package bolts;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.CancellationException;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;

public class Task<TResult>
{
  public static final ExecutorService BACKGROUND_EXECUTOR = BoltsExecutors.background();
  private static final Executor IMMEDIATE_EXECUTOR = BoltsExecutors.immediate();
  private static Task<?> TASK_CANCELLED;
  private static Task<Boolean> TASK_FALSE;
  private static Task<?> TASK_NULL;
  private static Task<Boolean> TASK_TRUE;
  public static final Executor UI_THREAD_EXECUTOR = AndroidExecutors.uiThread();
  private static volatile UnobservedExceptionHandler unobservedExceptionHandler;
  private boolean cancelled;
  private boolean complete;
  private List<Continuation<TResult, Void>> continuations = new ArrayList();
  private Exception error;
  private boolean errorHasBeenObserved;
  private final Object lock = new Object();
  private TResult result;
  private UnobservedErrorNotifier unobservedErrorNotifier;

  static
  {
    TASK_NULL = new Task(null);
    TASK_TRUE = new Task(Boolean.valueOf(true));
    TASK_FALSE = new Task(Boolean.valueOf(false));
    TASK_CANCELLED = new Task(true);
  }

  Task()
  {
  }

  private Task(TResult paramTResult)
  {
    trySetResult(paramTResult);
  }

  private Task(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      trySetCancelled();
      return;
    }
    trySetResult(null);
  }

  public static <TResult> Task<TResult> call(Callable<TResult> paramCallable)
  {
    return call(paramCallable, IMMEDIATE_EXECUTOR, null);
  }

  public static <TResult> Task<TResult> call(Callable<TResult> paramCallable, CancellationToken paramCancellationToken)
  {
    return call(paramCallable, IMMEDIATE_EXECUTOR, paramCancellationToken);
  }

  public static <TResult> Task<TResult> call(Callable<TResult> paramCallable, Executor paramExecutor)
  {
    return call(paramCallable, paramExecutor, null);
  }

  public static <TResult> Task<TResult> call(Callable<TResult> paramCallable, Executor paramExecutor, CancellationToken paramCancellationToken)
  {
    TaskCompletionSource localTaskCompletionSource = new TaskCompletionSource();
    try
    {
      paramExecutor.execute(new Runnable(paramCancellationToken, localTaskCompletionSource, paramCallable)
      {
        public void run()
        {
          if ((this.val$ct != null) && (this.val$ct.isCancellationRequested()))
          {
            this.val$tcs.setCancelled();
            return;
          }
          try
          {
            this.val$tcs.setResult(this.val$callable.call());
            return;
          }
          catch (CancellationException localCancellationException)
          {
            this.val$tcs.setCancelled();
            return;
          }
          catch (Exception localException)
          {
            this.val$tcs.setError(localException);
          }
        }
      });
      return localTaskCompletionSource.getTask();
    }
    catch (Exception paramCallable)
    {
      while (true)
        localTaskCompletionSource.setError(new ExecutorException(paramCallable));
    }
  }

  public static <TResult> Task<TResult> callInBackground(Callable<TResult> paramCallable)
  {
    return call(paramCallable, BACKGROUND_EXECUTOR, null);
  }

  public static <TResult> Task<TResult> callInBackground(Callable<TResult> paramCallable, CancellationToken paramCancellationToken)
  {
    return call(paramCallable, BACKGROUND_EXECUTOR, paramCancellationToken);
  }

  public static <TResult> Task<TResult> cancelled()
  {
    return TASK_CANCELLED;
  }

  private static <TContinuationResult, TResult> void completeAfterTask(TaskCompletionSource<TContinuationResult> paramTaskCompletionSource, Continuation<TResult, Task<TContinuationResult>> paramContinuation, Task<TResult> paramTask, Executor paramExecutor, CancellationToken paramCancellationToken)
  {
    try
    {
      paramExecutor.execute(new Runnable(paramCancellationToken, paramTaskCompletionSource, paramContinuation, paramTask)
      {
        public void run()
        {
          if ((this.val$ct != null) && (this.val$ct.isCancellationRequested()))
          {
            this.val$tcs.setCancelled();
            return;
          }
          try
          {
            Task localTask = (Task)this.val$continuation.then(this.val$task);
            if (localTask == null)
            {
              this.val$tcs.setResult(null);
              return;
            }
          }
          catch (CancellationException localCancellationException)
          {
            this.val$tcs.setCancelled();
            return;
            localCancellationException.continueWith(new Continuation()
            {
              public Void then(Task<TContinuationResult> paramTask)
              {
                if ((Task.15.this.val$ct != null) && (Task.15.this.val$ct.isCancellationRequested()))
                {
                  Task.15.this.val$tcs.setCancelled();
                  return null;
                }
                if (paramTask.isCancelled())
                {
                  Task.15.this.val$tcs.setCancelled();
                  return null;
                }
                if (paramTask.isFaulted())
                {
                  Task.15.this.val$tcs.setError(paramTask.getError());
                  return null;
                }
                Task.15.this.val$tcs.setResult(paramTask.getResult());
                return null;
              }
            });
            return;
          }
          catch (Exception localException)
          {
            this.val$tcs.setError(localException);
          }
        }
      });
      return;
    }
    catch (Exception paramContinuation)
    {
      paramTaskCompletionSource.setError(new ExecutorException(paramContinuation));
    }
  }

  private static <TContinuationResult, TResult> void completeImmediately(TaskCompletionSource<TContinuationResult> paramTaskCompletionSource, Continuation<TResult, TContinuationResult> paramContinuation, Task<TResult> paramTask, Executor paramExecutor, CancellationToken paramCancellationToken)
  {
    try
    {
      paramExecutor.execute(new Runnable(paramCancellationToken, paramTaskCompletionSource, paramContinuation, paramTask)
      {
        public void run()
        {
          if ((this.val$ct != null) && (this.val$ct.isCancellationRequested()))
          {
            this.val$tcs.setCancelled();
            return;
          }
          try
          {
            Object localObject = this.val$continuation.then(this.val$task);
            this.val$tcs.setResult(localObject);
            return;
          }
          catch (CancellationException localCancellationException)
          {
            this.val$tcs.setCancelled();
            return;
          }
          catch (Exception localException)
          {
            this.val$tcs.setError(localException);
          }
        }
      });
      return;
    }
    catch (Exception paramContinuation)
    {
      paramTaskCompletionSource.setError(new ExecutorException(paramContinuation));
    }
  }

  public static <TResult> Task<TResult>.TaskCompletionSource create()
  {
    Task localTask = new Task();
    localTask.getClass();
    return new TaskCompletionSource();
  }

  public static Task<Void> delay(long paramLong)
  {
    return delay(paramLong, BoltsExecutors.scheduled(), null);
  }

  public static Task<Void> delay(long paramLong, CancellationToken paramCancellationToken)
  {
    return delay(paramLong, BoltsExecutors.scheduled(), paramCancellationToken);
  }

  static Task<Void> delay(long paramLong, ScheduledExecutorService paramScheduledExecutorService, CancellationToken paramCancellationToken)
  {
    if ((paramCancellationToken != null) && (paramCancellationToken.isCancellationRequested()))
      return cancelled();
    if (paramLong <= 0L)
      return forResult(null);
    TaskCompletionSource localTaskCompletionSource = new TaskCompletionSource();
    paramScheduledExecutorService = paramScheduledExecutorService.schedule(new Runnable(localTaskCompletionSource)
    {
      public void run()
      {
        this.val$tcs.trySetResult(null);
      }
    }
    , paramLong, TimeUnit.MILLISECONDS);
    if (paramCancellationToken != null)
      paramCancellationToken.register(new Runnable(paramScheduledExecutorService, localTaskCompletionSource)
      {
        public void run()
        {
          this.val$scheduled.cancel(true);
          this.val$tcs.trySetCancelled();
        }
      });
    return localTaskCompletionSource.getTask();
  }

  public static <TResult> Task<TResult> forError(Exception paramException)
  {
    TaskCompletionSource localTaskCompletionSource = new TaskCompletionSource();
    localTaskCompletionSource.setError(paramException);
    return localTaskCompletionSource.getTask();
  }

  public static <TResult> Task<TResult> forResult(TResult paramTResult)
  {
    if (paramTResult == null)
      return TASK_NULL;
    if ((paramTResult instanceof Boolean))
    {
      if (((Boolean)paramTResult).booleanValue())
        return TASK_TRUE;
      return TASK_FALSE;
    }
    TaskCompletionSource localTaskCompletionSource = new TaskCompletionSource();
    localTaskCompletionSource.setResult(paramTResult);
    return localTaskCompletionSource.getTask();
  }

  public static UnobservedExceptionHandler getUnobservedExceptionHandler()
  {
    return unobservedExceptionHandler;
  }

  private void runContinuations()
  {
    while (true)
    {
      Continuation localContinuation;
      synchronized (this.lock)
      {
        Iterator localIterator = this.continuations.iterator();
        if (!localIterator.hasNext())
          break;
        localContinuation = (Continuation)localIterator.next();
      }
      try
      {
        localContinuation.then(this);
      }
      catch (RuntimeException localObject2)
      {
        throw localRuntimeException;
        localObject2 = finally;
        monitorexit;
        throw localObject2;
      }
      catch (Exception localException)
      {
        throw new RuntimeException(localException);
      }
    }
    this.continuations = null;
    monitorexit;
  }

  public static void setUnobservedExceptionHandler(UnobservedExceptionHandler paramUnobservedExceptionHandler)
  {
    unobservedExceptionHandler = paramUnobservedExceptionHandler;
  }

  public static Task<Void> whenAll(Collection<? extends Task<?>> paramCollection)
  {
    if (paramCollection.size() == 0)
      return forResult(null);
    TaskCompletionSource localTaskCompletionSource = new TaskCompletionSource();
    ArrayList localArrayList = new ArrayList();
    Object localObject = new Object();
    AtomicInteger localAtomicInteger = new AtomicInteger(paramCollection.size());
    AtomicBoolean localAtomicBoolean = new AtomicBoolean(false);
    paramCollection = paramCollection.iterator();
    while (paramCollection.hasNext())
      ((Task)paramCollection.next()).continueWith(new Continuation(localObject, localArrayList, localAtomicBoolean, localAtomicInteger, localTaskCompletionSource)
      {
        public Void then(Task<Object> paramTask)
        {
          if (paramTask.isFaulted());
          synchronized (this.val$errorLock)
          {
            this.val$causes.add(paramTask.getError());
            if (paramTask.isCancelled())
              this.val$isCancelled.set(true);
            if (this.val$count.decrementAndGet() == 0)
            {
              if (this.val$causes.size() == 0)
                break label143;
              if (this.val$causes.size() == 1)
                this.val$allFinished.setError((Exception)this.val$causes.get(0));
            }
            else
            {
              return null;
            }
          }
          paramTask = new AggregateException(String.format("There were %d exceptions.", new Object[] { Integer.valueOf(this.val$causes.size()) }), this.val$causes);
          this.val$allFinished.setError(paramTask);
          return null;
          label143: if (this.val$isCancelled.get())
          {
            this.val$allFinished.setCancelled();
            return null;
          }
          this.val$allFinished.setResult(null);
          return null;
        }
      });
    return localTaskCompletionSource.getTask();
  }

  public static <TResult> Task<List<TResult>> whenAllResult(Collection<? extends Task<TResult>> paramCollection)
  {
    return whenAll(paramCollection).onSuccess(new Continuation(paramCollection)
    {
      public List<TResult> then(Task<Void> paramTask)
        throws Exception
      {
        if (this.val$tasks.size() == 0)
        {
          paramTask = Collections.emptyList();
          return paramTask;
        }
        ArrayList localArrayList = new ArrayList();
        Iterator localIterator = this.val$tasks.iterator();
        while (true)
        {
          paramTask = localArrayList;
          if (!localIterator.hasNext())
            break;
          localArrayList.add(((Task)localIterator.next()).getResult());
        }
      }
    });
  }

  public static Task<Task<?>> whenAny(Collection<? extends Task<?>> paramCollection)
  {
    if (paramCollection.size() == 0)
      return forResult(null);
    TaskCompletionSource localTaskCompletionSource = new TaskCompletionSource();
    AtomicBoolean localAtomicBoolean = new AtomicBoolean(false);
    paramCollection = paramCollection.iterator();
    while (paramCollection.hasNext())
      ((Task)paramCollection.next()).continueWith(new Continuation(localAtomicBoolean, localTaskCompletionSource)
      {
        public Void then(Task<Object> paramTask)
        {
          if (this.val$isAnyTaskComplete.compareAndSet(false, true))
            this.val$firstCompleted.setResult(paramTask);
          while (true)
          {
            return null;
            paramTask.getError();
          }
        }
      });
    return localTaskCompletionSource.getTask();
  }

  public static <TResult> Task<Task<TResult>> whenAnyResult(Collection<? extends Task<TResult>> paramCollection)
  {
    if (paramCollection.size() == 0)
      return forResult(null);
    TaskCompletionSource localTaskCompletionSource = new TaskCompletionSource();
    AtomicBoolean localAtomicBoolean = new AtomicBoolean(false);
    paramCollection = paramCollection.iterator();
    while (paramCollection.hasNext())
      ((Task)paramCollection.next()).continueWith(new Continuation(localAtomicBoolean, localTaskCompletionSource)
      {
        public Void then(Task<TResult> paramTask)
        {
          if (this.val$isAnyTaskComplete.compareAndSet(false, true))
            this.val$firstCompleted.setResult(paramTask);
          while (true)
          {
            return null;
            paramTask.getError();
          }
        }
      });
    return localTaskCompletionSource.getTask();
  }

  public <TOut> Task<TOut> cast()
  {
    return this;
  }

  public Task<Void> continueWhile(Callable<Boolean> paramCallable, Continuation<Void, Task<Void>> paramContinuation)
  {
    return continueWhile(paramCallable, paramContinuation, IMMEDIATE_EXECUTOR, null);
  }

  public Task<Void> continueWhile(Callable<Boolean> paramCallable, Continuation<Void, Task<Void>> paramContinuation, CancellationToken paramCancellationToken)
  {
    return continueWhile(paramCallable, paramContinuation, IMMEDIATE_EXECUTOR, paramCancellationToken);
  }

  public Task<Void> continueWhile(Callable<Boolean> paramCallable, Continuation<Void, Task<Void>> paramContinuation, Executor paramExecutor)
  {
    return continueWhile(paramCallable, paramContinuation, paramExecutor, null);
  }

  public Task<Void> continueWhile(Callable<Boolean> paramCallable, Continuation<Void, Task<Void>> paramContinuation, Executor paramExecutor, CancellationToken paramCancellationToken)
  {
    Capture localCapture = new Capture();
    localCapture.set(new Continuation(paramCancellationToken, paramCallable, paramContinuation, paramExecutor, localCapture)
    {
      public Task<Void> then(Task<Void> paramTask)
        throws Exception
      {
        if ((this.val$ct != null) && (this.val$ct.isCancellationRequested()))
          return Task.cancelled();
        if (((Boolean)this.val$predicate.call()).booleanValue())
          return Task.forResult(null).onSuccessTask(this.val$continuation, this.val$executor).onSuccessTask((Continuation)this.val$predicateContinuation.get(), this.val$executor);
        return Task.forResult(null);
      }
    });
    return makeVoid().continueWithTask((Continuation)localCapture.get(), paramExecutor);
  }

  public <TContinuationResult> Task<TContinuationResult> continueWith(Continuation<TResult, TContinuationResult> paramContinuation)
  {
    return continueWith(paramContinuation, IMMEDIATE_EXECUTOR, null);
  }

  public <TContinuationResult> Task<TContinuationResult> continueWith(Continuation<TResult, TContinuationResult> paramContinuation, CancellationToken paramCancellationToken)
  {
    return continueWith(paramContinuation, IMMEDIATE_EXECUTOR, paramCancellationToken);
  }

  public <TContinuationResult> Task<TContinuationResult> continueWith(Continuation<TResult, TContinuationResult> paramContinuation, Executor paramExecutor)
  {
    return continueWith(paramContinuation, paramExecutor, null);
  }

  public <TContinuationResult> Task<TContinuationResult> continueWith(Continuation<TResult, TContinuationResult> paramContinuation, Executor paramExecutor, CancellationToken paramCancellationToken)
  {
    TaskCompletionSource localTaskCompletionSource = new TaskCompletionSource();
    synchronized (this.lock)
    {
      boolean bool = isCompleted();
      if (!bool)
        this.continuations.add(new Continuation(localTaskCompletionSource, paramContinuation, paramExecutor, paramCancellationToken)
        {
          public Void then(Task<TResult> paramTask)
          {
            Task.access$000(this.val$tcs, this.val$continuation, paramTask, this.val$executor, this.val$ct);
            return null;
          }
        });
      if (bool)
        completeImmediately(localTaskCompletionSource, paramContinuation, this, paramExecutor, paramCancellationToken);
      return localTaskCompletionSource.getTask();
    }
  }

  public <TContinuationResult> Task<TContinuationResult> continueWithTask(Continuation<TResult, Task<TContinuationResult>> paramContinuation)
  {
    return continueWithTask(paramContinuation, IMMEDIATE_EXECUTOR, null);
  }

  public <TContinuationResult> Task<TContinuationResult> continueWithTask(Continuation<TResult, Task<TContinuationResult>> paramContinuation, CancellationToken paramCancellationToken)
  {
    return continueWithTask(paramContinuation, IMMEDIATE_EXECUTOR, paramCancellationToken);
  }

  public <TContinuationResult> Task<TContinuationResult> continueWithTask(Continuation<TResult, Task<TContinuationResult>> paramContinuation, Executor paramExecutor)
  {
    return continueWithTask(paramContinuation, paramExecutor, null);
  }

  public <TContinuationResult> Task<TContinuationResult> continueWithTask(Continuation<TResult, Task<TContinuationResult>> paramContinuation, Executor paramExecutor, CancellationToken paramCancellationToken)
  {
    TaskCompletionSource localTaskCompletionSource = new TaskCompletionSource();
    synchronized (this.lock)
    {
      boolean bool = isCompleted();
      if (!bool)
        this.continuations.add(new Continuation(localTaskCompletionSource, paramContinuation, paramExecutor, paramCancellationToken)
        {
          public Void then(Task<TResult> paramTask)
          {
            Task.access$100(this.val$tcs, this.val$continuation, paramTask, this.val$executor, this.val$ct);
            return null;
          }
        });
      if (bool)
        completeAfterTask(localTaskCompletionSource, paramContinuation, this, paramExecutor, paramCancellationToken);
      return localTaskCompletionSource.getTask();
    }
  }

  public Exception getError()
  {
    synchronized (this.lock)
    {
      if (this.error != null)
      {
        this.errorHasBeenObserved = true;
        if (this.unobservedErrorNotifier != null)
        {
          this.unobservedErrorNotifier.setObserved();
          this.unobservedErrorNotifier = null;
        }
      }
      Exception localException = this.error;
      return localException;
    }
  }

  public TResult getResult()
  {
    synchronized (this.lock)
    {
      Object localObject2 = this.result;
      return localObject2;
    }
  }

  public boolean isCancelled()
  {
    synchronized (this.lock)
    {
      boolean bool = this.cancelled;
      return bool;
    }
  }

  public boolean isCompleted()
  {
    synchronized (this.lock)
    {
      boolean bool = this.complete;
      return bool;
    }
  }

  public boolean isFaulted()
  {
    while (true)
    {
      synchronized (this.lock)
      {
        if (getError() != null)
        {
          i = 1;
          return i;
        }
      }
      int i = 0;
    }
  }

  public Task<Void> makeVoid()
  {
    return continueWithTask(new Continuation()
    {
      public Task<Void> then(Task<TResult> paramTask)
        throws Exception
      {
        if (paramTask.isCancelled())
          return Task.cancelled();
        if (paramTask.isFaulted())
          return Task.forError(paramTask.getError());
        return Task.forResult(null);
      }
    });
  }

  public <TContinuationResult> Task<TContinuationResult> onSuccess(Continuation<TResult, TContinuationResult> paramContinuation)
  {
    return onSuccess(paramContinuation, IMMEDIATE_EXECUTOR, null);
  }

  public <TContinuationResult> Task<TContinuationResult> onSuccess(Continuation<TResult, TContinuationResult> paramContinuation, CancellationToken paramCancellationToken)
  {
    return onSuccess(paramContinuation, IMMEDIATE_EXECUTOR, paramCancellationToken);
  }

  public <TContinuationResult> Task<TContinuationResult> onSuccess(Continuation<TResult, TContinuationResult> paramContinuation, Executor paramExecutor)
  {
    return onSuccess(paramContinuation, paramExecutor, null);
  }

  public <TContinuationResult> Task<TContinuationResult> onSuccess(Continuation<TResult, TContinuationResult> paramContinuation, Executor paramExecutor, CancellationToken paramCancellationToken)
  {
    return continueWithTask(new Continuation(paramCancellationToken, paramContinuation)
    {
      public Task<TContinuationResult> then(Task<TResult> paramTask)
      {
        if ((this.val$ct != null) && (this.val$ct.isCancellationRequested()))
          return Task.cancelled();
        if (paramTask.isFaulted())
          return Task.forError(paramTask.getError());
        if (paramTask.isCancelled())
          return Task.cancelled();
        return paramTask.continueWith(this.val$continuation);
      }
    }
    , paramExecutor);
  }

  public <TContinuationResult> Task<TContinuationResult> onSuccessTask(Continuation<TResult, Task<TContinuationResult>> paramContinuation)
  {
    return onSuccessTask(paramContinuation, IMMEDIATE_EXECUTOR);
  }

  public <TContinuationResult> Task<TContinuationResult> onSuccessTask(Continuation<TResult, Task<TContinuationResult>> paramContinuation, CancellationToken paramCancellationToken)
  {
    return onSuccessTask(paramContinuation, IMMEDIATE_EXECUTOR, paramCancellationToken);
  }

  public <TContinuationResult> Task<TContinuationResult> onSuccessTask(Continuation<TResult, Task<TContinuationResult>> paramContinuation, Executor paramExecutor)
  {
    return onSuccessTask(paramContinuation, paramExecutor, null);
  }

  public <TContinuationResult> Task<TContinuationResult> onSuccessTask(Continuation<TResult, Task<TContinuationResult>> paramContinuation, Executor paramExecutor, CancellationToken paramCancellationToken)
  {
    return continueWithTask(new Continuation(paramCancellationToken, paramContinuation)
    {
      public Task<TContinuationResult> then(Task<TResult> paramTask)
      {
        if ((this.val$ct != null) && (this.val$ct.isCancellationRequested()))
          return Task.cancelled();
        if (paramTask.isFaulted())
          return Task.forError(paramTask.getError());
        if (paramTask.isCancelled())
          return Task.cancelled();
        return paramTask.continueWithTask(this.val$continuation);
      }
    }
    , paramExecutor);
  }

  boolean trySetCancelled()
  {
    synchronized (this.lock)
    {
      if (this.complete)
        return false;
      this.complete = true;
      this.cancelled = true;
      this.lock.notifyAll();
      runContinuations();
      return true;
    }
  }

  boolean trySetError(Exception paramException)
  {
    synchronized (this.lock)
    {
      if (this.complete)
        return false;
      this.complete = true;
      this.error = paramException;
      this.errorHasBeenObserved = false;
      this.lock.notifyAll();
      runContinuations();
      if ((!this.errorHasBeenObserved) && (getUnobservedExceptionHandler() != null))
        this.unobservedErrorNotifier = new UnobservedErrorNotifier(this);
      return true;
    }
  }

  boolean trySetResult(TResult paramTResult)
  {
    synchronized (this.lock)
    {
      if (this.complete)
        return false;
      this.complete = true;
      this.result = paramTResult;
      this.lock.notifyAll();
      runContinuations();
      return true;
    }
  }

  public void waitForCompletion()
    throws InterruptedException
  {
    synchronized (this.lock)
    {
      if (!isCompleted())
        this.lock.wait();
      return;
    }
  }

  public boolean waitForCompletion(long paramLong, TimeUnit paramTimeUnit)
    throws InterruptedException
  {
    synchronized (this.lock)
    {
      if (!isCompleted())
        this.lock.wait(paramTimeUnit.toMillis(paramLong));
      boolean bool = isCompleted();
      return bool;
    }
  }

  public class TaskCompletionSource extends TaskCompletionSource<TResult>
  {
    TaskCompletionSource()
    {
    }
  }

  public static abstract interface UnobservedExceptionHandler
  {
    public abstract void unobservedException(Task<?> paramTask, UnobservedTaskException paramUnobservedTaskException);
  }
}

/* Location:           C:\Users\c_jealom1\Documents\Scripts\Android\Fathom_com.brynk.fathom\Fathom_com.brynk.fathom-dex2jar.jar
 * Qualified Name:     bolts.Task
 * JD-Core Version:    0.6.0
 */
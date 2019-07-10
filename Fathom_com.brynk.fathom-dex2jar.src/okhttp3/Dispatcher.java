package okhttp3;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Deque;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import okhttp3.internal.Util;

public final class Dispatcher
{
  private ExecutorService executorService;
  private Runnable idleCallback;
  private int maxRequests = 64;
  private int maxRequestsPerHost = 5;
  private final Deque<RealCall.AsyncCall> readyAsyncCalls = new ArrayDeque();
  private final Deque<RealCall.AsyncCall> runningAsyncCalls = new ArrayDeque();
  private final Deque<RealCall> runningSyncCalls = new ArrayDeque();

  public Dispatcher()
  {
  }

  public Dispatcher(ExecutorService paramExecutorService)
  {
    this.executorService = paramExecutorService;
  }

  private <T> void finished(Deque<T> paramDeque, T paramT, boolean paramBoolean)
  {
    monitorenter;
    try
    {
      if (!paramDeque.remove(paramT))
        throw new AssertionError("Call wasn't in-flight!");
    }
    finally
    {
      monitorexit;
    }
    if (paramBoolean)
      promoteCalls();
    int i = runningCallsCount();
    paramDeque = this.idleCallback;
    monitorexit;
    if ((i == 0) && (paramDeque != null))
      paramDeque.run();
  }

  private void promoteCalls()
  {
    if (this.runningAsyncCalls.size() >= this.maxRequests);
    label16: 
    do
    {
      Iterator localIterator;
      do
      {
        return;
        break label16;
        continue;
        while (this.readyAsyncCalls.isEmpty());
        localIterator = this.readyAsyncCalls.iterator();
      }
      while (!localIterator.hasNext());
      RealCall.AsyncCall localAsyncCall = (RealCall.AsyncCall)localIterator.next();
      if (runningCallsForHost(localAsyncCall) >= this.maxRequestsPerHost)
        continue;
      localIterator.remove();
      this.runningAsyncCalls.add(localAsyncCall);
      executorService().execute(localAsyncCall);
    }
    while (this.runningAsyncCalls.size() < this.maxRequests);
  }

  private int runningCallsForHost(RealCall.AsyncCall paramAsyncCall)
  {
    int i = 0;
    Iterator localIterator = this.runningAsyncCalls.iterator();
    while (localIterator.hasNext())
    {
      if (!((RealCall.AsyncCall)localIterator.next()).host().equals(paramAsyncCall.host()))
        continue;
      i += 1;
    }
    return i;
  }

  public void cancelAll()
  {
    monitorenter;
    try
    {
      Iterator localIterator1 = this.readyAsyncCalls.iterator();
      while (localIterator1.hasNext())
        ((RealCall.AsyncCall)localIterator1.next()).get().cancel();
    }
    finally
    {
      monitorexit;
    }
    Iterator localIterator2 = this.runningAsyncCalls.iterator();
    while (localIterator2.hasNext())
      ((RealCall.AsyncCall)localIterator2.next()).get().cancel();
    localIterator2 = this.runningSyncCalls.iterator();
    while (localIterator2.hasNext())
      ((RealCall)localIterator2.next()).cancel();
    monitorexit;
  }

  void enqueue(RealCall.AsyncCall paramAsyncCall)
  {
    monitorenter;
    try
    {
      if ((this.runningAsyncCalls.size() < this.maxRequests) && (runningCallsForHost(paramAsyncCall) < this.maxRequestsPerHost))
      {
        this.runningAsyncCalls.add(paramAsyncCall);
        executorService().execute(paramAsyncCall);
      }
      while (true)
      {
        return;
        this.readyAsyncCalls.add(paramAsyncCall);
      }
    }
    finally
    {
      monitorexit;
    }
    throw paramAsyncCall;
  }

  void executed(RealCall paramRealCall)
  {
    monitorenter;
    try
    {
      this.runningSyncCalls.add(paramRealCall);
      monitorexit;
      return;
    }
    finally
    {
      paramRealCall = finally;
      monitorexit;
    }
    throw paramRealCall;
  }

  public ExecutorService executorService()
  {
    monitorenter;
    try
    {
      if (this.executorService == null)
        this.executorService = new ThreadPoolExecutor(0, 2147483647, 60L, TimeUnit.SECONDS, new SynchronousQueue(), Util.threadFactory("OkHttp Dispatcher", false));
      ExecutorService localExecutorService = this.executorService;
      return localExecutorService;
    }
    finally
    {
      monitorexit;
    }
    throw localObject;
  }

  void finished(RealCall.AsyncCall paramAsyncCall)
  {
    finished(this.runningAsyncCalls, paramAsyncCall, true);
  }

  void finished(RealCall paramRealCall)
  {
    finished(this.runningSyncCalls, paramRealCall, false);
  }

  public int getMaxRequests()
  {
    monitorenter;
    try
    {
      int i = this.maxRequests;
      monitorexit;
      return i;
    }
    finally
    {
      localObject = finally;
      monitorexit;
    }
    throw localObject;
  }

  public int getMaxRequestsPerHost()
  {
    monitorenter;
    try
    {
      int i = this.maxRequestsPerHost;
      monitorexit;
      return i;
    }
    finally
    {
      localObject = finally;
      monitorexit;
    }
    throw localObject;
  }

  public List<Call> queuedCalls()
  {
    monitorenter;
    try
    {
      ArrayList localArrayList = new ArrayList();
      Iterator localIterator = this.readyAsyncCalls.iterator();
      while (localIterator.hasNext())
        localArrayList.add(((RealCall.AsyncCall)localIterator.next()).get());
    }
    finally
    {
      monitorexit;
    }
    List localList2 = Collections.unmodifiableList(localList1);
    monitorexit;
    return localList2;
  }

  public int queuedCallsCount()
  {
    monitorenter;
    try
    {
      int i = this.readyAsyncCalls.size();
      monitorexit;
      return i;
    }
    finally
    {
      localObject = finally;
      monitorexit;
    }
    throw localObject;
  }

  public List<Call> runningCalls()
  {
    monitorenter;
    try
    {
      ArrayList localArrayList = new ArrayList();
      localArrayList.addAll(this.runningSyncCalls);
      Iterator localIterator = this.runningAsyncCalls.iterator();
      while (localIterator.hasNext())
        localArrayList.add(((RealCall.AsyncCall)localIterator.next()).get());
    }
    finally
    {
      monitorexit;
    }
    List localList2 = Collections.unmodifiableList(localList1);
    monitorexit;
    return localList2;
  }

  public int runningCallsCount()
  {
    monitorenter;
    try
    {
      int i = this.runningAsyncCalls.size();
      int j = this.runningSyncCalls.size();
      monitorexit;
      return i + j;
    }
    finally
    {
      localObject = finally;
      monitorexit;
    }
    throw localObject;
  }

  public void setIdleCallback(Runnable paramRunnable)
  {
    monitorenter;
    try
    {
      this.idleCallback = paramRunnable;
      monitorexit;
      return;
    }
    finally
    {
      paramRunnable = finally;
      monitorexit;
    }
    throw paramRunnable;
  }

  public void setMaxRequests(int paramInt)
  {
    monitorenter;
    if (paramInt < 1)
      try
      {
        throw new IllegalArgumentException("max < 1: " + paramInt);
      }
      finally
      {
        monitorexit;
      }
    this.maxRequests = paramInt;
    promoteCalls();
    monitorexit;
  }

  public void setMaxRequestsPerHost(int paramInt)
  {
    monitorenter;
    if (paramInt < 1)
      try
      {
        throw new IllegalArgumentException("max < 1: " + paramInt);
      }
      finally
      {
        monitorexit;
      }
    this.maxRequestsPerHost = paramInt;
    promoteCalls();
    monitorexit;
  }
}

/* Location:           C:\Users\c_jealom1\Documents\Scripts\Android\Fathom_com.brynk.fathom\Fathom_com.brynk.fathom-dex2jar.jar
 * Qualified Name:     okhttp3.Dispatcher
 * JD-Core Version:    0.6.0
 */
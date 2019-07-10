package com.facebook.common.references;

import com.facebook.common.internal.Closeables;
import com.facebook.common.internal.Preconditions;
import com.facebook.common.internal.VisibleForTesting;
import com.facebook.common.logging.FLog;
import java.io.Closeable;
import java.lang.ref.PhantomReference;
import java.lang.ref.ReferenceQueue;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import javax.annotation.Nullable;
import javax.annotation.concurrent.GuardedBy;

public abstract class CloseableReference<T>
  implements Cloneable, Closeable
{
  private static final ResourceReleaser<Closeable> DEFAULT_CLOSEABLE_RELEASER;
  private static Class<CloseableReference> TAG = CloseableReference.class;
  private static volatile boolean sUseFinalizers;

  static
  {
    DEFAULT_CLOSEABLE_RELEASER = new ResourceReleaser()
    {
      public void release(Closeable paramCloseable)
      {
        try
        {
          Closeables.close(paramCloseable, true);
          return;
        }
        catch (java.io.IOException paramCloseable)
        {
        }
      }
    };
    sUseFinalizers = true;
  }

  @Nullable
  public static <T> CloseableReference<T> cloneOrNull(@Nullable CloseableReference<T> paramCloseableReference)
  {
    if (paramCloseableReference != null)
      return paramCloseableReference.cloneOrNull();
    return null;
  }

  public static <T> List<CloseableReference<T>> cloneOrNull(Collection<CloseableReference<T>> paramCollection)
  {
    if (paramCollection == null)
    {
      paramCollection = null;
      return paramCollection;
    }
    ArrayList localArrayList = new ArrayList(paramCollection.size());
    Iterator localIterator = paramCollection.iterator();
    while (true)
    {
      paramCollection = localArrayList;
      if (!localIterator.hasNext())
        break;
      localArrayList.add(cloneOrNull((CloseableReference)localIterator.next()));
    }
  }

  public static void closeSafely(@Nullable CloseableReference<?> paramCloseableReference)
  {
    if (paramCloseableReference != null)
      paramCloseableReference.close();
  }

  public static void closeSafely(@Nullable Iterable<? extends CloseableReference<?>> paramIterable)
  {
    if (paramIterable != null)
    {
      paramIterable = paramIterable.iterator();
      while (paramIterable.hasNext())
        closeSafely((CloseableReference)paramIterable.next());
    }
  }

  public static boolean isValid(@Nullable CloseableReference<?> paramCloseableReference)
  {
    return (paramCloseableReference != null) && (paramCloseableReference.isValid());
  }

  private static <T> CloseableReference<T> makeCloseableReference(@Nullable T paramT, ResourceReleaser<T> paramResourceReleaser)
  {
    if (sUseFinalizers)
      return new CloseableReferenceWithFinalizer(paramT, paramResourceReleaser, null);
    return new CloseableReferenceWithoutFinalizer(paramT, paramResourceReleaser, null);
  }

  @Nullable
  public static <T extends Closeable> CloseableReference<T> of(@Nullable T paramT)
  {
    if (paramT == null)
      return null;
    return makeCloseableReference(paramT, DEFAULT_CLOSEABLE_RELEASER);
  }

  @Nullable
  public static <T> CloseableReference<T> of(@Nullable T paramT, ResourceReleaser<T> paramResourceReleaser)
  {
    if (paramT == null)
      return null;
    return makeCloseableReference(paramT, paramResourceReleaser);
  }

  public static void setUseFinalizers(boolean paramBoolean)
  {
    sUseFinalizers = paramBoolean;
  }

  public abstract CloseableReference<T> clone();

  public abstract CloseableReference<T> cloneOrNull();

  public abstract void close();

  public abstract T get();

  @VisibleForTesting
  public abstract SharedReference<T> getUnderlyingReferenceTestOnly();

  public abstract int getValueHash();

  public abstract boolean isValid();

  private static class CloseableReferenceWithFinalizer<T> extends CloseableReference<T>
  {

    @GuardedBy("this")
    private boolean mIsClosed = false;
    private final SharedReference<T> mSharedReference;

    private CloseableReferenceWithFinalizer(SharedReference<T> paramSharedReference)
    {
      this.mSharedReference = ((SharedReference)Preconditions.checkNotNull(paramSharedReference));
      paramSharedReference.addReference();
    }

    private CloseableReferenceWithFinalizer(T paramT, ResourceReleaser<T> paramResourceReleaser)
    {
      this.mSharedReference = new SharedReference(paramT, paramResourceReleaser);
    }

    public CloseableReference<T> clone()
    {
      monitorenter;
      try
      {
        Preconditions.checkState(isValid());
        CloseableReferenceWithFinalizer localCloseableReferenceWithFinalizer = new CloseableReferenceWithFinalizer(this.mSharedReference);
        monitorexit;
        return localCloseableReferenceWithFinalizer;
      }
      finally
      {
        localObject = finally;
        monitorexit;
      }
      throw localObject;
    }

    public CloseableReference<T> cloneOrNull()
    {
      monitorenter;
      try
      {
        if (isValid())
        {
          localCloseableReference = clone();
          return localCloseableReference;
        }
        CloseableReference localCloseableReference = null;
      }
      finally
      {
        monitorexit;
      }
    }

    public void close()
    {
      monitorenter;
      try
      {
        if (this.mIsClosed)
          return;
        this.mIsClosed = true;
        monitorexit;
        this.mSharedReference.deleteReference();
        return;
      }
      finally
      {
        monitorexit;
      }
      throw localObject;
    }

    protected void finalize()
      throws Throwable
    {
      try
      {
        monitorenter;
        try
        {
          if (this.mIsClosed)
          {
            monitorexit;
            super.finalize();
            return;
          }
          monitorexit;
          FLog.w(CloseableReference.TAG, "Finalized without closing: %x %x (type = %s)", new Object[] { Integer.valueOf(System.identityHashCode(this)), Integer.valueOf(System.identityHashCode(this.mSharedReference)), this.mSharedReference.get().getClass().getSimpleName() });
          close();
          super.finalize();
          return;
        }
        finally
        {
          monitorexit;
        }
      }
      finally
      {
        super.finalize();
      }
      throw localObject2;
    }

    public T get()
    {
      monitorenter;
      try
      {
        if (!this.mIsClosed);
        for (boolean bool = true; ; bool = false)
        {
          Preconditions.checkState(bool);
          Object localObject1 = this.mSharedReference.get();
          return localObject1;
        }
      }
      finally
      {
        monitorexit;
      }
      throw localObject2;
    }

    public SharedReference<T> getUnderlyingReferenceTestOnly()
    {
      monitorenter;
      try
      {
        SharedReference localSharedReference = this.mSharedReference;
        monitorexit;
        return localSharedReference;
      }
      finally
      {
        localObject = finally;
        monitorexit;
      }
      throw localObject;
    }

    public int getValueHash()
    {
      if (isValid())
        return System.identityHashCode(this.mSharedReference.get());
      return 0;
    }

    public boolean isValid()
    {
      monitorenter;
      try
      {
        boolean bool = this.mIsClosed;
        if (!bool)
        {
          bool = true;
          return bool;
        }
        bool = false;
      }
      finally
      {
        monitorexit;
      }
    }
  }

  private static class CloseableReferenceWithoutFinalizer<T> extends CloseableReference<T>
  {
    private static final ReferenceQueue<CloseableReference> REF_QUEUE = new ReferenceQueue();
    private final Destructor mDestructor;
    private final SharedReference<T> mSharedReference;

    static
    {
      new Thread(new Runnable()
      {
        public void run()
        {
          while (true)
            try
            {
              ((CloseableReference.CloseableReferenceWithoutFinalizer.Destructor)CloseableReference.CloseableReferenceWithoutFinalizer.REF_QUEUE.remove()).destroy(false);
              continue;
            }
            catch (InterruptedException localInterruptedException)
            {
            }
        }
      }
      , "CloseableReferenceDestructorThread").start();
    }

    private CloseableReferenceWithoutFinalizer(SharedReference<T> paramSharedReference)
    {
      this.mSharedReference = ((SharedReference)Preconditions.checkNotNull(paramSharedReference));
      paramSharedReference.addReference();
      this.mDestructor = new Destructor(this, REF_QUEUE);
    }

    private CloseableReferenceWithoutFinalizer(T paramT, ResourceReleaser<T> paramResourceReleaser)
    {
      this.mSharedReference = new SharedReference(paramT, paramResourceReleaser);
      this.mDestructor = new Destructor(this, REF_QUEUE);
    }

    public CloseableReference<T> clone()
    {
      while (true)
      {
        synchronized (this.mDestructor)
        {
          if (!this.mDestructor.isDestroyed())
          {
            bool = true;
            Preconditions.checkState(bool);
            CloseableReferenceWithoutFinalizer localCloseableReferenceWithoutFinalizer = new CloseableReferenceWithoutFinalizer(this.mSharedReference);
            return localCloseableReferenceWithoutFinalizer;
          }
        }
        boolean bool = false;
      }
    }

    public CloseableReference<T> cloneOrNull()
    {
      synchronized (this.mDestructor)
      {
        if (!this.mDestructor.isDestroyed())
        {
          CloseableReferenceWithoutFinalizer localCloseableReferenceWithoutFinalizer = new CloseableReferenceWithoutFinalizer(this.mSharedReference);
          return localCloseableReferenceWithoutFinalizer;
        }
        return null;
      }
    }

    public void close()
    {
      this.mDestructor.destroy(true);
    }

    public T get()
    {
      while (true)
      {
        synchronized (this.mDestructor)
        {
          if (!this.mDestructor.isDestroyed())
          {
            bool = true;
            Preconditions.checkState(bool);
            Object localObject1 = this.mSharedReference.get();
            return localObject1;
          }
        }
        boolean bool = false;
      }
    }

    public SharedReference<T> getUnderlyingReferenceTestOnly()
    {
      return this.mSharedReference;
    }

    public int getValueHash()
    {
      while (true)
      {
        synchronized (this.mDestructor)
        {
          if (isValid())
          {
            i = System.identityHashCode(this.mSharedReference.get());
            return i;
          }
        }
        int i = 0;
      }
    }

    public boolean isValid()
    {
      return !this.mDestructor.isDestroyed();
    }

    private static class Destructor extends PhantomReference<CloseableReference>
    {

      @GuardedBy("Destructor.class")
      private static Destructor sHead;

      @GuardedBy("this")
      private boolean destroyed;
      private final SharedReference mSharedReference;

      @GuardedBy("Destructor.class")
      private Destructor next;

      @GuardedBy("Destructor.class")
      private Destructor previous;

      public Destructor(CloseableReference.CloseableReferenceWithoutFinalizer paramCloseableReferenceWithoutFinalizer, ReferenceQueue<? super CloseableReference> paramReferenceQueue)
      {
        super(paramReferenceQueue);
        this.mSharedReference = paramCloseableReferenceWithoutFinalizer.mSharedReference;
        monitorenter;
        try
        {
          if (sHead != null)
          {
            sHead.next = this;
            this.previous = sHead;
          }
          sHead = this;
          return;
        }
        finally
        {
          monitorexit;
        }
        throw paramCloseableReferenceWithoutFinalizer;
      }

      // ERROR //
      public void destroy(boolean paramBoolean)
      {
        // Byte code:
        //   0: aload_0
        //   1: monitorenter
        //   2: aload_0
        //   3: getfield 47	com/facebook/common/references/CloseableReference$CloseableReferenceWithoutFinalizer$Destructor:destroyed	Z
        //   6: ifeq +6 -> 12
        //   9: aload_0
        //   10: monitorexit
        //   11: return
        //   12: aload_0
        //   13: iconst_1
        //   14: putfield 47	com/facebook/common/references/CloseableReference$CloseableReferenceWithoutFinalizer$Destructor:destroyed	Z
        //   17: aload_0
        //   18: monitorexit
        //   19: ldc 2
        //   21: monitorenter
        //   22: aload_0
        //   23: getfield 40	com/facebook/common/references/CloseableReference$CloseableReferenceWithoutFinalizer$Destructor:previous	Lcom/facebook/common/references/CloseableReference$CloseableReferenceWithoutFinalizer$Destructor;
        //   26: ifnull +14 -> 40
        //   29: aload_0
        //   30: getfield 40	com/facebook/common/references/CloseableReference$CloseableReferenceWithoutFinalizer$Destructor:previous	Lcom/facebook/common/references/CloseableReference$CloseableReferenceWithoutFinalizer$Destructor;
        //   33: aload_0
        //   34: getfield 38	com/facebook/common/references/CloseableReference$CloseableReferenceWithoutFinalizer$Destructor:next	Lcom/facebook/common/references/CloseableReference$CloseableReferenceWithoutFinalizer$Destructor;
        //   37: putfield 38	com/facebook/common/references/CloseableReference$CloseableReferenceWithoutFinalizer$Destructor:next	Lcom/facebook/common/references/CloseableReference$CloseableReferenceWithoutFinalizer$Destructor;
        //   40: aload_0
        //   41: getfield 38	com/facebook/common/references/CloseableReference$CloseableReferenceWithoutFinalizer$Destructor:next	Lcom/facebook/common/references/CloseableReference$CloseableReferenceWithoutFinalizer$Destructor;
        //   44: ifnull +85 -> 129
        //   47: aload_0
        //   48: getfield 38	com/facebook/common/references/CloseableReference$CloseableReferenceWithoutFinalizer$Destructor:next	Lcom/facebook/common/references/CloseableReference$CloseableReferenceWithoutFinalizer$Destructor;
        //   51: aload_0
        //   52: getfield 40	com/facebook/common/references/CloseableReference$CloseableReferenceWithoutFinalizer$Destructor:previous	Lcom/facebook/common/references/CloseableReference$CloseableReferenceWithoutFinalizer$Destructor;
        //   55: putfield 40	com/facebook/common/references/CloseableReference$CloseableReferenceWithoutFinalizer$Destructor:previous	Lcom/facebook/common/references/CloseableReference$CloseableReferenceWithoutFinalizer$Destructor;
        //   58: ldc 2
        //   60: monitorexit
        //   61: iload_1
        //   62: ifne +54 -> 116
        //   65: invokestatic 51	com/facebook/common/references/CloseableReference:access$300	()Ljava/lang/Class;
        //   68: ldc 53
        //   70: iconst_3
        //   71: anewarray 55	java/lang/Object
        //   74: dup
        //   75: iconst_0
        //   76: aload_0
        //   77: invokestatic 61	java/lang/System:identityHashCode	(Ljava/lang/Object;)I
        //   80: invokestatic 67	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
        //   83: aastore
        //   84: dup
        //   85: iconst_1
        //   86: aload_0
        //   87: getfield 34	com/facebook/common/references/CloseableReference$CloseableReferenceWithoutFinalizer$Destructor:mSharedReference	Lcom/facebook/common/references/SharedReference;
        //   90: invokestatic 61	java/lang/System:identityHashCode	(Ljava/lang/Object;)I
        //   93: invokestatic 67	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
        //   96: aastore
        //   97: dup
        //   98: iconst_2
        //   99: aload_0
        //   100: getfield 34	com/facebook/common/references/CloseableReference$CloseableReferenceWithoutFinalizer$Destructor:mSharedReference	Lcom/facebook/common/references/SharedReference;
        //   103: invokevirtual 73	com/facebook/common/references/SharedReference:get	()Ljava/lang/Object;
        //   106: invokevirtual 76	java/lang/Object:getClass	()Ljava/lang/Class;
        //   109: invokevirtual 82	java/lang/Class:getSimpleName	()Ljava/lang/String;
        //   112: aastore
        //   113: invokestatic 88	com/facebook/common/logging/FLog:w	(Ljava/lang/Class;Ljava/lang/String;[Ljava/lang/Object;)V
        //   116: aload_0
        //   117: getfield 34	com/facebook/common/references/CloseableReference$CloseableReferenceWithoutFinalizer$Destructor:mSharedReference	Lcom/facebook/common/references/SharedReference;
        //   120: invokevirtual 92	com/facebook/common/references/SharedReference:deleteReference	()V
        //   123: return
        //   124: astore_2
        //   125: aload_0
        //   126: monitorexit
        //   127: aload_2
        //   128: athrow
        //   129: aload_0
        //   130: getfield 40	com/facebook/common/references/CloseableReference$CloseableReferenceWithoutFinalizer$Destructor:previous	Lcom/facebook/common/references/CloseableReference$CloseableReferenceWithoutFinalizer$Destructor;
        //   133: putstatic 36	com/facebook/common/references/CloseableReference$CloseableReferenceWithoutFinalizer$Destructor:sHead	Lcom/facebook/common/references/CloseableReference$CloseableReferenceWithoutFinalizer$Destructor;
        //   136: goto -78 -> 58
        //   139: astore_2
        //   140: ldc 2
        //   142: monitorexit
        //   143: aload_2
        //   144: athrow
        //
        // Exception table:
        //   from	to	target	type
        //   2	11	124	finally
        //   12	19	124	finally
        //   125	127	124	finally
        //   22	40	139	finally
        //   40	58	139	finally
        //   58	61	139	finally
        //   129	136	139	finally
        //   140	143	139	finally
      }

      public boolean isDestroyed()
      {
        monitorenter;
        try
        {
          boolean bool = this.destroyed;
          monitorexit;
          return bool;
        }
        finally
        {
          localObject = finally;
          monitorexit;
        }
        throw localObject;
      }
    }
  }
}

/* Location:           C:\Users\c_jealom1\Documents\Scripts\Android\Fathom_com.brynk.fathom\Fathom_com.brynk.fathom-dex2jar.jar
 * Qualified Name:     com.facebook.common.references.CloseableReference
 * JD-Core Version:    0.6.0
 */
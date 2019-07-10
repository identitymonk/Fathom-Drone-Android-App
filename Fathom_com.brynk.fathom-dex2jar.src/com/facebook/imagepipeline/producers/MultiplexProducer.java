package com.facebook.imagepipeline.producers;

import android.util.Pair;
import com.facebook.common.internal.Preconditions;
import com.facebook.common.internal.Sets;
import com.facebook.common.internal.VisibleForTesting;
import com.facebook.imagepipeline.common.Priority;
import java.io.Closeable;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArraySet;
import javax.annotation.Nullable;
import javax.annotation.concurrent.GuardedBy;
import javax.annotation.concurrent.ThreadSafe;

@ThreadSafe
public abstract class MultiplexProducer<K, T extends Closeable>
  implements Producer<T>
{
  private final Producer<T> mInputProducer;

  @VisibleForTesting
  @GuardedBy("this")
  final Map<K, MultiplexProducer<K, T>.Multiplexer> mMultiplexers;

  protected MultiplexProducer(Producer<T> paramProducer)
  {
    this.mInputProducer = paramProducer;
    this.mMultiplexers = new HashMap();
  }

  private MultiplexProducer<K, T>.Multiplexer createAndPutNewMultiplexer(K paramK)
  {
    monitorenter;
    try
    {
      Multiplexer localMultiplexer = new Multiplexer(paramK);
      this.mMultiplexers.put(paramK, localMultiplexer);
      monitorexit;
      return localMultiplexer;
    }
    finally
    {
      paramK = finally;
      monitorexit;
    }
    throw paramK;
  }

  private MultiplexProducer<K, T>.Multiplexer getExistingMultiplexer(K paramK)
  {
    monitorenter;
    try
    {
      paramK = (Multiplexer)this.mMultiplexers.get(paramK);
      monitorexit;
      return paramK;
    }
    finally
    {
      paramK = finally;
      monitorexit;
    }
    throw paramK;
  }

  private void removeMultiplexer(K paramK, MultiplexProducer<K, T>.Multiplexer paramMultiplexProducer)
  {
    monitorenter;
    try
    {
      if (this.mMultiplexers.get(paramK) == paramMultiplexProducer)
        this.mMultiplexers.remove(paramK);
      monitorexit;
      return;
    }
    finally
    {
      paramK = finally;
      monitorexit;
    }
    throw paramK;
  }

  protected abstract T cloneOrNull(T paramT);

  protected abstract K getKey(ProducerContext paramProducerContext);

  public void produceResults(Consumer<T> paramConsumer, ProducerContext paramProducerContext)
  {
    Object localObject = getKey(paramProducerContext);
    while (true)
    {
      int i = 0;
      monitorenter;
      try
      {
        Multiplexer localMultiplexer2 = getExistingMultiplexer(localObject);
        Multiplexer localMultiplexer1 = localMultiplexer2;
        if (localMultiplexer2 == null)
        {
          localMultiplexer1 = createAndPutNewMultiplexer(localObject);
          i = 1;
        }
        monitorexit;
        if (!localMultiplexer1.addNewConsumer(paramConsumer, paramProducerContext))
          continue;
        if (i != 0)
          localMultiplexer1.startInputProducerIfHasAttachedConsumers();
        return;
      }
      finally
      {
        monitorexit;
      }
    }
    throw paramConsumer;
  }

  @VisibleForTesting
  class Multiplexer
  {
    private final CopyOnWriteArraySet<Pair<Consumer<T>, ProducerContext>> mConsumerContextPairs = Sets.newCopyOnWriteArraySet();

    @Nullable
    @GuardedBy("Multiplexer.this")
    private MultiplexProducer<K, T>.Multiplexer.ForwardingConsumer mForwardingConsumer;
    private final K mKey;

    @Nullable
    @GuardedBy("Multiplexer.this")
    private T mLastIntermediateResult;

    @GuardedBy("Multiplexer.this")
    private float mLastProgress;

    @Nullable
    @GuardedBy("Multiplexer.this")
    private BaseProducerContext mMultiplexProducerContext;

    public Multiplexer()
    {
      Object localObject;
      this.mKey = localObject;
    }

    private void addCallbacks(Pair<Consumer<T>, ProducerContext> paramPair, ProducerContext paramProducerContext)
    {
      paramProducerContext.addCallbacks(new BaseProducerContextCallbacks(paramPair)
      {
        public void onCancellationRequested()
        {
          Object localObject6 = null;
          Object localObject7 = null;
          Object localObject8 = null;
          Object localObject9 = null;
          synchronized (MultiplexProducer.Multiplexer.this)
          {
            boolean bool = MultiplexProducer.Multiplexer.this.mConsumerContextPairs.remove(this.val$consumerContextPair);
            Object localObject1 = localObject6;
            Object localObject3 = localObject9;
            Object localObject4 = localObject7;
            Object localObject5 = localObject8;
            if (bool)
            {
              if (MultiplexProducer.Multiplexer.this.mConsumerContextPairs.isEmpty())
              {
                localObject1 = MultiplexProducer.Multiplexer.this.mMultiplexProducerContext;
                localObject5 = localObject8;
                localObject4 = localObject7;
                localObject3 = localObject9;
              }
            }
            else
            {
              BaseProducerContext.callOnIsPrefetchChanged((List)localObject4);
              BaseProducerContext.callOnPriorityChanged((List)localObject5);
              BaseProducerContext.callOnIsIntermediateResultExpectedChanged((List)localObject3);
              if (localObject1 != null)
                ((BaseProducerContext)localObject1).cancel();
              if (bool)
                ((Consumer)this.val$consumerContextPair.first).onCancellation();
              return;
            }
            localObject4 = MultiplexProducer.Multiplexer.this.updateIsPrefetch();
            localObject5 = MultiplexProducer.Multiplexer.this.updatePriority();
            localObject3 = MultiplexProducer.Multiplexer.this.updateIsIntermediateResultExpected();
            localObject1 = localObject6;
          }
        }

        public void onIsIntermediateResultExpectedChanged()
        {
          BaseProducerContext.callOnIsIntermediateResultExpectedChanged(MultiplexProducer.Multiplexer.this.updateIsIntermediateResultExpected());
        }

        public void onIsPrefetchChanged()
        {
          BaseProducerContext.callOnIsPrefetchChanged(MultiplexProducer.Multiplexer.this.updateIsPrefetch());
        }

        public void onPriorityChanged()
        {
          BaseProducerContext.callOnPriorityChanged(MultiplexProducer.Multiplexer.this.updatePriority());
        }
      });
    }

    private void closeSafely(Closeable paramCloseable)
    {
      if (paramCloseable != null);
      try
      {
        paramCloseable.close();
        return;
      }
      catch (java.io.IOException paramCloseable)
      {
      }
      throw new RuntimeException(paramCloseable);
    }

    private boolean computeIsIntermediateResultExpected()
    {
      monitorenter;
      try
      {
        Iterator localIterator = this.mConsumerContextPairs.iterator();
        do
        {
          if (!localIterator.hasNext())
            break;
          bool = ((ProducerContext)((Pair)localIterator.next()).second).isIntermediateResultExpected();
        }
        while (!bool);
        for (boolean bool = true; ; bool = false)
          return bool;
      }
      finally
      {
        monitorexit;
      }
      throw localObject;
    }

    private boolean computeIsPrefetch()
    {
      monitorenter;
      try
      {
        Iterator localIterator = this.mConsumerContextPairs.iterator();
        do
        {
          if (!localIterator.hasNext())
            break;
          bool = ((ProducerContext)((Pair)localIterator.next()).second).isPrefetch();
        }
        while (bool);
        for (boolean bool = false; ; bool = true)
          return bool;
      }
      finally
      {
        monitorexit;
      }
      throw localObject;
    }

    private Priority computePriority()
    {
      monitorenter;
      try
      {
        Priority localPriority = Priority.LOW;
        Iterator localIterator = this.mConsumerContextPairs.iterator();
        while (localIterator.hasNext())
          localPriority = Priority.getHigherPriority(localPriority, ((ProducerContext)((Pair)localIterator.next()).second).getPriority());
        return localPriority;
      }
      finally
      {
        monitorexit;
      }
      throw localObject;
    }

    private void startInputProducerIfHasAttachedConsumers()
    {
      boolean bool2 = true;
      monitorenter;
      while (true)
      {
        try
        {
          if (this.mMultiplexProducerContext == null)
          {
            bool1 = true;
            Preconditions.checkArgument(bool1);
            if (this.mForwardingConsumer != null)
              break label182;
            bool1 = bool2;
            Preconditions.checkArgument(bool1);
            if (!this.mConsumerContextPairs.isEmpty())
              continue;
            MultiplexProducer.this.removeMultiplexer(this.mKey, this);
            return;
            Object localObject1 = (ProducerContext)((Pair)this.mConsumerContextPairs.iterator().next()).second;
            this.mMultiplexProducerContext = new BaseProducerContext(((ProducerContext)localObject1).getImageRequest(), ((ProducerContext)localObject1).getId(), ((ProducerContext)localObject1).getListener(), ((ProducerContext)localObject1).getCallerContext(), ((ProducerContext)localObject1).getLowestPermittedRequestLevel(), computeIsPrefetch(), computeIsIntermediateResultExpected(), computePriority());
            this.mForwardingConsumer = new ForwardingConsumer(null);
            localObject1 = this.mMultiplexProducerContext;
            ForwardingConsumer localForwardingConsumer = this.mForwardingConsumer;
            monitorexit;
            MultiplexProducer.this.mInputProducer.produceResults(localForwardingConsumer, (ProducerContext)localObject1);
            return;
          }
        }
        finally
        {
          monitorexit;
        }
        boolean bool1 = false;
        continue;
        label182: bool1 = false;
      }
    }

    @Nullable
    private List<ProducerContextCallbacks> updateIsIntermediateResultExpected()
    {
      monitorenter;
      try
      {
        Object localObject1 = this.mMultiplexProducerContext;
        if (localObject1 == null);
        for (localObject1 = null; ; localObject1 = this.mMultiplexProducerContext.setIsIntermediateResultExpectedNoCallbacks(computeIsIntermediateResultExpected()))
          return localObject1;
      }
      finally
      {
        monitorexit;
      }
      throw localObject2;
    }

    @Nullable
    private List<ProducerContextCallbacks> updateIsPrefetch()
    {
      monitorenter;
      try
      {
        Object localObject1 = this.mMultiplexProducerContext;
        if (localObject1 == null);
        for (localObject1 = null; ; localObject1 = this.mMultiplexProducerContext.setIsPrefetchNoCallbacks(computeIsPrefetch()))
          return localObject1;
      }
      finally
      {
        monitorexit;
      }
      throw localObject2;
    }

    @Nullable
    private List<ProducerContextCallbacks> updatePriority()
    {
      monitorenter;
      try
      {
        Object localObject1 = this.mMultiplexProducerContext;
        if (localObject1 == null);
        for (localObject1 = null; ; localObject1 = this.mMultiplexProducerContext.setPriorityNoCallbacks(computePriority()))
          return localObject1;
      }
      finally
      {
        monitorexit;
      }
      throw localObject2;
    }

    // ERROR //
    public boolean addNewConsumer(Consumer<T> paramConsumer, ProducerContext paramProducerContext)
    {
      // Byte code:
      //   0: aload_1
      //   1: aload_2
      //   2: invokestatic 226	android/util/Pair:create	(Ljava/lang/Object;Ljava/lang/Object;)Landroid/util/Pair;
      //   5: astore 6
      //   7: aload_0
      //   8: monitorenter
      //   9: aload_0
      //   10: getfield 39	com/facebook/imagepipeline/producers/MultiplexProducer$Multiplexer:this$0	Lcom/facebook/imagepipeline/producers/MultiplexProducer;
      //   13: aload_0
      //   14: getfield 52	com/facebook/imagepipeline/producers/MultiplexProducer$Multiplexer:mKey	Ljava/lang/Object;
      //   17: invokestatic 230	com/facebook/imagepipeline/producers/MultiplexProducer:access$100	(Lcom/facebook/imagepipeline/producers/MultiplexProducer;Ljava/lang/Object;)Lcom/facebook/imagepipeline/producers/MultiplexProducer$Multiplexer;
      //   20: aload_0
      //   21: if_acmpeq +7 -> 28
      //   24: aload_0
      //   25: monitorexit
      //   26: iconst_0
      //   27: ireturn
      //   28: aload_0
      //   29: getfield 50	com/facebook/imagepipeline/producers/MultiplexProducer$Multiplexer:mConsumerContextPairs	Ljava/util/concurrent/CopyOnWriteArraySet;
      //   32: aload 6
      //   34: invokevirtual 234	java/util/concurrent/CopyOnWriteArraySet:add	(Ljava/lang/Object;)Z
      //   37: pop
      //   38: aload_0
      //   39: invokespecial 72	com/facebook/imagepipeline/producers/MultiplexProducer$Multiplexer:updateIsPrefetch	()Ljava/util/List;
      //   42: astore 4
      //   44: aload_0
      //   45: invokespecial 76	com/facebook/imagepipeline/producers/MultiplexProducer$Multiplexer:updatePriority	()Ljava/util/List;
      //   48: astore 7
      //   50: aload_0
      //   51: invokespecial 80	com/facebook/imagepipeline/producers/MultiplexProducer$Multiplexer:updateIsIntermediateResultExpected	()Ljava/util/List;
      //   54: astore 8
      //   56: aload_0
      //   57: getfield 236	com/facebook/imagepipeline/producers/MultiplexProducer$Multiplexer:mLastIntermediateResult	Ljava/io/Closeable;
      //   60: astore 5
      //   62: aload_0
      //   63: getfield 238	com/facebook/imagepipeline/producers/MultiplexProducer$Multiplexer:mLastProgress	F
      //   66: fstore_3
      //   67: aload_0
      //   68: monitorexit
      //   69: aload 4
      //   71: invokestatic 242	com/facebook/imagepipeline/producers/BaseProducerContext:callOnIsPrefetchChanged	(Ljava/util/List;)V
      //   74: aload 7
      //   76: invokestatic 245	com/facebook/imagepipeline/producers/BaseProducerContext:callOnPriorityChanged	(Ljava/util/List;)V
      //   79: aload 8
      //   81: invokestatic 248	com/facebook/imagepipeline/producers/BaseProducerContext:callOnIsIntermediateResultExpectedChanged	(Ljava/util/List;)V
      //   84: aload 6
      //   86: monitorenter
      //   87: aload_0
      //   88: monitorenter
      //   89: aload 5
      //   91: aload_0
      //   92: getfield 236	com/facebook/imagepipeline/producers/MultiplexProducer$Multiplexer:mLastIntermediateResult	Ljava/io/Closeable;
      //   95: if_acmpeq +58 -> 153
      //   98: aconst_null
      //   99: astore 4
      //   101: aload_0
      //   102: monitorexit
      //   103: aload 4
      //   105: ifnull +31 -> 136
      //   108: fload_3
      //   109: fconst_0
      //   110: fcmpl
      //   111: ifle +10 -> 121
      //   114: aload_1
      //   115: fload_3
      //   116: invokeinterface 254 2 0
      //   121: aload_1
      //   122: aload 4
      //   124: iconst_0
      //   125: invokeinterface 258 3 0
      //   130: aload_0
      //   131: aload 4
      //   133: invokespecial 260	com/facebook/imagepipeline/producers/MultiplexProducer$Multiplexer:closeSafely	(Ljava/io/Closeable;)V
      //   136: aload 6
      //   138: monitorexit
      //   139: aload_0
      //   140: aload 6
      //   142: aload_2
      //   143: invokespecial 262	com/facebook/imagepipeline/producers/MultiplexProducer$Multiplexer:addCallbacks	(Landroid/util/Pair;Lcom/facebook/imagepipeline/producers/ProducerContext;)V
      //   146: iconst_1
      //   147: ireturn
      //   148: astore_1
      //   149: aload_0
      //   150: monitorexit
      //   151: aload_1
      //   152: athrow
      //   153: aload 5
      //   155: astore 4
      //   157: aload 5
      //   159: ifnull -58 -> 101
      //   162: aload_0
      //   163: getfield 39	com/facebook/imagepipeline/producers/MultiplexProducer$Multiplexer:this$0	Lcom/facebook/imagepipeline/producers/MultiplexProducer;
      //   166: aload 5
      //   168: invokevirtual 266	com/facebook/imagepipeline/producers/MultiplexProducer:cloneOrNull	(Ljava/io/Closeable;)Ljava/io/Closeable;
      //   171: astore 4
      //   173: goto -72 -> 101
      //   176: astore_1
      //   177: aload_0
      //   178: monitorexit
      //   179: aload_1
      //   180: athrow
      //   181: astore_1
      //   182: aload 6
      //   184: monitorexit
      //   185: aload_1
      //   186: athrow
      //
      // Exception table:
      //   from	to	target	type
      //   9	26	148	finally
      //   28	69	148	finally
      //   149	151	148	finally
      //   89	98	176	finally
      //   101	103	176	finally
      //   162	173	176	finally
      //   177	179	176	finally
      //   87	89	181	finally
      //   114	121	181	finally
      //   121	136	181	finally
      //   136	139	181	finally
      //   179	181	181	finally
      //   182	185	181	finally
    }

    public void onCancelled(MultiplexProducer<K, T>.Multiplexer.ForwardingConsumer paramMultiplexProducer)
    {
      monitorenter;
      try
      {
        if (this.mForwardingConsumer != paramMultiplexProducer)
          return;
        this.mForwardingConsumer = null;
        this.mMultiplexProducerContext = null;
        closeSafely(this.mLastIntermediateResult);
        this.mLastIntermediateResult = null;
        monitorexit;
        startInputProducerIfHasAttachedConsumers();
        return;
      }
      finally
      {
        monitorexit;
      }
      throw paramMultiplexProducer;
    }

    public void onFailure(MultiplexProducer<K, T>.Multiplexer.ForwardingConsumer arg1, Throwable paramThrowable)
    {
      monitorenter;
      try
      {
        if (this.mForwardingConsumer != ???)
          return;
        Iterator localIterator = this.mConsumerContextPairs.iterator();
        this.mConsumerContextPairs.clear();
        MultiplexProducer.this.removeMultiplexer(this.mKey, this);
        closeSafely(this.mLastIntermediateResult);
        this.mLastIntermediateResult = null;
        monitorexit;
        while (localIterator.hasNext())
          synchronized ((Pair)localIterator.next())
          {
            ((Consumer)???.first).onFailure(paramThrowable);
          }
      }
      finally
      {
        monitorexit;
      }
    }

    public void onNextResult(MultiplexProducer<K, T>.Multiplexer.ForwardingConsumer arg1, T paramT, boolean paramBoolean)
    {
      monitorenter;
      try
      {
        if (this.mForwardingConsumer != ???)
          return;
        closeSafely(this.mLastIntermediateResult);
        this.mLastIntermediateResult = null;
        Iterator localIterator = this.mConsumerContextPairs.iterator();
        if (!paramBoolean)
          this.mLastIntermediateResult = MultiplexProducer.this.cloneOrNull(paramT);
        while (true)
        {
          monitorexit;
          while (localIterator.hasNext())
            synchronized ((Pair)localIterator.next())
            {
              ((Consumer)???.first).onNewResult(paramT, paramBoolean);
            }
          this.mConsumerContextPairs.clear();
          MultiplexProducer.this.removeMultiplexer(this.mKey, this);
        }
      }
      finally
      {
        monitorexit;
      }
    }

    public void onProgressUpdate(MultiplexProducer<K, T>.Multiplexer.ForwardingConsumer arg1, float paramFloat)
    {
      monitorenter;
      try
      {
        if (this.mForwardingConsumer != ???)
          return;
        this.mLastProgress = paramFloat;
        Iterator localIterator = this.mConsumerContextPairs.iterator();
        monitorexit;
        while (localIterator.hasNext())
          synchronized ((Pair)localIterator.next())
          {
            ((Consumer)???.first).onProgressUpdate(paramFloat);
          }
      }
      finally
      {
        monitorexit;
      }
    }

    private class ForwardingConsumer extends BaseConsumer<T>
    {
      private ForwardingConsumer()
      {
      }

      protected void onCancellationImpl()
      {
        MultiplexProducer.Multiplexer.this.onCancelled(this);
      }

      protected void onFailureImpl(Throwable paramThrowable)
      {
        MultiplexProducer.Multiplexer.this.onFailure(this, paramThrowable);
      }

      protected void onNewResultImpl(T paramT, boolean paramBoolean)
      {
        MultiplexProducer.Multiplexer.this.onNextResult(this, paramT, paramBoolean);
      }

      protected void onProgressUpdateImpl(float paramFloat)
      {
        MultiplexProducer.Multiplexer.this.onProgressUpdate(this, paramFloat);
      }
    }
  }
}

/* Location:           C:\Users\c_jealom1\Documents\Scripts\Android\Fathom_com.brynk.fathom\Fathom_com.brynk.fathom-dex2jar.jar
 * Qualified Name:     com.facebook.imagepipeline.producers.MultiplexProducer
 * JD-Core Version:    0.6.0
 */
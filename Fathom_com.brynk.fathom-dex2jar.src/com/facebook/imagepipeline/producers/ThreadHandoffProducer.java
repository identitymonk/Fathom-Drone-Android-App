package com.facebook.imagepipeline.producers;

import com.facebook.common.internal.Preconditions;

public class ThreadHandoffProducer<T>
  implements Producer<T>
{
  public static final String PRODUCER_NAME = "BackgroundThreadHandoffProducer";
  private final Producer<T> mInputProducer;
  private final ThreadHandoffProducerQueue mThreadHandoffProducerQueue;

  public ThreadHandoffProducer(Producer<T> paramProducer, ThreadHandoffProducerQueue paramThreadHandoffProducerQueue)
  {
    this.mInputProducer = ((Producer)Preconditions.checkNotNull(paramProducer));
    this.mThreadHandoffProducerQueue = paramThreadHandoffProducerQueue;
  }

  public void produceResults(Consumer<T> paramConsumer, ProducerContext paramProducerContext)
  {
    ProducerListener localProducerListener = paramProducerContext.getListener();
    String str = paramProducerContext.getId();
    paramConsumer = new StatefulProducerRunnable(paramConsumer, localProducerListener, "BackgroundThreadHandoffProducer", str, localProducerListener, str, paramConsumer, paramProducerContext)
    {
      protected void disposeResult(T paramT)
      {
      }

      protected T getResult()
        throws Exception
      {
        return null;
      }

      protected void onSuccess(T paramT)
      {
        this.val$producerListener.onProducerFinishWithSuccess(this.val$requestId, "BackgroundThreadHandoffProducer", null);
        ThreadHandoffProducer.this.mInputProducer.produceResults(this.val$consumer, this.val$context);
      }
    };
    paramProducerContext.addCallbacks(new BaseProducerContextCallbacks(paramConsumer)
    {
      public void onCancellationRequested()
      {
        this.val$statefulRunnable.cancel();
        ThreadHandoffProducer.this.mThreadHandoffProducerQueue.remove(this.val$statefulRunnable);
      }
    });
    this.mThreadHandoffProducerQueue.addToQueueOrExecute(paramConsumer);
  }
}

/* Location:           C:\Users\c_jealom1\Documents\Scripts\Android\Fathom_com.brynk.fathom\Fathom_com.brynk.fathom-dex2jar.jar
 * Qualified Name:     com.facebook.imagepipeline.producers.ThreadHandoffProducer
 * JD-Core Version:    0.6.0
 */
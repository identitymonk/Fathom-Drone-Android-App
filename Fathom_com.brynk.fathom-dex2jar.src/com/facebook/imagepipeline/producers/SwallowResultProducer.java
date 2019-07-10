package com.facebook.imagepipeline.producers;

public class SwallowResultProducer<T>
  implements Producer<Void>
{
  private final Producer<T> mInputProducer;

  public SwallowResultProducer(Producer<T> paramProducer)
  {
    this.mInputProducer = paramProducer;
  }

  public void produceResults(Consumer<Void> paramConsumer, ProducerContext paramProducerContext)
  {
    paramConsumer = new DelegatingConsumer(paramConsumer)
    {
      protected void onNewResultImpl(T paramT, boolean paramBoolean)
      {
        if (paramBoolean)
          getConsumer().onNewResult(null, paramBoolean);
      }
    };
    this.mInputProducer.produceResults(paramConsumer, paramProducerContext);
  }
}

/* Location:           C:\Users\c_jealom1\Documents\Scripts\Android\Fathom_com.brynk.fathom\Fathom_com.brynk.fathom-dex2jar.jar
 * Qualified Name:     com.facebook.imagepipeline.producers.SwallowResultProducer
 * JD-Core Version:    0.6.0
 */
package com.facebook.imagepipeline.producers;

public class NullProducer<T>
  implements Producer<T>
{
  public void produceResults(Consumer<T> paramConsumer, ProducerContext paramProducerContext)
  {
    paramConsumer.onNewResult(null, true);
  }
}

/* Location:           C:\Users\c_jealom1\Documents\Scripts\Android\Fathom_com.brynk.fathom\Fathom_com.brynk.fathom-dex2jar.jar
 * Qualified Name:     com.facebook.imagepipeline.producers.NullProducer
 * JD-Core Version:    0.6.0
 */
package com.facebook.imagepipeline.producers;

public abstract interface ProducerContextCallbacks
{
  public abstract void onCancellationRequested();

  public abstract void onIsIntermediateResultExpectedChanged();

  public abstract void onIsPrefetchChanged();

  public abstract void onPriorityChanged();
}

/* Location:           C:\Users\c_jealom1\Documents\Scripts\Android\Fathom_com.brynk.fathom\Fathom_com.brynk.fathom-dex2jar.jar
 * Qualified Name:     com.facebook.imagepipeline.producers.ProducerContextCallbacks
 * JD-Core Version:    0.6.0
 */
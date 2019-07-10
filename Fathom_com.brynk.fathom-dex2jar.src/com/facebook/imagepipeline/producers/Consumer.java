package com.facebook.imagepipeline.producers;

public abstract interface Consumer<T>
{
  public abstract void onCancellation();

  public abstract void onFailure(Throwable paramThrowable);

  public abstract void onNewResult(T paramT, boolean paramBoolean);

  public abstract void onProgressUpdate(float paramFloat);
}

/* Location:           C:\Users\c_jealom1\Documents\Scripts\Android\Fathom_com.brynk.fathom\Fathom_com.brynk.fathom-dex2jar.jar
 * Qualified Name:     com.facebook.imagepipeline.producers.Consumer
 * JD-Core Version:    0.6.0
 */
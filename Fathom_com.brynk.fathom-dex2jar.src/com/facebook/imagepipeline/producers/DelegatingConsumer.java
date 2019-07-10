package com.facebook.imagepipeline.producers;

public abstract class DelegatingConsumer<I, O> extends BaseConsumer<I>
{
  private final Consumer<O> mConsumer;

  public DelegatingConsumer(Consumer<O> paramConsumer)
  {
    this.mConsumer = paramConsumer;
  }

  public Consumer<O> getConsumer()
  {
    return this.mConsumer;
  }

  protected void onCancellationImpl()
  {
    this.mConsumer.onCancellation();
  }

  protected void onFailureImpl(Throwable paramThrowable)
  {
    this.mConsumer.onFailure(paramThrowable);
  }

  protected void onProgressUpdateImpl(float paramFloat)
  {
    this.mConsumer.onProgressUpdate(paramFloat);
  }
}

/* Location:           C:\Users\c_jealom1\Documents\Scripts\Android\Fathom_com.brynk.fathom\Fathom_com.brynk.fathom-dex2jar.jar
 * Qualified Name:     com.facebook.imagepipeline.producers.DelegatingConsumer
 * JD-Core Version:    0.6.0
 */
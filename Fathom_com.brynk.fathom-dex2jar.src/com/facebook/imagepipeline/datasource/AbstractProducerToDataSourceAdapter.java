package com.facebook.imagepipeline.datasource;

import com.facebook.common.internal.Preconditions;
import com.facebook.datasource.AbstractDataSource;
import com.facebook.imagepipeline.listener.RequestListener;
import com.facebook.imagepipeline.producers.BaseConsumer;
import com.facebook.imagepipeline.producers.Consumer;
import com.facebook.imagepipeline.producers.Producer;
import com.facebook.imagepipeline.producers.SettableProducerContext;
import javax.annotation.Nullable;
import javax.annotation.concurrent.ThreadSafe;

@ThreadSafe
public abstract class AbstractProducerToDataSourceAdapter<T> extends AbstractDataSource<T>
{
  private final RequestListener mRequestListener;
  private final SettableProducerContext mSettableProducerContext;

  protected AbstractProducerToDataSourceAdapter(Producer<T> paramProducer, SettableProducerContext paramSettableProducerContext, RequestListener paramRequestListener)
  {
    this.mSettableProducerContext = paramSettableProducerContext;
    this.mRequestListener = paramRequestListener;
    this.mRequestListener.onRequestStart(paramSettableProducerContext.getImageRequest(), this.mSettableProducerContext.getCallerContext(), this.mSettableProducerContext.getId(), this.mSettableProducerContext.isPrefetch());
    paramProducer.produceResults(createConsumer(), paramSettableProducerContext);
  }

  private Consumer<T> createConsumer()
  {
    return new BaseConsumer()
    {
      protected void onCancellationImpl()
      {
        AbstractProducerToDataSourceAdapter.this.onCancellationImpl();
      }

      protected void onFailureImpl(Throwable paramThrowable)
      {
        AbstractProducerToDataSourceAdapter.this.onFailureImpl(paramThrowable);
      }

      protected void onNewResultImpl(@Nullable T paramT, boolean paramBoolean)
      {
        AbstractProducerToDataSourceAdapter.this.onNewResultImpl(paramT, paramBoolean);
      }

      protected void onProgressUpdateImpl(float paramFloat)
      {
        AbstractProducerToDataSourceAdapter.this.setProgress(paramFloat);
      }
    };
  }

  private void onCancellationImpl()
  {
    monitorenter;
    try
    {
      Preconditions.checkState(isClosed());
      monitorexit;
      return;
    }
    finally
    {
      localObject = finally;
      monitorexit;
    }
    throw localObject;
  }

  private void onFailureImpl(Throwable paramThrowable)
  {
    if (super.setFailure(paramThrowable))
      this.mRequestListener.onRequestFailure(this.mSettableProducerContext.getImageRequest(), this.mSettableProducerContext.getId(), paramThrowable, this.mSettableProducerContext.isPrefetch());
  }

  public boolean close()
  {
    if (!super.close())
      return false;
    if (!super.isFinished())
    {
      this.mRequestListener.onRequestCancellation(this.mSettableProducerContext.getId());
      this.mSettableProducerContext.cancel();
    }
    return true;
  }

  protected void onNewResultImpl(@Nullable T paramT, boolean paramBoolean)
  {
    if ((super.setResult(paramT, paramBoolean)) && (paramBoolean))
      this.mRequestListener.onRequestSuccess(this.mSettableProducerContext.getImageRequest(), this.mSettableProducerContext.getId(), this.mSettableProducerContext.isPrefetch());
  }
}

/* Location:           C:\Users\c_jealom1\Documents\Scripts\Android\Fathom_com.brynk.fathom\Fathom_com.brynk.fathom-dex2jar.jar
 * Qualified Name:     com.facebook.imagepipeline.datasource.AbstractProducerToDataSourceAdapter
 * JD-Core Version:    0.6.0
 */
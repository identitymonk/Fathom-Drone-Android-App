package com.facebook.imagepipeline.producers;

import android.graphics.Bitmap;
import com.facebook.common.internal.ImmutableMap;
import com.facebook.common.internal.Preconditions;
import com.facebook.common.internal.VisibleForTesting;
import com.facebook.common.references.CloseableReference;
import com.facebook.imagepipeline.bitmaps.PlatformBitmapFactory;
import com.facebook.imagepipeline.image.CloseableImage;
import com.facebook.imagepipeline.image.CloseableStaticBitmap;
import com.facebook.imagepipeline.request.ImageRequest;
import com.facebook.imagepipeline.request.Postprocessor;
import com.facebook.imagepipeline.request.RepeatedPostprocessor;
import com.facebook.imagepipeline.request.RepeatedPostprocessorRunner;
import java.util.Map;
import java.util.concurrent.Executor;
import javax.annotation.Nullable;
import javax.annotation.concurrent.GuardedBy;

public class PostprocessorProducer
  implements Producer<CloseableReference<CloseableImage>>
{
  public static final String NAME = "PostprocessorProducer";

  @VisibleForTesting
  static final String POSTPROCESSOR = "Postprocessor";
  private final PlatformBitmapFactory mBitmapFactory;
  private final Executor mExecutor;
  private final Producer<CloseableReference<CloseableImage>> mInputProducer;

  public PostprocessorProducer(Producer<CloseableReference<CloseableImage>> paramProducer, PlatformBitmapFactory paramPlatformBitmapFactory, Executor paramExecutor)
  {
    this.mInputProducer = ((Producer)Preconditions.checkNotNull(paramProducer));
    this.mBitmapFactory = paramPlatformBitmapFactory;
    this.mExecutor = ((Executor)Preconditions.checkNotNull(paramExecutor));
  }

  public void produceResults(Consumer<CloseableReference<CloseableImage>> paramConsumer, ProducerContext paramProducerContext)
  {
    ProducerListener localProducerListener = paramProducerContext.getListener();
    Postprocessor localPostprocessor = paramProducerContext.getImageRequest().getPostprocessor();
    paramConsumer = new PostprocessorConsumer(paramConsumer, localProducerListener, paramProducerContext.getId(), localPostprocessor, paramProducerContext);
    if ((localPostprocessor instanceof RepeatedPostprocessor));
    for (paramConsumer = new RepeatedPostprocessorConsumer(paramConsumer, (RepeatedPostprocessor)localPostprocessor, paramProducerContext, null); ; paramConsumer = new SingleUsePostprocessorConsumer(paramConsumer, null))
    {
      this.mInputProducer.produceResults(paramConsumer, paramProducerContext);
      return;
    }
  }

  private class PostprocessorConsumer extends DelegatingConsumer<CloseableReference<CloseableImage>, CloseableReference<CloseableImage>>
  {

    @GuardedBy("PostprocessorConsumer.this")
    private boolean mIsClosed;

    @GuardedBy("PostprocessorConsumer.this")
    private boolean mIsDirty = false;

    @GuardedBy("PostprocessorConsumer.this")
    private boolean mIsLast = false;

    @GuardedBy("PostprocessorConsumer.this")
    private boolean mIsPostProcessingRunning = false;
    private final ProducerListener mListener;
    private final Postprocessor mPostprocessor;
    private final String mRequestId;

    @Nullable
    @GuardedBy("PostprocessorConsumer.this")
    private CloseableReference<CloseableImage> mSourceImageRef = null;

    public PostprocessorConsumer(ProducerListener paramString, String paramPostprocessor, Postprocessor paramProducerContext, ProducerContext arg5)
    {
      super();
      this.mListener = paramPostprocessor;
      this.mRequestId = paramProducerContext;
      Object localObject1;
      this.mPostprocessor = localObject1;
      Object localObject2;
      localObject2.addCallbacks(new BaseProducerContextCallbacks(PostprocessorProducer.this)
      {
        public void onCancellationRequested()
        {
          PostprocessorProducer.PostprocessorConsumer.this.maybeNotifyOnCancellation();
        }
      });
    }

    private void clearRunningAndStartIfDirty()
    {
      monitorenter;
      try
      {
        this.mIsPostProcessingRunning = false;
        boolean bool = setRunningIfDirtyAndNotRunning();
        monitorexit;
        if (bool)
          submitPostprocessing();
        return;
      }
      finally
      {
        monitorexit;
      }
      throw localObject;
    }

    private boolean close()
    {
      monitorenter;
      try
      {
        if (this.mIsClosed)
          return false;
        CloseableReference localCloseableReference = this.mSourceImageRef;
        this.mSourceImageRef = null;
        this.mIsClosed = true;
        monitorexit;
        CloseableReference.closeSafely(localCloseableReference);
        return true;
      }
      finally
      {
        monitorexit;
      }
      throw localObject;
    }

    private void doPostprocessing(CloseableReference<CloseableImage> paramCloseableReference, boolean paramBoolean)
    {
      Preconditions.checkArgument(CloseableReference.isValid(paramCloseableReference));
      if (!shouldPostprocess((CloseableImage)paramCloseableReference.get()))
      {
        maybeNotifyOnNewResult(paramCloseableReference, paramBoolean);
        return;
      }
      this.mListener.onProducerStart(this.mRequestId, "PostprocessorProducer");
      Object localObject2 = null;
      Object localObject1 = localObject2;
      try
      {
        paramCloseableReference = postprocessInternal((CloseableImage)paramCloseableReference.get());
        localObject1 = paramCloseableReference;
        this.mListener.onProducerFinishWithSuccess(this.mRequestId, "PostprocessorProducer", getExtraMap(this.mListener, this.mRequestId, this.mPostprocessor));
        localObject1 = paramCloseableReference;
        maybeNotifyOnNewResult(paramCloseableReference, paramBoolean);
        CloseableReference.closeSafely(paramCloseableReference);
        return;
      }
      catch (java.lang.Exception paramCloseableReference)
      {
        localObject1 = localObject2;
        this.mListener.onProducerFinishWithFailure(this.mRequestId, "PostprocessorProducer", paramCloseableReference, getExtraMap(this.mListener, this.mRequestId, this.mPostprocessor));
        localObject1 = localObject2;
        maybeNotifyOnFailure(paramCloseableReference);
        CloseableReference.closeSafely(null);
        return;
      }
      finally
      {
        CloseableReference.closeSafely((CloseableReference)localObject1);
      }
      throw paramCloseableReference;
    }

    private Map<String, String> getExtraMap(ProducerListener paramProducerListener, String paramString, Postprocessor paramPostprocessor)
    {
      if (!paramProducerListener.requiresExtraMap(paramString))
        return null;
      return ImmutableMap.of("Postprocessor", paramPostprocessor.getName());
    }

    private boolean isClosed()
    {
      monitorenter;
      try
      {
        boolean bool = this.mIsClosed;
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

    private void maybeNotifyOnCancellation()
    {
      if (close())
        getConsumer().onCancellation();
    }

    private void maybeNotifyOnFailure(Throwable paramThrowable)
    {
      if (close())
        getConsumer().onFailure(paramThrowable);
    }

    private void maybeNotifyOnNewResult(CloseableReference<CloseableImage> paramCloseableReference, boolean paramBoolean)
    {
      if (((!paramBoolean) && (!isClosed())) || ((paramBoolean) && (close())))
        getConsumer().onNewResult(paramCloseableReference, paramBoolean);
    }

    private CloseableReference<CloseableImage> postprocessInternal(CloseableImage paramCloseableImage)
    {
      CloseableStaticBitmap localCloseableStaticBitmap = (CloseableStaticBitmap)paramCloseableImage;
      Object localObject = localCloseableStaticBitmap.getUnderlyingBitmap();
      localObject = this.mPostprocessor.process((Bitmap)localObject, PostprocessorProducer.this.mBitmapFactory);
      int i = localCloseableStaticBitmap.getRotationAngle();
      try
      {
        paramCloseableImage = CloseableReference.of(new CloseableStaticBitmap((CloseableReference)localObject, paramCloseableImage.getQualityInfo(), i));
        return paramCloseableImage;
      }
      finally
      {
        CloseableReference.closeSafely((CloseableReference)localObject);
      }
      throw paramCloseableImage;
    }

    private boolean setRunningIfDirtyAndNotRunning()
    {
      int i = 1;
      monitorenter;
      try
      {
        if ((!this.mIsClosed) && (this.mIsDirty) && (!this.mIsPostProcessingRunning) && (CloseableReference.isValid(this.mSourceImageRef)))
        {
          this.mIsPostProcessingRunning = true;
          return i;
        }
        i = 0;
      }
      finally
      {
        monitorexit;
      }
    }

    private boolean shouldPostprocess(CloseableImage paramCloseableImage)
    {
      return paramCloseableImage instanceof CloseableStaticBitmap;
    }

    private void submitPostprocessing()
    {
      PostprocessorProducer.this.mExecutor.execute(new Runnable()
      {
        public void run()
        {
          CloseableReference localCloseableReference1;
          boolean bool;
          synchronized (PostprocessorProducer.PostprocessorConsumer.this)
          {
            localCloseableReference1 = PostprocessorProducer.PostprocessorConsumer.this.mSourceImageRef;
            bool = PostprocessorProducer.PostprocessorConsumer.this.mIsLast;
            PostprocessorProducer.PostprocessorConsumer.access$302(PostprocessorProducer.PostprocessorConsumer.this, null);
            PostprocessorProducer.PostprocessorConsumer.access$502(PostprocessorProducer.PostprocessorConsumer.this, false);
            if (!CloseableReference.isValid(localCloseableReference1));
          }
          try
          {
            PostprocessorProducer.PostprocessorConsumer.this.doPostprocessing(localCloseableReference1, bool);
            CloseableReference.closeSafely(localCloseableReference1);
            PostprocessorProducer.PostprocessorConsumer.this.clearRunningAndStartIfDirty();
            return;
            localCloseableReference2 = finally;
            monitorexit;
            throw localCloseableReference2;
          }
          finally
          {
          }
          throw localObject;
        }
      });
    }

    private void updateSourceImageRef(@Nullable CloseableReference<CloseableImage> paramCloseableReference, boolean paramBoolean)
    {
      monitorenter;
      try
      {
        if (this.mIsClosed)
          return;
        CloseableReference localCloseableReference = this.mSourceImageRef;
        this.mSourceImageRef = CloseableReference.cloneOrNull(paramCloseableReference);
        this.mIsLast = paramBoolean;
        this.mIsDirty = true;
        paramBoolean = setRunningIfDirtyAndNotRunning();
        monitorexit;
        CloseableReference.closeSafely(localCloseableReference);
        if (paramBoolean)
        {
          submitPostprocessing();
          return;
        }
      }
      finally
      {
        monitorexit;
      }
    }

    protected void onCancellationImpl()
    {
      maybeNotifyOnCancellation();
    }

    protected void onFailureImpl(Throwable paramThrowable)
    {
      maybeNotifyOnFailure(paramThrowable);
    }

    protected void onNewResultImpl(CloseableReference<CloseableImage> paramCloseableReference, boolean paramBoolean)
    {
      if (!CloseableReference.isValid(paramCloseableReference))
      {
        if (paramBoolean)
          maybeNotifyOnNewResult(null, true);
        return;
      }
      updateSourceImageRef(paramCloseableReference, paramBoolean);
    }
  }

  class RepeatedPostprocessorConsumer extends DelegatingConsumer<CloseableReference<CloseableImage>, CloseableReference<CloseableImage>>
    implements RepeatedPostprocessorRunner
  {

    @GuardedBy("RepeatedPostprocessorConsumer.this")
    private boolean mIsClosed = false;

    @Nullable
    @GuardedBy("RepeatedPostprocessorConsumer.this")
    private CloseableReference<CloseableImage> mSourceImageRef = null;

    private RepeatedPostprocessorConsumer(PostprocessorProducer.PostprocessorConsumer paramRepeatedPostprocessor, RepeatedPostprocessor paramProducerContext, ProducerContext arg4)
    {
      super();
      paramProducerContext.setCallback(this);
      Object localObject;
      localObject.addCallbacks(new BaseProducerContextCallbacks(PostprocessorProducer.this)
      {
        public void onCancellationRequested()
        {
          if (PostprocessorProducer.RepeatedPostprocessorConsumer.this.close())
            PostprocessorProducer.RepeatedPostprocessorConsumer.this.getConsumer().onCancellation();
        }
      });
    }

    private boolean close()
    {
      monitorenter;
      try
      {
        if (this.mIsClosed)
          return false;
        CloseableReference localCloseableReference = this.mSourceImageRef;
        this.mSourceImageRef = null;
        this.mIsClosed = true;
        monitorexit;
        CloseableReference.closeSafely(localCloseableReference);
        return true;
      }
      finally
      {
        monitorexit;
      }
      throw localObject;
    }

    private void setSourceImageRef(CloseableReference<CloseableImage> paramCloseableReference)
    {
      monitorenter;
      try
      {
        if (this.mIsClosed)
          return;
        CloseableReference localCloseableReference = this.mSourceImageRef;
        this.mSourceImageRef = CloseableReference.cloneOrNull(paramCloseableReference);
        monitorexit;
        CloseableReference.closeSafely(localCloseableReference);
        return;
      }
      finally
      {
        monitorexit;
      }
      throw paramCloseableReference;
    }

    // ERROR //
    private void updateInternal()
    {
      // Byte code:
      //   0: aload_0
      //   1: monitorenter
      //   2: aload_0
      //   3: getfield 32	com/facebook/imagepipeline/producers/PostprocessorProducer$RepeatedPostprocessorConsumer:mIsClosed	Z
      //   6: ifeq +6 -> 12
      //   9: aload_0
      //   10: monitorexit
      //   11: return
      //   12: aload_0
      //   13: getfield 34	com/facebook/imagepipeline/producers/PostprocessorProducer$RepeatedPostprocessorConsumer:mSourceImageRef	Lcom/facebook/common/references/CloseableReference;
      //   16: invokestatic 70	com/facebook/common/references/CloseableReference:cloneOrNull	(Lcom/facebook/common/references/CloseableReference;)Lcom/facebook/common/references/CloseableReference;
      //   19: astore_1
      //   20: aload_0
      //   21: monitorexit
      //   22: aload_0
      //   23: invokevirtual 78	com/facebook/imagepipeline/producers/PostprocessorProducer$RepeatedPostprocessorConsumer:getConsumer	()Lcom/facebook/imagepipeline/producers/Consumer;
      //   26: aload_1
      //   27: iconst_0
      //   28: invokeinterface 84 3 0
      //   33: aload_1
      //   34: invokestatic 65	com/facebook/common/references/CloseableReference:closeSafely	(Lcom/facebook/common/references/CloseableReference;)V
      //   37: return
      //   38: astore_1
      //   39: aload_0
      //   40: monitorexit
      //   41: aload_1
      //   42: athrow
      //   43: astore_2
      //   44: aload_1
      //   45: invokestatic 65	com/facebook/common/references/CloseableReference:closeSafely	(Lcom/facebook/common/references/CloseableReference;)V
      //   48: aload_2
      //   49: athrow
      //
      // Exception table:
      //   from	to	target	type
      //   2	11	38	finally
      //   12	22	38	finally
      //   39	41	38	finally
      //   22	33	43	finally
    }

    protected void onCancellationImpl()
    {
      if (close())
        getConsumer().onCancellation();
    }

    protected void onFailureImpl(Throwable paramThrowable)
    {
      if (close())
        getConsumer().onFailure(paramThrowable);
    }

    protected void onNewResultImpl(CloseableReference<CloseableImage> paramCloseableReference, boolean paramBoolean)
    {
      if (!paramBoolean)
        return;
      setSourceImageRef(paramCloseableReference);
      updateInternal();
    }

    public void update()
    {
      monitorenter;
      try
      {
        updateInternal();
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
  }

  class SingleUsePostprocessorConsumer extends DelegatingConsumer<CloseableReference<CloseableImage>, CloseableReference<CloseableImage>>
  {
    private SingleUsePostprocessorConsumer(PostprocessorProducer.PostprocessorConsumer arg2)
    {
      super();
    }

    protected void onNewResultImpl(CloseableReference<CloseableImage> paramCloseableReference, boolean paramBoolean)
    {
      if (!paramBoolean)
        return;
      getConsumer().onNewResult(paramCloseableReference, paramBoolean);
    }
  }
}

/* Location:           C:\Users\c_jealom1\Documents\Scripts\Android\Fathom_com.brynk.fathom\Fathom_com.brynk.fathom-dex2jar.jar
 * Qualified Name:     com.facebook.imagepipeline.producers.PostprocessorProducer
 * JD-Core Version:    0.6.0
 */
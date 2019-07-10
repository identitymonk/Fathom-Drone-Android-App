package com.facebook.drawee.controller;

import android.content.Context;
import android.graphics.drawable.Animatable;
import com.facebook.common.internal.Objects;
import com.facebook.common.internal.Objects.ToStringHelper;
import com.facebook.common.internal.Preconditions;
import com.facebook.common.internal.Supplier;
import com.facebook.datasource.DataSource;
import com.facebook.datasource.DataSources;
import com.facebook.datasource.FirstAvailableDataSourceSupplier;
import com.facebook.datasource.IncreasingQualityDataSourceSupplier;
import com.facebook.drawee.components.RetryManager;
import com.facebook.drawee.gestures.GestureDetector;
import com.facebook.drawee.interfaces.DraweeController;
import com.facebook.drawee.interfaces.SimpleDraweeControllerBuilder;
import com.facebook.infer.annotation.ReturnsOwnership;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.atomic.AtomicLong;
import javax.annotation.Nullable;

public abstract class AbstractDraweeControllerBuilder<BUILDER extends AbstractDraweeControllerBuilder<BUILDER, REQUEST, IMAGE, INFO>, REQUEST, IMAGE, INFO>
  implements SimpleDraweeControllerBuilder
{
  private static final NullPointerException NO_REQUEST_EXCEPTION;
  private static final ControllerListener<Object> sAutoPlayAnimationsListener = new BaseControllerListener()
  {
    public void onFinalImageSet(String paramString, @Nullable Object paramObject, @Nullable Animatable paramAnimatable)
    {
      if (paramAnimatable != null)
        paramAnimatable.start();
    }
  };
  private static final AtomicLong sIdCounter;
  private boolean mAutoPlayAnimations;
  private final Set<ControllerListener> mBoundControllerListeners;

  @Nullable
  private Object mCallerContext;
  private String mContentDescription;
  private final Context mContext;

  @Nullable
  private ControllerListener<? super INFO> mControllerListener;

  @Nullable
  private ControllerViewportVisibilityListener mControllerViewportVisibilityListener;

  @Nullable
  private Supplier<DataSource<IMAGE>> mDataSourceSupplier;

  @Nullable
  private REQUEST mImageRequest;

  @Nullable
  private REQUEST mLowResImageRequest;

  @Nullable
  private REQUEST[] mMultiImageRequests;

  @Nullable
  private DraweeController mOldController;
  private boolean mRetainImageOnFailure;
  private boolean mTapToRetryEnabled;
  private boolean mTryCacheOnlyFirst;

  static
  {
    NO_REQUEST_EXCEPTION = new NullPointerException("No image request was specified!");
    sIdCounter = new AtomicLong();
  }

  protected AbstractDraweeControllerBuilder(Context paramContext, Set<ControllerListener> paramSet)
  {
    this.mContext = paramContext;
    this.mBoundControllerListeners = paramSet;
    init();
  }

  protected static String generateUniqueControllerId()
  {
    return String.valueOf(sIdCounter.getAndIncrement());
  }

  private void init()
  {
    this.mCallerContext = null;
    this.mImageRequest = null;
    this.mLowResImageRequest = null;
    this.mMultiImageRequests = null;
    this.mTryCacheOnlyFirst = true;
    this.mControllerListener = null;
    this.mControllerViewportVisibilityListener = null;
    this.mTapToRetryEnabled = false;
    this.mAutoPlayAnimations = false;
    this.mOldController = null;
    this.mContentDescription = null;
  }

  public AbstractDraweeController build()
  {
    validate();
    if ((this.mImageRequest == null) && (this.mMultiImageRequests == null) && (this.mLowResImageRequest != null))
    {
      this.mImageRequest = this.mLowResImageRequest;
      this.mLowResImageRequest = null;
    }
    return buildController();
  }

  protected AbstractDraweeController buildController()
  {
    AbstractDraweeController localAbstractDraweeController = obtainController();
    localAbstractDraweeController.setRetainImageOnFailure(getRetainImageOnFailure());
    localAbstractDraweeController.setContentDescription(getContentDescription());
    localAbstractDraweeController.setControllerViewportVisibilityListener(getControllerViewportVisibilityListener());
    maybeBuildAndSetRetryManager(localAbstractDraweeController);
    maybeAttachListeners(localAbstractDraweeController);
    return localAbstractDraweeController;
  }

  public boolean getAutoPlayAnimations()
  {
    return this.mAutoPlayAnimations;
  }

  @Nullable
  public Object getCallerContext()
  {
    return this.mCallerContext;
  }

  @Nullable
  public String getContentDescription()
  {
    return this.mContentDescription;
  }

  protected Context getContext()
  {
    return this.mContext;
  }

  @Nullable
  public ControllerListener<? super INFO> getControllerListener()
  {
    return this.mControllerListener;
  }

  @Nullable
  public ControllerViewportVisibilityListener getControllerViewportVisibilityListener()
  {
    return this.mControllerViewportVisibilityListener;
  }

  protected abstract DataSource<IMAGE> getDataSourceForRequest(REQUEST paramREQUEST, Object paramObject, CacheLevel paramCacheLevel);

  @Nullable
  public Supplier<DataSource<IMAGE>> getDataSourceSupplier()
  {
    return this.mDataSourceSupplier;
  }

  protected Supplier<DataSource<IMAGE>> getDataSourceSupplierForRequest(REQUEST paramREQUEST)
  {
    return getDataSourceSupplierForRequest(paramREQUEST, CacheLevel.FULL_FETCH);
  }

  protected Supplier<DataSource<IMAGE>> getDataSourceSupplierForRequest(REQUEST paramREQUEST, CacheLevel paramCacheLevel)
  {
    return new Supplier(paramREQUEST, getCallerContext(), paramCacheLevel)
    {
      public DataSource<IMAGE> get()
      {
        return AbstractDraweeControllerBuilder.this.getDataSourceForRequest(this.val$imageRequest, this.val$callerContext, this.val$cacheLevel);
      }

      public String toString()
      {
        return Objects.toStringHelper(this).add("request", this.val$imageRequest.toString()).toString();
      }
    };
  }

  protected Supplier<DataSource<IMAGE>> getFirstAvailableDataSourceSupplier(REQUEST[] paramArrayOfREQUEST, boolean paramBoolean)
  {
    ArrayList localArrayList = new ArrayList(paramArrayOfREQUEST.length * 2);
    if (paramBoolean)
    {
      i = 0;
      while (i < paramArrayOfREQUEST.length)
      {
        localArrayList.add(getDataSourceSupplierForRequest(paramArrayOfREQUEST[i], CacheLevel.BITMAP_MEMORY_CACHE));
        i += 1;
      }
    }
    int i = 0;
    while (i < paramArrayOfREQUEST.length)
    {
      localArrayList.add(getDataSourceSupplierForRequest(paramArrayOfREQUEST[i]));
      i += 1;
    }
    return FirstAvailableDataSourceSupplier.create(localArrayList);
  }

  @Nullable
  public REQUEST[] getFirstAvailableImageRequests()
  {
    return this.mMultiImageRequests;
  }

  @Nullable
  public REQUEST getImageRequest()
  {
    return this.mImageRequest;
  }

  @Nullable
  public REQUEST getLowResImageRequest()
  {
    return this.mLowResImageRequest;
  }

  @Nullable
  public DraweeController getOldController()
  {
    return this.mOldController;
  }

  public boolean getRetainImageOnFailure()
  {
    return this.mRetainImageOnFailure;
  }

  public boolean getTapToRetryEnabled()
  {
    return this.mTapToRetryEnabled;
  }

  protected abstract BUILDER getThis();

  protected void maybeAttachListeners(AbstractDraweeController paramAbstractDraweeController)
  {
    if (this.mBoundControllerListeners != null)
    {
      Iterator localIterator = this.mBoundControllerListeners.iterator();
      while (localIterator.hasNext())
        paramAbstractDraweeController.addControllerListener((ControllerListener)localIterator.next());
    }
    if (this.mControllerListener != null)
      paramAbstractDraweeController.addControllerListener(this.mControllerListener);
    if (this.mAutoPlayAnimations)
      paramAbstractDraweeController.addControllerListener(sAutoPlayAnimationsListener);
  }

  protected void maybeBuildAndSetGestureDetector(AbstractDraweeController paramAbstractDraweeController)
  {
    if (paramAbstractDraweeController.getGestureDetector() == null)
      paramAbstractDraweeController.setGestureDetector(GestureDetector.newInstance(this.mContext));
  }

  protected void maybeBuildAndSetRetryManager(AbstractDraweeController paramAbstractDraweeController)
  {
    if (!this.mTapToRetryEnabled)
      return;
    RetryManager localRetryManager2 = paramAbstractDraweeController.getRetryManager();
    RetryManager localRetryManager1 = localRetryManager2;
    if (localRetryManager2 == null)
    {
      localRetryManager1 = new RetryManager();
      paramAbstractDraweeController.setRetryManager(localRetryManager1);
    }
    localRetryManager1.setTapToRetryEnabled(this.mTapToRetryEnabled);
    maybeBuildAndSetGestureDetector(paramAbstractDraweeController);
  }

  @ReturnsOwnership
  protected abstract AbstractDraweeController obtainController();

  protected Supplier<DataSource<IMAGE>> obtainDataSourceSupplier()
  {
    if (this.mDataSourceSupplier != null)
    {
      localObject1 = this.mDataSourceSupplier;
      return localObject1;
    }
    Object localObject1 = null;
    if (this.mImageRequest != null)
      localObject1 = getDataSourceSupplierForRequest(this.mImageRequest);
    while (true)
    {
      Object localObject2 = localObject1;
      if (localObject1 != null)
      {
        localObject2 = localObject1;
        if (this.mLowResImageRequest != null)
        {
          localObject2 = new ArrayList(2);
          ((List)localObject2).add(localObject1);
          ((List)localObject2).add(getDataSourceSupplierForRequest(this.mLowResImageRequest));
          localObject2 = IncreasingQualityDataSourceSupplier.create((List)localObject2);
        }
      }
      localObject1 = localObject2;
      if (localObject2 != null)
        break;
      return DataSources.getFailedDataSourceSupplier(NO_REQUEST_EXCEPTION);
      if (this.mMultiImageRequests == null)
        continue;
      localObject1 = getFirstAvailableDataSourceSupplier(this.mMultiImageRequests, this.mTryCacheOnlyFirst);
    }
  }

  public BUILDER reset()
  {
    init();
    return getThis();
  }

  public BUILDER setAutoPlayAnimations(boolean paramBoolean)
  {
    this.mAutoPlayAnimations = paramBoolean;
    return getThis();
  }

  public BUILDER setCallerContext(Object paramObject)
  {
    this.mCallerContext = paramObject;
    return getThis();
  }

  public BUILDER setContentDescription(String paramString)
  {
    this.mContentDescription = paramString;
    return getThis();
  }

  public BUILDER setControllerListener(ControllerListener<? super INFO> paramControllerListener)
  {
    this.mControllerListener = paramControllerListener;
    return getThis();
  }

  public BUILDER setControllerViewportVisibilityListener(@Nullable ControllerViewportVisibilityListener paramControllerViewportVisibilityListener)
  {
    this.mControllerViewportVisibilityListener = paramControllerViewportVisibilityListener;
    return getThis();
  }

  public void setDataSourceSupplier(@Nullable Supplier<DataSource<IMAGE>> paramSupplier)
  {
    this.mDataSourceSupplier = paramSupplier;
  }

  public BUILDER setFirstAvailableImageRequests(REQUEST[] paramArrayOfREQUEST)
  {
    return setFirstAvailableImageRequests(paramArrayOfREQUEST, true);
  }

  public BUILDER setFirstAvailableImageRequests(REQUEST[] paramArrayOfREQUEST, boolean paramBoolean)
  {
    this.mMultiImageRequests = paramArrayOfREQUEST;
    this.mTryCacheOnlyFirst = paramBoolean;
    return getThis();
  }

  public BUILDER setImageRequest(REQUEST paramREQUEST)
  {
    this.mImageRequest = paramREQUEST;
    return getThis();
  }

  public BUILDER setLowResImageRequest(REQUEST paramREQUEST)
  {
    this.mLowResImageRequest = paramREQUEST;
    return getThis();
  }

  public BUILDER setOldController(@Nullable DraweeController paramDraweeController)
  {
    this.mOldController = paramDraweeController;
    return getThis();
  }

  public BUILDER setRetainImageOnFailure(boolean paramBoolean)
  {
    this.mRetainImageOnFailure = paramBoolean;
    return getThis();
  }

  public BUILDER setTapToRetryEnabled(boolean paramBoolean)
  {
    this.mTapToRetryEnabled = paramBoolean;
    return getThis();
  }

  protected void validate()
  {
    boolean bool2 = false;
    if ((this.mMultiImageRequests == null) || (this.mImageRequest == null));
    for (boolean bool1 = true; ; bool1 = false)
    {
      Preconditions.checkState(bool1, "Cannot specify both ImageRequest and FirstAvailableImageRequests!");
      if (this.mDataSourceSupplier != null)
      {
        bool1 = bool2;
        if (this.mMultiImageRequests == null)
        {
          bool1 = bool2;
          if (this.mImageRequest == null)
          {
            bool1 = bool2;
            if (this.mLowResImageRequest != null);
          }
        }
      }
      else
      {
        bool1 = true;
      }
      Preconditions.checkState(bool1, "Cannot specify DataSourceSupplier with other ImageRequests! Use one or the other.");
      return;
    }
  }

  public static enum CacheLevel
  {
    static
    {
      DISK_CACHE = new CacheLevel("DISK_CACHE", 1);
      BITMAP_MEMORY_CACHE = new CacheLevel("BITMAP_MEMORY_CACHE", 2);
      $VALUES = new CacheLevel[] { FULL_FETCH, DISK_CACHE, BITMAP_MEMORY_CACHE };
    }
  }
}

/* Location:           C:\Users\c_jealom1\Documents\Scripts\Android\Fathom_com.brynk.fathom\Fathom_com.brynk.fathom-dex2jar.jar
 * Qualified Name:     com.facebook.drawee.controller.AbstractDraweeControllerBuilder
 * JD-Core Version:    0.6.0
 */
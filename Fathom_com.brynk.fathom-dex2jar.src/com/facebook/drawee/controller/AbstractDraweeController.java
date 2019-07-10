package com.facebook.drawee.controller;

import android.graphics.drawable.Animatable;
import android.graphics.drawable.Drawable;
import android.view.MotionEvent;
import com.facebook.common.internal.Objects;
import com.facebook.common.internal.Objects.ToStringHelper;
import com.facebook.common.internal.Preconditions;
import com.facebook.common.logging.FLog;
import com.facebook.datasource.BaseDataSubscriber;
import com.facebook.datasource.DataSource;
import com.facebook.datasource.DataSubscriber;
import com.facebook.drawee.components.DeferredReleaser;
import com.facebook.drawee.components.DeferredReleaser.Releasable;
import com.facebook.drawee.components.DraweeEventTracker;
import com.facebook.drawee.components.DraweeEventTracker.Event;
import com.facebook.drawee.components.RetryManager;
import com.facebook.drawee.gestures.GestureDetector;
import com.facebook.drawee.gestures.GestureDetector.ClickListener;
import com.facebook.drawee.interfaces.DraweeController;
import com.facebook.drawee.interfaces.DraweeHierarchy;
import com.facebook.drawee.interfaces.SettableDraweeHierarchy;
import java.util.concurrent.Executor;
import javax.annotation.Nullable;
import javax.annotation.concurrent.NotThreadSafe;

@NotThreadSafe
public abstract class AbstractDraweeController<T, INFO>
  implements DraweeController, DeferredReleaser.Releasable, GestureDetector.ClickListener
{
  private static final Class<?> TAG = AbstractDraweeController.class;
  private Object mCallerContext;

  @Nullable
  private String mContentDescription;

  @Nullable
  private ControllerListener<INFO> mControllerListener;

  @Nullable
  private Drawable mControllerOverlay;

  @Nullable
  private ControllerViewportVisibilityListener mControllerViewportVisibilityListener;

  @Nullable
  private DataSource<T> mDataSource;
  private final DeferredReleaser mDeferredReleaser;

  @Nullable
  private Drawable mDrawable;
  private final DraweeEventTracker mEventTracker = DraweeEventTracker.newInstance();

  @Nullable
  private T mFetchedImage;

  @Nullable
  private GestureDetector mGestureDetector;
  private boolean mHasFetchFailed;
  private String mId;
  private boolean mIsAttached;
  private boolean mIsRequestSubmitted;
  private boolean mIsVisibleInViewportHint;
  private boolean mRetainImageOnFailure;

  @Nullable
  private RetryManager mRetryManager;

  @Nullable
  private SettableDraweeHierarchy mSettableDraweeHierarchy;
  private final Executor mUiThreadImmediateExecutor;

  public AbstractDraweeController(DeferredReleaser paramDeferredReleaser, Executor paramExecutor, String paramString, Object paramObject)
  {
    this.mDeferredReleaser = paramDeferredReleaser;
    this.mUiThreadImmediateExecutor = paramExecutor;
    init(paramString, paramObject, true);
  }

  private void init(String paramString, Object paramObject, boolean paramBoolean)
  {
    this.mEventTracker.recordEvent(DraweeEventTracker.Event.ON_INIT_CONTROLLER);
    if ((!paramBoolean) && (this.mDeferredReleaser != null))
      this.mDeferredReleaser.cancelDeferredRelease(this);
    this.mIsAttached = false;
    this.mIsVisibleInViewportHint = false;
    releaseFetch();
    this.mRetainImageOnFailure = false;
    if (this.mRetryManager != null)
      this.mRetryManager.init();
    if (this.mGestureDetector != null)
    {
      this.mGestureDetector.init();
      this.mGestureDetector.setClickListener(this);
    }
    if ((this.mControllerListener instanceof InternalForwardingListener))
      ((InternalForwardingListener)this.mControllerListener).clearListeners();
    while (true)
    {
      this.mControllerViewportVisibilityListener = null;
      if (this.mSettableDraweeHierarchy != null)
      {
        this.mSettableDraweeHierarchy.reset();
        this.mSettableDraweeHierarchy.setControllerOverlay(null);
        this.mSettableDraweeHierarchy = null;
      }
      this.mControllerOverlay = null;
      if (FLog.isLoggable(2))
        FLog.v(TAG, "controller %x %s -> %s: initialize", Integer.valueOf(System.identityHashCode(this)), this.mId, paramString);
      this.mId = paramString;
      this.mCallerContext = paramObject;
      return;
      this.mControllerListener = null;
    }
  }

  private boolean isExpectedDataSource(String paramString, DataSource<T> paramDataSource)
  {
    if ((paramDataSource == null) && (this.mDataSource == null));
    do
      return true;
    while ((paramString.equals(this.mId)) && (paramDataSource == this.mDataSource) && (this.mIsRequestSubmitted));
    return false;
  }

  private void logMessageAndFailure(String paramString, Throwable paramThrowable)
  {
    if (FLog.isLoggable(2))
      FLog.v(TAG, "controller %x %s: %s: failure: %s", Integer.valueOf(System.identityHashCode(this)), this.mId, paramString, paramThrowable);
  }

  private void logMessageAndImage(String paramString, T paramT)
  {
    if (FLog.isLoggable(2))
      FLog.v(TAG, "controller %x %s: %s: image: %s %x", new Object[] { Integer.valueOf(System.identityHashCode(this)), this.mId, paramString, getImageClass(paramT), Integer.valueOf(getImageHash(paramT)) });
  }

  private void onFailureInternal(String paramString, DataSource<T> paramDataSource, Throwable paramThrowable, boolean paramBoolean)
  {
    if (!isExpectedDataSource(paramString, paramDataSource))
    {
      logMessageAndFailure("ignore_old_datasource @ onFailure", paramThrowable);
      paramDataSource.close();
      return;
    }
    paramDataSource = this.mEventTracker;
    if (paramBoolean)
    {
      paramString = DraweeEventTracker.Event.ON_DATASOURCE_FAILURE;
      paramDataSource.recordEvent(paramString);
      if (!paramBoolean)
        break label149;
      logMessageAndFailure("final_failed @ onFailure", paramThrowable);
      this.mDataSource = null;
      this.mHasFetchFailed = true;
      if ((!this.mRetainImageOnFailure) || (this.mDrawable == null))
        break label116;
      this.mSettableDraweeHierarchy.setImage(this.mDrawable, 1.0F, true);
    }
    while (true)
    {
      getControllerListener().onFailure(this.mId, paramThrowable);
      return;
      paramString = DraweeEventTracker.Event.ON_DATASOURCE_FAILURE_INT;
      break;
      label116: if (shouldRetryOnTap())
      {
        this.mSettableDraweeHierarchy.setRetry(paramThrowable);
        continue;
      }
      this.mSettableDraweeHierarchy.setFailure(paramThrowable);
    }
    label149: logMessageAndFailure("intermediate_failed @ onFailure", paramThrowable);
    getControllerListener().onIntermediateImageFailed(this.mId, paramThrowable);
  }

  // ERROR //
  private void onNewResultInternal(String paramString, DataSource<T> paramDataSource, @Nullable T paramT, float paramFloat, boolean paramBoolean1, boolean paramBoolean2)
  {
    // Byte code:
    //   0: aload_0
    //   1: aload_1
    //   2: aload_2
    //   3: invokespecial 226	com/facebook/drawee/controller/AbstractDraweeController:isExpectedDataSource	(Ljava/lang/String;Lcom/facebook/datasource/DataSource;)Z
    //   6: ifne +24 -> 30
    //   9: aload_0
    //   10: ldc_w 281
    //   13: aload_3
    //   14: invokespecial 283	com/facebook/drawee/controller/AbstractDraweeController:logMessageAndImage	(Ljava/lang/String;Ljava/lang/Object;)V
    //   17: aload_0
    //   18: aload_3
    //   19: invokevirtual 287	com/facebook/drawee/controller/AbstractDraweeController:releaseImage	(Ljava/lang/Object;)V
    //   22: aload_2
    //   23: invokeinterface 236 1 0
    //   28: pop
    //   29: return
    //   30: aload_0
    //   31: getfield 74	com/facebook/drawee/controller/AbstractDraweeController:mEventTracker	Lcom/facebook/drawee/components/DraweeEventTracker;
    //   34: astore 8
    //   36: iload 5
    //   38: ifeq +136 -> 174
    //   41: getstatic 290	com/facebook/drawee/components/DraweeEventTracker$Event:ON_DATASOURCE_RESULT	Lcom/facebook/drawee/components/DraweeEventTracker$Event;
    //   44: astore 7
    //   46: aload 8
    //   48: aload 7
    //   50: invokevirtual 110	com/facebook/drawee/components/DraweeEventTracker:recordEvent	(Lcom/facebook/drawee/components/DraweeEventTracker$Event;)V
    //   53: aload_0
    //   54: aload_3
    //   55: invokevirtual 294	com/facebook/drawee/controller/AbstractDraweeController:createDrawable	(Ljava/lang/Object;)Landroid/graphics/drawable/Drawable;
    //   58: astore 7
    //   60: aload_0
    //   61: getfield 296	com/facebook/drawee/controller/AbstractDraweeController:mFetchedImage	Ljava/lang/Object;
    //   64: astore_2
    //   65: aload_0
    //   66: getfield 245	com/facebook/drawee/controller/AbstractDraweeController:mDrawable	Landroid/graphics/drawable/Drawable;
    //   69: astore 8
    //   71: aload_0
    //   72: aload_3
    //   73: putfield 296	com/facebook/drawee/controller/AbstractDraweeController:mFetchedImage	Ljava/lang/Object;
    //   76: aload_0
    //   77: aload 7
    //   79: putfield 245	com/facebook/drawee/controller/AbstractDraweeController:mDrawable	Landroid/graphics/drawable/Drawable;
    //   82: iload 5
    //   84: ifeq +124 -> 208
    //   87: aload_0
    //   88: ldc_w 298
    //   91: aload_3
    //   92: invokespecial 283	com/facebook/drawee/controller/AbstractDraweeController:logMessageAndImage	(Ljava/lang/String;Ljava/lang/Object;)V
    //   95: aload_0
    //   96: aconst_null
    //   97: putfield 192	com/facebook/drawee/controller/AbstractDraweeController:mDataSource	Lcom/facebook/datasource/DataSource;
    //   100: aload_0
    //   101: getfield 149	com/facebook/drawee/controller/AbstractDraweeController:mSettableDraweeHierarchy	Lcom/facebook/drawee/interfaces/SettableDraweeHierarchy;
    //   104: aload 7
    //   106: fconst_1
    //   107: iload 6
    //   109: invokeinterface 249 4 0
    //   114: aload_0
    //   115: invokevirtual 253	com/facebook/drawee/controller/AbstractDraweeController:getControllerListener	()Lcom/facebook/drawee/controller/ControllerListener;
    //   118: aload_1
    //   119: aload_0
    //   120: aload_3
    //   121: invokevirtual 302	com/facebook/drawee/controller/AbstractDraweeController:getImageInfo	(Ljava/lang/Object;)Ljava/lang/Object;
    //   124: aload_0
    //   125: invokevirtual 306	com/facebook/drawee/controller/AbstractDraweeController:getAnimatable	()Landroid/graphics/drawable/Animatable;
    //   128: invokeinterface 310 4 0
    //   133: aload 8
    //   135: ifnull +16 -> 151
    //   138: aload 8
    //   140: aload 7
    //   142: if_acmpeq +9 -> 151
    //   145: aload_0
    //   146: aload 8
    //   148: invokevirtual 313	com/facebook/drawee/controller/AbstractDraweeController:releaseDrawable	(Landroid/graphics/drawable/Drawable;)V
    //   151: aload_2
    //   152: ifnull -123 -> 29
    //   155: aload_2
    //   156: aload_3
    //   157: if_acmpeq -128 -> 29
    //   160: aload_0
    //   161: ldc_w 315
    //   164: aload_2
    //   165: invokespecial 283	com/facebook/drawee/controller/AbstractDraweeController:logMessageAndImage	(Ljava/lang/String;Ljava/lang/Object;)V
    //   168: aload_0
    //   169: aload_2
    //   170: invokevirtual 287	com/facebook/drawee/controller/AbstractDraweeController:releaseImage	(Ljava/lang/Object;)V
    //   173: return
    //   174: getstatic 318	com/facebook/drawee/components/DraweeEventTracker$Event:ON_DATASOURCE_RESULT_INT	Lcom/facebook/drawee/components/DraweeEventTracker$Event;
    //   177: astore 7
    //   179: goto -133 -> 46
    //   182: astore 7
    //   184: aload_0
    //   185: ldc_w 320
    //   188: aload_3
    //   189: invokespecial 283	com/facebook/drawee/controller/AbstractDraweeController:logMessageAndImage	(Ljava/lang/String;Ljava/lang/Object;)V
    //   192: aload_0
    //   193: aload_3
    //   194: invokevirtual 287	com/facebook/drawee/controller/AbstractDraweeController:releaseImage	(Ljava/lang/Object;)V
    //   197: aload_0
    //   198: aload_1
    //   199: aload_2
    //   200: aload 7
    //   202: iload 5
    //   204: invokespecial 94	com/facebook/drawee/controller/AbstractDraweeController:onFailureInternal	(Ljava/lang/String;Lcom/facebook/datasource/DataSource;Ljava/lang/Throwable;Z)V
    //   207: return
    //   208: aload_0
    //   209: ldc_w 322
    //   212: aload_3
    //   213: invokespecial 283	com/facebook/drawee/controller/AbstractDraweeController:logMessageAndImage	(Ljava/lang/String;Ljava/lang/Object;)V
    //   216: aload_0
    //   217: getfield 149	com/facebook/drawee/controller/AbstractDraweeController:mSettableDraweeHierarchy	Lcom/facebook/drawee/interfaces/SettableDraweeHierarchy;
    //   220: aload 7
    //   222: fload 4
    //   224: iload 6
    //   226: invokeinterface 249 4 0
    //   231: aload_0
    //   232: invokevirtual 253	com/facebook/drawee/controller/AbstractDraweeController:getControllerListener	()Lcom/facebook/drawee/controller/ControllerListener;
    //   235: aload_1
    //   236: aload_0
    //   237: aload_3
    //   238: invokevirtual 302	com/facebook/drawee/controller/AbstractDraweeController:getImageInfo	(Ljava/lang/Object;)Ljava/lang/Object;
    //   241: invokeinterface 325 3 0
    //   246: goto -113 -> 133
    //   249: astore_1
    //   250: aload 8
    //   252: ifnull +16 -> 268
    //   255: aload 8
    //   257: aload 7
    //   259: if_acmpeq +9 -> 268
    //   262: aload_0
    //   263: aload 8
    //   265: invokevirtual 313	com/facebook/drawee/controller/AbstractDraweeController:releaseDrawable	(Landroid/graphics/drawable/Drawable;)V
    //   268: aload_2
    //   269: ifnull +21 -> 290
    //   272: aload_2
    //   273: aload_3
    //   274: if_acmpeq +16 -> 290
    //   277: aload_0
    //   278: ldc_w 315
    //   281: aload_2
    //   282: invokespecial 283	com/facebook/drawee/controller/AbstractDraweeController:logMessageAndImage	(Ljava/lang/String;Ljava/lang/Object;)V
    //   285: aload_0
    //   286: aload_2
    //   287: invokevirtual 287	com/facebook/drawee/controller/AbstractDraweeController:releaseImage	(Ljava/lang/Object;)V
    //   290: aload_1
    //   291: athrow
    //
    // Exception table:
    //   from	to	target	type
    //   53	60	182	java/lang/Exception
    //   87	133	249	finally
    //   208	246	249	finally
  }

  private void onProgressUpdateInternal(String paramString, DataSource<T> paramDataSource, float paramFloat, boolean paramBoolean)
  {
    if (!isExpectedDataSource(paramString, paramDataSource))
    {
      logMessageAndFailure("ignore_old_datasource @ onProgress", null);
      paramDataSource.close();
    }
    do
      return;
    while (paramBoolean);
    this.mSettableDraweeHierarchy.setProgress(paramFloat, false);
  }

  private void releaseFetch()
  {
    boolean bool = this.mIsRequestSubmitted;
    this.mIsRequestSubmitted = false;
    this.mHasFetchFailed = false;
    if (this.mDataSource != null)
    {
      this.mDataSource.close();
      this.mDataSource = null;
    }
    if (this.mDrawable != null)
      releaseDrawable(this.mDrawable);
    if (this.mContentDescription != null)
      this.mContentDescription = null;
    this.mDrawable = null;
    if (this.mFetchedImage != null)
    {
      logMessageAndImage("release", this.mFetchedImage);
      releaseImage(this.mFetchedImage);
      this.mFetchedImage = null;
    }
    if (bool)
      getControllerListener().onRelease(this.mId);
  }

  private boolean shouldRetryOnTap()
  {
    return (this.mHasFetchFailed) && (this.mRetryManager != null) && (this.mRetryManager.shouldRetryOnTap());
  }

  public void addControllerListener(ControllerListener<? super INFO> paramControllerListener)
  {
    Preconditions.checkNotNull(paramControllerListener);
    if ((this.mControllerListener instanceof InternalForwardingListener))
    {
      ((InternalForwardingListener)this.mControllerListener).addListener(paramControllerListener);
      return;
    }
    if (this.mControllerListener != null)
    {
      this.mControllerListener = InternalForwardingListener.createInternal(this.mControllerListener, paramControllerListener);
      return;
    }
    this.mControllerListener = paramControllerListener;
  }

  protected abstract Drawable createDrawable(T paramT);

  @Nullable
  public Animatable getAnimatable()
  {
    if ((this.mDrawable instanceof Animatable))
      return (Animatable)this.mDrawable;
    return null;
  }

  protected T getCachedImage()
  {
    return null;
  }

  public Object getCallerContext()
  {
    return this.mCallerContext;
  }

  @Nullable
  public String getContentDescription()
  {
    return this.mContentDescription;
  }

  protected ControllerListener<INFO> getControllerListener()
  {
    if (this.mControllerListener == null)
      return BaseControllerListener.getNoOpListener();
    return this.mControllerListener;
  }

  @Nullable
  protected Drawable getControllerOverlay()
  {
    return this.mControllerOverlay;
  }

  protected abstract DataSource<T> getDataSource();

  @Nullable
  protected GestureDetector getGestureDetector()
  {
    return this.mGestureDetector;
  }

  @Nullable
  public DraweeHierarchy getHierarchy()
  {
    return this.mSettableDraweeHierarchy;
  }

  public String getId()
  {
    return this.mId;
  }

  protected String getImageClass(@Nullable T paramT)
  {
    if (paramT != null)
      return paramT.getClass().getSimpleName();
    return "<null>";
  }

  protected int getImageHash(@Nullable T paramT)
  {
    return System.identityHashCode(paramT);
  }

  @Nullable
  protected abstract INFO getImageInfo(T paramT);

  @Nullable
  protected RetryManager getRetryManager()
  {
    return this.mRetryManager;
  }

  protected void initialize(String paramString, Object paramObject)
  {
    init(paramString, paramObject, false);
  }

  public void onAttach()
  {
    Class localClass;
    int i;
    String str2;
    if (FLog.isLoggable(2))
    {
      localClass = TAG;
      i = System.identityHashCode(this);
      str2 = this.mId;
      if (!this.mIsRequestSubmitted)
        break label90;
    }
    label90: for (String str1 = "request already submitted"; ; str1 = "request needs submit")
    {
      FLog.v(localClass, "controller %x %s: onAttach: %s", Integer.valueOf(i), str2, str1);
      this.mEventTracker.recordEvent(DraweeEventTracker.Event.ON_ATTACH_CONTROLLER);
      Preconditions.checkNotNull(this.mSettableDraweeHierarchy);
      this.mDeferredReleaser.cancelDeferredRelease(this);
      this.mIsAttached = true;
      if (!this.mIsRequestSubmitted)
        submitRequest();
      return;
    }
  }

  public boolean onClick()
  {
    if (FLog.isLoggable(2))
      FLog.v(TAG, "controller %x %s: onClick", Integer.valueOf(System.identityHashCode(this)), this.mId);
    if (shouldRetryOnTap())
    {
      this.mRetryManager.notifyTapToRetry();
      this.mSettableDraweeHierarchy.reset();
      submitRequest();
      return true;
    }
    return false;
  }

  public void onDetach()
  {
    if (FLog.isLoggable(2))
      FLog.v(TAG, "controller %x %s: onDetach", Integer.valueOf(System.identityHashCode(this)), this.mId);
    this.mEventTracker.recordEvent(DraweeEventTracker.Event.ON_DETACH_CONTROLLER);
    this.mIsAttached = false;
    this.mDeferredReleaser.scheduleDeferredRelease(this);
  }

  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    if (FLog.isLoggable(2))
      FLog.v(TAG, "controller %x %s: onTouchEvent %s", Integer.valueOf(System.identityHashCode(this)), this.mId, paramMotionEvent);
    if (this.mGestureDetector == null);
    do
      return false;
    while ((!this.mGestureDetector.isCapturingGesture()) && (!shouldHandleGesture()));
    this.mGestureDetector.onTouchEvent(paramMotionEvent);
    return true;
  }

  public void onViewportVisibilityHint(boolean paramBoolean)
  {
    ControllerViewportVisibilityListener localControllerViewportVisibilityListener = this.mControllerViewportVisibilityListener;
    if (localControllerViewportVisibilityListener != null)
    {
      if ((!paramBoolean) || (this.mIsVisibleInViewportHint))
        break label36;
      localControllerViewportVisibilityListener.onDraweeViewportEntry(this.mId);
    }
    while (true)
    {
      this.mIsVisibleInViewportHint = paramBoolean;
      return;
      label36: if ((paramBoolean) || (!this.mIsVisibleInViewportHint))
        continue;
      localControllerViewportVisibilityListener.onDraweeViewportExit(this.mId);
    }
  }

  public void release()
  {
    this.mEventTracker.recordEvent(DraweeEventTracker.Event.ON_RELEASE_CONTROLLER);
    if (this.mRetryManager != null)
      this.mRetryManager.reset();
    if (this.mGestureDetector != null)
      this.mGestureDetector.reset();
    if (this.mSettableDraweeHierarchy != null)
      this.mSettableDraweeHierarchy.reset();
    releaseFetch();
  }

  protected abstract void releaseDrawable(@Nullable Drawable paramDrawable);

  protected abstract void releaseImage(@Nullable T paramT);

  public void removeControllerListener(ControllerListener<? super INFO> paramControllerListener)
  {
    Preconditions.checkNotNull(paramControllerListener);
    if ((this.mControllerListener instanceof InternalForwardingListener))
      ((InternalForwardingListener)this.mControllerListener).removeListener(paramControllerListener);
    do
      return;
    while (this.mControllerListener != paramControllerListener);
    this.mControllerListener = null;
  }

  public void setContentDescription(@Nullable String paramString)
  {
    this.mContentDescription = paramString;
  }

  protected void setControllerOverlay(@Nullable Drawable paramDrawable)
  {
    this.mControllerOverlay = paramDrawable;
    if (this.mSettableDraweeHierarchy != null)
      this.mSettableDraweeHierarchy.setControllerOverlay(this.mControllerOverlay);
  }

  public void setControllerViewportVisibilityListener(@Nullable ControllerViewportVisibilityListener paramControllerViewportVisibilityListener)
  {
    this.mControllerViewportVisibilityListener = paramControllerViewportVisibilityListener;
  }

  protected void setGestureDetector(@Nullable GestureDetector paramGestureDetector)
  {
    this.mGestureDetector = paramGestureDetector;
    if (this.mGestureDetector != null)
      this.mGestureDetector.setClickListener(this);
  }

  public void setHierarchy(@Nullable DraweeHierarchy paramDraweeHierarchy)
  {
    if (FLog.isLoggable(2))
      FLog.v(TAG, "controller %x %s: setHierarchy: %s", Integer.valueOf(System.identityHashCode(this)), this.mId, paramDraweeHierarchy);
    DraweeEventTracker localDraweeEventTracker = this.mEventTracker;
    if (paramDraweeHierarchy != null);
    for (DraweeEventTracker.Event localEvent = DraweeEventTracker.Event.ON_SET_HIERARCHY; ; localEvent = DraweeEventTracker.Event.ON_CLEAR_HIERARCHY)
    {
      localDraweeEventTracker.recordEvent(localEvent);
      if (this.mIsRequestSubmitted)
      {
        this.mDeferredReleaser.cancelDeferredRelease(this);
        release();
      }
      if (this.mSettableDraweeHierarchy != null)
      {
        this.mSettableDraweeHierarchy.setControllerOverlay(null);
        this.mSettableDraweeHierarchy = null;
      }
      if (paramDraweeHierarchy != null)
      {
        Preconditions.checkArgument(paramDraweeHierarchy instanceof SettableDraweeHierarchy);
        this.mSettableDraweeHierarchy = ((SettableDraweeHierarchy)paramDraweeHierarchy);
        this.mSettableDraweeHierarchy.setControllerOverlay(this.mControllerOverlay);
      }
      return;
    }
  }

  protected void setRetainImageOnFailure(boolean paramBoolean)
  {
    this.mRetainImageOnFailure = paramBoolean;
  }

  protected void setRetryManager(@Nullable RetryManager paramRetryManager)
  {
    this.mRetryManager = paramRetryManager;
  }

  protected boolean shouldHandleGesture()
  {
    return shouldRetryOnTap();
  }

  protected void submitRequest()
  {
    Object localObject = getCachedImage();
    if (localObject != null)
    {
      this.mDataSource = null;
      this.mIsRequestSubmitted = true;
      this.mHasFetchFailed = false;
      this.mEventTracker.recordEvent(DraweeEventTracker.Event.ON_SUBMIT_CACHE_HIT);
      getControllerListener().onSubmit(this.mId, this.mCallerContext);
      onNewResultInternal(this.mId, this.mDataSource, localObject, 1.0F, true, true);
      return;
    }
    this.mEventTracker.recordEvent(DraweeEventTracker.Event.ON_DATASOURCE_SUBMIT);
    getControllerListener().onSubmit(this.mId, this.mCallerContext);
    this.mSettableDraweeHierarchy.setProgress(0.0F, true);
    this.mIsRequestSubmitted = true;
    this.mHasFetchFailed = false;
    this.mDataSource = getDataSource();
    if (FLog.isLoggable(2))
      FLog.v(TAG, "controller %x %s: submitRequest: dataSource: %x", Integer.valueOf(System.identityHashCode(this)), this.mId, Integer.valueOf(System.identityHashCode(this.mDataSource)));
    localObject = new BaseDataSubscriber(this.mId, this.mDataSource.hasResult())
    {
      public void onFailureImpl(DataSource<T> paramDataSource)
      {
        AbstractDraweeController.this.onFailureInternal(this.val$id, paramDataSource, paramDataSource.getFailureCause(), true);
      }

      public void onNewResultImpl(DataSource<T> paramDataSource)
      {
        boolean bool = paramDataSource.isFinished();
        float f = paramDataSource.getProgress();
        Object localObject = paramDataSource.getResult();
        if (localObject != null)
          AbstractDraweeController.this.onNewResultInternal(this.val$id, paramDataSource, localObject, f, bool, this.val$wasImmediate);
        do
          return;
        while (!bool);
        AbstractDraweeController.this.onFailureInternal(this.val$id, paramDataSource, new NullPointerException(), true);
      }

      public void onProgressUpdate(DataSource<T> paramDataSource)
      {
        boolean bool = paramDataSource.isFinished();
        float f = paramDataSource.getProgress();
        AbstractDraweeController.this.onProgressUpdateInternal(this.val$id, paramDataSource, f, bool);
      }
    };
    this.mDataSource.subscribe((DataSubscriber)localObject, this.mUiThreadImmediateExecutor);
  }

  public String toString()
  {
    return Objects.toStringHelper(this).add("isAttached", this.mIsAttached).add("isRequestSubmitted", this.mIsRequestSubmitted).add("hasFetchFailed", this.mHasFetchFailed).add("fetchedImage", getImageHash(this.mFetchedImage)).add("events", this.mEventTracker.toString()).toString();
  }

  private static class InternalForwardingListener<INFO> extends ForwardingControllerListener<INFO>
  {
    public static <INFO> InternalForwardingListener<INFO> createInternal(ControllerListener<? super INFO> paramControllerListener1, ControllerListener<? super INFO> paramControllerListener2)
    {
      InternalForwardingListener localInternalForwardingListener = new InternalForwardingListener();
      localInternalForwardingListener.addListener(paramControllerListener1);
      localInternalForwardingListener.addListener(paramControllerListener2);
      return localInternalForwardingListener;
    }
  }
}

/* Location:           C:\Users\c_jealom1\Documents\Scripts\Android\Fathom_com.brynk.fathom\Fathom_com.brynk.fathom-dex2jar.jar
 * Qualified Name:     com.facebook.drawee.controller.AbstractDraweeController
 * JD-Core Version:    0.6.0
 */
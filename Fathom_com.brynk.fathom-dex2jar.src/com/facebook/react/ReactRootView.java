package com.facebook.react;

import android.content.Context;
import android.graphics.Rect;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewParent;
import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import android.view.WindowManager;
import com.facebook.common.logging.FLog;
import com.facebook.infer.annotation.Assertions;
import com.facebook.react.bridge.Arguments;
import com.facebook.react.bridge.CatalystInstance;
import com.facebook.react.bridge.GuardedRunnable;
import com.facebook.react.bridge.ReactContext;
import com.facebook.react.bridge.ReactMarker;
import com.facebook.react.bridge.ReactMarkerConstants;
import com.facebook.react.bridge.UiThreadUtil;
import com.facebook.react.bridge.WritableMap;
import com.facebook.react.bridge.WritableNativeMap;
import com.facebook.react.common.annotations.VisibleForTesting;
import com.facebook.react.modules.appregistry.AppRegistry;
import com.facebook.react.modules.core.DeviceEventManagerModule.RCTDeviceEventEmitter;
import com.facebook.react.modules.deviceinfo.DeviceInfoModule;
import com.facebook.react.uimanager.DisplayMetricsHolder;
import com.facebook.react.uimanager.JSTouchDispatcher;
import com.facebook.react.uimanager.MeasureSpecProvider;
import com.facebook.react.uimanager.PixelUtil;
import com.facebook.react.uimanager.RootView;
import com.facebook.react.uimanager.SizeMonitoringFrameLayout;
import com.facebook.react.uimanager.UIImplementation;
import com.facebook.react.uimanager.UIManagerModule;
import com.facebook.react.uimanager.events.EventDispatcher;
import com.facebook.systrace.Systrace;
import javax.annotation.Nullable;

public class ReactRootView extends SizeMonitoringFrameLayout
  implements RootView, MeasureSpecProvider
{

  @Nullable
  private Bundle mAppProperties;

  @Nullable
  private CustomGlobalLayoutListener mCustomGlobalLayoutListener;
  private int mHeightMeasureSpec = View.MeasureSpec.makeMeasureSpec(0, 0);
  private boolean mIsAttachedToInstance;

  @Nullable
  private String mJSModuleName;
  private final JSTouchDispatcher mJSTouchDispatcher = new JSTouchDispatcher(this);

  @Nullable
  private ReactInstanceManager mReactInstanceManager;

  @Nullable
  private ReactRootViewEventListener mRootViewEventListener;
  private int mRootViewTag;
  private boolean mShouldLogContentAppeared;
  private boolean mWasMeasured = false;
  private int mWidthMeasureSpec = View.MeasureSpec.makeMeasureSpec(0, 0);

  public ReactRootView(Context paramContext)
  {
    super(paramContext);
  }

  public ReactRootView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }

  public ReactRootView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
  }

  private void attachToReactInstanceManager()
  {
    Systrace.beginSection(0L, "attachToReactInstanceManager");
    try
    {
      boolean bool = this.mIsAttachedToInstance;
      if (bool)
        return;
      this.mIsAttachedToInstance = true;
      ((ReactInstanceManager)Assertions.assertNotNull(this.mReactInstanceManager)).attachRootView(this);
      getViewTreeObserver().addOnGlobalLayoutListener(getCustomGlobalLayoutListener());
      return;
    }
    finally
    {
      Systrace.endSection(0L);
    }
    throw localObject;
  }

  private void dispatchJSTouchEvent(MotionEvent paramMotionEvent)
  {
    if ((this.mReactInstanceManager == null) || (!this.mIsAttachedToInstance) || (this.mReactInstanceManager.getCurrentReactContext() == null))
    {
      FLog.w("ReactNative", "Unable to dispatch touch to JS as the catalyst instance has not been attached");
      return;
    }
    EventDispatcher localEventDispatcher = ((UIManagerModule)this.mReactInstanceManager.getCurrentReactContext().getNativeModule(UIManagerModule.class)).getEventDispatcher();
    this.mJSTouchDispatcher.handleTouchEvent(paramMotionEvent, localEventDispatcher);
  }

  private void enableLayoutCalculation()
  {
    if (this.mReactInstanceManager == null)
      FLog.w("ReactNative", "Unable to enable layout calculation for uninitialized ReactInstanceManager");
    ReactContext localReactContext;
    do
    {
      return;
      localReactContext = this.mReactInstanceManager.getCurrentReactContext();
    }
    while (localReactContext == null);
    ((UIManagerModule)localReactContext.getCatalystInstance().getNativeModule(UIManagerModule.class)).getUIImplementation().enableLayoutCalculationForRootNode(getRootViewTag());
  }

  private CustomGlobalLayoutListener getCustomGlobalLayoutListener()
  {
    if (this.mCustomGlobalLayoutListener == null)
      this.mCustomGlobalLayoutListener = new CustomGlobalLayoutListener();
    return this.mCustomGlobalLayoutListener;
  }

  private void updateRootLayoutSpecs(int paramInt1, int paramInt2)
  {
    if (this.mReactInstanceManager == null)
      FLog.w("ReactNative", "Unable to update root layout specs for uninitialized ReactInstanceManager");
    ReactContext localReactContext;
    do
    {
      return;
      localReactContext = this.mReactInstanceManager.getCurrentReactContext();
    }
    while (localReactContext == null);
    localReactContext.runUIBackgroundRunnable(new GuardedRunnable(localReactContext, localReactContext, paramInt1, paramInt2)
    {
      public void runGuarded()
      {
        ((UIManagerModule)this.val$reactApplicationContext.getCatalystInstance().getNativeModule(UIManagerModule.class)).updateRootLayoutSpecs(ReactRootView.this.getRootViewTag(), this.val$widthMeasureSpec, this.val$heightMeasureSpec);
      }
    });
  }

  protected void finalize()
    throws Throwable
  {
    super.finalize();
    if (!this.mIsAttachedToInstance);
    for (boolean bool = true; ; bool = false)
    {
      Assertions.assertCondition(bool, "The application this ReactRootView was rendering was not unmounted before the ReactRootView was garbage collected. This usually means that your application is leaking large amounts of memory. To solve this, make sure to call ReactRootView#unmountReactApplication in the onDestroy() of your hosting Activity or in the onDestroyView() of your hosting Fragment.");
      return;
    }
  }

  @Nullable
  public Bundle getAppProperties()
  {
    return this.mAppProperties;
  }

  public int getHeightMeasureSpec()
  {
    if ((!this.mWasMeasured) && (getLayoutParams() != null) && (getLayoutParams().height > 0))
      return View.MeasureSpec.makeMeasureSpec(getLayoutParams().height, 1073741824);
    return this.mHeightMeasureSpec;
  }

  String getJSModuleName()
  {
    return (String)Assertions.assertNotNull(this.mJSModuleName);
  }

  public int getRootViewTag()
  {
    return this.mRootViewTag;
  }

  public int getWidthMeasureSpec()
  {
    if ((!this.mWasMeasured) && (getLayoutParams() != null) && (getLayoutParams().width > 0))
      return View.MeasureSpec.makeMeasureSpec(getLayoutParams().width, 1073741824);
    return this.mWidthMeasureSpec;
  }

  public void onAttachedToReactInstance()
  {
    if (this.mRootViewEventListener != null)
      this.mRootViewEventListener.onAttachedToReactInstance(this);
  }

  protected void onAttachedToWindow()
  {
    super.onAttachedToWindow();
    if (this.mIsAttachedToInstance)
      getViewTreeObserver().addOnGlobalLayoutListener(getCustomGlobalLayoutListener());
  }

  public void onChildStartedNativeGesture(MotionEvent paramMotionEvent)
  {
    if ((this.mReactInstanceManager == null) || (!this.mIsAttachedToInstance) || (this.mReactInstanceManager.getCurrentReactContext() == null))
    {
      FLog.w("ReactNative", "Unable to dispatch touch to JS as the catalyst instance has not been attached");
      return;
    }
    EventDispatcher localEventDispatcher = ((UIManagerModule)this.mReactInstanceManager.getCurrentReactContext().getNativeModule(UIManagerModule.class)).getEventDispatcher();
    this.mJSTouchDispatcher.onChildStartedNativeGesture(paramMotionEvent, localEventDispatcher);
  }

  protected void onDetachedFromWindow()
  {
    super.onDetachedFromWindow();
    if (this.mIsAttachedToInstance)
    {
      if (Build.VERSION.SDK_INT >= 16)
        getViewTreeObserver().removeOnGlobalLayoutListener(getCustomGlobalLayoutListener());
    }
    else
      return;
    getViewTreeObserver().removeGlobalOnLayoutListener(getCustomGlobalLayoutListener());
  }

  public boolean onInterceptTouchEvent(MotionEvent paramMotionEvent)
  {
    dispatchJSTouchEvent(paramMotionEvent);
    return super.onInterceptTouchEvent(paramMotionEvent);
  }

  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
  }

  protected void onMeasure(int paramInt1, int paramInt2)
  {
    Systrace.beginSection(0L, "ReactRootView.onMeasure");
    while (true)
    {
      int i;
      int k;
      try
      {
        this.mWidthMeasureSpec = paramInt1;
        this.mHeightMeasureSpec = paramInt2;
        i = 0;
        k = 0;
        j = View.MeasureSpec.getMode(paramInt1);
        if (j != -2147483648)
        {
          if (j != 0)
            continue;
          break label246;
          i = paramInt1;
          if (j >= getChildCount())
            continue;
          View localView = getChildAt(j);
          paramInt1 = Math.max(paramInt1, localView.getLeft() + localView.getMeasuredWidth() + localView.getPaddingLeft() + localView.getPaddingRight());
          j += 1;
          continue;
          i = View.MeasureSpec.getSize(paramInt1);
          paramInt1 = View.MeasureSpec.getMode(paramInt2);
          if (paramInt1 == -2147483648)
            break label254;
          if (paramInt1 != 0)
            continue;
          break label254;
          j = paramInt1;
          if (paramInt2 >= getChildCount())
            continue;
          localView = getChildAt(paramInt2);
          paramInt1 = Math.max(paramInt1, localView.getTop() + localView.getMeasuredHeight() + localView.getPaddingTop() + localView.getPaddingBottom());
          paramInt2 += 1;
          continue;
          j = View.MeasureSpec.getSize(paramInt2);
          setMeasuredDimension(i, j);
          this.mWasMeasured = true;
          if ((this.mReactInstanceManager == null) || (this.mIsAttachedToInstance))
            continue;
          attachToReactInstanceManager();
          enableLayoutCalculation();
          return;
          updateRootLayoutSpecs(this.mWidthMeasureSpec, this.mHeightMeasureSpec);
          continue;
        }
      }
      finally
      {
        Systrace.endSection(0L);
      }
      label246: int j = 0;
      paramInt1 = i;
      continue;
      label254: paramInt2 = 0;
      paramInt1 = k;
    }
  }

  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    dispatchJSTouchEvent(paramMotionEvent);
    super.onTouchEvent(paramMotionEvent);
    return true;
  }

  public void onViewAdded(View paramView)
  {
    super.onViewAdded(paramView);
    if (this.mShouldLogContentAppeared)
    {
      this.mShouldLogContentAppeared = false;
      if (this.mJSModuleName != null)
        ReactMarker.logMarker(ReactMarkerConstants.CONTENT_APPEARED, this.mJSModuleName, this.mRootViewTag);
    }
  }

  public void requestDisallowInterceptTouchEvent(boolean paramBoolean)
  {
    if (getParent() != null)
      getParent().requestDisallowInterceptTouchEvent(paramBoolean);
  }

  void runApplication()
  {
    Systrace.beginSection(0L, "ReactRootView.runApplication");
    try
    {
      if (this.mReactInstanceManager != null)
      {
        boolean bool = this.mIsAttachedToInstance;
        if (bool);
      }
      else
      {
        return;
      }
      Object localObject1 = this.mReactInstanceManager.getCurrentReactContext();
      if (localObject1 == null)
        return;
      localObject1 = ((ReactContext)localObject1).getCatalystInstance();
      WritableNativeMap localWritableNativeMap = new WritableNativeMap();
      localWritableNativeMap.putDouble("rootTag", getRootViewTag());
      Object localObject3 = getAppProperties();
      if (localObject3 != null)
        localWritableNativeMap.putMap("initialProps", Arguments.fromBundle((Bundle)localObject3));
      this.mShouldLogContentAppeared = true;
      localObject3 = getJSModuleName();
      ((AppRegistry)((CatalystInstance)localObject1).getJSModule(AppRegistry.class)).runApplication((String)localObject3, localWritableNativeMap);
      return;
    }
    finally
    {
      Systrace.endSection(0L);
    }
    throw localObject2;
  }

  public void setAppProperties(@Nullable Bundle paramBundle)
  {
    UiThreadUtil.assertOnUiThread();
    this.mAppProperties = paramBundle;
    if (getRootViewTag() != 0)
      runApplication();
  }

  public void setEventListener(ReactRootViewEventListener paramReactRootViewEventListener)
  {
    this.mRootViewEventListener = paramReactRootViewEventListener;
  }

  public void setRootViewTag(int paramInt)
  {
    this.mRootViewTag = paramInt;
  }

  @VisibleForTesting
  void simulateAttachForTesting()
  {
    this.mIsAttachedToInstance = true;
  }

  public void startReactApplication(ReactInstanceManager paramReactInstanceManager, String paramString)
  {
    startReactApplication(paramReactInstanceManager, paramString, null);
  }

  public void startReactApplication(ReactInstanceManager paramReactInstanceManager, String paramString, @Nullable Bundle paramBundle)
  {
    Systrace.beginSection(0L, "startReactApplication");
    try
    {
      UiThreadUtil.assertOnUiThread();
      if (this.mReactInstanceManager == null);
      for (boolean bool = true; ; bool = false)
      {
        Assertions.assertCondition(bool, "This root view has already been attached to a catalyst instance manager");
        this.mReactInstanceManager = paramReactInstanceManager;
        this.mJSModuleName = paramString;
        this.mAppProperties = paramBundle;
        if (!this.mReactInstanceManager.hasStartedCreatingInitialContext())
          this.mReactInstanceManager.createReactContextInBackground();
        attachToReactInstanceManager();
        return;
      }
    }
    finally
    {
      Systrace.endSection(0L);
    }
    throw paramReactInstanceManager;
  }

  public void unmountReactApplication()
  {
    if ((this.mReactInstanceManager != null) && (this.mIsAttachedToInstance))
    {
      this.mReactInstanceManager.detachRootView(this);
      this.mIsAttachedToInstance = false;
    }
    this.mShouldLogContentAppeared = false;
  }

  private class CustomGlobalLayoutListener
    implements ViewTreeObserver.OnGlobalLayoutListener
  {
    private int mDeviceRotation = 0;
    private int mKeyboardHeight = 0;
    private final int mMinKeyboardHeightDetected;
    private DisplayMetrics mScreenMetrics = new DisplayMetrics();
    private final Rect mVisibleViewArea;
    private DisplayMetrics mWindowMetrics = new DisplayMetrics();

    CustomGlobalLayoutListener()
    {
      DisplayMetricsHolder.initDisplayMetricsIfNotInitialized(ReactRootView.this.getContext().getApplicationContext());
      this.mVisibleViewArea = new Rect();
      this.mMinKeyboardHeightDetected = (int)PixelUtil.toPixelFromDIP(60.0F);
    }

    private boolean areMetricsEqual(DisplayMetrics paramDisplayMetrics1, DisplayMetrics paramDisplayMetrics2)
    {
      if (Build.VERSION.SDK_INT >= 17)
        return paramDisplayMetrics1.equals(paramDisplayMetrics2);
      return (paramDisplayMetrics1.widthPixels == paramDisplayMetrics2.widthPixels) && (paramDisplayMetrics1.heightPixels == paramDisplayMetrics2.heightPixels) && (paramDisplayMetrics1.density == paramDisplayMetrics2.density) && (paramDisplayMetrics1.densityDpi == paramDisplayMetrics2.densityDpi) && (paramDisplayMetrics1.scaledDensity == paramDisplayMetrics2.scaledDensity) && (paramDisplayMetrics1.xdpi == paramDisplayMetrics2.xdpi) && (paramDisplayMetrics1.ydpi == paramDisplayMetrics2.ydpi);
    }

    private void checkForDeviceDimensionsChanges()
    {
      DisplayMetricsHolder.initDisplayMetrics(ReactRootView.this.getContext());
      if ((!areMetricsEqual(this.mWindowMetrics, DisplayMetricsHolder.getWindowDisplayMetrics())) || (!areMetricsEqual(this.mScreenMetrics, DisplayMetricsHolder.getScreenDisplayMetrics())))
      {
        this.mWindowMetrics.setTo(DisplayMetricsHolder.getWindowDisplayMetrics());
        this.mScreenMetrics.setTo(DisplayMetricsHolder.getScreenDisplayMetrics());
        emitUpdateDimensionsEvent();
      }
    }

    private void checkForDeviceOrientationChanges()
    {
      int i = ((WindowManager)ReactRootView.this.getContext().getSystemService("window")).getDefaultDisplay().getRotation();
      if (this.mDeviceRotation == i)
        return;
      this.mDeviceRotation = i;
      emitOrientationChanged(i);
    }

    private void checkForKeyboardEvents()
    {
      ReactRootView.this.getRootView().getWindowVisibleDisplayFrame(this.mVisibleViewArea);
      int i = DisplayMetricsHolder.getWindowDisplayMetrics().heightPixels - this.mVisibleViewArea.bottom;
      if ((this.mKeyboardHeight != i) && (i > this.mMinKeyboardHeightDetected))
      {
        this.mKeyboardHeight = i;
        WritableMap localWritableMap1 = Arguments.createMap();
        WritableMap localWritableMap2 = Arguments.createMap();
        localWritableMap2.putDouble("screenY", PixelUtil.toDIPFromPixel(this.mVisibleViewArea.bottom));
        localWritableMap2.putDouble("screenX", PixelUtil.toDIPFromPixel(this.mVisibleViewArea.left));
        localWritableMap2.putDouble("width", PixelUtil.toDIPFromPixel(this.mVisibleViewArea.width()));
        localWritableMap2.putDouble("height", PixelUtil.toDIPFromPixel(this.mKeyboardHeight));
        localWritableMap1.putMap("endCoordinates", localWritableMap2);
        sendEvent("keyboardDidShow", localWritableMap1);
      }
      do
        return;
      while ((this.mKeyboardHeight == 0) || (i > this.mMinKeyboardHeightDetected));
      this.mKeyboardHeight = 0;
      sendEvent("keyboardDidHide", null);
    }

    private void emitOrientationChanged(int paramInt)
    {
      boolean bool = false;
      String str;
      double d;
      switch (paramInt)
      {
      default:
        return;
      case 0:
        str = "portrait-primary";
        d = 0.0D;
      case 1:
      case 2:
      case 3:
      }
      while (true)
      {
        WritableMap localWritableMap = Arguments.createMap();
        localWritableMap.putString("name", str);
        localWritableMap.putDouble("rotationDegrees", d);
        localWritableMap.putBoolean("isLandscape", bool);
        sendEvent("namedOrientationDidChange", localWritableMap);
        return;
        str = "landscape-primary";
        d = -90.0D;
        bool = true;
        continue;
        str = "portrait-secondary";
        d = 180.0D;
        continue;
        str = "landscape-secondary";
        d = 90.0D;
        bool = true;
      }
    }

    private void emitUpdateDimensionsEvent()
    {
      ((DeviceInfoModule)ReactRootView.this.mReactInstanceManager.getCurrentReactContext().getNativeModule(DeviceInfoModule.class)).emitUpdateDimensionsEvent();
    }

    private void sendEvent(String paramString, @Nullable WritableMap paramWritableMap)
    {
      if (ReactRootView.this.mReactInstanceManager != null)
        ((DeviceEventManagerModule.RCTDeviceEventEmitter)ReactRootView.this.mReactInstanceManager.getCurrentReactContext().getJSModule(DeviceEventManagerModule.RCTDeviceEventEmitter.class)).emit(paramString, paramWritableMap);
    }

    public void onGlobalLayout()
    {
      if ((ReactRootView.this.mReactInstanceManager == null) || (!ReactRootView.this.mIsAttachedToInstance) || (ReactRootView.this.mReactInstanceManager.getCurrentReactContext() == null))
        return;
      checkForKeyboardEvents();
      checkForDeviceOrientationChanges();
      checkForDeviceDimensionsChanges();
    }
  }

  public static abstract interface ReactRootViewEventListener
  {
    public abstract void onAttachedToReactInstance(ReactRootView paramReactRootView);
  }
}

/* Location:           C:\Users\c_jealom1\Documents\Scripts\Android\Fathom_com.brynk.fathom\Fathom_com.brynk.fathom-dex2jar.jar
 * Qualified Name:     com.facebook.react.ReactRootView
 * JD-Core Version:    0.6.0
 */
package com.facebook.react.modules.statusbar;

import android.animation.ArgbEvaluator;
import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.os.Build.VERSION;
import android.support.v4.view.ViewCompat;
import android.view.View;
import android.view.View.OnApplyWindowInsetsListener;
import android.view.Window;
import android.view.WindowInsets;
import com.facebook.common.logging.FLog;
import com.facebook.react.bridge.GuardedRunnable;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.facebook.react.bridge.ReactMethod;
import com.facebook.react.bridge.UiThreadUtil;
import com.facebook.react.common.MapBuilder;
import com.facebook.react.module.annotations.ReactModule;
import com.facebook.react.uimanager.PixelUtil;
import java.util.Map;
import javax.annotation.Nullable;

@ReactModule(name="StatusBarManager")
public class StatusBarModule extends ReactContextBaseJavaModule
{
  private static final String HEIGHT_KEY = "HEIGHT";

  public StatusBarModule(ReactApplicationContext paramReactApplicationContext)
  {
    super(paramReactApplicationContext);
  }

  @Nullable
  public Map<String, Object> getConstants()
  {
    ReactApplicationContext localReactApplicationContext = getReactApplicationContext();
    int i = localReactApplicationContext.getResources().getIdentifier("status_bar_height", "dimen", "android");
    float f;
    if (i > 0)
      f = PixelUtil.toDIPFromPixel(localReactApplicationContext.getResources().getDimensionPixelSize(i));
    while (true)
    {
      return MapBuilder.of("HEIGHT", Float.valueOf(f));
      f = 0.0F;
    }
  }

  public String getName()
  {
    return "StatusBarManager";
  }

  @ReactMethod
  public void setColor(int paramInt, boolean paramBoolean)
  {
    Activity localActivity = getCurrentActivity();
    if (localActivity == null)
      FLog.w("ReactNative", "StatusBarModule: Ignored status bar change, current activity is null.");
    do
      return;
    while (Build.VERSION.SDK_INT < 21);
    UiThreadUtil.runOnUiThread(new GuardedRunnable(getReactApplicationContext(), localActivity, paramBoolean, paramInt)
    {
      @TargetApi(21)
      public void runGuarded()
      {
        this.val$activity.getWindow().addFlags(-2147483648);
        if (this.val$animated)
        {
          int i = this.val$activity.getWindow().getStatusBarColor();
          ValueAnimator localValueAnimator = ValueAnimator.ofObject(new ArgbEvaluator(), new Object[] { Integer.valueOf(i), Integer.valueOf(this.val$color) });
          localValueAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener()
          {
            public void onAnimationUpdate(ValueAnimator paramValueAnimator)
            {
              StatusBarModule.1.this.val$activity.getWindow().setStatusBarColor(((Integer)paramValueAnimator.getAnimatedValue()).intValue());
            }
          });
          localValueAnimator.setDuration(300L).setStartDelay(0L);
          localValueAnimator.start();
          return;
        }
        this.val$activity.getWindow().setStatusBarColor(this.val$color);
      }
    });
  }

  @ReactMethod
  public void setHidden(boolean paramBoolean)
  {
    Activity localActivity = getCurrentActivity();
    if (localActivity == null)
    {
      FLog.w("ReactNative", "StatusBarModule: Ignored status bar change, current activity is null.");
      return;
    }
    UiThreadUtil.runOnUiThread(new Runnable(paramBoolean, localActivity)
    {
      public void run()
      {
        if (this.val$hidden)
        {
          this.val$activity.getWindow().addFlags(1024);
          this.val$activity.getWindow().clearFlags(2048);
          return;
        }
        this.val$activity.getWindow().addFlags(2048);
        this.val$activity.getWindow().clearFlags(1024);
      }
    });
  }

  @ReactMethod
  public void setStyle(String paramString)
  {
    Activity localActivity = getCurrentActivity();
    if (localActivity == null)
      FLog.w("ReactNative", "StatusBarModule: Ignored status bar change, current activity is null.");
    do
      return;
    while (Build.VERSION.SDK_INT < 23);
    UiThreadUtil.runOnUiThread(new Runnable(localActivity, paramString)
    {
      @TargetApi(23)
      public void run()
      {
        View localView = this.val$activity.getWindow().getDecorView();
        if (this.val$style.equals("dark-content"));
        for (int i = 8192; ; i = 0)
        {
          localView.setSystemUiVisibility(i);
          return;
        }
      }
    });
  }

  @ReactMethod
  public void setTranslucent(boolean paramBoolean)
  {
    Activity localActivity = getCurrentActivity();
    if (localActivity == null)
      FLog.w("ReactNative", "StatusBarModule: Ignored status bar change, current activity is null.");
    do
      return;
    while (Build.VERSION.SDK_INT < 21);
    UiThreadUtil.runOnUiThread(new GuardedRunnable(getReactApplicationContext(), localActivity, paramBoolean)
    {
      @TargetApi(21)
      public void runGuarded()
      {
        View localView = this.val$activity.getWindow().getDecorView();
        if (this.val$translucent)
          localView.setOnApplyWindowInsetsListener(new View.OnApplyWindowInsetsListener()
          {
            public WindowInsets onApplyWindowInsets(View paramView, WindowInsets paramWindowInsets)
            {
              paramView = paramView.onApplyWindowInsets(paramWindowInsets);
              return paramView.replaceSystemWindowInsets(paramView.getSystemWindowInsetLeft(), 0, paramView.getSystemWindowInsetRight(), paramView.getSystemWindowInsetBottom());
            }
          });
        while (true)
        {
          ViewCompat.requestApplyInsets(localView);
          return;
          localView.setOnApplyWindowInsetsListener(null);
        }
      }
    });
  }
}

/* Location:           C:\Users\c_jealom1\Documents\Scripts\Android\Fathom_com.brynk.fathom\Fathom_com.brynk.fathom-dex2jar.jar
 * Qualified Name:     com.facebook.react.modules.statusbar.StatusBarModule
 * JD-Core Version:    0.6.0
 */
package com.facebook.react.devsupport;

import android.view.WindowManager;
import android.view.WindowManager.LayoutParams;
import android.widget.FrameLayout;
import com.facebook.react.bridge.ReactContext;
import javax.annotation.Nullable;

class DebugOverlayController
{

  @Nullable
  private FrameLayout mFPSDebugViewContainer;
  private final ReactContext mReactContext;
  private final WindowManager mWindowManager;

  public DebugOverlayController(ReactContext paramReactContext)
  {
    this.mReactContext = paramReactContext;
    this.mWindowManager = ((WindowManager)paramReactContext.getSystemService("window"));
  }

  public void setFpsDebugViewVisible(boolean paramBoolean)
  {
    if ((paramBoolean) && (this.mFPSDebugViewContainer == null))
    {
      this.mFPSDebugViewContainer = new FpsView(this.mReactContext);
      WindowManager.LayoutParams localLayoutParams = new WindowManager.LayoutParams(-1, -1, WindowOverlayCompat.TYPE_SYSTEM_OVERLAY, 24, -3);
      this.mWindowManager.addView(this.mFPSDebugViewContainer, localLayoutParams);
    }
    do
      return;
    while ((paramBoolean) || (this.mFPSDebugViewContainer == null));
    this.mFPSDebugViewContainer.removeAllViews();
    this.mWindowManager.removeView(this.mFPSDebugViewContainer);
    this.mFPSDebugViewContainer = null;
  }
}

/* Location:           C:\Users\c_jealom1\Documents\Scripts\Android\Fathom_com.brynk.fathom\Fathom_com.brynk.fathom-dex2jar.jar
 * Qualified Name:     com.facebook.react.devsupport.DebugOverlayController
 * JD-Core Version:    0.6.0
 */
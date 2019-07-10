package com.facebook.react.uimanager.events;

import android.view.MotionEvent;
import android.view.View;
import com.facebook.react.uimanager.RootView;
import com.facebook.react.uimanager.RootViewUtil;

public class NativeGestureUtil
{
  public static void notifyNativeGestureStarted(View paramView, MotionEvent paramMotionEvent)
  {
    RootViewUtil.getRootView(paramView).onChildStartedNativeGesture(paramMotionEvent);
  }
}

/* Location:           C:\Users\c_jealom1\Documents\Scripts\Android\Fathom_com.brynk.fathom\Fathom_com.brynk.fathom-dex2jar.jar
 * Qualified Name:     com.facebook.react.uimanager.events.NativeGestureUtil
 * JD-Core Version:    0.6.0
 */
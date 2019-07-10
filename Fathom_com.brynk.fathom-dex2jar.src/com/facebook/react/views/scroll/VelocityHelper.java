package com.facebook.react.views.scroll;

import android.view.MotionEvent;
import android.view.VelocityTracker;
import javax.annotation.Nullable;

public class VelocityHelper
{

  @Nullable
  private VelocityTracker mVelocityTracker;
  private float mXVelocity;
  private float mYVelocity;

  public void calculateVelocity(MotionEvent paramMotionEvent)
  {
    int i = paramMotionEvent.getAction();
    if (this.mVelocityTracker == null)
      this.mVelocityTracker = VelocityTracker.obtain();
    this.mVelocityTracker.addMovement(paramMotionEvent);
    switch (i & 0xFF)
    {
    case 2:
    default:
    case 1:
    case 3:
    }
    do
    {
      return;
      this.mVelocityTracker.computeCurrentVelocity(1);
      this.mXVelocity = this.mVelocityTracker.getXVelocity();
      this.mYVelocity = this.mVelocityTracker.getYVelocity();
    }
    while (this.mVelocityTracker == null);
    this.mVelocityTracker.recycle();
    this.mVelocityTracker = null;
  }

  public float getXVelocity()
  {
    return this.mXVelocity;
  }

  public float getYVelocity()
  {
    return this.mYVelocity;
  }
}

/* Location:           C:\Users\c_jealom1\Documents\Scripts\Android\Fathom_com.brynk.fathom\Fathom_com.brynk.fathom-dex2jar.jar
 * Qualified Name:     com.facebook.react.views.scroll.VelocityHelper
 * JD-Core Version:    0.6.0
 */
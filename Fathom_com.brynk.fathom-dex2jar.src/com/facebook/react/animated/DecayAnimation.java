package com.facebook.react.animated;

import com.facebook.react.bridge.ReadableMap;

public class DecayAnimation extends AnimationDriver
{
  private int mCurrentLoop;
  private final double mDeceleration;
  private double mFromValue = 0.0D;
  private int mIterations;
  private double mLastValue = 0.0D;
  private long mStartFrameTimeMillis = -1L;
  private final double mVelocity;

  public DecayAnimation(ReadableMap paramReadableMap)
  {
    this.mVelocity = paramReadableMap.getDouble("velocity");
    this.mDeceleration = paramReadableMap.getDouble("deceleration");
    int i;
    if (paramReadableMap.hasKey("iterations"))
    {
      i = paramReadableMap.getInt("iterations");
      this.mIterations = i;
      this.mCurrentLoop = 1;
      if (this.mIterations != 0)
        break label95;
    }
    while (true)
    {
      this.mHasFinished = bool;
      return;
      i = 1;
      break;
      label95: bool = false;
    }
  }

  public void runAnimationStep(long paramLong)
  {
    paramLong /= 1000000L;
    if (this.mStartFrameTimeMillis == -1L)
    {
      this.mStartFrameTimeMillis = (paramLong - 16L);
      if (this.mFromValue != this.mLastValue)
        break label164;
      this.mFromValue = this.mAnimatedValue.mValue;
    }
    while (true)
    {
      this.mLastValue = this.mAnimatedValue.mValue;
      double d = this.mFromValue + this.mVelocity / (1.0D - this.mDeceleration) * (1.0D - Math.exp(-(1.0D - this.mDeceleration) * (paramLong - this.mStartFrameTimeMillis)));
      if (Math.abs(this.mLastValue - d) < 0.1D)
      {
        if ((this.mIterations != -1) && (this.mCurrentLoop >= this.mIterations))
          break;
        this.mStartFrameTimeMillis = -1L;
        this.mCurrentLoop += 1;
      }
      this.mLastValue = d;
      this.mAnimatedValue.mValue = d;
      return;
      label164: this.mAnimatedValue.mValue = this.mFromValue;
    }
    this.mHasFinished = true;
  }
}

/* Location:           C:\Users\c_jealom1\Documents\Scripts\Android\Fathom_com.brynk.fathom\Fathom_com.brynk.fathom-dex2jar.jar
 * Qualified Name:     com.facebook.react.animated.DecayAnimation
 * JD-Core Version:    0.6.0
 */
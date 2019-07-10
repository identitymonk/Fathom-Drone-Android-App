package com.facebook.react.animated;

import com.facebook.react.bridge.ReadableArray;
import com.facebook.react.bridge.ReadableMap;

class FrameBasedAnimationDriver extends AnimationDriver
{
  private static final double FRAME_TIME_MILLIS = 16.666666666666668D;
  private int mCurrentLoop;
  private final double[] mFrames;
  private double mFromValue;
  private int mIterations;
  private long mStartFrameTimeNanos = -1L;
  private final double mToValue;

  FrameBasedAnimationDriver(ReadableMap paramReadableMap)
  {
    ReadableArray localReadableArray = paramReadableMap.getArray("frames");
    int j = localReadableArray.size();
    this.mFrames = new double[j];
    int i = 0;
    while (i < j)
    {
      this.mFrames[i] = localReadableArray.getDouble(i);
      i += 1;
    }
    this.mToValue = paramReadableMap.getDouble("toValue");
    if (paramReadableMap.hasKey("iterations"))
    {
      i = paramReadableMap.getInt("iterations");
      this.mIterations = i;
      this.mCurrentLoop = 1;
      if (this.mIterations != 0)
        break label128;
    }
    while (true)
    {
      this.mHasFinished = bool;
      return;
      i = 1;
      break;
      label128: bool = false;
    }
  }

  public void runAnimationStep(long paramLong)
  {
    if (this.mStartFrameTimeNanos < 0L)
    {
      this.mStartFrameTimeNanos = paramLong;
      this.mFromValue = this.mAnimatedValue.mValue;
    }
    int i = (int)((paramLong - this.mStartFrameTimeNanos) / 1000000L / 16.666666666666668D);
    if (i < 0)
      throw new IllegalStateException("Calculated frame index should never be lower than 0");
    if (this.mHasFinished)
      return;
    double d;
    if (i >= this.mFrames.length - 1)
    {
      d = this.mToValue;
      if ((this.mIterations == -1) || (this.mCurrentLoop < this.mIterations))
      {
        this.mStartFrameTimeNanos = paramLong;
        this.mCurrentLoop += 1;
      }
    }
    while (true)
    {
      this.mAnimatedValue.mValue = d;
      return;
      this.mHasFinished = true;
      continue;
      d = this.mFromValue + this.mFrames[i] * (this.mToValue - this.mFromValue);
    }
  }
}

/* Location:           C:\Users\c_jealom1\Documents\Scripts\Android\Fathom_com.brynk.fathom\Fathom_com.brynk.fathom-dex2jar.jar
 * Qualified Name:     com.facebook.react.animated.FrameBasedAnimationDriver
 * JD-Core Version:    0.6.0
 */
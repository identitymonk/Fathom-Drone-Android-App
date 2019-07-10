package com.facebook.react.animated;

import com.facebook.react.bridge.Callback;

abstract class AnimationDriver
{
  ValueAnimatedNode mAnimatedValue;
  Callback mEndCallback;
  boolean mHasFinished = false;
  int mId;

  public abstract void runAnimationStep(long paramLong);
}

/* Location:           C:\Users\c_jealom1\Documents\Scripts\Android\Fathom_com.brynk.fathom\Fathom_com.brynk.fathom-dex2jar.jar
 * Qualified Name:     com.facebook.react.animated.AnimationDriver
 * JD-Core Version:    0.6.0
 */
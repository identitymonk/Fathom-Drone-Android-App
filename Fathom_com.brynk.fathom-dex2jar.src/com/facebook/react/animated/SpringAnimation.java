package com.facebook.react.animated;

import com.facebook.react.bridge.ReadableMap;

class SpringAnimation extends AnimationDriver
{
  private static final double MAX_DELTA_TIME_SEC = 0.064D;
  private static final double SOLVER_TIMESTEP_SEC = 0.001D;
  private int mCurrentLoop = 0;
  private final PhysicsState mCurrentState = new PhysicsState(null);
  private double mDisplacementFromRestThreshold;
  private double mEndValue;
  private double mInitialVelocity;
  private int mIterations;
  private long mLastTime;
  private double mOriginalValue;
  private boolean mOvershootClampingEnabled;
  private double mRestSpeedThreshold;
  private double mSpringDamping;
  private double mSpringMass;
  private boolean mSpringStarted;
  private double mSpringStiffness;
  private double mStartValue;
  private double mTimeAccumulator = 0.0D;

  SpringAnimation(ReadableMap paramReadableMap)
  {
    this.mSpringStiffness = paramReadableMap.getDouble("stiffness");
    this.mSpringDamping = paramReadableMap.getDouble("damping");
    this.mSpringMass = paramReadableMap.getDouble("mass");
    this.mInitialVelocity = paramReadableMap.getDouble("initialVelocity");
    this.mCurrentState.velocity = this.mInitialVelocity;
    this.mEndValue = paramReadableMap.getDouble("toValue");
    this.mRestSpeedThreshold = paramReadableMap.getDouble("restSpeedThreshold");
    this.mDisplacementFromRestThreshold = paramReadableMap.getDouble("restDisplacementThreshold");
    this.mOvershootClampingEnabled = paramReadableMap.getBoolean("overshootClamping");
    int i;
    if (paramReadableMap.hasKey("iterations"))
    {
      i = paramReadableMap.getInt("iterations");
      this.mIterations = i;
      if (this.mIterations != 0)
        break label178;
    }
    while (true)
    {
      this.mHasFinished = bool;
      return;
      i = 1;
      break;
      label178: bool = false;
    }
  }

  private void advance(double paramDouble)
  {
    if (isAtRest());
    double d1;
    double d2;
    double d3;
    double d4;
    double d5;
    while (true)
    {
      return;
      d1 = paramDouble;
      if (paramDouble > 0.064D)
        d1 = 0.064D;
      this.mTimeAccumulator += d1;
      d2 = this.mSpringDamping;
      paramDouble = this.mSpringMass;
      d3 = this.mSpringStiffness;
      d1 = -this.mInitialVelocity;
      d2 /= 2.0D * Math.sqrt(d3 * paramDouble);
      d3 = Math.sqrt(d3 / paramDouble);
      double d6 = d3 * Math.sqrt(1.0D - d2 * d2);
      d4 = this.mEndValue - this.mStartValue;
      d5 = this.mTimeAccumulator;
      if (d2 >= 1.0D)
        break;
      double d7 = Math.exp(-d2 * d3 * d5);
      paramDouble = this.mEndValue - ((d2 * d3 * d4 + d1) / d6 * Math.sin(d6 * d5) + Math.cos(d6 * d5) * d4) * d7;
      d1 = d2 * d3 * d7 * (Math.sin(d6 * d5) * (d2 * d3 * d4 + d1) / d6 + Math.cos(d6 * d5) * d4) - (Math.cos(d6 * d5) * (d2 * d3 * d4 + d1) - d6 * d4 * Math.sin(d6 * d5)) * d7;
      this.mCurrentState.position = paramDouble;
      this.mCurrentState.velocity = d1;
      if ((!isAtRest()) && ((!this.mOvershootClampingEnabled) || (!isOvershooting())))
        continue;
      if (this.mSpringStiffness <= 0.0D)
        break label393;
      this.mStartValue = this.mEndValue;
      this.mCurrentState.position = this.mEndValue;
    }
    while (true)
    {
      this.mCurrentState.velocity = 0.0D;
      return;
      d2 = Math.exp(-d3 * d5);
      paramDouble = this.mEndValue - ((d3 * d4 + d1) * d5 + d4) * d2;
      d1 = d2 * ((d5 * d3 - 1.0D) * d1 + d5 * d4 * (d3 * d3));
      break;
      label393: this.mEndValue = this.mCurrentState.position;
      this.mStartValue = this.mEndValue;
    }
  }

  private double getDisplacementDistanceForState(PhysicsState paramPhysicsState)
  {
    return Math.abs(this.mEndValue - paramPhysicsState.position);
  }

  private boolean isAtRest()
  {
    return (Math.abs(this.mCurrentState.velocity) <= this.mRestSpeedThreshold) && ((getDisplacementDistanceForState(this.mCurrentState) <= this.mDisplacementFromRestThreshold) || (this.mSpringStiffness == 0.0D));
  }

  private boolean isOvershooting()
  {
    return (this.mSpringStiffness > 0.0D) && (((this.mStartValue < this.mEndValue) && (this.mCurrentState.position > this.mEndValue)) || ((this.mStartValue > this.mEndValue) && (this.mCurrentState.position < this.mEndValue)));
  }

  public void runAnimationStep(long paramLong)
  {
    paramLong /= 1000000L;
    if (!this.mSpringStarted)
    {
      if (this.mCurrentLoop == 0)
      {
        this.mOriginalValue = this.mAnimatedValue.mValue;
        this.mCurrentLoop = 1;
      }
      PhysicsState localPhysicsState = this.mCurrentState;
      double d = this.mAnimatedValue.mValue;
      localPhysicsState.position = d;
      this.mStartValue = d;
      this.mLastTime = paramLong;
      this.mTimeAccumulator = 0.0D;
      this.mSpringStarted = true;
    }
    advance((paramLong - this.mLastTime) / 1000.0D);
    this.mLastTime = paramLong;
    this.mAnimatedValue.mValue = this.mCurrentState.position;
    if (isAtRest())
    {
      if ((this.mIterations == -1) || (this.mCurrentLoop < this.mIterations))
      {
        this.mSpringStarted = false;
        this.mAnimatedValue.mValue = this.mOriginalValue;
        this.mCurrentLoop += 1;
      }
    }
    else
      return;
    this.mHasFinished = true;
  }

  private static class PhysicsState
  {
    double position;
    double velocity;
  }
}

/* Location:           C:\Users\c_jealom1\Documents\Scripts\Android\Fathom_com.brynk.fathom\Fathom_com.brynk.fathom-dex2jar.jar
 * Qualified Name:     com.facebook.react.animated.SpringAnimation
 * JD-Core Version:    0.6.0
 */
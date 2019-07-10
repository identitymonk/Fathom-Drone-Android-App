package com.facebook.react.animation;

import android.view.View;
import com.facebook.infer.annotation.Assertions;
import javax.annotation.Nullable;

public abstract class Animation
{

  @Nullable
  private View mAnimatedView;
  private final int mAnimationID;

  @Nullable
  private AnimationListener mAnimationListener;
  private volatile boolean mCancelled = false;
  private volatile boolean mIsFinished = false;
  private final AnimationPropertyUpdater mPropertyUpdater;

  public Animation(int paramInt, AnimationPropertyUpdater paramAnimationPropertyUpdater)
  {
    this.mAnimationID = paramInt;
    this.mPropertyUpdater = paramAnimationPropertyUpdater;
  }

  public final void cancel()
  {
    if ((this.mIsFinished) || (this.mCancelled));
    do
    {
      return;
      this.mCancelled = true;
    }
    while (this.mAnimationListener == null);
    this.mAnimationListener.onCancel();
  }

  protected final void finish()
  {
    if (!this.mIsFinished);
    for (boolean bool = true; ; bool = false)
    {
      Assertions.assertCondition(bool, "Animation must not already be finished!");
      this.mIsFinished = true;
      if (!this.mCancelled)
      {
        if (this.mAnimatedView != null)
          this.mPropertyUpdater.onFinish(this.mAnimatedView);
        if (this.mAnimationListener != null)
          this.mAnimationListener.onFinished();
      }
      return;
    }
  }

  public int getAnimationID()
  {
    return this.mAnimationID;
  }

  protected final boolean onUpdate(float paramFloat)
  {
    if (!this.mIsFinished);
    for (boolean bool = true; ; bool = false)
    {
      Assertions.assertCondition(bool, "Animation must not already be finished!");
      if (!this.mCancelled)
        this.mPropertyUpdater.onUpdate((View)Assertions.assertNotNull(this.mAnimatedView), paramFloat);
      if (this.mCancelled)
        break;
      return true;
    }
    return false;
  }

  public abstract void run();

  public void setAnimationListener(AnimationListener paramAnimationListener)
  {
    this.mAnimationListener = paramAnimationListener;
  }

  public final void start(View paramView)
  {
    this.mAnimatedView = paramView;
    this.mPropertyUpdater.prepare(paramView);
    run();
  }
}

/* Location:           C:\Users\c_jealom1\Documents\Scripts\Android\Fathom_com.brynk.fathom\Fathom_com.brynk.fathom-dex2jar.jar
 * Qualified Name:     com.facebook.react.animation.Animation
 * JD-Core Version:    0.6.0
 */
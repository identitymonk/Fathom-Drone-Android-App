package com.facebook.react.animation;

public class ImmediateAnimation extends Animation
{
  public ImmediateAnimation(int paramInt, AnimationPropertyUpdater paramAnimationPropertyUpdater)
  {
    super(paramInt, paramAnimationPropertyUpdater);
  }

  public void run()
  {
    onUpdate(1.0F);
    finish();
  }
}

/* Location:           C:\Users\c_jealom1\Documents\Scripts\Android\Fathom_com.brynk.fathom\Fathom_com.brynk.fathom-dex2jar.jar
 * Qualified Name:     com.facebook.react.animation.ImmediateAnimation
 * JD-Core Version:    0.6.0
 */
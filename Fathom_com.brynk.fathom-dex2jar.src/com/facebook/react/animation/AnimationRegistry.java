package com.facebook.react.animation;

import android.util.SparseArray;
import com.facebook.react.bridge.UiThreadUtil;

public class AnimationRegistry
{
  private final SparseArray<Animation> mRegistry = new SparseArray();

  public Animation getAnimation(int paramInt)
  {
    UiThreadUtil.assertOnUiThread();
    return (Animation)this.mRegistry.get(paramInt);
  }

  public void registerAnimation(Animation paramAnimation)
  {
    UiThreadUtil.assertOnUiThread();
    this.mRegistry.put(paramAnimation.getAnimationID(), paramAnimation);
  }

  public Animation removeAnimation(int paramInt)
  {
    UiThreadUtil.assertOnUiThread();
    Animation localAnimation = (Animation)this.mRegistry.get(paramInt);
    if (localAnimation != null)
      this.mRegistry.delete(paramInt);
    return localAnimation;
  }
}

/* Location:           C:\Users\c_jealom1\Documents\Scripts\Android\Fathom_com.brynk.fathom\Fathom_com.brynk.fathom-dex2jar.jar
 * Qualified Name:     com.facebook.react.animation.AnimationRegistry
 * JD-Core Version:    0.6.0
 */
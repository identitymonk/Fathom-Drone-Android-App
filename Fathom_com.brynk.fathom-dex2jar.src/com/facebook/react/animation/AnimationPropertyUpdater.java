package com.facebook.react.animation;

import android.view.View;

public abstract interface AnimationPropertyUpdater
{
  public abstract void onFinish(View paramView);

  public abstract void onUpdate(View paramView, float paramFloat);

  public abstract void prepare(View paramView);
}

/* Location:           C:\Users\c_jealom1\Documents\Scripts\Android\Fathom_com.brynk.fathom\Fathom_com.brynk.fathom-dex2jar.jar
 * Qualified Name:     com.facebook.react.animation.AnimationPropertyUpdater
 * JD-Core Version:    0.6.0
 */
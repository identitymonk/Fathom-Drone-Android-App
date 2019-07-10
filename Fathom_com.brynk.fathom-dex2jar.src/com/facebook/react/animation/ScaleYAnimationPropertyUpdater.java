package com.facebook.react.animation;

import android.view.View;

public class ScaleYAnimationPropertyUpdater extends AbstractSingleFloatProperyUpdater
{
  public ScaleYAnimationPropertyUpdater(float paramFloat)
  {
    super(paramFloat);
  }

  public ScaleYAnimationPropertyUpdater(float paramFloat1, float paramFloat2)
  {
    super(paramFloat1, paramFloat2);
  }

  protected float getProperty(View paramView)
  {
    return paramView.getScaleY();
  }

  protected void setProperty(View paramView, float paramFloat)
  {
    paramView.setScaleY(paramFloat);
  }
}

/* Location:           C:\Users\c_jealom1\Documents\Scripts\Android\Fathom_com.brynk.fathom\Fathom_com.brynk.fathom-dex2jar.jar
 * Qualified Name:     com.facebook.react.animation.ScaleYAnimationPropertyUpdater
 * JD-Core Version:    0.6.0
 */
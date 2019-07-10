package com.facebook.react.animation;

import android.view.View;

public class RotationAnimationPropertyUpdater extends AbstractSingleFloatProperyUpdater
{
  public RotationAnimationPropertyUpdater(float paramFloat)
  {
    super(paramFloat);
  }

  protected float getProperty(View paramView)
  {
    return paramView.getRotation();
  }

  protected void setProperty(View paramView, float paramFloat)
  {
    paramView.setRotation((float)Math.toDegrees(paramFloat));
  }
}

/* Location:           C:\Users\c_jealom1\Documents\Scripts\Android\Fathom_com.brynk.fathom\Fathom_com.brynk.fathom-dex2jar.jar
 * Qualified Name:     com.facebook.react.animation.RotationAnimationPropertyUpdater
 * JD-Core Version:    0.6.0
 */
package com.facebook.react.uimanager.layoutanimation;

import android.view.animation.Interpolator;

class SimpleSpringInterpolator
  implements Interpolator
{
  private static final float FACTOR = 0.5F;

  public float getInterpolation(float paramFloat)
  {
    return (float)(1.0D + Math.pow(2.0D, -10.0F * paramFloat) * Math.sin((paramFloat - 0.125F) * 3.141592653589793D * 2.0D / 0.5D));
  }
}

/* Location:           C:\Users\c_jealom1\Documents\Scripts\Android\Fathom_com.brynk.fathom\Fathom_com.brynk.fathom-dex2jar.jar
 * Qualified Name:     com.facebook.react.uimanager.layoutanimation.SimpleSpringInterpolator
 * JD-Core Version:    0.6.0
 */
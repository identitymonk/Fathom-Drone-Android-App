package com.facebook.react.animation;

import android.view.View;

public class ScaleXYAnimationPairPropertyUpdater extends AbstractFloatPairPropertyUpdater
{
  public ScaleXYAnimationPairPropertyUpdater(float paramFloat1, float paramFloat2)
  {
    super(paramFloat1, paramFloat2);
  }

  public ScaleXYAnimationPairPropertyUpdater(float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4)
  {
    super(paramFloat1, paramFloat2, paramFloat3, paramFloat4);
  }

  protected void getProperty(View paramView, float[] paramArrayOfFloat)
  {
    paramArrayOfFloat[0] = paramView.getScaleX();
    paramArrayOfFloat[1] = paramView.getScaleY();
  }

  protected void setProperty(View paramView, float[] paramArrayOfFloat)
  {
    paramView.setScaleX(paramArrayOfFloat[0]);
    paramView.setScaleY(paramArrayOfFloat[1]);
  }
}

/* Location:           C:\Users\c_jealom1\Documents\Scripts\Android\Fathom_com.brynk.fathom\Fathom_com.brynk.fathom-dex2jar.jar
 * Qualified Name:     com.facebook.react.animation.ScaleXYAnimationPairPropertyUpdater
 * JD-Core Version:    0.6.0
 */
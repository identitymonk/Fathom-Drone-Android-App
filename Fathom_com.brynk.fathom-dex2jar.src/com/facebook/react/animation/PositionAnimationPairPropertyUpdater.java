package com.facebook.react.animation;

import android.view.View;

public class PositionAnimationPairPropertyUpdater extends AbstractFloatPairPropertyUpdater
{
  public PositionAnimationPairPropertyUpdater(float paramFloat1, float paramFloat2)
  {
    super(paramFloat1, paramFloat2);
  }

  public PositionAnimationPairPropertyUpdater(float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4)
  {
    super(paramFloat1, paramFloat2, paramFloat3, paramFloat4);
  }

  protected void getProperty(View paramView, float[] paramArrayOfFloat)
  {
    paramArrayOfFloat[0] = (paramView.getX() + paramView.getWidth() * 0.5F);
    paramArrayOfFloat[1] = (paramView.getY() + paramView.getHeight() * 0.5F);
  }

  protected void setProperty(View paramView, float[] paramArrayOfFloat)
  {
    paramView.setX(paramArrayOfFloat[0] - paramView.getWidth() * 0.5F);
    paramView.setY(paramArrayOfFloat[1] - paramView.getHeight() * 0.5F);
  }
}

/* Location:           C:\Users\c_jealom1\Documents\Scripts\Android\Fathom_com.brynk.fathom\Fathom_com.brynk.fathom-dex2jar.jar
 * Qualified Name:     com.facebook.react.animation.PositionAnimationPairPropertyUpdater
 * JD-Core Version:    0.6.0
 */
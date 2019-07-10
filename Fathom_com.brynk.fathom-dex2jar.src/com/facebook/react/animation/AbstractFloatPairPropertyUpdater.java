package com.facebook.react.animation;

import android.view.View;

public abstract class AbstractFloatPairPropertyUpdater
  implements AnimationPropertyUpdater
{
  private boolean mFromSource;
  private final float[] mFromValues = new float[2];
  private final float[] mToValues = new float[2];
  private final float[] mUpdateValues = new float[2];

  protected AbstractFloatPairPropertyUpdater(float paramFloat1, float paramFloat2)
  {
    this.mToValues[0] = paramFloat1;
    this.mToValues[1] = paramFloat2;
    this.mFromSource = true;
  }

  protected AbstractFloatPairPropertyUpdater(float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4)
  {
    this(paramFloat3, paramFloat4);
    this.mFromValues[0] = paramFloat1;
    this.mFromValues[1] = paramFloat2;
    this.mFromSource = false;
  }

  protected abstract void getProperty(View paramView, float[] paramArrayOfFloat);

  public void onFinish(View paramView)
  {
    setProperty(paramView, this.mToValues);
  }

  public void onUpdate(View paramView, float paramFloat)
  {
    this.mUpdateValues[0] = (this.mFromValues[0] + (this.mToValues[0] - this.mFromValues[0]) * paramFloat);
    this.mUpdateValues[1] = (this.mFromValues[1] + (this.mToValues[1] - this.mFromValues[1]) * paramFloat);
    setProperty(paramView, this.mUpdateValues);
  }

  public void prepare(View paramView)
  {
    if (this.mFromSource)
      getProperty(paramView, this.mFromValues);
  }

  protected abstract void setProperty(View paramView, float[] paramArrayOfFloat);
}

/* Location:           C:\Users\c_jealom1\Documents\Scripts\Android\Fathom_com.brynk.fathom\Fathom_com.brynk.fathom-dex2jar.jar
 * Qualified Name:     com.facebook.react.animation.AbstractFloatPairPropertyUpdater
 * JD-Core Version:    0.6.0
 */
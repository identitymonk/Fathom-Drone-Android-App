package android.support.v4.view.animation;

import android.view.animation.Interpolator;

abstract class LookupTableInterpolator
  implements Interpolator
{
  private final float mStepSize;
  private final float[] mValues;

  public LookupTableInterpolator(float[] paramArrayOfFloat)
  {
    this.mValues = paramArrayOfFloat;
    this.mStepSize = (1.0F / (this.mValues.length - 1));
  }

  public float getInterpolation(float paramFloat)
  {
    if (paramFloat >= 1.0F)
      return 1.0F;
    if (paramFloat <= 0.0F)
      return 0.0F;
    int i = Math.min((int)((this.mValues.length - 1) * paramFloat), this.mValues.length - 2);
    paramFloat = (paramFloat - i * this.mStepSize) / this.mStepSize;
    return this.mValues[i] + (this.mValues[(i + 1)] - this.mValues[i]) * paramFloat;
  }
}

/* Location:           C:\Users\c_jealom1\Documents\Scripts\Android\Fathom_com.brynk.fathom\Fathom_com.brynk.fathom-dex2jar.jar
 * Qualified Name:     android.support.v4.view.animation.LookupTableInterpolator
 * JD-Core Version:    0.6.0
 */
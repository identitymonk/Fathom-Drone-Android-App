package com.facebook.drawee.generic;

import android.support.annotation.ColorInt;
import com.facebook.common.internal.Preconditions;
import java.util.Arrays;

public class RoundingParams
{
  private int mBorderColor = 0;
  private float mBorderWidth = 0.0F;
  private float[] mCornersRadii = null;
  private int mOverlayColor = 0;
  private float mPadding = 0.0F;
  private boolean mRoundAsCircle = false;
  private RoundingMethod mRoundingMethod = RoundingMethod.BITMAP_ONLY;

  public static RoundingParams asCircle()
  {
    return new RoundingParams().setRoundAsCircle(true);
  }

  public static RoundingParams fromCornersRadii(float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4)
  {
    return new RoundingParams().setCornersRadii(paramFloat1, paramFloat2, paramFloat3, paramFloat4);
  }

  public static RoundingParams fromCornersRadii(float[] paramArrayOfFloat)
  {
    return new RoundingParams().setCornersRadii(paramArrayOfFloat);
  }

  public static RoundingParams fromCornersRadius(float paramFloat)
  {
    return new RoundingParams().setCornersRadius(paramFloat);
  }

  private float[] getOrCreateRoundedCornersRadii()
  {
    if (this.mCornersRadii == null)
      this.mCornersRadii = new float[8];
    return this.mCornersRadii;
  }

  public boolean equals(Object paramObject)
  {
    int j = 0;
    int i;
    if (this == paramObject)
      i = 1;
    do
    {
      do
      {
        do
        {
          do
          {
            do
            {
              do
              {
                do
                {
                  do
                  {
                    return i;
                    i = j;
                  }
                  while (paramObject == null);
                  i = j;
                }
                while (getClass() != paramObject.getClass());
                paramObject = (RoundingParams)paramObject;
                i = j;
              }
              while (this.mRoundAsCircle != paramObject.mRoundAsCircle);
              i = j;
            }
            while (this.mOverlayColor != paramObject.mOverlayColor);
            i = j;
          }
          while (Float.compare(paramObject.mBorderWidth, this.mBorderWidth) != 0);
          i = j;
        }
        while (this.mBorderColor != paramObject.mBorderColor);
        i = j;
      }
      while (Float.compare(paramObject.mPadding, this.mPadding) != 0);
      i = j;
    }
    while (this.mRoundingMethod != paramObject.mRoundingMethod);
    return Arrays.equals(this.mCornersRadii, paramObject.mCornersRadii);
  }

  public int getBorderColor()
  {
    return this.mBorderColor;
  }

  public float getBorderWidth()
  {
    return this.mBorderWidth;
  }

  public float[] getCornersRadii()
  {
    return this.mCornersRadii;
  }

  public int getOverlayColor()
  {
    return this.mOverlayColor;
  }

  public float getPadding()
  {
    return this.mPadding;
  }

  public boolean getRoundAsCircle()
  {
    return this.mRoundAsCircle;
  }

  public RoundingMethod getRoundingMethod()
  {
    return this.mRoundingMethod;
  }

  public int hashCode()
  {
    int n = 0;
    int i;
    int j;
    label27: int k;
    label42: int i1;
    if (this.mRoundingMethod != null)
    {
      i = this.mRoundingMethod.hashCode();
      if (!this.mRoundAsCircle)
        break label131;
      j = 1;
      if (this.mCornersRadii == null)
        break label136;
      k = Arrays.hashCode(this.mCornersRadii);
      i1 = this.mOverlayColor;
      if (this.mBorderWidth == 0.0F)
        break label141;
    }
    label131: label136: label141: for (int m = Float.floatToIntBits(this.mBorderWidth); ; m = 0)
    {
      int i2 = this.mBorderColor;
      if (this.mPadding != 0.0F)
        n = Float.floatToIntBits(this.mPadding);
      return (((((i * 31 + j) * 31 + k) * 31 + i1) * 31 + m) * 31 + i2) * 31 + n;
      i = 0;
      break;
      j = 0;
      break label27;
      k = 0;
      break label42;
    }
  }

  public RoundingParams setBorder(@ColorInt int paramInt, float paramFloat)
  {
    if (paramFloat >= 0.0F);
    for (boolean bool = true; ; bool = false)
    {
      Preconditions.checkArgument(bool, "the border width cannot be < 0");
      this.mBorderWidth = paramFloat;
      this.mBorderColor = paramInt;
      return this;
    }
  }

  public RoundingParams setBorderColor(@ColorInt int paramInt)
  {
    this.mBorderColor = paramInt;
    return this;
  }

  public RoundingParams setBorderWidth(float paramFloat)
  {
    if (paramFloat >= 0.0F);
    for (boolean bool = true; ; bool = false)
    {
      Preconditions.checkArgument(bool, "the border width cannot be < 0");
      this.mBorderWidth = paramFloat;
      return this;
    }
  }

  public RoundingParams setCornersRadii(float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4)
  {
    float[] arrayOfFloat = getOrCreateRoundedCornersRadii();
    arrayOfFloat[1] = paramFloat1;
    arrayOfFloat[0] = paramFloat1;
    arrayOfFloat[3] = paramFloat2;
    arrayOfFloat[2] = paramFloat2;
    arrayOfFloat[5] = paramFloat3;
    arrayOfFloat[4] = paramFloat3;
    arrayOfFloat[7] = paramFloat4;
    arrayOfFloat[6] = paramFloat4;
    return this;
  }

  public RoundingParams setCornersRadii(float[] paramArrayOfFloat)
  {
    Preconditions.checkNotNull(paramArrayOfFloat);
    if (paramArrayOfFloat.length == 8);
    for (boolean bool = true; ; bool = false)
    {
      Preconditions.checkArgument(bool, "radii should have exactly 8 values");
      System.arraycopy(paramArrayOfFloat, 0, getOrCreateRoundedCornersRadii(), 0, 8);
      return this;
    }
  }

  public RoundingParams setCornersRadius(float paramFloat)
  {
    Arrays.fill(getOrCreateRoundedCornersRadii(), paramFloat);
    return this;
  }

  public RoundingParams setOverlayColor(@ColorInt int paramInt)
  {
    this.mOverlayColor = paramInt;
    this.mRoundingMethod = RoundingMethod.OVERLAY_COLOR;
    return this;
  }

  public RoundingParams setPadding(float paramFloat)
  {
    if (paramFloat >= 0.0F);
    for (boolean bool = true; ; bool = false)
    {
      Preconditions.checkArgument(bool, "the padding cannot be < 0");
      this.mPadding = paramFloat;
      return this;
    }
  }

  public RoundingParams setRoundAsCircle(boolean paramBoolean)
  {
    this.mRoundAsCircle = paramBoolean;
    return this;
  }

  public RoundingParams setRoundingMethod(RoundingMethod paramRoundingMethod)
  {
    this.mRoundingMethod = paramRoundingMethod;
    return this;
  }

  public static enum RoundingMethod
  {
    static
    {
      BITMAP_ONLY = new RoundingMethod("BITMAP_ONLY", 1);
      $VALUES = new RoundingMethod[] { OVERLAY_COLOR, BITMAP_ONLY };
    }
  }
}

/* Location:           C:\Users\c_jealom1\Documents\Scripts\Android\Fathom_com.brynk.fathom\Fathom_com.brynk.fathom-dex2jar.jar
 * Qualified Name:     com.facebook.drawee.generic.RoundingParams
 * JD-Core Version:    0.6.0
 */
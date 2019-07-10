package com.facebook.react.uimanager;

import com.facebook.yoga.YogaConstants;
import java.util.Arrays;

public class Spacing
{
  public static final int ALL = 8;
  public static final int BOTTOM = 3;
  public static final int END = 5;
  public static final int HORIZONTAL = 6;
  public static final int LEFT = 0;
  public static final int RIGHT = 2;
  public static final int START = 4;
  public static final int TOP = 1;
  public static final int VERTICAL = 7;
  private static final int[] sFlagsMap = { 1, 2, 4, 8, 16, 32, 64, 128, 256 };
  private float mDefaultValue;
  private boolean mHasAliasesSet;
  private final float[] mSpacing = newFullSpacingArray();
  private int mValueFlags = 0;

  public Spacing()
  {
    this(0.0F);
  }

  public Spacing(float paramFloat)
  {
    this.mDefaultValue = paramFloat;
  }

  private static float[] newFullSpacingArray()
  {
    return new float[] { (0.0F / 0.0F), (0.0F / 0.0F), (0.0F / 0.0F), (0.0F / 0.0F), (0.0F / 0.0F), (0.0F / 0.0F), (0.0F / 0.0F), (0.0F / 0.0F), (0.0F / 0.0F) };
  }

  public float get(int paramInt)
  {
    float f;
    if ((paramInt == 4) || (paramInt == 5))
    {
      f = (0.0F / 0.0F);
      if (this.mValueFlags != 0)
        break label30;
    }
    label30: 
    do
    {
      do
      {
        return f;
        f = this.mDefaultValue;
        break;
        if ((this.mValueFlags & sFlagsMap[paramInt]) != 0)
          return this.mSpacing[paramInt];
      }
      while (!this.mHasAliasesSet);
      if ((paramInt == 1) || (paramInt == 3));
      for (paramInt = 7; (this.mValueFlags & sFlagsMap[paramInt]) != 0; paramInt = 6)
        return this.mSpacing[paramInt];
    }
    while ((this.mValueFlags & sFlagsMap[8]) == 0);
    return this.mSpacing[8];
  }

  public float getRaw(int paramInt)
  {
    return this.mSpacing[paramInt];
  }

  float getWithFallback(int paramInt1, int paramInt2)
  {
    if ((this.mValueFlags & sFlagsMap[paramInt1]) != 0)
      return this.mSpacing[paramInt1];
    return get(paramInt2);
  }

  public void reset()
  {
    Arrays.fill(this.mSpacing, (0.0F / 0.0F));
    this.mHasAliasesSet = false;
    this.mValueFlags = 0;
  }

  public boolean set(int paramInt, float paramFloat)
  {
    boolean bool = false;
    if (!FloatUtil.floatsEqual(this.mSpacing[paramInt], paramFloat))
    {
      this.mSpacing[paramInt] = paramFloat;
      if (YogaConstants.isUndefined(paramFloat))
        this.mValueFlags &= (sFlagsMap[paramInt] ^ 0xFFFFFFFF);
      while (true)
      {
        if (((this.mValueFlags & sFlagsMap[8]) != 0) || ((this.mValueFlags & sFlagsMap[7]) != 0) || ((this.mValueFlags & sFlagsMap[6]) != 0))
          bool = true;
        this.mHasAliasesSet = bool;
        return true;
        this.mValueFlags |= sFlagsMap[paramInt];
      }
    }
    return false;
  }
}

/* Location:           C:\Users\c_jealom1\Documents\Scripts\Android\Fathom_com.brynk.fathom\Fathom_com.brynk.fathom-dex2jar.jar
 * Qualified Name:     com.facebook.react.uimanager.Spacing
 * JD-Core Version:    0.6.0
 */
package com.facebook.yoga;

public class YogaMeasureOutput
{
  public static float getHeight(long paramLong)
  {
    return Float.intBitsToFloat((int)(0xFFFFFFFF & paramLong));
  }

  public static float getWidth(long paramLong)
  {
    return Float.intBitsToFloat((int)(0xFFFFFFFF & paramLong >> 32));
  }

  public static long make(float paramFloat1, float paramFloat2)
  {
    int i = Float.floatToRawIntBits(paramFloat1);
    int j = Float.floatToRawIntBits(paramFloat2);
    return i << 32 | j;
  }

  public static long make(int paramInt1, int paramInt2)
  {
    return make(paramInt1, paramInt2);
  }
}

/* Location:           C:\Users\c_jealom1\Documents\Scripts\Android\Fathom_com.brynk.fathom\Fathom_com.brynk.fathom-dex2jar.jar
 * Qualified Name:     com.facebook.yoga.YogaMeasureOutput
 * JD-Core Version:    0.6.0
 */
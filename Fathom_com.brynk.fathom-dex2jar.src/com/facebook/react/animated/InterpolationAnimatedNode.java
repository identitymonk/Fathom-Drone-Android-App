package com.facebook.react.animated;

import com.facebook.react.bridge.JSApplicationIllegalArgumentException;
import com.facebook.react.bridge.ReadableArray;
import com.facebook.react.bridge.ReadableMap;
import javax.annotation.Nullable;

class InterpolationAnimatedNode extends ValueAnimatedNode
{
  public static final String EXTRAPOLATE_TYPE_CLAMP = "clamp";
  public static final String EXTRAPOLATE_TYPE_EXTEND = "extend";
  public static final String EXTRAPOLATE_TYPE_IDENTITY = "identity";
  private final String mExtrapolateLeft;
  private final String mExtrapolateRight;
  private final double[] mInputRange;
  private final double[] mOutputRange;

  @Nullable
  private ValueAnimatedNode mParent;

  public InterpolationAnimatedNode(ReadableMap paramReadableMap)
  {
    this.mInputRange = fromDoubleArray(paramReadableMap.getArray("inputRange"));
    this.mOutputRange = fromDoubleArray(paramReadableMap.getArray("outputRange"));
    this.mExtrapolateLeft = paramReadableMap.getString("extrapolateLeft");
    this.mExtrapolateRight = paramReadableMap.getString("extrapolateRight");
  }

  private static int findRangeIndex(double paramDouble, double[] paramArrayOfDouble)
  {
    int i = 1;
    while (true)
    {
      if ((i >= paramArrayOfDouble.length - 1) || (paramArrayOfDouble[i] >= paramDouble))
        return i - 1;
      i += 1;
    }
  }

  private static double[] fromDoubleArray(ReadableArray paramReadableArray)
  {
    double[] arrayOfDouble = new double[paramReadableArray.size()];
    int i = 0;
    while (i < arrayOfDouble.length)
    {
      arrayOfDouble[i] = paramReadableArray.getDouble(i);
      i += 1;
    }
    return arrayOfDouble;
  }

  private static double interpolate(double paramDouble1, double paramDouble2, double paramDouble3, double paramDouble4, double paramDouble5, String paramString1, String paramString2)
  {
    double d = paramDouble1;
    paramDouble1 = d;
    int i;
    if (d < paramDouble2)
    {
      i = -1;
      switch (paramString1.hashCode())
      {
      default:
      case -135761730:
      case 94742715:
      case -1289044198:
      }
      while (true)
      {
        paramDouble1 = d;
        switch (i)
        {
        default:
          throw new JSApplicationIllegalArgumentException("Invalid extrapolation type " + paramString1 + "for left extrapolation");
          if (!paramString1.equals("identity"))
            continue;
          i = 0;
          continue;
          if (!paramString1.equals("clamp"))
            continue;
          i = 1;
          continue;
          if (!paramString1.equals("extend"))
            continue;
          i = 2;
        case 0:
        case 1:
        case 2:
        }
      }
      return d;
      paramDouble1 = paramDouble2;
    }
    d = paramDouble1;
    if (paramDouble1 > paramDouble3)
    {
      i = -1;
      switch (paramString2.hashCode())
      {
      default:
      case -135761730:
      case 94742715:
      case -1289044198:
      }
      while (true)
      {
        d = paramDouble1;
        switch (i)
        {
        default:
          throw new JSApplicationIllegalArgumentException("Invalid extrapolation type " + paramString2 + "for right extrapolation");
          if (!paramString2.equals("identity"))
            continue;
          i = 0;
          continue;
          if (!paramString2.equals("clamp"))
            continue;
          i = 1;
          continue;
          if (!paramString2.equals("extend"))
            continue;
          i = 2;
        case 0:
        case 1:
        case 2:
        }
      }
      return paramDouble1;
      d = paramDouble3;
    }
    return (paramDouble5 - paramDouble4) * (d - paramDouble2) / (paramDouble3 - paramDouble2) + paramDouble4;
  }

  static double interpolate(double paramDouble, double[] paramArrayOfDouble1, double[] paramArrayOfDouble2, String paramString1, String paramString2)
  {
    int i = findRangeIndex(paramDouble, paramArrayOfDouble1);
    return interpolate(paramDouble, paramArrayOfDouble1[i], paramArrayOfDouble1[(i + 1)], paramArrayOfDouble2[i], paramArrayOfDouble2[(i + 1)], paramString1, paramString2);
  }

  public void onAttachedToNode(AnimatedNode paramAnimatedNode)
  {
    if (this.mParent != null)
      throw new IllegalStateException("Parent already attached");
    if (!(paramAnimatedNode instanceof ValueAnimatedNode))
      throw new IllegalArgumentException("Parent is of an invalid type");
    this.mParent = ((ValueAnimatedNode)paramAnimatedNode);
  }

  public void onDetachedFromNode(AnimatedNode paramAnimatedNode)
  {
    if (paramAnimatedNode != this.mParent)
      throw new IllegalArgumentException("Invalid parent node provided");
    this.mParent = null;
  }

  public void update()
  {
    if (this.mParent == null)
      throw new IllegalStateException("Trying to update interpolation node that has not been attached to the parent");
    this.mValue = interpolate(this.mParent.getValue(), this.mInputRange, this.mOutputRange, this.mExtrapolateLeft, this.mExtrapolateRight);
  }
}

/* Location:           C:\Users\c_jealom1\Documents\Scripts\Android\Fathom_com.brynk.fathom\Fathom_com.brynk.fathom-dex2jar.jar
 * Qualified Name:     com.facebook.react.animated.InterpolationAnimatedNode
 * JD-Core Version:    0.6.0
 */
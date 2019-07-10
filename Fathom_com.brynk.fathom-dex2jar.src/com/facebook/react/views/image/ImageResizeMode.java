package com.facebook.react.views.image;

import com.facebook.drawee.drawable.ScalingUtils.ScaleType;
import com.facebook.react.bridge.JSApplicationIllegalArgumentException;
import javax.annotation.Nullable;

public class ImageResizeMode
{
  public static ScalingUtils.ScaleType defaultValue()
  {
    return ScalingUtils.ScaleType.CENTER_CROP;
  }

  public static ScalingUtils.ScaleType toScaleType(@Nullable String paramString)
  {
    if ("contain".equals(paramString))
      return ScalingUtils.ScaleType.FIT_CENTER;
    if ("cover".equals(paramString))
      return ScalingUtils.ScaleType.CENTER_CROP;
    if ("stretch".equals(paramString))
      return ScalingUtils.ScaleType.FIT_XY;
    if ("center".equals(paramString))
      return ScalingUtils.ScaleType.CENTER_INSIDE;
    if (paramString == null)
      return defaultValue();
    throw new JSApplicationIllegalArgumentException("Invalid resize mode: '" + paramString + "'");
  }
}

/* Location:           C:\Users\c_jealom1\Documents\Scripts\Android\Fathom_com.brynk.fathom\Fathom_com.brynk.fathom-dex2jar.jar
 * Qualified Name:     com.facebook.react.views.image.ImageResizeMode
 * JD-Core Version:    0.6.0
 */
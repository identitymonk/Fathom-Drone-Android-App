package com.facebook.react.flat;

import android.content.Context;
import com.facebook.drawee.drawable.ScalingUtils.ScaleType;
import com.facebook.react.bridge.ReadableArray;
import javax.annotation.Nullable;

abstract interface DrawImage extends AttachDetachListener
{
  public abstract int getBorderColor();

  public abstract float getBorderRadius();

  public abstract float getBorderWidth();

  public abstract ScalingUtils.ScaleType getScaleType();

  public abstract boolean hasImageRequest();

  public abstract void setBorderColor(int paramInt);

  public abstract void setBorderRadius(float paramFloat);

  public abstract void setBorderWidth(float paramFloat);

  public abstract void setFadeDuration(int paramInt);

  public abstract void setProgressiveRenderingEnabled(boolean paramBoolean);

  public abstract void setReactTag(int paramInt);

  public abstract void setScaleType(ScalingUtils.ScaleType paramScaleType);

  public abstract void setSource(Context paramContext, @Nullable ReadableArray paramReadableArray);

  public abstract void setTintColor(int paramInt);
}

/* Location:           C:\Users\c_jealom1\Documents\Scripts\Android\Fathom_com.brynk.fathom\Fathom_com.brynk.fathom-dex2jar.jar
 * Qualified Name:     com.facebook.react.flat.DrawImage
 * JD-Core Version:    0.6.0
 */
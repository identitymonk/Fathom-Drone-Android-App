package com.facebook.react.views.toolbar;

import android.graphics.drawable.Drawable;
import android.graphics.drawable.Drawable.Callback;
import com.facebook.drawee.drawable.ForwardingDrawable;
import com.facebook.imagepipeline.image.ImageInfo;

public class DrawableWithIntrinsicSize extends ForwardingDrawable
  implements Drawable.Callback
{
  private final ImageInfo mImageInfo;

  public DrawableWithIntrinsicSize(Drawable paramDrawable, ImageInfo paramImageInfo)
  {
    super(paramDrawable);
    this.mImageInfo = paramImageInfo;
  }

  public int getIntrinsicHeight()
  {
    return this.mImageInfo.getHeight();
  }

  public int getIntrinsicWidth()
  {
    return this.mImageInfo.getWidth();
  }
}

/* Location:           C:\Users\c_jealom1\Documents\Scripts\Android\Fathom_com.brynk.fathom\Fathom_com.brynk.fathom-dex2jar.jar
 * Qualified Name:     com.facebook.react.views.toolbar.DrawableWithIntrinsicSize
 * JD-Core Version:    0.6.0
 */
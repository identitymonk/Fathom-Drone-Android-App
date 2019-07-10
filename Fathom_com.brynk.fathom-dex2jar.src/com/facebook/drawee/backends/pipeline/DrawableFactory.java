package com.facebook.drawee.backends.pipeline;

import android.graphics.drawable.Drawable;
import com.facebook.imagepipeline.image.CloseableImage;
import javax.annotation.Nullable;

public abstract interface DrawableFactory
{
  @Nullable
  public abstract Drawable createDrawable(CloseableImage paramCloseableImage);

  public abstract boolean supportsImageType(CloseableImage paramCloseableImage);
}

/* Location:           C:\Users\c_jealom1\Documents\Scripts\Android\Fathom_com.brynk.fathom\Fathom_com.brynk.fathom-dex2jar.jar
 * Qualified Name:     com.facebook.drawee.backends.pipeline.DrawableFactory
 * JD-Core Version:    0.6.0
 */
package com.facebook.drawee.interfaces;

import android.graphics.drawable.Drawable;

public abstract interface SettableDraweeHierarchy extends DraweeHierarchy
{
  public abstract void reset();

  public abstract void setControllerOverlay(Drawable paramDrawable);

  public abstract void setFailure(Throwable paramThrowable);

  public abstract void setImage(Drawable paramDrawable, float paramFloat, boolean paramBoolean);

  public abstract void setProgress(float paramFloat, boolean paramBoolean);

  public abstract void setRetry(Throwable paramThrowable);
}

/* Location:           C:\Users\c_jealom1\Documents\Scripts\Android\Fathom_com.brynk.fathom\Fathom_com.brynk.fathom-dex2jar.jar
 * Qualified Name:     com.facebook.drawee.interfaces.SettableDraweeHierarchy
 * JD-Core Version:    0.6.0
 */
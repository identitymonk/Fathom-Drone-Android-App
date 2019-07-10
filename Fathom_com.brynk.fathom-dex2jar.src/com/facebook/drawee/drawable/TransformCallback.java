package com.facebook.drawee.drawable;

import android.graphics.Matrix;
import android.graphics.RectF;

public abstract interface TransformCallback
{
  public abstract void getRootBounds(RectF paramRectF);

  public abstract void getTransform(Matrix paramMatrix);
}

/* Location:           C:\Users\c_jealom1\Documents\Scripts\Android\Fathom_com.brynk.fathom\Fathom_com.brynk.fathom-dex2jar.jar
 * Qualified Name:     com.facebook.drawee.drawable.TransformCallback
 * JD-Core Version:    0.6.0
 */
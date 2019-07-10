package com.facebook.react.flat;

import android.graphics.Bitmap;

abstract interface BitmapUpdateListener
{
  public abstract void onBitmapReady(Bitmap paramBitmap);

  public abstract void onImageLoadEvent(int paramInt);

  public abstract void onSecondaryAttach(Bitmap paramBitmap);
}

/* Location:           C:\Users\c_jealom1\Documents\Scripts\Android\Fathom_com.brynk.fathom\Fathom_com.brynk.fathom-dex2jar.jar
 * Qualified Name:     com.facebook.react.flat.BitmapUpdateListener
 * JD-Core Version:    0.6.0
 */
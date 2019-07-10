package com.facebook.common.webp;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory.Options;
import android.graphics.Rect;
import java.io.FileDescriptor;
import java.io.InputStream;

public abstract interface WebpBitmapFactory
{
  public abstract Bitmap decodeByteArray(byte[] paramArrayOfByte, int paramInt1, int paramInt2, BitmapFactory.Options paramOptions);

  public abstract Bitmap decodeFile(String paramString, BitmapFactory.Options paramOptions);

  public abstract Bitmap decodeFileDescriptor(FileDescriptor paramFileDescriptor, Rect paramRect, BitmapFactory.Options paramOptions);

  public abstract Bitmap decodeStream(InputStream paramInputStream, Rect paramRect, BitmapFactory.Options paramOptions);

  public abstract void setBitmapCreator(BitmapCreator paramBitmapCreator);

  public abstract void setWebpErrorLogger(WebpErrorLogger paramWebpErrorLogger);

  public static abstract interface WebpErrorLogger
  {
    public abstract void onWebpErrorLog(String paramString1, String paramString2);
  }
}

/* Location:           C:\Users\c_jealom1\Documents\Scripts\Android\Fathom_com.brynk.fathom\Fathom_com.brynk.fathom-dex2jar.jar
 * Qualified Name:     com.facebook.common.webp.WebpBitmapFactory
 * JD-Core Version:    0.6.0
 */
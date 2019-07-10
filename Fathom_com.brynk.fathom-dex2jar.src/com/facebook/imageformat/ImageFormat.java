package com.facebook.imageformat;

import javax.annotation.Nullable;

public class ImageFormat
{
  public static final ImageFormat UNKNOWN = new ImageFormat("UNKNOWN", null);
  private final String mFileExtension;
  private final String mName;

  public ImageFormat(String paramString1, @Nullable String paramString2)
  {
    this.mName = paramString1;
    this.mFileExtension = paramString2;
  }

  @Nullable
  public String getFileExtension()
  {
    return this.mFileExtension;
  }

  public String getName()
  {
    return this.mName;
  }

  public String toString()
  {
    return getName();
  }

  public static abstract interface FormatChecker
  {
    @Nullable
    public abstract ImageFormat determineFormat(byte[] paramArrayOfByte, int paramInt);

    public abstract int getHeaderSize();
  }
}

/* Location:           C:\Users\c_jealom1\Documents\Scripts\Android\Fathom_com.brynk.fathom\Fathom_com.brynk.fathom-dex2jar.jar
 * Qualified Name:     com.facebook.imageformat.ImageFormat
 * JD-Core Version:    0.6.0
 */
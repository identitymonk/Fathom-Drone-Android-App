package com.facebook.imagepipeline.nativecode;

public class WebpTranscoderFactory
{
  private static WebpTranscoder sWebpTranscoder;
  public static boolean sWebpTranscoderPresent = false;

  static
  {
    try
    {
      sWebpTranscoder = (WebpTranscoder)Class.forName("com.facebook.imagepipeline.nativecode.WebpTranscoderImpl").newInstance();
      sWebpTranscoderPresent = true;
      return;
    }
    catch (Throwable localThrowable)
    {
      sWebpTranscoderPresent = false;
    }
  }

  public static WebpTranscoder getWebpTranscoder()
  {
    return sWebpTranscoder;
  }
}

/* Location:           C:\Users\c_jealom1\Documents\Scripts\Android\Fathom_com.brynk.fathom\Fathom_com.brynk.fathom-dex2jar.jar
 * Qualified Name:     com.facebook.imagepipeline.nativecode.WebpTranscoderFactory
 * JD-Core Version:    0.6.0
 */
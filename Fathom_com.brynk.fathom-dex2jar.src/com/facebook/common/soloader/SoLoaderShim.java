package com.facebook.common.soloader;

public class SoLoaderShim
{
  private static volatile Handler sHandler = new DefaultHandler();

  public static void loadLibrary(String paramString)
  {
    sHandler.loadLibrary(paramString);
  }

  public static void setHandler(Handler paramHandler)
  {
    if (paramHandler == null)
      throw new NullPointerException("Handler cannot be null");
    sHandler = paramHandler;
  }

  public static void setInTestMode()
  {
    setHandler(new Handler()
    {
      public void loadLibrary(String paramString)
      {
      }
    });
  }

  public static class DefaultHandler
    implements SoLoaderShim.Handler
  {
    public void loadLibrary(String paramString)
    {
      System.loadLibrary(paramString);
    }
  }

  public static abstract interface Handler
  {
    public abstract void loadLibrary(String paramString);
  }
}

/* Location:           C:\Users\c_jealom1\Documents\Scripts\Android\Fathom_com.brynk.fathom\Fathom_com.brynk.fathom-dex2jar.jar
 * Qualified Name:     com.facebook.common.soloader.SoLoaderShim
 * JD-Core Version:    0.6.0
 */
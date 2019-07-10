package com.facebook.react.uimanager;

public class ReactInvalidPropertyException extends RuntimeException
{
  public ReactInvalidPropertyException(String paramString1, String paramString2, String paramString3)
  {
    super("Invalid React property `" + paramString1 + "` with value `" + paramString2 + "`, expected " + paramString3);
  }
}

/* Location:           C:\Users\c_jealom1\Documents\Scripts\Android\Fathom_com.brynk.fathom\Fathom_com.brynk.fathom-dex2jar.jar
 * Qualified Name:     com.facebook.react.uimanager.ReactInvalidPropertyException
 * JD-Core Version:    0.6.0
 */
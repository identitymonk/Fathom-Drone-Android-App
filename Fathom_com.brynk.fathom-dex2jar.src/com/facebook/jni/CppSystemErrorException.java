package com.facebook.jni;

import com.facebook.proguard.annotations.DoNotStrip;

@DoNotStrip
public class CppSystemErrorException extends CppException
{
  int errorCode;

  @DoNotStrip
  public CppSystemErrorException(String paramString, int paramInt)
  {
    super(paramString);
    this.errorCode = paramInt;
  }

  public int getErrorCode()
  {
    return this.errorCode;
  }
}

/* Location:           C:\Users\c_jealom1\Documents\Scripts\Android\Fathom_com.brynk.fathom\Fathom_com.brynk.fathom-dex2jar.jar
 * Qualified Name:     com.facebook.jni.CppSystemErrorException
 * JD-Core Version:    0.6.0
 */
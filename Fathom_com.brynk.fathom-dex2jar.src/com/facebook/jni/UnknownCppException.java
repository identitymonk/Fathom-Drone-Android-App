package com.facebook.jni;

import com.facebook.proguard.annotations.DoNotStrip;

@DoNotStrip
public class UnknownCppException extends CppException
{
  @DoNotStrip
  public UnknownCppException()
  {
    super("Unknown");
  }

  @DoNotStrip
  public UnknownCppException(String paramString)
  {
    super(paramString);
  }
}

/* Location:           C:\Users\c_jealom1\Documents\Scripts\Android\Fathom_com.brynk.fathom\Fathom_com.brynk.fathom-dex2jar.jar
 * Qualified Name:     com.facebook.jni.UnknownCppException
 * JD-Core Version:    0.6.0
 */
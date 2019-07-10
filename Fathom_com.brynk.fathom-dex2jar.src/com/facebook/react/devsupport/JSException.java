package com.facebook.react.devsupport;

import com.facebook.proguard.annotations.DoNotStrip;

@DoNotStrip
public class JSException extends Exception
{
  private final String mStack;

  public JSException(String paramString1, String paramString2)
  {
    super(paramString1);
    this.mStack = paramString2;
  }

  @DoNotStrip
  public JSException(String paramString1, String paramString2, Throwable paramThrowable)
  {
    super(paramString1, paramThrowable);
    this.mStack = paramString2;
  }

  public String getStack()
  {
    return this.mStack;
  }
}

/* Location:           C:\Users\c_jealom1\Documents\Scripts\Android\Fathom_com.brynk.fathom\Fathom_com.brynk.fathom-dex2jar.jar
 * Qualified Name:     com.facebook.react.devsupport.JSException
 * JD-Core Version:    0.6.0
 */
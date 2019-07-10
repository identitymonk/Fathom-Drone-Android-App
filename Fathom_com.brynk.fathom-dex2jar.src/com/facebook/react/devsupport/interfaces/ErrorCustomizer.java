package com.facebook.react.devsupport.interfaces;

import android.util.Pair;

public abstract interface ErrorCustomizer
{
  public abstract Pair<String, StackFrame[]> customizeErrorInfo(Pair<String, StackFrame[]> paramPair);
}

/* Location:           C:\Users\c_jealom1\Documents\Scripts\Android\Fathom_com.brynk.fathom\Fathom_com.brynk.fathom-dex2jar.jar
 * Qualified Name:     com.facebook.react.devsupport.interfaces.ErrorCustomizer
 * JD-Core Version:    0.6.0
 */
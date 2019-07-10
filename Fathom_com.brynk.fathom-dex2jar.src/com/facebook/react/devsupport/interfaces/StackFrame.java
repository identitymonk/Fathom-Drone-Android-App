package com.facebook.react.devsupport.interfaces;

import org.json.JSONObject;

public abstract interface StackFrame
{
  public abstract int getColumn();

  public abstract String getFile();

  public abstract String getFileName();

  public abstract int getLine();

  public abstract String getMethod();

  public abstract JSONObject toJSON();
}

/* Location:           C:\Users\c_jealom1\Documents\Scripts\Android\Fathom_com.brynk.fathom\Fathom_com.brynk.fathom-dex2jar.jar
 * Qualified Name:     com.facebook.react.devsupport.interfaces.StackFrame
 * JD-Core Version:    0.6.0
 */
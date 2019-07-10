package com.facebook.react.bridge;

import javax.annotation.Nullable;

public abstract interface Promise
{
  @Deprecated
  public abstract void reject(String paramString);

  public abstract void reject(String paramString1, String paramString2);

  public abstract void reject(String paramString1, String paramString2, Throwable paramThrowable);

  public abstract void reject(String paramString, Throwable paramThrowable);

  public abstract void reject(Throwable paramThrowable);

  public abstract void resolve(@Nullable Object paramObject);
}

/* Location:           C:\Users\c_jealom1\Documents\Scripts\Android\Fathom_com.brynk.fathom\Fathom_com.brynk.fathom-dex2jar.jar
 * Qualified Name:     com.facebook.react.bridge.Promise
 * JD-Core Version:    0.6.0
 */
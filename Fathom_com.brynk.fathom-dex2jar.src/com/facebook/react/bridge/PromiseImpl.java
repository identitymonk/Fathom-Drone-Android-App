package com.facebook.react.bridge;

import javax.annotation.Nullable;

public class PromiseImpl
  implements Promise
{
  private static final String DEFAULT_ERROR = "EUNSPECIFIED";

  @Nullable
  private Callback mReject;

  @Nullable
  private Callback mResolve;

  public PromiseImpl(@Nullable Callback paramCallback1, @Nullable Callback paramCallback2)
  {
    this.mResolve = paramCallback1;
    this.mReject = paramCallback2;
  }

  @Deprecated
  public void reject(String paramString)
  {
    reject("EUNSPECIFIED", paramString, null);
  }

  public void reject(String paramString1, String paramString2)
  {
    reject(paramString1, paramString2, null);
  }

  public void reject(String paramString1, String paramString2, @Nullable Throwable paramThrowable)
  {
    if (this.mReject != null)
    {
      paramThrowable = paramString1;
      if (paramString1 == null)
        paramThrowable = "EUNSPECIFIED";
      paramString1 = new WritableNativeMap();
      paramString1.putString("code", paramThrowable);
      paramString1.putString("message", paramString2);
      this.mReject.invoke(new Object[] { paramString1 });
    }
  }

  public void reject(String paramString, Throwable paramThrowable)
  {
    reject(paramString, paramThrowable.getMessage(), paramThrowable);
  }

  public void reject(Throwable paramThrowable)
  {
    reject("EUNSPECIFIED", paramThrowable.getMessage(), paramThrowable);
  }

  public void resolve(Object paramObject)
  {
    if (this.mResolve != null)
      this.mResolve.invoke(new Object[] { paramObject });
  }
}

/* Location:           C:\Users\c_jealom1\Documents\Scripts\Android\Fathom_com.brynk.fathom\Fathom_com.brynk.fathom-dex2jar.jar
 * Qualified Name:     com.facebook.react.bridge.PromiseImpl
 * JD-Core Version:    0.6.0
 */
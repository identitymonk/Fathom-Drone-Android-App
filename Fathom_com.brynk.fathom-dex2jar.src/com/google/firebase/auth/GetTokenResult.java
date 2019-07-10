package com.google.firebase.auth;

import android.support.annotation.Nullable;

public class GetTokenResult
{
  private String hN;

  public GetTokenResult(String paramString)
  {
    this.hN = paramString;
  }

  @Nullable
  public String getToken()
  {
    return this.hN;
  }
}

/* Location:           C:\Users\c_jealom1\Documents\Scripts\Android\Fathom_com.brynk.fathom\Fathom_com.brynk.fathom-dex2jar.jar
 * Qualified Name:     com.google.firebase.auth.GetTokenResult
 * JD-Core Version:    0.6.0
 */
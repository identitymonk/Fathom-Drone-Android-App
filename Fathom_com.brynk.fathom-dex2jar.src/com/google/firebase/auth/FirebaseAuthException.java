package com.google.firebase.auth;

import android.support.annotation.NonNull;
import com.google.android.gms.common.internal.zzaa;
import com.google.firebase.FirebaseException;

public class FirebaseAuthException extends FirebaseException
{
  private final String aXe;

  public FirebaseAuthException(@NonNull String paramString1, @NonNull String paramString2)
  {
    super(paramString2);
    this.aXe = zzaa.zzib(paramString1);
  }

  @NonNull
  public String getErrorCode()
  {
    return this.aXe;
  }
}

/* Location:           C:\Users\c_jealom1\Documents\Scripts\Android\Fathom_com.brynk.fathom\Fathom_com.brynk.fathom-dex2jar.jar
 * Qualified Name:     com.google.firebase.auth.FirebaseAuthException
 * JD-Core Version:    0.6.0
 */
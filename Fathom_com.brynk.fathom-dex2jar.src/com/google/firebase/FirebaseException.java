package com.google.firebase;

import android.support.annotation.NonNull;
import com.google.android.gms.common.internal.zzaa;

public class FirebaseException extends Exception
{
  @Deprecated
  protected FirebaseException()
  {
  }

  public FirebaseException(@NonNull String paramString)
  {
    super(zzaa.zzh(paramString, "Detail message must not be empty"));
  }

  public FirebaseException(@NonNull String paramString, Throwable paramThrowable)
  {
    super(zzaa.zzh(paramString, "Detail message must not be empty"), paramThrowable);
  }
}

/* Location:           C:\Users\c_jealom1\Documents\Scripts\Android\Fathom_com.brynk.fathom\Fathom_com.brynk.fathom-dex2jar.jar
 * Qualified Name:     com.google.firebase.FirebaseException
 * JD-Core Version:    0.6.0
 */
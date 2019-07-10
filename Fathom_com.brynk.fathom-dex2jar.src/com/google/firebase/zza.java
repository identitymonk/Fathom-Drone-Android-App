package com.google.firebase;

import com.google.android.gms.common.api.Status;
import com.google.android.gms.internal.zzsb;

public class zza
  implements zzsb
{
  public Exception zzz(Status paramStatus)
  {
    if (paramStatus.getStatusCode() == 8)
      return new FirebaseException(paramStatus.zzark());
    return new FirebaseApiNotAvailableException(paramStatus.zzark());
  }
}

/* Location:           C:\Users\c_jealom1\Documents\Scripts\Android\Fathom_com.brynk.fathom\Fathom_com.brynk.fathom-dex2jar.jar
 * Qualified Name:     com.google.firebase.zza
 * JD-Core Version:    0.6.0
 */
package com.google.android.gms.common.internal;

import android.accounts.Account;
import android.os.Binder;
import android.util.Log;
import com.google.android.gms.common.zze;

public class zza extends zzp.zza
{
  int De;

  public static Account zza(zzp paramzzp)
  {
    Account localAccount = null;
    long l;
    if (paramzzp != null)
      l = Binder.clearCallingIdentity();
    try
    {
      localAccount = paramzzp.getAccount();
      return localAccount;
    }
    catch (android.os.RemoteException paramzzp)
    {
      Log.w("AccountAccessor", "Remote account accessor probably died");
      return null;
    }
    finally
    {
      Binder.restoreCallingIdentity(l);
    }
    throw paramzzp;
  }

  public boolean equals(Object paramObject)
  {
    if (this == paramObject)
      return true;
    if (!(paramObject instanceof zza))
      return false;
    paramObject = (zza)paramObject;
    throw new NullPointerException();
  }

  public Account getAccount()
  {
    int i = Binder.getCallingUid();
    if (i == this.De)
      return null;
    if (zze.zzf(null, i))
    {
      this.De = i;
      return null;
    }
    throw new SecurityException("Caller is not GooglePlayServices");
  }
}

/* Location:           C:\Users\c_jealom1\Documents\Scripts\Android\Fathom_com.brynk.fathom\Fathom_com.brynk.fathom-dex2jar.jar
 * Qualified Name:     com.google.android.gms.common.internal.zza
 * JD-Core Version:    0.6.0
 */
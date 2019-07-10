package com.google.android.gms.internal;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;

public final class zzrj extends BroadcastReceiver
{
  private final zza AZ;
  protected Context mContext;

  public zzrj(zza paramzza)
  {
    this.AZ = paramzza;
  }

  public void onReceive(Context paramContext, Intent paramIntent)
  {
    paramIntent = paramIntent.getData();
    paramContext = null;
    if (paramIntent != null)
      paramContext = paramIntent.getSchemeSpecificPart();
    if ("com.google.android.gms".equals(paramContext))
    {
      this.AZ.zzarr();
      unregister();
    }
  }

  public void setContext(Context paramContext)
  {
    this.mContext = paramContext;
  }

  public void unregister()
  {
    monitorenter;
    try
    {
      if (this.mContext != null)
        this.mContext.unregisterReceiver(this);
      this.mContext = null;
      return;
    }
    finally
    {
      monitorexit;
    }
    throw localObject;
  }

  public static abstract class zza
  {
    public abstract void zzarr();
  }
}

/* Location:           C:\Users\c_jealom1\Documents\Scripts\Android\Fathom_com.brynk.fathom\Fathom_com.brynk.fathom-dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.zzrj
 * JD-Core Version:    0.6.0
 */
package com.google.android.gms.security;

import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.util.Log;
import com.google.android.gms.common.GooglePlayServicesNotAvailableException;
import com.google.android.gms.common.GooglePlayServicesRepairableException;
import com.google.android.gms.common.internal.zzaa;
import com.google.android.gms.common.zzc;
import com.google.android.gms.common.zze;
import java.lang.reflect.Method;

public class ProviderInstaller
{
  public static final String PROVIDER_NAME = "GmsCore_OpenSSL";
  private static final zzc aDf = zzc.zzaql();
  private static Method aDg;
  private static final Object zzaox = new Object();

  static
  {
    aDg = null;
  }

  public static void installIfNeeded(Context paramContext)
    throws GooglePlayServicesRepairableException, GooglePlayServicesNotAvailableException
  {
    zzaa.zzb(paramContext, "Context must not be null");
    aDf.zzbm(paramContext);
    paramContext = zze.getRemoteContext(paramContext);
    if (paramContext == null)
    {
      Log.e("ProviderInstaller", "Failed to get remote context");
      throw new GooglePlayServicesNotAvailableException(8);
    }
    while (true)
    {
      synchronized (zzaox)
      {
        try
        {
          if (aDg != null)
            continue;
          zzdv(paramContext);
          aDg.invoke(null, new Object[] { paramContext });
          return;
        }
        catch (Exception paramContext)
        {
          paramContext = String.valueOf(paramContext.getMessage());
          if (paramContext.length() == 0)
            break label121;
        }
        paramContext = "Failed to install provider: ".concat(paramContext);
        Log.e("ProviderInstaller", paramContext);
        throw new GooglePlayServicesNotAvailableException(8);
      }
      label121: paramContext = new String("Failed to install provider: ");
    }
  }

  public static void installIfNeededAsync(Context paramContext, ProviderInstallListener paramProviderInstallListener)
  {
    zzaa.zzb(paramContext, "Context must not be null");
    zzaa.zzb(paramProviderInstallListener, "Listener must not be null");
    zzaa.zzhs("Must be called on the UI thread");
    new AsyncTask(paramContext, paramProviderInstallListener)
    {
      protected Integer zzc(Void[] paramArrayOfVoid)
      {
        try
        {
          ProviderInstaller.installIfNeeded(ProviderInstaller.this);
          return Integer.valueOf(0);
        }
        catch (GooglePlayServicesRepairableException paramArrayOfVoid)
        {
          return Integer.valueOf(paramArrayOfVoid.getConnectionStatusCode());
        }
        catch (GooglePlayServicesNotAvailableException paramArrayOfVoid)
        {
        }
        return Integer.valueOf(paramArrayOfVoid.errorCode);
      }

      protected void zzg(Integer paramInteger)
      {
        if (paramInteger.intValue() == 0)
        {
          this.aDh.onProviderInstalled();
          return;
        }
        Intent localIntent = ProviderInstaller.zzcda().zzb(ProviderInstaller.this, paramInteger.intValue(), "pi");
        this.aDh.onProviderInstallFailed(paramInteger.intValue(), localIntent);
      }
    }
    .execute(new Void[0]);
  }

  private static void zzdv(Context paramContext)
    throws ClassNotFoundException, NoSuchMethodException
  {
    aDg = paramContext.getClassLoader().loadClass("com.google.android.gms.common.security.ProviderInstallerImpl").getMethod("insertProvider", new Class[] { Context.class });
  }

  public static abstract interface ProviderInstallListener
  {
    public abstract void onProviderInstallFailed(int paramInt, Intent paramIntent);

    public abstract void onProviderInstalled();
  }
}

/* Location:           C:\Users\c_jealom1\Documents\Scripts\Android\Fathom_com.brynk.fathom\Fathom_com.brynk.fathom-dex2jar.jar
 * Qualified Name:     com.google.android.gms.security.ProviderInstaller
 * JD-Core Version:    0.6.0
 */
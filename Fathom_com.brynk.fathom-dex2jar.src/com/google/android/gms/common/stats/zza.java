package com.google.android.gms.common.stats;

import android.annotation.SuppressLint;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.util.Log;
import com.google.android.gms.internal.zzsi;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class zza
{
  private static final Object El = new Object();
  private static Integer FF;
  private static zza Fz;
  private final List<String> FA;
  private final List<String> FB;
  private final List<String> FC;
  private final List<String> FD;
  private zzd FE;
  private zzd FG;

  private zza()
  {
    if (zzaxs())
    {
      this.FA = Collections.EMPTY_LIST;
      this.FB = Collections.EMPTY_LIST;
      this.FC = Collections.EMPTY_LIST;
      this.FD = Collections.EMPTY_LIST;
      return;
    }
    Object localObject = (String)zzb.zza.FK.get();
    if (localObject == null)
    {
      localObject = Collections.EMPTY_LIST;
      this.FA = ((List)localObject);
      localObject = (String)zzb.zza.FL.get();
      if (localObject != null)
        break label198;
      localObject = Collections.EMPTY_LIST;
      label81: this.FB = ((List)localObject);
      localObject = (String)zzb.zza.FM.get();
      if (localObject != null)
        break label211;
      localObject = Collections.EMPTY_LIST;
      label104: this.FC = ((List)localObject);
      localObject = (String)zzb.zza.FN.get();
      if (localObject != null)
        break label224;
    }
    label198: label211: label224: for (localObject = Collections.EMPTY_LIST; ; localObject = Arrays.asList(((String)localObject).split(",")))
    {
      this.FD = ((List)localObject);
      this.FE = new zzd(1024, ((Long)zzb.zza.FO.get()).longValue());
      this.FG = new zzd(1024, ((Long)zzb.zza.FO.get()).longValue());
      return;
      localObject = Arrays.asList(((String)localObject).split(","));
      break;
      localObject = Arrays.asList(((String)localObject).split(","));
      break label81;
      localObject = Arrays.asList(((String)localObject).split(","));
      break label104;
    }
  }

  private static int getLogLevel()
  {
    if (FF == null);
    try
    {
      if (com.google.android.gms.common.util.zzd.zzayi());
      for (int i = ((Integer)zzb.zza.FJ.get()).intValue(); ; i = zzc.LOG_LEVEL_OFF)
      {
        FF = Integer.valueOf(i);
        return FF.intValue();
      }
    }
    catch (SecurityException localSecurityException)
    {
      while (true)
        FF = Integer.valueOf(zzc.LOG_LEVEL_OFF);
    }
  }

  public static zza zzaxr()
  {
    synchronized (El)
    {
      if (Fz == null)
        Fz = new zza();
      return Fz;
    }
  }

  private boolean zzaxs()
  {
    return getLogLevel() == zzc.LOG_LEVEL_OFF;
  }

  private boolean zzc(Context paramContext, Intent paramIntent)
  {
    paramIntent = paramIntent.getComponent();
    if (paramIntent == null)
      return false;
    return com.google.android.gms.common.util.zzd.zzx(paramContext, paramIntent.getPackageName());
  }

  @SuppressLint({"UntrackedBindService"})
  public void zza(Context paramContext, ServiceConnection paramServiceConnection)
  {
    paramContext.unbindService(paramServiceConnection);
  }

  public void zza(Context paramContext, ServiceConnection paramServiceConnection, String paramString, Intent paramIntent)
  {
  }

  public boolean zza(Context paramContext, Intent paramIntent, ServiceConnection paramServiceConnection, int paramInt)
  {
    return zza(paramContext, paramContext.getClass().getName(), paramIntent, paramServiceConnection, paramInt);
  }

  @SuppressLint({"UntrackedBindService"})
  public boolean zza(Context paramContext, String paramString, Intent paramIntent, ServiceConnection paramServiceConnection, int paramInt)
  {
    if (zzc(paramContext, paramIntent))
    {
      Log.w("ConnectionTracker", "Attempted to bind to a service in a STOPPED package.");
      return false;
    }
    return paramContext.bindService(paramIntent, paramServiceConnection, paramInt);
  }

  public void zzb(Context paramContext, ServiceConnection paramServiceConnection)
  {
  }
}

/* Location:           C:\Users\c_jealom1\Documents\Scripts\Android\Fathom_com.brynk.fathom\Fathom_com.brynk.fathom-dex2jar.jar
 * Qualified Name:     com.google.android.gms.common.stats.zza
 * JD-Core Version:    0.6.0
 */
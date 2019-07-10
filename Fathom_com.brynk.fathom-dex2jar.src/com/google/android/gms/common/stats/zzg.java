package com.google.android.gms.common.stats;

import android.content.Context;
import android.content.Intent;
import android.os.SystemClock;
import android.text.TextUtils;
import android.util.Log;
import com.google.android.gms.common.util.zzd;
import com.google.android.gms.common.util.zzj;
import com.google.android.gms.internal.zzsi;
import java.util.List;

public class zzg
{
  private static zzg Gn;
  private static Boolean Go;
  private static String TAG = "WakeLockTracker";

  static
  {
    Gn = new zzg();
  }

  public static zzg zzayg()
  {
    return Gn;
  }

  private static boolean zzcg(Context paramContext)
  {
    if (Go == null)
      Go = Boolean.valueOf(zzch(paramContext));
    return Go.booleanValue();
  }

  private static boolean zzch(Context paramContext)
  {
    int k = 0;
    try
    {
      if (zzd.zzayi())
      {
        int i = ((Integer)zzb.zzb.FJ.get()).intValue();
        int j = zzc.LOG_LEVEL_OFF;
        if (i == j)
          break label34;
      }
      label34: for (k = 1; ; k = 0)
        return k;
    }
    catch (java.lang.SecurityException paramContext)
    {
    }
    return false;
  }

  public void zza(Context paramContext, String paramString1, int paramInt1, String paramString2, String paramString3, String paramString4, int paramInt2, List<String> paramList)
  {
    zza(paramContext, paramString1, paramInt1, paramString2, paramString3, paramString4, paramInt2, paramList, 0L);
  }

  public void zza(Context paramContext, String paramString1, int paramInt1, String paramString2, String paramString3, String paramString4, int paramInt2, List<String> paramList, long paramLong)
  {
    if (!zzcg(paramContext));
    long l;
    do
    {
      return;
      if (TextUtils.isEmpty(paramString1))
      {
        paramString2 = TAG;
        paramContext = String.valueOf(paramString1);
        if (paramContext.length() != 0);
        for (paramContext = "missing wakeLock key. ".concat(paramContext); ; paramContext = new String("missing wakeLock key. "))
        {
          Log.e(paramString2, paramContext);
          return;
        }
      }
      l = System.currentTimeMillis();
    }
    while ((7 != paramInt1) && (8 != paramInt1) && (10 != paramInt1) && (11 != paramInt1));
    paramString1 = new WakeLockEvent(l, paramInt1, paramString2, paramInt2, zze.zzz(paramList), paramString1, SystemClock.elapsedRealtime(), zzj.zzck(paramContext), paramString3, zze.zzih(paramContext.getPackageName()), zzj.zzcl(paramContext), paramLong, paramString4);
    try
    {
      paramContext.startService(new Intent().setComponent(zzc.FP).putExtra("com.google.android.gms.common.stats.EXTRA_LOG_EVENT", paramString1));
      return;
    }
    catch (java.lang.Exception paramContext)
    {
      Log.wtf(TAG, paramContext);
    }
  }
}

/* Location:           C:\Users\c_jealom1\Documents\Scripts\Android\Fathom_com.brynk.fathom\Fathom_com.brynk.fathom-dex2jar.jar
 * Qualified Name:     com.google.android.gms.common.stats.zzg
 * JD-Core Version:    0.6.0
 */
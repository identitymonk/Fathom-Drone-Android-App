package com.google.android.gms.common.util;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.PowerManager;
import android.os.SystemClock;

public final class zzj
{
  private static IntentFilter Gv = new IntentFilter("android.intent.action.BATTERY_CHANGED");
  private static long Gw;
  private static float Gx = (0.0F / 0.0F);

  @TargetApi(20)
  public static boolean zzb(PowerManager paramPowerManager)
  {
    if (zzs.zzayv())
      return paramPowerManager.isInteractive();
    return paramPowerManager.isScreenOn();
  }

  @TargetApi(20)
  public static int zzck(Context paramContext)
  {
    int k = 1;
    if ((paramContext == null) || (paramContext.getApplicationContext() == null))
      return -1;
    Intent localIntent = paramContext.getApplicationContext().registerReceiver(null, Gv);
    if (localIntent == null)
    {
      i = 0;
      if ((i & 0x7) == 0)
        break label72;
    }
    label72: for (int i = 1; ; i = 0)
    {
      paramContext = (PowerManager)paramContext.getSystemService("power");
      if (paramContext != null)
        break label77;
      return -1;
      i = localIntent.getIntExtra("plugged", 0);
      break;
    }
    label77: int j;
    if (zzb(paramContext))
    {
      j = 1;
      if (i == 0)
        break label103;
    }
    label103: for (i = k; ; i = 0)
    {
      return j << 1 | i;
      j = 0;
      break;
    }
  }

  public static float zzcl(Context paramContext)
  {
    monitorenter;
    try
    {
      float f;
      if ((SystemClock.elapsedRealtime() - Gw < 60000L) && (!Float.isNaN(Gx)))
        f = Gx;
      while (true)
      {
        return f;
        paramContext = paramContext.getApplicationContext().registerReceiver(null, Gv);
        if (paramContext != null)
        {
          int i = paramContext.getIntExtra("level", -1);
          int j = paramContext.getIntExtra("scale", -1);
          Gx = i / j;
        }
        Gw = SystemClock.elapsedRealtime();
        f = Gx;
      }
    }
    finally
    {
      monitorexit;
    }
    throw paramContext;
  }
}

/* Location:           C:\Users\c_jealom1\Documents\Scripts\Android\Fathom_com.brynk.fathom\Fathom_com.brynk.fathom-dex2jar.jar
 * Qualified Name:     com.google.android.gms.common.util.zzj
 * JD-Core Version:    0.6.0
 */
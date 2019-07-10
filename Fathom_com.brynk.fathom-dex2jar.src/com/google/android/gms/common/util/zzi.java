package com.google.android.gms.common.util;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.pm.PackageManager;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Build;
import com.google.android.gms.common.zze;

public final class zzi
{
  private static Boolean Gr;
  private static Boolean Gs;
  private static Boolean Gt;
  private static Boolean Gu;

  public static boolean zzaym()
  {
    boolean bool = zze.xb;
    return "user".equals(Build.TYPE);
  }

  public static boolean zzb(Resources paramResources)
  {
    boolean bool = false;
    if (paramResources == null)
      return false;
    if (Gr == null)
      if ((paramResources.getConfiguration().screenLayout & 0xF) <= 3)
        break label63;
    label63: for (int i = 1; ; i = 0)
    {
      if (((zzs.zzayn()) && (i != 0)) || (zzc(paramResources)))
        bool = true;
      Gr = Boolean.valueOf(bool);
      return Gr.booleanValue();
    }
  }

  @TargetApi(13)
  private static boolean zzc(Resources paramResources)
  {
    if (Gs == null)
    {
      paramResources = paramResources.getConfiguration();
      if ((!zzs.zzayp()) || ((paramResources.screenLayout & 0xF) > 3) || (paramResources.smallestScreenWidthDp < 600))
        break label54;
    }
    label54: for (boolean bool = true; ; bool = false)
    {
      Gs = Boolean.valueOf(bool);
      return Gs.booleanValue();
    }
  }

  @TargetApi(20)
  public static boolean zzci(Context paramContext)
  {
    if (Gt == null)
      if ((!zzs.zzayv()) || (!paramContext.getPackageManager().hasSystemFeature("android.hardware.type.watch")))
        break label40;
    label40: for (boolean bool = true; ; bool = false)
    {
      Gt = Boolean.valueOf(bool);
      return Gt.booleanValue();
    }
  }

  @TargetApi(21)
  public static boolean zzcj(Context paramContext)
  {
    if (Gu == null)
      if ((!zzs.zzayx()) || (!paramContext.getPackageManager().hasSystemFeature("cn.google")))
        break label40;
    label40: for (boolean bool = true; ; bool = false)
    {
      Gu = Boolean.valueOf(bool);
      return Gu.booleanValue();
    }
  }
}

/* Location:           C:\Users\c_jealom1\Documents\Scripts\Android\Fathom_com.brynk.fathom\Fathom_com.brynk.fathom-dex2jar.jar
 * Qualified Name:     com.google.android.gms.common.util.zzi
 * JD-Core Version:    0.6.0
 */
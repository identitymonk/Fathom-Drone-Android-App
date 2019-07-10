package com.google.android.gms.common.util;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.os.Bundle;
import android.support.annotation.Nullable;
import com.google.android.gms.internal.zzsy;
import com.google.android.gms.internal.zzsz;

public class zzd
{
  public static int zza(PackageInfo paramPackageInfo)
  {
    if ((paramPackageInfo == null) || (paramPackageInfo.applicationInfo == null));
    do
    {
      return -1;
      paramPackageInfo = paramPackageInfo.applicationInfo.metaData;
    }
    while (paramPackageInfo == null);
    return paramPackageInfo.getInt("com.google.android.gms.version", -1);
  }

  public static boolean zzayi()
  {
    return false;
  }

  public static int zzv(Context paramContext, String paramString)
  {
    return zza(zzw(paramContext, paramString));
  }

  @Nullable
  public static PackageInfo zzw(Context paramContext, String paramString)
  {
    try
    {
      paramContext = zzsz.zzco(paramContext).getPackageInfo(paramString, 128);
      return paramContext;
    }
    catch (android.content.pm.PackageManager.NameNotFoundException paramContext)
    {
    }
    return null;
  }

  @TargetApi(12)
  public static boolean zzx(Context paramContext, String paramString)
  {
    if (!zzs.zzayo());
    while (true)
    {
      return false;
      if (("com.google.android.gms".equals(paramString)) && (zzayi()))
        continue;
      try
      {
        int i = zzsz.zzco(paramContext).getApplicationInfo(paramString, 0).flags;
        if ((i & 0x200000) != 0)
          return true;
      }
      catch (android.content.pm.PackageManager.NameNotFoundException paramContext)
      {
      }
    }
    return false;
  }
}

/* Location:           C:\Users\c_jealom1\Documents\Scripts\Android\Fathom_com.brynk.fathom\Fathom_com.brynk.fathom-dex2jar.jar
 * Qualified Name:     com.google.android.gms.common.util.zzd
 * JD-Core Version:    0.6.0
 */
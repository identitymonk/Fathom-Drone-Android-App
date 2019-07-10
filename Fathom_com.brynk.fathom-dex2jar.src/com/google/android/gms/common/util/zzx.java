package com.google.android.gms.common.util;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.util.Log;
import com.google.android.gms.common.zzf;
import com.google.android.gms.internal.zzsy;
import com.google.android.gms.internal.zzsz;

public final class zzx
{
  @TargetApi(19)
  public static boolean zzc(Context paramContext, int paramInt, String paramString)
  {
    return zzsz.zzco(paramContext).zzg(paramInt, paramString);
  }

  public static boolean zzf(Context paramContext, int paramInt)
  {
    if (!zzc(paramContext, paramInt, "com.google.android.gms"));
    do
    {
      return false;
      Object localObject = paramContext.getPackageManager();
      try
      {
        localObject = ((PackageManager)localObject).getPackageInfo("com.google.android.gms", 64);
        return zzf.zzbv(paramContext).zzb(paramContext.getPackageManager(), (PackageInfo)localObject);
      }
      catch (android.content.pm.PackageManager.NameNotFoundException paramContext)
      {
      }
    }
    while (!Log.isLoggable("UidVerifier", 3));
    Log.d("UidVerifier", "Package manager can't find google play services package, defaulting to false");
    return false;
  }
}

/* Location:           C:\Users\c_jealom1\Documents\Scripts\Android\Fathom_com.brynk.fathom\Fathom_com.brynk.fathom-dex2jar.jar
 * Qualified Name:     com.google.android.gms.common.util.zzx
 * JD-Core Version:    0.6.0
 */
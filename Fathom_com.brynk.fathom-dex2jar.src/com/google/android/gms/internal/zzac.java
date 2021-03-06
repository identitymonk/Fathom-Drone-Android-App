package com.google.android.gms.internal;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.net.http.AndroidHttpClient;
import android.os.Build.VERSION;
import java.io.File;

public class zzac
{
  public static zzl zza(Context paramContext)
  {
    return zza(paramContext, null);
  }

  public static zzl zza(Context paramContext, zzy paramzzy)
  {
    File localFile = new File(paramContext.getCacheDir(), "volley");
    Object localObject = "volley/0";
    try
    {
      String str = paramContext.getPackageName();
      int i = paramContext.getPackageManager().getPackageInfo(str, 0).versionCode;
      paramContext = String.valueOf(str).length() + 12 + str + "/" + i;
      localObject = paramContext;
      label76: paramContext = paramzzy;
      if (paramzzy == null)
        if (Build.VERSION.SDK_INT < 9)
          break label131;
      label131: for (paramContext = new zzz(); ; paramContext = new zzw(AndroidHttpClient.newInstance((String)localObject)))
      {
        paramContext = new zzt(paramContext);
        paramContext = new zzl(new zzv(localFile), paramContext);
        paramContext.start();
        return paramContext;
      }
    }
    catch (android.content.pm.PackageManager.NameNotFoundException paramContext)
    {
      break label76;
    }
  }
}

/* Location:           C:\Users\c_jealom1\Documents\Scripts\Android\Fathom_com.brynk.fathom\Fathom_com.brynk.fathom-dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.zzac
 * JD-Core Version:    0.6.0
 */
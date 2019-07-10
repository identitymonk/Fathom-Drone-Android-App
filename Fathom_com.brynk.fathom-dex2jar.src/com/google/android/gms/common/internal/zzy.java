package com.google.android.gms.common.internal;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.os.Bundle;
import android.util.Log;
import com.google.android.gms.internal.zzsy;
import com.google.android.gms.internal.zzsz;

public class zzy
{
  private static String EE;
  private static int EF;
  private static Object zzaox = new Object();
  private static boolean zzchk;

  public static String zzcd(Context paramContext)
  {
    zzcf(paramContext);
    return EE;
  }

  public static int zzce(Context paramContext)
  {
    zzcf(paramContext);
    return EF;
  }

  private static void zzcf(Context paramContext)
  {
    String str;
    synchronized (zzaox)
    {
      if (zzchk)
        return;
      zzchk = true;
      str = paramContext.getPackageName();
      paramContext = zzsz.zzco(paramContext);
    }
    try
    {
      paramContext = paramContext.getApplicationInfo(str, 128).metaData;
      if (paramContext == null)
      {
        monitorexit;
        return;
        paramContext = finally;
        monitorexit;
        throw paramContext;
      }
      EE = paramContext.getString("com.google.app.id");
      EF = paramContext.getInt("com.google.android.gms.version");
      monitorexit;
      return;
    }
    catch (android.content.pm.PackageManager.NameNotFoundException paramContext)
    {
      while (true)
        Log.wtf("MetadataValueReader", "This should never happen.", paramContext);
    }
  }
}

/* Location:           C:\Users\c_jealom1\Documents\Scripts\Android\Fathom_com.brynk.fathom\Fathom_com.brynk.fathom-dex2jar.jar
 * Qualified Name:     com.google.android.gms.common.internal.zzy
 * JD-Core Version:    0.6.0
 */
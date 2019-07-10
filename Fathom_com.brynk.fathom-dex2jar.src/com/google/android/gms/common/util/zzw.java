package com.google.android.gms.common.util;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.util.Log;
import java.io.File;

public class zzw
{
  @TargetApi(21)
  public static File getNoBackupFilesDir(Context paramContext)
  {
    if (zzs.zzayx())
      return paramContext.getNoBackupFilesDir();
    return zze(new File(paramContext.getApplicationInfo().dataDir, "no_backup"));
  }

  private static File zze(File paramFile)
  {
    monitorenter;
    File localFile = paramFile;
    try
    {
      if (!paramFile.exists())
      {
        localFile = paramFile;
        if (!paramFile.mkdirs())
        {
          boolean bool = paramFile.exists();
          if (!bool)
            break label37;
          localFile = paramFile;
        }
      }
      return localFile;
      label37: paramFile = String.valueOf(paramFile.getPath());
      if (paramFile.length() != 0);
      for (paramFile = "Unable to create no-backup dir ".concat(paramFile); ; paramFile = new String("Unable to create no-backup dir "))
      {
        Log.w("SupportV4Utils", paramFile);
        localFile = null;
        break;
      }
    }
    finally
    {
      monitorexit;
    }
    throw paramFile;
  }
}

/* Location:           C:\Users\c_jealom1\Documents\Scripts\Android\Fathom_com.brynk.fathom\Fathom_com.brynk.fathom-dex2jar.jar
 * Qualified Name:     com.google.android.gms.common.util.zzw
 * JD-Core Version:    0.6.0
 */
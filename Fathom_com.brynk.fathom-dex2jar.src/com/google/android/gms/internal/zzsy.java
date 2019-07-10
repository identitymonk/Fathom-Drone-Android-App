package com.google.android.gms.internal;

import android.annotation.TargetApi;
import android.app.AppOpsManager;
import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import com.google.android.gms.common.util.zzs;

public class zzsy
{
  protected final Context mContext;

  public zzsy(Context paramContext)
  {
    this.mContext = paramContext;
  }

  public int checkCallingOrSelfPermission(String paramString)
  {
    return this.mContext.checkCallingOrSelfPermission(paramString);
  }

  public int checkPermission(String paramString1, String paramString2)
  {
    return this.mContext.getPackageManager().checkPermission(paramString1, paramString2);
  }

  public ApplicationInfo getApplicationInfo(String paramString, int paramInt)
    throws PackageManager.NameNotFoundException
  {
    return this.mContext.getPackageManager().getApplicationInfo(paramString, paramInt);
  }

  public PackageInfo getPackageInfo(String paramString, int paramInt)
    throws PackageManager.NameNotFoundException
  {
    return this.mContext.getPackageManager().getPackageInfo(paramString, paramInt);
  }

  public String[] getPackagesForUid(int paramInt)
  {
    return this.mContext.getPackageManager().getPackagesForUid(paramInt);
  }

  @TargetApi(19)
  public boolean zzg(int paramInt, String paramString)
  {
    int j = 0;
    if (zzs.zzayu());
    try
    {
      ((AppOpsManager)this.mContext.getSystemService("appops")).checkPackage(paramInt, paramString);
      int i = 1;
      String[] arrayOfString;
      do
      {
        do
        {
          return i;
          arrayOfString = this.mContext.getPackageManager().getPackagesForUid(paramInt);
          i = j;
        }
        while (paramString == null);
        i = j;
      }
      while (arrayOfString == null);
      paramInt = 0;
      while (true)
      {
        i = j;
        if (paramInt >= arrayOfString.length)
          break;
        if (paramString.equals(arrayOfString[paramInt]))
          return true;
        paramInt += 1;
      }
    }
    catch (java.lang.SecurityException paramString)
    {
    }
    return false;
  }

  public CharSequence zzik(String paramString)
    throws PackageManager.NameNotFoundException
  {
    return this.mContext.getPackageManager().getApplicationLabel(this.mContext.getPackageManager().getApplicationInfo(paramString, 0));
  }
}

/* Location:           C:\Users\c_jealom1\Documents\Scripts\Android\Fathom_com.brynk.fathom\Fathom_com.brynk.fathom-dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.zzsy
 * JD-Core Version:    0.6.0
 */
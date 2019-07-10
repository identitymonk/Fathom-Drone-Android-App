package com.google.android.gms.common;

import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import com.google.android.gms.common.internal.zzn;
import com.google.android.gms.common.util.zzi;
import com.google.android.gms.internal.zzsy;
import com.google.android.gms.internal.zzsz;

public class zzc
{
  public static final String GOOGLE_PLAY_SERVICES_PACKAGE = "com.google.android.gms";
  public static final int GOOGLE_PLAY_SERVICES_VERSION_CODE = zze.GOOGLE_PLAY_SERVICES_VERSION_CODE;
  private static final zzc wT = new zzc();

  public static zzc zzaql()
  {
    return wT;
  }

  static String zzt(@Nullable Context paramContext, @Nullable String paramString)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("gcore_");
    localStringBuilder.append(GOOGLE_PLAY_SERVICES_VERSION_CODE);
    localStringBuilder.append("-");
    if (!TextUtils.isEmpty(paramString))
      localStringBuilder.append(paramString);
    localStringBuilder.append("-");
    if (paramContext != null)
      localStringBuilder.append(paramContext.getPackageName());
    localStringBuilder.append("-");
    if (paramContext != null);
    try
    {
      localStringBuilder.append(zzsz.zzco(paramContext).getPackageInfo(paramContext.getPackageName(), 0).versionCode);
      label94: return localStringBuilder.toString();
    }
    catch (android.content.pm.PackageManager.NameNotFoundException paramContext)
    {
      break label94;
    }
  }

  @Nullable
  public PendingIntent getErrorResolutionPendingIntent(Context paramContext, int paramInt1, int paramInt2)
  {
    return zza(paramContext, paramInt1, paramInt2, null);
  }

  public String getErrorString(int paramInt)
  {
    return zze.getErrorString(paramInt);
  }

  @Nullable
  public String getOpenSourceSoftwareLicenseInfo(Context paramContext)
  {
    return zze.getOpenSourceSoftwareLicenseInfo(paramContext);
  }

  public int isGooglePlayServicesAvailable(Context paramContext)
  {
    int j = zze.isGooglePlayServicesAvailable(paramContext);
    int i = j;
    if (zze.zzd(paramContext, j))
      i = 18;
    return i;
  }

  public boolean isUserResolvableError(int paramInt)
  {
    return zze.isUserRecoverableError(paramInt);
  }

  @Nullable
  public PendingIntent zza(Context paramContext, int paramInt1, int paramInt2, @Nullable String paramString)
  {
    paramString = zzb(paramContext, paramInt1, paramString);
    if (paramString == null)
      return null;
    return PendingIntent.getActivity(paramContext, paramInt2, paramString, 268435456);
  }

  @Nullable
  public Intent zzb(Context paramContext, int paramInt, @Nullable String paramString)
  {
    switch (paramInt)
    {
    default:
      return null;
    case 1:
    case 2:
      if ((paramContext != null) && (zzi.zzci(paramContext)))
        return zzn.zzawg();
      return zzn.zzac("com.google.android.gms", zzt(paramContext, paramString));
    case 3:
    }
    return zzn.zzhy("com.google.android.gms");
  }

  public int zzbk(Context paramContext)
  {
    return zze.zzbk(paramContext);
  }

  public void zzbm(Context paramContext)
    throws GooglePlayServicesRepairableException, GooglePlayServicesNotAvailableException
  {
    zze.zzaz(paramContext);
  }

  public void zzbn(Context paramContext)
  {
    zze.zzbn(paramContext);
  }

  public boolean zzd(Context paramContext, int paramInt)
  {
    return zze.zzd(paramContext, paramInt);
  }

  @Deprecated
  @Nullable
  public Intent zzfp(int paramInt)
  {
    return zzb(null, paramInt, null);
  }

  public boolean zzs(Context paramContext, String paramString)
  {
    return zze.zzs(paramContext, paramString);
  }
}

/* Location:           C:\Users\c_jealom1\Documents\Scripts\Android\Fathom_com.brynk.fathom\Fathom_com.brynk.fathom-dex2jar.jar
 * Qualified Name:     com.google.android.gms.common.zzc
 * JD-Core Version:    0.6.0
 */
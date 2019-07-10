package com.google.android.gms.common.internal;

import android.util.Log;

public final class zzo
{
  public static final int EA = 23 - " PII_LOG".length();
  private static final String EB = null;
  private final String EC;
  private final String ED;

  public zzo(String paramString)
  {
    this(paramString, null);
  }

  public zzo(String paramString1, String paramString2)
  {
    zzaa.zzb(paramString1, "log tag cannot be null");
    if (paramString1.length() <= 23);
    for (boolean bool = true; ; bool = false)
    {
      zzaa.zzb(bool, "tag \"%s\" is longer than the %d character maximum", new Object[] { paramString1, Integer.valueOf(23) });
      this.EC = paramString1;
      if ((paramString2 != null) && (paramString2.length() > 0))
        break;
      this.ED = null;
      return;
    }
    this.ED = paramString2;
  }

  private String zzhz(String paramString)
  {
    if (this.ED == null)
      return paramString;
    return this.ED.concat(paramString);
  }

  public void zzad(String paramString1, String paramString2)
  {
    if (zzgo(3))
      Log.d(paramString1, zzhz(paramString2));
  }

  public void zzae(String paramString1, String paramString2)
  {
    if (zzgo(5))
      Log.w(paramString1, zzhz(paramString2));
  }

  public void zzaf(String paramString1, String paramString2)
  {
    if (zzgo(6))
      Log.e(paramString1, zzhz(paramString2));
  }

  public void zzb(String paramString1, String paramString2, Throwable paramThrowable)
  {
    if (zzgo(4))
      Log.i(paramString1, zzhz(paramString2), paramThrowable);
  }

  public void zzc(String paramString1, String paramString2, Throwable paramThrowable)
  {
    if (zzgo(5))
      Log.w(paramString1, zzhz(paramString2), paramThrowable);
  }

  public void zzd(String paramString1, String paramString2, Throwable paramThrowable)
  {
    if (zzgo(6))
      Log.e(paramString1, zzhz(paramString2), paramThrowable);
  }

  public void zze(String paramString1, String paramString2, Throwable paramThrowable)
  {
    if (zzgo(7))
    {
      Log.e(paramString1, zzhz(paramString2), paramThrowable);
      Log.wtf(paramString1, zzhz(paramString2), paramThrowable);
    }
  }

  public boolean zzgo(int paramInt)
  {
    return Log.isLoggable(this.EC, paramInt);
  }
}

/* Location:           C:\Users\c_jealom1\Documents\Scripts\Android\Fathom_com.brynk.fathom\Fathom_com.brynk.fathom-dex2jar.jar
 * Qualified Name:     com.google.android.gms.common.internal.zzo
 * JD-Core Version:    0.6.0
 */
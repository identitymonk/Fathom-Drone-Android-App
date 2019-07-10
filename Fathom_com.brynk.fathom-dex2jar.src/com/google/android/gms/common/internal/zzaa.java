package com.google.android.gms.common.internal;

import android.os.Looper;
import android.text.TextUtils;

public final class zzaa
{
  public static int zza(int paramInt, Object paramObject)
  {
    if (paramInt == 0)
      throw new IllegalArgumentException(String.valueOf(paramObject));
    return paramInt;
  }

  public static long zza(long paramLong, Object paramObject)
  {
    if (paramLong == 0L)
      throw new IllegalArgumentException(String.valueOf(paramObject));
    return paramLong;
  }

  public static void zza(boolean paramBoolean, Object paramObject)
  {
    if (!paramBoolean)
      throw new IllegalStateException(String.valueOf(paramObject));
  }

  public static void zza(boolean paramBoolean, String paramString, Object[] paramArrayOfObject)
  {
    if (!paramBoolean)
      throw new IllegalStateException(String.format(paramString, paramArrayOfObject));
  }

  public static void zzawk()
  {
    zzht("Must not be called on the main application thread");
  }

  public static <T> T zzb(T paramT, Object paramObject)
  {
    if (paramT == null)
      throw new NullPointerException(String.valueOf(paramObject));
    return paramT;
  }

  public static void zzb(boolean paramBoolean, Object paramObject)
  {
    if (!paramBoolean)
      throw new IllegalArgumentException(String.valueOf(paramObject));
  }

  public static void zzb(boolean paramBoolean, String paramString, Object[] paramArrayOfObject)
  {
    if (!paramBoolean)
      throw new IllegalArgumentException(String.format(paramString, paramArrayOfObject));
  }

  public static void zzbs(boolean paramBoolean)
  {
    if (!paramBoolean)
      throw new IllegalStateException();
  }

  public static void zzbt(boolean paramBoolean)
  {
    if (!paramBoolean)
      throw new IllegalArgumentException();
  }

  public static int zzgp(int paramInt)
  {
    if (paramInt == 0)
      throw new IllegalArgumentException("Given Integer is zero");
    return paramInt;
  }

  public static String zzh(String paramString, Object paramObject)
  {
    if (TextUtils.isEmpty(paramString))
      throw new IllegalArgumentException(String.valueOf(paramObject));
    return paramString;
  }

  public static void zzhs(String paramString)
  {
    if (Looper.myLooper() != Looper.getMainLooper())
      throw new IllegalStateException(paramString);
  }

  public static void zzht(String paramString)
  {
    if (Looper.myLooper() == Looper.getMainLooper())
      throw new IllegalStateException(paramString);
  }

  public static String zzib(String paramString)
  {
    if (TextUtils.isEmpty(paramString))
      throw new IllegalArgumentException("Given String is empty or null");
    return paramString;
  }

  public static <T> T zzy(T paramT)
  {
    if (paramT == null)
      throw new NullPointerException("null reference");
    return paramT;
  }
}

/* Location:           C:\Users\c_jealom1\Documents\Scripts\Android\Fathom_com.brynk.fathom\Fathom_com.brynk.fathom-dex2jar.jar
 * Qualified Name:     com.google.android.gms.common.internal.zzaa
 * JD-Core Version:    0.6.0
 */
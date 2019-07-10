package com.google.android.gms.flags.impl;

import android.content.SharedPreferences;
import com.google.android.gms.internal.zzvv;
import java.util.concurrent.Callable;

public abstract class zza<T>
{
  public static class zza extends zza<Boolean>
  {
    public static Boolean zza(SharedPreferences paramSharedPreferences, String paramString, Boolean paramBoolean)
    {
      return (Boolean)zzvv.zzb(new Callable(paramSharedPreferences, paramString, paramBoolean)
      {
        public Boolean zzwa()
        {
          return Boolean.valueOf(zza.zza.this.getBoolean(this.WH, this.WI.booleanValue()));
        }
      });
    }
  }

  public static class zzb extends zza<Integer>
  {
    public static Integer zza(SharedPreferences paramSharedPreferences, String paramString, Integer paramInteger)
    {
      return (Integer)zzvv.zzb(new Callable(paramSharedPreferences, paramString, paramInteger)
      {
        public Integer zzbhg()
        {
          return Integer.valueOf(zza.zzb.this.getInt(this.WH, this.WJ.intValue()));
        }
      });
    }
  }

  public static class zzc extends zza<Long>
  {
    public static Long zza(SharedPreferences paramSharedPreferences, String paramString, Long paramLong)
    {
      return (Long)zzvv.zzb(new Callable(paramSharedPreferences, paramString, paramLong)
      {
        public Long zzbhh()
        {
          return Long.valueOf(zza.zzc.this.getLong(this.WH, this.WK.longValue()));
        }
      });
    }
  }

  public static class zzd extends zza<String>
  {
    public static String zza(SharedPreferences paramSharedPreferences, String paramString1, String paramString2)
    {
      return (String)zzvv.zzb(new Callable(paramSharedPreferences, paramString1, paramString2)
      {
        public String zzaed()
        {
          return zza.zzd.this.getString(this.WH, this.WL);
        }
      });
    }
  }
}

/* Location:           C:\Users\c_jealom1\Documents\Scripts\Android\Fathom_com.brynk.fathom\Fathom_com.brynk.fathom-dex2jar.jar
 * Qualified Name:     com.google.android.gms.flags.impl.zza
 * JD-Core Version:    0.6.0
 */
package com.google.android.gms.internal;

import android.os.Binder;

public abstract class zzsi<T>
{
  private static zza BL;
  private static int BM;
  private static String READ_PERMISSION;
  private static final Object zzaox = new Object();
  private T BN = null;
  protected final String zzbcn;
  protected final T zzbco;

  static
  {
    BL = null;
    BM = 0;
    READ_PERMISSION = "com.google.android.providers.gsf.permission.READ_GSERVICES";
  }

  protected zzsi(String paramString, T paramT)
  {
    this.zzbcn = paramString;
    this.zzbco = paramT;
  }

  public static zzsi<Float> zza(String paramString, Float paramFloat)
  {
    return new zzsi(paramString, paramFloat)
    {
      protected Float zzhm(String paramString)
      {
        return zzsi.zzauh().zzb(this.zzbcn, (Float)this.zzbco);
      }
    };
  }

  public static zzsi<Integer> zza(String paramString, Integer paramInteger)
  {
    return new zzsi(paramString, paramInteger)
    {
      protected Integer zzhl(String paramString)
      {
        return zzsi.zzauh().zzb(this.zzbcn, (Integer)this.zzbco);
      }
    };
  }

  public static zzsi<Long> zza(String paramString, Long paramLong)
  {
    return new zzsi(paramString, paramLong)
    {
      protected Long zzhk(String paramString)
      {
        return zzsi.zzauh().getLong(this.zzbcn, (Long)this.zzbco);
      }
    };
  }

  public static zzsi<String> zzaa(String paramString1, String paramString2)
  {
    return new zzsi(paramString1, paramString2)
    {
      protected String zzhn(String paramString)
      {
        return zzsi.zzauh().getString(this.zzbcn, (String)this.zzbco);
      }
    };
  }

  public static zzsi<Boolean> zzk(String paramString, boolean paramBoolean)
  {
    return new zzsi(paramString, Boolean.valueOf(paramBoolean))
    {
      protected Boolean zzhj(String paramString)
      {
        return zzsi.zzauh().zza(this.zzbcn, (Boolean)this.zzbco);
      }
    };
  }

  public final T get()
  {
    try
    {
      Object localObject1 = zzhi(this.zzbcn);
      return localObject1;
    }
    catch (SecurityException localObject3)
    {
      long l = Binder.clearCallingIdentity();
      try
      {
        Object localObject2 = zzhi(this.zzbcn);
        return localObject2;
      }
      finally
      {
        Binder.restoreCallingIdentity(l);
      }
    }
    throw localObject3;
  }

  protected abstract T zzhi(String paramString);

  private static abstract interface zza
  {
    public abstract Long getLong(String paramString, Long paramLong);

    public abstract String getString(String paramString1, String paramString2);

    public abstract Boolean zza(String paramString, Boolean paramBoolean);

    public abstract Float zzb(String paramString, Float paramFloat);

    public abstract Integer zzb(String paramString, Integer paramInteger);
  }
}

/* Location:           C:\Users\c_jealom1\Documents\Scripts\Android\Fathom_com.brynk.fathom\Fathom_com.brynk.fathom-dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.zzsi
 * JD-Core Version:    0.6.0
 */
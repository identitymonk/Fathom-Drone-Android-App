package com.google.android.gms.internal;

import android.net.Uri;
import android.os.Handler;
import android.os.Looper;
import android.os.SystemClock;
import android.text.TextUtils;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.Collections;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public abstract class zzk<T>
  implements Comparable<zzk<T>>
{
  private final zzs.zza zzac;
  private final int zzad;
  private final String zzae;
  private final int zzaf;
  private final zzm.zza zzag;
  private Integer zzah;
  private zzl zzai;
  private boolean zzaj;
  private boolean zzak;
  private boolean zzal;
  private long zzam;
  private zzo zzan;
  private zzb.zza zzao;

  public zzk(int paramInt, String paramString, zzm.zza paramzza)
  {
    if (zzs.zza.zzbj);
    for (zzs.zza localzza = new zzs.zza(); ; localzza = null)
    {
      this.zzac = localzza;
      this.zzaj = true;
      this.zzak = false;
      this.zzal = false;
      this.zzam = 0L;
      this.zzao = null;
      this.zzad = paramInt;
      this.zzae = paramString;
      this.zzag = paramzza;
      zza(new zzd());
      this.zzaf = zzb(paramString);
      return;
    }
  }

  private byte[] zza(Map<String, String> paramMap, String paramString)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    try
    {
      paramMap = paramMap.entrySet().iterator();
      while (paramMap.hasNext())
      {
        Map.Entry localEntry = (Map.Entry)paramMap.next();
        localStringBuilder.append(URLEncoder.encode((String)localEntry.getKey(), paramString));
        localStringBuilder.append('=');
        localStringBuilder.append(URLEncoder.encode((String)localEntry.getValue(), paramString));
        localStringBuilder.append('&');
      }
    }
    catch (UnsupportedEncodingException localUnsupportedEncodingException)
    {
      paramMap = String.valueOf(paramString);
      if (paramMap.length() == 0);
    }
    for (paramMap = "Encoding not supported: ".concat(paramMap); ; paramMap = new String("Encoding not supported: "))
    {
      throw new RuntimeException(paramMap, localUnsupportedEncodingException);
      paramMap = localUnsupportedEncodingException.toString().getBytes(paramString);
      return paramMap;
    }
  }

  private static int zzb(String paramString)
  {
    if (!TextUtils.isEmpty(paramString))
    {
      paramString = Uri.parse(paramString);
      if (paramString != null)
      {
        paramString = paramString.getHost();
        if (paramString != null)
          return paramString.hashCode();
      }
    }
    return 0;
  }

  public Map<String, String> getHeaders()
    throws zza
  {
    return Collections.emptyMap();
  }

  public int getMethod()
  {
    return this.zzad;
  }

  public String getUrl()
  {
    return this.zzae;
  }

  public boolean isCanceled()
  {
    return false;
  }

  public String toString()
  {
    String str1 = String.valueOf(Integer.toHexString(zzf()));
    if (str1.length() != 0);
    for (str1 = "0x".concat(str1); ; str1 = new String("0x"))
    {
      String str2 = String.valueOf(getUrl());
      String str3 = String.valueOf(zzq());
      String str4 = String.valueOf(this.zzah);
      return String.valueOf("[ ] ").length() + 3 + String.valueOf(str2).length() + String.valueOf(str1).length() + String.valueOf(str3).length() + String.valueOf(str4).length() + "[ ] " + str2 + " " + str1 + " " + str3 + " " + str4;
    }
  }

  public final zzk<?> zza(int paramInt)
  {
    this.zzah = Integer.valueOf(paramInt);
    return this;
  }

  public zzk<?> zza(zzb.zza paramzza)
  {
    this.zzao = paramzza;
    return this;
  }

  public zzk<?> zza(zzl paramzzl)
  {
    this.zzai = paramzzl;
    return this;
  }

  public zzk<?> zza(zzo paramzzo)
  {
    this.zzan = paramzzo;
    return this;
  }

  protected abstract zzm<T> zza(zzi paramzzi);

  protected abstract void zza(T paramT);

  protected zzr zzb(zzr paramzzr)
  {
    return paramzzr;
  }

  public int zzc(zzk<T> paramzzk)
  {
    zza localzza1 = zzq();
    zza localzza2 = paramzzk.zzq();
    if (localzza1 == localzza2)
      return this.zzah.intValue() - paramzzk.zzah.intValue();
    return localzza2.ordinal() - localzza1.ordinal();
  }

  public void zzc(zzr paramzzr)
  {
    if (this.zzag != null)
      this.zzag.zze(paramzzr);
  }

  public void zzc(String paramString)
  {
    if (zzs.zza.zzbj)
      this.zzac.zza(paramString, Thread.currentThread().getId());
    do
      return;
    while (this.zzam != 0L);
    this.zzam = SystemClock.elapsedRealtime();
  }

  void zzd(String paramString)
  {
    if (this.zzai != null)
      this.zzai.zzf(this);
    long l;
    if (zzs.zza.zzbj)
    {
      l = Thread.currentThread().getId();
      if (Looper.myLooper() != Looper.getMainLooper())
        new Handler(Looper.getMainLooper()).post(new Runnable(paramString, l)
        {
          public void run()
          {
            zzk.zzd(zzk.this).zza(this.zzap, this.zzaq);
            zzk.zzd(zzk.this).zzd(toString());
          }
        });
    }
    do
    {
      return;
      this.zzac.zza(paramString, l);
      this.zzac.zzd(toString());
      return;
      l = SystemClock.elapsedRealtime() - this.zzam;
    }
    while (l < 3000L);
    zzs.zzb("%d ms: %s", new Object[] { Long.valueOf(l), toString() });
  }

  public int zzf()
  {
    return this.zzaf;
  }

  public String zzg()
  {
    return getUrl();
  }

  public zzb.zza zzh()
  {
    return this.zzao;
  }

  @Deprecated
  protected Map<String, String> zzi()
    throws zza
  {
    return null;
  }

  @Deprecated
  protected String zzj()
  {
    return zzm();
  }

  @Deprecated
  public String zzk()
  {
    return zzn();
  }

  @Deprecated
  public byte[] zzl()
    throws zza
  {
    Map localMap = zzi();
    if ((localMap != null) && (localMap.size() > 0))
      return zza(localMap, zzj());
    return null;
  }

  protected String zzm()
  {
    return "UTF-8";
  }

  public String zzn()
  {
    String str = String.valueOf(zzm());
    if (str.length() != 0)
      return "application/x-www-form-urlencoded; charset=".concat(str);
    return new String("application/x-www-form-urlencoded; charset=");
  }

  public byte[] zzo()
    throws zza
  {
    return null;
  }

  public final boolean zzp()
  {
    return this.zzaj;
  }

  public zza zzq()
  {
    return zza.zzat;
  }

  public final int zzr()
  {
    return this.zzan.zzc();
  }

  public zzo zzs()
  {
    return this.zzan;
  }

  public void zzt()
  {
    this.zzal = true;
  }

  public boolean zzu()
  {
    return this.zzal;
  }

  public static enum zza
  {
  }
}

/* Location:           C:\Users\c_jealom1\Documents\Scripts\Android\Fathom_com.brynk.fathom\Fathom_com.brynk.fathom-dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.zzk
 * JD-Core Version:    0.6.0
 */
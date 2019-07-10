package com.google.android.gms.internal;

import android.os.SystemClock;
import android.util.Log;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;

public class zzs
{
  public static boolean DEBUG;
  public static String TAG = "Volley";

  static
  {
    DEBUG = Log.isLoggable(TAG, 2);
  }

  public static void zza(String paramString, Object[] paramArrayOfObject)
  {
    if (DEBUG)
      Log.v(TAG, zzd(paramString, paramArrayOfObject));
  }

  public static void zza(Throwable paramThrowable, String paramString, Object[] paramArrayOfObject)
  {
    Log.e(TAG, zzd(paramString, paramArrayOfObject), paramThrowable);
  }

  public static void zzb(String paramString, Object[] paramArrayOfObject)
  {
    Log.d(TAG, zzd(paramString, paramArrayOfObject));
  }

  public static void zzc(String paramString, Object[] paramArrayOfObject)
  {
    Log.e(TAG, zzd(paramString, paramArrayOfObject));
  }

  private static String zzd(String paramString, Object[] paramArrayOfObject)
  {
    int i;
    label20: String str;
    if (paramArrayOfObject == null)
    {
      paramArrayOfObject = new Throwable().fillInStackTrace().getStackTrace();
      i = 2;
      if (i >= paramArrayOfObject.length)
        break label176;
      if (paramArrayOfObject[i].getClass().equals(zzs.class))
        break label169;
      str = paramArrayOfObject[i].getClassName();
      str = str.substring(str.lastIndexOf('.') + 1);
      str = str.substring(str.lastIndexOf('$') + 1);
      paramArrayOfObject = String.valueOf(paramArrayOfObject[i].getMethodName());
    }
    label169: label176: for (paramArrayOfObject = String.valueOf(str).length() + 1 + String.valueOf(paramArrayOfObject).length() + str + "." + paramArrayOfObject; ; paramArrayOfObject = "<unknown>")
    {
      return String.format(Locale.US, "[%d] %s: %s", new Object[] { Long.valueOf(Thread.currentThread().getId()), paramArrayOfObject, paramString });
      paramString = String.format(Locale.US, paramString, paramArrayOfObject);
      break;
      i += 1;
      break label20;
    }
  }

  static class zza
  {
    public static final boolean zzbj = zzs.DEBUG;
    private final List<zza> zzbk = new ArrayList();
    private boolean zzbl = false;

    private long getTotalDuration()
    {
      if (this.zzbk.size() == 0)
        return 0L;
      long l = ((zza)this.zzbk.get(0)).time;
      return ((zza)this.zzbk.get(this.zzbk.size() - 1)).time - l;
    }

    protected void finalize()
      throws Throwable
    {
      if (!this.zzbl)
      {
        zzd("Request on the loose");
        zzs.zzc("Marker log finalized without finish() - uncaught exit point for request", new Object[0]);
      }
    }

    public void zza(String paramString, long paramLong)
    {
      monitorenter;
      try
      {
        if (this.zzbl)
          throw new IllegalStateException("Marker added to finished log");
      }
      finally
      {
        monitorexit;
      }
      this.zzbk.add(new zza(paramString, paramLong, SystemClock.elapsedRealtime()));
      monitorexit;
    }

    public void zzd(String paramString)
    {
      monitorenter;
      try
      {
        this.zzbl = true;
        long l2 = getTotalDuration();
        if (l2 <= 0L);
        while (true)
        {
          return;
          long l1 = ((zza)this.zzbk.get(0)).time;
          zzs.zzb("(%-4d ms) %s", new Object[] { Long.valueOf(l2), paramString });
          paramString = this.zzbk.iterator();
          while (paramString.hasNext())
          {
            zza localzza = (zza)paramString.next();
            l2 = localzza.time;
            zzs.zzb("(+%-4d) [%2d] %s", new Object[] { Long.valueOf(l2 - l1), Long.valueOf(localzza.zzbm), localzza.name });
            l1 = l2;
          }
        }
      }
      finally
      {
        monitorexit;
      }
      throw paramString;
    }

    private static class zza
    {
      public final String name;
      public final long time;
      public final long zzbm;

      public zza(String paramString, long paramLong1, long paramLong2)
      {
        this.name = paramString;
        this.zzbm = paramLong1;
        this.time = paramLong2;
      }
    }
  }
}

/* Location:           C:\Users\c_jealom1\Documents\Scripts\Android\Fathom_com.brynk.fathom\Fathom_com.brynk.fathom-dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.zzs
 * JD-Core Version:    0.6.0
 */
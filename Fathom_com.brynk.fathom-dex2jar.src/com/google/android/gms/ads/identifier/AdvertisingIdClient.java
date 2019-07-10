package com.google.android.gms.ads.identifier;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.net.Uri.Builder;
import android.os.Bundle;
import com.google.android.gms.common.GooglePlayServicesNotAvailableException;
import com.google.android.gms.common.GooglePlayServicesRepairableException;
import com.google.android.gms.common.internal.zzaa;
import com.google.android.gms.common.zzc;
import com.google.android.gms.internal.zzcl;
import com.google.android.gms.internal.zzcl.zza;
import java.io.IOException;
import java.lang.ref.WeakReference;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

public class AdvertisingIdClient
{
  private final Context mContext;
  com.google.android.gms.common.zza zzalf;
  zzcl zzalg;
  boolean zzalh;
  Object zzali = new Object();
  zza zzalj;
  final long zzalk;

  public AdvertisingIdClient(Context paramContext)
  {
    this(paramContext, 30000L, false);
  }

  public AdvertisingIdClient(Context paramContext, long paramLong, boolean paramBoolean)
  {
    zzaa.zzy(paramContext);
    Context localContext;
    if (paramBoolean)
    {
      localContext = paramContext.getApplicationContext();
      if (localContext != null);
    }
    for (this.mContext = paramContext; ; this.mContext = paramContext)
    {
      this.zzalh = false;
      this.zzalk = paramLong;
      return;
      paramContext = localContext;
      break;
    }
  }

  // ERROR //
  public static Info getAdvertisingIdInfo(Context paramContext)
    throws IOException, IllegalStateException, GooglePlayServicesNotAvailableException, GooglePlayServicesRepairableException
  {
    // Byte code:
    //   0: fconst_0
    //   1: fstore_2
    //   2: iconst_0
    //   3: istore 4
    //   5: iconst_0
    //   6: istore 5
    //   8: iload 4
    //   10: istore_3
    //   11: aload_0
    //   12: invokestatic 77	com/google/android/gms/common/zze:getRemoteContext	(Landroid/content/Context;)Landroid/content/Context;
    //   15: astore 6
    //   17: fload_2
    //   18: fstore_1
    //   19: iload 5
    //   21: istore_3
    //   22: aload 6
    //   24: ifnull +48 -> 72
    //   27: iload 4
    //   29: istore_3
    //   30: aload 6
    //   32: ldc 79
    //   34: iconst_1
    //   35: invokevirtual 83	android/content/Context:getSharedPreferences	(Ljava/lang/String;I)Landroid/content/SharedPreferences;
    //   38: astore 6
    //   40: iload 4
    //   42: istore_3
    //   43: aload 6
    //   45: ldc 85
    //   47: iconst_0
    //   48: invokeinterface 91 3 0
    //   53: istore 4
    //   55: iload 4
    //   57: istore_3
    //   58: aload 6
    //   60: ldc 93
    //   62: fconst_0
    //   63: invokeinterface 97 3 0
    //   68: fstore_1
    //   69: iload 4
    //   71: istore_3
    //   72: new 2	com/google/android/gms/ads/identifier/AdvertisingIdClient
    //   75: dup
    //   76: aload_0
    //   77: ldc2_w 98
    //   80: iload_3
    //   81: invokespecial 33	com/google/android/gms/ads/identifier/AdvertisingIdClient:<init>	(Landroid/content/Context;JZ)V
    //   84: astore_0
    //   85: aload_0
    //   86: iconst_0
    //   87: invokevirtual 103	com/google/android/gms/ads/identifier/AdvertisingIdClient:zze	(Z)V
    //   90: aload_0
    //   91: invokevirtual 107	com/google/android/gms/ads/identifier/AdvertisingIdClient:getInfo	()Lcom/google/android/gms/ads/identifier/AdvertisingIdClient$Info;
    //   94: astore 6
    //   96: aload_0
    //   97: aload 6
    //   99: iload_3
    //   100: fload_1
    //   101: aconst_null
    //   102: invokespecial 110	com/google/android/gms/ads/identifier/AdvertisingIdClient:zza	(Lcom/google/android/gms/ads/identifier/AdvertisingIdClient$Info;ZFLjava/lang/Throwable;)V
    //   105: aload_0
    //   106: invokevirtual 113	com/google/android/gms/ads/identifier/AdvertisingIdClient:finish	()V
    //   109: aload 6
    //   111: areturn
    //   112: astore 6
    //   114: ldc 115
    //   116: ldc 117
    //   118: aload 6
    //   120: invokestatic 123	android/util/Log:w	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)I
    //   123: pop
    //   124: fload_2
    //   125: fstore_1
    //   126: goto -54 -> 72
    //   129: astore 6
    //   131: aload_0
    //   132: aconst_null
    //   133: iload_3
    //   134: fload_1
    //   135: aload 6
    //   137: invokespecial 110	com/google/android/gms/ads/identifier/AdvertisingIdClient:zza	(Lcom/google/android/gms/ads/identifier/AdvertisingIdClient$Info;ZFLjava/lang/Throwable;)V
    //   140: aload_0
    //   141: invokevirtual 113	com/google/android/gms/ads/identifier/AdvertisingIdClient:finish	()V
    //   144: aconst_null
    //   145: areturn
    //   146: astore 6
    //   148: aload_0
    //   149: invokevirtual 113	com/google/android/gms/ads/identifier/AdvertisingIdClient:finish	()V
    //   152: aload 6
    //   154: athrow
    //
    // Exception table:
    //   from	to	target	type
    //   11	17	112	java/lang/Exception
    //   30	40	112	java/lang/Exception
    //   43	55	112	java/lang/Exception
    //   58	69	112	java/lang/Exception
    //   85	105	129	java/lang/Throwable
    //   85	105	146	finally
    //   131	140	146	finally
  }

  public static void setShouldSkipGmsCoreVersionCheck(boolean paramBoolean)
  {
  }

  static zzcl zza(Context paramContext, com.google.android.gms.common.zza paramzza)
    throws IOException
  {
    try
    {
      paramContext = zzcl.zza.zzf(paramzza.zza(10000L, TimeUnit.MILLISECONDS));
      return paramContext;
    }
    catch (InterruptedException paramContext)
    {
      throw new IOException("Interrupted exception");
    }
    catch (Throwable paramContext)
    {
    }
    throw new IOException(paramContext);
  }

  private void zza(Info paramInfo, boolean paramBoolean, float paramFloat, Throwable paramThrowable)
  {
    if (Math.random() > paramFloat)
      return;
    new Thread(zza(paramInfo, paramBoolean, paramThrowable).toString())
    {
      public void run()
      {
        new zza().zzv(this.zzall);
      }
    }
    .start();
  }

  private void zzea()
  {
    synchronized (this.zzali)
    {
      if (this.zzalj != null)
        this.zzalj.cancel();
    }
    try
    {
      this.zzalj.join();
      label28: if (this.zzalk > 0L)
        this.zzalj = new zza(this, this.zzalk);
      monitorexit;
      return;
      localObject2 = finally;
      monitorexit;
      throw localObject2;
    }
    catch (InterruptedException localInterruptedException)
    {
      break label28;
    }
  }

  static com.google.android.gms.common.zza zzf(Context paramContext)
    throws IOException, GooglePlayServicesNotAvailableException, GooglePlayServicesRepairableException
  {
    try
    {
      paramContext.getPackageManager().getPackageInfo("com.android.vending", 0);
      switch (zzc.zzaql().isGooglePlayServicesAvailable(paramContext))
      {
      case 1:
      default:
        throw new IOException("Google Play services not available");
      case 0:
      case 2:
      }
    }
    catch (android.content.pm.PackageManager.NameNotFoundException paramContext)
    {
      throw new GooglePlayServicesNotAvailableException(9);
    }
    com.google.android.gms.common.zza localzza = new com.google.android.gms.common.zza();
    Intent localIntent = new Intent("com.google.android.gms.ads.identifier.service.START");
    localIntent.setPackage("com.google.android.gms");
    try
    {
      boolean bool = com.google.android.gms.common.stats.zza.zzaxr().zza(paramContext, localIntent, localzza, 1);
      if (bool)
        return localzza;
    }
    catch (Throwable paramContext)
    {
      throw new IOException(paramContext);
    }
    throw new IOException("Connection failure");
  }

  protected void finalize()
    throws Throwable
  {
    finish();
    super.finalize();
  }

  // ERROR //
  public void finish()
  {
    // Byte code:
    //   0: ldc 248
    //   2: invokestatic 251	com/google/android/gms/common/internal/zzaa:zzht	(Ljava/lang/String;)V
    //   5: aload_0
    //   6: monitorenter
    //   7: aload_0
    //   8: getfield 53	com/google/android/gms/ads/identifier/AdvertisingIdClient:mContext	Landroid/content/Context;
    //   11: ifnull +10 -> 21
    //   14: aload_0
    //   15: getfield 253	com/google/android/gms/ads/identifier/AdvertisingIdClient:zzalf	Lcom/google/android/gms/common/zza;
    //   18: ifnonnull +6 -> 24
    //   21: aload_0
    //   22: monitorexit
    //   23: return
    //   24: aload_0
    //   25: getfield 55	com/google/android/gms/ads/identifier/AdvertisingIdClient:zzalh	Z
    //   28: ifeq +17 -> 45
    //   31: invokestatic 236	com/google/android/gms/common/stats/zza:zzaxr	()Lcom/google/android/gms/common/stats/zza;
    //   34: aload_0
    //   35: getfield 53	com/google/android/gms/ads/identifier/AdvertisingIdClient:mContext	Landroid/content/Context;
    //   38: aload_0
    //   39: getfield 253	com/google/android/gms/ads/identifier/AdvertisingIdClient:zzalf	Lcom/google/android/gms/common/zza;
    //   42: invokevirtual 256	com/google/android/gms/common/stats/zza:zza	(Landroid/content/Context;Landroid/content/ServiceConnection;)V
    //   45: aload_0
    //   46: iconst_0
    //   47: putfield 55	com/google/android/gms/ads/identifier/AdvertisingIdClient:zzalh	Z
    //   50: aload_0
    //   51: aconst_null
    //   52: putfield 258	com/google/android/gms/ads/identifier/AdvertisingIdClient:zzalg	Lcom/google/android/gms/internal/zzcl;
    //   55: aload_0
    //   56: aconst_null
    //   57: putfield 253	com/google/android/gms/ads/identifier/AdvertisingIdClient:zzalf	Lcom/google/android/gms/common/zza;
    //   60: aload_0
    //   61: monitorexit
    //   62: return
    //   63: astore_1
    //   64: aload_0
    //   65: monitorexit
    //   66: aload_1
    //   67: athrow
    //   68: astore_1
    //   69: ldc 115
    //   71: ldc_w 260
    //   74: aload_1
    //   75: invokestatic 263	android/util/Log:i	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)I
    //   78: pop
    //   79: goto -34 -> 45
    //   82: astore_1
    //   83: ldc 115
    //   85: ldc_w 260
    //   88: aload_1
    //   89: invokestatic 263	android/util/Log:i	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)I
    //   92: pop
    //   93: goto -48 -> 45
    //
    // Exception table:
    //   from	to	target	type
    //   7	21	63	finally
    //   21	23	63	finally
    //   24	45	63	finally
    //   45	62	63	finally
    //   64	66	63	finally
    //   69	79	63	finally
    //   83	93	63	finally
    //   24	45	68	java/lang/IllegalArgumentException
    //   24	45	82	java/lang/Throwable
  }

  // ERROR //
  public Info getInfo()
    throws IOException
  {
    // Byte code:
    //   0: ldc 248
    //   2: invokestatic 251	com/google/android/gms/common/internal/zzaa:zzht	(Ljava/lang/String;)V
    //   5: aload_0
    //   6: monitorenter
    //   7: aload_0
    //   8: getfield 55	com/google/android/gms/ads/identifier/AdvertisingIdClient:zzalh	Z
    //   11: ifne +86 -> 97
    //   14: aload_0
    //   15: getfield 39	com/google/android/gms/ads/identifier/AdvertisingIdClient:zzali	Ljava/lang/Object;
    //   18: astore_1
    //   19: aload_1
    //   20: monitorenter
    //   21: aload_0
    //   22: getfield 179	com/google/android/gms/ads/identifier/AdvertisingIdClient:zzalj	Lcom/google/android/gms/ads/identifier/AdvertisingIdClient$zza;
    //   25: ifnull +13 -> 38
    //   28: aload_0
    //   29: getfield 179	com/google/android/gms/ads/identifier/AdvertisingIdClient:zzalj	Lcom/google/android/gms/ads/identifier/AdvertisingIdClient$zza;
    //   32: invokevirtual 269	com/google/android/gms/ads/identifier/AdvertisingIdClient$zza:zzeb	()Z
    //   35: ifne +24 -> 59
    //   38: new 61	java/io/IOException
    //   41: dup
    //   42: ldc_w 271
    //   45: invokespecial 152	java/io/IOException:<init>	(Ljava/lang/String;)V
    //   48: athrow
    //   49: astore_2
    //   50: aload_1
    //   51: monitorexit
    //   52: aload_2
    //   53: athrow
    //   54: astore_1
    //   55: aload_0
    //   56: monitorexit
    //   57: aload_1
    //   58: athrow
    //   59: aload_1
    //   60: monitorexit
    //   61: aload_0
    //   62: iconst_0
    //   63: invokevirtual 103	com/google/android/gms/ads/identifier/AdvertisingIdClient:zze	(Z)V
    //   66: aload_0
    //   67: getfield 55	com/google/android/gms/ads/identifier/AdvertisingIdClient:zzalh	Z
    //   70: ifne +27 -> 97
    //   73: new 61	java/io/IOException
    //   76: dup
    //   77: ldc_w 273
    //   80: invokespecial 152	java/io/IOException:<init>	(Ljava/lang/String;)V
    //   83: athrow
    //   84: astore_1
    //   85: new 61	java/io/IOException
    //   88: dup
    //   89: ldc_w 273
    //   92: aload_1
    //   93: invokespecial 276	java/io/IOException:<init>	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   96: athrow
    //   97: aload_0
    //   98: getfield 253	com/google/android/gms/ads/identifier/AdvertisingIdClient:zzalf	Lcom/google/android/gms/common/zza;
    //   101: invokestatic 45	com/google/android/gms/common/internal/zzaa:zzy	(Ljava/lang/Object;)Ljava/lang/Object;
    //   104: pop
    //   105: aload_0
    //   106: getfield 258	com/google/android/gms/ads/identifier/AdvertisingIdClient:zzalg	Lcom/google/android/gms/internal/zzcl;
    //   109: invokestatic 45	com/google/android/gms/common/internal/zzaa:zzy	(Ljava/lang/Object;)Ljava/lang/Object;
    //   112: pop
    //   113: new 8	com/google/android/gms/ads/identifier/AdvertisingIdClient$Info
    //   116: dup
    //   117: aload_0
    //   118: getfield 258	com/google/android/gms/ads/identifier/AdvertisingIdClient:zzalg	Lcom/google/android/gms/internal/zzcl;
    //   121: invokeinterface 281 1 0
    //   126: aload_0
    //   127: getfield 258	com/google/android/gms/ads/identifier/AdvertisingIdClient:zzalg	Lcom/google/android/gms/internal/zzcl;
    //   130: iconst_1
    //   131: invokeinterface 284 2 0
    //   136: invokespecial 287	com/google/android/gms/ads/identifier/AdvertisingIdClient$Info:<init>	(Ljava/lang/String;Z)V
    //   139: astore_1
    //   140: aload_0
    //   141: monitorexit
    //   142: aload_0
    //   143: invokespecial 289	com/google/android/gms/ads/identifier/AdvertisingIdClient:zzea	()V
    //   146: aload_1
    //   147: areturn
    //   148: astore_1
    //   149: ldc 115
    //   151: ldc_w 291
    //   154: aload_1
    //   155: invokestatic 263	android/util/Log:i	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)I
    //   158: pop
    //   159: new 61	java/io/IOException
    //   162: dup
    //   163: ldc_w 293
    //   166: invokespecial 152	java/io/IOException:<init>	(Ljava/lang/String;)V
    //   169: athrow
    //
    // Exception table:
    //   from	to	target	type
    //   21	38	49	finally
    //   38	49	49	finally
    //   50	52	49	finally
    //   59	61	49	finally
    //   7	21	54	finally
    //   52	54	54	finally
    //   55	57	54	finally
    //   61	66	54	finally
    //   66	84	54	finally
    //   85	97	54	finally
    //   97	113	54	finally
    //   113	140	54	finally
    //   140	142	54	finally
    //   149	170	54	finally
    //   61	66	84	java/lang/Exception
    //   113	140	148	android/os/RemoteException
  }

  public void start()
    throws IOException, IllegalStateException, GooglePlayServicesNotAvailableException, GooglePlayServicesRepairableException
  {
    zze(true);
  }

  Uri zza(Info paramInfo, boolean paramBoolean, Throwable paramThrowable)
  {
    Bundle localBundle = new Bundle();
    if (paramBoolean)
    {
      str = "1";
      localBundle.putString("app_context", str);
      if (paramInfo != null)
        if (!paramInfo.isLimitAdTrackingEnabled())
          break label168;
    }
    label168: for (String str = "1"; ; str = "0")
    {
      localBundle.putString("limit_ad_tracking", str);
      if ((paramInfo != null) && (paramInfo.getId() != null))
        localBundle.putString("ad_id_size", Integer.toString(paramInfo.getId().length()));
      if (paramThrowable != null)
        localBundle.putString("error", paramThrowable.getClass().getName());
      paramInfo = Uri.parse("https://pagead2.googlesyndication.com/pagead/gen_204?id=gmob-apps").buildUpon();
      paramThrowable = localBundle.keySet().iterator();
      while (paramThrowable.hasNext())
      {
        str = (String)paramThrowable.next();
        paramInfo.appendQueryParameter(str, localBundle.getString(str));
      }
      str = "0";
      break;
    }
    return paramInfo.build();
  }

  protected void zze(boolean paramBoolean)
    throws IOException, IllegalStateException, GooglePlayServicesNotAvailableException, GooglePlayServicesRepairableException
  {
    zzaa.zzht("Calling this from your main thread can lead to deadlock");
    monitorenter;
    try
    {
      if (this.zzalh)
        finish();
      this.zzalf = zzf(this.mContext);
      this.zzalg = zza(this.mContext, this.zzalf);
      this.zzalh = true;
      if (paramBoolean)
        zzea();
      return;
    }
    finally
    {
      monitorexit;
    }
    throw localObject;
  }

  public static final class Info
  {
    private final String zzalr;
    private final boolean zzals;

    public Info(String paramString, boolean paramBoolean)
    {
      this.zzalr = paramString;
      this.zzals = paramBoolean;
    }

    public String getId()
    {
      return this.zzalr;
    }

    public boolean isLimitAdTrackingEnabled()
    {
      return this.zzals;
    }

    public String toString()
    {
      String str = this.zzalr;
      boolean bool = this.zzals;
      return String.valueOf(str).length() + 7 + "{" + str + "}" + bool;
    }
  }

  static class zza extends Thread
  {
    private WeakReference<AdvertisingIdClient> zzaln;
    private long zzalo;
    CountDownLatch zzalp;
    boolean zzalq;

    public zza(AdvertisingIdClient paramAdvertisingIdClient, long paramLong)
    {
      this.zzaln = new WeakReference(paramAdvertisingIdClient);
      this.zzalo = paramLong;
      this.zzalp = new CountDownLatch(1);
      this.zzalq = false;
      start();
    }

    private void disconnect()
    {
      AdvertisingIdClient localAdvertisingIdClient = (AdvertisingIdClient)this.zzaln.get();
      if (localAdvertisingIdClient != null)
      {
        localAdvertisingIdClient.finish();
        this.zzalq = true;
      }
    }

    public void cancel()
    {
      this.zzalp.countDown();
    }

    public void run()
    {
      try
      {
        if (!this.zzalp.await(this.zzalo, TimeUnit.MILLISECONDS))
          disconnect();
        return;
      }
      catch (InterruptedException localInterruptedException)
      {
        disconnect();
      }
    }

    public boolean zzeb()
    {
      return this.zzalq;
    }
  }
}

/* Location:           C:\Users\c_jealom1\Documents\Scripts\Android\Fathom_com.brynk.fathom\Fathom_com.brynk.fathom-dex2jar.jar
 * Qualified Name:     com.google.android.gms.ads.identifier.AdvertisingIdClient
 * JD-Core Version:    0.6.0
 */
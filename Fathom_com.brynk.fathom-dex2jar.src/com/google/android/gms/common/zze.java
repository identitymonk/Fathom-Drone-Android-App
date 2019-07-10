package com.google.android.gms.common;

import android.annotation.TargetApi;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageInstaller;
import android.content.pm.PackageInstaller.SessionInfo;
import android.content.pm.PackageManager;
import android.content.res.Resources;
import android.os.Bundle;
import android.os.UserManager;
import android.util.Log;
import com.google.android.gms.common.internal.zzy;
import com.google.android.gms.common.util.zzd;
import com.google.android.gms.common.util.zzi;
import com.google.android.gms.common.util.zzs;
import com.google.android.gms.common.util.zzx;
import com.google.android.gms.internal.zzsy;
import com.google.android.gms.internal.zzsz;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;

public class zze
{

  @Deprecated
  public static final String GOOGLE_PLAY_SERVICES_PACKAGE = "com.google.android.gms";

  @Deprecated
  public static final int GOOGLE_PLAY_SERVICES_VERSION_CODE = zzaqq();
  public static final String GOOGLE_PLAY_STORE_PACKAGE = "com.android.vending";
  public static boolean xb = false;
  public static boolean xc = false;
  static boolean xd = false;
  private static boolean xe = false;
  static final AtomicBoolean xf = new AtomicBoolean();
  private static final AtomicBoolean xg = new AtomicBoolean();

  @Deprecated
  public static PendingIntent getErrorPendingIntent(int paramInt1, Context paramContext, int paramInt2)
  {
    return zzc.zzaql().getErrorResolutionPendingIntent(paramContext, paramInt1, paramInt2);
  }

  @Deprecated
  public static String getErrorString(int paramInt)
  {
    return ConnectionResult.getStatusString(paramInt);
  }

  // ERROR //
  @Deprecated
  public static String getOpenSourceSoftwareLicenseInfo(Context paramContext)
  {
    // Byte code:
    //   0: new 77	android/net/Uri$Builder
    //   3: dup
    //   4: invokespecial 78	android/net/Uri$Builder:<init>	()V
    //   7: ldc 80
    //   9: invokevirtual 84	android/net/Uri$Builder:scheme	(Ljava/lang/String;)Landroid/net/Uri$Builder;
    //   12: ldc 8
    //   14: invokevirtual 87	android/net/Uri$Builder:authority	(Ljava/lang/String;)Landroid/net/Uri$Builder;
    //   17: ldc 89
    //   19: invokevirtual 92	android/net/Uri$Builder:appendPath	(Ljava/lang/String;)Landroid/net/Uri$Builder;
    //   22: ldc 94
    //   24: invokevirtual 92	android/net/Uri$Builder:appendPath	(Ljava/lang/String;)Landroid/net/Uri$Builder;
    //   27: invokevirtual 98	android/net/Uri$Builder:build	()Landroid/net/Uri;
    //   30: astore_1
    //   31: aload_0
    //   32: invokevirtual 104	android/content/Context:getContentResolver	()Landroid/content/ContentResolver;
    //   35: aload_1
    //   36: invokevirtual 110	android/content/ContentResolver:openInputStream	(Landroid/net/Uri;)Ljava/io/InputStream;
    //   39: astore_2
    //   40: new 112	java/util/Scanner
    //   43: dup
    //   44: aload_2
    //   45: invokespecial 115	java/util/Scanner:<init>	(Ljava/io/InputStream;)V
    //   48: ldc 117
    //   50: invokevirtual 121	java/util/Scanner:useDelimiter	(Ljava/lang/String;)Ljava/util/Scanner;
    //   53: invokevirtual 125	java/util/Scanner:next	()Ljava/lang/String;
    //   56: astore_0
    //   57: aload_0
    //   58: astore_1
    //   59: aload_2
    //   60: ifnull +35 -> 95
    //   63: aload_2
    //   64: invokevirtual 130	java/io/InputStream:close	()V
    //   67: aload_0
    //   68: areturn
    //   69: astore_0
    //   70: aload_2
    //   71: ifnull +26 -> 97
    //   74: aload_2
    //   75: invokevirtual 130	java/io/InputStream:close	()V
    //   78: goto +19 -> 97
    //   81: astore_0
    //   82: aload_2
    //   83: ifnull +7 -> 90
    //   86: aload_2
    //   87: invokevirtual 130	java/io/InputStream:close	()V
    //   90: aload_0
    //   91: athrow
    //   92: astore_0
    //   93: aconst_null
    //   94: astore_1
    //   95: aload_1
    //   96: areturn
    //   97: aconst_null
    //   98: areturn
    //
    // Exception table:
    //   from	to	target	type
    //   40	57	69	java/util/NoSuchElementException
    //   40	57	81	finally
    //   31	40	92	java/lang/Exception
    //   63	67	92	java/lang/Exception
    //   74	78	92	java/lang/Exception
    //   86	90	92	java/lang/Exception
    //   90	92	92	java/lang/Exception
  }

  public static Context getRemoteContext(Context paramContext)
  {
    try
    {
      paramContext = paramContext.createPackageContext("com.google.android.gms", 3);
      return paramContext;
    }
    catch (android.content.pm.PackageManager.NameNotFoundException paramContext)
    {
    }
    return null;
  }

  public static Resources getRemoteResource(Context paramContext)
  {
    try
    {
      paramContext = paramContext.getPackageManager().getResourcesForApplication("com.google.android.gms");
      return paramContext;
    }
    catch (android.content.pm.PackageManager.NameNotFoundException paramContext)
    {
    }
    return null;
  }

  // ERROR //
  @Deprecated
  public static int isGooglePlayServicesAvailable(Context paramContext)
  {
    // Byte code:
    //   0: aload_0
    //   1: invokevirtual 144	android/content/Context:getPackageManager	()Landroid/content/pm/PackageManager;
    //   4: astore 4
    //   6: aload_0
    //   7: invokevirtual 158	android/content/Context:getResources	()Landroid/content/res/Resources;
    //   10: getstatic 163	com/google/android/gms/R$string:common_google_play_services_unknown_issue	I
    //   13: invokevirtual 168	android/content/res/Resources:getString	(I)Ljava/lang/String;
    //   16: pop
    //   17: ldc 8
    //   19: aload_0
    //   20: invokevirtual 171	android/content/Context:getPackageName	()Ljava/lang/String;
    //   23: invokevirtual 177	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   26: ifne +7 -> 33
    //   29: aload_0
    //   30: invokestatic 181	com/google/android/gms/common/zze:zzbp	(Landroid/content/Context;)V
    //   33: aload_0
    //   34: invokestatic 187	com/google/android/gms/common/util/zzi:zzci	(Landroid/content/Context;)Z
    //   37: ifne +78 -> 115
    //   40: iconst_1
    //   41: istore_1
    //   42: aconst_null
    //   43: astore_3
    //   44: iload_1
    //   45: ifeq +14 -> 59
    //   48: aload 4
    //   50: ldc 14
    //   52: sipush 8256
    //   55: invokevirtual 191	android/content/pm/PackageManager:getPackageInfo	(Ljava/lang/String;I)Landroid/content/pm/PackageInfo;
    //   58: astore_3
    //   59: aload 4
    //   61: ldc 8
    //   63: bipush 64
    //   65: invokevirtual 191	android/content/pm/PackageManager:getPackageInfo	(Ljava/lang/String;I)Landroid/content/pm/PackageInfo;
    //   68: astore 5
    //   70: aload_0
    //   71: invokestatic 197	com/google/android/gms/common/zzf:zzbv	(Landroid/content/Context;)Lcom/google/android/gms/common/zzf;
    //   74: astore_0
    //   75: iload_1
    //   76: ifeq +95 -> 171
    //   79: aload_0
    //   80: aload_3
    //   81: getstatic 203	com/google/android/gms/common/zzd$zzd:xa	[Lcom/google/android/gms/common/zzd$zza;
    //   84: invokevirtual 207	com/google/android/gms/common/zzf:zza	(Landroid/content/pm/PackageInfo;[Lcom/google/android/gms/common/zzd$zza;)Lcom/google/android/gms/common/zzd$zza;
    //   87: astore_3
    //   88: aload_3
    //   89: ifnonnull +54 -> 143
    //   92: ldc 209
    //   94: ldc 211
    //   96: invokestatic 217	android/util/Log:w	(Ljava/lang/String;Ljava/lang/String;)I
    //   99: pop
    //   100: bipush 9
    //   102: ireturn
    //   103: astore_3
    //   104: ldc 209
    //   106: ldc 219
    //   108: invokestatic 222	android/util/Log:e	(Ljava/lang/String;Ljava/lang/String;)I
    //   111: pop
    //   112: goto -95 -> 17
    //   115: iconst_0
    //   116: istore_1
    //   117: goto -75 -> 42
    //   120: astore_0
    //   121: ldc 209
    //   123: ldc 224
    //   125: invokestatic 217	android/util/Log:w	(Ljava/lang/String;Ljava/lang/String;)I
    //   128: pop
    //   129: bipush 9
    //   131: ireturn
    //   132: astore_0
    //   133: ldc 209
    //   135: ldc 226
    //   137: invokestatic 217	android/util/Log:w	(Ljava/lang/String;Ljava/lang/String;)I
    //   140: pop
    //   141: iconst_1
    //   142: ireturn
    //   143: aload_0
    //   144: aload 5
    //   146: iconst_1
    //   147: anewarray 228	com/google/android/gms/common/zzd$zza
    //   150: dup
    //   151: iconst_0
    //   152: aload_3
    //   153: aastore
    //   154: invokevirtual 207	com/google/android/gms/common/zzf:zza	(Landroid/content/pm/PackageInfo;[Lcom/google/android/gms/common/zzd$zza;)Lcom/google/android/gms/common/zzd$zza;
    //   157: ifnonnull +37 -> 194
    //   160: ldc 209
    //   162: ldc 230
    //   164: invokestatic 217	android/util/Log:w	(Ljava/lang/String;Ljava/lang/String;)I
    //   167: pop
    //   168: bipush 9
    //   170: ireturn
    //   171: aload_0
    //   172: aload 5
    //   174: getstatic 203	com/google/android/gms/common/zzd$zzd:xa	[Lcom/google/android/gms/common/zzd$zza;
    //   177: invokevirtual 207	com/google/android/gms/common/zzf:zza	(Landroid/content/pm/PackageInfo;[Lcom/google/android/gms/common/zzd$zza;)Lcom/google/android/gms/common/zzd$zza;
    //   180: ifnonnull +14 -> 194
    //   183: ldc 209
    //   185: ldc 230
    //   187: invokestatic 217	android/util/Log:w	(Ljava/lang/String;Ljava/lang/String;)I
    //   190: pop
    //   191: bipush 9
    //   193: ireturn
    //   194: getstatic 30	com/google/android/gms/common/zze:GOOGLE_PLAY_SERVICES_VERSION_CODE	I
    //   197: invokestatic 236	com/google/android/gms/common/util/zzl:zzhh	(I)I
    //   200: istore_1
    //   201: aload 5
    //   203: getfield 241	android/content/pm/PackageInfo:versionCode	I
    //   206: invokestatic 236	com/google/android/gms/common/util/zzl:zzhh	(I)I
    //   209: iload_1
    //   210: if_icmpge +52 -> 262
    //   213: getstatic 30	com/google/android/gms/common/zze:GOOGLE_PLAY_SERVICES_VERSION_CODE	I
    //   216: istore_1
    //   217: aload 5
    //   219: getfield 241	android/content/pm/PackageInfo:versionCode	I
    //   222: istore_2
    //   223: ldc 209
    //   225: new 243	java/lang/StringBuilder
    //   228: dup
    //   229: bipush 77
    //   231: invokespecial 246	java/lang/StringBuilder:<init>	(I)V
    //   234: ldc 248
    //   236: invokevirtual 252	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   239: iload_1
    //   240: invokevirtual 255	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   243: ldc_w 257
    //   246: invokevirtual 252	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   249: iload_2
    //   250: invokevirtual 255	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   253: invokevirtual 260	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   256: invokestatic 217	android/util/Log:w	(Ljava/lang/String;Ljava/lang/String;)I
    //   259: pop
    //   260: iconst_2
    //   261: ireturn
    //   262: aload 5
    //   264: getfield 264	android/content/pm/PackageInfo:applicationInfo	Landroid/content/pm/ApplicationInfo;
    //   267: astore_3
    //   268: aload_3
    //   269: astore_0
    //   270: aload_3
    //   271: ifnonnull +12 -> 283
    //   274: aload 4
    //   276: ldc 8
    //   278: iconst_0
    //   279: invokevirtual 268	android/content/pm/PackageManager:getApplicationInfo	(Ljava/lang/String;I)Landroid/content/pm/ApplicationInfo;
    //   282: astore_0
    //   283: aload_0
    //   284: getfield 273	android/content/pm/ApplicationInfo:enabled	Z
    //   287: ifne +18 -> 305
    //   290: iconst_3
    //   291: ireturn
    //   292: astore_0
    //   293: ldc 209
    //   295: ldc_w 275
    //   298: aload_0
    //   299: invokestatic 279	android/util/Log:wtf	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)I
    //   302: pop
    //   303: iconst_1
    //   304: ireturn
    //   305: iconst_0
    //   306: ireturn
    //
    // Exception table:
    //   from	to	target	type
    //   6	17	103	java/lang/Throwable
    //   48	59	120	android/content/pm/PackageManager$NameNotFoundException
    //   59	70	132	android/content/pm/PackageManager$NameNotFoundException
    //   274	283	292	android/content/pm/PackageManager$NameNotFoundException
  }

  @Deprecated
  public static boolean isUserRecoverableError(int paramInt)
  {
    switch (paramInt)
    {
    case 4:
    case 5:
    case 6:
    case 7:
    case 8:
    default:
      return false;
    case 1:
    case 2:
    case 3:
    case 9:
    }
    return true;
  }

  private static int zzaqq()
  {
    return 9877000;
  }

  @Deprecated
  public static boolean zzaqr()
  {
    return zzi.zzaym();
  }

  @Deprecated
  public static void zzaz(Context paramContext)
    throws GooglePlayServicesRepairableException, GooglePlayServicesNotAvailableException
  {
    int i = zzc.zzaql().isGooglePlayServicesAvailable(paramContext);
    if (i != 0)
    {
      paramContext = zzc.zzaql().zzb(paramContext, i, "e");
      Log.e("GooglePlayServicesUtil", 57 + "GooglePlayServices not available due to error " + i);
      if (paramContext == null)
        throw new GooglePlayServicesNotAvailableException(i);
      throw new GooglePlayServicesRepairableException(i, "Google Play Services not available", paramContext);
    }
  }

  @Deprecated
  public static int zzbk(Context paramContext)
  {
    try
    {
      paramContext = paramContext.getPackageManager().getPackageInfo("com.google.android.gms", 0);
      return paramContext.versionCode;
    }
    catch (android.content.pm.PackageManager.NameNotFoundException paramContext)
    {
      Log.w("GooglePlayServicesUtil", "Google Play services is missing.");
    }
    return 0;
  }

  @Deprecated
  public static void zzbn(Context paramContext)
  {
    if (xf.getAndSet(true));
    while (true)
    {
      return;
      try
      {
        paramContext = (NotificationManager)paramContext.getSystemService("notification");
        if (paramContext == null)
          continue;
        paramContext.cancel(10436);
        return;
      }
      catch (java.lang.SecurityException paramContext)
      {
      }
    }
  }

  private static void zzbp(Context paramContext)
  {
    if (xg.get());
    int i;
    do
    {
      return;
      i = zzy.zzce(paramContext);
      if (i != 0)
        continue;
      throw new IllegalStateException("A required meta-data tag in your app's AndroidManifest.xml does not exist.  You must have the following declaration within the <application> element:     <meta-data android:name=\"com.google.android.gms.version\" android:value=\"@integer/google_play_services_version\" />");
    }
    while (i == GOOGLE_PLAY_SERVICES_VERSION_CODE);
    int j = GOOGLE_PLAY_SERVICES_VERSION_CODE;
    paramContext = String.valueOf("com.google.android.gms.version");
    throw new IllegalStateException(String.valueOf(paramContext).length() + 290 + "The meta-data tag in your app's AndroidManifest.xml does not have the right value.  Expected " + j + " but found " + i + ".  You must have the following declaration within the <application> element:     <meta-data android:name=\"" + paramContext + "\" android:value=\"@integer/google_play_services_version\" />");
  }

  public static boolean zzbq(Context paramContext)
  {
    zzbt(paramContext);
    return xd;
  }

  public static boolean zzbr(Context paramContext)
  {
    return (zzbq(paramContext)) || (!zzaqr());
  }

  @TargetApi(18)
  public static boolean zzbs(Context paramContext)
  {
    if (zzs.zzayt())
    {
      paramContext = ((UserManager)paramContext.getSystemService("user")).getApplicationRestrictions(paramContext.getPackageName());
      if ((paramContext != null) && ("true".equals(paramContext.getString("restricted_profile"))))
        return true;
    }
    return false;
  }

  private static void zzbt(Context paramContext)
  {
    if (!xe)
      zzbu(paramContext);
  }

  private static void zzbu(Context paramContext)
  {
    try
    {
      PackageInfo localPackageInfo = zzsz.zzco(paramContext).getPackageInfo("com.google.android.gms", 64);
      if (localPackageInfo != null)
        if (zzf.zzbv(paramContext).zza(localPackageInfo, new zzd.zza[] { zzd.zzd.xa[1] }) != null)
          xd = true;
      while (true)
      {
        return;
        xd = false;
      }
    }
    catch (android.content.pm.PackageManager.NameNotFoundException paramContext)
    {
      Log.w("GooglePlayServicesUtil", "Cannot find Google Play services package name.", paramContext);
      return;
    }
    finally
    {
      xe = true;
    }
    throw paramContext;
  }

  @Deprecated
  @TargetApi(19)
  public static boolean zzc(Context paramContext, int paramInt, String paramString)
  {
    return zzx.zzc(paramContext, paramInt, paramString);
  }

  @Deprecated
  public static boolean zzd(Context paramContext, int paramInt)
  {
    if (paramInt == 18)
      return true;
    if (paramInt == 1)
      return zzs(paramContext, "com.google.android.gms");
    return false;
  }

  @Deprecated
  public static boolean zze(Context paramContext, int paramInt)
  {
    if (paramInt == 9)
      return zzs(paramContext, "com.android.vending");
    return false;
  }

  @Deprecated
  public static boolean zzf(Context paramContext, int paramInt)
  {
    return zzx.zzf(paramContext, paramInt);
  }

  @TargetApi(21)
  static boolean zzs(Context paramContext, String paramString)
  {
    boolean bool = paramString.equals("com.google.android.gms");
    if ((bool) && (zzd.zzayi()))
      return false;
    if (zzs.zzayx())
    {
      localObject = paramContext.getPackageManager().getPackageInstaller().getAllSessions().iterator();
      while (((Iterator)localObject).hasNext())
        if (paramString.equals(((PackageInstaller.SessionInfo)((Iterator)localObject).next()).getAppPackageName()))
          return true;
    }
    Object localObject = paramContext.getPackageManager();
    try
    {
      paramString = ((PackageManager)localObject).getApplicationInfo(paramString, 8192);
      if (bool)
        return paramString.enabled;
      if (paramString.enabled)
      {
        bool = zzbs(paramContext);
        if (bool);
      }
      for (bool = true; ; bool = false)
        return bool;
    }
    catch (android.content.pm.PackageManager.NameNotFoundException paramContext)
    {
    }
    return false;
  }
}

/* Location:           C:\Users\c_jealom1\Documents\Scripts\Android\Fathom_com.brynk.fathom\Fathom_com.brynk.fathom-dex2jar.jar
 * Qualified Name:     com.google.android.gms.common.zze
 * JD-Core Version:    0.6.0
 */
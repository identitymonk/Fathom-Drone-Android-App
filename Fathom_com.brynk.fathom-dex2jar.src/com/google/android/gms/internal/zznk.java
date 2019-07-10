package com.google.android.gms.internal;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.net.Uri.Builder;
import android.os.RemoteException;
import android.util.Log;
import com.google.android.gms.appdatasearch.UsageInfo;
import com.google.android.gms.appdatasearch.UsageInfo.zza;
import com.google.android.gms.appdatasearch.zza;
import com.google.android.gms.appdatasearch.zzk;
import com.google.android.gms.appindexing.Action;
import com.google.android.gms.appindexing.AppIndexApi;
import com.google.android.gms.appindexing.AppIndexApi.ActionResult;
import com.google.android.gms.appindexing.AppIndexApi.AppIndexingLink;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.PendingResult<Lcom.google.android.gms.common.api.Status;>;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import java.util.Iterator;
import java.util.List;

public final class zznk
  implements zzk, AppIndexApi
{
  private static final String TAG = zznk.class.getSimpleName();

  public static Intent zza(String paramString, Uri paramUri)
  {
    zzb(paramString, paramUri);
    if (zzm(paramUri))
      return new Intent("android.intent.action.VIEW", paramUri);
    if (zzn(paramUri))
      return new Intent("android.intent.action.VIEW", zzl(paramUri));
    paramString = String.valueOf(paramUri);
    throw new RuntimeException(String.valueOf(paramString).length() + 70 + "appIndexingUri is neither an HTTP(S) URL nor an \"android-app://\" URL: " + paramString);
  }

  private PendingResult<Status> zza(GoogleApiClient paramGoogleApiClient, Action paramAction, int paramInt)
  {
    String str = paramGoogleApiClient.getContext().getPackageName();
    return zza(paramGoogleApiClient, new UsageInfo[] { zznj.zza(paramAction, System.currentTimeMillis(), str, paramInt) });
  }

  private static void zzb(String paramString, Uri paramUri)
  {
    if (zzm(paramUri))
    {
      if (paramUri.getHost().isEmpty())
      {
        paramString = String.valueOf(paramUri);
        throw new IllegalArgumentException(String.valueOf(paramString).length() + 98 + "AppIndex: The web URL must have a host (follow the format http(s)://<host>/<path>). Provided URI: " + paramString);
      }
    }
    else if (zzn(paramUri))
    {
      if ((paramString != null) && (!paramString.equals(paramUri.getHost())))
      {
        paramString = String.valueOf(paramUri);
        throw new IllegalArgumentException(String.valueOf(paramString).length() + 150 + "AppIndex: The android-app URI host must match the package name and follow the format android-app://<package_name>/<scheme>/<host_path>. Provided URI: " + paramString);
      }
      paramString = paramUri.getPathSegments();
      if ((paramString.isEmpty()) || (((String)paramString.get(0)).isEmpty()))
      {
        paramString = String.valueOf(paramUri);
        throw new IllegalArgumentException(String.valueOf(paramString).length() + 128 + "AppIndex: The app URI scheme must exist and follow the format android-app://<package_name>/<scheme>/<host_path>). Provided URI: " + paramString);
      }
    }
    else
    {
      paramString = String.valueOf(paramUri);
      throw new IllegalArgumentException(String.valueOf(paramString).length() + 176 + "AppIndex: The URI scheme must either be 'http(s)' or 'android-app'. If the latter, it must follow the format 'android-app://<package_name>/<scheme>/<host_path>'. Provided URI: " + paramString);
    }
  }

  private static Uri zzl(Uri paramUri)
  {
    Object localObject = paramUri.getPathSegments();
    String str = (String)((List)localObject).get(0);
    Uri.Builder localBuilder = new Uri.Builder();
    localBuilder.scheme(str);
    if (((List)localObject).size() > 1)
    {
      localBuilder.authority((String)((List)localObject).get(1));
      int i = 2;
      while (i < ((List)localObject).size())
      {
        localBuilder.appendPath((String)((List)localObject).get(i));
        i += 1;
      }
    }
    localObject = TAG;
    str = String.valueOf(paramUri);
    Log.e((String)localObject, String.valueOf(str).length() + 88 + "The app URI must have the format: android-app://<package_name>/<scheme>/<path>. But got " + str);
    localBuilder.encodedQuery(paramUri.getEncodedQuery());
    localBuilder.encodedFragment(paramUri.getEncodedFragment());
    return (Uri)localBuilder.build();
  }

  private static boolean zzm(Uri paramUri)
  {
    paramUri = paramUri.getScheme();
    return ("http".equals(paramUri)) || ("https".equals(paramUri));
  }

  private static boolean zzn(Uri paramUri)
  {
    return "android-app".equals(paramUri.getScheme());
  }

  public static void zzw(List<AppIndexApi.AppIndexingLink> paramList)
  {
    if (paramList == null);
    while (true)
    {
      return;
      paramList = paramList.iterator();
      while (paramList.hasNext())
        zzb(null, ((AppIndexApi.AppIndexingLink)paramList.next()).appIndexingUrl);
    }
  }

  public AppIndexApi.ActionResult action(GoogleApiClient paramGoogleApiClient, Action paramAction)
  {
    return new zza(this, zza(paramGoogleApiClient, paramAction, 1), paramAction);
  }

  public PendingResult<Status> end(GoogleApiClient paramGoogleApiClient, Action paramAction)
  {
    return zza(paramGoogleApiClient, paramAction, 2);
  }

  public PendingResult<Status> start(GoogleApiClient paramGoogleApiClient, Action paramAction)
  {
    return zza(paramGoogleApiClient, paramAction, 1);
  }

  public PendingResult<Status> view(GoogleApiClient paramGoogleApiClient, Activity paramActivity, Intent paramIntent, String paramString, Uri paramUri, List<AppIndexApi.AppIndexingLink> paramList)
  {
    paramActivity = paramGoogleApiClient.getContext().getPackageName();
    zzw(paramList);
    return zza(paramGoogleApiClient, new UsageInfo[] { new UsageInfo(paramActivity, paramIntent, paramString, paramUri, null, paramList, 1) });
  }

  public PendingResult<Status> view(GoogleApiClient paramGoogleApiClient, Activity paramActivity, Uri paramUri1, String paramString, Uri paramUri2, List<AppIndexApi.AppIndexingLink> paramList)
  {
    String str = paramGoogleApiClient.getContext().getPackageName();
    zzb(str, paramUri1);
    return view(paramGoogleApiClient, paramActivity, zza(str, paramUri1), paramString, paramUri2, paramList);
  }

  public PendingResult<Status> viewEnd(GoogleApiClient paramGoogleApiClient, Activity paramActivity, Intent paramIntent)
  {
    paramActivity = paramGoogleApiClient.getContext().getPackageName();
    return zza(paramGoogleApiClient, new UsageInfo[] { new UsageInfo.zza().zza(UsageInfo.zza(paramActivity, paramIntent)).zzaa(System.currentTimeMillis()).zzcq(0).zzcr(2).zzahs() });
  }

  public PendingResult<Status> viewEnd(GoogleApiClient paramGoogleApiClient, Activity paramActivity, Uri paramUri)
  {
    return viewEnd(paramGoogleApiClient, paramActivity, zza(paramGoogleApiClient.getContext().getPackageName(), paramUri));
  }

  public PendingResult<Status> zza(GoogleApiClient paramGoogleApiClient, UsageInfo[] paramArrayOfUsageInfo)
  {
    return paramGoogleApiClient.zza(new zzc(paramGoogleApiClient, paramArrayOfUsageInfo)
    {
      protected void zza(zznf paramzznf)
        throws RemoteException
      {
        paramzznf.zza(new zznk.zzd(this), null, this.gZ);
      }
    });
  }

  @Deprecated
  private static final class zza
    implements AppIndexApi.ActionResult
  {
    private zznk hb;
    private PendingResult<Status> hc;
    private Action hd;

    zza(zznk paramzznk, PendingResult<Status> paramPendingResult, Action paramAction)
    {
      this.hb = paramzznk;
      this.hc = paramPendingResult;
      this.hd = paramAction;
    }

    public PendingResult<Status> end(GoogleApiClient paramGoogleApiClient)
    {
      Object localObject = paramGoogleApiClient.getContext().getPackageName();
      long l = System.currentTimeMillis();
      localObject = zznj.zza(this.hd, l, (String)localObject, 2);
      return (PendingResult<Status>)this.hb.zza(paramGoogleApiClient, new UsageInfo[] { localObject });
    }

    public PendingResult<Status> getPendingResult()
    {
      return this.hc;
    }
  }

  private static abstract class zzb<T extends Result> extends zzqo.zza<T, zzni>
  {
    public zzb(GoogleApiClient paramGoogleApiClient)
    {
      super(paramGoogleApiClient);
    }

    protected abstract void zza(zznf paramzznf)
      throws RemoteException;

    protected final void zza(zzni paramzzni)
      throws RemoteException
    {
      zza(paramzzni.zzaht());
    }
  }

  public static abstract class zzc<T extends Result> extends zznk.zzb<Status>
  {
    public zzc(GoogleApiClient paramGoogleApiClient)
    {
      super();
    }

    protected Status zzb(Status paramStatus)
    {
      return paramStatus;
    }
  }

  public static final class zzd extends zznh<Status>
  {
    public zzd(zzqo.zzb<Status> paramzzb)
    {
      super();
    }

    public void zza(Status paramStatus)
    {
      this.gY.setResult(paramStatus);
    }
  }
}

/* Location:           C:\Users\c_jealom1\Documents\Scripts\Android\Fathom_com.brynk.fathom\Fathom_com.brynk.fathom-dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.zznk
 * JD-Core Version:    0.6.0
 */
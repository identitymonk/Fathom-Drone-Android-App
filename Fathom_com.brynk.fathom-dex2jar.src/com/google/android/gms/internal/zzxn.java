package com.google.android.gms.internal;

import android.content.Context;
import android.os.RemoteException;
import android.util.Log;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.search.GoogleNowAuthState;
import com.google.android.gms.search.SearchAuth;
import com.google.android.gms.search.SearchAuthApi;
import com.google.android.gms.search.SearchAuthApi.GoogleNowAuthResult;

public class zzxn
  implements SearchAuthApi
{
  public PendingResult<Status> clearToken(GoogleApiClient paramGoogleApiClient, String paramString)
  {
    return paramGoogleApiClient.zza(new zzb(paramGoogleApiClient, paramString));
  }

  public PendingResult<SearchAuthApi.GoogleNowAuthResult> getGoogleNowAuth(GoogleApiClient paramGoogleApiClient, String paramString)
  {
    return paramGoogleApiClient.zza(new zzc(paramGoogleApiClient, paramString));
  }

  static abstract class zza extends zzxk.zza
  {
    public void zza(Status paramStatus, GoogleNowAuthState paramGoogleNowAuthState)
    {
      throw new UnsupportedOperationException();
    }

    public void zzeh(Status paramStatus)
    {
      throw new UnsupportedOperationException();
    }
  }

  static class zzb extends zzqo.zza<Status, zzxm>
  {
    private final String aCW;
    private final String aCZ;
    private final boolean aDa = Log.isLoggable("SearchAuth", 3);

    protected zzb(GoogleApiClient paramGoogleApiClient, String paramString)
    {
      super(paramGoogleApiClient);
      this.aCW = paramString;
      this.aCZ = paramGoogleApiClient.getContext().getPackageName();
    }

    protected void zza(zzxm paramzzxm)
      throws RemoteException
    {
      if (this.aDa)
        Log.d("SearchAuth", "ClearTokenImpl started");
      1 local1 = new zzxn.zza()
      {
        public void zzeh(Status paramStatus)
        {
          if (zzxn.zzb.zza(zzxn.zzb.this))
            Log.d("SearchAuth", "ClearTokenImpl success");
          zzxn.zzb.this.zzc(paramStatus);
        }
      };
      ((zzxl)paramzzxm.zzavg()).zzb(local1, this.aCZ, this.aCW);
    }

    protected Status zzb(Status paramStatus)
    {
      if (this.aDa)
      {
        str = String.valueOf(paramStatus.getStatusMessage());
        if (str.length() == 0)
          break label38;
      }
      label38: for (String str = "ClearTokenImpl received failure: ".concat(str); ; str = new String("ClearTokenImpl received failure: "))
      {
        Log.d("SearchAuth", str);
        return paramStatus;
      }
    }
  }

  static class zzc extends zzqo.zza<SearchAuthApi.GoogleNowAuthResult, zzxm>
  {
    private final String aCZ;
    private final boolean aDa = Log.isLoggable("SearchAuth", 3);
    private final String aDc;

    protected zzc(GoogleApiClient paramGoogleApiClient, String paramString)
    {
      super(paramGoogleApiClient);
      this.aDc = paramString;
      this.aCZ = paramGoogleApiClient.getContext().getPackageName();
    }

    protected void zza(zzxm paramzzxm)
      throws RemoteException
    {
      if (this.aDa)
        Log.d("SearchAuth", "GetGoogleNowAuthImpl started");
      1 local1 = new zzxn.zza()
      {
        public void zza(Status paramStatus, GoogleNowAuthState paramGoogleNowAuthState)
        {
          if (zzxn.zzc.zza(zzxn.zzc.this))
            Log.d("SearchAuth", "GetGoogleNowAuthImpl success");
          zzxn.zzc.this.zzc(new zzxn.zzd(paramStatus, paramGoogleNowAuthState));
        }
      };
      ((zzxl)paramzzxm.zzavg()).zza(local1, this.aCZ, this.aDc);
    }

    protected SearchAuthApi.GoogleNowAuthResult zzei(Status paramStatus)
    {
      if (this.aDa)
      {
        str = String.valueOf(paramStatus.getStatusMessage());
        if (str.length() == 0)
          break label46;
      }
      label46: for (String str = "GetGoogleNowAuthImpl received failure: ".concat(str); ; str = new String("GetGoogleNowAuthImpl received failure: "))
      {
        Log.d("SearchAuth", str);
        return new zzxn.zzd(paramStatus, null);
      }
    }
  }

  static class zzd
    implements SearchAuthApi.GoogleNowAuthResult
  {
    private final GoogleNowAuthState aDe;
    private final Status hv;

    zzd(Status paramStatus, GoogleNowAuthState paramGoogleNowAuthState)
    {
      this.hv = paramStatus;
      this.aDe = paramGoogleNowAuthState;
    }

    public GoogleNowAuthState getGoogleNowAuthState()
    {
      return this.aDe;
    }

    public Status getStatus()
    {
      return this.hv;
    }
  }
}

/* Location:           C:\Users\c_jealom1\Documents\Scripts\Android\Fathom_com.brynk.fathom\Fathom_com.brynk.fathom-dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.zzxn
 * JD-Core Version:    0.6.0
 */
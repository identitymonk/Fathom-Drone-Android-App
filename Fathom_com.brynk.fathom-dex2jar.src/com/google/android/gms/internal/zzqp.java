package com.google.android.gms.internal;

import android.app.Activity;
import android.app.Dialog;
import android.app.PendingIntent;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.support.annotation.MainThread;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.GoogleApiAvailability;
import com.google.android.gms.common.api.GoogleApiActivity;

public abstract class zzqp extends zzro
  implements DialogInterface.OnCancelListener
{
  protected boolean mStarted;
  protected final GoogleApiAvailability xP;
  private ConnectionResult yA;
  private int yB = -1;
  private final Handler yC = new Handler(Looper.getMainLooper());
  protected boolean yz;

  protected zzqp(zzrp paramzzrp)
  {
    this(paramzzrp, GoogleApiAvailability.getInstance());
  }

  zzqp(zzrp paramzzrp, GoogleApiAvailability paramGoogleApiAvailability)
  {
    super(paramzzrp);
    this.xP = paramGoogleApiAvailability;
  }

  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    int i = 1;
    int j = 1;
    switch (paramInt1)
    {
    default:
      paramInt1 = 0;
      if (paramInt1 == 0)
        break;
      zzarq();
      return;
    case 2:
      label30: j = this.xP.isGooglePlayServicesAvailable(getActivity());
      if (j != 0);
    case 1:
    }
    for (paramInt2 = i; ; paramInt2 = 0)
    {
      paramInt1 = paramInt2;
      if (this.yA.getErrorCode() != 18)
        break label30;
      paramInt1 = paramInt2;
      if (j != 18)
        break label30;
      return;
      paramInt1 = j;
      if (paramInt2 == -1)
        break label30;
      if (paramInt2 != 0)
        break;
      if (paramIntent != null);
      for (paramInt1 = paramIntent.getIntExtra("<<ResolutionFailureErrorDetail>>", 13); ; paramInt1 = 13)
      {
        this.yA = new ConnectionResult(paramInt1, null);
        break;
        zza(this.yA, this.yB);
        return;
      }
    }
  }

  public void onCancel(DialogInterface paramDialogInterface)
  {
    zza(new ConnectionResult(13, null), this.yB);
    zzarq();
  }

  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    if (paramBundle != null)
    {
      this.yz = paramBundle.getBoolean("resolving_error", false);
      if (this.yz)
      {
        this.yB = paramBundle.getInt("failed_client_id", -1);
        this.yA = new ConnectionResult(paramBundle.getInt("failed_status"), (PendingIntent)paramBundle.getParcelable("failed_resolution"));
      }
    }
  }

  public void onSaveInstanceState(Bundle paramBundle)
  {
    super.onSaveInstanceState(paramBundle);
    paramBundle.putBoolean("resolving_error", this.yz);
    if (this.yz)
    {
      paramBundle.putInt("failed_client_id", this.yB);
      paramBundle.putInt("failed_status", this.yA.getErrorCode());
      paramBundle.putParcelable("failed_resolution", this.yA.getResolution());
    }
  }

  public void onStart()
  {
    super.onStart();
    this.mStarted = true;
  }

  public void onStop()
  {
    super.onStop();
    this.mStarted = false;
  }

  protected abstract void zza(ConnectionResult paramConnectionResult, int paramInt);

  protected abstract void zzarm();

  protected void zzarq()
  {
    this.yB = -1;
    this.yz = false;
    this.yA = null;
    zzarm();
  }

  public void zzb(ConnectionResult paramConnectionResult, int paramInt)
  {
    if (!this.yz)
    {
      this.yz = true;
      this.yB = paramInt;
      this.yA = paramConnectionResult;
      this.yC.post(new zza(null));
    }
  }

  private class zza
    implements Runnable
  {
    private zza()
    {
    }

    @MainThread
    public void run()
    {
      if (!zzqp.this.mStarted)
        return;
      if (zzqp.zza(zzqp.this).hasResolution())
      {
        zzqp.this.Bf.startActivityForResult(GoogleApiActivity.zzb(zzqp.this.getActivity(), zzqp.zza(zzqp.this).getResolution(), zzqp.zzb(zzqp.this), false), 1);
        return;
      }
      if (zzqp.this.xP.isUserResolvableError(zzqp.zza(zzqp.this).getErrorCode()))
      {
        zzqp.this.xP.zza(zzqp.this.getActivity(), zzqp.this.Bf, zzqp.zza(zzqp.this).getErrorCode(), 2, zzqp.this);
        return;
      }
      if (zzqp.zza(zzqp.this).getErrorCode() == 18)
      {
        Dialog localDialog = zzqp.this.xP.zza(zzqp.this.getActivity(), zzqp.this);
        zzqp.this.xP.zza(zzqp.this.getActivity().getApplicationContext(), new zzrj.zza(localDialog)
        {
          public void zzarr()
          {
            zzqp.this.zzarq();
            if (this.yE.isShowing())
              this.yE.dismiss();
          }
        });
        return;
      }
      zzqp.this.zza(zzqp.zza(zzqp.this), zzqp.zzb(zzqp.this));
    }
  }
}

/* Location:           C:\Users\c_jealom1\Documents\Scripts\Android\Fathom_com.brynk.fathom\Fathom_com.brynk.fathom-dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.zzqp
 * JD-Core Version:    0.6.0
 */
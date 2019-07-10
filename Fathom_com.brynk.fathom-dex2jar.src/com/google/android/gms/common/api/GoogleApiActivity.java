package com.google.android.gms.common.api;

import android.app.Activity;
import android.app.PendingIntent;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.Intent;
import android.content.IntentSender.SendIntentException;
import android.os.Bundle;
import android.util.Log;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.GoogleApiAvailability;
import com.google.android.gms.internal.zzrh;

public class GoogleApiActivity extends Activity
  implements DialogInterface.OnCancelListener
{
  protected int xD = 0;

  public static PendingIntent zza(Context paramContext, PendingIntent paramPendingIntent, int paramInt)
  {
    return zza(paramContext, paramPendingIntent, paramInt, true);
  }

  public static PendingIntent zza(Context paramContext, PendingIntent paramPendingIntent, int paramInt, boolean paramBoolean)
  {
    return PendingIntent.getActivity(paramContext, 0, zzb(paramContext, paramPendingIntent, paramInt, paramBoolean), 134217728);
  }

  private void zza(int paramInt, zzrh paramzzrh)
  {
    switch (paramInt)
    {
    default:
      return;
    case 0:
      paramzzrh.zza(new ConnectionResult(13, null), getIntent().getIntExtra("failing_client_id", -1));
      return;
    case -1:
    }
    paramzzrh.zzarm();
  }

  private void zzarb()
  {
    Object localObject = getIntent().getExtras();
    if (localObject == null)
    {
      Log.e("GoogleApiActivity", "Activity started without extras");
      finish();
      return;
    }
    PendingIntent localPendingIntent = (PendingIntent)((Bundle)localObject).get("pending_intent");
    localObject = (Integer)((Bundle)localObject).get("error_code");
    if ((localPendingIntent == null) && (localObject == null))
    {
      Log.e("GoogleApiActivity", "Activity started without resolution");
      finish();
      return;
    }
    if (localPendingIntent != null)
      try
      {
        startIntentSenderForResult(localPendingIntent.getIntentSender(), 1, null, 0, 0, 0);
        this.xD = 1;
        return;
      }
      catch (IntentSender.SendIntentException localSendIntentException)
      {
        Log.e("GoogleApiActivity", "Failed to launch pendingIntent", localSendIntentException);
        finish();
        return;
      }
    GoogleApiAvailability.getInstance().showErrorDialogFragment(this, ((Integer)localObject).intValue(), 2, this);
    this.xD = 1;
  }

  public static Intent zzb(Context paramContext, PendingIntent paramPendingIntent, int paramInt, boolean paramBoolean)
  {
    paramContext = new Intent(paramContext, GoogleApiActivity.class);
    paramContext.putExtra("pending_intent", paramPendingIntent);
    paramContext.putExtra("failing_client_id", paramInt);
    paramContext.putExtra("notify_manager", paramBoolean);
    return paramContext;
  }

  protected void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    if (paramInt1 == 1)
    {
      boolean bool = getIntent().getBooleanExtra("notify_manager", true);
      this.xD = 0;
      setResultCode(paramInt2);
      if (bool)
        zza(paramInt2, zzrh.zzbx(this));
    }
    while (true)
    {
      finish();
      return;
      if (paramInt1 != 2)
        continue;
      this.xD = 0;
      setResultCode(paramInt2);
    }
  }

  public void onCancel(DialogInterface paramDialogInterface)
  {
    this.xD = 0;
    setResult(0);
    finish();
  }

  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    if (paramBundle != null)
      this.xD = paramBundle.getInt("resolution");
    if (this.xD != 1)
      zzarb();
  }

  protected void onSaveInstanceState(Bundle paramBundle)
  {
    paramBundle.putInt("resolution", this.xD);
    super.onSaveInstanceState(paramBundle);
  }

  protected void setResultCode(int paramInt)
  {
    setResult(paramInt);
  }
}

/* Location:           C:\Users\c_jealom1\Documents\Scripts\Android\Fathom_com.brynk.fathom\Fathom_com.brynk.fathom-dex2jar.jar
 * Qualified Name:     com.google.android.gms.common.api.GoogleApiActivity
 * JD-Core Version:    0.6.0
 */
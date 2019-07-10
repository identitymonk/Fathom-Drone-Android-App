package com.google.android.gms.common.internal;

import android.annotation.TargetApi;
import android.app.Activity;
import android.content.ActivityNotFoundException;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.util.Log;
import com.google.android.gms.internal.zzrp;

public abstract class zzh
  implements DialogInterface.OnClickListener
{
  public static zzh zza(Activity paramActivity, Intent paramIntent, int paramInt)
  {
    return new zzh(paramIntent, paramActivity, paramInt)
    {
      public void zzavx()
      {
        if (zzh.this != null)
          this.val$activity.startActivityForResult(zzh.this, this.val$requestCode);
      }
    };
  }

  public static zzh zza(@NonNull Fragment paramFragment, Intent paramIntent, int paramInt)
  {
    return new zzh(paramIntent, paramFragment, paramInt)
    {
      public void zzavx()
      {
        if (zzh.this != null)
          this.val$fragment.startActivityForResult(zzh.this, this.val$requestCode);
      }
    };
  }

  public static zzh zza(@NonNull zzrp paramzzrp, Intent paramIntent, int paramInt)
  {
    return new zzh(paramIntent, paramzzrp, paramInt)
    {
      @TargetApi(11)
      public void zzavx()
      {
        if (zzh.this != null)
          this.DP.startActivityForResult(zzh.this, this.val$requestCode);
      }
    };
  }

  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    try
    {
      zzavx();
      return;
    }
    catch (ActivityNotFoundException localActivityNotFoundException)
    {
      Log.e("DialogRedirect", "Failed to start resolution intent", localActivityNotFoundException);
      return;
    }
    finally
    {
      paramDialogInterface.dismiss();
    }
    throw localObject;
  }

  protected abstract void zzavx();
}

/* Location:           C:\Users\c_jealom1\Documents\Scripts\Android\Fathom_com.brynk.fathom\Fathom_com.brynk.fathom-dex2jar.jar
 * Qualified Name:     com.google.android.gms.common.internal.zzh
 * JD-Core Version:    0.6.0
 */
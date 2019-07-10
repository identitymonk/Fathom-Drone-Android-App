package com.google.android.gms.common.api;

import android.app.Activity;
import android.app.PendingIntent;
import android.content.IntentSender.SendIntentException;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.support.annotation.Nullable;
import com.google.android.gms.common.internal.ReflectedParcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.zzz;
import com.google.android.gms.common.internal.zzz.zza;

public final class Status extends AbstractSafeParcelable
  implements Result, ReflectedParcelable
{
  public static final Parcelable.Creator<Status> CREATOR;
  public static final Status xZ = new Status(0);
  public static final Status ya = new Status(14);
  public static final Status yb = new Status(8);
  public static final Status yc = new Status(15);
  public static final Status yd = new Status(16);
  public static final Status ye = new Status(17);
  public static final Status yf = new Status(18);
  private final PendingIntent mPendingIntent;
  final int mVersionCode;
  private final int uo;
  private final String wP;

  static
  {
    CREATOR = new zzg();
  }

  public Status(int paramInt)
  {
    this(paramInt, null);
  }

  Status(int paramInt1, int paramInt2, String paramString, PendingIntent paramPendingIntent)
  {
    this.mVersionCode = paramInt1;
    this.uo = paramInt2;
    this.wP = paramString;
    this.mPendingIntent = paramPendingIntent;
  }

  public Status(int paramInt, String paramString)
  {
    this(1, paramInt, paramString, null);
  }

  public Status(int paramInt, String paramString, PendingIntent paramPendingIntent)
  {
    this(1, paramInt, paramString, paramPendingIntent);
  }

  public boolean equals(Object paramObject)
  {
    if (!(paramObject instanceof Status));
    do
    {
      return false;
      paramObject = (Status)paramObject;
    }
    while ((this.mVersionCode != paramObject.mVersionCode) || (this.uo != paramObject.uo) || (!zzz.equal(this.wP, paramObject.wP)) || (!zzz.equal(this.mPendingIntent, paramObject.mPendingIntent)));
    return true;
  }

  public PendingIntent getResolution()
  {
    return this.mPendingIntent;
  }

  public Status getStatus()
  {
    return this;
  }

  public int getStatusCode()
  {
    return this.uo;
  }

  @Nullable
  public String getStatusMessage()
  {
    return this.wP;
  }

  public boolean hasResolution()
  {
    return this.mPendingIntent != null;
  }

  public int hashCode()
  {
    return zzz.hashCode(new Object[] { Integer.valueOf(this.mVersionCode), Integer.valueOf(this.uo), this.wP, this.mPendingIntent });
  }

  public boolean isCanceled()
  {
    return this.uo == 16;
  }

  public boolean isInterrupted()
  {
    return this.uo == 14;
  }

  public boolean isSuccess()
  {
    return this.uo <= 0;
  }

  public void startResolutionForResult(Activity paramActivity, int paramInt)
    throws IntentSender.SendIntentException
  {
    if (!hasResolution())
      return;
    paramActivity.startIntentSenderForResult(this.mPendingIntent.getIntentSender(), paramInt, null, 0, 0, 0);
  }

  public String toString()
  {
    return zzz.zzx(this).zzg("statusCode", zzark()).zzg("resolution", this.mPendingIntent).toString();
  }

  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    zzg.zza(this, paramParcel, paramInt);
  }

  PendingIntent zzarj()
  {
    return this.mPendingIntent;
  }

  public String zzark()
  {
    if (this.wP != null)
      return this.wP;
    return CommonStatusCodes.getStatusCodeString(this.uo);
  }
}

/* Location:           C:\Users\c_jealom1\Documents\Scripts\Android\Fathom_com.brynk.fathom\Fathom_com.brynk.fathom-dex2jar.jar
 * Qualified Name:     com.google.android.gms.common.api.Status
 * JD-Core Version:    0.6.0
 */
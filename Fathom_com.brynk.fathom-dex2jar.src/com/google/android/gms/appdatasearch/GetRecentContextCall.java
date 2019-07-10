package com.google.android.gms.appdatasearch;

import android.accounts.Account;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import java.util.List;

public class GetRecentContextCall
{
  public static class Request extends AbstractSafeParcelable
  {
    public static final Parcelable.Creator<Request> CREATOR = new zzf();
    public final Account gt;
    public final boolean gu;
    public final boolean gv;
    public final boolean gw;
    public final String gx;
    final int mVersionCode;

    public Request()
    {
      this(null, false, false, false, null);
    }

    Request(int paramInt, Account paramAccount, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, String paramString)
    {
      this.mVersionCode = paramInt;
      this.gt = paramAccount;
      this.gu = paramBoolean1;
      this.gv = paramBoolean2;
      this.gw = paramBoolean3;
      this.gx = paramString;
    }

    public Request(Account paramAccount, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, String paramString)
    {
      this(1, paramAccount, paramBoolean1, paramBoolean2, paramBoolean3, paramString);
    }

    public void writeToParcel(Parcel paramParcel, int paramInt)
    {
      zzf.zza(this, paramParcel, paramInt);
    }
  }

  public static class Response extends AbstractSafeParcelable
    implements Result
  {
    public static final Parcelable.Creator<Response> CREATOR = new zzg();

    @Deprecated
    public String[] gA;
    public Status gy;
    public List<UsageInfo> gz;
    final int mVersionCode;

    public Response()
    {
      this.mVersionCode = 1;
    }

    Response(int paramInt, Status paramStatus, List<UsageInfo> paramList, String[] paramArrayOfString)
    {
      this.mVersionCode = paramInt;
      this.gy = paramStatus;
      this.gz = paramList;
      this.gA = paramArrayOfString;
    }

    public Status getStatus()
    {
      return this.gy;
    }

    public void writeToParcel(Parcel paramParcel, int paramInt)
    {
      zzg.zza(this, paramParcel, paramInt);
    }
  }
}

/* Location:           C:\Users\c_jealom1\Documents\Scripts\Android\Fathom_com.brynk.fathom\Fathom_com.brynk.fathom-dex2jar.jar
 * Qualified Name:     com.google.android.gms.appdatasearch.GetRecentContextCall
 * JD-Core Version:    0.6.0
 */
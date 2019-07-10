package com.google.android.gms.common.internal;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.annotation.KeepName;

@KeepName
public final class BinderWrapper
  implements Parcelable
{
  public static final Parcelable.Creator<BinderWrapper> CREATOR = new Parcelable.Creator()
  {
    public BinderWrapper zzck(Parcel paramParcel)
    {
      return new BinderWrapper(paramParcel, null);
    }

    public BinderWrapper[] zzgl(int paramInt)
    {
      return new BinderWrapper[paramInt];
    }
  };
  private IBinder DI = null;

  public BinderWrapper()
  {
  }

  public BinderWrapper(IBinder paramIBinder)
  {
    this.DI = paramIBinder;
  }

  private BinderWrapper(Parcel paramParcel)
  {
    this.DI = paramParcel.readStrongBinder();
  }

  public int describeContents()
  {
    return 0;
  }

  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeStrongBinder(this.DI);
  }
}

/* Location:           C:\Users\c_jealom1\Documents\Scripts\Android\Fathom_com.brynk.fathom\Fathom_com.brynk.fathom-dex2jar.jar
 * Qualified Name:     com.google.android.gms.common.internal.BinderWrapper
 * JD-Core Version:    0.6.0
 */
package com.google.android.gms.internal;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.os.RemoteException;
import com.google.android.gms.common.api.Status;

public abstract interface zzrl extends IInterface
{
  public abstract void zzp(Status paramStatus)
    throws RemoteException;

  public static abstract class zza extends Binder
    implements zzrl
  {
    public zza()
    {
      attachInterface(this, "com.google.android.gms.common.api.internal.IStatusCallback");
    }

    public static zzrl zzdp(IBinder paramIBinder)
    {
      if (paramIBinder == null)
        return null;
      IInterface localIInterface = paramIBinder.queryLocalInterface("com.google.android.gms.common.api.internal.IStatusCallback");
      if ((localIInterface != null) && ((localIInterface instanceof zzrl)))
        return (zzrl)localIInterface;
      return new zza(paramIBinder);
    }

    public IBinder asBinder()
    {
      return this;
    }

    public boolean onTransact(int paramInt1, Parcel paramParcel1, Parcel paramParcel2, int paramInt2)
      throws RemoteException
    {
      switch (paramInt1)
      {
      default:
        return super.onTransact(paramInt1, paramParcel1, paramParcel2, paramInt2);
      case 1598968902:
        paramParcel2.writeString("com.google.android.gms.common.api.internal.IStatusCallback");
        return true;
      case 1:
      }
      paramParcel1.enforceInterface("com.google.android.gms.common.api.internal.IStatusCallback");
      if (paramParcel1.readInt() != 0);
      for (paramParcel1 = (Status)Status.CREATOR.createFromParcel(paramParcel1); ; paramParcel1 = null)
      {
        zzp(paramParcel1);
        return true;
      }
    }

    private static class zza
      implements zzrl
    {
      private IBinder zzajq;

      zza(IBinder paramIBinder)
      {
        this.zzajq = paramIBinder;
      }

      public IBinder asBinder()
      {
        return this.zzajq;
      }

      public void zzp(Status paramStatus)
        throws RemoteException
      {
        Parcel localParcel = Parcel.obtain();
        try
        {
          localParcel.writeInterfaceToken("com.google.android.gms.common.api.internal.IStatusCallback");
          if (paramStatus != null)
          {
            localParcel.writeInt(1);
            paramStatus.writeToParcel(localParcel, 0);
          }
          while (true)
          {
            this.zzajq.transact(1, localParcel, null, 1);
            return;
            localParcel.writeInt(0);
          }
        }
        finally
        {
          localParcel.recycle();
        }
        throw paramStatus;
      }
    }
  }
}

/* Location:           C:\Users\c_jealom1\Documents\Scripts\Android\Fathom_com.brynk.fathom\Fathom_com.brynk.fathom-dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.zzrl
 * JD-Core Version:    0.6.0
 */
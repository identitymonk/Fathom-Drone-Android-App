package com.google.android.gms.internal;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.ParcelFileDescriptor;
import android.os.Parcelable.Creator;
import android.os.RemoteException;
import com.google.android.gms.appdatasearch.GetRecentContextCall.Response;
import com.google.android.gms.common.api.Status;

public abstract interface zzng extends IInterface
{
  public abstract void zza(GetRecentContextCall.Response paramResponse)
    throws RemoteException;

  public abstract void zza(Status paramStatus)
    throws RemoteException;

  public abstract void zza(Status paramStatus, ParcelFileDescriptor paramParcelFileDescriptor)
    throws RemoteException;

  public abstract void zza(Status paramStatus, boolean paramBoolean)
    throws RemoteException;

  public static abstract class zza extends Binder
    implements zzng
  {
    public zza()
    {
      attachInterface(this, "com.google.android.gms.appdatasearch.internal.ILightweightAppDataSearchCallbacks");
    }

    public static zzng zzbo(IBinder paramIBinder)
    {
      if (paramIBinder == null)
        return null;
      IInterface localIInterface = paramIBinder.queryLocalInterface("com.google.android.gms.appdatasearch.internal.ILightweightAppDataSearchCallbacks");
      if ((localIInterface != null) && ((localIInterface instanceof zzng)))
        return (zzng)localIInterface;
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
        paramParcel2.writeString("com.google.android.gms.appdatasearch.internal.ILightweightAppDataSearchCallbacks");
        return true;
      case 1:
        paramParcel1.enforceInterface("com.google.android.gms.appdatasearch.internal.ILightweightAppDataSearchCallbacks");
        if (paramParcel1.readInt() != 0);
        for (paramParcel1 = (Status)Status.CREATOR.createFromParcel(paramParcel1); ; paramParcel1 = null)
        {
          zza(paramParcel1);
          return true;
        }
      case 2:
        paramParcel1.enforceInterface("com.google.android.gms.appdatasearch.internal.ILightweightAppDataSearchCallbacks");
        if (paramParcel1.readInt() != 0)
        {
          paramParcel2 = (Status)Status.CREATOR.createFromParcel(paramParcel1);
          if (paramParcel1.readInt() == 0)
            break label167;
        }
        for (paramParcel1 = (ParcelFileDescriptor)ParcelFileDescriptor.CREATOR.createFromParcel(paramParcel1); ; paramParcel1 = null)
        {
          zza(paramParcel2, paramParcel1);
          return true;
          paramParcel2 = null;
          break;
        }
      case 3:
        label167: paramParcel1.enforceInterface("com.google.android.gms.appdatasearch.internal.ILightweightAppDataSearchCallbacks");
        if (paramParcel1.readInt() != 0)
        {
          paramParcel2 = (Status)Status.CREATOR.createFromParcel(paramParcel1);
          if (paramParcel1.readInt() == 0)
            break label222;
        }
        label222: for (boolean bool = true; ; bool = false)
        {
          zza(paramParcel2, bool);
          return true;
          paramParcel2 = null;
          break;
        }
      case 4:
      }
      paramParcel1.enforceInterface("com.google.android.gms.appdatasearch.internal.ILightweightAppDataSearchCallbacks");
      if (paramParcel1.readInt() != 0);
      for (paramParcel1 = (GetRecentContextCall.Response)GetRecentContextCall.Response.CREATOR.createFromParcel(paramParcel1); ; paramParcel1 = null)
      {
        zza(paramParcel1);
        return true;
      }
    }

    private static class zza
      implements zzng
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

      public void zza(GetRecentContextCall.Response paramResponse)
        throws RemoteException
      {
        Parcel localParcel = Parcel.obtain();
        try
        {
          localParcel.writeInterfaceToken("com.google.android.gms.appdatasearch.internal.ILightweightAppDataSearchCallbacks");
          if (paramResponse != null)
          {
            localParcel.writeInt(1);
            paramResponse.writeToParcel(localParcel, 0);
          }
          while (true)
          {
            this.zzajq.transact(4, localParcel, null, 1);
            return;
            localParcel.writeInt(0);
          }
        }
        finally
        {
          localParcel.recycle();
        }
        throw paramResponse;
      }

      public void zza(Status paramStatus)
        throws RemoteException
      {
        Parcel localParcel = Parcel.obtain();
        try
        {
          localParcel.writeInterfaceToken("com.google.android.gms.appdatasearch.internal.ILightweightAppDataSearchCallbacks");
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

      public void zza(Status paramStatus, ParcelFileDescriptor paramParcelFileDescriptor)
        throws RemoteException
      {
        Parcel localParcel = Parcel.obtain();
        while (true)
        {
          try
          {
            localParcel.writeInterfaceToken("com.google.android.gms.appdatasearch.internal.ILightweightAppDataSearchCallbacks");
            if (paramStatus == null)
              continue;
            localParcel.writeInt(1);
            paramStatus.writeToParcel(localParcel, 0);
            if (paramParcelFileDescriptor != null)
            {
              localParcel.writeInt(1);
              paramParcelFileDescriptor.writeToParcel(localParcel, 0);
              this.zzajq.transact(2, localParcel, null, 1);
              return;
              localParcel.writeInt(0);
              continue;
            }
          }
          finally
          {
            localParcel.recycle();
          }
          localParcel.writeInt(0);
        }
      }

      public void zza(Status paramStatus, boolean paramBoolean)
        throws RemoteException
      {
        int i = 1;
        Parcel localParcel = Parcel.obtain();
        while (true)
        {
          try
          {
            localParcel.writeInterfaceToken("com.google.android.gms.appdatasearch.internal.ILightweightAppDataSearchCallbacks");
            if (paramStatus == null)
              continue;
            localParcel.writeInt(1);
            paramStatus.writeToParcel(localParcel, 0);
            break label83;
            localParcel.writeInt(i);
            this.zzajq.transact(3, localParcel, null, 1);
            return;
            localParcel.writeInt(0);
          }
          finally
          {
            localParcel.recycle();
          }
          label83: 
          do
          {
            i = 0;
            break;
          }
          while (!paramBoolean);
        }
      }
    }
  }
}

/* Location:           C:\Users\c_jealom1\Documents\Scripts\Android\Fathom_com.brynk.fathom\Fathom_com.brynk.fathom-dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.zzng
 * JD-Core Version:    0.6.0
 */
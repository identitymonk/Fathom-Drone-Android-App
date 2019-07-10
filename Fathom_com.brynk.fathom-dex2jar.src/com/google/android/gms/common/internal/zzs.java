package com.google.android.gms.common.internal;

import android.os.Binder;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.os.RemoteException;

public abstract interface zzs extends IInterface
{
  public abstract void zza(int paramInt, IBinder paramIBinder, Bundle paramBundle)
    throws RemoteException;

  public abstract void zzb(int paramInt, Bundle paramBundle)
    throws RemoteException;

  public static abstract class zza extends Binder
    implements zzs
  {
    public zza()
    {
      attachInterface(this, "com.google.android.gms.common.internal.IGmsCallbacks");
    }

    public static zzs zzdt(IBinder paramIBinder)
    {
      if (paramIBinder == null)
        return null;
      IInterface localIInterface = paramIBinder.queryLocalInterface("com.google.android.gms.common.internal.IGmsCallbacks");
      if ((localIInterface != null) && ((localIInterface instanceof zzs)))
        return (zzs)localIInterface;
      return new zza(paramIBinder);
    }

    public IBinder asBinder()
    {
      return this;
    }

    public boolean onTransact(int paramInt1, Parcel paramParcel1, Parcel paramParcel2, int paramInt2)
      throws RemoteException
    {
      IBinder localIBinder = null;
      Object localObject = null;
      switch (paramInt1)
      {
      default:
        return super.onTransact(paramInt1, paramParcel1, paramParcel2, paramInt2);
      case 1598968902:
        paramParcel2.writeString("com.google.android.gms.common.internal.IGmsCallbacks");
        return true;
      case 1:
        paramParcel1.enforceInterface("com.google.android.gms.common.internal.IGmsCallbacks");
        paramInt1 = paramParcel1.readInt();
        localIBinder = paramParcel1.readStrongBinder();
        if (paramParcel1.readInt() != 0)
          localObject = (Bundle)Bundle.CREATOR.createFromParcel(paramParcel1);
        zza(paramInt1, localIBinder, (Bundle)localObject);
        paramParcel2.writeNoException();
        return true;
      case 2:
      }
      paramParcel1.enforceInterface("com.google.android.gms.common.internal.IGmsCallbacks");
      paramInt1 = paramParcel1.readInt();
      localObject = localIBinder;
      if (paramParcel1.readInt() != 0)
        localObject = (Bundle)Bundle.CREATOR.createFromParcel(paramParcel1);
      zzb(paramInt1, (Bundle)localObject);
      paramParcel2.writeNoException();
      return true;
    }

    private static class zza
      implements zzs
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

      public void zza(int paramInt, IBinder paramIBinder, Bundle paramBundle)
        throws RemoteException
      {
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        try
        {
          localParcel1.writeInterfaceToken("com.google.android.gms.common.internal.IGmsCallbacks");
          localParcel1.writeInt(paramInt);
          localParcel1.writeStrongBinder(paramIBinder);
          if (paramBundle != null)
          {
            localParcel1.writeInt(1);
            paramBundle.writeToParcel(localParcel1, 0);
          }
          while (true)
          {
            this.zzajq.transact(1, localParcel1, localParcel2, 0);
            localParcel2.readException();
            return;
            localParcel1.writeInt(0);
          }
        }
        finally
        {
          localParcel2.recycle();
          localParcel1.recycle();
        }
        throw paramIBinder;
      }

      public void zzb(int paramInt, Bundle paramBundle)
        throws RemoteException
      {
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        try
        {
          localParcel1.writeInterfaceToken("com.google.android.gms.common.internal.IGmsCallbacks");
          localParcel1.writeInt(paramInt);
          if (paramBundle != null)
          {
            localParcel1.writeInt(1);
            paramBundle.writeToParcel(localParcel1, 0);
          }
          while (true)
          {
            this.zzajq.transact(2, localParcel1, localParcel2, 0);
            localParcel2.readException();
            return;
            localParcel1.writeInt(0);
          }
        }
        finally
        {
          localParcel2.recycle();
          localParcel1.recycle();
        }
        throw paramBundle;
      }
    }
  }
}

/* Location:           C:\Users\c_jealom1\Documents\Scripts\Android\Fathom_com.brynk.fathom\Fathom_com.brynk.fathom-dex2jar.jar
 * Qualified Name:     com.google.android.gms.common.internal.zzs
 * JD-Core Version:    0.6.0
 */
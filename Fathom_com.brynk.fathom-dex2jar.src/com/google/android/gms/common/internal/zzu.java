package com.google.android.gms.common.internal;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.dynamic.zzd;
import com.google.android.gms.dynamic.zzd.zza;

public abstract interface zzu extends IInterface
{
  public abstract zzd zzawi()
    throws RemoteException;

  public abstract zzd zzawj()
    throws RemoteException;

  public abstract boolean zzd(String paramString, zzd paramzzd)
    throws RemoteException;

  public abstract boolean zze(String paramString, zzd paramzzd)
    throws RemoteException;

  public static abstract class zza extends Binder
    implements zzu
  {
    public static zzu zzdv(IBinder paramIBinder)
    {
      if (paramIBinder == null)
        return null;
      IInterface localIInterface = paramIBinder.queryLocalInterface("com.google.android.gms.common.internal.IGoogleCertificatesApi");
      if ((localIInterface != null) && ((localIInterface instanceof zzu)))
        return (zzu)localIInterface;
      return new zza(paramIBinder);
    }

    public boolean onTransact(int paramInt1, Parcel paramParcel1, Parcel paramParcel2, int paramInt2)
      throws RemoteException
    {
      zzd localzzd2 = null;
      zzd localzzd1 = null;
      int i = 0;
      switch (paramInt1)
      {
      default:
        return super.onTransact(paramInt1, paramParcel1, paramParcel2, paramInt2);
      case 1598968902:
        paramParcel2.writeString("com.google.android.gms.common.internal.IGoogleCertificatesApi");
        return true;
      case 1:
        paramParcel1.enforceInterface("com.google.android.gms.common.internal.IGoogleCertificatesApi");
        localzzd2 = zzawi();
        paramParcel2.writeNoException();
        paramParcel1 = localzzd1;
        if (localzzd2 != null)
          paramParcel1 = localzzd2.asBinder();
        paramParcel2.writeStrongBinder(paramParcel1);
        return true;
      case 2:
        paramParcel1.enforceInterface("com.google.android.gms.common.internal.IGoogleCertificatesApi");
        localzzd1 = zzawj();
        paramParcel2.writeNoException();
        paramParcel1 = localzzd2;
        if (localzzd1 != null)
          paramParcel1 = localzzd1.asBinder();
        paramParcel2.writeStrongBinder(paramParcel1);
        return true;
      case 3:
        paramParcel1.enforceInterface("com.google.android.gms.common.internal.IGoogleCertificatesApi");
        bool = zzd(paramParcel1.readString(), zzd.zza.zzfd(paramParcel1.readStrongBinder()));
        paramParcel2.writeNoException();
        if (bool);
        for (paramInt1 = 1; ; paramInt1 = 0)
        {
          paramParcel2.writeInt(paramInt1);
          return true;
        }
      case 4:
      }
      paramParcel1.enforceInterface("com.google.android.gms.common.internal.IGoogleCertificatesApi");
      boolean bool = zze(paramParcel1.readString(), zzd.zza.zzfd(paramParcel1.readStrongBinder()));
      paramParcel2.writeNoException();
      paramInt1 = i;
      if (bool)
        paramInt1 = 1;
      paramParcel2.writeInt(paramInt1);
      return true;
    }

    private static class zza
      implements zzu
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

      public zzd zzawi()
        throws RemoteException
      {
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        try
        {
          localParcel1.writeInterfaceToken("com.google.android.gms.common.internal.IGoogleCertificatesApi");
          this.zzajq.transact(1, localParcel1, localParcel2, 0);
          localParcel2.readException();
          zzd localzzd = zzd.zza.zzfd(localParcel2.readStrongBinder());
          return localzzd;
        }
        finally
        {
          localParcel2.recycle();
          localParcel1.recycle();
        }
        throw localObject;
      }

      public zzd zzawj()
        throws RemoteException
      {
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        try
        {
          localParcel1.writeInterfaceToken("com.google.android.gms.common.internal.IGoogleCertificatesApi");
          this.zzajq.transact(2, localParcel1, localParcel2, 0);
          localParcel2.readException();
          zzd localzzd = zzd.zza.zzfd(localParcel2.readStrongBinder());
          return localzzd;
        }
        finally
        {
          localParcel2.recycle();
          localParcel1.recycle();
        }
        throw localObject;
      }

      public boolean zzd(String paramString, zzd paramzzd)
        throws RemoteException
      {
        int j = 0;
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        try
        {
          localParcel1.writeInterfaceToken("com.google.android.gms.common.internal.IGoogleCertificatesApi");
          localParcel1.writeString(paramString);
          if (paramzzd != null);
          for (paramString = paramzzd.asBinder(); ; paramString = null)
          {
            localParcel1.writeStrongBinder(paramString);
            this.zzajq.transact(3, localParcel1, localParcel2, 0);
            localParcel2.readException();
            int i = localParcel2.readInt();
            if (i != 0)
              j = 1;
            return j;
          }
        }
        finally
        {
          localParcel2.recycle();
          localParcel1.recycle();
        }
        throw paramString;
      }

      public boolean zze(String paramString, zzd paramzzd)
        throws RemoteException
      {
        int j = 0;
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        try
        {
          localParcel1.writeInterfaceToken("com.google.android.gms.common.internal.IGoogleCertificatesApi");
          localParcel1.writeString(paramString);
          if (paramzzd != null);
          for (paramString = paramzzd.asBinder(); ; paramString = null)
          {
            localParcel1.writeStrongBinder(paramString);
            this.zzajq.transact(4, localParcel1, localParcel2, 0);
            localParcel2.readException();
            int i = localParcel2.readInt();
            if (i != 0)
              j = 1;
            return j;
          }
        }
        finally
        {
          localParcel2.recycle();
          localParcel1.recycle();
        }
        throw paramString;
      }
    }
  }
}

/* Location:           C:\Users\c_jealom1\Documents\Scripts\Android\Fathom_com.brynk.fathom\Fathom_com.brynk.fathom-dex2jar.jar
 * Qualified Name:     com.google.android.gms.common.internal.zzu
 * JD-Core Version:    0.6.0
 */
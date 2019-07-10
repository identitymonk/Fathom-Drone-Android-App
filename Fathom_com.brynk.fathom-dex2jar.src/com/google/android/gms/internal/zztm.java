package com.google.android.gms.internal;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.dynamic.zzd;
import com.google.android.gms.dynamic.zzd.zza;

public abstract interface zztm extends IInterface
{
  public abstract int zza(zzd paramzzd, String paramString, boolean paramBoolean)
    throws RemoteException;

  public abstract zzd zza(zzd paramzzd, String paramString, int paramInt)
    throws RemoteException;

  public abstract int zzf(zzd paramzzd, String paramString)
    throws RemoteException;

  public static abstract class zza extends Binder
    implements zztm
  {
    public static zztm zzfe(IBinder paramIBinder)
    {
      if (paramIBinder == null)
        return null;
      IInterface localIInterface = paramIBinder.queryLocalInterface("com.google.android.gms.dynamite.IDynamiteLoader");
      if ((localIInterface != null) && ((localIInterface instanceof zztm)))
        return (zztm)localIInterface;
      return new zza(paramIBinder);
    }

    public boolean onTransact(int paramInt1, Parcel paramParcel1, Parcel paramParcel2, int paramInt2)
      throws RemoteException
    {
      switch (paramInt1)
      {
      default:
        return super.onTransact(paramInt1, paramParcel1, paramParcel2, paramInt2);
      case 1598968902:
        paramParcel2.writeString("com.google.android.gms.dynamite.IDynamiteLoader");
        return true;
      case 1:
        paramParcel1.enforceInterface("com.google.android.gms.dynamite.IDynamiteLoader");
        paramInt1 = zzf(zzd.zza.zzfd(paramParcel1.readStrongBinder()), paramParcel1.readString());
        paramParcel2.writeNoException();
        paramParcel2.writeInt(paramInt1);
        return true;
      case 2:
        paramParcel1.enforceInterface("com.google.android.gms.dynamite.IDynamiteLoader");
        paramParcel1 = zza(zzd.zza.zzfd(paramParcel1.readStrongBinder()), paramParcel1.readString(), paramParcel1.readInt());
        paramParcel2.writeNoException();
        if (paramParcel1 != null);
        for (paramParcel1 = paramParcel1.asBinder(); ; paramParcel1 = null)
        {
          paramParcel2.writeStrongBinder(paramParcel1);
          return true;
        }
      case 3:
      }
      paramParcel1.enforceInterface("com.google.android.gms.dynamite.IDynamiteLoader");
      zzd localzzd = zzd.zza.zzfd(paramParcel1.readStrongBinder());
      String str = paramParcel1.readString();
      if (paramParcel1.readInt() != 0);
      for (boolean bool = true; ; bool = false)
      {
        paramInt1 = zza(localzzd, str, bool);
        paramParcel2.writeNoException();
        paramParcel2.writeInt(paramInt1);
        return true;
      }
    }

    private static class zza
      implements zztm
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

      public int zza(zzd paramzzd, String paramString, boolean paramBoolean)
        throws RemoteException
      {
        int i = 0;
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        try
        {
          localParcel1.writeInterfaceToken("com.google.android.gms.dynamite.IDynamiteLoader");
          if (paramzzd != null);
          for (paramzzd = paramzzd.asBinder(); ; paramzzd = null)
          {
            localParcel1.writeStrongBinder(paramzzd);
            localParcel1.writeString(paramString);
            if (paramBoolean)
              i = 1;
            localParcel1.writeInt(i);
            this.zzajq.transact(3, localParcel1, localParcel2, 0);
            localParcel2.readException();
            i = localParcel2.readInt();
            return i;
          }
        }
        finally
        {
          localParcel2.recycle();
          localParcel1.recycle();
        }
        throw paramzzd;
      }

      public zzd zza(zzd paramzzd, String paramString, int paramInt)
        throws RemoteException
      {
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        try
        {
          localParcel1.writeInterfaceToken("com.google.android.gms.dynamite.IDynamiteLoader");
          if (paramzzd != null);
          for (paramzzd = paramzzd.asBinder(); ; paramzzd = null)
          {
            localParcel1.writeStrongBinder(paramzzd);
            localParcel1.writeString(paramString);
            localParcel1.writeInt(paramInt);
            this.zzajq.transact(2, localParcel1, localParcel2, 0);
            localParcel2.readException();
            paramzzd = zzd.zza.zzfd(localParcel2.readStrongBinder());
            return paramzzd;
          }
        }
        finally
        {
          localParcel2.recycle();
          localParcel1.recycle();
        }
        throw paramzzd;
      }

      public int zzf(zzd paramzzd, String paramString)
        throws RemoteException
      {
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        try
        {
          localParcel1.writeInterfaceToken("com.google.android.gms.dynamite.IDynamiteLoader");
          if (paramzzd != null);
          for (paramzzd = paramzzd.asBinder(); ; paramzzd = null)
          {
            localParcel1.writeStrongBinder(paramzzd);
            localParcel1.writeString(paramString);
            this.zzajq.transact(1, localParcel1, localParcel2, 0);
            localParcel2.readException();
            int i = localParcel2.readInt();
            return i;
          }
        }
        finally
        {
          localParcel2.recycle();
          localParcel1.recycle();
        }
        throw paramzzd;
      }
    }
  }
}

/* Location:           C:\Users\c_jealom1\Documents\Scripts\Android\Fathom_com.brynk.fathom\Fathom_com.brynk.fathom-dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.zztm
 * JD-Core Version:    0.6.0
 */
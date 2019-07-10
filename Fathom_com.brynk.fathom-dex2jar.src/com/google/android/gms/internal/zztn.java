package com.google.android.gms.internal;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.dynamic.zzd;
import com.google.android.gms.dynamic.zzd.zza;

public abstract interface zztn extends IInterface
{
  public abstract zzd zza(zzd paramzzd, String paramString, byte[] paramArrayOfByte)
    throws RemoteException;

  public static abstract class zza extends Binder
    implements zztn
  {
    public static zztn zzff(IBinder paramIBinder)
    {
      if (paramIBinder == null)
        return null;
      IInterface localIInterface = paramIBinder.queryLocalInterface("com.google.android.gms.dynamite.IDynamiteLoaderV2");
      if ((localIInterface != null) && ((localIInterface instanceof zztn)))
        return (zztn)localIInterface;
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
        paramParcel2.writeString("com.google.android.gms.dynamite.IDynamiteLoaderV2");
        return true;
      case 1:
      }
      paramParcel1.enforceInterface("com.google.android.gms.dynamite.IDynamiteLoaderV2");
      paramParcel1 = zza(zzd.zza.zzfd(paramParcel1.readStrongBinder()), paramParcel1.readString(), paramParcel1.createByteArray());
      paramParcel2.writeNoException();
      if (paramParcel1 != null);
      for (paramParcel1 = paramParcel1.asBinder(); ; paramParcel1 = null)
      {
        paramParcel2.writeStrongBinder(paramParcel1);
        return true;
      }
    }

    private static class zza
      implements zztn
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

      public zzd zza(zzd paramzzd, String paramString, byte[] paramArrayOfByte)
        throws RemoteException
      {
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        try
        {
          localParcel1.writeInterfaceToken("com.google.android.gms.dynamite.IDynamiteLoaderV2");
          if (paramzzd != null);
          for (paramzzd = paramzzd.asBinder(); ; paramzzd = null)
          {
            localParcel1.writeStrongBinder(paramzzd);
            localParcel1.writeString(paramString);
            localParcel1.writeByteArray(paramArrayOfByte);
            this.zzajq.transact(1, localParcel1, localParcel2, 0);
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
    }
  }
}

/* Location:           C:\Users\c_jealom1\Documents\Scripts\Android\Fathom_com.brynk.fathom\Fathom_com.brynk.fathom-dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.zztn
 * JD-Core Version:    0.6.0
 */
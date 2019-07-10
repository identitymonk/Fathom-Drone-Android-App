package com.google.android.gms.common.internal;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.os.RemoteException;
import com.google.android.gms.dynamic.zzd;
import com.google.android.gms.dynamic.zzd.zza;

public abstract interface zzw extends IInterface
{
  public abstract zzd zza(zzd paramzzd, int paramInt1, int paramInt2)
    throws RemoteException;

  public abstract zzd zza(zzd paramzzd, SignInButtonConfig paramSignInButtonConfig)
    throws RemoteException;

  public static abstract class zza extends Binder
    implements zzw
  {
    public static zzw zzdx(IBinder paramIBinder)
    {
      if (paramIBinder == null)
        return null;
      IInterface localIInterface = paramIBinder.queryLocalInterface("com.google.android.gms.common.internal.ISignInButtonCreator");
      if ((localIInterface != null) && ((localIInterface instanceof zzw)))
        return (zzw)localIInterface;
      return new zza(paramIBinder);
    }

    public boolean onTransact(int paramInt1, Parcel paramParcel1, Parcel paramParcel2, int paramInt2)
      throws RemoteException
    {
      Object localObject = null;
      switch (paramInt1)
      {
      default:
        return super.onTransact(paramInt1, paramParcel1, paramParcel2, paramInt2);
      case 1598968902:
        paramParcel2.writeString("com.google.android.gms.common.internal.ISignInButtonCreator");
        return true;
      case 1:
        paramParcel1.enforceInterface("com.google.android.gms.common.internal.ISignInButtonCreator");
        paramParcel1 = zza(zzd.zza.zzfd(paramParcel1.readStrongBinder()), paramParcel1.readInt(), paramParcel1.readInt());
        paramParcel2.writeNoException();
        if (paramParcel1 != null);
        for (paramParcel1 = paramParcel1.asBinder(); ; paramParcel1 = null)
        {
          paramParcel2.writeStrongBinder(paramParcel1);
          return true;
        }
      case 2:
      }
      paramParcel1.enforceInterface("com.google.android.gms.common.internal.ISignInButtonCreator");
      zzd localzzd = zzd.zza.zzfd(paramParcel1.readStrongBinder());
      if (paramParcel1.readInt() != 0);
      for (paramParcel1 = (SignInButtonConfig)SignInButtonConfig.CREATOR.createFromParcel(paramParcel1); ; paramParcel1 = null)
      {
        localzzd = zza(localzzd, paramParcel1);
        paramParcel2.writeNoException();
        paramParcel1 = localObject;
        if (localzzd != null)
          paramParcel1 = localzzd.asBinder();
        paramParcel2.writeStrongBinder(paramParcel1);
        return true;
      }
    }

    private static class zza
      implements zzw
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

      public zzd zza(zzd paramzzd, int paramInt1, int paramInt2)
        throws RemoteException
      {
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        try
        {
          localParcel1.writeInterfaceToken("com.google.android.gms.common.internal.ISignInButtonCreator");
          if (paramzzd != null);
          for (paramzzd = paramzzd.asBinder(); ; paramzzd = null)
          {
            localParcel1.writeStrongBinder(paramzzd);
            localParcel1.writeInt(paramInt1);
            localParcel1.writeInt(paramInt2);
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

      public zzd zza(zzd paramzzd, SignInButtonConfig paramSignInButtonConfig)
        throws RemoteException
      {
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        try
        {
          localParcel1.writeInterfaceToken("com.google.android.gms.common.internal.ISignInButtonCreator");
          if (paramzzd != null)
          {
            paramzzd = paramzzd.asBinder();
            localParcel1.writeStrongBinder(paramzzd);
            if (paramSignInButtonConfig == null)
              break label91;
            localParcel1.writeInt(1);
            paramSignInButtonConfig.writeToParcel(localParcel1, 0);
          }
          while (true)
          {
            this.zzajq.transact(2, localParcel1, localParcel2, 0);
            localParcel2.readException();
            paramzzd = zzd.zza.zzfd(localParcel2.readStrongBinder());
            return paramzzd;
            paramzzd = null;
            break;
            label91: localParcel1.writeInt(0);
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
 * Qualified Name:     com.google.android.gms.common.internal.zzw
 * JD-Core Version:    0.6.0
 */
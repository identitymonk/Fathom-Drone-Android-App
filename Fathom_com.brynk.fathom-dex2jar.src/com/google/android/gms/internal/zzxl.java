package com.google.android.gms.internal;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

public abstract interface zzxl extends IInterface
{
  public abstract void zza(zzxk paramzzxk, String paramString1, String paramString2)
    throws RemoteException;

  public abstract void zzb(zzxk paramzzxk, String paramString1, String paramString2)
    throws RemoteException;

  public static abstract class zza extends Binder
    implements zzxl
  {
    public static zzxl zzkt(IBinder paramIBinder)
    {
      if (paramIBinder == null)
        return null;
      IInterface localIInterface = paramIBinder.queryLocalInterface("com.google.android.gms.search.internal.ISearchAuthService");
      if ((localIInterface != null) && ((localIInterface instanceof zzxl)))
        return (zzxl)localIInterface;
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
        paramParcel2.writeString("com.google.android.gms.search.internal.ISearchAuthService");
        return true;
      case 1:
        paramParcel1.enforceInterface("com.google.android.gms.search.internal.ISearchAuthService");
        zza(zzxk.zza.zzks(paramParcel1.readStrongBinder()), paramParcel1.readString(), paramParcel1.readString());
        paramParcel2.writeNoException();
        return true;
      case 2:
      }
      paramParcel1.enforceInterface("com.google.android.gms.search.internal.ISearchAuthService");
      zzb(zzxk.zza.zzks(paramParcel1.readStrongBinder()), paramParcel1.readString(), paramParcel1.readString());
      paramParcel2.writeNoException();
      return true;
    }

    private static class zza
      implements zzxl
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

      public void zza(zzxk paramzzxk, String paramString1, String paramString2)
        throws RemoteException
      {
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        try
        {
          localParcel1.writeInterfaceToken("com.google.android.gms.search.internal.ISearchAuthService");
          if (paramzzxk != null);
          for (paramzzxk = paramzzxk.asBinder(); ; paramzzxk = null)
          {
            localParcel1.writeStrongBinder(paramzzxk);
            localParcel1.writeString(paramString1);
            localParcel1.writeString(paramString2);
            this.zzajq.transact(1, localParcel1, localParcel2, 0);
            localParcel2.readException();
            return;
          }
        }
        finally
        {
          localParcel2.recycle();
          localParcel1.recycle();
        }
        throw paramzzxk;
      }

      public void zzb(zzxk paramzzxk, String paramString1, String paramString2)
        throws RemoteException
      {
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        try
        {
          localParcel1.writeInterfaceToken("com.google.android.gms.search.internal.ISearchAuthService");
          if (paramzzxk != null);
          for (paramzzxk = paramzzxk.asBinder(); ; paramzzxk = null)
          {
            localParcel1.writeStrongBinder(paramzzxk);
            localParcel1.writeString(paramString1);
            localParcel1.writeString(paramString2);
            this.zzajq.transact(2, localParcel1, localParcel2, 0);
            localParcel2.readException();
            return;
          }
        }
        finally
        {
          localParcel2.recycle();
          localParcel1.recycle();
        }
        throw paramzzxk;
      }
    }
  }
}

/* Location:           C:\Users\c_jealom1\Documents\Scripts\Android\Fathom_com.brynk.fathom\Fathom_com.brynk.fathom-dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.zzxl
 * JD-Core Version:    0.6.0
 */
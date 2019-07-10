package com.google.android.gms.internal;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.os.RemoteException;
import com.google.android.gms.appdatasearch.GetRecentContextCall.Request;
import com.google.android.gms.appdatasearch.UsageInfo;
import com.google.firebase.appindexing.internal.ActionImpl;

public abstract interface zznf extends IInterface
{
  public abstract void zza(GetRecentContextCall.Request paramRequest, zzng paramzzng)
    throws RemoteException;

  public abstract void zza(zzng paramzzng)
    throws RemoteException;

  public abstract void zza(zzng paramzzng, String paramString1, String paramString2)
    throws RemoteException;

  public abstract void zza(zzng paramzzng, String paramString, UsageInfo[] paramArrayOfUsageInfo)
    throws RemoteException;

  public abstract void zza(zzng paramzzng, boolean paramBoolean)
    throws RemoteException;

  public abstract void zza(zzng paramzzng, ActionImpl[] paramArrayOfActionImpl)
    throws RemoteException;

  public abstract void zzb(zzng paramzzng)
    throws RemoteException;

  public static abstract class zza extends Binder
    implements zznf
  {
    public static zznf zzbn(IBinder paramIBinder)
    {
      if (paramIBinder == null)
        return null;
      IInterface localIInterface = paramIBinder.queryLocalInterface("com.google.android.gms.appdatasearch.internal.ILightweightAppDataSearch");
      if ((localIInterface != null) && ((localIInterface instanceof zznf)))
        return (zznf)localIInterface;
      return new zza(paramIBinder);
    }

    public boolean onTransact(int paramInt1, Parcel paramParcel1, Parcel paramParcel2, int paramInt2)
      throws RemoteException
    {
      Object localObject;
      switch (paramInt1)
      {
      default:
        return super.onTransact(paramInt1, paramParcel1, paramParcel2, paramInt2);
      case 1598968902:
        paramParcel2.writeString("com.google.android.gms.appdatasearch.internal.ILightweightAppDataSearch");
        return true;
      case 1:
        paramParcel1.enforceInterface("com.google.android.gms.appdatasearch.internal.ILightweightAppDataSearch");
        zza(zzng.zza.zzbo(paramParcel1.readStrongBinder()), paramParcel1.readString(), (UsageInfo[])paramParcel1.createTypedArray(UsageInfo.CREATOR));
        paramParcel2.writeNoException();
        return true;
      case 2:
        paramParcel1.enforceInterface("com.google.android.gms.appdatasearch.internal.ILightweightAppDataSearch");
        zza(zzng.zza.zzbo(paramParcel1.readStrongBinder()));
        paramParcel2.writeNoException();
        return true;
      case 3:
        paramParcel1.enforceInterface("com.google.android.gms.appdatasearch.internal.ILightweightAppDataSearch");
        zzb(zzng.zza.zzbo(paramParcel1.readStrongBinder()));
        paramParcel2.writeNoException();
        return true;
      case 4:
        paramParcel1.enforceInterface("com.google.android.gms.appdatasearch.internal.ILightweightAppDataSearch");
        localObject = zzng.zza.zzbo(paramParcel1.readStrongBinder());
        if (paramParcel1.readInt() != 0);
        for (boolean bool = true; ; bool = false)
        {
          zza((zzng)localObject, bool);
          paramParcel2.writeNoException();
          return true;
        }
      case 5:
        paramParcel1.enforceInterface("com.google.android.gms.appdatasearch.internal.ILightweightAppDataSearch");
        if (paramParcel1.readInt() != 0);
        for (localObject = (GetRecentContextCall.Request)GetRecentContextCall.Request.CREATOR.createFromParcel(paramParcel1); ; localObject = null)
        {
          zza((GetRecentContextCall.Request)localObject, zzng.zza.zzbo(paramParcel1.readStrongBinder()));
          paramParcel2.writeNoException();
          return true;
        }
      case 6:
        paramParcel1.enforceInterface("com.google.android.gms.appdatasearch.internal.ILightweightAppDataSearch");
        zza(zzng.zza.zzbo(paramParcel1.readStrongBinder()), paramParcel1.readString(), paramParcel1.readString());
        paramParcel2.writeNoException();
        return true;
      case 7:
      }
      paramParcel1.enforceInterface("com.google.android.gms.appdatasearch.internal.ILightweightAppDataSearch");
      zza(zzng.zza.zzbo(paramParcel1.readStrongBinder()), (ActionImpl[])paramParcel1.createTypedArray(ActionImpl.CREATOR));
      paramParcel2.writeNoException();
      return true;
    }

    private static class zza
      implements zznf
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

      public void zza(GetRecentContextCall.Request paramRequest, zzng paramzzng)
        throws RemoteException
      {
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        while (true)
        {
          try
          {
            localParcel1.writeInterfaceToken("com.google.android.gms.appdatasearch.internal.ILightweightAppDataSearch");
            if (paramRequest == null)
              continue;
            localParcel1.writeInt(1);
            paramRequest.writeToParcel(localParcel1, 0);
            if (paramzzng != null)
            {
              paramRequest = paramzzng.asBinder();
              localParcel1.writeStrongBinder(paramRequest);
              this.zzajq.transact(5, localParcel1, localParcel2, 0);
              localParcel2.readException();
              return;
              localParcel1.writeInt(0);
              continue;
            }
          }
          finally
          {
            localParcel2.recycle();
            localParcel1.recycle();
          }
          paramRequest = null;
        }
      }

      public void zza(zzng paramzzng)
        throws RemoteException
      {
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        try
        {
          localParcel1.writeInterfaceToken("com.google.android.gms.appdatasearch.internal.ILightweightAppDataSearch");
          if (paramzzng != null);
          for (paramzzng = paramzzng.asBinder(); ; paramzzng = null)
          {
            localParcel1.writeStrongBinder(paramzzng);
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
        throw paramzzng;
      }

      public void zza(zzng paramzzng, String paramString1, String paramString2)
        throws RemoteException
      {
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        try
        {
          localParcel1.writeInterfaceToken("com.google.android.gms.appdatasearch.internal.ILightweightAppDataSearch");
          if (paramzzng != null);
          for (paramzzng = paramzzng.asBinder(); ; paramzzng = null)
          {
            localParcel1.writeStrongBinder(paramzzng);
            localParcel1.writeString(paramString1);
            localParcel1.writeString(paramString2);
            this.zzajq.transact(6, localParcel1, localParcel2, 0);
            localParcel2.readException();
            return;
          }
        }
        finally
        {
          localParcel2.recycle();
          localParcel1.recycle();
        }
        throw paramzzng;
      }

      public void zza(zzng paramzzng, String paramString, UsageInfo[] paramArrayOfUsageInfo)
        throws RemoteException
      {
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        try
        {
          localParcel1.writeInterfaceToken("com.google.android.gms.appdatasearch.internal.ILightweightAppDataSearch");
          if (paramzzng != null);
          for (paramzzng = paramzzng.asBinder(); ; paramzzng = null)
          {
            localParcel1.writeStrongBinder(paramzzng);
            localParcel1.writeString(paramString);
            localParcel1.writeTypedArray(paramArrayOfUsageInfo, 0);
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
        throw paramzzng;
      }

      public void zza(zzng paramzzng, boolean paramBoolean)
        throws RemoteException
      {
        int i = 0;
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        try
        {
          localParcel1.writeInterfaceToken("com.google.android.gms.appdatasearch.internal.ILightweightAppDataSearch");
          if (paramzzng != null);
          for (paramzzng = paramzzng.asBinder(); ; paramzzng = null)
          {
            localParcel1.writeStrongBinder(paramzzng);
            if (paramBoolean)
              i = 1;
            localParcel1.writeInt(i);
            this.zzajq.transact(4, localParcel1, localParcel2, 0);
            localParcel2.readException();
            return;
          }
        }
        finally
        {
          localParcel2.recycle();
          localParcel1.recycle();
        }
        throw paramzzng;
      }

      public void zza(zzng paramzzng, ActionImpl[] paramArrayOfActionImpl)
        throws RemoteException
      {
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        try
        {
          localParcel1.writeInterfaceToken("com.google.android.gms.appdatasearch.internal.ILightweightAppDataSearch");
          if (paramzzng != null);
          for (paramzzng = paramzzng.asBinder(); ; paramzzng = null)
          {
            localParcel1.writeStrongBinder(paramzzng);
            localParcel1.writeTypedArray(paramArrayOfActionImpl, 0);
            this.zzajq.transact(7, localParcel1, localParcel2, 0);
            localParcel2.readException();
            return;
          }
        }
        finally
        {
          localParcel2.recycle();
          localParcel1.recycle();
        }
        throw paramzzng;
      }

      public void zzb(zzng paramzzng)
        throws RemoteException
      {
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        try
        {
          localParcel1.writeInterfaceToken("com.google.android.gms.appdatasearch.internal.ILightweightAppDataSearch");
          if (paramzzng != null);
          for (paramzzng = paramzzng.asBinder(); ; paramzzng = null)
          {
            localParcel1.writeStrongBinder(paramzzng);
            this.zzajq.transact(3, localParcel1, localParcel2, 0);
            localParcel2.readException();
            return;
          }
        }
        finally
        {
          localParcel2.recycle();
          localParcel1.recycle();
        }
        throw paramzzng;
      }
    }
  }
}

/* Location:           C:\Users\c_jealom1\Documents\Scripts\Android\Fathom_com.brynk.fathom\Fathom_com.brynk.fathom-dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.zznf
 * JD-Core Version:    0.6.0
 */
package com.google.firebase.appindexing.internal;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.os.RemoteException;
import com.google.android.gms.internal.zzrl;
import com.google.android.gms.internal.zzrl.zza;

public abstract interface zzf extends IInterface
{
  public abstract void zza(zzrl paramzzrl, UpdateTagsRequest paramUpdateTagsRequest)
    throws RemoteException;

  public abstract void zza(zzrl paramzzrl, Thing[] paramArrayOfThing)
    throws RemoteException;

  public abstract void zza(zzrl paramzzrl, String[] paramArrayOfString)
    throws RemoteException;

  public abstract void zze(zzrl paramzzrl)
    throws RemoteException;

  public static abstract class zza extends Binder
    implements zzf
  {
    public static zzf zzlz(IBinder paramIBinder)
    {
      if (paramIBinder == null)
        return null;
      IInterface localIInterface = paramIBinder.queryLocalInterface("com.google.firebase.appindexing.internal.IAppIndexingService");
      if ((localIInterface != null) && ((localIInterface instanceof zzf)))
        return (zzf)localIInterface;
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
        paramParcel2.writeString("com.google.firebase.appindexing.internal.IAppIndexingService");
        return true;
      case 1:
        paramParcel1.enforceInterface("com.google.firebase.appindexing.internal.IAppIndexingService");
        zza(zzrl.zza.zzdp(paramParcel1.readStrongBinder()), (Thing[])paramParcel1.createTypedArray(Thing.CREATOR));
        paramParcel2.writeNoException();
        return true;
      case 2:
        paramParcel1.enforceInterface("com.google.firebase.appindexing.internal.IAppIndexingService");
        zza(zzrl.zza.zzdp(paramParcel1.readStrongBinder()), paramParcel1.createStringArray());
        paramParcel2.writeNoException();
        return true;
      case 3:
        paramParcel1.enforceInterface("com.google.firebase.appindexing.internal.IAppIndexingService");
        zze(zzrl.zza.zzdp(paramParcel1.readStrongBinder()));
        paramParcel2.writeNoException();
        return true;
      case 4:
      }
      paramParcel1.enforceInterface("com.google.firebase.appindexing.internal.IAppIndexingService");
      zzrl localzzrl = zzrl.zza.zzdp(paramParcel1.readStrongBinder());
      if (paramParcel1.readInt() != 0);
      for (paramParcel1 = (UpdateTagsRequest)UpdateTagsRequest.CREATOR.createFromParcel(paramParcel1); ; paramParcel1 = null)
      {
        zza(localzzrl, paramParcel1);
        paramParcel2.writeNoException();
        return true;
      }
    }

    private static class zza
      implements zzf
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

      public void zza(zzrl paramzzrl, UpdateTagsRequest paramUpdateTagsRequest)
        throws RemoteException
      {
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        try
        {
          localParcel1.writeInterfaceToken("com.google.firebase.appindexing.internal.IAppIndexingService");
          if (paramzzrl != null)
          {
            paramzzrl = paramzzrl.asBinder();
            localParcel1.writeStrongBinder(paramzzrl);
            if (paramUpdateTagsRequest == null)
              break label81;
            localParcel1.writeInt(1);
            paramUpdateTagsRequest.writeToParcel(localParcel1, 0);
          }
          while (true)
          {
            this.zzajq.transact(4, localParcel1, localParcel2, 0);
            localParcel2.readException();
            return;
            paramzzrl = null;
            break;
            label81: localParcel1.writeInt(0);
          }
        }
        finally
        {
          localParcel2.recycle();
          localParcel1.recycle();
        }
        throw paramzzrl;
      }

      public void zza(zzrl paramzzrl, Thing[] paramArrayOfThing)
        throws RemoteException
      {
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        try
        {
          localParcel1.writeInterfaceToken("com.google.firebase.appindexing.internal.IAppIndexingService");
          if (paramzzrl != null);
          for (paramzzrl = paramzzrl.asBinder(); ; paramzzrl = null)
          {
            localParcel1.writeStrongBinder(paramzzrl);
            localParcel1.writeTypedArray(paramArrayOfThing, 0);
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
        throw paramzzrl;
      }

      public void zza(zzrl paramzzrl, String[] paramArrayOfString)
        throws RemoteException
      {
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        try
        {
          localParcel1.writeInterfaceToken("com.google.firebase.appindexing.internal.IAppIndexingService");
          if (paramzzrl != null);
          for (paramzzrl = paramzzrl.asBinder(); ; paramzzrl = null)
          {
            localParcel1.writeStrongBinder(paramzzrl);
            localParcel1.writeStringArray(paramArrayOfString);
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
        throw paramzzrl;
      }

      public void zze(zzrl paramzzrl)
        throws RemoteException
      {
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        try
        {
          localParcel1.writeInterfaceToken("com.google.firebase.appindexing.internal.IAppIndexingService");
          if (paramzzrl != null);
          for (paramzzrl = paramzzrl.asBinder(); ; paramzzrl = null)
          {
            localParcel1.writeStrongBinder(paramzzrl);
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
        throw paramzzrl;
      }
    }
  }
}

/* Location:           C:\Users\c_jealom1\Documents\Scripts\Android\Fathom_com.brynk.fathom\Fathom_com.brynk.fathom-dex2jar.jar
 * Qualified Name:     com.google.firebase.appindexing.internal.zzf
 * JD-Core Version:    0.6.0
 */
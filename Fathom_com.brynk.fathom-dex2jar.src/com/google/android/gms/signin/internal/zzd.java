package com.google.android.gms.signin.internal;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.os.RemoteException;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.Status;

public abstract interface zzd extends IInterface
{
  public abstract void zza(ConnectionResult paramConnectionResult, AuthAccountResult paramAuthAccountResult)
    throws RemoteException;

  public abstract void zza(Status paramStatus, GoogleSignInAccount paramGoogleSignInAccount)
    throws RemoteException;

  public abstract void zzb(SignInResponse paramSignInResponse)
    throws RemoteException;

  public abstract void zzej(Status paramStatus)
    throws RemoteException;

  public abstract void zzek(Status paramStatus)
    throws RemoteException;

  public static abstract class zza extends Binder
    implements zzd
  {
    public zza()
    {
      attachInterface(this, "com.google.android.gms.signin.internal.ISignInCallbacks");
    }

    public static zzd zzkv(IBinder paramIBinder)
    {
      if (paramIBinder == null)
        return null;
      IInterface localIInterface = paramIBinder.queryLocalInterface("com.google.android.gms.signin.internal.ISignInCallbacks");
      if ((localIInterface != null) && ((localIInterface instanceof zzd)))
        return (zzd)localIInterface;
      return new zza(paramIBinder);
    }

    public IBinder asBinder()
    {
      return this;
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
        paramParcel2.writeString("com.google.android.gms.signin.internal.ISignInCallbacks");
        return true;
      case 3:
        paramParcel1.enforceInterface("com.google.android.gms.signin.internal.ISignInCallbacks");
        if (paramParcel1.readInt() != 0)
        {
          localObject = (ConnectionResult)ConnectionResult.CREATOR.createFromParcel(paramParcel1);
          if (paramParcel1.readInt() == 0)
            break label144;
        }
        for (paramParcel1 = (AuthAccountResult)AuthAccountResult.CREATOR.createFromParcel(paramParcel1); ; paramParcel1 = null)
        {
          zza((ConnectionResult)localObject, paramParcel1);
          paramParcel2.writeNoException();
          return true;
          localObject = null;
          break;
        }
      case 4:
        paramParcel1.enforceInterface("com.google.android.gms.signin.internal.ISignInCallbacks");
        if (paramParcel1.readInt() != 0);
        for (paramParcel1 = (Status)Status.CREATOR.createFromParcel(paramParcel1); ; paramParcel1 = null)
        {
          zzej(paramParcel1);
          paramParcel2.writeNoException();
          return true;
        }
      case 6:
        paramParcel1.enforceInterface("com.google.android.gms.signin.internal.ISignInCallbacks");
        if (paramParcel1.readInt() != 0);
        for (paramParcel1 = (Status)Status.CREATOR.createFromParcel(paramParcel1); ; paramParcel1 = null)
        {
          zzek(paramParcel1);
          paramParcel2.writeNoException();
          return true;
        }
      case 7:
        label144: paramParcel1.enforceInterface("com.google.android.gms.signin.internal.ISignInCallbacks");
        if (paramParcel1.readInt() != 0)
        {
          localObject = (Status)Status.CREATOR.createFromParcel(paramParcel1);
          if (paramParcel1.readInt() == 0)
            break label299;
        }
        label299: for (paramParcel1 = (GoogleSignInAccount)GoogleSignInAccount.CREATOR.createFromParcel(paramParcel1); ; paramParcel1 = null)
        {
          zza((Status)localObject, paramParcel1);
          paramParcel2.writeNoException();
          return true;
          localObject = null;
          break;
        }
      case 8:
      }
      paramParcel1.enforceInterface("com.google.android.gms.signin.internal.ISignInCallbacks");
      if (paramParcel1.readInt() != 0);
      for (paramParcel1 = (SignInResponse)SignInResponse.CREATOR.createFromParcel(paramParcel1); ; paramParcel1 = null)
      {
        zzb(paramParcel1);
        paramParcel2.writeNoException();
        return true;
      }
    }

    private static class zza
      implements zzd
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

      public void zza(ConnectionResult paramConnectionResult, AuthAccountResult paramAuthAccountResult)
        throws RemoteException
      {
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        while (true)
        {
          try
          {
            localParcel1.writeInterfaceToken("com.google.android.gms.signin.internal.ISignInCallbacks");
            if (paramConnectionResult == null)
              continue;
            localParcel1.writeInt(1);
            paramConnectionResult.writeToParcel(localParcel1, 0);
            if (paramAuthAccountResult != null)
            {
              localParcel1.writeInt(1);
              paramAuthAccountResult.writeToParcel(localParcel1, 0);
              this.zzajq.transact(3, localParcel1, localParcel2, 0);
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
          localParcel1.writeInt(0);
        }
      }

      public void zza(Status paramStatus, GoogleSignInAccount paramGoogleSignInAccount)
        throws RemoteException
      {
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        while (true)
        {
          try
          {
            localParcel1.writeInterfaceToken("com.google.android.gms.signin.internal.ISignInCallbacks");
            if (paramStatus == null)
              continue;
            localParcel1.writeInt(1);
            paramStatus.writeToParcel(localParcel1, 0);
            if (paramGoogleSignInAccount != null)
            {
              localParcel1.writeInt(1);
              paramGoogleSignInAccount.writeToParcel(localParcel1, 0);
              this.zzajq.transact(7, localParcel1, localParcel2, 0);
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
          localParcel1.writeInt(0);
        }
      }

      public void zzb(SignInResponse paramSignInResponse)
        throws RemoteException
      {
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        try
        {
          localParcel1.writeInterfaceToken("com.google.android.gms.signin.internal.ISignInCallbacks");
          if (paramSignInResponse != null)
          {
            localParcel1.writeInt(1);
            paramSignInResponse.writeToParcel(localParcel1, 0);
          }
          while (true)
          {
            this.zzajq.transact(8, localParcel1, localParcel2, 0);
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
        throw paramSignInResponse;
      }

      public void zzej(Status paramStatus)
        throws RemoteException
      {
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        try
        {
          localParcel1.writeInterfaceToken("com.google.android.gms.signin.internal.ISignInCallbacks");
          if (paramStatus != null)
          {
            localParcel1.writeInt(1);
            paramStatus.writeToParcel(localParcel1, 0);
          }
          while (true)
          {
            this.zzajq.transact(4, localParcel1, localParcel2, 0);
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
        throw paramStatus;
      }

      public void zzek(Status paramStatus)
        throws RemoteException
      {
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        try
        {
          localParcel1.writeInterfaceToken("com.google.android.gms.signin.internal.ISignInCallbacks");
          if (paramStatus != null)
          {
            localParcel1.writeInt(1);
            paramStatus.writeToParcel(localParcel1, 0);
          }
          while (true)
          {
            this.zzajq.transact(6, localParcel1, localParcel2, 0);
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
        throw paramStatus;
      }
    }
  }
}

/* Location:           C:\Users\c_jealom1\Documents\Scripts\Android\Fathom_com.brynk.fathom\Fathom_com.brynk.fathom-dex2jar.jar
 * Qualified Name:     com.google.android.gms.signin.internal.zzd
 * JD-Core Version:    0.6.0
 */
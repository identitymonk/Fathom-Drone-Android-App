package com.google.android.gms.signin.internal;

import android.accounts.Account;
import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.os.RemoteException;
import com.google.android.gms.common.internal.AuthAccountRequest;
import com.google.android.gms.common.internal.ResolveAccountRequest;
import com.google.android.gms.common.internal.zzp;
import com.google.android.gms.common.internal.zzp.zza;
import com.google.android.gms.common.internal.zzv;
import com.google.android.gms.common.internal.zzv.zza;

public abstract interface zze extends IInterface
{
  public abstract void zza(int paramInt, Account paramAccount, zzd paramzzd)
    throws RemoteException;

  public abstract void zza(AuthAccountRequest paramAuthAccountRequest, zzd paramzzd)
    throws RemoteException;

  public abstract void zza(ResolveAccountRequest paramResolveAccountRequest, zzv paramzzv)
    throws RemoteException;

  public abstract void zza(zzp paramzzp, int paramInt, boolean paramBoolean)
    throws RemoteException;

  public abstract void zza(CheckServerAuthResult paramCheckServerAuthResult)
    throws RemoteException;

  public abstract void zza(RecordConsentRequest paramRecordConsentRequest, zzd paramzzd)
    throws RemoteException;

  public abstract void zza(SignInRequest paramSignInRequest, zzd paramzzd)
    throws RemoteException;

  public abstract void zzb(zzd paramzzd)
    throws RemoteException;

  public abstract void zzcl(boolean paramBoolean)
    throws RemoteException;

  public abstract void zzzv(int paramInt)
    throws RemoteException;

  public static abstract class zza extends Binder
    implements zze
  {
    public static zze zzkw(IBinder paramIBinder)
    {
      if (paramIBinder == null)
        return null;
      IInterface localIInterface = paramIBinder.queryLocalInterface("com.google.android.gms.signin.internal.ISignInService");
      if ((localIInterface != null) && ((localIInterface instanceof zze)))
        return (zze)localIInterface;
      return new zza(paramIBinder);
    }

    public boolean onTransact(int paramInt1, Parcel paramParcel1, Parcel paramParcel2, int paramInt2)
      throws RemoteException
    {
      boolean bool = false;
      Object localObject2 = null;
      Object localObject3 = null;
      Object localObject4 = null;
      Object localObject5 = null;
      Object localObject6 = null;
      Object localObject1 = null;
      switch (paramInt1)
      {
      default:
        return super.onTransact(paramInt1, paramParcel1, paramParcel2, paramInt2);
      case 1598968902:
        paramParcel2.writeString("com.google.android.gms.signin.internal.ISignInService");
        return true;
      case 2:
        paramParcel1.enforceInterface("com.google.android.gms.signin.internal.ISignInService");
        if (paramParcel1.readInt() != 0)
          localObject1 = (AuthAccountRequest)AuthAccountRequest.CREATOR.createFromParcel(paramParcel1);
        zza((AuthAccountRequest)localObject1, zzd.zza.zzkv(paramParcel1.readStrongBinder()));
        paramParcel2.writeNoException();
        return true;
      case 3:
        paramParcel1.enforceInterface("com.google.android.gms.signin.internal.ISignInService");
        localObject1 = localObject2;
        if (paramParcel1.readInt() != 0)
          localObject1 = (CheckServerAuthResult)CheckServerAuthResult.CREATOR.createFromParcel(paramParcel1);
        zza((CheckServerAuthResult)localObject1);
        paramParcel2.writeNoException();
        return true;
      case 4:
        paramParcel1.enforceInterface("com.google.android.gms.signin.internal.ISignInService");
        if (paramParcel1.readInt() != 0);
        for (bool = true; ; bool = false)
        {
          zzcl(bool);
          paramParcel2.writeNoException();
          return true;
        }
      case 5:
        paramParcel1.enforceInterface("com.google.android.gms.signin.internal.ISignInService");
        localObject1 = localObject3;
        if (paramParcel1.readInt() != 0)
          localObject1 = (ResolveAccountRequest)ResolveAccountRequest.CREATOR.createFromParcel(paramParcel1);
        zza((ResolveAccountRequest)localObject1, zzv.zza.zzdw(paramParcel1.readStrongBinder()));
        paramParcel2.writeNoException();
        return true;
      case 7:
        paramParcel1.enforceInterface("com.google.android.gms.signin.internal.ISignInService");
        zzzv(paramParcel1.readInt());
        paramParcel2.writeNoException();
        return true;
      case 8:
        paramParcel1.enforceInterface("com.google.android.gms.signin.internal.ISignInService");
        paramInt1 = paramParcel1.readInt();
        localObject1 = localObject4;
        if (paramParcel1.readInt() != 0)
          localObject1 = (Account)Account.CREATOR.createFromParcel(paramParcel1);
        zza(paramInt1, (Account)localObject1, zzd.zza.zzkv(paramParcel1.readStrongBinder()));
        paramParcel2.writeNoException();
        return true;
      case 9:
        paramParcel1.enforceInterface("com.google.android.gms.signin.internal.ISignInService");
        localObject1 = zzp.zza.zzdr(paramParcel1.readStrongBinder());
        paramInt1 = paramParcel1.readInt();
        if (paramParcel1.readInt() != 0)
          bool = true;
        zza((zzp)localObject1, paramInt1, bool);
        paramParcel2.writeNoException();
        return true;
      case 10:
        paramParcel1.enforceInterface("com.google.android.gms.signin.internal.ISignInService");
        localObject1 = localObject5;
        if (paramParcel1.readInt() != 0)
          localObject1 = (RecordConsentRequest)RecordConsentRequest.CREATOR.createFromParcel(paramParcel1);
        zza((RecordConsentRequest)localObject1, zzd.zza.zzkv(paramParcel1.readStrongBinder()));
        paramParcel2.writeNoException();
        return true;
      case 11:
        paramParcel1.enforceInterface("com.google.android.gms.signin.internal.ISignInService");
        zzb(zzd.zza.zzkv(paramParcel1.readStrongBinder()));
        paramParcel2.writeNoException();
        return true;
      case 12:
      }
      paramParcel1.enforceInterface("com.google.android.gms.signin.internal.ISignInService");
      localObject1 = localObject6;
      if (paramParcel1.readInt() != 0)
        localObject1 = (SignInRequest)SignInRequest.CREATOR.createFromParcel(paramParcel1);
      zza((SignInRequest)localObject1, zzd.zza.zzkv(paramParcel1.readStrongBinder()));
      paramParcel2.writeNoException();
      return true;
    }

    private static class zza
      implements zze
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

      public void zza(int paramInt, Account paramAccount, zzd paramzzd)
        throws RemoteException
      {
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        while (true)
        {
          try
          {
            localParcel1.writeInterfaceToken("com.google.android.gms.signin.internal.ISignInService");
            localParcel1.writeInt(paramInt);
            if (paramAccount == null)
              continue;
            localParcel1.writeInt(1);
            paramAccount.writeToParcel(localParcel1, 0);
            if (paramzzd != null)
            {
              paramAccount = paramzzd.asBinder();
              localParcel1.writeStrongBinder(paramAccount);
              this.zzajq.transact(8, localParcel1, localParcel2, 0);
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
          paramAccount = null;
        }
      }

      public void zza(AuthAccountRequest paramAuthAccountRequest, zzd paramzzd)
        throws RemoteException
      {
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        while (true)
        {
          try
          {
            localParcel1.writeInterfaceToken("com.google.android.gms.signin.internal.ISignInService");
            if (paramAuthAccountRequest == null)
              continue;
            localParcel1.writeInt(1);
            paramAuthAccountRequest.writeToParcel(localParcel1, 0);
            if (paramzzd != null)
            {
              paramAuthAccountRequest = paramzzd.asBinder();
              localParcel1.writeStrongBinder(paramAuthAccountRequest);
              this.zzajq.transact(2, localParcel1, localParcel2, 0);
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
          paramAuthAccountRequest = null;
        }
      }

      public void zza(ResolveAccountRequest paramResolveAccountRequest, zzv paramzzv)
        throws RemoteException
      {
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        while (true)
        {
          try
          {
            localParcel1.writeInterfaceToken("com.google.android.gms.signin.internal.ISignInService");
            if (paramResolveAccountRequest == null)
              continue;
            localParcel1.writeInt(1);
            paramResolveAccountRequest.writeToParcel(localParcel1, 0);
            if (paramzzv != null)
            {
              paramResolveAccountRequest = paramzzv.asBinder();
              localParcel1.writeStrongBinder(paramResolveAccountRequest);
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
          paramResolveAccountRequest = null;
        }
      }

      public void zza(zzp paramzzp, int paramInt, boolean paramBoolean)
        throws RemoteException
      {
        int i = 0;
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        try
        {
          localParcel1.writeInterfaceToken("com.google.android.gms.signin.internal.ISignInService");
          if (paramzzp != null);
          for (paramzzp = paramzzp.asBinder(); ; paramzzp = null)
          {
            localParcel1.writeStrongBinder(paramzzp);
            localParcel1.writeInt(paramInt);
            paramInt = i;
            if (paramBoolean)
              paramInt = 1;
            localParcel1.writeInt(paramInt);
            this.zzajq.transact(9, localParcel1, localParcel2, 0);
            localParcel2.readException();
            return;
          }
        }
        finally
        {
          localParcel2.recycle();
          localParcel1.recycle();
        }
        throw paramzzp;
      }

      public void zza(CheckServerAuthResult paramCheckServerAuthResult)
        throws RemoteException
      {
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        try
        {
          localParcel1.writeInterfaceToken("com.google.android.gms.signin.internal.ISignInService");
          if (paramCheckServerAuthResult != null)
          {
            localParcel1.writeInt(1);
            paramCheckServerAuthResult.writeToParcel(localParcel1, 0);
          }
          while (true)
          {
            this.zzajq.transact(3, localParcel1, localParcel2, 0);
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
        throw paramCheckServerAuthResult;
      }

      public void zza(RecordConsentRequest paramRecordConsentRequest, zzd paramzzd)
        throws RemoteException
      {
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        while (true)
        {
          try
          {
            localParcel1.writeInterfaceToken("com.google.android.gms.signin.internal.ISignInService");
            if (paramRecordConsentRequest == null)
              continue;
            localParcel1.writeInt(1);
            paramRecordConsentRequest.writeToParcel(localParcel1, 0);
            if (paramzzd != null)
            {
              paramRecordConsentRequest = paramzzd.asBinder();
              localParcel1.writeStrongBinder(paramRecordConsentRequest);
              this.zzajq.transact(10, localParcel1, localParcel2, 0);
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
          paramRecordConsentRequest = null;
        }
      }

      public void zza(SignInRequest paramSignInRequest, zzd paramzzd)
        throws RemoteException
      {
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        while (true)
        {
          try
          {
            localParcel1.writeInterfaceToken("com.google.android.gms.signin.internal.ISignInService");
            if (paramSignInRequest == null)
              continue;
            localParcel1.writeInt(1);
            paramSignInRequest.writeToParcel(localParcel1, 0);
            if (paramzzd != null)
            {
              paramSignInRequest = paramzzd.asBinder();
              localParcel1.writeStrongBinder(paramSignInRequest);
              this.zzajq.transact(12, localParcel1, localParcel2, 0);
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
          paramSignInRequest = null;
        }
      }

      public void zzb(zzd paramzzd)
        throws RemoteException
      {
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        try
        {
          localParcel1.writeInterfaceToken("com.google.android.gms.signin.internal.ISignInService");
          if (paramzzd != null);
          for (paramzzd = paramzzd.asBinder(); ; paramzzd = null)
          {
            localParcel1.writeStrongBinder(paramzzd);
            this.zzajq.transact(11, localParcel1, localParcel2, 0);
            localParcel2.readException();
            return;
          }
        }
        finally
        {
          localParcel2.recycle();
          localParcel1.recycle();
        }
        throw paramzzd;
      }

      public void zzcl(boolean paramBoolean)
        throws RemoteException
      {
        int i = 0;
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        try
        {
          localParcel1.writeInterfaceToken("com.google.android.gms.signin.internal.ISignInService");
          if (paramBoolean)
            i = 1;
          localParcel1.writeInt(i);
          this.zzajq.transact(4, localParcel1, localParcel2, 0);
          localParcel2.readException();
          return;
        }
        finally
        {
          localParcel2.recycle();
          localParcel1.recycle();
        }
        throw localObject;
      }

      public void zzzv(int paramInt)
        throws RemoteException
      {
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        try
        {
          localParcel1.writeInterfaceToken("com.google.android.gms.signin.internal.ISignInService");
          localParcel1.writeInt(paramInt);
          this.zzajq.transact(7, localParcel1, localParcel2, 0);
          localParcel2.readException();
          return;
        }
        finally
        {
          localParcel2.recycle();
          localParcel1.recycle();
        }
        throw localObject;
      }
    }
  }
}

/* Location:           C:\Users\c_jealom1\Documents\Scripts\Android\Fathom_com.brynk.fathom\Fathom_com.brynk.fathom-dex2jar.jar
 * Qualified Name:     com.google.android.gms.signin.internal.zze
 * JD-Core Version:    0.6.0
 */
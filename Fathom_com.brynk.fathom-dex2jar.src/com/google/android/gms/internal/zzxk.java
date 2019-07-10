package com.google.android.gms.internal;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.os.RemoteException;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.search.GoogleNowAuthState;

public abstract interface zzxk extends IInterface
{
  public abstract void zza(Status paramStatus, GoogleNowAuthState paramGoogleNowAuthState)
    throws RemoteException;

  public abstract void zzeh(Status paramStatus)
    throws RemoteException;

  public static abstract class zza extends Binder
    implements zzxk
  {
    public zza()
    {
      attachInterface(this, "com.google.android.gms.search.internal.ISearchAuthCallbacks");
    }

    public static zzxk zzks(IBinder paramIBinder)
    {
      if (paramIBinder == null)
        return null;
      IInterface localIInterface = paramIBinder.queryLocalInterface("com.google.android.gms.search.internal.ISearchAuthCallbacks");
      if ((localIInterface != null) && ((localIInterface instanceof zzxk)))
        return (zzxk)localIInterface;
      return new zza(paramIBinder);
    }

    public IBinder asBinder()
    {
      return this;
    }

    public boolean onTransact(int paramInt1, Parcel paramParcel1, Parcel paramParcel2, int paramInt2)
      throws RemoteException
    {
      switch (paramInt1)
      {
      default:
        return super.onTransact(paramInt1, paramParcel1, paramParcel2, paramInt2);
      case 1598968902:
        paramParcel2.writeString("com.google.android.gms.search.internal.ISearchAuthCallbacks");
        return true;
      case 1:
        paramParcel1.enforceInterface("com.google.android.gms.search.internal.ISearchAuthCallbacks");
        if (paramParcel1.readInt() != 0)
        {
          paramParcel2 = (Status)Status.CREATOR.createFromParcel(paramParcel1);
          if (paramParcel1.readInt() == 0)
            break label113;
        }
        label113: for (paramParcel1 = (GoogleNowAuthState)GoogleNowAuthState.CREATOR.createFromParcel(paramParcel1); ; paramParcel1 = null)
        {
          zza(paramParcel2, paramParcel1);
          return true;
          paramParcel2 = null;
          break;
        }
      case 2:
      }
      paramParcel1.enforceInterface("com.google.android.gms.search.internal.ISearchAuthCallbacks");
      if (paramParcel1.readInt() != 0);
      for (paramParcel1 = (Status)Status.CREATOR.createFromParcel(paramParcel1); ; paramParcel1 = null)
      {
        zzeh(paramParcel1);
        return true;
      }
    }

    private static class zza
      implements zzxk
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

      public void zza(Status paramStatus, GoogleNowAuthState paramGoogleNowAuthState)
        throws RemoteException
      {
        Parcel localParcel = Parcel.obtain();
        while (true)
        {
          try
          {
            localParcel.writeInterfaceToken("com.google.android.gms.search.internal.ISearchAuthCallbacks");
            if (paramStatus == null)
              continue;
            localParcel.writeInt(1);
            paramStatus.writeToParcel(localParcel, 0);
            if (paramGoogleNowAuthState != null)
            {
              localParcel.writeInt(1);
              paramGoogleNowAuthState.writeToParcel(localParcel, 0);
              this.zzajq.transact(1, localParcel, null, 1);
              return;
              localParcel.writeInt(0);
              continue;
            }
          }
          finally
          {
            localParcel.recycle();
          }
          localParcel.writeInt(0);
        }
      }

      public void zzeh(Status paramStatus)
        throws RemoteException
      {
        Parcel localParcel = Parcel.obtain();
        try
        {
          localParcel.writeInterfaceToken("com.google.android.gms.search.internal.ISearchAuthCallbacks");
          if (paramStatus != null)
          {
            localParcel.writeInt(1);
            paramStatus.writeToParcel(localParcel, 0);
          }
          while (true)
          {
            this.zzajq.transact(2, localParcel, null, 1);
            return;
            localParcel.writeInt(0);
          }
        }
        finally
        {
          localParcel.recycle();
        }
        throw paramStatus;
      }
    }
  }
}

/* Location:           C:\Users\c_jealom1\Documents\Scripts\Android\Fathom_com.brynk.fathom\Fathom_com.brynk.fathom-dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.zzxk
 * JD-Core Version:    0.6.0
 */
package com.google.android.gms.iid;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Message;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.os.RemoteException;

public abstract interface zzb extends IInterface
{
  public abstract void send(Message paramMessage)
    throws RemoteException;

  public static abstract class zza extends Binder
    implements zzb
  {
    public zza()
    {
      attachInterface(this, "com.google.android.gms.iid.IMessengerCompat");
    }

    public static zzb zzgx(IBinder paramIBinder)
    {
      if (paramIBinder == null)
        return null;
      IInterface localIInterface = paramIBinder.queryLocalInterface("com.google.android.gms.iid.IMessengerCompat");
      if ((localIInterface != null) && ((localIInterface instanceof zzb)))
        return (zzb)localIInterface;
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
        paramParcel2.writeString("com.google.android.gms.iid.IMessengerCompat");
        return true;
      case 1:
      }
      paramParcel1.enforceInterface("com.google.android.gms.iid.IMessengerCompat");
      if (paramParcel1.readInt() != 0);
      for (paramParcel1 = (Message)Message.CREATOR.createFromParcel(paramParcel1); ; paramParcel1 = null)
      {
        send(paramParcel1);
        return true;
      }
    }

    private static class zza
      implements zzb
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

      public void send(Message paramMessage)
        throws RemoteException
      {
        Parcel localParcel = Parcel.obtain();
        try
        {
          localParcel.writeInterfaceToken("com.google.android.gms.iid.IMessengerCompat");
          if (paramMessage != null)
          {
            localParcel.writeInt(1);
            paramMessage.writeToParcel(localParcel, 0);
          }
          while (true)
          {
            this.zzajq.transact(1, localParcel, null, 1);
            return;
            localParcel.writeInt(0);
          }
        }
        finally
        {
          localParcel.recycle();
        }
        throw paramMessage;
      }
    }
  }
}

/* Location:           C:\Users\c_jealom1\Documents\Scripts\Android\Fathom_com.brynk.fathom\Fathom_com.brynk.fathom-dex2jar.jar
 * Qualified Name:     com.google.android.gms.iid.zzb
 * JD-Core Version:    0.6.0
 */
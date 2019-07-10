package com.google.android.gms.internal;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.dynamic.zzd;
import com.google.android.gms.dynamic.zzd.zza;

public abstract interface zzvt extends IInterface
{
  public abstract boolean getBooleanFlagValue(String paramString, boolean paramBoolean, int paramInt)
    throws RemoteException;

  public abstract int getIntFlagValue(String paramString, int paramInt1, int paramInt2)
    throws RemoteException;

  public abstract long getLongFlagValue(String paramString, long paramLong, int paramInt)
    throws RemoteException;

  public abstract String getStringFlagValue(String paramString1, String paramString2, int paramInt)
    throws RemoteException;

  public abstract void init(zzd paramzzd)
    throws RemoteException;

  public static abstract class zza extends Binder
    implements zzvt
  {
    public zza()
    {
      attachInterface(this, "com.google.android.gms.flags.IFlagProvider");
    }

    public static zzvt asInterface(IBinder paramIBinder)
    {
      if (paramIBinder == null)
        return null;
      IInterface localIInterface = paramIBinder.queryLocalInterface("com.google.android.gms.flags.IFlagProvider");
      if ((localIInterface != null) && ((localIInterface instanceof zzvt)))
        return (zzvt)localIInterface;
      return new zza(paramIBinder);
    }

    public IBinder asBinder()
    {
      return this;
    }

    public boolean onTransact(int paramInt1, Parcel paramParcel1, Parcel paramParcel2, int paramInt2)
      throws RemoteException
    {
      int i = 0;
      switch (paramInt1)
      {
      default:
        return super.onTransact(paramInt1, paramParcel1, paramParcel2, paramInt2);
      case 1598968902:
        paramParcel2.writeString("com.google.android.gms.flags.IFlagProvider");
        return true;
      case 1:
        paramParcel1.enforceInterface("com.google.android.gms.flags.IFlagProvider");
        init(zzd.zza.zzfd(paramParcel1.readStrongBinder()));
        paramParcel2.writeNoException();
        return true;
      case 2:
        paramParcel1.enforceInterface("com.google.android.gms.flags.IFlagProvider");
        String str = paramParcel1.readString();
        if (paramParcel1.readInt() != 0);
        for (boolean bool = true; ; bool = false)
        {
          bool = getBooleanFlagValue(str, bool, paramParcel1.readInt());
          paramParcel2.writeNoException();
          paramInt1 = i;
          if (bool)
            paramInt1 = 1;
          paramParcel2.writeInt(paramInt1);
          return true;
        }
      case 3:
        paramParcel1.enforceInterface("com.google.android.gms.flags.IFlagProvider");
        paramInt1 = getIntFlagValue(paramParcel1.readString(), paramParcel1.readInt(), paramParcel1.readInt());
        paramParcel2.writeNoException();
        paramParcel2.writeInt(paramInt1);
        return true;
      case 4:
        paramParcel1.enforceInterface("com.google.android.gms.flags.IFlagProvider");
        long l = getLongFlagValue(paramParcel1.readString(), paramParcel1.readLong(), paramParcel1.readInt());
        paramParcel2.writeNoException();
        paramParcel2.writeLong(l);
        return true;
      case 5:
      }
      paramParcel1.enforceInterface("com.google.android.gms.flags.IFlagProvider");
      paramParcel1 = getStringFlagValue(paramParcel1.readString(), paramParcel1.readString(), paramParcel1.readInt());
      paramParcel2.writeNoException();
      paramParcel2.writeString(paramParcel1);
      return true;
    }

    private static class zza
      implements zzvt
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

      public boolean getBooleanFlagValue(String paramString, boolean paramBoolean, int paramInt)
        throws RemoteException
      {
        boolean bool = true;
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        try
        {
          localParcel1.writeInterfaceToken("com.google.android.gms.flags.IFlagProvider");
          localParcel1.writeString(paramString);
          int i;
          if (paramBoolean)
          {
            i = 1;
            localParcel1.writeInt(i);
            localParcel1.writeInt(paramInt);
            this.zzajq.transact(2, localParcel1, localParcel2, 0);
            localParcel2.readException();
            paramInt = localParcel2.readInt();
            if (paramInt == 0)
              break label98;
          }
          label98: for (paramBoolean = bool; ; paramBoolean = false)
          {
            return paramBoolean;
            i = 0;
            break;
          }
        }
        finally
        {
          localParcel2.recycle();
          localParcel1.recycle();
        }
        throw paramString;
      }

      public int getIntFlagValue(String paramString, int paramInt1, int paramInt2)
        throws RemoteException
      {
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        try
        {
          localParcel1.writeInterfaceToken("com.google.android.gms.flags.IFlagProvider");
          localParcel1.writeString(paramString);
          localParcel1.writeInt(paramInt1);
          localParcel1.writeInt(paramInt2);
          this.zzajq.transact(3, localParcel1, localParcel2, 0);
          localParcel2.readException();
          paramInt1 = localParcel2.readInt();
          return paramInt1;
        }
        finally
        {
          localParcel2.recycle();
          localParcel1.recycle();
        }
        throw paramString;
      }

      public long getLongFlagValue(String paramString, long paramLong, int paramInt)
        throws RemoteException
      {
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        try
        {
          localParcel1.writeInterfaceToken("com.google.android.gms.flags.IFlagProvider");
          localParcel1.writeString(paramString);
          localParcel1.writeLong(paramLong);
          localParcel1.writeInt(paramInt);
          this.zzajq.transact(4, localParcel1, localParcel2, 0);
          localParcel2.readException();
          paramLong = localParcel2.readLong();
          return paramLong;
        }
        finally
        {
          localParcel2.recycle();
          localParcel1.recycle();
        }
        throw paramString;
      }

      public String getStringFlagValue(String paramString1, String paramString2, int paramInt)
        throws RemoteException
      {
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        try
        {
          localParcel1.writeInterfaceToken("com.google.android.gms.flags.IFlagProvider");
          localParcel1.writeString(paramString1);
          localParcel1.writeString(paramString2);
          localParcel1.writeInt(paramInt);
          this.zzajq.transact(5, localParcel1, localParcel2, 0);
          localParcel2.readException();
          paramString1 = localParcel2.readString();
          return paramString1;
        }
        finally
        {
          localParcel2.recycle();
          localParcel1.recycle();
        }
        throw paramString1;
      }

      public void init(zzd paramzzd)
        throws RemoteException
      {
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        try
        {
          localParcel1.writeInterfaceToken("com.google.android.gms.flags.IFlagProvider");
          if (paramzzd != null);
          for (paramzzd = paramzzd.asBinder(); ; paramzzd = null)
          {
            localParcel1.writeStrongBinder(paramzzd);
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
        throw paramzzd;
      }
    }
  }
}

/* Location:           C:\Users\c_jealom1\Documents\Scripts\Android\Fathom_com.brynk.fathom\Fathom_com.brynk.fathom-dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.zzvt
 * JD-Core Version:    0.6.0
 */
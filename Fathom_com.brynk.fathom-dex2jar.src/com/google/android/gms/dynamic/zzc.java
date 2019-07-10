package com.google.android.gms.dynamic;

import android.content.Intent;
import android.os.Binder;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.os.RemoteException;

public abstract interface zzc extends IInterface
{
  public abstract Bundle getArguments()
    throws RemoteException;

  public abstract int getId()
    throws RemoteException;

  public abstract boolean getRetainInstance()
    throws RemoteException;

  public abstract String getTag()
    throws RemoteException;

  public abstract int getTargetRequestCode()
    throws RemoteException;

  public abstract boolean getUserVisibleHint()
    throws RemoteException;

  public abstract zzd getView()
    throws RemoteException;

  public abstract boolean isAdded()
    throws RemoteException;

  public abstract boolean isDetached()
    throws RemoteException;

  public abstract boolean isHidden()
    throws RemoteException;

  public abstract boolean isInLayout()
    throws RemoteException;

  public abstract boolean isRemoving()
    throws RemoteException;

  public abstract boolean isResumed()
    throws RemoteException;

  public abstract boolean isVisible()
    throws RemoteException;

  public abstract void setHasOptionsMenu(boolean paramBoolean)
    throws RemoteException;

  public abstract void setMenuVisibility(boolean paramBoolean)
    throws RemoteException;

  public abstract void setRetainInstance(boolean paramBoolean)
    throws RemoteException;

  public abstract void setUserVisibleHint(boolean paramBoolean)
    throws RemoteException;

  public abstract void startActivity(Intent paramIntent)
    throws RemoteException;

  public abstract void startActivityForResult(Intent paramIntent, int paramInt)
    throws RemoteException;

  public abstract void zzac(zzd paramzzd)
    throws RemoteException;

  public abstract void zzad(zzd paramzzd)
    throws RemoteException;

  public abstract zzd zzbdp()
    throws RemoteException;

  public abstract zzc zzbdq()
    throws RemoteException;

  public abstract zzd zzbdr()
    throws RemoteException;

  public abstract zzc zzbds()
    throws RemoteException;

  public static abstract class zza extends Binder
    implements zzc
  {
    public zza()
    {
      attachInterface(this, "com.google.android.gms.dynamic.IFragmentWrapper");
    }

    public static zzc zzfc(IBinder paramIBinder)
    {
      if (paramIBinder == null)
        return null;
      IInterface localIInterface = paramIBinder.queryLocalInterface("com.google.android.gms.dynamic.IFragmentWrapper");
      if ((localIInterface != null) && ((localIInterface instanceof zzc)))
        return (zzc)localIInterface;
      return new zza(paramIBinder);
    }

    public IBinder asBinder()
    {
      return this;
    }

    public boolean onTransact(int paramInt1, Parcel paramParcel1, Parcel paramParcel2, int paramInt2)
      throws RemoteException
    {
      zzd localzzd = null;
      Object localObject2 = null;
      Object localObject3 = null;
      Object localObject4 = null;
      Object localObject5 = null;
      Object localObject6 = null;
      Object localObject1 = null;
      int j = 0;
      int k = 0;
      int m = 0;
      int n = 0;
      int i1 = 0;
      int i2 = 0;
      int i3 = 0;
      boolean bool1 = false;
      boolean bool2 = false;
      boolean bool3 = false;
      boolean bool4 = false;
      int i = 0;
      switch (paramInt1)
      {
      default:
        return super.onTransact(paramInt1, paramParcel1, paramParcel2, paramInt2);
      case 1598968902:
        paramParcel2.writeString("com.google.android.gms.dynamic.IFragmentWrapper");
        return true;
      case 2:
        paramParcel1.enforceInterface("com.google.android.gms.dynamic.IFragmentWrapper");
        localzzd = zzbdp();
        paramParcel2.writeNoException();
        paramParcel1 = (Parcel)localObject1;
        if (localzzd != null)
          paramParcel1 = localzzd.asBinder();
        paramParcel2.writeStrongBinder(paramParcel1);
        return true;
      case 3:
        paramParcel1.enforceInterface("com.google.android.gms.dynamic.IFragmentWrapper");
        paramParcel1 = getArguments();
        paramParcel2.writeNoException();
        if (paramParcel1 != null)
        {
          paramParcel2.writeInt(1);
          paramParcel1.writeToParcel(paramParcel2, 1);
          return true;
        }
        paramParcel2.writeInt(0);
        return true;
      case 4:
        paramParcel1.enforceInterface("com.google.android.gms.dynamic.IFragmentWrapper");
        paramInt1 = getId();
        paramParcel2.writeNoException();
        paramParcel2.writeInt(paramInt1);
        return true;
      case 5:
        paramParcel1.enforceInterface("com.google.android.gms.dynamic.IFragmentWrapper");
        localObject1 = zzbdq();
        paramParcel2.writeNoException();
        paramParcel1 = localzzd;
        if (localObject1 != null)
          paramParcel1 = ((zzc)localObject1).asBinder();
        paramParcel2.writeStrongBinder(paramParcel1);
        return true;
      case 6:
        paramParcel1.enforceInterface("com.google.android.gms.dynamic.IFragmentWrapper");
        localObject1 = zzbdr();
        paramParcel2.writeNoException();
        paramParcel1 = localObject2;
        if (localObject1 != null)
          paramParcel1 = ((zzd)localObject1).asBinder();
        paramParcel2.writeStrongBinder(paramParcel1);
        return true;
      case 7:
        paramParcel1.enforceInterface("com.google.android.gms.dynamic.IFragmentWrapper");
        bool1 = getRetainInstance();
        paramParcel2.writeNoException();
        if (bool1);
        for (paramInt1 = 1; ; paramInt1 = 0)
        {
          paramParcel2.writeInt(paramInt1);
          return true;
        }
      case 8:
        paramParcel1.enforceInterface("com.google.android.gms.dynamic.IFragmentWrapper");
        paramParcel1 = getTag();
        paramParcel2.writeNoException();
        paramParcel2.writeString(paramParcel1);
        return true;
      case 9:
        paramParcel1.enforceInterface("com.google.android.gms.dynamic.IFragmentWrapper");
        localObject1 = zzbds();
        paramParcel2.writeNoException();
        paramParcel1 = localObject3;
        if (localObject1 != null)
          paramParcel1 = ((zzc)localObject1).asBinder();
        paramParcel2.writeStrongBinder(paramParcel1);
        return true;
      case 10:
        paramParcel1.enforceInterface("com.google.android.gms.dynamic.IFragmentWrapper");
        paramInt1 = getTargetRequestCode();
        paramParcel2.writeNoException();
        paramParcel2.writeInt(paramInt1);
        return true;
      case 11:
        paramParcel1.enforceInterface("com.google.android.gms.dynamic.IFragmentWrapper");
        bool1 = getUserVisibleHint();
        paramParcel2.writeNoException();
        paramInt1 = i;
        if (bool1)
          paramInt1 = 1;
        paramParcel2.writeInt(paramInt1);
        return true;
      case 12:
        paramParcel1.enforceInterface("com.google.android.gms.dynamic.IFragmentWrapper");
        localObject1 = getView();
        paramParcel2.writeNoException();
        paramParcel1 = localObject4;
        if (localObject1 != null)
          paramParcel1 = ((zzd)localObject1).asBinder();
        paramParcel2.writeStrongBinder(paramParcel1);
        return true;
      case 13:
        paramParcel1.enforceInterface("com.google.android.gms.dynamic.IFragmentWrapper");
        bool1 = isAdded();
        paramParcel2.writeNoException();
        paramInt1 = j;
        if (bool1)
          paramInt1 = 1;
        paramParcel2.writeInt(paramInt1);
        return true;
      case 14:
        paramParcel1.enforceInterface("com.google.android.gms.dynamic.IFragmentWrapper");
        bool1 = isDetached();
        paramParcel2.writeNoException();
        paramInt1 = k;
        if (bool1)
          paramInt1 = 1;
        paramParcel2.writeInt(paramInt1);
        return true;
      case 15:
        paramParcel1.enforceInterface("com.google.android.gms.dynamic.IFragmentWrapper");
        bool1 = isHidden();
        paramParcel2.writeNoException();
        paramInt1 = m;
        if (bool1)
          paramInt1 = 1;
        paramParcel2.writeInt(paramInt1);
        return true;
      case 16:
        paramParcel1.enforceInterface("com.google.android.gms.dynamic.IFragmentWrapper");
        bool1 = isInLayout();
        paramParcel2.writeNoException();
        paramInt1 = n;
        if (bool1)
          paramInt1 = 1;
        paramParcel2.writeInt(paramInt1);
        return true;
      case 17:
        paramParcel1.enforceInterface("com.google.android.gms.dynamic.IFragmentWrapper");
        bool1 = isRemoving();
        paramParcel2.writeNoException();
        paramInt1 = i1;
        if (bool1)
          paramInt1 = 1;
        paramParcel2.writeInt(paramInt1);
        return true;
      case 18:
        paramParcel1.enforceInterface("com.google.android.gms.dynamic.IFragmentWrapper");
        bool1 = isResumed();
        paramParcel2.writeNoException();
        paramInt1 = i2;
        if (bool1)
          paramInt1 = 1;
        paramParcel2.writeInt(paramInt1);
        return true;
      case 19:
        paramParcel1.enforceInterface("com.google.android.gms.dynamic.IFragmentWrapper");
        bool1 = isVisible();
        paramParcel2.writeNoException();
        paramInt1 = i3;
        if (bool1)
          paramInt1 = 1;
        paramParcel2.writeInt(paramInt1);
        return true;
      case 20:
        paramParcel1.enforceInterface("com.google.android.gms.dynamic.IFragmentWrapper");
        zzac(zzd.zza.zzfd(paramParcel1.readStrongBinder()));
        paramParcel2.writeNoException();
        return true;
      case 21:
        paramParcel1.enforceInterface("com.google.android.gms.dynamic.IFragmentWrapper");
        if (paramParcel1.readInt() != 0)
          bool1 = true;
        setHasOptionsMenu(bool1);
        paramParcel2.writeNoException();
        return true;
      case 22:
        paramParcel1.enforceInterface("com.google.android.gms.dynamic.IFragmentWrapper");
        bool1 = bool2;
        if (paramParcel1.readInt() != 0)
          bool1 = true;
        setMenuVisibility(bool1);
        paramParcel2.writeNoException();
        return true;
      case 23:
        paramParcel1.enforceInterface("com.google.android.gms.dynamic.IFragmentWrapper");
        bool1 = bool3;
        if (paramParcel1.readInt() != 0)
          bool1 = true;
        setRetainInstance(bool1);
        paramParcel2.writeNoException();
        return true;
      case 24:
        paramParcel1.enforceInterface("com.google.android.gms.dynamic.IFragmentWrapper");
        bool1 = bool4;
        if (paramParcel1.readInt() != 0)
          bool1 = true;
        setUserVisibleHint(bool1);
        paramParcel2.writeNoException();
        return true;
      case 25:
        paramParcel1.enforceInterface("com.google.android.gms.dynamic.IFragmentWrapper");
        localObject1 = localObject5;
        if (paramParcel1.readInt() != 0)
          localObject1 = (Intent)Intent.CREATOR.createFromParcel(paramParcel1);
        startActivity((Intent)localObject1);
        paramParcel2.writeNoException();
        return true;
      case 26:
        paramParcel1.enforceInterface("com.google.android.gms.dynamic.IFragmentWrapper");
        localObject1 = localObject6;
        if (paramParcel1.readInt() != 0)
          localObject1 = (Intent)Intent.CREATOR.createFromParcel(paramParcel1);
        startActivityForResult((Intent)localObject1, paramParcel1.readInt());
        paramParcel2.writeNoException();
        return true;
      case 27:
      }
      paramParcel1.enforceInterface("com.google.android.gms.dynamic.IFragmentWrapper");
      zzad(zzd.zza.zzfd(paramParcel1.readStrongBinder()));
      paramParcel2.writeNoException();
      return true;
    }

    private static class zza
      implements zzc
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

      public Bundle getArguments()
        throws RemoteException
      {
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        try
        {
          localParcel1.writeInterfaceToken("com.google.android.gms.dynamic.IFragmentWrapper");
          this.zzajq.transact(3, localParcel1, localParcel2, 0);
          localParcel2.readException();
          if (localParcel2.readInt() != 0)
          {
            localBundle = (Bundle)Bundle.CREATOR.createFromParcel(localParcel2);
            return localBundle;
          }
          Bundle localBundle = null;
        }
        finally
        {
          localParcel2.recycle();
          localParcel1.recycle();
        }
      }

      public int getId()
        throws RemoteException
      {
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        try
        {
          localParcel1.writeInterfaceToken("com.google.android.gms.dynamic.IFragmentWrapper");
          this.zzajq.transact(4, localParcel1, localParcel2, 0);
          localParcel2.readException();
          int i = localParcel2.readInt();
          return i;
        }
        finally
        {
          localParcel2.recycle();
          localParcel1.recycle();
        }
        throw localObject;
      }

      public boolean getRetainInstance()
        throws RemoteException
      {
        int j = 0;
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        try
        {
          localParcel1.writeInterfaceToken("com.google.android.gms.dynamic.IFragmentWrapper");
          this.zzajq.transact(7, localParcel1, localParcel2, 0);
          localParcel2.readException();
          int i = localParcel2.readInt();
          if (i != 0)
            j = 1;
          return j;
        }
        finally
        {
          localParcel2.recycle();
          localParcel1.recycle();
        }
        throw localObject;
      }

      public String getTag()
        throws RemoteException
      {
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        try
        {
          localParcel1.writeInterfaceToken("com.google.android.gms.dynamic.IFragmentWrapper");
          this.zzajq.transact(8, localParcel1, localParcel2, 0);
          localParcel2.readException();
          String str = localParcel2.readString();
          return str;
        }
        finally
        {
          localParcel2.recycle();
          localParcel1.recycle();
        }
        throw localObject;
      }

      public int getTargetRequestCode()
        throws RemoteException
      {
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        try
        {
          localParcel1.writeInterfaceToken("com.google.android.gms.dynamic.IFragmentWrapper");
          this.zzajq.transact(10, localParcel1, localParcel2, 0);
          localParcel2.readException();
          int i = localParcel2.readInt();
          return i;
        }
        finally
        {
          localParcel2.recycle();
          localParcel1.recycle();
        }
        throw localObject;
      }

      public boolean getUserVisibleHint()
        throws RemoteException
      {
        int j = 0;
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        try
        {
          localParcel1.writeInterfaceToken("com.google.android.gms.dynamic.IFragmentWrapper");
          this.zzajq.transact(11, localParcel1, localParcel2, 0);
          localParcel2.readException();
          int i = localParcel2.readInt();
          if (i != 0)
            j = 1;
          return j;
        }
        finally
        {
          localParcel2.recycle();
          localParcel1.recycle();
        }
        throw localObject;
      }

      public zzd getView()
        throws RemoteException
      {
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        try
        {
          localParcel1.writeInterfaceToken("com.google.android.gms.dynamic.IFragmentWrapper");
          this.zzajq.transact(12, localParcel1, localParcel2, 0);
          localParcel2.readException();
          zzd localzzd = zzd.zza.zzfd(localParcel2.readStrongBinder());
          return localzzd;
        }
        finally
        {
          localParcel2.recycle();
          localParcel1.recycle();
        }
        throw localObject;
      }

      public boolean isAdded()
        throws RemoteException
      {
        int j = 0;
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        try
        {
          localParcel1.writeInterfaceToken("com.google.android.gms.dynamic.IFragmentWrapper");
          this.zzajq.transact(13, localParcel1, localParcel2, 0);
          localParcel2.readException();
          int i = localParcel2.readInt();
          if (i != 0)
            j = 1;
          return j;
        }
        finally
        {
          localParcel2.recycle();
          localParcel1.recycle();
        }
        throw localObject;
      }

      public boolean isDetached()
        throws RemoteException
      {
        int j = 0;
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        try
        {
          localParcel1.writeInterfaceToken("com.google.android.gms.dynamic.IFragmentWrapper");
          this.zzajq.transact(14, localParcel1, localParcel2, 0);
          localParcel2.readException();
          int i = localParcel2.readInt();
          if (i != 0)
            j = 1;
          return j;
        }
        finally
        {
          localParcel2.recycle();
          localParcel1.recycle();
        }
        throw localObject;
      }

      public boolean isHidden()
        throws RemoteException
      {
        int j = 0;
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        try
        {
          localParcel1.writeInterfaceToken("com.google.android.gms.dynamic.IFragmentWrapper");
          this.zzajq.transact(15, localParcel1, localParcel2, 0);
          localParcel2.readException();
          int i = localParcel2.readInt();
          if (i != 0)
            j = 1;
          return j;
        }
        finally
        {
          localParcel2.recycle();
          localParcel1.recycle();
        }
        throw localObject;
      }

      public boolean isInLayout()
        throws RemoteException
      {
        int j = 0;
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        try
        {
          localParcel1.writeInterfaceToken("com.google.android.gms.dynamic.IFragmentWrapper");
          this.zzajq.transact(16, localParcel1, localParcel2, 0);
          localParcel2.readException();
          int i = localParcel2.readInt();
          if (i != 0)
            j = 1;
          return j;
        }
        finally
        {
          localParcel2.recycle();
          localParcel1.recycle();
        }
        throw localObject;
      }

      public boolean isRemoving()
        throws RemoteException
      {
        int j = 0;
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        try
        {
          localParcel1.writeInterfaceToken("com.google.android.gms.dynamic.IFragmentWrapper");
          this.zzajq.transact(17, localParcel1, localParcel2, 0);
          localParcel2.readException();
          int i = localParcel2.readInt();
          if (i != 0)
            j = 1;
          return j;
        }
        finally
        {
          localParcel2.recycle();
          localParcel1.recycle();
        }
        throw localObject;
      }

      public boolean isResumed()
        throws RemoteException
      {
        int j = 0;
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        try
        {
          localParcel1.writeInterfaceToken("com.google.android.gms.dynamic.IFragmentWrapper");
          this.zzajq.transact(18, localParcel1, localParcel2, 0);
          localParcel2.readException();
          int i = localParcel2.readInt();
          if (i != 0)
            j = 1;
          return j;
        }
        finally
        {
          localParcel2.recycle();
          localParcel1.recycle();
        }
        throw localObject;
      }

      public boolean isVisible()
        throws RemoteException
      {
        int j = 0;
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        try
        {
          localParcel1.writeInterfaceToken("com.google.android.gms.dynamic.IFragmentWrapper");
          this.zzajq.transact(19, localParcel1, localParcel2, 0);
          localParcel2.readException();
          int i = localParcel2.readInt();
          if (i != 0)
            j = 1;
          return j;
        }
        finally
        {
          localParcel2.recycle();
          localParcel1.recycle();
        }
        throw localObject;
      }

      public void setHasOptionsMenu(boolean paramBoolean)
        throws RemoteException
      {
        int i = 0;
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        try
        {
          localParcel1.writeInterfaceToken("com.google.android.gms.dynamic.IFragmentWrapper");
          if (paramBoolean)
            i = 1;
          localParcel1.writeInt(i);
          this.zzajq.transact(21, localParcel1, localParcel2, 0);
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

      public void setMenuVisibility(boolean paramBoolean)
        throws RemoteException
      {
        int i = 0;
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        try
        {
          localParcel1.writeInterfaceToken("com.google.android.gms.dynamic.IFragmentWrapper");
          if (paramBoolean)
            i = 1;
          localParcel1.writeInt(i);
          this.zzajq.transact(22, localParcel1, localParcel2, 0);
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

      public void setRetainInstance(boolean paramBoolean)
        throws RemoteException
      {
        int i = 0;
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        try
        {
          localParcel1.writeInterfaceToken("com.google.android.gms.dynamic.IFragmentWrapper");
          if (paramBoolean)
            i = 1;
          localParcel1.writeInt(i);
          this.zzajq.transact(23, localParcel1, localParcel2, 0);
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

      public void setUserVisibleHint(boolean paramBoolean)
        throws RemoteException
      {
        int i = 0;
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        try
        {
          localParcel1.writeInterfaceToken("com.google.android.gms.dynamic.IFragmentWrapper");
          if (paramBoolean)
            i = 1;
          localParcel1.writeInt(i);
          this.zzajq.transact(24, localParcel1, localParcel2, 0);
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

      public void startActivity(Intent paramIntent)
        throws RemoteException
      {
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        try
        {
          localParcel1.writeInterfaceToken("com.google.android.gms.dynamic.IFragmentWrapper");
          if (paramIntent != null)
          {
            localParcel1.writeInt(1);
            paramIntent.writeToParcel(localParcel1, 0);
          }
          while (true)
          {
            this.zzajq.transact(25, localParcel1, localParcel2, 0);
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
        throw paramIntent;
      }

      public void startActivityForResult(Intent paramIntent, int paramInt)
        throws RemoteException
      {
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        try
        {
          localParcel1.writeInterfaceToken("com.google.android.gms.dynamic.IFragmentWrapper");
          if (paramIntent != null)
          {
            localParcel1.writeInt(1);
            paramIntent.writeToParcel(localParcel1, 0);
          }
          while (true)
          {
            localParcel1.writeInt(paramInt);
            this.zzajq.transact(26, localParcel1, localParcel2, 0);
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
        throw paramIntent;
      }

      public void zzac(zzd paramzzd)
        throws RemoteException
      {
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        try
        {
          localParcel1.writeInterfaceToken("com.google.android.gms.dynamic.IFragmentWrapper");
          if (paramzzd != null);
          for (paramzzd = paramzzd.asBinder(); ; paramzzd = null)
          {
            localParcel1.writeStrongBinder(paramzzd);
            this.zzajq.transact(20, localParcel1, localParcel2, 0);
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

      public void zzad(zzd paramzzd)
        throws RemoteException
      {
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        try
        {
          localParcel1.writeInterfaceToken("com.google.android.gms.dynamic.IFragmentWrapper");
          if (paramzzd != null);
          for (paramzzd = paramzzd.asBinder(); ; paramzzd = null)
          {
            localParcel1.writeStrongBinder(paramzzd);
            this.zzajq.transact(27, localParcel1, localParcel2, 0);
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

      public zzd zzbdp()
        throws RemoteException
      {
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        try
        {
          localParcel1.writeInterfaceToken("com.google.android.gms.dynamic.IFragmentWrapper");
          this.zzajq.transact(2, localParcel1, localParcel2, 0);
          localParcel2.readException();
          zzd localzzd = zzd.zza.zzfd(localParcel2.readStrongBinder());
          return localzzd;
        }
        finally
        {
          localParcel2.recycle();
          localParcel1.recycle();
        }
        throw localObject;
      }

      public zzc zzbdq()
        throws RemoteException
      {
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        try
        {
          localParcel1.writeInterfaceToken("com.google.android.gms.dynamic.IFragmentWrapper");
          this.zzajq.transact(5, localParcel1, localParcel2, 0);
          localParcel2.readException();
          zzc localzzc = zzc.zza.zzfc(localParcel2.readStrongBinder());
          return localzzc;
        }
        finally
        {
          localParcel2.recycle();
          localParcel1.recycle();
        }
        throw localObject;
      }

      public zzd zzbdr()
        throws RemoteException
      {
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        try
        {
          localParcel1.writeInterfaceToken("com.google.android.gms.dynamic.IFragmentWrapper");
          this.zzajq.transact(6, localParcel1, localParcel2, 0);
          localParcel2.readException();
          zzd localzzd = zzd.zza.zzfd(localParcel2.readStrongBinder());
          return localzzd;
        }
        finally
        {
          localParcel2.recycle();
          localParcel1.recycle();
        }
        throw localObject;
      }

      public zzc zzbds()
        throws RemoteException
      {
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        try
        {
          localParcel1.writeInterfaceToken("com.google.android.gms.dynamic.IFragmentWrapper");
          this.zzajq.transact(9, localParcel1, localParcel2, 0);
          localParcel2.readException();
          zzc localzzc = zzc.zza.zzfc(localParcel2.readStrongBinder());
          return localzzc;
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
 * Qualified Name:     com.google.android.gms.dynamic.zzc
 * JD-Core Version:    0.6.0
 */
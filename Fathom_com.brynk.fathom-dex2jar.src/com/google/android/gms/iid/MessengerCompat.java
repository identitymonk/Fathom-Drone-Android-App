package com.google.android.gms.iid;

import android.annotation.TargetApi;
import android.os.Binder;
import android.os.Build.VERSION;
import android.os.Handler;
import android.os.IBinder;
import android.os.Message;
import android.os.Messenger;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.os.RemoteException;

public class MessengerCompat
  implements Parcelable
{
  public static final Parcelable.Creator<MessengerCompat> CREATOR = new Parcelable.Creator()
  {
    public MessengerCompat zznf(Parcel paramParcel)
    {
      paramParcel = paramParcel.readStrongBinder();
      if (paramParcel != null)
        return new MessengerCompat(paramParcel);
      return null;
    }

    public MessengerCompat[] zztv(int paramInt)
    {
      return new MessengerCompat[paramInt];
    }
  };
  Messenger aiq;
  zzb air;

  public MessengerCompat(Handler paramHandler)
  {
    if (Build.VERSION.SDK_INT >= 21)
    {
      this.aiq = new Messenger(paramHandler);
      return;
    }
    this.air = new zza(paramHandler);
  }

  public MessengerCompat(IBinder paramIBinder)
  {
    if (Build.VERSION.SDK_INT >= 21)
    {
      this.aiq = new Messenger(paramIBinder);
      return;
    }
    this.air = zzb.zza.zzgx(paramIBinder);
  }

  public static int zzc(Message paramMessage)
  {
    if (Build.VERSION.SDK_INT >= 21)
      return zzd(paramMessage);
    return paramMessage.arg2;
  }

  @TargetApi(21)
  private static int zzd(Message paramMessage)
  {
    return paramMessage.sendingUid;
  }

  public int describeContents()
  {
    return 0;
  }

  public boolean equals(Object paramObject)
  {
    if (paramObject == null)
      return false;
    try
    {
      boolean bool = getBinder().equals(((MessengerCompat)paramObject).getBinder());
      return bool;
    }
    catch (java.lang.ClassCastException paramObject)
    {
    }
    return false;
  }

  public IBinder getBinder()
  {
    if (this.aiq != null)
      return this.aiq.getBinder();
    return this.air.asBinder();
  }

  public int hashCode()
  {
    return getBinder().hashCode();
  }

  public void send(Message paramMessage)
    throws RemoteException
  {
    if (this.aiq != null)
    {
      this.aiq.send(paramMessage);
      return;
    }
    this.air.send(paramMessage);
  }

  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    if (this.aiq != null)
    {
      paramParcel.writeStrongBinder(this.aiq.getBinder());
      return;
    }
    paramParcel.writeStrongBinder(this.air.asBinder());
  }

  private final class zza extends zzb.zza
  {
    Handler handler;

    zza(Handler arg2)
    {
      Object localObject;
      this.handler = localObject;
    }

    public void send(Message paramMessage)
      throws RemoteException
    {
      paramMessage.arg2 = Binder.getCallingUid();
      this.handler.dispatchMessage(paramMessage);
    }
  }
}

/* Location:           C:\Users\c_jealom1\Documents\Scripts\Android\Fathom_com.brynk.fathom\Fathom_com.brynk.fathom-dex2jar.jar
 * Qualified Name:     com.google.android.gms.iid.MessengerCompat
 * JD-Core Version:    0.6.0
 */
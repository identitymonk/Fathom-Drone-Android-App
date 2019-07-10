package com.google.android.gms.common.internal;

import android.os.Bundle;
import android.os.Handler;
import android.os.Handler.Callback;
import android.os.Looper;
import android.os.Message;
import android.util.Log;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.GoogleApiClient.ConnectionCallbacks;
import com.google.android.gms.common.api.GoogleApiClient.OnConnectionFailedListener;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.concurrent.atomic.AtomicInteger;

public final class zzk
  implements Handler.Callback
{
  private final zza Ee;
  private final ArrayList<GoogleApiClient.ConnectionCallbacks> Ef = new ArrayList();
  final ArrayList<GoogleApiClient.ConnectionCallbacks> Eg = new ArrayList();
  private final ArrayList<GoogleApiClient.OnConnectionFailedListener> Eh = new ArrayList();
  private volatile boolean Ei = false;
  private final AtomicInteger Ej = new AtomicInteger(0);
  private boolean Ek = false;
  private final Handler mHandler;
  private final Object zzako = new Object();

  public zzk(Looper paramLooper, zza paramzza)
  {
    this.Ee = paramzza;
    this.mHandler = new Handler(paramLooper, this);
  }

  public boolean handleMessage(Message arg1)
  {
    if (???.what == 1)
    {
      GoogleApiClient.ConnectionCallbacks localConnectionCallbacks = (GoogleApiClient.ConnectionCallbacks)???.obj;
      synchronized (this.zzako)
      {
        if ((this.Ei) && (this.Ee.isConnected()) && (this.Ef.contains(localConnectionCallbacks)))
          localConnectionCallbacks.onConnected(this.Ee.zzapn());
        return true;
      }
    }
    int i = ???.what;
    Log.wtf("GmsClientEvents", 45 + "Don't know how to handle message: " + i, new Exception());
    return false;
  }

  public boolean isConnectionCallbacksRegistered(GoogleApiClient.ConnectionCallbacks paramConnectionCallbacks)
  {
    zzaa.zzy(paramConnectionCallbacks);
    synchronized (this.zzako)
    {
      boolean bool = this.Ef.contains(paramConnectionCallbacks);
      return bool;
    }
  }

  public boolean isConnectionFailedListenerRegistered(GoogleApiClient.OnConnectionFailedListener paramOnConnectionFailedListener)
  {
    zzaa.zzy(paramOnConnectionFailedListener);
    synchronized (this.zzako)
    {
      boolean bool = this.Eh.contains(paramOnConnectionFailedListener);
      return bool;
    }
  }

  public void registerConnectionCallbacks(GoogleApiClient.ConnectionCallbacks paramConnectionCallbacks)
  {
    zzaa.zzy(paramConnectionCallbacks);
    synchronized (this.zzako)
    {
      if (this.Ef.contains(paramConnectionCallbacks))
      {
        String str = String.valueOf(paramConnectionCallbacks);
        Log.w("GmsClientEvents", String.valueOf(str).length() + 62 + "registerConnectionCallbacks(): listener " + str + " is already registered");
        if (this.Ee.isConnected())
          this.mHandler.sendMessage(this.mHandler.obtainMessage(1, paramConnectionCallbacks));
        return;
      }
      this.Ef.add(paramConnectionCallbacks);
    }
  }

  public void registerConnectionFailedListener(GoogleApiClient.OnConnectionFailedListener paramOnConnectionFailedListener)
  {
    zzaa.zzy(paramOnConnectionFailedListener);
    synchronized (this.zzako)
    {
      if (this.Eh.contains(paramOnConnectionFailedListener))
      {
        paramOnConnectionFailedListener = String.valueOf(paramOnConnectionFailedListener);
        Log.w("GmsClientEvents", String.valueOf(paramOnConnectionFailedListener).length() + 67 + "registerConnectionFailedListener(): listener " + paramOnConnectionFailedListener + " is already registered");
        return;
      }
      this.Eh.add(paramOnConnectionFailedListener);
    }
  }

  public void unregisterConnectionCallbacks(GoogleApiClient.ConnectionCallbacks paramConnectionCallbacks)
  {
    zzaa.zzy(paramConnectionCallbacks);
    synchronized (this.zzako)
    {
      if (!this.Ef.remove(paramConnectionCallbacks))
      {
        paramConnectionCallbacks = String.valueOf(paramConnectionCallbacks);
        Log.w("GmsClientEvents", String.valueOf(paramConnectionCallbacks).length() + 52 + "unregisterConnectionCallbacks(): listener " + paramConnectionCallbacks + " not found");
      }
      do
        return;
      while (!this.Ek);
      this.Eg.add(paramConnectionCallbacks);
    }
  }

  public void unregisterConnectionFailedListener(GoogleApiClient.OnConnectionFailedListener paramOnConnectionFailedListener)
  {
    zzaa.zzy(paramOnConnectionFailedListener);
    synchronized (this.zzako)
    {
      if (!this.Eh.remove(paramOnConnectionFailedListener))
      {
        paramOnConnectionFailedListener = String.valueOf(paramOnConnectionFailedListener);
        Log.w("GmsClientEvents", String.valueOf(paramOnConnectionFailedListener).length() + 57 + "unregisterConnectionFailedListener(): listener " + paramOnConnectionFailedListener + " not found");
      }
      return;
    }
  }

  public void zzawc()
  {
    this.Ei = false;
    this.Ej.incrementAndGet();
  }

  public void zzawd()
  {
    this.Ei = true;
  }

  public void zzgn(int paramInt)
  {
    boolean bool = false;
    if (Looper.myLooper() == this.mHandler.getLooper())
      bool = true;
    zzaa.zza(bool, "onUnintentionalDisconnection must only be called on the Handler thread");
    this.mHandler.removeMessages(1);
    synchronized (this.zzako)
    {
      this.Ek = true;
      Object localObject2 = new ArrayList(this.Ef);
      int i = this.Ej.get();
      localObject2 = ((ArrayList)localObject2).iterator();
      GoogleApiClient.ConnectionCallbacks localConnectionCallbacks;
      do
      {
        if (((Iterator)localObject2).hasNext())
        {
          localConnectionCallbacks = (GoogleApiClient.ConnectionCallbacks)((Iterator)localObject2).next();
          if ((this.Ei) && (this.Ej.get() == i))
            continue;
        }
        this.Eg.clear();
        this.Ek = false;
        return;
      }
      while (!this.Ef.contains(localConnectionCallbacks));
      localConnectionCallbacks.onConnectionSuspended(paramInt);
    }
  }

  public void zzn(ConnectionResult paramConnectionResult)
  {
    if (Looper.myLooper() == this.mHandler.getLooper());
    for (boolean bool = true; ; bool = false)
    {
      zzaa.zza(bool, "onConnectionFailure must only be called on the Handler thread");
      this.mHandler.removeMessages(1);
      synchronized (this.zzako)
      {
        Object localObject2 = new ArrayList(this.Eh);
        int i = this.Ej.get();
        localObject2 = ((ArrayList)localObject2).iterator();
        while (((Iterator)localObject2).hasNext())
        {
          GoogleApiClient.OnConnectionFailedListener localOnConnectionFailedListener = (GoogleApiClient.OnConnectionFailedListener)((Iterator)localObject2).next();
          if ((!this.Ei) || (this.Ej.get() != i))
            return;
          if (!this.Eh.contains(localOnConnectionFailedListener))
            continue;
          localOnConnectionFailedListener.onConnectionFailed(paramConnectionResult);
        }
      }
      monitorexit;
      return;
    }
  }

  public void zzp(Bundle paramBundle)
  {
    boolean bool2 = true;
    boolean bool1;
    if (Looper.myLooper() == this.mHandler.getLooper())
    {
      bool1 = true;
      zzaa.zza(bool1, "onConnectionSuccess must only be called on the Handler thread");
    }
    while (true)
    {
      synchronized (this.zzako)
      {
        if (this.Ek)
          break label206;
        bool1 = true;
        zzaa.zzbs(bool1);
        this.mHandler.removeMessages(1);
        this.Ek = true;
        if (this.Eg.size() != 0)
          break label211;
        bool1 = bool2;
        zzaa.zzbs(bool1);
        Object localObject2 = new ArrayList(this.Ef);
        int i = this.Ej.get();
        localObject2 = ((ArrayList)localObject2).iterator();
        if (!((Iterator)localObject2).hasNext())
          continue;
        GoogleApiClient.ConnectionCallbacks localConnectionCallbacks = (GoogleApiClient.ConnectionCallbacks)((Iterator)localObject2).next();
        if ((this.Ei) && (this.Ee.isConnected()) && (this.Ej.get() == i))
          continue;
        this.Eg.clear();
        this.Ek = false;
        return;
        if (this.Eg.contains(localConnectionCallbacks))
          continue;
        localConnectionCallbacks.onConnected(paramBundle);
      }
      bool1 = false;
      break;
      label206: bool1 = false;
      continue;
      label211: bool1 = false;
    }
  }

  public static abstract interface zza
  {
    public abstract boolean isConnected();

    public abstract Bundle zzapn();
  }
}

/* Location:           C:\Users\c_jealom1\Documents\Scripts\Android\Fathom_com.brynk.fathom\Fathom_com.brynk.fathom-dex2jar.jar
 * Qualified Name:     com.google.android.gms.common.internal.zzk
 * JD-Core Version:    0.6.0
 */
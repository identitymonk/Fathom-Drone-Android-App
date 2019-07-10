package com.google.android.gms.internal;

import android.support.annotation.NonNull;
import android.support.v4.app.FragmentActivity;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.GoogleApiClient.ConnectionCallbacks;
import com.google.android.gms.common.api.GoogleApiClient.OnConnectionFailedListener;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Status;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.util.concurrent.TimeUnit;

public class zzqz extends GoogleApiClient
{
  private final UnsupportedOperationException zz;

  public zzqz(String paramString)
  {
    this.zz = new UnsupportedOperationException(paramString);
  }

  public ConnectionResult blockingConnect()
  {
    throw this.zz;
  }

  public ConnectionResult blockingConnect(long paramLong, @NonNull TimeUnit paramTimeUnit)
  {
    throw this.zz;
  }

  public PendingResult<Status> clearDefaultAccountAndReconnect()
  {
    throw this.zz;
  }

  public void connect()
  {
    throw this.zz;
  }

  public void disconnect()
  {
    throw this.zz;
  }

  public void dump(String paramString, FileDescriptor paramFileDescriptor, PrintWriter paramPrintWriter, String[] paramArrayOfString)
  {
    throw this.zz;
  }

  @NonNull
  public ConnectionResult getConnectionResult(@NonNull Api<?> paramApi)
  {
    throw this.zz;
  }

  public boolean hasConnectedApi(@NonNull Api<?> paramApi)
  {
    throw this.zz;
  }

  public boolean isConnected()
  {
    throw this.zz;
  }

  public boolean isConnecting()
  {
    throw this.zz;
  }

  public boolean isConnectionCallbacksRegistered(@NonNull GoogleApiClient.ConnectionCallbacks paramConnectionCallbacks)
  {
    throw this.zz;
  }

  public boolean isConnectionFailedListenerRegistered(@NonNull GoogleApiClient.OnConnectionFailedListener paramOnConnectionFailedListener)
  {
    throw this.zz;
  }

  public void reconnect()
  {
    throw this.zz;
  }

  public void registerConnectionCallbacks(@NonNull GoogleApiClient.ConnectionCallbacks paramConnectionCallbacks)
  {
    throw this.zz;
  }

  public void registerConnectionFailedListener(@NonNull GoogleApiClient.OnConnectionFailedListener paramOnConnectionFailedListener)
  {
    throw this.zz;
  }

  public void stopAutoManage(@NonNull FragmentActivity paramFragmentActivity)
  {
    throw this.zz;
  }

  public void unregisterConnectionCallbacks(@NonNull GoogleApiClient.ConnectionCallbacks paramConnectionCallbacks)
  {
    throw this.zz;
  }

  public void unregisterConnectionFailedListener(@NonNull GoogleApiClient.OnConnectionFailedListener paramOnConnectionFailedListener)
  {
    throw this.zz;
  }
}

/* Location:           C:\Users\c_jealom1\Documents\Scripts\Android\Fathom_com.brynk.fathom\Fathom_com.brynk.fathom-dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.zzqz
 * JD-Core Version:    0.6.0
 */
package com.google.android.gms.common.internal;

import android.annotation.TargetApi;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Handler;
import android.os.Handler.Callback;
import android.os.IBinder;
import android.os.Message;
import com.google.android.gms.common.stats.zza;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

final class zzm extends zzl
  implements Handler.Callback
{
  private final HashMap<zza, zzb> En = new HashMap();
  private final zza Eo;
  private final long Ep;
  private final Handler mHandler;
  private final Context zzatc;

  zzm(Context paramContext)
  {
    this.zzatc = paramContext.getApplicationContext();
    this.mHandler = new Handler(paramContext.getMainLooper(), this);
    this.Eo = zza.zzaxr();
    this.Ep = 5000L;
  }

  private boolean zza(zza paramzza, ServiceConnection paramServiceConnection, String paramString)
  {
    zzaa.zzb(paramServiceConnection, "ServiceConnection must not be null");
    while (true)
    {
      zzb localzzb;
      synchronized (this.En)
      {
        localzzb = (zzb)this.En.get(paramzza);
        if (localzzb != null)
          continue;
        localzzb = new zzb(paramzza);
        localzzb.zza(paramServiceConnection, paramString);
        localzzb.zzhw(paramString);
        this.En.put(paramzza, localzzb);
        paramzza = localzzb;
        boolean bool = paramzza.isBound();
        return bool;
        this.mHandler.removeMessages(0, paramzza);
        if (localzzb.zza(paramServiceConnection))
        {
          paramzza = String.valueOf(paramzza);
          throw new IllegalStateException(String.valueOf(paramzza).length() + 81 + "Trying to bind a GmsServiceConnection that was already connected before.  config=" + paramzza);
        }
      }
      localzzb.zza(paramServiceConnection, paramString);
      switch (localzzb.getState())
      {
      case 1:
        paramServiceConnection.onServiceConnected(localzzb.getComponentName(), localzzb.getBinder());
        paramzza = localzzb;
        break;
      case 2:
        localzzb.zzhw(paramString);
        paramzza = localzzb;
        break;
      default:
        paramzza = localzzb;
      }
    }
  }

  private void zzb(zza paramzza, ServiceConnection paramServiceConnection, String paramString)
  {
    zzaa.zzb(paramServiceConnection, "ServiceConnection must not be null");
    zzb localzzb;
    synchronized (this.En)
    {
      localzzb = (zzb)this.En.get(paramzza);
      if (localzzb == null)
      {
        paramzza = String.valueOf(paramzza);
        throw new IllegalStateException(String.valueOf(paramzza).length() + 50 + "Nonexistent connection status for service config: " + paramzza);
      }
    }
    if (!localzzb.zza(paramServiceConnection))
    {
      paramzza = String.valueOf(paramzza);
      throw new IllegalStateException(String.valueOf(paramzza).length() + 76 + "Trying to unbind a GmsServiceConnection  that was not bound before.  config=" + paramzza);
    }
    localzzb.zzb(paramServiceConnection, paramString);
    if (localzzb.zzawf())
    {
      paramzza = this.mHandler.obtainMessage(0, paramzza);
      this.mHandler.sendMessageDelayed(paramzza, this.Ep);
    }
    monitorexit;
  }

  public boolean handleMessage(Message arg1)
  {
    switch (???.what)
    {
    default:
      return false;
    case 0:
    }
    zza localzza = (zza)???.obj;
    synchronized (this.En)
    {
      zzb localzzb = (zzb)this.En.get(localzza);
      if ((localzzb != null) && (localzzb.zzawf()))
      {
        if (localzzb.isBound())
          localzzb.zzhx("GmsClientSupervisor");
        this.En.remove(localzza);
      }
      return true;
    }
  }

  public boolean zza(ComponentName paramComponentName, ServiceConnection paramServiceConnection, String paramString)
  {
    return zza(new zza(paramComponentName), paramServiceConnection, paramString);
  }

  public boolean zza(String paramString1, String paramString2, ServiceConnection paramServiceConnection, String paramString3)
  {
    return zza(new zza(paramString1, paramString2), paramServiceConnection, paramString3);
  }

  public void zzb(ComponentName paramComponentName, ServiceConnection paramServiceConnection, String paramString)
  {
    zzb(new zza(paramComponentName), paramServiceConnection, paramString);
  }

  public void zzb(String paramString1, String paramString2, ServiceConnection paramServiceConnection, String paramString3)
  {
    zzb(new zza(paramString1, paramString2), paramServiceConnection, paramString3);
  }

  private static final class zza
  {
    private final String Eq;
    private final ComponentName Er;
    private final String cd;

    public zza(ComponentName paramComponentName)
    {
      this.cd = null;
      this.Eq = null;
      this.Er = ((ComponentName)zzaa.zzy(paramComponentName));
    }

    public zza(String paramString1, String paramString2)
    {
      this.cd = zzaa.zzib(paramString1);
      this.Eq = zzaa.zzib(paramString2);
      this.Er = null;
    }

    public boolean equals(Object paramObject)
    {
      if (this == paramObject);
      do
      {
        return true;
        if (!(paramObject instanceof zza))
          return false;
        paramObject = (zza)paramObject;
      }
      while ((zzz.equal(this.cd, paramObject.cd)) && (zzz.equal(this.Er, paramObject.Er)));
      return false;
    }

    public int hashCode()
    {
      return zzz.hashCode(new Object[] { this.cd, this.Er });
    }

    public String toString()
    {
      if (this.cd == null)
        return this.Er.flattenToString();
      return this.cd;
    }

    public Intent zzawe()
    {
      if (this.cd != null)
        return new Intent(this.cd).setPackage(this.Eq);
      return new Intent().setComponent(this.Er);
    }
  }

  private final class zzb
  {
    private IBinder DI;
    private ComponentName Er;
    private final zza Es;
    private final Set<ServiceConnection> Et;
    private boolean Eu;
    private final zzm.zza Ev;
    private int mState;

    public zzb(zzm.zza arg2)
    {
      Object localObject;
      this.Ev = localObject;
      this.Es = new zza();
      this.Et = new HashSet();
      this.mState = 2;
    }

    public IBinder getBinder()
    {
      return this.DI;
    }

    public ComponentName getComponentName()
    {
      return this.Er;
    }

    public int getState()
    {
      return this.mState;
    }

    public boolean isBound()
    {
      return this.Eu;
    }

    public void zza(ServiceConnection paramServiceConnection, String paramString)
    {
      zzm.zzc(zzm.this).zza(zzm.zzb(zzm.this), paramServiceConnection, paramString, this.Ev.zzawe());
      this.Et.add(paramServiceConnection);
    }

    public boolean zza(ServiceConnection paramServiceConnection)
    {
      return this.Et.contains(paramServiceConnection);
    }

    public boolean zzawf()
    {
      return this.Et.isEmpty();
    }

    public void zzb(ServiceConnection paramServiceConnection, String paramString)
    {
      zzm.zzc(zzm.this).zzb(zzm.zzb(zzm.this), paramServiceConnection);
      this.Et.remove(paramServiceConnection);
    }

    @TargetApi(14)
    public void zzhw(String paramString)
    {
      this.mState = 3;
      this.Eu = zzm.zzc(zzm.this).zza(zzm.zzb(zzm.this), paramString, this.Ev.zzawe(), this.Es, 129);
      if (!this.Eu)
        this.mState = 2;
      try
      {
        zzm.zzc(zzm.this).zza(zzm.zzb(zzm.this), this.Es);
        return;
      }
      catch (java.lang.IllegalArgumentException paramString)
      {
      }
    }

    public void zzhx(String paramString)
    {
      zzm.zzc(zzm.this).zza(zzm.zzb(zzm.this), this.Es);
      this.Eu = false;
      this.mState = 2;
    }

    public class zza
      implements ServiceConnection
    {
      public zza()
      {
      }

      public void onServiceConnected(ComponentName paramComponentName, IBinder paramIBinder)
      {
        synchronized (zzm.zza(zzm.this))
        {
          zzm.zzb.zza(zzm.zzb.this, paramIBinder);
          zzm.zzb.zza(zzm.zzb.this, paramComponentName);
          Iterator localIterator = zzm.zzb.zza(zzm.zzb.this).iterator();
          if (localIterator.hasNext())
            ((ServiceConnection)localIterator.next()).onServiceConnected(paramComponentName, paramIBinder);
        }
        zzm.zzb.zza(zzm.zzb.this, 1);
        monitorexit;
      }

      public void onServiceDisconnected(ComponentName paramComponentName)
      {
        synchronized (zzm.zza(zzm.this))
        {
          zzm.zzb.zza(zzm.zzb.this, null);
          zzm.zzb.zza(zzm.zzb.this, paramComponentName);
          Iterator localIterator = zzm.zzb.zza(zzm.zzb.this).iterator();
          if (localIterator.hasNext())
            ((ServiceConnection)localIterator.next()).onServiceDisconnected(paramComponentName);
        }
        zzm.zzb.zza(zzm.zzb.this, 2);
        monitorexit;
      }
    }
  }
}

/* Location:           C:\Users\c_jealom1\Documents\Scripts\Android\Fathom_com.brynk.fathom\Fathom_com.brynk.fathom-dex2jar.jar
 * Qualified Name:     com.google.android.gms.common.internal.zzm
 * JD-Core Version:    0.6.0
 */
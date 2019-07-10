package com.google.android.gms.common.internal;

import android.accounts.Account;
import android.app.PendingIntent;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.DeadObjectException;
import android.os.Handler;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Looper;
import android.os.Message;
import android.os.RemoteException;
import android.support.annotation.BinderThread;
import android.support.annotation.CallSuper;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.annotation.WorkerThread;
import android.util.Log;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.CommonStatusCodes;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.common.zzc;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.Locale;
import java.util.Set;
import java.util.concurrent.atomic.AtomicInteger;

public abstract class zze<T extends IInterface>
{
  public static final String[] DB = { "service_esmobile", "service_googleme" };
  protected AtomicInteger DA = new AtomicInteger(0);
  private int Dj;
  private long Dk;
  private long Dl;
  private int Dm;
  private long Dn;
  private final zzl Do;
  private final Object Dp = new Object();
  private zzt Dq;
  protected zzf Dr;
  private T Ds;
  private final ArrayList<zze<?>> Dt = new ArrayList();
  private zzh Du;
  private int Dv = 1;
  private final zzb Dw;
  private final zzc Dx;
  private final int Dy;
  private final String Dz;
  private final Context mContext;
  final Handler mHandler;
  private final zzc zm;
  private final Looper zzajy;
  private final Object zzako = new Object();

  protected zze(Context paramContext, Looper paramLooper, int paramInt, zzb paramzzb, zzc paramzzc, String paramString)
  {
    this(paramContext, paramLooper, zzl.zzcc(paramContext), zzc.zzaql(), paramInt, (zzb)zzaa.zzy(paramzzb), (zzc)zzaa.zzy(paramzzc), paramString);
  }

  protected zze(Context paramContext, Looper paramLooper, zzl paramzzl, zzc paramzzc, int paramInt, zzb paramzzb, zzc paramzzc1, String paramString)
  {
    this.mContext = ((Context)zzaa.zzb(paramContext, "Context must not be null"));
    this.zzajy = ((Looper)zzaa.zzb(paramLooper, "Looper must not be null"));
    this.Do = ((zzl)zzaa.zzb(paramzzl, "Supervisor must not be null"));
    this.zm = ((zzc)zzaa.zzb(paramzzc, "API availability must not be null"));
    this.mHandler = new zzd(paramLooper);
    this.Dy = paramInt;
    this.Dw = paramzzb;
    this.Dx = paramzzc1;
    this.Dz = paramString;
  }

  private boolean zza(int paramInt1, int paramInt2, T paramT)
  {
    synchronized (this.zzako)
    {
      if (this.Dv != paramInt1)
        return false;
      zzb(paramInt2, paramT);
      return true;
    }
  }

  private void zzavb()
  {
    String str1;
    String str2;
    if (this.Du != null)
    {
      str1 = String.valueOf(zzjx());
      str2 = String.valueOf(zzauz());
      Log.e("GmsClient", String.valueOf(str1).length() + 70 + String.valueOf(str2).length() + "Calling connect() while still connected, missing disconnect() for " + str1 + " on " + str2);
      this.Do.zzb(zzjx(), zzauz(), this.Du, zzava());
      this.DA.incrementAndGet();
    }
    this.Du = new zzh(this.DA.get());
    if (!this.Do.zza(zzjx(), zzauz(), this.Du, zzava()))
    {
      str1 = String.valueOf(zzjx());
      str2 = String.valueOf(zzauz());
      Log.e("GmsClient", String.valueOf(str1).length() + 34 + String.valueOf(str2).length() + "unable to connect to service: " + str1 + " on " + str2);
      zza(16, null, this.DA.get());
    }
  }

  private void zzavc()
  {
    if (this.Du != null)
    {
      this.Do.zzb(zzjx(), zzauz(), this.Du, zzava());
      this.Du = null;
    }
  }

  private void zzb(int paramInt, T paramT)
  {
    boolean bool = true;
    int i;
    int j;
    if (paramInt == 3)
    {
      i = 1;
      if (paramT == null)
        break label120;
      j = 1;
      label17: if (i != j)
        break label126;
    }
    while (true)
    {
      zzaa.zzbt(bool);
      while (true)
      {
        synchronized (this.zzako)
        {
          this.Dv = paramInt;
          this.Ds = paramT;
          zzc(paramInt, paramT);
          switch (paramInt)
          {
          case 2:
            return;
            zzavb();
          case 3:
          case 1:
          }
        }
        zza(paramT);
        continue;
        zzavc();
        continue;
      }
      i = 0;
      break;
      label120: j = 0;
      break label17;
      label126: bool = false;
    }
  }

  private void zzl(ConnectionResult paramConnectionResult)
  {
    this.mHandler.sendMessage(this.mHandler.obtainMessage(3, this.DA.get(), paramConnectionResult.getErrorCode(), paramConnectionResult.getResolution()));
  }

  public void disconnect()
  {
    this.DA.incrementAndGet();
    synchronized (this.Dt)
    {
      int j = this.Dt.size();
      int i = 0;
      while (i < j)
      {
        ((zze)this.Dt.get(i)).zzavm();
        i += 1;
      }
      this.Dt.clear();
    }
    synchronized (this.Dp)
    {
      this.Dq = null;
      zzb(1, null);
      return;
      localObject2 = finally;
      throw localObject2;
    }
  }

  public void dump(String paramString, FileDescriptor arg2, PrintWriter paramPrintWriter, String[] paramArrayOfString)
  {
    while (true)
    {
      synchronized (this.zzako)
      {
        int i = this.Dv;
        paramArrayOfString = this.Ds;
        paramPrintWriter.append(paramString).append("mConnectState=");
        switch (i)
        {
        default:
          paramPrintWriter.print("UNKNOWN");
          paramPrintWriter.append(" mService=");
          if (paramArrayOfString != null)
            break label482;
          paramPrintWriter.println("null");
          ??? = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS", Locale.US);
          if (this.Dl <= 0L)
            continue;
          paramArrayOfString = paramPrintWriter.append(paramString).append("lastConnectedTime=");
          long l = this.Dl;
          String str = String.valueOf(???.format(new Date(this.Dl)));
          paramArrayOfString.println(String.valueOf(str).length() + 21 + l + " " + str);
          if (this.Dk <= 0L)
            continue;
          paramPrintWriter.append(paramString).append("lastSuspendedCause=");
          switch (this.Dj)
          {
          default:
            paramPrintWriter.append(String.valueOf(this.Dj));
            paramArrayOfString = paramPrintWriter.append(" lastSuspendedTime=");
            l = this.Dk;
            str = String.valueOf(???.format(new Date(this.Dk)));
            paramArrayOfString.println(String.valueOf(str).length() + 21 + l + " " + str);
            if (this.Dn <= 0L)
              continue;
            paramPrintWriter.append(paramString).append("lastFailedStatus=").append(CommonStatusCodes.getStatusCodeString(this.Dm));
            paramString = paramPrintWriter.append(" lastFailedTime=");
            l = this.Dn;
            ??? = String.valueOf(???.format(new Date(this.Dn)));
            paramString.println(String.valueOf(???).length() + 21 + l + " " + ???);
            return;
          case 1:
          case 2:
          }
        case 2:
        case 3:
        case 4:
        case 1:
        }
      }
      paramPrintWriter.print("CONNECTING");
      continue;
      paramPrintWriter.print("CONNECTED");
      continue;
      paramPrintWriter.print("DISCONNECTING");
      continue;
      paramPrintWriter.print("DISCONNECTED");
      continue;
      label482: paramPrintWriter.append(zzjy()).append("@").println(Integer.toHexString(System.identityHashCode(paramArrayOfString.asBinder())));
      continue;
      paramPrintWriter.append("CAUSE_SERVICE_DISCONNECTED");
      continue;
      paramPrintWriter.append("CAUSE_NETWORK_LOST");
    }
  }

  public Account getAccount()
  {
    return null;
  }

  public final Context getContext()
  {
    return this.mContext;
  }

  public final Looper getLooper()
  {
    return this.zzajy;
  }

  public boolean isConnected()
  {
    while (true)
    {
      synchronized (this.zzako)
      {
        if (this.Dv == 3)
        {
          i = 1;
          return i;
        }
      }
      int i = 0;
    }
  }

  public boolean isConnecting()
  {
    while (true)
    {
      synchronized (this.zzako)
      {
        if (this.Dv == 2)
        {
          i = 1;
          return i;
        }
      }
      int i = 0;
    }
  }

  @CallSuper
  protected void onConnectionFailed(ConnectionResult paramConnectionResult)
  {
    this.Dm = paramConnectionResult.getErrorCode();
    this.Dn = System.currentTimeMillis();
  }

  @CallSuper
  protected void onConnectionSuspended(int paramInt)
  {
    this.Dj = paramInt;
    this.Dk = System.currentTimeMillis();
  }

  protected void zza(int paramInt1, @Nullable Bundle paramBundle, int paramInt2)
  {
    this.mHandler.sendMessage(this.mHandler.obtainMessage(5, paramInt2, -1, new zzk(paramInt1, paramBundle)));
  }

  @BinderThread
  protected void zza(int paramInt1, IBinder paramIBinder, Bundle paramBundle, int paramInt2)
  {
    this.mHandler.sendMessage(this.mHandler.obtainMessage(1, paramInt2, -1, new zzj(paramInt1, paramIBinder, paramBundle)));
  }

  @CallSuper
  protected void zza(@NonNull T paramT)
  {
    this.Dl = System.currentTimeMillis();
  }

  public void zza(@NonNull zzf paramzzf)
  {
    this.Dr = ((zzf)zzaa.zzb(paramzzf, "Connection progress callbacks cannot be null."));
    zzb(2, null);
  }

  public void zza(zzf paramzzf, ConnectionResult paramConnectionResult)
  {
    this.Dr = ((zzf)zzaa.zzb(paramzzf, "Connection progress callbacks cannot be null."));
    this.mHandler.sendMessage(this.mHandler.obtainMessage(3, this.DA.get(), paramConnectionResult.getErrorCode(), paramConnectionResult.getResolution()));
  }

  @WorkerThread
  public void zza(zzp arg1, Set<Scope> paramSet)
  {
    Object localObject = zzahv();
    localObject = new GetServiceRequest(this.Dy).zzhv(this.mContext.getPackageName()).zzo((Bundle)localObject);
    if (paramSet != null)
      ((GetServiceRequest)localObject).zzf(paramSet);
    if (zzain())
      ((GetServiceRequest)localObject).zze(zzave()).zzb(???);
    try
    {
      synchronized (this.Dp)
      {
        while (this.Dq != null)
        {
          this.Dq.zza(new zzg(this, this.DA.get()), (GetServiceRequest)localObject);
          return;
          if (!zzavh())
            continue;
          ((GetServiceRequest)localObject).zze(getAccount());
        }
        Log.w("GmsClient", "mServiceBroker is null, client disconnected");
      }
    }
    catch (DeadObjectException )
    {
      Log.w("GmsClient", "service died");
      zzgk(1);
      return;
    }
    catch (RemoteException )
    {
      Log.w("GmsClient", "Remote exception occurred", ???);
      return;
    }
    catch (java.lang.SecurityException )
    {
      throw ???;
    }
    catch (java.lang.RuntimeException )
    {
      Log.w("GmsClient", "IGmsServiceBroker.getService failed", ???);
      zzl(new ConnectionResult(8, null, "IGmsServiceBroker.getService failed."));
    }
  }

  protected Bundle zzahv()
  {
    return new Bundle();
  }

  public boolean zzain()
  {
    return false;
  }

  public boolean zzajc()
  {
    return false;
  }

  public Intent zzajd()
  {
    throw new UnsupportedOperationException("Not a sign in API");
  }

  public Bundle zzapn()
  {
    return null;
  }

  public boolean zzaqx()
  {
    return true;
  }

  @Nullable
  public IBinder zzaqy()
  {
    synchronized (this.Dp)
    {
      if (this.Dq == null)
        return null;
      IBinder localIBinder = this.Dq.asBinder();
      return localIBinder;
    }
  }

  protected String zzauz()
  {
    return "com.google.android.gms";
  }

  @Nullable
  protected final String zzava()
  {
    if (this.Dz == null)
      return this.mContext.getClass().getName();
    return this.Dz;
  }

  public void zzavd()
  {
    int i = this.zm.isGooglePlayServicesAvailable(this.mContext);
    if (i != 0)
    {
      zzb(1, null);
      this.Dr = new zzi();
      this.mHandler.sendMessage(this.mHandler.obtainMessage(3, this.DA.get(), i));
      return;
    }
    zza(new zzi());
  }

  public final Account zzave()
  {
    if (getAccount() != null)
      return getAccount();
    return new Account("<<default account>>", "com.google");
  }

  protected final void zzavf()
  {
    if (!isConnected())
      throw new IllegalStateException("Not connected. Call connect() and wait for onConnected() to be called.");
  }

  public final T zzavg()
    throws DeadObjectException
  {
    synchronized (this.zzako)
    {
      if (this.Dv == 4)
        throw new DeadObjectException();
    }
    zzavf();
    if (this.Ds != null);
    for (boolean bool = true; ; bool = false)
    {
      zzaa.zza(bool, "Client is connected but service is null");
      IInterface localIInterface = this.Ds;
      monitorexit;
      return localIInterface;
    }
  }

  public boolean zzavh()
  {
    return false;
  }

  protected Set<Scope> zzavi()
  {
    return Collections.EMPTY_SET;
  }

  void zzc(int paramInt, T paramT)
  {
  }

  public void zzgk(int paramInt)
  {
    this.mHandler.sendMessage(this.mHandler.obtainMessage(4, this.DA.get(), paramInt));
  }

  @Nullable
  protected abstract T zzh(IBinder paramIBinder);

  @NonNull
  protected abstract String zzjx();

  @NonNull
  protected abstract String zzjy();

  private abstract class zza extends zze.zze<Boolean>
  {
    public final Bundle DC;
    public final int statusCode;

    @BinderThread
    protected zza(int paramBundle, Bundle arg3)
    {
      super(Boolean.valueOf(true));
      this.statusCode = paramBundle;
      Object localObject;
      this.DC = localObject;
    }

    protected abstract boolean zzavj();

    protected void zzavk()
    {
    }

    protected void zzc(Boolean paramBoolean)
    {
      Object localObject = null;
      if (paramBoolean == null)
        zze.zza(zze.this, 1, null);
      do
      {
        return;
        switch (this.statusCode)
        {
        default:
          zze.zza(zze.this, 1, null);
          paramBoolean = localObject;
          if (this.DC != null)
            paramBoolean = (PendingIntent)this.DC.getParcelable("pendingIntent");
          zzm(new ConnectionResult(this.statusCode, paramBoolean));
          return;
        case 0:
        case 10:
        }
      }
      while (zzavj());
      zze.zza(zze.this, 1, null);
      zzm(new ConnectionResult(8, null));
      return;
      zze.zza(zze.this, 1, null);
      throw new IllegalStateException("A fatal developer error has occurred. Check the logs for further information.");
    }

    protected abstract void zzm(ConnectionResult paramConnectionResult);
  }

  public static abstract interface zzb
  {
    public abstract void onConnected(@Nullable Bundle paramBundle);

    public abstract void onConnectionSuspended(int paramInt);
  }

  public static abstract interface zzc
  {
    public abstract void onConnectionFailed(@NonNull ConnectionResult paramConnectionResult);
  }

  final class zzd extends Handler
  {
    public zzd(Looper arg2)
    {
      super();
    }

    private void zza(Message paramMessage)
    {
      paramMessage = (zze.zze)paramMessage.obj;
      paramMessage.zzavk();
      paramMessage.unregister();
    }

    private boolean zzb(Message paramMessage)
    {
      return (paramMessage.what == 2) || (paramMessage.what == 1) || (paramMessage.what == 5);
    }

    public void handleMessage(Message paramMessage)
    {
      PendingIntent localPendingIntent = null;
      if (zze.this.DA.get() != paramMessage.arg1)
      {
        if (zzb(paramMessage))
          zza(paramMessage);
        return;
      }
      if (((paramMessage.what == 1) || (paramMessage.what == 5)) && (!zze.this.isConnecting()))
      {
        zza(paramMessage);
        return;
      }
      if (paramMessage.what == 3)
      {
        if ((paramMessage.obj instanceof PendingIntent))
          localPendingIntent = (PendingIntent)paramMessage.obj;
        paramMessage = new ConnectionResult(paramMessage.arg2, localPendingIntent);
        zze.this.Dr.zzg(paramMessage);
        zze.this.onConnectionFailed(paramMessage);
        return;
      }
      if (paramMessage.what == 4)
      {
        zze.zza(zze.this, 4, null);
        if (zze.zzb(zze.this) != null)
          zze.zzb(zze.this).onConnectionSuspended(paramMessage.arg2);
        zze.this.onConnectionSuspended(paramMessage.arg2);
        zze.zza(zze.this, 4, 1, null);
        return;
      }
      if ((paramMessage.what == 2) && (!zze.this.isConnected()))
      {
        zza(paramMessage);
        return;
      }
      if (zzb(paramMessage))
      {
        ((zze.zze)paramMessage.obj).zzavl();
        return;
      }
      int i = paramMessage.what;
      Log.wtf("GmsClient", 45 + "Don't know how to handle message: " + i, new Exception());
    }
  }

  protected abstract class zze<TListener>
  {
    private boolean DE;
    private TListener mListener;

    public zze()
    {
      Object localObject;
      this.mListener = localObject;
      this.DE = false;
    }

    public void unregister()
    {
      zzavm();
      synchronized (zze.zzc(zze.this))
      {
        zze.zzc(zze.this).remove(this);
        return;
      }
    }

    protected abstract void zzavk();

    // ERROR //
    public void zzavl()
    {
      // Byte code:
      //   0: aload_0
      //   1: monitorenter
      //   2: aload_0
      //   3: getfield 24	com/google/android/gms/common/internal/zze$zze:mListener	Ljava/lang/Object;
      //   6: astore_1
      //   7: aload_0
      //   8: getfield 26	com/google/android/gms/common/internal/zze$zze:DE	Z
      //   11: ifeq +48 -> 59
      //   14: aload_0
      //   15: invokestatic 53	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
      //   18: astore_2
      //   19: ldc 55
      //   21: new 57	java/lang/StringBuilder
      //   24: dup
      //   25: aload_2
      //   26: invokestatic 53	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
      //   29: invokevirtual 61	java/lang/String:length	()I
      //   32: bipush 47
      //   34: iadd
      //   35: invokespecial 64	java/lang/StringBuilder:<init>	(I)V
      //   38: ldc 66
      //   40: invokevirtual 70	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   43: aload_2
      //   44: invokevirtual 70	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   47: ldc 72
      //   49: invokevirtual 70	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   52: invokevirtual 76	java/lang/StringBuilder:toString	()Ljava/lang/String;
      //   55: invokestatic 82	android/util/Log:w	(Ljava/lang/String;Ljava/lang/String;)I
      //   58: pop
      //   59: aload_0
      //   60: monitorexit
      //   61: aload_1
      //   62: ifnull +34 -> 96
      //   65: aload_0
      //   66: aload_1
      //   67: invokevirtual 86	com/google/android/gms/common/internal/zze$zze:zzv	(Ljava/lang/Object;)V
      //   70: aload_0
      //   71: monitorenter
      //   72: aload_0
      //   73: iconst_1
      //   74: putfield 26	com/google/android/gms/common/internal/zze$zze:DE	Z
      //   77: aload_0
      //   78: monitorexit
      //   79: aload_0
      //   80: invokevirtual 88	com/google/android/gms/common/internal/zze$zze:unregister	()V
      //   83: return
      //   84: astore_1
      //   85: aload_0
      //   86: monitorexit
      //   87: aload_1
      //   88: athrow
      //   89: astore_1
      //   90: aload_0
      //   91: invokevirtual 90	com/google/android/gms/common/internal/zze$zze:zzavk	()V
      //   94: aload_1
      //   95: athrow
      //   96: aload_0
      //   97: invokevirtual 90	com/google/android/gms/common/internal/zze$zze:zzavk	()V
      //   100: goto -30 -> 70
      //   103: astore_1
      //   104: aload_0
      //   105: monitorexit
      //   106: aload_1
      //   107: athrow
      //
      // Exception table:
      //   from	to	target	type
      //   2	59	84	finally
      //   59	61	84	finally
      //   85	87	84	finally
      //   65	70	89	java/lang/RuntimeException
      //   72	79	103	finally
      //   104	106	103	finally
    }

    public void zzavm()
    {
      monitorenter;
      try
      {
        this.mListener = null;
        return;
      }
      finally
      {
        monitorexit;
      }
      throw localObject;
    }

    protected abstract void zzv(TListener paramTListener);
  }

  public static abstract interface zzf
  {
    public abstract void zzg(@NonNull ConnectionResult paramConnectionResult);
  }

  public static final class zzg extends zzs.zza
  {
    private zze DF;
    private final int DG;

    public zzg(@NonNull zze paramzze, int paramInt)
    {
      this.DF = paramzze;
      this.DG = paramInt;
    }

    private void zzavn()
    {
      this.DF = null;
    }

    @BinderThread
    public void zza(int paramInt, @NonNull IBinder paramIBinder, @Nullable Bundle paramBundle)
    {
      zzaa.zzb(this.DF, "onPostInitComplete can be called only once per call to getRemoteService");
      this.DF.zza(paramInt, paramIBinder, paramBundle, this.DG);
      zzavn();
    }

    @BinderThread
    public void zzb(int paramInt, @Nullable Bundle paramBundle)
    {
      Log.wtf("GmsClient", "received deprecated onAccountValidationComplete callback, ignoring", new Exception());
    }
  }

  public final class zzh
    implements ServiceConnection
  {
    private final int DG;

    public zzh(int arg2)
    {
      int i;
      this.DG = i;
    }

    public void onServiceConnected(ComponentName arg1, IBinder paramIBinder)
    {
      if (paramIBinder == null)
      {
        zze.zza(zze.this, new ConnectionResult(8, null, "ServiceBroker IBinder is null"));
        return;
      }
      synchronized (zze.zza(zze.this))
      {
        zze.zza(zze.this, zzt.zza.zzdu(paramIBinder));
        zze.this.zza(0, null, this.DG);
        return;
      }
    }

    public void onServiceDisconnected(ComponentName arg1)
    {
      synchronized (zze.zza(zze.this))
      {
        zze.zza(zze.this, null);
        zze.this.mHandler.sendMessage(zze.this.mHandler.obtainMessage(4, this.DG, 1));
        return;
      }
    }
  }

  protected class zzi
    implements zze.zzf
  {
    public zzi()
    {
    }

    public void zzg(@NonNull ConnectionResult paramConnectionResult)
    {
      if (paramConnectionResult.isSuccess())
        zze.this.zza(null, zze.this.zzavi());
      do
        return;
      while (zze.zzd(zze.this) == null);
      zze.zzd(zze.this).onConnectionFailed(paramConnectionResult);
    }
  }

  protected final class zzj extends zze.zza
  {
    public final IBinder DH;

    @BinderThread
    public zzj(int paramIBinder, IBinder paramBundle, Bundle arg4)
    {
      super(paramIBinder, localBundle);
      this.DH = paramBundle;
    }

    protected boolean zzavj()
    {
      do
      {
        try
        {
          String str1 = this.DH.getInterfaceDescriptor();
          if (!zze.this.zzjy().equals(str1))
          {
            String str2 = String.valueOf(zze.this.zzjy());
            Log.e("GmsClient", String.valueOf(str2).length() + 34 + String.valueOf(str1).length() + "service descriptor mismatch: " + str2 + " vs. " + str1);
            return false;
          }
        }
        catch (RemoteException localRemoteException)
        {
          Log.w("GmsClient", "service probably died");
          return false;
        }
        localObject = zze.this.zzh(this.DH);
      }
      while ((localObject == null) || (!zze.zza(zze.this, 2, 3, (IInterface)localObject)));
      Object localObject = zze.this.zzapn();
      if (zze.zzb(zze.this) != null)
        zze.zzb(zze.this).onConnected((Bundle)localObject);
      return true;
    }

    protected void zzm(ConnectionResult paramConnectionResult)
    {
      if (zze.zzd(zze.this) != null)
        zze.zzd(zze.this).onConnectionFailed(paramConnectionResult);
      zze.this.onConnectionFailed(paramConnectionResult);
    }
  }

  protected final class zzk extends zze.zza
  {
    @BinderThread
    public zzk(int paramBundle, @Nullable Bundle arg3)
    {
      super(paramBundle, localBundle);
    }

    protected boolean zzavj()
    {
      zze.this.Dr.zzg(ConnectionResult.wO);
      return true;
    }

    protected void zzm(ConnectionResult paramConnectionResult)
    {
      zze.this.Dr.zzg(paramConnectionResult);
      zze.this.onConnectionFailed(paramConnectionResult);
    }
  }
}

/* Location:           C:\Users\c_jealom1\Documents\Scripts\Android\Fathom_com.brynk.fathom\Fathom_com.brynk.fathom-dex2jar.jar
 * Qualified Name:     com.google.android.gms.common.internal.zze
 * JD-Core Version:    0.6.0
 */
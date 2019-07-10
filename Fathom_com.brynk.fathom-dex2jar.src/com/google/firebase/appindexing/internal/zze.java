package com.google.firebase.appindexing.internal;

import android.content.Context;
import android.os.RemoteException;
import com.google.android.gms.common.api.Api.ApiOptions.NoOptions;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.zzc;
import com.google.android.gms.common.internal.zzaa;
import com.google.android.gms.internal.zznf;
import com.google.android.gms.internal.zzni;
import com.google.android.gms.internal.zznk.zzd;
import com.google.android.gms.internal.zzqo.zzb;
import com.google.android.gms.internal.zzse;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.TaskCompletionSource;
import com.google.android.gms.tasks.Tasks;
import com.google.firebase.appindexing.Action;
import com.google.firebase.appindexing.FirebaseAppIndexingInvalidArgumentException;
import com.google.firebase.appindexing.FirebaseUserActions;

public final class zze extends FirebaseUserActions
{
  private zza aWP;

  public zze(Context paramContext)
  {
    this.aWP = new zza(paramContext);
  }

  private Task<Void> zza(int paramInt, Action paramAction)
  {
    if (!(paramAction instanceof ActionImpl))
      return Tasks.forException(new FirebaseAppIndexingInvalidArgumentException("Custom Action objects are not allowed. Please use the 'Actions' or 'ActionBuilder' class for creating Action objects."));
    ActionImpl[] arrayOfActionImpl = new ActionImpl[1];
    arrayOfActionImpl[0] = ((ActionImpl)paramAction);
    arrayOfActionImpl[0].zzcof().zzaey(paramInt);
    return this.aWP.doWrite(new zzb(arrayOfActionImpl)
    {
      protected void zza(zznf paramzznf)
        throws RemoteException
      {
        paramzznf.zza(new zznk.zzd(this), this.aWQ);
      }
    });
  }

  public Task<Void> end(Action paramAction)
  {
    return zza(2, paramAction);
  }

  public Task<Void> start(Action paramAction)
  {
    return zza(1, paramAction);
  }

  private static class zza extends zzc<Api.ApiOptions.NoOptions>
  {
    zza(Context paramContext)
    {
      super(com.google.android.gms.appdatasearch.zza.gb, null, new com.google.firebase.zza());
    }
  }

  private static abstract class zzb extends zzse<zzni, Void>
    implements zzqo.zzb<Status>
  {
    protected TaskCompletionSource<Void> yg;

    protected abstract void zza(zznf paramzznf)
      throws RemoteException;

    protected final void zza(zzni paramzzni, TaskCompletionSource<Void> paramTaskCompletionSource)
      throws RemoteException
    {
      this.yg = paramTaskCompletionSource;
      zza((zznf)paramzzni.zzavg());
    }

    public void zzaa(Status paramStatus)
    {
      if (!paramStatus.isSuccess());
      for (boolean bool = true; ; bool = false)
      {
        zzaa.zzb(bool, "Failed result must not be success.");
        zzfb(paramStatus);
        return;
      }
    }

    public void zzfb(Status paramStatus)
    {
      if (paramStatus.isSuccess())
      {
        this.yg.setResult(null);
        return;
      }
      this.yg.setException(zzl.zzb(paramStatus, "User Action indexing error, please try again."));
    }
  }
}

/* Location:           C:\Users\c_jealom1\Documents\Scripts\Android\Fathom_com.brynk.fathom\Fathom_com.brynk.fathom-dex2jar.jar
 * Qualified Name:     com.google.firebase.appindexing.internal.zze
 * JD-Core Version:    0.6.0
 */
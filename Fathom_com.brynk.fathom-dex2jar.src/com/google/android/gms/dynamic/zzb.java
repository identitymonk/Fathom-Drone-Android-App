package com.google.android.gms.dynamic;

import android.annotation.SuppressLint;
import android.app.Fragment;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

@SuppressLint({"NewApi"})
public final class zzb extends zzc.zza
{
  private Fragment Qd;

  private zzb(Fragment paramFragment)
  {
    this.Qd = paramFragment;
  }

  public static zzb zza(Fragment paramFragment)
  {
    if (paramFragment != null)
      return new zzb(paramFragment);
    return null;
  }

  public Bundle getArguments()
  {
    return this.Qd.getArguments();
  }

  public int getId()
  {
    return this.Qd.getId();
  }

  public boolean getRetainInstance()
  {
    return this.Qd.getRetainInstance();
  }

  public String getTag()
  {
    return this.Qd.getTag();
  }

  public int getTargetRequestCode()
  {
    return this.Qd.getTargetRequestCode();
  }

  public boolean getUserVisibleHint()
  {
    return this.Qd.getUserVisibleHint();
  }

  public zzd getView()
  {
    return zze.zzac(this.Qd.getView());
  }

  public boolean isAdded()
  {
    return this.Qd.isAdded();
  }

  public boolean isDetached()
  {
    return this.Qd.isDetached();
  }

  public boolean isHidden()
  {
    return this.Qd.isHidden();
  }

  public boolean isInLayout()
  {
    return this.Qd.isInLayout();
  }

  public boolean isRemoving()
  {
    return this.Qd.isRemoving();
  }

  public boolean isResumed()
  {
    return this.Qd.isResumed();
  }

  public boolean isVisible()
  {
    return this.Qd.isVisible();
  }

  public void setHasOptionsMenu(boolean paramBoolean)
  {
    this.Qd.setHasOptionsMenu(paramBoolean);
  }

  public void setMenuVisibility(boolean paramBoolean)
  {
    this.Qd.setMenuVisibility(paramBoolean);
  }

  public void setRetainInstance(boolean paramBoolean)
  {
    this.Qd.setRetainInstance(paramBoolean);
  }

  public void setUserVisibleHint(boolean paramBoolean)
  {
    this.Qd.setUserVisibleHint(paramBoolean);
  }

  public void startActivity(Intent paramIntent)
  {
    this.Qd.startActivity(paramIntent);
  }

  public void startActivityForResult(Intent paramIntent, int paramInt)
  {
    this.Qd.startActivityForResult(paramIntent, paramInt);
  }

  public void zzac(zzd paramzzd)
  {
    paramzzd = (View)zze.zzae(paramzzd);
    this.Qd.registerForContextMenu(paramzzd);
  }

  public void zzad(zzd paramzzd)
  {
    paramzzd = (View)zze.zzae(paramzzd);
    this.Qd.unregisterForContextMenu(paramzzd);
  }

  public zzd zzbdp()
  {
    return zze.zzac(this.Qd.getActivity());
  }

  public zzc zzbdq()
  {
    return zza(this.Qd.getParentFragment());
  }

  public zzd zzbdr()
  {
    return zze.zzac(this.Qd.getResources());
  }

  public zzc zzbds()
  {
    return zza(this.Qd.getTargetFragment());
  }
}

/* Location:           C:\Users\c_jealom1\Documents\Scripts\Android\Fathom_com.brynk.fathom\Fathom_com.brynk.fathom-dex2jar.jar
 * Qualified Name:     com.google.android.gms.dynamic.zzb
 * JD-Core Version:    0.6.0
 */
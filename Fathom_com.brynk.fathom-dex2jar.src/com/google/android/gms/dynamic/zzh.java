package com.google.android.gms.dynamic;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.View;

public final class zzh extends zzc.zza
{
  private Fragment Qg;

  private zzh(Fragment paramFragment)
  {
    this.Qg = paramFragment;
  }

  public static zzh zza(Fragment paramFragment)
  {
    if (paramFragment != null)
      return new zzh(paramFragment);
    return null;
  }

  public Bundle getArguments()
  {
    return this.Qg.getArguments();
  }

  public int getId()
  {
    return this.Qg.getId();
  }

  public boolean getRetainInstance()
  {
    return this.Qg.getRetainInstance();
  }

  public String getTag()
  {
    return this.Qg.getTag();
  }

  public int getTargetRequestCode()
  {
    return this.Qg.getTargetRequestCode();
  }

  public boolean getUserVisibleHint()
  {
    return this.Qg.getUserVisibleHint();
  }

  public zzd getView()
  {
    return zze.zzac(this.Qg.getView());
  }

  public boolean isAdded()
  {
    return this.Qg.isAdded();
  }

  public boolean isDetached()
  {
    return this.Qg.isDetached();
  }

  public boolean isHidden()
  {
    return this.Qg.isHidden();
  }

  public boolean isInLayout()
  {
    return this.Qg.isInLayout();
  }

  public boolean isRemoving()
  {
    return this.Qg.isRemoving();
  }

  public boolean isResumed()
  {
    return this.Qg.isResumed();
  }

  public boolean isVisible()
  {
    return this.Qg.isVisible();
  }

  public void setHasOptionsMenu(boolean paramBoolean)
  {
    this.Qg.setHasOptionsMenu(paramBoolean);
  }

  public void setMenuVisibility(boolean paramBoolean)
  {
    this.Qg.setMenuVisibility(paramBoolean);
  }

  public void setRetainInstance(boolean paramBoolean)
  {
    this.Qg.setRetainInstance(paramBoolean);
  }

  public void setUserVisibleHint(boolean paramBoolean)
  {
    this.Qg.setUserVisibleHint(paramBoolean);
  }

  public void startActivity(Intent paramIntent)
  {
    this.Qg.startActivity(paramIntent);
  }

  public void startActivityForResult(Intent paramIntent, int paramInt)
  {
    this.Qg.startActivityForResult(paramIntent, paramInt);
  }

  public void zzac(zzd paramzzd)
  {
    paramzzd = (View)zze.zzae(paramzzd);
    this.Qg.registerForContextMenu(paramzzd);
  }

  public void zzad(zzd paramzzd)
  {
    paramzzd = (View)zze.zzae(paramzzd);
    this.Qg.unregisterForContextMenu(paramzzd);
  }

  public zzd zzbdp()
  {
    return zze.zzac(this.Qg.getActivity());
  }

  public zzc zzbdq()
  {
    return zza(this.Qg.getParentFragment());
  }

  public zzd zzbdr()
  {
    return zze.zzac(this.Qg.getResources());
  }

  public zzc zzbds()
  {
    return zza(this.Qg.getTargetFragment());
  }
}

/* Location:           C:\Users\c_jealom1\Documents\Scripts\Android\Fathom_com.brynk.fathom\Fathom_com.brynk.fathom-dex2jar.jar
 * Qualified Name:     com.google.android.gms.dynamic.zzh
 * JD-Core Version:    0.6.0
 */
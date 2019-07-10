package com.google.android.gms.dynamic;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.VisibleForTesting;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.google.android.gms.common.GoogleApiAvailability;
import com.google.android.gms.common.internal.zzg;
import java.util.Iterator;
import java.util.LinkedList;

public abstract class zza<T extends LifecycleDelegate>
{
  private T PT;
  private Bundle PU;
  private LinkedList<zza> PV;
  private final zzf<T> PW = new zzf()
  {
    public void zza(T paramT)
    {
      zza.zza(zza.this, paramT);
      paramT = zza.zza(zza.this).iterator();
      while (paramT.hasNext())
        ((zza.zza)paramT.next()).zzb(zza.zzb(zza.this));
      zza.zza(zza.this).clear();
      zza.zza(zza.this, null);
    }
  };

  private void zza(Bundle paramBundle, zza paramzza)
  {
    if (this.PT != null)
    {
      paramzza.zzb(this.PT);
      return;
    }
    if (this.PV == null)
      this.PV = new LinkedList();
    this.PV.add(paramzza);
    if (paramBundle != null)
    {
      if (this.PU != null)
        break label76;
      this.PU = ((Bundle)paramBundle.clone());
    }
    while (true)
    {
      zza(this.PW);
      return;
      label76: this.PU.putAll(paramBundle);
    }
  }

  @VisibleForTesting
  static void zza(FrameLayout paramFrameLayout, GoogleApiAvailability paramGoogleApiAvailability)
  {
    Context localContext = paramFrameLayout.getContext();
    int i = paramGoogleApiAvailability.isGooglePlayServicesAvailable(localContext);
    String str2 = zzg.zzi(localContext, i);
    String str1 = zzg.zzk(localContext, i);
    LinearLayout localLinearLayout = new LinearLayout(paramFrameLayout.getContext());
    localLinearLayout.setOrientation(1);
    localLinearLayout.setLayoutParams(new FrameLayout.LayoutParams(-2, -2));
    paramFrameLayout.addView(localLinearLayout);
    paramFrameLayout = new TextView(paramFrameLayout.getContext());
    paramFrameLayout.setLayoutParams(new FrameLayout.LayoutParams(-2, -2));
    paramFrameLayout.setText(str2);
    localLinearLayout.addView(paramFrameLayout);
    paramFrameLayout = paramGoogleApiAvailability.zzb(localContext, i, null);
    if (paramFrameLayout != null)
    {
      paramGoogleApiAvailability = new Button(localContext);
      paramGoogleApiAvailability.setId(16908313);
      paramGoogleApiAvailability.setLayoutParams(new FrameLayout.LayoutParams(-2, -2));
      paramGoogleApiAvailability.setText(str1);
      localLinearLayout.addView(paramGoogleApiAvailability);
      paramGoogleApiAvailability.setOnClickListener(new View.OnClickListener(localContext, paramFrameLayout)
      {
        public void onClick(View paramView)
        {
          try
          {
            zza.this.startActivity(this.Qc);
            return;
          }
          catch (android.content.ActivityNotFoundException paramView)
          {
            Log.e("DeferredLifecycleHelper", "Failed to start resolution intent", paramView);
          }
        }
      });
    }
  }

  public static void zzb(FrameLayout paramFrameLayout)
  {
    zza(paramFrameLayout, GoogleApiAvailability.getInstance());
  }

  private void zznj(int paramInt)
  {
    while ((!this.PV.isEmpty()) && (((zza)this.PV.getLast()).getState() >= paramInt))
      this.PV.removeLast();
  }

  public void onCreate(Bundle paramBundle)
  {
    zza(paramBundle, new zza(paramBundle)
    {
      public int getState()
      {
        return 1;
      }

      public void zzb(LifecycleDelegate paramLifecycleDelegate)
      {
        zza.zzb(zza.this).onCreate(this.zzavg);
      }
    });
  }

  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    FrameLayout localFrameLayout = new FrameLayout(paramLayoutInflater.getContext());
    zza(paramBundle, new zza(localFrameLayout, paramLayoutInflater, paramViewGroup, paramBundle)
    {
      public int getState()
      {
        return 2;
      }

      public void zzb(LifecycleDelegate paramLifecycleDelegate)
      {
        this.PZ.removeAllViews();
        this.PZ.addView(zza.zzb(zza.this).onCreateView(this.Qa, this.Qb, this.zzavg));
      }
    });
    if (this.PT == null)
      zza(localFrameLayout);
    return localFrameLayout;
  }

  public void onDestroy()
  {
    if (this.PT != null)
    {
      this.PT.onDestroy();
      return;
    }
    zznj(1);
  }

  public void onDestroyView()
  {
    if (this.PT != null)
    {
      this.PT.onDestroyView();
      return;
    }
    zznj(2);
  }

  public void onInflate(Activity paramActivity, Bundle paramBundle1, Bundle paramBundle2)
  {
    zza(paramBundle2, new zza(paramActivity, paramBundle1, paramBundle2)
    {
      public int getState()
      {
        return 0;
      }

      public void zzb(LifecycleDelegate paramLifecycleDelegate)
      {
        zza.zzb(zza.this).onInflate(this.val$activity, this.PY, this.zzavg);
      }
    });
  }

  public void onLowMemory()
  {
    if (this.PT != null)
      this.PT.onLowMemory();
  }

  public void onPause()
  {
    if (this.PT != null)
    {
      this.PT.onPause();
      return;
    }
    zznj(5);
  }

  public void onResume()
  {
    zza(null, new zza()
    {
      public int getState()
      {
        return 5;
      }

      public void zzb(LifecycleDelegate paramLifecycleDelegate)
      {
        zza.zzb(zza.this).onResume();
      }
    });
  }

  public void onSaveInstanceState(Bundle paramBundle)
  {
    if (this.PT != null)
      this.PT.onSaveInstanceState(paramBundle);
    do
      return;
    while (this.PU == null);
    paramBundle.putAll(this.PU);
  }

  public void onStart()
  {
    zza(null, new zza()
    {
      public int getState()
      {
        return 4;
      }

      public void zzb(LifecycleDelegate paramLifecycleDelegate)
      {
        zza.zzb(zza.this).onStart();
      }
    });
  }

  public void onStop()
  {
    if (this.PT != null)
    {
      this.PT.onStop();
      return;
    }
    zznj(4);
  }

  protected void zza(FrameLayout paramFrameLayout)
  {
    zzb(paramFrameLayout);
  }

  protected abstract void zza(zzf<T> paramzzf);

  public T zzbdo()
  {
    return this.PT;
  }

  private static abstract interface zza
  {
    public abstract int getState();

    public abstract void zzb(LifecycleDelegate paramLifecycleDelegate);
  }
}

/* Location:           C:\Users\c_jealom1\Documents\Scripts\Android\Fathom_com.brynk.fathom\Fathom_com.brynk.fathom-dex2jar.jar
 * Qualified Name:     com.google.android.gms.dynamic.zza
 * JD-Core Version:    0.6.0
 */
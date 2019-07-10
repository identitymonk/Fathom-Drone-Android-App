package com.google.android.gms.internal;

import android.annotation.TargetApi;
import android.app.Activity;
import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.support.annotation.NonNull;
import android.support.v4.util.ArrayMap;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.lang.ref.WeakReference;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.WeakHashMap;

@TargetApi(11)
public final class zzrq extends Fragment
  implements zzrp
{
  private static WeakHashMap<Activity, WeakReference<zzrq>> Bg = new WeakHashMap();
  private Map<String, zzro> Bh = new ArrayMap();
  private Bundle Bi;
  private int zzbtt = 0;

  private void zzb(String paramString, @NonNull zzro paramzzro)
  {
    if (this.zzbtt > 0)
      new Handler(Looper.getMainLooper()).post(new Runnable(paramzzro, paramString)
      {
        public void run()
        {
          zzro localzzro;
          if (zzrq.zza(zzrq.this) >= 1)
          {
            localzzro = this.Bj;
            if (zzrq.zzb(zzrq.this) == null)
              break label101;
          }
          label101: for (Bundle localBundle = zzrq.zzb(zzrq.this).getBundle(this.zzap); ; localBundle = null)
          {
            localzzro.onCreate(localBundle);
            if (zzrq.zza(zzrq.this) >= 2)
              this.Bj.onStart();
            if (zzrq.zza(zzrq.this) >= 3)
              this.Bj.onStop();
            if (zzrq.zza(zzrq.this) >= 4)
              this.Bj.onDestroy();
            return;
          }
        }
      });
  }

  public static zzrq zzt(Activity paramActivity)
  {
    Object localObject = (WeakReference)Bg.get(paramActivity);
    if (localObject != null)
    {
      localObject = (zzrq)((WeakReference)localObject).get();
      if (localObject != null)
        return localObject;
    }
    try
    {
      zzrq localzzrq = (zzrq)paramActivity.getFragmentManager().findFragmentByTag("LifecycleFragmentImpl");
      if (localzzrq != null)
      {
        localObject = localzzrq;
        if (!localzzrq.isRemoving());
      }
      else
      {
        localObject = new zzrq();
        paramActivity.getFragmentManager().beginTransaction().add((Fragment)localObject, "LifecycleFragmentImpl").commitAllowingStateLoss();
      }
      Bg.put(paramActivity, new WeakReference(localObject));
      return localObject;
    }
    catch (java.lang.ClassCastException paramActivity)
    {
    }
    throw new IllegalStateException("Fragment with tag LifecycleFragmentImpl is not a LifecycleFragmentImpl", paramActivity);
  }

  public void dump(String paramString, FileDescriptor paramFileDescriptor, PrintWriter paramPrintWriter, String[] paramArrayOfString)
  {
    super.dump(paramString, paramFileDescriptor, paramPrintWriter, paramArrayOfString);
    Iterator localIterator = this.Bh.values().iterator();
    while (localIterator.hasNext())
      ((zzro)localIterator.next()).dump(paramString, paramFileDescriptor, paramPrintWriter, paramArrayOfString);
  }

  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    Iterator localIterator = this.Bh.values().iterator();
    while (localIterator.hasNext())
      ((zzro)localIterator.next()).onActivityResult(paramInt1, paramInt2, paramIntent);
  }

  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    this.zzbtt = 1;
    this.Bi = paramBundle;
    Iterator localIterator = this.Bh.entrySet().iterator();
    if (localIterator.hasNext())
    {
      Object localObject = (Map.Entry)localIterator.next();
      zzro localzzro = (zzro)((Map.Entry)localObject).getValue();
      if (paramBundle != null);
      for (localObject = paramBundle.getBundle((String)((Map.Entry)localObject).getKey()); ; localObject = null)
      {
        localzzro.onCreate((Bundle)localObject);
        break;
      }
    }
  }

  public void onDestroy()
  {
    super.onDestroy();
    this.zzbtt = 4;
    Iterator localIterator = this.Bh.values().iterator();
    while (localIterator.hasNext())
      ((zzro)localIterator.next()).onDestroy();
  }

  public void onSaveInstanceState(Bundle paramBundle)
  {
    super.onSaveInstanceState(paramBundle);
    if (paramBundle == null);
    while (true)
    {
      return;
      Iterator localIterator = this.Bh.entrySet().iterator();
      while (localIterator.hasNext())
      {
        Map.Entry localEntry = (Map.Entry)localIterator.next();
        Bundle localBundle = new Bundle();
        ((zzro)localEntry.getValue()).onSaveInstanceState(localBundle);
        paramBundle.putBundle((String)localEntry.getKey(), localBundle);
      }
    }
  }

  public void onStart()
  {
    super.onStart();
    this.zzbtt = 2;
    Iterator localIterator = this.Bh.values().iterator();
    while (localIterator.hasNext())
      ((zzro)localIterator.next()).onStart();
  }

  public void onStop()
  {
    super.onStop();
    this.zzbtt = 3;
    Iterator localIterator = this.Bh.values().iterator();
    while (localIterator.hasNext())
      ((zzro)localIterator.next()).onStop();
  }

  public <T extends zzro> T zza(String paramString, Class<T> paramClass)
  {
    return (zzro)paramClass.cast(this.Bh.get(paramString));
  }

  public void zza(String paramString, @NonNull zzro paramzzro)
  {
    if (!this.Bh.containsKey(paramString))
    {
      this.Bh.put(paramString, paramzzro);
      zzb(paramString, paramzzro);
      return;
    }
    throw new IllegalArgumentException(String.valueOf(paramString).length() + 59 + "LifecycleCallback with tag " + paramString + " already added to this fragment.");
  }

  public Activity zzaty()
  {
    return getActivity();
  }
}

/* Location:           C:\Users\c_jealom1\Documents\Scripts\Android\Fathom_com.brynk.fathom\Fathom_com.brynk.fathom-dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.zzrq
 * JD-Core Version:    0.6.0
 */
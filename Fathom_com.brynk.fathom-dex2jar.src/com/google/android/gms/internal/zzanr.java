package com.google.android.gms.internal;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.google.firebase.FirebaseApp;
import com.google.firebase.FirebaseOptions;
import java.util.Collections;
import java.util.Set;
import java.util.concurrent.atomic.AtomicReference;

public class zzanr
{
  private static final AtomicReference<zzanr> aWf = new AtomicReference();

  zzanr(Context paramContext)
  {
  }

  @Nullable
  public static zzanr P()
  {
    return (zzanr)aWf.get();
  }

  public static zzanr zzeu(Context paramContext)
  {
    aWf.compareAndSet(null, new zzanr(paramContext));
    return (zzanr)aWf.get();
  }

  public Set<String> Q()
  {
    return Collections.emptySet();
  }

  public void zzg(@NonNull FirebaseApp paramFirebaseApp)
  {
  }

  public FirebaseOptions zztz(@NonNull String paramString)
  {
    return null;
  }
}

/* Location:           C:\Users\c_jealom1\Documents\Scripts\Android\Fathom_com.brynk.fathom\Fathom_com.brynk.fathom-dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.zzanr
 * JD-Core Version:    0.6.0
 */
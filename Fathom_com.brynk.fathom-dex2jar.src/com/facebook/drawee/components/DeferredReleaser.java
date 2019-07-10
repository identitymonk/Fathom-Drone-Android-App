package com.facebook.drawee.components;

import android.os.Handler;
import android.os.Looper;
import com.facebook.common.internal.Preconditions;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class DeferredReleaser
{
  private static DeferredReleaser sInstance = null;
  private final Set<Releasable> mPendingReleasables = new HashSet();
  private final Handler mUiHandler = new Handler(Looper.getMainLooper());
  private final Runnable releaseRunnable = new Runnable()
  {
    public void run()
    {
      DeferredReleaser.access$000();
      Iterator localIterator = DeferredReleaser.this.mPendingReleasables.iterator();
      while (localIterator.hasNext())
        ((DeferredReleaser.Releasable)localIterator.next()).release();
      DeferredReleaser.this.mPendingReleasables.clear();
    }
  };

  private static void ensureOnUiThread()
  {
    if (Looper.getMainLooper().getThread() == Thread.currentThread());
    for (boolean bool = true; ; bool = false)
    {
      Preconditions.checkState(bool);
      return;
    }
  }

  public static DeferredReleaser getInstance()
  {
    monitorenter;
    try
    {
      if (sInstance == null)
        sInstance = new DeferredReleaser();
      DeferredReleaser localDeferredReleaser = sInstance;
      return localDeferredReleaser;
    }
    finally
    {
      monitorexit;
    }
    throw localObject;
  }

  public void cancelDeferredRelease(Releasable paramReleasable)
  {
    ensureOnUiThread();
    this.mPendingReleasables.remove(paramReleasable);
  }

  public void scheduleDeferredRelease(Releasable paramReleasable)
  {
    ensureOnUiThread();
    if (!this.mPendingReleasables.add(paramReleasable));
    do
      return;
    while (this.mPendingReleasables.size() != 1);
    this.mUiHandler.post(this.releaseRunnable);
  }

  public static abstract interface Releasable
  {
    public abstract void release();
  }
}

/* Location:           C:\Users\c_jealom1\Documents\Scripts\Android\Fathom_com.brynk.fathom\Fathom_com.brynk.fathom-dex2jar.jar
 * Qualified Name:     com.facebook.drawee.components.DeferredReleaser
 * JD-Core Version:    0.6.0
 */
package com.facebook.common.activitylistener;

import android.app.Activity;
import android.content.Context;
import android.content.ContextWrapper;
import com.facebook.common.internal.Preconditions;
import java.lang.ref.WeakReference;

public class ActivityListenerManager
{
  public static void register(ActivityListener paramActivityListener, Context paramContext)
  {
    Context localContext = paramContext;
    if (!(paramContext instanceof ListenableActivity))
    {
      localContext = paramContext;
      if ((paramContext instanceof ContextWrapper))
        localContext = ((ContextWrapper)paramContext).getBaseContext();
    }
    if ((localContext instanceof ListenableActivity))
      ((ListenableActivity)localContext).addActivityListener(new Listener(paramActivityListener));
  }

  private static class Listener extends BaseActivityListener
  {
    private final WeakReference<ActivityListener> mActivityListenerRef;

    public Listener(ActivityListener paramActivityListener)
    {
      this.mActivityListenerRef = new WeakReference(paramActivityListener);
    }

    private ActivityListener getListenerOrCleanUp(Activity paramActivity)
    {
      ActivityListener localActivityListener = (ActivityListener)this.mActivityListenerRef.get();
      if (localActivityListener == null)
      {
        Preconditions.checkArgument(paramActivity instanceof ListenableActivity);
        ((ListenableActivity)paramActivity).removeActivityListener(this);
      }
      return localActivityListener;
    }

    public void onActivityCreate(Activity paramActivity)
    {
      ActivityListener localActivityListener = getListenerOrCleanUp(paramActivity);
      if (localActivityListener != null)
        localActivityListener.onActivityCreate(paramActivity);
    }

    public void onDestroy(Activity paramActivity)
    {
      ActivityListener localActivityListener = getListenerOrCleanUp(paramActivity);
      if (localActivityListener != null)
        localActivityListener.onDestroy(paramActivity);
    }

    public void onPause(Activity paramActivity)
    {
      ActivityListener localActivityListener = getListenerOrCleanUp(paramActivity);
      if (localActivityListener != null)
        localActivityListener.onPause(paramActivity);
    }

    public void onResume(Activity paramActivity)
    {
      ActivityListener localActivityListener = getListenerOrCleanUp(paramActivity);
      if (localActivityListener != null)
        localActivityListener.onResume(paramActivity);
    }

    public void onStart(Activity paramActivity)
    {
      ActivityListener localActivityListener = getListenerOrCleanUp(paramActivity);
      if (localActivityListener != null)
        localActivityListener.onStart(paramActivity);
    }

    public void onStop(Activity paramActivity)
    {
      ActivityListener localActivityListener = getListenerOrCleanUp(paramActivity);
      if (localActivityListener != null)
        localActivityListener.onStop(paramActivity);
    }
  }
}

/* Location:           C:\Users\c_jealom1\Documents\Scripts\Android\Fathom_com.brynk.fathom\Fathom_com.brynk.fathom-dex2jar.jar
 * Qualified Name:     com.facebook.common.activitylistener.ActivityListenerManager
 * JD-Core Version:    0.6.0
 */
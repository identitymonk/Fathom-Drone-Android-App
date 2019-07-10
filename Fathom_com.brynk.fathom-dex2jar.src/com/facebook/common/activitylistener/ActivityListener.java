package com.facebook.common.activitylistener;

import android.app.Activity;

public abstract interface ActivityListener
{
  public abstract void onActivityCreate(Activity paramActivity);

  public abstract void onDestroy(Activity paramActivity);

  public abstract void onPause(Activity paramActivity);

  public abstract void onResume(Activity paramActivity);

  public abstract void onStart(Activity paramActivity);

  public abstract void onStop(Activity paramActivity);
}

/* Location:           C:\Users\c_jealom1\Documents\Scripts\Android\Fathom_com.brynk.fathom\Fathom_com.brynk.fathom-dex2jar.jar
 * Qualified Name:     com.facebook.common.activitylistener.ActivityListener
 * JD-Core Version:    0.6.0
 */
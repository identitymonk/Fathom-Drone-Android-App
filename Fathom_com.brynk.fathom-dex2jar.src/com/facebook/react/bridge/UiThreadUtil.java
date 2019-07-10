package com.facebook.react.bridge;

import android.os.Handler;
import android.os.Looper;
import javax.annotation.Nullable;

public class UiThreadUtil
{

  @Nullable
  private static Handler sMainHandler;

  public static void assertNotOnUiThread()
  {
    if (!isOnUiThread());
    for (boolean bool = true; ; bool = false)
    {
      SoftAssertions.assertCondition(bool, "Expected not to run on UI thread!");
      return;
    }
  }

  public static void assertOnUiThread()
  {
    SoftAssertions.assertCondition(isOnUiThread(), "Expected to run on UI thread!");
  }

  public static boolean isOnUiThread()
  {
    return Looper.getMainLooper().getThread() == Thread.currentThread();
  }

  public static void runOnUiThread(Runnable paramRunnable)
  {
    monitorenter;
    try
    {
      if (sMainHandler == null)
        sMainHandler = new Handler(Looper.getMainLooper());
      monitorexit;
      sMainHandler.post(paramRunnable);
      return;
    }
    finally
    {
      monitorexit;
    }
    throw paramRunnable;
  }
}

/* Location:           C:\Users\c_jealom1\Documents\Scripts\Android\Fathom_com.brynk.fathom\Fathom_com.brynk.fathom-dex2jar.jar
 * Qualified Name:     com.facebook.react.bridge.UiThreadUtil
 * JD-Core Version:    0.6.0
 */
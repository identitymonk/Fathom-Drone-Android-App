package com.facebook.common.executors;

import android.os.Handler;
import android.os.Looper;

public class UiThreadImmediateExecutorService extends HandlerExecutorServiceImpl
{
  private static UiThreadImmediateExecutorService sInstance = null;

  private UiThreadImmediateExecutorService()
  {
    super(new Handler(Looper.getMainLooper()));
  }

  public static UiThreadImmediateExecutorService getInstance()
  {
    if (sInstance == null)
      sInstance = new UiThreadImmediateExecutorService();
    return sInstance;
  }

  public void execute(Runnable paramRunnable)
  {
    if (isHandlerThread())
    {
      paramRunnable.run();
      return;
    }
    super.execute(paramRunnable);
  }
}

/* Location:           C:\Users\c_jealom1\Documents\Scripts\Android\Fathom_com.brynk.fathom\Fathom_com.brynk.fathom-dex2jar.jar
 * Qualified Name:     com.facebook.common.executors.UiThreadImmediateExecutorService
 * JD-Core Version:    0.6.0
 */
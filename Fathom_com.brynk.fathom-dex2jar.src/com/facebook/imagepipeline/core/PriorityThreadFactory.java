package com.facebook.imagepipeline.core;

import android.os.Process;
import java.util.concurrent.ThreadFactory;

public class PriorityThreadFactory
  implements ThreadFactory
{
  private final int mThreadPriority;

  public PriorityThreadFactory(int paramInt)
  {
    this.mThreadPriority = paramInt;
  }

  public Thread newThread(Runnable paramRunnable)
  {
    return new Thread(new Runnable(paramRunnable)
    {
      public void run()
      {
        try
        {
          Process.setThreadPriority(PriorityThreadFactory.this.mThreadPriority);
          label10: this.val$runnable.run();
          return;
        }
        catch (Throwable localThrowable)
        {
          break label10;
        }
      }
    });
  }
}

/* Location:           C:\Users\c_jealom1\Documents\Scripts\Android\Fathom_com.brynk.fathom\Fathom_com.brynk.fathom-dex2jar.jar
 * Qualified Name:     com.facebook.imagepipeline.core.PriorityThreadFactory
 * JD-Core Version:    0.6.0
 */
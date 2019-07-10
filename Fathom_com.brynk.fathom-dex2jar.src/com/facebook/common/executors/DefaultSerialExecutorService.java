package com.facebook.common.executors;

import java.util.concurrent.Executor;
import java.util.concurrent.LinkedBlockingQueue;

public class DefaultSerialExecutorService extends ConstrainedExecutorService
  implements SerialExecutorService
{
  public DefaultSerialExecutorService(Executor paramExecutor)
  {
    super("SerialExecutor", 1, paramExecutor, new LinkedBlockingQueue());
  }

  public void execute(Runnable paramRunnable)
  {
    monitorenter;
    try
    {
      super.execute(paramRunnable);
      monitorexit;
      return;
    }
    finally
    {
      paramRunnable = finally;
      monitorexit;
    }
    throw paramRunnable;
  }
}

/* Location:           C:\Users\c_jealom1\Documents\Scripts\Android\Fathom_com.brynk.fathom\Fathom_com.brynk.fathom-dex2jar.jar
 * Qualified Name:     com.facebook.common.executors.DefaultSerialExecutorService
 * JD-Core Version:    0.6.0
 */
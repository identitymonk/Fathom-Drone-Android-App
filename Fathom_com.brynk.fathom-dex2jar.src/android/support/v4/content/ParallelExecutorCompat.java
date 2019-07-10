package android.support.v4.content;

import android.os.Build.VERSION;
import java.util.concurrent.Executor;

public final class ParallelExecutorCompat
{
  public static Executor getParallelExecutor()
  {
    if (Build.VERSION.SDK_INT >= 11)
      return ExecutorCompatHoneycomb.getParallelExecutor();
    return ModernAsyncTask.THREAD_POOL_EXECUTOR;
  }
}

/* Location:           C:\Users\c_jealom1\Documents\Scripts\Android\Fathom_com.brynk.fathom\Fathom_com.brynk.fathom-dex2jar.jar
 * Qualified Name:     android.support.v4.content.ParallelExecutorCompat
 * JD-Core Version:    0.6.0
 */
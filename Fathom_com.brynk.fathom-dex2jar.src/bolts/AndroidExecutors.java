package bolts;

import android.annotation.SuppressLint;
import android.os.Build.VERSION;
import android.os.Handler;
import android.os.Looper;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

final class AndroidExecutors
{
  static final int CORE_POOL_SIZE;
  private static final int CPU_COUNT;
  private static final AndroidExecutors INSTANCE = new AndroidExecutors();
  static final long KEEP_ALIVE_TIME = 1L;
  static final int MAX_POOL_SIZE;
  private final Executor uiThread = new UIThreadExecutor(null);

  static
  {
    CPU_COUNT = Runtime.getRuntime().availableProcessors();
    CORE_POOL_SIZE = CPU_COUNT + 1;
    MAX_POOL_SIZE = CPU_COUNT * 2 + 1;
  }

  @SuppressLint({"NewApi"})
  public static void allowCoreThreadTimeout(ThreadPoolExecutor paramThreadPoolExecutor, boolean paramBoolean)
  {
    if (Build.VERSION.SDK_INT >= 9)
      paramThreadPoolExecutor.allowCoreThreadTimeOut(paramBoolean);
  }

  public static ExecutorService newCachedThreadPool()
  {
    ThreadPoolExecutor localThreadPoolExecutor = new ThreadPoolExecutor(CORE_POOL_SIZE, MAX_POOL_SIZE, 1L, TimeUnit.SECONDS, new LinkedBlockingQueue());
    allowCoreThreadTimeout(localThreadPoolExecutor, true);
    return localThreadPoolExecutor;
  }

  public static ExecutorService newCachedThreadPool(ThreadFactory paramThreadFactory)
  {
    paramThreadFactory = new ThreadPoolExecutor(CORE_POOL_SIZE, MAX_POOL_SIZE, 1L, TimeUnit.SECONDS, new LinkedBlockingQueue(), paramThreadFactory);
    allowCoreThreadTimeout(paramThreadFactory, true);
    return paramThreadFactory;
  }

  public static Executor uiThread()
  {
    return INSTANCE.uiThread;
  }

  private static class UIThreadExecutor
    implements Executor
  {
    public void execute(Runnable paramRunnable)
    {
      new Handler(Looper.getMainLooper()).post(paramRunnable);
    }
  }
}

/* Location:           C:\Users\c_jealom1\Documents\Scripts\Android\Fathom_com.brynk.fathom\Fathom_com.brynk.fathom-dex2jar.jar
 * Qualified Name:     bolts.AndroidExecutors
 * JD-Core Version:    0.6.0
 */
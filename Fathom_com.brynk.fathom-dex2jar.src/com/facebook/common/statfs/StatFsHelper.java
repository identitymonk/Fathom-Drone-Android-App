package com.facebook.common.statfs;

import android.annotation.SuppressLint;
import android.os.Build.VERSION;
import android.os.Environment;
import android.os.StatFs;
import android.os.SystemClock;
import com.facebook.common.internal.Throwables;
import java.io.File;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import javax.annotation.Nullable;
import javax.annotation.concurrent.GuardedBy;
import javax.annotation.concurrent.ThreadSafe;

@ThreadSafe
public class StatFsHelper
{
  private static final long RESTAT_INTERVAL_MS = TimeUnit.MINUTES.toMillis(2L);
  private static StatFsHelper sStatsFsHelper;
  private final Lock lock = new ReentrantLock();
  private volatile File mExternalPath;
  private volatile StatFs mExternalStatFs = null;
  private volatile boolean mInitialized = false;
  private volatile File mInternalPath;
  private volatile StatFs mInternalStatFs = null;

  @GuardedBy("lock")
  private long mLastRestatTime;

  protected static StatFs createStatFs(String paramString)
  {
    return new StatFs(paramString);
  }

  private void ensureInitialized()
  {
    if (!this.mInitialized)
      this.lock.lock();
    try
    {
      if (!this.mInitialized)
      {
        this.mInternalPath = Environment.getDataDirectory();
        this.mExternalPath = Environment.getExternalStorageDirectory();
        updateStats();
        this.mInitialized = true;
      }
      return;
    }
    finally
    {
      this.lock.unlock();
    }
    throw localObject;
  }

  public static StatFsHelper getInstance()
  {
    monitorenter;
    try
    {
      if (sStatsFsHelper == null)
        sStatsFsHelper = new StatFsHelper();
      StatFsHelper localStatFsHelper = sStatsFsHelper;
      return localStatFsHelper;
    }
    finally
    {
      monitorexit;
    }
    throw localObject;
  }

  private void maybeUpdateStats()
  {
    if (this.lock.tryLock());
    try
    {
      if (SystemClock.uptimeMillis() - this.mLastRestatTime > RESTAT_INTERVAL_MS)
        updateStats();
      return;
    }
    finally
    {
      this.lock.unlock();
    }
    throw localObject;
  }

  @GuardedBy("lock")
  private void updateStats()
  {
    this.mInternalStatFs = updateStatsHelper(this.mInternalStatFs, this.mInternalPath);
    this.mExternalStatFs = updateStatsHelper(this.mExternalStatFs, this.mExternalPath);
    this.mLastRestatTime = SystemClock.uptimeMillis();
  }

  private StatFs updateStatsHelper(@Nullable StatFs paramStatFs, @Nullable File paramFile)
  {
    if ((paramFile == null) || (!paramFile.exists()))
      return null;
    if (paramStatFs == null);
    try
    {
      paramStatFs = createStatFs(paramFile.getAbsolutePath());
      break label51;
      paramStatFs.restat(paramFile.getAbsolutePath());
    }
    catch (java.lang.IllegalArgumentException paramStatFs)
    {
      paramStatFs = null;
    }
    catch (java.lang.Throwable paramStatFs)
    {
      throw Throwables.propagate(paramStatFs);
    }
    label51: return paramStatFs;
  }

  @SuppressLint({"DeprecatedMethod"})
  public long getAvailableStorageSpace(StorageType paramStorageType)
  {
    ensureInitialized();
    maybeUpdateStats();
    long l2;
    long l1;
    if (paramStorageType == StorageType.INTERNAL)
    {
      paramStorageType = this.mInternalStatFs;
      if (paramStorageType == null)
        break label72;
      if (Build.VERSION.SDK_INT < 18)
        break label56;
      l2 = paramStorageType.getBlockSizeLong();
      l1 = paramStorageType.getAvailableBlocksLong();
    }
    while (true)
    {
      return l2 * l1;
      paramStorageType = this.mExternalStatFs;
      break;
      label56: l2 = paramStorageType.getBlockSize();
      l1 = paramStorageType.getAvailableBlocks();
    }
    label72: return 0L;
  }

  @SuppressLint({"DeprecatedMethod"})
  public long getFreeStorageSpace(StorageType paramStorageType)
  {
    ensureInitialized();
    maybeUpdateStats();
    long l2;
    long l1;
    if (paramStorageType == StorageType.INTERNAL)
    {
      paramStorageType = this.mInternalStatFs;
      if (paramStorageType == null)
        break label72;
      if (Build.VERSION.SDK_INT < 18)
        break label56;
      l2 = paramStorageType.getBlockSizeLong();
      l1 = paramStorageType.getFreeBlocksLong();
    }
    while (true)
    {
      return l2 * l1;
      paramStorageType = this.mExternalStatFs;
      break;
      label56: l2 = paramStorageType.getBlockSize();
      l1 = paramStorageType.getFreeBlocks();
    }
    label72: return -1L;
  }

  @SuppressLint({"DeprecatedMethod"})
  public long getTotalStorageSpace(StorageType paramStorageType)
  {
    ensureInitialized();
    maybeUpdateStats();
    long l1;
    long l2;
    if (paramStorageType == StorageType.INTERNAL)
    {
      paramStorageType = this.mInternalStatFs;
      if (paramStorageType == null)
        break label72;
      if (Build.VERSION.SDK_INT < 18)
        break label56;
      l1 = paramStorageType.getBlockSizeLong();
      l2 = paramStorageType.getBlockCountLong();
    }
    while (true)
    {
      return l1 * l2;
      paramStorageType = this.mExternalStatFs;
      break;
      label56: l1 = paramStorageType.getBlockSize();
      l2 = paramStorageType.getBlockCount();
    }
    label72: return -1L;
  }

  public void resetStats()
  {
    if (this.lock.tryLock());
    try
    {
      ensureInitialized();
      updateStats();
      return;
    }
    finally
    {
      this.lock.unlock();
    }
    throw localObject;
  }

  public boolean testLowDiskSpace(StorageType paramStorageType, long paramLong)
  {
    ensureInitialized();
    long l = getAvailableStorageSpace(paramStorageType);
    return (l <= 0L) || (l < paramLong);
  }

  public static enum StorageType
  {
    static
    {
      EXTERNAL = new StorageType("EXTERNAL", 1);
      $VALUES = new StorageType[] { INTERNAL, EXTERNAL };
    }
  }
}

/* Location:           C:\Users\c_jealom1\Documents\Scripts\Android\Fathom_com.brynk.fathom\Fathom_com.brynk.fathom-dex2jar.jar
 * Qualified Name:     com.facebook.common.statfs.StatFsHelper
 * JD-Core Version:    0.6.0
 */
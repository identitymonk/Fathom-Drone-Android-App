package com.facebook.imagepipeline.memory;

import com.facebook.common.internal.Preconditions;
import com.facebook.common.internal.Throwables;
import com.facebook.common.internal.VisibleForTesting;
import com.facebook.common.memory.MemoryTrimType;
import com.facebook.common.memory.MemoryTrimmable;
import com.facebook.common.memory.MemoryTrimmableRegistry;
import com.facebook.common.references.CloseableReference;
import com.facebook.common.references.OOMSoftReference;
import com.facebook.common.references.ResourceReleaser;
import java.util.concurrent.Semaphore;
import javax.annotation.concurrent.ThreadSafe;

@ThreadSafe
public class SharedByteArray
  implements MemoryTrimmable
{

  @VisibleForTesting
  final OOMSoftReference<byte[]> mByteArraySoftRef;

  @VisibleForTesting
  final int mMaxByteArraySize;

  @VisibleForTesting
  final int mMinByteArraySize;
  private final ResourceReleaser<byte[]> mResourceReleaser;

  @VisibleForTesting
  final Semaphore mSemaphore;

  public SharedByteArray(MemoryTrimmableRegistry paramMemoryTrimmableRegistry, PoolParams paramPoolParams)
  {
    Preconditions.checkNotNull(paramMemoryTrimmableRegistry);
    if (paramPoolParams.minBucketSize > 0);
    for (boolean bool1 = true; ; bool1 = false)
    {
      Preconditions.checkArgument(bool1);
      bool1 = bool2;
      if (paramPoolParams.maxBucketSize >= paramPoolParams.minBucketSize)
        bool1 = true;
      Preconditions.checkArgument(bool1);
      this.mMaxByteArraySize = paramPoolParams.maxBucketSize;
      this.mMinByteArraySize = paramPoolParams.minBucketSize;
      this.mByteArraySoftRef = new OOMSoftReference();
      this.mSemaphore = new Semaphore(1);
      this.mResourceReleaser = new ResourceReleaser()
      {
        public void release(byte[] paramArrayOfByte)
        {
          SharedByteArray.this.mSemaphore.release();
        }
      };
      paramMemoryTrimmableRegistry.registerMemoryTrimmable(this);
      return;
    }
  }

  private byte[] allocateByteArray(int paramInt)
  {
    monitorenter;
    try
    {
      this.mByteArraySoftRef.clear();
      byte[] arrayOfByte = new byte[paramInt];
      this.mByteArraySoftRef.set(arrayOfByte);
      monitorexit;
      return arrayOfByte;
    }
    finally
    {
      localObject = finally;
      monitorexit;
    }
    throw localObject;
  }

  private byte[] getByteArray(int paramInt)
  {
    paramInt = getBucketedSize(paramInt);
    byte[] arrayOfByte2 = (byte[])this.mByteArraySoftRef.get();
    byte[] arrayOfByte1;
    if (arrayOfByte2 != null)
    {
      arrayOfByte1 = arrayOfByte2;
      if (arrayOfByte2.length >= paramInt);
    }
    else
    {
      arrayOfByte1 = allocateByteArray(paramInt);
    }
    return arrayOfByte1;
  }

  public CloseableReference<byte[]> get(int paramInt)
  {
    boolean bool2 = true;
    boolean bool1;
    if (paramInt > 0)
      bool1 = true;
    while (true)
    {
      Preconditions.checkArgument(bool1, "Size must be greater than zero");
      if (paramInt <= this.mMaxByteArraySize)
      {
        bool1 = bool2;
        Preconditions.checkArgument(bool1, "Requested size is too big");
        this.mSemaphore.acquireUninterruptibly();
      }
      try
      {
        CloseableReference localCloseableReference = CloseableReference.of(getByteArray(paramInt), this.mResourceReleaser);
        return localCloseableReference;
        bool1 = false;
        continue;
        bool1 = false;
      }
      catch (Throwable localThrowable)
      {
        this.mSemaphore.release();
      }
    }
    throw Throwables.propagate(localThrowable);
  }

  @VisibleForTesting
  int getBucketedSize(int paramInt)
  {
    return Integer.highestOneBit(Math.max(paramInt, this.mMinByteArraySize) - 1) * 2;
  }

  public void trim(MemoryTrimType paramMemoryTrimType)
  {
    if (!this.mSemaphore.tryAcquire())
      return;
    try
    {
      this.mByteArraySoftRef.clear();
      return;
    }
    finally
    {
      this.mSemaphore.release();
    }
    throw paramMemoryTrimType;
  }
}

/* Location:           C:\Users\c_jealom1\Documents\Scripts\Android\Fathom_com.brynk.fathom\Fathom_com.brynk.fathom-dex2jar.jar
 * Qualified Name:     com.facebook.imagepipeline.memory.SharedByteArray
 * JD-Core Version:    0.6.0
 */
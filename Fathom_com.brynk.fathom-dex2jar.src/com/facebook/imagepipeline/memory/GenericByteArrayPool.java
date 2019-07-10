package com.facebook.imagepipeline.memory;

import android.util.SparseIntArray;
import com.facebook.common.internal.Preconditions;
import com.facebook.common.memory.ByteArrayPool;
import com.facebook.common.memory.MemoryTrimmableRegistry;
import javax.annotation.concurrent.ThreadSafe;

@ThreadSafe
public class GenericByteArrayPool extends BasePool<byte[]>
  implements ByteArrayPool
{
  private final int[] mBucketSizes;

  public GenericByteArrayPool(MemoryTrimmableRegistry paramMemoryTrimmableRegistry, PoolParams paramPoolParams, PoolStatsTracker paramPoolStatsTracker)
  {
    super(paramMemoryTrimmableRegistry, paramPoolParams, paramPoolStatsTracker);
    paramMemoryTrimmableRegistry = paramPoolParams.bucketSizes;
    this.mBucketSizes = new int[paramMemoryTrimmableRegistry.size()];
    int i = 0;
    while (i < paramMemoryTrimmableRegistry.size())
    {
      this.mBucketSizes[i] = paramMemoryTrimmableRegistry.keyAt(i);
      i += 1;
    }
    initialize();
  }

  protected byte[] alloc(int paramInt)
  {
    return new byte[paramInt];
  }

  protected void free(byte[] paramArrayOfByte)
  {
    Preconditions.checkNotNull(paramArrayOfByte);
  }

  protected int getBucketedSize(int paramInt)
  {
    if (paramInt <= 0)
      throw new BasePool.InvalidSizeException(Integer.valueOf(paramInt));
    int[] arrayOfInt = this.mBucketSizes;
    int j = arrayOfInt.length;
    int i = 0;
    while (i < j)
    {
      int k = arrayOfInt[i];
      if (k >= paramInt)
        return k;
      i += 1;
    }
    return paramInt;
  }

  protected int getBucketedSizeForValue(byte[] paramArrayOfByte)
  {
    Preconditions.checkNotNull(paramArrayOfByte);
    return paramArrayOfByte.length;
  }

  public int getMinBufferSize()
  {
    return this.mBucketSizes[0];
  }

  protected int getSizeInBytes(int paramInt)
  {
    return paramInt;
  }
}

/* Location:           C:\Users\c_jealom1\Documents\Scripts\Android\Fathom_com.brynk.fathom\Fathom_com.brynk.fathom-dex2jar.jar
 * Qualified Name:     com.facebook.imagepipeline.memory.GenericByteArrayPool
 * JD-Core Version:    0.6.0
 */
package com.facebook.imagepipeline.memory;

import android.util.SparseIntArray;
import com.facebook.common.internal.Preconditions;
import javax.annotation.Nullable;

public class PoolParams
{
  public static final int IGNORE_THREADS = -1;
  public final SparseIntArray bucketSizes;
  public final int maxBucketSize;
  public final int maxNumThreads;
  public final int maxSizeHardCap;
  public final int maxSizeSoftCap;
  public final int minBucketSize;

  public PoolParams(int paramInt1, int paramInt2, @Nullable SparseIntArray paramSparseIntArray)
  {
    this(paramInt1, paramInt2, paramSparseIntArray, 0, 2147483647, -1);
  }

  public PoolParams(int paramInt1, int paramInt2, @Nullable SparseIntArray paramSparseIntArray, int paramInt3, int paramInt4, int paramInt5)
  {
    if ((paramInt1 >= 0) && (paramInt2 >= paramInt1));
    for (boolean bool = true; ; bool = false)
    {
      Preconditions.checkState(bool);
      this.maxSizeSoftCap = paramInt1;
      this.maxSizeHardCap = paramInt2;
      this.bucketSizes = paramSparseIntArray;
      this.minBucketSize = paramInt3;
      this.maxBucketSize = paramInt4;
      this.maxNumThreads = paramInt5;
      return;
    }
  }

  public PoolParams(int paramInt, @Nullable SparseIntArray paramSparseIntArray)
  {
    this(paramInt, paramInt, paramSparseIntArray, 0, 2147483647, -1);
  }
}

/* Location:           C:\Users\c_jealom1\Documents\Scripts\Android\Fathom_com.brynk.fathom\Fathom_com.brynk.fathom-dex2jar.jar
 * Qualified Name:     com.facebook.imagepipeline.memory.PoolParams
 * JD-Core Version:    0.6.0
 */
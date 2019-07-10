package com.facebook.imagepipeline.memory;

import android.util.SparseIntArray;

public class DefaultFlexByteArrayPoolParams
{
  public static final int DEFAULT_MAX_BYTE_ARRAY_SIZE = 4194304;
  public static final int DEFAULT_MAX_NUM_THREADS = Runtime.getRuntime().availableProcessors();
  private static final int DEFAULT_MIN_BYTE_ARRAY_SIZE = 131072;

  public static SparseIntArray generateBuckets(int paramInt1, int paramInt2, int paramInt3)
  {
    SparseIntArray localSparseIntArray = new SparseIntArray();
    while (paramInt1 <= paramInt2)
    {
      localSparseIntArray.put(paramInt1, paramInt3);
      paramInt1 *= 2;
    }
    return localSparseIntArray;
  }

  public static PoolParams get()
  {
    return new PoolParams(4194304, DEFAULT_MAX_NUM_THREADS * 4194304, generateBuckets(131072, 4194304, DEFAULT_MAX_NUM_THREADS), 131072, 4194304, DEFAULT_MAX_NUM_THREADS);
  }
}

/* Location:           C:\Users\c_jealom1\Documents\Scripts\Android\Fathom_com.brynk.fathom\Fathom_com.brynk.fathom-dex2jar.jar
 * Qualified Name:     com.facebook.imagepipeline.memory.DefaultFlexByteArrayPoolParams
 * JD-Core Version:    0.6.0
 */
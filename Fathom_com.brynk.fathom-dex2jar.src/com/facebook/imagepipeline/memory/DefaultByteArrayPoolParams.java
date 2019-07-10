package com.facebook.imagepipeline.memory;

import android.util.SparseIntArray;

public class DefaultByteArrayPoolParams
{
  private static final int DEFAULT_BUCKET_SIZE = 5;
  private static final int DEFAULT_IO_BUFFER_SIZE = 16384;
  private static final int MAX_SIZE_HARD_CAP = 1048576;
  private static final int MAX_SIZE_SOFT_CAP = 81920;

  public static PoolParams get()
  {
    SparseIntArray localSparseIntArray = new SparseIntArray();
    localSparseIntArray.put(16384, 5);
    return new PoolParams(81920, 1048576, localSparseIntArray);
  }
}

/* Location:           C:\Users\c_jealom1\Documents\Scripts\Android\Fathom_com.brynk.fathom\Fathom_com.brynk.fathom-dex2jar.jar
 * Qualified Name:     com.facebook.imagepipeline.memory.DefaultByteArrayPoolParams
 * JD-Core Version:    0.6.0
 */
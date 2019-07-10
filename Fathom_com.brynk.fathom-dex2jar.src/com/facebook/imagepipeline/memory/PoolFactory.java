package com.facebook.imagepipeline.memory;

import com.facebook.common.internal.Preconditions;
import com.facebook.common.memory.ByteArrayPool;
import com.facebook.common.memory.PooledByteBufferFactory;
import com.facebook.common.memory.PooledByteStreams;
import javax.annotation.concurrent.NotThreadSafe;

@NotThreadSafe
public class PoolFactory
{
  private BitmapPool mBitmapPool;
  private final PoolConfig mConfig;
  private FlexByteArrayPool mFlexByteArrayPool;
  private NativeMemoryChunkPool mNativeMemoryChunkPool;
  private PooledByteBufferFactory mPooledByteBufferFactory;
  private PooledByteStreams mPooledByteStreams;
  private SharedByteArray mSharedByteArray;
  private ByteArrayPool mSmallByteArrayPool;

  public PoolFactory(PoolConfig paramPoolConfig)
  {
    this.mConfig = ((PoolConfig)Preconditions.checkNotNull(paramPoolConfig));
  }

  public BitmapPool getBitmapPool()
  {
    if (this.mBitmapPool == null)
      this.mBitmapPool = new BitmapPool(this.mConfig.getMemoryTrimmableRegistry(), this.mConfig.getBitmapPoolParams(), this.mConfig.getBitmapPoolStatsTracker());
    return this.mBitmapPool;
  }

  public FlexByteArrayPool getFlexByteArrayPool()
  {
    if (this.mFlexByteArrayPool == null)
      this.mFlexByteArrayPool = new FlexByteArrayPool(this.mConfig.getMemoryTrimmableRegistry(), this.mConfig.getFlexByteArrayPoolParams());
    return this.mFlexByteArrayPool;
  }

  public int getFlexByteArrayPoolMaxNumThreads()
  {
    return this.mConfig.getFlexByteArrayPoolParams().maxNumThreads;
  }

  public NativeMemoryChunkPool getNativeMemoryChunkPool()
  {
    if (this.mNativeMemoryChunkPool == null)
      this.mNativeMemoryChunkPool = new NativeMemoryChunkPool(this.mConfig.getMemoryTrimmableRegistry(), this.mConfig.getNativeMemoryChunkPoolParams(), this.mConfig.getNativeMemoryChunkPoolStatsTracker());
    return this.mNativeMemoryChunkPool;
  }

  public PooledByteBufferFactory getPooledByteBufferFactory()
  {
    if (this.mPooledByteBufferFactory == null)
      this.mPooledByteBufferFactory = new NativePooledByteBufferFactory(getNativeMemoryChunkPool(), getPooledByteStreams());
    return this.mPooledByteBufferFactory;
  }

  public PooledByteStreams getPooledByteStreams()
  {
    if (this.mPooledByteStreams == null)
      this.mPooledByteStreams = new PooledByteStreams(getSmallByteArrayPool());
    return this.mPooledByteStreams;
  }

  public SharedByteArray getSharedByteArray()
  {
    if (this.mSharedByteArray == null)
      this.mSharedByteArray = new SharedByteArray(this.mConfig.getMemoryTrimmableRegistry(), this.mConfig.getFlexByteArrayPoolParams());
    return this.mSharedByteArray;
  }

  public ByteArrayPool getSmallByteArrayPool()
  {
    if (this.mSmallByteArrayPool == null)
      this.mSmallByteArrayPool = new GenericByteArrayPool(this.mConfig.getMemoryTrimmableRegistry(), this.mConfig.getSmallByteArrayPoolParams(), this.mConfig.getSmallByteArrayPoolStatsTracker());
    return this.mSmallByteArrayPool;
  }
}

/* Location:           C:\Users\c_jealom1\Documents\Scripts\Android\Fathom_com.brynk.fathom\Fathom_com.brynk.fathom-dex2jar.jar
 * Qualified Name:     com.facebook.imagepipeline.memory.PoolFactory
 * JD-Core Version:    0.6.0
 */
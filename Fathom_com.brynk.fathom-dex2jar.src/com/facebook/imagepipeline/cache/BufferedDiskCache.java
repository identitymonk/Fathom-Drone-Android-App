package com.facebook.imagepipeline.cache;

import bolts.Task;
import com.facebook.cache.common.CacheKey;
import com.facebook.cache.common.WriterCallback;
import com.facebook.cache.disk.FileCache;
import com.facebook.common.internal.Preconditions;
import com.facebook.common.logging.FLog;
import com.facebook.common.memory.PooledByteBufferFactory;
import com.facebook.common.memory.PooledByteStreams;
import com.facebook.imagepipeline.image.EncodedImage;
import java.io.IOException;
import java.io.OutputStream;
import java.util.concurrent.Callable;
import java.util.concurrent.Executor;
import java.util.concurrent.atomic.AtomicBoolean;

public class BufferedDiskCache
{
  private static final Class<?> TAG = BufferedDiskCache.class;
  private final FileCache mFileCache;
  private final ImageCacheStatsTracker mImageCacheStatsTracker;
  private final PooledByteBufferFactory mPooledByteBufferFactory;
  private final PooledByteStreams mPooledByteStreams;
  private final Executor mReadExecutor;
  private final StagingArea mStagingArea;
  private final Executor mWriteExecutor;

  public BufferedDiskCache(FileCache paramFileCache, PooledByteBufferFactory paramPooledByteBufferFactory, PooledByteStreams paramPooledByteStreams, Executor paramExecutor1, Executor paramExecutor2, ImageCacheStatsTracker paramImageCacheStatsTracker)
  {
    this.mFileCache = paramFileCache;
    this.mPooledByteBufferFactory = paramPooledByteBufferFactory;
    this.mPooledByteStreams = paramPooledByteStreams;
    this.mReadExecutor = paramExecutor1;
    this.mWriteExecutor = paramExecutor2;
    this.mImageCacheStatsTracker = paramImageCacheStatsTracker;
    this.mStagingArea = StagingArea.getInstance();
  }

  private boolean checkInStagingAreaAndFileCache(CacheKey paramCacheKey)
  {
    EncodedImage localEncodedImage = this.mStagingArea.get(paramCacheKey);
    if (localEncodedImage != null)
    {
      localEncodedImage.close();
      FLog.v(TAG, "Found image for %s in staging area", paramCacheKey.getUriString());
      this.mImageCacheStatsTracker.onStagingAreaHit(paramCacheKey);
      return true;
    }
    FLog.v(TAG, "Did not find image for %s in staging area", paramCacheKey.getUriString());
    this.mImageCacheStatsTracker.onStagingAreaMiss();
    try
    {
      boolean bool = this.mFileCache.hasKey(paramCacheKey);
      return bool;
    }
    catch (Exception paramCacheKey)
    {
    }
    return false;
  }

  private Task<Boolean> containsAsync(CacheKey paramCacheKey)
  {
    try
    {
      Task localTask = Task.call(new Callable(paramCacheKey)
      {
        public Boolean call()
          throws Exception
        {
          return Boolean.valueOf(BufferedDiskCache.this.checkInStagingAreaAndFileCache(this.val$key));
        }
      }
      , this.mReadExecutor);
      return localTask;
    }
    catch (Exception localException)
    {
      FLog.w(TAG, localException, "Failed to schedule disk-cache read for %s", new Object[] { paramCacheKey.getUriString() });
    }
    return Task.forError(localException);
  }

  private Task<EncodedImage> foundPinnedImage(CacheKey paramCacheKey, EncodedImage paramEncodedImage)
  {
    FLog.v(TAG, "Found image for %s in staging area", paramCacheKey.getUriString());
    this.mImageCacheStatsTracker.onStagingAreaHit(paramCacheKey);
    return Task.forResult(paramEncodedImage);
  }

  private Task<EncodedImage> getAsync(CacheKey paramCacheKey, AtomicBoolean paramAtomicBoolean)
  {
    try
    {
      paramAtomicBoolean = Task.call(new Callable(paramAtomicBoolean, paramCacheKey)
      {
        // ERROR //
        public EncodedImage call()
          throws Exception
        {
          // Byte code:
          //   0: aload_0
          //   1: getfield 24	com/facebook/imagepipeline/cache/BufferedDiskCache$2:val$isCancelled	Ljava/util/concurrent/atomic/AtomicBoolean;
          //   4: invokevirtual 40	java/util/concurrent/atomic/AtomicBoolean:get	()Z
          //   7: ifeq +11 -> 18
          //   10: new 42	java/util/concurrent/CancellationException
          //   13: dup
          //   14: invokespecial 43	java/util/concurrent/CancellationException:<init>	()V
          //   17: athrow
          //   18: aload_0
          //   19: getfield 22	com/facebook/imagepipeline/cache/BufferedDiskCache$2:this$0	Lcom/facebook/imagepipeline/cache/BufferedDiskCache;
          //   22: invokestatic 47	com/facebook/imagepipeline/cache/BufferedDiskCache:access$100	(Lcom/facebook/imagepipeline/cache/BufferedDiskCache;)Lcom/facebook/imagepipeline/cache/StagingArea;
          //   25: aload_0
          //   26: getfield 26	com/facebook/imagepipeline/cache/BufferedDiskCache$2:val$key	Lcom/facebook/cache/common/CacheKey;
          //   29: invokevirtual 52	com/facebook/imagepipeline/cache/StagingArea:get	(Lcom/facebook/cache/common/CacheKey;)Lcom/facebook/imagepipeline/image/EncodedImage;
          //   32: astore_1
          //   33: aload_1
          //   34: ifnull +74 -> 108
          //   37: invokestatic 56	com/facebook/imagepipeline/cache/BufferedDiskCache:access$200	()Ljava/lang/Class;
          //   40: ldc 58
          //   42: aload_0
          //   43: getfield 26	com/facebook/imagepipeline/cache/BufferedDiskCache$2:val$key	Lcom/facebook/cache/common/CacheKey;
          //   46: invokeinterface 64 1 0
          //   51: invokestatic 70	com/facebook/common/logging/FLog:v	(Ljava/lang/Class;Ljava/lang/String;Ljava/lang/Object;)V
          //   54: aload_0
          //   55: getfield 22	com/facebook/imagepipeline/cache/BufferedDiskCache$2:this$0	Lcom/facebook/imagepipeline/cache/BufferedDiskCache;
          //   58: invokestatic 74	com/facebook/imagepipeline/cache/BufferedDiskCache:access$300	(Lcom/facebook/imagepipeline/cache/BufferedDiskCache;)Lcom/facebook/imagepipeline/cache/ImageCacheStatsTracker;
          //   61: aload_0
          //   62: getfield 26	com/facebook/imagepipeline/cache/BufferedDiskCache$2:val$key	Lcom/facebook/cache/common/CacheKey;
          //   65: invokeinterface 80 2 0
          //   70: aload_1
          //   71: aload_0
          //   72: getfield 26	com/facebook/imagepipeline/cache/BufferedDiskCache$2:val$key	Lcom/facebook/cache/common/CacheKey;
          //   75: invokevirtual 85	com/facebook/imagepipeline/image/EncodedImage:setEncodedCacheKey	(Lcom/facebook/cache/common/CacheKey;)V
          //   78: invokestatic 90	java/lang/Thread:interrupted	()Z
          //   81: ifeq +105 -> 186
          //   84: invokestatic 56	com/facebook/imagepipeline/cache/BufferedDiskCache:access$200	()Ljava/lang/Class;
          //   87: ldc 92
          //   89: invokestatic 95	com/facebook/common/logging/FLog:v	(Ljava/lang/Class;Ljava/lang/String;)V
          //   92: aload_1
          //   93: ifnull +7 -> 100
          //   96: aload_1
          //   97: invokevirtual 98	com/facebook/imagepipeline/image/EncodedImage:close	()V
          //   100: new 100	java/lang/InterruptedException
          //   103: dup
          //   104: invokespecial 101	java/lang/InterruptedException:<init>	()V
          //   107: athrow
          //   108: invokestatic 56	com/facebook/imagepipeline/cache/BufferedDiskCache:access$200	()Ljava/lang/Class;
          //   111: ldc 103
          //   113: aload_0
          //   114: getfield 26	com/facebook/imagepipeline/cache/BufferedDiskCache$2:val$key	Lcom/facebook/cache/common/CacheKey;
          //   117: invokeinterface 64 1 0
          //   122: invokestatic 70	com/facebook/common/logging/FLog:v	(Ljava/lang/Class;Ljava/lang/String;Ljava/lang/Object;)V
          //   125: aload_0
          //   126: getfield 22	com/facebook/imagepipeline/cache/BufferedDiskCache$2:this$0	Lcom/facebook/imagepipeline/cache/BufferedDiskCache;
          //   129: invokestatic 74	com/facebook/imagepipeline/cache/BufferedDiskCache:access$300	(Lcom/facebook/imagepipeline/cache/BufferedDiskCache;)Lcom/facebook/imagepipeline/cache/ImageCacheStatsTracker;
          //   132: invokeinterface 106 1 0
          //   137: aload_0
          //   138: getfield 22	com/facebook/imagepipeline/cache/BufferedDiskCache$2:this$0	Lcom/facebook/imagepipeline/cache/BufferedDiskCache;
          //   141: aload_0
          //   142: getfield 26	com/facebook/imagepipeline/cache/BufferedDiskCache$2:val$key	Lcom/facebook/cache/common/CacheKey;
          //   145: invokestatic 110	com/facebook/imagepipeline/cache/BufferedDiskCache:access$400	(Lcom/facebook/imagepipeline/cache/BufferedDiskCache;Lcom/facebook/cache/common/CacheKey;)Lcom/facebook/common/memory/PooledByteBuffer;
          //   148: invokestatic 116	com/facebook/common/references/CloseableReference:of	(Ljava/io/Closeable;)Lcom/facebook/common/references/CloseableReference;
          //   151: astore_2
          //   152: new 82	com/facebook/imagepipeline/image/EncodedImage
          //   155: dup
          //   156: aload_2
          //   157: invokespecial 119	com/facebook/imagepipeline/image/EncodedImage:<init>	(Lcom/facebook/common/references/CloseableReference;)V
          //   160: astore_1
          //   161: aload_1
          //   162: aload_0
          //   163: getfield 26	com/facebook/imagepipeline/cache/BufferedDiskCache$2:val$key	Lcom/facebook/cache/common/CacheKey;
          //   166: invokevirtual 85	com/facebook/imagepipeline/image/EncodedImage:setEncodedCacheKey	(Lcom/facebook/cache/common/CacheKey;)V
          //   169: aload_2
          //   170: invokestatic 122	com/facebook/common/references/CloseableReference:closeSafely	(Lcom/facebook/common/references/CloseableReference;)V
          //   173: goto -95 -> 78
          //   176: astore_1
          //   177: aload_2
          //   178: invokestatic 122	com/facebook/common/references/CloseableReference:closeSafely	(Lcom/facebook/common/references/CloseableReference;)V
          //   181: aload_1
          //   182: athrow
          //   183: astore_1
          //   184: aconst_null
          //   185: areturn
          //   186: aload_1
          //   187: areturn
          //   188: astore_1
          //   189: goto -5 -> 184
          //   192: astore_1
          //   193: goto -16 -> 177
          //
          // Exception table:
          //   from	to	target	type
          //   152	161	176	finally
          //   137	152	183	java/lang/Exception
          //   177	183	183	java/lang/Exception
          //   169	173	188	java/lang/Exception
          //   161	169	192	finally
        }
      }
      , this.mReadExecutor);
      return paramAtomicBoolean;
    }
    catch (Exception paramAtomicBoolean)
    {
      FLog.w(TAG, paramAtomicBoolean, "Failed to schedule disk-cache read for %s", new Object[] { paramCacheKey.getUriString() });
    }
    return Task.forError(paramAtomicBoolean);
  }

  // ERROR //
  private com.facebook.common.memory.PooledByteBuffer readFromDiskCache(CacheKey paramCacheKey)
    throws IOException
  {
    // Byte code:
    //   0: getstatic 36	com/facebook/imagepipeline/cache/BufferedDiskCache:TAG	Ljava/lang/Class;
    //   3: ldc 171
    //   5: aload_1
    //   6: invokeinterface 111 1 0
    //   11: invokestatic 117	com/facebook/common/logging/FLog:v	(Ljava/lang/Class;Ljava/lang/String;Ljava/lang/Object;)V
    //   14: aload_0
    //   15: getfield 43	com/facebook/imagepipeline/cache/BufferedDiskCache:mFileCache	Lcom/facebook/cache/disk/FileCache;
    //   18: aload_1
    //   19: invokeinterface 175 2 0
    //   24: astore_3
    //   25: aload_3
    //   26: ifnonnull +28 -> 54
    //   29: getstatic 36	com/facebook/imagepipeline/cache/BufferedDiskCache:TAG	Ljava/lang/Class;
    //   32: ldc 177
    //   34: aload_1
    //   35: invokeinterface 111 1 0
    //   40: invokestatic 117	com/facebook/common/logging/FLog:v	(Ljava/lang/Class;Ljava/lang/String;Ljava/lang/Object;)V
    //   43: aload_0
    //   44: getfield 53	com/facebook/imagepipeline/cache/BufferedDiskCache:mImageCacheStatsTracker	Lcom/facebook/imagepipeline/cache/ImageCacheStatsTracker;
    //   47: invokeinterface 180 1 0
    //   52: aconst_null
    //   53: areturn
    //   54: getstatic 36	com/facebook/imagepipeline/cache/BufferedDiskCache:TAG	Ljava/lang/Class;
    //   57: ldc 182
    //   59: aload_1
    //   60: invokeinterface 111 1 0
    //   65: invokestatic 117	com/facebook/common/logging/FLog:v	(Ljava/lang/Class;Ljava/lang/String;Ljava/lang/Object;)V
    //   68: aload_0
    //   69: getfield 53	com/facebook/imagepipeline/cache/BufferedDiskCache:mImageCacheStatsTracker	Lcom/facebook/imagepipeline/cache/ImageCacheStatsTracker;
    //   72: invokeinterface 185 1 0
    //   77: aload_3
    //   78: invokeinterface 191 1 0
    //   83: astore_2
    //   84: aload_0
    //   85: getfield 45	com/facebook/imagepipeline/cache/BufferedDiskCache:mPooledByteBufferFactory	Lcom/facebook/common/memory/PooledByteBufferFactory;
    //   88: aload_2
    //   89: aload_3
    //   90: invokeinterface 195 1 0
    //   95: l2i
    //   96: invokeinterface 201 3 0
    //   101: astore_3
    //   102: aload_2
    //   103: invokevirtual 204	java/io/InputStream:close	()V
    //   106: getstatic 36	com/facebook/imagepipeline/cache/BufferedDiskCache:TAG	Ljava/lang/Class;
    //   109: ldc 206
    //   111: aload_1
    //   112: invokeinterface 111 1 0
    //   117: invokestatic 117	com/facebook/common/logging/FLog:v	(Ljava/lang/Class;Ljava/lang/String;Ljava/lang/Object;)V
    //   120: aload_3
    //   121: areturn
    //   122: astore_2
    //   123: getstatic 36	com/facebook/imagepipeline/cache/BufferedDiskCache:TAG	Ljava/lang/Class;
    //   126: aload_2
    //   127: ldc 208
    //   129: iconst_1
    //   130: anewarray 4	java/lang/Object
    //   133: dup
    //   134: iconst_0
    //   135: aload_1
    //   136: invokeinterface 111 1 0
    //   141: aastore
    //   142: invokestatic 150	com/facebook/common/logging/FLog:w	(Ljava/lang/Class;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   145: aload_0
    //   146: getfield 53	com/facebook/imagepipeline/cache/BufferedDiskCache:mImageCacheStatsTracker	Lcom/facebook/imagepipeline/cache/ImageCacheStatsTracker;
    //   149: invokeinterface 211 1 0
    //   154: aload_2
    //   155: athrow
    //   156: astore_3
    //   157: aload_2
    //   158: invokevirtual 204	java/io/InputStream:close	()V
    //   161: aload_3
    //   162: athrow
    //
    // Exception table:
    //   from	to	target	type
    //   0	25	122	java/io/IOException
    //   29	52	122	java/io/IOException
    //   54	84	122	java/io/IOException
    //   102	120	122	java/io/IOException
    //   157	163	122	java/io/IOException
    //   84	102	156	finally
  }

  private void writeToDiskCache(CacheKey paramCacheKey, EncodedImage paramEncodedImage)
  {
    FLog.v(TAG, "About to write to disk-cache for key %s", paramCacheKey.getUriString());
    try
    {
      this.mFileCache.insert(paramCacheKey, new WriterCallback(paramEncodedImage)
      {
        public void write(OutputStream paramOutputStream)
          throws IOException
        {
          BufferedDiskCache.this.mPooledByteStreams.copy(this.val$encodedImage.getInputStream(), paramOutputStream);
        }
      });
      FLog.v(TAG, "Successful disk-cache write for key %s", paramCacheKey.getUriString());
      return;
    }
    catch (IOException paramEncodedImage)
    {
      FLog.w(TAG, paramEncodedImage, "Failed to write to disk-cache for key %s", new Object[] { paramCacheKey.getUriString() });
    }
  }

  public Task<Void> clearAll()
  {
    this.mStagingArea.clearAll();
    try
    {
      Task localTask = Task.call(new Callable()
      {
        public Void call()
          throws Exception
        {
          BufferedDiskCache.this.mStagingArea.clearAll();
          BufferedDiskCache.this.mFileCache.clearAll();
          return null;
        }
      }
      , this.mWriteExecutor);
      return localTask;
    }
    catch (Exception localException)
    {
      FLog.w(TAG, localException, "Failed to schedule disk-cache clear", new Object[0]);
    }
    return Task.forError(localException);
  }

  public Task<Boolean> contains(CacheKey paramCacheKey)
  {
    if (containsSync(paramCacheKey))
      return Task.forResult(Boolean.valueOf(true));
    return containsAsync(paramCacheKey);
  }

  public boolean containsSync(CacheKey paramCacheKey)
  {
    return (this.mStagingArea.containsKey(paramCacheKey)) || (this.mFileCache.hasKeySync(paramCacheKey));
  }

  public boolean diskCheckSync(CacheKey paramCacheKey)
  {
    if (containsSync(paramCacheKey))
      return true;
    return checkInStagingAreaAndFileCache(paramCacheKey);
  }

  public Task<EncodedImage> get(CacheKey paramCacheKey, AtomicBoolean paramAtomicBoolean)
  {
    EncodedImage localEncodedImage = this.mStagingArea.get(paramCacheKey);
    if (localEncodedImage != null)
      return foundPinnedImage(paramCacheKey, localEncodedImage);
    return getAsync(paramCacheKey, paramAtomicBoolean);
  }

  public void put(CacheKey paramCacheKey, EncodedImage paramEncodedImage)
  {
    Preconditions.checkNotNull(paramCacheKey);
    Preconditions.checkArgument(EncodedImage.isValid(paramEncodedImage));
    this.mStagingArea.put(paramCacheKey, paramEncodedImage);
    paramEncodedImage.setEncodedCacheKey(paramCacheKey);
    EncodedImage localEncodedImage = EncodedImage.cloneOrNull(paramEncodedImage);
    try
    {
      this.mWriteExecutor.execute(new Runnable(paramCacheKey, localEncodedImage)
      {
        public void run()
        {
          try
          {
            BufferedDiskCache.this.writeToDiskCache(this.val$key, this.val$finalEncodedImage);
            return;
          }
          finally
          {
            BufferedDiskCache.this.mStagingArea.remove(this.val$key, this.val$finalEncodedImage);
            EncodedImage.closeSafely(this.val$finalEncodedImage);
          }
          throw localObject;
        }
      });
      return;
    }
    catch (Exception localException)
    {
      FLog.w(TAG, localException, "Failed to schedule disk-cache write for %s", new Object[] { paramCacheKey.getUriString() });
      this.mStagingArea.remove(paramCacheKey, paramEncodedImage);
      EncodedImage.closeSafely(localEncodedImage);
    }
  }

  public Task<Void> remove(CacheKey paramCacheKey)
  {
    Preconditions.checkNotNull(paramCacheKey);
    this.mStagingArea.remove(paramCacheKey);
    try
    {
      Task localTask = Task.call(new Callable(paramCacheKey)
      {
        public Void call()
          throws Exception
        {
          BufferedDiskCache.this.mStagingArea.remove(this.val$key);
          BufferedDiskCache.this.mFileCache.remove(this.val$key);
          return null;
        }
      }
      , this.mWriteExecutor);
      return localTask;
    }
    catch (Exception localException)
    {
      FLog.w(TAG, localException, "Failed to schedule disk-cache remove for %s", new Object[] { paramCacheKey.getUriString() });
    }
    return Task.forError(localException);
  }
}

/* Location:           C:\Users\c_jealom1\Documents\Scripts\Android\Fathom_com.brynk.fathom\Fathom_com.brynk.fathom-dex2jar.jar
 * Qualified Name:     com.facebook.imagepipeline.cache.BufferedDiskCache
 * JD-Core Version:    0.6.0
 */
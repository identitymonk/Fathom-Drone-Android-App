package com.facebook.imagepipeline.cache;

import com.facebook.cache.common.CacheKey;
import com.facebook.common.internal.Preconditions;
import com.facebook.common.logging.FLog;
import com.facebook.imagepipeline.image.EncodedImage;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.annotation.concurrent.GuardedBy;

public class StagingArea
{
  private static final Class<?> TAG = StagingArea.class;

  @GuardedBy("this")
  private Map<CacheKey, EncodedImage> mMap = new HashMap();

  public static StagingArea getInstance()
  {
    return new StagingArea();
  }

  private void logStats()
  {
    monitorenter;
    try
    {
      FLog.v(TAG, "Count = %d", Integer.valueOf(this.mMap.size()));
      monitorexit;
      return;
    }
    finally
    {
      localObject = finally;
      monitorexit;
    }
    throw localObject;
  }

  public void clearAll()
  {
    monitorenter;
    try
    {
      ArrayList localArrayList = new ArrayList(this.mMap.values());
      this.mMap.clear();
      monitorexit;
      int i = 0;
      while (i < localArrayList.size())
      {
        EncodedImage localEncodedImage = (EncodedImage)localArrayList.get(i);
        if (localEncodedImage != null)
          localEncodedImage.close();
        i += 1;
      }
    }
    finally
    {
      monitorexit;
    }
  }

  public boolean containsKey(CacheKey paramCacheKey)
  {
    int i = 0;
    monitorenter;
    while (true)
    {
      try
      {
        Preconditions.checkNotNull(paramCacheKey);
        boolean bool = this.mMap.containsKey(paramCacheKey);
        if (!bool)
          return i;
        synchronized ((EncodedImage)this.mMap.get(paramCacheKey))
        {
          if (!EncodedImage.isValid(???))
          {
            this.mMap.remove(paramCacheKey);
            FLog.w(TAG, "Found closed reference %d for key %s (%d)", new Object[] { Integer.valueOf(System.identityHashCode(???)), paramCacheKey.getUriString(), Integer.valueOf(System.identityHashCode(paramCacheKey)) });
          }
        }
      }
      finally
      {
        monitorexit;
      }
      monitorexit;
      i = 1;
    }
  }

  // ERROR //
  public EncodedImage get(CacheKey paramCacheKey)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_1
    //   3: invokestatic 83	com/facebook/common/internal/Preconditions:checkNotNull	(Ljava/lang/Object;)Ljava/lang/Object;
    //   6: pop
    //   7: aload_0
    //   8: getfield 26	com/facebook/imagepipeline/cache/StagingArea:mMap	Ljava/util/Map;
    //   11: aload_1
    //   12: invokeinterface 88 2 0
    //   17: checkcast 72	com/facebook/imagepipeline/image/EncodedImage
    //   20: astore_3
    //   21: aload_3
    //   22: astore_2
    //   23: aload_3
    //   24: ifnull +95 -> 119
    //   27: aload_3
    //   28: monitorenter
    //   29: aload_3
    //   30: invokestatic 92	com/facebook/imagepipeline/image/EncodedImage:isValid	(Lcom/facebook/imagepipeline/image/EncodedImage;)Z
    //   33: ifne +63 -> 96
    //   36: aload_0
    //   37: getfield 26	com/facebook/imagepipeline/cache/StagingArea:mMap	Ljava/util/Map;
    //   40: aload_1
    //   41: invokeinterface 95 2 0
    //   46: pop
    //   47: getstatic 17	com/facebook/imagepipeline/cache/StagingArea:TAG	Ljava/lang/Class;
    //   50: ldc 97
    //   52: iconst_3
    //   53: anewarray 4	java/lang/Object
    //   56: dup
    //   57: iconst_0
    //   58: aload_3
    //   59: invokestatic 103	java/lang/System:identityHashCode	(Ljava/lang/Object;)I
    //   62: invokestatic 44	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   65: aastore
    //   66: dup
    //   67: iconst_1
    //   68: aload_1
    //   69: invokeinterface 109 1 0
    //   74: aastore
    //   75: dup
    //   76: iconst_2
    //   77: aload_1
    //   78: invokestatic 103	java/lang/System:identityHashCode	(Ljava/lang/Object;)I
    //   81: invokestatic 44	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   84: aastore
    //   85: invokestatic 113	com/facebook/common/logging/FLog:w	(Ljava/lang/Class;Ljava/lang/String;[Ljava/lang/Object;)V
    //   88: aconst_null
    //   89: astore_1
    //   90: aload_3
    //   91: monitorexit
    //   92: aload_0
    //   93: monitorexit
    //   94: aload_1
    //   95: areturn
    //   96: aload_3
    //   97: invokestatic 118	com/facebook/imagepipeline/image/EncodedImage:cloneOrNull	(Lcom/facebook/imagepipeline/image/EncodedImage;)Lcom/facebook/imagepipeline/image/EncodedImage;
    //   100: astore_2
    //   101: aload_3
    //   102: monitorexit
    //   103: goto +16 -> 119
    //   106: aload_3
    //   107: monitorexit
    //   108: aload_1
    //   109: athrow
    //   110: astore_1
    //   111: aload_0
    //   112: monitorexit
    //   113: aload_1
    //   114: athrow
    //   115: astore_1
    //   116: goto -10 -> 106
    //   119: aload_2
    //   120: astore_1
    //   121: goto -29 -> 92
    //   124: astore_1
    //   125: goto -19 -> 106
    //
    // Exception table:
    //   from	to	target	type
    //   2	21	110	finally
    //   27	29	110	finally
    //   108	110	110	finally
    //   101	103	115	finally
    //   106	108	115	finally
    //   29	88	124	finally
    //   90	92	124	finally
    //   96	101	124	finally
  }

  public void put(CacheKey paramCacheKey, EncodedImage paramEncodedImage)
  {
    monitorenter;
    try
    {
      Preconditions.checkNotNull(paramCacheKey);
      Preconditions.checkArgument(EncodedImage.isValid(paramEncodedImage));
      EncodedImage.closeSafely((EncodedImage)this.mMap.put(paramCacheKey, EncodedImage.cloneOrNull(paramEncodedImage)));
      logStats();
      monitorexit;
      return;
    }
    finally
    {
      paramCacheKey = finally;
      monitorexit;
    }
    throw paramCacheKey;
  }

  public boolean remove(CacheKey paramCacheKey)
  {
    Preconditions.checkNotNull(paramCacheKey);
    monitorenter;
    try
    {
      paramCacheKey = (EncodedImage)this.mMap.remove(paramCacheKey);
      monitorexit;
      if (paramCacheKey == null)
        return false;
    }
    finally
    {
      monitorexit;
    }
    try
    {
      boolean bool = paramCacheKey.isValid();
      return bool;
    }
    finally
    {
      paramCacheKey.close();
    }
    throw localObject;
  }

  // ERROR //
  public boolean remove(CacheKey paramCacheKey, EncodedImage paramEncodedImage)
  {
    // Byte code:
    //   0: iconst_0
    //   1: istore_3
    //   2: aload_0
    //   3: monitorenter
    //   4: aload_1
    //   5: invokestatic 83	com/facebook/common/internal/Preconditions:checkNotNull	(Ljava/lang/Object;)Ljava/lang/Object;
    //   8: pop
    //   9: aload_2
    //   10: invokestatic 83	com/facebook/common/internal/Preconditions:checkNotNull	(Ljava/lang/Object;)Ljava/lang/Object;
    //   13: pop
    //   14: aload_2
    //   15: invokestatic 92	com/facebook/imagepipeline/image/EncodedImage:isValid	(Lcom/facebook/imagepipeline/image/EncodedImage;)Z
    //   18: invokestatic 124	com/facebook/common/internal/Preconditions:checkArgument	(Z)V
    //   21: aload_0
    //   22: getfield 26	com/facebook/imagepipeline/cache/StagingArea:mMap	Ljava/util/Map;
    //   25: aload_1
    //   26: invokeinterface 88 2 0
    //   31: checkcast 72	com/facebook/imagepipeline/image/EncodedImage
    //   34: astore 4
    //   36: aload 4
    //   38: ifnonnull +7 -> 45
    //   41: aload_0
    //   42: monitorexit
    //   43: iload_3
    //   44: ireturn
    //   45: aload 4
    //   47: invokevirtual 141	com/facebook/imagepipeline/image/EncodedImage:getByteBufferRef	()Lcom/facebook/common/references/CloseableReference;
    //   50: astore 5
    //   52: aload_2
    //   53: invokevirtual 141	com/facebook/imagepipeline/image/EncodedImage:getByteBufferRef	()Lcom/facebook/common/references/CloseableReference;
    //   56: astore_2
    //   57: aload 5
    //   59: ifnull +27 -> 86
    //   62: aload_2
    //   63: ifnull +23 -> 86
    //   66: aload 5
    //   68: invokevirtual 146	com/facebook/common/references/CloseableReference:get	()Ljava/lang/Object;
    //   71: astore 6
    //   73: aload_2
    //   74: invokevirtual 146	com/facebook/common/references/CloseableReference:get	()Ljava/lang/Object;
    //   77: astore 7
    //   79: aload 6
    //   81: aload 7
    //   83: if_acmpeq +25 -> 108
    //   86: aload_2
    //   87: invokestatic 149	com/facebook/common/references/CloseableReference:closeSafely	(Lcom/facebook/common/references/CloseableReference;)V
    //   90: aload 5
    //   92: invokestatic 149	com/facebook/common/references/CloseableReference:closeSafely	(Lcom/facebook/common/references/CloseableReference;)V
    //   95: aload 4
    //   97: invokestatic 131	com/facebook/imagepipeline/image/EncodedImage:closeSafely	(Lcom/facebook/imagepipeline/image/EncodedImage;)V
    //   100: goto -59 -> 41
    //   103: astore_1
    //   104: aload_0
    //   105: monitorexit
    //   106: aload_1
    //   107: athrow
    //   108: aload_0
    //   109: getfield 26	com/facebook/imagepipeline/cache/StagingArea:mMap	Ljava/util/Map;
    //   112: aload_1
    //   113: invokeinterface 95 2 0
    //   118: pop
    //   119: aload_2
    //   120: invokestatic 149	com/facebook/common/references/CloseableReference:closeSafely	(Lcom/facebook/common/references/CloseableReference;)V
    //   123: aload 5
    //   125: invokestatic 149	com/facebook/common/references/CloseableReference:closeSafely	(Lcom/facebook/common/references/CloseableReference;)V
    //   128: aload 4
    //   130: invokestatic 131	com/facebook/imagepipeline/image/EncodedImage:closeSafely	(Lcom/facebook/imagepipeline/image/EncodedImage;)V
    //   133: aload_0
    //   134: invokespecial 133	com/facebook/imagepipeline/cache/StagingArea:logStats	()V
    //   137: iconst_1
    //   138: istore_3
    //   139: goto -98 -> 41
    //   142: astore_1
    //   143: aload_2
    //   144: invokestatic 149	com/facebook/common/references/CloseableReference:closeSafely	(Lcom/facebook/common/references/CloseableReference;)V
    //   147: aload 5
    //   149: invokestatic 149	com/facebook/common/references/CloseableReference:closeSafely	(Lcom/facebook/common/references/CloseableReference;)V
    //   152: aload 4
    //   154: invokestatic 131	com/facebook/imagepipeline/image/EncodedImage:closeSafely	(Lcom/facebook/imagepipeline/image/EncodedImage;)V
    //   157: aload_1
    //   158: athrow
    //
    // Exception table:
    //   from	to	target	type
    //   4	36	103	finally
    //   45	57	103	finally
    //   86	100	103	finally
    //   119	137	103	finally
    //   143	159	103	finally
    //   66	79	142	finally
    //   108	119	142	finally
  }
}

/* Location:           C:\Users\c_jealom1\Documents\Scripts\Android\Fathom_com.brynk.fathom\Fathom_com.brynk.fathom-dex2jar.jar
 * Qualified Name:     com.facebook.imagepipeline.cache.StagingArea
 * JD-Core Version:    0.6.0
 */
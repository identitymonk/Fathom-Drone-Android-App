package com.facebook.imagepipeline.memory;

import android.util.Log;
import com.facebook.common.internal.DoNotStrip;
import com.facebook.common.internal.Preconditions;
import com.facebook.common.internal.VisibleForTesting;
import com.facebook.imagepipeline.nativecode.ImagePipelineNativeLoader;
import java.io.Closeable;

@DoNotStrip
public class NativeMemoryChunk
  implements Closeable
{
  private static final String TAG = "NativeMemoryChunk";
  private boolean mClosed;
  private final long mNativePtr;
  private final int mSize;

  static
  {
    ImagePipelineNativeLoader.load();
  }

  @VisibleForTesting
  public NativeMemoryChunk()
  {
    this.mSize = 0;
    this.mNativePtr = 0L;
    this.mClosed = true;
  }

  public NativeMemoryChunk(int paramInt)
  {
    if (paramInt > 0);
    for (boolean bool = true; ; bool = false)
    {
      Preconditions.checkArgument(bool);
      this.mSize = paramInt;
      this.mNativePtr = nativeAllocate(this.mSize);
      this.mClosed = false;
      return;
    }
  }

  private int adjustByteCount(int paramInt1, int paramInt2)
  {
    return Math.min(Math.max(0, this.mSize - paramInt1), paramInt2);
  }

  private void checkBounds(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    boolean bool2 = true;
    if (paramInt4 >= 0)
    {
      bool1 = true;
      Preconditions.checkArgument(bool1);
      if (paramInt1 < 0)
        break label83;
      bool1 = true;
      label23: Preconditions.checkArgument(bool1);
      if (paramInt3 < 0)
        break label89;
      bool1 = true;
      label35: Preconditions.checkArgument(bool1);
      if (paramInt1 + paramInt4 > this.mSize)
        break label95;
      bool1 = true;
      label54: Preconditions.checkArgument(bool1);
      if (paramInt3 + paramInt4 > paramInt2)
        break label101;
    }
    label83: label89: label95: label101: for (boolean bool1 = bool2; ; bool1 = false)
    {
      Preconditions.checkArgument(bool1);
      return;
      bool1 = false;
      break;
      bool1 = false;
      break label23;
      bool1 = false;
      break label35;
      bool1 = false;
      break label54;
    }
  }

  private void doCopy(int paramInt1, NativeMemoryChunk paramNativeMemoryChunk, int paramInt2, int paramInt3)
  {
    boolean bool2 = true;
    if (!isClosed())
    {
      bool1 = true;
      Preconditions.checkState(bool1);
      if (paramNativeMemoryChunk.isClosed())
        break label72;
    }
    label72: for (boolean bool1 = bool2; ; bool1 = false)
    {
      Preconditions.checkState(bool1);
      checkBounds(paramInt1, paramNativeMemoryChunk.mSize, paramInt2, paramInt3);
      nativeMemcpy(paramNativeMemoryChunk.mNativePtr + paramInt2, this.mNativePtr + paramInt1, paramInt3);
      return;
      bool1 = false;
      break;
    }
  }

  @DoNotStrip
  private static native long nativeAllocate(int paramInt);

  @DoNotStrip
  private static native void nativeCopyFromByteArray(long paramLong, byte[] paramArrayOfByte, int paramInt1, int paramInt2);

  @DoNotStrip
  private static native void nativeCopyToByteArray(long paramLong, byte[] paramArrayOfByte, int paramInt1, int paramInt2);

  @DoNotStrip
  private static native void nativeFree(long paramLong);

  @DoNotStrip
  private static native void nativeMemcpy(long paramLong1, long paramLong2, int paramInt);

  @DoNotStrip
  private static native byte nativeReadByte(long paramLong);

  public void close()
  {
    monitorenter;
    try
    {
      if (!this.mClosed)
      {
        this.mClosed = true;
        nativeFree(this.mNativePtr);
      }
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

  // ERROR //
  public void copy(int paramInt1, NativeMemoryChunk paramNativeMemoryChunk, int paramInt2, int paramInt3)
  {
    // Byte code:
    //   0: aload_2
    //   1: invokestatic 89	com/facebook/common/internal/Preconditions:checkNotNull	(Ljava/lang/Object;)Ljava/lang/Object;
    //   4: pop
    //   5: aload_2
    //   6: getfield 33	com/facebook/imagepipeline/memory/NativeMemoryChunk:mNativePtr	J
    //   9: aload_0
    //   10: getfield 33	com/facebook/imagepipeline/memory/NativeMemoryChunk:mNativePtr	J
    //   13: lcmp
    //   14: ifne +68 -> 82
    //   17: ldc 11
    //   19: new 91	java/lang/StringBuilder
    //   22: dup
    //   23: invokespecial 92	java/lang/StringBuilder:<init>	()V
    //   26: ldc 94
    //   28: invokevirtual 98	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   31: aload_0
    //   32: invokestatic 104	java/lang/System:identityHashCode	(Ljava/lang/Object;)I
    //   35: invokestatic 110	java/lang/Integer:toHexString	(I)Ljava/lang/String;
    //   38: invokevirtual 98	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   41: ldc 112
    //   43: invokevirtual 98	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   46: aload_2
    //   47: invokestatic 104	java/lang/System:identityHashCode	(Ljava/lang/Object;)I
    //   50: invokestatic 110	java/lang/Integer:toHexString	(I)Ljava/lang/String;
    //   53: invokevirtual 98	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   56: ldc 114
    //   58: invokevirtual 98	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   61: aload_0
    //   62: getfield 33	com/facebook/imagepipeline/memory/NativeMemoryChunk:mNativePtr	J
    //   65: invokestatic 119	java/lang/Long:toHexString	(J)Ljava/lang/String;
    //   68: invokevirtual 98	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   71: invokevirtual 123	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   74: invokestatic 129	android/util/Log:w	(Ljava/lang/String;Ljava/lang/String;)I
    //   77: pop
    //   78: iconst_0
    //   79: invokestatic 43	com/facebook/common/internal/Preconditions:checkArgument	(Z)V
    //   82: aload_2
    //   83: getfield 33	com/facebook/imagepipeline/memory/NativeMemoryChunk:mNativePtr	J
    //   86: aload_0
    //   87: getfield 33	com/facebook/imagepipeline/memory/NativeMemoryChunk:mNativePtr	J
    //   90: lcmp
    //   91: ifge +35 -> 126
    //   94: aload_2
    //   95: monitorenter
    //   96: aload_0
    //   97: monitorenter
    //   98: aload_0
    //   99: iload_1
    //   100: aload_2
    //   101: iload_3
    //   102: iload 4
    //   104: invokespecial 131	com/facebook/imagepipeline/memory/NativeMemoryChunk:doCopy	(ILcom/facebook/imagepipeline/memory/NativeMemoryChunk;II)V
    //   107: aload_0
    //   108: monitorexit
    //   109: aload_2
    //   110: monitorexit
    //   111: return
    //   112: astore 5
    //   114: aload_0
    //   115: monitorexit
    //   116: aload 5
    //   118: athrow
    //   119: astore 5
    //   121: aload_2
    //   122: monitorexit
    //   123: aload 5
    //   125: athrow
    //   126: aload_0
    //   127: monitorenter
    //   128: aload_2
    //   129: monitorenter
    //   130: aload_0
    //   131: iload_1
    //   132: aload_2
    //   133: iload_3
    //   134: iload 4
    //   136: invokespecial 131	com/facebook/imagepipeline/memory/NativeMemoryChunk:doCopy	(ILcom/facebook/imagepipeline/memory/NativeMemoryChunk;II)V
    //   139: aload_2
    //   140: monitorexit
    //   141: aload_0
    //   142: monitorexit
    //   143: return
    //   144: astore_2
    //   145: aload_0
    //   146: monitorexit
    //   147: aload_2
    //   148: athrow
    //   149: astore 5
    //   151: aload_2
    //   152: monitorexit
    //   153: aload 5
    //   155: athrow
    //
    // Exception table:
    //   from	to	target	type
    //   98	109	112	finally
    //   114	116	112	finally
    //   96	98	119	finally
    //   109	111	119	finally
    //   116	119	119	finally
    //   121	123	119	finally
    //   128	130	144	finally
    //   141	143	144	finally
    //   145	147	144	finally
    //   153	156	144	finally
    //   130	141	149	finally
    //   151	153	149	finally
  }

  protected void finalize()
    throws Throwable
  {
    if (isClosed())
      return;
    Log.w("NativeMemoryChunk", "finalize: Chunk " + Integer.toHexString(System.identityHashCode(this)) + " still active. Underlying address = " + Long.toHexString(this.mNativePtr));
    try
    {
      close();
      return;
    }
    finally
    {
      super.finalize();
    }
    throw localObject;
  }

  public long getNativePtr()
  {
    return this.mNativePtr;
  }

  public int getSize()
  {
    return this.mSize;
  }

  public boolean isClosed()
  {
    monitorenter;
    try
    {
      boolean bool = this.mClosed;
      monitorexit;
      return bool;
    }
    finally
    {
      localObject = finally;
      monitorexit;
    }
    throw localObject;
  }

  public byte read(int paramInt)
  {
    boolean bool2 = true;
    monitorenter;
    try
    {
      if (!isClosed())
      {
        bool1 = true;
        Preconditions.checkState(bool1);
        if (paramInt < 0)
          break label63;
        bool1 = true;
        label24: Preconditions.checkArgument(bool1);
        if (paramInt >= this.mSize)
          break label68;
      }
      label63: label68: for (boolean bool1 = bool2; ; bool1 = false)
      {
        Preconditions.checkArgument(bool1);
        int i = nativeReadByte(this.mNativePtr + paramInt);
        return i;
        bool1 = false;
        break;
        bool1 = false;
        break label24;
      }
    }
    finally
    {
      monitorexit;
    }
    throw localObject;
  }

  public int read(int paramInt1, byte[] paramArrayOfByte, int paramInt2, int paramInt3)
  {
    monitorenter;
    try
    {
      Preconditions.checkNotNull(paramArrayOfByte);
      if (!isClosed());
      for (boolean bool = true; ; bool = false)
      {
        Preconditions.checkState(bool);
        paramInt3 = adjustByteCount(paramInt1, paramInt3);
        checkBounds(paramInt1, paramArrayOfByte.length, paramInt2, paramInt3);
        nativeCopyToByteArray(this.mNativePtr + paramInt1, paramArrayOfByte, paramInt2, paramInt3);
        return paramInt3;
      }
    }
    finally
    {
      monitorexit;
    }
    throw paramArrayOfByte;
  }

  public int write(int paramInt1, byte[] paramArrayOfByte, int paramInt2, int paramInt3)
  {
    monitorenter;
    try
    {
      Preconditions.checkNotNull(paramArrayOfByte);
      if (!isClosed());
      for (boolean bool = true; ; bool = false)
      {
        Preconditions.checkState(bool);
        paramInt3 = adjustByteCount(paramInt1, paramInt3);
        checkBounds(paramInt1, paramArrayOfByte.length, paramInt2, paramInt3);
        nativeCopyFromByteArray(this.mNativePtr + paramInt1, paramArrayOfByte, paramInt2, paramInt3);
        return paramInt3;
      }
    }
    finally
    {
      monitorexit;
    }
    throw paramArrayOfByte;
  }
}

/* Location:           C:\Users\c_jealom1\Documents\Scripts\Android\Fathom_com.brynk.fathom\Fathom_com.brynk.fathom-dex2jar.jar
 * Qualified Name:     com.facebook.imagepipeline.memory.NativeMemoryChunk
 * JD-Core Version:    0.6.0
 */
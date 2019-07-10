package com.facebook.imagepipeline.memory;

import com.facebook.common.internal.Preconditions;
import com.facebook.common.internal.VisibleForTesting;
import com.facebook.common.memory.PooledByteBuffer;
import com.facebook.common.memory.PooledByteBuffer.ClosedException;
import com.facebook.common.references.CloseableReference;
import javax.annotation.concurrent.GuardedBy;
import javax.annotation.concurrent.ThreadSafe;

@ThreadSafe
public class NativePooledByteBuffer
  implements PooledByteBuffer
{

  @VisibleForTesting
  @GuardedBy("this")
  CloseableReference<NativeMemoryChunk> mBufRef;
  private final int mSize;

  public NativePooledByteBuffer(CloseableReference<NativeMemoryChunk> paramCloseableReference, int paramInt)
  {
    Preconditions.checkNotNull(paramCloseableReference);
    if ((paramInt >= 0) && (paramInt <= ((NativeMemoryChunk)paramCloseableReference.get()).getSize()));
    for (boolean bool = true; ; bool = false)
    {
      Preconditions.checkArgument(bool);
      this.mBufRef = paramCloseableReference.clone();
      this.mSize = paramInt;
      return;
    }
  }

  public void close()
  {
    monitorenter;
    try
    {
      CloseableReference.closeSafely(this.mBufRef);
      this.mBufRef = null;
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

  void ensureValid()
  {
    monitorenter;
    try
    {
      if (isClosed())
        throw new PooledByteBuffer.ClosedException();
    }
    finally
    {
      monitorexit;
    }
    monitorexit;
  }

  public long getNativePtr()
  {
    monitorenter;
    try
    {
      ensureValid();
      long l = ((NativeMemoryChunk)this.mBufRef.get()).getNativePtr();
      monitorexit;
      return l;
    }
    finally
    {
      localObject = finally;
      monitorexit;
    }
    throw localObject;
  }

  public boolean isClosed()
  {
    monitorenter;
    try
    {
      boolean bool = CloseableReference.isValid(this.mBufRef);
      if (!bool)
      {
        bool = true;
        return bool;
      }
      bool = false;
    }
    finally
    {
      monitorexit;
    }
  }

  public byte read(int paramInt)
  {
    boolean bool2 = true;
    monitorenter;
    try
    {
      ensureValid();
      if (paramInt >= 0)
      {
        bool1 = true;
        Preconditions.checkArgument(bool1);
        if (paramInt >= this.mSize)
          break label58;
      }
      label58: for (boolean bool1 = bool2; ; bool1 = false)
      {
        Preconditions.checkArgument(bool1);
        int i = ((NativeMemoryChunk)this.mBufRef.get()).read(paramInt);
        return i;
        bool1 = false;
        break;
      }
    }
    finally
    {
      monitorexit;
    }
    throw localObject;
  }

  public void read(int paramInt1, byte[] paramArrayOfByte, int paramInt2, int paramInt3)
  {
    monitorenter;
    try
    {
      ensureValid();
      if (paramInt1 + paramInt3 <= this.mSize);
      for (boolean bool = true; ; bool = false)
      {
        Preconditions.checkArgument(bool);
        ((NativeMemoryChunk)this.mBufRef.get()).read(paramInt1, paramArrayOfByte, paramInt2, paramInt3);
        return;
      }
    }
    finally
    {
      monitorexit;
    }
    throw paramArrayOfByte;
  }

  public int size()
  {
    monitorenter;
    try
    {
      ensureValid();
      int i = this.mSize;
      monitorexit;
      return i;
    }
    finally
    {
      localObject = finally;
      monitorexit;
    }
    throw localObject;
  }
}

/* Location:           C:\Users\c_jealom1\Documents\Scripts\Android\Fathom_com.brynk.fathom\Fathom_com.brynk.fathom-dex2jar.jar
 * Qualified Name:     com.facebook.imagepipeline.memory.NativePooledByteBuffer
 * JD-Core Version:    0.6.0
 */
package com.facebook.imagepipeline.memory;

import com.facebook.common.internal.Preconditions;
import com.facebook.common.internal.VisibleForTesting;
import java.util.LinkedList;
import java.util.Queue;
import javax.annotation.Nullable;
import javax.annotation.concurrent.NotThreadSafe;

@VisibleForTesting
@NotThreadSafe
class Bucket<V>
{
  final Queue mFreeList;
  private int mInUseLength;
  public final int mItemSize;
  public final int mMaxLength;

  public Bucket(int paramInt1, int paramInt2, int paramInt3)
  {
    if (paramInt1 > 0)
    {
      bool1 = true;
      Preconditions.checkState(bool1);
      if (paramInt2 < 0)
        break label77;
      bool1 = true;
      label26: Preconditions.checkState(bool1);
      if (paramInt3 < 0)
        break label83;
    }
    label77: label83: for (boolean bool1 = bool2; ; bool1 = false)
    {
      Preconditions.checkState(bool1);
      this.mItemSize = paramInt1;
      this.mMaxLength = paramInt2;
      this.mFreeList = new LinkedList();
      this.mInUseLength = paramInt3;
      return;
      bool1 = false;
      break;
      bool1 = false;
      break label26;
    }
  }

  void addToFreeList(V paramV)
  {
    this.mFreeList.add(paramV);
  }

  public void decrementInUseCount()
  {
    if (this.mInUseLength > 0);
    for (boolean bool = true; ; bool = false)
    {
      Preconditions.checkState(bool);
      this.mInUseLength -= 1;
      return;
    }
  }

  @Nullable
  public V get()
  {
    Object localObject = pop();
    if (localObject != null)
      this.mInUseLength += 1;
    return localObject;
  }

  int getFreeListSize()
  {
    return this.mFreeList.size();
  }

  public int getInUseCount()
  {
    return this.mInUseLength;
  }

  public void incrementInUseCount()
  {
    this.mInUseLength += 1;
  }

  public boolean isMaxLengthExceeded()
  {
    return this.mInUseLength + getFreeListSize() > this.mMaxLength;
  }

  @Nullable
  public V pop()
  {
    return this.mFreeList.poll();
  }

  public void release(V paramV)
  {
    Preconditions.checkNotNull(paramV);
    if (this.mInUseLength > 0);
    for (boolean bool = true; ; bool = false)
    {
      Preconditions.checkState(bool);
      this.mInUseLength -= 1;
      addToFreeList(paramV);
      return;
    }
  }
}

/* Location:           C:\Users\c_jealom1\Documents\Scripts\Android\Fathom_com.brynk.fathom\Fathom_com.brynk.fathom-dex2jar.jar
 * Qualified Name:     com.facebook.imagepipeline.memory.Bucket
 * JD-Core Version:    0.6.0
 */
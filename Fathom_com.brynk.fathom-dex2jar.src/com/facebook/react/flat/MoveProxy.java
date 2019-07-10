package com.facebook.react.flat;

import com.facebook.infer.annotation.Assertions;
import com.facebook.react.bridge.ReadableArray;
import com.facebook.react.uimanager.ReactShadowNode;
import com.facebook.react.uimanager.ReactShadowNodeImpl;
import javax.annotation.Nullable;

final class MoveProxy
{
  private ReactShadowNode[] mChildren = new ReactShadowNodeImpl[4];
  private int[] mMapping = new int[8];

  @Nullable
  private ReadableArray mMoveTo;
  private int mSize;

  private static int k(int paramInt)
  {
    return paramInt * 2;
  }

  private int moveFromToIndex(int paramInt)
  {
    return this.mMapping[k(paramInt)];
  }

  private int moveFromToValue(int paramInt)
  {
    return this.mMapping[v(paramInt)];
  }

  private static int moveToToIndex(int paramInt)
  {
    return paramInt;
  }

  private int moveToToValue(int paramInt)
  {
    return ((ReadableArray)Assertions.assumeNotNull(this.mMoveTo)).getInt(paramInt);
  }

  private void setKeyValue(int paramInt1, int paramInt2, int paramInt3)
  {
    this.mMapping[k(paramInt1)] = paramInt2;
    this.mMapping[v(paramInt1)] = paramInt3;
  }

  private void setSize(int paramInt)
  {
    int i = paramInt;
    while (i < this.mSize)
    {
      this.mChildren[i] = null;
      i += 1;
    }
    this.mSize = paramInt;
  }

  private static int v(int paramInt)
  {
    return paramInt * 2 + 1;
  }

  public ReactShadowNode getChildMoveTo(int paramInt)
  {
    return this.mChildren[moveToToIndex(paramInt)];
  }

  public int getMoveFrom(int paramInt)
  {
    return moveFromToValue(paramInt);
  }

  public int getMoveTo(int paramInt)
  {
    return moveToToValue(paramInt);
  }

  public void setChildMoveFrom(int paramInt, ReactShadowNode paramReactShadowNode)
  {
    this.mChildren[moveFromToIndex(paramInt)] = paramReactShadowNode;
  }

  public void setup(ReadableArray paramReadableArray1, ReadableArray paramReadableArray2)
  {
    this.mMoveTo = paramReadableArray2;
    if (paramReadableArray1 == null)
    {
      setSize(0);
      return;
    }
    int k = paramReadableArray1.size();
    int i = k + k;
    if (this.mMapping.length < i)
    {
      this.mMapping = new int[i];
      this.mChildren = new FlatShadowNode[k];
    }
    setSize(k);
    setKeyValue(0, 0, paramReadableArray1.getInt(0));
    i = 1;
    label75: int m;
    int j;
    if (i < k)
    {
      m = paramReadableArray1.getInt(i);
      j = i - 1;
    }
    while (true)
    {
      if ((j < 0) || (moveFromToValue(j) < m))
      {
        setKeyValue(j + 1, i, m);
        i += 1;
        break label75;
        break;
      }
      setKeyValue(j + 1, moveFromToIndex(j), moveFromToValue(j));
      j -= 1;
    }
  }

  public int size()
  {
    return this.mSize;
  }
}

/* Location:           C:\Users\c_jealom1\Documents\Scripts\Android\Fathom_com.brynk.fathom\Fathom_com.brynk.fathom-dex2jar.jar
 * Qualified Name:     com.facebook.react.flat.MoveProxy
 * JD-Core Version:    0.6.0
 */
package android.support.v4.util;

import java.util.Map;

public class SimpleArrayMap<K, V>
{
  private static final int BASE_SIZE = 4;
  private static final int CACHE_SIZE = 10;
  private static final boolean DEBUG = false;
  private static final String TAG = "ArrayMap";
  static Object[] mBaseCache;
  static int mBaseCacheSize;
  static Object[] mTwiceBaseCache;
  static int mTwiceBaseCacheSize;
  Object[] mArray;
  int[] mHashes;
  int mSize;

  public SimpleArrayMap()
  {
    this.mHashes = ContainerHelpers.EMPTY_INTS;
    this.mArray = ContainerHelpers.EMPTY_OBJECTS;
    this.mSize = 0;
  }

  public SimpleArrayMap(int paramInt)
  {
    if (paramInt == 0)
    {
      this.mHashes = ContainerHelpers.EMPTY_INTS;
      this.mArray = ContainerHelpers.EMPTY_OBJECTS;
    }
    while (true)
    {
      this.mSize = 0;
      return;
      allocArrays(paramInt);
    }
  }

  public SimpleArrayMap(SimpleArrayMap paramSimpleArrayMap)
  {
    this();
    if (paramSimpleArrayMap != null)
      putAll(paramSimpleArrayMap);
  }

  private void allocArrays(int paramInt)
  {
    if (paramInt == 8)
      monitorenter;
    while (true)
    {
      try
      {
        if (mTwiceBaseCache == null)
          continue;
        Object[] arrayOfObject1 = mTwiceBaseCache;
        this.mArray = arrayOfObject1;
        mTwiceBaseCache = (Object[])(Object[])arrayOfObject1[0];
        this.mHashes = ((int[])(int[])arrayOfObject1[1]);
        arrayOfObject1[1] = null;
        arrayOfObject1[0] = null;
        mTwiceBaseCacheSize -= 1;
        return;
        monitorexit;
        this.mHashes = new int[paramInt];
        this.mArray = new Object[paramInt << 1];
        return;
      }
      finally
      {
        monitorexit;
      }
      if (paramInt != 4)
        continue;
      monitorenter;
      try
      {
        if (mBaseCache != null)
        {
          Object[] arrayOfObject2 = mBaseCache;
          this.mArray = arrayOfObject2;
          mBaseCache = (Object[])(Object[])arrayOfObject2[0];
          this.mHashes = ((int[])(int[])arrayOfObject2[1]);
          arrayOfObject2[1] = null;
          arrayOfObject2[0] = null;
          mBaseCacheSize -= 1;
          return;
        }
      }
      finally
      {
        monitorexit;
      }
      monitorexit;
    }
  }

  private static void freeArrays(int[] paramArrayOfInt, Object[] paramArrayOfObject, int paramInt)
  {
    if (paramArrayOfInt.length == 8)
    {
      monitorenter;
      try
      {
        if (mTwiceBaseCacheSize < 10)
        {
          paramArrayOfObject[0] = mTwiceBaseCache;
          paramArrayOfObject[1] = paramArrayOfInt;
          paramInt = (paramInt << 1) - 1;
          break label117;
          mTwiceBaseCache = paramArrayOfObject;
          mTwiceBaseCacheSize += 1;
        }
        return;
      }
      finally
      {
        monitorexit;
      }
    }
    else
    {
      if (paramArrayOfInt.length != 4)
        break label133;
      monitorenter;
    }
    while (true)
    {
      try
      {
        if (mBaseCacheSize >= 10)
          continue;
        paramArrayOfObject[0] = mBaseCache;
        paramArrayOfObject[1] = paramArrayOfInt;
        paramInt = (paramInt << 1) - 1;
        break label134;
        mBaseCache = paramArrayOfObject;
        mBaseCacheSize += 1;
        return;
      }
      finally
      {
        monitorexit;
      }
      label117: 
      while (paramInt >= 2)
      {
        paramArrayOfObject[paramInt] = null;
        paramInt -= 1;
      }
      break;
      label133: return;
      label134: 
      while (paramInt >= 2)
      {
        paramArrayOfObject[paramInt] = null;
        paramInt -= 1;
      }
    }
  }

  public void clear()
  {
    if (this.mSize != 0)
    {
      freeArrays(this.mHashes, this.mArray, this.mSize);
      this.mHashes = ContainerHelpers.EMPTY_INTS;
      this.mArray = ContainerHelpers.EMPTY_OBJECTS;
      this.mSize = 0;
    }
  }

  public boolean containsKey(Object paramObject)
  {
    return indexOfKey(paramObject) >= 0;
  }

  public boolean containsValue(Object paramObject)
  {
    return indexOfValue(paramObject) >= 0;
  }

  public void ensureCapacity(int paramInt)
  {
    if (this.mHashes.length < paramInt)
    {
      int[] arrayOfInt = this.mHashes;
      Object[] arrayOfObject = this.mArray;
      allocArrays(paramInt);
      if (this.mSize > 0)
      {
        System.arraycopy(arrayOfInt, 0, this.mHashes, 0, this.mSize);
        System.arraycopy(arrayOfObject, 0, this.mArray, 0, this.mSize << 1);
      }
      freeArrays(arrayOfInt, arrayOfObject, this.mSize);
    }
  }

  public boolean equals(Object paramObject)
  {
    if (this == paramObject);
    while (true)
    {
      return true;
      Object localObject1;
      Object localObject2;
      Object localObject3;
      boolean bool;
      if ((paramObject instanceof SimpleArrayMap))
      {
        paramObject = (SimpleArrayMap)paramObject;
        if (size() != paramObject.size())
          return false;
        i = 0;
        try
        {
          while (i < this.mSize)
          {
            localObject1 = keyAt(i);
            localObject2 = valueAt(i);
            localObject3 = paramObject.get(localObject1);
            if (localObject2 == null)
            {
              if (localObject3 != null)
                break label227;
              if (!paramObject.containsKey(localObject1))
                break label227;
            }
            else
            {
              bool = localObject2.equals(localObject3);
              if (!bool)
                return false;
            }
            i += 1;
          }
        }
        catch (java.lang.NullPointerException paramObject)
        {
          return false;
        }
        catch (java.lang.ClassCastException paramObject)
        {
          return false;
        }
      }
      if (!(paramObject instanceof Map))
        break;
      paramObject = (Map)paramObject;
      if (size() != paramObject.size())
        return false;
      int i = 0;
      try
      {
        while (i < this.mSize)
        {
          localObject1 = keyAt(i);
          localObject2 = valueAt(i);
          localObject3 = paramObject.get(localObject1);
          if (localObject2 == null)
          {
            if (localObject3 != null)
              break label229;
            if (!paramObject.containsKey(localObject1))
              break label229;
          }
          else
          {
            bool = localObject2.equals(localObject3);
            if (!bool)
              return false;
          }
          i += 1;
        }
      }
      catch (java.lang.NullPointerException paramObject)
      {
        return false;
      }
      catch (java.lang.ClassCastException paramObject)
      {
        return false;
      }
    }
    return false;
    label227: return false;
    label229: return false;
  }

  public V get(Object paramObject)
  {
    int i = indexOfKey(paramObject);
    if (i >= 0)
      return this.mArray[((i << 1) + 1)];
    return null;
  }

  public int hashCode()
  {
    int[] arrayOfInt = this.mHashes;
    Object[] arrayOfObject = this.mArray;
    int k = 0;
    int j = 0;
    int i = 1;
    int n = this.mSize;
    if (j < n)
    {
      Object localObject = arrayOfObject[i];
      int i1 = arrayOfInt[j];
      if (localObject == null);
      for (int m = 0; ; m = localObject.hashCode())
      {
        k += (m ^ i1);
        j += 1;
        i += 2;
        break;
      }
    }
    return k;
  }

  int indexOf(Object paramObject, int paramInt)
  {
    int k = this.mSize;
    if (k == 0)
      i = -1;
    int j;
    do
    {
      do
      {
        return i;
        j = ContainerHelpers.binarySearch(this.mHashes, k, paramInt);
        i = j;
      }
      while (j < 0);
      i = j;
    }
    while (paramObject.equals(this.mArray[(j << 1)]));
    int i = j + 1;
    while ((i < k) && (this.mHashes[i] == paramInt))
    {
      if (paramObject.equals(this.mArray[(i << 1)]))
        return i;
      i += 1;
    }
    j -= 1;
    while ((j >= 0) && (this.mHashes[j] == paramInt))
    {
      if (paramObject.equals(this.mArray[(j << 1)]))
        return j;
      j -= 1;
    }
    return i ^ 0xFFFFFFFF;
  }

  public int indexOfKey(Object paramObject)
  {
    if (paramObject == null)
      return indexOfNull();
    return indexOf(paramObject, paramObject.hashCode());
  }

  int indexOfNull()
  {
    int k = this.mSize;
    if (k == 0)
      i = -1;
    int j;
    do
    {
      do
      {
        return i;
        j = ContainerHelpers.binarySearch(this.mHashes, k, 0);
        i = j;
      }
      while (j < 0);
      i = j;
    }
    while (this.mArray[(j << 1)] == null);
    int i = j + 1;
    while ((i < k) && (this.mHashes[i] == 0))
    {
      if (this.mArray[(i << 1)] == null)
        return i;
      i += 1;
    }
    j -= 1;
    while ((j >= 0) && (this.mHashes[j] == 0))
    {
      if (this.mArray[(j << 1)] == null)
        return j;
      j -= 1;
    }
    return i ^ 0xFFFFFFFF;
  }

  int indexOfValue(Object paramObject)
  {
    int j = this.mSize * 2;
    Object[] arrayOfObject = this.mArray;
    if (paramObject == null)
    {
      i = 1;
      while (i < j)
      {
        if (arrayOfObject[i] == null)
          return i >> 1;
        i += 2;
      }
    }
    int i = 1;
    while (i < j)
    {
      if (paramObject.equals(arrayOfObject[i]))
        return i >> 1;
      i += 2;
    }
    return -1;
  }

  public boolean isEmpty()
  {
    return this.mSize <= 0;
  }

  public K keyAt(int paramInt)
  {
    return this.mArray[(paramInt << 1)];
  }

  public V put(K paramK, V paramV)
  {
    int k = 8;
    int j;
    if (paramK == null)
      j = 0;
    for (int i = indexOfNull(); i >= 0; i = indexOf(paramK, j))
    {
      i = (i << 1) + 1;
      paramK = this.mArray[i];
      this.mArray[i] = paramV;
      return paramK;
      j = paramK.hashCode();
    }
    int m = i ^ 0xFFFFFFFF;
    if (this.mSize >= this.mHashes.length)
    {
      if (this.mSize < 8)
        break label267;
      i = this.mSize + (this.mSize >> 1);
    }
    while (true)
    {
      int[] arrayOfInt = this.mHashes;
      Object[] arrayOfObject = this.mArray;
      allocArrays(i);
      if (this.mHashes.length > 0)
      {
        System.arraycopy(arrayOfInt, 0, this.mHashes, 0, arrayOfInt.length);
        System.arraycopy(arrayOfObject, 0, this.mArray, 0, arrayOfObject.length);
      }
      freeArrays(arrayOfInt, arrayOfObject, this.mSize);
      if (m < this.mSize)
      {
        System.arraycopy(this.mHashes, m, this.mHashes, m + 1, this.mSize - m);
        System.arraycopy(this.mArray, m << 1, this.mArray, m + 1 << 1, this.mSize - m << 1);
      }
      this.mHashes[m] = j;
      this.mArray[(m << 1)] = paramK;
      this.mArray[((m << 1) + 1)] = paramV;
      this.mSize += 1;
      return null;
      label267: i = k;
      if (this.mSize >= 4)
        continue;
      i = 4;
    }
  }

  public void putAll(SimpleArrayMap<? extends K, ? extends V> paramSimpleArrayMap)
  {
    int j = paramSimpleArrayMap.mSize;
    ensureCapacity(this.mSize + j);
    if (this.mSize == 0)
      if (j > 0)
      {
        System.arraycopy(paramSimpleArrayMap.mHashes, 0, this.mHashes, 0, j);
        System.arraycopy(paramSimpleArrayMap.mArray, 0, this.mArray, 0, j << 1);
        this.mSize = j;
      }
    while (true)
    {
      return;
      int i = 0;
      while (i < j)
      {
        put(paramSimpleArrayMap.keyAt(i), paramSimpleArrayMap.valueAt(i));
        i += 1;
      }
    }
  }

  public V remove(Object paramObject)
  {
    int i = indexOfKey(paramObject);
    if (i >= 0)
      return removeAt(i);
    return null;
  }

  public V removeAt(int paramInt)
  {
    int i = 8;
    Object localObject = this.mArray[((paramInt << 1) + 1)];
    if (this.mSize <= 1)
    {
      freeArrays(this.mHashes, this.mArray, this.mSize);
      this.mHashes = ContainerHelpers.EMPTY_INTS;
      this.mArray = ContainerHelpers.EMPTY_OBJECTS;
      this.mSize = 0;
    }
    while (true)
    {
      return localObject;
      if ((this.mHashes.length <= 8) || (this.mSize >= this.mHashes.length / 3))
        break;
      if (this.mSize > 8)
        i = this.mSize + (this.mSize >> 1);
      int[] arrayOfInt = this.mHashes;
      Object[] arrayOfObject = this.mArray;
      allocArrays(i);
      this.mSize -= 1;
      if (paramInt > 0)
      {
        System.arraycopy(arrayOfInt, 0, this.mHashes, 0, paramInt);
        System.arraycopy(arrayOfObject, 0, this.mArray, 0, paramInt << 1);
      }
      if (paramInt >= this.mSize)
        continue;
      System.arraycopy(arrayOfInt, paramInt + 1, this.mHashes, paramInt, this.mSize - paramInt);
      System.arraycopy(arrayOfObject, paramInt + 1 << 1, this.mArray, paramInt << 1, this.mSize - paramInt << 1);
      return localObject;
    }
    this.mSize -= 1;
    if (paramInt < this.mSize)
    {
      System.arraycopy(this.mHashes, paramInt + 1, this.mHashes, paramInt, this.mSize - paramInt);
      System.arraycopy(this.mArray, paramInt + 1 << 1, this.mArray, paramInt << 1, this.mSize - paramInt << 1);
    }
    this.mArray[(this.mSize << 1)] = null;
    this.mArray[((this.mSize << 1) + 1)] = null;
    return localObject;
  }

  public V setValueAt(int paramInt, V paramV)
  {
    paramInt = (paramInt << 1) + 1;
    Object localObject = this.mArray[paramInt];
    this.mArray[paramInt] = paramV;
    return localObject;
  }

  public int size()
  {
    return this.mSize;
  }

  public String toString()
  {
    if (isEmpty())
      return "{}";
    StringBuilder localStringBuilder = new StringBuilder(this.mSize * 28);
    localStringBuilder.append('{');
    int i = 0;
    if (i < this.mSize)
    {
      if (i > 0)
        localStringBuilder.append(", ");
      Object localObject = keyAt(i);
      if (localObject != this)
      {
        localStringBuilder.append(localObject);
        label70: localStringBuilder.append('=');
        localObject = valueAt(i);
        if (localObject == this)
          break label111;
        localStringBuilder.append(localObject);
      }
      while (true)
      {
        i += 1;
        break;
        localStringBuilder.append("(this Map)");
        break label70;
        label111: localStringBuilder.append("(this Map)");
      }
    }
    localStringBuilder.append('}');
    return localStringBuilder.toString();
  }

  public V valueAt(int paramInt)
  {
    return this.mArray[((paramInt << 1) + 1)];
  }
}

/* Location:           C:\Users\c_jealom1\Documents\Scripts\Android\Fathom_com.brynk.fathom\Fathom_com.brynk.fathom-dex2jar.jar
 * Qualified Name:     android.support.v4.util.SimpleArrayMap
 * JD-Core Version:    0.6.0
 */
package com.facebook.react.bridge;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class JavaOnlyMap
  implements ReadableMap, WritableMap
{
  private final Map mBackingMap;

  public JavaOnlyMap()
  {
    this.mBackingMap = new HashMap();
  }

  private JavaOnlyMap(Object[] paramArrayOfObject)
  {
    if (paramArrayOfObject.length % 2 != 0)
      throw new IllegalArgumentException("You must provide the same number of keys and values");
    this.mBackingMap = new HashMap();
    int i = 0;
    while (i < paramArrayOfObject.length)
    {
      this.mBackingMap.put(paramArrayOfObject[i], paramArrayOfObject[(i + 1)]);
      i += 2;
    }
  }

  public static JavaOnlyMap of(Object[] paramArrayOfObject)
  {
    return new JavaOnlyMap(paramArrayOfObject);
  }

  public boolean equals(Object paramObject)
  {
    if (this == paramObject);
    do
    {
      return true;
      if ((paramObject == null) || (getClass() != paramObject.getClass()))
        return false;
      paramObject = (JavaOnlyMap)paramObject;
      if (this.mBackingMap == null)
        break;
    }
    while (this.mBackingMap.equals(paramObject.mBackingMap));
    while (true)
    {
      return false;
      if (paramObject.mBackingMap == null)
        break;
    }
  }

  public JavaOnlyArray getArray(String paramString)
  {
    return (JavaOnlyArray)this.mBackingMap.get(paramString);
  }

  public boolean getBoolean(String paramString)
  {
    return ((Boolean)this.mBackingMap.get(paramString)).booleanValue();
  }

  public double getDouble(String paramString)
  {
    return ((Double)this.mBackingMap.get(paramString)).doubleValue();
  }

  public Dynamic getDynamic(String paramString)
  {
    return DynamicFromMap.create(this, paramString);
  }

  public int getInt(String paramString)
  {
    return ((Integer)this.mBackingMap.get(paramString)).intValue();
  }

  public JavaOnlyMap getMap(String paramString)
  {
    return (JavaOnlyMap)this.mBackingMap.get(paramString);
  }

  public String getString(String paramString)
  {
    return (String)this.mBackingMap.get(paramString);
  }

  public ReadableType getType(String paramString)
  {
    Object localObject = this.mBackingMap.get(paramString);
    if (localObject == null)
      return ReadableType.Null;
    if ((localObject instanceof Number))
      return ReadableType.Number;
    if ((localObject instanceof String))
      return ReadableType.String;
    if ((localObject instanceof Boolean))
      return ReadableType.Boolean;
    if ((localObject instanceof WritableMap))
      return ReadableType.Map;
    if ((localObject instanceof ReadableArray))
      return ReadableType.Array;
    if ((localObject instanceof Dynamic))
      return ((Dynamic)localObject).getType();
    throw new IllegalArgumentException("Invalid value " + localObject.toString() + " for key " + paramString + "contained in JavaOnlyMap");
  }

  public boolean hasKey(String paramString)
  {
    return this.mBackingMap.containsKey(paramString);
  }

  public int hashCode()
  {
    if (this.mBackingMap != null)
      return this.mBackingMap.hashCode();
    return 0;
  }

  public boolean isNull(String paramString)
  {
    return this.mBackingMap.get(paramString) == null;
  }

  public ReadableMapKeySetIterator keySetIterator()
  {
    return new ReadableMapKeySetIterator()
    {
      Iterator<String> mIterator = JavaOnlyMap.this.mBackingMap.keySet().iterator();

      public boolean hasNextKey()
      {
        return this.mIterator.hasNext();
      }

      public String nextKey()
      {
        return (String)this.mIterator.next();
      }
    };
  }

  public void merge(ReadableMap paramReadableMap)
  {
    this.mBackingMap.putAll(((JavaOnlyMap)paramReadableMap).mBackingMap);
  }

  public void putArray(String paramString, WritableArray paramWritableArray)
  {
    this.mBackingMap.put(paramString, paramWritableArray);
  }

  public void putBoolean(String paramString, boolean paramBoolean)
  {
    this.mBackingMap.put(paramString, Boolean.valueOf(paramBoolean));
  }

  public void putDouble(String paramString, double paramDouble)
  {
    this.mBackingMap.put(paramString, Double.valueOf(paramDouble));
  }

  public void putInt(String paramString, int paramInt)
  {
    this.mBackingMap.put(paramString, Integer.valueOf(paramInt));
  }

  public void putMap(String paramString, WritableMap paramWritableMap)
  {
    this.mBackingMap.put(paramString, paramWritableMap);
  }

  public void putNull(String paramString)
  {
    this.mBackingMap.put(paramString, null);
  }

  public void putString(String paramString1, String paramString2)
  {
    this.mBackingMap.put(paramString1, paramString2);
  }

  public HashMap<String, Object> toHashMap()
  {
    return new HashMap(this.mBackingMap);
  }

  public String toString()
  {
    return this.mBackingMap.toString();
  }
}

/* Location:           C:\Users\c_jealom1\Documents\Scripts\Android\Fathom_com.brynk.fathom\Fathom_com.brynk.fathom-dex2jar.jar
 * Qualified Name:     com.facebook.react.bridge.JavaOnlyMap
 * JD-Core Version:    0.6.0
 */
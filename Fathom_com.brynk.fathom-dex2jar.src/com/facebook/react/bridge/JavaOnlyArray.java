package com.facebook.react.bridge;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class JavaOnlyArray
  implements ReadableArray, WritableArray
{
  private final List mBackingList;

  public JavaOnlyArray()
  {
    this.mBackingList = new ArrayList();
  }

  private JavaOnlyArray(List paramList)
  {
    this.mBackingList = new ArrayList(paramList);
  }

  private JavaOnlyArray(Object[] paramArrayOfObject)
  {
    this.mBackingList = Arrays.asList(paramArrayOfObject);
  }

  public static JavaOnlyArray from(List paramList)
  {
    return new JavaOnlyArray(paramList);
  }

  public static JavaOnlyArray of(Object[] paramArrayOfObject)
  {
    return new JavaOnlyArray(paramArrayOfObject);
  }

  public boolean equals(Object paramObject)
  {
    if (this == paramObject);
    do
    {
      return true;
      if ((paramObject == null) || (getClass() != paramObject.getClass()))
        return false;
      paramObject = (JavaOnlyArray)paramObject;
      if (this.mBackingList == null)
        break;
    }
    while (this.mBackingList.equals(paramObject.mBackingList));
    while (true)
    {
      return false;
      if (paramObject.mBackingList == null)
        break;
    }
  }

  public JavaOnlyArray getArray(int paramInt)
  {
    return (JavaOnlyArray)this.mBackingList.get(paramInt);
  }

  public boolean getBoolean(int paramInt)
  {
    return ((Boolean)this.mBackingList.get(paramInt)).booleanValue();
  }

  public double getDouble(int paramInt)
  {
    return ((Double)this.mBackingList.get(paramInt)).doubleValue();
  }

  public Dynamic getDynamic(int paramInt)
  {
    return DynamicFromArray.create(this, paramInt);
  }

  public int getInt(int paramInt)
  {
    return ((Integer)this.mBackingList.get(paramInt)).intValue();
  }

  public JavaOnlyMap getMap(int paramInt)
  {
    return (JavaOnlyMap)this.mBackingList.get(paramInt);
  }

  public String getString(int paramInt)
  {
    return (String)this.mBackingList.get(paramInt);
  }

  public ReadableType getType(int paramInt)
  {
    Object localObject = this.mBackingList.get(paramInt);
    if (localObject == null)
      return ReadableType.Null;
    if ((localObject instanceof Boolean))
      return ReadableType.Boolean;
    if (((localObject instanceof Double)) || ((localObject instanceof Float)) || ((localObject instanceof Integer)))
      return ReadableType.Number;
    if ((localObject instanceof String))
      return ReadableType.String;
    if ((localObject instanceof WritableArray))
      return ReadableType.Array;
    if ((localObject instanceof ReadableMap))
      return ReadableType.Map;
    return null;
  }

  public int hashCode()
  {
    if (this.mBackingList != null)
      return this.mBackingList.hashCode();
    return 0;
  }

  public boolean isNull(int paramInt)
  {
    return this.mBackingList.get(paramInt) == null;
  }

  public void pushArray(WritableArray paramWritableArray)
  {
    this.mBackingList.add(paramWritableArray);
  }

  public void pushBoolean(boolean paramBoolean)
  {
    this.mBackingList.add(Boolean.valueOf(paramBoolean));
  }

  public void pushDouble(double paramDouble)
  {
    this.mBackingList.add(Double.valueOf(paramDouble));
  }

  public void pushInt(int paramInt)
  {
    this.mBackingList.add(Integer.valueOf(paramInt));
  }

  public void pushMap(WritableMap paramWritableMap)
  {
    this.mBackingList.add(paramWritableMap);
  }

  public void pushNull()
  {
    this.mBackingList.add(null);
  }

  public void pushString(String paramString)
  {
    this.mBackingList.add(paramString);
  }

  public int size()
  {
    return this.mBackingList.size();
  }

  public ArrayList<Object> toArrayList()
  {
    return new ArrayList(this.mBackingList);
  }

  public String toString()
  {
    return this.mBackingList.toString();
  }
}

/* Location:           C:\Users\c_jealom1\Documents\Scripts\Android\Fathom_com.brynk.fathom\Fathom_com.brynk.fathom-dex2jar.jar
 * Qualified Name:     com.facebook.react.bridge.JavaOnlyArray
 * JD-Core Version:    0.6.0
 */
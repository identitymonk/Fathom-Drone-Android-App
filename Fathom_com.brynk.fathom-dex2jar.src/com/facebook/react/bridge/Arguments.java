package com.facebook.react.bridge;

import android.os.Bundle;
import java.lang.reflect.Array;
import java.util.AbstractList;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import javax.annotation.Nullable;

public class Arguments
{
  private static void addEntry(WritableNativeMap paramWritableNativeMap, String paramString, Object paramObject)
  {
    paramObject = makeNativeObject(paramObject);
    if (paramObject == null)
    {
      paramWritableNativeMap.putNull(paramString);
      return;
    }
    if ((paramObject instanceof Boolean))
    {
      paramWritableNativeMap.putBoolean(paramString, ((Boolean)paramObject).booleanValue());
      return;
    }
    if ((paramObject instanceof Integer))
    {
      paramWritableNativeMap.putInt(paramString, ((Integer)paramObject).intValue());
      return;
    }
    if ((paramObject instanceof Number))
    {
      paramWritableNativeMap.putDouble(paramString, ((Number)paramObject).doubleValue());
      return;
    }
    if ((paramObject instanceof String))
    {
      paramWritableNativeMap.putString(paramString, (String)paramObject);
      return;
    }
    if ((paramObject instanceof WritableNativeArray))
    {
      paramWritableNativeMap.putArray(paramString, (WritableNativeArray)paramObject);
      return;
    }
    if ((paramObject instanceof WritableNativeMap))
    {
      paramWritableNativeMap.putMap(paramString, (WritableNativeMap)paramObject);
      return;
    }
    throw new IllegalArgumentException("Could not convert " + paramObject.getClass());
  }

  public static WritableArray createArray()
  {
    return new WritableNativeArray();
  }

  public static WritableMap createMap()
  {
    return new WritableNativeMap();
  }

  public static WritableArray fromArray(Object paramObject)
  {
    int j = 0;
    int k = 0;
    int m = 0;
    int n = 0;
    int i1 = 0;
    int i = 0;
    WritableArray localWritableArray = createArray();
    if ((paramObject instanceof String[]))
    {
      paramObject = (String[])(String[])paramObject;
      j = paramObject.length;
      while (i < j)
      {
        localWritableArray.pushString(paramObject[i]);
        i += 1;
      }
    }
    if ((paramObject instanceof Bundle[]))
    {
      paramObject = (Bundle[])(Bundle[])paramObject;
      k = paramObject.length;
      i = j;
      while (i < k)
      {
        localWritableArray.pushMap(fromBundle(paramObject[i]));
        i += 1;
      }
    }
    if ((paramObject instanceof int[]))
    {
      paramObject = (int[])(int[])paramObject;
      j = paramObject.length;
      i = k;
      while (i < j)
      {
        localWritableArray.pushInt(paramObject[i]);
        i += 1;
      }
    }
    if ((paramObject instanceof float[]))
    {
      paramObject = (float[])(float[])paramObject;
      j = paramObject.length;
      i = m;
      while (i < j)
      {
        localWritableArray.pushDouble(paramObject[i]);
        i += 1;
      }
    }
    if ((paramObject instanceof double[]))
    {
      paramObject = (double[])(double[])paramObject;
      j = paramObject.length;
      i = n;
      while (i < j)
      {
        localWritableArray.pushDouble(paramObject[i]);
        i += 1;
      }
    }
    if ((paramObject instanceof boolean[]))
    {
      paramObject = (boolean[])(boolean[])paramObject;
      j = paramObject.length;
      i = i1;
      while (i < j)
      {
        localWritableArray.pushBoolean(paramObject[i]);
        i += 1;
      }
    }
    throw new IllegalArgumentException("Unknown array type " + paramObject.getClass());
    return localWritableArray;
  }

  public static WritableMap fromBundle(Bundle paramBundle)
  {
    WritableMap localWritableMap = createMap();
    Iterator localIterator = paramBundle.keySet().iterator();
    while (localIterator.hasNext())
    {
      String str = (String)localIterator.next();
      Object localObject = paramBundle.get(str);
      if (localObject == null)
      {
        localWritableMap.putNull(str);
        continue;
      }
      if (localObject.getClass().isArray())
      {
        localWritableMap.putArray(str, fromArray(localObject));
        continue;
      }
      if ((localObject instanceof String))
      {
        localWritableMap.putString(str, (String)localObject);
        continue;
      }
      if ((localObject instanceof Number))
      {
        if ((localObject instanceof Integer))
        {
          localWritableMap.putInt(str, ((Integer)localObject).intValue());
          continue;
        }
        localWritableMap.putDouble(str, ((Number)localObject).doubleValue());
        continue;
      }
      if ((localObject instanceof Boolean))
      {
        localWritableMap.putBoolean(str, ((Boolean)localObject).booleanValue());
        continue;
      }
      if ((localObject instanceof Bundle))
      {
        localWritableMap.putMap(str, fromBundle((Bundle)localObject));
        continue;
      }
      if ((localObject instanceof List))
      {
        localWritableMap.putArray(str, fromList((List)localObject));
        continue;
      }
      throw new IllegalArgumentException("Could not convert " + localObject.getClass());
    }
    return localWritableMap;
  }

  public static WritableNativeArray fromJavaArgs(Object[] paramArrayOfObject)
  {
    WritableNativeArray localWritableNativeArray = new WritableNativeArray();
    int i = 0;
    if (i < paramArrayOfObject.length)
    {
      Object localObject = paramArrayOfObject[i];
      if (localObject == null)
        localWritableNativeArray.pushNull();
      Class localClass;
      while (true)
      {
        i += 1;
        break;
        localClass = localObject.getClass();
        if (localClass == Boolean.class)
        {
          localWritableNativeArray.pushBoolean(((Boolean)localObject).booleanValue());
          continue;
        }
        if (localClass == Integer.class)
        {
          localWritableNativeArray.pushDouble(((Integer)localObject).doubleValue());
          continue;
        }
        if (localClass == Double.class)
        {
          localWritableNativeArray.pushDouble(((Double)localObject).doubleValue());
          continue;
        }
        if (localClass == Float.class)
        {
          localWritableNativeArray.pushDouble(((Float)localObject).doubleValue());
          continue;
        }
        if (localClass == String.class)
        {
          localWritableNativeArray.pushString(localObject.toString());
          continue;
        }
        if (localClass == WritableNativeMap.class)
        {
          localWritableNativeArray.pushMap((WritableNativeMap)localObject);
          continue;
        }
        if (localClass != WritableNativeArray.class)
          break label179;
        localWritableNativeArray.pushArray((WritableNativeArray)localObject);
      }
      label179: throw new RuntimeException("Cannot convert argument of type " + localClass);
    }
    return localWritableNativeArray;
  }

  public static WritableArray fromList(List paramList)
  {
    WritableArray localWritableArray = createArray();
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      Object localObject = paramList.next();
      if (localObject == null)
      {
        localWritableArray.pushNull();
        continue;
      }
      if (localObject.getClass().isArray())
      {
        localWritableArray.pushArray(fromArray(localObject));
        continue;
      }
      if ((localObject instanceof Bundle))
      {
        localWritableArray.pushMap(fromBundle((Bundle)localObject));
        continue;
      }
      if ((localObject instanceof List))
      {
        localWritableArray.pushArray(fromList((List)localObject));
        continue;
      }
      if ((localObject instanceof String))
      {
        localWritableArray.pushString((String)localObject);
        continue;
      }
      if ((localObject instanceof Integer))
      {
        localWritableArray.pushInt(((Integer)localObject).intValue());
        continue;
      }
      if ((localObject instanceof Number))
      {
        localWritableArray.pushDouble(((Number)localObject).doubleValue());
        continue;
      }
      if ((localObject instanceof Boolean))
      {
        localWritableArray.pushBoolean(((Boolean)localObject).booleanValue());
        continue;
      }
      throw new IllegalArgumentException("Unknown value type " + localObject.getClass());
    }
    return localWritableArray;
  }

  public static <T> WritableNativeArray makeNativeArray(Object paramObject)
  {
    if (paramObject == null)
      return new WritableNativeArray();
    return makeNativeArray(new AbstractList(paramObject)
    {
      public Object get(int paramInt)
      {
        return Array.get(this.val$objects, paramInt);
      }

      public int size()
      {
        return Array.getLength(this.val$objects);
      }
    });
  }

  public static WritableNativeArray makeNativeArray(List paramList)
  {
    WritableNativeArray localWritableNativeArray = new WritableNativeArray();
    if (paramList == null);
    Object localObject;
    while (true)
    {
      return localWritableNativeArray;
      paramList = paramList.iterator();
      while (paramList.hasNext())
      {
        localObject = makeNativeObject(paramList.next());
        if (localObject == null)
        {
          localWritableNativeArray.pushNull();
          continue;
        }
        if ((localObject instanceof Boolean))
        {
          localWritableNativeArray.pushBoolean(((Boolean)localObject).booleanValue());
          continue;
        }
        if ((localObject instanceof Integer))
        {
          localWritableNativeArray.pushInt(((Integer)localObject).intValue());
          continue;
        }
        if ((localObject instanceof Double))
        {
          localWritableNativeArray.pushDouble(((Double)localObject).doubleValue());
          continue;
        }
        if ((localObject instanceof String))
        {
          localWritableNativeArray.pushString((String)localObject);
          continue;
        }
        if ((localObject instanceof WritableNativeArray))
        {
          localWritableNativeArray.pushArray((WritableNativeArray)localObject);
          continue;
        }
        if (!(localObject instanceof WritableNativeMap))
          break label168;
        localWritableNativeArray.pushMap((WritableNativeMap)localObject);
      }
    }
    label168: throw new IllegalArgumentException("Could not convert " + localObject.getClass());
  }

  public static WritableNativeMap makeNativeMap(Bundle paramBundle)
  {
    WritableNativeMap localWritableNativeMap = new WritableNativeMap();
    if (paramBundle == null);
    while (true)
    {
      return localWritableNativeMap;
      Iterator localIterator = paramBundle.keySet().iterator();
      while (localIterator.hasNext())
      {
        String str = (String)localIterator.next();
        addEntry(localWritableNativeMap, str, paramBundle.get(str));
      }
    }
  }

  public static WritableNativeMap makeNativeMap(Map<String, Object> paramMap)
  {
    WritableNativeMap localWritableNativeMap = new WritableNativeMap();
    if (paramMap == null);
    while (true)
    {
      return localWritableNativeMap;
      paramMap = paramMap.entrySet().iterator();
      while (paramMap.hasNext())
      {
        Map.Entry localEntry = (Map.Entry)paramMap.next();
        addEntry(localWritableNativeMap, (String)localEntry.getKey(), localEntry.getValue());
      }
    }
  }

  private static Object makeNativeObject(Object paramObject)
  {
    Object localObject;
    if (paramObject == null)
      localObject = null;
    do
    {
      return localObject;
      if (((paramObject instanceof Float)) || ((paramObject instanceof Long)) || ((paramObject instanceof Byte)) || ((paramObject instanceof Short)))
        return new Double(((Number)paramObject).doubleValue());
      if (paramObject.getClass().isArray())
        return makeNativeArray(paramObject);
      if ((paramObject instanceof List))
        return makeNativeArray((List)paramObject);
      if ((paramObject instanceof Map))
        return makeNativeMap((Map)paramObject);
      localObject = paramObject;
    }
    while (!(paramObject instanceof Bundle));
    return makeNativeMap((Bundle)paramObject);
  }

  @Nullable
  public static Bundle toBundle(@Nullable ReadableMap paramReadableMap)
  {
    Object localObject;
    if (paramReadableMap == null)
    {
      localObject = null;
      return localObject;
    }
    ReadableMapKeySetIterator localReadableMapKeySetIterator = paramReadableMap.keySetIterator();
    Bundle localBundle = new Bundle();
    while (true)
    {
      localObject = localBundle;
      if (!localReadableMapKeySetIterator.hasNextKey())
        break;
      localObject = localReadableMapKeySetIterator.nextKey();
      ReadableType localReadableType = paramReadableMap.getType((String)localObject);
      switch (2.$SwitchMap$com$facebook$react$bridge$ReadableType[localReadableType.ordinal()])
      {
      default:
        throw new IllegalArgumentException("Could not convert object with key: " + (String)localObject + ".");
      case 1:
        localBundle.putString((String)localObject, null);
        break;
      case 2:
        localBundle.putBoolean((String)localObject, paramReadableMap.getBoolean((String)localObject));
        break;
      case 3:
        localBundle.putDouble((String)localObject, paramReadableMap.getDouble((String)localObject));
        break;
      case 4:
        localBundle.putString((String)localObject, paramReadableMap.getString((String)localObject));
        break;
      case 5:
        localBundle.putBundle((String)localObject, toBundle(paramReadableMap.getMap((String)localObject)));
        break;
      case 6:
        localBundle.putSerializable((String)localObject, toList(paramReadableMap.getArray((String)localObject)));
      }
    }
  }

  @Nullable
  public static ArrayList toList(@Nullable ReadableArray paramReadableArray)
  {
    Object localObject;
    if (paramReadableArray == null)
      localObject = null;
    ArrayList localArrayList;
    int i;
    do
    {
      return localObject;
      localArrayList = new ArrayList();
      i = 0;
      localObject = localArrayList;
    }
    while (i >= paramReadableArray.size());
    switch (2.$SwitchMap$com$facebook$react$bridge$ReadableType[paramReadableArray.getType(i).ordinal()])
    {
    default:
      throw new IllegalArgumentException("Could not convert object in array.");
    case 1:
      localArrayList.add(null);
    case 2:
    case 3:
    case 4:
    case 5:
    case 6:
    }
    while (true)
    {
      i += 1;
      break;
      localArrayList.add(Boolean.valueOf(paramReadableArray.getBoolean(i)));
      continue;
      double d = paramReadableArray.getDouble(i);
      if (d == Math.rint(d))
      {
        localArrayList.add(Integer.valueOf((int)d));
        continue;
      }
      localArrayList.add(Double.valueOf(d));
      continue;
      localArrayList.add(paramReadableArray.getString(i));
      continue;
      localArrayList.add(toBundle(paramReadableArray.getMap(i)));
      continue;
      localArrayList.add(toList(paramReadableArray.getArray(i)));
    }
  }
}

/* Location:           C:\Users\c_jealom1\Documents\Scripts\Android\Fathom_com.brynk.fathom\Fathom_com.brynk.fathom-dex2jar.jar
 * Qualified Name:     com.facebook.react.bridge.Arguments
 * JD-Core Version:    0.6.0
 */
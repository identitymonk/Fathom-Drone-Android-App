package com.facebook.react.bridge;

import com.facebook.jni.HybridData;
import com.facebook.proguard.annotations.DoNotStrip;
import java.util.HashMap;

@DoNotStrip
public class ReadableNativeMap extends NativeMap
  implements ReadableMap
{
  static
  {
    ReactBridge.staticInit();
  }

  protected ReadableNativeMap(HybridData paramHybridData)
  {
    super(paramHybridData);
  }

  public native ReadableNativeArray getArray(String paramString);

  public native boolean getBoolean(String paramString);

  public native double getDouble(String paramString);

  public Dynamic getDynamic(String paramString)
  {
    return DynamicFromMap.create(this, paramString);
  }

  public native int getInt(String paramString);

  public native ReadableNativeMap getMap(String paramString);

  public native String getString(String paramString);

  public native ReadableType getType(String paramString);

  public native boolean hasKey(String paramString);

  public native boolean isNull(String paramString);

  public ReadableMapKeySetIterator keySetIterator()
  {
    return new ReadableNativeMapKeySetIterator(this);
  }

  public HashMap<String, Object> toHashMap()
  {
    ReadableMapKeySetIterator localReadableMapKeySetIterator = keySetIterator();
    HashMap localHashMap = new HashMap();
    while (localReadableMapKeySetIterator.hasNextKey())
    {
      String str = localReadableMapKeySetIterator.nextKey();
      switch (1.$SwitchMap$com$facebook$react$bridge$ReadableType[getType(str).ordinal()])
      {
      default:
        throw new IllegalArgumentException("Could not convert object with key: " + str + ".");
      case 1:
        localHashMap.put(str, null);
        break;
      case 2:
        localHashMap.put(str, Boolean.valueOf(getBoolean(str)));
        break;
      case 3:
        localHashMap.put(str, Double.valueOf(getDouble(str)));
        break;
      case 4:
        localHashMap.put(str, getString(str));
        break;
      case 5:
        localHashMap.put(str, getMap(str).toHashMap());
        break;
      case 6:
        localHashMap.put(str, getArray(str).toArrayList());
      }
    }
    return localHashMap;
  }

  @DoNotStrip
  private static class ReadableNativeMapKeySetIterator
    implements ReadableMapKeySetIterator
  {

    @DoNotStrip
    private final HybridData mHybridData;

    @DoNotStrip
    private final ReadableNativeMap mMap;

    public ReadableNativeMapKeySetIterator(ReadableNativeMap paramReadableNativeMap)
    {
      this.mMap = paramReadableNativeMap;
      this.mHybridData = initHybrid(paramReadableNativeMap);
    }

    private static native HybridData initHybrid(ReadableNativeMap paramReadableNativeMap);

    public native boolean hasNextKey();

    public native String nextKey();
  }
}

/* Location:           C:\Users\c_jealom1\Documents\Scripts\Android\Fathom_com.brynk.fathom\Fathom_com.brynk.fathom-dex2jar.jar
 * Qualified Name:     com.facebook.react.bridge.ReadableNativeMap
 * JD-Core Version:    0.6.0
 */
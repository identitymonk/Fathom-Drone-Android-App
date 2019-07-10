package com.facebook.react.bridge;

import com.facebook.jni.HybridData;
import com.facebook.proguard.annotations.DoNotStrip;
import java.util.ArrayList;

@DoNotStrip
public class ReadableNativeArray extends NativeArray
  implements ReadableArray
{
  static
  {
    ReactBridge.staticInit();
  }

  protected ReadableNativeArray(HybridData paramHybridData)
  {
    super(paramHybridData);
  }

  public native ReadableNativeArray getArray(int paramInt);

  public native boolean getBoolean(int paramInt);

  public native double getDouble(int paramInt);

  public Dynamic getDynamic(int paramInt)
  {
    return DynamicFromArray.create(this, paramInt);
  }

  public native int getInt(int paramInt);

  public native ReadableNativeMap getMap(int paramInt);

  public native String getString(int paramInt);

  public native ReadableType getType(int paramInt);

  public native boolean isNull(int paramInt);

  public native int size();

  public ArrayList<Object> toArrayList()
  {
    ArrayList localArrayList = new ArrayList();
    int i = 0;
    if (i < size())
    {
      switch (1.$SwitchMap$com$facebook$react$bridge$ReadableType[getType(i).ordinal()])
      {
      default:
        throw new IllegalArgumentException("Could not convert object at index: " + i + ".");
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
        localArrayList.add(Boolean.valueOf(getBoolean(i)));
        continue;
        localArrayList.add(Double.valueOf(getDouble(i)));
        continue;
        localArrayList.add(getString(i));
        continue;
        localArrayList.add(getMap(i).toHashMap());
        continue;
        localArrayList.add(getArray(i).toArrayList());
      }
    }
    return localArrayList;
  }
}

/* Location:           C:\Users\c_jealom1\Documents\Scripts\Android\Fathom_com.brynk.fathom\Fathom_com.brynk.fathom-dex2jar.jar
 * Qualified Name:     com.facebook.react.bridge.ReadableNativeArray
 * JD-Core Version:    0.6.0
 */
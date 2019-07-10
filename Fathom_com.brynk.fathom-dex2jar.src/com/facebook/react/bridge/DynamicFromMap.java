package com.facebook.react.bridge;

import android.support.v4.util.Pools.SimplePool;
import javax.annotation.Nullable;

public class DynamicFromMap
  implements Dynamic
{
  private static final Pools.SimplePool<DynamicFromMap> sPool = new Pools.SimplePool(10);

  @Nullable
  private ReadableMap mMap;

  @Nullable
  private String mName;

  public static DynamicFromMap create(ReadableMap paramReadableMap, String paramString)
  {
    DynamicFromMap localDynamicFromMap2 = (DynamicFromMap)sPool.acquire();
    DynamicFromMap localDynamicFromMap1 = localDynamicFromMap2;
    if (localDynamicFromMap2 == null)
      localDynamicFromMap1 = new DynamicFromMap();
    localDynamicFromMap1.mMap = paramReadableMap;
    localDynamicFromMap1.mName = paramString;
    return localDynamicFromMap1;
  }

  public ReadableArray asArray()
  {
    if ((this.mMap == null) || (this.mName == null))
      throw new IllegalStateException("This dynamic value has been recycled");
    return this.mMap.getArray(this.mName);
  }

  public boolean asBoolean()
  {
    if ((this.mMap == null) || (this.mName == null))
      throw new IllegalStateException("This dynamic value has been recycled");
    return this.mMap.getBoolean(this.mName);
  }

  public double asDouble()
  {
    if ((this.mMap == null) || (this.mName == null))
      throw new IllegalStateException("This dynamic value has been recycled");
    return this.mMap.getDouble(this.mName);
  }

  public int asInt()
  {
    if ((this.mMap == null) || (this.mName == null))
      throw new IllegalStateException("This dynamic value has been recycled");
    return this.mMap.getInt(this.mName);
  }

  public ReadableMap asMap()
  {
    if ((this.mMap == null) || (this.mName == null))
      throw new IllegalStateException("This dynamic value has been recycled");
    return this.mMap.getMap(this.mName);
  }

  public String asString()
  {
    if ((this.mMap == null) || (this.mName == null))
      throw new IllegalStateException("This dynamic value has been recycled");
    return this.mMap.getString(this.mName);
  }

  public ReadableType getType()
  {
    if ((this.mMap == null) || (this.mName == null))
      throw new IllegalStateException("This dynamic value has been recycled");
    return this.mMap.getType(this.mName);
  }

  public boolean isNull()
  {
    if ((this.mMap == null) || (this.mName == null))
      throw new IllegalStateException("This dynamic value has been recycled");
    return this.mMap.isNull(this.mName);
  }

  public void recycle()
  {
    this.mMap = null;
    this.mName = null;
    sPool.release(this);
  }
}

/* Location:           C:\Users\c_jealom1\Documents\Scripts\Android\Fathom_com.brynk.fathom\Fathom_com.brynk.fathom-dex2jar.jar
 * Qualified Name:     com.facebook.react.bridge.DynamicFromMap
 * JD-Core Version:    0.6.0
 */
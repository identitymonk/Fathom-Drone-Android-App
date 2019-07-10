package com.facebook.react.modules.location;

import com.facebook.react.bridge.Arguments;
import com.facebook.react.bridge.WritableMap;

public class PositionError
{
  public static int PERMISSION_DENIED = 1;
  public static int POSITION_UNAVAILABLE = 2;
  public static int TIMEOUT = 3;

  public static WritableMap buildError(int paramInt, String paramString)
  {
    WritableMap localWritableMap = Arguments.createMap();
    localWritableMap.putInt("code", paramInt);
    if (paramString != null)
      localWritableMap.putString("message", paramString);
    return localWritableMap;
  }
}

/* Location:           C:\Users\c_jealom1\Documents\Scripts\Android\Fathom_com.brynk.fathom\Fathom_com.brynk.fathom-dex2jar.jar
 * Qualified Name:     com.facebook.react.modules.location.PositionError
 * JD-Core Version:    0.6.0
 */
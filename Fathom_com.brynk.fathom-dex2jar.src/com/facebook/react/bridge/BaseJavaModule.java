package com.facebook.react.bridge;

import java.util.Map;
import javax.annotation.Nullable;

public abstract class BaseJavaModule
  implements NativeModule
{
  public static final String METHOD_TYPE_ASYNC = "async";
  public static final String METHOD_TYPE_PROMISE = "promise";
  public static final String METHOD_TYPE_SYNC = "sync";

  public boolean canOverrideExistingModule()
  {
    return false;
  }

  @Nullable
  public Map<String, Object> getConstants()
  {
    return null;
  }

  public boolean hasConstants()
  {
    return false;
  }

  public void initialize()
  {
  }

  public void onCatalystInstanceDestroy()
  {
  }
}

/* Location:           C:\Users\c_jealom1\Documents\Scripts\Android\Fathom_com.brynk.fathom\Fathom_com.brynk.fathom-dex2jar.jar
 * Qualified Name:     com.facebook.react.bridge.BaseJavaModule
 * JD-Core Version:    0.6.0
 */
package com.facebook.react.modules.systeminfo;

import android.os.Build.VERSION;
import com.facebook.react.bridge.BaseJavaModule;
import com.facebook.react.module.annotations.ReactModule;
import java.util.HashMap;
import java.util.Map;
import javax.annotation.Nullable;

@ReactModule(name="PlatformConstants")
public class AndroidInfoModule extends BaseJavaModule
{
  private static final String IS_TESTING = "IS_TESTING";

  @Nullable
  public Map<String, Object> getConstants()
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("Version", Integer.valueOf(Build.VERSION.SDK_INT));
    localHashMap.put("ServerHost", AndroidInfoHelpers.getServerHost());
    localHashMap.put("isTesting", Boolean.valueOf("true".equals(System.getProperty("IS_TESTING"))));
    localHashMap.put("reactNativeVersion", ReactNativeVersion.VERSION);
    return localHashMap;
  }

  public String getName()
  {
    return "PlatformConstants";
  }
}

/* Location:           C:\Users\c_jealom1\Documents\Scripts\Android\Fathom_com.brynk.fathom\Fathom_com.brynk.fathom-dex2jar.jar
 * Qualified Name:     com.facebook.react.modules.systeminfo.AndroidInfoModule
 * JD-Core Version:    0.6.0
 */
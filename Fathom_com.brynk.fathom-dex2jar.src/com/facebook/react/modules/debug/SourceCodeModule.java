package com.facebook.react.modules.debug;

import com.facebook.infer.annotation.Assertions;
import com.facebook.react.bridge.BaseJavaModule;
import com.facebook.react.bridge.CatalystInstance;
import com.facebook.react.bridge.ReactContext;
import com.facebook.react.module.annotations.ReactModule;
import java.util.HashMap;
import java.util.Map;
import javax.annotation.Nullable;

@ReactModule(name="SourceCode")
public class SourceCodeModule extends BaseJavaModule
{
  public static final String NAME = "SourceCode";
  private final ReactContext mReactContext;

  public SourceCodeModule(ReactContext paramReactContext)
  {
    this.mReactContext = paramReactContext;
  }

  @Nullable
  public Map<String, Object> getConstants()
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("scriptURL", (String)Assertions.assertNotNull(this.mReactContext.getCatalystInstance().getSourceURL(), "No source URL loaded, have you initialised the instance?"));
    return localHashMap;
  }

  public String getName()
  {
    return "SourceCode";
  }
}

/* Location:           C:\Users\c_jealom1\Documents\Scripts\Android\Fathom_com.brynk.fathom\Fathom_com.brynk.fathom-dex2jar.jar
 * Qualified Name:     com.facebook.react.modules.debug.SourceCodeModule
 * JD-Core Version:    0.6.0
 */
package com.facebook.react.bridge;

public class JSCJavaScriptExecutorFactory
  implements JavaScriptExecutorFactory
{
  private final String mAppName;
  private final String mDeviceName;

  public JSCJavaScriptExecutorFactory(String paramString1, String paramString2)
  {
    this.mAppName = paramString1;
    this.mDeviceName = paramString2;
  }

  public JavaScriptExecutor create()
    throws Exception
  {
    WritableNativeMap localWritableNativeMap = new WritableNativeMap();
    localWritableNativeMap.putString("OwnerIdentity", "ReactNative");
    localWritableNativeMap.putString("AppIdentity", this.mAppName);
    localWritableNativeMap.putString("DeviceIdentity", this.mDeviceName);
    return new JSCJavaScriptExecutor(localWritableNativeMap);
  }
}

/* Location:           C:\Users\c_jealom1\Documents\Scripts\Android\Fathom_com.brynk.fathom\Fathom_com.brynk.fathom-dex2jar.jar
 * Qualified Name:     com.facebook.react.bridge.JSCJavaScriptExecutorFactory
 * JD-Core Version:    0.6.0
 */
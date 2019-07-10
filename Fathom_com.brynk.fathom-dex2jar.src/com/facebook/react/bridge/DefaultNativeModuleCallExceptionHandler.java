package com.facebook.react.bridge;

public class DefaultNativeModuleCallExceptionHandler
  implements NativeModuleCallExceptionHandler
{
  public void handleException(Exception paramException)
  {
    if ((paramException instanceof RuntimeException))
      throw ((RuntimeException)paramException);
    throw new RuntimeException(paramException);
  }
}

/* Location:           C:\Users\c_jealom1\Documents\Scripts\Android\Fathom_com.brynk.fathom\Fathom_com.brynk.fathom-dex2jar.jar
 * Qualified Name:     com.facebook.react.bridge.DefaultNativeModuleCallExceptionHandler
 * JD-Core Version:    0.6.0
 */
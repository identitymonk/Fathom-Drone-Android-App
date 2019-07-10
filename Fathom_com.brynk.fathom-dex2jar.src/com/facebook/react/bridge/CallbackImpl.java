package com.facebook.react.bridge;

public final class CallbackImpl
  implements Callback
{
  private final int mCallbackId;
  private boolean mInvoked;
  private final JSInstance mJSInstance;

  public CallbackImpl(JSInstance paramJSInstance, int paramInt)
  {
    this.mJSInstance = paramJSInstance;
    this.mCallbackId = paramInt;
    this.mInvoked = false;
  }

  public void invoke(Object[] paramArrayOfObject)
  {
    if (this.mInvoked)
      throw new RuntimeException("Illegal callback invocation from native module. This callback type only permits a single invocation from native code.");
    this.mJSInstance.invokeCallback(this.mCallbackId, Arguments.fromJavaArgs(paramArrayOfObject));
    this.mInvoked = true;
  }
}

/* Location:           C:\Users\c_jealom1\Documents\Scripts\Android\Fathom_com.brynk.fathom\Fathom_com.brynk.fathom-dex2jar.jar
 * Qualified Name:     com.facebook.react.bridge.CallbackImpl
 * JD-Core Version:    0.6.0
 */
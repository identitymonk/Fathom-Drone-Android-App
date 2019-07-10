package com.facebook.react.bridge;

import com.facebook.jni.HybridData;
import com.facebook.proguard.annotations.DoNotStrip;
import javax.annotation.Nullable;

@DoNotStrip
public class ProxyJavaScriptExecutor extends JavaScriptExecutor
{

  @Nullable
  private JavaJSExecutor mJavaJSExecutor;

  static
  {
    ReactBridge.staticInit();
  }

  public ProxyJavaScriptExecutor(JavaJSExecutor paramJavaJSExecutor)
  {
    super(initHybrid(paramJavaJSExecutor));
    this.mJavaJSExecutor = paramJavaJSExecutor;
  }

  private static native HybridData initHybrid(JavaJSExecutor paramJavaJSExecutor);

  public void close()
  {
    if (this.mJavaJSExecutor != null)
    {
      this.mJavaJSExecutor.close();
      this.mJavaJSExecutor = null;
    }
  }

  public static class Factory
    implements JavaScriptExecutorFactory
  {
    private final JavaJSExecutor.Factory mJavaJSExecutorFactory;

    public Factory(JavaJSExecutor.Factory paramFactory)
    {
      this.mJavaJSExecutorFactory = paramFactory;
    }

    public JavaScriptExecutor create()
      throws Exception
    {
      return new ProxyJavaScriptExecutor(this.mJavaJSExecutorFactory.create());
    }
  }
}

/* Location:           C:\Users\c_jealom1\Documents\Scripts\Android\Fathom_com.brynk.fathom\Fathom_com.brynk.fathom-dex2jar.jar
 * Qualified Name:     com.facebook.react.bridge.ProxyJavaScriptExecutor
 * JD-Core Version:    0.6.0
 */
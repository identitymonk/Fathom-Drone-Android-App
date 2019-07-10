package com.facebook.react.bridge;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.HashMap;
import javax.annotation.Nullable;

public final class JavaScriptModuleRegistry
{
  private final HashMap<Class<? extends JavaScriptModule>, JavaScriptModule> mModuleInstances = new HashMap();

  public <T extends JavaScriptModule> T getJavaScriptModule(CatalystInstance paramCatalystInstance, Class<T> paramClass)
  {
    monitorenter;
    try
    {
      Object localObject = (JavaScriptModule)this.mModuleInstances.get(paramClass);
      if (localObject != null)
        paramCatalystInstance = (CatalystInstance)localObject;
      while (true)
      {
        return paramCatalystInstance;
        localObject = paramClass.getClassLoader();
        paramCatalystInstance = new JavaScriptModuleInvocationHandler(paramCatalystInstance, paramClass);
        paramCatalystInstance = (JavaScriptModule)Proxy.newProxyInstance((ClassLoader)localObject, new Class[] { paramClass }, paramCatalystInstance);
        this.mModuleInstances.put(paramClass, paramCatalystInstance);
      }
    }
    finally
    {
      monitorexit;
    }
    throw paramCatalystInstance;
  }

  private static class JavaScriptModuleInvocationHandler
    implements InvocationHandler
  {
    private final CatalystInstance mCatalystInstance;
    private final Class<? extends JavaScriptModule> mModuleInterface;

    @Nullable
    private String mName;

    public JavaScriptModuleInvocationHandler(CatalystInstance paramCatalystInstance, Class<? extends JavaScriptModule> paramClass)
    {
      this.mCatalystInstance = paramCatalystInstance;
      this.mModuleInterface = paramClass;
    }

    private String getJSModuleName()
    {
      if (this.mName == null)
      {
        String str2 = this.mModuleInterface.getSimpleName();
        int i = str2.lastIndexOf('$');
        String str1 = str2;
        if (i != -1)
          str1 = str2.substring(i + 1);
        this.mName = str1;
      }
      return this.mName;
    }

    @Nullable
    public Object invoke(Object paramObject, Method paramMethod, @Nullable Object[] paramArrayOfObject)
      throws Throwable
    {
      if (paramArrayOfObject != null);
      for (paramObject = Arguments.fromJavaArgs(paramArrayOfObject); ; paramObject = new WritableNativeArray())
      {
        this.mCatalystInstance.callFunction(getJSModuleName(), paramMethod.getName(), paramObject);
        return null;
      }
    }
  }
}

/* Location:           C:\Users\c_jealom1\Documents\Scripts\Android\Fathom_com.brynk.fathom\Fathom_com.brynk.fathom-dex2jar.jar
 * Qualified Name:     com.facebook.react.bridge.JavaScriptModuleRegistry
 * JD-Core Version:    0.6.0
 */
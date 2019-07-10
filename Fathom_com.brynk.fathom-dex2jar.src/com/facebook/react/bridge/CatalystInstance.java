package com.facebook.react.bridge;

import com.facebook.proguard.annotations.DoNotStrip;
import com.facebook.react.bridge.queue.ReactQueueConfiguration;
import com.facebook.react.common.annotations.VisibleForTesting;
import java.util.Collection;
import javax.annotation.Nullable;

@DoNotStrip
public abstract interface CatalystInstance extends MemoryPressureListener, JSInstance
{
  public abstract void addBridgeIdleDebugListener(NotThreadSafeBridgeIdleDebugListener paramNotThreadSafeBridgeIdleDebugListener);

  @DoNotStrip
  public abstract void callFunction(String paramString1, String paramString2, NativeArray paramNativeArray);

  public abstract void destroy();

  public abstract void extendNativeModules(NativeModuleRegistry paramNativeModuleRegistry);

  public abstract <T extends JavaScriptModule> T getJSModule(Class<T> paramClass);

  public abstract JavaScriptContextHolder getJavaScriptContextHolder();

  public abstract <T extends NativeModule> T getNativeModule(Class<T> paramClass);

  public abstract Collection<NativeModule> getNativeModules();

  public abstract ReactQueueConfiguration getReactQueueConfiguration();

  @Nullable
  public abstract String getSourceURL();

  public abstract <T extends NativeModule> boolean hasNativeModule(Class<T> paramClass);

  public abstract boolean hasRunJSBundle();

  @VisibleForTesting
  public abstract void initialize();

  @DoNotStrip
  public abstract void invokeCallback(int paramInt, NativeArray paramNativeArray);

  public abstract boolean isDestroyed();

  public abstract void removeBridgeIdleDebugListener(NotThreadSafeBridgeIdleDebugListener paramNotThreadSafeBridgeIdleDebugListener);

  public abstract void runJSBundle();

  @VisibleForTesting
  public abstract void setGlobalVariable(String paramString1, String paramString2);
}

/* Location:           C:\Users\c_jealom1\Documents\Scripts\Android\Fathom_com.brynk.fathom\Fathom_com.brynk.fathom-dex2jar.jar
 * Qualified Name:     com.facebook.react.bridge.CatalystInstance
 * JD-Core Version:    0.6.0
 */
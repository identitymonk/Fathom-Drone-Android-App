package com.facebook.react.devsupport.interfaces;

import com.facebook.react.bridge.NativeModuleCallExceptionHandler;
import com.facebook.react.bridge.ReactContext;
import com.facebook.react.bridge.ReadableArray;
import com.facebook.react.modules.debug.interfaces.DeveloperSettings;
import java.io.File;
import javax.annotation.Nullable;

public abstract interface DevSupportManager extends NativeModuleCallExceptionHandler
{
  public abstract void addCustomDevOption(String paramString, DevOptionHandler paramDevOptionHandler);

  @Nullable
  public abstract File downloadBundleResourceFromUrlSync(String paramString, File paramFile);

  public abstract DeveloperSettings getDevSettings();

  public abstract boolean getDevSupportEnabled();

  public abstract String getDownloadedJSBundleFile();

  public abstract String getJSBundleURLForRemoteDebugging();

  @Nullable
  public abstract StackFrame[] getLastErrorStack();

  @Nullable
  public abstract String getLastErrorTitle();

  public abstract String getSourceMapUrl();

  public abstract String getSourceUrl();

  public abstract void handleReloadJS();

  public abstract boolean hasUpToDateJSBundleInCache();

  public abstract void hideRedboxDialog();

  public abstract void isPackagerRunning(PackagerStatusCallback paramPackagerStatusCallback);

  public abstract void onNewReactContextCreated(ReactContext paramReactContext);

  public abstract void onReactInstanceDestroyed(ReactContext paramReactContext);

  public abstract void registerErrorCustomizer(ErrorCustomizer paramErrorCustomizer);

  public abstract void reloadJSFromServer(String paramString);

  public abstract void reloadSettings();

  public abstract void setDevSupportEnabled(boolean paramBoolean);

  public abstract void showDevOptionsDialog();

  public abstract void showNewJSError(String paramString, ReadableArray paramReadableArray, int paramInt);

  public abstract void showNewJavaError(String paramString, Throwable paramThrowable);

  public abstract void startInspector();

  public abstract void stopInspector();

  public abstract void updateJSError(String paramString, ReadableArray paramReadableArray, int paramInt);
}

/* Location:           C:\Users\c_jealom1\Documents\Scripts\Android\Fathom_com.brynk.fathom\Fathom_com.brynk.fathom-dex2jar.jar
 * Qualified Name:     com.facebook.react.devsupport.interfaces.DevSupportManager
 * JD-Core Version:    0.6.0
 */
package com.facebook.react.devsupport;

import com.facebook.react.bridge.DefaultNativeModuleCallExceptionHandler;
import com.facebook.react.bridge.ReactContext;
import com.facebook.react.bridge.ReadableArray;
import com.facebook.react.devsupport.interfaces.DevOptionHandler;
import com.facebook.react.devsupport.interfaces.DevSupportManager;
import com.facebook.react.devsupport.interfaces.ErrorCustomizer;
import com.facebook.react.devsupport.interfaces.PackagerStatusCallback;
import com.facebook.react.devsupport.interfaces.StackFrame;
import com.facebook.react.modules.debug.interfaces.DeveloperSettings;
import java.io.File;
import javax.annotation.Nullable;

public class DisabledDevSupportManager
  implements DevSupportManager
{
  private final DefaultNativeModuleCallExceptionHandler mDefaultNativeModuleCallExceptionHandler = new DefaultNativeModuleCallExceptionHandler();

  public void addCustomDevOption(String paramString, DevOptionHandler paramDevOptionHandler)
  {
  }

  @Nullable
  public File downloadBundleResourceFromUrlSync(String paramString, File paramFile)
  {
    return null;
  }

  public DeveloperSettings getDevSettings()
  {
    return null;
  }

  public boolean getDevSupportEnabled()
  {
    return false;
  }

  public String getDownloadedJSBundleFile()
  {
    return null;
  }

  public String getJSBundleURLForRemoteDebugging()
  {
    return null;
  }

  @Nullable
  public StackFrame[] getLastErrorStack()
  {
    return null;
  }

  @Nullable
  public String getLastErrorTitle()
  {
    return null;
  }

  public String getSourceMapUrl()
  {
    return null;
  }

  public String getSourceUrl()
  {
    return null;
  }

  public void handleException(Exception paramException)
  {
    this.mDefaultNativeModuleCallExceptionHandler.handleException(paramException);
  }

  public void handleReloadJS()
  {
  }

  public boolean hasUpToDateJSBundleInCache()
  {
    return false;
  }

  public void hideRedboxDialog()
  {
  }

  public void isPackagerRunning(PackagerStatusCallback paramPackagerStatusCallback)
  {
  }

  public void onNewReactContextCreated(ReactContext paramReactContext)
  {
  }

  public void onReactInstanceDestroyed(ReactContext paramReactContext)
  {
  }

  public void registerErrorCustomizer(ErrorCustomizer paramErrorCustomizer)
  {
  }

  public void reloadJSFromServer(String paramString)
  {
  }

  public void reloadSettings()
  {
  }

  public void setDevSupportEnabled(boolean paramBoolean)
  {
  }

  public void showDevOptionsDialog()
  {
  }

  public void showNewJSError(String paramString, ReadableArray paramReadableArray, int paramInt)
  {
  }

  public void showNewJavaError(String paramString, Throwable paramThrowable)
  {
  }

  public void startInspector()
  {
  }

  public void stopInspector()
  {
  }

  public void updateJSError(String paramString, ReadableArray paramReadableArray, int paramInt)
  {
  }
}

/* Location:           C:\Users\c_jealom1\Documents\Scripts\Android\Fathom_com.brynk.fathom\Fathom_com.brynk.fathom-dex2jar.jar
 * Qualified Name:     com.facebook.react.devsupport.DisabledDevSupportManager
 * JD-Core Version:    0.6.0
 */
package com.facebook.react;

import android.app.Application;
import com.facebook.infer.annotation.Assertions;
import com.facebook.react.bridge.JavaScriptExecutorFactory;
import com.facebook.react.common.LifecycleState;
import com.facebook.react.devsupport.RedBoxHandler;
import com.facebook.react.uimanager.UIImplementationProvider;
import java.util.Iterator;
import java.util.List;
import javax.annotation.Nullable;

public abstract class ReactNativeHost
{
  private final Application mApplication;

  @Nullable
  private ReactInstanceManager mReactInstanceManager;

  protected ReactNativeHost(Application paramApplication)
  {
    this.mApplication = paramApplication;
  }

  public void clear()
  {
    if (this.mReactInstanceManager != null)
    {
      this.mReactInstanceManager.destroy();
      this.mReactInstanceManager = null;
    }
  }

  protected ReactInstanceManager createReactInstanceManager()
  {
    ReactInstanceManagerBuilder localReactInstanceManagerBuilder = ReactInstanceManager.builder().setApplication(this.mApplication).setJSMainModulePath(getJSMainModuleName()).setUseDeveloperSupport(getUseDeveloperSupport()).setRedBoxHandler(getRedBoxHandler()).setJavaScriptExecutorFactory(getJavaScriptExecutorFactory()).setUIImplementationProvider(getUIImplementationProvider()).setInitialLifecycleState(LifecycleState.BEFORE_CREATE);
    Object localObject = getPackages().iterator();
    while (((Iterator)localObject).hasNext())
      localReactInstanceManagerBuilder.addPackage((ReactPackage)((Iterator)localObject).next());
    localObject = getJSBundleFile();
    if (localObject != null)
      localReactInstanceManagerBuilder.setJSBundleFile((String)localObject);
    while (true)
    {
      return localReactInstanceManagerBuilder.build();
      localReactInstanceManagerBuilder.setBundleAssetName((String)Assertions.assertNotNull(getBundleAssetName()));
    }
  }

  protected final Application getApplication()
  {
    return this.mApplication;
  }

  @Nullable
  protected String getBundleAssetName()
  {
    return "index.android.bundle";
  }

  @Nullable
  protected String getJSBundleFile()
  {
    return null;
  }

  protected String getJSMainModuleName()
  {
    return "index.android";
  }

  @Nullable
  protected JavaScriptExecutorFactory getJavaScriptExecutorFactory()
  {
    return null;
  }

  protected abstract List<ReactPackage> getPackages();

  public ReactInstanceManager getReactInstanceManager()
  {
    if (this.mReactInstanceManager == null)
      this.mReactInstanceManager = createReactInstanceManager();
    return this.mReactInstanceManager;
  }

  @Nullable
  protected RedBoxHandler getRedBoxHandler()
  {
    return null;
  }

  protected UIImplementationProvider getUIImplementationProvider()
  {
    return new UIImplementationProvider();
  }

  public abstract boolean getUseDeveloperSupport();

  public boolean hasInstance()
  {
    return this.mReactInstanceManager != null;
  }
}

/* Location:           C:\Users\c_jealom1\Documents\Scripts\Android\Fathom_com.brynk.fathom\Fathom_com.brynk.fathom-dex2jar.jar
 * Qualified Name:     com.facebook.react.ReactNativeHost
 * JD-Core Version:    0.6.0
 */
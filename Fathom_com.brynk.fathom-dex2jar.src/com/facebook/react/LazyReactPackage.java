package com.facebook.react;

import com.facebook.react.bridge.ModuleSpec;
import com.facebook.react.bridge.NativeModule;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactMarker;
import com.facebook.react.bridge.ReactMarkerConstants;
import com.facebook.react.module.model.ReactModuleInfoProvider;
import com.facebook.react.uimanager.ViewManager;
import com.facebook.systrace.SystraceMessage;
import com.facebook.systrace.SystraceMessage.Builder;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.List<Lcom.facebook.react.bridge.NativeModule;>;
import javax.inject.Provider;

public abstract class LazyReactPackage
  implements ReactPackage
{
  public static ReactModuleInfoProvider getReactModuleInfoProviderViaReflection(LazyReactPackage paramLazyReactPackage)
  {
    Object localObject;
    try
    {
      localObject = Class.forName(paramLazyReactPackage.getClass().getCanonicalName() + "$$ReactModuleInfoProvider");
      if (localObject == null)
        throw new RuntimeException("ReactModuleInfoProvider class for " + paramLazyReactPackage.getClass().getCanonicalName() + " not found.");
    }
    catch (java.lang.ClassNotFoundException paramLazyReactPackage)
    {
      throw new RuntimeException(paramLazyReactPackage);
    }
    try
    {
      localObject = (ReactModuleInfoProvider)((Class)localObject).newInstance();
      return localObject;
    }
    catch (InstantiationException localInstantiationException)
    {
      throw new RuntimeException("Unable to instantiate ReactModuleInfoProvider for " + paramLazyReactPackage.getClass(), localInstantiationException);
    }
    catch (IllegalAccessException localIllegalAccessException)
    {
    }
    throw new RuntimeException("Unable to instantiate ReactModuleInfoProvider for " + paramLazyReactPackage.getClass(), localIllegalAccessException);
  }

  public final List<NativeModule> createNativeModules(ReactApplicationContext paramReactApplicationContext)
  {
    ArrayList localArrayList = new ArrayList();
    paramReactApplicationContext = getNativeModules(paramReactApplicationContext).iterator();
    while (paramReactApplicationContext.hasNext())
    {
      Object localObject = (ModuleSpec)paramReactApplicationContext.next();
      SystraceMessage.beginSection(0L, "createNativeModule").arg("module", ((ModuleSpec)localObject).getType()).flush();
      ReactMarker.logMarker(ReactMarkerConstants.CREATE_MODULE_START, ((ModuleSpec)localObject).getType().getSimpleName());
      try
      {
        localObject = (NativeModule)((ModuleSpec)localObject).getProvider().get();
        ReactMarker.logMarker(ReactMarkerConstants.CREATE_MODULE_END);
        SystraceMessage.endSection(0L).flush();
        localArrayList.add(localObject);
      }
      finally
      {
        ReactMarker.logMarker(ReactMarkerConstants.CREATE_MODULE_END);
        SystraceMessage.endSection(0L).flush();
      }
    }
    return (List<NativeModule>)localArrayList;
  }

  public List<ViewManager> createViewManagers(ReactApplicationContext paramReactApplicationContext)
  {
    paramReactApplicationContext = getViewManagers(paramReactApplicationContext);
    if ((paramReactApplicationContext == null) || (paramReactApplicationContext.isEmpty()))
    {
      paramReactApplicationContext = Collections.emptyList();
      return paramReactApplicationContext;
    }
    ArrayList localArrayList = new ArrayList();
    Iterator localIterator = paramReactApplicationContext.iterator();
    while (true)
    {
      paramReactApplicationContext = localArrayList;
      if (!localIterator.hasNext())
        break;
      localArrayList.add((ViewManager)((ModuleSpec)localIterator.next()).getProvider().get());
    }
  }

  public abstract List<ModuleSpec> getNativeModules(ReactApplicationContext paramReactApplicationContext);

  public abstract ReactModuleInfoProvider getReactModuleInfoProvider();

  public List<ModuleSpec> getViewManagers(ReactApplicationContext paramReactApplicationContext)
  {
    return Collections.emptyList();
  }
}

/* Location:           C:\Users\c_jealom1\Documents\Scripts\Android\Fathom_com.brynk.fathom\Fathom_com.brynk.fathom-dex2jar.jar
 * Qualified Name:     com.facebook.react.LazyReactPackage
 * JD-Core Version:    0.6.0
 */
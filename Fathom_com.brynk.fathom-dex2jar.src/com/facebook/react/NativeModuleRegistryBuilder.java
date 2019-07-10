package com.facebook.react;

import com.facebook.common.logging.FLog;
import com.facebook.react.bridge.BaseJavaModule;
import com.facebook.react.bridge.ModuleHolder;
import com.facebook.react.bridge.ModuleSpec;
import com.facebook.react.bridge.NativeModule;
import com.facebook.react.bridge.NativeModuleRegistry;
import com.facebook.react.bridge.OnBatchCompleteListener;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactMarker;
import com.facebook.react.bridge.ReactMarkerConstants;
import com.facebook.react.module.model.ReactModuleInfo;
import com.facebook.react.module.model.ReactModuleInfoProvider;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import javax.inject.Provider;

public class NativeModuleRegistryBuilder
{
  private final boolean mLazyNativeModulesEnabled;
  private final Map<Class<? extends NativeModule>, ModuleHolder> mModules = new HashMap();
  private final ReactApplicationContext mReactApplicationContext;
  private final ReactInstanceManager mReactInstanceManager;
  private final Map<String, Class<? extends NativeModule>> namesToType = new HashMap();

  public NativeModuleRegistryBuilder(ReactApplicationContext paramReactApplicationContext, ReactInstanceManager paramReactInstanceManager, boolean paramBoolean)
  {
    this.mReactApplicationContext = paramReactApplicationContext;
    this.mReactInstanceManager = paramReactInstanceManager;
    this.mLazyNativeModulesEnabled = paramBoolean;
  }

  public void addNativeModule(NativeModule paramNativeModule)
  {
    String str = paramNativeModule.getName();
    Class localClass1 = paramNativeModule.getClass();
    if (this.namesToType.containsKey(str))
    {
      Class localClass2 = (Class)this.namesToType.get(str);
      if (!paramNativeModule.canOverrideExistingModule())
        throw new IllegalStateException("Native module " + localClass1.getSimpleName() + " tried to override " + localClass2.getSimpleName() + " for module name " + str + ". If this was your intention, set canOverrideExistingModule=true");
      this.mModules.remove(localClass2);
    }
    this.namesToType.put(str, localClass1);
    paramNativeModule = new ModuleHolder(paramNativeModule);
    this.mModules.put(localClass1, paramNativeModule);
  }

  public NativeModuleRegistry build()
  {
    ArrayList localArrayList = new ArrayList();
    Iterator localIterator = this.mModules.entrySet().iterator();
    while (localIterator.hasNext())
    {
      Map.Entry localEntry = (Map.Entry)localIterator.next();
      if (!OnBatchCompleteListener.class.isAssignableFrom((Class)localEntry.getKey()))
        continue;
      localArrayList.add(localEntry.getValue());
    }
    return new NativeModuleRegistry(this.mReactApplicationContext, this.mModules, localArrayList);
  }

  public void processPackage(ReactPackage paramReactPackage)
  {
    if (this.mLazyNativeModulesEnabled)
    {
      if (!(paramReactPackage instanceof LazyReactPackage))
        throw new IllegalStateException("Lazy native modules requires all ReactPackage to inherit from LazyReactPackage");
      Object localObject1 = (LazyReactPackage)paramReactPackage;
      paramReactPackage = ((LazyReactPackage)localObject1).getNativeModules(this.mReactApplicationContext);
      localObject1 = ((LazyReactPackage)localObject1).getReactModuleInfoProvider().getReactModuleInfos();
      Iterator localIterator = paramReactPackage.iterator();
      while (localIterator.hasNext())
      {
        paramReactPackage = (ModuleSpec)localIterator.next();
        Class localClass1 = paramReactPackage.getType();
        Object localObject2 = (ReactModuleInfo)((Map)localObject1).get(localClass1);
        if (localObject2 == null)
        {
          if (BaseJavaModule.class.isAssignableFrom(localClass1))
            throw new IllegalStateException("Native Java module " + localClass1.getSimpleName() + " should be annotated with @ReactModule and added to a @ReactModuleList.");
          ReactMarker.logMarker(ReactMarkerConstants.CREATE_MODULE_START, paramReactPackage.getType().getName());
        }
        while (true)
        {
          Class localClass2;
          try
          {
            paramReactPackage = (NativeModule)paramReactPackage.getProvider().get();
            ReactMarker.logMarker(ReactMarkerConstants.CREATE_MODULE_END);
            paramReactPackage = new ModuleHolder(paramReactPackage);
            localObject2 = paramReactPackage.getName();
            if (!this.namesToType.containsKey(localObject2))
              break;
            localClass2 = (Class)this.namesToType.get(localObject2);
            if (paramReactPackage.getCanOverrideExistingModule())
              break label313;
            throw new IllegalStateException("Native module " + localClass1.getSimpleName() + " tried to override " + localClass2.getSimpleName() + " for module name " + (String)localObject2 + ". If this was your intention, set canOverrideExistingModule=true");
          }
          finally
          {
            ReactMarker.logMarker(ReactMarkerConstants.CREATE_MODULE_END);
          }
          paramReactPackage = new ModuleHolder((ReactModuleInfo)localObject2, paramReactPackage.getProvider());
          continue;
          label313: this.mModules.remove(localClass2);
        }
        this.namesToType.put(localObject2, localClass1);
        this.mModules.put(localClass1, paramReactPackage);
      }
    }
    FLog.d("ReactNative", paramReactPackage.getClass().getSimpleName() + " is not a LazyReactPackage, falling back to old version.");
    if ((paramReactPackage instanceof ReactInstancePackage));
    for (paramReactPackage = ((ReactInstancePackage)paramReactPackage).createNativeModules(this.mReactApplicationContext, this.mReactInstanceManager); ; paramReactPackage = paramReactPackage.createNativeModules(this.mReactApplicationContext))
    {
      paramReactPackage = paramReactPackage.iterator();
      while (paramReactPackage.hasNext())
        addNativeModule((NativeModule)paramReactPackage.next());
    }
  }
}

/* Location:           C:\Users\c_jealom1\Documents\Scripts\Android\Fathom_com.brynk.fathom\Fathom_com.brynk.fathom-dex2jar.jar
 * Qualified Name:     com.facebook.react.NativeModuleRegistryBuilder
 * JD-Core Version:    0.6.0
 */
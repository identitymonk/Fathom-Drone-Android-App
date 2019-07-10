package com.facebook.react.bridge;

import com.facebook.infer.annotation.Assertions;
import com.facebook.systrace.Systrace;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class NativeModuleRegistry
{
  private final ArrayList<ModuleHolder> mBatchCompleteListenerModules;
  private final Map<Class<? extends NativeModule>, ModuleHolder> mModules;
  private final ReactApplicationContext mReactApplicationContext;

  public NativeModuleRegistry(ReactApplicationContext paramReactApplicationContext, Map<Class<? extends NativeModule>, ModuleHolder> paramMap, ArrayList<ModuleHolder> paramArrayList)
  {
    this.mReactApplicationContext = paramReactApplicationContext;
    this.mModules = paramMap;
    this.mBatchCompleteListenerModules = paramArrayList;
  }

  private ArrayList<ModuleHolder> getBatchCompleteListenerModules()
  {
    return this.mBatchCompleteListenerModules;
  }

  private Map<Class<? extends NativeModule>, ModuleHolder> getModuleMap()
  {
    return this.mModules;
  }

  private ReactApplicationContext getReactApplicationContext()
  {
    return this.mReactApplicationContext;
  }

  public List<NativeModule> getAllModules()
  {
    ArrayList localArrayList = new ArrayList();
    Iterator localIterator = this.mModules.values().iterator();
    while (localIterator.hasNext())
      localArrayList.add(((ModuleHolder)localIterator.next()).getModule());
    return localArrayList;
  }

  Collection<ModuleHolder> getCxxModules()
  {
    ArrayList localArrayList = new ArrayList();
    Iterator localIterator = this.mModules.entrySet().iterator();
    while (localIterator.hasNext())
    {
      Map.Entry localEntry = (Map.Entry)localIterator.next();
      if (!CxxModuleWrapperBase.class.isAssignableFrom((Class)localEntry.getKey()))
        continue;
      localArrayList.add(localEntry.getValue());
    }
    return localArrayList;
  }

  Collection<JavaModuleWrapper> getJavaModules(JSInstance paramJSInstance)
  {
    ArrayList localArrayList = new ArrayList();
    Iterator localIterator = this.mModules.entrySet().iterator();
    while (localIterator.hasNext())
    {
      Map.Entry localEntry = (Map.Entry)localIterator.next();
      Class localClass = (Class)localEntry.getKey();
      if (CxxModuleWrapperBase.class.isAssignableFrom(localClass))
        continue;
      localArrayList.add(new JavaModuleWrapper(paramJSInstance, localClass, (ModuleHolder)localEntry.getValue()));
    }
    return localArrayList;
  }

  public <T extends NativeModule> T getModule(Class<T> paramClass)
  {
    return ((ModuleHolder)Assertions.assertNotNull(this.mModules.get(paramClass))).getModule();
  }

  public <T extends NativeModule> boolean hasModule(Class<T> paramClass)
  {
    return this.mModules.containsKey(paramClass);
  }

  void notifyJSInstanceDestroy()
  {
    this.mReactApplicationContext.assertOnNativeModulesQueueThread();
    Systrace.beginSection(0L, "NativeModuleRegistry_notifyJSInstanceDestroy");
    try
    {
      Iterator localIterator = this.mModules.values().iterator();
      while (localIterator.hasNext())
        ((ModuleHolder)localIterator.next()).destroy();
    }
    finally
    {
      Systrace.endSection(0L);
    }
    Systrace.endSection(0L);
  }

  void notifyJSInstanceInitialized()
  {
    this.mReactApplicationContext.assertOnNativeModulesQueueThread("From version React Native v0.44, native modules are explicitly not initialized on the UI thread. See https://github.com/facebook/react-native/wiki/Breaking-Changes#d4611211-reactnativeandroidbreaking-move-nativemodule-initialization-off-ui-thread---aaachiuuu  for more details.");
    ReactMarker.logMarker(ReactMarkerConstants.NATIVE_MODULE_INITIALIZE_START);
    Systrace.beginSection(0L, "NativeModuleRegistry_notifyJSInstanceInitialized");
    try
    {
      Iterator localIterator = this.mModules.values().iterator();
      while (localIterator.hasNext())
        ((ModuleHolder)localIterator.next()).markInitializable();
    }
    finally
    {
      Systrace.endSection(0L);
      ReactMarker.logMarker(ReactMarkerConstants.NATIVE_MODULE_INITIALIZE_END);
    }
    Systrace.endSection(0L);
    ReactMarker.logMarker(ReactMarkerConstants.NATIVE_MODULE_INITIALIZE_END);
  }

  public void onBatchComplete()
  {
    Iterator localIterator = this.mBatchCompleteListenerModules.iterator();
    while (localIterator.hasNext())
    {
      ModuleHolder localModuleHolder = (ModuleHolder)localIterator.next();
      if (!localModuleHolder.hasInstance())
        continue;
      ((OnBatchCompleteListener)localModuleHolder.getModule()).onBatchComplete();
    }
  }

  void registerModules(NativeModuleRegistry paramNativeModuleRegistry)
  {
    Assertions.assertCondition(this.mReactApplicationContext.equals(paramNativeModuleRegistry.getReactApplicationContext()), "Extending native modules with non-matching application contexts.");
    Object localObject1 = paramNativeModuleRegistry.getModuleMap();
    paramNativeModuleRegistry = paramNativeModuleRegistry.getBatchCompleteListenerModules();
    localObject1 = ((Map)localObject1).entrySet().iterator();
    while (((Iterator)localObject1).hasNext())
    {
      Object localObject2 = (Map.Entry)((Iterator)localObject1).next();
      Class localClass = (Class)((Map.Entry)localObject2).getKey();
      if (this.mModules.containsKey(localClass))
        continue;
      localObject2 = (ModuleHolder)((Map.Entry)localObject2).getValue();
      if (paramNativeModuleRegistry.contains(localObject2))
        this.mBatchCompleteListenerModules.add(localObject2);
      this.mModules.put(localClass, localObject2);
    }
  }
}

/* Location:           C:\Users\c_jealom1\Documents\Scripts\Android\Fathom_com.brynk.fathom\Fathom_com.brynk.fathom-dex2jar.jar
 * Qualified Name:     com.facebook.react.bridge.NativeModuleRegistry
 * JD-Core Version:    0.6.0
 */
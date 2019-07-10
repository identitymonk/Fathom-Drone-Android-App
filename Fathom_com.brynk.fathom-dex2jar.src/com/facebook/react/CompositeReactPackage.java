package com.facebook.react;

import com.facebook.react.bridge.NativeModule;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.uimanager.ViewManager;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.List<Lcom.facebook.react.bridge.NativeModule;>;
import java.util.List<Ljava.lang.String;>;
import java.util.ListIterator;
import java.util.Map;
import java.util.Set;
import javax.annotation.Nullable;

public class CompositeReactPackage extends ReactInstancePackage
  implements ViewManagerOnDemandReactPackage
{
  private final List<ReactPackage> mChildReactPackages = new ArrayList();

  public CompositeReactPackage(ReactPackage paramReactPackage1, ReactPackage paramReactPackage2, ReactPackage[] paramArrayOfReactPackage)
  {
    this.mChildReactPackages.add(paramReactPackage1);
    this.mChildReactPackages.add(paramReactPackage2);
    Collections.addAll(this.mChildReactPackages, paramArrayOfReactPackage);
  }

  public List<NativeModule> createNativeModules(ReactApplicationContext paramReactApplicationContext)
  {
    HashMap localHashMap = new HashMap();
    Iterator localIterator1 = this.mChildReactPackages.iterator();
    while (localIterator1.hasNext())
    {
      Iterator localIterator2 = ((ReactPackage)localIterator1.next()).createNativeModules(paramReactApplicationContext).iterator();
      while (localIterator2.hasNext())
      {
        NativeModule localNativeModule = (NativeModule)localIterator2.next();
        localHashMap.put(localNativeModule.getName(), localNativeModule);
      }
    }
    return new ArrayList(localHashMap.values());
  }

  public List<NativeModule> createNativeModules(ReactApplicationContext paramReactApplicationContext, ReactInstanceManager paramReactInstanceManager)
  {
    HashMap localHashMap = new HashMap();
    Iterator localIterator = this.mChildReactPackages.iterator();
    if (localIterator.hasNext())
    {
      Object localObject = (ReactPackage)localIterator.next();
      if ((localObject instanceof ReactInstancePackage));
      for (localObject = ((ReactInstancePackage)localObject).createNativeModules(paramReactApplicationContext, paramReactInstanceManager); ; localObject = ((ReactPackage)localObject).createNativeModules(paramReactApplicationContext))
      {
        localObject = ((List)localObject).iterator();
        while (((Iterator)localObject).hasNext())
        {
          NativeModule localNativeModule = (NativeModule)((Iterator)localObject).next();
          localHashMap.put(localNativeModule.getName(), localNativeModule);
        }
        break;
      }
    }
    return (List<NativeModule>)new ArrayList(localHashMap.values());
  }

  @Nullable
  public ViewManager createViewManager(ReactApplicationContext paramReactApplicationContext, String paramString)
  {
    ListIterator localListIterator = this.mChildReactPackages.listIterator(this.mChildReactPackages.size());
    while (localListIterator.hasPrevious())
    {
      Object localObject = (ReactPackage)localListIterator.previous();
      if (!(localObject instanceof ViewManagerOnDemandReactPackage))
        continue;
      localObject = ((ViewManagerOnDemandReactPackage)localObject).createViewManager(paramReactApplicationContext, paramString);
      if (localObject != null)
        return localObject;
    }
    return (ViewManager)null;
  }

  public List<ViewManager> createViewManagers(ReactApplicationContext paramReactApplicationContext)
  {
    HashMap localHashMap = new HashMap();
    Iterator localIterator1 = this.mChildReactPackages.iterator();
    while (localIterator1.hasNext())
    {
      Iterator localIterator2 = ((ReactPackage)localIterator1.next()).createViewManagers(paramReactApplicationContext).iterator();
      while (localIterator2.hasNext())
      {
        ViewManager localViewManager = (ViewManager)localIterator2.next();
        localHashMap.put(localViewManager.getName(), localViewManager);
      }
    }
    return new ArrayList(localHashMap.values());
  }

  public List<String> getViewManagerNames(ReactApplicationContext paramReactApplicationContext)
  {
    HashSet localHashSet = new HashSet();
    Iterator localIterator = this.mChildReactPackages.iterator();
    while (localIterator.hasNext())
    {
      Object localObject = (ReactPackage)localIterator.next();
      if (!(localObject instanceof ViewManagerOnDemandReactPackage))
        continue;
      localObject = ((ViewManagerOnDemandReactPackage)localObject).getViewManagerNames(paramReactApplicationContext);
      if (localObject == null)
        continue;
      localHashSet.addAll((Collection)localObject);
    }
    return (List<String>)new ArrayList(localHashSet);
  }
}

/* Location:           C:\Users\c_jealom1\Documents\Scripts\Android\Fathom_com.brynk.fathom\Fathom_com.brynk.fathom-dex2jar.jar
 * Qualified Name:     com.facebook.react.CompositeReactPackage
 * JD-Core Version:    0.6.0
 */
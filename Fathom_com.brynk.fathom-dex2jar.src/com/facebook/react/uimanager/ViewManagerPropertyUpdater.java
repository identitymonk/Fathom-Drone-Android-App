package com.facebook.react.uimanager;

import android.view.View;
import com.facebook.common.logging.FLog;
import com.facebook.react.bridge.ReadableMap;
import com.facebook.react.bridge.ReadableMapKeySetIterator;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class ViewManagerPropertyUpdater
{
  private static final Map<Class<?>, ShadowNodeSetter<?>> SHADOW_NODE_SETTER_MAP;
  private static final String TAG = "ViewManagerPropertyUpdater";
  private static final Map<Class<?>, ViewManagerSetter<?, ?>> VIEW_MANAGER_SETTER_MAP = new HashMap();

  static
  {
    SHADOW_NODE_SETTER_MAP = new HashMap();
  }

  public static void clear()
  {
    ViewManagersPropertyCache.clear();
    VIEW_MANAGER_SETTER_MAP.clear();
    SHADOW_NODE_SETTER_MAP.clear();
  }

  private static <T> T findGeneratedSetter(Class<?> paramClass)
  {
    String str = paramClass.getName();
    try
    {
      Object localObject = Class.forName(str + "$$PropsSetter").newInstance();
      return localObject;
    }
    catch (ClassNotFoundException localClassNotFoundException)
    {
      FLog.w("ViewManagerPropertyUpdater", "Could not find generated setter for " + paramClass);
      return null;
    }
    catch (java.lang.InstantiationException paramClass)
    {
      throw new RuntimeException("Unable to instantiate methods getter for " + localClassNotFoundException, paramClass);
    }
    catch (java.lang.IllegalAccessException paramClass)
    {
      label61: break label61;
    }
  }

  private static <T extends ViewManager, V extends View> ViewManagerSetter<T, V> findManagerSetter(Class<? extends ViewManager> paramClass)
  {
    ViewManagerSetter localViewManagerSetter = (ViewManagerSetter)VIEW_MANAGER_SETTER_MAP.get(paramClass);
    Object localObject = localViewManagerSetter;
    if (localViewManagerSetter == null)
    {
      localViewManagerSetter = (ViewManagerSetter)findGeneratedSetter(paramClass);
      localObject = localViewManagerSetter;
      if (localViewManagerSetter == null)
        localObject = new FallbackViewManagerSetter(paramClass, null);
      VIEW_MANAGER_SETTER_MAP.put(paramClass, localObject);
    }
    return (ViewManagerSetter<T, V>)localObject;
  }

  private static <T extends ReactShadowNode> ShadowNodeSetter<T> findNodeSetter(Class<? extends ReactShadowNode> paramClass)
  {
    ShadowNodeSetter localShadowNodeSetter = (ShadowNodeSetter)SHADOW_NODE_SETTER_MAP.get(paramClass);
    Object localObject = localShadowNodeSetter;
    if (localShadowNodeSetter == null)
    {
      localShadowNodeSetter = (ShadowNodeSetter)findGeneratedSetter(paramClass);
      localObject = localShadowNodeSetter;
      if (localShadowNodeSetter == null)
        localObject = new FallbackShadowNodeSetter(paramClass, null);
      SHADOW_NODE_SETTER_MAP.put(paramClass, localObject);
    }
    return (ShadowNodeSetter<T>)localObject;
  }

  public static Map<String, String> getNativeProps(Class<? extends ViewManager> paramClass, Class<? extends ReactShadowNode> paramClass1)
  {
    HashMap localHashMap = new HashMap();
    findManagerSetter(paramClass).getProperties(localHashMap);
    findNodeSetter(paramClass1).getProperties(localHashMap);
    return localHashMap;
  }

  public static <T extends ReactShadowNode> void updateProps(T paramT, ReactStylesDiffMap paramReactStylesDiffMap)
  {
    ShadowNodeSetter localShadowNodeSetter = findNodeSetter(paramT.getClass());
    ReadableMapKeySetIterator localReadableMapKeySetIterator = paramReactStylesDiffMap.mBackingMap.keySetIterator();
    while (localReadableMapKeySetIterator.hasNextKey())
      localShadowNodeSetter.setProperty(paramT, localReadableMapKeySetIterator.nextKey(), paramReactStylesDiffMap);
  }

  public static <T extends ViewManager, V extends View> void updateProps(T paramT, V paramV, ReactStylesDiffMap paramReactStylesDiffMap)
  {
    ViewManagerSetter localViewManagerSetter = findManagerSetter(paramT.getClass());
    ReadableMapKeySetIterator localReadableMapKeySetIterator = paramReactStylesDiffMap.mBackingMap.keySetIterator();
    while (localReadableMapKeySetIterator.hasNextKey())
      localViewManagerSetter.setProperty(paramT, paramV, localReadableMapKeySetIterator.nextKey(), paramReactStylesDiffMap);
  }

  private static class FallbackShadowNodeSetter<T extends ReactShadowNode>
    implements ViewManagerPropertyUpdater.ShadowNodeSetter<T>
  {
    private final Map<String, ViewManagersPropertyCache.PropSetter> mPropSetters;

    private FallbackShadowNodeSetter(Class<? extends ReactShadowNode> paramClass)
    {
      this.mPropSetters = ViewManagersPropertyCache.getNativePropSettersForShadowNodeClass(paramClass);
    }

    public void getProperties(Map<String, String> paramMap)
    {
      Iterator localIterator = this.mPropSetters.values().iterator();
      while (localIterator.hasNext())
      {
        ViewManagersPropertyCache.PropSetter localPropSetter = (ViewManagersPropertyCache.PropSetter)localIterator.next();
        paramMap.put(localPropSetter.getPropName(), localPropSetter.getPropType());
      }
    }

    public void setProperty(ReactShadowNode paramReactShadowNode, String paramString, ReactStylesDiffMap paramReactStylesDiffMap)
    {
      paramString = (ViewManagersPropertyCache.PropSetter)this.mPropSetters.get(paramString);
      if (paramString != null)
        paramString.updateShadowNodeProp(paramReactShadowNode, paramReactStylesDiffMap);
    }
  }

  private static class FallbackViewManagerSetter<T extends ViewManager, V extends View>
    implements ViewManagerPropertyUpdater.ViewManagerSetter<T, V>
  {
    private final Map<String, ViewManagersPropertyCache.PropSetter> mPropSetters;

    private FallbackViewManagerSetter(Class<? extends ViewManager> paramClass)
    {
      this.mPropSetters = ViewManagersPropertyCache.getNativePropSettersForViewManagerClass(paramClass);
    }

    public void getProperties(Map<String, String> paramMap)
    {
      Iterator localIterator = this.mPropSetters.values().iterator();
      while (localIterator.hasNext())
      {
        ViewManagersPropertyCache.PropSetter localPropSetter = (ViewManagersPropertyCache.PropSetter)localIterator.next();
        paramMap.put(localPropSetter.getPropName(), localPropSetter.getPropType());
      }
    }

    public void setProperty(T paramT, V paramV, String paramString, ReactStylesDiffMap paramReactStylesDiffMap)
    {
      paramString = (ViewManagersPropertyCache.PropSetter)this.mPropSetters.get(paramString);
      if (paramString != null)
        paramString.updateViewProp(paramT, paramV, paramReactStylesDiffMap);
    }
  }

  public static abstract interface Settable
  {
    public abstract void getProperties(Map<String, String> paramMap);
  }

  public static abstract interface ShadowNodeSetter<T extends ReactShadowNode> extends ViewManagerPropertyUpdater.Settable
  {
    public abstract void setProperty(T paramT, String paramString, ReactStylesDiffMap paramReactStylesDiffMap);
  }

  public static abstract interface ViewManagerSetter<T extends ViewManager, V extends View> extends ViewManagerPropertyUpdater.Settable
  {
    public abstract void setProperty(T paramT, V paramV, String paramString, ReactStylesDiffMap paramReactStylesDiffMap);
  }
}

/* Location:           C:\Users\c_jealom1\Documents\Scripts\Android\Fathom_com.brynk.fathom\Fathom_com.brynk.fathom-dex2jar.jar
 * Qualified Name:     com.facebook.react.uimanager.ViewManagerPropertyUpdater
 * JD-Core Version:    0.6.0
 */
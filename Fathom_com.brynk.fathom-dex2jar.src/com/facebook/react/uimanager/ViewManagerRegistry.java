package com.facebook.react.uimanager;

import com.facebook.react.common.MapBuilder;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import javax.annotation.Nullable;

public final class ViewManagerRegistry
{

  @Nullable
  private final UIManagerModule.ViewManagerResolver mViewManagerResolver;
  private final Map<String, ViewManager> mViewManagers;

  public ViewManagerRegistry(UIManagerModule.ViewManagerResolver paramViewManagerResolver)
  {
    this.mViewManagers = MapBuilder.newHashMap();
    this.mViewManagerResolver = paramViewManagerResolver;
  }

  public ViewManagerRegistry(List<ViewManager> paramList)
  {
    HashMap localHashMap = MapBuilder.newHashMap();
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      ViewManager localViewManager = (ViewManager)paramList.next();
      localHashMap.put(localViewManager.getName(), localViewManager);
    }
    this.mViewManagers = localHashMap;
    this.mViewManagerResolver = null;
  }

  public ViewManagerRegistry(Map<String, ViewManager> paramMap)
  {
    if (paramMap != null);
    while (true)
    {
      this.mViewManagers = paramMap;
      this.mViewManagerResolver = null;
      return;
      paramMap = MapBuilder.newHashMap();
    }
  }

  public ViewManager get(String paramString)
  {
    ViewManager localViewManager = (ViewManager)this.mViewManagers.get(paramString);
    if (localViewManager != null)
      return localViewManager;
    if (this.mViewManagerResolver != null)
    {
      localViewManager = this.mViewManagerResolver.getViewManager(paramString);
      if (localViewManager != null)
      {
        this.mViewManagers.put(paramString, localViewManager);
        return localViewManager;
      }
    }
    throw new IllegalViewOperationException("No ViewManager defined for class " + paramString);
  }
}

/* Location:           C:\Users\c_jealom1\Documents\Scripts\Android\Fathom_com.brynk.fathom\Fathom_com.brynk.fathom-dex2jar.jar
 * Qualified Name:     com.facebook.react.uimanager.ViewManagerRegistry
 * JD-Core Version:    0.6.0
 */
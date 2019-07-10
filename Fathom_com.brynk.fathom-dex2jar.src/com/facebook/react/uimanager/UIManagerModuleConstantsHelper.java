package com.facebook.react.uimanager;

import com.facebook.react.common.MapBuilder;
import com.facebook.systrace.Systrace;
import com.facebook.systrace.SystraceMessage;
import com.facebook.systrace.SystraceMessage.Builder;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map<Ljava.lang.String;Ljava.lang.Object;>;
import java.util.Set;
import javax.annotation.Nullable;

class UIManagerModuleConstantsHelper
{
  private static final String BUBBLING_EVENTS_KEY = "bubblingEventTypes";
  private static final String DIRECT_EVENTS_KEY = "directEventTypes";

  static Map<String, Object> createConstants(UIManagerModule.ViewManagerResolver paramViewManagerResolver)
  {
    Map localMap = UIManagerModuleConstants.getConstants();
    localMap.put("ViewManagerNames", paramViewManagerResolver.getViewManagerNames());
    return localMap;
  }

  static Map<String, Object> createConstants(List<ViewManager> paramList, @Nullable Map<String, Object> paramMap1, @Nullable Map<String, Object> paramMap2)
  {
    Map localMap1 = UIManagerModuleConstants.getConstants();
    Map localMap2 = UIManagerModuleConstants.getBubblingEventTypeConstants();
    Map localMap3 = UIManagerModuleConstants.getDirectEventTypeConstants();
    if (paramMap1 != null)
      paramMap1.putAll(localMap2);
    if (paramMap2 != null)
      paramMap2.putAll(localMap3);
    paramList = paramList.iterator();
    while (true)
    {
      Object localObject;
      String str;
      if (paramList.hasNext())
      {
        localObject = (ViewManager)paramList.next();
        str = ((ViewManager)localObject).getName();
        SystraceMessage.beginSection(0L, "constants for ViewManager").arg("ViewManager", str).arg("Lazy", Boolean.valueOf(false)).flush();
      }
      try
      {
        localObject = createConstantsForViewManager((ViewManager)localObject, null, null, paramMap1, paramMap2);
        if (!((Map)localObject).isEmpty())
          localMap1.put(str, localObject);
        Systrace.endSection(0L);
      }
      finally
      {
        Systrace.endSection(0L);
      }
    }
    localMap1.put("genericDirectEventTypes", localMap3);
    return (Map<String, Object>)localMap1;
  }

  static Map<String, Object> createConstantsForViewManager(ViewManager paramViewManager, @Nullable Map paramMap1, @Nullable Map paramMap2, @Nullable Map paramMap3, @Nullable Map paramMap4)
  {
    HashMap localHashMap = MapBuilder.newHashMap();
    Map localMap = paramViewManager.getExportedCustomBubblingEventTypeConstants();
    if (localMap != null)
    {
      recursiveMerge(paramMap3, localMap);
      recursiveMerge(localMap, paramMap1);
      localHashMap.put("bubblingEventTypes", localMap);
      paramMap1 = paramViewManager.getExportedCustomDirectEventTypeConstants();
      if (paramMap1 == null)
        break label157;
      recursiveMerge(paramMap4, paramMap1);
      recursiveMerge(paramMap1, paramMap2);
      localHashMap.put("directEventTypes", paramMap1);
    }
    while (true)
    {
      paramMap1 = paramViewManager.getExportedViewConstants();
      if (paramMap1 != null)
        localHashMap.put("Constants", paramMap1);
      paramMap1 = paramViewManager.getCommandsMap();
      if (paramMap1 != null)
        localHashMap.put("Commands", paramMap1);
      paramViewManager = paramViewManager.getNativeProps();
      if (!paramViewManager.isEmpty())
        localHashMap.put("NativeProps", paramViewManager);
      return localHashMap;
      if (paramMap1 == null)
        break;
      localHashMap.put("bubblingEventTypes", paramMap1);
      break;
      label157: if (paramMap2 == null)
        continue;
      localHashMap.put("directEventTypes", paramMap2);
    }
  }

  static Map<String, Object> getDefaultExportableEventTypes()
  {
    return MapBuilder.of("bubblingEventTypes", UIManagerModuleConstants.getBubblingEventTypeConstants(), "directEventTypes", UIManagerModuleConstants.getDirectEventTypeConstants());
  }

  private static void recursiveMerge(@Nullable Map paramMap1, @Nullable Map paramMap2)
  {
    if ((paramMap1 == null) || (paramMap2 == null) || (paramMap2.isEmpty()));
    while (true)
    {
      return;
      Iterator localIterator = paramMap2.keySet().iterator();
      while (localIterator.hasNext())
      {
        Object localObject1 = localIterator.next();
        Object localObject2 = paramMap2.get(localObject1);
        Object localObject3 = paramMap1.get(localObject1);
        if ((localObject3 != null) && ((localObject2 instanceof Map)) && ((localObject3 instanceof Map)))
        {
          recursiveMerge((Map)localObject3, (Map)localObject2);
          continue;
        }
        paramMap1.put(localObject1, localObject2);
      }
    }
  }
}

/* Location:           C:\Users\c_jealom1\Documents\Scripts\Android\Fathom_com.brynk.fathom\Fathom_com.brynk.fathom-dex2jar.jar
 * Qualified Name:     com.facebook.react.uimanager.UIManagerModuleConstantsHelper
 * JD-Core Version:    0.6.0
 */
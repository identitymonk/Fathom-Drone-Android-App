package com.facebook.react.views.swiperefresh;

import android.support.v4.widget.SwipeRefreshLayout.OnRefreshListener;
import com.facebook.react.bridge.ReadableArray;
import com.facebook.react.common.MapBuilder;
import com.facebook.react.common.MapBuilder.Builder;
import com.facebook.react.module.annotations.ReactModule;
import com.facebook.react.uimanager.ThemedReactContext;
import com.facebook.react.uimanager.UIManagerModule;
import com.facebook.react.uimanager.ViewGroupManager;
import com.facebook.react.uimanager.annotations.ReactProp;
import com.facebook.react.uimanager.events.EventDispatcher;
import java.util.Map;
import javax.annotation.Nullable;

@ReactModule(name="AndroidSwipeRefreshLayout")
public class SwipeRefreshLayoutManager extends ViewGroupManager<ReactSwipeRefreshLayout>
{
  protected static final String REACT_CLASS = "AndroidSwipeRefreshLayout";

  protected void addEventEmitters(ThemedReactContext paramThemedReactContext, ReactSwipeRefreshLayout paramReactSwipeRefreshLayout)
  {
    paramReactSwipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener(paramThemedReactContext, paramReactSwipeRefreshLayout)
    {
      public void onRefresh()
      {
        ((UIManagerModule)this.val$reactContext.getNativeModule(UIManagerModule.class)).getEventDispatcher().dispatchEvent(new RefreshEvent(this.val$view.getId()));
      }
    });
  }

  protected ReactSwipeRefreshLayout createViewInstance(ThemedReactContext paramThemedReactContext)
  {
    return new ReactSwipeRefreshLayout(paramThemedReactContext);
  }

  public Map<String, Object> getExportedCustomDirectEventTypeConstants()
  {
    return MapBuilder.builder().put("topRefresh", MapBuilder.of("registrationName", "onRefresh")).build();
  }

  @Nullable
  public Map<String, Object> getExportedViewConstants()
  {
    return MapBuilder.of("SIZE", MapBuilder.of("DEFAULT", Integer.valueOf(1), "LARGE", Integer.valueOf(0)));
  }

  public String getName()
  {
    return "AndroidSwipeRefreshLayout";
  }

  @ReactProp(customType="ColorArray", name="colors")
  public void setColors(ReactSwipeRefreshLayout paramReactSwipeRefreshLayout, @Nullable ReadableArray paramReadableArray)
  {
    if (paramReadableArray != null)
    {
      int[] arrayOfInt = new int[paramReadableArray.size()];
      int i = 0;
      while (i < paramReadableArray.size())
      {
        arrayOfInt[i] = paramReadableArray.getInt(i);
        i += 1;
      }
      paramReactSwipeRefreshLayout.setColorSchemeColors(arrayOfInt);
      return;
    }
    paramReactSwipeRefreshLayout.setColorSchemeColors(new int[0]);
  }

  @ReactProp(defaultBoolean=true, name="enabled")
  public void setEnabled(ReactSwipeRefreshLayout paramReactSwipeRefreshLayout, boolean paramBoolean)
  {
    paramReactSwipeRefreshLayout.setEnabled(paramBoolean);
  }

  @ReactProp(customType="Color", defaultInt=0, name="progressBackgroundColor")
  public void setProgressBackgroundColor(ReactSwipeRefreshLayout paramReactSwipeRefreshLayout, int paramInt)
  {
    paramReactSwipeRefreshLayout.setProgressBackgroundColorSchemeColor(paramInt);
  }

  @ReactProp(defaultFloat=0.0F, name="progressViewOffset")
  public void setProgressViewOffset(ReactSwipeRefreshLayout paramReactSwipeRefreshLayout, float paramFloat)
  {
    paramReactSwipeRefreshLayout.setProgressViewOffset(paramFloat);
  }

  @ReactProp(name="refreshing")
  public void setRefreshing(ReactSwipeRefreshLayout paramReactSwipeRefreshLayout, boolean paramBoolean)
  {
    paramReactSwipeRefreshLayout.setRefreshing(paramBoolean);
  }

  @ReactProp(defaultInt=1, name="size")
  public void setSize(ReactSwipeRefreshLayout paramReactSwipeRefreshLayout, int paramInt)
  {
    paramReactSwipeRefreshLayout.setSize(paramInt);
  }
}

/* Location:           C:\Users\c_jealom1\Documents\Scripts\Android\Fathom_com.brynk.fathom\Fathom_com.brynk.fathom-dex2jar.jar
 * Qualified Name:     com.facebook.react.views.swiperefresh.SwipeRefreshLayoutManager
 * JD-Core Version:    0.6.0
 */
package com.facebook.react.views.drawer;

import android.os.Build.VERSION;
import android.support.v4.widget.DrawerLayout;
import android.support.v4.widget.DrawerLayout.DrawerListener;
import android.view.View;
import com.facebook.common.logging.FLog;
import com.facebook.react.bridge.JSApplicationIllegalArgumentException;
import com.facebook.react.bridge.ReadableArray;
import com.facebook.react.common.MapBuilder;
import com.facebook.react.module.annotations.ReactModule;
import com.facebook.react.uimanager.PixelUtil;
import com.facebook.react.uimanager.ThemedReactContext;
import com.facebook.react.uimanager.UIManagerModule;
import com.facebook.react.uimanager.ViewGroupManager;
import com.facebook.react.uimanager.annotations.ReactProp;
import com.facebook.react.uimanager.events.EventDispatcher;
import com.facebook.react.views.drawer.events.DrawerClosedEvent;
import com.facebook.react.views.drawer.events.DrawerOpenedEvent;
import com.facebook.react.views.drawer.events.DrawerSlideEvent;
import com.facebook.react.views.drawer.events.DrawerStateChangedEvent;
import java.lang.reflect.Method;
import java.util.Map;
import javax.annotation.Nullable;

@ReactModule(name="AndroidDrawerLayout")
public class ReactDrawerLayoutManager extends ViewGroupManager<ReactDrawerLayout>
{
  public static final int CLOSE_DRAWER = 2;
  public static final int OPEN_DRAWER = 1;
  protected static final String REACT_CLASS = "AndroidDrawerLayout";

  protected void addEventEmitters(ThemedReactContext paramThemedReactContext, ReactDrawerLayout paramReactDrawerLayout)
  {
    paramReactDrawerLayout.setDrawerListener(new DrawerEventEmitter(paramReactDrawerLayout, ((UIManagerModule)paramThemedReactContext.getNativeModule(UIManagerModule.class)).getEventDispatcher()));
  }

  public void addView(ReactDrawerLayout paramReactDrawerLayout, View paramView, int paramInt)
  {
    if (getChildCount(paramReactDrawerLayout) >= 2)
      throw new JSApplicationIllegalArgumentException("The Drawer cannot have more than two children");
    if ((paramInt != 0) && (paramInt != 1))
      throw new JSApplicationIllegalArgumentException("The only valid indices for drawer's child are 0 or 1. Got " + paramInt + " instead.");
    paramReactDrawerLayout.addView(paramView, paramInt);
    paramReactDrawerLayout.setDrawerProperties();
  }

  protected ReactDrawerLayout createViewInstance(ThemedReactContext paramThemedReactContext)
  {
    return new ReactDrawerLayout(paramThemedReactContext);
  }

  @Nullable
  public Map<String, Integer> getCommandsMap()
  {
    return MapBuilder.of("openDrawer", Integer.valueOf(1), "closeDrawer", Integer.valueOf(2));
  }

  @ReactProp(defaultFloat=(0.0F / 0.0F), name="drawerWidth")
  public void getDrawerWidth(ReactDrawerLayout paramReactDrawerLayout, float paramFloat)
  {
    if (Float.isNaN(paramFloat));
    for (int i = -1; ; i = Math.round(PixelUtil.toPixelFromDIP(paramFloat)))
    {
      paramReactDrawerLayout.setDrawerWidth(i);
      return;
    }
  }

  @Nullable
  public Map getExportedCustomDirectEventTypeConstants()
  {
    return MapBuilder.of("topDrawerSlide", MapBuilder.of("registrationName", "onDrawerSlide"), "topDrawerOpened", MapBuilder.of("registrationName", "onDrawerOpen"), "topDrawerClosed", MapBuilder.of("registrationName", "onDrawerClose"), "topDrawerStateChanged", MapBuilder.of("registrationName", "onDrawerStateChanged"));
  }

  @Nullable
  public Map getExportedViewConstants()
  {
    return MapBuilder.of("DrawerPosition", MapBuilder.of("Left", Integer.valueOf(8388611), "Right", Integer.valueOf(8388613)));
  }

  public String getName()
  {
    return "AndroidDrawerLayout";
  }

  public boolean needsCustomLayoutForChildren()
  {
    return true;
  }

  public void receiveCommand(ReactDrawerLayout paramReactDrawerLayout, int paramInt, @Nullable ReadableArray paramReadableArray)
  {
    switch (paramInt)
    {
    default:
      return;
    case 1:
      paramReactDrawerLayout.openDrawer();
      return;
    case 2:
    }
    paramReactDrawerLayout.closeDrawer();
  }

  @ReactProp(name="drawerLockMode")
  public void setDrawerLockMode(ReactDrawerLayout paramReactDrawerLayout, @Nullable String paramString)
  {
    if ((paramString == null) || ("unlocked".equals(paramString)))
    {
      paramReactDrawerLayout.setDrawerLockMode(0);
      return;
    }
    if ("locked-closed".equals(paramString))
    {
      paramReactDrawerLayout.setDrawerLockMode(1);
      return;
    }
    if ("locked-open".equals(paramString))
    {
      paramReactDrawerLayout.setDrawerLockMode(2);
      return;
    }
    throw new JSApplicationIllegalArgumentException("Unknown drawerLockMode " + paramString);
  }

  @ReactProp(defaultInt=8388611, name="drawerPosition")
  public void setDrawerPosition(ReactDrawerLayout paramReactDrawerLayout, int paramInt)
  {
    if ((8388611 == paramInt) || (8388613 == paramInt))
    {
      paramReactDrawerLayout.setDrawerPosition(paramInt);
      return;
    }
    throw new JSApplicationIllegalArgumentException("Unknown drawerPosition " + paramInt);
  }

  public void setElevation(ReactDrawerLayout paramReactDrawerLayout, float paramFloat)
  {
    if (Build.VERSION.SDK_INT >= 21);
    try
    {
      ReactDrawerLayout.class.getMethod("setDrawerElevation", new Class[] { Float.TYPE }).invoke(paramReactDrawerLayout, new Object[] { Float.valueOf(PixelUtil.toPixelFromDIP(paramFloat)) });
      return;
    }
    catch (java.lang.Exception paramReactDrawerLayout)
    {
      FLog.w("ReactNative", "setDrawerElevation is not available in this version of the support lib.", paramReactDrawerLayout);
    }
  }

  public static class DrawerEventEmitter
    implements DrawerLayout.DrawerListener
  {
    private final DrawerLayout mDrawerLayout;
    private final EventDispatcher mEventDispatcher;

    public DrawerEventEmitter(DrawerLayout paramDrawerLayout, EventDispatcher paramEventDispatcher)
    {
      this.mDrawerLayout = paramDrawerLayout;
      this.mEventDispatcher = paramEventDispatcher;
    }

    public void onDrawerClosed(View paramView)
    {
      this.mEventDispatcher.dispatchEvent(new DrawerClosedEvent(this.mDrawerLayout.getId()));
    }

    public void onDrawerOpened(View paramView)
    {
      this.mEventDispatcher.dispatchEvent(new DrawerOpenedEvent(this.mDrawerLayout.getId()));
    }

    public void onDrawerSlide(View paramView, float paramFloat)
    {
      this.mEventDispatcher.dispatchEvent(new DrawerSlideEvent(this.mDrawerLayout.getId(), paramFloat));
    }

    public void onDrawerStateChanged(int paramInt)
    {
      this.mEventDispatcher.dispatchEvent(new DrawerStateChangedEvent(this.mDrawerLayout.getId(), paramInt));
    }
  }
}

/* Location:           C:\Users\c_jealom1\Documents\Scripts\Android\Fathom_com.brynk.fathom\Fathom_com.brynk.fathom-dex2jar.jar
 * Qualified Name:     com.facebook.react.views.drawer.ReactDrawerLayoutManager
 * JD-Core Version:    0.6.0
 */
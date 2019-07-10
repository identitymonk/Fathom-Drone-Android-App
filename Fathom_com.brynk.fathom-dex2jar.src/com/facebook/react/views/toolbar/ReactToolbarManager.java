package com.facebook.react.views.toolbar;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.Resources.Theme;
import android.content.res.TypedArray;
import android.support.v7.widget.Toolbar.OnMenuItemClickListener;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import com.facebook.react.bridge.ReadableArray;
import com.facebook.react.bridge.ReadableMap;
import com.facebook.react.common.MapBuilder;
import com.facebook.react.uimanager.PixelUtil;
import com.facebook.react.uimanager.ThemedReactContext;
import com.facebook.react.uimanager.UIManagerModule;
import com.facebook.react.uimanager.ViewGroupManager;
import com.facebook.react.uimanager.annotations.ReactProp;
import com.facebook.react.uimanager.events.EventDispatcher;
import com.facebook.react.views.toolbar.events.ToolbarClickEvent;
import java.util.Map;
import javax.annotation.Nullable;

public class ReactToolbarManager extends ViewGroupManager<ReactToolbar>
{
  private static final String REACT_CLASS = "ToolbarAndroid";

  private static int[] getDefaultColors(Context paramContext)
  {
    Resources.Theme localTheme = paramContext.getTheme();
    Object localObject2 = null;
    Object localObject3 = null;
    TypedArray localTypedArray5 = null;
    TypedArray localTypedArray3 = null;
    TypedArray localTypedArray1 = localTypedArray3;
    Object localObject1 = localObject3;
    TypedArray localTypedArray2 = localTypedArray5;
    try
    {
      TypedArray localTypedArray4 = localTheme.obtainStyledAttributes(new int[] { getIdentifier(paramContext, "toolbarStyle") });
      localTypedArray1 = localTypedArray3;
      localObject1 = localObject3;
      localTypedArray2 = localTypedArray5;
      localObject2 = localTypedArray4;
      paramContext = localTheme.obtainStyledAttributes(localTypedArray4.getResourceId(0, 0), new int[] { getIdentifier(paramContext, "titleTextAppearance"), getIdentifier(paramContext, "subtitleTextAppearance") });
      localTypedArray1 = localTypedArray3;
      localObject1 = paramContext;
      localTypedArray2 = localTypedArray5;
      localObject2 = localTypedArray4;
      int i = paramContext.getResourceId(0, 0);
      localTypedArray1 = localTypedArray3;
      localObject1 = paramContext;
      localTypedArray2 = localTypedArray5;
      localObject2 = localTypedArray4;
      int j = paramContext.getResourceId(1, 0);
      localTypedArray1 = localTypedArray3;
      localObject1 = paramContext;
      localTypedArray2 = localTypedArray5;
      localObject2 = localTypedArray4;
      localTypedArray5 = localTheme.obtainStyledAttributes(i, new int[] { 16842904 });
      localTypedArray1 = localTypedArray3;
      localObject1 = paramContext;
      localTypedArray2 = localTypedArray5;
      localObject2 = localTypedArray4;
      localTypedArray3 = localTheme.obtainStyledAttributes(j, new int[] { 16842904 });
      localTypedArray1 = localTypedArray3;
      localObject1 = paramContext;
      localTypedArray2 = localTypedArray5;
      localObject2 = localTypedArray4;
      i = localTypedArray5.getColor(0, -16777216);
      localTypedArray1 = localTypedArray3;
      localObject1 = paramContext;
      localTypedArray2 = localTypedArray5;
      localObject2 = localTypedArray4;
      j = localTypedArray3.getColor(0, -16777216);
      recycleQuietly(localTypedArray4);
      recycleQuietly(paramContext);
      recycleQuietly(localTypedArray5);
      recycleQuietly(localTypedArray3);
      return new int[] { i, j };
    }
    finally
    {
      recycleQuietly(localObject2);
      recycleQuietly((TypedArray)localObject1);
      recycleQuietly(localTypedArray2);
      recycleQuietly(localTypedArray1);
    }
    throw paramContext;
  }

  private int[] getDefaultContentInsets(Context paramContext)
  {
    Resources.Theme localTheme = paramContext.getTheme();
    Object localObject2 = null;
    Object localObject3 = null;
    Object localObject1 = localObject3;
    try
    {
      TypedArray localTypedArray = localTheme.obtainStyledAttributes(new int[] { getIdentifier(paramContext, "toolbarStyle") });
      localObject1 = localObject3;
      localObject2 = localTypedArray;
      paramContext = localTheme.obtainStyledAttributes(localTypedArray.getResourceId(0, 0), new int[] { getIdentifier(paramContext, "contentInsetStart"), getIdentifier(paramContext, "contentInsetEnd") });
      localObject1 = paramContext;
      localObject2 = localTypedArray;
      int i = paramContext.getDimensionPixelSize(0, 0);
      localObject1 = paramContext;
      localObject2 = localTypedArray;
      int j = paramContext.getDimensionPixelSize(1, 0);
      recycleQuietly(localTypedArray);
      recycleQuietly(paramContext);
      return new int[] { i, j };
    }
    finally
    {
      recycleQuietly(localObject2);
      recycleQuietly((TypedArray)localObject1);
    }
    throw paramContext;
  }

  private static int getIdentifier(Context paramContext, String paramString)
  {
    return paramContext.getResources().getIdentifier(paramString, "attr", paramContext.getPackageName());
  }

  private static void recycleQuietly(@Nullable TypedArray paramTypedArray)
  {
    if (paramTypedArray != null)
      paramTypedArray.recycle();
  }

  protected void addEventEmitters(ThemedReactContext paramThemedReactContext, ReactToolbar paramReactToolbar)
  {
    paramThemedReactContext = ((UIManagerModule)paramThemedReactContext.getNativeModule(UIManagerModule.class)).getEventDispatcher();
    paramReactToolbar.setNavigationOnClickListener(new View.OnClickListener(paramThemedReactContext, paramReactToolbar)
    {
      public void onClick(View paramView)
      {
        this.val$mEventDispatcher.dispatchEvent(new ToolbarClickEvent(this.val$view.getId(), -1));
      }
    });
    paramReactToolbar.setOnMenuItemClickListener(new Toolbar.OnMenuItemClickListener(paramThemedReactContext, paramReactToolbar)
    {
      public boolean onMenuItemClick(MenuItem paramMenuItem)
      {
        this.val$mEventDispatcher.dispatchEvent(new ToolbarClickEvent(this.val$view.getId(), paramMenuItem.getOrder()));
        return true;
      }
    });
  }

  protected ReactToolbar createViewInstance(ThemedReactContext paramThemedReactContext)
  {
    return new ReactToolbar(paramThemedReactContext);
  }

  @Nullable
  public Map<String, Object> getExportedViewConstants()
  {
    return MapBuilder.of("ShowAsAction", MapBuilder.of("never", Integer.valueOf(0), "always", Integer.valueOf(2), "ifRoom", Integer.valueOf(1)));
  }

  public String getName()
  {
    return "ToolbarAndroid";
  }

  public boolean needsCustomLayoutForChildren()
  {
    return true;
  }

  @ReactProp(name="nativeActions")
  public void setActions(ReactToolbar paramReactToolbar, @Nullable ReadableArray paramReadableArray)
  {
    paramReactToolbar.setActions(paramReadableArray);
  }

  @ReactProp(defaultFloat=(0.0F / 0.0F), name="contentInsetEnd")
  public void setContentInsetEnd(ReactToolbar paramReactToolbar, float paramFloat)
  {
    if (Float.isNaN(paramFloat));
    for (int i = getDefaultContentInsets(paramReactToolbar.getContext())[1]; ; i = Math.round(PixelUtil.toPixelFromDIP(paramFloat)))
    {
      paramReactToolbar.setContentInsetsRelative(paramReactToolbar.getContentInsetStart(), i);
      return;
    }
  }

  @ReactProp(defaultFloat=(0.0F / 0.0F), name="contentInsetStart")
  public void setContentInsetStart(ReactToolbar paramReactToolbar, float paramFloat)
  {
    if (Float.isNaN(paramFloat));
    for (int i = getDefaultContentInsets(paramReactToolbar.getContext())[0]; ; i = Math.round(PixelUtil.toPixelFromDIP(paramFloat)))
    {
      paramReactToolbar.setContentInsetsRelative(i, paramReactToolbar.getContentInsetEnd());
      return;
    }
  }

  @ReactProp(name="logo")
  public void setLogo(ReactToolbar paramReactToolbar, @Nullable ReadableMap paramReadableMap)
  {
    paramReactToolbar.setLogoSource(paramReadableMap);
  }

  @ReactProp(name="navIcon")
  public void setNavIcon(ReactToolbar paramReactToolbar, @Nullable ReadableMap paramReadableMap)
  {
    paramReactToolbar.setNavIconSource(paramReadableMap);
  }

  @ReactProp(name="overflowIcon")
  public void setOverflowIcon(ReactToolbar paramReactToolbar, @Nullable ReadableMap paramReadableMap)
  {
    paramReactToolbar.setOverflowIconSource(paramReadableMap);
  }

  @ReactProp(name="rtl")
  public void setRtl(ReactToolbar paramReactToolbar, boolean paramBoolean)
  {
    if (paramBoolean);
    for (int i = 1; ; i = 0)
    {
      paramReactToolbar.setLayoutDirection(i);
      return;
    }
  }

  @ReactProp(name="subtitle")
  public void setSubtitle(ReactToolbar paramReactToolbar, @Nullable String paramString)
  {
    paramReactToolbar.setSubtitle(paramString);
  }

  @ReactProp(customType="Color", name="subtitleColor")
  public void setSubtitleColor(ReactToolbar paramReactToolbar, @Nullable Integer paramInteger)
  {
    int[] arrayOfInt = getDefaultColors(paramReactToolbar.getContext());
    if (paramInteger != null)
    {
      paramReactToolbar.setSubtitleTextColor(paramInteger.intValue());
      return;
    }
    paramReactToolbar.setSubtitleTextColor(arrayOfInt[1]);
  }

  @ReactProp(name="title")
  public void setTitle(ReactToolbar paramReactToolbar, @Nullable String paramString)
  {
    paramReactToolbar.setTitle(paramString);
  }

  @ReactProp(customType="Color", name="titleColor")
  public void setTitleColor(ReactToolbar paramReactToolbar, @Nullable Integer paramInteger)
  {
    int[] arrayOfInt = getDefaultColors(paramReactToolbar.getContext());
    if (paramInteger != null)
    {
      paramReactToolbar.setTitleTextColor(paramInteger.intValue());
      return;
    }
    paramReactToolbar.setTitleTextColor(arrayOfInt[0]);
  }
}

/* Location:           C:\Users\c_jealom1\Documents\Scripts\Android\Fathom_com.brynk.fathom\Fathom_com.brynk.fathom-dex2jar.jar
 * Qualified Name:     com.facebook.react.views.toolbar.ReactToolbarManager
 * JD-Core Version:    0.6.0
 */
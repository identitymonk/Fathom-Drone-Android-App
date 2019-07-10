package com.facebook.react.views.view;

import android.annotation.TargetApi;
import android.graphics.Rect;
import android.os.Build.VERSION;
import android.view.View;
import com.facebook.react.bridge.JSApplicationIllegalArgumentException;
import com.facebook.react.bridge.ReadableArray;
import com.facebook.react.bridge.ReadableMap;
import com.facebook.react.common.MapBuilder;
import com.facebook.react.common.annotations.VisibleForTesting;
import com.facebook.react.module.annotations.ReactModule;
import com.facebook.react.uimanager.PixelUtil;
import com.facebook.react.uimanager.PointerEvents;
import com.facebook.react.uimanager.ThemedReactContext;
import com.facebook.react.uimanager.ViewGroupManager;
import com.facebook.react.uimanager.annotations.ReactProp;
import com.facebook.react.uimanager.annotations.ReactPropGroup;
import com.facebook.yoga.YogaConstants;
import java.util.Locale;
import java.util.Map;
import javax.annotation.Nullable;

@ReactModule(name="RCTView")
public class ReactViewManager extends ViewGroupManager<ReactViewGroup>
{
  private static final int CMD_HOTSPOT_UPDATE = 1;
  private static final int CMD_SET_PRESSED = 2;

  @VisibleForTesting
  public static final String REACT_CLASS = "RCTView";
  private static final int[] SPACING_TYPES = { 8, 0, 2, 1, 3 };

  public void addView(ReactViewGroup paramReactViewGroup, View paramView, int paramInt)
  {
    if (paramReactViewGroup.getRemoveClippedSubviews())
    {
      paramReactViewGroup.addViewWithSubviewClippingEnabled(paramView, paramInt);
      return;
    }
    paramReactViewGroup.addView(paramView, paramInt);
  }

  public ReactViewGroup createViewInstance(ThemedReactContext paramThemedReactContext)
  {
    return new ReactViewGroup(paramThemedReactContext);
  }

  public View getChildAt(ReactViewGroup paramReactViewGroup, int paramInt)
  {
    if (paramReactViewGroup.getRemoveClippedSubviews())
      return paramReactViewGroup.getChildAtWithSubviewClippingEnabled(paramInt);
    return paramReactViewGroup.getChildAt(paramInt);
  }

  public int getChildCount(ReactViewGroup paramReactViewGroup)
  {
    if (paramReactViewGroup.getRemoveClippedSubviews())
      return paramReactViewGroup.getAllChildrenCount();
    return paramReactViewGroup.getChildCount();
  }

  public Map<String, Integer> getCommandsMap()
  {
    return MapBuilder.of("hotspotUpdate", Integer.valueOf(1), "setPressed", Integer.valueOf(2));
  }

  public String getName()
  {
    return "RCTView";
  }

  public void receiveCommand(ReactViewGroup paramReactViewGroup, int paramInt, @Nullable ReadableArray paramReadableArray)
  {
    switch (paramInt)
    {
    default:
    case 1:
      do
      {
        return;
        if ((paramReadableArray != null) && (paramReadableArray.size() == 2))
          continue;
        throw new JSApplicationIllegalArgumentException("Illegal number of arguments for 'updateHotspot' command");
      }
      while (Build.VERSION.SDK_INT < 21);
      paramReactViewGroup.drawableHotspotChanged(PixelUtil.toPixelFromDIP(paramReadableArray.getDouble(0)), PixelUtil.toPixelFromDIP(paramReadableArray.getDouble(1)));
      return;
    case 2:
    }
    if ((paramReadableArray == null) || (paramReadableArray.size() != 1))
      throw new JSApplicationIllegalArgumentException("Illegal number of arguments for 'setPressed' command");
    paramReactViewGroup.setPressed(paramReadableArray.getBoolean(0));
  }

  public void removeAllViews(ReactViewGroup paramReactViewGroup)
  {
    if (paramReactViewGroup.getRemoveClippedSubviews())
    {
      paramReactViewGroup.removeAllViewsWithSubviewClippingEnabled();
      return;
    }
    paramReactViewGroup.removeAllViews();
  }

  public void removeViewAt(ReactViewGroup paramReactViewGroup, int paramInt)
  {
    if (paramReactViewGroup.getRemoveClippedSubviews())
    {
      View localView = getChildAt(paramReactViewGroup, paramInt);
      if (localView.getParent() != null)
        paramReactViewGroup.removeView(localView);
      paramReactViewGroup.removeViewWithSubviewClippingEnabled(localView);
      return;
    }
    paramReactViewGroup.removeViewAt(paramInt);
  }

  @ReactProp(name="accessible")
  public void setAccessible(ReactViewGroup paramReactViewGroup, boolean paramBoolean)
  {
    paramReactViewGroup.setFocusable(paramBoolean);
  }

  @ReactPropGroup(customType="Color", names={"borderColor", "borderLeftColor", "borderRightColor", "borderTopColor", "borderBottomColor"})
  public void setBorderColor(ReactViewGroup paramReactViewGroup, int paramInt, Integer paramInteger)
  {
    float f2 = (0.0F / 0.0F);
    float f1;
    if (paramInteger == null)
    {
      f1 = (0.0F / 0.0F);
      if (paramInteger != null)
        break label43;
    }
    while (true)
    {
      paramReactViewGroup.setBorderColor(SPACING_TYPES[paramInt], f1, f2);
      return;
      f1 = paramInteger.intValue() & 0xFFFFFF;
      break;
      label43: f2 = paramInteger.intValue() >>> 24;
    }
  }

  @ReactPropGroup(defaultFloat=(0.0F / 0.0F), names={"borderRadius", "borderTopLeftRadius", "borderTopRightRadius", "borderBottomRightRadius", "borderBottomLeftRadius"})
  public void setBorderRadius(ReactViewGroup paramReactViewGroup, int paramInt, float paramFloat)
  {
    float f = paramFloat;
    if (!YogaConstants.isUndefined(paramFloat))
      f = PixelUtil.toPixelFromDIP(paramFloat);
    if (paramInt == 0)
    {
      paramReactViewGroup.setBorderRadius(f);
      return;
    }
    paramReactViewGroup.setBorderRadius(f, paramInt - 1);
  }

  @ReactProp(name="borderStyle")
  public void setBorderStyle(ReactViewGroup paramReactViewGroup, @Nullable String paramString)
  {
    paramReactViewGroup.setBorderStyle(paramString);
  }

  @ReactPropGroup(defaultFloat=(0.0F / 0.0F), names={"borderWidth", "borderLeftWidth", "borderRightWidth", "borderTopWidth", "borderBottomWidth"})
  public void setBorderWidth(ReactViewGroup paramReactViewGroup, int paramInt, float paramFloat)
  {
    float f = paramFloat;
    if (!YogaConstants.isUndefined(paramFloat))
      f = PixelUtil.toPixelFromDIP(paramFloat);
    paramReactViewGroup.setBorderWidth(SPACING_TYPES[paramInt], f);
  }

  @ReactProp(name="collapsable")
  public void setCollapsable(ReactViewGroup paramReactViewGroup, boolean paramBoolean)
  {
  }

  @ReactProp(name="hitSlop")
  public void setHitSlop(ReactViewGroup paramReactViewGroup, @Nullable ReadableMap paramReadableMap)
  {
    int m = 0;
    if (paramReadableMap == null)
    {
      paramReactViewGroup.setHitSlopRect(null);
      return;
    }
    int i;
    int j;
    if (paramReadableMap.hasKey("left"))
    {
      i = (int)PixelUtil.toPixelFromDIP(paramReadableMap.getDouble("left"));
      if (!paramReadableMap.hasKey("top"))
        break label142;
      j = (int)PixelUtil.toPixelFromDIP(paramReadableMap.getDouble("top"));
      label64: if (!paramReadableMap.hasKey("right"))
        break label148;
    }
    label142: label148: for (int k = (int)PixelUtil.toPixelFromDIP(paramReadableMap.getDouble("right")); ; k = 0)
    {
      if (paramReadableMap.hasKey("bottom"))
        m = (int)PixelUtil.toPixelFromDIP(paramReadableMap.getDouble("bottom"));
      paramReactViewGroup.setHitSlopRect(new Rect(i, j, k, m));
      return;
      i = 0;
      break;
      j = 0;
      break label64;
    }
  }

  @ReactProp(name="nativeBackgroundAndroid")
  public void setNativeBackground(ReactViewGroup paramReactViewGroup, @Nullable ReadableMap paramReadableMap)
  {
    if (paramReadableMap == null);
    for (paramReadableMap = null; ; paramReadableMap = ReactDrawableHelper.createDrawableFromJSDescription(paramReactViewGroup.getContext(), paramReadableMap))
    {
      paramReactViewGroup.setTranslucentBackgroundDrawable(paramReadableMap);
      return;
    }
  }

  @ReactProp(name="nativeForegroundAndroid")
  @TargetApi(23)
  public void setNativeForeground(ReactViewGroup paramReactViewGroup, @Nullable ReadableMap paramReadableMap)
  {
    if (paramReadableMap == null);
    for (paramReadableMap = null; ; paramReadableMap = ReactDrawableHelper.createDrawableFromJSDescription(paramReactViewGroup.getContext(), paramReadableMap))
    {
      paramReactViewGroup.setForeground(paramReadableMap);
      return;
    }
  }

  @ReactProp(name="needsOffscreenAlphaCompositing")
  public void setNeedsOffscreenAlphaCompositing(ReactViewGroup paramReactViewGroup, boolean paramBoolean)
  {
    paramReactViewGroup.setNeedsOffscreenAlphaCompositing(paramBoolean);
  }

  @ReactProp(name="overflow")
  public void setOverflow(ReactViewGroup paramReactViewGroup, String paramString)
  {
    paramReactViewGroup.setOverflow(paramString);
  }

  @ReactProp(name="pointerEvents")
  public void setPointerEvents(ReactViewGroup paramReactViewGroup, @Nullable String paramString)
  {
    if (paramString == null)
    {
      paramReactViewGroup.setPointerEvents(PointerEvents.AUTO);
      return;
    }
    paramReactViewGroup.setPointerEvents(PointerEvents.valueOf(paramString.toUpperCase(Locale.US).replace("-", "_")));
  }

  @ReactProp(name="removeClippedSubviews")
  public void setRemoveClippedSubviews(ReactViewGroup paramReactViewGroup, boolean paramBoolean)
  {
    paramReactViewGroup.setRemoveClippedSubviews(paramBoolean);
  }
}

/* Location:           C:\Users\c_jealom1\Documents\Scripts\Android\Fathom_com.brynk.fathom\Fathom_com.brynk.fathom-dex2jar.jar
 * Qualified Name:     com.facebook.react.views.view.ReactViewManager
 * JD-Core Version:    0.6.0
 */
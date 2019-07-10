package com.facebook.react.flat;

import android.graphics.Rect;
import android.os.Build.VERSION;
import com.facebook.react.bridge.JSApplicationIllegalArgumentException;
import com.facebook.react.bridge.ReadableArray;
import com.facebook.react.bridge.ReadableMap;
import com.facebook.react.common.MapBuilder;
import com.facebook.react.uimanager.PixelUtil;
import com.facebook.react.uimanager.PointerEvents;
import com.facebook.react.uimanager.annotations.ReactProp;
import com.facebook.react.views.view.ReactDrawableHelper;
import java.util.Map;
import javax.annotation.Nullable;

public final class RCTViewManager extends FlatViewManager
{
  private static final int CMD_HOTSPOT_UPDATE = 1;
  private static final int CMD_SET_PRESSED = 2;
  static final String REACT_CLASS = "RCTView";
  private static final int[] TMP_INT_ARRAY = new int[2];

  private static PointerEvents parsePointerEvents(@Nullable String paramString)
  {
    int i;
    if (paramString != null)
    {
      i = -1;
      switch (paramString.hashCode())
      {
      default:
      case 3387192:
      case 3005871:
      case -2089141766:
      case -2089112978:
      }
    }
    while (true)
      switch (i)
      {
      default:
        return PointerEvents.AUTO;
        if (!paramString.equals("none"))
          continue;
        i = 0;
        continue;
        if (!paramString.equals("auto"))
          continue;
        i = 1;
        continue;
        if (!paramString.equals("box-none"))
          continue;
        i = 2;
        continue;
        if (!paramString.equals("box-only"))
          continue;
        i = 3;
      case 0:
      case 1:
      case 2:
      case 3:
      }
    return PointerEvents.NONE;
    return PointerEvents.AUTO;
    return PointerEvents.BOX_NONE;
    return PointerEvents.BOX_ONLY;
  }

  public RCTView createShadowNodeInstance()
  {
    return new RCTView();
  }

  public Map<String, Integer> getCommandsMap()
  {
    return MapBuilder.of("hotspotUpdate", Integer.valueOf(1), "setPressed", Integer.valueOf(2));
  }

  public String getName()
  {
    return "RCTView";
  }

  public Class<RCTView> getShadowNodeClass()
  {
    return RCTView.class;
  }

  public void receiveCommand(FlatViewGroup paramFlatViewGroup, int paramInt, @Nullable ReadableArray paramReadableArray)
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
      paramFlatViewGroup.getLocationOnScreen(TMP_INT_ARRAY);
      paramFlatViewGroup.drawableHotspotChanged(PixelUtil.toPixelFromDIP(paramReadableArray.getDouble(0)) - TMP_INT_ARRAY[0], PixelUtil.toPixelFromDIP(paramReadableArray.getDouble(1)) - TMP_INT_ARRAY[1]);
      return;
    case 2:
    }
    if ((paramReadableArray == null) || (paramReadableArray.size() != 1))
      throw new JSApplicationIllegalArgumentException("Illegal number of arguments for 'setPressed' command");
    paramFlatViewGroup.setPressed(paramReadableArray.getBoolean(0));
  }

  @ReactProp(name="hitSlop")
  public void setHitSlop(FlatViewGroup paramFlatViewGroup, @Nullable ReadableMap paramReadableMap)
  {
    if (paramReadableMap == null)
    {
      paramFlatViewGroup.setHitSlopRect(null);
      return;
    }
    paramFlatViewGroup.setHitSlopRect(new Rect((int)PixelUtil.toPixelFromDIP(paramReadableMap.getDouble("left")), (int)PixelUtil.toPixelFromDIP(paramReadableMap.getDouble("top")), (int)PixelUtil.toPixelFromDIP(paramReadableMap.getDouble("right")), (int)PixelUtil.toPixelFromDIP(paramReadableMap.getDouble("bottom"))));
  }

  @ReactProp(name="nativeBackgroundAndroid")
  public void setHotspot(FlatViewGroup paramFlatViewGroup, @Nullable ReadableMap paramReadableMap)
  {
    if (paramReadableMap == null);
    for (paramReadableMap = null; ; paramReadableMap = ReactDrawableHelper.createDrawableFromJSDescription(paramFlatViewGroup.getContext(), paramReadableMap))
    {
      paramFlatViewGroup.setHotspot(paramReadableMap);
      return;
    }
  }

  @ReactProp(name="needsOffscreenAlphaCompositing")
  public void setNeedsOffscreenAlphaCompositing(FlatViewGroup paramFlatViewGroup, boolean paramBoolean)
  {
    paramFlatViewGroup.setNeedsOffscreenAlphaCompositing(paramBoolean);
  }

  @ReactProp(name="pointerEvents")
  public void setPointerEvents(FlatViewGroup paramFlatViewGroup, @Nullable String paramString)
  {
    paramFlatViewGroup.setPointerEvents(parsePointerEvents(paramString));
  }

  @ReactProp(name="removeClippedSubviews")
  public void setRemoveClippedSubviews(FlatViewGroup paramFlatViewGroup, boolean paramBoolean)
  {
    paramFlatViewGroup.setRemoveClippedSubviews(paramBoolean);
  }
}

/* Location:           C:\Users\c_jealom1\Documents\Scripts\Android\Fathom_com.brynk.fathom\Fathom_com.brynk.fathom-dex2jar.jar
 * Qualified Name:     com.facebook.react.flat.RCTViewManager
 * JD-Core Version:    0.6.0
 */
package com.facebook.react.uimanager;

import com.facebook.react.bridge.ReadableMap;
import java.util.Arrays;
import java.util.HashSet;

public class ViewProps
{
  public static final String ALIGN_CONTENT = "alignContent";
  public static final String ALIGN_ITEMS = "alignItems";
  public static final String ALIGN_SELF = "alignSelf";
  public static final String ALLOW_FONT_SCALING = "allowFontScaling";
  public static final String ASPECT_RATIO = "aspectRatio";
  public static final String BACKGROUND_COLOR = "backgroundColor";
  public static final String BORDER_BOTTOM_COLOR = "borderBottomColor";
  public static final String BORDER_BOTTOM_LEFT_RADIUS = "borderBottomLeftRadius";
  public static final String BORDER_BOTTOM_RIGHT_RADIUS = "borderBottomRightRadius";
  public static final String BORDER_BOTTOM_WIDTH = "borderBottomWidth";
  public static final String BORDER_COLOR = "borderColor";
  public static final String BORDER_LEFT_COLOR = "borderLeftColor";
  public static final String BORDER_LEFT_WIDTH = "borderLeftWidth";
  public static final String BORDER_RADIUS = "borderRadius";
  public static final String BORDER_RIGHT_COLOR = "borderRightColor";
  public static final String BORDER_RIGHT_WIDTH = "borderRightWidth";
  public static final int[] BORDER_SPACING_TYPES = { 8, 4, 5, 1, 3 };
  public static final String BORDER_TOP_COLOR = "borderTopColor";
  public static final String BORDER_TOP_LEFT_RADIUS = "borderTopLeftRadius";
  public static final String BORDER_TOP_RIGHT_RADIUS = "borderTopRightRadius";
  public static final String BORDER_TOP_WIDTH = "borderTopWidth";
  public static final String BORDER_WIDTH = "borderWidth";
  public static final String BOTTOM = "bottom";
  public static final String COLLAPSABLE = "collapsable";
  public static final String COLOR = "color";
  public static final String DISPLAY = "display";
  public static final String ELLIPSIZE_MODE = "ellipsizeMode";
  public static final String ENABLED = "enabled";
  public static final String FLEX = "flex";
  public static final String FLEX_BASIS = "flexBasis";
  public static final String FLEX_DIRECTION = "flexDirection";
  public static final String FLEX_GROW = "flexGrow";
  public static final String FLEX_SHRINK = "flexShrink";
  public static final String FLEX_WRAP = "flexWrap";
  public static final String FONT_FAMILY = "fontFamily";
  public static final String FONT_SIZE = "fontSize";
  public static final String FONT_STYLE = "fontStyle";
  public static final String FONT_WEIGHT = "fontWeight";
  public static final String HEIGHT = "height";
  public static final String INCLUDE_FONT_PADDING = "includeFontPadding";
  public static final String JUSTIFY_CONTENT = "justifyContent";
  private static final HashSet<String> LAYOUT_ONLY_PROPS;
  public static final String LEFT = "left";
  public static final String LINE_HEIGHT = "lineHeight";
  public static final String MARGIN = "margin";
  public static final String MARGIN_BOTTOM = "marginBottom";
  public static final String MARGIN_HORIZONTAL = "marginHorizontal";
  public static final String MARGIN_LEFT = "marginLeft";
  public static final String MARGIN_RIGHT = "marginRight";
  public static final String MARGIN_TOP = "marginTop";
  public static final String MARGIN_VERTICAL = "marginVertical";
  public static final String MAX_HEIGHT = "maxHeight";
  public static final String MAX_WIDTH = "maxWidth";
  public static final String MIN_HEIGHT = "minHeight";
  public static final String MIN_WIDTH = "minWidth";
  public static final String NEEDS_OFFSCREEN_ALPHA_COMPOSITING = "needsOffscreenAlphaCompositing";
  public static final String NUMBER_OF_LINES = "numberOfLines";
  public static final String ON = "on";
  public static final String OPACITY = "opacity";
  public static final String OVERFLOW = "overflow";
  public static final String PADDING = "padding";
  public static final String PADDING_BOTTOM = "paddingBottom";
  public static final String PADDING_HORIZONTAL = "paddingHorizontal";
  public static final String PADDING_LEFT = "paddingLeft";
  public static final int[] PADDING_MARGIN_SPACING_TYPES = { 8, 7, 6, 4, 5, 1, 3 };
  public static final String PADDING_RIGHT = "paddingRight";
  public static final String PADDING_TOP = "paddingTop";
  public static final String PADDING_VERTICAL = "paddingVertical";
  public static final String POINTER_EVENTS = "pointerEvents";
  public static final String POSITION = "position";
  public static final int[] POSITION_SPACING_TYPES = { 4, 5, 1, 3 };
  public static final String RESIZE_METHOD = "resizeMethod";
  public static final String RESIZE_MODE = "resizeMode";
  public static final String RIGHT = "right";
  public static final String TEXT_ALIGN = "textAlign";
  public static final String TEXT_ALIGN_VERTICAL = "textAlignVertical";
  public static final String TEXT_BREAK_STRATEGY = "textBreakStrategy";
  public static final String TEXT_DECORATION_LINE = "textDecorationLine";
  public static final String TOP = "top";
  public static final String VIEW_CLASS_NAME = "RCTView";
  public static final String WIDTH = "width";
  public static boolean sIsOptimizationsEnabled;

  static
  {
    LAYOUT_ONLY_PROPS = new HashSet(Arrays.asList(new String[] { "alignSelf", "alignItems", "collapsable", "flex", "flexBasis", "flexDirection", "flexGrow", "flexShrink", "flexWrap", "justifyContent", "overflow", "alignContent", "display", "position", "right", "top", "bottom", "left", "width", "height", "minWidth", "maxWidth", "minHeight", "maxHeight", "margin", "marginVertical", "marginHorizontal", "marginLeft", "marginRight", "marginTop", "marginBottom", "padding", "paddingVertical", "paddingHorizontal", "paddingLeft", "paddingRight", "paddingTop", "paddingBottom" }));
  }

  public static boolean isLayoutOnly(ReadableMap paramReadableMap, String paramString)
  {
    int j = 0;
    if (LAYOUT_ONLY_PROPS.contains(paramString));
    while (true)
    {
      return true;
      if ("pointerEvents".equals(paramString))
      {
        paramReadableMap = paramReadableMap.getString(paramString);
        if (("auto".equals(paramReadableMap)) || ("box-none".equals(paramReadableMap)))
          j = 1;
        return j;
      }
      if (!sIsOptimizationsEnabled)
        break;
      int i = -1;
      switch (paramString.hashCode())
      {
      default:
      case -1267206133:
      case 1287124693:
      case 1349188574:
      case 722830999:
      case -242276144:
      case -1989576717:
      case -1470826662:
      case -1308858324:
      case 741115130:
      case -223992013:
      case -1452542531:
      case -1971292586:
      case -1290574193:
      case 1288688105:
      case 529642498:
      }
      while (true)
        switch (i)
        {
        case 13:
        case 14:
        default:
          return false;
          if (!paramString.equals("opacity"))
            continue;
          i = 0;
          continue;
          if (!paramString.equals("backgroundColor"))
            continue;
          i = 1;
          continue;
          if (!paramString.equals("borderRadius"))
            continue;
          i = 2;
          continue;
          if (!paramString.equals("borderColor"))
            continue;
          i = 3;
          continue;
          if (!paramString.equals("borderLeftColor"))
            continue;
          i = 4;
          continue;
          if (!paramString.equals("borderRightColor"))
            continue;
          i = 5;
          continue;
          if (!paramString.equals("borderTopColor"))
            continue;
          i = 6;
          continue;
          if (!paramString.equals("borderBottomColor"))
            continue;
          i = 7;
          continue;
          if (!paramString.equals("borderWidth"))
            continue;
          i = 8;
          continue;
          if (!paramString.equals("borderLeftWidth"))
            continue;
          i = 9;
          continue;
          if (!paramString.equals("borderTopWidth"))
            continue;
          i = 10;
          continue;
          if (!paramString.equals("borderRightWidth"))
            continue;
          i = 11;
          continue;
          if (!paramString.equals("borderBottomWidth"))
            continue;
          i = 12;
          continue;
          if (!paramString.equals("onLayout"))
            continue;
          i = 13;
          continue;
          if (!paramString.equals("overflow"))
            continue;
          i = 14;
        case 0:
        case 1:
        case 2:
        case 3:
        case 4:
        case 5:
        case 6:
        case 7:
        case 8:
        case 9:
        case 10:
        case 11:
        case 12:
        }
      if (paramReadableMap.getDouble("opacity") != 1.0D)
      {
        return false;
        if (paramReadableMap.getInt("backgroundColor") != 0)
        {
          return false;
          if ((paramReadableMap.hasKey("backgroundColor")) && (paramReadableMap.getInt("backgroundColor") != 0))
            return false;
          if ((paramReadableMap.hasKey("borderWidth")) && (paramReadableMap.getDouble("borderWidth") != 0.0D))
          {
            return false;
            if (paramReadableMap.getInt("borderColor") != 0)
            {
              return false;
              if (paramReadableMap.getInt("borderLeftColor") != 0)
              {
                return false;
                if (paramReadableMap.getInt("borderRightColor") != 0)
                {
                  return false;
                  if (paramReadableMap.getInt("borderTopColor") != 0)
                  {
                    return false;
                    if (paramReadableMap.getInt("borderBottomColor") != 0)
                    {
                      return false;
                      if (paramReadableMap.getDouble("borderWidth") != 0.0D)
                      {
                        return false;
                        if (paramReadableMap.getDouble("borderLeftWidth") != 0.0D)
                        {
                          return false;
                          if (paramReadableMap.getDouble("borderTopWidth") != 0.0D)
                          {
                            return false;
                            if (paramReadableMap.getDouble("borderRightWidth") != 0.0D)
                            {
                              return false;
                              if (paramReadableMap.getDouble("borderBottomWidth") != 0.0D)
                                return false;
                            }
                          }
                        }
                      }
                    }
                  }
                }
              }
            }
          }
        }
      }
    }
    return false;
  }
}

/* Location:           C:\Users\c_jealom1\Documents\Scripts\Android\Fathom_com.brynk.fathom\Fathom_com.brynk.fathom-dex2jar.jar
 * Qualified Name:     com.facebook.react.uimanager.ViewProps
 * JD-Core Version:    0.6.0
 */
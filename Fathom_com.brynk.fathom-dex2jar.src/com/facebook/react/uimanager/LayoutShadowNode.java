package com.facebook.react.uimanager;

import com.facebook.react.bridge.Dynamic;
import com.facebook.react.bridge.JSApplicationIllegalArgumentException;
import com.facebook.react.bridge.ReadableType;
import com.facebook.react.uimanager.annotations.ReactProp;
import com.facebook.react.uimanager.annotations.ReactPropGroup;
import com.facebook.yoga.YogaAlign;
import com.facebook.yoga.YogaDisplay;
import com.facebook.yoga.YogaFlexDirection;
import com.facebook.yoga.YogaJustify;
import com.facebook.yoga.YogaOverflow;
import com.facebook.yoga.YogaPositionType;
import com.facebook.yoga.YogaUnit;
import com.facebook.yoga.YogaWrap;
import javax.annotation.Nullable;

public class LayoutShadowNode extends ReactShadowNodeImpl
{
  private final MutableYogaValue mTempYogaValue = new MutableYogaValue(null);

  @ReactProp(name="alignContent")
  public void setAlignContent(@Nullable String paramString)
  {
    if (isVirtual())
      return;
    if (paramString == null)
    {
      setAlignContent(YogaAlign.FLEX_START);
      return;
    }
    int i = -1;
    switch (paramString.hashCode())
    {
    default:
    case 3005871:
    case -46581362:
    case -1364013995:
    case 1742952711:
    case -1881872635:
    case -1720785339:
    case 441309761:
    case 1937124468:
    }
    while (true)
      switch (i)
      {
      default:
        throw new JSApplicationIllegalArgumentException("invalid value for alignContent: " + paramString);
        if (!paramString.equals("auto"))
          continue;
        i = 0;
        continue;
        if (!paramString.equals("flex-start"))
          continue;
        i = 1;
        continue;
        if (!paramString.equals("center"))
          continue;
        i = 2;
        continue;
        if (!paramString.equals("flex-end"))
          continue;
        i = 3;
        continue;
        if (!paramString.equals("stretch"))
          continue;
        i = 4;
        continue;
        if (!paramString.equals("baseline"))
          continue;
        i = 5;
        continue;
        if (!paramString.equals("space-between"))
          continue;
        i = 6;
        continue;
        if (!paramString.equals("space-around"))
          continue;
        i = 7;
      case 0:
      case 1:
      case 2:
      case 3:
      case 4:
      case 5:
      case 6:
      case 7:
      }
    setAlignContent(YogaAlign.AUTO);
    return;
    setAlignContent(YogaAlign.FLEX_START);
    return;
    setAlignContent(YogaAlign.CENTER);
    return;
    setAlignContent(YogaAlign.FLEX_END);
    return;
    setAlignContent(YogaAlign.STRETCH);
    return;
    setAlignContent(YogaAlign.BASELINE);
    return;
    setAlignContent(YogaAlign.SPACE_BETWEEN);
    return;
    setAlignContent(YogaAlign.SPACE_AROUND);
  }

  @ReactProp(name="alignItems")
  public void setAlignItems(@Nullable String paramString)
  {
    if (isVirtual())
      return;
    if (paramString == null)
    {
      setAlignItems(YogaAlign.STRETCH);
      return;
    }
    int i = -1;
    switch (paramString.hashCode())
    {
    default:
    case 3005871:
    case -46581362:
    case -1364013995:
    case 1742952711:
    case -1881872635:
    case -1720785339:
    case 441309761:
    case 1937124468:
    }
    while (true)
      switch (i)
      {
      default:
        throw new JSApplicationIllegalArgumentException("invalid value for alignItems: " + paramString);
        if (!paramString.equals("auto"))
          continue;
        i = 0;
        continue;
        if (!paramString.equals("flex-start"))
          continue;
        i = 1;
        continue;
        if (!paramString.equals("center"))
          continue;
        i = 2;
        continue;
        if (!paramString.equals("flex-end"))
          continue;
        i = 3;
        continue;
        if (!paramString.equals("stretch"))
          continue;
        i = 4;
        continue;
        if (!paramString.equals("baseline"))
          continue;
        i = 5;
        continue;
        if (!paramString.equals("space-between"))
          continue;
        i = 6;
        continue;
        if (!paramString.equals("space-around"))
          continue;
        i = 7;
      case 0:
      case 1:
      case 2:
      case 3:
      case 4:
      case 5:
      case 6:
      case 7:
      }
    setAlignItems(YogaAlign.AUTO);
    return;
    setAlignItems(YogaAlign.FLEX_START);
    return;
    setAlignItems(YogaAlign.CENTER);
    return;
    setAlignItems(YogaAlign.FLEX_END);
    return;
    setAlignItems(YogaAlign.STRETCH);
    return;
    setAlignItems(YogaAlign.BASELINE);
    return;
    setAlignItems(YogaAlign.SPACE_BETWEEN);
    return;
    setAlignItems(YogaAlign.SPACE_AROUND);
  }

  @ReactProp(name="alignSelf")
  public void setAlignSelf(@Nullable String paramString)
  {
    if (isVirtual())
      return;
    if (paramString == null)
    {
      setAlignSelf(YogaAlign.AUTO);
      return;
    }
    int i = -1;
    switch (paramString.hashCode())
    {
    default:
    case 3005871:
    case -46581362:
    case -1364013995:
    case 1742952711:
    case -1881872635:
    case -1720785339:
    case 441309761:
    case 1937124468:
    }
    while (true)
      switch (i)
      {
      default:
        throw new JSApplicationIllegalArgumentException("invalid value for alignSelf: " + paramString);
        if (!paramString.equals("auto"))
          continue;
        i = 0;
        continue;
        if (!paramString.equals("flex-start"))
          continue;
        i = 1;
        continue;
        if (!paramString.equals("center"))
          continue;
        i = 2;
        continue;
        if (!paramString.equals("flex-end"))
          continue;
        i = 3;
        continue;
        if (!paramString.equals("stretch"))
          continue;
        i = 4;
        continue;
        if (!paramString.equals("baseline"))
          continue;
        i = 5;
        continue;
        if (!paramString.equals("space-between"))
          continue;
        i = 6;
        continue;
        if (!paramString.equals("space-around"))
          continue;
        i = 7;
      case 0:
      case 1:
      case 2:
      case 3:
      case 4:
      case 5:
      case 6:
      case 7:
      }
    setAlignSelf(YogaAlign.AUTO);
    return;
    setAlignSelf(YogaAlign.FLEX_START);
    return;
    setAlignSelf(YogaAlign.CENTER);
    return;
    setAlignSelf(YogaAlign.FLEX_END);
    return;
    setAlignSelf(YogaAlign.STRETCH);
    return;
    setAlignSelf(YogaAlign.BASELINE);
    return;
    setAlignSelf(YogaAlign.SPACE_BETWEEN);
    return;
    setAlignSelf(YogaAlign.SPACE_AROUND);
  }

  @ReactProp(defaultFloat=(0.0F / 0.0F), name="aspectRatio")
  public void setAspectRatio(float paramFloat)
  {
    setStyleAspectRatio(paramFloat);
  }

  @ReactPropGroup(defaultFloat=(0.0F / 0.0F), names={"borderWidth", "borderLeftWidth", "borderRightWidth", "borderTopWidth", "borderBottomWidth"})
  public void setBorderWidths(int paramInt, float paramFloat)
  {
    if (isVirtual())
      return;
    setBorder(ViewProps.BORDER_SPACING_TYPES[paramInt], PixelUtil.toPixelFromDIP(paramFloat));
  }

  @ReactProp(name="display")
  public void setDisplay(@Nullable String paramString)
  {
    if (isVirtual())
      return;
    if (paramString == null)
    {
      setDisplay(YogaDisplay.FLEX);
      return;
    }
    int i = -1;
    switch (paramString.hashCode())
    {
    default:
    case 3145721:
    case 3387192:
    }
    while (true)
      switch (i)
      {
      default:
        throw new JSApplicationIllegalArgumentException("invalid value for display: " + paramString);
        if (!paramString.equals("flex"))
          continue;
        i = 0;
        continue;
        if (!paramString.equals("none"))
          continue;
        i = 1;
      case 0:
      case 1:
      }
    setDisplay(YogaDisplay.FLEX);
    return;
    setDisplay(YogaDisplay.NONE);
  }

  @ReactProp(defaultFloat=0.0F, name="flex")
  public void setFlex(float paramFloat)
  {
    if (isVirtual())
      return;
    super.setFlex(paramFloat);
  }

  @ReactProp(name="flexBasis")
  public void setFlexBasis(Dynamic paramDynamic)
  {
    if (isVirtual())
      return;
    this.mTempYogaValue.setFromDynamic(paramDynamic);
    switch (1.$SwitchMap$com$facebook$yoga$YogaUnit[this.mTempYogaValue.unit.ordinal()])
    {
    default:
    case 1:
    case 2:
    case 3:
    case 4:
    }
    while (true)
    {
      paramDynamic.recycle();
      return;
      setFlexBasis(this.mTempYogaValue.value);
      continue;
      setFlexBasisAuto();
      continue;
      setFlexBasisPercent(this.mTempYogaValue.value);
    }
  }

  @ReactProp(name="flexDirection")
  public void setFlexDirection(@Nullable String paramString)
  {
    if (isVirtual())
      return;
    if (paramString == null)
    {
      setFlexDirection(YogaFlexDirection.COLUMN);
      return;
    }
    int i = -1;
    switch (paramString.hashCode())
    {
    default:
    case -1354837162:
    case 1272730475:
    case 113114:
    case -1448970769:
    }
    while (true)
      switch (i)
      {
      default:
        throw new JSApplicationIllegalArgumentException("invalid value for flexDirection: " + paramString);
        if (!paramString.equals("column"))
          continue;
        i = 0;
        continue;
        if (!paramString.equals("column-reverse"))
          continue;
        i = 1;
        continue;
        if (!paramString.equals("row"))
          continue;
        i = 2;
        continue;
        if (!paramString.equals("row-reverse"))
          continue;
        i = 3;
      case 0:
      case 1:
      case 2:
      case 3:
      }
    setFlexDirection(YogaFlexDirection.COLUMN);
    return;
    setFlexDirection(YogaFlexDirection.COLUMN_REVERSE);
    return;
    setFlexDirection(YogaFlexDirection.ROW);
    return;
    setFlexDirection(YogaFlexDirection.ROW_REVERSE);
  }

  @ReactProp(defaultFloat=0.0F, name="flexGrow")
  public void setFlexGrow(float paramFloat)
  {
    if (isVirtual())
      return;
    super.setFlexGrow(paramFloat);
  }

  @ReactProp(defaultFloat=0.0F, name="flexShrink")
  public void setFlexShrink(float paramFloat)
  {
    if (isVirtual())
      return;
    super.setFlexShrink(paramFloat);
  }

  @ReactProp(name="flexWrap")
  public void setFlexWrap(@Nullable String paramString)
  {
    if (isVirtual())
      return;
    if (paramString == null)
    {
      setFlexWrap(YogaWrap.NO_WRAP);
      return;
    }
    int i = -1;
    switch (paramString.hashCode())
    {
    default:
    case -1039592053:
    case 3657802:
    }
    while (true)
      switch (i)
      {
      default:
        throw new JSApplicationIllegalArgumentException("invalid value for flexWrap: " + paramString);
        if (!paramString.equals("nowrap"))
          continue;
        i = 0;
        continue;
        if (!paramString.equals("wrap"))
          continue;
        i = 1;
      case 0:
      case 1:
      }
    setFlexWrap(YogaWrap.NO_WRAP);
    return;
    setFlexWrap(YogaWrap.WRAP);
  }

  @ReactProp(name="height")
  public void setHeight(Dynamic paramDynamic)
  {
    if (isVirtual())
      return;
    this.mTempYogaValue.setFromDynamic(paramDynamic);
    switch (1.$SwitchMap$com$facebook$yoga$YogaUnit[this.mTempYogaValue.unit.ordinal()])
    {
    default:
    case 1:
    case 2:
    case 3:
    case 4:
    }
    while (true)
    {
      paramDynamic.recycle();
      return;
      setStyleHeight(this.mTempYogaValue.value);
      continue;
      setStyleHeightAuto();
      continue;
      setStyleHeightPercent(this.mTempYogaValue.value);
    }
  }

  @ReactProp(name="justifyContent")
  public void setJustifyContent(@Nullable String paramString)
  {
    if (isVirtual())
      return;
    if (paramString == null)
    {
      setJustifyContent(YogaJustify.FLEX_START);
      return;
    }
    int i = -1;
    switch (paramString.hashCode())
    {
    default:
    case -46581362:
    case -1364013995:
    case 1742952711:
    case 441309761:
    case 1937124468:
    }
    while (true)
      switch (i)
      {
      default:
        throw new JSApplicationIllegalArgumentException("invalid value for justifyContent: " + paramString);
        if (!paramString.equals("flex-start"))
          continue;
        i = 0;
        continue;
        if (!paramString.equals("center"))
          continue;
        i = 1;
        continue;
        if (!paramString.equals("flex-end"))
          continue;
        i = 2;
        continue;
        if (!paramString.equals("space-between"))
          continue;
        i = 3;
        continue;
        if (!paramString.equals("space-around"))
          continue;
        i = 4;
      case 0:
      case 1:
      case 2:
      case 3:
      case 4:
      }
    setJustifyContent(YogaJustify.FLEX_START);
    return;
    setJustifyContent(YogaJustify.CENTER);
    return;
    setJustifyContent(YogaJustify.FLEX_END);
    return;
    setJustifyContent(YogaJustify.SPACE_BETWEEN);
    return;
    setJustifyContent(YogaJustify.SPACE_AROUND);
  }

  @ReactPropGroup(names={"margin", "marginVertical", "marginHorizontal", "marginLeft", "marginRight", "marginTop", "marginBottom"})
  public void setMargins(int paramInt, Dynamic paramDynamic)
  {
    if (isVirtual())
      return;
    this.mTempYogaValue.setFromDynamic(paramDynamic);
    switch (1.$SwitchMap$com$facebook$yoga$YogaUnit[this.mTempYogaValue.unit.ordinal()])
    {
    default:
    case 1:
    case 2:
    case 3:
    case 4:
    }
    while (true)
    {
      paramDynamic.recycle();
      return;
      setMargin(ViewProps.PADDING_MARGIN_SPACING_TYPES[paramInt], this.mTempYogaValue.value);
      continue;
      setMarginAuto(ViewProps.PADDING_MARGIN_SPACING_TYPES[paramInt]);
      continue;
      setMarginPercent(ViewProps.PADDING_MARGIN_SPACING_TYPES[paramInt], this.mTempYogaValue.value);
    }
  }

  @ReactProp(name="maxHeight")
  public void setMaxHeight(Dynamic paramDynamic)
  {
    if (isVirtual())
      return;
    this.mTempYogaValue.setFromDynamic(paramDynamic);
    switch (1.$SwitchMap$com$facebook$yoga$YogaUnit[this.mTempYogaValue.unit.ordinal()])
    {
    case 3:
    default:
    case 1:
    case 2:
    case 4:
    }
    while (true)
    {
      paramDynamic.recycle();
      return;
      setStyleMaxHeight(this.mTempYogaValue.value);
      continue;
      setStyleMaxHeightPercent(this.mTempYogaValue.value);
    }
  }

  @ReactProp(name="maxWidth")
  public void setMaxWidth(Dynamic paramDynamic)
  {
    if (isVirtual())
      return;
    this.mTempYogaValue.setFromDynamic(paramDynamic);
    switch (1.$SwitchMap$com$facebook$yoga$YogaUnit[this.mTempYogaValue.unit.ordinal()])
    {
    case 3:
    default:
    case 1:
    case 2:
    case 4:
    }
    while (true)
    {
      paramDynamic.recycle();
      return;
      setStyleMaxWidth(this.mTempYogaValue.value);
      continue;
      setStyleMaxWidthPercent(this.mTempYogaValue.value);
    }
  }

  @ReactProp(name="minHeight")
  public void setMinHeight(Dynamic paramDynamic)
  {
    if (isVirtual())
      return;
    this.mTempYogaValue.setFromDynamic(paramDynamic);
    switch (1.$SwitchMap$com$facebook$yoga$YogaUnit[this.mTempYogaValue.unit.ordinal()])
    {
    case 3:
    default:
    case 1:
    case 2:
    case 4:
    }
    while (true)
    {
      paramDynamic.recycle();
      return;
      setStyleMinHeight(this.mTempYogaValue.value);
      continue;
      setStyleMinHeightPercent(this.mTempYogaValue.value);
    }
  }

  @ReactProp(name="minWidth")
  public void setMinWidth(Dynamic paramDynamic)
  {
    if (isVirtual())
      return;
    this.mTempYogaValue.setFromDynamic(paramDynamic);
    switch (1.$SwitchMap$com$facebook$yoga$YogaUnit[this.mTempYogaValue.unit.ordinal()])
    {
    case 3:
    default:
    case 1:
    case 2:
    case 4:
    }
    while (true)
    {
      paramDynamic.recycle();
      return;
      setStyleMinWidth(this.mTempYogaValue.value);
      continue;
      setStyleMinWidthPercent(this.mTempYogaValue.value);
    }
  }

  @ReactProp(name="overflow")
  public void setOverflow(@Nullable String paramString)
  {
    if (isVirtual())
      return;
    if (paramString == null)
    {
      setOverflow(YogaOverflow.VISIBLE);
      return;
    }
    int i = -1;
    switch (paramString.hashCode())
    {
    default:
    case 466743410:
    case -1217487446:
    case -907680051:
    }
    while (true)
      switch (i)
      {
      default:
        throw new JSApplicationIllegalArgumentException("invalid value for overflow: " + paramString);
        if (!paramString.equals("visible"))
          continue;
        i = 0;
        continue;
        if (!paramString.equals("hidden"))
          continue;
        i = 1;
        continue;
        if (!paramString.equals("scroll"))
          continue;
        i = 2;
      case 0:
      case 1:
      case 2:
      }
    setOverflow(YogaOverflow.VISIBLE);
    return;
    setOverflow(YogaOverflow.HIDDEN);
    return;
    setOverflow(YogaOverflow.SCROLL);
  }

  @ReactPropGroup(names={"padding", "paddingVertical", "paddingHorizontal", "paddingLeft", "paddingRight", "paddingTop", "paddingBottom"})
  public void setPaddings(int paramInt, Dynamic paramDynamic)
  {
    if (isVirtual())
      return;
    this.mTempYogaValue.setFromDynamic(paramDynamic);
    switch (1.$SwitchMap$com$facebook$yoga$YogaUnit[this.mTempYogaValue.unit.ordinal()])
    {
    case 3:
    default:
    case 1:
    case 2:
    case 4:
    }
    while (true)
    {
      paramDynamic.recycle();
      return;
      setPadding(ViewProps.PADDING_MARGIN_SPACING_TYPES[paramInt], this.mTempYogaValue.value);
      continue;
      setPaddingPercent(ViewProps.PADDING_MARGIN_SPACING_TYPES[paramInt], this.mTempYogaValue.value);
    }
  }

  @ReactProp(name="position")
  public void setPosition(@Nullable String paramString)
  {
    if (isVirtual())
      return;
    if (paramString == null)
    {
      setPositionType(YogaPositionType.RELATIVE);
      return;
    }
    int i = -1;
    switch (paramString.hashCode())
    {
    default:
    case -554435892:
    case 1728122231:
    }
    while (true)
      switch (i)
      {
      default:
        throw new JSApplicationIllegalArgumentException("invalid value for position: " + paramString);
        if (!paramString.equals("relative"))
          continue;
        i = 0;
        continue;
        if (!paramString.equals("absolute"))
          continue;
        i = 1;
      case 0:
      case 1:
      }
    setPositionType(YogaPositionType.RELATIVE);
    return;
    setPositionType(YogaPositionType.ABSOLUTE);
  }

  @ReactPropGroup(names={"left", "right", "top", "bottom"})
  public void setPositionValues(int paramInt, Dynamic paramDynamic)
  {
    if (isVirtual())
      return;
    this.mTempYogaValue.setFromDynamic(paramDynamic);
    switch (1.$SwitchMap$com$facebook$yoga$YogaUnit[this.mTempYogaValue.unit.ordinal()])
    {
    case 3:
    default:
    case 1:
    case 2:
    case 4:
    }
    while (true)
    {
      paramDynamic.recycle();
      return;
      setPosition(ViewProps.POSITION_SPACING_TYPES[paramInt], this.mTempYogaValue.value);
      continue;
      setPositionPercent(ViewProps.POSITION_SPACING_TYPES[paramInt], this.mTempYogaValue.value);
    }
  }

  @ReactProp(name="onLayout")
  public void setShouldNotifyOnLayout(boolean paramBoolean)
  {
    super.setShouldNotifyOnLayout(paramBoolean);
  }

  @ReactProp(name="width")
  public void setWidth(Dynamic paramDynamic)
  {
    if (isVirtual())
      return;
    this.mTempYogaValue.setFromDynamic(paramDynamic);
    switch (1.$SwitchMap$com$facebook$yoga$YogaUnit[this.mTempYogaValue.unit.ordinal()])
    {
    default:
    case 1:
    case 2:
    case 3:
    case 4:
    }
    while (true)
    {
      paramDynamic.recycle();
      return;
      setStyleWidth(this.mTempYogaValue.value);
      continue;
      setStyleWidthAuto();
      continue;
      setStyleWidthPercent(this.mTempYogaValue.value);
    }
  }

  private static class MutableYogaValue
  {
    YogaUnit unit;
    float value;

    void setFromDynamic(Dynamic paramDynamic)
    {
      if (paramDynamic.isNull())
      {
        this.unit = YogaUnit.UNDEFINED;
        this.value = (0.0F / 0.0F);
        return;
      }
      if (paramDynamic.getType() == ReadableType.String)
      {
        paramDynamic = paramDynamic.asString();
        if (paramDynamic.equals("auto"))
        {
          this.unit = YogaUnit.AUTO;
          this.value = (0.0F / 0.0F);
          return;
        }
        if (paramDynamic.endsWith("%"))
        {
          this.unit = YogaUnit.PERCENT;
          this.value = Float.parseFloat(paramDynamic.substring(0, paramDynamic.length() - 1));
          return;
        }
        throw new IllegalArgumentException("Unknown value: " + paramDynamic);
      }
      this.unit = YogaUnit.POINT;
      this.value = PixelUtil.toPixelFromDIP(paramDynamic.asDouble());
    }
  }
}

/* Location:           C:\Users\c_jealom1\Documents\Scripts\Android\Fathom_com.brynk.fathom\Fathom_com.brynk.fathom-dex2jar.jar
 * Qualified Name:     com.facebook.react.uimanager.LayoutShadowNode
 * JD-Core Version:    0.6.0
 */
package com.facebook.react.views.scroll;

import android.view.View;
import com.facebook.react.bridge.ReadableArray;
import com.facebook.react.common.MapBuilder;
import com.facebook.react.common.MapBuilder.Builder;
import com.facebook.react.module.annotations.ReactModule;
import com.facebook.react.uimanager.PixelUtil;
import com.facebook.react.uimanager.ThemedReactContext;
import com.facebook.react.uimanager.ViewGroupManager;
import com.facebook.react.uimanager.annotations.ReactProp;
import com.facebook.react.uimanager.annotations.ReactPropGroup;
import com.facebook.yoga.YogaConstants;
import java.util.Map;
import javax.annotation.Nullable;

@ReactModule(name="RCTScrollView")
public class ReactScrollViewManager extends ViewGroupManager<ReactScrollView>
  implements ReactScrollViewCommandHelper.ScrollCommandHandler<ReactScrollView>
{
  protected static final String REACT_CLASS = "RCTScrollView";
  private static final int[] SPACING_TYPES = { 8, 0, 2, 1, 3 };

  @Nullable
  private FpsListener mFpsListener = null;

  public ReactScrollViewManager()
  {
    this(null);
  }

  public ReactScrollViewManager(@Nullable FpsListener paramFpsListener)
  {
    this.mFpsListener = paramFpsListener;
  }

  public static Map createExportedCustomDirectEventTypeConstants()
  {
    return MapBuilder.builder().put(ScrollEventType.SCROLL.getJSEventName(), MapBuilder.of("registrationName", "onScroll")).put(ScrollEventType.BEGIN_DRAG.getJSEventName(), MapBuilder.of("registrationName", "onScrollBeginDrag")).put(ScrollEventType.END_DRAG.getJSEventName(), MapBuilder.of("registrationName", "onScrollEndDrag")).put(ScrollEventType.MOMENTUM_BEGIN.getJSEventName(), MapBuilder.of("registrationName", "onMomentumScrollBegin")).put(ScrollEventType.MOMENTUM_END.getJSEventName(), MapBuilder.of("registrationName", "onMomentumScrollEnd")).build();
  }

  public ReactScrollView createViewInstance(ThemedReactContext paramThemedReactContext)
  {
    return new ReactScrollView(paramThemedReactContext, this.mFpsListener);
  }

  public void flashScrollIndicators(ReactScrollView paramReactScrollView)
  {
    paramReactScrollView.flashScrollIndicators();
  }

  @Nullable
  public Map<String, Integer> getCommandsMap()
  {
    return ReactScrollViewCommandHelper.getCommandsMap();
  }

  @Nullable
  public Map getExportedCustomDirectEventTypeConstants()
  {
    return createExportedCustomDirectEventTypeConstants();
  }

  public String getName()
  {
    return "RCTScrollView";
  }

  public void receiveCommand(ReactScrollView paramReactScrollView, int paramInt, @Nullable ReadableArray paramReadableArray)
  {
    ReactScrollViewCommandHelper.receiveCommand(this, paramReactScrollView, paramInt, paramReadableArray);
  }

  public void scrollTo(ReactScrollView paramReactScrollView, ReactScrollViewCommandHelper.ScrollToCommandData paramScrollToCommandData)
  {
    if (paramScrollToCommandData.mAnimated)
    {
      paramReactScrollView.smoothScrollTo(paramScrollToCommandData.mDestX, paramScrollToCommandData.mDestY);
      return;
    }
    paramReactScrollView.scrollTo(paramScrollToCommandData.mDestX, paramScrollToCommandData.mDestY);
  }

  public void scrollToEnd(ReactScrollView paramReactScrollView, ReactScrollViewCommandHelper.ScrollToEndCommandData paramScrollToEndCommandData)
  {
    int i = paramReactScrollView.getChildAt(0).getHeight() + paramReactScrollView.getPaddingBottom();
    if (paramScrollToEndCommandData.mAnimated)
    {
      paramReactScrollView.smoothScrollTo(paramReactScrollView.getScrollX(), i);
      return;
    }
    paramReactScrollView.scrollTo(paramReactScrollView.getScrollX(), i);
  }

  @ReactPropGroup(customType="Color", names={"borderColor", "borderLeftColor", "borderRightColor", "borderTopColor", "borderBottomColor"})
  public void setBorderColor(ReactScrollView paramReactScrollView, int paramInt, Integer paramInteger)
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
      paramReactScrollView.setBorderColor(SPACING_TYPES[paramInt], f1, f2);
      return;
      f1 = paramInteger.intValue() & 0xFFFFFF;
      break;
      label43: f2 = paramInteger.intValue() >>> 24;
    }
  }

  @ReactPropGroup(defaultFloat=(0.0F / 0.0F), names={"borderRadius", "borderTopLeftRadius", "borderTopRightRadius", "borderBottomRightRadius", "borderBottomLeftRadius"})
  public void setBorderRadius(ReactScrollView paramReactScrollView, int paramInt, float paramFloat)
  {
    float f = paramFloat;
    if (!YogaConstants.isUndefined(paramFloat))
      f = PixelUtil.toPixelFromDIP(paramFloat);
    if (paramInt == 0)
    {
      paramReactScrollView.setBorderRadius(f);
      return;
    }
    paramReactScrollView.setBorderRadius(f, paramInt - 1);
  }

  @ReactProp(name="borderStyle")
  public void setBorderStyle(ReactScrollView paramReactScrollView, @Nullable String paramString)
  {
    paramReactScrollView.setBorderStyle(paramString);
  }

  @ReactPropGroup(defaultFloat=(0.0F / 0.0F), names={"borderWidth", "borderLeftWidth", "borderRightWidth", "borderTopWidth", "borderBottomWidth"})
  public void setBorderWidth(ReactScrollView paramReactScrollView, int paramInt, float paramFloat)
  {
    float f = paramFloat;
    if (!YogaConstants.isUndefined(paramFloat))
      f = PixelUtil.toPixelFromDIP(paramFloat);
    paramReactScrollView.setBorderWidth(SPACING_TYPES[paramInt], f);
  }

  @ReactProp(customType="Color", defaultInt=0, name="endFillColor")
  public void setBottomFillColor(ReactScrollView paramReactScrollView, int paramInt)
  {
    paramReactScrollView.setEndFillColor(paramInt);
  }

  @ReactProp(name="overScrollMode")
  public void setOverScrollMode(ReactScrollView paramReactScrollView, String paramString)
  {
    paramReactScrollView.setOverScrollMode(ReactScrollViewHelper.parseOverScrollMode(paramString));
  }

  @ReactProp(name="removeClippedSubviews")
  public void setRemoveClippedSubviews(ReactScrollView paramReactScrollView, boolean paramBoolean)
  {
    paramReactScrollView.setRemoveClippedSubviews(paramBoolean);
  }

  @ReactProp(defaultBoolean=true, name="scrollEnabled")
  public void setScrollEnabled(ReactScrollView paramReactScrollView, boolean paramBoolean)
  {
    paramReactScrollView.setScrollEnabled(paramBoolean);
  }

  @ReactProp(name="scrollPerfTag")
  public void setScrollPerfTag(ReactScrollView paramReactScrollView, String paramString)
  {
    paramReactScrollView.setScrollPerfTag(paramString);
  }

  @ReactProp(name="sendMomentumEvents")
  public void setSendMomentumEvents(ReactScrollView paramReactScrollView, boolean paramBoolean)
  {
    paramReactScrollView.setSendMomentumEvents(paramBoolean);
  }

  @ReactProp(name="showsVerticalScrollIndicator")
  public void setShowsVerticalScrollIndicator(ReactScrollView paramReactScrollView, boolean paramBoolean)
  {
    paramReactScrollView.setVerticalScrollBarEnabled(paramBoolean);
  }
}

/* Location:           C:\Users\c_jealom1\Documents\Scripts\Android\Fathom_com.brynk.fathom\Fathom_com.brynk.fathom-dex2jar.jar
 * Qualified Name:     com.facebook.react.views.scroll.ReactScrollViewManager
 * JD-Core Version:    0.6.0
 */
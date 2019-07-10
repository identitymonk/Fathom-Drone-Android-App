package com.facebook.react.views.scroll;

import android.view.View;
import android.view.ViewGroup;
import com.facebook.react.bridge.JSApplicationIllegalArgumentException;
import com.facebook.react.bridge.ReactContext;
import com.facebook.react.uimanager.UIManagerModule;
import com.facebook.react.uimanager.events.EventDispatcher;

public class ReactScrollViewHelper
{
  public static final String AUTO = "auto";
  public static final long MOMENTUM_DELAY = 20L;
  public static final String OVER_SCROLL_ALWAYS = "always";
  public static final String OVER_SCROLL_NEVER = "never";

  public static void emitScrollBeginDragEvent(ViewGroup paramViewGroup)
  {
    emitScrollEvent(paramViewGroup, ScrollEventType.BEGIN_DRAG);
  }

  public static void emitScrollEndDragEvent(ViewGroup paramViewGroup, float paramFloat1, float paramFloat2)
  {
    emitScrollEvent(paramViewGroup, ScrollEventType.END_DRAG, paramFloat1, paramFloat2);
  }

  public static void emitScrollEvent(ViewGroup paramViewGroup, float paramFloat1, float paramFloat2)
  {
    emitScrollEvent(paramViewGroup, ScrollEventType.SCROLL, paramFloat1, paramFloat2);
  }

  private static void emitScrollEvent(ViewGroup paramViewGroup, ScrollEventType paramScrollEventType)
  {
    emitScrollEvent(paramViewGroup, paramScrollEventType, 0.0F, 0.0F);
  }

  private static void emitScrollEvent(ViewGroup paramViewGroup, ScrollEventType paramScrollEventType, float paramFloat1, float paramFloat2)
  {
    View localView = paramViewGroup.getChildAt(0);
    if (localView == null)
      return;
    ((UIManagerModule)((ReactContext)paramViewGroup.getContext()).getNativeModule(UIManagerModule.class)).getEventDispatcher().dispatchEvent(ScrollEvent.obtain(paramViewGroup.getId(), paramScrollEventType, paramViewGroup.getScrollX(), paramViewGroup.getScrollY(), paramFloat1, paramFloat2, localView.getWidth(), localView.getHeight(), paramViewGroup.getWidth(), paramViewGroup.getHeight()));
  }

  public static void emitScrollMomentumBeginEvent(ViewGroup paramViewGroup)
  {
    emitScrollEvent(paramViewGroup, ScrollEventType.MOMENTUM_BEGIN);
  }

  public static void emitScrollMomentumEndEvent(ViewGroup paramViewGroup)
  {
    emitScrollEvent(paramViewGroup, ScrollEventType.MOMENTUM_END);
  }

  public static int parseOverScrollMode(String paramString)
  {
    if ((paramString == null) || (paramString.equals("auto")))
      return 1;
    if (paramString.equals("always"))
      return 0;
    if (paramString.equals("never"))
      return 2;
    throw new JSApplicationIllegalArgumentException("wrong overScrollMode: " + paramString);
  }
}

/* Location:           C:\Users\c_jealom1\Documents\Scripts\Android\Fathom_com.brynk.fathom\Fathom_com.brynk.fathom-dex2jar.jar
 * Qualified Name:     com.facebook.react.views.scroll.ReactScrollViewHelper
 * JD-Core Version:    0.6.0
 */
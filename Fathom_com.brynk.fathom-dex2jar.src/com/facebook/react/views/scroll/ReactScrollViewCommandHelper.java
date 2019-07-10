package com.facebook.react.views.scroll;

import com.facebook.infer.annotation.Assertions;
import com.facebook.react.bridge.ReadableArray;
import com.facebook.react.common.MapBuilder;
import com.facebook.react.uimanager.PixelUtil;
import java.util.Map;
import javax.annotation.Nullable;

public class ReactScrollViewCommandHelper
{
  public static final int COMMAND_FLASH_SCROLL_INDICATORS = 3;
  public static final int COMMAND_SCROLL_TO = 1;
  public static final int COMMAND_SCROLL_TO_END = 2;

  public static Map<String, Integer> getCommandsMap()
  {
    return MapBuilder.of("scrollTo", Integer.valueOf(1), "scrollToEnd", Integer.valueOf(2), "flashScrollIndicators", Integer.valueOf(3));
  }

  public static <T> void receiveCommand(ScrollCommandHandler<T> paramScrollCommandHandler, T paramT, int paramInt, @Nullable ReadableArray paramReadableArray)
  {
    Assertions.assertNotNull(paramScrollCommandHandler);
    Assertions.assertNotNull(paramT);
    Assertions.assertNotNull(paramReadableArray);
    switch (paramInt)
    {
    default:
      throw new IllegalArgumentException(String.format("Unsupported command %d received by %s.", new Object[] { Integer.valueOf(paramInt), paramScrollCommandHandler.getClass().getSimpleName() }));
    case 1:
      paramScrollCommandHandler.scrollTo(paramT, new ScrollToCommandData(Math.round(PixelUtil.toPixelFromDIP(paramReadableArray.getDouble(0))), Math.round(PixelUtil.toPixelFromDIP(paramReadableArray.getDouble(1))), paramReadableArray.getBoolean(2)));
      return;
    case 2:
      paramScrollCommandHandler.scrollToEnd(paramT, new ScrollToEndCommandData(paramReadableArray.getBoolean(0)));
      return;
    case 3:
    }
    paramScrollCommandHandler.flashScrollIndicators(paramT);
  }

  public static abstract interface ScrollCommandHandler<T>
  {
    public abstract void flashScrollIndicators(T paramT);

    public abstract void scrollTo(T paramT, ReactScrollViewCommandHelper.ScrollToCommandData paramScrollToCommandData);

    public abstract void scrollToEnd(T paramT, ReactScrollViewCommandHelper.ScrollToEndCommandData paramScrollToEndCommandData);
  }

  public static class ScrollToCommandData
  {
    public final boolean mAnimated;
    public final int mDestX;
    public final int mDestY;

    ScrollToCommandData(int paramInt1, int paramInt2, boolean paramBoolean)
    {
      this.mDestX = paramInt1;
      this.mDestY = paramInt2;
      this.mAnimated = paramBoolean;
    }
  }

  public static class ScrollToEndCommandData
  {
    public final boolean mAnimated;

    ScrollToEndCommandData(boolean paramBoolean)
    {
      this.mAnimated = paramBoolean;
    }
  }
}

/* Location:           C:\Users\c_jealom1\Documents\Scripts\Android\Fathom_com.brynk.fathom\Fathom_com.brynk.fathom-dex2jar.jar
 * Qualified Name:     com.facebook.react.views.scroll.ReactScrollViewCommandHelper
 * JD-Core Version:    0.6.0
 */
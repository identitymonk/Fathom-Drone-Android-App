package com.facebook.fbui.textlayoutbuilder.glyphwarmer;

import android.annotation.SuppressLint;
import android.graphics.Picture;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import android.support.annotation.VisibleForTesting;
import android.text.Layout;
import com.facebook.fbui.textlayoutbuilder.GlyphWarmer;
import com.facebook.fbui.textlayoutbuilder.util.LayoutMeasureUtil;

public class GlyphWarmerImpl
  implements GlyphWarmer
{
  private static WarmHandler sWarmHandler;

  @SuppressLint({"BadMethodUse-android.os.HandlerThread._Constructor", "BadMethodUse-java.lang.Thread.start"})
  private WarmHandler getWarmHandler()
  {
    if (sWarmHandler == null)
    {
      HandlerThread localHandlerThread = new HandlerThread("GlyphWarmer");
      localHandlerThread.start();
      sWarmHandler = new WarmHandler(localHandlerThread.getLooper());
    }
    return sWarmHandler;
  }

  @VisibleForTesting
  Looper getWarmHandlerLooper()
  {
    return getWarmHandler().getLooper();
  }

  public void warmLayout(Layout paramLayout)
  {
    WarmHandler localWarmHandler = getWarmHandler();
    localWarmHandler.sendMessage(localWarmHandler.obtainMessage(1, paramLayout));
  }

  private static class WarmHandler extends Handler
  {
    private static final int NO_OP = 1;
    private final Picture mPicture = new Picture();

    public WarmHandler(Looper paramLooper)
    {
      super();
    }

    public void handleMessage(Message paramMessage)
    {
      paramMessage = (Layout)paramMessage.obj;
      try
      {
        paramMessage.draw(this.mPicture.beginRecording(LayoutMeasureUtil.getWidth(paramMessage), LayoutMeasureUtil.getHeight(paramMessage)));
        this.mPicture.endRecording();
        return;
      }
      catch (java.lang.Exception paramMessage)
      {
      }
    }
  }
}

/* Location:           C:\Users\c_jealom1\Documents\Scripts\Android\Fathom_com.brynk.fathom\Fathom_com.brynk.fathom-dex2jar.jar
 * Qualified Name:     com.facebook.fbui.textlayoutbuilder.glyphwarmer.GlyphWarmerImpl
 * JD-Core Version:    0.6.0
 */
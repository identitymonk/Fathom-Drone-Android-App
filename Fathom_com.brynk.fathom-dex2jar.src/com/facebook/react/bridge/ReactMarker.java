package com.facebook.react.bridge;

import com.facebook.proguard.annotations.DoNotStrip;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import javax.annotation.Nullable;

@DoNotStrip
public class ReactMarker
{
  private static final List<MarkerListener> sListeners = new ArrayList();

  @DoNotStrip
  public static void addListener(MarkerListener paramMarkerListener)
  {
    synchronized (sListeners)
    {
      if (!sListeners.contains(paramMarkerListener))
        sListeners.add(paramMarkerListener);
      return;
    }
  }

  @DoNotStrip
  public static void clearMarkerListeners()
  {
    synchronized (sListeners)
    {
      sListeners.clear();
      return;
    }
  }

  @DoNotStrip
  public static void logMarker(ReactMarkerConstants paramReactMarkerConstants)
  {
    logMarker(paramReactMarkerConstants, null, 0);
  }

  @DoNotStrip
  public static void logMarker(ReactMarkerConstants paramReactMarkerConstants, int paramInt)
  {
    logMarker(paramReactMarkerConstants, null, paramInt);
  }

  @DoNotStrip
  public static void logMarker(ReactMarkerConstants paramReactMarkerConstants, @Nullable String paramString)
  {
    logMarker(paramReactMarkerConstants, paramString, 0);
  }

  @DoNotStrip
  public static void logMarker(ReactMarkerConstants paramReactMarkerConstants, @Nullable String paramString, int paramInt)
  {
    synchronized (sListeners)
    {
      Iterator localIterator = sListeners.iterator();
      if (localIterator.hasNext())
        ((MarkerListener)localIterator.next()).logMarker(paramReactMarkerConstants, paramString, paramInt);
    }
    monitorexit;
  }

  @DoNotStrip
  public static void logMarker(String paramString)
  {
    logMarker(paramString, null);
  }

  @DoNotStrip
  public static void logMarker(String paramString, int paramInt)
  {
    logMarker(paramString, null, paramInt);
  }

  @DoNotStrip
  public static void logMarker(String paramString1, @Nullable String paramString2)
  {
    logMarker(paramString1, paramString2, 0);
  }

  @DoNotStrip
  public static void logMarker(String paramString1, @Nullable String paramString2, int paramInt)
  {
    logMarker(ReactMarkerConstants.valueOf(paramString1), paramString2, paramInt);
  }

  @DoNotStrip
  public static void removeListener(MarkerListener paramMarkerListener)
  {
    synchronized (sListeners)
    {
      sListeners.remove(paramMarkerListener);
      return;
    }
  }

  public static abstract interface MarkerListener
  {
    public abstract void logMarker(ReactMarkerConstants paramReactMarkerConstants, @Nullable String paramString, int paramInt);
  }
}

/* Location:           C:\Users\c_jealom1\Documents\Scripts\Android\Fathom_com.brynk.fathom\Fathom_com.brynk.fathom-dex2jar.jar
 * Qualified Name:     com.facebook.react.bridge.ReactMarker
 * JD-Core Version:    0.6.0
 */
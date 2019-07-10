package com.facebook.systrace;

import android.os.Build.VERSION;
import android.os.Trace;

public class Systrace
{
  public static final long TRACE_TAG_REACT_APPS = 0L;
  public static final long TRACE_TAG_REACT_FRESCO = 0L;
  public static final long TRACE_TAG_REACT_JAVA_BRIDGE = 0L;
  public static final long TRACE_TAG_REACT_JSC_CALLS = 0L;
  public static final long TRACE_TAG_REACT_VIEW = 0L;

  public static void beginAsyncSection(long paramLong, String paramString, int paramInt)
  {
  }

  public static void beginAsyncSection(long paramLong1, String paramString, int paramInt, long paramLong2)
  {
  }

  public static void beginSection(long paramLong, String paramString)
  {
    if (Build.VERSION.SDK_INT >= 18)
      Trace.beginSection(paramString);
  }

  public static void endAsyncFlow(long paramLong, String paramString, int paramInt)
  {
  }

  public static void endAsyncSection(long paramLong, String paramString, int paramInt)
  {
  }

  public static void endAsyncSection(long paramLong1, String paramString, int paramInt, long paramLong2)
  {
  }

  public static void endSection(long paramLong)
  {
    if (Build.VERSION.SDK_INT >= 18)
      Trace.endSection();
  }

  public static boolean isTracing(long paramLong)
  {
    return false;
  }

  public static void registerListener(TraceListener paramTraceListener)
  {
  }

  public static void startAsyncFlow(long paramLong, String paramString, int paramInt)
  {
  }

  public static void stepAsyncFlow(long paramLong, String paramString, int paramInt)
  {
  }

  public static void traceCounter(long paramLong, String paramString, int paramInt)
  {
  }

  public static void traceInstant(long paramLong, String paramString, EventScope paramEventScope)
  {
  }

  public static void unregisterListener(TraceListener paramTraceListener)
  {
  }

  public static enum EventScope
  {
    private final char mCode;

    static
    {
      PROCESS = new EventScope("PROCESS", 1, 'p');
      GLOBAL = new EventScope("GLOBAL", 2, 'g');
      $VALUES = new EventScope[] { THREAD, PROCESS, GLOBAL };
    }

    private EventScope(char paramChar)
    {
      this.mCode = paramChar;
    }

    public char getCode()
    {
      return this.mCode;
    }
  }
}

/* Location:           C:\Users\c_jealom1\Documents\Scripts\Android\Fathom_com.brynk.fathom\Fathom_com.brynk.fathom-dex2jar.jar
 * Qualified Name:     com.facebook.systrace.Systrace
 * JD-Core Version:    0.6.0
 */
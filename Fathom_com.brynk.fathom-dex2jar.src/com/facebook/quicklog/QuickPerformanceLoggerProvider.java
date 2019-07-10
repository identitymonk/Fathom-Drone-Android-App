package com.facebook.quicklog;

public class QuickPerformanceLoggerProvider
{
  private static final QuickPerformanceLogger sQuickPerformanceLogger = new QuickPerformanceLogger();

  public static QuickPerformanceLogger getQPLInstance()
  {
    return sQuickPerformanceLogger;
  }
}

/* Location:           C:\Users\c_jealom1\Documents\Scripts\Android\Fathom_com.brynk.fathom\Fathom_com.brynk.fathom-dex2jar.jar
 * Qualified Name:     com.facebook.quicklog.QuickPerformanceLoggerProvider
 * JD-Core Version:    0.6.0
 */
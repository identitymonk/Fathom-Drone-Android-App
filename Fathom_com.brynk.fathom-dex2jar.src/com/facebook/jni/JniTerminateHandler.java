package com.facebook.jni;

public class JniTerminateHandler
{
  public static void handleTerminate(Throwable paramThrowable)
    throws Throwable
  {
    Thread.UncaughtExceptionHandler localUncaughtExceptionHandler = Thread.getDefaultUncaughtExceptionHandler();
    if (localUncaughtExceptionHandler == null)
      return;
    localUncaughtExceptionHandler.uncaughtException(Thread.currentThread(), paramThrowable);
  }
}

/* Location:           C:\Users\c_jealom1\Documents\Scripts\Android\Fathom_com.brynk.fathom\Fathom_com.brynk.fathom-dex2jar.jar
 * Qualified Name:     com.facebook.jni.JniTerminateHandler
 * JD-Core Version:    0.6.0
 */
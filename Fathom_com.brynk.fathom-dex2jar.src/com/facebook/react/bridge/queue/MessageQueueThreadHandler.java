package com.facebook.react.bridge.queue;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;

public class MessageQueueThreadHandler extends Handler
{
  private final QueueThreadExceptionHandler mExceptionHandler;

  public MessageQueueThreadHandler(Looper paramLooper, QueueThreadExceptionHandler paramQueueThreadExceptionHandler)
  {
    super(paramLooper);
    this.mExceptionHandler = paramQueueThreadExceptionHandler;
  }

  public void dispatchMessage(Message paramMessage)
  {
    try
    {
      super.dispatchMessage(paramMessage);
      return;
    }
    catch (java.lang.Exception paramMessage)
    {
      this.mExceptionHandler.handleException(paramMessage);
    }
  }
}

/* Location:           C:\Users\c_jealom1\Documents\Scripts\Android\Fathom_com.brynk.fathom\Fathom_com.brynk.fathom-dex2jar.jar
 * Qualified Name:     com.facebook.react.bridge.queue.MessageQueueThreadHandler
 * JD-Core Version:    0.6.0
 */
package com.facebook.react.bridge.queue;

import javax.annotation.Nullable;

public abstract interface ReactQueueConfiguration
{
  public abstract void destroy();

  public abstract MessageQueueThread getJSQueueThread();

  public abstract MessageQueueThread getNativeModulesQueueThread();

  @Nullable
  public abstract MessageQueueThread getUIBackgroundQueueThread();

  public abstract MessageQueueThread getUIQueueThread();
}

/* Location:           C:\Users\c_jealom1\Documents\Scripts\Android\Fathom_com.brynk.fathom\Fathom_com.brynk.fathom-dex2jar.jar
 * Qualified Name:     com.facebook.react.bridge.queue.ReactQueueConfiguration
 * JD-Core Version:    0.6.0
 */
package com.facebook.react.bridge.queue;

import android.os.Looper;
import com.facebook.react.common.MapBuilder;
import java.util.Map;
import javax.annotation.Nullable;

public class ReactQueueConfigurationImpl
  implements ReactQueueConfiguration
{
  private final MessageQueueThreadImpl mJSQueueThread;
  private final MessageQueueThreadImpl mNativeModulesQueueThread;

  @Nullable
  private final MessageQueueThreadImpl mUIBackgroundQueueThread;
  private final MessageQueueThreadImpl mUIQueueThread;

  private ReactQueueConfigurationImpl(MessageQueueThreadImpl paramMessageQueueThreadImpl1, @Nullable MessageQueueThreadImpl paramMessageQueueThreadImpl2, MessageQueueThreadImpl paramMessageQueueThreadImpl3, MessageQueueThreadImpl paramMessageQueueThreadImpl4)
  {
    this.mUIQueueThread = paramMessageQueueThreadImpl1;
    this.mUIBackgroundQueueThread = paramMessageQueueThreadImpl2;
    this.mNativeModulesQueueThread = paramMessageQueueThreadImpl3;
    this.mJSQueueThread = paramMessageQueueThreadImpl4;
  }

  public static ReactQueueConfigurationImpl create(ReactQueueConfigurationSpec paramReactQueueConfigurationSpec, QueueThreadExceptionHandler paramQueueThreadExceptionHandler)
  {
    Object localObject4 = MapBuilder.newHashMap();
    Object localObject1 = MessageQueueThreadSpec.mainThreadSpec();
    MessageQueueThreadImpl localMessageQueueThreadImpl = MessageQueueThreadImpl.create((MessageQueueThreadSpec)localObject1, paramQueueThreadExceptionHandler);
    ((Map)localObject4).put(localObject1, localMessageQueueThreadImpl);
    Object localObject2 = (MessageQueueThreadImpl)((Map)localObject4).get(paramReactQueueConfigurationSpec.getJSQueueThreadSpec());
    localObject1 = localObject2;
    if (localObject2 == null)
      localObject1 = MessageQueueThreadImpl.create(paramReactQueueConfigurationSpec.getJSQueueThreadSpec(), paramQueueThreadExceptionHandler);
    Object localObject3 = (MessageQueueThreadImpl)((Map)localObject4).get(paramReactQueueConfigurationSpec.getNativeModulesQueueThreadSpec());
    localObject2 = localObject3;
    if (localObject3 == null)
      localObject2 = MessageQueueThreadImpl.create(paramReactQueueConfigurationSpec.getNativeModulesQueueThreadSpec(), paramQueueThreadExceptionHandler);
    localObject4 = (MessageQueueThreadImpl)((Map)localObject4).get(paramReactQueueConfigurationSpec.getUIBackgroundQueueThreadSpec());
    localObject3 = localObject4;
    if (localObject4 == null)
    {
      localObject3 = localObject4;
      if (paramReactQueueConfigurationSpec.getUIBackgroundQueueThreadSpec() != null)
        localObject3 = MessageQueueThreadImpl.create(paramReactQueueConfigurationSpec.getUIBackgroundQueueThreadSpec(), paramQueueThreadExceptionHandler);
    }
    return (ReactQueueConfigurationImpl)(ReactQueueConfigurationImpl)(ReactQueueConfigurationImpl)(ReactQueueConfigurationImpl)new ReactQueueConfigurationImpl(localMessageQueueThreadImpl, (MessageQueueThreadImpl)localObject3, (MessageQueueThreadImpl)localObject2, (MessageQueueThreadImpl)localObject1);
  }

  public void destroy()
  {
    if ((this.mUIBackgroundQueueThread != null) && (this.mUIBackgroundQueueThread.getLooper() != Looper.getMainLooper()))
      this.mUIBackgroundQueueThread.quitSynchronous();
    if (this.mNativeModulesQueueThread.getLooper() != Looper.getMainLooper())
      this.mNativeModulesQueueThread.quitSynchronous();
    if (this.mJSQueueThread.getLooper() != Looper.getMainLooper())
      this.mJSQueueThread.quitSynchronous();
  }

  public MessageQueueThread getJSQueueThread()
  {
    return this.mJSQueueThread;
  }

  public MessageQueueThread getNativeModulesQueueThread()
  {
    return this.mNativeModulesQueueThread;
  }

  @Nullable
  public MessageQueueThread getUIBackgroundQueueThread()
  {
    return this.mUIBackgroundQueueThread;
  }

  public MessageQueueThread getUIQueueThread()
  {
    return this.mUIQueueThread;
  }
}

/* Location:           C:\Users\c_jealom1\Documents\Scripts\Android\Fathom_com.brynk.fathom\Fathom_com.brynk.fathom-dex2jar.jar
 * Qualified Name:     com.facebook.react.bridge.queue.ReactQueueConfigurationImpl
 * JD-Core Version:    0.6.0
 */
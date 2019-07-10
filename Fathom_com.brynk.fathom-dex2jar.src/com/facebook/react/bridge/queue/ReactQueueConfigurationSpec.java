package com.facebook.react.bridge.queue;

import android.os.Build.VERSION;
import com.facebook.infer.annotation.Assertions;
import javax.annotation.Nullable;

public class ReactQueueConfigurationSpec
{
  private static final long LEGACY_STACK_SIZE_BYTES = 2000000L;
  private final MessageQueueThreadSpec mJSQueueThreadSpec;
  private final MessageQueueThreadSpec mNativeModulesQueueThreadSpec;

  @Nullable
  private final MessageQueueThreadSpec mUIBackgroundQueueThreadSpec;

  private ReactQueueConfigurationSpec(@Nullable MessageQueueThreadSpec paramMessageQueueThreadSpec1, MessageQueueThreadSpec paramMessageQueueThreadSpec2, MessageQueueThreadSpec paramMessageQueueThreadSpec3)
  {
    this.mUIBackgroundQueueThreadSpec = paramMessageQueueThreadSpec1;
    this.mNativeModulesQueueThreadSpec = paramMessageQueueThreadSpec2;
    this.mJSQueueThreadSpec = paramMessageQueueThreadSpec3;
  }

  public static Builder builder()
  {
    return new Builder();
  }

  public static ReactQueueConfigurationSpec createDefault()
  {
    if (Build.VERSION.SDK_INT < 21);
    for (MessageQueueThreadSpec localMessageQueueThreadSpec = MessageQueueThreadSpec.newBackgroundThreadSpec("native_modules", 2000000L); ; localMessageQueueThreadSpec = MessageQueueThreadSpec.newBackgroundThreadSpec("native_modules"))
      return builder().setJSQueueThreadSpec(MessageQueueThreadSpec.newBackgroundThreadSpec("js")).setNativeModulesQueueThreadSpec(localMessageQueueThreadSpec).build();
  }

  public static ReactQueueConfigurationSpec createWithSeparateUIBackgroundThread()
  {
    if (Build.VERSION.SDK_INT < 21);
    for (MessageQueueThreadSpec localMessageQueueThreadSpec = MessageQueueThreadSpec.newBackgroundThreadSpec("native_modules", 2000000L); ; localMessageQueueThreadSpec = MessageQueueThreadSpec.newBackgroundThreadSpec("native_modules"))
      return builder().setJSQueueThreadSpec(MessageQueueThreadSpec.newBackgroundThreadSpec("js")).setNativeModulesQueueThreadSpec(localMessageQueueThreadSpec).setUIBackgroundQueueThreadSpec(MessageQueueThreadSpec.newUIBackgroundTreadSpec("ui_background")).build();
  }

  public MessageQueueThreadSpec getJSQueueThreadSpec()
  {
    return this.mJSQueueThreadSpec;
  }

  public MessageQueueThreadSpec getNativeModulesQueueThreadSpec()
  {
    return this.mNativeModulesQueueThreadSpec;
  }

  @Nullable
  public MessageQueueThreadSpec getUIBackgroundQueueThreadSpec()
  {
    return this.mUIBackgroundQueueThreadSpec;
  }

  public static class Builder
  {

    @Nullable
    private MessageQueueThreadSpec mJSQueueSpec;

    @Nullable
    private MessageQueueThreadSpec mNativeModulesQueueSpec;

    @Nullable
    private MessageQueueThreadSpec mUIBackgroundQueueSpec;

    public ReactQueueConfigurationSpec build()
    {
      return new ReactQueueConfigurationSpec(this.mUIBackgroundQueueSpec, (MessageQueueThreadSpec)Assertions.assertNotNull(this.mNativeModulesQueueSpec), (MessageQueueThreadSpec)Assertions.assertNotNull(this.mJSQueueSpec), null);
    }

    public Builder setJSQueueThreadSpec(MessageQueueThreadSpec paramMessageQueueThreadSpec)
    {
      if (this.mJSQueueSpec == null);
      for (boolean bool = true; ; bool = false)
      {
        Assertions.assertCondition(bool, "Setting JS queue multiple times!");
        this.mJSQueueSpec = paramMessageQueueThreadSpec;
        return this;
      }
    }

    public Builder setNativeModulesQueueThreadSpec(MessageQueueThreadSpec paramMessageQueueThreadSpec)
    {
      if (this.mNativeModulesQueueSpec == null);
      for (boolean bool = true; ; bool = false)
      {
        Assertions.assertCondition(bool, "Setting native modules queue spec multiple times!");
        this.mNativeModulesQueueSpec = paramMessageQueueThreadSpec;
        return this;
      }
    }

    public Builder setUIBackgroundQueueThreadSpec(MessageQueueThreadSpec paramMessageQueueThreadSpec)
    {
      if (this.mUIBackgroundQueueSpec == null);
      for (boolean bool = true; ; bool = false)
      {
        Assertions.assertCondition(bool, "Setting UI background queue multiple times!");
        this.mUIBackgroundQueueSpec = paramMessageQueueThreadSpec;
        return this;
      }
    }
  }
}

/* Location:           C:\Users\c_jealom1\Documents\Scripts\Android\Fathom_com.brynk.fathom\Fathom_com.brynk.fathom-dex2jar.jar
 * Qualified Name:     com.facebook.react.bridge.queue.ReactQueueConfigurationSpec
 * JD-Core Version:    0.6.0
 */
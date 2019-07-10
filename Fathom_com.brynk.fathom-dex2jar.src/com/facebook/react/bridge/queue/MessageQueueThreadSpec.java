package com.facebook.react.bridge.queue;

public class MessageQueueThreadSpec
{
  public static final long DEFAULT_STACK_SIZE_BYTES = 0L;
  private static final MessageQueueThreadSpec MAIN_UI_SPEC = new MessageQueueThreadSpec(ThreadType.MAIN_UI, "main_ui");
  private final String mName;
  private final long mStackSize;
  private final ThreadType mThreadType;

  private MessageQueueThreadSpec(ThreadType paramThreadType, String paramString)
  {
    this(paramThreadType, paramString, 0L);
  }

  private MessageQueueThreadSpec(ThreadType paramThreadType, String paramString, long paramLong)
  {
    this.mThreadType = paramThreadType;
    this.mName = paramString;
    this.mStackSize = paramLong;
  }

  public static MessageQueueThreadSpec mainThreadSpec()
  {
    return MAIN_UI_SPEC;
  }

  public static MessageQueueThreadSpec newBackgroundThreadSpec(String paramString)
  {
    return new MessageQueueThreadSpec(ThreadType.NEW_BACKGROUND, paramString);
  }

  public static MessageQueueThreadSpec newBackgroundThreadSpec(String paramString, long paramLong)
  {
    return new MessageQueueThreadSpec(ThreadType.NEW_BACKGROUND, paramString, paramLong);
  }

  public static MessageQueueThreadSpec newUIBackgroundTreadSpec(String paramString)
  {
    return new MessageQueueThreadSpec(ThreadType.NEW_BACKGROUND, paramString);
  }

  public String getName()
  {
    return this.mName;
  }

  public long getStackSize()
  {
    return this.mStackSize;
  }

  public ThreadType getThreadType()
  {
    return this.mThreadType;
  }

  protected static enum ThreadType
  {
    static
    {
      $VALUES = new ThreadType[] { MAIN_UI, NEW_BACKGROUND };
    }
  }
}

/* Location:           C:\Users\c_jealom1\Documents\Scripts\Android\Fathom_com.brynk.fathom\Fathom_com.brynk.fathom-dex2jar.jar
 * Qualified Name:     com.facebook.react.bridge.queue.MessageQueueThreadSpec
 * JD-Core Version:    0.6.0
 */
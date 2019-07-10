package com.facebook.react.jstasks;

import com.facebook.react.bridge.WritableMap;

public class HeadlessJsTaskConfig
{
  private final boolean mAllowedInForeground;
  private final WritableMap mData;
  private final String mTaskKey;
  private final long mTimeout;

  public HeadlessJsTaskConfig(String paramString, WritableMap paramWritableMap)
  {
    this(paramString, paramWritableMap, 0L, false);
  }

  public HeadlessJsTaskConfig(String paramString, WritableMap paramWritableMap, long paramLong)
  {
    this(paramString, paramWritableMap, paramLong, false);
  }

  public HeadlessJsTaskConfig(String paramString, WritableMap paramWritableMap, long paramLong, boolean paramBoolean)
  {
    this.mTaskKey = paramString;
    this.mData = paramWritableMap;
    this.mTimeout = paramLong;
    this.mAllowedInForeground = paramBoolean;
  }

  WritableMap getData()
  {
    return this.mData;
  }

  String getTaskKey()
  {
    return this.mTaskKey;
  }

  long getTimeout()
  {
    return this.mTimeout;
  }

  boolean isAllowedInForeground()
  {
    return this.mAllowedInForeground;
  }
}

/* Location:           C:\Users\c_jealom1\Documents\Scripts\Android\Fathom_com.brynk.fathom\Fathom_com.brynk.fathom-dex2jar.jar
 * Qualified Name:     com.facebook.react.jstasks.HeadlessJsTaskConfig
 * JD-Core Version:    0.6.0
 */
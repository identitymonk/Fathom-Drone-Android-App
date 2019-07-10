package com.facebook.react.bridge;

import com.facebook.common.logging.FLog;
import com.facebook.jni.HybridData;
import com.facebook.proguard.annotations.DoNotStrip;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

@DoNotStrip
public class Inspector
{
  private final HybridData mHybridData;

  static
  {
    ReactBridge.staticInit();
  }

  private Inspector(HybridData paramHybridData)
  {
    this.mHybridData = paramHybridData;
  }

  public static LocalConnection connect(int paramInt, RemoteConnection paramRemoteConnection)
  {
    try
    {
      paramRemoteConnection = instance().connectNative(paramInt, paramRemoteConnection);
      return paramRemoteConnection;
    }
    catch (UnsatisfiedLinkError paramRemoteConnection)
    {
      FLog.e("ReactNative", "Inspector doesn't work in open source yet", paramRemoteConnection);
    }
    throw new RuntimeException(paramRemoteConnection);
  }

  private native LocalConnection connectNative(int paramInt, RemoteConnection paramRemoteConnection);

  public static List<Page> getPages()
  {
    try
    {
      List localList = Arrays.asList(instance().getPagesNative());
      return localList;
    }
    catch (UnsatisfiedLinkError localUnsatisfiedLinkError)
    {
      FLog.e("ReactNative", "Inspector doesn't work in open source yet", localUnsatisfiedLinkError);
    }
    return Collections.emptyList();
  }

  private native Page[] getPagesNative();

  private static native Inspector instance();

  @DoNotStrip
  public static class LocalConnection
  {
    private final HybridData mHybridData;

    private LocalConnection(HybridData paramHybridData)
    {
      this.mHybridData = paramHybridData;
    }

    public native void disconnect();

    public native void sendMessage(String paramString);
  }

  @DoNotStrip
  public static class Page
  {
    private final int mId;
    private final String mTitle;

    @DoNotStrip
    private Page(int paramInt, String paramString)
    {
      this.mId = paramInt;
      this.mTitle = paramString;
    }

    public int getId()
    {
      return this.mId;
    }

    public String getTitle()
    {
      return this.mTitle;
    }

    public String toString()
    {
      return "Page{mId=" + this.mId + ", mTitle='" + this.mTitle + '\'' + '}';
    }
  }

  @DoNotStrip
  public static abstract interface RemoteConnection
  {
    public abstract void onDisconnect();

    public abstract void onMessage(String paramString);
  }
}

/* Location:           C:\Users\c_jealom1\Documents\Scripts\Android\Fathom_com.brynk.fathom\Fathom_com.brynk.fathom-dex2jar.jar
 * Qualified Name:     com.facebook.react.bridge.Inspector
 * JD-Core Version:    0.6.0
 */
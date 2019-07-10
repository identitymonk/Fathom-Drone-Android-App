package com.facebook.react.views.image;

import com.facebook.react.bridge.Arguments;
import com.facebook.react.bridge.WritableMap;
import com.facebook.react.uimanager.events.Event;
import com.facebook.react.uimanager.events.RCTEventEmitter;
import javax.annotation.Nullable;

public class ImageLoadEvent extends Event<ImageLoadEvent>
{
  public static final int ON_ERROR = 1;
  public static final int ON_LOAD = 2;
  public static final int ON_LOAD_END = 3;
  public static final int ON_LOAD_START = 4;
  public static final int ON_PROGRESS = 5;
  private final int mEventType;
  private final int mHeight;

  @Nullable
  private final String mImageUri;
  private final int mWidth;

  public ImageLoadEvent(int paramInt1, int paramInt2)
  {
    this(paramInt1, paramInt2, null);
  }

  public ImageLoadEvent(int paramInt1, int paramInt2, String paramString)
  {
    this(paramInt1, paramInt2, paramString, 0, 0);
  }

  public ImageLoadEvent(int paramInt1, int paramInt2, @Nullable String paramString, int paramInt3, int paramInt4)
  {
    super(paramInt1);
    this.mEventType = paramInt2;
    this.mImageUri = paramString;
    this.mWidth = paramInt3;
    this.mHeight = paramInt4;
  }

  public static String eventNameForType(int paramInt)
  {
    switch (paramInt)
    {
    default:
      throw new IllegalStateException("Invalid image event: " + Integer.toString(paramInt));
    case 1:
      return "topError";
    case 2:
      return "topLoad";
    case 3:
      return "topLoadEnd";
    case 4:
      return "topLoadStart";
    case 5:
    }
    return "topProgress";
  }

  public void dispatch(RCTEventEmitter paramRCTEventEmitter)
  {
    Object localObject = null;
    if ((this.mImageUri != null) || (this.mEventType == 2))
    {
      WritableMap localWritableMap = Arguments.createMap();
      if (this.mImageUri != null)
        localWritableMap.putString("uri", this.mImageUri);
      localObject = localWritableMap;
      if (this.mEventType == 2)
      {
        localObject = Arguments.createMap();
        ((WritableMap)localObject).putDouble("width", this.mWidth);
        ((WritableMap)localObject).putDouble("height", this.mHeight);
        if (this.mImageUri != null)
          ((WritableMap)localObject).putString("url", this.mImageUri);
        localWritableMap.putMap("source", (WritableMap)localObject);
        localObject = localWritableMap;
      }
    }
    paramRCTEventEmitter.receiveEvent(getViewTag(), getEventName(), (WritableMap)localObject);
  }

  public short getCoalescingKey()
  {
    return (short)this.mEventType;
  }

  public String getEventName()
  {
    return eventNameForType(this.mEventType);
  }
}

/* Location:           C:\Users\c_jealom1\Documents\Scripts\Android\Fathom_com.brynk.fathom\Fathom_com.brynk.fathom-dex2jar.jar
 * Qualified Name:     com.facebook.react.views.image.ImageLoadEvent
 * JD-Core Version:    0.6.0
 */
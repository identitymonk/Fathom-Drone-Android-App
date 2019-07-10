package com.facebook.react.modules.blob;

import android.content.res.Resources;
import android.net.Uri;
import android.support.annotation.Nullable;
import com.facebook.react.bridge.Arguments;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.facebook.react.bridge.ReactMethod;
import com.facebook.react.bridge.ReadableArray;
import com.facebook.react.bridge.ReadableMap;
import com.facebook.react.bridge.WritableMap;
import com.facebook.react.common.MapBuilder;
import com.facebook.react.module.annotations.ReactModule;
import com.facebook.react.modules.websocket.WebSocketModule;
import com.facebook.react.modules.websocket.WebSocketModule.ContentHandler;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.UUID;
import okio.ByteString;

@ReactModule(name="BlobModule")
public class BlobModule extends ReactContextBaseJavaModule
{
  protected static final String NAME = "BlobModule";
  private final Map<String, byte[]> mBlobs = new HashMap();
  protected final WebSocketModule.ContentHandler mContentHandler = new WebSocketModule.ContentHandler()
  {
    public void onMessage(String paramString, WritableMap paramWritableMap)
    {
      paramWritableMap.putString("data", paramString);
    }

    public void onMessage(ByteString paramByteString, WritableMap paramWritableMap)
    {
      paramByteString = paramByteString.toByteArray();
      WritableMap localWritableMap = Arguments.createMap();
      localWritableMap.putString("blobId", BlobModule.this.store(paramByteString));
      localWritableMap.putInt("offset", 0);
      localWritableMap.putInt("size", paramByteString.length);
      paramWritableMap.putMap("data", localWritableMap);
      paramWritableMap.putString("type", "blob");
    }
  };

  public BlobModule(ReactApplicationContext paramReactApplicationContext)
  {
    super(paramReactApplicationContext);
  }

  private WebSocketModule getWebSocketModule()
  {
    return (WebSocketModule)getReactApplicationContext().getNativeModule(WebSocketModule.class);
  }

  @ReactMethod
  public void createFromParts(ReadableArray paramReadableArray, String paramString)
  {
    int j = 0;
    Object localObject = new ArrayList(paramReadableArray.size());
    int i = 0;
    while (i < paramReadableArray.size())
    {
      ReadableMap localReadableMap = paramReadableArray.getMap(i);
      j += localReadableMap.getInt("size");
      ((ArrayList)localObject).add(i, localReadableMap);
      i += 1;
    }
    paramReadableArray = ByteBuffer.allocate(j);
    localObject = ((ArrayList)localObject).iterator();
    while (((Iterator)localObject).hasNext())
      paramReadableArray.put(resolve((ReadableMap)((Iterator)localObject).next()));
    store(paramReadableArray.array(), paramString);
  }

  @ReactMethod
  public void disableBlobSupport(int paramInt)
  {
    getWebSocketModule().setContentHandler(paramInt, null);
  }

  @ReactMethod
  public void enableBlobSupport(int paramInt)
  {
    getWebSocketModule().setContentHandler(paramInt, this.mContentHandler);
  }

  @Nullable
  public Map getConstants()
  {
    Resources localResources = getReactApplicationContext().getResources();
    int i = localResources.getIdentifier("blob_provider_authority", "string", getReactApplicationContext().getPackageName());
    if (i == 0)
      return null;
    return MapBuilder.of("BLOB_URI_SCHEME", "content", "BLOB_URI_HOST", localResources.getString(i));
  }

  public String getName()
  {
    return "BlobModule";
  }

  @ReactMethod
  public void release(String paramString)
  {
    remove(paramString);
  }

  public void remove(String paramString)
  {
    this.mBlobs.remove(paramString);
  }

  @Nullable
  public byte[] resolve(Uri paramUri)
  {
    String str1 = paramUri.getLastPathSegment();
    int i = 0;
    int j = -1;
    String str2 = paramUri.getQueryParameter("offset");
    if (str2 != null)
      i = Integer.parseInt(str2, 10);
    paramUri = paramUri.getQueryParameter("size");
    if (paramUri != null)
      j = Integer.parseInt(paramUri, 10);
    return resolve(str1, i, j);
  }

  @Nullable
  public byte[] resolve(ReadableMap paramReadableMap)
  {
    return resolve(paramReadableMap.getString("blobId"), paramReadableMap.getInt("offset"), paramReadableMap.getInt("size"));
  }

  @Nullable
  public byte[] resolve(String paramString, int paramInt1, int paramInt2)
  {
    byte[] arrayOfByte = (byte[])this.mBlobs.get(paramString);
    if (arrayOfByte == null)
      return null;
    int i = paramInt2;
    if (paramInt2 == -1)
      i = arrayOfByte.length - paramInt1;
    paramString = arrayOfByte;
    if (paramInt1 > 0)
      paramString = Arrays.copyOfRange(arrayOfByte, paramInt1, paramInt1 + i);
    return paramString;
  }

  @ReactMethod
  public void sendBlob(ReadableMap paramReadableMap, int paramInt)
  {
    paramReadableMap = resolve(paramReadableMap.getString("blobId"), paramReadableMap.getInt("offset"), paramReadableMap.getInt("size"));
    if (paramReadableMap != null)
    {
      getWebSocketModule().sendBinary(ByteString.of(paramReadableMap), paramInt);
      return;
    }
    getWebSocketModule().sendBinary((ByteString)null, paramInt);
  }

  public String store(byte[] paramArrayOfByte)
  {
    String str = UUID.randomUUID().toString();
    store(paramArrayOfByte, str);
    return str;
  }

  public void store(byte[] paramArrayOfByte, String paramString)
  {
    this.mBlobs.put(paramString, paramArrayOfByte);
  }
}

/* Location:           C:\Users\c_jealom1\Documents\Scripts\Android\Fathom_com.brynk.fathom\Fathom_com.brynk.fathom-dex2jar.jar
 * Qualified Name:     com.facebook.react.modules.blob.BlobModule
 * JD-Core Version:    0.6.0
 */
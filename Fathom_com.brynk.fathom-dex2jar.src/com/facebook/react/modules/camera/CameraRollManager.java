package com.facebook.react.modules.camera;

import android.content.ContentResolver;
import android.content.Context;
import android.database.Cursor;
import android.media.MediaScannerConnection;
import android.media.MediaScannerConnection.OnScanCompletedListener;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Build.VERSION;
import android.os.Environment;
import com.facebook.common.logging.FLog;
import com.facebook.react.bridge.GuardedAsyncTask;
import com.facebook.react.bridge.JSApplicationIllegalArgumentException;
import com.facebook.react.bridge.Promise;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.facebook.react.bridge.ReactMethod;
import com.facebook.react.bridge.ReadableArray;
import com.facebook.react.bridge.ReadableMap;
import com.facebook.react.bridge.WritableArray;
import com.facebook.react.bridge.WritableMap;
import com.facebook.react.bridge.WritableNativeArray;
import com.facebook.react.bridge.WritableNativeMap;
import com.facebook.react.module.annotations.ReactModule;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.channels.FileChannel;
import java.nio.channels.ReadableByteChannel;
import javax.annotation.Nullable;

@ReactModule(name="CameraRollManager")
public class CameraRollManager extends ReactContextBaseJavaModule
{
  private static final String ERROR_UNABLE_TO_LOAD = "E_UNABLE_TO_LOAD";
  private static final String ERROR_UNABLE_TO_LOAD_PERMISSION = "E_UNABLE_TO_LOAD_PERMISSION";
  private static final String ERROR_UNABLE_TO_SAVE = "E_UNABLE_TO_SAVE";
  public static final boolean IS_JELLY_BEAN_OR_LATER;
  protected static final String NAME = "CameraRollManager";
  private static final String[] PROJECTION;
  private static final String SELECTION_BUCKET = "bucket_display_name = ?";
  private static final String SELECTION_DATE_TAKEN = "datetaken < ?";

  static
  {
    if (Build.VERSION.SDK_INT >= 16);
    for (boolean bool = true; ; bool = false)
    {
      IS_JELLY_BEAN_OR_LATER = bool;
      if (!IS_JELLY_BEAN_OR_LATER)
        break;
      PROJECTION = new String[] { "_id", "mime_type", "bucket_display_name", "datetaken", "width", "height", "longitude", "latitude" };
      return;
    }
    PROJECTION = new String[] { "_id", "mime_type", "bucket_display_name", "datetaken", "longitude", "latitude" };
  }

  public CameraRollManager(ReactApplicationContext paramReactApplicationContext)
  {
    super(paramReactApplicationContext);
  }

  private static void putBasicNodeInfo(Cursor paramCursor, WritableMap paramWritableMap, int paramInt1, int paramInt2, int paramInt3)
  {
    paramWritableMap.putString("type", paramCursor.getString(paramInt1));
    paramWritableMap.putString("group_name", paramCursor.getString(paramInt2));
    paramWritableMap.putDouble("timestamp", paramCursor.getLong(paramInt3) / 1000.0D);
  }

  private static void putEdges(ContentResolver paramContentResolver, Cursor paramCursor, WritableMap paramWritableMap, int paramInt, @Nullable String paramString)
  {
    WritableNativeArray localWritableNativeArray = new WritableNativeArray();
    paramCursor.moveToFirst();
    int m = paramCursor.getColumnIndex("_id");
    int n = paramCursor.getColumnIndex("mime_type");
    int i1 = paramCursor.getColumnIndex("bucket_display_name");
    int i2 = paramCursor.getColumnIndex("datetaken");
    int j;
    int k;
    label88: int i;
    if (IS_JELLY_BEAN_OR_LATER)
    {
      j = paramCursor.getColumnIndex("width");
      if (!IS_JELLY_BEAN_OR_LATER)
        break label226;
      k = paramCursor.getColumnIndex("height");
      int i3 = paramCursor.getColumnIndex("longitude");
      int i4 = paramCursor.getColumnIndex("latitude");
      i = 0;
      label111: if ((i >= paramInt) || (paramCursor.isAfterLast()))
        break label241;
      WritableNativeMap localWritableNativeMap1 = new WritableNativeMap();
      WritableNativeMap localWritableNativeMap2 = new WritableNativeMap();
      if (!putImageInfo(paramContentResolver, paramCursor, localWritableNativeMap2, m, j, k, paramString))
        break label232;
      putBasicNodeInfo(paramCursor, localWritableNativeMap2, n, i1, i2);
      putLocationInfo(paramCursor, localWritableNativeMap2, i3, i4);
      localWritableNativeMap1.putMap("node", localWritableNativeMap2);
      localWritableNativeArray.pushMap(localWritableNativeMap1);
    }
    while (true)
    {
      paramCursor.moveToNext();
      i += 1;
      break label111;
      j = -1;
      break;
      label226: k = -1;
      break label88;
      label232: i -= 1;
    }
    label241: paramWritableMap.putArray("edges", localWritableNativeArray);
  }

  // ERROR //
  private static boolean putImageInfo(ContentResolver paramContentResolver, Cursor paramCursor, WritableMap paramWritableMap, int paramInt1, int paramInt2, int paramInt3, @Nullable String paramString)
  {
    // Byte code:
    //   0: new 134	com/facebook/react/bridge/WritableNativeMap
    //   3: dup
    //   4: invokespecial 135	com/facebook/react/bridge/WritableNativeMap:<init>	()V
    //   7: astore 12
    //   9: aload 6
    //   11: ifnull +337 -> 348
    //   14: aload 6
    //   16: ldc 171
    //   18: invokevirtual 175	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   21: ifeq +327 -> 348
    //   24: getstatic 181	android/provider/MediaStore$Video$Media:EXTERNAL_CONTENT_URI	Landroid/net/Uri;
    //   27: aload_1
    //   28: iload_3
    //   29: invokeinterface 96 2 0
    //   34: invokestatic 187	android/net/Uri:withAppendedPath	(Landroid/net/Uri;Ljava/lang/String;)Landroid/net/Uri;
    //   37: astore 11
    //   39: aload 12
    //   41: ldc 189
    //   43: aload 11
    //   45: invokevirtual 193	android/net/Uri:toString	()Ljava/lang/String;
    //   48: invokeinterface 102 3 0
    //   53: ldc 194
    //   55: fstore 8
    //   57: ldc 194
    //   59: fstore 7
    //   61: getstatic 49	com/facebook/react/modules/camera/CameraRollManager:IS_JELLY_BEAN_OR_LATER	Z
    //   64: ifeq +25 -> 89
    //   67: aload_1
    //   68: iload 4
    //   70: invokeinterface 198 2 0
    //   75: i2f
    //   76: fstore 8
    //   78: aload_1
    //   79: iload 5
    //   81: invokeinterface 198 2 0
    //   86: i2f
    //   87: fstore 7
    //   89: fload 7
    //   91: fstore 9
    //   93: fload 8
    //   95: fstore 10
    //   97: aload 6
    //   99: ifnull +144 -> 243
    //   102: fload 7
    //   104: fstore 9
    //   106: fload 8
    //   108: fstore 10
    //   110: aload 6
    //   112: ldc 171
    //   114: invokevirtual 175	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   117: ifeq +126 -> 243
    //   120: fload 7
    //   122: fstore 9
    //   124: fload 8
    //   126: fstore 10
    //   128: getstatic 47	android/os/Build$VERSION:SDK_INT	I
    //   131: bipush 10
    //   133: if_icmplt +110 -> 243
    //   136: aload_0
    //   137: aload 11
    //   139: ldc 200
    //   141: invokevirtual 206	android/content/ContentResolver:openAssetFileDescriptor	(Landroid/net/Uri;Ljava/lang/String;)Landroid/content/res/AssetFileDescriptor;
    //   144: astore_1
    //   145: new 208	android/media/MediaMetadataRetriever
    //   148: dup
    //   149: invokespecial 209	android/media/MediaMetadataRetriever:<init>	()V
    //   152: astore 6
    //   154: aload 6
    //   156: aload_1
    //   157: invokevirtual 215	android/content/res/AssetFileDescriptor:getFileDescriptor	()Ljava/io/FileDescriptor;
    //   160: invokevirtual 219	android/media/MediaMetadataRetriever:setDataSource	(Ljava/io/FileDescriptor;)V
    //   163: fload 8
    //   165: fconst_0
    //   166: fcmpg
    //   167: ifle +14 -> 181
    //   170: fload 7
    //   172: fstore 9
    //   174: fload 7
    //   176: fconst_0
    //   177: fcmpg
    //   178: ifgt +29 -> 207
    //   181: aload 6
    //   183: bipush 18
    //   185: invokevirtual 222	android/media/MediaMetadataRetriever:extractMetadata	(I)Ljava/lang/String;
    //   188: invokestatic 227	java/lang/Integer:parseInt	(Ljava/lang/String;)I
    //   191: i2f
    //   192: fstore 8
    //   194: aload 6
    //   196: bipush 19
    //   198: invokevirtual 222	android/media/MediaMetadataRetriever:extractMetadata	(I)Ljava/lang/String;
    //   201: invokestatic 227	java/lang/Integer:parseInt	(Ljava/lang/String;)I
    //   204: i2f
    //   205: fstore 9
    //   207: aload 12
    //   209: ldc 229
    //   211: aload 6
    //   213: bipush 9
    //   215: invokevirtual 222	android/media/MediaMetadataRetriever:extractMetadata	(I)Ljava/lang/String;
    //   218: invokestatic 227	java/lang/Integer:parseInt	(Ljava/lang/String;)I
    //   221: sipush 1000
    //   224: idiv
    //   225: invokeinterface 233 3 0
    //   230: aload 6
    //   232: invokevirtual 236	android/media/MediaMetadataRetriever:release	()V
    //   235: aload_1
    //   236: invokevirtual 239	android/content/res/AssetFileDescriptor:close	()V
    //   239: fload 8
    //   241: fstore 10
    //   243: fload 10
    //   245: fconst_0
    //   246: fcmpg
    //   247: ifle +14 -> 261
    //   250: fload 9
    //   252: fstore 7
    //   254: fload 9
    //   256: fconst_0
    //   257: fcmpg
    //   258: ifgt +53 -> 311
    //   261: aload_0
    //   262: aload 11
    //   264: ldc 200
    //   266: invokevirtual 206	android/content/ContentResolver:openAssetFileDescriptor	(Landroid/net/Uri;Ljava/lang/String;)Landroid/content/res/AssetFileDescriptor;
    //   269: astore_0
    //   270: new 241	android/graphics/BitmapFactory$Options
    //   273: dup
    //   274: invokespecial 242	android/graphics/BitmapFactory$Options:<init>	()V
    //   277: astore_1
    //   278: aload_1
    //   279: iconst_1
    //   280: putfield 245	android/graphics/BitmapFactory$Options:inJustDecodeBounds	Z
    //   283: aload_0
    //   284: invokevirtual 215	android/content/res/AssetFileDescriptor:getFileDescriptor	()Ljava/io/FileDescriptor;
    //   287: aconst_null
    //   288: aload_1
    //   289: invokestatic 251	android/graphics/BitmapFactory:decodeFileDescriptor	(Ljava/io/FileDescriptor;Landroid/graphics/Rect;Landroid/graphics/BitmapFactory$Options;)Landroid/graphics/Bitmap;
    //   292: pop
    //   293: aload_1
    //   294: getfield 254	android/graphics/BitmapFactory$Options:outWidth	I
    //   297: i2f
    //   298: fstore 10
    //   300: aload_1
    //   301: getfield 257	android/graphics/BitmapFactory$Options:outHeight	I
    //   304: i2f
    //   305: fstore 7
    //   307: aload_0
    //   308: invokevirtual 239	android/content/res/AssetFileDescriptor:close	()V
    //   311: aload 12
    //   313: ldc 61
    //   315: fload 10
    //   317: f2d
    //   318: invokeinterface 116 4 0
    //   323: aload 12
    //   325: ldc 63
    //   327: fload 7
    //   329: f2d
    //   330: invokeinterface 116 4 0
    //   335: aload_2
    //   336: ldc_w 259
    //   339: aload 12
    //   341: invokeinterface 151 3 0
    //   346: iconst_1
    //   347: ireturn
    //   348: getstatic 262	android/provider/MediaStore$Images$Media:EXTERNAL_CONTENT_URI	Landroid/net/Uri;
    //   351: aload_1
    //   352: iload_3
    //   353: invokeinterface 96 2 0
    //   358: invokestatic 187	android/net/Uri:withAppendedPath	(Landroid/net/Uri;Ljava/lang/String;)Landroid/net/Uri;
    //   361: astore 11
    //   363: goto -324 -> 39
    //   366: astore_0
    //   367: ldc_w 264
    //   370: new 266	java/lang/StringBuilder
    //   373: dup
    //   374: invokespecial 267	java/lang/StringBuilder:<init>	()V
    //   377: ldc_w 269
    //   380: invokevirtual 273	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   383: aload 11
    //   385: invokevirtual 193	android/net/Uri:toString	()Ljava/lang/String;
    //   388: invokevirtual 273	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   391: invokevirtual 274	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   394: aload_0
    //   395: invokestatic 280	com/facebook/common/logging/FLog:e	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   398: iconst_0
    //   399: ireturn
    //   400: astore_0
    //   401: ldc_w 264
    //   404: new 266	java/lang/StringBuilder
    //   407: dup
    //   408: invokespecial 267	java/lang/StringBuilder:<init>	()V
    //   411: ldc_w 282
    //   414: invokevirtual 273	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   417: aload 11
    //   419: invokevirtual 193	android/net/Uri:toString	()Ljava/lang/String;
    //   422: invokevirtual 273	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   425: invokevirtual 274	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   428: aload_0
    //   429: invokestatic 280	com/facebook/common/logging/FLog:e	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   432: iconst_0
    //   433: ireturn
    //
    // Exception table:
    //   from	to	target	type
    //   136	163	366	java/io/IOException
    //   181	207	366	java/io/IOException
    //   207	239	366	java/io/IOException
    //   261	311	400	java/io/IOException
  }

  private static void putLocationInfo(Cursor paramCursor, WritableMap paramWritableMap, int paramInt1, int paramInt2)
  {
    double d1 = paramCursor.getDouble(paramInt1);
    double d2 = paramCursor.getDouble(paramInt2);
    if ((d1 > 0.0D) || (d2 > 0.0D))
    {
      paramCursor = new WritableNativeMap();
      paramCursor.putDouble("longitude", d1);
      paramCursor.putDouble("latitude", d2);
      paramWritableMap.putMap("location", paramCursor);
    }
  }

  private static void putPageInfo(Cursor paramCursor, WritableMap paramWritableMap, int paramInt)
  {
    WritableNativeMap localWritableNativeMap = new WritableNativeMap();
    if (paramInt < paramCursor.getCount());
    for (boolean bool = true; ; bool = false)
    {
      localWritableNativeMap.putBoolean("has_next_page", bool);
      if (paramInt < paramCursor.getCount())
      {
        paramCursor.moveToPosition(paramInt - 1);
        localWritableNativeMap.putString("end_cursor", paramCursor.getString(paramCursor.getColumnIndex("datetaken")));
      }
      paramWritableMap.putMap("page_info", localWritableNativeMap);
      return;
    }
  }

  public String getName()
  {
    return "CameraRollManager";
  }

  @ReactMethod
  public void getPhotos(ReadableMap paramReadableMap, Promise paramPromise)
  {
    int i = paramReadableMap.getInt("first");
    String str1;
    String str2;
    label56: String str3;
    if (paramReadableMap.hasKey("after"))
    {
      str1 = paramReadableMap.getString("after");
      if (!paramReadableMap.hasKey("groupName"))
        break label131;
      str2 = paramReadableMap.getString("groupName");
      if (!paramReadableMap.hasKey("assetType"))
        break label137;
      str3 = paramReadableMap.getString("assetType");
      label79: if (!paramReadableMap.hasKey("mimeTypes"))
        break label143;
    }
    label131: label137: label143: for (ReadableArray localReadableArray = paramReadableMap.getArray("mimeTypes"); ; localReadableArray = null)
    {
      if (!paramReadableMap.hasKey("groupTypes"))
        break label149;
      throw new JSApplicationIllegalArgumentException("groupTypes is not supported on Android");
      str1 = null;
      break;
      str2 = null;
      break label56;
      str3 = null;
      break label79;
    }
    label149: new GetPhotosTask(getReactApplicationContext(), i, str1, str2, localReadableArray, str3, paramPromise, null).executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new Void[0]);
  }

  @ReactMethod
  public void saveToCameraRoll(String paramString1, String paramString2, Promise paramPromise)
  {
    new SaveToCameraRoll(getReactApplicationContext(), Uri.parse(paramString1), paramPromise).executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new Void[0]);
  }

  private static class GetPhotosTask extends GuardedAsyncTask<Void, Void>
  {

    @Nullable
    private final String mAfter;

    @Nullable
    private final String mAssetType;
    private final Context mContext;
    private final int mFirst;

    @Nullable
    private final String mGroupName;

    @Nullable
    private final ReadableArray mMimeTypes;
    private final Promise mPromise;

    private GetPhotosTask(ReactContext paramReactContext, int paramInt, @Nullable String paramString1, @Nullable String paramString2, @Nullable ReadableArray paramReadableArray, @Nullable String paramString3, Promise paramPromise)
    {
      super();
      this.mContext = paramReactContext;
      this.mFirst = paramInt;
      this.mAfter = paramString1;
      this.mGroupName = paramString2;
      this.mMimeTypes = paramReadableArray;
      this.mPromise = paramPromise;
      this.mAssetType = paramString3;
    }

    // ERROR //
    protected void doInBackgroundGuarded(Void[] paramArrayOfVoid)
    {
      // Byte code:
      //   0: new 56	java/lang/StringBuilder
      //   3: dup
      //   4: ldc 58
      //   6: invokespecial 61	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
      //   9: astore 5
      //   11: new 63	java/util/ArrayList
      //   14: dup
      //   15: invokespecial 66	java/util/ArrayList:<init>	()V
      //   18: astore 6
      //   20: aload_0
      //   21: getfield 32	com/facebook/react/modules/camera/CameraRollManager$GetPhotosTask:mAfter	Ljava/lang/String;
      //   24: invokestatic 72	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
      //   27: ifne +23 -> 50
      //   30: aload 5
      //   32: ldc 74
      //   34: invokevirtual 78	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   37: pop
      //   38: aload 6
      //   40: aload_0
      //   41: getfield 32	com/facebook/react/modules/camera/CameraRollManager$GetPhotosTask:mAfter	Ljava/lang/String;
      //   44: invokeinterface 84 2 0
      //   49: pop
      //   50: aload_0
      //   51: getfield 34	com/facebook/react/modules/camera/CameraRollManager$GetPhotosTask:mGroupName	Ljava/lang/String;
      //   54: invokestatic 72	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
      //   57: ifne +23 -> 80
      //   60: aload 5
      //   62: ldc 86
      //   64: invokevirtual 78	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   67: pop
      //   68: aload 6
      //   70: aload_0
      //   71: getfield 34	com/facebook/react/modules/camera/CameraRollManager$GetPhotosTask:mGroupName	Ljava/lang/String;
      //   74: invokeinterface 84 2 0
      //   79: pop
      //   80: aload_0
      //   81: getfield 36	com/facebook/react/modules/camera/CameraRollManager$GetPhotosTask:mMimeTypes	Lcom/facebook/react/bridge/ReadableArray;
      //   84: ifnull +91 -> 175
      //   87: aload_0
      //   88: getfield 36	com/facebook/react/modules/camera/CameraRollManager$GetPhotosTask:mMimeTypes	Lcom/facebook/react/bridge/ReadableArray;
      //   91: invokeinterface 92 1 0
      //   96: ifle +79 -> 175
      //   99: aload 5
      //   101: ldc 94
      //   103: invokevirtual 78	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   106: pop
      //   107: iconst_0
      //   108: istore_2
      //   109: iload_2
      //   110: aload_0
      //   111: getfield 36	com/facebook/react/modules/camera/CameraRollManager$GetPhotosTask:mMimeTypes	Lcom/facebook/react/bridge/ReadableArray;
      //   114: invokeinterface 92 1 0
      //   119: if_icmpge +36 -> 155
      //   122: aload 5
      //   124: ldc 96
      //   126: invokevirtual 78	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   129: pop
      //   130: aload 6
      //   132: aload_0
      //   133: getfield 36	com/facebook/react/modules/camera/CameraRollManager$GetPhotosTask:mMimeTypes	Lcom/facebook/react/bridge/ReadableArray;
      //   136: iload_2
      //   137: invokeinterface 100 2 0
      //   142: invokeinterface 84 2 0
      //   147: pop
      //   148: iload_2
      //   149: iconst_1
      //   150: iadd
      //   151: istore_2
      //   152: goto -43 -> 109
      //   155: aload 5
      //   157: aload 5
      //   159: invokevirtual 103	java/lang/StringBuilder:length	()I
      //   162: iconst_1
      //   163: isub
      //   164: aload 5
      //   166: invokevirtual 103	java/lang/StringBuilder:length	()I
      //   169: ldc 105
      //   171: invokevirtual 109	java/lang/StringBuilder:replace	(IILjava/lang/String;)Ljava/lang/StringBuilder;
      //   174: pop
      //   175: new 111	com/facebook/react/bridge/WritableNativeMap
      //   178: dup
      //   179: invokespecial 112	com/facebook/react/bridge/WritableNativeMap:<init>	()V
      //   182: astore_3
      //   183: aload_0
      //   184: getfield 28	com/facebook/react/modules/camera/CameraRollManager$GetPhotosTask:mContext	Landroid/content/Context;
      //   187: invokevirtual 118	android/content/Context:getContentResolver	()Landroid/content/ContentResolver;
      //   190: astore 4
      //   192: aload_0
      //   193: getfield 40	com/facebook/react/modules/camera/CameraRollManager$GetPhotosTask:mAssetType	Ljava/lang/String;
      //   196: ifnull +96 -> 292
      //   199: aload_0
      //   200: getfield 40	com/facebook/react/modules/camera/CameraRollManager$GetPhotosTask:mAssetType	Ljava/lang/String;
      //   203: ldc 120
      //   205: invokevirtual 125	java/lang/String:equals	(Ljava/lang/Object;)Z
      //   208: ifeq +84 -> 292
      //   211: getstatic 131	android/provider/MediaStore$Video$Media:EXTERNAL_CONTENT_URI	Landroid/net/Uri;
      //   214: astore_1
      //   215: aload 4
      //   217: aload_1
      //   218: invokestatic 135	com/facebook/react/modules/camera/CameraRollManager:access$200	()[Ljava/lang/String;
      //   221: aload 5
      //   223: invokevirtual 139	java/lang/StringBuilder:toString	()Ljava/lang/String;
      //   226: aload 6
      //   228: aload 6
      //   230: invokeinterface 140 1 0
      //   235: anewarray 122	java/lang/String
      //   238: invokeinterface 144 2 0
      //   243: checkcast 146	[Ljava/lang/String;
      //   246: new 56	java/lang/StringBuilder
      //   249: dup
      //   250: invokespecial 147	java/lang/StringBuilder:<init>	()V
      //   253: ldc 149
      //   255: invokevirtual 78	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   258: aload_0
      //   259: getfield 30	com/facebook/react/modules/camera/CameraRollManager$GetPhotosTask:mFirst	I
      //   262: iconst_1
      //   263: iadd
      //   264: invokevirtual 152	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
      //   267: invokevirtual 139	java/lang/StringBuilder:toString	()Ljava/lang/String;
      //   270: invokevirtual 158	android/content/ContentResolver:query	(Landroid/net/Uri;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
      //   273: astore_1
      //   274: aload_1
      //   275: ifnonnull +24 -> 299
      //   278: aload_0
      //   279: getfield 38	com/facebook/react/modules/camera/CameraRollManager$GetPhotosTask:mPromise	Lcom/facebook/react/bridge/Promise;
      //   282: ldc 160
      //   284: ldc 162
      //   286: invokeinterface 168 3 0
      //   291: return
      //   292: getstatic 171	android/provider/MediaStore$Images$Media:EXTERNAL_CONTENT_URI	Landroid/net/Uri;
      //   295: astore_1
      //   296: goto -81 -> 215
      //   299: aload 4
      //   301: aload_1
      //   302: aload_3
      //   303: aload_0
      //   304: getfield 30	com/facebook/react/modules/camera/CameraRollManager$GetPhotosTask:mFirst	I
      //   307: aload_0
      //   308: getfield 40	com/facebook/react/modules/camera/CameraRollManager$GetPhotosTask:mAssetType	Ljava/lang/String;
      //   311: invokestatic 175	com/facebook/react/modules/camera/CameraRollManager:access$300	(Landroid/content/ContentResolver;Landroid/database/Cursor;Lcom/facebook/react/bridge/WritableMap;ILjava/lang/String;)V
      //   314: aload_1
      //   315: aload_3
      //   316: aload_0
      //   317: getfield 30	com/facebook/react/modules/camera/CameraRollManager$GetPhotosTask:mFirst	I
      //   320: invokestatic 179	com/facebook/react/modules/camera/CameraRollManager:access$400	(Landroid/database/Cursor;Lcom/facebook/react/bridge/WritableMap;I)V
      //   323: aload_1
      //   324: invokeinterface 184 1 0
      //   329: aload_0
      //   330: getfield 38	com/facebook/react/modules/camera/CameraRollManager$GetPhotosTask:mPromise	Lcom/facebook/react/bridge/Promise;
      //   333: aload_3
      //   334: invokeinterface 188 2 0
      //   339: return
      //   340: astore_1
      //   341: aload_0
      //   342: getfield 38	com/facebook/react/modules/camera/CameraRollManager$GetPhotosTask:mPromise	Lcom/facebook/react/bridge/Promise;
      //   345: ldc 190
      //   347: ldc 192
      //   349: aload_1
      //   350: invokeinterface 195 4 0
      //   355: return
      //   356: astore 4
      //   358: aload_1
      //   359: invokeinterface 184 1 0
      //   364: aload_0
      //   365: getfield 38	com/facebook/react/modules/camera/CameraRollManager$GetPhotosTask:mPromise	Lcom/facebook/react/bridge/Promise;
      //   368: aload_3
      //   369: invokeinterface 188 2 0
      //   374: aload 4
      //   376: athrow
      //
      // Exception table:
      //   from	to	target	type
      //   192	215	340	java/lang/SecurityException
      //   215	274	340	java/lang/SecurityException
      //   278	291	340	java/lang/SecurityException
      //   292	296	340	java/lang/SecurityException
      //   323	339	340	java/lang/SecurityException
      //   358	377	340	java/lang/SecurityException
      //   299	323	356	finally
    }
  }

  private static class SaveToCameraRoll extends GuardedAsyncTask<Void, Void>
  {
    private final Context mContext;
    private final Promise mPromise;
    private final Uri mUri;

    public SaveToCameraRoll(ReactContext paramReactContext, Uri paramUri, Promise paramPromise)
    {
      super();
      this.mContext = paramReactContext;
      this.mUri = paramUri;
      this.mPromise = paramPromise;
    }

    protected void doInBackgroundGuarded(Void[] paramArrayOfVoid)
    {
      File localFile2 = new File(this.mUri.getPath());
      Object localObject9 = null;
      Object localObject8 = null;
      String str = null;
      Context localContext = null;
      Object localObject2 = localContext;
      Object localObject4 = localObject8;
      paramArrayOfVoid = str;
      Object localObject1 = localObject9;
      try
      {
        File localFile1 = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DCIM);
        localObject2 = localContext;
        localObject4 = localObject8;
        paramArrayOfVoid = str;
        localObject1 = localObject9;
        localFile1.mkdirs();
        localObject2 = localContext;
        localObject4 = localObject8;
        paramArrayOfVoid = str;
        localObject1 = localObject9;
        if (!localFile1.isDirectory())
        {
          localObject2 = localContext;
          localObject4 = localObject8;
          paramArrayOfVoid = str;
          localObject1 = localObject9;
          this.mPromise.reject("E_UNABLE_TO_LOAD", "External media storage directory not available");
          if (0 != 0)
            throw new NullPointerException();
          if (0 != 0)
            throw new NullPointerException();
        }
        while (true)
        {
          return;
          localObject2 = localContext;
          localObject4 = localObject8;
          paramArrayOfVoid = str;
          localObject1 = localObject9;
          Object localObject5 = new File(localFile1, localFile2.getName());
          localObject2 = localContext;
          localObject4 = localObject8;
          paramArrayOfVoid = str;
          localObject1 = localObject9;
          localObject6 = localFile2.getName();
          localObject2 = localContext;
          localObject4 = localObject8;
          paramArrayOfVoid = str;
          localObject1 = localObject9;
          if (((String)localObject6).indexOf('.') >= 0)
          {
            localObject2 = localContext;
            localObject4 = localObject8;
            paramArrayOfVoid = str;
            localObject1 = localObject9;
            localObject7 = ((String)localObject6).substring(0, ((String)localObject6).lastIndexOf('.'));
            localObject2 = localContext;
            localObject4 = localObject8;
            paramArrayOfVoid = str;
            localObject1 = localObject9;
            localObject6 = ((String)localObject6).substring(((String)localObject6).lastIndexOf('.'));
            i = 0;
            while (true)
            {
              localObject2 = localContext;
              localObject4 = localObject8;
              paramArrayOfVoid = str;
              localObject1 = localObject9;
              if (((File)localObject5).createNewFile())
                break;
              localObject2 = localContext;
              localObject4 = localObject8;
              paramArrayOfVoid = str;
              localObject1 = localObject9;
              localObject5 = new File(localFile1, (String)localObject7 + "_" + i + (String)localObject6);
              i += 1;
            }
            localObject2 = localContext;
            localObject4 = localObject8;
            paramArrayOfVoid = str;
            localObject1 = localObject9;
            localObject6 = new FileInputStream(localFile2).getChannel();
            localObject2 = localContext;
            localObject4 = localObject6;
            paramArrayOfVoid = str;
            localObject1 = localObject6;
            localObject7 = new FileOutputStream((File)localObject5).getChannel();
            localObject2 = localObject7;
            localObject4 = localObject6;
            paramArrayOfVoid = (Void)localObject7;
            localObject1 = localObject6;
            ((FileChannel)localObject7).transferFrom((ReadableByteChannel)localObject6, 0L, ((FileChannel)localObject6).size());
            localObject2 = localObject7;
            localObject4 = localObject6;
            paramArrayOfVoid = (Void)localObject7;
            localObject1 = localObject6;
            ((FileChannel)localObject6).close();
            localObject2 = localObject7;
            localObject4 = localObject6;
            paramArrayOfVoid = (Void)localObject7;
            localObject1 = localObject6;
            ((FileChannel)localObject7).close();
            localObject2 = localObject7;
            localObject4 = localObject6;
            paramArrayOfVoid = (Void)localObject7;
            localObject1 = localObject6;
            localContext = this.mContext;
            localObject2 = localObject7;
            localObject4 = localObject6;
            paramArrayOfVoid = (Void)localObject7;
            localObject1 = localObject6;
            str = ((File)localObject5).getAbsolutePath();
            localObject2 = localObject7;
            localObject4 = localObject6;
            paramArrayOfVoid = (Void)localObject7;
            localObject1 = localObject6;
            localObject5 = new MediaScannerConnection.OnScanCompletedListener()
            {
              public void onScanCompleted(String paramString, Uri paramUri)
              {
                if (paramUri != null)
                {
                  CameraRollManager.SaveToCameraRoll.this.mPromise.resolve(paramUri.toString());
                  return;
                }
                CameraRollManager.SaveToCameraRoll.this.mPromise.reject("E_UNABLE_TO_SAVE", "Could not add image to gallery");
              }
            };
            localObject2 = localObject7;
            localObject4 = localObject6;
            paramArrayOfVoid = (Void)localObject7;
            localObject1 = localObject6;
            MediaScannerConnection.scanFile(localContext, new String[] { str }, null, (MediaScannerConnection.OnScanCompletedListener)localObject5);
            if ((localObject6 != null) && (((FileChannel)localObject6).isOpen()));
            try
            {
              ((FileChannel)localObject6).close();
              if ((localObject7 == null) || (!((FileChannel)localObject7).isOpen()))
                continue;
              try
              {
                ((FileChannel)localObject7).close();
                return;
              }
              catch (IOException paramArrayOfVoid)
              {
                FLog.e("ReactNative", "Could not close output channel", paramArrayOfVoid);
                return;
              }
            }
            catch (IOException paramArrayOfVoid)
            {
              while (true)
                FLog.e("ReactNative", "Could not close input channel", paramArrayOfVoid);
            }
          }
        }
      }
      catch (IOException localIOException2)
      {
        while (true)
        {
          paramArrayOfVoid = (Void)localObject2;
          localObject1 = localObject4;
          this.mPromise.reject(localIOException2);
          if ((localObject4 != null) && (localObject4.isOpen()));
          try
          {
            localObject4.close();
            if ((localObject2 == null) || (!((FileChannel)localObject2).isOpen()))
              continue;
            try
            {
              ((FileChannel)localObject2).close();
              return;
            }
            catch (IOException paramArrayOfVoid)
            {
              FLog.e("ReactNative", "Could not close output channel", paramArrayOfVoid);
              return;
            }
          }
          catch (IOException paramArrayOfVoid)
          {
            while (true)
              FLog.e("ReactNative", "Could not close input channel", paramArrayOfVoid);
          }
        }
      }
      finally
      {
        while (true)
        {
          if ((localObject1 != null) && (localObject1.isOpen()));
          try
          {
            localObject1.close();
            if ((paramArrayOfVoid == null) || (!paramArrayOfVoid.isOpen()));
          }
          catch (IOException localIOException1)
          {
            try
            {
              paramArrayOfVoid.close();
              throw localObject3;
              localIOException1 = localIOException1;
              FLog.e("ReactNative", "Could not close input channel", localIOException1);
            }
            catch (IOException paramArrayOfVoid)
            {
              while (true)
                FLog.e("ReactNative", "Could not close output channel", paramArrayOfVoid);
            }
          }
          Object localObject7 = localObject6;
          Object localObject6 = "";
          int i = 0;
        }
      }
    }
  }
}

/* Location:           C:\Users\c_jealom1\Documents\Scripts\Android\Fathom_com.brynk.fathom\Fathom_com.brynk.fathom-dex2jar.jar
 * Qualified Name:     com.facebook.react.modules.camera.CameraRollManager
 * JD-Core Version:    0.6.0
 */
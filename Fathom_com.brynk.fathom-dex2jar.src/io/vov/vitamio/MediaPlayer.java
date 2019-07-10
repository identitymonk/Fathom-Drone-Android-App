package io.vov.vitamio;

import android.annotation.SuppressLint;
import android.content.ContentResolver;
import android.content.Context;
import android.content.res.AssetFileDescriptor;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.media.AudioTrack;
import android.net.Uri;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.ParcelFileDescriptor;
import android.os.PowerManager;
import android.os.PowerManager.WakeLock;
import android.text.TextUtils;
import android.util.SparseArray;
import android.view.Surface;
import android.view.SurfaceHolder;
import io.vov.vitamio.utils.FileUtils;
import io.vov.vitamio.utils.Log;
import java.io.File;
import java.io.FileDescriptor;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.charset.Charset;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.concurrent.atomic.AtomicBoolean;

public class MediaPlayer
{
  public static final int CACHE_INFO_NO_SPACE = 1;
  public static final int CACHE_INFO_STREAM_NOT_SUPPORT = 2;
  public static final int CACHE_TYPE_COMPLETE = 5;
  public static final int CACHE_TYPE_NOT_AVAILABLE = 1;
  public static final int CACHE_TYPE_SPEED = 4;
  public static final int CACHE_TYPE_START = 2;
  public static final int CACHE_TYPE_UPDATE = 3;
  private static final int MEDIA_BUFFERING_UPDATE = 3;
  private static final int MEDIA_CACHE = 300;
  private static final String MEDIA_CACHING_INFO = "caching_info";
  private static final String MEDIA_CACHING_SEGMENTS = "caching_segment";
  private static final String MEDIA_CACHING_TYPE = "caching_type";
  private static final int MEDIA_CACHING_UPDATE = 2000;
  private static final int MEDIA_ERROR = 100;
  public static final int MEDIA_ERROR_IO = -5;
  public static final int MEDIA_ERROR_MALFORMED = -1007;
  public static final int MEDIA_ERROR_NOT_VALID_FOR_PROGRESSIVE_PLAYBACK = 200;
  public static final int MEDIA_ERROR_TIMED_OUT = -110;
  public static final int MEDIA_ERROR_UNKNOWN = 1;
  public static final int MEDIA_ERROR_UNSUPPORTED = -1010;
  private static final int MEDIA_HW_ERROR = 400;
  private static final int MEDIA_INFO = 200;
  public static final int MEDIA_INFO_BUFFERING_END = 702;
  public static final int MEDIA_INFO_BUFFERING_START = 701;
  public static final int MEDIA_INFO_DOWNLOAD_RATE_CHANGED = 901;
  public static final int MEDIA_INFO_FILE_OPEN_OK = 704;
  public static final int MEDIA_INFO_GET_CODEC_INFO_ERROR = 1002;
  public static final int MEDIA_INFO_NOT_SEEKABLE = 801;
  public static final int MEDIA_INFO_UNKNOW_TYPE = 1001;
  public static final int MEDIA_INFO_VIDEO_TRACK_LAGGING = 700;
  private static final int MEDIA_NOP = 0;
  private static final int MEDIA_PLAYBACK_COMPLETE = 2;
  private static final int MEDIA_PREPARED = 1;
  private static final int MEDIA_SEEK_COMPLETE = 4;
  private static final int MEDIA_SET_VIDEO_SIZE = 5;
  private static final String MEDIA_SUBTITLE_BYTES = "sub_bytes";
  private static final String MEDIA_SUBTITLE_STRING = "sub_string";
  private static final String MEDIA_SUBTITLE_TYPE = "sub_type";
  private static final int MEDIA_TIMED_TEXT = 1000;
  private static AtomicBoolean NATIVE_OMX_LOADED;
  private static final int SUBTITLE_BITMAP = 1;
  public static final int SUBTITLE_EXTERNAL = 1;
  public static final int SUBTITLE_INTERNAL = 0;
  private static final int SUBTITLE_TEXT = 0;
  public static final String[] SUB_TYPES = { ".srt", ".ssa", ".smi", ".txt", ".sub", ".ass", ".webvtt" };
  public static final int VIDEOCHROMA_RGB565 = 0;
  public static final int VIDEOCHROMA_RGBA = 1;
  public static final int VIDEOQUALITY_HIGH = 16;
  public static final int VIDEOQUALITY_LOW = -16;
  public static final int VIDEOQUALITY_MEDIUM = 0;
  private static String path;
  int channels;
  private AudioTrack mAudioTrack;
  private int mAudioTrackBufferSize;
  private Bitmap mBitmap;
  private ByteBuffer mByteBuffer;
  private Context mContext;
  private EventHandler mEventHandler;
  private AssetFileDescriptor mFD = null;
  private boolean mInBuffering = false;
  private TrackInfo[] mInbandTracks;
  private Surface mLocalSurface;
  private Metadata mMeta;
  private boolean mNeedResume = false;
  private OnBufferingUpdateListener mOnBufferingUpdateListener;
  private OnCachingUpdateListener mOnCachingUpdateListener;
  private OnCompletionListener mOnCompletionListener;
  private OnErrorListener mOnErrorListener;
  private OnHWRenderFailedListener mOnHWRenderFailedListener;
  private OnInfoListener mOnInfoListener;
  private OnPreparedListener mOnPreparedListener;
  private OnSeekCompleteListener mOnSeekCompleteListener;
  private OnTimedTextListener mOnTimedTextListener;
  private OnVideoSizeChangedListener mOnVideoSizeChangedListener;
  private TrackInfo mOutOfBandTracks;
  private boolean mScreenOnWhilePlaying;
  private boolean mStayAwake;
  private Surface mSurface;
  private SurfaceHolder mSurfaceHolder;
  private PowerManager.WakeLock mWakeLock = null;
  int sampleRateInHz;

  static
  {
    NATIVE_OMX_LOADED = new AtomicBoolean(false);
    String str;
    if (Build.VERSION.SDK_INT > 20)
      str = "";
    try
    {
      load_lib(str, "libstlport_shared.so");
      load_lib(str, "libvplayer.so");
      loadFFmpeg_native_lib(str, "libffmpeg.so");
      boolean bool;
      if (Build.VERSION.SDK_INT > 8)
        bool = loadVVO_native_lib(str, "libvvo.9.so");
      while (true)
      {
        if (!bool)
        {
          bool = loadVAO_native_lib(str, "libvvo.j.so");
          Log.d("FALLBACK TO VVO JNI " + bool, new Object[0]);
        }
        loadVAO_native_lib(str, "libvao.0.so");
        return;
        str = Vitamio.getLibraryPath();
        break;
        if (Build.VERSION.SDK_INT > 7)
        {
          bool = loadVVO_native_lib(str, "libvvo.8.so");
          continue;
        }
        bool = loadVVO_native_lib(str, "libvvo.7.so");
      }
    }
    catch (UnsatisfiedLinkError localUnsatisfiedLinkError)
    {
      Log.e("Error loading libs", localUnsatisfiedLinkError);
    }
  }

  public MediaPlayer(Context paramContext)
  {
    this(paramContext, false);
  }

  public MediaPlayer(Context paramContext, boolean paramBoolean)
  {
    this.mContext = paramContext;
    if (Build.VERSION.SDK_INT > 20)
    {
      paramContext = "";
      if (!paramBoolean)
        break label159;
      if (!NATIVE_OMX_LOADED.get())
      {
        if (Build.VERSION.SDK_INT <= 17)
          break label110;
        load_omxnative_lib(paramContext, "libOMX.18.so");
        label69: NATIVE_OMX_LOADED.set(true);
      }
      paramContext = Looper.myLooper();
      if (paramContext == null)
        break label193;
      this.mEventHandler = new EventHandler(this, paramContext);
    }
    while (true)
    {
      while (true)
      {
        native_init();
        return;
        paramContext = Vitamio.getLibraryPath();
        break;
        label110: if (Build.VERSION.SDK_INT > 13)
        {
          load_omxnative_lib(paramContext, "libOMX.14.so");
          break label69;
        }
        if (Build.VERSION.SDK_INT > 10)
        {
          load_omxnative_lib(paramContext, "libOMX.11.so");
          break label69;
        }
        load_omxnative_lib(paramContext, "libOMX.9.so");
        break label69;
        try
        {
          label159: unloadOMX_native();
          NATIVE_OMX_LOADED.set(false);
        }
        catch (UnsatisfiedLinkError paramContext)
        {
          while (true)
            Log.e("unloadOMX failed %s", new Object[] { paramContext.toString() });
        }
      }
      label193: paramContext = Looper.getMainLooper();
      if (paramContext != null)
      {
        this.mEventHandler = new EventHandler(this, paramContext);
        continue;
      }
      this.mEventHandler = null;
    }
  }

  private native void _pause()
    throws IllegalStateException;

  private native void _release();

  private native void _reset();

  private native void _setDataSegmentsSource(String[] paramArrayOfString, String paramString);

  private native void _setDataSource(String paramString, String[] paramArrayOfString1, String[] paramArrayOfString2)
    throws IOException, IllegalArgumentException, IllegalStateException;

  private native void _setVideoSurface(Surface paramSurface);

  private native void _start()
    throws IllegalStateException;

  private native void _stop()
    throws IllegalStateException;

  @SuppressLint({"NewApi"})
  private int audioTrackInit(int paramInt1, int paramInt2)
  {
    this.sampleRateInHz = paramInt1;
    this.channels = paramInt2;
    return 0;
  }

  private void audioTrackPause()
  {
    if ((this.mAudioTrack != null) && (this.mAudioTrack.getState() == 1))
      this.mAudioTrack.pause();
  }

  private void audioTrackRelease()
  {
    if (this.mAudioTrack != null)
    {
      if (this.mAudioTrack.getState() == 1)
        this.mAudioTrack.stop();
      this.mAudioTrack.release();
    }
    this.mAudioTrack = null;
  }

  private void audioTrackSetVolume(float paramFloat1, float paramFloat2)
  {
    if (this.mAudioTrack != null)
      this.mAudioTrack.setStereoVolume(paramFloat1, paramFloat2);
  }

  private void audioTrackStart()
  {
    if ((this.mAudioTrack != null) && (this.mAudioTrack.getState() == 1) && (this.mAudioTrack.getPlayState() != 3))
      this.mAudioTrack.play();
  }

  private void audioTrackWrite(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    if ((this.mAudioTrack != null) && (this.mAudioTrack.getPlayState() == 3))
      if (paramInt2 > 0)
      {
        if (paramInt2 > this.mAudioTrackBufferSize);
        for (int i = this.mAudioTrackBufferSize; ; i = paramInt2)
        {
          this.mAudioTrack.write(paramArrayOfByte, paramInt1, i);
          paramInt2 -= i;
          paramInt1 += i;
          break;
        }
      }
  }

  private void closeFD()
  {
    if (this.mFD != null);
    try
    {
      this.mFD.close();
      this.mFD = null;
      return;
    }
    catch (IOException localIOException)
    {
      while (true)
        Log.e("closeFD", localIOException);
    }
  }

  private TrackInfo[] getInbandTrackInfo(String paramString)
  {
    if (this.mInbandTracks == null)
    {
      SparseArray localSparseArray = new SparseArray();
      if (!native_getTrackInfo(localSparseArray))
        return null;
      int j = localSparseArray.size();
      this.mInbandTracks = new TrackInfo[j];
      int i = 0;
      while (i < j)
      {
        Object localObject = parseTrackInfo((byte[])localSparseArray.valueAt(i), paramString);
        localObject = new TrackInfo(localSparseArray.keyAt(i), (SparseArray)localObject);
        this.mInbandTracks[i] = localObject;
        i += 1;
      }
    }
    return (TrackInfo)this.mInbandTracks;
  }

  private native int getVideoHeight_a();

  private native int getVideoWidth_a();

  private static native boolean loadFFmpeg_native(String paramString);

  private static boolean loadFFmpeg_native_lib(String paramString1, String paramString2)
  {
    if (paramString1 == "")
      return loadFFmpeg_native(paramString2);
    return loadFFmpeg_native(paramString1 + paramString2);
  }

  private static native boolean loadOMX_native(String paramString);

  private static native boolean loadVAO_native(String paramString);

  private static boolean loadVAO_native_lib(String paramString1, String paramString2)
  {
    if (paramString1 == "")
      return loadVAO_native(paramString2);
    return loadVAO_native(paramString1 + paramString2);
  }

  private static native boolean loadVVO_native(String paramString);

  private static boolean loadVVO_native_lib(String paramString1, String paramString2)
  {
    if (paramString1 == "")
      return loadVVO_native(paramString2);
    return loadVVO_native(paramString1 + paramString2);
  }

  private static boolean load_lib(String paramString1, String paramString2)
  {
    if (paramString1 == "")
      System.load(paramString2);
    while (true)
    {
      return true;
      System.load(paramString1 + paramString2);
    }
  }

  private static boolean load_omxnative_lib(String paramString1, String paramString2)
  {
    if (paramString1 == "")
      return loadOMX_native(paramString2);
    return loadOMX_native(paramString1 + paramString2);
  }

  private final native void native_finalize();

  private final native boolean native_getMetadata(Map<byte[], byte[]> paramMap);

  private final native boolean native_getTrackInfo(SparseArray<byte[]> paramSparseArray);

  private final native void native_init();

  // ERROR //
  private SparseArray<MediaFormat> parseTrackInfo(byte[] paramArrayOfByte, String paramString)
  {
    // Byte code:
    //   0: iconst_0
    //   1: istore_3
    //   2: new 484	android/util/SparseArray
    //   5: dup
    //   6: invokespecial 485	android/util/SparseArray:<init>	()V
    //   9: astore 6
    //   11: new 192	java/lang/String
    //   14: dup
    //   15: aload_1
    //   16: aload_2
    //   17: invokespecial 540	java/lang/String:<init>	([BLjava/lang/String;)V
    //   20: astore_2
    //   21: aload_2
    //   22: astore_1
    //   23: aload_1
    //   24: ldc_w 542
    //   27: invokevirtual 546	java/lang/String:split	(Ljava/lang/String;)[Ljava/lang/String;
    //   30: astore_2
    //   31: aload_2
    //   32: arraylength
    //   33: istore 4
    //   35: iload_3
    //   36: iload 4
    //   38: if_icmpge +114 -> 152
    //   41: aload_2
    //   42: iload_3
    //   43: aaload
    //   44: astore 7
    //   46: aconst_null
    //   47: astore_1
    //   48: aload 7
    //   50: ldc_w 548
    //   53: invokevirtual 546	java/lang/String:split	(Ljava/lang/String;)[Ljava/lang/String;
    //   56: astore 7
    //   58: aload 7
    //   60: ifnonnull +33 -> 93
    //   63: iload_3
    //   64: iconst_1
    //   65: iadd
    //   66: istore_3
    //   67: goto -32 -> 35
    //   70: astore_2
    //   71: ldc_w 550
    //   74: iconst_0
    //   75: anewarray 4	java/lang/Object
    //   78: invokestatic 342	io/vov/vitamio/utils/Log:e	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   81: new 192	java/lang/String
    //   84: dup
    //   85: aload_1
    //   86: invokespecial 553	java/lang/String:<init>	([B)V
    //   89: astore_1
    //   90: goto -67 -> 23
    //   93: aload 7
    //   95: iconst_0
    //   96: aaload
    //   97: invokestatic 559	java/lang/Integer:parseInt	(Ljava/lang/String;)I
    //   100: istore 5
    //   102: aload 7
    //   104: arraylength
    //   105: iconst_3
    //   106: if_icmpne +26 -> 132
    //   109: aload 7
    //   111: iconst_2
    //   112: aaload
    //   113: aload 7
    //   115: iconst_1
    //   116: aaload
    //   117: invokestatic 565	io/vov/vitamio/MediaFormat:createSubtitleFormat	(Ljava/lang/String;Ljava/lang/String;)Lio/vov/vitamio/MediaFormat;
    //   120: astore_1
    //   121: aload 6
    //   123: iload 5
    //   125: aload_1
    //   126: invokevirtual 569	android/util/SparseArray:put	(ILjava/lang/Object;)V
    //   129: goto -66 -> 63
    //   132: aload 7
    //   134: arraylength
    //   135: iconst_2
    //   136: if_icmpne -15 -> 121
    //   139: ldc 223
    //   141: aload 7
    //   143: iconst_1
    //   144: aaload
    //   145: invokestatic 565	io/vov/vitamio/MediaFormat:createSubtitleFormat	(Ljava/lang/String;Ljava/lang/String;)Lio/vov/vitamio/MediaFormat;
    //   148: astore_1
    //   149: goto -28 -> 121
    //   152: aload 6
    //   154: areturn
    //   155: astore_1
    //   156: goto -93 -> 63
    //
    // Exception table:
    //   from	to	target	type
    //   11	21	70	java/lang/Exception
    //   48	58	155	java/lang/NumberFormatException
    //   93	121	155	java/lang/NumberFormatException
    //   121	129	155	java/lang/NumberFormatException
    //   132	149	155	java/lang/NumberFormatException
  }

  private static void postEventFromNative(Object paramObject1, int paramInt1, int paramInt2, int paramInt3, Object paramObject2)
  {
    paramObject1 = (MediaPlayer)(MediaPlayer)paramObject1;
    if (paramObject1 == null);
    while (true)
    {
      return;
      try
      {
        if (paramObject1.mEventHandler == null)
          continue;
        paramObject2 = paramObject1.mEventHandler.obtainMessage(paramInt1, paramInt2, paramInt3, paramObject2);
        paramObject1.mEventHandler.sendMessage(paramObject2);
        return;
      }
      catch (Exception paramObject1)
      {
        Log.e("exception: " + paramObject1, new Object[0]);
      }
    }
  }

  private void selectOrDeselectBandTrack(int paramInt, boolean paramBoolean)
  {
    if (this.mOutOfBandTracks != null)
    {
      Object localObject = this.mOutOfBandTracks.getTrackInfoArray();
      int i = ((SparseArray)localObject).keyAt(0);
      localObject = (MediaFormat)((SparseArray)localObject).valueAt(0);
      if ((paramInt == i) && (paramBoolean))
      {
        addTimedTextSource(((MediaFormat)localObject).getString("path"));
        return;
      }
    }
    selectOrDeselectTrack(paramInt, paramBoolean);
  }

  private native void selectOrDeselectTrack(int paramInt, boolean paramBoolean);

  @SuppressLint({"Wakelock"})
  private void stayAwake(boolean paramBoolean)
  {
    if (this.mWakeLock != null)
    {
      if ((!paramBoolean) || (this.mWakeLock.isHeld()))
        break label38;
      this.mWakeLock.acquire();
    }
    while (true)
    {
      this.mStayAwake = paramBoolean;
      updateSurfaceScreenOn();
      return;
      label38: if ((paramBoolean) || (!this.mWakeLock.isHeld()))
        continue;
      this.mWakeLock.release();
    }
  }

  private ByteBuffer surfaceInit()
  {
    monitorenter;
    try
    {
      this.mLocalSurface = this.mSurface;
      int i = getVideoWidth_a();
      int j = getVideoHeight_a();
      if ((this.mLocalSurface != null) && (i != 0) && (j != 0))
        this.mBitmap = Bitmap.createBitmap(i, j, Bitmap.Config.RGB_565);
      for (this.mByteBuffer = ByteBuffer.allocateDirect(i * j * 2); ; this.mByteBuffer = null)
      {
        ByteBuffer localByteBuffer = this.mByteBuffer;
        return localByteBuffer;
        this.mBitmap = null;
      }
    }
    finally
    {
      monitorexit;
    }
    throw localObject;
  }

  private void surfaceRelease()
  {
    monitorenter;
    try
    {
      this.mLocalSurface = null;
      this.mBitmap = null;
      this.mByteBuffer = null;
      return;
    }
    finally
    {
      monitorexit;
    }
    throw localObject;
  }

  // ERROR //
  private void surfaceRender()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 626	io/vov/vitamio/MediaPlayer:mLocalSurface	Landroid/view/Surface;
    //   6: ifnull +27 -> 33
    //   9: aload_0
    //   10: getfield 626	io/vov/vitamio/MediaPlayer:mLocalSurface	Landroid/view/Surface;
    //   13: invokevirtual 659	android/view/Surface:isValid	()Z
    //   16: ifeq +17 -> 33
    //   19: aload_0
    //   20: getfield 644	io/vov/vitamio/MediaPlayer:mBitmap	Landroid/graphics/Bitmap;
    //   23: ifnull +10 -> 33
    //   26: aload_0
    //   27: getfield 652	io/vov/vitamio/MediaPlayer:mByteBuffer	Ljava/nio/ByteBuffer;
    //   30: ifnonnull +6 -> 36
    //   33: aload_0
    //   34: monitorexit
    //   35: return
    //   36: aload_0
    //   37: getfield 626	io/vov/vitamio/MediaPlayer:mLocalSurface	Landroid/view/Surface;
    //   40: aconst_null
    //   41: invokevirtual 663	android/view/Surface:lockCanvas	(Landroid/graphics/Rect;)Landroid/graphics/Canvas;
    //   44: astore_1
    //   45: aload_0
    //   46: getfield 644	io/vov/vitamio/MediaPlayer:mBitmap	Landroid/graphics/Bitmap;
    //   49: aload_0
    //   50: getfield 652	io/vov/vitamio/MediaPlayer:mByteBuffer	Ljava/nio/ByteBuffer;
    //   53: invokevirtual 667	android/graphics/Bitmap:copyPixelsFromBuffer	(Ljava/nio/Buffer;)V
    //   56: aload_1
    //   57: aload_0
    //   58: getfield 644	io/vov/vitamio/MediaPlayer:mBitmap	Landroid/graphics/Bitmap;
    //   61: fconst_0
    //   62: fconst_0
    //   63: aconst_null
    //   64: invokevirtual 673	android/graphics/Canvas:drawBitmap	(Landroid/graphics/Bitmap;FFLandroid/graphics/Paint;)V
    //   67: aload_0
    //   68: getfield 626	io/vov/vitamio/MediaPlayer:mLocalSurface	Landroid/view/Surface;
    //   71: aload_1
    //   72: invokevirtual 677	android/view/Surface:unlockCanvasAndPost	(Landroid/graphics/Canvas;)V
    //   75: aload_0
    //   76: monitorexit
    //   77: return
    //   78: astore_1
    //   79: aload_0
    //   80: monitorexit
    //   81: aload_1
    //   82: athrow
    //   83: astore_1
    //   84: ldc_w 678
    //   87: aload_1
    //   88: invokestatic 286	io/vov/vitamio/utils/Log:e	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   91: goto -16 -> 75
    //
    // Exception table:
    //   from	to	target	type
    //   2	33	78	finally
    //   33	35	78	finally
    //   36	75	78	finally
    //   75	77	78	finally
    //   79	81	78	finally
    //   84	91	78	finally
    //   36	75	83	java/lang/Exception
  }

  private static native void unloadOMX_native();

  private void updateCacheStatus(int paramInt1, int paramInt2, long[] paramArrayOfLong)
  {
    if (this.mEventHandler != null)
    {
      Message localMessage = this.mEventHandler.obtainMessage(2000);
      Bundle localBundle = localMessage.getData();
      localBundle.putInt("caching_type", paramInt1);
      localBundle.putInt("caching_info", paramInt2);
      localBundle.putLongArray("caching_segment", paramArrayOfLong);
      this.mEventHandler.sendMessage(localMessage);
    }
  }

  private void updateSub(int paramInt1, byte[] paramArrayOfByte, String paramString, int paramInt2, int paramInt3)
  {
    Message localMessage;
    Bundle localBundle;
    if (this.mEventHandler != null)
    {
      localMessage = this.mEventHandler.obtainMessage(1000, paramInt2, paramInt3);
      localBundle = localMessage.getData();
      if (paramInt1 != 0)
        break label120;
      localBundle.putInt("sub_type", 0);
      if (paramString != null)
        break label72;
      localBundle.putString("sub_string", new String(paramArrayOfByte));
    }
    while (true)
    {
      this.mEventHandler.sendMessage(localMessage);
      return;
      try
      {
        label72: localBundle.putString("sub_string", new String(paramArrayOfByte, paramString.trim()));
      }
      catch (java.io.UnsupportedEncodingException paramString)
      {
        Log.e("updateSub", paramString);
        localBundle.putString("sub_string", new String(paramArrayOfByte));
      }
      continue;
      label120: if (paramInt1 != 1)
        continue;
      localBundle.putInt("sub_type", 1);
      localBundle.putByteArray("sub_bytes", paramArrayOfByte);
    }
  }

  private void updateSurfaceScreenOn()
  {
    SurfaceHolder localSurfaceHolder;
    if (this.mSurfaceHolder != null)
    {
      localSurfaceHolder = this.mSurfaceHolder;
      if ((!this.mScreenOnWhilePlaying) || (!this.mStayAwake))
        break label36;
    }
    label36: for (boolean bool = true; ; bool = false)
    {
      localSurfaceHolder.setKeepScreenOn(bool);
      return;
    }
  }

  protected native void _releaseVideoSurface();

  public native void addTimedTextSource(String paramString);

  public native void audioInitedOk(long paramLong);

  public int audioTrackInit()
  {
    audioTrackRelease();
    int i;
    if (this.channels >= 2)
      i = 12;
    try
    {
      while (true)
      {
        this.mAudioTrackBufferSize = AudioTrack.getMinBufferSize(this.sampleRateInHz, i, 2);
        this.mAudioTrack = new AudioTrack(3, this.sampleRateInHz, i, 2, this.mAudioTrackBufferSize, 1);
        return this.mAudioTrackBufferSize;
        i = 4;
      }
    }
    catch (Exception localException)
    {
      while (true)
      {
        this.mAudioTrackBufferSize = 0;
        Log.e("audioTrackInit", localException);
      }
    }
  }

  public void deselectTrack(int paramInt)
  {
    selectOrDeselectBandTrack(paramInt, false);
  }

  protected void finalize()
  {
    native_finalize();
  }

  public SparseArray<MediaFormat> findTrackFromTrackInfo(int paramInt, TrackInfo[] paramArrayOfTrackInfo)
  {
    int i = 0;
    while (i < paramArrayOfTrackInfo.length)
    {
      if (paramArrayOfTrackInfo[i].getTrackType() == paramInt)
        return paramArrayOfTrackInfo[i].getTrackInfoArray();
      i += 1;
    }
    return null;
  }

  public int getAudioSessionId()
  {
    return this.mAudioTrack.getAudioSessionId();
  }

  public native int getAudioTrack();

  public native int getBufferProgress();

  public native Bitmap getCurrentFrame();

  public native long getCurrentPosition();

  public native long getDuration();

  public native String getMetaEncoding();

  public Metadata getMetadata()
  {
    if (this.mMeta == null)
    {
      this.mMeta = new Metadata();
      HashMap localHashMap = new HashMap();
      if (!native_getMetadata(localHashMap));
      do
        return null;
      while (!this.mMeta.parse(localHashMap, getMetaEncoding()));
    }
    return this.mMeta;
  }

  public native int getTimedTextLocation();

  public native String getTimedTextPath();

  public native int getTimedTextTrack();

  public TrackInfo[] getTrackInfo()
  {
    return getTrackInfo(Charset.defaultCharset().name());
  }

  public TrackInfo[] getTrackInfo(String paramString)
  {
    Object localObject = getInbandTrackInfo(paramString);
    String str = getTimedTextPath();
    if (TextUtils.isEmpty(str))
      return localObject;
    paramString = new TrackInfo[localObject.length + 1];
    System.arraycopy(localObject, 0, paramString, 0, localObject.length);
    int i = localObject.length;
    SparseArray localSparseArray = new SparseArray();
    MediaFormat localMediaFormat = new MediaFormat();
    localMediaFormat.setString("title", str.substring(str.lastIndexOf("/")));
    localMediaFormat.setString("path", str);
    localObject = findTrackFromTrackInfo(3, localObject);
    if ((localObject == null) || (((SparseArray)localObject).size() == 0))
      localSparseArray.put(((SparseArray)localObject).keyAt(0), localMediaFormat);
    while (true)
    {
      this.mOutOfBandTracks = new TrackInfo(4, localSparseArray);
      paramString[i] = this.mOutOfBandTracks;
      return paramString;
      localSparseArray.put(((SparseArray)localObject).keyAt(((SparseArray)localObject).size() - 1), localMediaFormat);
    }
  }

  public native float getVideoAspectRatio();

  public native int getVideoHeight();

  public native int getVideoTrack();

  public native int getVideoWidth();

  public native boolean isBuffering();

  public native boolean isLooping();

  public native boolean isPlaying();

  public void pause()
    throws IllegalStateException
  {
    stayAwake(false);
    this.mNeedResume = false;
    _pause();
  }

  public native void prepare()
    throws IOException, IllegalStateException;

  public native void prepareAsync()
    throws IllegalStateException;

  public void release()
  {
    stayAwake(false);
    updateSurfaceScreenOn();
    this.mOnPreparedListener = null;
    this.mOnBufferingUpdateListener = null;
    this.mOnCompletionListener = null;
    this.mOnSeekCompleteListener = null;
    this.mOnErrorListener = null;
    this.mOnInfoListener = null;
    this.mOnVideoSizeChangedListener = null;
    this.mOnCachingUpdateListener = null;
    this.mOnHWRenderFailedListener = null;
    if (this.mEventHandler != null)
      this.mEventHandler.release();
    _release();
    closeFD();
    this.mInBuffering = false;
    this.mNeedResume = false;
  }

  public void releaseDisplay()
  {
    _releaseVideoSurface();
    this.mSurfaceHolder = null;
    this.mSurface = null;
  }

  public void reset()
  {
    stayAwake(false);
    _reset();
    if (this.mEventHandler != null)
      this.mEventHandler.removeCallbacksAndMessages(null);
    closeFD();
    this.mInBuffering = false;
    this.mNeedResume = false;
  }

  public native void seekTo(long paramLong)
    throws IllegalStateException;

  public void selectTrack(int paramInt)
  {
    selectOrDeselectBandTrack(paramInt, true);
  }

  public native void setAdaptiveStream(boolean paramBoolean);

  public native void setAudioAmplify(float paramFloat);

  public native void setBufferSize(long paramLong);

  public native void setCacheDirectory(String paramString);

  public void setDataSegments(String[] paramArrayOfString, String paramString)
  {
    _setDataSegmentsSource(paramArrayOfString, paramString);
  }

  public void setDataSource(Context paramContext, Uri paramUri)
    throws IOException, IllegalArgumentException, SecurityException, IllegalStateException
  {
    setDataSource(paramContext, paramUri, null);
  }

  public void setDataSource(Context paramContext, Uri paramUri, Map<String, String> paramMap)
    throws IOException, IllegalArgumentException, SecurityException, IllegalStateException
  {
    if ((paramContext == null) || (paramUri == null))
      throw new IllegalArgumentException();
    String str = paramUri.getScheme();
    if ((str == null) || (str.equals("file")))
      setDataSource(FileUtils.getPath(paramUri.toString()));
    while (true)
    {
      return;
      try
      {
        this.mFD = paramContext.getContentResolver().openAssetFileDescriptor(paramUri, "r");
        if (this.mFD == null)
          continue;
        setDataSource(this.mFD.getParcelFileDescriptor().getFileDescriptor());
        return;
      }
      catch (Exception paramContext)
      {
        closeFD();
        setDataSource(paramUri.toString(), paramMap);
      }
    }
  }

  public native void setDataSource(FileDescriptor paramFileDescriptor)
    throws IOException, IllegalArgumentException, IllegalStateException;

  public void setDataSource(String paramString)
    throws IOException, IllegalArgumentException, SecurityException, IllegalStateException
  {
    _setDataSource(paramString, null, null);
  }

  public void setDataSource(String paramString, Map<String, String> paramMap)
    throws IOException, IllegalArgumentException, SecurityException, IllegalStateException
  {
    Object localObject1 = null;
    Object localObject2 = null;
    if (paramMap != null)
    {
      String[] arrayOfString1 = new String[paramMap.size()];
      String[] arrayOfString2 = new String[paramMap.size()];
      int i = 0;
      paramMap = paramMap.entrySet().iterator();
      while (true)
      {
        localObject1 = arrayOfString1;
        localObject2 = arrayOfString2;
        if (!paramMap.hasNext())
          break;
        localObject1 = (Map.Entry)paramMap.next();
        arrayOfString1[i] = ((String)((Map.Entry)localObject1).getKey());
        arrayOfString2[i] = ((String)((Map.Entry)localObject1).getValue());
        i += 1;
      }
    }
    setDataSource(paramString, localObject1, localObject2);
  }

  public void setDataSource(String paramString, String[] paramArrayOfString1, String[] paramArrayOfString2)
    throws IOException, IllegalArgumentException, SecurityException, IllegalStateException
  {
    Object localObject = Uri.parse(paramString);
    if ("file".equals(((Uri)localObject).getScheme()))
      paramString = ((Uri)localObject).getPath();
    localObject = new File(paramString);
    if (((File)localObject).exists())
    {
      paramString = new FileInputStream((File)localObject);
      setDataSource(paramString.getFD());
      paramString.close();
      return;
    }
    _setDataSource(paramString, paramArrayOfString1, paramArrayOfString2);
  }

  public native void setDeinterlace(boolean paramBoolean);

  public void setDisplay(SurfaceHolder paramSurfaceHolder)
  {
    if (paramSurfaceHolder == null)
    {
      releaseDisplay();
      return;
    }
    this.mSurfaceHolder = paramSurfaceHolder;
    this.mSurface = paramSurfaceHolder.getSurface();
    _setVideoSurface(this.mSurface);
    updateSurfaceScreenOn();
  }

  public native void setLooping(boolean paramBoolean);

  public native void setMetaEncoding(String paramString);

  public void setOnBufferingUpdateListener(OnBufferingUpdateListener paramOnBufferingUpdateListener)
  {
    this.mOnBufferingUpdateListener = paramOnBufferingUpdateListener;
  }

  public void setOnCachingUpdateListener(OnCachingUpdateListener paramOnCachingUpdateListener)
  {
    this.mOnCachingUpdateListener = paramOnCachingUpdateListener;
  }

  public void setOnCompletionListener(OnCompletionListener paramOnCompletionListener)
  {
    this.mOnCompletionListener = paramOnCompletionListener;
  }

  public void setOnErrorListener(OnErrorListener paramOnErrorListener)
  {
    this.mOnErrorListener = paramOnErrorListener;
  }

  public void setOnHWRenderFailedListener(OnHWRenderFailedListener paramOnHWRenderFailedListener)
  {
    this.mOnHWRenderFailedListener = paramOnHWRenderFailedListener;
  }

  public void setOnInfoListener(OnInfoListener paramOnInfoListener)
  {
    this.mOnInfoListener = paramOnInfoListener;
  }

  public void setOnPreparedListener(OnPreparedListener paramOnPreparedListener)
  {
    this.mOnPreparedListener = paramOnPreparedListener;
  }

  public void setOnSeekCompleteListener(OnSeekCompleteListener paramOnSeekCompleteListener)
  {
    this.mOnSeekCompleteListener = paramOnSeekCompleteListener;
  }

  public void setOnTimedTextListener(OnTimedTextListener paramOnTimedTextListener)
  {
    this.mOnTimedTextListener = paramOnTimedTextListener;
  }

  public void setOnVideoSizeChangedListener(OnVideoSizeChangedListener paramOnVideoSizeChangedListener)
  {
    this.mOnVideoSizeChangedListener = paramOnVideoSizeChangedListener;
  }

  public native void setPlaybackSpeed(float paramFloat);

  public void setScreenOnWhilePlaying(boolean paramBoolean)
  {
    if (this.mScreenOnWhilePlaying != paramBoolean)
    {
      this.mScreenOnWhilePlaying = paramBoolean;
      updateSurfaceScreenOn();
    }
  }

  public void setSurface(Surface paramSurface)
  {
    if (paramSurface == null)
    {
      releaseDisplay();
      return;
    }
    this.mSurfaceHolder = null;
    this.mSurface = paramSurface;
    _setVideoSurface(this.mSurface);
    updateSurfaceScreenOn();
  }

  public native void setTimedTextEncoding(String paramString);

  public native void setTimedTextShown(boolean paramBoolean);

  public native void setUseCache(boolean paramBoolean);

  public native void setVideoChroma(int paramInt);

  public native void setVideoQuality(int paramInt);

  public native void setVolume(float paramFloat1, float paramFloat2);

  @SuppressLint({"Wakelock"})
  public void setWakeMode(Context paramContext, int paramInt)
  {
    int i = 0;
    int j = 0;
    if (this.mWakeLock != null)
    {
      i = j;
      if (this.mWakeLock.isHeld())
      {
        i = 1;
        this.mWakeLock.release();
      }
      this.mWakeLock = null;
    }
    this.mWakeLock = ((PowerManager)paramContext.getSystemService("power")).newWakeLock(0x20000000 | paramInt, MediaPlayer.class.getName());
    this.mWakeLock.setReferenceCounted(false);
    if (i != 0)
      this.mWakeLock.acquire();
  }

  public void start()
    throws IllegalStateException
  {
    stayAwake(true);
    if (this.mInBuffering)
    {
      this.mNeedResume = true;
      return;
    }
    _start();
  }

  public void stop()
    throws IllegalStateException
  {
    stayAwake(false);
    _stop();
    this.mInBuffering = false;
    this.mNeedResume = false;
  }

  @SuppressLint({"HandlerLeak"})
  private class EventHandler extends Handler
  {
    private Bundle mData;
    private MediaPlayer mMediaPlayer;

    public EventHandler(MediaPlayer paramLooper, Looper arg3)
    {
      super();
      this.mMediaPlayer = paramLooper;
    }

    private void onBufferingUpdate(Message paramMessage)
    {
      int i = paramMessage.arg1;
      if (MediaPlayer.this.mOnBufferingUpdateListener != null)
        MediaPlayer.this.mOnBufferingUpdateListener.onBufferingUpdate(this.mMediaPlayer, paramMessage.arg1);
      if ((i >= 100) && (MediaPlayer.this.mInBuffering))
      {
        MediaPlayer.access$002(MediaPlayer.this, false);
        if (MediaPlayer.this.mNeedResume)
        {
          MediaPlayer.this._start();
          MediaPlayer.access$202(MediaPlayer.this, false);
        }
        if (MediaPlayer.this.mOnInfoListener != null)
          MediaPlayer.this.mOnInfoListener.onInfo(this.mMediaPlayer, 702, i);
      }
    }

    private void onInfo(Message paramMessage)
    {
      switch (paramMessage.arg1)
      {
      default:
      case 701:
      case 702:
      }
      while (true)
      {
        if (MediaPlayer.this.mOnInfoListener != null)
          MediaPlayer.this.mOnInfoListener.onInfo(this.mMediaPlayer, paramMessage.arg1, paramMessage.arg2);
        return;
        MediaPlayer.access$002(MediaPlayer.this, true);
        if (!MediaPlayer.this.isPlaying())
          continue;
        MediaPlayer.this._pause();
        MediaPlayer.access$202(MediaPlayer.this, true);
        continue;
        MediaPlayer.access$002(MediaPlayer.this, false);
        if (!MediaPlayer.this.mNeedResume)
          continue;
        MediaPlayer.this._start();
        MediaPlayer.access$202(MediaPlayer.this, false);
      }
    }

    public void handleMessage(Message paramMessage)
    {
      if (this.mMediaPlayer == null);
      do
      {
        int i;
        do
        {
          do
          {
            do
            {
              do
                while (true)
                {
                  return;
                  switch (paramMessage.what)
                  {
                  case 0:
                  case 300:
                  default:
                    Log.e("Unknown message type " + paramMessage.what, new Object[0]);
                    return;
                  case 1:
                    if (MediaPlayer.this.mOnPreparedListener == null)
                      continue;
                    MediaPlayer.this.mOnPreparedListener.onPrepared(this.mMediaPlayer);
                    return;
                  case 2:
                    if (MediaPlayer.this.mOnCompletionListener != null)
                      MediaPlayer.this.mOnCompletionListener.onCompletion(this.mMediaPlayer);
                    MediaPlayer.this.stayAwake(false);
                    return;
                  case 3:
                    onBufferingUpdate(paramMessage);
                    return;
                  case 4:
                    if (MediaPlayer.this.isPlaying())
                      MediaPlayer.this.stayAwake(true);
                    if (MediaPlayer.this.mOnSeekCompleteListener == null)
                      continue;
                    MediaPlayer.this.mOnSeekCompleteListener.onSeekComplete(this.mMediaPlayer);
                    return;
                  case 5:
                    if (MediaPlayer.this.mOnVideoSizeChangedListener == null)
                      continue;
                    MediaPlayer.this.mOnVideoSizeChangedListener.onVideoSizeChanged(this.mMediaPlayer, paramMessage.arg1, paramMessage.arg2);
                    return;
                  case 100:
                    Log.e("Error (%d, %d)", new Object[] { Integer.valueOf(paramMessage.arg1), Integer.valueOf(paramMessage.arg2) });
                    boolean bool = false;
                    if (MediaPlayer.this.mOnErrorListener != null)
                      bool = MediaPlayer.this.mOnErrorListener.onError(this.mMediaPlayer, paramMessage.arg1, paramMessage.arg2);
                    if ((MediaPlayer.this.mOnCompletionListener != null) && (!bool))
                      MediaPlayer.this.mOnCompletionListener.onCompletion(this.mMediaPlayer);
                    MediaPlayer.this.stayAwake(false);
                    return;
                  case 200:
                    Log.i("Info (%d, %d)", new Object[] { Integer.valueOf(paramMessage.arg1), Integer.valueOf(paramMessage.arg2) });
                    if (MediaPlayer.this.mOnInfoListener == null)
                      continue;
                    MediaPlayer.this.mOnInfoListener.onInfo(this.mMediaPlayer, paramMessage.arg1, paramMessage.arg2);
                    return;
                  case 1000:
                    this.mData = paramMessage.getData();
                    if (this.mData.getInt("sub_type") == 0)
                    {
                      Log.i("Subtitle : %s", new Object[] { this.mData.getString("sub_string") });
                      if (MediaPlayer.this.mOnTimedTextListener == null)
                        continue;
                      MediaPlayer.this.mOnTimedTextListener.onTimedText(this.mData.getString("sub_string"));
                      return;
                    }
                  case 2000:
                  case 400:
                  }
                }
              while (this.mData.getInt("sub_type") != 1);
              Log.i("Subtitle : bitmap", new Object[0]);
            }
            while (MediaPlayer.this.mOnTimedTextListener == null);
            MediaPlayer.this.mOnTimedTextListener.onTimedTextUpdate(this.mData.getByteArray("sub_bytes"), paramMessage.arg1, paramMessage.arg2);
            return;
          }
          while (MediaPlayer.this.mOnCachingUpdateListener == null);
          i = paramMessage.getData().getInt("caching_type");
          if (i == 1)
          {
            MediaPlayer.this.mOnCachingUpdateListener.onCachingNotAvailable(this.mMediaPlayer, paramMessage.getData().getInt("caching_info"));
            return;
          }
          if (i == 3)
          {
            MediaPlayer.this.mOnCachingUpdateListener.onCachingUpdate(this.mMediaPlayer, paramMessage.getData().getLongArray("caching_segment"));
            return;
          }
          if (i == 4)
          {
            MediaPlayer.this.mOnCachingUpdateListener.onCachingSpeed(this.mMediaPlayer, paramMessage.getData().getInt("caching_info"));
            return;
          }
          if (i != 2)
            continue;
          MediaPlayer.this.mOnCachingUpdateListener.onCachingStart(this.mMediaPlayer);
          return;
        }
        while (i != 5);
        MediaPlayer.this.mOnCachingUpdateListener.onCachingComplete(this.mMediaPlayer);
        return;
      }
      while (MediaPlayer.this.mOnHWRenderFailedListener == null);
      MediaPlayer.this.mOnHWRenderFailedListener.onFailed();
    }

    public void release()
    {
      this.mMediaPlayer = null;
    }
  }

  public static abstract interface OnBufferingUpdateListener
  {
    public abstract void onBufferingUpdate(MediaPlayer paramMediaPlayer, int paramInt);
  }

  public static abstract interface OnCachingUpdateListener
  {
    public abstract void onCachingComplete(MediaPlayer paramMediaPlayer);

    public abstract void onCachingNotAvailable(MediaPlayer paramMediaPlayer, int paramInt);

    public abstract void onCachingSpeed(MediaPlayer paramMediaPlayer, int paramInt);

    public abstract void onCachingStart(MediaPlayer paramMediaPlayer);

    public abstract void onCachingUpdate(MediaPlayer paramMediaPlayer, long[] paramArrayOfLong);
  }

  public static abstract interface OnCompletionListener
  {
    public abstract void onCompletion(MediaPlayer paramMediaPlayer);
  }

  public static abstract interface OnErrorListener
  {
    public abstract boolean onError(MediaPlayer paramMediaPlayer, int paramInt1, int paramInt2);
  }

  public static abstract interface OnHWRenderFailedListener
  {
    public abstract void onFailed();
  }

  public static abstract interface OnInfoListener
  {
    public abstract boolean onInfo(MediaPlayer paramMediaPlayer, int paramInt1, int paramInt2);
  }

  public static abstract interface OnPreparedListener
  {
    public abstract void onPrepared(MediaPlayer paramMediaPlayer);
  }

  public static abstract interface OnSeekCompleteListener
  {
    public abstract void onSeekComplete(MediaPlayer paramMediaPlayer);
  }

  public static abstract interface OnTimedTextListener
  {
    public abstract void onTimedText(String paramString);

    public abstract void onTimedTextUpdate(byte[] paramArrayOfByte, int paramInt1, int paramInt2);
  }

  public static abstract interface OnVideoSizeChangedListener
  {
    public abstract void onVideoSizeChanged(MediaPlayer paramMediaPlayer, int paramInt1, int paramInt2);
  }

  public static class TrackInfo
  {
    public static final int MEDIA_TRACK_TYPE_AUDIO = 2;
    public static final int MEDIA_TRACK_TYPE_SUBTITLE = 4;
    public static final int MEDIA_TRACK_TYPE_TIMEDTEXT = 3;
    public static final int MEDIA_TRACK_TYPE_UNKNOWN = 0;
    public static final int MEDIA_TRACK_TYPE_VIDEO = 1;
    final SparseArray<MediaFormat> mTrackInfoArray;
    final int mTrackType;

    TrackInfo(int paramInt, SparseArray<MediaFormat> paramSparseArray)
    {
      this.mTrackType = paramInt;
      this.mTrackInfoArray = paramSparseArray;
    }

    public SparseArray<MediaFormat> getTrackInfoArray()
    {
      return this.mTrackInfoArray;
    }

    public int getTrackType()
    {
      return this.mTrackType;
    }
  }
}

/* Location:           C:\Users\c_jealom1\Documents\Scripts\Android\Fathom_com.brynk.fathom\Fathom_com.brynk.fathom-dex2jar.jar
 * Qualified Name:     io.vov.vitamio.MediaPlayer
 * JD-Core Version:    0.6.0
 */
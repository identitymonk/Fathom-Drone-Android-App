.class public Lio/vov/vitamio/MediaPlayer;
.super Ljava/lang/Object;
.source "MediaPlayer.java"


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lio/vov/vitamio/MediaPlayer$EventHandler;,
        Lio/vov/vitamio/MediaPlayer$TrackInfo;,
        Lio/vov/vitamio/MediaPlayer$OnTimedTextListener;,
        Lio/vov/vitamio/MediaPlayer$OnInfoListener;,
        Lio/vov/vitamio/MediaPlayer$OnErrorListener;,
        Lio/vov/vitamio/MediaPlayer$OnVideoSizeChangedListener;,
        Lio/vov/vitamio/MediaPlayer$OnSeekCompleteListener;,
        Lio/vov/vitamio/MediaPlayer$OnCachingUpdateListener;,
        Lio/vov/vitamio/MediaPlayer$OnBufferingUpdateListener;,
        Lio/vov/vitamio/MediaPlayer$OnCompletionListener;,
        Lio/vov/vitamio/MediaPlayer$OnPreparedListener;,
        Lio/vov/vitamio/MediaPlayer$OnHWRenderFailedListener;
    }
.end annotation


# static fields
.field public static final CACHE_INFO_NO_SPACE:I = 0x1

.field public static final CACHE_INFO_STREAM_NOT_SUPPORT:I = 0x2

.field public static final CACHE_TYPE_COMPLETE:I = 0x5

.field public static final CACHE_TYPE_NOT_AVAILABLE:I = 0x1

.field public static final CACHE_TYPE_SPEED:I = 0x4

.field public static final CACHE_TYPE_START:I = 0x2

.field public static final CACHE_TYPE_UPDATE:I = 0x3

.field private static final MEDIA_BUFFERING_UPDATE:I = 0x3

.field private static final MEDIA_CACHE:I = 0x12c

.field private static final MEDIA_CACHING_INFO:Ljava/lang/String; = "caching_info"

.field private static final MEDIA_CACHING_SEGMENTS:Ljava/lang/String; = "caching_segment"

.field private static final MEDIA_CACHING_TYPE:Ljava/lang/String; = "caching_type"

.field private static final MEDIA_CACHING_UPDATE:I = 0x7d0

.field private static final MEDIA_ERROR:I = 0x64

.field public static final MEDIA_ERROR_IO:I = -0x5

.field public static final MEDIA_ERROR_MALFORMED:I = -0x3ef

.field public static final MEDIA_ERROR_NOT_VALID_FOR_PROGRESSIVE_PLAYBACK:I = 0xc8

.field public static final MEDIA_ERROR_TIMED_OUT:I = -0x6e

.field public static final MEDIA_ERROR_UNKNOWN:I = 0x1

.field public static final MEDIA_ERROR_UNSUPPORTED:I = -0x3f2

.field private static final MEDIA_HW_ERROR:I = 0x190

.field private static final MEDIA_INFO:I = 0xc8

.field public static final MEDIA_INFO_BUFFERING_END:I = 0x2be

.field public static final MEDIA_INFO_BUFFERING_START:I = 0x2bd

.field public static final MEDIA_INFO_DOWNLOAD_RATE_CHANGED:I = 0x385

.field public static final MEDIA_INFO_FILE_OPEN_OK:I = 0x2c0

.field public static final MEDIA_INFO_GET_CODEC_INFO_ERROR:I = 0x3ea

.field public static final MEDIA_INFO_NOT_SEEKABLE:I = 0x321

.field public static final MEDIA_INFO_UNKNOW_TYPE:I = 0x3e9

.field public static final MEDIA_INFO_VIDEO_TRACK_LAGGING:I = 0x2bc

.field private static final MEDIA_NOP:I = 0x0

.field private static final MEDIA_PLAYBACK_COMPLETE:I = 0x2

.field private static final MEDIA_PREPARED:I = 0x1

.field private static final MEDIA_SEEK_COMPLETE:I = 0x4

.field private static final MEDIA_SET_VIDEO_SIZE:I = 0x5

.field private static final MEDIA_SUBTITLE_BYTES:Ljava/lang/String; = "sub_bytes"

.field private static final MEDIA_SUBTITLE_STRING:Ljava/lang/String; = "sub_string"

.field private static final MEDIA_SUBTITLE_TYPE:Ljava/lang/String; = "sub_type"

.field private static final MEDIA_TIMED_TEXT:I = 0x3e8

.field private static NATIVE_OMX_LOADED:Ljava/util/concurrent/atomic/AtomicBoolean; = null

.field private static final SUBTITLE_BITMAP:I = 0x1

.field public static final SUBTITLE_EXTERNAL:I = 0x1

.field public static final SUBTITLE_INTERNAL:I = 0x0

.field private static final SUBTITLE_TEXT:I = 0x0

.field public static final SUB_TYPES:[Ljava/lang/String;

.field public static final VIDEOCHROMA_RGB565:I = 0x0

.field public static final VIDEOCHROMA_RGBA:I = 0x1

.field public static final VIDEOQUALITY_HIGH:I = 0x10

.field public static final VIDEOQUALITY_LOW:I = -0x10

.field public static final VIDEOQUALITY_MEDIUM:I

.field private static path:Ljava/lang/String;


# instance fields
.field channels:I

.field private mAudioTrack:Landroid/media/AudioTrack;

.field private mAudioTrackBufferSize:I

.field private mBitmap:Landroid/graphics/Bitmap;

.field private mByteBuffer:Ljava/nio/ByteBuffer;

.field private mContext:Landroid/content/Context;

.field private mEventHandler:Lio/vov/vitamio/MediaPlayer$EventHandler;

.field private mFD:Landroid/content/res/AssetFileDescriptor;

.field private mInBuffering:Z

.field private mInbandTracks:[Lio/vov/vitamio/MediaPlayer$TrackInfo;

.field private mLocalSurface:Landroid/view/Surface;

.field private mMeta:Lio/vov/vitamio/Metadata;

.field private mNeedResume:Z

.field private mOnBufferingUpdateListener:Lio/vov/vitamio/MediaPlayer$OnBufferingUpdateListener;

.field private mOnCachingUpdateListener:Lio/vov/vitamio/MediaPlayer$OnCachingUpdateListener;

.field private mOnCompletionListener:Lio/vov/vitamio/MediaPlayer$OnCompletionListener;

.field private mOnErrorListener:Lio/vov/vitamio/MediaPlayer$OnErrorListener;

.field private mOnHWRenderFailedListener:Lio/vov/vitamio/MediaPlayer$OnHWRenderFailedListener;

.field private mOnInfoListener:Lio/vov/vitamio/MediaPlayer$OnInfoListener;

.field private mOnPreparedListener:Lio/vov/vitamio/MediaPlayer$OnPreparedListener;

.field private mOnSeekCompleteListener:Lio/vov/vitamio/MediaPlayer$OnSeekCompleteListener;

.field private mOnTimedTextListener:Lio/vov/vitamio/MediaPlayer$OnTimedTextListener;

.field private mOnVideoSizeChangedListener:Lio/vov/vitamio/MediaPlayer$OnVideoSizeChangedListener;

.field private mOutOfBandTracks:Lio/vov/vitamio/MediaPlayer$TrackInfo;

.field private mScreenOnWhilePlaying:Z

.field private mStayAwake:Z

.field private mSurface:Landroid/view/Surface;

.field private mSurfaceHolder:Landroid/view/SurfaceHolder;

.field private mWakeLock:Landroid/os/PowerManager$WakeLock;

.field sampleRateInHz:I


# direct methods
.method static constructor <clinit>()V
    .locals 8

    .prologue
    const/4 v7, 0x7

    const/4 v6, 0x0

    .line 135
    new-array v3, v7, [Ljava/lang/String;

    const-string v4, ".srt"

    aput-object v4, v3, v6

    const/4 v4, 0x1

    const-string v5, ".ssa"

    aput-object v5, v3, v4

    const/4 v4, 0x2

    const-string v5, ".smi"

    aput-object v5, v3, v4

    const/4 v4, 0x3

    const-string v5, ".txt"

    aput-object v5, v3, v4

    const/4 v4, 0x4

    const-string v5, ".sub"

    aput-object v5, v3, v4

    const/4 v4, 0x5

    const-string v5, ".ass"

    aput-object v5, v3, v4

    const/4 v4, 0x6

    const-string v5, ".webvtt"

    aput-object v5, v3, v4

    sput-object v3, Lio/vov/vitamio/MediaPlayer;->SUB_TYPES:[Ljava/lang/String;

    .line 156
    new-instance v3, Ljava/util/concurrent/atomic/AtomicBoolean;

    invoke-direct {v3, v6}, Ljava/util/concurrent/atomic/AtomicBoolean;-><init>(Z)V

    sput-object v3, Lio/vov/vitamio/MediaPlayer;->NATIVE_OMX_LOADED:Ljava/util/concurrent/atomic/AtomicBoolean;

    .line 311
    sget v3, Landroid/os/Build$VERSION;->SDK_INT:I

    const/16 v4, 0x14

    if-le v3, v4, :cond_1

    .line 312
    const-string v0, ""

    .line 320
    .local v0, "LIB_ROOT":Ljava/lang/String;
    :goto_0
    :try_start_0
    const-string v3, "libstlport_shared.so"

    invoke-static {v0, v3}, Lio/vov/vitamio/MediaPlayer;->load_lib(Ljava/lang/String;Ljava/lang/String;)Z

    .line 321
    const-string v3, "libvplayer.so"

    invoke-static {v0, v3}, Lio/vov/vitamio/MediaPlayer;->load_lib(Ljava/lang/String;Ljava/lang/String;)Z

    .line 322
    const-string v3, "libffmpeg.so"

    invoke-static {v0, v3}, Lio/vov/vitamio/MediaPlayer;->loadFFmpeg_native_lib(Ljava/lang/String;Ljava/lang/String;)Z

    .line 323
    const/4 v2, 0x0

    .line 324
    .local v2, "vvo_loaded":Z
    sget v3, Landroid/os/Build$VERSION;->SDK_INT:I

    const/16 v4, 0x8

    if-le v3, v4, :cond_2

    .line 325
    const-string v3, "libvvo.9.so"

    invoke-static {v0, v3}, Lio/vov/vitamio/MediaPlayer;->loadVVO_native_lib(Ljava/lang/String;Ljava/lang/String;)Z

    move-result v2

    .line 330
    :goto_1
    if-nez v2, :cond_0

    .line 331
    const-string v3, "libvvo.j.so"

    invoke-static {v0, v3}, Lio/vov/vitamio/MediaPlayer;->loadVAO_native_lib(Ljava/lang/String;Ljava/lang/String;)Z

    move-result v2

    .line 332
    new-instance v3, Ljava/lang/StringBuilder;

    invoke-direct {v3}, Ljava/lang/StringBuilder;-><init>()V

    const-string v4, "FALLBACK TO VVO JNI "

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    invoke-virtual {v3, v2}, Ljava/lang/StringBuilder;->append(Z)Ljava/lang/StringBuilder;

    move-result-object v3

    invoke-virtual {v3}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v3

    const/4 v4, 0x0

    new-array v4, v4, [Ljava/lang/Object;

    invoke-static {v3, v4}, Lio/vov/vitamio/utils/Log;->d(Ljava/lang/String;[Ljava/lang/Object;)V

    .line 334
    :cond_0
    const-string v3, "libvao.0.so"

    invoke-static {v0, v3}, Lio/vov/vitamio/MediaPlayer;->loadVAO_native_lib(Ljava/lang/String;Ljava/lang/String;)Z
    :try_end_0
    .catch Ljava/lang/UnsatisfiedLinkError; {:try_start_0 .. :try_end_0} :catch_0

    .line 338
    .end local v2    # "vvo_loaded":Z
    :goto_2
    return-void

    .line 315
    .end local v0    # "LIB_ROOT":Ljava/lang/String;
    :cond_1
    invoke-static {}, Lio/vov/vitamio/Vitamio;->getLibraryPath()Ljava/lang/String;

    move-result-object v0

    .restart local v0    # "LIB_ROOT":Ljava/lang/String;
    goto :goto_0

    .line 326
    .restart local v2    # "vvo_loaded":Z
    :cond_2
    :try_start_1
    sget v3, Landroid/os/Build$VERSION;->SDK_INT:I

    if-le v3, v7, :cond_3

    .line 327
    const-string v3, "libvvo.8.so"

    invoke-static {v0, v3}, Lio/vov/vitamio/MediaPlayer;->loadVVO_native_lib(Ljava/lang/String;Ljava/lang/String;)Z

    move-result v2

    goto :goto_1

    .line 329
    :cond_3
    const-string v3, "libvvo.7.so"

    invoke-static {v0, v3}, Lio/vov/vitamio/MediaPlayer;->loadVVO_native_lib(Ljava/lang/String;Ljava/lang/String;)Z
    :try_end_1
    .catch Ljava/lang/UnsatisfiedLinkError; {:try_start_1 .. :try_end_1} :catch_0

    move-result v2

    goto :goto_1

    .line 335
    .end local v2    # "vvo_loaded":Z
    :catch_0
    move-exception v1

    .line 336
    .local v1, "e":Ljava/lang/UnsatisfiedLinkError;
    const-string v3, "Error loading libs"

    invoke-static {v3, v1}, Lio/vov/vitamio/utils/Log;->e(Ljava/lang/String;Ljava/lang/Throwable;)V

    goto :goto_2
.end method

.method public constructor <init>(Landroid/content/Context;)V
    .locals 1
    .param p1, "ctx"    # Landroid/content/Context;

    .prologue
    .line 199
    const/4 v0, 0x0

    invoke-direct {p0, p1, v0}, Lio/vov/vitamio/MediaPlayer;-><init>(Landroid/content/Context;Z)V

    .line 200
    return-void
.end method

.method public constructor <init>(Landroid/content/Context;Z)V
    .locals 8
    .param p1, "ctx"    # Landroid/content/Context;
    .param p2, "preferHWDecoder"    # Z

    .prologue
    const/4 v5, 0x1

    const/4 v7, 0x0

    const/4 v6, 0x0

    .line 265
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 161
    iput-object v7, p0, Lio/vov/vitamio/MediaPlayer;->mWakeLock:Landroid/os/PowerManager$WakeLock;

    .line 167
    iput-object v7, p0, Lio/vov/vitamio/MediaPlayer;->mFD:Landroid/content/res/AssetFileDescriptor;

    .line 1606
    iput-boolean v6, p0, Lio/vov/vitamio/MediaPlayer;->mNeedResume:Z

    .line 1607
    iput-boolean v6, p0, Lio/vov/vitamio/MediaPlayer;->mInBuffering:Z

    .line 266
    iput-object p1, p0, Lio/vov/vitamio/MediaPlayer;->mContext:Landroid/content/Context;

    .line 269
    sget v3, Landroid/os/Build$VERSION;->SDK_INT:I

    const/16 v4, 0x14

    if-le v3, v4, :cond_1

    .line 270
    const-string v0, ""

    .line 276
    .local v0, "LIB_ROOT":Ljava/lang/String;
    :goto_0
    if-eqz p2, :cond_5

    .line 277
    sget-object v3, Lio/vov/vitamio/MediaPlayer;->NATIVE_OMX_LOADED:Ljava/util/concurrent/atomic/AtomicBoolean;

    invoke-virtual {v3}, Ljava/util/concurrent/atomic/AtomicBoolean;->get()Z

    move-result v3

    if-nez v3, :cond_0

    .line 278
    sget v3, Landroid/os/Build$VERSION;->SDK_INT:I

    const/16 v4, 0x11

    if-le v3, v4, :cond_2

    .line 279
    const-string v3, "libOMX.18.so"

    invoke-static {v0, v3}, Lio/vov/vitamio/MediaPlayer;->load_omxnative_lib(Ljava/lang/String;Ljava/lang/String;)Z

    .line 287
    :goto_1
    sget-object v3, Lio/vov/vitamio/MediaPlayer;->NATIVE_OMX_LOADED:Ljava/util/concurrent/atomic/AtomicBoolean;

    invoke-virtual {v3, v5}, Ljava/util/concurrent/atomic/AtomicBoolean;->set(Z)V

    .line 299
    :cond_0
    :goto_2
    invoke-static {}, Landroid/os/Looper;->myLooper()Landroid/os/Looper;

    move-result-object v2

    .local v2, "looper":Landroid/os/Looper;
    if-eqz v2, :cond_6

    .line 300
    new-instance v3, Lio/vov/vitamio/MediaPlayer$EventHandler;

    invoke-direct {v3, p0, p0, v2}, Lio/vov/vitamio/MediaPlayer$EventHandler;-><init>(Lio/vov/vitamio/MediaPlayer;Lio/vov/vitamio/MediaPlayer;Landroid/os/Looper;)V

    iput-object v3, p0, Lio/vov/vitamio/MediaPlayer;->mEventHandler:Lio/vov/vitamio/MediaPlayer$EventHandler;

    .line 306
    :goto_3
    invoke-direct {p0}, Lio/vov/vitamio/MediaPlayer;->native_init()V

    .line 307
    return-void

    .line 273
    .end local v0    # "LIB_ROOT":Ljava/lang/String;
    .end local v2    # "looper":Landroid/os/Looper;
    :cond_1
    invoke-static {}, Lio/vov/vitamio/Vitamio;->getLibraryPath()Ljava/lang/String;

    move-result-object v0

    .restart local v0    # "LIB_ROOT":Ljava/lang/String;
    goto :goto_0

    .line 281
    :cond_2
    sget v3, Landroid/os/Build$VERSION;->SDK_INT:I

    const/16 v4, 0xd

    if-le v3, v4, :cond_3

    .line 282
    const-string v3, "libOMX.14.so"

    invoke-static {v0, v3}, Lio/vov/vitamio/MediaPlayer;->load_omxnative_lib(Ljava/lang/String;Ljava/lang/String;)Z

    goto :goto_1

    .line 283
    :cond_3
    sget v3, Landroid/os/Build$VERSION;->SDK_INT:I

    const/16 v4, 0xa

    if-le v3, v4, :cond_4

    .line 284
    const-string v3, "libOMX.11.so"

    invoke-static {v0, v3}, Lio/vov/vitamio/MediaPlayer;->load_omxnative_lib(Ljava/lang/String;Ljava/lang/String;)Z

    goto :goto_1

    .line 286
    :cond_4
    const-string v3, "libOMX.9.so"

    invoke-static {v0, v3}, Lio/vov/vitamio/MediaPlayer;->load_omxnative_lib(Ljava/lang/String;Ljava/lang/String;)Z

    goto :goto_1

    .line 291
    :cond_5
    :try_start_0
    invoke-static {}, Lio/vov/vitamio/MediaPlayer;->unloadOMX_native()V
    :try_end_0
    .catch Ljava/lang/UnsatisfiedLinkError; {:try_start_0 .. :try_end_0} :catch_0

    .line 295
    :goto_4
    sget-object v3, Lio/vov/vitamio/MediaPlayer;->NATIVE_OMX_LOADED:Ljava/util/concurrent/atomic/AtomicBoolean;

    invoke-virtual {v3, v6}, Ljava/util/concurrent/atomic/AtomicBoolean;->set(Z)V

    goto :goto_2

    .line 292
    :catch_0
    move-exception v1

    .line 293
    .local v1, "e":Ljava/lang/UnsatisfiedLinkError;
    const-string v3, "unloadOMX failed %s"

    new-array v4, v5, [Ljava/lang/Object;

    invoke-virtual {v1}, Ljava/lang/UnsatisfiedLinkError;->toString()Ljava/lang/String;

    move-result-object v5

    aput-object v5, v4, v6

    invoke-static {v3, v4}, Lio/vov/vitamio/utils/Log;->e(Ljava/lang/String;[Ljava/lang/Object;)V

    goto :goto_4

    .line 301
    .end local v1    # "e":Ljava/lang/UnsatisfiedLinkError;
    .restart local v2    # "looper":Landroid/os/Looper;
    :cond_6
    invoke-static {}, Landroid/os/Looper;->getMainLooper()Landroid/os/Looper;

    move-result-object v2

    if-eqz v2, :cond_7

    .line 302
    new-instance v3, Lio/vov/vitamio/MediaPlayer$EventHandler;

    invoke-direct {v3, p0, p0, v2}, Lio/vov/vitamio/MediaPlayer$EventHandler;-><init>(Lio/vov/vitamio/MediaPlayer;Lio/vov/vitamio/MediaPlayer;Landroid/os/Looper;)V

    iput-object v3, p0, Lio/vov/vitamio/MediaPlayer;->mEventHandler:Lio/vov/vitamio/MediaPlayer$EventHandler;

    goto :goto_3

    .line 304
    :cond_7
    iput-object v7, p0, Lio/vov/vitamio/MediaPlayer;->mEventHandler:Lio/vov/vitamio/MediaPlayer$EventHandler;

    goto :goto_3
.end method

.method private native _pause()V
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/lang/IllegalStateException;
        }
    .end annotation
.end method

.method private native _release()V
.end method

.method private native _reset()V
.end method

.method private native _setDataSegmentsSource([Ljava/lang/String;Ljava/lang/String;)V
.end method

.method private native _setDataSource(Ljava/lang/String;[Ljava/lang/String;[Ljava/lang/String;)V
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;,
            Ljava/lang/IllegalArgumentException;,
            Ljava/lang/IllegalStateException;
        }
    .end annotation
.end method

.method private native _setVideoSurface(Landroid/view/Surface;)V
.end method

.method private native _start()V
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/lang/IllegalStateException;
        }
    .end annotation
.end method

.method private native _stop()V
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/lang/IllegalStateException;
        }
    .end annotation
.end method

.method static synthetic access$000(Lio/vov/vitamio/MediaPlayer;)Z
    .locals 1
    .param p0, "x0"    # Lio/vov/vitamio/MediaPlayer;

    .prologue
    .line 65
    iget-boolean v0, p0, Lio/vov/vitamio/MediaPlayer;->mInBuffering:Z

    return v0
.end method

.method static synthetic access$002(Lio/vov/vitamio/MediaPlayer;Z)Z
    .locals 0
    .param p0, "x0"    # Lio/vov/vitamio/MediaPlayer;
    .param p1, "x1"    # Z

    .prologue
    .line 65
    iput-boolean p1, p0, Lio/vov/vitamio/MediaPlayer;->mInBuffering:Z

    return p1
.end method

.method static synthetic access$100(Lio/vov/vitamio/MediaPlayer;)V
    .locals 0
    .param p0, "x0"    # Lio/vov/vitamio/MediaPlayer;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/lang/IllegalStateException;
        }
    .end annotation

    .prologue
    .line 65
    invoke-direct {p0}, Lio/vov/vitamio/MediaPlayer;->_pause()V

    return-void
.end method

.method static synthetic access$1000(Lio/vov/vitamio/MediaPlayer;)Lio/vov/vitamio/MediaPlayer$OnVideoSizeChangedListener;
    .locals 1
    .param p0, "x0"    # Lio/vov/vitamio/MediaPlayer;

    .prologue
    .line 65
    iget-object v0, p0, Lio/vov/vitamio/MediaPlayer;->mOnVideoSizeChangedListener:Lio/vov/vitamio/MediaPlayer$OnVideoSizeChangedListener;

    return-object v0
.end method

.method static synthetic access$1100(Lio/vov/vitamio/MediaPlayer;)Lio/vov/vitamio/MediaPlayer$OnErrorListener;
    .locals 1
    .param p0, "x0"    # Lio/vov/vitamio/MediaPlayer;

    .prologue
    .line 65
    iget-object v0, p0, Lio/vov/vitamio/MediaPlayer;->mOnErrorListener:Lio/vov/vitamio/MediaPlayer$OnErrorListener;

    return-object v0
.end method

.method static synthetic access$1200(Lio/vov/vitamio/MediaPlayer;)Lio/vov/vitamio/MediaPlayer$OnTimedTextListener;
    .locals 1
    .param p0, "x0"    # Lio/vov/vitamio/MediaPlayer;

    .prologue
    .line 65
    iget-object v0, p0, Lio/vov/vitamio/MediaPlayer;->mOnTimedTextListener:Lio/vov/vitamio/MediaPlayer$OnTimedTextListener;

    return-object v0
.end method

.method static synthetic access$1300(Lio/vov/vitamio/MediaPlayer;)Lio/vov/vitamio/MediaPlayer$OnCachingUpdateListener;
    .locals 1
    .param p0, "x0"    # Lio/vov/vitamio/MediaPlayer;

    .prologue
    .line 65
    iget-object v0, p0, Lio/vov/vitamio/MediaPlayer;->mOnCachingUpdateListener:Lio/vov/vitamio/MediaPlayer$OnCachingUpdateListener;

    return-object v0
.end method

.method static synthetic access$1400(Lio/vov/vitamio/MediaPlayer;)Lio/vov/vitamio/MediaPlayer$OnHWRenderFailedListener;
    .locals 1
    .param p0, "x0"    # Lio/vov/vitamio/MediaPlayer;

    .prologue
    .line 65
    iget-object v0, p0, Lio/vov/vitamio/MediaPlayer;->mOnHWRenderFailedListener:Lio/vov/vitamio/MediaPlayer$OnHWRenderFailedListener;

    return-object v0
.end method

.method static synthetic access$200(Lio/vov/vitamio/MediaPlayer;)Z
    .locals 1
    .param p0, "x0"    # Lio/vov/vitamio/MediaPlayer;

    .prologue
    .line 65
    iget-boolean v0, p0, Lio/vov/vitamio/MediaPlayer;->mNeedResume:Z

    return v0
.end method

.method static synthetic access$202(Lio/vov/vitamio/MediaPlayer;Z)Z
    .locals 0
    .param p0, "x0"    # Lio/vov/vitamio/MediaPlayer;
    .param p1, "x1"    # Z

    .prologue
    .line 65
    iput-boolean p1, p0, Lio/vov/vitamio/MediaPlayer;->mNeedResume:Z

    return p1
.end method

.method static synthetic access$300(Lio/vov/vitamio/MediaPlayer;)V
    .locals 0
    .param p0, "x0"    # Lio/vov/vitamio/MediaPlayer;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/lang/IllegalStateException;
        }
    .end annotation

    .prologue
    .line 65
    invoke-direct {p0}, Lio/vov/vitamio/MediaPlayer;->_start()V

    return-void
.end method

.method static synthetic access$400(Lio/vov/vitamio/MediaPlayer;)Lio/vov/vitamio/MediaPlayer$OnInfoListener;
    .locals 1
    .param p0, "x0"    # Lio/vov/vitamio/MediaPlayer;

    .prologue
    .line 65
    iget-object v0, p0, Lio/vov/vitamio/MediaPlayer;->mOnInfoListener:Lio/vov/vitamio/MediaPlayer$OnInfoListener;

    return-object v0
.end method

.method static synthetic access$500(Lio/vov/vitamio/MediaPlayer;)Lio/vov/vitamio/MediaPlayer$OnBufferingUpdateListener;
    .locals 1
    .param p0, "x0"    # Lio/vov/vitamio/MediaPlayer;

    .prologue
    .line 65
    iget-object v0, p0, Lio/vov/vitamio/MediaPlayer;->mOnBufferingUpdateListener:Lio/vov/vitamio/MediaPlayer$OnBufferingUpdateListener;

    return-object v0
.end method

.method static synthetic access$600(Lio/vov/vitamio/MediaPlayer;)Lio/vov/vitamio/MediaPlayer$OnPreparedListener;
    .locals 1
    .param p0, "x0"    # Lio/vov/vitamio/MediaPlayer;

    .prologue
    .line 65
    iget-object v0, p0, Lio/vov/vitamio/MediaPlayer;->mOnPreparedListener:Lio/vov/vitamio/MediaPlayer$OnPreparedListener;

    return-object v0
.end method

.method static synthetic access$700(Lio/vov/vitamio/MediaPlayer;)Lio/vov/vitamio/MediaPlayer$OnCompletionListener;
    .locals 1
    .param p0, "x0"    # Lio/vov/vitamio/MediaPlayer;

    .prologue
    .line 65
    iget-object v0, p0, Lio/vov/vitamio/MediaPlayer;->mOnCompletionListener:Lio/vov/vitamio/MediaPlayer$OnCompletionListener;

    return-object v0
.end method

.method static synthetic access$800(Lio/vov/vitamio/MediaPlayer;Z)V
    .locals 0
    .param p0, "x0"    # Lio/vov/vitamio/MediaPlayer;
    .param p1, "x1"    # Z

    .prologue
    .line 65
    invoke-direct {p0, p1}, Lio/vov/vitamio/MediaPlayer;->stayAwake(Z)V

    return-void
.end method

.method static synthetic access$900(Lio/vov/vitamio/MediaPlayer;)Lio/vov/vitamio/MediaPlayer$OnSeekCompleteListener;
    .locals 1
    .param p0, "x0"    # Lio/vov/vitamio/MediaPlayer;

    .prologue
    .line 65
    iget-object v0, p0, Lio/vov/vitamio/MediaPlayer;->mOnSeekCompleteListener:Lio/vov/vitamio/MediaPlayer$OnSeekCompleteListener;

    return-object v0
.end method

.method private audioTrackInit(II)I
    .locals 1
    .param p1, "sampleRateInHz"    # I
    .param p2, "channels"    # I
    .annotation build Landroid/annotation/SuppressLint;
        value = {
            "NewApi"
        }
    .end annotation

    .prologue
    .line 1311
    iput p1, p0, Lio/vov/vitamio/MediaPlayer;->sampleRateInHz:I

    .line 1312
    iput p2, p0, Lio/vov/vitamio/MediaPlayer;->channels:I

    .line 1313
    const/4 v0, 0x0

    return v0
.end method

.method private audioTrackPause()V
    .locals 2

    .prologue
    .line 1352
    iget-object v0, p0, Lio/vov/vitamio/MediaPlayer;->mAudioTrack:Landroid/media/AudioTrack;

    if-eqz v0, :cond_0

    iget-object v0, p0, Lio/vov/vitamio/MediaPlayer;->mAudioTrack:Landroid/media/AudioTrack;

    invoke-virtual {v0}, Landroid/media/AudioTrack;->getState()I

    move-result v0

    const/4 v1, 0x1

    if-ne v0, v1, :cond_0

    .line 1353
    iget-object v0, p0, Lio/vov/vitamio/MediaPlayer;->mAudioTrack:Landroid/media/AudioTrack;

    invoke-virtual {v0}, Landroid/media/AudioTrack;->pause()V

    .line 1354
    :cond_0
    return-void
.end method

.method private audioTrackRelease()V
    .locals 2

    .prologue
    .line 1357
    iget-object v0, p0, Lio/vov/vitamio/MediaPlayer;->mAudioTrack:Landroid/media/AudioTrack;

    if-eqz v0, :cond_1

    .line 1358
    iget-object v0, p0, Lio/vov/vitamio/MediaPlayer;->mAudioTrack:Landroid/media/AudioTrack;

    invoke-virtual {v0}, Landroid/media/AudioTrack;->getState()I

    move-result v0

    const/4 v1, 0x1

    if-ne v0, v1, :cond_0

    .line 1359
    iget-object v0, p0, Lio/vov/vitamio/MediaPlayer;->mAudioTrack:Landroid/media/AudioTrack;

    invoke-virtual {v0}, Landroid/media/AudioTrack;->stop()V

    .line 1360
    :cond_0
    iget-object v0, p0, Lio/vov/vitamio/MediaPlayer;->mAudioTrack:Landroid/media/AudioTrack;

    invoke-virtual {v0}, Landroid/media/AudioTrack;->release()V

    .line 1362
    :cond_1
    const/4 v0, 0x0

    iput-object v0, p0, Lio/vov/vitamio/MediaPlayer;->mAudioTrack:Landroid/media/AudioTrack;

    .line 1363
    return-void
.end method

.method private audioTrackSetVolume(FF)V
    .locals 1
    .param p1, "leftVolume"    # F
    .param p2, "rightVolume"    # F

    .prologue
    .line 1330
    iget-object v0, p0, Lio/vov/vitamio/MediaPlayer;->mAudioTrack:Landroid/media/AudioTrack;

    if-eqz v0, :cond_0

    .line 1331
    iget-object v0, p0, Lio/vov/vitamio/MediaPlayer;->mAudioTrack:Landroid/media/AudioTrack;

    invoke-virtual {v0, p1, p2}, Landroid/media/AudioTrack;->setStereoVolume(FF)I

    .line 1332
    :cond_0
    return-void
.end method

.method private audioTrackStart()V
    .locals 2

    .prologue
    .line 1347
    iget-object v0, p0, Lio/vov/vitamio/MediaPlayer;->mAudioTrack:Landroid/media/AudioTrack;

    if-eqz v0, :cond_0

    iget-object v0, p0, Lio/vov/vitamio/MediaPlayer;->mAudioTrack:Landroid/media/AudioTrack;

    invoke-virtual {v0}, Landroid/media/AudioTrack;->getState()I

    move-result v0

    const/4 v1, 0x1

    if-ne v0, v1, :cond_0

    iget-object v0, p0, Lio/vov/vitamio/MediaPlayer;->mAudioTrack:Landroid/media/AudioTrack;

    invoke-virtual {v0}, Landroid/media/AudioTrack;->getPlayState()I

    move-result v0

    const/4 v1, 0x3

    if-eq v0, v1, :cond_0

    .line 1348
    iget-object v0, p0, Lio/vov/vitamio/MediaPlayer;->mAudioTrack:Landroid/media/AudioTrack;

    invoke-virtual {v0}, Landroid/media/AudioTrack;->play()V

    .line 1349
    :cond_0
    return-void
.end method

.method private audioTrackWrite([BII)V
    .locals 3
    .param p1, "audioData"    # [B
    .param p2, "offsetInBytes"    # I
    .param p3, "sizeInBytes"    # I

    .prologue
    .line 1335
    iget-object v1, p0, Lio/vov/vitamio/MediaPlayer;->mAudioTrack:Landroid/media/AudioTrack;

    if-eqz v1, :cond_1

    iget-object v1, p0, Lio/vov/vitamio/MediaPlayer;->mAudioTrack:Landroid/media/AudioTrack;

    invoke-virtual {v1}, Landroid/media/AudioTrack;->getPlayState()I

    move-result v1

    const/4 v2, 0x3

    if-ne v1, v2, :cond_1

    .line 1337
    :goto_0
    if-lez p3, :cond_1

    .line 1338
    iget v1, p0, Lio/vov/vitamio/MediaPlayer;->mAudioTrackBufferSize:I

    if-le p3, v1, :cond_0

    iget v0, p0, Lio/vov/vitamio/MediaPlayer;->mAudioTrackBufferSize:I

    .line 1339
    .local v0, "written":I
    :goto_1
    iget-object v1, p0, Lio/vov/vitamio/MediaPlayer;->mAudioTrack:Landroid/media/AudioTrack;

    invoke-virtual {v1, p1, p2, v0}, Landroid/media/AudioTrack;->write([BII)I

    .line 1340
    sub-int/2addr p3, v0

    .line 1341
    add-int/2addr p2, v0

    goto :goto_0

    .end local v0    # "written":I
    :cond_0
    move v0, p3

    .line 1338
    goto :goto_1

    .line 1344
    :cond_1
    return-void
.end method

.method private closeFD()V
    .locals 2

    .prologue
    .line 840
    iget-object v1, p0, Lio/vov/vitamio/MediaPlayer;->mFD:Landroid/content/res/AssetFileDescriptor;

    if-eqz v1, :cond_0

    .line 842
    :try_start_0
    iget-object v1, p0, Lio/vov/vitamio/MediaPlayer;->mFD:Landroid/content/res/AssetFileDescriptor;

    invoke-virtual {v1}, Landroid/content/res/AssetFileDescriptor;->close()V
    :try_end_0
    .catch Ljava/io/IOException; {:try_start_0 .. :try_end_0} :catch_0

    .line 846
    :goto_0
    const/4 v1, 0x0

    iput-object v1, p0, Lio/vov/vitamio/MediaPlayer;->mFD:Landroid/content/res/AssetFileDescriptor;

    .line 848
    :cond_0
    return-void

    .line 843
    :catch_0
    move-exception v0

    .line 844
    .local v0, "e":Ljava/io/IOException;
    const-string v1, "closeFD"

    invoke-static {v1, v0}, Lio/vov/vitamio/utils/Log;->e(Ljava/lang/String;Ljava/lang/Throwable;)V

    goto :goto_0
.end method

.method private getInbandTrackInfo(Ljava/lang/String;)[Lio/vov/vitamio/MediaPlayer$TrackInfo;
    .locals 6
    .param p1, "encoding"    # Ljava/lang/String;

    .prologue
    .line 912
    iget-object v5, p0, Lio/vov/vitamio/MediaPlayer;->mInbandTracks:[Lio/vov/vitamio/MediaPlayer$TrackInfo;

    if-nez v5, :cond_1

    .line 913
    new-instance v4, Landroid/util/SparseArray;

    invoke-direct {v4}, Landroid/util/SparseArray;-><init>()V

    .line 914
    .local v4, "trackSparse":Landroid/util/SparseArray;, "Landroid/util/SparseArray<[B>;"
    invoke-direct {p0, v4}, Lio/vov/vitamio/MediaPlayer;->native_getTrackInfo(Landroid/util/SparseArray;)Z

    move-result v5

    if-nez v5, :cond_0

    .line 915
    const/4 v5, 0x0

    .line 926
    .end local v4    # "trackSparse":Landroid/util/SparseArray;, "Landroid/util/SparseArray<[B>;"
    :goto_0
    return-object v5

    .line 918
    .restart local v4    # "trackSparse":Landroid/util/SparseArray;, "Landroid/util/SparseArray<[B>;"
    :cond_0
    invoke-virtual {v4}, Landroid/util/SparseArray;->size()I

    move-result v1

    .line 919
    .local v1, "size":I
    new-array v5, v1, [Lio/vov/vitamio/MediaPlayer$TrackInfo;

    iput-object v5, p0, Lio/vov/vitamio/MediaPlayer;->mInbandTracks:[Lio/vov/vitamio/MediaPlayer$TrackInfo;

    .line 920
    const/4 v0, 0x0

    .local v0, "i":I
    :goto_1
    if-ge v0, v1, :cond_1

    .line 921
    invoke-virtual {v4, v0}, Landroid/util/SparseArray;->valueAt(I)Ljava/lang/Object;

    move-result-object v5

    check-cast v5, [B

    invoke-direct {p0, v5, p1}, Lio/vov/vitamio/MediaPlayer;->parseTrackInfo([BLjava/lang/String;)Landroid/util/SparseArray;

    move-result-object v2

    .line 922
    .local v2, "sparseArray":Landroid/util/SparseArray;, "Landroid/util/SparseArray<Lio/vov/vitamio/MediaFormat;>;"
    new-instance v3, Lio/vov/vitamio/MediaPlayer$TrackInfo;

    invoke-virtual {v4, v0}, Landroid/util/SparseArray;->keyAt(I)I

    move-result v5

    invoke-direct {v3, v5, v2}, Lio/vov/vitamio/MediaPlayer$TrackInfo;-><init>(ILandroid/util/SparseArray;)V

    .line 923
    .local v3, "trackInfo":Lio/vov/vitamio/MediaPlayer$TrackInfo;
    iget-object v5, p0, Lio/vov/vitamio/MediaPlayer;->mInbandTracks:[Lio/vov/vitamio/MediaPlayer$TrackInfo;

    aput-object v3, v5, v0

    .line 920
    add-int/lit8 v0, v0, 0x1

    goto :goto_1

    .line 926
    .end local v0    # "i":I
    .end local v1    # "size":I
    .end local v2    # "sparseArray":Landroid/util/SparseArray;, "Landroid/util/SparseArray<Lio/vov/vitamio/MediaFormat;>;"
    .end local v3    # "trackInfo":Lio/vov/vitamio/MediaPlayer$TrackInfo;
    .end local v4    # "trackSparse":Landroid/util/SparseArray;, "Landroid/util/SparseArray<[B>;"
    :cond_1
    iget-object v5, p0, Lio/vov/vitamio/MediaPlayer;->mInbandTracks:[Lio/vov/vitamio/MediaPlayer$TrackInfo;

    goto :goto_0
.end method

.method private native getVideoHeight_a()I
.end method

.method private native getVideoWidth_a()I
.end method

.method private static native loadFFmpeg_native(Ljava/lang/String;)Z
.end method

.method private static loadFFmpeg_native_lib(Ljava/lang/String;Ljava/lang/String;)Z
    .locals 2
    .param p0, "path"    # Ljava/lang/String;
    .param p1, "name"    # Ljava/lang/String;

    .prologue
    .line 247
    const/4 v0, 0x0

    .line 248
    .local v0, "load":Z
    const-string v1, ""

    if-ne p0, v1, :cond_0

    .line 249
    invoke-static {p1}, Lio/vov/vitamio/MediaPlayer;->loadFFmpeg_native(Ljava/lang/String;)Z

    move-result v0

    .line 254
    :goto_0
    return v0

    .line 252
    :cond_0
    new-instance v1, Ljava/lang/StringBuilder;

    invoke-direct {v1}, Ljava/lang/StringBuilder;-><init>()V

    invoke-virtual {v1, p0}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1, p1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    invoke-static {v1}, Lio/vov/vitamio/MediaPlayer;->loadFFmpeg_native(Ljava/lang/String;)Z

    move-result v0

    goto :goto_0
.end method

.method private static native loadOMX_native(Ljava/lang/String;)Z
.end method

.method private static native loadVAO_native(Ljava/lang/String;)Z
.end method

.method private static loadVAO_native_lib(Ljava/lang/String;Ljava/lang/String;)Z
    .locals 2
    .param p0, "path"    # Ljava/lang/String;
    .param p1, "name"    # Ljava/lang/String;

    .prologue
    .line 236
    const/4 v0, 0x0

    .line 237
    .local v0, "load":Z
    const-string v1, ""

    if-ne p0, v1, :cond_0

    .line 238
    invoke-static {p1}, Lio/vov/vitamio/MediaPlayer;->loadVAO_native(Ljava/lang/String;)Z

    move-result v0

    .line 243
    :goto_0
    return v0

    .line 241
    :cond_0
    new-instance v1, Ljava/lang/StringBuilder;

    invoke-direct {v1}, Ljava/lang/StringBuilder;-><init>()V

    invoke-virtual {v1, p0}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1, p1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    invoke-static {v1}, Lio/vov/vitamio/MediaPlayer;->loadVAO_native(Ljava/lang/String;)Z

    move-result v0

    goto :goto_0
.end method

.method private static native loadVVO_native(Ljava/lang/String;)Z
.end method

.method private static loadVVO_native_lib(Ljava/lang/String;Ljava/lang/String;)Z
    .locals 2
    .param p0, "path"    # Ljava/lang/String;
    .param p1, "name"    # Ljava/lang/String;

    .prologue
    .line 225
    const/4 v0, 0x0

    .line 226
    .local v0, "load":Z
    const-string v1, ""

    if-ne p0, v1, :cond_0

    .line 227
    invoke-static {p1}, Lio/vov/vitamio/MediaPlayer;->loadVVO_native(Ljava/lang/String;)Z

    move-result v0

    .line 232
    :goto_0
    return v0

    .line 230
    :cond_0
    new-instance v1, Ljava/lang/StringBuilder;

    invoke-direct {v1}, Ljava/lang/StringBuilder;-><init>()V

    invoke-virtual {v1, p0}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1, p1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    invoke-static {v1}, Lio/vov/vitamio/MediaPlayer;->loadVVO_native(Ljava/lang/String;)Z

    move-result v0

    goto :goto_0
.end method

.method private static load_lib(Ljava/lang/String;Ljava/lang/String;)Z
    .locals 1
    .param p0, "path"    # Ljava/lang/String;
    .param p1, "name"    # Ljava/lang/String;

    .prologue
    .line 257
    const-string v0, ""

    if-ne p0, v0, :cond_0

    .line 258
    invoke-static {p1}, Ljava/lang/System;->load(Ljava/lang/String;)V

    .line 263
    :goto_0
    const/4 v0, 0x1

    return v0

    .line 261
    :cond_0
    new-instance v0, Ljava/lang/StringBuilder;

    invoke-direct {v0}, Ljava/lang/StringBuilder;-><init>()V

    invoke-virtual {v0, p0}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0, p1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    invoke-static {v0}, Ljava/lang/System;->load(Ljava/lang/String;)V

    goto :goto_0
.end method

.method private static load_omxnative_lib(Ljava/lang/String;Ljava/lang/String;)Z
    .locals 2
    .param p0, "path"    # Ljava/lang/String;
    .param p1, "name"    # Ljava/lang/String;

    .prologue
    .line 215
    const/4 v0, 0x0

    .line 216
    .local v0, "load":Z
    const-string v1, ""

    if-ne p0, v1, :cond_0

    .line 217
    invoke-static {p1}, Lio/vov/vitamio/MediaPlayer;->loadOMX_native(Ljava/lang/String;)Z

    move-result v0

    .line 222
    :goto_0
    return v0

    .line 220
    :cond_0
    new-instance v1, Ljava/lang/StringBuilder;

    invoke-direct {v1}, Ljava/lang/StringBuilder;-><init>()V

    invoke-virtual {v1, p0}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1, p1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    invoke-static {v1}, Lio/vov/vitamio/MediaPlayer;->loadOMX_native(Ljava/lang/String;)Z

    move-result v0

    goto :goto_0
.end method

.method private final native native_finalize()V
.end method

.method private final native native_getMetadata(Ljava/util/Map;)Z
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/util/Map",
            "<[B[B>;)Z"
        }
    .end annotation
.end method

.method private final native native_getTrackInfo(Landroid/util/SparseArray;)Z
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Landroid/util/SparseArray",
            "<[B>;)Z"
        }
    .end annotation
.end method

.method private final native native_init()V
.end method

.method private parseTrackInfo([BLjava/lang/String;)Landroid/util/SparseArray;
    .locals 13
    .param p1, "tracks"    # [B
    .param p2, "encoding"    # Ljava/lang/String;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "([B",
            "Ljava/lang/String;",
            ")",
            "Landroid/util/SparseArray",
            "<",
            "Lio/vov/vitamio/MediaFormat;",
            ">;"
        }
    .end annotation

    .prologue
    const/4 v12, 0x2

    const/4 v7, 0x0

    .line 939
    new-instance v5, Landroid/util/SparseArray;

    invoke-direct {v5}, Landroid/util/SparseArray;-><init>()V

    .line 943
    .local v5, "trackSparse":Landroid/util/SparseArray;, "Landroid/util/SparseArray<Lio/vov/vitamio/MediaFormat;>;"
    :try_start_0
    new-instance v6, Ljava/lang/String;

    invoke-direct {v6, p1, p2}, Ljava/lang/String;-><init>([BLjava/lang/String;)V
    :try_end_0
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_0

    .line 948
    .local v6, "trackString":Ljava/lang/String;
    :goto_0
    const-string v8, "!#!"

    invoke-virtual {v6, v8}, Ljava/lang/String;->split(Ljava/lang/String;)[Ljava/lang/String;

    move-result-object v8

    array-length v9, v8

    :goto_1
    if-ge v7, v9, :cond_3

    aget-object v3, v8, v7

    .line 950
    .local v3, "s":Ljava/lang/String;
    const/4 v2, 0x0

    .line 951
    .local v2, "mediaFormat":Lio/vov/vitamio/MediaFormat;
    :try_start_1
    const-string v10, "\\."

    invoke-virtual {v3, v10}, Ljava/lang/String;->split(Ljava/lang/String;)[Ljava/lang/String;
    :try_end_1
    .catch Ljava/lang/NumberFormatException; {:try_start_1 .. :try_end_1} :catch_1

    move-result-object v1

    .line 952
    .local v1, "formats":[Ljava/lang/String;
    if-nez v1, :cond_0

    .line 948
    .end local v1    # "formats":[Ljava/lang/String;
    :goto_2
    add-int/lit8 v7, v7, 0x1

    goto :goto_1

    .line 944
    .end local v2    # "mediaFormat":Lio/vov/vitamio/MediaFormat;
    .end local v3    # "s":Ljava/lang/String;
    .end local v6    # "trackString":Ljava/lang/String;
    :catch_0
    move-exception v0

    .line 945
    .local v0, "e":Ljava/lang/Exception;
    const-string v8, "getTrackMap exception"

    new-array v9, v7, [Ljava/lang/Object;

    invoke-static {v8, v9}, Lio/vov/vitamio/utils/Log;->e(Ljava/lang/String;[Ljava/lang/Object;)V

    .line 946
    new-instance v6, Ljava/lang/String;

    invoke-direct {v6, p1}, Ljava/lang/String;-><init>([B)V

    .restart local v6    # "trackString":Ljava/lang/String;
    goto :goto_0

    .line 954
    .end local v0    # "e":Ljava/lang/Exception;
    .restart local v1    # "formats":[Ljava/lang/String;
    .restart local v2    # "mediaFormat":Lio/vov/vitamio/MediaFormat;
    .restart local v3    # "s":Ljava/lang/String;
    :cond_0
    const/4 v10, 0x0

    :try_start_2
    aget-object v10, v1, v10

    invoke-static {v10}, Ljava/lang/Integer;->parseInt(Ljava/lang/String;)I

    move-result v4

    .line 955
    .local v4, "trackNum":I
    array-length v10, v1

    const/4 v11, 0x3

    if-ne v10, v11, :cond_2

    .line 956
    const/4 v10, 0x2

    aget-object v10, v1, v10

    const/4 v11, 0x1

    aget-object v11, v1, v11

    invoke-static {v10, v11}, Lio/vov/vitamio/MediaFormat;->createSubtitleFormat(Ljava/lang/String;Ljava/lang/String;)Lio/vov/vitamio/MediaFormat;

    move-result-object v2

    .line 960
    :cond_1
    :goto_3
    invoke-virtual {v5, v4, v2}, Landroid/util/SparseArray;->put(ILjava/lang/Object;)V

    goto :goto_2

    .line 961
    .end local v1    # "formats":[Ljava/lang/String;
    .end local v4    # "trackNum":I
    :catch_1
    move-exception v10

    goto :goto_2

    .line 957
    .restart local v1    # "formats":[Ljava/lang/String;
    .restart local v4    # "trackNum":I
    :cond_2
    array-length v10, v1

    if-ne v10, v12, :cond_1

    .line 958
    const-string v10, ""

    const/4 v11, 0x1

    aget-object v11, v1, v11

    invoke-static {v10, v11}, Lio/vov/vitamio/MediaFormat;->createSubtitleFormat(Ljava/lang/String;Ljava/lang/String;)Lio/vov/vitamio/MediaFormat;
    :try_end_2
    .catch Ljava/lang/NumberFormatException; {:try_start_2 .. :try_end_2} :catch_1

    move-result-object v2

    goto :goto_3

    .line 965
    .end local v1    # "formats":[Ljava/lang/String;
    .end local v2    # "mediaFormat":Lio/vov/vitamio/MediaFormat;
    .end local v3    # "s":Ljava/lang/String;
    .end local v4    # "trackNum":I
    :cond_3
    return-object v5
.end method

.method private static postEventFromNative(Ljava/lang/Object;IIILjava/lang/Object;)V
    .locals 5
    .param p0, "mediaplayer_ref"    # Ljava/lang/Object;
    .param p1, "what"    # I
    .param p2, "arg1"    # I
    .param p3, "arg2"    # I
    .param p4, "obj"    # Ljava/lang/Object;

    .prologue
    .line 341
    check-cast p0, Lio/vov/vitamio/MediaPlayer;

    .end local p0    # "mediaplayer_ref":Ljava/lang/Object;
    move-object v2, p0

    check-cast v2, Lio/vov/vitamio/MediaPlayer;

    .line 342
    .local v2, "mp":Lio/vov/vitamio/MediaPlayer;
    if-nez v2, :cond_1

    .line 354
    :cond_0
    :goto_0
    return-void

    .line 347
    :cond_1
    :try_start_0
    iget-object v3, v2, Lio/vov/vitamio/MediaPlayer;->mEventHandler:Lio/vov/vitamio/MediaPlayer$EventHandler;

    if-eqz v3, :cond_0

    .line 348
    iget-object v3, v2, Lio/vov/vitamio/MediaPlayer;->mEventHandler:Lio/vov/vitamio/MediaPlayer$EventHandler;

    invoke-virtual {v3, p1, p2, p3, p4}, Lio/vov/vitamio/MediaPlayer$EventHandler;->obtainMessage(IIILjava/lang/Object;)Landroid/os/Message;

    move-result-object v1

    .line 349
    .local v1, "m":Landroid/os/Message;
    iget-object v3, v2, Lio/vov/vitamio/MediaPlayer;->mEventHandler:Lio/vov/vitamio/MediaPlayer$EventHandler;

    invoke-virtual {v3, v1}, Lio/vov/vitamio/MediaPlayer$EventHandler;->sendMessage(Landroid/os/Message;)Z
    :try_end_0
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_0

    goto :goto_0

    .line 351
    .end local v1    # "m":Landroid/os/Message;
    :catch_0
    move-exception v0

    .line 352
    .local v0, "e":Ljava/lang/Exception;
    new-instance v3, Ljava/lang/StringBuilder;

    invoke-direct {v3}, Ljava/lang/StringBuilder;-><init>()V

    const-string v4, "exception: "

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    invoke-virtual {v3, v0}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    move-result-object v3

    invoke-virtual {v3}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v3

    const/4 v4, 0x0

    new-array v4, v4, [Ljava/lang/Object;

    invoke-static {v3, v4}, Lio/vov/vitamio/utils/Log;->e(Ljava/lang/String;[Ljava/lang/Object;)V

    goto :goto_0
.end method

.method private selectOrDeselectBandTrack(IZ)V
    .locals 5
    .param p1, "index"    # I
    .param p2, "select"    # Z

    .prologue
    const/4 v4, 0x0

    .line 1029
    iget-object v3, p0, Lio/vov/vitamio/MediaPlayer;->mOutOfBandTracks:Lio/vov/vitamio/MediaPlayer$TrackInfo;

    if-eqz v3, :cond_0

    .line 1030
    iget-object v3, p0, Lio/vov/vitamio/MediaPlayer;->mOutOfBandTracks:Lio/vov/vitamio/MediaPlayer$TrackInfo;

    invoke-virtual {v3}, Lio/vov/vitamio/MediaPlayer$TrackInfo;->getTrackInfoArray()Landroid/util/SparseArray;

    move-result-object v1

    .line 1031
    .local v1, "mediaSparse":Landroid/util/SparseArray;, "Landroid/util/SparseArray<Lio/vov/vitamio/MediaFormat;>;"
    invoke-virtual {v1, v4}, Landroid/util/SparseArray;->keyAt(I)I

    move-result v2

    .line 1032
    .local v2, "trackIndex":I
    invoke-virtual {v1, v4}, Landroid/util/SparseArray;->valueAt(I)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lio/vov/vitamio/MediaFormat;

    .line 1033
    .local v0, "mediaFormat":Lio/vov/vitamio/MediaFormat;
    if-ne p1, v2, :cond_0

    if-eqz p2, :cond_0

    .line 1034
    const-string v3, "path"

    invoke-virtual {v0, v3}, Lio/vov/vitamio/MediaFormat;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v3

    invoke-virtual {p0, v3}, Lio/vov/vitamio/MediaPlayer;->addTimedTextSource(Ljava/lang/String;)V

    .line 1039
    .end local v0    # "mediaFormat":Lio/vov/vitamio/MediaFormat;
    .end local v1    # "mediaSparse":Landroid/util/SparseArray;, "Landroid/util/SparseArray<Lio/vov/vitamio/MediaFormat;>;"
    .end local v2    # "trackIndex":I
    :goto_0
    return-void

    .line 1038
    :cond_0
    invoke-direct {p0, p1, p2}, Lio/vov/vitamio/MediaPlayer;->selectOrDeselectTrack(IZ)V

    goto :goto_0
.end method

.method private native selectOrDeselectTrack(IZ)V
.end method

.method private stayAwake(Z)V
    .locals 1
    .param p1, "awake"    # Z
    .annotation build Landroid/annotation/SuppressLint;
        value = {
            "Wakelock"
        }
    .end annotation

    .prologue
    .line 674
    iget-object v0, p0, Lio/vov/vitamio/MediaPlayer;->mWakeLock:Landroid/os/PowerManager$WakeLock;

    if-eqz v0, :cond_0

    .line 675
    if-eqz p1, :cond_1

    iget-object v0, p0, Lio/vov/vitamio/MediaPlayer;->mWakeLock:Landroid/os/PowerManager$WakeLock;

    invoke-virtual {v0}, Landroid/os/PowerManager$WakeLock;->isHeld()Z

    move-result v0

    if-nez v0, :cond_1

    .line 676
    iget-object v0, p0, Lio/vov/vitamio/MediaPlayer;->mWakeLock:Landroid/os/PowerManager$WakeLock;

    invoke-virtual {v0}, Landroid/os/PowerManager$WakeLock;->acquire()V

    .line 681
    :cond_0
    :goto_0
    iput-boolean p1, p0, Lio/vov/vitamio/MediaPlayer;->mStayAwake:Z

    .line 682
    invoke-direct {p0}, Lio/vov/vitamio/MediaPlayer;->updateSurfaceScreenOn()V

    .line 683
    return-void

    .line 677
    :cond_1
    if-nez p1, :cond_0

    iget-object v0, p0, Lio/vov/vitamio/MediaPlayer;->mWakeLock:Landroid/os/PowerManager$WakeLock;

    invoke-virtual {v0}, Landroid/os/PowerManager$WakeLock;->isHeld()Z

    move-result v0

    if-eqz v0, :cond_0

    .line 678
    iget-object v0, p0, Lio/vov/vitamio/MediaPlayer;->mWakeLock:Landroid/os/PowerManager$WakeLock;

    invoke-virtual {v0}, Landroid/os/PowerManager$WakeLock;->release()V

    goto :goto_0
.end method

.method private surfaceInit()Ljava/nio/ByteBuffer;
    .locals 3

    .prologue
    .line 1370
    monitor-enter p0

    .line 1371
    :try_start_0
    iget-object v2, p0, Lio/vov/vitamio/MediaPlayer;->mSurface:Landroid/view/Surface;

    iput-object v2, p0, Lio/vov/vitamio/MediaPlayer;->mLocalSurface:Landroid/view/Surface;

    .line 1372
    invoke-direct {p0}, Lio/vov/vitamio/MediaPlayer;->getVideoWidth_a()I

    move-result v1

    .line 1373
    .local v1, "w":I
    invoke-direct {p0}, Lio/vov/vitamio/MediaPlayer;->getVideoHeight_a()I

    move-result v0

    .line 1374
    .local v0, "h":I
    iget-object v2, p0, Lio/vov/vitamio/MediaPlayer;->mLocalSurface:Landroid/view/Surface;

    if-eqz v2, :cond_0

    if-eqz v1, :cond_0

    if-eqz v0, :cond_0

    .line 1375
    sget-object v2, Landroid/graphics/Bitmap$Config;->RGB_565:Landroid/graphics/Bitmap$Config;

    invoke-static {v1, v0, v2}, Landroid/graphics/Bitmap;->createBitmap(IILandroid/graphics/Bitmap$Config;)Landroid/graphics/Bitmap;

    move-result-object v2

    iput-object v2, p0, Lio/vov/vitamio/MediaPlayer;->mBitmap:Landroid/graphics/Bitmap;

    .line 1376
    mul-int v2, v1, v0

    mul-int/lit8 v2, v2, 0x2

    invoke-static {v2}, Ljava/nio/ByteBuffer;->allocateDirect(I)Ljava/nio/ByteBuffer;

    move-result-object v2

    iput-object v2, p0, Lio/vov/vitamio/MediaPlayer;->mByteBuffer:Ljava/nio/ByteBuffer;

    .line 1381
    :goto_0
    iget-object v2, p0, Lio/vov/vitamio/MediaPlayer;->mByteBuffer:Ljava/nio/ByteBuffer;

    monitor-exit p0

    return-object v2

    .line 1378
    :cond_0
    const/4 v2, 0x0

    iput-object v2, p0, Lio/vov/vitamio/MediaPlayer;->mBitmap:Landroid/graphics/Bitmap;

    .line 1379
    const/4 v2, 0x0

    iput-object v2, p0, Lio/vov/vitamio/MediaPlayer;->mByteBuffer:Ljava/nio/ByteBuffer;

    goto :goto_0

    .line 1382
    .end local v0    # "h":I
    .end local v1    # "w":I
    :catchall_0
    move-exception v2

    monitor-exit p0
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    throw v2
.end method

.method private surfaceRelease()V
    .locals 1

    .prologue
    .line 1402
    monitor-enter p0

    .line 1403
    const/4 v0, 0x0

    :try_start_0
    iput-object v0, p0, Lio/vov/vitamio/MediaPlayer;->mLocalSurface:Landroid/view/Surface;

    .line 1404
    const/4 v0, 0x0

    iput-object v0, p0, Lio/vov/vitamio/MediaPlayer;->mBitmap:Landroid/graphics/Bitmap;

    .line 1405
    const/4 v0, 0x0

    iput-object v0, p0, Lio/vov/vitamio/MediaPlayer;->mByteBuffer:Ljava/nio/ByteBuffer;

    .line 1406
    monitor-exit p0

    .line 1407
    return-void

    .line 1406
    :catchall_0
    move-exception v0

    monitor-exit p0
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    throw v0
.end method

.method private surfaceRender()V
    .locals 6

    .prologue
    .line 1386
    monitor-enter p0

    .line 1387
    :try_start_0
    iget-object v2, p0, Lio/vov/vitamio/MediaPlayer;->mLocalSurface:Landroid/view/Surface;

    if-eqz v2, :cond_0

    iget-object v2, p0, Lio/vov/vitamio/MediaPlayer;->mLocalSurface:Landroid/view/Surface;

    invoke-virtual {v2}, Landroid/view/Surface;->isValid()Z

    move-result v2

    if-eqz v2, :cond_0

    iget-object v2, p0, Lio/vov/vitamio/MediaPlayer;->mBitmap:Landroid/graphics/Bitmap;

    if-eqz v2, :cond_0

    iget-object v2, p0, Lio/vov/vitamio/MediaPlayer;->mByteBuffer:Ljava/nio/ByteBuffer;

    if-nez v2, :cond_1

    .line 1388
    :cond_0
    monitor-exit p0
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    .line 1399
    :goto_0
    return-void

    .line 1391
    :cond_1
    :try_start_1
    iget-object v2, p0, Lio/vov/vitamio/MediaPlayer;->mLocalSurface:Landroid/view/Surface;

    const/4 v3, 0x0

    invoke-virtual {v2, v3}, Landroid/view/Surface;->lockCanvas(Landroid/graphics/Rect;)Landroid/graphics/Canvas;

    move-result-object v0

    .line 1392
    .local v0, "c":Landroid/graphics/Canvas;
    iget-object v2, p0, Lio/vov/vitamio/MediaPlayer;->mBitmap:Landroid/graphics/Bitmap;

    iget-object v3, p0, Lio/vov/vitamio/MediaPlayer;->mByteBuffer:Ljava/nio/ByteBuffer;

    invoke-virtual {v2, v3}, Landroid/graphics/Bitmap;->copyPixelsFromBuffer(Ljava/nio/Buffer;)V

    .line 1393
    iget-object v2, p0, Lio/vov/vitamio/MediaPlayer;->mBitmap:Landroid/graphics/Bitmap;

    const/4 v3, 0x0

    const/4 v4, 0x0

    const/4 v5, 0x0

    invoke-virtual {v0, v2, v3, v4, v5}, Landroid/graphics/Canvas;->drawBitmap(Landroid/graphics/Bitmap;FFLandroid/graphics/Paint;)V

    .line 1394
    iget-object v2, p0, Lio/vov/vitamio/MediaPlayer;->mLocalSurface:Landroid/view/Surface;

    invoke-virtual {v2, v0}, Landroid/view/Surface;->unlockCanvasAndPost(Landroid/graphics/Canvas;)V
    :try_end_1
    .catch Ljava/lang/Exception; {:try_start_1 .. :try_end_1} :catch_0
    .catchall {:try_start_1 .. :try_end_1} :catchall_0

    .line 1398
    .end local v0    # "c":Landroid/graphics/Canvas;
    :goto_1
    :try_start_2
    monitor-exit p0

    goto :goto_0

    :catchall_0
    move-exception v2

    monitor-exit p0
    :try_end_2
    .catchall {:try_start_2 .. :try_end_2} :catchall_0

    throw v2

    .line 1395
    :catch_0
    move-exception v1

    .line 1396
    .local v1, "e":Ljava/lang/Exception;
    :try_start_3
    const-string v2, "surfaceRender"

    invoke-static {v2, v1}, Lio/vov/vitamio/utils/Log;->e(Ljava/lang/String;Ljava/lang/Throwable;)V
    :try_end_3
    .catchall {:try_start_3 .. :try_end_3} :catchall_0

    goto :goto_1
.end method

.method private static native unloadOMX_native()V
.end method

.method private updateCacheStatus(II[J)V
    .locals 4
    .param p1, "type"    # I
    .param p2, "info"    # I
    .param p3, "segments"    # [J

    .prologue
    .line 1089
    iget-object v2, p0, Lio/vov/vitamio/MediaPlayer;->mEventHandler:Lio/vov/vitamio/MediaPlayer$EventHandler;

    if-eqz v2, :cond_0

    .line 1090
    iget-object v2, p0, Lio/vov/vitamio/MediaPlayer;->mEventHandler:Lio/vov/vitamio/MediaPlayer$EventHandler;

    const/16 v3, 0x7d0

    invoke-virtual {v2, v3}, Lio/vov/vitamio/MediaPlayer$EventHandler;->obtainMessage(I)Landroid/os/Message;

    move-result-object v1

    .line 1091
    .local v1, "m":Landroid/os/Message;
    invoke-virtual {v1}, Landroid/os/Message;->getData()Landroid/os/Bundle;

    move-result-object v0

    .line 1092
    .local v0, "b":Landroid/os/Bundle;
    const-string v2, "caching_type"

    invoke-virtual {v0, v2, p1}, Landroid/os/Bundle;->putInt(Ljava/lang/String;I)V

    .line 1093
    const-string v2, "caching_info"

    invoke-virtual {v0, v2, p2}, Landroid/os/Bundle;->putInt(Ljava/lang/String;I)V

    .line 1094
    const-string v2, "caching_segment"

    invoke-virtual {v0, v2, p3}, Landroid/os/Bundle;->putLongArray(Ljava/lang/String;[J)V

    .line 1095
    iget-object v2, p0, Lio/vov/vitamio/MediaPlayer;->mEventHandler:Lio/vov/vitamio/MediaPlayer$EventHandler;

    invoke-virtual {v2, v1}, Lio/vov/vitamio/MediaPlayer$EventHandler;->sendMessage(Landroid/os/Message;)Z

    .line 1097
    .end local v0    # "b":Landroid/os/Bundle;
    .end local v1    # "m":Landroid/os/Message;
    :cond_0
    return-void
.end method

.method private updateSub(I[BLjava/lang/String;II)V
    .locals 6
    .param p1, "subType"    # I
    .param p2, "bytes"    # [B
    .param p3, "encoding"    # Ljava/lang/String;
    .param p4, "width"    # I
    .param p5, "height"    # I

    .prologue
    const/4 v5, 0x1

    .line 1141
    iget-object v3, p0, Lio/vov/vitamio/MediaPlayer;->mEventHandler:Lio/vov/vitamio/MediaPlayer$EventHandler;

    if-eqz v3, :cond_1

    .line 1142
    iget-object v3, p0, Lio/vov/vitamio/MediaPlayer;->mEventHandler:Lio/vov/vitamio/MediaPlayer$EventHandler;

    const/16 v4, 0x3e8

    invoke-virtual {v3, v4, p4, p5}, Lio/vov/vitamio/MediaPlayer$EventHandler;->obtainMessage(III)Landroid/os/Message;

    move-result-object v2

    .line 1143
    .local v2, "m":Landroid/os/Message;
    invoke-virtual {v2}, Landroid/os/Message;->getData()Landroid/os/Bundle;

    move-result-object v0

    .line 1144
    .local v0, "b":Landroid/os/Bundle;
    if-nez p1, :cond_3

    .line 1145
    const-string v3, "sub_type"

    const/4 v4, 0x0

    invoke-virtual {v0, v3, v4}, Landroid/os/Bundle;->putInt(Ljava/lang/String;I)V

    .line 1146
    if-nez p3, :cond_2

    .line 1147
    const-string v3, "sub_string"

    new-instance v4, Ljava/lang/String;

    invoke-direct {v4, p2}, Ljava/lang/String;-><init>([B)V

    invoke-virtual {v0, v3, v4}, Landroid/os/Bundle;->putString(Ljava/lang/String;Ljava/lang/String;)V

    .line 1160
    :cond_0
    :goto_0
    iget-object v3, p0, Lio/vov/vitamio/MediaPlayer;->mEventHandler:Lio/vov/vitamio/MediaPlayer$EventHandler;

    invoke-virtual {v3, v2}, Lio/vov/vitamio/MediaPlayer$EventHandler;->sendMessage(Landroid/os/Message;)Z

    .line 1162
    .end local v0    # "b":Landroid/os/Bundle;
    .end local v2    # "m":Landroid/os/Message;
    :cond_1
    return-void

    .line 1150
    .restart local v0    # "b":Landroid/os/Bundle;
    .restart local v2    # "m":Landroid/os/Message;
    :cond_2
    :try_start_0
    const-string v3, "sub_string"

    new-instance v4, Ljava/lang/String;

    invoke-virtual {p3}, Ljava/lang/String;->trim()Ljava/lang/String;

    move-result-object v5

    invoke-direct {v4, p2, v5}, Ljava/lang/String;-><init>([BLjava/lang/String;)V

    invoke-virtual {v0, v3, v4}, Landroid/os/Bundle;->putString(Ljava/lang/String;Ljava/lang/String;)V
    :try_end_0
    .catch Ljava/io/UnsupportedEncodingException; {:try_start_0 .. :try_end_0} :catch_0

    goto :goto_0

    .line 1151
    :catch_0
    move-exception v1

    .line 1152
    .local v1, "e":Ljava/io/UnsupportedEncodingException;
    const-string v3, "updateSub"

    invoke-static {v3, v1}, Lio/vov/vitamio/utils/Log;->e(Ljava/lang/String;Ljava/lang/Throwable;)V

    .line 1153
    const-string v3, "sub_string"

    new-instance v4, Ljava/lang/String;

    invoke-direct {v4, p2}, Ljava/lang/String;-><init>([B)V

    invoke-virtual {v0, v3, v4}, Landroid/os/Bundle;->putString(Ljava/lang/String;Ljava/lang/String;)V

    goto :goto_0

    .line 1156
    .end local v1    # "e":Ljava/io/UnsupportedEncodingException;
    :cond_3
    if-ne p1, v5, :cond_0

    .line 1157
    const-string v3, "sub_type"

    invoke-virtual {v0, v3, v5}, Landroid/os/Bundle;->putInt(Ljava/lang/String;I)V

    .line 1158
    const-string v3, "sub_bytes"

    invoke-virtual {v0, v3, p2}, Landroid/os/Bundle;->putByteArray(Ljava/lang/String;[B)V

    goto :goto_0
.end method

.method private updateSurfaceScreenOn()V
    .locals 2

    .prologue
    .line 686
    iget-object v0, p0, Lio/vov/vitamio/MediaPlayer;->mSurfaceHolder:Landroid/view/SurfaceHolder;

    if-eqz v0, :cond_0

    .line 687
    iget-object v1, p0, Lio/vov/vitamio/MediaPlayer;->mSurfaceHolder:Landroid/view/SurfaceHolder;

    iget-boolean v0, p0, Lio/vov/vitamio/MediaPlayer;->mScreenOnWhilePlaying:Z

    if-eqz v0, :cond_1

    iget-boolean v0, p0, Lio/vov/vitamio/MediaPlayer;->mStayAwake:Z

    if-eqz v0, :cond_1

    const/4 v0, 0x1

    :goto_0
    invoke-interface {v1, v0}, Landroid/view/SurfaceHolder;->setKeepScreenOn(Z)V

    .line 688
    :cond_0
    return-void

    .line 687
    :cond_1
    const/4 v0, 0x0

    goto :goto_0
.end method


# virtual methods
.method protected native _releaseVideoSurface()V
.end method

.method public native addTimedTextSource(Ljava/lang/String;)V
.end method

.method public native audioInitedOk(J)V
.end method

.method public audioTrackInit()I
    .locals 8

    .prologue
    const/4 v1, 0x2

    .line 1317
    invoke-direct {p0}, Lio/vov/vitamio/MediaPlayer;->audioTrackRelease()V

    .line 1318
    iget v0, p0, Lio/vov/vitamio/MediaPlayer;->channels:I

    if-lt v0, v1, :cond_0

    const/16 v3, 0xc

    .line 1320
    .local v3, "channelConfig":I
    :goto_0
    :try_start_0
    iget v0, p0, Lio/vov/vitamio/MediaPlayer;->sampleRateInHz:I

    const/4 v1, 0x2

    invoke-static {v0, v3, v1}, Landroid/media/AudioTrack;->getMinBufferSize(III)I

    move-result v0

    iput v0, p0, Lio/vov/vitamio/MediaPlayer;->mAudioTrackBufferSize:I

    .line 1321
    new-instance v0, Landroid/media/AudioTrack;

    const/4 v1, 0x3

    iget v2, p0, Lio/vov/vitamio/MediaPlayer;->sampleRateInHz:I

    const/4 v4, 0x2

    iget v5, p0, Lio/vov/vitamio/MediaPlayer;->mAudioTrackBufferSize:I

    const/4 v6, 0x1

    invoke-direct/range {v0 .. v6}, Landroid/media/AudioTrack;-><init>(IIIIII)V

    iput-object v0, p0, Lio/vov/vitamio/MediaPlayer;->mAudioTrack:Landroid/media/AudioTrack;
    :try_end_0
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_0

    .line 1326
    :goto_1
    iget v0, p0, Lio/vov/vitamio/MediaPlayer;->mAudioTrackBufferSize:I

    return v0

    .line 1318
    .end local v3    # "channelConfig":I
    :cond_0
    const/4 v3, 0x4

    goto :goto_0

    .line 1322
    .restart local v3    # "channelConfig":I
    :catch_0
    move-exception v7

    .line 1323
    .local v7, "e":Ljava/lang/Exception;
    const/4 v0, 0x0

    iput v0, p0, Lio/vov/vitamio/MediaPlayer;->mAudioTrackBufferSize:I

    .line 1324
    const-string v0, "audioTrackInit"

    invoke-static {v0, v7}, Lio/vov/vitamio/utils/Log;->e(Ljava/lang/String;Ljava/lang/Throwable;)V

    goto :goto_1
.end method

.method public deselectTrack(I)V
    .locals 1
    .param p1, "index"    # I

    .prologue
    .line 1025
    const/4 v0, 0x0

    invoke-direct {p0, p1, v0}, Lio/vov/vitamio/MediaPlayer;->selectOrDeselectBandTrack(IZ)V

    .line 1026
    return-void
.end method

.method protected finalize()V
    .locals 0

    .prologue
    .line 1045
    invoke-direct {p0}, Lio/vov/vitamio/MediaPlayer;->native_finalize()V

    .line 1046
    return-void
.end method

.method public findTrackFromTrackInfo(I[Lio/vov/vitamio/MediaPlayer$TrackInfo;)Landroid/util/SparseArray;
    .locals 2
    .param p1, "mediaTrackType"    # I
    .param p2, "trackInfo"    # [Lio/vov/vitamio/MediaPlayer$TrackInfo;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(I[",
            "Lio/vov/vitamio/MediaPlayer$TrackInfo;",
            ")",
            "Landroid/util/SparseArray",
            "<",
            "Lio/vov/vitamio/MediaFormat;",
            ">;"
        }
    .end annotation

    .prologue
    .line 974
    const/4 v0, 0x0

    .local v0, "i":I
    :goto_0
    array-length v1, p2

    if-ge v0, v1, :cond_1

    .line 975
    aget-object v1, p2, v0

    invoke-virtual {v1}, Lio/vov/vitamio/MediaPlayer$TrackInfo;->getTrackType()I

    move-result v1

    if-ne v1, p1, :cond_0

    .line 976
    aget-object v1, p2, v0

    invoke-virtual {v1}, Lio/vov/vitamio/MediaPlayer$TrackInfo;->getTrackInfoArray()Landroid/util/SparseArray;

    move-result-object v1

    .line 979
    :goto_1
    return-object v1

    .line 974
    :cond_0
    add-int/lit8 v0, v0, 0x1

    goto :goto_0

    .line 979
    :cond_1
    const/4 v1, 0x0

    goto :goto_1
.end method

.method public getAudioSessionId()I
    .locals 1

    .prologue
    .line 1366
    iget-object v0, p0, Lio/vov/vitamio/MediaPlayer;->mAudioTrack:Landroid/media/AudioTrack;

    invoke-virtual {v0}, Landroid/media/AudioTrack;->getAudioSessionId()I

    move-result v0

    return v0
.end method

.method public native getAudioTrack()I
.end method

.method public native getBufferProgress()I
.end method

.method public native getCurrentFrame()Landroid/graphics/Bitmap;
.end method

.method public native getCurrentPosition()J
.end method

.method public native getDuration()J
.end method

.method public native getMetaEncoding()Ljava/lang/String;
.end method

.method public getMetadata()Lio/vov/vitamio/Metadata;
    .locals 4

    .prologue
    const/4 v1, 0x0

    .line 779
    iget-object v2, p0, Lio/vov/vitamio/MediaPlayer;->mMeta:Lio/vov/vitamio/Metadata;

    if-nez v2, :cond_2

    .line 780
    new-instance v2, Lio/vov/vitamio/Metadata;

    invoke-direct {v2}, Lio/vov/vitamio/Metadata;-><init>()V

    iput-object v2, p0, Lio/vov/vitamio/MediaPlayer;->mMeta:Lio/vov/vitamio/Metadata;

    .line 781
    new-instance v0, Ljava/util/HashMap;

    invoke-direct {v0}, Ljava/util/HashMap;-><init>()V

    .line 783
    .local v0, "meta":Ljava/util/Map;, "Ljava/util/Map<[B[B>;"
    invoke-direct {p0, v0}, Lio/vov/vitamio/MediaPlayer;->native_getMetadata(Ljava/util/Map;)Z

    move-result v2

    if-nez v2, :cond_1

    .line 791
    .end local v0    # "meta":Ljava/util/Map;, "Ljava/util/Map<[B[B>;"
    :cond_0
    :goto_0
    return-object v1

    .line 787
    .restart local v0    # "meta":Ljava/util/Map;, "Ljava/util/Map<[B[B>;"
    :cond_1
    iget-object v2, p0, Lio/vov/vitamio/MediaPlayer;->mMeta:Lio/vov/vitamio/Metadata;

    invoke-virtual {p0}, Lio/vov/vitamio/MediaPlayer;->getMetaEncoding()Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v2, v0, v3}, Lio/vov/vitamio/Metadata;->parse(Ljava/util/Map;Ljava/lang/String;)Z

    move-result v2

    if-eqz v2, :cond_0

    .line 791
    .end local v0    # "meta":Ljava/util/Map;, "Ljava/util/Map<[B[B>;"
    :cond_2
    iget-object v1, p0, Lio/vov/vitamio/MediaPlayer;->mMeta:Lio/vov/vitamio/Metadata;

    goto :goto_0
.end method

.method public native getTimedTextLocation()I
.end method

.method public native getTimedTextPath()Ljava/lang/String;
.end method

.method public native getTimedTextTrack()I
.end method

.method public getTrackInfo()[Lio/vov/vitamio/MediaPlayer$TrackInfo;
    .locals 1

    .prologue
    .line 935
    invoke-static {}, Ljava/nio/charset/Charset;->defaultCharset()Ljava/nio/charset/Charset;

    move-result-object v0

    invoke-virtual {v0}, Ljava/nio/charset/Charset;->name()Ljava/lang/String;

    move-result-object v0

    invoke-virtual {p0, v0}, Lio/vov/vitamio/MediaPlayer;->getTrackInfo(Ljava/lang/String;)[Lio/vov/vitamio/MediaPlayer$TrackInfo;

    move-result-object v0

    return-object v0
.end method

.method public getTrackInfo(Ljava/lang/String;)[Lio/vov/vitamio/MediaPlayer$TrackInfo;
    .locals 10
    .param p1, "encoding"    # Ljava/lang/String;

    .prologue
    const/4 v9, 0x0

    .line 888
    invoke-direct {p0, p1}, Lio/vov/vitamio/MediaPlayer;->getInbandTrackInfo(Ljava/lang/String;)[Lio/vov/vitamio/MediaPlayer$TrackInfo;

    move-result-object v5

    .line 890
    .local v5, "trackInfo":[Lio/vov/vitamio/MediaPlayer$TrackInfo;
    invoke-virtual {p0}, Lio/vov/vitamio/MediaPlayer;->getTimedTextPath()Ljava/lang/String;

    move-result-object v3

    .line 891
    .local v3, "timedTextPath":Ljava/lang/String;
    invoke-static {v3}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result v7

    if-eqz v7, :cond_0

    .line 908
    .end local v5    # "trackInfo":[Lio/vov/vitamio/MediaPlayer$TrackInfo;
    :goto_0
    return-object v5

    .line 894
    .restart local v5    # "trackInfo":[Lio/vov/vitamio/MediaPlayer$TrackInfo;
    :cond_0
    array-length v7, v5

    add-int/lit8 v7, v7, 0x1

    new-array v0, v7, [Lio/vov/vitamio/MediaPlayer$TrackInfo;

    .line 895
    .local v0, "allTrackInfo":[Lio/vov/vitamio/MediaPlayer$TrackInfo;
    array-length v7, v5

    invoke-static {v5, v9, v0, v9, v7}, Ljava/lang/System;->arraycopy(Ljava/lang/Object;ILjava/lang/Object;II)V

    .line 896
    array-length v1, v5

    .line 897
    .local v1, "i":I
    new-instance v6, Landroid/util/SparseArray;

    invoke-direct {v6}, Landroid/util/SparseArray;-><init>()V

    .line 898
    .local v6, "trackInfoArray":Landroid/util/SparseArray;, "Landroid/util/SparseArray<Lio/vov/vitamio/MediaFormat;>;"
    new-instance v2, Lio/vov/vitamio/MediaFormat;

    invoke-direct {v2}, Lio/vov/vitamio/MediaFormat;-><init>()V

    .line 899
    .local v2, "mediaFormat":Lio/vov/vitamio/MediaFormat;
    const-string v7, "title"

    const-string v8, "/"

    invoke-virtual {v3, v8}, Ljava/lang/String;->lastIndexOf(Ljava/lang/String;)I

    move-result v8

    invoke-virtual {v3, v8}, Ljava/lang/String;->substring(I)Ljava/lang/String;

    move-result-object v8

    invoke-virtual {v2, v7, v8}, Lio/vov/vitamio/MediaFormat;->setString(Ljava/lang/String;Ljava/lang/String;)V

    .line 900
    const-string v7, "path"

    invoke-virtual {v2, v7, v3}, Lio/vov/vitamio/MediaFormat;->setString(Ljava/lang/String;Ljava/lang/String;)V

    .line 901
    const/4 v7, 0x3

    invoke-virtual {p0, v7, v5}, Lio/vov/vitamio/MediaPlayer;->findTrackFromTrackInfo(I[Lio/vov/vitamio/MediaPlayer$TrackInfo;)Landroid/util/SparseArray;

    move-result-object v4

    .line 902
    .local v4, "timedTextSparse":Landroid/util/SparseArray;, "Landroid/util/SparseArray<Lio/vov/vitamio/MediaFormat;>;"
    if-eqz v4, :cond_1

    invoke-virtual {v4}, Landroid/util/SparseArray;->size()I

    move-result v7

    if-nez v7, :cond_2

    .line 903
    :cond_1
    invoke-virtual {v4, v9}, Landroid/util/SparseArray;->keyAt(I)I

    move-result v7

    invoke-virtual {v6, v7, v2}, Landroid/util/SparseArray;->put(ILjava/lang/Object;)V

    .line 906
    :goto_1
    new-instance v7, Lio/vov/vitamio/MediaPlayer$TrackInfo;

    const/4 v8, 0x4

    invoke-direct {v7, v8, v6}, Lio/vov/vitamio/MediaPlayer$TrackInfo;-><init>(ILandroid/util/SparseArray;)V

    iput-object v7, p0, Lio/vov/vitamio/MediaPlayer;->mOutOfBandTracks:Lio/vov/vitamio/MediaPlayer$TrackInfo;

    .line 907
    iget-object v7, p0, Lio/vov/vitamio/MediaPlayer;->mOutOfBandTracks:Lio/vov/vitamio/MediaPlayer$TrackInfo;

    aput-object v7, v0, v1

    move-object v5, v0

    .line 908
    goto :goto_0

    .line 905
    :cond_2
    invoke-virtual {v4}, Landroid/util/SparseArray;->size()I

    move-result v7

    add-int/lit8 v7, v7, -0x1

    invoke-virtual {v4, v7}, Landroid/util/SparseArray;->keyAt(I)I

    move-result v7

    invoke-virtual {v6, v7, v2}, Landroid/util/SparseArray;->put(ILjava/lang/Object;)V

    goto :goto_1
.end method

.method public native getVideoAspectRatio()F
.end method

.method public native getVideoHeight()I
.end method

.method public native getVideoTrack()I
.end method

.method public native getVideoWidth()I
.end method

.method public native isBuffering()Z
.end method

.method public native isLooping()Z
.end method

.method public native isPlaying()Z
.end method

.method public pause()V
    .locals 1
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/lang/IllegalStateException;
        }
    .end annotation

    .prologue
    const/4 v0, 0x0

    .line 613
    invoke-direct {p0, v0}, Lio/vov/vitamio/MediaPlayer;->stayAwake(Z)V

    .line 614
    iput-boolean v0, p0, Lio/vov/vitamio/MediaPlayer;->mNeedResume:Z

    .line 616
    invoke-direct {p0}, Lio/vov/vitamio/MediaPlayer;->_pause()V

    .line 617
    return-void
.end method

.method public native prepare()V
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;,
            Ljava/lang/IllegalStateException;
        }
    .end annotation
.end method

.method public native prepareAsync()V
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/lang/IllegalStateException;
        }
    .end annotation
.end method

.method public release()V
    .locals 2

    .prologue
    const/4 v1, 0x0

    const/4 v0, 0x0

    .line 800
    invoke-direct {p0, v1}, Lio/vov/vitamio/MediaPlayer;->stayAwake(Z)V

    .line 801
    invoke-direct {p0}, Lio/vov/vitamio/MediaPlayer;->updateSurfaceScreenOn()V

    .line 802
    iput-object v0, p0, Lio/vov/vitamio/MediaPlayer;->mOnPreparedListener:Lio/vov/vitamio/MediaPlayer$OnPreparedListener;

    .line 803
    iput-object v0, p0, Lio/vov/vitamio/MediaPlayer;->mOnBufferingUpdateListener:Lio/vov/vitamio/MediaPlayer$OnBufferingUpdateListener;

    .line 804
    iput-object v0, p0, Lio/vov/vitamio/MediaPlayer;->mOnCompletionListener:Lio/vov/vitamio/MediaPlayer$OnCompletionListener;

    .line 805
    iput-object v0, p0, Lio/vov/vitamio/MediaPlayer;->mOnSeekCompleteListener:Lio/vov/vitamio/MediaPlayer$OnSeekCompleteListener;

    .line 806
    iput-object v0, p0, Lio/vov/vitamio/MediaPlayer;->mOnErrorListener:Lio/vov/vitamio/MediaPlayer$OnErrorListener;

    .line 807
    iput-object v0, p0, Lio/vov/vitamio/MediaPlayer;->mOnInfoListener:Lio/vov/vitamio/MediaPlayer$OnInfoListener;

    .line 808
    iput-object v0, p0, Lio/vov/vitamio/MediaPlayer;->mOnVideoSizeChangedListener:Lio/vov/vitamio/MediaPlayer$OnVideoSizeChangedListener;

    .line 809
    iput-object v0, p0, Lio/vov/vitamio/MediaPlayer;->mOnCachingUpdateListener:Lio/vov/vitamio/MediaPlayer$OnCachingUpdateListener;

    .line 810
    iput-object v0, p0, Lio/vov/vitamio/MediaPlayer;->mOnHWRenderFailedListener:Lio/vov/vitamio/MediaPlayer$OnHWRenderFailedListener;

    .line 811
    iget-object v0, p0, Lio/vov/vitamio/MediaPlayer;->mEventHandler:Lio/vov/vitamio/MediaPlayer$EventHandler;

    if-eqz v0, :cond_0

    .line 812
    iget-object v0, p0, Lio/vov/vitamio/MediaPlayer;->mEventHandler:Lio/vov/vitamio/MediaPlayer$EventHandler;

    invoke-virtual {v0}, Lio/vov/vitamio/MediaPlayer$EventHandler;->release()V

    .line 814
    :cond_0
    invoke-direct {p0}, Lio/vov/vitamio/MediaPlayer;->_release()V

    .line 815
    invoke-direct {p0}, Lio/vov/vitamio/MediaPlayer;->closeFD()V

    .line 816
    iput-boolean v1, p0, Lio/vov/vitamio/MediaPlayer;->mInBuffering:Z

    .line 817
    iput-boolean v1, p0, Lio/vov/vitamio/MediaPlayer;->mNeedResume:Z

    .line 818
    return-void
.end method

.method public releaseDisplay()V
    .locals 1

    .prologue
    const/4 v0, 0x0

    .line 1170
    invoke-virtual {p0}, Lio/vov/vitamio/MediaPlayer;->_releaseVideoSurface()V

    .line 1171
    iput-object v0, p0, Lio/vov/vitamio/MediaPlayer;->mSurfaceHolder:Landroid/view/SurfaceHolder;

    .line 1172
    iput-object v0, p0, Lio/vov/vitamio/MediaPlayer;->mSurface:Landroid/view/Surface;

    .line 1173
    return-void
.end method

.method public reset()V
    .locals 3

    .prologue
    const/4 v2, 0x0

    .line 828
    invoke-direct {p0, v2}, Lio/vov/vitamio/MediaPlayer;->stayAwake(Z)V

    .line 829
    invoke-direct {p0}, Lio/vov/vitamio/MediaPlayer;->_reset()V

    .line 830
    iget-object v0, p0, Lio/vov/vitamio/MediaPlayer;->mEventHandler:Lio/vov/vitamio/MediaPlayer$EventHandler;

    if-eqz v0, :cond_0

    .line 831
    iget-object v0, p0, Lio/vov/vitamio/MediaPlayer;->mEventHandler:Lio/vov/vitamio/MediaPlayer$EventHandler;

    const/4 v1, 0x0

    invoke-virtual {v0, v1}, Lio/vov/vitamio/MediaPlayer$EventHandler;->removeCallbacksAndMessages(Ljava/lang/Object;)V

    .line 832
    :cond_0
    invoke-direct {p0}, Lio/vov/vitamio/MediaPlayer;->closeFD()V

    .line 833
    iput-boolean v2, p0, Lio/vov/vitamio/MediaPlayer;->mInBuffering:Z

    .line 834
    iput-boolean v2, p0, Lio/vov/vitamio/MediaPlayer;->mNeedResume:Z

    .line 835
    return-void
.end method

.method public native seekTo(J)V
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/lang/IllegalStateException;
        }
    .end annotation
.end method

.method public selectTrack(I)V
    .locals 1
    .param p1, "index"    # I

    .prologue
    .line 1008
    const/4 v0, 0x1

    invoke-direct {p0, p1, v0}, Lio/vov/vitamio/MediaPlayer;->selectOrDeselectBandTrack(IZ)V

    .line 1009
    return-void
.end method

.method public native setAdaptiveStream(Z)V
.end method

.method public native setAudioAmplify(F)V
.end method

.method public native setBufferSize(J)V
.end method

.method public native setCacheDirectory(Ljava/lang/String;)V
.end method

.method public setDataSegments([Ljava/lang/String;Ljava/lang/String;)V
    .locals 0
    .param p1, "uris"    # [Ljava/lang/String;
    .param p2, "cacheDir"    # Ljava/lang/String;

    .prologue
    .line 515
    invoke-direct {p0, p1, p2}, Lio/vov/vitamio/MediaPlayer;->_setDataSegmentsSource([Ljava/lang/String;Ljava/lang/String;)V

    .line 516
    return-void
.end method

.method public setDataSource(Landroid/content/Context;Landroid/net/Uri;)V
    .locals 1
    .param p1, "context"    # Landroid/content/Context;
    .param p2, "uri"    # Landroid/net/Uri;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;,
            Ljava/lang/IllegalArgumentException;,
            Ljava/lang/SecurityException;,
            Ljava/lang/IllegalStateException;
        }
    .end annotation

    .prologue
    .line 432
    const/4 v0, 0x0

    invoke-virtual {p0, p1, p2, v0}, Lio/vov/vitamio/MediaPlayer;->setDataSource(Landroid/content/Context;Landroid/net/Uri;Ljava/util/Map;)V

    .line 433
    return-void
.end method

.method public setDataSource(Landroid/content/Context;Landroid/net/Uri;Ljava/util/Map;)V
    .locals 4
    .param p1, "context"    # Landroid/content/Context;
    .param p2, "uri"    # Landroid/net/Uri;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Landroid/content/Context;",
            "Landroid/net/Uri;",
            "Ljava/util/Map",
            "<",
            "Ljava/lang/String;",
            "Ljava/lang/String;",
            ">;)V"
        }
    .end annotation

    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;,
            Ljava/lang/IllegalArgumentException;,
            Ljava/lang/SecurityException;,
            Ljava/lang/IllegalStateException;
        }
    .end annotation

    .prologue
    .line 436
    .local p3, "headers":Ljava/util/Map;, "Ljava/util/Map<Ljava/lang/String;Ljava/lang/String;>;"
    if-eqz p1, :cond_0

    if-nez p2, :cond_1

    .line 437
    :cond_0
    new-instance v3, Ljava/lang/IllegalArgumentException;

    invoke-direct {v3}, Ljava/lang/IllegalArgumentException;-><init>()V

    throw v3

    .line 438
    :cond_1
    invoke-virtual {p2}, Landroid/net/Uri;->getScheme()Ljava/lang/String;

    move-result-object v2

    .line 439
    .local v2, "scheme":Ljava/lang/String;
    if-eqz v2, :cond_2

    const-string v3, "file"

    invoke-virtual {v2, v3}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v3

    if-eqz v3, :cond_4

    .line 440
    :cond_2
    invoke-virtual {p2}, Landroid/net/Uri;->toString()Ljava/lang/String;

    move-result-object v3

    invoke-static {v3}, Lio/vov/vitamio/utils/FileUtils;->getPath(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v3

    invoke-virtual {p0, v3}, Lio/vov/vitamio/MediaPlayer;->setDataSource(Ljava/lang/String;)V

    .line 455
    :cond_3
    :goto_0
    return-void

    .line 445
    :cond_4
    :try_start_0
    invoke-virtual {p1}, Landroid/content/Context;->getContentResolver()Landroid/content/ContentResolver;

    move-result-object v1

    .line 446
    .local v1, "resolver":Landroid/content/ContentResolver;
    const-string v3, "r"

    invoke-virtual {v1, p2, v3}, Landroid/content/ContentResolver;->openAssetFileDescriptor(Landroid/net/Uri;Ljava/lang/String;)Landroid/content/res/AssetFileDescriptor;

    move-result-object v3

    iput-object v3, p0, Lio/vov/vitamio/MediaPlayer;->mFD:Landroid/content/res/AssetFileDescriptor;

    .line 447
    iget-object v3, p0, Lio/vov/vitamio/MediaPlayer;->mFD:Landroid/content/res/AssetFileDescriptor;

    if-eqz v3, :cond_3

    .line 449
    iget-object v3, p0, Lio/vov/vitamio/MediaPlayer;->mFD:Landroid/content/res/AssetFileDescriptor;

    invoke-virtual {v3}, Landroid/content/res/AssetFileDescriptor;->getParcelFileDescriptor()Landroid/os/ParcelFileDescriptor;

    move-result-object v3

    invoke-virtual {v3}, Landroid/os/ParcelFileDescriptor;->getFileDescriptor()Ljava/io/FileDescriptor;

    move-result-object v3

    invoke-virtual {p0, v3}, Lio/vov/vitamio/MediaPlayer;->setDataSource(Ljava/io/FileDescriptor;)V
    :try_end_0
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_0

    goto :goto_0

    .line 451
    .end local v1    # "resolver":Landroid/content/ContentResolver;
    :catch_0
    move-exception v0

    .line 452
    .local v0, "e":Ljava/lang/Exception;
    invoke-direct {p0}, Lio/vov/vitamio/MediaPlayer;->closeFD()V

    .line 454
    invoke-virtual {p2}, Landroid/net/Uri;->toString()Ljava/lang/String;

    move-result-object v3

    invoke-virtual {p0, v3, p3}, Lio/vov/vitamio/MediaPlayer;->setDataSource(Ljava/lang/String;Ljava/util/Map;)V

    goto :goto_0
.end method

.method public native setDataSource(Ljava/io/FileDescriptor;)V
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;,
            Ljava/lang/IllegalArgumentException;,
            Ljava/lang/IllegalStateException;
        }
    .end annotation
.end method

.method public setDataSource(Ljava/lang/String;)V
    .locals 1
    .param p1, "path"    # Ljava/lang/String;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;,
            Ljava/lang/IllegalArgumentException;,
            Ljava/lang/SecurityException;,
            Ljava/lang/IllegalStateException;
        }
    .end annotation

    .prologue
    const/4 v0, 0x0

    .line 421
    invoke-direct {p0, p1, v0, v0}, Lio/vov/vitamio/MediaPlayer;->_setDataSource(Ljava/lang/String;[Ljava/lang/String;[Ljava/lang/String;)V

    .line 422
    return-void
.end method

.method public setDataSource(Ljava/lang/String;Ljava/util/Map;)V
    .locals 6
    .param p1, "path"    # Ljava/lang/String;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/lang/String;",
            "Ljava/util/Map",
            "<",
            "Ljava/lang/String;",
            "Ljava/lang/String;",
            ">;)V"
        }
    .end annotation

    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;,
            Ljava/lang/IllegalArgumentException;,
            Ljava/lang/SecurityException;,
            Ljava/lang/IllegalStateException;
        }
    .end annotation

    .prologue
    .line 467
    .local p2, "headers":Ljava/util/Map;, "Ljava/util/Map<Ljava/lang/String;Ljava/lang/String;>;"
    const/4 v2, 0x0

    .line 468
    .local v2, "keys":[Ljava/lang/String;
    const/4 v3, 0x0

    .line 470
    .local v3, "values":[Ljava/lang/String;
    if-eqz p2, :cond_0

    .line 471
    invoke-interface {p2}, Ljava/util/Map;->size()I

    move-result v4

    new-array v2, v4, [Ljava/lang/String;

    .line 472
    invoke-interface {p2}, Ljava/util/Map;->size()I

    move-result v4

    new-array v3, v4, [Ljava/lang/String;

    .line 474
    const/4 v1, 0x0

    .line 475
    .local v1, "i":I
    invoke-interface {p2}, Ljava/util/Map;->entrySet()Ljava/util/Set;

    move-result-object v4

    invoke-interface {v4}, Ljava/util/Set;->iterator()Ljava/util/Iterator;

    move-result-object v5

    :goto_0
    invoke-interface {v5}, Ljava/util/Iterator;->hasNext()Z

    move-result v4

    if-eqz v4, :cond_0

    invoke-interface {v5}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Ljava/util/Map$Entry;

    .line 476
    .local v0, "entry":Ljava/util/Map$Entry;, "Ljava/util/Map$Entry<Ljava/lang/String;Ljava/lang/String;>;"
    invoke-interface {v0}, Ljava/util/Map$Entry;->getKey()Ljava/lang/Object;

    move-result-object v4

    check-cast v4, Ljava/lang/String;

    aput-object v4, v2, v1

    .line 477
    invoke-interface {v0}, Ljava/util/Map$Entry;->getValue()Ljava/lang/Object;

    move-result-object v4

    check-cast v4, Ljava/lang/String;

    aput-object v4, v3, v1

    .line 478
    add-int/lit8 v1, v1, 0x1

    .line 479
    goto :goto_0

    .line 481
    .end local v0    # "entry":Ljava/util/Map$Entry;, "Ljava/util/Map$Entry<Ljava/lang/String;Ljava/lang/String;>;"
    .end local v1    # "i":I
    :cond_0
    invoke-virtual {p0, p1, v2, v3}, Lio/vov/vitamio/MediaPlayer;->setDataSource(Ljava/lang/String;[Ljava/lang/String;[Ljava/lang/String;)V

    .line 482
    return-void
.end method

.method public setDataSource(Ljava/lang/String;[Ljava/lang/String;[Ljava/lang/String;)V
    .locals 6
    .param p1, "path"    # Ljava/lang/String;
    .param p2, "keys"    # [Ljava/lang/String;
    .param p3, "values"    # [Ljava/lang/String;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;,
            Ljava/lang/IllegalArgumentException;,
            Ljava/lang/SecurityException;,
            Ljava/lang/IllegalStateException;
        }
    .end annotation

    .prologue
    .line 493
    invoke-static {p1}, Landroid/net/Uri;->parse(Ljava/lang/String;)Landroid/net/Uri;

    move-result-object v3

    .line 494
    .local v3, "uri":Landroid/net/Uri;
    const-string v4, "file"

    invoke-virtual {v3}, Landroid/net/Uri;->getScheme()Ljava/lang/String;

    move-result-object v5

    invoke-virtual {v4, v5}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v4

    if-eqz v4, :cond_0

    .line 495
    invoke-virtual {v3}, Landroid/net/Uri;->getPath()Ljava/lang/String;

    move-result-object p1

    .line 498
    :cond_0
    new-instance v1, Ljava/io/File;

    invoke-direct {v1, p1}, Ljava/io/File;-><init>(Ljava/lang/String;)V

    .line 499
    .local v1, "file":Ljava/io/File;
    invoke-virtual {v1}, Ljava/io/File;->exists()Z

    move-result v4

    if-eqz v4, :cond_1

    .line 500
    new-instance v2, Ljava/io/FileInputStream;

    invoke-direct {v2, v1}, Ljava/io/FileInputStream;-><init>(Ljava/io/File;)V

    .line 501
    .local v2, "is":Ljava/io/FileInputStream;
    invoke-virtual {v2}, Ljava/io/FileInputStream;->getFD()Ljava/io/FileDescriptor;

    move-result-object v0

    .line 502
    .local v0, "fd":Ljava/io/FileDescriptor;
    invoke-virtual {p0, v0}, Lio/vov/vitamio/MediaPlayer;->setDataSource(Ljava/io/FileDescriptor;)V

    .line 503
    invoke-virtual {v2}, Ljava/io/FileInputStream;->close()V

    .line 507
    .end local v0    # "fd":Ljava/io/FileDescriptor;
    .end local v2    # "is":Ljava/io/FileInputStream;
    :goto_0
    return-void

    .line 505
    :cond_1
    invoke-direct {p0, p1, p2, p3}, Lio/vov/vitamio/MediaPlayer;->_setDataSource(Ljava/lang/String;[Ljava/lang/String;[Ljava/lang/String;)V

    goto :goto_0
.end method

.method public native setDeinterlace(Z)V
.end method

.method public setDisplay(Landroid/view/SurfaceHolder;)V
    .locals 1
    .param p1, "sh"    # Landroid/view/SurfaceHolder;

    .prologue
    .line 376
    if-nez p1, :cond_0

    .line 377
    invoke-virtual {p0}, Lio/vov/vitamio/MediaPlayer;->releaseDisplay()V

    .line 384
    :goto_0
    return-void

    .line 379
    :cond_0
    iput-object p1, p0, Lio/vov/vitamio/MediaPlayer;->mSurfaceHolder:Landroid/view/SurfaceHolder;

    .line 380
    invoke-interface {p1}, Landroid/view/SurfaceHolder;->getSurface()Landroid/view/Surface;

    move-result-object v0

    iput-object v0, p0, Lio/vov/vitamio/MediaPlayer;->mSurface:Landroid/view/Surface;

    .line 381
    iget-object v0, p0, Lio/vov/vitamio/MediaPlayer;->mSurface:Landroid/view/Surface;

    invoke-direct {p0, v0}, Lio/vov/vitamio/MediaPlayer;->_setVideoSurface(Landroid/view/Surface;)V

    .line 382
    invoke-direct {p0}, Lio/vov/vitamio/MediaPlayer;->updateSurfaceScreenOn()V

    goto :goto_0
.end method

.method public native setLooping(Z)V
.end method

.method public native setMetaEncoding(Ljava/lang/String;)V
.end method

.method public setOnBufferingUpdateListener(Lio/vov/vitamio/MediaPlayer$OnBufferingUpdateListener;)V
    .locals 0
    .param p1, "listener"    # Lio/vov/vitamio/MediaPlayer$OnBufferingUpdateListener;

    .prologue
    .line 1075
    iput-object p1, p0, Lio/vov/vitamio/MediaPlayer;->mOnBufferingUpdateListener:Lio/vov/vitamio/MediaPlayer$OnBufferingUpdateListener;

    .line 1076
    return-void
.end method

.method public setOnCachingUpdateListener(Lio/vov/vitamio/MediaPlayer$OnCachingUpdateListener;)V
    .locals 0
    .param p1, "listener"    # Lio/vov/vitamio/MediaPlayer$OnCachingUpdateListener;

    .prologue
    .line 1085
    iput-object p1, p0, Lio/vov/vitamio/MediaPlayer;->mOnCachingUpdateListener:Lio/vov/vitamio/MediaPlayer$OnCachingUpdateListener;

    .line 1086
    return-void
.end method

.method public setOnCompletionListener(Lio/vov/vitamio/MediaPlayer$OnCompletionListener;)V
    .locals 0
    .param p1, "listener"    # Lio/vov/vitamio/MediaPlayer$OnCompletionListener;

    .prologue
    .line 1065
    iput-object p1, p0, Lio/vov/vitamio/MediaPlayer;->mOnCompletionListener:Lio/vov/vitamio/MediaPlayer$OnCompletionListener;

    .line 1066
    return-void
.end method

.method public setOnErrorListener(Lio/vov/vitamio/MediaPlayer$OnErrorListener;)V
    .locals 0
    .param p1, "listener"    # Lio/vov/vitamio/MediaPlayer$OnErrorListener;

    .prologue
    .line 1124
    iput-object p1, p0, Lio/vov/vitamio/MediaPlayer;->mOnErrorListener:Lio/vov/vitamio/MediaPlayer$OnErrorListener;

    .line 1125
    return-void
.end method

.method public setOnHWRenderFailedListener(Lio/vov/vitamio/MediaPlayer$OnHWRenderFailedListener;)V
    .locals 0
    .param p1, "l"    # Lio/vov/vitamio/MediaPlayer$OnHWRenderFailedListener;

    .prologue
    .line 519
    iput-object p1, p0, Lio/vov/vitamio/MediaPlayer;->mOnHWRenderFailedListener:Lio/vov/vitamio/MediaPlayer$OnHWRenderFailedListener;

    .line 520
    return-void
.end method

.method public setOnInfoListener(Lio/vov/vitamio/MediaPlayer$OnInfoListener;)V
    .locals 0
    .param p1, "listener"    # Lio/vov/vitamio/MediaPlayer$OnInfoListener;

    .prologue
    .line 1128
    iput-object p1, p0, Lio/vov/vitamio/MediaPlayer;->mOnInfoListener:Lio/vov/vitamio/MediaPlayer$OnInfoListener;

    .line 1129
    return-void
.end method

.method public setOnPreparedListener(Lio/vov/vitamio/MediaPlayer$OnPreparedListener;)V
    .locals 0
    .param p1, "listener"    # Lio/vov/vitamio/MediaPlayer$OnPreparedListener;

    .prologue
    .line 1055
    iput-object p1, p0, Lio/vov/vitamio/MediaPlayer;->mOnPreparedListener:Lio/vov/vitamio/MediaPlayer$OnPreparedListener;

    .line 1056
    return-void
.end method

.method public setOnSeekCompleteListener(Lio/vov/vitamio/MediaPlayer$OnSeekCompleteListener;)V
    .locals 0
    .param p1, "listener"    # Lio/vov/vitamio/MediaPlayer$OnSeekCompleteListener;

    .prologue
    .line 1105
    iput-object p1, p0, Lio/vov/vitamio/MediaPlayer;->mOnSeekCompleteListener:Lio/vov/vitamio/MediaPlayer$OnSeekCompleteListener;

    .line 1106
    return-void
.end method

.method public setOnTimedTextListener(Lio/vov/vitamio/MediaPlayer$OnTimedTextListener;)V
    .locals 0
    .param p1, "listener"    # Lio/vov/vitamio/MediaPlayer$OnTimedTextListener;

    .prologue
    .line 1137
    iput-object p1, p0, Lio/vov/vitamio/MediaPlayer;->mOnTimedTextListener:Lio/vov/vitamio/MediaPlayer$OnTimedTextListener;

    .line 1138
    return-void
.end method

.method public setOnVideoSizeChangedListener(Lio/vov/vitamio/MediaPlayer$OnVideoSizeChangedListener;)V
    .locals 0
    .param p1, "listener"    # Lio/vov/vitamio/MediaPlayer$OnVideoSizeChangedListener;

    .prologue
    .line 1114
    iput-object p1, p0, Lio/vov/vitamio/MediaPlayer;->mOnVideoSizeChangedListener:Lio/vov/vitamio/MediaPlayer$OnVideoSizeChangedListener;

    .line 1115
    return-void
.end method

.method public native setPlaybackSpeed(F)V
.end method

.method public setScreenOnWhilePlaying(Z)V
    .locals 1
    .param p1, "screenOn"    # Z

    .prologue
    .line 666
    iget-boolean v0, p0, Lio/vov/vitamio/MediaPlayer;->mScreenOnWhilePlaying:Z

    if-eq v0, p1, :cond_0

    .line 667
    iput-boolean p1, p0, Lio/vov/vitamio/MediaPlayer;->mScreenOnWhilePlaying:Z

    .line 668
    invoke-direct {p0}, Lio/vov/vitamio/MediaPlayer;->updateSurfaceScreenOn()V

    .line 670
    :cond_0
    return-void
.end method

.method public setSurface(Landroid/view/Surface;)V
    .locals 1
    .param p1, "surface"    # Landroid/view/Surface;

    .prologue
    .line 393
    if-nez p1, :cond_0

    .line 394
    invoke-virtual {p0}, Lio/vov/vitamio/MediaPlayer;->releaseDisplay()V

    .line 401
    :goto_0
    return-void

    .line 396
    :cond_0
    const/4 v0, 0x0

    iput-object v0, p0, Lio/vov/vitamio/MediaPlayer;->mSurfaceHolder:Landroid/view/SurfaceHolder;

    .line 397
    iput-object p1, p0, Lio/vov/vitamio/MediaPlayer;->mSurface:Landroid/view/Surface;

    .line 398
    iget-object v0, p0, Lio/vov/vitamio/MediaPlayer;->mSurface:Landroid/view/Surface;

    invoke-direct {p0, v0}, Lio/vov/vitamio/MediaPlayer;->_setVideoSurface(Landroid/view/Surface;)V

    .line 399
    invoke-direct {p0}, Lio/vov/vitamio/MediaPlayer;->updateSurfaceScreenOn()V

    goto :goto_0
.end method

.method public native setTimedTextEncoding(Ljava/lang/String;)V
.end method

.method public native setTimedTextShown(Z)V
.end method

.method public native setUseCache(Z)V
.end method

.method public native setVideoChroma(I)V
.end method

.method public native setVideoQuality(I)V
.end method

.method public native setVolume(FF)V
.end method

.method public setWakeMode(Landroid/content/Context;I)V
    .locals 4
    .param p1, "context"    # Landroid/content/Context;
    .param p2, "mode"    # I
    .annotation build Landroid/annotation/SuppressLint;
        value = {
            "Wakelock"
        }
    .end annotation

    .prologue
    .line 640
    const/4 v1, 0x0

    .line 641
    .local v1, "washeld":Z
    iget-object v2, p0, Lio/vov/vitamio/MediaPlayer;->mWakeLock:Landroid/os/PowerManager$WakeLock;

    if-eqz v2, :cond_1

    .line 642
    iget-object v2, p0, Lio/vov/vitamio/MediaPlayer;->mWakeLock:Landroid/os/PowerManager$WakeLock;

    invoke-virtual {v2}, Landroid/os/PowerManager$WakeLock;->isHeld()Z

    move-result v2

    if-eqz v2, :cond_0

    .line 643
    const/4 v1, 0x1

    .line 644
    iget-object v2, p0, Lio/vov/vitamio/MediaPlayer;->mWakeLock:Landroid/os/PowerManager$WakeLock;

    invoke-virtual {v2}, Landroid/os/PowerManager$WakeLock;->release()V

    .line 646
    :cond_0
    const/4 v2, 0x0

    iput-object v2, p0, Lio/vov/vitamio/MediaPlayer;->mWakeLock:Landroid/os/PowerManager$WakeLock;

    .line 649
    :cond_1
    const-string v2, "power"

    invoke-virtual {p1, v2}, Landroid/content/Context;->getSystemService(Ljava/lang/String;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Landroid/os/PowerManager;

    .line 650
    .local v0, "pm":Landroid/os/PowerManager;
    const/high16 v2, 0x20000000

    or-int/2addr v2, p2

    const-class v3, Lio/vov/vitamio/MediaPlayer;

    invoke-virtual {v3}, Ljava/lang/Class;->getName()Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v0, v2, v3}, Landroid/os/PowerManager;->newWakeLock(ILjava/lang/String;)Landroid/os/PowerManager$WakeLock;

    move-result-object v2

    iput-object v2, p0, Lio/vov/vitamio/MediaPlayer;->mWakeLock:Landroid/os/PowerManager$WakeLock;

    .line 651
    iget-object v2, p0, Lio/vov/vitamio/MediaPlayer;->mWakeLock:Landroid/os/PowerManager$WakeLock;

    const/4 v3, 0x0

    invoke-virtual {v2, v3}, Landroid/os/PowerManager$WakeLock;->setReferenceCounted(Z)V

    .line 652
    if-eqz v1, :cond_2

    .line 653
    iget-object v2, p0, Lio/vov/vitamio/MediaPlayer;->mWakeLock:Landroid/os/PowerManager$WakeLock;

    invoke-virtual {v2}, Landroid/os/PowerManager$WakeLock;->acquire()V

    .line 655
    :cond_2
    return-void
.end method

.method public start()V
    .locals 2
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/lang/IllegalStateException;
        }
    .end annotation

    .prologue
    const/4 v1, 0x1

    .line 581
    invoke-direct {p0, v1}, Lio/vov/vitamio/MediaPlayer;->stayAwake(Z)V

    .line 582
    iget-boolean v0, p0, Lio/vov/vitamio/MediaPlayer;->mInBuffering:Z

    if-eqz v0, :cond_0

    .line 584
    iput-boolean v1, p0, Lio/vov/vitamio/MediaPlayer;->mNeedResume:Z

    .line 589
    :goto_0
    return-void

    .line 587
    :cond_0
    invoke-direct {p0}, Lio/vov/vitamio/MediaPlayer;->_start()V

    goto :goto_0
.end method

.method public stop()V
    .locals 1
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/lang/IllegalStateException;
        }
    .end annotation

    .prologue
    const/4 v0, 0x0

    .line 599
    invoke-direct {p0, v0}, Lio/vov/vitamio/MediaPlayer;->stayAwake(Z)V

    .line 600
    invoke-direct {p0}, Lio/vov/vitamio/MediaPlayer;->_stop()V

    .line 601
    iput-boolean v0, p0, Lio/vov/vitamio/MediaPlayer;->mInBuffering:Z

    .line 602
    iput-boolean v0, p0, Lio/vov/vitamio/MediaPlayer;->mNeedResume:Z

    .line 603
    return-void
.end method

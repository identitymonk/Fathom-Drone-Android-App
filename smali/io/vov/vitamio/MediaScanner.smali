.class public Lio/vov/vitamio/MediaScanner;
.super Ljava/lang/Object;
.source "MediaScanner.java"


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lio/vov/vitamio/MediaScanner$MyMediaScannerClient;,
        Lio/vov/vitamio/MediaScanner$FileCacheEntry;
    }
.end annotation


# static fields
.field private static final DATE_MODIFIED_VIDEO_COLUMN_INDEX:I = 0x2

.field private static final ID_VIDEO_COLUMN_INDEX:I = 0x0

.field private static final PATH_VIDEO_COLUMN_INDEX:I = 0x1

.field private static final VIDEO_PROJECTION:[Ljava/lang/String;


# instance fields
.field private mCaseInsensitivePaths:Z

.field private mClient:Lio/vov/vitamio/MediaScanner$MyMediaScannerClient;

.field private mContext:Landroid/content/Context;

.field private mFileCache:Ljava/util/HashMap;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/HashMap",
            "<",
            "Ljava/lang/String;",
            "Lio/vov/vitamio/MediaScanner$FileCacheEntry;",
            ">;"
        }
    .end annotation
.end field

.field private mProvider:Landroid/content/ContentProviderClient;


# direct methods
.method static constructor <clinit>()V
    .locals 6

    .prologue
    const/4 v5, 0x1

    const/4 v4, 0x0

    .line 41
    const/4 v1, 0x3

    new-array v1, v1, [Ljava/lang/String;

    const-string v2, "_id"

    aput-object v2, v1, v4

    const-string v2, "_data"

    aput-object v2, v1, v5

    const/4 v2, 0x2

    const-string v3, "date_modified"

    aput-object v3, v1, v2

    sput-object v1, Lio/vov/vitamio/MediaScanner;->VIDEO_PROJECTION:[Ljava/lang/String;

    .line 184
    invoke-static {}, Lio/vov/vitamio/Vitamio;->getLibraryPath()Ljava/lang/String;

    move-result-object v0

    .line 185
    .local v0, "LIB_ROOT":Ljava/lang/String;
    const-string v1, "LIB ROOT: %s"

    new-array v2, v5, [Ljava/lang/Object;

    aput-object v0, v2, v4

    invoke-static {v1, v2}, Lio/vov/vitamio/utils/Log;->i(Ljava/lang/String;[Ljava/lang/Object;)V

    .line 186
    new-instance v1, Ljava/lang/StringBuilder;

    invoke-direct {v1}, Ljava/lang/StringBuilder;-><init>()V

    invoke-virtual {v1, v0}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    const-string v2, "libstlport_shared.so"

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    invoke-static {v1}, Ljava/lang/System;->load(Ljava/lang/String;)V

    .line 187
    new-instance v1, Ljava/lang/StringBuilder;

    invoke-direct {v1}, Ljava/lang/StringBuilder;-><init>()V

    invoke-virtual {v1, v0}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    const-string v2, "libvscanner.so"

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    invoke-static {v1}, Ljava/lang/System;->load(Ljava/lang/String;)V

    .line 188
    new-instance v1, Ljava/lang/StringBuilder;

    invoke-direct {v1}, Ljava/lang/StringBuilder;-><init>()V

    invoke-virtual {v1, v0}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    const-string v2, "libffmpeg.so"

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    invoke-static {v1}, Lio/vov/vitamio/MediaScanner;->loadFFmpeg_native(Ljava/lang/String;)Z

    .line 189
    return-void
.end method

.method public constructor <init>(Landroid/content/Context;)V
    .locals 2
    .param p1, "ctx"    # Landroid/content/Context;

    .prologue
    .line 51
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 49
    new-instance v0, Lio/vov/vitamio/MediaScanner$MyMediaScannerClient;

    const/4 v1, 0x0

    invoke-direct {v0, p0, v1}, Lio/vov/vitamio/MediaScanner$MyMediaScannerClient;-><init>(Lio/vov/vitamio/MediaScanner;Lio/vov/vitamio/MediaScanner$1;)V

    iput-object v0, p0, Lio/vov/vitamio/MediaScanner;->mClient:Lio/vov/vitamio/MediaScanner$MyMediaScannerClient;

    .line 52
    iput-object p1, p0, Lio/vov/vitamio/MediaScanner;->mContext:Landroid/content/Context;

    .line 53
    iget-object v0, p0, Lio/vov/vitamio/MediaScanner;->mClient:Lio/vov/vitamio/MediaScanner$MyMediaScannerClient;

    invoke-direct {p0, v0}, Lio/vov/vitamio/MediaScanner;->native_init(Lio/vov/vitamio/MediaScannerClient;)V

    .line 54
    return-void
.end method

.method static synthetic access$100(Lio/vov/vitamio/MediaScanner;)Z
    .locals 1
    .param p0, "x0"    # Lio/vov/vitamio/MediaScanner;

    .prologue
    .line 40
    iget-boolean v0, p0, Lio/vov/vitamio/MediaScanner;->mCaseInsensitivePaths:Z

    return v0
.end method

.method static synthetic access$200(Lio/vov/vitamio/MediaScanner;)Ljava/util/HashMap;
    .locals 1
    .param p0, "x0"    # Lio/vov/vitamio/MediaScanner;

    .prologue
    .line 40
    iget-object v0, p0, Lio/vov/vitamio/MediaScanner;->mFileCache:Ljava/util/HashMap;

    return-object v0
.end method

.method static synthetic access$300(Lio/vov/vitamio/MediaScanner;Ljava/lang/String;Ljava/lang/String;)Z
    .locals 1
    .param p0, "x0"    # Lio/vov/vitamio/MediaScanner;
    .param p1, "x1"    # Ljava/lang/String;
    .param p2, "x2"    # Ljava/lang/String;

    .prologue
    .line 40
    invoke-direct {p0, p1, p2}, Lio/vov/vitamio/MediaScanner;->processFile(Ljava/lang/String;Ljava/lang/String;)Z

    move-result v0

    return v0
.end method

.method static synthetic access$400(Lio/vov/vitamio/MediaScanner;)Landroid/content/ContentProviderClient;
    .locals 1
    .param p0, "x0"    # Lio/vov/vitamio/MediaScanner;

    .prologue
    .line 40
    iget-object v0, p0, Lio/vov/vitamio/MediaScanner;->mProvider:Landroid/content/ContentProviderClient;

    return-object v0
.end method

.method private inScanDirectory(Ljava/lang/String;[Ljava/lang/String;)Z
    .locals 2
    .param p1, "path"    # Ljava/lang/String;
    .param p2, "directories"    # [Ljava/lang/String;

    .prologue
    .line 133
    const/4 v0, 0x0

    .local v0, "i":I
    :goto_0
    array-length v1, p2

    if-ge v0, v1, :cond_1

    .line 134
    aget-object v1, p2, v0

    invoke-virtual {p1, v1}, Ljava/lang/String;->startsWith(Ljava/lang/String;)Z

    move-result v1

    if-eqz v1, :cond_0

    .line 135
    const/4 v1, 0x1

    .line 137
    :goto_1
    return v1

    .line 133
    :cond_0
    add-int/lit8 v0, v0, 0x1

    goto :goto_0

    .line 137
    :cond_1
    const/4 v1, 0x0

    goto :goto_1
.end method

.method private initialize()V
    .locals 1

    .prologue
    .line 59
    const/4 v0, 0x1

    iput-boolean v0, p0, Lio/vov/vitamio/MediaScanner;->mCaseInsensitivePaths:Z

    .line 60
    return-void
.end method

.method private static native loadFFmpeg_native(Ljava/lang/String;)Z
.end method

.method private final native native_finalize()V
.end method

.method private final native native_init(Lio/vov/vitamio/MediaScannerClient;)V
.end method

.method private postscan([Ljava/lang/String;)V
    .locals 8
    .param p1, "directories"    # [Ljava/lang/String;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Landroid/os/RemoteException;
        }
    .end annotation

    .prologue
    const/4 v5, 0x0

    .line 112
    iget-object v3, p0, Lio/vov/vitamio/MediaScanner;->mFileCache:Ljava/util/HashMap;

    invoke-virtual {v3}, Ljava/util/HashMap;->values()Ljava/util/Collection;

    move-result-object v3

    invoke-interface {v3}, Ljava/util/Collection;->iterator()Ljava/util/Iterator;

    move-result-object v1

    .line 114
    .local v1, "iterator":Ljava/util/Iterator;, "Ljava/util/Iterator<Lio/vov/vitamio/MediaScanner$FileCacheEntry;>;"
    :cond_0
    :goto_0
    invoke-interface {v1}, Ljava/util/Iterator;->hasNext()Z

    move-result v3

    if-eqz v3, :cond_1

    .line 115
    invoke-interface {v1}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lio/vov/vitamio/MediaScanner$FileCacheEntry;

    .line 116
    .local v0, "entry":Lio/vov/vitamio/MediaScanner$FileCacheEntry;
    iget-object v2, v0, Lio/vov/vitamio/MediaScanner$FileCacheEntry;->mPath:Ljava/lang/String;

    .line 118
    .local v2, "path":Ljava/lang/String;
    iget-boolean v3, v0, Lio/vov/vitamio/MediaScanner$FileCacheEntry;->mSeenInFileSystem:Z

    if-nez v3, :cond_0

    .line 119
    invoke-direct {p0, v2, p1}, Lio/vov/vitamio/MediaScanner;->inScanDirectory(Ljava/lang/String;[Ljava/lang/String;)Z

    move-result v3

    if-eqz v3, :cond_0

    new-instance v3, Ljava/io/File;

    invoke-direct {v3, v2}, Ljava/io/File;-><init>(Ljava/lang/String;)V

    invoke-virtual {v3}, Ljava/io/File;->exists()Z

    move-result v3

    if-nez v3, :cond_0

    .line 120
    iget-object v3, p0, Lio/vov/vitamio/MediaScanner;->mProvider:Landroid/content/ContentProviderClient;

    iget-object v4, v0, Lio/vov/vitamio/MediaScanner$FileCacheEntry;->mTableUri:Landroid/net/Uri;

    iget-wide v6, v0, Lio/vov/vitamio/MediaScanner$FileCacheEntry;->mRowId:J

    invoke-static {v4, v6, v7}, Landroid/content/ContentUris;->withAppendedId(Landroid/net/Uri;J)Landroid/net/Uri;

    move-result-object v4

    invoke-virtual {v3, v4, v5, v5}, Landroid/content/ContentProviderClient;->delete(Landroid/net/Uri;Ljava/lang/String;[Ljava/lang/String;)I

    .line 121
    invoke-interface {v1}, Ljava/util/Iterator;->remove()V

    goto :goto_0

    .line 126
    .end local v0    # "entry":Lio/vov/vitamio/MediaScanner$FileCacheEntry;
    .end local v2    # "path":Ljava/lang/String;
    :cond_1
    iget-object v3, p0, Lio/vov/vitamio/MediaScanner;->mFileCache:Ljava/util/HashMap;

    invoke-virtual {v3}, Ljava/util/HashMap;->clear()V

    .line 127
    iput-object v5, p0, Lio/vov/vitamio/MediaScanner;->mFileCache:Ljava/util/HashMap;

    .line 128
    iget-object v3, p0, Lio/vov/vitamio/MediaScanner;->mProvider:Landroid/content/ContentProviderClient;

    invoke-virtual {v3}, Landroid/content/ContentProviderClient;->release()Z

    .line 129
    iput-object v5, p0, Lio/vov/vitamio/MediaScanner;->mProvider:Landroid/content/ContentProviderClient;

    .line 130
    return-void
.end method

.method private prescan(Ljava/lang/String;)V
    .locals 18
    .param p1, "filePath"    # Ljava/lang/String;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Landroid/os/RemoteException;
        }
    .end annotation

    .prologue
    .line 63
    move-object/from16 v0, p0

    iget-object v1, v0, Lio/vov/vitamio/MediaScanner;->mContext:Landroid/content/Context;

    invoke-virtual {v1}, Landroid/content/Context;->getContentResolver()Landroid/content/ContentResolver;

    move-result-object v1

    const-string v2, "me.abitno.vplayer.mediaprovider"

    invoke-virtual {v1, v2}, Landroid/content/ContentResolver;->acquireContentProviderClient(Ljava/lang/String;)Landroid/content/ContentProviderClient;

    move-result-object v1

    move-object/from16 v0, p0

    iput-object v1, v0, Lio/vov/vitamio/MediaScanner;->mProvider:Landroid/content/ContentProviderClient;

    .line 64
    const/4 v14, 0x0

    .line 65
    .local v14, "c":Landroid/database/Cursor;
    const/4 v4, 0x0

    .line 66
    .local v4, "where":Ljava/lang/String;
    const/4 v5, 0x0

    .line 68
    .local v5, "selectionArgs":[Ljava/lang/String;
    move-object/from16 v0, p0

    iget-object v1, v0, Lio/vov/vitamio/MediaScanner;->mFileCache:Ljava/util/HashMap;

    if-nez v1, :cond_3

    .line 69
    new-instance v1, Ljava/util/HashMap;

    invoke-direct {v1}, Ljava/util/HashMap;-><init>()V

    move-object/from16 v0, p0

    iput-object v1, v0, Lio/vov/vitamio/MediaScanner;->mFileCache:Ljava/util/HashMap;

    .line 74
    :goto_0
    if-eqz p1, :cond_0

    .line 75
    :try_start_0
    const-string v4, "_data=?"

    .line 76
    const/4 v1, 0x1

    new-array v0, v1, [Ljava/lang/String;

    move-object/from16 v16, v0

    const/4 v1, 0x0

    aput-object p1, v16, v1

    .end local v5    # "selectionArgs":[Ljava/lang/String;
    .local v16, "selectionArgs":[Ljava/lang/String;
    move-object/from16 v5, v16

    .line 79
    .end local v16    # "selectionArgs":[Ljava/lang/String;
    .restart local v5    # "selectionArgs":[Ljava/lang/String;
    :cond_0
    move-object/from16 v0, p0

    iget-object v1, v0, Lio/vov/vitamio/MediaScanner;->mProvider:Landroid/content/ContentProviderClient;

    sget-object v2, Lio/vov/vitamio/provider/MediaStore$Video$Media;->CONTENT_URI:Landroid/net/Uri;

    sget-object v3, Lio/vov/vitamio/MediaScanner;->VIDEO_PROJECTION:[Ljava/lang/String;

    const/4 v6, 0x0

    invoke-virtual/range {v1 .. v6}, Landroid/content/ContentProviderClient;->query(Landroid/net/Uri;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_1

    move-result-object v14

    .line 80
    if-eqz v14, :cond_8

    .line 82
    :cond_1
    :goto_1
    :try_start_1
    invoke-interface {v14}, Landroid/database/Cursor;->moveToNext()Z

    move-result v1

    if-eqz v1, :cond_7

    .line 83
    const/4 v1, 0x0

    invoke-interface {v14, v1}, Landroid/database/Cursor;->getLong(I)J

    move-result-wide v9

    .line 84
    .local v9, "rowId":J
    const/4 v1, 0x1

    invoke-interface {v14, v1}, Landroid/database/Cursor;->getString(I)Ljava/lang/String;

    move-result-object v11

    .line 85
    .local v11, "path":Ljava/lang/String;
    const/4 v1, 0x2

    invoke-interface {v14, v1}, Landroid/database/Cursor;->getLong(I)J

    move-result-wide v12

    .line 86
    .local v12, "lastModified":J
    const-string v1, "/"

    invoke-virtual {v11, v1}, Ljava/lang/String;->startsWith(Ljava/lang/String;)Z

    move-result v1

    if-eqz v1, :cond_1

    .line 87
    new-instance v17, Ljava/io/File;

    move-object/from16 v0, v17

    invoke-direct {v0, v11}, Ljava/io/File;-><init>(Ljava/lang/String;)V

    .line 88
    .local v17, "tempFile":Ljava/io/File;
    invoke-static/range {p1 .. p1}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result v1

    if-nez v1, :cond_4

    invoke-virtual/range {v17 .. v17}, Ljava/io/File;->exists()Z

    move-result v1

    if-nez v1, :cond_4

    .line 89
    move-object/from16 v0, p0

    iget-object v1, v0, Lio/vov/vitamio/MediaScanner;->mProvider:Landroid/content/ContentProviderClient;

    sget-object v2, Lio/vov/vitamio/provider/MediaStore$Video$Media;->CONTENT_URI:Landroid/net/Uri;

    invoke-virtual {v1, v2, v4, v5}, Landroid/content/ContentProviderClient;->delete(Landroid/net/Uri;Ljava/lang/String;[Ljava/lang/String;)I
    :try_end_1
    .catchall {:try_start_1 .. :try_end_1} :catchall_0

    .line 98
    :try_start_2
    invoke-interface {v14}, Landroid/database/Cursor;->close()V
    :try_end_2
    .catchall {:try_start_2 .. :try_end_2} :catchall_1

    .line 99
    const/4 v14, 0x0

    .line 103
    if-eqz v14, :cond_2

    .line 104
    invoke-interface {v14}, Landroid/database/Cursor;->close()V

    .line 107
    .end local v9    # "rowId":J
    .end local v11    # "path":Ljava/lang/String;
    .end local v12    # "lastModified":J
    .end local v17    # "tempFile":Ljava/io/File;
    :cond_2
    :goto_2
    return-void

    .line 71
    :cond_3
    move-object/from16 v0, p0

    iget-object v1, v0, Lio/vov/vitamio/MediaScanner;->mFileCache:Ljava/util/HashMap;

    invoke-virtual {v1}, Ljava/util/HashMap;->clear()V

    goto :goto_0

    .line 92
    .restart local v9    # "rowId":J
    .restart local v11    # "path":Ljava/lang/String;
    .restart local v12    # "lastModified":J
    .restart local v17    # "tempFile":Ljava/io/File;
    :cond_4
    :try_start_3
    invoke-static/range {v17 .. v17}, Lio/vov/vitamio/utils/FileUtils;->getCanonical(Ljava/io/File;)Ljava/lang/String;

    move-result-object v11

    .line 93
    move-object/from16 v0, p0

    iget-boolean v1, v0, Lio/vov/vitamio/MediaScanner;->mCaseInsensitivePaths:Z

    if-eqz v1, :cond_6

    invoke-virtual {v11}, Ljava/lang/String;->toLowerCase()Ljava/lang/String;

    move-result-object v15

    .line 94
    .local v15, "key":Ljava/lang/String;
    :goto_3
    move-object/from16 v0, p0

    iget-object v1, v0, Lio/vov/vitamio/MediaScanner;->mFileCache:Ljava/util/HashMap;

    new-instance v7, Lio/vov/vitamio/MediaScanner$FileCacheEntry;

    sget-object v8, Lio/vov/vitamio/provider/MediaStore$Video$Media;->CONTENT_URI:Landroid/net/Uri;

    invoke-direct/range {v7 .. v13}, Lio/vov/vitamio/MediaScanner$FileCacheEntry;-><init>(Landroid/net/Uri;JLjava/lang/String;J)V

    invoke-virtual {v1, v15, v7}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    :try_end_3
    .catchall {:try_start_3 .. :try_end_3} :catchall_0

    goto :goto_1

    .line 98
    .end local v9    # "rowId":J
    .end local v11    # "path":Ljava/lang/String;
    .end local v12    # "lastModified":J
    .end local v15    # "key":Ljava/lang/String;
    .end local v17    # "tempFile":Ljava/io/File;
    :catchall_0
    move-exception v1

    :try_start_4
    invoke-interface {v14}, Landroid/database/Cursor;->close()V

    .line 99
    const/4 v14, 0x0

    throw v1
    :try_end_4
    .catchall {:try_start_4 .. :try_end_4} :catchall_1

    .line 103
    :catchall_1
    move-exception v1

    if-eqz v14, :cond_5

    .line 104
    invoke-interface {v14}, Landroid/database/Cursor;->close()V

    :cond_5
    throw v1

    .restart local v9    # "rowId":J
    .restart local v11    # "path":Ljava/lang/String;
    .restart local v12    # "lastModified":J
    .restart local v17    # "tempFile":Ljava/io/File;
    :cond_6
    move-object v15, v11

    .line 93
    goto :goto_3

    .line 98
    .end local v9    # "rowId":J
    .end local v11    # "path":Ljava/lang/String;
    .end local v12    # "lastModified":J
    .end local v17    # "tempFile":Ljava/io/File;
    :cond_7
    :try_start_5
    invoke-interface {v14}, Landroid/database/Cursor;->close()V
    :try_end_5
    .catchall {:try_start_5 .. :try_end_5} :catchall_1

    .line 99
    const/4 v14, 0x0

    .line 103
    :cond_8
    if-eqz v14, :cond_2

    .line 104
    invoke-interface {v14}, Landroid/database/Cursor;->close()V

    goto :goto_2
.end method

.method private native processDirectory(Ljava/lang/String;Ljava/lang/String;)V
.end method

.method private native processFile(Ljava/lang/String;Ljava/lang/String;)Z
.end method


# virtual methods
.method protected finalize()V
    .locals 1
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/lang/Throwable;
        }
    .end annotation

    .prologue
    .line 204
    :try_start_0
    invoke-direct {p0}, Lio/vov/vitamio/MediaScanner;->native_finalize()V
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    .line 206
    invoke-super {p0}, Ljava/lang/Object;->finalize()V

    .line 208
    return-void

    .line 206
    :catchall_0
    move-exception v0

    invoke-super {p0}, Ljava/lang/Object;->finalize()V

    throw v0
.end method

.method public native release()V
.end method

.method public scanDirectories([Ljava/lang/String;)V
    .locals 18
    .param p1, "directories"    # [Ljava/lang/String;

    .prologue
    .line 142
    :try_start_0
    invoke-static {}, Ljava/lang/System;->currentTimeMillis()J

    move-result-wide v10

    .line 143
    .local v10, "start":J
    const/4 v12, 0x0

    move-object/from16 v0, p0

    invoke-direct {v0, v12}, Lio/vov/vitamio/MediaScanner;->prescan(Ljava/lang/String;)V

    .line 144
    invoke-static {}, Ljava/lang/System;->currentTimeMillis()J

    move-result-wide v6

    .line 146
    .local v6, "prescan":J
    const/4 v3, 0x0

    .local v3, "i":I
    :goto_0
    move-object/from16 v0, p1

    array-length v12, v0

    if-ge v3, v12, :cond_1

    .line 147
    aget-object v12, p1, v3

    invoke-static {v12}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result v12

    if-nez v12, :cond_0

    .line 148
    aget-object v12, p1, v3

    invoke-static {v12}, Lio/vov/vitamio/utils/ContextUtils;->fixLastSlash(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v12

    aput-object v12, p1, v3

    .line 149
    aget-object v12, p1, v3

    sget-object v13, Lio/vov/vitamio/MediaFile;->sFileExtensions:Ljava/lang/String;

    move-object/from16 v0, p0

    invoke-direct {v0, v12, v13}, Lio/vov/vitamio/MediaScanner;->processDirectory(Ljava/lang/String;Ljava/lang/String;)V

    .line 146
    :cond_0
    add-int/lit8 v3, v3, 0x1

    goto :goto_0

    .line 153
    :cond_1
    invoke-static {}, Ljava/lang/System;->currentTimeMillis()J

    move-result-wide v8

    .line 154
    .local v8, "scan":J
    invoke-direct/range {p0 .. p1}, Lio/vov/vitamio/MediaScanner;->postscan([Ljava/lang/String;)V

    .line 155
    invoke-static {}, Ljava/lang/System;->currentTimeMillis()J

    move-result-wide v4

    .line 157
    .local v4, "end":J
    const-string v12, " prescan time: %dms"

    const/4 v13, 0x1

    new-array v13, v13, [Ljava/lang/Object;

    const/4 v14, 0x0

    sub-long v16, v6, v10

    invoke-static/range {v16 .. v17}, Ljava/lang/Long;->valueOf(J)Ljava/lang/Long;

    move-result-object v15

    aput-object v15, v13, v14

    invoke-static {v12, v13}, Lio/vov/vitamio/utils/Log;->d(Ljava/lang/String;[Ljava/lang/Object;)V

    .line 158
    const-string v12, "    scan time: %dms"

    const/4 v13, 0x1

    new-array v13, v13, [Ljava/lang/Object;

    const/4 v14, 0x0

    sub-long v16, v8, v6

    invoke-static/range {v16 .. v17}, Ljava/lang/Long;->valueOf(J)Ljava/lang/Long;

    move-result-object v15

    aput-object v15, v13, v14

    invoke-static {v12, v13}, Lio/vov/vitamio/utils/Log;->d(Ljava/lang/String;[Ljava/lang/Object;)V

    .line 159
    const-string v12, "postscan time: %dms"

    const/4 v13, 0x1

    new-array v13, v13, [Ljava/lang/Object;

    const/4 v14, 0x0

    sub-long v16, v4, v8

    invoke-static/range {v16 .. v17}, Ljava/lang/Long;->valueOf(J)Ljava/lang/Long;

    move-result-object v15

    aput-object v15, v13, v14

    invoke-static {v12, v13}, Lio/vov/vitamio/utils/Log;->d(Ljava/lang/String;[Ljava/lang/Object;)V

    .line 160
    const-string v12, "   total time: %dms"

    const/4 v13, 0x1

    new-array v13, v13, [Ljava/lang/Object;

    const/4 v14, 0x0

    sub-long v16, v4, v10

    invoke-static/range {v16 .. v17}, Ljava/lang/Long;->valueOf(J)Ljava/lang/Long;

    move-result-object v15

    aput-object v15, v13, v14

    invoke-static {v12, v13}, Lio/vov/vitamio/utils/Log;->d(Ljava/lang/String;[Ljava/lang/Object;)V
    :try_end_0
    .catch Landroid/database/SQLException; {:try_start_0 .. :try_end_0} :catch_0
    .catch Ljava/lang/UnsupportedOperationException; {:try_start_0 .. :try_end_0} :catch_1
    .catch Landroid/os/RemoteException; {:try_start_0 .. :try_end_0} :catch_2

    .line 168
    .end local v3    # "i":I
    .end local v4    # "end":J
    .end local v6    # "prescan":J
    .end local v8    # "scan":J
    .end local v10    # "start":J
    :goto_1
    return-void

    .line 161
    :catch_0
    move-exception v2

    .line 162
    .local v2, "e":Landroid/database/SQLException;
    const-string v12, "SQLException in MediaScanner.scan()"

    invoke-static {v12, v2}, Lio/vov/vitamio/utils/Log;->e(Ljava/lang/String;Ljava/lang/Throwable;)V

    goto :goto_1

    .line 163
    .end local v2    # "e":Landroid/database/SQLException;
    :catch_1
    move-exception v2

    .line 164
    .local v2, "e":Ljava/lang/UnsupportedOperationException;
    const-string v12, "UnsupportedOperationException in MediaScanner.scan()"

    invoke-static {v12, v2}, Lio/vov/vitamio/utils/Log;->e(Ljava/lang/String;Ljava/lang/Throwable;)V

    goto :goto_1

    .line 165
    .end local v2    # "e":Ljava/lang/UnsupportedOperationException;
    :catch_2
    move-exception v2

    .line 166
    .local v2, "e":Landroid/os/RemoteException;
    const-string v12, "RemoteException in MediaScanner.scan()"

    invoke-static {v12, v2}, Lio/vov/vitamio/utils/Log;->e(Ljava/lang/String;Ljava/lang/Throwable;)V

    goto :goto_1
.end method

.method public scanSingleFile(Ljava/lang/String;Ljava/lang/String;)Landroid/net/Uri;
    .locals 9
    .param p1, "path"    # Ljava/lang/String;
    .param p2, "mimeType"    # Ljava/lang/String;

    .prologue
    .line 172
    :try_start_0
    invoke-direct {p0, p1}, Lio/vov/vitamio/MediaScanner;->prescan(Ljava/lang/String;)V

    .line 173
    new-instance v8, Ljava/io/File;

    invoke-direct {v8, p1}, Ljava/io/File;-><init>(Ljava/lang/String;)V

    .line 174
    .local v8, "file":Ljava/io/File;
    invoke-virtual {v8}, Ljava/io/File;->lastModified()J

    move-result-wide v0

    const-wide/16 v4, 0x3e8

    div-long v2, v0, v4

    .line 176
    .local v2, "lastModifiedSeconds":J
    iget-object v0, p0, Lio/vov/vitamio/MediaScanner;->mClient:Lio/vov/vitamio/MediaScanner$MyMediaScannerClient;

    invoke-virtual {v8}, Ljava/io/File;->length()J

    move-result-wide v4

    const/4 v6, 0x1

    move-object v1, p1

    invoke-virtual/range {v0 .. v6}, Lio/vov/vitamio/MediaScanner$MyMediaScannerClient;->doScanFile(Ljava/lang/String;JJZ)Landroid/net/Uri;
    :try_end_0
    .catch Landroid/os/RemoteException; {:try_start_0 .. :try_end_0} :catch_0

    move-result-object v0

    .line 179
    .end local v2    # "lastModifiedSeconds":J
    .end local v8    # "file":Ljava/io/File;
    :goto_0
    return-object v0

    .line 177
    :catch_0
    move-exception v7

    .line 178
    .local v7, "e":Landroid/os/RemoteException;
    const-string v0, "RemoteException in MediaScanner.scanFile()"

    invoke-static {v0, v7}, Lio/vov/vitamio/utils/Log;->e(Ljava/lang/String;Ljava/lang/Throwable;)V

    .line 179
    const/4 v0, 0x0

    goto :goto_0
.end method

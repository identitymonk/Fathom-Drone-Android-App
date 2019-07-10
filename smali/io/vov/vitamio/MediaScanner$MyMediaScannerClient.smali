.class Lio/vov/vitamio/MediaScanner$MyMediaScannerClient;
.super Ljava/lang/Object;
.source "MediaScanner.java"

# interfaces
.implements Lio/vov/vitamio/MediaScannerClient;


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lio/vov/vitamio/MediaScanner;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x2
    name = "MyMediaScannerClient"
.end annotation


# instance fields
.field private mAlbum:Ljava/lang/String;

.field private mArtist:Ljava/lang/String;

.field private mDuration:J

.field private mFileSize:J

.field private mFileType:I

.field private mHeight:I

.field private mLanguage:Ljava/lang/String;

.field private mLastModified:J

.field private mMimeType:Ljava/lang/String;

.field private mPath:Ljava/lang/String;

.field private mTitle:Ljava/lang/String;

.field private mWidth:I

.field final synthetic this$0:Lio/vov/vitamio/MediaScanner;


# direct methods
.method private constructor <init>(Lio/vov/vitamio/MediaScanner;)V
    .locals 0

    .prologue
    .line 233
    iput-object p1, p0, Lio/vov/vitamio/MediaScanner$MyMediaScannerClient;->this$0:Lio/vov/vitamio/MediaScanner;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method

.method synthetic constructor <init>(Lio/vov/vitamio/MediaScanner;Lio/vov/vitamio/MediaScanner$1;)V
    .locals 0
    .param p1, "x0"    # Lio/vov/vitamio/MediaScanner;
    .param p2, "x1"    # Lio/vov/vitamio/MediaScanner$1;

    .prologue
    .line 233
    invoke-direct {p0, p1}, Lio/vov/vitamio/MediaScanner$MyMediaScannerClient;-><init>(Lio/vov/vitamio/MediaScanner;)V

    return-void
.end method

.method private endFile(Lio/vov/vitamio/MediaScanner$FileCacheEntry;)Landroid/net/Uri;
    .locals 12
    .param p1, "entry"    # Lio/vov/vitamio/MediaScanner$FileCacheEntry;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Landroid/os/RemoteException;
        }
    .end annotation

    .prologue
    const/4 v10, 0x0

    const/4 v9, 0x0

    .line 399
    iget v11, p0, Lio/vov/vitamio/MediaScanner$MyMediaScannerClient;->mFileType:I

    invoke-static {v11}, Lio/vov/vitamio/MediaFile;->isVideoFileType(I)Z

    move-result v11

    if-eqz v11, :cond_4

    iget v11, p0, Lio/vov/vitamio/MediaScanner$MyMediaScannerClient;->mWidth:I

    if-lez v11, :cond_4

    iget v11, p0, Lio/vov/vitamio/MediaScanner$MyMediaScannerClient;->mHeight:I

    if-lez v11, :cond_4

    const/4 v0, 0x1

    .line 400
    .local v0, "isVideo":Z
    :goto_0
    if-eqz v0, :cond_5

    .line 401
    sget-object v6, Lio/vov/vitamio/provider/MediaStore$Video$Media;->CONTENT_URI:Landroid/net/Uri;

    .line 405
    .local v6, "tableUri":Landroid/net/Uri;
    iput-object v6, p1, Lio/vov/vitamio/MediaScanner$FileCacheEntry;->mTableUri:Landroid/net/Uri;

    .line 407
    invoke-direct {p0}, Lio/vov/vitamio/MediaScanner$MyMediaScannerClient;->toValues()Landroid/content/ContentValues;

    move-result-object v8

    .line 408
    .local v8, "values":Landroid/content/ContentValues;
    const-string v11, "title"

    invoke-virtual {v8, v11}, Landroid/content/ContentValues;->getAsString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v7

    .line 409
    .local v7, "title":Ljava/lang/String;
    invoke-static {v7}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result v11

    if-eqz v11, :cond_2

    .line 410
    const-string v11, "_data"

    invoke-virtual {v8, v11}, Landroid/content/ContentValues;->getAsString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v7

    .line 411
    const/16 v11, 0x2f

    invoke-virtual {v7, v11}, Ljava/lang/String;->lastIndexOf(I)I

    move-result v2

    .line 412
    .local v2, "lastSlash":I
    if-ltz v2, :cond_0

    .line 413
    add-int/lit8 v2, v2, 0x1

    .line 414
    invoke-virtual {v7}, Ljava/lang/String;->length()I

    move-result v11

    if-ge v2, v11, :cond_0

    .line 415
    invoke-virtual {v7, v2}, Ljava/lang/String;->substring(I)Ljava/lang/String;

    move-result-object v7

    .line 417
    :cond_0
    const/16 v11, 0x2e

    invoke-virtual {v7, v11}, Ljava/lang/String;->lastIndexOf(I)I

    move-result v1

    .line 418
    .local v1, "lastDot":I
    if-lez v1, :cond_1

    .line 419
    invoke-virtual {v7, v10, v1}, Ljava/lang/String;->substring(II)Ljava/lang/String;

    move-result-object v7

    .line 420
    :cond_1
    const-string v10, "title"

    invoke-virtual {v8, v10, v7}, Landroid/content/ContentValues;->put(Ljava/lang/String;Ljava/lang/String;)V

    .line 423
    .end local v1    # "lastDot":I
    .end local v2    # "lastSlash":I
    :cond_2
    iget-wide v4, p1, Lio/vov/vitamio/MediaScanner$FileCacheEntry;->mRowId:J

    .line 425
    .local v4, "rowId":J
    const/4 v3, 0x0

    .line 426
    .local v3, "result":Landroid/net/Uri;
    const-wide/16 v10, 0x0

    cmp-long v10, v4, v10

    if-nez v10, :cond_6

    .line 427
    iget-object v9, p0, Lio/vov/vitamio/MediaScanner$MyMediaScannerClient;->this$0:Lio/vov/vitamio/MediaScanner;

    invoke-static {v9}, Lio/vov/vitamio/MediaScanner;->access$400(Lio/vov/vitamio/MediaScanner;)Landroid/content/ContentProviderClient;

    move-result-object v9

    invoke-virtual {v9, v6, v8}, Landroid/content/ContentProviderClient;->insert(Landroid/net/Uri;Landroid/content/ContentValues;)Landroid/net/Uri;

    move-result-object v3

    .line 428
    if-eqz v3, :cond_3

    .line 429
    invoke-static {v3}, Landroid/content/ContentUris;->parseId(Landroid/net/Uri;)J

    move-result-wide v4

    .line 430
    iput-wide v4, p1, Lio/vov/vitamio/MediaScanner$FileCacheEntry;->mRowId:J

    .line 437
    .end local v3    # "result":Landroid/net/Uri;
    .end local v4    # "rowId":J
    .end local v6    # "tableUri":Landroid/net/Uri;
    .end local v7    # "title":Ljava/lang/String;
    .end local v8    # "values":Landroid/content/ContentValues;
    :cond_3
    :goto_1
    return-object v3

    .end local v0    # "isVideo":Z
    :cond_4
    move v0, v10

    .line 399
    goto :goto_0

    .restart local v0    # "isVideo":Z
    :cond_5
    move-object v3, v9

    .line 403
    goto :goto_1

    .line 433
    .restart local v3    # "result":Landroid/net/Uri;
    .restart local v4    # "rowId":J
    .restart local v6    # "tableUri":Landroid/net/Uri;
    .restart local v7    # "title":Ljava/lang/String;
    .restart local v8    # "values":Landroid/content/ContentValues;
    :cond_6
    invoke-static {v6, v4, v5}, Landroid/content/ContentUris;->withAppendedId(Landroid/net/Uri;J)Landroid/net/Uri;

    move-result-object v3

    .line 434
    iget-object v10, p0, Lio/vov/vitamio/MediaScanner$MyMediaScannerClient;->this$0:Lio/vov/vitamio/MediaScanner;

    invoke-static {v10}, Lio/vov/vitamio/MediaScanner;->access$400(Lio/vov/vitamio/MediaScanner;)Landroid/content/ContentProviderClient;

    move-result-object v10

    invoke-virtual {v10, v3, v8, v9, v9}, Landroid/content/ContentProviderClient;->update(Landroid/net/Uri;Landroid/content/ContentValues;Ljava/lang/String;[Ljava/lang/String;)I

    goto :goto_1
.end method

.method private parseSubstring(Ljava/lang/String;II)I
    .locals 8
    .param p1, "s"    # Ljava/lang/String;
    .param p2, "start"    # I
    .param p3, "defaultValue"    # I

    .prologue
    const/16 v7, 0x39

    const/16 v6, 0x30

    .line 321
    invoke-virtual {p1}, Ljava/lang/String;->length()I

    move-result v1

    .line 322
    .local v1, "length":I
    if-ne p2, v1, :cond_0

    .line 337
    .end local p3    # "defaultValue":I
    :goto_0
    return p3

    .line 325
    .restart local p3    # "defaultValue":I
    :cond_0
    add-int/lit8 v3, p2, 0x1

    .end local p2    # "start":I
    .local v3, "start":I
    invoke-virtual {p1, p2}, Ljava/lang/String;->charAt(I)C

    move-result v0

    .line 326
    .local v0, "ch":C
    if-lt v0, v6, :cond_1

    if-le v0, v7, :cond_2

    :cond_1
    move p2, v3

    .line 327
    .end local v3    # "start":I
    .restart local p2    # "start":I
    goto :goto_0

    .line 329
    .end local p2    # "start":I
    .restart local v3    # "start":I
    :cond_2
    add-int/lit8 v2, v0, -0x30

    .line 330
    .local v2, "result":I
    :goto_1
    if-ge v3, v1, :cond_5

    .line 331
    add-int/lit8 p2, v3, 0x1

    .end local v3    # "start":I
    .restart local p2    # "start":I
    invoke-virtual {p1, v3}, Ljava/lang/String;->charAt(I)C

    move-result v0

    .line 332
    if-lt v0, v6, :cond_3

    if-le v0, v7, :cond_4

    :cond_3
    move p3, v2

    .line 333
    goto :goto_0

    .line 334
    :cond_4
    mul-int/lit8 v4, v2, 0xa

    add-int/lit8 v5, v0, -0x30

    add-int v2, v4, v5

    move v3, p2

    .end local p2    # "start":I
    .restart local v3    # "start":I
    goto :goto_1

    :cond_5
    move p2, v3

    .end local v3    # "start":I
    .restart local p2    # "start":I
    move p3, v2

    .line 337
    goto :goto_0
.end method

.method private toValues()Landroid/content/ContentValues;
    .locals 4

    .prologue
    .line 377
    new-instance v0, Landroid/content/ContentValues;

    invoke-direct {v0}, Landroid/content/ContentValues;-><init>()V

    .line 379
    .local v0, "map":Landroid/content/ContentValues;
    const-string v1, "_data"

    iget-object v2, p0, Lio/vov/vitamio/MediaScanner$MyMediaScannerClient;->mPath:Ljava/lang/String;

    invoke-virtual {v0, v1, v2}, Landroid/content/ContentValues;->put(Ljava/lang/String;Ljava/lang/String;)V

    .line 380
    const-string v1, "date_modified"

    iget-wide v2, p0, Lio/vov/vitamio/MediaScanner$MyMediaScannerClient;->mLastModified:J

    invoke-static {v2, v3}, Ljava/lang/Long;->valueOf(J)Ljava/lang/Long;

    move-result-object v2

    invoke-virtual {v0, v1, v2}, Landroid/content/ContentValues;->put(Ljava/lang/String;Ljava/lang/Long;)V

    .line 381
    const-string v1, "_size"

    iget-wide v2, p0, Lio/vov/vitamio/MediaScanner$MyMediaScannerClient;->mFileSize:J

    invoke-static {v2, v3}, Ljava/lang/Long;->valueOf(J)Ljava/lang/Long;

    move-result-object v2

    invoke-virtual {v0, v1, v2}, Landroid/content/ContentValues;->put(Ljava/lang/String;Ljava/lang/Long;)V

    .line 382
    const-string v1, "mime_type"

    iget-object v2, p0, Lio/vov/vitamio/MediaScanner$MyMediaScannerClient;->mMimeType:Ljava/lang/String;

    invoke-virtual {v0, v1, v2}, Landroid/content/ContentValues;->put(Ljava/lang/String;Ljava/lang/String;)V

    .line 383
    const-string v1, "title"

    iget-object v2, p0, Lio/vov/vitamio/MediaScanner$MyMediaScannerClient;->mTitle:Ljava/lang/String;

    invoke-virtual {v0, v1, v2}, Landroid/content/ContentValues;->put(Ljava/lang/String;Ljava/lang/String;)V

    .line 385
    iget v1, p0, Lio/vov/vitamio/MediaScanner$MyMediaScannerClient;->mFileType:I

    invoke-static {v1}, Lio/vov/vitamio/MediaFile;->isVideoFileType(I)Z

    move-result v1

    if-eqz v1, :cond_0

    .line 386
    const-string v1, "duration"

    iget-wide v2, p0, Lio/vov/vitamio/MediaScanner$MyMediaScannerClient;->mDuration:J

    invoke-static {v2, v3}, Ljava/lang/Long;->valueOf(J)Ljava/lang/Long;

    move-result-object v2

    invoke-virtual {v0, v1, v2}, Landroid/content/ContentValues;->put(Ljava/lang/String;Ljava/lang/Long;)V

    .line 387
    const-string v1, "language"

    iget-object v2, p0, Lio/vov/vitamio/MediaScanner$MyMediaScannerClient;->mLanguage:Ljava/lang/String;

    invoke-virtual {v0, v1, v2}, Landroid/content/ContentValues;->put(Ljava/lang/String;Ljava/lang/String;)V

    .line 388
    const-string v1, "album"

    iget-object v2, p0, Lio/vov/vitamio/MediaScanner$MyMediaScannerClient;->mAlbum:Ljava/lang/String;

    invoke-virtual {v0, v1, v2}, Landroid/content/ContentValues;->put(Ljava/lang/String;Ljava/lang/String;)V

    .line 389
    const-string v1, "artist"

    iget-object v2, p0, Lio/vov/vitamio/MediaScanner$MyMediaScannerClient;->mArtist:Ljava/lang/String;

    invoke-virtual {v0, v1, v2}, Landroid/content/ContentValues;->put(Ljava/lang/String;Ljava/lang/String;)V

    .line 390
    const-string v1, "width"

    iget v2, p0, Lio/vov/vitamio/MediaScanner$MyMediaScannerClient;->mWidth:I

    invoke-static {v2}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v2

    invoke-virtual {v0, v1, v2}, Landroid/content/ContentValues;->put(Ljava/lang/String;Ljava/lang/Integer;)V

    .line 391
    const-string v1, "height"

    iget v2, p0, Lio/vov/vitamio/MediaScanner$MyMediaScannerClient;->mHeight:I

    invoke-static {v2}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v2

    invoke-virtual {v0, v1, v2}, Landroid/content/ContentValues;->put(Ljava/lang/String;Ljava/lang/Integer;)V

    .line 394
    :cond_0
    return-object v0
.end method


# virtual methods
.method public addNoMediaFolder(Ljava/lang/String;)V
    .locals 6
    .param p1, "path"    # Ljava/lang/String;

    .prologue
    .line 441
    new-instance v2, Landroid/content/ContentValues;

    invoke-direct {v2}, Landroid/content/ContentValues;-><init>()V

    .line 442
    .local v2, "values":Landroid/content/ContentValues;
    const-string v3, "_data"

    const-string v4, ""

    invoke-virtual {v2, v3, v4}, Landroid/content/ContentValues;->put(Ljava/lang/String;Ljava/lang/String;)V

    .line 443
    const/4 v3, 0x1

    new-array v1, v3, [Ljava/lang/String;

    const/4 v3, 0x0

    new-instance v4, Ljava/lang/StringBuilder;

    invoke-direct {v4}, Ljava/lang/StringBuilder;-><init>()V

    invoke-virtual {v4, p1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v4

    const/16 v5, 0x25

    invoke-virtual {v4, v5}, Ljava/lang/StringBuilder;->append(C)Ljava/lang/StringBuilder;

    move-result-object v4

    invoke-virtual {v4}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v4

    aput-object v4, v1, v3

    .line 445
    .local v1, "pathSpec":[Ljava/lang/String;
    :try_start_0
    iget-object v3, p0, Lio/vov/vitamio/MediaScanner$MyMediaScannerClient;->this$0:Lio/vov/vitamio/MediaScanner;

    invoke-static {v3}, Lio/vov/vitamio/MediaScanner;->access$400(Lio/vov/vitamio/MediaScanner;)Landroid/content/ContentProviderClient;

    move-result-object v3

    sget-object v4, Lio/vov/vitamio/provider/MediaStore$Video$Media;->CONTENT_URI:Landroid/net/Uri;

    const-string v5, "_data LIKE ?"

    invoke-virtual {v3, v4, v2, v5, v1}, Landroid/content/ContentProviderClient;->update(Landroid/net/Uri;Landroid/content/ContentValues;Ljava/lang/String;[Ljava/lang/String;)I
    :try_end_0
    .catch Landroid/os/RemoteException; {:try_start_0 .. :try_end_0} :catch_0

    .line 449
    return-void

    .line 446
    :catch_0
    move-exception v0

    .line 447
    .local v0, "e":Landroid/os/RemoteException;
    new-instance v3, Ljava/lang/RuntimeException;

    invoke-direct {v3}, Ljava/lang/RuntimeException;-><init>()V

    throw v3
.end method

.method public beginFile(Ljava/lang/String;JJ)Lio/vov/vitamio/MediaScanner$FileCacheEntry;
    .locals 18
    .param p1, "path"    # Ljava/lang/String;
    .param p2, "lastModified"    # J
    .param p4, "fileSize"    # J

    .prologue
    .line 248
    const/16 v5, 0x2f

    move-object/from16 v0, p1

    invoke-virtual {v0, v5}, Ljava/lang/String;->lastIndexOf(I)I

    move-result v14

    .line 249
    .local v14, "lastSlash":I
    if-ltz v14, :cond_5

    add-int/lit8 v5, v14, 0x2

    invoke-virtual/range {p1 .. p1}, Ljava/lang/String;->length()I

    move-result v6

    if-ge v5, v6, :cond_5

    .line 250
    add-int/lit8 v5, v14, 0x1

    const-string v6, "._"

    const/4 v7, 0x0

    const/4 v8, 0x2

    move-object/from16 v0, p1

    invoke-virtual {v0, v5, v6, v7, v8}, Ljava/lang/String;->regionMatches(ILjava/lang/String;II)Z

    move-result v5

    if-eqz v5, :cond_0

    .line 251
    const/4 v4, 0x0

    .line 292
    :goto_0
    return-object v4

    .line 253
    :cond_0
    const/4 v5, 0x1

    invoke-virtual/range {p1 .. p1}, Ljava/lang/String;->length()I

    move-result v6

    add-int/lit8 v6, v6, -0x4

    const-string v7, ".jpg"

    const/4 v8, 0x0

    const/4 v9, 0x4

    move-object/from16 v4, p1

    invoke-virtual/range {v4 .. v9}, Ljava/lang/String;->regionMatches(ZILjava/lang/String;II)Z

    move-result v5

    if-eqz v5, :cond_5

    .line 254
    const/4 v5, 0x1

    add-int/lit8 v6, v14, 0x1

    const-string v7, "AlbumArt_{"

    const/4 v8, 0x0

    const/16 v9, 0xa

    move-object/from16 v4, p1

    invoke-virtual/range {v4 .. v9}, Ljava/lang/String;->regionMatches(ZILjava/lang/String;II)Z

    move-result v5

    if-nez v5, :cond_1

    const/4 v5, 0x1

    add-int/lit8 v6, v14, 0x1

    const-string v7, "AlbumArt."

    const/4 v8, 0x0

    const/16 v9, 0x9

    move-object/from16 v4, p1

    invoke-virtual/range {v4 .. v9}, Ljava/lang/String;->regionMatches(ZILjava/lang/String;II)Z

    move-result v5

    if-eqz v5, :cond_2

    .line 255
    :cond_1
    const/4 v4, 0x0

    goto :goto_0

    .line 257
    :cond_2
    invoke-virtual/range {p1 .. p1}, Ljava/lang/String;->length()I

    move-result v5

    sub-int/2addr v5, v14

    add-int/lit8 v15, v5, -0x1

    .line 258
    .local v15, "length":I
    const/16 v5, 0x11

    if-ne v15, v5, :cond_3

    const/4 v5, 0x1

    add-int/lit8 v6, v14, 0x1

    const-string v7, "AlbumArtSmall"

    const/4 v8, 0x0

    const/16 v9, 0xd

    move-object/from16 v4, p1

    invoke-virtual/range {v4 .. v9}, Ljava/lang/String;->regionMatches(ZILjava/lang/String;II)Z

    move-result v5

    if-nez v5, :cond_4

    :cond_3
    const/16 v5, 0xa

    if-ne v15, v5, :cond_5

    const/4 v5, 0x1

    add-int/lit8 v6, v14, 0x1

    const-string v7, "Folder"

    const/4 v8, 0x0

    const/4 v9, 0x6

    move-object/from16 v4, p1

    invoke-virtual/range {v4 .. v9}, Ljava/lang/String;->regionMatches(ZILjava/lang/String;II)Z

    move-result v5

    if-eqz v5, :cond_5

    .line 259
    :cond_4
    const/4 v4, 0x0

    goto :goto_0

    .line 264
    .end local v15    # "length":I
    :cond_5
    invoke-static/range {p1 .. p1}, Lio/vov/vitamio/MediaFile;->getFileType(Ljava/lang/String;)Lio/vov/vitamio/MediaFile$MediaFileType;

    move-result-object v16

    .line 265
    .local v16, "mediaFileType":Lio/vov/vitamio/MediaFile$MediaFileType;
    if-eqz v16, :cond_6

    .line 266
    move-object/from16 v0, v16

    iget v5, v0, Lio/vov/vitamio/MediaFile$MediaFileType;->fileType:I

    move-object/from16 v0, p0

    iput v5, v0, Lio/vov/vitamio/MediaScanner$MyMediaScannerClient;->mFileType:I

    .line 267
    move-object/from16 v0, v16

    iget-object v5, v0, Lio/vov/vitamio/MediaFile$MediaFileType;->mimeType:Ljava/lang/String;

    move-object/from16 v0, p0

    iput-object v5, v0, Lio/vov/vitamio/MediaScanner$MyMediaScannerClient;->mMimeType:Ljava/lang/String;

    .line 270
    :cond_6
    new-instance v5, Ljava/io/File;

    move-object/from16 v0, p1

    invoke-direct {v5, v0}, Ljava/io/File;-><init>(Ljava/lang/String;)V

    invoke-static {v5}, Lio/vov/vitamio/utils/FileUtils;->getCanonical(Ljava/io/File;)Ljava/lang/String;

    move-result-object v11

    .line 271
    .local v11, "key":Ljava/lang/String;
    move-object/from16 v0, p0

    iget-object v5, v0, Lio/vov/vitamio/MediaScanner$MyMediaScannerClient;->this$0:Lio/vov/vitamio/MediaScanner;

    invoke-static {v5}, Lio/vov/vitamio/MediaScanner;->access$100(Lio/vov/vitamio/MediaScanner;)Z

    move-result v5

    if-eqz v5, :cond_7

    .line 272
    invoke-virtual/range {p1 .. p1}, Ljava/lang/String;->toLowerCase()Ljava/lang/String;

    move-result-object v11

    .line 273
    :cond_7
    move-object/from16 v0, p0

    iget-object v5, v0, Lio/vov/vitamio/MediaScanner$MyMediaScannerClient;->this$0:Lio/vov/vitamio/MediaScanner;

    invoke-static {v5}, Lio/vov/vitamio/MediaScanner;->access$200(Lio/vov/vitamio/MediaScanner;)Ljava/util/HashMap;

    move-result-object v5

    invoke-virtual {v5, v11}, Ljava/util/HashMap;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v4

    check-cast v4, Lio/vov/vitamio/MediaScanner$FileCacheEntry;

    .line 274
    .local v4, "entry":Lio/vov/vitamio/MediaScanner$FileCacheEntry;
    if-nez v4, :cond_8

    .line 275
    new-instance v4, Lio/vov/vitamio/MediaScanner$FileCacheEntry;

    .end local v4    # "entry":Lio/vov/vitamio/MediaScanner$FileCacheEntry;
    const/4 v5, 0x0

    const-wide/16 v6, 0x0

    const-wide/16 v9, 0x0

    move-object/from16 v8, p1

    invoke-direct/range {v4 .. v10}, Lio/vov/vitamio/MediaScanner$FileCacheEntry;-><init>(Landroid/net/Uri;JLjava/lang/String;J)V

    .line 276
    .restart local v4    # "entry":Lio/vov/vitamio/MediaScanner$FileCacheEntry;
    move-object/from16 v0, p0

    iget-object v5, v0, Lio/vov/vitamio/MediaScanner$MyMediaScannerClient;->this$0:Lio/vov/vitamio/MediaScanner;

    invoke-static {v5}, Lio/vov/vitamio/MediaScanner;->access$200(Lio/vov/vitamio/MediaScanner;)Ljava/util/HashMap;

    move-result-object v5

    invoke-virtual {v5, v11, v4}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 278
    :cond_8
    const/4 v5, 0x1

    iput-boolean v5, v4, Lio/vov/vitamio/MediaScanner$FileCacheEntry;->mSeenInFileSystem:Z

    .line 280
    iget-wide v6, v4, Lio/vov/vitamio/MediaScanner$FileCacheEntry;->mLastModified:J

    sub-long v12, p2, v6

    .line 281
    .local v12, "delta":J
    const-wide/16 v6, 0x1

    cmp-long v5, v12, v6

    if-gtz v5, :cond_9

    const-wide/16 v6, -0x1

    cmp-long v5, v12, v6

    if-gez v5, :cond_a

    .line 282
    :cond_9
    move-wide/from16 v0, p2

    iput-wide v0, v4, Lio/vov/vitamio/MediaScanner$FileCacheEntry;->mLastModified:J

    .line 283
    const/4 v5, 0x1

    iput-boolean v5, v4, Lio/vov/vitamio/MediaScanner$FileCacheEntry;->mLastModifiedChanged:Z

    .line 286
    :cond_a
    move-object/from16 v0, p1

    move-object/from16 v1, p0

    iput-object v0, v1, Lio/vov/vitamio/MediaScanner$MyMediaScannerClient;->mPath:Ljava/lang/String;

    .line 287
    move-wide/from16 v0, p2

    move-object/from16 v2, p0

    iput-wide v0, v2, Lio/vov/vitamio/MediaScanner$MyMediaScannerClient;->mLastModified:J

    .line 288
    move-wide/from16 v0, p4

    move-object/from16 v2, p0

    iput-wide v0, v2, Lio/vov/vitamio/MediaScanner$MyMediaScannerClient;->mFileSize:J

    .line 289
    const/4 v5, 0x0

    move-object/from16 v0, p0

    iput-object v5, v0, Lio/vov/vitamio/MediaScanner$MyMediaScannerClient;->mTitle:Ljava/lang/String;

    .line 290
    const-wide/16 v6, 0x0

    move-object/from16 v0, p0

    iput-wide v6, v0, Lio/vov/vitamio/MediaScanner$MyMediaScannerClient;->mDuration:J

    goto/16 :goto_0
.end method

.method public doScanFile(Ljava/lang/String;JJZ)Landroid/net/Uri;
    .locals 6
    .param p1, "path"    # Ljava/lang/String;
    .param p2, "lastModified"    # J
    .param p4, "fileSize"    # J
    .param p6, "scanAlways"    # Z

    .prologue
    .line 301
    const/4 v2, 0x0

    .line 303
    .local v2, "result":Landroid/net/Uri;
    :try_start_0
    invoke-virtual/range {p0 .. p5}, Lio/vov/vitamio/MediaScanner$MyMediaScannerClient;->beginFile(Ljava/lang/String;JJ)Lio/vov/vitamio/MediaScanner$FileCacheEntry;

    move-result-object v1

    .line 304
    .local v1, "entry":Lio/vov/vitamio/MediaScanner$FileCacheEntry;
    if-eqz v1, :cond_1

    iget-boolean v3, v1, Lio/vov/vitamio/MediaScanner$FileCacheEntry;->mLastModifiedChanged:Z

    if-nez v3, :cond_0

    if-eqz p6, :cond_1

    .line 305
    :cond_0
    iget-object v3, p0, Lio/vov/vitamio/MediaScanner$MyMediaScannerClient;->this$0:Lio/vov/vitamio/MediaScanner;

    const/4 v4, 0x0

    invoke-static {v3, p1, v4}, Lio/vov/vitamio/MediaScanner;->access$300(Lio/vov/vitamio/MediaScanner;Ljava/lang/String;Ljava/lang/String;)Z

    move-result v3

    if-eqz v3, :cond_2

    .line 306
    invoke-direct {p0, v1}, Lio/vov/vitamio/MediaScanner$MyMediaScannerClient;->endFile(Lio/vov/vitamio/MediaScanner$FileCacheEntry;)Landroid/net/Uri;

    move-result-object v2

    .line 317
    .end local v1    # "entry":Lio/vov/vitamio/MediaScanner$FileCacheEntry;
    :cond_1
    :goto_0
    return-object v2

    .line 308
    .restart local v1    # "entry":Lio/vov/vitamio/MediaScanner$FileCacheEntry;
    :cond_2
    iget-object v3, p0, Lio/vov/vitamio/MediaScanner$MyMediaScannerClient;->this$0:Lio/vov/vitamio/MediaScanner;

    invoke-static {v3}, Lio/vov/vitamio/MediaScanner;->access$100(Lio/vov/vitamio/MediaScanner;)Z

    move-result v3

    if-eqz v3, :cond_3

    .line 309
    iget-object v3, p0, Lio/vov/vitamio/MediaScanner$MyMediaScannerClient;->this$0:Lio/vov/vitamio/MediaScanner;

    invoke-static {v3}, Lio/vov/vitamio/MediaScanner;->access$200(Lio/vov/vitamio/MediaScanner;)Ljava/util/HashMap;

    move-result-object v3

    invoke-virtual {p1}, Ljava/lang/String;->toLowerCase()Ljava/lang/String;

    move-result-object v4

    invoke-virtual {v3, v4}, Ljava/util/HashMap;->remove(Ljava/lang/Object;)Ljava/lang/Object;
    :try_end_0
    .catch Landroid/os/RemoteException; {:try_start_0 .. :try_end_0} :catch_0

    goto :goto_0

    .line 314
    .end local v1    # "entry":Lio/vov/vitamio/MediaScanner$FileCacheEntry;
    :catch_0
    move-exception v0

    .line 315
    .local v0, "e":Landroid/os/RemoteException;
    const-string v3, "RemoteException in MediaScanner.scanFile()"

    invoke-static {v3, v0}, Lio/vov/vitamio/utils/Log;->e(Ljava/lang/String;Ljava/lang/Throwable;)V

    goto :goto_0

    .line 311
    .end local v0    # "e":Landroid/os/RemoteException;
    .restart local v1    # "entry":Lio/vov/vitamio/MediaScanner$FileCacheEntry;
    :cond_3
    :try_start_1
    iget-object v3, p0, Lio/vov/vitamio/MediaScanner$MyMediaScannerClient;->this$0:Lio/vov/vitamio/MediaScanner;

    invoke-static {v3}, Lio/vov/vitamio/MediaScanner;->access$200(Lio/vov/vitamio/MediaScanner;)Ljava/util/HashMap;

    move-result-object v3

    invoke-virtual {v3, p1}, Ljava/util/HashMap;->remove(Ljava/lang/Object;)Ljava/lang/Object;
    :try_end_1
    .catch Landroid/os/RemoteException; {:try_start_1 .. :try_end_1} :catch_0

    goto :goto_0
.end method

.method public handleStringTag(Ljava/lang/String;[BLjava/lang/String;)V
    .locals 6
    .param p1, "name"    # Ljava/lang/String;
    .param p2, "valueBytes"    # [B
    .param p3, "valueEncoding"    # Ljava/lang/String;

    .prologue
    const/4 v5, 0x0

    .line 343
    :try_start_0
    new-instance v1, Ljava/lang/String;

    invoke-direct {v1, p2, p3}, Ljava/lang/String;-><init>([BLjava/lang/String;)V
    :try_end_0
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_0

    .line 348
    .local v1, "value":Ljava/lang/String;
    :goto_0
    const-string v2, "%s : %s"

    const/4 v3, 0x2

    new-array v3, v3, [Ljava/lang/Object;

    aput-object p1, v3, v5

    const/4 v4, 0x1

    aput-object v1, v3, v4

    invoke-static {v2, v3}, Lio/vov/vitamio/utils/Log;->i(Ljava/lang/String;[Ljava/lang/Object;)V

    .line 350
    const-string v2, "title"

    invoke-virtual {p1, v2}, Ljava/lang/String;->equalsIgnoreCase(Ljava/lang/String;)Z

    move-result v2

    if-eqz v2, :cond_1

    .line 351
    iput-object v1, p0, Lio/vov/vitamio/MediaScanner$MyMediaScannerClient;->mTitle:Ljava/lang/String;

    .line 368
    :cond_0
    :goto_1
    return-void

    .line 344
    .end local v1    # "value":Ljava/lang/String;
    :catch_0
    move-exception v0

    .line 345
    .local v0, "e":Ljava/lang/Exception;
    const-string v2, "handleStringTag"

    invoke-static {v2, v0}, Lio/vov/vitamio/utils/Log;->e(Ljava/lang/String;Ljava/lang/Throwable;)V

    .line 346
    new-instance v1, Ljava/lang/String;

    invoke-direct {v1, p2}, Ljava/lang/String;-><init>([B)V

    .restart local v1    # "value":Ljava/lang/String;
    goto :goto_0

    .line 352
    .end local v0    # "e":Ljava/lang/Exception;
    :cond_1
    const-string v2, "artist"

    invoke-virtual {p1, v2}, Ljava/lang/String;->equalsIgnoreCase(Ljava/lang/String;)Z

    move-result v2

    if-eqz v2, :cond_2

    .line 353
    invoke-virtual {v1}, Ljava/lang/String;->trim()Ljava/lang/String;

    move-result-object v2

    iput-object v2, p0, Lio/vov/vitamio/MediaScanner$MyMediaScannerClient;->mArtist:Ljava/lang/String;

    goto :goto_1

    .line 354
    :cond_2
    const-string v2, "albumartist"

    invoke-virtual {p1, v2}, Ljava/lang/String;->equalsIgnoreCase(Ljava/lang/String;)Z

    move-result v2

    if-eqz v2, :cond_3

    .line 355
    iget-object v2, p0, Lio/vov/vitamio/MediaScanner$MyMediaScannerClient;->mArtist:Ljava/lang/String;

    invoke-static {v2}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result v2

    if-eqz v2, :cond_0

    .line 356
    invoke-virtual {v1}, Ljava/lang/String;->trim()Ljava/lang/String;

    move-result-object v2

    iput-object v2, p0, Lio/vov/vitamio/MediaScanner$MyMediaScannerClient;->mArtist:Ljava/lang/String;

    goto :goto_1

    .line 357
    :cond_3
    const-string v2, "album"

    invoke-virtual {p1, v2}, Ljava/lang/String;->equalsIgnoreCase(Ljava/lang/String;)Z

    move-result v2

    if-eqz v2, :cond_4

    .line 358
    invoke-virtual {v1}, Ljava/lang/String;->trim()Ljava/lang/String;

    move-result-object v2

    iput-object v2, p0, Lio/vov/vitamio/MediaScanner$MyMediaScannerClient;->mAlbum:Ljava/lang/String;

    goto :goto_1

    .line 359
    :cond_4
    const-string v2, "language"

    invoke-virtual {p1, v2}, Ljava/lang/String;->equalsIgnoreCase(Ljava/lang/String;)Z

    move-result v2

    if-eqz v2, :cond_5

    .line 360
    invoke-virtual {v1}, Ljava/lang/String;->trim()Ljava/lang/String;

    move-result-object v2

    iput-object v2, p0, Lio/vov/vitamio/MediaScanner$MyMediaScannerClient;->mLanguage:Ljava/lang/String;

    goto :goto_1

    .line 361
    :cond_5
    const-string v2, "duration"

    invoke-virtual {p1, v2}, Ljava/lang/String;->equalsIgnoreCase(Ljava/lang/String;)Z

    move-result v2

    if-eqz v2, :cond_6

    .line 362
    invoke-direct {p0, v1, v5, v5}, Lio/vov/vitamio/MediaScanner$MyMediaScannerClient;->parseSubstring(Ljava/lang/String;II)I

    move-result v2

    int-to-long v2, v2

    iput-wide v2, p0, Lio/vov/vitamio/MediaScanner$MyMediaScannerClient;->mDuration:J

    goto :goto_1

    .line 363
    :cond_6
    const-string v2, "width"

    invoke-virtual {p1, v2}, Ljava/lang/String;->equalsIgnoreCase(Ljava/lang/String;)Z

    move-result v2

    if-eqz v2, :cond_7

    .line 364
    invoke-direct {p0, v1, v5, v5}, Lio/vov/vitamio/MediaScanner$MyMediaScannerClient;->parseSubstring(Ljava/lang/String;II)I

    move-result v2

    iput v2, p0, Lio/vov/vitamio/MediaScanner$MyMediaScannerClient;->mWidth:I

    goto :goto_1

    .line 365
    :cond_7
    const-string v2, "height"

    invoke-virtual {p1, v2}, Ljava/lang/String;->equalsIgnoreCase(Ljava/lang/String;)Z

    move-result v2

    if-eqz v2, :cond_0

    .line 366
    invoke-direct {p0, v1, v5, v5}, Lio/vov/vitamio/MediaScanner$MyMediaScannerClient;->parseSubstring(Ljava/lang/String;II)I

    move-result v2

    iput v2, p0, Lio/vov/vitamio/MediaScanner$MyMediaScannerClient;->mHeight:I

    goto :goto_1
.end method

.method public scanFile(Ljava/lang/String;JJ)V
    .locals 8
    .param p1, "path"    # Ljava/lang/String;
    .param p2, "lastModified"    # J
    .param p4, "fileSize"    # J

    .prologue
    const/4 v6, 0x0

    .line 296
    const-string v0, "scanFile: %s"

    const/4 v1, 0x1

    new-array v1, v1, [Ljava/lang/Object;

    aput-object p1, v1, v6

    invoke-static {v0, v1}, Lio/vov/vitamio/utils/Log;->i(Ljava/lang/String;[Ljava/lang/Object;)V

    move-object v0, p0

    move-object v1, p1

    move-wide v2, p2

    move-wide v4, p4

    .line 297
    invoke-virtual/range {v0 .. v6}, Lio/vov/vitamio/MediaScanner$MyMediaScannerClient;->doScanFile(Ljava/lang/String;JJZ)Landroid/net/Uri;

    .line 298
    return-void
.end method

.method public setMimeType(Ljava/lang/String;)V
    .locals 3
    .param p1, "mimeType"    # Ljava/lang/String;

    .prologue
    .line 371
    const-string v0, "setMimeType: %s"

    const/4 v1, 0x1

    new-array v1, v1, [Ljava/lang/Object;

    const/4 v2, 0x0

    aput-object p1, v1, v2

    invoke-static {v0, v1}, Lio/vov/vitamio/utils/Log;->i(Ljava/lang/String;[Ljava/lang/Object;)V

    .line 372
    iput-object p1, p0, Lio/vov/vitamio/MediaScanner$MyMediaScannerClient;->mMimeType:Ljava/lang/String;

    .line 373
    invoke-static {p1}, Lio/vov/vitamio/MediaFile;->getFileTypeForMimeType(Ljava/lang/String;)I

    move-result v0

    iput v0, p0, Lio/vov/vitamio/MediaScanner$MyMediaScannerClient;->mFileType:I

    .line 374
    return-void
.end method

.class public Lcom/facebook/react/modules/camera/CameraRollManager;
.super Lcom/facebook/react/bridge/ReactContextBaseJavaModule;
.source "CameraRollManager.java"


# annotations
.annotation runtime Lcom/facebook/react/module/annotations/ReactModule;
    name = "CameraRollManager"
.end annotation

.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lcom/facebook/react/modules/camera/CameraRollManager$GetPhotosTask;,
        Lcom/facebook/react/modules/camera/CameraRollManager$SaveToCameraRoll;
    }
.end annotation


# static fields
.field private static final ERROR_UNABLE_TO_LOAD:Ljava/lang/String; = "E_UNABLE_TO_LOAD"

.field private static final ERROR_UNABLE_TO_LOAD_PERMISSION:Ljava/lang/String; = "E_UNABLE_TO_LOAD_PERMISSION"

.field private static final ERROR_UNABLE_TO_SAVE:Ljava/lang/String; = "E_UNABLE_TO_SAVE"

.field public static final IS_JELLY_BEAN_OR_LATER:Z

.field protected static final NAME:Ljava/lang/String; = "CameraRollManager"

.field private static final PROJECTION:[Ljava/lang/String;

.field private static final SELECTION_BUCKET:Ljava/lang/String; = "bucket_display_name = ?"

.field private static final SELECTION_DATE_TAKEN:Ljava/lang/String; = "datetaken < ?"


# direct methods
.method static constructor <clinit>()V
    .locals 7

    .prologue
    const/4 v6, 0x4

    const/4 v5, 0x3

    const/4 v4, 0x2

    const/4 v1, 0x1

    const/4 v2, 0x0

    .line 67
    sget v0, Landroid/os/Build$VERSION;->SDK_INT:I

    const/16 v3, 0x10

    if-lt v0, v3, :cond_0

    move v0, v1

    :goto_0
    sput-boolean v0, Lcom/facebook/react/modules/camera/CameraRollManager;->IS_JELLY_BEAN_OR_LATER:Z

    .line 72
    sget-boolean v0, Lcom/facebook/react/modules/camera/CameraRollManager;->IS_JELLY_BEAN_OR_LATER:Z

    if-eqz v0, :cond_1

    .line 73
    const/16 v0, 0x8

    new-array v0, v0, [Ljava/lang/String;

    const-string v3, "_id"

    aput-object v3, v0, v2

    const-string v2, "mime_type"

    aput-object v2, v0, v1

    const-string v1, "bucket_display_name"

    aput-object v1, v0, v4

    const-string v1, "datetaken"

    aput-object v1, v0, v5

    const-string v1, "width"

    aput-object v1, v0, v6

    const/4 v1, 0x5

    const-string v2, "height"

    aput-object v2, v0, v1

    const/4 v1, 0x6

    const-string v2, "longitude"

    aput-object v2, v0, v1

    const/4 v1, 0x7

    const-string v2, "latitude"

    aput-object v2, v0, v1

    sput-object v0, Lcom/facebook/react/modules/camera/CameraRollManager;->PROJECTION:[Ljava/lang/String;

    .line 93
    :goto_1
    return-void

    :cond_0
    move v0, v2

    .line 67
    goto :goto_0

    .line 84
    :cond_1
    const/4 v0, 0x6

    new-array v0, v0, [Ljava/lang/String;

    const-string v3, "_id"

    aput-object v3, v0, v2

    const-string v2, "mime_type"

    aput-object v2, v0, v1

    const-string v1, "bucket_display_name"

    aput-object v1, v0, v4

    const-string v1, "datetaken"

    aput-object v1, v0, v5

    const-string v1, "longitude"

    aput-object v1, v0, v6

    const/4 v1, 0x5

    const-string v2, "latitude"

    aput-object v2, v0, v1

    sput-object v0, Lcom/facebook/react/modules/camera/CameraRollManager;->PROJECTION:[Ljava/lang/String;

    goto :goto_1
.end method

.method public constructor <init>(Lcom/facebook/react/bridge/ReactApplicationContext;)V
    .locals 0
    .param p1, "reactContext"    # Lcom/facebook/react/bridge/ReactApplicationContext;

    .prologue
    .line 99
    invoke-direct {p0, p1}, Lcom/facebook/react/bridge/ReactContextBaseJavaModule;-><init>(Lcom/facebook/react/bridge/ReactApplicationContext;)V

    .line 100
    return-void
.end method

.method static synthetic access$200()[Ljava/lang/String;
    .locals 1

    .prologue
    .line 59
    sget-object v0, Lcom/facebook/react/modules/camera/CameraRollManager;->PROJECTION:[Ljava/lang/String;

    return-object v0
.end method

.method static synthetic access$300(Landroid/content/ContentResolver;Landroid/database/Cursor;Lcom/facebook/react/bridge/WritableMap;ILjava/lang/String;)V
    .locals 0
    .param p0, "x0"    # Landroid/content/ContentResolver;
    .param p1, "x1"    # Landroid/database/Cursor;
    .param p2, "x2"    # Lcom/facebook/react/bridge/WritableMap;
    .param p3, "x3"    # I
    .param p4, "x4"    # Ljava/lang/String;

    .prologue
    .line 59
    invoke-static {p0, p1, p2, p3, p4}, Lcom/facebook/react/modules/camera/CameraRollManager;->putEdges(Landroid/content/ContentResolver;Landroid/database/Cursor;Lcom/facebook/react/bridge/WritableMap;ILjava/lang/String;)V

    return-void
.end method

.method static synthetic access$400(Landroid/database/Cursor;Lcom/facebook/react/bridge/WritableMap;I)V
    .locals 0
    .param p0, "x0"    # Landroid/database/Cursor;
    .param p1, "x1"    # Lcom/facebook/react/bridge/WritableMap;
    .param p2, "x2"    # I

    .prologue
    .line 59
    invoke-static {p0, p1, p2}, Lcom/facebook/react/modules/camera/CameraRollManager;->putPageInfo(Landroid/database/Cursor;Lcom/facebook/react/bridge/WritableMap;I)V

    return-void
.end method

.method private static putBasicNodeInfo(Landroid/database/Cursor;Lcom/facebook/react/bridge/WritableMap;III)V
    .locals 6
    .param p0, "photos"    # Landroid/database/Cursor;
    .param p1, "node"    # Lcom/facebook/react/bridge/WritableMap;
    .param p2, "mimeTypeIndex"    # I
    .param p3, "groupNameIndex"    # I
    .param p4, "dateTakenIndex"    # I

    .prologue
    .line 387
    const-string v0, "type"

    invoke-interface {p0, p2}, Landroid/database/Cursor;->getString(I)Ljava/lang/String;

    move-result-object v1

    invoke-interface {p1, v0, v1}, Lcom/facebook/react/bridge/WritableMap;->putString(Ljava/lang/String;Ljava/lang/String;)V

    .line 388
    const-string v0, "group_name"

    invoke-interface {p0, p3}, Landroid/database/Cursor;->getString(I)Ljava/lang/String;

    move-result-object v1

    invoke-interface {p1, v0, v1}, Lcom/facebook/react/bridge/WritableMap;->putString(Ljava/lang/String;Ljava/lang/String;)V

    .line 389
    const-string v0, "timestamp"

    invoke-interface {p0, p4}, Landroid/database/Cursor;->getLong(I)J

    move-result-wide v2

    long-to-double v2, v2

    const-wide v4, 0x408f400000000000L    # 1000.0

    div-double/2addr v2, v4

    invoke-interface {p1, v0, v2, v3}, Lcom/facebook/react/bridge/WritableMap;->putDouble(Ljava/lang/String;D)V

    .line 390
    return-void
.end method

.method private static putEdges(Landroid/content/ContentResolver;Landroid/database/Cursor;Lcom/facebook/react/bridge/WritableMap;ILjava/lang/String;)V
    .locals 18
    .param p0, "resolver"    # Landroid/content/ContentResolver;
    .param p1, "photos"    # Landroid/database/Cursor;
    .param p2, "response"    # Lcom/facebook/react/bridge/WritableMap;
    .param p3, "limit"    # I
    .param p4, "assetType"    # Ljava/lang/String;
        .annotation runtime Ljavax/annotation/Nullable;
        .end annotation
    .end param

    .prologue
    .line 349
    new-instance v11, Lcom/facebook/react/bridge/WritableNativeArray;

    invoke-direct {v11}, Lcom/facebook/react/bridge/WritableNativeArray;-><init>()V

    .line 350
    .local v11, "edges":Lcom/facebook/react/bridge/WritableArray;
    invoke-interface/range {p1 .. p1}, Landroid/database/Cursor;->moveToFirst()Z

    .line 351
    const-string v2, "_id"

    move-object/from16 v0, p1

    invoke-interface {v0, v2}, Landroid/database/Cursor;->getColumnIndex(Ljava/lang/String;)I

    move-result v5

    .line 352
    .local v5, "idIndex":I
    const-string v2, "mime_type"

    move-object/from16 v0, p1

    invoke-interface {v0, v2}, Landroid/database/Cursor;->getColumnIndex(Ljava/lang/String;)I

    move-result v17

    .line 353
    .local v17, "mimeTypeIndex":I
    const-string v2, "bucket_display_name"

    move-object/from16 v0, p1

    invoke-interface {v0, v2}, Landroid/database/Cursor;->getColumnIndex(Ljava/lang/String;)I

    move-result v12

    .line 354
    .local v12, "groupNameIndex":I
    const-string v2, "datetaken"

    move-object/from16 v0, p1

    invoke-interface {v0, v2}, Landroid/database/Cursor;->getColumnIndex(Ljava/lang/String;)I

    move-result v9

    .line 355
    .local v9, "dateTakenIndex":I
    sget-boolean v2, Lcom/facebook/react/modules/camera/CameraRollManager;->IS_JELLY_BEAN_OR_LATER:Z

    if-eqz v2, :cond_0

    const-string v2, "width"

    move-object/from16 v0, p1

    invoke-interface {v0, v2}, Landroid/database/Cursor;->getColumnIndex(Ljava/lang/String;)I

    move-result v6

    .line 356
    .local v6, "widthIndex":I
    :goto_0
    sget-boolean v2, Lcom/facebook/react/modules/camera/CameraRollManager;->IS_JELLY_BEAN_OR_LATER:Z

    if-eqz v2, :cond_1

    const-string v2, "height"

    move-object/from16 v0, p1

    invoke-interface {v0, v2}, Landroid/database/Cursor;->getColumnIndex(Ljava/lang/String;)I

    move-result v7

    .line 357
    .local v7, "heightIndex":I
    :goto_1
    const-string v2, "longitude"

    move-object/from16 v0, p1

    invoke-interface {v0, v2}, Landroid/database/Cursor;->getColumnIndex(Ljava/lang/String;)I

    move-result v16

    .line 358
    .local v16, "longitudeIndex":I
    const-string v2, "latitude"

    move-object/from16 v0, p1

    invoke-interface {v0, v2}, Landroid/database/Cursor;->getColumnIndex(Ljava/lang/String;)I

    move-result v15

    .line 360
    .local v15, "latitudeIndex":I
    const/4 v13, 0x0

    .local v13, "i":I
    :goto_2
    move/from16 v0, p3

    if-ge v13, v0, :cond_3

    invoke-interface/range {p1 .. p1}, Landroid/database/Cursor;->isAfterLast()Z

    move-result v2

    if-nez v2, :cond_3

    .line 361
    new-instance v10, Lcom/facebook/react/bridge/WritableNativeMap;

    invoke-direct {v10}, Lcom/facebook/react/bridge/WritableNativeMap;-><init>()V

    .line 362
    .local v10, "edge":Lcom/facebook/react/bridge/WritableMap;
    new-instance v4, Lcom/facebook/react/bridge/WritableNativeMap;

    invoke-direct {v4}, Lcom/facebook/react/bridge/WritableNativeMap;-><init>()V

    .local v4, "node":Lcom/facebook/react/bridge/WritableMap;
    move-object/from16 v2, p0

    move-object/from16 v3, p1

    move-object/from16 v8, p4

    .line 364
    invoke-static/range {v2 .. v8}, Lcom/facebook/react/modules/camera/CameraRollManager;->putImageInfo(Landroid/content/ContentResolver;Landroid/database/Cursor;Lcom/facebook/react/bridge/WritableMap;IIILjava/lang/String;)Z

    move-result v14

    .line 365
    .local v14, "imageInfoSuccess":Z
    if-eqz v14, :cond_2

    .line 366
    move-object/from16 v0, p1

    move/from16 v1, v17

    invoke-static {v0, v4, v1, v12, v9}, Lcom/facebook/react/modules/camera/CameraRollManager;->putBasicNodeInfo(Landroid/database/Cursor;Lcom/facebook/react/bridge/WritableMap;III)V

    .line 367
    move-object/from16 v0, p1

    move/from16 v1, v16

    invoke-static {v0, v4, v1, v15}, Lcom/facebook/react/modules/camera/CameraRollManager;->putLocationInfo(Landroid/database/Cursor;Lcom/facebook/react/bridge/WritableMap;II)V

    .line 369
    const-string v2, "node"

    invoke-interface {v10, v2, v4}, Lcom/facebook/react/bridge/WritableMap;->putMap(Ljava/lang/String;Lcom/facebook/react/bridge/WritableMap;)V

    .line 370
    invoke-interface {v11, v10}, Lcom/facebook/react/bridge/WritableArray;->pushMap(Lcom/facebook/react/bridge/WritableMap;)V

    .line 376
    :goto_3
    invoke-interface/range {p1 .. p1}, Landroid/database/Cursor;->moveToNext()Z

    .line 360
    add-int/lit8 v13, v13, 0x1

    goto :goto_2

    .line 355
    .end local v4    # "node":Lcom/facebook/react/bridge/WritableMap;
    .end local v6    # "widthIndex":I
    .end local v7    # "heightIndex":I
    .end local v10    # "edge":Lcom/facebook/react/bridge/WritableMap;
    .end local v13    # "i":I
    .end local v14    # "imageInfoSuccess":Z
    .end local v15    # "latitudeIndex":I
    .end local v16    # "longitudeIndex":I
    :cond_0
    const/4 v6, -0x1

    goto :goto_0

    .line 356
    .restart local v6    # "widthIndex":I
    :cond_1
    const/4 v7, -0x1

    goto :goto_1

    .line 374
    .restart local v4    # "node":Lcom/facebook/react/bridge/WritableMap;
    .restart local v7    # "heightIndex":I
    .restart local v10    # "edge":Lcom/facebook/react/bridge/WritableMap;
    .restart local v13    # "i":I
    .restart local v14    # "imageInfoSuccess":Z
    .restart local v15    # "latitudeIndex":I
    .restart local v16    # "longitudeIndex":I
    :cond_2
    add-int/lit8 v13, v13, -0x1

    goto :goto_3

    .line 378
    .end local v4    # "node":Lcom/facebook/react/bridge/WritableMap;
    .end local v10    # "edge":Lcom/facebook/react/bridge/WritableMap;
    .end local v14    # "imageInfoSuccess":Z
    :cond_3
    const-string v2, "edges"

    move-object/from16 v0, p2

    invoke-interface {v0, v2, v11}, Lcom/facebook/react/bridge/WritableMap;->putArray(Ljava/lang/String;Lcom/facebook/react/bridge/WritableArray;)V

    .line 379
    return-void
.end method

.method private static putImageInfo(Landroid/content/ContentResolver;Landroid/database/Cursor;Lcom/facebook/react/bridge/WritableMap;IIILjava/lang/String;)Z
    .locals 16
    .param p0, "resolver"    # Landroid/content/ContentResolver;
    .param p1, "photos"    # Landroid/database/Cursor;
    .param p2, "node"    # Lcom/facebook/react/bridge/WritableMap;
    .param p3, "idIndex"    # I
    .param p4, "widthIndex"    # I
    .param p5, "heightIndex"    # I
    .param p6, "assetType"    # Ljava/lang/String;
        .annotation runtime Ljavax/annotation/Nullable;
        .end annotation
    .end param

    .prologue
    .line 400
    new-instance v4, Lcom/facebook/react/bridge/WritableNativeMap;

    invoke-direct {v4}, Lcom/facebook/react/bridge/WritableNativeMap;-><init>()V

    .line 402
    .local v4, "image":Lcom/facebook/react/bridge/WritableMap;
    if-eqz p6, :cond_6

    const-string v12, "Videos"

    move-object/from16 v0, p6

    invoke-virtual {v0, v12}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v12

    if-eqz v12, :cond_6

    .line 403
    sget-object v12, Landroid/provider/MediaStore$Video$Media;->EXTERNAL_CONTENT_URI:Landroid/net/Uri;

    move-object/from16 v0, p1

    move/from16 v1, p3

    invoke-interface {v0, v1}, Landroid/database/Cursor;->getString(I)Ljava/lang/String;

    move-result-object v13

    invoke-static {v12, v13}, Landroid/net/Uri;->withAppendedPath(Landroid/net/Uri;Ljava/lang/String;)Landroid/net/Uri;

    move-result-object v7

    .line 407
    .local v7, "photoUri":Landroid/net/Uri;
    :goto_0
    const-string v12, "uri"

    invoke-virtual {v7}, Landroid/net/Uri;->toString()Ljava/lang/String;

    move-result-object v13

    invoke-interface {v4, v12, v13}, Lcom/facebook/react/bridge/WritableMap;->putString(Ljava/lang/String;Ljava/lang/String;)V

    .line 408
    const/high16 v11, -0x40800000    # -1.0f

    .line 409
    .local v11, "width":F
    const/high16 v3, -0x40800000    # -1.0f

    .line 410
    .local v3, "height":F
    sget-boolean v12, Lcom/facebook/react/modules/camera/CameraRollManager;->IS_JELLY_BEAN_OR_LATER:Z

    if-eqz v12, :cond_0

    .line 411
    move-object/from16 v0, p1

    move/from16 v1, p4

    invoke-interface {v0, v1}, Landroid/database/Cursor;->getInt(I)I

    move-result v12

    int-to-float v11, v12

    .line 412
    move-object/from16 v0, p1

    move/from16 v1, p5

    invoke-interface {v0, v1}, Landroid/database/Cursor;->getInt(I)I

    move-result v12

    int-to-float v3, v12

    .line 415
    :cond_0
    if-eqz p6, :cond_3

    const-string v12, "Videos"

    .line 416
    move-object/from16 v0, p6

    invoke-virtual {v0, v12}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v12

    if-eqz v12, :cond_3

    sget v12, Landroid/os/Build$VERSION;->SDK_INT:I

    const/16 v13, 0xa

    if-lt v12, v13, :cond_3

    .line 419
    :try_start_0
    const-string v12, "r"

    move-object/from16 v0, p0

    invoke-virtual {v0, v7, v12}, Landroid/content/ContentResolver;->openAssetFileDescriptor(Landroid/net/Uri;Ljava/lang/String;)Landroid/content/res/AssetFileDescriptor;

    move-result-object v6

    .line 420
    .local v6, "photoDescriptor":Landroid/content/res/AssetFileDescriptor;
    new-instance v9, Landroid/media/MediaMetadataRetriever;

    invoke-direct {v9}, Landroid/media/MediaMetadataRetriever;-><init>()V

    .line 421
    .local v9, "retriever":Landroid/media/MediaMetadataRetriever;
    invoke-virtual {v6}, Landroid/content/res/AssetFileDescriptor;->getFileDescriptor()Ljava/io/FileDescriptor;

    move-result-object v12

    invoke-virtual {v9, v12}, Landroid/media/MediaMetadataRetriever;->setDataSource(Ljava/io/FileDescriptor;)V

    .line 423
    const/4 v12, 0x0

    cmpg-float v12, v11, v12

    if-lez v12, :cond_1

    const/4 v12, 0x0

    cmpg-float v12, v3, v12

    if-gtz v12, :cond_2

    .line 424
    :cond_1
    const/16 v12, 0x12

    .line 426
    invoke-virtual {v9, v12}, Landroid/media/MediaMetadataRetriever;->extractMetadata(I)Ljava/lang/String;

    move-result-object v12

    .line 425
    invoke-static {v12}, Ljava/lang/Integer;->parseInt(Ljava/lang/String;)I

    move-result v12

    int-to-float v11, v12

    .line 427
    const/16 v12, 0x13

    .line 429
    invoke-virtual {v9, v12}, Landroid/media/MediaMetadataRetriever;->extractMetadata(I)Ljava/lang/String;

    move-result-object v12

    .line 428
    invoke-static {v12}, Ljava/lang/Integer;->parseInt(Ljava/lang/String;)I

    move-result v12

    int-to-float v3, v12

    .line 431
    :cond_2
    const/16 v12, 0x9

    .line 433
    invoke-virtual {v9, v12}, Landroid/media/MediaMetadataRetriever;->extractMetadata(I)Ljava/lang/String;

    move-result-object v12

    .line 432
    invoke-static {v12}, Ljava/lang/Integer;->parseInt(Ljava/lang/String;)I

    move-result v10

    .line 434
    .local v10, "timeInMillisec":I
    div-int/lit16 v8, v10, 0x3e8

    .line 435
    .local v8, "playableDuration":I
    const-string v12, "playableDuration"

    invoke-interface {v4, v12, v8}, Lcom/facebook/react/bridge/WritableMap;->putInt(Ljava/lang/String;I)V

    .line 436
    invoke-virtual {v9}, Landroid/media/MediaMetadataRetriever;->release()V

    .line 437
    invoke-virtual {v6}, Landroid/content/res/AssetFileDescriptor;->close()V
    :try_end_0
    .catch Ljava/io/IOException; {:try_start_0 .. :try_end_0} :catch_0

    .line 444
    .end local v6    # "photoDescriptor":Landroid/content/res/AssetFileDescriptor;
    .end local v8    # "playableDuration":I
    .end local v9    # "retriever":Landroid/media/MediaMetadataRetriever;
    .end local v10    # "timeInMillisec":I
    :cond_3
    const/4 v12, 0x0

    cmpg-float v12, v11, v12

    if-lez v12, :cond_4

    const/4 v12, 0x0

    cmpg-float v12, v3, v12

    if-gtz v12, :cond_5

    .line 446
    :cond_4
    :try_start_1
    const-string v12, "r"

    move-object/from16 v0, p0

    invoke-virtual {v0, v7, v12}, Landroid/content/ContentResolver;->openAssetFileDescriptor(Landroid/net/Uri;Ljava/lang/String;)Landroid/content/res/AssetFileDescriptor;

    move-result-object v6

    .line 447
    .restart local v6    # "photoDescriptor":Landroid/content/res/AssetFileDescriptor;
    new-instance v5, Landroid/graphics/BitmapFactory$Options;

    invoke-direct {v5}, Landroid/graphics/BitmapFactory$Options;-><init>()V

    .line 450
    .local v5, "options":Landroid/graphics/BitmapFactory$Options;
    const/4 v12, 0x1

    iput-boolean v12, v5, Landroid/graphics/BitmapFactory$Options;->inJustDecodeBounds:Z

    .line 451
    invoke-virtual {v6}, Landroid/content/res/AssetFileDescriptor;->getFileDescriptor()Ljava/io/FileDescriptor;

    move-result-object v12

    const/4 v13, 0x0

    invoke-static {v12, v13, v5}, Landroid/graphics/BitmapFactory;->decodeFileDescriptor(Ljava/io/FileDescriptor;Landroid/graphics/Rect;Landroid/graphics/BitmapFactory$Options;)Landroid/graphics/Bitmap;

    .line 452
    iget v12, v5, Landroid/graphics/BitmapFactory$Options;->outWidth:I

    int-to-float v11, v12

    .line 453
    iget v12, v5, Landroid/graphics/BitmapFactory$Options;->outHeight:I

    int-to-float v3, v12

    .line 454
    invoke-virtual {v6}, Landroid/content/res/AssetFileDescriptor;->close()V
    :try_end_1
    .catch Ljava/io/IOException; {:try_start_1 .. :try_end_1} :catch_1

    .line 460
    .end local v5    # "options":Landroid/graphics/BitmapFactory$Options;
    .end local v6    # "photoDescriptor":Landroid/content/res/AssetFileDescriptor;
    :cond_5
    const-string v12, "width"

    float-to-double v14, v11

    invoke-interface {v4, v12, v14, v15}, Lcom/facebook/react/bridge/WritableMap;->putDouble(Ljava/lang/String;D)V

    .line 461
    const-string v12, "height"

    float-to-double v14, v3

    invoke-interface {v4, v12, v14, v15}, Lcom/facebook/react/bridge/WritableMap;->putDouble(Ljava/lang/String;D)V

    .line 462
    const-string v12, "image"

    move-object/from16 v0, p2

    invoke-interface {v0, v12, v4}, Lcom/facebook/react/bridge/WritableMap;->putMap(Ljava/lang/String;Lcom/facebook/react/bridge/WritableMap;)V

    .line 463
    const/4 v12, 0x1

    :goto_1
    return v12

    .line 405
    .end local v3    # "height":F
    .end local v7    # "photoUri":Landroid/net/Uri;
    .end local v11    # "width":F
    :cond_6
    sget-object v12, Landroid/provider/MediaStore$Images$Media;->EXTERNAL_CONTENT_URI:Landroid/net/Uri;

    move-object/from16 v0, p1

    move/from16 v1, p3

    invoke-interface {v0, v1}, Landroid/database/Cursor;->getString(I)Ljava/lang/String;

    move-result-object v13

    invoke-static {v12, v13}, Landroid/net/Uri;->withAppendedPath(Landroid/net/Uri;Ljava/lang/String;)Landroid/net/Uri;

    move-result-object v7

    .restart local v7    # "photoUri":Landroid/net/Uri;
    goto/16 :goto_0

    .line 438
    .restart local v3    # "height":F
    .restart local v11    # "width":F
    :catch_0
    move-exception v2

    .line 439
    .local v2, "e":Ljava/io/IOException;
    const-string v12, "ReactNative"

    new-instance v13, Ljava/lang/StringBuilder;

    invoke-direct {v13}, Ljava/lang/StringBuilder;-><init>()V

    const-string v14, "Could not get video metadata for "

    invoke-virtual {v13, v14}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v13

    invoke-virtual {v7}, Landroid/net/Uri;->toString()Ljava/lang/String;

    move-result-object v14

    invoke-virtual {v13, v14}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v13

    invoke-virtual {v13}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v13

    invoke-static {v12, v13, v2}, Lcom/facebook/common/logging/FLog;->e(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V

    .line 440
    const/4 v12, 0x0

    goto :goto_1

    .line 455
    .end local v2    # "e":Ljava/io/IOException;
    :catch_1
    move-exception v2

    .line 456
    .restart local v2    # "e":Ljava/io/IOException;
    const-string v12, "ReactNative"

    new-instance v13, Ljava/lang/StringBuilder;

    invoke-direct {v13}, Ljava/lang/StringBuilder;-><init>()V

    const-string v14, "Could not get width/height for "

    invoke-virtual {v13, v14}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v13

    invoke-virtual {v7}, Landroid/net/Uri;->toString()Ljava/lang/String;

    move-result-object v14

    invoke-virtual {v13, v14}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v13

    invoke-virtual {v13}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v13

    invoke-static {v12, v13, v2}, Lcom/facebook/common/logging/FLog;->e(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V

    .line 457
    const/4 v12, 0x0

    goto :goto_1
.end method

.method private static putLocationInfo(Landroid/database/Cursor;Lcom/facebook/react/bridge/WritableMap;II)V
    .locals 8
    .param p0, "photos"    # Landroid/database/Cursor;
    .param p1, "node"    # Lcom/facebook/react/bridge/WritableMap;
    .param p2, "longitudeIndex"    # I
    .param p3, "latitudeIndex"    # I

    .prologue
    const-wide/16 v6, 0x0

    .line 471
    invoke-interface {p0, p2}, Landroid/database/Cursor;->getDouble(I)D

    move-result-wide v4

    .line 472
    .local v4, "longitude":D
    invoke-interface {p0, p3}, Landroid/database/Cursor;->getDouble(I)D

    move-result-wide v0

    .line 473
    .local v0, "latitude":D
    cmpl-double v3, v4, v6

    if-gtz v3, :cond_0

    cmpl-double v3, v0, v6

    if-lez v3, :cond_1

    .line 474
    :cond_0
    new-instance v2, Lcom/facebook/react/bridge/WritableNativeMap;

    invoke-direct {v2}, Lcom/facebook/react/bridge/WritableNativeMap;-><init>()V

    .line 475
    .local v2, "location":Lcom/facebook/react/bridge/WritableMap;
    const-string v3, "longitude"

    invoke-interface {v2, v3, v4, v5}, Lcom/facebook/react/bridge/WritableMap;->putDouble(Ljava/lang/String;D)V

    .line 476
    const-string v3, "latitude"

    invoke-interface {v2, v3, v0, v1}, Lcom/facebook/react/bridge/WritableMap;->putDouble(Ljava/lang/String;D)V

    .line 477
    const-string v3, "location"

    invoke-interface {p1, v3, v2}, Lcom/facebook/react/bridge/WritableMap;->putMap(Ljava/lang/String;Lcom/facebook/react/bridge/WritableMap;)V

    .line 479
    .end local v2    # "location":Lcom/facebook/react/bridge/WritableMap;
    :cond_1
    return-void
.end method

.method private static putPageInfo(Landroid/database/Cursor;Lcom/facebook/react/bridge/WritableMap;I)V
    .locals 3
    .param p0, "photos"    # Landroid/database/Cursor;
    .param p1, "response"    # Lcom/facebook/react/bridge/WritableMap;
    .param p2, "limit"    # I

    .prologue
    .line 332
    new-instance v0, Lcom/facebook/react/bridge/WritableNativeMap;

    invoke-direct {v0}, Lcom/facebook/react/bridge/WritableNativeMap;-><init>()V

    .line 333
    .local v0, "pageInfo":Lcom/facebook/react/bridge/WritableMap;
    const-string v2, "has_next_page"

    invoke-interface {p0}, Landroid/database/Cursor;->getCount()I

    move-result v1

    if-ge p2, v1, :cond_1

    const/4 v1, 0x1

    :goto_0
    invoke-interface {v0, v2, v1}, Lcom/facebook/react/bridge/WritableMap;->putBoolean(Ljava/lang/String;Z)V

    .line 334
    invoke-interface {p0}, Landroid/database/Cursor;->getCount()I

    move-result v1

    if-ge p2, v1, :cond_0

    .line 335
    add-int/lit8 v1, p2, -0x1

    invoke-interface {p0, v1}, Landroid/database/Cursor;->moveToPosition(I)Z

    .line 336
    const-string v1, "end_cursor"

    const-string v2, "datetaken"

    .line 338
    invoke-interface {p0, v2}, Landroid/database/Cursor;->getColumnIndex(Ljava/lang/String;)I

    move-result v2

    invoke-interface {p0, v2}, Landroid/database/Cursor;->getString(I)Ljava/lang/String;

    move-result-object v2

    .line 336
    invoke-interface {v0, v1, v2}, Lcom/facebook/react/bridge/WritableMap;->putString(Ljava/lang/String;Ljava/lang/String;)V

    .line 340
    :cond_0
    const-string v1, "page_info"

    invoke-interface {p1, v1, v0}, Lcom/facebook/react/bridge/WritableMap;->putMap(Ljava/lang/String;Lcom/facebook/react/bridge/WritableMap;)V

    .line 341
    return-void

    .line 333
    :cond_1
    const/4 v1, 0x0

    goto :goto_0
.end method


# virtual methods
.method public getName()Ljava/lang/String;
    .locals 1

    .prologue
    .line 104
    const-string v0, "CameraRollManager"

    return-object v0
.end method

.method public getPhotos(Lcom/facebook/react/bridge/ReadableMap;Lcom/facebook/react/bridge/Promise;)V
    .locals 9
    .param p1, "params"    # Lcom/facebook/react/bridge/ReadableMap;
    .param p2, "promise"    # Lcom/facebook/react/bridge/Promise;
    .annotation runtime Lcom/facebook/react/bridge/ReactMethod;
    .end annotation

    .prologue
    const/4 v8, 0x0

    .line 225
    const-string v0, "first"

    invoke-interface {p1, v0}, Lcom/facebook/react/bridge/ReadableMap;->getInt(Ljava/lang/String;)I

    move-result v2

    .line 226
    .local v2, "first":I
    const-string v0, "after"

    invoke-interface {p1, v0}, Lcom/facebook/react/bridge/ReadableMap;->hasKey(Ljava/lang/String;)Z

    move-result v0

    if-eqz v0, :cond_0

    const-string v0, "after"

    invoke-interface {p1, v0}, Lcom/facebook/react/bridge/ReadableMap;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v3

    .line 227
    .local v3, "after":Ljava/lang/String;
    :goto_0
    const-string v0, "groupName"

    invoke-interface {p1, v0}, Lcom/facebook/react/bridge/ReadableMap;->hasKey(Ljava/lang/String;)Z

    move-result v0

    if-eqz v0, :cond_1

    const-string v0, "groupName"

    invoke-interface {p1, v0}, Lcom/facebook/react/bridge/ReadableMap;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v4

    .line 228
    .local v4, "groupName":Ljava/lang/String;
    :goto_1
    const-string v0, "assetType"

    invoke-interface {p1, v0}, Lcom/facebook/react/bridge/ReadableMap;->hasKey(Ljava/lang/String;)Z

    move-result v0

    if-eqz v0, :cond_2

    const-string v0, "assetType"

    invoke-interface {p1, v0}, Lcom/facebook/react/bridge/ReadableMap;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v6

    .line 229
    .local v6, "assetType":Ljava/lang/String;
    :goto_2
    const-string v0, "mimeTypes"

    invoke-interface {p1, v0}, Lcom/facebook/react/bridge/ReadableMap;->hasKey(Ljava/lang/String;)Z

    move-result v0

    if-eqz v0, :cond_3

    const-string v0, "mimeTypes"

    .line 230
    invoke-interface {p1, v0}, Lcom/facebook/react/bridge/ReadableMap;->getArray(Ljava/lang/String;)Lcom/facebook/react/bridge/ReadableArray;

    move-result-object v5

    .line 232
    .local v5, "mimeTypes":Lcom/facebook/react/bridge/ReadableArray;
    :goto_3
    const-string v0, "groupTypes"

    invoke-interface {p1, v0}, Lcom/facebook/react/bridge/ReadableMap;->hasKey(Ljava/lang/String;)Z

    move-result v0

    if-eqz v0, :cond_4

    .line 233
    new-instance v0, Lcom/facebook/react/bridge/JSApplicationIllegalArgumentException;

    const-string v1, "groupTypes is not supported on Android"

    invoke-direct {v0, v1}, Lcom/facebook/react/bridge/JSApplicationIllegalArgumentException;-><init>(Ljava/lang/String;)V

    throw v0

    .end local v3    # "after":Ljava/lang/String;
    .end local v4    # "groupName":Ljava/lang/String;
    .end local v5    # "mimeTypes":Lcom/facebook/react/bridge/ReadableArray;
    .end local v6    # "assetType":Ljava/lang/String;
    :cond_0
    move-object v3, v8

    .line 226
    goto :goto_0

    .restart local v3    # "after":Ljava/lang/String;
    :cond_1
    move-object v4, v8

    .line 227
    goto :goto_1

    .restart local v4    # "groupName":Ljava/lang/String;
    :cond_2
    move-object v6, v8

    .line 228
    goto :goto_2

    .restart local v6    # "assetType":Ljava/lang/String;
    :cond_3
    move-object v5, v8

    .line 230
    goto :goto_3

    .line 236
    .restart local v5    # "mimeTypes":Lcom/facebook/react/bridge/ReadableArray;
    :cond_4
    new-instance v0, Lcom/facebook/react/modules/camera/CameraRollManager$GetPhotosTask;

    .line 237
    invoke-virtual {p0}, Lcom/facebook/react/modules/camera/CameraRollManager;->getReactApplicationContext()Lcom/facebook/react/bridge/ReactApplicationContext;

    move-result-object v1

    move-object v7, p2

    invoke-direct/range {v0 .. v8}, Lcom/facebook/react/modules/camera/CameraRollManager$GetPhotosTask;-><init>(Lcom/facebook/react/bridge/ReactContext;ILjava/lang/String;Ljava/lang/String;Lcom/facebook/react/bridge/ReadableArray;Ljava/lang/String;Lcom/facebook/react/bridge/Promise;Lcom/facebook/react/modules/camera/CameraRollManager$1;)V

    sget-object v1, Landroid/os/AsyncTask;->THREAD_POOL_EXECUTOR:Ljava/util/concurrent/Executor;

    const/4 v7, 0x0

    new-array v7, v7, [Ljava/lang/Void;

    .line 244
    invoke-virtual {v0, v1, v7}, Lcom/facebook/react/modules/camera/CameraRollManager$GetPhotosTask;->executeOnExecutor(Ljava/util/concurrent/Executor;[Ljava/lang/Object;)Landroid/os/AsyncTask;

    .line 245
    return-void
.end method

.method public saveToCameraRoll(Ljava/lang/String;Ljava/lang/String;Lcom/facebook/react/bridge/Promise;)V
    .locals 3
    .param p1, "uri"    # Ljava/lang/String;
    .param p2, "type"    # Ljava/lang/String;
    .param p3, "promise"    # Lcom/facebook/react/bridge/Promise;
    .annotation runtime Lcom/facebook/react/bridge/ReactMethod;
    .end annotation

    .prologue
    .line 117
    new-instance v0, Lcom/facebook/react/modules/camera/CameraRollManager$SaveToCameraRoll;

    invoke-virtual {p0}, Lcom/facebook/react/modules/camera/CameraRollManager;->getReactApplicationContext()Lcom/facebook/react/bridge/ReactApplicationContext;

    move-result-object v1

    invoke-static {p1}, Landroid/net/Uri;->parse(Ljava/lang/String;)Landroid/net/Uri;

    move-result-object v2

    invoke-direct {v0, v1, v2, p3}, Lcom/facebook/react/modules/camera/CameraRollManager$SaveToCameraRoll;-><init>(Lcom/facebook/react/bridge/ReactContext;Landroid/net/Uri;Lcom/facebook/react/bridge/Promise;)V

    sget-object v1, Landroid/os/AsyncTask;->THREAD_POOL_EXECUTOR:Ljava/util/concurrent/Executor;

    const/4 v2, 0x0

    new-array v2, v2, [Ljava/lang/Void;

    .line 118
    invoke-virtual {v0, v1, v2}, Lcom/facebook/react/modules/camera/CameraRollManager$SaveToCameraRoll;->executeOnExecutor(Ljava/util/concurrent/Executor;[Ljava/lang/Object;)Landroid/os/AsyncTask;

    .line 119
    return-void
.end method

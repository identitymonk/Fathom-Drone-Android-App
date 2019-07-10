.class Lcom/facebook/react/modules/camera/CameraRollManager$GetPhotosTask;
.super Lcom/facebook/react/bridge/GuardedAsyncTask;
.source "CameraRollManager.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/facebook/react/modules/camera/CameraRollManager;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0xa
    name = "GetPhotosTask"
.end annotation

.annotation system Ldalvik/annotation/Signature;
    value = {
        "Lcom/facebook/react/bridge/GuardedAsyncTask",
        "<",
        "Ljava/lang/Void;",
        "Ljava/lang/Void;",
        ">;"
    }
.end annotation


# instance fields
.field private final mAfter:Ljava/lang/String;
    .annotation runtime Ljavax/annotation/Nullable;
    .end annotation
.end field

.field private final mAssetType:Ljava/lang/String;
    .annotation runtime Ljavax/annotation/Nullable;
    .end annotation
.end field

.field private final mContext:Landroid/content/Context;

.field private final mFirst:I

.field private final mGroupName:Ljava/lang/String;
    .annotation runtime Ljavax/annotation/Nullable;
    .end annotation
.end field

.field private final mMimeTypes:Lcom/facebook/react/bridge/ReadableArray;
    .annotation runtime Ljavax/annotation/Nullable;
    .end annotation
.end field

.field private final mPromise:Lcom/facebook/react/bridge/Promise;


# direct methods
.method private constructor <init>(Lcom/facebook/react/bridge/ReactContext;ILjava/lang/String;Ljava/lang/String;Lcom/facebook/react/bridge/ReadableArray;Ljava/lang/String;Lcom/facebook/react/bridge/Promise;)V
    .locals 0
    .param p1, "context"    # Lcom/facebook/react/bridge/ReactContext;
    .param p2, "first"    # I
    .param p3, "after"    # Ljava/lang/String;
        .annotation runtime Ljavax/annotation/Nullable;
        .end annotation
    .end param
    .param p4, "groupName"    # Ljava/lang/String;
        .annotation runtime Ljavax/annotation/Nullable;
        .end annotation
    .end param
    .param p5, "mimeTypes"    # Lcom/facebook/react/bridge/ReadableArray;
        .annotation runtime Ljavax/annotation/Nullable;
        .end annotation
    .end param
    .param p6, "assetType"    # Ljava/lang/String;
        .annotation runtime Ljavax/annotation/Nullable;
        .end annotation
    .end param
    .param p7, "promise"    # Lcom/facebook/react/bridge/Promise;

    .prologue
    .line 264
    invoke-direct {p0, p1}, Lcom/facebook/react/bridge/GuardedAsyncTask;-><init>(Lcom/facebook/react/bridge/ReactContext;)V

    .line 265
    iput-object p1, p0, Lcom/facebook/react/modules/camera/CameraRollManager$GetPhotosTask;->mContext:Landroid/content/Context;

    .line 266
    iput p2, p0, Lcom/facebook/react/modules/camera/CameraRollManager$GetPhotosTask;->mFirst:I

    .line 267
    iput-object p3, p0, Lcom/facebook/react/modules/camera/CameraRollManager$GetPhotosTask;->mAfter:Ljava/lang/String;

    .line 268
    iput-object p4, p0, Lcom/facebook/react/modules/camera/CameraRollManager$GetPhotosTask;->mGroupName:Ljava/lang/String;

    .line 269
    iput-object p5, p0, Lcom/facebook/react/modules/camera/CameraRollManager$GetPhotosTask;->mMimeTypes:Lcom/facebook/react/bridge/ReadableArray;

    .line 270
    iput-object p7, p0, Lcom/facebook/react/modules/camera/CameraRollManager$GetPhotosTask;->mPromise:Lcom/facebook/react/bridge/Promise;

    .line 271
    iput-object p6, p0, Lcom/facebook/react/modules/camera/CameraRollManager$GetPhotosTask;->mAssetType:Ljava/lang/String;

    .line 272
    return-void
.end method

.method synthetic constructor <init>(Lcom/facebook/react/bridge/ReactContext;ILjava/lang/String;Ljava/lang/String;Lcom/facebook/react/bridge/ReadableArray;Ljava/lang/String;Lcom/facebook/react/bridge/Promise;Lcom/facebook/react/modules/camera/CameraRollManager$1;)V
    .locals 0
    .param p1, "x0"    # Lcom/facebook/react/bridge/ReactContext;
    .param p2, "x1"    # I
    .param p3, "x2"    # Ljava/lang/String;
    .param p4, "x3"    # Ljava/lang/String;
    .param p5, "x4"    # Lcom/facebook/react/bridge/ReadableArray;
    .param p6, "x5"    # Ljava/lang/String;
    .param p7, "x6"    # Lcom/facebook/react/bridge/Promise;
    .param p8, "x7"    # Lcom/facebook/react/modules/camera/CameraRollManager$1;

    .prologue
    .line 247
    invoke-direct/range {p0 .. p7}, Lcom/facebook/react/modules/camera/CameraRollManager$GetPhotosTask;-><init>(Lcom/facebook/react/bridge/ReactContext;ILjava/lang/String;Ljava/lang/String;Lcom/facebook/react/bridge/ReadableArray;Ljava/lang/String;Lcom/facebook/react/bridge/Promise;)V

    return-void
.end method


# virtual methods
.method protected bridge synthetic doInBackgroundGuarded([Ljava/lang/Object;)V
    .locals 0

    .prologue
    .line 247
    check-cast p1, [Ljava/lang/Void;

    invoke-virtual {p0, p1}, Lcom/facebook/react/modules/camera/CameraRollManager$GetPhotosTask;->doInBackgroundGuarded([Ljava/lang/Void;)V

    return-void
.end method

.method protected varargs doInBackgroundGuarded([Ljava/lang/Void;)V
    .locals 13
    .param p1, "params"    # [Ljava/lang/Void;

    .prologue
    .line 276
    new-instance v10, Ljava/lang/StringBuilder;

    const-string v2, "1"

    invoke-direct {v10, v2}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    .line 277
    .local v10, "selection":Ljava/lang/StringBuilder;
    new-instance v11, Ljava/util/ArrayList;

    invoke-direct {v11}, Ljava/util/ArrayList;-><init>()V

    .line 278
    .local v11, "selectionArgs":Ljava/util/List;, "Ljava/util/List<Ljava/lang/String;>;"
    iget-object v2, p0, Lcom/facebook/react/modules/camera/CameraRollManager$GetPhotosTask;->mAfter:Ljava/lang/String;

    invoke-static {v2}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result v2

    if-nez v2, :cond_0

    .line 279
    const-string v2, " AND datetaken < ?"

    invoke-virtual {v10, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    .line 280
    iget-object v2, p0, Lcom/facebook/react/modules/camera/CameraRollManager$GetPhotosTask;->mAfter:Ljava/lang/String;

    invoke-interface {v11, v2}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    .line 282
    :cond_0
    iget-object v2, p0, Lcom/facebook/react/modules/camera/CameraRollManager$GetPhotosTask;->mGroupName:Ljava/lang/String;

    invoke-static {v2}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result v2

    if-nez v2, :cond_1

    .line 283
    const-string v2, " AND bucket_display_name = ?"

    invoke-virtual {v10, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    .line 284
    iget-object v2, p0, Lcom/facebook/react/modules/camera/CameraRollManager$GetPhotosTask;->mGroupName:Ljava/lang/String;

    invoke-interface {v11, v2}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    .line 286
    :cond_1
    iget-object v2, p0, Lcom/facebook/react/modules/camera/CameraRollManager$GetPhotosTask;->mMimeTypes:Lcom/facebook/react/bridge/ReadableArray;

    if-eqz v2, :cond_3

    iget-object v2, p0, Lcom/facebook/react/modules/camera/CameraRollManager$GetPhotosTask;->mMimeTypes:Lcom/facebook/react/bridge/ReadableArray;

    invoke-interface {v2}, Lcom/facebook/react/bridge/ReadableArray;->size()I

    move-result v2

    if-lez v2, :cond_3

    .line 287
    const-string v2, " AND mime_type IN ("

    invoke-virtual {v10, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    .line 288
    const/4 v7, 0x0

    .local v7, "i":I
    :goto_0
    iget-object v2, p0, Lcom/facebook/react/modules/camera/CameraRollManager$GetPhotosTask;->mMimeTypes:Lcom/facebook/react/bridge/ReadableArray;

    invoke-interface {v2}, Lcom/facebook/react/bridge/ReadableArray;->size()I

    move-result v2

    if-ge v7, v2, :cond_2

    .line 289
    const-string v2, "?,"

    invoke-virtual {v10, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    .line 290
    iget-object v2, p0, Lcom/facebook/react/modules/camera/CameraRollManager$GetPhotosTask;->mMimeTypes:Lcom/facebook/react/bridge/ReadableArray;

    invoke-interface {v2, v7}, Lcom/facebook/react/bridge/ReadableArray;->getString(I)Ljava/lang/String;

    move-result-object v2

    invoke-interface {v11, v2}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    .line 288
    add-int/lit8 v7, v7, 0x1

    goto :goto_0

    .line 292
    :cond_2
    invoke-virtual {v10}, Ljava/lang/StringBuilder;->length()I

    move-result v2

    add-int/lit8 v2, v2, -0x1

    invoke-virtual {v10}, Ljava/lang/StringBuilder;->length()I

    move-result v3

    const-string v4, ")"

    invoke-virtual {v10, v2, v3, v4}, Ljava/lang/StringBuilder;->replace(IILjava/lang/String;)Ljava/lang/StringBuilder;

    .line 294
    .end local v7    # "i":I
    :cond_3
    new-instance v9, Lcom/facebook/react/bridge/WritableNativeMap;

    invoke-direct {v9}, Lcom/facebook/react/bridge/WritableNativeMap;-><init>()V

    .line 295
    .local v9, "response":Lcom/facebook/react/bridge/WritableMap;
    iget-object v2, p0, Lcom/facebook/react/modules/camera/CameraRollManager$GetPhotosTask;->mContext:Landroid/content/Context;

    invoke-virtual {v2}, Landroid/content/Context;->getContentResolver()Landroid/content/ContentResolver;

    move-result-object v0

    .line 300
    .local v0, "resolver":Landroid/content/ContentResolver;
    :try_start_0
    iget-object v2, p0, Lcom/facebook/react/modules/camera/CameraRollManager$GetPhotosTask;->mAssetType:Ljava/lang/String;

    if-eqz v2, :cond_4

    iget-object v2, p0, Lcom/facebook/react/modules/camera/CameraRollManager$GetPhotosTask;->mAssetType:Ljava/lang/String;

    const-string v3, "Videos"

    .line 301
    invoke-virtual {v2, v3}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v2

    if-eqz v2, :cond_4

    sget-object v1, Landroid/provider/MediaStore$Video$Media;->EXTERNAL_CONTENT_URI:Landroid/net/Uri;

    .line 306
    .local v1, "assetURI":Landroid/net/Uri;
    :goto_1
    invoke-static {}, Lcom/facebook/react/modules/camera/CameraRollManager;->access$200()[Ljava/lang/String;

    move-result-object v2

    .line 307
    invoke-virtual {v10}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v3

    .line 308
    invoke-interface {v11}, Ljava/util/List;->size()I

    move-result v4

    new-array v4, v4, [Ljava/lang/String;

    invoke-interface {v11, v4}, Ljava/util/List;->toArray([Ljava/lang/Object;)[Ljava/lang/Object;

    move-result-object v4

    check-cast v4, [Ljava/lang/String;

    new-instance v5, Ljava/lang/StringBuilder;

    invoke-direct {v5}, Ljava/lang/StringBuilder;-><init>()V

    const-string v12, "datetaken DESC, date_modified DESC LIMIT "

    invoke-virtual {v5, v12}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v5

    iget v12, p0, Lcom/facebook/react/modules/camera/CameraRollManager$GetPhotosTask;->mFirst:I

    add-int/lit8 v12, v12, 0x1

    invoke-virtual {v5, v12}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v5

    invoke-virtual {v5}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v5

    .line 304
    invoke-virtual/range {v0 .. v5}, Landroid/content/ContentResolver;->query(Landroid/net/Uri;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;

    move-result-object v8

    .line 311
    .local v8, "photos":Landroid/database/Cursor;
    if-nez v8, :cond_5

    .line 312
    iget-object v2, p0, Lcom/facebook/react/modules/camera/CameraRollManager$GetPhotosTask;->mPromise:Lcom/facebook/react/bridge/Promise;

    const-string v3, "E_UNABLE_TO_LOAD"

    const-string v4, "Could not get photos"

    invoke-interface {v2, v3, v4}, Lcom/facebook/react/bridge/Promise;->reject(Ljava/lang/String;Ljava/lang/String;)V

    .line 328
    .end local v1    # "assetURI":Landroid/net/Uri;
    .end local v8    # "photos":Landroid/database/Cursor;
    :goto_2
    return-void

    .line 301
    :cond_4
    sget-object v1, Landroid/provider/MediaStore$Images$Media;->EXTERNAL_CONTENT_URI:Landroid/net/Uri;
    :try_end_0
    .catch Ljava/lang/SecurityException; {:try_start_0 .. :try_end_0} :catch_0

    goto :goto_1

    .line 315
    .restart local v1    # "assetURI":Landroid/net/Uri;
    .restart local v8    # "photos":Landroid/database/Cursor;
    :cond_5
    :try_start_1
    iget v2, p0, Lcom/facebook/react/modules/camera/CameraRollManager$GetPhotosTask;->mFirst:I

    iget-object v3, p0, Lcom/facebook/react/modules/camera/CameraRollManager$GetPhotosTask;->mAssetType:Ljava/lang/String;

    invoke-static {v0, v8, v9, v2, v3}, Lcom/facebook/react/modules/camera/CameraRollManager;->access$300(Landroid/content/ContentResolver;Landroid/database/Cursor;Lcom/facebook/react/bridge/WritableMap;ILjava/lang/String;)V

    .line 316
    iget v2, p0, Lcom/facebook/react/modules/camera/CameraRollManager$GetPhotosTask;->mFirst:I

    invoke-static {v8, v9, v2}, Lcom/facebook/react/modules/camera/CameraRollManager;->access$400(Landroid/database/Cursor;Lcom/facebook/react/bridge/WritableMap;I)V
    :try_end_1
    .catchall {:try_start_1 .. :try_end_1} :catchall_0

    .line 318
    :try_start_2
    invoke-interface {v8}, Landroid/database/Cursor;->close()V

    .line 319
    iget-object v2, p0, Lcom/facebook/react/modules/camera/CameraRollManager$GetPhotosTask;->mPromise:Lcom/facebook/react/bridge/Promise;

    invoke-interface {v2, v9}, Lcom/facebook/react/bridge/Promise;->resolve(Ljava/lang/Object;)V
    :try_end_2
    .catch Ljava/lang/SecurityException; {:try_start_2 .. :try_end_2} :catch_0

    goto :goto_2

    .line 322
    .end local v1    # "assetURI":Landroid/net/Uri;
    .end local v8    # "photos":Landroid/database/Cursor;
    :catch_0
    move-exception v6

    .line 323
    .local v6, "e":Ljava/lang/SecurityException;
    iget-object v2, p0, Lcom/facebook/react/modules/camera/CameraRollManager$GetPhotosTask;->mPromise:Lcom/facebook/react/bridge/Promise;

    const-string v3, "E_UNABLE_TO_LOAD_PERMISSION"

    const-string v4, "Could not get photos: need READ_EXTERNAL_STORAGE permission"

    invoke-interface {v2, v3, v4, v6}, Lcom/facebook/react/bridge/Promise;->reject(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V

    goto :goto_2

    .line 318
    .end local v6    # "e":Ljava/lang/SecurityException;
    .restart local v1    # "assetURI":Landroid/net/Uri;
    .restart local v8    # "photos":Landroid/database/Cursor;
    :catchall_0
    move-exception v2

    :try_start_3
    invoke-interface {v8}, Landroid/database/Cursor;->close()V

    .line 319
    iget-object v3, p0, Lcom/facebook/react/modules/camera/CameraRollManager$GetPhotosTask;->mPromise:Lcom/facebook/react/bridge/Promise;

    invoke-interface {v3, v9}, Lcom/facebook/react/bridge/Promise;->resolve(Ljava/lang/Object;)V

    throw v2
    :try_end_3
    .catch Ljava/lang/SecurityException; {:try_start_3 .. :try_end_3} :catch_0
.end method

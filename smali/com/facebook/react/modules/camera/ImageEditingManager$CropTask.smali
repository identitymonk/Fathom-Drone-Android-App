.class Lcom/facebook/react/modules/camera/ImageEditingManager$CropTask;
.super Lcom/facebook/react/bridge/GuardedAsyncTask;
.source "ImageEditingManager.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/facebook/react/modules/camera/ImageEditingManager;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0xa
    name = "CropTask"
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
.field final mContext:Landroid/content/Context;

.field final mError:Lcom/facebook/react/bridge/Callback;

.field final mHeight:I

.field final mSuccess:Lcom/facebook/react/bridge/Callback;

.field mTargetHeight:I

.field mTargetWidth:I

.field final mUri:Ljava/lang/String;

.field final mWidth:I

.field final mX:I

.field final mY:I


# direct methods
.method private constructor <init>(Lcom/facebook/react/bridge/ReactContext;Ljava/lang/String;IIIILcom/facebook/react/bridge/Callback;Lcom/facebook/react/bridge/Callback;)V
    .locals 5
    .param p1, "context"    # Lcom/facebook/react/bridge/ReactContext;
    .param p2, "uri"    # Ljava/lang/String;
    .param p3, "x"    # I
    .param p4, "y"    # I
    .param p5, "width"    # I
    .param p6, "height"    # I
    .param p7, "success"    # Lcom/facebook/react/bridge/Callback;
    .param p8, "error"    # Lcom/facebook/react/bridge/Callback;

    .prologue
    const/4 v4, 0x0

    .line 226
    invoke-direct {p0, p1}, Lcom/facebook/react/bridge/GuardedAsyncTask;-><init>(Lcom/facebook/react/bridge/ReactContext;)V

    .line 212
    iput v4, p0, Lcom/facebook/react/modules/camera/ImageEditingManager$CropTask;->mTargetWidth:I

    .line 213
    iput v4, p0, Lcom/facebook/react/modules/camera/ImageEditingManager$CropTask;->mTargetHeight:I

    .line 227
    if-ltz p3, :cond_0

    if-ltz p4, :cond_0

    if-lez p5, :cond_0

    if-gtz p6, :cond_1

    .line 228
    :cond_0
    new-instance v0, Lcom/facebook/react/bridge/JSApplicationIllegalArgumentException;

    const-string v1, "Invalid crop rectangle: [%d, %d, %d, %d]"

    const/4 v2, 0x4

    new-array v2, v2, [Ljava/lang/Object;

    .line 229
    invoke-static {p3}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v3

    aput-object v3, v2, v4

    const/4 v3, 0x1

    invoke-static {p4}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v4

    aput-object v4, v2, v3

    const/4 v3, 0x2

    invoke-static {p5}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v4

    aput-object v4, v2, v3

    const/4 v3, 0x3

    invoke-static {p6}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v4

    aput-object v4, v2, v3

    .line 228
    invoke-static {v1, v2}, Ljava/lang/String;->format(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v1

    invoke-direct {v0, v1}, Lcom/facebook/react/bridge/JSApplicationIllegalArgumentException;-><init>(Ljava/lang/String;)V

    throw v0

    .line 231
    :cond_1
    iput-object p1, p0, Lcom/facebook/react/modules/camera/ImageEditingManager$CropTask;->mContext:Landroid/content/Context;

    .line 232
    iput-object p2, p0, Lcom/facebook/react/modules/camera/ImageEditingManager$CropTask;->mUri:Ljava/lang/String;

    .line 233
    iput p3, p0, Lcom/facebook/react/modules/camera/ImageEditingManager$CropTask;->mX:I

    .line 234
    iput p4, p0, Lcom/facebook/react/modules/camera/ImageEditingManager$CropTask;->mY:I

    .line 235
    iput p5, p0, Lcom/facebook/react/modules/camera/ImageEditingManager$CropTask;->mWidth:I

    .line 236
    iput p6, p0, Lcom/facebook/react/modules/camera/ImageEditingManager$CropTask;->mHeight:I

    .line 237
    iput-object p7, p0, Lcom/facebook/react/modules/camera/ImageEditingManager$CropTask;->mSuccess:Lcom/facebook/react/bridge/Callback;

    .line 238
    iput-object p8, p0, Lcom/facebook/react/modules/camera/ImageEditingManager$CropTask;->mError:Lcom/facebook/react/bridge/Callback;

    .line 239
    return-void
.end method

.method synthetic constructor <init>(Lcom/facebook/react/bridge/ReactContext;Ljava/lang/String;IIIILcom/facebook/react/bridge/Callback;Lcom/facebook/react/bridge/Callback;Lcom/facebook/react/modules/camera/ImageEditingManager$1;)V
    .locals 0
    .param p1, "x0"    # Lcom/facebook/react/bridge/ReactContext;
    .param p2, "x1"    # Ljava/lang/String;
    .param p3, "x2"    # I
    .param p4, "x3"    # I
    .param p5, "x4"    # I
    .param p6, "x5"    # I
    .param p7, "x6"    # Lcom/facebook/react/bridge/Callback;
    .param p8, "x7"    # Lcom/facebook/react/bridge/Callback;
    .param p9, "x8"    # Lcom/facebook/react/modules/camera/ImageEditingManager$1;

    .prologue
    .line 205
    invoke-direct/range {p0 .. p8}, Lcom/facebook/react/modules/camera/ImageEditingManager$CropTask;-><init>(Lcom/facebook/react/bridge/ReactContext;Ljava/lang/String;IIIILcom/facebook/react/bridge/Callback;Lcom/facebook/react/bridge/Callback;)V

    return-void
.end method

.method private crop(Landroid/graphics/BitmapFactory$Options;)Landroid/graphics/Bitmap;
    .locals 8
    .param p1, "outOptions"    # Landroid/graphics/BitmapFactory$Options;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;
        }
    .end annotation

    .prologue
    .line 302
    invoke-direct {p0}, Lcom/facebook/react/modules/camera/ImageEditingManager$CropTask;->openBitmapInputStream()Ljava/io/InputStream;

    move-result-object v1

    .line 305
    .local v1, "inputStream":Ljava/io/InputStream;
    const/4 v3, 0x0

    invoke-static {v1, v3}, Landroid/graphics/BitmapRegionDecoder;->newInstance(Ljava/io/InputStream;Z)Landroid/graphics/BitmapRegionDecoder;

    move-result-object v0

    .line 307
    .local v0, "decoder":Landroid/graphics/BitmapRegionDecoder;
    :try_start_0
    new-instance v2, Landroid/graphics/Rect;

    iget v3, p0, Lcom/facebook/react/modules/camera/ImageEditingManager$CropTask;->mX:I

    iget v4, p0, Lcom/facebook/react/modules/camera/ImageEditingManager$CropTask;->mY:I

    iget v5, p0, Lcom/facebook/react/modules/camera/ImageEditingManager$CropTask;->mX:I

    iget v6, p0, Lcom/facebook/react/modules/camera/ImageEditingManager$CropTask;->mWidth:I

    add-int/2addr v5, v6

    iget v6, p0, Lcom/facebook/react/modules/camera/ImageEditingManager$CropTask;->mY:I

    iget v7, p0, Lcom/facebook/react/modules/camera/ImageEditingManager$CropTask;->mHeight:I

    add-int/2addr v6, v7

    invoke-direct {v2, v3, v4, v5, v6}, Landroid/graphics/Rect;-><init>(IIII)V

    .line 308
    .local v2, "rect":Landroid/graphics/Rect;
    invoke-virtual {v0, v2, p1}, Landroid/graphics/BitmapRegionDecoder;->decodeRegion(Landroid/graphics/Rect;Landroid/graphics/BitmapFactory$Options;)Landroid/graphics/Bitmap;
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    move-result-object v3

    .line 310
    if-eqz v1, :cond_0

    .line 311
    invoke-virtual {v1}, Ljava/io/InputStream;->close()V

    .line 313
    :cond_0
    invoke-virtual {v0}, Landroid/graphics/BitmapRegionDecoder;->recycle()V

    return-object v3

    .line 310
    .end local v2    # "rect":Landroid/graphics/Rect;
    :catchall_0
    move-exception v3

    if-eqz v1, :cond_1

    .line 311
    invoke-virtual {v1}, Ljava/io/InputStream;->close()V

    .line 313
    :cond_1
    invoke-virtual {v0}, Landroid/graphics/BitmapRegionDecoder;->recycle()V

    throw v3
.end method

.method private cropAndResize(IILandroid/graphics/BitmapFactory$Options;)Landroid/graphics/Bitmap;
    .locals 24
    .param p1, "targetWidth"    # I
    .param p2, "targetHeight"    # I
    .param p3, "outOptions"    # Landroid/graphics/BitmapFactory$Options;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;
        }
    .end annotation

    .prologue
    .line 327
    invoke-static/range {p3 .. p3}, Lcom/facebook/infer/annotation/Assertions;->assertNotNull(Ljava/lang/Object;)Ljava/lang/Object;

    .line 333
    new-instance v18, Landroid/graphics/BitmapFactory$Options;

    invoke-direct/range {v18 .. v18}, Landroid/graphics/BitmapFactory$Options;-><init>()V

    .line 334
    .local v18, "options":Landroid/graphics/BitmapFactory$Options;
    const/16 v21, 0x1

    move/from16 v0, v21

    move-object/from16 v1, v18

    iput-boolean v0, v1, Landroid/graphics/BitmapFactory$Options;->inJustDecodeBounds:Z

    .line 335
    invoke-direct/range {p0 .. p0}, Lcom/facebook/react/modules/camera/ImageEditingManager$CropTask;->openBitmapInputStream()Ljava/io/InputStream;

    move-result-object v13

    .line 337
    .local v13, "inputStream":Ljava/io/InputStream;
    const/16 v21, 0x0

    :try_start_0
    move-object/from16 v0, v21

    move-object/from16 v1, v18

    invoke-static {v13, v0, v1}, Landroid/graphics/BitmapFactory;->decodeStream(Ljava/io/InputStream;Landroid/graphics/Rect;Landroid/graphics/BitmapFactory$Options;)Landroid/graphics/Bitmap;
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_1

    .line 339
    if-eqz v13, :cond_0

    .line 340
    invoke-virtual {v13}, Ljava/io/InputStream;->close()V

    .line 348
    :cond_0
    move-object/from16 v0, p0

    iget v0, v0, Lcom/facebook/react/modules/camera/ImageEditingManager$CropTask;->mWidth:I

    move/from16 v21, v0

    move/from16 v0, v21

    int-to-float v0, v0

    move/from16 v21, v0

    move-object/from16 v0, p0

    iget v0, v0, Lcom/facebook/react/modules/camera/ImageEditingManager$CropTask;->mHeight:I

    move/from16 v22, v0

    move/from16 v0, v22

    int-to-float v0, v0

    move/from16 v22, v0

    div-float v11, v21, v22

    .line 349
    .local v11, "cropRectRatio":F
    move/from16 v0, p1

    int-to-float v0, v0

    move/from16 v21, v0

    move/from16 v0, p2

    int-to-float v0, v0

    move/from16 v22, v0

    div-float v20, v21, v22

    .line 350
    .local v20, "targetRatio":F
    cmpl-float v21, v11, v20

    if-lez v21, :cond_3

    .line 352
    move-object/from16 v0, p0

    iget v0, v0, Lcom/facebook/react/modules/camera/ImageEditingManager$CropTask;->mHeight:I

    move/from16 v21, v0

    move/from16 v0, v21

    int-to-float v0, v0

    move/from16 v21, v0

    mul-float v15, v21, v20

    .line 353
    .local v15, "newWidth":F
    move-object/from16 v0, p0

    iget v0, v0, Lcom/facebook/react/modules/camera/ImageEditingManager$CropTask;->mHeight:I

    move/from16 v21, v0

    move/from16 v0, v21

    int-to-float v14, v0

    .line 354
    .local v14, "newHeight":F
    move-object/from16 v0, p0

    iget v0, v0, Lcom/facebook/react/modules/camera/ImageEditingManager$CropTask;->mX:I

    move/from16 v21, v0

    move/from16 v0, v21

    int-to-float v0, v0

    move/from16 v21, v0

    move-object/from16 v0, p0

    iget v0, v0, Lcom/facebook/react/modules/camera/ImageEditingManager$CropTask;->mWidth:I

    move/from16 v22, v0

    move/from16 v0, v22

    int-to-float v0, v0

    move/from16 v22, v0

    sub-float v22, v22, v15

    const/high16 v23, 0x40000000    # 2.0f

    div-float v22, v22, v23

    add-float v16, v21, v22

    .line 355
    .local v16, "newX":F
    move-object/from16 v0, p0

    iget v0, v0, Lcom/facebook/react/modules/camera/ImageEditingManager$CropTask;->mY:I

    move/from16 v21, v0

    move/from16 v0, v21

    int-to-float v0, v0

    move/from16 v17, v0

    .line 356
    .local v17, "newY":F
    move/from16 v0, p2

    int-to-float v0, v0

    move/from16 v21, v0

    move-object/from16 v0, p0

    iget v0, v0, Lcom/facebook/react/modules/camera/ImageEditingManager$CropTask;->mHeight:I

    move/from16 v22, v0

    move/from16 v0, v22

    int-to-float v0, v0

    move/from16 v22, v0

    div-float v19, v21, v22

    .line 368
    .local v19, "scale":F
    :goto_0
    move-object/from16 v0, p0

    iget v0, v0, Lcom/facebook/react/modules/camera/ImageEditingManager$CropTask;->mWidth:I

    move/from16 v21, v0

    move-object/from16 v0, p0

    iget v0, v0, Lcom/facebook/react/modules/camera/ImageEditingManager$CropTask;->mHeight:I

    move/from16 v22, v0

    move/from16 v0, v21

    move/from16 v1, v22

    move/from16 v2, p1

    move/from16 v3, p2

    invoke-static {v0, v1, v2, v3}, Lcom/facebook/react/modules/camera/ImageEditingManager;->access$600(IIII)I

    move-result v21

    move/from16 v0, v21

    move-object/from16 v1, p3

    iput v0, v1, Landroid/graphics/BitmapFactory$Options;->inSampleSize:I

    .line 369
    const/16 v21, 0x0

    move/from16 v0, v21

    move-object/from16 v1, v18

    iput-boolean v0, v1, Landroid/graphics/BitmapFactory$Options;->inJustDecodeBounds:Z

    .line 370
    invoke-direct/range {p0 .. p0}, Lcom/facebook/react/modules/camera/ImageEditingManager$CropTask;->openBitmapInputStream()Ljava/io/InputStream;

    move-result-object v13

    .line 375
    const/16 v21, 0x0

    :try_start_1
    move-object/from16 v0, v21

    move-object/from16 v1, p3

    invoke-static {v13, v0, v1}, Landroid/graphics/BitmapFactory;->decodeStream(Ljava/io/InputStream;Landroid/graphics/Rect;Landroid/graphics/BitmapFactory$Options;)Landroid/graphics/Bitmap;

    move-result-object v4

    .line 376
    .local v4, "bitmap":Landroid/graphics/Bitmap;
    if-nez v4, :cond_4

    .line 377
    new-instance v21, Ljava/io/IOException;

    new-instance v22, Ljava/lang/StringBuilder;

    invoke-direct/range {v22 .. v22}, Ljava/lang/StringBuilder;-><init>()V

    const-string v23, "Cannot decode bitmap: "

    invoke-virtual/range {v22 .. v23}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v22

    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/facebook/react/modules/camera/ImageEditingManager$CropTask;->mUri:Ljava/lang/String;

    move-object/from16 v23, v0

    invoke-virtual/range {v22 .. v23}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v22

    invoke-virtual/range {v22 .. v22}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v22

    invoke-direct/range {v21 .. v22}, Ljava/io/IOException;-><init>(Ljava/lang/String;)V

    throw v21
    :try_end_1
    .catchall {:try_start_1 .. :try_end_1} :catchall_0

    .line 380
    .end local v4    # "bitmap":Landroid/graphics/Bitmap;
    :catchall_0
    move-exception v21

    if-eqz v13, :cond_1

    .line 381
    invoke-virtual {v13}, Ljava/io/InputStream;->close()V

    :cond_1
    throw v21

    .line 339
    .end local v11    # "cropRectRatio":F
    .end local v14    # "newHeight":F
    .end local v15    # "newWidth":F
    .end local v16    # "newX":F
    .end local v17    # "newY":F
    .end local v19    # "scale":F
    .end local v20    # "targetRatio":F
    :catchall_1
    move-exception v21

    if-eqz v13, :cond_2

    .line 340
    invoke-virtual {v13}, Ljava/io/InputStream;->close()V

    :cond_2
    throw v21

    .line 359
    .restart local v11    # "cropRectRatio":F
    .restart local v20    # "targetRatio":F
    :cond_3
    move-object/from16 v0, p0

    iget v0, v0, Lcom/facebook/react/modules/camera/ImageEditingManager$CropTask;->mWidth:I

    move/from16 v21, v0

    move/from16 v0, v21

    int-to-float v15, v0

    .line 360
    .restart local v15    # "newWidth":F
    move-object/from16 v0, p0

    iget v0, v0, Lcom/facebook/react/modules/camera/ImageEditingManager$CropTask;->mWidth:I

    move/from16 v21, v0

    move/from16 v0, v21

    int-to-float v0, v0

    move/from16 v21, v0

    div-float v14, v21, v20

    .line 361
    .restart local v14    # "newHeight":F
    move-object/from16 v0, p0

    iget v0, v0, Lcom/facebook/react/modules/camera/ImageEditingManager$CropTask;->mX:I

    move/from16 v21, v0

    move/from16 v0, v21

    int-to-float v0, v0

    move/from16 v16, v0

    .line 362
    .restart local v16    # "newX":F
    move-object/from16 v0, p0

    iget v0, v0, Lcom/facebook/react/modules/camera/ImageEditingManager$CropTask;->mY:I

    move/from16 v21, v0

    move/from16 v0, v21

    int-to-float v0, v0

    move/from16 v21, v0

    move-object/from16 v0, p0

    iget v0, v0, Lcom/facebook/react/modules/camera/ImageEditingManager$CropTask;->mHeight:I

    move/from16 v22, v0

    move/from16 v0, v22

    int-to-float v0, v0

    move/from16 v22, v0

    sub-float v22, v22, v14

    const/high16 v23, 0x40000000    # 2.0f

    div-float v22, v22, v23

    add-float v17, v21, v22

    .line 363
    .restart local v17    # "newY":F
    move/from16 v0, p1

    int-to-float v0, v0

    move/from16 v21, v0

    move-object/from16 v0, p0

    iget v0, v0, Lcom/facebook/react/modules/camera/ImageEditingManager$CropTask;->mWidth:I

    move/from16 v22, v0

    move/from16 v0, v22

    int-to-float v0, v0

    move/from16 v22, v0

    div-float v19, v21, v22

    .restart local v19    # "scale":F
    goto/16 :goto_0

    .line 380
    .restart local v4    # "bitmap":Landroid/graphics/Bitmap;
    :cond_4
    if-eqz v13, :cond_5

    .line 381
    invoke-virtual {v13}, Ljava/io/InputStream;->close()V

    .line 385
    :cond_5
    move-object/from16 v0, p3

    iget v0, v0, Landroid/graphics/BitmapFactory$Options;->inSampleSize:I

    move/from16 v21, v0

    move/from16 v0, v21

    int-to-float v0, v0

    move/from16 v21, v0

    div-float v21, v16, v21

    move/from16 v0, v21

    float-to-double v0, v0

    move-wide/from16 v22, v0

    invoke-static/range {v22 .. v23}, Ljava/lang/Math;->floor(D)D

    move-result-wide v22

    move-wide/from16 v0, v22

    double-to-int v5, v0

    .line 386
    .local v5, "cropX":I
    move-object/from16 v0, p3

    iget v0, v0, Landroid/graphics/BitmapFactory$Options;->inSampleSize:I

    move/from16 v21, v0

    move/from16 v0, v21

    int-to-float v0, v0

    move/from16 v21, v0

    div-float v21, v17, v21

    move/from16 v0, v21

    float-to-double v0, v0

    move-wide/from16 v22, v0

    invoke-static/range {v22 .. v23}, Ljava/lang/Math;->floor(D)D

    move-result-wide v22

    move-wide/from16 v0, v22

    double-to-int v6, v0

    .line 387
    .local v6, "cropY":I
    move-object/from16 v0, p3

    iget v0, v0, Landroid/graphics/BitmapFactory$Options;->inSampleSize:I

    move/from16 v21, v0

    move/from16 v0, v21

    int-to-float v0, v0

    move/from16 v21, v0

    div-float v21, v15, v21

    move/from16 v0, v21

    float-to-double v0, v0

    move-wide/from16 v22, v0

    invoke-static/range {v22 .. v23}, Ljava/lang/Math;->floor(D)D

    move-result-wide v22

    move-wide/from16 v0, v22

    double-to-int v7, v0

    .line 388
    .local v7, "cropWidth":I
    move-object/from16 v0, p3

    iget v0, v0, Landroid/graphics/BitmapFactory$Options;->inSampleSize:I

    move/from16 v21, v0

    move/from16 v0, v21

    int-to-float v0, v0

    move/from16 v21, v0

    div-float v21, v14, v21

    move/from16 v0, v21

    float-to-double v0, v0

    move-wide/from16 v22, v0

    invoke-static/range {v22 .. v23}, Ljava/lang/Math;->floor(D)D

    move-result-wide v22

    move-wide/from16 v0, v22

    double-to-int v8, v0

    .line 389
    .local v8, "cropHeight":I
    move-object/from16 v0, p3

    iget v0, v0, Landroid/graphics/BitmapFactory$Options;->inSampleSize:I

    move/from16 v21, v0

    move/from16 v0, v21

    int-to-float v0, v0

    move/from16 v21, v0

    mul-float v12, v19, v21

    .line 391
    .local v12, "cropScale":F
    new-instance v9, Landroid/graphics/Matrix;

    invoke-direct {v9}, Landroid/graphics/Matrix;-><init>()V

    .line 392
    .local v9, "scaleMatrix":Landroid/graphics/Matrix;
    invoke-virtual {v9, v12, v12}, Landroid/graphics/Matrix;->setScale(FF)V

    .line 393
    const/4 v10, 0x1

    .line 395
    .local v10, "filter":Z
    invoke-static/range {v4 .. v10}, Landroid/graphics/Bitmap;->createBitmap(Landroid/graphics/Bitmap;IIIILandroid/graphics/Matrix;Z)Landroid/graphics/Bitmap;

    move-result-object v21

    return-object v21
.end method

.method private openBitmapInputStream()Ljava/io/InputStream;
    .locals 5
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;
        }
    .end annotation

    .prologue
    .line 252
    iget-object v2, p0, Lcom/facebook/react/modules/camera/ImageEditingManager$CropTask;->mUri:Ljava/lang/String;

    invoke-static {v2}, Lcom/facebook/react/modules/camera/ImageEditingManager;->access$200(Ljava/lang/String;)Z

    move-result v2

    if-eqz v2, :cond_0

    .line 253
    iget-object v2, p0, Lcom/facebook/react/modules/camera/ImageEditingManager$CropTask;->mContext:Landroid/content/Context;

    invoke-virtual {v2}, Landroid/content/Context;->getContentResolver()Landroid/content/ContentResolver;

    move-result-object v2

    iget-object v3, p0, Lcom/facebook/react/modules/camera/ImageEditingManager$CropTask;->mUri:Ljava/lang/String;

    invoke-static {v3}, Landroid/net/Uri;->parse(Ljava/lang/String;)Landroid/net/Uri;

    move-result-object v3

    invoke-virtual {v2, v3}, Landroid/content/ContentResolver;->openInputStream(Landroid/net/Uri;)Ljava/io/InputStream;

    move-result-object v1

    .line 258
    .local v1, "stream":Ljava/io/InputStream;
    :goto_0
    if-nez v1, :cond_1

    .line 259
    new-instance v2, Ljava/io/IOException;

    new-instance v3, Ljava/lang/StringBuilder;

    invoke-direct {v3}, Ljava/lang/StringBuilder;-><init>()V

    const-string v4, "Cannot open bitmap: "

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    iget-object v4, p0, Lcom/facebook/react/modules/camera/ImageEditingManager$CropTask;->mUri:Ljava/lang/String;

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    invoke-virtual {v3}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v3

    invoke-direct {v2, v3}, Ljava/io/IOException;-><init>(Ljava/lang/String;)V

    throw v2

    .line 255
    .end local v1    # "stream":Ljava/io/InputStream;
    :cond_0
    new-instance v2, Ljava/net/URL;

    iget-object v3, p0, Lcom/facebook/react/modules/camera/ImageEditingManager$CropTask;->mUri:Ljava/lang/String;

    invoke-direct {v2, v3}, Ljava/net/URL;-><init>(Ljava/lang/String;)V

    invoke-virtual {v2}, Ljava/net/URL;->openConnection()Ljava/net/URLConnection;

    move-result-object v0

    .line 256
    .local v0, "connection":Ljava/net/URLConnection;
    invoke-virtual {v0}, Ljava/net/URLConnection;->getInputStream()Ljava/io/InputStream;

    move-result-object v1

    .restart local v1    # "stream":Ljava/io/InputStream;
    goto :goto_0

    .line 261
    .end local v0    # "connection":Ljava/net/URLConnection;
    :cond_1
    return-object v1
.end method


# virtual methods
.method protected bridge synthetic doInBackgroundGuarded([Ljava/lang/Object;)V
    .locals 0

    .prologue
    .line 205
    check-cast p1, [Ljava/lang/Void;

    invoke-virtual {p0, p1}, Lcom/facebook/react/modules/camera/ImageEditingManager$CropTask;->doInBackgroundGuarded([Ljava/lang/Void;)V

    return-void
.end method

.method protected varargs doInBackgroundGuarded([Ljava/lang/Void;)V
    .locals 12
    .param p1, "params"    # [Ljava/lang/Void;

    .prologue
    const/4 v6, 0x1

    const/4 v7, 0x0

    .line 267
    :try_start_0
    new-instance v4, Landroid/graphics/BitmapFactory$Options;

    invoke-direct {v4}, Landroid/graphics/BitmapFactory$Options;-><init>()V

    .line 270
    .local v4, "outOptions":Landroid/graphics/BitmapFactory$Options;
    iget v8, p0, Lcom/facebook/react/modules/camera/ImageEditingManager$CropTask;->mTargetWidth:I

    if-lez v8, :cond_1

    iget v8, p0, Lcom/facebook/react/modules/camera/ImageEditingManager$CropTask;->mTargetHeight:I

    if-lez v8, :cond_1

    move v2, v6

    .line 273
    .local v2, "hasTargetSize":Z
    :goto_0
    if-eqz v2, :cond_2

    .line 274
    iget v8, p0, Lcom/facebook/react/modules/camera/ImageEditingManager$CropTask;->mTargetWidth:I

    iget v9, p0, Lcom/facebook/react/modules/camera/ImageEditingManager$CropTask;->mTargetHeight:I

    invoke-direct {p0, v8, v9, v4}, Lcom/facebook/react/modules/camera/ImageEditingManager$CropTask;->cropAndResize(IILandroid/graphics/BitmapFactory$Options;)Landroid/graphics/Bitmap;

    move-result-object v0

    .line 279
    .local v0, "cropped":Landroid/graphics/Bitmap;
    :goto_1
    iget-object v3, v4, Landroid/graphics/BitmapFactory$Options;->outMimeType:Ljava/lang/String;

    .line 280
    .local v3, "mimeType":Ljava/lang/String;
    if-eqz v3, :cond_0

    invoke-virtual {v3}, Ljava/lang/String;->isEmpty()Z

    move-result v8

    if-eqz v8, :cond_3

    .line 281
    :cond_0
    new-instance v8, Ljava/io/IOException;

    const-string v9, "Could not determine MIME type"

    invoke-direct {v8, v9}, Ljava/io/IOException;-><init>(Ljava/lang/String;)V

    throw v8
    :try_end_0
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_0

    .line 292
    .end local v0    # "cropped":Landroid/graphics/Bitmap;
    .end local v2    # "hasTargetSize":Z
    .end local v3    # "mimeType":Ljava/lang/String;
    .end local v4    # "outOptions":Landroid/graphics/BitmapFactory$Options;
    :catch_0
    move-exception v1

    .line 293
    .local v1, "e":Ljava/lang/Exception;
    iget-object v8, p0, Lcom/facebook/react/modules/camera/ImageEditingManager$CropTask;->mError:Lcom/facebook/react/bridge/Callback;

    new-array v6, v6, [Ljava/lang/Object;

    invoke-virtual {v1}, Ljava/lang/Exception;->getMessage()Ljava/lang/String;

    move-result-object v9

    aput-object v9, v6, v7

    invoke-interface {v8, v6}, Lcom/facebook/react/bridge/Callback;->invoke([Ljava/lang/Object;)V

    .line 295
    .end local v1    # "e":Ljava/lang/Exception;
    :goto_2
    return-void

    .restart local v4    # "outOptions":Landroid/graphics/BitmapFactory$Options;
    :cond_1
    move v2, v7

    .line 270
    goto :goto_0

    .line 276
    .restart local v2    # "hasTargetSize":Z
    :cond_2
    :try_start_1
    invoke-direct {p0, v4}, Lcom/facebook/react/modules/camera/ImageEditingManager$CropTask;->crop(Landroid/graphics/BitmapFactory$Options;)Landroid/graphics/Bitmap;

    move-result-object v0

    .restart local v0    # "cropped":Landroid/graphics/Bitmap;
    goto :goto_1

    .line 284
    .restart local v3    # "mimeType":Ljava/lang/String;
    :cond_3
    iget-object v8, p0, Lcom/facebook/react/modules/camera/ImageEditingManager$CropTask;->mContext:Landroid/content/Context;

    invoke-static {v8, v3}, Lcom/facebook/react/modules/camera/ImageEditingManager;->access$300(Landroid/content/Context;Ljava/lang/String;)Ljava/io/File;

    move-result-object v5

    .line 285
    .local v5, "tempFile":Ljava/io/File;
    invoke-static {v0, v3, v5}, Lcom/facebook/react/modules/camera/ImageEditingManager;->access$400(Landroid/graphics/Bitmap;Ljava/lang/String;Ljava/io/File;)V

    .line 287
    const-string v8, "image/jpeg"

    invoke-virtual {v3, v8}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v8

    if-eqz v8, :cond_4

    .line 288
    iget-object v8, p0, Lcom/facebook/react/modules/camera/ImageEditingManager$CropTask;->mContext:Landroid/content/Context;

    iget-object v9, p0, Lcom/facebook/react/modules/camera/ImageEditingManager$CropTask;->mUri:Ljava/lang/String;

    invoke-static {v9}, Landroid/net/Uri;->parse(Ljava/lang/String;)Landroid/net/Uri;

    move-result-object v9

    invoke-static {v8, v9, v5}, Lcom/facebook/react/modules/camera/ImageEditingManager;->access$500(Landroid/content/Context;Landroid/net/Uri;Ljava/io/File;)V

    .line 291
    :cond_4
    iget-object v8, p0, Lcom/facebook/react/modules/camera/ImageEditingManager$CropTask;->mSuccess:Lcom/facebook/react/bridge/Callback;

    const/4 v9, 0x1

    new-array v9, v9, [Ljava/lang/Object;

    const/4 v10, 0x0

    invoke-static {v5}, Landroid/net/Uri;->fromFile(Ljava/io/File;)Landroid/net/Uri;

    move-result-object v11

    invoke-virtual {v11}, Landroid/net/Uri;->toString()Ljava/lang/String;

    move-result-object v11

    aput-object v11, v9, v10

    invoke-interface {v8, v9}, Lcom/facebook/react/bridge/Callback;->invoke([Ljava/lang/Object;)V
    :try_end_1
    .catch Ljava/lang/Exception; {:try_start_1 .. :try_end_1} :catch_0

    goto :goto_2
.end method

.method public setTargetSize(II)V
    .locals 5
    .param p1, "width"    # I
    .param p2, "height"    # I

    .prologue
    .line 242
    if-lez p1, :cond_0

    if-gtz p2, :cond_1

    .line 243
    :cond_0
    new-instance v0, Lcom/facebook/react/bridge/JSApplicationIllegalArgumentException;

    const-string v1, "Invalid target size: [%d, %d]"

    const/4 v2, 0x2

    new-array v2, v2, [Ljava/lang/Object;

    const/4 v3, 0x0

    .line 244
    invoke-static {p1}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v4

    aput-object v4, v2, v3

    const/4 v3, 0x1

    invoke-static {p2}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v4

    aput-object v4, v2, v3

    .line 243
    invoke-static {v1, v2}, Ljava/lang/String;->format(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v1

    invoke-direct {v0, v1}, Lcom/facebook/react/bridge/JSApplicationIllegalArgumentException;-><init>(Ljava/lang/String;)V

    throw v0

    .line 246
    :cond_1
    iput p1, p0, Lcom/facebook/react/modules/camera/ImageEditingManager$CropTask;->mTargetWidth:I

    .line 247
    iput p2, p0, Lcom/facebook/react/modules/camera/ImageEditingManager$CropTask;->mTargetHeight:I

    .line 248
    return-void
.end method

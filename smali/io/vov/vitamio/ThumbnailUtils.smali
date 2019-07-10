.class public Lio/vov/vitamio/ThumbnailUtils;
.super Ljava/lang/Object;
.source "ThumbnailUtils.java"


# static fields
.field private static final OPTIONS_NONE:I = 0x0

.field public static final OPTIONS_RECYCLE_INPUT:I = 0x2

.field private static final OPTIONS_SCALE_UP:I = 0x1

.field public static final TARGET_SIZE_MICRO_THUMBNAIL_HEIGHT:I = 0xa0

.field public static final TARGET_SIZE_MICRO_THUMBNAIL_WIDTH:I = 0xd4

.field public static final TARGET_SIZE_MINI_THUMBNAIL_HEIGHT:I = 0x140

.field public static final TARGET_SIZE_MINI_THUMBNAIL_WIDTH:I = 0x1aa


# direct methods
.method public constructor <init>()V
    .locals 0

    .prologue
    .line 35
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method

.method public static createVideoThumbnail(Landroid/content/Context;Ljava/lang/String;I)Landroid/graphics/Bitmap;
    .locals 7
    .param p0, "ctx"    # Landroid/content/Context;
    .param p1, "filePath"    # Ljava/lang/String;
    .param p2, "kind"    # I

    .prologue
    const/4 v6, 0x2

    .line 46
    invoke-static {p0}, Lio/vov/vitamio/Vitamio;->isInitialized(Landroid/content/Context;)Z

    move-result v3

    if-nez v3, :cond_1

    .line 47
    const/4 v0, 0x0

    .line 69
    :cond_0
    :goto_0
    return-object v0

    .line 49
    :cond_1
    const/4 v0, 0x0

    .line 50
    .local v0, "bitmap":Landroid/graphics/Bitmap;
    const/4 v1, 0x0

    .line 52
    .local v1, "retriever":Lio/vov/vitamio/MediaMetadataRetriever;
    :try_start_0
    new-instance v2, Lio/vov/vitamio/MediaMetadataRetriever;

    invoke-direct {v2, p0}, Lio/vov/vitamio/MediaMetadataRetriever;-><init>(Landroid/content/Context;)V
    :try_end_0
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_1
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    .line 53
    .end local v1    # "retriever":Lio/vov/vitamio/MediaMetadataRetriever;
    .local v2, "retriever":Lio/vov/vitamio/MediaMetadataRetriever;
    :try_start_1
    invoke-virtual {v2, p1}, Lio/vov/vitamio/MediaMetadataRetriever;->setDataSource(Ljava/lang/String;)V

    .line 54
    const-wide/16 v4, -0x1

    invoke-virtual {v2, v4, v5}, Lio/vov/vitamio/MediaMetadataRetriever;->getFrameAtTime(J)Landroid/graphics/Bitmap;
    :try_end_1
    .catch Ljava/lang/Exception; {:try_start_1 .. :try_end_1} :catch_4
    .catchall {:try_start_1 .. :try_end_1} :catchall_1

    move-result-object v0

    .line 58
    :try_start_2
    invoke-virtual {v2}, Lio/vov/vitamio/MediaMetadataRetriever;->release()V
    :try_end_2
    .catch Ljava/lang/RuntimeException; {:try_start_2 .. :try_end_2} :catch_0

    move-object v1, v2

    .line 63
    .end local v2    # "retriever":Lio/vov/vitamio/MediaMetadataRetriever;
    .restart local v1    # "retriever":Lio/vov/vitamio/MediaMetadataRetriever;
    :goto_1
    if-eqz v0, :cond_0

    .line 64
    const/4 v3, 0x3

    if-ne p2, v3, :cond_2

    .line 65
    const/16 v3, 0xd4

    const/16 v4, 0xa0

    invoke-static {v0, v3, v4, v6}, Lio/vov/vitamio/ThumbnailUtils;->extractThumbnail(Landroid/graphics/Bitmap;III)Landroid/graphics/Bitmap;

    move-result-object v0

    goto :goto_0

    .line 59
    .end local v1    # "retriever":Lio/vov/vitamio/MediaMetadataRetriever;
    .restart local v2    # "retriever":Lio/vov/vitamio/MediaMetadataRetriever;
    :catch_0
    move-exception v3

    move-object v1, v2

    .line 61
    .end local v2    # "retriever":Lio/vov/vitamio/MediaMetadataRetriever;
    .restart local v1    # "retriever":Lio/vov/vitamio/MediaMetadataRetriever;
    goto :goto_1

    .line 55
    :catch_1
    move-exception v3

    .line 58
    :goto_2
    :try_start_3
    invoke-virtual {v1}, Lio/vov/vitamio/MediaMetadataRetriever;->release()V
    :try_end_3
    .catch Ljava/lang/RuntimeException; {:try_start_3 .. :try_end_3} :catch_2

    goto :goto_1

    .line 59
    :catch_2
    move-exception v3

    goto :goto_1

    .line 57
    :catchall_0
    move-exception v3

    .line 58
    :goto_3
    :try_start_4
    invoke-virtual {v1}, Lio/vov/vitamio/MediaMetadataRetriever;->release()V
    :try_end_4
    .catch Ljava/lang/RuntimeException; {:try_start_4 .. :try_end_4} :catch_3

    .line 60
    :goto_4
    throw v3

    .line 66
    :cond_2
    const/4 v3, 0x1

    if-ne p2, v3, :cond_0

    .line 67
    const/16 v3, 0x1aa

    const/16 v4, 0x140

    invoke-static {v0, v3, v4, v6}, Lio/vov/vitamio/ThumbnailUtils;->extractThumbnail(Landroid/graphics/Bitmap;III)Landroid/graphics/Bitmap;

    move-result-object v0

    goto :goto_0

    .line 59
    :catch_3
    move-exception v4

    goto :goto_4

    .line 57
    .end local v1    # "retriever":Lio/vov/vitamio/MediaMetadataRetriever;
    .restart local v2    # "retriever":Lio/vov/vitamio/MediaMetadataRetriever;
    :catchall_1
    move-exception v3

    move-object v1, v2

    .end local v2    # "retriever":Lio/vov/vitamio/MediaMetadataRetriever;
    .restart local v1    # "retriever":Lio/vov/vitamio/MediaMetadataRetriever;
    goto :goto_3

    .line 55
    .end local v1    # "retriever":Lio/vov/vitamio/MediaMetadataRetriever;
    .restart local v2    # "retriever":Lio/vov/vitamio/MediaMetadataRetriever;
    :catch_4
    move-exception v3

    move-object v1, v2

    .end local v2    # "retriever":Lio/vov/vitamio/MediaMetadataRetriever;
    .restart local v1    # "retriever":Lio/vov/vitamio/MediaMetadataRetriever;
    goto :goto_2
.end method

.method public static extractThumbnail(Landroid/graphics/Bitmap;II)Landroid/graphics/Bitmap;
    .locals 1
    .param p0, "source"    # Landroid/graphics/Bitmap;
    .param p1, "width"    # I
    .param p2, "height"    # I

    .prologue
    .line 73
    const/4 v0, 0x0

    invoke-static {p0, p1, p2, v0}, Lio/vov/vitamio/ThumbnailUtils;->extractThumbnail(Landroid/graphics/Bitmap;III)Landroid/graphics/Bitmap;

    move-result-object v0

    return-object v0
.end method

.method public static extractThumbnail(Landroid/graphics/Bitmap;III)Landroid/graphics/Bitmap;
    .locals 5
    .param p0, "source"    # Landroid/graphics/Bitmap;
    .param p1, "width"    # I
    .param p2, "height"    # I
    .param p3, "options"    # I

    .prologue
    .line 77
    if-nez p0, :cond_0

    .line 78
    const/4 v2, 0x0

    .line 88
    :goto_0
    return-object v2

    .line 81
    :cond_0
    invoke-virtual {p0}, Landroid/graphics/Bitmap;->getWidth()I

    move-result v3

    invoke-virtual {p0}, Landroid/graphics/Bitmap;->getHeight()I

    move-result v4

    if-ge v3, v4, :cond_1

    .line 82
    int-to-float v3, p1

    invoke-virtual {p0}, Landroid/graphics/Bitmap;->getWidth()I

    move-result v4

    int-to-float v4, v4

    div-float v1, v3, v4

    .line 85
    .local v1, "scale":F
    :goto_1
    new-instance v0, Landroid/graphics/Matrix;

    invoke-direct {v0}, Landroid/graphics/Matrix;-><init>()V

    .line 86
    .local v0, "matrix":Landroid/graphics/Matrix;
    invoke-virtual {v0, v1, v1}, Landroid/graphics/Matrix;->setScale(FF)V

    .line 87
    or-int/lit8 v3, p3, 0x1

    invoke-static {v0, p0, p1, p2, v3}, Lio/vov/vitamio/ThumbnailUtils;->transform(Landroid/graphics/Matrix;Landroid/graphics/Bitmap;III)Landroid/graphics/Bitmap;

    move-result-object v2

    .line 88
    .local v2, "thumbnail":Landroid/graphics/Bitmap;
    goto :goto_0

    .line 84
    .end local v0    # "matrix":Landroid/graphics/Matrix;
    .end local v1    # "scale":F
    .end local v2    # "thumbnail":Landroid/graphics/Bitmap;
    :cond_1
    int-to-float v3, p2

    invoke-virtual {p0}, Landroid/graphics/Bitmap;->getHeight()I

    move-result v4

    int-to-float v4, v4

    div-float v1, v3, v4

    .restart local v1    # "scale":F
    goto :goto_1
.end method

.method private static transform(Landroid/graphics/Matrix;Landroid/graphics/Bitmap;III)Landroid/graphics/Bitmap;
    .locals 30
    .param p0, "scaler"    # Landroid/graphics/Matrix;
    .param p1, "source"    # Landroid/graphics/Bitmap;
    .param p2, "targetWidth"    # I
    .param p3, "targetHeight"    # I
    .param p4, "options"    # I

    .prologue
    .line 92
    and-int/lit8 v3, p4, 0x1

    if-eqz v3, :cond_2

    const/16 v27, 0x1

    .line 93
    .local v27, "scaleUp":Z
    :goto_0
    and-int/lit8 v3, p4, 0x2

    if-eqz v3, :cond_3

    const/16 v25, 0x1

    .line 95
    .local v25, "recycle":Z
    :goto_1
    invoke-virtual/range {p1 .. p1}, Landroid/graphics/Bitmap;->getWidth()I

    move-result v3

    sub-int v16, v3, p2

    .line 96
    .local v16, "deltaX":I
    invoke-virtual/range {p1 .. p1}, Landroid/graphics/Bitmap;->getHeight()I

    move-result v3

    sub-int v18, v3, p3

    .line 97
    .local v18, "deltaY":I
    if-nez v27, :cond_4

    if-ltz v16, :cond_0

    if-gez v18, :cond_4

    .line 98
    :cond_0
    sget-object v3, Landroid/graphics/Bitmap$Config;->ARGB_8888:Landroid/graphics/Bitmap$Config;

    move/from16 v0, p2

    move/from16 v1, p3

    invoke-static {v0, v1, v3}, Landroid/graphics/Bitmap;->createBitmap(IILandroid/graphics/Bitmap$Config;)Landroid/graphics/Bitmap;

    move-result-object v11

    .line 99
    .local v11, "b2":Landroid/graphics/Bitmap;
    new-instance v15, Landroid/graphics/Canvas;

    invoke-direct {v15, v11}, Landroid/graphics/Canvas;-><init>(Landroid/graphics/Bitmap;)V

    .line 101
    .local v15, "c":Landroid/graphics/Canvas;
    const/4 v3, 0x0

    div-int/lit8 v4, v16, 0x2

    invoke-static {v3, v4}, Ljava/lang/Math;->max(II)I

    move-result v17

    .line 102
    .local v17, "deltaXHalf":I
    const/4 v3, 0x0

    div-int/lit8 v4, v18, 0x2

    invoke-static {v3, v4}, Ljava/lang/Math;->max(II)I

    move-result v19

    .line 103
    .local v19, "deltaYHalf":I
    new-instance v28, Landroid/graphics/Rect;

    invoke-virtual/range {p1 .. p1}, Landroid/graphics/Bitmap;->getWidth()I

    move-result v3

    move/from16 v0, p2

    invoke-static {v0, v3}, Ljava/lang/Math;->min(II)I

    move-result v3

    add-int v3, v3, v17

    invoke-virtual/range {p1 .. p1}, Landroid/graphics/Bitmap;->getHeight()I

    move-result v4

    move/from16 v0, p3

    invoke-static {v0, v4}, Ljava/lang/Math;->min(II)I

    move-result v4

    add-int v4, v4, v19

    move-object/from16 v0, v28

    move/from16 v1, v17

    move/from16 v2, v19

    invoke-direct {v0, v1, v2, v3, v4}, Landroid/graphics/Rect;-><init>(IIII)V

    .line 104
    .local v28, "src":Landroid/graphics/Rect;
    invoke-virtual/range {v28 .. v28}, Landroid/graphics/Rect;->width()I

    move-result v3

    sub-int v3, p2, v3

    div-int/lit8 v21, v3, 0x2

    .line 105
    .local v21, "dstX":I
    invoke-virtual/range {v28 .. v28}, Landroid/graphics/Rect;->height()I

    move-result v3

    sub-int v3, p3, v3

    div-int/lit8 v22, v3, 0x2

    .line 106
    .local v22, "dstY":I
    new-instance v20, Landroid/graphics/Rect;

    sub-int v3, p2, v21

    sub-int v4, p3, v22

    move-object/from16 v0, v20

    move/from16 v1, v21

    move/from16 v2, v22

    invoke-direct {v0, v1, v2, v3, v4}, Landroid/graphics/Rect;-><init>(IIII)V

    .line 107
    .local v20, "dst":Landroid/graphics/Rect;
    const/4 v3, 0x0

    move-object/from16 v0, p1

    move-object/from16 v1, v28

    move-object/from16 v2, v20

    invoke-virtual {v15, v0, v1, v2, v3}, Landroid/graphics/Canvas;->drawBitmap(Landroid/graphics/Bitmap;Landroid/graphics/Rect;Landroid/graphics/Rect;Landroid/graphics/Paint;)V

    .line 108
    if-eqz v25, :cond_1

    .line 109
    invoke-virtual/range {p1 .. p1}, Landroid/graphics/Bitmap;->recycle()V

    .line 141
    .end local v15    # "c":Landroid/graphics/Canvas;
    .end local v17    # "deltaXHalf":I
    .end local v19    # "deltaYHalf":I
    .end local v20    # "dst":Landroid/graphics/Rect;
    .end local v21    # "dstX":I
    .end local v22    # "dstY":I
    .end local v28    # "src":Landroid/graphics/Rect;
    :cond_1
    :goto_2
    return-object v11

    .line 92
    .end local v11    # "b2":Landroid/graphics/Bitmap;
    .end local v16    # "deltaX":I
    .end local v18    # "deltaY":I
    .end local v25    # "recycle":Z
    .end local v27    # "scaleUp":Z
    :cond_2
    const/16 v27, 0x0

    goto/16 :goto_0

    .line 93
    .restart local v27    # "scaleUp":Z
    :cond_3
    const/16 v25, 0x0

    goto/16 :goto_1

    .line 113
    .restart local v16    # "deltaX":I
    .restart local v18    # "deltaY":I
    .restart local v25    # "recycle":Z
    :cond_4
    invoke-virtual/range {p1 .. p1}, Landroid/graphics/Bitmap;->getWidth()I

    move-result v3

    int-to-float v14, v3

    .line 114
    .local v14, "bitmapWidthF":F
    invoke-virtual/range {p1 .. p1}, Landroid/graphics/Bitmap;->getHeight()I

    move-result v3

    int-to-float v13, v3

    .line 115
    .local v13, "bitmapHeightF":F
    div-float v12, v14, v13

    .line 116
    .local v12, "bitmapAspect":F
    move/from16 v0, p2

    int-to-float v3, v0

    move/from16 v0, p3

    int-to-float v4, v0

    div-float v29, v3, v4

    .line 118
    .local v29, "viewAspect":F
    cmpl-float v3, v12, v29

    if-lez v3, :cond_8

    move/from16 v0, p3

    int-to-float v3, v0

    div-float v26, v3, v13

    .line 119
    .local v26, "scale":F
    :goto_3
    const v3, 0x3f666666    # 0.9f

    cmpg-float v3, v26, v3

    if-ltz v3, :cond_5

    const/high16 v3, 0x3f800000    # 1.0f

    cmpl-float v3, v26, v3

    if-lez v3, :cond_9

    .line 120
    :cond_5
    move-object/from16 v0, p0

    move/from16 v1, v26

    move/from16 v2, v26

    invoke-virtual {v0, v1, v2}, Landroid/graphics/Matrix;->setScale(FF)V

    .line 125
    :goto_4
    if-eqz p0, :cond_a

    .line 126
    const/4 v4, 0x0

    const/4 v5, 0x0

    invoke-virtual/range {p1 .. p1}, Landroid/graphics/Bitmap;->getWidth()I

    move-result v6

    invoke-virtual/range {p1 .. p1}, Landroid/graphics/Bitmap;->getHeight()I

    move-result v7

    const/4 v9, 0x1

    move-object/from16 v3, p1

    move-object/from16 v8, p0

    invoke-static/range {v3 .. v9}, Landroid/graphics/Bitmap;->createBitmap(Landroid/graphics/Bitmap;IIIILandroid/graphics/Matrix;Z)Landroid/graphics/Bitmap;

    move-result-object v10

    .line 130
    .local v10, "b1":Landroid/graphics/Bitmap;
    :goto_5
    if-eqz v25, :cond_6

    move-object/from16 v0, p1

    if-eq v10, v0, :cond_6

    .line 131
    invoke-virtual/range {p1 .. p1}, Landroid/graphics/Bitmap;->recycle()V

    .line 133
    :cond_6
    const/4 v3, 0x0

    invoke-virtual {v10}, Landroid/graphics/Bitmap;->getWidth()I

    move-result v4

    sub-int v4, v4, p2

    invoke-static {v3, v4}, Ljava/lang/Math;->max(II)I

    move-result v23

    .line 134
    .local v23, "dx1":I
    const/4 v3, 0x0

    invoke-virtual {v10}, Landroid/graphics/Bitmap;->getHeight()I

    move-result v4

    sub-int v4, v4, p3

    invoke-static {v3, v4}, Ljava/lang/Math;->max(II)I

    move-result v24

    .line 136
    .local v24, "dy1":I
    div-int/lit8 v3, v23, 0x2

    div-int/lit8 v4, v24, 0x2

    move/from16 v0, p2

    move/from16 v1, p3

    invoke-static {v10, v3, v4, v0, v1}, Landroid/graphics/Bitmap;->createBitmap(Landroid/graphics/Bitmap;IIII)Landroid/graphics/Bitmap;

    move-result-object v11

    .line 138
    .restart local v11    # "b2":Landroid/graphics/Bitmap;
    if-eq v11, v10, :cond_1

    if-nez v25, :cond_7

    move-object/from16 v0, p1

    if-eq v10, v0, :cond_1

    .line 139
    :cond_7
    invoke-virtual {v10}, Landroid/graphics/Bitmap;->recycle()V

    goto/16 :goto_2

    .line 118
    .end local v10    # "b1":Landroid/graphics/Bitmap;
    .end local v11    # "b2":Landroid/graphics/Bitmap;
    .end local v23    # "dx1":I
    .end local v24    # "dy1":I
    .end local v26    # "scale":F
    :cond_8
    move/from16 v0, p2

    int-to-float v3, v0

    div-float v26, v3, v14

    goto :goto_3

    .line 122
    .restart local v26    # "scale":F
    :cond_9
    const/16 p0, 0x0

    goto :goto_4

    .line 128
    :cond_a
    move-object/from16 v10, p1

    .restart local v10    # "b1":Landroid/graphics/Bitmap;
    goto :goto_5
.end method

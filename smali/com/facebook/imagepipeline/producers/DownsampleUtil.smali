.class public Lcom/facebook/imagepipeline/producers/DownsampleUtil;
.super Ljava/lang/Object;
.source "DownsampleUtil.java"


# static fields
.field private static final DEFAULT_SAMPLE_SIZE:I = 0x1

.field private static final INTERVAL_ROUNDING:F = 0.33333334f


# direct methods
.method private constructor <init>()V
    .locals 0

    .prologue
    .line 25
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method

.method static determineDownsampleRatio(Lcom/facebook/imagepipeline/request/ImageRequest;Lcom/facebook/imagepipeline/image/EncodedImage;)F
    .locals 14
    .param p0, "imageRequest"    # Lcom/facebook/imagepipeline/request/ImageRequest;
    .param p1, "encodedImage"    # Lcom/facebook/imagepipeline/image/EncodedImage;
    .annotation build Lcom/facebook/common/internal/VisibleForTesting;
    .end annotation

    .prologue
    const/4 v9, 0x1

    const/4 v8, 0x0

    .line 67
    invoke-static {p1}, Lcom/facebook/imagepipeline/image/EncodedImage;->isMetaDataAvailable(Lcom/facebook/imagepipeline/image/EncodedImage;)Z

    move-result v10

    invoke-static {v10}, Lcom/facebook/common/internal/Preconditions;->checkArgument(Z)V

    .line 68
    invoke-virtual {p0}, Lcom/facebook/imagepipeline/request/ImageRequest;->getResizeOptions()Lcom/facebook/imagepipeline/common/ResizeOptions;

    move-result-object v3

    .line 69
    .local v3, "resizeOptions":Lcom/facebook/imagepipeline/common/ResizeOptions;
    if-eqz v3, :cond_0

    iget v10, v3, Lcom/facebook/imagepipeline/common/ResizeOptions;->height:I

    if-lez v10, :cond_0

    iget v10, v3, Lcom/facebook/imagepipeline/common/ResizeOptions;->width:I

    if-lez v10, :cond_0

    .line 70
    invoke-virtual {p1}, Lcom/facebook/imagepipeline/image/EncodedImage;->getWidth()I

    move-result v10

    if-eqz v10, :cond_0

    invoke-virtual {p1}, Lcom/facebook/imagepipeline/image/EncodedImage;->getHeight()I

    move-result v10

    if-nez v10, :cond_1

    .line 71
    :cond_0
    const/high16 v2, 0x3f800000    # 1.0f

    .line 96
    :goto_0
    return v2

    .line 74
    :cond_1
    invoke-static {p0, p1}, Lcom/facebook/imagepipeline/producers/DownsampleUtil;->getRotationAngle(Lcom/facebook/imagepipeline/request/ImageRequest;Lcom/facebook/imagepipeline/image/EncodedImage;)I

    move-result v4

    .line 75
    .local v4, "rotationAngle":I
    const/16 v10, 0x5a

    if-eq v4, v10, :cond_2

    const/16 v10, 0x10e

    if-ne v4, v10, :cond_3

    :cond_2
    move v5, v9

    .line 76
    .local v5, "swapDimensions":Z
    :goto_1
    if-eqz v5, :cond_4

    .line 77
    invoke-virtual {p1}, Lcom/facebook/imagepipeline/image/EncodedImage;->getHeight()I

    move-result v6

    .line 78
    .local v6, "widthAfterRotation":I
    :goto_2
    if-eqz v5, :cond_5

    .line 79
    invoke-virtual {p1}, Lcom/facebook/imagepipeline/image/EncodedImage;->getWidth()I

    move-result v0

    .line 81
    .local v0, "heightAfterRotation":I
    :goto_3
    iget v10, v3, Lcom/facebook/imagepipeline/common/ResizeOptions;->width:I

    int-to-float v10, v10

    int-to-float v11, v6

    div-float v7, v10, v11

    .line 82
    .local v7, "widthRatio":F
    iget v10, v3, Lcom/facebook/imagepipeline/common/ResizeOptions;->height:I

    int-to-float v10, v10

    int-to-float v11, v0

    div-float v1, v10, v11

    .line 83
    .local v1, "heightRatio":F
    invoke-static {v7, v1}, Ljava/lang/Math;->max(FF)F

    move-result v2

    .line 84
    .local v2, "ratio":F
    const-string v10, "DownsampleUtil"

    const-string v11, "Downsample - Specified size: %dx%d, image size: %dx%d ratio: %.1f x %.1f, ratio: %.3f for %s"

    const/16 v12, 0x8

    new-array v12, v12, [Ljava/lang/Object;

    iget v13, v3, Lcom/facebook/imagepipeline/common/ResizeOptions;->width:I

    .line 88
    invoke-static {v13}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v13

    aput-object v13, v12, v8

    iget v8, v3, Lcom/facebook/imagepipeline/common/ResizeOptions;->height:I

    .line 89
    invoke-static {v8}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v8

    aput-object v8, v12, v9

    const/4 v8, 0x2

    .line 90
    invoke-static {v6}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v9

    aput-object v9, v12, v8

    const/4 v8, 0x3

    .line 91
    invoke-static {v0}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v9

    aput-object v9, v12, v8

    const/4 v8, 0x4

    .line 92
    invoke-static {v7}, Ljava/lang/Float;->valueOf(F)Ljava/lang/Float;

    move-result-object v9

    aput-object v9, v12, v8

    const/4 v8, 0x5

    .line 93
    invoke-static {v1}, Ljava/lang/Float;->valueOf(F)Ljava/lang/Float;

    move-result-object v9

    aput-object v9, v12, v8

    const/4 v8, 0x6

    .line 94
    invoke-static {v2}, Ljava/lang/Float;->valueOf(F)Ljava/lang/Float;

    move-result-object v9

    aput-object v9, v12, v8

    const/4 v8, 0x7

    .line 95
    invoke-virtual {p0}, Lcom/facebook/imagepipeline/request/ImageRequest;->getSourceUri()Landroid/net/Uri;

    move-result-object v9

    invoke-virtual {v9}, Landroid/net/Uri;->toString()Ljava/lang/String;

    move-result-object v9

    aput-object v9, v12, v8

    .line 84
    invoke-static {v10, v11, v12}, Lcom/facebook/common/logging/FLog;->v(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V

    goto :goto_0

    .end local v0    # "heightAfterRotation":I
    .end local v1    # "heightRatio":F
    .end local v2    # "ratio":F
    .end local v5    # "swapDimensions":Z
    .end local v6    # "widthAfterRotation":I
    .end local v7    # "widthRatio":F
    :cond_3
    move v5, v8

    .line 75
    goto :goto_1

    .line 77
    .restart local v5    # "swapDimensions":Z
    :cond_4
    invoke-virtual {p1}, Lcom/facebook/imagepipeline/image/EncodedImage;->getWidth()I

    move-result v6

    goto :goto_2

    .line 79
    .restart local v6    # "widthAfterRotation":I
    :cond_5
    invoke-virtual {p1}, Lcom/facebook/imagepipeline/image/EncodedImage;->getHeight()I

    move-result v0

    goto :goto_3
.end method

.method public static determineSampleSize(Lcom/facebook/imagepipeline/request/ImageRequest;Lcom/facebook/imagepipeline/image/EncodedImage;)I
    .locals 7
    .param p0, "imageRequest"    # Lcom/facebook/imagepipeline/request/ImageRequest;
    .param p1, "encodedImage"    # Lcom/facebook/imagepipeline/image/EncodedImage;

    .prologue
    .line 36
    invoke-static {p1}, Lcom/facebook/imagepipeline/image/EncodedImage;->isMetaDataAvailable(Lcom/facebook/imagepipeline/image/EncodedImage;)Z

    move-result v5

    if-nez v5, :cond_1

    .line 37
    const/4 v4, 0x1

    .line 61
    :cond_0
    return v4

    .line 39
    :cond_1
    invoke-static {p0, p1}, Lcom/facebook/imagepipeline/producers/DownsampleUtil;->determineDownsampleRatio(Lcom/facebook/imagepipeline/request/ImageRequest;Lcom/facebook/imagepipeline/image/EncodedImage;)F

    move-result v2

    .line 41
    .local v2, "ratio":F
    invoke-virtual {p1}, Lcom/facebook/imagepipeline/image/EncodedImage;->getImageFormat()Lcom/facebook/imageformat/ImageFormat;

    move-result-object v5

    sget-object v6, Lcom/facebook/imageformat/DefaultImageFormats;->JPEG:Lcom/facebook/imageformat/ImageFormat;

    if-ne v5, v6, :cond_2

    .line 42
    invoke-static {v2}, Lcom/facebook/imagepipeline/producers/DownsampleUtil;->ratioToSampleSizeJPEG(F)I

    move-result v4

    .line 49
    .local v4, "sampleSize":I
    :goto_0
    invoke-virtual {p1}, Lcom/facebook/imagepipeline/image/EncodedImage;->getHeight()I

    move-result v5

    invoke-virtual {p1}, Lcom/facebook/imagepipeline/image/EncodedImage;->getWidth()I

    move-result v6

    invoke-static {v5, v6}, Ljava/lang/Math;->max(II)I

    move-result v1

    .line 50
    .local v1, "maxDimension":I
    invoke-virtual {p0}, Lcom/facebook/imagepipeline/request/ImageRequest;->getResizeOptions()Lcom/facebook/imagepipeline/common/ResizeOptions;

    move-result-object v3

    .line 51
    .local v3, "resizeOptions":Lcom/facebook/imagepipeline/common/ResizeOptions;
    if-eqz v3, :cond_3

    iget v0, v3, Lcom/facebook/imagepipeline/common/ResizeOptions;->maxBitmapSize:F

    .line 54
    .local v0, "maxBitmapSize":F
    :goto_1
    div-int v5, v1, v4

    int-to-float v5, v5

    cmpl-float v5, v5, v0

    if-lez v5, :cond_0

    .line 55
    invoke-virtual {p1}, Lcom/facebook/imagepipeline/image/EncodedImage;->getImageFormat()Lcom/facebook/imageformat/ImageFormat;

    move-result-object v5

    sget-object v6, Lcom/facebook/imageformat/DefaultImageFormats;->JPEG:Lcom/facebook/imageformat/ImageFormat;

    if-ne v5, v6, :cond_4

    .line 56
    mul-int/lit8 v4, v4, 0x2

    goto :goto_1

    .line 44
    .end local v0    # "maxBitmapSize":F
    .end local v1    # "maxDimension":I
    .end local v3    # "resizeOptions":Lcom/facebook/imagepipeline/common/ResizeOptions;
    .end local v4    # "sampleSize":I
    :cond_2
    invoke-static {v2}, Lcom/facebook/imagepipeline/producers/DownsampleUtil;->ratioToSampleSize(F)I

    move-result v4

    .restart local v4    # "sampleSize":I
    goto :goto_0

    .line 51
    .restart local v1    # "maxDimension":I
    .restart local v3    # "resizeOptions":Lcom/facebook/imagepipeline/common/ResizeOptions;
    :cond_3
    const/high16 v0, 0x45000000    # 2048.0f

    goto :goto_1

    .line 58
    .restart local v0    # "maxBitmapSize":F
    :cond_4
    add-int/lit8 v4, v4, 0x1

    goto :goto_1
.end method

.method private static getRotationAngle(Lcom/facebook/imagepipeline/request/ImageRequest;Lcom/facebook/imagepipeline/image/EncodedImage;)I
    .locals 3
    .param p0, "imageRequest"    # Lcom/facebook/imagepipeline/request/ImageRequest;
    .param p1, "encodedImage"    # Lcom/facebook/imagepipeline/image/EncodedImage;

    .prologue
    const/4 v1, 0x0

    .line 132
    invoke-virtual {p0}, Lcom/facebook/imagepipeline/request/ImageRequest;->getRotationOptions()Lcom/facebook/imagepipeline/common/RotationOptions;

    move-result-object v2

    invoke-virtual {v2}, Lcom/facebook/imagepipeline/common/RotationOptions;->useImageMetadata()Z

    move-result v2

    if-nez v2, :cond_0

    .line 138
    :goto_0
    return v1

    .line 135
    :cond_0
    invoke-virtual {p1}, Lcom/facebook/imagepipeline/image/EncodedImage;->getRotationAngle()I

    move-result v0

    .line 136
    .local v0, "rotationAngle":I
    if-eqz v0, :cond_1

    const/16 v2, 0x5a

    if-eq v0, v2, :cond_1

    const/16 v2, 0xb4

    if-eq v0, v2, :cond_1

    const/16 v2, 0x10e

    if-ne v0, v2, :cond_2

    :cond_1
    const/4 v1, 0x1

    :cond_2
    invoke-static {v1}, Lcom/facebook/common/internal/Preconditions;->checkArgument(Z)V

    move v1, v0

    .line 138
    goto :goto_0
.end method

.method static ratioToSampleSize(F)I
    .locals 12
    .param p0, "ratio"    # F
    .annotation build Lcom/facebook/common/internal/VisibleForTesting;
    .end annotation

    .prologue
    const-wide/high16 v10, 0x3ff0000000000000L    # 1.0

    .line 101
    const v5, 0x3f2aaaab

    cmpl-float v5, p0, v5

    if-lez v5, :cond_0

    .line 102
    const/4 v5, 0x1

    .line 109
    :goto_0
    return v5

    .line 104
    :cond_0
    const/4 v4, 0x2

    .line 106
    .local v4, "sampleSize":I
    :goto_1
    int-to-double v6, v4

    const-wide/high16 v8, 0x4000000000000000L    # 2.0

    invoke-static {v6, v7, v8, v9}, Ljava/lang/Math;->pow(DD)D

    move-result-wide v6

    int-to-double v8, v4

    sub-double/2addr v6, v8

    div-double v2, v10, v6

    .line 107
    .local v2, "intervalLength":D
    int-to-double v6, v4

    div-double v6, v10, v6

    const-wide v8, 0x3fd5555560000000L    # 0.3333333432674408

    mul-double/2addr v8, v2

    add-double v0, v6, v8

    .line 108
    .local v0, "compare":D
    float-to-double v6, p0

    cmpg-double v5, v0, v6

    if-gtz v5, :cond_1

    .line 109
    add-int/lit8 v5, v4, -0x1

    goto :goto_0

    .line 111
    :cond_1
    add-int/lit8 v4, v4, 0x1

    .line 112
    goto :goto_1
.end method

.method static ratioToSampleSizeJPEG(F)I
    .locals 12
    .param p0, "ratio"    # F
    .annotation build Lcom/facebook/common/internal/VisibleForTesting;
    .end annotation

    .prologue
    const-wide/high16 v10, 0x3ff0000000000000L    # 1.0

    .line 117
    const v5, 0x3f2aaaab

    cmpl-float v5, p0, v5

    if-lez v5, :cond_1

    .line 118
    const/4 v4, 0x1

    .line 125
    :cond_0
    return v4

    .line 120
    :cond_1
    const/4 v4, 0x2

    .line 122
    .local v4, "sampleSize":I
    :goto_0
    mul-int/lit8 v5, v4, 0x2

    int-to-double v6, v5

    div-double v2, v10, v6

    .line 123
    .local v2, "intervalLength":D
    mul-int/lit8 v5, v4, 0x2

    int-to-double v6, v5

    div-double v6, v10, v6

    const-wide v8, 0x3fd5555560000000L    # 0.3333333432674408

    mul-double/2addr v8, v2

    add-double v0, v6, v8

    .line 124
    .local v0, "compare":D
    float-to-double v6, p0

    cmpg-double v5, v0, v6

    if-lez v5, :cond_0

    .line 127
    mul-int/lit8 v4, v4, 0x2

    .line 128
    goto :goto_0
.end method

.method static roundToPowerOfTwo(I)I
    .locals 1
    .param p0, "sampleSize"    # I
    .annotation build Lcom/facebook/common/internal/VisibleForTesting;
    .end annotation

    .prologue
    .line 143
    const/4 v0, 0x1

    .line 145
    .local v0, "compare":I
    :goto_0
    if-lt v0, p0, :cond_0

    .line 146
    return v0

    .line 148
    :cond_0
    mul-int/lit8 v0, v0, 0x2

    goto :goto_0
.end method

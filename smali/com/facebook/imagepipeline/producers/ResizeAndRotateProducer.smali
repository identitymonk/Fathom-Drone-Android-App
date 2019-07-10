.class public Lcom/facebook/imagepipeline/producers/ResizeAndRotateProducer;
.super Ljava/lang/Object;
.source "ResizeAndRotateProducer.java"

# interfaces
.implements Lcom/facebook/imagepipeline/producers/Producer;


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lcom/facebook/imagepipeline/producers/ResizeAndRotateProducer$TransformingConsumer;
    }
.end annotation

.annotation system Ldalvik/annotation/Signature;
    value = {
        "Ljava/lang/Object;",
        "Lcom/facebook/imagepipeline/producers/Producer",
        "<",
        "Lcom/facebook/imagepipeline/image/EncodedImage;",
        ">;"
    }
.end annotation


# static fields
.field static final DEFAULT_JPEG_QUALITY:I = 0x55
    .annotation build Lcom/facebook/common/internal/VisibleForTesting;
    .end annotation
.end field

.field private static final DOWNSAMPLE_ENUMERATOR_KEY:Ljava/lang/String; = "downsampleEnumerator"

.field private static final FRACTION_KEY:Ljava/lang/String; = "Fraction"

.field private static final FULL_ROUND:I = 0x168

.field static final MAX_JPEG_SCALE_NUMERATOR:I = 0x8
    .annotation build Lcom/facebook/common/internal/VisibleForTesting;
    .end annotation
.end field

.field static final MIN_TRANSFORM_INTERVAL_MS:I = 0x64
    .annotation build Lcom/facebook/common/internal/VisibleForTesting;
    .end annotation
.end field

.field private static final ORIGINAL_SIZE_KEY:Ljava/lang/String; = "Original size"

.field public static final PRODUCER_NAME:Ljava/lang/String; = "ResizeAndRotateProducer"

.field private static final REQUESTED_SIZE_KEY:Ljava/lang/String; = "Requested size"

.field private static final ROTATION_ANGLE_KEY:Ljava/lang/String; = "rotationAngle"

.field private static final SOFTWARE_ENUMERATOR_KEY:Ljava/lang/String; = "softwareEnumerator"


# instance fields
.field private final mExecutor:Ljava/util/concurrent/Executor;

.field private final mInputProducer:Lcom/facebook/imagepipeline/producers/Producer;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Lcom/facebook/imagepipeline/producers/Producer",
            "<",
            "Lcom/facebook/imagepipeline/image/EncodedImage;",
            ">;"
        }
    .end annotation
.end field

.field private final mPooledByteBufferFactory:Lcom/facebook/common/memory/PooledByteBufferFactory;

.field private final mResizingEnabled:Z

.field private final mUseDownsamplingRatio:Z


# direct methods
.method public constructor <init>(Ljava/util/concurrent/Executor;Lcom/facebook/common/memory/PooledByteBufferFactory;ZLcom/facebook/imagepipeline/producers/Producer;Z)V
    .locals 1
    .param p1, "executor"    # Ljava/util/concurrent/Executor;
    .param p2, "pooledByteBufferFactory"    # Lcom/facebook/common/memory/PooledByteBufferFactory;
    .param p3, "resizingEnabled"    # Z
    .param p5, "useDownsamplingRatio"    # Z
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/util/concurrent/Executor;",
            "Lcom/facebook/common/memory/PooledByteBufferFactory;",
            "Z",
            "Lcom/facebook/imagepipeline/producers/Producer",
            "<",
            "Lcom/facebook/imagepipeline/image/EncodedImage;",
            ">;Z)V"
        }
    .end annotation

    .prologue
    .line 70
    .local p4, "inputProducer":Lcom/facebook/imagepipeline/producers/Producer;, "Lcom/facebook/imagepipeline/producers/Producer<Lcom/facebook/imagepipeline/image/EncodedImage;>;"
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 71
    invoke-static {p1}, Lcom/facebook/common/internal/Preconditions;->checkNotNull(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Ljava/util/concurrent/Executor;

    iput-object v0, p0, Lcom/facebook/imagepipeline/producers/ResizeAndRotateProducer;->mExecutor:Ljava/util/concurrent/Executor;

    .line 72
    invoke-static {p2}, Lcom/facebook/common/internal/Preconditions;->checkNotNull(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/facebook/common/memory/PooledByteBufferFactory;

    iput-object v0, p0, Lcom/facebook/imagepipeline/producers/ResizeAndRotateProducer;->mPooledByteBufferFactory:Lcom/facebook/common/memory/PooledByteBufferFactory;

    .line 73
    iput-boolean p3, p0, Lcom/facebook/imagepipeline/producers/ResizeAndRotateProducer;->mResizingEnabled:Z

    .line 74
    invoke-static {p4}, Lcom/facebook/common/internal/Preconditions;->checkNotNull(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/facebook/imagepipeline/producers/Producer;

    iput-object v0, p0, Lcom/facebook/imagepipeline/producers/ResizeAndRotateProducer;->mInputProducer:Lcom/facebook/imagepipeline/producers/Producer;

    .line 75
    iput-boolean p5, p0, Lcom/facebook/imagepipeline/producers/ResizeAndRotateProducer;->mUseDownsamplingRatio:Z

    .line 76
    return-void
.end method

.method static synthetic access$100(Lcom/facebook/imagepipeline/producers/ResizeAndRotateProducer;)Ljava/util/concurrent/Executor;
    .locals 1
    .param p0, "x0"    # Lcom/facebook/imagepipeline/producers/ResizeAndRotateProducer;

    .prologue
    .line 45
    iget-object v0, p0, Lcom/facebook/imagepipeline/producers/ResizeAndRotateProducer;->mExecutor:Ljava/util/concurrent/Executor;

    return-object v0
.end method

.method static synthetic access$1000(Lcom/facebook/imagepipeline/common/RotationOptions;Lcom/facebook/imagepipeline/image/EncodedImage;)I
    .locals 1
    .param p0, "x0"    # Lcom/facebook/imagepipeline/common/RotationOptions;
    .param p1, "x1"    # Lcom/facebook/imagepipeline/image/EncodedImage;

    .prologue
    .line 45
    invoke-static {p0, p1}, Lcom/facebook/imagepipeline/producers/ResizeAndRotateProducer;->getRotationAngle(Lcom/facebook/imagepipeline/common/RotationOptions;Lcom/facebook/imagepipeline/image/EncodedImage;)I

    move-result v0

    return v0
.end method

.method static synthetic access$500(Lcom/facebook/imagepipeline/producers/ResizeAndRotateProducer;)Z
    .locals 1
    .param p0, "x0"    # Lcom/facebook/imagepipeline/producers/ResizeAndRotateProducer;

    .prologue
    .line 45
    iget-boolean v0, p0, Lcom/facebook/imagepipeline/producers/ResizeAndRotateProducer;->mResizingEnabled:Z

    return v0
.end method

.method static synthetic access$600(Lcom/facebook/imagepipeline/request/ImageRequest;Lcom/facebook/imagepipeline/image/EncodedImage;Z)Lcom/facebook/common/util/TriState;
    .locals 1
    .param p0, "x0"    # Lcom/facebook/imagepipeline/request/ImageRequest;
    .param p1, "x1"    # Lcom/facebook/imagepipeline/image/EncodedImage;
    .param p2, "x2"    # Z

    .prologue
    .line 45
    invoke-static {p0, p1, p2}, Lcom/facebook/imagepipeline/producers/ResizeAndRotateProducer;->shouldTransform(Lcom/facebook/imagepipeline/request/ImageRequest;Lcom/facebook/imagepipeline/image/EncodedImage;Z)Lcom/facebook/common/util/TriState;

    move-result-object v0

    return-object v0
.end method

.method static synthetic access$700(Lcom/facebook/imagepipeline/producers/ResizeAndRotateProducer;)Lcom/facebook/common/memory/PooledByteBufferFactory;
    .locals 1
    .param p0, "x0"    # Lcom/facebook/imagepipeline/producers/ResizeAndRotateProducer;

    .prologue
    .line 45
    iget-object v0, p0, Lcom/facebook/imagepipeline/producers/ResizeAndRotateProducer;->mPooledByteBufferFactory:Lcom/facebook/common/memory/PooledByteBufferFactory;

    return-object v0
.end method

.method static synthetic access$800(Lcom/facebook/imagepipeline/request/ImageRequest;Lcom/facebook/imagepipeline/image/EncodedImage;Z)I
    .locals 1
    .param p0, "x0"    # Lcom/facebook/imagepipeline/request/ImageRequest;
    .param p1, "x1"    # Lcom/facebook/imagepipeline/image/EncodedImage;
    .param p2, "x2"    # Z

    .prologue
    .line 45
    invoke-static {p0, p1, p2}, Lcom/facebook/imagepipeline/producers/ResizeAndRotateProducer;->getSoftwareNumerator(Lcom/facebook/imagepipeline/request/ImageRequest;Lcom/facebook/imagepipeline/image/EncodedImage;Z)I

    move-result v0

    return v0
.end method

.method static synthetic access$900(Lcom/facebook/imagepipeline/producers/ResizeAndRotateProducer;)Z
    .locals 1
    .param p0, "x0"    # Lcom/facebook/imagepipeline/producers/ResizeAndRotateProducer;

    .prologue
    .line 45
    iget-boolean v0, p0, Lcom/facebook/imagepipeline/producers/ResizeAndRotateProducer;->mUseDownsamplingRatio:Z

    return v0
.end method

.method static calculateDownsampleNumerator(I)I
    .locals 2
    .param p0, "downsampleRatio"    # I
    .annotation build Lcom/facebook/common/internal/VisibleForTesting;
    .end annotation

    .prologue
    .line 356
    const/4 v0, 0x1

    const/16 v1, 0x8

    div-int/2addr v1, p0

    invoke-static {v0, v1}, Ljava/lang/Math;->max(II)I

    move-result v0

    return v0
.end method

.method static determineResizeRatio(Lcom/facebook/imagepipeline/common/ResizeOptions;II)F
    .locals 5
    .param p0, "resizeOptions"    # Lcom/facebook/imagepipeline/common/ResizeOptions;
    .param p1, "width"    # I
    .param p2, "height"    # I
    .annotation build Lcom/facebook/common/internal/VisibleForTesting;
    .end annotation

    .prologue
    .line 271
    if-nez p0, :cond_1

    .line 272
    const/high16 v1, 0x3f800000    # 1.0f

    .line 285
    :cond_0
    :goto_0
    return v1

    .line 275
    :cond_1
    iget v3, p0, Lcom/facebook/imagepipeline/common/ResizeOptions;->width:I

    int-to-float v3, v3

    int-to-float v4, p1

    div-float v2, v3, v4

    .line 276
    .local v2, "widthRatio":F
    iget v3, p0, Lcom/facebook/imagepipeline/common/ResizeOptions;->height:I

    int-to-float v3, v3

    int-to-float v4, p2

    div-float v0, v3, v4

    .line 277
    .local v0, "heightRatio":F
    invoke-static {v2, v0}, Ljava/lang/Math;->max(FF)F

    move-result v1

    .line 279
    .local v1, "ratio":F
    int-to-float v3, p1

    mul-float/2addr v3, v1

    iget v4, p0, Lcom/facebook/imagepipeline/common/ResizeOptions;->maxBitmapSize:F

    cmpl-float v3, v3, v4

    if-lez v3, :cond_2

    .line 280
    iget v3, p0, Lcom/facebook/imagepipeline/common/ResizeOptions;->maxBitmapSize:F

    int-to-float v4, p1

    div-float v1, v3, v4

    .line 282
    :cond_2
    int-to-float v3, p2

    mul-float/2addr v3, v1

    iget v4, p0, Lcom/facebook/imagepipeline/common/ResizeOptions;->maxBitmapSize:F

    cmpl-float v3, v3, v4

    if-lez v3, :cond_0

    .line 283
    iget v3, p0, Lcom/facebook/imagepipeline/common/ResizeOptions;->maxBitmapSize:F

    int-to-float v4, p2

    div-float v1, v3, v4

    goto :goto_0
.end method

.method private static extractOrientationFromMetadata(Lcom/facebook/imagepipeline/image/EncodedImage;)I
    .locals 1
    .param p0, "encodedImage"    # Lcom/facebook/imagepipeline/image/EncodedImage;

    .prologue
    .line 331
    invoke-virtual {p0}, Lcom/facebook/imagepipeline/image/EncodedImage;->getRotationAngle()I

    move-result v0

    sparse-switch v0, :sswitch_data_0

    .line 337
    const/4 v0, 0x0

    :goto_0
    return v0

    .line 335
    :sswitch_0
    invoke-virtual {p0}, Lcom/facebook/imagepipeline/image/EncodedImage;->getRotationAngle()I

    move-result v0

    goto :goto_0

    .line 331
    :sswitch_data_0
    .sparse-switch
        0x5a -> :sswitch_0
        0xb4 -> :sswitch_0
        0x10e -> :sswitch_0
    .end sparse-switch
.end method

.method private static getRotationAngle(Lcom/facebook/imagepipeline/common/RotationOptions;Lcom/facebook/imagepipeline/image/EncodedImage;)I
    .locals 2
    .param p0, "rotationOptions"    # Lcom/facebook/imagepipeline/common/RotationOptions;
    .param p1, "encodedImage"    # Lcom/facebook/imagepipeline/image/EncodedImage;

    .prologue
    .line 320
    invoke-virtual {p0}, Lcom/facebook/imagepipeline/common/RotationOptions;->rotationEnabled()Z

    move-result v1

    if-nez v1, :cond_1

    .line 321
    const/4 v0, 0x0

    .line 327
    :cond_0
    :goto_0
    return v0

    .line 323
    :cond_1
    invoke-static {p1}, Lcom/facebook/imagepipeline/producers/ResizeAndRotateProducer;->extractOrientationFromMetadata(Lcom/facebook/imagepipeline/image/EncodedImage;)I

    move-result v0

    .line 324
    .local v0, "rotationFromMetadata":I
    invoke-virtual {p0}, Lcom/facebook/imagepipeline/common/RotationOptions;->useImageMetadata()Z

    move-result v1

    if-nez v1, :cond_0

    .line 327
    invoke-virtual {p0}, Lcom/facebook/imagepipeline/common/RotationOptions;->getForcedAngle()I

    move-result v1

    add-int/2addr v1, v0

    rem-int/lit16 v0, v1, 0x168

    goto :goto_0
.end method

.method private static getSoftwareNumerator(Lcom/facebook/imagepipeline/request/ImageRequest;Lcom/facebook/imagepipeline/image/EncodedImage;Z)I
    .locals 10
    .param p0, "imageRequest"    # Lcom/facebook/imagepipeline/request/ImageRequest;
    .param p1, "encodedImage"    # Lcom/facebook/imagepipeline/image/EncodedImage;
    .param p2, "resizingEnabled"    # Z

    .prologue
    const/4 v7, 0x1

    const/16 v8, 0x8

    .line 296
    if-nez p2, :cond_1

    move v1, v8

    .line 316
    :cond_0
    :goto_0
    return v1

    .line 299
    :cond_1
    invoke-virtual {p0}, Lcom/facebook/imagepipeline/request/ImageRequest;->getResizeOptions()Lcom/facebook/imagepipeline/common/ResizeOptions;

    move-result-object v3

    .line 300
    .local v3, "resizeOptions":Lcom/facebook/imagepipeline/common/ResizeOptions;
    if-nez v3, :cond_2

    move v1, v8

    .line 301
    goto :goto_0

    .line 304
    :cond_2
    invoke-virtual {p0}, Lcom/facebook/imagepipeline/request/ImageRequest;->getRotationOptions()Lcom/facebook/imagepipeline/common/RotationOptions;

    move-result-object v9

    invoke-static {v9, p1}, Lcom/facebook/imagepipeline/producers/ResizeAndRotateProducer;->getRotationAngle(Lcom/facebook/imagepipeline/common/RotationOptions;Lcom/facebook/imagepipeline/image/EncodedImage;)I

    move-result v4

    .line 305
    .local v4, "rotationAngle":I
    const/16 v9, 0x5a

    if-eq v4, v9, :cond_3

    const/16 v9, 0x10e

    if-ne v4, v9, :cond_4

    :cond_3
    move v5, v7

    .line 306
    .local v5, "swapDimensions":Z
    :goto_1
    if-eqz v5, :cond_5

    invoke-virtual {p1}, Lcom/facebook/imagepipeline/image/EncodedImage;->getHeight()I

    move-result v6

    .line 308
    .local v6, "widthAfterRotation":I
    :goto_2
    if-eqz v5, :cond_6

    invoke-virtual {p1}, Lcom/facebook/imagepipeline/image/EncodedImage;->getWidth()I

    move-result v0

    .line 311
    .local v0, "heightAfterRotation":I
    :goto_3
    invoke-static {v3, v6, v0}, Lcom/facebook/imagepipeline/producers/ResizeAndRotateProducer;->determineResizeRatio(Lcom/facebook/imagepipeline/common/ResizeOptions;II)F

    move-result v2

    .line 312
    .local v2, "ratio":F
    iget v9, v3, Lcom/facebook/imagepipeline/common/ResizeOptions;->roundUpFraction:F

    invoke-static {v2, v9}, Lcom/facebook/imagepipeline/producers/ResizeAndRotateProducer;->roundNumerator(FF)I

    move-result v1

    .line 313
    .local v1, "numerator":I
    if-le v1, v8, :cond_7

    move v1, v8

    .line 314
    goto :goto_0

    .line 305
    .end local v0    # "heightAfterRotation":I
    .end local v1    # "numerator":I
    .end local v2    # "ratio":F
    .end local v5    # "swapDimensions":Z
    .end local v6    # "widthAfterRotation":I
    :cond_4
    const/4 v5, 0x0

    goto :goto_1

    .line 307
    .restart local v5    # "swapDimensions":Z
    :cond_5
    invoke-virtual {p1}, Lcom/facebook/imagepipeline/image/EncodedImage;->getWidth()I

    move-result v6

    goto :goto_2

    .line 309
    .restart local v6    # "widthAfterRotation":I
    :cond_6
    invoke-virtual {p1}, Lcom/facebook/imagepipeline/image/EncodedImage;->getHeight()I

    move-result v0

    goto :goto_3

    .line 316
    .restart local v0    # "heightAfterRotation":I
    .restart local v1    # "numerator":I
    .restart local v2    # "ratio":F
    :cond_7
    if-ge v1, v7, :cond_0

    move v1, v7

    goto :goto_0
.end method

.method static roundNumerator(FF)I
    .locals 1
    .param p0, "maxRatio"    # F
    .param p1, "roundUpFraction"    # F
    .annotation build Lcom/facebook/common/internal/VisibleForTesting;
    .end annotation

    .prologue
    .line 289
    const/high16 v0, 0x41000000    # 8.0f

    mul-float/2addr v0, p0

    add-float/2addr v0, p1

    float-to-int v0, v0

    return v0
.end method

.method private static shouldResize(I)Z
    .locals 1
    .param p0, "numerator"    # I

    .prologue
    .line 342
    const/16 v0, 0x8

    if-ge p0, v0, :cond_0

    const/4 v0, 0x1

    :goto_0
    return v0

    :cond_0
    const/4 v0, 0x0

    goto :goto_0
.end method

.method private static shouldRotate(Lcom/facebook/imagepipeline/common/RotationOptions;Lcom/facebook/imagepipeline/image/EncodedImage;)Z
    .locals 1
    .param p0, "rotationOptions"    # Lcom/facebook/imagepipeline/common/RotationOptions;
    .param p1, "encodedImage"    # Lcom/facebook/imagepipeline/image/EncodedImage;

    .prologue
    .line 346
    invoke-virtual {p0}, Lcom/facebook/imagepipeline/common/RotationOptions;->canDeferUntilRendered()Z

    move-result v0

    if-nez v0, :cond_0

    .line 347
    invoke-static {p0, p1}, Lcom/facebook/imagepipeline/producers/ResizeAndRotateProducer;->getRotationAngle(Lcom/facebook/imagepipeline/common/RotationOptions;Lcom/facebook/imagepipeline/image/EncodedImage;)I

    move-result v0

    if-eqz v0, :cond_0

    const/4 v0, 0x1

    :goto_0
    return v0

    :cond_0
    const/4 v0, 0x0

    goto :goto_0
.end method

.method private static shouldTransform(Lcom/facebook/imagepipeline/request/ImageRequest;Lcom/facebook/imagepipeline/image/EncodedImage;Z)Lcom/facebook/common/util/TriState;
    .locals 2
    .param p0, "request"    # Lcom/facebook/imagepipeline/request/ImageRequest;
    .param p1, "encodedImage"    # Lcom/facebook/imagepipeline/image/EncodedImage;
    .param p2, "resizingEnabled"    # Z

    .prologue
    .line 255
    if-eqz p1, :cond_0

    invoke-virtual {p1}, Lcom/facebook/imagepipeline/image/EncodedImage;->getImageFormat()Lcom/facebook/imageformat/ImageFormat;

    move-result-object v0

    sget-object v1, Lcom/facebook/imageformat/ImageFormat;->UNKNOWN:Lcom/facebook/imageformat/ImageFormat;

    if-ne v0, v1, :cond_1

    .line 256
    :cond_0
    sget-object v0, Lcom/facebook/common/util/TriState;->UNSET:Lcom/facebook/common/util/TriState;

    .line 261
    :goto_0
    return-object v0

    .line 258
    :cond_1
    invoke-virtual {p1}, Lcom/facebook/imagepipeline/image/EncodedImage;->getImageFormat()Lcom/facebook/imageformat/ImageFormat;

    move-result-object v0

    sget-object v1, Lcom/facebook/imageformat/DefaultImageFormats;->JPEG:Lcom/facebook/imageformat/ImageFormat;

    if-eq v0, v1, :cond_2

    .line 259
    sget-object v0, Lcom/facebook/common/util/TriState;->NO:Lcom/facebook/common/util/TriState;

    goto :goto_0

    .line 262
    :cond_2
    invoke-virtual {p0}, Lcom/facebook/imagepipeline/request/ImageRequest;->getRotationOptions()Lcom/facebook/imagepipeline/common/RotationOptions;

    move-result-object v0

    invoke-static {v0, p1}, Lcom/facebook/imagepipeline/producers/ResizeAndRotateProducer;->shouldRotate(Lcom/facebook/imagepipeline/common/RotationOptions;Lcom/facebook/imagepipeline/image/EncodedImage;)Z

    move-result v0

    if-nez v0, :cond_3

    .line 263
    invoke-static {p0, p1, p2}, Lcom/facebook/imagepipeline/producers/ResizeAndRotateProducer;->getSoftwareNumerator(Lcom/facebook/imagepipeline/request/ImageRequest;Lcom/facebook/imagepipeline/image/EncodedImage;Z)I

    move-result v0

    invoke-static {v0}, Lcom/facebook/imagepipeline/producers/ResizeAndRotateProducer;->shouldResize(I)Z

    move-result v0

    if-eqz v0, :cond_4

    :cond_3
    const/4 v0, 0x1

    .line 261
    :goto_1
    invoke-static {v0}, Lcom/facebook/common/util/TriState;->valueOf(Z)Lcom/facebook/common/util/TriState;

    move-result-object v0

    goto :goto_0

    .line 263
    :cond_4
    const/4 v0, 0x0

    goto :goto_1
.end method


# virtual methods
.method public produceResults(Lcom/facebook/imagepipeline/producers/Consumer;Lcom/facebook/imagepipeline/producers/ProducerContext;)V
    .locals 2
    .param p2, "context"    # Lcom/facebook/imagepipeline/producers/ProducerContext;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Lcom/facebook/imagepipeline/producers/Consumer",
            "<",
            "Lcom/facebook/imagepipeline/image/EncodedImage;",
            ">;",
            "Lcom/facebook/imagepipeline/producers/ProducerContext;",
            ")V"
        }
    .end annotation

    .prologue
    .line 82
    .local p1, "consumer":Lcom/facebook/imagepipeline/producers/Consumer;, "Lcom/facebook/imagepipeline/producers/Consumer<Lcom/facebook/imagepipeline/image/EncodedImage;>;"
    iget-object v0, p0, Lcom/facebook/imagepipeline/producers/ResizeAndRotateProducer;->mInputProducer:Lcom/facebook/imagepipeline/producers/Producer;

    new-instance v1, Lcom/facebook/imagepipeline/producers/ResizeAndRotateProducer$TransformingConsumer;

    invoke-direct {v1, p0, p1, p2}, Lcom/facebook/imagepipeline/producers/ResizeAndRotateProducer$TransformingConsumer;-><init>(Lcom/facebook/imagepipeline/producers/ResizeAndRotateProducer;Lcom/facebook/imagepipeline/producers/Consumer;Lcom/facebook/imagepipeline/producers/ProducerContext;)V

    invoke-interface {v0, v1, p2}, Lcom/facebook/imagepipeline/producers/Producer;->produceResults(Lcom/facebook/imagepipeline/producers/Consumer;Lcom/facebook/imagepipeline/producers/ProducerContext;)V

    .line 83
    return-void
.end method

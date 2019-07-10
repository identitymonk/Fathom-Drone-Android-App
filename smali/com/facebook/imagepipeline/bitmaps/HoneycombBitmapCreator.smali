.class public Lcom/facebook/imagepipeline/bitmaps/HoneycombBitmapCreator;
.super Ljava/lang/Object;
.source "HoneycombBitmapCreator.java"

# interfaces
.implements Lcom/facebook/common/webp/BitmapCreator;


# instance fields
.field private final mFlexByteArrayPool:Lcom/facebook/imagepipeline/memory/FlexByteArrayPool;

.field private final mJpegGenerator:Lcom/facebook/imagepipeline/bitmaps/EmptyJpegGenerator;


# direct methods
.method public constructor <init>(Lcom/facebook/imagepipeline/memory/PoolFactory;)V
    .locals 2
    .param p1, "poolFactory"    # Lcom/facebook/imagepipeline/memory/PoolFactory;

    .prologue
    .line 33
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 34
    invoke-virtual {p1}, Lcom/facebook/imagepipeline/memory/PoolFactory;->getFlexByteArrayPool()Lcom/facebook/imagepipeline/memory/FlexByteArrayPool;

    move-result-object v0

    iput-object v0, p0, Lcom/facebook/imagepipeline/bitmaps/HoneycombBitmapCreator;->mFlexByteArrayPool:Lcom/facebook/imagepipeline/memory/FlexByteArrayPool;

    .line 35
    new-instance v0, Lcom/facebook/imagepipeline/bitmaps/EmptyJpegGenerator;

    invoke-virtual {p1}, Lcom/facebook/imagepipeline/memory/PoolFactory;->getPooledByteBufferFactory()Lcom/facebook/common/memory/PooledByteBufferFactory;

    move-result-object v1

    invoke-direct {v0, v1}, Lcom/facebook/imagepipeline/bitmaps/EmptyJpegGenerator;-><init>(Lcom/facebook/common/memory/PooledByteBufferFactory;)V

    iput-object v0, p0, Lcom/facebook/imagepipeline/bitmaps/HoneycombBitmapCreator;->mJpegGenerator:Lcom/facebook/imagepipeline/bitmaps/EmptyJpegGenerator;

    .line 36
    return-void
.end method

.method private static getBitmapFactoryOptions(ILandroid/graphics/Bitmap$Config;)Landroid/graphics/BitmapFactory$Options;
    .locals 4
    .param p0, "sampleSize"    # I
    .param p1, "bitmapConfig"    # Landroid/graphics/Bitmap$Config;

    .prologue
    const/4 v3, 0x1

    .line 77
    new-instance v0, Landroid/graphics/BitmapFactory$Options;

    invoke-direct {v0}, Landroid/graphics/BitmapFactory$Options;-><init>()V

    .line 78
    .local v0, "options":Landroid/graphics/BitmapFactory$Options;
    iput-boolean v3, v0, Landroid/graphics/BitmapFactory$Options;->inDither:Z

    .line 79
    iput-object p1, v0, Landroid/graphics/BitmapFactory$Options;->inPreferredConfig:Landroid/graphics/Bitmap$Config;

    .line 81
    iput-boolean v3, v0, Landroid/graphics/BitmapFactory$Options;->inPurgeable:Z

    .line 83
    iput-boolean v3, v0, Landroid/graphics/BitmapFactory$Options;->inInputShareable:Z

    .line 85
    iput p0, v0, Landroid/graphics/BitmapFactory$Options;->inSampleSize:I

    .line 86
    sget v1, Landroid/os/Build$VERSION;->SDK_INT:I

    const/16 v2, 0xb

    if-lt v1, v2, :cond_0

    .line 87
    iput-boolean v3, v0, Landroid/graphics/BitmapFactory$Options;->inMutable:Z

    .line 89
    :cond_0
    return-object v0
.end method


# virtual methods
.method public createNakedBitmap(IILandroid/graphics/Bitmap$Config;)Landroid/graphics/Bitmap;
    .locals 12
    .param p1, "width"    # I
    .param p2, "height"    # I
    .param p3, "bitmapConfig"    # Landroid/graphics/Bitmap$Config;
    .annotation build Landroid/annotation/TargetApi;
        value = 0xc
    .end annotation

    .prologue
    .line 42
    iget-object v9, p0, Lcom/facebook/imagepipeline/bitmaps/HoneycombBitmapCreator;->mJpegGenerator:Lcom/facebook/imagepipeline/bitmaps/EmptyJpegGenerator;

    int-to-short v10, p1

    int-to-short v11, p2

    invoke-virtual {v9, v10, v11}, Lcom/facebook/imagepipeline/bitmaps/EmptyJpegGenerator;->generate(SS)Lcom/facebook/common/references/CloseableReference;

    move-result-object v5

    .line 45
    .local v5, "jpgRef":Lcom/facebook/common/references/CloseableReference;, "Lcom/facebook/common/references/CloseableReference<Lcom/facebook/common/memory/PooledByteBuffer;>;"
    const/4 v3, 0x0

    .line 46
    .local v3, "encodedImage":Lcom/facebook/imagepipeline/image/EncodedImage;
    const/4 v2, 0x0

    .line 48
    .local v2, "encodedBytesArrayRef":Lcom/facebook/common/references/CloseableReference;, "Lcom/facebook/common/references/CloseableReference<[B>;"
    :try_start_0
    new-instance v4, Lcom/facebook/imagepipeline/image/EncodedImage;

    invoke-direct {v4, v5}, Lcom/facebook/imagepipeline/image/EncodedImage;-><init>(Lcom/facebook/common/references/CloseableReference;)V
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    .line 49
    .end local v3    # "encodedImage":Lcom/facebook/imagepipeline/image/EncodedImage;
    .local v4, "encodedImage":Lcom/facebook/imagepipeline/image/EncodedImage;
    :try_start_1
    sget-object v9, Lcom/facebook/imageformat/DefaultImageFormats;->JPEG:Lcom/facebook/imageformat/ImageFormat;

    invoke-virtual {v4, v9}, Lcom/facebook/imagepipeline/image/EncodedImage;->setImageFormat(Lcom/facebook/imageformat/ImageFormat;)V

    .line 51
    invoke-virtual {v4}, Lcom/facebook/imagepipeline/image/EncodedImage;->getSampleSize()I

    move-result v9

    .line 50
    invoke-static {v9, p3}, Lcom/facebook/imagepipeline/bitmaps/HoneycombBitmapCreator;->getBitmapFactoryOptions(ILandroid/graphics/Bitmap$Config;)Landroid/graphics/BitmapFactory$Options;

    move-result-object v7

    .line 53
    .local v7, "options":Landroid/graphics/BitmapFactory$Options;
    invoke-virtual {v5}, Lcom/facebook/common/references/CloseableReference;->get()Ljava/lang/Object;

    move-result-object v9

    check-cast v9, Lcom/facebook/common/memory/PooledByteBuffer;

    invoke-interface {v9}, Lcom/facebook/common/memory/PooledByteBuffer;->size()I

    move-result v6

    .line 54
    .local v6, "length":I
    invoke-virtual {v5}, Lcom/facebook/common/references/CloseableReference;->get()Ljava/lang/Object;

    move-result-object v8

    check-cast v8, Lcom/facebook/common/memory/PooledByteBuffer;

    .line 55
    .local v8, "pooledByteBuffer":Lcom/facebook/common/memory/PooledByteBuffer;
    iget-object v9, p0, Lcom/facebook/imagepipeline/bitmaps/HoneycombBitmapCreator;->mFlexByteArrayPool:Lcom/facebook/imagepipeline/memory/FlexByteArrayPool;

    add-int/lit8 v10, v6, 0x2

    .line 56
    invoke-virtual {v9, v10}, Lcom/facebook/imagepipeline/memory/FlexByteArrayPool;->get(I)Lcom/facebook/common/references/CloseableReference;

    move-result-object v2

    .line 57
    invoke-virtual {v2}, Lcom/facebook/common/references/CloseableReference;->get()Ljava/lang/Object;

    move-result-object v1

    check-cast v1, [B

    .line 58
    .local v1, "encodedBytesArray":[B
    const/4 v9, 0x0

    const/4 v10, 0x0

    invoke-interface {v8, v9, v1, v10, v6}, Lcom/facebook/common/memory/PooledByteBuffer;->read(I[BII)V

    .line 59
    const/4 v9, 0x0

    invoke-static {v1, v9, v6, v7}, Landroid/graphics/BitmapFactory;->decodeByteArray([BIILandroid/graphics/BitmapFactory$Options;)Landroid/graphics/Bitmap;

    move-result-object v0

    .line 64
    .local v0, "bitmap":Landroid/graphics/Bitmap;
    const/4 v9, 0x1

    invoke-virtual {v0, v9}, Landroid/graphics/Bitmap;->setHasAlpha(Z)V

    .line 65
    const/4 v9, 0x0

    invoke-virtual {v0, v9}, Landroid/graphics/Bitmap;->eraseColor(I)V
    :try_end_1
    .catchall {:try_start_1 .. :try_end_1} :catchall_1

    .line 68
    invoke-static {v2}, Lcom/facebook/common/references/CloseableReference;->closeSafely(Lcom/facebook/common/references/CloseableReference;)V

    .line 69
    invoke-static {v4}, Lcom/facebook/imagepipeline/image/EncodedImage;->closeSafely(Lcom/facebook/imagepipeline/image/EncodedImage;)V

    .line 70
    invoke-static {v5}, Lcom/facebook/common/references/CloseableReference;->closeSafely(Lcom/facebook/common/references/CloseableReference;)V

    return-object v0

    .line 68
    .end local v0    # "bitmap":Landroid/graphics/Bitmap;
    .end local v1    # "encodedBytesArray":[B
    .end local v4    # "encodedImage":Lcom/facebook/imagepipeline/image/EncodedImage;
    .end local v6    # "length":I
    .end local v7    # "options":Landroid/graphics/BitmapFactory$Options;
    .end local v8    # "pooledByteBuffer":Lcom/facebook/common/memory/PooledByteBuffer;
    .restart local v3    # "encodedImage":Lcom/facebook/imagepipeline/image/EncodedImage;
    :catchall_0
    move-exception v9

    :goto_0
    invoke-static {v2}, Lcom/facebook/common/references/CloseableReference;->closeSafely(Lcom/facebook/common/references/CloseableReference;)V

    .line 69
    invoke-static {v3}, Lcom/facebook/imagepipeline/image/EncodedImage;->closeSafely(Lcom/facebook/imagepipeline/image/EncodedImage;)V

    .line 70
    invoke-static {v5}, Lcom/facebook/common/references/CloseableReference;->closeSafely(Lcom/facebook/common/references/CloseableReference;)V

    throw v9

    .line 68
    .end local v3    # "encodedImage":Lcom/facebook/imagepipeline/image/EncodedImage;
    .restart local v4    # "encodedImage":Lcom/facebook/imagepipeline/image/EncodedImage;
    :catchall_1
    move-exception v9

    move-object v3, v4

    .end local v4    # "encodedImage":Lcom/facebook/imagepipeline/image/EncodedImage;
    .restart local v3    # "encodedImage":Lcom/facebook/imagepipeline/image/EncodedImage;
    goto :goto_0
.end method

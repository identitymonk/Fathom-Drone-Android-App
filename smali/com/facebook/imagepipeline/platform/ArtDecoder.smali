.class public Lcom/facebook/imagepipeline/platform/ArtDecoder;
.super Ljava/lang/Object;
.source "ArtDecoder.java"

# interfaces
.implements Lcom/facebook/imagepipeline/platform/PlatformDecoder;


# annotations
.annotation build Landroid/annotation/TargetApi;
    value = 0x15
.end annotation

.annotation build Ljavax/annotation/concurrent/ThreadSafe;
.end annotation


# static fields
.field private static final DECODE_BUFFER_SIZE:I = 0x4000

.field private static final EOI_TAIL:[B


# instance fields
.field private final mBitmapPool:Lcom/facebook/imagepipeline/memory/BitmapPool;

.field final mDecodeBuffers:Landroid/support/v4/util/Pools$SynchronizedPool;
    .annotation build Lcom/facebook/common/internal/VisibleForTesting;
    .end annotation

    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Landroid/support/v4/util/Pools$SynchronizedPool",
            "<",
            "Ljava/nio/ByteBuffer;",
            ">;"
        }
    .end annotation
.end field


# direct methods
.method static constructor <clinit>()V
    .locals 1

    .prologue
    .line 54
    const/4 v0, 0x2

    new-array v0, v0, [B

    fill-array-data v0, :array_0

    sput-object v0, Lcom/facebook/imagepipeline/platform/ArtDecoder;->EOI_TAIL:[B

    return-void

    nop

    :array_0
    .array-data 1
        -0x1t
        -0x27t
    .end array-data
.end method

.method public constructor <init>(Lcom/facebook/imagepipeline/memory/BitmapPool;ILandroid/support/v4/util/Pools$SynchronizedPool;)V
    .locals 3
    .param p1, "bitmapPool"    # Lcom/facebook/imagepipeline/memory/BitmapPool;
    .param p2, "maxNumThreads"    # I
    .param p3, "decodeBuffers"    # Landroid/support/v4/util/Pools$SynchronizedPool;

    .prologue
    .line 58
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 59
    iput-object p1, p0, Lcom/facebook/imagepipeline/platform/ArtDecoder;->mBitmapPool:Lcom/facebook/imagepipeline/memory/BitmapPool;

    .line 60
    iput-object p3, p0, Lcom/facebook/imagepipeline/platform/ArtDecoder;->mDecodeBuffers:Landroid/support/v4/util/Pools$SynchronizedPool;

    .line 61
    const/4 v0, 0x0

    .local v0, "i":I
    :goto_0
    if-ge v0, p2, :cond_0

    .line 62
    iget-object v1, p0, Lcom/facebook/imagepipeline/platform/ArtDecoder;->mDecodeBuffers:Landroid/support/v4/util/Pools$SynchronizedPool;

    const/16 v2, 0x4000

    invoke-static {v2}, Ljava/nio/ByteBuffer;->allocate(I)Ljava/nio/ByteBuffer;

    move-result-object v2

    invoke-virtual {v1, v2}, Landroid/support/v4/util/Pools$SynchronizedPool;->release(Ljava/lang/Object;)Z

    .line 61
    add-int/lit8 v0, v0, 0x1

    goto :goto_0

    .line 64
    :cond_0
    return-void
.end method

.method private static getDecodeOptionsForStream(Lcom/facebook/imagepipeline/image/EncodedImage;Landroid/graphics/Bitmap$Config;)Landroid/graphics/BitmapFactory$Options;
    .locals 5
    .param p0, "encodedImage"    # Lcom/facebook/imagepipeline/image/EncodedImage;
    .param p1, "bitmapConfig"    # Landroid/graphics/Bitmap$Config;

    .prologue
    const/4 v4, -0x1

    const/4 v3, 0x1

    .line 173
    new-instance v0, Landroid/graphics/BitmapFactory$Options;

    invoke-direct {v0}, Landroid/graphics/BitmapFactory$Options;-><init>()V

    .line 175
    .local v0, "options":Landroid/graphics/BitmapFactory$Options;
    invoke-virtual {p0}, Lcom/facebook/imagepipeline/image/EncodedImage;->getSampleSize()I

    move-result v1

    iput v1, v0, Landroid/graphics/BitmapFactory$Options;->inSampleSize:I

    .line 176
    iput-boolean v3, v0, Landroid/graphics/BitmapFactory$Options;->inJustDecodeBounds:Z

    .line 178
    invoke-virtual {p0}, Lcom/facebook/imagepipeline/image/EncodedImage;->getInputStream()Ljava/io/InputStream;

    move-result-object v1

    const/4 v2, 0x0

    invoke-static {v1, v2, v0}, Landroid/graphics/BitmapFactory;->decodeStream(Ljava/io/InputStream;Landroid/graphics/Rect;Landroid/graphics/BitmapFactory$Options;)Landroid/graphics/Bitmap;

    .line 179
    iget v1, v0, Landroid/graphics/BitmapFactory$Options;->outWidth:I

    if-eq v1, v4, :cond_0

    iget v1, v0, Landroid/graphics/BitmapFactory$Options;->outHeight:I

    if-ne v1, v4, :cond_1

    .line 180
    :cond_0
    new-instance v1, Ljava/lang/IllegalArgumentException;

    invoke-direct {v1}, Ljava/lang/IllegalArgumentException;-><init>()V

    throw v1

    .line 183
    :cond_1
    const/4 v1, 0x0

    iput-boolean v1, v0, Landroid/graphics/BitmapFactory$Options;->inJustDecodeBounds:Z

    .line 184
    iput-boolean v3, v0, Landroid/graphics/BitmapFactory$Options;->inDither:Z

    .line 185
    iput-object p1, v0, Landroid/graphics/BitmapFactory$Options;->inPreferredConfig:Landroid/graphics/Bitmap$Config;

    .line 186
    iput-boolean v3, v0, Landroid/graphics/BitmapFactory$Options;->inMutable:Z

    .line 188
    return-object v0
.end method


# virtual methods
.method public decodeFromEncodedImage(Lcom/facebook/imagepipeline/image/EncodedImage;Landroid/graphics/Bitmap$Config;)Lcom/facebook/common/references/CloseableReference;
    .locals 5
    .param p1, "encodedImage"    # Lcom/facebook/imagepipeline/image/EncodedImage;
    .param p2, "bitmapConfig"    # Landroid/graphics/Bitmap$Config;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Lcom/facebook/imagepipeline/image/EncodedImage;",
            "Landroid/graphics/Bitmap$Config;",
            ")",
            "Lcom/facebook/common/references/CloseableReference",
            "<",
            "Landroid/graphics/Bitmap;",
            ">;"
        }
    .end annotation

    .prologue
    .line 78
    invoke-static {p1, p2}, Lcom/facebook/imagepipeline/platform/ArtDecoder;->getDecodeOptionsForStream(Lcom/facebook/imagepipeline/image/EncodedImage;Landroid/graphics/Bitmap$Config;)Landroid/graphics/BitmapFactory$Options;

    move-result-object v0

    .line 79
    .local v0, "options":Landroid/graphics/BitmapFactory$Options;
    iget-object v3, v0, Landroid/graphics/BitmapFactory$Options;->inPreferredConfig:Landroid/graphics/Bitmap$Config;

    sget-object v4, Landroid/graphics/Bitmap$Config;->ARGB_8888:Landroid/graphics/Bitmap$Config;

    if-eq v3, v4, :cond_0

    const/4 v2, 0x1

    .line 81
    .local v2, "retryOnFail":Z
    :goto_0
    :try_start_0
    invoke-virtual {p1}, Lcom/facebook/imagepipeline/image/EncodedImage;->getInputStream()Ljava/io/InputStream;

    move-result-object v3

    invoke-virtual {p0, v3, v0}, Lcom/facebook/imagepipeline/platform/ArtDecoder;->decodeStaticImageFromStream(Ljava/io/InputStream;Landroid/graphics/BitmapFactory$Options;)Lcom/facebook/common/references/CloseableReference;
    :try_end_0
    .catch Ljava/lang/RuntimeException; {:try_start_0 .. :try_end_0} :catch_0

    move-result-object v3

    .line 84
    :goto_1
    return-object v3

    .line 79
    .end local v2    # "retryOnFail":Z
    :cond_0
    const/4 v2, 0x0

    goto :goto_0

    .line 82
    .restart local v2    # "retryOnFail":Z
    :catch_0
    move-exception v1

    .line 83
    .local v1, "re":Ljava/lang/RuntimeException;
    if-eqz v2, :cond_1

    .line 84
    sget-object v3, Landroid/graphics/Bitmap$Config;->ARGB_8888:Landroid/graphics/Bitmap$Config;

    invoke-virtual {p0, p1, v3}, Lcom/facebook/imagepipeline/platform/ArtDecoder;->decodeFromEncodedImage(Lcom/facebook/imagepipeline/image/EncodedImage;Landroid/graphics/Bitmap$Config;)Lcom/facebook/common/references/CloseableReference;

    move-result-object v3

    goto :goto_1

    .line 86
    :cond_1
    throw v1
.end method

.method public decodeJPEGFromEncodedImage(Lcom/facebook/imagepipeline/image/EncodedImage;Landroid/graphics/Bitmap$Config;I)Lcom/facebook/common/references/CloseableReference;
    .locals 8
    .param p1, "encodedImage"    # Lcom/facebook/imagepipeline/image/EncodedImage;
    .param p2, "bitmapConfig"    # Landroid/graphics/Bitmap$Config;
    .param p3, "length"    # I
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Lcom/facebook/imagepipeline/image/EncodedImage;",
            "Landroid/graphics/Bitmap$Config;",
            "I)",
            "Lcom/facebook/common/references/CloseableReference",
            "<",
            "Landroid/graphics/Bitmap;",
            ">;"
        }
    .end annotation

    .prologue
    .line 104
    invoke-virtual {p1, p3}, Lcom/facebook/imagepipeline/image/EncodedImage;->isCompleteAt(I)Z

    move-result v0

    .line 105
    .local v0, "isJpegComplete":Z
    invoke-static {p1, p2}, Lcom/facebook/imagepipeline/platform/ArtDecoder;->getDecodeOptionsForStream(Lcom/facebook/imagepipeline/image/EncodedImage;Landroid/graphics/Bitmap$Config;)Landroid/graphics/BitmapFactory$Options;

    move-result-object v3

    .line 107
    .local v3, "options":Landroid/graphics/BitmapFactory$Options;
    invoke-virtual {p1}, Lcom/facebook/imagepipeline/image/EncodedImage;->getInputStream()Ljava/io/InputStream;

    move-result-object v1

    .line 111
    .local v1, "jpegDataStream":Ljava/io/InputStream;
    invoke-static {v1}, Lcom/facebook/common/internal/Preconditions;->checkNotNull(Ljava/lang/Object;)Ljava/lang/Object;

    .line 112
    invoke-virtual {p1}, Lcom/facebook/imagepipeline/image/EncodedImage;->getSize()I

    move-result v6

    if-le v6, p3, :cond_3

    .line 113
    new-instance v2, Lcom/facebook/common/streams/LimitedInputStream;

    invoke-direct {v2, v1, p3}, Lcom/facebook/common/streams/LimitedInputStream;-><init>(Ljava/io/InputStream;I)V

    .line 115
    .end local v1    # "jpegDataStream":Ljava/io/InputStream;
    .local v2, "jpegDataStream":Ljava/io/InputStream;
    :goto_0
    if-nez v0, :cond_2

    .line 116
    new-instance v1, Lcom/facebook/common/streams/TailAppendingInputStream;

    sget-object v6, Lcom/facebook/imagepipeline/platform/ArtDecoder;->EOI_TAIL:[B

    invoke-direct {v1, v2, v6}, Lcom/facebook/common/streams/TailAppendingInputStream;-><init>(Ljava/io/InputStream;[B)V

    .line 118
    .end local v2    # "jpegDataStream":Ljava/io/InputStream;
    .restart local v1    # "jpegDataStream":Ljava/io/InputStream;
    :goto_1
    iget-object v6, v3, Landroid/graphics/BitmapFactory$Options;->inPreferredConfig:Landroid/graphics/Bitmap$Config;

    sget-object v7, Landroid/graphics/Bitmap$Config;->ARGB_8888:Landroid/graphics/Bitmap$Config;

    if-eq v6, v7, :cond_0

    const/4 v5, 0x1

    .line 120
    .local v5, "retryOnFail":Z
    :goto_2
    :try_start_0
    invoke-virtual {p0, v1, v3}, Lcom/facebook/imagepipeline/platform/ArtDecoder;->decodeStaticImageFromStream(Ljava/io/InputStream;Landroid/graphics/BitmapFactory$Options;)Lcom/facebook/common/references/CloseableReference;
    :try_end_0
    .catch Ljava/lang/RuntimeException; {:try_start_0 .. :try_end_0} :catch_0

    move-result-object v6

    .line 123
    :goto_3
    return-object v6

    .line 118
    .end local v5    # "retryOnFail":Z
    :cond_0
    const/4 v5, 0x0

    goto :goto_2

    .line 121
    .restart local v5    # "retryOnFail":Z
    :catch_0
    move-exception v4

    .line 122
    .local v4, "re":Ljava/lang/RuntimeException;
    if-eqz v5, :cond_1

    .line 123
    sget-object v6, Landroid/graphics/Bitmap$Config;->ARGB_8888:Landroid/graphics/Bitmap$Config;

    invoke-virtual {p0, p1, v6}, Lcom/facebook/imagepipeline/platform/ArtDecoder;->decodeFromEncodedImage(Lcom/facebook/imagepipeline/image/EncodedImage;Landroid/graphics/Bitmap$Config;)Lcom/facebook/common/references/CloseableReference;

    move-result-object v6

    goto :goto_3

    .line 125
    :cond_1
    throw v4

    .end local v1    # "jpegDataStream":Ljava/io/InputStream;
    .end local v4    # "re":Ljava/lang/RuntimeException;
    .end local v5    # "retryOnFail":Z
    .restart local v2    # "jpegDataStream":Ljava/io/InputStream;
    :cond_2
    move-object v1, v2

    .end local v2    # "jpegDataStream":Ljava/io/InputStream;
    .restart local v1    # "jpegDataStream":Ljava/io/InputStream;
    goto :goto_1

    :cond_3
    move-object v2, v1

    .end local v1    # "jpegDataStream":Ljava/io/InputStream;
    .restart local v2    # "jpegDataStream":Ljava/io/InputStream;
    goto :goto_0
.end method

.method protected decodeStaticImageFromStream(Ljava/io/InputStream;Landroid/graphics/BitmapFactory$Options;)Lcom/facebook/common/references/CloseableReference;
    .locals 8
    .param p1, "inputStream"    # Ljava/io/InputStream;
    .param p2, "options"    # Landroid/graphics/BitmapFactory$Options;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/io/InputStream;",
            "Landroid/graphics/BitmapFactory$Options;",
            ")",
            "Lcom/facebook/common/references/CloseableReference",
            "<",
            "Landroid/graphics/Bitmap;",
            ">;"
        }
    .end annotation

    .prologue
    .line 132
    invoke-static {p1}, Lcom/facebook/common/internal/Preconditions;->checkNotNull(Ljava/lang/Object;)Ljava/lang/Object;

    .line 133
    iget v5, p2, Landroid/graphics/BitmapFactory$Options;->outWidth:I

    iget v6, p2, Landroid/graphics/BitmapFactory$Options;->outHeight:I

    iget-object v7, p2, Landroid/graphics/BitmapFactory$Options;->inPreferredConfig:Landroid/graphics/Bitmap$Config;

    invoke-static {v5, v6, v7}, Lcom/facebook/imageutils/BitmapUtil;->getSizeInByteForBitmap(IILandroid/graphics/Bitmap$Config;)I

    move-result v4

    .line 137
    .local v4, "sizeInBytes":I
    iget-object v5, p0, Lcom/facebook/imagepipeline/platform/ArtDecoder;->mBitmapPool:Lcom/facebook/imagepipeline/memory/BitmapPool;

    invoke-virtual {v5, v4}, Lcom/facebook/imagepipeline/memory/BitmapPool;->get(I)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Landroid/graphics/Bitmap;

    .line 138
    .local v0, "bitmapToReuse":Landroid/graphics/Bitmap;
    if-nez v0, :cond_0

    .line 139
    new-instance v5, Ljava/lang/NullPointerException;

    const-string v6, "BitmapPool.get returned null"

    invoke-direct {v5, v6}, Ljava/lang/NullPointerException;-><init>(Ljava/lang/String;)V

    throw v5

    .line 141
    :cond_0
    iput-object v0, p2, Landroid/graphics/BitmapFactory$Options;->inBitmap:Landroid/graphics/Bitmap;

    .line 144
    iget-object v5, p0, Lcom/facebook/imagepipeline/platform/ArtDecoder;->mDecodeBuffers:Landroid/support/v4/util/Pools$SynchronizedPool;

    invoke-virtual {v5}, Landroid/support/v4/util/Pools$SynchronizedPool;->acquire()Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Ljava/nio/ByteBuffer;

    .line 145
    .local v1, "byteBuffer":Ljava/nio/ByteBuffer;
    if-nez v1, :cond_1

    .line 146
    const/16 v5, 0x4000

    invoke-static {v5}, Ljava/nio/ByteBuffer;->allocate(I)Ljava/nio/ByteBuffer;

    move-result-object v1

    .line 149
    :cond_1
    :try_start_0
    invoke-virtual {v1}, Ljava/nio/ByteBuffer;->array()[B

    move-result-object v5

    iput-object v5, p2, Landroid/graphics/BitmapFactory$Options;->inTempStorage:[B

    .line 150
    const/4 v5, 0x0

    invoke-static {p1, v5, p2}, Landroid/graphics/BitmapFactory;->decodeStream(Ljava/io/InputStream;Landroid/graphics/Rect;Landroid/graphics/BitmapFactory$Options;)Landroid/graphics/Bitmap;
    :try_end_0
    .catch Ljava/lang/RuntimeException; {:try_start_0 .. :try_end_0} :catch_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    move-result-object v2

    .line 155
    .local v2, "decodedBitmap":Landroid/graphics/Bitmap;
    iget-object v5, p0, Lcom/facebook/imagepipeline/platform/ArtDecoder;->mDecodeBuffers:Landroid/support/v4/util/Pools$SynchronizedPool;

    invoke-virtual {v5, v1}, Landroid/support/v4/util/Pools$SynchronizedPool;->release(Ljava/lang/Object;)Z

    .line 158
    if-eq v0, v2, :cond_2

    .line 159
    iget-object v5, p0, Lcom/facebook/imagepipeline/platform/ArtDecoder;->mBitmapPool:Lcom/facebook/imagepipeline/memory/BitmapPool;

    invoke-virtual {v5, v0}, Lcom/facebook/imagepipeline/memory/BitmapPool;->release(Ljava/lang/Object;)V

    .line 160
    invoke-virtual {v2}, Landroid/graphics/Bitmap;->recycle()V

    .line 161
    new-instance v5, Ljava/lang/IllegalStateException;

    invoke-direct {v5}, Ljava/lang/IllegalStateException;-><init>()V

    throw v5

    .line 151
    .end local v2    # "decodedBitmap":Landroid/graphics/Bitmap;
    :catch_0
    move-exception v3

    .line 152
    .local v3, "re":Ljava/lang/RuntimeException;
    :try_start_1
    iget-object v5, p0, Lcom/facebook/imagepipeline/platform/ArtDecoder;->mBitmapPool:Lcom/facebook/imagepipeline/memory/BitmapPool;

    invoke-virtual {v5, v0}, Lcom/facebook/imagepipeline/memory/BitmapPool;->release(Ljava/lang/Object;)V

    .line 153
    throw v3
    :try_end_1
    .catchall {:try_start_1 .. :try_end_1} :catchall_0

    .line 155
    .end local v3    # "re":Ljava/lang/RuntimeException;
    :catchall_0
    move-exception v5

    iget-object v6, p0, Lcom/facebook/imagepipeline/platform/ArtDecoder;->mDecodeBuffers:Landroid/support/v4/util/Pools$SynchronizedPool;

    invoke-virtual {v6, v1}, Landroid/support/v4/util/Pools$SynchronizedPool;->release(Ljava/lang/Object;)Z

    throw v5

    .line 164
    .restart local v2    # "decodedBitmap":Landroid/graphics/Bitmap;
    :cond_2
    iget-object v5, p0, Lcom/facebook/imagepipeline/platform/ArtDecoder;->mBitmapPool:Lcom/facebook/imagepipeline/memory/BitmapPool;

    invoke-static {v2, v5}, Lcom/facebook/common/references/CloseableReference;->of(Ljava/lang/Object;Lcom/facebook/common/references/ResourceReleaser;)Lcom/facebook/common/references/CloseableReference;

    move-result-object v5

    return-object v5
.end method

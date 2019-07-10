.class public Lcom/facebook/imagepipeline/nativecode/Bitmaps;
.super Ljava/lang/Object;
.source "Bitmaps.java"


# annotations
.annotation build Lcom/facebook/common/internal/DoNotStrip;
.end annotation


# direct methods
.method static constructor <clinit>()V
    .locals 0

    .prologue
    .line 31
    invoke-static {}, Lcom/facebook/imagepipeline/nativecode/ImagePipelineNativeLoader;->load()V

    .line 32
    return-void
.end method

.method public constructor <init>()V
    .locals 0

    .prologue
    .line 28
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method

.method public static copyBitmap(Landroid/graphics/Bitmap;Landroid/graphics/Bitmap;)V
    .locals 4
    .param p0, "dest"    # Landroid/graphics/Bitmap;
    .param p1, "src"    # Landroid/graphics/Bitmap;

    .prologue
    const/4 v1, 0x1

    const/4 v2, 0x0

    .line 70
    invoke-virtual {p1}, Landroid/graphics/Bitmap;->getConfig()Landroid/graphics/Bitmap$Config;

    move-result-object v0

    invoke-virtual {p0}, Landroid/graphics/Bitmap;->getConfig()Landroid/graphics/Bitmap$Config;

    move-result-object v3

    if-ne v0, v3, :cond_0

    move v0, v1

    :goto_0
    invoke-static {v0}, Lcom/facebook/common/internal/Preconditions;->checkArgument(Z)V

    .line 71
    invoke-virtual {p0}, Landroid/graphics/Bitmap;->isMutable()Z

    move-result v0

    invoke-static {v0}, Lcom/facebook/common/internal/Preconditions;->checkArgument(Z)V

    .line 72
    invoke-virtual {p0}, Landroid/graphics/Bitmap;->getWidth()I

    move-result v0

    invoke-virtual {p1}, Landroid/graphics/Bitmap;->getWidth()I

    move-result v3

    if-ne v0, v3, :cond_1

    move v0, v1

    :goto_1
    invoke-static {v0}, Lcom/facebook/common/internal/Preconditions;->checkArgument(Z)V

    .line 73
    invoke-virtual {p0}, Landroid/graphics/Bitmap;->getHeight()I

    move-result v0

    invoke-virtual {p1}, Landroid/graphics/Bitmap;->getHeight()I

    move-result v3

    if-ne v0, v3, :cond_2

    :goto_2
    invoke-static {v1}, Lcom/facebook/common/internal/Preconditions;->checkArgument(Z)V

    .line 76
    invoke-virtual {p0}, Landroid/graphics/Bitmap;->getRowBytes()I

    move-result v0

    .line 78
    invoke-virtual {p1}, Landroid/graphics/Bitmap;->getRowBytes()I

    move-result v1

    .line 79
    invoke-virtual {p0}, Landroid/graphics/Bitmap;->getHeight()I

    move-result v2

    .line 74
    invoke-static {p0, v0, p1, v1, v2}, Lcom/facebook/imagepipeline/nativecode/Bitmaps;->nativeCopyBitmap(Landroid/graphics/Bitmap;ILandroid/graphics/Bitmap;II)V

    .line 80
    return-void

    :cond_0
    move v0, v2

    .line 70
    goto :goto_0

    :cond_1
    move v0, v2

    .line 72
    goto :goto_1

    :cond_2
    move v1, v2

    .line 73
    goto :goto_2
.end method

.method public static getByteBuffer(Landroid/graphics/Bitmap;JJ)Ljava/nio/ByteBuffer;
    .locals 1
    .param p0, "bitmap"    # Landroid/graphics/Bitmap;
    .param p1, "start"    # J
    .param p3, "size"    # J

    .prologue
    .line 48
    invoke-static {p0}, Lcom/facebook/common/internal/Preconditions;->checkNotNull(Ljava/lang/Object;)Ljava/lang/Object;

    .line 49
    invoke-static {p0, p1, p2, p3, p4}, Lcom/facebook/imagepipeline/nativecode/Bitmaps;->nativeGetByteBuffer(Landroid/graphics/Bitmap;JJ)Ljava/nio/ByteBuffer;

    move-result-object v0

    return-object v0
.end method

.method private static native nativeCopyBitmap(Landroid/graphics/Bitmap;ILandroid/graphics/Bitmap;II)V
    .annotation build Lcom/facebook/common/internal/DoNotStrip;
    .end annotation
.end method

.method private static native nativeGetByteBuffer(Landroid/graphics/Bitmap;JJ)Ljava/nio/ByteBuffer;
    .annotation build Lcom/facebook/common/internal/DoNotStrip;
    .end annotation
.end method

.method private static native nativePinBitmap(Landroid/graphics/Bitmap;)V
    .annotation build Lcom/facebook/common/internal/DoNotStrip;
    .end annotation
.end method

.method private static native nativeReleaseByteBuffer(Landroid/graphics/Bitmap;)V
    .annotation build Lcom/facebook/common/internal/DoNotStrip;
    .end annotation
.end method

.method public static pinBitmap(Landroid/graphics/Bitmap;)V
    .locals 0
    .param p0, "bitmap"    # Landroid/graphics/Bitmap;

    .prologue
    .line 43
    invoke-static {p0}, Lcom/facebook/common/internal/Preconditions;->checkNotNull(Ljava/lang/Object;)Ljava/lang/Object;

    .line 44
    invoke-static {p0}, Lcom/facebook/imagepipeline/nativecode/Bitmaps;->nativePinBitmap(Landroid/graphics/Bitmap;)V

    .line 45
    return-void
.end method

.method public static reconfigureBitmap(Landroid/graphics/Bitmap;IILandroid/graphics/Bitmap$Config;)V
    .locals 3
    .param p0, "bitmap"    # Landroid/graphics/Bitmap;
    .param p1, "width"    # I
    .param p2, "height"    # I
    .param p3, "bitmapConfig"    # Landroid/graphics/Bitmap$Config;
    .annotation build Landroid/annotation/TargetApi;
        value = 0x13
    .end annotation

    .prologue
    .line 95
    .line 96
    invoke-virtual {p0}, Landroid/graphics/Bitmap;->getAllocationByteCount()I

    move-result v0

    mul-int v1, p1, p2

    .line 97
    invoke-static {p3}, Lcom/facebook/imageutils/BitmapUtil;->getPixelSizeForBitmapConfig(Landroid/graphics/Bitmap$Config;)I

    move-result v2

    mul-int/2addr v1, v2

    if-lt v0, v1, :cond_0

    const/4 v0, 0x1

    .line 95
    :goto_0
    invoke-static {v0}, Lcom/facebook/common/internal/Preconditions;->checkArgument(Z)V

    .line 98
    invoke-virtual {p0, p1, p2, p3}, Landroid/graphics/Bitmap;->reconfigure(IILandroid/graphics/Bitmap$Config;)V

    .line 99
    return-void

    .line 97
    :cond_0
    const/4 v0, 0x0

    goto :goto_0
.end method

.method public static releaseByteBuffer(Landroid/graphics/Bitmap;)V
    .locals 0
    .param p0, "bitmap"    # Landroid/graphics/Bitmap;

    .prologue
    .line 53
    invoke-static {p0}, Lcom/facebook/common/internal/Preconditions;->checkNotNull(Ljava/lang/Object;)Ljava/lang/Object;

    .line 54
    invoke-static {p0}, Lcom/facebook/imagepipeline/nativecode/Bitmaps;->nativeReleaseByteBuffer(Landroid/graphics/Bitmap;)V

    .line 55
    return-void
.end method

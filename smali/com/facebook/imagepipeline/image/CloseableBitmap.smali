.class public abstract Lcom/facebook/imagepipeline/image/CloseableBitmap;
.super Lcom/facebook/imagepipeline/image/CloseableImage;
.source "CloseableBitmap.java"


# direct methods
.method public constructor <init>()V
    .locals 0

    .prologue
    .line 16
    invoke-direct {p0}, Lcom/facebook/imagepipeline/image/CloseableImage;-><init>()V

    return-void
.end method


# virtual methods
.method public abstract getUnderlyingBitmap()Landroid/graphics/Bitmap;
.end method

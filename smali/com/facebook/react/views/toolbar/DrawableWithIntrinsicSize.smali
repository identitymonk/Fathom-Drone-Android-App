.class public Lcom/facebook/react/views/toolbar/DrawableWithIntrinsicSize;
.super Lcom/facebook/drawee/drawable/ForwardingDrawable;
.source "DrawableWithIntrinsicSize.java"

# interfaces
.implements Landroid/graphics/drawable/Drawable$Callback;


# instance fields
.field private final mImageInfo:Lcom/facebook/imagepipeline/image/ImageInfo;


# direct methods
.method public constructor <init>(Landroid/graphics/drawable/Drawable;Lcom/facebook/imagepipeline/image/ImageInfo;)V
    .locals 0
    .param p1, "drawable"    # Landroid/graphics/drawable/Drawable;
    .param p2, "imageInfo"    # Lcom/facebook/imagepipeline/image/ImageInfo;

    .prologue
    .line 35
    invoke-direct {p0, p1}, Lcom/facebook/drawee/drawable/ForwardingDrawable;-><init>(Landroid/graphics/drawable/Drawable;)V

    .line 36
    iput-object p2, p0, Lcom/facebook/react/views/toolbar/DrawableWithIntrinsicSize;->mImageInfo:Lcom/facebook/imagepipeline/image/ImageInfo;

    .line 37
    return-void
.end method


# virtual methods
.method public getIntrinsicHeight()I
    .locals 1

    .prologue
    .line 46
    iget-object v0, p0, Lcom/facebook/react/views/toolbar/DrawableWithIntrinsicSize;->mImageInfo:Lcom/facebook/imagepipeline/image/ImageInfo;

    invoke-interface {v0}, Lcom/facebook/imagepipeline/image/ImageInfo;->getHeight()I

    move-result v0

    return v0
.end method

.method public getIntrinsicWidth()I
    .locals 1

    .prologue
    .line 41
    iget-object v0, p0, Lcom/facebook/react/views/toolbar/DrawableWithIntrinsicSize;->mImageInfo:Lcom/facebook/imagepipeline/image/ImageInfo;

    invoke-interface {v0}, Lcom/facebook/imagepipeline/image/ImageInfo;->getWidth()I

    move-result v0

    return v0
.end method

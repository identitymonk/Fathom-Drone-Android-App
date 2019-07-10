.class Lcom/facebook/drawee/backends/pipeline/PipelineDraweeController$1;
.super Ljava/lang/Object;
.source "PipelineDraweeController.java"

# interfaces
.implements Lcom/facebook/drawee/backends/pipeline/DrawableFactory;


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/facebook/drawee/backends/pipeline/PipelineDraweeController;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$0:Lcom/facebook/drawee/backends/pipeline/PipelineDraweeController;


# direct methods
.method constructor <init>(Lcom/facebook/drawee/backends/pipeline/PipelineDraweeController;)V
    .locals 0
    .param p1, "this$0"    # Lcom/facebook/drawee/backends/pipeline/PipelineDraweeController;

    .prologue
    .line 70
    iput-object p1, p0, Lcom/facebook/drawee/backends/pipeline/PipelineDraweeController$1;->this$0:Lcom/facebook/drawee/backends/pipeline/PipelineDraweeController;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public createDrawable(Lcom/facebook/imagepipeline/image/CloseableImage;)Landroid/graphics/drawable/Drawable;
    .locals 4
    .param p1, "closeableImage"    # Lcom/facebook/imagepipeline/image/CloseableImage;

    .prologue
    .line 79
    instance-of v2, p1, Lcom/facebook/imagepipeline/image/CloseableStaticBitmap;

    if-eqz v2, :cond_2

    move-object v1, p1

    .line 80
    check-cast v1, Lcom/facebook/imagepipeline/image/CloseableStaticBitmap;

    .line 81
    .local v1, "closeableStaticBitmap":Lcom/facebook/imagepipeline/image/CloseableStaticBitmap;
    new-instance v0, Landroid/graphics/drawable/BitmapDrawable;

    iget-object v2, p0, Lcom/facebook/drawee/backends/pipeline/PipelineDraweeController$1;->this$0:Lcom/facebook/drawee/backends/pipeline/PipelineDraweeController;

    .line 82
    invoke-static {v2}, Lcom/facebook/drawee/backends/pipeline/PipelineDraweeController;->access$000(Lcom/facebook/drawee/backends/pipeline/PipelineDraweeController;)Landroid/content/res/Resources;

    move-result-object v2

    .line 83
    invoke-virtual {v1}, Lcom/facebook/imagepipeline/image/CloseableStaticBitmap;->getUnderlyingBitmap()Landroid/graphics/Bitmap;

    move-result-object v3

    invoke-direct {v0, v2, v3}, Landroid/graphics/drawable/BitmapDrawable;-><init>(Landroid/content/res/Resources;Landroid/graphics/Bitmap;)V

    .line 84
    .local v0, "bitmapDrawable":Landroid/graphics/drawable/Drawable;
    invoke-virtual {v1}, Lcom/facebook/imagepipeline/image/CloseableStaticBitmap;->getRotationAngle()I

    move-result v2

    if-eqz v2, :cond_0

    .line 85
    invoke-virtual {v1}, Lcom/facebook/imagepipeline/image/CloseableStaticBitmap;->getRotationAngle()I

    move-result v2

    const/4 v3, -0x1

    if-ne v2, v3, :cond_1

    .line 93
    .end local v0    # "bitmapDrawable":Landroid/graphics/drawable/Drawable;
    .end local v1    # "closeableStaticBitmap":Lcom/facebook/imagepipeline/image/CloseableStaticBitmap;
    :cond_0
    :goto_0
    return-object v0

    .line 88
    .restart local v0    # "bitmapDrawable":Landroid/graphics/drawable/Drawable;
    .restart local v1    # "closeableStaticBitmap":Lcom/facebook/imagepipeline/image/CloseableStaticBitmap;
    :cond_1
    new-instance v2, Lcom/facebook/drawee/drawable/OrientedDrawable;

    invoke-virtual {v1}, Lcom/facebook/imagepipeline/image/CloseableStaticBitmap;->getRotationAngle()I

    move-result v3

    invoke-direct {v2, v0, v3}, Lcom/facebook/drawee/drawable/OrientedDrawable;-><init>(Landroid/graphics/drawable/Drawable;I)V

    move-object v0, v2

    goto :goto_0

    .line 90
    .end local v0    # "bitmapDrawable":Landroid/graphics/drawable/Drawable;
    .end local v1    # "closeableStaticBitmap":Lcom/facebook/imagepipeline/image/CloseableStaticBitmap;
    :cond_2
    iget-object v2, p0, Lcom/facebook/drawee/backends/pipeline/PipelineDraweeController$1;->this$0:Lcom/facebook/drawee/backends/pipeline/PipelineDraweeController;

    invoke-static {v2}, Lcom/facebook/drawee/backends/pipeline/PipelineDraweeController;->access$100(Lcom/facebook/drawee/backends/pipeline/PipelineDraweeController;)Lcom/facebook/imagepipeline/animated/factory/AnimatedDrawableFactory;

    move-result-object v2

    if-eqz v2, :cond_3

    .line 91
    iget-object v2, p0, Lcom/facebook/drawee/backends/pipeline/PipelineDraweeController$1;->this$0:Lcom/facebook/drawee/backends/pipeline/PipelineDraweeController;

    invoke-static {v2}, Lcom/facebook/drawee/backends/pipeline/PipelineDraweeController;->access$100(Lcom/facebook/drawee/backends/pipeline/PipelineDraweeController;)Lcom/facebook/imagepipeline/animated/factory/AnimatedDrawableFactory;

    move-result-object v2

    invoke-interface {v2, p1}, Lcom/facebook/imagepipeline/animated/factory/AnimatedDrawableFactory;->create(Lcom/facebook/imagepipeline/image/CloseableImage;)Landroid/graphics/drawable/Drawable;

    move-result-object v0

    goto :goto_0

    .line 93
    :cond_3
    const/4 v0, 0x0

    goto :goto_0
.end method

.method public supportsImageType(Lcom/facebook/imagepipeline/image/CloseableImage;)Z
    .locals 1
    .param p1, "image"    # Lcom/facebook/imagepipeline/image/CloseableImage;

    .prologue
    .line 74
    const/4 v0, 0x1

    return v0
.end method

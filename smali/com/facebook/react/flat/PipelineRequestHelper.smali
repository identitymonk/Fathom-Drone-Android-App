.class final Lcom/facebook/react/flat/PipelineRequestHelper;
.super Ljava/lang/Object;
.source "PipelineRequestHelper.java"

# interfaces
.implements Lcom/facebook/datasource/DataSubscriber;


# annotations
.annotation system Ldalvik/annotation/Signature;
    value = {
        "Ljava/lang/Object;",
        "Lcom/facebook/datasource/DataSubscriber",
        "<",
        "Lcom/facebook/common/references/CloseableReference",
        "<",
        "Lcom/facebook/imagepipeline/image/CloseableImage;",
        ">;>;"
    }
.end annotation


# instance fields
.field private mAttachCounter:I

.field private mBitmapUpdateListener:Lcom/facebook/react/flat/BitmapUpdateListener;
    .annotation runtime Ljavax/annotation/Nullable;
    .end annotation
.end field

.field private mDataSource:Lcom/facebook/datasource/DataSource;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Lcom/facebook/datasource/DataSource",
            "<",
            "Lcom/facebook/common/references/CloseableReference",
            "<",
            "Lcom/facebook/imagepipeline/image/CloseableImage;",
            ">;>;"
        }
    .end annotation

    .annotation runtime Ljavax/annotation/Nullable;
    .end annotation
.end field

.field private mImageRef:Lcom/facebook/common/references/CloseableReference;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Lcom/facebook/common/references/CloseableReference",
            "<",
            "Lcom/facebook/imagepipeline/image/CloseableImage;",
            ">;"
        }
    .end annotation

    .annotation runtime Ljavax/annotation/Nullable;
    .end annotation
.end field

.field private final mImageRequest:Lcom/facebook/imagepipeline/request/ImageRequest;


# direct methods
.method constructor <init>(Lcom/facebook/imagepipeline/request/ImageRequest;)V
    .locals 0
    .param p1, "imageRequest"    # Lcom/facebook/imagepipeline/request/ImageRequest;

    .prologue
    .line 46
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 47
    iput-object p1, p0, Lcom/facebook/react/flat/PipelineRequestHelper;->mImageRequest:Lcom/facebook/imagepipeline/request/ImageRequest;

    .line 48
    return-void
.end method


# virtual methods
.method attach(Lcom/facebook/react/flat/BitmapUpdateListener;)V
    .locals 5
    .param p1, "listener"    # Lcom/facebook/react/flat/BitmapUpdateListener;

    .prologue
    const/4 v4, 0x0

    const/4 v3, 0x1

    .line 51
    iput-object p1, p0, Lcom/facebook/react/flat/PipelineRequestHelper;->mBitmapUpdateListener:Lcom/facebook/react/flat/BitmapUpdateListener;

    .line 53
    iget v2, p0, Lcom/facebook/react/flat/PipelineRequestHelper;->mAttachCounter:I

    add-int/lit8 v2, v2, 0x1

    iput v2, p0, Lcom/facebook/react/flat/PipelineRequestHelper;->mAttachCounter:I

    .line 54
    iget v2, p0, Lcom/facebook/react/flat/PipelineRequestHelper;->mAttachCounter:I

    if-eq v2, v3, :cond_1

    .line 56
    invoke-virtual {p0}, Lcom/facebook/react/flat/PipelineRequestHelper;->getBitmap()Landroid/graphics/Bitmap;

    move-result-object v0

    .line 57
    .local v0, "bitmap":Landroid/graphics/Bitmap;
    if-eqz v0, :cond_0

    .line 58
    invoke-interface {p1, v0}, Lcom/facebook/react/flat/BitmapUpdateListener;->onSecondaryAttach(Landroid/graphics/Bitmap;)V

    .line 72
    .end local v0    # "bitmap":Landroid/graphics/Bitmap;
    :cond_0
    :goto_0
    return-void

    .line 63
    :cond_1
    const/4 v2, 0x4

    invoke-interface {p1, v2}, Lcom/facebook/react/flat/BitmapUpdateListener;->onImageLoadEvent(I)V

    .line 65
    iget-object v2, p0, Lcom/facebook/react/flat/PipelineRequestHelper;->mDataSource:Lcom/facebook/datasource/DataSource;

    if-nez v2, :cond_2

    move v2, v3

    :goto_1
    invoke-static {v2}, Lcom/facebook/infer/annotation/Assertions;->assertCondition(Z)V

    .line 66
    iget-object v2, p0, Lcom/facebook/react/flat/PipelineRequestHelper;->mImageRef:Lcom/facebook/common/references/CloseableReference;

    if-nez v2, :cond_3

    :goto_2
    invoke-static {v3}, Lcom/facebook/infer/annotation/Assertions;->assertCondition(Z)V

    .line 69
    invoke-static {}, Lcom/facebook/imagepipeline/core/ImagePipelineFactory;->getInstance()Lcom/facebook/imagepipeline/core/ImagePipelineFactory;

    move-result-object v2

    invoke-virtual {v2}, Lcom/facebook/imagepipeline/core/ImagePipelineFactory;->getImagePipeline()Lcom/facebook/imagepipeline/core/ImagePipeline;

    move-result-object v1

    .line 70
    .local v1, "imagePipeline":Lcom/facebook/imagepipeline/core/ImagePipeline;
    iget-object v2, p0, Lcom/facebook/react/flat/PipelineRequestHelper;->mImageRequest:Lcom/facebook/imagepipeline/request/ImageRequest;

    invoke-static {}, Lcom/facebook/react/flat/RCTImageView;->getCallerContext()Ljava/lang/Object;

    move-result-object v3

    invoke-virtual {v1, v2, v3}, Lcom/facebook/imagepipeline/core/ImagePipeline;->fetchDecodedImage(Lcom/facebook/imagepipeline/request/ImageRequest;Ljava/lang/Object;)Lcom/facebook/datasource/DataSource;

    move-result-object v2

    iput-object v2, p0, Lcom/facebook/react/flat/PipelineRequestHelper;->mDataSource:Lcom/facebook/datasource/DataSource;

    .line 71
    iget-object v2, p0, Lcom/facebook/react/flat/PipelineRequestHelper;->mDataSource:Lcom/facebook/datasource/DataSource;

    invoke-static {}, Lcom/facebook/common/executors/UiThreadImmediateExecutorService;->getInstance()Lcom/facebook/common/executors/UiThreadImmediateExecutorService;

    move-result-object v3

    invoke-interface {v2, p0, v3}, Lcom/facebook/datasource/DataSource;->subscribe(Lcom/facebook/datasource/DataSubscriber;Ljava/util/concurrent/Executor;)V

    goto :goto_0

    .end local v1    # "imagePipeline":Lcom/facebook/imagepipeline/core/ImagePipeline;
    :cond_2
    move v2, v4

    .line 65
    goto :goto_1

    :cond_3
    move v3, v4

    .line 66
    goto :goto_2
.end method

.method detach()V
    .locals 2

    .prologue
    const/4 v1, 0x0

    .line 78
    iget v0, p0, Lcom/facebook/react/flat/PipelineRequestHelper;->mAttachCounter:I

    add-int/lit8 v0, v0, -0x1

    iput v0, p0, Lcom/facebook/react/flat/PipelineRequestHelper;->mAttachCounter:I

    .line 79
    iget v0, p0, Lcom/facebook/react/flat/PipelineRequestHelper;->mAttachCounter:I

    if-eqz v0, :cond_0

    .line 95
    :goto_0
    return-void

    .line 84
    :cond_0
    iget-object v0, p0, Lcom/facebook/react/flat/PipelineRequestHelper;->mDataSource:Lcom/facebook/datasource/DataSource;

    if-eqz v0, :cond_1

    .line 85
    iget-object v0, p0, Lcom/facebook/react/flat/PipelineRequestHelper;->mDataSource:Lcom/facebook/datasource/DataSource;

    invoke-interface {v0}, Lcom/facebook/datasource/DataSource;->close()Z

    .line 86
    iput-object v1, p0, Lcom/facebook/react/flat/PipelineRequestHelper;->mDataSource:Lcom/facebook/datasource/DataSource;

    .line 89
    :cond_1
    iget-object v0, p0, Lcom/facebook/react/flat/PipelineRequestHelper;->mImageRef:Lcom/facebook/common/references/CloseableReference;

    if-eqz v0, :cond_2

    .line 90
    iget-object v0, p0, Lcom/facebook/react/flat/PipelineRequestHelper;->mImageRef:Lcom/facebook/common/references/CloseableReference;

    invoke-virtual {v0}, Lcom/facebook/common/references/CloseableReference;->close()V

    .line 91
    iput-object v1, p0, Lcom/facebook/react/flat/PipelineRequestHelper;->mImageRef:Lcom/facebook/common/references/CloseableReference;

    .line 94
    :cond_2
    iput-object v1, p0, Lcom/facebook/react/flat/PipelineRequestHelper;->mBitmapUpdateListener:Lcom/facebook/react/flat/BitmapUpdateListener;

    goto :goto_0
.end method

.method getBitmap()Landroid/graphics/Bitmap;
    .locals 3
    .annotation runtime Ljavax/annotation/Nullable;
    .end annotation

    .prologue
    const/4 v1, 0x0

    .line 102
    iget-object v2, p0, Lcom/facebook/react/flat/PipelineRequestHelper;->mImageRef:Lcom/facebook/common/references/CloseableReference;

    if-nez v2, :cond_0

    .line 113
    :goto_0
    return-object v1

    .line 106
    :cond_0
    iget-object v2, p0, Lcom/facebook/react/flat/PipelineRequestHelper;->mImageRef:Lcom/facebook/common/references/CloseableReference;

    invoke-virtual {v2}, Lcom/facebook/common/references/CloseableReference;->get()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/facebook/imagepipeline/image/CloseableImage;

    .line 107
    .local v0, "closeableImage":Lcom/facebook/imagepipeline/image/CloseableImage;
    instance-of v2, v0, Lcom/facebook/imagepipeline/image/CloseableBitmap;

    if-nez v2, :cond_1

    .line 108
    iget-object v2, p0, Lcom/facebook/react/flat/PipelineRequestHelper;->mImageRef:Lcom/facebook/common/references/CloseableReference;

    invoke-virtual {v2}, Lcom/facebook/common/references/CloseableReference;->close()V

    .line 109
    iput-object v1, p0, Lcom/facebook/react/flat/PipelineRequestHelper;->mImageRef:Lcom/facebook/common/references/CloseableReference;

    goto :goto_0

    .line 113
    :cond_1
    check-cast v0, Lcom/facebook/imagepipeline/image/CloseableBitmap;

    .end local v0    # "closeableImage":Lcom/facebook/imagepipeline/image/CloseableImage;
    invoke-virtual {v0}, Lcom/facebook/imagepipeline/image/CloseableBitmap;->getUnderlyingBitmap()Landroid/graphics/Bitmap;

    move-result-object v1

    goto :goto_0
.end method

.method isDetached()Z
    .locals 1

    .prologue
    .line 117
    iget v0, p0, Lcom/facebook/react/flat/PipelineRequestHelper;->mAttachCounter:I

    if-nez v0, :cond_0

    const/4 v0, 0x1

    :goto_0
    return v0

    :cond_0
    const/4 v0, 0x0

    goto :goto_0
.end method

.method public onCancellation(Lcom/facebook/datasource/DataSource;)V
    .locals 1
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Lcom/facebook/datasource/DataSource",
            "<",
            "Lcom/facebook/common/references/CloseableReference",
            "<",
            "Lcom/facebook/imagepipeline/image/CloseableImage;",
            ">;>;)V"
        }
    .end annotation

    .prologue
    .line 178
    .local p1, "dataSource":Lcom/facebook/datasource/DataSource;, "Lcom/facebook/datasource/DataSource<Lcom/facebook/common/references/CloseableReference<Lcom/facebook/imagepipeline/image/CloseableImage;>;>;"
    iget-object v0, p0, Lcom/facebook/react/flat/PipelineRequestHelper;->mDataSource:Lcom/facebook/datasource/DataSource;

    if-ne v0, p1, :cond_0

    .line 179
    const/4 v0, 0x0

    iput-object v0, p0, Lcom/facebook/react/flat/PipelineRequestHelper;->mDataSource:Lcom/facebook/datasource/DataSource;

    .line 182
    :cond_0
    invoke-interface {p1}, Lcom/facebook/datasource/DataSource;->close()Z

    .line 183
    return-void
.end method

.method public onFailure(Lcom/facebook/datasource/DataSource;)V
    .locals 2
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Lcom/facebook/datasource/DataSource",
            "<",
            "Lcom/facebook/common/references/CloseableReference",
            "<",
            "Lcom/facebook/imagepipeline/image/CloseableImage;",
            ">;>;)V"
        }
    .end annotation

    .prologue
    .line 167
    .local p1, "dataSource":Lcom/facebook/datasource/DataSource;, "Lcom/facebook/datasource/DataSource<Lcom/facebook/common/references/CloseableReference<Lcom/facebook/imagepipeline/image/CloseableImage;>;>;"
    iget-object v0, p0, Lcom/facebook/react/flat/PipelineRequestHelper;->mDataSource:Lcom/facebook/datasource/DataSource;

    if-ne v0, p1, :cond_0

    .line 168
    iget-object v0, p0, Lcom/facebook/react/flat/PipelineRequestHelper;->mBitmapUpdateListener:Lcom/facebook/react/flat/BitmapUpdateListener;

    invoke-static {v0}, Lcom/facebook/infer/annotation/Assertions;->assumeNotNull(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/facebook/react/flat/BitmapUpdateListener;

    const/4 v1, 0x1

    invoke-interface {v0, v1}, Lcom/facebook/react/flat/BitmapUpdateListener;->onImageLoadEvent(I)V

    .line 169
    iget-object v0, p0, Lcom/facebook/react/flat/PipelineRequestHelper;->mBitmapUpdateListener:Lcom/facebook/react/flat/BitmapUpdateListener;

    invoke-static {v0}, Lcom/facebook/infer/annotation/Assertions;->assumeNotNull(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/facebook/react/flat/BitmapUpdateListener;

    const/4 v1, 0x3

    invoke-interface {v0, v1}, Lcom/facebook/react/flat/BitmapUpdateListener;->onImageLoadEvent(I)V

    .line 170
    const/4 v0, 0x0

    iput-object v0, p0, Lcom/facebook/react/flat/PipelineRequestHelper;->mDataSource:Lcom/facebook/datasource/DataSource;

    .line 173
    :cond_0
    invoke-interface {p1}, Lcom/facebook/datasource/DataSource;->close()Z

    .line 174
    return-void
.end method

.method public onNewResult(Lcom/facebook/datasource/DataSource;)V
    .locals 5
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Lcom/facebook/datasource/DataSource",
            "<",
            "Lcom/facebook/common/references/CloseableReference",
            "<",
            "Lcom/facebook/imagepipeline/image/CloseableImage;",
            ">;>;)V"
        }
    .end annotation

    .prologue
    .line 122
    .local p1, "dataSource":Lcom/facebook/datasource/DataSource;, "Lcom/facebook/datasource/DataSource<Lcom/facebook/common/references/CloseableReference<Lcom/facebook/imagepipeline/image/CloseableImage;>;>;"
    invoke-interface {p1}, Lcom/facebook/datasource/DataSource;->isFinished()Z

    move-result v4

    if-nez v4, :cond_0

    .line 163
    :goto_0
    return-void

    .line 128
    :cond_0
    :try_start_0
    iget-object v4, p0, Lcom/facebook/react/flat/PipelineRequestHelper;->mDataSource:Lcom/facebook/datasource/DataSource;
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    if-eq v4, p1, :cond_1

    .line 161
    invoke-interface {p1}, Lcom/facebook/datasource/DataSource;->close()Z

    goto :goto_0

    .line 133
    :cond_1
    const/4 v4, 0x0

    :try_start_1
    iput-object v4, p0, Lcom/facebook/react/flat/PipelineRequestHelper;->mDataSource:Lcom/facebook/datasource/DataSource;

    .line 135
    invoke-interface {p1}, Lcom/facebook/datasource/DataSource;->getResult()Ljava/lang/Object;

    move-result-object v2

    check-cast v2, Lcom/facebook/common/references/CloseableReference;
    :try_end_1
    .catchall {:try_start_1 .. :try_end_1} :catchall_0

    .line 136
    .local v2, "imageReference":Lcom/facebook/common/references/CloseableReference;, "Lcom/facebook/common/references/CloseableReference<Lcom/facebook/imagepipeline/image/CloseableImage;>;"
    if-nez v2, :cond_2

    .line 161
    invoke-interface {p1}, Lcom/facebook/datasource/DataSource;->close()Z

    goto :goto_0

    .line 141
    :cond_2
    :try_start_2
    invoke-virtual {v2}, Lcom/facebook/common/references/CloseableReference;->get()Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Lcom/facebook/imagepipeline/image/CloseableImage;

    .line 142
    .local v1, "image":Lcom/facebook/imagepipeline/image/CloseableImage;
    instance-of v4, v1, Lcom/facebook/imagepipeline/image/CloseableBitmap;

    if-nez v4, :cond_3

    .line 144
    invoke-virtual {v2}, Lcom/facebook/common/references/CloseableReference;->close()V
    :try_end_2
    .catchall {:try_start_2 .. :try_end_2} :catchall_0

    .line 161
    invoke-interface {p1}, Lcom/facebook/datasource/DataSource;->close()Z

    goto :goto_0

    .line 148
    :cond_3
    :try_start_3
    iput-object v2, p0, Lcom/facebook/react/flat/PipelineRequestHelper;->mImageRef:Lcom/facebook/common/references/CloseableReference;

    .line 150
    invoke-virtual {p0}, Lcom/facebook/react/flat/PipelineRequestHelper;->getBitmap()Landroid/graphics/Bitmap;
    :try_end_3
    .catchall {:try_start_3 .. :try_end_3} :catchall_0

    move-result-object v0

    .line 151
    .local v0, "bitmap":Landroid/graphics/Bitmap;
    if-nez v0, :cond_4

    .line 161
    invoke-interface {p1}, Lcom/facebook/datasource/DataSource;->close()Z

    goto :goto_0

    .line 156
    :cond_4
    :try_start_4
    iget-object v4, p0, Lcom/facebook/react/flat/PipelineRequestHelper;->mBitmapUpdateListener:Lcom/facebook/react/flat/BitmapUpdateListener;

    invoke-static {v4}, Lcom/facebook/infer/annotation/Assertions;->assumeNotNull(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v3

    check-cast v3, Lcom/facebook/react/flat/BitmapUpdateListener;

    .line 157
    .local v3, "listener":Lcom/facebook/react/flat/BitmapUpdateListener;
    invoke-interface {v3, v0}, Lcom/facebook/react/flat/BitmapUpdateListener;->onBitmapReady(Landroid/graphics/Bitmap;)V

    .line 158
    const/4 v4, 0x2

    invoke-interface {v3, v4}, Lcom/facebook/react/flat/BitmapUpdateListener;->onImageLoadEvent(I)V

    .line 159
    const/4 v4, 0x3

    invoke-interface {v3, v4}, Lcom/facebook/react/flat/BitmapUpdateListener;->onImageLoadEvent(I)V
    :try_end_4
    .catchall {:try_start_4 .. :try_end_4} :catchall_0

    .line 161
    invoke-interface {p1}, Lcom/facebook/datasource/DataSource;->close()Z

    goto :goto_0

    .end local v0    # "bitmap":Landroid/graphics/Bitmap;
    .end local v1    # "image":Lcom/facebook/imagepipeline/image/CloseableImage;
    .end local v2    # "imageReference":Lcom/facebook/common/references/CloseableReference;, "Lcom/facebook/common/references/CloseableReference<Lcom/facebook/imagepipeline/image/CloseableImage;>;"
    .end local v3    # "listener":Lcom/facebook/react/flat/BitmapUpdateListener;
    :catchall_0
    move-exception v4

    invoke-interface {p1}, Lcom/facebook/datasource/DataSource;->close()Z

    throw v4
.end method

.method public onProgressUpdate(Lcom/facebook/datasource/DataSource;)V
    .locals 0
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Lcom/facebook/datasource/DataSource",
            "<",
            "Lcom/facebook/common/references/CloseableReference",
            "<",
            "Lcom/facebook/imagepipeline/image/CloseableImage;",
            ">;>;)V"
        }
    .end annotation

    .prologue
    .line 187
    .local p1, "dataSource":Lcom/facebook/datasource/DataSource;, "Lcom/facebook/datasource/DataSource<Lcom/facebook/common/references/CloseableReference<Lcom/facebook/imagepipeline/image/CloseableImage;>;>;"
    return-void
.end method

.class Lcom/facebook/imagepipeline/producers/RemoveImageTransformMetaDataProducer$RemoveImageTransformMetaDataConsumer;
.super Lcom/facebook/imagepipeline/producers/DelegatingConsumer;
.source "RemoveImageTransformMetaDataProducer.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/facebook/imagepipeline/producers/RemoveImageTransformMetaDataProducer;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x2
    name = "RemoveImageTransformMetaDataConsumer"
.end annotation

.annotation system Ldalvik/annotation/Signature;
    value = {
        "Lcom/facebook/imagepipeline/producers/DelegatingConsumer",
        "<",
        "Lcom/facebook/imagepipeline/image/EncodedImage;",
        "Lcom/facebook/common/references/CloseableReference",
        "<",
        "Lcom/facebook/common/memory/PooledByteBuffer;",
        ">;>;"
    }
.end annotation


# instance fields
.field final synthetic this$0:Lcom/facebook/imagepipeline/producers/RemoveImageTransformMetaDataProducer;


# direct methods
.method private constructor <init>(Lcom/facebook/imagepipeline/producers/RemoveImageTransformMetaDataProducer;Lcom/facebook/imagepipeline/producers/Consumer;)V
    .locals 0
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Lcom/facebook/imagepipeline/producers/Consumer",
            "<",
            "Lcom/facebook/common/references/CloseableReference",
            "<",
            "Lcom/facebook/common/memory/PooledByteBuffer;",
            ">;>;)V"
        }
    .end annotation

    .prologue
    .line 42
    .local p2, "consumer":Lcom/facebook/imagepipeline/producers/Consumer;, "Lcom/facebook/imagepipeline/producers/Consumer<Lcom/facebook/common/references/CloseableReference<Lcom/facebook/common/memory/PooledByteBuffer;>;>;"
    iput-object p1, p0, Lcom/facebook/imagepipeline/producers/RemoveImageTransformMetaDataProducer$RemoveImageTransformMetaDataConsumer;->this$0:Lcom/facebook/imagepipeline/producers/RemoveImageTransformMetaDataProducer;

    .line 43
    invoke-direct {p0, p2}, Lcom/facebook/imagepipeline/producers/DelegatingConsumer;-><init>(Lcom/facebook/imagepipeline/producers/Consumer;)V

    .line 44
    return-void
.end method

.method synthetic constructor <init>(Lcom/facebook/imagepipeline/producers/RemoveImageTransformMetaDataProducer;Lcom/facebook/imagepipeline/producers/Consumer;Lcom/facebook/imagepipeline/producers/RemoveImageTransformMetaDataProducer$1;)V
    .locals 0
    .param p1, "x0"    # Lcom/facebook/imagepipeline/producers/RemoveImageTransformMetaDataProducer;
    .param p2, "x1"    # Lcom/facebook/imagepipeline/producers/Consumer;
    .param p3, "x2"    # Lcom/facebook/imagepipeline/producers/RemoveImageTransformMetaDataProducer$1;

    .prologue
    .line 38
    invoke-direct {p0, p1, p2}, Lcom/facebook/imagepipeline/producers/RemoveImageTransformMetaDataProducer$RemoveImageTransformMetaDataConsumer;-><init>(Lcom/facebook/imagepipeline/producers/RemoveImageTransformMetaDataProducer;Lcom/facebook/imagepipeline/producers/Consumer;)V

    return-void
.end method


# virtual methods
.method protected onNewResultImpl(Lcom/facebook/imagepipeline/image/EncodedImage;Z)V
    .locals 2
    .param p1, "newResult"    # Lcom/facebook/imagepipeline/image/EncodedImage;
    .param p2, "isLast"    # Z

    .prologue
    .line 48
    const/4 v0, 0x0

    .line 50
    .local v0, "ret":Lcom/facebook/common/references/CloseableReference;, "Lcom/facebook/common/references/CloseableReference<Lcom/facebook/common/memory/PooledByteBuffer;>;"
    :try_start_0
    invoke-static {p1}, Lcom/facebook/imagepipeline/image/EncodedImage;->isValid(Lcom/facebook/imagepipeline/image/EncodedImage;)Z

    move-result v1

    if-eqz v1, :cond_0

    .line 51
    invoke-virtual {p1}, Lcom/facebook/imagepipeline/image/EncodedImage;->getByteBufferRef()Lcom/facebook/common/references/CloseableReference;

    move-result-object v0

    .line 53
    :cond_0
    invoke-virtual {p0}, Lcom/facebook/imagepipeline/producers/RemoveImageTransformMetaDataProducer$RemoveImageTransformMetaDataConsumer;->getConsumer()Lcom/facebook/imagepipeline/producers/Consumer;

    move-result-object v1

    invoke-interface {v1, v0, p2}, Lcom/facebook/imagepipeline/producers/Consumer;->onNewResult(Ljava/lang/Object;Z)V
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    .line 55
    invoke-static {v0}, Lcom/facebook/common/references/CloseableReference;->closeSafely(Lcom/facebook/common/references/CloseableReference;)V

    .line 57
    return-void

    .line 55
    :catchall_0
    move-exception v1

    invoke-static {v0}, Lcom/facebook/common/references/CloseableReference;->closeSafely(Lcom/facebook/common/references/CloseableReference;)V

    throw v1
.end method

.method protected bridge synthetic onNewResultImpl(Ljava/lang/Object;Z)V
    .locals 0

    .prologue
    .line 38
    check-cast p1, Lcom/facebook/imagepipeline/image/EncodedImage;

    invoke-virtual {p0, p1, p2}, Lcom/facebook/imagepipeline/producers/RemoveImageTransformMetaDataProducer$RemoveImageTransformMetaDataConsumer;->onNewResultImpl(Lcom/facebook/imagepipeline/image/EncodedImage;Z)V

    return-void
.end method

.class Lcom/facebook/imagepipeline/producers/ThumbnailBranchProducer$ThumbnailConsumer;
.super Lcom/facebook/imagepipeline/producers/DelegatingConsumer;
.source "ThumbnailBranchProducer.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/facebook/imagepipeline/producers/ThumbnailBranchProducer;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x2
    name = "ThumbnailConsumer"
.end annotation

.annotation system Ldalvik/annotation/Signature;
    value = {
        "Lcom/facebook/imagepipeline/producers/DelegatingConsumer",
        "<",
        "Lcom/facebook/imagepipeline/image/EncodedImage;",
        "Lcom/facebook/imagepipeline/image/EncodedImage;",
        ">;"
    }
.end annotation


# instance fields
.field private final mProducerContext:Lcom/facebook/imagepipeline/producers/ProducerContext;

.field private final mProducerIndex:I

.field private final mResizeOptions:Lcom/facebook/imagepipeline/common/ResizeOptions;

.field final synthetic this$0:Lcom/facebook/imagepipeline/producers/ThumbnailBranchProducer;


# direct methods
.method public constructor <init>(Lcom/facebook/imagepipeline/producers/ThumbnailBranchProducer;Lcom/facebook/imagepipeline/producers/Consumer;Lcom/facebook/imagepipeline/producers/ProducerContext;I)V
    .locals 1
    .param p3, "producerContext"    # Lcom/facebook/imagepipeline/producers/ProducerContext;
    .param p4, "producerIndex"    # I
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Lcom/facebook/imagepipeline/producers/Consumer",
            "<",
            "Lcom/facebook/imagepipeline/image/EncodedImage;",
            ">;",
            "Lcom/facebook/imagepipeline/producers/ProducerContext;",
            "I)V"
        }
    .end annotation

    .prologue
    .line 56
    .local p2, "consumer":Lcom/facebook/imagepipeline/producers/Consumer;, "Lcom/facebook/imagepipeline/producers/Consumer<Lcom/facebook/imagepipeline/image/EncodedImage;>;"
    iput-object p1, p0, Lcom/facebook/imagepipeline/producers/ThumbnailBranchProducer$ThumbnailConsumer;->this$0:Lcom/facebook/imagepipeline/producers/ThumbnailBranchProducer;

    .line 57
    invoke-direct {p0, p2}, Lcom/facebook/imagepipeline/producers/DelegatingConsumer;-><init>(Lcom/facebook/imagepipeline/producers/Consumer;)V

    .line 58
    iput-object p3, p0, Lcom/facebook/imagepipeline/producers/ThumbnailBranchProducer$ThumbnailConsumer;->mProducerContext:Lcom/facebook/imagepipeline/producers/ProducerContext;

    .line 59
    iput p4, p0, Lcom/facebook/imagepipeline/producers/ThumbnailBranchProducer$ThumbnailConsumer;->mProducerIndex:I

    .line 60
    iget-object v0, p0, Lcom/facebook/imagepipeline/producers/ThumbnailBranchProducer$ThumbnailConsumer;->mProducerContext:Lcom/facebook/imagepipeline/producers/ProducerContext;

    invoke-interface {v0}, Lcom/facebook/imagepipeline/producers/ProducerContext;->getImageRequest()Lcom/facebook/imagepipeline/request/ImageRequest;

    move-result-object v0

    invoke-virtual {v0}, Lcom/facebook/imagepipeline/request/ImageRequest;->getResizeOptions()Lcom/facebook/imagepipeline/common/ResizeOptions;

    move-result-object v0

    iput-object v0, p0, Lcom/facebook/imagepipeline/producers/ThumbnailBranchProducer$ThumbnailConsumer;->mResizeOptions:Lcom/facebook/imagepipeline/common/ResizeOptions;

    .line 61
    return-void
.end method


# virtual methods
.method protected onFailureImpl(Ljava/lang/Throwable;)V
    .locals 5
    .param p1, "t"    # Ljava/lang/Throwable;

    .prologue
    .line 84
    iget-object v1, p0, Lcom/facebook/imagepipeline/producers/ThumbnailBranchProducer$ThumbnailConsumer;->this$0:Lcom/facebook/imagepipeline/producers/ThumbnailBranchProducer;

    iget v2, p0, Lcom/facebook/imagepipeline/producers/ThumbnailBranchProducer$ThumbnailConsumer;->mProducerIndex:I

    add-int/lit8 v2, v2, 0x1

    .line 85
    invoke-virtual {p0}, Lcom/facebook/imagepipeline/producers/ThumbnailBranchProducer$ThumbnailConsumer;->getConsumer()Lcom/facebook/imagepipeline/producers/Consumer;

    move-result-object v3

    iget-object v4, p0, Lcom/facebook/imagepipeline/producers/ThumbnailBranchProducer$ThumbnailConsumer;->mProducerContext:Lcom/facebook/imagepipeline/producers/ProducerContext;

    invoke-static {v1, v2, v3, v4}, Lcom/facebook/imagepipeline/producers/ThumbnailBranchProducer;->access$000(Lcom/facebook/imagepipeline/producers/ThumbnailBranchProducer;ILcom/facebook/imagepipeline/producers/Consumer;Lcom/facebook/imagepipeline/producers/ProducerContext;)Z

    move-result v0

    .line 87
    .local v0, "fallback":Z
    if-nez v0, :cond_0

    .line 88
    invoke-virtual {p0}, Lcom/facebook/imagepipeline/producers/ThumbnailBranchProducer$ThumbnailConsumer;->getConsumer()Lcom/facebook/imagepipeline/producers/Consumer;

    move-result-object v1

    invoke-interface {v1, p1}, Lcom/facebook/imagepipeline/producers/Consumer;->onFailure(Ljava/lang/Throwable;)V

    .line 90
    :cond_0
    return-void
.end method

.method protected onNewResultImpl(Lcom/facebook/imagepipeline/image/EncodedImage;Z)V
    .locals 5
    .param p1, "newResult"    # Lcom/facebook/imagepipeline/image/EncodedImage;
    .param p2, "isLast"    # Z

    .prologue
    .line 65
    if-eqz p1, :cond_2

    if-eqz p2, :cond_0

    iget-object v1, p0, Lcom/facebook/imagepipeline/producers/ThumbnailBranchProducer$ThumbnailConsumer;->mResizeOptions:Lcom/facebook/imagepipeline/common/ResizeOptions;

    .line 66
    invoke-static {p1, v1}, Lcom/facebook/imagepipeline/producers/ThumbnailSizeChecker;->isImageBigEnough(Lcom/facebook/imagepipeline/image/EncodedImage;Lcom/facebook/imagepipeline/common/ResizeOptions;)Z

    move-result v1

    if-eqz v1, :cond_2

    .line 67
    :cond_0
    invoke-virtual {p0}, Lcom/facebook/imagepipeline/producers/ThumbnailBranchProducer$ThumbnailConsumer;->getConsumer()Lcom/facebook/imagepipeline/producers/Consumer;

    move-result-object v1

    invoke-interface {v1, p1, p2}, Lcom/facebook/imagepipeline/producers/Consumer;->onNewResult(Ljava/lang/Object;Z)V

    .line 80
    :cond_1
    :goto_0
    return-void

    .line 68
    :cond_2
    if-eqz p2, :cond_1

    .line 69
    invoke-static {p1}, Lcom/facebook/imagepipeline/image/EncodedImage;->closeSafely(Lcom/facebook/imagepipeline/image/EncodedImage;)V

    .line 71
    iget-object v1, p0, Lcom/facebook/imagepipeline/producers/ThumbnailBranchProducer$ThumbnailConsumer;->this$0:Lcom/facebook/imagepipeline/producers/ThumbnailBranchProducer;

    iget v2, p0, Lcom/facebook/imagepipeline/producers/ThumbnailBranchProducer$ThumbnailConsumer;->mProducerIndex:I

    add-int/lit8 v2, v2, 0x1

    .line 73
    invoke-virtual {p0}, Lcom/facebook/imagepipeline/producers/ThumbnailBranchProducer$ThumbnailConsumer;->getConsumer()Lcom/facebook/imagepipeline/producers/Consumer;

    move-result-object v3

    iget-object v4, p0, Lcom/facebook/imagepipeline/producers/ThumbnailBranchProducer$ThumbnailConsumer;->mProducerContext:Lcom/facebook/imagepipeline/producers/ProducerContext;

    .line 71
    invoke-static {v1, v2, v3, v4}, Lcom/facebook/imagepipeline/producers/ThumbnailBranchProducer;->access$000(Lcom/facebook/imagepipeline/producers/ThumbnailBranchProducer;ILcom/facebook/imagepipeline/producers/Consumer;Lcom/facebook/imagepipeline/producers/ProducerContext;)Z

    move-result v0

    .line 76
    .local v0, "fallback":Z
    if-nez v0, :cond_1

    .line 77
    invoke-virtual {p0}, Lcom/facebook/imagepipeline/producers/ThumbnailBranchProducer$ThumbnailConsumer;->getConsumer()Lcom/facebook/imagepipeline/producers/Consumer;

    move-result-object v1

    const/4 v2, 0x0

    const/4 v3, 0x1

    invoke-interface {v1, v2, v3}, Lcom/facebook/imagepipeline/producers/Consumer;->onNewResult(Ljava/lang/Object;Z)V

    goto :goto_0
.end method

.method protected bridge synthetic onNewResultImpl(Ljava/lang/Object;Z)V
    .locals 0

    .prologue
    .line 48
    check-cast p1, Lcom/facebook/imagepipeline/image/EncodedImage;

    invoke-virtual {p0, p1, p2}, Lcom/facebook/imagepipeline/producers/ThumbnailBranchProducer$ThumbnailConsumer;->onNewResultImpl(Lcom/facebook/imagepipeline/image/EncodedImage;Z)V

    return-void
.end method

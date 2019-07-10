.class public Lcom/facebook/imagepipeline/producers/ThumbnailBranchProducer;
.super Ljava/lang/Object;
.source "ThumbnailBranchProducer.java"

# interfaces
.implements Lcom/facebook/imagepipeline/producers/Producer;


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lcom/facebook/imagepipeline/producers/ThumbnailBranchProducer$ThumbnailConsumer;
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


# instance fields
.field private final mThumbnailProducers:[Lcom/facebook/imagepipeline/producers/ThumbnailProducer;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "[",
            "Lcom/facebook/imagepipeline/producers/ThumbnailProducer",
            "<",
            "Lcom/facebook/imagepipeline/image/EncodedImage;",
            ">;"
        }
    .end annotation
.end field


# direct methods
.method public varargs constructor <init>([Lcom/facebook/imagepipeline/producers/ThumbnailProducer;)V
    .locals 2
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "([",
            "Lcom/facebook/imagepipeline/producers/ThumbnailProducer",
            "<",
            "Lcom/facebook/imagepipeline/image/EncodedImage;",
            ">;)V"
        }
    .end annotation

    .prologue
    .line 29
    .local p1, "thumbnailProducers":[Lcom/facebook/imagepipeline/producers/ThumbnailProducer;, "[Lcom/facebook/imagepipeline/producers/ThumbnailProducer<Lcom/facebook/imagepipeline/image/EncodedImage;>;"
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 30
    invoke-static {p1}, Lcom/facebook/common/internal/Preconditions;->checkNotNull(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, [Lcom/facebook/imagepipeline/producers/ThumbnailProducer;

    iput-object v0, p0, Lcom/facebook/imagepipeline/producers/ThumbnailBranchProducer;->mThumbnailProducers:[Lcom/facebook/imagepipeline/producers/ThumbnailProducer;

    .line 31
    const/4 v0, 0x0

    iget-object v1, p0, Lcom/facebook/imagepipeline/producers/ThumbnailBranchProducer;->mThumbnailProducers:[Lcom/facebook/imagepipeline/producers/ThumbnailProducer;

    array-length v1, v1

    invoke-static {v0, v1}, Lcom/facebook/common/internal/Preconditions;->checkElementIndex(II)I

    .line 32
    return-void
.end method

.method static synthetic access$000(Lcom/facebook/imagepipeline/producers/ThumbnailBranchProducer;ILcom/facebook/imagepipeline/producers/Consumer;Lcom/facebook/imagepipeline/producers/ProducerContext;)Z
    .locals 1
    .param p0, "x0"    # Lcom/facebook/imagepipeline/producers/ThumbnailBranchProducer;
    .param p1, "x1"    # I
    .param p2, "x2"    # Lcom/facebook/imagepipeline/producers/Consumer;
    .param p3, "x3"    # Lcom/facebook/imagepipeline/producers/ProducerContext;

    .prologue
    .line 25
    invoke-direct {p0, p1, p2, p3}, Lcom/facebook/imagepipeline/producers/ThumbnailBranchProducer;->produceResultsFromThumbnailProducer(ILcom/facebook/imagepipeline/producers/Consumer;Lcom/facebook/imagepipeline/producers/ProducerContext;)Z

    move-result v0

    return v0
.end method

.method private findFirstProducerForSize(ILcom/facebook/imagepipeline/common/ResizeOptions;)I
    .locals 2
    .param p1, "startIndex"    # I
    .param p2, "resizeOptions"    # Lcom/facebook/imagepipeline/common/ResizeOptions;

    .prologue
    .line 110
    move v0, p1

    .local v0, "i":I
    :goto_0
    iget-object v1, p0, Lcom/facebook/imagepipeline/producers/ThumbnailBranchProducer;->mThumbnailProducers:[Lcom/facebook/imagepipeline/producers/ThumbnailProducer;

    array-length v1, v1

    if-ge v0, v1, :cond_1

    .line 111
    iget-object v1, p0, Lcom/facebook/imagepipeline/producers/ThumbnailBranchProducer;->mThumbnailProducers:[Lcom/facebook/imagepipeline/producers/ThumbnailProducer;

    aget-object v1, v1, v0

    invoke-interface {v1, p2}, Lcom/facebook/imagepipeline/producers/ThumbnailProducer;->canProvideImageForSize(Lcom/facebook/imagepipeline/common/ResizeOptions;)Z

    move-result v1

    if-eqz v1, :cond_0

    .line 116
    .end local v0    # "i":I
    :goto_1
    return v0

    .line 110
    .restart local v0    # "i":I
    :cond_0
    add-int/lit8 v0, v0, 0x1

    goto :goto_0

    .line 116
    :cond_1
    const/4 v0, -0x1

    goto :goto_1
.end method

.method private produceResultsFromThumbnailProducer(ILcom/facebook/imagepipeline/producers/Consumer;Lcom/facebook/imagepipeline/producers/ProducerContext;)Z
    .locals 3
    .param p1, "startIndex"    # I
    .param p3, "context"    # Lcom/facebook/imagepipeline/producers/ProducerContext;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(I",
            "Lcom/facebook/imagepipeline/producers/Consumer",
            "<",
            "Lcom/facebook/imagepipeline/image/EncodedImage;",
            ">;",
            "Lcom/facebook/imagepipeline/producers/ProducerContext;",
            ")Z"
        }
    .end annotation

    .prologue
    .line 97
    .line 98
    .local p2, "consumer":Lcom/facebook/imagepipeline/producers/Consumer;, "Lcom/facebook/imagepipeline/producers/Consumer<Lcom/facebook/imagepipeline/image/EncodedImage;>;"
    invoke-interface {p3}, Lcom/facebook/imagepipeline/producers/ProducerContext;->getImageRequest()Lcom/facebook/imagepipeline/request/ImageRequest;

    move-result-object v1

    invoke-virtual {v1}, Lcom/facebook/imagepipeline/request/ImageRequest;->getResizeOptions()Lcom/facebook/imagepipeline/common/ResizeOptions;

    move-result-object v1

    invoke-direct {p0, p1, v1}, Lcom/facebook/imagepipeline/producers/ThumbnailBranchProducer;->findFirstProducerForSize(ILcom/facebook/imagepipeline/common/ResizeOptions;)I

    move-result v0

    .line 100
    .local v0, "producerIndex":I
    const/4 v1, -0x1

    if-ne v0, v1, :cond_0

    .line 101
    const/4 v1, 0x0

    .line 106
    :goto_0
    return v1

    .line 104
    :cond_0
    iget-object v1, p0, Lcom/facebook/imagepipeline/producers/ThumbnailBranchProducer;->mThumbnailProducers:[Lcom/facebook/imagepipeline/producers/ThumbnailProducer;

    aget-object v1, v1, v0

    new-instance v2, Lcom/facebook/imagepipeline/producers/ThumbnailBranchProducer$ThumbnailConsumer;

    invoke-direct {v2, p0, p2, p3, v0}, Lcom/facebook/imagepipeline/producers/ThumbnailBranchProducer$ThumbnailConsumer;-><init>(Lcom/facebook/imagepipeline/producers/ThumbnailBranchProducer;Lcom/facebook/imagepipeline/producers/Consumer;Lcom/facebook/imagepipeline/producers/ProducerContext;I)V

    .line 105
    invoke-interface {v1, v2, p3}, Lcom/facebook/imagepipeline/producers/ThumbnailProducer;->produceResults(Lcom/facebook/imagepipeline/producers/Consumer;Lcom/facebook/imagepipeline/producers/ProducerContext;)V

    .line 106
    const/4 v1, 0x1

    goto :goto_0
.end method


# virtual methods
.method public produceResults(Lcom/facebook/imagepipeline/producers/Consumer;Lcom/facebook/imagepipeline/producers/ProducerContext;)V
    .locals 4
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
    .local p1, "consumer":Lcom/facebook/imagepipeline/producers/Consumer;, "Lcom/facebook/imagepipeline/producers/Consumer<Lcom/facebook/imagepipeline/image/EncodedImage;>;"
    const/4 v3, 0x0

    const/4 v2, 0x1

    .line 38
    invoke-interface {p2}, Lcom/facebook/imagepipeline/producers/ProducerContext;->getImageRequest()Lcom/facebook/imagepipeline/request/ImageRequest;

    move-result-object v1

    invoke-virtual {v1}, Lcom/facebook/imagepipeline/request/ImageRequest;->getResizeOptions()Lcom/facebook/imagepipeline/common/ResizeOptions;

    move-result-object v1

    if-nez v1, :cond_1

    .line 39
    invoke-interface {p1, v3, v2}, Lcom/facebook/imagepipeline/producers/Consumer;->onNewResult(Ljava/lang/Object;Z)V

    .line 46
    :cond_0
    :goto_0
    return-void

    .line 41
    :cond_1
    const/4 v1, 0x0

    invoke-direct {p0, v1, p1, p2}, Lcom/facebook/imagepipeline/producers/ThumbnailBranchProducer;->produceResultsFromThumbnailProducer(ILcom/facebook/imagepipeline/producers/Consumer;Lcom/facebook/imagepipeline/producers/ProducerContext;)Z

    move-result v0

    .line 42
    .local v0, "requested":Z
    if-nez v0, :cond_0

    .line 43
    invoke-interface {p1, v3, v2}, Lcom/facebook/imagepipeline/producers/Consumer;->onNewResult(Ljava/lang/Object;Z)V

    goto :goto_0
.end method

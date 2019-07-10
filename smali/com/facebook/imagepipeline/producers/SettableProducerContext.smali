.class public Lcom/facebook/imagepipeline/producers/SettableProducerContext;
.super Lcom/facebook/imagepipeline/producers/BaseProducerContext;
.source "SettableProducerContext.java"


# annotations
.annotation build Ljavax/annotation/concurrent/ThreadSafe;
.end annotation


# direct methods
.method public constructor <init>(Lcom/facebook/imagepipeline/request/ImageRequest;Ljava/lang/String;Lcom/facebook/imagepipeline/producers/ProducerListener;Ljava/lang/Object;Lcom/facebook/imagepipeline/request/ImageRequest$RequestLevel;ZZLcom/facebook/imagepipeline/common/Priority;)V
    .locals 0
    .param p1, "imageRequest"    # Lcom/facebook/imagepipeline/request/ImageRequest;
    .param p2, "id"    # Ljava/lang/String;
    .param p3, "producerListener"    # Lcom/facebook/imagepipeline/producers/ProducerListener;
    .param p4, "callerContext"    # Ljava/lang/Object;
    .param p5, "lowestPermittedRequestLevel"    # Lcom/facebook/imagepipeline/request/ImageRequest$RequestLevel;
    .param p6, "isPrefetch"    # Z
    .param p7, "isIntermediateResultExpected"    # Z
    .param p8, "priority"    # Lcom/facebook/imagepipeline/common/Priority;

    .prologue
    .line 32
    invoke-direct/range {p0 .. p8}, Lcom/facebook/imagepipeline/producers/BaseProducerContext;-><init>(Lcom/facebook/imagepipeline/request/ImageRequest;Ljava/lang/String;Lcom/facebook/imagepipeline/producers/ProducerListener;Ljava/lang/Object;Lcom/facebook/imagepipeline/request/ImageRequest$RequestLevel;ZZLcom/facebook/imagepipeline/common/Priority;)V

    .line 41
    return-void
.end method


# virtual methods
.method public setIsIntermediateResultExpected(Z)V
    .locals 1
    .param p1, "isIntermediateResultExpected"    # Z

    .prologue
    .line 56
    .line 57
    invoke-virtual {p0, p1}, Lcom/facebook/imagepipeline/producers/SettableProducerContext;->setIsIntermediateResultExpectedNoCallbacks(Z)Ljava/util/List;

    move-result-object v0

    .line 56
    invoke-static {v0}, Lcom/facebook/imagepipeline/producers/BaseProducerContext;->callOnIsIntermediateResultExpectedChanged(Ljava/util/List;)V

    .line 58
    return-void
.end method

.method public setIsPrefetch(Z)V
    .locals 1
    .param p1, "isPrefetch"    # Z

    .prologue
    .line 48
    invoke-virtual {p0, p1}, Lcom/facebook/imagepipeline/producers/SettableProducerContext;->setIsPrefetchNoCallbacks(Z)Ljava/util/List;

    move-result-object v0

    invoke-static {v0}, Lcom/facebook/imagepipeline/producers/BaseProducerContext;->callOnIsPrefetchChanged(Ljava/util/List;)V

    .line 49
    return-void
.end method

.method public setPriority(Lcom/facebook/imagepipeline/common/Priority;)V
    .locals 1
    .param p1, "priority"    # Lcom/facebook/imagepipeline/common/Priority;

    .prologue
    .line 65
    invoke-virtual {p0, p1}, Lcom/facebook/imagepipeline/producers/SettableProducerContext;->setPriorityNoCallbacks(Lcom/facebook/imagepipeline/common/Priority;)Ljava/util/List;

    move-result-object v0

    invoke-static {v0}, Lcom/facebook/imagepipeline/producers/BaseProducerContext;->callOnPriorityChanged(Ljava/util/List;)V

    .line 66
    return-void
.end method

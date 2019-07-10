.class public abstract Lcom/facebook/imagepipeline/producers/StatefulProducerRunnable;
.super Lcom/facebook/common/executors/StatefulRunnable;
.source "StatefulProducerRunnable.java"


# annotations
.annotation system Ldalvik/annotation/Signature;
    value = {
        "<T:",
        "Ljava/lang/Object;",
        ">",
        "Lcom/facebook/common/executors/StatefulRunnable",
        "<TT;>;"
    }
.end annotation


# instance fields
.field private final mConsumer:Lcom/facebook/imagepipeline/producers/Consumer;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Lcom/facebook/imagepipeline/producers/Consumer",
            "<TT;>;"
        }
    .end annotation
.end field

.field private final mProducerListener:Lcom/facebook/imagepipeline/producers/ProducerListener;

.field private final mProducerName:Ljava/lang/String;

.field private final mRequestId:Ljava/lang/String;


# direct methods
.method public constructor <init>(Lcom/facebook/imagepipeline/producers/Consumer;Lcom/facebook/imagepipeline/producers/ProducerListener;Ljava/lang/String;Ljava/lang/String;)V
    .locals 3
    .param p2, "producerListener"    # Lcom/facebook/imagepipeline/producers/ProducerListener;
    .param p3, "producerName"    # Ljava/lang/String;
    .param p4, "requestId"    # Ljava/lang/String;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Lcom/facebook/imagepipeline/producers/Consumer",
            "<TT;>;",
            "Lcom/facebook/imagepipeline/producers/ProducerListener;",
            "Ljava/lang/String;",
            "Ljava/lang/String;",
            ")V"
        }
    .end annotation

    .prologue
    .line 34
    .local p0, "this":Lcom/facebook/imagepipeline/producers/StatefulProducerRunnable;, "Lcom/facebook/imagepipeline/producers/StatefulProducerRunnable<TT;>;"
    .local p1, "consumer":Lcom/facebook/imagepipeline/producers/Consumer;, "Lcom/facebook/imagepipeline/producers/Consumer<TT;>;"
    invoke-direct {p0}, Lcom/facebook/common/executors/StatefulRunnable;-><init>()V

    .line 35
    iput-object p1, p0, Lcom/facebook/imagepipeline/producers/StatefulProducerRunnable;->mConsumer:Lcom/facebook/imagepipeline/producers/Consumer;

    .line 36
    iput-object p2, p0, Lcom/facebook/imagepipeline/producers/StatefulProducerRunnable;->mProducerListener:Lcom/facebook/imagepipeline/producers/ProducerListener;

    .line 37
    iput-object p3, p0, Lcom/facebook/imagepipeline/producers/StatefulProducerRunnable;->mProducerName:Ljava/lang/String;

    .line 38
    iput-object p4, p0, Lcom/facebook/imagepipeline/producers/StatefulProducerRunnable;->mRequestId:Ljava/lang/String;

    .line 40
    iget-object v0, p0, Lcom/facebook/imagepipeline/producers/StatefulProducerRunnable;->mProducerListener:Lcom/facebook/imagepipeline/producers/ProducerListener;

    iget-object v1, p0, Lcom/facebook/imagepipeline/producers/StatefulProducerRunnable;->mRequestId:Ljava/lang/String;

    iget-object v2, p0, Lcom/facebook/imagepipeline/producers/StatefulProducerRunnable;->mProducerName:Ljava/lang/String;

    invoke-interface {v0, v1, v2}, Lcom/facebook/imagepipeline/producers/ProducerListener;->onProducerStart(Ljava/lang/String;Ljava/lang/String;)V

    .line 41
    return-void
.end method


# virtual methods
.method protected abstract disposeResult(Ljava/lang/Object;)V
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(TT;)V"
        }
    .end annotation
.end method

.method protected getExtraMapOnCancellation()Ljava/util/Map;
    .locals 1
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()",
            "Ljava/util/Map",
            "<",
            "Ljava/lang/String;",
            "Ljava/lang/String;",
            ">;"
        }
    .end annotation

    .prologue
    .line 89
    .local p0, "this":Lcom/facebook/imagepipeline/producers/StatefulProducerRunnable;, "Lcom/facebook/imagepipeline/producers/StatefulProducerRunnable<TT;>;"
    const/4 v0, 0x0

    return-object v0
.end method

.method protected getExtraMapOnFailure(Ljava/lang/Exception;)Ljava/util/Map;
    .locals 1
    .param p1, "exception"    # Ljava/lang/Exception;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/lang/Exception;",
            ")",
            "Ljava/util/Map",
            "<",
            "Ljava/lang/String;",
            "Ljava/lang/String;",
            ">;"
        }
    .end annotation

    .prologue
    .line 82
    .local p0, "this":Lcom/facebook/imagepipeline/producers/StatefulProducerRunnable;, "Lcom/facebook/imagepipeline/producers/StatefulProducerRunnable<TT;>;"
    const/4 v0, 0x0

    return-object v0
.end method

.method protected getExtraMapOnSuccess(Ljava/lang/Object;)Ljava/util/Map;
    .locals 1
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(TT;)",
            "Ljava/util/Map",
            "<",
            "Ljava/lang/String;",
            "Ljava/lang/String;",
            ">;"
        }
    .end annotation

    .prologue
    .line 75
    .local p0, "this":Lcom/facebook/imagepipeline/producers/StatefulProducerRunnable;, "Lcom/facebook/imagepipeline/producers/StatefulProducerRunnable<TT;>;"
    .local p1, "result":Ljava/lang/Object;, "TT;"
    const/4 v0, 0x0

    return-object v0
.end method

.method protected onCancellation()V
    .locals 5

    .prologue
    .line 64
    .local p0, "this":Lcom/facebook/imagepipeline/producers/StatefulProducerRunnable;, "Lcom/facebook/imagepipeline/producers/StatefulProducerRunnable<TT;>;"
    iget-object v1, p0, Lcom/facebook/imagepipeline/producers/StatefulProducerRunnable;->mProducerListener:Lcom/facebook/imagepipeline/producers/ProducerListener;

    iget-object v2, p0, Lcom/facebook/imagepipeline/producers/StatefulProducerRunnable;->mRequestId:Ljava/lang/String;

    iget-object v3, p0, Lcom/facebook/imagepipeline/producers/StatefulProducerRunnable;->mProducerName:Ljava/lang/String;

    iget-object v0, p0, Lcom/facebook/imagepipeline/producers/StatefulProducerRunnable;->mProducerListener:Lcom/facebook/imagepipeline/producers/ProducerListener;

    iget-object v4, p0, Lcom/facebook/imagepipeline/producers/StatefulProducerRunnable;->mRequestId:Ljava/lang/String;

    .line 67
    invoke-interface {v0, v4}, Lcom/facebook/imagepipeline/producers/ProducerListener;->requiresExtraMap(Ljava/lang/String;)Z

    move-result v0

    if-eqz v0, :cond_0

    invoke-virtual {p0}, Lcom/facebook/imagepipeline/producers/StatefulProducerRunnable;->getExtraMapOnCancellation()Ljava/util/Map;

    move-result-object v0

    .line 64
    :goto_0
    invoke-interface {v1, v2, v3, v0}, Lcom/facebook/imagepipeline/producers/ProducerListener;->onProducerFinishWithCancellation(Ljava/lang/String;Ljava/lang/String;Ljava/util/Map;)V

    .line 68
    iget-object v0, p0, Lcom/facebook/imagepipeline/producers/StatefulProducerRunnable;->mConsumer:Lcom/facebook/imagepipeline/producers/Consumer;

    invoke-interface {v0}, Lcom/facebook/imagepipeline/producers/Consumer;->onCancellation()V

    .line 69
    return-void

    .line 67
    :cond_0
    const/4 v0, 0x0

    goto :goto_0
.end method

.method protected onFailure(Ljava/lang/Exception;)V
    .locals 5
    .param p1, "e"    # Ljava/lang/Exception;

    .prologue
    .line 54
    .local p0, "this":Lcom/facebook/imagepipeline/producers/StatefulProducerRunnable;, "Lcom/facebook/imagepipeline/producers/StatefulProducerRunnable<TT;>;"
    iget-object v1, p0, Lcom/facebook/imagepipeline/producers/StatefulProducerRunnable;->mProducerListener:Lcom/facebook/imagepipeline/producers/ProducerListener;

    iget-object v2, p0, Lcom/facebook/imagepipeline/producers/StatefulProducerRunnable;->mRequestId:Ljava/lang/String;

    iget-object v3, p0, Lcom/facebook/imagepipeline/producers/StatefulProducerRunnable;->mProducerName:Ljava/lang/String;

    iget-object v0, p0, Lcom/facebook/imagepipeline/producers/StatefulProducerRunnable;->mProducerListener:Lcom/facebook/imagepipeline/producers/ProducerListener;

    iget-object v4, p0, Lcom/facebook/imagepipeline/producers/StatefulProducerRunnable;->mRequestId:Ljava/lang/String;

    .line 58
    invoke-interface {v0, v4}, Lcom/facebook/imagepipeline/producers/ProducerListener;->requiresExtraMap(Ljava/lang/String;)Z

    move-result v0

    if-eqz v0, :cond_0

    invoke-virtual {p0, p1}, Lcom/facebook/imagepipeline/producers/StatefulProducerRunnable;->getExtraMapOnFailure(Ljava/lang/Exception;)Ljava/util/Map;

    move-result-object v0

    .line 54
    :goto_0
    invoke-interface {v1, v2, v3, p1, v0}, Lcom/facebook/imagepipeline/producers/ProducerListener;->onProducerFinishWithFailure(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;Ljava/util/Map;)V

    .line 59
    iget-object v0, p0, Lcom/facebook/imagepipeline/producers/StatefulProducerRunnable;->mConsumer:Lcom/facebook/imagepipeline/producers/Consumer;

    invoke-interface {v0, p1}, Lcom/facebook/imagepipeline/producers/Consumer;->onFailure(Ljava/lang/Throwable;)V

    .line 60
    return-void

    .line 58
    :cond_0
    const/4 v0, 0x0

    goto :goto_0
.end method

.method protected onSuccess(Ljava/lang/Object;)V
    .locals 5
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(TT;)V"
        }
    .end annotation

    .prologue
    .line 45
    .local p0, "this":Lcom/facebook/imagepipeline/producers/StatefulProducerRunnable;, "Lcom/facebook/imagepipeline/producers/StatefulProducerRunnable<TT;>;"
    .local p1, "result":Ljava/lang/Object;, "TT;"
    iget-object v1, p0, Lcom/facebook/imagepipeline/producers/StatefulProducerRunnable;->mProducerListener:Lcom/facebook/imagepipeline/producers/ProducerListener;

    iget-object v2, p0, Lcom/facebook/imagepipeline/producers/StatefulProducerRunnable;->mRequestId:Ljava/lang/String;

    iget-object v3, p0, Lcom/facebook/imagepipeline/producers/StatefulProducerRunnable;->mProducerName:Ljava/lang/String;

    iget-object v0, p0, Lcom/facebook/imagepipeline/producers/StatefulProducerRunnable;->mProducerListener:Lcom/facebook/imagepipeline/producers/ProducerListener;

    iget-object v4, p0, Lcom/facebook/imagepipeline/producers/StatefulProducerRunnable;->mRequestId:Ljava/lang/String;

    .line 48
    invoke-interface {v0, v4}, Lcom/facebook/imagepipeline/producers/ProducerListener;->requiresExtraMap(Ljava/lang/String;)Z

    move-result v0

    if-eqz v0, :cond_0

    invoke-virtual {p0, p1}, Lcom/facebook/imagepipeline/producers/StatefulProducerRunnable;->getExtraMapOnSuccess(Ljava/lang/Object;)Ljava/util/Map;

    move-result-object v0

    .line 45
    :goto_0
    invoke-interface {v1, v2, v3, v0}, Lcom/facebook/imagepipeline/producers/ProducerListener;->onProducerFinishWithSuccess(Ljava/lang/String;Ljava/lang/String;Ljava/util/Map;)V

    .line 49
    iget-object v0, p0, Lcom/facebook/imagepipeline/producers/StatefulProducerRunnable;->mConsumer:Lcom/facebook/imagepipeline/producers/Consumer;

    const/4 v1, 0x1

    invoke-interface {v0, p1, v1}, Lcom/facebook/imagepipeline/producers/Consumer;->onNewResult(Ljava/lang/Object;Z)V

    .line 50
    return-void

    .line 48
    :cond_0
    const/4 v0, 0x0

    goto :goto_0
.end method

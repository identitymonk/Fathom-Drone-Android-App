.class Lcom/facebook/imagepipeline/producers/MultiplexProducer$Multiplexer$1;
.super Lcom/facebook/imagepipeline/producers/BaseProducerContextCallbacks;
.source "MultiplexProducer.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/facebook/imagepipeline/producers/MultiplexProducer$Multiplexer;->addCallbacks(Landroid/util/Pair;Lcom/facebook/imagepipeline/producers/ProducerContext;)V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$1:Lcom/facebook/imagepipeline/producers/MultiplexProducer$Multiplexer;

.field final synthetic val$consumerContextPair:Landroid/util/Pair;


# direct methods
.method constructor <init>(Lcom/facebook/imagepipeline/producers/MultiplexProducer$Multiplexer;Landroid/util/Pair;)V
    .locals 0
    .param p1, "this$1"    # Lcom/facebook/imagepipeline/producers/MultiplexProducer$Multiplexer;

    .prologue
    .line 250
    .local p0, "this":Lcom/facebook/imagepipeline/producers/MultiplexProducer$Multiplexer$1;, "Lcom/facebook/imagepipeline/producers/MultiplexProducer$Multiplexer$1;"
    iput-object p1, p0, Lcom/facebook/imagepipeline/producers/MultiplexProducer$Multiplexer$1;->this$1:Lcom/facebook/imagepipeline/producers/MultiplexProducer$Multiplexer;

    iput-object p2, p0, Lcom/facebook/imagepipeline/producers/MultiplexProducer$Multiplexer$1;->val$consumerContextPair:Landroid/util/Pair;

    invoke-direct {p0}, Lcom/facebook/imagepipeline/producers/BaseProducerContextCallbacks;-><init>()V

    return-void
.end method


# virtual methods
.method public onCancellationRequested()V
    .locals 8

    .prologue
    .line 253
    .local p0, "this":Lcom/facebook/imagepipeline/producers/MultiplexProducer$Multiplexer$1;, "Lcom/facebook/imagepipeline/producers/MultiplexProducer$Multiplexer$1;"
    const/4 v0, 0x0

    .line 254
    .local v0, "contextToCancel":Lcom/facebook/imagepipeline/producers/BaseProducerContext;
    const/4 v2, 0x0

    .line 255
    .local v2, "isPrefetchCallbacks":Ljava/util/List;, "Ljava/util/List<Lcom/facebook/imagepipeline/producers/ProducerContextCallbacks;>;"
    const/4 v4, 0x0

    .line 256
    .local v4, "priorityCallbacks":Ljava/util/List;, "Ljava/util/List<Lcom/facebook/imagepipeline/producers/ProducerContextCallbacks;>;"
    const/4 v1, 0x0

    .line 259
    .local v1, "isIntermediateResultExpectedCallbacks":Ljava/util/List;, "Ljava/util/List<Lcom/facebook/imagepipeline/producers/ProducerContextCallbacks;>;"
    iget-object v6, p0, Lcom/facebook/imagepipeline/producers/MultiplexProducer$Multiplexer$1;->this$1:Lcom/facebook/imagepipeline/producers/MultiplexProducer$Multiplexer;

    monitor-enter v6

    .line 260
    :try_start_0
    iget-object v5, p0, Lcom/facebook/imagepipeline/producers/MultiplexProducer$Multiplexer$1;->this$1:Lcom/facebook/imagepipeline/producers/MultiplexProducer$Multiplexer;

    invoke-static {v5}, Lcom/facebook/imagepipeline/producers/MultiplexProducer$Multiplexer;->access$200(Lcom/facebook/imagepipeline/producers/MultiplexProducer$Multiplexer;)Ljava/util/concurrent/CopyOnWriteArraySet;

    move-result-object v5

    iget-object v7, p0, Lcom/facebook/imagepipeline/producers/MultiplexProducer$Multiplexer$1;->val$consumerContextPair:Landroid/util/Pair;

    invoke-virtual {v5, v7}, Ljava/util/concurrent/CopyOnWriteArraySet;->remove(Ljava/lang/Object;)Z

    move-result v3

    .line 261
    .local v3, "pairWasRemoved":Z
    if-eqz v3, :cond_0

    .line 262
    iget-object v5, p0, Lcom/facebook/imagepipeline/producers/MultiplexProducer$Multiplexer$1;->this$1:Lcom/facebook/imagepipeline/producers/MultiplexProducer$Multiplexer;

    invoke-static {v5}, Lcom/facebook/imagepipeline/producers/MultiplexProducer$Multiplexer;->access$200(Lcom/facebook/imagepipeline/producers/MultiplexProducer$Multiplexer;)Ljava/util/concurrent/CopyOnWriteArraySet;

    move-result-object v5

    invoke-virtual {v5}, Ljava/util/concurrent/CopyOnWriteArraySet;->isEmpty()Z

    move-result v5

    if-eqz v5, :cond_3

    .line 263
    iget-object v5, p0, Lcom/facebook/imagepipeline/producers/MultiplexProducer$Multiplexer$1;->this$1:Lcom/facebook/imagepipeline/producers/MultiplexProducer$Multiplexer;

    invoke-static {v5}, Lcom/facebook/imagepipeline/producers/MultiplexProducer$Multiplexer;->access$300(Lcom/facebook/imagepipeline/producers/MultiplexProducer$Multiplexer;)Lcom/facebook/imagepipeline/producers/BaseProducerContext;

    move-result-object v0

    .line 270
    :cond_0
    :goto_0
    monitor-exit v6
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    .line 272
    invoke-static {v2}, Lcom/facebook/imagepipeline/producers/BaseProducerContext;->callOnIsPrefetchChanged(Ljava/util/List;)V

    .line 273
    invoke-static {v4}, Lcom/facebook/imagepipeline/producers/BaseProducerContext;->callOnPriorityChanged(Ljava/util/List;)V

    .line 274
    invoke-static {v1}, Lcom/facebook/imagepipeline/producers/BaseProducerContext;->callOnIsIntermediateResultExpectedChanged(Ljava/util/List;)V

    .line 277
    if-eqz v0, :cond_1

    .line 278
    invoke-virtual {v0}, Lcom/facebook/imagepipeline/producers/BaseProducerContext;->cancel()V

    .line 280
    :cond_1
    if-eqz v3, :cond_2

    .line 281
    iget-object v5, p0, Lcom/facebook/imagepipeline/producers/MultiplexProducer$Multiplexer$1;->val$consumerContextPair:Landroid/util/Pair;

    iget-object v5, v5, Landroid/util/Pair;->first:Ljava/lang/Object;

    check-cast v5, Lcom/facebook/imagepipeline/producers/Consumer;

    invoke-interface {v5}, Lcom/facebook/imagepipeline/producers/Consumer;->onCancellation()V

    .line 283
    :cond_2
    return-void

    .line 265
    :cond_3
    :try_start_1
    iget-object v5, p0, Lcom/facebook/imagepipeline/producers/MultiplexProducer$Multiplexer$1;->this$1:Lcom/facebook/imagepipeline/producers/MultiplexProducer$Multiplexer;

    invoke-static {v5}, Lcom/facebook/imagepipeline/producers/MultiplexProducer$Multiplexer;->access$400(Lcom/facebook/imagepipeline/producers/MultiplexProducer$Multiplexer;)Ljava/util/List;

    move-result-object v2

    .line 266
    iget-object v5, p0, Lcom/facebook/imagepipeline/producers/MultiplexProducer$Multiplexer$1;->this$1:Lcom/facebook/imagepipeline/producers/MultiplexProducer$Multiplexer;

    invoke-static {v5}, Lcom/facebook/imagepipeline/producers/MultiplexProducer$Multiplexer;->access$500(Lcom/facebook/imagepipeline/producers/MultiplexProducer$Multiplexer;)Ljava/util/List;

    move-result-object v4

    .line 267
    iget-object v5, p0, Lcom/facebook/imagepipeline/producers/MultiplexProducer$Multiplexer$1;->this$1:Lcom/facebook/imagepipeline/producers/MultiplexProducer$Multiplexer;

    invoke-static {v5}, Lcom/facebook/imagepipeline/producers/MultiplexProducer$Multiplexer;->access$600(Lcom/facebook/imagepipeline/producers/MultiplexProducer$Multiplexer;)Ljava/util/List;

    move-result-object v1

    goto :goto_0

    .line 270
    .end local v3    # "pairWasRemoved":Z
    :catchall_0
    move-exception v5

    monitor-exit v6
    :try_end_1
    .catchall {:try_start_1 .. :try_end_1} :catchall_0

    throw v5
.end method

.method public onIsIntermediateResultExpectedChanged()V
    .locals 1

    .prologue
    .line 292
    .local p0, "this":Lcom/facebook/imagepipeline/producers/MultiplexProducer$Multiplexer$1;, "Lcom/facebook/imagepipeline/producers/MultiplexProducer$Multiplexer$1;"
    iget-object v0, p0, Lcom/facebook/imagepipeline/producers/MultiplexProducer$Multiplexer$1;->this$1:Lcom/facebook/imagepipeline/producers/MultiplexProducer$Multiplexer;

    .line 293
    invoke-static {v0}, Lcom/facebook/imagepipeline/producers/MultiplexProducer$Multiplexer;->access$600(Lcom/facebook/imagepipeline/producers/MultiplexProducer$Multiplexer;)Ljava/util/List;

    move-result-object v0

    .line 292
    invoke-static {v0}, Lcom/facebook/imagepipeline/producers/BaseProducerContext;->callOnIsIntermediateResultExpectedChanged(Ljava/util/List;)V

    .line 294
    return-void
.end method

.method public onIsPrefetchChanged()V
    .locals 1

    .prologue
    .line 287
    .local p0, "this":Lcom/facebook/imagepipeline/producers/MultiplexProducer$Multiplexer$1;, "Lcom/facebook/imagepipeline/producers/MultiplexProducer$Multiplexer$1;"
    iget-object v0, p0, Lcom/facebook/imagepipeline/producers/MultiplexProducer$Multiplexer$1;->this$1:Lcom/facebook/imagepipeline/producers/MultiplexProducer$Multiplexer;

    invoke-static {v0}, Lcom/facebook/imagepipeline/producers/MultiplexProducer$Multiplexer;->access$400(Lcom/facebook/imagepipeline/producers/MultiplexProducer$Multiplexer;)Ljava/util/List;

    move-result-object v0

    invoke-static {v0}, Lcom/facebook/imagepipeline/producers/BaseProducerContext;->callOnIsPrefetchChanged(Ljava/util/List;)V

    .line 288
    return-void
.end method

.method public onPriorityChanged()V
    .locals 1

    .prologue
    .line 298
    .local p0, "this":Lcom/facebook/imagepipeline/producers/MultiplexProducer$Multiplexer$1;, "Lcom/facebook/imagepipeline/producers/MultiplexProducer$Multiplexer$1;"
    iget-object v0, p0, Lcom/facebook/imagepipeline/producers/MultiplexProducer$Multiplexer$1;->this$1:Lcom/facebook/imagepipeline/producers/MultiplexProducer$Multiplexer;

    invoke-static {v0}, Lcom/facebook/imagepipeline/producers/MultiplexProducer$Multiplexer;->access$500(Lcom/facebook/imagepipeline/producers/MultiplexProducer$Multiplexer;)Ljava/util/List;

    move-result-object v0

    invoke-static {v0}, Lcom/facebook/imagepipeline/producers/BaseProducerContext;->callOnPriorityChanged(Ljava/util/List;)V

    .line 299
    return-void
.end method

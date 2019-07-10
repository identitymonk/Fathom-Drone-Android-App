.class Lcom/facebook/imagepipeline/producers/MediaVariationsFallbackProducer$2;
.super Ljava/lang/Object;
.source "MediaVariationsFallbackProducer.java"

# interfaces
.implements Lbolts/Continuation;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/facebook/imagepipeline/producers/MediaVariationsFallbackProducer;->onFinishDiskReads(Lcom/facebook/imagepipeline/producers/Consumer;Lcom/facebook/imagepipeline/producers/ProducerContext;Lcom/facebook/imagepipeline/request/ImageRequest;Lcom/facebook/imagepipeline/request/MediaVariations;Ljava/util/List;ILjava/util/concurrent/atomic/AtomicBoolean;)Lbolts/Continuation;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation

.annotation system Ldalvik/annotation/Signature;
    value = {
        "Ljava/lang/Object;",
        "Lbolts/Continuation",
        "<",
        "Lcom/facebook/imagepipeline/image/EncodedImage;",
        "Ljava/lang/Void;",
        ">;"
    }
.end annotation


# instance fields
.field final synthetic this$0:Lcom/facebook/imagepipeline/producers/MediaVariationsFallbackProducer;

.field final synthetic val$consumer:Lcom/facebook/imagepipeline/producers/Consumer;

.field final synthetic val$imageRequest:Lcom/facebook/imagepipeline/request/ImageRequest;

.field final synthetic val$isCancelled:Ljava/util/concurrent/atomic/AtomicBoolean;

.field final synthetic val$listener:Lcom/facebook/imagepipeline/producers/ProducerListener;

.field final synthetic val$mediaVariations:Lcom/facebook/imagepipeline/request/MediaVariations;

.field final synthetic val$producerContext:Lcom/facebook/imagepipeline/producers/ProducerContext;

.field final synthetic val$requestId:Ljava/lang/String;

.field final synthetic val$sortedVariants:Ljava/util/List;

.field final synthetic val$variantsIndex:I


# direct methods
.method constructor <init>(Lcom/facebook/imagepipeline/producers/MediaVariationsFallbackProducer;Lcom/facebook/imagepipeline/producers/ProducerListener;Ljava/lang/String;Lcom/facebook/imagepipeline/producers/Consumer;Lcom/facebook/imagepipeline/producers/ProducerContext;Lcom/facebook/imagepipeline/request/MediaVariations;Ljava/util/List;ILcom/facebook/imagepipeline/request/ImageRequest;Ljava/util/concurrent/atomic/AtomicBoolean;)V
    .locals 0
    .param p1, "this$0"    # Lcom/facebook/imagepipeline/producers/MediaVariationsFallbackProducer;

    .prologue
    .line 255
    iput-object p1, p0, Lcom/facebook/imagepipeline/producers/MediaVariationsFallbackProducer$2;->this$0:Lcom/facebook/imagepipeline/producers/MediaVariationsFallbackProducer;

    iput-object p2, p0, Lcom/facebook/imagepipeline/producers/MediaVariationsFallbackProducer$2;->val$listener:Lcom/facebook/imagepipeline/producers/ProducerListener;

    iput-object p3, p0, Lcom/facebook/imagepipeline/producers/MediaVariationsFallbackProducer$2;->val$requestId:Ljava/lang/String;

    iput-object p4, p0, Lcom/facebook/imagepipeline/producers/MediaVariationsFallbackProducer$2;->val$consumer:Lcom/facebook/imagepipeline/producers/Consumer;

    iput-object p5, p0, Lcom/facebook/imagepipeline/producers/MediaVariationsFallbackProducer$2;->val$producerContext:Lcom/facebook/imagepipeline/producers/ProducerContext;

    iput-object p6, p0, Lcom/facebook/imagepipeline/producers/MediaVariationsFallbackProducer$2;->val$mediaVariations:Lcom/facebook/imagepipeline/request/MediaVariations;

    iput-object p7, p0, Lcom/facebook/imagepipeline/producers/MediaVariationsFallbackProducer$2;->val$sortedVariants:Ljava/util/List;

    iput p8, p0, Lcom/facebook/imagepipeline/producers/MediaVariationsFallbackProducer$2;->val$variantsIndex:I

    iput-object p9, p0, Lcom/facebook/imagepipeline/producers/MediaVariationsFallbackProducer$2;->val$imageRequest:Lcom/facebook/imagepipeline/request/ImageRequest;

    iput-object p10, p0, Lcom/facebook/imagepipeline/producers/MediaVariationsFallbackProducer$2;->val$isCancelled:Ljava/util/concurrent/atomic/AtomicBoolean;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public bridge synthetic then(Lbolts/Task;)Ljava/lang/Object;
    .locals 1
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/lang/Exception;
        }
    .end annotation

    .prologue
    .line 255
    invoke-virtual {p0, p1}, Lcom/facebook/imagepipeline/producers/MediaVariationsFallbackProducer$2;->then(Lbolts/Task;)Ljava/lang/Void;

    move-result-object v0

    return-object v0
.end method

.method public then(Lbolts/Task;)Ljava/lang/Void;
    .locals 17
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Lbolts/Task",
            "<",
            "Lcom/facebook/imagepipeline/image/EncodedImage;",
            ">;)",
            "Ljava/lang/Void;"
        }
    .end annotation

    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/lang/Exception;
        }
    .end annotation

    .prologue
    .line 260
    .local p1, "task":Lbolts/Task;, "Lbolts/Task<Lcom/facebook/imagepipeline/image/EncodedImage;>;"
    invoke-static/range {p1 .. p1}, Lcom/facebook/imagepipeline/producers/MediaVariationsFallbackProducer;->access$200(Lbolts/Task;)Z

    move-result v1

    if-eqz v1, :cond_1

    .line 261
    move-object/from16 v0, p0

    iget-object v1, v0, Lcom/facebook/imagepipeline/producers/MediaVariationsFallbackProducer$2;->val$listener:Lcom/facebook/imagepipeline/producers/ProducerListener;

    move-object/from16 v0, p0

    iget-object v2, v0, Lcom/facebook/imagepipeline/producers/MediaVariationsFallbackProducer$2;->val$requestId:Ljava/lang/String;

    const-string v3, "MediaVariationsFallbackProducer"

    const/4 v4, 0x0

    invoke-interface {v1, v2, v3, v4}, Lcom/facebook/imagepipeline/producers/ProducerListener;->onProducerFinishWithCancellation(Ljava/lang/String;Ljava/lang/String;Ljava/util/Map;)V

    .line 262
    move-object/from16 v0, p0

    iget-object v1, v0, Lcom/facebook/imagepipeline/producers/MediaVariationsFallbackProducer$2;->val$consumer:Lcom/facebook/imagepipeline/producers/Consumer;

    invoke-interface {v1}, Lcom/facebook/imagepipeline/producers/Consumer;->onCancellation()V

    .line 263
    const/16 v16, 0x0

    .line 325
    .local v16, "triggerNextProducer":Z
    :goto_0
    if-eqz v16, :cond_0

    .line 326
    move-object/from16 v0, p0

    iget-object v1, v0, Lcom/facebook/imagepipeline/producers/MediaVariationsFallbackProducer$2;->this$0:Lcom/facebook/imagepipeline/producers/MediaVariationsFallbackProducer;

    move-object/from16 v0, p0

    iget-object v2, v0, Lcom/facebook/imagepipeline/producers/MediaVariationsFallbackProducer$2;->val$consumer:Lcom/facebook/imagepipeline/producers/Consumer;

    move-object/from16 v0, p0

    iget-object v3, v0, Lcom/facebook/imagepipeline/producers/MediaVariationsFallbackProducer$2;->val$producerContext:Lcom/facebook/imagepipeline/producers/ProducerContext;

    move-object/from16 v0, p0

    iget-object v4, v0, Lcom/facebook/imagepipeline/producers/MediaVariationsFallbackProducer$2;->val$mediaVariations:Lcom/facebook/imagepipeline/request/MediaVariations;

    .line 329
    invoke-virtual {v4}, Lcom/facebook/imagepipeline/request/MediaVariations;->getMediaId()Ljava/lang/String;

    move-result-object v4

    .line 326
    invoke-static {v1, v2, v3, v4}, Lcom/facebook/imagepipeline/producers/MediaVariationsFallbackProducer;->access$000(Lcom/facebook/imagepipeline/producers/MediaVariationsFallbackProducer;Lcom/facebook/imagepipeline/producers/Consumer;Lcom/facebook/imagepipeline/producers/ProducerContext;Ljava/lang/String;)V

    .line 331
    :cond_0
    const/4 v1, 0x0

    return-object v1

    .line 264
    .end local v16    # "triggerNextProducer":Z
    :cond_1
    invoke-virtual/range {p1 .. p1}, Lbolts/Task;->isFaulted()Z

    move-result v1

    if-eqz v1, :cond_2

    .line 265
    move-object/from16 v0, p0

    iget-object v1, v0, Lcom/facebook/imagepipeline/producers/MediaVariationsFallbackProducer$2;->val$listener:Lcom/facebook/imagepipeline/producers/ProducerListener;

    move-object/from16 v0, p0

    iget-object v2, v0, Lcom/facebook/imagepipeline/producers/MediaVariationsFallbackProducer$2;->val$requestId:Ljava/lang/String;

    const-string v3, "MediaVariationsFallbackProducer"

    invoke-virtual/range {p1 .. p1}, Lbolts/Task;->getError()Ljava/lang/Exception;

    move-result-object v4

    const/4 v5, 0x0

    invoke-interface {v1, v2, v3, v4, v5}, Lcom/facebook/imagepipeline/producers/ProducerListener;->onProducerFinishWithFailure(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;Ljava/util/Map;)V

    .line 266
    move-object/from16 v0, p0

    iget-object v1, v0, Lcom/facebook/imagepipeline/producers/MediaVariationsFallbackProducer$2;->this$0:Lcom/facebook/imagepipeline/producers/MediaVariationsFallbackProducer;

    move-object/from16 v0, p0

    iget-object v2, v0, Lcom/facebook/imagepipeline/producers/MediaVariationsFallbackProducer$2;->val$consumer:Lcom/facebook/imagepipeline/producers/Consumer;

    move-object/from16 v0, p0

    iget-object v3, v0, Lcom/facebook/imagepipeline/producers/MediaVariationsFallbackProducer$2;->val$producerContext:Lcom/facebook/imagepipeline/producers/ProducerContext;

    move-object/from16 v0, p0

    iget-object v4, v0, Lcom/facebook/imagepipeline/producers/MediaVariationsFallbackProducer$2;->val$mediaVariations:Lcom/facebook/imagepipeline/request/MediaVariations;

    .line 269
    invoke-virtual {v4}, Lcom/facebook/imagepipeline/request/MediaVariations;->getMediaId()Ljava/lang/String;

    move-result-object v4

    .line 266
    invoke-static {v1, v2, v3, v4}, Lcom/facebook/imagepipeline/producers/MediaVariationsFallbackProducer;->access$000(Lcom/facebook/imagepipeline/producers/MediaVariationsFallbackProducer;Lcom/facebook/imagepipeline/producers/Consumer;Lcom/facebook/imagepipeline/producers/ProducerContext;Ljava/lang/String;)V

    .line 270
    const/16 v16, 0x1

    .restart local v16    # "triggerNextProducer":Z
    goto :goto_0

    .line 272
    .end local v16    # "triggerNextProducer":Z
    :cond_2
    invoke-virtual/range {p1 .. p1}, Lbolts/Task;->getResult()Ljava/lang/Object;

    move-result-object v15

    check-cast v15, Lcom/facebook/imagepipeline/image/EncodedImage;

    .line 273
    .local v15, "cachedReference":Lcom/facebook/imagepipeline/image/EncodedImage;
    if-eqz v15, :cond_6

    .line 274
    move-object/from16 v0, p0

    iget-object v1, v0, Lcom/facebook/imagepipeline/producers/MediaVariationsFallbackProducer$2;->val$mediaVariations:Lcom/facebook/imagepipeline/request/MediaVariations;

    invoke-virtual {v1}, Lcom/facebook/imagepipeline/request/MediaVariations;->shouldForceRequestForSpecifiedUri()Z

    move-result v1

    if-nez v1, :cond_4

    move-object/from16 v0, p0

    iget-object v1, v0, Lcom/facebook/imagepipeline/producers/MediaVariationsFallbackProducer$2;->val$sortedVariants:Ljava/util/List;

    move-object/from16 v0, p0

    iget v2, v0, Lcom/facebook/imagepipeline/producers/MediaVariationsFallbackProducer$2;->val$variantsIndex:I

    .line 276
    invoke-interface {v1, v2}, Ljava/util/List;->get(I)Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Lcom/facebook/imagepipeline/request/MediaVariations$Variant;

    move-object/from16 v0, p0

    iget-object v2, v0, Lcom/facebook/imagepipeline/producers/MediaVariationsFallbackProducer$2;->val$imageRequest:Lcom/facebook/imagepipeline/request/ImageRequest;

    .line 277
    invoke-virtual {v2}, Lcom/facebook/imagepipeline/request/ImageRequest;->getResizeOptions()Lcom/facebook/imagepipeline/common/ResizeOptions;

    move-result-object v2

    .line 275
    invoke-static {v1, v2}, Lcom/facebook/imagepipeline/producers/MediaVariationsFallbackProducer;->access$300(Lcom/facebook/imagepipeline/request/MediaVariations$Variant;Lcom/facebook/imagepipeline/common/ResizeOptions;)Z

    move-result v1

    if-eqz v1, :cond_4

    const/4 v6, 0x1

    .line 278
    .local v6, "useAsLastResult":Z
    :goto_1
    move-object/from16 v0, p0

    iget-object v7, v0, Lcom/facebook/imagepipeline/producers/MediaVariationsFallbackProducer$2;->val$listener:Lcom/facebook/imagepipeline/producers/ProducerListener;

    move-object/from16 v0, p0

    iget-object v8, v0, Lcom/facebook/imagepipeline/producers/MediaVariationsFallbackProducer$2;->val$requestId:Ljava/lang/String;

    const-string v9, "MediaVariationsFallbackProducer"

    move-object/from16 v0, p0

    iget-object v1, v0, Lcom/facebook/imagepipeline/producers/MediaVariationsFallbackProducer$2;->val$listener:Lcom/facebook/imagepipeline/producers/ProducerListener;

    move-object/from16 v0, p0

    iget-object v2, v0, Lcom/facebook/imagepipeline/producers/MediaVariationsFallbackProducer$2;->val$requestId:Ljava/lang/String;

    const/4 v3, 0x1

    move-object/from16 v0, p0

    iget-object v4, v0, Lcom/facebook/imagepipeline/producers/MediaVariationsFallbackProducer$2;->val$sortedVariants:Ljava/util/List;

    .line 285
    invoke-interface {v4}, Ljava/util/List;->size()I

    move-result v4

    move-object/from16 v0, p0

    iget-object v5, v0, Lcom/facebook/imagepipeline/producers/MediaVariationsFallbackProducer$2;->val$mediaVariations:Lcom/facebook/imagepipeline/request/MediaVariations;

    .line 286
    invoke-virtual {v5}, Lcom/facebook/imagepipeline/request/MediaVariations;->getSource()Ljava/lang/String;

    move-result-object v5

    .line 281
    invoke-static/range {v1 .. v6}, Lcom/facebook/imagepipeline/producers/MediaVariationsFallbackProducer;->getExtraMap(Lcom/facebook/imagepipeline/producers/ProducerListener;Ljava/lang/String;ZILjava/lang/String;Z)Ljava/util/Map;

    move-result-object v1

    .line 278
    invoke-interface {v7, v8, v9, v1}, Lcom/facebook/imagepipeline/producers/ProducerListener;->onProducerFinishWithSuccess(Ljava/lang/String;Ljava/lang/String;Ljava/util/Map;)V

    .line 289
    if-eqz v6, :cond_3

    .line 290
    move-object/from16 v0, p0

    iget-object v1, v0, Lcom/facebook/imagepipeline/producers/MediaVariationsFallbackProducer$2;->val$listener:Lcom/facebook/imagepipeline/producers/ProducerListener;

    move-object/from16 v0, p0

    iget-object v2, v0, Lcom/facebook/imagepipeline/producers/MediaVariationsFallbackProducer$2;->val$requestId:Ljava/lang/String;

    const-string v3, "MediaVariationsFallbackProducer"

    const/4 v4, 0x1

    invoke-interface {v1, v2, v3, v4}, Lcom/facebook/imagepipeline/producers/ProducerListener;->onUltimateProducerReached(Ljava/lang/String;Ljava/lang/String;Z)V

    .line 291
    move-object/from16 v0, p0

    iget-object v1, v0, Lcom/facebook/imagepipeline/producers/MediaVariationsFallbackProducer$2;->val$consumer:Lcom/facebook/imagepipeline/producers/Consumer;

    const/high16 v2, 0x3f800000    # 1.0f

    invoke-interface {v1, v2}, Lcom/facebook/imagepipeline/producers/Consumer;->onProgressUpdate(F)V

    .line 293
    :cond_3
    move-object/from16 v0, p0

    iget-object v1, v0, Lcom/facebook/imagepipeline/producers/MediaVariationsFallbackProducer$2;->val$consumer:Lcom/facebook/imagepipeline/producers/Consumer;

    invoke-interface {v1, v15, v6}, Lcom/facebook/imagepipeline/producers/Consumer;->onNewResult(Ljava/lang/Object;Z)V

    .line 294
    invoke-virtual {v15}, Lcom/facebook/imagepipeline/image/EncodedImage;->close()V

    .line 296
    if-nez v6, :cond_5

    const/16 v16, 0x1

    .line 297
    .restart local v16    # "triggerNextProducer":Z
    :goto_2
    goto/16 :goto_0

    .line 275
    .end local v6    # "useAsLastResult":Z
    .end local v16    # "triggerNextProducer":Z
    :cond_4
    const/4 v6, 0x0

    goto :goto_1

    .line 296
    .restart local v6    # "useAsLastResult":Z
    :cond_5
    const/16 v16, 0x0

    goto :goto_2

    .line 297
    .end local v6    # "useAsLastResult":Z
    :cond_6
    move-object/from16 v0, p0

    iget v1, v0, Lcom/facebook/imagepipeline/producers/MediaVariationsFallbackProducer$2;->val$variantsIndex:I

    move-object/from16 v0, p0

    iget-object v2, v0, Lcom/facebook/imagepipeline/producers/MediaVariationsFallbackProducer$2;->val$sortedVariants:Ljava/util/List;

    invoke-interface {v2}, Ljava/util/List;->size()I

    move-result v2

    add-int/lit8 v2, v2, -0x1

    if-ge v1, v2, :cond_7

    .line 300
    move-object/from16 v0, p0

    iget-object v7, v0, Lcom/facebook/imagepipeline/producers/MediaVariationsFallbackProducer$2;->this$0:Lcom/facebook/imagepipeline/producers/MediaVariationsFallbackProducer;

    move-object/from16 v0, p0

    iget-object v8, v0, Lcom/facebook/imagepipeline/producers/MediaVariationsFallbackProducer$2;->val$consumer:Lcom/facebook/imagepipeline/producers/Consumer;

    move-object/from16 v0, p0

    iget-object v9, v0, Lcom/facebook/imagepipeline/producers/MediaVariationsFallbackProducer$2;->val$producerContext:Lcom/facebook/imagepipeline/producers/ProducerContext;

    move-object/from16 v0, p0

    iget-object v10, v0, Lcom/facebook/imagepipeline/producers/MediaVariationsFallbackProducer$2;->val$imageRequest:Lcom/facebook/imagepipeline/request/ImageRequest;

    move-object/from16 v0, p0

    iget-object v11, v0, Lcom/facebook/imagepipeline/producers/MediaVariationsFallbackProducer$2;->val$mediaVariations:Lcom/facebook/imagepipeline/request/MediaVariations;

    move-object/from16 v0, p0

    iget-object v12, v0, Lcom/facebook/imagepipeline/producers/MediaVariationsFallbackProducer$2;->val$sortedVariants:Ljava/util/List;

    move-object/from16 v0, p0

    iget v1, v0, Lcom/facebook/imagepipeline/producers/MediaVariationsFallbackProducer$2;->val$variantsIndex:I

    add-int/lit8 v13, v1, 0x1

    move-object/from16 v0, p0

    iget-object v14, v0, Lcom/facebook/imagepipeline/producers/MediaVariationsFallbackProducer$2;->val$isCancelled:Ljava/util/concurrent/atomic/AtomicBoolean;

    invoke-static/range {v7 .. v14}, Lcom/facebook/imagepipeline/producers/MediaVariationsFallbackProducer;->access$400(Lcom/facebook/imagepipeline/producers/MediaVariationsFallbackProducer;Lcom/facebook/imagepipeline/producers/Consumer;Lcom/facebook/imagepipeline/producers/ProducerContext;Lcom/facebook/imagepipeline/request/ImageRequest;Lcom/facebook/imagepipeline/request/MediaVariations;Ljava/util/List;ILjava/util/concurrent/atomic/AtomicBoolean;)Lbolts/Task;

    .line 309
    const/16 v16, 0x0

    .restart local v16    # "triggerNextProducer":Z
    goto/16 :goto_0

    .line 311
    .end local v16    # "triggerNextProducer":Z
    :cond_7
    move-object/from16 v0, p0

    iget-object v1, v0, Lcom/facebook/imagepipeline/producers/MediaVariationsFallbackProducer$2;->val$listener:Lcom/facebook/imagepipeline/producers/ProducerListener;

    move-object/from16 v0, p0

    iget-object v2, v0, Lcom/facebook/imagepipeline/producers/MediaVariationsFallbackProducer$2;->val$requestId:Ljava/lang/String;

    const-string v3, "MediaVariationsFallbackProducer"

    move-object/from16 v0, p0

    iget-object v7, v0, Lcom/facebook/imagepipeline/producers/MediaVariationsFallbackProducer$2;->val$listener:Lcom/facebook/imagepipeline/producers/ProducerListener;

    move-object/from16 v0, p0

    iget-object v8, v0, Lcom/facebook/imagepipeline/producers/MediaVariationsFallbackProducer$2;->val$requestId:Ljava/lang/String;

    const/4 v9, 0x0

    move-object/from16 v0, p0

    iget-object v4, v0, Lcom/facebook/imagepipeline/producers/MediaVariationsFallbackProducer$2;->val$sortedVariants:Ljava/util/List;

    .line 318
    invoke-interface {v4}, Ljava/util/List;->size()I

    move-result v10

    move-object/from16 v0, p0

    iget-object v4, v0, Lcom/facebook/imagepipeline/producers/MediaVariationsFallbackProducer$2;->val$mediaVariations:Lcom/facebook/imagepipeline/request/MediaVariations;

    .line 319
    invoke-virtual {v4}, Lcom/facebook/imagepipeline/request/MediaVariations;->getSource()Ljava/lang/String;

    move-result-object v11

    const/4 v12, 0x0

    .line 314
    invoke-static/range {v7 .. v12}, Lcom/facebook/imagepipeline/producers/MediaVariationsFallbackProducer;->getExtraMap(Lcom/facebook/imagepipeline/producers/ProducerListener;Ljava/lang/String;ZILjava/lang/String;Z)Ljava/util/Map;

    move-result-object v4

    .line 311
    invoke-interface {v1, v2, v3, v4}, Lcom/facebook/imagepipeline/producers/ProducerListener;->onProducerFinishWithSuccess(Ljava/lang/String;Ljava/lang/String;Ljava/util/Map;)V

    .line 321
    const/16 v16, 0x1

    .restart local v16    # "triggerNextProducer":Z
    goto/16 :goto_0
.end method

.class Lcom/facebook/imagepipeline/producers/WebpTranscodeProducer$1;
.super Lcom/facebook/imagepipeline/producers/StatefulProducerRunnable;
.source "WebpTranscodeProducer.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/facebook/imagepipeline/producers/WebpTranscodeProducer;->transcodeLastResult(Lcom/facebook/imagepipeline/image/EncodedImage;Lcom/facebook/imagepipeline/producers/Consumer;Lcom/facebook/imagepipeline/producers/ProducerContext;)V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation

.annotation system Ldalvik/annotation/Signature;
    value = {
        "Lcom/facebook/imagepipeline/producers/StatefulProducerRunnable",
        "<",
        "Lcom/facebook/imagepipeline/image/EncodedImage;",
        ">;"
    }
.end annotation


# instance fields
.field final synthetic this$0:Lcom/facebook/imagepipeline/producers/WebpTranscodeProducer;

.field final synthetic val$encodedImageCopy:Lcom/facebook/imagepipeline/image/EncodedImage;


# direct methods
.method constructor <init>(Lcom/facebook/imagepipeline/producers/WebpTranscodeProducer;Lcom/facebook/imagepipeline/producers/Consumer;Lcom/facebook/imagepipeline/producers/ProducerListener;Ljava/lang/String;Ljava/lang/String;Lcom/facebook/imagepipeline/image/EncodedImage;)V
    .locals 0
    .param p1, "this$0"    # Lcom/facebook/imagepipeline/producers/WebpTranscodeProducer;
    .param p3, "producerListener"    # Lcom/facebook/imagepipeline/producers/ProducerListener;
    .param p4, "producerName"    # Ljava/lang/String;
    .param p5, "requestId"    # Ljava/lang/String;

    .prologue
    .line 107
    .local p2, "consumer":Lcom/facebook/imagepipeline/producers/Consumer;, "Lcom/facebook/imagepipeline/producers/Consumer<Lcom/facebook/imagepipeline/image/EncodedImage;>;"
    iput-object p1, p0, Lcom/facebook/imagepipeline/producers/WebpTranscodeProducer$1;->this$0:Lcom/facebook/imagepipeline/producers/WebpTranscodeProducer;

    iput-object p6, p0, Lcom/facebook/imagepipeline/producers/WebpTranscodeProducer$1;->val$encodedImageCopy:Lcom/facebook/imagepipeline/image/EncodedImage;

    invoke-direct {p0, p2, p3, p4, p5}, Lcom/facebook/imagepipeline/producers/StatefulProducerRunnable;-><init>(Lcom/facebook/imagepipeline/producers/Consumer;Lcom/facebook/imagepipeline/producers/ProducerListener;Ljava/lang/String;Ljava/lang/String;)V

    return-void
.end method


# virtual methods
.method protected disposeResult(Lcom/facebook/imagepipeline/image/EncodedImage;)V
    .locals 0
    .param p1, "result"    # Lcom/facebook/imagepipeline/image/EncodedImage;

    .prologue
    .line 129
    invoke-static {p1}, Lcom/facebook/imagepipeline/image/EncodedImage;->closeSafely(Lcom/facebook/imagepipeline/image/EncodedImage;)V

    .line 130
    return-void
.end method

.method protected bridge synthetic disposeResult(Ljava/lang/Object;)V
    .locals 0

    .prologue
    .line 107
    check-cast p1, Lcom/facebook/imagepipeline/image/EncodedImage;

    invoke-virtual {p0, p1}, Lcom/facebook/imagepipeline/producers/WebpTranscodeProducer$1;->disposeResult(Lcom/facebook/imagepipeline/image/EncodedImage;)V

    return-void
.end method

.method protected getResult()Lcom/facebook/imagepipeline/image/EncodedImage;
    .locals 4
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/lang/Exception;
        }
    .end annotation

    .prologue
    .line 110
    iget-object v3, p0, Lcom/facebook/imagepipeline/producers/WebpTranscodeProducer$1;->this$0:Lcom/facebook/imagepipeline/producers/WebpTranscodeProducer;

    invoke-static {v3}, Lcom/facebook/imagepipeline/producers/WebpTranscodeProducer;->access$200(Lcom/facebook/imagepipeline/producers/WebpTranscodeProducer;)Lcom/facebook/common/memory/PooledByteBufferFactory;

    move-result-object v3

    invoke-interface {v3}, Lcom/facebook/common/memory/PooledByteBufferFactory;->newOutputStream()Lcom/facebook/common/memory/PooledByteBufferOutputStream;

    move-result-object v1

    .line 112
    .local v1, "outputStream":Lcom/facebook/common/memory/PooledByteBufferOutputStream;
    :try_start_0
    iget-object v3, p0, Lcom/facebook/imagepipeline/producers/WebpTranscodeProducer$1;->val$encodedImageCopy:Lcom/facebook/imagepipeline/image/EncodedImage;

    invoke-static {v3, v1}, Lcom/facebook/imagepipeline/producers/WebpTranscodeProducer;->access$300(Lcom/facebook/imagepipeline/image/EncodedImage;Lcom/facebook/common/memory/PooledByteBufferOutputStream;)V

    .line 114
    invoke-virtual {v1}, Lcom/facebook/common/memory/PooledByteBufferOutputStream;->toByteBuffer()Lcom/facebook/common/memory/PooledByteBuffer;

    move-result-object v3

    invoke-static {v3}, Lcom/facebook/common/references/CloseableReference;->of(Ljava/io/Closeable;)Lcom/facebook/common/references/CloseableReference;
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_1

    move-result-object v2

    .line 116
    .local v2, "ref":Lcom/facebook/common/references/CloseableReference;, "Lcom/facebook/common/references/CloseableReference<Lcom/facebook/common/memory/PooledByteBuffer;>;"
    :try_start_1
    new-instance v0, Lcom/facebook/imagepipeline/image/EncodedImage;

    invoke-direct {v0, v2}, Lcom/facebook/imagepipeline/image/EncodedImage;-><init>(Lcom/facebook/common/references/CloseableReference;)V

    .line 117
    .local v0, "encodedImage":Lcom/facebook/imagepipeline/image/EncodedImage;
    iget-object v3, p0, Lcom/facebook/imagepipeline/producers/WebpTranscodeProducer$1;->val$encodedImageCopy:Lcom/facebook/imagepipeline/image/EncodedImage;

    invoke-virtual {v0, v3}, Lcom/facebook/imagepipeline/image/EncodedImage;->copyMetaDataFrom(Lcom/facebook/imagepipeline/image/EncodedImage;)V
    :try_end_1
    .catchall {:try_start_1 .. :try_end_1} :catchall_0

    .line 120
    :try_start_2
    invoke-static {v2}, Lcom/facebook/common/references/CloseableReference;->closeSafely(Lcom/facebook/common/references/CloseableReference;)V
    :try_end_2
    .catchall {:try_start_2 .. :try_end_2} :catchall_1

    .line 123
    invoke-virtual {v1}, Lcom/facebook/common/memory/PooledByteBufferOutputStream;->close()V

    return-object v0

    .line 120
    .end local v0    # "encodedImage":Lcom/facebook/imagepipeline/image/EncodedImage;
    :catchall_0
    move-exception v3

    :try_start_3
    invoke-static {v2}, Lcom/facebook/common/references/CloseableReference;->closeSafely(Lcom/facebook/common/references/CloseableReference;)V

    throw v3
    :try_end_3
    .catchall {:try_start_3 .. :try_end_3} :catchall_1

    .line 123
    .end local v2    # "ref":Lcom/facebook/common/references/CloseableReference;, "Lcom/facebook/common/references/CloseableReference<Lcom/facebook/common/memory/PooledByteBuffer;>;"
    :catchall_1
    move-exception v3

    invoke-virtual {v1}, Lcom/facebook/common/memory/PooledByteBufferOutputStream;->close()V

    throw v3
.end method

.method protected bridge synthetic getResult()Ljava/lang/Object;
    .locals 1
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/lang/Exception;
        }
    .end annotation

    .prologue
    .line 107
    invoke-virtual {p0}, Lcom/facebook/imagepipeline/producers/WebpTranscodeProducer$1;->getResult()Lcom/facebook/imagepipeline/image/EncodedImage;

    move-result-object v0

    return-object v0
.end method

.method protected onCancellation()V
    .locals 1

    .prologue
    .line 146
    iget-object v0, p0, Lcom/facebook/imagepipeline/producers/WebpTranscodeProducer$1;->val$encodedImageCopy:Lcom/facebook/imagepipeline/image/EncodedImage;

    invoke-static {v0}, Lcom/facebook/imagepipeline/image/EncodedImage;->closeSafely(Lcom/facebook/imagepipeline/image/EncodedImage;)V

    .line 147
    invoke-super {p0}, Lcom/facebook/imagepipeline/producers/StatefulProducerRunnable;->onCancellation()V

    .line 148
    return-void
.end method

.method protected onFailure(Ljava/lang/Exception;)V
    .locals 1
    .param p1, "e"    # Ljava/lang/Exception;

    .prologue
    .line 140
    iget-object v0, p0, Lcom/facebook/imagepipeline/producers/WebpTranscodeProducer$1;->val$encodedImageCopy:Lcom/facebook/imagepipeline/image/EncodedImage;

    invoke-static {v0}, Lcom/facebook/imagepipeline/image/EncodedImage;->closeSafely(Lcom/facebook/imagepipeline/image/EncodedImage;)V

    .line 141
    invoke-super {p0, p1}, Lcom/facebook/imagepipeline/producers/StatefulProducerRunnable;->onFailure(Ljava/lang/Exception;)V

    .line 142
    return-void
.end method

.method protected onSuccess(Lcom/facebook/imagepipeline/image/EncodedImage;)V
    .locals 1
    .param p1, "result"    # Lcom/facebook/imagepipeline/image/EncodedImage;

    .prologue
    .line 134
    iget-object v0, p0, Lcom/facebook/imagepipeline/producers/WebpTranscodeProducer$1;->val$encodedImageCopy:Lcom/facebook/imagepipeline/image/EncodedImage;

    invoke-static {v0}, Lcom/facebook/imagepipeline/image/EncodedImage;->closeSafely(Lcom/facebook/imagepipeline/image/EncodedImage;)V

    .line 135
    invoke-super {p0, p1}, Lcom/facebook/imagepipeline/producers/StatefulProducerRunnable;->onSuccess(Ljava/lang/Object;)V

    .line 136
    return-void
.end method

.method protected bridge synthetic onSuccess(Ljava/lang/Object;)V
    .locals 0

    .prologue
    .line 107
    check-cast p1, Lcom/facebook/imagepipeline/image/EncodedImage;

    invoke-virtual {p0, p1}, Lcom/facebook/imagepipeline/producers/WebpTranscodeProducer$1;->onSuccess(Lcom/facebook/imagepipeline/image/EncodedImage;)V

    return-void
.end method

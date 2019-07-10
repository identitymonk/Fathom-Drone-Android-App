.class Lcom/facebook/imagepipeline/cache/BufferedDiskCache$2;
.super Ljava/lang/Object;
.source "BufferedDiskCache.java"

# interfaces
.implements Ljava/util/concurrent/Callable;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/facebook/imagepipeline/cache/BufferedDiskCache;->getAsync(Lcom/facebook/cache/common/CacheKey;Ljava/util/concurrent/atomic/AtomicBoolean;)Lbolts/Task;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation

.annotation system Ldalvik/annotation/Signature;
    value = {
        "Ljava/lang/Object;",
        "Ljava/util/concurrent/Callable",
        "<",
        "Lcom/facebook/imagepipeline/image/EncodedImage;",
        ">;"
    }
.end annotation


# instance fields
.field final synthetic this$0:Lcom/facebook/imagepipeline/cache/BufferedDiskCache;

.field final synthetic val$isCancelled:Ljava/util/concurrent/atomic/AtomicBoolean;

.field final synthetic val$key:Lcom/facebook/cache/common/CacheKey;


# direct methods
.method constructor <init>(Lcom/facebook/imagepipeline/cache/BufferedDiskCache;Ljava/util/concurrent/atomic/AtomicBoolean;Lcom/facebook/cache/common/CacheKey;)V
    .locals 0
    .param p1, "this$0"    # Lcom/facebook/imagepipeline/cache/BufferedDiskCache;

    .prologue
    .line 168
    iput-object p1, p0, Lcom/facebook/imagepipeline/cache/BufferedDiskCache$2;->this$0:Lcom/facebook/imagepipeline/cache/BufferedDiskCache;

    iput-object p2, p0, Lcom/facebook/imagepipeline/cache/BufferedDiskCache$2;->val$isCancelled:Ljava/util/concurrent/atomic/AtomicBoolean;

    iput-object p3, p0, Lcom/facebook/imagepipeline/cache/BufferedDiskCache$2;->val$key:Lcom/facebook/cache/common/CacheKey;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public call()Lcom/facebook/imagepipeline/image/EncodedImage;
    .locals 8
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/lang/Exception;
        }
    .end annotation

    .prologue
    .line 172
    iget-object v5, p0, Lcom/facebook/imagepipeline/cache/BufferedDiskCache$2;->val$isCancelled:Ljava/util/concurrent/atomic/AtomicBoolean;

    invoke-virtual {v5}, Ljava/util/concurrent/atomic/AtomicBoolean;->get()Z

    move-result v5

    if-eqz v5, :cond_0

    .line 173
    new-instance v5, Ljava/util/concurrent/CancellationException;

    invoke-direct {v5}, Ljava/util/concurrent/CancellationException;-><init>()V

    throw v5

    .line 175
    :cond_0
    iget-object v5, p0, Lcom/facebook/imagepipeline/cache/BufferedDiskCache$2;->this$0:Lcom/facebook/imagepipeline/cache/BufferedDiskCache;

    invoke-static {v5}, Lcom/facebook/imagepipeline/cache/BufferedDiskCache;->access$100(Lcom/facebook/imagepipeline/cache/BufferedDiskCache;)Lcom/facebook/imagepipeline/cache/StagingArea;

    move-result-object v5

    iget-object v6, p0, Lcom/facebook/imagepipeline/cache/BufferedDiskCache$2;->val$key:Lcom/facebook/cache/common/CacheKey;

    invoke-virtual {v5, v6}, Lcom/facebook/imagepipeline/cache/StagingArea;->get(Lcom/facebook/cache/common/CacheKey;)Lcom/facebook/imagepipeline/image/EncodedImage;

    move-result-object v3

    .line 176
    .local v3, "result":Lcom/facebook/imagepipeline/image/EncodedImage;
    if-eqz v3, :cond_2

    .line 177
    invoke-static {}, Lcom/facebook/imagepipeline/cache/BufferedDiskCache;->access$200()Ljava/lang/Class;

    move-result-object v5

    const-string v6, "Found image for %s in staging area"

    iget-object v7, p0, Lcom/facebook/imagepipeline/cache/BufferedDiskCache$2;->val$key:Lcom/facebook/cache/common/CacheKey;

    invoke-interface {v7}, Lcom/facebook/cache/common/CacheKey;->getUriString()Ljava/lang/String;

    move-result-object v7

    invoke-static {v5, v6, v7}, Lcom/facebook/common/logging/FLog;->v(Ljava/lang/Class;Ljava/lang/String;Ljava/lang/Object;)V

    .line 178
    iget-object v5, p0, Lcom/facebook/imagepipeline/cache/BufferedDiskCache$2;->this$0:Lcom/facebook/imagepipeline/cache/BufferedDiskCache;

    invoke-static {v5}, Lcom/facebook/imagepipeline/cache/BufferedDiskCache;->access$300(Lcom/facebook/imagepipeline/cache/BufferedDiskCache;)Lcom/facebook/imagepipeline/cache/ImageCacheStatsTracker;

    move-result-object v5

    iget-object v6, p0, Lcom/facebook/imagepipeline/cache/BufferedDiskCache$2;->val$key:Lcom/facebook/cache/common/CacheKey;

    invoke-interface {v5, v6}, Lcom/facebook/imagepipeline/cache/ImageCacheStatsTracker;->onStagingAreaHit(Lcom/facebook/cache/common/CacheKey;)V

    .line 179
    iget-object v5, p0, Lcom/facebook/imagepipeline/cache/BufferedDiskCache$2;->val$key:Lcom/facebook/cache/common/CacheKey;

    invoke-virtual {v3, v5}, Lcom/facebook/imagepipeline/image/EncodedImage;->setEncodedCacheKey(Lcom/facebook/cache/common/CacheKey;)V

    .line 198
    :goto_0
    invoke-static {}, Ljava/lang/Thread;->interrupted()Z

    move-result v5

    if-eqz v5, :cond_3

    .line 199
    invoke-static {}, Lcom/facebook/imagepipeline/cache/BufferedDiskCache;->access$200()Ljava/lang/Class;

    move-result-object v5

    const-string v6, "Host thread was interrupted, decreasing reference count"

    invoke-static {v5, v6}, Lcom/facebook/common/logging/FLog;->v(Ljava/lang/Class;Ljava/lang/String;)V

    .line 200
    if-eqz v3, :cond_1

    .line 201
    invoke-virtual {v3}, Lcom/facebook/imagepipeline/image/EncodedImage;->close()V

    .line 203
    :cond_1
    new-instance v5, Ljava/lang/InterruptedException;

    invoke-direct {v5}, Ljava/lang/InterruptedException;-><init>()V

    throw v5

    .line 181
    :cond_2
    invoke-static {}, Lcom/facebook/imagepipeline/cache/BufferedDiskCache;->access$200()Ljava/lang/Class;

    move-result-object v5

    const-string v6, "Did not find image for %s in staging area"

    iget-object v7, p0, Lcom/facebook/imagepipeline/cache/BufferedDiskCache$2;->val$key:Lcom/facebook/cache/common/CacheKey;

    invoke-interface {v7}, Lcom/facebook/cache/common/CacheKey;->getUriString()Ljava/lang/String;

    move-result-object v7

    invoke-static {v5, v6, v7}, Lcom/facebook/common/logging/FLog;->v(Ljava/lang/Class;Ljava/lang/String;Ljava/lang/Object;)V

    .line 182
    iget-object v5, p0, Lcom/facebook/imagepipeline/cache/BufferedDiskCache$2;->this$0:Lcom/facebook/imagepipeline/cache/BufferedDiskCache;

    invoke-static {v5}, Lcom/facebook/imagepipeline/cache/BufferedDiskCache;->access$300(Lcom/facebook/imagepipeline/cache/BufferedDiskCache;)Lcom/facebook/imagepipeline/cache/ImageCacheStatsTracker;

    move-result-object v5

    invoke-interface {v5}, Lcom/facebook/imagepipeline/cache/ImageCacheStatsTracker;->onStagingAreaMiss()V

    .line 185
    :try_start_0
    iget-object v5, p0, Lcom/facebook/imagepipeline/cache/BufferedDiskCache$2;->this$0:Lcom/facebook/imagepipeline/cache/BufferedDiskCache;

    iget-object v6, p0, Lcom/facebook/imagepipeline/cache/BufferedDiskCache$2;->val$key:Lcom/facebook/cache/common/CacheKey;

    invoke-static {v5, v6}, Lcom/facebook/imagepipeline/cache/BufferedDiskCache;->access$400(Lcom/facebook/imagepipeline/cache/BufferedDiskCache;Lcom/facebook/cache/common/CacheKey;)Lcom/facebook/common/memory/PooledByteBuffer;

    move-result-object v0

    .line 186
    .local v0, "buffer":Lcom/facebook/common/memory/PooledByteBuffer;
    invoke-static {v0}, Lcom/facebook/common/references/CloseableReference;->of(Ljava/io/Closeable;)Lcom/facebook/common/references/CloseableReference;
    :try_end_0
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_0

    move-result-object v2

    .line 188
    .local v2, "ref":Lcom/facebook/common/references/CloseableReference;, "Lcom/facebook/common/references/CloseableReference<Lcom/facebook/common/memory/PooledByteBuffer;>;"
    :try_start_1
    new-instance v4, Lcom/facebook/imagepipeline/image/EncodedImage;

    invoke-direct {v4, v2}, Lcom/facebook/imagepipeline/image/EncodedImage;-><init>(Lcom/facebook/common/references/CloseableReference;)V
    :try_end_1
    .catchall {:try_start_1 .. :try_end_1} :catchall_0

    .line 189
    .end local v3    # "result":Lcom/facebook/imagepipeline/image/EncodedImage;
    .local v4, "result":Lcom/facebook/imagepipeline/image/EncodedImage;
    :try_start_2
    iget-object v5, p0, Lcom/facebook/imagepipeline/cache/BufferedDiskCache$2;->val$key:Lcom/facebook/cache/common/CacheKey;

    invoke-virtual {v4, v5}, Lcom/facebook/imagepipeline/image/EncodedImage;->setEncodedCacheKey(Lcom/facebook/cache/common/CacheKey;)V
    :try_end_2
    .catchall {:try_start_2 .. :try_end_2} :catchall_1

    .line 191
    :try_start_3
    invoke-static {v2}, Lcom/facebook/common/references/CloseableReference;->closeSafely(Lcom/facebook/common/references/CloseableReference;)V
    :try_end_3
    .catch Ljava/lang/Exception; {:try_start_3 .. :try_end_3} :catch_1

    move-object v3, v4

    .line 195
    .end local v4    # "result":Lcom/facebook/imagepipeline/image/EncodedImage;
    .restart local v3    # "result":Lcom/facebook/imagepipeline/image/EncodedImage;
    goto :goto_0

    .line 191
    :catchall_0
    move-exception v5

    :goto_1
    :try_start_4
    invoke-static {v2}, Lcom/facebook/common/references/CloseableReference;->closeSafely(Lcom/facebook/common/references/CloseableReference;)V

    throw v5
    :try_end_4
    .catch Ljava/lang/Exception; {:try_start_4 .. :try_end_4} :catch_0

    .line 193
    .end local v0    # "buffer":Lcom/facebook/common/memory/PooledByteBuffer;
    .end local v2    # "ref":Lcom/facebook/common/references/CloseableReference;, "Lcom/facebook/common/references/CloseableReference<Lcom/facebook/common/memory/PooledByteBuffer;>;"
    :catch_0
    move-exception v1

    .line 194
    .local v1, "exception":Ljava/lang/Exception;
    :goto_2
    const/4 v5, 0x0

    .line 205
    .end local v1    # "exception":Ljava/lang/Exception;
    :goto_3
    return-object v5

    :cond_3
    move-object v5, v3

    goto :goto_3

    .line 193
    .end local v3    # "result":Lcom/facebook/imagepipeline/image/EncodedImage;
    .restart local v0    # "buffer":Lcom/facebook/common/memory/PooledByteBuffer;
    .restart local v2    # "ref":Lcom/facebook/common/references/CloseableReference;, "Lcom/facebook/common/references/CloseableReference<Lcom/facebook/common/memory/PooledByteBuffer;>;"
    .restart local v4    # "result":Lcom/facebook/imagepipeline/image/EncodedImage;
    :catch_1
    move-exception v1

    move-object v3, v4

    .end local v4    # "result":Lcom/facebook/imagepipeline/image/EncodedImage;
    .restart local v3    # "result":Lcom/facebook/imagepipeline/image/EncodedImage;
    goto :goto_2

    .line 191
    .end local v3    # "result":Lcom/facebook/imagepipeline/image/EncodedImage;
    .restart local v4    # "result":Lcom/facebook/imagepipeline/image/EncodedImage;
    :catchall_1
    move-exception v5

    move-object v3, v4

    .end local v4    # "result":Lcom/facebook/imagepipeline/image/EncodedImage;
    .restart local v3    # "result":Lcom/facebook/imagepipeline/image/EncodedImage;
    goto :goto_1
.end method

.method public bridge synthetic call()Ljava/lang/Object;
    .locals 1
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/lang/Exception;
        }
    .end annotation

    .prologue
    .line 168
    invoke-virtual {p0}, Lcom/facebook/imagepipeline/cache/BufferedDiskCache$2;->call()Lcom/facebook/imagepipeline/image/EncodedImage;

    move-result-object v0

    return-object v0
.end method

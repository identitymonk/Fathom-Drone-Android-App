.class Lcom/facebook/imagepipeline/cache/BufferedDiskCache$3;
.super Ljava/lang/Object;
.source "BufferedDiskCache.java"

# interfaces
.implements Ljava/lang/Runnable;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/facebook/imagepipeline/cache/BufferedDiskCache;->put(Lcom/facebook/cache/common/CacheKey;Lcom/facebook/imagepipeline/image/EncodedImage;)V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$0:Lcom/facebook/imagepipeline/cache/BufferedDiskCache;

.field final synthetic val$finalEncodedImage:Lcom/facebook/imagepipeline/image/EncodedImage;

.field final synthetic val$key:Lcom/facebook/cache/common/CacheKey;


# direct methods
.method constructor <init>(Lcom/facebook/imagepipeline/cache/BufferedDiskCache;Lcom/facebook/cache/common/CacheKey;Lcom/facebook/imagepipeline/image/EncodedImage;)V
    .locals 0
    .param p1, "this$0"    # Lcom/facebook/imagepipeline/cache/BufferedDiskCache;

    .prologue
    .line 242
    iput-object p1, p0, Lcom/facebook/imagepipeline/cache/BufferedDiskCache$3;->this$0:Lcom/facebook/imagepipeline/cache/BufferedDiskCache;

    iput-object p2, p0, Lcom/facebook/imagepipeline/cache/BufferedDiskCache$3;->val$key:Lcom/facebook/cache/common/CacheKey;

    iput-object p3, p0, Lcom/facebook/imagepipeline/cache/BufferedDiskCache$3;->val$finalEncodedImage:Lcom/facebook/imagepipeline/image/EncodedImage;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public run()V
    .locals 4

    .prologue
    .line 246
    :try_start_0
    iget-object v0, p0, Lcom/facebook/imagepipeline/cache/BufferedDiskCache$3;->this$0:Lcom/facebook/imagepipeline/cache/BufferedDiskCache;

    iget-object v1, p0, Lcom/facebook/imagepipeline/cache/BufferedDiskCache$3;->val$key:Lcom/facebook/cache/common/CacheKey;

    iget-object v2, p0, Lcom/facebook/imagepipeline/cache/BufferedDiskCache$3;->val$finalEncodedImage:Lcom/facebook/imagepipeline/image/EncodedImage;

    invoke-static {v0, v1, v2}, Lcom/facebook/imagepipeline/cache/BufferedDiskCache;->access$500(Lcom/facebook/imagepipeline/cache/BufferedDiskCache;Lcom/facebook/cache/common/CacheKey;Lcom/facebook/imagepipeline/image/EncodedImage;)V
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    .line 248
    iget-object v0, p0, Lcom/facebook/imagepipeline/cache/BufferedDiskCache$3;->this$0:Lcom/facebook/imagepipeline/cache/BufferedDiskCache;

    invoke-static {v0}, Lcom/facebook/imagepipeline/cache/BufferedDiskCache;->access$100(Lcom/facebook/imagepipeline/cache/BufferedDiskCache;)Lcom/facebook/imagepipeline/cache/StagingArea;

    move-result-object v0

    iget-object v1, p0, Lcom/facebook/imagepipeline/cache/BufferedDiskCache$3;->val$key:Lcom/facebook/cache/common/CacheKey;

    iget-object v2, p0, Lcom/facebook/imagepipeline/cache/BufferedDiskCache$3;->val$finalEncodedImage:Lcom/facebook/imagepipeline/image/EncodedImage;

    invoke-virtual {v0, v1, v2}, Lcom/facebook/imagepipeline/cache/StagingArea;->remove(Lcom/facebook/cache/common/CacheKey;Lcom/facebook/imagepipeline/image/EncodedImage;)Z

    .line 249
    iget-object v0, p0, Lcom/facebook/imagepipeline/cache/BufferedDiskCache$3;->val$finalEncodedImage:Lcom/facebook/imagepipeline/image/EncodedImage;

    invoke-static {v0}, Lcom/facebook/imagepipeline/image/EncodedImage;->closeSafely(Lcom/facebook/imagepipeline/image/EncodedImage;)V

    .line 251
    return-void

    .line 248
    :catchall_0
    move-exception v0

    iget-object v1, p0, Lcom/facebook/imagepipeline/cache/BufferedDiskCache$3;->this$0:Lcom/facebook/imagepipeline/cache/BufferedDiskCache;

    invoke-static {v1}, Lcom/facebook/imagepipeline/cache/BufferedDiskCache;->access$100(Lcom/facebook/imagepipeline/cache/BufferedDiskCache;)Lcom/facebook/imagepipeline/cache/StagingArea;

    move-result-object v1

    iget-object v2, p0, Lcom/facebook/imagepipeline/cache/BufferedDiskCache$3;->val$key:Lcom/facebook/cache/common/CacheKey;

    iget-object v3, p0, Lcom/facebook/imagepipeline/cache/BufferedDiskCache$3;->val$finalEncodedImage:Lcom/facebook/imagepipeline/image/EncodedImage;

    invoke-virtual {v1, v2, v3}, Lcom/facebook/imagepipeline/cache/StagingArea;->remove(Lcom/facebook/cache/common/CacheKey;Lcom/facebook/imagepipeline/image/EncodedImage;)Z

    .line 249
    iget-object v1, p0, Lcom/facebook/imagepipeline/cache/BufferedDiskCache$3;->val$finalEncodedImage:Lcom/facebook/imagepipeline/image/EncodedImage;

    invoke-static {v1}, Lcom/facebook/imagepipeline/image/EncodedImage;->closeSafely(Lcom/facebook/imagepipeline/image/EncodedImage;)V

    throw v0
.end method

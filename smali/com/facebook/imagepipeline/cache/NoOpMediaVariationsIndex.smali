.class public Lcom/facebook/imagepipeline/cache/NoOpMediaVariationsIndex;
.super Ljava/lang/Object;
.source "NoOpMediaVariationsIndex.java"

# interfaces
.implements Lcom/facebook/imagepipeline/cache/MediaVariationsIndex;


# direct methods
.method public constructor <init>()V
    .locals 0

    .prologue
    .line 19
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public getCachedVariants(Ljava/lang/String;Lcom/facebook/imagepipeline/request/MediaVariations$Builder;)Lbolts/Task;
    .locals 1
    .param p1, "mediaId"    # Ljava/lang/String;
    .param p2, "mediaVariationsBuilder"    # Lcom/facebook/imagepipeline/request/MediaVariations$Builder;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/lang/String;",
            "Lcom/facebook/imagepipeline/request/MediaVariations$Builder;",
            ")",
            "Lbolts/Task",
            "<",
            "Lcom/facebook/imagepipeline/request/MediaVariations;",
            ">;"
        }
    .end annotation

    .prologue
    .line 25
    const/4 v0, 0x0

    invoke-static {v0}, Lbolts/Task;->forResult(Ljava/lang/Object;)Lbolts/Task;

    move-result-object v0

    return-object v0
.end method

.method public saveCachedVariant(Ljava/lang/String;Lcom/facebook/imagepipeline/request/ImageRequest$CacheChoice;Lcom/facebook/cache/common/CacheKey;Lcom/facebook/imagepipeline/image/EncodedImage;)V
    .locals 0
    .param p1, "mediaId"    # Ljava/lang/String;
    .param p2, "cacheChoice"    # Lcom/facebook/imagepipeline/request/ImageRequest$CacheChoice;
    .param p3, "cacheKey"    # Lcom/facebook/cache/common/CacheKey;
    .param p4, "encodedImage"    # Lcom/facebook/imagepipeline/image/EncodedImage;

    .prologue
    .line 35
    return-void
.end method

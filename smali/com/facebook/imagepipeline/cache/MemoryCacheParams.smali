.class public Lcom/facebook/imagepipeline/cache/MemoryCacheParams;
.super Ljava/lang/Object;
.source "MemoryCacheParams.java"


# instance fields
.field public final maxCacheEntries:I

.field public final maxCacheEntrySize:I

.field public final maxCacheSize:I

.field public final maxEvictionQueueEntries:I

.field public final maxEvictionQueueSize:I


# direct methods
.method public constructor <init>(IIIII)V
    .locals 0
    .param p1, "maxCacheSize"    # I
    .param p2, "maxCacheEntries"    # I
    .param p3, "maxEvictionQueueSize"    # I
    .param p4, "maxEvictionQueueEntries"    # I
    .param p5, "maxCacheEntrySize"    # I

    .prologue
    .line 39
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 40
    iput p1, p0, Lcom/facebook/imagepipeline/cache/MemoryCacheParams;->maxCacheSize:I

    .line 41
    iput p2, p0, Lcom/facebook/imagepipeline/cache/MemoryCacheParams;->maxCacheEntries:I

    .line 42
    iput p3, p0, Lcom/facebook/imagepipeline/cache/MemoryCacheParams;->maxEvictionQueueSize:I

    .line 43
    iput p4, p0, Lcom/facebook/imagepipeline/cache/MemoryCacheParams;->maxEvictionQueueEntries:I

    .line 44
    iput p5, p0, Lcom/facebook/imagepipeline/cache/MemoryCacheParams;->maxCacheEntrySize:I

    .line 45
    return-void
.end method

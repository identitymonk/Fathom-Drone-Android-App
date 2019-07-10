.class public Lcom/facebook/imagepipeline/cache/DefaultEncodedMemoryCacheParamsSupplier;
.super Ljava/lang/Object;
.source "DefaultEncodedMemoryCacheParamsSupplier.java"

# interfaces
.implements Lcom/facebook/common/internal/Supplier;


# annotations
.annotation system Ldalvik/annotation/Signature;
    value = {
        "Ljava/lang/Object;",
        "Lcom/facebook/common/internal/Supplier",
        "<",
        "Lcom/facebook/imagepipeline/cache/MemoryCacheParams;",
        ">;"
    }
.end annotation


# static fields
.field private static final MAX_CACHE_ENTRIES:I = 0x7fffffff

.field private static final MAX_EVICTION_QUEUE_ENTRIES:I = 0x7fffffff


# direct methods
.method public constructor <init>()V
    .locals 0

    .prologue
    .line 18
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method

.method private getMaxCacheSize()I
    .locals 6

    .prologue
    .line 37
    invoke-static {}, Ljava/lang/Runtime;->getRuntime()Ljava/lang/Runtime;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/Runtime;->maxMemory()J

    move-result-wide v2

    const-wide/32 v4, 0x7fffffff

    invoke-static {v2, v3, v4, v5}, Ljava/lang/Math;->min(JJ)J

    move-result-wide v2

    long-to-int v0, v2

    .line 38
    .local v0, "maxMemory":I
    const/high16 v1, 0x1000000

    if-ge v0, v1, :cond_0

    .line 39
    const/high16 v1, 0x100000

    .line 43
    :goto_0
    return v1

    .line 40
    :cond_0
    const/high16 v1, 0x2000000

    if-ge v0, v1, :cond_1

    .line 41
    const/high16 v1, 0x200000

    goto :goto_0

    .line 43
    :cond_1
    const/high16 v1, 0x400000

    goto :goto_0
.end method


# virtual methods
.method public get()Lcom/facebook/imagepipeline/cache/MemoryCacheParams;
    .locals 6

    .prologue
    const v2, 0x7fffffff

    .line 26
    invoke-direct {p0}, Lcom/facebook/imagepipeline/cache/DefaultEncodedMemoryCacheParamsSupplier;->getMaxCacheSize()I

    move-result v1

    .line 27
    .local v1, "maxCacheSize":I
    div-int/lit8 v5, v1, 0x8

    .line 28
    .local v5, "maxCacheEntrySize":I
    new-instance v0, Lcom/facebook/imagepipeline/cache/MemoryCacheParams;

    move v3, v1

    move v4, v2

    invoke-direct/range {v0 .. v5}, Lcom/facebook/imagepipeline/cache/MemoryCacheParams;-><init>(IIIII)V

    return-object v0
.end method

.method public bridge synthetic get()Ljava/lang/Object;
    .locals 1

    .prologue
    .line 18
    invoke-virtual {p0}, Lcom/facebook/imagepipeline/cache/DefaultEncodedMemoryCacheParamsSupplier;->get()Lcom/facebook/imagepipeline/cache/MemoryCacheParams;

    move-result-object v0

    return-object v0
.end method

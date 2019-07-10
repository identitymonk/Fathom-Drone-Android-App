.class Lcom/facebook/imagepipeline/memory/OOMSoftReferenceBucket;
.super Lcom/facebook/imagepipeline/memory/Bucket;
.source "OOMSoftReferenceBucket.java"


# annotations
.annotation system Ldalvik/annotation/Signature;
    value = {
        "<V:",
        "Ljava/lang/Object;",
        ">",
        "Lcom/facebook/imagepipeline/memory/Bucket",
        "<TV;>;"
    }
.end annotation

.annotation build Ljavax/annotation/concurrent/NotThreadSafe;
.end annotation


# instance fields
.field private mSpareReferences:Ljava/util/LinkedList;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/LinkedList",
            "<",
            "Lcom/facebook/common/references/OOMSoftReference",
            "<TV;>;>;"
        }
    .end annotation
.end field


# direct methods
.method public constructor <init>(III)V
    .locals 1
    .param p1, "itemSize"    # I
    .param p2, "maxLength"    # I
    .param p3, "inUseLength"    # I

    .prologue
    .line 27
    .local p0, "this":Lcom/facebook/imagepipeline/memory/OOMSoftReferenceBucket;, "Lcom/facebook/imagepipeline/memory/OOMSoftReferenceBucket<TV;>;"
    invoke-direct {p0, p1, p2, p3}, Lcom/facebook/imagepipeline/memory/Bucket;-><init>(III)V

    .line 28
    new-instance v0, Ljava/util/LinkedList;

    invoke-direct {v0}, Ljava/util/LinkedList;-><init>()V

    iput-object v0, p0, Lcom/facebook/imagepipeline/memory/OOMSoftReferenceBucket;->mSpareReferences:Ljava/util/LinkedList;

    .line 29
    return-void
.end method


# virtual methods
.method addToFreeList(Ljava/lang/Object;)V
    .locals 2
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(TV;)V"
        }
    .end annotation

    .prologue
    .line 42
    .local p0, "this":Lcom/facebook/imagepipeline/memory/OOMSoftReferenceBucket;, "Lcom/facebook/imagepipeline/memory/OOMSoftReferenceBucket<TV;>;"
    .local p1, "value":Ljava/lang/Object;, "TV;"
    iget-object v1, p0, Lcom/facebook/imagepipeline/memory/OOMSoftReferenceBucket;->mSpareReferences:Ljava/util/LinkedList;

    invoke-virtual {v1}, Ljava/util/LinkedList;->poll()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/facebook/common/references/OOMSoftReference;

    .line 43
    .local v0, "ref":Lcom/facebook/common/references/OOMSoftReference;, "Lcom/facebook/common/references/OOMSoftReference<TV;>;"
    if-nez v0, :cond_0

    .line 44
    new-instance v0, Lcom/facebook/common/references/OOMSoftReference;

    .end local v0    # "ref":Lcom/facebook/common/references/OOMSoftReference;, "Lcom/facebook/common/references/OOMSoftReference<TV;>;"
    invoke-direct {v0}, Lcom/facebook/common/references/OOMSoftReference;-><init>()V

    .line 46
    .restart local v0    # "ref":Lcom/facebook/common/references/OOMSoftReference;, "Lcom/facebook/common/references/OOMSoftReference<TV;>;"
    :cond_0
    invoke-virtual {v0, p1}, Lcom/facebook/common/references/OOMSoftReference;->set(Ljava/lang/Object;)V

    .line 47
    iget-object v1, p0, Lcom/facebook/imagepipeline/memory/OOMSoftReferenceBucket;->mFreeList:Ljava/util/Queue;

    invoke-interface {v1, v0}, Ljava/util/Queue;->add(Ljava/lang/Object;)Z

    .line 48
    return-void
.end method

.method public pop()Ljava/lang/Object;
    .locals 3
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()TV;"
        }
    .end annotation

    .prologue
    .line 33
    .local p0, "this":Lcom/facebook/imagepipeline/memory/OOMSoftReferenceBucket;, "Lcom/facebook/imagepipeline/memory/OOMSoftReferenceBucket<TV;>;"
    iget-object v2, p0, Lcom/facebook/imagepipeline/memory/OOMSoftReferenceBucket;->mFreeList:Ljava/util/Queue;

    invoke-interface {v2}, Ljava/util/Queue;->poll()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/facebook/common/references/OOMSoftReference;

    .line 34
    .local v0, "ref":Lcom/facebook/common/references/OOMSoftReference;, "Lcom/facebook/common/references/OOMSoftReference<TV;>;"
    invoke-virtual {v0}, Lcom/facebook/common/references/OOMSoftReference;->get()Ljava/lang/Object;

    move-result-object v1

    .line 35
    .local v1, "value":Ljava/lang/Object;, "TV;"
    invoke-virtual {v0}, Lcom/facebook/common/references/OOMSoftReference;->clear()V

    .line 36
    iget-object v2, p0, Lcom/facebook/imagepipeline/memory/OOMSoftReferenceBucket;->mSpareReferences:Ljava/util/LinkedList;

    invoke-virtual {v2, v0}, Ljava/util/LinkedList;->add(Ljava/lang/Object;)Z

    .line 37
    return-object v1
.end method

.class public Lcom/facebook/imagepipeline/memory/PoolParams;
.super Ljava/lang/Object;
.source "PoolParams.java"


# static fields
.field public static final IGNORE_THREADS:I = -0x1


# instance fields
.field public final bucketSizes:Landroid/util/SparseIntArray;

.field public final maxBucketSize:I

.field public final maxNumThreads:I

.field public final maxSizeHardCap:I

.field public final maxSizeSoftCap:I

.field public final minBucketSize:I


# direct methods
.method public constructor <init>(IILandroid/util/SparseIntArray;)V
    .locals 7
    .param p1, "maxSizeSoftCap"    # I
    .param p2, "maxSizeHardCap"    # I
    .param p3, "bucketSizes"    # Landroid/util/SparseIntArray;
        .annotation runtime Ljavax/annotation/Nullable;
        .end annotation
    .end param

    .prologue
    .line 82
    const/4 v4, 0x0

    const v5, 0x7fffffff

    const/4 v6, -0x1

    move-object v0, p0

    move v1, p1

    move v2, p2

    move-object v3, p3

    invoke-direct/range {v0 .. v6}, Lcom/facebook/imagepipeline/memory/PoolParams;-><init>(IILandroid/util/SparseIntArray;III)V

    .line 83
    return-void
.end method

.method public constructor <init>(IILandroid/util/SparseIntArray;III)V
    .locals 1
    .param p1, "maxSizeSoftCap"    # I
    .param p2, "maxSizeHardCap"    # I
    .param p3, "bucketSizes"    # Landroid/util/SparseIntArray;
        .annotation runtime Ljavax/annotation/Nullable;
        .end annotation
    .end param
    .param p4, "minBucketSize"    # I
    .param p5, "maxBucketSize"    # I
    .param p6, "maxNumThreads"    # I

    .prologue
    .line 100
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 101
    if-ltz p1, :cond_0

    if-lt p2, p1, :cond_0

    const/4 v0, 0x1

    :goto_0
    invoke-static {v0}, Lcom/facebook/common/internal/Preconditions;->checkState(Z)V

    .line 102
    iput p1, p0, Lcom/facebook/imagepipeline/memory/PoolParams;->maxSizeSoftCap:I

    .line 103
    iput p2, p0, Lcom/facebook/imagepipeline/memory/PoolParams;->maxSizeHardCap:I

    .line 104
    iput-object p3, p0, Lcom/facebook/imagepipeline/memory/PoolParams;->bucketSizes:Landroid/util/SparseIntArray;

    .line 105
    iput p4, p0, Lcom/facebook/imagepipeline/memory/PoolParams;->minBucketSize:I

    .line 106
    iput p5, p0, Lcom/facebook/imagepipeline/memory/PoolParams;->maxBucketSize:I

    .line 107
    iput p6, p0, Lcom/facebook/imagepipeline/memory/PoolParams;->maxNumThreads:I

    .line 108
    return-void

    .line 101
    :cond_0
    const/4 v0, 0x0

    goto :goto_0
.end method

.method public constructor <init>(ILandroid/util/SparseIntArray;)V
    .locals 7
    .param p1, "maxSize"    # I
    .param p2, "bucketSizes"    # Landroid/util/SparseIntArray;
        .annotation runtime Ljavax/annotation/Nullable;
        .end annotation
    .end param

    .prologue
    .line 72
    const/4 v4, 0x0

    const v5, 0x7fffffff

    const/4 v6, -0x1

    move-object v0, p0

    move v1, p1

    move v2, p1

    move-object v3, p2

    invoke-direct/range {v0 .. v6}, Lcom/facebook/imagepipeline/memory/PoolParams;-><init>(IILandroid/util/SparseIntArray;III)V

    .line 73
    return-void
.end method

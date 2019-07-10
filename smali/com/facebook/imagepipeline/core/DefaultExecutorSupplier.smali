.class public Lcom/facebook/imagepipeline/core/DefaultExecutorSupplier;
.super Ljava/lang/Object;
.source "DefaultExecutorSupplier.java"

# interfaces
.implements Lcom/facebook/imagepipeline/core/ExecutorSupplier;


# static fields
.field private static final NUM_IO_BOUND_THREADS:I = 0x2

.field private static final NUM_LIGHTWEIGHT_BACKGROUND_THREADS:I = 0x1


# instance fields
.field private final mBackgroundExecutor:Ljava/util/concurrent/Executor;

.field private final mDecodeExecutor:Ljava/util/concurrent/Executor;

.field private final mIoBoundExecutor:Ljava/util/concurrent/Executor;

.field private final mLightWeightBackgroundExecutor:Ljava/util/concurrent/Executor;


# direct methods
.method public constructor <init>(I)V
    .locals 2
    .param p1, "numCpuBoundThreads"    # I

    .prologue
    .line 34
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 35
    new-instance v0, Lcom/facebook/imagepipeline/core/PriorityThreadFactory;

    const/16 v1, 0xa

    invoke-direct {v0, v1}, Lcom/facebook/imagepipeline/core/PriorityThreadFactory;-><init>(I)V

    .line 38
    .local v0, "backgroundPriorityThreadFactory":Ljava/util/concurrent/ThreadFactory;
    const/4 v1, 0x2

    invoke-static {v1}, Ljava/util/concurrent/Executors;->newFixedThreadPool(I)Ljava/util/concurrent/ExecutorService;

    move-result-object v1

    iput-object v1, p0, Lcom/facebook/imagepipeline/core/DefaultExecutorSupplier;->mIoBoundExecutor:Ljava/util/concurrent/Executor;

    .line 39
    invoke-static {p1, v0}, Ljava/util/concurrent/Executors;->newFixedThreadPool(ILjava/util/concurrent/ThreadFactory;)Ljava/util/concurrent/ExecutorService;

    move-result-object v1

    iput-object v1, p0, Lcom/facebook/imagepipeline/core/DefaultExecutorSupplier;->mDecodeExecutor:Ljava/util/concurrent/Executor;

    .line 42
    invoke-static {p1, v0}, Ljava/util/concurrent/Executors;->newFixedThreadPool(ILjava/util/concurrent/ThreadFactory;)Ljava/util/concurrent/ExecutorService;

    move-result-object v1

    iput-object v1, p0, Lcom/facebook/imagepipeline/core/DefaultExecutorSupplier;->mBackgroundExecutor:Ljava/util/concurrent/Executor;

    .line 45
    const/4 v1, 0x1

    invoke-static {v1, v0}, Ljava/util/concurrent/Executors;->newFixedThreadPool(ILjava/util/concurrent/ThreadFactory;)Ljava/util/concurrent/ExecutorService;

    move-result-object v1

    iput-object v1, p0, Lcom/facebook/imagepipeline/core/DefaultExecutorSupplier;->mLightWeightBackgroundExecutor:Ljava/util/concurrent/Executor;

    .line 49
    return-void
.end method


# virtual methods
.method public forBackgroundTasks()Ljava/util/concurrent/Executor;
    .locals 1

    .prologue
    .line 68
    iget-object v0, p0, Lcom/facebook/imagepipeline/core/DefaultExecutorSupplier;->mBackgroundExecutor:Ljava/util/concurrent/Executor;

    return-object v0
.end method

.method public forDecode()Ljava/util/concurrent/Executor;
    .locals 1

    .prologue
    .line 63
    iget-object v0, p0, Lcom/facebook/imagepipeline/core/DefaultExecutorSupplier;->mDecodeExecutor:Ljava/util/concurrent/Executor;

    return-object v0
.end method

.method public forLightweightBackgroundTasks()Ljava/util/concurrent/Executor;
    .locals 1

    .prologue
    .line 73
    iget-object v0, p0, Lcom/facebook/imagepipeline/core/DefaultExecutorSupplier;->mLightWeightBackgroundExecutor:Ljava/util/concurrent/Executor;

    return-object v0
.end method

.method public forLocalStorageRead()Ljava/util/concurrent/Executor;
    .locals 1

    .prologue
    .line 53
    iget-object v0, p0, Lcom/facebook/imagepipeline/core/DefaultExecutorSupplier;->mIoBoundExecutor:Ljava/util/concurrent/Executor;

    return-object v0
.end method

.method public forLocalStorageWrite()Ljava/util/concurrent/Executor;
    .locals 1

    .prologue
    .line 58
    iget-object v0, p0, Lcom/facebook/imagepipeline/core/DefaultExecutorSupplier;->mIoBoundExecutor:Ljava/util/concurrent/Executor;

    return-object v0
.end method

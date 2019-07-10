.class public Lcom/facebook/imagepipeline/datasource/ListDataSource;
.super Lcom/facebook/datasource/AbstractDataSource;
.source "ListDataSource.java"


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lcom/facebook/imagepipeline/datasource/ListDataSource$InternalDataSubscriber;
    }
.end annotation

.annotation system Ldalvik/annotation/Signature;
    value = {
        "<T:",
        "Ljava/lang/Object;",
        ">",
        "Lcom/facebook/datasource/AbstractDataSource",
        "<",
        "Ljava/util/List",
        "<",
        "Lcom/facebook/common/references/CloseableReference",
        "<TT;>;>;>;"
    }
.end annotation


# instance fields
.field private final mDataSources:[Lcom/facebook/datasource/DataSource;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "[",
            "Lcom/facebook/datasource/DataSource",
            "<",
            "Lcom/facebook/common/references/CloseableReference",
            "<TT;>;>;"
        }
    .end annotation
.end field

.field private mFinishedDataSources:I
    .annotation build Ljavax/annotation/concurrent/GuardedBy;
        value = "this"
    .end annotation
.end field


# direct methods
.method protected constructor <init>([Lcom/facebook/datasource/DataSource;)V
    .locals 1
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "([",
            "Lcom/facebook/datasource/DataSource",
            "<",
            "Lcom/facebook/common/references/CloseableReference",
            "<TT;>;>;)V"
        }
    .end annotation

    .prologue
    .line 40
    .local p0, "this":Lcom/facebook/imagepipeline/datasource/ListDataSource;, "Lcom/facebook/imagepipeline/datasource/ListDataSource<TT;>;"
    .local p1, "dataSources":[Lcom/facebook/datasource/DataSource;, "[Lcom/facebook/datasource/DataSource<Lcom/facebook/common/references/CloseableReference<TT;>;>;"
    invoke-direct {p0}, Lcom/facebook/datasource/AbstractDataSource;-><init>()V

    .line 41
    iput-object p1, p0, Lcom/facebook/imagepipeline/datasource/ListDataSource;->mDataSources:[Lcom/facebook/datasource/DataSource;

    .line 42
    const/4 v0, 0x0

    iput v0, p0, Lcom/facebook/imagepipeline/datasource/ListDataSource;->mFinishedDataSources:I

    .line 43
    return-void
.end method

.method static synthetic access$100(Lcom/facebook/imagepipeline/datasource/ListDataSource;Lcom/facebook/datasource/DataSource;)V
    .locals 0
    .param p0, "x0"    # Lcom/facebook/imagepipeline/datasource/ListDataSource;
    .param p1, "x1"    # Lcom/facebook/datasource/DataSource;

    .prologue
    .line 35
    invoke-direct {p0, p1}, Lcom/facebook/imagepipeline/datasource/ListDataSource;->onDataSourceFailed(Lcom/facebook/datasource/DataSource;)V

    return-void
.end method

.method static synthetic access$200(Lcom/facebook/imagepipeline/datasource/ListDataSource;)V
    .locals 0
    .param p0, "x0"    # Lcom/facebook/imagepipeline/datasource/ListDataSource;

    .prologue
    .line 35
    invoke-direct {p0}, Lcom/facebook/imagepipeline/datasource/ListDataSource;->onDataSourceCancelled()V

    return-void
.end method

.method static synthetic access$300(Lcom/facebook/imagepipeline/datasource/ListDataSource;)V
    .locals 0
    .param p0, "x0"    # Lcom/facebook/imagepipeline/datasource/ListDataSource;

    .prologue
    .line 35
    invoke-direct {p0}, Lcom/facebook/imagepipeline/datasource/ListDataSource;->onDataSourceFinished()V

    return-void
.end method

.method static synthetic access$400(Lcom/facebook/imagepipeline/datasource/ListDataSource;)V
    .locals 0
    .param p0, "x0"    # Lcom/facebook/imagepipeline/datasource/ListDataSource;

    .prologue
    .line 35
    invoke-direct {p0}, Lcom/facebook/imagepipeline/datasource/ListDataSource;->onDataSourceProgress()V

    return-void
.end method

.method public static varargs create([Lcom/facebook/datasource/DataSource;)Lcom/facebook/imagepipeline/datasource/ListDataSource;
    .locals 6
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "<T:",
            "Ljava/lang/Object;",
            ">([",
            "Lcom/facebook/datasource/DataSource",
            "<",
            "Lcom/facebook/common/references/CloseableReference",
            "<TT;>;>;)",
            "Lcom/facebook/imagepipeline/datasource/ListDataSource",
            "<TT;>;"
        }
    .end annotation

    .prologue
    .local p0, "dataSources":[Lcom/facebook/datasource/DataSource;, "[Lcom/facebook/datasource/DataSource<Lcom/facebook/common/references/CloseableReference<TT;>;>;"
    const/4 v3, 0x0

    .line 47
    invoke-static {p0}, Lcom/facebook/common/internal/Preconditions;->checkNotNull(Ljava/lang/Object;)Ljava/lang/Object;

    .line 48
    array-length v2, p0

    if-lez v2, :cond_1

    const/4 v2, 0x1

    :goto_0
    invoke-static {v2}, Lcom/facebook/common/internal/Preconditions;->checkState(Z)V

    .line 49
    new-instance v1, Lcom/facebook/imagepipeline/datasource/ListDataSource;

    invoke-direct {v1, p0}, Lcom/facebook/imagepipeline/datasource/ListDataSource;-><init>([Lcom/facebook/datasource/DataSource;)V

    .line 50
    .local v1, "listDataSource":Lcom/facebook/imagepipeline/datasource/ListDataSource;, "Lcom/facebook/imagepipeline/datasource/ListDataSource<TT;>;"
    array-length v2, p0

    :goto_1
    if-ge v3, v2, :cond_2

    aget-object v0, p0, v3

    .line 51
    .local v0, "dataSource":Lcom/facebook/datasource/DataSource;, "Lcom/facebook/datasource/DataSource<Lcom/facebook/common/references/CloseableReference<TT;>;>;"
    if-eqz v0, :cond_0

    .line 52
    new-instance v4, Lcom/facebook/imagepipeline/datasource/ListDataSource$InternalDataSubscriber;

    invoke-virtual {v1}, Ljava/lang/Object;->getClass()Ljava/lang/Class;

    const/4 v5, 0x0

    invoke-direct {v4, v1, v5}, Lcom/facebook/imagepipeline/datasource/ListDataSource$InternalDataSubscriber;-><init>(Lcom/facebook/imagepipeline/datasource/ListDataSource;Lcom/facebook/imagepipeline/datasource/ListDataSource$1;)V

    .line 54
    invoke-static {}, Lcom/facebook/common/executors/CallerThreadExecutor;->getInstance()Lcom/facebook/common/executors/CallerThreadExecutor;

    move-result-object v5

    .line 52
    invoke-interface {v0, v4, v5}, Lcom/facebook/datasource/DataSource;->subscribe(Lcom/facebook/datasource/DataSubscriber;Ljava/util/concurrent/Executor;)V

    .line 50
    :cond_0
    add-int/lit8 v3, v3, 0x1

    goto :goto_1

    .end local v0    # "dataSource":Lcom/facebook/datasource/DataSource;, "Lcom/facebook/datasource/DataSource<Lcom/facebook/common/references/CloseableReference<TT;>;>;"
    .end local v1    # "listDataSource":Lcom/facebook/imagepipeline/datasource/ListDataSource;, "Lcom/facebook/imagepipeline/datasource/ListDataSource<TT;>;"
    :cond_1
    move v2, v3

    .line 48
    goto :goto_0

    .line 57
    .restart local v1    # "listDataSource":Lcom/facebook/imagepipeline/datasource/ListDataSource;, "Lcom/facebook/imagepipeline/datasource/ListDataSource<TT;>;"
    :cond_2
    return-object v1
.end method

.method private declared-synchronized increaseAndCheckIfLast()Z
    .locals 2

    .prologue
    .line 96
    .local p0, "this":Lcom/facebook/imagepipeline/datasource/ListDataSource;, "Lcom/facebook/imagepipeline/datasource/ListDataSource<TT;>;"
    monitor-enter p0

    :try_start_0
    iget v0, p0, Lcom/facebook/imagepipeline/datasource/ListDataSource;->mFinishedDataSources:I

    add-int/lit8 v0, v0, 0x1

    iput v0, p0, Lcom/facebook/imagepipeline/datasource/ListDataSource;->mFinishedDataSources:I

    iget-object v1, p0, Lcom/facebook/imagepipeline/datasource/ListDataSource;->mDataSources:[Lcom/facebook/datasource/DataSource;

    array-length v1, v1
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    if-ne v0, v1, :cond_0

    const/4 v0, 0x1

    :goto_0
    monitor-exit p0

    return v0

    :cond_0
    const/4 v0, 0x0

    goto :goto_0

    :catchall_0
    move-exception v0

    monitor-exit p0

    throw v0
.end method

.method private onDataSourceCancelled()V
    .locals 1

    .prologue
    .line 104
    .local p0, "this":Lcom/facebook/imagepipeline/datasource/ListDataSource;, "Lcom/facebook/imagepipeline/datasource/ListDataSource<TT;>;"
    new-instance v0, Ljava/util/concurrent/CancellationException;

    invoke-direct {v0}, Ljava/util/concurrent/CancellationException;-><init>()V

    invoke-virtual {p0, v0}, Lcom/facebook/imagepipeline/datasource/ListDataSource;->setFailure(Ljava/lang/Throwable;)Z

    .line 105
    return-void
.end method

.method private onDataSourceFailed(Lcom/facebook/datasource/DataSource;)V
    .locals 1
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Lcom/facebook/datasource/DataSource",
            "<",
            "Lcom/facebook/common/references/CloseableReference",
            "<TT;>;>;)V"
        }
    .end annotation

    .prologue
    .line 100
    .local p0, "this":Lcom/facebook/imagepipeline/datasource/ListDataSource;, "Lcom/facebook/imagepipeline/datasource/ListDataSource<TT;>;"
    .local p1, "dataSource":Lcom/facebook/datasource/DataSource;, "Lcom/facebook/datasource/DataSource<Lcom/facebook/common/references/CloseableReference<TT;>;>;"
    invoke-interface {p1}, Lcom/facebook/datasource/DataSource;->getFailureCause()Ljava/lang/Throwable;

    move-result-object v0

    invoke-virtual {p0, v0}, Lcom/facebook/imagepipeline/datasource/ListDataSource;->setFailure(Ljava/lang/Throwable;)Z

    .line 101
    return-void
.end method

.method private onDataSourceFinished()V
    .locals 2

    .prologue
    .line 90
    .local p0, "this":Lcom/facebook/imagepipeline/datasource/ListDataSource;, "Lcom/facebook/imagepipeline/datasource/ListDataSource<TT;>;"
    invoke-direct {p0}, Lcom/facebook/imagepipeline/datasource/ListDataSource;->increaseAndCheckIfLast()Z

    move-result v0

    if-eqz v0, :cond_0

    .line 91
    const/4 v0, 0x0

    const/4 v1, 0x1

    invoke-virtual {p0, v0, v1}, Lcom/facebook/imagepipeline/datasource/ListDataSource;->setResult(Ljava/lang/Object;Z)Z

    .line 93
    :cond_0
    return-void
.end method

.method private onDataSourceProgress()V
    .locals 6

    .prologue
    .line 108
    .local p0, "this":Lcom/facebook/imagepipeline/datasource/ListDataSource;, "Lcom/facebook/imagepipeline/datasource/ListDataSource<TT;>;"
    const/4 v1, 0x0

    .line 109
    .local v1, "progress":F
    iget-object v3, p0, Lcom/facebook/imagepipeline/datasource/ListDataSource;->mDataSources:[Lcom/facebook/datasource/DataSource;

    array-length v4, v3

    const/4 v2, 0x0

    :goto_0
    if-ge v2, v4, :cond_0

    aget-object v0, v3, v2

    .line 110
    .local v0, "dataSource":Lcom/facebook/datasource/DataSource;, "Lcom/facebook/datasource/DataSource<*>;"
    invoke-interface {v0}, Lcom/facebook/datasource/DataSource;->getProgress()F

    move-result v5

    add-float/2addr v1, v5

    .line 109
    add-int/lit8 v2, v2, 0x1

    goto :goto_0

    .line 112
    .end local v0    # "dataSource":Lcom/facebook/datasource/DataSource;, "Lcom/facebook/datasource/DataSource<*>;"
    :cond_0
    iget-object v2, p0, Lcom/facebook/imagepipeline/datasource/ListDataSource;->mDataSources:[Lcom/facebook/datasource/DataSource;

    array-length v2, v2

    int-to-float v2, v2

    div-float v2, v1, v2

    invoke-virtual {p0, v2}, Lcom/facebook/imagepipeline/datasource/ListDataSource;->setProgress(F)Z

    .line 113
    return-void
.end method


# virtual methods
.method public close()Z
    .locals 4

    .prologue
    .local p0, "this":Lcom/facebook/imagepipeline/datasource/ListDataSource;, "Lcom/facebook/imagepipeline/datasource/ListDataSource<TT;>;"
    const/4 v1, 0x0

    .line 80
    invoke-super {p0}, Lcom/facebook/datasource/AbstractDataSource;->close()Z

    move-result v2

    if-nez v2, :cond_0

    .line 86
    :goto_0
    return v1

    .line 83
    :cond_0
    iget-object v2, p0, Lcom/facebook/imagepipeline/datasource/ListDataSource;->mDataSources:[Lcom/facebook/datasource/DataSource;

    array-length v3, v2

    :goto_1
    if-ge v1, v3, :cond_1

    aget-object v0, v2, v1

    .line 84
    .local v0, "dataSource":Lcom/facebook/datasource/DataSource;, "Lcom/facebook/datasource/DataSource<*>;"
    invoke-interface {v0}, Lcom/facebook/datasource/DataSource;->close()Z

    .line 83
    add-int/lit8 v1, v1, 0x1

    goto :goto_1

    .line 86
    .end local v0    # "dataSource":Lcom/facebook/datasource/DataSource;, "Lcom/facebook/datasource/DataSource<*>;"
    :cond_1
    const/4 v1, 0x1

    goto :goto_0
.end method

.method public bridge synthetic getResult()Ljava/lang/Object;
    .locals 1
    .annotation runtime Ljavax/annotation/Nullable;
    .end annotation

    .prologue
    .line 35
    .local p0, "this":Lcom/facebook/imagepipeline/datasource/ListDataSource;, "Lcom/facebook/imagepipeline/datasource/ListDataSource<TT;>;"
    invoke-virtual {p0}, Lcom/facebook/imagepipeline/datasource/ListDataSource;->getResult()Ljava/util/List;

    move-result-object v0

    return-object v0
.end method

.method public declared-synchronized getResult()Ljava/util/List;
    .locals 6
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()",
            "Ljava/util/List",
            "<",
            "Lcom/facebook/common/references/CloseableReference",
            "<TT;>;>;"
        }
    .end annotation

    .annotation runtime Ljavax/annotation/Nullable;
    .end annotation

    .prologue
    .line 63
    .local p0, "this":Lcom/facebook/imagepipeline/datasource/ListDataSource;, "Lcom/facebook/imagepipeline/datasource/ListDataSource<TT;>;"
    monitor-enter p0

    :try_start_0
    invoke-virtual {p0}, Lcom/facebook/imagepipeline/datasource/ListDataSource;->hasResult()Z
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    move-result v2

    if-nez v2, :cond_1

    .line 64
    const/4 v1, 0x0

    .line 70
    :cond_0
    monitor-exit p0

    return-object v1

    .line 66
    :cond_1
    :try_start_1
    new-instance v1, Ljava/util/ArrayList;

    iget-object v2, p0, Lcom/facebook/imagepipeline/datasource/ListDataSource;->mDataSources:[Lcom/facebook/datasource/DataSource;

    array-length v2, v2

    invoke-direct {v1, v2}, Ljava/util/ArrayList;-><init>(I)V

    .line 67
    .local v1, "results":Ljava/util/List;, "Ljava/util/List<Lcom/facebook/common/references/CloseableReference<TT;>;>;"
    iget-object v3, p0, Lcom/facebook/imagepipeline/datasource/ListDataSource;->mDataSources:[Lcom/facebook/datasource/DataSource;

    array-length v4, v3

    const/4 v2, 0x0

    :goto_0
    if-ge v2, v4, :cond_0

    aget-object v0, v3, v2

    .line 68
    .local v0, "dataSource":Lcom/facebook/datasource/DataSource;, "Lcom/facebook/datasource/DataSource<Lcom/facebook/common/references/CloseableReference<TT;>;>;"
    invoke-interface {v0}, Lcom/facebook/datasource/DataSource;->getResult()Ljava/lang/Object;

    move-result-object v5

    invoke-interface {v1, v5}, Ljava/util/List;->add(Ljava/lang/Object;)Z
    :try_end_1
    .catchall {:try_start_1 .. :try_end_1} :catchall_0

    .line 67
    add-int/lit8 v2, v2, 0x1

    goto :goto_0

    .line 63
    .end local v0    # "dataSource":Lcom/facebook/datasource/DataSource;, "Lcom/facebook/datasource/DataSource<Lcom/facebook/common/references/CloseableReference<TT;>;>;"
    .end local v1    # "results":Ljava/util/List;, "Ljava/util/List<Lcom/facebook/common/references/CloseableReference<TT;>;>;"
    :catchall_0
    move-exception v2

    monitor-exit p0

    throw v2
.end method

.method public declared-synchronized hasResult()Z
    .locals 2

    .prologue
    .line 75
    .local p0, "this":Lcom/facebook/imagepipeline/datasource/ListDataSource;, "Lcom/facebook/imagepipeline/datasource/ListDataSource<TT;>;"
    monitor-enter p0

    :try_start_0
    invoke-virtual {p0}, Lcom/facebook/imagepipeline/datasource/ListDataSource;->isClosed()Z

    move-result v0

    if-nez v0, :cond_0

    iget v0, p0, Lcom/facebook/imagepipeline/datasource/ListDataSource;->mFinishedDataSources:I

    iget-object v1, p0, Lcom/facebook/imagepipeline/datasource/ListDataSource;->mDataSources:[Lcom/facebook/datasource/DataSource;

    array-length v1, v1
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    if-ne v0, v1, :cond_0

    const/4 v0, 0x1

    :goto_0
    monitor-exit p0

    return v0

    :cond_0
    const/4 v0, 0x0

    goto :goto_0

    :catchall_0
    move-exception v0

    monitor-exit p0

    throw v0
.end method

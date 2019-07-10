.class public Lcom/facebook/react/common/ClearableSynchronizedPool;
.super Ljava/lang/Object;
.source "ClearableSynchronizedPool.java"

# interfaces
.implements Landroid/support/v4/util/Pools$Pool;


# annotations
.annotation system Ldalvik/annotation/Signature;
    value = {
        "<T:",
        "Ljava/lang/Object;",
        ">",
        "Ljava/lang/Object;",
        "Landroid/support/v4/util/Pools$Pool",
        "<TT;>;"
    }
.end annotation


# instance fields
.field private final mPool:[Ljava/lang/Object;

.field private mSize:I


# direct methods
.method public constructor <init>(I)V
    .locals 1
    .param p1, "maxSize"    # I

    .prologue
    .line 16
    .local p0, "this":Lcom/facebook/react/common/ClearableSynchronizedPool;, "Lcom/facebook/react/common/ClearableSynchronizedPool<TT;>;"
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 14
    const/4 v0, 0x0

    iput v0, p0, Lcom/facebook/react/common/ClearableSynchronizedPool;->mSize:I

    .line 17
    new-array v0, p1, [Ljava/lang/Object;

    iput-object v0, p0, Lcom/facebook/react/common/ClearableSynchronizedPool;->mPool:[Ljava/lang/Object;

    .line 18
    return-void
.end method


# virtual methods
.method public declared-synchronized acquire()Ljava/lang/Object;
    .locals 4
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()TT;"
        }
    .end annotation

    .prologue
    .local p0, "this":Lcom/facebook/react/common/ClearableSynchronizedPool;, "Lcom/facebook/react/common/ClearableSynchronizedPool<TT;>;"
    const/4 v1, 0x0

    .line 22
    monitor-enter p0

    :try_start_0
    iget v2, p0, Lcom/facebook/react/common/ClearableSynchronizedPool;->mSize:I
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    if-nez v2, :cond_0

    .line 29
    :goto_0
    monitor-exit p0

    return-object v1

    .line 25
    :cond_0
    :try_start_1
    iget v2, p0, Lcom/facebook/react/common/ClearableSynchronizedPool;->mSize:I

    add-int/lit8 v2, v2, -0x1

    iput v2, p0, Lcom/facebook/react/common/ClearableSynchronizedPool;->mSize:I

    .line 26
    iget v0, p0, Lcom/facebook/react/common/ClearableSynchronizedPool;->mSize:I

    .line 27
    .local v0, "lastIndex":I
    iget-object v2, p0, Lcom/facebook/react/common/ClearableSynchronizedPool;->mPool:[Ljava/lang/Object;

    aget-object v1, v2, v0

    .line 28
    .local v1, "toReturn":Ljava/lang/Object;, "TT;"
    iget-object v2, p0, Lcom/facebook/react/common/ClearableSynchronizedPool;->mPool:[Ljava/lang/Object;

    const/4 v3, 0x0

    aput-object v3, v2, v0
    :try_end_1
    .catchall {:try_start_1 .. :try_end_1} :catchall_0

    goto :goto_0

    .line 22
    .end local v0    # "lastIndex":I
    .end local v1    # "toReturn":Ljava/lang/Object;, "TT;"
    :catchall_0
    move-exception v2

    monitor-exit p0

    throw v2
.end method

.method public declared-synchronized clear()V
    .locals 3

    .prologue
    .line 43
    .local p0, "this":Lcom/facebook/react/common/ClearableSynchronizedPool;, "Lcom/facebook/react/common/ClearableSynchronizedPool<TT;>;"
    monitor-enter p0

    const/4 v0, 0x0

    .local v0, "i":I
    :goto_0
    :try_start_0
    iget v1, p0, Lcom/facebook/react/common/ClearableSynchronizedPool;->mSize:I

    if-ge v0, v1, :cond_0

    .line 44
    iget-object v1, p0, Lcom/facebook/react/common/ClearableSynchronizedPool;->mPool:[Ljava/lang/Object;

    const/4 v2, 0x0

    aput-object v2, v1, v0

    .line 43
    add-int/lit8 v0, v0, 0x1

    goto :goto_0

    .line 46
    :cond_0
    const/4 v1, 0x0

    iput v1, p0, Lcom/facebook/react/common/ClearableSynchronizedPool;->mSize:I
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    .line 47
    monitor-exit p0

    return-void

    .line 43
    :catchall_0
    move-exception v1

    monitor-exit p0

    throw v1
.end method

.method public declared-synchronized release(Ljava/lang/Object;)Z
    .locals 2
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(TT;)Z"
        }
    .end annotation

    .prologue
    .line 34
    .local p0, "this":Lcom/facebook/react/common/ClearableSynchronizedPool;, "Lcom/facebook/react/common/ClearableSynchronizedPool<TT;>;"
    .local p1, "obj":Ljava/lang/Object;, "TT;"
    monitor-enter p0

    :try_start_0
    iget v0, p0, Lcom/facebook/react/common/ClearableSynchronizedPool;->mSize:I

    iget-object v1, p0, Lcom/facebook/react/common/ClearableSynchronizedPool;->mPool:[Ljava/lang/Object;

    array-length v1, v1
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    if-ne v0, v1, :cond_0

    .line 35
    const/4 v0, 0x0

    .line 39
    :goto_0
    monitor-exit p0

    return v0

    .line 37
    :cond_0
    :try_start_1
    iget-object v0, p0, Lcom/facebook/react/common/ClearableSynchronizedPool;->mPool:[Ljava/lang/Object;

    iget v1, p0, Lcom/facebook/react/common/ClearableSynchronizedPool;->mSize:I

    aput-object p1, v0, v1

    .line 38
    iget v0, p0, Lcom/facebook/react/common/ClearableSynchronizedPool;->mSize:I

    add-int/lit8 v0, v0, 0x1

    iput v0, p0, Lcom/facebook/react/common/ClearableSynchronizedPool;->mSize:I
    :try_end_1
    .catchall {:try_start_1 .. :try_end_1} :catchall_0

    .line 39
    const/4 v0, 0x1

    goto :goto_0

    .line 34
    :catchall_0
    move-exception v0

    monitor-exit p0

    throw v0
.end method

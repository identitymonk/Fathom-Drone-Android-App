.class public Lcom/facebook/common/executors/ScheduledFutureImpl;
.super Ljava/lang/Object;
.source "ScheduledFutureImpl.java"

# interfaces
.implements Ljava/util/concurrent/RunnableFuture;
.implements Ljava/util/concurrent/ScheduledFuture;


# annotations
.annotation system Ldalvik/annotation/Signature;
    value = {
        "<V:",
        "Ljava/lang/Object;",
        ">",
        "Ljava/lang/Object;",
        "Ljava/util/concurrent/RunnableFuture",
        "<TV;>;",
        "Ljava/util/concurrent/ScheduledFuture",
        "<TV;>;"
    }
.end annotation


# instance fields
.field private final mHandler:Landroid/os/Handler;

.field private final mListenableFuture:Ljava/util/concurrent/FutureTask;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/concurrent/FutureTask",
            "<TV;>;"
        }
    .end annotation
.end field


# direct methods
.method public constructor <init>(Landroid/os/Handler;Ljava/lang/Runnable;Ljava/lang/Object;)V
    .locals 1
    .param p1, "handler"    # Landroid/os/Handler;
    .param p2, "runnable"    # Ljava/lang/Runnable;
    .param p3    # Ljava/lang/Object;
        .annotation runtime Ljavax/annotation/Nullable;
        .end annotation
    .end param
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Landroid/os/Handler;",
            "Ljava/lang/Runnable;",
            "TV;)V"
        }
    .end annotation

    .prologue
    .line 38
    .local p0, "this":Lcom/facebook/common/executors/ScheduledFutureImpl;, "Lcom/facebook/common/executors/ScheduledFutureImpl<TV;>;"
    .local p3, "result":Ljava/lang/Object;, "TV;"
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 39
    iput-object p1, p0, Lcom/facebook/common/executors/ScheduledFutureImpl;->mHandler:Landroid/os/Handler;

    .line 40
    new-instance v0, Ljava/util/concurrent/FutureTask;

    invoke-direct {v0, p2, p3}, Ljava/util/concurrent/FutureTask;-><init>(Ljava/lang/Runnable;Ljava/lang/Object;)V

    iput-object v0, p0, Lcom/facebook/common/executors/ScheduledFutureImpl;->mListenableFuture:Ljava/util/concurrent/FutureTask;

    .line 41
    return-void
.end method

.method public constructor <init>(Landroid/os/Handler;Ljava/util/concurrent/Callable;)V
    .locals 1
    .param p1, "handler"    # Landroid/os/Handler;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Landroid/os/Handler;",
            "Ljava/util/concurrent/Callable",
            "<TV;>;)V"
        }
    .end annotation

    .prologue
    .line 33
    .local p0, "this":Lcom/facebook/common/executors/ScheduledFutureImpl;, "Lcom/facebook/common/executors/ScheduledFutureImpl<TV;>;"
    .local p2, "callable":Ljava/util/concurrent/Callable;, "Ljava/util/concurrent/Callable<TV;>;"
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 34
    iput-object p1, p0, Lcom/facebook/common/executors/ScheduledFutureImpl;->mHandler:Landroid/os/Handler;

    .line 35
    new-instance v0, Ljava/util/concurrent/FutureTask;

    invoke-direct {v0, p2}, Ljava/util/concurrent/FutureTask;-><init>(Ljava/util/concurrent/Callable;)V

    iput-object v0, p0, Lcom/facebook/common/executors/ScheduledFutureImpl;->mListenableFuture:Ljava/util/concurrent/FutureTask;

    .line 36
    return-void
.end method


# virtual methods
.method public cancel(Z)Z
    .locals 1
    .param p1, "mayInterruptIfRunning"    # Z

    .prologue
    .line 60
    .local p0, "this":Lcom/facebook/common/executors/ScheduledFutureImpl;, "Lcom/facebook/common/executors/ScheduledFutureImpl<TV;>;"
    iget-object v0, p0, Lcom/facebook/common/executors/ScheduledFutureImpl;->mListenableFuture:Ljava/util/concurrent/FutureTask;

    invoke-virtual {v0, p1}, Ljava/util/concurrent/FutureTask;->cancel(Z)Z

    move-result v0

    return v0
.end method

.method public bridge synthetic compareTo(Ljava/lang/Object;)I
    .locals 1

    .prologue
    .line 28
    .local p0, "this":Lcom/facebook/common/executors/ScheduledFutureImpl;, "Lcom/facebook/common/executors/ScheduledFutureImpl<TV;>;"
    check-cast p1, Ljava/util/concurrent/Delayed;

    invoke-virtual {p0, p1}, Lcom/facebook/common/executors/ScheduledFutureImpl;->compareTo(Ljava/util/concurrent/Delayed;)I

    move-result v0

    return v0
.end method

.method public compareTo(Ljava/util/concurrent/Delayed;)I
    .locals 1
    .param p1, "other"    # Ljava/util/concurrent/Delayed;

    .prologue
    .line 50
    .local p0, "this":Lcom/facebook/common/executors/ScheduledFutureImpl;, "Lcom/facebook/common/executors/ScheduledFutureImpl<TV;>;"
    new-instance v0, Ljava/lang/UnsupportedOperationException;

    invoke-direct {v0}, Ljava/lang/UnsupportedOperationException;-><init>()V

    throw v0
.end method

.method public get()Ljava/lang/Object;
    .locals 1
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()TV;"
        }
    .end annotation

    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/lang/InterruptedException;,
            Ljava/util/concurrent/ExecutionException;
        }
    .end annotation

    .prologue
    .line 75
    .local p0, "this":Lcom/facebook/common/executors/ScheduledFutureImpl;, "Lcom/facebook/common/executors/ScheduledFutureImpl<TV;>;"
    iget-object v0, p0, Lcom/facebook/common/executors/ScheduledFutureImpl;->mListenableFuture:Ljava/util/concurrent/FutureTask;

    invoke-virtual {v0}, Ljava/util/concurrent/FutureTask;->get()Ljava/lang/Object;

    move-result-object v0

    return-object v0
.end method

.method public get(JLjava/util/concurrent/TimeUnit;)Ljava/lang/Object;
    .locals 1
    .param p1, "timeout"    # J
    .param p3, "unit"    # Ljava/util/concurrent/TimeUnit;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(J",
            "Ljava/util/concurrent/TimeUnit;",
            ")TV;"
        }
    .end annotation

    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/lang/InterruptedException;,
            Ljava/util/concurrent/ExecutionException;,
            Ljava/util/concurrent/TimeoutException;
        }
    .end annotation

    .prologue
    .line 81
    .local p0, "this":Lcom/facebook/common/executors/ScheduledFutureImpl;, "Lcom/facebook/common/executors/ScheduledFutureImpl<TV;>;"
    iget-object v0, p0, Lcom/facebook/common/executors/ScheduledFutureImpl;->mListenableFuture:Ljava/util/concurrent/FutureTask;

    invoke-virtual {v0, p1, p2, p3}, Ljava/util/concurrent/FutureTask;->get(JLjava/util/concurrent/TimeUnit;)Ljava/lang/Object;

    move-result-object v0

    return-object v0
.end method

.method public getDelay(Ljava/util/concurrent/TimeUnit;)J
    .locals 1
    .param p1, "unit"    # Ljava/util/concurrent/TimeUnit;

    .prologue
    .line 45
    .local p0, "this":Lcom/facebook/common/executors/ScheduledFutureImpl;, "Lcom/facebook/common/executors/ScheduledFutureImpl<TV;>;"
    new-instance v0, Ljava/lang/UnsupportedOperationException;

    invoke-direct {v0}, Ljava/lang/UnsupportedOperationException;-><init>()V

    throw v0
.end method

.method public isCancelled()Z
    .locals 1

    .prologue
    .line 65
    .local p0, "this":Lcom/facebook/common/executors/ScheduledFutureImpl;, "Lcom/facebook/common/executors/ScheduledFutureImpl<TV;>;"
    iget-object v0, p0, Lcom/facebook/common/executors/ScheduledFutureImpl;->mListenableFuture:Ljava/util/concurrent/FutureTask;

    invoke-virtual {v0}, Ljava/util/concurrent/FutureTask;->isCancelled()Z

    move-result v0

    return v0
.end method

.method public isDone()Z
    .locals 1

    .prologue
    .line 70
    .local p0, "this":Lcom/facebook/common/executors/ScheduledFutureImpl;, "Lcom/facebook/common/executors/ScheduledFutureImpl<TV;>;"
    iget-object v0, p0, Lcom/facebook/common/executors/ScheduledFutureImpl;->mListenableFuture:Ljava/util/concurrent/FutureTask;

    invoke-virtual {v0}, Ljava/util/concurrent/FutureTask;->isDone()Z

    move-result v0

    return v0
.end method

.method public run()V
    .locals 1

    .prologue
    .line 55
    .local p0, "this":Lcom/facebook/common/executors/ScheduledFutureImpl;, "Lcom/facebook/common/executors/ScheduledFutureImpl<TV;>;"
    iget-object v0, p0, Lcom/facebook/common/executors/ScheduledFutureImpl;->mListenableFuture:Ljava/util/concurrent/FutureTask;

    invoke-virtual {v0}, Ljava/util/concurrent/FutureTask;->run()V

    .line 56
    return-void
.end method

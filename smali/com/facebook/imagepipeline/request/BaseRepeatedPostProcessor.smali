.class public abstract Lcom/facebook/imagepipeline/request/BaseRepeatedPostProcessor;
.super Lcom/facebook/imagepipeline/request/BasePostprocessor;
.source "BaseRepeatedPostProcessor.java"

# interfaces
.implements Lcom/facebook/imagepipeline/request/RepeatedPostprocessor;


# instance fields
.field private mCallback:Lcom/facebook/imagepipeline/request/RepeatedPostprocessorRunner;


# direct methods
.method public constructor <init>()V
    .locals 0

    .prologue
    .line 12
    invoke-direct {p0}, Lcom/facebook/imagepipeline/request/BasePostprocessor;-><init>()V

    return-void
.end method

.method private declared-synchronized getCallback()Lcom/facebook/imagepipeline/request/RepeatedPostprocessorRunner;
    .locals 1

    .prologue
    .line 22
    monitor-enter p0

    :try_start_0
    iget-object v0, p0, Lcom/facebook/imagepipeline/request/BaseRepeatedPostProcessor;->mCallback:Lcom/facebook/imagepipeline/request/RepeatedPostprocessorRunner;
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    monitor-exit p0

    return-object v0

    :catchall_0
    move-exception v0

    monitor-exit p0

    throw v0
.end method


# virtual methods
.method public declared-synchronized setCallback(Lcom/facebook/imagepipeline/request/RepeatedPostprocessorRunner;)V
    .locals 1
    .param p1, "runner"    # Lcom/facebook/imagepipeline/request/RepeatedPostprocessorRunner;

    .prologue
    .line 18
    monitor-enter p0

    :try_start_0
    iput-object p1, p0, Lcom/facebook/imagepipeline/request/BaseRepeatedPostProcessor;->mCallback:Lcom/facebook/imagepipeline/request/RepeatedPostprocessorRunner;
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    .line 19
    monitor-exit p0

    return-void

    .line 18
    :catchall_0
    move-exception v0

    monitor-exit p0

    throw v0
.end method

.method public update()V
    .locals 1

    .prologue
    .line 26
    invoke-direct {p0}, Lcom/facebook/imagepipeline/request/BaseRepeatedPostProcessor;->getCallback()Lcom/facebook/imagepipeline/request/RepeatedPostprocessorRunner;

    move-result-object v0

    .line 27
    .local v0, "callback":Lcom/facebook/imagepipeline/request/RepeatedPostprocessorRunner;
    if-eqz v0, :cond_0

    .line 28
    invoke-interface {v0}, Lcom/facebook/imagepipeline/request/RepeatedPostprocessorRunner;->update()V

    .line 30
    :cond_0
    return-void
.end method

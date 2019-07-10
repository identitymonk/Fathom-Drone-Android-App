.class Lcom/facebook/common/references/CloseableReference$CloseableReferenceWithFinalizer;
.super Lcom/facebook/common/references/CloseableReference;
.source "CloseableReference.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/facebook/common/references/CloseableReference;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0xa
    name = "CloseableReferenceWithFinalizer"
.end annotation

.annotation system Ldalvik/annotation/Signature;
    value = {
        "<T:",
        "Ljava/lang/Object;",
        ">",
        "Lcom/facebook/common/references/CloseableReference",
        "<TT;>;"
    }
.end annotation


# instance fields
.field private mIsClosed:Z
    .annotation build Ljavax/annotation/concurrent/GuardedBy;
        value = "this"
    .end annotation
.end field

.field private final mSharedReference:Lcom/facebook/common/references/SharedReference;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Lcom/facebook/common/references/SharedReference",
            "<TT;>;"
        }
    .end annotation
.end field


# direct methods
.method private constructor <init>(Lcom/facebook/common/references/SharedReference;)V
    .locals 1
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Lcom/facebook/common/references/SharedReference",
            "<TT;>;)V"
        }
    .end annotation

    .prologue
    .line 388
    .local p0, "this":Lcom/facebook/common/references/CloseableReference$CloseableReferenceWithFinalizer;, "Lcom/facebook/common/references/CloseableReference$CloseableReferenceWithFinalizer<TT;>;"
    .local p1, "sharedReference":Lcom/facebook/common/references/SharedReference;, "Lcom/facebook/common/references/SharedReference<TT;>;"
    invoke-direct {p0}, Lcom/facebook/common/references/CloseableReference;-><init>()V

    .line 384
    const/4 v0, 0x0

    iput-boolean v0, p0, Lcom/facebook/common/references/CloseableReference$CloseableReferenceWithFinalizer;->mIsClosed:Z

    .line 389
    invoke-static {p1}, Lcom/facebook/common/internal/Preconditions;->checkNotNull(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/facebook/common/references/SharedReference;

    iput-object v0, p0, Lcom/facebook/common/references/CloseableReference$CloseableReferenceWithFinalizer;->mSharedReference:Lcom/facebook/common/references/SharedReference;

    .line 390
    invoke-virtual {p1}, Lcom/facebook/common/references/SharedReference;->addReference()V

    .line 391
    return-void
.end method

.method private constructor <init>(Ljava/lang/Object;Lcom/facebook/common/references/ResourceReleaser;)V
    .locals 1
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(TT;",
            "Lcom/facebook/common/references/ResourceReleaser",
            "<TT;>;)V"
        }
    .end annotation

    .prologue
    .line 393
    .local p0, "this":Lcom/facebook/common/references/CloseableReference$CloseableReferenceWithFinalizer;, "Lcom/facebook/common/references/CloseableReference$CloseableReferenceWithFinalizer<TT;>;"
    .local p1, "t":Ljava/lang/Object;, "TT;"
    .local p2, "resourceReleaser":Lcom/facebook/common/references/ResourceReleaser;, "Lcom/facebook/common/references/ResourceReleaser<TT;>;"
    invoke-direct {p0}, Lcom/facebook/common/references/CloseableReference;-><init>()V

    .line 384
    const/4 v0, 0x0

    iput-boolean v0, p0, Lcom/facebook/common/references/CloseableReference$CloseableReferenceWithFinalizer;->mIsClosed:Z

    .line 394
    new-instance v0, Lcom/facebook/common/references/SharedReference;

    invoke-direct {v0, p1, p2}, Lcom/facebook/common/references/SharedReference;-><init>(Ljava/lang/Object;Lcom/facebook/common/references/ResourceReleaser;)V

    iput-object v0, p0, Lcom/facebook/common/references/CloseableReference$CloseableReferenceWithFinalizer;->mSharedReference:Lcom/facebook/common/references/SharedReference;

    .line 395
    return-void
.end method

.method synthetic constructor <init>(Ljava/lang/Object;Lcom/facebook/common/references/ResourceReleaser;Lcom/facebook/common/references/CloseableReference$1;)V
    .locals 0
    .param p1, "x0"    # Ljava/lang/Object;
    .param p2, "x1"    # Lcom/facebook/common/references/ResourceReleaser;
    .param p3, "x2"    # Lcom/facebook/common/references/CloseableReference$1;

    .prologue
    .line 382
    .local p0, "this":Lcom/facebook/common/references/CloseableReference$CloseableReferenceWithFinalizer;, "Lcom/facebook/common/references/CloseableReference$CloseableReferenceWithFinalizer<TT;>;"
    invoke-direct {p0, p1, p2}, Lcom/facebook/common/references/CloseableReference$CloseableReferenceWithFinalizer;-><init>(Ljava/lang/Object;Lcom/facebook/common/references/ResourceReleaser;)V

    return-void
.end method


# virtual methods
.method public declared-synchronized clone()Lcom/facebook/common/references/CloseableReference;
    .locals 2
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()",
            "Lcom/facebook/common/references/CloseableReference",
            "<TT;>;"
        }
    .end annotation

    .prologue
    .line 429
    .local p0, "this":Lcom/facebook/common/references/CloseableReference$CloseableReferenceWithFinalizer;, "Lcom/facebook/common/references/CloseableReference$CloseableReferenceWithFinalizer<TT;>;"
    monitor-enter p0

    :try_start_0
    invoke-virtual {p0}, Lcom/facebook/common/references/CloseableReference$CloseableReferenceWithFinalizer;->isValid()Z

    move-result v0

    invoke-static {v0}, Lcom/facebook/common/internal/Preconditions;->checkState(Z)V

    .line 430
    new-instance v0, Lcom/facebook/common/references/CloseableReference$CloseableReferenceWithFinalizer;

    iget-object v1, p0, Lcom/facebook/common/references/CloseableReference$CloseableReferenceWithFinalizer;->mSharedReference:Lcom/facebook/common/references/SharedReference;

    invoke-direct {v0, v1}, Lcom/facebook/common/references/CloseableReference$CloseableReferenceWithFinalizer;-><init>(Lcom/facebook/common/references/SharedReference;)V
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    monitor-exit p0

    return-object v0

    .line 429
    :catchall_0
    move-exception v0

    monitor-exit p0

    throw v0
.end method

.method public bridge synthetic clone()Ljava/lang/Object;
    .locals 1
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/lang/CloneNotSupportedException;
        }
    .end annotation

    .prologue
    .line 382
    .local p0, "this":Lcom/facebook/common/references/CloseableReference$CloseableReferenceWithFinalizer;, "Lcom/facebook/common/references/CloseableReference$CloseableReferenceWithFinalizer<TT;>;"
    invoke-virtual {p0}, Lcom/facebook/common/references/CloseableReference$CloseableReferenceWithFinalizer;->clone()Lcom/facebook/common/references/CloseableReference;

    move-result-object v0

    return-object v0
.end method

.method public declared-synchronized cloneOrNull()Lcom/facebook/common/references/CloseableReference;
    .locals 1
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()",
            "Lcom/facebook/common/references/CloseableReference",
            "<TT;>;"
        }
    .end annotation

    .prologue
    .line 435
    .local p0, "this":Lcom/facebook/common/references/CloseableReference$CloseableReferenceWithFinalizer;, "Lcom/facebook/common/references/CloseableReference$CloseableReferenceWithFinalizer<TT;>;"
    monitor-enter p0

    :try_start_0
    invoke-virtual {p0}, Lcom/facebook/common/references/CloseableReference$CloseableReferenceWithFinalizer;->isValid()Z

    move-result v0

    if-eqz v0, :cond_0

    .line 436
    invoke-virtual {p0}, Lcom/facebook/common/references/CloseableReference$CloseableReferenceWithFinalizer;->clone()Lcom/facebook/common/references/CloseableReference;
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    move-result-object v0

    .line 438
    :goto_0
    monitor-exit p0

    return-object v0

    :cond_0
    const/4 v0, 0x0

    goto :goto_0

    .line 435
    :catchall_0
    move-exception v0

    monitor-exit p0

    throw v0
.end method

.method public close()V
    .locals 1

    .prologue
    .line 458
    .local p0, "this":Lcom/facebook/common/references/CloseableReference$CloseableReferenceWithFinalizer;, "Lcom/facebook/common/references/CloseableReference$CloseableReferenceWithFinalizer<TT;>;"
    monitor-enter p0

    .line 459
    :try_start_0
    iget-boolean v0, p0, Lcom/facebook/common/references/CloseableReference$CloseableReferenceWithFinalizer;->mIsClosed:Z

    if-eqz v0, :cond_0

    .line 460
    monitor-exit p0

    .line 466
    :goto_0
    return-void

    .line 462
    :cond_0
    const/4 v0, 0x1

    iput-boolean v0, p0, Lcom/facebook/common/references/CloseableReference$CloseableReferenceWithFinalizer;->mIsClosed:Z

    .line 463
    monitor-exit p0
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    .line 465
    iget-object v0, p0, Lcom/facebook/common/references/CloseableReference$CloseableReferenceWithFinalizer;->mSharedReference:Lcom/facebook/common/references/SharedReference;

    invoke-virtual {v0}, Lcom/facebook/common/references/SharedReference;->deleteReference()V

    goto :goto_0

    .line 463
    :catchall_0
    move-exception v0

    :try_start_1
    monitor-exit p0
    :try_end_1
    .catchall {:try_start_1 .. :try_end_1} :catchall_0

    throw v0
.end method

.method protected finalize()V
    .locals 5
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/lang/Throwable;
        }
    .end annotation

    .prologue
    .line 402
    .local p0, "this":Lcom/facebook/common/references/CloseableReference$CloseableReferenceWithFinalizer;, "Lcom/facebook/common/references/CloseableReference$CloseableReferenceWithFinalizer<TT;>;"
    :try_start_0
    monitor-enter p0
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_1

    .line 403
    :try_start_1
    iget-boolean v0, p0, Lcom/facebook/common/references/CloseableReference$CloseableReferenceWithFinalizer;->mIsClosed:Z

    if-eqz v0, :cond_0

    .line 404
    monitor-exit p0
    :try_end_1
    .catchall {:try_start_1 .. :try_end_1} :catchall_0

    .line 417
    invoke-super {p0}, Ljava/lang/Object;->finalize()V

    .line 419
    :goto_0
    return-void

    .line 406
    :cond_0
    :try_start_2
    monitor-exit p0
    :try_end_2
    .catchall {:try_start_2 .. :try_end_2} :catchall_0

    .line 409
    :try_start_3
    invoke-static {}, Lcom/facebook/common/references/CloseableReference;->access$300()Ljava/lang/Class;

    move-result-object v0

    const-string v1, "Finalized without closing: %x %x (type = %s)"

    const/4 v2, 0x3

    new-array v2, v2, [Ljava/lang/Object;

    const/4 v3, 0x0

    .line 411
    invoke-static {p0}, Ljava/lang/System;->identityHashCode(Ljava/lang/Object;)I

    move-result v4

    invoke-static {v4}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v4

    aput-object v4, v2, v3

    const/4 v3, 0x1

    iget-object v4, p0, Lcom/facebook/common/references/CloseableReference$CloseableReferenceWithFinalizer;->mSharedReference:Lcom/facebook/common/references/SharedReference;

    .line 412
    invoke-static {v4}, Ljava/lang/System;->identityHashCode(Ljava/lang/Object;)I

    move-result v4

    invoke-static {v4}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v4

    aput-object v4, v2, v3

    const/4 v3, 0x2

    iget-object v4, p0, Lcom/facebook/common/references/CloseableReference$CloseableReferenceWithFinalizer;->mSharedReference:Lcom/facebook/common/references/SharedReference;

    .line 413
    invoke-virtual {v4}, Lcom/facebook/common/references/SharedReference;->get()Ljava/lang/Object;

    move-result-object v4

    invoke-virtual {v4}, Ljava/lang/Object;->getClass()Ljava/lang/Class;

    move-result-object v4

    invoke-virtual {v4}, Ljava/lang/Class;->getSimpleName()Ljava/lang/String;

    move-result-object v4

    aput-object v4, v2, v3

    .line 408
    invoke-static {v0, v1, v2}, Lcom/facebook/common/logging/FLog;->w(Ljava/lang/Class;Ljava/lang/String;[Ljava/lang/Object;)V

    .line 415
    invoke-virtual {p0}, Lcom/facebook/common/references/CloseableReference$CloseableReferenceWithFinalizer;->close()V
    :try_end_3
    .catchall {:try_start_3 .. :try_end_3} :catchall_1

    .line 417
    invoke-super {p0}, Ljava/lang/Object;->finalize()V

    goto :goto_0

    .line 406
    :catchall_0
    move-exception v0

    :try_start_4
    monitor-exit p0
    :try_end_4
    .catchall {:try_start_4 .. :try_end_4} :catchall_0

    :try_start_5
    throw v0
    :try_end_5
    .catchall {:try_start_5 .. :try_end_5} :catchall_1

    .line 417
    :catchall_1
    move-exception v0

    invoke-super {p0}, Ljava/lang/Object;->finalize()V

    throw v0
.end method

.method public declared-synchronized get()Ljava/lang/Object;
    .locals 1
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()TT;"
        }
    .end annotation

    .prologue
    .line 423
    .local p0, "this":Lcom/facebook/common/references/CloseableReference$CloseableReferenceWithFinalizer;, "Lcom/facebook/common/references/CloseableReference$CloseableReferenceWithFinalizer<TT;>;"
    monitor-enter p0

    :try_start_0
    iget-boolean v0, p0, Lcom/facebook/common/references/CloseableReference$CloseableReferenceWithFinalizer;->mIsClosed:Z

    if-nez v0, :cond_0

    const/4 v0, 0x1

    :goto_0
    invoke-static {v0}, Lcom/facebook/common/internal/Preconditions;->checkState(Z)V

    .line 424
    iget-object v0, p0, Lcom/facebook/common/references/CloseableReference$CloseableReferenceWithFinalizer;->mSharedReference:Lcom/facebook/common/references/SharedReference;

    invoke-virtual {v0}, Lcom/facebook/common/references/SharedReference;->get()Ljava/lang/Object;
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    move-result-object v0

    monitor-exit p0

    return-object v0

    .line 423
    :cond_0
    const/4 v0, 0x0

    goto :goto_0

    :catchall_0
    move-exception v0

    monitor-exit p0

    throw v0
.end method

.method public declared-synchronized getUnderlyingReferenceTestOnly()Lcom/facebook/common/references/SharedReference;
    .locals 1
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()",
            "Lcom/facebook/common/references/SharedReference",
            "<TT;>;"
        }
    .end annotation

    .prologue
    .line 448
    .local p0, "this":Lcom/facebook/common/references/CloseableReference$CloseableReferenceWithFinalizer;, "Lcom/facebook/common/references/CloseableReference$CloseableReferenceWithFinalizer<TT;>;"
    monitor-enter p0

    :try_start_0
    iget-object v0, p0, Lcom/facebook/common/references/CloseableReference$CloseableReferenceWithFinalizer;->mSharedReference:Lcom/facebook/common/references/SharedReference;
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    monitor-exit p0

    return-object v0

    :catchall_0
    move-exception v0

    monitor-exit p0

    throw v0
.end method

.method public getValueHash()I
    .locals 1

    .prologue
    .line 453
    .local p0, "this":Lcom/facebook/common/references/CloseableReference$CloseableReferenceWithFinalizer;, "Lcom/facebook/common/references/CloseableReference$CloseableReferenceWithFinalizer<TT;>;"
    invoke-virtual {p0}, Lcom/facebook/common/references/CloseableReference$CloseableReferenceWithFinalizer;->isValid()Z

    move-result v0

    if-eqz v0, :cond_0

    iget-object v0, p0, Lcom/facebook/common/references/CloseableReference$CloseableReferenceWithFinalizer;->mSharedReference:Lcom/facebook/common/references/SharedReference;

    invoke-virtual {v0}, Lcom/facebook/common/references/SharedReference;->get()Ljava/lang/Object;

    move-result-object v0

    invoke-static {v0}, Ljava/lang/System;->identityHashCode(Ljava/lang/Object;)I

    move-result v0

    :goto_0
    return v0

    :cond_0
    const/4 v0, 0x0

    goto :goto_0
.end method

.method public declared-synchronized isValid()Z
    .locals 1

    .prologue
    .line 443
    .local p0, "this":Lcom/facebook/common/references/CloseableReference$CloseableReferenceWithFinalizer;, "Lcom/facebook/common/references/CloseableReference$CloseableReferenceWithFinalizer<TT;>;"
    monitor-enter p0

    :try_start_0
    iget-boolean v0, p0, Lcom/facebook/common/references/CloseableReference$CloseableReferenceWithFinalizer;->mIsClosed:Z
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    if-nez v0, :cond_0

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

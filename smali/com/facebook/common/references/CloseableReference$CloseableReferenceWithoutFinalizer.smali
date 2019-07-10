.class Lcom/facebook/common/references/CloseableReference$CloseableReferenceWithoutFinalizer;
.super Lcom/facebook/common/references/CloseableReference;
.source "CloseableReference.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/facebook/common/references/CloseableReference;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0xa
    name = "CloseableReferenceWithoutFinalizer"
.end annotation

.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lcom/facebook/common/references/CloseableReference$CloseableReferenceWithoutFinalizer$Destructor;
    }
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


# static fields
.field private static final REF_QUEUE:Ljava/lang/ref/ReferenceQueue;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/lang/ref/ReferenceQueue",
            "<",
            "Lcom/facebook/common/references/CloseableReference;",
            ">;"
        }
    .end annotation
.end field


# instance fields
.field private final mDestructor:Lcom/facebook/common/references/CloseableReference$CloseableReferenceWithoutFinalizer$Destructor;

.field private final mSharedReference:Lcom/facebook/common/references/SharedReference;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Lcom/facebook/common/references/SharedReference",
            "<TT;>;"
        }
    .end annotation
.end field


# direct methods
.method static constructor <clinit>()V
    .locals 3

    .prologue
    .line 300
    new-instance v0, Ljava/lang/ref/ReferenceQueue;

    invoke-direct {v0}, Ljava/lang/ref/ReferenceQueue;-><init>()V

    sput-object v0, Lcom/facebook/common/references/CloseableReference$CloseableReferenceWithoutFinalizer;->REF_QUEUE:Ljava/lang/ref/ReferenceQueue;

    .line 303
    new-instance v0, Ljava/lang/Thread;

    new-instance v1, Lcom/facebook/common/references/CloseableReference$CloseableReferenceWithoutFinalizer$1;

    invoke-direct {v1}, Lcom/facebook/common/references/CloseableReference$CloseableReferenceWithoutFinalizer$1;-><init>()V

    const-string v2, "CloseableReferenceDestructorThread"

    invoke-direct {v0, v1, v2}, Ljava/lang/Thread;-><init>(Ljava/lang/Runnable;Ljava/lang/String;)V

    .line 316
    invoke-virtual {v0}, Ljava/lang/Thread;->start()V

    .line 317
    return-void
.end method

.method private constructor <init>(Lcom/facebook/common/references/SharedReference;)V
    .locals 2
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Lcom/facebook/common/references/SharedReference",
            "<TT;>;)V"
        }
    .end annotation

    .prologue
    .line 322
    .local p0, "this":Lcom/facebook/common/references/CloseableReference$CloseableReferenceWithoutFinalizer;, "Lcom/facebook/common/references/CloseableReference$CloseableReferenceWithoutFinalizer<TT;>;"
    .local p1, "sharedReference":Lcom/facebook/common/references/SharedReference;, "Lcom/facebook/common/references/SharedReference<TT;>;"
    invoke-direct {p0}, Lcom/facebook/common/references/CloseableReference;-><init>()V

    .line 323
    invoke-static {p1}, Lcom/facebook/common/internal/Preconditions;->checkNotNull(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/facebook/common/references/SharedReference;

    iput-object v0, p0, Lcom/facebook/common/references/CloseableReference$CloseableReferenceWithoutFinalizer;->mSharedReference:Lcom/facebook/common/references/SharedReference;

    .line 324
    invoke-virtual {p1}, Lcom/facebook/common/references/SharedReference;->addReference()V

    .line 325
    new-instance v0, Lcom/facebook/common/references/CloseableReference$CloseableReferenceWithoutFinalizer$Destructor;

    sget-object v1, Lcom/facebook/common/references/CloseableReference$CloseableReferenceWithoutFinalizer;->REF_QUEUE:Ljava/lang/ref/ReferenceQueue;

    invoke-direct {v0, p0, v1}, Lcom/facebook/common/references/CloseableReference$CloseableReferenceWithoutFinalizer$Destructor;-><init>(Lcom/facebook/common/references/CloseableReference$CloseableReferenceWithoutFinalizer;Ljava/lang/ref/ReferenceQueue;)V

    iput-object v0, p0, Lcom/facebook/common/references/CloseableReference$CloseableReferenceWithoutFinalizer;->mDestructor:Lcom/facebook/common/references/CloseableReference$CloseableReferenceWithoutFinalizer$Destructor;

    .line 326
    return-void
.end method

.method private constructor <init>(Ljava/lang/Object;Lcom/facebook/common/references/ResourceReleaser;)V
    .locals 2
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(TT;",
            "Lcom/facebook/common/references/ResourceReleaser",
            "<TT;>;)V"
        }
    .end annotation

    .prologue
    .line 328
    .local p0, "this":Lcom/facebook/common/references/CloseableReference$CloseableReferenceWithoutFinalizer;, "Lcom/facebook/common/references/CloseableReference$CloseableReferenceWithoutFinalizer<TT;>;"
    .local p1, "t":Ljava/lang/Object;, "TT;"
    .local p2, "resourceReleaser":Lcom/facebook/common/references/ResourceReleaser;, "Lcom/facebook/common/references/ResourceReleaser<TT;>;"
    invoke-direct {p0}, Lcom/facebook/common/references/CloseableReference;-><init>()V

    .line 329
    new-instance v0, Lcom/facebook/common/references/SharedReference;

    invoke-direct {v0, p1, p2}, Lcom/facebook/common/references/SharedReference;-><init>(Ljava/lang/Object;Lcom/facebook/common/references/ResourceReleaser;)V

    iput-object v0, p0, Lcom/facebook/common/references/CloseableReference$CloseableReferenceWithoutFinalizer;->mSharedReference:Lcom/facebook/common/references/SharedReference;

    .line 330
    new-instance v0, Lcom/facebook/common/references/CloseableReference$CloseableReferenceWithoutFinalizer$Destructor;

    sget-object v1, Lcom/facebook/common/references/CloseableReference$CloseableReferenceWithoutFinalizer;->REF_QUEUE:Ljava/lang/ref/ReferenceQueue;

    invoke-direct {v0, p0, v1}, Lcom/facebook/common/references/CloseableReference$CloseableReferenceWithoutFinalizer$Destructor;-><init>(Lcom/facebook/common/references/CloseableReference$CloseableReferenceWithoutFinalizer;Ljava/lang/ref/ReferenceQueue;)V

    iput-object v0, p0, Lcom/facebook/common/references/CloseableReference$CloseableReferenceWithoutFinalizer;->mDestructor:Lcom/facebook/common/references/CloseableReference$CloseableReferenceWithoutFinalizer$Destructor;

    .line 331
    return-void
.end method

.method synthetic constructor <init>(Ljava/lang/Object;Lcom/facebook/common/references/ResourceReleaser;Lcom/facebook/common/references/CloseableReference$1;)V
    .locals 0
    .param p1, "x0"    # Ljava/lang/Object;
    .param p2, "x1"    # Lcom/facebook/common/references/ResourceReleaser;
    .param p3, "x2"    # Lcom/facebook/common/references/CloseableReference$1;

    .prologue
    .line 234
    .local p0, "this":Lcom/facebook/common/references/CloseableReference$CloseableReferenceWithoutFinalizer;, "Lcom/facebook/common/references/CloseableReference$CloseableReferenceWithoutFinalizer<TT;>;"
    invoke-direct {p0, p1, p2}, Lcom/facebook/common/references/CloseableReference$CloseableReferenceWithoutFinalizer;-><init>(Ljava/lang/Object;Lcom/facebook/common/references/ResourceReleaser;)V

    return-void
.end method

.method static synthetic access$200(Lcom/facebook/common/references/CloseableReference$CloseableReferenceWithoutFinalizer;)Lcom/facebook/common/references/SharedReference;
    .locals 1
    .param p0, "x0"    # Lcom/facebook/common/references/CloseableReference$CloseableReferenceWithoutFinalizer;

    .prologue
    .line 234
    iget-object v0, p0, Lcom/facebook/common/references/CloseableReference$CloseableReferenceWithoutFinalizer;->mSharedReference:Lcom/facebook/common/references/SharedReference;

    return-object v0
.end method

.method static synthetic access$400()Ljava/lang/ref/ReferenceQueue;
    .locals 1

    .prologue
    .line 234
    sget-object v0, Lcom/facebook/common/references/CloseableReference$CloseableReferenceWithoutFinalizer;->REF_QUEUE:Ljava/lang/ref/ReferenceQueue;

    return-object v0
.end method


# virtual methods
.method public clone()Lcom/facebook/common/references/CloseableReference;
    .locals 3
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()",
            "Lcom/facebook/common/references/CloseableReference",
            "<TT;>;"
        }
    .end annotation

    .prologue
    .line 348
    .local p0, "this":Lcom/facebook/common/references/CloseableReference$CloseableReferenceWithoutFinalizer;, "Lcom/facebook/common/references/CloseableReference$CloseableReferenceWithoutFinalizer<TT;>;"
    iget-object v1, p0, Lcom/facebook/common/references/CloseableReference$CloseableReferenceWithoutFinalizer;->mDestructor:Lcom/facebook/common/references/CloseableReference$CloseableReferenceWithoutFinalizer$Destructor;

    monitor-enter v1

    .line 349
    :try_start_0
    iget-object v0, p0, Lcom/facebook/common/references/CloseableReference$CloseableReferenceWithoutFinalizer;->mDestructor:Lcom/facebook/common/references/CloseableReference$CloseableReferenceWithoutFinalizer$Destructor;

    invoke-virtual {v0}, Lcom/facebook/common/references/CloseableReference$CloseableReferenceWithoutFinalizer$Destructor;->isDestroyed()Z

    move-result v0

    if-nez v0, :cond_0

    const/4 v0, 0x1

    :goto_0
    invoke-static {v0}, Lcom/facebook/common/internal/Preconditions;->checkState(Z)V

    .line 350
    new-instance v0, Lcom/facebook/common/references/CloseableReference$CloseableReferenceWithoutFinalizer;

    iget-object v2, p0, Lcom/facebook/common/references/CloseableReference$CloseableReferenceWithoutFinalizer;->mSharedReference:Lcom/facebook/common/references/SharedReference;

    invoke-direct {v0, v2}, Lcom/facebook/common/references/CloseableReference$CloseableReferenceWithoutFinalizer;-><init>(Lcom/facebook/common/references/SharedReference;)V

    monitor-exit v1

    return-object v0

    .line 349
    :cond_0
    const/4 v0, 0x0

    goto :goto_0

    .line 351
    :catchall_0
    move-exception v0

    monitor-exit v1
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

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
    .line 234
    .local p0, "this":Lcom/facebook/common/references/CloseableReference$CloseableReferenceWithoutFinalizer;, "Lcom/facebook/common/references/CloseableReference$CloseableReferenceWithoutFinalizer<TT;>;"
    invoke-virtual {p0}, Lcom/facebook/common/references/CloseableReference$CloseableReferenceWithoutFinalizer;->clone()Lcom/facebook/common/references/CloseableReference;

    move-result-object v0

    return-object v0
.end method

.method public cloneOrNull()Lcom/facebook/common/references/CloseableReference;
    .locals 3
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()",
            "Lcom/facebook/common/references/CloseableReference",
            "<TT;>;"
        }
    .end annotation

    .prologue
    .line 356
    .local p0, "this":Lcom/facebook/common/references/CloseableReference$CloseableReferenceWithoutFinalizer;, "Lcom/facebook/common/references/CloseableReference$CloseableReferenceWithoutFinalizer<TT;>;"
    iget-object v1, p0, Lcom/facebook/common/references/CloseableReference$CloseableReferenceWithoutFinalizer;->mDestructor:Lcom/facebook/common/references/CloseableReference$CloseableReferenceWithoutFinalizer$Destructor;

    monitor-enter v1

    .line 357
    :try_start_0
    iget-object v0, p0, Lcom/facebook/common/references/CloseableReference$CloseableReferenceWithoutFinalizer;->mDestructor:Lcom/facebook/common/references/CloseableReference$CloseableReferenceWithoutFinalizer$Destructor;

    invoke-virtual {v0}, Lcom/facebook/common/references/CloseableReference$CloseableReferenceWithoutFinalizer$Destructor;->isDestroyed()Z

    move-result v0

    if-nez v0, :cond_0

    .line 358
    new-instance v0, Lcom/facebook/common/references/CloseableReference$CloseableReferenceWithoutFinalizer;

    iget-object v2, p0, Lcom/facebook/common/references/CloseableReference$CloseableReferenceWithoutFinalizer;->mSharedReference:Lcom/facebook/common/references/SharedReference;

    invoke-direct {v0, v2}, Lcom/facebook/common/references/CloseableReference$CloseableReferenceWithoutFinalizer;-><init>(Lcom/facebook/common/references/SharedReference;)V

    monitor-exit v1

    .line 360
    :goto_0
    return-object v0

    :cond_0
    const/4 v0, 0x0

    monitor-exit v1

    goto :goto_0

    .line 361
    :catchall_0
    move-exception v0

    monitor-exit v1
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    throw v0
.end method

.method public close()V
    .locals 2

    .prologue
    .line 335
    .local p0, "this":Lcom/facebook/common/references/CloseableReference$CloseableReferenceWithoutFinalizer;, "Lcom/facebook/common/references/CloseableReference$CloseableReferenceWithoutFinalizer<TT;>;"
    iget-object v0, p0, Lcom/facebook/common/references/CloseableReference$CloseableReferenceWithoutFinalizer;->mDestructor:Lcom/facebook/common/references/CloseableReference$CloseableReferenceWithoutFinalizer$Destructor;

    const/4 v1, 0x1

    invoke-virtual {v0, v1}, Lcom/facebook/common/references/CloseableReference$CloseableReferenceWithoutFinalizer$Destructor;->destroy(Z)V

    .line 336
    return-void
.end method

.method public get()Ljava/lang/Object;
    .locals 2
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()TT;"
        }
    .end annotation

    .prologue
    .line 340
    .local p0, "this":Lcom/facebook/common/references/CloseableReference$CloseableReferenceWithoutFinalizer;, "Lcom/facebook/common/references/CloseableReference$CloseableReferenceWithoutFinalizer<TT;>;"
    iget-object v1, p0, Lcom/facebook/common/references/CloseableReference$CloseableReferenceWithoutFinalizer;->mDestructor:Lcom/facebook/common/references/CloseableReference$CloseableReferenceWithoutFinalizer$Destructor;

    monitor-enter v1

    .line 341
    :try_start_0
    iget-object v0, p0, Lcom/facebook/common/references/CloseableReference$CloseableReferenceWithoutFinalizer;->mDestructor:Lcom/facebook/common/references/CloseableReference$CloseableReferenceWithoutFinalizer$Destructor;

    invoke-virtual {v0}, Lcom/facebook/common/references/CloseableReference$CloseableReferenceWithoutFinalizer$Destructor;->isDestroyed()Z

    move-result v0

    if-nez v0, :cond_0

    const/4 v0, 0x1

    :goto_0
    invoke-static {v0}, Lcom/facebook/common/internal/Preconditions;->checkState(Z)V

    .line 342
    iget-object v0, p0, Lcom/facebook/common/references/CloseableReference$CloseableReferenceWithoutFinalizer;->mSharedReference:Lcom/facebook/common/references/SharedReference;

    invoke-virtual {v0}, Lcom/facebook/common/references/SharedReference;->get()Ljava/lang/Object;

    move-result-object v0

    monitor-exit v1

    return-object v0

    .line 341
    :cond_0
    const/4 v0, 0x0

    goto :goto_0

    .line 343
    :catchall_0
    move-exception v0

    monitor-exit v1
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    throw v0
.end method

.method public getUnderlyingReferenceTestOnly()Lcom/facebook/common/references/SharedReference;
    .locals 1
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()",
            "Lcom/facebook/common/references/SharedReference",
            "<TT;>;"
        }
    .end annotation

    .prologue
    .line 371
    .local p0, "this":Lcom/facebook/common/references/CloseableReference$CloseableReferenceWithoutFinalizer;, "Lcom/facebook/common/references/CloseableReference$CloseableReferenceWithoutFinalizer<TT;>;"
    iget-object v0, p0, Lcom/facebook/common/references/CloseableReference$CloseableReferenceWithoutFinalizer;->mSharedReference:Lcom/facebook/common/references/SharedReference;

    return-object v0
.end method

.method public getValueHash()I
    .locals 2

    .prologue
    .line 376
    .local p0, "this":Lcom/facebook/common/references/CloseableReference$CloseableReferenceWithoutFinalizer;, "Lcom/facebook/common/references/CloseableReference$CloseableReferenceWithoutFinalizer<TT;>;"
    iget-object v1, p0, Lcom/facebook/common/references/CloseableReference$CloseableReferenceWithoutFinalizer;->mDestructor:Lcom/facebook/common/references/CloseableReference$CloseableReferenceWithoutFinalizer$Destructor;

    monitor-enter v1

    .line 377
    :try_start_0
    invoke-virtual {p0}, Lcom/facebook/common/references/CloseableReference$CloseableReferenceWithoutFinalizer;->isValid()Z

    move-result v0

    if-eqz v0, :cond_0

    iget-object v0, p0, Lcom/facebook/common/references/CloseableReference$CloseableReferenceWithoutFinalizer;->mSharedReference:Lcom/facebook/common/references/SharedReference;

    invoke-virtual {v0}, Lcom/facebook/common/references/SharedReference;->get()Ljava/lang/Object;

    move-result-object v0

    invoke-static {v0}, Ljava/lang/System;->identityHashCode(Ljava/lang/Object;)I

    move-result v0

    :goto_0
    monitor-exit v1

    return v0

    :cond_0
    const/4 v0, 0x0

    goto :goto_0

    .line 378
    :catchall_0
    move-exception v0

    monitor-exit v1
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    throw v0
.end method

.method public isValid()Z
    .locals 1

    .prologue
    .line 366
    .local p0, "this":Lcom/facebook/common/references/CloseableReference$CloseableReferenceWithoutFinalizer;, "Lcom/facebook/common/references/CloseableReference$CloseableReferenceWithoutFinalizer<TT;>;"
    iget-object v0, p0, Lcom/facebook/common/references/CloseableReference$CloseableReferenceWithoutFinalizer;->mDestructor:Lcom/facebook/common/references/CloseableReference$CloseableReferenceWithoutFinalizer$Destructor;

    invoke-virtual {v0}, Lcom/facebook/common/references/CloseableReference$CloseableReferenceWithoutFinalizer$Destructor;->isDestroyed()Z

    move-result v0

    if-nez v0, :cond_0

    const/4 v0, 0x1

    :goto_0
    return v0

    :cond_0
    const/4 v0, 0x0

    goto :goto_0
.end method

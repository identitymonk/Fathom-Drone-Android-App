.class public Lcom/facebook/drawee/components/DeferredReleaser;
.super Ljava/lang/Object;
.source "DeferredReleaser.java"


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lcom/facebook/drawee/components/DeferredReleaser$Releasable;
    }
.end annotation


# static fields
.field private static sInstance:Lcom/facebook/drawee/components/DeferredReleaser;


# instance fields
.field private final mPendingReleasables:Ljava/util/Set;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/Set",
            "<",
            "Lcom/facebook/drawee/components/DeferredReleaser$Releasable;",
            ">;"
        }
    .end annotation
.end field

.field private final mUiHandler:Landroid/os/Handler;

.field private final releaseRunnable:Ljava/lang/Runnable;


# direct methods
.method static constructor <clinit>()V
    .locals 1

    .prologue
    .line 37
    const/4 v0, 0x0

    sput-object v0, Lcom/facebook/drawee/components/DeferredReleaser;->sInstance:Lcom/facebook/drawee/components/DeferredReleaser;

    return-void
.end method

.method public constructor <init>()V
    .locals 2

    .prologue
    .line 53
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 62
    new-instance v0, Lcom/facebook/drawee/components/DeferredReleaser$1;

    invoke-direct {v0, p0}, Lcom/facebook/drawee/components/DeferredReleaser$1;-><init>(Lcom/facebook/drawee/components/DeferredReleaser;)V

    iput-object v0, p0, Lcom/facebook/drawee/components/DeferredReleaser;->releaseRunnable:Ljava/lang/Runnable;

    .line 54
    new-instance v0, Ljava/util/HashSet;

    invoke-direct {v0}, Ljava/util/HashSet;-><init>()V

    iput-object v0, p0, Lcom/facebook/drawee/components/DeferredReleaser;->mPendingReleasables:Ljava/util/Set;

    .line 55
    new-instance v0, Landroid/os/Handler;

    invoke-static {}, Landroid/os/Looper;->getMainLooper()Landroid/os/Looper;

    move-result-object v1

    invoke-direct {v0, v1}, Landroid/os/Handler;-><init>(Landroid/os/Looper;)V

    iput-object v0, p0, Lcom/facebook/drawee/components/DeferredReleaser;->mUiHandler:Landroid/os/Handler;

    .line 56
    return-void
.end method

.method static synthetic access$000()V
    .locals 0

    .prologue
    .line 35
    invoke-static {}, Lcom/facebook/drawee/components/DeferredReleaser;->ensureOnUiThread()V

    return-void
.end method

.method static synthetic access$100(Lcom/facebook/drawee/components/DeferredReleaser;)Ljava/util/Set;
    .locals 1
    .param p0, "x0"    # Lcom/facebook/drawee/components/DeferredReleaser;

    .prologue
    .line 35
    iget-object v0, p0, Lcom/facebook/drawee/components/DeferredReleaser;->mPendingReleasables:Ljava/util/Set;

    return-object v0
.end method

.method private static ensureOnUiThread()V
    .locals 2

    .prologue
    .line 103
    invoke-static {}, Landroid/os/Looper;->getMainLooper()Landroid/os/Looper;

    move-result-object v0

    invoke-virtual {v0}, Landroid/os/Looper;->getThread()Ljava/lang/Thread;

    move-result-object v0

    invoke-static {}, Ljava/lang/Thread;->currentThread()Ljava/lang/Thread;

    move-result-object v1

    if-ne v0, v1, :cond_0

    const/4 v0, 0x1

    :goto_0
    invoke-static {v0}, Lcom/facebook/common/internal/Preconditions;->checkState(Z)V

    .line 104
    return-void

    .line 103
    :cond_0
    const/4 v0, 0x0

    goto :goto_0
.end method

.method public static declared-synchronized getInstance()Lcom/facebook/drawee/components/DeferredReleaser;
    .locals 2

    .prologue
    .line 40
    const-class v1, Lcom/facebook/drawee/components/DeferredReleaser;

    monitor-enter v1

    :try_start_0
    sget-object v0, Lcom/facebook/drawee/components/DeferredReleaser;->sInstance:Lcom/facebook/drawee/components/DeferredReleaser;

    if-nez v0, :cond_0

    .line 41
    new-instance v0, Lcom/facebook/drawee/components/DeferredReleaser;

    invoke-direct {v0}, Lcom/facebook/drawee/components/DeferredReleaser;-><init>()V

    sput-object v0, Lcom/facebook/drawee/components/DeferredReleaser;->sInstance:Lcom/facebook/drawee/components/DeferredReleaser;

    .line 43
    :cond_0
    sget-object v0, Lcom/facebook/drawee/components/DeferredReleaser;->sInstance:Lcom/facebook/drawee/components/DeferredReleaser;
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    monitor-exit v1

    return-object v0

    .line 40
    :catchall_0
    move-exception v0

    monitor-exit v1

    throw v0
.end method


# virtual methods
.method public cancelDeferredRelease(Lcom/facebook/drawee/components/DeferredReleaser$Releasable;)V
    .locals 1
    .param p1, "releasable"    # Lcom/facebook/drawee/components/DeferredReleaser$Releasable;

    .prologue
    .line 98
    invoke-static {}, Lcom/facebook/drawee/components/DeferredReleaser;->ensureOnUiThread()V

    .line 99
    iget-object v0, p0, Lcom/facebook/drawee/components/DeferredReleaser;->mPendingReleasables:Ljava/util/Set;

    invoke-interface {v0, p1}, Ljava/util/Set;->remove(Ljava/lang/Object;)Z

    .line 100
    return-void
.end method

.method public scheduleDeferredRelease(Lcom/facebook/drawee/components/DeferredReleaser$Releasable;)V
    .locals 2
    .param p1, "releasable"    # Lcom/facebook/drawee/components/DeferredReleaser$Releasable;

    .prologue
    .line 81
    invoke-static {}, Lcom/facebook/drawee/components/DeferredReleaser;->ensureOnUiThread()V

    .line 83
    iget-object v0, p0, Lcom/facebook/drawee/components/DeferredReleaser;->mPendingReleasables:Ljava/util/Set;

    invoke-interface {v0, p1}, Ljava/util/Set;->add(Ljava/lang/Object;)Z

    move-result v0

    if-nez v0, :cond_1

    .line 91
    :cond_0
    :goto_0
    return-void

    .line 88
    :cond_1
    iget-object v0, p0, Lcom/facebook/drawee/components/DeferredReleaser;->mPendingReleasables:Ljava/util/Set;

    invoke-interface {v0}, Ljava/util/Set;->size()I

    move-result v0

    const/4 v1, 0x1

    if-ne v0, v1, :cond_0

    .line 89
    iget-object v0, p0, Lcom/facebook/drawee/components/DeferredReleaser;->mUiHandler:Landroid/os/Handler;

    iget-object v1, p0, Lcom/facebook/drawee/components/DeferredReleaser;->releaseRunnable:Ljava/lang/Runnable;

    invoke-virtual {v0, v1}, Landroid/os/Handler;->post(Ljava/lang/Runnable;)Z

    goto :goto_0
.end method

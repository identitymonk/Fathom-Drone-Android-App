.class public abstract Lcom/facebook/drawee/controller/AbstractDraweeController;
.super Ljava/lang/Object;
.source "AbstractDraweeController.java"

# interfaces
.implements Lcom/facebook/drawee/interfaces/DraweeController;
.implements Lcom/facebook/drawee/components/DeferredReleaser$Releasable;
.implements Lcom/facebook/drawee/gestures/GestureDetector$ClickListener;


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lcom/facebook/drawee/controller/AbstractDraweeController$InternalForwardingListener;
    }
.end annotation

.annotation system Ldalvik/annotation/Signature;
    value = {
        "<T:",
        "Ljava/lang/Object;",
        "INFO:",
        "Ljava/lang/Object;",
        ">",
        "Ljava/lang/Object;",
        "Lcom/facebook/drawee/interfaces/DraweeController;",
        "Lcom/facebook/drawee/components/DeferredReleaser$Releasable;",
        "Lcom/facebook/drawee/gestures/GestureDetector$ClickListener;"
    }
.end annotation

.annotation build Ljavax/annotation/concurrent/NotThreadSafe;
.end annotation


# static fields
.field private static final TAG:Ljava/lang/Class;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/lang/Class",
            "<*>;"
        }
    .end annotation
.end field


# instance fields
.field private mCallerContext:Ljava/lang/Object;

.field private mContentDescription:Ljava/lang/String;
    .annotation runtime Ljavax/annotation/Nullable;
    .end annotation
.end field

.field private mControllerListener:Lcom/facebook/drawee/controller/ControllerListener;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Lcom/facebook/drawee/controller/ControllerListener",
            "<TINFO;>;"
        }
    .end annotation

    .annotation runtime Ljavax/annotation/Nullable;
    .end annotation
.end field

.field private mControllerOverlay:Landroid/graphics/drawable/Drawable;
    .annotation runtime Ljavax/annotation/Nullable;
    .end annotation
.end field

.field private mControllerViewportVisibilityListener:Lcom/facebook/drawee/controller/ControllerViewportVisibilityListener;
    .annotation runtime Ljavax/annotation/Nullable;
    .end annotation
.end field

.field private mDataSource:Lcom/facebook/datasource/DataSource;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Lcom/facebook/datasource/DataSource",
            "<TT;>;"
        }
    .end annotation

    .annotation runtime Ljavax/annotation/Nullable;
    .end annotation
.end field

.field private final mDeferredReleaser:Lcom/facebook/drawee/components/DeferredReleaser;

.field private mDrawable:Landroid/graphics/drawable/Drawable;
    .annotation runtime Ljavax/annotation/Nullable;
    .end annotation
.end field

.field private final mEventTracker:Lcom/facebook/drawee/components/DraweeEventTracker;

.field private mFetchedImage:Ljava/lang/Object;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "TT;"
        }
    .end annotation

    .annotation runtime Ljavax/annotation/Nullable;
    .end annotation
.end field

.field private mGestureDetector:Lcom/facebook/drawee/gestures/GestureDetector;
    .annotation runtime Ljavax/annotation/Nullable;
    .end annotation
.end field

.field private mHasFetchFailed:Z

.field private mId:Ljava/lang/String;

.field private mIsAttached:Z

.field private mIsRequestSubmitted:Z

.field private mIsVisibleInViewportHint:Z

.field private mRetainImageOnFailure:Z

.field private mRetryManager:Lcom/facebook/drawee/components/RetryManager;
    .annotation runtime Ljavax/annotation/Nullable;
    .end annotation
.end field

.field private mSettableDraweeHierarchy:Lcom/facebook/drawee/interfaces/SettableDraweeHierarchy;
    .annotation runtime Ljavax/annotation/Nullable;
    .end annotation
.end field

.field private final mUiThreadImmediateExecutor:Ljava/util/concurrent/Executor;


# direct methods
.method static constructor <clinit>()V
    .locals 1

    .prologue
    .line 67
    const-class v0, Lcom/facebook/drawee/controller/AbstractDraweeController;

    sput-object v0, Lcom/facebook/drawee/controller/AbstractDraweeController;->TAG:Ljava/lang/Class;

    return-void
.end method

.method public constructor <init>(Lcom/facebook/drawee/components/DeferredReleaser;Ljava/util/concurrent/Executor;Ljava/lang/String;Ljava/lang/Object;)V
    .locals 1
    .param p1, "deferredReleaser"    # Lcom/facebook/drawee/components/DeferredReleaser;
    .param p2, "uiThreadImmediateExecutor"    # Ljava/util/concurrent/Executor;
    .param p3, "id"    # Ljava/lang/String;
    .param p4, "callerContext"    # Ljava/lang/Object;

    .prologue
    .line 103
    .local p0, "this":Lcom/facebook/drawee/controller/AbstractDraweeController;, "Lcom/facebook/drawee/controller/AbstractDraweeController<TT;TINFO;>;"
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 70
    invoke-static {}, Lcom/facebook/drawee/components/DraweeEventTracker;->newInstance()Lcom/facebook/drawee/components/DraweeEventTracker;

    move-result-object v0

    iput-object v0, p0, Lcom/facebook/drawee/controller/AbstractDraweeController;->mEventTracker:Lcom/facebook/drawee/components/DraweeEventTracker;

    .line 104
    iput-object p1, p0, Lcom/facebook/drawee/controller/AbstractDraweeController;->mDeferredReleaser:Lcom/facebook/drawee/components/DeferredReleaser;

    .line 105
    iput-object p2, p0, Lcom/facebook/drawee/controller/AbstractDraweeController;->mUiThreadImmediateExecutor:Ljava/util/concurrent/Executor;

    .line 106
    const/4 v0, 0x1

    invoke-direct {p0, p3, p4, v0}, Lcom/facebook/drawee/controller/AbstractDraweeController;->init(Ljava/lang/String;Ljava/lang/Object;Z)V

    .line 107
    return-void
.end method

.method static synthetic access$000(Lcom/facebook/drawee/controller/AbstractDraweeController;Ljava/lang/String;Lcom/facebook/datasource/DataSource;Ljava/lang/Object;FZZ)V
    .locals 0
    .param p0, "x0"    # Lcom/facebook/drawee/controller/AbstractDraweeController;
    .param p1, "x1"    # Ljava/lang/String;
    .param p2, "x2"    # Lcom/facebook/datasource/DataSource;
    .param p3, "x3"    # Ljava/lang/Object;
    .param p4, "x4"    # F
    .param p5, "x5"    # Z
    .param p6, "x6"    # Z

    .prologue
    .line 47
    invoke-direct/range {p0 .. p6}, Lcom/facebook/drawee/controller/AbstractDraweeController;->onNewResultInternal(Ljava/lang/String;Lcom/facebook/datasource/DataSource;Ljava/lang/Object;FZZ)V

    return-void
.end method

.method static synthetic access$100(Lcom/facebook/drawee/controller/AbstractDraweeController;Ljava/lang/String;Lcom/facebook/datasource/DataSource;Ljava/lang/Throwable;Z)V
    .locals 0
    .param p0, "x0"    # Lcom/facebook/drawee/controller/AbstractDraweeController;
    .param p1, "x1"    # Ljava/lang/String;
    .param p2, "x2"    # Lcom/facebook/datasource/DataSource;
    .param p3, "x3"    # Ljava/lang/Throwable;
    .param p4, "x4"    # Z

    .prologue
    .line 47
    invoke-direct {p0, p1, p2, p3, p4}, Lcom/facebook/drawee/controller/AbstractDraweeController;->onFailureInternal(Ljava/lang/String;Lcom/facebook/datasource/DataSource;Ljava/lang/Throwable;Z)V

    return-void
.end method

.method static synthetic access$200(Lcom/facebook/drawee/controller/AbstractDraweeController;Ljava/lang/String;Lcom/facebook/datasource/DataSource;FZ)V
    .locals 0
    .param p0, "x0"    # Lcom/facebook/drawee/controller/AbstractDraweeController;
    .param p1, "x1"    # Ljava/lang/String;
    .param p2, "x2"    # Lcom/facebook/datasource/DataSource;
    .param p3, "x3"    # F
    .param p4, "x4"    # Z

    .prologue
    .line 47
    invoke-direct {p0, p1, p2, p3, p4}, Lcom/facebook/drawee/controller/AbstractDraweeController;->onProgressUpdateInternal(Ljava/lang/String;Lcom/facebook/datasource/DataSource;FZ)V

    return-void
.end method

.method private init(Ljava/lang/String;Ljava/lang/Object;Z)V
    .locals 4
    .param p1, "id"    # Ljava/lang/String;
    .param p2, "callerContext"    # Ljava/lang/Object;
    .param p3, "justConstructed"    # Z

    .prologue
    .local p0, "this":Lcom/facebook/drawee/controller/AbstractDraweeController;, "Lcom/facebook/drawee/controller/AbstractDraweeController<TT;TINFO;>;"
    const/4 v3, 0x0

    const/4 v2, 0x0

    .line 121
    iget-object v0, p0, Lcom/facebook/drawee/controller/AbstractDraweeController;->mEventTracker:Lcom/facebook/drawee/components/DraweeEventTracker;

    sget-object v1, Lcom/facebook/drawee/components/DraweeEventTracker$Event;->ON_INIT_CONTROLLER:Lcom/facebook/drawee/components/DraweeEventTracker$Event;

    invoke-virtual {v0, v1}, Lcom/facebook/drawee/components/DraweeEventTracker;->recordEvent(Lcom/facebook/drawee/components/DraweeEventTracker$Event;)V

    .line 123
    if-nez p3, :cond_0

    iget-object v0, p0, Lcom/facebook/drawee/controller/AbstractDraweeController;->mDeferredReleaser:Lcom/facebook/drawee/components/DeferredReleaser;

    if-eqz v0, :cond_0

    .line 124
    iget-object v0, p0, Lcom/facebook/drawee/controller/AbstractDraweeController;->mDeferredReleaser:Lcom/facebook/drawee/components/DeferredReleaser;

    invoke-virtual {v0, p0}, Lcom/facebook/drawee/components/DeferredReleaser;->cancelDeferredRelease(Lcom/facebook/drawee/components/DeferredReleaser$Releasable;)V

    .line 127
    :cond_0
    iput-boolean v3, p0, Lcom/facebook/drawee/controller/AbstractDraweeController;->mIsAttached:Z

    .line 128
    iput-boolean v3, p0, Lcom/facebook/drawee/controller/AbstractDraweeController;->mIsVisibleInViewportHint:Z

    .line 129
    invoke-direct {p0}, Lcom/facebook/drawee/controller/AbstractDraweeController;->releaseFetch()V

    .line 130
    iput-boolean v3, p0, Lcom/facebook/drawee/controller/AbstractDraweeController;->mRetainImageOnFailure:Z

    .line 132
    iget-object v0, p0, Lcom/facebook/drawee/controller/AbstractDraweeController;->mRetryManager:Lcom/facebook/drawee/components/RetryManager;

    if-eqz v0, :cond_1

    .line 133
    iget-object v0, p0, Lcom/facebook/drawee/controller/AbstractDraweeController;->mRetryManager:Lcom/facebook/drawee/components/RetryManager;

    invoke-virtual {v0}, Lcom/facebook/drawee/components/RetryManager;->init()V

    .line 135
    :cond_1
    iget-object v0, p0, Lcom/facebook/drawee/controller/AbstractDraweeController;->mGestureDetector:Lcom/facebook/drawee/gestures/GestureDetector;

    if-eqz v0, :cond_2

    .line 136
    iget-object v0, p0, Lcom/facebook/drawee/controller/AbstractDraweeController;->mGestureDetector:Lcom/facebook/drawee/gestures/GestureDetector;

    invoke-virtual {v0}, Lcom/facebook/drawee/gestures/GestureDetector;->init()V

    .line 137
    iget-object v0, p0, Lcom/facebook/drawee/controller/AbstractDraweeController;->mGestureDetector:Lcom/facebook/drawee/gestures/GestureDetector;

    invoke-virtual {v0, p0}, Lcom/facebook/drawee/gestures/GestureDetector;->setClickListener(Lcom/facebook/drawee/gestures/GestureDetector$ClickListener;)V

    .line 139
    :cond_2
    iget-object v0, p0, Lcom/facebook/drawee/controller/AbstractDraweeController;->mControllerListener:Lcom/facebook/drawee/controller/ControllerListener;

    instance-of v0, v0, Lcom/facebook/drawee/controller/AbstractDraweeController$InternalForwardingListener;

    if-eqz v0, :cond_5

    .line 140
    iget-object v0, p0, Lcom/facebook/drawee/controller/AbstractDraweeController;->mControllerListener:Lcom/facebook/drawee/controller/ControllerListener;

    check-cast v0, Lcom/facebook/drawee/controller/AbstractDraweeController$InternalForwardingListener;

    invoke-virtual {v0}, Lcom/facebook/drawee/controller/AbstractDraweeController$InternalForwardingListener;->clearListeners()V

    .line 144
    :goto_0
    iput-object v2, p0, Lcom/facebook/drawee/controller/AbstractDraweeController;->mControllerViewportVisibilityListener:Lcom/facebook/drawee/controller/ControllerViewportVisibilityListener;

    .line 146
    iget-object v0, p0, Lcom/facebook/drawee/controller/AbstractDraweeController;->mSettableDraweeHierarchy:Lcom/facebook/drawee/interfaces/SettableDraweeHierarchy;

    if-eqz v0, :cond_3

    .line 147
    iget-object v0, p0, Lcom/facebook/drawee/controller/AbstractDraweeController;->mSettableDraweeHierarchy:Lcom/facebook/drawee/interfaces/SettableDraweeHierarchy;

    invoke-interface {v0}, Lcom/facebook/drawee/interfaces/SettableDraweeHierarchy;->reset()V

    .line 148
    iget-object v0, p0, Lcom/facebook/drawee/controller/AbstractDraweeController;->mSettableDraweeHierarchy:Lcom/facebook/drawee/interfaces/SettableDraweeHierarchy;

    invoke-interface {v0, v2}, Lcom/facebook/drawee/interfaces/SettableDraweeHierarchy;->setControllerOverlay(Landroid/graphics/drawable/Drawable;)V

    .line 149
    iput-object v2, p0, Lcom/facebook/drawee/controller/AbstractDraweeController;->mSettableDraweeHierarchy:Lcom/facebook/drawee/interfaces/SettableDraweeHierarchy;

    .line 151
    :cond_3
    iput-object v2, p0, Lcom/facebook/drawee/controller/AbstractDraweeController;->mControllerOverlay:Landroid/graphics/drawable/Drawable;

    .line 153
    const/4 v0, 0x2

    invoke-static {v0}, Lcom/facebook/common/logging/FLog;->isLoggable(I)Z

    move-result v0

    if-eqz v0, :cond_4

    .line 154
    sget-object v0, Lcom/facebook/drawee/controller/AbstractDraweeController;->TAG:Ljava/lang/Class;

    const-string v1, "controller %x %s -> %s: initialize"

    invoke-static {p0}, Ljava/lang/System;->identityHashCode(Ljava/lang/Object;)I

    move-result v2

    invoke-static {v2}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v2

    iget-object v3, p0, Lcom/facebook/drawee/controller/AbstractDraweeController;->mId:Ljava/lang/String;

    invoke-static {v0, v1, v2, v3, p1}, Lcom/facebook/common/logging/FLog;->v(Ljava/lang/Class;Ljava/lang/String;Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;)V

    .line 156
    :cond_4
    iput-object p1, p0, Lcom/facebook/drawee/controller/AbstractDraweeController;->mId:Ljava/lang/String;

    .line 157
    iput-object p2, p0, Lcom/facebook/drawee/controller/AbstractDraweeController;->mCallerContext:Ljava/lang/Object;

    .line 158
    return-void

    .line 142
    :cond_5
    iput-object v2, p0, Lcom/facebook/drawee/controller/AbstractDraweeController;->mControllerListener:Lcom/facebook/drawee/controller/ControllerListener;

    goto :goto_0
.end method

.method private isExpectedDataSource(Ljava/lang/String;Lcom/facebook/datasource/DataSource;)Z
    .locals 2
    .param p1, "id"    # Ljava/lang/String;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/lang/String;",
            "Lcom/facebook/datasource/DataSource",
            "<TT;>;)Z"
        }
    .end annotation

    .prologue
    .local p0, "this":Lcom/facebook/drawee/controller/AbstractDraweeController;, "Lcom/facebook/drawee/controller/AbstractDraweeController<TT;TINFO;>;"
    .local p2, "dataSource":Lcom/facebook/datasource/DataSource;, "Lcom/facebook/datasource/DataSource<TT;>;"
    const/4 v0, 0x1

    .line 595
    if-nez p2, :cond_1

    iget-object v1, p0, Lcom/facebook/drawee/controller/AbstractDraweeController;->mDataSource:Lcom/facebook/datasource/DataSource;

    if-nez v1, :cond_1

    .line 602
    :cond_0
    :goto_0
    return v0

    :cond_1
    iget-object v1, p0, Lcom/facebook/drawee/controller/AbstractDraweeController;->mId:Ljava/lang/String;

    invoke-virtual {p1, v1}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v1

    if-eqz v1, :cond_2

    iget-object v1, p0, Lcom/facebook/drawee/controller/AbstractDraweeController;->mDataSource:Lcom/facebook/datasource/DataSource;

    if-ne p2, v1, :cond_2

    iget-boolean v1, p0, Lcom/facebook/drawee/controller/AbstractDraweeController;->mIsRequestSubmitted:Z

    if-nez v1, :cond_0

    :cond_2
    const/4 v0, 0x0

    goto :goto_0
.end method

.method private logMessageAndFailure(Ljava/lang/String;Ljava/lang/Throwable;)V
    .locals 6
    .param p1, "messageAndMethod"    # Ljava/lang/String;
    .param p2, "throwable"    # Ljava/lang/Throwable;

    .prologue
    .line 619
    .local p0, "this":Lcom/facebook/drawee/controller/AbstractDraweeController;, "Lcom/facebook/drawee/controller/AbstractDraweeController<TT;TINFO;>;"
    const/4 v0, 0x2

    invoke-static {v0}, Lcom/facebook/common/logging/FLog;->isLoggable(I)Z

    move-result v0

    if-eqz v0, :cond_0

    .line 620
    sget-object v0, Lcom/facebook/drawee/controller/AbstractDraweeController;->TAG:Ljava/lang/Class;

    const-string v1, "controller %x %s: %s: failure: %s"

    .line 623
    invoke-static {p0}, Ljava/lang/System;->identityHashCode(Ljava/lang/Object;)I

    move-result v2

    invoke-static {v2}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v2

    iget-object v3, p0, Lcom/facebook/drawee/controller/AbstractDraweeController;->mId:Ljava/lang/String;

    move-object v4, p1

    move-object v5, p2

    .line 620
    invoke-static/range {v0 .. v5}, Lcom/facebook/common/logging/FLog;->v(Ljava/lang/Class;Ljava/lang/String;Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;)V

    .line 628
    :cond_0
    return-void
.end method

.method private logMessageAndImage(Ljava/lang/String;Ljava/lang/Object;)V
    .locals 6
    .param p1, "messageAndMethod"    # Ljava/lang/String;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/lang/String;",
            "TT;)V"
        }
    .end annotation

    .prologue
    .local p0, "this":Lcom/facebook/drawee/controller/AbstractDraweeController;, "Lcom/facebook/drawee/controller/AbstractDraweeController<TT;TINFO;>;"
    .local p2, "image":Ljava/lang/Object;, "TT;"
    const/4 v5, 0x2

    .line 606
    invoke-static {v5}, Lcom/facebook/common/logging/FLog;->isLoggable(I)Z

    move-result v0

    if-eqz v0, :cond_0

    .line 607
    sget-object v0, Lcom/facebook/drawee/controller/AbstractDraweeController;->TAG:Ljava/lang/Class;

    const-string v1, "controller %x %s: %s: image: %s %x"

    const/4 v2, 0x5

    new-array v2, v2, [Ljava/lang/Object;

    const/4 v3, 0x0

    .line 610
    invoke-static {p0}, Ljava/lang/System;->identityHashCode(Ljava/lang/Object;)I

    move-result v4

    invoke-static {v4}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v4

    aput-object v4, v2, v3

    const/4 v3, 0x1

    iget-object v4, p0, Lcom/facebook/drawee/controller/AbstractDraweeController;->mId:Ljava/lang/String;

    aput-object v4, v2, v3

    aput-object p1, v2, v5

    const/4 v3, 0x3

    .line 613
    invoke-virtual {p0, p2}, Lcom/facebook/drawee/controller/AbstractDraweeController;->getImageClass(Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v4

    aput-object v4, v2, v3

    const/4 v3, 0x4

    .line 614
    invoke-virtual {p0, p2}, Lcom/facebook/drawee/controller/AbstractDraweeController;->getImageHash(Ljava/lang/Object;)I

    move-result v4

    invoke-static {v4}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v4

    aput-object v4, v2, v3

    .line 607
    invoke-static {v0, v1, v2}, Lcom/facebook/common/logging/FLog;->v(Ljava/lang/Class;Ljava/lang/String;[Ljava/lang/Object;)V

    .line 616
    :cond_0
    return-void
.end method

.method private onFailureInternal(Ljava/lang/String;Lcom/facebook/datasource/DataSource;Ljava/lang/Throwable;Z)V
    .locals 4
    .param p1, "id"    # Ljava/lang/String;
    .param p3, "throwable"    # Ljava/lang/Throwable;
    .param p4, "isFinished"    # Z
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/lang/String;",
            "Lcom/facebook/datasource/DataSource",
            "<TT;>;",
            "Ljava/lang/Throwable;",
            "Z)V"
        }
    .end annotation

    .prologue
    .local p0, "this":Lcom/facebook/drawee/controller/AbstractDraweeController;, "Lcom/facebook/drawee/controller/AbstractDraweeController<TT;TINFO;>;"
    .local p2, "dataSource":Lcom/facebook/datasource/DataSource;, "Lcom/facebook/datasource/DataSource<TT;>;"
    const/4 v3, 0x1

    .line 549
    invoke-direct {p0, p1, p2}, Lcom/facebook/drawee/controller/AbstractDraweeController;->isExpectedDataSource(Ljava/lang/String;Lcom/facebook/datasource/DataSource;)Z

    move-result v0

    if-nez v0, :cond_0

    .line 550
    const-string v0, "ignore_old_datasource @ onFailure"

    invoke-direct {p0, v0, p3}, Lcom/facebook/drawee/controller/AbstractDraweeController;->logMessageAndFailure(Ljava/lang/String;Ljava/lang/Throwable;)V

    .line 551
    invoke-interface {p2}, Lcom/facebook/datasource/DataSource;->close()Z

    .line 576
    :goto_0
    return-void

    .line 554
    :cond_0
    iget-object v1, p0, Lcom/facebook/drawee/controller/AbstractDraweeController;->mEventTracker:Lcom/facebook/drawee/components/DraweeEventTracker;

    if-eqz p4, :cond_1

    sget-object v0, Lcom/facebook/drawee/components/DraweeEventTracker$Event;->ON_DATASOURCE_FAILURE:Lcom/facebook/drawee/components/DraweeEventTracker$Event;

    :goto_1
    invoke-virtual {v1, v0}, Lcom/facebook/drawee/components/DraweeEventTracker;->recordEvent(Lcom/facebook/drawee/components/DraweeEventTracker$Event;)V

    .line 557
    if-eqz p4, :cond_4

    .line 558
    const-string v0, "final_failed @ onFailure"

    invoke-direct {p0, v0, p3}, Lcom/facebook/drawee/controller/AbstractDraweeController;->logMessageAndFailure(Ljava/lang/String;Ljava/lang/Throwable;)V

    .line 559
    const/4 v0, 0x0

    iput-object v0, p0, Lcom/facebook/drawee/controller/AbstractDraweeController;->mDataSource:Lcom/facebook/datasource/DataSource;

    .line 560
    iput-boolean v3, p0, Lcom/facebook/drawee/controller/AbstractDraweeController;->mHasFetchFailed:Z

    .line 562
    iget-boolean v0, p0, Lcom/facebook/drawee/controller/AbstractDraweeController;->mRetainImageOnFailure:Z

    if-eqz v0, :cond_2

    iget-object v0, p0, Lcom/facebook/drawee/controller/AbstractDraweeController;->mDrawable:Landroid/graphics/drawable/Drawable;

    if-eqz v0, :cond_2

    .line 563
    iget-object v0, p0, Lcom/facebook/drawee/controller/AbstractDraweeController;->mSettableDraweeHierarchy:Lcom/facebook/drawee/interfaces/SettableDraweeHierarchy;

    iget-object v1, p0, Lcom/facebook/drawee/controller/AbstractDraweeController;->mDrawable:Landroid/graphics/drawable/Drawable;

    const/high16 v2, 0x3f800000    # 1.0f

    invoke-interface {v0, v1, v2, v3}, Lcom/facebook/drawee/interfaces/SettableDraweeHierarchy;->setImage(Landroid/graphics/drawable/Drawable;FZ)V

    .line 569
    :goto_2
    invoke-virtual {p0}, Lcom/facebook/drawee/controller/AbstractDraweeController;->getControllerListener()Lcom/facebook/drawee/controller/ControllerListener;

    move-result-object v0

    iget-object v1, p0, Lcom/facebook/drawee/controller/AbstractDraweeController;->mId:Ljava/lang/String;

    invoke-interface {v0, v1, p3}, Lcom/facebook/drawee/controller/ControllerListener;->onFailure(Ljava/lang/String;Ljava/lang/Throwable;)V

    goto :goto_0

    .line 554
    :cond_1
    sget-object v0, Lcom/facebook/drawee/components/DraweeEventTracker$Event;->ON_DATASOURCE_FAILURE_INT:Lcom/facebook/drawee/components/DraweeEventTracker$Event;

    goto :goto_1

    .line 564
    :cond_2
    invoke-direct {p0}, Lcom/facebook/drawee/controller/AbstractDraweeController;->shouldRetryOnTap()Z

    move-result v0

    if-eqz v0, :cond_3

    .line 565
    iget-object v0, p0, Lcom/facebook/drawee/controller/AbstractDraweeController;->mSettableDraweeHierarchy:Lcom/facebook/drawee/interfaces/SettableDraweeHierarchy;

    invoke-interface {v0, p3}, Lcom/facebook/drawee/interfaces/SettableDraweeHierarchy;->setRetry(Ljava/lang/Throwable;)V

    goto :goto_2

    .line 567
    :cond_3
    iget-object v0, p0, Lcom/facebook/drawee/controller/AbstractDraweeController;->mSettableDraweeHierarchy:Lcom/facebook/drawee/interfaces/SettableDraweeHierarchy;

    invoke-interface {v0, p3}, Lcom/facebook/drawee/interfaces/SettableDraweeHierarchy;->setFailure(Ljava/lang/Throwable;)V

    goto :goto_2

    .line 572
    :cond_4
    const-string v0, "intermediate_failed @ onFailure"

    invoke-direct {p0, v0, p3}, Lcom/facebook/drawee/controller/AbstractDraweeController;->logMessageAndFailure(Ljava/lang/String;Ljava/lang/Throwable;)V

    .line 573
    invoke-virtual {p0}, Lcom/facebook/drawee/controller/AbstractDraweeController;->getControllerListener()Lcom/facebook/drawee/controller/ControllerListener;

    move-result-object v0

    iget-object v1, p0, Lcom/facebook/drawee/controller/AbstractDraweeController;->mId:Ljava/lang/String;

    invoke-interface {v0, v1, p3}, Lcom/facebook/drawee/controller/ControllerListener;->onIntermediateImageFailed(Ljava/lang/String;Ljava/lang/Throwable;)V

    goto :goto_0
.end method

.method private onNewResultInternal(Ljava/lang/String;Lcom/facebook/datasource/DataSource;Ljava/lang/Object;FZZ)V
    .locals 7
    .param p1, "id"    # Ljava/lang/String;
    .param p3    # Ljava/lang/Object;
        .annotation runtime Ljavax/annotation/Nullable;
        .end annotation
    .end param
    .param p4, "progress"    # F
    .param p5, "isFinished"    # Z
    .param p6, "wasImmediate"    # Z
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/lang/String;",
            "Lcom/facebook/datasource/DataSource",
            "<TT;>;TT;FZZ)V"
        }
    .end annotation

    .prologue
    .line 496
    .local p0, "this":Lcom/facebook/drawee/controller/AbstractDraweeController;, "Lcom/facebook/drawee/controller/AbstractDraweeController<TT;TINFO;>;"
    .local p2, "dataSource":Lcom/facebook/datasource/DataSource;, "Lcom/facebook/datasource/DataSource<TT;>;"
    .local p3, "image":Ljava/lang/Object;, "TT;"
    invoke-direct {p0, p1, p2}, Lcom/facebook/drawee/controller/AbstractDraweeController;->isExpectedDataSource(Ljava/lang/String;Lcom/facebook/datasource/DataSource;)Z

    move-result v4

    if-nez v4, :cond_1

    .line 497
    const-string v4, "ignore_old_datasource @ onNewResult"

    invoke-direct {p0, v4, p3}, Lcom/facebook/drawee/controller/AbstractDraweeController;->logMessageAndImage(Ljava/lang/String;Ljava/lang/Object;)V

    .line 498
    invoke-virtual {p0, p3}, Lcom/facebook/drawee/controller/AbstractDraweeController;->releaseImage(Ljava/lang/Object;)V

    .line 499
    invoke-interface {p2}, Lcom/facebook/datasource/DataSource;->close()Z

    .line 541
    :cond_0
    :goto_0
    return-void

    .line 502
    :cond_1
    iget-object v5, p0, Lcom/facebook/drawee/controller/AbstractDraweeController;->mEventTracker:Lcom/facebook/drawee/components/DraweeEventTracker;

    if-eqz p5, :cond_3

    sget-object v4, Lcom/facebook/drawee/components/DraweeEventTracker$Event;->ON_DATASOURCE_RESULT:Lcom/facebook/drawee/components/DraweeEventTracker$Event;

    :goto_1
    invoke-virtual {v5, v4}, Lcom/facebook/drawee/components/DraweeEventTracker;->recordEvent(Lcom/facebook/drawee/components/DraweeEventTracker$Event;)V

    .line 507
    :try_start_0
    invoke-virtual {p0, p3}, Lcom/facebook/drawee/controller/AbstractDraweeController;->createDrawable(Ljava/lang/Object;)Landroid/graphics/drawable/Drawable;
    :try_end_0
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_0

    move-result-object v0

    .line 514
    .local v0, "drawable":Landroid/graphics/drawable/Drawable;
    iget-object v3, p0, Lcom/facebook/drawee/controller/AbstractDraweeController;->mFetchedImage:Ljava/lang/Object;

    .line 515
    .local v3, "previousImage":Ljava/lang/Object;, "TT;"
    iget-object v2, p0, Lcom/facebook/drawee/controller/AbstractDraweeController;->mDrawable:Landroid/graphics/drawable/Drawable;

    .line 516
    .local v2, "previousDrawable":Landroid/graphics/drawable/Drawable;
    iput-object p3, p0, Lcom/facebook/drawee/controller/AbstractDraweeController;->mFetchedImage:Ljava/lang/Object;

    .line 517
    iput-object v0, p0, Lcom/facebook/drawee/controller/AbstractDraweeController;->mDrawable:Landroid/graphics/drawable/Drawable;

    .line 520
    if-eqz p5, :cond_4

    .line 521
    :try_start_1
    const-string v4, "set_final_result @ onNewResult"

    invoke-direct {p0, v4, p3}, Lcom/facebook/drawee/controller/AbstractDraweeController;->logMessageAndImage(Ljava/lang/String;Ljava/lang/Object;)V

    .line 522
    const/4 v4, 0x0

    iput-object v4, p0, Lcom/facebook/drawee/controller/AbstractDraweeController;->mDataSource:Lcom/facebook/datasource/DataSource;

    .line 523
    iget-object v4, p0, Lcom/facebook/drawee/controller/AbstractDraweeController;->mSettableDraweeHierarchy:Lcom/facebook/drawee/interfaces/SettableDraweeHierarchy;

    const/high16 v5, 0x3f800000    # 1.0f

    invoke-interface {v4, v0, v5, p6}, Lcom/facebook/drawee/interfaces/SettableDraweeHierarchy;->setImage(Landroid/graphics/drawable/Drawable;FZ)V

    .line 524
    invoke-virtual {p0}, Lcom/facebook/drawee/controller/AbstractDraweeController;->getControllerListener()Lcom/facebook/drawee/controller/ControllerListener;

    move-result-object v4

    invoke-virtual {p0, p3}, Lcom/facebook/drawee/controller/AbstractDraweeController;->getImageInfo(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v5

    invoke-virtual {p0}, Lcom/facebook/drawee/controller/AbstractDraweeController;->getAnimatable()Landroid/graphics/drawable/Animatable;

    move-result-object v6

    invoke-interface {v4, p1, v5, v6}, Lcom/facebook/drawee/controller/ControllerListener;->onFinalImageSet(Ljava/lang/String;Ljava/lang/Object;Landroid/graphics/drawable/Animatable;)V
    :try_end_1
    .catchall {:try_start_1 .. :try_end_1} :catchall_0

    .line 533
    :goto_2
    if-eqz v2, :cond_2

    if-eq v2, v0, :cond_2

    .line 534
    invoke-virtual {p0, v2}, Lcom/facebook/drawee/controller/AbstractDraweeController;->releaseDrawable(Landroid/graphics/drawable/Drawable;)V

    .line 536
    :cond_2
    if-eqz v3, :cond_0

    if-eq v3, p3, :cond_0

    .line 537
    const-string v4, "release_previous_result @ onNewResult"

    invoke-direct {p0, v4, v3}, Lcom/facebook/drawee/controller/AbstractDraweeController;->logMessageAndImage(Ljava/lang/String;Ljava/lang/Object;)V

    .line 538
    invoke-virtual {p0, v3}, Lcom/facebook/drawee/controller/AbstractDraweeController;->releaseImage(Ljava/lang/Object;)V

    goto :goto_0

    .line 502
    .end local v0    # "drawable":Landroid/graphics/drawable/Drawable;
    .end local v2    # "previousDrawable":Landroid/graphics/drawable/Drawable;
    .end local v3    # "previousImage":Ljava/lang/Object;, "TT;"
    :cond_3
    sget-object v4, Lcom/facebook/drawee/components/DraweeEventTracker$Event;->ON_DATASOURCE_RESULT_INT:Lcom/facebook/drawee/components/DraweeEventTracker$Event;

    goto :goto_1

    .line 508
    :catch_0
    move-exception v1

    .line 509
    .local v1, "exception":Ljava/lang/Exception;
    const-string v4, "drawable_failed @ onNewResult"

    invoke-direct {p0, v4, p3}, Lcom/facebook/drawee/controller/AbstractDraweeController;->logMessageAndImage(Ljava/lang/String;Ljava/lang/Object;)V

    .line 510
    invoke-virtual {p0, p3}, Lcom/facebook/drawee/controller/AbstractDraweeController;->releaseImage(Ljava/lang/Object;)V

    .line 511
    invoke-direct {p0, p1, p2, v1, p5}, Lcom/facebook/drawee/controller/AbstractDraweeController;->onFailureInternal(Ljava/lang/String;Lcom/facebook/datasource/DataSource;Ljava/lang/Throwable;Z)V

    goto :goto_0

    .line 527
    .end local v1    # "exception":Ljava/lang/Exception;
    .restart local v0    # "drawable":Landroid/graphics/drawable/Drawable;
    .restart local v2    # "previousDrawable":Landroid/graphics/drawable/Drawable;
    .restart local v3    # "previousImage":Ljava/lang/Object;, "TT;"
    :cond_4
    :try_start_2
    const-string v4, "set_intermediate_result @ onNewResult"

    invoke-direct {p0, v4, p3}, Lcom/facebook/drawee/controller/AbstractDraweeController;->logMessageAndImage(Ljava/lang/String;Ljava/lang/Object;)V

    .line 528
    iget-object v4, p0, Lcom/facebook/drawee/controller/AbstractDraweeController;->mSettableDraweeHierarchy:Lcom/facebook/drawee/interfaces/SettableDraweeHierarchy;

    invoke-interface {v4, v0, p4, p6}, Lcom/facebook/drawee/interfaces/SettableDraweeHierarchy;->setImage(Landroid/graphics/drawable/Drawable;FZ)V

    .line 529
    invoke-virtual {p0}, Lcom/facebook/drawee/controller/AbstractDraweeController;->getControllerListener()Lcom/facebook/drawee/controller/ControllerListener;

    move-result-object v4

    invoke-virtual {p0, p3}, Lcom/facebook/drawee/controller/AbstractDraweeController;->getImageInfo(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v5

    invoke-interface {v4, p1, v5}, Lcom/facebook/drawee/controller/ControllerListener;->onIntermediateImageSet(Ljava/lang/String;Ljava/lang/Object;)V
    :try_end_2
    .catchall {:try_start_2 .. :try_end_2} :catchall_0

    goto :goto_2

    .line 533
    :catchall_0
    move-exception v4

    if-eqz v2, :cond_5

    if-eq v2, v0, :cond_5

    .line 534
    invoke-virtual {p0, v2}, Lcom/facebook/drawee/controller/AbstractDraweeController;->releaseDrawable(Landroid/graphics/drawable/Drawable;)V

    .line 536
    :cond_5
    if-eqz v3, :cond_6

    if-eq v3, p3, :cond_6

    .line 537
    const-string v5, "release_previous_result @ onNewResult"

    invoke-direct {p0, v5, v3}, Lcom/facebook/drawee/controller/AbstractDraweeController;->logMessageAndImage(Ljava/lang/String;Ljava/lang/Object;)V

    .line 538
    invoke-virtual {p0, v3}, Lcom/facebook/drawee/controller/AbstractDraweeController;->releaseImage(Ljava/lang/Object;)V

    :cond_6
    throw v4
.end method

.method private onProgressUpdateInternal(Ljava/lang/String;Lcom/facebook/datasource/DataSource;FZ)V
    .locals 2
    .param p1, "id"    # Ljava/lang/String;
    .param p3, "progress"    # F
    .param p4, "isFinished"    # Z
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/lang/String;",
            "Lcom/facebook/datasource/DataSource",
            "<TT;>;FZ)V"
        }
    .end annotation

    .prologue
    .line 584
    .local p0, "this":Lcom/facebook/drawee/controller/AbstractDraweeController;, "Lcom/facebook/drawee/controller/AbstractDraweeController<TT;TINFO;>;"
    .local p2, "dataSource":Lcom/facebook/datasource/DataSource;, "Lcom/facebook/datasource/DataSource<TT;>;"
    invoke-direct {p0, p1, p2}, Lcom/facebook/drawee/controller/AbstractDraweeController;->isExpectedDataSource(Ljava/lang/String;Lcom/facebook/datasource/DataSource;)Z

    move-result v0

    if-nez v0, :cond_1

    .line 585
    const-string v0, "ignore_old_datasource @ onProgress"

    const/4 v1, 0x0

    invoke-direct {p0, v0, v1}, Lcom/facebook/drawee/controller/AbstractDraweeController;->logMessageAndFailure(Ljava/lang/String;Ljava/lang/Throwable;)V

    .line 586
    invoke-interface {p2}, Lcom/facebook/datasource/DataSource;->close()Z

    .line 592
    :cond_0
    :goto_0
    return-void

    .line 589
    :cond_1
    if-nez p4, :cond_0

    .line 590
    iget-object v0, p0, Lcom/facebook/drawee/controller/AbstractDraweeController;->mSettableDraweeHierarchy:Lcom/facebook/drawee/interfaces/SettableDraweeHierarchy;

    const/4 v1, 0x0

    invoke-interface {v0, p3, v1}, Lcom/facebook/drawee/interfaces/SettableDraweeHierarchy;->setProgress(FZ)V

    goto :goto_0
.end method

.method private releaseFetch()V
    .locals 4

    .prologue
    .local p0, "this":Lcom/facebook/drawee/controller/AbstractDraweeController;, "Lcom/facebook/drawee/controller/AbstractDraweeController<TT;TINFO;>;"
    const/4 v1, 0x0

    const/4 v3, 0x0

    .line 176
    iget-boolean v0, p0, Lcom/facebook/drawee/controller/AbstractDraweeController;->mIsRequestSubmitted:Z

    .line 177
    .local v0, "wasRequestSubmitted":Z
    iput-boolean v1, p0, Lcom/facebook/drawee/controller/AbstractDraweeController;->mIsRequestSubmitted:Z

    .line 178
    iput-boolean v1, p0, Lcom/facebook/drawee/controller/AbstractDraweeController;->mHasFetchFailed:Z

    .line 179
    iget-object v1, p0, Lcom/facebook/drawee/controller/AbstractDraweeController;->mDataSource:Lcom/facebook/datasource/DataSource;

    if-eqz v1, :cond_0

    .line 180
    iget-object v1, p0, Lcom/facebook/drawee/controller/AbstractDraweeController;->mDataSource:Lcom/facebook/datasource/DataSource;

    invoke-interface {v1}, Lcom/facebook/datasource/DataSource;->close()Z

    .line 181
    iput-object v3, p0, Lcom/facebook/drawee/controller/AbstractDraweeController;->mDataSource:Lcom/facebook/datasource/DataSource;

    .line 183
    :cond_0
    iget-object v1, p0, Lcom/facebook/drawee/controller/AbstractDraweeController;->mDrawable:Landroid/graphics/drawable/Drawable;

    if-eqz v1, :cond_1

    .line 184
    iget-object v1, p0, Lcom/facebook/drawee/controller/AbstractDraweeController;->mDrawable:Landroid/graphics/drawable/Drawable;

    invoke-virtual {p0, v1}, Lcom/facebook/drawee/controller/AbstractDraweeController;->releaseDrawable(Landroid/graphics/drawable/Drawable;)V

    .line 186
    :cond_1
    iget-object v1, p0, Lcom/facebook/drawee/controller/AbstractDraweeController;->mContentDescription:Ljava/lang/String;

    if-eqz v1, :cond_2

    .line 187
    iput-object v3, p0, Lcom/facebook/drawee/controller/AbstractDraweeController;->mContentDescription:Ljava/lang/String;

    .line 189
    :cond_2
    iput-object v3, p0, Lcom/facebook/drawee/controller/AbstractDraweeController;->mDrawable:Landroid/graphics/drawable/Drawable;

    .line 190
    iget-object v1, p0, Lcom/facebook/drawee/controller/AbstractDraweeController;->mFetchedImage:Ljava/lang/Object;

    if-eqz v1, :cond_3

    .line 191
    const-string v1, "release"

    iget-object v2, p0, Lcom/facebook/drawee/controller/AbstractDraweeController;->mFetchedImage:Ljava/lang/Object;

    invoke-direct {p0, v1, v2}, Lcom/facebook/drawee/controller/AbstractDraweeController;->logMessageAndImage(Ljava/lang/String;Ljava/lang/Object;)V

    .line 192
    iget-object v1, p0, Lcom/facebook/drawee/controller/AbstractDraweeController;->mFetchedImage:Ljava/lang/Object;

    invoke-virtual {p0, v1}, Lcom/facebook/drawee/controller/AbstractDraweeController;->releaseImage(Ljava/lang/Object;)V

    .line 193
    iput-object v3, p0, Lcom/facebook/drawee/controller/AbstractDraweeController;->mFetchedImage:Ljava/lang/Object;

    .line 195
    :cond_3
    if-eqz v0, :cond_4

    .line 196
    invoke-virtual {p0}, Lcom/facebook/drawee/controller/AbstractDraweeController;->getControllerListener()Lcom/facebook/drawee/controller/ControllerListener;

    move-result-object v1

    iget-object v2, p0, Lcom/facebook/drawee/controller/AbstractDraweeController;->mId:Ljava/lang/String;

    invoke-interface {v1, v2}, Lcom/facebook/drawee/controller/ControllerListener;->onRelease(Ljava/lang/String;)V

    .line 198
    :cond_4
    return-void
.end method

.method private shouldRetryOnTap()Z
    .locals 1

    .prologue
    .line 415
    .local p0, "this":Lcom/facebook/drawee/controller/AbstractDraweeController;, "Lcom/facebook/drawee/controller/AbstractDraweeController<TT;TINFO;>;"
    iget-boolean v0, p0, Lcom/facebook/drawee/controller/AbstractDraweeController;->mHasFetchFailed:Z

    if-eqz v0, :cond_0

    iget-object v0, p0, Lcom/facebook/drawee/controller/AbstractDraweeController;->mRetryManager:Lcom/facebook/drawee/components/RetryManager;

    if-eqz v0, :cond_0

    iget-object v0, p0, Lcom/facebook/drawee/controller/AbstractDraweeController;->mRetryManager:Lcom/facebook/drawee/components/RetryManager;

    invoke-virtual {v0}, Lcom/facebook/drawee/components/RetryManager;->shouldRetryOnTap()Z

    move-result v0

    if-eqz v0, :cond_0

    const/4 v0, 0x1

    :goto_0
    return v0

    :cond_0
    const/4 v0, 0x0

    goto :goto_0
.end method


# virtual methods
.method public addControllerListener(Lcom/facebook/drawee/controller/ControllerListener;)V
    .locals 1
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Lcom/facebook/drawee/controller/ControllerListener",
            "<-TINFO;>;)V"
        }
    .end annotation

    .prologue
    .line 252
    .local p0, "this":Lcom/facebook/drawee/controller/AbstractDraweeController;, "Lcom/facebook/drawee/controller/AbstractDraweeController<TT;TINFO;>;"
    .local p1, "controllerListener":Lcom/facebook/drawee/controller/ControllerListener;, "Lcom/facebook/drawee/controller/ControllerListener<-TINFO;>;"
    invoke-static {p1}, Lcom/facebook/common/internal/Preconditions;->checkNotNull(Ljava/lang/Object;)Ljava/lang/Object;

    .line 253
    iget-object v0, p0, Lcom/facebook/drawee/controller/AbstractDraweeController;->mControllerListener:Lcom/facebook/drawee/controller/ControllerListener;

    instance-of v0, v0, Lcom/facebook/drawee/controller/AbstractDraweeController$InternalForwardingListener;

    if-eqz v0, :cond_0

    .line 254
    iget-object v0, p0, Lcom/facebook/drawee/controller/AbstractDraweeController;->mControllerListener:Lcom/facebook/drawee/controller/ControllerListener;

    check-cast v0, Lcom/facebook/drawee/controller/AbstractDraweeController$InternalForwardingListener;

    invoke-virtual {v0, p1}, Lcom/facebook/drawee/controller/AbstractDraweeController$InternalForwardingListener;->addListener(Lcom/facebook/drawee/controller/ControllerListener;)V

    .line 266
    :goto_0
    return-void

    .line 257
    :cond_0
    iget-object v0, p0, Lcom/facebook/drawee/controller/AbstractDraweeController;->mControllerListener:Lcom/facebook/drawee/controller/ControllerListener;

    if-eqz v0, :cond_1

    .line 258
    iget-object v0, p0, Lcom/facebook/drawee/controller/AbstractDraweeController;->mControllerListener:Lcom/facebook/drawee/controller/ControllerListener;

    invoke-static {v0, p1}, Lcom/facebook/drawee/controller/AbstractDraweeController$InternalForwardingListener;->createInternal(Lcom/facebook/drawee/controller/ControllerListener;Lcom/facebook/drawee/controller/ControllerListener;)Lcom/facebook/drawee/controller/AbstractDraweeController$InternalForwardingListener;

    move-result-object v0

    iput-object v0, p0, Lcom/facebook/drawee/controller/AbstractDraweeController;->mControllerListener:Lcom/facebook/drawee/controller/ControllerListener;

    goto :goto_0

    .line 265
    :cond_1
    iput-object p1, p0, Lcom/facebook/drawee/controller/AbstractDraweeController;->mControllerListener:Lcom/facebook/drawee/controller/ControllerListener;

    goto :goto_0
.end method

.method protected abstract createDrawable(Ljava/lang/Object;)Landroid/graphics/drawable/Drawable;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(TT;)",
            "Landroid/graphics/drawable/Drawable;"
        }
    .end annotation
.end method

.method public getAnimatable()Landroid/graphics/drawable/Animatable;
    .locals 1
    .annotation runtime Ljavax/annotation/Nullable;
    .end annotation

    .prologue
    .line 632
    .local p0, "this":Lcom/facebook/drawee/controller/AbstractDraweeController;, "Lcom/facebook/drawee/controller/AbstractDraweeController<TT;TINFO;>;"
    iget-object v0, p0, Lcom/facebook/drawee/controller/AbstractDraweeController;->mDrawable:Landroid/graphics/drawable/Drawable;

    instance-of v0, v0, Landroid/graphics/drawable/Animatable;

    if-eqz v0, :cond_0

    iget-object v0, p0, Lcom/facebook/drawee/controller/AbstractDraweeController;->mDrawable:Landroid/graphics/drawable/Drawable;

    check-cast v0, Landroid/graphics/drawable/Animatable;

    :goto_0
    return-object v0

    :cond_0
    const/4 v0, 0x0

    goto :goto_0
.end method

.method protected getCachedImage()Ljava/lang/Object;
    .locals 1
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()TT;"
        }
    .end annotation

    .prologue
    .line 665
    .local p0, "this":Lcom/facebook/drawee/controller/AbstractDraweeController;, "Lcom/facebook/drawee/controller/AbstractDraweeController<TT;TINFO;>;"
    const/4 v0, 0x0

    return-object v0
.end method

.method public getCallerContext()Ljava/lang/Object;
    .locals 1

    .prologue
    .line 207
    .local p0, "this":Lcom/facebook/drawee/controller/AbstractDraweeController;, "Lcom/facebook/drawee/controller/AbstractDraweeController<TT;TINFO;>;"
    iget-object v0, p0, Lcom/facebook/drawee/controller/AbstractDraweeController;->mCallerContext:Ljava/lang/Object;

    return-object v0
.end method

.method public getContentDescription()Ljava/lang/String;
    .locals 1
    .annotation runtime Ljavax/annotation/Nullable;
    .end annotation

    .prologue
    .line 241
    .local p0, "this":Lcom/facebook/drawee/controller/AbstractDraweeController;, "Lcom/facebook/drawee/controller/AbstractDraweeController<TT;TINFO;>;"
    iget-object v0, p0, Lcom/facebook/drawee/controller/AbstractDraweeController;->mContentDescription:Ljava/lang/String;

    return-object v0
.end method

.method protected getControllerListener()Lcom/facebook/drawee/controller/ControllerListener;
    .locals 1
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()",
            "Lcom/facebook/drawee/controller/ControllerListener",
            "<TINFO;>;"
        }
    .end annotation

    .prologue
    .line 282
    .local p0, "this":Lcom/facebook/drawee/controller/AbstractDraweeController;, "Lcom/facebook/drawee/controller/AbstractDraweeController<TT;TINFO;>;"
    iget-object v0, p0, Lcom/facebook/drawee/controller/AbstractDraweeController;->mControllerListener:Lcom/facebook/drawee/controller/ControllerListener;

    if-nez v0, :cond_0

    .line 283
    invoke-static {}, Lcom/facebook/drawee/controller/BaseControllerListener;->getNoOpListener()Lcom/facebook/drawee/controller/ControllerListener;

    move-result-object v0

    .line 285
    :goto_0
    return-object v0

    :cond_0
    iget-object v0, p0, Lcom/facebook/drawee/controller/AbstractDraweeController;->mControllerListener:Lcom/facebook/drawee/controller/ControllerListener;

    goto :goto_0
.end method

.method protected getControllerOverlay()Landroid/graphics/drawable/Drawable;
    .locals 1
    .annotation runtime Ljavax/annotation/Nullable;
    .end annotation

    .prologue
    .line 347
    .local p0, "this":Lcom/facebook/drawee/controller/AbstractDraweeController;, "Lcom/facebook/drawee/controller/AbstractDraweeController<TT;TINFO;>;"
    iget-object v0, p0, Lcom/facebook/drawee/controller/AbstractDraweeController;->mControllerOverlay:Landroid/graphics/drawable/Drawable;

    return-object v0
.end method

.method protected abstract getDataSource()Lcom/facebook/datasource/DataSource;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()",
            "Lcom/facebook/datasource/DataSource",
            "<TT;>;"
        }
    .end annotation
.end method

.method protected getGestureDetector()Lcom/facebook/drawee/gestures/GestureDetector;
    .locals 1
    .annotation runtime Ljavax/annotation/Nullable;
    .end annotation

    .prologue
    .line 222
    .local p0, "this":Lcom/facebook/drawee/controller/AbstractDraweeController;, "Lcom/facebook/drawee/controller/AbstractDraweeController<TT;TINFO;>;"
    iget-object v0, p0, Lcom/facebook/drawee/controller/AbstractDraweeController;->mGestureDetector:Lcom/facebook/drawee/gestures/GestureDetector;

    return-object v0
.end method

.method public getHierarchy()Lcom/facebook/drawee/interfaces/DraweeHierarchy;
    .locals 1
    .annotation runtime Ljavax/annotation/Nullable;
    .end annotation

    .prologue
    .line 298
    .local p0, "this":Lcom/facebook/drawee/controller/AbstractDraweeController;, "Lcom/facebook/drawee/controller/AbstractDraweeController<TT;TINFO;>;"
    iget-object v0, p0, Lcom/facebook/drawee/controller/AbstractDraweeController;->mSettableDraweeHierarchy:Lcom/facebook/drawee/interfaces/SettableDraweeHierarchy;

    return-object v0
.end method

.method public getId()Ljava/lang/String;
    .locals 1

    .prologue
    .line 202
    .local p0, "this":Lcom/facebook/drawee/controller/AbstractDraweeController;, "Lcom/facebook/drawee/controller/AbstractDraweeController<TT;TINFO;>;"
    iget-object v0, p0, Lcom/facebook/drawee/controller/AbstractDraweeController;->mId:Ljava/lang/String;

    return-object v0
.end method

.method protected getImageClass(Ljava/lang/Object;)Ljava/lang/String;
    .locals 1
    .param p1    # Ljava/lang/Object;
        .annotation runtime Ljavax/annotation/Nullable;
        .end annotation
    .end param
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(TT;)",
            "Ljava/lang/String;"
        }
    .end annotation

    .prologue
    .line 642
    .local p0, "this":Lcom/facebook/drawee/controller/AbstractDraweeController;, "Lcom/facebook/drawee/controller/AbstractDraweeController<TT;TINFO;>;"
    .local p1, "image":Ljava/lang/Object;, "TT;"
    if-eqz p1, :cond_0

    invoke-virtual {p1}, Ljava/lang/Object;->getClass()Ljava/lang/Class;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/Class;->getSimpleName()Ljava/lang/String;

    move-result-object v0

    :goto_0
    return-object v0

    :cond_0
    const-string v0, "<null>"

    goto :goto_0
.end method

.method protected getImageHash(Ljava/lang/Object;)I
    .locals 1
    .param p1    # Ljava/lang/Object;
        .annotation runtime Ljavax/annotation/Nullable;
        .end annotation
    .end param
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(TT;)I"
        }
    .end annotation

    .prologue
    .line 646
    .local p0, "this":Lcom/facebook/drawee/controller/AbstractDraweeController;, "Lcom/facebook/drawee/controller/AbstractDraweeController<TT;TINFO;>;"
    .local p1, "image":Ljava/lang/Object;, "TT;"
    invoke-static {p1}, Ljava/lang/System;->identityHashCode(Ljava/lang/Object;)I

    move-result v0

    return v0
.end method

.method protected abstract getImageInfo(Ljava/lang/Object;)Ljava/lang/Object;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(TT;)TINFO;"
        }
    .end annotation

    .annotation runtime Ljavax/annotation/Nullable;
    .end annotation
.end method

.method protected getRetryManager()Lcom/facebook/drawee/components/RetryManager;
    .locals 1
    .annotation runtime Ljavax/annotation/Nullable;
    .end annotation

    .prologue
    .line 212
    .local p0, "this":Lcom/facebook/drawee/controller/AbstractDraweeController;, "Lcom/facebook/drawee/controller/AbstractDraweeController<TT;TINFO;>;"
    iget-object v0, p0, Lcom/facebook/drawee/controller/AbstractDraweeController;->mRetryManager:Lcom/facebook/drawee/components/RetryManager;

    return-object v0
.end method

.method protected initialize(Ljava/lang/String;Ljava/lang/Object;)V
    .locals 1
    .param p1, "id"    # Ljava/lang/String;
    .param p2, "callerContext"    # Ljava/lang/Object;

    .prologue
    .line 117
    .local p0, "this":Lcom/facebook/drawee/controller/AbstractDraweeController;, "Lcom/facebook/drawee/controller/AbstractDraweeController<TT;TINFO;>;"
    const/4 v0, 0x0

    invoke-direct {p0, p1, p2, v0}, Lcom/facebook/drawee/controller/AbstractDraweeController;->init(Ljava/lang/String;Ljava/lang/Object;Z)V

    .line 118
    return-void
.end method

.method public onAttach()V
    .locals 5

    .prologue
    .line 352
    .local p0, "this":Lcom/facebook/drawee/controller/AbstractDraweeController;, "Lcom/facebook/drawee/controller/AbstractDraweeController<TT;TINFO;>;"
    const/4 v0, 0x2

    invoke-static {v0}, Lcom/facebook/common/logging/FLog;->isLoggable(I)Z

    move-result v0

    if-eqz v0, :cond_0

    .line 353
    sget-object v1, Lcom/facebook/drawee/controller/AbstractDraweeController;->TAG:Ljava/lang/Class;

    const-string v2, "controller %x %s: onAttach: %s"

    .line 356
    invoke-static {p0}, Ljava/lang/System;->identityHashCode(Ljava/lang/Object;)I

    move-result v0

    invoke-static {v0}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v3

    iget-object v4, p0, Lcom/facebook/drawee/controller/AbstractDraweeController;->mId:Ljava/lang/String;

    iget-boolean v0, p0, Lcom/facebook/drawee/controller/AbstractDraweeController;->mIsRequestSubmitted:Z

    if-eqz v0, :cond_2

    const-string v0, "request already submitted"

    .line 353
    :goto_0
    invoke-static {v1, v2, v3, v4, v0}, Lcom/facebook/common/logging/FLog;->v(Ljava/lang/Class;Ljava/lang/String;Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;)V

    .line 360
    :cond_0
    iget-object v0, p0, Lcom/facebook/drawee/controller/AbstractDraweeController;->mEventTracker:Lcom/facebook/drawee/components/DraweeEventTracker;

    sget-object v1, Lcom/facebook/drawee/components/DraweeEventTracker$Event;->ON_ATTACH_CONTROLLER:Lcom/facebook/drawee/components/DraweeEventTracker$Event;

    invoke-virtual {v0, v1}, Lcom/facebook/drawee/components/DraweeEventTracker;->recordEvent(Lcom/facebook/drawee/components/DraweeEventTracker$Event;)V

    .line 361
    iget-object v0, p0, Lcom/facebook/drawee/controller/AbstractDraweeController;->mSettableDraweeHierarchy:Lcom/facebook/drawee/interfaces/SettableDraweeHierarchy;

    invoke-static {v0}, Lcom/facebook/common/internal/Preconditions;->checkNotNull(Ljava/lang/Object;)Ljava/lang/Object;

    .line 362
    iget-object v0, p0, Lcom/facebook/drawee/controller/AbstractDraweeController;->mDeferredReleaser:Lcom/facebook/drawee/components/DeferredReleaser;

    invoke-virtual {v0, p0}, Lcom/facebook/drawee/components/DeferredReleaser;->cancelDeferredRelease(Lcom/facebook/drawee/components/DeferredReleaser$Releasable;)V

    .line 363
    const/4 v0, 0x1

    iput-boolean v0, p0, Lcom/facebook/drawee/controller/AbstractDraweeController;->mIsAttached:Z

    .line 364
    iget-boolean v0, p0, Lcom/facebook/drawee/controller/AbstractDraweeController;->mIsRequestSubmitted:Z

    if-nez v0, :cond_1

    .line 365
    invoke-virtual {p0}, Lcom/facebook/drawee/controller/AbstractDraweeController;->submitRequest()V

    .line 367
    :cond_1
    return-void

    .line 356
    :cond_2
    const-string v0, "request needs submit"

    goto :goto_0
.end method

.method public onClick()Z
    .locals 4

    .prologue
    .line 420
    .local p0, "this":Lcom/facebook/drawee/controller/AbstractDraweeController;, "Lcom/facebook/drawee/controller/AbstractDraweeController<TT;TINFO;>;"
    const/4 v0, 0x2

    invoke-static {v0}, Lcom/facebook/common/logging/FLog;->isLoggable(I)Z

    move-result v0

    if-eqz v0, :cond_0

    .line 421
    sget-object v0, Lcom/facebook/drawee/controller/AbstractDraweeController;->TAG:Ljava/lang/Class;

    const-string v1, "controller %x %s: onClick"

    invoke-static {p0}, Ljava/lang/System;->identityHashCode(Ljava/lang/Object;)I

    move-result v2

    invoke-static {v2}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v2

    iget-object v3, p0, Lcom/facebook/drawee/controller/AbstractDraweeController;->mId:Ljava/lang/String;

    invoke-static {v0, v1, v2, v3}, Lcom/facebook/common/logging/FLog;->v(Ljava/lang/Class;Ljava/lang/String;Ljava/lang/Object;Ljava/lang/Object;)V

    .line 423
    :cond_0
    invoke-direct {p0}, Lcom/facebook/drawee/controller/AbstractDraweeController;->shouldRetryOnTap()Z

    move-result v0

    if-eqz v0, :cond_1

    .line 424
    iget-object v0, p0, Lcom/facebook/drawee/controller/AbstractDraweeController;->mRetryManager:Lcom/facebook/drawee/components/RetryManager;

    invoke-virtual {v0}, Lcom/facebook/drawee/components/RetryManager;->notifyTapToRetry()V

    .line 425
    iget-object v0, p0, Lcom/facebook/drawee/controller/AbstractDraweeController;->mSettableDraweeHierarchy:Lcom/facebook/drawee/interfaces/SettableDraweeHierarchy;

    invoke-interface {v0}, Lcom/facebook/drawee/interfaces/SettableDraweeHierarchy;->reset()V

    .line 426
    invoke-virtual {p0}, Lcom/facebook/drawee/controller/AbstractDraweeController;->submitRequest()V

    .line 427
    const/4 v0, 0x1

    .line 429
    :goto_0
    return v0

    :cond_1
    const/4 v0, 0x0

    goto :goto_0
.end method

.method public onDetach()V
    .locals 4

    .prologue
    .line 371
    .local p0, "this":Lcom/facebook/drawee/controller/AbstractDraweeController;, "Lcom/facebook/drawee/controller/AbstractDraweeController<TT;TINFO;>;"
    const/4 v0, 0x2

    invoke-static {v0}, Lcom/facebook/common/logging/FLog;->isLoggable(I)Z

    move-result v0

    if-eqz v0, :cond_0

    .line 372
    sget-object v0, Lcom/facebook/drawee/controller/AbstractDraweeController;->TAG:Ljava/lang/Class;

    const-string v1, "controller %x %s: onDetach"

    invoke-static {p0}, Ljava/lang/System;->identityHashCode(Ljava/lang/Object;)I

    move-result v2

    invoke-static {v2}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v2

    iget-object v3, p0, Lcom/facebook/drawee/controller/AbstractDraweeController;->mId:Ljava/lang/String;

    invoke-static {v0, v1, v2, v3}, Lcom/facebook/common/logging/FLog;->v(Ljava/lang/Class;Ljava/lang/String;Ljava/lang/Object;Ljava/lang/Object;)V

    .line 374
    :cond_0
    iget-object v0, p0, Lcom/facebook/drawee/controller/AbstractDraweeController;->mEventTracker:Lcom/facebook/drawee/components/DraweeEventTracker;

    sget-object v1, Lcom/facebook/drawee/components/DraweeEventTracker$Event;->ON_DETACH_CONTROLLER:Lcom/facebook/drawee/components/DraweeEventTracker$Event;

    invoke-virtual {v0, v1}, Lcom/facebook/drawee/components/DraweeEventTracker;->recordEvent(Lcom/facebook/drawee/components/DraweeEventTracker$Event;)V

    .line 375
    const/4 v0, 0x0

    iput-boolean v0, p0, Lcom/facebook/drawee/controller/AbstractDraweeController;->mIsAttached:Z

    .line 376
    iget-object v0, p0, Lcom/facebook/drawee/controller/AbstractDraweeController;->mDeferredReleaser:Lcom/facebook/drawee/components/DeferredReleaser;

    invoke-virtual {v0, p0}, Lcom/facebook/drawee/components/DeferredReleaser;->scheduleDeferredRelease(Lcom/facebook/drawee/components/DeferredReleaser$Releasable;)V

    .line 377
    return-void
.end method

.method public onTouchEvent(Landroid/view/MotionEvent;)Z
    .locals 5
    .param p1, "event"    # Landroid/view/MotionEvent;

    .prologue
    .local p0, "this":Lcom/facebook/drawee/controller/AbstractDraweeController;, "Lcom/facebook/drawee/controller/AbstractDraweeController<TT;TINFO;>;"
    const/4 v0, 0x0

    .line 394
    const/4 v1, 0x2

    invoke-static {v1}, Lcom/facebook/common/logging/FLog;->isLoggable(I)Z

    move-result v1

    if-eqz v1, :cond_0

    .line 395
    sget-object v1, Lcom/facebook/drawee/controller/AbstractDraweeController;->TAG:Ljava/lang/Class;

    const-string v2, "controller %x %s: onTouchEvent %s"

    invoke-static {p0}, Ljava/lang/System;->identityHashCode(Ljava/lang/Object;)I

    move-result v3

    invoke-static {v3}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v3

    iget-object v4, p0, Lcom/facebook/drawee/controller/AbstractDraweeController;->mId:Ljava/lang/String;

    invoke-static {v1, v2, v3, v4, p1}, Lcom/facebook/common/logging/FLog;->v(Ljava/lang/Class;Ljava/lang/String;Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;)V

    .line 397
    :cond_0
    iget-object v1, p0, Lcom/facebook/drawee/controller/AbstractDraweeController;->mGestureDetector:Lcom/facebook/drawee/gestures/GestureDetector;

    if-nez v1, :cond_2

    .line 404
    :cond_1
    :goto_0
    return v0

    .line 400
    :cond_2
    iget-object v1, p0, Lcom/facebook/drawee/controller/AbstractDraweeController;->mGestureDetector:Lcom/facebook/drawee/gestures/GestureDetector;

    invoke-virtual {v1}, Lcom/facebook/drawee/gestures/GestureDetector;->isCapturingGesture()Z

    move-result v1

    if-nez v1, :cond_3

    invoke-virtual {p0}, Lcom/facebook/drawee/controller/AbstractDraweeController;->shouldHandleGesture()Z

    move-result v1

    if-eqz v1, :cond_1

    .line 401
    :cond_3
    iget-object v0, p0, Lcom/facebook/drawee/controller/AbstractDraweeController;->mGestureDetector:Lcom/facebook/drawee/gestures/GestureDetector;

    invoke-virtual {v0, p1}, Lcom/facebook/drawee/gestures/GestureDetector;->onTouchEvent(Landroid/view/MotionEvent;)Z

    .line 402
    const/4 v0, 0x1

    goto :goto_0
.end method

.method public onViewportVisibilityHint(Z)V
    .locals 2
    .param p1, "isVisibleInViewportHint"    # Z

    .prologue
    .line 381
    .local p0, "this":Lcom/facebook/drawee/controller/AbstractDraweeController;, "Lcom/facebook/drawee/controller/AbstractDraweeController<TT;TINFO;>;"
    iget-object v0, p0, Lcom/facebook/drawee/controller/AbstractDraweeController;->mControllerViewportVisibilityListener:Lcom/facebook/drawee/controller/ControllerViewportVisibilityListener;

    .line 382
    .local v0, "listener":Lcom/facebook/drawee/controller/ControllerViewportVisibilityListener;
    if-eqz v0, :cond_0

    .line 383
    if-eqz p1, :cond_1

    iget-boolean v1, p0, Lcom/facebook/drawee/controller/AbstractDraweeController;->mIsVisibleInViewportHint:Z

    if-nez v1, :cond_1

    .line 384
    iget-object v1, p0, Lcom/facebook/drawee/controller/AbstractDraweeController;->mId:Ljava/lang/String;

    invoke-interface {v0, v1}, Lcom/facebook/drawee/controller/ControllerViewportVisibilityListener;->onDraweeViewportEntry(Ljava/lang/String;)V

    .line 389
    :cond_0
    :goto_0
    iput-boolean p1, p0, Lcom/facebook/drawee/controller/AbstractDraweeController;->mIsVisibleInViewportHint:Z

    .line 390
    return-void

    .line 385
    :cond_1
    if-nez p1, :cond_0

    iget-boolean v1, p0, Lcom/facebook/drawee/controller/AbstractDraweeController;->mIsVisibleInViewportHint:Z

    if-eqz v1, :cond_0

    .line 386
    iget-object v1, p0, Lcom/facebook/drawee/controller/AbstractDraweeController;->mId:Ljava/lang/String;

    invoke-interface {v0, v1}, Lcom/facebook/drawee/controller/ControllerViewportVisibilityListener;->onDraweeViewportExit(Ljava/lang/String;)V

    goto :goto_0
.end method

.method public release()V
    .locals 2

    .prologue
    .line 162
    .local p0, "this":Lcom/facebook/drawee/controller/AbstractDraweeController;, "Lcom/facebook/drawee/controller/AbstractDraweeController<TT;TINFO;>;"
    iget-object v0, p0, Lcom/facebook/drawee/controller/AbstractDraweeController;->mEventTracker:Lcom/facebook/drawee/components/DraweeEventTracker;

    sget-object v1, Lcom/facebook/drawee/components/DraweeEventTracker$Event;->ON_RELEASE_CONTROLLER:Lcom/facebook/drawee/components/DraweeEventTracker$Event;

    invoke-virtual {v0, v1}, Lcom/facebook/drawee/components/DraweeEventTracker;->recordEvent(Lcom/facebook/drawee/components/DraweeEventTracker$Event;)V

    .line 163
    iget-object v0, p0, Lcom/facebook/drawee/controller/AbstractDraweeController;->mRetryManager:Lcom/facebook/drawee/components/RetryManager;

    if-eqz v0, :cond_0

    .line 164
    iget-object v0, p0, Lcom/facebook/drawee/controller/AbstractDraweeController;->mRetryManager:Lcom/facebook/drawee/components/RetryManager;

    invoke-virtual {v0}, Lcom/facebook/drawee/components/RetryManager;->reset()V

    .line 166
    :cond_0
    iget-object v0, p0, Lcom/facebook/drawee/controller/AbstractDraweeController;->mGestureDetector:Lcom/facebook/drawee/gestures/GestureDetector;

    if-eqz v0, :cond_1

    .line 167
    iget-object v0, p0, Lcom/facebook/drawee/controller/AbstractDraweeController;->mGestureDetector:Lcom/facebook/drawee/gestures/GestureDetector;

    invoke-virtual {v0}, Lcom/facebook/drawee/gestures/GestureDetector;->reset()V

    .line 169
    :cond_1
    iget-object v0, p0, Lcom/facebook/drawee/controller/AbstractDraweeController;->mSettableDraweeHierarchy:Lcom/facebook/drawee/interfaces/SettableDraweeHierarchy;

    if-eqz v0, :cond_2

    .line 170
    iget-object v0, p0, Lcom/facebook/drawee/controller/AbstractDraweeController;->mSettableDraweeHierarchy:Lcom/facebook/drawee/interfaces/SettableDraweeHierarchy;

    invoke-interface {v0}, Lcom/facebook/drawee/interfaces/SettableDraweeHierarchy;->reset()V

    .line 172
    :cond_2
    invoke-direct {p0}, Lcom/facebook/drawee/controller/AbstractDraweeController;->releaseFetch()V

    .line 173
    return-void
.end method

.method protected abstract releaseDrawable(Landroid/graphics/drawable/Drawable;)V
    .param p1    # Landroid/graphics/drawable/Drawable;
        .annotation runtime Ljavax/annotation/Nullable;
        .end annotation
    .end param
.end method

.method protected abstract releaseImage(Ljava/lang/Object;)V
    .param p1    # Ljava/lang/Object;
        .annotation runtime Ljavax/annotation/Nullable;
        .end annotation
    .end param
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(TT;)V"
        }
    .end annotation
.end method

.method public removeControllerListener(Lcom/facebook/drawee/controller/ControllerListener;)V
    .locals 1
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Lcom/facebook/drawee/controller/ControllerListener",
            "<-TINFO;>;)V"
        }
    .end annotation

    .prologue
    .line 270
    .local p0, "this":Lcom/facebook/drawee/controller/AbstractDraweeController;, "Lcom/facebook/drawee/controller/AbstractDraweeController<TT;TINFO;>;"
    .local p1, "controllerListener":Lcom/facebook/drawee/controller/ControllerListener;, "Lcom/facebook/drawee/controller/ControllerListener<-TINFO;>;"
    invoke-static {p1}, Lcom/facebook/common/internal/Preconditions;->checkNotNull(Ljava/lang/Object;)Ljava/lang/Object;

    .line 271
    iget-object v0, p0, Lcom/facebook/drawee/controller/AbstractDraweeController;->mControllerListener:Lcom/facebook/drawee/controller/ControllerListener;

    instance-of v0, v0, Lcom/facebook/drawee/controller/AbstractDraweeController$InternalForwardingListener;

    if-eqz v0, :cond_1

    .line 272
    iget-object v0, p0, Lcom/facebook/drawee/controller/AbstractDraweeController;->mControllerListener:Lcom/facebook/drawee/controller/ControllerListener;

    check-cast v0, Lcom/facebook/drawee/controller/AbstractDraweeController$InternalForwardingListener;

    invoke-virtual {v0, p1}, Lcom/facebook/drawee/controller/AbstractDraweeController$InternalForwardingListener;->removeListener(Lcom/facebook/drawee/controller/ControllerListener;)V

    .line 278
    :cond_0
    :goto_0
    return-void

    .line 275
    :cond_1
    iget-object v0, p0, Lcom/facebook/drawee/controller/AbstractDraweeController;->mControllerListener:Lcom/facebook/drawee/controller/ControllerListener;

    if-ne v0, p1, :cond_0

    .line 276
    const/4 v0, 0x0

    iput-object v0, p0, Lcom/facebook/drawee/controller/AbstractDraweeController;->mControllerListener:Lcom/facebook/drawee/controller/ControllerListener;

    goto :goto_0
.end method

.method public setContentDescription(Ljava/lang/String;)V
    .locals 0
    .param p1, "contentDescription"    # Ljava/lang/String;
        .annotation runtime Ljavax/annotation/Nullable;
        .end annotation
    .end param

    .prologue
    .line 247
    .local p0, "this":Lcom/facebook/drawee/controller/AbstractDraweeController;, "Lcom/facebook/drawee/controller/AbstractDraweeController<TT;TINFO;>;"
    iput-object p1, p0, Lcom/facebook/drawee/controller/AbstractDraweeController;->mContentDescription:Ljava/lang/String;

    .line 248
    return-void
.end method

.method protected setControllerOverlay(Landroid/graphics/drawable/Drawable;)V
    .locals 2
    .param p1, "controllerOverlay"    # Landroid/graphics/drawable/Drawable;
        .annotation runtime Ljavax/annotation/Nullable;
        .end annotation
    .end param

    .prologue
    .line 339
    .local p0, "this":Lcom/facebook/drawee/controller/AbstractDraweeController;, "Lcom/facebook/drawee/controller/AbstractDraweeController<TT;TINFO;>;"
    iput-object p1, p0, Lcom/facebook/drawee/controller/AbstractDraweeController;->mControllerOverlay:Landroid/graphics/drawable/Drawable;

    .line 340
    iget-object v0, p0, Lcom/facebook/drawee/controller/AbstractDraweeController;->mSettableDraweeHierarchy:Lcom/facebook/drawee/interfaces/SettableDraweeHierarchy;

    if-eqz v0, :cond_0

    .line 341
    iget-object v0, p0, Lcom/facebook/drawee/controller/AbstractDraweeController;->mSettableDraweeHierarchy:Lcom/facebook/drawee/interfaces/SettableDraweeHierarchy;

    iget-object v1, p0, Lcom/facebook/drawee/controller/AbstractDraweeController;->mControllerOverlay:Landroid/graphics/drawable/Drawable;

    invoke-interface {v0, v1}, Lcom/facebook/drawee/interfaces/SettableDraweeHierarchy;->setControllerOverlay(Landroid/graphics/drawable/Drawable;)V

    .line 343
    :cond_0
    return-void
.end method

.method public setControllerViewportVisibilityListener(Lcom/facebook/drawee/controller/ControllerViewportVisibilityListener;)V
    .locals 0
    .param p1, "controllerViewportVisibilityListener"    # Lcom/facebook/drawee/controller/ControllerViewportVisibilityListener;
        .annotation runtime Ljavax/annotation/Nullable;
        .end annotation
    .end param

    .prologue
    .line 291
    .local p0, "this":Lcom/facebook/drawee/controller/AbstractDraweeController;, "Lcom/facebook/drawee/controller/AbstractDraweeController<TT;TINFO;>;"
    iput-object p1, p0, Lcom/facebook/drawee/controller/AbstractDraweeController;->mControllerViewportVisibilityListener:Lcom/facebook/drawee/controller/ControllerViewportVisibilityListener;

    .line 292
    return-void
.end method

.method protected setGestureDetector(Lcom/facebook/drawee/gestures/GestureDetector;)V
    .locals 1
    .param p1, "gestureDetector"    # Lcom/facebook/drawee/gestures/GestureDetector;
        .annotation runtime Ljavax/annotation/Nullable;
        .end annotation
    .end param

    .prologue
    .line 227
    .local p0, "this":Lcom/facebook/drawee/controller/AbstractDraweeController;, "Lcom/facebook/drawee/controller/AbstractDraweeController<TT;TINFO;>;"
    iput-object p1, p0, Lcom/facebook/drawee/controller/AbstractDraweeController;->mGestureDetector:Lcom/facebook/drawee/gestures/GestureDetector;

    .line 228
    iget-object v0, p0, Lcom/facebook/drawee/controller/AbstractDraweeController;->mGestureDetector:Lcom/facebook/drawee/gestures/GestureDetector;

    if-eqz v0, :cond_0

    .line 229
    iget-object v0, p0, Lcom/facebook/drawee/controller/AbstractDraweeController;->mGestureDetector:Lcom/facebook/drawee/gestures/GestureDetector;

    invoke-virtual {v0, p0}, Lcom/facebook/drawee/gestures/GestureDetector;->setClickListener(Lcom/facebook/drawee/gestures/GestureDetector$ClickListener;)V

    .line 231
    :cond_0
    return-void
.end method

.method public setHierarchy(Lcom/facebook/drawee/interfaces/DraweeHierarchy;)V
    .locals 5
    .param p1, "hierarchy"    # Lcom/facebook/drawee/interfaces/DraweeHierarchy;
        .annotation runtime Ljavax/annotation/Nullable;
        .end annotation
    .end param

    .prologue
    .local p0, "this":Lcom/facebook/drawee/controller/AbstractDraweeController;, "Lcom/facebook/drawee/controller/AbstractDraweeController<TT;TINFO;>;"
    const/4 v4, 0x0

    .line 309
    const/4 v0, 0x2

    invoke-static {v0}, Lcom/facebook/common/logging/FLog;->isLoggable(I)Z

    move-result v0

    if-eqz v0, :cond_0

    .line 310
    sget-object v0, Lcom/facebook/drawee/controller/AbstractDraweeController;->TAG:Ljava/lang/Class;

    const-string v1, "controller %x %s: setHierarchy: %s"

    .line 313
    invoke-static {p0}, Ljava/lang/System;->identityHashCode(Ljava/lang/Object;)I

    move-result v2

    invoke-static {v2}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v2

    iget-object v3, p0, Lcom/facebook/drawee/controller/AbstractDraweeController;->mId:Ljava/lang/String;

    .line 310
    invoke-static {v0, v1, v2, v3, p1}, Lcom/facebook/common/logging/FLog;->v(Ljava/lang/Class;Ljava/lang/String;Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;)V

    .line 317
    :cond_0
    iget-object v1, p0, Lcom/facebook/drawee/controller/AbstractDraweeController;->mEventTracker:Lcom/facebook/drawee/components/DraweeEventTracker;

    if-eqz p1, :cond_4

    sget-object v0, Lcom/facebook/drawee/components/DraweeEventTracker$Event;->ON_SET_HIERARCHY:Lcom/facebook/drawee/components/DraweeEventTracker$Event;

    :goto_0
    invoke-virtual {v1, v0}, Lcom/facebook/drawee/components/DraweeEventTracker;->recordEvent(Lcom/facebook/drawee/components/DraweeEventTracker$Event;)V

    .line 320
    iget-boolean v0, p0, Lcom/facebook/drawee/controller/AbstractDraweeController;->mIsRequestSubmitted:Z

    if-eqz v0, :cond_1

    .line 321
    iget-object v0, p0, Lcom/facebook/drawee/controller/AbstractDraweeController;->mDeferredReleaser:Lcom/facebook/drawee/components/DeferredReleaser;

    invoke-virtual {v0, p0}, Lcom/facebook/drawee/components/DeferredReleaser;->cancelDeferredRelease(Lcom/facebook/drawee/components/DeferredReleaser$Releasable;)V

    .line 322
    invoke-virtual {p0}, Lcom/facebook/drawee/controller/AbstractDraweeController;->release()V

    .line 325
    :cond_1
    iget-object v0, p0, Lcom/facebook/drawee/controller/AbstractDraweeController;->mSettableDraweeHierarchy:Lcom/facebook/drawee/interfaces/SettableDraweeHierarchy;

    if-eqz v0, :cond_2

    .line 326
    iget-object v0, p0, Lcom/facebook/drawee/controller/AbstractDraweeController;->mSettableDraweeHierarchy:Lcom/facebook/drawee/interfaces/SettableDraweeHierarchy;

    invoke-interface {v0, v4}, Lcom/facebook/drawee/interfaces/SettableDraweeHierarchy;->setControllerOverlay(Landroid/graphics/drawable/Drawable;)V

    .line 327
    iput-object v4, p0, Lcom/facebook/drawee/controller/AbstractDraweeController;->mSettableDraweeHierarchy:Lcom/facebook/drawee/interfaces/SettableDraweeHierarchy;

    .line 330
    :cond_2
    if-eqz p1, :cond_3

    .line 331
    instance-of v0, p1, Lcom/facebook/drawee/interfaces/SettableDraweeHierarchy;

    invoke-static {v0}, Lcom/facebook/common/internal/Preconditions;->checkArgument(Z)V

    .line 332
    check-cast p1, Lcom/facebook/drawee/interfaces/SettableDraweeHierarchy;

    .end local p1    # "hierarchy":Lcom/facebook/drawee/interfaces/DraweeHierarchy;
    iput-object p1, p0, Lcom/facebook/drawee/controller/AbstractDraweeController;->mSettableDraweeHierarchy:Lcom/facebook/drawee/interfaces/SettableDraweeHierarchy;

    .line 333
    iget-object v0, p0, Lcom/facebook/drawee/controller/AbstractDraweeController;->mSettableDraweeHierarchy:Lcom/facebook/drawee/interfaces/SettableDraweeHierarchy;

    iget-object v1, p0, Lcom/facebook/drawee/controller/AbstractDraweeController;->mControllerOverlay:Landroid/graphics/drawable/Drawable;

    invoke-interface {v0, v1}, Lcom/facebook/drawee/interfaces/SettableDraweeHierarchy;->setControllerOverlay(Landroid/graphics/drawable/Drawable;)V

    .line 335
    :cond_3
    return-void

    .line 317
    .restart local p1    # "hierarchy":Lcom/facebook/drawee/interfaces/DraweeHierarchy;
    :cond_4
    sget-object v0, Lcom/facebook/drawee/components/DraweeEventTracker$Event;->ON_CLEAR_HIERARCHY:Lcom/facebook/drawee/components/DraweeEventTracker$Event;

    goto :goto_0
.end method

.method protected setRetainImageOnFailure(Z)V
    .locals 0
    .param p1, "enabled"    # Z

    .prologue
    .line 235
    .local p0, "this":Lcom/facebook/drawee/controller/AbstractDraweeController;, "Lcom/facebook/drawee/controller/AbstractDraweeController<TT;TINFO;>;"
    iput-boolean p1, p0, Lcom/facebook/drawee/controller/AbstractDraweeController;->mRetainImageOnFailure:Z

    .line 236
    return-void
.end method

.method protected setRetryManager(Lcom/facebook/drawee/components/RetryManager;)V
    .locals 0
    .param p1, "retryManager"    # Lcom/facebook/drawee/components/RetryManager;
        .annotation runtime Ljavax/annotation/Nullable;
        .end annotation
    .end param

    .prologue
    .line 217
    .local p0, "this":Lcom/facebook/drawee/controller/AbstractDraweeController;, "Lcom/facebook/drawee/controller/AbstractDraweeController<TT;TINFO;>;"
    iput-object p1, p0, Lcom/facebook/drawee/controller/AbstractDraweeController;->mRetryManager:Lcom/facebook/drawee/components/RetryManager;

    .line 218
    return-void
.end method

.method protected shouldHandleGesture()Z
    .locals 1

    .prologue
    .line 409
    .local p0, "this":Lcom/facebook/drawee/controller/AbstractDraweeController;, "Lcom/facebook/drawee/controller/AbstractDraweeController<TT;TINFO;>;"
    invoke-direct {p0}, Lcom/facebook/drawee/controller/AbstractDraweeController;->shouldRetryOnTap()Z

    move-result v0

    return v0
.end method

.method protected submitRequest()V
    .locals 10

    .prologue
    .local p0, "this":Lcom/facebook/drawee/controller/AbstractDraweeController;, "Lcom/facebook/drawee/controller/AbstractDraweeController<TT;TINFO;>;"
    const/4 v4, 0x0

    const/4 v5, 0x1

    .line 433
    invoke-virtual {p0}, Lcom/facebook/drawee/controller/AbstractDraweeController;->getCachedImage()Ljava/lang/Object;

    move-result-object v3

    .line 434
    .local v3, "closeableImage":Ljava/lang/Object;, "TT;"
    if-eqz v3, :cond_0

    .line 435
    const/4 v0, 0x0

    iput-object v0, p0, Lcom/facebook/drawee/controller/AbstractDraweeController;->mDataSource:Lcom/facebook/datasource/DataSource;

    .line 436
    iput-boolean v5, p0, Lcom/facebook/drawee/controller/AbstractDraweeController;->mIsRequestSubmitted:Z

    .line 437
    iput-boolean v4, p0, Lcom/facebook/drawee/controller/AbstractDraweeController;->mHasFetchFailed:Z

    .line 438
    iget-object v0, p0, Lcom/facebook/drawee/controller/AbstractDraweeController;->mEventTracker:Lcom/facebook/drawee/components/DraweeEventTracker;

    sget-object v1, Lcom/facebook/drawee/components/DraweeEventTracker$Event;->ON_SUBMIT_CACHE_HIT:Lcom/facebook/drawee/components/DraweeEventTracker$Event;

    invoke-virtual {v0, v1}, Lcom/facebook/drawee/components/DraweeEventTracker;->recordEvent(Lcom/facebook/drawee/components/DraweeEventTracker$Event;)V

    .line 439
    invoke-virtual {p0}, Lcom/facebook/drawee/controller/AbstractDraweeController;->getControllerListener()Lcom/facebook/drawee/controller/ControllerListener;

    move-result-object v0

    iget-object v1, p0, Lcom/facebook/drawee/controller/AbstractDraweeController;->mId:Ljava/lang/String;

    iget-object v2, p0, Lcom/facebook/drawee/controller/AbstractDraweeController;->mCallerContext:Ljava/lang/Object;

    invoke-interface {v0, v1, v2}, Lcom/facebook/drawee/controller/ControllerListener;->onSubmit(Ljava/lang/String;Ljava/lang/Object;)V

    .line 440
    iget-object v1, p0, Lcom/facebook/drawee/controller/AbstractDraweeController;->mId:Ljava/lang/String;

    iget-object v2, p0, Lcom/facebook/drawee/controller/AbstractDraweeController;->mDataSource:Lcom/facebook/datasource/DataSource;

    const/high16 v4, 0x3f800000    # 1.0f

    move-object v0, p0

    move v6, v5

    invoke-direct/range {v0 .. v6}, Lcom/facebook/drawee/controller/AbstractDraweeController;->onNewResultInternal(Ljava/lang/String;Lcom/facebook/datasource/DataSource;Ljava/lang/Object;FZZ)V

    .line 486
    :goto_0
    return-void

    .line 443
    :cond_0
    iget-object v0, p0, Lcom/facebook/drawee/controller/AbstractDraweeController;->mEventTracker:Lcom/facebook/drawee/components/DraweeEventTracker;

    sget-object v1, Lcom/facebook/drawee/components/DraweeEventTracker$Event;->ON_DATASOURCE_SUBMIT:Lcom/facebook/drawee/components/DraweeEventTracker$Event;

    invoke-virtual {v0, v1}, Lcom/facebook/drawee/components/DraweeEventTracker;->recordEvent(Lcom/facebook/drawee/components/DraweeEventTracker$Event;)V

    .line 444
    invoke-virtual {p0}, Lcom/facebook/drawee/controller/AbstractDraweeController;->getControllerListener()Lcom/facebook/drawee/controller/ControllerListener;

    move-result-object v0

    iget-object v1, p0, Lcom/facebook/drawee/controller/AbstractDraweeController;->mId:Ljava/lang/String;

    iget-object v2, p0, Lcom/facebook/drawee/controller/AbstractDraweeController;->mCallerContext:Ljava/lang/Object;

    invoke-interface {v0, v1, v2}, Lcom/facebook/drawee/controller/ControllerListener;->onSubmit(Ljava/lang/String;Ljava/lang/Object;)V

    .line 445
    iget-object v0, p0, Lcom/facebook/drawee/controller/AbstractDraweeController;->mSettableDraweeHierarchy:Lcom/facebook/drawee/interfaces/SettableDraweeHierarchy;

    const/4 v1, 0x0

    invoke-interface {v0, v1, v5}, Lcom/facebook/drawee/interfaces/SettableDraweeHierarchy;->setProgress(FZ)V

    .line 446
    iput-boolean v5, p0, Lcom/facebook/drawee/controller/AbstractDraweeController;->mIsRequestSubmitted:Z

    .line 447
    iput-boolean v4, p0, Lcom/facebook/drawee/controller/AbstractDraweeController;->mHasFetchFailed:Z

    .line 448
    invoke-virtual {p0}, Lcom/facebook/drawee/controller/AbstractDraweeController;->getDataSource()Lcom/facebook/datasource/DataSource;

    move-result-object v0

    iput-object v0, p0, Lcom/facebook/drawee/controller/AbstractDraweeController;->mDataSource:Lcom/facebook/datasource/DataSource;

    .line 449
    const/4 v0, 0x2

    invoke-static {v0}, Lcom/facebook/common/logging/FLog;->isLoggable(I)Z

    move-result v0

    if-eqz v0, :cond_1

    .line 450
    sget-object v0, Lcom/facebook/drawee/controller/AbstractDraweeController;->TAG:Ljava/lang/Class;

    const-string v1, "controller %x %s: submitRequest: dataSource: %x"

    .line 453
    invoke-static {p0}, Ljava/lang/System;->identityHashCode(Ljava/lang/Object;)I

    move-result v2

    invoke-static {v2}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v2

    iget-object v4, p0, Lcom/facebook/drawee/controller/AbstractDraweeController;->mId:Ljava/lang/String;

    iget-object v5, p0, Lcom/facebook/drawee/controller/AbstractDraweeController;->mDataSource:Lcom/facebook/datasource/DataSource;

    .line 455
    invoke-static {v5}, Ljava/lang/System;->identityHashCode(Ljava/lang/Object;)I

    move-result v5

    invoke-static {v5}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v5

    .line 450
    invoke-static {v0, v1, v2, v4, v5}, Lcom/facebook/common/logging/FLog;->v(Ljava/lang/Class;Ljava/lang/String;Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;)V

    .line 457
    :cond_1
    iget-object v8, p0, Lcom/facebook/drawee/controller/AbstractDraweeController;->mId:Ljava/lang/String;

    .line 458
    .local v8, "id":Ljava/lang/String;
    iget-object v0, p0, Lcom/facebook/drawee/controller/AbstractDraweeController;->mDataSource:Lcom/facebook/datasource/DataSource;

    invoke-interface {v0}, Lcom/facebook/datasource/DataSource;->hasResult()Z

    move-result v9

    .line 459
    .local v9, "wasImmediate":Z
    new-instance v7, Lcom/facebook/drawee/controller/AbstractDraweeController$1;

    invoke-direct {v7, p0, v8, v9}, Lcom/facebook/drawee/controller/AbstractDraweeController$1;-><init>(Lcom/facebook/drawee/controller/AbstractDraweeController;Ljava/lang/String;Z)V

    .line 485
    .local v7, "dataSubscriber":Lcom/facebook/datasource/DataSubscriber;, "Lcom/facebook/datasource/DataSubscriber<TT;>;"
    iget-object v0, p0, Lcom/facebook/drawee/controller/AbstractDraweeController;->mDataSource:Lcom/facebook/datasource/DataSource;

    iget-object v1, p0, Lcom/facebook/drawee/controller/AbstractDraweeController;->mUiThreadImmediateExecutor:Ljava/util/concurrent/Executor;

    invoke-interface {v0, v7, v1}, Lcom/facebook/datasource/DataSource;->subscribe(Lcom/facebook/datasource/DataSubscriber;Ljava/util/concurrent/Executor;)V

    goto :goto_0
.end method

.method public toString()Ljava/lang/String;
    .locals 3

    .prologue
    .line 655
    .local p0, "this":Lcom/facebook/drawee/controller/AbstractDraweeController;, "Lcom/facebook/drawee/controller/AbstractDraweeController<TT;TINFO;>;"
    invoke-static {p0}, Lcom/facebook/common/internal/Objects;->toStringHelper(Ljava/lang/Object;)Lcom/facebook/common/internal/Objects$ToStringHelper;

    move-result-object v0

    const-string v1, "isAttached"

    iget-boolean v2, p0, Lcom/facebook/drawee/controller/AbstractDraweeController;->mIsAttached:Z

    .line 656
    invoke-virtual {v0, v1, v2}, Lcom/facebook/common/internal/Objects$ToStringHelper;->add(Ljava/lang/String;Z)Lcom/facebook/common/internal/Objects$ToStringHelper;

    move-result-object v0

    const-string v1, "isRequestSubmitted"

    iget-boolean v2, p0, Lcom/facebook/drawee/controller/AbstractDraweeController;->mIsRequestSubmitted:Z

    .line 657
    invoke-virtual {v0, v1, v2}, Lcom/facebook/common/internal/Objects$ToStringHelper;->add(Ljava/lang/String;Z)Lcom/facebook/common/internal/Objects$ToStringHelper;

    move-result-object v0

    const-string v1, "hasFetchFailed"

    iget-boolean v2, p0, Lcom/facebook/drawee/controller/AbstractDraweeController;->mHasFetchFailed:Z

    .line 658
    invoke-virtual {v0, v1, v2}, Lcom/facebook/common/internal/Objects$ToStringHelper;->add(Ljava/lang/String;Z)Lcom/facebook/common/internal/Objects$ToStringHelper;

    move-result-object v0

    const-string v1, "fetchedImage"

    iget-object v2, p0, Lcom/facebook/drawee/controller/AbstractDraweeController;->mFetchedImage:Ljava/lang/Object;

    .line 659
    invoke-virtual {p0, v2}, Lcom/facebook/drawee/controller/AbstractDraweeController;->getImageHash(Ljava/lang/Object;)I

    move-result v2

    invoke-virtual {v0, v1, v2}, Lcom/facebook/common/internal/Objects$ToStringHelper;->add(Ljava/lang/String;I)Lcom/facebook/common/internal/Objects$ToStringHelper;

    move-result-object v0

    const-string v1, "events"

    iget-object v2, p0, Lcom/facebook/drawee/controller/AbstractDraweeController;->mEventTracker:Lcom/facebook/drawee/components/DraweeEventTracker;

    .line 660
    invoke-virtual {v2}, Lcom/facebook/drawee/components/DraweeEventTracker;->toString()Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v0, v1, v2}, Lcom/facebook/common/internal/Objects$ToStringHelper;->add(Ljava/lang/String;Ljava/lang/Object;)Lcom/facebook/common/internal/Objects$ToStringHelper;

    move-result-object v0

    .line 661
    invoke-virtual {v0}, Lcom/facebook/common/internal/Objects$ToStringHelper;->toString()Ljava/lang/String;

    move-result-object v0

    return-object v0
.end method

.class public Lcom/facebook/react/modules/core/ReactChoreographer;
.super Ljava/lang/Object;
.source "ReactChoreographer.java"


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lcom/facebook/react/modules/core/ReactChoreographer$ReactChoreographerDispatcher;,
        Lcom/facebook/react/modules/core/ReactChoreographer$CallbackType;
    }
.end annotation


# static fields
.field private static sInstance:Lcom/facebook/react/modules/core/ReactChoreographer;


# instance fields
.field private final mCallbackQueues:[Ljava/util/ArrayDeque;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "[",
            "Ljava/util/ArrayDeque",
            "<",
            "Lcom/facebook/react/modules/core/ChoreographerCompat$FrameCallback;",
            ">;"
        }
    .end annotation
.end field

.field private final mChoreographer:Lcom/facebook/react/modules/core/ChoreographerCompat;

.field private mHasPostedCallback:Z

.field private final mReactChoreographerDispatcher:Lcom/facebook/react/modules/core/ReactChoreographer$ReactChoreographerDispatcher;

.field private mTotalCallbacks:I


# direct methods
.method private constructor <init>()V
    .locals 3

    .prologue
    const/4 v1, 0x0

    .line 87
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 84
    iput v1, p0, Lcom/facebook/react/modules/core/ReactChoreographer;->mTotalCallbacks:I

    .line 85
    iput-boolean v1, p0, Lcom/facebook/react/modules/core/ReactChoreographer;->mHasPostedCallback:Z

    .line 88
    invoke-static {}, Lcom/facebook/react/modules/core/ChoreographerCompat;->getInstance()Lcom/facebook/react/modules/core/ChoreographerCompat;

    move-result-object v1

    iput-object v1, p0, Lcom/facebook/react/modules/core/ReactChoreographer;->mChoreographer:Lcom/facebook/react/modules/core/ChoreographerCompat;

    .line 89
    new-instance v1, Lcom/facebook/react/modules/core/ReactChoreographer$ReactChoreographerDispatcher;

    const/4 v2, 0x0

    invoke-direct {v1, p0, v2}, Lcom/facebook/react/modules/core/ReactChoreographer$ReactChoreographerDispatcher;-><init>(Lcom/facebook/react/modules/core/ReactChoreographer;Lcom/facebook/react/modules/core/ReactChoreographer$1;)V

    iput-object v1, p0, Lcom/facebook/react/modules/core/ReactChoreographer;->mReactChoreographerDispatcher:Lcom/facebook/react/modules/core/ReactChoreographer$ReactChoreographerDispatcher;

    .line 90
    invoke-static {}, Lcom/facebook/react/modules/core/ReactChoreographer$CallbackType;->values()[Lcom/facebook/react/modules/core/ReactChoreographer$CallbackType;

    move-result-object v1

    array-length v1, v1

    new-array v1, v1, [Ljava/util/ArrayDeque;

    iput-object v1, p0, Lcom/facebook/react/modules/core/ReactChoreographer;->mCallbackQueues:[Ljava/util/ArrayDeque;

    .line 91
    const/4 v0, 0x0

    .local v0, "i":I
    :goto_0
    iget-object v1, p0, Lcom/facebook/react/modules/core/ReactChoreographer;->mCallbackQueues:[Ljava/util/ArrayDeque;

    array-length v1, v1

    if-ge v0, v1, :cond_0

    .line 92
    iget-object v1, p0, Lcom/facebook/react/modules/core/ReactChoreographer;->mCallbackQueues:[Ljava/util/ArrayDeque;

    new-instance v2, Ljava/util/ArrayDeque;

    invoke-direct {v2}, Ljava/util/ArrayDeque;-><init>()V

    aput-object v2, v1, v0

    .line 91
    add-int/lit8 v0, v0, 0x1

    goto :goto_0

    .line 94
    :cond_0
    return-void
.end method

.method static synthetic access$102(Lcom/facebook/react/modules/core/ReactChoreographer;Z)Z
    .locals 0
    .param p0, "x0"    # Lcom/facebook/react/modules/core/ReactChoreographer;
    .param p1, "x1"    # Z

    .prologue
    .line 24
    iput-boolean p1, p0, Lcom/facebook/react/modules/core/ReactChoreographer;->mHasPostedCallback:Z

    return p1
.end method

.method static synthetic access$200(Lcom/facebook/react/modules/core/ReactChoreographer;)[Ljava/util/ArrayDeque;
    .locals 1
    .param p0, "x0"    # Lcom/facebook/react/modules/core/ReactChoreographer;

    .prologue
    .line 24
    iget-object v0, p0, Lcom/facebook/react/modules/core/ReactChoreographer;->mCallbackQueues:[Ljava/util/ArrayDeque;

    return-object v0
.end method

.method static synthetic access$310(Lcom/facebook/react/modules/core/ReactChoreographer;)I
    .locals 2
    .param p0, "x0"    # Lcom/facebook/react/modules/core/ReactChoreographer;

    .prologue
    .line 24
    iget v0, p0, Lcom/facebook/react/modules/core/ReactChoreographer;->mTotalCallbacks:I

    add-int/lit8 v1, v0, -0x1

    iput v1, p0, Lcom/facebook/react/modules/core/ReactChoreographer;->mTotalCallbacks:I

    return v0
.end method

.method static synthetic access$400(Lcom/facebook/react/modules/core/ReactChoreographer;)V
    .locals 0
    .param p0, "x0"    # Lcom/facebook/react/modules/core/ReactChoreographer;

    .prologue
    .line 24
    invoke-direct {p0}, Lcom/facebook/react/modules/core/ReactChoreographer;->maybeRemoveFrameCallback()V

    return-void
.end method

.method public static getInstance()Lcom/facebook/react/modules/core/ReactChoreographer;
    .locals 2

    .prologue
    .line 76
    sget-object v0, Lcom/facebook/react/modules/core/ReactChoreographer;->sInstance:Lcom/facebook/react/modules/core/ReactChoreographer;

    const-string v1, "ReactChoreographer needs to be initialized."

    invoke-static {v0, v1}, Lcom/facebook/infer/annotation/Assertions;->assertNotNull(Ljava/lang/Object;Ljava/lang/String;)Ljava/lang/Object;

    .line 77
    sget-object v0, Lcom/facebook/react/modules/core/ReactChoreographer;->sInstance:Lcom/facebook/react/modules/core/ReactChoreographer;

    return-object v0
.end method

.method public static initialize()V
    .locals 1

    .prologue
    .line 69
    sget-object v0, Lcom/facebook/react/modules/core/ReactChoreographer;->sInstance:Lcom/facebook/react/modules/core/ReactChoreographer;

    if-nez v0, :cond_0

    .line 70
    invoke-static {}, Lcom/facebook/react/bridge/UiThreadUtil;->assertOnUiThread()V

    .line 71
    new-instance v0, Lcom/facebook/react/modules/core/ReactChoreographer;

    invoke-direct {v0}, Lcom/facebook/react/modules/core/ReactChoreographer;-><init>()V

    sput-object v0, Lcom/facebook/react/modules/core/ReactChoreographer;->sInstance:Lcom/facebook/react/modules/core/ReactChoreographer;

    .line 73
    :cond_0
    return-void
.end method

.method private maybeRemoveFrameCallback()V
    .locals 3

    .prologue
    const/4 v1, 0x0

    .line 120
    iget v0, p0, Lcom/facebook/react/modules/core/ReactChoreographer;->mTotalCallbacks:I

    if-ltz v0, :cond_1

    const/4 v0, 0x1

    :goto_0
    invoke-static {v0}, Lcom/facebook/infer/annotation/Assertions;->assertCondition(Z)V

    .line 121
    iget v0, p0, Lcom/facebook/react/modules/core/ReactChoreographer;->mTotalCallbacks:I

    if-nez v0, :cond_0

    iget-boolean v0, p0, Lcom/facebook/react/modules/core/ReactChoreographer;->mHasPostedCallback:Z

    if-eqz v0, :cond_0

    .line 122
    iget-object v0, p0, Lcom/facebook/react/modules/core/ReactChoreographer;->mChoreographer:Lcom/facebook/react/modules/core/ChoreographerCompat;

    iget-object v2, p0, Lcom/facebook/react/modules/core/ReactChoreographer;->mReactChoreographerDispatcher:Lcom/facebook/react/modules/core/ReactChoreographer$ReactChoreographerDispatcher;

    invoke-virtual {v0, v2}, Lcom/facebook/react/modules/core/ChoreographerCompat;->removeFrameCallback(Lcom/facebook/react/modules/core/ChoreographerCompat$FrameCallback;)V

    .line 123
    iput-boolean v1, p0, Lcom/facebook/react/modules/core/ReactChoreographer;->mHasPostedCallback:Z

    .line 125
    :cond_0
    return-void

    :cond_1
    move v0, v1

    .line 120
    goto :goto_0
.end method


# virtual methods
.method public declared-synchronized postFrameCallback(Lcom/facebook/react/modules/core/ReactChoreographer$CallbackType;Lcom/facebook/react/modules/core/ChoreographerCompat$FrameCallback;)V
    .locals 3
    .param p1, "type"    # Lcom/facebook/react/modules/core/ReactChoreographer$CallbackType;
    .param p2, "frameCallback"    # Lcom/facebook/react/modules/core/ChoreographerCompat$FrameCallback;

    .prologue
    const/4 v0, 0x1

    .line 99
    monitor-enter p0

    :try_start_0
    iget-object v1, p0, Lcom/facebook/react/modules/core/ReactChoreographer;->mCallbackQueues:[Ljava/util/ArrayDeque;

    invoke-virtual {p1}, Lcom/facebook/react/modules/core/ReactChoreographer$CallbackType;->getOrder()I

    move-result v2

    aget-object v1, v1, v2

    invoke-virtual {v1, p2}, Ljava/util/ArrayDeque;->addLast(Ljava/lang/Object;)V

    .line 100
    iget v1, p0, Lcom/facebook/react/modules/core/ReactChoreographer;->mTotalCallbacks:I

    add-int/lit8 v1, v1, 0x1

    iput v1, p0, Lcom/facebook/react/modules/core/ReactChoreographer;->mTotalCallbacks:I

    .line 101
    iget v1, p0, Lcom/facebook/react/modules/core/ReactChoreographer;->mTotalCallbacks:I

    if-lez v1, :cond_1

    :goto_0
    invoke-static {v0}, Lcom/facebook/infer/annotation/Assertions;->assertCondition(Z)V

    .line 102
    iget-boolean v0, p0, Lcom/facebook/react/modules/core/ReactChoreographer;->mHasPostedCallback:Z

    if-nez v0, :cond_0

    .line 103
    iget-object v0, p0, Lcom/facebook/react/modules/core/ReactChoreographer;->mChoreographer:Lcom/facebook/react/modules/core/ChoreographerCompat;

    iget-object v1, p0, Lcom/facebook/react/modules/core/ReactChoreographer;->mReactChoreographerDispatcher:Lcom/facebook/react/modules/core/ReactChoreographer$ReactChoreographerDispatcher;

    invoke-virtual {v0, v1}, Lcom/facebook/react/modules/core/ChoreographerCompat;->postFrameCallback(Lcom/facebook/react/modules/core/ChoreographerCompat$FrameCallback;)V

    .line 104
    const/4 v0, 0x1

    iput-boolean v0, p0, Lcom/facebook/react/modules/core/ReactChoreographer;->mHasPostedCallback:Z
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    .line 106
    :cond_0
    monitor-exit p0

    return-void

    .line 101
    :cond_1
    const/4 v0, 0x0

    goto :goto_0

    .line 99
    :catchall_0
    move-exception v0

    monitor-exit p0

    throw v0
.end method

.method public declared-synchronized removeFrameCallback(Lcom/facebook/react/modules/core/ReactChoreographer$CallbackType;Lcom/facebook/react/modules/core/ChoreographerCompat$FrameCallback;)V
    .locals 2
    .param p1, "type"    # Lcom/facebook/react/modules/core/ReactChoreographer$CallbackType;
    .param p2, "frameCallback"    # Lcom/facebook/react/modules/core/ChoreographerCompat$FrameCallback;

    .prologue
    .line 111
    monitor-enter p0

    :try_start_0
    iget-object v0, p0, Lcom/facebook/react/modules/core/ReactChoreographer;->mCallbackQueues:[Ljava/util/ArrayDeque;

    invoke-virtual {p1}, Lcom/facebook/react/modules/core/ReactChoreographer$CallbackType;->getOrder()I

    move-result v1

    aget-object v0, v0, v1

    invoke-virtual {v0, p2}, Ljava/util/ArrayDeque;->removeFirstOccurrence(Ljava/lang/Object;)Z

    move-result v0

    if-eqz v0, :cond_0

    .line 112
    iget v0, p0, Lcom/facebook/react/modules/core/ReactChoreographer;->mTotalCallbacks:I

    add-int/lit8 v0, v0, -0x1

    iput v0, p0, Lcom/facebook/react/modules/core/ReactChoreographer;->mTotalCallbacks:I

    .line 113
    invoke-direct {p0}, Lcom/facebook/react/modules/core/ReactChoreographer;->maybeRemoveFrameCallback()V
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    .line 117
    :goto_0
    monitor-exit p0

    return-void

    .line 115
    :cond_0
    :try_start_1
    const-string v0, "ReactNative"

    const-string v1, "Tried to remove non-existent frame callback"

    invoke-static {v0, v1}, Lcom/facebook/common/logging/FLog;->e(Ljava/lang/String;Ljava/lang/String;)V
    :try_end_1
    .catchall {:try_start_1 .. :try_end_1} :catchall_0

    goto :goto_0

    .line 111
    :catchall_0
    move-exception v0

    monitor-exit p0

    throw v0
.end method

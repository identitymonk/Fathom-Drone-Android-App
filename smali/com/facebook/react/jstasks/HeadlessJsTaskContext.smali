.class public Lcom/facebook/react/jstasks/HeadlessJsTaskContext;
.super Ljava/lang/Object;
.source "HeadlessJsTaskContext.java"


# static fields
.field private static final INSTANCES:Ljava/util/WeakHashMap;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/WeakHashMap",
            "<",
            "Lcom/facebook/react/bridge/ReactContext;",
            "Lcom/facebook/react/jstasks/HeadlessJsTaskContext;",
            ">;"
        }
    .end annotation
.end field


# instance fields
.field private final mActiveTasks:Ljava/util/Set;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/Set",
            "<",
            "Ljava/lang/Integer;",
            ">;"
        }
    .end annotation
.end field

.field private final mHandler:Landroid/os/Handler;

.field private final mHeadlessJsTaskEventListeners:Ljava/util/Set;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/Set",
            "<",
            "Lcom/facebook/react/jstasks/HeadlessJsTaskEventListener;",
            ">;"
        }
    .end annotation
.end field

.field private final mLastTaskId:Ljava/util/concurrent/atomic/AtomicInteger;

.field private final mReactContext:Ljava/lang/ref/WeakReference;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/lang/ref/WeakReference",
            "<",
            "Lcom/facebook/react/bridge/ReactContext;",
            ">;"
        }
    .end annotation
.end field

.field private final mTaskTimeouts:Landroid/util/SparseArray;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Landroid/util/SparseArray",
            "<",
            "Ljava/lang/Runnable;",
            ">;"
        }
    .end annotation
.end field


# direct methods
.method static constructor <clinit>()V
    .locals 1

    .prologue
    .line 26
    new-instance v0, Ljava/util/WeakHashMap;

    invoke-direct {v0}, Ljava/util/WeakHashMap;-><init>()V

    sput-object v0, Lcom/facebook/react/jstasks/HeadlessJsTaskContext;->INSTANCES:Ljava/util/WeakHashMap;

    return-void
.end method

.method private constructor <init>(Lcom/facebook/react/bridge/ReactContext;)V
    .locals 2
    .param p1, "reactContext"    # Lcom/facebook/react/bridge/ReactContext;

    .prologue
    .line 53
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 46
    new-instance v0, Ljava/util/concurrent/CopyOnWriteArraySet;

    invoke-direct {v0}, Ljava/util/concurrent/CopyOnWriteArraySet;-><init>()V

    iput-object v0, p0, Lcom/facebook/react/jstasks/HeadlessJsTaskContext;->mHeadlessJsTaskEventListeners:Ljava/util/Set;

    .line 48
    new-instance v0, Ljava/util/concurrent/atomic/AtomicInteger;

    const/4 v1, 0x0

    invoke-direct {v0, v1}, Ljava/util/concurrent/atomic/AtomicInteger;-><init>(I)V

    iput-object v0, p0, Lcom/facebook/react/jstasks/HeadlessJsTaskContext;->mLastTaskId:Ljava/util/concurrent/atomic/AtomicInteger;

    .line 49
    new-instance v0, Landroid/os/Handler;

    invoke-direct {v0}, Landroid/os/Handler;-><init>()V

    iput-object v0, p0, Lcom/facebook/react/jstasks/HeadlessJsTaskContext;->mHandler:Landroid/os/Handler;

    .line 50
    new-instance v0, Ljava/util/concurrent/CopyOnWriteArraySet;

    invoke-direct {v0}, Ljava/util/concurrent/CopyOnWriteArraySet;-><init>()V

    iput-object v0, p0, Lcom/facebook/react/jstasks/HeadlessJsTaskContext;->mActiveTasks:Ljava/util/Set;

    .line 51
    new-instance v0, Landroid/util/SparseArray;

    invoke-direct {v0}, Landroid/util/SparseArray;-><init>()V

    iput-object v0, p0, Lcom/facebook/react/jstasks/HeadlessJsTaskContext;->mTaskTimeouts:Landroid/util/SparseArray;

    .line 54
    new-instance v0, Ljava/lang/ref/WeakReference;

    invoke-direct {v0, p1}, Ljava/lang/ref/WeakReference;-><init>(Ljava/lang/Object;)V

    iput-object v0, p0, Lcom/facebook/react/jstasks/HeadlessJsTaskContext;->mReactContext:Ljava/lang/ref/WeakReference;

    .line 55
    return-void
.end method

.method static synthetic access$000(Lcom/facebook/react/jstasks/HeadlessJsTaskContext;)Ljava/util/Set;
    .locals 1
    .param p0, "x0"    # Lcom/facebook/react/jstasks/HeadlessJsTaskContext;

    .prologue
    .line 24
    iget-object v0, p0, Lcom/facebook/react/jstasks/HeadlessJsTaskContext;->mHeadlessJsTaskEventListeners:Ljava/util/Set;

    return-object v0
.end method

.method public static getInstance(Lcom/facebook/react/bridge/ReactContext;)Lcom/facebook/react/jstasks/HeadlessJsTaskContext;
    .locals 2
    .param p0, "context"    # Lcom/facebook/react/bridge/ReactContext;

    .prologue
    .line 37
    sget-object v1, Lcom/facebook/react/jstasks/HeadlessJsTaskContext;->INSTANCES:Ljava/util/WeakHashMap;

    invoke-virtual {v1, p0}, Ljava/util/WeakHashMap;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/facebook/react/jstasks/HeadlessJsTaskContext;

    .line 38
    .local v0, "helper":Lcom/facebook/react/jstasks/HeadlessJsTaskContext;
    if-nez v0, :cond_0

    .line 39
    new-instance v0, Lcom/facebook/react/jstasks/HeadlessJsTaskContext;

    .end local v0    # "helper":Lcom/facebook/react/jstasks/HeadlessJsTaskContext;
    invoke-direct {v0, p0}, Lcom/facebook/react/jstasks/HeadlessJsTaskContext;-><init>(Lcom/facebook/react/bridge/ReactContext;)V

    .line 40
    .restart local v0    # "helper":Lcom/facebook/react/jstasks/HeadlessJsTaskContext;
    sget-object v1, Lcom/facebook/react/jstasks/HeadlessJsTaskContext;->INSTANCES:Ljava/util/WeakHashMap;

    invoke-virtual {v1, p0, v0}, Ljava/util/WeakHashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 42
    :cond_0
    return-object v0
.end method

.method private scheduleTaskTimeout(IJ)V
    .locals 2
    .param p1, "taskId"    # I
    .param p2, "timeout"    # J

    .prologue
    .line 142
    new-instance v0, Lcom/facebook/react/jstasks/HeadlessJsTaskContext$2;

    invoke-direct {v0, p0, p1}, Lcom/facebook/react/jstasks/HeadlessJsTaskContext$2;-><init>(Lcom/facebook/react/jstasks/HeadlessJsTaskContext;I)V

    .line 148
    .local v0, "runnable":Ljava/lang/Runnable;
    iget-object v1, p0, Lcom/facebook/react/jstasks/HeadlessJsTaskContext;->mTaskTimeouts:Landroid/util/SparseArray;

    invoke-virtual {v1, p1, v0}, Landroid/util/SparseArray;->append(ILjava/lang/Object;)V

    .line 149
    iget-object v1, p0, Lcom/facebook/react/jstasks/HeadlessJsTaskContext;->mHandler:Landroid/os/Handler;

    invoke-virtual {v1, v0, p2, p3}, Landroid/os/Handler;->postDelayed(Ljava/lang/Runnable;J)Z

    .line 150
    return-void
.end method


# virtual methods
.method public addTaskEventListener(Lcom/facebook/react/jstasks/HeadlessJsTaskEventListener;)V
    .locals 1
    .param p1, "listener"    # Lcom/facebook/react/jstasks/HeadlessJsTaskEventListener;

    .prologue
    .line 61
    iget-object v0, p0, Lcom/facebook/react/jstasks/HeadlessJsTaskContext;->mHeadlessJsTaskEventListeners:Ljava/util/Set;

    invoke-interface {v0, p1}, Ljava/util/Set;->add(Ljava/lang/Object;)Z

    .line 62
    return-void
.end method

.method public declared-synchronized finishTask(I)V
    .locals 4
    .param p1, "taskId"    # I

    .prologue
    .line 115
    monitor-enter p0

    :try_start_0
    iget-object v1, p0, Lcom/facebook/react/jstasks/HeadlessJsTaskContext;->mActiveTasks:Ljava/util/Set;

    .line 116
    invoke-static {p1}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v2

    invoke-interface {v1, v2}, Ljava/util/Set;->remove(Ljava/lang/Object;)Z

    move-result v1

    new-instance v2, Ljava/lang/StringBuilder;

    invoke-direct {v2}, Ljava/lang/StringBuilder;-><init>()V

    const-string v3, "Tried to finish non-existent task with id "

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2, p1}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v2

    const-string v3, "."

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v2

    .line 115
    invoke-static {v1, v2}, Lcom/facebook/infer/annotation/Assertions;->assertCondition(ZLjava/lang/String;)V

    .line 118
    iget-object v1, p0, Lcom/facebook/react/jstasks/HeadlessJsTaskContext;->mTaskTimeouts:Landroid/util/SparseArray;

    invoke-virtual {v1, p1}, Landroid/util/SparseArray;->get(I)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Ljava/lang/Runnable;

    .line 119
    .local v0, "timeout":Ljava/lang/Runnable;
    if-eqz v0, :cond_0

    .line 120
    iget-object v1, p0, Lcom/facebook/react/jstasks/HeadlessJsTaskContext;->mHandler:Landroid/os/Handler;

    invoke-virtual {v1, v0}, Landroid/os/Handler;->removeCallbacks(Ljava/lang/Runnable;)V

    .line 121
    iget-object v1, p0, Lcom/facebook/react/jstasks/HeadlessJsTaskContext;->mTaskTimeouts:Landroid/util/SparseArray;

    invoke-virtual {v1, p1}, Landroid/util/SparseArray;->remove(I)V

    .line 123
    :cond_0
    new-instance v1, Lcom/facebook/react/jstasks/HeadlessJsTaskContext$1;

    invoke-direct {v1, p0, p1}, Lcom/facebook/react/jstasks/HeadlessJsTaskContext$1;-><init>(Lcom/facebook/react/jstasks/HeadlessJsTaskContext;I)V

    invoke-static {v1}, Lcom/facebook/react/bridge/UiThreadUtil;->runOnUiThread(Ljava/lang/Runnable;)V
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    .line 131
    monitor-exit p0

    return-void

    .line 115
    .end local v0    # "timeout":Ljava/lang/Runnable;
    :catchall_0
    move-exception v1

    monitor-exit p0

    throw v1
.end method

.method public hasActiveTasks()Z
    .locals 1

    .prologue
    .line 75
    iget-object v0, p0, Lcom/facebook/react/jstasks/HeadlessJsTaskContext;->mActiveTasks:Ljava/util/Set;

    invoke-interface {v0}, Ljava/util/Set;->size()I

    move-result v0

    if-lez v0, :cond_0

    const/4 v0, 0x1

    :goto_0
    return v0

    :cond_0
    const/4 v0, 0x0

    goto :goto_0
.end method

.method public declared-synchronized isTaskRunning(I)Z
    .locals 2
    .param p1, "taskId"    # I

    .prologue
    .line 138
    monitor-enter p0

    :try_start_0
    iget-object v0, p0, Lcom/facebook/react/jstasks/HeadlessJsTaskContext;->mActiveTasks:Ljava/util/Set;

    invoke-static {p1}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v1

    invoke-interface {v0, v1}, Ljava/util/Set;->contains(Ljava/lang/Object;)Z
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    move-result v0

    monitor-exit p0

    return v0

    :catchall_0
    move-exception v0

    monitor-exit p0

    throw v0
.end method

.method public removeTaskEventListener(Lcom/facebook/react/jstasks/HeadlessJsTaskEventListener;)V
    .locals 1
    .param p1, "listener"    # Lcom/facebook/react/jstasks/HeadlessJsTaskEventListener;

    .prologue
    .line 68
    iget-object v0, p0, Lcom/facebook/react/jstasks/HeadlessJsTaskContext;->mHeadlessJsTaskEventListeners:Ljava/util/Set;

    invoke-interface {v0, p1}, Ljava/util/Set;->remove(Ljava/lang/Object;)Z

    .line 69
    return-void
.end method

.method public declared-synchronized startTask(Lcom/facebook/react/jstasks/HeadlessJsTaskConfig;)I
    .locals 8
    .param p1, "taskConfig"    # Lcom/facebook/react/jstasks/HeadlessJsTaskConfig;

    .prologue
    .line 85
    monitor-enter p0

    :try_start_0
    invoke-static {}, Lcom/facebook/react/bridge/UiThreadUtil;->assertOnUiThread()V

    .line 86
    iget-object v3, p0, Lcom/facebook/react/jstasks/HeadlessJsTaskContext;->mReactContext:Ljava/lang/ref/WeakReference;

    .line 87
    invoke-virtual {v3}, Ljava/lang/ref/WeakReference;->get()Ljava/lang/Object;

    move-result-object v3

    const-string v4, "Tried to start a task on a react context that has already been destroyed"

    .line 86
    invoke-static {v3, v4}, Lcom/facebook/infer/annotation/Assertions;->assertNotNull(Ljava/lang/Object;Ljava/lang/String;)Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Lcom/facebook/react/bridge/ReactContext;

    .line 89
    .local v1, "reactContext":Lcom/facebook/react/bridge/ReactContext;
    invoke-virtual {v1}, Lcom/facebook/react/bridge/ReactContext;->getLifecycleState()Lcom/facebook/react/common/LifecycleState;

    move-result-object v3

    sget-object v4, Lcom/facebook/react/common/LifecycleState;->RESUMED:Lcom/facebook/react/common/LifecycleState;

    if-ne v3, v4, :cond_0

    .line 90
    invoke-virtual {p1}, Lcom/facebook/react/jstasks/HeadlessJsTaskConfig;->isAllowedInForeground()Z

    move-result v3

    if-nez v3, :cond_0

    .line 91
    new-instance v3, Ljava/lang/IllegalStateException;

    new-instance v4, Ljava/lang/StringBuilder;

    invoke-direct {v4}, Ljava/lang/StringBuilder;-><init>()V

    const-string v5, "Tried to start task "

    invoke-virtual {v4, v5}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v4

    .line 92
    invoke-virtual {p1}, Lcom/facebook/react/jstasks/HeadlessJsTaskConfig;->getTaskKey()Ljava/lang/String;

    move-result-object v5

    invoke-virtual {v4, v5}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v4

    const-string v5, " while in foreground, but this is not allowed."

    invoke-virtual {v4, v5}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v4

    invoke-virtual {v4}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v4

    invoke-direct {v3, v4}, Ljava/lang/IllegalStateException;-><init>(Ljava/lang/String;)V

    throw v3
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    .line 85
    .end local v1    # "reactContext":Lcom/facebook/react/bridge/ReactContext;
    :catchall_0
    move-exception v3

    monitor-exit p0

    throw v3

    .line 95
    .restart local v1    # "reactContext":Lcom/facebook/react/bridge/ReactContext;
    :cond_0
    :try_start_1
    iget-object v3, p0, Lcom/facebook/react/jstasks/HeadlessJsTaskContext;->mLastTaskId:Ljava/util/concurrent/atomic/AtomicInteger;

    invoke-virtual {v3}, Ljava/util/concurrent/atomic/AtomicInteger;->incrementAndGet()I

    move-result v2

    .line 96
    .local v2, "taskId":I
    iget-object v3, p0, Lcom/facebook/react/jstasks/HeadlessJsTaskContext;->mActiveTasks:Ljava/util/Set;

    invoke-static {v2}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v4

    invoke-interface {v3, v4}, Ljava/util/Set;->add(Ljava/lang/Object;)Z

    .line 97
    const-class v3, Lcom/facebook/react/modules/appregistry/AppRegistry;

    invoke-virtual {v1, v3}, Lcom/facebook/react/bridge/ReactContext;->getJSModule(Ljava/lang/Class;)Lcom/facebook/react/bridge/JavaScriptModule;

    move-result-object v3

    check-cast v3, Lcom/facebook/react/modules/appregistry/AppRegistry;

    .line 98
    invoke-virtual {p1}, Lcom/facebook/react/jstasks/HeadlessJsTaskConfig;->getTaskKey()Ljava/lang/String;

    move-result-object v4

    invoke-virtual {p1}, Lcom/facebook/react/jstasks/HeadlessJsTaskConfig;->getData()Lcom/facebook/react/bridge/WritableMap;

    move-result-object v5

    invoke-interface {v3, v2, v4, v5}, Lcom/facebook/react/modules/appregistry/AppRegistry;->startHeadlessTask(ILjava/lang/String;Lcom/facebook/react/bridge/WritableMap;)V

    .line 99
    invoke-virtual {p1}, Lcom/facebook/react/jstasks/HeadlessJsTaskConfig;->getTimeout()J

    move-result-wide v4

    const-wide/16 v6, 0x0

    cmp-long v3, v4, v6

    if-lez v3, :cond_1

    .line 100
    invoke-virtual {p1}, Lcom/facebook/react/jstasks/HeadlessJsTaskConfig;->getTimeout()J

    move-result-wide v4

    invoke-direct {p0, v2, v4, v5}, Lcom/facebook/react/jstasks/HeadlessJsTaskContext;->scheduleTaskTimeout(IJ)V

    .line 102
    :cond_1
    iget-object v3, p0, Lcom/facebook/react/jstasks/HeadlessJsTaskContext;->mHeadlessJsTaskEventListeners:Ljava/util/Set;

    invoke-interface {v3}, Ljava/util/Set;->iterator()Ljava/util/Iterator;

    move-result-object v3

    :goto_0
    invoke-interface {v3}, Ljava/util/Iterator;->hasNext()Z

    move-result v4

    if-eqz v4, :cond_2

    invoke-interface {v3}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/facebook/react/jstasks/HeadlessJsTaskEventListener;

    .line 103
    .local v0, "listener":Lcom/facebook/react/jstasks/HeadlessJsTaskEventListener;
    invoke-interface {v0, v2}, Lcom/facebook/react/jstasks/HeadlessJsTaskEventListener;->onHeadlessJsTaskStart(I)V
    :try_end_1
    .catchall {:try_start_1 .. :try_end_1} :catchall_0

    goto :goto_0

    .line 105
    .end local v0    # "listener":Lcom/facebook/react/jstasks/HeadlessJsTaskEventListener;
    :cond_2
    monitor-exit p0

    return v2
.end method

.class Lcom/facebook/react/modules/core/Timing$TimerFrameCallback;
.super Lcom/facebook/react/modules/core/ChoreographerCompat$FrameCallback;
.source "Timing.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/facebook/react/modules/core/Timing;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x2
    name = "TimerFrameCallback"
.end annotation


# instance fields
.field private mTimersToCall:Lcom/facebook/react/bridge/WritableArray;
    .annotation runtime Ljavax/annotation/Nullable;
    .end annotation
.end field

.field final synthetic this$0:Lcom/facebook/react/modules/core/Timing;


# direct methods
.method private constructor <init>(Lcom/facebook/react/modules/core/Timing;)V
    .locals 1

    .prologue
    .line 70
    iput-object p1, p0, Lcom/facebook/react/modules/core/Timing$TimerFrameCallback;->this$0:Lcom/facebook/react/modules/core/Timing;

    invoke-direct {p0}, Lcom/facebook/react/modules/core/ChoreographerCompat$FrameCallback;-><init>()V

    .line 73
    const/4 v0, 0x0

    iput-object v0, p0, Lcom/facebook/react/modules/core/Timing$TimerFrameCallback;->mTimersToCall:Lcom/facebook/react/bridge/WritableArray;

    return-void
.end method

.method synthetic constructor <init>(Lcom/facebook/react/modules/core/Timing;Lcom/facebook/react/modules/core/Timing$1;)V
    .locals 0
    .param p1, "x0"    # Lcom/facebook/react/modules/core/Timing;
    .param p2, "x1"    # Lcom/facebook/react/modules/core/Timing$1;

    .prologue
    .line 70
    invoke-direct {p0, p1}, Lcom/facebook/react/modules/core/Timing$TimerFrameCallback;-><init>(Lcom/facebook/react/modules/core/Timing;)V

    return-void
.end method


# virtual methods
.method public doFrame(J)V
    .locals 9
    .param p1, "frameTimeNanos"    # J

    .prologue
    .line 80
    iget-object v3, p0, Lcom/facebook/react/modules/core/Timing$TimerFrameCallback;->this$0:Lcom/facebook/react/modules/core/Timing;

    invoke-static {v3}, Lcom/facebook/react/modules/core/Timing;->access$000(Lcom/facebook/react/modules/core/Timing;)Ljava/util/concurrent/atomic/AtomicBoolean;

    move-result-object v3

    invoke-virtual {v3}, Ljava/util/concurrent/atomic/AtomicBoolean;->get()Z

    move-result v3

    if-eqz v3, :cond_0

    iget-object v3, p0, Lcom/facebook/react/modules/core/Timing$TimerFrameCallback;->this$0:Lcom/facebook/react/modules/core/Timing;

    invoke-static {v3}, Lcom/facebook/react/modules/core/Timing;->access$100(Lcom/facebook/react/modules/core/Timing;)Ljava/util/concurrent/atomic/AtomicBoolean;

    move-result-object v3

    invoke-virtual {v3}, Ljava/util/concurrent/atomic/AtomicBoolean;->get()Z

    move-result v3

    if-nez v3, :cond_0

    .line 107
    :goto_0
    return-void

    .line 84
    :cond_0
    const-wide/32 v4, 0xf4240

    div-long v0, p1, v4

    .line 85
    .local v0, "frameTimeMillis":J
    iget-object v3, p0, Lcom/facebook/react/modules/core/Timing$TimerFrameCallback;->this$0:Lcom/facebook/react/modules/core/Timing;

    invoke-static {v3}, Lcom/facebook/react/modules/core/Timing;->access$200(Lcom/facebook/react/modules/core/Timing;)Ljava/lang/Object;

    move-result-object v4

    monitor-enter v4

    .line 86
    :goto_1
    :try_start_0
    iget-object v3, p0, Lcom/facebook/react/modules/core/Timing$TimerFrameCallback;->this$0:Lcom/facebook/react/modules/core/Timing;

    invoke-static {v3}, Lcom/facebook/react/modules/core/Timing;->access$300(Lcom/facebook/react/modules/core/Timing;)Ljava/util/PriorityQueue;

    move-result-object v3

    invoke-virtual {v3}, Ljava/util/PriorityQueue;->isEmpty()Z

    move-result v3

    if-nez v3, :cond_3

    iget-object v3, p0, Lcom/facebook/react/modules/core/Timing$TimerFrameCallback;->this$0:Lcom/facebook/react/modules/core/Timing;

    invoke-static {v3}, Lcom/facebook/react/modules/core/Timing;->access$300(Lcom/facebook/react/modules/core/Timing;)Ljava/util/PriorityQueue;

    move-result-object v3

    invoke-virtual {v3}, Ljava/util/PriorityQueue;->peek()Ljava/lang/Object;

    move-result-object v3

    check-cast v3, Lcom/facebook/react/modules/core/Timing$Timer;

    invoke-static {v3}, Lcom/facebook/react/modules/core/Timing$Timer;->access$400(Lcom/facebook/react/modules/core/Timing$Timer;)J

    move-result-wide v6

    cmp-long v3, v6, v0

    if-gez v3, :cond_3

    .line 87
    iget-object v3, p0, Lcom/facebook/react/modules/core/Timing$TimerFrameCallback;->this$0:Lcom/facebook/react/modules/core/Timing;

    invoke-static {v3}, Lcom/facebook/react/modules/core/Timing;->access$300(Lcom/facebook/react/modules/core/Timing;)Ljava/util/PriorityQueue;

    move-result-object v3

    invoke-virtual {v3}, Ljava/util/PriorityQueue;->poll()Ljava/lang/Object;

    move-result-object v2

    check-cast v2, Lcom/facebook/react/modules/core/Timing$Timer;

    .line 88
    .local v2, "timer":Lcom/facebook/react/modules/core/Timing$Timer;
    iget-object v3, p0, Lcom/facebook/react/modules/core/Timing$TimerFrameCallback;->mTimersToCall:Lcom/facebook/react/bridge/WritableArray;

    if-nez v3, :cond_1

    .line 89
    invoke-static {}, Lcom/facebook/react/bridge/Arguments;->createArray()Lcom/facebook/react/bridge/WritableArray;

    move-result-object v3

    iput-object v3, p0, Lcom/facebook/react/modules/core/Timing$TimerFrameCallback;->mTimersToCall:Lcom/facebook/react/bridge/WritableArray;

    .line 91
    :cond_1
    iget-object v3, p0, Lcom/facebook/react/modules/core/Timing$TimerFrameCallback;->mTimersToCall:Lcom/facebook/react/bridge/WritableArray;

    invoke-static {v2}, Lcom/facebook/react/modules/core/Timing$Timer;->access$500(Lcom/facebook/react/modules/core/Timing$Timer;)I

    move-result v5

    invoke-interface {v3, v5}, Lcom/facebook/react/bridge/WritableArray;->pushInt(I)V

    .line 92
    invoke-static {v2}, Lcom/facebook/react/modules/core/Timing$Timer;->access$600(Lcom/facebook/react/modules/core/Timing$Timer;)Z

    move-result v3

    if-eqz v3, :cond_2

    .line 93
    invoke-static {v2}, Lcom/facebook/react/modules/core/Timing$Timer;->access$700(Lcom/facebook/react/modules/core/Timing$Timer;)I

    move-result v3

    int-to-long v6, v3

    add-long/2addr v6, v0

    invoke-static {v2, v6, v7}, Lcom/facebook/react/modules/core/Timing$Timer;->access$402(Lcom/facebook/react/modules/core/Timing$Timer;J)J

    .line 94
    iget-object v3, p0, Lcom/facebook/react/modules/core/Timing$TimerFrameCallback;->this$0:Lcom/facebook/react/modules/core/Timing;

    invoke-static {v3}, Lcom/facebook/react/modules/core/Timing;->access$300(Lcom/facebook/react/modules/core/Timing;)Ljava/util/PriorityQueue;

    move-result-object v3

    invoke-virtual {v3, v2}, Ljava/util/PriorityQueue;->add(Ljava/lang/Object;)Z

    goto :goto_1

    .line 99
    .end local v2    # "timer":Lcom/facebook/react/modules/core/Timing$Timer;
    :catchall_0
    move-exception v3

    monitor-exit v4
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    throw v3

    .line 96
    .restart local v2    # "timer":Lcom/facebook/react/modules/core/Timing$Timer;
    :cond_2
    :try_start_1
    iget-object v3, p0, Lcom/facebook/react/modules/core/Timing$TimerFrameCallback;->this$0:Lcom/facebook/react/modules/core/Timing;

    invoke-static {v3}, Lcom/facebook/react/modules/core/Timing;->access$800(Lcom/facebook/react/modules/core/Timing;)Landroid/util/SparseArray;

    move-result-object v3

    invoke-static {v2}, Lcom/facebook/react/modules/core/Timing$Timer;->access$500(Lcom/facebook/react/modules/core/Timing$Timer;)I

    move-result v5

    invoke-virtual {v3, v5}, Landroid/util/SparseArray;->remove(I)V

    goto :goto_1

    .line 99
    .end local v2    # "timer":Lcom/facebook/react/modules/core/Timing$Timer;
    :cond_3
    monitor-exit v4
    :try_end_1
    .catchall {:try_start_1 .. :try_end_1} :catchall_0

    .line 101
    iget-object v3, p0, Lcom/facebook/react/modules/core/Timing$TimerFrameCallback;->mTimersToCall:Lcom/facebook/react/bridge/WritableArray;

    if-eqz v3, :cond_4

    .line 102
    iget-object v3, p0, Lcom/facebook/react/modules/core/Timing$TimerFrameCallback;->this$0:Lcom/facebook/react/modules/core/Timing;

    invoke-static {v3}, Lcom/facebook/react/modules/core/Timing;->access$900(Lcom/facebook/react/modules/core/Timing;)Lcom/facebook/react/bridge/ReactApplicationContext;

    move-result-object v3

    const-class v4, Lcom/facebook/react/modules/core/JSTimers;

    invoke-virtual {v3, v4}, Lcom/facebook/react/bridge/ReactApplicationContext;->getJSModule(Ljava/lang/Class;)Lcom/facebook/react/bridge/JavaScriptModule;

    move-result-object v3

    check-cast v3, Lcom/facebook/react/modules/core/JSTimers;

    iget-object v4, p0, Lcom/facebook/react/modules/core/Timing$TimerFrameCallback;->mTimersToCall:Lcom/facebook/react/bridge/WritableArray;

    invoke-interface {v3, v4}, Lcom/facebook/react/modules/core/JSTimers;->callTimers(Lcom/facebook/react/bridge/WritableArray;)V

    .line 103
    const/4 v3, 0x0

    iput-object v3, p0, Lcom/facebook/react/modules/core/Timing$TimerFrameCallback;->mTimersToCall:Lcom/facebook/react/bridge/WritableArray;

    .line 106
    :cond_4
    iget-object v3, p0, Lcom/facebook/react/modules/core/Timing$TimerFrameCallback;->this$0:Lcom/facebook/react/modules/core/Timing;

    invoke-static {v3}, Lcom/facebook/react/modules/core/Timing;->access$1000(Lcom/facebook/react/modules/core/Timing;)Lcom/facebook/react/modules/core/ReactChoreographer;

    move-result-object v3

    sget-object v4, Lcom/facebook/react/modules/core/ReactChoreographer$CallbackType;->TIMERS_EVENTS:Lcom/facebook/react/modules/core/ReactChoreographer$CallbackType;

    invoke-virtual {v3, v4, p0}, Lcom/facebook/react/modules/core/ReactChoreographer;->postFrameCallback(Lcom/facebook/react/modules/core/ReactChoreographer$CallbackType;Lcom/facebook/react/modules/core/ChoreographerCompat$FrameCallback;)V

    goto/16 :goto_0
.end method

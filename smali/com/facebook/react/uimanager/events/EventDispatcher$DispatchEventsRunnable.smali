.class Lcom/facebook/react/uimanager/events/EventDispatcher$DispatchEventsRunnable;
.super Ljava/lang/Object;
.source "EventDispatcher.java"

# interfaces
.implements Ljava/lang/Runnable;


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/facebook/react/uimanager/events/EventDispatcher;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x2
    name = "DispatchEventsRunnable"
.end annotation


# instance fields
.field final synthetic this$0:Lcom/facebook/react/uimanager/events/EventDispatcher;


# direct methods
.method private constructor <init>(Lcom/facebook/react/uimanager/events/EventDispatcher;)V
    .locals 0

    .prologue
    .line 325
    iput-object p1, p0, Lcom/facebook/react/uimanager/events/EventDispatcher$DispatchEventsRunnable;->this$0:Lcom/facebook/react/uimanager/events/EventDispatcher;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method

.method synthetic constructor <init>(Lcom/facebook/react/uimanager/events/EventDispatcher;Lcom/facebook/react/uimanager/events/EventDispatcher$1;)V
    .locals 0
    .param p1, "x0"    # Lcom/facebook/react/uimanager/events/EventDispatcher;
    .param p2, "x1"    # Lcom/facebook/react/uimanager/events/EventDispatcher$1;

    .prologue
    .line 325
    invoke-direct {p0, p1}, Lcom/facebook/react/uimanager/events/EventDispatcher$DispatchEventsRunnable;-><init>(Lcom/facebook/react/uimanager/events/EventDispatcher;)V

    return-void
.end method


# virtual methods
.method public run()V
    .locals 10

    .prologue
    const-wide/16 v8, 0x0

    .line 329
    const-string v2, "DispatchEventsRunnable"

    invoke-static {v8, v9, v2}, Lcom/facebook/systrace/Systrace;->beginSection(JLjava/lang/String;)V

    .line 331
    const-wide/16 v2, 0x0

    :try_start_0
    const-string v4, "ScheduleDispatchFrameCallback"

    iget-object v5, p0, Lcom/facebook/react/uimanager/events/EventDispatcher$DispatchEventsRunnable;->this$0:Lcom/facebook/react/uimanager/events/EventDispatcher;

    .line 334
    invoke-static {v5}, Lcom/facebook/react/uimanager/events/EventDispatcher;->access$600(Lcom/facebook/react/uimanager/events/EventDispatcher;)Ljava/util/concurrent/atomic/AtomicInteger;

    move-result-object v5

    invoke-virtual {v5}, Ljava/util/concurrent/atomic/AtomicInteger;->getAndIncrement()I

    move-result v5

    .line 331
    invoke-static {v2, v3, v4, v5}, Lcom/facebook/systrace/Systrace;->endAsyncFlow(JLjava/lang/String;I)V

    .line 335
    iget-object v2, p0, Lcom/facebook/react/uimanager/events/EventDispatcher$DispatchEventsRunnable;->this$0:Lcom/facebook/react/uimanager/events/EventDispatcher;

    const/4 v3, 0x0

    invoke-static {v2, v3}, Lcom/facebook/react/uimanager/events/EventDispatcher;->access$502(Lcom/facebook/react/uimanager/events/EventDispatcher;Z)Z

    .line 336
    iget-object v2, p0, Lcom/facebook/react/uimanager/events/EventDispatcher$DispatchEventsRunnable;->this$0:Lcom/facebook/react/uimanager/events/EventDispatcher;

    invoke-static {v2}, Lcom/facebook/react/uimanager/events/EventDispatcher;->access$1000(Lcom/facebook/react/uimanager/events/EventDispatcher;)Lcom/facebook/react/uimanager/events/RCTEventEmitter;

    move-result-object v2

    invoke-static {v2}, Lcom/facebook/infer/annotation/Assertions;->assertNotNull(Ljava/lang/Object;)Ljava/lang/Object;

    .line 337
    iget-object v2, p0, Lcom/facebook/react/uimanager/events/EventDispatcher$DispatchEventsRunnable;->this$0:Lcom/facebook/react/uimanager/events/EventDispatcher;

    invoke-static {v2}, Lcom/facebook/react/uimanager/events/EventDispatcher;->access$1100(Lcom/facebook/react/uimanager/events/EventDispatcher;)Ljava/lang/Object;

    move-result-object v3

    monitor-enter v3
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_1

    .line 340
    :try_start_1
    iget-object v2, p0, Lcom/facebook/react/uimanager/events/EventDispatcher$DispatchEventsRunnable;->this$0:Lcom/facebook/react/uimanager/events/EventDispatcher;

    invoke-static {v2}, Lcom/facebook/react/uimanager/events/EventDispatcher;->access$400(Lcom/facebook/react/uimanager/events/EventDispatcher;)I

    move-result v2

    const/4 v4, 0x1

    if-le v2, v4, :cond_0

    .line 341
    iget-object v2, p0, Lcom/facebook/react/uimanager/events/EventDispatcher$DispatchEventsRunnable;->this$0:Lcom/facebook/react/uimanager/events/EventDispatcher;

    invoke-static {v2}, Lcom/facebook/react/uimanager/events/EventDispatcher;->access$1200(Lcom/facebook/react/uimanager/events/EventDispatcher;)[Lcom/facebook/react/uimanager/events/Event;

    move-result-object v2

    const/4 v4, 0x0

    iget-object v5, p0, Lcom/facebook/react/uimanager/events/EventDispatcher$DispatchEventsRunnable;->this$0:Lcom/facebook/react/uimanager/events/EventDispatcher;

    invoke-static {v5}, Lcom/facebook/react/uimanager/events/EventDispatcher;->access$400(Lcom/facebook/react/uimanager/events/EventDispatcher;)I

    move-result v5

    invoke-static {}, Lcom/facebook/react/uimanager/events/EventDispatcher;->access$1300()Ljava/util/Comparator;

    move-result-object v6

    invoke-static {v2, v4, v5, v6}, Ljava/util/Arrays;->sort([Ljava/lang/Object;IILjava/util/Comparator;)V

    .line 343
    :cond_0
    const/4 v1, 0x0

    .local v1, "eventIdx":I
    :goto_0
    iget-object v2, p0, Lcom/facebook/react/uimanager/events/EventDispatcher$DispatchEventsRunnable;->this$0:Lcom/facebook/react/uimanager/events/EventDispatcher;

    invoke-static {v2}, Lcom/facebook/react/uimanager/events/EventDispatcher;->access$400(Lcom/facebook/react/uimanager/events/EventDispatcher;)I

    move-result v2

    if-ge v1, v2, :cond_2

    .line 344
    iget-object v2, p0, Lcom/facebook/react/uimanager/events/EventDispatcher$DispatchEventsRunnable;->this$0:Lcom/facebook/react/uimanager/events/EventDispatcher;

    invoke-static {v2}, Lcom/facebook/react/uimanager/events/EventDispatcher;->access$1200(Lcom/facebook/react/uimanager/events/EventDispatcher;)[Lcom/facebook/react/uimanager/events/Event;

    move-result-object v2

    aget-object v0, v2, v1

    .line 346
    .local v0, "event":Lcom/facebook/react/uimanager/events/Event;
    if-nez v0, :cond_1

    .line 343
    :goto_1
    add-int/lit8 v1, v1, 0x1

    goto :goto_0

    .line 349
    :cond_1
    const-wide/16 v4, 0x0

    .line 351
    invoke-virtual {v0}, Lcom/facebook/react/uimanager/events/Event;->getEventName()Ljava/lang/String;

    move-result-object v2

    .line 352
    invoke-virtual {v0}, Lcom/facebook/react/uimanager/events/Event;->getUniqueID()I

    move-result v6

    .line 349
    invoke-static {v4, v5, v2, v6}, Lcom/facebook/systrace/Systrace;->endAsyncFlow(JLjava/lang/String;I)V

    .line 353
    iget-object v2, p0, Lcom/facebook/react/uimanager/events/EventDispatcher$DispatchEventsRunnable;->this$0:Lcom/facebook/react/uimanager/events/EventDispatcher;

    invoke-static {v2}, Lcom/facebook/react/uimanager/events/EventDispatcher;->access$1000(Lcom/facebook/react/uimanager/events/EventDispatcher;)Lcom/facebook/react/uimanager/events/RCTEventEmitter;

    move-result-object v2

    invoke-virtual {v0, v2}, Lcom/facebook/react/uimanager/events/Event;->dispatch(Lcom/facebook/react/uimanager/events/RCTEventEmitter;)V

    .line 354
    invoke-virtual {v0}, Lcom/facebook/react/uimanager/events/Event;->dispose()V

    goto :goto_1

    .line 358
    .end local v0    # "event":Lcom/facebook/react/uimanager/events/Event;
    .end local v1    # "eventIdx":I
    :catchall_0
    move-exception v2

    monitor-exit v3
    :try_end_1
    .catchall {:try_start_1 .. :try_end_1} :catchall_0

    :try_start_2
    throw v2
    :try_end_2
    .catchall {:try_start_2 .. :try_end_2} :catchall_1

    .line 360
    :catchall_1
    move-exception v2

    invoke-static {v8, v9}, Lcom/facebook/systrace/Systrace;->endSection(J)V

    throw v2

    .line 356
    .restart local v1    # "eventIdx":I
    :cond_2
    :try_start_3
    iget-object v2, p0, Lcom/facebook/react/uimanager/events/EventDispatcher$DispatchEventsRunnable;->this$0:Lcom/facebook/react/uimanager/events/EventDispatcher;

    invoke-static {v2}, Lcom/facebook/react/uimanager/events/EventDispatcher;->access$1400(Lcom/facebook/react/uimanager/events/EventDispatcher;)V

    .line 357
    iget-object v2, p0, Lcom/facebook/react/uimanager/events/EventDispatcher$DispatchEventsRunnable;->this$0:Lcom/facebook/react/uimanager/events/EventDispatcher;

    invoke-static {v2}, Lcom/facebook/react/uimanager/events/EventDispatcher;->access$1500(Lcom/facebook/react/uimanager/events/EventDispatcher;)Landroid/util/LongSparseArray;

    move-result-object v2

    invoke-virtual {v2}, Landroid/util/LongSparseArray;->clear()V

    .line 358
    monitor-exit v3
    :try_end_3
    .catchall {:try_start_3 .. :try_end_3} :catchall_0

    .line 360
    invoke-static {v8, v9}, Lcom/facebook/systrace/Systrace;->endSection(J)V

    .line 362
    return-void
.end method

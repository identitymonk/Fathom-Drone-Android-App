.class Lcom/facebook/react/modules/core/Timing$IdleCallbackRunnable;
.super Ljava/lang/Object;
.source "Timing.java"

# interfaces
.implements Ljava/lang/Runnable;


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/facebook/react/modules/core/Timing;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x2
    name = "IdleCallbackRunnable"
.end annotation


# instance fields
.field private volatile mCancelled:Z

.field private final mFrameStartTime:J

.field final synthetic this$0:Lcom/facebook/react/modules/core/Timing;


# direct methods
.method public constructor <init>(Lcom/facebook/react/modules/core/Timing;J)V
    .locals 2
    .param p2, "frameStartTime"    # J

    .prologue
    .line 134
    iput-object p1, p0, Lcom/facebook/react/modules/core/Timing$IdleCallbackRunnable;->this$0:Lcom/facebook/react/modules/core/Timing;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 131
    const/4 v0, 0x0

    iput-boolean v0, p0, Lcom/facebook/react/modules/core/Timing$IdleCallbackRunnable;->mCancelled:Z

    .line 135
    iput-wide p2, p0, Lcom/facebook/react/modules/core/Timing$IdleCallbackRunnable;->mFrameStartTime:J

    .line 136
    return-void
.end method


# virtual methods
.method public cancel()V
    .locals 1

    .prologue
    .line 168
    const/4 v0, 0x1

    iput-boolean v0, p0, Lcom/facebook/react/modules/core/Timing$IdleCallbackRunnable;->mCancelled:Z

    .line 169
    return-void
.end method

.method public run()V
    .locals 18

    .prologue
    .line 140
    move-object/from16 v0, p0

    iget-boolean v9, v0, Lcom/facebook/react/modules/core/Timing$IdleCallbackRunnable;->mCancelled:Z

    if-eqz v9, :cond_1

    .line 165
    :cond_0
    :goto_0
    return-void

    .line 144
    :cond_1
    move-object/from16 v0, p0

    iget-wide v14, v0, Lcom/facebook/react/modules/core/Timing$IdleCallbackRunnable;->mFrameStartTime:J

    const-wide/32 v16, 0xf4240

    div-long v6, v14, v16

    .line 145
    .local v6, "frameTimeMillis":J
    invoke-static {}, Lcom/facebook/react/common/SystemClock;->uptimeMillis()J

    move-result-wide v12

    .line 146
    .local v12, "timeSinceBoot":J
    sub-long v4, v12, v6

    .line 147
    .local v4, "frameTimeElapsed":J
    invoke-static {}, Lcom/facebook/react/common/SystemClock;->currentTimeMillis()J

    move-result-wide v10

    .line 148
    .local v10, "time":J
    sub-long v2, v10, v4

    .line 150
    .local v2, "absoluteFrameStartTime":J
    const v9, 0x41855555

    long-to-float v14, v4

    sub-float/2addr v9, v14

    const/high16 v14, 0x3f800000    # 1.0f

    cmpg-float v9, v9, v14

    if-ltz v9, :cond_0

    .line 155
    move-object/from16 v0, p0

    iget-object v9, v0, Lcom/facebook/react/modules/core/Timing$IdleCallbackRunnable;->this$0:Lcom/facebook/react/modules/core/Timing;

    invoke-static {v9}, Lcom/facebook/react/modules/core/Timing;->access$1300(Lcom/facebook/react/modules/core/Timing;)Ljava/lang/Object;

    move-result-object v14

    monitor-enter v14

    .line 156
    :try_start_0
    move-object/from16 v0, p0

    iget-object v9, v0, Lcom/facebook/react/modules/core/Timing$IdleCallbackRunnable;->this$0:Lcom/facebook/react/modules/core/Timing;

    invoke-static {v9}, Lcom/facebook/react/modules/core/Timing;->access$1400(Lcom/facebook/react/modules/core/Timing;)Z

    move-result v8

    .line 157
    .local v8, "sendIdleEvents":Z
    monitor-exit v14
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    .line 159
    if-eqz v8, :cond_2

    .line 160
    move-object/from16 v0, p0

    iget-object v9, v0, Lcom/facebook/react/modules/core/Timing$IdleCallbackRunnable;->this$0:Lcom/facebook/react/modules/core/Timing;

    invoke-static {v9}, Lcom/facebook/react/modules/core/Timing;->access$1500(Lcom/facebook/react/modules/core/Timing;)Lcom/facebook/react/bridge/ReactApplicationContext;

    move-result-object v9

    const-class v14, Lcom/facebook/react/modules/core/JSTimers;

    invoke-virtual {v9, v14}, Lcom/facebook/react/bridge/ReactApplicationContext;->getJSModule(Ljava/lang/Class;)Lcom/facebook/react/bridge/JavaScriptModule;

    move-result-object v9

    check-cast v9, Lcom/facebook/react/modules/core/JSTimers;

    long-to-double v14, v2

    .line 161
    invoke-interface {v9, v14, v15}, Lcom/facebook/react/modules/core/JSTimers;->callIdleCallbacks(D)V

    .line 164
    :cond_2
    move-object/from16 v0, p0

    iget-object v9, v0, Lcom/facebook/react/modules/core/Timing$IdleCallbackRunnable;->this$0:Lcom/facebook/react/modules/core/Timing;

    const/4 v14, 0x0

    invoke-static {v9, v14}, Lcom/facebook/react/modules/core/Timing;->access$1102(Lcom/facebook/react/modules/core/Timing;Lcom/facebook/react/modules/core/Timing$IdleCallbackRunnable;)Lcom/facebook/react/modules/core/Timing$IdleCallbackRunnable;

    goto :goto_0

    .line 157
    .end local v8    # "sendIdleEvents":Z
    :catchall_0
    move-exception v9

    :try_start_1
    monitor-exit v14
    :try_end_1
    .catchall {:try_start_1 .. :try_end_1} :catchall_0

    throw v9
.end method

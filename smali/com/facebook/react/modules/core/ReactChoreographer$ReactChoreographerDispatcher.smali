.class Lcom/facebook/react/modules/core/ReactChoreographer$ReactChoreographerDispatcher;
.super Lcom/facebook/react/modules/core/ChoreographerCompat$FrameCallback;
.source "ReactChoreographer.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/facebook/react/modules/core/ReactChoreographer;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x2
    name = "ReactChoreographerDispatcher"
.end annotation


# instance fields
.field final synthetic this$0:Lcom/facebook/react/modules/core/ReactChoreographer;


# direct methods
.method private constructor <init>(Lcom/facebook/react/modules/core/ReactChoreographer;)V
    .locals 0

    .prologue
    .line 127
    iput-object p1, p0, Lcom/facebook/react/modules/core/ReactChoreographer$ReactChoreographerDispatcher;->this$0:Lcom/facebook/react/modules/core/ReactChoreographer;

    invoke-direct {p0}, Lcom/facebook/react/modules/core/ChoreographerCompat$FrameCallback;-><init>()V

    return-void
.end method

.method synthetic constructor <init>(Lcom/facebook/react/modules/core/ReactChoreographer;Lcom/facebook/react/modules/core/ReactChoreographer$1;)V
    .locals 0
    .param p1, "x0"    # Lcom/facebook/react/modules/core/ReactChoreographer;
    .param p2, "x1"    # Lcom/facebook/react/modules/core/ReactChoreographer$1;

    .prologue
    .line 127
    invoke-direct {p0, p1}, Lcom/facebook/react/modules/core/ReactChoreographer$ReactChoreographerDispatcher;-><init>(Lcom/facebook/react/modules/core/ReactChoreographer;)V

    return-void
.end method


# virtual methods
.method public doFrame(J)V
    .locals 7
    .param p1, "frameTimeNanos"    # J

    .prologue
    .line 131
    iget-object v4, p0, Lcom/facebook/react/modules/core/ReactChoreographer$ReactChoreographerDispatcher;->this$0:Lcom/facebook/react/modules/core/ReactChoreographer;

    monitor-enter v4

    .line 132
    :try_start_0
    iget-object v3, p0, Lcom/facebook/react/modules/core/ReactChoreographer$ReactChoreographerDispatcher;->this$0:Lcom/facebook/react/modules/core/ReactChoreographer;

    const/4 v5, 0x0

    invoke-static {v3, v5}, Lcom/facebook/react/modules/core/ReactChoreographer;->access$102(Lcom/facebook/react/modules/core/ReactChoreographer;Z)Z

    .line 133
    const/4 v1, 0x0

    .local v1, "i":I
    :goto_0
    iget-object v3, p0, Lcom/facebook/react/modules/core/ReactChoreographer$ReactChoreographerDispatcher;->this$0:Lcom/facebook/react/modules/core/ReactChoreographer;

    invoke-static {v3}, Lcom/facebook/react/modules/core/ReactChoreographer;->access$200(Lcom/facebook/react/modules/core/ReactChoreographer;)[Ljava/util/ArrayDeque;

    move-result-object v3

    array-length v3, v3

    if-ge v1, v3, :cond_1

    .line 134
    iget-object v3, p0, Lcom/facebook/react/modules/core/ReactChoreographer$ReactChoreographerDispatcher;->this$0:Lcom/facebook/react/modules/core/ReactChoreographer;

    invoke-static {v3}, Lcom/facebook/react/modules/core/ReactChoreographer;->access$200(Lcom/facebook/react/modules/core/ReactChoreographer;)[Ljava/util/ArrayDeque;

    move-result-object v3

    aget-object v3, v3, v1

    invoke-virtual {v3}, Ljava/util/ArrayDeque;->size()I

    move-result v2

    .line 135
    .local v2, "initialLength":I
    const/4 v0, 0x0

    .local v0, "callback":I
    :goto_1
    if-ge v0, v2, :cond_0

    .line 136
    iget-object v3, p0, Lcom/facebook/react/modules/core/ReactChoreographer$ReactChoreographerDispatcher;->this$0:Lcom/facebook/react/modules/core/ReactChoreographer;

    invoke-static {v3}, Lcom/facebook/react/modules/core/ReactChoreographer;->access$200(Lcom/facebook/react/modules/core/ReactChoreographer;)[Ljava/util/ArrayDeque;

    move-result-object v3

    aget-object v3, v3, v1

    invoke-virtual {v3}, Ljava/util/ArrayDeque;->removeFirst()Ljava/lang/Object;

    move-result-object v3

    check-cast v3, Lcom/facebook/react/modules/core/ChoreographerCompat$FrameCallback;

    invoke-virtual {v3, p1, p2}, Lcom/facebook/react/modules/core/ChoreographerCompat$FrameCallback;->doFrame(J)V

    .line 137
    iget-object v3, p0, Lcom/facebook/react/modules/core/ReactChoreographer$ReactChoreographerDispatcher;->this$0:Lcom/facebook/react/modules/core/ReactChoreographer;

    invoke-static {v3}, Lcom/facebook/react/modules/core/ReactChoreographer;->access$310(Lcom/facebook/react/modules/core/ReactChoreographer;)I

    .line 135
    add-int/lit8 v0, v0, 0x1

    goto :goto_1

    .line 133
    :cond_0
    add-int/lit8 v1, v1, 0x1

    goto :goto_0

    .line 140
    .end local v0    # "callback":I
    .end local v2    # "initialLength":I
    :cond_1
    iget-object v3, p0, Lcom/facebook/react/modules/core/ReactChoreographer$ReactChoreographerDispatcher;->this$0:Lcom/facebook/react/modules/core/ReactChoreographer;

    invoke-static {v3}, Lcom/facebook/react/modules/core/ReactChoreographer;->access$400(Lcom/facebook/react/modules/core/ReactChoreographer;)V

    .line 141
    monitor-exit v4

    .line 142
    return-void

    .line 141
    .end local v1    # "i":I
    :catchall_0
    move-exception v3

    monitor-exit v4
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    throw v3
.end method

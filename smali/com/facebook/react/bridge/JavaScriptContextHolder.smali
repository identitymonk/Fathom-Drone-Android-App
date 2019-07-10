.class public Lcom/facebook/react/bridge/JavaScriptContextHolder;
.super Ljava/lang/Object;
.source "JavaScriptContextHolder.java"


# instance fields
.field private mContext:J
    .annotation build Ljavax/annotation/concurrent/GuardedBy;
        value = "this"
    .end annotation
.end field


# direct methods
.method public constructor <init>(J)V
    .locals 1
    .param p1, "context"    # J

    .prologue
    .line 16
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 17
    iput-wide p1, p0, Lcom/facebook/react/bridge/JavaScriptContextHolder;->mContext:J

    .line 18
    return-void
.end method


# virtual methods
.method public declared-synchronized clear()V
    .locals 2

    .prologue
    .line 26
    monitor-enter p0

    const-wide/16 v0, 0x0

    :try_start_0
    iput-wide v0, p0, Lcom/facebook/react/bridge/JavaScriptContextHolder;->mContext:J
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    .line 27
    monitor-exit p0

    return-void

    .line 26
    :catchall_0
    move-exception v0

    monitor-exit p0

    throw v0
.end method

.method public get()J
    .locals 2
    .annotation build Ljavax/annotation/concurrent/GuardedBy;
        value = "this"
    .end annotation

    .prologue
    .line 22
    iget-wide v0, p0, Lcom/facebook/react/bridge/JavaScriptContextHolder;->mContext:J

    return-wide v0
.end method

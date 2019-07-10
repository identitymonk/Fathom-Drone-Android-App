.class public Lcom/facebook/react/modules/debug/DidJSUpdateUiDuringFrameDetector;
.super Ljava/lang/Object;
.source "DidJSUpdateUiDuringFrameDetector.java"

# interfaces
.implements Lcom/facebook/react/bridge/NotThreadSafeBridgeIdleDebugListener;
.implements Lcom/facebook/react/uimanager/debug/NotThreadSafeViewHierarchyUpdateDebugListener;


# instance fields
.field private final mTransitionToBusyEvents:Lcom/facebook/react/common/LongArray;

.field private final mTransitionToIdleEvents:Lcom/facebook/react/common/LongArray;

.field private final mViewHierarchyUpdateEnqueuedEvents:Lcom/facebook/react/common/LongArray;

.field private final mViewHierarchyUpdateFinishedEvents:Lcom/facebook/react/common/LongArray;

.field private volatile mWasIdleAtEndOfLastFrame:Z


# direct methods
.method public constructor <init>()V
    .locals 2

    .prologue
    const/16 v1, 0x14

    .line 26
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 29
    invoke-static {v1}, Lcom/facebook/react/common/LongArray;->createWithInitialCapacity(I)Lcom/facebook/react/common/LongArray;

    move-result-object v0

    iput-object v0, p0, Lcom/facebook/react/modules/debug/DidJSUpdateUiDuringFrameDetector;->mTransitionToIdleEvents:Lcom/facebook/react/common/LongArray;

    .line 30
    invoke-static {v1}, Lcom/facebook/react/common/LongArray;->createWithInitialCapacity(I)Lcom/facebook/react/common/LongArray;

    move-result-object v0

    iput-object v0, p0, Lcom/facebook/react/modules/debug/DidJSUpdateUiDuringFrameDetector;->mTransitionToBusyEvents:Lcom/facebook/react/common/LongArray;

    .line 32
    invoke-static {v1}, Lcom/facebook/react/common/LongArray;->createWithInitialCapacity(I)Lcom/facebook/react/common/LongArray;

    move-result-object v0

    iput-object v0, p0, Lcom/facebook/react/modules/debug/DidJSUpdateUiDuringFrameDetector;->mViewHierarchyUpdateEnqueuedEvents:Lcom/facebook/react/common/LongArray;

    .line 34
    invoke-static {v1}, Lcom/facebook/react/common/LongArray;->createWithInitialCapacity(I)Lcom/facebook/react/common/LongArray;

    move-result-object v0

    iput-object v0, p0, Lcom/facebook/react/modules/debug/DidJSUpdateUiDuringFrameDetector;->mViewHierarchyUpdateFinishedEvents:Lcom/facebook/react/common/LongArray;

    .line 35
    const/4 v0, 0x1

    iput-boolean v0, p0, Lcom/facebook/react/modules/debug/DidJSUpdateUiDuringFrameDetector;->mWasIdleAtEndOfLastFrame:Z

    return-void
.end method

.method private static cleanUp(Lcom/facebook/react/common/LongArray;J)V
    .locals 7
    .param p0, "eventArray"    # Lcom/facebook/react/common/LongArray;
    .param p1, "endTime"    # J

    .prologue
    .line 159
    invoke-virtual {p0}, Lcom/facebook/react/common/LongArray;->size()I

    move-result v2

    .line 160
    .local v2, "size":I
    const/4 v1, 0x0

    .line 161
    .local v1, "indicesToRemove":I
    const/4 v0, 0x0

    .local v0, "i":I
    :goto_0
    if-ge v0, v2, :cond_1

    .line 162
    invoke-virtual {p0, v0}, Lcom/facebook/react/common/LongArray;->get(I)J

    move-result-wide v4

    cmp-long v3, v4, p1

    if-gez v3, :cond_0

    .line 163
    add-int/lit8 v1, v1, 0x1

    .line 161
    :cond_0
    add-int/lit8 v0, v0, 0x1

    goto :goto_0

    .line 167
    :cond_1
    if-lez v1, :cond_3

    .line 168
    const/4 v0, 0x0

    :goto_1
    sub-int v3, v2, v1

    if-ge v0, v3, :cond_2

    .line 169
    add-int v3, v0, v1

    invoke-virtual {p0, v3}, Lcom/facebook/react/common/LongArray;->get(I)J

    move-result-wide v4

    invoke-virtual {p0, v0, v4, v5}, Lcom/facebook/react/common/LongArray;->set(IJ)V

    .line 168
    add-int/lit8 v0, v0, 0x1

    goto :goto_1

    .line 171
    :cond_2
    invoke-virtual {p0, v1}, Lcom/facebook/react/common/LongArray;->dropTail(I)V

    .line 173
    :cond_3
    return-void
.end method

.method private didEndFrameIdle(JJ)Z
    .locals 9
    .param p1, "startTime"    # J
    .param p3, "endTime"    # J

    .prologue
    const-wide/16 v6, -0x1

    .line 142
    iget-object v4, p0, Lcom/facebook/react/modules/debug/DidJSUpdateUiDuringFrameDetector;->mTransitionToIdleEvents:Lcom/facebook/react/common/LongArray;

    invoke-static {v4, p1, p2, p3, p4}, Lcom/facebook/react/modules/debug/DidJSUpdateUiDuringFrameDetector;->getLastEventBetweenTimestamps(Lcom/facebook/react/common/LongArray;JJ)J

    move-result-wide v2

    .line 146
    .local v2, "lastIdleTransition":J
    iget-object v4, p0, Lcom/facebook/react/modules/debug/DidJSUpdateUiDuringFrameDetector;->mTransitionToBusyEvents:Lcom/facebook/react/common/LongArray;

    invoke-static {v4, p1, p2, p3, p4}, Lcom/facebook/react/modules/debug/DidJSUpdateUiDuringFrameDetector;->getLastEventBetweenTimestamps(Lcom/facebook/react/common/LongArray;JJ)J

    move-result-wide v0

    .line 151
    .local v0, "lastBusyTransition":J
    cmp-long v4, v2, v6

    if-nez v4, :cond_0

    cmp-long v4, v0, v6

    if-nez v4, :cond_0

    .line 152
    iget-boolean v4, p0, Lcom/facebook/react/modules/debug/DidJSUpdateUiDuringFrameDetector;->mWasIdleAtEndOfLastFrame:Z

    .line 155
    :goto_0
    return v4

    :cond_0
    cmp-long v4, v2, v0

    if-lez v4, :cond_1

    const/4 v4, 0x1

    goto :goto_0

    :cond_1
    const/4 v4, 0x0

    goto :goto_0
.end method

.method private static getLastEventBetweenTimestamps(Lcom/facebook/react/common/LongArray;JJ)J
    .locals 7
    .param p0, "eventArray"    # Lcom/facebook/react/common/LongArray;
    .param p1, "startTime"    # J
    .param p3, "endTime"    # J

    .prologue
    .line 129
    const-wide/16 v2, -0x1

    .line 130
    .local v2, "lastEvent":J
    const/4 v0, 0x0

    .local v0, "i":I
    :goto_0
    invoke-virtual {p0}, Lcom/facebook/react/common/LongArray;->size()I

    move-result v1

    if-ge v0, v1, :cond_2

    .line 131
    invoke-virtual {p0, v0}, Lcom/facebook/react/common/LongArray;->get(I)J

    move-result-wide v4

    .line 132
    .local v4, "time":J
    cmp-long v1, v4, p1

    if-ltz v1, :cond_1

    cmp-long v1, v4, p3

    if-gez v1, :cond_1

    .line 133
    move-wide v2, v4

    .line 130
    :cond_0
    add-int/lit8 v0, v0, 0x1

    goto :goto_0

    .line 134
    :cond_1
    cmp-long v1, v4, p3

    if-ltz v1, :cond_0

    .line 138
    .end local v4    # "time":J
    :cond_2
    return-wide v2
.end method

.method private static hasEventBetweenTimestamps(Lcom/facebook/react/common/LongArray;JJ)Z
    .locals 5
    .param p0, "eventArray"    # Lcom/facebook/react/common/LongArray;
    .param p1, "startTime"    # J
    .param p3, "endTime"    # J

    .prologue
    .line 116
    const/4 v0, 0x0

    .local v0, "i":I
    :goto_0
    invoke-virtual {p0}, Lcom/facebook/react/common/LongArray;->size()I

    move-result v1

    if-ge v0, v1, :cond_1

    .line 117
    invoke-virtual {p0, v0}, Lcom/facebook/react/common/LongArray;->get(I)J

    move-result-wide v2

    .line 118
    .local v2, "time":J
    cmp-long v1, v2, p1

    if-ltz v1, :cond_0

    cmp-long v1, v2, p3

    if-gez v1, :cond_0

    .line 119
    const/4 v1, 0x1

    .line 122
    .end local v2    # "time":J
    :goto_1
    return v1

    .line 116
    .restart local v2    # "time":J
    :cond_0
    add-int/lit8 v0, v0, 0x1

    goto :goto_0

    .line 122
    .end local v2    # "time":J
    :cond_1
    const/4 v1, 0x0

    goto :goto_1
.end method


# virtual methods
.method public declared-synchronized getDidJSHitFrameAndCleanup(JJ)Z
    .locals 5
    .param p1, "frameStartTimeNanos"    # J
    .param p3, "frameEndTimeNanos"    # J

    .prologue
    .line 85
    monitor-enter p0

    :try_start_0
    iget-object v3, p0, Lcom/facebook/react/modules/debug/DidJSUpdateUiDuringFrameDetector;->mViewHierarchyUpdateFinishedEvents:Lcom/facebook/react/common/LongArray;

    invoke-static {v3, p1, p2, p3, p4}, Lcom/facebook/react/modules/debug/DidJSUpdateUiDuringFrameDetector;->hasEventBetweenTimestamps(Lcom/facebook/react/common/LongArray;JJ)Z

    move-result v1

    .line 89
    .local v1, "finishedUiUpdate":Z
    invoke-direct {p0, p1, p2, p3, p4}, Lcom/facebook/react/modules/debug/DidJSUpdateUiDuringFrameDetector;->didEndFrameIdle(JJ)Z

    move-result v0

    .line 92
    .local v0, "didEndFrameIdle":Z
    if-eqz v1, :cond_0

    .line 93
    const/4 v2, 0x1

    .line 102
    .local v2, "hitFrame":Z
    :goto_0
    iget-object v3, p0, Lcom/facebook/react/modules/debug/DidJSUpdateUiDuringFrameDetector;->mTransitionToIdleEvents:Lcom/facebook/react/common/LongArray;

    invoke-static {v3, p3, p4}, Lcom/facebook/react/modules/debug/DidJSUpdateUiDuringFrameDetector;->cleanUp(Lcom/facebook/react/common/LongArray;J)V

    .line 103
    iget-object v3, p0, Lcom/facebook/react/modules/debug/DidJSUpdateUiDuringFrameDetector;->mTransitionToBusyEvents:Lcom/facebook/react/common/LongArray;

    invoke-static {v3, p3, p4}, Lcom/facebook/react/modules/debug/DidJSUpdateUiDuringFrameDetector;->cleanUp(Lcom/facebook/react/common/LongArray;J)V

    .line 104
    iget-object v3, p0, Lcom/facebook/react/modules/debug/DidJSUpdateUiDuringFrameDetector;->mViewHierarchyUpdateEnqueuedEvents:Lcom/facebook/react/common/LongArray;

    invoke-static {v3, p3, p4}, Lcom/facebook/react/modules/debug/DidJSUpdateUiDuringFrameDetector;->cleanUp(Lcom/facebook/react/common/LongArray;J)V

    .line 105
    iget-object v3, p0, Lcom/facebook/react/modules/debug/DidJSUpdateUiDuringFrameDetector;->mViewHierarchyUpdateFinishedEvents:Lcom/facebook/react/common/LongArray;

    invoke-static {v3, p3, p4}, Lcom/facebook/react/modules/debug/DidJSUpdateUiDuringFrameDetector;->cleanUp(Lcom/facebook/react/common/LongArray;J)V

    .line 107
    iput-boolean v0, p0, Lcom/facebook/react/modules/debug/DidJSUpdateUiDuringFrameDetector;->mWasIdleAtEndOfLastFrame:Z
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    .line 109
    monitor-exit p0

    return v2

    .line 96
    .end local v2    # "hitFrame":Z
    :cond_0
    if-eqz v0, :cond_1

    :try_start_1
    iget-object v3, p0, Lcom/facebook/react/modules/debug/DidJSUpdateUiDuringFrameDetector;->mViewHierarchyUpdateEnqueuedEvents:Lcom/facebook/react/common/LongArray;

    invoke-static {v3, p1, p2, p3, p4}, Lcom/facebook/react/modules/debug/DidJSUpdateUiDuringFrameDetector;->hasEventBetweenTimestamps(Lcom/facebook/react/common/LongArray;JJ)Z
    :try_end_1
    .catchall {:try_start_1 .. :try_end_1} :catchall_0

    move-result v3

    if-nez v3, :cond_1

    const/4 v2, 0x1

    .restart local v2    # "hitFrame":Z
    :goto_1
    goto :goto_0

    .end local v2    # "hitFrame":Z
    :cond_1
    const/4 v2, 0x0

    goto :goto_1

    .line 85
    .end local v0    # "didEndFrameIdle":Z
    .end local v1    # "finishedUiUpdate":Z
    :catchall_0
    move-exception v3

    monitor-exit p0

    throw v3
.end method

.method public declared-synchronized onTransitionToBridgeBusy()V
    .locals 4

    .prologue
    .line 44
    monitor-enter p0

    :try_start_0
    iget-object v0, p0, Lcom/facebook/react/modules/debug/DidJSUpdateUiDuringFrameDetector;->mTransitionToBusyEvents:Lcom/facebook/react/common/LongArray;

    invoke-static {}, Ljava/lang/System;->nanoTime()J

    move-result-wide v2

    invoke-virtual {v0, v2, v3}, Lcom/facebook/react/common/LongArray;->add(J)V
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    .line 45
    monitor-exit p0

    return-void

    .line 44
    :catchall_0
    move-exception v0

    monitor-exit p0

    throw v0
.end method

.method public declared-synchronized onTransitionToBridgeIdle()V
    .locals 4

    .prologue
    .line 39
    monitor-enter p0

    :try_start_0
    iget-object v0, p0, Lcom/facebook/react/modules/debug/DidJSUpdateUiDuringFrameDetector;->mTransitionToIdleEvents:Lcom/facebook/react/common/LongArray;

    invoke-static {}, Ljava/lang/System;->nanoTime()J

    move-result-wide v2

    invoke-virtual {v0, v2, v3}, Lcom/facebook/react/common/LongArray;->add(J)V
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    .line 40
    monitor-exit p0

    return-void

    .line 39
    :catchall_0
    move-exception v0

    monitor-exit p0

    throw v0
.end method

.method public declared-synchronized onViewHierarchyUpdateEnqueued()V
    .locals 4

    .prologue
    .line 49
    monitor-enter p0

    :try_start_0
    iget-object v0, p0, Lcom/facebook/react/modules/debug/DidJSUpdateUiDuringFrameDetector;->mViewHierarchyUpdateEnqueuedEvents:Lcom/facebook/react/common/LongArray;

    invoke-static {}, Ljava/lang/System;->nanoTime()J

    move-result-wide v2

    invoke-virtual {v0, v2, v3}, Lcom/facebook/react/common/LongArray;->add(J)V
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    .line 50
    monitor-exit p0

    return-void

    .line 49
    :catchall_0
    move-exception v0

    monitor-exit p0

    throw v0
.end method

.method public declared-synchronized onViewHierarchyUpdateFinished()V
    .locals 4

    .prologue
    .line 54
    monitor-enter p0

    :try_start_0
    iget-object v0, p0, Lcom/facebook/react/modules/debug/DidJSUpdateUiDuringFrameDetector;->mViewHierarchyUpdateFinishedEvents:Lcom/facebook/react/common/LongArray;

    invoke-static {}, Ljava/lang/System;->nanoTime()J

    move-result-wide v2

    invoke-virtual {v0, v2, v3}, Lcom/facebook/react/common/LongArray;->add(J)V
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    .line 55
    monitor-exit p0

    return-void

    .line 54
    :catchall_0
    move-exception v0

    monitor-exit p0

    throw v0
.end method

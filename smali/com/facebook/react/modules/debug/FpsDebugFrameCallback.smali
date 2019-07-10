.class public Lcom/facebook/react/modules/debug/FpsDebugFrameCallback;
.super Lcom/facebook/react/modules/core/ChoreographerCompat$FrameCallback;
.source "FpsDebugFrameCallback.java"


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lcom/facebook/react/modules/debug/FpsDebugFrameCallback$FpsInfo;
    }
.end annotation


# static fields
.field private static final EXPECTED_FRAME_TIME:D = 16.9


# instance fields
.field private m4PlusFrameStutters:I

.field private final mChoreographer:Lcom/facebook/react/modules/core/ChoreographerCompat;

.field private final mDidJSUpdateUiDuringFrameDetector:Lcom/facebook/react/modules/debug/DidJSUpdateUiDuringFrameDetector;

.field private mExpectedNumFramesPrev:I

.field private mFirstFrameTime:J

.field private mIsRecordingFpsInfoAtEachFrame:Z

.field private mLastFrameTime:J

.field private mNumFrameCallbacks:I

.field private mNumFrameCallbacksWithBatchDispatches:I

.field private final mReactContext:Lcom/facebook/react/bridge/ReactContext;

.field private mShouldStop:Z

.field private mTimeToFps:Ljava/util/TreeMap;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/TreeMap",
            "<",
            "Ljava/lang/Long;",
            "Lcom/facebook/react/modules/debug/FpsDebugFrameCallback$FpsInfo;",
            ">;"
        }
    .end annotation

    .annotation runtime Ljavax/annotation/Nullable;
    .end annotation
.end field

.field private final mUIManagerModule:Lcom/facebook/react/uimanager/UIManagerModule;


# direct methods
.method public constructor <init>(Lcom/facebook/react/modules/core/ChoreographerCompat;Lcom/facebook/react/bridge/ReactContext;)V
    .locals 4
    .param p1, "choreographer"    # Lcom/facebook/react/modules/core/ChoreographerCompat;
    .param p2, "reactContext"    # Lcom/facebook/react/bridge/ReactContext;

    .prologue
    const-wide/16 v2, -0x1

    const/4 v0, 0x0

    .line 79
    invoke-direct {p0}, Lcom/facebook/react/modules/core/ChoreographerCompat$FrameCallback;-><init>()V

    .line 69
    iput-boolean v0, p0, Lcom/facebook/react/modules/debug/FpsDebugFrameCallback;->mShouldStop:Z

    .line 70
    iput-wide v2, p0, Lcom/facebook/react/modules/debug/FpsDebugFrameCallback;->mFirstFrameTime:J

    .line 71
    iput-wide v2, p0, Lcom/facebook/react/modules/debug/FpsDebugFrameCallback;->mLastFrameTime:J

    .line 72
    iput v0, p0, Lcom/facebook/react/modules/debug/FpsDebugFrameCallback;->mNumFrameCallbacks:I

    .line 73
    iput v0, p0, Lcom/facebook/react/modules/debug/FpsDebugFrameCallback;->mExpectedNumFramesPrev:I

    .line 74
    iput v0, p0, Lcom/facebook/react/modules/debug/FpsDebugFrameCallback;->m4PlusFrameStutters:I

    .line 75
    iput v0, p0, Lcom/facebook/react/modules/debug/FpsDebugFrameCallback;->mNumFrameCallbacksWithBatchDispatches:I

    .line 76
    iput-boolean v0, p0, Lcom/facebook/react/modules/debug/FpsDebugFrameCallback;->mIsRecordingFpsInfoAtEachFrame:Z

    .line 80
    iput-object p1, p0, Lcom/facebook/react/modules/debug/FpsDebugFrameCallback;->mChoreographer:Lcom/facebook/react/modules/core/ChoreographerCompat;

    .line 81
    iput-object p2, p0, Lcom/facebook/react/modules/debug/FpsDebugFrameCallback;->mReactContext:Lcom/facebook/react/bridge/ReactContext;

    .line 82
    const-class v0, Lcom/facebook/react/uimanager/UIManagerModule;

    invoke-virtual {p2, v0}, Lcom/facebook/react/bridge/ReactContext;->getNativeModule(Ljava/lang/Class;)Lcom/facebook/react/bridge/NativeModule;

    move-result-object v0

    check-cast v0, Lcom/facebook/react/uimanager/UIManagerModule;

    iput-object v0, p0, Lcom/facebook/react/modules/debug/FpsDebugFrameCallback;->mUIManagerModule:Lcom/facebook/react/uimanager/UIManagerModule;

    .line 83
    new-instance v0, Lcom/facebook/react/modules/debug/DidJSUpdateUiDuringFrameDetector;

    invoke-direct {v0}, Lcom/facebook/react/modules/debug/DidJSUpdateUiDuringFrameDetector;-><init>()V

    iput-object v0, p0, Lcom/facebook/react/modules/debug/FpsDebugFrameCallback;->mDidJSUpdateUiDuringFrameDetector:Lcom/facebook/react/modules/debug/DidJSUpdateUiDuringFrameDetector;

    .line 84
    return-void
.end method


# virtual methods
.method public doFrame(J)V
    .locals 19
    .param p1, "l"    # J

    .prologue
    .line 88
    move-object/from16 v0, p0

    iget-boolean v6, v0, Lcom/facebook/react/modules/debug/FpsDebugFrameCallback;->mShouldStop:Z

    if-eqz v6, :cond_0

    .line 127
    :goto_0
    return-void

    .line 92
    :cond_0
    move-object/from16 v0, p0

    iget-wide v6, v0, Lcom/facebook/react/modules/debug/FpsDebugFrameCallback;->mFirstFrameTime:J

    const-wide/16 v10, -0x1

    cmp-long v6, v6, v10

    if-nez v6, :cond_1

    .line 93
    move-wide/from16 v0, p1

    move-object/from16 v2, p0

    iput-wide v0, v2, Lcom/facebook/react/modules/debug/FpsDebugFrameCallback;->mFirstFrameTime:J

    .line 96
    :cond_1
    move-object/from16 v0, p0

    iget-wide v0, v0, Lcom/facebook/react/modules/debug/FpsDebugFrameCallback;->mLastFrameTime:J

    move-wide/from16 v16, v0

    .line 97
    .local v16, "lastFrameStartTime":J
    move-wide/from16 v0, p1

    move-object/from16 v2, p0

    iput-wide v0, v2, Lcom/facebook/react/modules/debug/FpsDebugFrameCallback;->mLastFrameTime:J

    .line 99
    move-object/from16 v0, p0

    iget-object v6, v0, Lcom/facebook/react/modules/debug/FpsDebugFrameCallback;->mDidJSUpdateUiDuringFrameDetector:Lcom/facebook/react/modules/debug/DidJSUpdateUiDuringFrameDetector;

    move-wide/from16 v0, v16

    move-wide/from16 v2, p1

    invoke-virtual {v6, v0, v1, v2, v3}, Lcom/facebook/react/modules/debug/DidJSUpdateUiDuringFrameDetector;->getDidJSHitFrameAndCleanup(JJ)Z

    move-result v6

    if-eqz v6, :cond_2

    .line 102
    move-object/from16 v0, p0

    iget v6, v0, Lcom/facebook/react/modules/debug/FpsDebugFrameCallback;->mNumFrameCallbacksWithBatchDispatches:I

    add-int/lit8 v6, v6, 0x1

    move-object/from16 v0, p0

    iput v6, v0, Lcom/facebook/react/modules/debug/FpsDebugFrameCallback;->mNumFrameCallbacksWithBatchDispatches:I

    .line 105
    :cond_2
    move-object/from16 v0, p0

    iget v6, v0, Lcom/facebook/react/modules/debug/FpsDebugFrameCallback;->mNumFrameCallbacks:I

    add-int/lit8 v6, v6, 0x1

    move-object/from16 v0, p0

    iput v6, v0, Lcom/facebook/react/modules/debug/FpsDebugFrameCallback;->mNumFrameCallbacks:I

    .line 106
    invoke-virtual/range {p0 .. p0}, Lcom/facebook/react/modules/debug/FpsDebugFrameCallback;->getExpectedNumFrames()I

    move-result v8

    .line 107
    .local v8, "expectedNumFrames":I
    move-object/from16 v0, p0

    iget v6, v0, Lcom/facebook/react/modules/debug/FpsDebugFrameCallback;->mExpectedNumFramesPrev:I

    sub-int v6, v8, v6

    add-int/lit8 v4, v6, -0x1

    .line 108
    .local v4, "framesDropped":I
    const/4 v6, 0x4

    if-lt v4, v6, :cond_3

    .line 109
    move-object/from16 v0, p0

    iget v6, v0, Lcom/facebook/react/modules/debug/FpsDebugFrameCallback;->m4PlusFrameStutters:I

    add-int/lit8 v6, v6, 0x1

    move-object/from16 v0, p0

    iput v6, v0, Lcom/facebook/react/modules/debug/FpsDebugFrameCallback;->m4PlusFrameStutters:I

    .line 112
    :cond_3
    move-object/from16 v0, p0

    iget-boolean v6, v0, Lcom/facebook/react/modules/debug/FpsDebugFrameCallback;->mIsRecordingFpsInfoAtEachFrame:Z

    if-eqz v6, :cond_4

    .line 113
    move-object/from16 v0, p0

    iget-object v6, v0, Lcom/facebook/react/modules/debug/FpsDebugFrameCallback;->mTimeToFps:Ljava/util/TreeMap;

    invoke-static {v6}, Lcom/facebook/infer/annotation/Assertions;->assertNotNull(Ljava/lang/Object;)Ljava/lang/Object;

    .line 114
    new-instance v5, Lcom/facebook/react/modules/debug/FpsDebugFrameCallback$FpsInfo;

    .line 115
    invoke-virtual/range {p0 .. p0}, Lcom/facebook/react/modules/debug/FpsDebugFrameCallback;->getNumFrames()I

    move-result v6

    .line 116
    invoke-virtual/range {p0 .. p0}, Lcom/facebook/react/modules/debug/FpsDebugFrameCallback;->getNumJSFrames()I

    move-result v7

    move-object/from16 v0, p0

    iget v9, v0, Lcom/facebook/react/modules/debug/FpsDebugFrameCallback;->m4PlusFrameStutters:I

    .line 119
    invoke-virtual/range {p0 .. p0}, Lcom/facebook/react/modules/debug/FpsDebugFrameCallback;->getFPS()D

    move-result-wide v10

    .line 120
    invoke-virtual/range {p0 .. p0}, Lcom/facebook/react/modules/debug/FpsDebugFrameCallback;->getJSFPS()D

    move-result-wide v12

    .line 121
    invoke-virtual/range {p0 .. p0}, Lcom/facebook/react/modules/debug/FpsDebugFrameCallback;->getTotalTimeMS()I

    move-result v14

    invoke-direct/range {v5 .. v14}, Lcom/facebook/react/modules/debug/FpsDebugFrameCallback$FpsInfo;-><init>(IIIIDDI)V

    .line 122
    .local v5, "info":Lcom/facebook/react/modules/debug/FpsDebugFrameCallback$FpsInfo;
    move-object/from16 v0, p0

    iget-object v6, v0, Lcom/facebook/react/modules/debug/FpsDebugFrameCallback;->mTimeToFps:Ljava/util/TreeMap;

    invoke-static {}, Ljava/lang/System;->currentTimeMillis()J

    move-result-wide v10

    invoke-static {v10, v11}, Ljava/lang/Long;->valueOf(J)Ljava/lang/Long;

    move-result-object v7

    invoke-virtual {v6, v7, v5}, Ljava/util/TreeMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 124
    .end local v5    # "info":Lcom/facebook/react/modules/debug/FpsDebugFrameCallback$FpsInfo;
    :cond_4
    move-object/from16 v0, p0

    iput v8, v0, Lcom/facebook/react/modules/debug/FpsDebugFrameCallback;->mExpectedNumFramesPrev:I

    .line 126
    move-object/from16 v0, p0

    iget-object v6, v0, Lcom/facebook/react/modules/debug/FpsDebugFrameCallback;->mChoreographer:Lcom/facebook/react/modules/core/ChoreographerCompat;

    move-object/from16 v0, p0

    invoke-virtual {v6, v0}, Lcom/facebook/react/modules/core/ChoreographerCompat;->postFrameCallback(Lcom/facebook/react/modules/core/ChoreographerCompat$FrameCallback;)V

    goto/16 :goto_0
.end method

.method public get4PlusFrameStutters()I
    .locals 1

    .prologue
    .line 179
    iget v0, p0, Lcom/facebook/react/modules/debug/FpsDebugFrameCallback;->m4PlusFrameStutters:I

    return v0
.end method

.method public getExpectedNumFrames()I
    .locals 8

    .prologue
    .line 173
    invoke-virtual {p0}, Lcom/facebook/react/modules/debug/FpsDebugFrameCallback;->getTotalTimeMS()I

    move-result v1

    int-to-double v2, v1

    .line 174
    .local v2, "totalTimeMS":D
    const-wide v4, 0x4030e66666666666L    # 16.9

    div-double v4, v2, v4

    const-wide/high16 v6, 0x3ff0000000000000L    # 1.0

    add-double/2addr v4, v6

    double-to-int v0, v4

    .line 175
    .local v0, "expectedFrames":I
    return v0
.end method

.method public getFPS()D
    .locals 6

    .prologue
    .line 151
    iget-wide v0, p0, Lcom/facebook/react/modules/debug/FpsDebugFrameCallback;->mLastFrameTime:J

    iget-wide v2, p0, Lcom/facebook/react/modules/debug/FpsDebugFrameCallback;->mFirstFrameTime:J

    cmp-long v0, v0, v2

    if-nez v0, :cond_0

    .line 152
    const-wide/16 v0, 0x0

    .line 154
    :goto_0
    return-wide v0

    :cond_0
    invoke-virtual {p0}, Lcom/facebook/react/modules/debug/FpsDebugFrameCallback;->getNumFrames()I

    move-result v0

    int-to-double v0, v0

    const-wide v2, 0x41cdcd6500000000L    # 1.0E9

    mul-double/2addr v0, v2

    iget-wide v2, p0, Lcom/facebook/react/modules/debug/FpsDebugFrameCallback;->mLastFrameTime:J

    iget-wide v4, p0, Lcom/facebook/react/modules/debug/FpsDebugFrameCallback;->mFirstFrameTime:J

    sub-long/2addr v2, v4

    long-to-double v2, v2

    div-double/2addr v0, v2

    goto :goto_0
.end method

.method public getFpsInfo(J)Lcom/facebook/react/modules/debug/FpsDebugFrameCallback$FpsInfo;
    .locals 3
    .param p1, "upToTimeMs"    # J
    .annotation runtime Ljavax/annotation/Nullable;
    .end annotation

    .prologue
    .line 191
    iget-object v1, p0, Lcom/facebook/react/modules/debug/FpsDebugFrameCallback;->mTimeToFps:Ljava/util/TreeMap;

    const-string v2, "FPS was not recorded at each frame!"

    invoke-static {v1, v2}, Lcom/facebook/infer/annotation/Assertions;->assertNotNull(Ljava/lang/Object;Ljava/lang/String;)Ljava/lang/Object;

    .line 192
    iget-object v1, p0, Lcom/facebook/react/modules/debug/FpsDebugFrameCallback;->mTimeToFps:Ljava/util/TreeMap;

    invoke-static {p1, p2}, Ljava/lang/Long;->valueOf(J)Ljava/lang/Long;

    move-result-object v2

    invoke-virtual {v1, v2}, Ljava/util/TreeMap;->floorEntry(Ljava/lang/Object;)Ljava/util/Map$Entry;

    move-result-object v0

    .line 193
    .local v0, "bestEntry":Ljava/util/Map$Entry;, "Ljava/util/Map$Entry<Ljava/lang/Long;Lcom/facebook/react/modules/debug/FpsDebugFrameCallback$FpsInfo;>;"
    if-nez v0, :cond_0

    .line 194
    const/4 v1, 0x0

    .line 196
    :goto_0
    return-object v1

    :cond_0
    invoke-interface {v0}, Ljava/util/Map$Entry;->getValue()Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Lcom/facebook/react/modules/debug/FpsDebugFrameCallback$FpsInfo;

    goto :goto_0
.end method

.method public getJSFPS()D
    .locals 6

    .prologue
    .line 158
    iget-wide v0, p0, Lcom/facebook/react/modules/debug/FpsDebugFrameCallback;->mLastFrameTime:J

    iget-wide v2, p0, Lcom/facebook/react/modules/debug/FpsDebugFrameCallback;->mFirstFrameTime:J

    cmp-long v0, v0, v2

    if-nez v0, :cond_0

    .line 159
    const-wide/16 v0, 0x0

    .line 161
    :goto_0
    return-wide v0

    :cond_0
    invoke-virtual {p0}, Lcom/facebook/react/modules/debug/FpsDebugFrameCallback;->getNumJSFrames()I

    move-result v0

    int-to-double v0, v0

    const-wide v2, 0x41cdcd6500000000L    # 1.0E9

    mul-double/2addr v0, v2

    iget-wide v2, p0, Lcom/facebook/react/modules/debug/FpsDebugFrameCallback;->mLastFrameTime:J

    iget-wide v4, p0, Lcom/facebook/react/modules/debug/FpsDebugFrameCallback;->mFirstFrameTime:J

    sub-long/2addr v2, v4

    long-to-double v2, v2

    div-double/2addr v0, v2

    goto :goto_0
.end method

.method public getNumFrames()I
    .locals 1

    .prologue
    .line 165
    iget v0, p0, Lcom/facebook/react/modules/debug/FpsDebugFrameCallback;->mNumFrameCallbacks:I

    add-int/lit8 v0, v0, -0x1

    return v0
.end method

.method public getNumJSFrames()I
    .locals 1

    .prologue
    .line 169
    iget v0, p0, Lcom/facebook/react/modules/debug/FpsDebugFrameCallback;->mNumFrameCallbacksWithBatchDispatches:I

    add-int/lit8 v0, v0, -0x1

    return v0
.end method

.method public getTotalTimeMS()I
    .locals 4

    .prologue
    .line 183
    iget-wide v0, p0, Lcom/facebook/react/modules/debug/FpsDebugFrameCallback;->mLastFrameTime:J

    long-to-double v0, v0

    iget-wide v2, p0, Lcom/facebook/react/modules/debug/FpsDebugFrameCallback;->mFirstFrameTime:J

    long-to-double v2, v2

    sub-double/2addr v0, v2

    double-to-int v0, v0

    const v1, 0xf4240

    div-int/2addr v0, v1

    return v0
.end method

.method public reset()V
    .locals 4

    .prologue
    const-wide/16 v2, -0x1

    const/4 v0, 0x0

    .line 200
    iput-wide v2, p0, Lcom/facebook/react/modules/debug/FpsDebugFrameCallback;->mFirstFrameTime:J

    .line 201
    iput-wide v2, p0, Lcom/facebook/react/modules/debug/FpsDebugFrameCallback;->mLastFrameTime:J

    .line 202
    iput v0, p0, Lcom/facebook/react/modules/debug/FpsDebugFrameCallback;->mNumFrameCallbacks:I

    .line 203
    iput v0, p0, Lcom/facebook/react/modules/debug/FpsDebugFrameCallback;->m4PlusFrameStutters:I

    .line 204
    iput v0, p0, Lcom/facebook/react/modules/debug/FpsDebugFrameCallback;->mNumFrameCallbacksWithBatchDispatches:I

    .line 205
    iput-boolean v0, p0, Lcom/facebook/react/modules/debug/FpsDebugFrameCallback;->mIsRecordingFpsInfoAtEachFrame:Z

    .line 206
    const/4 v0, 0x0

    iput-object v0, p0, Lcom/facebook/react/modules/debug/FpsDebugFrameCallback;->mTimeToFps:Ljava/util/TreeMap;

    .line 207
    return-void
.end method

.method public start()V
    .locals 2

    .prologue
    .line 130
    const/4 v0, 0x0

    iput-boolean v0, p0, Lcom/facebook/react/modules/debug/FpsDebugFrameCallback;->mShouldStop:Z

    .line 131
    iget-object v0, p0, Lcom/facebook/react/modules/debug/FpsDebugFrameCallback;->mReactContext:Lcom/facebook/react/bridge/ReactContext;

    invoke-virtual {v0}, Lcom/facebook/react/bridge/ReactContext;->getCatalystInstance()Lcom/facebook/react/bridge/CatalystInstance;

    move-result-object v0

    iget-object v1, p0, Lcom/facebook/react/modules/debug/FpsDebugFrameCallback;->mDidJSUpdateUiDuringFrameDetector:Lcom/facebook/react/modules/debug/DidJSUpdateUiDuringFrameDetector;

    invoke-interface {v0, v1}, Lcom/facebook/react/bridge/CatalystInstance;->addBridgeIdleDebugListener(Lcom/facebook/react/bridge/NotThreadSafeBridgeIdleDebugListener;)V

    .line 133
    iget-object v0, p0, Lcom/facebook/react/modules/debug/FpsDebugFrameCallback;->mUIManagerModule:Lcom/facebook/react/uimanager/UIManagerModule;

    iget-object v1, p0, Lcom/facebook/react/modules/debug/FpsDebugFrameCallback;->mDidJSUpdateUiDuringFrameDetector:Lcom/facebook/react/modules/debug/DidJSUpdateUiDuringFrameDetector;

    invoke-virtual {v0, v1}, Lcom/facebook/react/uimanager/UIManagerModule;->setViewHierarchyUpdateDebugListener(Lcom/facebook/react/uimanager/debug/NotThreadSafeViewHierarchyUpdateDebugListener;)V

    .line 134
    iget-object v0, p0, Lcom/facebook/react/modules/debug/FpsDebugFrameCallback;->mChoreographer:Lcom/facebook/react/modules/core/ChoreographerCompat;

    invoke-virtual {v0, p0}, Lcom/facebook/react/modules/core/ChoreographerCompat;->postFrameCallback(Lcom/facebook/react/modules/core/ChoreographerCompat$FrameCallback;)V

    .line 135
    return-void
.end method

.method public startAndRecordFpsAtEachFrame()V
    .locals 1

    .prologue
    .line 138
    new-instance v0, Ljava/util/TreeMap;

    invoke-direct {v0}, Ljava/util/TreeMap;-><init>()V

    iput-object v0, p0, Lcom/facebook/react/modules/debug/FpsDebugFrameCallback;->mTimeToFps:Ljava/util/TreeMap;

    .line 139
    const/4 v0, 0x1

    iput-boolean v0, p0, Lcom/facebook/react/modules/debug/FpsDebugFrameCallback;->mIsRecordingFpsInfoAtEachFrame:Z

    .line 140
    invoke-virtual {p0}, Lcom/facebook/react/modules/debug/FpsDebugFrameCallback;->start()V

    .line 141
    return-void
.end method

.method public stop()V
    .locals 2

    .prologue
    .line 144
    const/4 v0, 0x1

    iput-boolean v0, p0, Lcom/facebook/react/modules/debug/FpsDebugFrameCallback;->mShouldStop:Z

    .line 145
    iget-object v0, p0, Lcom/facebook/react/modules/debug/FpsDebugFrameCallback;->mReactContext:Lcom/facebook/react/bridge/ReactContext;

    invoke-virtual {v0}, Lcom/facebook/react/bridge/ReactContext;->getCatalystInstance()Lcom/facebook/react/bridge/CatalystInstance;

    move-result-object v0

    iget-object v1, p0, Lcom/facebook/react/modules/debug/FpsDebugFrameCallback;->mDidJSUpdateUiDuringFrameDetector:Lcom/facebook/react/modules/debug/DidJSUpdateUiDuringFrameDetector;

    invoke-interface {v0, v1}, Lcom/facebook/react/bridge/CatalystInstance;->removeBridgeIdleDebugListener(Lcom/facebook/react/bridge/NotThreadSafeBridgeIdleDebugListener;)V

    .line 147
    iget-object v0, p0, Lcom/facebook/react/modules/debug/FpsDebugFrameCallback;->mUIManagerModule:Lcom/facebook/react/uimanager/UIManagerModule;

    const/4 v1, 0x0

    invoke-virtual {v0, v1}, Lcom/facebook/react/uimanager/UIManagerModule;->setViewHierarchyUpdateDebugListener(Lcom/facebook/react/uimanager/debug/NotThreadSafeViewHierarchyUpdateDebugListener;)V

    .line 148
    return-void
.end method

.class Lcom/facebook/react/animated/FrameBasedAnimationDriver;
.super Lcom/facebook/react/animated/AnimationDriver;
.source "FrameBasedAnimationDriver.java"


# static fields
.field private static final FRAME_TIME_MILLIS:D = 16.666666666666668


# instance fields
.field private mCurrentLoop:I

.field private final mFrames:[D

.field private mFromValue:D

.field private mIterations:I

.field private mStartFrameTimeNanos:J

.field private final mToValue:D


# direct methods
.method constructor <init>(Lcom/facebook/react/bridge/ReadableMap;)V
    .locals 8
    .param p1, "config"    # Lcom/facebook/react/bridge/ReadableMap;

    .prologue
    const/4 v4, 0x1

    .line 32
    invoke-direct {p0}, Lcom/facebook/react/animated/AnimationDriver;-><init>()V

    .line 25
    const-wide/16 v6, -0x1

    iput-wide v6, p0, Lcom/facebook/react/animated/FrameBasedAnimationDriver;->mStartFrameTimeNanos:J

    .line 33
    const-string v3, "frames"

    invoke-interface {p1, v3}, Lcom/facebook/react/bridge/ReadableMap;->getArray(Ljava/lang/String;)Lcom/facebook/react/bridge/ReadableArray;

    move-result-object v0

    .line 34
    .local v0, "frames":Lcom/facebook/react/bridge/ReadableArray;
    invoke-interface {v0}, Lcom/facebook/react/bridge/ReadableArray;->size()I

    move-result v2

    .line 35
    .local v2, "numberOfFrames":I
    new-array v3, v2, [D

    iput-object v3, p0, Lcom/facebook/react/animated/FrameBasedAnimationDriver;->mFrames:[D

    .line 36
    const/4 v1, 0x0

    .local v1, "i":I
    :goto_0
    if-ge v1, v2, :cond_0

    .line 37
    iget-object v3, p0, Lcom/facebook/react/animated/FrameBasedAnimationDriver;->mFrames:[D

    invoke-interface {v0, v1}, Lcom/facebook/react/bridge/ReadableArray;->getDouble(I)D

    move-result-wide v6

    aput-wide v6, v3, v1

    .line 36
    add-int/lit8 v1, v1, 0x1

    goto :goto_0

    .line 39
    :cond_0
    const-string v3, "toValue"

    invoke-interface {p1, v3}, Lcom/facebook/react/bridge/ReadableMap;->getDouble(Ljava/lang/String;)D

    move-result-wide v6

    iput-wide v6, p0, Lcom/facebook/react/animated/FrameBasedAnimationDriver;->mToValue:D

    .line 40
    const-string v3, "iterations"

    invoke-interface {p1, v3}, Lcom/facebook/react/bridge/ReadableMap;->hasKey(Ljava/lang/String;)Z

    move-result v3

    if-eqz v3, :cond_1

    const-string v3, "iterations"

    invoke-interface {p1, v3}, Lcom/facebook/react/bridge/ReadableMap;->getInt(Ljava/lang/String;)I

    move-result v3

    :goto_1
    iput v3, p0, Lcom/facebook/react/animated/FrameBasedAnimationDriver;->mIterations:I

    .line 41
    iput v4, p0, Lcom/facebook/react/animated/FrameBasedAnimationDriver;->mCurrentLoop:I

    .line 42
    iget v3, p0, Lcom/facebook/react/animated/FrameBasedAnimationDriver;->mIterations:I

    if-nez v3, :cond_2

    :goto_2
    iput-boolean v4, p0, Lcom/facebook/react/animated/FrameBasedAnimationDriver;->mHasFinished:Z

    .line 43
    return-void

    :cond_1
    move v3, v4

    .line 40
    goto :goto_1

    .line 42
    :cond_2
    const/4 v4, 0x0

    goto :goto_2
.end method


# virtual methods
.method public runAnimationStep(J)V
    .locals 19
    .param p1, "frameTimeNanos"    # J

    .prologue
    .line 47
    move-object/from16 v0, p0

    iget-wide v10, v0, Lcom/facebook/react/animated/FrameBasedAnimationDriver;->mStartFrameTimeNanos:J

    const-wide/16 v12, 0x0

    cmp-long v5, v10, v12

    if-gez v5, :cond_0

    .line 48
    move-wide/from16 v0, p1

    move-object/from16 v2, p0

    iput-wide v0, v2, Lcom/facebook/react/animated/FrameBasedAnimationDriver;->mStartFrameTimeNanos:J

    .line 49
    move-object/from16 v0, p0

    iget-object v5, v0, Lcom/facebook/react/animated/FrameBasedAnimationDriver;->mAnimatedValue:Lcom/facebook/react/animated/ValueAnimatedNode;

    iget-wide v10, v5, Lcom/facebook/react/animated/ValueAnimatedNode;->mValue:D

    move-object/from16 v0, p0

    iput-wide v10, v0, Lcom/facebook/react/animated/FrameBasedAnimationDriver;->mFromValue:D

    .line 51
    :cond_0
    move-object/from16 v0, p0

    iget-wide v10, v0, Lcom/facebook/react/animated/FrameBasedAnimationDriver;->mStartFrameTimeNanos:J

    sub-long v10, p1, v10

    const-wide/32 v12, 0xf4240

    div-long v8, v10, v12

    .line 52
    .local v8, "timeFromStartMillis":J
    long-to-double v10, v8

    const-wide v12, 0x4030aaaaaaaaaaabL    # 16.666666666666668

    div-double/2addr v10, v12

    double-to-int v4, v10

    .line 53
    .local v4, "frameIndex":I
    if-gez v4, :cond_1

    .line 54
    new-instance v5, Ljava/lang/IllegalStateException;

    const-string v10, "Calculated frame index should never be lower than 0"

    invoke-direct {v5, v10}, Ljava/lang/IllegalStateException;-><init>(Ljava/lang/String;)V

    throw v5

    .line 55
    :cond_1
    move-object/from16 v0, p0

    iget-boolean v5, v0, Lcom/facebook/react/animated/FrameBasedAnimationDriver;->mHasFinished:Z

    if-eqz v5, :cond_2

    .line 72
    :goto_0
    return-void

    .line 60
    :cond_2
    move-object/from16 v0, p0

    iget-object v5, v0, Lcom/facebook/react/animated/FrameBasedAnimationDriver;->mFrames:[D

    array-length v5, v5

    add-int/lit8 v5, v5, -0x1

    if-lt v4, v5, :cond_5

    .line 61
    move-object/from16 v0, p0

    iget-wide v6, v0, Lcom/facebook/react/animated/FrameBasedAnimationDriver;->mToValue:D

    .line 62
    .local v6, "nextValue":D
    move-object/from16 v0, p0

    iget v5, v0, Lcom/facebook/react/animated/FrameBasedAnimationDriver;->mIterations:I

    const/4 v10, -0x1

    if-eq v5, v10, :cond_3

    move-object/from16 v0, p0

    iget v5, v0, Lcom/facebook/react/animated/FrameBasedAnimationDriver;->mCurrentLoop:I

    move-object/from16 v0, p0

    iget v10, v0, Lcom/facebook/react/animated/FrameBasedAnimationDriver;->mIterations:I

    if-ge v5, v10, :cond_4

    .line 63
    :cond_3
    move-wide/from16 v0, p1

    move-object/from16 v2, p0

    iput-wide v0, v2, Lcom/facebook/react/animated/FrameBasedAnimationDriver;->mStartFrameTimeNanos:J

    .line 64
    move-object/from16 v0, p0

    iget v5, v0, Lcom/facebook/react/animated/FrameBasedAnimationDriver;->mCurrentLoop:I

    add-int/lit8 v5, v5, 0x1

    move-object/from16 v0, p0

    iput v5, v0, Lcom/facebook/react/animated/FrameBasedAnimationDriver;->mCurrentLoop:I

    .line 71
    :goto_1
    move-object/from16 v0, p0

    iget-object v5, v0, Lcom/facebook/react/animated/FrameBasedAnimationDriver;->mAnimatedValue:Lcom/facebook/react/animated/ValueAnimatedNode;

    iput-wide v6, v5, Lcom/facebook/react/animated/ValueAnimatedNode;->mValue:D

    goto :goto_0

    .line 66
    :cond_4
    const/4 v5, 0x1

    move-object/from16 v0, p0

    iput-boolean v5, v0, Lcom/facebook/react/animated/FrameBasedAnimationDriver;->mHasFinished:Z

    goto :goto_1

    .line 69
    .end local v6    # "nextValue":D
    :cond_5
    move-object/from16 v0, p0

    iget-wide v10, v0, Lcom/facebook/react/animated/FrameBasedAnimationDriver;->mFromValue:D

    move-object/from16 v0, p0

    iget-object v5, v0, Lcom/facebook/react/animated/FrameBasedAnimationDriver;->mFrames:[D

    aget-wide v12, v5, v4

    move-object/from16 v0, p0

    iget-wide v14, v0, Lcom/facebook/react/animated/FrameBasedAnimationDriver;->mToValue:D

    move-object/from16 v0, p0

    iget-wide v0, v0, Lcom/facebook/react/animated/FrameBasedAnimationDriver;->mFromValue:D

    move-wide/from16 v16, v0

    sub-double v14, v14, v16

    mul-double/2addr v12, v14

    add-double v6, v10, v12

    .restart local v6    # "nextValue":D
    goto :goto_1
.end method

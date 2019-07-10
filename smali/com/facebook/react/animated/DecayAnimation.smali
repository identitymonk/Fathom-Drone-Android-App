.class public Lcom/facebook/react/animated/DecayAnimation;
.super Lcom/facebook/react/animated/AnimationDriver;
.source "DecayAnimation.java"


# instance fields
.field private mCurrentLoop:I

.field private final mDeceleration:D

.field private mFromValue:D

.field private mIterations:I

.field private mLastValue:D

.field private mStartFrameTimeMillis:J

.field private final mVelocity:D


# direct methods
.method public constructor <init>(Lcom/facebook/react/bridge/ReadableMap;)V
    .locals 6
    .param p1, "config"    # Lcom/facebook/react/bridge/ReadableMap;

    .prologue
    const-wide/16 v4, 0x0

    const/4 v1, 0x1

    .line 29
    invoke-direct {p0}, Lcom/facebook/react/animated/AnimationDriver;-><init>()V

    .line 23
    const-wide/16 v2, -0x1

    iput-wide v2, p0, Lcom/facebook/react/animated/DecayAnimation;->mStartFrameTimeMillis:J

    .line 24
    iput-wide v4, p0, Lcom/facebook/react/animated/DecayAnimation;->mFromValue:D

    .line 25
    iput-wide v4, p0, Lcom/facebook/react/animated/DecayAnimation;->mLastValue:D

    .line 30
    const-string v0, "velocity"

    invoke-interface {p1, v0}, Lcom/facebook/react/bridge/ReadableMap;->getDouble(Ljava/lang/String;)D

    move-result-wide v2

    iput-wide v2, p0, Lcom/facebook/react/animated/DecayAnimation;->mVelocity:D

    .line 31
    const-string v0, "deceleration"

    invoke-interface {p1, v0}, Lcom/facebook/react/bridge/ReadableMap;->getDouble(Ljava/lang/String;)D

    move-result-wide v2

    iput-wide v2, p0, Lcom/facebook/react/animated/DecayAnimation;->mDeceleration:D

    .line 32
    const-string v0, "iterations"

    invoke-interface {p1, v0}, Lcom/facebook/react/bridge/ReadableMap;->hasKey(Ljava/lang/String;)Z

    move-result v0

    if-eqz v0, :cond_0

    const-string v0, "iterations"

    invoke-interface {p1, v0}, Lcom/facebook/react/bridge/ReadableMap;->getInt(Ljava/lang/String;)I

    move-result v0

    :goto_0
    iput v0, p0, Lcom/facebook/react/animated/DecayAnimation;->mIterations:I

    .line 33
    iput v1, p0, Lcom/facebook/react/animated/DecayAnimation;->mCurrentLoop:I

    .line 34
    iget v0, p0, Lcom/facebook/react/animated/DecayAnimation;->mIterations:I

    if-nez v0, :cond_1

    :goto_1
    iput-boolean v1, p0, Lcom/facebook/react/animated/DecayAnimation;->mHasFinished:Z

    .line 35
    return-void

    :cond_0
    move v0, v1

    .line 32
    goto :goto_0

    .line 34
    :cond_1
    const/4 v1, 0x0

    goto :goto_1
.end method


# virtual methods
.method public runAnimationStep(J)V
    .locals 15
    .param p1, "frameTimeNanos"    # J

    .prologue
    .line 39
    const-wide/32 v4, 0xf4240

    div-long v0, p1, v4

    .line 40
    .local v0, "frameTimeMillis":J
    iget-wide v4, p0, Lcom/facebook/react/animated/DecayAnimation;->mStartFrameTimeMillis:J

    const-wide/16 v6, -0x1

    cmp-long v4, v4, v6

    if-nez v4, :cond_0

    .line 42
    const-wide/16 v4, 0x10

    sub-long v4, v0, v4

    iput-wide v4, p0, Lcom/facebook/react/animated/DecayAnimation;->mStartFrameTimeMillis:J

    .line 43
    iget-wide v4, p0, Lcom/facebook/react/animated/DecayAnimation;->mFromValue:D

    iget-wide v6, p0, Lcom/facebook/react/animated/DecayAnimation;->mLastValue:D

    cmpl-double v4, v4, v6

    if-nez v4, :cond_3

    .line 44
    iget-object v4, p0, Lcom/facebook/react/animated/DecayAnimation;->mAnimatedValue:Lcom/facebook/react/animated/ValueAnimatedNode;

    iget-wide v4, v4, Lcom/facebook/react/animated/ValueAnimatedNode;->mValue:D

    iput-wide v4, p0, Lcom/facebook/react/animated/DecayAnimation;->mFromValue:D

    .line 48
    :goto_0
    iget-object v4, p0, Lcom/facebook/react/animated/DecayAnimation;->mAnimatedValue:Lcom/facebook/react/animated/ValueAnimatedNode;

    iget-wide v4, v4, Lcom/facebook/react/animated/ValueAnimatedNode;->mValue:D

    iput-wide v4, p0, Lcom/facebook/react/animated/DecayAnimation;->mLastValue:D

    .line 51
    :cond_0
    iget-wide v4, p0, Lcom/facebook/react/animated/DecayAnimation;->mFromValue:D

    iget-wide v6, p0, Lcom/facebook/react/animated/DecayAnimation;->mVelocity:D

    const-wide/high16 v8, 0x3ff0000000000000L    # 1.0

    iget-wide v10, p0, Lcom/facebook/react/animated/DecayAnimation;->mDeceleration:D

    sub-double/2addr v8, v10

    div-double/2addr v6, v8

    const-wide/high16 v8, 0x3ff0000000000000L    # 1.0

    const-wide/high16 v10, 0x3ff0000000000000L    # 1.0

    iget-wide v12, p0, Lcom/facebook/react/animated/DecayAnimation;->mDeceleration:D

    sub-double/2addr v10, v12

    neg-double v10, v10

    iget-wide v12, p0, Lcom/facebook/react/animated/DecayAnimation;->mStartFrameTimeMillis:J

    sub-long v12, v0, v12

    long-to-double v12, v12

    mul-double/2addr v10, v12

    .line 53
    invoke-static {v10, v11}, Ljava/lang/Math;->exp(D)D

    move-result-wide v10

    sub-double/2addr v8, v10

    mul-double/2addr v6, v8

    add-double v2, v4, v6

    .line 55
    .local v2, "value":D
    iget-wide v4, p0, Lcom/facebook/react/animated/DecayAnimation;->mLastValue:D

    sub-double/2addr v4, v2

    invoke-static {v4, v5}, Ljava/lang/Math;->abs(D)D

    move-result-wide v4

    const-wide v6, 0x3fb999999999999aL    # 0.1

    cmpg-double v4, v4, v6

    if-gez v4, :cond_2

    .line 57
    iget v4, p0, Lcom/facebook/react/animated/DecayAnimation;->mIterations:I

    const/4 v5, -0x1

    if-eq v4, v5, :cond_1

    iget v4, p0, Lcom/facebook/react/animated/DecayAnimation;->mCurrentLoop:I

    iget v5, p0, Lcom/facebook/react/animated/DecayAnimation;->mIterations:I

    if-ge v4, v5, :cond_4

    .line 59
    :cond_1
    const-wide/16 v4, -0x1

    iput-wide v4, p0, Lcom/facebook/react/animated/DecayAnimation;->mStartFrameTimeMillis:J

    .line 60
    iget v4, p0, Lcom/facebook/react/animated/DecayAnimation;->mCurrentLoop:I

    add-int/lit8 v4, v4, 0x1

    iput v4, p0, Lcom/facebook/react/animated/DecayAnimation;->mCurrentLoop:I

    .line 67
    :cond_2
    iput-wide v2, p0, Lcom/facebook/react/animated/DecayAnimation;->mLastValue:D

    .line 68
    iget-object v4, p0, Lcom/facebook/react/animated/DecayAnimation;->mAnimatedValue:Lcom/facebook/react/animated/ValueAnimatedNode;

    iput-wide v2, v4, Lcom/facebook/react/animated/ValueAnimatedNode;->mValue:D

    .line 69
    :goto_1
    return-void

    .line 46
    .end local v2    # "value":D
    :cond_3
    iget-object v4, p0, Lcom/facebook/react/animated/DecayAnimation;->mAnimatedValue:Lcom/facebook/react/animated/ValueAnimatedNode;

    iget-wide v6, p0, Lcom/facebook/react/animated/DecayAnimation;->mFromValue:D

    iput-wide v6, v4, Lcom/facebook/react/animated/ValueAnimatedNode;->mValue:D

    goto :goto_0

    .line 62
    .restart local v2    # "value":D
    :cond_4
    const/4 v4, 0x1

    iput-boolean v4, p0, Lcom/facebook/react/animated/DecayAnimation;->mHasFinished:Z

    goto :goto_1
.end method

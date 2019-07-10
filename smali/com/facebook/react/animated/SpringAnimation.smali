.class Lcom/facebook/react/animated/SpringAnimation;
.super Lcom/facebook/react/animated/AnimationDriver;
.source "SpringAnimation.java"


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lcom/facebook/react/animated/SpringAnimation$PhysicsState;
    }
.end annotation


# static fields
.field private static final MAX_DELTA_TIME_SEC:D = 0.064

.field private static final SOLVER_TIMESTEP_SEC:D = 0.001


# instance fields
.field private mCurrentLoop:I

.field private final mCurrentState:Lcom/facebook/react/animated/SpringAnimation$PhysicsState;

.field private mDisplacementFromRestThreshold:D

.field private mEndValue:D

.field private mInitialVelocity:D

.field private mIterations:I

.field private mLastTime:J

.field private mOriginalValue:D

.field private mOvershootClampingEnabled:Z

.field private mRestSpeedThreshold:D

.field private mSpringDamping:D

.field private mSpringMass:D

.field private mSpringStarted:Z

.field private mSpringStiffness:D

.field private mStartValue:D

.field private mTimeAccumulator:D


# direct methods
.method constructor <init>(Lcom/facebook/react/bridge/ReadableMap;)V
    .locals 6
    .param p1, "config"    # Lcom/facebook/react/bridge/ReadableMap;

    .prologue
    const/4 v1, 0x1

    const/4 v2, 0x0

    .line 46
    invoke-direct {p0}, Lcom/facebook/react/animated/AnimationDriver;-><init>()V

    .line 34
    new-instance v0, Lcom/facebook/react/animated/SpringAnimation$PhysicsState;

    const/4 v3, 0x0

    invoke-direct {v0, v3}, Lcom/facebook/react/animated/SpringAnimation$PhysicsState;-><init>(Lcom/facebook/react/animated/SpringAnimation$1;)V

    iput-object v0, p0, Lcom/facebook/react/animated/SpringAnimation;->mCurrentState:Lcom/facebook/react/animated/SpringAnimation$PhysicsState;

    .line 40
    const-wide/16 v4, 0x0

    iput-wide v4, p0, Lcom/facebook/react/animated/SpringAnimation;->mTimeAccumulator:D

    .line 43
    iput v2, p0, Lcom/facebook/react/animated/SpringAnimation;->mCurrentLoop:I

    .line 47
    const-string v0, "stiffness"

    invoke-interface {p1, v0}, Lcom/facebook/react/bridge/ReadableMap;->getDouble(Ljava/lang/String;)D

    move-result-wide v4

    iput-wide v4, p0, Lcom/facebook/react/animated/SpringAnimation;->mSpringStiffness:D

    .line 48
    const-string v0, "damping"

    invoke-interface {p1, v0}, Lcom/facebook/react/bridge/ReadableMap;->getDouble(Ljava/lang/String;)D

    move-result-wide v4

    iput-wide v4, p0, Lcom/facebook/react/animated/SpringAnimation;->mSpringDamping:D

    .line 49
    const-string v0, "mass"

    invoke-interface {p1, v0}, Lcom/facebook/react/bridge/ReadableMap;->getDouble(Ljava/lang/String;)D

    move-result-wide v4

    iput-wide v4, p0, Lcom/facebook/react/animated/SpringAnimation;->mSpringMass:D

    .line 50
    const-string v0, "initialVelocity"

    invoke-interface {p1, v0}, Lcom/facebook/react/bridge/ReadableMap;->getDouble(Ljava/lang/String;)D

    move-result-wide v4

    iput-wide v4, p0, Lcom/facebook/react/animated/SpringAnimation;->mInitialVelocity:D

    .line 51
    iget-object v0, p0, Lcom/facebook/react/animated/SpringAnimation;->mCurrentState:Lcom/facebook/react/animated/SpringAnimation$PhysicsState;

    iget-wide v4, p0, Lcom/facebook/react/animated/SpringAnimation;->mInitialVelocity:D

    iput-wide v4, v0, Lcom/facebook/react/animated/SpringAnimation$PhysicsState;->velocity:D

    .line 52
    const-string v0, "toValue"

    invoke-interface {p1, v0}, Lcom/facebook/react/bridge/ReadableMap;->getDouble(Ljava/lang/String;)D

    move-result-wide v4

    iput-wide v4, p0, Lcom/facebook/react/animated/SpringAnimation;->mEndValue:D

    .line 53
    const-string v0, "restSpeedThreshold"

    invoke-interface {p1, v0}, Lcom/facebook/react/bridge/ReadableMap;->getDouble(Ljava/lang/String;)D

    move-result-wide v4

    iput-wide v4, p0, Lcom/facebook/react/animated/SpringAnimation;->mRestSpeedThreshold:D

    .line 54
    const-string v0, "restDisplacementThreshold"

    invoke-interface {p1, v0}, Lcom/facebook/react/bridge/ReadableMap;->getDouble(Ljava/lang/String;)D

    move-result-wide v4

    iput-wide v4, p0, Lcom/facebook/react/animated/SpringAnimation;->mDisplacementFromRestThreshold:D

    .line 55
    const-string v0, "overshootClamping"

    invoke-interface {p1, v0}, Lcom/facebook/react/bridge/ReadableMap;->getBoolean(Ljava/lang/String;)Z

    move-result v0

    iput-boolean v0, p0, Lcom/facebook/react/animated/SpringAnimation;->mOvershootClampingEnabled:Z

    .line 56
    const-string v0, "iterations"

    invoke-interface {p1, v0}, Lcom/facebook/react/bridge/ReadableMap;->hasKey(Ljava/lang/String;)Z

    move-result v0

    if-eqz v0, :cond_0

    const-string v0, "iterations"

    invoke-interface {p1, v0}, Lcom/facebook/react/bridge/ReadableMap;->getInt(Ljava/lang/String;)I

    move-result v0

    :goto_0
    iput v0, p0, Lcom/facebook/react/animated/SpringAnimation;->mIterations:I

    .line 57
    iget v0, p0, Lcom/facebook/react/animated/SpringAnimation;->mIterations:I

    if-nez v0, :cond_1

    :goto_1
    iput-boolean v1, p0, Lcom/facebook/react/animated/SpringAnimation;->mHasFinished:Z

    .line 58
    return-void

    :cond_0
    move v0, v1

    .line 56
    goto :goto_0

    :cond_1
    move v1, v2

    .line 57
    goto :goto_1
.end method

.method private advance(D)V
    .locals 39
    .param p1, "realDeltaTime"    # D

    .prologue
    .line 117
    invoke-direct/range {p0 .. p0}, Lcom/facebook/react/animated/SpringAnimation;->isAtRest()Z

    move-result v30

    if-eqz v30, :cond_1

    .line 187
    :cond_0
    :goto_0
    return-void

    .line 123
    :cond_1
    move-wide/from16 v4, p1

    .line 124
    .local v4, "adjustedDeltaTime":D
    const-wide v30, 0x3fb0624dd2f1a9fcL    # 0.064

    cmpl-double v30, p1, v30

    if-lez v30, :cond_2

    .line 125
    const-wide v4, 0x3fb0624dd2f1a9fcL    # 0.064

    .line 128
    :cond_2
    move-object/from16 v0, p0

    iget-wide v0, v0, Lcom/facebook/react/animated/SpringAnimation;->mTimeAccumulator:D

    move-wide/from16 v30, v0

    add-double v30, v30, v4

    move-wide/from16 v0, v30

    move-object/from16 v2, p0

    iput-wide v0, v2, Lcom/facebook/react/animated/SpringAnimation;->mTimeAccumulator:D

    .line 130
    move-object/from16 v0, p0

    iget-wide v6, v0, Lcom/facebook/react/animated/SpringAnimation;->mSpringDamping:D

    .line 131
    .local v6, "c":D
    move-object/from16 v0, p0

    iget-wide v12, v0, Lcom/facebook/react/animated/SpringAnimation;->mSpringMass:D

    .line 132
    .local v12, "m":D
    move-object/from16 v0, p0

    iget-wide v10, v0, Lcom/facebook/react/animated/SpringAnimation;->mSpringStiffness:D

    .line 133
    .local v10, "k":D
    move-object/from16 v0, p0

    iget-wide v0, v0, Lcom/facebook/react/animated/SpringAnimation;->mInitialVelocity:D

    move-wide/from16 v30, v0

    move-wide/from16 v0, v30

    neg-double v0, v0

    move-wide/from16 v22, v0

    .line 135
    .local v22, "v0":D
    const-wide/high16 v30, 0x4000000000000000L    # 2.0

    mul-double v32, v10, v12

    invoke-static/range {v32 .. v33}, Ljava/lang/Math;->sqrt(D)D

    move-result-wide v32

    mul-double v30, v30, v32

    div-double v28, v6, v30

    .line 136
    .local v28, "zeta":D
    div-double v30, v10, v12

    invoke-static/range {v30 .. v31}, Ljava/lang/Math;->sqrt(D)D

    move-result-wide v14

    .line 137
    .local v14, "omega0":D
    const-wide/high16 v30, 0x3ff0000000000000L    # 1.0

    mul-double v32, v28, v28

    sub-double v30, v30, v32

    invoke-static/range {v30 .. v31}, Ljava/lang/Math;->sqrt(D)D

    move-result-wide v30

    mul-double v16, v14, v30

    .line 138
    .local v16, "omega1":D
    move-object/from16 v0, p0

    iget-wide v0, v0, Lcom/facebook/react/animated/SpringAnimation;->mEndValue:D

    move-wide/from16 v30, v0

    move-object/from16 v0, p0

    iget-wide v0, v0, Lcom/facebook/react/animated/SpringAnimation;->mStartValue:D

    move-wide/from16 v32, v0

    sub-double v26, v30, v32

    .line 142
    .local v26, "x0":D
    move-object/from16 v0, p0

    iget-wide v0, v0, Lcom/facebook/react/animated/SpringAnimation;->mTimeAccumulator:D

    move-wide/from16 v20, v0

    .line 143
    .local v20, "t":D
    const-wide/high16 v30, 0x3ff0000000000000L    # 1.0

    cmpg-double v30, v28, v30

    if-gez v30, :cond_4

    .line 145
    move-wide/from16 v0, v28

    neg-double v0, v0

    move-wide/from16 v30, v0

    mul-double v30, v30, v14

    mul-double v30, v30, v20

    invoke-static/range {v30 .. v31}, Ljava/lang/Math;->exp(D)D

    move-result-wide v8

    .line 146
    .local v8, "envelope":D
    move-object/from16 v0, p0

    iget-wide v0, v0, Lcom/facebook/react/animated/SpringAnimation;->mEndValue:D

    move-wide/from16 v30, v0

    mul-double v32, v28, v14

    mul-double v32, v32, v26

    add-double v32, v32, v22

    div-double v32, v32, v16

    mul-double v34, v16, v20

    .line 149
    invoke-static/range {v34 .. v35}, Ljava/lang/Math;->sin(D)D

    move-result-wide v34

    mul-double v32, v32, v34

    mul-double v34, v16, v20

    .line 150
    invoke-static/range {v34 .. v35}, Ljava/lang/Math;->cos(D)D

    move-result-wide v34

    mul-double v34, v34, v26

    add-double v32, v32, v34

    mul-double v32, v32, v8

    sub-double v18, v30, v32

    .line 153
    .local v18, "position":D
    mul-double v30, v28, v14

    mul-double v30, v30, v8

    mul-double v32, v16, v20

    .line 157
    invoke-static/range {v32 .. v33}, Ljava/lang/Math;->sin(D)D

    move-result-wide v32

    mul-double v34, v28, v14

    mul-double v34, v34, v26

    add-double v34, v34, v22

    mul-double v32, v32, v34

    div-double v32, v32, v16

    mul-double v34, v16, v20

    .line 158
    invoke-static/range {v34 .. v35}, Ljava/lang/Math;->cos(D)D

    move-result-wide v34

    mul-double v34, v34, v26

    add-double v32, v32, v34

    mul-double v30, v30, v32

    mul-double v32, v16, v20

    .line 160
    invoke-static/range {v32 .. v33}, Ljava/lang/Math;->cos(D)D

    move-result-wide v32

    mul-double v34, v28, v14

    mul-double v34, v34, v26

    add-double v34, v34, v22

    mul-double v32, v32, v34

    mul-double v34, v16, v26

    mul-double v36, v16, v20

    .line 161
    invoke-static/range {v36 .. v37}, Ljava/lang/Math;->sin(D)D

    move-result-wide v36

    mul-double v34, v34, v36

    sub-double v32, v32, v34

    mul-double v32, v32, v8

    sub-double v24, v30, v32

    .line 170
    .local v24, "velocity":D
    :goto_1
    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/facebook/react/animated/SpringAnimation;->mCurrentState:Lcom/facebook/react/animated/SpringAnimation$PhysicsState;

    move-object/from16 v30, v0

    move-wide/from16 v0, v18

    move-object/from16 v2, v30

    iput-wide v0, v2, Lcom/facebook/react/animated/SpringAnimation$PhysicsState;->position:D

    .line 171
    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/facebook/react/animated/SpringAnimation;->mCurrentState:Lcom/facebook/react/animated/SpringAnimation$PhysicsState;

    move-object/from16 v30, v0

    move-wide/from16 v0, v24

    move-object/from16 v2, v30

    iput-wide v0, v2, Lcom/facebook/react/animated/SpringAnimation$PhysicsState;->velocity:D

    .line 176
    invoke-direct/range {p0 .. p0}, Lcom/facebook/react/animated/SpringAnimation;->isAtRest()Z

    move-result v30

    if-nez v30, :cond_3

    move-object/from16 v0, p0

    iget-boolean v0, v0, Lcom/facebook/react/animated/SpringAnimation;->mOvershootClampingEnabled:Z

    move/from16 v30, v0

    if-eqz v30, :cond_0

    invoke-direct/range {p0 .. p0}, Lcom/facebook/react/animated/SpringAnimation;->isOvershooting()Z

    move-result v30

    if-eqz v30, :cond_0

    .line 178
    :cond_3
    move-object/from16 v0, p0

    iget-wide v0, v0, Lcom/facebook/react/animated/SpringAnimation;->mSpringStiffness:D

    move-wide/from16 v30, v0

    const-wide/16 v32, 0x0

    cmpl-double v30, v30, v32

    if-lez v30, :cond_5

    .line 179
    move-object/from16 v0, p0

    iget-wide v0, v0, Lcom/facebook/react/animated/SpringAnimation;->mEndValue:D

    move-wide/from16 v30, v0

    move-wide/from16 v0, v30

    move-object/from16 v2, p0

    iput-wide v0, v2, Lcom/facebook/react/animated/SpringAnimation;->mStartValue:D

    .line 180
    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/facebook/react/animated/SpringAnimation;->mCurrentState:Lcom/facebook/react/animated/SpringAnimation$PhysicsState;

    move-object/from16 v30, v0

    move-object/from16 v0, p0

    iget-wide v0, v0, Lcom/facebook/react/animated/SpringAnimation;->mEndValue:D

    move-wide/from16 v32, v0

    move-wide/from16 v0, v32

    move-object/from16 v2, v30

    iput-wide v0, v2, Lcom/facebook/react/animated/SpringAnimation$PhysicsState;->position:D

    .line 185
    :goto_2
    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/facebook/react/animated/SpringAnimation;->mCurrentState:Lcom/facebook/react/animated/SpringAnimation$PhysicsState;

    move-object/from16 v30, v0

    const-wide/16 v32, 0x0

    move-wide/from16 v0, v32

    move-object/from16 v2, v30

    iput-wide v0, v2, Lcom/facebook/react/animated/SpringAnimation$PhysicsState;->velocity:D

    goto/16 :goto_0

    .line 164
    .end local v8    # "envelope":D
    .end local v18    # "position":D
    .end local v24    # "velocity":D
    :cond_4
    neg-double v0, v14

    move-wide/from16 v30, v0

    mul-double v30, v30, v20

    invoke-static/range {v30 .. v31}, Ljava/lang/Math;->exp(D)D

    move-result-wide v8

    .line 165
    .restart local v8    # "envelope":D
    move-object/from16 v0, p0

    iget-wide v0, v0, Lcom/facebook/react/animated/SpringAnimation;->mEndValue:D

    move-wide/from16 v30, v0

    mul-double v32, v14, v26

    add-double v32, v32, v22

    mul-double v32, v32, v20

    add-double v32, v32, v26

    mul-double v32, v32, v8

    sub-double v18, v30, v32

    .line 166
    .restart local v18    # "position":D
    mul-double v30, v20, v14

    const-wide/high16 v32, 0x3ff0000000000000L    # 1.0

    sub-double v30, v30, v32

    mul-double v30, v30, v22

    mul-double v32, v20, v26

    mul-double v34, v14, v14

    mul-double v32, v32, v34

    add-double v30, v30, v32

    mul-double v24, v8, v30

    .restart local v24    # "velocity":D
    goto/16 :goto_1

    .line 182
    :cond_5
    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/facebook/react/animated/SpringAnimation;->mCurrentState:Lcom/facebook/react/animated/SpringAnimation$PhysicsState;

    move-object/from16 v30, v0

    move-object/from16 v0, v30

    iget-wide v0, v0, Lcom/facebook/react/animated/SpringAnimation$PhysicsState;->position:D

    move-wide/from16 v30, v0

    move-wide/from16 v0, v30

    move-object/from16 v2, p0

    iput-wide v0, v2, Lcom/facebook/react/animated/SpringAnimation;->mEndValue:D

    .line 183
    move-object/from16 v0, p0

    iget-wide v0, v0, Lcom/facebook/react/animated/SpringAnimation;->mEndValue:D

    move-wide/from16 v30, v0

    move-wide/from16 v0, v30

    move-object/from16 v2, p0

    iput-wide v0, v2, Lcom/facebook/react/animated/SpringAnimation;->mStartValue:D

    goto :goto_2
.end method

.method private getDisplacementDistanceForState(Lcom/facebook/react/animated/SpringAnimation$PhysicsState;)D
    .locals 4
    .param p1, "state"    # Lcom/facebook/react/animated/SpringAnimation$PhysicsState;

    .prologue
    .line 93
    iget-wide v0, p0, Lcom/facebook/react/animated/SpringAnimation;->mEndValue:D

    iget-wide v2, p1, Lcom/facebook/react/animated/SpringAnimation$PhysicsState;->position:D

    sub-double/2addr v0, v2

    invoke-static {v0, v1}, Ljava/lang/Math;->abs(D)D

    move-result-wide v0

    return-wide v0
.end method

.method private isAtRest()Z
    .locals 4

    .prologue
    .line 101
    iget-object v0, p0, Lcom/facebook/react/animated/SpringAnimation;->mCurrentState:Lcom/facebook/react/animated/SpringAnimation$PhysicsState;

    iget-wide v0, v0, Lcom/facebook/react/animated/SpringAnimation$PhysicsState;->velocity:D

    invoke-static {v0, v1}, Ljava/lang/Math;->abs(D)D

    move-result-wide v0

    iget-wide v2, p0, Lcom/facebook/react/animated/SpringAnimation;->mRestSpeedThreshold:D

    cmpg-double v0, v0, v2

    if-gtz v0, :cond_1

    iget-object v0, p0, Lcom/facebook/react/animated/SpringAnimation;->mCurrentState:Lcom/facebook/react/animated/SpringAnimation$PhysicsState;

    .line 102
    invoke-direct {p0, v0}, Lcom/facebook/react/animated/SpringAnimation;->getDisplacementDistanceForState(Lcom/facebook/react/animated/SpringAnimation$PhysicsState;)D

    move-result-wide v0

    iget-wide v2, p0, Lcom/facebook/react/animated/SpringAnimation;->mDisplacementFromRestThreshold:D

    cmpg-double v0, v0, v2

    if-lez v0, :cond_0

    iget-wide v0, p0, Lcom/facebook/react/animated/SpringAnimation;->mSpringStiffness:D

    const-wide/16 v2, 0x0

    cmpl-double v0, v0, v2

    if-nez v0, :cond_1

    :cond_0
    const/4 v0, 0x1

    :goto_0
    return v0

    :cond_1
    const/4 v0, 0x0

    goto :goto_0
.end method

.method private isOvershooting()Z
    .locals 4

    .prologue
    .line 111
    iget-wide v0, p0, Lcom/facebook/react/animated/SpringAnimation;->mSpringStiffness:D

    const-wide/16 v2, 0x0

    cmpl-double v0, v0, v2

    if-lez v0, :cond_2

    iget-wide v0, p0, Lcom/facebook/react/animated/SpringAnimation;->mStartValue:D

    iget-wide v2, p0, Lcom/facebook/react/animated/SpringAnimation;->mEndValue:D

    cmpg-double v0, v0, v2

    if-gez v0, :cond_0

    iget-object v0, p0, Lcom/facebook/react/animated/SpringAnimation;->mCurrentState:Lcom/facebook/react/animated/SpringAnimation$PhysicsState;

    iget-wide v0, v0, Lcom/facebook/react/animated/SpringAnimation$PhysicsState;->position:D

    iget-wide v2, p0, Lcom/facebook/react/animated/SpringAnimation;->mEndValue:D

    cmpl-double v0, v0, v2

    if-gtz v0, :cond_1

    :cond_0
    iget-wide v0, p0, Lcom/facebook/react/animated/SpringAnimation;->mStartValue:D

    iget-wide v2, p0, Lcom/facebook/react/animated/SpringAnimation;->mEndValue:D

    cmpl-double v0, v0, v2

    if-lez v0, :cond_2

    iget-object v0, p0, Lcom/facebook/react/animated/SpringAnimation;->mCurrentState:Lcom/facebook/react/animated/SpringAnimation$PhysicsState;

    iget-wide v0, v0, Lcom/facebook/react/animated/SpringAnimation$PhysicsState;->position:D

    iget-wide v2, p0, Lcom/facebook/react/animated/SpringAnimation;->mEndValue:D

    cmpg-double v0, v0, v2

    if-gez v0, :cond_2

    :cond_1
    const/4 v0, 0x1

    :goto_0
    return v0

    :cond_2
    const/4 v0, 0x0

    goto :goto_0
.end method


# virtual methods
.method public runAnimationStep(J)V
    .locals 7
    .param p1, "frameTimeNanos"    # J

    .prologue
    const/4 v6, 0x1

    .line 62
    const-wide/32 v2, 0xf4240

    div-long v0, p1, v2

    .line 63
    .local v0, "frameTimeMillis":J
    iget-boolean v2, p0, Lcom/facebook/react/animated/SpringAnimation;->mSpringStarted:Z

    if-nez v2, :cond_1

    .line 64
    iget v2, p0, Lcom/facebook/react/animated/SpringAnimation;->mCurrentLoop:I

    if-nez v2, :cond_0

    .line 65
    iget-object v2, p0, Lcom/facebook/react/animated/SpringAnimation;->mAnimatedValue:Lcom/facebook/react/animated/ValueAnimatedNode;

    iget-wide v2, v2, Lcom/facebook/react/animated/ValueAnimatedNode;->mValue:D

    iput-wide v2, p0, Lcom/facebook/react/animated/SpringAnimation;->mOriginalValue:D

    .line 66
    iput v6, p0, Lcom/facebook/react/animated/SpringAnimation;->mCurrentLoop:I

    .line 68
    :cond_0
    iget-object v2, p0, Lcom/facebook/react/animated/SpringAnimation;->mCurrentState:Lcom/facebook/react/animated/SpringAnimation$PhysicsState;

    iget-object v3, p0, Lcom/facebook/react/animated/SpringAnimation;->mAnimatedValue:Lcom/facebook/react/animated/ValueAnimatedNode;

    iget-wide v4, v3, Lcom/facebook/react/animated/ValueAnimatedNode;->mValue:D

    iput-wide v4, v2, Lcom/facebook/react/animated/SpringAnimation$PhysicsState;->position:D

    iput-wide v4, p0, Lcom/facebook/react/animated/SpringAnimation;->mStartValue:D

    .line 69
    iput-wide v0, p0, Lcom/facebook/react/animated/SpringAnimation;->mLastTime:J

    .line 70
    const-wide/16 v2, 0x0

    iput-wide v2, p0, Lcom/facebook/react/animated/SpringAnimation;->mTimeAccumulator:D

    .line 71
    iput-boolean v6, p0, Lcom/facebook/react/animated/SpringAnimation;->mSpringStarted:Z

    .line 73
    :cond_1
    iget-wide v2, p0, Lcom/facebook/react/animated/SpringAnimation;->mLastTime:J

    sub-long v2, v0, v2

    long-to-double v2, v2

    const-wide v4, 0x408f400000000000L    # 1000.0

    div-double/2addr v2, v4

    invoke-direct {p0, v2, v3}, Lcom/facebook/react/animated/SpringAnimation;->advance(D)V

    .line 74
    iput-wide v0, p0, Lcom/facebook/react/animated/SpringAnimation;->mLastTime:J

    .line 75
    iget-object v2, p0, Lcom/facebook/react/animated/SpringAnimation;->mAnimatedValue:Lcom/facebook/react/animated/ValueAnimatedNode;

    iget-object v3, p0, Lcom/facebook/react/animated/SpringAnimation;->mCurrentState:Lcom/facebook/react/animated/SpringAnimation$PhysicsState;

    iget-wide v4, v3, Lcom/facebook/react/animated/SpringAnimation$PhysicsState;->position:D

    iput-wide v4, v2, Lcom/facebook/react/animated/ValueAnimatedNode;->mValue:D

    .line 76
    invoke-direct {p0}, Lcom/facebook/react/animated/SpringAnimation;->isAtRest()Z

    move-result v2

    if-eqz v2, :cond_3

    .line 77
    iget v2, p0, Lcom/facebook/react/animated/SpringAnimation;->mIterations:I

    const/4 v3, -0x1

    if-eq v2, v3, :cond_2

    iget v2, p0, Lcom/facebook/react/animated/SpringAnimation;->mCurrentLoop:I

    iget v3, p0, Lcom/facebook/react/animated/SpringAnimation;->mIterations:I

    if-ge v2, v3, :cond_4

    .line 78
    :cond_2
    const/4 v2, 0x0

    iput-boolean v2, p0, Lcom/facebook/react/animated/SpringAnimation;->mSpringStarted:Z

    .line 79
    iget-object v2, p0, Lcom/facebook/react/animated/SpringAnimation;->mAnimatedValue:Lcom/facebook/react/animated/ValueAnimatedNode;

    iget-wide v4, p0, Lcom/facebook/react/animated/SpringAnimation;->mOriginalValue:D

    iput-wide v4, v2, Lcom/facebook/react/animated/ValueAnimatedNode;->mValue:D

    .line 80
    iget v2, p0, Lcom/facebook/react/animated/SpringAnimation;->mCurrentLoop:I

    add-int/lit8 v2, v2, 0x1

    iput v2, p0, Lcom/facebook/react/animated/SpringAnimation;->mCurrentLoop:I

    .line 85
    :cond_3
    :goto_0
    return-void

    .line 82
    :cond_4
    iput-boolean v6, p0, Lcom/facebook/react/animated/SpringAnimation;->mHasFinished:Z

    goto :goto_0
.end method

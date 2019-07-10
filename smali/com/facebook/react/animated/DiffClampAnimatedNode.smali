.class Lcom/facebook/react/animated/DiffClampAnimatedNode;
.super Lcom/facebook/react/animated/ValueAnimatedNode;
.source "DiffClampAnimatedNode.java"


# instance fields
.field private final mInputNodeTag:I

.field private mLastValue:D

.field private final mMax:D

.field private final mMin:D

.field private final mNativeAnimatedNodesManager:Lcom/facebook/react/animated/NativeAnimatedNodesManager;


# direct methods
.method public constructor <init>(Lcom/facebook/react/bridge/ReadableMap;Lcom/facebook/react/animated/NativeAnimatedNodesManager;)V
    .locals 2
    .param p1, "config"    # Lcom/facebook/react/bridge/ReadableMap;
    .param p2, "nativeAnimatedNodesManager"    # Lcom/facebook/react/animated/NativeAnimatedNodesManager;

    .prologue
    .line 25
    invoke-direct {p0}, Lcom/facebook/react/animated/ValueAnimatedNode;-><init>()V

    .line 26
    iput-object p2, p0, Lcom/facebook/react/animated/DiffClampAnimatedNode;->mNativeAnimatedNodesManager:Lcom/facebook/react/animated/NativeAnimatedNodesManager;

    .line 27
    const-string v0, "input"

    invoke-interface {p1, v0}, Lcom/facebook/react/bridge/ReadableMap;->getInt(Ljava/lang/String;)I

    move-result v0

    iput v0, p0, Lcom/facebook/react/animated/DiffClampAnimatedNode;->mInputNodeTag:I

    .line 28
    const-string v0, "min"

    invoke-interface {p1, v0}, Lcom/facebook/react/bridge/ReadableMap;->getDouble(Ljava/lang/String;)D

    move-result-wide v0

    iput-wide v0, p0, Lcom/facebook/react/animated/DiffClampAnimatedNode;->mMin:D

    .line 29
    const-string v0, "max"

    invoke-interface {p1, v0}, Lcom/facebook/react/bridge/ReadableMap;->getDouble(Ljava/lang/String;)D

    move-result-wide v0

    iput-wide v0, p0, Lcom/facebook/react/animated/DiffClampAnimatedNode;->mMax:D

    .line 31
    const-wide/16 v0, 0x0

    iput-wide v0, p0, Lcom/facebook/react/animated/DiffClampAnimatedNode;->mLastValue:D

    iput-wide v0, p0, Lcom/facebook/react/animated/DiffClampAnimatedNode;->mValue:D

    .line 32
    return-void
.end method

.method private getInputNodeValue()D
    .locals 4

    .prologue
    .line 44
    iget-object v1, p0, Lcom/facebook/react/animated/DiffClampAnimatedNode;->mNativeAnimatedNodesManager:Lcom/facebook/react/animated/NativeAnimatedNodesManager;

    iget v2, p0, Lcom/facebook/react/animated/DiffClampAnimatedNode;->mInputNodeTag:I

    invoke-virtual {v1, v2}, Lcom/facebook/react/animated/NativeAnimatedNodesManager;->getNodeById(I)Lcom/facebook/react/animated/AnimatedNode;

    move-result-object v0

    .line 45
    .local v0, "animatedNode":Lcom/facebook/react/animated/AnimatedNode;
    if-eqz v0, :cond_0

    instance-of v1, v0, Lcom/facebook/react/animated/ValueAnimatedNode;

    if-nez v1, :cond_1

    .line 46
    :cond_0
    new-instance v1, Lcom/facebook/react/bridge/JSApplicationCausedNativeException;

    const-string v2, "Illegal node ID set as an input for Animated.DiffClamp node"

    invoke-direct {v1, v2}, Lcom/facebook/react/bridge/JSApplicationCausedNativeException;-><init>(Ljava/lang/String;)V

    throw v1

    .line 51
    :cond_1
    check-cast v0, Lcom/facebook/react/animated/ValueAnimatedNode;

    .end local v0    # "animatedNode":Lcom/facebook/react/animated/AnimatedNode;
    invoke-virtual {v0}, Lcom/facebook/react/animated/ValueAnimatedNode;->getValue()D

    move-result-wide v2

    return-wide v2
.end method


# virtual methods
.method public update()V
    .locals 8

    .prologue
    .line 36
    invoke-direct {p0}, Lcom/facebook/react/animated/DiffClampAnimatedNode;->getInputNodeValue()D

    move-result-wide v2

    .line 38
    .local v2, "value":D
    iget-wide v4, p0, Lcom/facebook/react/animated/DiffClampAnimatedNode;->mLastValue:D

    sub-double v0, v2, v4

    .line 39
    .local v0, "diff":D
    iput-wide v2, p0, Lcom/facebook/react/animated/DiffClampAnimatedNode;->mLastValue:D

    .line 40
    iget-wide v4, p0, Lcom/facebook/react/animated/DiffClampAnimatedNode;->mValue:D

    add-double/2addr v4, v0

    iget-wide v6, p0, Lcom/facebook/react/animated/DiffClampAnimatedNode;->mMin:D

    invoke-static {v4, v5, v6, v7}, Ljava/lang/Math;->max(DD)D

    move-result-wide v4

    iget-wide v6, p0, Lcom/facebook/react/animated/DiffClampAnimatedNode;->mMax:D

    invoke-static {v4, v5, v6, v7}, Ljava/lang/Math;->min(DD)D

    move-result-wide v4

    iput-wide v4, p0, Lcom/facebook/react/animated/DiffClampAnimatedNode;->mValue:D

    .line 41
    return-void
.end method

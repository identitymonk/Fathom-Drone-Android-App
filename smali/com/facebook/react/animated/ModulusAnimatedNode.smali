.class Lcom/facebook/react/animated/ModulusAnimatedNode;
.super Lcom/facebook/react/animated/ValueAnimatedNode;
.source "ModulusAnimatedNode.java"


# instance fields
.field private final mInputNode:I

.field private final mModulus:I

.field private final mNativeAnimatedNodesManager:Lcom/facebook/react/animated/NativeAnimatedNodesManager;


# direct methods
.method public constructor <init>(Lcom/facebook/react/bridge/ReadableMap;Lcom/facebook/react/animated/NativeAnimatedNodesManager;)V
    .locals 1
    .param p1, "config"    # Lcom/facebook/react/bridge/ReadableMap;
    .param p2, "nativeAnimatedNodesManager"    # Lcom/facebook/react/animated/NativeAnimatedNodesManager;

    .prologue
    .line 24
    invoke-direct {p0}, Lcom/facebook/react/animated/ValueAnimatedNode;-><init>()V

    .line 25
    iput-object p2, p0, Lcom/facebook/react/animated/ModulusAnimatedNode;->mNativeAnimatedNodesManager:Lcom/facebook/react/animated/NativeAnimatedNodesManager;

    .line 26
    const-string v0, "input"

    invoke-interface {p1, v0}, Lcom/facebook/react/bridge/ReadableMap;->getInt(Ljava/lang/String;)I

    move-result v0

    iput v0, p0, Lcom/facebook/react/animated/ModulusAnimatedNode;->mInputNode:I

    .line 27
    const-string v0, "modulus"

    invoke-interface {p1, v0}, Lcom/facebook/react/bridge/ReadableMap;->getInt(Ljava/lang/String;)I

    move-result v0

    iput v0, p0, Lcom/facebook/react/animated/ModulusAnimatedNode;->mModulus:I

    .line 28
    return-void
.end method


# virtual methods
.method public update()V
    .locals 6

    .prologue
    .line 32
    iget-object v1, p0, Lcom/facebook/react/animated/ModulusAnimatedNode;->mNativeAnimatedNodesManager:Lcom/facebook/react/animated/NativeAnimatedNodesManager;

    iget v2, p0, Lcom/facebook/react/animated/ModulusAnimatedNode;->mInputNode:I

    invoke-virtual {v1, v2}, Lcom/facebook/react/animated/NativeAnimatedNodesManager;->getNodeById(I)Lcom/facebook/react/animated/AnimatedNode;

    move-result-object v0

    .line 33
    .local v0, "animatedNode":Lcom/facebook/react/animated/AnimatedNode;
    if-eqz v0, :cond_0

    instance-of v1, v0, Lcom/facebook/react/animated/ValueAnimatedNode;

    if-eqz v1, :cond_0

    .line 34
    check-cast v0, Lcom/facebook/react/animated/ValueAnimatedNode;

    .end local v0    # "animatedNode":Lcom/facebook/react/animated/AnimatedNode;
    invoke-virtual {v0}, Lcom/facebook/react/animated/ValueAnimatedNode;->getValue()D

    move-result-wide v2

    iget v1, p0, Lcom/facebook/react/animated/ModulusAnimatedNode;->mModulus:I

    int-to-double v4, v1

    rem-double/2addr v2, v4

    iput-wide v2, p0, Lcom/facebook/react/animated/ModulusAnimatedNode;->mValue:D

    .line 39
    return-void

    .line 36
    .restart local v0    # "animatedNode":Lcom/facebook/react/animated/AnimatedNode;
    :cond_0
    new-instance v1, Lcom/facebook/react/bridge/JSApplicationCausedNativeException;

    const-string v2, "Illegal node ID set as an input for Animated.modulus node"

    invoke-direct {v1, v2}, Lcom/facebook/react/bridge/JSApplicationCausedNativeException;-><init>(Ljava/lang/String;)V

    throw v1
.end method

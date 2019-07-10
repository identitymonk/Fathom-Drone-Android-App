.class Lcom/facebook/react/animated/AdditionAnimatedNode;
.super Lcom/facebook/react/animated/ValueAnimatedNode;
.source "AdditionAnimatedNode.java"


# instance fields
.field private final mInputNodes:[I

.field private final mNativeAnimatedNodesManager:Lcom/facebook/react/animated/NativeAnimatedNodesManager;


# direct methods
.method public constructor <init>(Lcom/facebook/react/bridge/ReadableMap;Lcom/facebook/react/animated/NativeAnimatedNodesManager;)V
    .locals 4
    .param p1, "config"    # Lcom/facebook/react/bridge/ReadableMap;
    .param p2, "nativeAnimatedNodesManager"    # Lcom/facebook/react/animated/NativeAnimatedNodesManager;

    .prologue
    .line 27
    invoke-direct {p0}, Lcom/facebook/react/animated/ValueAnimatedNode;-><init>()V

    .line 28
    iput-object p2, p0, Lcom/facebook/react/animated/AdditionAnimatedNode;->mNativeAnimatedNodesManager:Lcom/facebook/react/animated/NativeAnimatedNodesManager;

    .line 29
    const-string v2, "input"

    invoke-interface {p1, v2}, Lcom/facebook/react/bridge/ReadableMap;->getArray(Ljava/lang/String;)Lcom/facebook/react/bridge/ReadableArray;

    move-result-object v1

    .line 30
    .local v1, "inputNodes":Lcom/facebook/react/bridge/ReadableArray;
    invoke-interface {v1}, Lcom/facebook/react/bridge/ReadableArray;->size()I

    move-result v2

    new-array v2, v2, [I

    iput-object v2, p0, Lcom/facebook/react/animated/AdditionAnimatedNode;->mInputNodes:[I

    .line 31
    const/4 v0, 0x0

    .local v0, "i":I
    :goto_0
    iget-object v2, p0, Lcom/facebook/react/animated/AdditionAnimatedNode;->mInputNodes:[I

    array-length v2, v2

    if-ge v0, v2, :cond_0

    .line 32
    iget-object v2, p0, Lcom/facebook/react/animated/AdditionAnimatedNode;->mInputNodes:[I

    invoke-interface {v1, v0}, Lcom/facebook/react/bridge/ReadableArray;->getInt(I)I

    move-result v3

    aput v3, v2, v0

    .line 31
    add-int/lit8 v0, v0, 0x1

    goto :goto_0

    .line 34
    :cond_0
    return-void
.end method


# virtual methods
.method public update()V
    .locals 6

    .prologue
    .line 38
    const-wide/16 v2, 0x0

    iput-wide v2, p0, Lcom/facebook/react/animated/AdditionAnimatedNode;->mValue:D

    .line 39
    const/4 v1, 0x0

    .local v1, "i":I
    :goto_0
    iget-object v2, p0, Lcom/facebook/react/animated/AdditionAnimatedNode;->mInputNodes:[I

    array-length v2, v2

    if-ge v1, v2, :cond_1

    .line 40
    iget-object v2, p0, Lcom/facebook/react/animated/AdditionAnimatedNode;->mNativeAnimatedNodesManager:Lcom/facebook/react/animated/NativeAnimatedNodesManager;

    iget-object v3, p0, Lcom/facebook/react/animated/AdditionAnimatedNode;->mInputNodes:[I

    aget v3, v3, v1

    invoke-virtual {v2, v3}, Lcom/facebook/react/animated/NativeAnimatedNodesManager;->getNodeById(I)Lcom/facebook/react/animated/AnimatedNode;

    move-result-object v0

    .line 41
    .local v0, "animatedNode":Lcom/facebook/react/animated/AnimatedNode;
    if-eqz v0, :cond_0

    instance-of v2, v0, Lcom/facebook/react/animated/ValueAnimatedNode;

    if-eqz v2, :cond_0

    .line 42
    iget-wide v2, p0, Lcom/facebook/react/animated/AdditionAnimatedNode;->mValue:D

    check-cast v0, Lcom/facebook/react/animated/ValueAnimatedNode;

    .end local v0    # "animatedNode":Lcom/facebook/react/animated/AnimatedNode;
    invoke-virtual {v0}, Lcom/facebook/react/animated/ValueAnimatedNode;->getValue()D

    move-result-wide v4

    add-double/2addr v2, v4

    iput-wide v2, p0, Lcom/facebook/react/animated/AdditionAnimatedNode;->mValue:D

    .line 39
    add-int/lit8 v1, v1, 0x1

    goto :goto_0

    .line 44
    .restart local v0    # "animatedNode":Lcom/facebook/react/animated/AnimatedNode;
    :cond_0
    new-instance v2, Lcom/facebook/react/bridge/JSApplicationCausedNativeException;

    const-string v3, "Illegal node ID set as an input for Animated.Add node"

    invoke-direct {v2, v3}, Lcom/facebook/react/bridge/JSApplicationCausedNativeException;-><init>(Ljava/lang/String;)V

    throw v2

    .line 48
    .end local v0    # "animatedNode":Lcom/facebook/react/animated/AnimatedNode;
    :cond_1
    return-void
.end method

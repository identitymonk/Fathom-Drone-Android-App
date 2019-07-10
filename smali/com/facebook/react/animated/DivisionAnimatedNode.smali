.class Lcom/facebook/react/animated/DivisionAnimatedNode;
.super Lcom/facebook/react/animated/ValueAnimatedNode;
.source "DivisionAnimatedNode.java"


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
    iput-object p2, p0, Lcom/facebook/react/animated/DivisionAnimatedNode;->mNativeAnimatedNodesManager:Lcom/facebook/react/animated/NativeAnimatedNodesManager;

    .line 29
    const-string v2, "input"

    invoke-interface {p1, v2}, Lcom/facebook/react/bridge/ReadableMap;->getArray(Ljava/lang/String;)Lcom/facebook/react/bridge/ReadableArray;

    move-result-object v1

    .line 30
    .local v1, "inputNodes":Lcom/facebook/react/bridge/ReadableArray;
    invoke-interface {v1}, Lcom/facebook/react/bridge/ReadableArray;->size()I

    move-result v2

    new-array v2, v2, [I

    iput-object v2, p0, Lcom/facebook/react/animated/DivisionAnimatedNode;->mInputNodes:[I

    .line 31
    const/4 v0, 0x0

    .local v0, "i":I
    :goto_0
    iget-object v2, p0, Lcom/facebook/react/animated/DivisionAnimatedNode;->mInputNodes:[I

    array-length v2, v2

    if-ge v0, v2, :cond_0

    .line 32
    iget-object v2, p0, Lcom/facebook/react/animated/DivisionAnimatedNode;->mInputNodes:[I

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
    const/4 v1, 0x0

    .local v1, "i":I
    :goto_0
    iget-object v4, p0, Lcom/facebook/react/animated/DivisionAnimatedNode;->mInputNodes:[I

    array-length v4, v4

    if-ge v1, v4, :cond_3

    .line 39
    iget-object v4, p0, Lcom/facebook/react/animated/DivisionAnimatedNode;->mNativeAnimatedNodesManager:Lcom/facebook/react/animated/NativeAnimatedNodesManager;

    iget-object v5, p0, Lcom/facebook/react/animated/DivisionAnimatedNode;->mInputNodes:[I

    aget v5, v5, v1

    invoke-virtual {v4, v5}, Lcom/facebook/react/animated/NativeAnimatedNodesManager;->getNodeById(I)Lcom/facebook/react/animated/AnimatedNode;

    move-result-object v0

    .line 40
    .local v0, "animatedNode":Lcom/facebook/react/animated/AnimatedNode;
    if-eqz v0, :cond_2

    instance-of v4, v0, Lcom/facebook/react/animated/ValueAnimatedNode;

    if-eqz v4, :cond_2

    .line 41
    check-cast v0, Lcom/facebook/react/animated/ValueAnimatedNode;

    .end local v0    # "animatedNode":Lcom/facebook/react/animated/AnimatedNode;
    invoke-virtual {v0}, Lcom/facebook/react/animated/ValueAnimatedNode;->getValue()D

    move-result-wide v2

    .line 42
    .local v2, "value":D
    if-nez v1, :cond_0

    .line 43
    iput-wide v2, p0, Lcom/facebook/react/animated/DivisionAnimatedNode;->mValue:D

    .line 38
    :goto_1
    add-int/lit8 v1, v1, 0x1

    goto :goto_0

    .line 46
    :cond_0
    const-wide/16 v4, 0x0

    cmpl-double v4, v2, v4

    if-nez v4, :cond_1

    .line 47
    new-instance v4, Lcom/facebook/react/bridge/JSApplicationCausedNativeException;

    const-string v5, "Detected a division by zero in Animated.divide node"

    invoke-direct {v4, v5}, Lcom/facebook/react/bridge/JSApplicationCausedNativeException;-><init>(Ljava/lang/String;)V

    throw v4

    .line 50
    :cond_1
    iget-wide v4, p0, Lcom/facebook/react/animated/DivisionAnimatedNode;->mValue:D

    div-double/2addr v4, v2

    iput-wide v4, p0, Lcom/facebook/react/animated/DivisionAnimatedNode;->mValue:D

    goto :goto_1

    .line 52
    .end local v2    # "value":D
    .restart local v0    # "animatedNode":Lcom/facebook/react/animated/AnimatedNode;
    :cond_2
    new-instance v4, Lcom/facebook/react/bridge/JSApplicationCausedNativeException;

    const-string v5, "Illegal node ID set as an input for Animated.divide node"

    invoke-direct {v4, v5}, Lcom/facebook/react/bridge/JSApplicationCausedNativeException;-><init>(Ljava/lang/String;)V

    throw v4

    .line 56
    .end local v0    # "animatedNode":Lcom/facebook/react/animated/AnimatedNode;
    :cond_3
    return-void
.end method

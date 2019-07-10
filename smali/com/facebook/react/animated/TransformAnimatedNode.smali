.class Lcom/facebook/react/animated/TransformAnimatedNode;
.super Lcom/facebook/react/animated/AnimatedNode;
.source "TransformAnimatedNode.java"


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lcom/facebook/react/animated/TransformAnimatedNode$StaticTransformConfig;,
        Lcom/facebook/react/animated/TransformAnimatedNode$AnimatedTransformConfig;,
        Lcom/facebook/react/animated/TransformAnimatedNode$TransformConfig;
    }
.end annotation


# instance fields
.field private final mNativeAnimatedNodesManager:Lcom/facebook/react/animated/NativeAnimatedNodesManager;

.field private final mTransformConfigs:Ljava/util/List;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/List",
            "<",
            "Lcom/facebook/react/animated/TransformAnimatedNode$TransformConfig;",
            ">;"
        }
    .end annotation
.end field


# direct methods
.method constructor <init>(Lcom/facebook/react/bridge/ReadableMap;Lcom/facebook/react/animated/NativeAnimatedNodesManager;)V
    .locals 9
    .param p1, "config"    # Lcom/facebook/react/bridge/ReadableMap;
    .param p2, "nativeAnimatedNodesManager"    # Lcom/facebook/react/animated/NativeAnimatedNodesManager;

    .prologue
    const/4 v8, 0x0

    .line 40
    invoke-direct {p0}, Lcom/facebook/react/animated/AnimatedNode;-><init>()V

    .line 41
    const-string v6, "transforms"

    invoke-interface {p1, v6}, Lcom/facebook/react/bridge/ReadableMap;->getArray(Ljava/lang/String;)Lcom/facebook/react/bridge/ReadableArray;

    move-result-object v4

    .line 42
    .local v4, "transforms":Lcom/facebook/react/bridge/ReadableArray;
    new-instance v6, Ljava/util/ArrayList;

    invoke-interface {v4}, Lcom/facebook/react/bridge/ReadableArray;->size()I

    move-result v7

    invoke-direct {v6, v7}, Ljava/util/ArrayList;-><init>(I)V

    iput-object v6, p0, Lcom/facebook/react/animated/TransformAnimatedNode;->mTransformConfigs:Ljava/util/List;

    .line 43
    const/4 v0, 0x0

    .local v0, "i":I
    :goto_0
    invoke-interface {v4}, Lcom/facebook/react/bridge/ReadableArray;->size()I

    move-result v6

    if-ge v0, v6, :cond_1

    .line 44
    invoke-interface {v4, v0}, Lcom/facebook/react/bridge/ReadableArray;->getMap(I)Lcom/facebook/react/bridge/ReadableMap;

    move-result-object v3

    .line 45
    .local v3, "transformConfigMap":Lcom/facebook/react/bridge/ReadableMap;
    const-string v6, "property"

    invoke-interface {v3, v6}, Lcom/facebook/react/bridge/ReadableMap;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v1

    .line 46
    .local v1, "property":Ljava/lang/String;
    const-string v6, "type"

    invoke-interface {v3, v6}, Lcom/facebook/react/bridge/ReadableMap;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v5

    .line 47
    .local v5, "type":Ljava/lang/String;
    const-string v6, "animated"

    invoke-virtual {v5, v6}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v6

    if-eqz v6, :cond_0

    .line 48
    new-instance v2, Lcom/facebook/react/animated/TransformAnimatedNode$AnimatedTransformConfig;

    invoke-direct {v2, p0, v8}, Lcom/facebook/react/animated/TransformAnimatedNode$AnimatedTransformConfig;-><init>(Lcom/facebook/react/animated/TransformAnimatedNode;Lcom/facebook/react/animated/TransformAnimatedNode$1;)V

    .line 49
    .local v2, "transformConfig":Lcom/facebook/react/animated/TransformAnimatedNode$AnimatedTransformConfig;
    iput-object v1, v2, Lcom/facebook/react/animated/TransformAnimatedNode$AnimatedTransformConfig;->mProperty:Ljava/lang/String;

    .line 50
    const-string v6, "nodeTag"

    invoke-interface {v3, v6}, Lcom/facebook/react/bridge/ReadableMap;->getInt(Ljava/lang/String;)I

    move-result v6

    iput v6, v2, Lcom/facebook/react/animated/TransformAnimatedNode$AnimatedTransformConfig;->mNodeTag:I

    .line 51
    iget-object v6, p0, Lcom/facebook/react/animated/TransformAnimatedNode;->mTransformConfigs:Ljava/util/List;

    invoke-interface {v6, v2}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    .line 43
    .end local v2    # "transformConfig":Lcom/facebook/react/animated/TransformAnimatedNode$AnimatedTransformConfig;
    :goto_1
    add-int/lit8 v0, v0, 0x1

    goto :goto_0

    .line 53
    :cond_0
    new-instance v2, Lcom/facebook/react/animated/TransformAnimatedNode$StaticTransformConfig;

    invoke-direct {v2, p0, v8}, Lcom/facebook/react/animated/TransformAnimatedNode$StaticTransformConfig;-><init>(Lcom/facebook/react/animated/TransformAnimatedNode;Lcom/facebook/react/animated/TransformAnimatedNode$1;)V

    .line 54
    .local v2, "transformConfig":Lcom/facebook/react/animated/TransformAnimatedNode$StaticTransformConfig;
    iput-object v1, v2, Lcom/facebook/react/animated/TransformAnimatedNode$StaticTransformConfig;->mProperty:Ljava/lang/String;

    .line 55
    const-string v6, "value"

    invoke-interface {v3, v6}, Lcom/facebook/react/bridge/ReadableMap;->getDouble(Ljava/lang/String;)D

    move-result-wide v6

    iput-wide v6, v2, Lcom/facebook/react/animated/TransformAnimatedNode$StaticTransformConfig;->mValue:D

    .line 56
    iget-object v6, p0, Lcom/facebook/react/animated/TransformAnimatedNode;->mTransformConfigs:Ljava/util/List;

    invoke-interface {v6, v2}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    goto :goto_1

    .line 59
    .end local v1    # "property":Ljava/lang/String;
    .end local v2    # "transformConfig":Lcom/facebook/react/animated/TransformAnimatedNode$StaticTransformConfig;
    .end local v3    # "transformConfigMap":Lcom/facebook/react/bridge/ReadableMap;
    .end local v5    # "type":Ljava/lang/String;
    :cond_1
    iput-object p2, p0, Lcom/facebook/react/animated/TransformAnimatedNode;->mNativeAnimatedNodesManager:Lcom/facebook/react/animated/NativeAnimatedNodesManager;

    .line 60
    return-void
.end method


# virtual methods
.method public collectViewUpdates(Lcom/facebook/react/bridge/JavaOnlyMap;)V
    .locals 10
    .param p1, "propsMap"    # Lcom/facebook/react/bridge/JavaOnlyMap;

    .prologue
    .line 63
    new-instance v3, Ljava/util/ArrayList;

    iget-object v6, p0, Lcom/facebook/react/animated/TransformAnimatedNode;->mTransformConfigs:Ljava/util/List;

    invoke-interface {v6}, Ljava/util/List;->size()I

    move-result v6

    invoke-direct {v3, v6}, Ljava/util/ArrayList;-><init>(I)V

    .line 65
    .local v3, "transforms":Ljava/util/List;, "Ljava/util/List<Lcom/facebook/react/bridge/JavaOnlyMap;>;"
    iget-object v6, p0, Lcom/facebook/react/animated/TransformAnimatedNode;->mTransformConfigs:Ljava/util/List;

    invoke-interface {v6}, Ljava/util/List;->iterator()Ljava/util/Iterator;

    move-result-object v7

    :goto_0
    invoke-interface {v7}, Ljava/util/Iterator;->hasNext()Z

    move-result v6

    if-eqz v6, :cond_3

    invoke-interface {v7}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v2

    check-cast v2, Lcom/facebook/react/animated/TransformAnimatedNode$TransformConfig;

    .line 67
    .local v2, "transformConfig":Lcom/facebook/react/animated/TransformAnimatedNode$TransformConfig;
    instance-of v6, v2, Lcom/facebook/react/animated/TransformAnimatedNode$AnimatedTransformConfig;

    if-eqz v6, :cond_2

    move-object v6, v2

    .line 68
    check-cast v6, Lcom/facebook/react/animated/TransformAnimatedNode$AnimatedTransformConfig;

    iget v1, v6, Lcom/facebook/react/animated/TransformAnimatedNode$AnimatedTransformConfig;->mNodeTag:I

    .line 69
    .local v1, "nodeTag":I
    iget-object v6, p0, Lcom/facebook/react/animated/TransformAnimatedNode;->mNativeAnimatedNodesManager:Lcom/facebook/react/animated/NativeAnimatedNodesManager;

    invoke-virtual {v6, v1}, Lcom/facebook/react/animated/NativeAnimatedNodesManager;->getNodeById(I)Lcom/facebook/react/animated/AnimatedNode;

    move-result-object v0

    .line 70
    .local v0, "node":Lcom/facebook/react/animated/AnimatedNode;
    if-nez v0, :cond_0

    .line 71
    new-instance v6, Ljava/lang/IllegalArgumentException;

    const-string v7, "Mapped style node does not exists"

    invoke-direct {v6, v7}, Ljava/lang/IllegalArgumentException;-><init>(Ljava/lang/String;)V

    throw v6

    .line 72
    :cond_0
    instance-of v6, v0, Lcom/facebook/react/animated/ValueAnimatedNode;

    if-eqz v6, :cond_1

    .line 73
    check-cast v0, Lcom/facebook/react/animated/ValueAnimatedNode;

    .end local v0    # "node":Lcom/facebook/react/animated/AnimatedNode;
    invoke-virtual {v0}, Lcom/facebook/react/animated/ValueAnimatedNode;->getValue()D

    move-result-wide v4

    .line 82
    .end local v1    # "nodeTag":I
    .local v4, "value":D
    :goto_1
    const/4 v6, 0x2

    new-array v6, v6, [Ljava/lang/Object;

    const/4 v8, 0x0

    iget-object v9, v2, Lcom/facebook/react/animated/TransformAnimatedNode$TransformConfig;->mProperty:Ljava/lang/String;

    aput-object v9, v6, v8

    const/4 v8, 0x1

    invoke-static {v4, v5}, Ljava/lang/Double;->valueOf(D)Ljava/lang/Double;

    move-result-object v9

    aput-object v9, v6, v8

    invoke-static {v6}, Lcom/facebook/react/bridge/JavaOnlyMap;->of([Ljava/lang/Object;)Lcom/facebook/react/bridge/JavaOnlyMap;

    move-result-object v6

    invoke-interface {v3, v6}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    goto :goto_0

    .line 75
    .end local v4    # "value":D
    .restart local v0    # "node":Lcom/facebook/react/animated/AnimatedNode;
    .restart local v1    # "nodeTag":I
    :cond_1
    new-instance v6, Ljava/lang/IllegalArgumentException;

    new-instance v7, Ljava/lang/StringBuilder;

    invoke-direct {v7}, Ljava/lang/StringBuilder;-><init>()V

    const-string v8, "Unsupported type of node used as a transform child node "

    invoke-virtual {v7, v8}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v7

    .line 76
    invoke-virtual {v0}, Ljava/lang/Object;->getClass()Ljava/lang/Class;

    move-result-object v8

    invoke-virtual {v7, v8}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    move-result-object v7

    invoke-virtual {v7}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v7

    invoke-direct {v6, v7}, Ljava/lang/IllegalArgumentException;-><init>(Ljava/lang/String;)V

    throw v6

    .end local v0    # "node":Lcom/facebook/react/animated/AnimatedNode;
    .end local v1    # "nodeTag":I
    :cond_2
    move-object v6, v2

    .line 79
    check-cast v6, Lcom/facebook/react/animated/TransformAnimatedNode$StaticTransformConfig;

    iget-wide v4, v6, Lcom/facebook/react/animated/TransformAnimatedNode$StaticTransformConfig;->mValue:D

    .restart local v4    # "value":D
    goto :goto_1

    .line 85
    .end local v2    # "transformConfig":Lcom/facebook/react/animated/TransformAnimatedNode$TransformConfig;
    .end local v4    # "value":D
    :cond_3
    const-string v6, "transform"

    invoke-static {v3}, Lcom/facebook/react/bridge/JavaOnlyArray;->from(Ljava/util/List;)Lcom/facebook/react/bridge/JavaOnlyArray;

    move-result-object v7

    invoke-virtual {p1, v6, v7}, Lcom/facebook/react/bridge/JavaOnlyMap;->putArray(Ljava/lang/String;Lcom/facebook/react/bridge/WritableArray;)V

    .line 86
    return-void
.end method

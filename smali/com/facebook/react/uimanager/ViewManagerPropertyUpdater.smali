.class public Lcom/facebook/react/uimanager/ViewManagerPropertyUpdater;
.super Ljava/lang/Object;
.source "ViewManagerPropertyUpdater.java"


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lcom/facebook/react/uimanager/ViewManagerPropertyUpdater$FallbackShadowNodeSetter;,
        Lcom/facebook/react/uimanager/ViewManagerPropertyUpdater$FallbackViewManagerSetter;,
        Lcom/facebook/react/uimanager/ViewManagerPropertyUpdater$ShadowNodeSetter;,
        Lcom/facebook/react/uimanager/ViewManagerPropertyUpdater$ViewManagerSetter;,
        Lcom/facebook/react/uimanager/ViewManagerPropertyUpdater$Settable;
    }
.end annotation


# static fields
.field private static final SHADOW_NODE_SETTER_MAP:Ljava/util/Map;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/Map",
            "<",
            "Ljava/lang/Class",
            "<*>;",
            "Lcom/facebook/react/uimanager/ViewManagerPropertyUpdater$ShadowNodeSetter",
            "<*>;>;"
        }
    .end annotation
.end field

.field private static final TAG:Ljava/lang/String; = "ViewManagerPropertyUpdater"

.field private static final VIEW_MANAGER_SETTER_MAP:Ljava/util/Map;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/Map",
            "<",
            "Ljava/lang/Class",
            "<*>;",
            "Lcom/facebook/react/uimanager/ViewManagerPropertyUpdater$ViewManagerSetter",
            "<**>;>;"
        }
    .end annotation
.end field


# direct methods
.method static constructor <clinit>()V
    .locals 1

    .prologue
    .line 29
    new-instance v0, Ljava/util/HashMap;

    invoke-direct {v0}, Ljava/util/HashMap;-><init>()V

    sput-object v0, Lcom/facebook/react/uimanager/ViewManagerPropertyUpdater;->VIEW_MANAGER_SETTER_MAP:Ljava/util/Map;

    .line 31
    new-instance v0, Ljava/util/HashMap;

    invoke-direct {v0}, Ljava/util/HashMap;-><init>()V

    sput-object v0, Lcom/facebook/react/uimanager/ViewManagerPropertyUpdater;->SHADOW_NODE_SETTER_MAP:Ljava/util/Map;

    return-void
.end method

.method public constructor <init>()V
    .locals 0

    .prologue
    .line 14
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 141
    return-void
.end method

.method public static clear()V
    .locals 1

    .prologue
    .line 34
    invoke-static {}, Lcom/facebook/react/uimanager/ViewManagersPropertyCache;->clear()V

    .line 35
    sget-object v0, Lcom/facebook/react/uimanager/ViewManagerPropertyUpdater;->VIEW_MANAGER_SETTER_MAP:Ljava/util/Map;

    invoke-interface {v0}, Ljava/util/Map;->clear()V

    .line 36
    sget-object v0, Lcom/facebook/react/uimanager/ViewManagerPropertyUpdater;->SHADOW_NODE_SETTER_MAP:Ljava/util/Map;

    invoke-interface {v0}, Ljava/util/Map;->clear()V

    .line 37
    return-void
.end method

.method private static findGeneratedSetter(Ljava/lang/Class;)Ljava/lang/Object;
    .locals 6
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "<T:",
            "Ljava/lang/Object;",
            ">(",
            "Ljava/lang/Class",
            "<*>;)TT;"
        }
    .end annotation

    .prologue
    .line 103
    .local p0, "cls":Ljava/lang/Class;, "Ljava/lang/Class<*>;"
    invoke-virtual {p0}, Ljava/lang/Class;->getName()Ljava/lang/String;

    move-result-object v0

    .line 105
    .local v0, "clsName":Ljava/lang/String;
    :try_start_0
    new-instance v3, Ljava/lang/StringBuilder;

    invoke-direct {v3}, Ljava/lang/StringBuilder;-><init>()V

    invoke-virtual {v3, v0}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    const-string v4, "$$PropsSetter"

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    invoke-virtual {v3}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v3

    invoke-static {v3}, Ljava/lang/Class;->forName(Ljava/lang/String;)Ljava/lang/Class;

    move-result-object v2

    .line 107
    .local v2, "setterClass":Ljava/lang/Class;, "Ljava/lang/Class<*>;"
    invoke-virtual {v2}, Ljava/lang/Class;->newInstance()Ljava/lang/Object;
    :try_end_0
    .catch Ljava/lang/ClassNotFoundException; {:try_start_0 .. :try_end_0} :catch_0
    .catch Ljava/lang/InstantiationException; {:try_start_0 .. :try_end_0} :catch_1
    .catch Ljava/lang/IllegalAccessException; {:try_start_0 .. :try_end_0} :catch_2

    move-result-object v3

    .line 110
    .end local v2    # "setterClass":Ljava/lang/Class;, "Ljava/lang/Class<*>;"
    :goto_0
    return-object v3

    .line 108
    :catch_0
    move-exception v1

    .line 109
    .local v1, "e":Ljava/lang/ClassNotFoundException;
    const-string v3, "ViewManagerPropertyUpdater"

    new-instance v4, Ljava/lang/StringBuilder;

    invoke-direct {v4}, Ljava/lang/StringBuilder;-><init>()V

    const-string v5, "Could not find generated setter for "

    invoke-virtual {v4, v5}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v4

    invoke-virtual {v4, p0}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    move-result-object v4

    invoke-virtual {v4}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v4

    invoke-static {v3, v4}, Lcom/facebook/common/logging/FLog;->w(Ljava/lang/String;Ljava/lang/String;)V

    .line 110
    const/4 v3, 0x0

    goto :goto_0

    .line 111
    .end local v1    # "e":Ljava/lang/ClassNotFoundException;
    :catch_1
    move-exception v1

    .line 112
    .local v1, "e":Ljava/lang/ReflectiveOperationException;
    :goto_1
    new-instance v3, Ljava/lang/RuntimeException;

    new-instance v4, Ljava/lang/StringBuilder;

    invoke-direct {v4}, Ljava/lang/StringBuilder;-><init>()V

    const-string v5, "Unable to instantiate methods getter for "

    invoke-virtual {v4, v5}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v4

    invoke-virtual {v4, v0}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v4

    invoke-virtual {v4}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v4

    invoke-direct {v3, v4, v1}, Ljava/lang/RuntimeException;-><init>(Ljava/lang/String;Ljava/lang/Throwable;)V

    throw v3

    .line 111
    .end local v1    # "e":Ljava/lang/ReflectiveOperationException;
    :catch_2
    move-exception v1

    goto :goto_1
.end method

.method private static findManagerSetter(Ljava/lang/Class;)Lcom/facebook/react/uimanager/ViewManagerPropertyUpdater$ViewManagerSetter;
    .locals 2
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "<T:",
            "Lcom/facebook/react/uimanager/ViewManager;",
            "V:",
            "Landroid/view/View;",
            ">(",
            "Ljava/lang/Class",
            "<+",
            "Lcom/facebook/react/uimanager/ViewManager;",
            ">;)",
            "Lcom/facebook/react/uimanager/ViewManagerPropertyUpdater$ViewManagerSetter",
            "<TT;TV;>;"
        }
    .end annotation

    .prologue
    .line 74
    .local p0, "managerClass":Ljava/lang/Class;, "Ljava/lang/Class<+Lcom/facebook/react/uimanager/ViewManager;>;"
    sget-object v1, Lcom/facebook/react/uimanager/ViewManagerPropertyUpdater;->VIEW_MANAGER_SETTER_MAP:Ljava/util/Map;

    .line 75
    invoke-interface {v1, p0}, Ljava/util/Map;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/facebook/react/uimanager/ViewManagerPropertyUpdater$ViewManagerSetter;

    .line 76
    .local v0, "setter":Lcom/facebook/react/uimanager/ViewManagerPropertyUpdater$ViewManagerSetter;, "Lcom/facebook/react/uimanager/ViewManagerPropertyUpdater$ViewManagerSetter<TT;TV;>;"
    if-nez v0, :cond_1

    .line 77
    invoke-static {p0}, Lcom/facebook/react/uimanager/ViewManagerPropertyUpdater;->findGeneratedSetter(Ljava/lang/Class;)Ljava/lang/Object;

    move-result-object v0

    .end local v0    # "setter":Lcom/facebook/react/uimanager/ViewManagerPropertyUpdater$ViewManagerSetter;, "Lcom/facebook/react/uimanager/ViewManagerPropertyUpdater$ViewManagerSetter<TT;TV;>;"
    check-cast v0, Lcom/facebook/react/uimanager/ViewManagerPropertyUpdater$ViewManagerSetter;

    .line 78
    .restart local v0    # "setter":Lcom/facebook/react/uimanager/ViewManagerPropertyUpdater$ViewManagerSetter;, "Lcom/facebook/react/uimanager/ViewManagerPropertyUpdater$ViewManagerSetter<TT;TV;>;"
    if-nez v0, :cond_0

    .line 79
    new-instance v0, Lcom/facebook/react/uimanager/ViewManagerPropertyUpdater$FallbackViewManagerSetter;

    .end local v0    # "setter":Lcom/facebook/react/uimanager/ViewManagerPropertyUpdater$ViewManagerSetter;, "Lcom/facebook/react/uimanager/ViewManagerPropertyUpdater$ViewManagerSetter<TT;TV;>;"
    const/4 v1, 0x0

    invoke-direct {v0, p0, v1}, Lcom/facebook/react/uimanager/ViewManagerPropertyUpdater$FallbackViewManagerSetter;-><init>(Ljava/lang/Class;Lcom/facebook/react/uimanager/ViewManagerPropertyUpdater$1;)V

    .line 81
    .restart local v0    # "setter":Lcom/facebook/react/uimanager/ViewManagerPropertyUpdater$ViewManagerSetter;, "Lcom/facebook/react/uimanager/ViewManagerPropertyUpdater$ViewManagerSetter<TT;TV;>;"
    :cond_0
    sget-object v1, Lcom/facebook/react/uimanager/ViewManagerPropertyUpdater;->VIEW_MANAGER_SETTER_MAP:Ljava/util/Map;

    invoke-interface {v1, p0, v0}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 84
    :cond_1
    return-object v0
.end method

.method private static findNodeSetter(Ljava/lang/Class;)Lcom/facebook/react/uimanager/ViewManagerPropertyUpdater$ShadowNodeSetter;
    .locals 2
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "<T::",
            "Lcom/facebook/react/uimanager/ReactShadowNode;",
            ">(",
            "Ljava/lang/Class",
            "<+",
            "Lcom/facebook/react/uimanager/ReactShadowNode;",
            ">;)",
            "Lcom/facebook/react/uimanager/ViewManagerPropertyUpdater$ShadowNodeSetter",
            "<TT;>;"
        }
    .end annotation

    .prologue
    .line 90
    .local p0, "nodeClass":Ljava/lang/Class;, "Ljava/lang/Class<+Lcom/facebook/react/uimanager/ReactShadowNode;>;"
    sget-object v1, Lcom/facebook/react/uimanager/ViewManagerPropertyUpdater;->SHADOW_NODE_SETTER_MAP:Ljava/util/Map;

    invoke-interface {v1, p0}, Ljava/util/Map;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/facebook/react/uimanager/ViewManagerPropertyUpdater$ShadowNodeSetter;

    .line 91
    .local v0, "setter":Lcom/facebook/react/uimanager/ViewManagerPropertyUpdater$ShadowNodeSetter;, "Lcom/facebook/react/uimanager/ViewManagerPropertyUpdater$ShadowNodeSetter<TT;>;"
    if-nez v0, :cond_1

    .line 92
    invoke-static {p0}, Lcom/facebook/react/uimanager/ViewManagerPropertyUpdater;->findGeneratedSetter(Ljava/lang/Class;)Ljava/lang/Object;

    move-result-object v0

    .end local v0    # "setter":Lcom/facebook/react/uimanager/ViewManagerPropertyUpdater$ShadowNodeSetter;, "Lcom/facebook/react/uimanager/ViewManagerPropertyUpdater$ShadowNodeSetter<TT;>;"
    check-cast v0, Lcom/facebook/react/uimanager/ViewManagerPropertyUpdater$ShadowNodeSetter;

    .line 93
    .restart local v0    # "setter":Lcom/facebook/react/uimanager/ViewManagerPropertyUpdater$ShadowNodeSetter;, "Lcom/facebook/react/uimanager/ViewManagerPropertyUpdater$ShadowNodeSetter<TT;>;"
    if-nez v0, :cond_0

    .line 94
    new-instance v0, Lcom/facebook/react/uimanager/ViewManagerPropertyUpdater$FallbackShadowNodeSetter;

    .end local v0    # "setter":Lcom/facebook/react/uimanager/ViewManagerPropertyUpdater$ShadowNodeSetter;, "Lcom/facebook/react/uimanager/ViewManagerPropertyUpdater$ShadowNodeSetter<TT;>;"
    const/4 v1, 0x0

    invoke-direct {v0, p0, v1}, Lcom/facebook/react/uimanager/ViewManagerPropertyUpdater$FallbackShadowNodeSetter;-><init>(Ljava/lang/Class;Lcom/facebook/react/uimanager/ViewManagerPropertyUpdater$1;)V

    .line 96
    .restart local v0    # "setter":Lcom/facebook/react/uimanager/ViewManagerPropertyUpdater$ShadowNodeSetter;, "Lcom/facebook/react/uimanager/ViewManagerPropertyUpdater$ShadowNodeSetter<TT;>;"
    :cond_0
    sget-object v1, Lcom/facebook/react/uimanager/ViewManagerPropertyUpdater;->SHADOW_NODE_SETTER_MAP:Ljava/util/Map;

    invoke-interface {v1, p0, v0}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 99
    :cond_1
    return-object v0
.end method

.method public static getNativeProps(Ljava/lang/Class;Ljava/lang/Class;)Ljava/util/Map;
    .locals 2
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/lang/Class",
            "<+",
            "Lcom/facebook/react/uimanager/ViewManager;",
            ">;",
            "Ljava/lang/Class",
            "<+",
            "Lcom/facebook/react/uimanager/ReactShadowNode;",
            ">;)",
            "Ljava/util/Map",
            "<",
            "Ljava/lang/String;",
            "Ljava/lang/String;",
            ">;"
        }
    .end annotation

    .prologue
    .line 65
    .local p0, "viewManagerTopClass":Ljava/lang/Class;, "Ljava/lang/Class<+Lcom/facebook/react/uimanager/ViewManager;>;"
    .local p1, "shadowNodeTopClass":Ljava/lang/Class;, "Ljava/lang/Class<+Lcom/facebook/react/uimanager/ReactShadowNode;>;"
    new-instance v0, Ljava/util/HashMap;

    invoke-direct {v0}, Ljava/util/HashMap;-><init>()V

    .line 66
    .local v0, "props":Ljava/util/Map;, "Ljava/util/Map<Ljava/lang/String;Ljava/lang/String;>;"
    invoke-static {p0}, Lcom/facebook/react/uimanager/ViewManagerPropertyUpdater;->findManagerSetter(Ljava/lang/Class;)Lcom/facebook/react/uimanager/ViewManagerPropertyUpdater$ViewManagerSetter;

    move-result-object v1

    invoke-interface {v1, v0}, Lcom/facebook/react/uimanager/ViewManagerPropertyUpdater$ViewManagerSetter;->getProperties(Ljava/util/Map;)V

    .line 67
    invoke-static {p1}, Lcom/facebook/react/uimanager/ViewManagerPropertyUpdater;->findNodeSetter(Ljava/lang/Class;)Lcom/facebook/react/uimanager/ViewManagerPropertyUpdater$ShadowNodeSetter;

    move-result-object v1

    invoke-interface {v1, v0}, Lcom/facebook/react/uimanager/ViewManagerPropertyUpdater$ShadowNodeSetter;->getProperties(Ljava/util/Map;)V

    .line 68
    return-object v0
.end method

.method public static updateProps(Lcom/facebook/react/uimanager/ReactShadowNode;Lcom/facebook/react/uimanager/ReactStylesDiffMap;)V
    .locals 5
    .param p1, "props"    # Lcom/facebook/react/uimanager/ReactStylesDiffMap;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "<T::",
            "Lcom/facebook/react/uimanager/ReactShadowNode;",
            ">(TT;",
            "Lcom/facebook/react/uimanager/ReactStylesDiffMap;",
            ")V"
        }
    .end annotation

    .prologue
    .line 53
    .local p0, "node":Lcom/facebook/react/uimanager/ReactShadowNode;, "TT;"
    invoke-virtual {p0}, Ljava/lang/Object;->getClass()Ljava/lang/Class;

    move-result-object v4

    invoke-static {v4}, Lcom/facebook/react/uimanager/ViewManagerPropertyUpdater;->findNodeSetter(Ljava/lang/Class;)Lcom/facebook/react/uimanager/ViewManagerPropertyUpdater$ShadowNodeSetter;

    move-result-object v3

    .line 54
    .local v3, "setter":Lcom/facebook/react/uimanager/ViewManagerPropertyUpdater$ShadowNodeSetter;, "Lcom/facebook/react/uimanager/ViewManagerPropertyUpdater$ShadowNodeSetter<TT;>;"
    iget-object v2, p1, Lcom/facebook/react/uimanager/ReactStylesDiffMap;->mBackingMap:Lcom/facebook/react/bridge/ReadableMap;

    .line 55
    .local v2, "propMap":Lcom/facebook/react/bridge/ReadableMap;
    invoke-interface {v2}, Lcom/facebook/react/bridge/ReadableMap;->keySetIterator()Lcom/facebook/react/bridge/ReadableMapKeySetIterator;

    move-result-object v0

    .line 56
    .local v0, "iterator":Lcom/facebook/react/bridge/ReadableMapKeySetIterator;
    :goto_0
    invoke-interface {v0}, Lcom/facebook/react/bridge/ReadableMapKeySetIterator;->hasNextKey()Z

    move-result v4

    if-eqz v4, :cond_0

    .line 57
    invoke-interface {v0}, Lcom/facebook/react/bridge/ReadableMapKeySetIterator;->nextKey()Ljava/lang/String;

    move-result-object v1

    .line 58
    .local v1, "key":Ljava/lang/String;
    invoke-interface {v3, p0, v1, p1}, Lcom/facebook/react/uimanager/ViewManagerPropertyUpdater$ShadowNodeSetter;->setProperty(Lcom/facebook/react/uimanager/ReactShadowNode;Ljava/lang/String;Lcom/facebook/react/uimanager/ReactStylesDiffMap;)V

    goto :goto_0

    .line 60
    .end local v1    # "key":Ljava/lang/String;
    :cond_0
    return-void
.end method

.method public static updateProps(Lcom/facebook/react/uimanager/ViewManager;Landroid/view/View;Lcom/facebook/react/uimanager/ReactStylesDiffMap;)V
    .locals 5
    .param p2, "props"    # Lcom/facebook/react/uimanager/ReactStylesDiffMap;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "<T:",
            "Lcom/facebook/react/uimanager/ViewManager;",
            "V:",
            "Landroid/view/View;",
            ">(TT;TV;",
            "Lcom/facebook/react/uimanager/ReactStylesDiffMap;",
            ")V"
        }
    .end annotation

    .prologue
    .line 43
    .local p0, "manager":Lcom/facebook/react/uimanager/ViewManager;, "TT;"
    .local p1, "v":Landroid/view/View;, "TV;"
    invoke-virtual {p0}, Ljava/lang/Object;->getClass()Ljava/lang/Class;

    move-result-object v4

    invoke-static {v4}, Lcom/facebook/react/uimanager/ViewManagerPropertyUpdater;->findManagerSetter(Ljava/lang/Class;)Lcom/facebook/react/uimanager/ViewManagerPropertyUpdater$ViewManagerSetter;

    move-result-object v3

    .line 44
    .local v3, "setter":Lcom/facebook/react/uimanager/ViewManagerPropertyUpdater$ViewManagerSetter;, "Lcom/facebook/react/uimanager/ViewManagerPropertyUpdater$ViewManagerSetter<TT;TV;>;"
    iget-object v2, p2, Lcom/facebook/react/uimanager/ReactStylesDiffMap;->mBackingMap:Lcom/facebook/react/bridge/ReadableMap;

    .line 45
    .local v2, "propMap":Lcom/facebook/react/bridge/ReadableMap;
    invoke-interface {v2}, Lcom/facebook/react/bridge/ReadableMap;->keySetIterator()Lcom/facebook/react/bridge/ReadableMapKeySetIterator;

    move-result-object v0

    .line 46
    .local v0, "iterator":Lcom/facebook/react/bridge/ReadableMapKeySetIterator;
    :goto_0
    invoke-interface {v0}, Lcom/facebook/react/bridge/ReadableMapKeySetIterator;->hasNextKey()Z

    move-result v4

    if-eqz v4, :cond_0

    .line 47
    invoke-interface {v0}, Lcom/facebook/react/bridge/ReadableMapKeySetIterator;->nextKey()Ljava/lang/String;

    move-result-object v1

    .line 48
    .local v1, "key":Ljava/lang/String;
    invoke-interface {v3, p0, p1, v1, p2}, Lcom/facebook/react/uimanager/ViewManagerPropertyUpdater$ViewManagerSetter;->setProperty(Lcom/facebook/react/uimanager/ViewManager;Landroid/view/View;Ljava/lang/String;Lcom/facebook/react/uimanager/ReactStylesDiffMap;)V

    goto :goto_0

    .line 50
    .end local v1    # "key":Ljava/lang/String;
    :cond_0
    return-void
.end method

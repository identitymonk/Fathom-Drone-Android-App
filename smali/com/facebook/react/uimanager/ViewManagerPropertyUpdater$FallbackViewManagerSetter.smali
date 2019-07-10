.class Lcom/facebook/react/uimanager/ViewManagerPropertyUpdater$FallbackViewManagerSetter;
.super Ljava/lang/Object;
.source "ViewManagerPropertyUpdater.java"

# interfaces
.implements Lcom/facebook/react/uimanager/ViewManagerPropertyUpdater$ViewManagerSetter;


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/facebook/react/uimanager/ViewManagerPropertyUpdater;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0xa
    name = "FallbackViewManagerSetter"
.end annotation

.annotation system Ldalvik/annotation/Signature;
    value = {
        "<T:",
        "Lcom/facebook/react/uimanager/ViewManager;",
        "V:",
        "Landroid/view/View;",
        ">",
        "Ljava/lang/Object;",
        "Lcom/facebook/react/uimanager/ViewManagerPropertyUpdater$ViewManagerSetter",
        "<TT;TV;>;"
    }
.end annotation


# instance fields
.field private final mPropSetters:Ljava/util/Map;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/Map",
            "<",
            "Ljava/lang/String;",
            "Lcom/facebook/react/uimanager/ViewManagersPropertyCache$PropSetter;",
            ">;"
        }
    .end annotation
.end field


# direct methods
.method private constructor <init>(Ljava/lang/Class;)V
    .locals 1
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/lang/Class",
            "<+",
            "Lcom/facebook/react/uimanager/ViewManager;",
            ">;)V"
        }
    .end annotation

    .prologue
    .line 120
    .local p0, "this":Lcom/facebook/react/uimanager/ViewManagerPropertyUpdater$FallbackViewManagerSetter;, "Lcom/facebook/react/uimanager/ViewManagerPropertyUpdater$FallbackViewManagerSetter<TT;TV;>;"
    .local p1, "viewManagerClass":Ljava/lang/Class;, "Ljava/lang/Class<+Lcom/facebook/react/uimanager/ViewManager;>;"
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 122
    invoke-static {p1}, Lcom/facebook/react/uimanager/ViewManagersPropertyCache;->getNativePropSettersForViewManagerClass(Ljava/lang/Class;)Ljava/util/Map;

    move-result-object v0

    iput-object v0, p0, Lcom/facebook/react/uimanager/ViewManagerPropertyUpdater$FallbackViewManagerSetter;->mPropSetters:Ljava/util/Map;

    .line 123
    return-void
.end method

.method synthetic constructor <init>(Ljava/lang/Class;Lcom/facebook/react/uimanager/ViewManagerPropertyUpdater$1;)V
    .locals 0
    .param p1, "x0"    # Ljava/lang/Class;
    .param p2, "x1"    # Lcom/facebook/react/uimanager/ViewManagerPropertyUpdater$1;

    .prologue
    .line 116
    .local p0, "this":Lcom/facebook/react/uimanager/ViewManagerPropertyUpdater$FallbackViewManagerSetter;, "Lcom/facebook/react/uimanager/ViewManagerPropertyUpdater$FallbackViewManagerSetter<TT;TV;>;"
    invoke-direct {p0, p1}, Lcom/facebook/react/uimanager/ViewManagerPropertyUpdater$FallbackViewManagerSetter;-><init>(Ljava/lang/Class;)V

    return-void
.end method


# virtual methods
.method public getProperties(Ljava/util/Map;)V
    .locals 4
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/util/Map",
            "<",
            "Ljava/lang/String;",
            "Ljava/lang/String;",
            ">;)V"
        }
    .end annotation

    .prologue
    .line 135
    .local p0, "this":Lcom/facebook/react/uimanager/ViewManagerPropertyUpdater$FallbackViewManagerSetter;, "Lcom/facebook/react/uimanager/ViewManagerPropertyUpdater$FallbackViewManagerSetter<TT;TV;>;"
    .local p1, "props":Ljava/util/Map;, "Ljava/util/Map<Ljava/lang/String;Ljava/lang/String;>;"
    iget-object v1, p0, Lcom/facebook/react/uimanager/ViewManagerPropertyUpdater$FallbackViewManagerSetter;->mPropSetters:Ljava/util/Map;

    invoke-interface {v1}, Ljava/util/Map;->values()Ljava/util/Collection;

    move-result-object v1

    invoke-interface {v1}, Ljava/util/Collection;->iterator()Ljava/util/Iterator;

    move-result-object v1

    :goto_0
    invoke-interface {v1}, Ljava/util/Iterator;->hasNext()Z

    move-result v2

    if-eqz v2, :cond_0

    invoke-interface {v1}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/facebook/react/uimanager/ViewManagersPropertyCache$PropSetter;

    .line 136
    .local v0, "setter":Lcom/facebook/react/uimanager/ViewManagersPropertyCache$PropSetter;
    invoke-virtual {v0}, Lcom/facebook/react/uimanager/ViewManagersPropertyCache$PropSetter;->getPropName()Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v0}, Lcom/facebook/react/uimanager/ViewManagersPropertyCache$PropSetter;->getPropType()Ljava/lang/String;

    move-result-object v3

    invoke-interface {p1, v2, v3}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    goto :goto_0

    .line 138
    .end local v0    # "setter":Lcom/facebook/react/uimanager/ViewManagersPropertyCache$PropSetter;
    :cond_0
    return-void
.end method

.method public setProperty(Lcom/facebook/react/uimanager/ViewManager;Landroid/view/View;Ljava/lang/String;Lcom/facebook/react/uimanager/ReactStylesDiffMap;)V
    .locals 2
    .param p3, "name"    # Ljava/lang/String;
    .param p4, "props"    # Lcom/facebook/react/uimanager/ReactStylesDiffMap;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(TT;TV;",
            "Ljava/lang/String;",
            "Lcom/facebook/react/uimanager/ReactStylesDiffMap;",
            ")V"
        }
    .end annotation

    .prologue
    .line 127
    .local p0, "this":Lcom/facebook/react/uimanager/ViewManagerPropertyUpdater$FallbackViewManagerSetter;, "Lcom/facebook/react/uimanager/ViewManagerPropertyUpdater$FallbackViewManagerSetter<TT;TV;>;"
    .local p1, "manager":Lcom/facebook/react/uimanager/ViewManager;, "TT;"
    .local p2, "v":Landroid/view/View;, "TV;"
    iget-object v1, p0, Lcom/facebook/react/uimanager/ViewManagerPropertyUpdater$FallbackViewManagerSetter;->mPropSetters:Ljava/util/Map;

    invoke-interface {v1, p3}, Ljava/util/Map;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/facebook/react/uimanager/ViewManagersPropertyCache$PropSetter;

    .line 128
    .local v0, "setter":Lcom/facebook/react/uimanager/ViewManagersPropertyCache$PropSetter;
    if-eqz v0, :cond_0

    .line 129
    invoke-virtual {v0, p1, p2, p4}, Lcom/facebook/react/uimanager/ViewManagersPropertyCache$PropSetter;->updateViewProp(Lcom/facebook/react/uimanager/ViewManager;Landroid/view/View;Lcom/facebook/react/uimanager/ReactStylesDiffMap;)V

    .line 131
    :cond_0
    return-void
.end method

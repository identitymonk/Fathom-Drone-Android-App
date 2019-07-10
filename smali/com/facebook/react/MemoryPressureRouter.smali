.class public Lcom/facebook/react/MemoryPressureRouter;
.super Ljava/lang/Object;
.source "MemoryPressureRouter.java"

# interfaces
.implements Landroid/content/ComponentCallbacks2;


# instance fields
.field private final mListeners:Ljava/util/Set;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/Set",
            "<",
            "Lcom/facebook/react/bridge/MemoryPressureListener;",
            ">;"
        }
    .end annotation
.end field


# direct methods
.method constructor <init>(Landroid/content/Context;)V
    .locals 1
    .param p1, "context"    # Landroid/content/Context;

    .prologue
    .line 20
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 17
    new-instance v0, Ljava/util/LinkedHashSet;

    invoke-direct {v0}, Ljava/util/LinkedHashSet;-><init>()V

    .line 18
    invoke-static {v0}, Ljava/util/Collections;->synchronizedSet(Ljava/util/Set;)Ljava/util/Set;

    move-result-object v0

    iput-object v0, p0, Lcom/facebook/react/MemoryPressureRouter;->mListeners:Ljava/util/Set;

    .line 21
    invoke-virtual {p1}, Landroid/content/Context;->getApplicationContext()Landroid/content/Context;

    move-result-object v0

    invoke-virtual {v0, p0}, Landroid/content/Context;->registerComponentCallbacks(Landroid/content/ComponentCallbacks;)V

    .line 22
    return-void
.end method

.method private dispatchMemoryPressure(I)V
    .locals 4
    .param p1, "level"    # I

    .prologue
    .line 58
    iget-object v2, p0, Lcom/facebook/react/MemoryPressureRouter;->mListeners:Ljava/util/Set;

    iget-object v3, p0, Lcom/facebook/react/MemoryPressureRouter;->mListeners:Ljava/util/Set;

    .line 59
    invoke-interface {v3}, Ljava/util/Set;->size()I

    move-result v3

    new-array v3, v3, [Lcom/facebook/react/bridge/MemoryPressureListener;

    invoke-interface {v2, v3}, Ljava/util/Set;->toArray([Ljava/lang/Object;)[Ljava/lang/Object;

    move-result-object v1

    check-cast v1, [Lcom/facebook/react/bridge/MemoryPressureListener;

    .line 60
    .local v1, "listeners":[Lcom/facebook/react/bridge/MemoryPressureListener;
    array-length v3, v1

    const/4 v2, 0x0

    :goto_0
    if-ge v2, v3, :cond_0

    aget-object v0, v1, v2

    .line 61
    .local v0, "listener":Lcom/facebook/react/bridge/MemoryPressureListener;
    invoke-interface {v0, p1}, Lcom/facebook/react/bridge/MemoryPressureListener;->handleMemoryPressure(I)V

    .line 60
    add-int/lit8 v2, v2, 0x1

    goto :goto_0

    .line 63
    .end local v0    # "listener":Lcom/facebook/react/bridge/MemoryPressureListener;
    :cond_0
    return-void
.end method


# virtual methods
.method public addMemoryPressureListener(Lcom/facebook/react/bridge/MemoryPressureListener;)V
    .locals 1
    .param p1, "listener"    # Lcom/facebook/react/bridge/MemoryPressureListener;

    .prologue
    .line 32
    iget-object v0, p0, Lcom/facebook/react/MemoryPressureRouter;->mListeners:Ljava/util/Set;

    invoke-interface {v0, p1}, Ljava/util/Set;->add(Ljava/lang/Object;)Z

    .line 33
    return-void
.end method

.method public destroy(Landroid/content/Context;)V
    .locals 1
    .param p1, "context"    # Landroid/content/Context;

    .prologue
    .line 25
    invoke-virtual {p1}, Landroid/content/Context;->getApplicationContext()Landroid/content/Context;

    move-result-object v0

    invoke-virtual {v0, p0}, Landroid/content/Context;->unregisterComponentCallbacks(Landroid/content/ComponentCallbacks;)V

    .line 26
    return-void
.end method

.method public onConfigurationChanged(Landroid/content/res/Configuration;)V
    .locals 0
    .param p1, "newConfig"    # Landroid/content/res/Configuration;

    .prologue
    .line 49
    return-void
.end method

.method public onLowMemory()V
    .locals 0

    .prologue
    .line 53
    return-void
.end method

.method public onTrimMemory(I)V
    .locals 0
    .param p1, "level"    # I

    .prologue
    .line 44
    invoke-direct {p0, p1}, Lcom/facebook/react/MemoryPressureRouter;->dispatchMemoryPressure(I)V

    .line 45
    return-void
.end method

.method public removeMemoryPressureListener(Lcom/facebook/react/bridge/MemoryPressureListener;)V
    .locals 1
    .param p1, "listener"    # Lcom/facebook/react/bridge/MemoryPressureListener;

    .prologue
    .line 39
    iget-object v0, p0, Lcom/facebook/react/MemoryPressureRouter;->mListeners:Ljava/util/Set;

    invoke-interface {v0, p1}, Ljava/util/Set;->remove(Ljava/lang/Object;)Z

    .line 40
    return-void
.end method

.class public final Lcom/facebook/react/flat/FlatUIImplementationProvider;
.super Lcom/facebook/react/uimanager/UIImplementationProvider;
.source "FlatUIImplementationProvider.java"


# instance fields
.field private final mMemoryImprovementEnabled:Z


# direct methods
.method public constructor <init>()V
    .locals 1

    .prologue
    .line 26
    invoke-direct {p0}, Lcom/facebook/react/uimanager/UIImplementationProvider;-><init>()V

    .line 27
    const/4 v0, 0x1

    iput-boolean v0, p0, Lcom/facebook/react/flat/FlatUIImplementationProvider;->mMemoryImprovementEnabled:Z

    .line 28
    return-void
.end method

.method public constructor <init>(Z)V
    .locals 0
    .param p1, "memoryImprovementEnabled"    # Z

    .prologue
    .line 30
    invoke-direct {p0}, Lcom/facebook/react/uimanager/UIImplementationProvider;-><init>()V

    .line 31
    iput-boolean p1, p0, Lcom/facebook/react/flat/FlatUIImplementationProvider;->mMemoryImprovementEnabled:Z

    .line 32
    return-void
.end method


# virtual methods
.method public createUIImplementation(Lcom/facebook/react/bridge/ReactApplicationContext;Lcom/facebook/react/uimanager/UIManagerModule$ViewManagerResolver;Lcom/facebook/react/uimanager/events/EventDispatcher;I)Lcom/facebook/react/flat/FlatUIImplementation;
    .locals 2
    .param p1, "reactContext"    # Lcom/facebook/react/bridge/ReactApplicationContext;
    .param p2, "viewManagerResolver"    # Lcom/facebook/react/uimanager/UIManagerModule$ViewManagerResolver;
    .param p3, "eventDispatcher"    # Lcom/facebook/react/uimanager/events/EventDispatcher;
    .param p4, "minTimeLeftInFrameForNonBatchedOperationMs"    # I

    .prologue
    .line 54
    new-instance v0, Ljava/lang/UnsupportedOperationException;

    const-string v1, "Lazy version of FlatUIImplementations are not supported"

    invoke-direct {v0, v1}, Ljava/lang/UnsupportedOperationException;-><init>(Ljava/lang/String;)V

    throw v0
.end method

.method public createUIImplementation(Lcom/facebook/react/bridge/ReactApplicationContext;Ljava/util/List;Lcom/facebook/react/uimanager/events/EventDispatcher;I)Lcom/facebook/react/flat/FlatUIImplementation;
    .locals 1
    .param p1, "reactContext"    # Lcom/facebook/react/bridge/ReactApplicationContext;
    .param p3, "eventDispatcher"    # Lcom/facebook/react/uimanager/events/EventDispatcher;
    .param p4, "minTimeLeftInFrameForNonBatchedOperationMs"    # I
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Lcom/facebook/react/bridge/ReactApplicationContext;",
            "Ljava/util/List",
            "<",
            "Lcom/facebook/react/uimanager/ViewManager;",
            ">;",
            "Lcom/facebook/react/uimanager/events/EventDispatcher;",
            "I)",
            "Lcom/facebook/react/flat/FlatUIImplementation;"
        }
    .end annotation

    .prologue
    .line 40
    .local p2, "viewManagers":Ljava/util/List;, "Ljava/util/List<Lcom/facebook/react/uimanager/ViewManager;>;"
    iget-boolean v0, p0, Lcom/facebook/react/flat/FlatUIImplementationProvider;->mMemoryImprovementEnabled:Z

    invoke-static {p1, p2, p3, v0, p4}, Lcom/facebook/react/flat/FlatUIImplementation;->createInstance(Lcom/facebook/react/bridge/ReactApplicationContext;Ljava/util/List;Lcom/facebook/react/uimanager/events/EventDispatcher;ZI)Lcom/facebook/react/flat/FlatUIImplementation;

    move-result-object v0

    return-object v0
.end method

.method public bridge synthetic createUIImplementation(Lcom/facebook/react/bridge/ReactApplicationContext;Lcom/facebook/react/uimanager/UIManagerModule$ViewManagerResolver;Lcom/facebook/react/uimanager/events/EventDispatcher;I)Lcom/facebook/react/uimanager/UIImplementation;
    .locals 1

    .prologue
    .line 22
    invoke-virtual {p0, p1, p2, p3, p4}, Lcom/facebook/react/flat/FlatUIImplementationProvider;->createUIImplementation(Lcom/facebook/react/bridge/ReactApplicationContext;Lcom/facebook/react/uimanager/UIManagerModule$ViewManagerResolver;Lcom/facebook/react/uimanager/events/EventDispatcher;I)Lcom/facebook/react/flat/FlatUIImplementation;

    move-result-object v0

    return-object v0
.end method

.method public bridge synthetic createUIImplementation(Lcom/facebook/react/bridge/ReactApplicationContext;Ljava/util/List;Lcom/facebook/react/uimanager/events/EventDispatcher;I)Lcom/facebook/react/uimanager/UIImplementation;
    .locals 1

    .prologue
    .line 22
    invoke-virtual {p0, p1, p2, p3, p4}, Lcom/facebook/react/flat/FlatUIImplementationProvider;->createUIImplementation(Lcom/facebook/react/bridge/ReactApplicationContext;Ljava/util/List;Lcom/facebook/react/uimanager/events/EventDispatcher;I)Lcom/facebook/react/flat/FlatUIImplementation;

    move-result-object v0

    return-object v0
.end method

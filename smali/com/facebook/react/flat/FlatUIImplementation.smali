.class public Lcom/facebook/react/flat/FlatUIImplementation;
.super Lcom/facebook/react/uimanager/UIImplementation;
.source "FlatUIImplementation.java"


# static fields
.field private static final flatManagerClassMap:Ljava/util/Map;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/Map",
            "<",
            "Ljava/lang/String;",
            "Ljava/lang/Class",
            "<+",
            "Lcom/facebook/react/uimanager/ViewManager;",
            ">;>;"
        }
    .end annotation
.end field


# instance fields
.field private final mMemoryImprovementEnabled:Z

.field private final mMoveProxy:Lcom/facebook/react/flat/MoveProxy;

.field private mRCTImageViewManager:Lcom/facebook/react/flat/RCTImageViewManager;
    .annotation runtime Ljavax/annotation/Nullable;
    .end annotation
.end field

.field private final mReactContext:Lcom/facebook/react/bridge/ReactApplicationContext;

.field private final mStateBuilder:Lcom/facebook/react/flat/StateBuilder;


# direct methods
.method static constructor <clinit>()V
    .locals 3

    .prologue
    .line 41
    new-instance v0, Ljava/util/HashMap;

    invoke-direct {v0}, Ljava/util/HashMap;-><init>()V

    sput-object v0, Lcom/facebook/react/flat/FlatUIImplementation;->flatManagerClassMap:Ljava/util/Map;

    .line 42
    sget-object v0, Lcom/facebook/react/flat/FlatUIImplementation;->flatManagerClassMap:Ljava/util/Map;

    const-string v1, "RCTView"

    const-class v2, Lcom/facebook/react/flat/RCTViewManager;

    invoke-interface {v0, v1, v2}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 43
    sget-object v0, Lcom/facebook/react/flat/FlatUIImplementation;->flatManagerClassMap:Ljava/util/Map;

    const-string v1, "RCTText"

    const-class v2, Lcom/facebook/react/flat/RCTTextManager;

    invoke-interface {v0, v1, v2}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 44
    sget-object v0, Lcom/facebook/react/flat/FlatUIImplementation;->flatManagerClassMap:Ljava/util/Map;

    const-string v1, "RCTRawText"

    const-class v2, Lcom/facebook/react/flat/RCTRawTextManager;

    invoke-interface {v0, v1, v2}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 45
    sget-object v0, Lcom/facebook/react/flat/FlatUIImplementation;->flatManagerClassMap:Ljava/util/Map;

    const-string v1, "RCTVirtualText"

    const-class v2, Lcom/facebook/react/flat/RCTVirtualTextManager;

    invoke-interface {v0, v1, v2}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 46
    sget-object v0, Lcom/facebook/react/flat/FlatUIImplementation;->flatManagerClassMap:Ljava/util/Map;

    const-string v1, "RCTTextInlineImage"

    const-class v2, Lcom/facebook/react/flat/RCTTextInlineImageManager;

    invoke-interface {v0, v1, v2}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 47
    sget-object v0, Lcom/facebook/react/flat/FlatUIImplementation;->flatManagerClassMap:Ljava/util/Map;

    const-string v1, "RCTImageView"

    const-class v2, Lcom/facebook/react/flat/RCTImageViewManager;

    invoke-interface {v0, v1, v2}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 48
    sget-object v0, Lcom/facebook/react/flat/FlatUIImplementation;->flatManagerClassMap:Ljava/util/Map;

    const-string v1, "AndroidTextInput"

    const-class v2, Lcom/facebook/react/flat/RCTTextInputManager;

    invoke-interface {v0, v1, v2}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 49
    sget-object v0, Lcom/facebook/react/flat/FlatUIImplementation;->flatManagerClassMap:Ljava/util/Map;

    const-string v1, "AndroidViewPager"

    const-class v2, Lcom/facebook/react/flat/RCTViewPagerManager;

    invoke-interface {v0, v1, v2}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 50
    sget-object v0, Lcom/facebook/react/flat/FlatUIImplementation;->flatManagerClassMap:Ljava/util/Map;

    const-string v1, "ARTSurfaceView"

    const-class v2, Lcom/facebook/react/flat/FlatARTSurfaceViewManager;

    invoke-interface {v0, v1, v2}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 51
    sget-object v0, Lcom/facebook/react/flat/FlatUIImplementation;->flatManagerClassMap:Ljava/util/Map;

    const-string v1, "RCTModalHostView"

    const-class v2, Lcom/facebook/react/flat/RCTModalHostManager;

    invoke-interface {v0, v1, v2}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 52
    return-void
.end method

.method private constructor <init>(Lcom/facebook/react/bridge/ReactApplicationContext;Lcom/facebook/react/flat/RCTImageViewManager;Lcom/facebook/react/uimanager/ViewManagerRegistry;Lcom/facebook/react/flat/FlatUIViewOperationQueue;Lcom/facebook/react/uimanager/events/EventDispatcher;Z)V
    .locals 1
    .param p1, "reactContext"    # Lcom/facebook/react/bridge/ReactApplicationContext;
    .param p2, "rctImageViewManager"    # Lcom/facebook/react/flat/RCTImageViewManager;
        .annotation runtime Ljavax/annotation/Nullable;
        .end annotation
    .end param
    .param p3, "viewManagers"    # Lcom/facebook/react/uimanager/ViewManagerRegistry;
    .param p4, "operationsQueue"    # Lcom/facebook/react/flat/FlatUIViewOperationQueue;
    .param p5, "eventDispatcher"    # Lcom/facebook/react/uimanager/events/EventDispatcher;
    .param p6, "memoryImprovementEnabled"    # Z

    .prologue
    .line 140
    invoke-direct {p0, p1, p3, p4, p5}, Lcom/facebook/react/uimanager/UIImplementation;-><init>(Lcom/facebook/react/bridge/ReactApplicationContext;Lcom/facebook/react/uimanager/ViewManagerRegistry;Lcom/facebook/react/uimanager/UIViewOperationQueue;Lcom/facebook/react/uimanager/events/EventDispatcher;)V

    .line 127
    new-instance v0, Lcom/facebook/react/flat/MoveProxy;

    invoke-direct {v0}, Lcom/facebook/react/flat/MoveProxy;-><init>()V

    iput-object v0, p0, Lcom/facebook/react/flat/FlatUIImplementation;->mMoveProxy:Lcom/facebook/react/flat/MoveProxy;

    .line 141
    iput-object p1, p0, Lcom/facebook/react/flat/FlatUIImplementation;->mReactContext:Lcom/facebook/react/bridge/ReactApplicationContext;

    .line 142
    iput-object p2, p0, Lcom/facebook/react/flat/FlatUIImplementation;->mRCTImageViewManager:Lcom/facebook/react/flat/RCTImageViewManager;

    .line 143
    new-instance v0, Lcom/facebook/react/flat/StateBuilder;

    invoke-direct {v0, p4}, Lcom/facebook/react/flat/StateBuilder;-><init>(Lcom/facebook/react/flat/FlatUIViewOperationQueue;)V

    iput-object v0, p0, Lcom/facebook/react/flat/FlatUIImplementation;->mStateBuilder:Lcom/facebook/react/flat/StateBuilder;

    .line 144
    iput-boolean p6, p0, Lcom/facebook/react/flat/FlatUIImplementation;->mMemoryImprovementEnabled:Z

    .line 145
    return-void
.end method

.method private static addChildAt(Lcom/facebook/react/uimanager/ReactShadowNode;Lcom/facebook/react/uimanager/ReactShadowNode;II)V
    .locals 3
    .param p0, "parentNode"    # Lcom/facebook/react/uimanager/ReactShadowNode;
    .param p1, "childNode"    # Lcom/facebook/react/uimanager/ReactShadowNode;
    .param p2, "index"    # I
    .param p3, "prevIndex"    # I

    .prologue
    .line 559
    if-gt p2, p3, :cond_0

    .line 560
    new-instance v0, Ljava/lang/RuntimeException;

    new-instance v1, Ljava/lang/StringBuilder;

    invoke-direct {v1}, Ljava/lang/StringBuilder;-><init>()V

    const-string v2, "Invariant failure, needs sorting! "

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1, p2}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v1

    const-string v2, " <= "

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1, p3}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    invoke-direct {v0, v1}, Ljava/lang/RuntimeException;-><init>(Ljava/lang/String;)V

    throw v0

    .line 564
    :cond_0
    invoke-interface {p0, p1, p2}, Lcom/facebook/react/uimanager/ReactShadowNode;->addChildAt(Lcom/facebook/react/uimanager/ReactShadowNode;I)V

    .line 565
    return-void
.end method

.method private addChildren(Lcom/facebook/react/uimanager/ReactShadowNode;Lcom/facebook/react/bridge/ReadableArray;Lcom/facebook/react/bridge/ReadableArray;)V
    .locals 10
    .param p1, "parentNode"    # Lcom/facebook/react/uimanager/ReactShadowNode;
    .param p2, "addChildTags"    # Lcom/facebook/react/bridge/ReadableArray;
        .annotation runtime Ljavax/annotation/Nullable;
        .end annotation
    .end param
    .param p3, "addAtIndices"    # Lcom/facebook/react/bridge/ReadableArray;
        .annotation runtime Ljavax/annotation/Nullable;
        .end annotation
    .end param

    .prologue
    const/4 v9, 0x0

    .line 477
    const/4 v7, -0x1

    .line 481
    .local v7, "prevIndex":I
    iget-object v8, p0, Lcom/facebook/react/flat/FlatUIImplementation;->mMoveProxy:Lcom/facebook/react/flat/MoveProxy;

    invoke-virtual {v8}, Lcom/facebook/react/flat/MoveProxy;->size()I

    move-result v8

    if-nez v8, :cond_0

    .line 482
    const v5, 0x7fffffff

    .line 483
    .local v5, "moveToIndex":I
    const v4, 0x7fffffff

    .line 492
    .local v4, "moveToChildIndex":I
    :goto_0
    if-nez p3, :cond_1

    .line 493
    const/4 v6, 0x0

    .line 494
    .local v6, "numNodesToAdd":I
    const v2, 0x7fffffff

    .line 495
    .local v2, "addToIndex":I
    const v1, 0x7fffffff

    .line 506
    .local v1, "addToChildIndex":I
    :goto_1
    if-ge v1, v4, :cond_3

    .line 507
    invoke-interface {p2, v2}, Lcom/facebook/react/bridge/ReadableArray;->getInt(I)I

    move-result v8

    invoke-virtual {p0, v8}, Lcom/facebook/react/flat/FlatUIImplementation;->resolveShadowNode(I)Lcom/facebook/react/uimanager/ReactShadowNode;

    move-result-object v0

    .line 508
    .local v0, "addToChild":Lcom/facebook/react/uimanager/ReactShadowNode;
    invoke-static {p1, v0, v1, v7}, Lcom/facebook/react/flat/FlatUIImplementation;->addChildAt(Lcom/facebook/react/uimanager/ReactShadowNode;Lcom/facebook/react/uimanager/ReactShadowNode;II)V

    .line 509
    move v7, v1

    .line 511
    add-int/lit8 v2, v2, 0x1

    .line 512
    if-ne v2, v6, :cond_2

    .line 513
    const v1, 0x7fffffff

    goto :goto_1

    .line 485
    .end local v0    # "addToChild":Lcom/facebook/react/uimanager/ReactShadowNode;
    .end local v1    # "addToChildIndex":I
    .end local v2    # "addToIndex":I
    .end local v4    # "moveToChildIndex":I
    .end local v5    # "moveToIndex":I
    .end local v6    # "numNodesToAdd":I
    :cond_0
    const/4 v5, 0x0

    .line 486
    .restart local v5    # "moveToIndex":I
    iget-object v8, p0, Lcom/facebook/react/flat/FlatUIImplementation;->mMoveProxy:Lcom/facebook/react/flat/MoveProxy;

    invoke-virtual {v8, v9}, Lcom/facebook/react/flat/MoveProxy;->getMoveTo(I)I

    move-result v4

    .restart local v4    # "moveToChildIndex":I
    goto :goto_0

    .line 497
    :cond_1
    invoke-interface {p3}, Lcom/facebook/react/bridge/ReadableArray;->size()I

    move-result v6

    .line 498
    .restart local v6    # "numNodesToAdd":I
    const/4 v2, 0x0

    .line 499
    .restart local v2    # "addToIndex":I
    invoke-interface {p3, v9}, Lcom/facebook/react/bridge/ReadableArray;->getInt(I)I

    move-result v1

    .restart local v1    # "addToChildIndex":I
    goto :goto_1

    .line 515
    .restart local v0    # "addToChild":Lcom/facebook/react/uimanager/ReactShadowNode;
    :cond_2
    invoke-interface {p3, v2}, Lcom/facebook/react/bridge/ReadableArray;->getInt(I)I

    move-result v1

    goto :goto_1

    .line 517
    .end local v0    # "addToChild":Lcom/facebook/react/uimanager/ReactShadowNode;
    :cond_3
    if-ge v4, v1, :cond_5

    .line 518
    iget-object v8, p0, Lcom/facebook/react/flat/FlatUIImplementation;->mMoveProxy:Lcom/facebook/react/flat/MoveProxy;

    invoke-virtual {v8, v5}, Lcom/facebook/react/flat/MoveProxy;->getChildMoveTo(I)Lcom/facebook/react/uimanager/ReactShadowNode;

    move-result-object v3

    .line 519
    .local v3, "moveToChild":Lcom/facebook/react/uimanager/ReactShadowNode;
    invoke-static {p1, v3, v4, v7}, Lcom/facebook/react/flat/FlatUIImplementation;->addChildAt(Lcom/facebook/react/uimanager/ReactShadowNode;Lcom/facebook/react/uimanager/ReactShadowNode;II)V

    .line 520
    move v7, v4

    .line 522
    add-int/lit8 v5, v5, 0x1

    .line 523
    iget-object v8, p0, Lcom/facebook/react/flat/FlatUIImplementation;->mMoveProxy:Lcom/facebook/react/flat/MoveProxy;

    invoke-virtual {v8}, Lcom/facebook/react/flat/MoveProxy;->size()I

    move-result v8

    if-ne v5, v8, :cond_4

    .line 524
    const v4, 0x7fffffff

    goto :goto_1

    .line 526
    :cond_4
    iget-object v8, p0, Lcom/facebook/react/flat/FlatUIImplementation;->mMoveProxy:Lcom/facebook/react/flat/MoveProxy;

    invoke-virtual {v8, v5}, Lcom/facebook/react/flat/MoveProxy;->getMoveTo(I)I

    move-result v4

    goto :goto_1

    .line 534
    .end local v3    # "moveToChild":Lcom/facebook/react/uimanager/ReactShadowNode;
    :cond_5
    return-void
.end method

.method private static buildViewManagerMap(Ljava/util/List;)Ljava/util/Map;
    .locals 10
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/util/List",
            "<",
            "Lcom/facebook/react/uimanager/ViewManager;",
            ">;)",
            "Ljava/util/Map",
            "<",
            "Ljava/lang/String;",
            "Lcom/facebook/react/uimanager/ViewManager;",
            ">;"
        }
    .end annotation

    .prologue
    .line 59
    .local p0, "viewManagers":Ljava/util/List;, "Ljava/util/List<Lcom/facebook/react/uimanager/ViewManager;>;"
    new-instance v6, Ljava/util/HashMap;

    invoke-direct {v6}, Ljava/util/HashMap;-><init>()V

    .line 60
    .local v6, "viewManagerMap":Ljava/util/Map;, "Ljava/util/Map<Ljava/lang/String;Lcom/facebook/react/uimanager/ViewManager;>;"
    invoke-interface {p0}, Ljava/util/List;->iterator()Ljava/util/Iterator;

    move-result-object v7

    :goto_0
    invoke-interface {v7}, Ljava/util/Iterator;->hasNext()Z

    move-result v8

    if-eqz v8, :cond_0

    invoke-interface {v7}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v5

    check-cast v5, Lcom/facebook/react/uimanager/ViewManager;

    .line 61
    .local v5, "viewManager":Lcom/facebook/react/uimanager/ViewManager;
    invoke-virtual {v5}, Lcom/facebook/react/uimanager/ViewManager;->getName()Ljava/lang/String;

    move-result-object v8

    invoke-interface {v6, v8, v5}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    goto :goto_0

    .line 63
    .end local v5    # "viewManager":Lcom/facebook/react/uimanager/ViewManager;
    :cond_0
    sget-object v7, Lcom/facebook/react/flat/FlatUIImplementation;->flatManagerClassMap:Ljava/util/Map;

    invoke-interface {v7}, Ljava/util/Map;->entrySet()Ljava/util/Set;

    move-result-object v7

    invoke-interface {v7}, Ljava/util/Set;->iterator()Ljava/util/Iterator;

    move-result-object v7

    :cond_1
    :goto_1
    invoke-interface {v7}, Ljava/util/Iterator;->hasNext()Z

    move-result v8

    if-eqz v8, :cond_2

    invoke-interface {v7}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Ljava/util/Map$Entry;

    .line 64
    .local v1, "entry":Ljava/util/Map$Entry;, "Ljava/util/Map$Entry<Ljava/lang/String;Ljava/lang/Class<+Lcom/facebook/react/uimanager/ViewManager;>;>;"
    invoke-interface {v1}, Ljava/util/Map$Entry;->getKey()Ljava/lang/Object;

    move-result-object v4

    check-cast v4, Ljava/lang/String;

    .line 65
    .local v4, "name":Ljava/lang/String;
    invoke-interface {v6, v4}, Ljava/util/Map;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v3

    check-cast v3, Lcom/facebook/react/uimanager/ViewManager;

    .line 66
    .local v3, "maybeFlatViewManager":Lcom/facebook/react/uimanager/ViewManager;
    if-eqz v3, :cond_1

    .line 71
    invoke-interface {v1}, Ljava/util/Map$Entry;->getValue()Ljava/lang/Object;

    move-result-object v2

    check-cast v2, Ljava/lang/Class;

    .line 72
    .local v2, "flatClazz":Ljava/lang/Class;, "Ljava/lang/Class<+Lcom/facebook/react/uimanager/ViewManager;>;"
    invoke-virtual {v3}, Ljava/lang/Object;->getClass()Ljava/lang/Class;

    move-result-object v8

    if-eq v8, v2, :cond_1

    .line 75
    :try_start_0
    invoke-virtual {v2}, Ljava/lang/Class;->newInstance()Ljava/lang/Object;

    move-result-object v8

    invoke-interface {v6, v4, v8}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    :try_end_0
    .catch Ljava/lang/IllegalAccessException; {:try_start_0 .. :try_end_0} :catch_0
    .catch Ljava/lang/InstantiationException; {:try_start_0 .. :try_end_0} :catch_1

    goto :goto_1

    .line 76
    :catch_0
    move-exception v0

    .line 77
    .local v0, "e":Ljava/lang/IllegalAccessException;
    new-instance v7, Ljava/lang/RuntimeException;

    new-instance v8, Ljava/lang/StringBuilder;

    invoke-direct {v8}, Ljava/lang/StringBuilder;-><init>()V

    const-string v9, "Unable to access flat class for "

    invoke-virtual {v8, v9}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v8

    invoke-virtual {v8, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v8

    invoke-virtual {v8}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v8

    invoke-direct {v7, v8, v0}, Ljava/lang/RuntimeException;-><init>(Ljava/lang/String;Ljava/lang/Throwable;)V

    throw v7

    .line 78
    .end local v0    # "e":Ljava/lang/IllegalAccessException;
    :catch_1
    move-exception v0

    .line 79
    .local v0, "e":Ljava/lang/InstantiationException;
    new-instance v7, Ljava/lang/RuntimeException;

    new-instance v8, Ljava/lang/StringBuilder;

    invoke-direct {v8}, Ljava/lang/StringBuilder;-><init>()V

    const-string v9, "Unable to instantiate flat class for "

    invoke-virtual {v8, v9}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v8

    invoke-virtual {v8, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v8

    invoke-virtual {v8}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v8

    invoke-direct {v7, v8, v0}, Ljava/lang/RuntimeException;-><init>(Ljava/lang/String;Ljava/lang/Throwable;)V

    throw v7

    .line 83
    .end local v0    # "e":Ljava/lang/InstantiationException;
    .end local v1    # "entry":Ljava/util/Map$Entry;, "Ljava/util/Map$Entry<Ljava/lang/String;Ljava/lang/Class<+Lcom/facebook/react/uimanager/ViewManager;>;>;"
    .end local v2    # "flatClazz":Ljava/lang/Class;, "Ljava/lang/Class<+Lcom/facebook/react/uimanager/ViewManager;>;"
    .end local v3    # "maybeFlatViewManager":Lcom/facebook/react/uimanager/ViewManager;
    .end local v4    # "name":Ljava/lang/String;
    :cond_2
    return-object v6
.end method

.method public static createInstance(Lcom/facebook/react/bridge/ReactApplicationContext;Ljava/util/List;Lcom/facebook/react/uimanager/events/EventDispatcher;ZI)Lcom/facebook/react/flat/FlatUIImplementation;
    .locals 10
    .param p0, "reactContext"    # Lcom/facebook/react/bridge/ReactApplicationContext;
    .param p2, "eventDispatcher"    # Lcom/facebook/react/uimanager/events/EventDispatcher;
    .param p3, "memoryImprovementEnabled"    # Z
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
            "ZI)",
            "Lcom/facebook/react/flat/FlatUIImplementation;"
        }
    .end annotation

    .prologue
    .line 93
    .local p1, "viewManagers":Ljava/util/List;, "Ljava/util/List<Lcom/facebook/react/uimanager/ViewManager;>;"
    invoke-static {p1}, Lcom/facebook/react/flat/FlatUIImplementation;->buildViewManagerMap(Ljava/util/List;)Ljava/util/Map;

    move-result-object v9

    .line 95
    .local v9, "viewManagerMap":Ljava/util/Map;, "Ljava/util/Map<Ljava/lang/String;Lcom/facebook/react/uimanager/ViewManager;>;"
    const-string v0, "RCTImageView"

    .line 96
    invoke-interface {v9, v0}, Ljava/util/Map;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v2

    check-cast v2, Lcom/facebook/react/flat/RCTImageViewManager;

    .line 97
    .local v2, "imageViewManager":Lcom/facebook/react/flat/RCTImageViewManager;
    if-eqz v2, :cond_0

    .line 98
    invoke-virtual {v2}, Lcom/facebook/react/flat/RCTImageViewManager;->getCallerContext()Ljava/lang/Object;

    move-result-object v7

    .line 99
    .local v7, "callerContext":Ljava/lang/Object;
    if-eqz v7, :cond_0

    .line 100
    invoke-static {v7}, Lcom/facebook/react/flat/RCTImageView;->setCallerContext(Ljava/lang/Object;)V

    .line 103
    .end local v7    # "callerContext":Ljava/lang/Object;
    :cond_0
    invoke-virtual {p0}, Lcom/facebook/react/bridge/ReactApplicationContext;->getResources()Landroid/content/res/Resources;

    move-result-object v0

    invoke-static {v0}, Lcom/facebook/react/flat/DraweeRequestHelper;->setResources(Landroid/content/res/Resources;)V

    .line 105
    invoke-virtual {p0}, Lcom/facebook/react/bridge/ReactApplicationContext;->getAssets()Landroid/content/res/AssetManager;

    move-result-object v0

    invoke-static {v0}, Lcom/facebook/react/flat/TypefaceCache;->setAssetManager(Landroid/content/res/AssetManager;)V

    .line 107
    new-instance v3, Lcom/facebook/react/uimanager/ViewManagerRegistry;

    invoke-direct {v3, v9}, Lcom/facebook/react/uimanager/ViewManagerRegistry;-><init>(Ljava/util/Map;)V

    .line 108
    .local v3, "viewManagerRegistry":Lcom/facebook/react/uimanager/ViewManagerRegistry;
    new-instance v8, Lcom/facebook/react/flat/FlatNativeViewHierarchyManager;

    invoke-direct {v8, v3}, Lcom/facebook/react/flat/FlatNativeViewHierarchyManager;-><init>(Lcom/facebook/react/uimanager/ViewManagerRegistry;)V

    .line 110
    .local v8, "nativeViewHierarchyManager":Lcom/facebook/react/flat/FlatNativeViewHierarchyManager;
    new-instance v4, Lcom/facebook/react/flat/FlatUIViewOperationQueue;

    invoke-direct {v4, p0, v8, p4}, Lcom/facebook/react/flat/FlatUIViewOperationQueue;-><init>(Lcom/facebook/react/bridge/ReactApplicationContext;Lcom/facebook/react/flat/FlatNativeViewHierarchyManager;I)V

    .line 113
    .local v4, "operationsQueue":Lcom/facebook/react/flat/FlatUIViewOperationQueue;
    new-instance v0, Lcom/facebook/react/flat/FlatUIImplementation;

    move-object v1, p0

    move-object v5, p2

    move v6, p3

    invoke-direct/range {v0 .. v6}, Lcom/facebook/react/flat/FlatUIImplementation;-><init>(Lcom/facebook/react/bridge/ReactApplicationContext;Lcom/facebook/react/flat/RCTImageViewManager;Lcom/facebook/react/uimanager/ViewManagerRegistry;Lcom/facebook/react/flat/FlatUIViewOperationQueue;Lcom/facebook/react/uimanager/events/EventDispatcher;Z)V

    return-object v0
.end method

.method private dropNativeViews(Lcom/facebook/react/uimanager/ReactShadowNode;Lcom/facebook/react/uimanager/ReactShadowNode;)V
    .locals 7
    .param p1, "child"    # Lcom/facebook/react/uimanager/ReactShadowNode;
    .param p2, "parentNode"    # Lcom/facebook/react/uimanager/ReactShadowNode;

    .prologue
    .line 428
    instance-of v6, p1, Lcom/facebook/react/flat/FlatShadowNode;

    if-eqz v6, :cond_3

    move-object v3, p1

    .line 429
    check-cast v3, Lcom/facebook/react/flat/FlatShadowNode;

    .line 430
    .local v3, "node":Lcom/facebook/react/flat/FlatShadowNode;
    invoke-virtual {v3}, Lcom/facebook/react/flat/FlatShadowNode;->mountsToView()Z

    move-result v6

    if-eqz v6, :cond_3

    invoke-virtual {v3}, Lcom/facebook/react/flat/FlatShadowNode;->isBackingViewCreated()Z

    move-result v6

    if-eqz v6, :cond_3

    .line 431
    const/4 v4, -0x1

    .line 438
    .local v4, "tag":I
    move-object v5, p2

    .line 439
    .local v5, "tmpNode":Lcom/facebook/react/uimanager/ReactShadowNode;
    :goto_0
    if-eqz v5, :cond_0

    .line 440
    instance-of v6, v5, Lcom/facebook/react/flat/FlatShadowNode;

    if-eqz v6, :cond_2

    move-object v1, v5

    .line 441
    check-cast v1, Lcom/facebook/react/flat/FlatShadowNode;

    .line 442
    .local v1, "flatTmpNode":Lcom/facebook/react/flat/FlatShadowNode;
    invoke-virtual {v1}, Lcom/facebook/react/flat/FlatShadowNode;->mountsToView()Z

    move-result v6

    if-eqz v6, :cond_2

    invoke-virtual {v1}, Lcom/facebook/react/flat/FlatShadowNode;->isBackingViewCreated()Z

    move-result v6

    if-eqz v6, :cond_2

    .line 443
    invoke-virtual {v1}, Lcom/facebook/react/flat/FlatShadowNode;->getParent()Lcom/facebook/react/uimanager/ReactShadowNodeImpl;

    move-result-object v6

    if-eqz v6, :cond_2

    .line 444
    invoke-virtual {v1}, Lcom/facebook/react/flat/FlatShadowNode;->getReactTag()I

    move-result v4

    .line 452
    .end local v1    # "flatTmpNode":Lcom/facebook/react/flat/FlatShadowNode;
    :cond_0
    iget-object v6, p0, Lcom/facebook/react/flat/FlatUIImplementation;->mStateBuilder:Lcom/facebook/react/flat/StateBuilder;

    invoke-virtual {v6, v3, v4}, Lcom/facebook/react/flat/StateBuilder;->dropView(Lcom/facebook/react/flat/FlatShadowNode;I)V

    .line 460
    .end local v3    # "node":Lcom/facebook/react/flat/FlatShadowNode;
    .end local v4    # "tag":I
    .end local v5    # "tmpNode":Lcom/facebook/react/uimanager/ReactShadowNode;
    :cond_1
    return-void

    .line 448
    .restart local v3    # "node":Lcom/facebook/react/flat/FlatShadowNode;
    .restart local v4    # "tag":I
    .restart local v5    # "tmpNode":Lcom/facebook/react/uimanager/ReactShadowNode;
    :cond_2
    invoke-interface {v5}, Lcom/facebook/react/uimanager/ReactShadowNode;->getParent()Lcom/facebook/react/uimanager/ReactShadowNode;

    move-result-object v5

    goto :goto_0

    .line 457
    .end local v3    # "node":Lcom/facebook/react/flat/FlatShadowNode;
    .end local v4    # "tag":I
    .end local v5    # "tmpNode":Lcom/facebook/react/uimanager/ReactShadowNode;
    :cond_3
    const/4 v2, 0x0

    .local v2, "i":I
    invoke-interface {p1}, Lcom/facebook/react/uimanager/ReactShadowNode;->getChildCount()I

    move-result v0

    .local v0, "childCount":I
    :goto_1
    if-eq v2, v0, :cond_1

    .line 458
    invoke-interface {p1, v2}, Lcom/facebook/react/uimanager/ReactShadowNode;->getChildAt(I)Lcom/facebook/react/uimanager/ReactShadowNode;

    move-result-object v6

    invoke-direct {p0, v6, p1}, Lcom/facebook/react/flat/FlatUIImplementation;->dropNativeViews(Lcom/facebook/react/uimanager/ReactShadowNode;Lcom/facebook/react/uimanager/ReactShadowNode;)V

    .line 457
    add-int/lit8 v2, v2, 0x1

    goto :goto_1
.end method

.method private ensureMountsToViewAndBackingViewIsCreated(I)V
    .locals 2
    .param p1, "reactTag"    # I

    .prologue
    .line 309
    invoke-virtual {p0, p1}, Lcom/facebook/react/flat/FlatUIImplementation;->resolveShadowNode(I)Lcom/facebook/react/uimanager/ReactShadowNode;

    move-result-object v0

    check-cast v0, Lcom/facebook/react/flat/FlatShadowNode;

    .line 310
    .local v0, "node":Lcom/facebook/react/flat/FlatShadowNode;
    invoke-virtual {v0}, Lcom/facebook/react/flat/FlatShadowNode;->isBackingViewCreated()Z

    move-result v1

    if-eqz v1, :cond_0

    .line 315
    :goto_0
    return-void

    .line 313
    :cond_0
    invoke-virtual {v0}, Lcom/facebook/react/flat/FlatShadowNode;->forceMountToView()V

    .line 314
    iget-object v1, p0, Lcom/facebook/react/flat/FlatUIImplementation;->mStateBuilder:Lcom/facebook/react/flat/StateBuilder;

    invoke-virtual {v1, v0}, Lcom/facebook/react/flat/StateBuilder;->ensureBackingViewIsCreated(Lcom/facebook/react/flat/FlatShadowNode;)V

    goto :goto_0
.end method

.method private measureHelper(IZLcom/facebook/react/bridge/Callback;)V
    .locals 19
    .param p1, "reactTag"    # I
    .param p2, "relativeToWindow"    # Z
    .param p3, "callback"    # Lcom/facebook/react/bridge/Callback;

    .prologue
    .line 254
    invoke-virtual/range {p0 .. p1}, Lcom/facebook/react/flat/FlatUIImplementation;->resolveShadowNode(I)Lcom/facebook/react/uimanager/ReactShadowNode;

    move-result-object v12

    check-cast v12, Lcom/facebook/react/flat/FlatShadowNode;

    .line 255
    .local v12, "node":Lcom/facebook/react/flat/FlatShadowNode;
    invoke-virtual {v12}, Lcom/facebook/react/flat/FlatShadowNode;->mountsToView()Z

    move-result v4

    if-eqz v4, :cond_2

    .line 256
    move-object/from16 v0, p0

    iget-object v4, v0, Lcom/facebook/react/flat/FlatUIImplementation;->mStateBuilder:Lcom/facebook/react/flat/StateBuilder;

    invoke-virtual {v4, v12}, Lcom/facebook/react/flat/StateBuilder;->ensureBackingViewIsCreated(Lcom/facebook/react/flat/FlatShadowNode;)V

    .line 257
    if-eqz p2, :cond_1

    .line 258
    move-object/from16 v0, p0

    move/from16 v1, p1

    move-object/from16 v2, p3

    invoke-super {v0, v1, v2}, Lcom/facebook/react/uimanager/UIImplementation;->measureInWindow(ILcom/facebook/react/bridge/Callback;)V

    .line 306
    :cond_0
    :goto_0
    return-void

    .line 260
    :cond_1
    move-object/from16 v0, p0

    move/from16 v1, p1

    move-object/from16 v2, p3

    invoke-super {v0, v1, v2}, Lcom/facebook/react/uimanager/UIImplementation;->measure(ILcom/facebook/react/bridge/Callback;)V

    goto :goto_0

    .line 267
    :cond_2
    :goto_1
    if-eqz v12, :cond_3

    invoke-virtual {v12}, Lcom/facebook/react/flat/FlatShadowNode;->isVirtual()Z

    move-result v4

    if-eqz v4, :cond_3

    .line 268
    invoke-virtual {v12}, Lcom/facebook/react/flat/FlatShadowNode;->getParent()Lcom/facebook/react/uimanager/ReactShadowNodeImpl;

    move-result-object v12

    .end local v12    # "node":Lcom/facebook/react/flat/FlatShadowNode;
    check-cast v12, Lcom/facebook/react/flat/FlatShadowNode;

    .restart local v12    # "node":Lcom/facebook/react/flat/FlatShadowNode;
    goto :goto_1

    .line 271
    :cond_3
    if-eqz v12, :cond_0

    .line 276
    invoke-virtual {v12}, Lcom/facebook/react/flat/FlatShadowNode;->getLayoutWidth()F

    move-result v16

    .line 277
    .local v16, "width":F
    invoke-virtual {v12}, Lcom/facebook/react/flat/FlatShadowNode;->getLayoutHeight()F

    move-result v11

    .line 279
    .local v11, "height":F
    invoke-virtual {v12}, Lcom/facebook/react/flat/FlatShadowNode;->mountsToView()Z

    move-result v13

    .line 282
    .local v13, "nodeMountsToView":Z
    if-eqz v13, :cond_5

    invoke-virtual {v12}, Lcom/facebook/react/flat/FlatShadowNode;->getLayoutX()F

    move-result v17

    .line 283
    .local v17, "xInParent":F
    :goto_2
    if-eqz v13, :cond_6

    invoke-virtual {v12}, Lcom/facebook/react/flat/FlatShadowNode;->getLayoutY()F

    move-result v18

    .line 285
    .local v18, "yInParent":F
    :goto_3
    invoke-virtual {v12}, Lcom/facebook/react/flat/FlatShadowNode;->mountsToView()Z

    move-result v4

    if-nez v4, :cond_7

    .line 286
    invoke-virtual {v12}, Lcom/facebook/react/flat/FlatShadowNode;->isVirtual()Z

    move-result v4

    if-nez v4, :cond_4

    .line 287
    invoke-virtual {v12}, Lcom/facebook/react/flat/FlatShadowNode;->getLayoutX()F

    move-result v4

    add-float v17, v17, v4

    .line 288
    invoke-virtual {v12}, Lcom/facebook/react/flat/FlatShadowNode;->getLayoutY()F

    move-result v4

    add-float v18, v18, v4

    .line 291
    :cond_4
    invoke-virtual {v12}, Lcom/facebook/react/flat/FlatShadowNode;->getParent()Lcom/facebook/react/uimanager/ReactShadowNodeImpl;

    move-result-object v4

    check-cast v4, Lcom/facebook/react/flat/FlatShadowNode;

    invoke-static {v4}, Lcom/facebook/infer/annotation/Assertions;->assumeNotNull(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v12

    .end local v12    # "node":Lcom/facebook/react/flat/FlatShadowNode;
    check-cast v12, Lcom/facebook/react/flat/FlatShadowNode;

    .restart local v12    # "node":Lcom/facebook/react/flat/FlatShadowNode;
    goto :goto_3

    .line 282
    .end local v17    # "xInParent":F
    .end local v18    # "yInParent":F
    :cond_5
    const/16 v17, 0x0

    goto :goto_2

    .line 283
    .restart local v17    # "xInParent":F
    :cond_6
    const/16 v18, 0x0

    goto :goto_3

    .line 294
    .restart local v18    # "yInParent":F
    :cond_7
    invoke-virtual {v12}, Lcom/facebook/react/flat/FlatShadowNode;->getLayoutWidth()F

    move-result v15

    .line 295
    .local v15, "parentWidth":F
    invoke-virtual {v12}, Lcom/facebook/react/flat/FlatShadowNode;->getLayoutHeight()F

    move-result v14

    .line 297
    .local v14, "parentHeight":F
    move-object/from16 v0, p0

    iget-object v4, v0, Lcom/facebook/react/flat/FlatUIImplementation;->mStateBuilder:Lcom/facebook/react/flat/StateBuilder;

    invoke-virtual {v4}, Lcom/facebook/react/flat/StateBuilder;->getOperationsQueue()Lcom/facebook/react/flat/FlatUIViewOperationQueue;

    move-result-object v3

    .line 299
    .local v3, "operationsQueue":Lcom/facebook/react/flat/FlatUIViewOperationQueue;
    invoke-virtual {v12}, Lcom/facebook/react/flat/FlatShadowNode;->getReactTag()I

    move-result v4

    div-float v5, v17, v15

    div-float v6, v18, v14

    div-float v7, v16, v15

    div-float v8, v11, v14

    move/from16 v9, p2

    move-object/from16 v10, p3

    .line 298
    invoke-virtual/range {v3 .. v10}, Lcom/facebook/react/flat/FlatUIViewOperationQueue;->enqueueMeasureVirtualView(IFFFFZLcom/facebook/react/bridge/Callback;)V

    goto/16 :goto_0
.end method

.method private moveChild(Lcom/facebook/react/uimanager/ReactShadowNode;I)V
    .locals 1
    .param p1, "child"    # Lcom/facebook/react/uimanager/ReactShadowNode;
    .param p2, "moveFromIndex"    # I

    .prologue
    .line 466
    iget-object v0, p0, Lcom/facebook/react/flat/FlatUIImplementation;->mMoveProxy:Lcom/facebook/react/flat/MoveProxy;

    invoke-virtual {v0, p2, p1}, Lcom/facebook/react/flat/MoveProxy;->setChildMoveFrom(ILcom/facebook/react/uimanager/ReactShadowNode;)V

    .line 467
    return-void
.end method

.method private removeChild(Lcom/facebook/react/uimanager/ReactShadowNode;Lcom/facebook/react/uimanager/ReactShadowNode;)V
    .locals 0
    .param p1, "child"    # Lcom/facebook/react/uimanager/ReactShadowNode;
    .param p2, "parentNode"    # Lcom/facebook/react/uimanager/ReactShadowNode;

    .prologue
    .line 423
    invoke-direct {p0, p1, p2}, Lcom/facebook/react/flat/FlatUIImplementation;->dropNativeViews(Lcom/facebook/react/uimanager/ReactShadowNode;Lcom/facebook/react/uimanager/ReactShadowNode;)V

    .line 424
    invoke-virtual {p0, p1}, Lcom/facebook/react/flat/FlatUIImplementation;->removeShadowNode(Lcom/facebook/react/uimanager/ReactShadowNode;)V

    .line 425
    return-void
.end method

.method private static removeChildAt(Lcom/facebook/react/uimanager/ReactShadowNode;II)Lcom/facebook/react/uimanager/ReactShadowNode;
    .locals 3
    .param p0, "parentNode"    # Lcom/facebook/react/uimanager/ReactShadowNode;
    .param p1, "index"    # I
    .param p2, "prevIndex"    # I

    .prologue
    .line 543
    if-lt p1, p2, :cond_0

    .line 544
    new-instance v0, Ljava/lang/RuntimeException;

    new-instance v1, Ljava/lang/StringBuilder;

    invoke-direct {v1}, Ljava/lang/StringBuilder;-><init>()V

    const-string v2, "Invariant failure, needs sorting! "

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1, p1}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v1

    const-string v2, " >= "

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1, p2}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    invoke-direct {v0, v1}, Ljava/lang/RuntimeException;-><init>(Ljava/lang/String;)V

    throw v0

    .line 548
    :cond_0
    invoke-interface {p0, p1}, Lcom/facebook/react/uimanager/ReactShadowNode;->removeChildAt(I)Lcom/facebook/react/uimanager/ReactShadowNode;

    move-result-object v0

    return-object v0
.end method

.method private removeChildren(Lcom/facebook/react/uimanager/ReactShadowNode;Lcom/facebook/react/bridge/ReadableArray;Lcom/facebook/react/bridge/ReadableArray;Lcom/facebook/react/bridge/ReadableArray;)V
    .locals 11
    .param p1, "parentNode"    # Lcom/facebook/react/uimanager/ReactShadowNode;
    .param p2, "moveFrom"    # Lcom/facebook/react/bridge/ReadableArray;
        .annotation runtime Ljavax/annotation/Nullable;
        .end annotation
    .end param
    .param p3, "moveTo"    # Lcom/facebook/react/bridge/ReadableArray;
        .annotation runtime Ljavax/annotation/Nullable;
        .end annotation
    .end param
    .param p4, "removeFrom"    # Lcom/facebook/react/bridge/ReadableArray;
        .annotation runtime Ljavax/annotation/Nullable;
        .end annotation
    .end param

    .prologue
    const/4 v9, -0x1

    .line 364
    const v6, 0x7fffffff

    .line 366
    .local v6, "prevIndex":I
    iget-object v10, p0, Lcom/facebook/react/flat/FlatUIImplementation;->mMoveProxy:Lcom/facebook/react/flat/MoveProxy;

    invoke-virtual {v10, p2, p3}, Lcom/facebook/react/flat/MoveProxy;->setup(Lcom/facebook/react/bridge/ReadableArray;Lcom/facebook/react/bridge/ReadableArray;)V

    .line 368
    iget-object v10, p0, Lcom/facebook/react/flat/FlatUIImplementation;->mMoveProxy:Lcom/facebook/react/flat/MoveProxy;

    invoke-virtual {v10}, Lcom/facebook/react/flat/MoveProxy;->size()I

    move-result v10

    add-int/lit8 v4, v10, -0x1

    .line 369
    .local v4, "moveFromIndex":I
    if-ne v4, v9, :cond_0

    move v3, v9

    .line 371
    .local v3, "moveFromChildIndex":I
    :goto_0
    if-nez p4, :cond_1

    const/4 v5, 0x0

    .line 372
    .local v5, "numToRemove":I
    :goto_1
    new-array v2, v5, [I

    .line 373
    .local v2, "indicesToRemove":[I
    if-lez v5, :cond_2

    .line 374
    invoke-static {p4}, Lcom/facebook/infer/annotation/Assertions;->assertNotNull(Ljava/lang/Object;)Ljava/lang/Object;

    .line 375
    const/4 v0, 0x0

    .local v0, "i":I
    :goto_2
    if-ge v0, v5, :cond_2

    .line 376
    invoke-interface {p4, v0}, Lcom/facebook/react/bridge/ReadableArray;->getInt(I)I

    move-result v1

    .line 377
    .local v1, "indexToRemove":I
    aput v1, v2, v0

    .line 375
    add-int/lit8 v0, v0, 0x1

    goto :goto_2

    .line 369
    .end local v0    # "i":I
    .end local v1    # "indexToRemove":I
    .end local v2    # "indicesToRemove":[I
    .end local v3    # "moveFromChildIndex":I
    .end local v5    # "numToRemove":I
    :cond_0
    iget-object v10, p0, Lcom/facebook/react/flat/FlatUIImplementation;->mMoveProxy:Lcom/facebook/react/flat/MoveProxy;

    invoke-virtual {v10, v4}, Lcom/facebook/react/flat/MoveProxy;->getMoveFrom(I)I

    move-result v3

    goto :goto_0

    .line 371
    .restart local v3    # "moveFromChildIndex":I
    :cond_1
    invoke-interface {p4}, Lcom/facebook/react/bridge/ReadableArray;->size()I

    move-result v5

    goto :goto_1

    .line 382
    .restart local v2    # "indicesToRemove":[I
    .restart local v5    # "numToRemove":I
    :cond_2
    invoke-static {v2}, Ljava/util/Arrays;->sort([I)V

    .line 386
    if-nez p4, :cond_3

    .line 387
    const/4 v8, -0x1

    .line 388
    .local v8, "removeFromIndex":I
    const/4 v7, -0x1

    .line 398
    .local v7, "removeFromChildIndex":I
    :goto_3
    if-le v3, v7, :cond_5

    .line 399
    invoke-static {p1, v3, v6}, Lcom/facebook/react/flat/FlatUIImplementation;->removeChildAt(Lcom/facebook/react/uimanager/ReactShadowNode;II)Lcom/facebook/react/uimanager/ReactShadowNode;

    move-result-object v10

    invoke-direct {p0, v10, v4}, Lcom/facebook/react/flat/FlatUIImplementation;->moveChild(Lcom/facebook/react/uimanager/ReactShadowNode;I)V

    .line 400
    move v6, v3

    .line 402
    add-int/lit8 v4, v4, -0x1

    .line 403
    if-ne v4, v9, :cond_4

    move v3, v9

    :goto_4
    goto :goto_3

    .line 390
    .end local v7    # "removeFromChildIndex":I
    .end local v8    # "removeFromIndex":I
    :cond_3
    array-length v10, v2

    add-int/lit8 v8, v10, -0x1

    .line 391
    .restart local v8    # "removeFromIndex":I
    aget v7, v2, v8

    .restart local v7    # "removeFromChildIndex":I
    goto :goto_3

    .line 403
    :cond_4
    iget-object v10, p0, Lcom/facebook/react/flat/FlatUIImplementation;->mMoveProxy:Lcom/facebook/react/flat/MoveProxy;

    invoke-virtual {v10, v4}, Lcom/facebook/react/flat/MoveProxy;->getMoveFrom(I)I

    move-result v3

    goto :goto_4

    .line 404
    :cond_5
    if-le v7, v3, :cond_7

    .line 405
    invoke-static {p1, v7, v6}, Lcom/facebook/react/flat/FlatUIImplementation;->removeChildAt(Lcom/facebook/react/uimanager/ReactShadowNode;II)Lcom/facebook/react/uimanager/ReactShadowNode;

    move-result-object v10

    invoke-direct {p0, v10, p1}, Lcom/facebook/react/flat/FlatUIImplementation;->removeChild(Lcom/facebook/react/uimanager/ReactShadowNode;Lcom/facebook/react/uimanager/ReactShadowNode;)V

    .line 406
    move v6, v7

    .line 408
    add-int/lit8 v8, v8, -0x1

    .line 409
    if-ne v8, v9, :cond_6

    move v7, v9

    :goto_5
    goto :goto_3

    :cond_6
    aget v7, v2, v8

    goto :goto_5

    .line 416
    :cond_7
    return-void
.end method


# virtual methods
.method public addAnimation(IILcom/facebook/react/bridge/Callback;)V
    .locals 0
    .param p1, "reactTag"    # I
    .param p2, "animationID"    # I
    .param p3, "onSuccess"    # Lcom/facebook/react/bridge/Callback;

    .prologue
    .line 330
    invoke-direct {p0, p1}, Lcom/facebook/react/flat/FlatUIImplementation;->ensureMountsToViewAndBackingViewIsCreated(I)V

    .line 331
    invoke-super {p0, p1, p2, p3}, Lcom/facebook/react/uimanager/UIImplementation;->addAnimation(IILcom/facebook/react/bridge/Callback;)V

    .line 332
    return-void
.end method

.method protected applyUpdatesRecursive(Lcom/facebook/react/uimanager/ReactShadowNode;FF)V
    .locals 1
    .param p1, "cssNode"    # Lcom/facebook/react/uimanager/ReactShadowNode;
    .param p2, "absoluteX"    # F
    .param p3, "absoluteY"    # F

    .prologue
    .line 578
    iget-object v0, p0, Lcom/facebook/react/flat/FlatUIImplementation;->mStateBuilder:Lcom/facebook/react/flat/StateBuilder;

    check-cast p1, Lcom/facebook/react/flat/FlatRootShadowNode;

    .end local p1    # "cssNode":Lcom/facebook/react/uimanager/ReactShadowNode;
    invoke-virtual {v0, p1}, Lcom/facebook/react/flat/StateBuilder;->applyUpdates(Lcom/facebook/react/flat/FlatShadowNode;)V

    .line 579
    return-void
.end method

.method protected createRootShadowNode()Lcom/facebook/react/uimanager/ReactShadowNode;
    .locals 4

    .prologue
    .line 149
    iget-object v2, p0, Lcom/facebook/react/flat/FlatUIImplementation;->mRCTImageViewManager:Lcom/facebook/react/flat/RCTImageViewManager;

    if-eqz v2, :cond_0

    .line 154
    iget-object v2, p0, Lcom/facebook/react/flat/FlatUIImplementation;->mReactContext:Lcom/facebook/react/bridge/ReactApplicationContext;

    const-class v3, Lcom/facebook/react/modules/fresco/FrescoModule;

    invoke-virtual {v2, v3}, Lcom/facebook/react/bridge/ReactApplicationContext;->getNativeModule(Ljava/lang/Class;)Lcom/facebook/react/bridge/NativeModule;

    .line 155
    iget-object v2, p0, Lcom/facebook/react/flat/FlatUIImplementation;->mRCTImageViewManager:Lcom/facebook/react/flat/RCTImageViewManager;

    .line 156
    invoke-virtual {v2}, Lcom/facebook/react/flat/RCTImageViewManager;->getDraweeControllerBuilder()Lcom/facebook/drawee/controller/AbstractDraweeControllerBuilder;

    move-result-object v2

    .line 155
    invoke-static {v2}, Lcom/facebook/react/flat/DraweeRequestHelper;->setDraweeControllerBuilder(Lcom/facebook/drawee/controller/AbstractDraweeControllerBuilder;)V

    .line 157
    const/4 v2, 0x0

    iput-object v2, p0, Lcom/facebook/react/flat/FlatUIImplementation;->mRCTImageViewManager:Lcom/facebook/react/flat/RCTImageViewManager;

    .line 160
    :cond_0
    new-instance v0, Lcom/facebook/react/flat/FlatRootShadowNode;

    invoke-direct {v0}, Lcom/facebook/react/flat/FlatRootShadowNode;-><init>()V

    .line 161
    .local v0, "node":Lcom/facebook/react/uimanager/ReactShadowNode;
    invoke-static {}, Lcom/facebook/react/modules/i18nmanager/I18nUtil;->getInstance()Lcom/facebook/react/modules/i18nmanager/I18nUtil;

    move-result-object v1

    .line 162
    .local v1, "sharedI18nUtilInstance":Lcom/facebook/react/modules/i18nmanager/I18nUtil;
    iget-object v2, p0, Lcom/facebook/react/flat/FlatUIImplementation;->mReactContext:Lcom/facebook/react/bridge/ReactApplicationContext;

    invoke-virtual {v1, v2}, Lcom/facebook/react/modules/i18nmanager/I18nUtil;->isRTL(Landroid/content/Context;)Z

    move-result v2

    if-eqz v2, :cond_1

    .line 163
    sget-object v2, Lcom/facebook/yoga/YogaDirection;->RTL:Lcom/facebook/yoga/YogaDirection;

    invoke-interface {v0, v2}, Lcom/facebook/react/uimanager/ReactShadowNode;->setLayoutDirection(Lcom/facebook/yoga/YogaDirection;)V

    .line 165
    :cond_1
    return-object v0
.end method

.method protected createShadowNode(Ljava/lang/String;)Lcom/facebook/react/uimanager/ReactShadowNode;
    .locals 3
    .param p1, "className"    # Ljava/lang/String;

    .prologue
    .line 170
    invoke-super {p0, p1}, Lcom/facebook/react/uimanager/UIImplementation;->createShadowNode(Ljava/lang/String;)Lcom/facebook/react/uimanager/ReactShadowNode;

    move-result-object v0

    .line 171
    .local v0, "cssNode":Lcom/facebook/react/uimanager/ReactShadowNode;
    instance-of v2, v0, Lcom/facebook/react/flat/FlatShadowNode;

    if-nez v2, :cond_0

    invoke-interface {v0}, Lcom/facebook/react/uimanager/ReactShadowNode;->isVirtual()Z

    move-result v2

    if-eqz v2, :cond_1

    .line 176
    .end local v0    # "cssNode":Lcom/facebook/react/uimanager/ReactShadowNode;
    :cond_0
    :goto_0
    return-object v0

    .line 175
    .restart local v0    # "cssNode":Lcom/facebook/react/uimanager/ReactShadowNode;
    :cond_1
    invoke-virtual {p0, p1}, Lcom/facebook/react/flat/FlatUIImplementation;->resolveViewManager(Ljava/lang/String;)Lcom/facebook/react/uimanager/ViewManager;

    move-result-object v1

    .line 176
    .local v1, "viewManager":Lcom/facebook/react/uimanager/ViewManager;
    new-instance v0, Lcom/facebook/react/flat/NativeViewWrapper;

    .end local v0    # "cssNode":Lcom/facebook/react/uimanager/ReactShadowNode;
    invoke-direct {v0, v1}, Lcom/facebook/react/flat/NativeViewWrapper;-><init>(Lcom/facebook/react/uimanager/ViewManager;)V

    goto :goto_0
.end method

.method public dispatchViewManagerCommand(IILcom/facebook/react/bridge/ReadableArray;)V
    .locals 1
    .param p1, "reactTag"    # I
    .param p2, "commandId"    # I
    .param p3, "commandArgs"    # Lcom/facebook/react/bridge/ReadableArray;

    .prologue
    .line 338
    invoke-direct {p0, p1}, Lcom/facebook/react/flat/FlatUIImplementation;->ensureMountsToViewAndBackingViewIsCreated(I)V

    .line 339
    iget-object v0, p0, Lcom/facebook/react/flat/FlatUIImplementation;->mStateBuilder:Lcom/facebook/react/flat/StateBuilder;

    invoke-virtual {v0, p1, p2, p3}, Lcom/facebook/react/flat/StateBuilder;->enqueueViewManagerCommand(IILcom/facebook/react/bridge/ReadableArray;)V

    .line 340
    return-void
.end method

.method public findSubviewIn(IFFLcom/facebook/react/bridge/Callback;)V
    .locals 0
    .param p1, "reactTag"    # I
    .param p2, "targetX"    # F
    .param p3, "targetY"    # F
    .param p4, "callback"    # Lcom/facebook/react/bridge/Callback;

    .prologue
    .line 319
    invoke-direct {p0, p1}, Lcom/facebook/react/flat/FlatUIImplementation;->ensureMountsToViewAndBackingViewIsCreated(I)V

    .line 320
    invoke-super {p0, p1, p2, p3, p4}, Lcom/facebook/react/uimanager/UIImplementation;->findSubviewIn(IFFLcom/facebook/react/bridge/Callback;)V

    .line 321
    return-void
.end method

.method protected handleCreateView(Lcom/facebook/react/uimanager/ReactShadowNode;ILcom/facebook/react/uimanager/ReactStylesDiffMap;)V
    .locals 2
    .param p1, "cssNode"    # Lcom/facebook/react/uimanager/ReactShadowNode;
    .param p2, "rootViewTag"    # I
    .param p3, "styles"    # Lcom/facebook/react/uimanager/ReactStylesDiffMap;
        .annotation runtime Ljavax/annotation/Nullable;
        .end annotation
    .end param

    .prologue
    .line 184
    instance-of v1, p1, Lcom/facebook/react/flat/FlatShadowNode;

    if-eqz v1, :cond_2

    move-object v0, p1

    .line 185
    check-cast v0, Lcom/facebook/react/flat/FlatShadowNode;

    .line 187
    .local v0, "node":Lcom/facebook/react/flat/FlatShadowNode;
    if-eqz p3, :cond_0

    .line 188
    invoke-virtual {v0, p3}, Lcom/facebook/react/flat/FlatShadowNode;->handleUpdateProperties(Lcom/facebook/react/uimanager/ReactStylesDiffMap;)V

    .line 191
    :cond_0
    invoke-virtual {v0}, Lcom/facebook/react/flat/FlatShadowNode;->mountsToView()Z

    move-result v1

    if-eqz v1, :cond_1

    .line 192
    iget-object v1, p0, Lcom/facebook/react/flat/FlatUIImplementation;->mStateBuilder:Lcom/facebook/react/flat/StateBuilder;

    invoke-virtual {v1, v0, p3}, Lcom/facebook/react/flat/StateBuilder;->enqueueCreateOrUpdateView(Lcom/facebook/react/flat/FlatShadowNode;Lcom/facebook/react/uimanager/ReactStylesDiffMap;)V

    .line 197
    .end local v0    # "node":Lcom/facebook/react/flat/FlatShadowNode;
    :cond_1
    :goto_0
    return-void

    .line 195
    :cond_2
    invoke-super {p0, p1, p2, p3}, Lcom/facebook/react/uimanager/UIImplementation;->handleCreateView(Lcom/facebook/react/uimanager/ReactShadowNode;ILcom/facebook/react/uimanager/ReactStylesDiffMap;)V

    goto :goto_0
.end method

.method protected handleUpdateView(Lcom/facebook/react/uimanager/ReactShadowNode;Ljava/lang/String;Lcom/facebook/react/uimanager/ReactStylesDiffMap;)V
    .locals 2
    .param p1, "cssNode"    # Lcom/facebook/react/uimanager/ReactShadowNode;
    .param p2, "className"    # Ljava/lang/String;
    .param p3, "styles"    # Lcom/facebook/react/uimanager/ReactStylesDiffMap;

    .prologue
    .line 204
    instance-of v1, p1, Lcom/facebook/react/flat/FlatShadowNode;

    if-eqz v1, :cond_1

    move-object v0, p1

    .line 205
    check-cast v0, Lcom/facebook/react/flat/FlatShadowNode;

    .line 207
    .local v0, "node":Lcom/facebook/react/flat/FlatShadowNode;
    invoke-virtual {v0, p3}, Lcom/facebook/react/flat/FlatShadowNode;->handleUpdateProperties(Lcom/facebook/react/uimanager/ReactStylesDiffMap;)V

    .line 209
    invoke-virtual {v0}, Lcom/facebook/react/flat/FlatShadowNode;->mountsToView()Z

    move-result v1

    if-eqz v1, :cond_0

    .line 210
    iget-object v1, p0, Lcom/facebook/react/flat/FlatUIImplementation;->mStateBuilder:Lcom/facebook/react/flat/StateBuilder;

    invoke-virtual {v1, v0, p3}, Lcom/facebook/react/flat/StateBuilder;->enqueueCreateOrUpdateView(Lcom/facebook/react/flat/FlatShadowNode;Lcom/facebook/react/uimanager/ReactStylesDiffMap;)V

    .line 215
    .end local v0    # "node":Lcom/facebook/react/flat/FlatShadowNode;
    :cond_0
    :goto_0
    return-void

    .line 213
    :cond_1
    invoke-super {p0, p1, p2, p3}, Lcom/facebook/react/uimanager/UIImplementation;->handleUpdateView(Lcom/facebook/react/uimanager/ReactShadowNode;Ljava/lang/String;Lcom/facebook/react/uimanager/ReactStylesDiffMap;)V

    goto :goto_0
.end method

.method public manageChildren(ILcom/facebook/react/bridge/ReadableArray;Lcom/facebook/react/bridge/ReadableArray;Lcom/facebook/react/bridge/ReadableArray;Lcom/facebook/react/bridge/ReadableArray;Lcom/facebook/react/bridge/ReadableArray;)V
    .locals 1
    .param p1, "viewTag"    # I
    .param p2, "moveFrom"    # Lcom/facebook/react/bridge/ReadableArray;
        .annotation runtime Ljavax/annotation/Nullable;
        .end annotation
    .end param
    .param p3, "moveTo"    # Lcom/facebook/react/bridge/ReadableArray;
        .annotation runtime Ljavax/annotation/Nullable;
        .end annotation
    .end param
    .param p4, "addChildTags"    # Lcom/facebook/react/bridge/ReadableArray;
        .annotation runtime Ljavax/annotation/Nullable;
        .end annotation
    .end param
    .param p5, "addAtIndices"    # Lcom/facebook/react/bridge/ReadableArray;
        .annotation runtime Ljavax/annotation/Nullable;
        .end annotation
    .end param
    .param p6, "removeFrom"    # Lcom/facebook/react/bridge/ReadableArray;
        .annotation runtime Ljavax/annotation/Nullable;
        .end annotation
    .end param

    .prologue
    .line 226
    invoke-virtual {p0, p1}, Lcom/facebook/react/flat/FlatUIImplementation;->resolveShadowNode(I)Lcom/facebook/react/uimanager/ReactShadowNode;

    move-result-object v0

    .line 229
    .local v0, "parentNode":Lcom/facebook/react/uimanager/ReactShadowNode;
    invoke-direct {p0, v0, p2, p3, p6}, Lcom/facebook/react/flat/FlatUIImplementation;->removeChildren(Lcom/facebook/react/uimanager/ReactShadowNode;Lcom/facebook/react/bridge/ReadableArray;Lcom/facebook/react/bridge/ReadableArray;Lcom/facebook/react/bridge/ReadableArray;)V

    .line 232
    invoke-direct {p0, v0, p4, p5}, Lcom/facebook/react/flat/FlatUIImplementation;->addChildren(Lcom/facebook/react/uimanager/ReactShadowNode;Lcom/facebook/react/bridge/ReadableArray;Lcom/facebook/react/bridge/ReadableArray;)V

    .line 233
    return-void
.end method

.method public measure(ILcom/facebook/react/bridge/Callback;)V
    .locals 1
    .param p1, "reactTag"    # I
    .param p2, "callback"    # Lcom/facebook/react/bridge/Callback;

    .prologue
    .line 250
    const/4 v0, 0x0

    invoke-direct {p0, p1, v0, p2}, Lcom/facebook/react/flat/FlatUIImplementation;->measureHelper(IZLcom/facebook/react/bridge/Callback;)V

    .line 251
    return-void
.end method

.method public measureInWindow(ILcom/facebook/react/bridge/Callback;)V
    .locals 1
    .param p1, "reactTag"    # I
    .param p2, "callback"    # Lcom/facebook/react/bridge/Callback;

    .prologue
    .line 325
    const/4 v0, 0x1

    invoke-direct {p0, p1, v0, p2}, Lcom/facebook/react/flat/FlatUIImplementation;->measureHelper(IZLcom/facebook/react/bridge/Callback;)V

    .line 326
    return-void
.end method

.method public removeRootView(I)V
    .locals 1
    .param p1, "rootViewTag"    # I

    .prologue
    .line 583
    iget-boolean v0, p0, Lcom/facebook/react/flat/FlatUIImplementation;->mMemoryImprovementEnabled:Z

    if-eqz v0, :cond_0

    .line 584
    invoke-virtual {p0, p1}, Lcom/facebook/react/flat/FlatUIImplementation;->removeRootShadowNode(I)V

    .line 586
    :cond_0
    iget-object v0, p0, Lcom/facebook/react/flat/FlatUIImplementation;->mStateBuilder:Lcom/facebook/react/flat/StateBuilder;

    invoke-virtual {v0, p1}, Lcom/facebook/react/flat/StateBuilder;->removeRootView(I)V

    .line 587
    return-void
.end method

.method public sendAccessibilityEvent(II)V
    .locals 0
    .param p1, "reactTag"    # I
    .param p2, "eventType"    # I

    .prologue
    .line 350
    invoke-direct {p0, p1}, Lcom/facebook/react/flat/FlatUIImplementation;->ensureMountsToViewAndBackingViewIsCreated(I)V

    .line 351
    invoke-super {p0, p1, p2}, Lcom/facebook/react/uimanager/UIImplementation;->sendAccessibilityEvent(II)V

    .line 352
    return-void
.end method

.method public setChildren(ILcom/facebook/react/bridge/ReadableArray;)V
    .locals 4
    .param p1, "viewTag"    # I
    .param p2, "children"    # Lcom/facebook/react/bridge/ReadableArray;

    .prologue
    .line 240
    invoke-virtual {p0, p1}, Lcom/facebook/react/flat/FlatUIImplementation;->resolveShadowNode(I)Lcom/facebook/react/uimanager/ReactShadowNode;

    move-result-object v2

    .line 242
    .local v2, "parentNode":Lcom/facebook/react/uimanager/ReactShadowNode;
    const/4 v1, 0x0

    .local v1, "i":I
    :goto_0
    invoke-interface {p2}, Lcom/facebook/react/bridge/ReadableArray;->size()I

    move-result v3

    if-ge v1, v3, :cond_0

    .line 243
    invoke-interface {p2, v1}, Lcom/facebook/react/bridge/ReadableArray;->getInt(I)I

    move-result v3

    invoke-virtual {p0, v3}, Lcom/facebook/react/flat/FlatUIImplementation;->resolveShadowNode(I)Lcom/facebook/react/uimanager/ReactShadowNode;

    move-result-object v0

    .line 244
    .local v0, "addToChild":Lcom/facebook/react/uimanager/ReactShadowNode;
    add-int/lit8 v3, v1, -0x1

    invoke-static {v2, v0, v1, v3}, Lcom/facebook/react/flat/FlatUIImplementation;->addChildAt(Lcom/facebook/react/uimanager/ReactShadowNode;Lcom/facebook/react/uimanager/ReactShadowNode;II)V

    .line 242
    add-int/lit8 v1, v1, 0x1

    goto :goto_0

    .line 246
    .end local v0    # "addToChild":Lcom/facebook/react/uimanager/ReactShadowNode;
    :cond_0
    return-void
.end method

.method public setJSResponder(IZ)V
    .locals 4
    .param p1, "possiblyVirtualReactTag"    # I
    .param p2, "blockNativeResponder"    # Z

    .prologue
    .line 591
    invoke-virtual {p0, p1}, Lcom/facebook/react/flat/FlatUIImplementation;->resolveShadowNode(I)Lcom/facebook/react/uimanager/ReactShadowNode;

    move-result-object v0

    .line 592
    .local v0, "node":Lcom/facebook/react/uimanager/ReactShadowNode;
    :goto_0
    invoke-interface {v0}, Lcom/facebook/react/uimanager/ReactShadowNode;->isVirtual()Z

    move-result v3

    if-eqz v3, :cond_0

    .line 593
    invoke-interface {v0}, Lcom/facebook/react/uimanager/ReactShadowNode;->getParent()Lcom/facebook/react/uimanager/ReactShadowNode;

    move-result-object v0

    goto :goto_0

    .line 595
    :cond_0
    invoke-interface {v0}, Lcom/facebook/react/uimanager/ReactShadowNode;->getReactTag()I

    move-result v2

    .line 600
    .local v2, "tag":I
    :goto_1
    instance-of v3, v0, Lcom/facebook/react/flat/FlatShadowNode;

    if-eqz v3, :cond_1

    move-object v3, v0

    check-cast v3, Lcom/facebook/react/flat/FlatShadowNode;

    invoke-virtual {v3}, Lcom/facebook/react/flat/FlatShadowNode;->mountsToView()Z

    move-result v3

    if-nez v3, :cond_1

    .line 601
    invoke-interface {v0}, Lcom/facebook/react/uimanager/ReactShadowNode;->getParent()Lcom/facebook/react/uimanager/ReactShadowNode;

    move-result-object v0

    goto :goto_1

    .line 604
    :cond_1
    iget-object v3, p0, Lcom/facebook/react/flat/FlatUIImplementation;->mStateBuilder:Lcom/facebook/react/flat/StateBuilder;

    invoke-virtual {v3}, Lcom/facebook/react/flat/StateBuilder;->getOperationsQueue()Lcom/facebook/react/flat/FlatUIViewOperationQueue;

    move-result-object v1

    .line 605
    .local v1, "operationsQueue":Lcom/facebook/react/flat/FlatUIViewOperationQueue;
    if-nez v0, :cond_2

    .end local v2    # "tag":I
    :goto_2
    invoke-virtual {v1, v2, p1, p2}, Lcom/facebook/react/flat/FlatUIViewOperationQueue;->enqueueSetJSResponder(IIZ)V

    .line 609
    return-void

    .line 606
    .restart local v2    # "tag":I
    :cond_2
    invoke-interface {v0}, Lcom/facebook/react/uimanager/ReactShadowNode;->getReactTag()I

    move-result v2

    goto :goto_2
.end method

.method public showPopupMenu(ILcom/facebook/react/bridge/ReadableArray;Lcom/facebook/react/bridge/Callback;Lcom/facebook/react/bridge/Callback;)V
    .locals 0
    .param p1, "reactTag"    # I
    .param p2, "items"    # Lcom/facebook/react/bridge/ReadableArray;
    .param p3, "error"    # Lcom/facebook/react/bridge/Callback;
    .param p4, "success"    # Lcom/facebook/react/bridge/Callback;

    .prologue
    .line 344
    invoke-direct {p0, p1}, Lcom/facebook/react/flat/FlatUIImplementation;->ensureMountsToViewAndBackingViewIsCreated(I)V

    .line 345
    invoke-super {p0, p1, p2, p3, p4}, Lcom/facebook/react/uimanager/UIImplementation;->showPopupMenu(ILcom/facebook/react/bridge/ReadableArray;Lcom/facebook/react/bridge/Callback;Lcom/facebook/react/bridge/Callback;)V

    .line 346
    return-void
.end method

.method protected updateViewHierarchy()V
    .locals 2

    .prologue
    .line 569
    invoke-super {p0}, Lcom/facebook/react/uimanager/UIImplementation;->updateViewHierarchy()V

    .line 570
    iget-object v0, p0, Lcom/facebook/react/flat/FlatUIImplementation;->mStateBuilder:Lcom/facebook/react/flat/StateBuilder;

    iget-object v1, p0, Lcom/facebook/react/flat/FlatUIImplementation;->mEventDispatcher:Lcom/facebook/react/uimanager/events/EventDispatcher;

    invoke-virtual {v0, v1}, Lcom/facebook/react/flat/StateBuilder;->afterUpdateViewHierarchy(Lcom/facebook/react/uimanager/events/EventDispatcher;)V

    .line 571
    return-void
.end method

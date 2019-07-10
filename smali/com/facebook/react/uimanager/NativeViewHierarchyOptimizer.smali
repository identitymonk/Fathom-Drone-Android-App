.class public Lcom/facebook/react/uimanager/NativeViewHierarchyOptimizer;
.super Ljava/lang/Object;
.source "NativeViewHierarchyOptimizer.java"


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lcom/facebook/react/uimanager/NativeViewHierarchyOptimizer$NodeIndexPair;
    }
.end annotation


# static fields
.field private static final ENABLED:Z = true


# instance fields
.field private final mShadowNodeRegistry:Lcom/facebook/react/uimanager/ShadowNodeRegistry;

.field private final mTagsWithLayoutVisited:Landroid/util/SparseBooleanArray;

.field private final mUIViewOperationQueue:Lcom/facebook/react/uimanager/UIViewOperationQueue;


# direct methods
.method public constructor <init>(Lcom/facebook/react/uimanager/UIViewOperationQueue;Lcom/facebook/react/uimanager/ShadowNodeRegistry;)V
    .locals 1
    .param p1, "uiViewOperationQueue"    # Lcom/facebook/react/uimanager/UIViewOperationQueue;
    .param p2, "shadowNodeRegistry"    # Lcom/facebook/react/uimanager/ShadowNodeRegistry;

    .prologue
    .line 71
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 67
    new-instance v0, Landroid/util/SparseBooleanArray;

    invoke-direct {v0}, Landroid/util/SparseBooleanArray;-><init>()V

    iput-object v0, p0, Lcom/facebook/react/uimanager/NativeViewHierarchyOptimizer;->mTagsWithLayoutVisited:Landroid/util/SparseBooleanArray;

    .line 72
    iput-object p1, p0, Lcom/facebook/react/uimanager/NativeViewHierarchyOptimizer;->mUIViewOperationQueue:Lcom/facebook/react/uimanager/UIViewOperationQueue;

    .line 73
    iput-object p2, p0, Lcom/facebook/react/uimanager/NativeViewHierarchyOptimizer;->mShadowNodeRegistry:Lcom/facebook/react/uimanager/ShadowNodeRegistry;

    .line 74
    return-void
.end method

.method private addGrandchildren(Lcom/facebook/react/uimanager/ReactShadowNode;Lcom/facebook/react/uimanager/ReactShadowNode;I)V
    .locals 8
    .param p1, "nativeParent"    # Lcom/facebook/react/uimanager/ReactShadowNode;
    .param p2, "child"    # Lcom/facebook/react/uimanager/ReactShadowNode;
    .param p3, "index"    # I

    .prologue
    const/4 v6, 0x1

    const/4 v7, 0x0

    .line 314
    invoke-interface {p1}, Lcom/facebook/react/uimanager/ReactShadowNode;->isLayoutOnly()Z

    move-result v5

    if-nez v5, :cond_0

    move v5, v6

    :goto_0
    invoke-static {v5}, Lcom/facebook/infer/annotation/Assertions;->assertCondition(Z)V

    .line 317
    move v0, p3

    .line 318
    .local v0, "currentIndex":I
    const/4 v4, 0x0

    .local v4, "i":I
    :goto_1
    invoke-interface {p2}, Lcom/facebook/react/uimanager/ReactShadowNode;->getChildCount()I

    move-result v5

    if-ge v4, v5, :cond_3

    .line 319
    invoke-interface {p2, v4}, Lcom/facebook/react/uimanager/ReactShadowNode;->getChildAt(I)Lcom/facebook/react/uimanager/ReactShadowNode;

    move-result-object v1

    .line 320
    .local v1, "grandchild":Lcom/facebook/react/uimanager/ReactShadowNode;
    invoke-interface {v1}, Lcom/facebook/react/uimanager/ReactShadowNode;->getNativeParent()Lcom/facebook/react/uimanager/ReactShadowNode;

    move-result-object v5

    if-nez v5, :cond_1

    move v5, v6

    :goto_2
    invoke-static {v5}, Lcom/facebook/infer/annotation/Assertions;->assertCondition(Z)V

    .line 322
    invoke-interface {v1}, Lcom/facebook/react/uimanager/ReactShadowNode;->isLayoutOnly()Z

    move-result v5

    if-eqz v5, :cond_2

    .line 324
    invoke-interface {p1}, Lcom/facebook/react/uimanager/ReactShadowNode;->getNativeChildCount()I

    move-result v3

    .line 325
    .local v3, "grandchildCountBefore":I
    invoke-direct {p0, p1, v1, v0}, Lcom/facebook/react/uimanager/NativeViewHierarchyOptimizer;->addLayoutOnlyNode(Lcom/facebook/react/uimanager/ReactShadowNode;Lcom/facebook/react/uimanager/ReactShadowNode;I)V

    .line 326
    invoke-interface {p1}, Lcom/facebook/react/uimanager/ReactShadowNode;->getNativeChildCount()I

    move-result v2

    .line 327
    .local v2, "grandchildCountAfter":I
    sub-int v5, v2, v3

    add-int/2addr v0, v5

    .line 318
    .end local v2    # "grandchildCountAfter":I
    .end local v3    # "grandchildCountBefore":I
    :goto_3
    add-int/lit8 v4, v4, 0x1

    goto :goto_1

    .end local v0    # "currentIndex":I
    .end local v1    # "grandchild":Lcom/facebook/react/uimanager/ReactShadowNode;
    .end local v4    # "i":I
    :cond_0
    move v5, v7

    .line 314
    goto :goto_0

    .restart local v0    # "currentIndex":I
    .restart local v1    # "grandchild":Lcom/facebook/react/uimanager/ReactShadowNode;
    .restart local v4    # "i":I
    :cond_1
    move v5, v7

    .line 320
    goto :goto_2

    .line 329
    :cond_2
    invoke-direct {p0, p1, v1, v0}, Lcom/facebook/react/uimanager/NativeViewHierarchyOptimizer;->addNonLayoutNode(Lcom/facebook/react/uimanager/ReactShadowNode;Lcom/facebook/react/uimanager/ReactShadowNode;I)V

    .line 330
    add-int/lit8 v0, v0, 0x1

    goto :goto_3

    .line 333
    .end local v1    # "grandchild":Lcom/facebook/react/uimanager/ReactShadowNode;
    :cond_3
    return-void
.end method

.method private addLayoutOnlyNode(Lcom/facebook/react/uimanager/ReactShadowNode;Lcom/facebook/react/uimanager/ReactShadowNode;I)V
    .locals 0
    .param p1, "nonLayoutOnlyNode"    # Lcom/facebook/react/uimanager/ReactShadowNode;
    .param p2, "layoutOnlyNode"    # Lcom/facebook/react/uimanager/ReactShadowNode;
    .param p3, "index"    # I

    .prologue
    .line 295
    invoke-direct {p0, p1, p2, p3}, Lcom/facebook/react/uimanager/NativeViewHierarchyOptimizer;->addGrandchildren(Lcom/facebook/react/uimanager/ReactShadowNode;Lcom/facebook/react/uimanager/ReactShadowNode;I)V

    .line 296
    return-void
.end method

.method private addNodeToNode(Lcom/facebook/react/uimanager/ReactShadowNode;Lcom/facebook/react/uimanager/ReactShadowNode;I)V
    .locals 3
    .param p1, "parent"    # Lcom/facebook/react/uimanager/ReactShadowNode;
    .param p2, "child"    # Lcom/facebook/react/uimanager/ReactShadowNode;
    .param p3, "index"    # I

    .prologue
    .line 249
    invoke-interface {p1, p3}, Lcom/facebook/react/uimanager/ReactShadowNode;->getChildAt(I)Lcom/facebook/react/uimanager/ReactShadowNode;

    move-result-object v2

    invoke-interface {p1, v2}, Lcom/facebook/react/uimanager/ReactShadowNode;->getNativeOffsetForChild(Lcom/facebook/react/uimanager/ReactShadowNode;)I

    move-result v0

    .line 250
    .local v0, "indexInNativeChildren":I
    invoke-interface {p1}, Lcom/facebook/react/uimanager/ReactShadowNode;->isLayoutOnly()Z

    move-result v2

    if-eqz v2, :cond_1

    .line 251
    invoke-direct {p0, p1, v0}, Lcom/facebook/react/uimanager/NativeViewHierarchyOptimizer;->walkUpUntilNonLayoutOnly(Lcom/facebook/react/uimanager/ReactShadowNode;I)Lcom/facebook/react/uimanager/NativeViewHierarchyOptimizer$NodeIndexPair;

    move-result-object v1

    .line 252
    .local v1, "result":Lcom/facebook/react/uimanager/NativeViewHierarchyOptimizer$NodeIndexPair;
    if-nez v1, :cond_0

    .line 266
    .end local v1    # "result":Lcom/facebook/react/uimanager/NativeViewHierarchyOptimizer$NodeIndexPair;
    :goto_0
    return-void

    .line 257
    .restart local v1    # "result":Lcom/facebook/react/uimanager/NativeViewHierarchyOptimizer$NodeIndexPair;
    :cond_0
    iget-object p1, v1, Lcom/facebook/react/uimanager/NativeViewHierarchyOptimizer$NodeIndexPair;->node:Lcom/facebook/react/uimanager/ReactShadowNode;

    .line 258
    iget v0, v1, Lcom/facebook/react/uimanager/NativeViewHierarchyOptimizer$NodeIndexPair;->index:I

    .line 261
    .end local v1    # "result":Lcom/facebook/react/uimanager/NativeViewHierarchyOptimizer$NodeIndexPair;
    :cond_1
    invoke-interface {p2}, Lcom/facebook/react/uimanager/ReactShadowNode;->isLayoutOnly()Z

    move-result v2

    if-nez v2, :cond_2

    .line 262
    invoke-direct {p0, p1, p2, v0}, Lcom/facebook/react/uimanager/NativeViewHierarchyOptimizer;->addNonLayoutNode(Lcom/facebook/react/uimanager/ReactShadowNode;Lcom/facebook/react/uimanager/ReactShadowNode;I)V

    goto :goto_0

    .line 264
    :cond_2
    invoke-direct {p0, p1, p2, v0}, Lcom/facebook/react/uimanager/NativeViewHierarchyOptimizer;->addLayoutOnlyNode(Lcom/facebook/react/uimanager/ReactShadowNode;Lcom/facebook/react/uimanager/ReactShadowNode;I)V

    goto :goto_0
.end method

.method private addNonLayoutNode(Lcom/facebook/react/uimanager/ReactShadowNode;Lcom/facebook/react/uimanager/ReactShadowNode;I)V
    .locals 7
    .param p1, "parent"    # Lcom/facebook/react/uimanager/ReactShadowNode;
    .param p2, "child"    # Lcom/facebook/react/uimanager/ReactShadowNode;
    .param p3, "index"    # I

    .prologue
    const/4 v6, 0x0

    .line 302
    invoke-interface {p1, p2, p3}, Lcom/facebook/react/uimanager/ReactShadowNode;->addNativeChildAt(Lcom/facebook/react/uimanager/ReactShadowNode;I)V

    .line 303
    iget-object v0, p0, Lcom/facebook/react/uimanager/NativeViewHierarchyOptimizer;->mUIViewOperationQueue:Lcom/facebook/react/uimanager/UIViewOperationQueue;

    .line 304
    invoke-interface {p1}, Lcom/facebook/react/uimanager/ReactShadowNode;->getReactTag()I

    move-result v1

    const/4 v2, 0x1

    new-array v2, v2, [Lcom/facebook/react/uimanager/ViewAtIndex;

    const/4 v3, 0x0

    new-instance v4, Lcom/facebook/react/uimanager/ViewAtIndex;

    .line 306
    invoke-interface {p2}, Lcom/facebook/react/uimanager/ReactShadowNode;->getReactTag()I

    move-result v5

    invoke-direct {v4, v5, p3}, Lcom/facebook/react/uimanager/ViewAtIndex;-><init>(II)V

    aput-object v4, v2, v3

    .line 303
    invoke-virtual {v0, v1, v6, v2, v6}, Lcom/facebook/react/uimanager/UIViewOperationQueue;->enqueueManageChildren(I[I[Lcom/facebook/react/uimanager/ViewAtIndex;[I)V

    .line 308
    return-void
.end method

.method private applyLayoutBase(Lcom/facebook/react/uimanager/ReactShadowNode;)V
    .locals 6
    .param p1, "node"    # Lcom/facebook/react/uimanager/ReactShadowNode;

    .prologue
    .line 336
    invoke-interface {p1}, Lcom/facebook/react/uimanager/ReactShadowNode;->getReactTag()I

    move-result v1

    .line 337
    .local v1, "tag":I
    iget-object v4, p0, Lcom/facebook/react/uimanager/NativeViewHierarchyOptimizer;->mTagsWithLayoutVisited:Landroid/util/SparseBooleanArray;

    invoke-virtual {v4, v1}, Landroid/util/SparseBooleanArray;->get(I)Z

    move-result v4

    if-eqz v4, :cond_0

    .line 359
    :goto_0
    return-void

    .line 340
    :cond_0
    iget-object v4, p0, Lcom/facebook/react/uimanager/NativeViewHierarchyOptimizer;->mTagsWithLayoutVisited:Landroid/util/SparseBooleanArray;

    const/4 v5, 0x1

    invoke-virtual {v4, v1, v5}, Landroid/util/SparseBooleanArray;->put(IZ)V

    .line 342
    invoke-interface {p1}, Lcom/facebook/react/uimanager/ReactShadowNode;->getParent()Lcom/facebook/react/uimanager/ReactShadowNode;

    move-result-object v0

    .line 347
    .local v0, "parent":Lcom/facebook/react/uimanager/ReactShadowNode;
    invoke-interface {p1}, Lcom/facebook/react/uimanager/ReactShadowNode;->getScreenX()I

    move-result v2

    .line 348
    .local v2, "x":I
    invoke-interface {p1}, Lcom/facebook/react/uimanager/ReactShadowNode;->getScreenY()I

    move-result v3

    .line 350
    .local v3, "y":I
    :goto_1
    if-eqz v0, :cond_1

    invoke-interface {v0}, Lcom/facebook/react/uimanager/ReactShadowNode;->isLayoutOnly()Z

    move-result v4

    if-eqz v4, :cond_1

    .line 352
    invoke-interface {v0}, Lcom/facebook/react/uimanager/ReactShadowNode;->getLayoutX()F

    move-result v4

    invoke-static {v4}, Ljava/lang/Math;->round(F)I

    move-result v4

    add-int/2addr v2, v4

    .line 353
    invoke-interface {v0}, Lcom/facebook/react/uimanager/ReactShadowNode;->getLayoutY()F

    move-result v4

    invoke-static {v4}, Ljava/lang/Math;->round(F)I

    move-result v4

    add-int/2addr v3, v4

    .line 355
    invoke-interface {v0}, Lcom/facebook/react/uimanager/ReactShadowNode;->getParent()Lcom/facebook/react/uimanager/ReactShadowNode;

    move-result-object v0

    goto :goto_1

    .line 358
    :cond_1
    invoke-direct {p0, p1, v2, v3}, Lcom/facebook/react/uimanager/NativeViewHierarchyOptimizer;->applyLayoutRecursive(Lcom/facebook/react/uimanager/ReactShadowNode;II)V

    goto :goto_0
.end method

.method private applyLayoutRecursive(Lcom/facebook/react/uimanager/ReactShadowNode;II)V
    .locals 12
    .param p1, "toUpdate"    # Lcom/facebook/react/uimanager/ReactShadowNode;
    .param p2, "x"    # I
    .param p3, "y"    # I

    .prologue
    .line 362
    invoke-interface {p1}, Lcom/facebook/react/uimanager/ReactShadowNode;->isLayoutOnly()Z

    move-result v0

    if-nez v0, :cond_1

    invoke-interface {p1}, Lcom/facebook/react/uimanager/ReactShadowNode;->getNativeParent()Lcom/facebook/react/uimanager/ReactShadowNode;

    move-result-object v0

    if-eqz v0, :cond_1

    .line 363
    invoke-interface {p1}, Lcom/facebook/react/uimanager/ReactShadowNode;->getReactTag()I

    move-result v2

    .line 364
    .local v2, "tag":I
    iget-object v0, p0, Lcom/facebook/react/uimanager/NativeViewHierarchyOptimizer;->mUIViewOperationQueue:Lcom/facebook/react/uimanager/UIViewOperationQueue;

    .line 365
    invoke-interface {p1}, Lcom/facebook/react/uimanager/ReactShadowNode;->getNativeParent()Lcom/facebook/react/uimanager/ReactShadowNode;

    move-result-object v1

    invoke-interface {v1}, Lcom/facebook/react/uimanager/ReactShadowNode;->getReactTag()I

    move-result v1

    .line 369
    invoke-interface {p1}, Lcom/facebook/react/uimanager/ReactShadowNode;->getScreenWidth()I

    move-result v5

    .line 370
    invoke-interface {p1}, Lcom/facebook/react/uimanager/ReactShadowNode;->getScreenHeight()I

    move-result v6

    move v3, p2

    move v4, p3

    .line 364
    invoke-virtual/range {v0 .. v6}, Lcom/facebook/react/uimanager/UIViewOperationQueue;->enqueueUpdateLayout(IIIIII)V

    .line 390
    .end local v2    # "tag":I
    :cond_0
    return-void

    .line 374
    :cond_1
    const/4 v11, 0x0

    .local v11, "i":I
    :goto_0
    invoke-interface {p1}, Lcom/facebook/react/uimanager/ReactShadowNode;->getChildCount()I

    move-result v0

    if-ge v11, v0, :cond_0

    .line 375
    invoke-interface {p1, v11}, Lcom/facebook/react/uimanager/ReactShadowNode;->getChildAt(I)Lcom/facebook/react/uimanager/ReactShadowNode;

    move-result-object v7

    .line 376
    .local v7, "child":Lcom/facebook/react/uimanager/ReactShadowNode;
    invoke-interface {v7}, Lcom/facebook/react/uimanager/ReactShadowNode;->getReactTag()I

    move-result v8

    .line 377
    .local v8, "childTag":I
    iget-object v0, p0, Lcom/facebook/react/uimanager/NativeViewHierarchyOptimizer;->mTagsWithLayoutVisited:Landroid/util/SparseBooleanArray;

    invoke-virtual {v0, v8}, Landroid/util/SparseBooleanArray;->get(I)Z

    move-result v0

    if-eqz v0, :cond_2

    .line 374
    :goto_1
    add-int/lit8 v11, v11, 0x1

    goto :goto_0

    .line 380
    :cond_2
    iget-object v0, p0, Lcom/facebook/react/uimanager/NativeViewHierarchyOptimizer;->mTagsWithLayoutVisited:Landroid/util/SparseBooleanArray;

    const/4 v1, 0x1

    invoke-virtual {v0, v8, v1}, Landroid/util/SparseBooleanArray;->put(IZ)V

    .line 382
    invoke-interface {v7}, Lcom/facebook/react/uimanager/ReactShadowNode;->getScreenX()I

    move-result v9

    .line 383
    .local v9, "childX":I
    invoke-interface {v7}, Lcom/facebook/react/uimanager/ReactShadowNode;->getScreenY()I

    move-result v10

    .line 385
    .local v10, "childY":I
    add-int/2addr v9, p2

    .line 386
    add-int/2addr v10, p3

    .line 388
    invoke-direct {p0, v7, v9, v10}, Lcom/facebook/react/uimanager/NativeViewHierarchyOptimizer;->applyLayoutRecursive(Lcom/facebook/react/uimanager/ReactShadowNode;II)V

    goto :goto_1
.end method

.method public static handleRemoveNode(Lcom/facebook/react/uimanager/ReactShadowNode;)V
    .locals 0
    .param p0, "node"    # Lcom/facebook/react/uimanager/ReactShadowNode;

    .prologue
    .line 110
    invoke-interface {p0}, Lcom/facebook/react/uimanager/ReactShadowNode;->removeAllNativeChildren()V

    .line 111
    return-void
.end method

.method private static isLayoutOnlyAndCollapsable(Lcom/facebook/react/uimanager/ReactStylesDiffMap;)Z
    .locals 5
    .param p0, "props"    # Lcom/facebook/react/uimanager/ReactStylesDiffMap;
        .annotation runtime Ljavax/annotation/Nullable;
        .end annotation
    .end param

    .prologue
    const/4 v2, 0x0

    const/4 v1, 0x1

    .line 437
    if-nez p0, :cond_1

    .line 451
    :cond_0
    :goto_0
    return v1

    .line 441
    :cond_1
    const-string v3, "collapsable"

    invoke-virtual {p0, v3}, Lcom/facebook/react/uimanager/ReactStylesDiffMap;->hasKey(Ljava/lang/String;)Z

    move-result v3

    if-eqz v3, :cond_2

    const-string v3, "collapsable"

    invoke-virtual {p0, v3, v1}, Lcom/facebook/react/uimanager/ReactStylesDiffMap;->getBoolean(Ljava/lang/String;Z)Z

    move-result v3

    if-nez v3, :cond_2

    move v1, v2

    .line 442
    goto :goto_0

    .line 445
    :cond_2
    iget-object v3, p0, Lcom/facebook/react/uimanager/ReactStylesDiffMap;->mBackingMap:Lcom/facebook/react/bridge/ReadableMap;

    invoke-interface {v3}, Lcom/facebook/react/bridge/ReadableMap;->keySetIterator()Lcom/facebook/react/bridge/ReadableMapKeySetIterator;

    move-result-object v0

    .line 446
    .local v0, "keyIterator":Lcom/facebook/react/bridge/ReadableMapKeySetIterator;
    :cond_3
    invoke-interface {v0}, Lcom/facebook/react/bridge/ReadableMapKeySetIterator;->hasNextKey()Z

    move-result v3

    if-eqz v3, :cond_0

    .line 447
    iget-object v3, p0, Lcom/facebook/react/uimanager/ReactStylesDiffMap;->mBackingMap:Lcom/facebook/react/bridge/ReadableMap;

    invoke-interface {v0}, Lcom/facebook/react/bridge/ReadableMapKeySetIterator;->nextKey()Ljava/lang/String;

    move-result-object v4

    invoke-static {v3, v4}, Lcom/facebook/react/uimanager/ViewProps;->isLayoutOnly(Lcom/facebook/react/bridge/ReadableMap;Ljava/lang/String;)Z

    move-result v3

    if-nez v3, :cond_3

    move v1, v2

    .line 448
    goto :goto_0
.end method

.method private removeNodeFromParent(Lcom/facebook/react/uimanager/ReactShadowNode;Z)V
    .locals 10
    .param p1, "nodeToRemove"    # Lcom/facebook/react/uimanager/ReactShadowNode;
    .param p2, "shouldDelete"    # Z

    .prologue
    const/4 v4, 0x0

    const/4 v3, 0x1

    const/4 v9, 0x0

    .line 273
    invoke-interface {p1}, Lcom/facebook/react/uimanager/ReactShadowNode;->getNativeParent()Lcom/facebook/react/uimanager/ReactShadowNode;

    move-result-object v2

    .line 275
    .local v2, "nativeNodeToRemoveFrom":Lcom/facebook/react/uimanager/ReactShadowNode;
    if-eqz v2, :cond_2

    .line 276
    invoke-interface {v2, p1}, Lcom/facebook/react/uimanager/ReactShadowNode;->indexOfNativeChild(Lcom/facebook/react/uimanager/ReactShadowNode;)I

    move-result v1

    .line 277
    .local v1, "index":I
    invoke-interface {v2, v1}, Lcom/facebook/react/uimanager/ReactShadowNode;->removeNativeChildAt(I)Lcom/facebook/react/uimanager/ReactShadowNode;

    .line 279
    iget-object v5, p0, Lcom/facebook/react/uimanager/NativeViewHierarchyOptimizer;->mUIViewOperationQueue:Lcom/facebook/react/uimanager/UIViewOperationQueue;

    .line 280
    invoke-interface {v2}, Lcom/facebook/react/uimanager/ReactShadowNode;->getReactTag()I

    move-result v6

    new-array v7, v3, [I

    aput v1, v7, v9

    if-eqz p2, :cond_1

    new-array v3, v3, [I

    .line 283
    invoke-interface {p1}, Lcom/facebook/react/uimanager/ReactShadowNode;->getReactTag()I

    move-result v8

    aput v8, v3, v9

    .line 279
    :goto_0
    invoke-virtual {v5, v6, v7, v4, v3}, Lcom/facebook/react/uimanager/UIViewOperationQueue;->enqueueManageChildren(I[I[Lcom/facebook/react/uimanager/ViewAtIndex;[I)V

    .line 289
    .end local v1    # "index":I
    :cond_0
    return-void

    .restart local v1    # "index":I
    :cond_1
    move-object v3, v4

    .line 283
    goto :goto_0

    .line 285
    .end local v1    # "index":I
    :cond_2
    invoke-interface {p1}, Lcom/facebook/react/uimanager/ReactShadowNode;->getChildCount()I

    move-result v3

    add-int/lit8 v0, v3, -0x1

    .local v0, "i":I
    :goto_1
    if-ltz v0, :cond_0

    .line 286
    invoke-interface {p1, v0}, Lcom/facebook/react/uimanager/ReactShadowNode;->getChildAt(I)Lcom/facebook/react/uimanager/ReactShadowNode;

    move-result-object v3

    invoke-direct {p0, v3, p2}, Lcom/facebook/react/uimanager/NativeViewHierarchyOptimizer;->removeNodeFromParent(Lcom/facebook/react/uimanager/ReactShadowNode;Z)V

    .line 285
    add-int/lit8 v0, v0, -0x1

    goto :goto_1
.end method

.method private transitionLayoutOnlyViewToNativeView(Lcom/facebook/react/uimanager/ReactShadowNode;Lcom/facebook/react/uimanager/ReactStylesDiffMap;)V
    .locals 8
    .param p1, "node"    # Lcom/facebook/react/uimanager/ReactShadowNode;
    .param p2, "props"    # Lcom/facebook/react/uimanager/ReactStylesDiffMap;
        .annotation runtime Ljavax/annotation/Nullable;
        .end annotation
    .end param

    .prologue
    const/4 v3, 0x0

    .line 395
    invoke-interface {p1}, Lcom/facebook/react/uimanager/ReactShadowNode;->getParent()Lcom/facebook/react/uimanager/ReactShadowNode;

    move-result-object v2

    .line 396
    .local v2, "parent":Lcom/facebook/react/uimanager/ReactShadowNode;
    if-nez v2, :cond_0

    .line 397
    invoke-interface {p1, v3}, Lcom/facebook/react/uimanager/ReactShadowNode;->setIsLayoutOnly(Z)V

    .line 434
    :goto_0
    return-void

    .line 404
    :cond_0
    invoke-interface {v2, p1}, Lcom/facebook/react/uimanager/ReactShadowNode;->indexOf(Lcom/facebook/react/uimanager/ReactShadowNode;)I

    move-result v0

    .line 405
    .local v0, "childIndex":I
    invoke-interface {v2, v0}, Lcom/facebook/react/uimanager/ReactShadowNode;->removeChildAt(I)Lcom/facebook/react/uimanager/ReactShadowNode;

    .line 406
    invoke-direct {p0, p1, v3}, Lcom/facebook/react/uimanager/NativeViewHierarchyOptimizer;->removeNodeFromParent(Lcom/facebook/react/uimanager/ReactShadowNode;Z)V

    .line 408
    invoke-interface {p1, v3}, Lcom/facebook/react/uimanager/ReactShadowNode;->setIsLayoutOnly(Z)V

    .line 411
    iget-object v4, p0, Lcom/facebook/react/uimanager/NativeViewHierarchyOptimizer;->mUIViewOperationQueue:Lcom/facebook/react/uimanager/UIViewOperationQueue;

    .line 412
    invoke-interface {p1}, Lcom/facebook/react/uimanager/ReactShadowNode;->getRootNode()Lcom/facebook/react/uimanager/ReactShadowNode;

    move-result-object v5

    invoke-interface {v5}, Lcom/facebook/react/uimanager/ReactShadowNode;->getThemedContext()Lcom/facebook/react/uimanager/ThemedReactContext;

    move-result-object v5

    .line 413
    invoke-interface {p1}, Lcom/facebook/react/uimanager/ReactShadowNode;->getReactTag()I

    move-result v6

    .line 414
    invoke-interface {p1}, Lcom/facebook/react/uimanager/ReactShadowNode;->getViewClass()Ljava/lang/String;

    move-result-object v7

    .line 411
    invoke-virtual {v4, v5, v6, v7, p2}, Lcom/facebook/react/uimanager/UIViewOperationQueue;->enqueueCreateView(Lcom/facebook/react/uimanager/ThemedReactContext;ILjava/lang/String;Lcom/facebook/react/uimanager/ReactStylesDiffMap;)V

    .line 418
    invoke-interface {v2, p1, v0}, Lcom/facebook/react/uimanager/ReactShadowNode;->addChildAt(Lcom/facebook/react/uimanager/ReactShadowNode;I)V

    .line 419
    invoke-direct {p0, v2, p1, v0}, Lcom/facebook/react/uimanager/NativeViewHierarchyOptimizer;->addNodeToNode(Lcom/facebook/react/uimanager/ReactShadowNode;Lcom/facebook/react/uimanager/ReactShadowNode;I)V

    .line 420
    const/4 v1, 0x0

    .local v1, "i":I
    :goto_1
    invoke-interface {p1}, Lcom/facebook/react/uimanager/ReactShadowNode;->getChildCount()I

    move-result v4

    if-ge v1, v4, :cond_1

    .line 421
    invoke-interface {p1, v1}, Lcom/facebook/react/uimanager/ReactShadowNode;->getChildAt(I)Lcom/facebook/react/uimanager/ReactShadowNode;

    move-result-object v4

    invoke-direct {p0, p1, v4, v1}, Lcom/facebook/react/uimanager/NativeViewHierarchyOptimizer;->addNodeToNode(Lcom/facebook/react/uimanager/ReactShadowNode;Lcom/facebook/react/uimanager/ReactShadowNode;I)V

    .line 420
    add-int/lit8 v1, v1, 0x1

    goto :goto_1

    .line 428
    :cond_1
    iget-object v4, p0, Lcom/facebook/react/uimanager/NativeViewHierarchyOptimizer;->mTagsWithLayoutVisited:Landroid/util/SparseBooleanArray;

    invoke-virtual {v4}, Landroid/util/SparseBooleanArray;->size()I

    move-result v4

    if-nez v4, :cond_2

    const/4 v3, 0x1

    :cond_2
    invoke-static {v3}, Lcom/facebook/infer/annotation/Assertions;->assertCondition(Z)V

    .line 429
    invoke-direct {p0, p1}, Lcom/facebook/react/uimanager/NativeViewHierarchyOptimizer;->applyLayoutBase(Lcom/facebook/react/uimanager/ReactShadowNode;)V

    .line 430
    const/4 v1, 0x0

    :goto_2
    invoke-interface {p1}, Lcom/facebook/react/uimanager/ReactShadowNode;->getChildCount()I

    move-result v3

    if-ge v1, v3, :cond_3

    .line 431
    invoke-interface {p1, v1}, Lcom/facebook/react/uimanager/ReactShadowNode;->getChildAt(I)Lcom/facebook/react/uimanager/ReactShadowNode;

    move-result-object v3

    invoke-direct {p0, v3}, Lcom/facebook/react/uimanager/NativeViewHierarchyOptimizer;->applyLayoutBase(Lcom/facebook/react/uimanager/ReactShadowNode;)V

    .line 430
    add-int/lit8 v1, v1, 0x1

    goto :goto_2

    .line 433
    :cond_3
    iget-object v3, p0, Lcom/facebook/react/uimanager/NativeViewHierarchyOptimizer;->mTagsWithLayoutVisited:Landroid/util/SparseBooleanArray;

    invoke-virtual {v3}, Landroid/util/SparseBooleanArray;->clear()V

    goto :goto_0
.end method

.method private walkUpUntilNonLayoutOnly(Lcom/facebook/react/uimanager/ReactShadowNode;I)Lcom/facebook/react/uimanager/NativeViewHierarchyOptimizer$NodeIndexPair;
    .locals 2
    .param p1, "node"    # Lcom/facebook/react/uimanager/ReactShadowNode;
    .param p2, "indexInNativeChildren"    # I

    .prologue
    .line 235
    :goto_0
    invoke-interface {p1}, Lcom/facebook/react/uimanager/ReactShadowNode;->isLayoutOnly()Z

    move-result v1

    if-eqz v1, :cond_1

    .line 236
    invoke-interface {p1}, Lcom/facebook/react/uimanager/ReactShadowNode;->getParent()Lcom/facebook/react/uimanager/ReactShadowNode;

    move-result-object v0

    .line 237
    .local v0, "parent":Lcom/facebook/react/uimanager/ReactShadowNode;
    if-nez v0, :cond_0

    .line 238
    const/4 v1, 0x0

    .line 245
    .end local v0    # "parent":Lcom/facebook/react/uimanager/ReactShadowNode;
    :goto_1
    return-object v1

    .line 241
    .restart local v0    # "parent":Lcom/facebook/react/uimanager/ReactShadowNode;
    :cond_0
    invoke-interface {v0, p1}, Lcom/facebook/react/uimanager/ReactShadowNode;->getNativeOffsetForChild(Lcom/facebook/react/uimanager/ReactShadowNode;)I

    move-result v1

    add-int/2addr p2, v1

    .line 242
    move-object p1, v0

    .line 243
    goto :goto_0

    .line 245
    .end local v0    # "parent":Lcom/facebook/react/uimanager/ReactShadowNode;
    :cond_1
    new-instance v1, Lcom/facebook/react/uimanager/NativeViewHierarchyOptimizer$NodeIndexPair;

    invoke-direct {v1, p1, p2}, Lcom/facebook/react/uimanager/NativeViewHierarchyOptimizer$NodeIndexPair;-><init>(Lcom/facebook/react/uimanager/ReactShadowNode;I)V

    goto :goto_1
.end method


# virtual methods
.method public handleCreateView(Lcom/facebook/react/uimanager/ReactShadowNode;Lcom/facebook/react/uimanager/ThemedReactContext;Lcom/facebook/react/uimanager/ReactStylesDiffMap;)V
    .locals 4
    .param p1, "node"    # Lcom/facebook/react/uimanager/ReactShadowNode;
    .param p2, "themedContext"    # Lcom/facebook/react/uimanager/ThemedReactContext;
    .param p3, "initialProps"    # Lcom/facebook/react/uimanager/ReactStylesDiffMap;
        .annotation runtime Ljavax/annotation/Nullable;
        .end annotation
    .end param

    .prologue
    .line 93
    invoke-interface {p1}, Lcom/facebook/react/uimanager/ReactShadowNode;->getViewClass()Ljava/lang/String;

    move-result-object v1

    const-string v2, "RCTView"

    invoke-virtual {v1, v2}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v1

    if-eqz v1, :cond_1

    .line 94
    invoke-static {p3}, Lcom/facebook/react/uimanager/NativeViewHierarchyOptimizer;->isLayoutOnlyAndCollapsable(Lcom/facebook/react/uimanager/ReactStylesDiffMap;)Z

    move-result v1

    if-eqz v1, :cond_1

    const/4 v0, 0x1

    .line 95
    .local v0, "isLayoutOnly":Z
    :goto_0
    invoke-interface {p1, v0}, Lcom/facebook/react/uimanager/ReactShadowNode;->setIsLayoutOnly(Z)V

    .line 97
    if-nez v0, :cond_0

    .line 98
    iget-object v1, p0, Lcom/facebook/react/uimanager/NativeViewHierarchyOptimizer;->mUIViewOperationQueue:Lcom/facebook/react/uimanager/UIViewOperationQueue;

    .line 100
    invoke-interface {p1}, Lcom/facebook/react/uimanager/ReactShadowNode;->getReactTag()I

    move-result v2

    .line 101
    invoke-interface {p1}, Lcom/facebook/react/uimanager/ReactShadowNode;->getViewClass()Ljava/lang/String;

    move-result-object v3

    .line 98
    invoke-virtual {v1, p2, v2, v3, p3}, Lcom/facebook/react/uimanager/UIViewOperationQueue;->enqueueCreateView(Lcom/facebook/react/uimanager/ThemedReactContext;ILjava/lang/String;Lcom/facebook/react/uimanager/ReactStylesDiffMap;)V

    .line 104
    :cond_0
    return-void

    .line 94
    .end local v0    # "isLayoutOnly":Z
    :cond_1
    const/4 v0, 0x0

    goto :goto_0
.end method

.method public handleManageChildren(Lcom/facebook/react/uimanager/ReactShadowNode;[I[I[Lcom/facebook/react/uimanager/ViewAtIndex;[I)V
    .locals 9
    .param p1, "nodeToManage"    # Lcom/facebook/react/uimanager/ReactShadowNode;
    .param p2, "indicesToRemove"    # [I
    .param p3, "tagsToRemove"    # [I
    .param p4, "viewsToAdd"    # [Lcom/facebook/react/uimanager/ViewAtIndex;
    .param p5, "tagsToDelete"    # [I

    .prologue
    .line 163
    const/4 v1, 0x0

    .local v1, "i":I
    :goto_0
    array-length v7, p3

    if-ge v1, v7, :cond_2

    .line 164
    aget v5, p3, v1

    .line 165
    .local v5, "tagToRemove":I
    const/4 v0, 0x0

    .line 166
    .local v0, "delete":Z
    const/4 v2, 0x0

    .local v2, "j":I
    :goto_1
    array-length v7, p5

    if-ge v2, v7, :cond_0

    .line 167
    aget v7, p5, v2

    if-ne v7, v5, :cond_1

    .line 168
    const/4 v0, 0x1

    .line 172
    :cond_0
    iget-object v7, p0, Lcom/facebook/react/uimanager/NativeViewHierarchyOptimizer;->mShadowNodeRegistry:Lcom/facebook/react/uimanager/ShadowNodeRegistry;

    invoke-virtual {v7, v5}, Lcom/facebook/react/uimanager/ShadowNodeRegistry;->getNode(I)Lcom/facebook/react/uimanager/ReactShadowNode;

    move-result-object v4

    .line 173
    .local v4, "nodeToRemove":Lcom/facebook/react/uimanager/ReactShadowNode;
    invoke-direct {p0, v4, v0}, Lcom/facebook/react/uimanager/NativeViewHierarchyOptimizer;->removeNodeFromParent(Lcom/facebook/react/uimanager/ReactShadowNode;Z)V

    .line 163
    add-int/lit8 v1, v1, 0x1

    goto :goto_0

    .line 166
    .end local v4    # "nodeToRemove":Lcom/facebook/react/uimanager/ReactShadowNode;
    :cond_1
    add-int/lit8 v2, v2, 0x1

    goto :goto_1

    .line 176
    .end local v0    # "delete":Z
    .end local v2    # "j":I
    .end local v5    # "tagToRemove":I
    :cond_2
    const/4 v1, 0x0

    :goto_2
    array-length v7, p4

    if-ge v1, v7, :cond_3

    .line 177
    aget-object v6, p4, v1

    .line 178
    .local v6, "toAdd":Lcom/facebook/react/uimanager/ViewAtIndex;
    iget-object v7, p0, Lcom/facebook/react/uimanager/NativeViewHierarchyOptimizer;->mShadowNodeRegistry:Lcom/facebook/react/uimanager/ShadowNodeRegistry;

    iget v8, v6, Lcom/facebook/react/uimanager/ViewAtIndex;->mTag:I

    invoke-virtual {v7, v8}, Lcom/facebook/react/uimanager/ShadowNodeRegistry;->getNode(I)Lcom/facebook/react/uimanager/ReactShadowNode;

    move-result-object v3

    .line 179
    .local v3, "nodeToAdd":Lcom/facebook/react/uimanager/ReactShadowNode;
    iget v7, v6, Lcom/facebook/react/uimanager/ViewAtIndex;->mIndex:I

    invoke-direct {p0, p1, v3, v7}, Lcom/facebook/react/uimanager/NativeViewHierarchyOptimizer;->addNodeToNode(Lcom/facebook/react/uimanager/ReactShadowNode;Lcom/facebook/react/uimanager/ReactShadowNode;I)V

    .line 176
    add-int/lit8 v1, v1, 0x1

    goto :goto_2

    .line 181
    .end local v3    # "nodeToAdd":Lcom/facebook/react/uimanager/ReactShadowNode;
    .end local v6    # "toAdd":Lcom/facebook/react/uimanager/ViewAtIndex;
    :cond_3
    return-void
.end method

.method public handleSetChildren(Lcom/facebook/react/uimanager/ReactShadowNode;Lcom/facebook/react/bridge/ReadableArray;)V
    .locals 4
    .param p1, "nodeToManage"    # Lcom/facebook/react/uimanager/ReactShadowNode;
    .param p2, "childrenTags"    # Lcom/facebook/react/bridge/ReadableArray;

    .prologue
    .line 198
    const/4 v0, 0x0

    .local v0, "i":I
    :goto_0
    invoke-interface {p2}, Lcom/facebook/react/bridge/ReadableArray;->size()I

    move-result v2

    if-ge v0, v2, :cond_0

    .line 199
    iget-object v2, p0, Lcom/facebook/react/uimanager/NativeViewHierarchyOptimizer;->mShadowNodeRegistry:Lcom/facebook/react/uimanager/ShadowNodeRegistry;

    invoke-interface {p2, v0}, Lcom/facebook/react/bridge/ReadableArray;->getInt(I)I

    move-result v3

    invoke-virtual {v2, v3}, Lcom/facebook/react/uimanager/ShadowNodeRegistry;->getNode(I)Lcom/facebook/react/uimanager/ReactShadowNode;

    move-result-object v1

    .line 200
    .local v1, "nodeToAdd":Lcom/facebook/react/uimanager/ReactShadowNode;
    invoke-direct {p0, p1, v1, v0}, Lcom/facebook/react/uimanager/NativeViewHierarchyOptimizer;->addNodeToNode(Lcom/facebook/react/uimanager/ReactShadowNode;Lcom/facebook/react/uimanager/ReactShadowNode;I)V

    .line 198
    add-int/lit8 v0, v0, 0x1

    goto :goto_0

    .line 202
    .end local v1    # "nodeToAdd":Lcom/facebook/react/uimanager/ReactShadowNode;
    :cond_0
    return-void
.end method

.method public handleUpdateLayout(Lcom/facebook/react/uimanager/ReactShadowNode;)V
    .locals 0
    .param p1, "node"    # Lcom/facebook/react/uimanager/ReactShadowNode;

    .prologue
    .line 221
    invoke-direct {p0, p1}, Lcom/facebook/react/uimanager/NativeViewHierarchyOptimizer;->applyLayoutBase(Lcom/facebook/react/uimanager/ReactShadowNode;)V

    .line 222
    return-void
.end method

.method public handleUpdateView(Lcom/facebook/react/uimanager/ReactShadowNode;Ljava/lang/String;Lcom/facebook/react/uimanager/ReactStylesDiffMap;)V
    .locals 3
    .param p1, "node"    # Lcom/facebook/react/uimanager/ReactShadowNode;
    .param p2, "className"    # Ljava/lang/String;
    .param p3, "props"    # Lcom/facebook/react/uimanager/ReactStylesDiffMap;

    .prologue
    .line 127
    invoke-interface {p1}, Lcom/facebook/react/uimanager/ReactShadowNode;->isLayoutOnly()Z

    move-result v1

    if-eqz v1, :cond_1

    invoke-static {p3}, Lcom/facebook/react/uimanager/NativeViewHierarchyOptimizer;->isLayoutOnlyAndCollapsable(Lcom/facebook/react/uimanager/ReactStylesDiffMap;)Z

    move-result v1

    if-nez v1, :cond_1

    const/4 v0, 0x1

    .line 128
    .local v0, "needsToLeaveLayoutOnly":Z
    :goto_0
    if-eqz v0, :cond_2

    .line 129
    invoke-direct {p0, p1, p3}, Lcom/facebook/react/uimanager/NativeViewHierarchyOptimizer;->transitionLayoutOnlyViewToNativeView(Lcom/facebook/react/uimanager/ReactShadowNode;Lcom/facebook/react/uimanager/ReactStylesDiffMap;)V

    .line 133
    :cond_0
    :goto_1
    return-void

    .line 127
    .end local v0    # "needsToLeaveLayoutOnly":Z
    :cond_1
    const/4 v0, 0x0

    goto :goto_0

    .line 130
    .restart local v0    # "needsToLeaveLayoutOnly":Z
    :cond_2
    invoke-interface {p1}, Lcom/facebook/react/uimanager/ReactShadowNode;->isLayoutOnly()Z

    move-result v1

    if-nez v1, :cond_0

    .line 131
    iget-object v1, p0, Lcom/facebook/react/uimanager/NativeViewHierarchyOptimizer;->mUIViewOperationQueue:Lcom/facebook/react/uimanager/UIViewOperationQueue;

    invoke-interface {p1}, Lcom/facebook/react/uimanager/ReactShadowNode;->getReactTag()I

    move-result v2

    invoke-virtual {v1, v2, p2, p3}, Lcom/facebook/react/uimanager/UIViewOperationQueue;->enqueueUpdateProperties(ILjava/lang/String;Lcom/facebook/react/uimanager/ReactStylesDiffMap;)V

    goto :goto_1
.end method

.method public onBatchComplete()V
    .locals 1

    .prologue
    .line 229
    iget-object v0, p0, Lcom/facebook/react/uimanager/NativeViewHierarchyOptimizer;->mTagsWithLayoutVisited:Landroid/util/SparseBooleanArray;

    invoke-virtual {v0}, Landroid/util/SparseBooleanArray;->clear()V

    .line 230
    return-void
.end method

.class final Lcom/facebook/react/flat/StateBuilder;
.super Ljava/lang/Object;
.source "StateBuilder.java"


# static fields
.field static final EMPTY_FLOAT_ARRAY:[F

.field private static final EMPTY_INT_ARRAY:[I

.field static final EMPTY_SPARSE_INT:Landroid/util/SparseIntArray;

.field private static final SKIP_UP_TO_DATE_NODES:Z = true


# instance fields
.field private final mAttachDetachListeners:Lcom/facebook/react/flat/ElementsList;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Lcom/facebook/react/flat/ElementsList",
            "<",
            "Lcom/facebook/react/flat/AttachDetachListener;",
            ">;"
        }
    .end annotation
.end field

.field private mDetachAllChildrenFromViews:Lcom/facebook/react/flat/FlatUIViewOperationQueue$DetachAllChildrenFromViews;
    .annotation runtime Ljavax/annotation/Nullable;
    .end annotation
.end field

.field private final mDrawCommands:Lcom/facebook/react/flat/ElementsList;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Lcom/facebook/react/flat/ElementsList",
            "<",
            "Lcom/facebook/react/flat/DrawCommand;",
            ">;"
        }
    .end annotation
.end field

.field private final mNativeChildren:Lcom/facebook/react/flat/ElementsList;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Lcom/facebook/react/flat/ElementsList",
            "<",
            "Lcom/facebook/react/flat/FlatShadowNode;",
            ">;"
        }
    .end annotation
.end field

.field private final mNodeRegions:Lcom/facebook/react/flat/ElementsList;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Lcom/facebook/react/flat/ElementsList",
            "<",
            "Lcom/facebook/react/flat/NodeRegion;",
            ">;"
        }
    .end annotation
.end field

.field private final mOnLayoutEvents:Ljava/util/ArrayList;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/ArrayList",
            "<",
            "Lcom/facebook/react/uimanager/OnLayoutEvent;",
            ">;"
        }
    .end annotation
.end field

.field private final mOperationsQueue:Lcom/facebook/react/flat/FlatUIViewOperationQueue;

.field private final mParentsForViewsToDrop:Ljava/util/ArrayList;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/ArrayList",
            "<",
            "Ljava/lang/Integer;",
            ">;"
        }
    .end annotation
.end field

.field private final mUpdateViewBoundsOperations:Ljava/util/ArrayList;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/ArrayList",
            "<",
            "Lcom/facebook/react/uimanager/UIViewOperationQueue$UIOperation;",
            ">;"
        }
    .end annotation
.end field

.field private final mViewManagerCommands:Ljava/util/ArrayList;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/ArrayList",
            "<",
            "Lcom/facebook/react/uimanager/UIViewOperationQueue$UIOperation;",
            ">;"
        }
    .end annotation
.end field

.field private final mViewsToDetach:Ljava/util/ArrayList;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/ArrayList",
            "<",
            "Lcom/facebook/react/flat/FlatShadowNode;",
            ">;"
        }
    .end annotation
.end field

.field private final mViewsToDetachAllChildrenFrom:Ljava/util/ArrayList;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/ArrayList",
            "<",
            "Lcom/facebook/react/flat/FlatShadowNode;",
            ">;"
        }
    .end annotation
.end field

.field private final mViewsToDrop:Ljava/util/ArrayList;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/ArrayList",
            "<",
            "Ljava/lang/Integer;",
            ">;"
        }
    .end annotation
.end field


# direct methods
.method static constructor <clinit>()V
    .locals 2

    .prologue
    const/4 v1, 0x0

    .line 33
    new-array v0, v1, [F

    sput-object v0, Lcom/facebook/react/flat/StateBuilder;->EMPTY_FLOAT_ARRAY:[F

    .line 34
    new-instance v0, Landroid/util/SparseIntArray;

    invoke-direct {v0}, Landroid/util/SparseIntArray;-><init>()V

    sput-object v0, Lcom/facebook/react/flat/StateBuilder;->EMPTY_SPARSE_INT:Landroid/util/SparseIntArray;

    .line 39
    new-array v0, v1, [I

    sput-object v0, Lcom/facebook/react/flat/StateBuilder;->EMPTY_INT_ARRAY:[I

    return-void
.end method

.method constructor <init>(Lcom/facebook/react/flat/FlatUIViewOperationQueue;)V
    .locals 2
    .param p1, "operationsQueue"    # Lcom/facebook/react/flat/FlatUIViewOperationQueue;

    .prologue
    .line 64
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 43
    new-instance v0, Lcom/facebook/react/flat/ElementsList;

    sget-object v1, Lcom/facebook/react/flat/DrawCommand;->EMPTY_ARRAY:[Lcom/facebook/react/flat/DrawCommand;

    invoke-direct {v0, v1}, Lcom/facebook/react/flat/ElementsList;-><init>([Ljava/lang/Object;)V

    iput-object v0, p0, Lcom/facebook/react/flat/StateBuilder;->mDrawCommands:Lcom/facebook/react/flat/ElementsList;

    .line 45
    new-instance v0, Lcom/facebook/react/flat/ElementsList;

    sget-object v1, Lcom/facebook/react/flat/AttachDetachListener;->EMPTY_ARRAY:[Lcom/facebook/react/flat/AttachDetachListener;

    invoke-direct {v0, v1}, Lcom/facebook/react/flat/ElementsList;-><init>([Ljava/lang/Object;)V

    iput-object v0, p0, Lcom/facebook/react/flat/StateBuilder;->mAttachDetachListeners:Lcom/facebook/react/flat/ElementsList;

    .line 47
    new-instance v0, Lcom/facebook/react/flat/ElementsList;

    sget-object v1, Lcom/facebook/react/flat/NodeRegion;->EMPTY_ARRAY:[Lcom/facebook/react/flat/NodeRegion;

    invoke-direct {v0, v1}, Lcom/facebook/react/flat/ElementsList;-><init>([Ljava/lang/Object;)V

    iput-object v0, p0, Lcom/facebook/react/flat/StateBuilder;->mNodeRegions:Lcom/facebook/react/flat/ElementsList;

    .line 49
    new-instance v0, Lcom/facebook/react/flat/ElementsList;

    sget-object v1, Lcom/facebook/react/flat/FlatShadowNode;->EMPTY_ARRAY:[Lcom/facebook/react/flat/FlatShadowNode;

    invoke-direct {v0, v1}, Lcom/facebook/react/flat/ElementsList;-><init>([Ljava/lang/Object;)V

    iput-object v0, p0, Lcom/facebook/react/flat/StateBuilder;->mNativeChildren:Lcom/facebook/react/flat/ElementsList;

    .line 52
    new-instance v0, Ljava/util/ArrayList;

    invoke-direct {v0}, Ljava/util/ArrayList;-><init>()V

    iput-object v0, p0, Lcom/facebook/react/flat/StateBuilder;->mViewsToDetachAllChildrenFrom:Ljava/util/ArrayList;

    .line 53
    new-instance v0, Ljava/util/ArrayList;

    invoke-direct {v0}, Ljava/util/ArrayList;-><init>()V

    iput-object v0, p0, Lcom/facebook/react/flat/StateBuilder;->mViewsToDetach:Ljava/util/ArrayList;

    .line 54
    new-instance v0, Ljava/util/ArrayList;

    invoke-direct {v0}, Ljava/util/ArrayList;-><init>()V

    iput-object v0, p0, Lcom/facebook/react/flat/StateBuilder;->mViewsToDrop:Ljava/util/ArrayList;

    .line 55
    new-instance v0, Ljava/util/ArrayList;

    invoke-direct {v0}, Ljava/util/ArrayList;-><init>()V

    iput-object v0, p0, Lcom/facebook/react/flat/StateBuilder;->mParentsForViewsToDrop:Ljava/util/ArrayList;

    .line 56
    new-instance v0, Ljava/util/ArrayList;

    invoke-direct {v0}, Ljava/util/ArrayList;-><init>()V

    iput-object v0, p0, Lcom/facebook/react/flat/StateBuilder;->mOnLayoutEvents:Ljava/util/ArrayList;

    .line 57
    new-instance v0, Ljava/util/ArrayList;

    invoke-direct {v0}, Ljava/util/ArrayList;-><init>()V

    iput-object v0, p0, Lcom/facebook/react/flat/StateBuilder;->mUpdateViewBoundsOperations:Ljava/util/ArrayList;

    .line 59
    new-instance v0, Ljava/util/ArrayList;

    invoke-direct {v0}, Ljava/util/ArrayList;-><init>()V

    iput-object v0, p0, Lcom/facebook/react/flat/StateBuilder;->mViewManagerCommands:Ljava/util/ArrayList;

    .line 65
    iput-object p1, p0, Lcom/facebook/react/flat/StateBuilder;->mOperationsQueue:Lcom/facebook/react/flat/FlatUIViewOperationQueue;

    .line 66
    return-void
.end method

.method private addNativeChild(Lcom/facebook/react/flat/FlatShadowNode;)V
    .locals 1
    .param p1, "nativeChild"    # Lcom/facebook/react/flat/FlatShadowNode;

    .prologue
    .line 276
    iget-object v0, p0, Lcom/facebook/react/flat/StateBuilder;->mNativeChildren:Lcom/facebook/react/flat/ElementsList;

    invoke-virtual {v0, p1}, Lcom/facebook/react/flat/ElementsList;->add(Ljava/lang/Object;)V

    .line 277
    return-void
.end method

.method private addNodeRegion(Lcom/facebook/react/flat/FlatShadowNode;FFFFZ)V
    .locals 2
    .param p1, "node"    # Lcom/facebook/react/flat/FlatShadowNode;
    .param p2, "left"    # F
    .param p3, "top"    # F
    .param p4, "right"    # F
    .param p5, "bottom"    # F
    .param p6, "isVirtual"    # Z

    .prologue
    .line 258
    cmpl-float v0, p2, p4

    if-eqz v0, :cond_0

    cmpl-float v0, p3, p5

    if-nez v0, :cond_1

    .line 267
    :cond_0
    :goto_0
    return-void

    .line 263
    :cond_1
    invoke-virtual/range {p1 .. p6}, Lcom/facebook/react/flat/FlatShadowNode;->updateNodeRegion(FFFFZ)V

    .line 264
    invoke-virtual {p1}, Lcom/facebook/react/flat/FlatShadowNode;->doesDraw()Z

    move-result v0

    if-eqz v0, :cond_0

    .line 265
    iget-object v0, p0, Lcom/facebook/react/flat/StateBuilder;->mNodeRegions:Lcom/facebook/react/flat/ElementsList;

    invoke-virtual {p1}, Lcom/facebook/react/flat/FlatShadowNode;->getNodeRegion()Lcom/facebook/react/flat/NodeRegion;

    move-result-object v1

    invoke-virtual {v0, v1}, Lcom/facebook/react/flat/ElementsList;->add(Ljava/lang/Object;)V

    goto :goto_0
.end method

.method private collectStateForMountableNode(Lcom/facebook/react/flat/FlatShadowNode;FFFFFFFF)Z
    .locals 35
    .param p1, "node"    # Lcom/facebook/react/flat/FlatShadowNode;
    .param p2, "left"    # F
    .param p3, "top"    # F
    .param p4, "right"    # F
    .param p5, "bottom"    # F
    .param p6, "clipLeft"    # F
    .param p7, "clipTop"    # F
    .param p8, "clipRight"    # F
    .param p9, "clipBottom"    # F

    .prologue
    .line 321
    invoke-virtual/range {p1 .. p1}, Lcom/facebook/react/flat/FlatShadowNode;->hasNewLayout()Z

    move-result v31

    .line 323
    .local v31, "hasUpdates":Z
    if-nez v31, :cond_0

    invoke-virtual/range {p1 .. p1}, Lcom/facebook/react/flat/FlatShadowNode;->isUpdated()Z

    move-result v5

    if-nez v5, :cond_0

    invoke-virtual/range {p1 .. p1}, Lcom/facebook/react/flat/FlatShadowNode;->hasUnseenUpdates()Z

    move-result v5

    if-nez v5, :cond_0

    .line 324
    move-object/from16 v0, p1

    move/from16 v1, p6

    move/from16 v2, p7

    move/from16 v3, p8

    move/from16 v4, p9

    invoke-virtual {v0, v1, v2, v3, v4}, Lcom/facebook/react/flat/FlatShadowNode;->clipBoundsChanged(FFFF)Z

    move-result v5

    if-eqz v5, :cond_2

    :cond_0
    const/16 v30, 0x1

    .line 325
    .local v30, "expectingUpdate":Z
    :goto_0
    if-nez v30, :cond_3

    .line 326
    const/16 v34, 0x0

    .line 474
    :cond_1
    return v34

    .line 324
    .end local v30    # "expectingUpdate":Z
    :cond_2
    const/16 v30, 0x0

    goto :goto_0

    .line 329
    .restart local v30    # "expectingUpdate":Z
    :cond_3
    move-object/from16 v0, p1

    move/from16 v1, p6

    move/from16 v2, p7

    move/from16 v3, p8

    move/from16 v4, p9

    invoke-virtual {v0, v1, v2, v3, v4}, Lcom/facebook/react/flat/FlatShadowNode;->setClipBounds(FFFF)V

    .line 331
    move-object/from16 v0, p0

    iget-object v5, v0, Lcom/facebook/react/flat/StateBuilder;->mDrawCommands:Lcom/facebook/react/flat/ElementsList;

    invoke-virtual/range {p1 .. p1}, Lcom/facebook/react/flat/FlatShadowNode;->getDrawCommands()[Lcom/facebook/react/flat/DrawCommand;

    move-result-object v6

    invoke-virtual {v5, v6}, Lcom/facebook/react/flat/ElementsList;->start([Ljava/lang/Object;)V

    .line 332
    move-object/from16 v0, p0

    iget-object v5, v0, Lcom/facebook/react/flat/StateBuilder;->mAttachDetachListeners:Lcom/facebook/react/flat/ElementsList;

    invoke-virtual/range {p1 .. p1}, Lcom/facebook/react/flat/FlatShadowNode;->getAttachDetachListeners()[Lcom/facebook/react/flat/AttachDetachListener;

    move-result-object v6

    invoke-virtual {v5, v6}, Lcom/facebook/react/flat/ElementsList;->start([Ljava/lang/Object;)V

    .line 333
    move-object/from16 v0, p0

    iget-object v5, v0, Lcom/facebook/react/flat/StateBuilder;->mNodeRegions:Lcom/facebook/react/flat/ElementsList;

    invoke-virtual/range {p1 .. p1}, Lcom/facebook/react/flat/FlatShadowNode;->getNodeRegions()[Lcom/facebook/react/flat/NodeRegion;

    move-result-object v6

    invoke-virtual {v5, v6}, Lcom/facebook/react/flat/ElementsList;->start([Ljava/lang/Object;)V

    .line 334
    move-object/from16 v0, p0

    iget-object v5, v0, Lcom/facebook/react/flat/StateBuilder;->mNativeChildren:Lcom/facebook/react/flat/ElementsList;

    invoke-virtual/range {p1 .. p1}, Lcom/facebook/react/flat/FlatShadowNode;->getNativeChildren()[Lcom/facebook/react/flat/FlatShadowNode;

    move-result-object v6

    invoke-virtual {v5, v6}, Lcom/facebook/react/flat/ElementsList;->start([Ljava/lang/Object;)V

    .line 336
    const/4 v15, 0x0

    .line 337
    .local v15, "isAndroidView":Z
    const/16 v16, 0x0

    .line 338
    .local v16, "needsCustomLayoutForChildren":Z
    move-object/from16 v0, p1

    instance-of v5, v0, Lcom/facebook/react/flat/AndroidView;

    if-eqz v5, :cond_4

    move-object/from16 v28, p1

    .line 339
    check-cast v28, Lcom/facebook/react/flat/AndroidView;

    .line 340
    .local v28, "androidView":Lcom/facebook/react/flat/AndroidView;
    invoke-virtual/range {p1 .. p1}, Lcom/facebook/react/flat/FlatShadowNode;->getReactTag()I

    move-result v5

    move-object/from16 v0, p0

    move-object/from16 v1, v28

    invoke-direct {v0, v1, v5}, Lcom/facebook/react/flat/StateBuilder;->updateViewPadding(Lcom/facebook/react/flat/AndroidView;I)V

    .line 342
    const/4 v15, 0x1

    .line 343
    invoke-interface/range {v28 .. v28}, Lcom/facebook/react/flat/AndroidView;->needsCustomLayoutForChildren()Z

    move-result v16

    .line 348
    const/high16 p6, -0x800000    # Float.NEGATIVE_INFINITY

    .line 349
    const/high16 p7, -0x800000    # Float.NEGATIVE_INFINITY

    .line 350
    const/high16 p8, 0x7f800000    # Float.POSITIVE_INFINITY

    .line 351
    const/high16 p9, 0x7f800000    # Float.POSITIVE_INFINITY

    .line 354
    .end local v28    # "androidView":Lcom/facebook/react/flat/AndroidView;
    :cond_4
    if-nez v15, :cond_5

    invoke-virtual/range {p1 .. p1}, Lcom/facebook/react/flat/FlatShadowNode;->isVirtualAnchor()Z

    move-result v5

    if-eqz v5, :cond_5

    .line 360
    const/4 v11, 0x1

    move-object/from16 v5, p0

    move-object/from16 v6, p1

    move/from16 v7, p2

    move/from16 v8, p3

    move/from16 v9, p4

    move/from16 v10, p5

    invoke-direct/range {v5 .. v11}, Lcom/facebook/react/flat/StateBuilder;->addNodeRegion(Lcom/facebook/react/flat/FlatShadowNode;FFFFZ)V

    :cond_5
    move-object/from16 v5, p0

    move-object/from16 v6, p1

    move/from16 v7, p2

    move/from16 v8, p3

    move/from16 v9, p4

    move/from16 v10, p5

    move/from16 v11, p6

    move/from16 v12, p7

    move/from16 v13, p8

    move/from16 v14, p9

    .line 363
    invoke-direct/range {v5 .. v16}, Lcom/facebook/react/flat/StateBuilder;->collectStateRecursively(Lcom/facebook/react/flat/FlatShadowNode;FFFFFFFFZZ)Z

    move-result v29

    .line 376
    .local v29, "descendantUpdated":Z
    const/16 v33, 0x0

    .line 377
    .local v33, "shouldUpdateMountState":Z
    move-object/from16 v0, p0

    iget-object v5, v0, Lcom/facebook/react/flat/StateBuilder;->mDrawCommands:Lcom/facebook/react/flat/ElementsList;

    invoke-virtual {v5}, Lcom/facebook/react/flat/ElementsList;->finish()[Ljava/lang/Object;

    move-result-object v19

    check-cast v19, [Lcom/facebook/react/flat/DrawCommand;

    .line 378
    .local v19, "drawCommands":[Lcom/facebook/react/flat/DrawCommand;
    if-eqz v19, :cond_6

    .line 379
    const/16 v33, 0x1

    .line 380
    move-object/from16 v0, p1

    move-object/from16 v1, v19

    invoke-virtual {v0, v1}, Lcom/facebook/react/flat/FlatShadowNode;->setDrawCommands([Lcom/facebook/react/flat/DrawCommand;)V

    .line 383
    :cond_6
    move-object/from16 v0, p0

    iget-object v5, v0, Lcom/facebook/react/flat/StateBuilder;->mAttachDetachListeners:Lcom/facebook/react/flat/ElementsList;

    invoke-virtual {v5}, Lcom/facebook/react/flat/ElementsList;->finish()[Ljava/lang/Object;

    move-result-object v23

    check-cast v23, [Lcom/facebook/react/flat/AttachDetachListener;

    .line 384
    .local v23, "listeners":[Lcom/facebook/react/flat/AttachDetachListener;
    if-eqz v23, :cond_7

    .line 385
    const/16 v33, 0x1

    .line 386
    move-object/from16 v0, p1

    move-object/from16 v1, v23

    invoke-virtual {v0, v1}, Lcom/facebook/react/flat/FlatShadowNode;->setAttachDetachListeners([Lcom/facebook/react/flat/AttachDetachListener;)V

    .line 389
    :cond_7
    move-object/from16 v0, p0

    iget-object v5, v0, Lcom/facebook/react/flat/StateBuilder;->mNodeRegions:Lcom/facebook/react/flat/ElementsList;

    invoke-virtual {v5}, Lcom/facebook/react/flat/ElementsList;->finish()[Ljava/lang/Object;

    move-result-object v24

    check-cast v24, [Lcom/facebook/react/flat/NodeRegion;

    .line 390
    .local v24, "nodeRegions":[Lcom/facebook/react/flat/NodeRegion;
    if-eqz v24, :cond_f

    .line 391
    const/16 v33, 0x1

    .line 392
    move-object/from16 v0, p1

    move-object/from16 v1, v24

    invoke-virtual {v0, v1}, Lcom/facebook/react/flat/FlatShadowNode;->setNodeRegions([Lcom/facebook/react/flat/NodeRegion;)V

    .line 400
    :cond_8
    :goto_1
    move-object/from16 v0, p0

    iget-object v5, v0, Lcom/facebook/react/flat/StateBuilder;->mNativeChildren:Lcom/facebook/react/flat/ElementsList;

    invoke-virtual {v5}, Lcom/facebook/react/flat/ElementsList;->finish()[Ljava/lang/Object;

    move-result-object v32

    check-cast v32, [Lcom/facebook/react/flat/FlatShadowNode;

    .line 401
    .local v32, "nativeChildren":[Lcom/facebook/react/flat/FlatShadowNode;
    if-eqz v33, :cond_b

    .line 402
    invoke-virtual/range {p1 .. p1}, Lcom/facebook/react/flat/FlatShadowNode;->clipsSubviews()Z

    move-result v5

    if-eqz v5, :cond_13

    .line 406
    sget-object v21, Lcom/facebook/react/flat/StateBuilder;->EMPTY_FLOAT_ARRAY:[F

    .line 407
    .local v21, "commandMaxBottom":[F
    sget-object v22, Lcom/facebook/react/flat/StateBuilder;->EMPTY_FLOAT_ARRAY:[F

    .line 408
    .local v22, "commandMinTop":[F
    sget-object v20, Lcom/facebook/react/flat/StateBuilder;->EMPTY_SPARSE_INT:Landroid/util/SparseIntArray;

    .line 409
    .local v20, "drawViewIndexMap":Landroid/util/SparseIntArray;
    if-eqz v19, :cond_9

    .line 410
    new-instance v20, Landroid/util/SparseIntArray;

    .end local v20    # "drawViewIndexMap":Landroid/util/SparseIntArray;
    invoke-direct/range {v20 .. v20}, Landroid/util/SparseIntArray;-><init>()V

    .line 412
    .restart local v20    # "drawViewIndexMap":Landroid/util/SparseIntArray;
    move-object/from16 v0, v19

    array-length v5, v0

    new-array v0, v5, [F

    move-object/from16 v21, v0

    .line 413
    move-object/from16 v0, v19

    array-length v5, v0

    new-array v0, v5, [F

    move-object/from16 v22, v0

    .line 415
    invoke-virtual/range {p1 .. p1}, Lcom/facebook/react/flat/FlatShadowNode;->isHorizontal()Z

    move-result v5

    if-eqz v5, :cond_10

    .line 417
    move-object/from16 v0, v19

    move-object/from16 v1, v21

    move-object/from16 v2, v22

    move-object/from16 v3, v20

    invoke-static {v0, v1, v2, v3}, Lcom/facebook/react/flat/HorizontalDrawCommandManager;->fillMaxMinArrays([Lcom/facebook/react/flat/DrawCommand;[F[FLandroid/util/SparseIntArray;)V

    .line 423
    :cond_9
    :goto_2
    sget-object v25, Lcom/facebook/react/flat/StateBuilder;->EMPTY_FLOAT_ARRAY:[F

    .line 424
    .local v25, "regionMaxBottom":[F
    sget-object v26, Lcom/facebook/react/flat/StateBuilder;->EMPTY_FLOAT_ARRAY:[F

    .line 425
    .local v26, "regionMinTop":[F
    if-eqz v24, :cond_a

    .line 426
    move-object/from16 v0, v24

    array-length v5, v0

    new-array v0, v5, [F

    move-object/from16 v25, v0

    .line 427
    move-object/from16 v0, v24

    array-length v5, v0

    new-array v0, v5, [F

    move-object/from16 v26, v0

    .line 429
    invoke-virtual/range {p1 .. p1}, Lcom/facebook/react/flat/FlatShadowNode;->isHorizontal()Z

    move-result v5

    if-eqz v5, :cond_11

    .line 431
    invoke-static/range {v24 .. v26}, Lcom/facebook/react/flat/HorizontalDrawCommandManager;->fillMaxMinArrays([Lcom/facebook/react/flat/NodeRegion;[F[F)V

    .line 438
    :cond_a
    :goto_3
    if-eqz v32, :cond_12

    const/16 v27, 0x1

    .line 439
    .local v27, "willMountViews":Z
    :goto_4
    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/facebook/react/flat/StateBuilder;->mOperationsQueue:Lcom/facebook/react/flat/FlatUIViewOperationQueue;

    move-object/from16 v17, v0

    .line 440
    invoke-virtual/range {p1 .. p1}, Lcom/facebook/react/flat/FlatShadowNode;->getReactTag()I

    move-result v18

    .line 439
    invoke-virtual/range {v17 .. v27}, Lcom/facebook/react/flat/FlatUIViewOperationQueue;->enqueueUpdateClippingMountState(I[Lcom/facebook/react/flat/DrawCommand;Landroid/util/SparseIntArray;[F[F[Lcom/facebook/react/flat/AttachDetachListener;[Lcom/facebook/react/flat/NodeRegion;[F[FZ)V

    .line 459
    .end local v20    # "drawViewIndexMap":Landroid/util/SparseIntArray;
    .end local v21    # "commandMaxBottom":[F
    .end local v22    # "commandMinTop":[F
    .end local v25    # "regionMaxBottom":[F
    .end local v26    # "regionMinTop":[F
    .end local v27    # "willMountViews":Z
    :cond_b
    :goto_5
    invoke-virtual/range {p1 .. p1}, Lcom/facebook/react/flat/FlatShadowNode;->hasUnseenUpdates()Z

    move-result v5

    if-eqz v5, :cond_c

    .line 460
    move-object/from16 v0, p0

    iget-object v5, v0, Lcom/facebook/react/flat/StateBuilder;->mOperationsQueue:Lcom/facebook/react/flat/FlatUIViewOperationQueue;

    move-object/from16 v0, p1

    invoke-virtual {v0, v5}, Lcom/facebook/react/flat/FlatShadowNode;->onCollectExtraUpdates(Lcom/facebook/react/uimanager/UIViewOperationQueue;)V

    .line 461
    invoke-virtual/range {p1 .. p1}, Lcom/facebook/react/flat/FlatShadowNode;->markUpdateSeen()V

    .line 464
    :cond_c
    if-eqz v32, :cond_d

    .line 465
    invoke-virtual/range {p1 .. p1}, Lcom/facebook/react/flat/FlatShadowNode;->getNativeChildren()[Lcom/facebook/react/flat/FlatShadowNode;

    move-result-object v5

    move-object/from16 v0, p0

    move-object/from16 v1, p1

    move-object/from16 v2, v32

    invoke-direct {v0, v1, v5, v2}, Lcom/facebook/react/flat/StateBuilder;->updateNativeChildren(Lcom/facebook/react/flat/FlatShadowNode;[Lcom/facebook/react/flat/FlatShadowNode;[Lcom/facebook/react/flat/FlatShadowNode;)V

    .line 468
    :cond_d
    if-nez v33, :cond_e

    if-nez v32, :cond_e

    if-eqz v29, :cond_14

    :cond_e
    const/16 v34, 0x1

    .line 470
    .local v34, "updated":Z
    :goto_6
    if-nez v30, :cond_1

    if-eqz v34, :cond_1

    .line 471
    new-instance v5, Ljava/lang/RuntimeException;

    new-instance v6, Ljava/lang/StringBuilder;

    invoke-direct {v6}, Ljava/lang/StringBuilder;-><init>()V

    const-string v7, "Node "

    invoke-virtual {v6, v7}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v6

    invoke-virtual/range {p1 .. p1}, Lcom/facebook/react/flat/FlatShadowNode;->getReactTag()I

    move-result v7

    invoke-virtual {v6, v7}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v6

    const-string v7, " updated unexpectedly."

    invoke-virtual {v6, v7}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v6

    invoke-virtual {v6}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v6

    invoke-direct {v5, v6}, Ljava/lang/RuntimeException;-><init>(Ljava/lang/String;)V

    throw v5

    .line 393
    .end local v32    # "nativeChildren":[Lcom/facebook/react/flat/FlatShadowNode;
    .end local v34    # "updated":Z
    :cond_f
    if-eqz v29, :cond_8

    .line 396
    invoke-virtual/range {p1 .. p1}, Lcom/facebook/react/flat/FlatShadowNode;->updateOverflowsContainer()V

    goto/16 :goto_1

    .line 420
    .restart local v20    # "drawViewIndexMap":Landroid/util/SparseIntArray;
    .restart local v21    # "commandMaxBottom":[F
    .restart local v22    # "commandMinTop":[F
    .restart local v32    # "nativeChildren":[Lcom/facebook/react/flat/FlatShadowNode;
    :cond_10
    move-object/from16 v0, v19

    move-object/from16 v1, v21

    move-object/from16 v2, v22

    move-object/from16 v3, v20

    invoke-static {v0, v1, v2, v3}, Lcom/facebook/react/flat/VerticalDrawCommandManager;->fillMaxMinArrays([Lcom/facebook/react/flat/DrawCommand;[F[FLandroid/util/SparseIntArray;)V

    goto/16 :goto_2

    .line 434
    .restart local v25    # "regionMaxBottom":[F
    .restart local v26    # "regionMinTop":[F
    :cond_11
    invoke-static/range {v24 .. v26}, Lcom/facebook/react/flat/VerticalDrawCommandManager;->fillMaxMinArrays([Lcom/facebook/react/flat/NodeRegion;[F[F)V

    goto :goto_3

    .line 438
    :cond_12
    const/16 v27, 0x0

    goto :goto_4

    .line 451
    .end local v20    # "drawViewIndexMap":Landroid/util/SparseIntArray;
    .end local v21    # "commandMaxBottom":[F
    .end local v22    # "commandMinTop":[F
    .end local v25    # "regionMaxBottom":[F
    .end local v26    # "regionMinTop":[F
    :cond_13
    move-object/from16 v0, p0

    iget-object v5, v0, Lcom/facebook/react/flat/StateBuilder;->mOperationsQueue:Lcom/facebook/react/flat/FlatUIViewOperationQueue;

    .line 452
    invoke-virtual/range {p1 .. p1}, Lcom/facebook/react/flat/FlatShadowNode;->getReactTag()I

    move-result v6

    .line 451
    move-object/from16 v0, v19

    move-object/from16 v1, v23

    move-object/from16 v2, v24

    invoke-virtual {v5, v6, v0, v1, v2}, Lcom/facebook/react/flat/FlatUIViewOperationQueue;->enqueueUpdateMountState(I[Lcom/facebook/react/flat/DrawCommand;[Lcom/facebook/react/flat/AttachDetachListener;[Lcom/facebook/react/flat/NodeRegion;)V

    goto :goto_5

    .line 468
    :cond_14
    const/16 v34, 0x0

    goto :goto_6
.end method

.method private collectStateRecursively(Lcom/facebook/react/flat/FlatShadowNode;FFFFFFFFZZ)Z
    .locals 23
    .param p1, "node"    # Lcom/facebook/react/flat/FlatShadowNode;
    .param p2, "left"    # F
    .param p3, "top"    # F
    .param p4, "right"    # F
    .param p5, "bottom"    # F
    .param p6, "clipLeft"    # F
    .param p7, "clipTop"    # F
    .param p8, "clipRight"    # F
    .param p9, "clipBottom"    # F
    .param p10, "isAndroidView"    # Z
    .param p11, "needsCustomLayoutForChildren"    # Z

    .prologue
    .line 558
    invoke-virtual/range {p1 .. p1}, Lcom/facebook/react/flat/FlatShadowNode;->hasNewLayout()Z

    move-result v2

    if-eqz v2, :cond_0

    .line 559
    invoke-virtual/range {p1 .. p1}, Lcom/facebook/react/flat/FlatShadowNode;->markLayoutSeen()V

    .line 562
    :cond_0
    invoke-static/range {p2 .. p2}, Lcom/facebook/react/flat/StateBuilder;->roundToPixel(F)F

    move-result v4

    .line 563
    .local v4, "roundedLeft":F
    invoke-static/range {p3 .. p3}, Lcom/facebook/react/flat/StateBuilder;->roundToPixel(F)F

    move-result v5

    .line 564
    .local v5, "roundedTop":F
    invoke-static/range {p4 .. p4}, Lcom/facebook/react/flat/StateBuilder;->roundToPixel(F)F

    move-result v6

    .line 565
    .local v6, "roundedRight":F
    invoke-static/range {p5 .. p5}, Lcom/facebook/react/flat/StateBuilder;->roundToPixel(F)F

    move-result v7

    .line 568
    .local v7, "roundedBottom":F
    invoke-virtual/range {p1 .. p1}, Lcom/facebook/react/flat/FlatShadowNode;->shouldNotifyOnLayout()Z

    move-result v2

    if-eqz v2, :cond_1

    .line 570
    invoke-virtual/range {p1 .. p1}, Lcom/facebook/react/flat/FlatShadowNode;->getLayoutX()F

    move-result v2

    invoke-static {v2}, Ljava/lang/Math;->round(F)I

    move-result v2

    .line 571
    invoke-virtual/range {p1 .. p1}, Lcom/facebook/react/flat/FlatShadowNode;->getLayoutY()F

    move-result v3

    invoke-static {v3}, Ljava/lang/Math;->round(F)I

    move-result v3

    sub-float v8, v6, v4

    float-to-int v8, v8

    sub-float v9, v7, v5

    float-to-int v9, v9

    .line 569
    move-object/from16 v0, p1

    invoke-virtual {v0, v2, v3, v8, v9}, Lcom/facebook/react/flat/FlatShadowNode;->obtainLayoutEvent(IIII)Lcom/facebook/react/uimanager/OnLayoutEvent;

    move-result-object v21

    .line 574
    .local v21, "layoutEvent":Lcom/facebook/react/uimanager/OnLayoutEvent;
    if-eqz v21, :cond_1

    .line 575
    move-object/from16 v0, p0

    iget-object v2, v0, Lcom/facebook/react/flat/StateBuilder;->mOnLayoutEvents:Ljava/util/ArrayList;

    move-object/from16 v0, v21

    invoke-virtual {v2, v0}, Ljava/util/ArrayList;->add(Ljava/lang/Object;)Z

    .line 579
    .end local v21    # "layoutEvent":Lcom/facebook/react/uimanager/OnLayoutEvent;
    :cond_1
    invoke-virtual/range {p1 .. p1}, Lcom/facebook/react/flat/FlatShadowNode;->clipToBounds()Z

    move-result v2

    if-eqz v2, :cond_2

    .line 580
    move/from16 v0, p2

    move/from16 v1, p6

    invoke-static {v0, v1}, Ljava/lang/Math;->max(FF)F

    move-result p6

    .line 581
    move/from16 v0, p3

    move/from16 v1, p7

    invoke-static {v0, v1}, Ljava/lang/Math;->max(FF)F

    move-result p7

    .line 582
    move/from16 v0, p4

    move/from16 v1, p8

    invoke-static {v0, v1}, Ljava/lang/Math;->min(FF)F

    move-result p8

    .line 583
    move/from16 v0, p5

    move/from16 v1, p9

    invoke-static {v0, v1}, Ljava/lang/Math;->min(FF)F

    move-result p9

    .line 592
    :cond_2
    invoke-static/range {p6 .. p6}, Lcom/facebook/react/flat/StateBuilder;->roundToPixel(F)F

    move-result v8

    .line 593
    invoke-static/range {p7 .. p7}, Lcom/facebook/react/flat/StateBuilder;->roundToPixel(F)F

    move-result v9

    .line 594
    invoke-static/range {p8 .. p8}, Lcom/facebook/react/flat/StateBuilder;->roundToPixel(F)F

    move-result v10

    move-object/from16 v2, p1

    move-object/from16 v3, p0

    move/from16 v11, p9

    .line 586
    invoke-virtual/range {v2 .. v11}, Lcom/facebook/react/flat/FlatShadowNode;->collectState(Lcom/facebook/react/flat/StateBuilder;FFFFFFFF)V

    .line 597
    const/16 v22, 0x0

    .line 598
    .local v22, "updated":Z
    const/16 v20, 0x0

    .local v20, "i":I
    invoke-virtual/range {p1 .. p1}, Lcom/facebook/react/flat/FlatShadowNode;->getChildCount()I

    move-result v19

    .local v19, "childCount":I
    :goto_0
    move/from16 v0, v20

    move/from16 v1, v19

    if-eq v0, v1, :cond_4

    .line 599
    move-object/from16 v0, p1

    move/from16 v1, v20

    invoke-virtual {v0, v1}, Lcom/facebook/react/flat/FlatShadowNode;->getChildAt(I)Lcom/facebook/react/uimanager/ReactShadowNodeImpl;

    move-result-object v18

    .line 600
    .local v18, "child":Lcom/facebook/react/uimanager/ReactShadowNode;
    invoke-interface/range {v18 .. v18}, Lcom/facebook/react/uimanager/ReactShadowNode;->isVirtual()Z

    move-result v2

    if-eqz v2, :cond_3

    .line 598
    :goto_1
    add-int/lit8 v20, v20, 0x1

    goto :goto_0

    :cond_3
    move-object/from16 v9, v18

    .line 604
    check-cast v9, Lcom/facebook/react/flat/FlatShadowNode;

    move-object/from16 v8, p0

    move/from16 v10, p2

    move/from16 v11, p3

    move/from16 v12, p6

    move/from16 v13, p7

    move/from16 v14, p8

    move/from16 v15, p9

    move/from16 v16, p10

    move/from16 v17, p11

    invoke-direct/range {v8 .. v17}, Lcom/facebook/react/flat/StateBuilder;->processNodeAndCollectState(Lcom/facebook/react/flat/FlatShadowNode;FFFFFFZZ)Z

    move-result v2

    or-int v22, v22, v2

    goto :goto_1

    .line 616
    .end local v18    # "child":Lcom/facebook/react/uimanager/ReactShadowNode;
    :cond_4
    invoke-virtual/range {p1 .. p1}, Lcom/facebook/react/flat/FlatShadowNode;->resetUpdated()V

    .line 618
    return v22
.end method

.method private static collectViewTags(Ljava/util/ArrayList;)[I
    .locals 4
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/util/ArrayList",
            "<",
            "Lcom/facebook/react/flat/FlatShadowNode;",
            ">;)[I"
        }
    .end annotation

    .prologue
    .line 712
    .local p0, "views":Ljava/util/ArrayList;, "Ljava/util/ArrayList<Lcom/facebook/react/flat/FlatShadowNode;>;"
    invoke-virtual {p0}, Ljava/util/ArrayList;->size()I

    move-result v1

    .line 713
    .local v1, "numViews":I
    if-nez v1, :cond_1

    .line 714
    sget-object v2, Lcom/facebook/react/flat/StateBuilder;->EMPTY_INT_ARRAY:[I

    .line 722
    :cond_0
    return-object v2

    .line 717
    :cond_1
    new-array v2, v1, [I

    .line 718
    .local v2, "viewTags":[I
    const/4 v0, 0x0

    .local v0, "i":I
    :goto_0
    if-ge v0, v1, :cond_0

    .line 719
    invoke-virtual {p0, v0}, Ljava/util/ArrayList;->get(I)Ljava/lang/Object;

    move-result-object v3

    check-cast v3, Lcom/facebook/react/flat/FlatShadowNode;

    invoke-virtual {v3}, Lcom/facebook/react/flat/FlatShadowNode;->getReactTag()I

    move-result v3

    aput v3, v2, v0

    .line 718
    add-int/lit8 v0, v0, 0x1

    goto :goto_0
.end method

.method private processNodeAndCollectState(Lcom/facebook/react/flat/FlatShadowNode;FFFFFFZZ)Z
    .locals 21
    .param p1, "node"    # Lcom/facebook/react/flat/FlatShadowNode;
    .param p2, "parentLeft"    # F
    .param p3, "parentTop"    # F
    .param p4, "parentClipLeft"    # F
    .param p5, "parentClipTop"    # F
    .param p6, "parentClipRight"    # F
    .param p7, "parentClipBottom"    # F
    .param p8, "parentIsAndroidView"    # Z
    .param p9, "needsCustomLayout"    # Z

    .prologue
    .line 635
    invoke-virtual/range {p1 .. p1}, Lcom/facebook/react/flat/FlatShadowNode;->getLayoutWidth()F

    move-result v20

    .line 636
    .local v20, "width":F
    invoke-virtual/range {p1 .. p1}, Lcom/facebook/react/flat/FlatShadowNode;->getLayoutHeight()F

    move-result v17

    .line 638
    .local v17, "height":F
    invoke-virtual/range {p1 .. p1}, Lcom/facebook/react/flat/FlatShadowNode;->getLayoutX()F

    move-result v1

    add-float v3, p2, v1

    .line 639
    .local v3, "left":F
    invoke-virtual/range {p1 .. p1}, Lcom/facebook/react/flat/FlatShadowNode;->getLayoutY()F

    move-result v1

    add-float v4, p3, v1

    .line 640
    .local v4, "top":F
    add-float v5, v3, v20

    .line 641
    .local v5, "right":F
    add-float v6, v4, v17

    .line 643
    .local v6, "bottom":F
    invoke-virtual/range {p1 .. p1}, Lcom/facebook/react/flat/FlatShadowNode;->mountsToView()Z

    move-result v18

    .line 647
    .local v18, "mountsToView":Z
    if-nez p8, :cond_0

    .line 648
    if-nez v18, :cond_3

    const/4 v7, 0x1

    :goto_0
    move-object/from16 v1, p0

    move-object/from16 v2, p1

    invoke-direct/range {v1 .. v7}, Lcom/facebook/react/flat/StateBuilder;->addNodeRegion(Lcom/facebook/react/flat/FlatShadowNode;FFFFZ)V

    .line 651
    :cond_0
    if-eqz v18, :cond_4

    .line 652
    invoke-virtual/range {p0 .. p1}, Lcom/facebook/react/flat/StateBuilder;->ensureBackingViewIsCreated(Lcom/facebook/react/flat/FlatShadowNode;)V

    .line 654
    invoke-direct/range {p0 .. p1}, Lcom/facebook/react/flat/StateBuilder;->addNativeChild(Lcom/facebook/react/flat/FlatShadowNode;)V

    .line 655
    const/4 v9, 0x0

    const/4 v10, 0x0

    sub-float v11, v5, v3

    sub-float v12, v6, v4

    sub-float v13, p4, v3

    sub-float v14, p5, v4

    sub-float v15, p6, v3

    sub-float v16, p7, v4

    move-object/from16 v7, p0

    move-object/from16 v8, p1

    invoke-direct/range {v7 .. v16}, Lcom/facebook/react/flat/StateBuilder;->collectStateForMountableNode(Lcom/facebook/react/flat/FlatShadowNode;FFFFFFFF)Z

    move-result v19

    .line 666
    .local v19, "updated":Z
    if-nez p8, :cond_1

    .line 667
    move-object/from16 v0, p0

    iget-object v1, v0, Lcom/facebook/react/flat/StateBuilder;->mDrawCommands:Lcom/facebook/react/flat/ElementsList;

    move-object/from16 v2, p1

    move/from16 v7, p4

    move/from16 v8, p5

    move/from16 v9, p6

    move/from16 v10, p7

    invoke-virtual/range {v2 .. v10}, Lcom/facebook/react/flat/FlatShadowNode;->collectDrawView(FFFFFFFF)Lcom/facebook/react/flat/DrawView;

    move-result-object v2

    invoke-virtual {v1, v2}, Lcom/facebook/react/flat/ElementsList;->add(Ljava/lang/Object;)V

    .line 678
    :cond_1
    if-nez p9, :cond_2

    move-object/from16 v1, p0

    move-object/from16 v2, p1

    .line 679
    invoke-direct/range {v1 .. v6}, Lcom/facebook/react/flat/StateBuilder;->updateViewBounds(Lcom/facebook/react/flat/FlatShadowNode;FFFF)V

    .line 696
    :cond_2
    :goto_1
    return v19

    .line 648
    .end local v19    # "updated":Z
    :cond_3
    const/4 v7, 0x0

    goto :goto_0

    .line 682
    :cond_4
    const/4 v11, 0x0

    const/4 v12, 0x0

    move-object/from16 v1, p0

    move-object/from16 v2, p1

    move/from16 v7, p4

    move/from16 v8, p5

    move/from16 v9, p6

    move/from16 v10, p7

    invoke-direct/range {v1 .. v12}, Lcom/facebook/react/flat/StateBuilder;->collectStateRecursively(Lcom/facebook/react/flat/FlatShadowNode;FFFFFFFFZZ)Z

    move-result v19

    .restart local v19    # "updated":Z
    goto :goto_1
.end method

.method private static roundToPixel(F)F
    .locals 2
    .param p0, "pos"    # F

    .prologue
    .line 729
    const/high16 v0, 0x3f000000    # 0.5f

    add-float/2addr v0, p0

    float-to-double v0, v0

    invoke-static {v0, v1}, Ljava/lang/Math;->floor(D)D

    move-result-wide v0

    double-to-float v0, v0

    return v0
.end method

.method private updateNativeChildren(Lcom/facebook/react/flat/FlatShadowNode;[Lcom/facebook/react/flat/FlatShadowNode;[Lcom/facebook/react/flat/FlatShadowNode;)V
    .locals 11
    .param p1, "node"    # Lcom/facebook/react/flat/FlatShadowNode;
    .param p2, "oldNativeChildren"    # [Lcom/facebook/react/flat/FlatShadowNode;
    .param p3, "newNativeChildren"    # [Lcom/facebook/react/flat/FlatShadowNode;

    .prologue
    const/4 v10, -0x1

    const/4 v6, 0x0

    .line 490
    invoke-virtual {p1, p3}, Lcom/facebook/react/flat/FlatShadowNode;->setNativeChildren([Lcom/facebook/react/flat/FlatShadowNode;)V

    .line 492
    iget-object v7, p0, Lcom/facebook/react/flat/StateBuilder;->mDetachAllChildrenFromViews:Lcom/facebook/react/flat/FlatUIViewOperationQueue$DetachAllChildrenFromViews;

    if-nez v7, :cond_0

    .line 493
    iget-object v7, p0, Lcom/facebook/react/flat/StateBuilder;->mOperationsQueue:Lcom/facebook/react/flat/FlatUIViewOperationQueue;

    invoke-virtual {v7}, Lcom/facebook/react/flat/FlatUIViewOperationQueue;->enqueueDetachAllChildrenFromViews()Lcom/facebook/react/flat/FlatUIViewOperationQueue$DetachAllChildrenFromViews;

    move-result-object v7

    iput-object v7, p0, Lcom/facebook/react/flat/StateBuilder;->mDetachAllChildrenFromViews:Lcom/facebook/react/flat/FlatUIViewOperationQueue$DetachAllChildrenFromViews;

    .line 496
    :cond_0
    array-length v7, p2

    if-eqz v7, :cond_1

    .line 497
    iget-object v7, p0, Lcom/facebook/react/flat/StateBuilder;->mViewsToDetachAllChildrenFrom:Ljava/util/ArrayList;

    invoke-virtual {v7, p1}, Ljava/util/ArrayList;->add(Ljava/lang/Object;)Z

    .line 500
    :cond_1
    invoke-virtual {p1}, Lcom/facebook/react/flat/FlatShadowNode;->getReactTag()I

    move-result v3

    .line 501
    .local v3, "tag":I
    array-length v2, p3

    .line 503
    .local v2, "numViewsToAdd":I
    if-nez v2, :cond_4

    .line 504
    sget-object v4, Lcom/facebook/react/flat/StateBuilder;->EMPTY_INT_ARRAY:[I

    .line 522
    .local v4, "viewsToAdd":[I
    :cond_2
    array-length v8, p2

    move v7, v6

    :goto_0
    if-ge v7, v8, :cond_6

    aget-object v0, p2, v7

    .line 523
    .local v0, "child":Lcom/facebook/react/flat/FlatShadowNode;
    invoke-virtual {v0}, Lcom/facebook/react/flat/FlatShadowNode;->getNativeParentTag()I

    move-result v9

    if-ne v9, v3, :cond_3

    .line 525
    iget-object v9, p0, Lcom/facebook/react/flat/StateBuilder;->mViewsToDetach:Ljava/util/ArrayList;

    invoke-virtual {v9, v0}, Ljava/util/ArrayList;->add(Ljava/lang/Object;)Z

    .line 526
    invoke-virtual {v0, v10}, Lcom/facebook/react/flat/FlatShadowNode;->setNativeParentTag(I)V

    .line 522
    :cond_3
    add-int/lit8 v7, v7, 0x1

    goto :goto_0

    .line 506
    .end local v0    # "child":Lcom/facebook/react/flat/FlatShadowNode;
    .end local v4    # "viewsToAdd":[I
    :cond_4
    new-array v4, v2, [I

    .line 507
    .restart local v4    # "viewsToAdd":[I
    const/4 v1, 0x0

    .line 508
    .local v1, "i":I
    array-length v8, p3

    move v7, v6

    :goto_1
    if-ge v7, v8, :cond_2

    aget-object v0, p3, v7

    .line 509
    .restart local v0    # "child":Lcom/facebook/react/flat/FlatShadowNode;
    invoke-virtual {v0}, Lcom/facebook/react/flat/FlatShadowNode;->getNativeParentTag()I

    move-result v9

    if-ne v9, v3, :cond_5

    .line 510
    invoke-virtual {v0}, Lcom/facebook/react/flat/FlatShadowNode;->getReactTag()I

    move-result v9

    neg-int v9, v9

    aput v9, v4, v1

    .line 515
    :goto_2
    invoke-virtual {v0, v10}, Lcom/facebook/react/flat/FlatShadowNode;->setNativeParentTag(I)V

    .line 516
    add-int/lit8 v1, v1, 0x1

    .line 508
    add-int/lit8 v7, v7, 0x1

    goto :goto_1

    .line 512
    :cond_5
    invoke-virtual {v0}, Lcom/facebook/react/flat/FlatShadowNode;->getReactTag()I

    move-result v9

    aput v9, v4, v1

    goto :goto_2

    .line 530
    .end local v0    # "child":Lcom/facebook/react/flat/FlatShadowNode;
    .end local v1    # "i":I
    :cond_6
    iget-object v7, p0, Lcom/facebook/react/flat/StateBuilder;->mViewsToDetach:Ljava/util/ArrayList;

    invoke-static {v7}, Lcom/facebook/react/flat/StateBuilder;->collectViewTags(Ljava/util/ArrayList;)[I

    move-result-object v5

    .line 531
    .local v5, "viewsToDetach":[I
    iget-object v7, p0, Lcom/facebook/react/flat/StateBuilder;->mViewsToDetach:Ljava/util/ArrayList;

    invoke-virtual {v7}, Ljava/util/ArrayList;->clear()V

    .line 534
    array-length v7, p3

    :goto_3
    if-ge v6, v7, :cond_7

    aget-object v0, p3, v6

    .line 535
    .restart local v0    # "child":Lcom/facebook/react/flat/FlatShadowNode;
    invoke-virtual {v0, v3}, Lcom/facebook/react/flat/FlatShadowNode;->setNativeParentTag(I)V

    .line 534
    add-int/lit8 v6, v6, 0x1

    goto :goto_3

    .line 538
    .end local v0    # "child":Lcom/facebook/react/flat/FlatShadowNode;
    :cond_7
    iget-object v6, p0, Lcom/facebook/react/flat/StateBuilder;->mOperationsQueue:Lcom/facebook/react/flat/FlatUIViewOperationQueue;

    invoke-virtual {v6, v3, v4, v5}, Lcom/facebook/react/flat/FlatUIViewOperationQueue;->enqueueUpdateViewGroup(I[I[I)V

    .line 539
    return-void
.end method

.method private updateViewBounds(Lcom/facebook/react/flat/FlatShadowNode;FFFF)V
    .locals 7
    .param p1, "node"    # Lcom/facebook/react/flat/FlatShadowNode;
    .param p2, "left"    # F
    .param p3, "top"    # F
    .param p4, "right"    # F
    .param p5, "bottom"    # F

    .prologue
    .line 288
    invoke-static {p2}, Ljava/lang/Math;->round(F)I

    move-result v2

    .line 289
    .local v2, "viewLeft":I
    invoke-static {p3}, Ljava/lang/Math;->round(F)I

    move-result v3

    .line 290
    .local v3, "viewTop":I
    invoke-static {p4}, Ljava/lang/Math;->round(F)I

    move-result v4

    .line 291
    .local v4, "viewRight":I
    invoke-static {p5}, Ljava/lang/Math;->round(F)I

    move-result v5

    .line 292
    .local v5, "viewBottom":I
    invoke-virtual {p1}, Lcom/facebook/react/flat/FlatShadowNode;->getViewLeft()I

    move-result v0

    if-ne v0, v2, :cond_0

    invoke-virtual {p1}, Lcom/facebook/react/flat/FlatShadowNode;->getViewTop()I

    move-result v0

    if-ne v0, v3, :cond_0

    .line 293
    invoke-virtual {p1}, Lcom/facebook/react/flat/FlatShadowNode;->getViewRight()I

    move-result v0

    if-ne v0, v4, :cond_0

    invoke-virtual {p1}, Lcom/facebook/react/flat/FlatShadowNode;->getViewBottom()I

    move-result v0

    if-ne v0, v5, :cond_0

    .line 304
    :goto_0
    return-void

    .line 299
    :cond_0
    invoke-virtual {p1, v2, v3, v4, v5}, Lcom/facebook/react/flat/FlatShadowNode;->setViewBounds(IIII)V

    .line 300
    invoke-virtual {p1}, Lcom/facebook/react/flat/FlatShadowNode;->getReactTag()I

    move-result v1

    .line 302
    .local v1, "tag":I
    iget-object v6, p0, Lcom/facebook/react/flat/StateBuilder;->mUpdateViewBoundsOperations:Ljava/util/ArrayList;

    iget-object v0, p0, Lcom/facebook/react/flat/StateBuilder;->mOperationsQueue:Lcom/facebook/react/flat/FlatUIViewOperationQueue;

    .line 303
    invoke-virtual/range {v0 .. v5}, Lcom/facebook/react/flat/FlatUIViewOperationQueue;->createUpdateViewBounds(IIIII)Lcom/facebook/react/flat/FlatUIViewOperationQueue$UpdateViewBounds;

    move-result-object v0

    .line 302
    invoke-virtual {v6, v0}, Ljava/util/ArrayList;->add(Ljava/lang/Object;)Z

    goto :goto_0
.end method

.method private updateViewPadding(Lcom/facebook/react/flat/AndroidView;I)V
    .locals 6
    .param p1, "androidView"    # Lcom/facebook/react/flat/AndroidView;
    .param p2, "reactTag"    # I

    .prologue
    .line 700
    invoke-interface {p1}, Lcom/facebook/react/flat/AndroidView;->isPaddingChanged()Z

    move-result v0

    if-eqz v0, :cond_0

    .line 701
    iget-object v0, p0, Lcom/facebook/react/flat/StateBuilder;->mOperationsQueue:Lcom/facebook/react/flat/FlatUIViewOperationQueue;

    const/4 v1, 0x0

    .line 703
    invoke-interface {p1, v1}, Lcom/facebook/react/flat/AndroidView;->getPadding(I)F

    move-result v1

    invoke-static {v1}, Ljava/lang/Math;->round(F)I

    move-result v2

    const/4 v1, 0x1

    .line 704
    invoke-interface {p1, v1}, Lcom/facebook/react/flat/AndroidView;->getPadding(I)F

    move-result v1

    invoke-static {v1}, Ljava/lang/Math;->round(F)I

    move-result v3

    const/4 v1, 0x2

    .line 705
    invoke-interface {p1, v1}, Lcom/facebook/react/flat/AndroidView;->getPadding(I)F

    move-result v1

    invoke-static {v1}, Ljava/lang/Math;->round(F)I

    move-result v4

    const/4 v1, 0x3

    .line 706
    invoke-interface {p1, v1}, Lcom/facebook/react/flat/AndroidView;->getPadding(I)F

    move-result v1

    invoke-static {v1}, Ljava/lang/Math;->round(F)I

    move-result v5

    move v1, p2

    .line 701
    invoke-virtual/range {v0 .. v5}, Lcom/facebook/react/flat/FlatUIViewOperationQueue;->enqueueSetPadding(IIIII)V

    .line 707
    invoke-interface {p1}, Lcom/facebook/react/flat/AndroidView;->resetPaddingChanged()V

    .line 709
    :cond_0
    return-void
.end method


# virtual methods
.method addAttachDetachListener(Lcom/facebook/react/flat/AttachDetachListener;)V
    .locals 1
    .param p1, "listener"    # Lcom/facebook/react/flat/AttachDetachListener;

    .prologue
    .line 167
    iget-object v0, p0, Lcom/facebook/react/flat/StateBuilder;->mAttachDetachListeners:Lcom/facebook/react/flat/ElementsList;

    invoke-virtual {v0, p1}, Lcom/facebook/react/flat/ElementsList;->add(Ljava/lang/Object;)V

    .line 168
    return-void
.end method

.method addDrawCommand(Lcom/facebook/react/flat/AbstractDrawCommand;)V
    .locals 1
    .param p1, "drawCommand"    # Lcom/facebook/react/flat/AbstractDrawCommand;

    .prologue
    .line 157
    iget-object v0, p0, Lcom/facebook/react/flat/StateBuilder;->mDrawCommands:Lcom/facebook/react/flat/ElementsList;

    invoke-virtual {v0, p1}, Lcom/facebook/react/flat/ElementsList;->add(Ljava/lang/Object;)V

    .line 158
    return-void
.end method

.method afterUpdateViewHierarchy(Lcom/facebook/react/uimanager/events/EventDispatcher;)V
    .locals 6
    .param p1, "eventDispatcher"    # Lcom/facebook/react/uimanager/events/EventDispatcher;

    .prologue
    .line 107
    iget-object v3, p0, Lcom/facebook/react/flat/StateBuilder;->mDetachAllChildrenFromViews:Lcom/facebook/react/flat/FlatUIViewOperationQueue$DetachAllChildrenFromViews;

    if-eqz v3, :cond_0

    .line 108
    iget-object v3, p0, Lcom/facebook/react/flat/StateBuilder;->mViewsToDetachAllChildrenFrom:Ljava/util/ArrayList;

    invoke-static {v3}, Lcom/facebook/react/flat/StateBuilder;->collectViewTags(Ljava/util/ArrayList;)[I

    move-result-object v2

    .line 109
    .local v2, "viewsToDetachAllChildrenFrom":[I
    iget-object v3, p0, Lcom/facebook/react/flat/StateBuilder;->mViewsToDetachAllChildrenFrom:Ljava/util/ArrayList;

    invoke-virtual {v3}, Ljava/util/ArrayList;->clear()V

    .line 111
    iget-object v3, p0, Lcom/facebook/react/flat/StateBuilder;->mDetachAllChildrenFromViews:Lcom/facebook/react/flat/FlatUIViewOperationQueue$DetachAllChildrenFromViews;

    invoke-virtual {v3, v2}, Lcom/facebook/react/flat/FlatUIViewOperationQueue$DetachAllChildrenFromViews;->setViewsToDetachAllChildrenFrom([I)V

    .line 112
    const/4 v3, 0x0

    iput-object v3, p0, Lcom/facebook/react/flat/StateBuilder;->mDetachAllChildrenFromViews:Lcom/facebook/react/flat/FlatUIViewOperationQueue$DetachAllChildrenFromViews;

    .line 115
    .end local v2    # "viewsToDetachAllChildrenFrom":[I
    :cond_0
    const/4 v0, 0x0

    .local v0, "i":I
    iget-object v3, p0, Lcom/facebook/react/flat/StateBuilder;->mUpdateViewBoundsOperations:Ljava/util/ArrayList;

    invoke-virtual {v3}, Ljava/util/ArrayList;->size()I

    move-result v1

    .local v1, "size":I
    :goto_0
    if-eq v0, v1, :cond_1

    .line 116
    iget-object v4, p0, Lcom/facebook/react/flat/StateBuilder;->mOperationsQueue:Lcom/facebook/react/flat/FlatUIViewOperationQueue;

    iget-object v3, p0, Lcom/facebook/react/flat/StateBuilder;->mUpdateViewBoundsOperations:Ljava/util/ArrayList;

    invoke-virtual {v3, v0}, Ljava/util/ArrayList;->get(I)Ljava/lang/Object;

    move-result-object v3

    check-cast v3, Lcom/facebook/react/uimanager/UIViewOperationQueue$UIOperation;

    invoke-virtual {v4, v3}, Lcom/facebook/react/flat/FlatUIViewOperationQueue;->enqueueFlatUIOperation(Lcom/facebook/react/uimanager/UIViewOperationQueue$UIOperation;)V

    .line 115
    add-int/lit8 v0, v0, 0x1

    goto :goto_0

    .line 118
    :cond_1
    iget-object v3, p0, Lcom/facebook/react/flat/StateBuilder;->mUpdateViewBoundsOperations:Ljava/util/ArrayList;

    invoke-virtual {v3}, Ljava/util/ArrayList;->clear()V

    .line 123
    const/4 v0, 0x0

    iget-object v3, p0, Lcom/facebook/react/flat/StateBuilder;->mViewManagerCommands:Ljava/util/ArrayList;

    invoke-virtual {v3}, Ljava/util/ArrayList;->size()I

    move-result v1

    :goto_1
    if-eq v0, v1, :cond_2

    .line 124
    iget-object v4, p0, Lcom/facebook/react/flat/StateBuilder;->mOperationsQueue:Lcom/facebook/react/flat/FlatUIViewOperationQueue;

    iget-object v3, p0, Lcom/facebook/react/flat/StateBuilder;->mViewManagerCommands:Ljava/util/ArrayList;

    invoke-virtual {v3, v0}, Ljava/util/ArrayList;->get(I)Ljava/lang/Object;

    move-result-object v3

    check-cast v3, Lcom/facebook/react/uimanager/UIViewOperationQueue$UIOperation;

    invoke-virtual {v4, v3}, Lcom/facebook/react/flat/FlatUIViewOperationQueue;->enqueueFlatUIOperation(Lcom/facebook/react/uimanager/UIViewOperationQueue$UIOperation;)V

    .line 123
    add-int/lit8 v0, v0, 0x1

    goto :goto_1

    .line 126
    :cond_2
    iget-object v3, p0, Lcom/facebook/react/flat/StateBuilder;->mViewManagerCommands:Ljava/util/ArrayList;

    invoke-virtual {v3}, Ljava/util/ArrayList;->clear()V

    .line 130
    const/4 v0, 0x0

    iget-object v3, p0, Lcom/facebook/react/flat/StateBuilder;->mOnLayoutEvents:Ljava/util/ArrayList;

    invoke-virtual {v3}, Ljava/util/ArrayList;->size()I

    move-result v1

    :goto_2
    if-eq v0, v1, :cond_3

    .line 131
    iget-object v3, p0, Lcom/facebook/react/flat/StateBuilder;->mOnLayoutEvents:Ljava/util/ArrayList;

    invoke-virtual {v3, v0}, Ljava/util/ArrayList;->get(I)Ljava/lang/Object;

    move-result-object v3

    check-cast v3, Lcom/facebook/react/uimanager/events/Event;

    invoke-virtual {p1, v3}, Lcom/facebook/react/uimanager/events/EventDispatcher;->dispatchEvent(Lcom/facebook/react/uimanager/events/Event;)V

    .line 130
    add-int/lit8 v0, v0, 0x1

    goto :goto_2

    .line 133
    :cond_3
    iget-object v3, p0, Lcom/facebook/react/flat/StateBuilder;->mOnLayoutEvents:Ljava/util/ArrayList;

    invoke-virtual {v3}, Ljava/util/ArrayList;->clear()V

    .line 135
    iget-object v3, p0, Lcom/facebook/react/flat/StateBuilder;->mViewsToDrop:Ljava/util/ArrayList;

    invoke-virtual {v3}, Ljava/util/ArrayList;->size()I

    move-result v3

    if-lez v3, :cond_4

    .line 136
    iget-object v3, p0, Lcom/facebook/react/flat/StateBuilder;->mOperationsQueue:Lcom/facebook/react/flat/FlatUIViewOperationQueue;

    iget-object v4, p0, Lcom/facebook/react/flat/StateBuilder;->mViewsToDrop:Ljava/util/ArrayList;

    iget-object v5, p0, Lcom/facebook/react/flat/StateBuilder;->mParentsForViewsToDrop:Ljava/util/ArrayList;

    invoke-virtual {v3, v4, v5}, Lcom/facebook/react/flat/FlatUIViewOperationQueue;->enqueueDropViews(Ljava/util/ArrayList;Ljava/util/ArrayList;)V

    .line 137
    iget-object v3, p0, Lcom/facebook/react/flat/StateBuilder;->mViewsToDrop:Ljava/util/ArrayList;

    invoke-virtual {v3}, Ljava/util/ArrayList;->clear()V

    .line 138
    iget-object v3, p0, Lcom/facebook/react/flat/StateBuilder;->mParentsForViewsToDrop:Ljava/util/ArrayList;

    invoke-virtual {v3}, Ljava/util/ArrayList;->clear()V

    .line 141
    :cond_4
    iget-object v3, p0, Lcom/facebook/react/flat/StateBuilder;->mOperationsQueue:Lcom/facebook/react/flat/FlatUIViewOperationQueue;

    invoke-virtual {v3}, Lcom/facebook/react/flat/FlatUIViewOperationQueue;->enqueueProcessLayoutRequests()V

    .line 142
    return-void
.end method

.method applyUpdates(Lcom/facebook/react/flat/FlatShadowNode;)V
    .locals 12
    .param p1, "node"    # Lcom/facebook/react/flat/FlatShadowNode;

    .prologue
    const/high16 v8, 0x7f800000    # Float.POSITIVE_INFINITY

    const/high16 v6, -0x800000    # Float.NEGATIVE_INFINITY

    .line 78
    invoke-virtual {p1}, Lcom/facebook/react/flat/FlatShadowNode;->getLayoutWidth()F

    move-result v11

    .line 79
    .local v11, "width":F
    invoke-virtual {p1}, Lcom/facebook/react/flat/FlatShadowNode;->getLayoutHeight()F

    move-result v10

    .line 80
    .local v10, "height":F
    invoke-virtual {p1}, Lcom/facebook/react/flat/FlatShadowNode;->getLayoutX()F

    move-result v2

    .line 81
    .local v2, "left":F
    invoke-virtual {p1}, Lcom/facebook/react/flat/FlatShadowNode;->getLayoutY()F

    move-result v3

    .line 82
    .local v3, "top":F
    add-float v4, v2, v11

    .line 83
    .local v4, "right":F
    add-float v5, v3, v10

    .local v5, "bottom":F
    move-object v0, p0

    move-object v1, p1

    move v7, v6

    move v9, v8

    .line 85
    invoke-direct/range {v0 .. v9}, Lcom/facebook/react/flat/StateBuilder;->collectStateForMountableNode(Lcom/facebook/react/flat/FlatShadowNode;FFFFFFFF)Z

    move-object v0, p0

    move-object v1, p1

    .line 96
    invoke-direct/range {v0 .. v5}, Lcom/facebook/react/flat/StateBuilder;->updateViewBounds(Lcom/facebook/react/flat/FlatShadowNode;FFFF)V

    .line 97
    return-void
.end method

.method dropView(Lcom/facebook/react/flat/FlatShadowNode;I)V
    .locals 2
    .param p1, "node"    # Lcom/facebook/react/flat/FlatShadowNode;
    .param p2, "parentReactTag"    # I

    .prologue
    .line 235
    iget-object v0, p0, Lcom/facebook/react/flat/StateBuilder;->mViewsToDrop:Ljava/util/ArrayList;

    invoke-virtual {p1}, Lcom/facebook/react/flat/FlatShadowNode;->getReactTag()I

    move-result v1

    invoke-static {v1}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v1

    invoke-virtual {v0, v1}, Ljava/util/ArrayList;->add(Ljava/lang/Object;)Z

    .line 236
    iget-object v0, p0, Lcom/facebook/react/flat/StateBuilder;->mParentsForViewsToDrop:Ljava/util/ArrayList;

    invoke-static {p2}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v1

    invoke-virtual {v0, v1}, Ljava/util/ArrayList;->add(Ljava/lang/Object;)Z

    .line 237
    return-void
.end method

.method enqueueCreateOrUpdateView(Lcom/facebook/react/flat/FlatShadowNode;Lcom/facebook/react/uimanager/ReactStylesDiffMap;)V
    .locals 4
    .param p1, "node"    # Lcom/facebook/react/flat/FlatShadowNode;
    .param p2, "styles"    # Lcom/facebook/react/uimanager/ReactStylesDiffMap;
        .annotation runtime Ljavax/annotation/Nullable;
        .end annotation
    .end param

    .prologue
    .line 195
    invoke-virtual {p1}, Lcom/facebook/react/flat/FlatShadowNode;->isBackingViewCreated()Z

    move-result v0

    if-eqz v0, :cond_0

    .line 197
    iget-object v0, p0, Lcom/facebook/react/flat/StateBuilder;->mOperationsQueue:Lcom/facebook/react/flat/FlatUIViewOperationQueue;

    .line 198
    invoke-virtual {p1}, Lcom/facebook/react/flat/FlatShadowNode;->getReactTag()I

    move-result v1

    .line 199
    invoke-virtual {p1}, Lcom/facebook/react/flat/FlatShadowNode;->getViewClass()Ljava/lang/String;

    move-result-object v2

    .line 197
    invoke-virtual {v0, v1, v2, p2}, Lcom/facebook/react/flat/FlatUIViewOperationQueue;->enqueueUpdateProperties(ILjava/lang/String;Lcom/facebook/react/uimanager/ReactStylesDiffMap;)V

    .line 210
    :goto_0
    return-void

    .line 202
    :cond_0
    iget-object v0, p0, Lcom/facebook/react/flat/StateBuilder;->mOperationsQueue:Lcom/facebook/react/flat/FlatUIViewOperationQueue;

    .line 203
    invoke-virtual {p1}, Lcom/facebook/react/flat/FlatShadowNode;->getThemedContext()Lcom/facebook/react/uimanager/ThemedReactContext;

    move-result-object v1

    .line 204
    invoke-virtual {p1}, Lcom/facebook/react/flat/FlatShadowNode;->getReactTag()I

    move-result v2

    .line 205
    invoke-virtual {p1}, Lcom/facebook/react/flat/FlatShadowNode;->getViewClass()Ljava/lang/String;

    move-result-object v3

    .line 202
    invoke-virtual {v0, v1, v2, v3, p2}, Lcom/facebook/react/flat/FlatUIViewOperationQueue;->enqueueCreateView(Lcom/facebook/react/uimanager/ThemedReactContext;ILjava/lang/String;Lcom/facebook/react/uimanager/ReactStylesDiffMap;)V

    .line 208
    invoke-virtual {p1}, Lcom/facebook/react/flat/FlatShadowNode;->signalBackingViewIsCreated()V

    goto :goto_0
.end method

.method enqueueViewManagerCommand(IILcom/facebook/react/bridge/ReadableArray;)V
    .locals 2
    .param p1, "reactTag"    # I
    .param p2, "commandId"    # I
    .param p3, "commandArgs"    # Lcom/facebook/react/bridge/ReadableArray;

    .prologue
    .line 182
    iget-object v0, p0, Lcom/facebook/react/flat/StateBuilder;->mViewManagerCommands:Ljava/util/ArrayList;

    iget-object v1, p0, Lcom/facebook/react/flat/StateBuilder;->mOperationsQueue:Lcom/facebook/react/flat/FlatUIViewOperationQueue;

    .line 183
    invoke-virtual {v1, p1, p2, p3}, Lcom/facebook/react/flat/FlatUIViewOperationQueue;->createViewManagerCommand(IILcom/facebook/react/bridge/ReadableArray;)Lcom/facebook/react/flat/FlatUIViewOperationQueue$ViewManagerCommand;

    move-result-object v1

    .line 182
    invoke-virtual {v0, v1}, Ljava/util/ArrayList;->add(Ljava/lang/Object;)Z

    .line 184
    return-void
.end method

.method ensureBackingViewIsCreated(Lcom/facebook/react/flat/FlatShadowNode;)V
    .locals 5
    .param p1, "node"    # Lcom/facebook/react/flat/FlatShadowNode;

    .prologue
    .line 218
    invoke-virtual {p1}, Lcom/facebook/react/flat/FlatShadowNode;->isBackingViewCreated()Z

    move-result v1

    if-eqz v1, :cond_0

    .line 226
    :goto_0
    return-void

    .line 222
    :cond_0
    invoke-virtual {p1}, Lcom/facebook/react/flat/FlatShadowNode;->getReactTag()I

    move-result v0

    .line 223
    .local v0, "tag":I
    iget-object v1, p0, Lcom/facebook/react/flat/StateBuilder;->mOperationsQueue:Lcom/facebook/react/flat/FlatUIViewOperationQueue;

    invoke-virtual {p1}, Lcom/facebook/react/flat/FlatShadowNode;->getThemedContext()Lcom/facebook/react/uimanager/ThemedReactContext;

    move-result-object v2

    invoke-virtual {p1}, Lcom/facebook/react/flat/FlatShadowNode;->getViewClass()Ljava/lang/String;

    move-result-object v3

    const/4 v4, 0x0

    invoke-virtual {v1, v2, v0, v3, v4}, Lcom/facebook/react/flat/FlatUIViewOperationQueue;->enqueueCreateView(Lcom/facebook/react/uimanager/ThemedReactContext;ILjava/lang/String;Lcom/facebook/react/uimanager/ReactStylesDiffMap;)V

    .line 225
    invoke-virtual {p1}, Lcom/facebook/react/flat/FlatShadowNode;->signalBackingViewIsCreated()V

    goto :goto_0
.end method

.method getOperationsQueue()Lcom/facebook/react/flat/FlatUIViewOperationQueue;
    .locals 1

    .prologue
    .line 69
    iget-object v0, p0, Lcom/facebook/react/flat/StateBuilder;->mOperationsQueue:Lcom/facebook/react/flat/FlatUIViewOperationQueue;

    return-object v0
.end method

.method removeRootView(I)V
    .locals 2
    .param p1, "rootViewTag"    # I

    .prologue
    .line 146
    iget-object v0, p0, Lcom/facebook/react/flat/StateBuilder;->mViewsToDrop:Ljava/util/ArrayList;

    neg-int v1, p1

    invoke-static {v1}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v1

    invoke-virtual {v0, v1}, Ljava/util/ArrayList;->add(Ljava/lang/Object;)Z

    .line 147
    iget-object v0, p0, Lcom/facebook/react/flat/StateBuilder;->mParentsForViewsToDrop:Ljava/util/ArrayList;

    const/4 v1, -0x1

    invoke-static {v1}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v1

    invoke-virtual {v0, v1}, Ljava/util/ArrayList;->add(Ljava/lang/Object;)Z

    .line 148
    return-void
.end method

.class abstract Lcom/facebook/react/flat/ClippingDrawCommandManager;
.super Lcom/facebook/react/flat/DrawCommandManager;
.source "ClippingDrawCommandManager.java"


# static fields
.field private static final TAG:Ljava/lang/String;


# instance fields
.field private final mClippedSubviews:Landroid/util/SparseArray;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Landroid/util/SparseArray",
            "<",
            "Landroid/view/View;",
            ">;"
        }
    .end annotation
.end field

.field protected final mClippingRect:Landroid/graphics/Rect;

.field private final mClippingViewGroups:Ljava/util/ArrayList;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/ArrayList",
            "<",
            "Lcom/facebook/react/uimanager/ReactClippingViewGroup;",
            ">;"
        }
    .end annotation
.end field

.field protected mCommandMaxBottom:[F

.field protected mCommandMinTop:[F

.field private mDrawCommands:[Lcom/facebook/react/flat/DrawCommand;

.field private mDrawViewIndexMap:Landroid/util/SparseIntArray;

.field private final mFlatViewGroup:Lcom/facebook/react/flat/FlatViewGroup;

.field private mNodeRegions:[Lcom/facebook/react/flat/NodeRegion;

.field protected mRegionMaxBottom:[F

.field protected mRegionMinTop:[F

.field private mStart:I

.field private mStop:I

.field private final mViewsToKeep:Ljava/util/ArrayList;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/ArrayList",
            "<",
            "Landroid/view/View;",
            ">;"
        }
    .end annotation
.end field

.field private final mViewsToRemove:Landroid/util/SparseArray;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Landroid/util/SparseArray",
            "<",
            "Landroid/view/View;",
            ">;"
        }
    .end annotation
.end field


# direct methods
.method static constructor <clinit>()V
    .locals 1

    .prologue
    .line 150
    const-class v0, Lcom/facebook/react/flat/ClippingDrawCommandManager;

    invoke-virtual {v0}, Ljava/lang/Class;->getSimpleName()Ljava/lang/String;

    move-result-object v0

    sput-object v0, Lcom/facebook/react/flat/ClippingDrawCommandManager;->TAG:Ljava/lang/String;

    return-void
.end method

.method constructor <init>(Lcom/facebook/react/flat/FlatViewGroup;[Lcom/facebook/react/flat/DrawCommand;)V
    .locals 1
    .param p1, "flatViewGroup"    # Lcom/facebook/react/flat/FlatViewGroup;
    .param p2, "drawCommands"    # [Lcom/facebook/react/flat/DrawCommand;

    .prologue
    .line 182
    invoke-direct {p0}, Lcom/facebook/react/flat/DrawCommandManager;-><init>()V

    .line 153
    sget-object v0, Lcom/facebook/react/flat/DrawCommand;->EMPTY_ARRAY:[Lcom/facebook/react/flat/DrawCommand;

    iput-object v0, p0, Lcom/facebook/react/flat/ClippingDrawCommandManager;->mDrawCommands:[Lcom/facebook/react/flat/DrawCommand;

    .line 154
    sget-object v0, Lcom/facebook/react/flat/StateBuilder;->EMPTY_FLOAT_ARRAY:[F

    iput-object v0, p0, Lcom/facebook/react/flat/ClippingDrawCommandManager;->mCommandMaxBottom:[F

    .line 155
    sget-object v0, Lcom/facebook/react/flat/StateBuilder;->EMPTY_FLOAT_ARRAY:[F

    iput-object v0, p0, Lcom/facebook/react/flat/ClippingDrawCommandManager;->mCommandMinTop:[F

    .line 157
    sget-object v0, Lcom/facebook/react/flat/NodeRegion;->EMPTY_ARRAY:[Lcom/facebook/react/flat/NodeRegion;

    iput-object v0, p0, Lcom/facebook/react/flat/ClippingDrawCommandManager;->mNodeRegions:[Lcom/facebook/react/flat/NodeRegion;

    .line 158
    sget-object v0, Lcom/facebook/react/flat/StateBuilder;->EMPTY_FLOAT_ARRAY:[F

    iput-object v0, p0, Lcom/facebook/react/flat/ClippingDrawCommandManager;->mRegionMaxBottom:[F

    .line 159
    sget-object v0, Lcom/facebook/react/flat/StateBuilder;->EMPTY_FLOAT_ARRAY:[F

    iput-object v0, p0, Lcom/facebook/react/flat/ClippingDrawCommandManager;->mRegionMinTop:[F

    .line 167
    sget-object v0, Lcom/facebook/react/flat/StateBuilder;->EMPTY_SPARSE_INT:Landroid/util/SparseIntArray;

    iput-object v0, p0, Lcom/facebook/react/flat/ClippingDrawCommandManager;->mDrawViewIndexMap:Landroid/util/SparseIntArray;

    .line 169
    new-instance v0, Landroid/util/SparseArray;

    invoke-direct {v0}, Landroid/util/SparseArray;-><init>()V

    iput-object v0, p0, Lcom/facebook/react/flat/ClippingDrawCommandManager;->mClippedSubviews:Landroid/util/SparseArray;

    .line 171
    new-instance v0, Landroid/graphics/Rect;

    invoke-direct {v0}, Landroid/graphics/Rect;-><init>()V

    iput-object v0, p0, Lcom/facebook/react/flat/ClippingDrawCommandManager;->mClippingRect:Landroid/graphics/Rect;

    .line 176
    new-instance v0, Landroid/util/SparseArray;

    invoke-direct {v0}, Landroid/util/SparseArray;-><init>()V

    iput-object v0, p0, Lcom/facebook/react/flat/ClippingDrawCommandManager;->mViewsToRemove:Landroid/util/SparseArray;

    .line 177
    new-instance v0, Ljava/util/ArrayList;

    invoke-direct {v0}, Ljava/util/ArrayList;-><init>()V

    iput-object v0, p0, Lcom/facebook/react/flat/ClippingDrawCommandManager;->mViewsToKeep:Ljava/util/ArrayList;

    .line 180
    new-instance v0, Ljava/util/ArrayList;

    invoke-direct {v0}, Ljava/util/ArrayList;-><init>()V

    iput-object v0, p0, Lcom/facebook/react/flat/ClippingDrawCommandManager;->mClippingViewGroups:Ljava/util/ArrayList;

    .line 183
    iput-object p1, p0, Lcom/facebook/react/flat/ClippingDrawCommandManager;->mFlatViewGroup:Lcom/facebook/react/flat/FlatViewGroup;

    .line 184
    invoke-direct {p0, p2}, Lcom/facebook/react/flat/ClippingDrawCommandManager;->initialSetup([Lcom/facebook/react/flat/DrawCommand;)V

    .line 185
    return-void
.end method

.method private static animating(Landroid/view/View;)Z
    .locals 2
    .param p0, "view"    # Landroid/view/View;

    .prologue
    .line 405
    invoke-virtual {p0}, Landroid/view/View;->getAnimation()Landroid/view/animation/Animation;

    move-result-object v0

    .line 406
    .local v0, "animation":Landroid/view/animation/Animation;
    if-eqz v0, :cond_0

    invoke-virtual {v0}, Landroid/view/animation/Animation;->hasEnded()Z

    move-result v1

    if-nez v1, :cond_0

    const/4 v1, 0x1

    :goto_0
    return v1

    :cond_0
    const/4 v1, 0x0

    goto :goto_0
.end method

.method private clip(ILandroid/view/View;)V
    .locals 1
    .param p1, "id"    # I
    .param p2, "view"    # Landroid/view/View;

    .prologue
    .line 298
    iget-object v0, p0, Lcom/facebook/react/flat/ClippingDrawCommandManager;->mClippedSubviews:Landroid/util/SparseArray;

    invoke-virtual {v0, p1, p2}, Landroid/util/SparseArray;->put(ILjava/lang/Object;)V

    .line 299
    return-void
.end method

.method private initialSetup([Lcom/facebook/react/flat/DrawCommand;)V
    .locals 6
    .param p1, "drawCommands"    # [Lcom/facebook/react/flat/DrawCommand;

    .prologue
    .line 195
    iget-object v2, p0, Lcom/facebook/react/flat/ClippingDrawCommandManager;->mDrawViewIndexMap:Landroid/util/SparseIntArray;

    iget-object v3, p0, Lcom/facebook/react/flat/ClippingDrawCommandManager;->mCommandMaxBottom:[F

    iget-object v4, p0, Lcom/facebook/react/flat/ClippingDrawCommandManager;->mCommandMinTop:[F

    const/4 v5, 0x1

    move-object v0, p0

    move-object v1, p1

    invoke-virtual/range {v0 .. v5}, Lcom/facebook/react/flat/ClippingDrawCommandManager;->mountDrawCommands([Lcom/facebook/react/flat/DrawCommand;Landroid/util/SparseIntArray;[F[FZ)V

    .line 201
    invoke-virtual {p0}, Lcom/facebook/react/flat/ClippingDrawCommandManager;->updateClippingRect()Z

    .line 202
    return-void
.end method

.method private isClipped(I)Z
    .locals 1
    .param p1, "id"    # I

    .prologue
    .line 306
    iget-object v0, p0, Lcom/facebook/react/flat/ClippingDrawCommandManager;->mClippedSubviews:Landroid/util/SparseArray;

    invoke-virtual {v0, p1}, Landroid/util/SparseArray;->get(I)Ljava/lang/Object;

    move-result-object v0

    if-eqz v0, :cond_0

    const/4 v0, 0x1

    :goto_0
    return v0

    :cond_0
    const/4 v0, 0x0

    goto :goto_0
.end method

.method private isNotClipped(I)Z
    .locals 1
    .param p1, "id"    # I

    .prologue
    .line 310
    iget-object v0, p0, Lcom/facebook/react/flat/ClippingDrawCommandManager;->mClippedSubviews:Landroid/util/SparseArray;

    invoke-virtual {v0, p1}, Landroid/util/SparseArray;->get(I)Ljava/lang/Object;

    move-result-object v0

    if-nez v0, :cond_0

    const/4 v0, 0x1

    :goto_0
    return v0

    :cond_0
    const/4 v0, 0x0

    goto :goto_0
.end method

.method private unclip(I)V
    .locals 1
    .param p1, "id"    # I

    .prologue
    .line 302
    iget-object v0, p0, Lcom/facebook/react/flat/ClippingDrawCommandManager;->mClippedSubviews:Landroid/util/SparseArray;

    invoke-virtual {v0, p1}, Landroid/util/SparseArray;->remove(I)V

    .line 303
    return-void
.end method

.method private updateClippingRecursively()V
    .locals 4

    .prologue
    .line 443
    const/4 v1, 0x0

    .local v1, "i":I
    iget-object v3, p0, Lcom/facebook/react/flat/ClippingDrawCommandManager;->mClippingViewGroups:Ljava/util/ArrayList;

    invoke-virtual {v3}, Ljava/util/ArrayList;->size()I

    move-result v0

    .local v0, "children":I
    :goto_0
    if-ge v1, v0, :cond_1

    .line 444
    iget-object v3, p0, Lcom/facebook/react/flat/ClippingDrawCommandManager;->mClippingViewGroups:Ljava/util/ArrayList;

    invoke-virtual {v3, v1}, Ljava/util/ArrayList;->get(I)Ljava/lang/Object;

    move-result-object v2

    check-cast v2, Lcom/facebook/react/uimanager/ReactClippingViewGroup;

    .local v2, "view":Lcom/facebook/react/uimanager/ReactClippingViewGroup;
    move-object v3, v2

    .line 445
    check-cast v3, Landroid/view/View;

    invoke-virtual {v3}, Landroid/view/View;->getId()I

    move-result v3

    invoke-direct {p0, v3}, Lcom/facebook/react/flat/ClippingDrawCommandManager;->isNotClipped(I)Z

    move-result v3

    if-eqz v3, :cond_0

    .line 446
    invoke-interface {v2}, Lcom/facebook/react/uimanager/ReactClippingViewGroup;->updateClippingRect()V

    .line 443
    :cond_0
    add-int/lit8 v1, v1, 0x1

    goto :goto_0

    .line 449
    .end local v2    # "view":Lcom/facebook/react/uimanager/ReactClippingViewGroup;
    :cond_1
    return-void
.end method

.method private updateClippingToCurrentRect()V
    .locals 15

    .prologue
    const/4 v12, 0x1

    .line 468
    const/4 v5, 0x0

    .local v5, "i":I
    iget-object v13, p0, Lcom/facebook/react/flat/ClippingDrawCommandManager;->mFlatViewGroup:Lcom/facebook/react/flat/FlatViewGroup;

    invoke-virtual {v13}, Lcom/facebook/react/flat/FlatViewGroup;->getChildCount()I

    move-result v10

    .local v10, "size":I
    :goto_0
    if-ge v5, v10, :cond_2

    .line 469
    iget-object v13, p0, Lcom/facebook/react/flat/ClippingDrawCommandManager;->mFlatViewGroup:Lcom/facebook/react/flat/FlatViewGroup;

    invoke-virtual {v13, v5}, Lcom/facebook/react/flat/FlatViewGroup;->getChildAt(I)Landroid/view/View;

    move-result-object v11

    .line 470
    .local v11, "view":Landroid/view/View;
    iget-object v13, p0, Lcom/facebook/react/flat/ClippingDrawCommandManager;->mDrawViewIndexMap:Landroid/util/SparseIntArray;

    invoke-virtual {v11}, Landroid/view/View;->getId()I

    move-result v14

    invoke-virtual {v13, v14}, Landroid/util/SparseIntArray;->get(I)I

    move-result v6

    .line 471
    .local v6, "index":I
    invoke-direct {p0, v6}, Lcom/facebook/react/flat/ClippingDrawCommandManager;->withinBounds(I)Z

    move-result v13

    if-nez v13, :cond_0

    invoke-static {v11}, Lcom/facebook/react/flat/ClippingDrawCommandManager;->animating(Landroid/view/View;)Z

    move-result v13

    if-eqz v13, :cond_1

    .line 472
    :cond_0
    iget-object v13, p0, Lcom/facebook/react/flat/ClippingDrawCommandManager;->mViewsToKeep:Ljava/util/ArrayList;

    invoke-virtual {v13, v11}, Ljava/util/ArrayList;->add(Ljava/lang/Object;)Z

    .line 468
    :goto_1
    add-int/lit8 v5, v5, 0x1

    goto :goto_0

    .line 474
    :cond_1
    iget-object v13, p0, Lcom/facebook/react/flat/ClippingDrawCommandManager;->mViewsToRemove:Landroid/util/SparseArray;

    invoke-virtual {v13, v5, v11}, Landroid/util/SparseArray;->append(ILjava/lang/Object;)V

    .line 475
    invoke-virtual {v11}, Landroid/view/View;->getId()I

    move-result v13

    invoke-direct {p0, v13, v11}, Lcom/facebook/react/flat/ClippingDrawCommandManager;->clip(ILandroid/view/View;)V

    goto :goto_1

    .line 479
    .end local v6    # "index":I
    .end local v11    # "view":Landroid/view/View;
    :cond_2
    iget-object v13, p0, Lcom/facebook/react/flat/ClippingDrawCommandManager;->mViewsToRemove:Landroid/util/SparseArray;

    invoke-virtual {v13}, Landroid/util/SparseArray;->size()I

    move-result v8

    .line 480
    .local v8, "removeSize":I
    const/4 v13, 0x2

    if-le v8, v13, :cond_3

    move v7, v12

    .line 482
    .local v7, "removeAll":Z
    :goto_2
    if-eqz v7, :cond_c

    .line 484
    iget-object v12, p0, Lcom/facebook/react/flat/ClippingDrawCommandManager;->mFlatViewGroup:Lcom/facebook/react/flat/FlatViewGroup;

    invoke-virtual {v12}, Lcom/facebook/react/flat/FlatViewGroup;->detachAllViewsFromParent()V

    .line 486
    const/4 v5, 0x0

    :goto_3
    if-ge v5, v8, :cond_4

    .line 487
    iget-object v13, p0, Lcom/facebook/react/flat/ClippingDrawCommandManager;->mFlatViewGroup:Lcom/facebook/react/flat/FlatViewGroup;

    iget-object v12, p0, Lcom/facebook/react/flat/ClippingDrawCommandManager;->mViewsToRemove:Landroid/util/SparseArray;

    invoke-virtual {v12, v5}, Landroid/util/SparseArray;->valueAt(I)Ljava/lang/Object;

    move-result-object v12

    check-cast v12, Landroid/view/View;

    invoke-virtual {v13, v12}, Lcom/facebook/react/flat/FlatViewGroup;->removeDetachedView(Landroid/view/View;)V

    .line 486
    add-int/lit8 v5, v5, 0x1

    goto :goto_3

    .line 480
    .end local v7    # "removeAll":Z
    :cond_3
    const/4 v7, 0x0

    goto :goto_2

    .line 491
    .end local v8    # "removeSize":I
    .restart local v7    # "removeAll":Z
    .local v9, "removeSize":I
    :goto_4
    add-int/lit8 v8, v9, -0x1

    .end local v9    # "removeSize":I
    .restart local v8    # "removeSize":I
    if-lez v9, :cond_4

    .line 492
    iget-object v13, p0, Lcom/facebook/react/flat/ClippingDrawCommandManager;->mFlatViewGroup:Lcom/facebook/react/flat/FlatViewGroup;

    iget-object v14, p0, Lcom/facebook/react/flat/ClippingDrawCommandManager;->mViewsToRemove:Landroid/util/SparseArray;

    invoke-virtual {v14, v8}, Landroid/util/SparseArray;->keyAt(I)I

    move-result v14

    invoke-virtual {v13, v14, v12}, Lcom/facebook/react/flat/FlatViewGroup;->removeViewsInLayout(II)V

    move v9, v8

    .end local v8    # "removeSize":I
    .restart local v9    # "removeSize":I
    goto :goto_4

    .line 495
    .end local v9    # "removeSize":I
    .restart local v8    # "removeSize":I
    :cond_4
    iget-object v12, p0, Lcom/facebook/react/flat/ClippingDrawCommandManager;->mViewsToRemove:Landroid/util/SparseArray;

    invoke-virtual {v12}, Landroid/util/SparseArray;->clear()V

    .line 497
    iget v3, p0, Lcom/facebook/react/flat/ClippingDrawCommandManager;->mStart:I

    .line 498
    .local v3, "current":I
    const/4 v0, 0x0

    .line 500
    .local v0, "childIndex":I
    const/4 v5, 0x0

    iget-object v12, p0, Lcom/facebook/react/flat/ClippingDrawCommandManager;->mViewsToKeep:Ljava/util/ArrayList;

    invoke-virtual {v12}, Ljava/util/ArrayList;->size()I

    move-result v10

    :goto_5
    if-ge v5, v10, :cond_8

    .line 501
    iget-object v12, p0, Lcom/facebook/react/flat/ClippingDrawCommandManager;->mViewsToKeep:Ljava/util/ArrayList;

    invoke-virtual {v12, v5}, Ljava/util/ArrayList;->get(I)Ljava/lang/Object;

    move-result-object v11

    check-cast v11, Landroid/view/View;

    .line 502
    .restart local v11    # "view":Landroid/view/View;
    iget-object v12, p0, Lcom/facebook/react/flat/ClippingDrawCommandManager;->mDrawViewIndexMap:Landroid/util/SparseIntArray;

    invoke-virtual {v11}, Landroid/view/View;->getId()I

    move-result v13

    invoke-virtual {v12, v13}, Landroid/util/SparseIntArray;->get(I)I

    move-result v2

    .line 503
    .local v2, "commandIndex":I
    if-gt v3, v2, :cond_6

    move v1, v0

    .line 504
    .end local v0    # "childIndex":I
    .local v1, "childIndex":I
    :goto_6
    if-eq v3, v2, :cond_5

    .line 505
    iget-object v12, p0, Lcom/facebook/react/flat/ClippingDrawCommandManager;->mDrawCommands:[Lcom/facebook/react/flat/DrawCommand;

    aget-object v12, v12, v3

    instance-of v12, v12, Lcom/facebook/react/flat/DrawView;

    if-eqz v12, :cond_b

    .line 506
    iget-object v12, p0, Lcom/facebook/react/flat/ClippingDrawCommandManager;->mDrawCommands:[Lcom/facebook/react/flat/DrawCommand;

    aget-object v4, v12, v3

    check-cast v4, Lcom/facebook/react/flat/DrawView;

    .line 507
    .local v4, "drawView":Lcom/facebook/react/flat/DrawView;
    iget-object v13, p0, Lcom/facebook/react/flat/ClippingDrawCommandManager;->mFlatViewGroup:Lcom/facebook/react/flat/FlatViewGroup;

    iget-object v12, p0, Lcom/facebook/react/flat/ClippingDrawCommandManager;->mClippedSubviews:Landroid/util/SparseArray;

    iget v14, v4, Lcom/facebook/react/flat/DrawView;->reactTag:I

    .line 508
    invoke-virtual {v12, v14}, Landroid/util/SparseArray;->get(I)Ljava/lang/Object;

    move-result-object v12

    invoke-static {v12}, Lcom/facebook/infer/annotation/Assertions;->assumeNotNull(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v12

    check-cast v12, Landroid/view/View;

    add-int/lit8 v0, v1, 0x1

    .line 507
    .end local v1    # "childIndex":I
    .restart local v0    # "childIndex":I
    invoke-virtual {v13, v12, v1}, Lcom/facebook/react/flat/FlatViewGroup;->addViewInLayout(Landroid/view/View;I)V

    .line 510
    iget v12, v4, Lcom/facebook/react/flat/DrawView;->reactTag:I

    invoke-direct {p0, v12}, Lcom/facebook/react/flat/ClippingDrawCommandManager;->unclip(I)V

    .line 512
    .end local v4    # "drawView":Lcom/facebook/react/flat/DrawView;
    :goto_7
    add-int/lit8 v3, v3, 0x1

    move v1, v0

    .end local v0    # "childIndex":I
    .restart local v1    # "childIndex":I
    goto :goto_6

    .line 515
    :cond_5
    add-int/lit8 v3, v3, 0x1

    move v0, v1

    .line 517
    .end local v1    # "childIndex":I
    .restart local v0    # "childIndex":I
    :cond_6
    if-eqz v7, :cond_7

    .line 518
    iget-object v12, p0, Lcom/facebook/react/flat/ClippingDrawCommandManager;->mFlatViewGroup:Lcom/facebook/react/flat/FlatViewGroup;

    invoke-virtual {v12, v11, v0}, Lcom/facebook/react/flat/FlatViewGroup;->attachViewToParent(Landroid/view/View;I)V

    .line 522
    :cond_7
    add-int/lit8 v0, v0, 0x1

    .line 500
    add-int/lit8 v5, v5, 0x1

    goto :goto_5

    .line 524
    .end local v2    # "commandIndex":I
    .end local v11    # "view":Landroid/view/View;
    :cond_8
    iget-object v12, p0, Lcom/facebook/react/flat/ClippingDrawCommandManager;->mViewsToKeep:Ljava/util/ArrayList;

    invoke-virtual {v12}, Ljava/util/ArrayList;->clear()V

    move v1, v0

    .line 526
    .end local v0    # "childIndex":I
    .restart local v1    # "childIndex":I
    :goto_8
    iget v12, p0, Lcom/facebook/react/flat/ClippingDrawCommandManager;->mStop:I

    if-ge v3, v12, :cond_9

    .line 527
    iget-object v12, p0, Lcom/facebook/react/flat/ClippingDrawCommandManager;->mDrawCommands:[Lcom/facebook/react/flat/DrawCommand;

    aget-object v12, v12, v3

    instance-of v12, v12, Lcom/facebook/react/flat/DrawView;

    if-eqz v12, :cond_a

    .line 528
    iget-object v12, p0, Lcom/facebook/react/flat/ClippingDrawCommandManager;->mDrawCommands:[Lcom/facebook/react/flat/DrawCommand;

    aget-object v4, v12, v3

    check-cast v4, Lcom/facebook/react/flat/DrawView;

    .line 529
    .restart local v4    # "drawView":Lcom/facebook/react/flat/DrawView;
    iget-object v13, p0, Lcom/facebook/react/flat/ClippingDrawCommandManager;->mFlatViewGroup:Lcom/facebook/react/flat/FlatViewGroup;

    iget-object v12, p0, Lcom/facebook/react/flat/ClippingDrawCommandManager;->mClippedSubviews:Landroid/util/SparseArray;

    iget v14, v4, Lcom/facebook/react/flat/DrawView;->reactTag:I

    .line 530
    invoke-virtual {v12, v14}, Landroid/util/SparseArray;->get(I)Ljava/lang/Object;

    move-result-object v12

    invoke-static {v12}, Lcom/facebook/infer/annotation/Assertions;->assumeNotNull(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v12

    check-cast v12, Landroid/view/View;

    add-int/lit8 v0, v1, 0x1

    .line 529
    .end local v1    # "childIndex":I
    .restart local v0    # "childIndex":I
    invoke-virtual {v13, v12, v1}, Lcom/facebook/react/flat/FlatViewGroup;->addViewInLayout(Landroid/view/View;I)V

    .line 532
    iget v12, v4, Lcom/facebook/react/flat/DrawView;->reactTag:I

    invoke-direct {p0, v12}, Lcom/facebook/react/flat/ClippingDrawCommandManager;->unclip(I)V

    .line 534
    .end local v4    # "drawView":Lcom/facebook/react/flat/DrawView;
    :goto_9
    add-int/lit8 v3, v3, 0x1

    move v1, v0

    .end local v0    # "childIndex":I
    .restart local v1    # "childIndex":I
    goto :goto_8

    .line 536
    :cond_9
    return-void

    :cond_a
    move v0, v1

    .end local v1    # "childIndex":I
    .restart local v0    # "childIndex":I
    goto :goto_9

    .end local v0    # "childIndex":I
    .restart local v1    # "childIndex":I
    .restart local v2    # "commandIndex":I
    .restart local v11    # "view":Landroid/view/View;
    :cond_b
    move v0, v1

    .end local v1    # "childIndex":I
    .restart local v0    # "childIndex":I
    goto :goto_7

    .end local v0    # "childIndex":I
    .end local v2    # "commandIndex":I
    .end local v3    # "current":I
    .end local v11    # "view":Landroid/view/View;
    :cond_c
    move v9, v8

    .end local v8    # "removeSize":I
    .restart local v9    # "removeSize":I
    goto/16 :goto_4
.end method

.method private withinBounds(I)Z
    .locals 1
    .param p1, "i"    # I

    .prologue
    .line 413
    iget v0, p0, Lcom/facebook/react/flat/ClippingDrawCommandManager;->mStart:I

    if-gt v0, p1, :cond_0

    iget v0, p0, Lcom/facebook/react/flat/ClippingDrawCommandManager;->mStop:I

    if-ge p1, v0, :cond_0

    const/4 v0, 0x1

    :goto_0
    return v0

    :cond_0
    const/4 v0, 0x0

    goto :goto_0
.end method


# virtual methods
.method public anyNodeRegionWithinBounds(FF)Lcom/facebook/react/flat/NodeRegion;
    .locals 4
    .param p1, "touchX"    # F
    .param p2, "touchY"    # F
    .annotation runtime Ljavax/annotation/Nullable;
    .end annotation

    .prologue
    .line 283
    invoke-virtual {p0, p1, p2}, Lcom/facebook/react/flat/ClippingDrawCommandManager;->regionStopIndex(FF)I

    move-result v0

    .local v0, "i":I
    move v1, v0

    .line 284
    .end local v0    # "i":I
    .local v1, "i":I
    :goto_0
    add-int/lit8 v0, v1, -0x1

    .end local v1    # "i":I
    .restart local v0    # "i":I
    if-lez v1, :cond_0

    .line 285
    iget-object v3, p0, Lcom/facebook/react/flat/ClippingDrawCommandManager;->mNodeRegions:[Lcom/facebook/react/flat/NodeRegion;

    aget-object v2, v3, v0

    .line 286
    .local v2, "nodeRegion":Lcom/facebook/react/flat/NodeRegion;
    invoke-virtual {p0, v0, p1, p2}, Lcom/facebook/react/flat/ClippingDrawCommandManager;->regionAboveTouch(IFF)Z

    move-result v3

    if-eqz v3, :cond_2

    .line 294
    .end local v2    # "nodeRegion":Lcom/facebook/react/flat/NodeRegion;
    :cond_0
    const/4 v2, 0x0

    :cond_1
    return-object v2

    .line 289
    .restart local v2    # "nodeRegion":Lcom/facebook/react/flat/NodeRegion;
    :cond_2
    invoke-virtual {v2, p1, p2}, Lcom/facebook/react/flat/NodeRegion;->withinBounds(FF)Z

    move-result v3

    if-nez v3, :cond_1

    move v1, v0

    .line 292
    .end local v0    # "i":I
    .restart local v1    # "i":I
    goto :goto_0
.end method

.method abstract commandStartIndex()I
.end method

.method abstract commandStopIndex(I)I
.end method

.method debugDraw(Landroid/graphics/Canvas;)V
    .locals 5
    .param p1, "canvas"    # Landroid/graphics/Canvas;

    .prologue
    .line 641
    iget-object v3, p0, Lcom/facebook/react/flat/ClippingDrawCommandManager;->mDrawCommands:[Lcom/facebook/react/flat/DrawCommand;

    array-length v4, v3

    const/4 v1, 0x0

    move v2, v1

    :goto_0
    if-ge v2, v4, :cond_2

    aget-object v0, v3, v2

    .line 642
    .local v0, "drawCommand":Lcom/facebook/react/flat/DrawCommand;
    instance-of v1, v0, Lcom/facebook/react/flat/DrawView;

    if-eqz v1, :cond_1

    move-object v1, v0

    .line 643
    check-cast v1, Lcom/facebook/react/flat/DrawView;

    iget v1, v1, Lcom/facebook/react/flat/DrawView;->reactTag:I

    invoke-direct {p0, v1}, Lcom/facebook/react/flat/ClippingDrawCommandManager;->isNotClipped(I)Z

    move-result v1

    if-eqz v1, :cond_0

    .line 644
    iget-object v1, p0, Lcom/facebook/react/flat/ClippingDrawCommandManager;->mFlatViewGroup:Lcom/facebook/react/flat/FlatViewGroup;

    invoke-virtual {v0, v1, p1}, Lcom/facebook/react/flat/DrawCommand;->debugDraw(Lcom/facebook/react/flat/FlatViewGroup;Landroid/graphics/Canvas;)V

    .line 641
    :cond_0
    :goto_1
    add-int/lit8 v1, v2, 0x1

    move v2, v1

    goto :goto_0

    .line 648
    :cond_1
    iget-object v1, p0, Lcom/facebook/react/flat/ClippingDrawCommandManager;->mFlatViewGroup:Lcom/facebook/react/flat/FlatViewGroup;

    invoke-virtual {v0, v1, p1}, Lcom/facebook/react/flat/DrawCommand;->debugDraw(Lcom/facebook/react/flat/FlatViewGroup;Landroid/graphics/Canvas;)V

    goto :goto_1

    .line 651
    .end local v0    # "drawCommand":Lcom/facebook/react/flat/DrawCommand;
    :cond_2
    return-void
.end method

.method public draw(Landroid/graphics/Canvas;)V
    .locals 9
    .param p1, "canvas"    # Landroid/graphics/Canvas;

    .prologue
    .line 591
    iget v1, p0, Lcom/facebook/react/flat/ClippingDrawCommandManager;->mStart:I

    .line 592
    .local v1, "commandIndex":I
    iget-object v6, p0, Lcom/facebook/react/flat/ClippingDrawCommandManager;->mFlatViewGroup:Lcom/facebook/react/flat/FlatViewGroup;

    invoke-virtual {v6}, Lcom/facebook/react/flat/FlatViewGroup;->getChildCount()I

    move-result v4

    .line 596
    .local v4, "size":I
    const/4 v3, 0x0

    .local v3, "i":I
    :goto_0
    if-ge v3, v4, :cond_3

    .line 600
    iget-object v6, p0, Lcom/facebook/react/flat/ClippingDrawCommandManager;->mDrawViewIndexMap:Landroid/util/SparseIntArray;

    iget-object v7, p0, Lcom/facebook/react/flat/ClippingDrawCommandManager;->mFlatViewGroup:Lcom/facebook/react/flat/FlatViewGroup;

    invoke-virtual {v7, v3}, Lcom/facebook/react/flat/FlatViewGroup;->getChildAt(I)Landroid/view/View;

    move-result-object v7

    invoke-virtual {v7}, Landroid/view/View;->getId()I

    move-result v7

    invoke-virtual {v6, v7}, Landroid/util/SparseIntArray;->get(I)I

    move-result v5

    .line 601
    .local v5, "viewIndex":I
    iget v6, p0, Lcom/facebook/react/flat/ClippingDrawCommandManager;->mStop:I

    if-ge v6, v5, :cond_0

    .line 604
    :goto_1
    iget v6, p0, Lcom/facebook/react/flat/ClippingDrawCommandManager;->mStop:I

    if-ge v1, v6, :cond_2

    .line 605
    iget-object v6, p0, Lcom/facebook/react/flat/ClippingDrawCommandManager;->mDrawCommands:[Lcom/facebook/react/flat/DrawCommand;

    add-int/lit8 v2, v1, 0x1

    .end local v1    # "commandIndex":I
    .local v2, "commandIndex":I
    aget-object v6, v6, v1

    iget-object v7, p0, Lcom/facebook/react/flat/ClippingDrawCommandManager;->mFlatViewGroup:Lcom/facebook/react/flat/FlatViewGroup;

    invoke-virtual {v6, v7, p1}, Lcom/facebook/react/flat/DrawCommand;->draw(Lcom/facebook/react/flat/FlatViewGroup;Landroid/graphics/Canvas;)V

    move v1, v2

    .end local v2    # "commandIndex":I
    .restart local v1    # "commandIndex":I
    goto :goto_1

    .line 609
    :cond_0
    if-gt v1, v5, :cond_2

    move v2, v1

    .line 612
    .end local v1    # "commandIndex":I
    .restart local v2    # "commandIndex":I
    :goto_2
    if-ge v2, v5, :cond_1

    .line 613
    iget-object v6, p0, Lcom/facebook/react/flat/ClippingDrawCommandManager;->mDrawCommands:[Lcom/facebook/react/flat/DrawCommand;

    add-int/lit8 v1, v2, 0x1

    .end local v2    # "commandIndex":I
    .restart local v1    # "commandIndex":I
    aget-object v6, v6, v2

    iget-object v7, p0, Lcom/facebook/react/flat/ClippingDrawCommandManager;->mFlatViewGroup:Lcom/facebook/react/flat/FlatViewGroup;

    invoke-virtual {v6, v7, p1}, Lcom/facebook/react/flat/DrawCommand;->draw(Lcom/facebook/react/flat/FlatViewGroup;Landroid/graphics/Canvas;)V

    move v2, v1

    .end local v1    # "commandIndex":I
    .restart local v2    # "commandIndex":I
    goto :goto_2

    .line 616
    :cond_1
    add-int/lit8 v1, v2, 0x1

    .line 618
    .end local v2    # "commandIndex":I
    .restart local v1    # "commandIndex":I
    :cond_2
    iget-object v6, p0, Lcom/facebook/react/flat/ClippingDrawCommandManager;->mDrawCommands:[Lcom/facebook/react/flat/DrawCommand;

    aget-object v6, v6, v5

    iget-object v7, p0, Lcom/facebook/react/flat/ClippingDrawCommandManager;->mFlatViewGroup:Lcom/facebook/react/flat/FlatViewGroup;

    invoke-virtual {v6, v7, p1}, Lcom/facebook/react/flat/DrawCommand;->draw(Lcom/facebook/react/flat/FlatViewGroup;Landroid/graphics/Canvas;)V

    .line 596
    add-int/lit8 v3, v3, 0x1

    goto :goto_0

    .line 623
    .end local v5    # "viewIndex":I
    :cond_3
    :goto_3
    iget v6, p0, Lcom/facebook/react/flat/ClippingDrawCommandManager;->mStop:I

    if-ge v1, v6, :cond_5

    .line 624
    iget-object v6, p0, Lcom/facebook/react/flat/ClippingDrawCommandManager;->mDrawCommands:[Lcom/facebook/react/flat/DrawCommand;

    add-int/lit8 v2, v1, 0x1

    .end local v1    # "commandIndex":I
    .restart local v2    # "commandIndex":I
    aget-object v0, v6, v1

    .line 625
    .local v0, "command":Lcom/facebook/react/flat/DrawCommand;
    instance-of v6, v0, Lcom/facebook/react/flat/DrawView;

    if-eqz v6, :cond_4

    .line 628
    sget-object v6, Lcom/facebook/react/flat/ClippingDrawCommandManager;->TAG:Ljava/lang/String;

    new-instance v7, Ljava/lang/StringBuilder;

    invoke-direct {v7}, Ljava/lang/StringBuilder;-><init>()V

    const-string v8, "Unexpected DrawView command at index "

    invoke-virtual {v7, v8}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v7

    add-int/lit8 v8, v2, -0x1

    invoke-virtual {v7, v8}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v7

    const-string v8, " with mStop="

    invoke-virtual {v7, v8}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v7

    iget v8, p0, Lcom/facebook/react/flat/ClippingDrawCommandManager;->mStop:I

    invoke-virtual {v7, v8}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v7

    const-string v8, ". "

    invoke-virtual {v7, v8}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v7

    iget-object v8, p0, Lcom/facebook/react/flat/ClippingDrawCommandManager;->mDrawCommands:[Lcom/facebook/react/flat/DrawCommand;

    .line 631
    invoke-static {v8}, Ljava/util/Arrays;->toString([Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v8

    invoke-virtual {v7, v8}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v7

    invoke-virtual {v7}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v7

    .line 628
    invoke-static {v6, v7}, Lcom/facebook/common/logging/FLog;->w(Ljava/lang/String;Ljava/lang/String;)V

    move v1, v2

    .line 632
    .end local v2    # "commandIndex":I
    .restart local v1    # "commandIndex":I
    goto :goto_3

    .line 634
    .end local v1    # "commandIndex":I
    .restart local v2    # "commandIndex":I
    :cond_4
    iget-object v6, p0, Lcom/facebook/react/flat/ClippingDrawCommandManager;->mFlatViewGroup:Lcom/facebook/react/flat/FlatViewGroup;

    invoke-virtual {v0, v6, p1}, Lcom/facebook/react/flat/DrawCommand;->draw(Lcom/facebook/react/flat/FlatViewGroup;Landroid/graphics/Canvas;)V

    move v1, v2

    .line 635
    .end local v2    # "commandIndex":I
    .restart local v1    # "commandIndex":I
    goto :goto_3

    .line 636
    .end local v0    # "command":Lcom/facebook/react/flat/DrawCommand;
    :cond_5
    return-void
.end method

.method public getClippingRect(Landroid/graphics/Rect;)V
    .locals 1
    .param p1, "outClippingRect"    # Landroid/graphics/Rect;

    .prologue
    .line 540
    iget-object v0, p0, Lcom/facebook/react/flat/ClippingDrawCommandManager;->mClippingRect:Landroid/graphics/Rect;

    invoke-virtual {p1, v0}, Landroid/graphics/Rect;->set(Landroid/graphics/Rect;)V

    .line 541
    return-void
.end method

.method public getDetachedViews()Landroid/util/SparseArray;
    .locals 1
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()",
            "Landroid/util/SparseArray",
            "<",
            "Landroid/view/View;",
            ">;"
        }
    .end annotation

    .prologue
    .line 545
    iget-object v0, p0, Lcom/facebook/react/flat/ClippingDrawCommandManager;->mClippedSubviews:Landroid/util/SparseArray;

    return-object v0
.end method

.method public mountDrawCommands([Lcom/facebook/react/flat/DrawCommand;Landroid/util/SparseIntArray;[F[FZ)V
    .locals 2
    .param p1, "drawCommands"    # [Lcom/facebook/react/flat/DrawCommand;
    .param p2, "drawViewIndexMap"    # Landroid/util/SparseIntArray;
    .param p3, "maxBottom"    # [F
    .param p4, "minTop"    # [F
    .param p5, "willMountViews"    # Z

    .prologue
    .line 238
    iput-object p1, p0, Lcom/facebook/react/flat/ClippingDrawCommandManager;->mDrawCommands:[Lcom/facebook/react/flat/DrawCommand;

    .line 239
    iput-object p3, p0, Lcom/facebook/react/flat/ClippingDrawCommandManager;->mCommandMaxBottom:[F

    .line 240
    iput-object p4, p0, Lcom/facebook/react/flat/ClippingDrawCommandManager;->mCommandMinTop:[F

    .line 241
    iput-object p2, p0, Lcom/facebook/react/flat/ClippingDrawCommandManager;->mDrawViewIndexMap:Landroid/util/SparseIntArray;

    .line 242
    iget-object v0, p0, Lcom/facebook/react/flat/ClippingDrawCommandManager;->mClippingRect:Landroid/graphics/Rect;

    iget v0, v0, Landroid/graphics/Rect;->bottom:I

    iget-object v1, p0, Lcom/facebook/react/flat/ClippingDrawCommandManager;->mClippingRect:Landroid/graphics/Rect;

    iget v1, v1, Landroid/graphics/Rect;->top:I

    if-eq v0, v1, :cond_0

    .line 243
    invoke-virtual {p0}, Lcom/facebook/react/flat/ClippingDrawCommandManager;->commandStartIndex()I

    move-result v0

    iput v0, p0, Lcom/facebook/react/flat/ClippingDrawCommandManager;->mStart:I

    .line 244
    iget v0, p0, Lcom/facebook/react/flat/ClippingDrawCommandManager;->mStart:I

    invoke-virtual {p0, v0}, Lcom/facebook/react/flat/ClippingDrawCommandManager;->commandStopIndex(I)I

    move-result v0

    iput v0, p0, Lcom/facebook/react/flat/ClippingDrawCommandManager;->mStop:I

    .line 245
    if-nez p5, :cond_0

    .line 249
    invoke-direct {p0}, Lcom/facebook/react/flat/ClippingDrawCommandManager;->updateClippingToCurrentRect()V

    .line 252
    :cond_0
    return-void
.end method

.method public mountNodeRegions([Lcom/facebook/react/flat/NodeRegion;[F[F)V
    .locals 0
    .param p1, "nodeRegions"    # [Lcom/facebook/react/flat/NodeRegion;
    .param p2, "maxBottom"    # [F
    .param p3, "minTop"    # [F

    .prologue
    .line 256
    iput-object p1, p0, Lcom/facebook/react/flat/ClippingDrawCommandManager;->mNodeRegions:[Lcom/facebook/react/flat/NodeRegion;

    .line 257
    iput-object p2, p0, Lcom/facebook/react/flat/ClippingDrawCommandManager;->mRegionMaxBottom:[F

    .line 258
    iput-object p3, p0, Lcom/facebook/react/flat/ClippingDrawCommandManager;->mRegionMinTop:[F

    .line 259
    return-void
.end method

.method public mountViews(Lcom/facebook/react/flat/ViewResolver;[I[I)V
    .locals 12
    .param p1, "viewResolver"    # Lcom/facebook/react/flat/ViewResolver;
    .param p2, "viewsToAdd"    # [I
    .param p3, "viewsToDetach"    # [I

    .prologue
    const/4 v8, 0x1

    const/4 v7, 0x0

    .line 321
    iget-object v6, p0, Lcom/facebook/react/flat/ClippingDrawCommandManager;->mClippingViewGroups:Ljava/util/ArrayList;

    invoke-virtual {v6}, Ljava/util/ArrayList;->clear()V

    .line 322
    array-length v10, p2

    move v9, v7

    :goto_0
    if-ge v9, v10, :cond_b

    aget v4, p2, v9

    .line 324
    .local v4, "viewToAdd":I
    if-lez v4, :cond_4

    move v2, v8

    .line 325
    .local v2, "newView":Z
    :goto_1
    if-nez v2, :cond_0

    .line 326
    neg-int v4, v4

    .line 329
    :cond_0
    iget-object v6, p0, Lcom/facebook/react/flat/ClippingDrawCommandManager;->mDrawViewIndexMap:Landroid/util/SparseIntArray;

    invoke-virtual {v6, v4}, Landroid/util/SparseIntArray;->get(I)I

    move-result v0

    .line 330
    .local v0, "commandArrayIndex":I
    iget-object v6, p0, Lcom/facebook/react/flat/ClippingDrawCommandManager;->mDrawCommands:[Lcom/facebook/react/flat/DrawCommand;

    aget-object v1, v6, v0

    check-cast v1, Lcom/facebook/react/flat/DrawView;

    .line 331
    .local v1, "drawView":Lcom/facebook/react/flat/DrawView;
    iget v6, v1, Lcom/facebook/react/flat/DrawView;->reactTag:I

    invoke-interface {p1, v6}, Lcom/facebook/react/flat/ViewResolver;->getView(I)Landroid/view/View;

    move-result-object v3

    .line 332
    .local v3, "view":Landroid/view/View;
    invoke-static {v3}, Lcom/facebook/react/flat/ClippingDrawCommandManager;->ensureViewHasNoParent(Landroid/view/View;)V

    .line 335
    instance-of v6, v3, Lcom/facebook/react/uimanager/ReactClippingViewGroup;

    if-eqz v6, :cond_1

    move-object v6, v3

    check-cast v6, Lcom/facebook/react/uimanager/ReactClippingViewGroup;

    .line 336
    invoke-interface {v6}, Lcom/facebook/react/uimanager/ReactClippingViewGroup;->getRemoveClippedSubviews()Z

    move-result v6

    if-eqz v6, :cond_1

    .line 337
    iget-object v11, p0, Lcom/facebook/react/flat/ClippingDrawCommandManager;->mClippingViewGroups:Ljava/util/ArrayList;

    move-object v6, v3

    check-cast v6, Lcom/facebook/react/uimanager/ReactClippingViewGroup;

    invoke-virtual {v11, v6}, Ljava/util/ArrayList;->add(Ljava/lang/Object;)Z

    .line 340
    :cond_1
    if-eqz v2, :cond_6

    .line 342
    iput-boolean v8, v1, Lcom/facebook/react/flat/DrawView;->mWasMounted:Z

    .line 343
    invoke-static {v3}, Lcom/facebook/react/flat/ClippingDrawCommandManager;->animating(Landroid/view/View;)Z

    move-result v6

    if-nez v6, :cond_2

    invoke-direct {p0, v0}, Lcom/facebook/react/flat/ClippingDrawCommandManager;->withinBounds(I)Z

    move-result v6

    if-eqz v6, :cond_5

    .line 346
    :cond_2
    iget-object v6, p0, Lcom/facebook/react/flat/ClippingDrawCommandManager;->mFlatViewGroup:Lcom/facebook/react/flat/FlatViewGroup;

    invoke-virtual {v6, v3}, Lcom/facebook/react/flat/FlatViewGroup;->addViewInLayout(Landroid/view/View;)V

    .line 322
    :cond_3
    :goto_2
    add-int/lit8 v6, v9, 0x1

    move v9, v6

    goto :goto_0

    .end local v0    # "commandArrayIndex":I
    .end local v1    # "drawView":Lcom/facebook/react/flat/DrawView;
    .end local v2    # "newView":Z
    .end local v3    # "view":Landroid/view/View;
    :cond_4
    move v2, v7

    .line 324
    goto :goto_1

    .line 348
    .restart local v0    # "commandArrayIndex":I
    .restart local v1    # "drawView":Lcom/facebook/react/flat/DrawView;
    .restart local v2    # "newView":Z
    .restart local v3    # "view":Landroid/view/View;
    :cond_5
    iget v6, v1, Lcom/facebook/react/flat/DrawView;->reactTag:I

    invoke-direct {p0, v6, v3}, Lcom/facebook/react/flat/ClippingDrawCommandManager;->clip(ILandroid/view/View;)V

    goto :goto_2

    .line 352
    :cond_6
    iget-boolean v6, v1, Lcom/facebook/react/flat/DrawView;->mWasMounted:Z

    if-eqz v6, :cond_7

    .line 354
    iget v6, v1, Lcom/facebook/react/flat/DrawView;->reactTag:I

    invoke-direct {p0, v6}, Lcom/facebook/react/flat/ClippingDrawCommandManager;->isNotClipped(I)Z

    move-result v6

    if-eqz v6, :cond_3

    .line 356
    iget-object v6, p0, Lcom/facebook/react/flat/ClippingDrawCommandManager;->mFlatViewGroup:Lcom/facebook/react/flat/FlatViewGroup;

    invoke-virtual {v6, v3}, Lcom/facebook/react/flat/FlatViewGroup;->attachViewToParent(Landroid/view/View;)V

    goto :goto_2

    .line 361
    :cond_7
    iput-boolean v8, v1, Lcom/facebook/react/flat/DrawView;->mWasMounted:Z

    .line 365
    invoke-static {v3}, Lcom/facebook/react/flat/ClippingDrawCommandManager;->animating(Landroid/view/View;)Z

    move-result v6

    if-nez v6, :cond_8

    invoke-direct {p0, v0}, Lcom/facebook/react/flat/ClippingDrawCommandManager;->withinBounds(I)Z

    move-result v6

    if-eqz v6, :cond_a

    .line 367
    :cond_8
    iget v6, v1, Lcom/facebook/react/flat/DrawView;->reactTag:I

    invoke-direct {p0, v6}, Lcom/facebook/react/flat/ClippingDrawCommandManager;->isClipped(I)Z

    move-result v6

    if-eqz v6, :cond_9

    .line 369
    iget-object v6, p0, Lcom/facebook/react/flat/ClippingDrawCommandManager;->mFlatViewGroup:Lcom/facebook/react/flat/FlatViewGroup;

    invoke-virtual {v6, v3}, Lcom/facebook/react/flat/FlatViewGroup;->addViewInLayout(Landroid/view/View;)V

    .line 370
    iget v6, v1, Lcom/facebook/react/flat/DrawView;->reactTag:I

    invoke-direct {p0, v6}, Lcom/facebook/react/flat/ClippingDrawCommandManager;->unclip(I)V

    goto :goto_2

    .line 374
    :cond_9
    iget-object v6, p0, Lcom/facebook/react/flat/ClippingDrawCommandManager;->mFlatViewGroup:Lcom/facebook/react/flat/FlatViewGroup;

    invoke-virtual {v6, v3}, Lcom/facebook/react/flat/FlatViewGroup;->attachViewToParent(Landroid/view/View;)V

    goto :goto_2

    .line 378
    :cond_a
    iget v6, v1, Lcom/facebook/react/flat/DrawView;->reactTag:I

    invoke-direct {p0, v6}, Lcom/facebook/react/flat/ClippingDrawCommandManager;->isNotClipped(I)Z

    move-result v6

    if-eqz v6, :cond_3

    .line 380
    iget-object v6, p0, Lcom/facebook/react/flat/ClippingDrawCommandManager;->mFlatViewGroup:Lcom/facebook/react/flat/FlatViewGroup;

    invoke-virtual {v6, v3}, Lcom/facebook/react/flat/FlatViewGroup;->removeDetachedView(Landroid/view/View;)V

    .line 381
    iget v6, v1, Lcom/facebook/react/flat/DrawView;->reactTag:I

    invoke-direct {p0, v6, v3}, Lcom/facebook/react/flat/ClippingDrawCommandManager;->clip(ILandroid/view/View;)V

    goto :goto_2

    .line 389
    .end local v0    # "commandArrayIndex":I
    .end local v1    # "drawView":Lcom/facebook/react/flat/DrawView;
    .end local v2    # "newView":Z
    .end local v3    # "view":Landroid/view/View;
    .end local v4    # "viewToAdd":I
    :cond_b
    array-length v8, p3

    move v6, v7

    :goto_3
    if-ge v6, v8, :cond_d

    aget v5, p3, v6

    .line 390
    .local v5, "viewToDetach":I
    invoke-interface {p1, v5}, Lcom/facebook/react/flat/ViewResolver;->getView(I)Landroid/view/View;

    move-result-object v3

    .line 391
    .restart local v3    # "view":Landroid/view/View;
    invoke-virtual {v3}, Landroid/view/View;->getParent()Landroid/view/ViewParent;

    move-result-object v7

    if-eqz v7, :cond_c

    .line 392
    new-instance v6, Ljava/lang/RuntimeException;

    const-string v7, "Trying to remove view not owned by FlatViewGroup"

    invoke-direct {v6, v7}, Ljava/lang/RuntimeException;-><init>(Ljava/lang/String;)V

    throw v6

    .line 394
    :cond_c
    iget-object v7, p0, Lcom/facebook/react/flat/ClippingDrawCommandManager;->mFlatViewGroup:Lcom/facebook/react/flat/FlatViewGroup;

    invoke-virtual {v7, v3}, Lcom/facebook/react/flat/FlatViewGroup;->removeDetachedView(Landroid/view/View;)V

    .line 397
    invoke-direct {p0, v5}, Lcom/facebook/react/flat/ClippingDrawCommandManager;->unclip(I)V

    .line 389
    add-int/lit8 v6, v6, 0x1

    goto :goto_3

    .line 399
    .end local v3    # "view":Landroid/view/View;
    .end local v5    # "viewToDetach":I
    :cond_d
    return-void
.end method

.method onClippedViewDropped(Landroid/view/View;)V
    .locals 1
    .param p1, "view"    # Landroid/view/View;

    .prologue
    .line 315
    invoke-virtual {p1}, Landroid/view/View;->getId()I

    move-result v0

    invoke-direct {p0, v0}, Lcom/facebook/react/flat/ClippingDrawCommandManager;->unclip(I)V

    .line 316
    iget-object v0, p0, Lcom/facebook/react/flat/ClippingDrawCommandManager;->mFlatViewGroup:Lcom/facebook/react/flat/FlatViewGroup;

    invoke-virtual {v0, p1}, Lcom/facebook/react/flat/FlatViewGroup;->removeDetachedView(Landroid/view/View;)V

    .line 317
    return-void
.end method

.method abstract regionAboveTouch(IFF)Z
.end method

.method abstract regionStopIndex(FF)I
.end method

.method public updateClippingRect()Z
    .locals 5

    .prologue
    const/4 v2, 0x0

    .line 418
    iget-object v3, p0, Lcom/facebook/react/flat/ClippingDrawCommandManager;->mFlatViewGroup:Lcom/facebook/react/flat/FlatViewGroup;

    iget-object v4, p0, Lcom/facebook/react/flat/ClippingDrawCommandManager;->mClippingRect:Landroid/graphics/Rect;

    invoke-static {v3, v4}, Lcom/facebook/react/uimanager/ReactClippingViewGroupHelper;->calculateClippingRect(Landroid/view/View;Landroid/graphics/Rect;)V

    .line 419
    iget-object v3, p0, Lcom/facebook/react/flat/ClippingDrawCommandManager;->mFlatViewGroup:Lcom/facebook/react/flat/FlatViewGroup;

    invoke-virtual {v3}, Lcom/facebook/react/flat/FlatViewGroup;->getParent()Landroid/view/ViewParent;

    move-result-object v3

    if-eqz v3, :cond_0

    iget-object v3, p0, Lcom/facebook/react/flat/ClippingDrawCommandManager;->mClippingRect:Landroid/graphics/Rect;

    iget v3, v3, Landroid/graphics/Rect;->top:I

    iget-object v4, p0, Lcom/facebook/react/flat/ClippingDrawCommandManager;->mClippingRect:Landroid/graphics/Rect;

    iget v4, v4, Landroid/graphics/Rect;->bottom:I

    if-ne v3, v4, :cond_1

    .line 439
    :cond_0
    :goto_0
    return v2

    .line 425
    :cond_1
    invoke-virtual {p0}, Lcom/facebook/react/flat/ClippingDrawCommandManager;->commandStartIndex()I

    move-result v0

    .line 426
    .local v0, "start":I
    invoke-virtual {p0, v0}, Lcom/facebook/react/flat/ClippingDrawCommandManager;->commandStopIndex(I)I

    move-result v1

    .line 427
    .local v1, "stop":I
    iget v3, p0, Lcom/facebook/react/flat/ClippingDrawCommandManager;->mStart:I

    if-gt v3, v0, :cond_2

    iget v3, p0, Lcom/facebook/react/flat/ClippingDrawCommandManager;->mStop:I

    if-gt v1, v3, :cond_2

    .line 430
    invoke-direct {p0}, Lcom/facebook/react/flat/ClippingDrawCommandManager;->updateClippingRecursively()V

    goto :goto_0

    .line 434
    :cond_2
    iput v0, p0, Lcom/facebook/react/flat/ClippingDrawCommandManager;->mStart:I

    .line 435
    iput v1, p0, Lcom/facebook/react/flat/ClippingDrawCommandManager;->mStop:I

    .line 437
    invoke-direct {p0}, Lcom/facebook/react/flat/ClippingDrawCommandManager;->updateClippingToCurrentRect()V

    .line 438
    invoke-direct {p0}, Lcom/facebook/react/flat/ClippingDrawCommandManager;->updateClippingRecursively()V

    .line 439
    const/4 v2, 0x1

    goto :goto_0
.end method

.method public virtualNodeRegionWithinBounds(FF)Lcom/facebook/react/flat/NodeRegion;
    .locals 4
    .param p1, "touchX"    # F
    .param p2, "touchY"    # F
    .annotation runtime Ljavax/annotation/Nullable;
    .end annotation

    .prologue
    .line 263
    invoke-virtual {p0, p1, p2}, Lcom/facebook/react/flat/ClippingDrawCommandManager;->regionStopIndex(FF)I

    move-result v0

    .local v0, "i":I
    move v1, v0

    .line 264
    .end local v0    # "i":I
    .local v1, "i":I
    :goto_0
    add-int/lit8 v0, v1, -0x1

    .end local v1    # "i":I
    .restart local v0    # "i":I
    if-lez v1, :cond_1

    .line 265
    iget-object v3, p0, Lcom/facebook/react/flat/ClippingDrawCommandManager;->mNodeRegions:[Lcom/facebook/react/flat/NodeRegion;

    aget-object v2, v3, v0

    .line 266
    .local v2, "nodeRegion":Lcom/facebook/react/flat/NodeRegion;
    iget-boolean v3, v2, Lcom/facebook/react/flat/NodeRegion;->mIsVirtual:Z

    if-nez v3, :cond_0

    move v1, v0

    .line 268
    .end local v0    # "i":I
    .restart local v1    # "i":I
    goto :goto_0

    .line 270
    .end local v1    # "i":I
    .restart local v0    # "i":I
    :cond_0
    invoke-virtual {p0, v0, p1, p2}, Lcom/facebook/react/flat/ClippingDrawCommandManager;->regionAboveTouch(IFF)Z

    move-result v3

    if-eqz v3, :cond_3

    .line 278
    .end local v2    # "nodeRegion":Lcom/facebook/react/flat/NodeRegion;
    :cond_1
    const/4 v2, 0x0

    :cond_2
    return-object v2

    .line 273
    .restart local v2    # "nodeRegion":Lcom/facebook/react/flat/NodeRegion;
    :cond_3
    invoke-virtual {v2, p1, p2}, Lcom/facebook/react/flat/NodeRegion;->withinBounds(FF)Z

    move-result v3

    if-nez v3, :cond_2

    move v1, v0

    .line 276
    .end local v0    # "i":I
    .restart local v1    # "i":I
    goto :goto_0
.end method

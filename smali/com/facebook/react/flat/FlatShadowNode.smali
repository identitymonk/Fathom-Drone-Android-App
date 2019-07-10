.class Lcom/facebook/react/flat/FlatShadowNode;
.super Lcom/facebook/react/uimanager/LayoutShadowNode;
.source "FlatShadowNode.java"


# static fields
.field static final EMPTY_ARRAY:[Lcom/facebook/react/flat/FlatShadowNode;

.field private static final EMPTY_DRAW_VIEW:Lcom/facebook/react/flat/DrawView;

.field private static final LOGICAL_OFFSET_EMPTY:Landroid/graphics/Rect;

.field private static final PROP_ACCESSIBILITY_COMPONENT_TYPE:Ljava/lang/String; = "accessibilityComponentType"

.field private static final PROP_ACCESSIBILITY_LABEL:Ljava/lang/String; = "accessibilityLabel"

.field private static final PROP_ACCESSIBILITY_LIVE_REGION:Ljava/lang/String; = "accessibilityLiveRegion"

.field protected static final PROP_HORIZONTAL:Ljava/lang/String; = "horizontal"

.field private static final PROP_IMPORTANT_FOR_ACCESSIBILITY:Ljava/lang/String; = "importantForAccessibility"

.field private static final PROP_OPACITY:Ljava/lang/String; = "opacity"

.field protected static final PROP_REMOVE_CLIPPED_SUBVIEWS:Ljava/lang/String; = "removeClippedSubviews"

.field private static final PROP_RENDER_TO_HARDWARE_TEXTURE:Ljava/lang/String; = "renderToHardwareTextureAndroid"

.field private static final PROP_TEST_ID:Ljava/lang/String; = "testID"

.field private static final PROP_TRANSFORM:Ljava/lang/String; = "transform"


# instance fields
.field private mAttachDetachListeners:[Lcom/facebook/react/flat/AttachDetachListener;

.field private mBackingViewIsCreated:Z

.field private mClipBottom:F

.field private mClipLeft:F

.field mClipRadius:F

.field private mClipRight:F

.field mClipToBounds:Z

.field private mClipTop:F

.field private mDrawBackground:Lcom/facebook/react/flat/DrawBackgroundColor;
    .annotation runtime Ljavax/annotation/Nullable;
    .end annotation
.end field

.field private mDrawCommands:[Lcom/facebook/react/flat/DrawCommand;

.field private mDrawView:Lcom/facebook/react/flat/DrawView;
    .annotation runtime Ljavax/annotation/Nullable;
    .end annotation
.end field

.field private mForceMountChildrenToView:Z

.field private mIsUpdated:Z

.field private mLayoutHeight:I

.field private mLayoutWidth:I

.field private mLayoutX:I

.field private mLayoutY:I

.field private mLogicalOffset:Landroid/graphics/Rect;

.field private mNativeChildren:[Lcom/facebook/react/flat/FlatShadowNode;

.field private mNativeParentTag:I

.field private mNodeRegion:Lcom/facebook/react/flat/NodeRegion;

.field private mNodeRegions:[Lcom/facebook/react/flat/NodeRegion;

.field private mOverflowsContainer:Z

.field private mViewBottom:I

.field private mViewLeft:I

.field private mViewRight:I

.field private mViewTop:I


# direct methods
.method static constructor <clinit>()V
    .locals 2

    .prologue
    const/4 v1, 0x0

    .line 30
    new-array v0, v1, [Lcom/facebook/react/flat/FlatShadowNode;

    sput-object v0, Lcom/facebook/react/flat/FlatShadowNode;->EMPTY_ARRAY:[Lcom/facebook/react/flat/FlatShadowNode;

    .line 43
    new-instance v0, Landroid/graphics/Rect;

    invoke-direct {v0}, Landroid/graphics/Rect;-><init>()V

    sput-object v0, Lcom/facebook/react/flat/FlatShadowNode;->LOGICAL_OFFSET_EMPTY:Landroid/graphics/Rect;

    .line 46
    new-instance v0, Lcom/facebook/react/flat/DrawView;

    invoke-direct {v0, v1}, Lcom/facebook/react/flat/DrawView;-><init>(I)V

    sput-object v0, Lcom/facebook/react/flat/FlatShadowNode;->EMPTY_DRAW_VIEW:Lcom/facebook/react/flat/DrawView;

    return-void
.end method

.method constructor <init>()V
    .locals 1

    .prologue
    .line 28
    invoke-direct {p0}, Lcom/facebook/react/uimanager/LayoutShadowNode;-><init>()V

    .line 48
    sget-object v0, Lcom/facebook/react/flat/DrawCommand;->EMPTY_ARRAY:[Lcom/facebook/react/flat/DrawCommand;

    iput-object v0, p0, Lcom/facebook/react/flat/FlatShadowNode;->mDrawCommands:[Lcom/facebook/react/flat/DrawCommand;

    .line 49
    sget-object v0, Lcom/facebook/react/flat/AttachDetachListener;->EMPTY_ARRAY:[Lcom/facebook/react/flat/AttachDetachListener;

    iput-object v0, p0, Lcom/facebook/react/flat/FlatShadowNode;->mAttachDetachListeners:[Lcom/facebook/react/flat/AttachDetachListener;

    .line 50
    sget-object v0, Lcom/facebook/react/flat/NodeRegion;->EMPTY_ARRAY:[Lcom/facebook/react/flat/NodeRegion;

    iput-object v0, p0, Lcom/facebook/react/flat/FlatShadowNode;->mNodeRegions:[Lcom/facebook/react/flat/NodeRegion;

    .line 51
    sget-object v0, Lcom/facebook/react/flat/FlatShadowNode;->EMPTY_ARRAY:[Lcom/facebook/react/flat/FlatShadowNode;

    iput-object v0, p0, Lcom/facebook/react/flat/FlatShadowNode;->mNativeChildren:[Lcom/facebook/react/flat/FlatShadowNode;

    .line 52
    sget-object v0, Lcom/facebook/react/flat/NodeRegion;->EMPTY:Lcom/facebook/react/flat/NodeRegion;

    iput-object v0, p0, Lcom/facebook/react/flat/FlatShadowNode;->mNodeRegion:Lcom/facebook/react/flat/NodeRegion;

    .line 61
    const/4 v0, 0x1

    iput-boolean v0, p0, Lcom/facebook/react/flat/FlatShadowNode;->mIsUpdated:Z

    .line 74
    sget-object v0, Lcom/facebook/react/flat/FlatShadowNode;->LOGICAL_OFFSET_EMPTY:Landroid/graphics/Rect;

    iput-object v0, p0, Lcom/facebook/react/flat/FlatShadowNode;->mLogicalOffset:Landroid/graphics/Rect;

    .line 84
    const/4 v0, 0x0

    iput-boolean v0, p0, Lcom/facebook/react/flat/FlatShadowNode;->mClipToBounds:Z

    return-void
.end method


# virtual methods
.method public bridge synthetic addChildAt(Lcom/facebook/react/uimanager/ReactShadowNode;I)V
    .locals 0

    .prologue
    .line 28
    check-cast p1, Lcom/facebook/react/uimanager/ReactShadowNodeImpl;

    invoke-virtual {p0, p1, p2}, Lcom/facebook/react/flat/FlatShadowNode;->addChildAt(Lcom/facebook/react/uimanager/ReactShadowNodeImpl;I)V

    return-void
.end method

.method public addChildAt(Lcom/facebook/react/uimanager/ReactShadowNodeImpl;I)V
    .locals 1
    .param p1, "child"    # Lcom/facebook/react/uimanager/ReactShadowNodeImpl;
    .param p2, "i"    # I

    .prologue
    .line 216
    invoke-super {p0, p1, p2}, Lcom/facebook/react/uimanager/LayoutShadowNode;->addChildAt(Lcom/facebook/react/uimanager/ReactShadowNodeImpl;I)V

    .line 217
    iget-boolean v0, p0, Lcom/facebook/react/flat/FlatShadowNode;->mForceMountChildrenToView:Z

    if-eqz v0, :cond_0

    instance-of v0, p1, Lcom/facebook/react/flat/FlatShadowNode;

    if-eqz v0, :cond_0

    .line 218
    check-cast p1, Lcom/facebook/react/flat/FlatShadowNode;

    .end local p1    # "child":Lcom/facebook/react/uimanager/ReactShadowNodeImpl;
    invoke-virtual {p1}, Lcom/facebook/react/flat/FlatShadowNode;->forceMountToView()V

    .line 220
    :cond_0
    return-void
.end method

.method final clipBoundsChanged(FFFF)Z
    .locals 1
    .param p1, "clipLeft"    # F
    .param p2, "clipTop"    # F
    .param p3, "clipRight"    # F
    .param p4, "clipBottom"    # F

    .prologue
    .line 270
    iget v0, p0, Lcom/facebook/react/flat/FlatShadowNode;->mClipLeft:F

    cmpl-float v0, v0, p1

    if-nez v0, :cond_0

    iget v0, p0, Lcom/facebook/react/flat/FlatShadowNode;->mClipTop:F

    cmpl-float v0, v0, p2

    if-nez v0, :cond_0

    iget v0, p0, Lcom/facebook/react/flat/FlatShadowNode;->mClipRight:F

    cmpl-float v0, v0, p3

    if-nez v0, :cond_0

    iget v0, p0, Lcom/facebook/react/flat/FlatShadowNode;->mClipBottom:F

    cmpl-float v0, v0, p4

    if-eqz v0, :cond_1

    :cond_0
    const/4 v0, 0x1

    :goto_0
    return v0

    :cond_1
    const/4 v0, 0x0

    goto :goto_0
.end method

.method public final clipToBounds()Z
    .locals 1

    .prologue
    .line 183
    iget-boolean v0, p0, Lcom/facebook/react/flat/FlatShadowNode;->mClipToBounds:Z

    return v0
.end method

.method public clipsSubviews()Z
    .locals 1

    .prologue
    .line 566
    const/4 v0, 0x0

    return v0
.end method

.method final collectDrawView(FFFFFFFF)Lcom/facebook/react/flat/DrawView;
    .locals 14
    .param p1, "left"    # F
    .param p2, "top"    # F
    .param p3, "right"    # F
    .param p4, "bottom"    # F
    .param p5, "clipLeft"    # F
    .param p6, "clipTop"    # F
    .param p7, "clipRight"    # F
    .param p8, "clipBottom"    # F

    .prologue
    .line 511
    iget-object v0, p0, Lcom/facebook/react/flat/FlatShadowNode;->mDrawView:Lcom/facebook/react/flat/DrawView;

    invoke-static {v0}, Lcom/facebook/infer/annotation/Assertions;->assumeNotNull(Ljava/lang/Object;)Ljava/lang/Object;

    .line 512
    iget-object v0, p0, Lcom/facebook/react/flat/FlatShadowNode;->mDrawView:Lcom/facebook/react/flat/DrawView;

    sget-object v1, Lcom/facebook/react/flat/FlatShadowNode;->EMPTY_DRAW_VIEW:Lcom/facebook/react/flat/DrawView;

    if-ne v0, v1, :cond_0

    .line 515
    new-instance v0, Lcom/facebook/react/flat/DrawView;

    invoke-virtual {p0}, Lcom/facebook/react/flat/FlatShadowNode;->getReactTag()I

    move-result v1

    invoke-direct {v0, v1}, Lcom/facebook/react/flat/DrawView;-><init>(I)V

    iput-object v0, p0, Lcom/facebook/react/flat/FlatShadowNode;->mDrawView:Lcom/facebook/react/flat/DrawView;

    .line 519
    :cond_0
    iget-boolean v0, p0, Lcom/facebook/react/flat/FlatShadowNode;->mClipToBounds:Z

    if-eqz v0, :cond_1

    iget v13, p0, Lcom/facebook/react/flat/FlatShadowNode;->mClipRadius:F

    .line 522
    .local v13, "clipRadius":F
    :goto_0
    iget-object v0, p0, Lcom/facebook/react/flat/FlatShadowNode;->mDrawView:Lcom/facebook/react/flat/DrawView;

    iget-object v1, p0, Lcom/facebook/react/flat/FlatShadowNode;->mLogicalOffset:Landroid/graphics/Rect;

    iget v1, v1, Landroid/graphics/Rect;->left:I

    int-to-float v1, v1

    add-float v5, p1, v1

    iget-object v1, p0, Lcom/facebook/react/flat/FlatShadowNode;->mLogicalOffset:Landroid/graphics/Rect;

    iget v1, v1, Landroid/graphics/Rect;->top:I

    int-to-float v1, v1

    add-float v6, p2, v1

    iget-object v1, p0, Lcom/facebook/react/flat/FlatShadowNode;->mLogicalOffset:Landroid/graphics/Rect;

    iget v1, v1, Landroid/graphics/Rect;->right:I

    int-to-float v1, v1

    add-float v7, p3, v1

    iget-object v1, p0, Lcom/facebook/react/flat/FlatShadowNode;->mLogicalOffset:Landroid/graphics/Rect;

    iget v1, v1, Landroid/graphics/Rect;->bottom:I

    int-to-float v1, v1

    add-float v8, p4, v1

    move v1, p1

    move/from16 v2, p2

    move/from16 v3, p3

    move/from16 v4, p4

    move/from16 v9, p5

    move/from16 v10, p6

    move/from16 v11, p7

    move/from16 v12, p8

    invoke-virtual/range {v0 .. v13}, Lcom/facebook/react/flat/DrawView;->collectDrawView(FFFFFFFFFFFFF)Lcom/facebook/react/flat/DrawView;

    move-result-object v0

    iput-object v0, p0, Lcom/facebook/react/flat/FlatShadowNode;->mDrawView:Lcom/facebook/react/flat/DrawView;

    .line 536
    iget-object v0, p0, Lcom/facebook/react/flat/FlatShadowNode;->mDrawView:Lcom/facebook/react/flat/DrawView;

    return-object v0

    .line 519
    .end local v13    # "clipRadius":F
    :cond_1
    const/4 v13, 0x0

    goto :goto_0
.end method

.method protected collectState(Lcom/facebook/react/flat/StateBuilder;FFFFFFFF)V
    .locals 9
    .param p1, "stateBuilder"    # Lcom/facebook/react/flat/StateBuilder;
    .param p2, "left"    # F
    .param p3, "top"    # F
    .param p4, "right"    # F
    .param p5, "bottom"    # F
    .param p6, "clipLeft"    # F
    .param p7, "clipTop"    # F
    .param p8, "clipRight"    # F
    .param p9, "clipBottom"    # F

    .prologue
    .line 130
    iget-object v0, p0, Lcom/facebook/react/flat/FlatShadowNode;->mDrawBackground:Lcom/facebook/react/flat/DrawBackgroundColor;

    if-eqz v0, :cond_0

    .line 131
    iget-object v0, p0, Lcom/facebook/react/flat/FlatShadowNode;->mDrawBackground:Lcom/facebook/react/flat/DrawBackgroundColor;

    move v1, p2

    move v2, p3

    move v3, p4

    move v4, p5

    move v5, p6

    move/from16 v6, p7

    move/from16 v7, p8

    move/from16 v8, p9

    invoke-virtual/range {v0 .. v8}, Lcom/facebook/react/flat/DrawBackgroundColor;->updateBoundsAndFreeze(FFFFFFFF)Lcom/facebook/react/flat/AbstractDrawCommand;

    move-result-object v0

    check-cast v0, Lcom/facebook/react/flat/DrawBackgroundColor;

    iput-object v0, p0, Lcom/facebook/react/flat/FlatShadowNode;->mDrawBackground:Lcom/facebook/react/flat/DrawBackgroundColor;

    .line 140
    iget-object v0, p0, Lcom/facebook/react/flat/FlatShadowNode;->mDrawBackground:Lcom/facebook/react/flat/DrawBackgroundColor;

    invoke-virtual {p1, v0}, Lcom/facebook/react/flat/StateBuilder;->addDrawCommand(Lcom/facebook/react/flat/AbstractDrawCommand;)V

    .line 142
    :cond_0
    return-void
.end method

.method doesDraw()Z
    .locals 1

    .prologue
    .line 156
    iget-object v0, p0, Lcom/facebook/react/flat/FlatShadowNode;->mDrawView:Lcom/facebook/react/flat/DrawView;

    if-nez v0, :cond_0

    iget-object v0, p0, Lcom/facebook/react/flat/FlatShadowNode;->mDrawBackground:Lcom/facebook/react/flat/DrawBackgroundColor;

    if-eqz v0, :cond_1

    :cond_0
    const/4 v0, 0x1

    :goto_0
    return v0

    :cond_1
    const/4 v0, 0x0

    goto :goto_0
.end method

.method final forceMountChildrenToView()V
    .locals 4

    .prologue
    .line 104
    iget-boolean v3, p0, Lcom/facebook/react/flat/FlatShadowNode;->mForceMountChildrenToView:Z

    if-eqz v3, :cond_1

    .line 115
    :cond_0
    return-void

    .line 108
    :cond_1
    const/4 v3, 0x1

    iput-boolean v3, p0, Lcom/facebook/react/flat/FlatShadowNode;->mForceMountChildrenToView:Z

    .line 109
    const/4 v2, 0x0

    .local v2, "i":I
    invoke-virtual {p0}, Lcom/facebook/react/flat/FlatShadowNode;->getChildCount()I

    move-result v1

    .local v1, "childCount":I
    :goto_0
    if-eq v2, v1, :cond_0

    .line 110
    invoke-virtual {p0, v2}, Lcom/facebook/react/flat/FlatShadowNode;->getChildAt(I)Lcom/facebook/react/uimanager/ReactShadowNodeImpl;

    move-result-object v0

    .line 111
    .local v0, "child":Lcom/facebook/react/uimanager/ReactShadowNode;
    instance-of v3, v0, Lcom/facebook/react/flat/FlatShadowNode;

    if-eqz v3, :cond_2

    .line 112
    check-cast v0, Lcom/facebook/react/flat/FlatShadowNode;

    .end local v0    # "child":Lcom/facebook/react/uimanager/ReactShadowNode;
    invoke-virtual {v0}, Lcom/facebook/react/flat/FlatShadowNode;->forceMountToView()V

    .line 109
    :cond_2
    add-int/lit8 v2, v2, 0x1

    goto :goto_0
.end method

.method final forceMountToView()V
    .locals 1

    .prologue
    .line 487
    invoke-virtual {p0}, Lcom/facebook/react/flat/FlatShadowNode;->isVirtual()Z

    move-result v0

    if-eqz v0, :cond_1

    .line 500
    :cond_0
    :goto_0
    return-void

    .line 491
    :cond_1
    iget-object v0, p0, Lcom/facebook/react/flat/FlatShadowNode;->mDrawView:Lcom/facebook/react/flat/DrawView;

    if-nez v0, :cond_0

    .line 494
    sget-object v0, Lcom/facebook/react/flat/FlatShadowNode;->EMPTY_DRAW_VIEW:Lcom/facebook/react/flat/DrawView;

    iput-object v0, p0, Lcom/facebook/react/flat/FlatShadowNode;->mDrawView:Lcom/facebook/react/flat/DrawView;

    .line 495
    invoke-virtual {p0}, Lcom/facebook/react/flat/FlatShadowNode;->invalidate()V

    .line 498
    sget-object v0, Lcom/facebook/react/flat/NodeRegion;->EMPTY:Lcom/facebook/react/flat/NodeRegion;

    iput-object v0, p0, Lcom/facebook/react/flat/FlatShadowNode;->mNodeRegion:Lcom/facebook/react/flat/NodeRegion;

    goto :goto_0
.end method

.method final getAttachDetachListeners()[Lcom/facebook/react/flat/AttachDetachListener;
    .locals 1

    .prologue
    .line 312
    iget-object v0, p0, Lcom/facebook/react/flat/FlatShadowNode;->mAttachDetachListeners:[Lcom/facebook/react/flat/AttachDetachListener;

    return-object v0
.end method

.method final getDrawCommands()[Lcom/facebook/react/flat/DrawCommand;
    .locals 1

    .prologue
    .line 289
    iget-object v0, p0, Lcom/facebook/react/flat/FlatShadowNode;->mDrawCommands:[Lcom/facebook/react/flat/DrawCommand;

    return-object v0
.end method

.method final getNativeChildren()[Lcom/facebook/react/flat/FlatShadowNode;
    .locals 1

    .prologue
    .line 316
    iget-object v0, p0, Lcom/facebook/react/flat/FlatShadowNode;->mNativeChildren:[Lcom/facebook/react/flat/FlatShadowNode;

    return-object v0
.end method

.method final getNativeParentTag()I
    .locals 1

    .prologue
    .line 324
    iget v0, p0, Lcom/facebook/react/flat/FlatShadowNode;->mNativeParentTag:I

    return v0
.end method

.method final getNodeRegion()Lcom/facebook/react/flat/NodeRegion;
    .locals 1

    .prologue
    .line 445
    iget-object v0, p0, Lcom/facebook/react/flat/FlatShadowNode;->mNodeRegion:Lcom/facebook/react/flat/NodeRegion;

    return-object v0
.end method

.method final getNodeRegions()[Lcom/facebook/react/flat/NodeRegion;
    .locals 1

    .prologue
    .line 332
    iget-object v0, p0, Lcom/facebook/react/flat/FlatShadowNode;->mNodeRegions:[Lcom/facebook/react/flat/NodeRegion;

    return-object v0
.end method

.method public final getScreenHeight()I
    .locals 2

    .prologue
    .line 207
    invoke-virtual {p0}, Lcom/facebook/react/flat/FlatShadowNode;->mountsToView()Z

    move-result v0

    if-eqz v0, :cond_0

    .line 208
    iget v0, p0, Lcom/facebook/react/flat/FlatShadowNode;->mViewBottom:I

    iget v1, p0, Lcom/facebook/react/flat/FlatShadowNode;->mViewTop:I

    sub-int/2addr v0, v1

    .line 210
    :goto_0
    return v0

    :cond_0
    iget-object v0, p0, Lcom/facebook/react/flat/FlatShadowNode;->mNodeRegion:Lcom/facebook/react/flat/NodeRegion;

    invoke-virtual {v0}, Lcom/facebook/react/flat/NodeRegion;->getBottom()F

    move-result v0

    iget-object v1, p0, Lcom/facebook/react/flat/FlatShadowNode;->mNodeRegion:Lcom/facebook/react/flat/NodeRegion;

    invoke-virtual {v1}, Lcom/facebook/react/flat/NodeRegion;->getTop()F

    move-result v1

    sub-float/2addr v0, v1

    invoke-static {v0}, Ljava/lang/Math;->round(F)I

    move-result v0

    goto :goto_0
.end method

.method public final getScreenWidth()I
    .locals 2

    .prologue
    .line 198
    invoke-virtual {p0}, Lcom/facebook/react/flat/FlatShadowNode;->mountsToView()Z

    move-result v0

    if-eqz v0, :cond_0

    .line 199
    iget v0, p0, Lcom/facebook/react/flat/FlatShadowNode;->mViewRight:I

    iget v1, p0, Lcom/facebook/react/flat/FlatShadowNode;->mViewLeft:I

    sub-int/2addr v0, v1

    .line 201
    :goto_0
    return v0

    :cond_0
    iget-object v0, p0, Lcom/facebook/react/flat/FlatShadowNode;->mNodeRegion:Lcom/facebook/react/flat/NodeRegion;

    invoke-virtual {v0}, Lcom/facebook/react/flat/NodeRegion;->getRight()F

    move-result v0

    iget-object v1, p0, Lcom/facebook/react/flat/FlatShadowNode;->mNodeRegion:Lcom/facebook/react/flat/NodeRegion;

    invoke-virtual {v1}, Lcom/facebook/react/flat/NodeRegion;->getLeft()F

    move-result v1

    sub-float/2addr v0, v1

    invoke-static {v0}, Ljava/lang/Math;->round(F)I

    move-result v0

    goto :goto_0
.end method

.method public final getScreenX()I
    .locals 1

    .prologue
    .line 188
    iget v0, p0, Lcom/facebook/react/flat/FlatShadowNode;->mViewLeft:I

    return v0
.end method

.method public final getScreenY()I
    .locals 1

    .prologue
    .line 193
    iget v0, p0, Lcom/facebook/react/flat/FlatShadowNode;->mViewTop:I

    return v0
.end method

.method final getViewBottom()I
    .locals 1

    .prologue
    .line 483
    iget v0, p0, Lcom/facebook/react/flat/FlatShadowNode;->mViewBottom:I

    return v0
.end method

.method final getViewLeft()I
    .locals 1

    .prologue
    .line 462
    iget v0, p0, Lcom/facebook/react/flat/FlatShadowNode;->mViewLeft:I

    return v0
.end method

.method final getViewRight()I
    .locals 1

    .prologue
    .line 476
    iget v0, p0, Lcom/facebook/react/flat/FlatShadowNode;->mViewRight:I

    return v0
.end method

.method final getViewTop()I
    .locals 1

    .prologue
    .line 469
    iget v0, p0, Lcom/facebook/react/flat/FlatShadowNode;->mViewTop:I

    return v0
.end method

.method handleUpdateProperties(Lcom/facebook/react/uimanager/ReactStylesDiffMap;)V
    .locals 1
    .param p1, "styles"    # Lcom/facebook/react/uimanager/ReactStylesDiffMap;

    .prologue
    .line 87
    invoke-virtual {p0}, Lcom/facebook/react/flat/FlatShadowNode;->mountsToView()Z

    move-result v0

    if-nez v0, :cond_1

    .line 89
    const-string v0, "opacity"

    invoke-virtual {p1, v0}, Lcom/facebook/react/uimanager/ReactStylesDiffMap;->hasKey(Ljava/lang/String;)Z

    move-result v0

    if-nez v0, :cond_0

    const-string v0, "renderToHardwareTextureAndroid"

    .line 90
    invoke-virtual {p1, v0}, Lcom/facebook/react/uimanager/ReactStylesDiffMap;->hasKey(Ljava/lang/String;)Z

    move-result v0

    if-nez v0, :cond_0

    const-string v0, "testID"

    .line 91
    invoke-virtual {p1, v0}, Lcom/facebook/react/uimanager/ReactStylesDiffMap;->hasKey(Ljava/lang/String;)Z

    move-result v0

    if-nez v0, :cond_0

    const-string v0, "accessibilityLabel"

    .line 92
    invoke-virtual {p1, v0}, Lcom/facebook/react/uimanager/ReactStylesDiffMap;->hasKey(Ljava/lang/String;)Z

    move-result v0

    if-nez v0, :cond_0

    const-string v0, "accessibilityComponentType"

    .line 93
    invoke-virtual {p1, v0}, Lcom/facebook/react/uimanager/ReactStylesDiffMap;->hasKey(Ljava/lang/String;)Z

    move-result v0

    if-nez v0, :cond_0

    const-string v0, "accessibilityLiveRegion"

    .line 94
    invoke-virtual {p1, v0}, Lcom/facebook/react/uimanager/ReactStylesDiffMap;->hasKey(Ljava/lang/String;)Z

    move-result v0

    if-nez v0, :cond_0

    const-string v0, "transform"

    .line 95
    invoke-virtual {p1, v0}, Lcom/facebook/react/uimanager/ReactStylesDiffMap;->hasKey(Ljava/lang/String;)Z

    move-result v0

    if-nez v0, :cond_0

    const-string v0, "importantForAccessibility"

    .line 96
    invoke-virtual {p1, v0}, Lcom/facebook/react/uimanager/ReactStylesDiffMap;->hasKey(Ljava/lang/String;)Z

    move-result v0

    if-nez v0, :cond_0

    const-string v0, "removeClippedSubviews"

    .line 97
    invoke-virtual {p1, v0}, Lcom/facebook/react/uimanager/ReactStylesDiffMap;->hasKey(Ljava/lang/String;)Z

    move-result v0

    if-eqz v0, :cond_1

    .line 98
    :cond_0
    invoke-virtual {p0}, Lcom/facebook/react/flat/FlatShadowNode;->forceMountToView()V

    .line 101
    :cond_1
    return-void
.end method

.method protected final invalidate()V
    .locals 3

    .prologue
    .line 228
    move-object v0, p0

    .line 231
    .local v0, "node":Lcom/facebook/react/flat/FlatShadowNode;
    :goto_0
    invoke-virtual {v0}, Lcom/facebook/react/flat/FlatShadowNode;->mountsToView()Z

    move-result v2

    if-eqz v2, :cond_2

    .line 232
    iget-boolean v2, v0, Lcom/facebook/react/flat/FlatShadowNode;->mIsUpdated:Z

    if-eqz v2, :cond_1

    .line 243
    :cond_0
    return-void

    .line 237
    :cond_1
    const/4 v2, 0x1

    iput-boolean v2, v0, Lcom/facebook/react/flat/FlatShadowNode;->mIsUpdated:Z

    .line 240
    :cond_2
    invoke-virtual {v0}, Lcom/facebook/react/flat/FlatShadowNode;->getParent()Lcom/facebook/react/uimanager/ReactShadowNodeImpl;

    move-result-object v1

    .line 241
    .local v1, "parent":Lcom/facebook/react/uimanager/ReactShadowNode;
    if-eqz v1, :cond_0

    move-object v0, v1

    .line 246
    check-cast v0, Lcom/facebook/react/flat/FlatShadowNode;

    .line 247
    goto :goto_0
.end method

.method final isBackingViewCreated()Z
    .locals 1

    .prologue
    .line 558
    iget-boolean v0, p0, Lcom/facebook/react/flat/FlatShadowNode;->mBackingViewIsCreated:Z

    return v0
.end method

.method public isHorizontal()Z
    .locals 1

    .prologue
    .line 570
    const/4 v0, 0x0

    return v0
.end method

.method final isUpdated()Z
    .locals 1

    .prologue
    .line 258
    iget-boolean v0, p0, Lcom/facebook/react/flat/FlatShadowNode;->mIsUpdated:Z

    return v0
.end method

.method public markUpdated()V
    .locals 1

    .prologue
    .line 252
    invoke-super {p0}, Lcom/facebook/react/uimanager/LayoutShadowNode;->markUpdated()V

    .line 253
    const/4 v0, 0x1

    iput-boolean v0, p0, Lcom/facebook/react/flat/FlatShadowNode;->mIsUpdated:Z

    .line 254
    invoke-virtual {p0}, Lcom/facebook/react/flat/FlatShadowNode;->invalidate()V

    .line 255
    return-void
.end method

.method final mountsToView()Z
    .locals 1

    .prologue
    .line 554
    iget-object v0, p0, Lcom/facebook/react/flat/FlatShadowNode;->mDrawView:Lcom/facebook/react/flat/DrawView;

    if-eqz v0, :cond_0

    const/4 v0, 0x1

    :goto_0
    return v0

    :cond_0
    const/4 v0, 0x0

    goto :goto_0
.end method

.method final obtainLayoutEvent(IIII)Lcom/facebook/react/uimanager/OnLayoutEvent;
    .locals 1
    .param p1, "x"    # I
    .param p2, "y"    # I
    .param p3, "width"    # I
    .param p4, "height"    # I
    .annotation runtime Ljavax/annotation/Nullable;
    .end annotation

    .prologue
    .line 541
    iget v0, p0, Lcom/facebook/react/flat/FlatShadowNode;->mLayoutX:I

    if-ne v0, p1, :cond_0

    iget v0, p0, Lcom/facebook/react/flat/FlatShadowNode;->mLayoutY:I

    if-ne v0, p2, :cond_0

    iget v0, p0, Lcom/facebook/react/flat/FlatShadowNode;->mLayoutWidth:I

    if-ne v0, p3, :cond_0

    iget v0, p0, Lcom/facebook/react/flat/FlatShadowNode;->mLayoutHeight:I

    if-ne v0, p4, :cond_0

    .line 542
    const/4 v0, 0x0

    .line 550
    :goto_0
    return-object v0

    .line 545
    :cond_0
    iput p1, p0, Lcom/facebook/react/flat/FlatShadowNode;->mLayoutX:I

    .line 546
    iput p2, p0, Lcom/facebook/react/flat/FlatShadowNode;->mLayoutY:I

    .line 547
    iput p3, p0, Lcom/facebook/react/flat/FlatShadowNode;->mLayoutWidth:I

    .line 548
    iput p4, p0, Lcom/facebook/react/flat/FlatShadowNode;->mLayoutHeight:I

    .line 550
    invoke-virtual {p0}, Lcom/facebook/react/flat/FlatShadowNode;->getReactTag()I

    move-result v0

    invoke-static {v0, p1, p2, p3, p4}, Lcom/facebook/react/uimanager/OnLayoutEvent;->obtain(IIIII)Lcom/facebook/react/uimanager/OnLayoutEvent;

    move-result-object v0

    goto :goto_0
.end method

.method final resetUpdated()V
    .locals 1

    .prologue
    .line 262
    const/4 v0, 0x0

    iput-boolean v0, p0, Lcom/facebook/react/flat/FlatShadowNode;->mIsUpdated:Z

    .line 263
    return-void
.end method

.method final setAttachDetachListeners([Lcom/facebook/react/flat/AttachDetachListener;)V
    .locals 0
    .param p1, "listeners"    # [Lcom/facebook/react/flat/AttachDetachListener;

    .prologue
    .line 305
    iput-object p1, p0, Lcom/facebook/react/flat/FlatShadowNode;->mAttachDetachListeners:[Lcom/facebook/react/flat/AttachDetachListener;

    .line 306
    return-void
.end method

.method public setBackgroundColor(I)V
    .locals 1
    .param p1, "backgroundColor"    # I
    .annotation runtime Lcom/facebook/react/uimanager/annotations/ReactProp;
        name = "backgroundColor"
    .end annotation

    .prologue
    .line 161
    if-nez p1, :cond_0

    const/4 v0, 0x0

    :goto_0
    iput-object v0, p0, Lcom/facebook/react/flat/FlatShadowNode;->mDrawBackground:Lcom/facebook/react/flat/DrawBackgroundColor;

    .line 162
    invoke-virtual {p0}, Lcom/facebook/react/flat/FlatShadowNode;->invalidate()V

    .line 163
    return-void

    .line 161
    :cond_0
    new-instance v0, Lcom/facebook/react/flat/DrawBackgroundColor;

    invoke-direct {v0, p1}, Lcom/facebook/react/flat/DrawBackgroundColor;-><init>(I)V

    goto :goto_0
.end method

.method final setClipBounds(FFFF)V
    .locals 0
    .param p1, "clipLeft"    # F
    .param p2, "clipTop"    # F
    .param p3, "clipRight"    # F
    .param p4, "clipBottom"    # F

    .prologue
    .line 279
    iput p1, p0, Lcom/facebook/react/flat/FlatShadowNode;->mClipLeft:F

    .line 280
    iput p2, p0, Lcom/facebook/react/flat/FlatShadowNode;->mClipTop:F

    .line 281
    iput p3, p0, Lcom/facebook/react/flat/FlatShadowNode;->mClipRight:F

    .line 282
    iput p4, p0, Lcom/facebook/react/flat/FlatShadowNode;->mClipBottom:F

    .line 283
    return-void
.end method

.method final setDrawCommands([Lcom/facebook/react/flat/DrawCommand;)V
    .locals 0
    .param p1, "drawCommands"    # [Lcom/facebook/react/flat/DrawCommand;

    .prologue
    .line 297
    iput-object p1, p0, Lcom/facebook/react/flat/FlatShadowNode;->mDrawCommands:[Lcom/facebook/react/flat/DrawCommand;

    .line 298
    return-void
.end method

.method final setNativeChildren([Lcom/facebook/react/flat/FlatShadowNode;)V
    .locals 0
    .param p1, "nativeChildren"    # [Lcom/facebook/react/flat/FlatShadowNode;

    .prologue
    .line 320
    iput-object p1, p0, Lcom/facebook/react/flat/FlatShadowNode;->mNativeChildren:[Lcom/facebook/react/flat/FlatShadowNode;

    .line 321
    return-void
.end method

.method final setNativeParentTag(I)V
    .locals 0
    .param p1, "nativeParentTag"    # I

    .prologue
    .line 328
    iput p1, p0, Lcom/facebook/react/flat/FlatShadowNode;->mNativeParentTag:I

    .line 329
    return-void
.end method

.method protected final setNodeRegion(Lcom/facebook/react/flat/NodeRegion;)V
    .locals 0
    .param p1, "nodeRegion"    # Lcom/facebook/react/flat/NodeRegion;

    .prologue
    .line 440
    iput-object p1, p0, Lcom/facebook/react/flat/FlatShadowNode;->mNodeRegion:Lcom/facebook/react/flat/NodeRegion;

    .line 441
    invoke-virtual {p0}, Lcom/facebook/react/flat/FlatShadowNode;->updateOverflowsContainer()V

    .line 442
    return-void
.end method

.method final setNodeRegions([Lcom/facebook/react/flat/NodeRegion;)V
    .locals 0
    .param p1, "nodeRegion"    # [Lcom/facebook/react/flat/NodeRegion;

    .prologue
    .line 336
    iput-object p1, p0, Lcom/facebook/react/flat/FlatShadowNode;->mNodeRegions:[Lcom/facebook/react/flat/NodeRegion;

    .line 337
    invoke-virtual {p0}, Lcom/facebook/react/flat/FlatShadowNode;->updateOverflowsContainer()V

    .line 338
    return-void
.end method

.method public setOverflow(Ljava/lang/String;)V
    .locals 2
    .param p1, "overflow"    # Ljava/lang/String;

    .prologue
    .line 167
    invoke-super {p0, p1}, Lcom/facebook/react/uimanager/LayoutShadowNode;->setOverflow(Ljava/lang/String;)V

    .line 168
    const-string v0, "hidden"

    invoke-virtual {v0, p1}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v0

    iput-boolean v0, p0, Lcom/facebook/react/flat/FlatShadowNode;->mClipToBounds:Z

    .line 169
    iget-boolean v0, p0, Lcom/facebook/react/flat/FlatShadowNode;->mClipToBounds:Z

    if-eqz v0, :cond_1

    .line 170
    const/4 v0, 0x0

    iput-boolean v0, p0, Lcom/facebook/react/flat/FlatShadowNode;->mOverflowsContainer:Z

    .line 171
    iget v0, p0, Lcom/facebook/react/flat/FlatShadowNode;->mClipRadius:F

    const/high16 v1, 0x3f000000    # 0.5f

    cmpl-float v0, v0, v1

    if-lez v0, :cond_0

    .line 174
    invoke-virtual {p0}, Lcom/facebook/react/flat/FlatShadowNode;->forceMountToView()V

    .line 179
    :cond_0
    :goto_0
    invoke-virtual {p0}, Lcom/facebook/react/flat/FlatShadowNode;->invalidate()V

    .line 180
    return-void

    .line 177
    :cond_1
    invoke-virtual {p0}, Lcom/facebook/react/flat/FlatShadowNode;->updateOverflowsContainer()V

    goto :goto_0
.end method

.method final setViewBounds(IIII)V
    .locals 0
    .param p1, "left"    # I
    .param p2, "top"    # I
    .param p3, "right"    # I
    .param p4, "bottom"    # I

    .prologue
    .line 452
    iput p1, p0, Lcom/facebook/react/flat/FlatShadowNode;->mViewLeft:I

    .line 453
    iput p2, p0, Lcom/facebook/react/flat/FlatShadowNode;->mViewTop:I

    .line 454
    iput p3, p0, Lcom/facebook/react/flat/FlatShadowNode;->mViewRight:I

    .line 455
    iput p4, p0, Lcom/facebook/react/flat/FlatShadowNode;->mViewBottom:I

    .line 456
    return-void
.end method

.method final signalBackingViewIsCreated()V
    .locals 1

    .prologue
    .line 562
    const/4 v0, 0x1

    iput-boolean v0, p0, Lcom/facebook/react/flat/FlatShadowNode;->mBackingViewIsCreated:Z

    .line 563
    return-void
.end method

.method updateNodeRegion(FFFFZ)V
    .locals 7
    .param p1, "left"    # F
    .param p2, "top"    # F
    .param p3, "right"    # F
    .param p4, "bottom"    # F
    .param p5, "isVirtual"    # Z

    .prologue
    .line 434
    iget-object v0, p0, Lcom/facebook/react/flat/FlatShadowNode;->mNodeRegion:Lcom/facebook/react/flat/NodeRegion;

    move v1, p1

    move v2, p2

    move v3, p3

    move v4, p4

    move v5, p5

    invoke-virtual/range {v0 .. v5}, Lcom/facebook/react/flat/NodeRegion;->matches(FFFFZ)Z

    move-result v0

    if-nez v0, :cond_0

    .line 435
    new-instance v0, Lcom/facebook/react/flat/NodeRegion;

    invoke-virtual {p0}, Lcom/facebook/react/flat/FlatShadowNode;->getReactTag()I

    move-result v5

    move v1, p1

    move v2, p2

    move v3, p3

    move v4, p4

    move v6, p5

    invoke-direct/range {v0 .. v6}, Lcom/facebook/react/flat/NodeRegion;-><init>(FFFFIZ)V

    invoke-virtual {p0, v0}, Lcom/facebook/react/flat/FlatShadowNode;->setNodeRegion(Lcom/facebook/react/flat/NodeRegion;)V

    .line 437
    :cond_0
    return-void
.end method

.method final updateOverflowsContainer()V
    .locals 21

    .prologue
    .line 341
    const/4 v12, 0x0

    .line 342
    .local v12, "overflowsContainer":Z
    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/facebook/react/flat/FlatShadowNode;->mNodeRegion:Lcom/facebook/react/flat/NodeRegion;

    move-object/from16 v17, v0

    invoke-virtual/range {v17 .. v17}, Lcom/facebook/react/flat/NodeRegion;->getRight()F

    move-result v17

    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/facebook/react/flat/FlatShadowNode;->mNodeRegion:Lcom/facebook/react/flat/NodeRegion;

    move-object/from16 v18, v0

    invoke-virtual/range {v18 .. v18}, Lcom/facebook/react/flat/NodeRegion;->getLeft()F

    move-result v18

    sub-float v17, v17, v18

    move/from16 v0, v17

    float-to-int v0, v0

    move/from16 v16, v0

    .line 343
    .local v16, "width":I
    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/facebook/react/flat/FlatShadowNode;->mNodeRegion:Lcom/facebook/react/flat/NodeRegion;

    move-object/from16 v17, v0

    invoke-virtual/range {v17 .. v17}, Lcom/facebook/react/flat/NodeRegion;->getBottom()F

    move-result v17

    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/facebook/react/flat/FlatShadowNode;->mNodeRegion:Lcom/facebook/react/flat/NodeRegion;

    move-object/from16 v18, v0

    invoke-virtual/range {v18 .. v18}, Lcom/facebook/react/flat/NodeRegion;->getTop()F

    move-result v18

    sub-float v17, v17, v18

    move/from16 v0, v17

    float-to-int v7, v0

    .line 345
    .local v7, "height":I
    const/4 v9, 0x0

    .line 346
    .local v9, "leftBound":F
    move/from16 v0, v16

    int-to-float v14, v0

    .line 347
    .local v14, "rightBound":F
    const/4 v15, 0x0

    .line 348
    .local v15, "topBound":F
    int-to-float v4, v7

    .line 349
    .local v4, "bottomBound":F
    const/4 v10, 0x0

    .line 357
    .local v10, "logicalOffset":Landroid/graphics/Rect;
    move-object/from16 v0, p0

    iget-boolean v0, v0, Lcom/facebook/react/flat/FlatShadowNode;->mClipToBounds:Z

    move/from16 v17, v0

    if-nez v17, :cond_5

    if-lez v7, :cond_5

    if-lez v16, :cond_5

    .line 358
    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/facebook/react/flat/FlatShadowNode;->mNodeRegions:[Lcom/facebook/react/flat/NodeRegion;

    move-object/from16 v18, v0

    move-object/from16 v0, v18

    array-length v0, v0

    move/from16 v19, v0

    const/16 v17, 0x0

    :goto_0
    move/from16 v0, v17

    move/from16 v1, v19

    if-ge v0, v1, :cond_4

    aget-object v13, v18, v17

    .line 359
    .local v13, "region":Lcom/facebook/react/flat/NodeRegion;
    invoke-virtual {v13}, Lcom/facebook/react/flat/NodeRegion;->getLeft()F

    move-result v20

    cmpg-float v20, v20, v9

    if-gez v20, :cond_0

    .line 360
    invoke-virtual {v13}, Lcom/facebook/react/flat/NodeRegion;->getLeft()F

    move-result v9

    .line 361
    const/4 v12, 0x1

    .line 364
    :cond_0
    invoke-virtual {v13}, Lcom/facebook/react/flat/NodeRegion;->getRight()F

    move-result v20

    cmpl-float v20, v20, v14

    if-lez v20, :cond_1

    .line 365
    invoke-virtual {v13}, Lcom/facebook/react/flat/NodeRegion;->getRight()F

    move-result v14

    .line 366
    const/4 v12, 0x1

    .line 369
    :cond_1
    invoke-virtual {v13}, Lcom/facebook/react/flat/NodeRegion;->getTop()F

    move-result v20

    cmpg-float v20, v20, v15

    if-gez v20, :cond_2

    .line 370
    invoke-virtual {v13}, Lcom/facebook/react/flat/NodeRegion;->getTop()F

    move-result v15

    .line 371
    const/4 v12, 0x1

    .line 374
    :cond_2
    invoke-virtual {v13}, Lcom/facebook/react/flat/NodeRegion;->getBottom()F

    move-result v20

    cmpl-float v20, v20, v4

    if-lez v20, :cond_3

    .line 375
    invoke-virtual {v13}, Lcom/facebook/react/flat/NodeRegion;->getBottom()F

    move-result v4

    .line 376
    const/4 v12, 0x1

    .line 358
    :cond_3
    add-int/lit8 v17, v17, 0x1

    goto :goto_0

    .line 380
    .end local v13    # "region":Lcom/facebook/react/flat/NodeRegion;
    :cond_4
    if-eqz v12, :cond_5

    .line 381
    new-instance v10, Landroid/graphics/Rect;

    .end local v10    # "logicalOffset":Landroid/graphics/Rect;
    float-to-int v0, v9

    move/from16 v17, v0

    float-to-int v0, v15

    move/from16 v18, v0

    move/from16 v0, v16

    int-to-float v0, v0

    move/from16 v19, v0

    sub-float v19, v14, v19

    move/from16 v0, v19

    float-to-int v0, v0

    move/from16 v19, v0

    int-to-float v0, v7

    move/from16 v20, v0

    sub-float v20, v4, v20

    move/from16 v0, v20

    float-to-int v0, v0

    move/from16 v20, v0

    move/from16 v0, v17

    move/from16 v1, v18

    move/from16 v2, v19

    move/from16 v3, v20

    invoke-direct {v10, v0, v1, v2, v3}, Landroid/graphics/Rect;-><init>(IIII)V

    .line 396
    .restart local v10    # "logicalOffset":Landroid/graphics/Rect;
    :cond_5
    if-nez v12, :cond_8

    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/facebook/react/flat/FlatShadowNode;->mNodeRegion:Lcom/facebook/react/flat/NodeRegion;

    move-object/from16 v17, v0

    sget-object v18, Lcom/facebook/react/flat/NodeRegion;->EMPTY:Lcom/facebook/react/flat/NodeRegion;

    move-object/from16 v0, v17

    move-object/from16 v1, v18

    if-eq v0, v1, :cond_8

    .line 397
    invoke-virtual/range {p0 .. p0}, Lcom/facebook/react/flat/FlatShadowNode;->getChildCount()I

    move-result v6

    .line 398
    .local v6, "children":I
    const/4 v8, 0x0

    .local v8, "i":I
    :goto_1
    if-ge v8, v6, :cond_8

    .line 399
    move-object/from16 v0, p0

    invoke-virtual {v0, v8}, Lcom/facebook/react/flat/FlatShadowNode;->getChildAt(I)Lcom/facebook/react/uimanager/ReactShadowNodeImpl;

    move-result-object v11

    .line 400
    .local v11, "node":Lcom/facebook/react/uimanager/ReactShadowNode;
    instance-of v0, v11, Lcom/facebook/react/flat/FlatShadowNode;

    move/from16 v17, v0

    if-eqz v17, :cond_7

    move-object/from16 v17, v11

    check-cast v17, Lcom/facebook/react/flat/FlatShadowNode;

    move-object/from16 v0, v17

    iget-boolean v0, v0, Lcom/facebook/react/flat/FlatShadowNode;->mOverflowsContainer:Z

    move/from16 v17, v0

    if-eqz v17, :cond_7

    .line 401
    check-cast v11, Lcom/facebook/react/flat/FlatShadowNode;

    .end local v11    # "node":Lcom/facebook/react/uimanager/ReactShadowNode;
    iget-object v5, v11, Lcom/facebook/react/flat/FlatShadowNode;->mLogicalOffset:Landroid/graphics/Rect;

    .line 402
    .local v5, "childLogicalOffset":Landroid/graphics/Rect;
    if-nez v10, :cond_6

    .line 403
    new-instance v10, Landroid/graphics/Rect;

    .end local v10    # "logicalOffset":Landroid/graphics/Rect;
    invoke-direct {v10}, Landroid/graphics/Rect;-><init>()V

    .line 412
    .restart local v10    # "logicalOffset":Landroid/graphics/Rect;
    :cond_6
    invoke-virtual {v10, v5}, Landroid/graphics/Rect;->union(Landroid/graphics/Rect;)V

    .line 413
    const/4 v12, 0x1

    .line 398
    .end local v5    # "childLogicalOffset":Landroid/graphics/Rect;
    :cond_7
    add-int/lit8 v8, v8, 0x1

    goto :goto_1

    .line 422
    .end local v6    # "children":I
    .end local v8    # "i":I
    :cond_8
    move-object/from16 v0, p0

    iget-boolean v0, v0, Lcom/facebook/react/flat/FlatShadowNode;->mOverflowsContainer:Z

    move/from16 v17, v0

    move/from16 v0, v17

    if-eq v0, v12, :cond_a

    .line 423
    move-object/from16 v0, p0

    iput-boolean v12, v0, Lcom/facebook/react/flat/FlatShadowNode;->mOverflowsContainer:Z

    .line 424
    if-nez v10, :cond_9

    sget-object v10, Lcom/facebook/react/flat/FlatShadowNode;->LOGICAL_OFFSET_EMPTY:Landroid/graphics/Rect;

    .end local v10    # "logicalOffset":Landroid/graphics/Rect;
    :cond_9
    move-object/from16 v0, p0

    iput-object v10, v0, Lcom/facebook/react/flat/FlatShadowNode;->mLogicalOffset:Landroid/graphics/Rect;

    .line 426
    :cond_a
    return-void
.end method

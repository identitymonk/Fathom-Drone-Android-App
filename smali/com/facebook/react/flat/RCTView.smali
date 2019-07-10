.class final Lcom/facebook/react/flat/RCTView;
.super Lcom/facebook/react/flat/FlatShadowNode;
.source "RCTView.java"


# static fields
.field private static final SPACING_TYPES:[I


# instance fields
.field private mDrawBorder:Lcom/facebook/react/flat/DrawBorder;
    .annotation runtime Ljavax/annotation/Nullable;
    .end annotation
.end field

.field private mHitSlop:Landroid/graphics/Rect;
    .annotation runtime Ljavax/annotation/Nullable;
    .end annotation
.end field

.field mHorizontal:Z

.field mRemoveClippedSubviews:Z


# direct methods
.method static constructor <clinit>()V
    .locals 1

    .prologue
    .line 27
    const/4 v0, 0x5

    new-array v0, v0, [I

    fill-array-data v0, :array_0

    sput-object v0, Lcom/facebook/react/flat/RCTView;->SPACING_TYPES:[I

    return-void

    nop

    :array_0
    .array-data 4
        0x8
        0x0
        0x2
        0x1
        0x3
    .end array-data
.end method

.method constructor <init>()V
    .locals 0

    .prologue
    .line 26
    invoke-direct {p0}, Lcom/facebook/react/flat/FlatShadowNode;-><init>()V

    return-void
.end method

.method private getMutableBorder()Lcom/facebook/react/flat/DrawBorder;
    .locals 1

    .prologue
    .line 174
    iget-object v0, p0, Lcom/facebook/react/flat/RCTView;->mDrawBorder:Lcom/facebook/react/flat/DrawBorder;

    if-nez v0, :cond_1

    .line 175
    new-instance v0, Lcom/facebook/react/flat/DrawBorder;

    invoke-direct {v0}, Lcom/facebook/react/flat/DrawBorder;-><init>()V

    iput-object v0, p0, Lcom/facebook/react/flat/RCTView;->mDrawBorder:Lcom/facebook/react/flat/DrawBorder;

    .line 179
    :cond_0
    :goto_0
    invoke-virtual {p0}, Lcom/facebook/react/flat/RCTView;->invalidate()V

    .line 180
    iget-object v0, p0, Lcom/facebook/react/flat/RCTView;->mDrawBorder:Lcom/facebook/react/flat/DrawBorder;

    return-object v0

    .line 176
    :cond_1
    iget-object v0, p0, Lcom/facebook/react/flat/RCTView;->mDrawBorder:Lcom/facebook/react/flat/DrawBorder;

    invoke-virtual {v0}, Lcom/facebook/react/flat/DrawBorder;->isFrozen()Z

    move-result v0

    if-eqz v0, :cond_0

    .line 177
    iget-object v0, p0, Lcom/facebook/react/flat/RCTView;->mDrawBorder:Lcom/facebook/react/flat/DrawBorder;

    invoke-virtual {v0}, Lcom/facebook/react/flat/DrawBorder;->mutableCopy()Lcom/facebook/react/flat/AbstractDrawCommand;

    move-result-object v0

    check-cast v0, Lcom/facebook/react/flat/DrawBorder;

    iput-object v0, p0, Lcom/facebook/react/flat/RCTView;->mDrawBorder:Lcom/facebook/react/flat/DrawBorder;

    goto :goto_0
.end method


# virtual methods
.method public clipsSubviews()Z
    .locals 1

    .prologue
    .line 185
    iget-boolean v0, p0, Lcom/facebook/react/flat/RCTView;->mRemoveClippedSubviews:Z

    return v0
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
    .line 63
    invoke-super/range {p0 .. p9}, Lcom/facebook/react/flat/FlatShadowNode;->collectState(Lcom/facebook/react/flat/StateBuilder;FFFFFFFF)V

    .line 74
    iget-object v0, p0, Lcom/facebook/react/flat/RCTView;->mDrawBorder:Lcom/facebook/react/flat/DrawBorder;

    if-eqz v0, :cond_0

    .line 75
    iget-object v0, p0, Lcom/facebook/react/flat/RCTView;->mDrawBorder:Lcom/facebook/react/flat/DrawBorder;

    move v1, p2

    move v2, p3

    move v3, p4

    move v4, p5

    move v5, p6

    move/from16 v6, p7

    move/from16 v7, p8

    move/from16 v8, p9

    invoke-virtual/range {v0 .. v8}, Lcom/facebook/react/flat/DrawBorder;->updateBoundsAndFreeze(FFFFFFFF)Lcom/facebook/react/flat/AbstractDrawCommand;

    move-result-object v0

    check-cast v0, Lcom/facebook/react/flat/DrawBorder;

    iput-object v0, p0, Lcom/facebook/react/flat/RCTView;->mDrawBorder:Lcom/facebook/react/flat/DrawBorder;

    .line 84
    iget-object v0, p0, Lcom/facebook/react/flat/RCTView;->mDrawBorder:Lcom/facebook/react/flat/DrawBorder;

    invoke-virtual {p1, v0}, Lcom/facebook/react/flat/StateBuilder;->addDrawCommand(Lcom/facebook/react/flat/AbstractDrawCommand;)V

    .line 86
    :cond_0
    return-void
.end method

.method doesDraw()Z
    .locals 1

    .prologue
    .line 90
    iget-object v0, p0, Lcom/facebook/react/flat/RCTView;->mDrawBorder:Lcom/facebook/react/flat/DrawBorder;

    if-nez v0, :cond_0

    invoke-super {p0}, Lcom/facebook/react/flat/FlatShadowNode;->doesDraw()Z

    move-result v0

    if-eqz v0, :cond_1

    :cond_0
    const/4 v0, 0x1

    :goto_0
    return v0

    :cond_1
    const/4 v0, 0x0

    goto :goto_0
.end method

.method handleUpdateProperties(Lcom/facebook/react/uimanager/ReactStylesDiffMap;)V
    .locals 3
    .param p1, "styles"    # Lcom/facebook/react/uimanager/ReactStylesDiffMap;

    .prologue
    const/4 v2, 0x1

    const/4 v1, 0x0

    .line 40
    iget-boolean v0, p0, Lcom/facebook/react/flat/RCTView;->mRemoveClippedSubviews:Z

    if-nez v0, :cond_0

    const-string v0, "removeClippedSubviews"

    .line 41
    invoke-virtual {p1, v0}, Lcom/facebook/react/uimanager/ReactStylesDiffMap;->hasKey(Ljava/lang/String;)Z

    move-result v0

    if-eqz v0, :cond_4

    const-string v0, "removeClippedSubviews"

    .line 42
    invoke-virtual {p1, v0, v1}, Lcom/facebook/react/uimanager/ReactStylesDiffMap;->getBoolean(Ljava/lang/String;Z)Z

    move-result v0

    if-eqz v0, :cond_4

    :cond_0
    move v0, v2

    :goto_0
    iput-boolean v0, p0, Lcom/facebook/react/flat/RCTView;->mRemoveClippedSubviews:Z

    .line 44
    iget-boolean v0, p0, Lcom/facebook/react/flat/RCTView;->mRemoveClippedSubviews:Z

    if-eqz v0, :cond_3

    .line 45
    iget-boolean v0, p0, Lcom/facebook/react/flat/RCTView;->mHorizontal:Z

    if-nez v0, :cond_1

    const-string v0, "horizontal"

    .line 46
    invoke-virtual {p1, v0}, Lcom/facebook/react/uimanager/ReactStylesDiffMap;->hasKey(Ljava/lang/String;)Z

    move-result v0

    if-eqz v0, :cond_2

    const-string v0, "horizontal"

    invoke-virtual {p1, v0, v1}, Lcom/facebook/react/uimanager/ReactStylesDiffMap;->getBoolean(Ljava/lang/String;Z)Z

    move-result v0

    if-eqz v0, :cond_2

    :cond_1
    move v1, v2

    :cond_2
    iput-boolean v1, p0, Lcom/facebook/react/flat/RCTView;->mHorizontal:Z

    .line 49
    :cond_3
    invoke-super {p0, p1}, Lcom/facebook/react/flat/FlatShadowNode;->handleUpdateProperties(Lcom/facebook/react/uimanager/ReactStylesDiffMap;)V

    .line 50
    return-void

    :cond_4
    move v0, v1

    .line 42
    goto :goto_0
.end method

.method public setBackgroundColor(I)V
    .locals 1
    .param p1, "backgroundColor"    # I

    .prologue
    .line 95
    invoke-direct {p0}, Lcom/facebook/react/flat/RCTView;->getMutableBorder()Lcom/facebook/react/flat/DrawBorder;

    move-result-object v0

    invoke-virtual {v0, p1}, Lcom/facebook/react/flat/DrawBorder;->setBackgroundColor(I)V

    .line 96
    return-void
.end method

.method public setBorderColor(ID)V
    .locals 4
    .param p1, "index"    # I
    .param p2, "color"    # D
    .annotation runtime Lcom/facebook/react/uimanager/annotations/ReactPropGroup;
        customType = "Color"
        defaultDouble = NaN
        names = {
            "borderColor",
            "borderLeftColor",
            "borderRightColor",
            "borderTopColor",
            "borderBottomColor"
        }
    .end annotation

    .prologue
    .line 117
    sget-object v1, Lcom/facebook/react/flat/RCTView;->SPACING_TYPES:[I

    aget v0, v1, p1

    .line 118
    .local v0, "type":I
    invoke-static {p2, p3}, Ljava/lang/Double;->isNaN(D)Z

    move-result v1

    if-eqz v1, :cond_0

    .line 119
    invoke-direct {p0}, Lcom/facebook/react/flat/RCTView;->getMutableBorder()Lcom/facebook/react/flat/DrawBorder;

    move-result-object v1

    invoke-virtual {v1, v0}, Lcom/facebook/react/flat/DrawBorder;->resetBorderColor(I)V

    .line 123
    :goto_0
    return-void

    .line 121
    :cond_0
    invoke-direct {p0}, Lcom/facebook/react/flat/RCTView;->getMutableBorder()Lcom/facebook/react/flat/DrawBorder;

    move-result-object v1

    double-to-int v2, p2

    invoke-virtual {v1, v0, v2}, Lcom/facebook/react/flat/DrawBorder;->setBorderColor(II)V

    goto :goto_0
.end method

.method public setBorderRadius(F)V
    .locals 2
    .param p1, "borderRadius"    # F
    .annotation runtime Lcom/facebook/react/uimanager/annotations/ReactProp;
        name = "borderRadius"
    .end annotation

    .prologue
    .line 127
    iput p1, p0, Lcom/facebook/react/flat/RCTView;->mClipRadius:F

    .line 128
    iget-boolean v0, p0, Lcom/facebook/react/flat/RCTView;->mClipToBounds:Z

    if-eqz v0, :cond_0

    const/high16 v0, 0x3f000000    # 0.5f

    cmpl-float v0, p1, v0

    if-lez v0, :cond_0

    .line 131
    invoke-virtual {p0}, Lcom/facebook/react/flat/RCTView;->forceMountToView()V

    .line 133
    :cond_0
    invoke-direct {p0}, Lcom/facebook/react/flat/RCTView;->getMutableBorder()Lcom/facebook/react/flat/DrawBorder;

    move-result-object v0

    invoke-static {p1}, Lcom/facebook/react/uimanager/PixelUtil;->toPixelFromDIP(F)F

    move-result v1

    invoke-virtual {v0, v1}, Lcom/facebook/react/flat/DrawBorder;->setBorderRadius(F)V

    .line 134
    return-void
.end method

.method public setBorderStyle(Ljava/lang/String;)V
    .locals 1
    .param p1, "borderStyle"    # Ljava/lang/String;
        .annotation runtime Ljavax/annotation/Nullable;
        .end annotation
    .end param
    .annotation runtime Lcom/facebook/react/uimanager/annotations/ReactProp;
        name = "borderStyle"
    .end annotation

    .prologue
    .line 138
    invoke-direct {p0}, Lcom/facebook/react/flat/RCTView;->getMutableBorder()Lcom/facebook/react/flat/DrawBorder;

    move-result-object v0

    invoke-virtual {v0, p1}, Lcom/facebook/react/flat/DrawBorder;->setBorderStyle(Ljava/lang/String;)V

    .line 139
    return-void
.end method

.method public setBorderWidths(IF)V
    .locals 3
    .param p1, "index"    # I
    .param p2, "borderWidth"    # F

    .prologue
    .line 100
    invoke-super {p0, p1, p2}, Lcom/facebook/react/flat/FlatShadowNode;->setBorderWidths(IF)V

    .line 102
    sget-object v1, Lcom/facebook/react/flat/RCTView;->SPACING_TYPES:[I

    aget v0, v1, p1

    .line 103
    .local v0, "type":I
    invoke-direct {p0}, Lcom/facebook/react/flat/RCTView;->getMutableBorder()Lcom/facebook/react/flat/DrawBorder;

    move-result-object v1

    invoke-static {p2}, Lcom/facebook/react/uimanager/PixelUtil;->toPixelFromDIP(F)F

    move-result v2

    invoke-virtual {v1, v0, v2}, Lcom/facebook/react/flat/DrawBorder;->setBorderWidth(IF)V

    .line 104
    return-void
.end method

.method public setHitSlop(Lcom/facebook/react/bridge/ReadableMap;)V
    .locals 6
    .param p1, "hitSlop"    # Lcom/facebook/react/bridge/ReadableMap;
        .annotation runtime Ljavax/annotation/Nullable;
        .end annotation
    .end param
    .annotation runtime Lcom/facebook/react/uimanager/annotations/ReactProp;
        name = "hitSlop"
    .end annotation

    .prologue
    .line 143
    if-nez p1, :cond_0

    .line 144
    const/4 v0, 0x0

    iput-object v0, p0, Lcom/facebook/react/flat/RCTView;->mHitSlop:Landroid/graphics/Rect;

    .line 152
    :goto_0
    return-void

    .line 146
    :cond_0
    new-instance v0, Landroid/graphics/Rect;

    const-string v1, "left"

    .line 147
    invoke-interface {p1, v1}, Lcom/facebook/react/bridge/ReadableMap;->getDouble(Ljava/lang/String;)D

    move-result-wide v2

    invoke-static {v2, v3}, Lcom/facebook/react/uimanager/PixelUtil;->toPixelFromDIP(D)F

    move-result v1

    float-to-int v1, v1

    const-string v2, "top"

    .line 148
    invoke-interface {p1, v2}, Lcom/facebook/react/bridge/ReadableMap;->getDouble(Ljava/lang/String;)D

    move-result-wide v2

    invoke-static {v2, v3}, Lcom/facebook/react/uimanager/PixelUtil;->toPixelFromDIP(D)F

    move-result v2

    float-to-int v2, v2

    const-string v3, "right"

    .line 149
    invoke-interface {p1, v3}, Lcom/facebook/react/bridge/ReadableMap;->getDouble(Ljava/lang/String;)D

    move-result-wide v4

    invoke-static {v4, v5}, Lcom/facebook/react/uimanager/PixelUtil;->toPixelFromDIP(D)F

    move-result v3

    float-to-int v3, v3

    const-string v4, "bottom"

    .line 150
    invoke-interface {p1, v4}, Lcom/facebook/react/bridge/ReadableMap;->getDouble(Ljava/lang/String;)D

    move-result-wide v4

    invoke-static {v4, v5}, Lcom/facebook/react/uimanager/PixelUtil;->toPixelFromDIP(D)F

    move-result v4

    float-to-int v4, v4

    invoke-direct {v0, v1, v2, v3, v4}, Landroid/graphics/Rect;-><init>(IIII)V

    iput-object v0, p0, Lcom/facebook/react/flat/RCTView;->mHitSlop:Landroid/graphics/Rect;

    goto :goto_0
.end method

.method public setHotspot(Lcom/facebook/react/bridge/ReadableMap;)V
    .locals 0
    .param p1, "bg"    # Lcom/facebook/react/bridge/ReadableMap;
        .annotation runtime Ljavax/annotation/Nullable;
        .end annotation
    .end param
    .annotation runtime Lcom/facebook/react/uimanager/annotations/ReactProp;
        name = "nativeBackgroundAndroid"
    .end annotation

    .prologue
    .line 108
    if-eqz p1, :cond_0

    .line 109
    invoke-virtual {p0}, Lcom/facebook/react/flat/RCTView;->forceMountToView()V

    .line 111
    :cond_0
    return-void
.end method

.method public setPointerEvents(Ljava/lang/String;)V
    .locals 0
    .param p1, "pointerEventsStr"    # Ljava/lang/String;
        .annotation runtime Ljavax/annotation/Nullable;
        .end annotation
    .end param
    .annotation runtime Lcom/facebook/react/uimanager/annotations/ReactProp;
        name = "pointerEvents"
    .end annotation

    .prologue
    .line 156
    invoke-virtual {p0}, Lcom/facebook/react/flat/RCTView;->forceMountToView()V

    .line 157
    return-void
.end method

.method updateNodeRegion(FFFFZ)V
    .locals 8
    .param p1, "left"    # F
    .param p2, "top"    # F
    .param p3, "right"    # F
    .param p4, "bottom"    # F
    .param p5, "isVirtual"    # Z

    .prologue
    .line 166
    invoke-virtual {p0}, Lcom/facebook/react/flat/RCTView;->getNodeRegion()Lcom/facebook/react/flat/NodeRegion;

    move-result-object v0

    move v1, p1

    move v2, p2

    move v3, p3

    move v4, p4

    move v5, p5

    invoke-virtual/range {v0 .. v5}, Lcom/facebook/react/flat/NodeRegion;->matches(FFFFZ)Z

    move-result v0

    if-nez v0, :cond_0

    .line 167
    iget-object v0, p0, Lcom/facebook/react/flat/RCTView;->mHitSlop:Landroid/graphics/Rect;

    if-nez v0, :cond_1

    new-instance v0, Lcom/facebook/react/flat/NodeRegion;

    .line 168
    invoke-virtual {p0}, Lcom/facebook/react/flat/RCTView;->getReactTag()I

    move-result v5

    move v1, p1

    move v2, p2

    move v3, p3

    move v4, p4

    move v6, p5

    invoke-direct/range {v0 .. v6}, Lcom/facebook/react/flat/NodeRegion;-><init>(FFFFIZ)V

    .line 167
    :goto_0
    invoke-virtual {p0, v0}, Lcom/facebook/react/flat/RCTView;->setNodeRegion(Lcom/facebook/react/flat/NodeRegion;)V

    .line 171
    :cond_0
    return-void

    .line 168
    :cond_1
    new-instance v0, Lcom/facebook/react/flat/HitSlopNodeRegion;

    iget-object v1, p0, Lcom/facebook/react/flat/RCTView;->mHitSlop:Landroid/graphics/Rect;

    .line 169
    invoke-virtual {p0}, Lcom/facebook/react/flat/RCTView;->getReactTag()I

    move-result v6

    move v2, p1

    move v3, p2

    move v4, p3

    move v5, p4

    move v7, p5

    invoke-direct/range {v0 .. v7}, Lcom/facebook/react/flat/HitSlopNodeRegion;-><init>(Landroid/graphics/Rect;FFFFIZ)V

    goto :goto_0
.end method

.class public Lcom/facebook/react/views/art/ARTGroupShadowNode;
.super Lcom/facebook/react/views/art/ARTVirtualNode;
.source "ARTGroupShadowNode.java"


# instance fields
.field protected mClipping:Landroid/graphics/RectF;
    .annotation runtime Ljavax/annotation/Nullable;
    .end annotation
.end field


# direct methods
.method public constructor <init>()V
    .locals 0

    .prologue
    .line 26
    invoke-direct {p0}, Lcom/facebook/react/views/art/ARTVirtualNode;-><init>()V

    return-void
.end method

.method private static createClipping([F)Landroid/graphics/RectF;
    .locals 6
    .param p0, "data"    # [F

    .prologue
    const/4 v5, 0x1

    const/4 v3, 0x0

    .line 76
    array-length v1, p0

    const/4 v2, 0x4

    if-eq v1, v2, :cond_0

    .line 77
    new-instance v1, Lcom/facebook/react/bridge/JSApplicationIllegalArgumentException;

    const-string v2, "Clipping should be array of length 4 (e.g. [x, y, width, height])"

    invoke-direct {v1, v2}, Lcom/facebook/react/bridge/JSApplicationIllegalArgumentException;-><init>(Ljava/lang/String;)V

    throw v1

    .line 80
    :cond_0
    new-instance v0, Landroid/graphics/RectF;

    aget v1, p0, v3

    aget v2, p0, v5

    aget v3, p0, v3

    const/4 v4, 0x2

    aget v4, p0, v4

    add-float/2addr v3, v4

    aget v4, p0, v5

    const/4 v5, 0x3

    aget v5, p0, v5

    add-float/2addr v4, v5

    invoke-direct {v0, v1, v2, v3, v4}, Landroid/graphics/RectF;-><init>(FFFF)V

    .line 82
    .local v0, "clippingRect":Landroid/graphics/RectF;
    return-object v0
.end method


# virtual methods
.method public draw(Landroid/graphics/Canvas;Landroid/graphics/Paint;F)V
    .locals 8
    .param p1, "canvas"    # Landroid/graphics/Canvas;
    .param p2, "paint"    # Landroid/graphics/Paint;
    .param p3, "opacity"    # F

    .prologue
    .line 45
    iget v0, p0, Lcom/facebook/react/views/art/ARTGroupShadowNode;->mOpacity:F

    mul-float/2addr p3, v0

    .line 46
    const v0, 0x3c23d70a    # 0.01f

    cmpl-float v0, p3, v0

    if-lez v0, :cond_2

    .line 47
    invoke-virtual {p0, p1}, Lcom/facebook/react/views/art/ARTGroupShadowNode;->saveAndSetupCanvas(Landroid/graphics/Canvas;)V

    .line 49
    iget-object v0, p0, Lcom/facebook/react/views/art/ARTGroupShadowNode;->mClipping:Landroid/graphics/RectF;

    if-eqz v0, :cond_0

    .line 50
    iget-object v0, p0, Lcom/facebook/react/views/art/ARTGroupShadowNode;->mClipping:Landroid/graphics/RectF;

    iget v0, v0, Landroid/graphics/RectF;->left:F

    iget v1, p0, Lcom/facebook/react/views/art/ARTGroupShadowNode;->mScale:F

    mul-float/2addr v1, v0

    iget-object v0, p0, Lcom/facebook/react/views/art/ARTGroupShadowNode;->mClipping:Landroid/graphics/RectF;

    iget v0, v0, Landroid/graphics/RectF;->top:F

    iget v2, p0, Lcom/facebook/react/views/art/ARTGroupShadowNode;->mScale:F

    mul-float/2addr v2, v0

    iget-object v0, p0, Lcom/facebook/react/views/art/ARTGroupShadowNode;->mClipping:Landroid/graphics/RectF;

    iget v0, v0, Landroid/graphics/RectF;->right:F

    iget v3, p0, Lcom/facebook/react/views/art/ARTGroupShadowNode;->mScale:F

    mul-float/2addr v3, v0

    iget-object v0, p0, Lcom/facebook/react/views/art/ARTGroupShadowNode;->mClipping:Landroid/graphics/RectF;

    iget v0, v0, Landroid/graphics/RectF;->bottom:F

    iget v4, p0, Lcom/facebook/react/views/art/ARTGroupShadowNode;->mScale:F

    mul-float/2addr v4, v0

    sget-object v5, Landroid/graphics/Region$Op;->REPLACE:Landroid/graphics/Region$Op;

    move-object v0, p1

    invoke-virtual/range {v0 .. v5}, Landroid/graphics/Canvas;->clipRect(FFFFLandroid/graphics/Region$Op;)Z

    .line 58
    :cond_0
    const/4 v7, 0x0

    .local v7, "i":I
    :goto_0
    invoke-virtual {p0}, Lcom/facebook/react/views/art/ARTGroupShadowNode;->getChildCount()I

    move-result v0

    if-ge v7, v0, :cond_1

    .line 59
    invoke-virtual {p0, v7}, Lcom/facebook/react/views/art/ARTGroupShadowNode;->getChildAt(I)Lcom/facebook/react/uimanager/ReactShadowNodeImpl;

    move-result-object v6

    check-cast v6, Lcom/facebook/react/views/art/ARTVirtualNode;

    .line 60
    .local v6, "child":Lcom/facebook/react/views/art/ARTVirtualNode;
    invoke-virtual {v6, p1, p2, p3}, Lcom/facebook/react/views/art/ARTVirtualNode;->draw(Landroid/graphics/Canvas;Landroid/graphics/Paint;F)V

    .line 61
    invoke-virtual {v6}, Lcom/facebook/react/views/art/ARTVirtualNode;->markUpdateSeen()V

    .line 58
    add-int/lit8 v7, v7, 0x1

    goto :goto_0

    .line 64
    .end local v6    # "child":Lcom/facebook/react/views/art/ARTVirtualNode;
    :cond_1
    invoke-virtual {p0, p1}, Lcom/facebook/react/views/art/ARTGroupShadowNode;->restoreCanvas(Landroid/graphics/Canvas;)V

    .line 66
    .end local v7    # "i":I
    :cond_2
    return-void
.end method

.method public isVirtual()Z
    .locals 1

    .prologue
    .line 41
    const/4 v0, 0x1

    return v0
.end method

.method public setClipping(Lcom/facebook/react/bridge/ReadableArray;)V
    .locals 2
    .param p1, "clippingDims"    # Lcom/facebook/react/bridge/ReadableArray;
        .annotation runtime Ljavax/annotation/Nullable;
        .end annotation
    .end param
    .annotation runtime Lcom/facebook/react/uimanager/annotations/ReactProp;
        name = "clipping"
    .end annotation

    .prologue
    .line 32
    invoke-static {p1}, Lcom/facebook/react/views/art/PropHelper;->toFloatArray(Lcom/facebook/react/bridge/ReadableArray;)[F

    move-result-object v0

    .line 33
    .local v0, "clippingData":[F
    if-eqz v0, :cond_0

    .line 34
    invoke-static {v0}, Lcom/facebook/react/views/art/ARTGroupShadowNode;->createClipping([F)Landroid/graphics/RectF;

    move-result-object v1

    iput-object v1, p0, Lcom/facebook/react/views/art/ARTGroupShadowNode;->mClipping:Landroid/graphics/RectF;

    .line 35
    invoke-virtual {p0}, Lcom/facebook/react/views/art/ARTGroupShadowNode;->markUpdated()V

    .line 37
    :cond_0
    return-void
.end method

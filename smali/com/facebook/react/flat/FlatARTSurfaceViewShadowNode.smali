.class Lcom/facebook/react/flat/FlatARTSurfaceViewShadowNode;
.super Lcom/facebook/react/flat/FlatShadowNode;
.source "FlatARTSurfaceViewShadowNode.java"

# interfaces
.implements Lcom/facebook/react/flat/AndroidView;
.implements Landroid/view/TextureView$SurfaceTextureListener;


# instance fields
.field private mPaddingChanged:Z

.field private mSurface:Landroid/view/Surface;
    .annotation runtime Ljavax/annotation/Nullable;
    .end annotation
.end field


# direct methods
.method constructor <init>()V
    .locals 1

    .prologue
    .line 35
    invoke-direct {p0}, Lcom/facebook/react/flat/FlatShadowNode;-><init>()V

    .line 32
    const/4 v0, 0x0

    iput-boolean v0, p0, Lcom/facebook/react/flat/FlatARTSurfaceViewShadowNode;->mPaddingChanged:Z

    .line 36
    invoke-virtual {p0}, Lcom/facebook/react/flat/FlatARTSurfaceViewShadowNode;->forceMountToView()V

    .line 37
    invoke-virtual {p0}, Lcom/facebook/react/flat/FlatARTSurfaceViewShadowNode;->forceMountChildrenToView()V

    .line 38
    return-void
.end method

.method private drawOutput()V
    .locals 8

    .prologue
    .line 58
    iget-object v5, p0, Lcom/facebook/react/flat/FlatARTSurfaceViewShadowNode;->mSurface:Landroid/view/Surface;

    if-eqz v5, :cond_0

    iget-object v5, p0, Lcom/facebook/react/flat/FlatARTSurfaceViewShadowNode;->mSurface:Landroid/view/Surface;

    invoke-virtual {v5}, Landroid/view/Surface;->isValid()Z

    move-result v5

    if-nez v5, :cond_2

    .line 59
    :cond_0
    invoke-direct {p0, p0}, Lcom/facebook/react/flat/FlatARTSurfaceViewShadowNode;->markChildrenUpdatesSeen(Lcom/facebook/react/uimanager/ReactShadowNode;)V

    .line 82
    :cond_1
    :goto_0
    return-void

    .line 64
    :cond_2
    :try_start_0
    iget-object v5, p0, Lcom/facebook/react/flat/FlatARTSurfaceViewShadowNode;->mSurface:Landroid/view/Surface;

    const/4 v6, 0x0

    invoke-virtual {v5, v6}, Landroid/view/Surface;->lockCanvas(Landroid/graphics/Rect;)Landroid/graphics/Canvas;

    move-result-object v0

    .line 65
    .local v0, "canvas":Landroid/graphics/Canvas;
    const/4 v5, 0x0

    sget-object v6, Landroid/graphics/PorterDuff$Mode;->CLEAR:Landroid/graphics/PorterDuff$Mode;

    invoke-virtual {v0, v5, v6}, Landroid/graphics/Canvas;->drawColor(ILandroid/graphics/PorterDuff$Mode;)V

    .line 67
    new-instance v4, Landroid/graphics/Paint;

    invoke-direct {v4}, Landroid/graphics/Paint;-><init>()V

    .line 68
    .local v4, "paint":Landroid/graphics/Paint;
    const/4 v3, 0x0

    .local v3, "i":I
    :goto_1
    invoke-virtual {p0}, Lcom/facebook/react/flat/FlatARTSurfaceViewShadowNode;->getChildCount()I

    move-result v5

    if-ge v3, v5, :cond_3

    .line 69
    invoke-virtual {p0, v3}, Lcom/facebook/react/flat/FlatARTSurfaceViewShadowNode;->getChildAt(I)Lcom/facebook/react/uimanager/ReactShadowNodeImpl;

    move-result-object v1

    check-cast v1, Lcom/facebook/react/views/art/ARTVirtualNode;

    .line 70
    .local v1, "child":Lcom/facebook/react/views/art/ARTVirtualNode;
    const/high16 v5, 0x3f800000    # 1.0f

    invoke-virtual {v1, v0, v4, v5}, Lcom/facebook/react/views/art/ARTVirtualNode;->draw(Landroid/graphics/Canvas;Landroid/graphics/Paint;F)V

    .line 71
    invoke-virtual {v1}, Lcom/facebook/react/views/art/ARTVirtualNode;->markUpdateSeen()V

    .line 68
    add-int/lit8 v3, v3, 0x1

    goto :goto_1

    .line 74
    .end local v1    # "child":Lcom/facebook/react/views/art/ARTVirtualNode;
    :cond_3
    iget-object v5, p0, Lcom/facebook/react/flat/FlatARTSurfaceViewShadowNode;->mSurface:Landroid/view/Surface;

    if-eqz v5, :cond_1

    .line 78
    iget-object v5, p0, Lcom/facebook/react/flat/FlatARTSurfaceViewShadowNode;->mSurface:Landroid/view/Surface;

    invoke-virtual {v5, v0}, Landroid/view/Surface;->unlockCanvasAndPost(Landroid/graphics/Canvas;)V
    :try_end_0
    .catch Ljava/lang/IllegalArgumentException; {:try_start_0 .. :try_end_0} :catch_0
    .catch Ljava/lang/IllegalStateException; {:try_start_0 .. :try_end_0} :catch_1

    goto :goto_0

    .line 79
    .end local v0    # "canvas":Landroid/graphics/Canvas;
    .end local v3    # "i":I
    .end local v4    # "paint":Landroid/graphics/Paint;
    :catch_0
    move-exception v2

    .line 80
    .local v2, "e":Ljava/lang/RuntimeException;
    :goto_2
    const-string v5, "ReactNative"

    new-instance v6, Ljava/lang/StringBuilder;

    invoke-direct {v6}, Ljava/lang/StringBuilder;-><init>()V

    invoke-virtual {v2}, Ljava/lang/Object;->getClass()Ljava/lang/Class;

    move-result-object v7

    invoke-virtual {v7}, Ljava/lang/Class;->getSimpleName()Ljava/lang/String;

    move-result-object v7

    invoke-virtual {v6, v7}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v6

    const-string v7, " in Surface.unlockCanvasAndPost"

    invoke-virtual {v6, v7}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v6

    invoke-virtual {v6}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v6

    invoke-static {v5, v6}, Landroid/util/Log;->e(Ljava/lang/String;Ljava/lang/String;)I

    goto :goto_0

    .line 79
    .end local v2    # "e":Ljava/lang/RuntimeException;
    :catch_1
    move-exception v2

    goto :goto_2
.end method

.method private markChildrenUpdatesSeen(Lcom/facebook/react/uimanager/ReactShadowNode;)V
    .locals 3
    .param p1, "shadowNode"    # Lcom/facebook/react/uimanager/ReactShadowNode;

    .prologue
    .line 85
    const/4 v1, 0x0

    .local v1, "i":I
    :goto_0
    invoke-interface {p1}, Lcom/facebook/react/uimanager/ReactShadowNode;->getChildCount()I

    move-result v2

    if-ge v1, v2, :cond_0

    .line 86
    invoke-interface {p1, v1}, Lcom/facebook/react/uimanager/ReactShadowNode;->getChildAt(I)Lcom/facebook/react/uimanager/ReactShadowNode;

    move-result-object v0

    .line 87
    .local v0, "child":Lcom/facebook/react/uimanager/ReactShadowNode;
    invoke-interface {v0}, Lcom/facebook/react/uimanager/ReactShadowNode;->markUpdateSeen()V

    .line 88
    invoke-direct {p0, v0}, Lcom/facebook/react/flat/FlatARTSurfaceViewShadowNode;->markChildrenUpdatesSeen(Lcom/facebook/react/uimanager/ReactShadowNode;)V

    .line 85
    add-int/lit8 v1, v1, 0x1

    goto :goto_0

    .line 90
    .end local v0    # "child":Lcom/facebook/react/uimanager/ReactShadowNode;
    :cond_0
    return-void
.end method


# virtual methods
.method public isPaddingChanged()Z
    .locals 1

    .prologue
    .line 99
    iget-boolean v0, p0, Lcom/facebook/react/flat/FlatARTSurfaceViewShadowNode;->mPaddingChanged:Z

    return v0
.end method

.method public isVirtual()Z
    .locals 1

    .prologue
    .line 42
    const/4 v0, 0x0

    return v0
.end method

.method public isVirtualAnchor()Z
    .locals 1

    .prologue
    .line 47
    const/4 v0, 0x1

    return v0
.end method

.method public needsCustomLayoutForChildren()Z
    .locals 1

    .prologue
    .line 94
    const/4 v0, 0x0

    return v0
.end method

.method public onCollectExtraUpdates(Lcom/facebook/react/uimanager/UIViewOperationQueue;)V
    .locals 1
    .param p1, "uiUpdater"    # Lcom/facebook/react/uimanager/UIViewOperationQueue;

    .prologue
    .line 52
    invoke-super {p0, p1}, Lcom/facebook/react/flat/FlatShadowNode;->onCollectExtraUpdates(Lcom/facebook/react/uimanager/UIViewOperationQueue;)V

    .line 53
    invoke-direct {p0}, Lcom/facebook/react/flat/FlatARTSurfaceViewShadowNode;->drawOutput()V

    .line 54
    invoke-virtual {p0}, Lcom/facebook/react/flat/FlatARTSurfaceViewShadowNode;->getReactTag()I

    move-result v0

    invoke-virtual {p1, v0, p0}, Lcom/facebook/react/uimanager/UIViewOperationQueue;->enqueueUpdateExtraData(ILjava/lang/Object;)V

    .line 55
    return-void
.end method

.method public onSurfaceTextureAvailable(Landroid/graphics/SurfaceTexture;II)V
    .locals 1
    .param p1, "surface"    # Landroid/graphics/SurfaceTexture;
    .param p2, "width"    # I
    .param p3, "height"    # I

    .prologue
    .line 129
    new-instance v0, Landroid/view/Surface;

    invoke-direct {v0, p1}, Landroid/view/Surface;-><init>(Landroid/graphics/SurfaceTexture;)V

    iput-object v0, p0, Lcom/facebook/react/flat/FlatARTSurfaceViewShadowNode;->mSurface:Landroid/view/Surface;

    .line 130
    invoke-direct {p0}, Lcom/facebook/react/flat/FlatARTSurfaceViewShadowNode;->drawOutput()V

    .line 131
    return-void
.end method

.method public onSurfaceTextureDestroyed(Landroid/graphics/SurfaceTexture;)Z
    .locals 1
    .param p1, "surface"    # Landroid/graphics/SurfaceTexture;

    .prologue
    .line 135
    invoke-virtual {p1}, Landroid/graphics/SurfaceTexture;->release()V

    .line 136
    const/4 v0, 0x0

    iput-object v0, p0, Lcom/facebook/react/flat/FlatARTSurfaceViewShadowNode;->mSurface:Landroid/view/Surface;

    .line 137
    const/4 v0, 0x1

    return v0
.end method

.method public onSurfaceTextureSizeChanged(Landroid/graphics/SurfaceTexture;II)V
    .locals 0
    .param p1, "surface"    # Landroid/graphics/SurfaceTexture;
    .param p2, "width"    # I
    .param p3, "height"    # I

    .prologue
    .line 141
    return-void
.end method

.method public onSurfaceTextureUpdated(Landroid/graphics/SurfaceTexture;)V
    .locals 0
    .param p1, "surface"    # Landroid/graphics/SurfaceTexture;

    .prologue
    .line 144
    return-void
.end method

.method public resetPaddingChanged()V
    .locals 1

    .prologue
    .line 104
    const/4 v0, 0x0

    iput-boolean v0, p0, Lcom/facebook/react/flat/FlatARTSurfaceViewShadowNode;->mPaddingChanged:Z

    .line 105
    return-void
.end method

.method public setPadding(IF)V
    .locals 3
    .param p1, "spacingType"    # I
    .param p2, "padding"    # F

    .prologue
    .line 109
    invoke-virtual {p0, p1}, Lcom/facebook/react/flat/FlatARTSurfaceViewShadowNode;->getStylePadding(I)Lcom/facebook/yoga/YogaValue;

    move-result-object v0

    .line 110
    .local v0, "current":Lcom/facebook/yoga/YogaValue;
    iget-object v1, v0, Lcom/facebook/yoga/YogaValue;->unit:Lcom/facebook/yoga/YogaUnit;

    sget-object v2, Lcom/facebook/yoga/YogaUnit;->POINT:Lcom/facebook/yoga/YogaUnit;

    if-ne v1, v2, :cond_0

    iget v1, v0, Lcom/facebook/yoga/YogaValue;->value:F

    cmpl-float v1, v1, p2

    if-eqz v1, :cond_1

    .line 111
    :cond_0
    invoke-super {p0, p1, p2}, Lcom/facebook/react/flat/FlatShadowNode;->setPadding(IF)V

    .line 112
    const/4 v1, 0x1

    iput-boolean v1, p0, Lcom/facebook/react/flat/FlatARTSurfaceViewShadowNode;->mPaddingChanged:Z

    .line 113
    invoke-virtual {p0}, Lcom/facebook/react/flat/FlatARTSurfaceViewShadowNode;->markUpdated()V

    .line 115
    :cond_1
    return-void
.end method

.method public setPaddingPercent(IF)V
    .locals 3
    .param p1, "spacingType"    # I
    .param p2, "percent"    # F

    .prologue
    .line 119
    invoke-virtual {p0, p1}, Lcom/facebook/react/flat/FlatARTSurfaceViewShadowNode;->getStylePadding(I)Lcom/facebook/yoga/YogaValue;

    move-result-object v0

    .line 120
    .local v0, "current":Lcom/facebook/yoga/YogaValue;
    iget-object v1, v0, Lcom/facebook/yoga/YogaValue;->unit:Lcom/facebook/yoga/YogaUnit;

    sget-object v2, Lcom/facebook/yoga/YogaUnit;->PERCENT:Lcom/facebook/yoga/YogaUnit;

    if-ne v1, v2, :cond_0

    iget v1, v0, Lcom/facebook/yoga/YogaValue;->value:F

    cmpl-float v1, v1, p2

    if-eqz v1, :cond_1

    .line 121
    :cond_0
    invoke-super {p0, p1, p2}, Lcom/facebook/react/flat/FlatShadowNode;->setPadding(IF)V

    .line 122
    const/4 v1, 0x1

    iput-boolean v1, p0, Lcom/facebook/react/flat/FlatARTSurfaceViewShadowNode;->mPaddingChanged:Z

    .line 123
    invoke-virtual {p0}, Lcom/facebook/react/flat/FlatARTSurfaceViewShadowNode;->markUpdated()V

    .line 125
    :cond_1
    return-void
.end method

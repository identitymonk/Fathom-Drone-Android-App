.class public Lcom/facebook/react/views/art/ARTSurfaceViewShadowNode;
.super Lcom/facebook/react/uimanager/LayoutShadowNode;
.source "ARTSurfaceViewShadowNode.java"

# interfaces
.implements Landroid/view/TextureView$SurfaceTextureListener;


# instance fields
.field private mBackgroundColor:Ljava/lang/Integer;
    .annotation runtime Ljavax/annotation/Nullable;
    .end annotation
.end field

.field private mSurface:Landroid/view/Surface;
    .annotation runtime Ljavax/annotation/Nullable;
    .end annotation
.end field


# direct methods
.method public constructor <init>()V
    .locals 0

    .prologue
    .line 33
    invoke-direct {p0}, Lcom/facebook/react/uimanager/LayoutShadowNode;-><init>()V

    return-void
.end method

.method private drawOutput()V
    .locals 8

    .prologue
    .line 64
    iget-object v5, p0, Lcom/facebook/react/views/art/ARTSurfaceViewShadowNode;->mSurface:Landroid/view/Surface;

    if-eqz v5, :cond_0

    iget-object v5, p0, Lcom/facebook/react/views/art/ARTSurfaceViewShadowNode;->mSurface:Landroid/view/Surface;

    invoke-virtual {v5}, Landroid/view/Surface;->isValid()Z

    move-result v5

    if-nez v5, :cond_2

    .line 65
    :cond_0
    invoke-direct {p0, p0}, Lcom/facebook/react/views/art/ARTSurfaceViewShadowNode;->markChildrenUpdatesSeen(Lcom/facebook/react/uimanager/ReactShadowNode;)V

    .line 91
    :cond_1
    :goto_0
    return-void

    .line 70
    :cond_2
    :try_start_0
    iget-object v5, p0, Lcom/facebook/react/views/art/ARTSurfaceViewShadowNode;->mSurface:Landroid/view/Surface;

    const/4 v6, 0x0

    invoke-virtual {v5, v6}, Landroid/view/Surface;->lockCanvas(Landroid/graphics/Rect;)Landroid/graphics/Canvas;

    move-result-object v0

    .line 71
    .local v0, "canvas":Landroid/graphics/Canvas;
    const/4 v5, 0x0

    sget-object v6, Landroid/graphics/PorterDuff$Mode;->CLEAR:Landroid/graphics/PorterDuff$Mode;

    invoke-virtual {v0, v5, v6}, Landroid/graphics/Canvas;->drawColor(ILandroid/graphics/PorterDuff$Mode;)V

    .line 72
    iget-object v5, p0, Lcom/facebook/react/views/art/ARTSurfaceViewShadowNode;->mBackgroundColor:Ljava/lang/Integer;

    if-eqz v5, :cond_3

    .line 73
    iget-object v5, p0, Lcom/facebook/react/views/art/ARTSurfaceViewShadowNode;->mBackgroundColor:Ljava/lang/Integer;

    invoke-virtual {v5}, Ljava/lang/Integer;->intValue()I

    move-result v5

    invoke-virtual {v0, v5}, Landroid/graphics/Canvas;->drawColor(I)V

    .line 76
    :cond_3
    new-instance v4, Landroid/graphics/Paint;

    invoke-direct {v4}, Landroid/graphics/Paint;-><init>()V

    .line 77
    .local v4, "paint":Landroid/graphics/Paint;
    const/4 v3, 0x0

    .local v3, "i":I
    :goto_1
    invoke-virtual {p0}, Lcom/facebook/react/views/art/ARTSurfaceViewShadowNode;->getChildCount()I

    move-result v5

    if-ge v3, v5, :cond_4

    .line 78
    invoke-virtual {p0, v3}, Lcom/facebook/react/views/art/ARTSurfaceViewShadowNode;->getChildAt(I)Lcom/facebook/react/uimanager/ReactShadowNodeImpl;

    move-result-object v1

    check-cast v1, Lcom/facebook/react/views/art/ARTVirtualNode;

    .line 79
    .local v1, "child":Lcom/facebook/react/views/art/ARTVirtualNode;
    const/high16 v5, 0x3f800000    # 1.0f

    invoke-virtual {v1, v0, v4, v5}, Lcom/facebook/react/views/art/ARTVirtualNode;->draw(Landroid/graphics/Canvas;Landroid/graphics/Paint;F)V

    .line 80
    invoke-virtual {v1}, Lcom/facebook/react/views/art/ARTVirtualNode;->markUpdateSeen()V

    .line 77
    add-int/lit8 v3, v3, 0x1

    goto :goto_1

    .line 83
    .end local v1    # "child":Lcom/facebook/react/views/art/ARTVirtualNode;
    :cond_4
    iget-object v5, p0, Lcom/facebook/react/views/art/ARTSurfaceViewShadowNode;->mSurface:Landroid/view/Surface;

    if-eqz v5, :cond_1

    .line 87
    iget-object v5, p0, Lcom/facebook/react/views/art/ARTSurfaceViewShadowNode;->mSurface:Landroid/view/Surface;

    invoke-virtual {v5, v0}, Landroid/view/Surface;->unlockCanvasAndPost(Landroid/graphics/Canvas;)V
    :try_end_0
    .catch Ljava/lang/IllegalArgumentException; {:try_start_0 .. :try_end_0} :catch_0
    .catch Ljava/lang/IllegalStateException; {:try_start_0 .. :try_end_0} :catch_1

    goto :goto_0

    .line 88
    .end local v0    # "canvas":Landroid/graphics/Canvas;
    .end local v3    # "i":I
    .end local v4    # "paint":Landroid/graphics/Paint;
    :catch_0
    move-exception v2

    .line 89
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

    invoke-static {v5, v6}, Lcom/facebook/common/logging/FLog;->e(Ljava/lang/String;Ljava/lang/String;)V

    goto :goto_0

    .line 88
    .end local v2    # "e":Ljava/lang/RuntimeException;
    :catch_1
    move-exception v2

    goto :goto_2
.end method

.method private markChildrenUpdatesSeen(Lcom/facebook/react/uimanager/ReactShadowNode;)V
    .locals 3
    .param p1, "shadowNode"    # Lcom/facebook/react/uimanager/ReactShadowNode;

    .prologue
    .line 94
    const/4 v1, 0x0

    .local v1, "i":I
    :goto_0
    invoke-interface {p1}, Lcom/facebook/react/uimanager/ReactShadowNode;->getChildCount()I

    move-result v2

    if-ge v1, v2, :cond_0

    .line 95
    invoke-interface {p1, v1}, Lcom/facebook/react/uimanager/ReactShadowNode;->getChildAt(I)Lcom/facebook/react/uimanager/ReactShadowNode;

    move-result-object v0

    .line 96
    .local v0, "child":Lcom/facebook/react/uimanager/ReactShadowNode;
    invoke-interface {v0}, Lcom/facebook/react/uimanager/ReactShadowNode;->markUpdateSeen()V

    .line 97
    invoke-direct {p0, v0}, Lcom/facebook/react/views/art/ARTSurfaceViewShadowNode;->markChildrenUpdatesSeen(Lcom/facebook/react/uimanager/ReactShadowNode;)V

    .line 94
    add-int/lit8 v1, v1, 0x1

    goto :goto_0

    .line 99
    .end local v0    # "child":Lcom/facebook/react/uimanager/ReactShadowNode;
    :cond_0
    return-void
.end method


# virtual methods
.method public isVirtual()Z
    .locals 1

    .prologue
    .line 48
    const/4 v0, 0x0

    return v0
.end method

.method public isVirtualAnchor()Z
    .locals 1

    .prologue
    .line 53
    const/4 v0, 0x1

    return v0
.end method

.method public onCollectExtraUpdates(Lcom/facebook/react/uimanager/UIViewOperationQueue;)V
    .locals 1
    .param p1, "uiUpdater"    # Lcom/facebook/react/uimanager/UIViewOperationQueue;

    .prologue
    .line 58
    invoke-super {p0, p1}, Lcom/facebook/react/uimanager/LayoutShadowNode;->onCollectExtraUpdates(Lcom/facebook/react/uimanager/UIViewOperationQueue;)V

    .line 59
    invoke-direct {p0}, Lcom/facebook/react/views/art/ARTSurfaceViewShadowNode;->drawOutput()V

    .line 60
    invoke-virtual {p0}, Lcom/facebook/react/views/art/ARTSurfaceViewShadowNode;->getReactTag()I

    move-result v0

    invoke-virtual {p1, v0, p0}, Lcom/facebook/react/uimanager/UIViewOperationQueue;->enqueueUpdateExtraData(ILjava/lang/Object;)V

    .line 61
    return-void
.end method

.method public onSurfaceTextureAvailable(Landroid/graphics/SurfaceTexture;II)V
    .locals 1
    .param p1, "surface"    # Landroid/graphics/SurfaceTexture;
    .param p2, "width"    # I
    .param p3, "height"    # I

    .prologue
    .line 103
    new-instance v0, Landroid/view/Surface;

    invoke-direct {v0, p1}, Landroid/view/Surface;-><init>(Landroid/graphics/SurfaceTexture;)V

    iput-object v0, p0, Lcom/facebook/react/views/art/ARTSurfaceViewShadowNode;->mSurface:Landroid/view/Surface;

    .line 104
    invoke-direct {p0}, Lcom/facebook/react/views/art/ARTSurfaceViewShadowNode;->drawOutput()V

    .line 105
    return-void
.end method

.method public onSurfaceTextureDestroyed(Landroid/graphics/SurfaceTexture;)Z
    .locals 1
    .param p1, "surface"    # Landroid/graphics/SurfaceTexture;

    .prologue
    .line 109
    invoke-virtual {p1}, Landroid/graphics/SurfaceTexture;->release()V

    .line 110
    const/4 v0, 0x0

    iput-object v0, p0, Lcom/facebook/react/views/art/ARTSurfaceViewShadowNode;->mSurface:Landroid/view/Surface;

    .line 111
    const/4 v0, 0x1

    return v0
.end method

.method public onSurfaceTextureSizeChanged(Landroid/graphics/SurfaceTexture;II)V
    .locals 0
    .param p1, "surface"    # Landroid/graphics/SurfaceTexture;
    .param p2, "width"    # I
    .param p3, "height"    # I

    .prologue
    .line 115
    return-void
.end method

.method public onSurfaceTextureUpdated(Landroid/graphics/SurfaceTexture;)V
    .locals 0
    .param p1, "surface"    # Landroid/graphics/SurfaceTexture;

    .prologue
    .line 118
    return-void
.end method

.method public setBackgroundColor(Ljava/lang/Integer;)V
    .locals 0
    .param p1, "color"    # Ljava/lang/Integer;
    .annotation runtime Lcom/facebook/react/uimanager/annotations/ReactProp;
        customType = "Color"
        name = "backgroundColor"
    .end annotation

    .prologue
    .line 42
    iput-object p1, p0, Lcom/facebook/react/views/art/ARTSurfaceViewShadowNode;->mBackgroundColor:Ljava/lang/Integer;

    .line 43
    invoke-virtual {p0}, Lcom/facebook/react/views/art/ARTSurfaceViewShadowNode;->markUpdated()V

    .line 44
    return-void
.end method

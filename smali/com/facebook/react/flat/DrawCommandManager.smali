.class abstract Lcom/facebook/react/flat/DrawCommandManager;
.super Ljava/lang/Object;
.source "DrawCommandManager.java"


# direct methods
.method constructor <init>()V
    .locals 0

    .prologue
    .line 25
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method

.method protected static ensureViewHasNoParent(Landroid/view/View;)V
    .locals 4
    .param p0, "view"    # Landroid/view/View;

    .prologue
    .line 139
    invoke-virtual {p0}, Landroid/view/View;->getParent()Landroid/view/ViewParent;

    move-result-object v0

    .line 140
    .local v0, "oldParent":Landroid/view/ViewParent;
    if-eqz v0, :cond_0

    .line 141
    new-instance v1, Ljava/lang/RuntimeException;

    new-instance v2, Ljava/lang/StringBuilder;

    invoke-direct {v2}, Ljava/lang/StringBuilder;-><init>()V

    const-string v3, "Cannot add view "

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2, p0}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    move-result-object v2

    const-string v3, " to DrawCommandManager while it has a parent "

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2, v0}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v2

    invoke-direct {v1, v2}, Ljava/lang/RuntimeException;-><init>(Ljava/lang/String;)V

    throw v1

    .line 144
    :cond_0
    return-void
.end method

.method static getVerticalClippingInstance(Lcom/facebook/react/flat/FlatViewGroup;[Lcom/facebook/react/flat/DrawCommand;)Lcom/facebook/react/flat/DrawCommandManager;
    .locals 1
    .param p0, "flatViewGroup"    # Lcom/facebook/react/flat/FlatViewGroup;
    .param p1, "drawCommands"    # [Lcom/facebook/react/flat/DrawCommand;

    .prologue
    .line 156
    new-instance v0, Lcom/facebook/react/flat/VerticalDrawCommandManager;

    invoke-direct {v0, p0, p1}, Lcom/facebook/react/flat/VerticalDrawCommandManager;-><init>(Lcom/facebook/react/flat/FlatViewGroup;[Lcom/facebook/react/flat/DrawCommand;)V

    return-object v0
.end method


# virtual methods
.method abstract anyNodeRegionWithinBounds(FF)Lcom/facebook/react/flat/NodeRegion;
    .annotation runtime Ljavax/annotation/Nullable;
    .end annotation
.end method

.method abstract debugDraw(Landroid/graphics/Canvas;)V
.end method

.method abstract draw(Landroid/graphics/Canvas;)V
.end method

.method abstract getClippingRect(Landroid/graphics/Rect;)V
.end method

.method abstract getDetachedViews()Landroid/util/SparseArray;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()",
            "Landroid/util/SparseArray",
            "<",
            "Landroid/view/View;",
            ">;"
        }
    .end annotation
.end method

.method abstract mountDrawCommands([Lcom/facebook/react/flat/DrawCommand;Landroid/util/SparseIntArray;[F[FZ)V
.end method

.method abstract mountNodeRegions([Lcom/facebook/react/flat/NodeRegion;[F[F)V
.end method

.method abstract mountViews(Lcom/facebook/react/flat/ViewResolver;[I[I)V
.end method

.method abstract onClippedViewDropped(Landroid/view/View;)V
.end method

.method abstract updateClippingRect()Z
.end method

.method abstract virtualNodeRegionWithinBounds(FF)Lcom/facebook/react/flat/NodeRegion;
    .annotation runtime Ljavax/annotation/Nullable;
    .end annotation
.end method

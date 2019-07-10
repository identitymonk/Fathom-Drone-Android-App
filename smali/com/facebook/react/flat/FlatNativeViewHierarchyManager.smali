.class final Lcom/facebook/react/flat/FlatNativeViewHierarchyManager;
.super Lcom/facebook/react/uimanager/NativeViewHierarchyManager;
.source "FlatNativeViewHierarchyManager.java"

# interfaces
.implements Lcom/facebook/react/flat/ViewResolver;


# direct methods
.method constructor <init>(Lcom/facebook/react/uimanager/ViewManagerRegistry;)V
    .locals 1
    .param p1, "viewManagers"    # Lcom/facebook/react/uimanager/ViewManagerRegistry;

    .prologue
    .line 37
    new-instance v0, Lcom/facebook/react/flat/FlatRootViewManager;

    invoke-direct {v0}, Lcom/facebook/react/flat/FlatRootViewManager;-><init>()V

    invoke-direct {p0, p1, v0}, Lcom/facebook/react/uimanager/NativeViewHierarchyManager;-><init>(Lcom/facebook/react/uimanager/ViewManagerRegistry;Lcom/facebook/react/uimanager/RootViewManager;)V

    .line 38
    return-void
.end method


# virtual methods
.method public addRootView(ILcom/facebook/react/uimanager/SizeMonitoringFrameLayout;Lcom/facebook/react/uimanager/ThemedReactContext;)V
    .locals 1
    .param p1, "tag"    # I
    .param p2, "view"    # Lcom/facebook/react/uimanager/SizeMonitoringFrameLayout;
    .param p3, "themedContext"    # Lcom/facebook/react/uimanager/ThemedReactContext;

    .prologue
    .line 50
    new-instance v0, Lcom/facebook/react/flat/FlatViewGroup;

    invoke-direct {v0, p3}, Lcom/facebook/react/flat/FlatViewGroup;-><init>(Landroid/content/Context;)V

    .line 51
    .local v0, "root":Lcom/facebook/react/flat/FlatViewGroup;
    invoke-virtual {p2, v0}, Lcom/facebook/react/uimanager/SizeMonitoringFrameLayout;->addView(Landroid/view/View;)V

    .line 56
    invoke-virtual {p2, p1}, Lcom/facebook/react/uimanager/SizeMonitoringFrameLayout;->setId(I)V

    .line 58
    invoke-virtual {p0, p1, v0, p3}, Lcom/facebook/react/flat/FlatNativeViewHierarchyManager;->addRootViewGroup(ILandroid/view/ViewGroup;Lcom/facebook/react/uimanager/ThemedReactContext;)V

    .line 59
    return-void
.end method

.method detachAllChildrenFromViews([I)V
    .locals 7
    .param p1, "viewsToDetachAllChildrenFrom"    # [I

    .prologue
    .line 251
    array-length v5, p1

    const/4 v4, 0x0

    :goto_0
    if-ge v4, v5, :cond_1

    aget v3, p1, v4

    .line 252
    .local v3, "viewTag":I
    invoke-virtual {p0, v3}, Lcom/facebook/react/flat/FlatNativeViewHierarchyManager;->resolveView(I)Landroid/view/View;

    move-result-object v0

    .line 253
    .local v0, "view":Landroid/view/View;
    instance-of v6, v0, Lcom/facebook/react/flat/FlatViewGroup;

    if-eqz v6, :cond_0

    .line 254
    check-cast v0, Lcom/facebook/react/flat/FlatViewGroup;

    .end local v0    # "view":Landroid/view/View;
    invoke-virtual {v0}, Lcom/facebook/react/flat/FlatViewGroup;->detachAllViewsFromParent()V

    .line 251
    :goto_1
    add-int/lit8 v4, v4, 0x1

    goto :goto_0

    .restart local v0    # "view":Landroid/view/View;
    :cond_0
    move-object v1, v0

    .line 258
    check-cast v1, Landroid/view/ViewGroup;

    .line 259
    .local v1, "viewGroup":Landroid/view/ViewGroup;
    invoke-virtual {p0, v3}, Lcom/facebook/react/flat/FlatNativeViewHierarchyManager;->resolveViewManager(I)Lcom/facebook/react/uimanager/ViewManager;

    move-result-object v2

    check-cast v2, Lcom/facebook/react/uimanager/ViewGroupManager;

    .line 260
    .local v2, "viewManager":Lcom/facebook/react/uimanager/ViewGroupManager;
    invoke-virtual {v2, v1}, Lcom/facebook/react/uimanager/ViewGroupManager;->removeAllViews(Landroid/view/ViewGroup;)V

    goto :goto_1

    .line 262
    .end local v0    # "view":Landroid/view/View;
    .end local v1    # "viewGroup":Landroid/view/ViewGroup;
    .end local v2    # "viewManager":Lcom/facebook/react/uimanager/ViewGroupManager;
    .end local v3    # "viewTag":I
    :cond_1
    return-void
.end method

.method protected dropView(Landroid/view/View;)V
    .locals 6
    .param p1, "view"    # Landroid/view/View;

    .prologue
    .line 224
    invoke-super {p0, p1}, Lcom/facebook/react/uimanager/NativeViewHierarchyManager;->dropView(Landroid/view/View;)V

    .line 230
    instance-of v5, p1, Lcom/facebook/react/flat/FlatViewGroup;

    if-eqz v5, :cond_0

    move-object v2, p1

    .line 231
    check-cast v2, Lcom/facebook/react/flat/FlatViewGroup;

    .line 232
    .local v2, "flatViewGroup":Lcom/facebook/react/flat/FlatViewGroup;
    invoke-virtual {v2}, Lcom/facebook/react/flat/FlatViewGroup;->getRemoveClippedSubviews()Z

    move-result v5

    if-eqz v5, :cond_0

    .line 233
    invoke-virtual {v2}, Lcom/facebook/react/flat/FlatViewGroup;->getDetachedViews()Landroid/util/SparseArray;

    move-result-object v1

    .line 234
    .local v1, "detachedViews":Landroid/util/SparseArray;, "Landroid/util/SparseArray<Landroid/view/View;>;"
    const/4 v3, 0x0

    .local v3, "i":I
    invoke-virtual {v1}, Landroid/util/SparseArray;->size()I

    move-result v4

    .local v4, "size":I
    :goto_0
    if-ge v3, v4, :cond_0

    .line 235
    invoke-virtual {v1, v3}, Landroid/util/SparseArray;->valueAt(I)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Landroid/view/View;

    .line 237
    .local v0, "detachedChild":Landroid/view/View;
    :try_start_0
    invoke-virtual {p0, v0}, Lcom/facebook/react/flat/FlatNativeViewHierarchyManager;->dropView(Landroid/view/View;)V
    :try_end_0
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_0

    .line 244
    :goto_1
    invoke-virtual {v2, v0}, Lcom/facebook/react/flat/FlatViewGroup;->removeDetachedView(Landroid/view/View;)V

    .line 234
    add-int/lit8 v3, v3, 0x1

    goto :goto_0

    .line 238
    :catch_0
    move-exception v5

    goto :goto_1

    .line 248
    .end local v0    # "detachedChild":Landroid/view/View;
    .end local v1    # "detachedViews":Landroid/util/SparseArray;, "Landroid/util/SparseArray<Landroid/view/View;>;"
    .end local v2    # "flatViewGroup":Lcom/facebook/react/flat/FlatViewGroup;
    .end local v3    # "i":I
    .end local v4    # "size":I
    :cond_0
    return-void
.end method

.method dropViews(Landroid/util/SparseIntArray;)V
    .locals 7
    .param p1, "viewsToDrop"    # Landroid/util/SparseIntArray;

    .prologue
    .line 190
    const/4 v1, 0x0

    .local v1, "i":I
    invoke-virtual {p1}, Landroid/util/SparseIntArray;->size()I

    move-result v0

    .local v0, "count":I
    :goto_0
    if-ge v1, v0, :cond_2

    .line 191
    invoke-virtual {p1, v1}, Landroid/util/SparseIntArray;->keyAt(I)I

    move-result v5

    .line 192
    .local v5, "viewToDrop":I
    const/4 v4, 0x0

    .line 193
    .local v4, "view":Landroid/view/View;
    if-lez v5, :cond_1

    .line 195
    :try_start_0
    invoke-virtual {p0, v5}, Lcom/facebook/react/flat/FlatNativeViewHierarchyManager;->resolveView(I)Landroid/view/View;

    move-result-object v4

    .line 196
    invoke-virtual {p0, v4}, Lcom/facebook/react/flat/FlatNativeViewHierarchyManager;->dropView(Landroid/view/View;)V
    :try_end_0
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_0

    .line 205
    :goto_1
    invoke-virtual {p1, v1}, Landroid/util/SparseIntArray;->valueAt(I)I

    move-result v3

    .line 208
    .local v3, "parentTag":I
    if-lez v3, :cond_0

    if-eqz v4, :cond_0

    invoke-virtual {v4}, Landroid/view/View;->getParent()Landroid/view/ViewParent;

    move-result-object v6

    if-nez v6, :cond_0

    .line 214
    invoke-virtual {p0, v3}, Lcom/facebook/react/flat/FlatNativeViewHierarchyManager;->resolveView(I)Landroid/view/View;

    move-result-object v2

    .line 215
    .local v2, "parent":Landroid/view/View;
    instance-of v6, v2, Lcom/facebook/react/flat/FlatViewGroup;

    if-eqz v6, :cond_0

    .line 216
    check-cast v2, Lcom/facebook/react/flat/FlatViewGroup;

    .end local v2    # "parent":Landroid/view/View;
    invoke-virtual {v2, v4}, Lcom/facebook/react/flat/FlatViewGroup;->onViewDropped(Landroid/view/View;)V

    .line 190
    :cond_0
    add-int/lit8 v1, v1, 0x1

    goto :goto_0

    .line 202
    .end local v3    # "parentTag":I
    :cond_1
    neg-int v6, v5

    invoke-virtual {p0, v6}, Lcom/facebook/react/flat/FlatNativeViewHierarchyManager;->removeRootView(I)V

    goto :goto_1

    .line 220
    .end local v4    # "view":Landroid/view/View;
    .end local v5    # "viewToDrop":I
    :cond_2
    return-void

    .line 197
    .restart local v4    # "view":Landroid/view/View;
    .restart local v5    # "viewToDrop":I
    :catch_0
    move-exception v6

    goto :goto_1
.end method

.method public getView(I)Landroid/view/View;
    .locals 1
    .param p1, "reactTag"    # I

    .prologue
    .line 42
    invoke-super {p0, p1}, Lcom/facebook/react/uimanager/NativeViewHierarchyManager;->resolveView(I)Landroid/view/View;

    move-result-object v0

    return-object v0
.end method

.method setPadding(IIIII)V
    .locals 1
    .param p1, "reactTag"    # I
    .param p2, "paddingLeft"    # I
    .param p3, "paddingTop"    # I
    .param p4, "paddingRight"    # I
    .param p5, "paddingBottom"    # I

    .prologue
    .line 186
    invoke-virtual {p0, p1}, Lcom/facebook/react/flat/FlatNativeViewHierarchyManager;->resolveView(I)Landroid/view/View;

    move-result-object v0

    invoke-virtual {v0, p2, p3, p4, p5}, Landroid/view/View;->setPadding(IIII)V

    .line 187
    return-void
.end method

.method updateClippingMountState(I[Lcom/facebook/react/flat/DrawCommand;Landroid/util/SparseIntArray;[F[F[Lcom/facebook/react/flat/AttachDetachListener;[Lcom/facebook/react/flat/NodeRegion;[F[FZ)V
    .locals 6
    .param p1, "reactTag"    # I
    .param p2, "drawCommands"    # [Lcom/facebook/react/flat/DrawCommand;
        .annotation runtime Ljavax/annotation/Nullable;
        .end annotation
    .end param
    .param p3, "drawViewIndexMap"    # Landroid/util/SparseIntArray;
    .param p4, "commandMaxBot"    # [F
    .param p5, "commandMinTop"    # [F
    .param p6, "listeners"    # [Lcom/facebook/react/flat/AttachDetachListener;
        .annotation runtime Ljavax/annotation/Nullable;
        .end annotation
    .end param
    .param p7, "nodeRegions"    # [Lcom/facebook/react/flat/NodeRegion;
        .annotation runtime Ljavax/annotation/Nullable;
        .end annotation
    .end param
    .param p8, "regionMaxBot"    # [F
    .param p9, "regionMinTop"    # [F
    .param p10, "willMountViews"    # Z

    .prologue
    .line 117
    invoke-virtual {p0, p1}, Lcom/facebook/react/flat/FlatNativeViewHierarchyManager;->resolveView(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Lcom/facebook/react/flat/FlatViewGroup;

    .line 118
    .local v0, "view":Lcom/facebook/react/flat/FlatViewGroup;
    if-eqz p2, :cond_0

    move-object v1, p2

    move-object v2, p3

    move-object v3, p4

    move-object v4, p5

    move/from16 v5, p10

    .line 119
    invoke-virtual/range {v0 .. v5}, Lcom/facebook/react/flat/FlatViewGroup;->mountClippingDrawCommands([Lcom/facebook/react/flat/DrawCommand;Landroid/util/SparseIntArray;[F[FZ)V

    .line 126
    :cond_0
    if-eqz p6, :cond_1

    .line 127
    invoke-virtual {v0, p6}, Lcom/facebook/react/flat/FlatViewGroup;->mountAttachDetachListeners([Lcom/facebook/react/flat/AttachDetachListener;)V

    .line 129
    :cond_1
    if-eqz p7, :cond_2

    .line 130
    invoke-virtual {v0, p7, p8, p9}, Lcom/facebook/react/flat/FlatViewGroup;->mountClippingNodeRegions([Lcom/facebook/react/flat/NodeRegion;[F[F)V

    .line 132
    :cond_2
    return-void
.end method

.method updateMountState(I[Lcom/facebook/react/flat/DrawCommand;[Lcom/facebook/react/flat/AttachDetachListener;[Lcom/facebook/react/flat/NodeRegion;)V
    .locals 1
    .param p1, "reactTag"    # I
    .param p2, "drawCommands"    # [Lcom/facebook/react/flat/DrawCommand;
        .annotation runtime Ljavax/annotation/Nullable;
        .end annotation
    .end param
    .param p3, "listeners"    # [Lcom/facebook/react/flat/AttachDetachListener;
        .annotation runtime Ljavax/annotation/Nullable;
        .end annotation
    .end param
    .param p4, "nodeRegions"    # [Lcom/facebook/react/flat/NodeRegion;
        .annotation runtime Ljavax/annotation/Nullable;
        .end annotation
    .end param

    .prologue
    .line 73
    invoke-virtual {p0, p1}, Lcom/facebook/react/flat/FlatNativeViewHierarchyManager;->resolveView(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Lcom/facebook/react/flat/FlatViewGroup;

    .line 74
    .local v0, "view":Lcom/facebook/react/flat/FlatViewGroup;
    if-eqz p2, :cond_0

    .line 75
    invoke-virtual {v0, p2}, Lcom/facebook/react/flat/FlatViewGroup;->mountDrawCommands([Lcom/facebook/react/flat/DrawCommand;)V

    .line 77
    :cond_0
    if-eqz p3, :cond_1

    .line 78
    invoke-virtual {v0, p3}, Lcom/facebook/react/flat/FlatViewGroup;->mountAttachDetachListeners([Lcom/facebook/react/flat/AttachDetachListener;)V

    .line 80
    :cond_1
    if-eqz p4, :cond_2

    .line 81
    invoke-virtual {v0, p4}, Lcom/facebook/react/flat/FlatViewGroup;->mountNodeRegions([Lcom/facebook/react/flat/NodeRegion;)V

    .line 83
    :cond_2
    return-void
.end method

.method updateViewBounds(IIIII)V
    .locals 5
    .param p1, "reactTag"    # I
    .param p2, "left"    # I
    .param p3, "top"    # I
    .param p4, "right"    # I
    .param p5, "bottom"    # I

    .prologue
    const/high16 v4, 0x40000000    # 2.0f

    .line 164
    invoke-virtual {p0, p1}, Lcom/facebook/react/flat/FlatNativeViewHierarchyManager;->resolveView(I)Landroid/view/View;

    move-result-object v1

    .line 165
    .local v1, "view":Landroid/view/View;
    sub-int v2, p4, p2

    .line 166
    .local v2, "width":I
    sub-int v0, p5, p3

    .line 167
    .local v0, "height":I
    invoke-virtual {v1}, Landroid/view/View;->getWidth()I

    move-result v3

    if-ne v3, v2, :cond_0

    invoke-virtual {v1}, Landroid/view/View;->getHeight()I

    move-result v3

    if-eq v3, v0, :cond_1

    .line 170
    :cond_0
    invoke-static {v2, v4}, Landroid/view/View$MeasureSpec;->makeMeasureSpec(II)I

    move-result v3

    .line 171
    invoke-static {v0, v4}, Landroid/view/View$MeasureSpec;->makeMeasureSpec(II)I

    move-result v4

    .line 169
    invoke-virtual {v1, v3, v4}, Landroid/view/View;->measure(II)V

    .line 172
    invoke-virtual {v1, p2, p3, p4, p5}, Landroid/view/View;->layout(IIII)V

    .line 178
    :goto_0
    return-void

    .line 175
    :cond_1
    invoke-virtual {v1}, Landroid/view/View;->getLeft()I

    move-result v3

    sub-int v3, p2, v3

    invoke-virtual {v1, v3}, Landroid/view/View;->offsetLeftAndRight(I)V

    .line 176
    invoke-virtual {v1}, Landroid/view/View;->getTop()I

    move-result v3

    sub-int v3, p3, v3

    invoke-virtual {v1, v3}, Landroid/view/View;->offsetTopAndBottom(I)V

    goto :goto_0
.end method

.method updateViewGroup(I[I[I)V
    .locals 9
    .param p1, "reactTag"    # I
    .param p2, "viewsToAdd"    # [I
    .param p3, "viewsToDetach"    # [I

    .prologue
    .line 135
    invoke-virtual {p0, p1}, Lcom/facebook/react/flat/FlatNativeViewHierarchyManager;->resolveView(I)Landroid/view/View;

    move-result-object v2

    .line 136
    .local v2, "view":Landroid/view/View;
    instance-of v6, v2, Lcom/facebook/react/flat/FlatViewGroup;

    if-eqz v6, :cond_0

    .line 137
    check-cast v2, Lcom/facebook/react/flat/FlatViewGroup;

    .end local v2    # "view":Landroid/view/View;
    invoke-virtual {v2, p0, p2, p3}, Lcom/facebook/react/flat/FlatViewGroup;->mountViews(Lcom/facebook/react/flat/ViewResolver;[I[I)V

    .line 152
    :goto_0
    return-void

    .restart local v2    # "view":Landroid/view/View;
    :cond_0
    move-object v3, v2

    .line 141
    check-cast v3, Landroid/view/ViewGroup;

    .line 142
    .local v3, "viewGroup":Landroid/view/ViewGroup;
    invoke-virtual {p0, p1}, Lcom/facebook/react/flat/FlatNativeViewHierarchyManager;->resolveViewManager(I)Lcom/facebook/react/uimanager/ViewManager;

    move-result-object v5

    check-cast v5, Lcom/facebook/react/uimanager/ViewGroupManager;

    .line 143
    .local v5, "viewManager":Lcom/facebook/react/uimanager/ViewGroupManager;
    new-instance v0, Ljava/util/ArrayList;

    array-length v6, p2

    invoke-direct {v0, v6}, Ljava/util/ArrayList;-><init>(I)V

    .line 147
    .local v0, "listOfViews":Ljava/util/List;, "Ljava/util/List<Landroid/view/View;>;"
    array-length v7, p2

    const/4 v6, 0x0

    :goto_1
    if-ge v6, v7, :cond_1

    aget v4, p2, v6

    .line 148
    .local v4, "viewIdToAdd":I
    invoke-static {v4}, Ljava/lang/Math;->abs(I)I

    move-result v1

    .line 149
    .local v1, "tag":I
    invoke-virtual {p0, v1}, Lcom/facebook/react/flat/FlatNativeViewHierarchyManager;->resolveView(I)Landroid/view/View;

    move-result-object v8

    invoke-interface {v0, v8}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    .line 147
    add-int/lit8 v6, v6, 0x1

    goto :goto_1

    .line 151
    .end local v1    # "tag":I
    .end local v4    # "viewIdToAdd":I
    :cond_1
    invoke-virtual {v5, v3, v0}, Lcom/facebook/react/uimanager/ViewGroupManager;->addViews(Landroid/view/ViewGroup;Ljava/util/List;)V

    goto :goto_0
.end method

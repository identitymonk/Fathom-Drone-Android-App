.class final Lcom/facebook/react/flat/VerticalDrawCommandManager;
.super Lcom/facebook/react/flat/ClippingDrawCommandManager;
.source "VerticalDrawCommandManager.java"


# direct methods
.method constructor <init>(Lcom/facebook/react/flat/FlatViewGroup;[Lcom/facebook/react/flat/DrawCommand;)V
    .locals 0
    .param p1, "flatViewGroup"    # Lcom/facebook/react/flat/FlatViewGroup;
    .param p2, "drawCommands"    # [Lcom/facebook/react/flat/DrawCommand;

    .prologue
    .line 24
    invoke-direct {p0, p1, p2}, Lcom/facebook/react/flat/ClippingDrawCommandManager;-><init>(Lcom/facebook/react/flat/FlatViewGroup;[Lcom/facebook/react/flat/DrawCommand;)V

    .line 25
    return-void
.end method

.method public static fillMaxMinArrays([Lcom/facebook/react/flat/DrawCommand;[F[FLandroid/util/SparseIntArray;)V
    .locals 4
    .param p0, "commands"    # [Lcom/facebook/react/flat/DrawCommand;
    .param p1, "maxBottom"    # [F
    .param p2, "minTop"    # [F
    .param p3, "drawViewIndexMap"    # Landroid/util/SparseIntArray;

    .prologue
    .line 99
    const/4 v2, 0x0

    .line 102
    .local v2, "last":F
    const/4 v1, 0x0

    .local v1, "i":I
    :goto_0
    array-length v3, p0

    if-ge v1, v3, :cond_1

    .line 103
    aget-object v3, p0, v1

    instance-of v3, v3, Lcom/facebook/react/flat/DrawView;

    if-eqz v3, :cond_0

    .line 104
    aget-object v0, p0, v1

    check-cast v0, Lcom/facebook/react/flat/DrawView;

    .line 106
    .local v0, "drawView":Lcom/facebook/react/flat/DrawView;
    iget v3, v0, Lcom/facebook/react/flat/DrawView;->reactTag:I

    invoke-virtual {p3, v3, v1}, Landroid/util/SparseIntArray;->append(II)V

    .line 107
    iget v3, v0, Lcom/facebook/react/flat/DrawView;->mLogicalBottom:F

    invoke-static {v2, v3}, Ljava/lang/Math;->max(FF)F

    move-result v2

    .line 111
    .end local v0    # "drawView":Lcom/facebook/react/flat/DrawView;
    :goto_1
    aput v2, p1, v1

    .line 102
    add-int/lit8 v1, v1, 0x1

    goto :goto_0

    .line 109
    :cond_0
    aget-object v3, p0, v1

    invoke-virtual {v3}, Lcom/facebook/react/flat/DrawCommand;->getBottom()F

    move-result v3

    invoke-static {v2, v3}, Ljava/lang/Math;->max(FF)F

    move-result v2

    goto :goto_1

    .line 117
    :cond_1
    array-length v3, p0

    add-int/lit8 v1, v3, -0x1

    :goto_2
    if-ltz v1, :cond_3

    .line 118
    aget-object v3, p0, v1

    instance-of v3, v3, Lcom/facebook/react/flat/DrawView;

    if-eqz v3, :cond_2

    .line 119
    aget-object v3, p0, v1

    check-cast v3, Lcom/facebook/react/flat/DrawView;

    iget v3, v3, Lcom/facebook/react/flat/DrawView;->mLogicalTop:F

    invoke-static {v2, v3}, Ljava/lang/Math;->min(FF)F

    move-result v2

    .line 123
    :goto_3
    aput v2, p2, v1

    .line 117
    add-int/lit8 v1, v1, -0x1

    goto :goto_2

    .line 121
    :cond_2
    aget-object v3, p0, v1

    invoke-virtual {v3}, Lcom/facebook/react/flat/DrawCommand;->getTop()F

    move-result v3

    invoke-static {v2, v3}, Ljava/lang/Math;->min(FF)F

    move-result v2

    goto :goto_3

    .line 125
    :cond_3
    return-void
.end method

.method public static fillMaxMinArrays([Lcom/facebook/react/flat/NodeRegion;[F[F)V
    .locals 3
    .param p0, "regions"    # [Lcom/facebook/react/flat/NodeRegion;
    .param p1, "maxBottom"    # [F
    .param p2, "minTop"    # [F

    .prologue
    .line 71
    const/4 v1, 0x0

    .line 72
    .local v1, "last":F
    const/4 v0, 0x0

    .local v0, "i":I
    :goto_0
    array-length v2, p0

    if-ge v0, v2, :cond_0

    .line 73
    aget-object v2, p0, v0

    invoke-virtual {v2}, Lcom/facebook/react/flat/NodeRegion;->getTouchableBottom()F

    move-result v2

    invoke-static {v1, v2}, Ljava/lang/Math;->max(FF)F

    move-result v1

    .line 74
    aput v1, p1, v0

    .line 72
    add-int/lit8 v0, v0, 0x1

    goto :goto_0

    .line 76
    :cond_0
    array-length v2, p0

    add-int/lit8 v0, v2, -0x1

    :goto_1
    if-ltz v0, :cond_1

    .line 77
    aget-object v2, p0, v0

    invoke-virtual {v2}, Lcom/facebook/react/flat/NodeRegion;->getTouchableTop()F

    move-result v2

    invoke-static {v1, v2}, Ljava/lang/Math;->min(FF)F

    move-result v1

    .line 78
    aput v1, p2, v0

    .line 76
    add-int/lit8 v0, v0, -0x1

    goto :goto_1

    .line 80
    :cond_1
    return-void
.end method


# virtual methods
.method commandStartIndex()I
    .locals 3

    .prologue
    .line 29
    iget-object v1, p0, Lcom/facebook/react/flat/VerticalDrawCommandManager;->mCommandMaxBottom:[F

    iget-object v2, p0, Lcom/facebook/react/flat/VerticalDrawCommandManager;->mClippingRect:Landroid/graphics/Rect;

    iget v2, v2, Landroid/graphics/Rect;->top:I

    int-to-float v2, v2

    invoke-static {v1, v2}, Ljava/util/Arrays;->binarySearch([FF)I

    move-result v0

    .line 32
    .local v0, "start":I
    if-gez v0, :cond_0

    xor-int/lit8 v0, v0, -0x1

    .end local v0    # "start":I
    :cond_0
    return v0
.end method

.method commandStopIndex(I)I
    .locals 4
    .param p1, "start"    # I

    .prologue
    .line 37
    iget-object v1, p0, Lcom/facebook/react/flat/VerticalDrawCommandManager;->mCommandMinTop:[F

    iget-object v2, p0, Lcom/facebook/react/flat/VerticalDrawCommandManager;->mCommandMinTop:[F

    array-length v2, v2

    iget-object v3, p0, Lcom/facebook/react/flat/VerticalDrawCommandManager;->mClippingRect:Landroid/graphics/Rect;

    iget v3, v3, Landroid/graphics/Rect;->bottom:I

    int-to-float v3, v3

    invoke-static {v1, p1, v2, v3}, Ljava/util/Arrays;->binarySearch([FIIF)I

    move-result v0

    .line 44
    .local v0, "stop":I
    if-gez v0, :cond_0

    xor-int/lit8 v0, v0, -0x1

    .end local v0    # "stop":I
    :cond_0
    return v0
.end method

.method regionAboveTouch(IFF)Z
    .locals 1
    .param p1, "index"    # I
    .param p2, "touchX"    # F
    .param p3, "touchY"    # F

    .prologue
    .line 57
    iget-object v0, p0, Lcom/facebook/react/flat/VerticalDrawCommandManager;->mRegionMaxBottom:[F

    aget v0, v0, p1

    cmpg-float v0, v0, p3

    if-gez v0, :cond_0

    const/4 v0, 0x1

    :goto_0
    return v0

    :cond_0
    const/4 v0, 0x0

    goto :goto_0
.end method

.method regionStopIndex(FF)I
    .locals 3
    .param p1, "touchX"    # F
    .param p2, "touchY"    # F

    .prologue
    .line 49
    iget-object v1, p0, Lcom/facebook/react/flat/VerticalDrawCommandManager;->mRegionMinTop:[F

    const v2, 0x38d1b717    # 1.0E-4f

    add-float/2addr v2, p2

    invoke-static {v1, v2}, Ljava/util/Arrays;->binarySearch([FF)I

    move-result v0

    .line 52
    .local v0, "stop":I
    if-gez v0, :cond_0

    xor-int/lit8 v0, v0, -0x1

    .end local v0    # "stop":I
    :cond_0
    return v0
.end method

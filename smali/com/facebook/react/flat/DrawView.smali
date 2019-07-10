.class final Lcom/facebook/react/flat/DrawView;
.super Lcom/facebook/react/flat/AbstractDrawCommand;
.source "DrawView.java"


# static fields
.field public static final EMPTY_ARRAY:[Lcom/facebook/react/flat/DrawView;

.field static final MINIMUM_ROUNDED_CLIPPING_VALUE:F = 0.5f


# instance fields
.field private final TMP_RECT:Landroid/graphics/RectF;

.field private mClipRadius:F

.field mLogicalBottom:F

.field mLogicalLeft:F

.field mLogicalRight:F

.field mLogicalTop:F

.field private mPath:Landroid/graphics/Path;
    .annotation runtime Ljavax/annotation/Nullable;
    .end annotation
.end field

.field mWasMounted:Z

.field final reactTag:I


# direct methods
.method static constructor <clinit>()V
    .locals 1

    .prologue
    .line 19
    const/4 v0, 0x0

    new-array v0, v0, [Lcom/facebook/react/flat/DrawView;

    sput-object v0, Lcom/facebook/react/flat/DrawView;->EMPTY_ARRAY:[Lcom/facebook/react/flat/DrawView;

    return-void
.end method

.method public constructor <init>(I)V
    .locals 1
    .param p1, "reactTag"    # I

    .prologue
    .line 50
    invoke-direct {p0}, Lcom/facebook/react/flat/AbstractDrawCommand;-><init>()V

    .line 22
    new-instance v0, Landroid/graphics/RectF;

    invoke-direct {v0}, Landroid/graphics/RectF;-><init>()V

    iput-object v0, p0, Lcom/facebook/react/flat/DrawView;->TMP_RECT:Landroid/graphics/RectF;

    .line 51
    iput p1, p0, Lcom/facebook/react/flat/DrawView;->reactTag:I

    .line 52
    return-void
.end method

.method private logicalBoundsMatch(FFFF)Z
    .locals 1
    .param p1, "left"    # F
    .param p2, "top"    # F
    .param p3, "right"    # F
    .param p4, "bottom"    # F

    .prologue
    .line 126
    iget v0, p0, Lcom/facebook/react/flat/DrawView;->mLogicalLeft:F

    cmpl-float v0, p1, v0

    if-nez v0, :cond_0

    iget v0, p0, Lcom/facebook/react/flat/DrawView;->mLogicalTop:F

    cmpl-float v0, p2, v0

    if-nez v0, :cond_0

    iget v0, p0, Lcom/facebook/react/flat/DrawView;->mLogicalRight:F

    cmpl-float v0, p3, v0

    if-nez v0, :cond_0

    iget v0, p0, Lcom/facebook/react/flat/DrawView;->mLogicalBottom:F

    cmpl-float v0, p4, v0

    if-nez v0, :cond_0

    const/4 v0, 0x1

    :goto_0
    return v0

    :cond_0
    const/4 v0, 0x0

    goto :goto_0
.end method

.method private setLogicalBounds(FFFF)V
    .locals 0
    .param p1, "left"    # F
    .param p2, "top"    # F
    .param p3, "right"    # F
    .param p4, "bottom"    # F

    .prologue
    .line 132
    iput p1, p0, Lcom/facebook/react/flat/DrawView;->mLogicalLeft:F

    .line 133
    iput p2, p0, Lcom/facebook/react/flat/DrawView;->mLogicalTop:F

    .line 134
    iput p3, p0, Lcom/facebook/react/flat/DrawView;->mLogicalRight:F

    .line 135
    iput p4, p0, Lcom/facebook/react/flat/DrawView;->mLogicalBottom:F

    .line 136
    return-void
.end method

.method private updateClipPath()V
    .locals 5

    .prologue
    .line 171
    new-instance v0, Landroid/graphics/Path;

    invoke-direct {v0}, Landroid/graphics/Path;-><init>()V

    iput-object v0, p0, Lcom/facebook/react/flat/DrawView;->mPath:Landroid/graphics/Path;

    .line 173
    iget-object v0, p0, Lcom/facebook/react/flat/DrawView;->TMP_RECT:Landroid/graphics/RectF;

    .line 174
    invoke-virtual {p0}, Lcom/facebook/react/flat/DrawView;->getLeft()F

    move-result v1

    .line 175
    invoke-virtual {p0}, Lcom/facebook/react/flat/DrawView;->getTop()F

    move-result v2

    .line 176
    invoke-virtual {p0}, Lcom/facebook/react/flat/DrawView;->getRight()F

    move-result v3

    .line 177
    invoke-virtual {p0}, Lcom/facebook/react/flat/DrawView;->getBottom()F

    move-result v4

    .line 173
    invoke-virtual {v0, v1, v2, v3, v4}, Landroid/graphics/RectF;->set(FFFF)V

    .line 180
    iget-object v0, p0, Lcom/facebook/react/flat/DrawView;->mPath:Landroid/graphics/Path;

    iget-object v1, p0, Lcom/facebook/react/flat/DrawView;->TMP_RECT:Landroid/graphics/RectF;

    iget v2, p0, Lcom/facebook/react/flat/DrawView;->mClipRadius:F

    iget v3, p0, Lcom/facebook/react/flat/DrawView;->mClipRadius:F

    sget-object v4, Landroid/graphics/Path$Direction;->CW:Landroid/graphics/Path$Direction;

    invoke-virtual {v0, v1, v2, v3, v4}, Landroid/graphics/Path;->addRoundRect(Landroid/graphics/RectF;FFLandroid/graphics/Path$Direction;)V

    .line 185
    return-void
.end method


# virtual methods
.method protected applyClipping(Landroid/graphics/Canvas;)V
    .locals 2
    .param p1, "canvas"    # Landroid/graphics/Canvas;

    .prologue
    .line 191
    iget v0, p0, Lcom/facebook/react/flat/DrawView;->mClipRadius:F

    const/high16 v1, 0x3f000000    # 0.5f

    cmpl-float v0, v0, v1

    if-lez v0, :cond_0

    .line 192
    iget-object v0, p0, Lcom/facebook/react/flat/DrawView;->mPath:Landroid/graphics/Path;

    invoke-virtual {p1, v0}, Landroid/graphics/Canvas;->clipPath(Landroid/graphics/Path;)Z

    .line 196
    :goto_0
    return-void

    .line 194
    :cond_0
    invoke-super {p0, p1}, Lcom/facebook/react/flat/AbstractDrawCommand;->applyClipping(Landroid/graphics/Canvas;)V

    goto :goto_0
.end method

.method public collectDrawView(FFFFFFFFFFFFF)Lcom/facebook/react/flat/DrawView;
    .locals 10
    .param p1, "left"    # F
    .param p2, "top"    # F
    .param p3, "right"    # F
    .param p4, "bottom"    # F
    .param p5, "logicalLeft"    # F
    .param p6, "logicalTop"    # F
    .param p7, "logicalRight"    # F
    .param p8, "logicalBottom"    # F
    .param p9, "clipLeft"    # F
    .param p10, "clipTop"    # F
    .param p11, "clipRight"    # F
    .param p12, "clipBottom"    # F
    .param p13, "clipRadius"    # F

    .prologue
    .line 75
    invoke-virtual {p0}, Lcom/facebook/react/flat/DrawView;->isFrozen()Z

    move-result v9

    if-nez v9, :cond_1

    .line 77
    invoke-virtual {p0, p1, p2, p3, p4}, Lcom/facebook/react/flat/DrawView;->setBounds(FFFF)V

    .line 78
    move/from16 v0, p9

    move/from16 v1, p10

    move/from16 v2, p11

    move/from16 v3, p12

    invoke-virtual {p0, v0, v1, v2, v3}, Lcom/facebook/react/flat/DrawView;->setClipBounds(FFFF)V

    .line 79
    move/from16 v0, p13

    invoke-virtual {p0, v0}, Lcom/facebook/react/flat/DrawView;->setClipRadius(F)V

    .line 80
    move/from16 v0, p6

    move/from16 v1, p7

    move/from16 v2, p8

    invoke-direct {p0, p5, v0, v1, v2}, Lcom/facebook/react/flat/DrawView;->setLogicalBounds(FFFF)V

    .line 81
    invoke-virtual {p0}, Lcom/facebook/react/flat/DrawView;->freeze()V

    .line 122
    .end local p0    # "this":Lcom/facebook/react/flat/DrawView;
    :cond_0
    :goto_0
    return-object p0

    .line 85
    .restart local p0    # "this":Lcom/facebook/react/flat/DrawView;
    :cond_1
    invoke-virtual {p0, p1, p2, p3, p4}, Lcom/facebook/react/flat/DrawView;->boundsMatch(FFFF)Z

    move-result v4

    .line 86
    .local v4, "boundsMatch":Z
    move/from16 v0, p9

    move/from16 v1, p10

    move/from16 v2, p11

    move/from16 v3, p12

    invoke-virtual {p0, v0, v1, v2, v3}, Lcom/facebook/react/flat/DrawView;->clipBoundsMatch(FFFF)Z

    move-result v5

    .line 87
    .local v5, "clipBoundsMatch":Z
    iget v9, p0, Lcom/facebook/react/flat/DrawView;->mClipRadius:F

    cmpl-float v9, v9, p13

    if-nez v9, :cond_8

    const/4 v6, 0x1

    .line 89
    .local v6, "clipRadiusMatch":Z
    :goto_1
    move/from16 v0, p6

    move/from16 v1, p7

    move/from16 v2, p8

    invoke-direct {p0, p5, v0, v1, v2}, Lcom/facebook/react/flat/DrawView;->logicalBoundsMatch(FFFF)Z

    move-result v8

    .line 92
    .local v8, "logicalBoundsMatch":Z
    if-eqz v4, :cond_2

    if-eqz v5, :cond_2

    if-eqz v6, :cond_2

    if-nez v8, :cond_0

    .line 96
    :cond_2
    invoke-virtual {p0}, Lcom/facebook/react/flat/DrawView;->mutableCopy()Lcom/facebook/react/flat/AbstractDrawCommand;

    move-result-object v7

    check-cast v7, Lcom/facebook/react/flat/DrawView;

    .line 98
    .local v7, "drawView":Lcom/facebook/react/flat/DrawView;
    if-nez v4, :cond_3

    .line 99
    invoke-virtual {v7, p1, p2, p3, p4}, Lcom/facebook/react/flat/DrawView;->setBounds(FFFF)V

    .line 102
    :cond_3
    if-nez v5, :cond_4

    .line 103
    move/from16 v0, p9

    move/from16 v1, p10

    move/from16 v2, p11

    move/from16 v3, p12

    invoke-virtual {v7, v0, v1, v2, v3}, Lcom/facebook/react/flat/DrawView;->setClipBounds(FFFF)V

    .line 106
    :cond_4
    if-nez v8, :cond_5

    .line 107
    move/from16 v0, p6

    move/from16 v1, p7

    move/from16 v2, p8

    invoke-direct {v7, p5, v0, v1, v2}, Lcom/facebook/react/flat/DrawView;->setLogicalBounds(FFFF)V

    .line 110
    :cond_5
    if-eqz v6, :cond_6

    if-nez v4, :cond_7

    .line 112
    :cond_6
    move/from16 v0, p13

    invoke-virtual {v7, v0}, Lcom/facebook/react/flat/DrawView;->setClipRadius(F)V

    .line 118
    :cond_7
    const/4 v9, 0x0

    iput-boolean v9, v7, Lcom/facebook/react/flat/DrawView;->mWasMounted:Z

    .line 120
    invoke-virtual {v7}, Lcom/facebook/react/flat/DrawView;->freeze()V

    move-object p0, v7

    .line 122
    goto :goto_0

    .line 87
    .end local v6    # "clipRadiusMatch":Z
    .end local v7    # "drawView":Lcom/facebook/react/flat/DrawView;
    .end local v8    # "logicalBoundsMatch":Z
    :cond_8
    const/4 v6, 0x0

    goto :goto_1
.end method

.method public draw(Lcom/facebook/react/flat/FlatViewGroup;Landroid/graphics/Canvas;)V
    .locals 2
    .param p1, "parent"    # Lcom/facebook/react/flat/FlatViewGroup;
    .param p2, "canvas"    # Landroid/graphics/Canvas;

    .prologue
    .line 140
    invoke-virtual {p0, p1, p2}, Lcom/facebook/react/flat/DrawView;->onPreDraw(Lcom/facebook/react/flat/FlatViewGroup;Landroid/graphics/Canvas;)V

    .line 141
    iget-boolean v0, p0, Lcom/facebook/react/flat/DrawView;->mNeedsClipping:Z

    if-nez v0, :cond_0

    iget v0, p0, Lcom/facebook/react/flat/DrawView;->mClipRadius:F

    const/high16 v1, 0x3f000000    # 0.5f

    cmpl-float v0, v0, v1

    if-lez v0, :cond_1

    .line 142
    :cond_0
    const/4 v0, 0x2

    invoke-virtual {p2, v0}, Landroid/graphics/Canvas;->save(I)I

    .line 143
    invoke-virtual {p0, p2}, Lcom/facebook/react/flat/DrawView;->applyClipping(Landroid/graphics/Canvas;)V

    .line 144
    invoke-virtual {p1, p2}, Lcom/facebook/react/flat/FlatViewGroup;->drawNextChild(Landroid/graphics/Canvas;)V

    .line 145
    invoke-virtual {p2}, Landroid/graphics/Canvas;->restore()V

    .line 149
    :goto_0
    return-void

    .line 147
    :cond_1
    invoke-virtual {p1, p2}, Lcom/facebook/react/flat/FlatViewGroup;->drawNextChild(Landroid/graphics/Canvas;)V

    goto :goto_0
.end method

.method protected onDebugDraw(Lcom/facebook/react/flat/FlatViewGroup;Landroid/graphics/Canvas;)V
    .locals 0
    .param p1, "parent"    # Lcom/facebook/react/flat/FlatViewGroup;
    .param p2, "canvas"    # Landroid/graphics/Canvas;

    .prologue
    .line 205
    invoke-virtual {p1, p2}, Lcom/facebook/react/flat/FlatViewGroup;->debugDrawNextChild(Landroid/graphics/Canvas;)V

    .line 206
    return-void
.end method

.method protected onDebugDrawHighlight(Landroid/graphics/Canvas;)V
    .locals 10
    .param p1, "canvas"    # Landroid/graphics/Canvas;

    .prologue
    const/4 v9, 0x4

    .line 210
    iget-object v5, p0, Lcom/facebook/react/flat/DrawView;->mPath:Landroid/graphics/Path;

    if-eqz v5, :cond_1

    .line 211
    new-instance v5, Ljava/lang/StringBuilder;

    invoke-direct {v5}, Ljava/lang/StringBuilder;-><init>()V

    const-string v6, "borderRadius: "

    invoke-virtual {v5, v6}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v5

    iget v6, p0, Lcom/facebook/react/flat/DrawView;->mClipRadius:F

    invoke-virtual {v5, v6}, Ljava/lang/StringBuilder;->append(F)Ljava/lang/StringBuilder;

    move-result-object v5

    invoke-virtual {v5}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v5

    invoke-virtual {p0, p1, v5}, Lcom/facebook/react/flat/DrawView;->debugDrawWarningHighlight(Landroid/graphics/Canvas;Ljava/lang/String;)V

    .line 234
    :cond_0
    :goto_0
    return-void

    .line 212
    :cond_1
    iget v5, p0, Lcom/facebook/react/flat/DrawView;->mLogicalLeft:F

    iget v6, p0, Lcom/facebook/react/flat/DrawView;->mLogicalTop:F

    iget v7, p0, Lcom/facebook/react/flat/DrawView;->mLogicalRight:F

    iget v8, p0, Lcom/facebook/react/flat/DrawView;->mLogicalBottom:F

    invoke-virtual {p0, v5, v6, v7, v8}, Lcom/facebook/react/flat/DrawView;->boundsMatch(FFFF)Z

    move-result v5

    if-nez v5, :cond_0

    .line 213
    new-instance v4, Ljava/lang/StringBuilder;

    const-string v5, "Overflow: { "

    invoke-direct {v4, v5}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    .line 214
    .local v4, "warn":Ljava/lang/StringBuilder;
    new-array v2, v9, [Ljava/lang/String;

    const/4 v5, 0x0

    const-string v6, "left: "

    aput-object v6, v2, v5

    const/4 v5, 0x1

    const-string v6, "top: "

    aput-object v6, v2, v5

    const/4 v5, 0x2

    const-string v6, "right: "

    aput-object v6, v2, v5

    const/4 v5, 0x3

    const-string v6, "bottom: "

    aput-object v6, v2, v5

    .line 215
    .local v2, "names":[Ljava/lang/String;
    const/4 v0, 0x0

    .line 216
    .local v0, "i":I
    new-array v3, v9, [F

    .line 217
    .local v3, "offsets":[F
    add-int/lit8 v1, v0, 0x1

    .end local v0    # "i":I
    .local v1, "i":I
    invoke-virtual {p0}, Lcom/facebook/react/flat/DrawView;->getLeft()F

    move-result v5

    iget v6, p0, Lcom/facebook/react/flat/DrawView;->mLogicalLeft:F

    sub-float/2addr v5, v6

    aput v5, v3, v0

    .line 218
    add-int/lit8 v0, v1, 0x1

    .end local v1    # "i":I
    .restart local v0    # "i":I
    invoke-virtual {p0}, Lcom/facebook/react/flat/DrawView;->getTop()F

    move-result v5

    iget v6, p0, Lcom/facebook/react/flat/DrawView;->mLogicalTop:F

    sub-float/2addr v5, v6

    aput v5, v3, v1

    .line 219
    add-int/lit8 v1, v0, 0x1

    .end local v0    # "i":I
    .restart local v1    # "i":I
    iget v5, p0, Lcom/facebook/react/flat/DrawView;->mLogicalRight:F

    invoke-virtual {p0}, Lcom/facebook/react/flat/DrawView;->getRight()F

    move-result v6

    sub-float/2addr v5, v6

    aput v5, v3, v0

    .line 220
    add-int/lit8 v0, v1, 0x1

    .end local v1    # "i":I
    .restart local v0    # "i":I
    iget v5, p0, Lcom/facebook/react/flat/DrawView;->mLogicalBottom:F

    invoke-virtual {p0}, Lcom/facebook/react/flat/DrawView;->getBottom()F

    move-result v6

    sub-float/2addr v5, v6

    aput v5, v3, v1

    .line 222
    const/4 v0, 0x0

    :goto_1
    if-ge v0, v9, :cond_3

    .line 223
    aget v5, v3, v0

    const/4 v6, 0x0

    cmpl-float v5, v5, v6

    if-eqz v5, :cond_2

    .line 224
    aget-object v5, v2, v0

    invoke-virtual {v4, v5}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    .line 225
    aget v5, v3, v0

    invoke-virtual {v4, v5}, Ljava/lang/StringBuilder;->append(F)Ljava/lang/StringBuilder;

    .line 226
    const-string v5, ", "

    invoke-virtual {v4, v5}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    .line 222
    :cond_2
    add-int/lit8 v0, v0, 0x1

    goto :goto_1

    .line 230
    :cond_3
    const-string v5, "}"

    invoke-virtual {v4, v5}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    .line 232
    invoke-virtual {v4}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v5

    invoke-virtual {p0, p1, v5}, Lcom/facebook/react/flat/DrawView;->debugDrawCautionHighlight(Landroid/graphics/Canvas;Ljava/lang/String;)V

    goto/16 :goto_0
.end method

.method protected onDraw(Landroid/graphics/Canvas;)V
    .locals 0
    .param p1, "canvas"    # Landroid/graphics/Canvas;

    .prologue
    .line 201
    return-void
.end method

.method setClipRadius(F)V
    .locals 1
    .param p1, "clipRadius"    # F

    .prologue
    .line 158
    iput p1, p0, Lcom/facebook/react/flat/DrawView;->mClipRadius:F

    .line 159
    const/high16 v0, 0x3f000000    # 0.5f

    cmpl-float v0, p1, v0

    if-lez v0, :cond_0

    .line 161
    invoke-direct {p0}, Lcom/facebook/react/flat/DrawView;->updateClipPath()V

    .line 165
    :goto_0
    return-void

    .line 163
    :cond_0
    const/4 v0, 0x0

    iput-object v0, p0, Lcom/facebook/react/flat/DrawView;->mPath:Landroid/graphics/Path;

    goto :goto_0
.end method

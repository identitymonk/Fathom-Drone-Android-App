.class public Lcom/facebook/react/views/art/ARTShapeShadowNode;
.super Lcom/facebook/react/views/art/ARTVirtualNode;
.source "ARTShapeShadowNode.java"


# static fields
.field private static final CAP_BUTT:I = 0x0

.field private static final CAP_ROUND:I = 0x1

.field private static final CAP_SQUARE:I = 0x2

.field private static final COLOR_TYPE_LINEAR_GRADIENT:I = 0x1

.field private static final COLOR_TYPE_PATTERN:I = 0x3

.field private static final COLOR_TYPE_RADIAL_GRADIENT:I = 0x2

.field private static final COLOR_TYPE_SOLID_COLOR:I = 0x0

.field private static final JOIN_BEVEL:I = 0x2

.field private static final JOIN_MITER:I = 0x0

.field private static final JOIN_ROUND:I = 0x1

.field private static final PATH_TYPE_ARC:I = 0x4

.field private static final PATH_TYPE_CLOSE:I = 0x1

.field private static final PATH_TYPE_CURVETO:I = 0x3

.field private static final PATH_TYPE_LINETO:I = 0x2

.field private static final PATH_TYPE_MOVETO:I


# instance fields
.field private mBrushData:[F
    .annotation runtime Ljavax/annotation/Nullable;
    .end annotation
.end field

.field protected mPath:Landroid/graphics/Path;
    .annotation runtime Ljavax/annotation/Nullable;
    .end annotation
.end field

.field private mStrokeCap:I

.field private mStrokeColor:[F
    .annotation runtime Ljavax/annotation/Nullable;
    .end annotation
.end field

.field private mStrokeDash:[F
    .annotation runtime Ljavax/annotation/Nullable;
    .end annotation
.end field

.field private mStrokeJoin:I

.field private mStrokeWidth:F


# direct methods
.method public constructor <init>()V
    .locals 2

    .prologue
    const/4 v1, 0x1

    .line 32
    invoke-direct {p0}, Lcom/facebook/react/views/art/ARTVirtualNode;-><init>()V

    .line 59
    const/high16 v0, 0x3f800000    # 1.0f

    iput v0, p0, Lcom/facebook/react/views/art/ARTShapeShadowNode;->mStrokeWidth:F

    .line 60
    iput v1, p0, Lcom/facebook/react/views/art/ARTShapeShadowNode;->mStrokeCap:I

    .line 61
    iput v1, p0, Lcom/facebook/react/views/art/ARTShapeShadowNode;->mStrokeJoin:I

    return-void
.end method

.method private createPath([F)Landroid/graphics/Path;
    .locals 21
    .param p1, "data"    # [F

    .prologue
    .line 267
    new-instance v2, Landroid/graphics/Path;

    invoke-direct {v2}, Landroid/graphics/Path;-><init>()V

    .line 268
    .local v2, "path":Landroid/graphics/Path;
    const/4 v3, 0x0

    const/4 v4, 0x0

    invoke-virtual {v2, v3, v4}, Landroid/graphics/Path;->moveTo(FF)V

    .line 269
    const/4 v11, 0x0

    .line 270
    .local v11, "i":I
    :goto_0
    move-object/from16 v0, p1

    array-length v3, v0

    if-ge v11, v3, :cond_4

    .line 271
    add-int/lit8 v12, v11, 0x1

    .end local v11    # "i":I
    .local v12, "i":I
    aget v3, p1, v11

    float-to-int v0, v3

    move/from16 v17, v0

    .line 272
    .local v17, "type":I
    packed-switch v17, :pswitch_data_0

    .line 316
    new-instance v3, Lcom/facebook/react/bridge/JSApplicationIllegalArgumentException;

    new-instance v4, Ljava/lang/StringBuilder;

    invoke-direct {v4}, Ljava/lang/StringBuilder;-><init>()V

    const-string v5, "Unrecognized drawing instruction "

    invoke-virtual {v4, v5}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v4

    move/from16 v0, v17

    invoke-virtual {v4, v0}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v4

    invoke-virtual {v4}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v4

    invoke-direct {v3, v4}, Lcom/facebook/react/bridge/JSApplicationIllegalArgumentException;-><init>(Ljava/lang/String;)V

    throw v3

    .line 274
    :pswitch_0
    add-int/lit8 v11, v12, 0x1

    .end local v12    # "i":I
    .restart local v11    # "i":I
    aget v3, p1, v12

    move-object/from16 v0, p0

    iget v4, v0, Lcom/facebook/react/views/art/ARTShapeShadowNode;->mScale:F

    mul-float/2addr v3, v4

    add-int/lit8 v12, v11, 0x1

    .end local v11    # "i":I
    .restart local v12    # "i":I
    aget v4, p1, v11

    move-object/from16 v0, p0

    iget v5, v0, Lcom/facebook/react/views/art/ARTShapeShadowNode;->mScale:F

    mul-float/2addr v4, v5

    invoke-virtual {v2, v3, v4}, Landroid/graphics/Path;->moveTo(FF)V

    move v11, v12

    .line 275
    .end local v12    # "i":I
    .restart local v11    # "i":I
    goto :goto_0

    .line 277
    .end local v11    # "i":I
    .restart local v12    # "i":I
    :pswitch_1
    invoke-virtual {v2}, Landroid/graphics/Path;->close()V

    move v11, v12

    .line 278
    .end local v12    # "i":I
    .restart local v11    # "i":I
    goto :goto_0

    .line 280
    .end local v11    # "i":I
    .restart local v12    # "i":I
    :pswitch_2
    add-int/lit8 v11, v12, 0x1

    .end local v12    # "i":I
    .restart local v11    # "i":I
    aget v3, p1, v12

    move-object/from16 v0, p0

    iget v4, v0, Lcom/facebook/react/views/art/ARTShapeShadowNode;->mScale:F

    mul-float/2addr v3, v4

    add-int/lit8 v12, v11, 0x1

    .end local v11    # "i":I
    .restart local v12    # "i":I
    aget v4, p1, v11

    move-object/from16 v0, p0

    iget v5, v0, Lcom/facebook/react/views/art/ARTShapeShadowNode;->mScale:F

    mul-float/2addr v4, v5

    invoke-virtual {v2, v3, v4}, Landroid/graphics/Path;->lineTo(FF)V

    move v11, v12

    .line 281
    .end local v12    # "i":I
    .restart local v11    # "i":I
    goto :goto_0

    .line 283
    .end local v11    # "i":I
    .restart local v12    # "i":I
    :pswitch_3
    add-int/lit8 v11, v12, 0x1

    .end local v12    # "i":I
    .restart local v11    # "i":I
    aget v3, p1, v12

    move-object/from16 v0, p0

    iget v4, v0, Lcom/facebook/react/views/art/ARTShapeShadowNode;->mScale:F

    mul-float/2addr v3, v4

    add-int/lit8 v12, v11, 0x1

    .end local v11    # "i":I
    .restart local v12    # "i":I
    aget v4, p1, v11

    move-object/from16 v0, p0

    iget v5, v0, Lcom/facebook/react/views/art/ARTShapeShadowNode;->mScale:F

    mul-float/2addr v4, v5

    add-int/lit8 v11, v12, 0x1

    .end local v12    # "i":I
    .restart local v11    # "i":I
    aget v5, p1, v12

    move-object/from16 v0, p0

    iget v6, v0, Lcom/facebook/react/views/art/ARTShapeShadowNode;->mScale:F

    mul-float/2addr v5, v6

    add-int/lit8 v12, v11, 0x1

    .end local v11    # "i":I
    .restart local v12    # "i":I
    aget v6, p1, v11

    move-object/from16 v0, p0

    iget v7, v0, Lcom/facebook/react/views/art/ARTShapeShadowNode;->mScale:F

    mul-float/2addr v6, v7

    add-int/lit8 v11, v12, 0x1

    .end local v12    # "i":I
    .restart local v11    # "i":I
    aget v7, p1, v12

    move-object/from16 v0, p0

    iget v8, v0, Lcom/facebook/react/views/art/ARTShapeShadowNode;->mScale:F

    mul-float/2addr v7, v8

    add-int/lit8 v12, v11, 0x1

    .end local v11    # "i":I
    .restart local v12    # "i":I
    aget v8, p1, v11

    move-object/from16 v0, p0

    iget v0, v0, Lcom/facebook/react/views/art/ARTShapeShadowNode;->mScale:F

    move/from16 v20, v0

    mul-float v8, v8, v20

    invoke-virtual/range {v2 .. v8}, Landroid/graphics/Path;->cubicTo(FFFFFF)V

    move v11, v12

    .line 290
    .end local v12    # "i":I
    .restart local v11    # "i":I
    goto/16 :goto_0

    .line 293
    .end local v11    # "i":I
    .restart local v12    # "i":I
    :pswitch_4
    add-int/lit8 v11, v12, 0x1

    .end local v12    # "i":I
    .restart local v11    # "i":I
    aget v3, p1, v12

    move-object/from16 v0, p0

    iget v4, v0, Lcom/facebook/react/views/art/ARTShapeShadowNode;->mScale:F

    mul-float v18, v3, v4

    .line 294
    .local v18, "x":F
    add-int/lit8 v12, v11, 0x1

    .end local v11    # "i":I
    .restart local v12    # "i":I
    aget v3, p1, v11

    move-object/from16 v0, p0

    iget v4, v0, Lcom/facebook/react/views/art/ARTShapeShadowNode;->mScale:F

    mul-float v19, v3, v4

    .line 295
    .local v19, "y":F
    add-int/lit8 v11, v12, 0x1

    .end local v12    # "i":I
    .restart local v11    # "i":I
    aget v3, p1, v12

    move-object/from16 v0, p0

    iget v4, v0, Lcom/facebook/react/views/art/ARTShapeShadowNode;->mScale:F

    mul-float v14, v3, v4

    .line 296
    .local v14, "r":F
    add-int/lit8 v12, v11, 0x1

    .end local v11    # "i":I
    .restart local v12    # "i":I
    aget v3, p1, v11

    float-to-double v4, v3

    invoke-static {v4, v5}, Ljava/lang/Math;->toDegrees(D)D

    move-result-wide v4

    double-to-float v15, v4

    .line 297
    .local v15, "start":F
    add-int/lit8 v11, v12, 0x1

    .end local v12    # "i":I
    .restart local v11    # "i":I
    aget v3, p1, v12

    float-to-double v4, v3

    invoke-static {v4, v5}, Ljava/lang/Math;->toDegrees(D)D

    move-result-wide v4

    double-to-float v10, v4

    .line 299
    .local v10, "end":F
    add-int/lit8 v12, v11, 0x1

    .end local v11    # "i":I
    .restart local v12    # "i":I
    aget v3, p1, v11

    const/high16 v4, 0x3f800000    # 1.0f

    cmpl-float v3, v3, v4

    if-eqz v3, :cond_0

    const/4 v9, 0x1

    .line 300
    .local v9, "counterClockwise":Z
    :goto_1
    sub-float v16, v10, v15

    .line 301
    .local v16, "sweep":F
    invoke-static/range {v16 .. v16}, Ljava/lang/Math;->abs(F)F

    move-result v3

    const/high16 v4, 0x43b40000    # 360.0f

    cmpl-float v3, v3, v4

    if-ltz v3, :cond_2

    .line 302
    if-eqz v9, :cond_1

    sget-object v3, Landroid/graphics/Path$Direction;->CCW:Landroid/graphics/Path$Direction;

    :goto_2
    move/from16 v0, v18

    move/from16 v1, v19

    invoke-virtual {v2, v0, v1, v14, v3}, Landroid/graphics/Path;->addCircle(FFFLandroid/graphics/Path$Direction;)V

    move v11, v12

    .end local v12    # "i":I
    .restart local v11    # "i":I
    goto/16 :goto_0

    .line 299
    .end local v9    # "counterClockwise":Z
    .end local v11    # "i":I
    .end local v16    # "sweep":F
    .restart local v12    # "i":I
    :cond_0
    const/4 v9, 0x0

    goto :goto_1

    .line 302
    .restart local v9    # "counterClockwise":Z
    .restart local v16    # "sweep":F
    :cond_1
    sget-object v3, Landroid/graphics/Path$Direction;->CW:Landroid/graphics/Path$Direction;

    goto :goto_2

    .line 304
    :cond_2
    const/high16 v3, 0x43b40000    # 360.0f

    move-object/from16 v0, p0

    move/from16 v1, v16

    invoke-direct {v0, v1, v3}, Lcom/facebook/react/views/art/ARTShapeShadowNode;->modulus(FF)F

    move-result v16

    .line 305
    if-eqz v9, :cond_3

    const/high16 v3, 0x43b40000    # 360.0f

    cmpg-float v3, v16, v3

    if-gez v3, :cond_3

    .line 307
    const/high16 v3, -0x40800000    # -1.0f

    const/high16 v4, 0x43b40000    # 360.0f

    sub-float v4, v4, v16

    mul-float v16, v3, v4

    .line 310
    :cond_3
    new-instance v13, Landroid/graphics/RectF;

    sub-float v3, v18, v14

    sub-float v4, v19, v14

    add-float v5, v18, v14

    add-float v6, v19, v14

    invoke-direct {v13, v3, v4, v5, v6}, Landroid/graphics/RectF;-><init>(FFFF)V

    .line 311
    .local v13, "oval":Landroid/graphics/RectF;
    move/from16 v0, v16

    invoke-virtual {v2, v13, v15, v0}, Landroid/graphics/Path;->arcTo(Landroid/graphics/RectF;FF)V

    move v11, v12

    .line 313
    .end local v12    # "i":I
    .restart local v11    # "i":I
    goto/16 :goto_0

    .line 320
    .end local v9    # "counterClockwise":Z
    .end local v10    # "end":F
    .end local v13    # "oval":Landroid/graphics/RectF;
    .end local v14    # "r":F
    .end local v15    # "start":F
    .end local v16    # "sweep":F
    .end local v17    # "type":I
    .end local v18    # "x":F
    .end local v19    # "y":F
    :cond_4
    return-object v2

    .line 272
    nop

    :pswitch_data_0
    .packed-switch 0x0
        :pswitch_0
        :pswitch_1
        :pswitch_2
        :pswitch_3
        :pswitch_4
    .end packed-switch
.end method

.method private modulus(FF)F
    .locals 3
    .param p1, "x"    # F
    .param p2, "y"    # F

    .prologue
    .line 249
    rem-float v1, p1, p2

    .line 250
    .local v1, "remainder":F
    move v0, v1

    .line 251
    .local v0, "modulus":F
    const/4 v2, 0x0

    cmpg-float v2, v1, v2

    if-gez v2, :cond_0

    .line 252
    add-float/2addr v0, p2

    .line 254
    :cond_0
    return v0
.end method


# virtual methods
.method public draw(Landroid/graphics/Canvas;Landroid/graphics/Paint;F)V
    .locals 2
    .param p1, "canvas"    # Landroid/graphics/Canvas;
    .param p2, "paint"    # Landroid/graphics/Paint;
    .param p3, "opacity"    # F

    .prologue
    .line 108
    iget v0, p0, Lcom/facebook/react/views/art/ARTShapeShadowNode;->mOpacity:F

    mul-float/2addr p3, v0

    .line 109
    const v0, 0x3c23d70a    # 0.01f

    cmpl-float v0, p3, v0

    if-lez v0, :cond_3

    .line 110
    invoke-virtual {p0, p1}, Lcom/facebook/react/views/art/ARTShapeShadowNode;->saveAndSetupCanvas(Landroid/graphics/Canvas;)V

    .line 111
    iget-object v0, p0, Lcom/facebook/react/views/art/ARTShapeShadowNode;->mPath:Landroid/graphics/Path;

    if-nez v0, :cond_0

    .line 112
    new-instance v0, Lcom/facebook/react/bridge/JSApplicationIllegalArgumentException;

    const-string v1, "Shapes should have a valid path (d) prop"

    invoke-direct {v0, v1}, Lcom/facebook/react/bridge/JSApplicationIllegalArgumentException;-><init>(Ljava/lang/String;)V

    throw v0

    .line 115
    :cond_0
    invoke-virtual {p0, p2, p3}, Lcom/facebook/react/views/art/ARTShapeShadowNode;->setupFillPaint(Landroid/graphics/Paint;F)Z

    move-result v0

    if-eqz v0, :cond_1

    .line 116
    iget-object v0, p0, Lcom/facebook/react/views/art/ARTShapeShadowNode;->mPath:Landroid/graphics/Path;

    invoke-virtual {p1, v0, p2}, Landroid/graphics/Canvas;->drawPath(Landroid/graphics/Path;Landroid/graphics/Paint;)V

    .line 118
    :cond_1
    invoke-virtual {p0, p2, p3}, Lcom/facebook/react/views/art/ARTShapeShadowNode;->setupStrokePaint(Landroid/graphics/Paint;F)Z

    move-result v0

    if-eqz v0, :cond_2

    .line 119
    iget-object v0, p0, Lcom/facebook/react/views/art/ARTShapeShadowNode;->mPath:Landroid/graphics/Path;

    invoke-virtual {p1, v0, p2}, Landroid/graphics/Canvas;->drawPath(Landroid/graphics/Path;Landroid/graphics/Paint;)V

    .line 121
    :cond_2
    invoke-virtual {p0, p1}, Lcom/facebook/react/views/art/ARTShapeShadowNode;->restoreCanvas(Landroid/graphics/Canvas;)V

    .line 123
    :cond_3
    invoke-virtual {p0}, Lcom/facebook/react/views/art/ARTShapeShadowNode;->markUpdateSeen()V

    .line 124
    return-void
.end method

.method public setFill(Lcom/facebook/react/bridge/ReadableArray;)V
    .locals 1
    .param p1, "fillColors"    # Lcom/facebook/react/bridge/ReadableArray;
        .annotation runtime Ljavax/annotation/Nullable;
        .end annotation
    .end param
    .annotation runtime Lcom/facebook/react/uimanager/annotations/ReactProp;
        name = "fill"
    .end annotation

    .prologue
    .line 84
    invoke-static {p1}, Lcom/facebook/react/views/art/PropHelper;->toFloatArray(Lcom/facebook/react/bridge/ReadableArray;)[F

    move-result-object v0

    iput-object v0, p0, Lcom/facebook/react/views/art/ARTShapeShadowNode;->mBrushData:[F

    .line 85
    invoke-virtual {p0}, Lcom/facebook/react/views/art/ARTShapeShadowNode;->markUpdated()V

    .line 86
    return-void
.end method

.method public setShapePath(Lcom/facebook/react/bridge/ReadableArray;)V
    .locals 2
    .param p1, "shapePath"    # Lcom/facebook/react/bridge/ReadableArray;
        .annotation runtime Ljavax/annotation/Nullable;
        .end annotation
    .end param
    .annotation runtime Lcom/facebook/react/uimanager/annotations/ReactProp;
        name = "d"
    .end annotation

    .prologue
    .line 65
    invoke-static {p1}, Lcom/facebook/react/views/art/PropHelper;->toFloatArray(Lcom/facebook/react/bridge/ReadableArray;)[F

    move-result-object v0

    .line 66
    .local v0, "pathData":[F
    invoke-direct {p0, v0}, Lcom/facebook/react/views/art/ARTShapeShadowNode;->createPath([F)Landroid/graphics/Path;

    move-result-object v1

    iput-object v1, p0, Lcom/facebook/react/views/art/ARTShapeShadowNode;->mPath:Landroid/graphics/Path;

    .line 67
    invoke-virtual {p0}, Lcom/facebook/react/views/art/ARTShapeShadowNode;->markUpdated()V

    .line 68
    return-void
.end method

.method public setStroke(Lcom/facebook/react/bridge/ReadableArray;)V
    .locals 1
    .param p1, "strokeColors"    # Lcom/facebook/react/bridge/ReadableArray;
        .annotation runtime Ljavax/annotation/Nullable;
        .end annotation
    .end param
    .annotation runtime Lcom/facebook/react/uimanager/annotations/ReactProp;
        name = "stroke"
    .end annotation

    .prologue
    .line 72
    invoke-static {p1}, Lcom/facebook/react/views/art/PropHelper;->toFloatArray(Lcom/facebook/react/bridge/ReadableArray;)[F

    move-result-object v0

    iput-object v0, p0, Lcom/facebook/react/views/art/ARTShapeShadowNode;->mStrokeColor:[F

    .line 73
    invoke-virtual {p0}, Lcom/facebook/react/views/art/ARTShapeShadowNode;->markUpdated()V

    .line 74
    return-void
.end method

.method public setStrokeCap(I)V
    .locals 0
    .param p1, "strokeCap"    # I
    .annotation runtime Lcom/facebook/react/uimanager/annotations/ReactProp;
        defaultInt = 0x1
        name = "strokeCap"
    .end annotation

    .prologue
    .line 96
    iput p1, p0, Lcom/facebook/react/views/art/ARTShapeShadowNode;->mStrokeCap:I

    .line 97
    invoke-virtual {p0}, Lcom/facebook/react/views/art/ARTShapeShadowNode;->markUpdated()V

    .line 98
    return-void
.end method

.method public setStrokeDash(Lcom/facebook/react/bridge/ReadableArray;)V
    .locals 1
    .param p1, "strokeDash"    # Lcom/facebook/react/bridge/ReadableArray;
        .annotation runtime Ljavax/annotation/Nullable;
        .end annotation
    .end param
    .annotation runtime Lcom/facebook/react/uimanager/annotations/ReactProp;
        name = "strokeDash"
    .end annotation

    .prologue
    .line 78
    invoke-static {p1}, Lcom/facebook/react/views/art/PropHelper;->toFloatArray(Lcom/facebook/react/bridge/ReadableArray;)[F

    move-result-object v0

    iput-object v0, p0, Lcom/facebook/react/views/art/ARTShapeShadowNode;->mStrokeDash:[F

    .line 79
    invoke-virtual {p0}, Lcom/facebook/react/views/art/ARTShapeShadowNode;->markUpdated()V

    .line 80
    return-void
.end method

.method public setStrokeJoin(I)V
    .locals 0
    .param p1, "strokeJoin"    # I
    .annotation runtime Lcom/facebook/react/uimanager/annotations/ReactProp;
        defaultInt = 0x1
        name = "strokeJoin"
    .end annotation

    .prologue
    .line 102
    iput p1, p0, Lcom/facebook/react/views/art/ARTShapeShadowNode;->mStrokeJoin:I

    .line 103
    invoke-virtual {p0}, Lcom/facebook/react/views/art/ARTShapeShadowNode;->markUpdated()V

    .line 104
    return-void
.end method

.method public setStrokeWidth(F)V
    .locals 0
    .param p1, "strokeWidth"    # F
    .annotation runtime Lcom/facebook/react/uimanager/annotations/ReactProp;
        defaultFloat = 1.0f
        name = "strokeWidth"
    .end annotation

    .prologue
    .line 90
    iput p1, p0, Lcom/facebook/react/views/art/ARTShapeShadowNode;->mStrokeWidth:F

    .line 91
    invoke-virtual {p0}, Lcom/facebook/react/views/art/ARTShapeShadowNode;->markUpdated()V

    .line 92
    return-void
.end method

.method protected setupFillPaint(Landroid/graphics/Paint;F)Z
    .locals 21
    .param p1, "paint"    # Landroid/graphics/Paint;
    .param p2, "opacity"    # F

    .prologue
    .line 182
    move-object/from16 v0, p0

    iget-object v3, v0, Lcom/facebook/react/views/art/ARTShapeShadowNode;->mBrushData:[F

    if-eqz v3, :cond_3

    move-object/from16 v0, p0

    iget-object v3, v0, Lcom/facebook/react/views/art/ARTShapeShadowNode;->mBrushData:[F

    array-length v3, v3

    if-lez v3, :cond_3

    .line 183
    invoke-virtual/range {p1 .. p1}, Landroid/graphics/Paint;->reset()V

    .line 184
    const/4 v3, 0x1

    move-object/from16 v0, p1

    invoke-virtual {v0, v3}, Landroid/graphics/Paint;->setFlags(I)V

    .line 185
    sget-object v3, Landroid/graphics/Paint$Style;->FILL:Landroid/graphics/Paint$Style;

    move-object/from16 v0, p1

    invoke-virtual {v0, v3}, Landroid/graphics/Paint;->setStyle(Landroid/graphics/Paint$Style;)V

    .line 186
    move-object/from16 v0, p0

    iget-object v3, v0, Lcom/facebook/react/views/art/ARTShapeShadowNode;->mBrushData:[F

    const/4 v10, 0x0

    aget v3, v3, v10

    float-to-int v13, v3

    .line 187
    .local v13, "colorType":I
    packed-switch v13, :pswitch_data_0

    .line 236
    const-string v3, "ReactNative"

    new-instance v10, Ljava/lang/StringBuilder;

    invoke-direct {v10}, Ljava/lang/StringBuilder;-><init>()V

    const-string v18, "ART: Color type "

    move-object/from16 v0, v18

    invoke-virtual {v10, v0}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v10

    invoke-virtual {v10, v13}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v10

    const-string v18, " not supported!"

    move-object/from16 v0, v18

    invoke-virtual {v10, v0}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v10

    invoke-virtual {v10}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v10

    invoke-static {v3, v10}, Lcom/facebook/common/logging/FLog;->w(Ljava/lang/String;Ljava/lang/String;)V

    .line 238
    :goto_0
    const/4 v3, 0x1

    .line 240
    .end local v13    # "colorType":I
    :goto_1
    return v3

    .line 189
    .restart local v13    # "colorType":I
    :pswitch_0
    move-object/from16 v0, p0

    iget-object v3, v0, Lcom/facebook/react/views/art/ARTShapeShadowNode;->mBrushData:[F

    array-length v3, v3

    const/4 v10, 0x4

    if-le v3, v10, :cond_0

    move-object/from16 v0, p0

    iget-object v3, v0, Lcom/facebook/react/views/art/ARTShapeShadowNode;->mBrushData:[F

    const/4 v10, 0x4

    aget v3, v3, v10

    mul-float v3, v3, p2

    const/high16 v10, 0x437f0000    # 255.0f

    mul-float/2addr v3, v10

    :goto_2
    float-to-int v3, v3

    move-object/from16 v0, p0

    iget-object v10, v0, Lcom/facebook/react/views/art/ARTShapeShadowNode;->mBrushData:[F

    const/16 v18, 0x1

    aget v10, v10, v18

    const/high16 v18, 0x437f0000    # 255.0f

    mul-float v10, v10, v18

    float-to-int v10, v10

    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/facebook/react/views/art/ARTShapeShadowNode;->mBrushData:[F

    move-object/from16 v18, v0

    const/16 v19, 0x2

    aget v18, v18, v19

    const/high16 v19, 0x437f0000    # 255.0f

    mul-float v18, v18, v19

    move/from16 v0, v18

    float-to-int v0, v0

    move/from16 v18, v0

    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/facebook/react/views/art/ARTShapeShadowNode;->mBrushData:[F

    move-object/from16 v19, v0

    const/16 v20, 0x3

    aget v19, v19, v20

    const/high16 v20, 0x437f0000    # 255.0f

    mul-float v19, v19, v20

    move/from16 v0, v19

    float-to-int v0, v0

    move/from16 v19, v0

    move-object/from16 v0, p1

    move/from16 v1, v18

    move/from16 v2, v19

    invoke-virtual {v0, v3, v10, v1, v2}, Landroid/graphics/Paint;->setARGB(IIII)V

    goto :goto_0

    :cond_0
    const/high16 v3, 0x437f0000    # 255.0f

    mul-float v3, v3, p2

    goto :goto_2

    .line 197
    :pswitch_1
    move-object/from16 v0, p0

    iget-object v3, v0, Lcom/facebook/react/views/art/ARTShapeShadowNode;->mBrushData:[F

    array-length v3, v3

    const/4 v10, 0x5

    if-ge v3, v10, :cond_1

    .line 198
    const-string v3, "ReactNative"

    new-instance v10, Ljava/lang/StringBuilder;

    invoke-direct {v10}, Ljava/lang/StringBuilder;-><init>()V

    const-string v18, "[ARTShapeShadowNode setupFillPaint] expects 5 elements, received "

    move-object/from16 v0, v18

    invoke-virtual {v10, v0}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v10

    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/facebook/react/views/art/ARTShapeShadowNode;->mBrushData:[F

    move-object/from16 v18, v0

    move-object/from16 v0, v18

    array-length v0, v0

    move/from16 v18, v0

    move/from16 v0, v18

    invoke-virtual {v10, v0}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v10

    invoke-virtual {v10}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v10

    invoke-static {v3, v10}, Lcom/facebook/common/logging/FLog;->w(Ljava/lang/String;Ljava/lang/String;)V

    .line 201
    const/4 v3, 0x0

    goto/16 :goto_1

    .line 203
    :cond_1
    move-object/from16 v0, p0

    iget-object v3, v0, Lcom/facebook/react/views/art/ARTShapeShadowNode;->mBrushData:[F

    const/4 v10, 0x1

    aget v3, v3, v10

    move-object/from16 v0, p0

    iget v10, v0, Lcom/facebook/react/views/art/ARTShapeShadowNode;->mScale:F

    mul-float v4, v3, v10

    .line 204
    .local v4, "gradientStartX":F
    move-object/from16 v0, p0

    iget-object v3, v0, Lcom/facebook/react/views/art/ARTShapeShadowNode;->mBrushData:[F

    const/4 v10, 0x2

    aget v3, v3, v10

    move-object/from16 v0, p0

    iget v10, v0, Lcom/facebook/react/views/art/ARTShapeShadowNode;->mScale:F

    mul-float v5, v3, v10

    .line 205
    .local v5, "gradientStartY":F
    move-object/from16 v0, p0

    iget-object v3, v0, Lcom/facebook/react/views/art/ARTShapeShadowNode;->mBrushData:[F

    const/4 v10, 0x3

    aget v3, v3, v10

    move-object/from16 v0, p0

    iget v10, v0, Lcom/facebook/react/views/art/ARTShapeShadowNode;->mScale:F

    mul-float v6, v3, v10

    .line 206
    .local v6, "gradientEndX":F
    move-object/from16 v0, p0

    iget-object v3, v0, Lcom/facebook/react/views/art/ARTShapeShadowNode;->mBrushData:[F

    const/4 v10, 0x4

    aget v3, v3, v10

    move-object/from16 v0, p0

    iget v10, v0, Lcom/facebook/react/views/art/ARTShapeShadowNode;->mScale:F

    mul-float v7, v3, v10

    .line 207
    .local v7, "gradientEndY":F
    move-object/from16 v0, p0

    iget-object v3, v0, Lcom/facebook/react/views/art/ARTShapeShadowNode;->mBrushData:[F

    array-length v3, v3

    add-int/lit8 v3, v3, -0x5

    div-int/lit8 v17, v3, 0x5

    .line 208
    .local v17, "stops":I
    const/4 v8, 0x0

    .line 209
    .local v8, "colors":[I
    const/4 v9, 0x0

    .line 210
    .local v9, "positions":[F
    if-lez v17, :cond_2

    .line 211
    move/from16 v0, v17

    new-array v8, v0, [I

    .line 212
    move/from16 v0, v17

    new-array v9, v0, [F

    .line 213
    const/4 v15, 0x0

    .local v15, "i":I
    :goto_3
    move/from16 v0, v17

    if-ge v15, v0, :cond_2

    .line 214
    move-object/from16 v0, p0

    iget-object v3, v0, Lcom/facebook/react/views/art/ARTShapeShadowNode;->mBrushData:[F

    mul-int/lit8 v10, v17, 0x4

    add-int/lit8 v10, v10, 0x5

    add-int/2addr v10, v15

    aget v3, v3, v10

    aput v3, v9, v15

    .line 215
    const/high16 v3, 0x437f0000    # 255.0f

    move-object/from16 v0, p0

    iget-object v10, v0, Lcom/facebook/react/views/art/ARTShapeShadowNode;->mBrushData:[F

    mul-int/lit8 v18, v15, 0x4

    add-int/lit8 v18, v18, 0x5

    add-int/lit8 v18, v18, 0x0

    aget v10, v10, v18

    mul-float/2addr v3, v10

    float-to-int v0, v3

    move/from16 v16, v0

    .line 216
    .local v16, "r":I
    const/high16 v3, 0x437f0000    # 255.0f

    move-object/from16 v0, p0

    iget-object v10, v0, Lcom/facebook/react/views/art/ARTShapeShadowNode;->mBrushData:[F

    mul-int/lit8 v18, v15, 0x4

    add-int/lit8 v18, v18, 0x5

    add-int/lit8 v18, v18, 0x1

    aget v10, v10, v18

    mul-float/2addr v3, v10

    float-to-int v14, v3

    .line 217
    .local v14, "g":I
    const/high16 v3, 0x437f0000    # 255.0f

    move-object/from16 v0, p0

    iget-object v10, v0, Lcom/facebook/react/views/art/ARTShapeShadowNode;->mBrushData:[F

    mul-int/lit8 v18, v15, 0x4

    add-int/lit8 v18, v18, 0x5

    add-int/lit8 v18, v18, 0x2

    aget v10, v10, v18

    mul-float/2addr v3, v10

    float-to-int v12, v3

    .line 218
    .local v12, "b":I
    const/high16 v3, 0x437f0000    # 255.0f

    move-object/from16 v0, p0

    iget-object v10, v0, Lcom/facebook/react/views/art/ARTShapeShadowNode;->mBrushData:[F

    mul-int/lit8 v18, v15, 0x4

    add-int/lit8 v18, v18, 0x5

    add-int/lit8 v18, v18, 0x3

    aget v10, v10, v18

    mul-float/2addr v3, v10

    float-to-int v11, v3

    .line 219
    .local v11, "a":I
    move/from16 v0, v16

    invoke-static {v11, v0, v14, v12}, Landroid/graphics/Color;->argb(IIII)I

    move-result v3

    aput v3, v8, v15

    .line 213
    add-int/lit8 v15, v15, 0x1

    goto :goto_3

    .line 222
    .end local v11    # "a":I
    .end local v12    # "b":I
    .end local v14    # "g":I
    .end local v15    # "i":I
    .end local v16    # "r":I
    :cond_2
    new-instance v3, Landroid/graphics/LinearGradient;

    sget-object v10, Landroid/graphics/Shader$TileMode;->CLAMP:Landroid/graphics/Shader$TileMode;

    invoke-direct/range {v3 .. v10}, Landroid/graphics/LinearGradient;-><init>(FFFF[I[FLandroid/graphics/Shader$TileMode;)V

    move-object/from16 v0, p1

    invoke-virtual {v0, v3}, Landroid/graphics/Paint;->setShader(Landroid/graphics/Shader;)Landroid/graphics/Shader;

    goto/16 :goto_0

    .line 240
    .end local v4    # "gradientStartX":F
    .end local v5    # "gradientStartY":F
    .end local v6    # "gradientEndX":F
    .end local v7    # "gradientEndY":F
    .end local v8    # "colors":[I
    .end local v9    # "positions":[F
    .end local v13    # "colorType":I
    .end local v17    # "stops":I
    :cond_3
    const/4 v3, 0x0

    goto/16 :goto_1

    .line 187
    :pswitch_data_0
    .packed-switch 0x0
        :pswitch_0
        :pswitch_1
    .end packed-switch
.end method

.method protected setupStrokePaint(Landroid/graphics/Paint;F)Z
    .locals 8
    .param p1, "paint"    # Landroid/graphics/Paint;
    .param p2, "opacity"    # F

    .prologue
    const/4 v4, 0x3

    const/4 v2, 0x0

    const/4 v7, 0x0

    const/4 v1, 0x1

    const/high16 v6, 0x437f0000    # 255.0f

    .line 131
    iget v0, p0, Lcom/facebook/react/views/art/ARTShapeShadowNode;->mStrokeWidth:F

    cmpl-float v0, v0, v7

    if-eqz v0, :cond_0

    iget-object v0, p0, Lcom/facebook/react/views/art/ARTShapeShadowNode;->mStrokeColor:[F

    if-eqz v0, :cond_0

    iget-object v0, p0, Lcom/facebook/react/views/art/ARTShapeShadowNode;->mStrokeColor:[F

    array-length v0, v0

    if-nez v0, :cond_1

    :cond_0
    move v0, v2

    .line 174
    :goto_0
    return v0

    .line 134
    :cond_1
    invoke-virtual {p1}, Landroid/graphics/Paint;->reset()V

    .line 135
    invoke-virtual {p1, v1}, Landroid/graphics/Paint;->setFlags(I)V

    .line 136
    sget-object v0, Landroid/graphics/Paint$Style;->STROKE:Landroid/graphics/Paint$Style;

    invoke-virtual {p1, v0}, Landroid/graphics/Paint;->setStyle(Landroid/graphics/Paint$Style;)V

    .line 137
    iget v0, p0, Lcom/facebook/react/views/art/ARTShapeShadowNode;->mStrokeCap:I

    packed-switch v0, :pswitch_data_0

    .line 148
    new-instance v0, Lcom/facebook/react/bridge/JSApplicationIllegalArgumentException;

    new-instance v1, Ljava/lang/StringBuilder;

    invoke-direct {v1}, Ljava/lang/StringBuilder;-><init>()V

    const-string v2, "strokeCap "

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    iget v2, p0, Lcom/facebook/react/views/art/ARTShapeShadowNode;->mStrokeCap:I

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v1

    const-string v2, " unrecognized"

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    invoke-direct {v0, v1}, Lcom/facebook/react/bridge/JSApplicationIllegalArgumentException;-><init>(Ljava/lang/String;)V

    throw v0

    .line 139
    :pswitch_0
    sget-object v0, Landroid/graphics/Paint$Cap;->BUTT:Landroid/graphics/Paint$Cap;

    invoke-virtual {p1, v0}, Landroid/graphics/Paint;->setStrokeCap(Landroid/graphics/Paint$Cap;)V

    .line 151
    :goto_1
    iget v0, p0, Lcom/facebook/react/views/art/ARTShapeShadowNode;->mStrokeJoin:I

    packed-switch v0, :pswitch_data_1

    .line 162
    new-instance v0, Lcom/facebook/react/bridge/JSApplicationIllegalArgumentException;

    new-instance v1, Ljava/lang/StringBuilder;

    invoke-direct {v1}, Ljava/lang/StringBuilder;-><init>()V

    const-string v2, "strokeJoin "

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    iget v2, p0, Lcom/facebook/react/views/art/ARTShapeShadowNode;->mStrokeJoin:I

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v1

    const-string v2, " unrecognized"

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    invoke-direct {v0, v1}, Lcom/facebook/react/bridge/JSApplicationIllegalArgumentException;-><init>(Ljava/lang/String;)V

    throw v0

    .line 142
    :pswitch_1
    sget-object v0, Landroid/graphics/Paint$Cap;->SQUARE:Landroid/graphics/Paint$Cap;

    invoke-virtual {p1, v0}, Landroid/graphics/Paint;->setStrokeCap(Landroid/graphics/Paint$Cap;)V

    goto :goto_1

    .line 145
    :pswitch_2
    sget-object v0, Landroid/graphics/Paint$Cap;->ROUND:Landroid/graphics/Paint$Cap;

    invoke-virtual {p1, v0}, Landroid/graphics/Paint;->setStrokeCap(Landroid/graphics/Paint$Cap;)V

    goto :goto_1

    .line 153
    :pswitch_3
    sget-object v0, Landroid/graphics/Paint$Join;->MITER:Landroid/graphics/Paint$Join;

    invoke-virtual {p1, v0}, Landroid/graphics/Paint;->setStrokeJoin(Landroid/graphics/Paint$Join;)V

    .line 165
    :goto_2
    iget v0, p0, Lcom/facebook/react/views/art/ARTShapeShadowNode;->mStrokeWidth:F

    iget v3, p0, Lcom/facebook/react/views/art/ARTShapeShadowNode;->mScale:F

    mul-float/2addr v0, v3

    invoke-virtual {p1, v0}, Landroid/graphics/Paint;->setStrokeWidth(F)V

    .line 166
    iget-object v0, p0, Lcom/facebook/react/views/art/ARTShapeShadowNode;->mStrokeColor:[F

    array-length v0, v0

    if-le v0, v4, :cond_3

    iget-object v0, p0, Lcom/facebook/react/views/art/ARTShapeShadowNode;->mStrokeColor:[F

    aget v0, v0, v4

    mul-float/2addr v0, p2

    mul-float/2addr v0, v6

    :goto_3
    float-to-int v0, v0

    iget-object v3, p0, Lcom/facebook/react/views/art/ARTShapeShadowNode;->mStrokeColor:[F

    aget v2, v3, v2

    mul-float/2addr v2, v6

    float-to-int v2, v2

    iget-object v3, p0, Lcom/facebook/react/views/art/ARTShapeShadowNode;->mStrokeColor:[F

    aget v3, v3, v1

    mul-float/2addr v3, v6

    float-to-int v3, v3

    iget-object v4, p0, Lcom/facebook/react/views/art/ARTShapeShadowNode;->mStrokeColor:[F

    const/4 v5, 0x2

    aget v4, v4, v5

    mul-float/2addr v4, v6

    float-to-int v4, v4

    invoke-virtual {p1, v0, v2, v3, v4}, Landroid/graphics/Paint;->setARGB(IIII)V

    .line 171
    iget-object v0, p0, Lcom/facebook/react/views/art/ARTShapeShadowNode;->mStrokeDash:[F

    if-eqz v0, :cond_2

    iget-object v0, p0, Lcom/facebook/react/views/art/ARTShapeShadowNode;->mStrokeDash:[F

    array-length v0, v0

    if-lez v0, :cond_2

    .line 172
    new-instance v0, Landroid/graphics/DashPathEffect;

    iget-object v2, p0, Lcom/facebook/react/views/art/ARTShapeShadowNode;->mStrokeDash:[F

    invoke-direct {v0, v2, v7}, Landroid/graphics/DashPathEffect;-><init>([FF)V

    invoke-virtual {p1, v0}, Landroid/graphics/Paint;->setPathEffect(Landroid/graphics/PathEffect;)Landroid/graphics/PathEffect;

    :cond_2
    move v0, v1

    .line 174
    goto/16 :goto_0

    .line 156
    :pswitch_4
    sget-object v0, Landroid/graphics/Paint$Join;->BEVEL:Landroid/graphics/Paint$Join;

    invoke-virtual {p1, v0}, Landroid/graphics/Paint;->setStrokeJoin(Landroid/graphics/Paint$Join;)V

    goto :goto_2

    .line 159
    :pswitch_5
    sget-object v0, Landroid/graphics/Paint$Join;->ROUND:Landroid/graphics/Paint$Join;

    invoke-virtual {p1, v0}, Landroid/graphics/Paint;->setStrokeJoin(Landroid/graphics/Paint$Join;)V

    goto :goto_2

    .line 166
    :cond_3
    mul-float v0, p2, v6

    goto :goto_3

    .line 137
    nop

    :pswitch_data_0
    .packed-switch 0x0
        :pswitch_0
        :pswitch_2
        :pswitch_1
    .end packed-switch

    .line 151
    :pswitch_data_1
    .packed-switch 0x0
        :pswitch_3
        :pswitch_5
        :pswitch_4
    .end packed-switch
.end method

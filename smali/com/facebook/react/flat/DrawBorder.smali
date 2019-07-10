.class final Lcom/facebook/react/flat/DrawBorder;
.super Lcom/facebook/react/flat/AbstractDrawBorder;
.source "DrawBorder.java"


# static fields
.field private static final ALL_BITS_SET:I = -0x1

.field private static final ALL_BITS_UNSET:I = 0x0

.field private static final BORDER_BOTTOM_COLOR_SET:I = 0x10

.field private static final BORDER_LEFT_COLOR_SET:I = 0x2

.field private static final BORDER_PATH_EFFECT_DIRTY:I = 0x20

.field private static final BORDER_RIGHT_COLOR_SET:I = 0x8

.field private static final BORDER_STYLE_DASHED:I = 0x2

.field private static final BORDER_STYLE_DOTTED:I = 0x1

.field private static final BORDER_STYLE_SOLID:I = 0x0

.field private static final BORDER_TOP_COLOR_SET:I = 0x4

.field private static final PAINT:Landroid/graphics/Paint;

.field private static final TMP_FLOAT_ARRAY:[F


# instance fields
.field private mBackgroundColor:I

.field private mBorderBottomColor:I

.field private mBorderBottomWidth:F

.field private mBorderLeftColor:I

.field private mBorderLeftWidth:F

.field private mBorderRightColor:I

.field private mBorderRightWidth:F

.field private mBorderStyle:I

.field private mBorderTopColor:I

.field private mBorderTopWidth:F

.field private mPathEffectForBorderStyle:Landroid/graphics/DashPathEffect;
    .annotation runtime Ljavax/annotation/Nullable;
    .end annotation
.end field

.field private mPathForBorder:Landroid/graphics/Path;
    .annotation runtime Ljavax/annotation/Nullable;
    .end annotation
.end field


# direct methods
.method static constructor <clinit>()V
    .locals 2

    .prologue
    .line 24
    new-instance v0, Landroid/graphics/Paint;

    const/4 v1, 0x1

    invoke-direct {v0, v1}, Landroid/graphics/Paint;-><init>(I)V

    sput-object v0, Lcom/facebook/react/flat/DrawBorder;->PAINT:Landroid/graphics/Paint;

    .line 25
    const/4 v0, 0x4

    new-array v0, v0, [F

    sput-object v0, Lcom/facebook/react/flat/DrawBorder;->TMP_FLOAT_ARRAY:[F

    return-void
.end method

.method constructor <init>()V
    .locals 1

    .prologue
    .line 22
    invoke-direct {p0}, Lcom/facebook/react/flat/AbstractDrawBorder;-><init>()V

    .line 52
    const/4 v0, 0x0

    iput v0, p0, Lcom/facebook/react/flat/DrawBorder;->mBorderStyle:I

    return-void
.end method

.method private static createDashPathEffect(F)Landroid/graphics/DashPathEffect;
    .locals 4
    .param p0, "borderWidth"    # F

    .prologue
    .line 455
    const/4 v0, 0x0

    .local v0, "i":I
    :goto_0
    const/4 v1, 0x4

    if-ge v0, v1, :cond_0

    .line 456
    sget-object v1, Lcom/facebook/react/flat/DrawBorder;->TMP_FLOAT_ARRAY:[F

    aput p0, v1, v0

    .line 455
    add-int/lit8 v0, v0, 0x1

    goto :goto_0

    .line 458
    :cond_0
    new-instance v1, Landroid/graphics/DashPathEffect;

    sget-object v2, Lcom/facebook/react/flat/DrawBorder;->TMP_FLOAT_ARRAY:[F

    const/4 v3, 0x0

    invoke-direct {v1, v2, v3}, Landroid/graphics/DashPathEffect;-><init>([FF)V

    return-object v1
.end method

.method private drawRectangularBorders(Landroid/graphics/Canvas;)V
    .locals 30
    .param p1, "canvas"    # Landroid/graphics/Canvas;

    .prologue
    .line 249
    invoke-virtual/range {p0 .. p0}, Lcom/facebook/react/flat/DrawBorder;->getBorderColor()I

    move-result v27

    .line 250
    .local v27, "defaultColor":I
    invoke-virtual/range {p0 .. p0}, Lcom/facebook/react/flat/DrawBorder;->getBorderWidth()F

    move-result v28

    .line 252
    .local v28, "defaultWidth":F
    invoke-virtual/range {p0 .. p0}, Lcom/facebook/react/flat/DrawBorder;->getTop()F

    move-result v17

    .line 253
    .local v17, "top":F
    move-object/from16 v0, p0

    iget v10, v0, Lcom/facebook/react/flat/DrawBorder;->mBorderTopWidth:F

    move/from16 v0, v28

    invoke-static {v10, v0}, Lcom/facebook/react/flat/DrawBorder;->resolveWidth(FF)F

    move-result v3

    .line 254
    .local v3, "borderTop":F
    add-float v12, v17, v3

    .line 255
    .local v12, "topInset":F
    const/4 v10, 0x4

    move-object/from16 v0, p0

    iget v15, v0, Lcom/facebook/react/flat/DrawBorder;->mBorderTopColor:I

    move-object/from16 v0, p0

    move/from16 v1, v27

    invoke-direct {v0, v10, v15, v1}, Lcom/facebook/react/flat/DrawBorder;->resolveBorderColor(III)I

    move-result v7

    .line 257
    .local v7, "topColor":I
    invoke-virtual/range {p0 .. p0}, Lcom/facebook/react/flat/DrawBorder;->getBottom()F

    move-result v19

    .line 258
    .local v19, "bottom":F
    move-object/from16 v0, p0

    iget v10, v0, Lcom/facebook/react/flat/DrawBorder;->mBorderBottomWidth:F

    move/from16 v0, v28

    invoke-static {v10, v0}, Lcom/facebook/react/flat/DrawBorder;->resolveWidth(FF)F

    move-result v5

    .line 259
    .local v5, "borderBottom":F
    sub-float v14, v19, v5

    .line 260
    .local v14, "bottomInset":F
    const/16 v10, 0x10

    move-object/from16 v0, p0

    iget v15, v0, Lcom/facebook/react/flat/DrawBorder;->mBorderBottomColor:I

    move-object/from16 v0, p0

    move/from16 v1, v27

    invoke-direct {v0, v10, v15, v1}, Lcom/facebook/react/flat/DrawBorder;->resolveBorderColor(III)I

    move-result v9

    .line 262
    .local v9, "bottomColor":I
    invoke-virtual/range {p0 .. p0}, Lcom/facebook/react/flat/DrawBorder;->getLeft()F

    move-result v16

    .line 263
    .local v16, "left":F
    move-object/from16 v0, p0

    iget v10, v0, Lcom/facebook/react/flat/DrawBorder;->mBorderLeftWidth:F

    move/from16 v0, v28

    invoke-static {v10, v0}, Lcom/facebook/react/flat/DrawBorder;->resolveWidth(FF)F

    move-result v2

    .line 264
    .local v2, "borderLeft":F
    add-float v11, v16, v2

    .line 265
    .local v11, "leftInset":F
    const/4 v10, 0x2

    move-object/from16 v0, p0

    iget v15, v0, Lcom/facebook/react/flat/DrawBorder;->mBorderLeftColor:I

    move-object/from16 v0, p0

    move/from16 v1, v27

    invoke-direct {v0, v10, v15, v1}, Lcom/facebook/react/flat/DrawBorder;->resolveBorderColor(III)I

    move-result v6

    .line 267
    .local v6, "leftColor":I
    invoke-virtual/range {p0 .. p0}, Lcom/facebook/react/flat/DrawBorder;->getRight()F

    move-result v18

    .line 268
    .local v18, "right":F
    move-object/from16 v0, p0

    iget v10, v0, Lcom/facebook/react/flat/DrawBorder;->mBorderRightWidth:F

    move/from16 v0, v28

    invoke-static {v10, v0}, Lcom/facebook/react/flat/DrawBorder;->resolveWidth(FF)F

    move-result v4

    .line 269
    .local v4, "borderRight":F
    sub-float v13, v18, v4

    .line 270
    .local v13, "rightInset":F
    const/16 v10, 0x8

    move-object/from16 v0, p0

    iget v15, v0, Lcom/facebook/react/flat/DrawBorder;->mBorderRightColor:I

    move-object/from16 v0, p0

    move/from16 v1, v27

    invoke-direct {v0, v10, v15, v1}, Lcom/facebook/react/flat/DrawBorder;->resolveBorderColor(III)I

    move-result v8

    .line 273
    .local v8, "rightColor":I
    invoke-static/range {v2 .. v9}, Lcom/facebook/react/flat/DrawBorder;->fastBorderCompatibleColorOrZero(FFFFIIII)I

    move-result v29

    .line 282
    .local v29, "fastBorderColor":I
    if-eqz v29, :cond_6

    .line 284
    invoke-static/range {v29 .. v29}, Landroid/graphics/Color;->alpha(I)I

    move-result v10

    if-eqz v10, :cond_4

    .line 288
    move-object/from16 v0, p0

    iget v10, v0, Lcom/facebook/react/flat/DrawBorder;->mBackgroundColor:I

    invoke-static {v10}, Landroid/graphics/Color;->alpha(I)I

    move-result v10

    if-eqz v10, :cond_0

    .line 289
    sget-object v10, Lcom/facebook/react/flat/DrawBorder;->PAINT:Landroid/graphics/Paint;

    move-object/from16 v0, p0

    iget v15, v0, Lcom/facebook/react/flat/DrawBorder;->mBackgroundColor:I

    invoke-virtual {v10, v15}, Landroid/graphics/Paint;->setColor(I)V

    .line 290
    invoke-static/range {v29 .. v29}, Landroid/graphics/Color;->alpha(I)I

    move-result v10

    const/16 v15, 0xff

    if-ne v10, v15, :cond_5

    .line 292
    sget-object v15, Lcom/facebook/react/flat/DrawBorder;->PAINT:Landroid/graphics/Paint;

    move-object/from16 v10, p1

    invoke-virtual/range {v10 .. v15}, Landroid/graphics/Canvas;->drawRect(FFFFLandroid/graphics/Paint;)V

    .line 299
    :cond_0
    :goto_0
    sget-object v10, Lcom/facebook/react/flat/DrawBorder;->PAINT:Landroid/graphics/Paint;

    move/from16 v0, v29

    invoke-virtual {v10, v0}, Landroid/graphics/Paint;->setColor(I)V

    .line 300
    const/4 v10, 0x0

    cmpl-float v10, v2, v10

    if-lez v10, :cond_1

    .line 301
    sub-float v24, v19, v5

    sget-object v25, Lcom/facebook/react/flat/DrawBorder;->PAINT:Landroid/graphics/Paint;

    move-object/from16 v20, p1

    move/from16 v21, v16

    move/from16 v22, v17

    move/from16 v23, v11

    invoke-virtual/range {v20 .. v25}, Landroid/graphics/Canvas;->drawRect(FFFFLandroid/graphics/Paint;)V

    .line 303
    :cond_1
    const/4 v10, 0x0

    cmpl-float v10, v3, v10

    if-lez v10, :cond_2

    .line 304
    add-float v21, v16, v2

    sget-object v25, Lcom/facebook/react/flat/DrawBorder;->PAINT:Landroid/graphics/Paint;

    move-object/from16 v20, p1

    move/from16 v22, v17

    move/from16 v23, v18

    move/from16 v24, v12

    invoke-virtual/range {v20 .. v25}, Landroid/graphics/Canvas;->drawRect(FFFFLandroid/graphics/Paint;)V

    .line 306
    :cond_2
    const/4 v10, 0x0

    cmpl-float v10, v4, v10

    if-lez v10, :cond_3

    .line 307
    add-float v22, v17, v3

    sget-object v25, Lcom/facebook/react/flat/DrawBorder;->PAINT:Landroid/graphics/Paint;

    move-object/from16 v20, p1

    move/from16 v21, v13

    move/from16 v23, v18

    move/from16 v24, v19

    invoke-virtual/range {v20 .. v25}, Landroid/graphics/Canvas;->drawRect(FFFFLandroid/graphics/Paint;)V

    .line 309
    :cond_3
    const/4 v10, 0x0

    cmpl-float v10, v5, v10

    if-lez v10, :cond_4

    .line 310
    sub-float v23, v18, v4

    sget-object v25, Lcom/facebook/react/flat/DrawBorder;->PAINT:Landroid/graphics/Paint;

    move-object/from16 v20, p1

    move/from16 v21, v16

    move/from16 v22, v14

    move/from16 v24, v19

    invoke-virtual/range {v20 .. v25}, Landroid/graphics/Canvas;->drawRect(FFFFLandroid/graphics/Paint;)V

    .line 380
    :cond_4
    :goto_1
    return-void

    .line 295
    :cond_5
    sget-object v20, Lcom/facebook/react/flat/DrawBorder;->PAINT:Landroid/graphics/Paint;

    move-object/from16 v15, p1

    invoke-virtual/range {v15 .. v20}, Landroid/graphics/Canvas;->drawRect(FFFFLandroid/graphics/Paint;)V

    goto :goto_0

    .line 314
    :cond_6
    move-object/from16 v0, p0

    iget-object v10, v0, Lcom/facebook/react/flat/DrawBorder;->mPathForBorder:Landroid/graphics/Path;

    if-nez v10, :cond_7

    .line 315
    new-instance v10, Landroid/graphics/Path;

    invoke-direct {v10}, Landroid/graphics/Path;-><init>()V

    move-object/from16 v0, p0

    iput-object v10, v0, Lcom/facebook/react/flat/DrawBorder;->mPathForBorder:Landroid/graphics/Path;

    .line 319
    :cond_7
    move-object/from16 v0, p0

    iget v10, v0, Lcom/facebook/react/flat/DrawBorder;->mBackgroundColor:I

    invoke-static {v10}, Landroid/graphics/Color;->alpha(I)I

    move-result v10

    if-eqz v10, :cond_8

    .line 320
    sget-object v10, Lcom/facebook/react/flat/DrawBorder;->PAINT:Landroid/graphics/Paint;

    move-object/from16 v0, p0

    iget v15, v0, Lcom/facebook/react/flat/DrawBorder;->mBackgroundColor:I

    invoke-virtual {v10, v15}, Landroid/graphics/Paint;->setColor(I)V

    .line 321
    sget-object v20, Lcom/facebook/react/flat/DrawBorder;->PAINT:Landroid/graphics/Paint;

    move-object/from16 v15, p1

    invoke-virtual/range {v15 .. v20}, Landroid/graphics/Canvas;->drawRect(FFFFLandroid/graphics/Paint;)V

    .line 325
    :cond_8
    const/4 v10, 0x0

    cmpl-float v10, v3, v10

    if-eqz v10, :cond_9

    invoke-static {v7}, Landroid/graphics/Color;->alpha(I)I

    move-result v10

    if-eqz v10, :cond_9

    .line 326
    sget-object v10, Lcom/facebook/react/flat/DrawBorder;->PAINT:Landroid/graphics/Paint;

    invoke-virtual {v10, v7}, Landroid/graphics/Paint;->setColor(I)V

    .line 327
    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/facebook/react/flat/DrawBorder;->mPathForBorder:Landroid/graphics/Path;

    move-object/from16 v20, v0

    move/from16 v21, v17

    move/from16 v22, v12

    move/from16 v23, v16

    move/from16 v24, v11

    move/from16 v25, v18

    move/from16 v26, v13

    invoke-static/range {v20 .. v26}, Lcom/facebook/react/flat/DrawBorder;->updatePathForTopBorder(Landroid/graphics/Path;FFFFFF)V

    .line 335
    move-object/from16 v0, p0

    iget-object v10, v0, Lcom/facebook/react/flat/DrawBorder;->mPathForBorder:Landroid/graphics/Path;

    sget-object v15, Lcom/facebook/react/flat/DrawBorder;->PAINT:Landroid/graphics/Paint;

    move-object/from16 v0, p1

    invoke-virtual {v0, v10, v15}, Landroid/graphics/Canvas;->drawPath(Landroid/graphics/Path;Landroid/graphics/Paint;)V

    .line 339
    :cond_9
    const/4 v10, 0x0

    cmpl-float v10, v5, v10

    if-eqz v10, :cond_a

    invoke-static {v9}, Landroid/graphics/Color;->alpha(I)I

    move-result v10

    if-eqz v10, :cond_a

    .line 340
    sget-object v10, Lcom/facebook/react/flat/DrawBorder;->PAINT:Landroid/graphics/Paint;

    invoke-virtual {v10, v9}, Landroid/graphics/Paint;->setColor(I)V

    .line 341
    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/facebook/react/flat/DrawBorder;->mPathForBorder:Landroid/graphics/Path;

    move-object/from16 v20, v0

    move/from16 v21, v19

    move/from16 v22, v14

    move/from16 v23, v16

    move/from16 v24, v11

    move/from16 v25, v18

    move/from16 v26, v13

    invoke-static/range {v20 .. v26}, Lcom/facebook/react/flat/DrawBorder;->updatePathForBottomBorder(Landroid/graphics/Path;FFFFFF)V

    .line 349
    move-object/from16 v0, p0

    iget-object v10, v0, Lcom/facebook/react/flat/DrawBorder;->mPathForBorder:Landroid/graphics/Path;

    sget-object v15, Lcom/facebook/react/flat/DrawBorder;->PAINT:Landroid/graphics/Paint;

    move-object/from16 v0, p1

    invoke-virtual {v0, v10, v15}, Landroid/graphics/Canvas;->drawPath(Landroid/graphics/Path;Landroid/graphics/Paint;)V

    .line 353
    :cond_a
    const/4 v10, 0x0

    cmpl-float v10, v2, v10

    if-eqz v10, :cond_b

    invoke-static {v6}, Landroid/graphics/Color;->alpha(I)I

    move-result v10

    if-eqz v10, :cond_b

    .line 354
    sget-object v10, Lcom/facebook/react/flat/DrawBorder;->PAINT:Landroid/graphics/Paint;

    invoke-virtual {v10, v6}, Landroid/graphics/Paint;->setColor(I)V

    .line 355
    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/facebook/react/flat/DrawBorder;->mPathForBorder:Landroid/graphics/Path;

    move-object/from16 v20, v0

    move/from16 v21, v17

    move/from16 v22, v12

    move/from16 v23, v19

    move/from16 v24, v14

    move/from16 v25, v16

    move/from16 v26, v11

    invoke-static/range {v20 .. v26}, Lcom/facebook/react/flat/DrawBorder;->updatePathForLeftBorder(Landroid/graphics/Path;FFFFFF)V

    .line 363
    move-object/from16 v0, p0

    iget-object v10, v0, Lcom/facebook/react/flat/DrawBorder;->mPathForBorder:Landroid/graphics/Path;

    sget-object v15, Lcom/facebook/react/flat/DrawBorder;->PAINT:Landroid/graphics/Paint;

    move-object/from16 v0, p1

    invoke-virtual {v0, v10, v15}, Landroid/graphics/Canvas;->drawPath(Landroid/graphics/Path;Landroid/graphics/Paint;)V

    .line 367
    :cond_b
    const/4 v10, 0x0

    cmpl-float v10, v4, v10

    if-eqz v10, :cond_4

    invoke-static {v8}, Landroid/graphics/Color;->alpha(I)I

    move-result v10

    if-eqz v10, :cond_4

    .line 368
    sget-object v10, Lcom/facebook/react/flat/DrawBorder;->PAINT:Landroid/graphics/Paint;

    invoke-virtual {v10, v8}, Landroid/graphics/Paint;->setColor(I)V

    .line 369
    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/facebook/react/flat/DrawBorder;->mPathForBorder:Landroid/graphics/Path;

    move-object/from16 v20, v0

    move/from16 v21, v17

    move/from16 v22, v12

    move/from16 v23, v19

    move/from16 v24, v14

    move/from16 v25, v18

    move/from16 v26, v13

    invoke-static/range {v20 .. v26}, Lcom/facebook/react/flat/DrawBorder;->updatePathForRightBorder(Landroid/graphics/Path;FFFFFF)V

    .line 377
    move-object/from16 v0, p0

    iget-object v10, v0, Lcom/facebook/react/flat/DrawBorder;->mPathForBorder:Landroid/graphics/Path;

    sget-object v15, Lcom/facebook/react/flat/DrawBorder;->PAINT:Landroid/graphics/Paint;

    move-object/from16 v0, p1

    invoke-virtual {v0, v10, v15}, Landroid/graphics/Canvas;->drawPath(Landroid/graphics/Path;Landroid/graphics/Paint;)V

    goto/16 :goto_1
.end method

.method private drawRoundedBorders(Landroid/graphics/Canvas;)V
    .locals 2
    .param p1, "canvas"    # Landroid/graphics/Canvas;

    .prologue
    .line 211
    iget v0, p0, Lcom/facebook/react/flat/DrawBorder;->mBackgroundColor:I

    if-eqz v0, :cond_0

    .line 212
    sget-object v0, Lcom/facebook/react/flat/DrawBorder;->PAINT:Landroid/graphics/Paint;

    iget v1, p0, Lcom/facebook/react/flat/DrawBorder;->mBackgroundColor:I

    invoke-virtual {v0, v1}, Landroid/graphics/Paint;->setColor(I)V

    .line 213
    invoke-virtual {p0}, Lcom/facebook/react/flat/DrawBorder;->getPathForBorderRadius()Landroid/graphics/Path;

    move-result-object v0

    sget-object v1, Lcom/facebook/react/flat/DrawBorder;->PAINT:Landroid/graphics/Paint;

    invoke-virtual {p1, v0, v1}, Landroid/graphics/Canvas;->drawPath(Landroid/graphics/Path;Landroid/graphics/Paint;)V

    .line 216
    :cond_0
    invoke-virtual {p0, p1}, Lcom/facebook/react/flat/DrawBorder;->drawBorders(Landroid/graphics/Canvas;)V

    .line 217
    return-void
.end method

.method private static fastBorderCompatibleColorOrZero(FFFFIIII)I
    .locals 7
    .param p0, "borderLeft"    # F
    .param p1, "borderTop"    # F
    .param p2, "borderRight"    # F
    .param p3, "borderBottom"    # F
    .param p4, "colorLeft"    # I
    .param p5, "colorTop"    # I
    .param p6, "colorRight"    # I
    .param p7, "colorBottom"    # I

    .prologue
    const/4 v3, -0x1

    const/4 v2, 0x0

    const/4 v6, 0x0

    .line 237
    cmpl-float v4, p0, v6

    if-lez v4, :cond_1

    move v5, p4

    :goto_0
    cmpl-float v4, p1, v6

    if-lez v4, :cond_2

    move v4, p5

    :goto_1
    and-int/2addr v5, v4

    cmpl-float v4, p2, v6

    if-lez v4, :cond_3

    move v4, p6

    :goto_2
    and-int/2addr v4, v5

    cmpl-float v5, p3, v6

    if-lez v5, :cond_0

    move v3, p7

    :cond_0
    and-int v0, v4, v3

    .line 241
    .local v0, "andSmear":I
    cmpl-float v3, p0, v6

    if-lez v3, :cond_4

    .end local p4    # "colorLeft":I
    :goto_3
    cmpl-float v3, p1, v6

    if-lez v3, :cond_5

    .end local p5    # "colorTop":I
    :goto_4
    or-int v3, p4, p5

    cmpl-float v4, p2, v6

    if-lez v4, :cond_6

    .end local p6    # "colorRight":I
    :goto_5
    or-int/2addr v3, p6

    cmpl-float v4, p3, v6

    if-lez v4, :cond_7

    .end local p7    # "colorBottom":I
    :goto_6
    or-int v1, v3, p7

    .line 245
    .local v1, "orSmear":I
    if-ne v0, v1, :cond_8

    .end local v0    # "andSmear":I
    :goto_7
    return v0

    .end local v1    # "orSmear":I
    .restart local p4    # "colorLeft":I
    .restart local p5    # "colorTop":I
    .restart local p6    # "colorRight":I
    .restart local p7    # "colorBottom":I
    :cond_1
    move v5, v3

    .line 237
    goto :goto_0

    :cond_2
    move v4, v3

    goto :goto_1

    :cond_3
    move v4, v3

    goto :goto_2

    .restart local v0    # "andSmear":I
    :cond_4
    move p4, v2

    .line 241
    goto :goto_3

    .end local p4    # "colorLeft":I
    :cond_5
    move p5, v2

    goto :goto_4

    .end local p5    # "colorTop":I
    :cond_6
    move p6, v2

    goto :goto_5

    .end local p6    # "colorRight":I
    :cond_7
    move p7, v2

    goto :goto_6

    .end local p7    # "colorBottom":I
    .restart local v1    # "orSmear":I
    :cond_8
    move v0, v2

    .line 245
    goto :goto_7
.end method

.method private resolveBorderColor(III)I
    .locals 1
    .param p1, "flag"    # I
    .param p2, "color"    # I
    .param p3, "defaultColor"    # I

    .prologue
    .line 447
    invoke-virtual {p0, p1}, Lcom/facebook/react/flat/DrawBorder;->isFlagSet(I)Z

    move-result v0

    if-eqz v0, :cond_0

    .end local p2    # "color":I
    :goto_0
    return p2

    .restart local p2    # "color":I
    :cond_0
    move p2, p3

    goto :goto_0
.end method

.method private static resolveWidth(FF)F
    .locals 1
    .param p0, "width"    # F
    .param p1, "defaultWidth"    # F

    .prologue
    .line 451
    const/4 v0, 0x0

    cmpl-float v0, p0, v0

    if-eqz v0, :cond_0

    cmpl-float v0, p0, p0

    if-eqz v0, :cond_1

    :cond_0
    move p0, p1

    .end local p0    # "width":F
    :cond_1
    return p0
.end method

.method private static updatePathForBottomBorder(Landroid/graphics/Path;FFFFFF)V
    .locals 0
    .param p0, "path"    # Landroid/graphics/Path;
    .param p1, "bottom"    # F
    .param p2, "bottomInset"    # F
    .param p3, "left"    # F
    .param p4, "leftInset"    # F
    .param p5, "right"    # F
    .param p6, "rightInset"    # F

    .prologue
    .line 406
    invoke-virtual {p0}, Landroid/graphics/Path;->reset()V

    .line 407
    invoke-virtual {p0, p3, p1}, Landroid/graphics/Path;->moveTo(FF)V

    .line 408
    invoke-virtual {p0, p5, p1}, Landroid/graphics/Path;->lineTo(FF)V

    .line 409
    invoke-virtual {p0, p6, p2}, Landroid/graphics/Path;->lineTo(FF)V

    .line 410
    invoke-virtual {p0, p4, p2}, Landroid/graphics/Path;->lineTo(FF)V

    .line 411
    invoke-virtual {p0, p3, p1}, Landroid/graphics/Path;->lineTo(FF)V

    .line 412
    return-void
.end method

.method private static updatePathForLeftBorder(Landroid/graphics/Path;FFFFFF)V
    .locals 0
    .param p0, "path"    # Landroid/graphics/Path;
    .param p1, "top"    # F
    .param p2, "topInset"    # F
    .param p3, "bottom"    # F
    .param p4, "bottomInset"    # F
    .param p5, "left"    # F
    .param p6, "leftInset"    # F

    .prologue
    .line 422
    invoke-virtual {p0}, Landroid/graphics/Path;->reset()V

    .line 423
    invoke-virtual {p0, p5, p1}, Landroid/graphics/Path;->moveTo(FF)V

    .line 424
    invoke-virtual {p0, p6, p2}, Landroid/graphics/Path;->lineTo(FF)V

    .line 425
    invoke-virtual {p0, p6, p4}, Landroid/graphics/Path;->lineTo(FF)V

    .line 426
    invoke-virtual {p0, p5, p3}, Landroid/graphics/Path;->lineTo(FF)V

    .line 427
    invoke-virtual {p0, p5, p1}, Landroid/graphics/Path;->lineTo(FF)V

    .line 428
    return-void
.end method

.method private static updatePathForRightBorder(Landroid/graphics/Path;FFFFFF)V
    .locals 0
    .param p0, "path"    # Landroid/graphics/Path;
    .param p1, "top"    # F
    .param p2, "topInset"    # F
    .param p3, "bottom"    # F
    .param p4, "bottomInset"    # F
    .param p5, "right"    # F
    .param p6, "rightInset"    # F

    .prologue
    .line 438
    invoke-virtual {p0}, Landroid/graphics/Path;->reset()V

    .line 439
    invoke-virtual {p0, p5, p1}, Landroid/graphics/Path;->moveTo(FF)V

    .line 440
    invoke-virtual {p0, p5, p3}, Landroid/graphics/Path;->lineTo(FF)V

    .line 441
    invoke-virtual {p0, p6, p4}, Landroid/graphics/Path;->lineTo(FF)V

    .line 442
    invoke-virtual {p0, p6, p2}, Landroid/graphics/Path;->lineTo(FF)V

    .line 443
    invoke-virtual {p0, p5, p1}, Landroid/graphics/Path;->lineTo(FF)V

    .line 444
    return-void
.end method

.method private static updatePathForTopBorder(Landroid/graphics/Path;FFFFFF)V
    .locals 0
    .param p0, "path"    # Landroid/graphics/Path;
    .param p1, "top"    # F
    .param p2, "topInset"    # F
    .param p3, "left"    # F
    .param p4, "leftInset"    # F
    .param p5, "right"    # F
    .param p6, "rightInset"    # F

    .prologue
    .line 390
    invoke-virtual {p0}, Landroid/graphics/Path;->reset()V

    .line 391
    invoke-virtual {p0, p3, p1}, Landroid/graphics/Path;->moveTo(FF)V

    .line 392
    invoke-virtual {p0, p4, p2}, Landroid/graphics/Path;->lineTo(FF)V

    .line 393
    invoke-virtual {p0, p6, p2}, Landroid/graphics/Path;->lineTo(FF)V

    .line 394
    invoke-virtual {p0, p5, p1}, Landroid/graphics/Path;->lineTo(FF)V

    .line 395
    invoke-virtual {p0, p3, p1}, Landroid/graphics/Path;->lineTo(FF)V

    .line 396
    return-void
.end method


# virtual methods
.method public getBackgroundColor()I
    .locals 1

    .prologue
    .line 175
    iget v0, p0, Lcom/facebook/react/flat/DrawBorder;->mBackgroundColor:I

    return v0
.end method

.method public getBorderColor(I)I
    .locals 3
    .param p1, "position"    # I

    .prologue
    .line 153
    invoke-virtual {p0}, Lcom/facebook/react/flat/DrawBorder;->getBorderColor()I

    move-result v0

    .line 154
    .local v0, "defaultColor":I
    packed-switch p1, :pswitch_data_0

    .line 167
    .end local v0    # "defaultColor":I
    :goto_0
    :pswitch_0
    return v0

    .line 156
    .restart local v0    # "defaultColor":I
    :pswitch_1
    const/4 v1, 0x2

    iget v2, p0, Lcom/facebook/react/flat/DrawBorder;->mBorderLeftColor:I

    invoke-direct {p0, v1, v2, v0}, Lcom/facebook/react/flat/DrawBorder;->resolveBorderColor(III)I

    move-result v0

    goto :goto_0

    .line 158
    :pswitch_2
    const/4 v1, 0x4

    iget v2, p0, Lcom/facebook/react/flat/DrawBorder;->mBorderTopColor:I

    invoke-direct {p0, v1, v2, v0}, Lcom/facebook/react/flat/DrawBorder;->resolveBorderColor(III)I

    move-result v0

    goto :goto_0

    .line 160
    :pswitch_3
    const/16 v1, 0x8

    iget v2, p0, Lcom/facebook/react/flat/DrawBorder;->mBorderRightColor:I

    invoke-direct {p0, v1, v2, v0}, Lcom/facebook/react/flat/DrawBorder;->resolveBorderColor(III)I

    move-result v0

    goto :goto_0

    .line 162
    :pswitch_4
    const/16 v1, 0x10

    iget v2, p0, Lcom/facebook/react/flat/DrawBorder;->mBorderBottomColor:I

    invoke-direct {p0, v1, v2, v0}, Lcom/facebook/react/flat/DrawBorder;->resolveBorderColor(III)I

    move-result v0

    goto :goto_0

    .line 154
    :pswitch_data_0
    .packed-switch 0x0
        :pswitch_1
        :pswitch_2
        :pswitch_3
        :pswitch_4
        :pswitch_0
        :pswitch_0
        :pswitch_0
        :pswitch_0
        :pswitch_0
    .end packed-switch
.end method

.method public getBorderWidth(I)F
    .locals 1
    .param p1, "position"    # I

    .prologue
    .line 80
    packed-switch p1, :pswitch_data_0

    .line 93
    :pswitch_0
    const/4 v0, 0x0

    :goto_0
    return v0

    .line 82
    :pswitch_1
    iget v0, p0, Lcom/facebook/react/flat/DrawBorder;->mBorderLeftWidth:F

    goto :goto_0

    .line 84
    :pswitch_2
    iget v0, p0, Lcom/facebook/react/flat/DrawBorder;->mBorderTopWidth:F

    goto :goto_0

    .line 86
    :pswitch_3
    iget v0, p0, Lcom/facebook/react/flat/DrawBorder;->mBorderRightWidth:F

    goto :goto_0

    .line 88
    :pswitch_4
    iget v0, p0, Lcom/facebook/react/flat/DrawBorder;->mBorderBottomWidth:F

    goto :goto_0

    .line 90
    :pswitch_5
    invoke-virtual {p0}, Lcom/facebook/react/flat/DrawBorder;->getBorderWidth()F

    move-result v0

    goto :goto_0

    .line 80
    :pswitch_data_0
    .packed-switch 0x0
        :pswitch_1
        :pswitch_2
        :pswitch_3
        :pswitch_4
        :pswitch_0
        :pswitch_0
        :pswitch_0
        :pswitch_0
        :pswitch_5
    .end packed-switch
.end method

.method protected getPathEffectForBorderStyle()Landroid/graphics/DashPathEffect;
    .locals 3
    .annotation runtime Ljavax/annotation/Nullable;
    .end annotation

    .prologue
    const/16 v2, 0x20

    .line 189
    invoke-virtual {p0, v2}, Lcom/facebook/react/flat/DrawBorder;->isFlagSet(I)Z

    move-result v0

    if-eqz v0, :cond_0

    .line 190
    iget v0, p0, Lcom/facebook/react/flat/DrawBorder;->mBorderStyle:I

    packed-switch v0, :pswitch_data_0

    .line 200
    const/4 v0, 0x0

    iput-object v0, p0, Lcom/facebook/react/flat/DrawBorder;->mPathEffectForBorderStyle:Landroid/graphics/DashPathEffect;

    .line 204
    :goto_0
    invoke-virtual {p0, v2}, Lcom/facebook/react/flat/DrawBorder;->resetFlag(I)V

    .line 207
    :cond_0
    iget-object v0, p0, Lcom/facebook/react/flat/DrawBorder;->mPathEffectForBorderStyle:Landroid/graphics/DashPathEffect;

    return-object v0

    .line 192
    :pswitch_0
    invoke-virtual {p0}, Lcom/facebook/react/flat/DrawBorder;->getBorderWidth()F

    move-result v0

    invoke-static {v0}, Lcom/facebook/react/flat/DrawBorder;->createDashPathEffect(F)Landroid/graphics/DashPathEffect;

    move-result-object v0

    iput-object v0, p0, Lcom/facebook/react/flat/DrawBorder;->mPathEffectForBorderStyle:Landroid/graphics/DashPathEffect;

    goto :goto_0

    .line 196
    :pswitch_1
    invoke-virtual {p0}, Lcom/facebook/react/flat/DrawBorder;->getBorderWidth()F

    move-result v0

    const/high16 v1, 0x40400000    # 3.0f

    mul-float/2addr v0, v1

    invoke-static {v0}, Lcom/facebook/react/flat/DrawBorder;->createDashPathEffect(F)Landroid/graphics/DashPathEffect;

    move-result-object v0

    iput-object v0, p0, Lcom/facebook/react/flat/DrawBorder;->mPathEffectForBorderStyle:Landroid/graphics/DashPathEffect;

    goto :goto_0

    .line 190
    nop

    :pswitch_data_0
    .packed-switch 0x1
        :pswitch_0
        :pswitch_1
    .end packed-switch
.end method

.method protected bridge synthetic getPathEffectForBorderStyle()Landroid/graphics/PathEffect;
    .locals 1
    .annotation runtime Ljavax/annotation/Nullable;
    .end annotation

    .prologue
    .line 22
    invoke-virtual {p0}, Lcom/facebook/react/flat/DrawBorder;->getPathEffectForBorderStyle()Landroid/graphics/DashPathEffect;

    move-result-object v0

    return-object v0
.end method

.method protected onDraw(Landroid/graphics/Canvas;)V
    .locals 2
    .param p1, "canvas"    # Landroid/graphics/Canvas;

    .prologue
    .line 180
    invoke-virtual {p0}, Lcom/facebook/react/flat/DrawBorder;->getBorderRadius()F

    move-result v0

    const/high16 v1, 0x3f000000    # 0.5f

    cmpl-float v0, v0, v1

    if-gez v0, :cond_0

    invoke-virtual {p0}, Lcom/facebook/react/flat/DrawBorder;->getPathEffectForBorderStyle()Landroid/graphics/DashPathEffect;

    move-result-object v0

    if-eqz v0, :cond_1

    .line 181
    :cond_0
    invoke-direct {p0, p1}, Lcom/facebook/react/flat/DrawBorder;->drawRoundedBorders(Landroid/graphics/Canvas;)V

    .line 185
    :goto_0
    return-void

    .line 183
    :cond_1
    invoke-direct {p0, p1}, Lcom/facebook/react/flat/DrawBorder;->drawRectangularBorders(Landroid/graphics/Canvas;)V

    goto :goto_0
.end method

.method public resetBorderColor(I)V
    .locals 1
    .param p1, "position"    # I

    .prologue
    .line 109
    packed-switch p1, :pswitch_data_0

    .line 126
    :goto_0
    :pswitch_0
    return-void

    .line 111
    :pswitch_1
    const/4 v0, 0x2

    invoke-virtual {p0, v0}, Lcom/facebook/react/flat/DrawBorder;->resetFlag(I)V

    goto :goto_0

    .line 114
    :pswitch_2
    const/4 v0, 0x4

    invoke-virtual {p0, v0}, Lcom/facebook/react/flat/DrawBorder;->resetFlag(I)V

    goto :goto_0

    .line 117
    :pswitch_3
    const/16 v0, 0x8

    invoke-virtual {p0, v0}, Lcom/facebook/react/flat/DrawBorder;->resetFlag(I)V

    goto :goto_0

    .line 120
    :pswitch_4
    const/16 v0, 0x10

    invoke-virtual {p0, v0}, Lcom/facebook/react/flat/DrawBorder;->resetFlag(I)V

    goto :goto_0

    .line 123
    :pswitch_5
    const/high16 v0, -0x1000000

    invoke-virtual {p0, v0}, Lcom/facebook/react/flat/DrawBorder;->setBorderColor(I)V

    goto :goto_0

    .line 109
    :pswitch_data_0
    .packed-switch 0x0
        :pswitch_1
        :pswitch_2
        :pswitch_3
        :pswitch_4
        :pswitch_0
        :pswitch_0
        :pswitch_0
        :pswitch_0
        :pswitch_5
    .end packed-switch
.end method

.method public setBackgroundColor(I)V
    .locals 0
    .param p1, "backgroundColor"    # I

    .prologue
    .line 171
    iput p1, p0, Lcom/facebook/react/flat/DrawBorder;->mBackgroundColor:I

    .line 172
    return-void
.end method

.method public setBorderColor(II)V
    .locals 1
    .param p1, "position"    # I
    .param p2, "borderColor"    # I

    .prologue
    .line 129
    packed-switch p1, :pswitch_data_0

    .line 150
    :goto_0
    :pswitch_0
    return-void

    .line 131
    :pswitch_1
    iput p2, p0, Lcom/facebook/react/flat/DrawBorder;->mBorderLeftColor:I

    .line 132
    const/4 v0, 0x2

    invoke-virtual {p0, v0}, Lcom/facebook/react/flat/DrawBorder;->setFlag(I)V

    goto :goto_0

    .line 135
    :pswitch_2
    iput p2, p0, Lcom/facebook/react/flat/DrawBorder;->mBorderTopColor:I

    .line 136
    const/4 v0, 0x4

    invoke-virtual {p0, v0}, Lcom/facebook/react/flat/DrawBorder;->setFlag(I)V

    goto :goto_0

    .line 139
    :pswitch_3
    iput p2, p0, Lcom/facebook/react/flat/DrawBorder;->mBorderRightColor:I

    .line 140
    const/16 v0, 0x8

    invoke-virtual {p0, v0}, Lcom/facebook/react/flat/DrawBorder;->setFlag(I)V

    goto :goto_0

    .line 143
    :pswitch_4
    iput p2, p0, Lcom/facebook/react/flat/DrawBorder;->mBorderBottomColor:I

    .line 144
    const/16 v0, 0x10

    invoke-virtual {p0, v0}, Lcom/facebook/react/flat/DrawBorder;->setFlag(I)V

    goto :goto_0

    .line 147
    :pswitch_5
    invoke-virtual {p0, p2}, Lcom/facebook/react/flat/DrawBorder;->setBorderColor(I)V

    goto :goto_0

    .line 129
    :pswitch_data_0
    .packed-switch 0x0
        :pswitch_1
        :pswitch_2
        :pswitch_3
        :pswitch_4
        :pswitch_0
        :pswitch_0
        :pswitch_0
        :pswitch_0
        :pswitch_5
    .end packed-switch
.end method

.method public setBorderStyle(Ljava/lang/String;)V
    .locals 1
    .param p1, "style"    # Ljava/lang/String;
        .annotation runtime Ljavax/annotation/Nullable;
        .end annotation
    .end param

    .prologue
    .line 97
    const-string v0, "dotted"

    invoke-virtual {v0, p1}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-eqz v0, :cond_0

    .line 98
    const/4 v0, 0x1

    iput v0, p0, Lcom/facebook/react/flat/DrawBorder;->mBorderStyle:I

    .line 105
    :goto_0
    const/16 v0, 0x20

    invoke-virtual {p0, v0}, Lcom/facebook/react/flat/DrawBorder;->setFlag(I)V

    .line 106
    return-void

    .line 99
    :cond_0
    const-string v0, "dashed"

    invoke-virtual {v0, p1}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-eqz v0, :cond_1

    .line 100
    const/4 v0, 0x2

    iput v0, p0, Lcom/facebook/react/flat/DrawBorder;->mBorderStyle:I

    goto :goto_0

    .line 102
    :cond_1
    const/4 v0, 0x0

    iput v0, p0, Lcom/facebook/react/flat/DrawBorder;->mBorderStyle:I

    goto :goto_0
.end method

.method public setBorderWidth(IF)V
    .locals 0
    .param p1, "position"    # I
    .param p2, "borderWidth"    # F

    .prologue
    .line 60
    packed-switch p1, :pswitch_data_0

    .line 77
    :goto_0
    :pswitch_0
    return-void

    .line 62
    :pswitch_1
    iput p2, p0, Lcom/facebook/react/flat/DrawBorder;->mBorderLeftWidth:F

    goto :goto_0

    .line 65
    :pswitch_2
    iput p2, p0, Lcom/facebook/react/flat/DrawBorder;->mBorderTopWidth:F

    goto :goto_0

    .line 68
    :pswitch_3
    iput p2, p0, Lcom/facebook/react/flat/DrawBorder;->mBorderRightWidth:F

    goto :goto_0

    .line 71
    :pswitch_4
    iput p2, p0, Lcom/facebook/react/flat/DrawBorder;->mBorderBottomWidth:F

    goto :goto_0

    .line 74
    :pswitch_5
    invoke-virtual {p0, p2}, Lcom/facebook/react/flat/DrawBorder;->setBorderWidth(F)V

    goto :goto_0

    .line 60
    :pswitch_data_0
    .packed-switch 0x0
        :pswitch_1
        :pswitch_2
        :pswitch_3
        :pswitch_4
        :pswitch_0
        :pswitch_0
        :pswitch_0
        :pswitch_0
        :pswitch_5
    .end packed-switch
.end method

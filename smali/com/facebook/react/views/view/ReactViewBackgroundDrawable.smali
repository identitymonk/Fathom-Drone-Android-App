.class public Lcom/facebook/react/views/view/ReactViewBackgroundDrawable;
.super Landroid/graphics/drawable/Drawable;
.source "ReactViewBackgroundDrawable.java"


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lcom/facebook/react/views/view/ReactViewBackgroundDrawable$BorderStyle;
    }
.end annotation


# static fields
.field private static final ALL_BITS_SET:I = -0x1

.field private static final ALL_BITS_UNSET:I = 0x0

.field private static final DEFAULT_BORDER_ALPHA:I = 0xff

.field private static final DEFAULT_BORDER_COLOR:I = -0x1000000

.field private static final DEFAULT_BORDER_RGB:I


# instance fields
.field private mAlpha:I

.field private mBorderAlpha:Lcom/facebook/react/uimanager/Spacing;
    .annotation runtime Ljavax/annotation/Nullable;
    .end annotation
.end field

.field private mBorderCornerRadii:[F
    .annotation runtime Ljavax/annotation/Nullable;
    .end annotation
.end field

.field private mBorderRGB:Lcom/facebook/react/uimanager/Spacing;
    .annotation runtime Ljavax/annotation/Nullable;
    .end annotation
.end field

.field private mBorderRadius:F

.field private mBorderStyle:Lcom/facebook/react/views/view/ReactViewBackgroundDrawable$BorderStyle;
    .annotation runtime Ljavax/annotation/Nullable;
    .end annotation
.end field

.field private mBorderWidth:Lcom/facebook/react/uimanager/Spacing;
    .annotation runtime Ljavax/annotation/Nullable;
    .end annotation
.end field

.field private mColor:I

.field private mNeedUpdatePathForBorderRadius:Z

.field private final mPaint:Landroid/graphics/Paint;

.field private mPathEffectForBorderStyle:Landroid/graphics/PathEffect;
    .annotation runtime Ljavax/annotation/Nullable;
    .end annotation
.end field

.field private mPathForBorder:Landroid/graphics/Path;
    .annotation runtime Ljavax/annotation/Nullable;
    .end annotation
.end field

.field private mPathForBorderRadius:Landroid/graphics/Path;
    .annotation runtime Ljavax/annotation/Nullable;
    .end annotation
.end field

.field private mPathForBorderRadiusOutline:Landroid/graphics/Path;
    .annotation runtime Ljavax/annotation/Nullable;
    .end annotation
.end field

.field private mTempRectForBorderRadius:Landroid/graphics/RectF;
    .annotation runtime Ljavax/annotation/Nullable;
    .end annotation
.end field

.field private mTempRectForBorderRadiusOutline:Landroid/graphics/RectF;
    .annotation runtime Ljavax/annotation/Nullable;
    .end annotation
.end field


# direct methods
.method public constructor <init>()V
    .locals 3

    .prologue
    const/4 v2, 0x0

    .line 43
    invoke-direct {p0}, Landroid/graphics/drawable/Drawable;-><init>()V

    .line 91
    iput-boolean v2, p0, Lcom/facebook/react/views/view/ReactViewBackgroundDrawable;->mNeedUpdatePathForBorderRadius:Z

    .line 92
    const/high16 v0, 0x7fc00000    # Float.NaN

    iput v0, p0, Lcom/facebook/react/views/view/ReactViewBackgroundDrawable;->mBorderRadius:F

    .line 95
    new-instance v0, Landroid/graphics/Paint;

    const/4 v1, 0x1

    invoke-direct {v0, v1}, Landroid/graphics/Paint;-><init>(I)V

    iput-object v0, p0, Lcom/facebook/react/views/view/ReactViewBackgroundDrawable;->mPaint:Landroid/graphics/Paint;

    .line 96
    iput v2, p0, Lcom/facebook/react/views/view/ReactViewBackgroundDrawable;->mColor:I

    .line 97
    const/16 v0, 0xff

    iput v0, p0, Lcom/facebook/react/views/view/ReactViewBackgroundDrawable;->mAlpha:I

    return-void
.end method

.method private static colorFromAlphaAndRGBComponents(FF)I
    .locals 4
    .param p0, "alpha"    # F
    .param p1, "rgb"    # F

    .prologue
    .line 514
    const v2, 0xffffff

    float-to-int v3, p1

    and-int v1, v2, v3

    .line 515
    .local v1, "rgbComponent":I
    const/high16 v2, -0x1000000

    float-to-int v3, p0

    shl-int/lit8 v3, v3, 0x18

    and-int v0, v2, v3

    .line 517
    .local v0, "alphaComponent":I
    or-int v2, v1, v0

    return v2
.end method

.method private drawRectangularBackgroundWithBorders(Landroid/graphics/Canvas;)V
    .locals 28
    .param p1, "canvas"    # Landroid/graphics/Canvas;

    .prologue
    .line 386
    move-object/from16 v0, p0

    iget v9, v0, Lcom/facebook/react/views/view/ReactViewBackgroundDrawable;->mColor:I

    move-object/from16 v0, p0

    iget v10, v0, Lcom/facebook/react/views/view/ReactViewBackgroundDrawable;->mAlpha:I

    invoke-static {v9, v10}, Lcom/facebook/react/views/view/ColorUtil;->multiplyColorAlpha(II)I

    move-result v26

    .line 387
    .local v26, "useColor":I
    invoke-static/range {v26 .. v26}, Landroid/graphics/Color;->alpha(I)I

    move-result v9

    if-eqz v9, :cond_0

    .line 388
    move-object/from16 v0, p0

    iget-object v9, v0, Lcom/facebook/react/views/view/ReactViewBackgroundDrawable;->mPaint:Landroid/graphics/Paint;

    move/from16 v0, v26

    invoke-virtual {v9, v0}, Landroid/graphics/Paint;->setColor(I)V

    .line 389
    move-object/from16 v0, p0

    iget-object v9, v0, Lcom/facebook/react/views/view/ReactViewBackgroundDrawable;->mPaint:Landroid/graphics/Paint;

    sget-object v10, Landroid/graphics/Paint$Style;->FILL:Landroid/graphics/Paint$Style;

    invoke-virtual {v9, v10}, Landroid/graphics/Paint;->setStyle(Landroid/graphics/Paint$Style;)V

    .line 390
    invoke-virtual/range {p0 .. p0}, Lcom/facebook/react/views/view/ReactViewBackgroundDrawable;->getBounds()Landroid/graphics/Rect;

    move-result-object v9

    move-object/from16 v0, p0

    iget-object v10, v0, Lcom/facebook/react/views/view/ReactViewBackgroundDrawable;->mPaint:Landroid/graphics/Paint;

    move-object/from16 v0, p1

    invoke-virtual {v0, v9, v10}, Landroid/graphics/Canvas;->drawRect(Landroid/graphics/Rect;Landroid/graphics/Paint;)V

    .line 393
    :cond_0
    const/4 v9, 0x0

    move-object/from16 v0, p0

    invoke-direct {v0, v9}, Lcom/facebook/react/views/view/ReactViewBackgroundDrawable;->getBorderWidth(I)I

    move-result v9

    if-gtz v9, :cond_1

    const/4 v9, 0x1

    move-object/from16 v0, p0

    invoke-direct {v0, v9}, Lcom/facebook/react/views/view/ReactViewBackgroundDrawable;->getBorderWidth(I)I

    move-result v9

    if-gtz v9, :cond_1

    const/4 v9, 0x2

    .line 394
    move-object/from16 v0, p0

    invoke-direct {v0, v9}, Lcom/facebook/react/views/view/ReactViewBackgroundDrawable;->getBorderWidth(I)I

    move-result v9

    if-gtz v9, :cond_1

    const/4 v9, 0x3

    move-object/from16 v0, p0

    invoke-direct {v0, v9}, Lcom/facebook/react/views/view/ReactViewBackgroundDrawable;->getBorderWidth(I)I

    move-result v9

    if-lez v9, :cond_5

    .line 395
    :cond_1
    invoke-virtual/range {p0 .. p0}, Lcom/facebook/react/views/view/ReactViewBackgroundDrawable;->getBounds()Landroid/graphics/Rect;

    move-result-object v17

    .line 397
    .local v17, "bounds":Landroid/graphics/Rect;
    const/4 v9, 0x0

    move-object/from16 v0, p0

    invoke-direct {v0, v9}, Lcom/facebook/react/views/view/ReactViewBackgroundDrawable;->getBorderWidth(I)I

    move-result v1

    .line 398
    .local v1, "borderLeft":I
    const/4 v9, 0x1

    move-object/from16 v0, p0

    invoke-direct {v0, v9}, Lcom/facebook/react/views/view/ReactViewBackgroundDrawable;->getBorderWidth(I)I

    move-result v2

    .line 399
    .local v2, "borderTop":I
    const/4 v9, 0x2

    move-object/from16 v0, p0

    invoke-direct {v0, v9}, Lcom/facebook/react/views/view/ReactViewBackgroundDrawable;->getBorderWidth(I)I

    move-result v3

    .line 400
    .local v3, "borderRight":I
    const/4 v9, 0x3

    move-object/from16 v0, p0

    invoke-direct {v0, v9}, Lcom/facebook/react/views/view/ReactViewBackgroundDrawable;->getBorderWidth(I)I

    move-result v4

    .line 401
    .local v4, "borderBottom":I
    const/4 v9, 0x0

    move-object/from16 v0, p0

    invoke-direct {v0, v9}, Lcom/facebook/react/views/view/ReactViewBackgroundDrawable;->getBorderColor(I)I

    move-result v5

    .line 402
    .local v5, "colorLeft":I
    const/4 v9, 0x1

    move-object/from16 v0, p0

    invoke-direct {v0, v9}, Lcom/facebook/react/views/view/ReactViewBackgroundDrawable;->getBorderColor(I)I

    move-result v6

    .line 403
    .local v6, "colorTop":I
    const/4 v9, 0x2

    move-object/from16 v0, p0

    invoke-direct {v0, v9}, Lcom/facebook/react/views/view/ReactViewBackgroundDrawable;->getBorderColor(I)I

    move-result v7

    .line 404
    .local v7, "colorRight":I
    const/4 v9, 0x3

    move-object/from16 v0, p0

    invoke-direct {v0, v9}, Lcom/facebook/react/views/view/ReactViewBackgroundDrawable;->getBorderColor(I)I

    move-result v8

    .line 406
    .local v8, "colorBottom":I
    move-object/from16 v0, v17

    iget v0, v0, Landroid/graphics/Rect;->left:I

    move/from16 v20, v0

    .line 407
    .local v20, "left":I
    move-object/from16 v0, v17

    iget v0, v0, Landroid/graphics/Rect;->top:I

    move/from16 v24, v0

    .line 410
    .local v24, "top":I
    invoke-static/range {v1 .. v8}, Lcom/facebook/react/views/view/ReactViewBackgroundDrawable;->fastBorderCompatibleColorOrZero(IIIIIIII)I

    move-result v18

    .line 419
    .local v18, "fastBorderColor":I
    if-eqz v18, :cond_6

    .line 420
    invoke-static/range {v18 .. v18}, Landroid/graphics/Color;->alpha(I)I

    move-result v9

    if-eqz v9, :cond_5

    .line 422
    move-object/from16 v0, v17

    iget v0, v0, Landroid/graphics/Rect;->right:I

    move/from16 v22, v0

    .line 423
    .local v22, "right":I
    move-object/from16 v0, v17

    iget v15, v0, Landroid/graphics/Rect;->bottom:I

    .line 425
    .local v15, "bottom":I
    move-object/from16 v0, p0

    iget-object v9, v0, Lcom/facebook/react/views/view/ReactViewBackgroundDrawable;->mPaint:Landroid/graphics/Paint;

    move/from16 v0, v18

    invoke-virtual {v9, v0}, Landroid/graphics/Paint;->setColor(I)V

    .line 426
    if-lez v1, :cond_2

    .line 427
    add-int v21, v20, v1

    .line 428
    .local v21, "leftInset":I
    move/from16 v0, v20

    int-to-float v10, v0

    move/from16 v0, v24

    int-to-float v11, v0

    move/from16 v0, v21

    int-to-float v12, v0

    sub-int v9, v15, v4

    int-to-float v13, v9

    move-object/from16 v0, p0

    iget-object v14, v0, Lcom/facebook/react/views/view/ReactViewBackgroundDrawable;->mPaint:Landroid/graphics/Paint;

    move-object/from16 v9, p1

    invoke-virtual/range {v9 .. v14}, Landroid/graphics/Canvas;->drawRect(FFFFLandroid/graphics/Paint;)V

    .line 430
    .end local v21    # "leftInset":I
    :cond_2
    if-lez v2, :cond_3

    .line 431
    add-int v25, v24, v2

    .line 432
    .local v25, "topInset":I
    add-int v9, v20, v1

    int-to-float v10, v9

    move/from16 v0, v24

    int-to-float v11, v0

    move/from16 v0, v22

    int-to-float v12, v0

    move/from16 v0, v25

    int-to-float v13, v0

    move-object/from16 v0, p0

    iget-object v14, v0, Lcom/facebook/react/views/view/ReactViewBackgroundDrawable;->mPaint:Landroid/graphics/Paint;

    move-object/from16 v9, p1

    invoke-virtual/range {v9 .. v14}, Landroid/graphics/Canvas;->drawRect(FFFFLandroid/graphics/Paint;)V

    .line 434
    .end local v25    # "topInset":I
    :cond_3
    if-lez v3, :cond_4

    .line 435
    sub-int v23, v22, v3

    .line 436
    .local v23, "rightInset":I
    move/from16 v0, v23

    int-to-float v10, v0

    add-int v9, v24, v2

    int-to-float v11, v9

    move/from16 v0, v22

    int-to-float v12, v0

    int-to-float v13, v15

    move-object/from16 v0, p0

    iget-object v14, v0, Lcom/facebook/react/views/view/ReactViewBackgroundDrawable;->mPaint:Landroid/graphics/Paint;

    move-object/from16 v9, p1

    invoke-virtual/range {v9 .. v14}, Landroid/graphics/Canvas;->drawRect(FFFFLandroid/graphics/Paint;)V

    .line 438
    .end local v23    # "rightInset":I
    :cond_4
    if-lez v4, :cond_5

    .line 439
    sub-int v16, v15, v4

    .line 440
    .local v16, "bottomInset":I
    move/from16 v0, v20

    int-to-float v10, v0

    move/from16 v0, v16

    int-to-float v11, v0

    sub-int v9, v22, v3

    int-to-float v12, v9

    int-to-float v13, v15

    move-object/from16 v0, p0

    iget-object v14, v0, Lcom/facebook/react/views/view/ReactViewBackgroundDrawable;->mPaint:Landroid/graphics/Paint;

    move-object/from16 v9, p1

    invoke-virtual/range {v9 .. v14}, Landroid/graphics/Canvas;->drawRect(FFFFLandroid/graphics/Paint;)V

    .line 507
    .end local v1    # "borderLeft":I
    .end local v2    # "borderTop":I
    .end local v3    # "borderRight":I
    .end local v4    # "borderBottom":I
    .end local v5    # "colorLeft":I
    .end local v6    # "colorTop":I
    .end local v7    # "colorRight":I
    .end local v8    # "colorBottom":I
    .end local v15    # "bottom":I
    .end local v16    # "bottomInset":I
    .end local v17    # "bounds":Landroid/graphics/Rect;
    .end local v18    # "fastBorderColor":I
    .end local v20    # "left":I
    .end local v22    # "right":I
    .end local v24    # "top":I
    :cond_5
    :goto_0
    return-void

    .line 444
    .restart local v1    # "borderLeft":I
    .restart local v2    # "borderTop":I
    .restart local v3    # "borderRight":I
    .restart local v4    # "borderBottom":I
    .restart local v5    # "colorLeft":I
    .restart local v6    # "colorTop":I
    .restart local v7    # "colorRight":I
    .restart local v8    # "colorBottom":I
    .restart local v17    # "bounds":Landroid/graphics/Rect;
    .restart local v18    # "fastBorderColor":I
    .restart local v20    # "left":I
    .restart local v24    # "top":I
    :cond_6
    move-object/from16 v0, p0

    iget-object v9, v0, Lcom/facebook/react/views/view/ReactViewBackgroundDrawable;->mPathForBorder:Landroid/graphics/Path;

    if-nez v9, :cond_7

    .line 445
    new-instance v9, Landroid/graphics/Path;

    invoke-direct {v9}, Landroid/graphics/Path;-><init>()V

    move-object/from16 v0, p0

    iput-object v9, v0, Lcom/facebook/react/views/view/ReactViewBackgroundDrawable;->mPathForBorder:Landroid/graphics/Path;

    .line 454
    :cond_7
    move-object/from16 v0, p0

    iget-object v9, v0, Lcom/facebook/react/views/view/ReactViewBackgroundDrawable;->mPaint:Landroid/graphics/Paint;

    const/4 v10, 0x0

    invoke-virtual {v9, v10}, Landroid/graphics/Paint;->setAntiAlias(Z)V

    .line 456
    invoke-virtual/range {v17 .. v17}, Landroid/graphics/Rect;->width()I

    move-result v27

    .line 457
    .local v27, "width":I
    invoke-virtual/range {v17 .. v17}, Landroid/graphics/Rect;->height()I

    move-result v19

    .line 459
    .local v19, "height":I
    if-lez v1, :cond_8

    if-eqz v5, :cond_8

    .line 460
    move-object/from16 v0, p0

    iget-object v9, v0, Lcom/facebook/react/views/view/ReactViewBackgroundDrawable;->mPaint:Landroid/graphics/Paint;

    invoke-virtual {v9, v5}, Landroid/graphics/Paint;->setColor(I)V

    .line 461
    move-object/from16 v0, p0

    iget-object v9, v0, Lcom/facebook/react/views/view/ReactViewBackgroundDrawable;->mPathForBorder:Landroid/graphics/Path;

    invoke-virtual {v9}, Landroid/graphics/Path;->reset()V

    .line 462
    move-object/from16 v0, p0

    iget-object v9, v0, Lcom/facebook/react/views/view/ReactViewBackgroundDrawable;->mPathForBorder:Landroid/graphics/Path;

    move/from16 v0, v20

    int-to-float v10, v0

    move/from16 v0, v24

    int-to-float v11, v0

    invoke-virtual {v9, v10, v11}, Landroid/graphics/Path;->moveTo(FF)V

    .line 463
    move-object/from16 v0, p0

    iget-object v9, v0, Lcom/facebook/react/views/view/ReactViewBackgroundDrawable;->mPathForBorder:Landroid/graphics/Path;

    add-int v10, v20, v1

    int-to-float v10, v10

    add-int v11, v24, v2

    int-to-float v11, v11

    invoke-virtual {v9, v10, v11}, Landroid/graphics/Path;->lineTo(FF)V

    .line 464
    move-object/from16 v0, p0

    iget-object v9, v0, Lcom/facebook/react/views/view/ReactViewBackgroundDrawable;->mPathForBorder:Landroid/graphics/Path;

    add-int v10, v20, v1

    int-to-float v10, v10

    add-int v11, v24, v19

    sub-int/2addr v11, v4

    int-to-float v11, v11

    invoke-virtual {v9, v10, v11}, Landroid/graphics/Path;->lineTo(FF)V

    .line 465
    move-object/from16 v0, p0

    iget-object v9, v0, Lcom/facebook/react/views/view/ReactViewBackgroundDrawable;->mPathForBorder:Landroid/graphics/Path;

    move/from16 v0, v20

    int-to-float v10, v0

    add-int v11, v24, v19

    int-to-float v11, v11

    invoke-virtual {v9, v10, v11}, Landroid/graphics/Path;->lineTo(FF)V

    .line 466
    move-object/from16 v0, p0

    iget-object v9, v0, Lcom/facebook/react/views/view/ReactViewBackgroundDrawable;->mPathForBorder:Landroid/graphics/Path;

    move/from16 v0, v20

    int-to-float v10, v0

    move/from16 v0, v24

    int-to-float v11, v0

    invoke-virtual {v9, v10, v11}, Landroid/graphics/Path;->lineTo(FF)V

    .line 467
    move-object/from16 v0, p0

    iget-object v9, v0, Lcom/facebook/react/views/view/ReactViewBackgroundDrawable;->mPathForBorder:Landroid/graphics/Path;

    move-object/from16 v0, p0

    iget-object v10, v0, Lcom/facebook/react/views/view/ReactViewBackgroundDrawable;->mPaint:Landroid/graphics/Paint;

    move-object/from16 v0, p1

    invoke-virtual {v0, v9, v10}, Landroid/graphics/Canvas;->drawPath(Landroid/graphics/Path;Landroid/graphics/Paint;)V

    .line 470
    :cond_8
    if-lez v2, :cond_9

    if-eqz v6, :cond_9

    .line 471
    move-object/from16 v0, p0

    iget-object v9, v0, Lcom/facebook/react/views/view/ReactViewBackgroundDrawable;->mPaint:Landroid/graphics/Paint;

    invoke-virtual {v9, v6}, Landroid/graphics/Paint;->setColor(I)V

    .line 472
    move-object/from16 v0, p0

    iget-object v9, v0, Lcom/facebook/react/views/view/ReactViewBackgroundDrawable;->mPathForBorder:Landroid/graphics/Path;

    invoke-virtual {v9}, Landroid/graphics/Path;->reset()V

    .line 473
    move-object/from16 v0, p0

    iget-object v9, v0, Lcom/facebook/react/views/view/ReactViewBackgroundDrawable;->mPathForBorder:Landroid/graphics/Path;

    move/from16 v0, v20

    int-to-float v10, v0

    move/from16 v0, v24

    int-to-float v11, v0

    invoke-virtual {v9, v10, v11}, Landroid/graphics/Path;->moveTo(FF)V

    .line 474
    move-object/from16 v0, p0

    iget-object v9, v0, Lcom/facebook/react/views/view/ReactViewBackgroundDrawable;->mPathForBorder:Landroid/graphics/Path;

    add-int v10, v20, v1

    int-to-float v10, v10

    add-int v11, v24, v2

    int-to-float v11, v11

    invoke-virtual {v9, v10, v11}, Landroid/graphics/Path;->lineTo(FF)V

    .line 475
    move-object/from16 v0, p0

    iget-object v9, v0, Lcom/facebook/react/views/view/ReactViewBackgroundDrawable;->mPathForBorder:Landroid/graphics/Path;

    add-int v10, v20, v27

    sub-int/2addr v10, v3

    int-to-float v10, v10

    add-int v11, v24, v2

    int-to-float v11, v11

    invoke-virtual {v9, v10, v11}, Landroid/graphics/Path;->lineTo(FF)V

    .line 476
    move-object/from16 v0, p0

    iget-object v9, v0, Lcom/facebook/react/views/view/ReactViewBackgroundDrawable;->mPathForBorder:Landroid/graphics/Path;

    add-int v10, v20, v27

    int-to-float v10, v10

    move/from16 v0, v24

    int-to-float v11, v0

    invoke-virtual {v9, v10, v11}, Landroid/graphics/Path;->lineTo(FF)V

    .line 477
    move-object/from16 v0, p0

    iget-object v9, v0, Lcom/facebook/react/views/view/ReactViewBackgroundDrawable;->mPathForBorder:Landroid/graphics/Path;

    move/from16 v0, v20

    int-to-float v10, v0

    move/from16 v0, v24

    int-to-float v11, v0

    invoke-virtual {v9, v10, v11}, Landroid/graphics/Path;->lineTo(FF)V

    .line 478
    move-object/from16 v0, p0

    iget-object v9, v0, Lcom/facebook/react/views/view/ReactViewBackgroundDrawable;->mPathForBorder:Landroid/graphics/Path;

    move-object/from16 v0, p0

    iget-object v10, v0, Lcom/facebook/react/views/view/ReactViewBackgroundDrawable;->mPaint:Landroid/graphics/Paint;

    move-object/from16 v0, p1

    invoke-virtual {v0, v9, v10}, Landroid/graphics/Canvas;->drawPath(Landroid/graphics/Path;Landroid/graphics/Paint;)V

    .line 481
    :cond_9
    if-lez v3, :cond_a

    if-eqz v7, :cond_a

    .line 482
    move-object/from16 v0, p0

    iget-object v9, v0, Lcom/facebook/react/views/view/ReactViewBackgroundDrawable;->mPaint:Landroid/graphics/Paint;

    invoke-virtual {v9, v7}, Landroid/graphics/Paint;->setColor(I)V

    .line 483
    move-object/from16 v0, p0

    iget-object v9, v0, Lcom/facebook/react/views/view/ReactViewBackgroundDrawable;->mPathForBorder:Landroid/graphics/Path;

    invoke-virtual {v9}, Landroid/graphics/Path;->reset()V

    .line 484
    move-object/from16 v0, p0

    iget-object v9, v0, Lcom/facebook/react/views/view/ReactViewBackgroundDrawable;->mPathForBorder:Landroid/graphics/Path;

    add-int v10, v20, v27

    int-to-float v10, v10

    move/from16 v0, v24

    int-to-float v11, v0

    invoke-virtual {v9, v10, v11}, Landroid/graphics/Path;->moveTo(FF)V

    .line 485
    move-object/from16 v0, p0

    iget-object v9, v0, Lcom/facebook/react/views/view/ReactViewBackgroundDrawable;->mPathForBorder:Landroid/graphics/Path;

    add-int v10, v20, v27

    int-to-float v10, v10

    add-int v11, v24, v19

    int-to-float v11, v11

    invoke-virtual {v9, v10, v11}, Landroid/graphics/Path;->lineTo(FF)V

    .line 486
    move-object/from16 v0, p0

    iget-object v9, v0, Lcom/facebook/react/views/view/ReactViewBackgroundDrawable;->mPathForBorder:Landroid/graphics/Path;

    add-int v10, v20, v27

    sub-int/2addr v10, v3

    int-to-float v10, v10

    add-int v11, v24, v19

    sub-int/2addr v11, v4

    int-to-float v11, v11

    invoke-virtual {v9, v10, v11}, Landroid/graphics/Path;->lineTo(FF)V

    .line 487
    move-object/from16 v0, p0

    iget-object v9, v0, Lcom/facebook/react/views/view/ReactViewBackgroundDrawable;->mPathForBorder:Landroid/graphics/Path;

    add-int v10, v20, v27

    sub-int/2addr v10, v3

    int-to-float v10, v10

    add-int v11, v24, v2

    int-to-float v11, v11

    invoke-virtual {v9, v10, v11}, Landroid/graphics/Path;->lineTo(FF)V

    .line 488
    move-object/from16 v0, p0

    iget-object v9, v0, Lcom/facebook/react/views/view/ReactViewBackgroundDrawable;->mPathForBorder:Landroid/graphics/Path;

    add-int v10, v20, v27

    int-to-float v10, v10

    move/from16 v0, v24

    int-to-float v11, v0

    invoke-virtual {v9, v10, v11}, Landroid/graphics/Path;->lineTo(FF)V

    .line 489
    move-object/from16 v0, p0

    iget-object v9, v0, Lcom/facebook/react/views/view/ReactViewBackgroundDrawable;->mPathForBorder:Landroid/graphics/Path;

    move-object/from16 v0, p0

    iget-object v10, v0, Lcom/facebook/react/views/view/ReactViewBackgroundDrawable;->mPaint:Landroid/graphics/Paint;

    move-object/from16 v0, p1

    invoke-virtual {v0, v9, v10}, Landroid/graphics/Canvas;->drawPath(Landroid/graphics/Path;Landroid/graphics/Paint;)V

    .line 492
    :cond_a
    if-lez v4, :cond_b

    if-eqz v8, :cond_b

    .line 493
    move-object/from16 v0, p0

    iget-object v9, v0, Lcom/facebook/react/views/view/ReactViewBackgroundDrawable;->mPaint:Landroid/graphics/Paint;

    invoke-virtual {v9, v8}, Landroid/graphics/Paint;->setColor(I)V

    .line 494
    move-object/from16 v0, p0

    iget-object v9, v0, Lcom/facebook/react/views/view/ReactViewBackgroundDrawable;->mPathForBorder:Landroid/graphics/Path;

    invoke-virtual {v9}, Landroid/graphics/Path;->reset()V

    .line 495
    move-object/from16 v0, p0

    iget-object v9, v0, Lcom/facebook/react/views/view/ReactViewBackgroundDrawable;->mPathForBorder:Landroid/graphics/Path;

    move/from16 v0, v20

    int-to-float v10, v0

    add-int v11, v24, v19

    int-to-float v11, v11

    invoke-virtual {v9, v10, v11}, Landroid/graphics/Path;->moveTo(FF)V

    .line 496
    move-object/from16 v0, p0

    iget-object v9, v0, Lcom/facebook/react/views/view/ReactViewBackgroundDrawable;->mPathForBorder:Landroid/graphics/Path;

    add-int v10, v20, v27

    int-to-float v10, v10

    add-int v11, v24, v19

    int-to-float v11, v11

    invoke-virtual {v9, v10, v11}, Landroid/graphics/Path;->lineTo(FF)V

    .line 497
    move-object/from16 v0, p0

    iget-object v9, v0, Lcom/facebook/react/views/view/ReactViewBackgroundDrawable;->mPathForBorder:Landroid/graphics/Path;

    add-int v10, v20, v27

    sub-int/2addr v10, v3

    int-to-float v10, v10

    add-int v11, v24, v19

    sub-int/2addr v11, v4

    int-to-float v11, v11

    invoke-virtual {v9, v10, v11}, Landroid/graphics/Path;->lineTo(FF)V

    .line 498
    move-object/from16 v0, p0

    iget-object v9, v0, Lcom/facebook/react/views/view/ReactViewBackgroundDrawable;->mPathForBorder:Landroid/graphics/Path;

    add-int v10, v20, v1

    int-to-float v10, v10

    add-int v11, v24, v19

    sub-int/2addr v11, v4

    int-to-float v11, v11

    invoke-virtual {v9, v10, v11}, Landroid/graphics/Path;->lineTo(FF)V

    .line 499
    move-object/from16 v0, p0

    iget-object v9, v0, Lcom/facebook/react/views/view/ReactViewBackgroundDrawable;->mPathForBorder:Landroid/graphics/Path;

    move/from16 v0, v20

    int-to-float v10, v0

    add-int v11, v24, v19

    int-to-float v11, v11

    invoke-virtual {v9, v10, v11}, Landroid/graphics/Path;->lineTo(FF)V

    .line 500
    move-object/from16 v0, p0

    iget-object v9, v0, Lcom/facebook/react/views/view/ReactViewBackgroundDrawable;->mPathForBorder:Landroid/graphics/Path;

    move-object/from16 v0, p0

    iget-object v10, v0, Lcom/facebook/react/views/view/ReactViewBackgroundDrawable;->mPaint:Landroid/graphics/Paint;

    move-object/from16 v0, p1

    invoke-virtual {v0, v9, v10}, Landroid/graphics/Canvas;->drawPath(Landroid/graphics/Path;Landroid/graphics/Paint;)V

    .line 504
    :cond_b
    move-object/from16 v0, p0

    iget-object v9, v0, Lcom/facebook/react/views/view/ReactViewBackgroundDrawable;->mPaint:Landroid/graphics/Paint;

    const/4 v10, 0x1

    invoke-virtual {v9, v10}, Landroid/graphics/Paint;->setAntiAlias(Z)V

    goto/16 :goto_0
.end method

.method private drawRoundedBackgroundWithBorders(Landroid/graphics/Canvas;)V
    .locals 5
    .param p1, "canvas"    # Landroid/graphics/Canvas;

    .prologue
    .line 246
    invoke-direct {p0}, Lcom/facebook/react/views/view/ReactViewBackgroundDrawable;->updatePath()V

    .line 247
    iget v3, p0, Lcom/facebook/react/views/view/ReactViewBackgroundDrawable;->mColor:I

    iget v4, p0, Lcom/facebook/react/views/view/ReactViewBackgroundDrawable;->mAlpha:I

    invoke-static {v3, v4}, Lcom/facebook/react/views/view/ColorUtil;->multiplyColorAlpha(II)I

    move-result v2

    .line 248
    .local v2, "useColor":I
    invoke-static {v2}, Landroid/graphics/Color;->alpha(I)I

    move-result v3

    if-eqz v3, :cond_0

    .line 249
    iget-object v3, p0, Lcom/facebook/react/views/view/ReactViewBackgroundDrawable;->mPaint:Landroid/graphics/Paint;

    invoke-virtual {v3, v2}, Landroid/graphics/Paint;->setColor(I)V

    .line 250
    iget-object v3, p0, Lcom/facebook/react/views/view/ReactViewBackgroundDrawable;->mPaint:Landroid/graphics/Paint;

    sget-object v4, Landroid/graphics/Paint$Style;->FILL:Landroid/graphics/Paint$Style;

    invoke-virtual {v3, v4}, Landroid/graphics/Paint;->setStyle(Landroid/graphics/Paint$Style;)V

    .line 251
    iget-object v3, p0, Lcom/facebook/react/views/view/ReactViewBackgroundDrawable;->mPathForBorderRadius:Landroid/graphics/Path;

    iget-object v4, p0, Lcom/facebook/react/views/view/ReactViewBackgroundDrawable;->mPaint:Landroid/graphics/Paint;

    invoke-virtual {p1, v3, v4}, Landroid/graphics/Canvas;->drawPath(Landroid/graphics/Path;Landroid/graphics/Paint;)V

    .line 254
    :cond_0
    invoke-virtual {p0}, Lcom/facebook/react/views/view/ReactViewBackgroundDrawable;->getFullBorderWidth()F

    move-result v1

    .line 255
    .local v1, "fullBorderWidth":F
    const/4 v3, 0x0

    cmpl-float v3, v1, v3

    if-lez v3, :cond_1

    .line 256
    invoke-direct {p0}, Lcom/facebook/react/views/view/ReactViewBackgroundDrawable;->getFullBorderColor()I

    move-result v0

    .line 257
    .local v0, "borderColor":I
    iget-object v3, p0, Lcom/facebook/react/views/view/ReactViewBackgroundDrawable;->mPaint:Landroid/graphics/Paint;

    iget v4, p0, Lcom/facebook/react/views/view/ReactViewBackgroundDrawable;->mAlpha:I

    invoke-static {v0, v4}, Lcom/facebook/react/views/view/ColorUtil;->multiplyColorAlpha(II)I

    move-result v4

    invoke-virtual {v3, v4}, Landroid/graphics/Paint;->setColor(I)V

    .line 258
    iget-object v3, p0, Lcom/facebook/react/views/view/ReactViewBackgroundDrawable;->mPaint:Landroid/graphics/Paint;

    sget-object v4, Landroid/graphics/Paint$Style;->STROKE:Landroid/graphics/Paint$Style;

    invoke-virtual {v3, v4}, Landroid/graphics/Paint;->setStyle(Landroid/graphics/Paint$Style;)V

    .line 259
    iget-object v3, p0, Lcom/facebook/react/views/view/ReactViewBackgroundDrawable;->mPaint:Landroid/graphics/Paint;

    invoke-virtual {v3, v1}, Landroid/graphics/Paint;->setStrokeWidth(F)V

    .line 260
    iget-object v3, p0, Lcom/facebook/react/views/view/ReactViewBackgroundDrawable;->mPathForBorderRadius:Landroid/graphics/Path;

    iget-object v4, p0, Lcom/facebook/react/views/view/ReactViewBackgroundDrawable;->mPaint:Landroid/graphics/Paint;

    invoke-virtual {p1, v3, v4}, Landroid/graphics/Canvas;->drawPath(Landroid/graphics/Path;Landroid/graphics/Paint;)V

    .line 262
    .end local v0    # "borderColor":I
    :cond_1
    return-void
.end method

.method private static fastBorderCompatibleColorOrZero(IIIIIIII)I
    .locals 6
    .param p0, "borderLeft"    # I
    .param p1, "borderTop"    # I
    .param p2, "borderRight"    # I
    .param p3, "borderBottom"    # I
    .param p4, "colorLeft"    # I
    .param p5, "colorTop"    # I
    .param p6, "colorRight"    # I
    .param p7, "colorBottom"    # I

    .prologue
    const/4 v3, -0x1

    const/4 v2, 0x0

    .line 374
    if-lez p0, :cond_1

    move v5, p4

    :goto_0
    if-lez p1, :cond_2

    move v4, p5

    :goto_1
    and-int/2addr v5, v4

    if-lez p2, :cond_3

    move v4, p6

    :goto_2
    and-int/2addr v4, v5

    if-lez p3, :cond_0

    move v3, p7

    :cond_0
    and-int v0, v4, v3

    .line 378
    .local v0, "andSmear":I
    if-lez p0, :cond_4

    .end local p4    # "colorLeft":I
    :goto_3
    if-lez p1, :cond_5

    .end local p5    # "colorTop":I
    :goto_4
    or-int v3, p4, p5

    if-lez p2, :cond_6

    .end local p6    # "colorRight":I
    :goto_5
    or-int/2addr v3, p6

    if-lez p3, :cond_7

    .end local p7    # "colorBottom":I
    :goto_6
    or-int v1, v3, p7

    .line 382
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

    .line 374
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

    .line 378
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

    .line 382
    goto :goto_7
.end method

.method private getBorderColor(I)I
    .locals 3
    .param p1, "position"    # I

    .prologue
    .line 521
    iget-object v2, p0, Lcom/facebook/react/views/view/ReactViewBackgroundDrawable;->mBorderRGB:Lcom/facebook/react/uimanager/Spacing;

    if-eqz v2, :cond_0

    iget-object v2, p0, Lcom/facebook/react/views/view/ReactViewBackgroundDrawable;->mBorderRGB:Lcom/facebook/react/uimanager/Spacing;

    invoke-virtual {v2, p1}, Lcom/facebook/react/uimanager/Spacing;->get(I)F

    move-result v1

    .line 522
    .local v1, "rgb":F
    :goto_0
    iget-object v2, p0, Lcom/facebook/react/views/view/ReactViewBackgroundDrawable;->mBorderAlpha:Lcom/facebook/react/uimanager/Spacing;

    if-eqz v2, :cond_1

    iget-object v2, p0, Lcom/facebook/react/views/view/ReactViewBackgroundDrawable;->mBorderAlpha:Lcom/facebook/react/uimanager/Spacing;

    invoke-virtual {v2, p1}, Lcom/facebook/react/uimanager/Spacing;->get(I)F

    move-result v0

    .line 524
    .local v0, "alpha":F
    :goto_1
    invoke-static {v0, v1}, Lcom/facebook/react/views/view/ReactViewBackgroundDrawable;->colorFromAlphaAndRGBComponents(FF)I

    move-result v2

    return v2

    .line 521
    .end local v0    # "alpha":F
    .end local v1    # "rgb":F
    :cond_0
    const/4 v1, 0x0

    goto :goto_0

    .line 522
    .restart local v1    # "rgb":F
    :cond_1
    const/high16 v0, 0x437f0000    # 255.0f

    goto :goto_1
.end method

.method private getBorderWidth(I)I
    .locals 1
    .param p1, "position"    # I

    .prologue
    .line 510
    iget-object v0, p0, Lcom/facebook/react/views/view/ReactViewBackgroundDrawable;->mBorderWidth:Lcom/facebook/react/uimanager/Spacing;

    if-eqz v0, :cond_0

    iget-object v0, p0, Lcom/facebook/react/views/view/ReactViewBackgroundDrawable;->mBorderWidth:Lcom/facebook/react/uimanager/Spacing;

    invoke-virtual {v0, p1}, Lcom/facebook/react/uimanager/Spacing;->get(I)F

    move-result v0

    invoke-static {v0}, Ljava/lang/Math;->round(F)I

    move-result v0

    :goto_0
    return v0

    :cond_0
    const/4 v0, 0x0

    goto :goto_0
.end method

.method private getFullBorderColor()I
    .locals 4

    .prologue
    const/16 v3, 0x8

    .line 349
    iget-object v2, p0, Lcom/facebook/react/views/view/ReactViewBackgroundDrawable;->mBorderRGB:Lcom/facebook/react/uimanager/Spacing;

    if-eqz v2, :cond_0

    iget-object v2, p0, Lcom/facebook/react/views/view/ReactViewBackgroundDrawable;->mBorderRGB:Lcom/facebook/react/uimanager/Spacing;

    invoke-virtual {v2, v3}, Lcom/facebook/react/uimanager/Spacing;->getRaw(I)F

    move-result v2

    invoke-static {v2}, Lcom/facebook/yoga/YogaConstants;->isUndefined(F)Z

    move-result v2

    if-nez v2, :cond_0

    iget-object v2, p0, Lcom/facebook/react/views/view/ReactViewBackgroundDrawable;->mBorderRGB:Lcom/facebook/react/uimanager/Spacing;

    .line 350
    invoke-virtual {v2, v3}, Lcom/facebook/react/uimanager/Spacing;->getRaw(I)F

    move-result v1

    .line 351
    .local v1, "rgb":F
    :goto_0
    iget-object v2, p0, Lcom/facebook/react/views/view/ReactViewBackgroundDrawable;->mBorderAlpha:Lcom/facebook/react/uimanager/Spacing;

    if-eqz v2, :cond_1

    iget-object v2, p0, Lcom/facebook/react/views/view/ReactViewBackgroundDrawable;->mBorderAlpha:Lcom/facebook/react/uimanager/Spacing;

    invoke-virtual {v2, v3}, Lcom/facebook/react/uimanager/Spacing;->getRaw(I)F

    move-result v2

    invoke-static {v2}, Lcom/facebook/yoga/YogaConstants;->isUndefined(F)Z

    move-result v2

    if-nez v2, :cond_1

    iget-object v2, p0, Lcom/facebook/react/views/view/ReactViewBackgroundDrawable;->mBorderAlpha:Lcom/facebook/react/uimanager/Spacing;

    .line 352
    invoke-virtual {v2, v3}, Lcom/facebook/react/uimanager/Spacing;->getRaw(I)F

    move-result v0

    .line 353
    .local v0, "alpha":F
    :goto_1
    invoke-static {v0, v1}, Lcom/facebook/react/views/view/ReactViewBackgroundDrawable;->colorFromAlphaAndRGBComponents(FF)I

    move-result v2

    return v2

    .line 350
    .end local v0    # "alpha":F
    .end local v1    # "rgb":F
    :cond_0
    const/4 v1, 0x0

    goto :goto_0

    .line 352
    .restart local v1    # "rgb":F
    :cond_1
    const/high16 v0, 0x437f0000    # 255.0f

    goto :goto_1
.end method

.method private setBorderAlpha(IF)V
    .locals 2
    .param p1, "position"    # I
    .param p2, "alpha"    # F

    .prologue
    .line 190
    iget-object v0, p0, Lcom/facebook/react/views/view/ReactViewBackgroundDrawable;->mBorderAlpha:Lcom/facebook/react/uimanager/Spacing;

    if-nez v0, :cond_0

    .line 191
    new-instance v0, Lcom/facebook/react/uimanager/Spacing;

    const/high16 v1, 0x437f0000    # 255.0f

    invoke-direct {v0, v1}, Lcom/facebook/react/uimanager/Spacing;-><init>(F)V

    iput-object v0, p0, Lcom/facebook/react/views/view/ReactViewBackgroundDrawable;->mBorderAlpha:Lcom/facebook/react/uimanager/Spacing;

    .line 193
    :cond_0
    iget-object v0, p0, Lcom/facebook/react/views/view/ReactViewBackgroundDrawable;->mBorderAlpha:Lcom/facebook/react/uimanager/Spacing;

    invoke-virtual {v0, p1}, Lcom/facebook/react/uimanager/Spacing;->getRaw(I)F

    move-result v0

    invoke-static {v0, p2}, Lcom/facebook/react/uimanager/FloatUtil;->floatsEqual(FF)Z

    move-result v0

    if-nez v0, :cond_1

    .line 194
    iget-object v0, p0, Lcom/facebook/react/views/view/ReactViewBackgroundDrawable;->mBorderAlpha:Lcom/facebook/react/uimanager/Spacing;

    invoke-virtual {v0, p1, p2}, Lcom/facebook/react/uimanager/Spacing;->set(IF)Z

    .line 195
    invoke-virtual {p0}, Lcom/facebook/react/views/view/ReactViewBackgroundDrawable;->invalidateSelf()V

    .line 197
    :cond_1
    return-void
.end method

.method private setBorderRGB(IF)V
    .locals 2
    .param p1, "position"    # I
    .param p2, "rgb"    # F

    .prologue
    .line 179
    iget-object v0, p0, Lcom/facebook/react/views/view/ReactViewBackgroundDrawable;->mBorderRGB:Lcom/facebook/react/uimanager/Spacing;

    if-nez v0, :cond_0

    .line 180
    new-instance v0, Lcom/facebook/react/uimanager/Spacing;

    const/4 v1, 0x0

    invoke-direct {v0, v1}, Lcom/facebook/react/uimanager/Spacing;-><init>(F)V

    iput-object v0, p0, Lcom/facebook/react/views/view/ReactViewBackgroundDrawable;->mBorderRGB:Lcom/facebook/react/uimanager/Spacing;

    .line 182
    :cond_0
    iget-object v0, p0, Lcom/facebook/react/views/view/ReactViewBackgroundDrawable;->mBorderRGB:Lcom/facebook/react/uimanager/Spacing;

    invoke-virtual {v0, p1}, Lcom/facebook/react/uimanager/Spacing;->getRaw(I)F

    move-result v0

    invoke-static {v0, p2}, Lcom/facebook/react/uimanager/FloatUtil;->floatsEqual(FF)Z

    move-result v0

    if-nez v0, :cond_1

    .line 183
    iget-object v0, p0, Lcom/facebook/react/views/view/ReactViewBackgroundDrawable;->mBorderRGB:Lcom/facebook/react/uimanager/Spacing;

    invoke-virtual {v0, p1, p2}, Lcom/facebook/react/uimanager/Spacing;->set(IF)Z

    .line 184
    invoke-virtual {p0}, Lcom/facebook/react/views/view/ReactViewBackgroundDrawable;->invalidateSelf()V

    .line 186
    :cond_1
    return-void
.end method

.method private updatePath()V
    .locals 12

    .prologue
    .line 265
    iget-boolean v7, p0, Lcom/facebook/react/views/view/ReactViewBackgroundDrawable;->mNeedUpdatePathForBorderRadius:Z

    if-nez v7, :cond_0

    .line 325
    :goto_0
    return-void

    .line 268
    :cond_0
    const/4 v7, 0x0

    iput-boolean v7, p0, Lcom/facebook/react/views/view/ReactViewBackgroundDrawable;->mNeedUpdatePathForBorderRadius:Z

    .line 269
    iget-object v7, p0, Lcom/facebook/react/views/view/ReactViewBackgroundDrawable;->mPathForBorderRadius:Landroid/graphics/Path;

    if-nez v7, :cond_1

    .line 270
    new-instance v7, Landroid/graphics/Path;

    invoke-direct {v7}, Landroid/graphics/Path;-><init>()V

    iput-object v7, p0, Lcom/facebook/react/views/view/ReactViewBackgroundDrawable;->mPathForBorderRadius:Landroid/graphics/Path;

    .line 271
    new-instance v7, Landroid/graphics/RectF;

    invoke-direct {v7}, Landroid/graphics/RectF;-><init>()V

    iput-object v7, p0, Lcom/facebook/react/views/view/ReactViewBackgroundDrawable;->mTempRectForBorderRadius:Landroid/graphics/RectF;

    .line 272
    new-instance v7, Landroid/graphics/Path;

    invoke-direct {v7}, Landroid/graphics/Path;-><init>()V

    iput-object v7, p0, Lcom/facebook/react/views/view/ReactViewBackgroundDrawable;->mPathForBorderRadiusOutline:Landroid/graphics/Path;

    .line 273
    new-instance v7, Landroid/graphics/RectF;

    invoke-direct {v7}, Landroid/graphics/RectF;-><init>()V

    iput-object v7, p0, Lcom/facebook/react/views/view/ReactViewBackgroundDrawable;->mTempRectForBorderRadiusOutline:Landroid/graphics/RectF;

    .line 276
    :cond_1
    iget-object v7, p0, Lcom/facebook/react/views/view/ReactViewBackgroundDrawable;->mPathForBorderRadius:Landroid/graphics/Path;

    invoke-virtual {v7}, Landroid/graphics/Path;->reset()V

    .line 277
    iget-object v7, p0, Lcom/facebook/react/views/view/ReactViewBackgroundDrawable;->mPathForBorderRadiusOutline:Landroid/graphics/Path;

    invoke-virtual {v7}, Landroid/graphics/Path;->reset()V

    .line 279
    iget-object v7, p0, Lcom/facebook/react/views/view/ReactViewBackgroundDrawable;->mTempRectForBorderRadius:Landroid/graphics/RectF;

    invoke-virtual {p0}, Lcom/facebook/react/views/view/ReactViewBackgroundDrawable;->getBounds()Landroid/graphics/Rect;

    move-result-object v8

    invoke-virtual {v7, v8}, Landroid/graphics/RectF;->set(Landroid/graphics/Rect;)V

    .line 280
    iget-object v7, p0, Lcom/facebook/react/views/view/ReactViewBackgroundDrawable;->mTempRectForBorderRadiusOutline:Landroid/graphics/RectF;

    invoke-virtual {p0}, Lcom/facebook/react/views/view/ReactViewBackgroundDrawable;->getBounds()Landroid/graphics/Rect;

    move-result-object v8

    invoke-virtual {v7, v8}, Landroid/graphics/RectF;->set(Landroid/graphics/Rect;)V

    .line 281
    invoke-virtual {p0}, Lcom/facebook/react/views/view/ReactViewBackgroundDrawable;->getFullBorderWidth()F

    move-result v4

    .line 282
    .local v4, "fullBorderWidth":F
    const/4 v7, 0x0

    cmpl-float v7, v4, v7

    if-lez v7, :cond_2

    .line 283
    iget-object v7, p0, Lcom/facebook/react/views/view/ReactViewBackgroundDrawable;->mTempRectForBorderRadius:Landroid/graphics/RectF;

    const/high16 v8, 0x3f000000    # 0.5f

    mul-float/2addr v8, v4

    const/high16 v9, 0x3f000000    # 0.5f

    mul-float/2addr v9, v4

    invoke-virtual {v7, v8, v9}, Landroid/graphics/RectF;->inset(FF)V

    .line 286
    :cond_2
    iget v7, p0, Lcom/facebook/react/views/view/ReactViewBackgroundDrawable;->mBorderRadius:F

    invoke-static {v7}, Lcom/facebook/yoga/YogaConstants;->isUndefined(F)Z

    move-result v7

    if-nez v7, :cond_4

    iget v2, p0, Lcom/facebook/react/views/view/ReactViewBackgroundDrawable;->mBorderRadius:F

    .line 287
    .local v2, "defaultBorderRadius":F
    :goto_1
    iget-object v7, p0, Lcom/facebook/react/views/view/ReactViewBackgroundDrawable;->mBorderCornerRadii:[F

    if-eqz v7, :cond_5

    iget-object v7, p0, Lcom/facebook/react/views/view/ReactViewBackgroundDrawable;->mBorderCornerRadii:[F

    const/4 v8, 0x0

    aget v7, v7, v8

    invoke-static {v7}, Lcom/facebook/yoga/YogaConstants;->isUndefined(F)Z

    move-result v7

    if-nez v7, :cond_5

    iget-object v7, p0, Lcom/facebook/react/views/view/ReactViewBackgroundDrawable;->mBorderCornerRadii:[F

    const/4 v8, 0x0

    aget v5, v7, v8

    .line 288
    .local v5, "topLeftRadius":F
    :goto_2
    iget-object v7, p0, Lcom/facebook/react/views/view/ReactViewBackgroundDrawable;->mBorderCornerRadii:[F

    if-eqz v7, :cond_6

    iget-object v7, p0, Lcom/facebook/react/views/view/ReactViewBackgroundDrawable;->mBorderCornerRadii:[F

    const/4 v8, 0x1

    aget v7, v7, v8

    invoke-static {v7}, Lcom/facebook/yoga/YogaConstants;->isUndefined(F)Z

    move-result v7

    if-nez v7, :cond_6

    iget-object v7, p0, Lcom/facebook/react/views/view/ReactViewBackgroundDrawable;->mBorderCornerRadii:[F

    const/4 v8, 0x1

    aget v6, v7, v8

    .line 289
    .local v6, "topRightRadius":F
    :goto_3
    iget-object v7, p0, Lcom/facebook/react/views/view/ReactViewBackgroundDrawable;->mBorderCornerRadii:[F

    if-eqz v7, :cond_7

    iget-object v7, p0, Lcom/facebook/react/views/view/ReactViewBackgroundDrawable;->mBorderCornerRadii:[F

    const/4 v8, 0x2

    aget v7, v7, v8

    invoke-static {v7}, Lcom/facebook/yoga/YogaConstants;->isUndefined(F)Z

    move-result v7

    if-nez v7, :cond_7

    iget-object v7, p0, Lcom/facebook/react/views/view/ReactViewBackgroundDrawable;->mBorderCornerRadii:[F

    const/4 v8, 0x2

    aget v1, v7, v8

    .line 290
    .local v1, "bottomRightRadius":F
    :goto_4
    iget-object v7, p0, Lcom/facebook/react/views/view/ReactViewBackgroundDrawable;->mBorderCornerRadii:[F

    if-eqz v7, :cond_8

    iget-object v7, p0, Lcom/facebook/react/views/view/ReactViewBackgroundDrawable;->mBorderCornerRadii:[F

    const/4 v8, 0x3

    aget v7, v7, v8

    invoke-static {v7}, Lcom/facebook/yoga/YogaConstants;->isUndefined(F)Z

    move-result v7

    if-nez v7, :cond_8

    iget-object v7, p0, Lcom/facebook/react/views/view/ReactViewBackgroundDrawable;->mBorderCornerRadii:[F

    const/4 v8, 0x3

    aget v0, v7, v8

    .line 292
    .local v0, "bottomLeftRadius":F
    :goto_5
    iget-object v7, p0, Lcom/facebook/react/views/view/ReactViewBackgroundDrawable;->mPathForBorderRadius:Landroid/graphics/Path;

    iget-object v8, p0, Lcom/facebook/react/views/view/ReactViewBackgroundDrawable;->mTempRectForBorderRadius:Landroid/graphics/RectF;

    const/16 v9, 0x8

    new-array v9, v9, [F

    const/4 v10, 0x0

    aput v5, v9, v10

    const/4 v10, 0x1

    aput v5, v9, v10

    const/4 v10, 0x2

    aput v6, v9, v10

    const/4 v10, 0x3

    aput v6, v9, v10

    const/4 v10, 0x4

    aput v1, v9, v10

    const/4 v10, 0x5

    aput v1, v9, v10

    const/4 v10, 0x6

    aput v0, v9, v10

    const/4 v10, 0x7

    aput v0, v9, v10

    sget-object v10, Landroid/graphics/Path$Direction;->CW:Landroid/graphics/Path$Direction;

    invoke-virtual {v7, v8, v9, v10}, Landroid/graphics/Path;->addRoundRect(Landroid/graphics/RectF;[FLandroid/graphics/Path$Direction;)V

    .line 306
    const/4 v3, 0x0

    .line 308
    .local v3, "extraRadiusForOutline":F
    iget-object v7, p0, Lcom/facebook/react/views/view/ReactViewBackgroundDrawable;->mBorderWidth:Lcom/facebook/react/uimanager/Spacing;

    if-eqz v7, :cond_3

    .line 309
    iget-object v7, p0, Lcom/facebook/react/views/view/ReactViewBackgroundDrawable;->mBorderWidth:Lcom/facebook/react/uimanager/Spacing;

    const/16 v8, 0x8

    invoke-virtual {v7, v8}, Lcom/facebook/react/uimanager/Spacing;->get(I)F

    move-result v7

    const/high16 v8, 0x40000000    # 2.0f

    div-float v3, v7, v8

    .line 312
    :cond_3
    iget-object v7, p0, Lcom/facebook/react/views/view/ReactViewBackgroundDrawable;->mPathForBorderRadiusOutline:Landroid/graphics/Path;

    iget-object v8, p0, Lcom/facebook/react/views/view/ReactViewBackgroundDrawable;->mTempRectForBorderRadiusOutline:Landroid/graphics/RectF;

    const/16 v9, 0x8

    new-array v9, v9, [F

    const/4 v10, 0x0

    add-float v11, v5, v3

    aput v11, v9, v10

    const/4 v10, 0x1

    add-float v11, v5, v3

    aput v11, v9, v10

    const/4 v10, 0x2

    add-float v11, v6, v3

    aput v11, v9, v10

    const/4 v10, 0x3

    add-float v11, v6, v3

    aput v11, v9, v10

    const/4 v10, 0x4

    add-float v11, v1, v3

    aput v11, v9, v10

    const/4 v10, 0x5

    add-float v11, v1, v3

    aput v11, v9, v10

    const/4 v10, 0x6

    add-float v11, v0, v3

    aput v11, v9, v10

    const/4 v10, 0x7

    add-float v11, v0, v3

    aput v11, v9, v10

    sget-object v10, Landroid/graphics/Path$Direction;->CW:Landroid/graphics/Path$Direction;

    invoke-virtual {v7, v8, v9, v10}, Landroid/graphics/Path;->addRoundRect(Landroid/graphics/RectF;[FLandroid/graphics/Path$Direction;)V

    goto/16 :goto_0

    .line 286
    .end local v0    # "bottomLeftRadius":F
    .end local v1    # "bottomRightRadius":F
    .end local v2    # "defaultBorderRadius":F
    .end local v3    # "extraRadiusForOutline":F
    .end local v5    # "topLeftRadius":F
    .end local v6    # "topRightRadius":F
    :cond_4
    const/4 v2, 0x0

    goto/16 :goto_1

    .restart local v2    # "defaultBorderRadius":F
    :cond_5
    move v5, v2

    .line 287
    goto/16 :goto_2

    .restart local v5    # "topLeftRadius":F
    :cond_6
    move v6, v2

    .line 288
    goto/16 :goto_3

    .restart local v6    # "topRightRadius":F
    :cond_7
    move v1, v2

    .line 289
    goto/16 :goto_4

    .restart local v1    # "bottomRightRadius":F
    :cond_8
    move v0, v2

    .line 290
    goto :goto_5
.end method

.method private updatePathEffect()V
    .locals 2

    .prologue
    .line 331
    iget-object v0, p0, Lcom/facebook/react/views/view/ReactViewBackgroundDrawable;->mBorderStyle:Lcom/facebook/react/views/view/ReactViewBackgroundDrawable$BorderStyle;

    if-eqz v0, :cond_0

    iget-object v0, p0, Lcom/facebook/react/views/view/ReactViewBackgroundDrawable;->mBorderStyle:Lcom/facebook/react/views/view/ReactViewBackgroundDrawable$BorderStyle;

    .line 332
    invoke-virtual {p0}, Lcom/facebook/react/views/view/ReactViewBackgroundDrawable;->getFullBorderWidth()F

    move-result v1

    invoke-virtual {v0, v1}, Lcom/facebook/react/views/view/ReactViewBackgroundDrawable$BorderStyle;->getPathEffect(F)Landroid/graphics/PathEffect;

    move-result-object v0

    :goto_0
    iput-object v0, p0, Lcom/facebook/react/views/view/ReactViewBackgroundDrawable;->mPathEffectForBorderStyle:Landroid/graphics/PathEffect;

    .line 335
    iget-object v0, p0, Lcom/facebook/react/views/view/ReactViewBackgroundDrawable;->mPaint:Landroid/graphics/Paint;

    iget-object v1, p0, Lcom/facebook/react/views/view/ReactViewBackgroundDrawable;->mPathEffectForBorderStyle:Landroid/graphics/PathEffect;

    invoke-virtual {v0, v1}, Landroid/graphics/Paint;->setPathEffect(Landroid/graphics/PathEffect;)Landroid/graphics/PathEffect;

    .line 336
    return-void

    .line 332
    :cond_0
    const/4 v0, 0x0

    goto :goto_0
.end method


# virtual methods
.method public draw(Landroid/graphics/Canvas;)V
    .locals 3
    .param p1, "canvas"    # Landroid/graphics/Canvas;

    .prologue
    .line 103
    invoke-direct {p0}, Lcom/facebook/react/views/view/ReactViewBackgroundDrawable;->updatePathEffect()V

    .line 104
    iget-object v1, p0, Lcom/facebook/react/views/view/ReactViewBackgroundDrawable;->mBorderCornerRadii:[F

    if-nez v1, :cond_0

    iget v1, p0, Lcom/facebook/react/views/view/ReactViewBackgroundDrawable;->mBorderRadius:F

    .line 105
    invoke-static {v1}, Lcom/facebook/yoga/YogaConstants;->isUndefined(F)Z

    move-result v1

    if-nez v1, :cond_1

    iget v1, p0, Lcom/facebook/react/views/view/ReactViewBackgroundDrawable;->mBorderRadius:F

    const/4 v2, 0x0

    cmpl-float v1, v1, v2

    if-lez v1, :cond_1

    :cond_0
    const/4 v0, 0x1

    .line 107
    .local v0, "roundedBorders":Z
    :goto_0
    if-nez v0, :cond_2

    .line 108
    invoke-direct {p0, p1}, Lcom/facebook/react/views/view/ReactViewBackgroundDrawable;->drawRectangularBackgroundWithBorders(Landroid/graphics/Canvas;)V

    .line 112
    :goto_1
    return-void

    .line 105
    .end local v0    # "roundedBorders":Z
    :cond_1
    const/4 v0, 0x0

    goto :goto_0

    .line 110
    .restart local v0    # "roundedBorders":Z
    :cond_2
    invoke-direct {p0, p1}, Lcom/facebook/react/views/view/ReactViewBackgroundDrawable;->drawRoundedBackgroundWithBorders(Landroid/graphics/Canvas;)V

    goto :goto_1
.end method

.method public getAlpha()I
    .locals 1

    .prologue
    .line 130
    iget v0, p0, Lcom/facebook/react/views/view/ReactViewBackgroundDrawable;->mAlpha:I

    return v0
.end method

.method public getColor()I
    .locals 1
    .annotation build Lcom/facebook/react/common/annotations/VisibleForTesting;
    .end annotation

    .prologue
    .line 242
    iget v0, p0, Lcom/facebook/react/views/view/ReactViewBackgroundDrawable;->mColor:I

    return v0
.end method

.method public getFullBorderWidth()F
    .locals 2

    .prologue
    const/16 v1, 0x8

    .line 340
    iget-object v0, p0, Lcom/facebook/react/views/view/ReactViewBackgroundDrawable;->mBorderWidth:Lcom/facebook/react/uimanager/Spacing;

    if-eqz v0, :cond_0

    iget-object v0, p0, Lcom/facebook/react/views/view/ReactViewBackgroundDrawable;->mBorderWidth:Lcom/facebook/react/uimanager/Spacing;

    invoke-virtual {v0, v1}, Lcom/facebook/react/uimanager/Spacing;->getRaw(I)F

    move-result v0

    invoke-static {v0}, Lcom/facebook/yoga/YogaConstants;->isUndefined(F)Z

    move-result v0

    if-nez v0, :cond_0

    iget-object v0, p0, Lcom/facebook/react/views/view/ReactViewBackgroundDrawable;->mBorderWidth:Lcom/facebook/react/uimanager/Spacing;

    .line 341
    invoke-virtual {v0, v1}, Lcom/facebook/react/uimanager/Spacing;->getRaw(I)F

    move-result v0

    :goto_0
    return v0

    :cond_0
    const/4 v0, 0x0

    goto :goto_0
.end method

.method public getOpacity()I
    .locals 2

    .prologue
    .line 140
    iget v0, p0, Lcom/facebook/react/views/view/ReactViewBackgroundDrawable;->mColor:I

    iget v1, p0, Lcom/facebook/react/views/view/ReactViewBackgroundDrawable;->mAlpha:I

    invoke-static {v0, v1}, Lcom/facebook/react/views/view/ColorUtil;->multiplyColorAlpha(II)I

    move-result v0

    invoke-static {v0}, Lcom/facebook/react/views/view/ColorUtil;->getOpacityFromColor(I)I

    move-result v0

    return v0
.end method

.method public getOutline(Landroid/graphics/Outline;)V
    .locals 2
    .param p1, "outline"    # Landroid/graphics/Outline;

    .prologue
    .line 146
    sget v0, Landroid/os/Build$VERSION;->SDK_INT:I

    const/16 v1, 0x15

    if-ge v0, v1, :cond_0

    .line 147
    invoke-super {p0, p1}, Landroid/graphics/drawable/Drawable;->getOutline(Landroid/graphics/Outline;)V

    .line 157
    :goto_0
    return-void

    .line 150
    :cond_0
    iget v0, p0, Lcom/facebook/react/views/view/ReactViewBackgroundDrawable;->mBorderRadius:F

    invoke-static {v0}, Lcom/facebook/yoga/YogaConstants;->isUndefined(F)Z

    move-result v0

    if-nez v0, :cond_1

    iget v0, p0, Lcom/facebook/react/views/view/ReactViewBackgroundDrawable;->mBorderRadius:F

    const/4 v1, 0x0

    cmpl-float v0, v0, v1

    if-gtz v0, :cond_2

    :cond_1
    iget-object v0, p0, Lcom/facebook/react/views/view/ReactViewBackgroundDrawable;->mBorderCornerRadii:[F

    if-eqz v0, :cond_3

    .line 151
    :cond_2
    invoke-direct {p0}, Lcom/facebook/react/views/view/ReactViewBackgroundDrawable;->updatePath()V

    .line 153
    iget-object v0, p0, Lcom/facebook/react/views/view/ReactViewBackgroundDrawable;->mPathForBorderRadiusOutline:Landroid/graphics/Path;

    invoke-virtual {p1, v0}, Landroid/graphics/Outline;->setConvexPath(Landroid/graphics/Path;)V

    goto :goto_0

    .line 155
    :cond_3
    invoke-virtual {p0}, Lcom/facebook/react/views/view/ReactViewBackgroundDrawable;->getBounds()Landroid/graphics/Rect;

    move-result-object v0

    invoke-virtual {p1, v0}, Landroid/graphics/Outline;->setRect(Landroid/graphics/Rect;)V

    goto :goto_0
.end method

.method public getRadius()F
    .locals 1

    .prologue
    .line 232
    iget v0, p0, Lcom/facebook/react/views/view/ReactViewBackgroundDrawable;->mBorderRadius:F

    return v0
.end method

.method protected onBoundsChange(Landroid/graphics/Rect;)V
    .locals 1
    .param p1, "bounds"    # Landroid/graphics/Rect;

    .prologue
    .line 116
    invoke-super {p0, p1}, Landroid/graphics/drawable/Drawable;->onBoundsChange(Landroid/graphics/Rect;)V

    .line 117
    const/4 v0, 0x1

    iput-boolean v0, p0, Lcom/facebook/react/views/view/ReactViewBackgroundDrawable;->mNeedUpdatePathForBorderRadius:Z

    .line 118
    return-void
.end method

.method public setAlpha(I)V
    .locals 1
    .param p1, "alpha"    # I

    .prologue
    .line 122
    iget v0, p0, Lcom/facebook/react/views/view/ReactViewBackgroundDrawable;->mAlpha:I

    if-eq p1, v0, :cond_0

    .line 123
    iput p1, p0, Lcom/facebook/react/views/view/ReactViewBackgroundDrawable;->mAlpha:I

    .line 124
    invoke-virtual {p0}, Lcom/facebook/react/views/view/ReactViewBackgroundDrawable;->invalidateSelf()V

    .line 126
    :cond_0
    return-void
.end method

.method public setBorderColor(IFF)V
    .locals 0
    .param p1, "position"    # I
    .param p2, "rgb"    # F
    .param p3, "alpha"    # F

    .prologue
    .line 173
    invoke-direct {p0, p1, p2}, Lcom/facebook/react/views/view/ReactViewBackgroundDrawable;->setBorderRGB(IF)V

    .line 174
    invoke-direct {p0, p1, p3}, Lcom/facebook/react/views/view/ReactViewBackgroundDrawable;->setBorderAlpha(IF)V

    .line 175
    return-void
.end method

.method public setBorderStyle(Ljava/lang/String;)V
    .locals 2
    .param p1, "style"    # Ljava/lang/String;
        .annotation runtime Ljavax/annotation/Nullable;
        .end annotation
    .end param

    .prologue
    .line 200
    if-nez p1, :cond_1

    const/4 v0, 0x0

    .line 203
    .local v0, "borderStyle":Lcom/facebook/react/views/view/ReactViewBackgroundDrawable$BorderStyle;
    :goto_0
    iget-object v1, p0, Lcom/facebook/react/views/view/ReactViewBackgroundDrawable;->mBorderStyle:Lcom/facebook/react/views/view/ReactViewBackgroundDrawable$BorderStyle;

    if-eq v1, v0, :cond_0

    .line 204
    iput-object v0, p0, Lcom/facebook/react/views/view/ReactViewBackgroundDrawable;->mBorderStyle:Lcom/facebook/react/views/view/ReactViewBackgroundDrawable$BorderStyle;

    .line 205
    const/4 v1, 0x1

    iput-boolean v1, p0, Lcom/facebook/react/views/view/ReactViewBackgroundDrawable;->mNeedUpdatePathForBorderRadius:Z

    .line 206
    invoke-virtual {p0}, Lcom/facebook/react/views/view/ReactViewBackgroundDrawable;->invalidateSelf()V

    .line 208
    :cond_0
    return-void

    .line 200
    .end local v0    # "borderStyle":Lcom/facebook/react/views/view/ReactViewBackgroundDrawable$BorderStyle;
    :cond_1
    sget-object v1, Ljava/util/Locale;->US:Ljava/util/Locale;

    .line 202
    invoke-virtual {p1, v1}, Ljava/lang/String;->toUpperCase(Ljava/util/Locale;)Ljava/lang/String;

    move-result-object v1

    invoke-static {v1}, Lcom/facebook/react/views/view/ReactViewBackgroundDrawable$BorderStyle;->valueOf(Ljava/lang/String;)Lcom/facebook/react/views/view/ReactViewBackgroundDrawable$BorderStyle;

    move-result-object v0

    goto :goto_0
.end method

.method public setBorderWidth(IF)V
    .locals 1
    .param p1, "position"    # I
    .param p2, "width"    # F

    .prologue
    .line 160
    iget-object v0, p0, Lcom/facebook/react/views/view/ReactViewBackgroundDrawable;->mBorderWidth:Lcom/facebook/react/uimanager/Spacing;

    if-nez v0, :cond_0

    .line 161
    new-instance v0, Lcom/facebook/react/uimanager/Spacing;

    invoke-direct {v0}, Lcom/facebook/react/uimanager/Spacing;-><init>()V

    iput-object v0, p0, Lcom/facebook/react/views/view/ReactViewBackgroundDrawable;->mBorderWidth:Lcom/facebook/react/uimanager/Spacing;

    .line 163
    :cond_0
    iget-object v0, p0, Lcom/facebook/react/views/view/ReactViewBackgroundDrawable;->mBorderWidth:Lcom/facebook/react/uimanager/Spacing;

    invoke-virtual {v0, p1}, Lcom/facebook/react/uimanager/Spacing;->getRaw(I)F

    move-result v0

    invoke-static {v0, p2}, Lcom/facebook/react/uimanager/FloatUtil;->floatsEqual(FF)Z

    move-result v0

    if-nez v0, :cond_2

    .line 164
    iget-object v0, p0, Lcom/facebook/react/views/view/ReactViewBackgroundDrawable;->mBorderWidth:Lcom/facebook/react/uimanager/Spacing;

    invoke-virtual {v0, p1, p2}, Lcom/facebook/react/uimanager/Spacing;->set(IF)Z

    .line 165
    const/16 v0, 0x8

    if-ne p1, v0, :cond_1

    .line 166
    const/4 v0, 0x1

    iput-boolean v0, p0, Lcom/facebook/react/views/view/ReactViewBackgroundDrawable;->mNeedUpdatePathForBorderRadius:Z

    .line 168
    :cond_1
    invoke-virtual {p0}, Lcom/facebook/react/views/view/ReactViewBackgroundDrawable;->invalidateSelf()V

    .line 170
    :cond_2
    return-void
.end method

.method public setColor(I)V
    .locals 0
    .param p1, "color"    # I

    .prologue
    .line 236
    iput p1, p0, Lcom/facebook/react/views/view/ReactViewBackgroundDrawable;->mColor:I

    .line 237
    invoke-virtual {p0}, Lcom/facebook/react/views/view/ReactViewBackgroundDrawable;->invalidateSelf()V

    .line 238
    return-void
.end method

.method public setColorFilter(Landroid/graphics/ColorFilter;)V
    .locals 0
    .param p1, "cf"    # Landroid/graphics/ColorFilter;

    .prologue
    .line 136
    return-void
.end method

.method public setRadius(F)V
    .locals 1
    .param p1, "radius"    # F

    .prologue
    .line 211
    iget v0, p0, Lcom/facebook/react/views/view/ReactViewBackgroundDrawable;->mBorderRadius:F

    invoke-static {v0, p1}, Lcom/facebook/react/uimanager/FloatUtil;->floatsEqual(FF)Z

    move-result v0

    if-nez v0, :cond_0

    .line 212
    iput p1, p0, Lcom/facebook/react/views/view/ReactViewBackgroundDrawable;->mBorderRadius:F

    .line 213
    const/4 v0, 0x1

    iput-boolean v0, p0, Lcom/facebook/react/views/view/ReactViewBackgroundDrawable;->mNeedUpdatePathForBorderRadius:Z

    .line 214
    invoke-virtual {p0}, Lcom/facebook/react/views/view/ReactViewBackgroundDrawable;->invalidateSelf()V

    .line 216
    :cond_0
    return-void
.end method

.method public setRadius(FI)V
    .locals 2
    .param p1, "radius"    # F
    .param p2, "position"    # I

    .prologue
    .line 219
    iget-object v0, p0, Lcom/facebook/react/views/view/ReactViewBackgroundDrawable;->mBorderCornerRadii:[F

    if-nez v0, :cond_0

    .line 220
    const/4 v0, 0x4

    new-array v0, v0, [F

    iput-object v0, p0, Lcom/facebook/react/views/view/ReactViewBackgroundDrawable;->mBorderCornerRadii:[F

    .line 221
    iget-object v0, p0, Lcom/facebook/react/views/view/ReactViewBackgroundDrawable;->mBorderCornerRadii:[F

    const/high16 v1, 0x7fc00000    # Float.NaN

    invoke-static {v0, v1}, Ljava/util/Arrays;->fill([FF)V

    .line 224
    :cond_0
    iget-object v0, p0, Lcom/facebook/react/views/view/ReactViewBackgroundDrawable;->mBorderCornerRadii:[F

    aget v0, v0, p2

    invoke-static {v0, p1}, Lcom/facebook/react/uimanager/FloatUtil;->floatsEqual(FF)Z

    move-result v0

    if-nez v0, :cond_1

    .line 225
    iget-object v0, p0, Lcom/facebook/react/views/view/ReactViewBackgroundDrawable;->mBorderCornerRadii:[F

    aput p1, v0, p2

    .line 226
    const/4 v0, 0x1

    iput-boolean v0, p0, Lcom/facebook/react/views/view/ReactViewBackgroundDrawable;->mNeedUpdatePathForBorderRadius:Z

    .line 227
    invoke-virtual {p0}, Lcom/facebook/react/views/view/ReactViewBackgroundDrawable;->invalidateSelf()V

    .line 229
    :cond_1
    return-void
.end method

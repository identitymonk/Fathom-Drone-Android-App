.class final Lcom/facebook/react/flat/RCTText;
.super Lcom/facebook/react/flat/RCTVirtualText;
.source "RCTText.java"

# interfaces
.implements Lcom/facebook/yoga/YogaMeasureFunction;


# static fields
.field private static final ALIGNMENT_LEFT:I = 0x3

.field private static final ALIGNMENT_RIGHT:I = 0x4

.field private static final sTextLayoutBuilder:Lcom/facebook/fbui/textlayoutbuilder/TextLayoutBuilder;


# instance fields
.field private mAlignment:I

.field private mDrawCommand:Lcom/facebook/react/flat/DrawTextLayout;
    .annotation runtime Ljavax/annotation/Nullable;
    .end annotation
.end field

.field private mIncludeFontPadding:Z

.field private mNumberOfLines:I

.field private mSpacingAdd:F

.field private mSpacingMult:F

.field private mText:Ljava/lang/CharSequence;
    .annotation runtime Ljavax/annotation/Nullable;
    .end annotation
.end field


# direct methods
.method static constructor <clinit>()V
    .locals 2

    .prologue
    .line 48
    new-instance v0, Lcom/facebook/fbui/textlayoutbuilder/TextLayoutBuilder;

    invoke-direct {v0}, Lcom/facebook/fbui/textlayoutbuilder/TextLayoutBuilder;-><init>()V

    const/4 v1, 0x0

    .line 50
    invoke-virtual {v0, v1}, Lcom/facebook/fbui/textlayoutbuilder/TextLayoutBuilder;->setShouldCacheLayout(Z)Lcom/facebook/fbui/textlayoutbuilder/TextLayoutBuilder;

    move-result-object v0

    const/4 v1, 0x1

    .line 51
    invoke-virtual {v0, v1}, Lcom/facebook/fbui/textlayoutbuilder/TextLayoutBuilder;->setShouldWarmText(Z)Lcom/facebook/fbui/textlayoutbuilder/TextLayoutBuilder;

    move-result-object v0

    new-instance v1, Lcom/facebook/fbui/textlayoutbuilder/glyphwarmer/GlyphWarmerImpl;

    invoke-direct {v1}, Lcom/facebook/fbui/textlayoutbuilder/glyphwarmer/GlyphWarmerImpl;-><init>()V

    .line 52
    invoke-virtual {v0, v1}, Lcom/facebook/fbui/textlayoutbuilder/TextLayoutBuilder;->setGlyphWarmer(Lcom/facebook/fbui/textlayoutbuilder/GlyphWarmer;)Lcom/facebook/fbui/textlayoutbuilder/TextLayoutBuilder;

    move-result-object v0

    sput-object v0, Lcom/facebook/react/flat/RCTText;->sTextLayoutBuilder:Lcom/facebook/fbui/textlayoutbuilder/TextLayoutBuilder;

    .line 48
    return-void
.end method

.method public constructor <init>()V
    .locals 2

    .prologue
    .line 62
    invoke-direct {p0}, Lcom/facebook/react/flat/RCTVirtualText;-><init>()V

    .line 56
    const/high16 v0, 0x3f800000    # 1.0f

    iput v0, p0, Lcom/facebook/react/flat/RCTText;->mSpacingMult:F

    .line 57
    const/4 v0, 0x0

    iput v0, p0, Lcom/facebook/react/flat/RCTText;->mSpacingAdd:F

    .line 58
    const v0, 0x7fffffff

    iput v0, p0, Lcom/facebook/react/flat/RCTText;->mNumberOfLines:I

    .line 59
    const/4 v0, 0x0

    iput v0, p0, Lcom/facebook/react/flat/RCTText;->mAlignment:I

    .line 60
    const/4 v0, 0x1

    iput-boolean v0, p0, Lcom/facebook/react/flat/RCTText;->mIncludeFontPadding:Z

    .line 63
    invoke-virtual {p0, p0}, Lcom/facebook/react/flat/RCTText;->setMeasureFunction(Lcom/facebook/yoga/YogaMeasureFunction;)V

    .line 64
    invoke-virtual {p0}, Lcom/facebook/react/flat/RCTText;->getSpan()Lcom/facebook/react/flat/FontStylingSpan;

    move-result-object v0

    invoke-virtual {p0}, Lcom/facebook/react/flat/RCTText;->getDefaultFontSize()I

    move-result v1

    invoke-virtual {v0, v1}, Lcom/facebook/react/flat/FontStylingSpan;->setFontSize(I)V

    .line 65
    return-void
.end method

.method private static createTextLayout(ILcom/facebook/yoga/YogaMeasureMode;Landroid/text/TextUtils$TruncateAt;ZIZLjava/lang/CharSequence;IFFILandroid/text/Layout$Alignment;)Landroid/text/Layout;
    .locals 6
    .param p0, "width"    # I
    .param p1, "widthMode"    # Lcom/facebook/yoga/YogaMeasureMode;
    .param p2, "ellipsize"    # Landroid/text/TextUtils$TruncateAt;
    .param p3, "shouldIncludeFontPadding"    # Z
    .param p4, "maxLines"    # I
    .param p5, "isSingleLine"    # Z
    .param p6, "text"    # Ljava/lang/CharSequence;
    .param p7, "textSize"    # I
    .param p8, "extraSpacing"    # F
    .param p9, "spacingMultiplier"    # F
    .param p10, "textStyle"    # I
    .param p11, "textAlignment"    # Landroid/text/Layout$Alignment;

    .prologue
    .line 326
    sget-object v3, Lcom/facebook/react/flat/RCTText$1;->$SwitchMap$com$facebook$yoga$YogaMeasureMode:[I

    invoke-virtual {p1}, Lcom/facebook/yoga/YogaMeasureMode;->ordinal()I

    move-result v4

    aget v3, v3, v4

    packed-switch v3, :pswitch_data_0

    .line 337
    new-instance v3, Ljava/lang/IllegalStateException;

    new-instance v4, Ljava/lang/StringBuilder;

    invoke-direct {v4}, Ljava/lang/StringBuilder;-><init>()V

    const-string v5, "Unexpected size mode: "

    invoke-virtual {v4, v5}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v4

    invoke-virtual {v4, p1}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    move-result-object v4

    invoke-virtual {v4}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v4

    invoke-direct {v3, v4}, Ljava/lang/IllegalStateException;-><init>(Ljava/lang/String;)V

    throw v3

    .line 328
    :pswitch_0
    const/4 v2, 0x0

    .line 340
    .local v2, "textMeasureMode":I
    :goto_0
    sget-object v3, Lcom/facebook/react/flat/RCTText;->sTextLayoutBuilder:Lcom/facebook/fbui/textlayoutbuilder/TextLayoutBuilder;

    .line 341
    invoke-virtual {v3, p2}, Lcom/facebook/fbui/textlayoutbuilder/TextLayoutBuilder;->setEllipsize(Landroid/text/TextUtils$TruncateAt;)Lcom/facebook/fbui/textlayoutbuilder/TextLayoutBuilder;

    move-result-object v3

    .line 342
    invoke-virtual {v3, p4}, Lcom/facebook/fbui/textlayoutbuilder/TextLayoutBuilder;->setMaxLines(I)Lcom/facebook/fbui/textlayoutbuilder/TextLayoutBuilder;

    move-result-object v3

    .line 343
    invoke-virtual {v3, p5}, Lcom/facebook/fbui/textlayoutbuilder/TextLayoutBuilder;->setSingleLine(Z)Lcom/facebook/fbui/textlayoutbuilder/TextLayoutBuilder;

    move-result-object v3

    .line 344
    invoke-virtual {v3, p6}, Lcom/facebook/fbui/textlayoutbuilder/TextLayoutBuilder;->setText(Ljava/lang/CharSequence;)Lcom/facebook/fbui/textlayoutbuilder/TextLayoutBuilder;

    move-result-object v3

    .line 345
    invoke-virtual {v3, p7}, Lcom/facebook/fbui/textlayoutbuilder/TextLayoutBuilder;->setTextSize(I)Lcom/facebook/fbui/textlayoutbuilder/TextLayoutBuilder;

    move-result-object v3

    .line 346
    invoke-virtual {v3, p0, v2}, Lcom/facebook/fbui/textlayoutbuilder/TextLayoutBuilder;->setWidth(II)Lcom/facebook/fbui/textlayoutbuilder/TextLayoutBuilder;

    .line 348
    sget-object v3, Lcom/facebook/react/flat/RCTText;->sTextLayoutBuilder:Lcom/facebook/fbui/textlayoutbuilder/TextLayoutBuilder;

    move/from16 v0, p10

    invoke-virtual {v3, v0}, Lcom/facebook/fbui/textlayoutbuilder/TextLayoutBuilder;->setTextStyle(I)Lcom/facebook/fbui/textlayoutbuilder/TextLayoutBuilder;

    .line 350
    sget-object v3, Lcom/facebook/react/flat/RCTText;->sTextLayoutBuilder:Lcom/facebook/fbui/textlayoutbuilder/TextLayoutBuilder;

    sget-object v4, Landroid/support/v4/text/TextDirectionHeuristicsCompat;->FIRSTSTRONG_LTR:Landroid/support/v4/text/TextDirectionHeuristicCompat;

    invoke-virtual {v3, v4}, Lcom/facebook/fbui/textlayoutbuilder/TextLayoutBuilder;->setTextDirection(Landroid/support/v4/text/TextDirectionHeuristicCompat;)Lcom/facebook/fbui/textlayoutbuilder/TextLayoutBuilder;

    .line 351
    sget-object v3, Lcom/facebook/react/flat/RCTText;->sTextLayoutBuilder:Lcom/facebook/fbui/textlayoutbuilder/TextLayoutBuilder;

    invoke-virtual {v3, p3}, Lcom/facebook/fbui/textlayoutbuilder/TextLayoutBuilder;->setIncludeFontPadding(Z)Lcom/facebook/fbui/textlayoutbuilder/TextLayoutBuilder;

    .line 352
    sget-object v3, Lcom/facebook/react/flat/RCTText;->sTextLayoutBuilder:Lcom/facebook/fbui/textlayoutbuilder/TextLayoutBuilder;

    invoke-virtual {v3, p8}, Lcom/facebook/fbui/textlayoutbuilder/TextLayoutBuilder;->setTextSpacingExtra(F)Lcom/facebook/fbui/textlayoutbuilder/TextLayoutBuilder;

    .line 353
    sget-object v3, Lcom/facebook/react/flat/RCTText;->sTextLayoutBuilder:Lcom/facebook/fbui/textlayoutbuilder/TextLayoutBuilder;

    invoke-virtual {v3, p9}, Lcom/facebook/fbui/textlayoutbuilder/TextLayoutBuilder;->setTextSpacingMultiplier(F)Lcom/facebook/fbui/textlayoutbuilder/TextLayoutBuilder;

    .line 354
    sget-object v3, Lcom/facebook/react/flat/RCTText;->sTextLayoutBuilder:Lcom/facebook/fbui/textlayoutbuilder/TextLayoutBuilder;

    move-object/from16 v0, p11

    invoke-virtual {v3, v0}, Lcom/facebook/fbui/textlayoutbuilder/TextLayoutBuilder;->setAlignment(Landroid/text/Layout$Alignment;)Lcom/facebook/fbui/textlayoutbuilder/TextLayoutBuilder;

    .line 356
    sget-object v3, Lcom/facebook/react/flat/RCTText;->sTextLayoutBuilder:Lcom/facebook/fbui/textlayoutbuilder/TextLayoutBuilder;

    invoke-virtual {v3}, Lcom/facebook/fbui/textlayoutbuilder/TextLayoutBuilder;->build()Landroid/text/Layout;

    move-result-object v1

    .line 358
    .local v1, "newLayout":Landroid/text/Layout;
    sget-object v3, Lcom/facebook/react/flat/RCTText;->sTextLayoutBuilder:Lcom/facebook/fbui/textlayoutbuilder/TextLayoutBuilder;

    const/4 v4, 0x0

    invoke-virtual {v3, v4}, Lcom/facebook/fbui/textlayoutbuilder/TextLayoutBuilder;->setText(Ljava/lang/CharSequence;)Lcom/facebook/fbui/textlayoutbuilder/TextLayoutBuilder;

    .line 360
    return-object v1

    .line 331
    .end local v1    # "newLayout":Landroid/text/Layout;
    .end local v2    # "textMeasureMode":I
    :pswitch_1
    const/4 v2, 0x1

    .line 332
    .restart local v2    # "textMeasureMode":I
    goto :goto_0

    .line 334
    .end local v2    # "textMeasureMode":I
    :pswitch_2
    const/4 v2, 0x2

    .line 335
    .restart local v2    # "textMeasureMode":I
    goto :goto_0

    .line 326
    nop

    :pswitch_data_0
    .packed-switch 0x1
        :pswitch_0
        :pswitch_1
        :pswitch_2
    .end packed-switch
.end method


# virtual methods
.method protected collectState(Lcom/facebook/react/flat/StateBuilder;FFFFFFFF)V
    .locals 18
    .param p1, "stateBuilder"    # Lcom/facebook/react/flat/StateBuilder;
    .param p2, "left"    # F
    .param p3, "top"    # F
    .param p4, "right"    # F
    .param p5, "bottom"    # F
    .param p6, "clipLeft"    # F
    .param p7, "clipTop"    # F
    .param p8, "clipRight"    # F
    .param p9, "clipBottom"    # F

    .prologue
    .line 129
    invoke-super/range {p0 .. p9}, Lcom/facebook/react/flat/RCTVirtualText;->collectState(Lcom/facebook/react/flat/StateBuilder;FFFFFFFF)V

    .line 140
    move-object/from16 v0, p0

    iget-object v2, v0, Lcom/facebook/react/flat/RCTText;->mText:Ljava/lang/CharSequence;

    if-nez v2, :cond_1

    .line 143
    sub-float v2, p5, p3

    const/4 v3, 0x0

    cmpl-float v2, v2, v3

    if-lez v2, :cond_0

    sub-float v2, p4, p2

    const/4 v3, 0x0

    cmpl-float v2, v2, v3

    if-lez v2, :cond_0

    .line 144
    invoke-virtual/range {p0 .. p0}, Lcom/facebook/react/flat/RCTText;->getText()Landroid/text/SpannableStringBuilder;

    move-result-object v15

    .line 145
    .local v15, "text":Ljava/lang/CharSequence;
    invoke-static {v15}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result v2

    if-nez v2, :cond_0

    .line 146
    move-object/from16 v0, p0

    iput-object v15, v0, Lcom/facebook/react/flat/RCTText;->mText:Ljava/lang/CharSequence;

    .line 150
    .end local v15    # "text":Ljava/lang/CharSequence;
    :cond_0
    move-object/from16 v0, p0

    iget-object v2, v0, Lcom/facebook/react/flat/RCTText;->mText:Ljava/lang/CharSequence;

    if-nez v2, :cond_1

    .line 200
    :goto_0
    return-void

    .line 156
    :cond_1
    const/16 v16, 0x0

    .line 157
    .local v16, "updateNodeRegion":Z
    move-object/from16 v0, p0

    iget-object v2, v0, Lcom/facebook/react/flat/RCTText;->mDrawCommand:Lcom/facebook/react/flat/DrawTextLayout;

    if-nez v2, :cond_2

    .line 158
    new-instance v17, Lcom/facebook/react/flat/DrawTextLayout;

    sub-float v2, p4, p2

    float-to-double v2, v2

    .line 159
    invoke-static {v2, v3}, Ljava/lang/Math;->ceil(D)D

    move-result-wide v2

    double-to-int v2, v2

    sget-object v3, Lcom/facebook/yoga/YogaMeasureMode;->EXACTLY:Lcom/facebook/yoga/YogaMeasureMode;

    sget-object v4, Landroid/text/TextUtils$TruncateAt;->END:Landroid/text/TextUtils$TruncateAt;

    move-object/from16 v0, p0

    iget-boolean v5, v0, Lcom/facebook/react/flat/RCTText;->mIncludeFontPadding:Z

    move-object/from16 v0, p0

    iget v6, v0, Lcom/facebook/react/flat/RCTText;->mNumberOfLines:I

    move-object/from16 v0, p0

    iget v7, v0, Lcom/facebook/react/flat/RCTText;->mNumberOfLines:I

    const/4 v8, 0x1

    if-ne v7, v8, :cond_4

    const/4 v7, 0x1

    :goto_1
    move-object/from16 v0, p0

    iget-object v8, v0, Lcom/facebook/react/flat/RCTText;->mText:Ljava/lang/CharSequence;

    .line 166
    invoke-virtual/range {p0 .. p0}, Lcom/facebook/react/flat/RCTText;->getFontSize()I

    move-result v9

    move-object/from16 v0, p0

    iget v10, v0, Lcom/facebook/react/flat/RCTText;->mSpacingAdd:F

    move-object/from16 v0, p0

    iget v11, v0, Lcom/facebook/react/flat/RCTText;->mSpacingMult:F

    .line 169
    invoke-virtual/range {p0 .. p0}, Lcom/facebook/react/flat/RCTText;->getFontStyle()I

    move-result v12

    .line 170
    invoke-virtual/range {p0 .. p0}, Lcom/facebook/react/flat/RCTText;->getAlignment()Landroid/text/Layout$Alignment;

    move-result-object v13

    .line 158
    invoke-static/range {v2 .. v13}, Lcom/facebook/react/flat/RCTText;->createTextLayout(ILcom/facebook/yoga/YogaMeasureMode;Landroid/text/TextUtils$TruncateAt;ZIZLjava/lang/CharSequence;IFFILandroid/text/Layout$Alignment;)Landroid/text/Layout;

    move-result-object v2

    move-object/from16 v0, v17

    invoke-direct {v0, v2}, Lcom/facebook/react/flat/DrawTextLayout;-><init>(Landroid/text/Layout;)V

    move-object/from16 v0, v17

    move-object/from16 v1, p0

    iput-object v0, v1, Lcom/facebook/react/flat/RCTText;->mDrawCommand:Lcom/facebook/react/flat/DrawTextLayout;

    .line 171
    const/16 v16, 0x1

    .line 174
    :cond_2
    const/4 v2, 0x0

    move-object/from16 v0, p0

    invoke-virtual {v0, v2}, Lcom/facebook/react/flat/RCTText;->getPadding(I)F

    move-result v2

    add-float p2, p2, v2

    .line 175
    const/4 v2, 0x1

    move-object/from16 v0, p0

    invoke-virtual {v0, v2}, Lcom/facebook/react/flat/RCTText;->getPadding(I)F

    move-result v2

    add-float p3, p3, v2

    .line 178
    move-object/from16 v0, p0

    iget-object v2, v0, Lcom/facebook/react/flat/RCTText;->mDrawCommand:Lcom/facebook/react/flat/DrawTextLayout;

    invoke-virtual {v2}, Lcom/facebook/react/flat/DrawTextLayout;->getLayoutWidth()F

    move-result v2

    add-float p4, p2, v2

    .line 179
    move-object/from16 v0, p0

    iget-object v2, v0, Lcom/facebook/react/flat/RCTText;->mDrawCommand:Lcom/facebook/react/flat/DrawTextLayout;

    invoke-virtual {v2}, Lcom/facebook/react/flat/DrawTextLayout;->getLayoutHeight()F

    move-result v2

    add-float p5, p3, v2

    .line 181
    move-object/from16 v0, p0

    iget-object v2, v0, Lcom/facebook/react/flat/RCTText;->mDrawCommand:Lcom/facebook/react/flat/DrawTextLayout;

    move/from16 v3, p2

    move/from16 v4, p3

    move/from16 v5, p4

    move/from16 v6, p5

    move/from16 v7, p6

    move/from16 v8, p7

    move/from16 v9, p8

    move/from16 v10, p9

    invoke-virtual/range {v2 .. v10}, Lcom/facebook/react/flat/DrawTextLayout;->updateBoundsAndFreeze(FFFFFFFF)Lcom/facebook/react/flat/AbstractDrawCommand;

    move-result-object v2

    check-cast v2, Lcom/facebook/react/flat/DrawTextLayout;

    move-object/from16 v0, p0

    iput-object v2, v0, Lcom/facebook/react/flat/RCTText;->mDrawCommand:Lcom/facebook/react/flat/DrawTextLayout;

    .line 190
    move-object/from16 v0, p0

    iget-object v2, v0, Lcom/facebook/react/flat/RCTText;->mDrawCommand:Lcom/facebook/react/flat/DrawTextLayout;

    move-object/from16 v0, p1

    invoke-virtual {v0, v2}, Lcom/facebook/react/flat/StateBuilder;->addDrawCommand(Lcom/facebook/react/flat/AbstractDrawCommand;)V

    .line 192
    if-eqz v16, :cond_3

    .line 193
    invoke-virtual/range {p0 .. p0}, Lcom/facebook/react/flat/RCTText;->getNodeRegion()Lcom/facebook/react/flat/NodeRegion;

    move-result-object v14

    .line 194
    .local v14, "nodeRegion":Lcom/facebook/react/flat/NodeRegion;
    instance-of v2, v14, Lcom/facebook/react/flat/TextNodeRegion;

    if-eqz v2, :cond_3

    .line 195
    check-cast v14, Lcom/facebook/react/flat/TextNodeRegion;

    .end local v14    # "nodeRegion":Lcom/facebook/react/flat/NodeRegion;
    move-object/from16 v0, p0

    iget-object v2, v0, Lcom/facebook/react/flat/RCTText;->mDrawCommand:Lcom/facebook/react/flat/DrawTextLayout;

    invoke-virtual {v2}, Lcom/facebook/react/flat/DrawTextLayout;->getLayout()Landroid/text/Layout;

    move-result-object v2

    invoke-virtual {v14, v2}, Lcom/facebook/react/flat/TextNodeRegion;->setLayout(Landroid/text/Layout;)V

    .line 199
    :cond_3
    invoke-virtual/range {p0 .. p1}, Lcom/facebook/react/flat/RCTText;->performCollectAttachDetachListeners(Lcom/facebook/react/flat/StateBuilder;)V

    goto/16 :goto_0

    .line 159
    :cond_4
    const/4 v7, 0x0

    goto/16 :goto_1
.end method

.method doesDraw()Z
    .locals 1

    .prologue
    .line 206
    const/4 v0, 0x1

    return v0
.end method

.method public getAlignment()Landroid/text/Layout$Alignment;
    .locals 5

    .prologue
    const/4 v0, 0x4

    const/4 v2, 0x3

    .line 293
    invoke-virtual {p0}, Lcom/facebook/react/flat/RCTText;->getLayoutDirection()Lcom/facebook/yoga/YogaDirection;

    move-result-object v3

    sget-object v4, Lcom/facebook/yoga/YogaDirection;->RTL:Lcom/facebook/yoga/YogaDirection;

    if-ne v3, v4, :cond_0

    const/4 v1, 0x1

    .line 294
    .local v1, "isRtl":Z
    :goto_0
    iget v3, p0, Lcom/facebook/react/flat/RCTText;->mAlignment:I

    sparse-switch v3, :sswitch_data_0

    .line 306
    sget-object v2, Landroid/text/Layout$Alignment;->ALIGN_NORMAL:Landroid/text/Layout$Alignment;

    :goto_1
    return-object v2

    .line 293
    .end local v1    # "isRtl":Z
    :cond_0
    const/4 v1, 0x0

    goto :goto_0

    .line 297
    .restart local v1    # "isRtl":Z
    :sswitch_0
    if-eqz v1, :cond_1

    .line 298
    .local v0, "index":I
    :goto_2
    invoke-static {}, Landroid/text/Layout$Alignment;->values()[Landroid/text/Layout$Alignment;

    move-result-object v2

    aget-object v2, v2, v0

    goto :goto_1

    .end local v0    # "index":I
    :cond_1
    move v0, v2

    .line 297
    goto :goto_2

    .line 300
    :sswitch_1
    if-eqz v1, :cond_2

    move v0, v2

    .line 301
    .restart local v0    # "index":I
    :cond_2
    invoke-static {}, Landroid/text/Layout$Alignment;->values()[Landroid/text/Layout$Alignment;

    move-result-object v2

    aget-object v2, v2, v0

    goto :goto_1

    .line 303
    .end local v0    # "index":I
    :sswitch_2
    sget-object v2, Landroid/text/Layout$Alignment;->ALIGN_CENTER:Landroid/text/Layout$Alignment;

    goto :goto_1

    .line 294
    nop

    :sswitch_data_0
    .sparse-switch
        0x3 -> :sswitch_0
        0x5 -> :sswitch_1
        0x11 -> :sswitch_2
    .end sparse-switch
.end method

.method protected getDefaultFontSize()I
    .locals 1

    .prologue
    .line 264
    const/high16 v0, 0x41600000    # 14.0f

    invoke-static {v0}, Lcom/facebook/react/flat/RCTText;->fontSizeFromSp(F)I

    move-result v0

    return v0
.end method

.method public isVirtual()Z
    .locals 1

    .prologue
    .line 69
    const/4 v0, 0x0

    return v0
.end method

.method public isVirtualAnchor()Z
    .locals 1

    .prologue
    .line 74
    const/4 v0, 0x1

    return v0
.end method

.method public measure(Lcom/facebook/yoga/YogaNode;FLcom/facebook/yoga/YogaMeasureMode;FLcom/facebook/yoga/YogaMeasureMode;)J
    .locals 13
    .param p1, "node"    # Lcom/facebook/yoga/YogaNode;
    .param p2, "width"    # F
    .param p3, "widthMode"    # Lcom/facebook/yoga/YogaMeasureMode;
    .param p4, "height"    # F
    .param p5, "heightMode"    # Lcom/facebook/yoga/YogaMeasureMode;

    .prologue
    .line 85
    invoke-virtual {p0}, Lcom/facebook/react/flat/RCTText;->getText()Landroid/text/SpannableStringBuilder;

    move-result-object v6

    .line 86
    .local v6, "text":Ljava/lang/CharSequence;
    invoke-static {v6}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result v0

    if-eqz v0, :cond_0

    .line 88
    const/4 v0, 0x0

    iput-object v0, p0, Lcom/facebook/react/flat/RCTText;->mText:Ljava/lang/CharSequence;

    .line 89
    const/4 v0, 0x0

    const/4 v1, 0x0

    invoke-static {v0, v1}, Lcom/facebook/yoga/YogaMeasureOutput;->make(II)J

    move-result-wide v0

    .line 114
    :goto_0
    return-wide v0

    .line 91
    :cond_0
    iput-object v6, p0, Lcom/facebook/react/flat/RCTText;->mText:Ljava/lang/CharSequence;

    .line 94
    float-to-double v0, p2

    .line 95
    invoke-static {v0, v1}, Ljava/lang/Math;->ceil(D)D

    move-result-wide v0

    double-to-int v0, v0

    sget-object v2, Landroid/text/TextUtils$TruncateAt;->END:Landroid/text/TextUtils$TruncateAt;

    iget-boolean v3, p0, Lcom/facebook/react/flat/RCTText;->mIncludeFontPadding:Z

    iget v4, p0, Lcom/facebook/react/flat/RCTText;->mNumberOfLines:I

    iget v1, p0, Lcom/facebook/react/flat/RCTText;->mNumberOfLines:I

    const/4 v5, 0x1

    if-ne v1, v5, :cond_1

    const/4 v5, 0x1

    .line 102
    :goto_1
    invoke-virtual {p0}, Lcom/facebook/react/flat/RCTText;->getFontSize()I

    move-result v7

    iget v8, p0, Lcom/facebook/react/flat/RCTText;->mSpacingAdd:F

    iget v9, p0, Lcom/facebook/react/flat/RCTText;->mSpacingMult:F

    .line 105
    invoke-virtual {p0}, Lcom/facebook/react/flat/RCTText;->getFontStyle()I

    move-result v10

    .line 106
    invoke-virtual {p0}, Lcom/facebook/react/flat/RCTText;->getAlignment()Landroid/text/Layout$Alignment;

    move-result-object v11

    move-object/from16 v1, p3

    .line 94
    invoke-static/range {v0 .. v11}, Lcom/facebook/react/flat/RCTText;->createTextLayout(ILcom/facebook/yoga/YogaMeasureMode;Landroid/text/TextUtils$TruncateAt;ZIZLjava/lang/CharSequence;IFFILandroid/text/Layout$Alignment;)Landroid/text/Layout;

    move-result-object v12

    .line 108
    .local v12, "layout":Landroid/text/Layout;
    iget-object v0, p0, Lcom/facebook/react/flat/RCTText;->mDrawCommand:Lcom/facebook/react/flat/DrawTextLayout;

    if-eqz v0, :cond_2

    iget-object v0, p0, Lcom/facebook/react/flat/RCTText;->mDrawCommand:Lcom/facebook/react/flat/DrawTextLayout;

    invoke-virtual {v0}, Lcom/facebook/react/flat/DrawTextLayout;->isFrozen()Z

    move-result v0

    if-nez v0, :cond_2

    .line 109
    iget-object v0, p0, Lcom/facebook/react/flat/RCTText;->mDrawCommand:Lcom/facebook/react/flat/DrawTextLayout;

    invoke-virtual {v0, v12}, Lcom/facebook/react/flat/DrawTextLayout;->setLayout(Landroid/text/Layout;)V

    .line 114
    :goto_2
    iget-object v0, p0, Lcom/facebook/react/flat/RCTText;->mDrawCommand:Lcom/facebook/react/flat/DrawTextLayout;

    invoke-virtual {v0}, Lcom/facebook/react/flat/DrawTextLayout;->getLayoutWidth()F

    move-result v0

    iget-object v1, p0, Lcom/facebook/react/flat/RCTText;->mDrawCommand:Lcom/facebook/react/flat/DrawTextLayout;

    invoke-virtual {v1}, Lcom/facebook/react/flat/DrawTextLayout;->getLayoutHeight()F

    move-result v1

    invoke-static {v0, v1}, Lcom/facebook/yoga/YogaMeasureOutput;->make(FF)J

    move-result-wide v0

    goto :goto_0

    .line 95
    .end local v12    # "layout":Landroid/text/Layout;
    :cond_1
    const/4 v5, 0x0

    goto :goto_1

    .line 111
    .restart local v12    # "layout":Landroid/text/Layout;
    :cond_2
    new-instance v0, Lcom/facebook/react/flat/DrawTextLayout;

    invoke-direct {v0, v12}, Lcom/facebook/react/flat/DrawTextLayout;-><init>(Landroid/text/Layout;)V

    iput-object v0, p0, Lcom/facebook/react/flat/RCTText;->mDrawCommand:Lcom/facebook/react/flat/DrawTextLayout;

    goto :goto_2
.end method

.method protected notifyChanged(Z)V
    .locals 0
    .param p1, "shouldRemeasure"    # Z

    .prologue
    .line 270
    invoke-virtual {p0}, Lcom/facebook/react/flat/RCTText;->dirty()V

    .line 271
    return-void
.end method

.method public setIncludeFontPadding(Z)V
    .locals 0
    .param p1, "includepad"    # Z
    .annotation runtime Lcom/facebook/react/uimanager/annotations/ReactProp;
        defaultBoolean = true
        name = "includeFontPadding"
    .end annotation

    .prologue
    .line 229
    iput-boolean p1, p0, Lcom/facebook/react/flat/RCTText;->mIncludeFontPadding:Z

    .line 230
    return-void
.end method

.method public setLineHeight(D)V
    .locals 3
    .param p1, "lineHeight"    # D
    .annotation runtime Lcom/facebook/react/uimanager/annotations/ReactProp;
        defaultDouble = NaN
        name = "lineHeight"
    .end annotation

    .prologue
    const/4 v1, 0x0

    .line 211
    invoke-static {p1, p2}, Ljava/lang/Double;->isNaN(D)Z

    move-result v0

    if-eqz v0, :cond_0

    .line 212
    const/high16 v0, 0x3f800000    # 1.0f

    iput v0, p0, Lcom/facebook/react/flat/RCTText;->mSpacingMult:F

    .line 213
    iput v1, p0, Lcom/facebook/react/flat/RCTText;->mSpacingAdd:F

    .line 218
    :goto_0
    const/4 v0, 0x1

    invoke-virtual {p0, v0}, Lcom/facebook/react/flat/RCTText;->notifyChanged(Z)V

    .line 219
    return-void

    .line 215
    :cond_0
    iput v1, p0, Lcom/facebook/react/flat/RCTText;->mSpacingMult:F

    .line 216
    double-to-float v0, p1

    invoke-static {v0}, Lcom/facebook/react/uimanager/PixelUtil;->toPixelFromSP(F)F

    move-result v0

    iput v0, p0, Lcom/facebook/react/flat/RCTText;->mSpacingAdd:F

    goto :goto_0
.end method

.method public setNumberOfLines(I)V
    .locals 1
    .param p1, "numberOfLines"    # I
    .annotation runtime Lcom/facebook/react/uimanager/annotations/ReactProp;
        defaultInt = 0x7fffffff
        name = "numberOfLines"
    .end annotation

    .prologue
    .line 223
    iput p1, p0, Lcom/facebook/react/flat/RCTText;->mNumberOfLines:I

    .line 224
    const/4 v0, 0x1

    invoke-virtual {p0, v0}, Lcom/facebook/react/flat/RCTText;->notifyChanged(Z)V

    .line 225
    return-void
.end method

.method public setTextAlign(Ljava/lang/String;)V
    .locals 3
    .param p1, "textAlign"    # Ljava/lang/String;
        .annotation runtime Ljavax/annotation/Nullable;
        .end annotation
    .end param
    .annotation runtime Lcom/facebook/react/uimanager/annotations/ReactProp;
        name = "textAlign"
    .end annotation

    .prologue
    const/4 v1, 0x0

    .line 275
    if-eqz p1, :cond_0

    const-string v0, "auto"

    invoke-virtual {v0, p1}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-eqz v0, :cond_1

    .line 276
    :cond_0
    iput v1, p0, Lcom/facebook/react/flat/RCTText;->mAlignment:I

    .line 289
    :goto_0
    invoke-virtual {p0, v1}, Lcom/facebook/react/flat/RCTText;->notifyChanged(Z)V

    .line 290
    return-void

    .line 277
    :cond_1
    const-string v0, "left"

    invoke-virtual {v0, p1}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-eqz v0, :cond_2

    .line 280
    const/4 v0, 0x3

    iput v0, p0, Lcom/facebook/react/flat/RCTText;->mAlignment:I

    goto :goto_0

    .line 281
    :cond_2
    const-string v0, "right"

    invoke-virtual {v0, p1}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-eqz v0, :cond_3

    .line 282
    const/4 v0, 0x5

    iput v0, p0, Lcom/facebook/react/flat/RCTText;->mAlignment:I

    goto :goto_0

    .line 283
    :cond_3
    const-string v0, "center"

    invoke-virtual {v0, p1}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-eqz v0, :cond_4

    .line 284
    const/16 v0, 0x11

    iput v0, p0, Lcom/facebook/react/flat/RCTText;->mAlignment:I

    goto :goto_0

    .line 286
    :cond_4
    new-instance v0, Lcom/facebook/react/bridge/JSApplicationIllegalArgumentException;

    new-instance v1, Ljava/lang/StringBuilder;

    invoke-direct {v1}, Ljava/lang/StringBuilder;-><init>()V

    const-string v2, "Invalid textAlign: "

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1, p1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    invoke-direct {v0, v1}, Lcom/facebook/react/bridge/JSApplicationIllegalArgumentException;-><init>(Ljava/lang/String;)V

    throw v0
.end method

.method updateNodeRegion(FFFFZ)V
    .locals 10
    .param p1, "left"    # F
    .param p2, "top"    # F
    .param p3, "right"    # F
    .param p4, "bottom"    # F
    .param p5, "isVirtual"    # Z

    .prologue
    .line 240
    invoke-virtual {p0}, Lcom/facebook/react/flat/RCTText;->getNodeRegion()Lcom/facebook/react/flat/NodeRegion;

    move-result-object v0

    .line 241
    .local v0, "nodeRegion":Lcom/facebook/react/flat/NodeRegion;
    iget-object v1, p0, Lcom/facebook/react/flat/RCTText;->mDrawCommand:Lcom/facebook/react/flat/DrawTextLayout;

    if-nez v1, :cond_1

    move v1, p1

    move v2, p2

    move v3, p3

    move v4, p4

    move v5, p5

    .line 242
    invoke-virtual/range {v0 .. v5}, Lcom/facebook/react/flat/NodeRegion;->matches(FFFFZ)Z

    move-result v1

    if-nez v1, :cond_0

    .line 243
    new-instance v1, Lcom/facebook/react/flat/TextNodeRegion;

    invoke-virtual {p0}, Lcom/facebook/react/flat/RCTText;->getReactTag()I

    move-result v6

    const/4 v8, 0x0

    move v2, p1

    move v3, p2

    move v4, p3

    move v5, p4

    move v7, p5

    invoke-direct/range {v1 .. v8}, Lcom/facebook/react/flat/TextNodeRegion;-><init>(FFFFIZLandroid/text/Layout;)V

    invoke-virtual {p0, v1}, Lcom/facebook/react/flat/RCTText;->setNodeRegion(Lcom/facebook/react/flat/NodeRegion;)V

    .line 259
    :cond_0
    :goto_0
    return-void

    .line 248
    :cond_1
    const/4 v9, 0x0

    .line 250
    .local v9, "layout":Landroid/text/Layout;
    instance-of v1, v0, Lcom/facebook/react/flat/TextNodeRegion;

    if-eqz v1, :cond_2

    move-object v1, v0

    .line 251
    check-cast v1, Lcom/facebook/react/flat/TextNodeRegion;

    invoke-virtual {v1}, Lcom/facebook/react/flat/TextNodeRegion;->getLayout()Landroid/text/Layout;

    move-result-object v9

    .line 254
    :cond_2
    iget-object v1, p0, Lcom/facebook/react/flat/RCTText;->mDrawCommand:Lcom/facebook/react/flat/DrawTextLayout;

    invoke-virtual {v1}, Lcom/facebook/react/flat/DrawTextLayout;->getLayout()Landroid/text/Layout;

    move-result-object v8

    .local v8, "newLayout":Landroid/text/Layout;
    move v1, p1

    move v2, p2

    move v3, p3

    move v4, p4

    move v5, p5

    .line 255
    invoke-virtual/range {v0 .. v5}, Lcom/facebook/react/flat/NodeRegion;->matches(FFFFZ)Z

    move-result v1

    if-eqz v1, :cond_3

    if-eq v9, v8, :cond_0

    .line 256
    :cond_3
    new-instance v1, Lcom/facebook/react/flat/TextNodeRegion;

    .line 257
    invoke-virtual {p0}, Lcom/facebook/react/flat/RCTText;->getReactTag()I

    move-result v6

    move v2, p1

    move v3, p2

    move v4, p3

    move v5, p4

    move v7, p5

    invoke-direct/range {v1 .. v8}, Lcom/facebook/react/flat/TextNodeRegion;-><init>(FFFFIZLandroid/text/Layout;)V

    .line 256
    invoke-virtual {p0, v1}, Lcom/facebook/react/flat/RCTText;->setNodeRegion(Lcom/facebook/react/flat/NodeRegion;)V

    goto :goto_0
.end method

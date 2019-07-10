.class public Lcom/facebook/fbui/textlayoutbuilder/ResourceTextLayoutHelper;
.super Ljava/lang/Object;
.source "ResourceTextLayoutHelper.java"


# static fields
.field private static final DEFAULT_TEXT_SIZE_PX:I = 0xf


# direct methods
.method public constructor <init>()V
    .locals 0

    .prologue
    .line 25
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method

.method public static setTextAppearance(Lcom/facebook/fbui/textlayoutbuilder/TextLayoutBuilder;Landroid/content/Context;I)V
    .locals 12
    .param p0, "builder"    # Lcom/facebook/fbui/textlayoutbuilder/TextLayoutBuilder;
    .param p1, "context"    # Landroid/content/Context;
    .param p2, "resId"    # I
        .annotation build Landroid/support/annotation/StyleRes;
        .end annotation
    .end param

    .prologue
    const/4 v11, 0x0

    const/4 v10, -0x1

    const/4 v9, 0x0

    .line 163
    sget-object v8, Lcom/facebook/fbui/textlayoutbuilder/R$styleable;->TextAppearance:[I

    invoke-virtual {p1, p2, v8}, Landroid/content/Context;->obtainStyledAttributes(I[I)Landroid/content/res/TypedArray;

    move-result-object v0

    .line 167
    .local v0, "customAttrs":Landroid/content/res/TypedArray;
    sget v8, Lcom/facebook/fbui/textlayoutbuilder/R$styleable;->TextAppearance_android_textColor:I

    invoke-virtual {v0, v8}, Landroid/content/res/TypedArray;->getColorStateList(I)Landroid/content/res/ColorStateList;

    move-result-object v5

    .line 170
    .local v5, "textColor":Landroid/content/res/ColorStateList;
    sget v8, Lcom/facebook/fbui/textlayoutbuilder/R$styleable;->TextAppearance_android_textSize:I

    invoke-virtual {v0, v8, v11}, Landroid/content/res/TypedArray;->getDimensionPixelSize(II)I

    move-result v6

    .line 174
    .local v6, "textSize":I
    sget v8, Lcom/facebook/fbui/textlayoutbuilder/R$styleable;->TextAppearance_android_shadowColor:I

    invoke-virtual {v0, v8, v11}, Landroid/content/res/TypedArray;->getInt(II)I

    move-result v4

    .line 178
    .local v4, "shadowColor":I
    if-eqz v4, :cond_0

    .line 179
    sget v8, Lcom/facebook/fbui/textlayoutbuilder/R$styleable;->TextAppearance_android_shadowDx:I

    invoke-virtual {v0, v8, v9}, Landroid/content/res/TypedArray;->getFloat(IF)F

    move-result v1

    .line 183
    .local v1, "dx":F
    sget v8, Lcom/facebook/fbui/textlayoutbuilder/R$styleable;->TextAppearance_android_shadowDy:I

    invoke-virtual {v0, v8, v9}, Landroid/content/res/TypedArray;->getFloat(IF)F

    move-result v2

    .line 187
    .local v2, "dy":F
    sget v8, Lcom/facebook/fbui/textlayoutbuilder/R$styleable;->TextAppearance_android_shadowRadius:I

    invoke-virtual {v0, v8, v9}, Landroid/content/res/TypedArray;->getFloat(IF)F

    move-result v3

    .line 191
    .local v3, "radius":F
    invoke-virtual {p0, v3, v1, v2, v4}, Lcom/facebook/fbui/textlayoutbuilder/TextLayoutBuilder;->setShadowLayer(FFFI)Lcom/facebook/fbui/textlayoutbuilder/TextLayoutBuilder;

    .line 194
    .end local v1    # "dx":F
    .end local v2    # "dy":F
    .end local v3    # "radius":F
    :cond_0
    sget v8, Lcom/facebook/fbui/textlayoutbuilder/R$styleable;->TextAppearance_android_textStyle:I

    invoke-virtual {v0, v8, v10}, Landroid/content/res/TypedArray;->getInt(II)I

    move-result v7

    .line 198
    .local v7, "textStyle":I
    invoke-virtual {v0}, Landroid/content/res/TypedArray;->recycle()V

    .line 201
    if-eqz v5, :cond_1

    .line 202
    invoke-virtual {p0, v5}, Lcom/facebook/fbui/textlayoutbuilder/TextLayoutBuilder;->setTextColor(Landroid/content/res/ColorStateList;)Lcom/facebook/fbui/textlayoutbuilder/TextLayoutBuilder;

    .line 205
    :cond_1
    if-eqz v6, :cond_2

    .line 206
    invoke-virtual {p0, v6}, Lcom/facebook/fbui/textlayoutbuilder/TextLayoutBuilder;->setTextSize(I)Lcom/facebook/fbui/textlayoutbuilder/TextLayoutBuilder;

    .line 210
    :cond_2
    if-eq v7, v10, :cond_3

    .line 211
    invoke-static {v7}, Landroid/graphics/Typeface;->defaultFromStyle(I)Landroid/graphics/Typeface;

    move-result-object v8

    invoke-virtual {p0, v8}, Lcom/facebook/fbui/textlayoutbuilder/TextLayoutBuilder;->setTypeface(Landroid/graphics/Typeface;)Lcom/facebook/fbui/textlayoutbuilder/TextLayoutBuilder;

    .line 213
    :cond_3
    return-void
.end method

.method public static updateFromStyleResource(Lcom/facebook/fbui/textlayoutbuilder/TextLayoutBuilder;Landroid/content/Context;I)V
    .locals 1
    .param p0, "builder"    # Lcom/facebook/fbui/textlayoutbuilder/TextLayoutBuilder;
    .param p1, "context"    # Landroid/content/Context;
    .param p2, "styleRes"    # I
        .annotation build Landroid/support/annotation/StyleRes;
        .end annotation
    .end param

    .prologue
    .line 41
    const/4 v0, 0x0

    invoke-static {p0, p1, v0, p2}, Lcom/facebook/fbui/textlayoutbuilder/ResourceTextLayoutHelper;->updateFromStyleResource(Lcom/facebook/fbui/textlayoutbuilder/TextLayoutBuilder;Landroid/content/Context;II)V

    .line 42
    return-void
.end method

.method public static updateFromStyleResource(Lcom/facebook/fbui/textlayoutbuilder/TextLayoutBuilder;Landroid/content/Context;II)V
    .locals 1
    .param p0, "builder"    # Lcom/facebook/fbui/textlayoutbuilder/TextLayoutBuilder;
    .param p1, "context"    # Landroid/content/Context;
    .param p2, "styleAttr"    # I
        .annotation build Landroid/support/annotation/AttrRes;
        .end annotation
    .end param
    .param p3, "styleRes"    # I
        .annotation build Landroid/support/annotation/StyleRes;
        .end annotation
    .end param

    .prologue
    .line 57
    const/4 v0, 0x0

    invoke-static {p0, p1, v0, p2, p3}, Lcom/facebook/fbui/textlayoutbuilder/ResourceTextLayoutHelper;->updateFromStyleResource(Lcom/facebook/fbui/textlayoutbuilder/TextLayoutBuilder;Landroid/content/Context;Landroid/util/AttributeSet;II)V

    .line 58
    return-void
.end method

.method public static updateFromStyleResource(Lcom/facebook/fbui/textlayoutbuilder/TextLayoutBuilder;Landroid/content/Context;Landroid/util/AttributeSet;II)V
    .locals 19
    .param p0, "builder"    # Lcom/facebook/fbui/textlayoutbuilder/TextLayoutBuilder;
    .param p1, "context"    # Landroid/content/Context;
    .param p2, "attrs"    # Landroid/util/AttributeSet;
    .param p3, "styleAttr"    # I
        .annotation build Landroid/support/annotation/AttrRes;
        .end annotation
    .end param
    .param p4, "styleRes"    # I
        .annotation build Landroid/support/annotation/StyleRes;
        .end annotation
    .end param

    .prologue
    .line 75
    sget-object v17, Lcom/facebook/fbui/textlayoutbuilder/R$styleable;->TextStyle:[I

    move-object/from16 v0, p1

    move-object/from16 v1, p2

    move-object/from16 v2, v17

    move/from16 v3, p3

    move/from16 v4, p4

    invoke-virtual {v0, v1, v2, v3, v4}, Landroid/content/Context;->obtainStyledAttributes(Landroid/util/AttributeSet;[III)Landroid/content/res/TypedArray;

    move-result-object v5

    .line 81
    .local v5, "customAttrs":Landroid/content/res/TypedArray;
    sget v17, Lcom/facebook/fbui/textlayoutbuilder/R$styleable;->TextStyle_android_textAppearance:I

    const/16 v18, -0x1

    move/from16 v0, v17

    move/from16 v1, v18

    invoke-virtual {v5, v0, v1}, Landroid/content/res/TypedArray;->getResourceId(II)I

    move-result v13

    .line 85
    .local v13, "textAppearanceId":I
    if-lez v13, :cond_0

    .line 86
    move-object/from16 v0, p0

    move-object/from16 v1, p1

    invoke-static {v0, v1, v13}, Lcom/facebook/fbui/textlayoutbuilder/ResourceTextLayoutHelper;->setTextAppearance(Lcom/facebook/fbui/textlayoutbuilder/TextLayoutBuilder;Landroid/content/Context;I)V

    .line 89
    :cond_0
    sget v17, Lcom/facebook/fbui/textlayoutbuilder/R$styleable;->TextStyle_android_textColor:I

    move/from16 v0, v17

    invoke-virtual {v5, v0}, Landroid/content/res/TypedArray;->getColorStateList(I)Landroid/content/res/ColorStateList;

    move-result-object v14

    .line 92
    .local v14, "textColor":Landroid/content/res/ColorStateList;
    sget v17, Lcom/facebook/fbui/textlayoutbuilder/R$styleable;->TextStyle_android_textSize:I

    const/16 v18, 0xf

    move/from16 v0, v17

    move/from16 v1, v18

    invoke-virtual {v5, v0, v1}, Landroid/content/res/TypedArray;->getDimensionPixelSize(II)I

    move-result v15

    .line 96
    .local v15, "textSize":I
    sget v17, Lcom/facebook/fbui/textlayoutbuilder/R$styleable;->TextStyle_android_shadowColor:I

    const/16 v18, 0x0

    move/from16 v0, v17

    move/from16 v1, v18

    invoke-virtual {v5, v0, v1}, Landroid/content/res/TypedArray;->getInt(II)I

    move-result v11

    .line 100
    .local v11, "shadowColor":I
    sget v17, Lcom/facebook/fbui/textlayoutbuilder/R$styleable;->TextStyle_android_shadowDx:I

    const/16 v18, 0x0

    move/from16 v0, v17

    move/from16 v1, v18

    invoke-virtual {v5, v0, v1}, Landroid/content/res/TypedArray;->getFloat(IF)F

    move-result v6

    .line 104
    .local v6, "dx":F
    sget v17, Lcom/facebook/fbui/textlayoutbuilder/R$styleable;->TextStyle_android_shadowDy:I

    const/16 v18, 0x0

    move/from16 v0, v17

    move/from16 v1, v18

    invoke-virtual {v5, v0, v1}, Landroid/content/res/TypedArray;->getFloat(IF)F

    move-result v7

    .line 108
    .local v7, "dy":F
    sget v17, Lcom/facebook/fbui/textlayoutbuilder/R$styleable;->TextStyle_android_shadowRadius:I

    const/16 v18, 0x0

    move/from16 v0, v17

    move/from16 v1, v18

    invoke-virtual {v5, v0, v1}, Landroid/content/res/TypedArray;->getFloat(IF)F

    move-result v10

    .line 112
    .local v10, "radius":F
    sget v17, Lcom/facebook/fbui/textlayoutbuilder/R$styleable;->TextStyle_android_textStyle:I

    const/16 v18, -0x1

    move/from16 v0, v17

    move/from16 v1, v18

    invoke-virtual {v5, v0, v1}, Landroid/content/res/TypedArray;->getInt(II)I

    move-result v16

    .line 116
    .local v16, "textStyle":I
    sget v17, Lcom/facebook/fbui/textlayoutbuilder/R$styleable;->TextStyle_android_ellipsize:I

    const/16 v18, 0x0

    move/from16 v0, v17

    move/from16 v1, v18

    invoke-virtual {v5, v0, v1}, Landroid/content/res/TypedArray;->getInt(II)I

    move-result v8

    .line 120
    .local v8, "ellipsize":I
    sget v17, Lcom/facebook/fbui/textlayoutbuilder/R$styleable;->TextStyle_android_singleLine:I

    const/16 v18, 0x0

    move/from16 v0, v17

    move/from16 v1, v18

    invoke-virtual {v5, v0, v1}, Landroid/content/res/TypedArray;->getBoolean(IZ)Z

    move-result v12

    .line 124
    .local v12, "singleLine":Z
    sget v17, Lcom/facebook/fbui/textlayoutbuilder/R$styleable;->TextStyle_android_maxLines:I

    const v18, 0x7fffffff

    move/from16 v0, v17

    move/from16 v1, v18

    invoke-virtual {v5, v0, v1}, Landroid/content/res/TypedArray;->getInt(II)I

    move-result v9

    .line 128
    .local v9, "maxLines":I
    invoke-virtual {v5}, Landroid/content/res/TypedArray;->recycle()V

    .line 130
    move-object/from16 v0, p0

    invoke-virtual {v0, v14}, Lcom/facebook/fbui/textlayoutbuilder/TextLayoutBuilder;->setTextColor(Landroid/content/res/ColorStateList;)Lcom/facebook/fbui/textlayoutbuilder/TextLayoutBuilder;

    .line 132
    move-object/from16 v0, p0

    invoke-virtual {v0, v15}, Lcom/facebook/fbui/textlayoutbuilder/TextLayoutBuilder;->setTextSize(I)Lcom/facebook/fbui/textlayoutbuilder/TextLayoutBuilder;

    .line 133
    move-object/from16 v0, p0

    invoke-virtual {v0, v10, v6, v7, v11}, Lcom/facebook/fbui/textlayoutbuilder/TextLayoutBuilder;->setShadowLayer(FFFI)Lcom/facebook/fbui/textlayoutbuilder/TextLayoutBuilder;

    .line 135
    const/16 v17, -0x1

    move/from16 v0, v16

    move/from16 v1, v17

    if-eq v0, v1, :cond_1

    .line 136
    invoke-static/range {v16 .. v16}, Landroid/graphics/Typeface;->defaultFromStyle(I)Landroid/graphics/Typeface;

    move-result-object v17

    move-object/from16 v0, p0

    move-object/from16 v1, v17

    invoke-virtual {v0, v1}, Lcom/facebook/fbui/textlayoutbuilder/TextLayoutBuilder;->setTypeface(Landroid/graphics/Typeface;)Lcom/facebook/fbui/textlayoutbuilder/TextLayoutBuilder;

    .line 141
    :goto_0
    if-lez v8, :cond_2

    const/16 v17, 0x4

    move/from16 v0, v17

    if-ge v8, v0, :cond_2

    .line 143
    invoke-static {}, Landroid/text/TextUtils$TruncateAt;->values()[Landroid/text/TextUtils$TruncateAt;

    move-result-object v17

    add-int/lit8 v18, v8, -0x1

    aget-object v17, v17, v18

    move-object/from16 v0, p0

    move-object/from16 v1, v17

    invoke-virtual {v0, v1}, Lcom/facebook/fbui/textlayoutbuilder/TextLayoutBuilder;->setEllipsize(Landroid/text/TextUtils$TruncateAt;)Lcom/facebook/fbui/textlayoutbuilder/TextLayoutBuilder;

    .line 148
    :goto_1
    move-object/from16 v0, p0

    invoke-virtual {v0, v12}, Lcom/facebook/fbui/textlayoutbuilder/TextLayoutBuilder;->setSingleLine(Z)Lcom/facebook/fbui/textlayoutbuilder/TextLayoutBuilder;

    .line 149
    move-object/from16 v0, p0

    invoke-virtual {v0, v9}, Lcom/facebook/fbui/textlayoutbuilder/TextLayoutBuilder;->setMaxLines(I)Lcom/facebook/fbui/textlayoutbuilder/TextLayoutBuilder;

    .line 150
    return-void

    .line 138
    :cond_1
    const/16 v17, 0x0

    move-object/from16 v0, p0

    move-object/from16 v1, v17

    invoke-virtual {v0, v1}, Lcom/facebook/fbui/textlayoutbuilder/TextLayoutBuilder;->setTypeface(Landroid/graphics/Typeface;)Lcom/facebook/fbui/textlayoutbuilder/TextLayoutBuilder;

    goto :goto_0

    .line 145
    :cond_2
    const/16 v17, 0x0

    move-object/from16 v0, p0

    move-object/from16 v1, v17

    invoke-virtual {v0, v1}, Lcom/facebook/fbui/textlayoutbuilder/TextLayoutBuilder;->setEllipsize(Landroid/text/TextUtils$TruncateAt;)Lcom/facebook/fbui/textlayoutbuilder/TextLayoutBuilder;

    goto :goto_1
.end method

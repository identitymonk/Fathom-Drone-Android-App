.class Lcom/facebook/fbui/textlayoutbuilder/StaticLayoutHelper;
.super Ljava/lang/Object;
.source "StaticLayoutHelper.java"


# static fields
.field private static final SPACE_AND_ELLIPSIS:Ljava/lang/String; = " \u2026"


# direct methods
.method constructor <init>()V
    .locals 0

    .prologue
    .line 25
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method

.method public static fixLayout(Landroid/text/StaticLayout;)Z
    .locals 15
    .param p0, "layout"    # Landroid/text/StaticLayout;

    .prologue
    const/4 v12, 0x0

    const/4 v13, 0x1

    .line 261
    invoke-virtual {p0, v12}, Landroid/text/StaticLayout;->getLineStart(I)I

    move-result v6

    .line 262
    .local v6, "lineStart":I
    const/4 v2, 0x0

    .local v2, "i":I
    invoke-virtual {p0}, Landroid/text/StaticLayout;->getLineCount()I

    move-result v4

    .local v4, "lineCount":I
    :goto_0
    if-ge v2, v4, :cond_0

    .line 263
    invoke-virtual {p0, v2}, Landroid/text/StaticLayout;->getLineEnd(I)I

    move-result v5

    .line 264
    .local v5, "lineEnd":I
    if-ge v5, v6, :cond_2

    .line 267
    :try_start_0
    const-class v11, Landroid/text/StaticLayout;

    const-string v14, "mLines"

    invoke-virtual {v11, v14}, Ljava/lang/Class;->getDeclaredField(Ljava/lang/String;)Ljava/lang/reflect/Field;

    move-result-object v10

    .line 268
    .local v10, "mLinesField":Ljava/lang/reflect/Field;
    const/4 v11, 0x1

    invoke-virtual {v10, v11}, Ljava/lang/reflect/Field;->setAccessible(Z)V

    .line 270
    const-class v11, Landroid/text/StaticLayout;

    const-string v14, "mColumns"

    invoke-virtual {v11, v14}, Ljava/lang/Class;->getDeclaredField(Ljava/lang/String;)Ljava/lang/reflect/Field;

    move-result-object v8

    .line 271
    .local v8, "mColumnsField":Ljava/lang/reflect/Field;
    const/4 v11, 0x1

    invoke-virtual {v8, v11}, Ljava/lang/reflect/Field;->setAccessible(Z)V

    .line 273
    invoke-virtual {v10, p0}, Ljava/lang/reflect/Field;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v11

    check-cast v11, [I

    move-object v0, v11

    check-cast v0, [I

    move-object v9, v0

    .line 274
    .local v9, "mLines":[I
    invoke-virtual {v8, p0}, Ljava/lang/reflect/Field;->getInt(Ljava/lang/Object;)I

    move-result v7

    .line 278
    .local v7, "mColumns":I
    const/4 v3, 0x0

    .local v3, "j":I
    :goto_1
    if-ge v3, v7, :cond_1

    .line 279
    mul-int v11, v7, v2

    add-int/2addr v11, v3

    mul-int v14, v7, v2

    add-int/2addr v14, v3

    add-int/2addr v14, v7

    invoke-static {v9, v11, v14}, Lcom/facebook/fbui/textlayoutbuilder/StaticLayoutHelper;->swap([III)V
    :try_end_0
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_0

    .line 278
    add-int/lit8 v3, v3, 0x1

    goto :goto_1

    .line 281
    .end local v3    # "j":I
    .end local v7    # "mColumns":I
    .end local v8    # "mColumnsField":Ljava/lang/reflect/Field;
    .end local v9    # "mLines":[I
    .end local v10    # "mLinesField":Ljava/lang/reflect/Field;
    :catch_0
    move-exception v1

    .end local v5    # "lineEnd":I
    :cond_0
    move v11, v13

    .line 293
    :goto_2
    return v11

    .restart local v3    # "j":I
    .restart local v5    # "lineEnd":I
    .restart local v7    # "mColumns":I
    .restart local v8    # "mColumnsField":Ljava/lang/reflect/Field;
    .restart local v9    # "mLines":[I
    .restart local v10    # "mLinesField":Ljava/lang/reflect/Field;
    :cond_1
    move v11, v12

    .line 287
    goto :goto_2

    .line 290
    .end local v3    # "j":I
    .end local v7    # "mColumns":I
    .end local v8    # "mColumnsField":Ljava/lang/reflect/Field;
    .end local v9    # "mLines":[I
    .end local v10    # "mLinesField":Ljava/lang/reflect/Field;
    :cond_2
    move v6, v5

    .line 262
    add-int/lit8 v2, v2, 0x1

    goto :goto_0
.end method

.method private static getStaticLayoutMaybeMaxLines(Ljava/lang/CharSequence;IILandroid/text/TextPaint;ILandroid/text/Layout$Alignment;FFZLandroid/text/TextUtils$TruncateAt;IILandroid/support/v4/text/TextDirectionHeuristicCompat;)Landroid/text/StaticLayout;
    .locals 1
    .param p0, "text"    # Ljava/lang/CharSequence;
    .param p1, "start"    # I
    .param p2, "end"    # I
    .param p3, "paint"    # Landroid/text/TextPaint;
    .param p4, "width"    # I
    .param p5, "alignment"    # Landroid/text/Layout$Alignment;
    .param p6, "spacingMult"    # F
    .param p7, "spacingAdd"    # F
    .param p8, "includePadding"    # Z
    .param p9, "ellipsize"    # Landroid/text/TextUtils$TruncateAt;
    .param p10, "ellipsisWidth"    # I
    .param p11, "maxLines"    # I
    .param p12, "textDirection"    # Landroid/support/v4/text/TextDirectionHeuristicCompat;

    .prologue
    .line 63
    :try_start_0
    invoke-static/range {p0 .. p12}, Lcom/facebook/fbui/textlayoutbuilder/proxy/StaticLayoutProxy;->create(Ljava/lang/CharSequence;IILandroid/text/TextPaint;ILandroid/text/Layout$Alignment;FFZLandroid/text/TextUtils$TruncateAt;IILandroid/support/v4/text/TextDirectionHeuristicCompat;)Landroid/text/StaticLayout;
    :try_end_0
    .catch Ljava/lang/LinkageError; {:try_start_0 .. :try_end_0} :catch_0

    move-result-object v0

    .line 81
    :goto_0
    return-object v0

    .line 77
    :catch_0
    move-exception v0

    .line 81
    invoke-static/range {p0 .. p10}, Lcom/facebook/fbui/textlayoutbuilder/StaticLayoutHelper;->getStaticLayoutNoMaxLines(Ljava/lang/CharSequence;IILandroid/text/TextPaint;ILandroid/text/Layout$Alignment;FFZLandroid/text/TextUtils$TruncateAt;I)Landroid/text/StaticLayout;

    move-result-object v0

    goto :goto_0
.end method

.method private static getStaticLayoutNoMaxLines(Ljava/lang/CharSequence;IILandroid/text/TextPaint;ILandroid/text/Layout$Alignment;FFZLandroid/text/TextUtils$TruncateAt;I)Landroid/text/StaticLayout;
    .locals 12
    .param p0, "text"    # Ljava/lang/CharSequence;
    .param p1, "start"    # I
    .param p2, "end"    # I
    .param p3, "paint"    # Landroid/text/TextPaint;
    .param p4, "width"    # I
    .param p5, "alignment"    # Landroid/text/Layout$Alignment;
    .param p6, "spacingMult"    # F
    .param p7, "spacingAdd"    # F
    .param p8, "includePadding"    # Z
    .param p9, "ellipsize"    # Landroid/text/TextUtils$TruncateAt;
    .param p10, "ellipsisWidth"    # I

    .prologue
    .line 124
    new-instance v0, Landroid/text/StaticLayout;

    move-object v1, p0

    move v2, p1

    move v3, p2

    move-object v4, p3

    move/from16 v5, p4

    move-object/from16 v6, p5

    move/from16 v7, p6

    move/from16 v8, p7

    move/from16 v9, p8

    move-object/from16 v10, p9

    move/from16 v11, p10

    invoke-direct/range {v0 .. v11}, Landroid/text/StaticLayout;-><init>(Ljava/lang/CharSequence;IILandroid/text/TextPaint;ILandroid/text/Layout$Alignment;FFZLandroid/text/TextUtils$TruncateAt;I)V

    return-object v0
.end method

.method public static make(Ljava/lang/CharSequence;IILandroid/text/TextPaint;ILandroid/text/Layout$Alignment;FFZLandroid/text/TextUtils$TruncateAt;IILandroid/support/v4/text/TextDirectionHeuristicCompat;)Landroid/text/StaticLayout;
    .locals 16
    .param p0, "text"    # Ljava/lang/CharSequence;
    .param p1, "start"    # I
    .param p2, "end"    # I
    .param p3, "paint"    # Landroid/text/TextPaint;
    .param p4, "width"    # I
    .param p5, "alignment"    # Landroid/text/Layout$Alignment;
    .param p6, "spacingMult"    # F
    .param p7, "spacingAdd"    # F
    .param p8, "includePadding"    # Z
    .param p9, "ellipsize"    # Landroid/text/TextUtils$TruncateAt;
    .param p10, "ellipsisWidth"    # I
    .param p11, "maxLines"    # I
    .param p12, "textDirection"    # Landroid/support/v4/text/TextDirectionHeuristicCompat;

    .prologue
    .line 171
    invoke-static/range {p0 .. p12}, Lcom/facebook/fbui/textlayoutbuilder/StaticLayoutHelper;->getStaticLayoutMaybeMaxLines(Ljava/lang/CharSequence;IILandroid/text/TextPaint;ILandroid/text/Layout$Alignment;FFZLandroid/text/TextUtils$TruncateAt;IILandroid/support/v4/text/TextDirectionHeuristicCompat;)Landroid/text/StaticLayout;

    move-result-object v14

    .line 190
    .local v14, "layout":Landroid/text/StaticLayout;
    if-lez p11, :cond_1

    .line 191
    :cond_0
    :goto_0
    invoke-virtual {v14}, Landroid/text/StaticLayout;->getLineCount()I

    move-result v2

    move/from16 v0, p11

    if-le v2, v0, :cond_1

    .line 192
    move/from16 v0, p11

    invoke-virtual {v14, v0}, Landroid/text/StaticLayout;->getLineStart(I)I

    move-result v15

    .line 193
    .local v15, "newEnd":I
    move/from16 v0, p2

    if-lt v15, v0, :cond_2

    .line 246
    .end local v15    # "newEnd":I
    :cond_1
    invoke-static {v14}, Lcom/facebook/fbui/textlayoutbuilder/StaticLayoutHelper;->fixLayout(Landroid/text/StaticLayout;)Z

    move-result v2

    if-eqz v2, :cond_1

    .line 250
    return-object v14

    .line 200
    .restart local v15    # "newEnd":I
    :cond_2
    :goto_1
    move/from16 v0, p1

    if-le v15, v0, :cond_3

    .line 201
    add-int/lit8 v2, v15, -0x1

    move-object/from16 v0, p0

    invoke-interface {v0, v2}, Ljava/lang/CharSequence;->charAt(I)C

    move-result v2

    invoke-static {v2}, Ljava/lang/Character;->isSpace(C)Z

    move-result v2

    if-eqz v2, :cond_3

    .line 202
    add-int/lit8 v15, v15, -0x1

    goto :goto_1

    .line 208
    :cond_3
    move/from16 p2, v15

    .line 210
    invoke-static/range {p0 .. p12}, Lcom/facebook/fbui/textlayoutbuilder/StaticLayoutHelper;->getStaticLayoutMaybeMaxLines(Ljava/lang/CharSequence;IILandroid/text/TextPaint;ILandroid/text/Layout$Alignment;FFZLandroid/text/TextUtils$TruncateAt;IILandroid/support/v4/text/TextDirectionHeuristicCompat;)Landroid/text/StaticLayout;

    move-result-object v14

    .line 225
    invoke-virtual {v14}, Landroid/text/StaticLayout;->getLineCount()I

    move-result v2

    move/from16 v0, p11

    if-lt v2, v0, :cond_0

    add-int/lit8 v2, p11, -0x1

    .line 226
    invoke-virtual {v14, v2}, Landroid/text/StaticLayout;->getEllipsisCount(I)I

    move-result v2

    if-nez v2, :cond_0

    .line 227
    new-instance v2, Ljava/lang/StringBuilder;

    invoke-direct {v2}, Ljava/lang/StringBuilder;-><init>()V

    invoke-interface/range {p0 .. p2}, Ljava/lang/CharSequence;->subSequence(II)Ljava/lang/CharSequence;

    move-result-object v3

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    move-result-object v2

    const-string v3, " \u2026"

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    .line 228
    .local v1, "ellipsizedText":Ljava/lang/CharSequence;
    const/4 v2, 0x0

    .line 231
    invoke-interface {v1}, Ljava/lang/CharSequence;->length()I

    move-result v3

    move-object/from16 v4, p3

    move/from16 v5, p4

    move-object/from16 v6, p5

    move/from16 v7, p6

    move/from16 v8, p7

    move/from16 v9, p8

    move-object/from16 v10, p9

    move/from16 v11, p10

    move/from16 v12, p11

    move-object/from16 v13, p12

    .line 228
    invoke-static/range {v1 .. v13}, Lcom/facebook/fbui/textlayoutbuilder/StaticLayoutHelper;->getStaticLayoutMaybeMaxLines(Ljava/lang/CharSequence;IILandroid/text/TextPaint;ILandroid/text/Layout$Alignment;FFZLandroid/text/TextUtils$TruncateAt;IILandroid/support/v4/text/TextDirectionHeuristicCompat;)Landroid/text/StaticLayout;

    move-result-object v14

    goto :goto_0
.end method

.method private static swap([III)V
    .locals 2
    .param p0, "array"    # [I
    .param p1, "i"    # I
    .param p2, "j"    # I

    .prologue
    .line 297
    aget v0, p0, p1

    .line 298
    .local v0, "tmp":I
    aget v1, p0, p2

    aput v1, p0, p1

    .line 299
    aput v0, p0, p2

    .line 300
    return-void
.end method

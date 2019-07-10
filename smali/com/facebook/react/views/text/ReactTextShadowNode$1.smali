.class Lcom/facebook/react/views/text/ReactTextShadowNode$1;
.super Ljava/lang/Object;
.source "ReactTextShadowNode.java"

# interfaces
.implements Lcom/facebook/yoga/YogaMeasureFunction;


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/facebook/react/views/text/ReactTextShadowNode;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$0:Lcom/facebook/react/views/text/ReactTextShadowNode;


# direct methods
.method constructor <init>(Lcom/facebook/react/views/text/ReactTextShadowNode;)V
    .locals 0
    .param p1, "this$0"    # Lcom/facebook/react/views/text/ReactTextShadowNode;

    .prologue
    .line 48
    iput-object p1, p0, Lcom/facebook/react/views/text/ReactTextShadowNode$1;->this$0:Lcom/facebook/react/views/text/ReactTextShadowNode;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public measure(Lcom/facebook/yoga/YogaNode;FLcom/facebook/yoga/YogaMeasureMode;FLcom/facebook/yoga/YogaMeasureMode;)J
    .locals 23
    .param p1, "node"    # Lcom/facebook/yoga/YogaNode;
    .param p2, "width"    # F
    .param p3, "widthMode"    # Lcom/facebook/yoga/YogaMeasureMode;
    .param p4, "height"    # F
    .param p5, "heightMode"    # Lcom/facebook/yoga/YogaMeasureMode;

    .prologue
    .line 57
    invoke-static {}, Lcom/facebook/react/views/text/ReactTextShadowNode;->access$000()Landroid/text/TextPaint;

    move-result-object v4

    .line 59
    .local v4, "textPaint":Landroid/text/TextPaint;
    move-object/from16 v0, p0

    iget-object v6, v0, Lcom/facebook/react/views/text/ReactTextShadowNode$1;->this$0:Lcom/facebook/react/views/text/ReactTextShadowNode;

    .line 60
    invoke-static {v6}, Lcom/facebook/react/views/text/ReactTextShadowNode;->access$100(Lcom/facebook/react/views/text/ReactTextShadowNode;)Landroid/text/Spannable;

    move-result-object v6

    const-string v7, "Spannable element has not been prepared in onBeforeLayout"

    .line 59
    invoke-static {v6, v7}, Lcom/facebook/infer/annotation/Assertions;->assertNotNull(Ljava/lang/Object;Ljava/lang/String;)Ljava/lang/Object;

    move-result-object v3

    check-cast v3, Landroid/text/Spanned;

    .line 62
    .local v3, "text":Landroid/text/Spanned;
    invoke-static {v3, v4}, Landroid/text/BoringLayout;->isBoring(Ljava/lang/CharSequence;Landroid/text/TextPaint;)Landroid/text/BoringLayout$Metrics;

    move-result-object v12

    .line 63
    .local v12, "boring":Landroid/text/BoringLayout$Metrics;
    if-nez v12, :cond_2

    .line 64
    invoke-static {v3, v4}, Landroid/text/Layout;->getDesiredWidth(Ljava/lang/CharSequence;Landroid/text/TextPaint;)F

    move-result v21

    .line 67
    .local v21, "desiredWidth":F
    :goto_0
    sget-object v6, Lcom/facebook/yoga/YogaMeasureMode;->UNDEFINED:Lcom/facebook/yoga/YogaMeasureMode;

    move-object/from16 v0, p3

    if-eq v0, v6, :cond_0

    const/4 v6, 0x0

    cmpg-float v6, p2, v6

    if-gez v6, :cond_3

    :cond_0
    const/16 v22, 0x1

    .line 69
    .local v22, "unconstrainedWidth":Z
    :goto_1
    if-nez v12, :cond_5

    if-nez v22, :cond_1

    .line 71
    invoke-static/range {v21 .. v21}, Lcom/facebook/yoga/YogaConstants;->isUndefined(F)Z

    move-result v6

    if-nez v6, :cond_5

    cmpg-float v6, v21, p2

    if-gtz v6, :cond_5

    .line 75
    :cond_1
    move/from16 v0, v21

    float-to-double v6, v0

    invoke-static {v6, v7}, Ljava/lang/Math;->ceil(D)D

    move-result-wide v6

    double-to-int v5, v6

    .line 76
    .local v5, "hintWidth":I
    sget v6, Landroid/os/Build$VERSION;->SDK_INT:I

    const/16 v7, 0x17

    if-ge v6, v7, :cond_4

    .line 77
    new-instance v2, Landroid/text/StaticLayout;

    sget-object v6, Landroid/text/Layout$Alignment;->ALIGN_NORMAL:Landroid/text/Layout$Alignment;

    const/high16 v7, 0x3f800000    # 1.0f

    const/4 v8, 0x0

    move-object/from16 v0, p0

    iget-object v9, v0, Lcom/facebook/react/views/text/ReactTextShadowNode$1;->this$0:Lcom/facebook/react/views/text/ReactTextShadowNode;

    iget-boolean v9, v9, Lcom/facebook/react/views/text/ReactTextShadowNode;->mIncludeFontPadding:Z

    invoke-direct/range {v2 .. v9}, Landroid/text/StaticLayout;-><init>(Ljava/lang/CharSequence;Landroid/text/TextPaint;ILandroid/text/Layout$Alignment;FFZ)V

    .line 130
    .end local v5    # "hintWidth":I
    .local v2, "layout":Landroid/text/Layout;
    :goto_2
    move-object/from16 v0, p0

    iget-object v6, v0, Lcom/facebook/react/views/text/ReactTextShadowNode$1;->this$0:Lcom/facebook/react/views/text/ReactTextShadowNode;

    iget v6, v6, Lcom/facebook/react/views/text/ReactTextShadowNode;->mNumberOfLines:I

    const/4 v7, -0x1

    if-eq v6, v7, :cond_9

    move-object/from16 v0, p0

    iget-object v6, v0, Lcom/facebook/react/views/text/ReactTextShadowNode$1;->this$0:Lcom/facebook/react/views/text/ReactTextShadowNode;

    iget v6, v6, Lcom/facebook/react/views/text/ReactTextShadowNode;->mNumberOfLines:I

    .line 131
    invoke-virtual {v2}, Landroid/text/Layout;->getLineCount()I

    move-result v7

    if-ge v6, v7, :cond_9

    .line 133
    invoke-virtual {v2}, Landroid/text/Layout;->getWidth()I

    move-result v6

    move-object/from16 v0, p0

    iget-object v7, v0, Lcom/facebook/react/views/text/ReactTextShadowNode$1;->this$0:Lcom/facebook/react/views/text/ReactTextShadowNode;

    iget v7, v7, Lcom/facebook/react/views/text/ReactTextShadowNode;->mNumberOfLines:I

    add-int/lit8 v7, v7, -0x1

    .line 134
    invoke-virtual {v2, v7}, Landroid/text/Layout;->getLineBottom(I)I

    move-result v7

    .line 132
    invoke-static {v6, v7}, Lcom/facebook/yoga/YogaMeasureOutput;->make(II)J

    move-result-wide v6

    .line 136
    :goto_3
    return-wide v6

    .line 64
    .end local v2    # "layout":Landroid/text/Layout;
    .end local v21    # "desiredWidth":F
    .end local v22    # "unconstrainedWidth":Z
    :cond_2
    const/high16 v21, 0x7fc00000    # Float.NaN

    goto :goto_0

    .line 67
    .restart local v21    # "desiredWidth":F
    :cond_3
    const/16 v22, 0x0

    goto :goto_1

    .line 86
    .restart local v5    # "hintWidth":I
    .restart local v22    # "unconstrainedWidth":Z
    :cond_4
    const/4 v6, 0x0

    invoke-interface {v3}, Landroid/text/Spanned;->length()I

    move-result v7

    invoke-static {v3, v6, v7, v4, v5}, Landroid/text/StaticLayout$Builder;->obtain(Ljava/lang/CharSequence;IILandroid/text/TextPaint;I)Landroid/text/StaticLayout$Builder;

    move-result-object v6

    sget-object v7, Landroid/text/Layout$Alignment;->ALIGN_NORMAL:Landroid/text/Layout$Alignment;

    .line 87
    invoke-virtual {v6, v7}, Landroid/text/StaticLayout$Builder;->setAlignment(Landroid/text/Layout$Alignment;)Landroid/text/StaticLayout$Builder;

    move-result-object v6

    const/4 v7, 0x0

    const/high16 v8, 0x3f800000    # 1.0f

    .line 88
    invoke-virtual {v6, v7, v8}, Landroid/text/StaticLayout$Builder;->setLineSpacing(FF)Landroid/text/StaticLayout$Builder;

    move-result-object v6

    move-object/from16 v0, p0

    iget-object v7, v0, Lcom/facebook/react/views/text/ReactTextShadowNode$1;->this$0:Lcom/facebook/react/views/text/ReactTextShadowNode;

    iget-boolean v7, v7, Lcom/facebook/react/views/text/ReactTextShadowNode;->mIncludeFontPadding:Z

    .line 89
    invoke-virtual {v6, v7}, Landroid/text/StaticLayout$Builder;->setIncludePad(Z)Landroid/text/StaticLayout$Builder;

    move-result-object v6

    move-object/from16 v0, p0

    iget-object v7, v0, Lcom/facebook/react/views/text/ReactTextShadowNode$1;->this$0:Lcom/facebook/react/views/text/ReactTextShadowNode;

    iget v7, v7, Lcom/facebook/react/views/text/ReactTextShadowNode;->mTextBreakStrategy:I

    .line 90
    invoke-virtual {v6, v7}, Landroid/text/StaticLayout$Builder;->setBreakStrategy(I)Landroid/text/StaticLayout$Builder;

    move-result-object v6

    const/4 v7, 0x1

    .line 91
    invoke-virtual {v6, v7}, Landroid/text/StaticLayout$Builder;->setHyphenationFrequency(I)Landroid/text/StaticLayout$Builder;

    move-result-object v6

    .line 92
    invoke-virtual {v6}, Landroid/text/StaticLayout$Builder;->build()Landroid/text/StaticLayout;

    move-result-object v2

    .restart local v2    # "layout":Landroid/text/Layout;
    goto :goto_2

    .line 95
    .end local v2    # "layout":Landroid/text/Layout;
    .end local v5    # "hintWidth":I
    :cond_5
    if-eqz v12, :cond_7

    if-nez v22, :cond_6

    iget v6, v12, Landroid/text/BoringLayout$Metrics;->width:I

    int-to-float v6, v6

    cmpg-float v6, v6, p2

    if-gtz v6, :cond_7

    .line 98
    :cond_6
    iget v8, v12, Landroid/text/BoringLayout$Metrics;->width:I

    sget-object v9, Landroid/text/Layout$Alignment;->ALIGN_NORMAL:Landroid/text/Layout$Alignment;

    const/high16 v10, 0x3f800000    # 1.0f

    const/4 v11, 0x0

    move-object/from16 v0, p0

    iget-object v6, v0, Lcom/facebook/react/views/text/ReactTextShadowNode$1;->this$0:Lcom/facebook/react/views/text/ReactTextShadowNode;

    iget-boolean v13, v6, Lcom/facebook/react/views/text/ReactTextShadowNode;->mIncludeFontPadding:Z

    move-object v6, v3

    move-object v7, v4

    invoke-static/range {v6 .. v13}, Landroid/text/BoringLayout;->make(Ljava/lang/CharSequence;Landroid/text/TextPaint;ILandroid/text/Layout$Alignment;FFLandroid/text/BoringLayout$Metrics;Z)Landroid/text/BoringLayout;

    move-result-object v2

    .restart local v2    # "layout":Landroid/text/Layout;
    goto/16 :goto_2

    .line 110
    .end local v2    # "layout":Landroid/text/Layout;
    :cond_7
    sget v6, Landroid/os/Build$VERSION;->SDK_INT:I

    const/16 v7, 0x17

    if-ge v6, v7, :cond_8

    .line 111
    new-instance v2, Landroid/text/StaticLayout;

    move/from16 v0, p2

    float-to-int v0, v0

    move/from16 v16, v0

    sget-object v17, Landroid/text/Layout$Alignment;->ALIGN_NORMAL:Landroid/text/Layout$Alignment;

    const/high16 v18, 0x3f800000    # 1.0f

    const/16 v19, 0x0

    move-object/from16 v0, p0

    iget-object v6, v0, Lcom/facebook/react/views/text/ReactTextShadowNode$1;->this$0:Lcom/facebook/react/views/text/ReactTextShadowNode;

    iget-boolean v0, v6, Lcom/facebook/react/views/text/ReactTextShadowNode;->mIncludeFontPadding:Z

    move/from16 v20, v0

    move-object v13, v2

    move-object v14, v3

    move-object v15, v4

    invoke-direct/range {v13 .. v20}, Landroid/text/StaticLayout;-><init>(Ljava/lang/CharSequence;Landroid/text/TextPaint;ILandroid/text/Layout$Alignment;FFZ)V

    .restart local v2    # "layout":Landroid/text/Layout;
    goto/16 :goto_2

    .line 120
    .end local v2    # "layout":Landroid/text/Layout;
    :cond_8
    const/4 v6, 0x0

    invoke-interface {v3}, Landroid/text/Spanned;->length()I

    move-result v7

    move/from16 v0, p2

    float-to-int v8, v0

    invoke-static {v3, v6, v7, v4, v8}, Landroid/text/StaticLayout$Builder;->obtain(Ljava/lang/CharSequence;IILandroid/text/TextPaint;I)Landroid/text/StaticLayout$Builder;

    move-result-object v6

    sget-object v7, Landroid/text/Layout$Alignment;->ALIGN_NORMAL:Landroid/text/Layout$Alignment;

    .line 121
    invoke-virtual {v6, v7}, Landroid/text/StaticLayout$Builder;->setAlignment(Landroid/text/Layout$Alignment;)Landroid/text/StaticLayout$Builder;

    move-result-object v6

    const/4 v7, 0x0

    const/high16 v8, 0x3f800000    # 1.0f

    .line 122
    invoke-virtual {v6, v7, v8}, Landroid/text/StaticLayout$Builder;->setLineSpacing(FF)Landroid/text/StaticLayout$Builder;

    move-result-object v6

    move-object/from16 v0, p0

    iget-object v7, v0, Lcom/facebook/react/views/text/ReactTextShadowNode$1;->this$0:Lcom/facebook/react/views/text/ReactTextShadowNode;

    iget-boolean v7, v7, Lcom/facebook/react/views/text/ReactTextShadowNode;->mIncludeFontPadding:Z

    .line 123
    invoke-virtual {v6, v7}, Landroid/text/StaticLayout$Builder;->setIncludePad(Z)Landroid/text/StaticLayout$Builder;

    move-result-object v6

    move-object/from16 v0, p0

    iget-object v7, v0, Lcom/facebook/react/views/text/ReactTextShadowNode$1;->this$0:Lcom/facebook/react/views/text/ReactTextShadowNode;

    iget v7, v7, Lcom/facebook/react/views/text/ReactTextShadowNode;->mTextBreakStrategy:I

    .line 124
    invoke-virtual {v6, v7}, Landroid/text/StaticLayout$Builder;->setBreakStrategy(I)Landroid/text/StaticLayout$Builder;

    move-result-object v6

    const/4 v7, 0x1

    .line 125
    invoke-virtual {v6, v7}, Landroid/text/StaticLayout$Builder;->setHyphenationFrequency(I)Landroid/text/StaticLayout$Builder;

    move-result-object v6

    .line 126
    invoke-virtual {v6}, Landroid/text/StaticLayout$Builder;->build()Landroid/text/StaticLayout;

    move-result-object v2

    .restart local v2    # "layout":Landroid/text/Layout;
    goto/16 :goto_2

    .line 136
    :cond_9
    invoke-virtual {v2}, Landroid/text/Layout;->getWidth()I

    move-result v6

    invoke-virtual {v2}, Landroid/text/Layout;->getHeight()I

    move-result v7

    invoke-static {v6, v7}, Lcom/facebook/yoga/YogaMeasureOutput;->make(II)J

    move-result-wide v6

    goto/16 :goto_3
.end method

.class final Lcom/facebook/react/flat/TextNodeRegion;
.super Lcom/facebook/react/flat/NodeRegion;
.source "TextNodeRegion.java"


# instance fields
.field private mLayout:Landroid/text/Layout;
    .annotation runtime Ljavax/annotation/Nullable;
    .end annotation
.end field


# direct methods
.method constructor <init>(FFFFIZLandroid/text/Layout;)V
    .locals 0
    .param p1, "left"    # F
    .param p2, "top"    # F
    .param p3, "right"    # F
    .param p4, "bottom"    # F
    .param p5, "tag"    # I
    .param p6, "isVirtual"    # Z
    .param p7, "layout"    # Landroid/text/Layout;
        .annotation runtime Ljavax/annotation/Nullable;
        .end annotation
    .end param

    .prologue
    .line 28
    invoke-direct/range {p0 .. p6}, Lcom/facebook/react/flat/NodeRegion;-><init>(FFFFIZ)V

    .line 29
    iput-object p7, p0, Lcom/facebook/react/flat/TextNodeRegion;->mLayout:Landroid/text/Layout;

    .line 30
    return-void
.end method


# virtual methods
.method getLayout()Landroid/text/Layout;
    .locals 1
    .annotation runtime Ljavax/annotation/Nullable;
    .end annotation

    .prologue
    .line 37
    iget-object v0, p0, Lcom/facebook/react/flat/TextNodeRegion;->mLayout:Landroid/text/Layout;

    return-object v0
.end method

.method getReactTag(FF)I
    .locals 10
    .param p1, "touchX"    # F
    .param p2, "touchY"    # F

    .prologue
    const/4 v9, 0x0

    .line 41
    iget-object v7, p0, Lcom/facebook/react/flat/TextNodeRegion;->mLayout:Landroid/text/Layout;

    if-eqz v7, :cond_0

    .line 42
    iget-object v7, p0, Lcom/facebook/react/flat/TextNodeRegion;->mLayout:Landroid/text/Layout;

    invoke-virtual {v7}, Landroid/text/Layout;->getText()Ljava/lang/CharSequence;

    move-result-object v4

    .line 43
    .local v4, "text":Ljava/lang/CharSequence;
    instance-of v7, v4, Landroid/text/Spanned;

    if-eqz v7, :cond_0

    .line 44
    invoke-virtual {p0}, Lcom/facebook/react/flat/TextNodeRegion;->getTop()F

    move-result v7

    sub-float v7, p2, v7

    invoke-static {v7}, Ljava/lang/Math;->round(F)I

    move-result v6

    .line 45
    .local v6, "y":I
    iget-object v7, p0, Lcom/facebook/react/flat/TextNodeRegion;->mLayout:Landroid/text/Layout;

    invoke-virtual {v7, v9}, Landroid/text/Layout;->getLineTop(I)I

    move-result v7

    if-lt v6, v7, :cond_0

    iget-object v7, p0, Lcom/facebook/react/flat/TextNodeRegion;->mLayout:Landroid/text/Layout;

    iget-object v8, p0, Lcom/facebook/react/flat/TextNodeRegion;->mLayout:Landroid/text/Layout;

    invoke-virtual {v8}, Landroid/text/Layout;->getLineCount()I

    move-result v8

    add-int/lit8 v8, v8, -0x1

    invoke-virtual {v7, v8}, Landroid/text/Layout;->getLineBottom(I)I

    move-result v7

    if-ge v6, v7, :cond_0

    .line 46
    invoke-virtual {p0}, Lcom/facebook/react/flat/TextNodeRegion;->getLeft()F

    move-result v7

    sub-float v7, p1, v7

    invoke-static {v7}, Ljava/lang/Math;->round(F)I

    move-result v7

    int-to-float v5, v7

    .line 47
    .local v5, "x":F
    iget-object v7, p0, Lcom/facebook/react/flat/TextNodeRegion;->mLayout:Landroid/text/Layout;

    invoke-virtual {v7, v6}, Landroid/text/Layout;->getLineForVertical(I)I

    move-result v0

    .line 49
    .local v0, "line":I
    iget-object v7, p0, Lcom/facebook/react/flat/TextNodeRegion;->mLayout:Landroid/text/Layout;

    invoke-virtual {v7, v0}, Landroid/text/Layout;->getLineLeft(I)F

    move-result v7

    cmpg-float v7, v7, v5

    if-gtz v7, :cond_0

    iget-object v7, p0, Lcom/facebook/react/flat/TextNodeRegion;->mLayout:Landroid/text/Layout;

    invoke-virtual {v7, v0}, Landroid/text/Layout;->getLineRight(I)F

    move-result v7

    cmpg-float v7, v5, v7

    if-gtz v7, :cond_0

    .line 50
    iget-object v7, p0, Lcom/facebook/react/flat/TextNodeRegion;->mLayout:Landroid/text/Layout;

    invoke-virtual {v7, v0, v5}, Landroid/text/Layout;->getOffsetForHorizontal(IF)I

    move-result v2

    .local v2, "off":I
    move-object v3, v4

    .line 52
    check-cast v3, Landroid/text/Spanned;

    .line 53
    .local v3, "spanned":Landroid/text/Spanned;
    const-class v7, Lcom/facebook/react/flat/RCTRawText;

    invoke-interface {v3, v2, v2, v7}, Landroid/text/Spanned;->getSpans(IILjava/lang/Class;)[Ljava/lang/Object;

    move-result-object v1

    check-cast v1, [Lcom/facebook/react/flat/RCTRawText;

    .line 55
    .local v1, "link":[Lcom/facebook/react/flat/RCTRawText;
    array-length v7, v1

    if-eqz v7, :cond_0

    .line 56
    aget-object v7, v1, v9

    invoke-virtual {v7}, Lcom/facebook/react/flat/RCTRawText;->getReactTag()I

    move-result v7

    .line 63
    .end local v0    # "line":I
    .end local v1    # "link":[Lcom/facebook/react/flat/RCTRawText;
    .end local v2    # "off":I
    .end local v3    # "spanned":Landroid/text/Spanned;
    .end local v4    # "text":Ljava/lang/CharSequence;
    .end local v5    # "x":F
    .end local v6    # "y":I
    :goto_0
    return v7

    :cond_0
    invoke-super {p0, p1, p2}, Lcom/facebook/react/flat/NodeRegion;->getReactTag(FF)I

    move-result v7

    goto :goto_0
.end method

.method matchesTag(I)Z
    .locals 8
    .param p1, "tag"    # I

    .prologue
    const/4 v3, 0x1

    const/4 v4, 0x0

    .line 68
    invoke-super {p0, p1}, Lcom/facebook/react/flat/NodeRegion;->matchesTag(I)Z

    move-result v5

    if-eqz v5, :cond_1

    .line 81
    :cond_0
    :goto_0
    return v3

    .line 72
    :cond_1
    iget-object v5, p0, Lcom/facebook/react/flat/TextNodeRegion;->mLayout:Landroid/text/Layout;

    if-eqz v5, :cond_2

    .line 73
    iget-object v5, p0, Lcom/facebook/react/flat/TextNodeRegion;->mLayout:Landroid/text/Layout;

    invoke-virtual {v5}, Landroid/text/Layout;->getText()Ljava/lang/CharSequence;

    move-result-object v2

    check-cast v2, Landroid/text/Spanned;

    .line 74
    .local v2, "text":Landroid/text/Spanned;
    invoke-interface {v2}, Landroid/text/Spanned;->length()I

    move-result v5

    const-class v6, Lcom/facebook/react/flat/RCTRawText;

    invoke-interface {v2, v4, v5, v6}, Landroid/text/Spanned;->getSpans(IILjava/lang/Class;)[Ljava/lang/Object;

    move-result-object v1

    check-cast v1, [Lcom/facebook/react/flat/RCTRawText;

    .line 75
    .local v1, "spans":[Lcom/facebook/react/flat/RCTRawText;
    array-length v6, v1

    move v5, v4

    :goto_1
    if-ge v5, v6, :cond_2

    aget-object v0, v1, v5

    .line 76
    .local v0, "span":Lcom/facebook/react/flat/RCTRawText;
    invoke-virtual {v0}, Lcom/facebook/react/flat/RCTRawText;->getReactTag()I

    move-result v7

    if-eq v7, p1, :cond_0

    .line 75
    add-int/lit8 v5, v5, 0x1

    goto :goto_1

    .end local v0    # "span":Lcom/facebook/react/flat/RCTRawText;
    .end local v1    # "spans":[Lcom/facebook/react/flat/RCTRawText;
    .end local v2    # "text":Landroid/text/Spanned;
    :cond_2
    move v3, v4

    .line 81
    goto :goto_0
.end method

.method public setLayout(Landroid/text/Layout;)V
    .locals 0
    .param p1, "layout"    # Landroid/text/Layout;

    .prologue
    .line 33
    iput-object p1, p0, Lcom/facebook/react/flat/TextNodeRegion;->mLayout:Landroid/text/Layout;

    .line 34
    return-void
.end method

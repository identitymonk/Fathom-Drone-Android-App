.class public Lcom/facebook/fbui/textlayoutbuilder/util/LayoutMeasureUtil;
.super Ljava/lang/Object;
.source "LayoutMeasureUtil.java"


# direct methods
.method public constructor <init>()V
    .locals 0

    .prologue
    .line 19
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method

.method public static getHeight(Landroid/text/Layout;)I
    .locals 10
    .param p0, "layout"    # Landroid/text/Layout;

    .prologue
    const-wide/high16 v8, 0x3fe0000000000000L    # 0.5

    .line 53
    if-nez p0, :cond_0

    .line 54
    const/4 v5, 0x0

    .line 70
    :goto_0
    return v5

    .line 57
    :cond_0
    const/4 v3, 0x0

    .line 58
    .local v3, "extra":I
    sget v5, Landroid/os/Build$VERSION;->SDK_INT:I

    const/16 v6, 0x14

    if-ge v5, v6, :cond_1

    instance-of v5, p0, Landroid/text/StaticLayout;

    if-eqz v5, :cond_1

    .line 60
    invoke-virtual {p0}, Landroid/text/Layout;->getLineCount()I

    move-result v5

    add-int/lit8 v5, v5, -0x1

    invoke-virtual {p0, v5}, Landroid/text/Layout;->getLineAscent(I)I

    move-result v0

    .line 61
    .local v0, "above":I
    invoke-virtual {p0}, Landroid/text/Layout;->getLineCount()I

    move-result v5

    add-int/lit8 v5, v5, -0x1

    invoke-virtual {p0, v5}, Landroid/text/Layout;->getLineDescent(I)I

    move-result v1

    .line 62
    .local v1, "below":I
    sub-int v5, v1, v0

    int-to-float v5, v5

    invoke-virtual {p0}, Landroid/text/Layout;->getSpacingAdd()F

    move-result v6

    sub-float/2addr v5, v6

    invoke-virtual {p0}, Landroid/text/Layout;->getSpacingMultiplier()F

    move-result v6

    div-float v4, v5, v6

    .line 63
    .local v4, "originalSize":F
    sub-int v5, v1, v0

    int-to-float v5, v5

    sub-float v2, v5, v4

    .line 64
    .local v2, "ex":F
    const/4 v5, 0x0

    cmpl-float v5, v2, v5

    if-ltz v5, :cond_2

    .line 65
    float-to-double v6, v2

    add-double/2addr v6, v8

    double-to-int v3, v6

    .line 70
    .end local v0    # "above":I
    .end local v1    # "below":I
    .end local v2    # "ex":F
    .end local v4    # "originalSize":F
    :cond_1
    :goto_1
    invoke-virtual {p0}, Landroid/text/Layout;->getHeight()I

    move-result v5

    sub-int/2addr v5, v3

    goto :goto_0

    .line 67
    .restart local v0    # "above":I
    .restart local v1    # "below":I
    .restart local v2    # "ex":F
    .restart local v4    # "originalSize":F
    :cond_2
    neg-float v5, v2

    float-to-double v6, v5

    add-double/2addr v6, v8

    double-to-int v5, v6

    neg-int v3, v5

    goto :goto_1
.end method

.method public static getWidth(Landroid/text/Layout;)I
    .locals 4
    .param p0, "layout"    # Landroid/text/Layout;

    .prologue
    .line 28
    if-nez p0, :cond_1

    .line 29
    const/4 v2, 0x0

    .line 40
    :cond_0
    return v2

    .line 33
    :cond_1
    invoke-virtual {p0}, Landroid/text/Layout;->getLineCount()I

    move-result v0

    .line 34
    .local v0, "count":I
    const/4 v2, 0x0

    .line 36
    .local v2, "maxWidth":I
    const/4 v1, 0x0

    .local v1, "i":I
    :goto_0
    if-ge v1, v0, :cond_0

    .line 37
    invoke-virtual {p0, v1}, Landroid/text/Layout;->getLineRight(I)F

    move-result v3

    float-to-int v3, v3

    invoke-static {v2, v3}, Ljava/lang/Math;->max(II)I

    move-result v2

    .line 36
    add-int/lit8 v1, v1, 0x1

    goto :goto_0
.end method

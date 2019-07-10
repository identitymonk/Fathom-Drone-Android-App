.class final Lcom/facebook/react/flat/DrawTextLayout;
.super Lcom/facebook/react/flat/AbstractDrawCommand;
.source "DrawTextLayout.java"


# instance fields
.field private mLayout:Landroid/text/Layout;

.field private mLayoutHeight:F

.field private mLayoutWidth:F


# direct methods
.method constructor <init>(Landroid/text/Layout;)V
    .locals 0
    .param p1, "layout"    # Landroid/text/Layout;

    .prologue
    .line 26
    invoke-direct {p0}, Lcom/facebook/react/flat/AbstractDrawCommand;-><init>()V

    .line 27
    invoke-virtual {p0, p1}, Lcom/facebook/react/flat/DrawTextLayout;->setLayout(Landroid/text/Layout;)V

    .line 28
    return-void
.end method


# virtual methods
.method public getLayout()Landroid/text/Layout;
    .locals 1

    .prologue
    .line 40
    iget-object v0, p0, Lcom/facebook/react/flat/DrawTextLayout;->mLayout:Landroid/text/Layout;

    return-object v0
.end method

.method public getLayoutHeight()F
    .locals 1

    .prologue
    .line 49
    iget v0, p0, Lcom/facebook/react/flat/DrawTextLayout;->mLayoutHeight:F

    return v0
.end method

.method public getLayoutWidth()F
    .locals 1

    .prologue
    .line 45
    iget v0, p0, Lcom/facebook/react/flat/DrawTextLayout;->mLayoutWidth:F

    return v0
.end method

.method protected onDraw(Landroid/graphics/Canvas;)V
    .locals 4
    .param p1, "canvas"    # Landroid/graphics/Canvas;

    .prologue
    .line 54
    invoke-virtual {p0}, Lcom/facebook/react/flat/DrawTextLayout;->getLeft()F

    move-result v0

    .line 55
    .local v0, "left":F
    invoke-virtual {p0}, Lcom/facebook/react/flat/DrawTextLayout;->getTop()F

    move-result v1

    .line 57
    .local v1, "top":F
    invoke-virtual {p1, v0, v1}, Landroid/graphics/Canvas;->translate(FF)V

    .line 58
    iget-object v2, p0, Lcom/facebook/react/flat/DrawTextLayout;->mLayout:Landroid/text/Layout;

    invoke-virtual {v2, p1}, Landroid/text/Layout;->draw(Landroid/graphics/Canvas;)V

    .line 59
    neg-float v2, v0

    neg-float v3, v1

    invoke-virtual {p1, v2, v3}, Landroid/graphics/Canvas;->translate(FF)V

    .line 60
    return-void
.end method

.method public setLayout(Landroid/text/Layout;)V
    .locals 1
    .param p1, "layout"    # Landroid/text/Layout;

    .prologue
    .line 34
    iput-object p1, p0, Lcom/facebook/react/flat/DrawTextLayout;->mLayout:Landroid/text/Layout;

    .line 35
    invoke-virtual {p1}, Landroid/text/Layout;->getWidth()I

    move-result v0

    int-to-float v0, v0

    iput v0, p0, Lcom/facebook/react/flat/DrawTextLayout;->mLayoutWidth:F

    .line 36
    invoke-static {p1}, Lcom/facebook/fbui/textlayoutbuilder/util/LayoutMeasureUtil;->getHeight(Landroid/text/Layout;)I

    move-result v0

    int-to-float v0, v0

    iput v0, p0, Lcom/facebook/react/flat/DrawTextLayout;->mLayoutHeight:F

    .line 37
    return-void
.end method

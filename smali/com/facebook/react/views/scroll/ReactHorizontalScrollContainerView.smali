.class public Lcom/facebook/react/views/scroll/ReactHorizontalScrollContainerView;
.super Landroid/view/ViewGroup;
.source "ReactHorizontalScrollContainerView.java"


# instance fields
.field private mLayoutDirection:I


# direct methods
.method public constructor <init>(Landroid/content/Context;)V
    .locals 1
    .param p1, "context"    # Landroid/content/Context;

    .prologue
    .line 16
    invoke-direct {p0, p1}, Landroid/view/ViewGroup;-><init>(Landroid/content/Context;)V

    .line 18
    invoke-static {}, Lcom/facebook/react/modules/i18nmanager/I18nUtil;->getInstance()Lcom/facebook/react/modules/i18nmanager/I18nUtil;

    move-result-object v0

    invoke-virtual {v0, p1}, Lcom/facebook/react/modules/i18nmanager/I18nUtil;->isRTL(Landroid/content/Context;)Z

    move-result v0

    if-eqz v0, :cond_0

    const/4 v0, 0x1

    :goto_0
    iput v0, p0, Lcom/facebook/react/views/scroll/ReactHorizontalScrollContainerView;->mLayoutDirection:I

    .line 19
    return-void

    .line 18
    :cond_0
    const/4 v0, 0x0

    goto :goto_0
.end method


# virtual methods
.method protected onLayout(ZIIII)V
    .locals 7
    .param p1, "changed"    # Z
    .param p2, "left"    # I
    .param p3, "top"    # I
    .param p4, "right"    # I
    .param p5, "bottom"    # I

    .prologue
    .line 23
    iget v5, p0, Lcom/facebook/react/views/scroll/ReactHorizontalScrollContainerView;->mLayoutDirection:I

    const/4 v6, 0x1

    if-ne v5, v6, :cond_0

    .line 26
    const/4 v0, 0x0

    .line 27
    .local v0, "newLeft":I
    sub-int v4, p4, p2

    .line 28
    .local v4, "width":I
    add-int v1, v0, v4

    .line 29
    .local v1, "newRight":I
    invoke-virtual {p0, v0}, Lcom/facebook/react/views/scroll/ReactHorizontalScrollContainerView;->setLeft(I)V

    .line 30
    invoke-virtual {p0, v1}, Lcom/facebook/react/views/scroll/ReactHorizontalScrollContainerView;->setRight(I)V

    .line 33
    invoke-virtual {p0}, Lcom/facebook/react/views/scroll/ReactHorizontalScrollContainerView;->computeHorizontalScrollRange()I

    move-result v5

    invoke-virtual {p0}, Lcom/facebook/react/views/scroll/ReactHorizontalScrollContainerView;->getScrollX()I

    move-result v6

    sub-int v2, v5, v6

    .line 36
    .local v2, "offsetX":I
    invoke-virtual {p0}, Lcom/facebook/react/views/scroll/ReactHorizontalScrollContainerView;->getParent()Landroid/view/ViewParent;

    move-result-object v3

    check-cast v3, Landroid/widget/HorizontalScrollView;

    .line 37
    .local v3, "parent":Landroid/widget/HorizontalScrollView;
    invoke-virtual {v3}, Landroid/widget/HorizontalScrollView;->getScrollY()I

    move-result v5

    invoke-virtual {v3, v2, v5}, Landroid/widget/HorizontalScrollView;->scrollTo(II)V

    .line 39
    .end local v0    # "newLeft":I
    .end local v1    # "newRight":I
    .end local v2    # "offsetX":I
    .end local v3    # "parent":Landroid/widget/HorizontalScrollView;
    .end local v4    # "width":I
    :cond_0
    return-void
.end method

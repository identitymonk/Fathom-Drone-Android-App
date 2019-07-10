.class public Lio/vov/vitamio/widget/CenterLayout;
.super Landroid/view/ViewGroup;
.source "CenterLayout.java"


# annotations
.annotation runtime Landroid/widget/RemoteViews$RemoteView;
.end annotation

.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lio/vov/vitamio/widget/CenterLayout$LayoutParams;
    }
.end annotation


# instance fields
.field private mHeight:I

.field private mPaddingBottom:I

.field private mPaddingLeft:I

.field private mPaddingRight:I

.field private mPaddingTop:I

.field private mWidth:I


# direct methods
.method public constructor <init>(Landroid/content/Context;)V
    .locals 1
    .param p1, "context"    # Landroid/content/Context;

    .prologue
    const/4 v0, 0x0

    .line 34
    invoke-direct {p0, p1}, Landroid/view/ViewGroup;-><init>(Landroid/content/Context;)V

    .line 27
    iput v0, p0, Lio/vov/vitamio/widget/CenterLayout;->mPaddingLeft:I

    .line 28
    iput v0, p0, Lio/vov/vitamio/widget/CenterLayout;->mPaddingRight:I

    .line 29
    iput v0, p0, Lio/vov/vitamio/widget/CenterLayout;->mPaddingTop:I

    .line 30
    iput v0, p0, Lio/vov/vitamio/widget/CenterLayout;->mPaddingBottom:I

    .line 35
    return-void
.end method

.method public constructor <init>(Landroid/content/Context;Landroid/util/AttributeSet;)V
    .locals 1
    .param p1, "context"    # Landroid/content/Context;
    .param p2, "attrs"    # Landroid/util/AttributeSet;

    .prologue
    const/4 v0, 0x0

    .line 38
    invoke-direct {p0, p1, p2}, Landroid/view/ViewGroup;-><init>(Landroid/content/Context;Landroid/util/AttributeSet;)V

    .line 27
    iput v0, p0, Lio/vov/vitamio/widget/CenterLayout;->mPaddingLeft:I

    .line 28
    iput v0, p0, Lio/vov/vitamio/widget/CenterLayout;->mPaddingRight:I

    .line 29
    iput v0, p0, Lio/vov/vitamio/widget/CenterLayout;->mPaddingTop:I

    .line 30
    iput v0, p0, Lio/vov/vitamio/widget/CenterLayout;->mPaddingBottom:I

    .line 39
    return-void
.end method

.method public constructor <init>(Landroid/content/Context;Landroid/util/AttributeSet;I)V
    .locals 1
    .param p1, "context"    # Landroid/content/Context;
    .param p2, "attrs"    # Landroid/util/AttributeSet;
    .param p3, "defStyle"    # I

    .prologue
    const/4 v0, 0x0

    .line 42
    invoke-direct {p0, p1, p2, p3}, Landroid/view/ViewGroup;-><init>(Landroid/content/Context;Landroid/util/AttributeSet;I)V

    .line 27
    iput v0, p0, Lio/vov/vitamio/widget/CenterLayout;->mPaddingLeft:I

    .line 28
    iput v0, p0, Lio/vov/vitamio/widget/CenterLayout;->mPaddingRight:I

    .line 29
    iput v0, p0, Lio/vov/vitamio/widget/CenterLayout;->mPaddingTop:I

    .line 30
    iput v0, p0, Lio/vov/vitamio/widget/CenterLayout;->mPaddingBottom:I

    .line 43
    return-void
.end method


# virtual methods
.method protected checkLayoutParams(Landroid/view/ViewGroup$LayoutParams;)Z
    .locals 1
    .param p1, "p"    # Landroid/view/ViewGroup$LayoutParams;

    .prologue
    .line 105
    instance-of v0, p1, Lio/vov/vitamio/widget/CenterLayout$LayoutParams;

    return v0
.end method

.method protected generateLayoutParams(Landroid/view/ViewGroup$LayoutParams;)Landroid/view/ViewGroup$LayoutParams;
    .locals 1
    .param p1, "p"    # Landroid/view/ViewGroup$LayoutParams;

    .prologue
    .line 110
    new-instance v0, Lio/vov/vitamio/widget/CenterLayout$LayoutParams;

    invoke-direct {v0, p1}, Lio/vov/vitamio/widget/CenterLayout$LayoutParams;-><init>(Landroid/view/ViewGroup$LayoutParams;)V

    return-object v0
.end method

.method protected onLayout(ZIIII)V
    .locals 10
    .param p1, "changed"    # Z
    .param p2, "l"    # I
    .param p3, "t"    # I
    .param p4, "r"    # I
    .param p5, "b"    # I

    .prologue
    const-wide/high16 v8, 0x4000000000000000L    # 2.0

    .line 81
    invoke-virtual {p0}, Lio/vov/vitamio/widget/CenterLayout;->getChildCount()I

    move-result v3

    .line 82
    .local v3, "count":I
    invoke-virtual {p0}, Lio/vov/vitamio/widget/CenterLayout;->getMeasuredWidth()I

    move-result v6

    iput v6, p0, Lio/vov/vitamio/widget/CenterLayout;->mWidth:I

    .line 83
    invoke-virtual {p0}, Lio/vov/vitamio/widget/CenterLayout;->getMeasuredHeight()I

    move-result v6

    iput v6, p0, Lio/vov/vitamio/widget/CenterLayout;->mHeight:I

    .line 84
    const/4 v4, 0x0

    .local v4, "i":I
    :goto_0
    if-ge v4, v3, :cond_3

    .line 85
    invoke-virtual {p0, v4}, Lio/vov/vitamio/widget/CenterLayout;->getChildAt(I)Landroid/view/View;

    move-result-object v0

    .line 86
    .local v0, "child":Landroid/view/View;
    invoke-virtual {v0}, Landroid/view/View;->getVisibility()I

    move-result v6

    const/16 v7, 0x8

    if-eq v6, v7, :cond_0

    .line 87
    invoke-virtual {v0}, Landroid/view/View;->getLayoutParams()Landroid/view/ViewGroup$LayoutParams;

    move-result-object v5

    check-cast v5, Lio/vov/vitamio/widget/CenterLayout$LayoutParams;

    .line 88
    .local v5, "lp":Lio/vov/vitamio/widget/CenterLayout$LayoutParams;
    iget v6, p0, Lio/vov/vitamio/widget/CenterLayout;->mPaddingLeft:I

    iget v7, v5, Lio/vov/vitamio/widget/CenterLayout$LayoutParams;->x:I

    add-int v1, v6, v7

    .line 89
    .local v1, "childLeft":I
    iget v6, v5, Lio/vov/vitamio/widget/CenterLayout$LayoutParams;->width:I

    if-lez v6, :cond_1

    .line 90
    iget v6, p0, Lio/vov/vitamio/widget/CenterLayout;->mWidth:I

    iget v7, v5, Lio/vov/vitamio/widget/CenterLayout$LayoutParams;->width:I

    sub-int/2addr v6, v7

    int-to-double v6, v6

    div-double/2addr v6, v8

    double-to-int v6, v6

    add-int/2addr v1, v6

    .line 93
    :goto_1
    iget v6, p0, Lio/vov/vitamio/widget/CenterLayout;->mPaddingTop:I

    iget v7, v5, Lio/vov/vitamio/widget/CenterLayout$LayoutParams;->y:I

    add-int v2, v6, v7

    .line 94
    .local v2, "childTop":I
    iget v6, v5, Lio/vov/vitamio/widget/CenterLayout$LayoutParams;->height:I

    if-lez v6, :cond_2

    .line 95
    iget v6, p0, Lio/vov/vitamio/widget/CenterLayout;->mHeight:I

    iget v7, v5, Lio/vov/vitamio/widget/CenterLayout$LayoutParams;->height:I

    sub-int/2addr v6, v7

    int-to-double v6, v6

    div-double/2addr v6, v8

    double-to-int v6, v6

    add-int/2addr v2, v6

    .line 98
    :goto_2
    invoke-virtual {v0}, Landroid/view/View;->getMeasuredWidth()I

    move-result v6

    add-int/2addr v6, v1

    invoke-virtual {v0}, Landroid/view/View;->getMeasuredHeight()I

    move-result v7

    add-int/2addr v7, v2

    invoke-virtual {v0, v1, v2, v6, v7}, Landroid/view/View;->layout(IIII)V

    .line 84
    .end local v1    # "childLeft":I
    .end local v2    # "childTop":I
    .end local v5    # "lp":Lio/vov/vitamio/widget/CenterLayout$LayoutParams;
    :cond_0
    add-int/lit8 v4, v4, 0x1

    goto :goto_0

    .line 92
    .restart local v1    # "childLeft":I
    .restart local v5    # "lp":Lio/vov/vitamio/widget/CenterLayout$LayoutParams;
    :cond_1
    iget v6, p0, Lio/vov/vitamio/widget/CenterLayout;->mWidth:I

    invoke-virtual {v0}, Landroid/view/View;->getMeasuredWidth()I

    move-result v7

    sub-int/2addr v6, v7

    int-to-double v6, v6

    div-double/2addr v6, v8

    double-to-int v6, v6

    add-int/2addr v1, v6

    goto :goto_1

    .line 97
    .restart local v2    # "childTop":I
    :cond_2
    iget v6, p0, Lio/vov/vitamio/widget/CenterLayout;->mHeight:I

    invoke-virtual {v0}, Landroid/view/View;->getMeasuredHeight()I

    move-result v7

    sub-int/2addr v6, v7

    int-to-double v6, v6

    div-double/2addr v6, v8

    double-to-int v6, v6

    add-int/2addr v2, v6

    goto :goto_2

    .line 101
    .end local v0    # "child":Landroid/view/View;
    .end local v1    # "childLeft":I
    .end local v2    # "childTop":I
    .end local v5    # "lp":Lio/vov/vitamio/widget/CenterLayout$LayoutParams;
    :cond_3
    return-void
.end method

.method protected onMeasure(II)V
    .locals 10
    .param p1, "widthMeasureSpec"    # I
    .param p2, "heightMeasureSpec"    # I

    .prologue
    .line 47
    invoke-virtual {p0}, Lio/vov/vitamio/widget/CenterLayout;->getChildCount()I

    move-result v3

    .line 49
    .local v3, "count":I
    const/4 v6, 0x0

    .line 50
    .local v6, "maxHeight":I
    const/4 v7, 0x0

    .line 52
    .local v7, "maxWidth":I
    invoke-virtual {p0, p1, p2}, Lio/vov/vitamio/widget/CenterLayout;->measureChildren(II)V

    .line 54
    const/4 v4, 0x0

    .local v4, "i":I
    :goto_0
    if-ge v4, v3, :cond_1

    .line 55
    invoke-virtual {p0, v4}, Lio/vov/vitamio/widget/CenterLayout;->getChildAt(I)Landroid/view/View;

    move-result-object v0

    .line 56
    .local v0, "child":Landroid/view/View;
    invoke-virtual {v0}, Landroid/view/View;->getVisibility()I

    move-result v8

    const/16 v9, 0x8

    if-eq v8, v9, :cond_0

    .line 60
    invoke-virtual {v0}, Landroid/view/View;->getLayoutParams()Landroid/view/ViewGroup$LayoutParams;

    move-result-object v5

    check-cast v5, Lio/vov/vitamio/widget/CenterLayout$LayoutParams;

    .line 62
    .local v5, "lp":Lio/vov/vitamio/widget/CenterLayout$LayoutParams;
    iget v8, v5, Lio/vov/vitamio/widget/CenterLayout$LayoutParams;->x:I

    invoke-virtual {v0}, Landroid/view/View;->getMeasuredWidth()I

    move-result v9

    add-int v2, v8, v9

    .line 63
    .local v2, "childRight":I
    iget v8, v5, Lio/vov/vitamio/widget/CenterLayout$LayoutParams;->y:I

    invoke-virtual {v0}, Landroid/view/View;->getMeasuredHeight()I

    move-result v9

    add-int v1, v8, v9

    .line 65
    .local v1, "childBottom":I
    invoke-static {v7, v2}, Ljava/lang/Math;->max(II)I

    move-result v7

    .line 66
    invoke-static {v6, v1}, Ljava/lang/Math;->max(II)I

    move-result v6

    .line 54
    .end local v1    # "childBottom":I
    .end local v2    # "childRight":I
    .end local v5    # "lp":Lio/vov/vitamio/widget/CenterLayout$LayoutParams;
    :cond_0
    add-int/lit8 v4, v4, 0x1

    goto :goto_0

    .line 70
    .end local v0    # "child":Landroid/view/View;
    :cond_1
    iget v8, p0, Lio/vov/vitamio/widget/CenterLayout;->mPaddingLeft:I

    iget v9, p0, Lio/vov/vitamio/widget/CenterLayout;->mPaddingRight:I

    add-int/2addr v8, v9

    add-int/2addr v7, v8

    .line 71
    iget v8, p0, Lio/vov/vitamio/widget/CenterLayout;->mPaddingTop:I

    iget v9, p0, Lio/vov/vitamio/widget/CenterLayout;->mPaddingBottom:I

    add-int/2addr v8, v9

    add-int/2addr v6, v8

    .line 73
    invoke-virtual {p0}, Lio/vov/vitamio/widget/CenterLayout;->getSuggestedMinimumHeight()I

    move-result v8

    invoke-static {v6, v8}, Ljava/lang/Math;->max(II)I

    move-result v6

    .line 74
    invoke-virtual {p0}, Lio/vov/vitamio/widget/CenterLayout;->getSuggestedMinimumWidth()I

    move-result v8

    invoke-static {v7, v8}, Ljava/lang/Math;->max(II)I

    move-result v7

    .line 76
    invoke-static {v7, p1}, Lio/vov/vitamio/widget/CenterLayout;->resolveSize(II)I

    move-result v8

    invoke-static {v6, p2}, Lio/vov/vitamio/widget/CenterLayout;->resolveSize(II)I

    move-result v9

    invoke-virtual {p0, v8, v9}, Lio/vov/vitamio/widget/CenterLayout;->setMeasuredDimension(II)V

    .line 77
    return-void
.end method

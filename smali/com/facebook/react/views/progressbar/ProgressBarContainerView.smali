.class Lcom/facebook/react/views/progressbar/ProgressBarContainerView;
.super Landroid/widget/FrameLayout;
.source "ProgressBarContainerView.java"


# static fields
.field private static final MAX_PROGRESS:I = 0x3e8


# instance fields
.field private mAnimating:Z

.field private mColor:Ljava/lang/Integer;
    .annotation runtime Ljavax/annotation/Nullable;
    .end annotation
.end field

.field private mIndeterminate:Z

.field private mProgress:D

.field private mProgressBar:Landroid/widget/ProgressBar;
    .annotation runtime Ljavax/annotation/Nullable;
    .end annotation
.end field


# direct methods
.method public constructor <init>(Landroid/content/Context;)V
    .locals 1
    .param p1, "context"    # Landroid/content/Context;

    .prologue
    const/4 v0, 0x1

    .line 31
    invoke-direct {p0, p1}, Landroid/widget/FrameLayout;-><init>(Landroid/content/Context;)V

    .line 25
    iput-boolean v0, p0, Lcom/facebook/react/views/progressbar/ProgressBarContainerView;->mIndeterminate:Z

    .line 26
    iput-boolean v0, p0, Lcom/facebook/react/views/progressbar/ProgressBarContainerView;->mAnimating:Z

    .line 32
    return-void
.end method

.method private setColor(Landroid/widget/ProgressBar;)V
    .locals 3
    .param p1, "progressBar"    # Landroid/widget/ProgressBar;

    .prologue
    .line 79
    invoke-virtual {p1}, Landroid/widget/ProgressBar;->isIndeterminate()Z

    move-result v1

    if-eqz v1, :cond_0

    .line 80
    invoke-virtual {p1}, Landroid/widget/ProgressBar;->getIndeterminateDrawable()Landroid/graphics/drawable/Drawable;

    move-result-object v0

    .line 85
    .local v0, "drawable":Landroid/graphics/drawable/Drawable;
    :goto_0
    if-nez v0, :cond_1

    .line 94
    :goto_1
    return-void

    .line 82
    .end local v0    # "drawable":Landroid/graphics/drawable/Drawable;
    :cond_0
    invoke-virtual {p1}, Landroid/widget/ProgressBar;->getProgressDrawable()Landroid/graphics/drawable/Drawable;

    move-result-object v0

    .restart local v0    # "drawable":Landroid/graphics/drawable/Drawable;
    goto :goto_0

    .line 89
    :cond_1
    iget-object v1, p0, Lcom/facebook/react/views/progressbar/ProgressBarContainerView;->mColor:Ljava/lang/Integer;

    if-eqz v1, :cond_2

    .line 90
    iget-object v1, p0, Lcom/facebook/react/views/progressbar/ProgressBarContainerView;->mColor:Ljava/lang/Integer;

    invoke-virtual {v1}, Ljava/lang/Integer;->intValue()I

    move-result v1

    sget-object v2, Landroid/graphics/PorterDuff$Mode;->SRC_IN:Landroid/graphics/PorterDuff$Mode;

    invoke-virtual {v0, v1, v2}, Landroid/graphics/drawable/Drawable;->setColorFilter(ILandroid/graphics/PorterDuff$Mode;)V

    goto :goto_1

    .line 92
    :cond_2
    invoke-virtual {v0}, Landroid/graphics/drawable/Drawable;->clearColorFilter()V

    goto :goto_1
.end method


# virtual methods
.method public apply()V
    .locals 6

    .prologue
    .line 63
    iget-object v0, p0, Lcom/facebook/react/views/progressbar/ProgressBarContainerView;->mProgressBar:Landroid/widget/ProgressBar;

    if-nez v0, :cond_0

    .line 64
    new-instance v0, Lcom/facebook/react/bridge/JSApplicationIllegalArgumentException;

    const-string v1, "setStyle() not called"

    invoke-direct {v0, v1}, Lcom/facebook/react/bridge/JSApplicationIllegalArgumentException;-><init>(Ljava/lang/String;)V

    throw v0

    .line 67
    :cond_0
    iget-object v0, p0, Lcom/facebook/react/views/progressbar/ProgressBarContainerView;->mProgressBar:Landroid/widget/ProgressBar;

    iget-boolean v1, p0, Lcom/facebook/react/views/progressbar/ProgressBarContainerView;->mIndeterminate:Z

    invoke-virtual {v0, v1}, Landroid/widget/ProgressBar;->setIndeterminate(Z)V

    .line 68
    iget-object v0, p0, Lcom/facebook/react/views/progressbar/ProgressBarContainerView;->mProgressBar:Landroid/widget/ProgressBar;

    invoke-direct {p0, v0}, Lcom/facebook/react/views/progressbar/ProgressBarContainerView;->setColor(Landroid/widget/ProgressBar;)V

    .line 69
    iget-object v0, p0, Lcom/facebook/react/views/progressbar/ProgressBarContainerView;->mProgressBar:Landroid/widget/ProgressBar;

    iget-wide v2, p0, Lcom/facebook/react/views/progressbar/ProgressBarContainerView;->mProgress:D

    const-wide v4, 0x408f400000000000L    # 1000.0

    mul-double/2addr v2, v4

    double-to-int v1, v2

    invoke-virtual {v0, v1}, Landroid/widget/ProgressBar;->setProgress(I)V

    .line 70
    iget-boolean v0, p0, Lcom/facebook/react/views/progressbar/ProgressBarContainerView;->mAnimating:Z

    if-eqz v0, :cond_1

    .line 71
    iget-object v0, p0, Lcom/facebook/react/views/progressbar/ProgressBarContainerView;->mProgressBar:Landroid/widget/ProgressBar;

    const/4 v1, 0x0

    invoke-virtual {v0, v1}, Landroid/widget/ProgressBar;->setVisibility(I)V

    .line 75
    :goto_0
    return-void

    .line 73
    :cond_1
    iget-object v0, p0, Lcom/facebook/react/views/progressbar/ProgressBarContainerView;->mProgressBar:Landroid/widget/ProgressBar;

    const/16 v1, 0x8

    invoke-virtual {v0, v1}, Landroid/widget/ProgressBar;->setVisibility(I)V

    goto :goto_0
.end method

.method public setAnimating(Z)V
    .locals 0
    .param p1, "animating"    # Z

    .prologue
    .line 59
    iput-boolean p1, p0, Lcom/facebook/react/views/progressbar/ProgressBarContainerView;->mAnimating:Z

    .line 60
    return-void
.end method

.method public setColor(Ljava/lang/Integer;)V
    .locals 0
    .param p1, "color"    # Ljava/lang/Integer;
        .annotation runtime Ljavax/annotation/Nullable;
        .end annotation
    .end param

    .prologue
    .line 47
    iput-object p1, p0, Lcom/facebook/react/views/progressbar/ProgressBarContainerView;->mColor:Ljava/lang/Integer;

    .line 48
    return-void
.end method

.method public setIndeterminate(Z)V
    .locals 0
    .param p1, "indeterminate"    # Z

    .prologue
    .line 51
    iput-boolean p1, p0, Lcom/facebook/react/views/progressbar/ProgressBarContainerView;->mIndeterminate:Z

    .line 52
    return-void
.end method

.method public setProgress(D)V
    .locals 1
    .param p1, "progress"    # D

    .prologue
    .line 55
    iput-wide p1, p0, Lcom/facebook/react/views/progressbar/ProgressBarContainerView;->mProgress:D

    .line 56
    return-void
.end method

.method public setStyle(Ljava/lang/String;)V
    .locals 4
    .param p1, "styleName"    # Ljava/lang/String;
        .annotation runtime Ljavax/annotation/Nullable;
        .end annotation
    .end param

    .prologue
    const/4 v3, -0x1

    .line 35
    invoke-static {p1}, Lcom/facebook/react/views/progressbar/ReactProgressBarViewManager;->getStyleFromString(Ljava/lang/String;)I

    move-result v0

    .line 36
    .local v0, "style":I
    invoke-virtual {p0}, Lcom/facebook/react/views/progressbar/ProgressBarContainerView;->getContext()Landroid/content/Context;

    move-result-object v1

    invoke-static {v1, v0}, Lcom/facebook/react/views/progressbar/ReactProgressBarViewManager;->createProgressBar(Landroid/content/Context;I)Landroid/widget/ProgressBar;

    move-result-object v1

    iput-object v1, p0, Lcom/facebook/react/views/progressbar/ProgressBarContainerView;->mProgressBar:Landroid/widget/ProgressBar;

    .line 37
    iget-object v1, p0, Lcom/facebook/react/views/progressbar/ProgressBarContainerView;->mProgressBar:Landroid/widget/ProgressBar;

    const/16 v2, 0x3e8

    invoke-virtual {v1, v2}, Landroid/widget/ProgressBar;->setMax(I)V

    .line 38
    invoke-virtual {p0}, Lcom/facebook/react/views/progressbar/ProgressBarContainerView;->removeAllViews()V

    .line 39
    iget-object v1, p0, Lcom/facebook/react/views/progressbar/ProgressBarContainerView;->mProgressBar:Landroid/widget/ProgressBar;

    new-instance v2, Landroid/view/ViewGroup$LayoutParams;

    invoke-direct {v2, v3, v3}, Landroid/view/ViewGroup$LayoutParams;-><init>(II)V

    invoke-virtual {p0, v1, v2}, Lcom/facebook/react/views/progressbar/ProgressBarContainerView;->addView(Landroid/view/View;Landroid/view/ViewGroup$LayoutParams;)V

    .line 44
    return-void
.end method

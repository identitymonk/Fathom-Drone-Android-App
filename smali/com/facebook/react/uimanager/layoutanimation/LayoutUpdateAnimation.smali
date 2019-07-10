.class Lcom/facebook/react/uimanager/layoutanimation/LayoutUpdateAnimation;
.super Lcom/facebook/react/uimanager/layoutanimation/AbstractLayoutAnimation;
.source "LayoutUpdateAnimation.java"


# static fields
.field private static final USE_TRANSLATE_ANIMATION:Z


# direct methods
.method constructor <init>()V
    .locals 0

    .prologue
    .line 15
    invoke-direct {p0}, Lcom/facebook/react/uimanager/layoutanimation/AbstractLayoutAnimation;-><init>()V

    return-void
.end method


# virtual methods
.method createAnimationImpl(Landroid/view/View;IIII)Landroid/view/animation/Animation;
    .locals 8
    .param p1, "view"    # Landroid/view/View;
    .param p2, "x"    # I
    .param p3, "y"    # I
    .param p4, "width"    # I
    .param p5, "height"    # I
    .annotation runtime Ljavax/annotation/Nullable;
    .end annotation

    .prologue
    const/4 v1, 0x1

    const/4 v0, 0x0

    .line 28
    invoke-virtual {p1}, Landroid/view/View;->getX()F

    move-result v2

    int-to-float v3, p2

    cmpl-float v2, v2, v3

    if-nez v2, :cond_0

    invoke-virtual {p1}, Landroid/view/View;->getY()F

    move-result v2

    int-to-float v3, p3

    cmpl-float v2, v2, v3

    if-eqz v2, :cond_2

    :cond_0
    move v6, v1

    .line 29
    .local v6, "animateLocation":Z
    :goto_0
    invoke-virtual {p1}, Landroid/view/View;->getWidth()I

    move-result v2

    if-ne v2, p4, :cond_1

    invoke-virtual {p1}, Landroid/view/View;->getHeight()I

    move-result v2

    if-eq v2, p5, :cond_3

    :cond_1
    move v7, v1

    .line 30
    .local v7, "animateSize":Z
    :goto_1
    if-nez v6, :cond_4

    if-nez v7, :cond_4

    .line 31
    const/4 v0, 0x0

    .line 39
    :goto_2
    return-object v0

    .end local v6    # "animateLocation":Z
    .end local v7    # "animateSize":Z
    :cond_2
    move v6, v0

    .line 28
    goto :goto_0

    .restart local v6    # "animateLocation":Z
    :cond_3
    move v7, v0

    .line 29
    goto :goto_1

    .line 32
    .restart local v7    # "animateSize":Z
    :cond_4
    if-eqz v6, :cond_5

    if-nez v7, :cond_5

    .line 39
    :cond_5
    new-instance v0, Lcom/facebook/react/uimanager/layoutanimation/PositionAndSizeAnimation;

    move-object v1, p1

    move v2, p2

    move v3, p3

    move v4, p4

    move v5, p5

    invoke-direct/range {v0 .. v5}, Lcom/facebook/react/uimanager/layoutanimation/PositionAndSizeAnimation;-><init>(Landroid/view/View;IIII)V

    goto :goto_2
.end method

.method isValid()Z
    .locals 1

    .prologue
    .line 23
    iget v0, p0, Lcom/facebook/react/uimanager/layoutanimation/LayoutUpdateAnimation;->mDurationMs:I

    if-lez v0, :cond_0

    const/4 v0, 0x1

    :goto_0
    return v0

    :cond_0
    const/4 v0, 0x0

    goto :goto_0
.end method

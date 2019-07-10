.class public Lcom/facebook/react/animation/ScaleXYAnimationPairPropertyUpdater;
.super Lcom/facebook/react/animation/AbstractFloatPairPropertyUpdater;
.source "ScaleXYAnimationPairPropertyUpdater.java"


# direct methods
.method public constructor <init>(FF)V
    .locals 0
    .param p1, "toFirst"    # F
    .param p2, "toSecond"    # F

    .prologue
    .line 20
    invoke-direct {p0, p1, p2}, Lcom/facebook/react/animation/AbstractFloatPairPropertyUpdater;-><init>(FF)V

    .line 21
    return-void
.end method

.method public constructor <init>(FFFF)V
    .locals 0
    .param p1, "fromFirst"    # F
    .param p2, "fromSecond"    # F
    .param p3, "toFirst"    # F
    .param p4, "toSecond"    # F

    .prologue
    .line 28
    invoke-direct {p0, p1, p2, p3, p4}, Lcom/facebook/react/animation/AbstractFloatPairPropertyUpdater;-><init>(FFFF)V

    .line 29
    return-void
.end method


# virtual methods
.method protected getProperty(Landroid/view/View;[F)V
    .locals 2
    .param p1, "view"    # Landroid/view/View;
    .param p2, "returnValues"    # [F

    .prologue
    .line 33
    const/4 v0, 0x0

    invoke-virtual {p1}, Landroid/view/View;->getScaleX()F

    move-result v1

    aput v1, p2, v0

    .line 34
    const/4 v0, 0x1

    invoke-virtual {p1}, Landroid/view/View;->getScaleY()F

    move-result v1

    aput v1, p2, v0

    .line 35
    return-void
.end method

.method protected setProperty(Landroid/view/View;[F)V
    .locals 1
    .param p1, "view"    # Landroid/view/View;
    .param p2, "propertyValues"    # [F

    .prologue
    .line 39
    const/4 v0, 0x0

    aget v0, p2, v0

    invoke-virtual {p1, v0}, Landroid/view/View;->setScaleX(F)V

    .line 40
    const/4 v0, 0x1

    aget v0, p2, v0

    invoke-virtual {p1, v0}, Landroid/view/View;->setScaleY(F)V

    .line 41
    return-void
.end method

.class public Lcom/facebook/react/animation/ScaleXAnimationPropertyUpdater;
.super Lcom/facebook/react/animation/AbstractSingleFloatProperyUpdater;
.source "ScaleXAnimationPropertyUpdater.java"


# direct methods
.method public constructor <init>(F)V
    .locals 0
    .param p1, "toValue"    # F

    .prologue
    .line 20
    invoke-direct {p0, p1}, Lcom/facebook/react/animation/AbstractSingleFloatProperyUpdater;-><init>(F)V

    .line 21
    return-void
.end method

.method public constructor <init>(FF)V
    .locals 0
    .param p1, "fromValue"    # F
    .param p2, "toValue"    # F

    .prologue
    .line 24
    invoke-direct {p0, p1, p2}, Lcom/facebook/react/animation/AbstractSingleFloatProperyUpdater;-><init>(FF)V

    .line 25
    return-void
.end method


# virtual methods
.method protected getProperty(Landroid/view/View;)F
    .locals 1
    .param p1, "view"    # Landroid/view/View;

    .prologue
    .line 29
    invoke-virtual {p1}, Landroid/view/View;->getScaleX()F

    move-result v0

    return v0
.end method

.method protected setProperty(Landroid/view/View;F)V
    .locals 0
    .param p1, "view"    # Landroid/view/View;
    .param p2, "propertyValue"    # F

    .prologue
    .line 34
    invoke-virtual {p1, p2}, Landroid/view/View;->setScaleX(F)V

    .line 35
    return-void
.end method

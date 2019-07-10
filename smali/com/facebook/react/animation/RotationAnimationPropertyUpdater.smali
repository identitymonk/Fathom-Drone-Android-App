.class public Lcom/facebook/react/animation/RotationAnimationPropertyUpdater;
.super Lcom/facebook/react/animation/AbstractSingleFloatProperyUpdater;
.source "RotationAnimationPropertyUpdater.java"


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


# virtual methods
.method protected getProperty(Landroid/view/View;)F
    .locals 1
    .param p1, "view"    # Landroid/view/View;

    .prologue
    .line 25
    invoke-virtual {p1}, Landroid/view/View;->getRotation()F

    move-result v0

    return v0
.end method

.method protected setProperty(Landroid/view/View;F)V
    .locals 2
    .param p1, "view"    # Landroid/view/View;
    .param p2, "propertyValue"    # F

    .prologue
    .line 30
    float-to-double v0, p2

    invoke-static {v0, v1}, Ljava/lang/Math;->toDegrees(D)D

    move-result-wide v0

    double-to-float v0, v0

    invoke-virtual {p1, v0}, Landroid/view/View;->setRotation(F)V

    .line 31
    return-void
.end method

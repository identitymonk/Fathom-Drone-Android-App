.class public abstract Lcom/facebook/react/animation/AbstractSingleFloatProperyUpdater;
.super Ljava/lang/Object;
.source "AbstractSingleFloatProperyUpdater.java"

# interfaces
.implements Lcom/facebook/react/animation/AnimationPropertyUpdater;


# instance fields
.field private mFromSource:Z

.field private mFromValue:F

.field private mToValue:F


# direct methods
.method protected constructor <init>(F)V
    .locals 1
    .param p1, "toValue"    # F

    .prologue
    .line 24
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 25
    iput p1, p0, Lcom/facebook/react/animation/AbstractSingleFloatProperyUpdater;->mToValue:F

    .line 26
    const/4 v0, 0x1

    iput-boolean v0, p0, Lcom/facebook/react/animation/AbstractSingleFloatProperyUpdater;->mFromSource:Z

    .line 27
    return-void
.end method

.method protected constructor <init>(FF)V
    .locals 1
    .param p1, "fromValue"    # F
    .param p2, "toValue"    # F

    .prologue
    .line 30
    invoke-direct {p0, p2}, Lcom/facebook/react/animation/AbstractSingleFloatProperyUpdater;-><init>(F)V

    .line 31
    iput p1, p0, Lcom/facebook/react/animation/AbstractSingleFloatProperyUpdater;->mFromValue:F

    .line 32
    const/4 v0, 0x0

    iput-boolean v0, p0, Lcom/facebook/react/animation/AbstractSingleFloatProperyUpdater;->mFromSource:Z

    .line 33
    return-void
.end method


# virtual methods
.method protected abstract getProperty(Landroid/view/View;)F
.end method

.method public onFinish(Landroid/view/View;)V
    .locals 1
    .param p1, "view"    # Landroid/view/View;

    .prologue
    .line 52
    iget v0, p0, Lcom/facebook/react/animation/AbstractSingleFloatProperyUpdater;->mToValue:F

    invoke-virtual {p0, p1, v0}, Lcom/facebook/react/animation/AbstractSingleFloatProperyUpdater;->setProperty(Landroid/view/View;F)V

    .line 53
    return-void
.end method

.method public final onUpdate(Landroid/view/View;F)V
    .locals 3
    .param p1, "view"    # Landroid/view/View;
    .param p2, "progress"    # F

    .prologue
    .line 47
    iget v0, p0, Lcom/facebook/react/animation/AbstractSingleFloatProperyUpdater;->mFromValue:F

    iget v1, p0, Lcom/facebook/react/animation/AbstractSingleFloatProperyUpdater;->mToValue:F

    iget v2, p0, Lcom/facebook/react/animation/AbstractSingleFloatProperyUpdater;->mFromValue:F

    sub-float/2addr v1, v2

    mul-float/2addr v1, p2

    add-float/2addr v0, v1

    invoke-virtual {p0, p1, v0}, Lcom/facebook/react/animation/AbstractSingleFloatProperyUpdater;->setProperty(Landroid/view/View;F)V

    .line 48
    return-void
.end method

.method public final prepare(Landroid/view/View;)V
    .locals 1
    .param p1, "view"    # Landroid/view/View;

    .prologue
    .line 40
    iget-boolean v0, p0, Lcom/facebook/react/animation/AbstractSingleFloatProperyUpdater;->mFromSource:Z

    if-eqz v0, :cond_0

    .line 41
    invoke-virtual {p0, p1}, Lcom/facebook/react/animation/AbstractSingleFloatProperyUpdater;->getProperty(Landroid/view/View;)F

    move-result v0

    iput v0, p0, Lcom/facebook/react/animation/AbstractSingleFloatProperyUpdater;->mFromValue:F

    .line 43
    :cond_0
    return-void
.end method

.method protected abstract setProperty(Landroid/view/View;F)V
.end method

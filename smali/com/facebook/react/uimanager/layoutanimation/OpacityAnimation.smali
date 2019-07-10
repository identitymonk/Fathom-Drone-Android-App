.class Lcom/facebook/react/uimanager/layoutanimation/OpacityAnimation;
.super Landroid/view/animation/Animation;
.source "OpacityAnimation.java"


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lcom/facebook/react/uimanager/layoutanimation/OpacityAnimation$OpacityAnimationListener;
    }
.end annotation


# instance fields
.field private final mDeltaOpacity:F

.field private final mStartOpacity:F

.field private final mView:Landroid/view/View;


# direct methods
.method public constructor <init>(Landroid/view/View;FF)V
    .locals 1
    .param p1, "view"    # Landroid/view/View;
    .param p2, "startOpacity"    # F
    .param p3, "endOpacity"    # F

    .prologue
    .line 49
    invoke-direct {p0}, Landroid/view/animation/Animation;-><init>()V

    .line 50
    iput-object p1, p0, Lcom/facebook/react/uimanager/layoutanimation/OpacityAnimation;->mView:Landroid/view/View;

    .line 51
    iput p2, p0, Lcom/facebook/react/uimanager/layoutanimation/OpacityAnimation;->mStartOpacity:F

    .line 52
    sub-float v0, p3, p2

    iput v0, p0, Lcom/facebook/react/uimanager/layoutanimation/OpacityAnimation;->mDeltaOpacity:F

    .line 54
    new-instance v0, Lcom/facebook/react/uimanager/layoutanimation/OpacityAnimation$OpacityAnimationListener;

    invoke-direct {v0, p1}, Lcom/facebook/react/uimanager/layoutanimation/OpacityAnimation$OpacityAnimationListener;-><init>(Landroid/view/View;)V

    invoke-virtual {p0, v0}, Lcom/facebook/react/uimanager/layoutanimation/OpacityAnimation;->setAnimationListener(Landroid/view/animation/Animation$AnimationListener;)V

    .line 55
    return-void
.end method


# virtual methods
.method protected applyTransformation(FLandroid/view/animation/Transformation;)V
    .locals 3
    .param p1, "interpolatedTime"    # F
    .param p2, "t"    # Landroid/view/animation/Transformation;

    .prologue
    .line 59
    iget-object v0, p0, Lcom/facebook/react/uimanager/layoutanimation/OpacityAnimation;->mView:Landroid/view/View;

    iget v1, p0, Lcom/facebook/react/uimanager/layoutanimation/OpacityAnimation;->mStartOpacity:F

    iget v2, p0, Lcom/facebook/react/uimanager/layoutanimation/OpacityAnimation;->mDeltaOpacity:F

    mul-float/2addr v2, p1

    add-float/2addr v1, v2

    invoke-virtual {v0, v1}, Landroid/view/View;->setAlpha(F)V

    .line 60
    return-void
.end method

.method public willChangeBounds()Z
    .locals 1

    .prologue
    .line 64
    const/4 v0, 0x0

    return v0
.end method

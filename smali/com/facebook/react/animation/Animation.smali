.class public abstract Lcom/facebook/react/animation/Animation;
.super Ljava/lang/Object;
.source "Animation.java"


# instance fields
.field private mAnimatedView:Landroid/view/View;
    .annotation runtime Ljavax/annotation/Nullable;
    .end annotation
.end field

.field private final mAnimationID:I

.field private mAnimationListener:Lcom/facebook/react/animation/AnimationListener;
    .annotation runtime Ljavax/annotation/Nullable;
    .end annotation
.end field

.field private volatile mCancelled:Z

.field private volatile mIsFinished:Z

.field private final mPropertyUpdater:Lcom/facebook/react/animation/AnimationPropertyUpdater;


# direct methods
.method public constructor <init>(ILcom/facebook/react/animation/AnimationPropertyUpdater;)V
    .locals 1
    .param p1, "animationID"    # I
    .param p2, "propertyUpdater"    # Lcom/facebook/react/animation/AnimationPropertyUpdater;

    .prologue
    const/4 v0, 0x0

    .line 37
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 32
    iput-boolean v0, p0, Lcom/facebook/react/animation/Animation;->mCancelled:Z

    .line 33
    iput-boolean v0, p0, Lcom/facebook/react/animation/Animation;->mIsFinished:Z

    .line 38
    iput p1, p0, Lcom/facebook/react/animation/Animation;->mAnimationID:I

    .line 39
    iput-object p2, p0, Lcom/facebook/react/animation/Animation;->mPropertyUpdater:Lcom/facebook/react/animation/AnimationPropertyUpdater;

    .line 40
    return-void
.end method


# virtual methods
.method public final cancel()V
    .locals 1

    .prologue
    .line 93
    iget-boolean v0, p0, Lcom/facebook/react/animation/Animation;->mIsFinished:Z

    if-nez v0, :cond_0

    iget-boolean v0, p0, Lcom/facebook/react/animation/Animation;->mCancelled:Z

    if-eqz v0, :cond_1

    .line 102
    :cond_0
    :goto_0
    return-void

    .line 98
    :cond_1
    const/4 v0, 0x1

    iput-boolean v0, p0, Lcom/facebook/react/animation/Animation;->mCancelled:Z

    .line 99
    iget-object v0, p0, Lcom/facebook/react/animation/Animation;->mAnimationListener:Lcom/facebook/react/animation/AnimationListener;

    if-eqz v0, :cond_0

    .line 100
    iget-object v0, p0, Lcom/facebook/react/animation/Animation;->mAnimationListener:Lcom/facebook/react/animation/AnimationListener;

    invoke-interface {v0}, Lcom/facebook/react/animation/AnimationListener;->onCancel()V

    goto :goto_0
.end method

.method protected final finish()V
    .locals 3

    .prologue
    const/4 v1, 0x1

    .line 75
    iget-boolean v0, p0, Lcom/facebook/react/animation/Animation;->mIsFinished:Z

    if-nez v0, :cond_2

    move v0, v1

    :goto_0
    const-string v2, "Animation must not already be finished!"

    invoke-static {v0, v2}, Lcom/facebook/infer/annotation/Assertions;->assertCondition(ZLjava/lang/String;)V

    .line 76
    iput-boolean v1, p0, Lcom/facebook/react/animation/Animation;->mIsFinished:Z

    .line 77
    iget-boolean v0, p0, Lcom/facebook/react/animation/Animation;->mCancelled:Z

    if-nez v0, :cond_1

    .line 78
    iget-object v0, p0, Lcom/facebook/react/animation/Animation;->mAnimatedView:Landroid/view/View;

    if-eqz v0, :cond_0

    .line 79
    iget-object v0, p0, Lcom/facebook/react/animation/Animation;->mPropertyUpdater:Lcom/facebook/react/animation/AnimationPropertyUpdater;

    iget-object v1, p0, Lcom/facebook/react/animation/Animation;->mAnimatedView:Landroid/view/View;

    invoke-interface {v0, v1}, Lcom/facebook/react/animation/AnimationPropertyUpdater;->onFinish(Landroid/view/View;)V

    .line 81
    :cond_0
    iget-object v0, p0, Lcom/facebook/react/animation/Animation;->mAnimationListener:Lcom/facebook/react/animation/AnimationListener;

    if-eqz v0, :cond_1

    .line 82
    iget-object v0, p0, Lcom/facebook/react/animation/Animation;->mAnimationListener:Lcom/facebook/react/animation/AnimationListener;

    invoke-interface {v0}, Lcom/facebook/react/animation/AnimationListener;->onFinished()V

    .line 85
    :cond_1
    return-void

    .line 75
    :cond_2
    const/4 v0, 0x0

    goto :goto_0
.end method

.method public getAnimationID()I
    .locals 1

    .prologue
    .line 105
    iget v0, p0, Lcom/facebook/react/animation/Animation;->mAnimationID:I

    return v0
.end method

.method protected final onUpdate(F)Z
    .locals 4
    .param p1, "value"    # F

    .prologue
    const/4 v1, 0x1

    const/4 v2, 0x0

    .line 63
    iget-boolean v0, p0, Lcom/facebook/react/animation/Animation;->mIsFinished:Z

    if-nez v0, :cond_1

    move v0, v1

    :goto_0
    const-string v3, "Animation must not already be finished!"

    invoke-static {v0, v3}, Lcom/facebook/infer/annotation/Assertions;->assertCondition(ZLjava/lang/String;)V

    .line 64
    iget-boolean v0, p0, Lcom/facebook/react/animation/Animation;->mCancelled:Z

    if-nez v0, :cond_0

    .line 65
    iget-object v3, p0, Lcom/facebook/react/animation/Animation;->mPropertyUpdater:Lcom/facebook/react/animation/AnimationPropertyUpdater;

    iget-object v0, p0, Lcom/facebook/react/animation/Animation;->mAnimatedView:Landroid/view/View;

    invoke-static {v0}, Lcom/facebook/infer/annotation/Assertions;->assertNotNull(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Landroid/view/View;

    invoke-interface {v3, v0, p1}, Lcom/facebook/react/animation/AnimationPropertyUpdater;->onUpdate(Landroid/view/View;F)V

    .line 67
    :cond_0
    iget-boolean v0, p0, Lcom/facebook/react/animation/Animation;->mCancelled:Z

    if-nez v0, :cond_2

    :goto_1
    return v1

    :cond_1
    move v0, v2

    .line 63
    goto :goto_0

    :cond_2
    move v1, v2

    .line 67
    goto :goto_1
.end method

.method public abstract run()V
.end method

.method public setAnimationListener(Lcom/facebook/react/animation/AnimationListener;)V
    .locals 0
    .param p1, "animationListener"    # Lcom/facebook/react/animation/AnimationListener;

    .prologue
    .line 43
    iput-object p1, p0, Lcom/facebook/react/animation/Animation;->mAnimationListener:Lcom/facebook/react/animation/AnimationListener;

    .line 44
    return-void
.end method

.method public final start(Landroid/view/View;)V
    .locals 1
    .param p1, "view"    # Landroid/view/View;

    .prologue
    .line 47
    iput-object p1, p0, Lcom/facebook/react/animation/Animation;->mAnimatedView:Landroid/view/View;

    .line 48
    iget-object v0, p0, Lcom/facebook/react/animation/Animation;->mPropertyUpdater:Lcom/facebook/react/animation/AnimationPropertyUpdater;

    invoke-interface {v0, p1}, Lcom/facebook/react/animation/AnimationPropertyUpdater;->prepare(Landroid/view/View;)V

    .line 49
    invoke-virtual {p0}, Lcom/facebook/react/animation/Animation;->run()V

    .line 50
    return-void
.end method

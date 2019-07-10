.class public Lcom/facebook/drawee/view/DraweeTransition;
.super Landroid/transition/Transition;
.source "DraweeTransition.java"


# annotations
.annotation build Landroid/annotation/TargetApi;
    value = 0x13
.end annotation


# static fields
.field private static final PROPNAME_BOUNDS:Ljava/lang/String; = "draweeTransition:bounds"


# instance fields
.field private final mFromScale:Lcom/facebook/drawee/drawable/ScalingUtils$ScaleType;

.field private final mToScale:Lcom/facebook/drawee/drawable/ScalingUtils$ScaleType;


# direct methods
.method public constructor <init>(Lcom/facebook/drawee/drawable/ScalingUtils$ScaleType;Lcom/facebook/drawee/drawable/ScalingUtils$ScaleType;)V
    .locals 0
    .param p1, "fromScale"    # Lcom/facebook/drawee/drawable/ScalingUtils$ScaleType;
    .param p2, "toScale"    # Lcom/facebook/drawee/drawable/ScalingUtils$ScaleType;

    .prologue
    .line 49
    invoke-direct {p0}, Landroid/transition/Transition;-><init>()V

    .line 50
    iput-object p1, p0, Lcom/facebook/drawee/view/DraweeTransition;->mFromScale:Lcom/facebook/drawee/drawable/ScalingUtils$ScaleType;

    .line 51
    iput-object p2, p0, Lcom/facebook/drawee/view/DraweeTransition;->mToScale:Lcom/facebook/drawee/drawable/ScalingUtils$ScaleType;

    .line 52
    return-void
.end method

.method static synthetic access$000(Lcom/facebook/drawee/view/DraweeTransition;)Lcom/facebook/drawee/drawable/ScalingUtils$ScaleType;
    .locals 1
    .param p0, "x0"    # Lcom/facebook/drawee/view/DraweeTransition;

    .prologue
    .line 33
    iget-object v0, p0, Lcom/facebook/drawee/view/DraweeTransition;->mToScale:Lcom/facebook/drawee/drawable/ScalingUtils$ScaleType;

    return-object v0
.end method

.method private captureValues(Landroid/transition/TransitionValues;)V
    .locals 6
    .param p1, "transitionValues"    # Landroid/transition/TransitionValues;

    .prologue
    const/4 v5, 0x0

    .line 104
    iget-object v0, p1, Landroid/transition/TransitionValues;->view:Landroid/view/View;

    instance-of v0, v0, Lcom/facebook/drawee/view/GenericDraweeView;

    if-eqz v0, :cond_0

    .line 105
    iget-object v0, p1, Landroid/transition/TransitionValues;->values:Ljava/util/Map;

    const-string v1, "draweeTransition:bounds"

    new-instance v2, Landroid/graphics/Rect;

    iget-object v3, p1, Landroid/transition/TransitionValues;->view:Landroid/view/View;

    .line 107
    invoke-virtual {v3}, Landroid/view/View;->getWidth()I

    move-result v3

    iget-object v4, p1, Landroid/transition/TransitionValues;->view:Landroid/view/View;

    invoke-virtual {v4}, Landroid/view/View;->getHeight()I

    move-result v4

    invoke-direct {v2, v5, v5, v3, v4}, Landroid/graphics/Rect;-><init>(IIII)V

    .line 105
    invoke-interface {v0, v1, v2}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 109
    :cond_0
    return-void
.end method

.method public static createTransitionSet(Lcom/facebook/drawee/drawable/ScalingUtils$ScaleType;Lcom/facebook/drawee/drawable/ScalingUtils$ScaleType;)Landroid/transition/TransitionSet;
    .locals 2
    .param p0, "fromScale"    # Lcom/facebook/drawee/drawable/ScalingUtils$ScaleType;
    .param p1, "toScale"    # Lcom/facebook/drawee/drawable/ScalingUtils$ScaleType;

    .prologue
    .line 43
    new-instance v0, Landroid/transition/TransitionSet;

    invoke-direct {v0}, Landroid/transition/TransitionSet;-><init>()V

    .line 44
    .local v0, "transitionSet":Landroid/transition/TransitionSet;
    new-instance v1, Landroid/transition/ChangeBounds;

    invoke-direct {v1}, Landroid/transition/ChangeBounds;-><init>()V

    invoke-virtual {v0, v1}, Landroid/transition/TransitionSet;->addTransition(Landroid/transition/Transition;)Landroid/transition/TransitionSet;

    .line 45
    new-instance v1, Lcom/facebook/drawee/view/DraweeTransition;

    invoke-direct {v1, p0, p1}, Lcom/facebook/drawee/view/DraweeTransition;-><init>(Lcom/facebook/drawee/drawable/ScalingUtils$ScaleType;Lcom/facebook/drawee/drawable/ScalingUtils$ScaleType;)V

    invoke-virtual {v0, v1}, Landroid/transition/TransitionSet;->addTransition(Landroid/transition/Transition;)Landroid/transition/TransitionSet;

    .line 46
    return-object v0
.end method


# virtual methods
.method public captureEndValues(Landroid/transition/TransitionValues;)V
    .locals 0
    .param p1, "transitionValues"    # Landroid/transition/TransitionValues;

    .prologue
    .line 61
    invoke-direct {p0, p1}, Lcom/facebook/drawee/view/DraweeTransition;->captureValues(Landroid/transition/TransitionValues;)V

    .line 62
    return-void
.end method

.method public captureStartValues(Landroid/transition/TransitionValues;)V
    .locals 0
    .param p1, "transitionValues"    # Landroid/transition/TransitionValues;

    .prologue
    .line 56
    invoke-direct {p0, p1}, Lcom/facebook/drawee/view/DraweeTransition;->captureValues(Landroid/transition/TransitionValues;)V

    .line 57
    return-void
.end method

.method public createAnimator(Landroid/view/ViewGroup;Landroid/transition/TransitionValues;Landroid/transition/TransitionValues;)Landroid/animation/Animator;
    .locals 7
    .param p1, "sceneRoot"    # Landroid/view/ViewGroup;
    .param p2, "startValues"    # Landroid/transition/TransitionValues;
    .param p3, "endValues"    # Landroid/transition/TransitionValues;

    .prologue
    const/4 v0, 0x0

    .line 69
    if-eqz p2, :cond_0

    if-nez p3, :cond_1

    .line 100
    :cond_0
    :goto_0
    return-object v0

    .line 72
    :cond_1
    iget-object v5, p2, Landroid/transition/TransitionValues;->values:Ljava/util/Map;

    const-string v6, "draweeTransition:bounds"

    invoke-interface {v5, v6}, Ljava/util/Map;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v4

    check-cast v4, Landroid/graphics/Rect;

    .line 73
    .local v4, "startBounds":Landroid/graphics/Rect;
    iget-object v5, p3, Landroid/transition/TransitionValues;->values:Ljava/util/Map;

    const-string v6, "draweeTransition:bounds"

    invoke-interface {v5, v6}, Ljava/util/Map;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v2

    check-cast v2, Landroid/graphics/Rect;

    .line 74
    .local v2, "endBounds":Landroid/graphics/Rect;
    if-eqz v4, :cond_0

    if-eqz v2, :cond_0

    .line 77
    iget-object v5, p0, Lcom/facebook/drawee/view/DraweeTransition;->mFromScale:Lcom/facebook/drawee/drawable/ScalingUtils$ScaleType;

    iget-object v6, p0, Lcom/facebook/drawee/view/DraweeTransition;->mToScale:Lcom/facebook/drawee/drawable/ScalingUtils$ScaleType;

    if-eq v5, v6, :cond_0

    .line 80
    iget-object v1, p2, Landroid/transition/TransitionValues;->view:Landroid/view/View;

    check-cast v1, Lcom/facebook/drawee/view/GenericDraweeView;

    .line 81
    .local v1, "draweeView":Lcom/facebook/drawee/view/GenericDraweeView;
    new-instance v3, Lcom/facebook/drawee/drawable/ScalingUtils$InterpolatingScaleType;

    iget-object v5, p0, Lcom/facebook/drawee/view/DraweeTransition;->mFromScale:Lcom/facebook/drawee/drawable/ScalingUtils$ScaleType;

    iget-object v6, p0, Lcom/facebook/drawee/view/DraweeTransition;->mToScale:Lcom/facebook/drawee/drawable/ScalingUtils$ScaleType;

    invoke-direct {v3, v5, v6, v4, v2}, Lcom/facebook/drawee/drawable/ScalingUtils$InterpolatingScaleType;-><init>(Lcom/facebook/drawee/drawable/ScalingUtils$ScaleType;Lcom/facebook/drawee/drawable/ScalingUtils$ScaleType;Landroid/graphics/Rect;Landroid/graphics/Rect;)V

    .line 83
    .local v3, "scaleType":Lcom/facebook/drawee/drawable/ScalingUtils$InterpolatingScaleType;
    invoke-virtual {v1}, Lcom/facebook/drawee/view/GenericDraweeView;->getHierarchy()Lcom/facebook/drawee/interfaces/DraweeHierarchy;

    move-result-object v5

    check-cast v5, Lcom/facebook/drawee/generic/GenericDraweeHierarchy;

    invoke-virtual {v5, v3}, Lcom/facebook/drawee/generic/GenericDraweeHierarchy;->setActualImageScaleType(Lcom/facebook/drawee/drawable/ScalingUtils$ScaleType;)V

    .line 85
    const/4 v5, 0x2

    new-array v5, v5, [F

    fill-array-data v5, :array_0

    invoke-static {v5}, Landroid/animation/ValueAnimator;->ofFloat([F)Landroid/animation/ValueAnimator;

    move-result-object v0

    .line 86
    .local v0, "animator":Landroid/animation/ValueAnimator;
    new-instance v5, Lcom/facebook/drawee/view/DraweeTransition$1;

    invoke-direct {v5, p0, v3}, Lcom/facebook/drawee/view/DraweeTransition$1;-><init>(Lcom/facebook/drawee/view/DraweeTransition;Lcom/facebook/drawee/drawable/ScalingUtils$InterpolatingScaleType;)V

    invoke-virtual {v0, v5}, Landroid/animation/ValueAnimator;->addUpdateListener(Landroid/animation/ValueAnimator$AnimatorUpdateListener;)V

    .line 93
    new-instance v5, Lcom/facebook/drawee/view/DraweeTransition$2;

    invoke-direct {v5, p0, v1}, Lcom/facebook/drawee/view/DraweeTransition$2;-><init>(Lcom/facebook/drawee/view/DraweeTransition;Lcom/facebook/drawee/view/GenericDraweeView;)V

    invoke-virtual {v0, v5}, Landroid/animation/ValueAnimator;->addListener(Landroid/animation/Animator$AnimatorListener;)V

    goto :goto_0

    .line 85
    nop

    :array_0
    .array-data 4
        0x0
        0x3f800000    # 1.0f
    .end array-data
.end method

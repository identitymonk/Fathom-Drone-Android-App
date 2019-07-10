.class public Lcom/brynk/fathom/helpers/CoordinateHelper;
.super Ljava/lang/Object;
.source "CoordinateHelper.java"


# instance fields
.field private EXTERNAL_NEUTRAL:Ljava/lang/Float;

.field private context:Landroid/content/Context;

.field private pitch_max:Ljava/lang/Float;

.field private pitch_min:Ljava/lang/Float;

.field private throttle_max:Ljava/lang/Float;

.field private throttle_min:Ljava/lang/Float;


# direct methods
.method public constructor <init>(Landroid/content/Context;)V
    .locals 1
    .param p1, "c"    # Landroid/content/Context;

    .prologue
    .line 24
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 23
    const v0, 0x3b808100

    invoke-static {v0}, Ljava/lang/Float;->valueOf(F)Ljava/lang/Float;

    move-result-object v0

    iput-object v0, p0, Lcom/brynk/fathom/helpers/CoordinateHelper;->EXTERNAL_NEUTRAL:Ljava/lang/Float;

    .line 26
    iput-object p1, p0, Lcom/brynk/fathom/helpers/CoordinateHelper;->context:Landroid/content/Context;

    .line 27
    invoke-direct {p0, p1}, Lcom/brynk/fathom/helpers/CoordinateHelper;->setupMaxAndMinThrottle(Landroid/content/Context;)V

    .line 32
    return-void
.end method

.method private setupMaxAndMinThrottle(Landroid/content/Context;)V
    .locals 7
    .param p1, "c"    # Landroid/content/Context;

    .prologue
    const/high16 v6, 0x40000000    # 2.0f

    .line 245
    sget-object v4, Lcom/brynk/fathom/helpers/Constants;->SERVO_MAX:Ljava/lang/Float;

    invoke-virtual {v4}, Ljava/lang/Float;->floatValue()F

    move-result v4

    sget-object v5, Lcom/brynk/fathom/helpers/Constants;->SERVO_MIN:Ljava/lang/Float;

    invoke-virtual {v5}, Ljava/lang/Float;->floatValue()F

    move-result v5

    sub-float/2addr v4, v5

    new-instance v5, Lcom/brynk/fathom/helpers/Constants;

    invoke-direct {v5}, Lcom/brynk/fathom/helpers/Constants;-><init>()V

    invoke-virtual {v5, p1}, Lcom/brynk/fathom/helpers/Constants;->getTHROTTLE_MOD_PERCENT(Landroid/content/Context;)Ljava/lang/Float;

    move-result-object v5

    invoke-virtual {v5}, Ljava/lang/Float;->floatValue()F

    move-result v5

    mul-float/2addr v4, v5

    invoke-static {v4}, Ljava/lang/Float;->valueOf(F)Ljava/lang/Float;

    move-result-object v2

    .line 246
    .local v2, "throttle_difference":Ljava/lang/Float;
    invoke-virtual {v2}, Ljava/lang/Float;->floatValue()F

    move-result v4

    div-float/2addr v4, v6

    invoke-static {v4}, Ljava/lang/Float;->valueOf(F)Ljava/lang/Float;

    move-result-object v3

    .line 247
    .local v3, "throttle_offset":Ljava/lang/Float;
    sget-object v4, Lcom/brynk/fathom/helpers/Constants;->SERVO_NEUTRAL:Ljava/lang/Float;

    invoke-virtual {v4}, Ljava/lang/Float;->floatValue()F

    move-result v4

    invoke-virtual {v3}, Ljava/lang/Float;->floatValue()F

    move-result v5

    add-float/2addr v4, v5

    invoke-static {v4}, Ljava/lang/Float;->valueOf(F)Ljava/lang/Float;

    move-result-object v4

    iput-object v4, p0, Lcom/brynk/fathom/helpers/CoordinateHelper;->throttle_max:Ljava/lang/Float;

    .line 248
    sget-object v4, Lcom/brynk/fathom/helpers/Constants;->SERVO_NEUTRAL:Ljava/lang/Float;

    invoke-virtual {v4}, Ljava/lang/Float;->floatValue()F

    move-result v4

    invoke-virtual {v3}, Ljava/lang/Float;->floatValue()F

    move-result v5

    sub-float/2addr v4, v5

    invoke-static {v4}, Ljava/lang/Float;->valueOf(F)Ljava/lang/Float;

    move-result-object v4

    iput-object v4, p0, Lcom/brynk/fathom/helpers/CoordinateHelper;->throttle_min:Ljava/lang/Float;

    .line 250
    sget-object v4, Lcom/brynk/fathom/helpers/Constants;->SERVO_MAX:Ljava/lang/Float;

    invoke-virtual {v4}, Ljava/lang/Float;->floatValue()F

    move-result v4

    sget-object v5, Lcom/brynk/fathom/helpers/Constants;->SERVO_MIN:Ljava/lang/Float;

    invoke-virtual {v5}, Ljava/lang/Float;->floatValue()F

    move-result v5

    sub-float/2addr v4, v5

    new-instance v5, Lcom/brynk/fathom/helpers/Constants;

    invoke-direct {v5}, Lcom/brynk/fathom/helpers/Constants;-><init>()V

    invoke-virtual {v5, p1}, Lcom/brynk/fathom/helpers/Constants;->getPITCH_MOD_PERCENT(Landroid/content/Context;)Ljava/lang/Float;

    move-result-object v5

    invoke-virtual {v5}, Ljava/lang/Float;->floatValue()F

    move-result v5

    mul-float/2addr v4, v5

    invoke-static {v4}, Ljava/lang/Float;->valueOf(F)Ljava/lang/Float;

    move-result-object v0

    .line 251
    .local v0, "pitch_difference":Ljava/lang/Float;
    invoke-virtual {v0}, Ljava/lang/Float;->floatValue()F

    move-result v4

    div-float/2addr v4, v6

    invoke-static {v4}, Ljava/lang/Float;->valueOf(F)Ljava/lang/Float;

    move-result-object v1

    .line 253
    .local v1, "pitch_offset":Ljava/lang/Float;
    sget-object v4, Lcom/brynk/fathom/helpers/Constants;->SERVO_NEUTRAL:Ljava/lang/Float;

    invoke-virtual {v4}, Ljava/lang/Float;->floatValue()F

    move-result v4

    invoke-virtual {v1}, Ljava/lang/Float;->floatValue()F

    move-result v5

    add-float/2addr v4, v5

    invoke-static {v4}, Ljava/lang/Float;->valueOf(F)Ljava/lang/Float;

    move-result-object v4

    iput-object v4, p0, Lcom/brynk/fathom/helpers/CoordinateHelper;->pitch_max:Ljava/lang/Float;

    .line 254
    sget-object v4, Lcom/brynk/fathom/helpers/Constants;->SERVO_NEUTRAL:Ljava/lang/Float;

    invoke-virtual {v4}, Ljava/lang/Float;->floatValue()F

    move-result v4

    invoke-virtual {v1}, Ljava/lang/Float;->floatValue()F

    move-result v5

    sub-float/2addr v4, v5

    invoke-static {v4}, Ljava/lang/Float;->valueOf(F)Ljava/lang/Float;

    move-result-object v4

    iput-object v4, p0, Lcom/brynk/fathom/helpers/CoordinateHelper;->pitch_min:Ljava/lang/Float;

    .line 256
    return-void
.end method


# virtual methods
.method public boundCoord(Landroid/view/MotionEvent;Landroid/widget/TextView;)Ljava/util/ArrayList;
    .locals 9
    .param p1, "e"    # Landroid/view/MotionEvent;
    .param p2, "tv"    # Landroid/widget/TextView;

    .prologue
    const/4 v8, 0x1

    const/4 v7, 0x0

    .line 34
    new-instance v0, Ljava/util/ArrayList;

    invoke-direct {v0}, Ljava/util/ArrayList;-><init>()V

    .line 35
    .local v0, "coords":Ljava/util/ArrayList;
    invoke-virtual {p1}, Landroid/view/MotionEvent;->getRawX()F

    move-result v5

    invoke-static {v5}, Ljava/lang/Float;->valueOf(F)Ljava/lang/Float;

    move-result-object v5

    invoke-virtual {v0, v5}, Ljava/util/ArrayList;->add(Ljava/lang/Object;)Z

    .line 36
    invoke-virtual {p1}, Landroid/view/MotionEvent;->getRawY()F

    move-result v5

    invoke-static {v5}, Ljava/lang/Float;->valueOf(F)Ljava/lang/Float;

    move-result-object v5

    invoke-virtual {v0, v5}, Ljava/util/ArrayList;->add(Ljava/lang/Object;)Z

    .line 37
    invoke-virtual {p2}, Landroid/widget/TextView;->getX()F

    move-result v5

    invoke-virtual {p2}, Landroid/widget/TextView;->getWidth()I

    move-result v6

    int-to-float v6, v6

    add-float/2addr v5, v6

    invoke-static {v5}, Ljava/lang/Float;->valueOf(F)Ljava/lang/Float;

    move-result-object v3

    .line 38
    .local v3, "tv_right":Ljava/lang/Float;
    invoke-virtual {p2}, Landroid/widget/TextView;->getX()F

    move-result v5

    invoke-static {v5}, Ljava/lang/Float;->valueOf(F)Ljava/lang/Float;

    move-result-object v2

    .line 39
    .local v2, "tv_left":Ljava/lang/Float;
    invoke-virtual {p2}, Landroid/widget/TextView;->getY()F

    move-result v5

    invoke-static {v5}, Ljava/lang/Float;->valueOf(F)Ljava/lang/Float;

    move-result-object v4

    .line 40
    .local v4, "tv_top":Ljava/lang/Float;
    invoke-virtual {p2}, Landroid/widget/TextView;->getY()F

    move-result v5

    invoke-virtual {p2}, Landroid/widget/TextView;->getHeight()I

    move-result v6

    int-to-float v6, v6

    add-float/2addr v5, v6

    invoke-static {v5}, Ljava/lang/Float;->valueOf(F)Ljava/lang/Float;

    move-result-object v1

    .line 41
    .local v1, "tv_bottom":Ljava/lang/Float;
    invoke-virtual {p1}, Landroid/view/MotionEvent;->getRawX()F

    move-result v5

    invoke-virtual {v3}, Ljava/lang/Float;->floatValue()F

    move-result v6

    cmpl-float v5, v5, v6

    if-lez v5, :cond_0

    invoke-virtual {v0, v7, v3}, Ljava/util/ArrayList;->set(ILjava/lang/Object;)Ljava/lang/Object;

    .line 42
    :cond_0
    invoke-virtual {p1}, Landroid/view/MotionEvent;->getRawX()F

    move-result v5

    invoke-virtual {v2}, Ljava/lang/Float;->floatValue()F

    move-result v6

    cmpg-float v5, v5, v6

    if-gez v5, :cond_1

    invoke-virtual {v0, v7, v2}, Ljava/util/ArrayList;->set(ILjava/lang/Object;)Ljava/lang/Object;

    .line 43
    :cond_1
    invoke-virtual {p1}, Landroid/view/MotionEvent;->getRawY()F

    move-result v5

    invoke-virtual {v4}, Ljava/lang/Float;->floatValue()F

    move-result v6

    cmpg-float v5, v5, v6

    if-gez v5, :cond_2

    invoke-virtual {v0, v8, v4}, Ljava/util/ArrayList;->set(ILjava/lang/Object;)Ljava/lang/Object;

    .line 44
    :cond_2
    invoke-virtual {p1}, Landroid/view/MotionEvent;->getRawY()F

    move-result v5

    invoke-virtual {v1}, Ljava/lang/Float;->floatValue()F

    move-result v6

    cmpl-float v5, v5, v6

    if-lez v5, :cond_3

    invoke-virtual {v0, v8, v1}, Ljava/util/ArrayList;->set(ILjava/lang/Object;)Ljava/lang/Object;

    .line 46
    :cond_3
    return-object v0
.end method

.method public boundCoordInRelativeLayout(Landroid/view/MotionEvent;Landroid/widget/RelativeLayout;)Ljava/util/ArrayList;
    .locals 9
    .param p1, "e"    # Landroid/view/MotionEvent;
    .param p2, "rl"    # Landroid/widget/RelativeLayout;

    .prologue
    const/4 v8, 0x1

    const/4 v7, 0x0

    .line 49
    new-instance v0, Ljava/util/ArrayList;

    invoke-direct {v0}, Ljava/util/ArrayList;-><init>()V

    .line 50
    .local v0, "coords":Ljava/util/ArrayList;
    invoke-virtual {p1}, Landroid/view/MotionEvent;->getRawX()F

    move-result v5

    invoke-static {v5}, Ljava/lang/Float;->valueOf(F)Ljava/lang/Float;

    move-result-object v5

    invoke-virtual {v0, v5}, Ljava/util/ArrayList;->add(Ljava/lang/Object;)Z

    .line 51
    invoke-virtual {p1}, Landroid/view/MotionEvent;->getRawY()F

    move-result v5

    invoke-static {v5}, Ljava/lang/Float;->valueOf(F)Ljava/lang/Float;

    move-result-object v5

    invoke-virtual {v0, v5}, Ljava/util/ArrayList;->add(Ljava/lang/Object;)Z

    .line 52
    invoke-virtual {p2}, Landroid/widget/RelativeLayout;->getX()F

    move-result v5

    invoke-virtual {p2}, Landroid/widget/RelativeLayout;->getWidth()I

    move-result v6

    int-to-float v6, v6

    add-float/2addr v5, v6

    invoke-static {v5}, Ljava/lang/Float;->valueOf(F)Ljava/lang/Float;

    move-result-object v3

    .line 53
    .local v3, "rl_right":Ljava/lang/Float;
    invoke-virtual {p2}, Landroid/widget/RelativeLayout;->getX()F

    move-result v5

    invoke-static {v5}, Ljava/lang/Float;->valueOf(F)Ljava/lang/Float;

    move-result-object v2

    .line 54
    .local v2, "rl_left":Ljava/lang/Float;
    invoke-virtual {p2}, Landroid/widget/RelativeLayout;->getY()F

    move-result v5

    invoke-static {v5}, Ljava/lang/Float;->valueOf(F)Ljava/lang/Float;

    move-result-object v4

    .line 55
    .local v4, "rl_top":Ljava/lang/Float;
    invoke-virtual {p2}, Landroid/widget/RelativeLayout;->getY()F

    move-result v5

    invoke-virtual {p2}, Landroid/widget/RelativeLayout;->getHeight()I

    move-result v6

    int-to-float v6, v6

    add-float/2addr v5, v6

    invoke-static {v5}, Ljava/lang/Float;->valueOf(F)Ljava/lang/Float;

    move-result-object v1

    .line 57
    .local v1, "rl_bottom":Ljava/lang/Float;
    invoke-virtual {p1}, Landroid/view/MotionEvent;->getRawX()F

    move-result v5

    invoke-virtual {v3}, Ljava/lang/Float;->floatValue()F

    move-result v6

    cmpl-float v5, v5, v6

    if-lez v5, :cond_0

    invoke-virtual {v0, v7, v3}, Ljava/util/ArrayList;->set(ILjava/lang/Object;)Ljava/lang/Object;

    .line 58
    :cond_0
    invoke-virtual {p1}, Landroid/view/MotionEvent;->getRawX()F

    move-result v5

    invoke-virtual {v2}, Ljava/lang/Float;->floatValue()F

    move-result v6

    cmpg-float v5, v5, v6

    if-gez v5, :cond_1

    invoke-virtual {v0, v7, v2}, Ljava/util/ArrayList;->set(ILjava/lang/Object;)Ljava/lang/Object;

    .line 59
    :cond_1
    invoke-virtual {p1}, Landroid/view/MotionEvent;->getRawY()F

    move-result v5

    invoke-virtual {v4}, Ljava/lang/Float;->floatValue()F

    move-result v6

    cmpg-float v5, v5, v6

    if-gez v5, :cond_2

    invoke-virtual {v0, v8, v4}, Ljava/util/ArrayList;->set(ILjava/lang/Object;)Ljava/lang/Object;

    .line 60
    :cond_2
    invoke-virtual {p1}, Landroid/view/MotionEvent;->getRawY()F

    move-result v5

    invoke-virtual {v1}, Ljava/lang/Float;->floatValue()F

    move-result v6

    cmpl-float v5, v5, v6

    if-lez v5, :cond_3

    invoke-virtual {v0, v8, v1}, Ljava/util/ArrayList;->set(ILjava/lang/Object;)Ljava/lang/Object;

    .line 62
    :cond_3
    return-object v0
.end method

.method public boundCoordInTextView(Landroid/view/MotionEvent;Landroid/widget/TextView;)Ljava/util/ArrayList;
    .locals 9
    .param p1, "e"    # Landroid/view/MotionEvent;
    .param p2, "tv"    # Landroid/widget/TextView;

    .prologue
    const/4 v8, 0x1

    const/4 v7, 0x0

    .line 65
    new-instance v0, Ljava/util/ArrayList;

    invoke-direct {v0}, Ljava/util/ArrayList;-><init>()V

    .line 66
    .local v0, "coords":Ljava/util/ArrayList;
    invoke-virtual {p1}, Landroid/view/MotionEvent;->getRawX()F

    move-result v5

    invoke-static {v5}, Ljava/lang/Float;->valueOf(F)Ljava/lang/Float;

    move-result-object v5

    invoke-virtual {v0, v5}, Ljava/util/ArrayList;->add(Ljava/lang/Object;)Z

    .line 67
    invoke-virtual {p1}, Landroid/view/MotionEvent;->getRawY()F

    move-result v5

    invoke-static {v5}, Ljava/lang/Float;->valueOf(F)Ljava/lang/Float;

    move-result-object v5

    invoke-virtual {v0, v5}, Ljava/util/ArrayList;->add(Ljava/lang/Object;)Z

    .line 68
    invoke-virtual {p2}, Landroid/widget/TextView;->getX()F

    move-result v5

    invoke-virtual {p2}, Landroid/widget/TextView;->getWidth()I

    move-result v6

    int-to-float v6, v6

    add-float/2addr v5, v6

    invoke-static {v5}, Ljava/lang/Float;->valueOf(F)Ljava/lang/Float;

    move-result-object v3

    .line 69
    .local v3, "rl_right":Ljava/lang/Float;
    invoke-virtual {p2}, Landroid/widget/TextView;->getX()F

    move-result v5

    invoke-static {v5}, Ljava/lang/Float;->valueOf(F)Ljava/lang/Float;

    move-result-object v2

    .line 70
    .local v2, "rl_left":Ljava/lang/Float;
    invoke-virtual {p2}, Landroid/widget/TextView;->getY()F

    move-result v5

    invoke-static {v5}, Ljava/lang/Float;->valueOf(F)Ljava/lang/Float;

    move-result-object v4

    .line 71
    .local v4, "rl_top":Ljava/lang/Float;
    invoke-virtual {p2}, Landroid/widget/TextView;->getY()F

    move-result v5

    invoke-virtual {p2}, Landroid/widget/TextView;->getHeight()I

    move-result v6

    int-to-float v6, v6

    add-float/2addr v5, v6

    invoke-static {v5}, Ljava/lang/Float;->valueOf(F)Ljava/lang/Float;

    move-result-object v1

    .line 73
    .local v1, "rl_bottom":Ljava/lang/Float;
    invoke-virtual {p1}, Landroid/view/MotionEvent;->getRawX()F

    move-result v5

    invoke-virtual {v3}, Ljava/lang/Float;->floatValue()F

    move-result v6

    cmpl-float v5, v5, v6

    if-lez v5, :cond_0

    invoke-virtual {v0, v7, v3}, Ljava/util/ArrayList;->set(ILjava/lang/Object;)Ljava/lang/Object;

    .line 74
    :cond_0
    invoke-virtual {p1}, Landroid/view/MotionEvent;->getRawX()F

    move-result v5

    invoke-virtual {v2}, Ljava/lang/Float;->floatValue()F

    move-result v6

    cmpg-float v5, v5, v6

    if-gez v5, :cond_1

    invoke-virtual {v0, v7, v2}, Ljava/util/ArrayList;->set(ILjava/lang/Object;)Ljava/lang/Object;

    .line 75
    :cond_1
    invoke-virtual {p1}, Landroid/view/MotionEvent;->getRawY()F

    move-result v5

    invoke-virtual {v4}, Ljava/lang/Float;->floatValue()F

    move-result v6

    cmpg-float v5, v5, v6

    if-gez v5, :cond_2

    invoke-virtual {v0, v8, v4}, Ljava/util/ArrayList;->set(ILjava/lang/Object;)Ljava/lang/Object;

    .line 76
    :cond_2
    invoke-virtual {p1}, Landroid/view/MotionEvent;->getRawY()F

    move-result v5

    invoke-virtual {v1}, Ljava/lang/Float;->floatValue()F

    move-result v6

    cmpl-float v5, v5, v6

    if-lez v5, :cond_3

    invoke-virtual {v0, v8, v1}, Ljava/util/ArrayList;->set(ILjava/lang/Object;)Ljava/lang/Object;

    .line 78
    :cond_3
    return-object v0
.end method

.method public boundPitch(Landroid/view/MotionEvent;Landroid/widget/TextView;Ljava/lang/Boolean;F)Ljava/lang/Float;
    .locals 12
    .param p1, "e"    # Landroid/view/MotionEvent;
    .param p2, "tv"    # Landroid/widget/TextView;
    .param p3, "shouldInvert"    # Ljava/lang/Boolean;
    .param p4, "deadband"    # F

    .prologue
    .line 136
    invoke-virtual {p1}, Landroid/view/MotionEvent;->getRawY()F

    move-result v10

    invoke-static {v10}, Ljava/lang/Float;->valueOf(F)Ljava/lang/Float;

    move-result-object v3

    .line 137
    .local v3, "rawY":Ljava/lang/Float;
    invoke-virtual {p2}, Landroid/widget/TextView;->getY()F

    move-result v10

    invoke-static {v10}, Ljava/lang/Float;->valueOf(F)Ljava/lang/Float;

    move-result-object v7

    .line 138
    .local v7, "tv_top":Ljava/lang/Float;
    invoke-virtual {p2}, Landroid/widget/TextView;->getY()F

    move-result v10

    invoke-virtual {p2}, Landroid/widget/TextView;->getHeight()I

    move-result v11

    int-to-float v11, v11

    add-float/2addr v10, v11

    invoke-static {v10}, Ljava/lang/Float;->valueOf(F)Ljava/lang/Float;

    move-result-object v5

    .line 139
    .local v5, "tv_bottom":Ljava/lang/Float;
    invoke-virtual {v5}, Ljava/lang/Float;->floatValue()F

    move-result v10

    invoke-virtual {p2}, Landroid/widget/TextView;->getHeight()I

    move-result v11

    div-int/lit8 v11, v11, 0x2

    int-to-float v11, v11

    sub-float/2addr v10, v11

    invoke-static {v10}, Ljava/lang/Float;->valueOf(F)Ljava/lang/Float;

    move-result-object v6

    .line 140
    .local v6, "tv_middle":Ljava/lang/Float;
    invoke-virtual {p1}, Landroid/view/MotionEvent;->getRawY()F

    move-result v10

    invoke-virtual {v6}, Ljava/lang/Float;->floatValue()F

    move-result v11

    sub-float/2addr v10, v11

    invoke-static {v10}, Ljava/lang/Float;->valueOf(F)Ljava/lang/Float;

    move-result-object v1

    .line 144
    .local v1, "distance_from_middle":Ljava/lang/Float;
    invoke-virtual {v1}, Ljava/lang/Float;->floatValue()F

    move-result v10

    invoke-static {v10}, Ljava/lang/Math;->abs(F)F

    move-result v10

    cmpg-float v10, v10, p4

    if-gez v10, :cond_1

    .line 147
    sget-object v4, Lcom/brynk/fathom/helpers/Constants;->SERVO_NEUTRAL:Ljava/lang/Float;

    .line 175
    :cond_0
    :goto_0
    return-object v4

    .line 150
    :cond_1
    move-object v0, v3

    .line 152
    .local v0, "bounded_y":Ljava/lang/Float;
    invoke-virtual {v3}, Ljava/lang/Float;->floatValue()F

    move-result v10

    invoke-virtual {v5}, Ljava/lang/Float;->floatValue()F

    move-result v11

    cmpl-float v10, v10, v11

    if-lez v10, :cond_2

    move-object v0, v5

    .line 153
    :cond_2
    invoke-virtual {v3}, Ljava/lang/Float;->floatValue()F

    move-result v10

    invoke-virtual {v7}, Ljava/lang/Float;->floatValue()F

    move-result v11

    cmpg-float v10, v10, v11

    if-gez v10, :cond_3

    move-object v0, v7

    .line 156
    :cond_3
    invoke-virtual {v5}, Ljava/lang/Float;->floatValue()F

    move-result v10

    invoke-virtual {v0}, Ljava/lang/Float;->floatValue()F

    move-result v11

    sub-float/2addr v10, v11

    invoke-static {v10}, Ljava/lang/Float;->valueOf(F)Ljava/lang/Float;

    move-result-object v8

    .line 157
    .local v8, "y_difference":Ljava/lang/Float;
    invoke-virtual {v8}, Ljava/lang/Float;->floatValue()F

    move-result v10

    invoke-virtual {p2}, Landroid/widget/TextView;->getHeight()I

    move-result v11

    int-to-float v11, v11

    div-float/2addr v10, v11

    invoke-static {v10}, Ljava/lang/Float;->valueOf(F)Ljava/lang/Float;

    move-result-object v9

    .line 159
    .local v9, "y_quotiant":Ljava/lang/Float;
    iget-object v10, p0, Lcom/brynk/fathom/helpers/CoordinateHelper;->pitch_max:Ljava/lang/Float;

    invoke-virtual {v10}, Ljava/lang/Float;->floatValue()F

    move-result v10

    iget-object v11, p0, Lcom/brynk/fathom/helpers/CoordinateHelper;->pitch_min:Ljava/lang/Float;

    invoke-virtual {v11}, Ljava/lang/Float;->floatValue()F

    move-result v11

    sub-float/2addr v10, v11

    invoke-virtual {v9}, Ljava/lang/Float;->floatValue()F

    move-result v11

    mul-float/2addr v10, v11

    iget-object v11, p0, Lcom/brynk/fathom/helpers/CoordinateHelper;->pitch_min:Ljava/lang/Float;

    invoke-virtual {v11}, Ljava/lang/Float;->floatValue()F

    move-result v11

    add-float/2addr v10, v11

    invoke-static {v10}, Ljava/lang/Float;->valueOf(F)Ljava/lang/Float;

    move-result-object v4

    .line 161
    .local v4, "result":Ljava/lang/Float;
    invoke-virtual {p3}, Ljava/lang/Boolean;->booleanValue()Z

    move-result v10

    if-eqz v10, :cond_4

    .line 163
    invoke-virtual {v4}, Ljava/lang/Float;->floatValue()F

    move-result v10

    sget-object v11, Lcom/brynk/fathom/helpers/Constants;->SERVO_NEUTRAL:Ljava/lang/Float;

    invoke-virtual {v11}, Ljava/lang/Float;->floatValue()F

    move-result v11

    sub-float/2addr v10, v11

    invoke-static {v10}, Ljava/lang/Math;->abs(F)F

    move-result v10

    invoke-static {v10}, Ljava/lang/Float;->valueOf(F)Ljava/lang/Float;

    move-result-object v2

    .line 164
    .local v2, "offset_from_neutral":Ljava/lang/Float;
    invoke-virtual {v4}, Ljava/lang/Float;->floatValue()F

    move-result v10

    sget-object v11, Lcom/brynk/fathom/helpers/Constants;->SERVO_NEUTRAL:Ljava/lang/Float;

    invoke-virtual {v11}, Ljava/lang/Float;->floatValue()F

    move-result v11

    cmpl-float v10, v10, v11

    if-lez v10, :cond_5

    .line 165
    sget-object v10, Lcom/brynk/fathom/helpers/Constants;->SERVO_NEUTRAL:Ljava/lang/Float;

    invoke-virtual {v10}, Ljava/lang/Float;->floatValue()F

    move-result v10

    invoke-virtual {v2}, Ljava/lang/Float;->floatValue()F

    move-result v11

    sub-float/2addr v10, v11

    invoke-static {v10}, Ljava/lang/Float;->valueOf(F)Ljava/lang/Float;

    move-result-object v4

    .line 172
    .end local v2    # "offset_from_neutral":Ljava/lang/Float;
    :cond_4
    :goto_1
    invoke-virtual {v4}, Ljava/lang/Float;->floatValue()F

    move-result v10

    const v11, 0x43b68000    # 365.0f

    cmpl-float v10, v10, v11

    if-lez v10, :cond_0

    invoke-virtual {v4}, Ljava/lang/Float;->floatValue()F

    move-result v10

    const v11, 0x43c08000    # 385.0f

    cmpg-float v10, v10, v11

    if-gez v10, :cond_0

    .line 173
    sget-object v4, Lcom/brynk/fathom/helpers/Constants;->SERVO_NEUTRAL:Ljava/lang/Float;

    goto/16 :goto_0

    .line 167
    .restart local v2    # "offset_from_neutral":Ljava/lang/Float;
    :cond_5
    sget-object v10, Lcom/brynk/fathom/helpers/Constants;->SERVO_NEUTRAL:Ljava/lang/Float;

    invoke-virtual {v10}, Ljava/lang/Float;->floatValue()F

    move-result v10

    invoke-virtual {v2}, Ljava/lang/Float;->floatValue()F

    move-result v11

    add-float/2addr v10, v11

    invoke-static {v10}, Ljava/lang/Float;->valueOf(F)Ljava/lang/Float;

    move-result-object v4

    goto :goto_1
.end method

.method public boundThruster(Landroid/view/MotionEvent;Landroid/widget/TextView;Ljava/lang/Boolean;F)Ljava/lang/Float;
    .locals 12
    .param p1, "e"    # Landroid/view/MotionEvent;
    .param p2, "tv"    # Landroid/widget/TextView;
    .param p3, "shouldInvert"    # Ljava/lang/Boolean;
    .param p4, "deadband"    # F

    .prologue
    .line 89
    invoke-virtual {p1}, Landroid/view/MotionEvent;->getRawY()F

    move-result v10

    invoke-static {v10}, Ljava/lang/Float;->valueOf(F)Ljava/lang/Float;

    move-result-object v3

    .line 90
    .local v3, "rawY":Ljava/lang/Float;
    invoke-virtual {p2}, Landroid/widget/TextView;->getY()F

    move-result v10

    invoke-static {v10}, Ljava/lang/Float;->valueOf(F)Ljava/lang/Float;

    move-result-object v7

    .line 91
    .local v7, "tv_top":Ljava/lang/Float;
    invoke-virtual {p2}, Landroid/widget/TextView;->getY()F

    move-result v10

    invoke-virtual {p2}, Landroid/widget/TextView;->getHeight()I

    move-result v11

    int-to-float v11, v11

    add-float/2addr v10, v11

    invoke-static {v10}, Ljava/lang/Float;->valueOf(F)Ljava/lang/Float;

    move-result-object v5

    .line 92
    .local v5, "tv_bottom":Ljava/lang/Float;
    invoke-virtual {v5}, Ljava/lang/Float;->floatValue()F

    move-result v10

    invoke-virtual {p2}, Landroid/widget/TextView;->getHeight()I

    move-result v11

    div-int/lit8 v11, v11, 0x2

    int-to-float v11, v11

    sub-float/2addr v10, v11

    invoke-static {v10}, Ljava/lang/Float;->valueOf(F)Ljava/lang/Float;

    move-result-object v6

    .line 93
    .local v6, "tv_middle":Ljava/lang/Float;
    invoke-virtual {p1}, Landroid/view/MotionEvent;->getRawY()F

    move-result v10

    invoke-virtual {v6}, Ljava/lang/Float;->floatValue()F

    move-result v11

    sub-float/2addr v10, v11

    invoke-static {v10}, Ljava/lang/Float;->valueOf(F)Ljava/lang/Float;

    move-result-object v1

    .line 97
    .local v1, "distance_from_middle":Ljava/lang/Float;
    invoke-virtual {v1}, Ljava/lang/Float;->floatValue()F

    move-result v10

    invoke-static {v10}, Ljava/lang/Math;->abs(F)F

    move-result v10

    cmpg-float v10, v10, p4

    if-gez v10, :cond_1

    .line 100
    sget-object v4, Lcom/brynk/fathom/helpers/Constants;->SERVO_NEUTRAL:Ljava/lang/Float;

    .line 128
    :cond_0
    :goto_0
    return-object v4

    .line 103
    :cond_1
    move-object v0, v3

    .line 105
    .local v0, "bounded_y":Ljava/lang/Float;
    invoke-virtual {v3}, Ljava/lang/Float;->floatValue()F

    move-result v10

    invoke-virtual {v5}, Ljava/lang/Float;->floatValue()F

    move-result v11

    cmpl-float v10, v10, v11

    if-lez v10, :cond_2

    move-object v0, v5

    .line 106
    :cond_2
    invoke-virtual {v3}, Ljava/lang/Float;->floatValue()F

    move-result v10

    invoke-virtual {v7}, Ljava/lang/Float;->floatValue()F

    move-result v11

    cmpg-float v10, v10, v11

    if-gez v10, :cond_3

    move-object v0, v7

    .line 109
    :cond_3
    invoke-virtual {v5}, Ljava/lang/Float;->floatValue()F

    move-result v10

    invoke-virtual {v0}, Ljava/lang/Float;->floatValue()F

    move-result v11

    sub-float/2addr v10, v11

    invoke-static {v10}, Ljava/lang/Float;->valueOf(F)Ljava/lang/Float;

    move-result-object v8

    .line 110
    .local v8, "y_difference":Ljava/lang/Float;
    invoke-virtual {v8}, Ljava/lang/Float;->floatValue()F

    move-result v10

    invoke-virtual {p2}, Landroid/widget/TextView;->getHeight()I

    move-result v11

    int-to-float v11, v11

    div-float/2addr v10, v11

    invoke-static {v10}, Ljava/lang/Float;->valueOf(F)Ljava/lang/Float;

    move-result-object v9

    .line 112
    .local v9, "y_quotiant":Ljava/lang/Float;
    iget-object v10, p0, Lcom/brynk/fathom/helpers/CoordinateHelper;->throttle_max:Ljava/lang/Float;

    invoke-virtual {v10}, Ljava/lang/Float;->floatValue()F

    move-result v10

    iget-object v11, p0, Lcom/brynk/fathom/helpers/CoordinateHelper;->throttle_min:Ljava/lang/Float;

    invoke-virtual {v11}, Ljava/lang/Float;->floatValue()F

    move-result v11

    sub-float/2addr v10, v11

    invoke-virtual {v9}, Ljava/lang/Float;->floatValue()F

    move-result v11

    mul-float/2addr v10, v11

    iget-object v11, p0, Lcom/brynk/fathom/helpers/CoordinateHelper;->throttle_min:Ljava/lang/Float;

    invoke-virtual {v11}, Ljava/lang/Float;->floatValue()F

    move-result v11

    add-float/2addr v10, v11

    invoke-static {v10}, Ljava/lang/Float;->valueOf(F)Ljava/lang/Float;

    move-result-object v4

    .line 114
    .local v4, "result":Ljava/lang/Float;
    invoke-virtual {p3}, Ljava/lang/Boolean;->booleanValue()Z

    move-result v10

    if-eqz v10, :cond_4

    .line 116
    invoke-virtual {v4}, Ljava/lang/Float;->floatValue()F

    move-result v10

    sget-object v11, Lcom/brynk/fathom/helpers/Constants;->SERVO_NEUTRAL:Ljava/lang/Float;

    invoke-virtual {v11}, Ljava/lang/Float;->floatValue()F

    move-result v11

    sub-float/2addr v10, v11

    invoke-static {v10}, Ljava/lang/Math;->abs(F)F

    move-result v10

    invoke-static {v10}, Ljava/lang/Float;->valueOf(F)Ljava/lang/Float;

    move-result-object v2

    .line 117
    .local v2, "offset_from_neutral":Ljava/lang/Float;
    invoke-virtual {v4}, Ljava/lang/Float;->floatValue()F

    move-result v10

    sget-object v11, Lcom/brynk/fathom/helpers/Constants;->SERVO_NEUTRAL:Ljava/lang/Float;

    invoke-virtual {v11}, Ljava/lang/Float;->floatValue()F

    move-result v11

    cmpl-float v10, v10, v11

    if-lez v10, :cond_5

    .line 118
    sget-object v10, Lcom/brynk/fathom/helpers/Constants;->SERVO_NEUTRAL:Ljava/lang/Float;

    invoke-virtual {v10}, Ljava/lang/Float;->floatValue()F

    move-result v10

    invoke-virtual {v2}, Ljava/lang/Float;->floatValue()F

    move-result v11

    sub-float/2addr v10, v11

    invoke-static {v10}, Ljava/lang/Float;->valueOf(F)Ljava/lang/Float;

    move-result-object v4

    .line 125
    .end local v2    # "offset_from_neutral":Ljava/lang/Float;
    :cond_4
    :goto_1
    invoke-virtual {v4}, Ljava/lang/Float;->floatValue()F

    move-result v10

    const v11, 0x43b68000    # 365.0f

    cmpl-float v10, v10, v11

    if-lez v10, :cond_0

    invoke-virtual {v4}, Ljava/lang/Float;->floatValue()F

    move-result v10

    const v11, 0x43c08000    # 385.0f

    cmpg-float v10, v10, v11

    if-gez v10, :cond_0

    .line 126
    sget-object v4, Lcom/brynk/fathom/helpers/Constants;->SERVO_NEUTRAL:Ljava/lang/Float;

    goto/16 :goto_0

    .line 120
    .restart local v2    # "offset_from_neutral":Ljava/lang/Float;
    :cond_5
    sget-object v10, Lcom/brynk/fathom/helpers/Constants;->SERVO_NEUTRAL:Ljava/lang/Float;

    invoke-virtual {v10}, Ljava/lang/Float;->floatValue()F

    move-result v10

    invoke-virtual {v2}, Ljava/lang/Float;->floatValue()F

    move-result v11

    add-float/2addr v10, v11

    invoke-static {v10}, Ljava/lang/Float;->valueOf(F)Ljava/lang/Float;

    move-result-object v4

    goto :goto_1
.end method

.method public boundThrusterTick(Ljava/lang/Float;Landroid/widget/TextView;)Ljava/lang/Float;
    .locals 6
    .param p1, "val"    # Ljava/lang/Float;
    .param p2, "tv"    # Landroid/widget/TextView;

    .prologue
    .line 230
    move-object v1, p1

    .line 231
    .local v1, "rawY":Ljava/lang/Float;
    invoke-virtual {p2}, Landroid/widget/TextView;->getY()F

    move-result v4

    invoke-static {v4}, Ljava/lang/Float;->valueOf(F)Ljava/lang/Float;

    move-result-object v3

    .line 232
    .local v3, "tv_top":Ljava/lang/Float;
    invoke-virtual {p2}, Landroid/widget/TextView;->getY()F

    move-result v4

    invoke-virtual {p2}, Landroid/widget/TextView;->getHeight()I

    move-result v5

    int-to-float v5, v5

    add-float/2addr v4, v5

    invoke-static {v4}, Ljava/lang/Float;->valueOf(F)Ljava/lang/Float;

    move-result-object v2

    .line 234
    .local v2, "tv_bottom":Ljava/lang/Float;
    move-object v0, v1

    .line 236
    .local v0, "bounded_y":Ljava/lang/Float;
    invoke-virtual {v1}, Ljava/lang/Float;->floatValue()F

    move-result v4

    invoke-virtual {v2}, Ljava/lang/Float;->floatValue()F

    move-result v5

    cmpl-float v4, v4, v5

    if-lez v4, :cond_0

    move-object v0, v2

    .line 237
    :cond_0
    invoke-virtual {v1}, Ljava/lang/Float;->floatValue()F

    move-result v4

    invoke-virtual {v3}, Ljava/lang/Float;->floatValue()F

    move-result v5

    cmpg-float v4, v4, v5

    if-gez v4, :cond_1

    move-object v0, v3

    .line 240
    :cond_1
    return-object v0
.end method

.method public changePitchMinAndMax(Ljava/lang/Float;)V
    .locals 5
    .param p1, "t_mod"    # Ljava/lang/Float;

    .prologue
    .line 271
    sget-object v2, Lcom/brynk/fathom/helpers/Constants;->SERVO_MAX:Ljava/lang/Float;

    invoke-virtual {v2}, Ljava/lang/Float;->floatValue()F

    move-result v2

    sget-object v3, Lcom/brynk/fathom/helpers/Constants;->SERVO_MIN:Ljava/lang/Float;

    invoke-virtual {v3}, Ljava/lang/Float;->floatValue()F

    move-result v3

    sub-float/2addr v2, v3

    invoke-virtual {p1}, Ljava/lang/Float;->floatValue()F

    move-result v3

    mul-float/2addr v2, v3

    invoke-static {v2}, Ljava/lang/Float;->valueOf(F)Ljava/lang/Float;

    move-result-object v0

    .line 272
    .local v0, "pitch_difference":Ljava/lang/Float;
    invoke-virtual {v0}, Ljava/lang/Float;->floatValue()F

    move-result v2

    const/high16 v3, 0x40000000    # 2.0f

    div-float/2addr v2, v3

    invoke-static {v2}, Ljava/lang/Float;->valueOf(F)Ljava/lang/Float;

    move-result-object v1

    .line 273
    .local v1, "pitch_offset":Ljava/lang/Float;
    sget-object v2, Lcom/brynk/fathom/helpers/Constants;->SERVO_NEUTRAL:Ljava/lang/Float;

    invoke-virtual {v2}, Ljava/lang/Float;->floatValue()F

    move-result v2

    invoke-virtual {v1}, Ljava/lang/Float;->floatValue()F

    move-result v3

    add-float/2addr v2, v3

    invoke-static {v2}, Ljava/lang/Float;->valueOf(F)Ljava/lang/Float;

    move-result-object v2

    iput-object v2, p0, Lcom/brynk/fathom/helpers/CoordinateHelper;->pitch_max:Ljava/lang/Float;

    .line 274
    sget-object v2, Lcom/brynk/fathom/helpers/Constants;->SERVO_NEUTRAL:Ljava/lang/Float;

    invoke-virtual {v2}, Ljava/lang/Float;->floatValue()F

    move-result v2

    invoke-virtual {v1}, Ljava/lang/Float;->floatValue()F

    move-result v3

    sub-float/2addr v2, v3

    invoke-static {v2}, Ljava/lang/Float;->valueOf(F)Ljava/lang/Float;

    move-result-object v2

    iput-object v2, p0, Lcom/brynk/fathom/helpers/CoordinateHelper;->pitch_min:Ljava/lang/Float;

    .line 275
    const-string v2, "FATHOM1"

    new-instance v3, Ljava/lang/StringBuilder;

    invoke-direct {v3}, Ljava/lang/StringBuilder;-><init>()V

    const-string v4, "MAX:"

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    iget-object v4, p0, Lcom/brynk/fathom/helpers/CoordinateHelper;->pitch_max:Ljava/lang/Float;

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    move-result-object v3

    const-string v4, ",MIN:"

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    iget-object v4, p0, Lcom/brynk/fathom/helpers/CoordinateHelper;->pitch_min:Ljava/lang/Float;

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    move-result-object v3

    invoke-virtual {v3}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v3

    invoke-static {v2, v3}, Landroid/util/Log;->d(Ljava/lang/String;Ljava/lang/String;)I

    .line 276
    return-void
.end method

.method public changeThrottleMinAndMax(Ljava/lang/Float;)V
    .locals 4
    .param p1, "t_mod"    # Ljava/lang/Float;

    .prologue
    .line 265
    sget-object v2, Lcom/brynk/fathom/helpers/Constants;->SERVO_MAX:Ljava/lang/Float;

    invoke-virtual {v2}, Ljava/lang/Float;->floatValue()F

    move-result v2

    sget-object v3, Lcom/brynk/fathom/helpers/Constants;->SERVO_MIN:Ljava/lang/Float;

    invoke-virtual {v3}, Ljava/lang/Float;->floatValue()F

    move-result v3

    sub-float/2addr v2, v3

    invoke-virtual {p1}, Ljava/lang/Float;->floatValue()F

    move-result v3

    mul-float/2addr v2, v3

    invoke-static {v2}, Ljava/lang/Float;->valueOf(F)Ljava/lang/Float;

    move-result-object v0

    .line 266
    .local v0, "throttle_difference":Ljava/lang/Float;
    invoke-virtual {v0}, Ljava/lang/Float;->floatValue()F

    move-result v2

    const/high16 v3, 0x40000000    # 2.0f

    div-float/2addr v2, v3

    invoke-static {v2}, Ljava/lang/Float;->valueOf(F)Ljava/lang/Float;

    move-result-object v1

    .line 267
    .local v1, "throttle_offset":Ljava/lang/Float;
    sget-object v2, Lcom/brynk/fathom/helpers/Constants;->SERVO_NEUTRAL:Ljava/lang/Float;

    invoke-virtual {v2}, Ljava/lang/Float;->floatValue()F

    move-result v2

    invoke-virtual {v1}, Ljava/lang/Float;->floatValue()F

    move-result v3

    add-float/2addr v2, v3

    invoke-static {v2}, Ljava/lang/Float;->valueOf(F)Ljava/lang/Float;

    move-result-object v2

    iput-object v2, p0, Lcom/brynk/fathom/helpers/CoordinateHelper;->throttle_max:Ljava/lang/Float;

    .line 268
    sget-object v2, Lcom/brynk/fathom/helpers/Constants;->SERVO_NEUTRAL:Ljava/lang/Float;

    invoke-virtual {v2}, Ljava/lang/Float;->floatValue()F

    move-result v2

    invoke-virtual {v1}, Ljava/lang/Float;->floatValue()F

    move-result v3

    sub-float/2addr v2, v3

    invoke-static {v2}, Ljava/lang/Float;->valueOf(F)Ljava/lang/Float;

    move-result-object v2

    iput-object v2, p0, Lcom/brynk/fathom/helpers/CoordinateHelper;->throttle_min:Ljava/lang/Float;

    .line 269
    return-void
.end method

.method public getThrusterNeutral()Ljava/lang/Float;
    .locals 1

    .prologue
    .line 81
    sget-object v0, Lcom/brynk/fathom/helpers/Constants;->SERVO_NEUTRAL:Ljava/lang/Float;

    return-object v0
.end method

.method public mapExternalControllerPitch(Ljava/lang/Float;)I
    .locals 12
    .param p1, "val"    # Ljava/lang/Float;

    .prologue
    const-wide v10, 0x3ee4f8b588e368f1L    # 1.0E-5

    .line 325
    move-object v4, p1

    .line 326
    .local v4, "rawY":Ljava/lang/Float;
    const/high16 v8, 0x3f800000    # 1.0f

    invoke-static {v8}, Ljava/lang/Float;->valueOf(F)Ljava/lang/Float;

    move-result-object v7

    .line 327
    .local v7, "y_upBound":Ljava/lang/Float;
    const/high16 v8, -0x40800000    # -1.0f

    invoke-static {v8}, Ljava/lang/Float;->valueOf(F)Ljava/lang/Float;

    move-result-object v5

    .line 328
    .local v5, "y_downBound":Ljava/lang/Float;
    invoke-static {v10, v11}, Ljava/lang/Double;->valueOf(D)Ljava/lang/Double;

    move-result-object v1

    .line 329
    .local v1, "epsilon":Ljava/lang/Double;
    const v8, 0x3b808100

    invoke-static {v8}, Ljava/lang/Float;->valueOf(F)Ljava/lang/Float;

    move-result-object v6

    .line 332
    .local v6, "y_neutral":Ljava/lang/Float;
    iget-object v8, p0, Lcom/brynk/fathom/helpers/CoordinateHelper;->pitch_max:Ljava/lang/Float;

    invoke-virtual {v8}, Ljava/lang/Float;->floatValue()F

    move-result v8

    sget-object v9, Lcom/brynk/fathom/helpers/Constants;->SERVO_NEUTRAL:Ljava/lang/Float;

    invoke-virtual {v9}, Ljava/lang/Float;->floatValue()F

    move-result v9

    sub-float/2addr v8, v9

    invoke-static {v8}, Ljava/lang/Float;->valueOf(F)Ljava/lang/Float;

    move-result-object v3

    .line 333
    .local v3, "range_up":Ljava/lang/Float;
    sget-object v8, Lcom/brynk/fathom/helpers/Constants;->SERVO_NEUTRAL:Ljava/lang/Float;

    invoke-virtual {v8}, Ljava/lang/Float;->floatValue()F

    move-result v8

    iget-object v9, p0, Lcom/brynk/fathom/helpers/CoordinateHelper;->pitch_min:Ljava/lang/Float;

    invoke-virtual {v9}, Ljava/lang/Float;->floatValue()F

    move-result v9

    sub-float/2addr v8, v9

    invoke-static {v8}, Ljava/lang/Float;->valueOf(F)Ljava/lang/Float;

    move-result-object v2

    .line 337
    .local v2, "range_down":Ljava/lang/Float;
    sget-object v0, Lcom/brynk/fathom/helpers/Constants;->SERVO_NEUTRAL:Ljava/lang/Float;

    .line 339
    .local v0, "bounded_y":Ljava/lang/Float;
    invoke-virtual {v4}, Ljava/lang/Float;->floatValue()F

    move-result v8

    invoke-virtual {v6}, Ljava/lang/Float;->floatValue()F

    move-result v9

    sub-float/2addr v8, v9

    invoke-static {v8}, Ljava/lang/Math;->abs(F)F

    move-result v8

    float-to-double v8, v8

    cmpg-double v8, v8, v10

    if-gez v8, :cond_1

    .line 340
    sget-object v0, Lcom/brynk/fathom/helpers/Constants;->SERVO_NEUTRAL:Ljava/lang/Float;

    .line 357
    :cond_0
    :goto_0
    invoke-virtual {v0}, Ljava/lang/Float;->floatValue()F

    move-result v8

    invoke-static {v8}, Ljava/lang/Math;->round(F)I

    move-result v8

    return v8

    .line 345
    :cond_1
    invoke-virtual {v4}, Ljava/lang/Float;->floatValue()F

    move-result v8

    invoke-virtual {v6}, Ljava/lang/Float;->floatValue()F

    move-result v9

    cmpg-float v8, v8, v9

    if-gez v8, :cond_2

    .line 347
    invoke-virtual {v4}, Ljava/lang/Float;->floatValue()F

    move-result v8

    invoke-static {v8}, Ljava/lang/Math;->abs(F)F

    move-result v8

    invoke-virtual {v3}, Ljava/lang/Float;->floatValue()F

    move-result v9

    mul-float/2addr v8, v9

    sget-object v9, Lcom/brynk/fathom/helpers/Constants;->SERVO_NEUTRAL:Ljava/lang/Float;

    invoke-virtual {v9}, Ljava/lang/Float;->floatValue()F

    move-result v9

    add-float/2addr v8, v9

    invoke-static {v8}, Ljava/lang/Float;->valueOf(F)Ljava/lang/Float;

    move-result-object v0

    goto :goto_0

    .line 349
    :cond_2
    invoke-virtual {v4}, Ljava/lang/Float;->floatValue()F

    move-result v8

    invoke-virtual {v6}, Ljava/lang/Float;->floatValue()F

    move-result v9

    cmpl-float v8, v8, v9

    if-lez v8, :cond_0

    .line 351
    sget-object v8, Lcom/brynk/fathom/helpers/Constants;->SERVO_NEUTRAL:Ljava/lang/Float;

    invoke-virtual {v8}, Ljava/lang/Float;->floatValue()F

    move-result v8

    invoke-virtual {v4}, Ljava/lang/Float;->floatValue()F

    move-result v9

    invoke-static {v9}, Ljava/lang/Math;->abs(F)F

    move-result v9

    invoke-virtual {v2}, Ljava/lang/Float;->floatValue()F

    move-result v10

    mul-float/2addr v9, v10

    sub-float/2addr v8, v9

    invoke-static {v8}, Ljava/lang/Float;->valueOf(F)Ljava/lang/Float;

    move-result-object v0

    goto :goto_0
.end method

.method public mapExternalControllerThruster(Ljava/lang/Float;)I
    .locals 12
    .param p1, "val"    # Ljava/lang/Float;

    .prologue
    const-wide v10, 0x3ee4f8b588e368f1L    # 1.0E-5

    .line 288
    move-object v4, p1

    .line 289
    .local v4, "rawY":Ljava/lang/Float;
    const/high16 v8, 0x3f800000    # 1.0f

    invoke-static {v8}, Ljava/lang/Float;->valueOf(F)Ljava/lang/Float;

    move-result-object v7

    .line 290
    .local v7, "y_upBound":Ljava/lang/Float;
    const/high16 v8, -0x40800000    # -1.0f

    invoke-static {v8}, Ljava/lang/Float;->valueOf(F)Ljava/lang/Float;

    move-result-object v5

    .line 291
    .local v5, "y_downBound":Ljava/lang/Float;
    invoke-static {v10, v11}, Ljava/lang/Double;->valueOf(D)Ljava/lang/Double;

    move-result-object v1

    .line 292
    .local v1, "epsilon":Ljava/lang/Double;
    const v8, 0x3b808100

    invoke-static {v8}, Ljava/lang/Float;->valueOf(F)Ljava/lang/Float;

    move-result-object v6

    .line 294
    .local v6, "y_neutral":Ljava/lang/Float;
    iget-object v8, p0, Lcom/brynk/fathom/helpers/CoordinateHelper;->throttle_max:Ljava/lang/Float;

    invoke-virtual {v8}, Ljava/lang/Float;->floatValue()F

    move-result v8

    sget-object v9, Lcom/brynk/fathom/helpers/Constants;->SERVO_NEUTRAL:Ljava/lang/Float;

    invoke-virtual {v9}, Ljava/lang/Float;->floatValue()F

    move-result v9

    sub-float/2addr v8, v9

    invoke-static {v8}, Ljava/lang/Float;->valueOf(F)Ljava/lang/Float;

    move-result-object v3

    .line 295
    .local v3, "range_up":Ljava/lang/Float;
    sget-object v8, Lcom/brynk/fathom/helpers/Constants;->SERVO_NEUTRAL:Ljava/lang/Float;

    invoke-virtual {v8}, Ljava/lang/Float;->floatValue()F

    move-result v8

    iget-object v9, p0, Lcom/brynk/fathom/helpers/CoordinateHelper;->throttle_min:Ljava/lang/Float;

    invoke-virtual {v9}, Ljava/lang/Float;->floatValue()F

    move-result v9

    sub-float/2addr v8, v9

    invoke-static {v8}, Ljava/lang/Float;->valueOf(F)Ljava/lang/Float;

    move-result-object v2

    .line 298
    .local v2, "range_down":Ljava/lang/Float;
    sget-object v0, Lcom/brynk/fathom/helpers/Constants;->SERVO_NEUTRAL:Ljava/lang/Float;

    .line 300
    .local v0, "bounded_y":Ljava/lang/Float;
    invoke-virtual {v4}, Ljava/lang/Float;->floatValue()F

    move-result v8

    invoke-virtual {v6}, Ljava/lang/Float;->floatValue()F

    move-result v9

    sub-float/2addr v8, v9

    invoke-static {v8}, Ljava/lang/Math;->abs(F)F

    move-result v8

    float-to-double v8, v8

    cmpg-double v8, v8, v10

    if-gez v8, :cond_1

    .line 301
    sget-object v0, Lcom/brynk/fathom/helpers/Constants;->SERVO_NEUTRAL:Ljava/lang/Float;

    .line 316
    :cond_0
    :goto_0
    invoke-virtual {v0}, Ljava/lang/Float;->floatValue()F

    move-result v8

    invoke-static {v8}, Ljava/lang/Math;->round(F)I

    move-result v8

    return v8

    .line 304
    :cond_1
    invoke-virtual {v4}, Ljava/lang/Float;->floatValue()F

    move-result v8

    invoke-virtual {v6}, Ljava/lang/Float;->floatValue()F

    move-result v9

    cmpg-float v8, v8, v9

    if-gez v8, :cond_2

    .line 306
    invoke-virtual {v4}, Ljava/lang/Float;->floatValue()F

    move-result v8

    invoke-static {v8}, Ljava/lang/Math;->abs(F)F

    move-result v8

    invoke-virtual {v3}, Ljava/lang/Float;->floatValue()F

    move-result v9

    mul-float/2addr v8, v9

    sget-object v9, Lcom/brynk/fathom/helpers/Constants;->SERVO_NEUTRAL:Ljava/lang/Float;

    invoke-virtual {v9}, Ljava/lang/Float;->floatValue()F

    move-result v9

    add-float/2addr v8, v9

    invoke-static {v8}, Ljava/lang/Float;->valueOf(F)Ljava/lang/Float;

    move-result-object v0

    goto :goto_0

    .line 308
    :cond_2
    invoke-virtual {v4}, Ljava/lang/Float;->floatValue()F

    move-result v8

    invoke-virtual {v6}, Ljava/lang/Float;->floatValue()F

    move-result v9

    cmpl-float v8, v8, v9

    if-lez v8, :cond_0

    .line 310
    sget-object v8, Lcom/brynk/fathom/helpers/Constants;->SERVO_NEUTRAL:Ljava/lang/Float;

    invoke-virtual {v8}, Ljava/lang/Float;->floatValue()F

    move-result v8

    invoke-virtual {v4}, Ljava/lang/Float;->floatValue()F

    move-result v9

    invoke-static {v9}, Ljava/lang/Math;->abs(F)F

    move-result v9

    invoke-virtual {v2}, Ljava/lang/Float;->floatValue()F

    move-result v10

    mul-float/2addr v9, v10

    sub-float/2addr v8, v9

    invoke-static {v8}, Ljava/lang/Float;->valueOf(F)Ljava/lang/Float;

    move-result-object v0

    goto :goto_0
.end method

.method public mapExternalYawToServo(Ljava/lang/Float;Ljava/lang/Boolean;F)Ljava/lang/String;
    .locals 7
    .param p1, "val"    # Ljava/lang/Float;
    .param p2, "isPanning"    # Ljava/lang/Boolean;
    .param p3, "deadband"    # F

    .prologue
    const/4 v6, 0x0

    const/high16 v5, 0x3f800000    # 1.0f

    .line 363
    invoke-static {v5}, Ljava/lang/Float;->valueOf(F)Ljava/lang/Float;

    move-result-object v1

    .line 364
    .local v1, "left_scale":Ljava/lang/Float;
    invoke-static {v5}, Ljava/lang/Float;->valueOf(F)Ljava/lang/Float;

    move-result-object v2

    .line 372
    .local v2, "right_scale":Ljava/lang/Float;
    invoke-virtual {p1}, Ljava/lang/Float;->floatValue()F

    move-result v3

    invoke-static {v3}, Ljava/lang/Math;->abs(F)F

    move-result v3

    invoke-static {v3}, Ljava/lang/Float;->valueOf(F)Ljava/lang/Float;

    move-result-object v0

    .line 373
    .local v0, "absolute_val":Ljava/lang/Float;
    invoke-virtual {p1}, Ljava/lang/Float;->floatValue()F

    move-result v3

    iget-object v4, p0, Lcom/brynk/fathom/helpers/CoordinateHelper;->EXTERNAL_NEUTRAL:Ljava/lang/Float;

    invoke-virtual {v4}, Ljava/lang/Float;->floatValue()F

    move-result v4

    cmpl-float v3, v3, v4

    if-lez v3, :cond_5

    .line 375
    invoke-virtual {v0}, Ljava/lang/Float;->floatValue()F

    move-result v3

    sub-float v3, v5, v3

    invoke-static {v3}, Ljava/lang/Math;->abs(F)F

    move-result v3

    invoke-static {v3}, Ljava/lang/Float;->valueOf(F)Ljava/lang/Float;

    move-result-object v2

    .line 381
    :cond_0
    :goto_0
    invoke-virtual {p2}, Ljava/lang/Boolean;->booleanValue()Z

    move-result v3

    if-eqz v3, :cond_3

    .line 382
    invoke-virtual {v1}, Ljava/lang/Float;->floatValue()F

    move-result v3

    cmpg-float v3, v3, v5

    if-gez v3, :cond_1

    invoke-virtual {v2}, Ljava/lang/Float;->floatValue()F

    move-result v3

    sub-float v3, v6, v3

    invoke-static {v3}, Ljava/lang/Float;->valueOf(F)Ljava/lang/Float;

    move-result-object v1

    .line 383
    :cond_1
    invoke-virtual {v2}, Ljava/lang/Float;->floatValue()F

    move-result v3

    cmpg-float v3, v3, v5

    if-gez v3, :cond_2

    invoke-virtual {v1}, Ljava/lang/Float;->floatValue()F

    move-result v3

    sub-float v3, v6, v3

    invoke-static {v3}, Ljava/lang/Float;->valueOf(F)Ljava/lang/Float;

    move-result-object v2

    .line 384
    :cond_2
    const-string v3, "FATHOM1"

    const-string v4, "PANNING"

    invoke-static {v3, v4}, Landroid/util/Log;->d(Ljava/lang/String;Ljava/lang/String;)I

    .line 390
    :cond_3
    invoke-virtual {v0}, Ljava/lang/Float;->floatValue()F

    move-result v3

    cmpg-float v3, v3, p3

    if-gez v3, :cond_4

    .line 392
    invoke-static {v5}, Ljava/lang/Float;->valueOf(F)Ljava/lang/Float;

    move-result-object v1

    .line 393
    invoke-static {v5}, Ljava/lang/Float;->valueOf(F)Ljava/lang/Float;

    move-result-object v2

    .line 397
    :cond_4
    new-instance v3, Ljava/lang/StringBuilder;

    invoke-direct {v3}, Ljava/lang/StringBuilder;-><init>()V

    invoke-virtual {v3, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    move-result-object v3

    const-string v4, ","

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    invoke-virtual {v3, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    move-result-object v3

    invoke-virtual {v3}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v3

    return-object v3

    .line 376
    :cond_5
    invoke-virtual {p1}, Ljava/lang/Float;->floatValue()F

    move-result v3

    iget-object v4, p0, Lcom/brynk/fathom/helpers/CoordinateHelper;->EXTERNAL_NEUTRAL:Ljava/lang/Float;

    invoke-virtual {v4}, Ljava/lang/Float;->floatValue()F

    move-result v4

    cmpg-float v3, v3, v4

    if-gez v3, :cond_0

    .line 377
    invoke-virtual {v0}, Ljava/lang/Float;->floatValue()F

    move-result v3

    sub-float v3, v5, v3

    invoke-static {v3}, Ljava/lang/Math;->abs(F)F

    move-result v3

    invoke-static {v3}, Ljava/lang/Float;->valueOf(F)Ljava/lang/Float;

    move-result-object v1

    goto :goto_0
.end method

.method public mapYawToServo(Ljava/lang/Float;Landroid/widget/TextView;Ljava/lang/Boolean;F)Ljava/lang/String;
    .locals 10
    .param p1, "val"    # Ljava/lang/Float;
    .param p2, "tv"    # Landroid/widget/TextView;
    .param p3, "isPanning"    # Ljava/lang/Boolean;
    .param p4, "deadband"    # F

    .prologue
    .line 180
    const/high16 v8, 0x3f800000    # 1.0f

    invoke-static {v8}, Ljava/lang/Float;->valueOf(F)Ljava/lang/Float;

    move-result-object v2

    .line 181
    .local v2, "left_scale":Ljava/lang/Float;
    const/high16 v8, 0x3f800000    # 1.0f

    invoke-static {v8}, Ljava/lang/Float;->valueOf(F)Ljava/lang/Float;

    move-result-object v3

    .line 189
    .local v3, "right_scale":Ljava/lang/Float;
    invoke-virtual {p2}, Landroid/widget/TextView;->getX()F

    move-result v8

    invoke-virtual {p2}, Landroid/widget/TextView;->getWidth()I

    move-result v9

    int-to-float v9, v9

    add-float/2addr v8, v9

    invoke-static {v8}, Ljava/lang/Float;->valueOf(F)Ljava/lang/Float;

    move-result-object v7

    .line 190
    .local v7, "tv_right":Ljava/lang/Float;
    invoke-virtual {p2}, Landroid/widget/TextView;->getX()F

    move-result v8

    invoke-static {v8}, Ljava/lang/Float;->valueOf(F)Ljava/lang/Float;

    move-result-object v5

    .line 191
    .local v5, "tv_left":Ljava/lang/Float;
    invoke-virtual {p2}, Landroid/widget/TextView;->getX()F

    move-result v8

    invoke-virtual {p2}, Landroid/widget/TextView;->getWidth()I

    move-result v9

    div-int/lit8 v9, v9, 0x2

    int-to-float v9, v9

    add-float/2addr v8, v9

    invoke-static {v8}, Ljava/lang/Float;->valueOf(F)Ljava/lang/Float;

    move-result-object v6

    .line 192
    .local v6, "tv_middle":Ljava/lang/Float;
    invoke-virtual {v7}, Ljava/lang/Float;->floatValue()F

    move-result v8

    invoke-virtual {v6}, Ljava/lang/Float;->floatValue()F

    move-result v9

    sub-float/2addr v8, v9

    invoke-static {v8}, Ljava/lang/Float;->valueOf(F)Ljava/lang/Float;

    move-result-object v4

    .line 193
    .local v4, "tv_half":Ljava/lang/Float;
    invoke-virtual {p1}, Ljava/lang/Float;->floatValue()F

    move-result v8

    invoke-virtual {v6}, Ljava/lang/Float;->floatValue()F

    move-result v9

    sub-float/2addr v8, v9

    invoke-static {v8}, Ljava/lang/Float;->valueOf(F)Ljava/lang/Float;

    move-result-object v1

    .line 197
    .local v1, "distance_from_middle":Ljava/lang/Float;
    invoke-virtual {p1}, Ljava/lang/Float;->floatValue()F

    move-result v8

    invoke-virtual {v6}, Ljava/lang/Float;->floatValue()F

    move-result v9

    cmpl-float v8, v8, v9

    if-lez v8, :cond_5

    .line 198
    invoke-virtual {v7}, Ljava/lang/Float;->floatValue()F

    move-result v8

    invoke-virtual {p1}, Ljava/lang/Float;->floatValue()F

    move-result v9

    sub-float/2addr v8, v9

    invoke-virtual {v4}, Ljava/lang/Float;->floatValue()F

    move-result v9

    div-float/2addr v8, v9

    invoke-static {v8}, Ljava/lang/Float;->valueOf(F)Ljava/lang/Float;

    move-result-object v0

    .line 199
    .local v0, "delta":Ljava/lang/Float;
    move-object v3, v0

    .line 210
    .end local v0    # "delta":Ljava/lang/Float;
    :cond_0
    :goto_0
    invoke-virtual {p3}, Ljava/lang/Boolean;->booleanValue()Z

    move-result v8

    if-eqz v8, :cond_3

    .line 211
    invoke-virtual {v2}, Ljava/lang/Float;->floatValue()F

    move-result v8

    const/high16 v9, 0x3f800000    # 1.0f

    cmpg-float v8, v8, v9

    if-gez v8, :cond_1

    const/4 v8, 0x0

    invoke-virtual {v3}, Ljava/lang/Float;->floatValue()F

    move-result v9

    sub-float/2addr v8, v9

    invoke-static {v8}, Ljava/lang/Float;->valueOf(F)Ljava/lang/Float;

    move-result-object v2

    .line 212
    :cond_1
    invoke-virtual {v3}, Ljava/lang/Float;->floatValue()F

    move-result v8

    const/high16 v9, 0x3f800000    # 1.0f

    cmpg-float v8, v8, v9

    if-gez v8, :cond_2

    const/4 v8, 0x0

    invoke-virtual {v2}, Ljava/lang/Float;->floatValue()F

    move-result v9

    sub-float/2addr v8, v9

    invoke-static {v8}, Ljava/lang/Float;->valueOf(F)Ljava/lang/Float;

    move-result-object v3

    .line 213
    :cond_2
    const-string v8, "FATHOM1"

    const-string v9, "PANNING"

    invoke-static {v8, v9}, Landroid/util/Log;->d(Ljava/lang/String;Ljava/lang/String;)I

    .line 219
    :cond_3
    invoke-virtual {v1}, Ljava/lang/Float;->floatValue()F

    move-result v8

    invoke-static {v8}, Ljava/lang/Math;->abs(F)F

    move-result v8

    cmpg-float v8, v8, p4

    if-gez v8, :cond_4

    .line 221
    const/high16 v8, 0x3f800000    # 1.0f

    invoke-static {v8}, Ljava/lang/Float;->valueOf(F)Ljava/lang/Float;

    move-result-object v2

    .line 222
    const/high16 v8, 0x3f800000    # 1.0f

    invoke-static {v8}, Ljava/lang/Float;->valueOf(F)Ljava/lang/Float;

    move-result-object v3

    .line 226
    :cond_4
    new-instance v8, Ljava/lang/StringBuilder;

    invoke-direct {v8}, Ljava/lang/StringBuilder;-><init>()V

    invoke-virtual {v8, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    move-result-object v8

    const-string v9, ","

    invoke-virtual {v8, v9}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v8

    invoke-virtual {v8, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    move-result-object v8

    invoke-virtual {v8}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v8

    return-object v8

    .line 203
    :cond_5
    invoke-virtual {p1}, Ljava/lang/Float;->floatValue()F

    move-result v8

    invoke-virtual {v6}, Ljava/lang/Float;->floatValue()F

    move-result v9

    cmpg-float v8, v8, v9

    if-gez v8, :cond_0

    .line 204
    invoke-virtual {p1}, Ljava/lang/Float;->floatValue()F

    move-result v8

    invoke-virtual {v5}, Ljava/lang/Float;->floatValue()F

    move-result v9

    sub-float/2addr v8, v9

    invoke-virtual {v4}, Ljava/lang/Float;->floatValue()F

    move-result v9

    div-float/2addr v8, v9

    invoke-static {v8}, Ljava/lang/Float;->valueOf(F)Ljava/lang/Float;

    move-result-object v0

    .line 205
    .restart local v0    # "delta":Ljava/lang/Float;
    move-object v2, v0

    goto/16 :goto_0
.end method

.method public setThrottle_max(Ljava/lang/Float;)V
    .locals 2
    .param p1, "v"    # Ljava/lang/Float;

    .prologue
    .line 261
    sget-object v0, Lcom/brynk/fathom/helpers/Constants;->SERVO_NEUTRAL:Ljava/lang/Float;

    invoke-virtual {v0}, Ljava/lang/Float;->floatValue()F

    move-result v0

    invoke-virtual {p1}, Ljava/lang/Float;->floatValue()F

    move-result v1

    sub-float/2addr v0, v1

    invoke-static {v0}, Ljava/lang/Float;->valueOf(F)Ljava/lang/Float;

    move-result-object v0

    iput-object v0, p0, Lcom/brynk/fathom/helpers/CoordinateHelper;->throttle_min:Ljava/lang/Float;

    .line 263
    return-void
.end method

.method public setThrottle_min(Ljava/lang/Float;)V
    .locals 2
    .param p1, "v"    # Ljava/lang/Float;

    .prologue
    .line 258
    sget-object v0, Lcom/brynk/fathom/helpers/Constants;->SERVO_NEUTRAL:Ljava/lang/Float;

    invoke-virtual {v0}, Ljava/lang/Float;->floatValue()F

    move-result v0

    invoke-virtual {p1}, Ljava/lang/Float;->floatValue()F

    move-result v1

    add-float/2addr v0, v1

    invoke-static {v0}, Ljava/lang/Float;->valueOf(F)Ljava/lang/Float;

    move-result-object v0

    iput-object v0, p0, Lcom/brynk/fathom/helpers/CoordinateHelper;->throttle_max:Ljava/lang/Float;

    .line 259
    return-void
.end method

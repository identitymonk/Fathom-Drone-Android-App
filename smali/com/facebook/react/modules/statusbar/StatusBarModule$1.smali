.class Lcom/facebook/react/modules/statusbar/StatusBarModule$1;
.super Lcom/facebook/react/bridge/GuardedRunnable;
.source "StatusBarModule.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/facebook/react/modules/statusbar/StatusBarModule;->setColor(IZ)V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$0:Lcom/facebook/react/modules/statusbar/StatusBarModule;

.field final synthetic val$activity:Landroid/app/Activity;

.field final synthetic val$animated:Z

.field final synthetic val$color:I


# direct methods
.method constructor <init>(Lcom/facebook/react/modules/statusbar/StatusBarModule;Lcom/facebook/react/bridge/ReactContext;Landroid/app/Activity;ZI)V
    .locals 0
    .param p1, "this$0"    # Lcom/facebook/react/modules/statusbar/StatusBarModule;
    .param p2, "reactContext"    # Lcom/facebook/react/bridge/ReactContext;

    .prologue
    .line 77
    iput-object p1, p0, Lcom/facebook/react/modules/statusbar/StatusBarModule$1;->this$0:Lcom/facebook/react/modules/statusbar/StatusBarModule;

    iput-object p3, p0, Lcom/facebook/react/modules/statusbar/StatusBarModule$1;->val$activity:Landroid/app/Activity;

    iput-boolean p4, p0, Lcom/facebook/react/modules/statusbar/StatusBarModule$1;->val$animated:Z

    iput p5, p0, Lcom/facebook/react/modules/statusbar/StatusBarModule$1;->val$color:I

    invoke-direct {p0, p2}, Lcom/facebook/react/bridge/GuardedRunnable;-><init>(Lcom/facebook/react/bridge/ReactContext;)V

    return-void
.end method


# virtual methods
.method public runGuarded()V
    .locals 6
    .annotation build Landroid/annotation/TargetApi;
        value = 0x15
    .end annotation

    .prologue
    .line 81
    iget-object v2, p0, Lcom/facebook/react/modules/statusbar/StatusBarModule$1;->val$activity:Landroid/app/Activity;

    .line 82
    invoke-virtual {v2}, Landroid/app/Activity;->getWindow()Landroid/view/Window;

    move-result-object v2

    const/high16 v3, -0x80000000

    .line 83
    invoke-virtual {v2, v3}, Landroid/view/Window;->addFlags(I)V

    .line 84
    iget-boolean v2, p0, Lcom/facebook/react/modules/statusbar/StatusBarModule$1;->val$animated:Z

    if-eqz v2, :cond_0

    .line 85
    iget-object v2, p0, Lcom/facebook/react/modules/statusbar/StatusBarModule$1;->val$activity:Landroid/app/Activity;

    invoke-virtual {v2}, Landroid/app/Activity;->getWindow()Landroid/view/Window;

    move-result-object v2

    invoke-virtual {v2}, Landroid/view/Window;->getStatusBarColor()I

    move-result v1

    .line 86
    .local v1, "curColor":I
    new-instance v2, Landroid/animation/ArgbEvaluator;

    invoke-direct {v2}, Landroid/animation/ArgbEvaluator;-><init>()V

    const/4 v3, 0x2

    new-array v3, v3, [Ljava/lang/Object;

    const/4 v4, 0x0

    .line 87
    invoke-static {v1}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v5

    aput-object v5, v3, v4

    const/4 v4, 0x1

    iget v5, p0, Lcom/facebook/react/modules/statusbar/StatusBarModule$1;->val$color:I

    invoke-static {v5}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v5

    aput-object v5, v3, v4

    invoke-static {v2, v3}, Landroid/animation/ValueAnimator;->ofObject(Landroid/animation/TypeEvaluator;[Ljava/lang/Object;)Landroid/animation/ValueAnimator;

    move-result-object v0

    .line 89
    .local v0, "colorAnimation":Landroid/animation/ValueAnimator;
    new-instance v2, Lcom/facebook/react/modules/statusbar/StatusBarModule$1$1;

    invoke-direct {v2, p0}, Lcom/facebook/react/modules/statusbar/StatusBarModule$1$1;-><init>(Lcom/facebook/react/modules/statusbar/StatusBarModule$1;)V

    invoke-virtual {v0, v2}, Landroid/animation/ValueAnimator;->addUpdateListener(Landroid/animation/ValueAnimator$AnimatorUpdateListener;)V

    .line 98
    const-wide/16 v2, 0x12c

    invoke-virtual {v0, v2, v3}, Landroid/animation/ValueAnimator;->setDuration(J)Landroid/animation/ValueAnimator;

    move-result-object v2

    const-wide/16 v4, 0x0

    invoke-virtual {v2, v4, v5}, Landroid/animation/ValueAnimator;->setStartDelay(J)V

    .line 99
    invoke-virtual {v0}, Landroid/animation/ValueAnimator;->start()V

    .line 103
    .end local v0    # "colorAnimation":Landroid/animation/ValueAnimator;
    .end local v1    # "curColor":I
    :goto_0
    return-void

    .line 101
    :cond_0
    iget-object v2, p0, Lcom/facebook/react/modules/statusbar/StatusBarModule$1;->val$activity:Landroid/app/Activity;

    invoke-virtual {v2}, Landroid/app/Activity;->getWindow()Landroid/view/Window;

    move-result-object v2

    iget v3, p0, Lcom/facebook/react/modules/statusbar/StatusBarModule$1;->val$color:I

    invoke-virtual {v2, v3}, Landroid/view/Window;->setStatusBarColor(I)V

    goto :goto_0
.end method

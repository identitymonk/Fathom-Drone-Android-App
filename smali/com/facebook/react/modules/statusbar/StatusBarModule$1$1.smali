.class Lcom/facebook/react/modules/statusbar/StatusBarModule$1$1;
.super Ljava/lang/Object;
.source "StatusBarModule.java"

# interfaces
.implements Landroid/animation/ValueAnimator$AnimatorUpdateListener;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/facebook/react/modules/statusbar/StatusBarModule$1;->runGuarded()V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$1:Lcom/facebook/react/modules/statusbar/StatusBarModule$1;


# direct methods
.method constructor <init>(Lcom/facebook/react/modules/statusbar/StatusBarModule$1;)V
    .locals 0
    .param p1, "this$1"    # Lcom/facebook/react/modules/statusbar/StatusBarModule$1;

    .prologue
    .line 90
    iput-object p1, p0, Lcom/facebook/react/modules/statusbar/StatusBarModule$1$1;->this$1:Lcom/facebook/react/modules/statusbar/StatusBarModule$1;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public onAnimationUpdate(Landroid/animation/ValueAnimator;)V
    .locals 2
    .param p1, "animator"    # Landroid/animation/ValueAnimator;

    .prologue
    .line 93
    iget-object v0, p0, Lcom/facebook/react/modules/statusbar/StatusBarModule$1$1;->this$1:Lcom/facebook/react/modules/statusbar/StatusBarModule$1;

    iget-object v0, v0, Lcom/facebook/react/modules/statusbar/StatusBarModule$1;->val$activity:Landroid/app/Activity;

    .line 94
    invoke-virtual {v0}, Landroid/app/Activity;->getWindow()Landroid/view/Window;

    move-result-object v1

    .line 95
    invoke-virtual {p1}, Landroid/animation/ValueAnimator;->getAnimatedValue()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Ljava/lang/Integer;

    invoke-virtual {v0}, Ljava/lang/Integer;->intValue()I

    move-result v0

    invoke-virtual {v1, v0}, Landroid/view/Window;->setStatusBarColor(I)V

    .line 96
    return-void
.end method

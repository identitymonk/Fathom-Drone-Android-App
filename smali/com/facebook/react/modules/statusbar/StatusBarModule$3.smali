.class Lcom/facebook/react/modules/statusbar/StatusBarModule$3;
.super Ljava/lang/Object;
.source "StatusBarModule.java"

# interfaces
.implements Ljava/lang/Runnable;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/facebook/react/modules/statusbar/StatusBarModule;->setHidden(Z)V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$0:Lcom/facebook/react/modules/statusbar/StatusBarModule;

.field final synthetic val$activity:Landroid/app/Activity;

.field final synthetic val$hidden:Z


# direct methods
.method constructor <init>(Lcom/facebook/react/modules/statusbar/StatusBarModule;ZLandroid/app/Activity;)V
    .locals 0
    .param p1, "this$0"    # Lcom/facebook/react/modules/statusbar/StatusBarModule;

    .prologue
    .line 155
    iput-object p1, p0, Lcom/facebook/react/modules/statusbar/StatusBarModule$3;->this$0:Lcom/facebook/react/modules/statusbar/StatusBarModule;

    iput-boolean p2, p0, Lcom/facebook/react/modules/statusbar/StatusBarModule$3;->val$hidden:Z

    iput-object p3, p0, Lcom/facebook/react/modules/statusbar/StatusBarModule$3;->val$activity:Landroid/app/Activity;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public run()V
    .locals 3

    .prologue
    const/16 v2, 0x800

    const/16 v1, 0x400

    .line 158
    iget-boolean v0, p0, Lcom/facebook/react/modules/statusbar/StatusBarModule$3;->val$hidden:Z

    if-eqz v0, :cond_0

    .line 159
    iget-object v0, p0, Lcom/facebook/react/modules/statusbar/StatusBarModule$3;->val$activity:Landroid/app/Activity;

    invoke-virtual {v0}, Landroid/app/Activity;->getWindow()Landroid/view/Window;

    move-result-object v0

    invoke-virtual {v0, v1}, Landroid/view/Window;->addFlags(I)V

    .line 160
    iget-object v0, p0, Lcom/facebook/react/modules/statusbar/StatusBarModule$3;->val$activity:Landroid/app/Activity;

    invoke-virtual {v0}, Landroid/app/Activity;->getWindow()Landroid/view/Window;

    move-result-object v0

    invoke-virtual {v0, v2}, Landroid/view/Window;->clearFlags(I)V

    .line 165
    :goto_0
    return-void

    .line 162
    :cond_0
    iget-object v0, p0, Lcom/facebook/react/modules/statusbar/StatusBarModule$3;->val$activity:Landroid/app/Activity;

    invoke-virtual {v0}, Landroid/app/Activity;->getWindow()Landroid/view/Window;

    move-result-object v0

    invoke-virtual {v0, v2}, Landroid/view/Window;->addFlags(I)V

    .line 163
    iget-object v0, p0, Lcom/facebook/react/modules/statusbar/StatusBarModule$3;->val$activity:Landroid/app/Activity;

    invoke-virtual {v0}, Landroid/app/Activity;->getWindow()Landroid/view/Window;

    move-result-object v0

    invoke-virtual {v0, v1}, Landroid/view/Window;->clearFlags(I)V

    goto :goto_0
.end method

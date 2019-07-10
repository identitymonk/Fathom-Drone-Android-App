.class Lcom/facebook/react/modules/statusbar/StatusBarModule$4;
.super Ljava/lang/Object;
.source "StatusBarModule.java"

# interfaces
.implements Ljava/lang/Runnable;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/facebook/react/modules/statusbar/StatusBarModule;->setStyle(Ljava/lang/String;)V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$0:Lcom/facebook/react/modules/statusbar/StatusBarModule;

.field final synthetic val$activity:Landroid/app/Activity;

.field final synthetic val$style:Ljava/lang/String;


# direct methods
.method constructor <init>(Lcom/facebook/react/modules/statusbar/StatusBarModule;Landroid/app/Activity;Ljava/lang/String;)V
    .locals 0
    .param p1, "this$0"    # Lcom/facebook/react/modules/statusbar/StatusBarModule;

    .prologue
    .line 179
    iput-object p1, p0, Lcom/facebook/react/modules/statusbar/StatusBarModule$4;->this$0:Lcom/facebook/react/modules/statusbar/StatusBarModule;

    iput-object p2, p0, Lcom/facebook/react/modules/statusbar/StatusBarModule$4;->val$activity:Landroid/app/Activity;

    iput-object p3, p0, Lcom/facebook/react/modules/statusbar/StatusBarModule$4;->val$style:Ljava/lang/String;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public run()V
    .locals 3
    .annotation build Landroid/annotation/TargetApi;
        value = 0x17
    .end annotation

    .prologue
    .line 183
    iget-object v1, p0, Lcom/facebook/react/modules/statusbar/StatusBarModule$4;->val$activity:Landroid/app/Activity;

    invoke-virtual {v1}, Landroid/app/Activity;->getWindow()Landroid/view/Window;

    move-result-object v1

    invoke-virtual {v1}, Landroid/view/Window;->getDecorView()Landroid/view/View;

    move-result-object v0

    .line 184
    .local v0, "decorView":Landroid/view/View;
    iget-object v1, p0, Lcom/facebook/react/modules/statusbar/StatusBarModule$4;->val$style:Ljava/lang/String;

    const-string v2, "dark-content"

    .line 185
    invoke-virtual {v1, v2}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v1

    if-eqz v1, :cond_0

    const/16 v1, 0x2000

    .line 184
    :goto_0
    invoke-virtual {v0, v1}, Landroid/view/View;->setSystemUiVisibility(I)V

    .line 186
    return-void

    .line 185
    :cond_0
    const/4 v1, 0x0

    goto :goto_0
.end method

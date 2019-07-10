.class Lcom/facebook/react/ReactInstanceManager$3$1;
.super Ljava/lang/Object;
.source "ReactInstanceManager.java"

# interfaces
.implements Ljava/lang/Runnable;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/facebook/react/ReactInstanceManager$3;->onPackagerStatusFetched(Z)V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$1:Lcom/facebook/react/ReactInstanceManager$3;

.field final synthetic val$packagerIsRunning:Z


# direct methods
.method constructor <init>(Lcom/facebook/react/ReactInstanceManager$3;Z)V
    .locals 0
    .param p1, "this$1"    # Lcom/facebook/react/ReactInstanceManager$3;

    .prologue
    .line 439
    iput-object p1, p0, Lcom/facebook/react/ReactInstanceManager$3$1;->this$1:Lcom/facebook/react/ReactInstanceManager$3;

    iput-boolean p2, p0, Lcom/facebook/react/ReactInstanceManager$3$1;->val$packagerIsRunning:Z

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public run()V
    .locals 2

    .prologue
    .line 442
    iget-boolean v0, p0, Lcom/facebook/react/ReactInstanceManager$3$1;->val$packagerIsRunning:Z

    if-eqz v0, :cond_0

    .line 443
    iget-object v0, p0, Lcom/facebook/react/ReactInstanceManager$3$1;->this$1:Lcom/facebook/react/ReactInstanceManager$3;

    iget-object v0, v0, Lcom/facebook/react/ReactInstanceManager$3;->this$0:Lcom/facebook/react/ReactInstanceManager;

    invoke-static {v0}, Lcom/facebook/react/ReactInstanceManager;->access$400(Lcom/facebook/react/ReactInstanceManager;)Lcom/facebook/react/devsupport/interfaces/DevSupportManager;

    move-result-object v0

    invoke-interface {v0}, Lcom/facebook/react/devsupport/interfaces/DevSupportManager;->handleReloadJS()V

    .line 449
    :goto_0
    return-void

    .line 446
    :cond_0
    iget-object v0, p0, Lcom/facebook/react/ReactInstanceManager$3$1;->this$1:Lcom/facebook/react/ReactInstanceManager$3;

    iget-object v0, v0, Lcom/facebook/react/ReactInstanceManager$3;->val$devSettings:Lcom/facebook/react/modules/debug/interfaces/DeveloperSettings;

    const/4 v1, 0x0

    invoke-interface {v0, v1}, Lcom/facebook/react/modules/debug/interfaces/DeveloperSettings;->setRemoteJSDebugEnabled(Z)V

    .line 447
    iget-object v0, p0, Lcom/facebook/react/ReactInstanceManager$3$1;->this$1:Lcom/facebook/react/ReactInstanceManager$3;

    iget-object v0, v0, Lcom/facebook/react/ReactInstanceManager$3;->this$0:Lcom/facebook/react/ReactInstanceManager;

    invoke-static {v0}, Lcom/facebook/react/ReactInstanceManager;->access$500(Lcom/facebook/react/ReactInstanceManager;)V

    goto :goto_0
.end method

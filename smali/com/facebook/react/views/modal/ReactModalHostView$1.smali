.class Lcom/facebook/react/views/modal/ReactModalHostView$1;
.super Ljava/lang/Object;
.source "ReactModalHostView.java"

# interfaces
.implements Landroid/content/DialogInterface$OnKeyListener;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/facebook/react/views/modal/ReactModalHostView;->showOrUpdate()V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$0:Lcom/facebook/react/views/modal/ReactModalHostView;


# direct methods
.method constructor <init>(Lcom/facebook/react/views/modal/ReactModalHostView;)V
    .locals 0
    .param p1, "this$0"    # Lcom/facebook/react/views/modal/ReactModalHostView;

    .prologue
    .line 219
    iput-object p1, p0, Lcom/facebook/react/views/modal/ReactModalHostView$1;->this$0:Lcom/facebook/react/views/modal/ReactModalHostView;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public onKey(Landroid/content/DialogInterface;ILandroid/view/KeyEvent;)Z
    .locals 4
    .param p1, "dialog"    # Landroid/content/DialogInterface;
    .param p2, "keyCode"    # I
    .param p3, "event"    # Landroid/view/KeyEvent;

    .prologue
    const/4 v1, 0x1

    .line 222
    invoke-virtual {p3}, Landroid/view/KeyEvent;->getAction()I

    move-result v2

    if-ne v2, v1, :cond_1

    .line 227
    const/4 v2, 0x4

    if-ne p2, v2, :cond_0

    .line 228
    iget-object v2, p0, Lcom/facebook/react/views/modal/ReactModalHostView$1;->this$0:Lcom/facebook/react/views/modal/ReactModalHostView;

    .line 229
    invoke-static {v2}, Lcom/facebook/react/views/modal/ReactModalHostView;->access$000(Lcom/facebook/react/views/modal/ReactModalHostView;)Lcom/facebook/react/views/modal/ReactModalHostView$OnRequestCloseListener;

    move-result-object v2

    const-string v3, "setOnRequestCloseListener must be called by the manager"

    .line 228
    invoke-static {v2, v3}, Lcom/facebook/infer/annotation/Assertions;->assertNotNull(Ljava/lang/Object;Ljava/lang/String;)Ljava/lang/Object;

    .line 231
    iget-object v2, p0, Lcom/facebook/react/views/modal/ReactModalHostView$1;->this$0:Lcom/facebook/react/views/modal/ReactModalHostView;

    invoke-static {v2}, Lcom/facebook/react/views/modal/ReactModalHostView;->access$000(Lcom/facebook/react/views/modal/ReactModalHostView;)Lcom/facebook/react/views/modal/ReactModalHostView$OnRequestCloseListener;

    move-result-object v2

    invoke-interface {v2, p1}, Lcom/facebook/react/views/modal/ReactModalHostView$OnRequestCloseListener;->onRequestClose(Landroid/content/DialogInterface;)V

    .line 242
    :goto_0
    return v1

    .line 236
    :cond_0
    iget-object v1, p0, Lcom/facebook/react/views/modal/ReactModalHostView$1;->this$0:Lcom/facebook/react/views/modal/ReactModalHostView;

    invoke-virtual {v1}, Lcom/facebook/react/views/modal/ReactModalHostView;->getContext()Landroid/content/Context;

    move-result-object v1

    check-cast v1, Lcom/facebook/react/bridge/ReactContext;

    invoke-virtual {v1}, Lcom/facebook/react/bridge/ReactContext;->getCurrentActivity()Landroid/app/Activity;

    move-result-object v0

    .line 237
    .local v0, "currentActivity":Landroid/app/Activity;
    if-eqz v0, :cond_1

    .line 238
    invoke-virtual {v0, p2, p3}, Landroid/app/Activity;->onKeyUp(ILandroid/view/KeyEvent;)Z

    move-result v1

    goto :goto_0

    .line 242
    .end local v0    # "currentActivity":Landroid/app/Activity;
    :cond_1
    const/4 v1, 0x0

    goto :goto_0
.end method

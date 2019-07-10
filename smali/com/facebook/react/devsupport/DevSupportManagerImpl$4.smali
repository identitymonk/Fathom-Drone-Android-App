.class Lcom/facebook/react/devsupport/DevSupportManagerImpl$4;
.super Ljava/lang/Object;
.source "DevSupportManagerImpl.java"

# interfaces
.implements Ljava/lang/Runnable;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/facebook/react/devsupport/DevSupportManagerImpl;->showNewError(Ljava/lang/String;[Lcom/facebook/react/devsupport/interfaces/StackFrame;ILcom/facebook/react/devsupport/DevSupportManagerImpl$ErrorType;)V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$0:Lcom/facebook/react/devsupport/DevSupportManagerImpl;

.field final synthetic val$errorCookie:I

.field final synthetic val$errorType:Lcom/facebook/react/devsupport/DevSupportManagerImpl$ErrorType;

.field final synthetic val$message:Ljava/lang/String;

.field final synthetic val$stack:[Lcom/facebook/react/devsupport/interfaces/StackFrame;


# direct methods
.method constructor <init>(Lcom/facebook/react/devsupport/DevSupportManagerImpl;Ljava/lang/String;[Lcom/facebook/react/devsupport/interfaces/StackFrame;ILcom/facebook/react/devsupport/DevSupportManagerImpl$ErrorType;)V
    .locals 0
    .param p1, "this$0"    # Lcom/facebook/react/devsupport/DevSupportManagerImpl;

    .prologue
    .line 362
    iput-object p1, p0, Lcom/facebook/react/devsupport/DevSupportManagerImpl$4;->this$0:Lcom/facebook/react/devsupport/DevSupportManagerImpl;

    iput-object p2, p0, Lcom/facebook/react/devsupport/DevSupportManagerImpl$4;->val$message:Ljava/lang/String;

    iput-object p3, p0, Lcom/facebook/react/devsupport/DevSupportManagerImpl$4;->val$stack:[Lcom/facebook/react/devsupport/interfaces/StackFrame;

    iput p4, p0, Lcom/facebook/react/devsupport/DevSupportManagerImpl$4;->val$errorCookie:I

    iput-object p5, p0, Lcom/facebook/react/devsupport/DevSupportManagerImpl$4;->val$errorType:Lcom/facebook/react/devsupport/DevSupportManagerImpl$ErrorType;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public run()V
    .locals 6

    .prologue
    .line 365
    iget-object v1, p0, Lcom/facebook/react/devsupport/DevSupportManagerImpl$4;->this$0:Lcom/facebook/react/devsupport/DevSupportManagerImpl;

    invoke-static {v1}, Lcom/facebook/react/devsupport/DevSupportManagerImpl;->access$200(Lcom/facebook/react/devsupport/DevSupportManagerImpl;)Lcom/facebook/react/devsupport/RedBoxDialog;

    move-result-object v1

    if-nez v1, :cond_0

    .line 366
    iget-object v1, p0, Lcom/facebook/react/devsupport/DevSupportManagerImpl$4;->this$0:Lcom/facebook/react/devsupport/DevSupportManagerImpl;

    new-instance v2, Lcom/facebook/react/devsupport/RedBoxDialog;

    iget-object v3, p0, Lcom/facebook/react/devsupport/DevSupportManagerImpl$4;->this$0:Lcom/facebook/react/devsupport/DevSupportManagerImpl;

    invoke-static {v3}, Lcom/facebook/react/devsupport/DevSupportManagerImpl;->access$700(Lcom/facebook/react/devsupport/DevSupportManagerImpl;)Landroid/content/Context;

    move-result-object v3

    iget-object v4, p0, Lcom/facebook/react/devsupport/DevSupportManagerImpl$4;->this$0:Lcom/facebook/react/devsupport/DevSupportManagerImpl;

    iget-object v5, p0, Lcom/facebook/react/devsupport/DevSupportManagerImpl$4;->this$0:Lcom/facebook/react/devsupport/DevSupportManagerImpl;

    invoke-static {v5}, Lcom/facebook/react/devsupport/DevSupportManagerImpl;->access$600(Lcom/facebook/react/devsupport/DevSupportManagerImpl;)Lcom/facebook/react/devsupport/RedBoxHandler;

    move-result-object v5

    invoke-direct {v2, v3, v4, v5}, Lcom/facebook/react/devsupport/RedBoxDialog;-><init>(Landroid/content/Context;Lcom/facebook/react/devsupport/interfaces/DevSupportManager;Lcom/facebook/react/devsupport/RedBoxHandler;)V

    invoke-static {v1, v2}, Lcom/facebook/react/devsupport/DevSupportManagerImpl;->access$202(Lcom/facebook/react/devsupport/DevSupportManagerImpl;Lcom/facebook/react/devsupport/RedBoxDialog;)Lcom/facebook/react/devsupport/RedBoxDialog;

    .line 367
    iget-object v1, p0, Lcom/facebook/react/devsupport/DevSupportManagerImpl$4;->this$0:Lcom/facebook/react/devsupport/DevSupportManagerImpl;

    invoke-static {v1}, Lcom/facebook/react/devsupport/DevSupportManagerImpl;->access$200(Lcom/facebook/react/devsupport/DevSupportManagerImpl;)Lcom/facebook/react/devsupport/RedBoxDialog;

    move-result-object v1

    invoke-virtual {v1}, Lcom/facebook/react/devsupport/RedBoxDialog;->getWindow()Landroid/view/Window;

    move-result-object v1

    sget v2, Lcom/facebook/react/devsupport/WindowOverlayCompat;->TYPE_SYSTEM_ALERT:I

    invoke-virtual {v1, v2}, Landroid/view/Window;->setType(I)V

    .line 369
    :cond_0
    iget-object v1, p0, Lcom/facebook/react/devsupport/DevSupportManagerImpl$4;->this$0:Lcom/facebook/react/devsupport/DevSupportManagerImpl;

    invoke-static {v1}, Lcom/facebook/react/devsupport/DevSupportManagerImpl;->access$200(Lcom/facebook/react/devsupport/DevSupportManagerImpl;)Lcom/facebook/react/devsupport/RedBoxDialog;

    move-result-object v1

    invoke-virtual {v1}, Lcom/facebook/react/devsupport/RedBoxDialog;->isShowing()Z

    move-result v1

    if-eqz v1, :cond_1

    .line 386
    :goto_0
    return-void

    .line 374
    :cond_1
    iget-object v1, p0, Lcom/facebook/react/devsupport/DevSupportManagerImpl$4;->this$0:Lcom/facebook/react/devsupport/DevSupportManagerImpl;

    iget-object v2, p0, Lcom/facebook/react/devsupport/DevSupportManagerImpl$4;->val$message:Ljava/lang/String;

    iget-object v3, p0, Lcom/facebook/react/devsupport/DevSupportManagerImpl$4;->val$stack:[Lcom/facebook/react/devsupport/interfaces/StackFrame;

    invoke-static {v2, v3}, Landroid/util/Pair;->create(Ljava/lang/Object;Ljava/lang/Object;)Landroid/util/Pair;

    move-result-object v2

    invoke-static {v1, v2}, Lcom/facebook/react/devsupport/DevSupportManagerImpl;->access$400(Lcom/facebook/react/devsupport/DevSupportManagerImpl;Landroid/util/Pair;)Landroid/util/Pair;

    move-result-object v0

    .line 375
    .local v0, "errorInfo":Landroid/util/Pair;, "Landroid/util/Pair<Ljava/lang/String;[Lcom/facebook/react/devsupport/interfaces/StackFrame;>;"
    iget-object v1, p0, Lcom/facebook/react/devsupport/DevSupportManagerImpl$4;->this$0:Lcom/facebook/react/devsupport/DevSupportManagerImpl;

    invoke-static {v1}, Lcom/facebook/react/devsupport/DevSupportManagerImpl;->access$200(Lcom/facebook/react/devsupport/DevSupportManagerImpl;)Lcom/facebook/react/devsupport/RedBoxDialog;

    move-result-object v3

    iget-object v1, v0, Landroid/util/Pair;->first:Ljava/lang/Object;

    check-cast v1, Ljava/lang/String;

    iget-object v2, v0, Landroid/util/Pair;->second:Ljava/lang/Object;

    check-cast v2, [Lcom/facebook/react/devsupport/interfaces/StackFrame;

    invoke-virtual {v3, v1, v2}, Lcom/facebook/react/devsupport/RedBoxDialog;->setExceptionDetails(Ljava/lang/String;[Lcom/facebook/react/devsupport/interfaces/StackFrame;)V

    .line 376
    iget-object v1, p0, Lcom/facebook/react/devsupport/DevSupportManagerImpl$4;->this$0:Lcom/facebook/react/devsupport/DevSupportManagerImpl;

    iget-object v2, p0, Lcom/facebook/react/devsupport/DevSupportManagerImpl$4;->val$message:Ljava/lang/String;

    iget-object v3, p0, Lcom/facebook/react/devsupport/DevSupportManagerImpl$4;->val$stack:[Lcom/facebook/react/devsupport/interfaces/StackFrame;

    iget v4, p0, Lcom/facebook/react/devsupport/DevSupportManagerImpl$4;->val$errorCookie:I

    iget-object v5, p0, Lcom/facebook/react/devsupport/DevSupportManagerImpl$4;->val$errorType:Lcom/facebook/react/devsupport/DevSupportManagerImpl$ErrorType;

    invoke-static {v1, v2, v3, v4, v5}, Lcom/facebook/react/devsupport/DevSupportManagerImpl;->access$500(Lcom/facebook/react/devsupport/DevSupportManagerImpl;Ljava/lang/String;[Lcom/facebook/react/devsupport/interfaces/StackFrame;ILcom/facebook/react/devsupport/DevSupportManagerImpl$ErrorType;)V

    .line 379
    iget-object v1, p0, Lcom/facebook/react/devsupport/DevSupportManagerImpl$4;->this$0:Lcom/facebook/react/devsupport/DevSupportManagerImpl;

    invoke-static {v1}, Lcom/facebook/react/devsupport/DevSupportManagerImpl;->access$600(Lcom/facebook/react/devsupport/DevSupportManagerImpl;)Lcom/facebook/react/devsupport/RedBoxHandler;

    move-result-object v1

    if-eqz v1, :cond_2

    iget-object v1, p0, Lcom/facebook/react/devsupport/DevSupportManagerImpl$4;->val$errorType:Lcom/facebook/react/devsupport/DevSupportManagerImpl$ErrorType;

    sget-object v2, Lcom/facebook/react/devsupport/DevSupportManagerImpl$ErrorType;->NATIVE:Lcom/facebook/react/devsupport/DevSupportManagerImpl$ErrorType;

    if-ne v1, v2, :cond_2

    .line 380
    iget-object v1, p0, Lcom/facebook/react/devsupport/DevSupportManagerImpl$4;->this$0:Lcom/facebook/react/devsupport/DevSupportManagerImpl;

    invoke-static {v1}, Lcom/facebook/react/devsupport/DevSupportManagerImpl;->access$600(Lcom/facebook/react/devsupport/DevSupportManagerImpl;)Lcom/facebook/react/devsupport/RedBoxHandler;

    move-result-object v1

    iget-object v2, p0, Lcom/facebook/react/devsupport/DevSupportManagerImpl$4;->val$message:Ljava/lang/String;

    iget-object v3, p0, Lcom/facebook/react/devsupport/DevSupportManagerImpl$4;->val$stack:[Lcom/facebook/react/devsupport/interfaces/StackFrame;

    sget-object v4, Lcom/facebook/react/devsupport/RedBoxHandler$ErrorType;->NATIVE:Lcom/facebook/react/devsupport/RedBoxHandler$ErrorType;

    invoke-interface {v1, v2, v3, v4}, Lcom/facebook/react/devsupport/RedBoxHandler;->handleRedbox(Ljava/lang/String;[Lcom/facebook/react/devsupport/interfaces/StackFrame;Lcom/facebook/react/devsupport/RedBoxHandler$ErrorType;)V

    .line 381
    iget-object v1, p0, Lcom/facebook/react/devsupport/DevSupportManagerImpl$4;->this$0:Lcom/facebook/react/devsupport/DevSupportManagerImpl;

    invoke-static {v1}, Lcom/facebook/react/devsupport/DevSupportManagerImpl;->access$200(Lcom/facebook/react/devsupport/DevSupportManagerImpl;)Lcom/facebook/react/devsupport/RedBoxDialog;

    move-result-object v1

    const/4 v2, 0x1

    invoke-virtual {v1, v2}, Lcom/facebook/react/devsupport/RedBoxDialog;->resetReporting(Z)V

    .line 385
    :goto_1
    iget-object v1, p0, Lcom/facebook/react/devsupport/DevSupportManagerImpl$4;->this$0:Lcom/facebook/react/devsupport/DevSupportManagerImpl;

    invoke-static {v1}, Lcom/facebook/react/devsupport/DevSupportManagerImpl;->access$200(Lcom/facebook/react/devsupport/DevSupportManagerImpl;)Lcom/facebook/react/devsupport/RedBoxDialog;

    move-result-object v1

    invoke-virtual {v1}, Lcom/facebook/react/devsupport/RedBoxDialog;->show()V

    goto :goto_0

    .line 383
    :cond_2
    iget-object v1, p0, Lcom/facebook/react/devsupport/DevSupportManagerImpl$4;->this$0:Lcom/facebook/react/devsupport/DevSupportManagerImpl;

    invoke-static {v1}, Lcom/facebook/react/devsupport/DevSupportManagerImpl;->access$200(Lcom/facebook/react/devsupport/DevSupportManagerImpl;)Lcom/facebook/react/devsupport/RedBoxDialog;

    move-result-object v1

    const/4 v2, 0x0

    invoke-virtual {v1, v2}, Lcom/facebook/react/devsupport/RedBoxDialog;->resetReporting(Z)V

    goto :goto_1
.end method

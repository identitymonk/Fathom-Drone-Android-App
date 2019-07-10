.class Lcom/facebook/react/devsupport/WebsocketJavaScriptExecutor$2;
.super Ljava/lang/Object;
.source "WebsocketJavaScriptExecutor.java"

# interfaces
.implements Lcom/facebook/react/devsupport/JSDebuggerWebSocketClient$JSDebuggerCallback;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/facebook/react/devsupport/WebsocketJavaScriptExecutor;->connectInternal(Ljava/lang/String;Lcom/facebook/react/devsupport/WebsocketJavaScriptExecutor$JSExecutorConnectCallback;)V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field private didSendResult:Z

.field final synthetic this$0:Lcom/facebook/react/devsupport/WebsocketJavaScriptExecutor;

.field final synthetic val$callback:Lcom/facebook/react/devsupport/WebsocketJavaScriptExecutor$JSExecutorConnectCallback;

.field final synthetic val$client:Lcom/facebook/react/devsupport/JSDebuggerWebSocketClient;

.field final synthetic val$timeoutHandler:Landroid/os/Handler;


# direct methods
.method constructor <init>(Lcom/facebook/react/devsupport/WebsocketJavaScriptExecutor;Lcom/facebook/react/devsupport/JSDebuggerWebSocketClient;Landroid/os/Handler;Lcom/facebook/react/devsupport/WebsocketJavaScriptExecutor$JSExecutorConnectCallback;)V
    .locals 1
    .param p1, "this$0"    # Lcom/facebook/react/devsupport/WebsocketJavaScriptExecutor;

    .prologue
    .line 103
    iput-object p1, p0, Lcom/facebook/react/devsupport/WebsocketJavaScriptExecutor$2;->this$0:Lcom/facebook/react/devsupport/WebsocketJavaScriptExecutor;

    iput-object p2, p0, Lcom/facebook/react/devsupport/WebsocketJavaScriptExecutor$2;->val$client:Lcom/facebook/react/devsupport/JSDebuggerWebSocketClient;

    iput-object p3, p0, Lcom/facebook/react/devsupport/WebsocketJavaScriptExecutor$2;->val$timeoutHandler:Landroid/os/Handler;

    iput-object p4, p0, Lcom/facebook/react/devsupport/WebsocketJavaScriptExecutor$2;->val$callback:Lcom/facebook/react/devsupport/WebsocketJavaScriptExecutor$JSExecutorConnectCallback;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 106
    const/4 v0, 0x0

    iput-boolean v0, p0, Lcom/facebook/react/devsupport/WebsocketJavaScriptExecutor$2;->didSendResult:Z

    return-void
.end method

.method static synthetic access$200(Lcom/facebook/react/devsupport/WebsocketJavaScriptExecutor$2;)Z
    .locals 1
    .param p0, "x0"    # Lcom/facebook/react/devsupport/WebsocketJavaScriptExecutor$2;

    .prologue
    .line 103
    iget-boolean v0, p0, Lcom/facebook/react/devsupport/WebsocketJavaScriptExecutor$2;->didSendResult:Z

    return v0
.end method

.method static synthetic access$202(Lcom/facebook/react/devsupport/WebsocketJavaScriptExecutor$2;Z)Z
    .locals 0
    .param p0, "x0"    # Lcom/facebook/react/devsupport/WebsocketJavaScriptExecutor$2;
    .param p1, "x1"    # Z

    .prologue
    .line 103
    iput-boolean p1, p0, Lcom/facebook/react/devsupport/WebsocketJavaScriptExecutor$2;->didSendResult:Z

    return p1
.end method


# virtual methods
.method public onFailure(Ljava/lang/Throwable;)V
    .locals 2
    .param p1, "cause"    # Ljava/lang/Throwable;

    .prologue
    .line 135
    iget-object v0, p0, Lcom/facebook/react/devsupport/WebsocketJavaScriptExecutor$2;->val$timeoutHandler:Landroid/os/Handler;

    const/4 v1, 0x0

    invoke-virtual {v0, v1}, Landroid/os/Handler;->removeCallbacksAndMessages(Ljava/lang/Object;)V

    .line 136
    iget-boolean v0, p0, Lcom/facebook/react/devsupport/WebsocketJavaScriptExecutor$2;->didSendResult:Z

    if-nez v0, :cond_0

    .line 137
    iget-object v0, p0, Lcom/facebook/react/devsupport/WebsocketJavaScriptExecutor$2;->val$callback:Lcom/facebook/react/devsupport/WebsocketJavaScriptExecutor$JSExecutorConnectCallback;

    invoke-interface {v0, p1}, Lcom/facebook/react/devsupport/WebsocketJavaScriptExecutor$JSExecutorConnectCallback;->onFailure(Ljava/lang/Throwable;)V

    .line 138
    const/4 v0, 0x1

    iput-boolean v0, p0, Lcom/facebook/react/devsupport/WebsocketJavaScriptExecutor$2;->didSendResult:Z

    .line 140
    :cond_0
    return-void
.end method

.method public onSuccess(Ljava/lang/String;)V
    .locals 2
    .param p1, "response"    # Ljava/lang/String;
        .annotation runtime Ljavax/annotation/Nullable;
        .end annotation
    .end param

    .prologue
    .line 110
    iget-object v0, p0, Lcom/facebook/react/devsupport/WebsocketJavaScriptExecutor$2;->val$client:Lcom/facebook/react/devsupport/JSDebuggerWebSocketClient;

    new-instance v1, Lcom/facebook/react/devsupport/WebsocketJavaScriptExecutor$2$1;

    invoke-direct {v1, p0}, Lcom/facebook/react/devsupport/WebsocketJavaScriptExecutor$2$1;-><init>(Lcom/facebook/react/devsupport/WebsocketJavaScriptExecutor$2;)V

    invoke-virtual {v0, v1}, Lcom/facebook/react/devsupport/JSDebuggerWebSocketClient;->prepareJSRuntime(Lcom/facebook/react/devsupport/JSDebuggerWebSocketClient$JSDebuggerCallback;)V

    .line 131
    return-void
.end method

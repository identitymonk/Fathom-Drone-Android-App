.class Lcom/facebook/react/ReactInstanceManager$1;
.super Ljava/lang/Object;
.source "ReactInstanceManager.java"

# interfaces
.implements Lcom/facebook/react/devsupport/ReactInstanceDevCommandsHandler;


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/facebook/react/ReactInstanceManager;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$0:Lcom/facebook/react/ReactInstanceManager;


# direct methods
.method constructor <init>(Lcom/facebook/react/ReactInstanceManager;)V
    .locals 0
    .param p1, "this$0"    # Lcom/facebook/react/ReactInstanceManager;

    .prologue
    .line 165
    iput-object p1, p0, Lcom/facebook/react/ReactInstanceManager$1;->this$0:Lcom/facebook/react/ReactInstanceManager;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public onJSBundleLoadedFromServer()V
    .locals 1

    .prologue
    .line 174
    iget-object v0, p0, Lcom/facebook/react/ReactInstanceManager$1;->this$0:Lcom/facebook/react/ReactInstanceManager;

    invoke-static {v0}, Lcom/facebook/react/ReactInstanceManager;->access$100(Lcom/facebook/react/ReactInstanceManager;)V

    .line 175
    return-void
.end method

.method public onReloadWithJSDebugger(Lcom/facebook/react/bridge/JavaJSExecutor$Factory;)V
    .locals 1
    .param p1, "jsExecutorFactory"    # Lcom/facebook/react/bridge/JavaJSExecutor$Factory;

    .prologue
    .line 169
    iget-object v0, p0, Lcom/facebook/react/ReactInstanceManager$1;->this$0:Lcom/facebook/react/ReactInstanceManager;

    invoke-static {v0, p1}, Lcom/facebook/react/ReactInstanceManager;->access$000(Lcom/facebook/react/ReactInstanceManager;Lcom/facebook/react/bridge/JavaJSExecutor$Factory;)V

    .line 170
    return-void
.end method

.method public toggleElementInspector()V
    .locals 1

    .prologue
    .line 179
    iget-object v0, p0, Lcom/facebook/react/ReactInstanceManager$1;->this$0:Lcom/facebook/react/ReactInstanceManager;

    invoke-static {v0}, Lcom/facebook/react/ReactInstanceManager;->access$200(Lcom/facebook/react/ReactInstanceManager;)V

    .line 180
    return-void
.end method

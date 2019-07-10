.class Lcom/facebook/react/ReactInstanceManager$4;
.super Ljava/lang/Object;
.source "ReactInstanceManager.java"

# interfaces
.implements Ljava/lang/Runnable;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/facebook/react/ReactInstanceManager;->runCreateReactContextOnNewThread(Lcom/facebook/react/ReactInstanceManager$ReactContextInitParams;)V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$0:Lcom/facebook/react/ReactInstanceManager;

.field final synthetic val$initParams:Lcom/facebook/react/ReactInstanceManager$ReactContextInitParams;


# direct methods
.method constructor <init>(Lcom/facebook/react/ReactInstanceManager;Lcom/facebook/react/ReactInstanceManager$ReactContextInitParams;)V
    .locals 0
    .param p1, "this$0"    # Lcom/facebook/react/ReactInstanceManager;

    .prologue
    .line 903
    iput-object p1, p0, Lcom/facebook/react/ReactInstanceManager$4;->this$0:Lcom/facebook/react/ReactInstanceManager;

    iput-object p2, p0, Lcom/facebook/react/ReactInstanceManager$4;->val$initParams:Lcom/facebook/react/ReactInstanceManager$ReactContextInitParams;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public run()V
    .locals 7

    .prologue
    .line 906
    sget-object v4, Lcom/facebook/react/bridge/ReactMarkerConstants;->REACT_CONTEXT_THREAD_END:Lcom/facebook/react/bridge/ReactMarkerConstants;

    invoke-static {v4}, Lcom/facebook/react/bridge/ReactMarker;->logMarker(Lcom/facebook/react/bridge/ReactMarkerConstants;)V

    .line 907
    iget-object v4, p0, Lcom/facebook/react/ReactInstanceManager$4;->this$0:Lcom/facebook/react/ReactInstanceManager;

    invoke-static {v4}, Lcom/facebook/react/ReactInstanceManager;->access$600(Lcom/facebook/react/ReactInstanceManager;)Ljava/lang/Boolean;

    move-result-object v5

    monitor-enter v5

    .line 908
    :goto_0
    :try_start_0
    iget-object v4, p0, Lcom/facebook/react/ReactInstanceManager$4;->this$0:Lcom/facebook/react/ReactInstanceManager;

    invoke-static {v4}, Lcom/facebook/react/ReactInstanceManager;->access$600(Lcom/facebook/react/ReactInstanceManager;)Ljava/lang/Boolean;

    move-result-object v4

    invoke-virtual {v4}, Ljava/lang/Boolean;->booleanValue()Z
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    move-result v4

    if-eqz v4, :cond_0

    .line 910
    :try_start_1
    iget-object v4, p0, Lcom/facebook/react/ReactInstanceManager$4;->this$0:Lcom/facebook/react/ReactInstanceManager;

    invoke-static {v4}, Lcom/facebook/react/ReactInstanceManager;->access$600(Lcom/facebook/react/ReactInstanceManager;)Ljava/lang/Boolean;

    move-result-object v4

    invoke-virtual {v4}, Ljava/lang/Object;->wait()V
    :try_end_1
    .catch Ljava/lang/InterruptedException; {:try_start_1 .. :try_end_1} :catch_0
    .catchall {:try_start_1 .. :try_end_1} :catchall_0

    goto :goto_0

    .line 911
    :catch_0
    move-exception v0

    .line 912
    .local v0, "e":Ljava/lang/InterruptedException;
    goto :goto_0

    .line 915
    .end local v0    # "e":Ljava/lang/InterruptedException;
    :cond_0
    :try_start_2
    monitor-exit v5
    :try_end_2
    .catchall {:try_start_2 .. :try_end_2} :catchall_0

    .line 917
    iget-object v4, p0, Lcom/facebook/react/ReactInstanceManager$4;->this$0:Lcom/facebook/react/ReactInstanceManager;

    const/4 v5, 0x1

    invoke-static {v4, v5}, Lcom/facebook/react/ReactInstanceManager;->access$702(Lcom/facebook/react/ReactInstanceManager;Z)Z

    .line 920
    const/4 v4, -0x4

    :try_start_3
    invoke-static {v4}, Landroid/os/Process;->setThreadPriority(I)V

    .line 921
    iget-object v4, p0, Lcom/facebook/react/ReactInstanceManager$4;->this$0:Lcom/facebook/react/ReactInstanceManager;

    iget-object v5, p0, Lcom/facebook/react/ReactInstanceManager$4;->val$initParams:Lcom/facebook/react/ReactInstanceManager$ReactContextInitParams;

    .line 923
    invoke-virtual {v5}, Lcom/facebook/react/ReactInstanceManager$ReactContextInitParams;->getJsExecutorFactory()Lcom/facebook/react/bridge/JavaScriptExecutorFactory;

    move-result-object v5

    invoke-interface {v5}, Lcom/facebook/react/bridge/JavaScriptExecutorFactory;->create()Lcom/facebook/react/bridge/JavaScriptExecutor;

    move-result-object v5

    iget-object v6, p0, Lcom/facebook/react/ReactInstanceManager$4;->val$initParams:Lcom/facebook/react/ReactInstanceManager$ReactContextInitParams;

    .line 924
    invoke-virtual {v6}, Lcom/facebook/react/ReactInstanceManager$ReactContextInitParams;->getJsBundleLoader()Lcom/facebook/react/bridge/JSBundleLoader;

    move-result-object v6

    .line 922
    invoke-static {v4, v5, v6}, Lcom/facebook/react/ReactInstanceManager;->access$800(Lcom/facebook/react/ReactInstanceManager;Lcom/facebook/react/bridge/JavaScriptExecutor;Lcom/facebook/react/bridge/JSBundleLoader;)Lcom/facebook/react/bridge/ReactApplicationContext;

    move-result-object v2

    .line 926
    .local v2, "reactApplicationContext":Lcom/facebook/react/bridge/ReactApplicationContext;
    iget-object v4, p0, Lcom/facebook/react/ReactInstanceManager$4;->this$0:Lcom/facebook/react/ReactInstanceManager;

    const/4 v5, 0x0

    invoke-static {v4, v5}, Lcom/facebook/react/ReactInstanceManager;->access$902(Lcom/facebook/react/ReactInstanceManager;Ljava/lang/Thread;)Ljava/lang/Thread;

    .line 927
    sget-object v4, Lcom/facebook/react/bridge/ReactMarkerConstants;->PRE_SETUP_REACT_CONTEXT_START:Lcom/facebook/react/bridge/ReactMarkerConstants;

    invoke-static {v4}, Lcom/facebook/react/bridge/ReactMarker;->logMarker(Lcom/facebook/react/bridge/ReactMarkerConstants;)V

    .line 928
    new-instance v1, Lcom/facebook/react/ReactInstanceManager$4$1;

    invoke-direct {v1, p0}, Lcom/facebook/react/ReactInstanceManager$4$1;-><init>(Lcom/facebook/react/ReactInstanceManager$4;)V

    .line 938
    .local v1, "maybeRecreateReactContextRunnable":Ljava/lang/Runnable;
    new-instance v3, Lcom/facebook/react/ReactInstanceManager$4$2;

    invoke-direct {v3, p0, v2}, Lcom/facebook/react/ReactInstanceManager$4$2;-><init>(Lcom/facebook/react/ReactInstanceManager$4;Lcom/facebook/react/bridge/ReactApplicationContext;)V

    .line 950
    .local v3, "setupReactContextRunnable":Ljava/lang/Runnable;
    invoke-virtual {v2, v3}, Lcom/facebook/react/bridge/ReactApplicationContext;->runOnNativeModulesQueueThread(Ljava/lang/Runnable;)V

    .line 951
    invoke-static {v1}, Lcom/facebook/react/bridge/UiThreadUtil;->runOnUiThread(Ljava/lang/Runnable;)V
    :try_end_3
    .catch Ljava/lang/Exception; {:try_start_3 .. :try_end_3} :catch_1

    .line 955
    .end local v1    # "maybeRecreateReactContextRunnable":Ljava/lang/Runnable;
    .end local v2    # "reactApplicationContext":Lcom/facebook/react/bridge/ReactApplicationContext;
    .end local v3    # "setupReactContextRunnable":Ljava/lang/Runnable;
    :goto_1
    return-void

    .line 915
    :catchall_0
    move-exception v4

    :try_start_4
    monitor-exit v5
    :try_end_4
    .catchall {:try_start_4 .. :try_end_4} :catchall_0

    throw v4

    .line 952
    :catch_1
    move-exception v0

    .line 953
    .local v0, "e":Ljava/lang/Exception;
    iget-object v4, p0, Lcom/facebook/react/ReactInstanceManager$4;->this$0:Lcom/facebook/react/ReactInstanceManager;

    invoke-static {v4}, Lcom/facebook/react/ReactInstanceManager;->access$400(Lcom/facebook/react/ReactInstanceManager;)Lcom/facebook/react/devsupport/interfaces/DevSupportManager;

    move-result-object v4

    invoke-interface {v4, v0}, Lcom/facebook/react/devsupport/interfaces/DevSupportManager;->handleException(Ljava/lang/Exception;)V

    goto :goto_1
.end method

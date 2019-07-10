.class Lcom/facebook/react/devsupport/DevSupportManagerImpl$18;
.super Ljava/lang/Object;
.source "DevSupportManagerImpl.java"

# interfaces
.implements Ljava/lang/Runnable;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/facebook/react/devsupport/DevSupportManagerImpl;->onPokeSamplingProfilerCommand(Lcom/facebook/react/packagerconnection/Responder;)V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$0:Lcom/facebook/react/devsupport/DevSupportManagerImpl;

.field final synthetic val$responder:Lcom/facebook/react/packagerconnection/Responder;


# direct methods
.method constructor <init>(Lcom/facebook/react/devsupport/DevSupportManagerImpl;Lcom/facebook/react/packagerconnection/Responder;)V
    .locals 0
    .param p1, "this$0"    # Lcom/facebook/react/devsupport/DevSupportManagerImpl;

    .prologue
    .line 737
    iput-object p1, p0, Lcom/facebook/react/devsupport/DevSupportManagerImpl$18;->this$0:Lcom/facebook/react/devsupport/DevSupportManagerImpl;

    iput-object p2, p0, Lcom/facebook/react/devsupport/DevSupportManagerImpl$18;->val$responder:Lcom/facebook/react/packagerconnection/Responder;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public run()V
    .locals 8

    .prologue
    .line 740
    iget-object v3, p0, Lcom/facebook/react/devsupport/DevSupportManagerImpl$18;->this$0:Lcom/facebook/react/devsupport/DevSupportManagerImpl;

    invoke-static {v3}, Lcom/facebook/react/devsupport/DevSupportManagerImpl;->access$1200(Lcom/facebook/react/devsupport/DevSupportManagerImpl;)Lcom/facebook/react/bridge/ReactContext;

    move-result-object v3

    if-nez v3, :cond_0

    .line 741
    iget-object v3, p0, Lcom/facebook/react/devsupport/DevSupportManagerImpl$18;->val$responder:Lcom/facebook/react/packagerconnection/Responder;

    const-string v4, "JSCContext is missing, unable to profile"

    invoke-interface {v3, v4}, Lcom/facebook/react/packagerconnection/Responder;->error(Ljava/lang/Object;)V

    .line 754
    :goto_0
    return-void

    .line 745
    :cond_0
    :try_start_0
    iget-object v3, p0, Lcom/facebook/react/devsupport/DevSupportManagerImpl$18;->this$0:Lcom/facebook/react/devsupport/DevSupportManagerImpl;

    invoke-static {v3}, Lcom/facebook/react/devsupport/DevSupportManagerImpl;->access$1200(Lcom/facebook/react/devsupport/DevSupportManagerImpl;)Lcom/facebook/react/bridge/ReactContext;

    move-result-object v3

    invoke-virtual {v3}, Lcom/facebook/react/bridge/ReactContext;->getJavaScriptContextHolder()Lcom/facebook/react/bridge/JavaScriptContextHolder;

    move-result-object v2

    .line 746
    .local v2, "jsContext":Lcom/facebook/react/bridge/JavaScriptContextHolder;
    monitor-enter v2
    :try_end_0
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_0

    .line 747
    :try_start_1
    const-string v3, "com.facebook.react.packagerconnection.SamplingProfilerPackagerMethod"

    invoke-static {v3}, Ljava/lang/Class;->forName(Ljava/lang/String;)Ljava/lang/Class;

    move-result-object v0

    .line 748
    .local v0, "clazz":Ljava/lang/Class;
    const/4 v3, 0x1

    new-array v3, v3, [Ljava/lang/Class;

    const/4 v4, 0x0

    sget-object v5, Ljava/lang/Long;->TYPE:Ljava/lang/Class;

    aput-object v5, v3, v4

    invoke-virtual {v0, v3}, Ljava/lang/Class;->getConstructor([Ljava/lang/Class;)Ljava/lang/reflect/Constructor;

    move-result-object v3

    const/4 v4, 0x1

    new-array v4, v4, [Ljava/lang/Object;

    const/4 v5, 0x0

    invoke-virtual {v2}, Lcom/facebook/react/bridge/JavaScriptContextHolder;->get()J

    move-result-wide v6

    invoke-static {v6, v7}, Ljava/lang/Long;->valueOf(J)Ljava/lang/Long;

    move-result-object v6

    aput-object v6, v4, v5

    invoke-virtual {v3, v4}, Ljava/lang/reflect/Constructor;->newInstance([Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Lcom/facebook/react/packagerconnection/RequestHandler;

    .line 749
    .local v1, "handler":Lcom/facebook/react/packagerconnection/RequestHandler;
    const/4 v3, 0x0

    iget-object v4, p0, Lcom/facebook/react/devsupport/DevSupportManagerImpl$18;->val$responder:Lcom/facebook/react/packagerconnection/Responder;

    invoke-interface {v1, v3, v4}, Lcom/facebook/react/packagerconnection/RequestHandler;->onRequest(Ljava/lang/Object;Lcom/facebook/react/packagerconnection/Responder;)V

    .line 750
    monitor-exit v2

    goto :goto_0

    .end local v0    # "clazz":Ljava/lang/Class;
    .end local v1    # "handler":Lcom/facebook/react/packagerconnection/RequestHandler;
    :catchall_0
    move-exception v3

    monitor-exit v2
    :try_end_1
    .catchall {:try_start_1 .. :try_end_1} :catchall_0

    :try_start_2
    throw v3
    :try_end_2
    .catch Ljava/lang/Exception; {:try_start_2 .. :try_end_2} :catch_0

    .line 751
    .end local v2    # "jsContext":Lcom/facebook/react/bridge/JavaScriptContextHolder;
    :catch_0
    move-exception v3

    goto :goto_0
.end method

.class Lcom/facebook/react/devsupport/DevServerHelper$1;
.super Landroid/os/AsyncTask;
.source "DevServerHelper.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/facebook/react/devsupport/DevServerHelper;->openPackagerConnection(Ljava/lang/String;Lcom/facebook/react/devsupport/DevServerHelper$PackagerCommandListener;)V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation

.annotation system Ldalvik/annotation/Signature;
    value = {
        "Landroid/os/AsyncTask",
        "<",
        "Ljava/lang/Void;",
        "Ljava/lang/Void;",
        "Ljava/lang/Void;",
        ">;"
    }
.end annotation


# instance fields
.field final synthetic this$0:Lcom/facebook/react/devsupport/DevServerHelper;

.field final synthetic val$clientId:Ljava/lang/String;

.field final synthetic val$commandListener:Lcom/facebook/react/devsupport/DevServerHelper$PackagerCommandListener;


# direct methods
.method constructor <init>(Lcom/facebook/react/devsupport/DevServerHelper;Lcom/facebook/react/devsupport/DevServerHelper$PackagerCommandListener;Ljava/lang/String;)V
    .locals 0
    .param p1, "this$0"    # Lcom/facebook/react/devsupport/DevServerHelper;

    .prologue
    .line 135
    iput-object p1, p0, Lcom/facebook/react/devsupport/DevServerHelper$1;->this$0:Lcom/facebook/react/devsupport/DevServerHelper;

    iput-object p2, p0, Lcom/facebook/react/devsupport/DevServerHelper$1;->val$commandListener:Lcom/facebook/react/devsupport/DevServerHelper$PackagerCommandListener;

    iput-object p3, p0, Lcom/facebook/react/devsupport/DevServerHelper$1;->val$clientId:Ljava/lang/String;

    invoke-direct {p0}, Landroid/os/AsyncTask;-><init>()V

    return-void
.end method


# virtual methods
.method protected bridge synthetic doInBackground([Ljava/lang/Object;)Ljava/lang/Object;
    .locals 1

    .prologue
    .line 135
    check-cast p1, [Ljava/lang/Void;

    invoke-virtual {p0, p1}, Lcom/facebook/react/devsupport/DevServerHelper$1;->doInBackground([Ljava/lang/Void;)Ljava/lang/Void;

    move-result-object v0

    return-object v0
.end method

.method protected varargs doInBackground([Ljava/lang/Void;)Ljava/lang/Void;
    .locals 5
    .param p1, "backgroundParams"    # [Ljava/lang/Void;

    .prologue
    .line 138
    new-instance v0, Ljava/util/HashMap;

    invoke-direct {v0}, Ljava/util/HashMap;-><init>()V

    .line 139
    .local v0, "handlers":Ljava/util/Map;, "Ljava/util/Map<Ljava/lang/String;Lcom/facebook/react/packagerconnection/RequestHandler;>;"
    const-string v1, "reload"

    new-instance v2, Lcom/facebook/react/devsupport/DevServerHelper$1$1;

    invoke-direct {v2, p0}, Lcom/facebook/react/devsupport/DevServerHelper$1$1;-><init>(Lcom/facebook/react/devsupport/DevServerHelper$1;)V

    invoke-interface {v0, v1, v2}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 145
    const-string v1, "devMenu"

    new-instance v2, Lcom/facebook/react/devsupport/DevServerHelper$1$2;

    invoke-direct {v2, p0}, Lcom/facebook/react/devsupport/DevServerHelper$1$2;-><init>(Lcom/facebook/react/devsupport/DevServerHelper$1;)V

    invoke-interface {v0, v1, v2}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 151
    const-string v1, "captureHeap"

    new-instance v2, Lcom/facebook/react/devsupport/DevServerHelper$1$3;

    invoke-direct {v2, p0}, Lcom/facebook/react/devsupport/DevServerHelper$1$3;-><init>(Lcom/facebook/react/devsupport/DevServerHelper$1;)V

    invoke-interface {v0, v1, v2}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 157
    const-string v1, "pokeSamplingProfiler"

    new-instance v2, Lcom/facebook/react/devsupport/DevServerHelper$1$4;

    invoke-direct {v2, p0}, Lcom/facebook/react/devsupport/DevServerHelper$1$4;-><init>(Lcom/facebook/react/devsupport/DevServerHelper$1;)V

    invoke-interface {v0, v1, v2}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 163
    new-instance v1, Lcom/facebook/react/packagerconnection/FileIoHandler;

    invoke-direct {v1}, Lcom/facebook/react/packagerconnection/FileIoHandler;-><init>()V

    invoke-virtual {v1}, Lcom/facebook/react/packagerconnection/FileIoHandler;->handlers()Ljava/util/Map;

    move-result-object v1

    invoke-interface {v0, v1}, Ljava/util/Map;->putAll(Ljava/util/Map;)V

    .line 165
    iget-object v1, p0, Lcom/facebook/react/devsupport/DevServerHelper$1;->this$0:Lcom/facebook/react/devsupport/DevServerHelper;

    new-instance v2, Lcom/facebook/react/packagerconnection/JSPackagerClient;

    iget-object v3, p0, Lcom/facebook/react/devsupport/DevServerHelper$1;->val$clientId:Ljava/lang/String;

    iget-object v4, p0, Lcom/facebook/react/devsupport/DevServerHelper$1;->this$0:Lcom/facebook/react/devsupport/DevServerHelper;

    .line 167
    invoke-static {v4}, Lcom/facebook/react/devsupport/DevServerHelper;->access$100(Lcom/facebook/react/devsupport/DevServerHelper;)Lcom/facebook/react/devsupport/DevInternalSettings;

    move-result-object v4

    invoke-virtual {v4}, Lcom/facebook/react/devsupport/DevInternalSettings;->getPackagerConnectionSettings()Lcom/facebook/react/packagerconnection/PackagerConnectionSettings;

    move-result-object v4

    invoke-direct {v2, v3, v4, v0}, Lcom/facebook/react/packagerconnection/JSPackagerClient;-><init>(Ljava/lang/String;Lcom/facebook/react/packagerconnection/PackagerConnectionSettings;Ljava/util/Map;)V

    .line 165
    invoke-static {v1, v2}, Lcom/facebook/react/devsupport/DevServerHelper;->access$002(Lcom/facebook/react/devsupport/DevServerHelper;Lcom/facebook/react/packagerconnection/JSPackagerClient;)Lcom/facebook/react/packagerconnection/JSPackagerClient;

    .line 169
    iget-object v1, p0, Lcom/facebook/react/devsupport/DevServerHelper$1;->this$0:Lcom/facebook/react/devsupport/DevServerHelper;

    invoke-static {v1}, Lcom/facebook/react/devsupport/DevServerHelper;->access$000(Lcom/facebook/react/devsupport/DevServerHelper;)Lcom/facebook/react/packagerconnection/JSPackagerClient;

    move-result-object v1

    invoke-virtual {v1}, Lcom/facebook/react/packagerconnection/JSPackagerClient;->init()V

    .line 171
    const/4 v1, 0x0

    return-object v1
.end method

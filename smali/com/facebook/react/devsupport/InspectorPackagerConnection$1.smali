.class Lcom/facebook/react/devsupport/InspectorPackagerConnection$1;
.super Ljava/lang/Object;
.source "InspectorPackagerConnection.java"

# interfaces
.implements Lcom/facebook/react/bridge/Inspector$RemoteConnection;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/facebook/react/devsupport/InspectorPackagerConnection;->handleConnect(Lorg/json/JSONObject;)V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$0:Lcom/facebook/react/devsupport/InspectorPackagerConnection;

.field final synthetic val$pageId:Ljava/lang/String;


# direct methods
.method constructor <init>(Lcom/facebook/react/devsupport/InspectorPackagerConnection;Ljava/lang/String;)V
    .locals 0
    .param p1, "this$0"    # Lcom/facebook/react/devsupport/InspectorPackagerConnection;

    .prologue
    .line 96
    iput-object p1, p0, Lcom/facebook/react/devsupport/InspectorPackagerConnection$1;->this$0:Lcom/facebook/react/devsupport/InspectorPackagerConnection;

    iput-object p2, p0, Lcom/facebook/react/devsupport/InspectorPackagerConnection$1;->val$pageId:Ljava/lang/String;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public onDisconnect()V
    .locals 5

    .prologue
    .line 109
    :try_start_0
    iget-object v1, p0, Lcom/facebook/react/devsupport/InspectorPackagerConnection$1;->this$0:Lcom/facebook/react/devsupport/InspectorPackagerConnection;

    invoke-static {v1}, Lcom/facebook/react/devsupport/InspectorPackagerConnection;->access$100(Lcom/facebook/react/devsupport/InspectorPackagerConnection;)Ljava/util/Map;

    move-result-object v1

    iget-object v2, p0, Lcom/facebook/react/devsupport/InspectorPackagerConnection$1;->val$pageId:Ljava/lang/String;

    invoke-interface {v1, v2}, Ljava/util/Map;->remove(Ljava/lang/Object;)Ljava/lang/Object;

    .line 110
    iget-object v1, p0, Lcom/facebook/react/devsupport/InspectorPackagerConnection$1;->this$0:Lcom/facebook/react/devsupport/InspectorPackagerConnection;

    const-string v2, "disconnect"

    iget-object v3, p0, Lcom/facebook/react/devsupport/InspectorPackagerConnection$1;->this$0:Lcom/facebook/react/devsupport/InspectorPackagerConnection;

    iget-object v4, p0, Lcom/facebook/react/devsupport/InspectorPackagerConnection$1;->val$pageId:Ljava/lang/String;

    invoke-static {v3, v4}, Lcom/facebook/react/devsupport/InspectorPackagerConnection;->access$200(Lcom/facebook/react/devsupport/InspectorPackagerConnection;Ljava/lang/String;)Lorg/json/JSONObject;

    move-result-object v3

    invoke-static {v1, v2, v3}, Lcom/facebook/react/devsupport/InspectorPackagerConnection;->access$300(Lcom/facebook/react/devsupport/InspectorPackagerConnection;Ljava/lang/String;Ljava/lang/Object;)V
    :try_end_0
    .catch Lorg/json/JSONException; {:try_start_0 .. :try_end_0} :catch_0

    .line 114
    :goto_0
    return-void

    .line 111
    :catch_0
    move-exception v0

    .line 112
    .local v0, "e":Lorg/json/JSONException;
    const-string v1, "InspectorPackagerConnection"

    const-string v2, "Couldn\'t send event to packager"

    invoke-static {v1, v2, v0}, Lcom/facebook/common/logging/FLog;->w(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V

    goto :goto_0
.end method

.method public onMessage(Ljava/lang/String;)V
    .locals 3
    .param p1, "message"    # Ljava/lang/String;

    .prologue
    .line 100
    :try_start_0
    iget-object v1, p0, Lcom/facebook/react/devsupport/InspectorPackagerConnection$1;->this$0:Lcom/facebook/react/devsupport/InspectorPackagerConnection;

    iget-object v2, p0, Lcom/facebook/react/devsupport/InspectorPackagerConnection$1;->val$pageId:Ljava/lang/String;

    invoke-static {v1, v2, p1}, Lcom/facebook/react/devsupport/InspectorPackagerConnection;->access$000(Lcom/facebook/react/devsupport/InspectorPackagerConnection;Ljava/lang/String;Ljava/lang/String;)V
    :try_end_0
    .catch Lorg/json/JSONException; {:try_start_0 .. :try_end_0} :catch_0

    .line 104
    :goto_0
    return-void

    .line 101
    :catch_0
    move-exception v0

    .line 102
    .local v0, "e":Lorg/json/JSONException;
    const-string v1, "InspectorPackagerConnection"

    const-string v2, "Couldn\'t send event to packager"

    invoke-static {v1, v2, v0}, Lcom/facebook/common/logging/FLog;->w(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V

    goto :goto_0
.end method

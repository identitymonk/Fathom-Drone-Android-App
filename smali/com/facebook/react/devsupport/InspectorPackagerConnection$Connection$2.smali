.class Lcom/facebook/react/devsupport/InspectorPackagerConnection$Connection$2;
.super Landroid/os/AsyncTask;
.source "InspectorPackagerConnection.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/facebook/react/devsupport/InspectorPackagerConnection$Connection;->send(Lorg/json/JSONObject;)V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation

.annotation system Ldalvik/annotation/Signature;
    value = {
        "Landroid/os/AsyncTask",
        "<",
        "Lokhttp3/WebSocket;",
        "Ljava/lang/Void;",
        "Ljava/lang/Void;",
        ">;"
    }
.end annotation


# instance fields
.field final synthetic this$1:Lcom/facebook/react/devsupport/InspectorPackagerConnection$Connection;

.field final synthetic val$object:Lorg/json/JSONObject;


# direct methods
.method constructor <init>(Lcom/facebook/react/devsupport/InspectorPackagerConnection$Connection;Lorg/json/JSONObject;)V
    .locals 0
    .param p1, "this$1"    # Lcom/facebook/react/devsupport/InspectorPackagerConnection$Connection;

    .prologue
    .line 276
    iput-object p1, p0, Lcom/facebook/react/devsupport/InspectorPackagerConnection$Connection$2;->this$1:Lcom/facebook/react/devsupport/InspectorPackagerConnection$Connection;

    iput-object p2, p0, Lcom/facebook/react/devsupport/InspectorPackagerConnection$Connection$2;->val$object:Lorg/json/JSONObject;

    invoke-direct {p0}, Landroid/os/AsyncTask;-><init>()V

    return-void
.end method


# virtual methods
.method protected bridge synthetic doInBackground([Ljava/lang/Object;)Ljava/lang/Object;
    .locals 1

    .prologue
    .line 276
    check-cast p1, [Lokhttp3/WebSocket;

    invoke-virtual {p0, p1}, Lcom/facebook/react/devsupport/InspectorPackagerConnection$Connection$2;->doInBackground([Lokhttp3/WebSocket;)Ljava/lang/Void;

    move-result-object v0

    return-object v0
.end method

.method protected varargs doInBackground([Lokhttp3/WebSocket;)Ljava/lang/Void;
    .locals 4
    .param p1, "sockets"    # [Lokhttp3/WebSocket;

    .prologue
    const/4 v3, 0x0

    .line 279
    if-eqz p1, :cond_0

    array-length v1, p1

    if-nez v1, :cond_1

    .line 287
    :cond_0
    :goto_0
    return-object v3

    .line 283
    :cond_1
    const/4 v1, 0x0

    :try_start_0
    aget-object v1, p1, v1

    iget-object v2, p0, Lcom/facebook/react/devsupport/InspectorPackagerConnection$Connection$2;->val$object:Lorg/json/JSONObject;

    invoke-virtual {v2}, Lorg/json/JSONObject;->toString()Ljava/lang/String;

    move-result-object v2

    invoke-interface {v1, v2}, Lokhttp3/WebSocket;->send(Ljava/lang/String;)Z
    :try_end_0
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_0

    goto :goto_0

    .line 284
    :catch_0
    move-exception v0

    .line 285
    .local v0, "e":Ljava/lang/Exception;
    const-string v1, "InspectorPackagerConnection"

    const-string v2, "Couldn\'t send event to packager"

    invoke-static {v1, v2, v0}, Lcom/facebook/common/logging/FLog;->w(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V

    goto :goto_0
.end method

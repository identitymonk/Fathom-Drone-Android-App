.class Lcom/facebook/react/packagerconnection/FileIoHandler$1;
.super Lcom/facebook/react/packagerconnection/RequestOnlyHandler;
.source "FileIoHandler.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/facebook/react/packagerconnection/FileIoHandler;-><init>()V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$0:Lcom/facebook/react/packagerconnection/FileIoHandler;


# direct methods
.method constructor <init>(Lcom/facebook/react/packagerconnection/FileIoHandler;)V
    .locals 0
    .param p1, "this$0"    # Lcom/facebook/react/packagerconnection/FileIoHandler;

    .prologue
    .line 72
    iput-object p1, p0, Lcom/facebook/react/packagerconnection/FileIoHandler$1;->this$0:Lcom/facebook/react/packagerconnection/FileIoHandler;

    invoke-direct {p0}, Lcom/facebook/react/packagerconnection/RequestOnlyHandler;-><init>()V

    return-void
.end method


# virtual methods
.method public onRequest(Ljava/lang/Object;Lcom/facebook/react/packagerconnection/Responder;)V
    .locals 9
    .param p1, "params"    # Ljava/lang/Object;
        .annotation runtime Ljavax/annotation/Nullable;
        .end annotation
    .end param
    .param p2, "responder"    # Lcom/facebook/react/packagerconnection/Responder;

    .prologue
    .line 76
    iget-object v5, p0, Lcom/facebook/react/packagerconnection/FileIoHandler$1;->this$0:Lcom/facebook/react/packagerconnection/FileIoHandler;

    invoke-static {v5}, Lcom/facebook/react/packagerconnection/FileIoHandler;->access$000(Lcom/facebook/react/packagerconnection/FileIoHandler;)Ljava/util/Map;

    move-result-object v6

    monitor-enter v6

    .line 78
    :try_start_0
    move-object v0, p1

    check-cast v0, Lorg/json/JSONObject;

    move-object v4, v0

    .line 79
    .local v4, "paramsObj":Lorg/json/JSONObject;
    if-nez v4, :cond_0

    .line 80
    new-instance v5, Ljava/lang/Exception;

    const-string v7, "params must be an object { mode: string, filename: string }"

    invoke-direct {v5, v7}, Ljava/lang/Exception;-><init>(Ljava/lang/String;)V

    throw v5
    :try_end_0
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    .line 95
    .end local v4    # "paramsObj":Lorg/json/JSONObject;
    :catch_0
    move-exception v1

    .line 96
    .local v1, "e":Ljava/lang/Exception;
    :try_start_1
    invoke-virtual {v1}, Ljava/lang/Exception;->toString()Ljava/lang/String;

    move-result-object v5

    invoke-interface {p2, v5}, Lcom/facebook/react/packagerconnection/Responder;->error(Ljava/lang/Object;)V

    .line 98
    .end local v1    # "e":Ljava/lang/Exception;
    :goto_0
    monitor-exit v6
    :try_end_1
    .catchall {:try_start_1 .. :try_end_1} :catchall_0

    .line 99
    return-void

    .line 82
    .restart local v4    # "paramsObj":Lorg/json/JSONObject;
    :cond_0
    :try_start_2
    const-string v5, "mode"

    invoke-virtual {v4, v5}, Lorg/json/JSONObject;->optString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v3

    .line 83
    .local v3, "mode":Ljava/lang/String;
    if-nez v3, :cond_1

    .line 84
    new-instance v5, Ljava/lang/Exception;

    const-string v7, "missing params.mode"

    invoke-direct {v5, v7}, Ljava/lang/Exception;-><init>(Ljava/lang/String;)V

    throw v5
    :try_end_2
    .catch Ljava/lang/Exception; {:try_start_2 .. :try_end_2} :catch_0
    .catchall {:try_start_2 .. :try_end_2} :catchall_0

    .line 98
    .end local v3    # "mode":Ljava/lang/String;
    .end local v4    # "paramsObj":Lorg/json/JSONObject;
    :catchall_0
    move-exception v5

    :try_start_3
    monitor-exit v6
    :try_end_3
    .catchall {:try_start_3 .. :try_end_3} :catchall_0

    throw v5

    .line 86
    .restart local v3    # "mode":Ljava/lang/String;
    .restart local v4    # "paramsObj":Lorg/json/JSONObject;
    :cond_1
    :try_start_4
    const-string v5, "filename"

    invoke-virtual {v4, v5}, Lorg/json/JSONObject;->optString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v2

    .line 87
    .local v2, "filename":Ljava/lang/String;
    if-nez v2, :cond_2

    .line 88
    new-instance v5, Ljava/lang/Exception;

    const-string v7, "missing params.filename"

    invoke-direct {v5, v7}, Ljava/lang/Exception;-><init>(Ljava/lang/String;)V

    throw v5

    .line 90
    :cond_2
    const-string v5, "r"

    invoke-virtual {v3, v5}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v5

    if-nez v5, :cond_3

    .line 91
    new-instance v5, Ljava/lang/IllegalArgumentException;

    new-instance v7, Ljava/lang/StringBuilder;

    invoke-direct {v7}, Ljava/lang/StringBuilder;-><init>()V

    const-string v8, "unsupported mode: "

    invoke-virtual {v7, v8}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v7

    invoke-virtual {v7, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v7

    invoke-virtual {v7}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v7

    invoke-direct {v5, v7}, Ljava/lang/IllegalArgumentException;-><init>(Ljava/lang/String;)V

    throw v5

    .line 94
    :cond_3
    iget-object v5, p0, Lcom/facebook/react/packagerconnection/FileIoHandler$1;->this$0:Lcom/facebook/react/packagerconnection/FileIoHandler;

    invoke-static {v5, v2}, Lcom/facebook/react/packagerconnection/FileIoHandler;->access$100(Lcom/facebook/react/packagerconnection/FileIoHandler;Ljava/lang/String;)I

    move-result v5

    invoke-static {v5}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v5

    invoke-interface {p2, v5}, Lcom/facebook/react/packagerconnection/Responder;->respond(Ljava/lang/Object;)V
    :try_end_4
    .catch Ljava/lang/Exception; {:try_start_4 .. :try_end_4} :catch_0
    .catchall {:try_start_4 .. :try_end_4} :catchall_0

    goto :goto_0
.end method

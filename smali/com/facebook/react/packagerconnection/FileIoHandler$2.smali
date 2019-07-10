.class Lcom/facebook/react/packagerconnection/FileIoHandler$2;
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
    .line 101
    iput-object p1, p0, Lcom/facebook/react/packagerconnection/FileIoHandler$2;->this$0:Lcom/facebook/react/packagerconnection/FileIoHandler;

    invoke-direct {p0}, Lcom/facebook/react/packagerconnection/RequestOnlyHandler;-><init>()V

    return-void
.end method


# virtual methods
.method public onRequest(Ljava/lang/Object;Lcom/facebook/react/packagerconnection/Responder;)V
    .locals 6
    .param p1, "params"    # Ljava/lang/Object;
        .annotation runtime Ljavax/annotation/Nullable;
        .end annotation
    .end param
    .param p2, "responder"    # Lcom/facebook/react/packagerconnection/Responder;

    .prologue
    .line 105
    iget-object v3, p0, Lcom/facebook/react/packagerconnection/FileIoHandler$2;->this$0:Lcom/facebook/react/packagerconnection/FileIoHandler;

    invoke-static {v3}, Lcom/facebook/react/packagerconnection/FileIoHandler;->access$000(Lcom/facebook/react/packagerconnection/FileIoHandler;)Ljava/util/Map;

    move-result-object v4

    monitor-enter v4

    .line 107
    :try_start_0
    instance-of v3, p1, Ljava/lang/Number;

    if-nez v3, :cond_0

    .line 108
    new-instance v3, Ljava/lang/Exception;

    const-string v5, "params must be a file handle"

    invoke-direct {v3, v5}, Ljava/lang/Exception;-><init>(Ljava/lang/String;)V

    throw v3
    :try_end_0
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    .line 118
    .end local p1    # "params":Ljava/lang/Object;
    :catch_0
    move-exception v1

    .line 119
    .local v1, "e":Ljava/lang/Exception;
    :try_start_1
    invoke-virtual {v1}, Ljava/lang/Exception;->toString()Ljava/lang/String;

    move-result-object v3

    invoke-interface {p2, v3}, Lcom/facebook/react/packagerconnection/Responder;->error(Ljava/lang/Object;)V

    .line 121
    .end local v1    # "e":Ljava/lang/Exception;
    :goto_0
    monitor-exit v4
    :try_end_1
    .catchall {:try_start_1 .. :try_end_1} :catchall_0

    .line 122
    return-void

    .line 110
    .restart local p1    # "params":Ljava/lang/Object;
    :cond_0
    :try_start_2
    iget-object v3, p0, Lcom/facebook/react/packagerconnection/FileIoHandler$2;->this$0:Lcom/facebook/react/packagerconnection/FileIoHandler;

    invoke-static {v3}, Lcom/facebook/react/packagerconnection/FileIoHandler;->access$000(Lcom/facebook/react/packagerconnection/FileIoHandler;)Ljava/util/Map;

    move-result-object v5

    move-object v0, p1

    check-cast v0, Ljava/lang/Integer;

    move-object v3, v0

    invoke-virtual {v3}, Ljava/lang/Integer;->intValue()I

    move-result v3

    invoke-static {v3}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v3

    invoke-interface {v5, v3}, Ljava/util/Map;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v2

    check-cast v2, Lcom/facebook/react/packagerconnection/FileIoHandler$TtlFileInputStream;

    .line 111
    .local v2, "stream":Lcom/facebook/react/packagerconnection/FileIoHandler$TtlFileInputStream;
    if-nez v2, :cond_1

    .line 112
    new-instance v3, Ljava/lang/Exception;

    const-string v5, "invalid file handle, it might have timed out"

    invoke-direct {v3, v5}, Ljava/lang/Exception;-><init>(Ljava/lang/String;)V

    throw v3
    :try_end_2
    .catch Ljava/lang/Exception; {:try_start_2 .. :try_end_2} :catch_0
    .catchall {:try_start_2 .. :try_end_2} :catchall_0

    .line 121
    .end local v2    # "stream":Lcom/facebook/react/packagerconnection/FileIoHandler$TtlFileInputStream;
    .end local p1    # "params":Ljava/lang/Object;
    :catchall_0
    move-exception v3

    :try_start_3
    monitor-exit v4
    :try_end_3
    .catchall {:try_start_3 .. :try_end_3} :catchall_0

    throw v3

    .line 115
    .restart local v2    # "stream":Lcom/facebook/react/packagerconnection/FileIoHandler$TtlFileInputStream;
    .restart local p1    # "params":Ljava/lang/Object;
    :cond_1
    :try_start_4
    iget-object v3, p0, Lcom/facebook/react/packagerconnection/FileIoHandler$2;->this$0:Lcom/facebook/react/packagerconnection/FileIoHandler;

    invoke-static {v3}, Lcom/facebook/react/packagerconnection/FileIoHandler;->access$000(Lcom/facebook/react/packagerconnection/FileIoHandler;)Ljava/util/Map;

    move-result-object v3

    check-cast p1, Ljava/lang/Integer;

    .end local p1    # "params":Ljava/lang/Object;
    invoke-virtual {p1}, Ljava/lang/Integer;->intValue()I

    move-result v5

    invoke-static {v5}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v5

    invoke-interface {v3, v5}, Ljava/util/Map;->remove(Ljava/lang/Object;)Ljava/lang/Object;

    .line 116
    invoke-virtual {v2}, Lcom/facebook/react/packagerconnection/FileIoHandler$TtlFileInputStream;->close()V

    .line 117
    const-string v3, ""

    invoke-interface {p2, v3}, Lcom/facebook/react/packagerconnection/Responder;->respond(Ljava/lang/Object;)V
    :try_end_4
    .catch Ljava/lang/Exception; {:try_start_4 .. :try_end_4} :catch_0
    .catchall {:try_start_4 .. :try_end_4} :catchall_0

    goto :goto_0
.end method

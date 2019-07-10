.class Lcom/facebook/react/modules/blob/BlobModule$1;
.super Ljava/lang/Object;
.source "BlobModule.java"

# interfaces
.implements Lcom/facebook/react/modules/websocket/WebSocketModule$ContentHandler;


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/facebook/react/modules/blob/BlobModule;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$0:Lcom/facebook/react/modules/blob/BlobModule;


# direct methods
.method constructor <init>(Lcom/facebook/react/modules/blob/BlobModule;)V
    .locals 0
    .param p1, "this$0"    # Lcom/facebook/react/modules/blob/BlobModule;

    .prologue
    .line 39
    iput-object p1, p0, Lcom/facebook/react/modules/blob/BlobModule$1;->this$0:Lcom/facebook/react/modules/blob/BlobModule;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public onMessage(Ljava/lang/String;Lcom/facebook/react/bridge/WritableMap;)V
    .locals 1
    .param p1, "text"    # Ljava/lang/String;
    .param p2, "params"    # Lcom/facebook/react/bridge/WritableMap;

    .prologue
    .line 42
    const-string v0, "data"

    invoke-interface {p2, v0, p1}, Lcom/facebook/react/bridge/WritableMap;->putString(Ljava/lang/String;Ljava/lang/String;)V

    .line 43
    return-void
.end method

.method public onMessage(Lokio/ByteString;Lcom/facebook/react/bridge/WritableMap;)V
    .locals 4
    .param p1, "bytes"    # Lokio/ByteString;
    .param p2, "params"    # Lcom/facebook/react/bridge/WritableMap;

    .prologue
    .line 47
    invoke-virtual {p1}, Lokio/ByteString;->toByteArray()[B

    move-result-object v1

    .line 49
    .local v1, "data":[B
    invoke-static {}, Lcom/facebook/react/bridge/Arguments;->createMap()Lcom/facebook/react/bridge/WritableMap;

    move-result-object v0

    .line 51
    .local v0, "blob":Lcom/facebook/react/bridge/WritableMap;
    const-string v2, "blobId"

    iget-object v3, p0, Lcom/facebook/react/modules/blob/BlobModule$1;->this$0:Lcom/facebook/react/modules/blob/BlobModule;

    invoke-virtual {v3, v1}, Lcom/facebook/react/modules/blob/BlobModule;->store([B)Ljava/lang/String;

    move-result-object v3

    invoke-interface {v0, v2, v3}, Lcom/facebook/react/bridge/WritableMap;->putString(Ljava/lang/String;Ljava/lang/String;)V

    .line 52
    const-string v2, "offset"

    const/4 v3, 0x0

    invoke-interface {v0, v2, v3}, Lcom/facebook/react/bridge/WritableMap;->putInt(Ljava/lang/String;I)V

    .line 53
    const-string v2, "size"

    array-length v3, v1

    invoke-interface {v0, v2, v3}, Lcom/facebook/react/bridge/WritableMap;->putInt(Ljava/lang/String;I)V

    .line 55
    const-string v2, "data"

    invoke-interface {p2, v2, v0}, Lcom/facebook/react/bridge/WritableMap;->putMap(Ljava/lang/String;Lcom/facebook/react/bridge/WritableMap;)V

    .line 56
    const-string v2, "type"

    const-string v3, "blob"

    invoke-interface {p2, v2, v3}, Lcom/facebook/react/bridge/WritableMap;->putString(Ljava/lang/String;Ljava/lang/String;)V

    .line 57
    return-void
.end method

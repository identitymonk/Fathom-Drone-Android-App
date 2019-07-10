.class public abstract Lorg/java_websocket/client/WebSocketClient;
.super Lorg/java_websocket/WebSocketAdapter;
.source "WebSocketClient.java"

# interfaces
.implements Ljava/lang/Runnable;


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lorg/java_websocket/client/WebSocketClient$1;,
        Lorg/java_websocket/client/WebSocketClient$WebsocketWriteThread;,
        Lorg/java_websocket/client/WebSocketClient$WebSocketClientFactory;,
        Lorg/java_websocket/client/WebSocketClient$DefaultClientProxyChannel;
    }
.end annotation


# static fields
.field static final synthetic $assertionsDisabled:Z


# instance fields
.field private channel:Ljava/nio/channels/SocketChannel;

.field private closeLatch:Ljava/util/concurrent/CountDownLatch;

.field private conn:Lorg/java_websocket/WebSocketImpl;

.field private connectLatch:Ljava/util/concurrent/CountDownLatch;

.field private draft:Lorg/java_websocket/drafts/Draft;

.field private headers:Ljava/util/Map;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/Map",
            "<",
            "Ljava/lang/String;",
            "Ljava/lang/String;",
            ">;"
        }
    .end annotation
.end field

.field private proxyAddress:Ljava/net/InetSocketAddress;

.field private readthread:Ljava/lang/Thread;

.field private timeout:I

.field protected uri:Ljava/net/URI;

.field private wrappedchannel:Ljava/nio/channels/ByteChannel;

.field private writethread:Ljava/lang/Thread;

.field private wsfactory:Lorg/java_websocket/client/WebSocketClient$WebSocketClientFactory;


# direct methods
.method static constructor <clinit>()V
    .locals 1

    .prologue
    .line 42
    const-class v0, Lorg/java_websocket/client/WebSocketClient;

    invoke-virtual {v0}, Ljava/lang/Class;->desiredAssertionStatus()Z

    move-result v0

    if-nez v0, :cond_0

    const/4 v0, 0x1

    :goto_0
    sput-boolean v0, Lorg/java_websocket/client/WebSocketClient;->$assertionsDisabled:Z

    return-void

    :cond_0
    const/4 v0, 0x0

    goto :goto_0
.end method

.method public constructor <init>(Ljava/net/URI;)V
    .locals 1
    .param p1, "serverURI"    # Ljava/net/URI;

    .prologue
    .line 76
    new-instance v0, Lorg/java_websocket/drafts/Draft_10;

    invoke-direct {v0}, Lorg/java_websocket/drafts/Draft_10;-><init>()V

    invoke-direct {p0, p1, v0}, Lorg/java_websocket/client/WebSocketClient;-><init>(Ljava/net/URI;Lorg/java_websocket/drafts/Draft;)V

    .line 77
    return-void
.end method

.method public constructor <init>(Ljava/net/URI;Lorg/java_websocket/drafts/Draft;)V
    .locals 2
    .param p1, "serverUri"    # Ljava/net/URI;
    .param p2, "draft"    # Lorg/java_websocket/drafts/Draft;

    .prologue
    .line 85
    const/4 v0, 0x0

    const/4 v1, 0x0

    invoke-direct {p0, p1, p2, v0, v1}, Lorg/java_websocket/client/WebSocketClient;-><init>(Ljava/net/URI;Lorg/java_websocket/drafts/Draft;Ljava/util/Map;I)V

    .line 86
    return-void
.end method

.method public constructor <init>(Ljava/net/URI;Lorg/java_websocket/drafts/Draft;Ljava/util/Map;I)V
    .locals 4
    .param p1, "serverUri"    # Ljava/net/URI;
    .param p2, "draft"    # Lorg/java_websocket/drafts/Draft;
    .param p4, "connecttimeout"    # I
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/net/URI;",
            "Lorg/java_websocket/drafts/Draft;",
            "Ljava/util/Map",
            "<",
            "Ljava/lang/String;",
            "Ljava/lang/String;",
            ">;I)V"
        }
    .end annotation

    .prologue
    .local p3, "headers":Ljava/util/Map;, "Ljava/util/Map<Ljava/lang/String;Ljava/lang/String;>;"
    const/4 v2, 0x1

    const/4 v3, 0x0

    .line 88
    invoke-direct {p0}, Lorg/java_websocket/WebSocketAdapter;-><init>()V

    .line 47
    iput-object v3, p0, Lorg/java_websocket/client/WebSocketClient;->uri:Ljava/net/URI;

    .line 49
    iput-object v3, p0, Lorg/java_websocket/client/WebSocketClient;->conn:Lorg/java_websocket/WebSocketImpl;

    .line 53
    iput-object v3, p0, Lorg/java_websocket/client/WebSocketClient;->channel:Ljava/nio/channels/SocketChannel;

    .line 55
    iput-object v3, p0, Lorg/java_websocket/client/WebSocketClient;->wrappedchannel:Ljava/nio/channels/ByteChannel;

    .line 65
    new-instance v1, Ljava/util/concurrent/CountDownLatch;

    invoke-direct {v1, v2}, Ljava/util/concurrent/CountDownLatch;-><init>(I)V

    iput-object v1, p0, Lorg/java_websocket/client/WebSocketClient;->connectLatch:Ljava/util/concurrent/CountDownLatch;

    .line 67
    new-instance v1, Ljava/util/concurrent/CountDownLatch;

    invoke-direct {v1, v2}, Ljava/util/concurrent/CountDownLatch;-><init>(I)V

    iput-object v1, p0, Lorg/java_websocket/client/WebSocketClient;->closeLatch:Ljava/util/concurrent/CountDownLatch;

    .line 69
    const/4 v1, 0x0

    iput v1, p0, Lorg/java_websocket/client/WebSocketClient;->timeout:I

    .line 71
    new-instance v1, Lorg/java_websocket/client/DefaultWebSocketClientFactory;

    invoke-direct {v1, p0}, Lorg/java_websocket/client/DefaultWebSocketClientFactory;-><init>(Lorg/java_websocket/client/WebSocketClient;)V

    iput-object v1, p0, Lorg/java_websocket/client/WebSocketClient;->wsfactory:Lorg/java_websocket/client/WebSocketClient$WebSocketClientFactory;

    .line 73
    iput-object v3, p0, Lorg/java_websocket/client/WebSocketClient;->proxyAddress:Ljava/net/InetSocketAddress;

    .line 89
    if-nez p1, :cond_0

    .line 90
    new-instance v1, Ljava/lang/IllegalArgumentException;

    invoke-direct {v1}, Ljava/lang/IllegalArgumentException;-><init>()V

    throw v1

    .line 92
    :cond_0
    if-nez p2, :cond_1

    .line 93
    new-instance v1, Ljava/lang/IllegalArgumentException;

    const-string v2, "null as draft is permitted for `WebSocketServer` only!"

    invoke-direct {v1, v2}, Ljava/lang/IllegalArgumentException;-><init>(Ljava/lang/String;)V

    throw v1

    .line 95
    :cond_1
    iput-object p1, p0, Lorg/java_websocket/client/WebSocketClient;->uri:Ljava/net/URI;

    .line 96
    iput-object p2, p0, Lorg/java_websocket/client/WebSocketClient;->draft:Lorg/java_websocket/drafts/Draft;

    .line 97
    iput-object p3, p0, Lorg/java_websocket/client/WebSocketClient;->headers:Ljava/util/Map;

    .line 98
    iput p4, p0, Lorg/java_websocket/client/WebSocketClient;->timeout:I

    .line 101
    :try_start_0
    invoke-static {}, Ljava/nio/channels/spi/SelectorProvider;->provider()Ljava/nio/channels/spi/SelectorProvider;

    move-result-object v1

    invoke-virtual {v1}, Ljava/nio/channels/spi/SelectorProvider;->openSocketChannel()Ljava/nio/channels/SocketChannel;

    move-result-object v1

    iput-object v1, p0, Lorg/java_websocket/client/WebSocketClient;->channel:Ljava/nio/channels/SocketChannel;

    .line 102
    iget-object v1, p0, Lorg/java_websocket/client/WebSocketClient;->channel:Ljava/nio/channels/SocketChannel;

    const/4 v2, 0x1

    invoke-virtual {v1, v2}, Ljava/nio/channels/SocketChannel;->configureBlocking(Z)Ljava/nio/channels/SelectableChannel;
    :try_end_0
    .catch Ljava/io/IOException; {:try_start_0 .. :try_end_0} :catch_0

    .line 107
    :goto_0
    iget-object v1, p0, Lorg/java_websocket/client/WebSocketClient;->channel:Ljava/nio/channels/SocketChannel;

    if-nez v1, :cond_2

    .line 108
    iget-object v1, p0, Lorg/java_websocket/client/WebSocketClient;->wsfactory:Lorg/java_websocket/client/WebSocketClient$WebSocketClientFactory;

    invoke-interface {v1, p0, p2, v3}, Lorg/java_websocket/client/WebSocketClient$WebSocketClientFactory;->createWebSocket(Lorg/java_websocket/WebSocketAdapter;Lorg/java_websocket/drafts/Draft;Ljava/net/Socket;)Lorg/java_websocket/WebSocket;

    move-result-object v1

    check-cast v1, Lorg/java_websocket/WebSocketImpl;

    iput-object v1, p0, Lorg/java_websocket/client/WebSocketClient;->conn:Lorg/java_websocket/WebSocketImpl;

    .line 109
    iget-object v1, p0, Lorg/java_websocket/client/WebSocketClient;->conn:Lorg/java_websocket/WebSocketImpl;

    const/4 v2, -0x1

    const-string v3, "Failed to create or configure SocketChannel."

    invoke-virtual {v1, v2, v3}, Lorg/java_websocket/WebSocketImpl;->close(ILjava/lang/String;)V

    .line 115
    :goto_1
    return-void

    .line 103
    :catch_0
    move-exception v0

    .line 104
    .local v0, "e":Ljava/io/IOException;
    iput-object v3, p0, Lorg/java_websocket/client/WebSocketClient;->channel:Ljava/nio/channels/SocketChannel;

    .line 105
    invoke-virtual {p0, v3, v0}, Lorg/java_websocket/client/WebSocketClient;->onWebsocketError(Lorg/java_websocket/WebSocket;Ljava/lang/Exception;)V

    goto :goto_0

    .line 112
    .end local v0    # "e":Ljava/io/IOException;
    :cond_2
    iget-object v1, p0, Lorg/java_websocket/client/WebSocketClient;->wsfactory:Lorg/java_websocket/client/WebSocketClient$WebSocketClientFactory;

    iget-object v2, p0, Lorg/java_websocket/client/WebSocketClient;->channel:Ljava/nio/channels/SocketChannel;

    invoke-virtual {v2}, Ljava/nio/channels/SocketChannel;->socket()Ljava/net/Socket;

    move-result-object v2

    invoke-interface {v1, p0, p2, v2}, Lorg/java_websocket/client/WebSocketClient$WebSocketClientFactory;->createWebSocket(Lorg/java_websocket/WebSocketAdapter;Lorg/java_websocket/drafts/Draft;Ljava/net/Socket;)Lorg/java_websocket/WebSocket;

    move-result-object v1

    check-cast v1, Lorg/java_websocket/WebSocketImpl;

    iput-object v1, p0, Lorg/java_websocket/client/WebSocketClient;->conn:Lorg/java_websocket/WebSocketImpl;

    goto :goto_1
.end method

.method static synthetic access$100(Lorg/java_websocket/client/WebSocketClient;)I
    .locals 1
    .param p0, "x0"    # Lorg/java_websocket/client/WebSocketClient;

    .prologue
    .line 42
    invoke-direct {p0}, Lorg/java_websocket/client/WebSocketClient;->getPort()I

    move-result v0

    return v0
.end method

.method static synthetic access$200(Lorg/java_websocket/client/WebSocketClient;)Lorg/java_websocket/WebSocketImpl;
    .locals 1
    .param p0, "x0"    # Lorg/java_websocket/client/WebSocketClient;

    .prologue
    .line 42
    iget-object v0, p0, Lorg/java_websocket/client/WebSocketClient;->conn:Lorg/java_websocket/WebSocketImpl;

    return-object v0
.end method

.method static synthetic access$300(Lorg/java_websocket/client/WebSocketClient;)Ljava/nio/channels/ByteChannel;
    .locals 1
    .param p0, "x0"    # Lorg/java_websocket/client/WebSocketClient;

    .prologue
    .line 42
    iget-object v0, p0, Lorg/java_websocket/client/WebSocketClient;->wrappedchannel:Ljava/nio/channels/ByteChannel;

    return-object v0
.end method

.method private getPort()I
    .locals 5

    .prologue
    .line 258
    iget-object v2, p0, Lorg/java_websocket/client/WebSocketClient;->uri:Ljava/net/URI;

    invoke-virtual {v2}, Ljava/net/URI;->getPort()I

    move-result v0

    .line 259
    .local v0, "port":I
    const/4 v2, -0x1

    if-ne v0, v2, :cond_0

    .line 260
    iget-object v2, p0, Lorg/java_websocket/client/WebSocketClient;->uri:Ljava/net/URI;

    invoke-virtual {v2}, Ljava/net/URI;->getScheme()Ljava/lang/String;

    move-result-object v1

    .line 261
    .local v1, "scheme":Ljava/lang/String;
    const-string v2, "wss"

    invoke-virtual {v1, v2}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v2

    if-eqz v2, :cond_1

    .line 262
    const/16 v0, 0x1bb

    .line 269
    .end local v0    # "port":I
    .end local v1    # "scheme":Ljava/lang/String;
    :cond_0
    :goto_0
    return v0

    .line 263
    .restart local v0    # "port":I
    .restart local v1    # "scheme":Ljava/lang/String;
    :cond_1
    const-string v2, "ws"

    invoke-virtual {v1, v2}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v2

    if-eqz v2, :cond_2

    .line 264
    const/16 v0, 0x50

    goto :goto_0

    .line 266
    :cond_2
    new-instance v2, Ljava/lang/RuntimeException;

    new-instance v3, Ljava/lang/StringBuilder;

    invoke-direct {v3}, Ljava/lang/StringBuilder;-><init>()V

    const-string v4, "unkonow scheme"

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    invoke-virtual {v3, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    invoke-virtual {v3}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v3

    invoke-direct {v2, v3}, Ljava/lang/RuntimeException;-><init>(Ljava/lang/String;)V

    throw v2
.end method

.method private final interruptableRun()V
    .locals 10

    .prologue
    const/4 v9, 0x0

    .line 195
    iget-object v5, p0, Lorg/java_websocket/client/WebSocketClient;->channel:Ljava/nio/channels/SocketChannel;

    if-nez v5, :cond_1

    .line 255
    :cond_0
    :goto_0
    return-void

    .line 203
    :cond_1
    :try_start_0
    iget-object v5, p0, Lorg/java_websocket/client/WebSocketClient;->proxyAddress:Ljava/net/InetSocketAddress;

    if-eqz v5, :cond_3

    .line 204
    iget-object v5, p0, Lorg/java_websocket/client/WebSocketClient;->proxyAddress:Ljava/net/InetSocketAddress;

    invoke-virtual {v5}, Ljava/net/InetSocketAddress;->getHostName()Ljava/lang/String;

    move-result-object v2

    .line 205
    .local v2, "host":Ljava/lang/String;
    iget-object v5, p0, Lorg/java_websocket/client/WebSocketClient;->proxyAddress:Ljava/net/InetSocketAddress;

    invoke-virtual {v5}, Ljava/net/InetSocketAddress;->getPort()I

    move-result v3

    .line 210
    .local v3, "port":I
    :goto_1
    iget-object v5, p0, Lorg/java_websocket/client/WebSocketClient;->channel:Ljava/nio/channels/SocketChannel;

    new-instance v6, Ljava/net/InetSocketAddress;

    invoke-direct {v6, v2, v3}, Ljava/net/InetSocketAddress;-><init>(Ljava/lang/String;I)V

    invoke-virtual {v5, v6}, Ljava/nio/channels/SocketChannel;->connect(Ljava/net/SocketAddress;)Z

    .line 211
    iget-object v5, p0, Lorg/java_websocket/client/WebSocketClient;->conn:Lorg/java_websocket/WebSocketImpl;

    iget-object v6, p0, Lorg/java_websocket/client/WebSocketClient;->wsfactory:Lorg/java_websocket/client/WebSocketClient$WebSocketClientFactory;

    iget-object v7, p0, Lorg/java_websocket/client/WebSocketClient;->channel:Ljava/nio/channels/SocketChannel;

    const/4 v8, 0x0

    invoke-interface {v6, v7, v8, v2, v3}, Lorg/java_websocket/client/WebSocketClient$WebSocketClientFactory;->wrapChannel(Ljava/nio/channels/SocketChannel;Ljava/nio/channels/SelectionKey;Ljava/lang/String;I)Ljava/nio/channels/ByteChannel;

    move-result-object v6

    invoke-virtual {p0, v6}, Lorg/java_websocket/client/WebSocketClient;->createProxyChannel(Ljava/nio/channels/ByteChannel;)Ljava/nio/channels/ByteChannel;

    move-result-object v6

    iput-object v6, p0, Lorg/java_websocket/client/WebSocketClient;->wrappedchannel:Ljava/nio/channels/ByteChannel;

    iput-object v6, v5, Lorg/java_websocket/WebSocketImpl;->channel:Ljava/nio/channels/ByteChannel;

    .line 213
    const/4 v5, 0x0

    iput v5, p0, Lorg/java_websocket/client/WebSocketClient;->timeout:I

    .line 214
    invoke-direct {p0}, Lorg/java_websocket/client/WebSocketClient;->sendHandshake()V

    .line 215
    new-instance v5, Ljava/lang/Thread;

    new-instance v6, Lorg/java_websocket/client/WebSocketClient$WebsocketWriteThread;

    const/4 v7, 0x0

    invoke-direct {v6, p0, v7}, Lorg/java_websocket/client/WebSocketClient$WebsocketWriteThread;-><init>(Lorg/java_websocket/client/WebSocketClient;Lorg/java_websocket/client/WebSocketClient$1;)V

    invoke-direct {v5, v6}, Ljava/lang/Thread;-><init>(Ljava/lang/Runnable;)V

    iput-object v5, p0, Lorg/java_websocket/client/WebSocketClient;->readthread:Ljava/lang/Thread;

    .line 216
    iget-object v5, p0, Lorg/java_websocket/client/WebSocketClient;->readthread:Ljava/lang/Thread;

    invoke-virtual {v5}, Ljava/lang/Thread;->start()V
    :try_end_0
    .catch Ljava/nio/channels/ClosedByInterruptException; {:try_start_0 .. :try_end_0} :catch_1
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_2

    .line 226
    sget v5, Lorg/java_websocket/WebSocketImpl;->RCVBUF:I

    invoke-static {v5}, Ljava/nio/ByteBuffer;->allocate(I)Ljava/nio/ByteBuffer;

    move-result-object v0

    .line 228
    .local v0, "buff":Ljava/nio/ByteBuffer;
    :cond_2
    :goto_2
    :try_start_1
    iget-object v5, p0, Lorg/java_websocket/client/WebSocketClient;->channel:Ljava/nio/channels/SocketChannel;

    invoke-virtual {v5}, Ljava/nio/channels/SocketChannel;->isOpen()Z

    move-result v5

    if-eqz v5, :cond_0

    .line 229
    iget-object v5, p0, Lorg/java_websocket/client/WebSocketClient;->conn:Lorg/java_websocket/WebSocketImpl;

    iget-object v6, p0, Lorg/java_websocket/client/WebSocketClient;->wrappedchannel:Ljava/nio/channels/ByteChannel;

    invoke-static {v0, v5, v6}, Lorg/java_websocket/SocketChannelIOHelper;->read(Ljava/nio/ByteBuffer;Lorg/java_websocket/WebSocketImpl;Ljava/nio/channels/ByteChannel;)Z

    move-result v5

    if-eqz v5, :cond_4

    .line 230
    iget-object v5, p0, Lorg/java_websocket/client/WebSocketClient;->conn:Lorg/java_websocket/WebSocketImpl;

    invoke-virtual {v5, v0}, Lorg/java_websocket/WebSocketImpl;->decode(Ljava/nio/ByteBuffer;)V

    .line 235
    :goto_3
    iget-object v5, p0, Lorg/java_websocket/client/WebSocketClient;->wrappedchannel:Ljava/nio/channels/ByteChannel;

    instance-of v5, v5, Lorg/java_websocket/WrappedByteChannel;

    if-eqz v5, :cond_2

    .line 236
    iget-object v4, p0, Lorg/java_websocket/client/WebSocketClient;->wrappedchannel:Ljava/nio/channels/ByteChannel;

    check-cast v4, Lorg/java_websocket/WrappedByteChannel;

    .line 237
    .local v4, "w":Lorg/java_websocket/WrappedByteChannel;
    invoke-interface {v4}, Lorg/java_websocket/WrappedByteChannel;->isNeedRead()Z

    move-result v5

    if-eqz v5, :cond_2

    .line 238
    :goto_4
    iget-object v5, p0, Lorg/java_websocket/client/WebSocketClient;->conn:Lorg/java_websocket/WebSocketImpl;

    invoke-static {v0, v5, v4}, Lorg/java_websocket/SocketChannelIOHelper;->readMore(Ljava/nio/ByteBuffer;Lorg/java_websocket/WebSocketImpl;Lorg/java_websocket/WrappedByteChannel;)Z

    move-result v5

    if-eqz v5, :cond_5

    .line 239
    iget-object v5, p0, Lorg/java_websocket/client/WebSocketClient;->conn:Lorg/java_websocket/WebSocketImpl;

    invoke-virtual {v5, v0}, Lorg/java_websocket/WebSocketImpl;->decode(Ljava/nio/ByteBuffer;)V
    :try_end_1
    .catch Ljava/nio/channels/CancelledKeyException; {:try_start_1 .. :try_end_1} :catch_0
    .catch Ljava/io/IOException; {:try_start_1 .. :try_end_1} :catch_3
    .catch Ljava/lang/RuntimeException; {:try_start_1 .. :try_end_1} :catch_4

    goto :goto_4

    .line 246
    .end local v4    # "w":Lorg/java_websocket/WrappedByteChannel;
    :catch_0
    move-exception v1

    .line 247
    .local v1, "e":Ljava/nio/channels/CancelledKeyException;
    iget-object v5, p0, Lorg/java_websocket/client/WebSocketClient;->conn:Lorg/java_websocket/WebSocketImpl;

    invoke-virtual {v5}, Lorg/java_websocket/WebSocketImpl;->eot()V

    goto/16 :goto_0

    .line 207
    .end local v0    # "buff":Ljava/nio/ByteBuffer;
    .end local v1    # "e":Ljava/nio/channels/CancelledKeyException;
    .end local v2    # "host":Ljava/lang/String;
    .end local v3    # "port":I
    :cond_3
    :try_start_2
    iget-object v5, p0, Lorg/java_websocket/client/WebSocketClient;->uri:Ljava/net/URI;

    invoke-virtual {v5}, Ljava/net/URI;->getHost()Ljava/lang/String;

    move-result-object v2

    .line 208
    .restart local v2    # "host":Ljava/lang/String;
    invoke-direct {p0}, Lorg/java_websocket/client/WebSocketClient;->getPort()I
    :try_end_2
    .catch Ljava/nio/channels/ClosedByInterruptException; {:try_start_2 .. :try_end_2} :catch_1
    .catch Ljava/lang/Exception; {:try_start_2 .. :try_end_2} :catch_2

    move-result v3

    .restart local v3    # "port":I
    goto/16 :goto_1

    .line 217
    .end local v2    # "host":Ljava/lang/String;
    .end local v3    # "port":I
    :catch_1
    move-exception v1

    .line 218
    .local v1, "e":Ljava/nio/channels/ClosedByInterruptException;
    invoke-virtual {p0, v9, v1}, Lorg/java_websocket/client/WebSocketClient;->onWebsocketError(Lorg/java_websocket/WebSocket;Ljava/lang/Exception;)V

    goto/16 :goto_0

    .line 220
    .end local v1    # "e":Ljava/nio/channels/ClosedByInterruptException;
    :catch_2
    move-exception v1

    .line 221
    .local v1, "e":Ljava/lang/Exception;
    iget-object v5, p0, Lorg/java_websocket/client/WebSocketClient;->conn:Lorg/java_websocket/WebSocketImpl;

    invoke-virtual {p0, v5, v1}, Lorg/java_websocket/client/WebSocketClient;->onWebsocketError(Lorg/java_websocket/WebSocket;Ljava/lang/Exception;)V

    .line 222
    iget-object v5, p0, Lorg/java_websocket/client/WebSocketClient;->conn:Lorg/java_websocket/WebSocketImpl;

    const/4 v6, -0x1

    invoke-virtual {v1}, Ljava/lang/Exception;->getMessage()Ljava/lang/String;

    move-result-object v7

    invoke-virtual {v5, v6, v7}, Lorg/java_websocket/WebSocketImpl;->closeConnection(ILjava/lang/String;)V

    goto/16 :goto_0

    .line 232
    .end local v1    # "e":Ljava/lang/Exception;
    .restart local v0    # "buff":Ljava/nio/ByteBuffer;
    .restart local v2    # "host":Ljava/lang/String;
    .restart local v3    # "port":I
    :cond_4
    :try_start_3
    iget-object v5, p0, Lorg/java_websocket/client/WebSocketClient;->conn:Lorg/java_websocket/WebSocketImpl;

    invoke-virtual {v5}, Lorg/java_websocket/WebSocketImpl;->eot()V
    :try_end_3
    .catch Ljava/nio/channels/CancelledKeyException; {:try_start_3 .. :try_end_3} :catch_0
    .catch Ljava/io/IOException; {:try_start_3 .. :try_end_3} :catch_3
    .catch Ljava/lang/RuntimeException; {:try_start_3 .. :try_end_3} :catch_4

    goto :goto_3

    .line 248
    :catch_3
    move-exception v1

    .line 249
    .local v1, "e":Ljava/io/IOException;
    iget-object v5, p0, Lorg/java_websocket/client/WebSocketClient;->conn:Lorg/java_websocket/WebSocketImpl;

    invoke-virtual {v5}, Lorg/java_websocket/WebSocketImpl;->eot()V

    goto/16 :goto_0

    .line 241
    .end local v1    # "e":Ljava/io/IOException;
    .restart local v4    # "w":Lorg/java_websocket/WrappedByteChannel;
    :cond_5
    :try_start_4
    iget-object v5, p0, Lorg/java_websocket/client/WebSocketClient;->conn:Lorg/java_websocket/WebSocketImpl;

    invoke-virtual {v5, v0}, Lorg/java_websocket/WebSocketImpl;->decode(Ljava/nio/ByteBuffer;)V
    :try_end_4
    .catch Ljava/nio/channels/CancelledKeyException; {:try_start_4 .. :try_end_4} :catch_0
    .catch Ljava/io/IOException; {:try_start_4 .. :try_end_4} :catch_3
    .catch Ljava/lang/RuntimeException; {:try_start_4 .. :try_end_4} :catch_4

    goto :goto_2

    .line 250
    .end local v4    # "w":Lorg/java_websocket/WrappedByteChannel;
    :catch_4
    move-exception v1

    .line 252
    .local v1, "e":Ljava/lang/RuntimeException;
    invoke-virtual {p0, v1}, Lorg/java_websocket/client/WebSocketClient;->onError(Ljava/lang/Exception;)V

    .line 253
    iget-object v5, p0, Lorg/java_websocket/client/WebSocketClient;->conn:Lorg/java_websocket/WebSocketImpl;

    const/16 v6, 0x3ee

    invoke-virtual {v1}, Ljava/lang/RuntimeException;->getMessage()Ljava/lang/String;

    move-result-object v7

    invoke-virtual {v5, v6, v7}, Lorg/java_websocket/WebSocketImpl;->closeConnection(ILjava/lang/String;)V

    goto/16 :goto_0
.end method

.method private sendHandshake()V
    .locals 11
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Lorg/java_websocket/exceptions/InvalidHandshakeException;
        }
    .end annotation

    .prologue
    .line 274
    iget-object v8, p0, Lorg/java_websocket/client/WebSocketClient;->uri:Ljava/net/URI;

    invoke-virtual {v8}, Ljava/net/URI;->getPath()Ljava/lang/String;

    move-result-object v4

    .line 275
    .local v4, "part1":Ljava/lang/String;
    iget-object v8, p0, Lorg/java_websocket/client/WebSocketClient;->uri:Ljava/net/URI;

    invoke-virtual {v8}, Ljava/net/URI;->getQuery()Ljava/lang/String;

    move-result-object v5

    .line 276
    .local v5, "part2":Ljava/lang/String;
    if-eqz v4, :cond_0

    invoke-virtual {v4}, Ljava/lang/String;->length()I

    move-result v8

    if-nez v8, :cond_2

    .line 277
    :cond_0
    const-string v6, "/"

    .line 280
    .local v6, "path":Ljava/lang/String;
    :goto_0
    if-eqz v5, :cond_1

    .line 281
    new-instance v8, Ljava/lang/StringBuilder;

    invoke-direct {v8}, Ljava/lang/StringBuilder;-><init>()V

    invoke-virtual {v8, v6}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v8

    const-string v9, "?"

    invoke-virtual {v8, v9}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v8

    invoke-virtual {v8, v5}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v8

    invoke-virtual {v8}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v6

    .line 282
    :cond_1
    invoke-direct {p0}, Lorg/java_websocket/client/WebSocketClient;->getPort()I

    move-result v7

    .line 283
    .local v7, "port":I
    new-instance v8, Ljava/lang/StringBuilder;

    invoke-direct {v8}, Ljava/lang/StringBuilder;-><init>()V

    iget-object v9, p0, Lorg/java_websocket/client/WebSocketClient;->uri:Ljava/net/URI;

    invoke-virtual {v9}, Ljava/net/URI;->getHost()Ljava/lang/String;

    move-result-object v9

    invoke-virtual {v8, v9}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v9

    const/16 v8, 0x50

    if-eq v7, v8, :cond_3

    new-instance v8, Ljava/lang/StringBuilder;

    invoke-direct {v8}, Ljava/lang/StringBuilder;-><init>()V

    const-string v10, ":"

    invoke-virtual {v8, v10}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v8

    invoke-virtual {v8, v7}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v8

    invoke-virtual {v8}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v8

    :goto_1
    invoke-virtual {v9, v8}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v8

    invoke-virtual {v8}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    .line 285
    .local v1, "host":Ljava/lang/String;
    new-instance v0, Lorg/java_websocket/handshake/HandshakeImpl1Client;

    invoke-direct {v0}, Lorg/java_websocket/handshake/HandshakeImpl1Client;-><init>()V

    .line 286
    .local v0, "handshake":Lorg/java_websocket/handshake/HandshakeImpl1Client;
    invoke-virtual {v0, v6}, Lorg/java_websocket/handshake/HandshakeImpl1Client;->setResourceDescriptor(Ljava/lang/String;)V

    .line 287
    const-string v8, "Host"

    invoke-virtual {v0, v8, v1}, Lorg/java_websocket/handshake/HandshakeImpl1Client;->put(Ljava/lang/String;Ljava/lang/String;)V

    .line 288
    iget-object v8, p0, Lorg/java_websocket/client/WebSocketClient;->headers:Ljava/util/Map;

    if-eqz v8, :cond_4

    .line 289
    iget-object v8, p0, Lorg/java_websocket/client/WebSocketClient;->headers:Ljava/util/Map;

    invoke-interface {v8}, Ljava/util/Map;->entrySet()Ljava/util/Set;

    move-result-object v8

    invoke-interface {v8}, Ljava/util/Set;->iterator()Ljava/util/Iterator;

    move-result-object v2

    .local v2, "i$":Ljava/util/Iterator;
    :goto_2
    invoke-interface {v2}, Ljava/util/Iterator;->hasNext()Z

    move-result v8

    if-eqz v8, :cond_4

    invoke-interface {v2}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v3

    check-cast v3, Ljava/util/Map$Entry;

    .line 290
    .local v3, "kv":Ljava/util/Map$Entry;, "Ljava/util/Map$Entry<Ljava/lang/String;Ljava/lang/String;>;"
    invoke-interface {v3}, Ljava/util/Map$Entry;->getKey()Ljava/lang/Object;

    move-result-object v8

    check-cast v8, Ljava/lang/String;

    invoke-interface {v3}, Ljava/util/Map$Entry;->getValue()Ljava/lang/Object;

    move-result-object v9

    check-cast v9, Ljava/lang/String;

    invoke-virtual {v0, v8, v9}, Lorg/java_websocket/handshake/HandshakeImpl1Client;->put(Ljava/lang/String;Ljava/lang/String;)V

    goto :goto_2

    .line 279
    .end local v0    # "handshake":Lorg/java_websocket/handshake/HandshakeImpl1Client;
    .end local v1    # "host":Ljava/lang/String;
    .end local v2    # "i$":Ljava/util/Iterator;
    .end local v3    # "kv":Ljava/util/Map$Entry;, "Ljava/util/Map$Entry<Ljava/lang/String;Ljava/lang/String;>;"
    .end local v6    # "path":Ljava/lang/String;
    .end local v7    # "port":I
    :cond_2
    move-object v6, v4

    .restart local v6    # "path":Ljava/lang/String;
    goto/16 :goto_0

    .line 283
    .restart local v7    # "port":I
    :cond_3
    const-string v8, ""

    goto :goto_1

    .line 293
    .restart local v0    # "handshake":Lorg/java_websocket/handshake/HandshakeImpl1Client;
    .restart local v1    # "host":Ljava/lang/String;
    :cond_4
    iget-object v8, p0, Lorg/java_websocket/client/WebSocketClient;->conn:Lorg/java_websocket/WebSocketImpl;

    invoke-virtual {v8, v0}, Lorg/java_websocket/WebSocketImpl;->startHandshake(Lorg/java_websocket/handshake/ClientHandshakeBuilder;)V

    .line 294
    return-void
.end method


# virtual methods
.method public close()V
    .locals 2

    .prologue
    .line 154
    iget-object v0, p0, Lorg/java_websocket/client/WebSocketClient;->writethread:Ljava/lang/Thread;

    if-eqz v0, :cond_0

    .line 155
    iget-object v0, p0, Lorg/java_websocket/client/WebSocketClient;->conn:Lorg/java_websocket/WebSocketImpl;

    const/16 v1, 0x3e8

    invoke-virtual {v0, v1}, Lorg/java_websocket/WebSocketImpl;->close(I)V

    .line 157
    :cond_0
    return-void
.end method

.method public closeBlocking()V
    .locals 1
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/lang/InterruptedException;
        }
    .end annotation

    .prologue
    .line 160
    invoke-virtual {p0}, Lorg/java_websocket/client/WebSocketClient;->close()V

    .line 161
    iget-object v0, p0, Lorg/java_websocket/client/WebSocketClient;->closeLatch:Ljava/util/concurrent/CountDownLatch;

    invoke-virtual {v0}, Ljava/util/concurrent/CountDownLatch;->await()V

    .line 162
    return-void
.end method

.method public connect()V
    .locals 2

    .prologue
    .line 137
    iget-object v0, p0, Lorg/java_websocket/client/WebSocketClient;->writethread:Ljava/lang/Thread;

    if-eqz v0, :cond_0

    .line 138
    new-instance v0, Ljava/lang/IllegalStateException;

    const-string v1, "WebSocketClient objects are not reuseable"

    invoke-direct {v0, v1}, Ljava/lang/IllegalStateException;-><init>(Ljava/lang/String;)V

    throw v0

    .line 139
    :cond_0
    new-instance v0, Ljava/lang/Thread;

    invoke-direct {v0, p0}, Ljava/lang/Thread;-><init>(Ljava/lang/Runnable;)V

    iput-object v0, p0, Lorg/java_websocket/client/WebSocketClient;->writethread:Ljava/lang/Thread;

    .line 140
    iget-object v0, p0, Lorg/java_websocket/client/WebSocketClient;->writethread:Ljava/lang/Thread;

    invoke-virtual {v0}, Ljava/lang/Thread;->start()V

    .line 141
    return-void
.end method

.method public connectBlocking()Z
    .locals 1
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/lang/InterruptedException;
        }
    .end annotation

    .prologue
    .line 148
    invoke-virtual {p0}, Lorg/java_websocket/client/WebSocketClient;->connect()V

    .line 149
    iget-object v0, p0, Lorg/java_websocket/client/WebSocketClient;->connectLatch:Ljava/util/concurrent/CountDownLatch;

    invoke-virtual {v0}, Ljava/util/concurrent/CountDownLatch;->await()V

    .line 150
    iget-object v0, p0, Lorg/java_websocket/client/WebSocketClient;->conn:Lorg/java_websocket/WebSocketImpl;

    invoke-virtual {v0}, Lorg/java_websocket/WebSocketImpl;->isOpen()Z

    move-result v0

    return v0
.end method

.method public createProxyChannel(Ljava/nio/channels/ByteChannel;)Ljava/nio/channels/ByteChannel;
    .locals 1
    .param p1, "towrap"    # Ljava/nio/channels/ByteChannel;

    .prologue
    .line 451
    iget-object v0, p0, Lorg/java_websocket/client/WebSocketClient;->proxyAddress:Ljava/net/InetSocketAddress;

    if-eqz v0, :cond_0

    .line 452
    new-instance v0, Lorg/java_websocket/client/WebSocketClient$DefaultClientProxyChannel;

    invoke-direct {v0, p0, p1}, Lorg/java_websocket/client/WebSocketClient$DefaultClientProxyChannel;-><init>(Lorg/java_websocket/client/WebSocketClient;Ljava/nio/channels/ByteChannel;)V

    move-object p1, v0

    .line 454
    .end local p1    # "towrap":Ljava/nio/channels/ByteChannel;
    :cond_0
    return-object p1
.end method

.method public getConnection()Lorg/java_websocket/WebSocket;
    .locals 1

    .prologue
    .line 377
    iget-object v0, p0, Lorg/java_websocket/client/WebSocketClient;->conn:Lorg/java_websocket/WebSocketImpl;

    return-object v0
.end method

.method public getDraft()Lorg/java_websocket/drafts/Draft;
    .locals 1

    .prologue
    .line 128
    iget-object v0, p0, Lorg/java_websocket/client/WebSocketClient;->draft:Lorg/java_websocket/drafts/Draft;

    return-object v0
.end method

.method public getLocalSocketAddress(Lorg/java_websocket/WebSocket;)Ljava/net/InetSocketAddress;
    .locals 1
    .param p1, "conn"    # Lorg/java_websocket/WebSocket;

    .prologue
    .line 390
    iget-object v0, p0, Lorg/java_websocket/client/WebSocketClient;->channel:Ljava/nio/channels/SocketChannel;

    if-eqz v0, :cond_0

    .line 391
    iget-object v0, p0, Lorg/java_websocket/client/WebSocketClient;->channel:Ljava/nio/channels/SocketChannel;

    invoke-virtual {v0}, Ljava/nio/channels/SocketChannel;->socket()Ljava/net/Socket;

    move-result-object v0

    invoke-virtual {v0}, Ljava/net/Socket;->getLocalSocketAddress()Ljava/net/SocketAddress;

    move-result-object v0

    check-cast v0, Ljava/net/InetSocketAddress;

    .line 392
    :goto_0
    return-object v0

    :cond_0
    const/4 v0, 0x0

    goto :goto_0
.end method

.method public getReadyState()Lorg/java_websocket/WebSocket$READYSTATE;
    .locals 1

    .prologue
    .line 301
    iget-object v0, p0, Lorg/java_websocket/client/WebSocketClient;->conn:Lorg/java_websocket/WebSocketImpl;

    invoke-virtual {v0}, Lorg/java_websocket/WebSocketImpl;->getReadyState()Lorg/java_websocket/WebSocket$READYSTATE;

    move-result-object v0

    return-object v0
.end method

.method public getRemoteSocketAddress(Lorg/java_websocket/WebSocket;)Ljava/net/InetSocketAddress;
    .locals 1
    .param p1, "conn"    # Lorg/java_websocket/WebSocket;

    .prologue
    .line 397
    iget-object v0, p0, Lorg/java_websocket/client/WebSocketClient;->channel:Ljava/nio/channels/SocketChannel;

    if-eqz v0, :cond_0

    .line 398
    iget-object v0, p0, Lorg/java_websocket/client/WebSocketClient;->channel:Ljava/nio/channels/SocketChannel;

    invoke-virtual {v0}, Ljava/nio/channels/SocketChannel;->socket()Ljava/net/Socket;

    move-result-object v0

    invoke-virtual {v0}, Ljava/net/Socket;->getLocalSocketAddress()Ljava/net/SocketAddress;

    move-result-object v0

    check-cast v0, Ljava/net/InetSocketAddress;

    .line 399
    :goto_0
    return-object v0

    :cond_0
    const/4 v0, 0x0

    goto :goto_0
.end method

.method public getURI()Ljava/net/URI;
    .locals 1

    .prologue
    .line 123
    iget-object v0, p0, Lorg/java_websocket/client/WebSocketClient;->uri:Ljava/net/URI;

    return-object v0
.end method

.method public final getWebSocketFactory()Lorg/java_websocket/WebSocketFactory;
    .locals 1

    .prologue
    .line 385
    iget-object v0, p0, Lorg/java_websocket/client/WebSocketClient;->wsfactory:Lorg/java_websocket/client/WebSocketClient$WebSocketClientFactory;

    return-object v0
.end method

.method public abstract onClose(ILjava/lang/String;Z)V
.end method

.method public onCloseInitiated(ILjava/lang/String;)V
    .locals 0
    .param p1, "code"    # I
    .param p2, "reason"    # Ljava/lang/String;

    .prologue
    .line 371
    return-void
.end method

.method public onClosing(ILjava/lang/String;Z)V
    .locals 0
    .param p1, "code"    # I
    .param p2, "reason"    # Ljava/lang/String;
    .param p3, "remote"    # Z

    .prologue
    .line 374
    return-void
.end method

.method public abstract onError(Ljava/lang/Exception;)V
.end method

.method public abstract onMessage(Ljava/lang/String;)V
.end method

.method public onMessage(Ljava/nio/ByteBuffer;)V
    .locals 0
    .param p1, "bytes"    # Ljava/nio/ByteBuffer;

    .prologue
    .line 408
    return-void
.end method

.method public abstract onOpen(Lorg/java_websocket/handshake/ServerHandshake;)V
.end method

.method public final onWebsocketClose(Lorg/java_websocket/WebSocket;ILjava/lang/String;Z)V
    .locals 1
    .param p1, "conn"    # Lorg/java_websocket/WebSocket;
    .param p2, "code"    # I
    .param p3, "reason"    # Ljava/lang/String;
    .param p4, "remote"    # Z

    .prologue
    .line 338
    iget-object v0, p0, Lorg/java_websocket/client/WebSocketClient;->connectLatch:Ljava/util/concurrent/CountDownLatch;

    invoke-virtual {v0}, Ljava/util/concurrent/CountDownLatch;->countDown()V

    .line 339
    iget-object v0, p0, Lorg/java_websocket/client/WebSocketClient;->closeLatch:Ljava/util/concurrent/CountDownLatch;

    invoke-virtual {v0}, Ljava/util/concurrent/CountDownLatch;->countDown()V

    .line 340
    iget-object v0, p0, Lorg/java_websocket/client/WebSocketClient;->readthread:Ljava/lang/Thread;

    if-eqz v0, :cond_0

    .line 341
    iget-object v0, p0, Lorg/java_websocket/client/WebSocketClient;->readthread:Ljava/lang/Thread;

    invoke-virtual {v0}, Ljava/lang/Thread;->interrupt()V

    .line 342
    :cond_0
    invoke-virtual {p0, p2, p3, p4}, Lorg/java_websocket/client/WebSocketClient;->onClose(ILjava/lang/String;Z)V

    .line 343
    return-void
.end method

.method public onWebsocketCloseInitiated(Lorg/java_websocket/WebSocket;ILjava/lang/String;)V
    .locals 0
    .param p1, "conn"    # Lorg/java_websocket/WebSocket;
    .param p2, "code"    # I
    .param p3, "reason"    # Ljava/lang/String;

    .prologue
    .line 362
    invoke-virtual {p0, p2, p3}, Lorg/java_websocket/client/WebSocketClient;->onCloseInitiated(ILjava/lang/String;)V

    .line 363
    return-void
.end method

.method public onWebsocketClosing(Lorg/java_websocket/WebSocket;ILjava/lang/String;Z)V
    .locals 0
    .param p1, "conn"    # Lorg/java_websocket/WebSocket;
    .param p2, "code"    # I
    .param p3, "reason"    # Ljava/lang/String;
    .param p4, "remote"    # Z

    .prologue
    .line 367
    invoke-virtual {p0, p2, p3, p4}, Lorg/java_websocket/client/WebSocketClient;->onClosing(ILjava/lang/String;Z)V

    .line 368
    return-void
.end method

.method public final onWebsocketError(Lorg/java_websocket/WebSocket;Ljava/lang/Exception;)V
    .locals 0
    .param p1, "conn"    # Lorg/java_websocket/WebSocket;
    .param p2, "ex"    # Ljava/lang/Exception;

    .prologue
    .line 352
    invoke-virtual {p0, p2}, Lorg/java_websocket/client/WebSocketClient;->onError(Ljava/lang/Exception;)V

    .line 353
    return-void
.end method

.method public final onWebsocketMessage(Lorg/java_websocket/WebSocket;Ljava/lang/String;)V
    .locals 0
    .param p1, "conn"    # Lorg/java_websocket/WebSocket;
    .param p2, "message"    # Ljava/lang/String;

    .prologue
    .line 312
    invoke-virtual {p0, p2}, Lorg/java_websocket/client/WebSocketClient;->onMessage(Ljava/lang/String;)V

    .line 313
    return-void
.end method

.method public final onWebsocketMessage(Lorg/java_websocket/WebSocket;Ljava/nio/ByteBuffer;)V
    .locals 0
    .param p1, "conn"    # Lorg/java_websocket/WebSocket;
    .param p2, "blob"    # Ljava/nio/ByteBuffer;

    .prologue
    .line 317
    invoke-virtual {p0, p2}, Lorg/java_websocket/client/WebSocketClient;->onMessage(Ljava/nio/ByteBuffer;)V

    .line 318
    return-void
.end method

.method public final onWebsocketOpen(Lorg/java_websocket/WebSocket;Lorg/java_websocket/handshake/Handshakedata;)V
    .locals 1
    .param p1, "conn"    # Lorg/java_websocket/WebSocket;
    .param p2, "handshake"    # Lorg/java_websocket/handshake/Handshakedata;

    .prologue
    .line 327
    iget-object v0, p0, Lorg/java_websocket/client/WebSocketClient;->connectLatch:Ljava/util/concurrent/CountDownLatch;

    invoke-virtual {v0}, Ljava/util/concurrent/CountDownLatch;->countDown()V

    .line 328
    check-cast p2, Lorg/java_websocket/handshake/ServerHandshake;

    .end local p2    # "handshake":Lorg/java_websocket/handshake/Handshakedata;
    invoke-virtual {p0, p2}, Lorg/java_websocket/client/WebSocketClient;->onOpen(Lorg/java_websocket/handshake/ServerHandshake;)V

    .line 329
    return-void
.end method

.method public final onWriteDemand(Lorg/java_websocket/WebSocket;)V
    .locals 0
    .param p1, "conn"    # Lorg/java_websocket/WebSocket;

    .prologue
    .line 358
    return-void
.end method

.method public run()V
    .locals 1

    .prologue
    .line 186
    iget-object v0, p0, Lorg/java_websocket/client/WebSocketClient;->writethread:Ljava/lang/Thread;

    if-nez v0, :cond_0

    .line 187
    invoke-static {}, Ljava/lang/Thread;->currentThread()Ljava/lang/Thread;

    move-result-object v0

    iput-object v0, p0, Lorg/java_websocket/client/WebSocketClient;->writethread:Ljava/lang/Thread;

    .line 188
    :cond_0
    invoke-direct {p0}, Lorg/java_websocket/client/WebSocketClient;->interruptableRun()V

    .line 190
    sget-boolean v0, Lorg/java_websocket/client/WebSocketClient;->$assertionsDisabled:Z

    if-nez v0, :cond_1

    iget-object v0, p0, Lorg/java_websocket/client/WebSocketClient;->channel:Ljava/nio/channels/SocketChannel;

    invoke-virtual {v0}, Ljava/nio/channels/SocketChannel;->isOpen()Z

    move-result v0

    if-eqz v0, :cond_1

    new-instance v0, Ljava/lang/AssertionError;

    invoke-direct {v0}, Ljava/lang/AssertionError;-><init>()V

    throw v0

    .line 192
    :cond_1
    return-void
.end method

.method public send(Ljava/lang/String;)V
    .locals 1
    .param p1, "text"    # Ljava/lang/String;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/nio/channels/NotYetConnectedException;
        }
    .end annotation

    .prologue
    .line 171
    iget-object v0, p0, Lorg/java_websocket/client/WebSocketClient;->conn:Lorg/java_websocket/WebSocketImpl;

    invoke-virtual {v0, p1}, Lorg/java_websocket/WebSocketImpl;->send(Ljava/lang/String;)V

    .line 172
    return-void
.end method

.method public send([B)V
    .locals 1
    .param p1, "data"    # [B
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/nio/channels/NotYetConnectedException;
        }
    .end annotation

    .prologue
    .line 181
    iget-object v0, p0, Lorg/java_websocket/client/WebSocketClient;->conn:Lorg/java_websocket/WebSocketImpl;

    invoke-virtual {v0, p1}, Lorg/java_websocket/WebSocketImpl;->send([B)V

    .line 182
    return-void
.end method

.method public setProxy(Ljava/net/InetSocketAddress;)V
    .locals 0
    .param p1, "proxyaddress"    # Ljava/net/InetSocketAddress;

    .prologue
    .line 458
    iput-object p1, p0, Lorg/java_websocket/client/WebSocketClient;->proxyAddress:Ljava/net/InetSocketAddress;

    .line 459
    return-void
.end method

.method public final setWebSocketFactory(Lorg/java_websocket/client/WebSocketClient$WebSocketClientFactory;)V
    .locals 0
    .param p1, "wsf"    # Lorg/java_websocket/client/WebSocketClient$WebSocketClientFactory;

    .prologue
    .line 381
    iput-object p1, p0, Lorg/java_websocket/client/WebSocketClient;->wsfactory:Lorg/java_websocket/client/WebSocketClient$WebSocketClientFactory;

    .line 382
    return-void
.end method

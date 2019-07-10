.class public Lorg/java_websocket/SocketChannelIOHelper;
.super Ljava/lang/Object;
.source "SocketChannelIOHelper.java"


# static fields
.field static final synthetic $assertionsDisabled:Z


# direct methods
.method static constructor <clinit>()V
    .locals 1

    .prologue
    .line 8
    const-class v0, Lorg/java_websocket/SocketChannelIOHelper;

    invoke-virtual {v0}, Ljava/lang/Class;->desiredAssertionStatus()Z

    move-result v0

    if-nez v0, :cond_0

    const/4 v0, 0x1

    :goto_0
    sput-boolean v0, Lorg/java_websocket/SocketChannelIOHelper;->$assertionsDisabled:Z

    return-void

    :cond_0
    const/4 v0, 0x0

    goto :goto_0
.end method

.method public constructor <init>()V
    .locals 0

    .prologue
    .line 8
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method

.method public static batch(Lorg/java_websocket/WebSocketImpl;Ljava/nio/channels/ByteChannel;)Z
    .locals 5
    .param p0, "ws"    # Lorg/java_websocket/WebSocketImpl;
    .param p1, "sockchannel"    # Ljava/nio/channels/ByteChannel;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;
        }
    .end annotation

    .prologue
    const/4 v2, 0x1

    const/4 v3, 0x0

    .line 40
    iget-object v4, p0, Lorg/java_websocket/WebSocketImpl;->outQueue:Ljava/util/concurrent/BlockingQueue;

    invoke-interface {v4}, Ljava/util/concurrent/BlockingQueue;->peek()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Ljava/nio/ByteBuffer;

    .line 41
    .local v0, "buffer":Ljava/nio/ByteBuffer;
    const/4 v1, 0x0

    .line 43
    .local v1, "c":Lorg/java_websocket/WrappedByteChannel;
    if-nez v0, :cond_3

    .line 44
    instance-of v4, p1, Lorg/java_websocket/WrappedByteChannel;

    if-eqz v4, :cond_0

    move-object v1, p1

    .line 45
    check-cast v1, Lorg/java_websocket/WrappedByteChannel;

    .line 46
    invoke-interface {v1}, Lorg/java_websocket/WrappedByteChannel;->isNeedWrite()Z

    move-result v4

    if-eqz v4, :cond_0

    .line 47
    invoke-interface {v1}, Lorg/java_websocket/WrappedByteChannel;->writeMore()V

    .line 62
    :cond_0
    :goto_0
    iget-object v4, p0, Lorg/java_websocket/WebSocketImpl;->outQueue:Ljava/util/concurrent/BlockingQueue;

    invoke-interface {v4}, Ljava/util/concurrent/BlockingQueue;->isEmpty()Z

    move-result v4

    if-eqz v4, :cond_1

    invoke-virtual {p0}, Lorg/java_websocket/WebSocketImpl;->isFlushAndClose()Z

    move-result v4

    if-eqz v4, :cond_1

    .line 63
    monitor-enter p0

    .line 64
    :try_start_0
    invoke-virtual {p0}, Lorg/java_websocket/WebSocketImpl;->closeConnection()V

    .line 65
    monitor-exit p0
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    .line 67
    :cond_1
    if-eqz v1, :cond_2

    check-cast p1, Lorg/java_websocket/WrappedByteChannel;

    .end local p1    # "sockchannel":Ljava/nio/channels/ByteChannel;
    invoke-interface {p1}, Lorg/java_websocket/WrappedByteChannel;->isNeedWrite()Z

    move-result v4

    if-nez v4, :cond_5

    :cond_2
    :goto_1
    return v2

    .line 52
    .restart local p1    # "sockchannel":Ljava/nio/channels/ByteChannel;
    :cond_3
    invoke-interface {p1, v0}, Ljava/nio/channels/ByteChannel;->write(Ljava/nio/ByteBuffer;)I

    .line 53
    invoke-virtual {v0}, Ljava/nio/ByteBuffer;->remaining()I

    move-result v4

    if-lez v4, :cond_4

    move v2, v3

    .line 54
    goto :goto_1

    .line 56
    :cond_4
    iget-object v4, p0, Lorg/java_websocket/WebSocketImpl;->outQueue:Ljava/util/concurrent/BlockingQueue;

    invoke-interface {v4}, Ljava/util/concurrent/BlockingQueue;->poll()Ljava/lang/Object;

    .line 57
    iget-object v4, p0, Lorg/java_websocket/WebSocketImpl;->outQueue:Ljava/util/concurrent/BlockingQueue;

    invoke-interface {v4}, Ljava/util/concurrent/BlockingQueue;->peek()Ljava/lang/Object;

    move-result-object v0

    .end local v0    # "buffer":Ljava/nio/ByteBuffer;
    check-cast v0, Ljava/nio/ByteBuffer;

    .line 59
    .restart local v0    # "buffer":Ljava/nio/ByteBuffer;
    if-nez v0, :cond_3

    goto :goto_0

    .line 65
    :catchall_0
    move-exception v2

    :try_start_1
    monitor-exit p0
    :try_end_1
    .catchall {:try_start_1 .. :try_end_1} :catchall_0

    throw v2

    .end local p1    # "sockchannel":Ljava/nio/channels/ByteChannel;
    :cond_5
    move v2, v3

    .line 67
    goto :goto_1
.end method

.method public static read(Ljava/nio/ByteBuffer;Lorg/java_websocket/WebSocketImpl;Ljava/nio/channels/ByteChannel;)Z
    .locals 3
    .param p0, "buf"    # Ljava/nio/ByteBuffer;
    .param p1, "ws"    # Lorg/java_websocket/WebSocketImpl;
    .param p2, "channel"    # Ljava/nio/channels/ByteChannel;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;
        }
    .end annotation

    .prologue
    const/4 v1, 0x0

    .line 11
    invoke-virtual {p0}, Ljava/nio/ByteBuffer;->clear()Ljava/nio/Buffer;

    .line 12
    invoke-interface {p2, p0}, Ljava/nio/channels/ByteChannel;->read(Ljava/nio/ByteBuffer;)I

    move-result v0

    .line 13
    .local v0, "read":I
    invoke-virtual {p0}, Ljava/nio/ByteBuffer;->flip()Ljava/nio/Buffer;

    .line 15
    const/4 v2, -0x1

    if-ne v0, v2, :cond_1

    .line 16
    invoke-virtual {p1}, Lorg/java_websocket/WebSocketImpl;->eot()V

    .line 19
    :cond_0
    :goto_0
    return v1

    :cond_1
    if-eqz v0, :cond_0

    const/4 v1, 0x1

    goto :goto_0
.end method

.method public static readMore(Ljava/nio/ByteBuffer;Lorg/java_websocket/WebSocketImpl;Lorg/java_websocket/WrappedByteChannel;)Z
    .locals 2
    .param p0, "buf"    # Ljava/nio/ByteBuffer;
    .param p1, "ws"    # Lorg/java_websocket/WebSocketImpl;
    .param p2, "channel"    # Lorg/java_websocket/WrappedByteChannel;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;
        }
    .end annotation

    .prologue
    .line 27
    invoke-virtual {p0}, Ljava/nio/ByteBuffer;->clear()Ljava/nio/Buffer;

    .line 28
    invoke-interface {p2, p0}, Lorg/java_websocket/WrappedByteChannel;->readMore(Ljava/nio/ByteBuffer;)I

    move-result v0

    .line 29
    .local v0, "read":I
    invoke-virtual {p0}, Ljava/nio/ByteBuffer;->flip()Ljava/nio/Buffer;

    .line 31
    const/4 v1, -0x1

    if-ne v0, v1, :cond_0

    .line 32
    invoke-virtual {p1}, Lorg/java_websocket/WebSocketImpl;->eot()V

    .line 33
    const/4 v1, 0x0

    .line 35
    :goto_0
    return v1

    :cond_0
    invoke-interface {p2}, Lorg/java_websocket/WrappedByteChannel;->isNeedRead()Z

    move-result v1

    goto :goto_0
.end method

.method public static writeBlocking(Lorg/java_websocket/WebSocketImpl;Ljava/nio/channels/ByteChannel;)V
    .locals 3
    .param p0, "ws"    # Lorg/java_websocket/WebSocketImpl;
    .param p1, "channel"    # Ljava/nio/channels/ByteChannel;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/lang/InterruptedException;,
            Ljava/io/IOException;
        }
    .end annotation

    .prologue
    const/4 v2, 0x1

    .line 71
    sget-boolean v1, Lorg/java_websocket/SocketChannelIOHelper;->$assertionsDisabled:Z

    if-nez v1, :cond_0

    instance-of v1, p1, Ljava/nio/channels/spi/AbstractSelectableChannel;

    if-ne v1, v2, :cond_0

    move-object v1, p1

    check-cast v1, Ljava/nio/channels/spi/AbstractSelectableChannel;

    invoke-virtual {v1}, Ljava/nio/channels/spi/AbstractSelectableChannel;->isBlocking()Z

    move-result v1

    if-eqz v1, :cond_2

    .line 72
    :cond_0
    sget-boolean v1, Lorg/java_websocket/SocketChannelIOHelper;->$assertionsDisabled:Z

    if-nez v1, :cond_1

    instance-of v1, p1, Lorg/java_websocket/WrappedByteChannel;

    if-ne v1, v2, :cond_1

    move-object v1, p1

    check-cast v1, Lorg/java_websocket/WrappedByteChannel;

    invoke-interface {v1}, Lorg/java_websocket/WrappedByteChannel;->isBlocking()Z

    move-result v1

    if-eqz v1, :cond_3

    .line 74
    :cond_1
    iget-object v1, p0, Lorg/java_websocket/WebSocketImpl;->outQueue:Ljava/util/concurrent/BlockingQueue;

    invoke-interface {v1}, Ljava/util/concurrent/BlockingQueue;->take()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Ljava/nio/ByteBuffer;

    .line 75
    .local v0, "buf":Ljava/nio/ByteBuffer;
    :goto_0
    invoke-virtual {v0}, Ljava/nio/ByteBuffer;->hasRemaining()Z

    move-result v1

    if-eqz v1, :cond_4

    .line 76
    invoke-interface {p1, v0}, Ljava/nio/channels/ByteChannel;->write(Ljava/nio/ByteBuffer;)I

    goto :goto_0

    .line 71
    .end local v0    # "buf":Ljava/nio/ByteBuffer;
    :cond_2
    new-instance v1, Ljava/lang/AssertionError;

    invoke-direct {v1}, Ljava/lang/AssertionError;-><init>()V

    throw v1

    .line 72
    :cond_3
    new-instance v1, Ljava/lang/AssertionError;

    invoke-direct {v1}, Ljava/lang/AssertionError;-><init>()V

    throw v1

    .line 77
    .restart local v0    # "buf":Ljava/nio/ByteBuffer;
    :cond_4
    return-void
.end method

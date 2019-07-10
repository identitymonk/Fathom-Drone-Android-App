.class public Lcom/facebook/common/memory/PooledByteStreams;
.super Ljava/lang/Object;
.source "PooledByteStreams.java"


# static fields
.field private static final DEFAULT_TEMP_BUF_SIZE:I = 0x4000


# instance fields
.field private final mByteArrayPool:Lcom/facebook/common/memory/ByteArrayPool;

.field private final mTempBufSize:I


# direct methods
.method public constructor <init>(Lcom/facebook/common/memory/ByteArrayPool;)V
    .locals 1
    .param p1, "byteArrayPool"    # Lcom/facebook/common/memory/ByteArrayPool;

    .prologue
    .line 33
    const/16 v0, 0x4000

    invoke-direct {p0, p1, v0}, Lcom/facebook/common/memory/PooledByteStreams;-><init>(Lcom/facebook/common/memory/ByteArrayPool;I)V

    .line 34
    return-void
.end method

.method public constructor <init>(Lcom/facebook/common/memory/ByteArrayPool;I)V
    .locals 1
    .param p1, "byteArrayPool"    # Lcom/facebook/common/memory/ByteArrayPool;
    .param p2, "tempBufSize"    # I
    .annotation build Lcom/facebook/common/internal/VisibleForTesting;
    .end annotation

    .prologue
    .line 37
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 38
    if-lez p2, :cond_0

    const/4 v0, 0x1

    :goto_0
    invoke-static {v0}, Lcom/facebook/common/internal/Preconditions;->checkArgument(Z)V

    .line 39
    iput p2, p0, Lcom/facebook/common/memory/PooledByteStreams;->mTempBufSize:I

    .line 40
    iput-object p1, p0, Lcom/facebook/common/memory/PooledByteStreams;->mByteArrayPool:Lcom/facebook/common/memory/ByteArrayPool;

    .line 41
    return-void

    .line 38
    :cond_0
    const/4 v0, 0x0

    goto :goto_0
.end method


# virtual methods
.method public copy(Ljava/io/InputStream;Ljava/io/OutputStream;)J
    .locals 6
    .param p1, "from"    # Ljava/io/InputStream;
    .param p2, "to"    # Ljava/io/OutputStream;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;
        }
    .end annotation

    .prologue
    .line 51
    const-wide/16 v0, 0x0

    .line 52
    .local v0, "count":J
    iget-object v4, p0, Lcom/facebook/common/memory/PooledByteStreams;->mByteArrayPool:Lcom/facebook/common/memory/ByteArrayPool;

    iget v5, p0, Lcom/facebook/common/memory/PooledByteStreams;->mTempBufSize:I

    invoke-interface {v4, v5}, Lcom/facebook/common/memory/ByteArrayPool;->get(I)Ljava/lang/Object;

    move-result-object v3

    check-cast v3, [B

    .line 56
    .local v3, "tmp":[B
    :goto_0
    const/4 v4, 0x0

    :try_start_0
    iget v5, p0, Lcom/facebook/common/memory/PooledByteStreams;->mTempBufSize:I

    invoke-virtual {p1, v3, v4, v5}, Ljava/io/InputStream;->read([BII)I
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    move-result v2

    .line 57
    .local v2, "read":I
    const/4 v4, -0x1

    if-ne v2, v4, :cond_0

    .line 64
    iget-object v4, p0, Lcom/facebook/common/memory/PooledByteStreams;->mByteArrayPool:Lcom/facebook/common/memory/ByteArrayPool;

    invoke-interface {v4, v3}, Lcom/facebook/common/memory/ByteArrayPool;->release(Ljava/lang/Object;)V

    return-wide v0

    .line 60
    :cond_0
    const/4 v4, 0x0

    :try_start_1
    invoke-virtual {p2, v3, v4, v2}, Ljava/io/OutputStream;->write([BII)V
    :try_end_1
    .catchall {:try_start_1 .. :try_end_1} :catchall_0

    .line 61
    int-to-long v4, v2

    add-long/2addr v0, v4

    .line 62
    goto :goto_0

    .line 64
    .end local v2    # "read":I
    :catchall_0
    move-exception v4

    iget-object v5, p0, Lcom/facebook/common/memory/PooledByteStreams;->mByteArrayPool:Lcom/facebook/common/memory/ByteArrayPool;

    invoke-interface {v5, v3}, Lcom/facebook/common/memory/ByteArrayPool;->release(Ljava/lang/Object;)V

    throw v4
.end method

.method public copy(Ljava/io/InputStream;Ljava/io/OutputStream;J)J
    .locals 11
    .param p1, "from"    # Ljava/io/InputStream;
    .param p2, "to"    # Ljava/io/OutputStream;
    .param p3, "bytesToCopy"    # J
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;
        }
    .end annotation

    .prologue
    const/4 v4, 0x0

    .line 80
    const-wide/16 v6, 0x0

    cmp-long v5, p3, v6

    if-lez v5, :cond_0

    const/4 v4, 0x1

    :cond_0
    invoke-static {v4}, Lcom/facebook/common/internal/Preconditions;->checkState(Z)V

    .line 81
    const-wide/16 v0, 0x0

    .line 82
    .local v0, "copied":J
    iget-object v4, p0, Lcom/facebook/common/memory/PooledByteStreams;->mByteArrayPool:Lcom/facebook/common/memory/ByteArrayPool;

    iget v5, p0, Lcom/facebook/common/memory/PooledByteStreams;->mTempBufSize:I

    invoke-interface {v4, v5}, Lcom/facebook/common/memory/ByteArrayPool;->get(I)Ljava/lang/Object;

    move-result-object v3

    check-cast v3, [B

    .line 85
    .local v3, "tmp":[B
    :goto_0
    cmp-long v4, v0, p3

    if-gez v4, :cond_2

    .line 86
    const/4 v4, 0x0

    :try_start_0
    iget v5, p0, Lcom/facebook/common/memory/PooledByteStreams;->mTempBufSize:I

    int-to-long v6, v5

    sub-long v8, p3, v0

    invoke-static {v6, v7, v8, v9}, Ljava/lang/Math;->min(JJ)J

    move-result-wide v6

    long-to-int v5, v6

    invoke-virtual {p1, v3, v4, v5}, Ljava/io/InputStream;->read([BII)I
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    move-result v2

    .line 87
    .local v2, "read":I
    const/4 v4, -0x1

    if-ne v2, v4, :cond_1

    .line 95
    iget-object v4, p0, Lcom/facebook/common/memory/PooledByteStreams;->mByteArrayPool:Lcom/facebook/common/memory/ByteArrayPool;

    invoke-interface {v4, v3}, Lcom/facebook/common/memory/ByteArrayPool;->release(Ljava/lang/Object;)V

    .end local v2    # "read":I
    :goto_1
    return-wide v0

    .line 90
    .restart local v2    # "read":I
    :cond_1
    const/4 v4, 0x0

    :try_start_1
    invoke-virtual {p2, v3, v4, v2}, Ljava/io/OutputStream;->write([BII)V
    :try_end_1
    .catchall {:try_start_1 .. :try_end_1} :catchall_0

    .line 91
    int-to-long v4, v2

    add-long/2addr v0, v4

    .line 92
    goto :goto_0

    .line 95
    .end local v2    # "read":I
    :cond_2
    iget-object v4, p0, Lcom/facebook/common/memory/PooledByteStreams;->mByteArrayPool:Lcom/facebook/common/memory/ByteArrayPool;

    invoke-interface {v4, v3}, Lcom/facebook/common/memory/ByteArrayPool;->release(Ljava/lang/Object;)V

    goto :goto_1

    :catchall_0
    move-exception v4

    iget-object v5, p0, Lcom/facebook/common/memory/PooledByteStreams;->mByteArrayPool:Lcom/facebook/common/memory/ByteArrayPool;

    invoke-interface {v5, v3}, Lcom/facebook/common/memory/ByteArrayPool;->release(Ljava/lang/Object;)V

    throw v4
.end method

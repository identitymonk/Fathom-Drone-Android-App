.class public Lcom/facebook/react/devsupport/MultipartStreamReader;
.super Ljava/lang/Object;
.source "MultipartStreamReader.java"


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lcom/facebook/react/devsupport/MultipartStreamReader$ChunkCallback;
    }
.end annotation


# static fields
.field private static final CRLF:Ljava/lang/String; = "\r\n"


# instance fields
.field private final mBoundary:Ljava/lang/String;

.field private final mSource:Lokio/BufferedSource;


# direct methods
.method public constructor <init>(Lokio/BufferedSource;Ljava/lang/String;)V
    .locals 0
    .param p1, "source"    # Lokio/BufferedSource;
    .param p2, "boundary"    # Ljava/lang/String;

    .prologue
    .line 34
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 35
    iput-object p1, p0, Lcom/facebook/react/devsupport/MultipartStreamReader;->mSource:Lokio/BufferedSource;

    .line 36
    iput-object p2, p0, Lcom/facebook/react/devsupport/MultipartStreamReader;->mBoundary:Ljava/lang/String;

    .line 37
    return-void
.end method

.method private emitChunk(Lokio/Buffer;ZLcom/facebook/react/devsupport/MultipartStreamReader$ChunkCallback;)V
    .locals 8
    .param p1, "chunk"    # Lokio/Buffer;
    .param p2, "done"    # Z
    .param p3, "callback"    # Lcom/facebook/react/devsupport/MultipartStreamReader$ChunkCallback;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;
        }
    .end annotation

    .prologue
    .line 59
    const-string v5, "\r\n\r\n"

    invoke-static {v5}, Lokio/ByteString;->encodeUtf8(Ljava/lang/String;)Lokio/ByteString;

    move-result-object v4

    .line 60
    .local v4, "marker":Lokio/ByteString;
    invoke-virtual {p1, v4}, Lokio/Buffer;->indexOf(Lokio/ByteString;)J

    move-result-wide v2

    .line 61
    .local v2, "indexOfMarker":J
    const-wide/16 v6, -0x1

    cmp-long v5, v2, v6

    if-nez v5, :cond_0

    .line 62
    const/4 v5, 0x0

    invoke-interface {p3, v5, p1, p2}, Lcom/facebook/react/devsupport/MultipartStreamReader$ChunkCallback;->execute(Ljava/util/Map;Lokio/Buffer;Z)V

    .line 71
    :goto_0
    return-void

    .line 64
    :cond_0
    new-instance v1, Lokio/Buffer;

    invoke-direct {v1}, Lokio/Buffer;-><init>()V

    .line 65
    .local v1, "headers":Lokio/Buffer;
    new-instance v0, Lokio/Buffer;

    invoke-direct {v0}, Lokio/Buffer;-><init>()V

    .line 66
    .local v0, "body":Lokio/Buffer;
    invoke-virtual {p1, v1, v2, v3}, Lokio/Buffer;->read(Lokio/Buffer;J)J

    .line 67
    invoke-virtual {v4}, Lokio/ByteString;->size()I

    move-result v5

    int-to-long v6, v5

    invoke-virtual {p1, v6, v7}, Lokio/Buffer;->skip(J)V

    .line 68
    invoke-virtual {p1, v0}, Lokio/Buffer;->readAll(Lokio/Sink;)J

    .line 69
    invoke-direct {p0, v1}, Lcom/facebook/react/devsupport/MultipartStreamReader;->parseHeaders(Lokio/Buffer;)Ljava/util/Map;

    move-result-object v5

    invoke-interface {p3, v5, v0, p2}, Lcom/facebook/react/devsupport/MultipartStreamReader$ChunkCallback;->execute(Ljava/util/Map;Lokio/Buffer;Z)V

    goto :goto_0
.end method

.method private parseHeaders(Lokio/Buffer;)Ljava/util/Map;
    .locals 11
    .param p1, "data"    # Lokio/Buffer;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Lokio/Buffer;",
            ")",
            "Ljava/util/Map",
            "<",
            "Ljava/lang/String;",
            "Ljava/lang/String;",
            ">;"
        }
    .end annotation

    .prologue
    const/4 v8, 0x0

    .line 40
    new-instance v0, Ljava/util/HashMap;

    invoke-direct {v0}, Ljava/util/HashMap;-><init>()V

    .line 42
    .local v0, "headers":Ljava/util/Map;, "Ljava/util/Map<Ljava/lang/String;Ljava/lang/String;>;"
    invoke-virtual {p1}, Lokio/Buffer;->readUtf8()Ljava/lang/String;

    move-result-object v5

    .line 43
    .local v5, "text":Ljava/lang/String;
    const-string v7, "\r\n"

    invoke-virtual {v5, v7}, Ljava/lang/String;->split(Ljava/lang/String;)[Ljava/lang/String;

    move-result-object v4

    .line 44
    .local v4, "lines":[Ljava/lang/String;
    array-length v9, v4

    move v7, v8

    :goto_0
    if-ge v7, v9, :cond_1

    aget-object v3, v4, v7

    .line 45
    .local v3, "line":Ljava/lang/String;
    const-string v10, ":"

    invoke-virtual {v3, v10}, Ljava/lang/String;->indexOf(Ljava/lang/String;)I

    move-result v1

    .line 46
    .local v1, "indexOfSeparator":I
    const/4 v10, -0x1

    if-ne v1, v10, :cond_0

    .line 44
    :goto_1
    add-int/lit8 v7, v7, 0x1

    goto :goto_0

    .line 50
    :cond_0
    invoke-virtual {v3, v8, v1}, Ljava/lang/String;->substring(II)Ljava/lang/String;

    move-result-object v10

    invoke-virtual {v10}, Ljava/lang/String;->trim()Ljava/lang/String;

    move-result-object v2

    .line 51
    .local v2, "key":Ljava/lang/String;
    add-int/lit8 v10, v1, 0x1

    invoke-virtual {v3, v10}, Ljava/lang/String;->substring(I)Ljava/lang/String;

    move-result-object v10

    invoke-virtual {v10}, Ljava/lang/String;->trim()Ljava/lang/String;

    move-result-object v6

    .line 52
    .local v6, "value":Ljava/lang/String;
    invoke-interface {v0, v2, v6}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    goto :goto_1

    .line 55
    .end local v1    # "indexOfSeparator":I
    .end local v2    # "key":Ljava/lang/String;
    .end local v3    # "line":Ljava/lang/String;
    .end local v6    # "value":Ljava/lang/String;
    :cond_1
    return-object v0
.end method


# virtual methods
.method public readAllParts(Lcom/facebook/react/devsupport/MultipartStreamReader$ChunkCallback;)Z
    .locals 28
    .param p1, "callback"    # Lcom/facebook/react/devsupport/MultipartStreamReader$ChunkCallback;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;
        }
    .end annotation

    .prologue
    .line 79
    new-instance v24, Ljava/lang/StringBuilder;

    invoke-direct/range {v24 .. v24}, Ljava/lang/StringBuilder;-><init>()V

    const-string v25, "\r\n--"

    invoke-virtual/range {v24 .. v25}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v24

    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/facebook/react/devsupport/MultipartStreamReader;->mBoundary:Ljava/lang/String;

    move-object/from16 v25, v0

    invoke-virtual/range {v24 .. v25}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v24

    const-string v25, "\r\n"

    invoke-virtual/range {v24 .. v25}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v24

    invoke-virtual/range {v24 .. v24}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v24

    invoke-static/range {v24 .. v24}, Lokio/ByteString;->encodeUtf8(Ljava/lang/String;)Lokio/ByteString;

    move-result-object v16

    .line 80
    .local v16, "delimiter":Lokio/ByteString;
    new-instance v24, Ljava/lang/StringBuilder;

    invoke-direct/range {v24 .. v24}, Ljava/lang/StringBuilder;-><init>()V

    const-string v25, "\r\n--"

    invoke-virtual/range {v24 .. v25}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v24

    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/facebook/react/devsupport/MultipartStreamReader;->mBoundary:Ljava/lang/String;

    move-object/from16 v25, v0

    invoke-virtual/range {v24 .. v25}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v24

    const-string v25, "--"

    invoke-virtual/range {v24 .. v25}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v24

    const-string v25, "\r\n"

    invoke-virtual/range {v24 .. v25}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v24

    invoke-virtual/range {v24 .. v24}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v24

    invoke-static/range {v24 .. v24}, Lokio/ByteString;->encodeUtf8(Ljava/lang/String;)Lokio/ByteString;

    move-result-object v14

    .line 82
    .local v14, "closeDelimiter":Lokio/ByteString;
    const/16 v4, 0x1000

    .line 83
    .local v4, "bufferLen":I
    const-wide/16 v12, 0x0

    .line 84
    .local v12, "chunkStart":J
    const-wide/16 v8, 0x0

    .line 85
    .local v8, "bytesSeen":J
    new-instance v15, Lokio/Buffer;

    invoke-direct {v15}, Lokio/Buffer;-><init>()V

    .line 88
    .local v15, "content":Lokio/Buffer;
    :cond_0
    :goto_0
    const/16 v17, 0x0

    .line 92
    .local v17, "isCloseDelimiter":Z
    invoke-virtual {v14}, Lokio/ByteString;->size()I

    move-result v24

    move/from16 v0, v24

    int-to-long v0, v0

    move-wide/from16 v24, v0

    sub-long v24, v8, v24

    move-wide/from16 v0, v24

    invoke-static {v0, v1, v12, v13}, Ljava/lang/Math;->max(JJ)J

    move-result-wide v22

    .line 93
    .local v22, "searchStart":J
    move-object/from16 v0, v16

    move-wide/from16 v1, v22

    invoke-virtual {v15, v0, v1, v2}, Lokio/Buffer;->indexOf(Lokio/ByteString;J)J

    move-result-wide v18

    .line 94
    .local v18, "indexOfDelimiter":J
    const-wide/16 v24, -0x1

    cmp-long v24, v18, v24

    if-nez v24, :cond_1

    .line 95
    const/16 v17, 0x1

    .line 96
    move-wide/from16 v0, v22

    invoke-virtual {v15, v14, v0, v1}, Lokio/Buffer;->indexOf(Lokio/ByteString;J)J

    move-result-wide v18

    .line 99
    :cond_1
    const-wide/16 v24, -0x1

    cmp-long v24, v18, v24

    if-nez v24, :cond_2

    .line 100
    invoke-virtual {v15}, Lokio/Buffer;->size()J

    move-result-wide v8

    .line 101
    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/facebook/react/devsupport/MultipartStreamReader;->mSource:Lokio/BufferedSource;

    move-object/from16 v24, v0

    int-to-long v0, v4

    move-wide/from16 v26, v0

    move-object/from16 v0, v24

    move-wide/from16 v1, v26

    invoke-interface {v0, v15, v1, v2}, Lokio/BufferedSource;->read(Lokio/Buffer;J)J

    move-result-wide v6

    .line 102
    .local v6, "bytesRead":J
    const-wide/16 v24, 0x0

    cmp-long v24, v6, v24

    if-gtz v24, :cond_0

    .line 103
    const/16 v24, 0x0

    .line 122
    .end local v6    # "bytesRead":J
    :goto_1
    return v24

    .line 108
    :cond_2
    move-wide/from16 v10, v18

    .line 109
    .local v10, "chunkEnd":J
    sub-long v20, v10, v12

    .line 112
    .local v20, "length":J
    const-wide/16 v24, 0x0

    cmp-long v24, v12, v24

    if-lez v24, :cond_3

    .line 113
    new-instance v5, Lokio/Buffer;

    invoke-direct {v5}, Lokio/Buffer;-><init>()V

    .line 114
    .local v5, "chunk":Lokio/Buffer;
    invoke-virtual {v15, v12, v13}, Lokio/Buffer;->skip(J)V

    .line 115
    move-wide/from16 v0, v20

    invoke-virtual {v15, v5, v0, v1}, Lokio/Buffer;->read(Lokio/Buffer;J)J

    .line 116
    move-object/from16 v0, p0

    move/from16 v1, v17

    move-object/from16 v2, p1

    invoke-direct {v0, v5, v1, v2}, Lcom/facebook/react/devsupport/MultipartStreamReader;->emitChunk(Lokio/Buffer;ZLcom/facebook/react/devsupport/MultipartStreamReader$ChunkCallback;)V

    .line 121
    .end local v5    # "chunk":Lokio/Buffer;
    :goto_2
    if-eqz v17, :cond_4

    .line 122
    const/16 v24, 0x1

    goto :goto_1

    .line 118
    :cond_3
    invoke-virtual {v15, v10, v11}, Lokio/Buffer;->skip(J)V

    goto :goto_2

    .line 125
    :cond_4
    invoke-virtual/range {v16 .. v16}, Lokio/ByteString;->size()I

    move-result v24

    move/from16 v0, v24

    int-to-long v12, v0

    move-wide v8, v12

    .line 126
    goto :goto_0
.end method

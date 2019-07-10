.class Lcom/facebook/react/modules/network/ProgressRequestBody$1;
.super Lokio/ForwardingSink;
.source "ProgressRequestBody.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/facebook/react/modules/network/ProgressRequestBody;->sink(Lokio/Sink;)Lokio/Sink;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field bytesWritten:J

.field contentLength:J

.field final synthetic this$0:Lcom/facebook/react/modules/network/ProgressRequestBody;


# direct methods
.method constructor <init>(Lcom/facebook/react/modules/network/ProgressRequestBody;Lokio/Sink;)V
    .locals 2
    .param p1, "this$0"    # Lcom/facebook/react/modules/network/ProgressRequestBody;
    .param p2, "x0"    # Lokio/Sink;

    .prologue
    const-wide/16 v0, 0x0

    .line 52
    iput-object p1, p0, Lcom/facebook/react/modules/network/ProgressRequestBody$1;->this$0:Lcom/facebook/react/modules/network/ProgressRequestBody;

    invoke-direct {p0, p2}, Lokio/ForwardingSink;-><init>(Lokio/Sink;)V

    .line 53
    iput-wide v0, p0, Lcom/facebook/react/modules/network/ProgressRequestBody$1;->bytesWritten:J

    .line 54
    iput-wide v0, p0, Lcom/facebook/react/modules/network/ProgressRequestBody$1;->contentLength:J

    return-void
.end method


# virtual methods
.method public write(Lokio/Buffer;J)V
    .locals 10
    .param p1, "source"    # Lokio/Buffer;
    .param p2, "byteCount"    # J
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;
        }
    .end annotation

    .prologue
    .line 58
    invoke-super {p0, p1, p2, p3}, Lokio/ForwardingSink;->write(Lokio/Buffer;J)V

    .line 59
    iget-wide v0, p0, Lcom/facebook/react/modules/network/ProgressRequestBody$1;->contentLength:J

    const-wide/16 v2, 0x0

    cmp-long v0, v0, v2

    if-nez v0, :cond_0

    .line 60
    iget-object v0, p0, Lcom/facebook/react/modules/network/ProgressRequestBody$1;->this$0:Lcom/facebook/react/modules/network/ProgressRequestBody;

    invoke-virtual {v0}, Lcom/facebook/react/modules/network/ProgressRequestBody;->contentLength()J

    move-result-wide v0

    iput-wide v0, p0, Lcom/facebook/react/modules/network/ProgressRequestBody$1;->contentLength:J

    .line 62
    :cond_0
    iget-wide v0, p0, Lcom/facebook/react/modules/network/ProgressRequestBody$1;->bytesWritten:J

    add-long/2addr v0, p2

    iput-wide v0, p0, Lcom/facebook/react/modules/network/ProgressRequestBody$1;->bytesWritten:J

    .line 63
    iget-object v0, p0, Lcom/facebook/react/modules/network/ProgressRequestBody$1;->this$0:Lcom/facebook/react/modules/network/ProgressRequestBody;

    invoke-static {v0}, Lcom/facebook/react/modules/network/ProgressRequestBody;->access$000(Lcom/facebook/react/modules/network/ProgressRequestBody;)Lcom/facebook/react/modules/network/ProgressListener;

    move-result-object v1

    iget-wide v2, p0, Lcom/facebook/react/modules/network/ProgressRequestBody$1;->bytesWritten:J

    iget-wide v4, p0, Lcom/facebook/react/modules/network/ProgressRequestBody$1;->contentLength:J

    iget-wide v6, p0, Lcom/facebook/react/modules/network/ProgressRequestBody$1;->bytesWritten:J

    iget-wide v8, p0, Lcom/facebook/react/modules/network/ProgressRequestBody$1;->contentLength:J

    cmp-long v0, v6, v8

    if-nez v0, :cond_1

    const/4 v6, 0x1

    :goto_0
    invoke-interface/range {v1 .. v6}, Lcom/facebook/react/modules/network/ProgressListener;->onProgress(JJZ)V

    .line 65
    return-void

    .line 63
    :cond_1
    const/4 v6, 0x0

    goto :goto_0
.end method

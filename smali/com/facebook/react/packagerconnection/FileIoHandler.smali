.class public Lcom/facebook/react/packagerconnection/FileIoHandler;
.super Ljava/lang/Object;
.source "FileIoHandler.java"

# interfaces
.implements Ljava/lang/Runnable;


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lcom/facebook/react/packagerconnection/FileIoHandler$TtlFileInputStream;
    }
.end annotation


# static fields
.field private static final FILE_TTL:J = 0x7530L

.field private static final TAG:Ljava/lang/String;


# instance fields
.field private final mHandler:Landroid/os/Handler;

.field private mNextHandle:I

.field private final mOpenFiles:Ljava/util/Map;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/Map",
            "<",
            "Ljava/lang/Integer;",
            "Lcom/facebook/react/packagerconnection/FileIoHandler$TtlFileInputStream;",
            ">;"
        }
    .end annotation
.end field

.field private final mRequestHandlers:Ljava/util/Map;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/Map",
            "<",
            "Ljava/lang/String;",
            "Lcom/facebook/react/packagerconnection/RequestHandler;",
            ">;"
        }
    .end annotation
.end field


# direct methods
.method static constructor <clinit>()V
    .locals 1

    .prologue
    .line 30
    const-class v0, Lcom/facebook/react/packagerconnection/JSPackagerClient;

    invoke-virtual {v0}, Ljava/lang/Class;->getSimpleName()Ljava/lang/String;

    move-result-object v0

    sput-object v0, Lcom/facebook/react/packagerconnection/FileIoHandler;->TAG:Ljava/lang/String;

    return-void
.end method

.method public constructor <init>()V
    .locals 3

    .prologue
    .line 67
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 68
    const/4 v0, 0x1

    iput v0, p0, Lcom/facebook/react/packagerconnection/FileIoHandler;->mNextHandle:I

    .line 69
    new-instance v0, Landroid/os/Handler;

    invoke-static {}, Landroid/os/Looper;->getMainLooper()Landroid/os/Looper;

    move-result-object v1

    invoke-direct {v0, v1}, Landroid/os/Handler;-><init>(Landroid/os/Looper;)V

    iput-object v0, p0, Lcom/facebook/react/packagerconnection/FileIoHandler;->mHandler:Landroid/os/Handler;

    .line 70
    new-instance v0, Ljava/util/HashMap;

    invoke-direct {v0}, Ljava/util/HashMap;-><init>()V

    iput-object v0, p0, Lcom/facebook/react/packagerconnection/FileIoHandler;->mOpenFiles:Ljava/util/Map;

    .line 71
    new-instance v0, Ljava/util/HashMap;

    invoke-direct {v0}, Ljava/util/HashMap;-><init>()V

    iput-object v0, p0, Lcom/facebook/react/packagerconnection/FileIoHandler;->mRequestHandlers:Ljava/util/Map;

    .line 72
    iget-object v0, p0, Lcom/facebook/react/packagerconnection/FileIoHandler;->mRequestHandlers:Ljava/util/Map;

    const-string v1, "fopen"

    new-instance v2, Lcom/facebook/react/packagerconnection/FileIoHandler$1;

    invoke-direct {v2, p0}, Lcom/facebook/react/packagerconnection/FileIoHandler$1;-><init>(Lcom/facebook/react/packagerconnection/FileIoHandler;)V

    invoke-interface {v0, v1, v2}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 101
    iget-object v0, p0, Lcom/facebook/react/packagerconnection/FileIoHandler;->mRequestHandlers:Ljava/util/Map;

    const-string v1, "fclose"

    new-instance v2, Lcom/facebook/react/packagerconnection/FileIoHandler$2;

    invoke-direct {v2, p0}, Lcom/facebook/react/packagerconnection/FileIoHandler$2;-><init>(Lcom/facebook/react/packagerconnection/FileIoHandler;)V

    invoke-interface {v0, v1, v2}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 124
    iget-object v0, p0, Lcom/facebook/react/packagerconnection/FileIoHandler;->mRequestHandlers:Ljava/util/Map;

    const-string v1, "fread"

    new-instance v2, Lcom/facebook/react/packagerconnection/FileIoHandler$3;

    invoke-direct {v2, p0}, Lcom/facebook/react/packagerconnection/FileIoHandler$3;-><init>(Lcom/facebook/react/packagerconnection/FileIoHandler;)V

    invoke-interface {v0, v1, v2}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 154
    return-void
.end method

.method static synthetic access$000(Lcom/facebook/react/packagerconnection/FileIoHandler;)Ljava/util/Map;
    .locals 1
    .param p0, "x0"    # Lcom/facebook/react/packagerconnection/FileIoHandler;

    .prologue
    .line 29
    iget-object v0, p0, Lcom/facebook/react/packagerconnection/FileIoHandler;->mOpenFiles:Ljava/util/Map;

    return-object v0
.end method

.method static synthetic access$100(Lcom/facebook/react/packagerconnection/FileIoHandler;Ljava/lang/String;)I
    .locals 1
    .param p0, "x0"    # Lcom/facebook/react/packagerconnection/FileIoHandler;
    .param p1, "x1"    # Ljava/lang/String;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/FileNotFoundException;
        }
    .end annotation

    .prologue
    .line 29
    invoke-direct {p0, p1}, Lcom/facebook/react/packagerconnection/FileIoHandler;->addOpenFile(Ljava/lang/String;)I

    move-result v0

    return v0
.end method

.method private addOpenFile(Ljava/lang/String;)I
    .locals 4
    .param p1, "filename"    # Ljava/lang/String;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/FileNotFoundException;
        }
    .end annotation

    .prologue
    .line 161
    iget v0, p0, Lcom/facebook/react/packagerconnection/FileIoHandler;->mNextHandle:I

    add-int/lit8 v1, v0, 0x1

    iput v1, p0, Lcom/facebook/react/packagerconnection/FileIoHandler;->mNextHandle:I

    .line 162
    .local v0, "handle":I
    iget-object v1, p0, Lcom/facebook/react/packagerconnection/FileIoHandler;->mOpenFiles:Ljava/util/Map;

    invoke-static {v0}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v2

    new-instance v3, Lcom/facebook/react/packagerconnection/FileIoHandler$TtlFileInputStream;

    invoke-direct {v3, p1}, Lcom/facebook/react/packagerconnection/FileIoHandler$TtlFileInputStream;-><init>(Ljava/lang/String;)V

    invoke-interface {v1, v2, v3}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 163
    iget-object v1, p0, Lcom/facebook/react/packagerconnection/FileIoHandler;->mOpenFiles:Ljava/util/Map;

    invoke-interface {v1}, Ljava/util/Map;->size()I

    move-result v1

    const/4 v2, 0x1

    if-ne v1, v2, :cond_0

    .line 164
    iget-object v1, p0, Lcom/facebook/react/packagerconnection/FileIoHandler;->mHandler:Landroid/os/Handler;

    const-wide/16 v2, 0x7530

    invoke-virtual {v1, p0, v2, v3}, Landroid/os/Handler;->postDelayed(Ljava/lang/Runnable;J)Z

    .line 166
    :cond_0
    return v0
.end method


# virtual methods
.method public handlers()Ljava/util/Map;
    .locals 1
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()",
            "Ljava/util/Map",
            "<",
            "Ljava/lang/String;",
            "Lcom/facebook/react/packagerconnection/RequestHandler;",
            ">;"
        }
    .end annotation

    .prologue
    .line 157
    iget-object v0, p0, Lcom/facebook/react/packagerconnection/FileIoHandler;->mRequestHandlers:Ljava/util/Map;

    return-object v0
.end method

.method public run()V
    .locals 8

    .prologue
    .line 172
    iget-object v4, p0, Lcom/facebook/react/packagerconnection/FileIoHandler;->mOpenFiles:Ljava/util/Map;

    monitor-enter v4

    .line 173
    :try_start_0
    iget-object v3, p0, Lcom/facebook/react/packagerconnection/FileIoHandler;->mOpenFiles:Ljava/util/Map;

    invoke-interface {v3}, Ljava/util/Map;->values()Ljava/util/Collection;

    move-result-object v3

    invoke-interface {v3}, Ljava/util/Collection;->iterator()Ljava/util/Iterator;

    move-result-object v1

    .line 174
    .local v1, "i":Ljava/util/Iterator;, "Ljava/util/Iterator<Lcom/facebook/react/packagerconnection/FileIoHandler$TtlFileInputStream;>;"
    :cond_0
    :goto_0
    invoke-interface {v1}, Ljava/util/Iterator;->hasNext()Z

    move-result v3

    if-eqz v3, :cond_1

    .line 175
    invoke-interface {v1}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v2

    check-cast v2, Lcom/facebook/react/packagerconnection/FileIoHandler$TtlFileInputStream;

    .line 176
    .local v2, "stream":Lcom/facebook/react/packagerconnection/FileIoHandler$TtlFileInputStream;
    invoke-virtual {v2}, Lcom/facebook/react/packagerconnection/FileIoHandler$TtlFileInputStream;->expiredTtl()Z

    move-result v3

    if-eqz v3, :cond_0

    .line 177
    invoke-interface {v1}, Ljava/util/Iterator;->remove()V
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    .line 179
    :try_start_1
    invoke-virtual {v2}, Lcom/facebook/react/packagerconnection/FileIoHandler$TtlFileInputStream;->close()V
    :try_end_1
    .catch Ljava/io/IOException; {:try_start_1 .. :try_end_1} :catch_0
    .catchall {:try_start_1 .. :try_end_1} :catchall_0

    goto :goto_0

    .line 180
    :catch_0
    move-exception v0

    .line 181
    .local v0, "e":Ljava/io/IOException;
    :try_start_2
    sget-object v3, Lcom/facebook/react/packagerconnection/FileIoHandler;->TAG:Ljava/lang/String;

    new-instance v5, Ljava/lang/StringBuilder;

    invoke-direct {v5}, Ljava/lang/StringBuilder;-><init>()V

    const-string v6, "closing expired file failed: "

    invoke-virtual {v5, v6}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v5

    .line 183
    invoke-virtual {v0}, Ljava/io/IOException;->toString()Ljava/lang/String;

    move-result-object v6

    invoke-virtual {v5, v6}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v5

    invoke-virtual {v5}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v5

    .line 181
    invoke-static {v3, v5}, Lcom/facebook/common/logging/FLog;->e(Ljava/lang/String;Ljava/lang/String;)V

    goto :goto_0

    .line 190
    .end local v0    # "e":Ljava/io/IOException;
    .end local v1    # "i":Ljava/util/Iterator;, "Ljava/util/Iterator<Lcom/facebook/react/packagerconnection/FileIoHandler$TtlFileInputStream;>;"
    .end local v2    # "stream":Lcom/facebook/react/packagerconnection/FileIoHandler$TtlFileInputStream;
    :catchall_0
    move-exception v3

    monitor-exit v4
    :try_end_2
    .catchall {:try_start_2 .. :try_end_2} :catchall_0

    throw v3

    .line 187
    .restart local v1    # "i":Ljava/util/Iterator;, "Ljava/util/Iterator<Lcom/facebook/react/packagerconnection/FileIoHandler$TtlFileInputStream;>;"
    :cond_1
    :try_start_3
    iget-object v3, p0, Lcom/facebook/react/packagerconnection/FileIoHandler;->mOpenFiles:Ljava/util/Map;

    invoke-interface {v3}, Ljava/util/Map;->isEmpty()Z

    move-result v3

    if-nez v3, :cond_2

    .line 188
    iget-object v3, p0, Lcom/facebook/react/packagerconnection/FileIoHandler;->mHandler:Landroid/os/Handler;

    const-wide/16 v6, 0x7530

    invoke-virtual {v3, p0, v6, v7}, Landroid/os/Handler;->postDelayed(Ljava/lang/Runnable;J)Z

    .line 190
    :cond_2
    monitor-exit v4
    :try_end_3
    .catchall {:try_start_3 .. :try_end_3} :catchall_0

    .line 191
    return-void
.end method

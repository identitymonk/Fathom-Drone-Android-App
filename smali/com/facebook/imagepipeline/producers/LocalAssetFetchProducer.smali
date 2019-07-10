.class public Lcom/facebook/imagepipeline/producers/LocalAssetFetchProducer;
.super Lcom/facebook/imagepipeline/producers/LocalFetchProducer;
.source "LocalAssetFetchProducer.java"


# static fields
.field public static final PRODUCER_NAME:Ljava/lang/String; = "LocalAssetFetchProducer"


# instance fields
.field private final mAssetManager:Landroid/content/res/AssetManager;


# direct methods
.method public constructor <init>(Ljava/util/concurrent/Executor;Lcom/facebook/common/memory/PooledByteBufferFactory;Landroid/content/res/AssetManager;)V
    .locals 0
    .param p1, "executor"    # Ljava/util/concurrent/Executor;
    .param p2, "pooledByteBufferFactory"    # Lcom/facebook/common/memory/PooledByteBufferFactory;
    .param p3, "assetManager"    # Landroid/content/res/AssetManager;

    .prologue
    .line 35
    invoke-direct {p0, p1, p2}, Lcom/facebook/imagepipeline/producers/LocalFetchProducer;-><init>(Ljava/util/concurrent/Executor;Lcom/facebook/common/memory/PooledByteBufferFactory;)V

    .line 36
    iput-object p3, p0, Lcom/facebook/imagepipeline/producers/LocalAssetFetchProducer;->mAssetManager:Landroid/content/res/AssetManager;

    .line 37
    return-void
.end method

.method private static getAssetName(Lcom/facebook/imagepipeline/request/ImageRequest;)Ljava/lang/String;
    .locals 2
    .param p0, "imageRequest"    # Lcom/facebook/imagepipeline/request/ImageRequest;

    .prologue
    .line 70
    invoke-virtual {p0}, Lcom/facebook/imagepipeline/request/ImageRequest;->getSourceUri()Landroid/net/Uri;

    move-result-object v0

    invoke-virtual {v0}, Landroid/net/Uri;->getPath()Ljava/lang/String;

    move-result-object v0

    const/4 v1, 0x1

    invoke-virtual {v0, v1}, Ljava/lang/String;->substring(I)Ljava/lang/String;

    move-result-object v0

    return-object v0
.end method

.method private getLength(Lcom/facebook/imagepipeline/request/ImageRequest;)I
    .locals 4
    .param p1, "imageRequest"    # Lcom/facebook/imagepipeline/request/ImageRequest;

    .prologue
    .line 47
    const/4 v1, 0x0

    .line 49
    .local v1, "fd":Landroid/content/res/AssetFileDescriptor;
    :try_start_0
    iget-object v2, p0, Lcom/facebook/imagepipeline/producers/LocalAssetFetchProducer;->mAssetManager:Landroid/content/res/AssetManager;

    invoke-static {p1}, Lcom/facebook/imagepipeline/producers/LocalAssetFetchProducer;->getAssetName(Lcom/facebook/imagepipeline/request/ImageRequest;)Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v2, v3}, Landroid/content/res/AssetManager;->openFd(Ljava/lang/String;)Landroid/content/res/AssetFileDescriptor;

    move-result-object v1

    .line 50
    invoke-virtual {v1}, Landroid/content/res/AssetFileDescriptor;->getLength()J
    :try_end_0
    .catch Ljava/io/IOException; {:try_start_0 .. :try_end_0} :catch_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    move-result-wide v2

    long-to-int v2, v2

    .line 55
    if-eqz v1, :cond_0

    .line 56
    :try_start_1
    invoke-virtual {v1}, Landroid/content/res/AssetFileDescriptor;->close()V
    :try_end_1
    .catch Ljava/io/IOException; {:try_start_1 .. :try_end_1} :catch_2

    .line 60
    :cond_0
    :goto_0
    return v2

    .line 51
    :catch_0
    move-exception v0

    .line 52
    .local v0, "e":Ljava/io/IOException;
    const/4 v2, -0x1

    .line 55
    if-eqz v1, :cond_0

    .line 56
    :try_start_2
    invoke-virtual {v1}, Landroid/content/res/AssetFileDescriptor;->close()V
    :try_end_2
    .catch Ljava/io/IOException; {:try_start_2 .. :try_end_2} :catch_1

    goto :goto_0

    .line 58
    :catch_1
    move-exception v3

    goto :goto_0

    .line 54
    .end local v0    # "e":Ljava/io/IOException;
    :catchall_0
    move-exception v2

    .line 55
    if-eqz v1, :cond_1

    .line 56
    :try_start_3
    invoke-virtual {v1}, Landroid/content/res/AssetFileDescriptor;->close()V
    :try_end_3
    .catch Ljava/io/IOException; {:try_start_3 .. :try_end_3} :catch_3

    .line 60
    :cond_1
    :goto_1
    throw v2

    .line 58
    :catch_2
    move-exception v3

    goto :goto_0

    :catch_3
    move-exception v3

    goto :goto_1
.end method


# virtual methods
.method protected getEncodedImage(Lcom/facebook/imagepipeline/request/ImageRequest;)Lcom/facebook/imagepipeline/image/EncodedImage;
    .locals 3
    .param p1, "imageRequest"    # Lcom/facebook/imagepipeline/request/ImageRequest;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;
        }
    .end annotation

    .prologue
    .line 41
    iget-object v0, p0, Lcom/facebook/imagepipeline/producers/LocalAssetFetchProducer;->mAssetManager:Landroid/content/res/AssetManager;

    .line 42
    invoke-static {p1}, Lcom/facebook/imagepipeline/producers/LocalAssetFetchProducer;->getAssetName(Lcom/facebook/imagepipeline/request/ImageRequest;)Ljava/lang/String;

    move-result-object v1

    const/4 v2, 0x2

    invoke-virtual {v0, v1, v2}, Landroid/content/res/AssetManager;->open(Ljava/lang/String;I)Ljava/io/InputStream;

    move-result-object v0

    .line 43
    invoke-direct {p0, p1}, Lcom/facebook/imagepipeline/producers/LocalAssetFetchProducer;->getLength(Lcom/facebook/imagepipeline/request/ImageRequest;)I

    move-result v1

    .line 41
    invoke-virtual {p0, v0, v1}, Lcom/facebook/imagepipeline/producers/LocalAssetFetchProducer;->getEncodedImage(Ljava/io/InputStream;I)Lcom/facebook/imagepipeline/image/EncodedImage;

    move-result-object v0

    return-object v0
.end method

.method protected getProducerName()Ljava/lang/String;
    .locals 1

    .prologue
    .line 66
    const-string v0, "LocalAssetFetchProducer"

    return-object v0
.end method

.class public Lcom/facebook/imagepipeline/producers/LocalContentUriFetchProducer;
.super Lcom/facebook/imagepipeline/producers/LocalFetchProducer;
.source "LocalContentUriFetchProducer.java"


# static fields
.field public static final PRODUCER_NAME:Ljava/lang/String; = "LocalContentUriFetchProducer"

.field private static final PROJECTION:[Ljava/lang/String;


# instance fields
.field private final mContentResolver:Landroid/content/ContentResolver;


# direct methods
.method static constructor <clinit>()V
    .locals 3

    .prologue
    .line 38
    const/4 v0, 0x2

    new-array v0, v0, [Ljava/lang/String;

    const/4 v1, 0x0

    const-string v2, "_id"

    aput-object v2, v0, v1

    const/4 v1, 0x1

    const-string v2, "_data"

    aput-object v2, v0, v1

    sput-object v0, Lcom/facebook/imagepipeline/producers/LocalContentUriFetchProducer;->PROJECTION:[Ljava/lang/String;

    return-void
.end method

.method public constructor <init>(Ljava/util/concurrent/Executor;Lcom/facebook/common/memory/PooledByteBufferFactory;Landroid/content/ContentResolver;)V
    .locals 0
    .param p1, "executor"    # Ljava/util/concurrent/Executor;
    .param p2, "pooledByteBufferFactory"    # Lcom/facebook/common/memory/PooledByteBufferFactory;
    .param p3, "contentResolver"    # Landroid/content/ContentResolver;

    .prologue
    .line 49
    invoke-direct {p0, p1, p2}, Lcom/facebook/imagepipeline/producers/LocalFetchProducer;-><init>(Ljava/util/concurrent/Executor;Lcom/facebook/common/memory/PooledByteBufferFactory;)V

    .line 50
    iput-object p3, p0, Lcom/facebook/imagepipeline/producers/LocalContentUriFetchProducer;->mContentResolver:Landroid/content/ContentResolver;

    .line 51
    return-void
.end method

.method private getCameraImage(Landroid/net/Uri;)Lcom/facebook/imagepipeline/image/EncodedImage;
    .locals 8
    .param p1, "uri"    # Landroid/net/Uri;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;
        }
    .end annotation

    .annotation runtime Ljavax/annotation/Nullable;
    .end annotation

    .prologue
    const/4 v3, 0x0

    .line 85
    iget-object v0, p0, Lcom/facebook/imagepipeline/producers/LocalContentUriFetchProducer;->mContentResolver:Landroid/content/ContentResolver;

    sget-object v2, Lcom/facebook/imagepipeline/producers/LocalContentUriFetchProducer;->PROJECTION:[Ljava/lang/String;

    move-object v1, p1

    move-object v4, v3

    move-object v5, v3

    invoke-virtual/range {v0 .. v5}, Landroid/content/ContentResolver;->query(Landroid/net/Uri;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;

    move-result-object v6

    .line 86
    .local v6, "cursor":Landroid/database/Cursor;
    if-nez v6, :cond_0

    .line 102
    :goto_0
    return-object v3

    .line 90
    :cond_0
    :try_start_0
    invoke-interface {v6}, Landroid/database/Cursor;->getCount()I
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    move-result v0

    if-nez v0, :cond_1

    .line 100
    invoke-interface {v6}, Landroid/database/Cursor;->close()V

    goto :goto_0

    .line 93
    :cond_1
    :try_start_1
    invoke-interface {v6}, Landroid/database/Cursor;->moveToFirst()Z

    .line 94
    const-string v0, "_data"

    .line 95
    invoke-interface {v6, v0}, Landroid/database/Cursor;->getColumnIndex(Ljava/lang/String;)I

    move-result v0

    invoke-interface {v6, v0}, Landroid/database/Cursor;->getString(I)Ljava/lang/String;

    move-result-object v7

    .line 96
    .local v7, "pathname":Ljava/lang/String;
    if-eqz v7, :cond_2

    .line 97
    new-instance v0, Ljava/io/FileInputStream;

    invoke-direct {v0, v7}, Ljava/io/FileInputStream;-><init>(Ljava/lang/String;)V

    invoke-static {v7}, Lcom/facebook/imagepipeline/producers/LocalContentUriFetchProducer;->getLength(Ljava/lang/String;)I

    move-result v1

    invoke-virtual {p0, v0, v1}, Lcom/facebook/imagepipeline/producers/LocalContentUriFetchProducer;->getEncodedImage(Ljava/io/InputStream;I)Lcom/facebook/imagepipeline/image/EncodedImage;
    :try_end_1
    .catchall {:try_start_1 .. :try_end_1} :catchall_0

    move-result-object v3

    .line 100
    invoke-interface {v6}, Landroid/database/Cursor;->close()V

    goto :goto_0

    :cond_2
    invoke-interface {v6}, Landroid/database/Cursor;->close()V

    goto :goto_0

    .end local v7    # "pathname":Ljava/lang/String;
    :catchall_0
    move-exception v0

    invoke-interface {v6}, Landroid/database/Cursor;->close()V

    throw v0
.end method

.method private static getLength(Ljava/lang/String;)I
    .locals 2
    .param p0, "pathname"    # Ljava/lang/String;

    .prologue
    .line 106
    if-nez p0, :cond_0

    const/4 v0, -0x1

    :goto_0
    return v0

    :cond_0
    new-instance v0, Ljava/io/File;

    invoke-direct {v0, p0}, Ljava/io/File;-><init>(Ljava/lang/String;)V

    invoke-virtual {v0}, Ljava/io/File;->length()J

    move-result-wide v0

    long-to-int v0, v0

    goto :goto_0
.end method


# virtual methods
.method protected getEncodedImage(Lcom/facebook/imagepipeline/request/ImageRequest;)Lcom/facebook/imagepipeline/image/EncodedImage;
    .locals 6
    .param p1, "imageRequest"    # Lcom/facebook/imagepipeline/request/ImageRequest;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;
        }
    .end annotation

    .prologue
    const/4 v5, -0x1

    .line 55
    invoke-virtual {p1}, Lcom/facebook/imagepipeline/request/ImageRequest;->getSourceUri()Landroid/net/Uri;

    move-result-object v2

    .line 56
    .local v2, "uri":Landroid/net/Uri;
    invoke-static {v2}, Lcom/facebook/common/util/UriUtil;->isLocalContactUri(Landroid/net/Uri;)Z

    move-result v3

    if-eqz v3, :cond_3

    .line 58
    invoke-virtual {v2}, Landroid/net/Uri;->toString()Ljava/lang/String;

    move-result-object v3

    const-string v4, "/photo"

    invoke-virtual {v3, v4}, Ljava/lang/String;->endsWith(Ljava/lang/String;)Z

    move-result v3

    if-eqz v3, :cond_2

    .line 59
    iget-object v3, p0, Lcom/facebook/imagepipeline/producers/LocalContentUriFetchProducer;->mContentResolver:Landroid/content/ContentResolver;

    invoke-virtual {v3, v2}, Landroid/content/ContentResolver;->openInputStream(Landroid/net/Uri;)Ljava/io/InputStream;

    move-result-object v1

    .line 67
    .local v1, "inputStream":Ljava/io/InputStream;
    :cond_0
    invoke-virtual {p0, v1, v5}, Lcom/facebook/imagepipeline/producers/LocalContentUriFetchProducer;->getEncodedImage(Ljava/io/InputStream;I)Lcom/facebook/imagepipeline/image/EncodedImage;

    move-result-object v0

    .line 79
    .end local v1    # "inputStream":Ljava/io/InputStream;
    :cond_1
    :goto_0
    return-object v0

    .line 61
    :cond_2
    iget-object v3, p0, Lcom/facebook/imagepipeline/producers/LocalContentUriFetchProducer;->mContentResolver:Landroid/content/ContentResolver;

    invoke-static {v3, v2}, Landroid/provider/ContactsContract$Contacts;->openContactPhotoInputStream(Landroid/content/ContentResolver;Landroid/net/Uri;)Ljava/io/InputStream;

    move-result-object v1

    .line 62
    .restart local v1    # "inputStream":Ljava/io/InputStream;
    if-nez v1, :cond_0

    .line 63
    new-instance v3, Ljava/io/IOException;

    new-instance v4, Ljava/lang/StringBuilder;

    invoke-direct {v4}, Ljava/lang/StringBuilder;-><init>()V

    const-string v5, "Contact photo does not exist: "

    invoke-virtual {v4, v5}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v4

    invoke-virtual {v4, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    move-result-object v4

    invoke-virtual {v4}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v4

    invoke-direct {v3, v4}, Ljava/io/IOException;-><init>(Ljava/lang/String;)V

    throw v3

    .line 72
    .end local v1    # "inputStream":Ljava/io/InputStream;
    :cond_3
    invoke-static {v2}, Lcom/facebook/common/util/UriUtil;->isLocalCameraUri(Landroid/net/Uri;)Z

    move-result v3

    if-eqz v3, :cond_4

    .line 73
    invoke-direct {p0, v2}, Lcom/facebook/imagepipeline/producers/LocalContentUriFetchProducer;->getCameraImage(Landroid/net/Uri;)Lcom/facebook/imagepipeline/image/EncodedImage;

    move-result-object v0

    .line 74
    .local v0, "cameraImage":Lcom/facebook/imagepipeline/image/EncodedImage;
    if-nez v0, :cond_1

    .line 79
    .end local v0    # "cameraImage":Lcom/facebook/imagepipeline/image/EncodedImage;
    :cond_4
    iget-object v3, p0, Lcom/facebook/imagepipeline/producers/LocalContentUriFetchProducer;->mContentResolver:Landroid/content/ContentResolver;

    .line 80
    invoke-virtual {v3, v2}, Landroid/content/ContentResolver;->openInputStream(Landroid/net/Uri;)Ljava/io/InputStream;

    move-result-object v3

    .line 79
    invoke-virtual {p0, v3, v5}, Lcom/facebook/imagepipeline/producers/LocalContentUriFetchProducer;->getEncodedImage(Ljava/io/InputStream;I)Lcom/facebook/imagepipeline/image/EncodedImage;

    move-result-object v0

    goto :goto_0
.end method

.method protected getProducerName()Ljava/lang/String;
    .locals 1

    .prologue
    .line 111
    const-string v0, "LocalContentUriFetchProducer"

    return-object v0
.end method

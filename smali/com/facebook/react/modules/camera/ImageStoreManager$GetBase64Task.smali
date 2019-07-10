.class Lcom/facebook/react/modules/camera/ImageStoreManager$GetBase64Task;
.super Lcom/facebook/react/bridge/GuardedAsyncTask;
.source "ImageStoreManager.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/facebook/react/modules/camera/ImageStoreManager;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x2
    name = "GetBase64Task"
.end annotation

.annotation system Ldalvik/annotation/Signature;
    value = {
        "Lcom/facebook/react/bridge/GuardedAsyncTask",
        "<",
        "Ljava/lang/Void;",
        "Ljava/lang/Void;",
        ">;"
    }
.end annotation


# instance fields
.field private final mError:Lcom/facebook/react/bridge/Callback;

.field private final mSuccess:Lcom/facebook/react/bridge/Callback;

.field private final mUri:Ljava/lang/String;

.field final synthetic this$0:Lcom/facebook/react/modules/camera/ImageStoreManager;


# direct methods
.method private constructor <init>(Lcom/facebook/react/modules/camera/ImageStoreManager;Lcom/facebook/react/bridge/ReactContext;Ljava/lang/String;Lcom/facebook/react/bridge/Callback;Lcom/facebook/react/bridge/Callback;)V
    .locals 0
    .param p2, "reactContext"    # Lcom/facebook/react/bridge/ReactContext;
    .param p3, "uri"    # Ljava/lang/String;
    .param p4, "success"    # Lcom/facebook/react/bridge/Callback;
    .param p5, "error"    # Lcom/facebook/react/bridge/Callback;

    .prologue
    .line 68
    iput-object p1, p0, Lcom/facebook/react/modules/camera/ImageStoreManager$GetBase64Task;->this$0:Lcom/facebook/react/modules/camera/ImageStoreManager;

    .line 69
    invoke-direct {p0, p2}, Lcom/facebook/react/bridge/GuardedAsyncTask;-><init>(Lcom/facebook/react/bridge/ReactContext;)V

    .line 70
    iput-object p3, p0, Lcom/facebook/react/modules/camera/ImageStoreManager$GetBase64Task;->mUri:Ljava/lang/String;

    .line 71
    iput-object p4, p0, Lcom/facebook/react/modules/camera/ImageStoreManager$GetBase64Task;->mSuccess:Lcom/facebook/react/bridge/Callback;

    .line 72
    iput-object p5, p0, Lcom/facebook/react/modules/camera/ImageStoreManager$GetBase64Task;->mError:Lcom/facebook/react/bridge/Callback;

    .line 73
    return-void
.end method

.method synthetic constructor <init>(Lcom/facebook/react/modules/camera/ImageStoreManager;Lcom/facebook/react/bridge/ReactContext;Ljava/lang/String;Lcom/facebook/react/bridge/Callback;Lcom/facebook/react/bridge/Callback;Lcom/facebook/react/modules/camera/ImageStoreManager$1;)V
    .locals 0
    .param p1, "x0"    # Lcom/facebook/react/modules/camera/ImageStoreManager;
    .param p2, "x1"    # Lcom/facebook/react/bridge/ReactContext;
    .param p3, "x2"    # Ljava/lang/String;
    .param p4, "x3"    # Lcom/facebook/react/bridge/Callback;
    .param p5, "x4"    # Lcom/facebook/react/bridge/Callback;
    .param p6, "x5"    # Lcom/facebook/react/modules/camera/ImageStoreManager$1;

    .prologue
    .line 59
    invoke-direct/range {p0 .. p5}, Lcom/facebook/react/modules/camera/ImageStoreManager$GetBase64Task;-><init>(Lcom/facebook/react/modules/camera/ImageStoreManager;Lcom/facebook/react/bridge/ReactContext;Ljava/lang/String;Lcom/facebook/react/bridge/Callback;Lcom/facebook/react/bridge/Callback;)V

    return-void
.end method


# virtual methods
.method protected bridge synthetic doInBackgroundGuarded([Ljava/lang/Object;)V
    .locals 0

    .prologue
    .line 59
    check-cast p1, [Ljava/lang/Void;

    invoke-virtual {p0, p1}, Lcom/facebook/react/modules/camera/ImageStoreManager$GetBase64Task;->doInBackgroundGuarded([Ljava/lang/Void;)V

    return-void
.end method

.method protected varargs doInBackgroundGuarded([Ljava/lang/Void;)V
    .locals 14
    .param p1, "params"    # [Ljava/lang/Void;

    .prologue
    const/4 v13, 0x1

    const/4 v12, 0x0

    .line 78
    :try_start_0
    iget-object v8, p0, Lcom/facebook/react/modules/camera/ImageStoreManager$GetBase64Task;->this$0:Lcom/facebook/react/modules/camera/ImageStoreManager;

    invoke-static {v8}, Lcom/facebook/react/modules/camera/ImageStoreManager;->access$100(Lcom/facebook/react/modules/camera/ImageStoreManager;)Lcom/facebook/react/bridge/ReactApplicationContext;

    move-result-object v8

    invoke-virtual {v8}, Lcom/facebook/react/bridge/ReactApplicationContext;->getContentResolver()Landroid/content/ContentResolver;

    move-result-object v4

    .line 79
    .local v4, "contentResolver":Landroid/content/ContentResolver;
    iget-object v8, p0, Lcom/facebook/react/modules/camera/ImageStoreManager$GetBase64Task;->mUri:Ljava/lang/String;

    invoke-static {v8}, Landroid/net/Uri;->parse(Ljava/lang/String;)Landroid/net/Uri;

    move-result-object v7

    .line 80
    .local v7, "uri":Landroid/net/Uri;
    invoke-virtual {v4, v7}, Landroid/content/ContentResolver;->openInputStream(Landroid/net/Uri;)Ljava/io/InputStream;

    move-result-object v6

    .line 81
    .local v6, "is":Ljava/io/InputStream;
    new-instance v1, Ljava/io/ByteArrayOutputStream;

    invoke-direct {v1}, Ljava/io/ByteArrayOutputStream;-><init>()V

    .line 82
    .local v1, "baos":Ljava/io/ByteArrayOutputStream;
    new-instance v0, Landroid/util/Base64OutputStream;

    const/4 v8, 0x0

    invoke-direct {v0, v1, v8}, Landroid/util/Base64OutputStream;-><init>(Ljava/io/OutputStream;I)V

    .line 83
    .local v0, "b64os":Landroid/util/Base64OutputStream;
    const/16 v8, 0x2000

    new-array v2, v8, [B
    :try_end_0
    .catch Ljava/io/FileNotFoundException; {:try_start_0 .. :try_end_0} :catch_1

    .line 86
    .local v2, "buffer":[B
    :goto_0
    :try_start_1
    invoke-virtual {v6, v2}, Ljava/io/InputStream;->read([B)I

    move-result v3

    .local v3, "bytesRead":I
    const/4 v8, -0x1

    if-le v3, v8, :cond_0

    .line 87
    const/4 v8, 0x0

    invoke-virtual {v0, v2, v8, v3}, Landroid/util/Base64OutputStream;->write([BII)V
    :try_end_1
    .catch Ljava/io/IOException; {:try_start_1 .. :try_end_1} :catch_0
    .catchall {:try_start_1 .. :try_end_1} :catchall_0

    goto :goto_0

    .line 90
    .end local v3    # "bytesRead":I
    :catch_0
    move-exception v5

    .line 91
    .local v5, "e":Ljava/io/IOException;
    :try_start_2
    iget-object v8, p0, Lcom/facebook/react/modules/camera/ImageStoreManager$GetBase64Task;->mError:Lcom/facebook/react/bridge/Callback;

    const/4 v9, 0x1

    new-array v9, v9, [Ljava/lang/Object;

    const/4 v10, 0x0

    invoke-virtual {v5}, Ljava/io/IOException;->getMessage()Ljava/lang/String;

    move-result-object v11

    aput-object v11, v9, v10

    invoke-interface {v8, v9}, Lcom/facebook/react/bridge/Callback;->invoke([Ljava/lang/Object;)V
    :try_end_2
    .catchall {:try_start_2 .. :try_end_2} :catchall_0

    .line 93
    :try_start_3
    invoke-static {v6}, Lcom/facebook/react/modules/camera/ImageStoreManager;->access$200(Ljava/io/Closeable;)V

    .line 94
    invoke-static {v0}, Lcom/facebook/react/modules/camera/ImageStoreManager;->access$200(Ljava/io/Closeable;)V
    :try_end_3
    .catch Ljava/io/FileNotFoundException; {:try_start_3 .. :try_end_3} :catch_1

    .line 99
    .end local v0    # "b64os":Landroid/util/Base64OutputStream;
    .end local v1    # "baos":Ljava/io/ByteArrayOutputStream;
    .end local v2    # "buffer":[B
    .end local v4    # "contentResolver":Landroid/content/ContentResolver;
    .end local v5    # "e":Ljava/io/IOException;
    .end local v6    # "is":Ljava/io/InputStream;
    .end local v7    # "uri":Landroid/net/Uri;
    :goto_1
    return-void

    .line 89
    .restart local v0    # "b64os":Landroid/util/Base64OutputStream;
    .restart local v1    # "baos":Ljava/io/ByteArrayOutputStream;
    .restart local v2    # "buffer":[B
    .restart local v3    # "bytesRead":I
    .restart local v4    # "contentResolver":Landroid/content/ContentResolver;
    .restart local v6    # "is":Ljava/io/InputStream;
    .restart local v7    # "uri":Landroid/net/Uri;
    :cond_0
    :try_start_4
    iget-object v8, p0, Lcom/facebook/react/modules/camera/ImageStoreManager$GetBase64Task;->mSuccess:Lcom/facebook/react/bridge/Callback;

    const/4 v9, 0x1

    new-array v9, v9, [Ljava/lang/Object;

    const/4 v10, 0x0

    invoke-virtual {v1}, Ljava/io/ByteArrayOutputStream;->toString()Ljava/lang/String;

    move-result-object v11

    aput-object v11, v9, v10

    invoke-interface {v8, v9}, Lcom/facebook/react/bridge/Callback;->invoke([Ljava/lang/Object;)V
    :try_end_4
    .catch Ljava/io/IOException; {:try_start_4 .. :try_end_4} :catch_0
    .catchall {:try_start_4 .. :try_end_4} :catchall_0

    .line 93
    :try_start_5
    invoke-static {v6}, Lcom/facebook/react/modules/camera/ImageStoreManager;->access$200(Ljava/io/Closeable;)V

    .line 94
    invoke-static {v0}, Lcom/facebook/react/modules/camera/ImageStoreManager;->access$200(Ljava/io/Closeable;)V
    :try_end_5
    .catch Ljava/io/FileNotFoundException; {:try_start_5 .. :try_end_5} :catch_1

    goto :goto_1

    .line 96
    .end local v0    # "b64os":Landroid/util/Base64OutputStream;
    .end local v1    # "baos":Ljava/io/ByteArrayOutputStream;
    .end local v2    # "buffer":[B
    .end local v3    # "bytesRead":I
    .end local v4    # "contentResolver":Landroid/content/ContentResolver;
    .end local v6    # "is":Ljava/io/InputStream;
    .end local v7    # "uri":Landroid/net/Uri;
    :catch_1
    move-exception v5

    .line 97
    .local v5, "e":Ljava/io/FileNotFoundException;
    iget-object v8, p0, Lcom/facebook/react/modules/camera/ImageStoreManager$GetBase64Task;->mError:Lcom/facebook/react/bridge/Callback;

    new-array v9, v13, [Ljava/lang/Object;

    invoke-virtual {v5}, Ljava/io/FileNotFoundException;->getMessage()Ljava/lang/String;

    move-result-object v10

    aput-object v10, v9, v12

    invoke-interface {v8, v9}, Lcom/facebook/react/bridge/Callback;->invoke([Ljava/lang/Object;)V

    goto :goto_1

    .line 93
    .end local v5    # "e":Ljava/io/FileNotFoundException;
    .restart local v0    # "b64os":Landroid/util/Base64OutputStream;
    .restart local v1    # "baos":Ljava/io/ByteArrayOutputStream;
    .restart local v2    # "buffer":[B
    .restart local v4    # "contentResolver":Landroid/content/ContentResolver;
    .restart local v6    # "is":Ljava/io/InputStream;
    .restart local v7    # "uri":Landroid/net/Uri;
    :catchall_0
    move-exception v8

    :try_start_6
    invoke-static {v6}, Lcom/facebook/react/modules/camera/ImageStoreManager;->access$200(Ljava/io/Closeable;)V

    .line 94
    invoke-static {v0}, Lcom/facebook/react/modules/camera/ImageStoreManager;->access$200(Ljava/io/Closeable;)V

    throw v8
    :try_end_6
    .catch Ljava/io/FileNotFoundException; {:try_start_6 .. :try_end_6} :catch_1
.end method

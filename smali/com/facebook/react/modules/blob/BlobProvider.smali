.class public final Lcom/facebook/react/modules/blob/BlobProvider;
.super Landroid/content/ContentProvider;
.source "BlobProvider.java"


# direct methods
.method public constructor <init>()V
    .locals 0

    .prologue
    .line 24
    invoke-direct {p0}, Landroid/content/ContentProvider;-><init>()V

    return-void
.end method


# virtual methods
.method public delete(Landroid/net/Uri;Ljava/lang/String;[Ljava/lang/String;)I
    .locals 1
    .param p1, "uri"    # Landroid/net/Uri;
    .param p2, "selection"    # Ljava/lang/String;
    .param p3, "selectionArgs"    # [Ljava/lang/String;

    .prologue
    .line 49
    const/4 v0, 0x0

    return v0
.end method

.method public getType(Landroid/net/Uri;)Ljava/lang/String;
    .locals 1
    .param p1, "uri"    # Landroid/net/Uri;
    .annotation build Landroid/support/annotation/Nullable;
    .end annotation

    .prologue
    .line 39
    const/4 v0, 0x0

    return-object v0
.end method

.method public insert(Landroid/net/Uri;Landroid/content/ContentValues;)Landroid/net/Uri;
    .locals 1
    .param p1, "uri"    # Landroid/net/Uri;
    .param p2, "values"    # Landroid/content/ContentValues;
    .annotation build Landroid/support/annotation/Nullable;
    .end annotation

    .prologue
    .line 44
    const/4 v0, 0x0

    return-object v0
.end method

.method public onCreate()Z
    .locals 1

    .prologue
    .line 28
    const/4 v0, 0x1

    return v0
.end method

.method public openFile(Landroid/net/Uri;Ljava/lang/String;)Landroid/os/ParcelFileDescriptor;
    .locals 13
    .param p1, "uri"    # Landroid/net/Uri;
    .param p2, "mode"    # Ljava/lang/String;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/FileNotFoundException;
        }
    .end annotation

    .prologue
    const/4 v10, 0x0

    .line 59
    const-string v11, "r"

    invoke-virtual {p2, v11}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v11

    if-nez v11, :cond_0

    .line 60
    new-instance v10, Ljava/io/FileNotFoundException;

    new-instance v11, Ljava/lang/StringBuilder;

    invoke-direct {v11}, Ljava/lang/StringBuilder;-><init>()V

    const-string v12, "Cannot open "

    invoke-virtual {v11, v12}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v11

    invoke-virtual {p1}, Landroid/net/Uri;->toString()Ljava/lang/String;

    move-result-object v12

    invoke-virtual {v11, v12}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v11

    const-string v12, " in mode \'"

    invoke-virtual {v11, v12}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v11

    invoke-virtual {v11, p2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v11

    const-string v12, "\'"

    invoke-virtual {v11, v12}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v11

    invoke-virtual {v11}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v11

    invoke-direct {v10, v11}, Ljava/io/FileNotFoundException;-><init>(Ljava/lang/String;)V

    throw v10

    .line 63
    :cond_0
    const/4 v0, 0x0

    .line 64
    .local v0, "blobModule":Lcom/facebook/react/modules/blob/BlobModule;
    invoke-virtual {p0}, Lcom/facebook/react/modules/blob/BlobProvider;->getContext()Landroid/content/Context;

    move-result-object v11

    invoke-virtual {v11}, Landroid/content/Context;->getApplicationContext()Landroid/content/Context;

    move-result-object v1

    .line 65
    .local v1, "context":Landroid/content/Context;
    instance-of v11, v1, Lcom/facebook/react/ReactApplication;

    if-eqz v11, :cond_1

    .line 66
    check-cast v1, Lcom/facebook/react/ReactApplication;

    .end local v1    # "context":Landroid/content/Context;
    invoke-interface {v1}, Lcom/facebook/react/ReactApplication;->getReactNativeHost()Lcom/facebook/react/ReactNativeHost;

    move-result-object v4

    .line 67
    .local v4, "host":Lcom/facebook/react/ReactNativeHost;
    invoke-virtual {v4}, Lcom/facebook/react/ReactNativeHost;->getReactInstanceManager()Lcom/facebook/react/ReactInstanceManager;

    move-result-object v11

    invoke-virtual {v11}, Lcom/facebook/react/ReactInstanceManager;->getCurrentReactContext()Lcom/facebook/react/bridge/ReactContext;

    move-result-object v7

    .line 68
    .local v7, "reactContext":Lcom/facebook/react/bridge/ReactContext;
    const-class v11, Lcom/facebook/react/modules/blob/BlobModule;

    invoke-virtual {v7, v11}, Lcom/facebook/react/bridge/ReactContext;->getNativeModule(Ljava/lang/Class;)Lcom/facebook/react/bridge/NativeModule;

    move-result-object v0

    .end local v0    # "blobModule":Lcom/facebook/react/modules/blob/BlobModule;
    check-cast v0, Lcom/facebook/react/modules/blob/BlobModule;

    .line 71
    .end local v4    # "host":Lcom/facebook/react/ReactNativeHost;
    .end local v7    # "reactContext":Lcom/facebook/react/bridge/ReactContext;
    .restart local v0    # "blobModule":Lcom/facebook/react/modules/blob/BlobModule;
    :cond_1
    if-nez v0, :cond_2

    .line 72
    new-instance v10, Ljava/lang/RuntimeException;

    const-string v11, "No blob module associated with BlobProvider"

    invoke-direct {v10, v11}, Ljava/lang/RuntimeException;-><init>(Ljava/lang/String;)V

    throw v10

    .line 75
    :cond_2
    invoke-virtual {v0, p1}, Lcom/facebook/react/modules/blob/BlobModule;->resolve(Landroid/net/Uri;)[B

    move-result-object v2

    .line 76
    .local v2, "data":[B
    if-nez v2, :cond_3

    .line 77
    new-instance v10, Ljava/io/FileNotFoundException;

    new-instance v11, Ljava/lang/StringBuilder;

    invoke-direct {v11}, Ljava/lang/StringBuilder;-><init>()V

    const-string v12, "Cannot open "

    invoke-virtual {v11, v12}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v11

    invoke-virtual {p1}, Landroid/net/Uri;->toString()Ljava/lang/String;

    move-result-object v12

    invoke-virtual {v11, v12}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v11

    const-string v12, ", blob not found."

    invoke-virtual {v11, v12}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v11

    invoke-virtual {v11}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v11

    invoke-direct {v10, v11}, Ljava/io/FileNotFoundException;-><init>(Ljava/lang/String;)V

    throw v10

    .line 82
    :cond_3
    :try_start_0
    invoke-static {}, Landroid/os/ParcelFileDescriptor;->createPipe()[Landroid/os/ParcelFileDescriptor;
    :try_end_0
    .catch Ljava/io/IOException; {:try_start_0 .. :try_end_0} :catch_0

    move-result-object v6

    .line 86
    .local v6, "pipe":[Landroid/os/ParcelFileDescriptor;
    const/4 v11, 0x0

    aget-object v8, v6, v11

    .line 87
    .local v8, "readSide":Landroid/os/ParcelFileDescriptor;
    const/4 v11, 0x1

    aget-object v9, v6, v11

    .line 89
    .local v9, "writeSide":Landroid/os/ParcelFileDescriptor;
    new-instance v5, Landroid/os/ParcelFileDescriptor$AutoCloseOutputStream;

    invoke-direct {v5, v9}, Landroid/os/ParcelFileDescriptor$AutoCloseOutputStream;-><init>(Landroid/os/ParcelFileDescriptor;)V

    .line 91
    .local v5, "outputStream":Ljava/io/OutputStream;
    :try_start_1
    invoke-virtual {v5, v2}, Ljava/io/OutputStream;->write([B)V

    .line 92
    invoke-virtual {v5}, Ljava/io/OutputStream;->close()V
    :try_end_1
    .catch Ljava/io/IOException; {:try_start_1 .. :try_end_1} :catch_1

    .line 97
    .end local v5    # "outputStream":Ljava/io/OutputStream;
    .end local v6    # "pipe":[Landroid/os/ParcelFileDescriptor;
    .end local v8    # "readSide":Landroid/os/ParcelFileDescriptor;
    .end local v9    # "writeSide":Landroid/os/ParcelFileDescriptor;
    :goto_0
    return-object v8

    .line 83
    :catch_0
    move-exception v3

    .local v3, "exception":Ljava/io/IOException;
    move-object v8, v10

    .line 84
    goto :goto_0

    .line 93
    .end local v3    # "exception":Ljava/io/IOException;
    .restart local v5    # "outputStream":Ljava/io/OutputStream;
    .restart local v6    # "pipe":[Landroid/os/ParcelFileDescriptor;
    .restart local v8    # "readSide":Landroid/os/ParcelFileDescriptor;
    .restart local v9    # "writeSide":Landroid/os/ParcelFileDescriptor;
    :catch_1
    move-exception v3

    .restart local v3    # "exception":Ljava/io/IOException;
    move-object v8, v10

    .line 94
    goto :goto_0
.end method

.method public query(Landroid/net/Uri;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    .locals 1
    .param p1, "uri"    # Landroid/net/Uri;
    .param p2, "projection"    # [Ljava/lang/String;
    .param p3, "selection"    # Ljava/lang/String;
    .param p4, "selectionArgs"    # [Ljava/lang/String;
    .param p5, "sortOrder"    # Ljava/lang/String;
    .annotation build Landroid/support/annotation/Nullable;
    .end annotation

    .prologue
    .line 34
    const/4 v0, 0x0

    return-object v0
.end method

.method public update(Landroid/net/Uri;Landroid/content/ContentValues;Ljava/lang/String;[Ljava/lang/String;)I
    .locals 1
    .param p1, "uri"    # Landroid/net/Uri;
    .param p2, "values"    # Landroid/content/ContentValues;
    .param p3, "selection"    # Ljava/lang/String;
    .param p4, "selectionArgs"    # [Ljava/lang/String;

    .prologue
    .line 54
    const/4 v0, 0x0

    return v0
.end method

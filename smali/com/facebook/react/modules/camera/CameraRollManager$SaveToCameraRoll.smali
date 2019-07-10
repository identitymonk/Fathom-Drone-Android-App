.class Lcom/facebook/react/modules/camera/CameraRollManager$SaveToCameraRoll;
.super Lcom/facebook/react/bridge/GuardedAsyncTask;
.source "CameraRollManager.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/facebook/react/modules/camera/CameraRollManager;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0xa
    name = "SaveToCameraRoll"
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
.field private final mContext:Landroid/content/Context;

.field private final mPromise:Lcom/facebook/react/bridge/Promise;

.field private final mUri:Landroid/net/Uri;


# direct methods
.method public constructor <init>(Lcom/facebook/react/bridge/ReactContext;Landroid/net/Uri;Lcom/facebook/react/bridge/Promise;)V
    .locals 0
    .param p1, "context"    # Lcom/facebook/react/bridge/ReactContext;
    .param p2, "uri"    # Landroid/net/Uri;
    .param p3, "promise"    # Lcom/facebook/react/bridge/Promise;

    .prologue
    .line 128
    invoke-direct {p0, p1}, Lcom/facebook/react/bridge/GuardedAsyncTask;-><init>(Lcom/facebook/react/bridge/ReactContext;)V

    .line 129
    iput-object p1, p0, Lcom/facebook/react/modules/camera/CameraRollManager$SaveToCameraRoll;->mContext:Landroid/content/Context;

    .line 130
    iput-object p2, p0, Lcom/facebook/react/modules/camera/CameraRollManager$SaveToCameraRoll;->mUri:Landroid/net/Uri;

    .line 131
    iput-object p3, p0, Lcom/facebook/react/modules/camera/CameraRollManager$SaveToCameraRoll;->mPromise:Lcom/facebook/react/bridge/Promise;

    .line 132
    return-void
.end method

.method static synthetic access$000(Lcom/facebook/react/modules/camera/CameraRollManager$SaveToCameraRoll;)Lcom/facebook/react/bridge/Promise;
    .locals 1
    .param p0, "x0"    # Lcom/facebook/react/modules/camera/CameraRollManager$SaveToCameraRoll;

    .prologue
    .line 121
    iget-object v0, p0, Lcom/facebook/react/modules/camera/CameraRollManager$SaveToCameraRoll;->mPromise:Lcom/facebook/react/bridge/Promise;

    return-object v0
.end method


# virtual methods
.method protected bridge synthetic doInBackgroundGuarded([Ljava/lang/Object;)V
    .locals 0

    .prologue
    .line 121
    check-cast p1, [Ljava/lang/Void;

    invoke-virtual {p0, p1}, Lcom/facebook/react/modules/camera/CameraRollManager$SaveToCameraRoll;->doInBackgroundGuarded([Ljava/lang/Void;)V

    return-void
.end method

.method protected varargs doInBackgroundGuarded([Ljava/lang/Void;)V
    .locals 15
    .param p1, "params"    # [Ljava/lang/Void;

    .prologue
    .line 136
    new-instance v12, Ljava/io/File;

    iget-object v2, p0, Lcom/facebook/react/modules/camera/CameraRollManager$SaveToCameraRoll;->mUri:Landroid/net/Uri;

    invoke-virtual {v2}, Landroid/net/Uri;->getPath()Ljava/lang/String;

    move-result-object v2

    invoke-direct {v12, v2}, Ljava/io/File;-><init>(Ljava/lang/String;)V

    .line 137
    .local v12, "source":Ljava/io/File;
    const/4 v1, 0x0

    .local v1, "input":Ljava/nio/channels/FileChannel;
    const/4 v0, 0x0

    .line 139
    .local v0, "output":Ljava/nio/channels/FileChannel;
    :try_start_0
    sget-object v2, Landroid/os/Environment;->DIRECTORY_DCIM:Ljava/lang/String;

    invoke-static {v2}, Landroid/os/Environment;->getExternalStoragePublicDirectory(Ljava/lang/String;)Ljava/io/File;

    move-result-object v8

    .line 140
    .local v8, "exportDir":Ljava/io/File;
    invoke-virtual {v8}, Ljava/io/File;->mkdirs()Z

    .line 141
    invoke-virtual {v8}, Ljava/io/File;->isDirectory()Z

    move-result v2

    if-nez v2, :cond_2

    .line 142
    iget-object v2, p0, Lcom/facebook/react/modules/camera/CameraRollManager$SaveToCameraRoll;->mPromise:Lcom/facebook/react/bridge/Promise;

    const-string v3, "E_UNABLE_TO_LOAD"

    const-string v4, "External media storage directory not available"

    invoke-interface {v2, v3, v4}, Lcom/facebook/react/bridge/Promise;->reject(Ljava/lang/String;Ljava/lang/String;)V
    :try_end_0
    .catch Ljava/io/IOException; {:try_start_0 .. :try_end_0} :catch_4
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    .line 182
    if-eqz v1, :cond_0

    invoke-virtual {v1}, Ljava/nio/channels/FileChannel;->isOpen()Z

    move-result v2

    if-eqz v2, :cond_0

    .line 184
    :try_start_1
    invoke-virtual {v1}, Ljava/nio/channels/FileChannel;->close()V
    :try_end_1
    .catch Ljava/io/IOException; {:try_start_1 .. :try_end_1} :catch_0

    .line 189
    :cond_0
    :goto_0
    if-eqz v0, :cond_1

    invoke-virtual {v0}, Ljava/nio/channels/FileChannel;->isOpen()Z

    move-result v2

    if-eqz v2, :cond_1

    .line 191
    :try_start_2
    invoke-virtual {v0}, Ljava/nio/channels/FileChannel;->close()V
    :try_end_2
    .catch Ljava/io/IOException; {:try_start_2 .. :try_end_2} :catch_1

    .line 197
    .end local v8    # "exportDir":Ljava/io/File;
    :cond_1
    :goto_1
    return-void

    .line 185
    .restart local v8    # "exportDir":Ljava/io/File;
    :catch_0
    move-exception v7

    .line 186
    .local v7, "e":Ljava/io/IOException;
    const-string v2, "ReactNative"

    const-string v3, "Could not close input channel"

    invoke-static {v2, v3, v7}, Lcom/facebook/common/logging/FLog;->e(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V

    goto :goto_0

    .line 192
    .end local v7    # "e":Ljava/io/IOException;
    :catch_1
    move-exception v7

    .line 193
    .restart local v7    # "e":Ljava/io/IOException;
    const-string v2, "ReactNative"

    const-string v3, "Could not close output channel"

    invoke-static {v2, v3, v7}, Lcom/facebook/common/logging/FLog;->e(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V

    goto :goto_1

    .line 145
    .end local v7    # "e":Ljava/io/IOException;
    :cond_2
    :try_start_3
    new-instance v6, Ljava/io/File;

    invoke-virtual {v12}, Ljava/io/File;->getName()Ljava/lang/String;

    move-result-object v2

    invoke-direct {v6, v8, v2}, Ljava/io/File;-><init>(Ljava/io/File;Ljava/lang/String;)V

    .line 146
    .local v6, "dest":Ljava/io/File;
    const/4 v10, 0x0

    .line 147
    .local v10, "n":I
    invoke-virtual {v12}, Ljava/io/File;->getName()Ljava/lang/String;

    move-result-object v9

    .line 149
    .local v9, "fullSourceName":Ljava/lang/String;
    const/16 v2, 0x2e

    invoke-virtual {v9, v2}, Ljava/lang/String;->indexOf(I)I

    move-result v2

    if-ltz v2, :cond_3

    .line 150
    const/4 v2, 0x0

    const/16 v3, 0x2e

    invoke-virtual {v9, v3}, Ljava/lang/String;->lastIndexOf(I)I

    move-result v3

    invoke-virtual {v9, v2, v3}, Ljava/lang/String;->substring(II)Ljava/lang/String;

    move-result-object v14

    .line 151
    .local v14, "sourceName":Ljava/lang/String;
    const/16 v2, 0x2e

    invoke-virtual {v9, v2}, Ljava/lang/String;->lastIndexOf(I)I

    move-result v2

    invoke-virtual {v9, v2}, Ljava/lang/String;->substring(I)Ljava/lang/String;

    move-result-object v13

    .local v13, "sourceExt":Ljava/lang/String;
    move v11, v10

    .line 156
    .end local v10    # "n":I
    .local v11, "n":I
    :goto_2
    invoke-virtual {v6}, Ljava/io/File;->createNewFile()Z

    move-result v2

    if-nez v2, :cond_4

    .line 157
    new-instance v6, Ljava/io/File;

    .end local v6    # "dest":Ljava/io/File;
    new-instance v2, Ljava/lang/StringBuilder;

    invoke-direct {v2}, Ljava/lang/StringBuilder;-><init>()V

    invoke-virtual {v2, v14}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    const-string v3, "_"

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    add-int/lit8 v10, v11, 0x1

    .end local v11    # "n":I
    .restart local v10    # "n":I
    invoke-virtual {v2, v11}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2, v13}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v2

    invoke-direct {v6, v8, v2}, Ljava/io/File;-><init>(Ljava/io/File;Ljava/lang/String;)V

    .restart local v6    # "dest":Ljava/io/File;
    move v11, v10

    .end local v10    # "n":I
    .restart local v11    # "n":I
    goto :goto_2

    .line 153
    .end local v11    # "n":I
    .end local v13    # "sourceExt":Ljava/lang/String;
    .end local v14    # "sourceName":Ljava/lang/String;
    .restart local v10    # "n":I
    :cond_3
    move-object v14, v9

    .line 154
    .restart local v14    # "sourceName":Ljava/lang/String;
    const-string v13, ""

    .restart local v13    # "sourceExt":Ljava/lang/String;
    move v11, v10

    .end local v10    # "n":I
    .restart local v11    # "n":I
    goto :goto_2

    .line 159
    :cond_4
    new-instance v2, Ljava/io/FileInputStream;

    invoke-direct {v2, v12}, Ljava/io/FileInputStream;-><init>(Ljava/io/File;)V

    invoke-virtual {v2}, Ljava/io/FileInputStream;->getChannel()Ljava/nio/channels/FileChannel;

    move-result-object v1

    .line 160
    new-instance v2, Ljava/io/FileOutputStream;

    invoke-direct {v2, v6}, Ljava/io/FileOutputStream;-><init>(Ljava/io/File;)V

    invoke-virtual {v2}, Ljava/io/FileOutputStream;->getChannel()Ljava/nio/channels/FileChannel;

    move-result-object v0

    .line 161
    const-wide/16 v2, 0x0

    invoke-virtual {v1}, Ljava/nio/channels/FileChannel;->size()J

    move-result-wide v4

    invoke-virtual/range {v0 .. v5}, Ljava/nio/channels/FileChannel;->transferFrom(Ljava/nio/channels/ReadableByteChannel;JJ)J

    .line 162
    invoke-virtual {v1}, Ljava/nio/channels/FileChannel;->close()V

    .line 163
    invoke-virtual {v0}, Ljava/nio/channels/FileChannel;->close()V

    .line 165
    iget-object v2, p0, Lcom/facebook/react/modules/camera/CameraRollManager$SaveToCameraRoll;->mContext:Landroid/content/Context;

    const/4 v3, 0x1

    new-array v3, v3, [Ljava/lang/String;

    const/4 v4, 0x0

    .line 167
    invoke-virtual {v6}, Ljava/io/File;->getAbsolutePath()Ljava/lang/String;

    move-result-object v5

    aput-object v5, v3, v4

    const/4 v4, 0x0

    new-instance v5, Lcom/facebook/react/modules/camera/CameraRollManager$SaveToCameraRoll$1;

    invoke-direct {v5, p0}, Lcom/facebook/react/modules/camera/CameraRollManager$SaveToCameraRoll$1;-><init>(Lcom/facebook/react/modules/camera/CameraRollManager$SaveToCameraRoll;)V

    .line 165
    invoke-static {v2, v3, v4, v5}, Landroid/media/MediaScannerConnection;->scanFile(Landroid/content/Context;[Ljava/lang/String;[Ljava/lang/String;Landroid/media/MediaScannerConnection$OnScanCompletedListener;)V
    :try_end_3
    .catch Ljava/io/IOException; {:try_start_3 .. :try_end_3} :catch_4
    .catchall {:try_start_3 .. :try_end_3} :catchall_0

    .line 182
    if-eqz v1, :cond_5

    invoke-virtual {v1}, Ljava/nio/channels/FileChannel;->isOpen()Z

    move-result v2

    if-eqz v2, :cond_5

    .line 184
    :try_start_4
    invoke-virtual {v1}, Ljava/nio/channels/FileChannel;->close()V
    :try_end_4
    .catch Ljava/io/IOException; {:try_start_4 .. :try_end_4} :catch_3

    .line 189
    :cond_5
    :goto_3
    if-eqz v0, :cond_1

    invoke-virtual {v0}, Ljava/nio/channels/FileChannel;->isOpen()Z

    move-result v2

    if-eqz v2, :cond_1

    .line 191
    :try_start_5
    invoke-virtual {v0}, Ljava/nio/channels/FileChannel;->close()V
    :try_end_5
    .catch Ljava/io/IOException; {:try_start_5 .. :try_end_5} :catch_2

    goto/16 :goto_1

    .line 192
    :catch_2
    move-exception v7

    .line 193
    .restart local v7    # "e":Ljava/io/IOException;
    const-string v2, "ReactNative"

    const-string v3, "Could not close output channel"

    invoke-static {v2, v3, v7}, Lcom/facebook/common/logging/FLog;->e(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V

    goto/16 :goto_1

    .line 185
    .end local v7    # "e":Ljava/io/IOException;
    :catch_3
    move-exception v7

    .line 186
    .restart local v7    # "e":Ljava/io/IOException;
    const-string v2, "ReactNative"

    const-string v3, "Could not close input channel"

    invoke-static {v2, v3, v7}, Lcom/facebook/common/logging/FLog;->e(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V

    goto :goto_3

    .line 179
    .end local v6    # "dest":Ljava/io/File;
    .end local v7    # "e":Ljava/io/IOException;
    .end local v8    # "exportDir":Ljava/io/File;
    .end local v9    # "fullSourceName":Ljava/lang/String;
    .end local v11    # "n":I
    .end local v13    # "sourceExt":Ljava/lang/String;
    .end local v14    # "sourceName":Ljava/lang/String;
    :catch_4
    move-exception v7

    .line 180
    .restart local v7    # "e":Ljava/io/IOException;
    :try_start_6
    iget-object v2, p0, Lcom/facebook/react/modules/camera/CameraRollManager$SaveToCameraRoll;->mPromise:Lcom/facebook/react/bridge/Promise;

    invoke-interface {v2, v7}, Lcom/facebook/react/bridge/Promise;->reject(Ljava/lang/Throwable;)V
    :try_end_6
    .catchall {:try_start_6 .. :try_end_6} :catchall_0

    .line 182
    if-eqz v1, :cond_6

    invoke-virtual {v1}, Ljava/nio/channels/FileChannel;->isOpen()Z

    move-result v2

    if-eqz v2, :cond_6

    .line 184
    :try_start_7
    invoke-virtual {v1}, Ljava/nio/channels/FileChannel;->close()V
    :try_end_7
    .catch Ljava/io/IOException; {:try_start_7 .. :try_end_7} :catch_6

    .line 189
    :cond_6
    :goto_4
    if-eqz v0, :cond_1

    invoke-virtual {v0}, Ljava/nio/channels/FileChannel;->isOpen()Z

    move-result v2

    if-eqz v2, :cond_1

    .line 191
    :try_start_8
    invoke-virtual {v0}, Ljava/nio/channels/FileChannel;->close()V
    :try_end_8
    .catch Ljava/io/IOException; {:try_start_8 .. :try_end_8} :catch_5

    goto/16 :goto_1

    .line 192
    :catch_5
    move-exception v7

    .line 193
    const-string v2, "ReactNative"

    const-string v3, "Could not close output channel"

    invoke-static {v2, v3, v7}, Lcom/facebook/common/logging/FLog;->e(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V

    goto/16 :goto_1

    .line 185
    :catch_6
    move-exception v7

    .line 186
    const-string v2, "ReactNative"

    const-string v3, "Could not close input channel"

    invoke-static {v2, v3, v7}, Lcom/facebook/common/logging/FLog;->e(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V

    goto :goto_4

    .line 182
    .end local v7    # "e":Ljava/io/IOException;
    :catchall_0
    move-exception v2

    if-eqz v1, :cond_7

    invoke-virtual {v1}, Ljava/nio/channels/FileChannel;->isOpen()Z

    move-result v3

    if-eqz v3, :cond_7

    .line 184
    :try_start_9
    invoke-virtual {v1}, Ljava/nio/channels/FileChannel;->close()V
    :try_end_9
    .catch Ljava/io/IOException; {:try_start_9 .. :try_end_9} :catch_7

    .line 189
    :cond_7
    :goto_5
    if-eqz v0, :cond_8

    invoke-virtual {v0}, Ljava/nio/channels/FileChannel;->isOpen()Z

    move-result v3

    if-eqz v3, :cond_8

    .line 191
    :try_start_a
    invoke-virtual {v0}, Ljava/nio/channels/FileChannel;->close()V
    :try_end_a
    .catch Ljava/io/IOException; {:try_start_a .. :try_end_a} :catch_8

    .line 194
    :cond_8
    :goto_6
    throw v2

    .line 185
    :catch_7
    move-exception v7

    .line 186
    .restart local v7    # "e":Ljava/io/IOException;
    const-string v3, "ReactNative"

    const-string v4, "Could not close input channel"

    invoke-static {v3, v4, v7}, Lcom/facebook/common/logging/FLog;->e(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V

    goto :goto_5

    .line 192
    .end local v7    # "e":Ljava/io/IOException;
    :catch_8
    move-exception v7

    .line 193
    .restart local v7    # "e":Ljava/io/IOException;
    const-string v3, "ReactNative"

    const-string v4, "Could not close output channel"

    invoke-static {v3, v4, v7}, Lcom/facebook/common/logging/FLog;->e(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V

    goto :goto_6
.end method

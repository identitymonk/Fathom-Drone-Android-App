.class public abstract Lcom/facebook/soloader/UnpackingSoSource;
.super Lcom/facebook/soloader/DirectorySoSource;
.source "UnpackingSoSource.java"


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lcom/facebook/soloader/UnpackingSoSource$Unpacker;,
        Lcom/facebook/soloader/UnpackingSoSource$InputDsoIterator;,
        Lcom/facebook/soloader/UnpackingSoSource$InputDso;,
        Lcom/facebook/soloader/UnpackingSoSource$DsoManifest;,
        Lcom/facebook/soloader/UnpackingSoSource$Dso;
    }
.end annotation


# static fields
.field private static final DEPS_FILE_NAME:Ljava/lang/String; = "dso_deps"

.field private static final LOCK_FILE_NAME:Ljava/lang/String; = "dso_lock"

.field private static final MANIFEST_FILE_NAME:Ljava/lang/String; = "dso_manifest"

.field private static final MANIFEST_VERSION:B = 0x1t

.field private static final STATE_CLEAN:B = 0x1t

.field private static final STATE_DIRTY:B = 0x0t

.field private static final STATE_FILE_NAME:Ljava/lang/String; = "dso_state"

.field private static final TAG:Ljava/lang/String; = "fb-UnpackingSoSource"


# instance fields
.field protected final mContext:Landroid/content/Context;


# direct methods
.method protected constructor <init>(Landroid/content/Context;Ljava/lang/String;)V
    .locals 2
    .param p1, "context"    # Landroid/content/Context;
    .param p2, "name"    # Ljava/lang/String;

    .prologue
    .line 40
    invoke-static {p1, p2}, Lcom/facebook/soloader/UnpackingSoSource;->getSoStorePath(Landroid/content/Context;Ljava/lang/String;)Ljava/io/File;

    move-result-object v0

    const/4 v1, 0x1

    invoke-direct {p0, v0, v1}, Lcom/facebook/soloader/DirectorySoSource;-><init>(Ljava/io/File;I)V

    .line 41
    iput-object p1, p0, Lcom/facebook/soloader/UnpackingSoSource;->mContext:Landroid/content/Context;

    .line 42
    return-void
.end method

.method static synthetic access$000(Ljava/io/File;B)V
    .locals 0
    .param p0, "x0"    # Ljava/io/File;
    .param p1, "x1"    # B
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;
        }
    .end annotation

    .prologue
    .line 23
    invoke-static {p0, p1}, Lcom/facebook/soloader/UnpackingSoSource;->writeState(Ljava/io/File;B)V

    return-void
.end method

.method private deleteUnmentionedFiles([Lcom/facebook/soloader/UnpackingSoSource$Dso;)V
    .locals 9
    .param p1, "dsos"    # [Lcom/facebook/soloader/UnpackingSoSource$Dso;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;
        }
    .end annotation

    .prologue
    .line 145
    iget-object v6, p0, Lcom/facebook/soloader/UnpackingSoSource;->soDirectory:Ljava/io/File;

    invoke-virtual {v6}, Ljava/io/File;->list()[Ljava/lang/String;

    move-result-object v0

    .line 146
    .local v0, "existingFiles":[Ljava/lang/String;
    if-nez v0, :cond_0

    .line 147
    new-instance v6, Ljava/io/IOException;

    new-instance v7, Ljava/lang/StringBuilder;

    invoke-direct {v7}, Ljava/lang/StringBuilder;-><init>()V

    const-string v8, "unable to list directory "

    invoke-virtual {v7, v8}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v7

    iget-object v8, p0, Lcom/facebook/soloader/UnpackingSoSource;->soDirectory:Ljava/io/File;

    invoke-virtual {v7, v8}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    move-result-object v7

    invoke-virtual {v7}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v7

    invoke-direct {v6, v7}, Ljava/io/IOException;-><init>(Ljava/lang/String;)V

    throw v6

    .line 150
    :cond_0
    const/4 v4, 0x0

    .local v4, "i":I
    :goto_0
    array-length v6, v0

    if-ge v4, v6, :cond_5

    .line 151
    aget-object v1, v0, v4

    .line 152
    .local v1, "fileName":Ljava/lang/String;
    const-string v6, "dso_state"

    invoke-virtual {v1, v6}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v6

    if-nez v6, :cond_1

    const-string v6, "dso_lock"

    invoke-virtual {v1, v6}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v6

    if-nez v6, :cond_1

    const-string v6, "dso_deps"

    invoke-virtual {v1, v6}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v6

    if-nez v6, :cond_1

    const-string v6, "dso_manifest"

    invoke-virtual {v1, v6}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v6

    if-eqz v6, :cond_2

    .line 150
    :cond_1
    :goto_1
    add-int/lit8 v4, v4, 0x1

    goto :goto_0

    .line 159
    :cond_2
    const/4 v3, 0x0

    .line 160
    .local v3, "found":Z
    const/4 v5, 0x0

    .local v5, "j":I
    :goto_2
    if-nez v3, :cond_4

    array-length v6, p1

    if-ge v5, v6, :cond_4

    .line 161
    aget-object v6, p1, v5

    iget-object v6, v6, Lcom/facebook/soloader/UnpackingSoSource$Dso;->name:Ljava/lang/String;

    invoke-virtual {v6, v1}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v6

    if-eqz v6, :cond_3

    .line 162
    const/4 v3, 0x1

    .line 160
    :cond_3
    add-int/lit8 v5, v5, 0x1

    goto :goto_2

    .line 166
    :cond_4
    if-nez v3, :cond_1

    .line 167
    new-instance v2, Ljava/io/File;

    iget-object v6, p0, Lcom/facebook/soloader/UnpackingSoSource;->soDirectory:Ljava/io/File;

    invoke-direct {v2, v6, v1}, Ljava/io/File;-><init>(Ljava/io/File;Ljava/lang/String;)V

    .line 168
    .local v2, "fileNameToDelete":Ljava/io/File;
    const-string v6, "fb-UnpackingSoSource"

    new-instance v7, Ljava/lang/StringBuilder;

    invoke-direct {v7}, Ljava/lang/StringBuilder;-><init>()V

    const-string v8, "deleting unaccounted-for file "

    invoke-virtual {v7, v8}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v7

    invoke-virtual {v7, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    move-result-object v7

    invoke-virtual {v7}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v7

    invoke-static {v6, v7}, Landroid/util/Log;->v(Ljava/lang/String;Ljava/lang/String;)I

    .line 169
    invoke-static {v2}, Lcom/facebook/soloader/SysUtil;->dumbDeleteRecursive(Ljava/io/File;)V

    goto :goto_1

    .line 172
    .end local v1    # "fileName":Ljava/lang/String;
    .end local v2    # "fileNameToDelete":Ljava/io/File;
    .end local v3    # "found":Z
    .end local v5    # "j":I
    :cond_5
    return-void
.end method

.method private extractDso(Lcom/facebook/soloader/UnpackingSoSource$InputDso;[B)V
    .locals 9
    .param p1, "iDso"    # Lcom/facebook/soloader/UnpackingSoSource$InputDso;
    .param p2, "ioBuffer"    # [B
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;
        }
    .end annotation

    .prologue
    const/4 v8, 0x1

    .line 175
    const-string v5, "fb-UnpackingSoSource"

    new-instance v6, Ljava/lang/StringBuilder;

    invoke-direct {v6}, Ljava/lang/StringBuilder;-><init>()V

    const-string v7, "extracting DSO "

    invoke-virtual {v6, v7}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v6

    iget-object v7, p1, Lcom/facebook/soloader/UnpackingSoSource$InputDso;->dso:Lcom/facebook/soloader/UnpackingSoSource$Dso;

    iget-object v7, v7, Lcom/facebook/soloader/UnpackingSoSource$Dso;->name:Ljava/lang/String;

    invoke-virtual {v6, v7}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v6

    invoke-virtual {v6}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v6

    invoke-static {v5, v6}, Landroid/util/Log;->i(Ljava/lang/String;Ljava/lang/String;)I

    .line 176
    new-instance v2, Ljava/io/File;

    iget-object v5, p0, Lcom/facebook/soloader/UnpackingSoSource;->soDirectory:Ljava/io/File;

    iget-object v6, p1, Lcom/facebook/soloader/UnpackingSoSource$InputDso;->dso:Lcom/facebook/soloader/UnpackingSoSource$Dso;

    iget-object v6, v6, Lcom/facebook/soloader/UnpackingSoSource$Dso;->name:Ljava/lang/String;

    invoke-direct {v2, v5, v6}, Ljava/io/File;-><init>(Ljava/io/File;Ljava/lang/String;)V

    .line 177
    .local v2, "dsoFileName":Ljava/io/File;
    const/4 v1, 0x0

    .line 179
    .local v1, "dsoFile":Ljava/io/RandomAccessFile;
    :try_start_0
    new-instance v1, Ljava/io/RandomAccessFile;

    .end local v1    # "dsoFile":Ljava/io/RandomAccessFile;
    const-string v5, "rw"

    invoke-direct {v1, v2, v5}, Ljava/io/RandomAccessFile;-><init>(Ljava/io/File;Ljava/lang/String;)V
    :try_end_0
    .catch Ljava/io/IOException; {:try_start_0 .. :try_end_0} :catch_0

    .line 187
    .restart local v1    # "dsoFile":Ljava/io/RandomAccessFile;
    :goto_0
    :try_start_1
    iget-object v0, p1, Lcom/facebook/soloader/UnpackingSoSource$InputDso;->content:Ljava/io/InputStream;

    .line 188
    .local v0, "dsoContent":Ljava/io/InputStream;
    invoke-virtual {v0}, Ljava/io/InputStream;->available()I

    move-result v4

    .line 189
    .local v4, "sizeHint":I
    if-le v4, v8, :cond_0

    .line 190
    invoke-virtual {v1}, Ljava/io/RandomAccessFile;->getFD()Ljava/io/FileDescriptor;

    move-result-object v5

    int-to-long v6, v4

    invoke-static {v5, v6, v7}, Lcom/facebook/soloader/SysUtil;->fallocateIfSupported(Ljava/io/FileDescriptor;J)V

    .line 192
    :cond_0
    iget-object v5, p1, Lcom/facebook/soloader/UnpackingSoSource$InputDso;->content:Ljava/io/InputStream;

    const v6, 0x7fffffff

    invoke-static {v1, v5, v6, p2}, Lcom/facebook/soloader/SysUtil;->copyBytes(Ljava/io/RandomAccessFile;Ljava/io/InputStream;I[B)I

    .line 193
    invoke-virtual {v1}, Ljava/io/RandomAccessFile;->getFilePointer()J

    move-result-wide v6

    invoke-virtual {v1, v6, v7}, Ljava/io/RandomAccessFile;->setLength(J)V

    .line 194
    const/4 v5, 0x1

    const/4 v6, 0x0

    invoke-virtual {v2, v5, v6}, Ljava/io/File;->setExecutable(ZZ)Z

    move-result v5

    if-nez v5, :cond_1

    .line 195
    new-instance v5, Ljava/io/IOException;

    new-instance v6, Ljava/lang/StringBuilder;

    invoke-direct {v6}, Ljava/lang/StringBuilder;-><init>()V

    const-string v7, "cannot make file executable: "

    invoke-virtual {v6, v7}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v6

    invoke-virtual {v6, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    move-result-object v6

    invoke-virtual {v6}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v6

    invoke-direct {v5, v6}, Ljava/io/IOException;-><init>(Ljava/lang/String;)V

    throw v5
    :try_end_1
    .catchall {:try_start_1 .. :try_end_1} :catchall_0

    .line 198
    .end local v0    # "dsoContent":Ljava/io/InputStream;
    .end local v4    # "sizeHint":I
    :catchall_0
    move-exception v5

    invoke-virtual {v1}, Ljava/io/RandomAccessFile;->close()V

    throw v5

    .line 180
    .end local v1    # "dsoFile":Ljava/io/RandomAccessFile;
    :catch_0
    move-exception v3

    .line 181
    .local v3, "ex":Ljava/io/IOException;
    const-string v5, "fb-UnpackingSoSource"

    new-instance v6, Ljava/lang/StringBuilder;

    invoke-direct {v6}, Ljava/lang/StringBuilder;-><init>()V

    const-string v7, "error overwriting "

    invoke-virtual {v6, v7}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v6

    invoke-virtual {v6, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    move-result-object v6

    const-string v7, " trying to delete and start over"

    invoke-virtual {v6, v7}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v6

    invoke-virtual {v6}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v6

    invoke-static {v5, v6, v3}, Landroid/util/Log;->w(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)I

    .line 182
    invoke-virtual {v2}, Ljava/io/File;->delete()Z

    .line 183
    new-instance v1, Ljava/io/RandomAccessFile;

    const-string v5, "rw"

    invoke-direct {v1, v2, v5}, Ljava/io/RandomAccessFile;-><init>(Ljava/io/File;Ljava/lang/String;)V

    .restart local v1    # "dsoFile":Ljava/io/RandomAccessFile;
    goto :goto_0

    .line 198
    .end local v3    # "ex":Ljava/io/IOException;
    .restart local v0    # "dsoContent":Ljava/io/InputStream;
    .restart local v4    # "sizeHint":I
    :cond_1
    invoke-virtual {v1}, Ljava/io/RandomAccessFile;->close()V

    .line 200
    return-void
.end method

.method public static getSoStorePath(Landroid/content/Context;Ljava/lang/String;)Ljava/io/File;
    .locals 3
    .param p0, "context"    # Landroid/content/Context;
    .param p1, "name"    # Ljava/lang/String;

    .prologue
    .line 45
    new-instance v0, Ljava/io/File;

    new-instance v1, Ljava/lang/StringBuilder;

    invoke-direct {v1}, Ljava/lang/StringBuilder;-><init>()V

    invoke-virtual {p0}, Landroid/content/Context;->getApplicationInfo()Landroid/content/pm/ApplicationInfo;

    move-result-object v2

    iget-object v2, v2, Landroid/content/pm/ApplicationInfo;->dataDir:Ljava/lang/String;

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    const-string v2, "/"

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1, p1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    invoke-direct {v0, v1}, Ljava/io/File;-><init>(Ljava/lang/String;)V

    return-object v0
.end method

.method private refreshLocked(Lcom/facebook/soloader/FileLocker;I[B)Z
    .locals 23
    .param p1, "lock"    # Lcom/facebook/soloader/FileLocker;
    .param p2, "flags"    # I
    .param p3, "deps"    # [B
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;
        }
    .end annotation

    .prologue
    .line 245
    new-instance v7, Ljava/io/File;

    move-object/from16 v0, p0

    iget-object v3, v0, Lcom/facebook/soloader/UnpackingSoSource;->soDirectory:Ljava/io/File;

    const-string v5, "dso_state"

    invoke-direct {v7, v3, v5}, Ljava/io/File;-><init>(Ljava/io/File;Ljava/lang/String;)V

    .line 247
    .local v7, "stateFileName":Ljava/io/File;
    new-instance v15, Ljava/io/RandomAccessFile;

    const-string v3, "rw"

    invoke-direct {v15, v7, v3}, Ljava/io/RandomAccessFile;-><init>(Ljava/io/File;Ljava/lang/String;)V

    .local v15, "stateFile":Ljava/io/RandomAccessFile;
    const/4 v5, 0x0

    .line 249
    :try_start_0
    invoke-virtual {v15}, Ljava/io/RandomAccessFile;->readByte()B

    move-result v14

    .line 250
    .local v14, "state":B
    const/4 v3, 0x1

    if-eq v14, v3, :cond_0

    .line 251
    const-string v3, "fb-UnpackingSoSource"

    new-instance v8, Ljava/lang/StringBuilder;

    invoke-direct {v8}, Ljava/lang/StringBuilder;-><init>()V

    const-string v18, "dso store "

    move-object/from16 v0, v18

    invoke-virtual {v8, v0}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v8

    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/facebook/soloader/UnpackingSoSource;->soDirectory:Ljava/io/File;

    move-object/from16 v18, v0

    move-object/from16 v0, v18

    invoke-virtual {v8, v0}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    move-result-object v8

    const-string v18, " regeneration interrupted: wiping clean"

    move-object/from16 v0, v18

    invoke-virtual {v8, v0}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v8

    invoke-virtual {v8}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v8

    invoke-static {v3, v8}, Landroid/util/Log;->v(Ljava/lang/String;Ljava/lang/String;)I
    :try_end_0
    .catch Ljava/io/EOFException; {:try_start_0 .. :try_end_0} :catch_0
    .catch Ljava/lang/Throwable; {:try_start_0 .. :try_end_0} :catch_2
    .catchall {:try_start_0 .. :try_end_0} :catchall_6

    .line 252
    const/4 v14, 0x0

    .line 257
    :cond_0
    :goto_0
    if-eqz v15, :cond_1

    if-eqz v5, :cond_7

    :try_start_1
    invoke-virtual {v15}, Ljava/io/RandomAccessFile;->close()V
    :try_end_1
    .catch Ljava/lang/Throwable; {:try_start_1 .. :try_end_1} :catch_1

    .line 259
    :cond_1
    :goto_1
    new-instance v4, Ljava/io/File;

    move-object/from16 v0, p0

    iget-object v3, v0, Lcom/facebook/soloader/UnpackingSoSource;->soDirectory:Ljava/io/File;

    const-string v5, "dso_deps"

    invoke-direct {v4, v3, v5}, Ljava/io/File;-><init>(Ljava/io/File;Ljava/lang/String;)V

    .line 260
    .local v4, "depsFileName":Ljava/io/File;
    const/4 v10, 0x0

    .line 261
    .local v10, "desiredManifest":Lcom/facebook/soloader/UnpackingSoSource$DsoManifest;
    new-instance v9, Ljava/io/RandomAccessFile;

    const-string v3, "rw"

    invoke-direct {v9, v4, v3}, Ljava/io/RandomAccessFile;-><init>(Ljava/io/File;Ljava/lang/String;)V

    .local v9, "depsFile":Ljava/io/RandomAccessFile;
    const/16 v18, 0x0

    .line 262
    :try_start_2
    invoke-virtual {v9}, Ljava/io/RandomAccessFile;->length()J

    move-result-wide v20

    move-wide/from16 v0, v20

    long-to-int v3, v0

    new-array v12, v3, [B

    .line 263
    .local v12, "existingDeps":[B
    invoke-virtual {v9, v12}, Ljava/io/RandomAccessFile;->read([B)I

    move-result v3

    array-length v5, v12

    if-eq v3, v5, :cond_2

    .line 264
    const-string v3, "fb-UnpackingSoSource"

    const-string v5, "short read of so store deps file: marking unclean"

    invoke-static {v3, v5}, Landroid/util/Log;->v(Ljava/lang/String;Ljava/lang/String;)I

    .line 265
    const/4 v14, 0x0

    .line 268
    :cond_2
    move-object/from16 v0, p3

    invoke-static {v12, v0}, Ljava/util/Arrays;->equals([B[B)Z

    move-result v3

    if-nez v3, :cond_3

    .line 269
    const-string v3, "fb-UnpackingSoSource"

    const-string v5, "deps mismatch on deps store: regenerating"

    invoke-static {v3, v5}, Landroid/util/Log;->v(Ljava/lang/String;Ljava/lang/String;)I

    .line 270
    const/4 v14, 0x0

    .line 273
    :cond_3
    if-nez v14, :cond_5

    .line 274
    const-string v3, "fb-UnpackingSoSource"

    const-string v5, "so store dirty: regenerating"

    invoke-static {v3, v5}, Landroid/util/Log;->v(Ljava/lang/String;Ljava/lang/String;)I

    .line 275
    const/4 v3, 0x0

    invoke-static {v7, v3}, Lcom/facebook/soloader/UnpackingSoSource;->writeState(Ljava/io/File;B)V

    .line 277
    invoke-virtual/range {p0 .. p0}, Lcom/facebook/soloader/UnpackingSoSource;->makeUnpacker()Lcom/facebook/soloader/UnpackingSoSource$Unpacker;
    :try_end_2
    .catch Ljava/lang/Throwable; {:try_start_2 .. :try_end_2} :catch_6
    .catchall {:try_start_2 .. :try_end_2} :catchall_5

    move-result-object v16

    .local v16, "u":Lcom/facebook/soloader/UnpackingSoSource$Unpacker;
    const/4 v8, 0x0

    .line 278
    :try_start_3
    invoke-virtual/range {v16 .. v16}, Lcom/facebook/soloader/UnpackingSoSource$Unpacker;->getDsoManifest()Lcom/facebook/soloader/UnpackingSoSource$DsoManifest;

    move-result-object v10

    .line 279
    invoke-virtual/range {v16 .. v16}, Lcom/facebook/soloader/UnpackingSoSource$Unpacker;->openDsoIterator()Lcom/facebook/soloader/UnpackingSoSource$InputDsoIterator;
    :try_end_3
    .catch Ljava/lang/Throwable; {:try_start_3 .. :try_end_3} :catch_5
    .catchall {:try_start_3 .. :try_end_3} :catchall_3

    move-result-object v13

    .local v13, "idi":Lcom/facebook/soloader/UnpackingSoSource$InputDsoIterator;
    const/4 v5, 0x0

    .line 280
    :try_start_4
    move-object/from16 v0, p0

    invoke-direct {v0, v14, v10, v13}, Lcom/facebook/soloader/UnpackingSoSource;->regenerate(BLcom/facebook/soloader/UnpackingSoSource$DsoManifest;Lcom/facebook/soloader/UnpackingSoSource$InputDsoIterator;)V
    :try_end_4
    .catch Ljava/lang/Throwable; {:try_start_4 .. :try_end_4} :catch_7
    .catchall {:try_start_4 .. :try_end_4} :catchall_4

    .line 281
    if-eqz v13, :cond_4

    if-eqz v5, :cond_c

    :try_start_5
    invoke-virtual {v13}, Lcom/facebook/soloader/UnpackingSoSource$InputDsoIterator;->close()V
    :try_end_5
    .catch Ljava/lang/Throwable; {:try_start_5 .. :try_end_5} :catch_4
    .catchall {:try_start_5 .. :try_end_5} :catchall_3

    .line 282
    :cond_4
    :goto_2
    if-eqz v16, :cond_5

    if-eqz v8, :cond_f

    :try_start_6
    invoke-virtual/range {v16 .. v16}, Lcom/facebook/soloader/UnpackingSoSource$Unpacker;->close()V
    :try_end_6
    .catch Ljava/lang/Throwable; {:try_start_6 .. :try_end_6} :catch_9
    .catchall {:try_start_6 .. :try_end_6} :catchall_5

    .line 284
    .end local v13    # "idi":Lcom/facebook/soloader/UnpackingSoSource$InputDsoIterator;
    .end local v16    # "u":Lcom/facebook/soloader/UnpackingSoSource$Unpacker;
    :cond_5
    :goto_3
    if-eqz v9, :cond_6

    if-eqz v18, :cond_11

    :try_start_7
    invoke-virtual {v9}, Ljava/io/RandomAccessFile;->close()V
    :try_end_7
    .catch Ljava/lang/Throwable; {:try_start_7 .. :try_end_7} :catch_b

    .line 286
    :cond_6
    :goto_4
    if-nez v10, :cond_13

    .line 287
    const/4 v3, 0x0

    .line 334
    :goto_5
    return v3

    .line 254
    .end local v4    # "depsFileName":Ljava/io/File;
    .end local v9    # "depsFile":Ljava/io/RandomAccessFile;
    .end local v10    # "desiredManifest":Lcom/facebook/soloader/UnpackingSoSource$DsoManifest;
    .end local v12    # "existingDeps":[B
    .end local v14    # "state":B
    :catch_0
    move-exception v11

    .line 255
    .local v11, "ex":Ljava/io/EOFException;
    const/4 v14, 0x0

    .restart local v14    # "state":B
    goto :goto_0

    .line 257
    .end local v11    # "ex":Ljava/io/EOFException;
    :catch_1
    move-exception v17

    .local v17, "x2":Ljava/lang/Throwable;
    move-object/from16 v0, v17

    invoke-virtual {v5, v0}, Ljava/lang/Throwable;->addSuppressed(Ljava/lang/Throwable;)V

    goto :goto_1

    .end local v17    # "x2":Ljava/lang/Throwable;
    :cond_7
    invoke-virtual {v15}, Ljava/io/RandomAccessFile;->close()V

    goto/16 :goto_1

    .line 247
    .end local v14    # "state":B
    :catch_2
    move-exception v3

    :try_start_8
    throw v3
    :try_end_8
    .catchall {:try_start_8 .. :try_end_8} :catchall_0

    .line 257
    :catchall_0
    move-exception v5

    move-object/from16 v22, v5

    move-object v5, v3

    move-object/from16 v3, v22

    :goto_6
    if-eqz v15, :cond_8

    if-eqz v5, :cond_9

    :try_start_9
    invoke-virtual {v15}, Ljava/io/RandomAccessFile;->close()V
    :try_end_9
    .catch Ljava/lang/Throwable; {:try_start_9 .. :try_end_9} :catch_3

    :cond_8
    :goto_7
    throw v3

    :catch_3
    move-exception v17

    .restart local v17    # "x2":Ljava/lang/Throwable;
    move-object/from16 v0, v17

    invoke-virtual {v5, v0}, Ljava/lang/Throwable;->addSuppressed(Ljava/lang/Throwable;)V

    goto :goto_7

    .end local v17    # "x2":Ljava/lang/Throwable;
    :cond_9
    invoke-virtual {v15}, Ljava/io/RandomAccessFile;->close()V

    goto :goto_7

    .line 281
    .restart local v4    # "depsFileName":Ljava/io/File;
    .restart local v9    # "depsFile":Ljava/io/RandomAccessFile;
    .restart local v10    # "desiredManifest":Lcom/facebook/soloader/UnpackingSoSource$DsoManifest;
    .restart local v12    # "existingDeps":[B
    .restart local v13    # "idi":Lcom/facebook/soloader/UnpackingSoSource$InputDsoIterator;
    .restart local v14    # "state":B
    .restart local v16    # "u":Lcom/facebook/soloader/UnpackingSoSource$Unpacker;
    :catch_4
    move-exception v17

    .restart local v17    # "x2":Ljava/lang/Throwable;
    :try_start_a
    move-object/from16 v0, v17

    invoke-virtual {v5, v0}, Ljava/lang/Throwable;->addSuppressed(Ljava/lang/Throwable;)V
    :try_end_a
    .catch Ljava/lang/Throwable; {:try_start_a .. :try_end_a} :catch_5
    .catchall {:try_start_a .. :try_end_a} :catchall_3

    goto :goto_2

    .line 277
    .end local v13    # "idi":Lcom/facebook/soloader/UnpackingSoSource$InputDsoIterator;
    .end local v17    # "x2":Ljava/lang/Throwable;
    :catch_5
    move-exception v3

    :try_start_b
    throw v3
    :try_end_b
    .catchall {:try_start_b .. :try_end_b} :catchall_1

    .line 282
    :catchall_1
    move-exception v5

    move-object/from16 v22, v5

    move-object v5, v3

    move-object/from16 v3, v22

    :goto_8
    if-eqz v16, :cond_a

    if-eqz v5, :cond_10

    :try_start_c
    invoke-virtual/range {v16 .. v16}, Lcom/facebook/soloader/UnpackingSoSource$Unpacker;->close()V
    :try_end_c
    .catch Ljava/lang/Throwable; {:try_start_c .. :try_end_c} :catch_a
    .catchall {:try_start_c .. :try_end_c} :catchall_5

    :cond_a
    :goto_9
    :try_start_d
    throw v3
    :try_end_d
    .catch Ljava/lang/Throwable; {:try_start_d .. :try_end_d} :catch_6
    .catchall {:try_start_d .. :try_end_d} :catchall_5

    .line 261
    .end local v12    # "existingDeps":[B
    .end local v16    # "u":Lcom/facebook/soloader/UnpackingSoSource$Unpacker;
    :catch_6
    move-exception v3

    :try_start_e
    throw v3
    :try_end_e
    .catchall {:try_start_e .. :try_end_e} :catchall_2

    .line 284
    :catchall_2
    move-exception v5

    move-object/from16 v22, v5

    move-object v5, v3

    move-object/from16 v3, v22

    :goto_a
    if-eqz v9, :cond_b

    if-eqz v5, :cond_12

    :try_start_f
    invoke-virtual {v9}, Ljava/io/RandomAccessFile;->close()V
    :try_end_f
    .catch Ljava/lang/Throwable; {:try_start_f .. :try_end_f} :catch_c

    :cond_b
    :goto_b
    throw v3

    .line 281
    .restart local v12    # "existingDeps":[B
    .restart local v13    # "idi":Lcom/facebook/soloader/UnpackingSoSource$InputDsoIterator;
    .restart local v16    # "u":Lcom/facebook/soloader/UnpackingSoSource$Unpacker;
    :cond_c
    :try_start_10
    invoke-virtual {v13}, Lcom/facebook/soloader/UnpackingSoSource$InputDsoIterator;->close()V
    :try_end_10
    .catch Ljava/lang/Throwable; {:try_start_10 .. :try_end_10} :catch_5
    .catchall {:try_start_10 .. :try_end_10} :catchall_3

    goto :goto_2

    .line 282
    .end local v13    # "idi":Lcom/facebook/soloader/UnpackingSoSource$InputDsoIterator;
    :catchall_3
    move-exception v3

    move-object v5, v8

    goto :goto_8

    .line 279
    .restart local v13    # "idi":Lcom/facebook/soloader/UnpackingSoSource$InputDsoIterator;
    :catch_7
    move-exception v5

    :try_start_11
    throw v5
    :try_end_11
    .catchall {:try_start_11 .. :try_end_11} :catchall_4

    .line 281
    :catchall_4
    move-exception v3

    if-eqz v13, :cond_d

    if-eqz v5, :cond_e

    :try_start_12
    invoke-virtual {v13}, Lcom/facebook/soloader/UnpackingSoSource$InputDsoIterator;->close()V
    :try_end_12
    .catch Ljava/lang/Throwable; {:try_start_12 .. :try_end_12} :catch_8
    .catchall {:try_start_12 .. :try_end_12} :catchall_3

    :cond_d
    :goto_c
    :try_start_13
    throw v3

    :catch_8
    move-exception v17

    .restart local v17    # "x2":Ljava/lang/Throwable;
    move-object/from16 v0, v17

    invoke-virtual {v5, v0}, Ljava/lang/Throwable;->addSuppressed(Ljava/lang/Throwable;)V

    goto :goto_c

    .end local v17    # "x2":Ljava/lang/Throwable;
    :cond_e
    invoke-virtual {v13}, Lcom/facebook/soloader/UnpackingSoSource$InputDsoIterator;->close()V
    :try_end_13
    .catch Ljava/lang/Throwable; {:try_start_13 .. :try_end_13} :catch_5
    .catchall {:try_start_13 .. :try_end_13} :catchall_3

    goto :goto_c

    .line 282
    :catch_9
    move-exception v17

    .restart local v17    # "x2":Ljava/lang/Throwable;
    :try_start_14
    move-object/from16 v0, v17

    invoke-virtual {v8, v0}, Ljava/lang/Throwable;->addSuppressed(Ljava/lang/Throwable;)V

    goto :goto_3

    .line 284
    .end local v12    # "existingDeps":[B
    .end local v13    # "idi":Lcom/facebook/soloader/UnpackingSoSource$InputDsoIterator;
    .end local v16    # "u":Lcom/facebook/soloader/UnpackingSoSource$Unpacker;
    .end local v17    # "x2":Ljava/lang/Throwable;
    :catchall_5
    move-exception v3

    move-object/from16 v5, v18

    goto :goto_a

    .line 282
    .restart local v12    # "existingDeps":[B
    .restart local v13    # "idi":Lcom/facebook/soloader/UnpackingSoSource$InputDsoIterator;
    .restart local v16    # "u":Lcom/facebook/soloader/UnpackingSoSource$Unpacker;
    :cond_f
    invoke-virtual/range {v16 .. v16}, Lcom/facebook/soloader/UnpackingSoSource$Unpacker;->close()V

    goto/16 :goto_3

    .end local v13    # "idi":Lcom/facebook/soloader/UnpackingSoSource$InputDsoIterator;
    :catch_a
    move-exception v17

    .restart local v17    # "x2":Ljava/lang/Throwable;
    move-object/from16 v0, v17

    invoke-virtual {v5, v0}, Ljava/lang/Throwable;->addSuppressed(Ljava/lang/Throwable;)V

    goto :goto_9

    .end local v17    # "x2":Ljava/lang/Throwable;
    :cond_10
    invoke-virtual/range {v16 .. v16}, Lcom/facebook/soloader/UnpackingSoSource$Unpacker;->close()V
    :try_end_14
    .catch Ljava/lang/Throwable; {:try_start_14 .. :try_end_14} :catch_6
    .catchall {:try_start_14 .. :try_end_14} :catchall_5

    goto :goto_9

    .line 284
    .end local v16    # "u":Lcom/facebook/soloader/UnpackingSoSource$Unpacker;
    :catch_b
    move-exception v17

    .restart local v17    # "x2":Ljava/lang/Throwable;
    move-object/from16 v0, v18

    move-object/from16 v1, v17

    invoke-virtual {v0, v1}, Ljava/lang/Throwable;->addSuppressed(Ljava/lang/Throwable;)V

    goto/16 :goto_4

    .end local v17    # "x2":Ljava/lang/Throwable;
    :cond_11
    invoke-virtual {v9}, Ljava/io/RandomAccessFile;->close()V

    goto/16 :goto_4

    .end local v12    # "existingDeps":[B
    :catch_c
    move-exception v17

    .restart local v17    # "x2":Ljava/lang/Throwable;
    move-object/from16 v0, v17

    invoke-virtual {v5, v0}, Ljava/lang/Throwable;->addSuppressed(Ljava/lang/Throwable;)V

    goto :goto_b

    .end local v17    # "x2":Ljava/lang/Throwable;
    :cond_12
    invoke-virtual {v9}, Ljava/io/RandomAccessFile;->close()V

    goto :goto_b

    .line 290
    .restart local v12    # "existingDeps":[B
    :cond_13
    move-object v6, v10

    .line 292
    .local v6, "manifest":Lcom/facebook/soloader/UnpackingSoSource$DsoManifest;
    new-instance v2, Lcom/facebook/soloader/UnpackingSoSource$1;

    move-object/from16 v3, p0

    move-object/from16 v5, p3

    move-object/from16 v8, p1

    invoke-direct/range {v2 .. v8}, Lcom/facebook/soloader/UnpackingSoSource$1;-><init>(Lcom/facebook/soloader/UnpackingSoSource;Ljava/io/File;[BLcom/facebook/soloader/UnpackingSoSource$DsoManifest;Ljava/io/File;Lcom/facebook/soloader/FileLocker;)V

    .line 328
    .local v2, "syncer":Ljava/lang/Runnable;
    and-int/lit8 v3, p2, 0x1

    if-eqz v3, :cond_14

    .line 329
    new-instance v3, Ljava/lang/Thread;

    new-instance v5, Ljava/lang/StringBuilder;

    invoke-direct {v5}, Ljava/lang/StringBuilder;-><init>()V

    const-string v8, "SoSync:"

    invoke-virtual {v5, v8}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v5

    move-object/from16 v0, p0

    iget-object v8, v0, Lcom/facebook/soloader/UnpackingSoSource;->soDirectory:Ljava/io/File;

    invoke-virtual {v8}, Ljava/io/File;->getName()Ljava/lang/String;

    move-result-object v8

    invoke-virtual {v5, v8}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v5

    invoke-virtual {v5}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v5

    invoke-direct {v3, v2, v5}, Ljava/lang/Thread;-><init>(Ljava/lang/Runnable;Ljava/lang/String;)V

    invoke-virtual {v3}, Ljava/lang/Thread;->start()V

    .line 334
    :goto_d
    const/4 v3, 0x1

    goto/16 :goto_5

    .line 331
    :cond_14
    invoke-interface {v2}, Ljava/lang/Runnable;->run()V

    goto :goto_d

    .line 257
    .end local v2    # "syncer":Ljava/lang/Runnable;
    .end local v4    # "depsFileName":Ljava/io/File;
    .end local v6    # "manifest":Lcom/facebook/soloader/UnpackingSoSource$DsoManifest;
    .end local v9    # "depsFile":Ljava/io/RandomAccessFile;
    .end local v10    # "desiredManifest":Lcom/facebook/soloader/UnpackingSoSource$DsoManifest;
    .end local v12    # "existingDeps":[B
    .end local v14    # "state":B
    :catchall_6
    move-exception v3

    goto/16 :goto_6
.end method

.method private regenerate(BLcom/facebook/soloader/UnpackingSoSource$DsoManifest;Lcom/facebook/soloader/UnpackingSoSource$InputDsoIterator;)V
    .locals 16
    .param p1, "state"    # B
    .param p2, "desiredManifest"    # Lcom/facebook/soloader/UnpackingSoSource$DsoManifest;
    .param p3, "dsoIterator"    # Lcom/facebook/soloader/UnpackingSoSource$InputDsoIterator;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;
        }
    .end annotation

    .prologue
    .line 206
    const-string v11, "fb-UnpackingSoSource"

    new-instance v12, Ljava/lang/StringBuilder;

    invoke-direct {v12}, Ljava/lang/StringBuilder;-><init>()V

    const-string v13, "regenerating DSO store "

    invoke-virtual {v12, v13}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v12

    invoke-virtual/range {p0 .. p0}, Ljava/lang/Object;->getClass()Ljava/lang/Class;

    move-result-object v13

    invoke-virtual {v13}, Ljava/lang/Class;->getName()Ljava/lang/String;

    move-result-object v13

    invoke-virtual {v12, v13}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v12

    invoke-virtual {v12}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v12

    invoke-static {v11, v12}, Landroid/util/Log;->v(Ljava/lang/String;Ljava/lang/String;)I

    .line 207
    new-instance v8, Ljava/io/File;

    move-object/from16 v0, p0

    iget-object v11, v0, Lcom/facebook/soloader/UnpackingSoSource;->soDirectory:Ljava/io/File;

    const-string v12, "dso_manifest"

    invoke-direct {v8, v11, v12}, Ljava/io/File;-><init>(Ljava/io/File;Ljava/lang/String;)V

    .line 208
    .local v8, "manifestFileName":Ljava/io/File;
    new-instance v7, Ljava/io/RandomAccessFile;

    const-string v11, "rw"

    invoke-direct {v7, v8, v11}, Ljava/io/RandomAccessFile;-><init>(Ljava/io/File;Ljava/lang/String;)V

    .local v7, "manifestFile":Ljava/io/RandomAccessFile;
    const/4 v13, 0x0

    .line 209
    const/4 v2, 0x0

    .line 210
    .local v2, "existingManifest":Lcom/facebook/soloader/UnpackingSoSource$DsoManifest;
    const/4 v11, 0x1

    move/from16 v0, p1

    if-ne v0, v11, :cond_2

    .line 212
    :try_start_0
    invoke-static {v7}, Lcom/facebook/soloader/UnpackingSoSource$DsoManifest;->read(Ljava/io/DataInput;)Lcom/facebook/soloader/UnpackingSoSource$DsoManifest;
    :try_end_0
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_0
    .catch Ljava/lang/Throwable; {:try_start_0 .. :try_end_0} :catch_2
    .catchall {:try_start_0 .. :try_end_0} :catchall_1

    move-result-object v2

    move-object v3, v2

    .line 218
    .end local v2    # "existingManifest":Lcom/facebook/soloader/UnpackingSoSource$DsoManifest;
    .local v3, "existingManifest":Lcom/facebook/soloader/UnpackingSoSource$DsoManifest;
    :goto_0
    if-nez v3, :cond_d

    .line 219
    :try_start_1
    new-instance v2, Lcom/facebook/soloader/UnpackingSoSource$DsoManifest;

    const/4 v11, 0x0

    new-array v11, v11, [Lcom/facebook/soloader/UnpackingSoSource$Dso;

    invoke-direct {v2, v11}, Lcom/facebook/soloader/UnpackingSoSource$DsoManifest;-><init>([Lcom/facebook/soloader/UnpackingSoSource$Dso;)V
    :try_end_1
    .catch Ljava/lang/Throwable; {:try_start_1 .. :try_end_1} :catch_7
    .catchall {:try_start_1 .. :try_end_1} :catchall_1

    .line 222
    .end local v3    # "existingManifest":Lcom/facebook/soloader/UnpackingSoSource$DsoManifest;
    .restart local v2    # "existingManifest":Lcom/facebook/soloader/UnpackingSoSource$DsoManifest;
    :goto_1
    :try_start_2
    move-object/from16 v0, p2

    iget-object v11, v0, Lcom/facebook/soloader/UnpackingSoSource$DsoManifest;->dsos:[Lcom/facebook/soloader/UnpackingSoSource$Dso;

    move-object/from16 v0, p0

    invoke-direct {v0, v11}, Lcom/facebook/soloader/UnpackingSoSource;->deleteUnmentionedFiles([Lcom/facebook/soloader/UnpackingSoSource$Dso;)V

    .line 223
    const v11, 0x8000

    new-array v6, v11, [B

    .line 224
    .local v6, "ioBuffer":[B
    :cond_0
    :goto_2
    invoke-virtual/range {p3 .. p3}, Lcom/facebook/soloader/UnpackingSoSource$InputDsoIterator;->hasNext()Z

    move-result v11

    if-eqz v11, :cond_9

    .line 225
    invoke-virtual/range {p3 .. p3}, Lcom/facebook/soloader/UnpackingSoSource$InputDsoIterator;->next()Lcom/facebook/soloader/UnpackingSoSource$InputDso;
    :try_end_2
    .catch Ljava/lang/Throwable; {:try_start_2 .. :try_end_2} :catch_2
    .catchall {:try_start_2 .. :try_end_2} :catchall_1

    move-result-object v5

    .local v5, "iDso":Lcom/facebook/soloader/UnpackingSoSource$InputDso;
    const/4 v12, 0x0

    .line 226
    const/4 v9, 0x1

    .line 227
    .local v9, "obsolete":Z
    const/4 v4, 0x0

    .local v4, "i":I
    :goto_3
    if-eqz v9, :cond_3

    :try_start_3
    iget-object v11, v2, Lcom/facebook/soloader/UnpackingSoSource$DsoManifest;->dsos:[Lcom/facebook/soloader/UnpackingSoSource$Dso;

    array-length v11, v11

    if-ge v4, v11, :cond_3

    .line 228
    iget-object v11, v2, Lcom/facebook/soloader/UnpackingSoSource$DsoManifest;->dsos:[Lcom/facebook/soloader/UnpackingSoSource$Dso;

    aget-object v11, v11, v4

    iget-object v11, v11, Lcom/facebook/soloader/UnpackingSoSource$Dso;->name:Ljava/lang/String;

    iget-object v14, v5, Lcom/facebook/soloader/UnpackingSoSource$InputDso;->dso:Lcom/facebook/soloader/UnpackingSoSource$Dso;

    iget-object v14, v14, Lcom/facebook/soloader/UnpackingSoSource$Dso;->name:Ljava/lang/String;

    invoke-virtual {v11, v14}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v11

    if-eqz v11, :cond_1

    iget-object v11, v2, Lcom/facebook/soloader/UnpackingSoSource$DsoManifest;->dsos:[Lcom/facebook/soloader/UnpackingSoSource$Dso;

    aget-object v11, v11, v4

    iget-object v11, v11, Lcom/facebook/soloader/UnpackingSoSource$Dso;->hash:Ljava/lang/String;

    iget-object v14, v5, Lcom/facebook/soloader/UnpackingSoSource$InputDso;->dso:Lcom/facebook/soloader/UnpackingSoSource$Dso;

    iget-object v14, v14, Lcom/facebook/soloader/UnpackingSoSource$Dso;->hash:Ljava/lang/String;

    invoke-virtual {v11, v14}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z
    :try_end_3
    .catch Ljava/lang/Throwable; {:try_start_3 .. :try_end_3} :catch_3
    .catchall {:try_start_3 .. :try_end_3} :catchall_3

    move-result v11

    if-eqz v11, :cond_1

    .line 230
    const/4 v9, 0x0

    .line 227
    :cond_1
    add-int/lit8 v4, v4, 0x1

    goto :goto_3

    .line 213
    .end local v4    # "i":I
    .end local v5    # "iDso":Lcom/facebook/soloader/UnpackingSoSource$InputDso;
    .end local v6    # "ioBuffer":[B
    .end local v9    # "obsolete":Z
    :catch_0
    move-exception v1

    .line 214
    .local v1, "ex":Ljava/lang/Exception;
    :try_start_4
    const-string v11, "fb-UnpackingSoSource"

    const-string v12, "error reading existing DSO manifest"

    invoke-static {v11, v12, v1}, Landroid/util/Log;->i(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)I
    :try_end_4
    .catch Ljava/lang/Throwable; {:try_start_4 .. :try_end_4} :catch_2
    .catchall {:try_start_4 .. :try_end_4} :catchall_1

    .end local v1    # "ex":Ljava/lang/Exception;
    :cond_2
    move-object v3, v2

    .end local v2    # "existingManifest":Lcom/facebook/soloader/UnpackingSoSource$DsoManifest;
    .restart local v3    # "existingManifest":Lcom/facebook/soloader/UnpackingSoSource$DsoManifest;
    goto :goto_0

    .line 233
    .end local v3    # "existingManifest":Lcom/facebook/soloader/UnpackingSoSource$DsoManifest;
    .restart local v2    # "existingManifest":Lcom/facebook/soloader/UnpackingSoSource$DsoManifest;
    .restart local v4    # "i":I
    .restart local v5    # "iDso":Lcom/facebook/soloader/UnpackingSoSource$InputDso;
    .restart local v6    # "ioBuffer":[B
    .restart local v9    # "obsolete":Z
    :cond_3
    if-eqz v9, :cond_4

    .line 234
    :try_start_5
    move-object/from16 v0, p0

    invoke-direct {v0, v5, v6}, Lcom/facebook/soloader/UnpackingSoSource;->extractDso(Lcom/facebook/soloader/UnpackingSoSource$InputDso;[B)V
    :try_end_5
    .catch Ljava/lang/Throwable; {:try_start_5 .. :try_end_5} :catch_3
    .catchall {:try_start_5 .. :try_end_5} :catchall_3

    .line 236
    :cond_4
    if-eqz v5, :cond_0

    if-eqz v12, :cond_6

    :try_start_6
    invoke-virtual {v5}, Lcom/facebook/soloader/UnpackingSoSource$InputDso;->close()V
    :try_end_6
    .catch Ljava/lang/Throwable; {:try_start_6 .. :try_end_6} :catch_1
    .catchall {:try_start_6 .. :try_end_6} :catchall_1

    goto :goto_2

    :catch_1
    move-exception v10

    .local v10, "x2":Ljava/lang/Throwable;
    :try_start_7
    invoke-virtual {v12, v10}, Ljava/lang/Throwable;->addSuppressed(Ljava/lang/Throwable;)V
    :try_end_7
    .catch Ljava/lang/Throwable; {:try_start_7 .. :try_end_7} :catch_2
    .catchall {:try_start_7 .. :try_end_7} :catchall_1

    goto :goto_2

    .line 208
    .end local v4    # "i":I
    .end local v5    # "iDso":Lcom/facebook/soloader/UnpackingSoSource$InputDso;
    .end local v6    # "ioBuffer":[B
    .end local v9    # "obsolete":Z
    .end local v10    # "x2":Ljava/lang/Throwable;
    :catch_2
    move-exception v11

    :goto_4
    :try_start_8
    throw v11
    :try_end_8
    .catchall {:try_start_8 .. :try_end_8} :catchall_0

    .line 238
    :catchall_0
    move-exception v12

    move-object v15, v12

    move-object v12, v11

    move-object v11, v15

    .end local v2    # "existingManifest":Lcom/facebook/soloader/UnpackingSoSource$DsoManifest;
    :goto_5
    if-eqz v7, :cond_5

    if-eqz v12, :cond_c

    :try_start_9
    invoke-virtual {v7}, Ljava/io/RandomAccessFile;->close()V
    :try_end_9
    .catch Ljava/lang/Throwable; {:try_start_9 .. :try_end_9} :catch_6

    :cond_5
    :goto_6
    throw v11

    .line 236
    .restart local v2    # "existingManifest":Lcom/facebook/soloader/UnpackingSoSource$DsoManifest;
    .restart local v4    # "i":I
    .restart local v5    # "iDso":Lcom/facebook/soloader/UnpackingSoSource$InputDso;
    .restart local v6    # "ioBuffer":[B
    .restart local v9    # "obsolete":Z
    :cond_6
    :try_start_a
    invoke-virtual {v5}, Lcom/facebook/soloader/UnpackingSoSource$InputDso;->close()V
    :try_end_a
    .catch Ljava/lang/Throwable; {:try_start_a .. :try_end_a} :catch_2
    .catchall {:try_start_a .. :try_end_a} :catchall_1

    goto :goto_2

    .line 238
    .end local v2    # "existingManifest":Lcom/facebook/soloader/UnpackingSoSource$DsoManifest;
    .end local v4    # "i":I
    .end local v5    # "iDso":Lcom/facebook/soloader/UnpackingSoSource$InputDso;
    .end local v6    # "ioBuffer":[B
    .end local v9    # "obsolete":Z
    :catchall_1
    move-exception v11

    move-object v12, v13

    goto :goto_5

    .line 225
    .restart local v2    # "existingManifest":Lcom/facebook/soloader/UnpackingSoSource$DsoManifest;
    .restart local v4    # "i":I
    .restart local v5    # "iDso":Lcom/facebook/soloader/UnpackingSoSource$InputDso;
    .restart local v6    # "ioBuffer":[B
    .restart local v9    # "obsolete":Z
    :catch_3
    move-exception v11

    :try_start_b
    throw v11
    :try_end_b
    .catchall {:try_start_b .. :try_end_b} :catchall_2

    .line 236
    :catchall_2
    move-exception v12

    move-object v15, v12

    move-object v12, v11

    move-object v11, v15

    :goto_7
    if-eqz v5, :cond_7

    if-eqz v12, :cond_8

    :try_start_c
    invoke-virtual {v5}, Lcom/facebook/soloader/UnpackingSoSource$InputDso;->close()V
    :try_end_c
    .catch Ljava/lang/Throwable; {:try_start_c .. :try_end_c} :catch_4
    .catchall {:try_start_c .. :try_end_c} :catchall_1

    :cond_7
    :goto_8
    :try_start_d
    throw v11

    :catch_4
    move-exception v10

    .restart local v10    # "x2":Ljava/lang/Throwable;
    invoke-virtual {v12, v10}, Ljava/lang/Throwable;->addSuppressed(Ljava/lang/Throwable;)V

    goto :goto_8

    .end local v10    # "x2":Ljava/lang/Throwable;
    :cond_8
    invoke-virtual {v5}, Lcom/facebook/soloader/UnpackingSoSource$InputDso;->close()V
    :try_end_d
    .catch Ljava/lang/Throwable; {:try_start_d .. :try_end_d} :catch_2
    .catchall {:try_start_d .. :try_end_d} :catchall_1

    goto :goto_8

    .line 238
    .end local v4    # "i":I
    .end local v5    # "iDso":Lcom/facebook/soloader/UnpackingSoSource$InputDso;
    .end local v9    # "obsolete":Z
    :cond_9
    if-eqz v7, :cond_a

    if-eqz v13, :cond_b

    :try_start_e
    invoke-virtual {v7}, Ljava/io/RandomAccessFile;->close()V
    :try_end_e
    .catch Ljava/lang/Throwable; {:try_start_e .. :try_end_e} :catch_5

    .line 239
    :cond_a
    :goto_9
    return-void

    .line 238
    :catch_5
    move-exception v10

    .restart local v10    # "x2":Ljava/lang/Throwable;
    invoke-virtual {v13, v10}, Ljava/lang/Throwable;->addSuppressed(Ljava/lang/Throwable;)V

    goto :goto_9

    .end local v10    # "x2":Ljava/lang/Throwable;
    :cond_b
    invoke-virtual {v7}, Ljava/io/RandomAccessFile;->close()V

    goto :goto_9

    .end local v2    # "existingManifest":Lcom/facebook/soloader/UnpackingSoSource$DsoManifest;
    .end local v6    # "ioBuffer":[B
    :catch_6
    move-exception v10

    .restart local v10    # "x2":Ljava/lang/Throwable;
    invoke-virtual {v12, v10}, Ljava/lang/Throwable;->addSuppressed(Ljava/lang/Throwable;)V

    goto :goto_6

    .end local v10    # "x2":Ljava/lang/Throwable;
    :cond_c
    invoke-virtual {v7}, Ljava/io/RandomAccessFile;->close()V

    goto :goto_6

    .line 208
    .restart local v3    # "existingManifest":Lcom/facebook/soloader/UnpackingSoSource$DsoManifest;
    :catch_7
    move-exception v11

    move-object v2, v3

    .end local v3    # "existingManifest":Lcom/facebook/soloader/UnpackingSoSource$DsoManifest;
    .restart local v2    # "existingManifest":Lcom/facebook/soloader/UnpackingSoSource$DsoManifest;
    goto :goto_4

    .line 236
    .restart local v4    # "i":I
    .restart local v5    # "iDso":Lcom/facebook/soloader/UnpackingSoSource$InputDso;
    .restart local v6    # "ioBuffer":[B
    .restart local v9    # "obsolete":Z
    :catchall_3
    move-exception v11

    goto :goto_7

    .end local v2    # "existingManifest":Lcom/facebook/soloader/UnpackingSoSource$DsoManifest;
    .end local v4    # "i":I
    .end local v5    # "iDso":Lcom/facebook/soloader/UnpackingSoSource$InputDso;
    .end local v6    # "ioBuffer":[B
    .end local v9    # "obsolete":Z
    .restart local v3    # "existingManifest":Lcom/facebook/soloader/UnpackingSoSource$DsoManifest;
    :cond_d
    move-object v2, v3

    .end local v3    # "existingManifest":Lcom/facebook/soloader/UnpackingSoSource$DsoManifest;
    .restart local v2    # "existingManifest":Lcom/facebook/soloader/UnpackingSoSource$DsoManifest;
    goto/16 :goto_1
.end method

.method private static writeState(Ljava/io/File;B)V
    .locals 7
    .param p0, "stateFileName"    # Ljava/io/File;
    .param p1, "state"    # B
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;
        }
    .end annotation

    .prologue
    .line 133
    new-instance v0, Ljava/io/RandomAccessFile;

    const-string v2, "rw"

    invoke-direct {v0, p0, v2}, Ljava/io/RandomAccessFile;-><init>(Ljava/io/File;Ljava/lang/String;)V

    .local v0, "stateFile":Ljava/io/RandomAccessFile;
    const/4 v3, 0x0

    .line 134
    const-wide/16 v4, 0x0

    :try_start_0
    invoke-virtual {v0, v4, v5}, Ljava/io/RandomAccessFile;->seek(J)V

    .line 135
    invoke-virtual {v0, p1}, Ljava/io/RandomAccessFile;->write(I)V

    .line 136
    invoke-virtual {v0}, Ljava/io/RandomAccessFile;->getFilePointer()J

    move-result-wide v4

    invoke-virtual {v0, v4, v5}, Ljava/io/RandomAccessFile;->setLength(J)V

    .line 137
    invoke-virtual {v0}, Ljava/io/RandomAccessFile;->getFD()Ljava/io/FileDescriptor;

    move-result-object v2

    invoke-virtual {v2}, Ljava/io/FileDescriptor;->sync()V
    :try_end_0
    .catch Ljava/lang/Throwable; {:try_start_0 .. :try_end_0} :catch_1
    .catchall {:try_start_0 .. :try_end_0} :catchall_1

    .line 138
    if-eqz v0, :cond_0

    if-eqz v3, :cond_1

    :try_start_1
    invoke-virtual {v0}, Ljava/io/RandomAccessFile;->close()V
    :try_end_1
    .catch Ljava/lang/Throwable; {:try_start_1 .. :try_end_1} :catch_0

    .line 139
    :cond_0
    :goto_0
    return-void

    .line 138
    :catch_0
    move-exception v1

    .local v1, "x2":Ljava/lang/Throwable;
    invoke-virtual {v3, v1}, Ljava/lang/Throwable;->addSuppressed(Ljava/lang/Throwable;)V

    goto :goto_0

    .end local v1    # "x2":Ljava/lang/Throwable;
    :cond_1
    invoke-virtual {v0}, Ljava/io/RandomAccessFile;->close()V

    goto :goto_0

    .line 133
    :catch_1
    move-exception v2

    :try_start_2
    throw v2
    :try_end_2
    .catchall {:try_start_2 .. :try_end_2} :catchall_0

    .line 138
    :catchall_0
    move-exception v3

    move-object v6, v3

    move-object v3, v2

    move-object v2, v6

    :goto_1
    if-eqz v0, :cond_2

    if-eqz v3, :cond_3

    :try_start_3
    invoke-virtual {v0}, Ljava/io/RandomAccessFile;->close()V
    :try_end_3
    .catch Ljava/lang/Throwable; {:try_start_3 .. :try_end_3} :catch_2

    :cond_2
    :goto_2
    throw v2

    :catch_2
    move-exception v1

    .restart local v1    # "x2":Ljava/lang/Throwable;
    invoke-virtual {v3, v1}, Ljava/lang/Throwable;->addSuppressed(Ljava/lang/Throwable;)V

    goto :goto_2

    .end local v1    # "x2":Ljava/lang/Throwable;
    :cond_3
    invoke-virtual {v0}, Ljava/io/RandomAccessFile;->close()V

    goto :goto_2

    :catchall_1
    move-exception v2

    goto :goto_1
.end method


# virtual methods
.method protected getDepsBlock()[B
    .locals 9
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;
        }
    .end annotation

    .prologue
    .line 349
    invoke-static {}, Landroid/os/Parcel;->obtain()Landroid/os/Parcel;

    move-result-object v3

    .line 350
    .local v3, "parcel":Landroid/os/Parcel;
    invoke-virtual {p0}, Lcom/facebook/soloader/UnpackingSoSource;->makeUnpacker()Lcom/facebook/soloader/UnpackingSoSource$Unpacker;

    move-result-object v4

    .local v4, "u":Lcom/facebook/soloader/UnpackingSoSource$Unpacker;
    const/4 v7, 0x0

    .line 351
    :try_start_0
    invoke-virtual {v4}, Lcom/facebook/soloader/UnpackingSoSource$Unpacker;->getDsoManifest()Lcom/facebook/soloader/UnpackingSoSource$DsoManifest;

    move-result-object v6

    iget-object v1, v6, Lcom/facebook/soloader/UnpackingSoSource$DsoManifest;->dsos:[Lcom/facebook/soloader/UnpackingSoSource$Dso;

    .line 352
    .local v1, "dsos":[Lcom/facebook/soloader/UnpackingSoSource$Dso;
    const/4 v6, 0x1

    invoke-virtual {v3, v6}, Landroid/os/Parcel;->writeByte(B)V

    .line 353
    array-length v6, v1

    invoke-virtual {v3, v6}, Landroid/os/Parcel;->writeInt(I)V

    .line 354
    const/4 v2, 0x0

    .local v2, "i":I
    :goto_0
    array-length v6, v1

    if-ge v2, v6, :cond_0

    .line 355
    aget-object v6, v1, v2

    iget-object v6, v6, Lcom/facebook/soloader/UnpackingSoSource$Dso;->name:Ljava/lang/String;

    invoke-virtual {v3, v6}, Landroid/os/Parcel;->writeString(Ljava/lang/String;)V

    .line 356
    aget-object v6, v1, v2

    iget-object v6, v6, Lcom/facebook/soloader/UnpackingSoSource$Dso;->hash:Ljava/lang/String;

    invoke-virtual {v3, v6}, Landroid/os/Parcel;->writeString(Ljava/lang/String;)V
    :try_end_0
    .catch Ljava/lang/Throwable; {:try_start_0 .. :try_end_0} :catch_1
    .catchall {:try_start_0 .. :try_end_0} :catchall_1

    .line 354
    add-int/lit8 v2, v2, 0x1

    goto :goto_0

    .line 358
    :cond_0
    if-eqz v4, :cond_1

    if-eqz v7, :cond_2

    :try_start_1
    invoke-virtual {v4}, Lcom/facebook/soloader/UnpackingSoSource$Unpacker;->close()V
    :try_end_1
    .catch Ljava/lang/Throwable; {:try_start_1 .. :try_end_1} :catch_0

    .line 359
    :cond_1
    :goto_1
    invoke-virtual {v3}, Landroid/os/Parcel;->marshall()[B

    move-result-object v0

    .line 360
    .local v0, "depsBlock":[B
    invoke-virtual {v3}, Landroid/os/Parcel;->recycle()V

    .line 361
    return-object v0

    .line 358
    .end local v0    # "depsBlock":[B
    :catch_0
    move-exception v5

    .local v5, "x2":Ljava/lang/Throwable;
    invoke-virtual {v7, v5}, Ljava/lang/Throwable;->addSuppressed(Ljava/lang/Throwable;)V

    goto :goto_1

    .end local v5    # "x2":Ljava/lang/Throwable;
    :cond_2
    invoke-virtual {v4}, Lcom/facebook/soloader/UnpackingSoSource$Unpacker;->close()V

    goto :goto_1

    .line 350
    .end local v1    # "dsos":[Lcom/facebook/soloader/UnpackingSoSource$Dso;
    .end local v2    # "i":I
    :catch_1
    move-exception v6

    :try_start_2
    throw v6
    :try_end_2
    .catchall {:try_start_2 .. :try_end_2} :catchall_0

    .line 358
    :catchall_0
    move-exception v7

    move-object v8, v7

    move-object v7, v6

    move-object v6, v8

    :goto_2
    if-eqz v4, :cond_3

    if-eqz v7, :cond_4

    :try_start_3
    invoke-virtual {v4}, Lcom/facebook/soloader/UnpackingSoSource$Unpacker;->close()V
    :try_end_3
    .catch Ljava/lang/Throwable; {:try_start_3 .. :try_end_3} :catch_2

    :cond_3
    :goto_3
    throw v6

    :catch_2
    move-exception v5

    .restart local v5    # "x2":Ljava/lang/Throwable;
    invoke-virtual {v7, v5}, Ljava/lang/Throwable;->addSuppressed(Ljava/lang/Throwable;)V

    goto :goto_3

    .end local v5    # "x2":Ljava/lang/Throwable;
    :cond_4
    invoke-virtual {v4}, Lcom/facebook/soloader/UnpackingSoSource$Unpacker;->close()V

    goto :goto_3

    :catchall_1
    move-exception v6

    goto :goto_2
.end method

.method protected abstract makeUnpacker()Lcom/facebook/soloader/UnpackingSoSource$Unpacker;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;
        }
    .end annotation
.end method

.method protected prepare(I)V
    .locals 6
    .param p1, "flags"    # I
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;
        }
    .end annotation

    .prologue
    .line 369
    iget-object v2, p0, Lcom/facebook/soloader/UnpackingSoSource;->soDirectory:Ljava/io/File;

    invoke-static {v2}, Lcom/facebook/soloader/SysUtil;->mkdirOrThrow(Ljava/io/File;)V

    .line 370
    new-instance v1, Ljava/io/File;

    iget-object v2, p0, Lcom/facebook/soloader/UnpackingSoSource;->soDirectory:Ljava/io/File;

    const-string v3, "dso_lock"

    invoke-direct {v1, v2, v3}, Ljava/io/File;-><init>(Ljava/io/File;Ljava/lang/String;)V

    .line 371
    .local v1, "lockFileName":Ljava/io/File;
    invoke-static {v1}, Lcom/facebook/soloader/FileLocker;->lock(Ljava/io/File;)Lcom/facebook/soloader/FileLocker;

    move-result-object v0

    .line 373
    .local v0, "lock":Lcom/facebook/soloader/FileLocker;
    :try_start_0
    const-string v2, "fb-UnpackingSoSource"

    new-instance v3, Ljava/lang/StringBuilder;

    invoke-direct {v3}, Ljava/lang/StringBuilder;-><init>()V

    const-string v4, "locked dso store "

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    iget-object v4, p0, Lcom/facebook/soloader/UnpackingSoSource;->soDirectory:Ljava/io/File;

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    move-result-object v3

    invoke-virtual {v3}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v3

    invoke-static {v2, v3}, Landroid/util/Log;->v(Ljava/lang/String;Ljava/lang/String;)I

    .line 374
    invoke-virtual {p0}, Lcom/facebook/soloader/UnpackingSoSource;->getDepsBlock()[B

    move-result-object v2

    invoke-direct {p0, v0, p1, v2}, Lcom/facebook/soloader/UnpackingSoSource;->refreshLocked(Lcom/facebook/soloader/FileLocker;I[B)Z
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    move-result v2

    if-eqz v2, :cond_0

    .line 375
    const/4 v0, 0x0

    .line 380
    :goto_0
    if-eqz v0, :cond_1

    .line 381
    const-string v2, "fb-UnpackingSoSource"

    new-instance v3, Ljava/lang/StringBuilder;

    invoke-direct {v3}, Ljava/lang/StringBuilder;-><init>()V

    const-string v4, "releasing dso store lock for "

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    iget-object v4, p0, Lcom/facebook/soloader/UnpackingSoSource;->soDirectory:Ljava/io/File;

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    move-result-object v3

    invoke-virtual {v3}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v3

    invoke-static {v2, v3}, Landroid/util/Log;->v(Ljava/lang/String;Ljava/lang/String;)I

    .line 382
    invoke-virtual {v0}, Lcom/facebook/soloader/FileLocker;->close()V

    .line 388
    :goto_1
    return-void

    .line 377
    :cond_0
    :try_start_1
    const-string v2, "fb-UnpackingSoSource"

    new-instance v3, Ljava/lang/StringBuilder;

    invoke-direct {v3}, Ljava/lang/StringBuilder;-><init>()V

    const-string v4, "dso store is up-to-date: "

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    iget-object v4, p0, Lcom/facebook/soloader/UnpackingSoSource;->soDirectory:Ljava/io/File;

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    move-result-object v3

    invoke-virtual {v3}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v3

    invoke-static {v2, v3}, Landroid/util/Log;->i(Ljava/lang/String;Ljava/lang/String;)I
    :try_end_1
    .catchall {:try_start_1 .. :try_end_1} :catchall_0

    goto :goto_0

    .line 380
    :catchall_0
    move-exception v2

    if-eqz v0, :cond_2

    .line 381
    const-string v3, "fb-UnpackingSoSource"

    new-instance v4, Ljava/lang/StringBuilder;

    invoke-direct {v4}, Ljava/lang/StringBuilder;-><init>()V

    const-string v5, "releasing dso store lock for "

    invoke-virtual {v4, v5}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v4

    iget-object v5, p0, Lcom/facebook/soloader/UnpackingSoSource;->soDirectory:Ljava/io/File;

    invoke-virtual {v4, v5}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    move-result-object v4

    invoke-virtual {v4}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v4

    invoke-static {v3, v4}, Landroid/util/Log;->v(Ljava/lang/String;Ljava/lang/String;)I

    .line 382
    invoke-virtual {v0}, Lcom/facebook/soloader/FileLocker;->close()V

    .line 384
    :goto_2
    throw v2

    :cond_1
    const-string v2, "fb-UnpackingSoSource"

    new-instance v3, Ljava/lang/StringBuilder;

    invoke-direct {v3}, Ljava/lang/StringBuilder;-><init>()V

    const-string v4, "not releasing dso store lock for "

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    iget-object v4, p0, Lcom/facebook/soloader/UnpackingSoSource;->soDirectory:Ljava/io/File;

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    move-result-object v3

    const-string v4, " (syncer thread started)"

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    invoke-virtual {v3}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v3

    invoke-static {v2, v3}, Landroid/util/Log;->v(Ljava/lang/String;Ljava/lang/String;)I

    goto :goto_1

    :cond_2
    const-string v3, "fb-UnpackingSoSource"

    new-instance v4, Ljava/lang/StringBuilder;

    invoke-direct {v4}, Ljava/lang/StringBuilder;-><init>()V

    const-string v5, "not releasing dso store lock for "

    invoke-virtual {v4, v5}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v4

    iget-object v5, p0, Lcom/facebook/soloader/UnpackingSoSource;->soDirectory:Ljava/io/File;

    invoke-virtual {v4, v5}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    move-result-object v4

    const-string v5, " (syncer thread started)"

    invoke-virtual {v4, v5}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v4

    invoke-virtual {v4}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v4

    invoke-static {v3, v4}, Landroid/util/Log;->v(Ljava/lang/String;Ljava/lang/String;)I

    goto :goto_2
.end method

.class Lcom/facebook/cache/disk/DefaultDiskStorage$InserterImpl;
.super Ljava/lang/Object;
.source "DefaultDiskStorage.java"

# interfaces
.implements Lcom/facebook/cache/disk/DiskStorage$Inserter;


# annotations
.annotation build Lcom/facebook/common/internal/VisibleForTesting;
.end annotation

.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/facebook/cache/disk/DefaultDiskStorage;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = "InserterImpl"
.end annotation


# instance fields
.field private final mResourceId:Ljava/lang/String;

.field final mTemporaryFile:Ljava/io/File;
    .annotation build Lcom/facebook/common/internal/VisibleForTesting;
    .end annotation
.end field

.field final synthetic this$0:Lcom/facebook/cache/disk/DefaultDiskStorage;


# direct methods
.method public constructor <init>(Lcom/facebook/cache/disk/DefaultDiskStorage;Ljava/lang/String;Ljava/io/File;)V
    .locals 0
    .param p1, "this$0"    # Lcom/facebook/cache/disk/DefaultDiskStorage;
    .param p2, "resourceId"    # Ljava/lang/String;
    .param p3, "temporaryFile"    # Ljava/io/File;

    .prologue
    .line 656
    iput-object p1, p0, Lcom/facebook/cache/disk/DefaultDiskStorage$InserterImpl;->this$0:Lcom/facebook/cache/disk/DefaultDiskStorage;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 657
    iput-object p2, p0, Lcom/facebook/cache/disk/DefaultDiskStorage$InserterImpl;->mResourceId:Ljava/lang/String;

    .line 658
    iput-object p3, p0, Lcom/facebook/cache/disk/DefaultDiskStorage$InserterImpl;->mTemporaryFile:Ljava/io/File;

    .line 659
    return-void
.end method


# virtual methods
.method public cleanUp()Z
    .locals 1

    .prologue
    .line 731
    iget-object v0, p0, Lcom/facebook/cache/disk/DefaultDiskStorage$InserterImpl;->mTemporaryFile:Ljava/io/File;

    invoke-virtual {v0}, Ljava/io/File;->exists()Z

    move-result v0

    if-eqz v0, :cond_0

    iget-object v0, p0, Lcom/facebook/cache/disk/DefaultDiskStorage$InserterImpl;->mTemporaryFile:Ljava/io/File;

    invoke-virtual {v0}, Ljava/io/File;->delete()Z

    move-result v0

    if-eqz v0, :cond_1

    :cond_0
    const/4 v0, 0x1

    :goto_0
    return v0

    :cond_1
    const/4 v0, 0x0

    goto :goto_0
.end method

.method public commit(Ljava/lang/Object;)Lcom/facebook/binaryresource/BinaryResource;
    .locals 7
    .param p1, "debugInfo"    # Ljava/lang/Object;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;
        }
    .end annotation

    .prologue
    .line 699
    iget-object v4, p0, Lcom/facebook/cache/disk/DefaultDiskStorage$InserterImpl;->this$0:Lcom/facebook/cache/disk/DefaultDiskStorage;

    iget-object v5, p0, Lcom/facebook/cache/disk/DefaultDiskStorage$InserterImpl;->mResourceId:Ljava/lang/String;

    invoke-virtual {v4, v5}, Lcom/facebook/cache/disk/DefaultDiskStorage;->getContentFileFor(Ljava/lang/String;)Ljava/io/File;

    move-result-object v3

    .line 702
    .local v3, "targetFile":Ljava/io/File;
    :try_start_0
    iget-object v4, p0, Lcom/facebook/cache/disk/DefaultDiskStorage$InserterImpl;->mTemporaryFile:Ljava/io/File;

    invoke-static {v4, v3}, Lcom/facebook/common/file/FileUtils;->rename(Ljava/io/File;Ljava/io/File;)V
    :try_end_0
    .catch Lcom/facebook/common/file/FileUtils$RenameException; {:try_start_0 .. :try_end_0} :catch_0

    .line 723
    invoke-virtual {v3}, Ljava/io/File;->exists()Z

    move-result v4

    if-eqz v4, :cond_0

    .line 724
    iget-object v4, p0, Lcom/facebook/cache/disk/DefaultDiskStorage$InserterImpl;->this$0:Lcom/facebook/cache/disk/DefaultDiskStorage;

    invoke-static {v4}, Lcom/facebook/cache/disk/DefaultDiskStorage;->access$400(Lcom/facebook/cache/disk/DefaultDiskStorage;)Lcom/facebook/common/time/Clock;

    move-result-object v4

    invoke-interface {v4}, Lcom/facebook/common/time/Clock;->now()J

    move-result-wide v4

    invoke-virtual {v3, v4, v5}, Ljava/io/File;->setLastModified(J)Z

    .line 726
    :cond_0
    invoke-static {v3}, Lcom/facebook/binaryresource/FileBinaryResource;->createOrNull(Ljava/io/File;)Lcom/facebook/binaryresource/FileBinaryResource;

    move-result-object v4

    return-object v4

    .line 703
    :catch_0
    move-exception v2

    .line 705
    .local v2, "re":Lcom/facebook/common/file/FileUtils$RenameException;
    invoke-virtual {v2}, Lcom/facebook/common/file/FileUtils$RenameException;->getCause()Ljava/lang/Throwable;

    move-result-object v1

    .line 706
    .local v1, "cause":Ljava/lang/Throwable;
    if-nez v1, :cond_1

    .line 707
    sget-object v0, Lcom/facebook/cache/common/CacheErrorLogger$CacheErrorCategory;->WRITE_RENAME_FILE_OTHER:Lcom/facebook/cache/common/CacheErrorLogger$CacheErrorCategory;

    .line 716
    .local v0, "category":Lcom/facebook/cache/common/CacheErrorLogger$CacheErrorCategory;
    :goto_0
    iget-object v4, p0, Lcom/facebook/cache/disk/DefaultDiskStorage$InserterImpl;->this$0:Lcom/facebook/cache/disk/DefaultDiskStorage;

    invoke-static {v4}, Lcom/facebook/cache/disk/DefaultDiskStorage;->access$900(Lcom/facebook/cache/disk/DefaultDiskStorage;)Lcom/facebook/cache/common/CacheErrorLogger;

    move-result-object v4

    .line 718
    invoke-static {}, Lcom/facebook/cache/disk/DefaultDiskStorage;->access$800()Ljava/lang/Class;

    move-result-object v5

    const-string v6, "commit"

    .line 716
    invoke-interface {v4, v0, v5, v6, v2}, Lcom/facebook/cache/common/CacheErrorLogger;->logError(Lcom/facebook/cache/common/CacheErrorLogger$CacheErrorCategory;Ljava/lang/Class;Ljava/lang/String;Ljava/lang/Throwable;)V

    .line 721
    throw v2

    .line 708
    .end local v0    # "category":Lcom/facebook/cache/common/CacheErrorLogger$CacheErrorCategory;
    :cond_1
    instance-of v4, v1, Lcom/facebook/common/file/FileUtils$ParentDirNotFoundException;

    if-eqz v4, :cond_2

    .line 709
    sget-object v0, Lcom/facebook/cache/common/CacheErrorLogger$CacheErrorCategory;->WRITE_RENAME_FILE_TEMPFILE_PARENT_NOT_FOUND:Lcom/facebook/cache/common/CacheErrorLogger$CacheErrorCategory;

    .restart local v0    # "category":Lcom/facebook/cache/common/CacheErrorLogger$CacheErrorCategory;
    goto :goto_0

    .line 711
    .end local v0    # "category":Lcom/facebook/cache/common/CacheErrorLogger$CacheErrorCategory;
    :cond_2
    instance-of v4, v1, Ljava/io/FileNotFoundException;

    if-eqz v4, :cond_3

    .line 712
    sget-object v0, Lcom/facebook/cache/common/CacheErrorLogger$CacheErrorCategory;->WRITE_RENAME_FILE_TEMPFILE_NOT_FOUND:Lcom/facebook/cache/common/CacheErrorLogger$CacheErrorCategory;

    .restart local v0    # "category":Lcom/facebook/cache/common/CacheErrorLogger$CacheErrorCategory;
    goto :goto_0

    .line 714
    .end local v0    # "category":Lcom/facebook/cache/common/CacheErrorLogger$CacheErrorCategory;
    :cond_3
    sget-object v0, Lcom/facebook/cache/common/CacheErrorLogger$CacheErrorCategory;->WRITE_RENAME_FILE_OTHER:Lcom/facebook/cache/common/CacheErrorLogger$CacheErrorCategory;

    .restart local v0    # "category":Lcom/facebook/cache/common/CacheErrorLogger$CacheErrorCategory;
    goto :goto_0
.end method

.method public writeData(Lcom/facebook/cache/common/WriterCallback;Ljava/lang/Object;)V
    .locals 9
    .param p1, "callback"    # Lcom/facebook/cache/common/WriterCallback;
    .param p2, "debugInfo"    # Ljava/lang/Object;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;
        }
    .end annotation

    .prologue
    .line 665
    :try_start_0
    new-instance v1, Ljava/io/FileOutputStream;

    iget-object v3, p0, Lcom/facebook/cache/disk/DefaultDiskStorage$InserterImpl;->mTemporaryFile:Ljava/io/File;

    invoke-direct {v1, v3}, Ljava/io/FileOutputStream;-><init>(Ljava/io/File;)V
    :try_end_0
    .catch Ljava/io/FileNotFoundException; {:try_start_0 .. :try_end_0} :catch_0

    .line 677
    .local v1, "fileStream":Ljava/io/FileOutputStream;
    :try_start_1
    new-instance v0, Lcom/facebook/common/internal/CountingOutputStream;

    invoke-direct {v0, v1}, Lcom/facebook/common/internal/CountingOutputStream;-><init>(Ljava/io/OutputStream;)V

    .line 678
    .local v0, "countingStream":Lcom/facebook/common/internal/CountingOutputStream;
    invoke-interface {p1, v0}, Lcom/facebook/cache/common/WriterCallback;->write(Ljava/io/OutputStream;)V

    .line 681
    invoke-virtual {v0}, Lcom/facebook/common/internal/CountingOutputStream;->flush()V

    .line 682
    invoke-virtual {v0}, Lcom/facebook/common/internal/CountingOutputStream;->getCount()J
    :try_end_1
    .catchall {:try_start_1 .. :try_end_1} :catchall_0

    move-result-wide v4

    .line 687
    .local v4, "length":J
    invoke-virtual {v1}, Ljava/io/FileOutputStream;->close()V

    .line 691
    iget-object v3, p0, Lcom/facebook/cache/disk/DefaultDiskStorage$InserterImpl;->mTemporaryFile:Ljava/io/File;

    invoke-virtual {v3}, Ljava/io/File;->length()J

    move-result-wide v6

    cmp-long v3, v6, v4

    if-eqz v3, :cond_0

    .line 692
    new-instance v3, Lcom/facebook/cache/disk/DefaultDiskStorage$IncompleteFileException;

    iget-object v6, p0, Lcom/facebook/cache/disk/DefaultDiskStorage$InserterImpl;->mTemporaryFile:Ljava/io/File;

    invoke-virtual {v6}, Ljava/io/File;->length()J

    move-result-wide v6

    invoke-direct {v3, v4, v5, v6, v7}, Lcom/facebook/cache/disk/DefaultDiskStorage$IncompleteFileException;-><init>(JJ)V

    throw v3

    .line 666
    .end local v0    # "countingStream":Lcom/facebook/common/internal/CountingOutputStream;
    .end local v1    # "fileStream":Ljava/io/FileOutputStream;
    .end local v4    # "length":J
    :catch_0
    move-exception v2

    .line 667
    .local v2, "fne":Ljava/io/FileNotFoundException;
    iget-object v3, p0, Lcom/facebook/cache/disk/DefaultDiskStorage$InserterImpl;->this$0:Lcom/facebook/cache/disk/DefaultDiskStorage;

    invoke-static {v3}, Lcom/facebook/cache/disk/DefaultDiskStorage;->access$900(Lcom/facebook/cache/disk/DefaultDiskStorage;)Lcom/facebook/cache/common/CacheErrorLogger;

    move-result-object v3

    sget-object v6, Lcom/facebook/cache/common/CacheErrorLogger$CacheErrorCategory;->WRITE_UPDATE_FILE_NOT_FOUND:Lcom/facebook/cache/common/CacheErrorLogger$CacheErrorCategory;

    .line 669
    invoke-static {}, Lcom/facebook/cache/disk/DefaultDiskStorage;->access$800()Ljava/lang/Class;

    move-result-object v7

    const-string v8, "updateResource"

    .line 667
    invoke-interface {v3, v6, v7, v8, v2}, Lcom/facebook/cache/common/CacheErrorLogger;->logError(Lcom/facebook/cache/common/CacheErrorLogger$CacheErrorCategory;Ljava/lang/Class;Ljava/lang/String;Ljava/lang/Throwable;)V

    .line 672
    throw v2

    .line 687
    .end local v2    # "fne":Ljava/io/FileNotFoundException;
    .restart local v1    # "fileStream":Ljava/io/FileOutputStream;
    :catchall_0
    move-exception v3

    invoke-virtual {v1}, Ljava/io/FileOutputStream;->close()V

    throw v3

    .line 694
    .restart local v0    # "countingStream":Lcom/facebook/common/internal/CountingOutputStream;
    .restart local v4    # "length":J
    :cond_0
    return-void
.end method

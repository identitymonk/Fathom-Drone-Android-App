.class Lcom/facebook/cache/disk/DiskStorageCache$1;
.super Ljava/lang/Object;
.source "DiskStorageCache.java"

# interfaces
.implements Ljava/lang/Runnable;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/facebook/cache/disk/DiskStorageCache;-><init>(Lcom/facebook/cache/disk/DiskStorage;Lcom/facebook/cache/disk/EntryEvictionComparatorSupplier;Lcom/facebook/cache/disk/DiskStorageCache$Params;Lcom/facebook/cache/common/CacheEventListener;Lcom/facebook/cache/common/CacheErrorLogger;Lcom/facebook/common/disk/DiskTrimmableRegistry;Landroid/content/Context;Ljava/util/concurrent/Executor;Z)V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$0:Lcom/facebook/cache/disk/DiskStorageCache;


# direct methods
.method constructor <init>(Lcom/facebook/cache/disk/DiskStorageCache;)V
    .locals 0
    .param p1, "this$0"    # Lcom/facebook/cache/disk/DiskStorageCache;

    .prologue
    .line 194
    iput-object p1, p0, Lcom/facebook/cache/disk/DiskStorageCache$1;->this$0:Lcom/facebook/cache/disk/DiskStorageCache;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public run()V
    .locals 2

    .prologue
    .line 198
    iget-object v0, p0, Lcom/facebook/cache/disk/DiskStorageCache$1;->this$0:Lcom/facebook/cache/disk/DiskStorageCache;

    invoke-static {v0}, Lcom/facebook/cache/disk/DiskStorageCache;->access$000(Lcom/facebook/cache/disk/DiskStorageCache;)Ljava/lang/Object;

    move-result-object v1

    monitor-enter v1

    .line 199
    :try_start_0
    iget-object v0, p0, Lcom/facebook/cache/disk/DiskStorageCache$1;->this$0:Lcom/facebook/cache/disk/DiskStorageCache;

    invoke-static {v0}, Lcom/facebook/cache/disk/DiskStorageCache;->access$100(Lcom/facebook/cache/disk/DiskStorageCache;)Z

    .line 200
    monitor-exit v1
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    .line 201
    iget-object v0, p0, Lcom/facebook/cache/disk/DiskStorageCache$1;->this$0:Lcom/facebook/cache/disk/DiskStorageCache;

    const/4 v1, 0x1

    invoke-static {v0, v1}, Lcom/facebook/cache/disk/DiskStorageCache;->access$202(Lcom/facebook/cache/disk/DiskStorageCache;Z)Z

    .line 202
    iget-object v0, p0, Lcom/facebook/cache/disk/DiskStorageCache$1;->this$0:Lcom/facebook/cache/disk/DiskStorageCache;

    invoke-static {v0}, Lcom/facebook/cache/disk/DiskStorageCache;->access$300(Lcom/facebook/cache/disk/DiskStorageCache;)Ljava/util/concurrent/CountDownLatch;

    move-result-object v0

    invoke-virtual {v0}, Ljava/util/concurrent/CountDownLatch;->countDown()V

    .line 203
    return-void

    .line 200
    :catchall_0
    move-exception v0

    :try_start_1
    monitor-exit v1
    :try_end_1
    .catchall {:try_start_1 .. :try_end_1} :catchall_0

    throw v0
.end method

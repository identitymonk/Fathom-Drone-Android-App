.class public Lcom/facebook/imagepipeline/core/DynamicDefaultDiskStorageFactory;
.super Ljava/lang/Object;
.source "DynamicDefaultDiskStorageFactory.java"

# interfaces
.implements Lcom/facebook/imagepipeline/core/DiskStorageFactory;


# direct methods
.method public constructor <init>()V
    .locals 0

    .prologue
    .line 18
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public get(Lcom/facebook/cache/disk/DiskCacheConfig;)Lcom/facebook/cache/disk/DiskStorage;
    .locals 5
    .param p1, "diskCacheConfig"    # Lcom/facebook/cache/disk/DiskCacheConfig;

    .prologue
    .line 22
    new-instance v0, Lcom/facebook/cache/disk/DynamicDefaultDiskStorage;

    .line 23
    invoke-virtual {p1}, Lcom/facebook/cache/disk/DiskCacheConfig;->getVersion()I

    move-result v1

    .line 24
    invoke-virtual {p1}, Lcom/facebook/cache/disk/DiskCacheConfig;->getBaseDirectoryPathSupplier()Lcom/facebook/common/internal/Supplier;

    move-result-object v2

    .line 25
    invoke-virtual {p1}, Lcom/facebook/cache/disk/DiskCacheConfig;->getBaseDirectoryName()Ljava/lang/String;

    move-result-object v3

    .line 26
    invoke-virtual {p1}, Lcom/facebook/cache/disk/DiskCacheConfig;->getCacheErrorLogger()Lcom/facebook/cache/common/CacheErrorLogger;

    move-result-object v4

    invoke-direct {v0, v1, v2, v3, v4}, Lcom/facebook/cache/disk/DynamicDefaultDiskStorage;-><init>(ILcom/facebook/common/internal/Supplier;Ljava/lang/String;Lcom/facebook/cache/common/CacheErrorLogger;)V

    return-object v0
.end method

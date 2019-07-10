.class public final Lcom/facebook/cache/common/CacheKeyUtil;
.super Ljava/lang/Object;
.source "CacheKeyUtil.java"


# direct methods
.method public constructor <init>()V
    .locals 0

    .prologue
    .line 17
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method

.method public static getFirstResourceId(Lcom/facebook/cache/common/CacheKey;)Ljava/lang/String;
    .locals 3
    .param p0, "key"    # Lcom/facebook/cache/common/CacheKey;

    .prologue
    .line 47
    :try_start_0
    instance-of v2, p0, Lcom/facebook/cache/common/MultiCacheKey;

    if-eqz v2, :cond_0

    .line 48
    check-cast p0, Lcom/facebook/cache/common/MultiCacheKey;

    .end local p0    # "key":Lcom/facebook/cache/common/CacheKey;
    invoke-virtual {p0}, Lcom/facebook/cache/common/MultiCacheKey;->getCacheKeys()Ljava/util/List;

    move-result-object v1

    .line 49
    .local v1, "keys":Ljava/util/List;, "Ljava/util/List<Lcom/facebook/cache/common/CacheKey;>;"
    const/4 v2, 0x0

    invoke-interface {v1, v2}, Ljava/util/List;->get(I)Ljava/lang/Object;

    move-result-object v2

    check-cast v2, Lcom/facebook/cache/common/CacheKey;

    invoke-static {v2}, Lcom/facebook/cache/common/CacheKeyUtil;->secureHashKey(Lcom/facebook/cache/common/CacheKey;)Ljava/lang/String;

    move-result-object v2

    .line 51
    .end local v1    # "keys":Ljava/util/List;, "Ljava/util/List<Lcom/facebook/cache/common/CacheKey;>;"
    :goto_0
    return-object v2

    .restart local p0    # "key":Lcom/facebook/cache/common/CacheKey;
    :cond_0
    invoke-static {p0}, Lcom/facebook/cache/common/CacheKeyUtil;->secureHashKey(Lcom/facebook/cache/common/CacheKey;)Ljava/lang/String;
    :try_end_0
    .catch Ljava/io/UnsupportedEncodingException; {:try_start_0 .. :try_end_0} :catch_0

    move-result-object v2

    goto :goto_0

    .line 53
    .end local p0    # "key":Lcom/facebook/cache/common/CacheKey;
    .restart local v1    # "keys":Ljava/util/List;, "Ljava/util/List<Lcom/facebook/cache/common/CacheKey;>;"
    :catch_0
    move-exception v0

    .line 55
    .local v0, "e":Ljava/io/UnsupportedEncodingException;
    new-instance v2, Ljava/lang/RuntimeException;

    invoke-direct {v2, v0}, Ljava/lang/RuntimeException;-><init>(Ljava/lang/Throwable;)V

    throw v2
.end method

.method public static getResourceIds(Lcom/facebook/cache/common/CacheKey;)Ljava/util/List;
    .locals 5
    .param p0, "key"    # Lcom/facebook/cache/common/CacheKey;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Lcom/facebook/cache/common/CacheKey;",
            ")",
            "Ljava/util/List",
            "<",
            "Ljava/lang/String;",
            ">;"
        }
    .end annotation

    .prologue
    .line 25
    :try_start_0
    instance-of v4, p0, Lcom/facebook/cache/common/MultiCacheKey;

    if-eqz v4, :cond_0

    .line 26
    check-cast p0, Lcom/facebook/cache/common/MultiCacheKey;

    .end local p0    # "key":Lcom/facebook/cache/common/CacheKey;
    invoke-virtual {p0}, Lcom/facebook/cache/common/MultiCacheKey;->getCacheKeys()Ljava/util/List;

    move-result-object v3

    .line 27
    .local v3, "keys":Ljava/util/List;, "Ljava/util/List<Lcom/facebook/cache/common/CacheKey;>;"
    new-instance v2, Ljava/util/ArrayList;

    invoke-interface {v3}, Ljava/util/List;->size()I

    move-result v4

    invoke-direct {v2, v4}, Ljava/util/ArrayList;-><init>(I)V

    .line 28
    .local v2, "ids":Ljava/util/List;, "Ljava/util/List<Ljava/lang/String;>;"
    const/4 v1, 0x0

    .local v1, "i":I
    :goto_0
    invoke-interface {v3}, Ljava/util/List;->size()I

    move-result v4

    if-ge v1, v4, :cond_1

    .line 29
    invoke-interface {v3, v1}, Ljava/util/List;->get(I)Ljava/lang/Object;

    move-result-object v4

    check-cast v4, Lcom/facebook/cache/common/CacheKey;

    invoke-static {v4}, Lcom/facebook/cache/common/CacheKeyUtil;->secureHashKey(Lcom/facebook/cache/common/CacheKey;)Ljava/lang/String;

    move-result-object v4

    invoke-interface {v2, v4}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    .line 28
    add-int/lit8 v1, v1, 0x1

    goto :goto_0

    .line 32
    .end local v1    # "i":I
    .end local v2    # "ids":Ljava/util/List;, "Ljava/util/List<Ljava/lang/String;>;"
    .end local v3    # "keys":Ljava/util/List;, "Ljava/util/List<Lcom/facebook/cache/common/CacheKey;>;"
    .restart local p0    # "key":Lcom/facebook/cache/common/CacheKey;
    :cond_0
    new-instance v2, Ljava/util/ArrayList;

    const/4 v4, 0x1

    invoke-direct {v2, v4}, Ljava/util/ArrayList;-><init>(I)V

    .line 33
    .restart local v2    # "ids":Ljava/util/List;, "Ljava/util/List<Ljava/lang/String;>;"
    invoke-static {p0}, Lcom/facebook/cache/common/CacheKeyUtil;->secureHashKey(Lcom/facebook/cache/common/CacheKey;)Ljava/lang/String;

    move-result-object v4

    invoke-interface {v2, v4}, Ljava/util/List;->add(Ljava/lang/Object;)Z
    :try_end_0
    .catch Ljava/io/UnsupportedEncodingException; {:try_start_0 .. :try_end_0} :catch_0

    .line 35
    .end local p0    # "key":Lcom/facebook/cache/common/CacheKey;
    :cond_1
    return-object v2

    .line 36
    .restart local p0    # "key":Lcom/facebook/cache/common/CacheKey;
    :catch_0
    move-exception v0

    .line 38
    .local v0, "e":Ljava/io/UnsupportedEncodingException;
    new-instance v4, Ljava/lang/RuntimeException;

    invoke-direct {v4, v0}, Ljava/lang/RuntimeException;-><init>(Ljava/lang/Throwable;)V

    throw v4
.end method

.method private static secureHashKey(Lcom/facebook/cache/common/CacheKey;)Ljava/lang/String;
    .locals 2
    .param p0, "key"    # Lcom/facebook/cache/common/CacheKey;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/UnsupportedEncodingException;
        }
    .end annotation

    .prologue
    .line 60
    invoke-interface {p0}, Lcom/facebook/cache/common/CacheKey;->getUriString()Ljava/lang/String;

    move-result-object v0

    const-string v1, "UTF-8"

    invoke-virtual {v0, v1}, Ljava/lang/String;->getBytes(Ljava/lang/String;)[B

    move-result-object v0

    invoke-static {v0}, Lcom/facebook/common/util/SecureHashUtil;->makeSHA1HashBase64([B)Ljava/lang/String;

    move-result-object v0

    return-object v0
.end method

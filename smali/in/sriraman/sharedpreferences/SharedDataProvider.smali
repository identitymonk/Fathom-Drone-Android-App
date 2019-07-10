.class public Lin/sriraman/sharedpreferences/SharedDataProvider;
.super Ljava/lang/Object;
.source "SharedDataProvider.java"


# static fields
.field private static final TAG:Ljava/lang/String; = "SharedDataProvider"


# direct methods
.method public constructor <init>()V
    .locals 0

    .prologue
    .line 7
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method

.method public static clear()V
    .locals 1

    .prologue
    .line 71
    invoke-static {}, Lin/sriraman/sharedpreferences/SharedHandler;->getInstance()Lin/sriraman/sharedpreferences/SharedHandler;

    move-result-object v0

    invoke-virtual {v0}, Lin/sriraman/sharedpreferences/SharedHandler;->clear()V

    .line 72
    return-void
.end method

.method public static deleteSharedValue(Ljava/lang/String;)V
    .locals 1
    .param p0, "key"    # Ljava/lang/String;

    .prologue
    .line 75
    invoke-static {}, Lin/sriraman/sharedpreferences/SharedHandler;->getInstance()Lin/sriraman/sharedpreferences/SharedHandler;

    move-result-object v0

    invoke-virtual {v0, p0}, Lin/sriraman/sharedpreferences/SharedHandler;->deleteKey(Ljava/lang/String;)V

    .line 76
    return-void
.end method

.method public static getAllKeys()[Ljava/lang/String;
    .locals 5

    .prologue
    .line 53
    invoke-static {}, Lin/sriraman/sharedpreferences/SharedHandler;->getInstance()Lin/sriraman/sharedpreferences/SharedHandler;

    move-result-object v4

    invoke-virtual {v4}, Lin/sriraman/sharedpreferences/SharedHandler;->getAllSharedData()Ljava/util/Map;

    move-result-object v1

    .line 54
    .local v1, "keyValues":Ljava/util/Map;, "Ljava/util/Map<Ljava/lang/String;*>;"
    new-instance v2, Ljava/util/ArrayList;

    invoke-interface {v1}, Ljava/util/Map;->keySet()Ljava/util/Set;

    move-result-object v4

    invoke-direct {v2, v4}, Ljava/util/ArrayList;-><init>(Ljava/util/Collection;)V

    .line 55
    .local v2, "keys":Ljava/util/List;, "Ljava/util/List<Ljava/lang/String;>;"
    invoke-interface {v2}, Ljava/util/List;->size()I

    move-result v4

    new-array v3, v4, [Ljava/lang/String;

    .line 56
    .local v3, "results":[Ljava/lang/String;
    const/4 v0, 0x0

    .local v0, "i":I
    :goto_0
    invoke-interface {v2}, Ljava/util/List;->size()I

    move-result v4

    if-ge v0, v4, :cond_0

    .line 57
    invoke-interface {v2, v0}, Ljava/util/List;->get(I)Ljava/lang/Object;

    move-result-object v4

    check-cast v4, Ljava/lang/String;

    aput-object v4, v3, v0

    .line 56
    add-int/lit8 v0, v0, 0x1

    goto :goto_0

    .line 59
    :cond_0
    return-object v3
.end method

.method public static getAllSharedValues()[[Ljava/lang/String;
    .locals 7

    .prologue
    .line 22
    invoke-static {}, Lin/sriraman/sharedpreferences/SharedHandler;->getInstance()Lin/sriraman/sharedpreferences/SharedHandler;

    move-result-object v4

    invoke-virtual {v4}, Lin/sriraman/sharedpreferences/SharedHandler;->getAllSharedData()Ljava/util/Map;

    move-result-object v1

    .line 23
    .local v1, "keyValues":Ljava/util/Map;, "Ljava/util/Map<Ljava/lang/String;*>;"
    new-instance v2, Ljava/util/ArrayList;

    invoke-interface {v1}, Ljava/util/Map;->keySet()Ljava/util/Set;

    move-result-object v4

    invoke-direct {v2, v4}, Ljava/util/ArrayList;-><init>(Ljava/util/Collection;)V

    .line 24
    .local v2, "keys":Ljava/util/List;, "Ljava/util/List<Ljava/lang/String;>;"
    invoke-interface {v2}, Ljava/util/List;->size()I

    move-result v4

    const/4 v5, 0x2

    filled-new-array {v4, v5}, [I

    move-result-object v4

    const-class v5, Ljava/lang/String;

    invoke-static {v5, v4}, Ljava/lang/reflect/Array;->newInstance(Ljava/lang/Class;[I)Ljava/lang/Object;

    move-result-object v3

    check-cast v3, [[Ljava/lang/String;

    .line 25
    .local v3, "results":[[Ljava/lang/String;
    const/4 v0, 0x0

    .local v0, "i":I
    :goto_0
    invoke-interface {v2}, Ljava/util/List;->size()I

    move-result v4

    if-ge v0, v4, :cond_0

    .line 26
    aget-object v5, v3, v0

    const/4 v6, 0x0

    invoke-interface {v2, v0}, Ljava/util/List;->get(I)Ljava/lang/Object;

    move-result-object v4

    check-cast v4, Ljava/lang/String;

    aput-object v4, v5, v6

    .line 27
    aget-object v4, v3, v0

    const/4 v5, 0x1

    invoke-interface {v2, v0}, Ljava/util/List;->get(I)Ljava/lang/Object;

    move-result-object v6

    invoke-interface {v1, v6}, Ljava/util/Map;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v6

    invoke-static {v6}, Ljava/lang/String;->valueOf(Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v6

    aput-object v6, v4, v5

    .line 25
    add-int/lit8 v0, v0, 0x1

    goto :goto_0

    .line 29
    :cond_0
    return-object v3
.end method

.method public static getMultiSharedValues([Ljava/lang/String;)[[Ljava/lang/String;
    .locals 6
    .param p0, "keys"    # [Ljava/lang/String;

    .prologue
    .line 12
    invoke-static {}, Lin/sriraman/sharedpreferences/SharedHandler;->getInstance()Lin/sriraman/sharedpreferences/SharedHandler;

    move-result-object v2

    .line 13
    .local v2, "sharedHandler":Lin/sriraman/sharedpreferences/SharedHandler;
    array-length v3, p0

    const/4 v4, 0x2

    filled-new-array {v3, v4}, [I

    move-result-object v3

    const-class v4, Ljava/lang/String;

    invoke-static {v4, v3}, Ljava/lang/reflect/Array;->newInstance(Ljava/lang/Class;[I)Ljava/lang/Object;

    move-result-object v1

    check-cast v1, [[Ljava/lang/String;

    .line 14
    .local v1, "results":[[Ljava/lang/String;
    const/4 v0, 0x0

    .local v0, "i":I
    :goto_0
    array-length v3, p0

    if-ge v0, v3, :cond_0

    .line 15
    aget-object v3, v1, v0

    const/4 v4, 0x0

    aget-object v5, p0, v0

    aput-object v5, v3, v4

    .line 16
    aget-object v3, v1, v0

    const/4 v4, 0x1

    aget-object v5, p0, v0

    invoke-virtual {v2, v5}, Lin/sriraman/sharedpreferences/SharedHandler;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v5

    invoke-static {v5}, Ljava/lang/String;->valueOf(Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v5

    aput-object v5, v3, v4

    .line 14
    add-int/lit8 v0, v0, 0x1

    goto :goto_0

    .line 18
    :cond_0
    return-object v1
.end method

.method public static getSharedValue(Ljava/lang/String;)Ljava/lang/String;
    .locals 1
    .param p0, "key"    # Ljava/lang/String;

    .prologue
    .line 63
    invoke-static {}, Lin/sriraman/sharedpreferences/SharedHandler;->getInstance()Lin/sriraman/sharedpreferences/SharedHandler;

    move-result-object v0

    invoke-virtual {v0, p0}, Lin/sriraman/sharedpreferences/SharedHandler;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    return-object v0
.end method

.method public static putSharedValue(Ljava/lang/String;Ljava/lang/String;)V
    .locals 1
    .param p0, "key"    # Ljava/lang/String;
    .param p1, "value"    # Ljava/lang/String;

    .prologue
    .line 67
    invoke-static {}, Lin/sriraman/sharedpreferences/SharedHandler;->getInstance()Lin/sriraman/sharedpreferences/SharedHandler;

    move-result-object v0

    invoke-virtual {v0, p0, p1}, Lin/sriraman/sharedpreferences/SharedHandler;->putExtra(Ljava/lang/String;Ljava/lang/Object;)V

    .line 68
    return-void
.end method

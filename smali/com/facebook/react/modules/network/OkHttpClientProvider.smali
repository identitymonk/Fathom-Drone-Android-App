.class public Lcom/facebook/react/modules/network/OkHttpClientProvider;
.super Ljava/lang/Object;
.source "OkHttpClientProvider.java"


# static fields
.field private static sClient:Lokhttp3/OkHttpClient;
    .annotation runtime Ljavax/annotation/Nullable;
    .end annotation
.end field


# direct methods
.method public constructor <init>()V
    .locals 0

    .prologue
    .line 30
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method

.method public static createClient()Lokhttp3/OkHttpClient;
    .locals 6

    .prologue
    const-wide/16 v4, 0x0

    .line 50
    new-instance v1, Lokhttp3/OkHttpClient$Builder;

    invoke-direct {v1}, Lokhttp3/OkHttpClient$Builder;-><init>()V

    sget-object v2, Ljava/util/concurrent/TimeUnit;->MILLISECONDS:Ljava/util/concurrent/TimeUnit;

    .line 51
    invoke-virtual {v1, v4, v5, v2}, Lokhttp3/OkHttpClient$Builder;->connectTimeout(JLjava/util/concurrent/TimeUnit;)Lokhttp3/OkHttpClient$Builder;

    move-result-object v1

    sget-object v2, Ljava/util/concurrent/TimeUnit;->MILLISECONDS:Ljava/util/concurrent/TimeUnit;

    .line 52
    invoke-virtual {v1, v4, v5, v2}, Lokhttp3/OkHttpClient$Builder;->readTimeout(JLjava/util/concurrent/TimeUnit;)Lokhttp3/OkHttpClient$Builder;

    move-result-object v1

    sget-object v2, Ljava/util/concurrent/TimeUnit;->MILLISECONDS:Ljava/util/concurrent/TimeUnit;

    .line 53
    invoke-virtual {v1, v4, v5, v2}, Lokhttp3/OkHttpClient$Builder;->writeTimeout(JLjava/util/concurrent/TimeUnit;)Lokhttp3/OkHttpClient$Builder;

    move-result-object v1

    new-instance v2, Lcom/facebook/react/modules/network/ReactCookieJarContainer;

    invoke-direct {v2}, Lcom/facebook/react/modules/network/ReactCookieJarContainer;-><init>()V

    .line 54
    invoke-virtual {v1, v2}, Lokhttp3/OkHttpClient$Builder;->cookieJar(Lokhttp3/CookieJar;)Lokhttp3/OkHttpClient$Builder;

    move-result-object v0

    .line 56
    .local v0, "client":Lokhttp3/OkHttpClient$Builder;
    invoke-static {v0}, Lcom/facebook/react/modules/network/OkHttpClientProvider;->enableTls12OnPreLollipop(Lokhttp3/OkHttpClient$Builder;)Lokhttp3/OkHttpClient$Builder;

    move-result-object v1

    invoke-virtual {v1}, Lokhttp3/OkHttpClient$Builder;->build()Lokhttp3/OkHttpClient;

    move-result-object v1

    return-object v1
.end method

.method public static enableTls12OnPreLollipop(Lokhttp3/OkHttpClient$Builder;)Lokhttp3/OkHttpClient$Builder;
    .locals 7
    .param p0, "client"    # Lokhttp3/OkHttpClient$Builder;

    .prologue
    .line 65
    sget v3, Landroid/os/Build$VERSION;->SDK_INT:I

    const/16 v4, 0x10

    if-lt v3, v4, :cond_0

    sget v3, Landroid/os/Build$VERSION;->SDK_INT:I

    const/16 v4, 0x13

    if-gt v3, v4, :cond_0

    .line 67
    :try_start_0
    new-instance v3, Lcom/facebook/react/modules/network/TLSSocketFactory;

    invoke-direct {v3}, Lcom/facebook/react/modules/network/TLSSocketFactory;-><init>()V

    invoke-virtual {p0, v3}, Lokhttp3/OkHttpClient$Builder;->sslSocketFactory(Ljavax/net/ssl/SSLSocketFactory;)Lokhttp3/OkHttpClient$Builder;

    .line 69
    new-instance v3, Lokhttp3/ConnectionSpec$Builder;

    sget-object v4, Lokhttp3/ConnectionSpec;->MODERN_TLS:Lokhttp3/ConnectionSpec;

    invoke-direct {v3, v4}, Lokhttp3/ConnectionSpec$Builder;-><init>(Lokhttp3/ConnectionSpec;)V

    const/4 v4, 0x1

    new-array v4, v4, [Lokhttp3/TlsVersion;

    const/4 v5, 0x0

    sget-object v6, Lokhttp3/TlsVersion;->TLS_1_2:Lokhttp3/TlsVersion;

    aput-object v6, v4, v5

    .line 70
    invoke-virtual {v3, v4}, Lokhttp3/ConnectionSpec$Builder;->tlsVersions([Lokhttp3/TlsVersion;)Lokhttp3/ConnectionSpec$Builder;

    move-result-object v3

    .line 71
    invoke-virtual {v3}, Lokhttp3/ConnectionSpec$Builder;->build()Lokhttp3/ConnectionSpec;

    move-result-object v0

    .line 73
    .local v0, "cs":Lokhttp3/ConnectionSpec;
    new-instance v2, Ljava/util/ArrayList;

    invoke-direct {v2}, Ljava/util/ArrayList;-><init>()V

    .line 74
    .local v2, "specs":Ljava/util/List;, "Ljava/util/List<Lokhttp3/ConnectionSpec;>;"
    invoke-interface {v2, v0}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    .line 75
    sget-object v3, Lokhttp3/ConnectionSpec;->COMPATIBLE_TLS:Lokhttp3/ConnectionSpec;

    invoke-interface {v2, v3}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    .line 76
    sget-object v3, Lokhttp3/ConnectionSpec;->CLEARTEXT:Lokhttp3/ConnectionSpec;

    invoke-interface {v2, v3}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    .line 78
    invoke-virtual {p0, v2}, Lokhttp3/OkHttpClient$Builder;->connectionSpecs(Ljava/util/List;)Lokhttp3/OkHttpClient$Builder;
    :try_end_0
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_0

    .line 84
    .end local v0    # "cs":Lokhttp3/ConnectionSpec;
    .end local v2    # "specs":Ljava/util/List;, "Ljava/util/List<Lokhttp3/ConnectionSpec;>;"
    :cond_0
    :goto_0
    return-object p0

    .line 79
    :catch_0
    move-exception v1

    .line 80
    .local v1, "exc":Ljava/lang/Exception;
    const-string v3, "OkHttpClientProvider"

    const-string v4, "Error while enabling TLS 1.2"

    invoke-static {v3, v4, v1}, Lcom/facebook/common/logging/FLog;->e(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V

    goto :goto_0
.end method

.method public static getOkHttpClient()Lokhttp3/OkHttpClient;
    .locals 1

    .prologue
    .line 36
    sget-object v0, Lcom/facebook/react/modules/network/OkHttpClientProvider;->sClient:Lokhttp3/OkHttpClient;

    if-nez v0, :cond_0

    .line 37
    invoke-static {}, Lcom/facebook/react/modules/network/OkHttpClientProvider;->createClient()Lokhttp3/OkHttpClient;

    move-result-object v0

    sput-object v0, Lcom/facebook/react/modules/network/OkHttpClientProvider;->sClient:Lokhttp3/OkHttpClient;

    .line 39
    :cond_0
    sget-object v0, Lcom/facebook/react/modules/network/OkHttpClientProvider;->sClient:Lokhttp3/OkHttpClient;

    return-object v0
.end method

.method public static replaceOkHttpClient(Lokhttp3/OkHttpClient;)V
    .locals 0
    .param p0, "client"    # Lokhttp3/OkHttpClient;

    .prologue
    .line 45
    sput-object p0, Lcom/facebook/react/modules/network/OkHttpClientProvider;->sClient:Lokhttp3/OkHttpClient;

    .line 46
    return-void
.end method

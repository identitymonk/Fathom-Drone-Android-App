.class public Lcom/facebook/react/modules/network/ForwardingCookieHandler;
.super Ljava/net/CookieHandler;
.source "ForwardingCookieHandler.java"


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lcom/facebook/react/modules/network/ForwardingCookieHandler$CookieSaver;
    }
.end annotation


# static fields
.field private static final COOKIE_HEADER:Ljava/lang/String; = "Cookie"

.field private static final USES_LEGACY_STORE:Z

.field private static final VERSION_ONE_HEADER:Ljava/lang/String; = "Set-cookie2"

.field private static final VERSION_ZERO_HEADER:Ljava/lang/String; = "Set-cookie"


# instance fields
.field private final mContext:Lcom/facebook/react/bridge/ReactContext;

.field private mCookieManager:Landroid/webkit/CookieManager;
    .annotation runtime Ljavax/annotation/Nullable;
    .end annotation
.end field

.field private final mCookieSaver:Lcom/facebook/react/modules/network/ForwardingCookieHandler$CookieSaver;


# direct methods
.method static constructor <clinit>()V
    .locals 2

    .prologue
    .line 42
    sget v0, Landroid/os/Build$VERSION;->SDK_INT:I

    const/16 v1, 0x15

    if-ge v0, v1, :cond_0

    const/4 v0, 0x1

    :goto_0
    sput-boolean v0, Lcom/facebook/react/modules/network/ForwardingCookieHandler;->USES_LEGACY_STORE:Z

    return-void

    :cond_0
    const/4 v0, 0x0

    goto :goto_0
.end method

.method public constructor <init>(Lcom/facebook/react/bridge/ReactContext;)V
    .locals 1
    .param p1, "context"    # Lcom/facebook/react/bridge/ReactContext;

    .prologue
    .line 48
    invoke-direct {p0}, Ljava/net/CookieHandler;-><init>()V

    .line 49
    iput-object p1, p0, Lcom/facebook/react/modules/network/ForwardingCookieHandler;->mContext:Lcom/facebook/react/bridge/ReactContext;

    .line 50
    new-instance v0, Lcom/facebook/react/modules/network/ForwardingCookieHandler$CookieSaver;

    invoke-direct {v0, p0}, Lcom/facebook/react/modules/network/ForwardingCookieHandler$CookieSaver;-><init>(Lcom/facebook/react/modules/network/ForwardingCookieHandler;)V

    iput-object v0, p0, Lcom/facebook/react/modules/network/ForwardingCookieHandler;->mCookieSaver:Lcom/facebook/react/modules/network/ForwardingCookieHandler$CookieSaver;

    .line 51
    return-void
.end method

.method static synthetic access$000(Lcom/facebook/react/modules/network/ForwardingCookieHandler;)Landroid/webkit/CookieManager;
    .locals 1
    .param p0, "x0"    # Lcom/facebook/react/modules/network/ForwardingCookieHandler;

    .prologue
    .line 36
    invoke-direct {p0}, Lcom/facebook/react/modules/network/ForwardingCookieHandler;->getCookieManager()Landroid/webkit/CookieManager;

    move-result-object v0

    return-object v0
.end method

.method static synthetic access$100(Lcom/facebook/react/modules/network/ForwardingCookieHandler;)Lcom/facebook/react/modules/network/ForwardingCookieHandler$CookieSaver;
    .locals 1
    .param p0, "x0"    # Lcom/facebook/react/modules/network/ForwardingCookieHandler;

    .prologue
    .line 36
    iget-object v0, p0, Lcom/facebook/react/modules/network/ForwardingCookieHandler;->mCookieSaver:Lcom/facebook/react/modules/network/ForwardingCookieHandler$CookieSaver;

    return-object v0
.end method

.method static synthetic access$200()Z
    .locals 1

    .prologue
    .line 36
    sget-boolean v0, Lcom/facebook/react/modules/network/ForwardingCookieHandler;->USES_LEGACY_STORE:Z

    return v0
.end method

.method static synthetic access$400(Lcom/facebook/react/modules/network/ForwardingCookieHandler;Ljava/lang/Runnable;)V
    .locals 0
    .param p0, "x0"    # Lcom/facebook/react/modules/network/ForwardingCookieHandler;
    .param p1, "x1"    # Ljava/lang/Runnable;

    .prologue
    .line 36
    invoke-direct {p0, p1}, Lcom/facebook/react/modules/network/ForwardingCookieHandler;->runInBackground(Ljava/lang/Runnable;)V

    return-void
.end method

.method private addCookieAsync(Ljava/lang/String;Ljava/lang/String;)V
    .locals 2
    .param p1, "url"    # Ljava/lang/String;
    .param p2, "cookie"    # Ljava/lang/String;
    .annotation build Landroid/annotation/TargetApi;
        value = 0x15
    .end annotation

    .prologue
    .line 135
    invoke-direct {p0}, Lcom/facebook/react/modules/network/ForwardingCookieHandler;->getCookieManager()Landroid/webkit/CookieManager;

    move-result-object v0

    const/4 v1, 0x0

    invoke-virtual {v0, p1, p2, v1}, Landroid/webkit/CookieManager;->setCookie(Ljava/lang/String;Ljava/lang/String;Landroid/webkit/ValueCallback;)V

    .line 136
    return-void
.end method

.method private addCookies(Ljava/lang/String;Ljava/util/List;)V
    .locals 3
    .param p1, "url"    # Ljava/lang/String;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/lang/String;",
            "Ljava/util/List",
            "<",
            "Ljava/lang/String;",
            ">;)V"
        }
    .end annotation

    .prologue
    .line 114
    .local p2, "cookies":Ljava/util/List;, "Ljava/util/List<Ljava/lang/String;>;"
    sget-boolean v1, Lcom/facebook/react/modules/network/ForwardingCookieHandler;->USES_LEGACY_STORE:Z

    if-eqz v1, :cond_0

    .line 115
    new-instance v1, Lcom/facebook/react/modules/network/ForwardingCookieHandler$3;

    invoke-direct {v1, p0, p2, p1}, Lcom/facebook/react/modules/network/ForwardingCookieHandler$3;-><init>(Lcom/facebook/react/modules/network/ForwardingCookieHandler;Ljava/util/List;Ljava/lang/String;)V

    invoke-direct {p0, v1}, Lcom/facebook/react/modules/network/ForwardingCookieHandler;->runInBackground(Ljava/lang/Runnable;)V

    .line 131
    :goto_0
    return-void

    .line 126
    :cond_0
    invoke-interface {p2}, Ljava/util/List;->iterator()Ljava/util/Iterator;

    move-result-object v1

    :goto_1
    invoke-interface {v1}, Ljava/util/Iterator;->hasNext()Z

    move-result v2

    if-eqz v2, :cond_1

    invoke-interface {v1}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Ljava/lang/String;

    .line 127
    .local v0, "cookie":Ljava/lang/String;
    invoke-direct {p0, p1, v0}, Lcom/facebook/react/modules/network/ForwardingCookieHandler;->addCookieAsync(Ljava/lang/String;Ljava/lang/String;)V

    goto :goto_1

    .line 129
    .end local v0    # "cookie":Ljava/lang/String;
    :cond_1
    iget-object v1, p0, Lcom/facebook/react/modules/network/ForwardingCookieHandler;->mCookieSaver:Lcom/facebook/react/modules/network/ForwardingCookieHandler$CookieSaver;

    invoke-virtual {v1}, Lcom/facebook/react/modules/network/ForwardingCookieHandler$CookieSaver;->onCookiesModified()V

    goto :goto_0
.end method

.method private clearCookiesAsync(Lcom/facebook/react/bridge/Callback;)V
    .locals 2
    .param p1, "callback"    # Lcom/facebook/react/bridge/Callback;

    .prologue
    .line 96
    invoke-direct {p0}, Lcom/facebook/react/modules/network/ForwardingCookieHandler;->getCookieManager()Landroid/webkit/CookieManager;

    move-result-object v0

    new-instance v1, Lcom/facebook/react/modules/network/ForwardingCookieHandler$2;

    invoke-direct {v1, p0, p1}, Lcom/facebook/react/modules/network/ForwardingCookieHandler$2;-><init>(Lcom/facebook/react/modules/network/ForwardingCookieHandler;Lcom/facebook/react/bridge/Callback;)V

    invoke-virtual {v0, v1}, Landroid/webkit/CookieManager;->removeAllCookies(Landroid/webkit/ValueCallback;)V

    .line 104
    return-void
.end method

.method private getCookieManager()Landroid/webkit/CookieManager;
    .locals 1

    .prologue
    .line 156
    iget-object v0, p0, Lcom/facebook/react/modules/network/ForwardingCookieHandler;->mCookieManager:Landroid/webkit/CookieManager;

    if-nez v0, :cond_0

    .line 157
    iget-object v0, p0, Lcom/facebook/react/modules/network/ForwardingCookieHandler;->mContext:Lcom/facebook/react/bridge/ReactContext;

    invoke-static {v0}, Lcom/facebook/react/modules/network/ForwardingCookieHandler;->possiblyWorkaroundSyncManager(Landroid/content/Context;)V

    .line 158
    invoke-static {}, Landroid/webkit/CookieManager;->getInstance()Landroid/webkit/CookieManager;

    move-result-object v0

    iput-object v0, p0, Lcom/facebook/react/modules/network/ForwardingCookieHandler;->mCookieManager:Landroid/webkit/CookieManager;

    .line 160
    sget-boolean v0, Lcom/facebook/react/modules/network/ForwardingCookieHandler;->USES_LEGACY_STORE:Z

    if-eqz v0, :cond_0

    .line 161
    iget-object v0, p0, Lcom/facebook/react/modules/network/ForwardingCookieHandler;->mCookieManager:Landroid/webkit/CookieManager;

    invoke-virtual {v0}, Landroid/webkit/CookieManager;->removeExpiredCookie()V

    .line 165
    :cond_0
    iget-object v0, p0, Lcom/facebook/react/modules/network/ForwardingCookieHandler;->mCookieManager:Landroid/webkit/CookieManager;

    return-object v0
.end method

.method private static isCookieHeader(Ljava/lang/String;)Z
    .locals 1
    .param p0, "name"    # Ljava/lang/String;

    .prologue
    .line 139
    const-string v0, "Set-cookie"

    invoke-virtual {p0, v0}, Ljava/lang/String;->equalsIgnoreCase(Ljava/lang/String;)Z

    move-result v0

    if-nez v0, :cond_0

    const-string v0, "Set-cookie2"

    invoke-virtual {p0, v0}, Ljava/lang/String;->equalsIgnoreCase(Ljava/lang/String;)Z

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

.method private static possiblyWorkaroundSyncManager(Landroid/content/Context;)V
    .locals 2
    .param p0, "context"    # Landroid/content/Context;

    .prologue
    .line 169
    sget-boolean v1, Lcom/facebook/react/modules/network/ForwardingCookieHandler;->USES_LEGACY_STORE:Z

    if-eqz v1, :cond_0

    .line 173
    invoke-static {p0}, Landroid/webkit/CookieSyncManager;->createInstance(Landroid/content/Context;)Landroid/webkit/CookieSyncManager;

    move-result-object v0

    .line 174
    .local v0, "syncManager":Landroid/webkit/CookieSyncManager;
    invoke-virtual {v0}, Landroid/webkit/CookieSyncManager;->sync()V

    .line 176
    .end local v0    # "syncManager":Landroid/webkit/CookieSyncManager;
    :cond_0
    return-void
.end method

.method private runInBackground(Ljava/lang/Runnable;)V
    .locals 2
    .param p1, "runnable"    # Ljava/lang/Runnable;

    .prologue
    .line 143
    new-instance v0, Lcom/facebook/react/modules/network/ForwardingCookieHandler$4;

    iget-object v1, p0, Lcom/facebook/react/modules/network/ForwardingCookieHandler;->mContext:Lcom/facebook/react/bridge/ReactContext;

    invoke-direct {v0, p0, v1, p1}, Lcom/facebook/react/modules/network/ForwardingCookieHandler$4;-><init>(Lcom/facebook/react/modules/network/ForwardingCookieHandler;Lcom/facebook/react/bridge/ReactContext;Ljava/lang/Runnable;)V

    const/4 v1, 0x0

    new-array v1, v1, [Ljava/lang/Void;

    .line 148
    invoke-virtual {v0, v1}, Lcom/facebook/react/modules/network/ForwardingCookieHandler$4;->execute([Ljava/lang/Object;)Landroid/os/AsyncTask;

    .line 149
    return-void
.end method


# virtual methods
.method public clearCookies(Lcom/facebook/react/bridge/Callback;)V
    .locals 2
    .param p1, "callback"    # Lcom/facebook/react/bridge/Callback;

    .prologue
    .line 76
    sget-boolean v0, Lcom/facebook/react/modules/network/ForwardingCookieHandler;->USES_LEGACY_STORE:Z

    if-eqz v0, :cond_0

    .line 77
    new-instance v0, Lcom/facebook/react/modules/network/ForwardingCookieHandler$1;

    iget-object v1, p0, Lcom/facebook/react/modules/network/ForwardingCookieHandler;->mContext:Lcom/facebook/react/bridge/ReactContext;

    invoke-direct {v0, p0, v1, p1}, Lcom/facebook/react/modules/network/ForwardingCookieHandler$1;-><init>(Lcom/facebook/react/modules/network/ForwardingCookieHandler;Lcom/facebook/react/bridge/ReactContext;Lcom/facebook/react/bridge/Callback;)V

    const/4 v1, 0x0

    new-array v1, v1, [Ljava/lang/Void;

    .line 89
    invoke-virtual {v0, v1}, Lcom/facebook/react/modules/network/ForwardingCookieHandler$1;->execute([Ljava/lang/Object;)Landroid/os/AsyncTask;

    .line 93
    :goto_0
    return-void

    .line 91
    :cond_0
    invoke-direct {p0, p1}, Lcom/facebook/react/modules/network/ForwardingCookieHandler;->clearCookiesAsync(Lcom/facebook/react/bridge/Callback;)V

    goto :goto_0
.end method

.method public destroy()V
    .locals 1

    .prologue
    .line 107
    sget-boolean v0, Lcom/facebook/react/modules/network/ForwardingCookieHandler;->USES_LEGACY_STORE:Z

    if-eqz v0, :cond_0

    .line 108
    invoke-direct {p0}, Lcom/facebook/react/modules/network/ForwardingCookieHandler;->getCookieManager()Landroid/webkit/CookieManager;

    move-result-object v0

    invoke-virtual {v0}, Landroid/webkit/CookieManager;->removeExpiredCookie()V

    .line 109
    iget-object v0, p0, Lcom/facebook/react/modules/network/ForwardingCookieHandler;->mCookieSaver:Lcom/facebook/react/modules/network/ForwardingCookieHandler$CookieSaver;

    invoke-virtual {v0}, Lcom/facebook/react/modules/network/ForwardingCookieHandler$CookieSaver;->persistCookies()V

    .line 111
    :cond_0
    return-void
.end method

.method public get(Ljava/net/URI;Ljava/util/Map;)Ljava/util/Map;
    .locals 3
    .param p1, "uri"    # Ljava/net/URI;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/net/URI;",
            "Ljava/util/Map",
            "<",
            "Ljava/lang/String;",
            "Ljava/util/List",
            "<",
            "Ljava/lang/String;",
            ">;>;)",
            "Ljava/util/Map",
            "<",
            "Ljava/lang/String;",
            "Ljava/util/List",
            "<",
            "Ljava/lang/String;",
            ">;>;"
        }
    .end annotation

    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;
        }
    .end annotation

    .prologue
    .line 56
    .local p2, "headers":Ljava/util/Map;, "Ljava/util/Map<Ljava/lang/String;Ljava/util/List<Ljava/lang/String;>;>;"
    invoke-direct {p0}, Lcom/facebook/react/modules/network/ForwardingCookieHandler;->getCookieManager()Landroid/webkit/CookieManager;

    move-result-object v1

    invoke-virtual {p1}, Ljava/net/URI;->toString()Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v1, v2}, Landroid/webkit/CookieManager;->getCookie(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    .line 57
    .local v0, "cookies":Ljava/lang/String;
    invoke-static {v0}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result v1

    if-eqz v1, :cond_0

    .line 58
    invoke-static {}, Ljava/util/Collections;->emptyMap()Ljava/util/Map;

    move-result-object v1

    .line 61
    :goto_0
    return-object v1

    :cond_0
    const-string v1, "Cookie"

    invoke-static {v0}, Ljava/util/Collections;->singletonList(Ljava/lang/Object;)Ljava/util/List;

    move-result-object v2

    invoke-static {v1, v2}, Ljava/util/Collections;->singletonMap(Ljava/lang/Object;Ljava/lang/Object;)Ljava/util/Map;

    move-result-object v1

    goto :goto_0
.end method

.method public put(Ljava/net/URI;Ljava/util/Map;)V
    .locals 5
    .param p1, "uri"    # Ljava/net/URI;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/net/URI;",
            "Ljava/util/Map",
            "<",
            "Ljava/lang/String;",
            "Ljava/util/List",
            "<",
            "Ljava/lang/String;",
            ">;>;)V"
        }
    .end annotation

    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;
        }
    .end annotation

    .prologue
    .line 66
    .local p2, "headers":Ljava/util/Map;, "Ljava/util/Map<Ljava/lang/String;Ljava/util/List<Ljava/lang/String;>;>;"
    invoke-virtual {p1}, Ljava/net/URI;->toString()Ljava/lang/String;

    move-result-object v2

    .line 67
    .local v2, "url":Ljava/lang/String;
    invoke-interface {p2}, Ljava/util/Map;->entrySet()Ljava/util/Set;

    move-result-object v3

    invoke-interface {v3}, Ljava/util/Set;->iterator()Ljava/util/Iterator;

    move-result-object v4

    :cond_0
    :goto_0
    invoke-interface {v4}, Ljava/util/Iterator;->hasNext()Z

    move-result v3

    if-eqz v3, :cond_1

    invoke-interface {v4}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Ljava/util/Map$Entry;

    .line 68
    .local v0, "entry":Ljava/util/Map$Entry;, "Ljava/util/Map$Entry<Ljava/lang/String;Ljava/util/List<Ljava/lang/String;>;>;"
    invoke-interface {v0}, Ljava/util/Map$Entry;->getKey()Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Ljava/lang/String;

    .line 69
    .local v1, "key":Ljava/lang/String;
    if-eqz v1, :cond_0

    invoke-static {v1}, Lcom/facebook/react/modules/network/ForwardingCookieHandler;->isCookieHeader(Ljava/lang/String;)Z

    move-result v3

    if-eqz v3, :cond_0

    .line 70
    invoke-interface {v0}, Ljava/util/Map$Entry;->getValue()Ljava/lang/Object;

    move-result-object v3

    check-cast v3, Ljava/util/List;

    invoke-direct {p0, v2, v3}, Lcom/facebook/react/modules/network/ForwardingCookieHandler;->addCookies(Ljava/lang/String;Ljava/util/List;)V

    goto :goto_0

    .line 73
    .end local v0    # "entry":Ljava/util/Map$Entry;, "Ljava/util/Map$Entry<Ljava/lang/String;Ljava/util/List<Ljava/lang/String;>;>;"
    .end local v1    # "key":Ljava/lang/String;
    :cond_1
    return-void
.end method

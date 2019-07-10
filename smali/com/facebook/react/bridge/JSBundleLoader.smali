.class public abstract Lcom/facebook/react/bridge/JSBundleLoader;
.super Ljava/lang/Object;
.source "JSBundleLoader.java"


# direct methods
.method public constructor <init>()V
    .locals 0

    .prologue
    .line 20
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method

.method public static createAssetLoader(Landroid/content/Context;Ljava/lang/String;Z)Lcom/facebook/react/bridge/JSBundleLoader;
    .locals 1
    .param p0, "context"    # Landroid/content/Context;
    .param p1, "assetUrl"    # Ljava/lang/String;
    .param p2, "loadSynchronously"    # Z

    .prologue
    .line 31
    new-instance v0, Lcom/facebook/react/bridge/JSBundleLoader$1;

    invoke-direct {v0, p0, p1, p2}, Lcom/facebook/react/bridge/JSBundleLoader$1;-><init>(Landroid/content/Context;Ljava/lang/String;Z)V

    return-object v0
.end method

.method public static createCachedBundleFromNetworkLoader(Ljava/lang/String;Ljava/lang/String;)Lcom/facebook/react/bridge/JSBundleLoader;
    .locals 1
    .param p0, "sourceURL"    # Ljava/lang/String;
    .param p1, "cachedFileLocation"    # Ljava/lang/String;

    .prologue
    .line 71
    new-instance v0, Lcom/facebook/react/bridge/JSBundleLoader$3;

    invoke-direct {v0, p1, p0}, Lcom/facebook/react/bridge/JSBundleLoader$3;-><init>(Ljava/lang/String;Ljava/lang/String;)V

    return-object v0
.end method

.method public static createFileLoader(Ljava/lang/String;)Lcom/facebook/react/bridge/JSBundleLoader;
    .locals 1
    .param p0, "fileName"    # Ljava/lang/String;

    .prologue
    .line 45
    const/4 v0, 0x0

    invoke-static {p0, p0, v0}, Lcom/facebook/react/bridge/JSBundleLoader;->createFileLoader(Ljava/lang/String;Ljava/lang/String;Z)Lcom/facebook/react/bridge/JSBundleLoader;

    move-result-object v0

    return-object v0
.end method

.method public static createFileLoader(Ljava/lang/String;Ljava/lang/String;Z)Lcom/facebook/react/bridge/JSBundleLoader;
    .locals 1
    .param p0, "fileName"    # Ljava/lang/String;
    .param p1, "assetUrl"    # Ljava/lang/String;
    .param p2, "loadSynchronously"    # Z

    .prologue
    .line 52
    new-instance v0, Lcom/facebook/react/bridge/JSBundleLoader$2;

    invoke-direct {v0, p0, p1, p2}, Lcom/facebook/react/bridge/JSBundleLoader$2;-><init>(Ljava/lang/String;Ljava/lang/String;Z)V

    return-object v0
.end method

.method public static createRemoteDebuggerBundleLoader(Ljava/lang/String;Ljava/lang/String;)Lcom/facebook/react/bridge/JSBundleLoader;
    .locals 1
    .param p0, "proxySourceURL"    # Ljava/lang/String;
    .param p1, "realSourceURL"    # Ljava/lang/String;

    .prologue
    .line 91
    new-instance v0, Lcom/facebook/react/bridge/JSBundleLoader$4;

    invoke-direct {v0, p1, p0}, Lcom/facebook/react/bridge/JSBundleLoader$4;-><init>(Ljava/lang/String;Ljava/lang/String;)V

    return-object v0
.end method


# virtual methods
.method public abstract loadScript(Lcom/facebook/react/bridge/CatalystInstanceImpl;)Ljava/lang/String;
.end method

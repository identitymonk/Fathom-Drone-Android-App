.class final Lcom/facebook/react/bridge/JSBundleLoader$1;
.super Lcom/facebook/react/bridge/JSBundleLoader;
.source "JSBundleLoader.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/facebook/react/bridge/JSBundleLoader;->createAssetLoader(Landroid/content/Context;Ljava/lang/String;Z)Lcom/facebook/react/bridge/JSBundleLoader;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x8
    name = null
.end annotation


# instance fields
.field final synthetic val$assetUrl:Ljava/lang/String;

.field final synthetic val$context:Landroid/content/Context;

.field final synthetic val$loadSynchronously:Z


# direct methods
.method constructor <init>(Landroid/content/Context;Ljava/lang/String;Z)V
    .locals 0

    .prologue
    .line 31
    iput-object p1, p0, Lcom/facebook/react/bridge/JSBundleLoader$1;->val$context:Landroid/content/Context;

    iput-object p2, p0, Lcom/facebook/react/bridge/JSBundleLoader$1;->val$assetUrl:Ljava/lang/String;

    iput-boolean p3, p0, Lcom/facebook/react/bridge/JSBundleLoader$1;->val$loadSynchronously:Z

    invoke-direct {p0}, Lcom/facebook/react/bridge/JSBundleLoader;-><init>()V

    return-void
.end method


# virtual methods
.method public loadScript(Lcom/facebook/react/bridge/CatalystInstanceImpl;)Ljava/lang/String;
    .locals 3
    .param p1, "instance"    # Lcom/facebook/react/bridge/CatalystInstanceImpl;

    .prologue
    .line 34
    iget-object v0, p0, Lcom/facebook/react/bridge/JSBundleLoader$1;->val$context:Landroid/content/Context;

    invoke-virtual {v0}, Landroid/content/Context;->getAssets()Landroid/content/res/AssetManager;

    move-result-object v0

    iget-object v1, p0, Lcom/facebook/react/bridge/JSBundleLoader$1;->val$assetUrl:Ljava/lang/String;

    iget-boolean v2, p0, Lcom/facebook/react/bridge/JSBundleLoader$1;->val$loadSynchronously:Z

    invoke-virtual {p1, v0, v1, v2}, Lcom/facebook/react/bridge/CatalystInstanceImpl;->loadScriptFromAssets(Landroid/content/res/AssetManager;Ljava/lang/String;Z)V

    .line 35
    iget-object v0, p0, Lcom/facebook/react/bridge/JSBundleLoader$1;->val$assetUrl:Ljava/lang/String;

    return-object v0
.end method

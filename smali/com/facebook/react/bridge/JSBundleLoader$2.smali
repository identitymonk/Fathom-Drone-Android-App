.class final Lcom/facebook/react/bridge/JSBundleLoader$2;
.super Lcom/facebook/react/bridge/JSBundleLoader;
.source "JSBundleLoader.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/facebook/react/bridge/JSBundleLoader;->createFileLoader(Ljava/lang/String;Ljava/lang/String;Z)Lcom/facebook/react/bridge/JSBundleLoader;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x8
    name = null
.end annotation


# instance fields
.field final synthetic val$assetUrl:Ljava/lang/String;

.field final synthetic val$fileName:Ljava/lang/String;

.field final synthetic val$loadSynchronously:Z


# direct methods
.method constructor <init>(Ljava/lang/String;Ljava/lang/String;Z)V
    .locals 0

    .prologue
    .line 52
    iput-object p1, p0, Lcom/facebook/react/bridge/JSBundleLoader$2;->val$fileName:Ljava/lang/String;

    iput-object p2, p0, Lcom/facebook/react/bridge/JSBundleLoader$2;->val$assetUrl:Ljava/lang/String;

    iput-boolean p3, p0, Lcom/facebook/react/bridge/JSBundleLoader$2;->val$loadSynchronously:Z

    invoke-direct {p0}, Lcom/facebook/react/bridge/JSBundleLoader;-><init>()V

    return-void
.end method


# virtual methods
.method public loadScript(Lcom/facebook/react/bridge/CatalystInstanceImpl;)Ljava/lang/String;
    .locals 3
    .param p1, "instance"    # Lcom/facebook/react/bridge/CatalystInstanceImpl;

    .prologue
    .line 55
    iget-object v0, p0, Lcom/facebook/react/bridge/JSBundleLoader$2;->val$fileName:Ljava/lang/String;

    iget-object v1, p0, Lcom/facebook/react/bridge/JSBundleLoader$2;->val$assetUrl:Ljava/lang/String;

    iget-boolean v2, p0, Lcom/facebook/react/bridge/JSBundleLoader$2;->val$loadSynchronously:Z

    invoke-virtual {p1, v0, v1, v2}, Lcom/facebook/react/bridge/CatalystInstanceImpl;->loadScriptFromFile(Ljava/lang/String;Ljava/lang/String;Z)V

    .line 56
    iget-object v0, p0, Lcom/facebook/react/bridge/JSBundleLoader$2;->val$fileName:Ljava/lang/String;

    return-object v0
.end method

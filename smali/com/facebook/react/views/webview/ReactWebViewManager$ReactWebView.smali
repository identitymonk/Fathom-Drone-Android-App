.class public Lcom/facebook/react/views/webview/ReactWebViewManager$ReactWebView;
.super Landroid/webkit/WebView;
.source "ReactWebViewManager.java"

# interfaces
.implements Lcom/facebook/react/bridge/LifecycleEventListener;


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/facebook/react/views/webview/ReactWebViewManager;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0xc
    name = "ReactWebView"
.end annotation

.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lcom/facebook/react/views/webview/ReactWebViewManager$ReactWebView$ReactWebViewBridge;
    }
.end annotation


# instance fields
.field protected injectedJS:Ljava/lang/String;
    .annotation runtime Ljavax/annotation/Nullable;
    .end annotation
.end field

.field protected mReactWebViewClient:Lcom/facebook/react/views/webview/ReactWebViewManager$ReactWebViewClient;
    .annotation runtime Ljavax/annotation/Nullable;
    .end annotation
.end field

.field protected messagingEnabled:Z


# direct methods
.method public constructor <init>(Lcom/facebook/react/uimanager/ThemedReactContext;)V
    .locals 1
    .param p1, "reactContext"    # Lcom/facebook/react/uimanager/ThemedReactContext;

    .prologue
    .line 248
    invoke-direct {p0, p1}, Landroid/webkit/WebView;-><init>(Landroid/content/Context;)V

    .line 224
    const/4 v0, 0x0

    iput-boolean v0, p0, Lcom/facebook/react/views/webview/ReactWebViewManager$ReactWebView;->messagingEnabled:Z

    .line 249
    return-void
.end method


# virtual methods
.method public callInjectedJavaScript()V
    .locals 2

    .prologue
    .line 299
    invoke-virtual {p0}, Lcom/facebook/react/views/webview/ReactWebViewManager$ReactWebView;->getSettings()Landroid/webkit/WebSettings;

    move-result-object v0

    invoke-virtual {v0}, Landroid/webkit/WebSettings;->getJavaScriptEnabled()Z

    move-result v0

    if-eqz v0, :cond_0

    iget-object v0, p0, Lcom/facebook/react/views/webview/ReactWebViewManager$ReactWebView;->injectedJS:Ljava/lang/String;

    if-eqz v0, :cond_0

    iget-object v0, p0, Lcom/facebook/react/views/webview/ReactWebViewManager$ReactWebView;->injectedJS:Ljava/lang/String;

    .line 301
    invoke-static {v0}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result v0

    if-nez v0, :cond_0

    .line 302
    new-instance v0, Ljava/lang/StringBuilder;

    invoke-direct {v0}, Ljava/lang/StringBuilder;-><init>()V

    const-string v1, "javascript:(function() {\n"

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    iget-object v1, p0, Lcom/facebook/react/views/webview/ReactWebViewManager$ReactWebView;->injectedJS:Ljava/lang/String;

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    const-string v1, ";\n})();"

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    invoke-virtual {p0, v0}, Lcom/facebook/react/views/webview/ReactWebViewManager$ReactWebView;->loadUrl(Ljava/lang/String;)V

    .line 304
    :cond_0
    return-void
.end method

.method protected cleanupCallbacksAndDestroy()V
    .locals 1

    .prologue
    .line 335
    const/4 v0, 0x0

    invoke-virtual {p0, v0}, Lcom/facebook/react/views/webview/ReactWebViewManager$ReactWebView;->setWebViewClient(Landroid/webkit/WebViewClient;)V

    .line 336
    invoke-virtual {p0}, Lcom/facebook/react/views/webview/ReactWebViewManager$ReactWebView;->destroy()V

    .line 337
    return-void
.end method

.method protected createReactWebViewBridge(Lcom/facebook/react/views/webview/ReactWebViewManager$ReactWebView;)Lcom/facebook/react/views/webview/ReactWebViewManager$ReactWebView$ReactWebViewBridge;
    .locals 1
    .param p1, "webView"    # Lcom/facebook/react/views/webview/ReactWebViewManager$ReactWebView;

    .prologue
    .line 281
    new-instance v0, Lcom/facebook/react/views/webview/ReactWebViewManager$ReactWebView$ReactWebViewBridge;

    invoke-direct {v0, p0, p1}, Lcom/facebook/react/views/webview/ReactWebViewManager$ReactWebView$ReactWebViewBridge;-><init>(Lcom/facebook/react/views/webview/ReactWebViewManager$ReactWebView;Lcom/facebook/react/views/webview/ReactWebViewManager$ReactWebView;)V

    return-object v0
.end method

.method public getReactWebViewClient()Lcom/facebook/react/views/webview/ReactWebViewManager$ReactWebViewClient;
    .locals 1
    .annotation runtime Ljavax/annotation/Nullable;
    .end annotation

    .prologue
    .line 273
    iget-object v0, p0, Lcom/facebook/react/views/webview/ReactWebViewManager$ReactWebView;->mReactWebViewClient:Lcom/facebook/react/views/webview/ReactWebViewManager$ReactWebViewClient;

    return-object v0
.end method

.method public linkBridge()V
    .locals 1

    .prologue
    .line 307
    iget-boolean v0, p0, Lcom/facebook/react/views/webview/ReactWebViewManager$ReactWebView;->messagingEnabled:Z

    if-eqz v0, :cond_0

    .line 321
    const-string v0, "javascript:(window.originalPostMessage = window.postMessage,window.postMessage = function(data) {__REACT_WEB_VIEW_BRIDGE.postMessage(String(data));})"

    invoke-virtual {p0, v0}, Lcom/facebook/react/views/webview/ReactWebViewManager$ReactWebView;->loadUrl(Ljava/lang/String;)V

    .line 328
    :cond_0
    return-void
.end method

.method public onHostDestroy()V
    .locals 0

    .prologue
    .line 263
    invoke-virtual {p0}, Lcom/facebook/react/views/webview/ReactWebViewManager$ReactWebView;->cleanupCallbacksAndDestroy()V

    .line 264
    return-void
.end method

.method public onHostPause()V
    .locals 0

    .prologue
    .line 259
    return-void
.end method

.method public onHostResume()V
    .locals 0

    .prologue
    .line 254
    return-void
.end method

.method public onMessage(Ljava/lang/String;)V
    .locals 2
    .param p1, "message"    # Ljava/lang/String;

    .prologue
    .line 331
    new-instance v0, Lcom/facebook/react/views/webview/events/TopMessageEvent;

    invoke-virtual {p0}, Lcom/facebook/react/views/webview/ReactWebViewManager$ReactWebView;->getId()I

    move-result v1

    invoke-direct {v0, v1, p1}, Lcom/facebook/react/views/webview/events/TopMessageEvent;-><init>(ILjava/lang/String;)V

    invoke-static {p0, v0}, Lcom/facebook/react/views/webview/ReactWebViewManager;->dispatchEvent(Landroid/webkit/WebView;Lcom/facebook/react/uimanager/events/Event;)V

    .line 332
    return-void
.end method

.method public setInjectedJavaScript(Ljava/lang/String;)V
    .locals 0
    .param p1, "js"    # Ljava/lang/String;
        .annotation runtime Ljavax/annotation/Nullable;
        .end annotation
    .end param

    .prologue
    .line 277
    iput-object p1, p0, Lcom/facebook/react/views/webview/ReactWebViewManager$ReactWebView;->injectedJS:Ljava/lang/String;

    .line 278
    return-void
.end method

.method public setMessagingEnabled(Z)V
    .locals 2
    .param p1, "enabled"    # Z

    .prologue
    .line 285
    iget-boolean v0, p0, Lcom/facebook/react/views/webview/ReactWebViewManager$ReactWebView;->messagingEnabled:Z

    if-ne v0, p1, :cond_0

    .line 296
    :goto_0
    return-void

    .line 289
    :cond_0
    iput-boolean p1, p0, Lcom/facebook/react/views/webview/ReactWebViewManager$ReactWebView;->messagingEnabled:Z

    .line 290
    if-eqz p1, :cond_1

    .line 291
    invoke-virtual {p0, p0}, Lcom/facebook/react/views/webview/ReactWebViewManager$ReactWebView;->createReactWebViewBridge(Lcom/facebook/react/views/webview/ReactWebViewManager$ReactWebView;)Lcom/facebook/react/views/webview/ReactWebViewManager$ReactWebView$ReactWebViewBridge;

    move-result-object v0

    const-string v1, "__REACT_WEB_VIEW_BRIDGE"

    invoke-virtual {p0, v0, v1}, Lcom/facebook/react/views/webview/ReactWebViewManager$ReactWebView;->addJavascriptInterface(Ljava/lang/Object;Ljava/lang/String;)V

    .line 292
    invoke-virtual {p0}, Lcom/facebook/react/views/webview/ReactWebViewManager$ReactWebView;->linkBridge()V

    goto :goto_0

    .line 294
    :cond_1
    const-string v0, "__REACT_WEB_VIEW_BRIDGE"

    invoke-virtual {p0, v0}, Lcom/facebook/react/views/webview/ReactWebViewManager$ReactWebView;->removeJavascriptInterface(Ljava/lang/String;)V

    goto :goto_0
.end method

.method public setWebViewClient(Landroid/webkit/WebViewClient;)V
    .locals 0
    .param p1, "client"    # Landroid/webkit/WebViewClient;

    .prologue
    .line 268
    invoke-super {p0, p1}, Landroid/webkit/WebView;->setWebViewClient(Landroid/webkit/WebViewClient;)V

    .line 269
    check-cast p1, Lcom/facebook/react/views/webview/ReactWebViewManager$ReactWebViewClient;

    .end local p1    # "client":Landroid/webkit/WebViewClient;
    iput-object p1, p0, Lcom/facebook/react/views/webview/ReactWebViewManager$ReactWebView;->mReactWebViewClient:Lcom/facebook/react/views/webview/ReactWebViewManager$ReactWebViewClient;

    .line 270
    return-void
.end method

.class Lcom/facebook/react/views/webview/ReactWebViewManager$1;
.super Ljava/lang/Object;
.source "ReactWebViewManager.java"

# interfaces
.implements Lcom/facebook/react/views/webview/WebViewConfig;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/facebook/react/views/webview/ReactWebViewManager;-><init>()V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$0:Lcom/facebook/react/views/webview/ReactWebViewManager;


# direct methods
.method constructor <init>(Lcom/facebook/react/views/webview/ReactWebViewManager;)V
    .locals 0
    .param p1, "this$0"    # Lcom/facebook/react/views/webview/ReactWebViewManager;

    .prologue
    .line 341
    iput-object p1, p0, Lcom/facebook/react/views/webview/ReactWebViewManager$1;->this$0:Lcom/facebook/react/views/webview/ReactWebViewManager;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public configWebView(Landroid/webkit/WebView;)V
    .locals 0
    .param p1, "webView"    # Landroid/webkit/WebView;

    .prologue
    .line 343
    return-void
.end method

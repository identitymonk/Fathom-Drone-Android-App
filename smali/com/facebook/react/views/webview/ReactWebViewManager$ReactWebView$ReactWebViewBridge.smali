.class public Lcom/facebook/react/views/webview/ReactWebViewManager$ReactWebView$ReactWebViewBridge;
.super Ljava/lang/Object;
.source "ReactWebViewManager.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/facebook/react/views/webview/ReactWebViewManager$ReactWebView;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x4
    name = "ReactWebViewBridge"
.end annotation


# instance fields
.field mContext:Lcom/facebook/react/views/webview/ReactWebViewManager$ReactWebView;

.field final synthetic this$0:Lcom/facebook/react/views/webview/ReactWebViewManager$ReactWebView;


# direct methods
.method constructor <init>(Lcom/facebook/react/views/webview/ReactWebViewManager$ReactWebView;Lcom/facebook/react/views/webview/ReactWebViewManager$ReactWebView;)V
    .locals 0
    .param p1, "this$0"    # Lcom/facebook/react/views/webview/ReactWebViewManager$ReactWebView;
    .param p2, "c"    # Lcom/facebook/react/views/webview/ReactWebViewManager$ReactWebView;

    .prologue
    .line 230
    iput-object p1, p0, Lcom/facebook/react/views/webview/ReactWebViewManager$ReactWebView$ReactWebViewBridge;->this$0:Lcom/facebook/react/views/webview/ReactWebViewManager$ReactWebView;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 231
    iput-object p2, p0, Lcom/facebook/react/views/webview/ReactWebViewManager$ReactWebView$ReactWebViewBridge;->mContext:Lcom/facebook/react/views/webview/ReactWebViewManager$ReactWebView;

    .line 232
    return-void
.end method


# virtual methods
.method public postMessage(Ljava/lang/String;)V
    .locals 1
    .param p1, "message"    # Ljava/lang/String;
    .annotation runtime Landroid/webkit/JavascriptInterface;
    .end annotation

    .prologue
    .line 236
    iget-object v0, p0, Lcom/facebook/react/views/webview/ReactWebViewManager$ReactWebView$ReactWebViewBridge;->mContext:Lcom/facebook/react/views/webview/ReactWebViewManager$ReactWebView;

    invoke-virtual {v0, p1}, Lcom/facebook/react/views/webview/ReactWebViewManager$ReactWebView;->onMessage(Ljava/lang/String;)V

    .line 237
    return-void
.end method

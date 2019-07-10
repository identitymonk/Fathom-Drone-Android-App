.class Lcom/facebook/react/views/webview/ReactWebViewManager$3;
.super Ljava/lang/Object;
.source "ReactWebViewManager.java"

# interfaces
.implements Landroid/webkit/WebView$PictureListener;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/facebook/react/views/webview/ReactWebViewManager;->getPictureListener()Landroid/webkit/WebView$PictureListener;
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
    .line 610
    iput-object p1, p0, Lcom/facebook/react/views/webview/ReactWebViewManager$3;->this$0:Lcom/facebook/react/views/webview/ReactWebViewManager;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public onNewPicture(Landroid/webkit/WebView;Landroid/graphics/Picture;)V
    .locals 4
    .param p1, "webView"    # Landroid/webkit/WebView;
    .param p2, "picture"    # Landroid/graphics/Picture;

    .prologue
    .line 613
    new-instance v0, Lcom/facebook/react/uimanager/events/ContentSizeChangeEvent;

    .line 616
    invoke-virtual {p1}, Landroid/webkit/WebView;->getId()I

    move-result v1

    .line 617
    invoke-virtual {p1}, Landroid/webkit/WebView;->getWidth()I

    move-result v2

    .line 618
    invoke-virtual {p1}, Landroid/webkit/WebView;->getContentHeight()I

    move-result v3

    invoke-direct {v0, v1, v2, v3}, Lcom/facebook/react/uimanager/events/ContentSizeChangeEvent;-><init>(III)V

    .line 613
    invoke-static {p1, v0}, Lcom/facebook/react/views/webview/ReactWebViewManager;->dispatchEvent(Landroid/webkit/WebView;Lcom/facebook/react/uimanager/events/Event;)V

    .line 619
    return-void
.end method

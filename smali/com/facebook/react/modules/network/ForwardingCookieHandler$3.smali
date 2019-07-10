.class Lcom/facebook/react/modules/network/ForwardingCookieHandler$3;
.super Ljava/lang/Object;
.source "ForwardingCookieHandler.java"

# interfaces
.implements Ljava/lang/Runnable;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/facebook/react/modules/network/ForwardingCookieHandler;->addCookies(Ljava/lang/String;Ljava/util/List;)V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$0:Lcom/facebook/react/modules/network/ForwardingCookieHandler;

.field final synthetic val$cookies:Ljava/util/List;

.field final synthetic val$url:Ljava/lang/String;


# direct methods
.method constructor <init>(Lcom/facebook/react/modules/network/ForwardingCookieHandler;Ljava/util/List;Ljava/lang/String;)V
    .locals 0
    .param p1, "this$0"    # Lcom/facebook/react/modules/network/ForwardingCookieHandler;

    .prologue
    .line 116
    iput-object p1, p0, Lcom/facebook/react/modules/network/ForwardingCookieHandler$3;->this$0:Lcom/facebook/react/modules/network/ForwardingCookieHandler;

    iput-object p2, p0, Lcom/facebook/react/modules/network/ForwardingCookieHandler$3;->val$cookies:Ljava/util/List;

    iput-object p3, p0, Lcom/facebook/react/modules/network/ForwardingCookieHandler$3;->val$url:Ljava/lang/String;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public run()V
    .locals 4

    .prologue
    .line 119
    iget-object v1, p0, Lcom/facebook/react/modules/network/ForwardingCookieHandler$3;->val$cookies:Ljava/util/List;

    invoke-interface {v1}, Ljava/util/List;->iterator()Ljava/util/Iterator;

    move-result-object v1

    :goto_0
    invoke-interface {v1}, Ljava/util/Iterator;->hasNext()Z

    move-result v2

    if-eqz v2, :cond_0

    invoke-interface {v1}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Ljava/lang/String;

    .line 120
    .local v0, "cookie":Ljava/lang/String;
    iget-object v2, p0, Lcom/facebook/react/modules/network/ForwardingCookieHandler$3;->this$0:Lcom/facebook/react/modules/network/ForwardingCookieHandler;

    invoke-static {v2}, Lcom/facebook/react/modules/network/ForwardingCookieHandler;->access$000(Lcom/facebook/react/modules/network/ForwardingCookieHandler;)Landroid/webkit/CookieManager;

    move-result-object v2

    iget-object v3, p0, Lcom/facebook/react/modules/network/ForwardingCookieHandler$3;->val$url:Ljava/lang/String;

    invoke-virtual {v2, v3, v0}, Landroid/webkit/CookieManager;->setCookie(Ljava/lang/String;Ljava/lang/String;)V

    goto :goto_0

    .line 122
    .end local v0    # "cookie":Ljava/lang/String;
    :cond_0
    iget-object v1, p0, Lcom/facebook/react/modules/network/ForwardingCookieHandler$3;->this$0:Lcom/facebook/react/modules/network/ForwardingCookieHandler;

    invoke-static {v1}, Lcom/facebook/react/modules/network/ForwardingCookieHandler;->access$100(Lcom/facebook/react/modules/network/ForwardingCookieHandler;)Lcom/facebook/react/modules/network/ForwardingCookieHandler$CookieSaver;

    move-result-object v1

    invoke-virtual {v1}, Lcom/facebook/react/modules/network/ForwardingCookieHandler$CookieSaver;->onCookiesModified()V

    .line 123
    return-void
.end method

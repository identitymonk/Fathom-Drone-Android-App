.class Lcom/facebook/react/modules/network/ForwardingCookieHandler$CookieSaver$2;
.super Ljava/lang/Object;
.source "ForwardingCookieHandler.java"

# interfaces
.implements Ljava/lang/Runnable;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/facebook/react/modules/network/ForwardingCookieHandler$CookieSaver;->persistCookies()V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$1:Lcom/facebook/react/modules/network/ForwardingCookieHandler$CookieSaver;


# direct methods
.method constructor <init>(Lcom/facebook/react/modules/network/ForwardingCookieHandler$CookieSaver;)V
    .locals 0
    .param p1, "this$1"    # Lcom/facebook/react/modules/network/ForwardingCookieHandler$CookieSaver;

    .prologue
    .line 212
    iput-object p1, p0, Lcom/facebook/react/modules/network/ForwardingCookieHandler$CookieSaver$2;->this$1:Lcom/facebook/react/modules/network/ForwardingCookieHandler$CookieSaver;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public run()V
    .locals 2

    .prologue
    .line 215
    invoke-static {}, Lcom/facebook/react/modules/network/ForwardingCookieHandler;->access$200()Z

    move-result v1

    if-eqz v1, :cond_0

    .line 216
    invoke-static {}, Landroid/webkit/CookieSyncManager;->getInstance()Landroid/webkit/CookieSyncManager;

    move-result-object v0

    .line 217
    .local v0, "syncManager":Landroid/webkit/CookieSyncManager;
    invoke-virtual {v0}, Landroid/webkit/CookieSyncManager;->sync()V

    .line 221
    .end local v0    # "syncManager":Landroid/webkit/CookieSyncManager;
    :goto_0
    return-void

    .line 219
    :cond_0
    iget-object v1, p0, Lcom/facebook/react/modules/network/ForwardingCookieHandler$CookieSaver$2;->this$1:Lcom/facebook/react/modules/network/ForwardingCookieHandler$CookieSaver;

    invoke-static {v1}, Lcom/facebook/react/modules/network/ForwardingCookieHandler$CookieSaver;->access$300(Lcom/facebook/react/modules/network/ForwardingCookieHandler$CookieSaver;)V

    goto :goto_0
.end method

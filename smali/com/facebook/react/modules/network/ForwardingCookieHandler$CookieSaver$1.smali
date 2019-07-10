.class Lcom/facebook/react/modules/network/ForwardingCookieHandler$CookieSaver$1;
.super Ljava/lang/Object;
.source "ForwardingCookieHandler.java"

# interfaces
.implements Landroid/os/Handler$Callback;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/facebook/react/modules/network/ForwardingCookieHandler$CookieSaver;-><init>(Lcom/facebook/react/modules/network/ForwardingCookieHandler;)V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$1:Lcom/facebook/react/modules/network/ForwardingCookieHandler$CookieSaver;

.field final synthetic val$this$0:Lcom/facebook/react/modules/network/ForwardingCookieHandler;


# direct methods
.method constructor <init>(Lcom/facebook/react/modules/network/ForwardingCookieHandler$CookieSaver;Lcom/facebook/react/modules/network/ForwardingCookieHandler;)V
    .locals 0
    .param p1, "this$1"    # Lcom/facebook/react/modules/network/ForwardingCookieHandler$CookieSaver;

    .prologue
    .line 190
    iput-object p1, p0, Lcom/facebook/react/modules/network/ForwardingCookieHandler$CookieSaver$1;->this$1:Lcom/facebook/react/modules/network/ForwardingCookieHandler$CookieSaver;

    iput-object p2, p0, Lcom/facebook/react/modules/network/ForwardingCookieHandler$CookieSaver$1;->val$this$0:Lcom/facebook/react/modules/network/ForwardingCookieHandler;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public handleMessage(Landroid/os/Message;)Z
    .locals 2
    .param p1, "msg"    # Landroid/os/Message;

    .prologue
    const/4 v0, 0x1

    .line 193
    iget v1, p1, Landroid/os/Message;->what:I

    if-ne v1, v0, :cond_0

    .line 194
    iget-object v1, p0, Lcom/facebook/react/modules/network/ForwardingCookieHandler$CookieSaver$1;->this$1:Lcom/facebook/react/modules/network/ForwardingCookieHandler$CookieSaver;

    invoke-virtual {v1}, Lcom/facebook/react/modules/network/ForwardingCookieHandler$CookieSaver;->persistCookies()V

    .line 197
    :goto_0
    return v0

    :cond_0
    const/4 v0, 0x0

    goto :goto_0
.end method

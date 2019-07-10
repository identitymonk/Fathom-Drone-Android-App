.class Lcom/facebook/react/packagerconnection/ReconnectingWebSocket$1;
.super Ljava/lang/Object;
.source "ReconnectingWebSocket.java"

# interfaces
.implements Ljava/lang/Runnable;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/facebook/react/packagerconnection/ReconnectingWebSocket;->reconnect()V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$0:Lcom/facebook/react/packagerconnection/ReconnectingWebSocket;


# direct methods
.method constructor <init>(Lcom/facebook/react/packagerconnection/ReconnectingWebSocket;)V
    .locals 0
    .param p1, "this$0"    # Lcom/facebook/react/packagerconnection/ReconnectingWebSocket;

    .prologue
    .line 99
    iput-object p1, p0, Lcom/facebook/react/packagerconnection/ReconnectingWebSocket$1;->this$0:Lcom/facebook/react/packagerconnection/ReconnectingWebSocket;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public run()V
    .locals 1

    .prologue
    .line 102
    iget-object v0, p0, Lcom/facebook/react/packagerconnection/ReconnectingWebSocket$1;->this$0:Lcom/facebook/react/packagerconnection/ReconnectingWebSocket;

    invoke-static {v0}, Lcom/facebook/react/packagerconnection/ReconnectingWebSocket;->access$000(Lcom/facebook/react/packagerconnection/ReconnectingWebSocket;)V

    .line 103
    return-void
.end method

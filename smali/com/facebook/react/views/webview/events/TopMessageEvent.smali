.class public Lcom/facebook/react/views/webview/events/TopMessageEvent;
.super Lcom/facebook/react/uimanager/events/Event;
.source "TopMessageEvent.java"


# annotations
.annotation system Ldalvik/annotation/Signature;
    value = {
        "Lcom/facebook/react/uimanager/events/Event",
        "<",
        "Lcom/facebook/react/views/webview/events/TopMessageEvent;",
        ">;"
    }
.end annotation


# static fields
.field public static final EVENT_NAME:Ljava/lang/String; = "topMessage"


# instance fields
.field private final mData:Ljava/lang/String;


# direct methods
.method public constructor <init>(ILjava/lang/String;)V
    .locals 0
    .param p1, "viewId"    # I
    .param p2, "data"    # Ljava/lang/String;

    .prologue
    .line 26
    invoke-direct {p0, p1}, Lcom/facebook/react/uimanager/events/Event;-><init>(I)V

    .line 27
    iput-object p2, p0, Lcom/facebook/react/views/webview/events/TopMessageEvent;->mData:Ljava/lang/String;

    .line 28
    return-void
.end method


# virtual methods
.method public canCoalesce()Z
    .locals 1

    .prologue
    .line 37
    const/4 v0, 0x0

    return v0
.end method

.method public dispatch(Lcom/facebook/react/uimanager/events/RCTEventEmitter;)V
    .locals 3
    .param p1, "rctEventEmitter"    # Lcom/facebook/react/uimanager/events/RCTEventEmitter;

    .prologue
    .line 48
    invoke-static {}, Lcom/facebook/react/bridge/Arguments;->createMap()Lcom/facebook/react/bridge/WritableMap;

    move-result-object v0

    .line 49
    .local v0, "data":Lcom/facebook/react/bridge/WritableMap;
    const-string v1, "data"

    iget-object v2, p0, Lcom/facebook/react/views/webview/events/TopMessageEvent;->mData:Ljava/lang/String;

    invoke-interface {v0, v1, v2}, Lcom/facebook/react/bridge/WritableMap;->putString(Ljava/lang/String;Ljava/lang/String;)V

    .line 50
    invoke-virtual {p0}, Lcom/facebook/react/views/webview/events/TopMessageEvent;->getViewTag()I

    move-result v1

    const-string v2, "topMessage"

    invoke-interface {p1, v1, v2, v0}, Lcom/facebook/react/uimanager/events/RCTEventEmitter;->receiveEvent(ILjava/lang/String;Lcom/facebook/react/bridge/WritableMap;)V

    .line 51
    return-void
.end method

.method public getCoalescingKey()S
    .locals 1

    .prologue
    .line 43
    const/4 v0, 0x0

    return v0
.end method

.method public getEventName()Ljava/lang/String;
    .locals 1

    .prologue
    .line 32
    const-string v0, "topMessage"

    return-object v0
.end method

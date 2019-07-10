.class Lcom/facebook/react/views/checkbox/ReactCheckBoxEvent;
.super Lcom/facebook/react/uimanager/events/Event;
.source "ReactCheckBoxEvent.java"


# annotations
.annotation system Ldalvik/annotation/Signature;
    value = {
        "Lcom/facebook/react/uimanager/events/Event",
        "<",
        "Lcom/facebook/react/views/checkbox/ReactCheckBoxEvent;",
        ">;"
    }
.end annotation


# static fields
.field public static final EVENT_NAME:Ljava/lang/String; = "topChange"


# instance fields
.field private final mIsChecked:Z


# direct methods
.method public constructor <init>(IZ)V
    .locals 0
    .param p1, "viewId"    # I
    .param p2, "isChecked"    # Z

    .prologue
    .line 23
    invoke-direct {p0, p1}, Lcom/facebook/react/uimanager/events/Event;-><init>(I)V

    .line 24
    iput-boolean p2, p0, Lcom/facebook/react/views/checkbox/ReactCheckBoxEvent;->mIsChecked:Z

    .line 25
    return-void
.end method

.method private serializeEventData()Lcom/facebook/react/bridge/WritableMap;
    .locals 3

    .prologue
    .line 48
    invoke-static {}, Lcom/facebook/react/bridge/Arguments;->createMap()Lcom/facebook/react/bridge/WritableMap;

    move-result-object v0

    .line 49
    .local v0, "eventData":Lcom/facebook/react/bridge/WritableMap;
    const-string v1, "target"

    invoke-virtual {p0}, Lcom/facebook/react/views/checkbox/ReactCheckBoxEvent;->getViewTag()I

    move-result v2

    invoke-interface {v0, v1, v2}, Lcom/facebook/react/bridge/WritableMap;->putInt(Ljava/lang/String;I)V

    .line 50
    const-string v1, "value"

    invoke-virtual {p0}, Lcom/facebook/react/views/checkbox/ReactCheckBoxEvent;->getIsChecked()Z

    move-result v2

    invoke-interface {v0, v1, v2}, Lcom/facebook/react/bridge/WritableMap;->putBoolean(Ljava/lang/String;Z)V

    .line 51
    return-object v0
.end method


# virtual methods
.method public dispatch(Lcom/facebook/react/uimanager/events/RCTEventEmitter;)V
    .locals 3
    .param p1, "rctEventEmitter"    # Lcom/facebook/react/uimanager/events/RCTEventEmitter;

    .prologue
    .line 44
    invoke-virtual {p0}, Lcom/facebook/react/views/checkbox/ReactCheckBoxEvent;->getViewTag()I

    move-result v0

    invoke-virtual {p0}, Lcom/facebook/react/views/checkbox/ReactCheckBoxEvent;->getEventName()Ljava/lang/String;

    move-result-object v1

    invoke-direct {p0}, Lcom/facebook/react/views/checkbox/ReactCheckBoxEvent;->serializeEventData()Lcom/facebook/react/bridge/WritableMap;

    move-result-object v2

    invoke-interface {p1, v0, v1, v2}, Lcom/facebook/react/uimanager/events/RCTEventEmitter;->receiveEvent(ILjava/lang/String;Lcom/facebook/react/bridge/WritableMap;)V

    .line 45
    return-void
.end method

.method public getCoalescingKey()S
    .locals 1

    .prologue
    .line 39
    const/4 v0, 0x0

    return v0
.end method

.method public getEventName()Ljava/lang/String;
    .locals 1

    .prologue
    .line 33
    const-string v0, "topChange"

    return-object v0
.end method

.method public getIsChecked()Z
    .locals 1

    .prologue
    .line 28
    iget-boolean v0, p0, Lcom/facebook/react/views/checkbox/ReactCheckBoxEvent;->mIsChecked:Z

    return v0
.end method

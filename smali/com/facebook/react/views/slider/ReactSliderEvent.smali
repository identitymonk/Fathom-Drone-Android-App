.class public Lcom/facebook/react/views/slider/ReactSliderEvent;
.super Lcom/facebook/react/uimanager/events/Event;
.source "ReactSliderEvent.java"


# annotations
.annotation system Ldalvik/annotation/Signature;
    value = {
        "Lcom/facebook/react/uimanager/events/Event",
        "<",
        "Lcom/facebook/react/views/slider/ReactSliderEvent;",
        ">;"
    }
.end annotation


# static fields
.field public static final EVENT_NAME:Ljava/lang/String; = "topChange"


# instance fields
.field private final mFromUser:Z

.field private final mValue:D


# direct methods
.method public constructor <init>(IDZ)V
    .locals 0
    .param p1, "viewId"    # I
    .param p2, "value"    # D
    .param p4, "fromUser"    # Z

    .prologue
    .line 28
    invoke-direct {p0, p1}, Lcom/facebook/react/uimanager/events/Event;-><init>(I)V

    .line 29
    iput-wide p2, p0, Lcom/facebook/react/views/slider/ReactSliderEvent;->mValue:D

    .line 30
    iput-boolean p4, p0, Lcom/facebook/react/views/slider/ReactSliderEvent;->mFromUser:Z

    .line 31
    return-void
.end method

.method private serializeEventData()Lcom/facebook/react/bridge/WritableMap;
    .locals 4

    .prologue
    .line 57
    invoke-static {}, Lcom/facebook/react/bridge/Arguments;->createMap()Lcom/facebook/react/bridge/WritableMap;

    move-result-object v0

    .line 58
    .local v0, "eventData":Lcom/facebook/react/bridge/WritableMap;
    const-string v1, "target"

    invoke-virtual {p0}, Lcom/facebook/react/views/slider/ReactSliderEvent;->getViewTag()I

    move-result v2

    invoke-interface {v0, v1, v2}, Lcom/facebook/react/bridge/WritableMap;->putInt(Ljava/lang/String;I)V

    .line 59
    const-string v1, "value"

    invoke-virtual {p0}, Lcom/facebook/react/views/slider/ReactSliderEvent;->getValue()D

    move-result-wide v2

    invoke-interface {v0, v1, v2, v3}, Lcom/facebook/react/bridge/WritableMap;->putDouble(Ljava/lang/String;D)V

    .line 60
    const-string v1, "fromUser"

    invoke-virtual {p0}, Lcom/facebook/react/views/slider/ReactSliderEvent;->isFromUser()Z

    move-result v2

    invoke-interface {v0, v1, v2}, Lcom/facebook/react/bridge/WritableMap;->putBoolean(Ljava/lang/String;Z)V

    .line 61
    return-object v0
.end method


# virtual methods
.method public dispatch(Lcom/facebook/react/uimanager/events/RCTEventEmitter;)V
    .locals 3
    .param p1, "rctEventEmitter"    # Lcom/facebook/react/uimanager/events/RCTEventEmitter;

    .prologue
    .line 53
    invoke-virtual {p0}, Lcom/facebook/react/views/slider/ReactSliderEvent;->getViewTag()I

    move-result v0

    invoke-virtual {p0}, Lcom/facebook/react/views/slider/ReactSliderEvent;->getEventName()Ljava/lang/String;

    move-result-object v1

    invoke-direct {p0}, Lcom/facebook/react/views/slider/ReactSliderEvent;->serializeEventData()Lcom/facebook/react/bridge/WritableMap;

    move-result-object v2

    invoke-interface {p1, v0, v1, v2}, Lcom/facebook/react/uimanager/events/RCTEventEmitter;->receiveEvent(ILjava/lang/String;Lcom/facebook/react/bridge/WritableMap;)V

    .line 54
    return-void
.end method

.method public getCoalescingKey()S
    .locals 1

    .prologue
    .line 49
    const/4 v0, 0x0

    return v0
.end method

.method public getEventName()Ljava/lang/String;
    .locals 1

    .prologue
    .line 44
    const-string v0, "topChange"

    return-object v0
.end method

.method public getValue()D
    .locals 2

    .prologue
    .line 34
    iget-wide v0, p0, Lcom/facebook/react/views/slider/ReactSliderEvent;->mValue:D

    return-wide v0
.end method

.method public isFromUser()Z
    .locals 1

    .prologue
    .line 38
    iget-boolean v0, p0, Lcom/facebook/react/views/slider/ReactSliderEvent;->mFromUser:Z

    return v0
.end method

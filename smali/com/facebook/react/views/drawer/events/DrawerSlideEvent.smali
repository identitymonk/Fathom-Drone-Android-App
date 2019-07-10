.class public Lcom/facebook/react/views/drawer/events/DrawerSlideEvent;
.super Lcom/facebook/react/uimanager/events/Event;
.source "DrawerSlideEvent.java"


# annotations
.annotation system Ldalvik/annotation/Signature;
    value = {
        "Lcom/facebook/react/uimanager/events/Event",
        "<",
        "Lcom/facebook/react/views/drawer/events/DrawerSlideEvent;",
        ">;"
    }
.end annotation


# static fields
.field public static final EVENT_NAME:Ljava/lang/String; = "topDrawerSlide"


# instance fields
.field private final mOffset:F


# direct methods
.method public constructor <init>(IF)V
    .locals 0
    .param p1, "viewId"    # I
    .param p2, "offset"    # F

    .prologue
    .line 27
    invoke-direct {p0, p1}, Lcom/facebook/react/uimanager/events/Event;-><init>(I)V

    .line 28
    iput p2, p0, Lcom/facebook/react/views/drawer/events/DrawerSlideEvent;->mOffset:F

    .line 29
    return-void
.end method

.method private serializeEventData()Lcom/facebook/react/bridge/WritableMap;
    .locals 4

    .prologue
    .line 52
    invoke-static {}, Lcom/facebook/react/bridge/Arguments;->createMap()Lcom/facebook/react/bridge/WritableMap;

    move-result-object v0

    .line 53
    .local v0, "eventData":Lcom/facebook/react/bridge/WritableMap;
    const-string v1, "offset"

    invoke-virtual {p0}, Lcom/facebook/react/views/drawer/events/DrawerSlideEvent;->getOffset()F

    move-result v2

    float-to-double v2, v2

    invoke-interface {v0, v1, v2, v3}, Lcom/facebook/react/bridge/WritableMap;->putDouble(Ljava/lang/String;D)V

    .line 54
    return-object v0
.end method


# virtual methods
.method public dispatch(Lcom/facebook/react/uimanager/events/RCTEventEmitter;)V
    .locals 3
    .param p1, "rctEventEmitter"    # Lcom/facebook/react/uimanager/events/RCTEventEmitter;

    .prologue
    .line 48
    invoke-virtual {p0}, Lcom/facebook/react/views/drawer/events/DrawerSlideEvent;->getViewTag()I

    move-result v0

    invoke-virtual {p0}, Lcom/facebook/react/views/drawer/events/DrawerSlideEvent;->getEventName()Ljava/lang/String;

    move-result-object v1

    invoke-direct {p0}, Lcom/facebook/react/views/drawer/events/DrawerSlideEvent;->serializeEventData()Lcom/facebook/react/bridge/WritableMap;

    move-result-object v2

    invoke-interface {p1, v0, v1, v2}, Lcom/facebook/react/uimanager/events/RCTEventEmitter;->receiveEvent(ILjava/lang/String;Lcom/facebook/react/bridge/WritableMap;)V

    .line 49
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
    .line 37
    const-string v0, "topDrawerSlide"

    return-object v0
.end method

.method public getOffset()F
    .locals 1

    .prologue
    .line 32
    iget v0, p0, Lcom/facebook/react/views/drawer/events/DrawerSlideEvent;->mOffset:F

    return v0
.end method

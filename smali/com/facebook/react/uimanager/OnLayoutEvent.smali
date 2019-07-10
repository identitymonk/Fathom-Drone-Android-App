.class public Lcom/facebook/react/uimanager/OnLayoutEvent;
.super Lcom/facebook/react/uimanager/events/Event;
.source "OnLayoutEvent.java"


# annotations
.annotation system Ldalvik/annotation/Signature;
    value = {
        "Lcom/facebook/react/uimanager/events/Event",
        "<",
        "Lcom/facebook/react/uimanager/OnLayoutEvent;",
        ">;"
    }
.end annotation


# static fields
.field private static final EVENTS_POOL:Landroid/support/v4/util/Pools$SynchronizedPool;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Landroid/support/v4/util/Pools$SynchronizedPool",
            "<",
            "Lcom/facebook/react/uimanager/OnLayoutEvent;",
            ">;"
        }
    .end annotation
.end field


# instance fields
.field private mHeight:I

.field private mWidth:I

.field private mX:I

.field private mY:I


# direct methods
.method static constructor <clinit>()V
    .locals 2

    .prologue
    .line 24
    new-instance v0, Landroid/support/v4/util/Pools$SynchronizedPool;

    const/16 v1, 0x14

    invoke-direct {v0, v1}, Landroid/support/v4/util/Pools$SynchronizedPool;-><init>(I)V

    sput-object v0, Lcom/facebook/react/uimanager/OnLayoutEvent;->EVENTS_POOL:Landroid/support/v4/util/Pools$SynchronizedPool;

    return-void
.end method

.method private constructor <init>()V
    .locals 0

    .prologue
    .line 43
    invoke-direct {p0}, Lcom/facebook/react/uimanager/events/Event;-><init>()V

    .line 44
    return-void
.end method

.method public static obtain(IIIII)Lcom/facebook/react/uimanager/OnLayoutEvent;
    .locals 6
    .param p0, "viewTag"    # I
    .param p1, "x"    # I
    .param p2, "y"    # I
    .param p3, "width"    # I
    .param p4, "height"    # I

    .prologue
    .line 30
    sget-object v1, Lcom/facebook/react/uimanager/OnLayoutEvent;->EVENTS_POOL:Landroid/support/v4/util/Pools$SynchronizedPool;

    invoke-virtual {v1}, Landroid/support/v4/util/Pools$SynchronizedPool;->acquire()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/facebook/react/uimanager/OnLayoutEvent;

    .line 31
    .local v0, "event":Lcom/facebook/react/uimanager/OnLayoutEvent;
    if-nez v0, :cond_0

    .line 32
    new-instance v0, Lcom/facebook/react/uimanager/OnLayoutEvent;

    .end local v0    # "event":Lcom/facebook/react/uimanager/OnLayoutEvent;
    invoke-direct {v0}, Lcom/facebook/react/uimanager/OnLayoutEvent;-><init>()V

    .restart local v0    # "event":Lcom/facebook/react/uimanager/OnLayoutEvent;
    :cond_0
    move v1, p0

    move v2, p1

    move v3, p2

    move v4, p3

    move v5, p4

    .line 34
    invoke-virtual/range {v0 .. v5}, Lcom/facebook/react/uimanager/OnLayoutEvent;->init(IIIII)V

    .line 35
    return-object v0
.end method


# virtual methods
.method public dispatch(Lcom/facebook/react/uimanager/events/RCTEventEmitter;)V
    .locals 6
    .param p1, "rctEventEmitter"    # Lcom/facebook/react/uimanager/events/RCTEventEmitter;

    .prologue
    .line 61
    invoke-static {}, Lcom/facebook/react/bridge/Arguments;->createMap()Lcom/facebook/react/bridge/WritableMap;

    move-result-object v1

    .line 62
    .local v1, "layout":Lcom/facebook/react/bridge/WritableMap;
    const-string v2, "x"

    iget v3, p0, Lcom/facebook/react/uimanager/OnLayoutEvent;->mX:I

    int-to-float v3, v3

    invoke-static {v3}, Lcom/facebook/react/uimanager/PixelUtil;->toDIPFromPixel(F)F

    move-result v3

    float-to-double v4, v3

    invoke-interface {v1, v2, v4, v5}, Lcom/facebook/react/bridge/WritableMap;->putDouble(Ljava/lang/String;D)V

    .line 63
    const-string v2, "y"

    iget v3, p0, Lcom/facebook/react/uimanager/OnLayoutEvent;->mY:I

    int-to-float v3, v3

    invoke-static {v3}, Lcom/facebook/react/uimanager/PixelUtil;->toDIPFromPixel(F)F

    move-result v3

    float-to-double v4, v3

    invoke-interface {v1, v2, v4, v5}, Lcom/facebook/react/bridge/WritableMap;->putDouble(Ljava/lang/String;D)V

    .line 64
    const-string v2, "width"

    iget v3, p0, Lcom/facebook/react/uimanager/OnLayoutEvent;->mWidth:I

    int-to-float v3, v3

    invoke-static {v3}, Lcom/facebook/react/uimanager/PixelUtil;->toDIPFromPixel(F)F

    move-result v3

    float-to-double v4, v3

    invoke-interface {v1, v2, v4, v5}, Lcom/facebook/react/bridge/WritableMap;->putDouble(Ljava/lang/String;D)V

    .line 65
    const-string v2, "height"

    iget v3, p0, Lcom/facebook/react/uimanager/OnLayoutEvent;->mHeight:I

    int-to-float v3, v3

    invoke-static {v3}, Lcom/facebook/react/uimanager/PixelUtil;->toDIPFromPixel(F)F

    move-result v3

    float-to-double v4, v3

    invoke-interface {v1, v2, v4, v5}, Lcom/facebook/react/bridge/WritableMap;->putDouble(Ljava/lang/String;D)V

    .line 67
    invoke-static {}, Lcom/facebook/react/bridge/Arguments;->createMap()Lcom/facebook/react/bridge/WritableMap;

    move-result-object v0

    .line 68
    .local v0, "event":Lcom/facebook/react/bridge/WritableMap;
    const-string v2, "layout"

    invoke-interface {v0, v2, v1}, Lcom/facebook/react/bridge/WritableMap;->putMap(Ljava/lang/String;Lcom/facebook/react/bridge/WritableMap;)V

    .line 69
    const-string v2, "target"

    invoke-virtual {p0}, Lcom/facebook/react/uimanager/OnLayoutEvent;->getViewTag()I

    move-result v3

    invoke-interface {v0, v2, v3}, Lcom/facebook/react/bridge/WritableMap;->putInt(Ljava/lang/String;I)V

    .line 71
    invoke-virtual {p0}, Lcom/facebook/react/uimanager/OnLayoutEvent;->getViewTag()I

    move-result v2

    invoke-virtual {p0}, Lcom/facebook/react/uimanager/OnLayoutEvent;->getEventName()Ljava/lang/String;

    move-result-object v3

    invoke-interface {p1, v2, v3, v0}, Lcom/facebook/react/uimanager/events/RCTEventEmitter;->receiveEvent(ILjava/lang/String;Lcom/facebook/react/bridge/WritableMap;)V

    .line 72
    return-void
.end method

.method public getEventName()Ljava/lang/String;
    .locals 1

    .prologue
    .line 56
    const-string v0, "topLayout"

    return-object v0
.end method

.method protected init(IIIII)V
    .locals 0
    .param p1, "viewTag"    # I
    .param p2, "x"    # I
    .param p3, "y"    # I
    .param p4, "width"    # I
    .param p5, "height"    # I

    .prologue
    .line 47
    invoke-super {p0, p1}, Lcom/facebook/react/uimanager/events/Event;->init(I)V

    .line 48
    iput p2, p0, Lcom/facebook/react/uimanager/OnLayoutEvent;->mX:I

    .line 49
    iput p3, p0, Lcom/facebook/react/uimanager/OnLayoutEvent;->mY:I

    .line 50
    iput p4, p0, Lcom/facebook/react/uimanager/OnLayoutEvent;->mWidth:I

    .line 51
    iput p5, p0, Lcom/facebook/react/uimanager/OnLayoutEvent;->mHeight:I

    .line 52
    return-void
.end method

.method public onDispose()V
    .locals 1

    .prologue
    .line 40
    sget-object v0, Lcom/facebook/react/uimanager/OnLayoutEvent;->EVENTS_POOL:Landroid/support/v4/util/Pools$SynchronizedPool;

    invoke-virtual {v0, p0}, Landroid/support/v4/util/Pools$SynchronizedPool;->release(Ljava/lang/Object;)Z

    .line 41
    return-void
.end method

.class public Lcom/facebook/react/views/scroll/ScrollEvent;
.super Lcom/facebook/react/uimanager/events/Event;
.source "ScrollEvent.java"


# annotations
.annotation system Ldalvik/annotation/Signature;
    value = {
        "Lcom/facebook/react/uimanager/events/Event",
        "<",
        "Lcom/facebook/react/views/scroll/ScrollEvent;",
        ">;"
    }
.end annotation


# static fields
.field private static final EVENTS_POOL:Landroid/support/v4/util/Pools$SynchronizedPool;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Landroid/support/v4/util/Pools$SynchronizedPool",
            "<",
            "Lcom/facebook/react/views/scroll/ScrollEvent;",
            ">;"
        }
    .end annotation
.end field


# instance fields
.field private mContentHeight:I

.field private mContentWidth:I

.field private mScrollEventType:Lcom/facebook/react/views/scroll/ScrollEventType;
    .annotation runtime Ljavax/annotation/Nullable;
    .end annotation
.end field

.field private mScrollViewHeight:I

.field private mScrollViewWidth:I

.field private mScrollX:I

.field private mScrollY:I

.field private mXVelocity:D

.field private mYVelocity:D


# direct methods
.method static constructor <clinit>()V
    .locals 2

    .prologue
    .line 30
    new-instance v0, Landroid/support/v4/util/Pools$SynchronizedPool;

    const/4 v1, 0x3

    invoke-direct {v0, v1}, Landroid/support/v4/util/Pools$SynchronizedPool;-><init>(I)V

    sput-object v0, Lcom/facebook/react/views/scroll/ScrollEvent;->EVENTS_POOL:Landroid/support/v4/util/Pools$SynchronizedPool;

    return-void
.end method

.method private constructor <init>()V
    .locals 0

    .prologue
    .line 77
    invoke-direct {p0}, Lcom/facebook/react/uimanager/events/Event;-><init>()V

    .line 78
    return-void
.end method

.method private init(ILcom/facebook/react/views/scroll/ScrollEventType;IIFFIIII)V
    .locals 2
    .param p1, "viewTag"    # I
    .param p2, "scrollEventType"    # Lcom/facebook/react/views/scroll/ScrollEventType;
    .param p3, "scrollX"    # I
    .param p4, "scrollY"    # I
    .param p5, "xVelocity"    # F
    .param p6, "yVelocity"    # F
    .param p7, "contentWidth"    # I
    .param p8, "contentHeight"    # I
    .param p9, "scrollViewWidth"    # I
    .param p10, "scrollViewHeight"    # I

    .prologue
    .line 91
    invoke-super {p0, p1}, Lcom/facebook/react/uimanager/events/Event;->init(I)V

    .line 92
    iput-object p2, p0, Lcom/facebook/react/views/scroll/ScrollEvent;->mScrollEventType:Lcom/facebook/react/views/scroll/ScrollEventType;

    .line 93
    iput p3, p0, Lcom/facebook/react/views/scroll/ScrollEvent;->mScrollX:I

    .line 94
    iput p4, p0, Lcom/facebook/react/views/scroll/ScrollEvent;->mScrollY:I

    .line 95
    float-to-double v0, p5

    iput-wide v0, p0, Lcom/facebook/react/views/scroll/ScrollEvent;->mXVelocity:D

    .line 96
    float-to-double v0, p6

    iput-wide v0, p0, Lcom/facebook/react/views/scroll/ScrollEvent;->mYVelocity:D

    .line 97
    iput p7, p0, Lcom/facebook/react/views/scroll/ScrollEvent;->mContentWidth:I

    .line 98
    iput p8, p0, Lcom/facebook/react/views/scroll/ScrollEvent;->mContentHeight:I

    .line 99
    iput p9, p0, Lcom/facebook/react/views/scroll/ScrollEvent;->mScrollViewWidth:I

    .line 100
    iput p10, p0, Lcom/facebook/react/views/scroll/ScrollEvent;->mScrollViewHeight:I

    .line 101
    return-void
.end method

.method public static obtain(ILcom/facebook/react/views/scroll/ScrollEventType;IIFFIIII)Lcom/facebook/react/views/scroll/ScrollEvent;
    .locals 11
    .param p0, "viewTag"    # I
    .param p1, "scrollEventType"    # Lcom/facebook/react/views/scroll/ScrollEventType;
    .param p2, "scrollX"    # I
    .param p3, "scrollY"    # I
    .param p4, "xVelocity"    # F
    .param p5, "yVelocity"    # F
    .param p6, "contentWidth"    # I
    .param p7, "contentHeight"    # I
    .param p8, "scrollViewWidth"    # I
    .param p9, "scrollViewHeight"    # I

    .prologue
    .line 54
    sget-object v1, Lcom/facebook/react/views/scroll/ScrollEvent;->EVENTS_POOL:Landroid/support/v4/util/Pools$SynchronizedPool;

    invoke-virtual {v1}, Landroid/support/v4/util/Pools$SynchronizedPool;->acquire()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/facebook/react/views/scroll/ScrollEvent;

    .line 55
    .local v0, "event":Lcom/facebook/react/views/scroll/ScrollEvent;
    if-nez v0, :cond_0

    .line 56
    new-instance v0, Lcom/facebook/react/views/scroll/ScrollEvent;

    .end local v0    # "event":Lcom/facebook/react/views/scroll/ScrollEvent;
    invoke-direct {v0}, Lcom/facebook/react/views/scroll/ScrollEvent;-><init>()V

    .restart local v0    # "event":Lcom/facebook/react/views/scroll/ScrollEvent;
    :cond_0
    move v1, p0

    move-object v2, p1

    move v3, p2

    move v4, p3

    move v5, p4

    move/from16 v6, p5

    move/from16 v7, p6

    move/from16 v8, p7

    move/from16 v9, p8

    move/from16 v10, p9

    .line 58
    invoke-direct/range {v0 .. v10}, Lcom/facebook/react/views/scroll/ScrollEvent;->init(ILcom/facebook/react/views/scroll/ScrollEventType;IIFFIIII)V

    .line 69
    return-object v0
.end method

.method private serializeEventData()Lcom/facebook/react/bridge/WritableMap;
    .locals 10

    .prologue
    const-wide/16 v8, 0x0

    .line 129
    invoke-static {}, Lcom/facebook/react/bridge/Arguments;->createMap()Lcom/facebook/react/bridge/WritableMap;

    move-result-object v0

    .line 130
    .local v0, "contentInset":Lcom/facebook/react/bridge/WritableMap;
    const-string v6, "top"

    invoke-interface {v0, v6, v8, v9}, Lcom/facebook/react/bridge/WritableMap;->putDouble(Ljava/lang/String;D)V

    .line 131
    const-string v6, "bottom"

    invoke-interface {v0, v6, v8, v9}, Lcom/facebook/react/bridge/WritableMap;->putDouble(Ljava/lang/String;D)V

    .line 132
    const-string v6, "left"

    invoke-interface {v0, v6, v8, v9}, Lcom/facebook/react/bridge/WritableMap;->putDouble(Ljava/lang/String;D)V

    .line 133
    const-string v6, "right"

    invoke-interface {v0, v6, v8, v9}, Lcom/facebook/react/bridge/WritableMap;->putDouble(Ljava/lang/String;D)V

    .line 135
    invoke-static {}, Lcom/facebook/react/bridge/Arguments;->createMap()Lcom/facebook/react/bridge/WritableMap;

    move-result-object v1

    .line 136
    .local v1, "contentOffset":Lcom/facebook/react/bridge/WritableMap;
    const-string v6, "x"

    iget v7, p0, Lcom/facebook/react/views/scroll/ScrollEvent;->mScrollX:I

    int-to-float v7, v7

    invoke-static {v7}, Lcom/facebook/react/uimanager/PixelUtil;->toDIPFromPixel(F)F

    move-result v7

    float-to-double v8, v7

    invoke-interface {v1, v6, v8, v9}, Lcom/facebook/react/bridge/WritableMap;->putDouble(Ljava/lang/String;D)V

    .line 137
    const-string v6, "y"

    iget v7, p0, Lcom/facebook/react/views/scroll/ScrollEvent;->mScrollY:I

    int-to-float v7, v7

    invoke-static {v7}, Lcom/facebook/react/uimanager/PixelUtil;->toDIPFromPixel(F)F

    move-result v7

    float-to-double v8, v7

    invoke-interface {v1, v6, v8, v9}, Lcom/facebook/react/bridge/WritableMap;->putDouble(Ljava/lang/String;D)V

    .line 139
    invoke-static {}, Lcom/facebook/react/bridge/Arguments;->createMap()Lcom/facebook/react/bridge/WritableMap;

    move-result-object v2

    .line 140
    .local v2, "contentSize":Lcom/facebook/react/bridge/WritableMap;
    const-string v6, "width"

    iget v7, p0, Lcom/facebook/react/views/scroll/ScrollEvent;->mContentWidth:I

    int-to-float v7, v7

    invoke-static {v7}, Lcom/facebook/react/uimanager/PixelUtil;->toDIPFromPixel(F)F

    move-result v7

    float-to-double v8, v7

    invoke-interface {v2, v6, v8, v9}, Lcom/facebook/react/bridge/WritableMap;->putDouble(Ljava/lang/String;D)V

    .line 141
    const-string v6, "height"

    iget v7, p0, Lcom/facebook/react/views/scroll/ScrollEvent;->mContentHeight:I

    int-to-float v7, v7

    invoke-static {v7}, Lcom/facebook/react/uimanager/PixelUtil;->toDIPFromPixel(F)F

    move-result v7

    float-to-double v8, v7

    invoke-interface {v2, v6, v8, v9}, Lcom/facebook/react/bridge/WritableMap;->putDouble(Ljava/lang/String;D)V

    .line 143
    invoke-static {}, Lcom/facebook/react/bridge/Arguments;->createMap()Lcom/facebook/react/bridge/WritableMap;

    move-result-object v4

    .line 144
    .local v4, "layoutMeasurement":Lcom/facebook/react/bridge/WritableMap;
    const-string v6, "width"

    iget v7, p0, Lcom/facebook/react/views/scroll/ScrollEvent;->mScrollViewWidth:I

    int-to-float v7, v7

    invoke-static {v7}, Lcom/facebook/react/uimanager/PixelUtil;->toDIPFromPixel(F)F

    move-result v7

    float-to-double v8, v7

    invoke-interface {v4, v6, v8, v9}, Lcom/facebook/react/bridge/WritableMap;->putDouble(Ljava/lang/String;D)V

    .line 145
    const-string v6, "height"

    iget v7, p0, Lcom/facebook/react/views/scroll/ScrollEvent;->mScrollViewHeight:I

    int-to-float v7, v7

    invoke-static {v7}, Lcom/facebook/react/uimanager/PixelUtil;->toDIPFromPixel(F)F

    move-result v7

    float-to-double v8, v7

    invoke-interface {v4, v6, v8, v9}, Lcom/facebook/react/bridge/WritableMap;->putDouble(Ljava/lang/String;D)V

    .line 147
    invoke-static {}, Lcom/facebook/react/bridge/Arguments;->createMap()Lcom/facebook/react/bridge/WritableMap;

    move-result-object v5

    .line 148
    .local v5, "velocity":Lcom/facebook/react/bridge/WritableMap;
    const-string v6, "x"

    iget-wide v8, p0, Lcom/facebook/react/views/scroll/ScrollEvent;->mXVelocity:D

    invoke-interface {v5, v6, v8, v9}, Lcom/facebook/react/bridge/WritableMap;->putDouble(Ljava/lang/String;D)V

    .line 149
    const-string v6, "y"

    iget-wide v8, p0, Lcom/facebook/react/views/scroll/ScrollEvent;->mYVelocity:D

    invoke-interface {v5, v6, v8, v9}, Lcom/facebook/react/bridge/WritableMap;->putDouble(Ljava/lang/String;D)V

    .line 151
    invoke-static {}, Lcom/facebook/react/bridge/Arguments;->createMap()Lcom/facebook/react/bridge/WritableMap;

    move-result-object v3

    .line 152
    .local v3, "event":Lcom/facebook/react/bridge/WritableMap;
    const-string v6, "contentInset"

    invoke-interface {v3, v6, v0}, Lcom/facebook/react/bridge/WritableMap;->putMap(Ljava/lang/String;Lcom/facebook/react/bridge/WritableMap;)V

    .line 153
    const-string v6, "contentOffset"

    invoke-interface {v3, v6, v1}, Lcom/facebook/react/bridge/WritableMap;->putMap(Ljava/lang/String;Lcom/facebook/react/bridge/WritableMap;)V

    .line 154
    const-string v6, "contentSize"

    invoke-interface {v3, v6, v2}, Lcom/facebook/react/bridge/WritableMap;->putMap(Ljava/lang/String;Lcom/facebook/react/bridge/WritableMap;)V

    .line 155
    const-string v6, "layoutMeasurement"

    invoke-interface {v3, v6, v4}, Lcom/facebook/react/bridge/WritableMap;->putMap(Ljava/lang/String;Lcom/facebook/react/bridge/WritableMap;)V

    .line 156
    const-string v6, "velocity"

    invoke-interface {v3, v6, v5}, Lcom/facebook/react/bridge/WritableMap;->putMap(Ljava/lang/String;Lcom/facebook/react/bridge/WritableMap;)V

    .line 158
    const-string v6, "target"

    invoke-virtual {p0}, Lcom/facebook/react/views/scroll/ScrollEvent;->getViewTag()I

    move-result v7

    invoke-interface {v3, v6, v7}, Lcom/facebook/react/bridge/WritableMap;->putInt(Ljava/lang/String;I)V

    .line 159
    const-string v6, "responderIgnoreScroll"

    const/4 v7, 0x1

    invoke-interface {v3, v6, v7}, Lcom/facebook/react/bridge/WritableMap;->putBoolean(Ljava/lang/String;Z)V

    .line 160
    return-object v3
.end method


# virtual methods
.method public canCoalesce()Z
    .locals 2

    .prologue
    .line 117
    iget-object v0, p0, Lcom/facebook/react/views/scroll/ScrollEvent;->mScrollEventType:Lcom/facebook/react/views/scroll/ScrollEventType;

    sget-object v1, Lcom/facebook/react/views/scroll/ScrollEventType;->SCROLL:Lcom/facebook/react/views/scroll/ScrollEventType;

    if-ne v0, v1, :cond_0

    .line 118
    const/4 v0, 0x1

    .line 120
    :goto_0
    return v0

    :cond_0
    const/4 v0, 0x0

    goto :goto_0
.end method

.method public dispatch(Lcom/facebook/react/uimanager/events/RCTEventEmitter;)V
    .locals 3
    .param p1, "rctEventEmitter"    # Lcom/facebook/react/uimanager/events/RCTEventEmitter;

    .prologue
    .line 125
    invoke-virtual {p0}, Lcom/facebook/react/views/scroll/ScrollEvent;->getViewTag()I

    move-result v0

    invoke-virtual {p0}, Lcom/facebook/react/views/scroll/ScrollEvent;->getEventName()Ljava/lang/String;

    move-result-object v1

    invoke-direct {p0}, Lcom/facebook/react/views/scroll/ScrollEvent;->serializeEventData()Lcom/facebook/react/bridge/WritableMap;

    move-result-object v2

    invoke-interface {p1, v0, v1, v2}, Lcom/facebook/react/uimanager/events/RCTEventEmitter;->receiveEvent(ILjava/lang/String;Lcom/facebook/react/bridge/WritableMap;)V

    .line 126
    return-void
.end method

.method public getCoalescingKey()S
    .locals 1

    .prologue
    .line 111
    const/4 v0, 0x0

    return v0
.end method

.method public getEventName()Ljava/lang/String;
    .locals 1

    .prologue
    .line 105
    iget-object v0, p0, Lcom/facebook/react/views/scroll/ScrollEvent;->mScrollEventType:Lcom/facebook/react/views/scroll/ScrollEventType;

    invoke-static {v0}, Lcom/facebook/infer/annotation/Assertions;->assertNotNull(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/facebook/react/views/scroll/ScrollEventType;

    invoke-virtual {v0}, Lcom/facebook/react/views/scroll/ScrollEventType;->getJSEventName()Ljava/lang/String;

    move-result-object v0

    return-object v0
.end method

.method public onDispose()V
    .locals 1

    .prologue
    .line 74
    sget-object v0, Lcom/facebook/react/views/scroll/ScrollEvent;->EVENTS_POOL:Landroid/support/v4/util/Pools$SynchronizedPool;

    invoke-virtual {v0, p0}, Landroid/support/v4/util/Pools$SynchronizedPool;->release(Ljava/lang/Object;)Z

    .line 75
    return-void
.end method

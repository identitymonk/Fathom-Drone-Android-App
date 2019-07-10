.class Lcom/facebook/react/uimanager/events/TouchesHelper;
.super Ljava/lang/Object;
.source "TouchesHelper.java"


# static fields
.field private static final LOCATION_X_KEY:Ljava/lang/String; = "locationX"

.field private static final LOCATION_Y_KEY:Ljava/lang/String; = "locationY"

.field private static final PAGE_X_KEY:Ljava/lang/String; = "pageX"

.field private static final PAGE_Y_KEY:Ljava/lang/String; = "pageY"

.field private static final POINTER_IDENTIFIER_KEY:Ljava/lang/String; = "identifier"

.field private static final TARGET_KEY:Ljava/lang/String; = "target"

.field private static final TIMESTAMP_KEY:Ljava/lang/String; = "timestamp"


# direct methods
.method constructor <init>()V
    .locals 0

    .prologue
    .line 22
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method

.method private static createsPointersArray(ILcom/facebook/react/uimanager/events/TouchEvent;)Lcom/facebook/react/bridge/WritableArray;
    .locals 12
    .param p0, "reactTarget"    # I
    .param p1, "event"    # Lcom/facebook/react/uimanager/events/TouchEvent;

    .prologue
    .line 39
    invoke-static {}, Lcom/facebook/react/bridge/Arguments;->createArray()Lcom/facebook/react/bridge/WritableArray;

    move-result-object v7

    .line 40
    .local v7, "touches":Lcom/facebook/react/bridge/WritableArray;
    invoke-virtual {p1}, Lcom/facebook/react/uimanager/events/TouchEvent;->getMotionEvent()Landroid/view/MotionEvent;

    move-result-object v3

    .line 49
    .local v3, "motionEvent":Landroid/view/MotionEvent;
    invoke-virtual {v3}, Landroid/view/MotionEvent;->getX()F

    move-result v8

    invoke-virtual {p1}, Lcom/facebook/react/uimanager/events/TouchEvent;->getViewX()F

    move-result v9

    sub-float v4, v8, v9

    .line 50
    .local v4, "targetViewCoordinateX":F
    invoke-virtual {v3}, Landroid/view/MotionEvent;->getY()F

    move-result v8

    invoke-virtual {p1}, Lcom/facebook/react/uimanager/events/TouchEvent;->getViewY()F

    move-result v9

    sub-float v5, v8, v9

    .line 52
    .local v5, "targetViewCoordinateY":F
    const/4 v0, 0x0

    .local v0, "index":I
    :goto_0
    invoke-virtual {v3}, Landroid/view/MotionEvent;->getPointerCount()I

    move-result v8

    if-ge v0, v8, :cond_0

    .line 53
    invoke-static {}, Lcom/facebook/react/bridge/Arguments;->createMap()Lcom/facebook/react/bridge/WritableMap;

    move-result-object v6

    .line 56
    .local v6, "touch":Lcom/facebook/react/bridge/WritableMap;
    const-string v8, "pageX"

    invoke-virtual {v3, v0}, Landroid/view/MotionEvent;->getX(I)F

    move-result v9

    invoke-static {v9}, Lcom/facebook/react/uimanager/PixelUtil;->toDIPFromPixel(F)F

    move-result v9

    float-to-double v10, v9

    invoke-interface {v6, v8, v10, v11}, Lcom/facebook/react/bridge/WritableMap;->putDouble(Ljava/lang/String;D)V

    .line 57
    const-string v8, "pageY"

    invoke-virtual {v3, v0}, Landroid/view/MotionEvent;->getY(I)F

    move-result v9

    invoke-static {v9}, Lcom/facebook/react/uimanager/PixelUtil;->toDIPFromPixel(F)F

    move-result v9

    float-to-double v10, v9

    invoke-interface {v6, v8, v10, v11}, Lcom/facebook/react/bridge/WritableMap;->putDouble(Ljava/lang/String;D)V

    .line 60
    invoke-virtual {v3, v0}, Landroid/view/MotionEvent;->getX(I)F

    move-result v8

    sub-float v1, v8, v4

    .line 61
    .local v1, "locationX":F
    invoke-virtual {v3, v0}, Landroid/view/MotionEvent;->getY(I)F

    move-result v8

    sub-float v2, v8, v5

    .line 62
    .local v2, "locationY":F
    const-string v8, "locationX"

    invoke-static {v1}, Lcom/facebook/react/uimanager/PixelUtil;->toDIPFromPixel(F)F

    move-result v9

    float-to-double v10, v9

    invoke-interface {v6, v8, v10, v11}, Lcom/facebook/react/bridge/WritableMap;->putDouble(Ljava/lang/String;D)V

    .line 63
    const-string v8, "locationY"

    invoke-static {v2}, Lcom/facebook/react/uimanager/PixelUtil;->toDIPFromPixel(F)F

    move-result v9

    float-to-double v10, v9

    invoke-interface {v6, v8, v10, v11}, Lcom/facebook/react/bridge/WritableMap;->putDouble(Ljava/lang/String;D)V

    .line 64
    const-string v8, "target"

    invoke-interface {v6, v8, p0}, Lcom/facebook/react/bridge/WritableMap;->putInt(Ljava/lang/String;I)V

    .line 65
    const-string v8, "timestamp"

    invoke-virtual {p1}, Lcom/facebook/react/uimanager/events/TouchEvent;->getTimestampMs()J

    move-result-wide v10

    long-to-double v10, v10

    invoke-interface {v6, v8, v10, v11}, Lcom/facebook/react/bridge/WritableMap;->putDouble(Ljava/lang/String;D)V

    .line 66
    const-string v8, "identifier"

    invoke-virtual {v3, v0}, Landroid/view/MotionEvent;->getPointerId(I)I

    move-result v9

    int-to-double v10, v9

    invoke-interface {v6, v8, v10, v11}, Lcom/facebook/react/bridge/WritableMap;->putDouble(Ljava/lang/String;D)V

    .line 67
    invoke-interface {v7, v6}, Lcom/facebook/react/bridge/WritableArray;->pushMap(Lcom/facebook/react/bridge/WritableMap;)V

    .line 52
    add-int/lit8 v0, v0, 0x1

    goto :goto_0

    .line 70
    .end local v1    # "locationX":F
    .end local v2    # "locationY":F
    .end local v6    # "touch":Lcom/facebook/react/bridge/WritableMap;
    :cond_0
    return-object v7
.end method

.method public static sendTouchEvent(Lcom/facebook/react/uimanager/events/RCTEventEmitter;Lcom/facebook/react/uimanager/events/TouchEventType;ILcom/facebook/react/uimanager/events/TouchEvent;)V
    .locals 7
    .param p0, "rctEventEmitter"    # Lcom/facebook/react/uimanager/events/RCTEventEmitter;
    .param p1, "type"    # Lcom/facebook/react/uimanager/events/TouchEventType;
    .param p2, "reactTarget"    # I
    .param p3, "touchEvent"    # Lcom/facebook/react/uimanager/events/TouchEvent;

    .prologue
    .line 88
    invoke-static {p2, p3}, Lcom/facebook/react/uimanager/events/TouchesHelper;->createsPointersArray(ILcom/facebook/react/uimanager/events/TouchEvent;)Lcom/facebook/react/bridge/WritableArray;

    move-result-object v3

    .line 89
    .local v3, "pointers":Lcom/facebook/react/bridge/WritableArray;
    invoke-virtual {p3}, Lcom/facebook/react/uimanager/events/TouchEvent;->getMotionEvent()Landroid/view/MotionEvent;

    move-result-object v2

    .line 93
    .local v2, "motionEvent":Landroid/view/MotionEvent;
    invoke-static {}, Lcom/facebook/react/bridge/Arguments;->createArray()Lcom/facebook/react/bridge/WritableArray;

    move-result-object v0

    .line 94
    .local v0, "changedIndices":Lcom/facebook/react/bridge/WritableArray;
    sget-object v4, Lcom/facebook/react/uimanager/events/TouchEventType;->MOVE:Lcom/facebook/react/uimanager/events/TouchEventType;

    if-eq p1, v4, :cond_0

    sget-object v4, Lcom/facebook/react/uimanager/events/TouchEventType;->CANCEL:Lcom/facebook/react/uimanager/events/TouchEventType;

    if-ne p1, v4, :cond_1

    .line 95
    :cond_0
    const/4 v1, 0x0

    .local v1, "i":I
    :goto_0
    invoke-virtual {v2}, Landroid/view/MotionEvent;->getPointerCount()I

    move-result v4

    if-ge v1, v4, :cond_3

    .line 96
    invoke-interface {v0, v1}, Lcom/facebook/react/bridge/WritableArray;->pushInt(I)V

    .line 95
    add-int/lit8 v1, v1, 0x1

    goto :goto_0

    .line 98
    .end local v1    # "i":I
    :cond_1
    sget-object v4, Lcom/facebook/react/uimanager/events/TouchEventType;->START:Lcom/facebook/react/uimanager/events/TouchEventType;

    if-eq p1, v4, :cond_2

    sget-object v4, Lcom/facebook/react/uimanager/events/TouchEventType;->END:Lcom/facebook/react/uimanager/events/TouchEventType;

    if-ne p1, v4, :cond_4

    .line 99
    :cond_2
    invoke-virtual {v2}, Landroid/view/MotionEvent;->getActionIndex()I

    move-result v4

    invoke-interface {v0, v4}, Lcom/facebook/react/bridge/WritableArray;->pushInt(I)V

    .line 105
    :cond_3
    invoke-virtual {p1}, Lcom/facebook/react/uimanager/events/TouchEventType;->getJSEventName()Ljava/lang/String;

    move-result-object v4

    .line 104
    invoke-interface {p0, v4, v3, v0}, Lcom/facebook/react/uimanager/events/RCTEventEmitter;->receiveTouches(Ljava/lang/String;Lcom/facebook/react/bridge/WritableArray;Lcom/facebook/react/bridge/WritableArray;)V

    .line 108
    return-void

    .line 101
    :cond_4
    new-instance v4, Ljava/lang/RuntimeException;

    new-instance v5, Ljava/lang/StringBuilder;

    invoke-direct {v5}, Ljava/lang/StringBuilder;-><init>()V

    const-string v6, "Unknown touch type: "

    invoke-virtual {v5, v6}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v5

    invoke-virtual {v5, p1}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    move-result-object v5

    invoke-virtual {v5}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v5

    invoke-direct {v4, v5}, Ljava/lang/RuntimeException;-><init>(Ljava/lang/String;)V

    throw v4
.end method

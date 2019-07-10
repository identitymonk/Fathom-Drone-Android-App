.class public Lcom/facebook/react/views/image/ImageLoadEvent;
.super Lcom/facebook/react/uimanager/events/Event;
.source "ImageLoadEvent.java"


# annotations
.annotation system Ldalvik/annotation/Signature;
    value = {
        "Lcom/facebook/react/uimanager/events/Event",
        "<",
        "Lcom/facebook/react/views/image/ImageLoadEvent;",
        ">;"
    }
.end annotation


# static fields
.field public static final ON_ERROR:I = 0x1

.field public static final ON_LOAD:I = 0x2

.field public static final ON_LOAD_END:I = 0x3

.field public static final ON_LOAD_START:I = 0x4

.field public static final ON_PROGRESS:I = 0x5


# instance fields
.field private final mEventType:I

.field private final mHeight:I

.field private final mImageUri:Ljava/lang/String;
    .annotation runtime Ljavax/annotation/Nullable;
    .end annotation
.end field

.field private final mWidth:I


# direct methods
.method public constructor <init>(II)V
    .locals 1
    .param p1, "viewId"    # I
    .param p2, "eventType"    # I

    .prologue
    .line 43
    const/4 v0, 0x0

    invoke-direct {p0, p1, p2, v0}, Lcom/facebook/react/views/image/ImageLoadEvent;-><init>(IILjava/lang/String;)V

    .line 44
    return-void
.end method

.method public constructor <init>(IILjava/lang/String;)V
    .locals 6
    .param p1, "viewId"    # I
    .param p2, "eventType"    # I
    .param p3, "imageUri"    # Ljava/lang/String;

    .prologue
    const/4 v4, 0x0

    .line 47
    move-object v0, p0

    move v1, p1

    move v2, p2

    move-object v3, p3

    move v5, v4

    invoke-direct/range {v0 .. v5}, Lcom/facebook/react/views/image/ImageLoadEvent;-><init>(IILjava/lang/String;II)V

    .line 48
    return-void
.end method

.method public constructor <init>(IILjava/lang/String;II)V
    .locals 0
    .param p1, "viewId"    # I
    .param p2, "eventType"    # I
    .param p3, "imageUri"    # Ljava/lang/String;
        .annotation runtime Ljavax/annotation/Nullable;
        .end annotation
    .end param
    .param p4, "width"    # I
    .param p5, "height"    # I

    .prologue
    .line 56
    invoke-direct {p0, p1}, Lcom/facebook/react/uimanager/events/Event;-><init>(I)V

    .line 57
    iput p2, p0, Lcom/facebook/react/views/image/ImageLoadEvent;->mEventType:I

    .line 58
    iput-object p3, p0, Lcom/facebook/react/views/image/ImageLoadEvent;->mImageUri:Ljava/lang/String;

    .line 59
    iput p4, p0, Lcom/facebook/react/views/image/ImageLoadEvent;->mWidth:I

    .line 60
    iput p5, p0, Lcom/facebook/react/views/image/ImageLoadEvent;->mHeight:I

    .line 61
    return-void
.end method

.method public static eventNameForType(I)Ljava/lang/String;
    .locals 3
    .param p0, "eventType"    # I

    .prologue
    .line 64
    packed-switch p0, :pswitch_data_0

    .line 76
    new-instance v0, Ljava/lang/IllegalStateException;

    new-instance v1, Ljava/lang/StringBuilder;

    invoke-direct {v1}, Ljava/lang/StringBuilder;-><init>()V

    const-string v2, "Invalid image event: "

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-static {p0}, Ljava/lang/Integer;->toString(I)Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    invoke-direct {v0, v1}, Ljava/lang/IllegalStateException;-><init>(Ljava/lang/String;)V

    throw v0

    .line 66
    :pswitch_0
    const-string v0, "topError"

    .line 74
    :goto_0
    return-object v0

    .line 68
    :pswitch_1
    const-string v0, "topLoad"

    goto :goto_0

    .line 70
    :pswitch_2
    const-string v0, "topLoadEnd"

    goto :goto_0

    .line 72
    :pswitch_3
    const-string v0, "topLoadStart"

    goto :goto_0

    .line 74
    :pswitch_4
    const-string v0, "topProgress"

    goto :goto_0

    .line 64
    nop

    :pswitch_data_0
    .packed-switch 0x1
        :pswitch_0
        :pswitch_1
        :pswitch_2
        :pswitch_3
        :pswitch_4
    .end packed-switch
.end method


# virtual methods
.method public dispatch(Lcom/facebook/react/uimanager/events/RCTEventEmitter;)V
    .locals 6
    .param p1, "rctEventEmitter"    # Lcom/facebook/react/uimanager/events/RCTEventEmitter;

    .prologue
    const/4 v4, 0x2

    .line 94
    const/4 v0, 0x0

    .line 96
    .local v0, "eventData":Lcom/facebook/react/bridge/WritableMap;
    iget-object v2, p0, Lcom/facebook/react/views/image/ImageLoadEvent;->mImageUri:Ljava/lang/String;

    if-nez v2, :cond_0

    iget v2, p0, Lcom/facebook/react/views/image/ImageLoadEvent;->mEventType:I

    if-ne v2, v4, :cond_3

    .line 97
    :cond_0
    invoke-static {}, Lcom/facebook/react/bridge/Arguments;->createMap()Lcom/facebook/react/bridge/WritableMap;

    move-result-object v0

    .line 99
    iget-object v2, p0, Lcom/facebook/react/views/image/ImageLoadEvent;->mImageUri:Ljava/lang/String;

    if-eqz v2, :cond_1

    .line 100
    const-string v2, "uri"

    iget-object v3, p0, Lcom/facebook/react/views/image/ImageLoadEvent;->mImageUri:Ljava/lang/String;

    invoke-interface {v0, v2, v3}, Lcom/facebook/react/bridge/WritableMap;->putString(Ljava/lang/String;Ljava/lang/String;)V

    .line 103
    :cond_1
    iget v2, p0, Lcom/facebook/react/views/image/ImageLoadEvent;->mEventType:I

    if-ne v2, v4, :cond_3

    .line 104
    invoke-static {}, Lcom/facebook/react/bridge/Arguments;->createMap()Lcom/facebook/react/bridge/WritableMap;

    move-result-object v1

    .line 105
    .local v1, "source":Lcom/facebook/react/bridge/WritableMap;
    const-string v2, "width"

    iget v3, p0, Lcom/facebook/react/views/image/ImageLoadEvent;->mWidth:I

    int-to-double v4, v3

    invoke-interface {v1, v2, v4, v5}, Lcom/facebook/react/bridge/WritableMap;->putDouble(Ljava/lang/String;D)V

    .line 106
    const-string v2, "height"

    iget v3, p0, Lcom/facebook/react/views/image/ImageLoadEvent;->mHeight:I

    int-to-double v4, v3

    invoke-interface {v1, v2, v4, v5}, Lcom/facebook/react/bridge/WritableMap;->putDouble(Ljava/lang/String;D)V

    .line 107
    iget-object v2, p0, Lcom/facebook/react/views/image/ImageLoadEvent;->mImageUri:Ljava/lang/String;

    if-eqz v2, :cond_2

    .line 108
    const-string v2, "url"

    iget-object v3, p0, Lcom/facebook/react/views/image/ImageLoadEvent;->mImageUri:Ljava/lang/String;

    invoke-interface {v1, v2, v3}, Lcom/facebook/react/bridge/WritableMap;->putString(Ljava/lang/String;Ljava/lang/String;)V

    .line 110
    :cond_2
    const-string v2, "source"

    invoke-interface {v0, v2, v1}, Lcom/facebook/react/bridge/WritableMap;->putMap(Ljava/lang/String;Lcom/facebook/react/bridge/WritableMap;)V

    .line 114
    .end local v1    # "source":Lcom/facebook/react/bridge/WritableMap;
    :cond_3
    invoke-virtual {p0}, Lcom/facebook/react/views/image/ImageLoadEvent;->getViewTag()I

    move-result v2

    invoke-virtual {p0}, Lcom/facebook/react/views/image/ImageLoadEvent;->getEventName()Ljava/lang/String;

    move-result-object v3

    invoke-interface {p1, v2, v3, v0}, Lcom/facebook/react/uimanager/events/RCTEventEmitter;->receiveEvent(ILjava/lang/String;Lcom/facebook/react/bridge/WritableMap;)V

    .line 115
    return-void
.end method

.method public getCoalescingKey()S
    .locals 1

    .prologue
    .line 89
    iget v0, p0, Lcom/facebook/react/views/image/ImageLoadEvent;->mEventType:I

    int-to-short v0, v0

    return v0
.end method

.method public getEventName()Ljava/lang/String;
    .locals 1

    .prologue
    .line 82
    iget v0, p0, Lcom/facebook/react/views/image/ImageLoadEvent;->mEventType:I

    invoke-static {v0}, Lcom/facebook/react/views/image/ImageLoadEvent;->eventNameForType(I)Ljava/lang/String;

    move-result-object v0

    return-object v0
.end method

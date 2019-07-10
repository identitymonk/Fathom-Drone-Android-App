.class public Lcom/facebook/react/uimanager/events/EventDispatcher;
.super Ljava/lang/Object;
.source "EventDispatcher.java"

# interfaces
.implements Lcom/facebook/react/bridge/LifecycleEventListener;


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lcom/facebook/react/uimanager/events/EventDispatcher$DispatchEventsRunnable;,
        Lcom/facebook/react/uimanager/events/EventDispatcher$ScheduleDispatchFrameCallback;
    }
.end annotation


# static fields
.field private static final EVENT_COMPARATOR:Ljava/util/Comparator;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/Comparator",
            "<",
            "Lcom/facebook/react/uimanager/events/Event;",
            ">;"
        }
    .end annotation
.end field


# instance fields
.field private final mCurrentFrameCallback:Lcom/facebook/react/uimanager/events/EventDispatcher$ScheduleDispatchFrameCallback;

.field private final mDispatchEventsRunnable:Lcom/facebook/react/uimanager/events/EventDispatcher$DispatchEventsRunnable;

.field private final mEventCookieToLastEventIdx:Landroid/util/LongSparseArray;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Landroid/util/LongSparseArray",
            "<",
            "Ljava/lang/Integer;",
            ">;"
        }
    .end annotation
.end field

.field private final mEventNameToEventId:Ljava/util/Map;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/Map",
            "<",
            "Ljava/lang/String;",
            "Ljava/lang/Short;",
            ">;"
        }
    .end annotation
.end field

.field private final mEventStaging:Ljava/util/ArrayList;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/ArrayList",
            "<",
            "Lcom/facebook/react/uimanager/events/Event;",
            ">;"
        }
    .end annotation
.end field

.field private final mEventsStagingLock:Ljava/lang/Object;

.field private mEventsToDispatch:[Lcom/facebook/react/uimanager/events/Event;

.field private final mEventsToDispatchLock:Ljava/lang/Object;

.field private mEventsToDispatchSize:I

.field private volatile mHasDispatchScheduled:Z

.field private final mHasDispatchScheduledCount:Ljava/util/concurrent/atomic/AtomicInteger;

.field private final mListeners:Ljava/util/ArrayList;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/ArrayList",
            "<",
            "Lcom/facebook/react/uimanager/events/EventDispatcherListener;",
            ">;"
        }
    .end annotation
.end field

.field private mNextEventTypeId:S

.field private volatile mRCTEventEmitter:Lcom/facebook/react/uimanager/events/RCTEventEmitter;
    .annotation runtime Ljavax/annotation/Nullable;
    .end annotation
.end field

.field private final mReactContext:Lcom/facebook/react/bridge/ReactApplicationContext;


# direct methods
.method static constructor <clinit>()V
    .locals 1

    .prologue
    .line 65
    new-instance v0, Lcom/facebook/react/uimanager/events/EventDispatcher$1;

    invoke-direct {v0}, Lcom/facebook/react/uimanager/events/EventDispatcher$1;-><init>()V

    sput-object v0, Lcom/facebook/react/uimanager/events/EventDispatcher;->EVENT_COMPARATOR:Ljava/util/Comparator;

    return-void
.end method

.method public constructor <init>(Lcom/facebook/react/bridge/ReactApplicationContext;)V
    .locals 3
    .param p1, "reactContext"    # Lcom/facebook/react/bridge/ReactApplicationContext;

    .prologue
    const/4 v2, 0x0

    const/4 v1, 0x0

    .line 107
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 89
    new-instance v0, Ljava/lang/Object;

    invoke-direct {v0}, Ljava/lang/Object;-><init>()V

    iput-object v0, p0, Lcom/facebook/react/uimanager/events/EventDispatcher;->mEventsStagingLock:Ljava/lang/Object;

    .line 90
    new-instance v0, Ljava/lang/Object;

    invoke-direct {v0}, Ljava/lang/Object;-><init>()V

    iput-object v0, p0, Lcom/facebook/react/uimanager/events/EventDispatcher;->mEventsToDispatchLock:Ljava/lang/Object;

    .line 92
    new-instance v0, Landroid/util/LongSparseArray;

    invoke-direct {v0}, Landroid/util/LongSparseArray;-><init>()V

    iput-object v0, p0, Lcom/facebook/react/uimanager/events/EventDispatcher;->mEventCookieToLastEventIdx:Landroid/util/LongSparseArray;

    .line 93
    invoke-static {}, Lcom/facebook/react/common/MapBuilder;->newHashMap()Ljava/util/HashMap;

    move-result-object v0

    iput-object v0, p0, Lcom/facebook/react/uimanager/events/EventDispatcher;->mEventNameToEventId:Ljava/util/Map;

    .line 94
    new-instance v0, Lcom/facebook/react/uimanager/events/EventDispatcher$DispatchEventsRunnable;

    invoke-direct {v0, p0, v2}, Lcom/facebook/react/uimanager/events/EventDispatcher$DispatchEventsRunnable;-><init>(Lcom/facebook/react/uimanager/events/EventDispatcher;Lcom/facebook/react/uimanager/events/EventDispatcher$1;)V

    iput-object v0, p0, Lcom/facebook/react/uimanager/events/EventDispatcher;->mDispatchEventsRunnable:Lcom/facebook/react/uimanager/events/EventDispatcher$DispatchEventsRunnable;

    .line 95
    new-instance v0, Ljava/util/ArrayList;

    invoke-direct {v0}, Ljava/util/ArrayList;-><init>()V

    iput-object v0, p0, Lcom/facebook/react/uimanager/events/EventDispatcher;->mEventStaging:Ljava/util/ArrayList;

    .line 96
    new-instance v0, Ljava/util/ArrayList;

    invoke-direct {v0}, Ljava/util/ArrayList;-><init>()V

    iput-object v0, p0, Lcom/facebook/react/uimanager/events/EventDispatcher;->mListeners:Ljava/util/ArrayList;

    .line 97
    new-instance v0, Lcom/facebook/react/uimanager/events/EventDispatcher$ScheduleDispatchFrameCallback;

    invoke-direct {v0, p0, v2}, Lcom/facebook/react/uimanager/events/EventDispatcher$ScheduleDispatchFrameCallback;-><init>(Lcom/facebook/react/uimanager/events/EventDispatcher;Lcom/facebook/react/uimanager/events/EventDispatcher$1;)V

    iput-object v0, p0, Lcom/facebook/react/uimanager/events/EventDispatcher;->mCurrentFrameCallback:Lcom/facebook/react/uimanager/events/EventDispatcher$ScheduleDispatchFrameCallback;

    .line 99
    new-instance v0, Ljava/util/concurrent/atomic/AtomicInteger;

    invoke-direct {v0}, Ljava/util/concurrent/atomic/AtomicInteger;-><init>()V

    iput-object v0, p0, Lcom/facebook/react/uimanager/events/EventDispatcher;->mHasDispatchScheduledCount:Ljava/util/concurrent/atomic/AtomicInteger;

    .line 101
    const/16 v0, 0x10

    new-array v0, v0, [Lcom/facebook/react/uimanager/events/Event;

    iput-object v0, p0, Lcom/facebook/react/uimanager/events/EventDispatcher;->mEventsToDispatch:[Lcom/facebook/react/uimanager/events/Event;

    .line 102
    iput v1, p0, Lcom/facebook/react/uimanager/events/EventDispatcher;->mEventsToDispatchSize:I

    .line 104
    iput-short v1, p0, Lcom/facebook/react/uimanager/events/EventDispatcher;->mNextEventTypeId:S

    .line 105
    iput-boolean v1, p0, Lcom/facebook/react/uimanager/events/EventDispatcher;->mHasDispatchScheduled:Z

    .line 108
    iput-object p1, p0, Lcom/facebook/react/uimanager/events/EventDispatcher;->mReactContext:Lcom/facebook/react/bridge/ReactApplicationContext;

    .line 109
    iget-object v0, p0, Lcom/facebook/react/uimanager/events/EventDispatcher;->mReactContext:Lcom/facebook/react/bridge/ReactApplicationContext;

    invoke-virtual {v0, p0}, Lcom/facebook/react/bridge/ReactApplicationContext;->addLifecycleEventListener(Lcom/facebook/react/bridge/LifecycleEventListener;)V

    .line 110
    return-void
.end method

.method static synthetic access$1000(Lcom/facebook/react/uimanager/events/EventDispatcher;)Lcom/facebook/react/uimanager/events/RCTEventEmitter;
    .locals 1
    .param p0, "x0"    # Lcom/facebook/react/uimanager/events/EventDispatcher;

    .prologue
    .line 63
    iget-object v0, p0, Lcom/facebook/react/uimanager/events/EventDispatcher;->mRCTEventEmitter:Lcom/facebook/react/uimanager/events/RCTEventEmitter;

    return-object v0
.end method

.method static synthetic access$1100(Lcom/facebook/react/uimanager/events/EventDispatcher;)Ljava/lang/Object;
    .locals 1
    .param p0, "x0"    # Lcom/facebook/react/uimanager/events/EventDispatcher;

    .prologue
    .line 63
    iget-object v0, p0, Lcom/facebook/react/uimanager/events/EventDispatcher;->mEventsToDispatchLock:Ljava/lang/Object;

    return-object v0
.end method

.method static synthetic access$1200(Lcom/facebook/react/uimanager/events/EventDispatcher;)[Lcom/facebook/react/uimanager/events/Event;
    .locals 1
    .param p0, "x0"    # Lcom/facebook/react/uimanager/events/EventDispatcher;

    .prologue
    .line 63
    iget-object v0, p0, Lcom/facebook/react/uimanager/events/EventDispatcher;->mEventsToDispatch:[Lcom/facebook/react/uimanager/events/Event;

    return-object v0
.end method

.method static synthetic access$1300()Ljava/util/Comparator;
    .locals 1

    .prologue
    .line 63
    sget-object v0, Lcom/facebook/react/uimanager/events/EventDispatcher;->EVENT_COMPARATOR:Ljava/util/Comparator;

    return-object v0
.end method

.method static synthetic access$1400(Lcom/facebook/react/uimanager/events/EventDispatcher;)V
    .locals 0
    .param p0, "x0"    # Lcom/facebook/react/uimanager/events/EventDispatcher;

    .prologue
    .line 63
    invoke-direct {p0}, Lcom/facebook/react/uimanager/events/EventDispatcher;->clearEventsToDispatch()V

    return-void
.end method

.method static synthetic access$1500(Lcom/facebook/react/uimanager/events/EventDispatcher;)Landroid/util/LongSparseArray;
    .locals 1
    .param p0, "x0"    # Lcom/facebook/react/uimanager/events/EventDispatcher;

    .prologue
    .line 63
    iget-object v0, p0, Lcom/facebook/react/uimanager/events/EventDispatcher;->mEventCookieToLastEventIdx:Landroid/util/LongSparseArray;

    return-object v0
.end method

.method static synthetic access$200(Lcom/facebook/react/uimanager/events/EventDispatcher;)V
    .locals 0
    .param p0, "x0"    # Lcom/facebook/react/uimanager/events/EventDispatcher;

    .prologue
    .line 63
    invoke-direct {p0}, Lcom/facebook/react/uimanager/events/EventDispatcher;->stopFrameCallback()V

    return-void
.end method

.method static synthetic access$300(Lcom/facebook/react/uimanager/events/EventDispatcher;)V
    .locals 0
    .param p0, "x0"    # Lcom/facebook/react/uimanager/events/EventDispatcher;

    .prologue
    .line 63
    invoke-direct {p0}, Lcom/facebook/react/uimanager/events/EventDispatcher;->moveStagedEventsToDispatchQueue()V

    return-void
.end method

.method static synthetic access$400(Lcom/facebook/react/uimanager/events/EventDispatcher;)I
    .locals 1
    .param p0, "x0"    # Lcom/facebook/react/uimanager/events/EventDispatcher;

    .prologue
    .line 63
    iget v0, p0, Lcom/facebook/react/uimanager/events/EventDispatcher;->mEventsToDispatchSize:I

    return v0
.end method

.method static synthetic access$500(Lcom/facebook/react/uimanager/events/EventDispatcher;)Z
    .locals 1
    .param p0, "x0"    # Lcom/facebook/react/uimanager/events/EventDispatcher;

    .prologue
    .line 63
    iget-boolean v0, p0, Lcom/facebook/react/uimanager/events/EventDispatcher;->mHasDispatchScheduled:Z

    return v0
.end method

.method static synthetic access$502(Lcom/facebook/react/uimanager/events/EventDispatcher;Z)Z
    .locals 0
    .param p0, "x0"    # Lcom/facebook/react/uimanager/events/EventDispatcher;
    .param p1, "x1"    # Z

    .prologue
    .line 63
    iput-boolean p1, p0, Lcom/facebook/react/uimanager/events/EventDispatcher;->mHasDispatchScheduled:Z

    return p1
.end method

.method static synthetic access$600(Lcom/facebook/react/uimanager/events/EventDispatcher;)Ljava/util/concurrent/atomic/AtomicInteger;
    .locals 1
    .param p0, "x0"    # Lcom/facebook/react/uimanager/events/EventDispatcher;

    .prologue
    .line 63
    iget-object v0, p0, Lcom/facebook/react/uimanager/events/EventDispatcher;->mHasDispatchScheduledCount:Ljava/util/concurrent/atomic/AtomicInteger;

    return-object v0
.end method

.method static synthetic access$700(Lcom/facebook/react/uimanager/events/EventDispatcher;)Lcom/facebook/react/uimanager/events/EventDispatcher$DispatchEventsRunnable;
    .locals 1
    .param p0, "x0"    # Lcom/facebook/react/uimanager/events/EventDispatcher;

    .prologue
    .line 63
    iget-object v0, p0, Lcom/facebook/react/uimanager/events/EventDispatcher;->mDispatchEventsRunnable:Lcom/facebook/react/uimanager/events/EventDispatcher$DispatchEventsRunnable;

    return-object v0
.end method

.method static synthetic access$800(Lcom/facebook/react/uimanager/events/EventDispatcher;)Lcom/facebook/react/bridge/ReactApplicationContext;
    .locals 1
    .param p0, "x0"    # Lcom/facebook/react/uimanager/events/EventDispatcher;

    .prologue
    .line 63
    iget-object v0, p0, Lcom/facebook/react/uimanager/events/EventDispatcher;->mReactContext:Lcom/facebook/react/bridge/ReactApplicationContext;

    return-object v0
.end method

.method static synthetic access$900(Lcom/facebook/react/uimanager/events/EventDispatcher;)Lcom/facebook/react/uimanager/events/EventDispatcher$ScheduleDispatchFrameCallback;
    .locals 1
    .param p0, "x0"    # Lcom/facebook/react/uimanager/events/EventDispatcher;

    .prologue
    .line 63
    iget-object v0, p0, Lcom/facebook/react/uimanager/events/EventDispatcher;->mCurrentFrameCallback:Lcom/facebook/react/uimanager/events/EventDispatcher$ScheduleDispatchFrameCallback;

    return-object v0
.end method

.method private addEventToEventsToDispatch(Lcom/facebook/react/uimanager/events/Event;)V
    .locals 3
    .param p1, "event"    # Lcom/facebook/react/uimanager/events/Event;

    .prologue
    .line 366
    iget v0, p0, Lcom/facebook/react/uimanager/events/EventDispatcher;->mEventsToDispatchSize:I

    iget-object v1, p0, Lcom/facebook/react/uimanager/events/EventDispatcher;->mEventsToDispatch:[Lcom/facebook/react/uimanager/events/Event;

    array-length v1, v1

    if-ne v0, v1, :cond_0

    .line 367
    iget-object v0, p0, Lcom/facebook/react/uimanager/events/EventDispatcher;->mEventsToDispatch:[Lcom/facebook/react/uimanager/events/Event;

    iget-object v1, p0, Lcom/facebook/react/uimanager/events/EventDispatcher;->mEventsToDispatch:[Lcom/facebook/react/uimanager/events/Event;

    array-length v1, v1

    mul-int/lit8 v1, v1, 0x2

    invoke-static {v0, v1}, Ljava/util/Arrays;->copyOf([Ljava/lang/Object;I)[Ljava/lang/Object;

    move-result-object v0

    check-cast v0, [Lcom/facebook/react/uimanager/events/Event;

    iput-object v0, p0, Lcom/facebook/react/uimanager/events/EventDispatcher;->mEventsToDispatch:[Lcom/facebook/react/uimanager/events/Event;

    .line 369
    :cond_0
    iget-object v0, p0, Lcom/facebook/react/uimanager/events/EventDispatcher;->mEventsToDispatch:[Lcom/facebook/react/uimanager/events/Event;

    iget v1, p0, Lcom/facebook/react/uimanager/events/EventDispatcher;->mEventsToDispatchSize:I

    add-int/lit8 v2, v1, 0x1

    iput v2, p0, Lcom/facebook/react/uimanager/events/EventDispatcher;->mEventsToDispatchSize:I

    aput-object p1, v0, v1

    .line 370
    return-void
.end method

.method private clearEventsToDispatch()V
    .locals 4

    .prologue
    const/4 v3, 0x0

    .line 373
    iget-object v0, p0, Lcom/facebook/react/uimanager/events/EventDispatcher;->mEventsToDispatch:[Lcom/facebook/react/uimanager/events/Event;

    iget v1, p0, Lcom/facebook/react/uimanager/events/EventDispatcher;->mEventsToDispatchSize:I

    const/4 v2, 0x0

    invoke-static {v0, v3, v1, v2}, Ljava/util/Arrays;->fill([Ljava/lang/Object;IILjava/lang/Object;)V

    .line 374
    iput v3, p0, Lcom/facebook/react/uimanager/events/EventDispatcher;->mEventsToDispatchSize:I

    .line 375
    return-void
.end method

.method private getEventCookie(ILjava/lang/String;S)J
    .locals 4
    .param p1, "viewTag"    # I
    .param p2, "eventName"    # Ljava/lang/String;
    .param p3, "coalescingKey"    # S

    .prologue
    .line 243
    iget-object v2, p0, Lcom/facebook/react/uimanager/events/EventDispatcher;->mEventNameToEventId:Ljava/util/Map;

    invoke-interface {v2, p2}, Ljava/util/Map;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Ljava/lang/Short;

    .line 244
    .local v0, "eventIdObj":Ljava/lang/Short;
    if-eqz v0, :cond_0

    .line 245
    invoke-virtual {v0}, Ljava/lang/Short;->shortValue()S

    move-result v1

    .line 250
    .local v1, "eventTypeId":S
    :goto_0
    invoke-static {p1, v1, p3}, Lcom/facebook/react/uimanager/events/EventDispatcher;->getEventCookie(ISS)J

    move-result-wide v2

    return-wide v2

    .line 247
    .end local v1    # "eventTypeId":S
    :cond_0
    iget-short v1, p0, Lcom/facebook/react/uimanager/events/EventDispatcher;->mNextEventTypeId:S

    add-int/lit8 v2, v1, 0x1

    int-to-short v2, v2

    iput-short v2, p0, Lcom/facebook/react/uimanager/events/EventDispatcher;->mNextEventTypeId:S

    .line 248
    .restart local v1    # "eventTypeId":S
    iget-object v2, p0, Lcom/facebook/react/uimanager/events/EventDispatcher;->mEventNameToEventId:Ljava/util/Map;

    invoke-static {v1}, Ljava/lang/Short;->valueOf(S)Ljava/lang/Short;

    move-result-object v3

    invoke-interface {v2, p2, v3}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    goto :goto_0
.end method

.method private static getEventCookie(ISS)J
    .locals 8
    .param p0, "viewTag"    # I
    .param p1, "eventTypeId"    # S
    .param p2, "coalescingKey"    # S

    .prologue
    const-wide/32 v6, 0xffff

    .line 254
    int-to-long v0, p0

    int-to-long v2, p1

    and-long/2addr v2, v6

    const/16 v4, 0x20

    shl-long/2addr v2, v4

    or-long/2addr v0, v2

    int-to-long v2, p2

    and-long/2addr v2, v6

    const/16 v4, 0x30

    shl-long/2addr v2, v4

    or-long/2addr v0, v2

    return-wide v0
.end method

.method private moveStagedEventsToDispatchQueue()V
    .locals 14

    .prologue
    .line 194
    iget-object v10, p0, Lcom/facebook/react/uimanager/events/EventDispatcher;->mEventsStagingLock:Ljava/lang/Object;

    monitor-enter v10

    .line 195
    :try_start_0
    iget-object v11, p0, Lcom/facebook/react/uimanager/events/EventDispatcher;->mEventsToDispatchLock:Ljava/lang/Object;

    monitor-enter v11
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_1

    .line 196
    const/4 v6, 0x0

    .local v6, "i":I
    :goto_0
    :try_start_1
    iget-object v9, p0, Lcom/facebook/react/uimanager/events/EventDispatcher;->mEventStaging:Ljava/util/ArrayList;

    invoke-virtual {v9}, Ljava/util/ArrayList;->size()I

    move-result v9

    if-ge v6, v9, :cond_5

    .line 197
    iget-object v9, p0, Lcom/facebook/react/uimanager/events/EventDispatcher;->mEventStaging:Ljava/util/ArrayList;

    invoke-virtual {v9, v6}, Ljava/util/ArrayList;->get(I)Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Lcom/facebook/react/uimanager/events/Event;

    .line 199
    .local v1, "event":Lcom/facebook/react/uimanager/events/Event;
    invoke-virtual {v1}, Lcom/facebook/react/uimanager/events/Event;->canCoalesce()Z

    move-result v9

    if-nez v9, :cond_1

    .line 200
    invoke-direct {p0, v1}, Lcom/facebook/react/uimanager/events/EventDispatcher;->addEventToEventsToDispatch(Lcom/facebook/react/uimanager/events/Event;)V

    .line 196
    :cond_0
    :goto_1
    add-int/lit8 v6, v6, 0x1

    goto :goto_0

    .line 205
    :cond_1
    invoke-virtual {v1}, Lcom/facebook/react/uimanager/events/Event;->getViewTag()I

    move-result v9

    .line 206
    invoke-virtual {v1}, Lcom/facebook/react/uimanager/events/Event;->getEventName()Ljava/lang/String;

    move-result-object v12

    .line 207
    invoke-virtual {v1}, Lcom/facebook/react/uimanager/events/Event;->getCoalescingKey()S

    move-result v13

    .line 204
    invoke-direct {p0, v9, v12, v13}, Lcom/facebook/react/uimanager/events/EventDispatcher;->getEventCookie(ILjava/lang/String;S)J

    move-result-wide v2

    .line 209
    .local v2, "eventCookie":J
    const/4 v4, 0x0

    .line 210
    .local v4, "eventToAdd":Lcom/facebook/react/uimanager/events/Event;
    const/4 v5, 0x0

    .line 211
    .local v5, "eventToDispose":Lcom/facebook/react/uimanager/events/Event;
    iget-object v9, p0, Lcom/facebook/react/uimanager/events/EventDispatcher;->mEventCookieToLastEventIdx:Landroid/util/LongSparseArray;

    invoke-virtual {v9, v2, v3}, Landroid/util/LongSparseArray;->get(J)Ljava/lang/Object;

    move-result-object v8

    check-cast v8, Ljava/lang/Integer;

    .line 213
    .local v8, "lastEventIdx":Ljava/lang/Integer;
    if-nez v8, :cond_3

    .line 214
    move-object v4, v1

    .line 215
    iget-object v9, p0, Lcom/facebook/react/uimanager/events/EventDispatcher;->mEventCookieToLastEventIdx:Landroid/util/LongSparseArray;

    iget v12, p0, Lcom/facebook/react/uimanager/events/EventDispatcher;->mEventsToDispatchSize:I

    invoke-static {v12}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v12

    invoke-virtual {v9, v2, v3, v12}, Landroid/util/LongSparseArray;->put(JLjava/lang/Object;)V

    .line 229
    :goto_2
    if-eqz v4, :cond_2

    .line 230
    invoke-direct {p0, v4}, Lcom/facebook/react/uimanager/events/EventDispatcher;->addEventToEventsToDispatch(Lcom/facebook/react/uimanager/events/Event;)V

    .line 232
    :cond_2
    if-eqz v5, :cond_0

    .line 233
    invoke-virtual {v5}, Lcom/facebook/react/uimanager/events/Event;->dispose()V

    goto :goto_1

    .line 236
    .end local v1    # "event":Lcom/facebook/react/uimanager/events/Event;
    .end local v2    # "eventCookie":J
    .end local v4    # "eventToAdd":Lcom/facebook/react/uimanager/events/Event;
    .end local v5    # "eventToDispose":Lcom/facebook/react/uimanager/events/Event;
    .end local v8    # "lastEventIdx":Ljava/lang/Integer;
    :catchall_0
    move-exception v9

    monitor-exit v11
    :try_end_1
    .catchall {:try_start_1 .. :try_end_1} :catchall_0

    :try_start_2
    throw v9

    .line 238
    .end local v6    # "i":I
    :catchall_1
    move-exception v9

    monitor-exit v10
    :try_end_2
    .catchall {:try_start_2 .. :try_end_2} :catchall_1

    throw v9

    .line 217
    .restart local v1    # "event":Lcom/facebook/react/uimanager/events/Event;
    .restart local v2    # "eventCookie":J
    .restart local v4    # "eventToAdd":Lcom/facebook/react/uimanager/events/Event;
    .restart local v5    # "eventToDispose":Lcom/facebook/react/uimanager/events/Event;
    .restart local v6    # "i":I
    .restart local v8    # "lastEventIdx":Ljava/lang/Integer;
    :cond_3
    :try_start_3
    iget-object v9, p0, Lcom/facebook/react/uimanager/events/EventDispatcher;->mEventsToDispatch:[Lcom/facebook/react/uimanager/events/Event;

    invoke-virtual {v8}, Ljava/lang/Integer;->intValue()I

    move-result v12

    aget-object v7, v9, v12

    .line 218
    .local v7, "lastEvent":Lcom/facebook/react/uimanager/events/Event;
    invoke-virtual {v1, v7}, Lcom/facebook/react/uimanager/events/Event;->coalesce(Lcom/facebook/react/uimanager/events/Event;)Lcom/facebook/react/uimanager/events/Event;

    move-result-object v0

    .line 219
    .local v0, "coalescedEvent":Lcom/facebook/react/uimanager/events/Event;
    if-eq v0, v7, :cond_4

    .line 220
    move-object v4, v0

    .line 221
    iget-object v9, p0, Lcom/facebook/react/uimanager/events/EventDispatcher;->mEventCookieToLastEventIdx:Landroid/util/LongSparseArray;

    iget v12, p0, Lcom/facebook/react/uimanager/events/EventDispatcher;->mEventsToDispatchSize:I

    invoke-static {v12}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v12

    invoke-virtual {v9, v2, v3, v12}, Landroid/util/LongSparseArray;->put(JLjava/lang/Object;)V

    .line 222
    move-object v5, v7

    .line 223
    iget-object v9, p0, Lcom/facebook/react/uimanager/events/EventDispatcher;->mEventsToDispatch:[Lcom/facebook/react/uimanager/events/Event;

    invoke-virtual {v8}, Ljava/lang/Integer;->intValue()I

    move-result v12

    const/4 v13, 0x0

    aput-object v13, v9, v12

    goto :goto_2

    .line 225
    :cond_4
    move-object v5, v1

    goto :goto_2

    .line 236
    .end local v0    # "coalescedEvent":Lcom/facebook/react/uimanager/events/Event;
    .end local v1    # "event":Lcom/facebook/react/uimanager/events/Event;
    .end local v2    # "eventCookie":J
    .end local v4    # "eventToAdd":Lcom/facebook/react/uimanager/events/Event;
    .end local v5    # "eventToDispose":Lcom/facebook/react/uimanager/events/Event;
    .end local v7    # "lastEvent":Lcom/facebook/react/uimanager/events/Event;
    .end local v8    # "lastEventIdx":Ljava/lang/Integer;
    :cond_5
    monitor-exit v11
    :try_end_3
    .catchall {:try_start_3 .. :try_end_3} :catchall_0

    .line 237
    :try_start_4
    iget-object v9, p0, Lcom/facebook/react/uimanager/events/EventDispatcher;->mEventStaging:Ljava/util/ArrayList;

    invoke-virtual {v9}, Ljava/util/ArrayList;->clear()V

    .line 238
    monitor-exit v10
    :try_end_4
    .catchall {:try_start_4 .. :try_end_4} :catchall_1

    .line 239
    return-void
.end method

.method private stopFrameCallback()V
    .locals 1

    .prologue
    .line 183
    invoke-static {}, Lcom/facebook/react/bridge/UiThreadUtil;->assertOnUiThread()V

    .line 184
    iget-object v0, p0, Lcom/facebook/react/uimanager/events/EventDispatcher;->mCurrentFrameCallback:Lcom/facebook/react/uimanager/events/EventDispatcher$ScheduleDispatchFrameCallback;

    invoke-virtual {v0}, Lcom/facebook/react/uimanager/events/EventDispatcher$ScheduleDispatchFrameCallback;->stop()V

    .line 185
    return-void
.end method


# virtual methods
.method public addListener(Lcom/facebook/react/uimanager/events/EventDispatcherListener;)V
    .locals 1
    .param p1, "listener"    # Lcom/facebook/react/uimanager/events/EventDispatcherListener;

    .prologue
    .line 145
    iget-object v0, p0, Lcom/facebook/react/uimanager/events/EventDispatcher;->mListeners:Ljava/util/ArrayList;

    invoke-virtual {v0, p1}, Ljava/util/ArrayList;->add(Ljava/lang/Object;)Z

    .line 146
    return-void
.end method

.method public dispatchEvent(Lcom/facebook/react/uimanager/events/Event;)V
    .locals 6
    .param p1, "event"    # Lcom/facebook/react/uimanager/events/Event;

    .prologue
    .line 116
    invoke-virtual {p1}, Lcom/facebook/react/uimanager/events/Event;->isInitialized()Z

    move-result v1

    const-string v2, "Dispatched event hasn\'t been initialized"

    invoke-static {v1, v2}, Lcom/facebook/infer/annotation/Assertions;->assertCondition(ZLjava/lang/String;)V

    .line 118
    iget-object v1, p0, Lcom/facebook/react/uimanager/events/EventDispatcher;->mListeners:Ljava/util/ArrayList;

    invoke-virtual {v1}, Ljava/util/ArrayList;->iterator()Ljava/util/Iterator;

    move-result-object v1

    :goto_0
    invoke-interface {v1}, Ljava/util/Iterator;->hasNext()Z

    move-result v2

    if-eqz v2, :cond_0

    invoke-interface {v1}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/facebook/react/uimanager/events/EventDispatcherListener;

    .line 119
    .local v0, "listener":Lcom/facebook/react/uimanager/events/EventDispatcherListener;
    invoke-interface {v0, p1}, Lcom/facebook/react/uimanager/events/EventDispatcherListener;->onEventDispatch(Lcom/facebook/react/uimanager/events/Event;)V

    goto :goto_0

    .line 122
    .end local v0    # "listener":Lcom/facebook/react/uimanager/events/EventDispatcherListener;
    :cond_0
    iget-object v2, p0, Lcom/facebook/react/uimanager/events/EventDispatcher;->mEventsStagingLock:Ljava/lang/Object;

    monitor-enter v2

    .line 123
    :try_start_0
    iget-object v1, p0, Lcom/facebook/react/uimanager/events/EventDispatcher;->mEventStaging:Ljava/util/ArrayList;

    invoke-virtual {v1, p1}, Ljava/util/ArrayList;->add(Ljava/lang/Object;)Z

    .line 124
    const-wide/16 v4, 0x0

    .line 126
    invoke-virtual {p1}, Lcom/facebook/react/uimanager/events/Event;->getEventName()Ljava/lang/String;

    move-result-object v1

    .line 127
    invoke-virtual {p1}, Lcom/facebook/react/uimanager/events/Event;->getUniqueID()I

    move-result v3

    .line 124
    invoke-static {v4, v5, v1, v3}, Lcom/facebook/systrace/Systrace;->startAsyncFlow(JLjava/lang/String;I)V

    .line 128
    monitor-exit v2
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    .line 129
    iget-object v1, p0, Lcom/facebook/react/uimanager/events/EventDispatcher;->mRCTEventEmitter:Lcom/facebook/react/uimanager/events/RCTEventEmitter;

    if-eqz v1, :cond_1

    .line 132
    iget-object v1, p0, Lcom/facebook/react/uimanager/events/EventDispatcher;->mCurrentFrameCallback:Lcom/facebook/react/uimanager/events/EventDispatcher$ScheduleDispatchFrameCallback;

    invoke-virtual {v1}, Lcom/facebook/react/uimanager/events/EventDispatcher$ScheduleDispatchFrameCallback;->maybePostFromNonUI()V

    .line 139
    :cond_1
    return-void

    .line 128
    :catchall_0
    move-exception v1

    :try_start_1
    monitor-exit v2
    :try_end_1
    .catchall {:try_start_1 .. :try_end_1} :catchall_0

    throw v1
.end method

.method public onCatalystInstanceDestroyed()V
    .locals 1

    .prologue
    .line 174
    new-instance v0, Lcom/facebook/react/uimanager/events/EventDispatcher$2;

    invoke-direct {v0, p0}, Lcom/facebook/react/uimanager/events/EventDispatcher$2;-><init>(Lcom/facebook/react/uimanager/events/EventDispatcher;)V

    invoke-static {v0}, Lcom/facebook/react/bridge/UiThreadUtil;->runOnUiThread(Ljava/lang/Runnable;)V

    .line 180
    return-void
.end method

.method public onHostDestroy()V
    .locals 0

    .prologue
    .line 170
    invoke-direct {p0}, Lcom/facebook/react/uimanager/events/EventDispatcher;->stopFrameCallback()V

    .line 171
    return-void
.end method

.method public onHostPause()V
    .locals 0

    .prologue
    .line 165
    invoke-direct {p0}, Lcom/facebook/react/uimanager/events/EventDispatcher;->stopFrameCallback()V

    .line 166
    return-void
.end method

.method public onHostResume()V
    .locals 2

    .prologue
    .line 157
    iget-object v0, p0, Lcom/facebook/react/uimanager/events/EventDispatcher;->mRCTEventEmitter:Lcom/facebook/react/uimanager/events/RCTEventEmitter;

    if-nez v0, :cond_0

    .line 158
    iget-object v0, p0, Lcom/facebook/react/uimanager/events/EventDispatcher;->mReactContext:Lcom/facebook/react/bridge/ReactApplicationContext;

    const-class v1, Lcom/facebook/react/uimanager/events/RCTEventEmitter;

    invoke-virtual {v0, v1}, Lcom/facebook/react/bridge/ReactApplicationContext;->getJSModule(Ljava/lang/Class;)Lcom/facebook/react/bridge/JavaScriptModule;

    move-result-object v0

    check-cast v0, Lcom/facebook/react/uimanager/events/RCTEventEmitter;

    iput-object v0, p0, Lcom/facebook/react/uimanager/events/EventDispatcher;->mRCTEventEmitter:Lcom/facebook/react/uimanager/events/RCTEventEmitter;

    .line 160
    :cond_0
    iget-object v0, p0, Lcom/facebook/react/uimanager/events/EventDispatcher;->mCurrentFrameCallback:Lcom/facebook/react/uimanager/events/EventDispatcher$ScheduleDispatchFrameCallback;

    invoke-virtual {v0}, Lcom/facebook/react/uimanager/events/EventDispatcher$ScheduleDispatchFrameCallback;->maybePostFromNonUI()V

    .line 161
    return-void
.end method

.method public removeListener(Lcom/facebook/react/uimanager/events/EventDispatcherListener;)V
    .locals 1
    .param p1, "listener"    # Lcom/facebook/react/uimanager/events/EventDispatcherListener;

    .prologue
    .line 152
    iget-object v0, p0, Lcom/facebook/react/uimanager/events/EventDispatcher;->mListeners:Ljava/util/ArrayList;

    invoke-virtual {v0, p1}, Ljava/util/ArrayList;->remove(Ljava/lang/Object;)Z

    .line 153
    return-void
.end method

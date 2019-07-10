.class public Lcom/facebook/drawee/components/DraweeEventTracker;
.super Ljava/lang/Object;
.source "DraweeEventTracker.java"


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lcom/facebook/drawee/components/DraweeEventTracker$Event;
    }
.end annotation


# static fields
.field private static final MAX_EVENTS_TO_TRACK:I = 0x14

.field private static sEnabled:Z

.field private static final sInstance:Lcom/facebook/drawee/components/DraweeEventTracker;


# instance fields
.field private final mEventQueue:Ljava/util/Queue;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/Queue",
            "<",
            "Lcom/facebook/drawee/components/DraweeEventTracker$Event;",
            ">;"
        }
    .end annotation
.end field


# direct methods
.method static constructor <clinit>()V
    .locals 1

    .prologue
    .line 25
    new-instance v0, Lcom/facebook/drawee/components/DraweeEventTracker;

    invoke-direct {v0}, Lcom/facebook/drawee/components/DraweeEventTracker;-><init>()V

    sput-object v0, Lcom/facebook/drawee/components/DraweeEventTracker;->sInstance:Lcom/facebook/drawee/components/DraweeEventTracker;

    .line 27
    const/4 v0, 0x1

    sput-boolean v0, Lcom/facebook/drawee/components/DraweeEventTracker;->sEnabled:Z

    return-void
.end method

.method private constructor <init>()V
    .locals 2

    .prologue
    .line 56
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 22
    new-instance v0, Ljava/util/concurrent/ArrayBlockingQueue;

    const/16 v1, 0x14

    invoke-direct {v0, v1}, Ljava/util/concurrent/ArrayBlockingQueue;-><init>(I)V

    iput-object v0, p0, Lcom/facebook/drawee/components/DraweeEventTracker;->mEventQueue:Ljava/util/Queue;

    .line 57
    return-void
.end method

.method public static disable()V
    .locals 1

    .prologue
    .line 67
    const/4 v0, 0x0

    sput-boolean v0, Lcom/facebook/drawee/components/DraweeEventTracker;->sEnabled:Z

    .line 68
    return-void
.end method

.method public static newInstance()Lcom/facebook/drawee/components/DraweeEventTracker;
    .locals 1

    .prologue
    .line 60
    sget-boolean v0, Lcom/facebook/drawee/components/DraweeEventTracker;->sEnabled:Z

    if-eqz v0, :cond_0

    new-instance v0, Lcom/facebook/drawee/components/DraweeEventTracker;

    invoke-direct {v0}, Lcom/facebook/drawee/components/DraweeEventTracker;-><init>()V

    :goto_0
    return-object v0

    :cond_0
    sget-object v0, Lcom/facebook/drawee/components/DraweeEventTracker;->sInstance:Lcom/facebook/drawee/components/DraweeEventTracker;

    goto :goto_0
.end method


# virtual methods
.method public recordEvent(Lcom/facebook/drawee/components/DraweeEventTracker$Event;)V
    .locals 2
    .param p1, "event"    # Lcom/facebook/drawee/components/DraweeEventTracker$Event;

    .prologue
    .line 71
    sget-boolean v0, Lcom/facebook/drawee/components/DraweeEventTracker;->sEnabled:Z

    if-nez v0, :cond_0

    .line 78
    :goto_0
    return-void

    .line 74
    :cond_0
    iget-object v0, p0, Lcom/facebook/drawee/components/DraweeEventTracker;->mEventQueue:Ljava/util/Queue;

    invoke-interface {v0}, Ljava/util/Queue;->size()I

    move-result v0

    add-int/lit8 v0, v0, 0x1

    const/16 v1, 0x14

    if-le v0, v1, :cond_1

    .line 75
    iget-object v0, p0, Lcom/facebook/drawee/components/DraweeEventTracker;->mEventQueue:Ljava/util/Queue;

    invoke-interface {v0}, Ljava/util/Queue;->poll()Ljava/lang/Object;

    .line 77
    :cond_1
    iget-object v0, p0, Lcom/facebook/drawee/components/DraweeEventTracker;->mEventQueue:Ljava/util/Queue;

    invoke-interface {v0, p1}, Ljava/util/Queue;->add(Ljava/lang/Object;)Z

    goto :goto_0
.end method

.method public toString()Ljava/lang/String;
    .locals 1

    .prologue
    .line 82
    iget-object v0, p0, Lcom/facebook/drawee/components/DraweeEventTracker;->mEventQueue:Ljava/util/Queue;

    invoke-virtual {v0}, Ljava/lang/Object;->toString()Ljava/lang/String;

    move-result-object v0

    return-object v0
.end method

.class final Lcom/facebook/react/uimanager/events/EventDispatcher$1;
.super Ljava/lang/Object;
.source "EventDispatcher.java"

# interfaces
.implements Ljava/util/Comparator;


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/facebook/react/uimanager/events/EventDispatcher;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x8
    name = null
.end annotation

.annotation system Ldalvik/annotation/Signature;
    value = {
        "Ljava/lang/Object;",
        "Ljava/util/Comparator",
        "<",
        "Lcom/facebook/react/uimanager/events/Event;",
        ">;"
    }
.end annotation


# direct methods
.method constructor <init>()V
    .locals 0

    .prologue
    .line 65
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public compare(Lcom/facebook/react/uimanager/events/Event;Lcom/facebook/react/uimanager/events/Event;)I
    .locals 12
    .param p1, "lhs"    # Lcom/facebook/react/uimanager/events/Event;
    .param p2, "rhs"    # Lcom/facebook/react/uimanager/events/Event;

    .prologue
    const-wide/16 v10, 0x0

    const/4 v4, 0x1

    const/4 v2, 0x0

    const/4 v3, -0x1

    .line 68
    if-nez p1, :cond_1

    if-nez p2, :cond_1

    .line 84
    :cond_0
    :goto_0
    return v2

    .line 71
    :cond_1
    if-nez p1, :cond_2

    move v2, v3

    .line 72
    goto :goto_0

    .line 74
    :cond_2
    if-nez p2, :cond_3

    move v2, v4

    .line 75
    goto :goto_0

    .line 78
    :cond_3
    invoke-virtual {p1}, Lcom/facebook/react/uimanager/events/Event;->getTimestampMs()J

    move-result-wide v6

    invoke-virtual {p2}, Lcom/facebook/react/uimanager/events/Event;->getTimestampMs()J

    move-result-wide v8

    sub-long v0, v6, v8

    .line 79
    .local v0, "diff":J
    cmp-long v5, v0, v10

    if-eqz v5, :cond_0

    .line 81
    cmp-long v2, v0, v10

    if-gez v2, :cond_4

    move v2, v3

    .line 82
    goto :goto_0

    :cond_4
    move v2, v4

    .line 84
    goto :goto_0
.end method

.method public bridge synthetic compare(Ljava/lang/Object;Ljava/lang/Object;)I
    .locals 1

    .prologue
    .line 65
    check-cast p1, Lcom/facebook/react/uimanager/events/Event;

    check-cast p2, Lcom/facebook/react/uimanager/events/Event;

    invoke-virtual {p0, p1, p2}, Lcom/facebook/react/uimanager/events/EventDispatcher$1;->compare(Lcom/facebook/react/uimanager/events/Event;Lcom/facebook/react/uimanager/events/Event;)I

    move-result v0

    return v0
.end method

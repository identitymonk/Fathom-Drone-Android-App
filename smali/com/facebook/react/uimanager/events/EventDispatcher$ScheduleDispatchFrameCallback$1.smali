.class Lcom/facebook/react/uimanager/events/EventDispatcher$ScheduleDispatchFrameCallback$1;
.super Ljava/lang/Object;
.source "EventDispatcher.java"

# interfaces
.implements Ljava/lang/Runnable;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/facebook/react/uimanager/events/EventDispatcher$ScheduleDispatchFrameCallback;->maybePostFromNonUI()V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$1:Lcom/facebook/react/uimanager/events/EventDispatcher$ScheduleDispatchFrameCallback;


# direct methods
.method constructor <init>(Lcom/facebook/react/uimanager/events/EventDispatcher$ScheduleDispatchFrameCallback;)V
    .locals 0
    .param p1, "this$1"    # Lcom/facebook/react/uimanager/events/EventDispatcher$ScheduleDispatchFrameCallback;

    .prologue
    .line 315
    iput-object p1, p0, Lcom/facebook/react/uimanager/events/EventDispatcher$ScheduleDispatchFrameCallback$1;->this$1:Lcom/facebook/react/uimanager/events/EventDispatcher$ScheduleDispatchFrameCallback;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public run()V
    .locals 1

    .prologue
    .line 318
    iget-object v0, p0, Lcom/facebook/react/uimanager/events/EventDispatcher$ScheduleDispatchFrameCallback$1;->this$1:Lcom/facebook/react/uimanager/events/EventDispatcher$ScheduleDispatchFrameCallback;

    invoke-virtual {v0}, Lcom/facebook/react/uimanager/events/EventDispatcher$ScheduleDispatchFrameCallback;->maybePost()V

    .line 319
    return-void
.end method

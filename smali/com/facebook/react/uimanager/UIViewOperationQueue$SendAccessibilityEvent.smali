.class final Lcom/facebook/react/uimanager/UIViewOperationQueue$SendAccessibilityEvent;
.super Lcom/facebook/react/uimanager/UIViewOperationQueue$ViewOperation;
.source "UIViewOperationQueue.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/facebook/react/uimanager/UIViewOperationQueue;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x12
    name = "SendAccessibilityEvent"
.end annotation


# instance fields
.field private final mEventType:I

.field final synthetic this$0:Lcom/facebook/react/uimanager/UIViewOperationQueue;


# direct methods
.method private constructor <init>(Lcom/facebook/react/uimanager/UIViewOperationQueue;II)V
    .locals 0
    .param p2, "tag"    # I
    .param p3, "eventType"    # I

    .prologue
    .line 518
    iput-object p1, p0, Lcom/facebook/react/uimanager/UIViewOperationQueue$SendAccessibilityEvent;->this$0:Lcom/facebook/react/uimanager/UIViewOperationQueue;

    .line 519
    invoke-direct {p0, p1, p2}, Lcom/facebook/react/uimanager/UIViewOperationQueue$ViewOperation;-><init>(Lcom/facebook/react/uimanager/UIViewOperationQueue;I)V

    .line 520
    iput p3, p0, Lcom/facebook/react/uimanager/UIViewOperationQueue$SendAccessibilityEvent;->mEventType:I

    .line 521
    return-void
.end method

.method synthetic constructor <init>(Lcom/facebook/react/uimanager/UIViewOperationQueue;IILcom/facebook/react/uimanager/UIViewOperationQueue$1;)V
    .locals 0
    .param p1, "x0"    # Lcom/facebook/react/uimanager/UIViewOperationQueue;
    .param p2, "x1"    # I
    .param p3, "x2"    # I
    .param p4, "x3"    # Lcom/facebook/react/uimanager/UIViewOperationQueue$1;

    .prologue
    .line 514
    invoke-direct {p0, p1, p2, p3}, Lcom/facebook/react/uimanager/UIViewOperationQueue$SendAccessibilityEvent;-><init>(Lcom/facebook/react/uimanager/UIViewOperationQueue;II)V

    return-void
.end method


# virtual methods
.method public execute()V
    .locals 3

    .prologue
    .line 525
    iget-object v0, p0, Lcom/facebook/react/uimanager/UIViewOperationQueue$SendAccessibilityEvent;->this$0:Lcom/facebook/react/uimanager/UIViewOperationQueue;

    invoke-static {v0}, Lcom/facebook/react/uimanager/UIViewOperationQueue;->access$000(Lcom/facebook/react/uimanager/UIViewOperationQueue;)Lcom/facebook/react/uimanager/NativeViewHierarchyManager;

    move-result-object v0

    iget v1, p0, Lcom/facebook/react/uimanager/UIViewOperationQueue$SendAccessibilityEvent;->mTag:I

    iget v2, p0, Lcom/facebook/react/uimanager/UIViewOperationQueue$SendAccessibilityEvent;->mEventType:I

    invoke-virtual {v0, v1, v2}, Lcom/facebook/react/uimanager/NativeViewHierarchyManager;->sendAccessibilityEvent(II)V

    .line 526
    return-void
.end method

.class final Lcom/facebook/react/uimanager/UIViewOperationQueue$UpdatePropertiesOperation;
.super Lcom/facebook/react/uimanager/UIViewOperationQueue$ViewOperation;
.source "UIViewOperationQueue.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/facebook/react/uimanager/UIViewOperationQueue;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x12
    name = "UpdatePropertiesOperation"
.end annotation


# instance fields
.field private final mProps:Lcom/facebook/react/uimanager/ReactStylesDiffMap;

.field final synthetic this$0:Lcom/facebook/react/uimanager/UIViewOperationQueue;


# direct methods
.method private constructor <init>(Lcom/facebook/react/uimanager/UIViewOperationQueue;ILcom/facebook/react/uimanager/ReactStylesDiffMap;)V
    .locals 0
    .param p2, "tag"    # I
    .param p3, "props"    # Lcom/facebook/react/uimanager/ReactStylesDiffMap;

    .prologue
    .line 89
    iput-object p1, p0, Lcom/facebook/react/uimanager/UIViewOperationQueue$UpdatePropertiesOperation;->this$0:Lcom/facebook/react/uimanager/UIViewOperationQueue;

    .line 90
    invoke-direct {p0, p1, p2}, Lcom/facebook/react/uimanager/UIViewOperationQueue$ViewOperation;-><init>(Lcom/facebook/react/uimanager/UIViewOperationQueue;I)V

    .line 91
    iput-object p3, p0, Lcom/facebook/react/uimanager/UIViewOperationQueue$UpdatePropertiesOperation;->mProps:Lcom/facebook/react/uimanager/ReactStylesDiffMap;

    .line 92
    return-void
.end method

.method synthetic constructor <init>(Lcom/facebook/react/uimanager/UIViewOperationQueue;ILcom/facebook/react/uimanager/ReactStylesDiffMap;Lcom/facebook/react/uimanager/UIViewOperationQueue$1;)V
    .locals 0
    .param p1, "x0"    # Lcom/facebook/react/uimanager/UIViewOperationQueue;
    .param p2, "x1"    # I
    .param p3, "x2"    # Lcom/facebook/react/uimanager/ReactStylesDiffMap;
    .param p4, "x3"    # Lcom/facebook/react/uimanager/UIViewOperationQueue$1;

    .prologue
    .line 85
    invoke-direct {p0, p1, p2, p3}, Lcom/facebook/react/uimanager/UIViewOperationQueue$UpdatePropertiesOperation;-><init>(Lcom/facebook/react/uimanager/UIViewOperationQueue;ILcom/facebook/react/uimanager/ReactStylesDiffMap;)V

    return-void
.end method


# virtual methods
.method public execute()V
    .locals 3

    .prologue
    .line 96
    iget-object v0, p0, Lcom/facebook/react/uimanager/UIViewOperationQueue$UpdatePropertiesOperation;->this$0:Lcom/facebook/react/uimanager/UIViewOperationQueue;

    invoke-static {v0}, Lcom/facebook/react/uimanager/UIViewOperationQueue;->access$000(Lcom/facebook/react/uimanager/UIViewOperationQueue;)Lcom/facebook/react/uimanager/NativeViewHierarchyManager;

    move-result-object v0

    iget v1, p0, Lcom/facebook/react/uimanager/UIViewOperationQueue$UpdatePropertiesOperation;->mTag:I

    iget-object v2, p0, Lcom/facebook/react/uimanager/UIViewOperationQueue$UpdatePropertiesOperation;->mProps:Lcom/facebook/react/uimanager/ReactStylesDiffMap;

    invoke-virtual {v0, v1, v2}, Lcom/facebook/react/uimanager/NativeViewHierarchyManager;->updateProperties(ILcom/facebook/react/uimanager/ReactStylesDiffMap;)V

    .line 97
    return-void
.end method

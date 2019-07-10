.class final Lcom/facebook/react/uimanager/UIViewOperationQueue$RemoveRootViewOperation;
.super Lcom/facebook/react/uimanager/UIViewOperationQueue$ViewOperation;
.source "UIViewOperationQueue.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/facebook/react/uimanager/UIViewOperationQueue;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x12
    name = "RemoveRootViewOperation"
.end annotation


# instance fields
.field final synthetic this$0:Lcom/facebook/react/uimanager/UIViewOperationQueue;


# direct methods
.method public constructor <init>(Lcom/facebook/react/uimanager/UIViewOperationQueue;I)V
    .locals 0
    .param p2, "tag"    # I

    .prologue
    .line 75
    iput-object p1, p0, Lcom/facebook/react/uimanager/UIViewOperationQueue$RemoveRootViewOperation;->this$0:Lcom/facebook/react/uimanager/UIViewOperationQueue;

    .line 76
    invoke-direct {p0, p1, p2}, Lcom/facebook/react/uimanager/UIViewOperationQueue$ViewOperation;-><init>(Lcom/facebook/react/uimanager/UIViewOperationQueue;I)V

    .line 77
    return-void
.end method


# virtual methods
.method public execute()V
    .locals 2

    .prologue
    .line 81
    iget-object v0, p0, Lcom/facebook/react/uimanager/UIViewOperationQueue$RemoveRootViewOperation;->this$0:Lcom/facebook/react/uimanager/UIViewOperationQueue;

    invoke-static {v0}, Lcom/facebook/react/uimanager/UIViewOperationQueue;->access$000(Lcom/facebook/react/uimanager/UIViewOperationQueue;)Lcom/facebook/react/uimanager/NativeViewHierarchyManager;

    move-result-object v0

    iget v1, p0, Lcom/facebook/react/uimanager/UIViewOperationQueue$RemoveRootViewOperation;->mTag:I

    invoke-virtual {v0, v1}, Lcom/facebook/react/uimanager/NativeViewHierarchyManager;->removeRootView(I)V

    .line 82
    return-void
.end method

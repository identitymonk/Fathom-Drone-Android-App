.class final Lcom/facebook/react/uimanager/UIViewOperationQueue$SetChildrenOperation;
.super Lcom/facebook/react/uimanager/UIViewOperationQueue$ViewOperation;
.source "UIViewOperationQueue.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/facebook/react/uimanager/UIViewOperationQueue;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x12
    name = "SetChildrenOperation"
.end annotation


# instance fields
.field private final mChildrenTags:Lcom/facebook/react/bridge/ReadableArray;

.field final synthetic this$0:Lcom/facebook/react/uimanager/UIViewOperationQueue;


# direct methods
.method public constructor <init>(Lcom/facebook/react/uimanager/UIViewOperationQueue;ILcom/facebook/react/bridge/ReadableArray;)V
    .locals 0
    .param p2, "tag"    # I
    .param p3, "childrenTags"    # Lcom/facebook/react/bridge/ReadableArray;

    .prologue
    .line 194
    iput-object p1, p0, Lcom/facebook/react/uimanager/UIViewOperationQueue$SetChildrenOperation;->this$0:Lcom/facebook/react/uimanager/UIViewOperationQueue;

    .line 195
    invoke-direct {p0, p1, p2}, Lcom/facebook/react/uimanager/UIViewOperationQueue$ViewOperation;-><init>(Lcom/facebook/react/uimanager/UIViewOperationQueue;I)V

    .line 196
    iput-object p3, p0, Lcom/facebook/react/uimanager/UIViewOperationQueue$SetChildrenOperation;->mChildrenTags:Lcom/facebook/react/bridge/ReadableArray;

    .line 197
    return-void
.end method


# virtual methods
.method public execute()V
    .locals 3

    .prologue
    .line 201
    iget-object v0, p0, Lcom/facebook/react/uimanager/UIViewOperationQueue$SetChildrenOperation;->this$0:Lcom/facebook/react/uimanager/UIViewOperationQueue;

    invoke-static {v0}, Lcom/facebook/react/uimanager/UIViewOperationQueue;->access$000(Lcom/facebook/react/uimanager/UIViewOperationQueue;)Lcom/facebook/react/uimanager/NativeViewHierarchyManager;

    move-result-object v0

    iget v1, p0, Lcom/facebook/react/uimanager/UIViewOperationQueue$SetChildrenOperation;->mTag:I

    iget-object v2, p0, Lcom/facebook/react/uimanager/UIViewOperationQueue$SetChildrenOperation;->mChildrenTags:Lcom/facebook/react/bridge/ReadableArray;

    invoke-virtual {v0, v1, v2}, Lcom/facebook/react/uimanager/NativeViewHierarchyManager;->setChildren(ILcom/facebook/react/bridge/ReadableArray;)V

    .line 204
    return-void
.end method

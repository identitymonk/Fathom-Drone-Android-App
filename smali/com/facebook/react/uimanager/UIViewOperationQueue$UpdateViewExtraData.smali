.class final Lcom/facebook/react/uimanager/UIViewOperationQueue$UpdateViewExtraData;
.super Lcom/facebook/react/uimanager/UIViewOperationQueue$ViewOperation;
.source "UIViewOperationQueue.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/facebook/react/uimanager/UIViewOperationQueue;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x12
    name = "UpdateViewExtraData"
.end annotation


# instance fields
.field private final mExtraData:Ljava/lang/Object;

.field final synthetic this$0:Lcom/facebook/react/uimanager/UIViewOperationQueue;


# direct methods
.method public constructor <init>(Lcom/facebook/react/uimanager/UIViewOperationQueue;ILjava/lang/Object;)V
    .locals 0
    .param p2, "tag"    # I
    .param p3, "extraData"    # Ljava/lang/Object;

    .prologue
    .line 211
    iput-object p1, p0, Lcom/facebook/react/uimanager/UIViewOperationQueue$UpdateViewExtraData;->this$0:Lcom/facebook/react/uimanager/UIViewOperationQueue;

    .line 212
    invoke-direct {p0, p1, p2}, Lcom/facebook/react/uimanager/UIViewOperationQueue$ViewOperation;-><init>(Lcom/facebook/react/uimanager/UIViewOperationQueue;I)V

    .line 213
    iput-object p3, p0, Lcom/facebook/react/uimanager/UIViewOperationQueue$UpdateViewExtraData;->mExtraData:Ljava/lang/Object;

    .line 214
    return-void
.end method


# virtual methods
.method public execute()V
    .locals 3

    .prologue
    .line 218
    iget-object v0, p0, Lcom/facebook/react/uimanager/UIViewOperationQueue$UpdateViewExtraData;->this$0:Lcom/facebook/react/uimanager/UIViewOperationQueue;

    invoke-static {v0}, Lcom/facebook/react/uimanager/UIViewOperationQueue;->access$000(Lcom/facebook/react/uimanager/UIViewOperationQueue;)Lcom/facebook/react/uimanager/NativeViewHierarchyManager;

    move-result-object v0

    iget v1, p0, Lcom/facebook/react/uimanager/UIViewOperationQueue$UpdateViewExtraData;->mTag:I

    iget-object v2, p0, Lcom/facebook/react/uimanager/UIViewOperationQueue$UpdateViewExtraData;->mExtraData:Ljava/lang/Object;

    invoke-virtual {v0, v1, v2}, Lcom/facebook/react/uimanager/NativeViewHierarchyManager;->updateViewExtraData(ILjava/lang/Object;)V

    .line 219
    return-void
.end method

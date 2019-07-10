.class final Lcom/facebook/react/uimanager/UIViewOperationQueue$ChangeJSResponderOperation;
.super Lcom/facebook/react/uimanager/UIViewOperationQueue$ViewOperation;
.source "UIViewOperationQueue.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/facebook/react/uimanager/UIViewOperationQueue;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x12
    name = "ChangeJSResponderOperation"
.end annotation


# instance fields
.field private final mBlockNativeResponder:Z

.field private final mClearResponder:Z

.field private final mInitialTag:I

.field final synthetic this$0:Lcom/facebook/react/uimanager/UIViewOperationQueue;


# direct methods
.method public constructor <init>(Lcom/facebook/react/uimanager/UIViewOperationQueue;IIZZ)V
    .locals 0
    .param p2, "tag"    # I
    .param p3, "initialTag"    # I
    .param p4, "clearResponder"    # Z
    .param p5, "blockNativeResponder"    # Z

    .prologue
    .line 232
    iput-object p1, p0, Lcom/facebook/react/uimanager/UIViewOperationQueue$ChangeJSResponderOperation;->this$0:Lcom/facebook/react/uimanager/UIViewOperationQueue;

    .line 233
    invoke-direct {p0, p1, p2}, Lcom/facebook/react/uimanager/UIViewOperationQueue$ViewOperation;-><init>(Lcom/facebook/react/uimanager/UIViewOperationQueue;I)V

    .line 234
    iput p3, p0, Lcom/facebook/react/uimanager/UIViewOperationQueue$ChangeJSResponderOperation;->mInitialTag:I

    .line 235
    iput-boolean p4, p0, Lcom/facebook/react/uimanager/UIViewOperationQueue$ChangeJSResponderOperation;->mClearResponder:Z

    .line 236
    iput-boolean p5, p0, Lcom/facebook/react/uimanager/UIViewOperationQueue$ChangeJSResponderOperation;->mBlockNativeResponder:Z

    .line 237
    return-void
.end method


# virtual methods
.method public execute()V
    .locals 4

    .prologue
    .line 241
    iget-boolean v0, p0, Lcom/facebook/react/uimanager/UIViewOperationQueue$ChangeJSResponderOperation;->mClearResponder:Z

    if-nez v0, :cond_0

    .line 242
    iget-object v0, p0, Lcom/facebook/react/uimanager/UIViewOperationQueue$ChangeJSResponderOperation;->this$0:Lcom/facebook/react/uimanager/UIViewOperationQueue;

    invoke-static {v0}, Lcom/facebook/react/uimanager/UIViewOperationQueue;->access$000(Lcom/facebook/react/uimanager/UIViewOperationQueue;)Lcom/facebook/react/uimanager/NativeViewHierarchyManager;

    move-result-object v0

    iget v1, p0, Lcom/facebook/react/uimanager/UIViewOperationQueue$ChangeJSResponderOperation;->mTag:I

    iget v2, p0, Lcom/facebook/react/uimanager/UIViewOperationQueue$ChangeJSResponderOperation;->mInitialTag:I

    iget-boolean v3, p0, Lcom/facebook/react/uimanager/UIViewOperationQueue$ChangeJSResponderOperation;->mBlockNativeResponder:Z

    invoke-virtual {v0, v1, v2, v3}, Lcom/facebook/react/uimanager/NativeViewHierarchyManager;->setJSResponder(IIZ)V

    .line 246
    :goto_0
    return-void

    .line 244
    :cond_0
    iget-object v0, p0, Lcom/facebook/react/uimanager/UIViewOperationQueue$ChangeJSResponderOperation;->this$0:Lcom/facebook/react/uimanager/UIViewOperationQueue;

    invoke-static {v0}, Lcom/facebook/react/uimanager/UIViewOperationQueue;->access$000(Lcom/facebook/react/uimanager/UIViewOperationQueue;)Lcom/facebook/react/uimanager/NativeViewHierarchyManager;

    move-result-object v0

    invoke-virtual {v0}, Lcom/facebook/react/uimanager/NativeViewHierarchyManager;->clearJSResponder()V

    goto :goto_0
.end method

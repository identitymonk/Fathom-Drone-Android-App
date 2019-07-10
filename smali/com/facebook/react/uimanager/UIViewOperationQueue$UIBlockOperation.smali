.class Lcom/facebook/react/uimanager/UIViewOperationQueue$UIBlockOperation;
.super Ljava/lang/Object;
.source "UIViewOperationQueue.java"

# interfaces
.implements Lcom/facebook/react/uimanager/UIViewOperationQueue$UIOperation;


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/facebook/react/uimanager/UIViewOperationQueue;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x2
    name = "UIBlockOperation"
.end annotation


# instance fields
.field private final mBlock:Lcom/facebook/react/uimanager/UIBlock;

.field final synthetic this$0:Lcom/facebook/react/uimanager/UIViewOperationQueue;


# direct methods
.method public constructor <init>(Lcom/facebook/react/uimanager/UIViewOperationQueue;Lcom/facebook/react/uimanager/UIBlock;)V
    .locals 0
    .param p2, "block"    # Lcom/facebook/react/uimanager/UIBlock;

    .prologue
    .line 504
    iput-object p1, p0, Lcom/facebook/react/uimanager/UIViewOperationQueue$UIBlockOperation;->this$0:Lcom/facebook/react/uimanager/UIViewOperationQueue;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 505
    iput-object p2, p0, Lcom/facebook/react/uimanager/UIViewOperationQueue$UIBlockOperation;->mBlock:Lcom/facebook/react/uimanager/UIBlock;

    .line 506
    return-void
.end method


# virtual methods
.method public execute()V
    .locals 2

    .prologue
    .line 510
    iget-object v0, p0, Lcom/facebook/react/uimanager/UIViewOperationQueue$UIBlockOperation;->mBlock:Lcom/facebook/react/uimanager/UIBlock;

    iget-object v1, p0, Lcom/facebook/react/uimanager/UIViewOperationQueue$UIBlockOperation;->this$0:Lcom/facebook/react/uimanager/UIViewOperationQueue;

    invoke-static {v1}, Lcom/facebook/react/uimanager/UIViewOperationQueue;->access$000(Lcom/facebook/react/uimanager/UIViewOperationQueue;)Lcom/facebook/react/uimanager/NativeViewHierarchyManager;

    move-result-object v1

    invoke-interface {v0, v1}, Lcom/facebook/react/uimanager/UIBlock;->execute(Lcom/facebook/react/uimanager/NativeViewHierarchyManager;)V

    .line 511
    return-void
.end method

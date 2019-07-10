.class public final Lcom/facebook/react/flat/FlatUIViewOperationQueue$ViewManagerCommand;
.super Ljava/lang/Object;
.source "FlatUIViewOperationQueue.java"

# interfaces
.implements Lcom/facebook/react/uimanager/UIViewOperationQueue$UIOperation;


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/facebook/react/flat/FlatUIViewOperationQueue;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x11
    name = "ViewManagerCommand"
.end annotation


# instance fields
.field private final mArgs:Lcom/facebook/react/bridge/ReadableArray;
    .annotation runtime Ljavax/annotation/Nullable;
    .end annotation
.end field

.field private final mCommand:I

.field private final mReactTag:I

.field final synthetic this$0:Lcom/facebook/react/flat/FlatUIViewOperationQueue;


# direct methods
.method public constructor <init>(Lcom/facebook/react/flat/FlatUIViewOperationQueue;IILcom/facebook/react/bridge/ReadableArray;)V
    .locals 0
    .param p1, "this$0"    # Lcom/facebook/react/flat/FlatUIViewOperationQueue;
    .param p2, "reactTag"    # I
    .param p3, "command"    # I
        .annotation runtime Ljavax/annotation/Nullable;
        .end annotation
    .end param
    .param p4, "args"    # Lcom/facebook/react/bridge/ReadableArray;

    .prologue
    .line 385
    iput-object p1, p0, Lcom/facebook/react/flat/FlatUIViewOperationQueue$ViewManagerCommand;->this$0:Lcom/facebook/react/flat/FlatUIViewOperationQueue;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 386
    iput p2, p0, Lcom/facebook/react/flat/FlatUIViewOperationQueue$ViewManagerCommand;->mReactTag:I

    .line 387
    iput p3, p0, Lcom/facebook/react/flat/FlatUIViewOperationQueue$ViewManagerCommand;->mCommand:I

    .line 388
    iput-object p4, p0, Lcom/facebook/react/flat/FlatUIViewOperationQueue$ViewManagerCommand;->mArgs:Lcom/facebook/react/bridge/ReadableArray;

    .line 389
    return-void
.end method


# virtual methods
.method public execute()V
    .locals 4

    .prologue
    .line 393
    iget-object v0, p0, Lcom/facebook/react/flat/FlatUIViewOperationQueue$ViewManagerCommand;->this$0:Lcom/facebook/react/flat/FlatUIViewOperationQueue;

    invoke-static {v0}, Lcom/facebook/react/flat/FlatUIViewOperationQueue;->access$100(Lcom/facebook/react/flat/FlatUIViewOperationQueue;)Lcom/facebook/react/flat/FlatNativeViewHierarchyManager;

    move-result-object v0

    iget v1, p0, Lcom/facebook/react/flat/FlatUIViewOperationQueue$ViewManagerCommand;->mReactTag:I

    iget v2, p0, Lcom/facebook/react/flat/FlatUIViewOperationQueue$ViewManagerCommand;->mCommand:I

    iget-object v3, p0, Lcom/facebook/react/flat/FlatUIViewOperationQueue$ViewManagerCommand;->mArgs:Lcom/facebook/react/bridge/ReadableArray;

    invoke-virtual {v0, v1, v2, v3}, Lcom/facebook/react/flat/FlatNativeViewHierarchyManager;->dispatchCommand(IILcom/facebook/react/bridge/ReadableArray;)V

    .line 394
    return-void
.end method

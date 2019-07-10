.class final Lcom/facebook/react/flat/FlatUIViewOperationQueue$UpdateMountState;
.super Ljava/lang/Object;
.source "FlatUIViewOperationQueue.java"

# interfaces
.implements Lcom/facebook/react/uimanager/UIViewOperationQueue$UIOperation;


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/facebook/react/flat/FlatUIViewOperationQueue;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x12
    name = "UpdateMountState"
.end annotation


# instance fields
.field private final mAttachDetachListeners:[Lcom/facebook/react/flat/AttachDetachListener;
    .annotation runtime Ljavax/annotation/Nullable;
    .end annotation
.end field

.field private final mDrawCommands:[Lcom/facebook/react/flat/DrawCommand;
    .annotation runtime Ljavax/annotation/Nullable;
    .end annotation
.end field

.field private final mNodeRegions:[Lcom/facebook/react/flat/NodeRegion;
    .annotation runtime Ljavax/annotation/Nullable;
    .end annotation
.end field

.field private final mReactTag:I

.field final synthetic this$0:Lcom/facebook/react/flat/FlatUIViewOperationQueue;


# direct methods
.method private constructor <init>(Lcom/facebook/react/flat/FlatUIViewOperationQueue;I[Lcom/facebook/react/flat/DrawCommand;[Lcom/facebook/react/flat/AttachDetachListener;[Lcom/facebook/react/flat/NodeRegion;)V
    .locals 0
    .param p2, "reactTag"    # I
        .annotation runtime Ljavax/annotation/Nullable;
        .end annotation
    .end param
    .param p3, "drawCommands"    # [Lcom/facebook/react/flat/DrawCommand;
        .annotation runtime Ljavax/annotation/Nullable;
        .end annotation
    .end param
    .param p4, "listeners"    # [Lcom/facebook/react/flat/AttachDetachListener;
        .annotation runtime Ljavax/annotation/Nullable;
        .end annotation
    .end param
    .param p5, "nodeRegions"    # [Lcom/facebook/react/flat/NodeRegion;

    .prologue
    .line 58
    iput-object p1, p0, Lcom/facebook/react/flat/FlatUIViewOperationQueue$UpdateMountState;->this$0:Lcom/facebook/react/flat/FlatUIViewOperationQueue;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 59
    iput p2, p0, Lcom/facebook/react/flat/FlatUIViewOperationQueue$UpdateMountState;->mReactTag:I

    .line 60
    iput-object p3, p0, Lcom/facebook/react/flat/FlatUIViewOperationQueue$UpdateMountState;->mDrawCommands:[Lcom/facebook/react/flat/DrawCommand;

    .line 61
    iput-object p4, p0, Lcom/facebook/react/flat/FlatUIViewOperationQueue$UpdateMountState;->mAttachDetachListeners:[Lcom/facebook/react/flat/AttachDetachListener;

    .line 62
    iput-object p5, p0, Lcom/facebook/react/flat/FlatUIViewOperationQueue$UpdateMountState;->mNodeRegions:[Lcom/facebook/react/flat/NodeRegion;

    .line 63
    return-void
.end method

.method synthetic constructor <init>(Lcom/facebook/react/flat/FlatUIViewOperationQueue;I[Lcom/facebook/react/flat/DrawCommand;[Lcom/facebook/react/flat/AttachDetachListener;[Lcom/facebook/react/flat/NodeRegion;Lcom/facebook/react/flat/FlatUIViewOperationQueue$1;)V
    .locals 0
    .param p1, "x0"    # Lcom/facebook/react/flat/FlatUIViewOperationQueue;
    .param p2, "x1"    # I
    .param p3, "x2"    # [Lcom/facebook/react/flat/DrawCommand;
    .param p4, "x3"    # [Lcom/facebook/react/flat/AttachDetachListener;
    .param p5, "x4"    # [Lcom/facebook/react/flat/NodeRegion;
    .param p6, "x5"    # Lcom/facebook/react/flat/FlatUIViewOperationQueue$1;

    .prologue
    .line 47
    invoke-direct/range {p0 .. p5}, Lcom/facebook/react/flat/FlatUIViewOperationQueue$UpdateMountState;-><init>(Lcom/facebook/react/flat/FlatUIViewOperationQueue;I[Lcom/facebook/react/flat/DrawCommand;[Lcom/facebook/react/flat/AttachDetachListener;[Lcom/facebook/react/flat/NodeRegion;)V

    return-void
.end method


# virtual methods
.method public execute()V
    .locals 5

    .prologue
    .line 67
    iget-object v0, p0, Lcom/facebook/react/flat/FlatUIViewOperationQueue$UpdateMountState;->this$0:Lcom/facebook/react/flat/FlatUIViewOperationQueue;

    invoke-static {v0}, Lcom/facebook/react/flat/FlatUIViewOperationQueue;->access$100(Lcom/facebook/react/flat/FlatUIViewOperationQueue;)Lcom/facebook/react/flat/FlatNativeViewHierarchyManager;

    move-result-object v0

    iget v1, p0, Lcom/facebook/react/flat/FlatUIViewOperationQueue$UpdateMountState;->mReactTag:I

    iget-object v2, p0, Lcom/facebook/react/flat/FlatUIViewOperationQueue$UpdateMountState;->mDrawCommands:[Lcom/facebook/react/flat/DrawCommand;

    iget-object v3, p0, Lcom/facebook/react/flat/FlatUIViewOperationQueue$UpdateMountState;->mAttachDetachListeners:[Lcom/facebook/react/flat/AttachDetachListener;

    iget-object v4, p0, Lcom/facebook/react/flat/FlatUIViewOperationQueue$UpdateMountState;->mNodeRegions:[Lcom/facebook/react/flat/NodeRegion;

    invoke-virtual {v0, v1, v2, v3, v4}, Lcom/facebook/react/flat/FlatNativeViewHierarchyManager;->updateMountState(I[Lcom/facebook/react/flat/DrawCommand;[Lcom/facebook/react/flat/AttachDetachListener;[Lcom/facebook/react/flat/NodeRegion;)V

    .line 72
    return-void
.end method

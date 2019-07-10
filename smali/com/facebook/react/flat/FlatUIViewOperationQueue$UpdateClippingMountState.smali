.class final Lcom/facebook/react/flat/FlatUIViewOperationQueue$UpdateClippingMountState;
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
    name = "UpdateClippingMountState"
.end annotation


# instance fields
.field private final mAttachDetachListeners:[Lcom/facebook/react/flat/AttachDetachListener;
    .annotation runtime Ljavax/annotation/Nullable;
    .end annotation
.end field

.field private final mCommandMaxBot:[F

.field private final mCommandMinTop:[F

.field private final mDrawCommands:[Lcom/facebook/react/flat/DrawCommand;
    .annotation runtime Ljavax/annotation/Nullable;
    .end annotation
.end field

.field private final mDrawViewIndexMap:Landroid/util/SparseIntArray;

.field private final mNodeRegions:[Lcom/facebook/react/flat/NodeRegion;
    .annotation runtime Ljavax/annotation/Nullable;
    .end annotation
.end field

.field private final mReactTag:I

.field private final mRegionMaxBot:[F

.field private final mRegionMinTop:[F

.field private final mWillMountViews:Z

.field final synthetic this$0:Lcom/facebook/react/flat/FlatUIViewOperationQueue;


# direct methods
.method private constructor <init>(Lcom/facebook/react/flat/FlatUIViewOperationQueue;I[Lcom/facebook/react/flat/DrawCommand;Landroid/util/SparseIntArray;[F[F[Lcom/facebook/react/flat/AttachDetachListener;[Lcom/facebook/react/flat/NodeRegion;[F[FZ)V
    .locals 0
    .param p2, "reactTag"    # I
        .annotation runtime Ljavax/annotation/Nullable;
        .end annotation
    .end param
    .param p3, "drawCommands"    # [Lcom/facebook/react/flat/DrawCommand;
    .param p4, "drawViewIndexMap"    # Landroid/util/SparseIntArray;
    .param p5, "commandMaxBot"    # [F
    .param p6, "commandMinTop"    # [F
        .annotation runtime Ljavax/annotation/Nullable;
        .end annotation
    .end param
    .param p7, "listeners"    # [Lcom/facebook/react/flat/AttachDetachListener;
        .annotation runtime Ljavax/annotation/Nullable;
        .end annotation
    .end param
    .param p8, "nodeRegions"    # [Lcom/facebook/react/flat/NodeRegion;
    .param p9, "regionMaxBot"    # [F
    .param p10, "regionMinTop"    # [F
    .param p11, "willMountViews"    # Z

    .prologue
    .line 101
    iput-object p1, p0, Lcom/facebook/react/flat/FlatUIViewOperationQueue$UpdateClippingMountState;->this$0:Lcom/facebook/react/flat/FlatUIViewOperationQueue;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 102
    iput p2, p0, Lcom/facebook/react/flat/FlatUIViewOperationQueue$UpdateClippingMountState;->mReactTag:I

    .line 103
    iput-object p3, p0, Lcom/facebook/react/flat/FlatUIViewOperationQueue$UpdateClippingMountState;->mDrawCommands:[Lcom/facebook/react/flat/DrawCommand;

    .line 104
    iput-object p4, p0, Lcom/facebook/react/flat/FlatUIViewOperationQueue$UpdateClippingMountState;->mDrawViewIndexMap:Landroid/util/SparseIntArray;

    .line 105
    iput-object p5, p0, Lcom/facebook/react/flat/FlatUIViewOperationQueue$UpdateClippingMountState;->mCommandMaxBot:[F

    .line 106
    iput-object p6, p0, Lcom/facebook/react/flat/FlatUIViewOperationQueue$UpdateClippingMountState;->mCommandMinTop:[F

    .line 107
    iput-object p7, p0, Lcom/facebook/react/flat/FlatUIViewOperationQueue$UpdateClippingMountState;->mAttachDetachListeners:[Lcom/facebook/react/flat/AttachDetachListener;

    .line 108
    iput-object p8, p0, Lcom/facebook/react/flat/FlatUIViewOperationQueue$UpdateClippingMountState;->mNodeRegions:[Lcom/facebook/react/flat/NodeRegion;

    .line 109
    iput-object p9, p0, Lcom/facebook/react/flat/FlatUIViewOperationQueue$UpdateClippingMountState;->mRegionMaxBot:[F

    .line 110
    iput-object p10, p0, Lcom/facebook/react/flat/FlatUIViewOperationQueue$UpdateClippingMountState;->mRegionMinTop:[F

    .line 111
    iput-boolean p11, p0, Lcom/facebook/react/flat/FlatUIViewOperationQueue$UpdateClippingMountState;->mWillMountViews:Z

    .line 112
    return-void
.end method

.method synthetic constructor <init>(Lcom/facebook/react/flat/FlatUIViewOperationQueue;I[Lcom/facebook/react/flat/DrawCommand;Landroid/util/SparseIntArray;[F[F[Lcom/facebook/react/flat/AttachDetachListener;[Lcom/facebook/react/flat/NodeRegion;[F[FZLcom/facebook/react/flat/FlatUIViewOperationQueue$1;)V
    .locals 0
    .param p1, "x0"    # Lcom/facebook/react/flat/FlatUIViewOperationQueue;
    .param p2, "x1"    # I
    .param p3, "x2"    # [Lcom/facebook/react/flat/DrawCommand;
    .param p4, "x3"    # Landroid/util/SparseIntArray;
    .param p5, "x4"    # [F
    .param p6, "x5"    # [F
    .param p7, "x6"    # [Lcom/facebook/react/flat/AttachDetachListener;
    .param p8, "x7"    # [Lcom/facebook/react/flat/NodeRegion;
    .param p9, "x8"    # [F
    .param p10, "x9"    # [F
    .param p11, "x10"    # Z
    .param p12, "x11"    # Lcom/facebook/react/flat/FlatUIViewOperationQueue$1;

    .prologue
    .line 78
    invoke-direct/range {p0 .. p11}, Lcom/facebook/react/flat/FlatUIViewOperationQueue$UpdateClippingMountState;-><init>(Lcom/facebook/react/flat/FlatUIViewOperationQueue;I[Lcom/facebook/react/flat/DrawCommand;Landroid/util/SparseIntArray;[F[F[Lcom/facebook/react/flat/AttachDetachListener;[Lcom/facebook/react/flat/NodeRegion;[F[FZ)V

    return-void
.end method


# virtual methods
.method public execute()V
    .locals 11

    .prologue
    .line 116
    iget-object v0, p0, Lcom/facebook/react/flat/FlatUIViewOperationQueue$UpdateClippingMountState;->this$0:Lcom/facebook/react/flat/FlatUIViewOperationQueue;

    invoke-static {v0}, Lcom/facebook/react/flat/FlatUIViewOperationQueue;->access$100(Lcom/facebook/react/flat/FlatUIViewOperationQueue;)Lcom/facebook/react/flat/FlatNativeViewHierarchyManager;

    move-result-object v0

    iget v1, p0, Lcom/facebook/react/flat/FlatUIViewOperationQueue$UpdateClippingMountState;->mReactTag:I

    iget-object v2, p0, Lcom/facebook/react/flat/FlatUIViewOperationQueue$UpdateClippingMountState;->mDrawCommands:[Lcom/facebook/react/flat/DrawCommand;

    iget-object v3, p0, Lcom/facebook/react/flat/FlatUIViewOperationQueue$UpdateClippingMountState;->mDrawViewIndexMap:Landroid/util/SparseIntArray;

    iget-object v4, p0, Lcom/facebook/react/flat/FlatUIViewOperationQueue$UpdateClippingMountState;->mCommandMaxBot:[F

    iget-object v5, p0, Lcom/facebook/react/flat/FlatUIViewOperationQueue$UpdateClippingMountState;->mCommandMinTop:[F

    iget-object v6, p0, Lcom/facebook/react/flat/FlatUIViewOperationQueue$UpdateClippingMountState;->mAttachDetachListeners:[Lcom/facebook/react/flat/AttachDetachListener;

    iget-object v7, p0, Lcom/facebook/react/flat/FlatUIViewOperationQueue$UpdateClippingMountState;->mNodeRegions:[Lcom/facebook/react/flat/NodeRegion;

    iget-object v8, p0, Lcom/facebook/react/flat/FlatUIViewOperationQueue$UpdateClippingMountState;->mRegionMaxBot:[F

    iget-object v9, p0, Lcom/facebook/react/flat/FlatUIViewOperationQueue$UpdateClippingMountState;->mRegionMinTop:[F

    iget-boolean v10, p0, Lcom/facebook/react/flat/FlatUIViewOperationQueue$UpdateClippingMountState;->mWillMountViews:Z

    invoke-virtual/range {v0 .. v10}, Lcom/facebook/react/flat/FlatNativeViewHierarchyManager;->updateClippingMountState(I[Lcom/facebook/react/flat/DrawCommand;Landroid/util/SparseIntArray;[F[F[Lcom/facebook/react/flat/AttachDetachListener;[Lcom/facebook/react/flat/NodeRegion;[F[FZ)V

    .line 127
    return-void
.end method

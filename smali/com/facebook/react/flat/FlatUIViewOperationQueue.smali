.class final Lcom/facebook/react/flat/FlatUIViewOperationQueue;
.super Lcom/facebook/react/uimanager/UIViewOperationQueue;
.source "FlatUIViewOperationQueue.java"


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lcom/facebook/react/flat/FlatUIViewOperationQueue$ViewManagerCommand;,
        Lcom/facebook/react/flat/FlatUIViewOperationQueue$FindTargetForTouchOperation;,
        Lcom/facebook/react/flat/FlatUIViewOperationQueue$DetachAllChildrenFromViews;,
        Lcom/facebook/react/flat/FlatUIViewOperationQueue$MeasureVirtualView;,
        Lcom/facebook/react/flat/FlatUIViewOperationQueue$DropViews;,
        Lcom/facebook/react/flat/FlatUIViewOperationQueue$SetPadding;,
        Lcom/facebook/react/flat/FlatUIViewOperationQueue$UpdateViewBounds;,
        Lcom/facebook/react/flat/FlatUIViewOperationQueue$UpdateViewGroup;,
        Lcom/facebook/react/flat/FlatUIViewOperationQueue$UpdateClippingMountState;,
        Lcom/facebook/react/flat/FlatUIViewOperationQueue$UpdateMountState;,
        Lcom/facebook/react/flat/FlatUIViewOperationQueue$ProcessLayoutRequests;
    }
.end annotation


# static fields
.field private static final MEASURE_BUFFER:[I


# instance fields
.field private final mNativeViewHierarchyManager:Lcom/facebook/react/flat/FlatNativeViewHierarchyManager;

.field private final mProcessLayoutRequests:Lcom/facebook/react/flat/FlatUIViewOperationQueue$ProcessLayoutRequests;


# direct methods
.method static constructor <clinit>()V
    .locals 1

    .prologue
    .line 32
    const/4 v0, 0x4

    new-array v0, v0, [I

    sput-object v0, Lcom/facebook/react/flat/FlatUIViewOperationQueue;->MEASURE_BUFFER:[I

    return-void
.end method

.method public constructor <init>(Lcom/facebook/react/bridge/ReactApplicationContext;Lcom/facebook/react/flat/FlatNativeViewHierarchyManager;I)V
    .locals 2
    .param p1, "reactContext"    # Lcom/facebook/react/bridge/ReactApplicationContext;
    .param p2, "nativeViewHierarchyManager"    # Lcom/facebook/react/flat/FlatNativeViewHierarchyManager;
    .param p3, "minTimeLeftInFrameForNonBatchedOperationMs"    # I

    .prologue
    .line 401
    invoke-direct {p0, p1, p2, p3}, Lcom/facebook/react/uimanager/UIViewOperationQueue;-><init>(Lcom/facebook/react/bridge/ReactApplicationContext;Lcom/facebook/react/uimanager/NativeViewHierarchyManager;I)V

    .line 35
    new-instance v0, Lcom/facebook/react/flat/FlatUIViewOperationQueue$ProcessLayoutRequests;

    const/4 v1, 0x0

    invoke-direct {v0, p0, v1}, Lcom/facebook/react/flat/FlatUIViewOperationQueue$ProcessLayoutRequests;-><init>(Lcom/facebook/react/flat/FlatUIViewOperationQueue;Lcom/facebook/react/flat/FlatUIViewOperationQueue$1;)V

    iput-object v0, p0, Lcom/facebook/react/flat/FlatUIViewOperationQueue;->mProcessLayoutRequests:Lcom/facebook/react/flat/FlatUIViewOperationQueue$ProcessLayoutRequests;

    .line 403
    iput-object p2, p0, Lcom/facebook/react/flat/FlatUIViewOperationQueue;->mNativeViewHierarchyManager:Lcom/facebook/react/flat/FlatNativeViewHierarchyManager;

    .line 404
    return-void
.end method

.method static synthetic access$100(Lcom/facebook/react/flat/FlatUIViewOperationQueue;)Lcom/facebook/react/flat/FlatNativeViewHierarchyManager;
    .locals 1
    .param p0, "x0"    # Lcom/facebook/react/flat/FlatUIViewOperationQueue;

    .prologue
    .line 30
    iget-object v0, p0, Lcom/facebook/react/flat/FlatUIViewOperationQueue;->mNativeViewHierarchyManager:Lcom/facebook/react/flat/FlatNativeViewHierarchyManager;

    return-object v0
.end method

.method static synthetic access$200()[I
    .locals 1

    .prologue
    .line 30
    sget-object v0, Lcom/facebook/react/flat/FlatUIViewOperationQueue;->MEASURE_BUFFER:[I

    return-object v0
.end method


# virtual methods
.method public createUpdateViewBounds(IIIII)Lcom/facebook/react/flat/FlatUIViewOperationQueue$UpdateViewBounds;
    .locals 8
    .param p1, "reactTag"    # I
    .param p2, "left"    # I
    .param p3, "top"    # I
    .param p4, "right"    # I
    .param p5, "bottom"    # I

    .prologue
    .line 461
    new-instance v0, Lcom/facebook/react/flat/FlatUIViewOperationQueue$UpdateViewBounds;

    const/4 v7, 0x0

    move-object v1, p0

    move v2, p1

    move v3, p2

    move v4, p3

    move v5, p4

    move v6, p5

    invoke-direct/range {v0 .. v7}, Lcom/facebook/react/flat/FlatUIViewOperationQueue$UpdateViewBounds;-><init>(Lcom/facebook/react/flat/FlatUIViewOperationQueue;IIIIILcom/facebook/react/flat/FlatUIViewOperationQueue$1;)V

    return-object v0
.end method

.method public createViewManagerCommand(IILcom/facebook/react/bridge/ReadableArray;)Lcom/facebook/react/flat/FlatUIViewOperationQueue$ViewManagerCommand;
    .locals 1
    .param p1, "reactTag"    # I
    .param p2, "command"    # I
    .param p3, "args"    # Lcom/facebook/react/bridge/ReadableArray;
        .annotation runtime Ljavax/annotation/Nullable;
        .end annotation
    .end param

    .prologue
    .line 468
    new-instance v0, Lcom/facebook/react/flat/FlatUIViewOperationQueue$ViewManagerCommand;

    invoke-direct {v0, p0, p1, p2, p3}, Lcom/facebook/react/flat/FlatUIViewOperationQueue$ViewManagerCommand;-><init>(Lcom/facebook/react/flat/FlatUIViewOperationQueue;IILcom/facebook/react/bridge/ReadableArray;)V

    return-object v0
.end method

.method public enqueueDetachAllChildrenFromViews()Lcom/facebook/react/flat/FlatUIViewOperationQueue$DetachAllChildrenFromViews;
    .locals 1

    .prologue
    .line 514
    new-instance v0, Lcom/facebook/react/flat/FlatUIViewOperationQueue$DetachAllChildrenFromViews;

    invoke-direct {v0, p0}, Lcom/facebook/react/flat/FlatUIViewOperationQueue$DetachAllChildrenFromViews;-><init>(Lcom/facebook/react/flat/FlatUIViewOperationQueue;)V

    .line 515
    .local v0, "op":Lcom/facebook/react/flat/FlatUIViewOperationQueue$DetachAllChildrenFromViews;
    invoke-virtual {p0, v0}, Lcom/facebook/react/flat/FlatUIViewOperationQueue;->enqueueUIOperation(Lcom/facebook/react/uimanager/UIViewOperationQueue$UIOperation;)V

    .line 516
    return-object v0
.end method

.method public enqueueDropViews(Ljava/util/ArrayList;Ljava/util/ArrayList;)V
    .locals 2
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/util/ArrayList",
            "<",
            "Ljava/lang/Integer;",
            ">;",
            "Ljava/util/ArrayList",
            "<",
            "Ljava/lang/Integer;",
            ">;)V"
        }
    .end annotation

    .prologue
    .line 488
    .local p1, "viewsToDrop":Ljava/util/ArrayList;, "Ljava/util/ArrayList<Ljava/lang/Integer;>;"
    .local p2, "parentsOfViewsToDrop":Ljava/util/ArrayList;, "Ljava/util/ArrayList<Ljava/lang/Integer;>;"
    new-instance v0, Lcom/facebook/react/flat/FlatUIViewOperationQueue$DropViews;

    const/4 v1, 0x0

    invoke-direct {v0, p0, p1, p2, v1}, Lcom/facebook/react/flat/FlatUIViewOperationQueue$DropViews;-><init>(Lcom/facebook/react/flat/FlatUIViewOperationQueue;Ljava/util/ArrayList;Ljava/util/ArrayList;Lcom/facebook/react/flat/FlatUIViewOperationQueue$1;)V

    invoke-virtual {p0, v0}, Lcom/facebook/react/flat/FlatUIViewOperationQueue;->enqueueUIOperation(Lcom/facebook/react/uimanager/UIViewOperationQueue$UIOperation;)V

    .line 489
    return-void
.end method

.method public enqueueFindTargetForTouch(IFFLcom/facebook/react/bridge/Callback;)V
    .locals 7
    .param p1, "reactTag"    # I
    .param p2, "targetX"    # F
    .param p3, "targetY"    # F
    .param p4, "callback"    # Lcom/facebook/react/bridge/Callback;

    .prologue
    .line 525
    new-instance v0, Lcom/facebook/react/flat/FlatUIViewOperationQueue$FindTargetForTouchOperation;

    const/4 v6, 0x0

    move-object v1, p0

    move v2, p1

    move v3, p2

    move v4, p3

    move-object v5, p4

    invoke-direct/range {v0 .. v6}, Lcom/facebook/react/flat/FlatUIViewOperationQueue$FindTargetForTouchOperation;-><init>(Lcom/facebook/react/flat/FlatUIViewOperationQueue;IFFLcom/facebook/react/bridge/Callback;Lcom/facebook/react/flat/FlatUIViewOperationQueue$1;)V

    invoke-virtual {p0, v0}, Lcom/facebook/react/flat/FlatUIViewOperationQueue;->enqueueUIOperation(Lcom/facebook/react/uimanager/UIViewOperationQueue$UIOperation;)V

    .line 527
    return-void
.end method

.method enqueueFlatUIOperation(Lcom/facebook/react/uimanager/UIViewOperationQueue$UIOperation;)V
    .locals 0
    .param p1, "operation"    # Lcom/facebook/react/uimanager/UIViewOperationQueue$UIOperation;

    .prologue
    .line 472
    invoke-virtual {p0, p1}, Lcom/facebook/react/flat/FlatUIViewOperationQueue;->enqueueUIOperation(Lcom/facebook/react/uimanager/UIViewOperationQueue$UIOperation;)V

    .line 473
    return-void
.end method

.method public enqueueMeasureVirtualView(IFFFFZLcom/facebook/react/bridge/Callback;)V
    .locals 10
    .param p1, "reactTag"    # I
    .param p2, "scaledX"    # F
    .param p3, "scaledY"    # F
    .param p4, "scaledWidth"    # F
    .param p5, "scaledHeight"    # F
    .param p6, "relativeToWindow"    # Z
    .param p7, "callback"    # Lcom/facebook/react/bridge/Callback;

    .prologue
    .line 499
    new-instance v0, Lcom/facebook/react/flat/FlatUIViewOperationQueue$MeasureVirtualView;

    const/4 v9, 0x0

    move-object v1, p0

    move v2, p1

    move v3, p2

    move v4, p3

    move v5, p4

    move v6, p5

    move/from16 v7, p6

    move-object/from16 v8, p7

    invoke-direct/range {v0 .. v9}, Lcom/facebook/react/flat/FlatUIViewOperationQueue$MeasureVirtualView;-><init>(Lcom/facebook/react/flat/FlatUIViewOperationQueue;IFFFFZLcom/facebook/react/bridge/Callback;Lcom/facebook/react/flat/FlatUIViewOperationQueue$1;)V

    invoke-virtual {p0, v0}, Lcom/facebook/react/flat/FlatUIViewOperationQueue;->enqueueUIOperation(Lcom/facebook/react/uimanager/UIViewOperationQueue$UIOperation;)V

    .line 507
    return-void
.end method

.method public enqueueProcessLayoutRequests()V
    .locals 1

    .prologue
    .line 510
    iget-object v0, p0, Lcom/facebook/react/flat/FlatUIViewOperationQueue;->mProcessLayoutRequests:Lcom/facebook/react/flat/FlatUIViewOperationQueue$ProcessLayoutRequests;

    invoke-virtual {p0, v0}, Lcom/facebook/react/flat/FlatUIViewOperationQueue;->enqueueUIOperation(Lcom/facebook/react/uimanager/UIViewOperationQueue$UIOperation;)V

    .line 511
    return-void
.end method

.method public enqueueSetPadding(IIIII)V
    .locals 8
    .param p1, "reactTag"    # I
    .param p2, "paddingLeft"    # I
    .param p3, "paddingTop"    # I
    .param p4, "paddingRight"    # I
    .param p5, "paddingBottom"    # I

    .prologue
    .line 481
    new-instance v0, Lcom/facebook/react/flat/FlatUIViewOperationQueue$SetPadding;

    const/4 v7, 0x0

    move-object v1, p0

    move v2, p1

    move v3, p2

    move v4, p3

    move v5, p4

    move v6, p5

    invoke-direct/range {v0 .. v7}, Lcom/facebook/react/flat/FlatUIViewOperationQueue$SetPadding;-><init>(Lcom/facebook/react/flat/FlatUIViewOperationQueue;IIIIILcom/facebook/react/flat/FlatUIViewOperationQueue$1;)V

    invoke-virtual {p0, v0}, Lcom/facebook/react/flat/FlatUIViewOperationQueue;->enqueueUIOperation(Lcom/facebook/react/uimanager/UIViewOperationQueue$UIOperation;)V

    .line 483
    return-void
.end method

.method public enqueueUpdateClippingMountState(I[Lcom/facebook/react/flat/DrawCommand;Landroid/util/SparseIntArray;[F[F[Lcom/facebook/react/flat/AttachDetachListener;[Lcom/facebook/react/flat/NodeRegion;[F[FZ)V
    .locals 13
    .param p1, "reactTag"    # I
    .param p2, "drawCommands"    # [Lcom/facebook/react/flat/DrawCommand;
        .annotation runtime Ljavax/annotation/Nullable;
        .end annotation
    .end param
    .param p3, "drawViewIndexMap"    # Landroid/util/SparseIntArray;
    .param p4, "commandMaxBot"    # [F
    .param p5, "commandMinTop"    # [F
    .param p6, "listeners"    # [Lcom/facebook/react/flat/AttachDetachListener;
        .annotation runtime Ljavax/annotation/Nullable;
        .end annotation
    .end param
    .param p7, "nodeRegions"    # [Lcom/facebook/react/flat/NodeRegion;
        .annotation runtime Ljavax/annotation/Nullable;
        .end annotation
    .end param
    .param p8, "regionMaxBot"    # [F
    .param p9, "regionMinTop"    # [F
    .param p10, "willMountViews"    # Z

    .prologue
    .line 435
    new-instance v0, Lcom/facebook/react/flat/FlatUIViewOperationQueue$UpdateClippingMountState;

    const/4 v12, 0x0

    move-object v1, p0

    move v2, p1

    move-object v3, p2

    move-object/from16 v4, p3

    move-object/from16 v5, p4

    move-object/from16 v6, p5

    move-object/from16 v7, p6

    move-object/from16 v8, p7

    move-object/from16 v9, p8

    move-object/from16 v10, p9

    move/from16 v11, p10

    invoke-direct/range {v0 .. v12}, Lcom/facebook/react/flat/FlatUIViewOperationQueue$UpdateClippingMountState;-><init>(Lcom/facebook/react/flat/FlatUIViewOperationQueue;I[Lcom/facebook/react/flat/DrawCommand;Landroid/util/SparseIntArray;[F[F[Lcom/facebook/react/flat/AttachDetachListener;[Lcom/facebook/react/flat/NodeRegion;[F[FZLcom/facebook/react/flat/FlatUIViewOperationQueue$1;)V

    invoke-virtual {p0, v0}, Lcom/facebook/react/flat/FlatUIViewOperationQueue;->enqueueUIOperation(Lcom/facebook/react/uimanager/UIViewOperationQueue$UIOperation;)V

    .line 446
    return-void
.end method

.method public enqueueUpdateMountState(I[Lcom/facebook/react/flat/DrawCommand;[Lcom/facebook/react/flat/AttachDetachListener;[Lcom/facebook/react/flat/NodeRegion;)V
    .locals 7
    .param p1, "reactTag"    # I
    .param p2, "drawCommands"    # [Lcom/facebook/react/flat/DrawCommand;
        .annotation runtime Ljavax/annotation/Nullable;
        .end annotation
    .end param
    .param p3, "listeners"    # [Lcom/facebook/react/flat/AttachDetachListener;
        .annotation runtime Ljavax/annotation/Nullable;
        .end annotation
    .end param
    .param p4, "nodeRegions"    # [Lcom/facebook/react/flat/NodeRegion;
        .annotation runtime Ljavax/annotation/Nullable;
        .end annotation
    .end param

    .prologue
    .line 414
    new-instance v0, Lcom/facebook/react/flat/FlatUIViewOperationQueue$UpdateMountState;

    const/4 v6, 0x0

    move-object v1, p0

    move v2, p1

    move-object v3, p2

    move-object v4, p3

    move-object v5, p4

    invoke-direct/range {v0 .. v6}, Lcom/facebook/react/flat/FlatUIViewOperationQueue$UpdateMountState;-><init>(Lcom/facebook/react/flat/FlatUIViewOperationQueue;I[Lcom/facebook/react/flat/DrawCommand;[Lcom/facebook/react/flat/AttachDetachListener;[Lcom/facebook/react/flat/NodeRegion;Lcom/facebook/react/flat/FlatUIViewOperationQueue$1;)V

    invoke-virtual {p0, v0}, Lcom/facebook/react/flat/FlatUIViewOperationQueue;->enqueueUIOperation(Lcom/facebook/react/uimanager/UIViewOperationQueue$UIOperation;)V

    .line 419
    return-void
.end method

.method public enqueueUpdateViewGroup(I[I[I)V
    .locals 6
    .param p1, "reactTag"    # I
    .param p2, "viewsToAdd"    # [I
    .param p3, "viewsToDetach"    # [I

    .prologue
    .line 449
    new-instance v0, Lcom/facebook/react/flat/FlatUIViewOperationQueue$UpdateViewGroup;

    const/4 v5, 0x0

    move-object v1, p0

    move v2, p1

    move-object v3, p2

    move-object v4, p3

    invoke-direct/range {v0 .. v5}, Lcom/facebook/react/flat/FlatUIViewOperationQueue$UpdateViewGroup;-><init>(Lcom/facebook/react/flat/FlatUIViewOperationQueue;I[I[ILcom/facebook/react/flat/FlatUIViewOperationQueue$1;)V

    invoke-virtual {p0, v0}, Lcom/facebook/react/flat/FlatUIViewOperationQueue;->enqueueUIOperation(Lcom/facebook/react/uimanager/UIViewOperationQueue$UIOperation;)V

    .line 450
    return-void
.end method

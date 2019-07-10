.class final Lcom/facebook/react/uimanager/UIViewOperationQueue$FindTargetForTouchOperation;
.super Ljava/lang/Object;
.source "UIViewOperationQueue.java"

# interfaces
.implements Lcom/facebook/react/uimanager/UIViewOperationQueue$UIOperation;


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/facebook/react/uimanager/UIViewOperationQueue;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x12
    name = "FindTargetForTouchOperation"
.end annotation


# instance fields
.field private final mCallback:Lcom/facebook/react/bridge/Callback;

.field private final mReactTag:I

.field private final mTargetX:F

.field private final mTargetY:F

.field final synthetic this$0:Lcom/facebook/react/uimanager/UIViewOperationQueue;


# direct methods
.method private constructor <init>(Lcom/facebook/react/uimanager/UIViewOperationQueue;IFFLcom/facebook/react/bridge/Callback;)V
    .locals 0
    .param p2, "reactTag"    # I
    .param p3, "targetX"    # F
    .param p4, "targetY"    # F
    .param p5, "callback"    # Lcom/facebook/react/bridge/Callback;

    .prologue
    .line 456
    iput-object p1, p0, Lcom/facebook/react/uimanager/UIViewOperationQueue$FindTargetForTouchOperation;->this$0:Lcom/facebook/react/uimanager/UIViewOperationQueue;

    .line 457
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 458
    iput p2, p0, Lcom/facebook/react/uimanager/UIViewOperationQueue$FindTargetForTouchOperation;->mReactTag:I

    .line 459
    iput p3, p0, Lcom/facebook/react/uimanager/UIViewOperationQueue$FindTargetForTouchOperation;->mTargetX:F

    .line 460
    iput p4, p0, Lcom/facebook/react/uimanager/UIViewOperationQueue$FindTargetForTouchOperation;->mTargetY:F

    .line 461
    iput-object p5, p0, Lcom/facebook/react/uimanager/UIViewOperationQueue$FindTargetForTouchOperation;->mCallback:Lcom/facebook/react/bridge/Callback;

    .line 462
    return-void
.end method

.method synthetic constructor <init>(Lcom/facebook/react/uimanager/UIViewOperationQueue;IFFLcom/facebook/react/bridge/Callback;Lcom/facebook/react/uimanager/UIViewOperationQueue$1;)V
    .locals 0
    .param p1, "x0"    # Lcom/facebook/react/uimanager/UIViewOperationQueue;
    .param p2, "x1"    # I
    .param p3, "x2"    # F
    .param p4, "x3"    # F
    .param p5, "x4"    # Lcom/facebook/react/bridge/Callback;
    .param p6, "x5"    # Lcom/facebook/react/uimanager/UIViewOperationQueue$1;

    .prologue
    .line 445
    invoke-direct/range {p0 .. p5}, Lcom/facebook/react/uimanager/UIViewOperationQueue$FindTargetForTouchOperation;-><init>(Lcom/facebook/react/uimanager/UIViewOperationQueue;IFFLcom/facebook/react/bridge/Callback;)V

    return-void
.end method


# virtual methods
.method public execute()V
    .locals 12

    .prologue
    .line 467
    :try_start_0
    iget-object v8, p0, Lcom/facebook/react/uimanager/UIViewOperationQueue$FindTargetForTouchOperation;->this$0:Lcom/facebook/react/uimanager/UIViewOperationQueue;

    invoke-static {v8}, Lcom/facebook/react/uimanager/UIViewOperationQueue;->access$000(Lcom/facebook/react/uimanager/UIViewOperationQueue;)Lcom/facebook/react/uimanager/NativeViewHierarchyManager;

    move-result-object v8

    iget v9, p0, Lcom/facebook/react/uimanager/UIViewOperationQueue$FindTargetForTouchOperation;->mReactTag:I

    iget-object v10, p0, Lcom/facebook/react/uimanager/UIViewOperationQueue$FindTargetForTouchOperation;->this$0:Lcom/facebook/react/uimanager/UIViewOperationQueue;

    .line 469
    invoke-static {v10}, Lcom/facebook/react/uimanager/UIViewOperationQueue;->access$200(Lcom/facebook/react/uimanager/UIViewOperationQueue;)[I

    move-result-object v10

    .line 467
    invoke-virtual {v8, v9, v10}, Lcom/facebook/react/uimanager/NativeViewHierarchyManager;->measure(I[I)V
    :try_end_0
    .catch Lcom/facebook/react/uimanager/IllegalViewOperationException; {:try_start_0 .. :try_end_0} :catch_0

    .line 477
    iget-object v8, p0, Lcom/facebook/react/uimanager/UIViewOperationQueue$FindTargetForTouchOperation;->this$0:Lcom/facebook/react/uimanager/UIViewOperationQueue;

    invoke-static {v8}, Lcom/facebook/react/uimanager/UIViewOperationQueue;->access$200(Lcom/facebook/react/uimanager/UIViewOperationQueue;)[I

    move-result-object v8

    const/4 v9, 0x0

    aget v8, v8, v9

    int-to-float v0, v8

    .line 478
    .local v0, "containerX":F
    iget-object v8, p0, Lcom/facebook/react/uimanager/UIViewOperationQueue$FindTargetForTouchOperation;->this$0:Lcom/facebook/react/uimanager/UIViewOperationQueue;

    invoke-static {v8}, Lcom/facebook/react/uimanager/UIViewOperationQueue;->access$200(Lcom/facebook/react/uimanager/UIViewOperationQueue;)[I

    move-result-object v8

    const/4 v9, 0x1

    aget v8, v8, v9

    int-to-float v1, v8

    .line 480
    .local v1, "containerY":F
    iget-object v8, p0, Lcom/facebook/react/uimanager/UIViewOperationQueue$FindTargetForTouchOperation;->this$0:Lcom/facebook/react/uimanager/UIViewOperationQueue;

    invoke-static {v8}, Lcom/facebook/react/uimanager/UIViewOperationQueue;->access$000(Lcom/facebook/react/uimanager/UIViewOperationQueue;)Lcom/facebook/react/uimanager/NativeViewHierarchyManager;

    move-result-object v8

    iget v9, p0, Lcom/facebook/react/uimanager/UIViewOperationQueue$FindTargetForTouchOperation;->mReactTag:I

    iget v10, p0, Lcom/facebook/react/uimanager/UIViewOperationQueue$FindTargetForTouchOperation;->mTargetX:F

    iget v11, p0, Lcom/facebook/react/uimanager/UIViewOperationQueue$FindTargetForTouchOperation;->mTargetY:F

    invoke-virtual {v8, v9, v10, v11}, Lcom/facebook/react/uimanager/NativeViewHierarchyManager;->findTargetTagForTouch(IFF)I

    move-result v4

    .line 486
    .local v4, "touchTargetReactTag":I
    :try_start_1
    iget-object v8, p0, Lcom/facebook/react/uimanager/UIViewOperationQueue$FindTargetForTouchOperation;->this$0:Lcom/facebook/react/uimanager/UIViewOperationQueue;

    invoke-static {v8}, Lcom/facebook/react/uimanager/UIViewOperationQueue;->access$000(Lcom/facebook/react/uimanager/UIViewOperationQueue;)Lcom/facebook/react/uimanager/NativeViewHierarchyManager;

    move-result-object v8

    iget-object v9, p0, Lcom/facebook/react/uimanager/UIViewOperationQueue$FindTargetForTouchOperation;->this$0:Lcom/facebook/react/uimanager/UIViewOperationQueue;

    .line 488
    invoke-static {v9}, Lcom/facebook/react/uimanager/UIViewOperationQueue;->access$200(Lcom/facebook/react/uimanager/UIViewOperationQueue;)[I

    move-result-object v9

    .line 486
    invoke-virtual {v8, v4, v9}, Lcom/facebook/react/uimanager/NativeViewHierarchyManager;->measure(I[I)V
    :try_end_1
    .catch Lcom/facebook/react/uimanager/IllegalViewOperationException; {:try_start_1 .. :try_end_1} :catch_1

    .line 494
    iget-object v8, p0, Lcom/facebook/react/uimanager/UIViewOperationQueue$FindTargetForTouchOperation;->this$0:Lcom/facebook/react/uimanager/UIViewOperationQueue;

    invoke-static {v8}, Lcom/facebook/react/uimanager/UIViewOperationQueue;->access$200(Lcom/facebook/react/uimanager/UIViewOperationQueue;)[I

    move-result-object v8

    const/4 v9, 0x0

    aget v8, v8, v9

    int-to-float v8, v8

    sub-float/2addr v8, v0

    invoke-static {v8}, Lcom/facebook/react/uimanager/PixelUtil;->toDIPFromPixel(F)F

    move-result v6

    .line 495
    .local v6, "x":F
    iget-object v8, p0, Lcom/facebook/react/uimanager/UIViewOperationQueue$FindTargetForTouchOperation;->this$0:Lcom/facebook/react/uimanager/UIViewOperationQueue;

    invoke-static {v8}, Lcom/facebook/react/uimanager/UIViewOperationQueue;->access$200(Lcom/facebook/react/uimanager/UIViewOperationQueue;)[I

    move-result-object v8

    const/4 v9, 0x1

    aget v8, v8, v9

    int-to-float v8, v8

    sub-float/2addr v8, v1

    invoke-static {v8}, Lcom/facebook/react/uimanager/PixelUtil;->toDIPFromPixel(F)F

    move-result v7

    .line 496
    .local v7, "y":F
    iget-object v8, p0, Lcom/facebook/react/uimanager/UIViewOperationQueue$FindTargetForTouchOperation;->this$0:Lcom/facebook/react/uimanager/UIViewOperationQueue;

    invoke-static {v8}, Lcom/facebook/react/uimanager/UIViewOperationQueue;->access$200(Lcom/facebook/react/uimanager/UIViewOperationQueue;)[I

    move-result-object v8

    const/4 v9, 0x2

    aget v8, v8, v9

    int-to-float v8, v8

    invoke-static {v8}, Lcom/facebook/react/uimanager/PixelUtil;->toDIPFromPixel(F)F

    move-result v5

    .line 497
    .local v5, "width":F
    iget-object v8, p0, Lcom/facebook/react/uimanager/UIViewOperationQueue$FindTargetForTouchOperation;->this$0:Lcom/facebook/react/uimanager/UIViewOperationQueue;

    invoke-static {v8}, Lcom/facebook/react/uimanager/UIViewOperationQueue;->access$200(Lcom/facebook/react/uimanager/UIViewOperationQueue;)[I

    move-result-object v8

    const/4 v9, 0x3

    aget v8, v8, v9

    int-to-float v8, v8

    invoke-static {v8}, Lcom/facebook/react/uimanager/PixelUtil;->toDIPFromPixel(F)F

    move-result v3

    .line 498
    .local v3, "height":F
    iget-object v8, p0, Lcom/facebook/react/uimanager/UIViewOperationQueue$FindTargetForTouchOperation;->mCallback:Lcom/facebook/react/bridge/Callback;

    const/4 v9, 0x5

    new-array v9, v9, [Ljava/lang/Object;

    const/4 v10, 0x0

    invoke-static {v4}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v11

    aput-object v11, v9, v10

    const/4 v10, 0x1

    invoke-static {v6}, Ljava/lang/Float;->valueOf(F)Ljava/lang/Float;

    move-result-object v11

    aput-object v11, v9, v10

    const/4 v10, 0x2

    invoke-static {v7}, Ljava/lang/Float;->valueOf(F)Ljava/lang/Float;

    move-result-object v11

    aput-object v11, v9, v10

    const/4 v10, 0x3

    invoke-static {v5}, Ljava/lang/Float;->valueOf(F)Ljava/lang/Float;

    move-result-object v11

    aput-object v11, v9, v10

    const/4 v10, 0x4

    invoke-static {v3}, Ljava/lang/Float;->valueOf(F)Ljava/lang/Float;

    move-result-object v11

    aput-object v11, v9, v10

    invoke-interface {v8, v9}, Lcom/facebook/react/bridge/Callback;->invoke([Ljava/lang/Object;)V

    .line 499
    .end local v0    # "containerX":F
    .end local v1    # "containerY":F
    .end local v3    # "height":F
    .end local v4    # "touchTargetReactTag":I
    .end local v5    # "width":F
    .end local v6    # "x":F
    .end local v7    # "y":F
    :goto_0
    return-void

    .line 470
    :catch_0
    move-exception v2

    .line 471
    .local v2, "e":Lcom/facebook/react/uimanager/IllegalViewOperationException;
    iget-object v8, p0, Lcom/facebook/react/uimanager/UIViewOperationQueue$FindTargetForTouchOperation;->mCallback:Lcom/facebook/react/bridge/Callback;

    const/4 v9, 0x0

    new-array v9, v9, [Ljava/lang/Object;

    invoke-interface {v8, v9}, Lcom/facebook/react/bridge/Callback;->invoke([Ljava/lang/Object;)V

    goto :goto_0

    .line 489
    .end local v2    # "e":Lcom/facebook/react/uimanager/IllegalViewOperationException;
    .restart local v0    # "containerX":F
    .restart local v1    # "containerY":F
    .restart local v4    # "touchTargetReactTag":I
    :catch_1
    move-exception v2

    .line 490
    .restart local v2    # "e":Lcom/facebook/react/uimanager/IllegalViewOperationException;
    iget-object v8, p0, Lcom/facebook/react/uimanager/UIViewOperationQueue$FindTargetForTouchOperation;->mCallback:Lcom/facebook/react/bridge/Callback;

    const/4 v9, 0x0

    new-array v9, v9, [Ljava/lang/Object;

    invoke-interface {v8, v9}, Lcom/facebook/react/bridge/Callback;->invoke([Ljava/lang/Object;)V

    goto :goto_0
.end method

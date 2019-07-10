.class final Lcom/facebook/react/flat/FlatUIViewOperationQueue$FindTargetForTouchOperation;
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
    name = "FindTargetForTouchOperation"
.end annotation


# instance fields
.field private final NATIVE_VIEW_BUFFER:[I

.field private final mCallback:Lcom/facebook/react/bridge/Callback;

.field private final mReactTag:I

.field private final mTargetX:F

.field private final mTargetY:F

.field final synthetic this$0:Lcom/facebook/react/flat/FlatUIViewOperationQueue;


# direct methods
.method private constructor <init>(Lcom/facebook/react/flat/FlatUIViewOperationQueue;IFFLcom/facebook/react/bridge/Callback;)V
    .locals 1
    .param p2, "reactTag"    # I
    .param p3, "targetX"    # F
    .param p4, "targetY"    # F
    .param p5, "callback"    # Lcom/facebook/react/bridge/Callback;

    .prologue
    .line 312
    iput-object p1, p0, Lcom/facebook/react/flat/FlatUIViewOperationQueue$FindTargetForTouchOperation;->this$0:Lcom/facebook/react/flat/FlatUIViewOperationQueue;

    .line 313
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 306
    const/4 v0, 0x1

    new-array v0, v0, [I

    iput-object v0, p0, Lcom/facebook/react/flat/FlatUIViewOperationQueue$FindTargetForTouchOperation;->NATIVE_VIEW_BUFFER:[I

    .line 314
    iput p2, p0, Lcom/facebook/react/flat/FlatUIViewOperationQueue$FindTargetForTouchOperation;->mReactTag:I

    .line 315
    iput p3, p0, Lcom/facebook/react/flat/FlatUIViewOperationQueue$FindTargetForTouchOperation;->mTargetX:F

    .line 316
    iput p4, p0, Lcom/facebook/react/flat/FlatUIViewOperationQueue$FindTargetForTouchOperation;->mTargetY:F

    .line 317
    iput-object p5, p0, Lcom/facebook/react/flat/FlatUIViewOperationQueue$FindTargetForTouchOperation;->mCallback:Lcom/facebook/react/bridge/Callback;

    .line 318
    return-void
.end method

.method synthetic constructor <init>(Lcom/facebook/react/flat/FlatUIViewOperationQueue;IFFLcom/facebook/react/bridge/Callback;Lcom/facebook/react/flat/FlatUIViewOperationQueue$1;)V
    .locals 0
    .param p1, "x0"    # Lcom/facebook/react/flat/FlatUIViewOperationQueue;
    .param p2, "x1"    # I
    .param p3, "x2"    # F
    .param p4, "x3"    # F
    .param p5, "x4"    # Lcom/facebook/react/bridge/Callback;
    .param p6, "x5"    # Lcom/facebook/react/flat/FlatUIViewOperationQueue$1;

    .prologue
    .line 300
    invoke-direct/range {p0 .. p5}, Lcom/facebook/react/flat/FlatUIViewOperationQueue$FindTargetForTouchOperation;-><init>(Lcom/facebook/react/flat/FlatUIViewOperationQueue;IFFLcom/facebook/react/bridge/Callback;)V

    return-void
.end method


# virtual methods
.method public execute()V
    .locals 17

    .prologue
    .line 323
    :try_start_0
    move-object/from16 v0, p0

    iget-object v13, v0, Lcom/facebook/react/flat/FlatUIViewOperationQueue$FindTargetForTouchOperation;->this$0:Lcom/facebook/react/flat/FlatUIViewOperationQueue;

    invoke-static {v13}, Lcom/facebook/react/flat/FlatUIViewOperationQueue;->access$100(Lcom/facebook/react/flat/FlatUIViewOperationQueue;)Lcom/facebook/react/flat/FlatNativeViewHierarchyManager;

    move-result-object v13

    move-object/from16 v0, p0

    iget v14, v0, Lcom/facebook/react/flat/FlatUIViewOperationQueue$FindTargetForTouchOperation;->mReactTag:I

    invoke-static {}, Lcom/facebook/react/flat/FlatUIViewOperationQueue;->access$200()[I

    move-result-object v15

    invoke-virtual {v13, v14, v15}, Lcom/facebook/react/flat/FlatNativeViewHierarchyManager;->measure(I[I)V
    :try_end_0
    .catch Lcom/facebook/react/uimanager/IllegalViewOperationException; {:try_start_0 .. :try_end_0} :catch_0

    .line 331
    invoke-static {}, Lcom/facebook/react/flat/FlatUIViewOperationQueue;->access$200()[I

    move-result-object v13

    const/4 v14, 0x0

    aget v13, v13, v14

    int-to-float v1, v13

    .line 332
    .local v1, "containerX":F
    invoke-static {}, Lcom/facebook/react/flat/FlatUIViewOperationQueue;->access$200()[I

    move-result-object v13

    const/4 v14, 0x1

    aget v13, v13, v14

    int-to-float v2, v13

    .line 334
    .local v2, "containerY":F
    move-object/from16 v0, p0

    iget-object v13, v0, Lcom/facebook/react/flat/FlatUIViewOperationQueue$FindTargetForTouchOperation;->this$0:Lcom/facebook/react/flat/FlatUIViewOperationQueue;

    invoke-static {v13}, Lcom/facebook/react/flat/FlatUIViewOperationQueue;->access$100(Lcom/facebook/react/flat/FlatUIViewOperationQueue;)Lcom/facebook/react/flat/FlatNativeViewHierarchyManager;

    move-result-object v13

    move-object/from16 v0, p0

    iget v14, v0, Lcom/facebook/react/flat/FlatUIViewOperationQueue$FindTargetForTouchOperation;->mReactTag:I

    invoke-virtual {v13, v14}, Lcom/facebook/react/flat/FlatNativeViewHierarchyManager;->getView(I)Landroid/view/View;

    move-result-object v9

    .line 335
    .local v9, "view":Landroid/view/View;
    move-object/from16 v0, p0

    iget v14, v0, Lcom/facebook/react/flat/FlatUIViewOperationQueue$FindTargetForTouchOperation;->mTargetX:F

    move-object/from16 v0, p0

    iget v15, v0, Lcom/facebook/react/flat/FlatUIViewOperationQueue$FindTargetForTouchOperation;->mTargetY:F

    move-object v13, v9

    check-cast v13, Landroid/view/ViewGroup;

    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/facebook/react/flat/FlatUIViewOperationQueue$FindTargetForTouchOperation;->NATIVE_VIEW_BUFFER:[I

    move-object/from16 v16, v0

    move-object/from16 v0, v16

    invoke-static {v14, v15, v13, v0}, Lcom/facebook/react/uimanager/TouchTargetHelper;->findTargetTagForTouch(FFLandroid/view/ViewGroup;[I)I

    move-result v8

    .line 342
    .local v8, "touchTargetReactTag":I
    :try_start_1
    move-object/from16 v0, p0

    iget-object v13, v0, Lcom/facebook/react/flat/FlatUIViewOperationQueue$FindTargetForTouchOperation;->this$0:Lcom/facebook/react/flat/FlatUIViewOperationQueue;

    invoke-static {v13}, Lcom/facebook/react/flat/FlatUIViewOperationQueue;->access$100(Lcom/facebook/react/flat/FlatUIViewOperationQueue;)Lcom/facebook/react/flat/FlatNativeViewHierarchyManager;

    move-result-object v13

    move-object/from16 v0, p0

    iget-object v14, v0, Lcom/facebook/react/flat/FlatUIViewOperationQueue$FindTargetForTouchOperation;->NATIVE_VIEW_BUFFER:[I

    const/4 v15, 0x0

    aget v14, v14, v15

    .line 344
    invoke-static {}, Lcom/facebook/react/flat/FlatUIViewOperationQueue;->access$200()[I

    move-result-object v15

    .line 342
    invoke-virtual {v13, v14, v15}, Lcom/facebook/react/flat/FlatNativeViewHierarchyManager;->measure(I[I)V
    :try_end_1
    .catch Lcom/facebook/react/uimanager/IllegalViewOperationException; {:try_start_1 .. :try_end_1} :catch_1

    .line 350
    sget-object v6, Lcom/facebook/react/flat/NodeRegion;->EMPTY:Lcom/facebook/react/flat/NodeRegion;

    .line 351
    .local v6, "region":Lcom/facebook/react/flat/NodeRegion;
    move-object/from16 v0, p0

    iget-object v13, v0, Lcom/facebook/react/flat/FlatUIViewOperationQueue$FindTargetForTouchOperation;->NATIVE_VIEW_BUFFER:[I

    const/4 v14, 0x0

    aget v13, v13, v14

    if-ne v13, v8, :cond_1

    const/4 v5, 0x1

    .line 352
    .local v5, "isNativeView":Z
    :goto_0
    if-nez v5, :cond_0

    .line 355
    move-object/from16 v0, p0

    iget-object v13, v0, Lcom/facebook/react/flat/FlatUIViewOperationQueue$FindTargetForTouchOperation;->this$0:Lcom/facebook/react/flat/FlatUIViewOperationQueue;

    invoke-static {v13}, Lcom/facebook/react/flat/FlatUIViewOperationQueue;->access$100(Lcom/facebook/react/flat/FlatUIViewOperationQueue;)Lcom/facebook/react/flat/FlatNativeViewHierarchyManager;

    move-result-object v13

    move-object/from16 v0, p0

    iget-object v14, v0, Lcom/facebook/react/flat/FlatUIViewOperationQueue$FindTargetForTouchOperation;->NATIVE_VIEW_BUFFER:[I

    const/4 v15, 0x0

    aget v14, v14, v15

    invoke-virtual {v13, v14}, Lcom/facebook/react/flat/FlatNativeViewHierarchyManager;->getView(I)Landroid/view/View;

    move-result-object v9

    .line 356
    instance-of v13, v9, Lcom/facebook/react/flat/FlatViewGroup;

    if-eqz v13, :cond_0

    move-object v13, v9

    .line 357
    check-cast v13, Lcom/facebook/react/flat/FlatViewGroup;

    move-object/from16 v0, p0

    iget v14, v0, Lcom/facebook/react/flat/FlatUIViewOperationQueue$FindTargetForTouchOperation;->mReactTag:I

    invoke-virtual {v13, v14}, Lcom/facebook/react/flat/FlatViewGroup;->getNodeRegionForTag(I)Lcom/facebook/react/flat/NodeRegion;

    move-result-object v6

    .line 361
    :cond_0
    sget-object v13, Lcom/facebook/react/flat/NodeRegion;->EMPTY:Lcom/facebook/react/flat/NodeRegion;

    if-ne v6, v13, :cond_2

    move v7, v8

    .line 362
    .local v7, "resultTag":I
    :goto_1
    invoke-virtual {v6}, Lcom/facebook/react/flat/NodeRegion;->getLeft()F

    move-result v13

    invoke-static {}, Lcom/facebook/react/flat/FlatUIViewOperationQueue;->access$200()[I

    move-result-object v14

    const/4 v15, 0x0

    aget v14, v14, v15

    int-to-float v14, v14

    add-float/2addr v13, v14

    sub-float/2addr v13, v1

    invoke-static {v13}, Lcom/facebook/react/uimanager/PixelUtil;->toDIPFromPixel(F)F

    move-result v11

    .line 363
    .local v11, "x":F
    invoke-virtual {v6}, Lcom/facebook/react/flat/NodeRegion;->getTop()F

    move-result v13

    invoke-static {}, Lcom/facebook/react/flat/FlatUIViewOperationQueue;->access$200()[I

    move-result-object v14

    const/4 v15, 0x1

    aget v14, v14, v15

    int-to-float v14, v14

    add-float/2addr v13, v14

    sub-float/2addr v13, v2

    invoke-static {v13}, Lcom/facebook/react/uimanager/PixelUtil;->toDIPFromPixel(F)F

    move-result v12

    .line 364
    .local v12, "y":F
    if-eqz v5, :cond_3

    .line 365
    invoke-static {}, Lcom/facebook/react/flat/FlatUIViewOperationQueue;->access$200()[I

    move-result-object v13

    const/4 v14, 0x2

    aget v13, v13, v14

    int-to-float v13, v13

    .line 364
    :goto_2
    invoke-static {v13}, Lcom/facebook/react/uimanager/PixelUtil;->toDIPFromPixel(F)F

    move-result v10

    .line 366
    .local v10, "width":F
    if-eqz v5, :cond_4

    .line 367
    invoke-static {}, Lcom/facebook/react/flat/FlatUIViewOperationQueue;->access$200()[I

    move-result-object v13

    const/4 v14, 0x3

    aget v13, v13, v14

    int-to-float v13, v13

    .line 366
    :goto_3
    invoke-static {v13}, Lcom/facebook/react/uimanager/PixelUtil;->toDIPFromPixel(F)F

    move-result v4

    .line 368
    .local v4, "height":F
    move-object/from16 v0, p0

    iget-object v13, v0, Lcom/facebook/react/flat/FlatUIViewOperationQueue$FindTargetForTouchOperation;->mCallback:Lcom/facebook/react/bridge/Callback;

    const/4 v14, 0x5

    new-array v14, v14, [Ljava/lang/Object;

    const/4 v15, 0x0

    invoke-static {v7}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v16

    aput-object v16, v14, v15

    const/4 v15, 0x1

    invoke-static {v11}, Ljava/lang/Float;->valueOf(F)Ljava/lang/Float;

    move-result-object v16

    aput-object v16, v14, v15

    const/4 v15, 0x2

    invoke-static {v12}, Ljava/lang/Float;->valueOf(F)Ljava/lang/Float;

    move-result-object v16

    aput-object v16, v14, v15

    const/4 v15, 0x3

    invoke-static {v10}, Ljava/lang/Float;->valueOf(F)Ljava/lang/Float;

    move-result-object v16

    aput-object v16, v14, v15

    const/4 v15, 0x4

    invoke-static {v4}, Ljava/lang/Float;->valueOf(F)Ljava/lang/Float;

    move-result-object v16

    aput-object v16, v14, v15

    invoke-interface {v13, v14}, Lcom/facebook/react/bridge/Callback;->invoke([Ljava/lang/Object;)V

    .line 369
    .end local v1    # "containerX":F
    .end local v2    # "containerY":F
    .end local v4    # "height":F
    .end local v5    # "isNativeView":Z
    .end local v6    # "region":Lcom/facebook/react/flat/NodeRegion;
    .end local v7    # "resultTag":I
    .end local v8    # "touchTargetReactTag":I
    .end local v9    # "view":Landroid/view/View;
    .end local v10    # "width":F
    .end local v11    # "x":F
    .end local v12    # "y":F
    :goto_4
    return-void

    .line 324
    :catch_0
    move-exception v3

    .line 325
    .local v3, "e":Lcom/facebook/react/uimanager/IllegalViewOperationException;
    move-object/from16 v0, p0

    iget-object v13, v0, Lcom/facebook/react/flat/FlatUIViewOperationQueue$FindTargetForTouchOperation;->mCallback:Lcom/facebook/react/bridge/Callback;

    const/4 v14, 0x0

    new-array v14, v14, [Ljava/lang/Object;

    invoke-interface {v13, v14}, Lcom/facebook/react/bridge/Callback;->invoke([Ljava/lang/Object;)V

    goto :goto_4

    .line 345
    .end local v3    # "e":Lcom/facebook/react/uimanager/IllegalViewOperationException;
    .restart local v1    # "containerX":F
    .restart local v2    # "containerY":F
    .restart local v8    # "touchTargetReactTag":I
    .restart local v9    # "view":Landroid/view/View;
    :catch_1
    move-exception v3

    .line 346
    .restart local v3    # "e":Lcom/facebook/react/uimanager/IllegalViewOperationException;
    move-object/from16 v0, p0

    iget-object v13, v0, Lcom/facebook/react/flat/FlatUIViewOperationQueue$FindTargetForTouchOperation;->mCallback:Lcom/facebook/react/bridge/Callback;

    const/4 v14, 0x0

    new-array v14, v14, [Ljava/lang/Object;

    invoke-interface {v13, v14}, Lcom/facebook/react/bridge/Callback;->invoke([Ljava/lang/Object;)V

    goto :goto_4

    .line 351
    .end local v3    # "e":Lcom/facebook/react/uimanager/IllegalViewOperationException;
    .restart local v6    # "region":Lcom/facebook/react/flat/NodeRegion;
    :cond_1
    const/4 v5, 0x0

    goto/16 :goto_0

    .line 361
    .restart local v5    # "isNativeView":Z
    :cond_2
    iget v7, v6, Lcom/facebook/react/flat/NodeRegion;->mTag:I

    goto/16 :goto_1

    .line 365
    .restart local v7    # "resultTag":I
    .restart local v11    # "x":F
    .restart local v12    # "y":F
    :cond_3
    invoke-virtual {v6}, Lcom/facebook/react/flat/NodeRegion;->getRight()F

    move-result v13

    invoke-virtual {v6}, Lcom/facebook/react/flat/NodeRegion;->getLeft()F

    move-result v14

    sub-float/2addr v13, v14

    goto :goto_2

    .line 367
    .restart local v10    # "width":F
    :cond_4
    invoke-virtual {v6}, Lcom/facebook/react/flat/NodeRegion;->getBottom()F

    move-result v13

    invoke-virtual {v6}, Lcom/facebook/react/flat/NodeRegion;->getTop()F

    move-result v14

    sub-float/2addr v13, v14

    goto :goto_3
.end method

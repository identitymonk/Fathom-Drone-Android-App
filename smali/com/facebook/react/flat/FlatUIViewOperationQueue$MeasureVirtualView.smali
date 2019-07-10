.class final Lcom/facebook/react/flat/FlatUIViewOperationQueue$MeasureVirtualView;
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
    name = "MeasureVirtualView"
.end annotation


# instance fields
.field private final mCallback:Lcom/facebook/react/bridge/Callback;

.field private final mReactTag:I

.field private final mRelativeToWindow:Z

.field private final mScaledHeight:F

.field private final mScaledWidth:F

.field private final mScaledX:F

.field private final mScaledY:F

.field final synthetic this$0:Lcom/facebook/react/flat/FlatUIViewOperationQueue;


# direct methods
.method private constructor <init>(Lcom/facebook/react/flat/FlatUIViewOperationQueue;IFFFFZLcom/facebook/react/bridge/Callback;)V
    .locals 0
    .param p2, "reactTag"    # I
    .param p3, "scaledX"    # F
    .param p4, "scaledY"    # F
    .param p5, "scaledWidth"    # F
    .param p6, "scaledHeight"    # F
    .param p7, "relativeToWindow"    # Z
    .param p8, "callback"    # Lcom/facebook/react/bridge/Callback;

    .prologue
    .line 240
    iput-object p1, p0, Lcom/facebook/react/flat/FlatUIViewOperationQueue$MeasureVirtualView;->this$0:Lcom/facebook/react/flat/FlatUIViewOperationQueue;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 241
    iput p2, p0, Lcom/facebook/react/flat/FlatUIViewOperationQueue$MeasureVirtualView;->mReactTag:I

    .line 242
    iput p3, p0, Lcom/facebook/react/flat/FlatUIViewOperationQueue$MeasureVirtualView;->mScaledX:F

    .line 243
    iput p4, p0, Lcom/facebook/react/flat/FlatUIViewOperationQueue$MeasureVirtualView;->mScaledY:F

    .line 244
    iput p5, p0, Lcom/facebook/react/flat/FlatUIViewOperationQueue$MeasureVirtualView;->mScaledWidth:F

    .line 245
    iput p6, p0, Lcom/facebook/react/flat/FlatUIViewOperationQueue$MeasureVirtualView;->mScaledHeight:F

    .line 246
    iput-object p8, p0, Lcom/facebook/react/flat/FlatUIViewOperationQueue$MeasureVirtualView;->mCallback:Lcom/facebook/react/bridge/Callback;

    .line 247
    iput-boolean p7, p0, Lcom/facebook/react/flat/FlatUIViewOperationQueue$MeasureVirtualView;->mRelativeToWindow:Z

    .line 248
    return-void
.end method

.method synthetic constructor <init>(Lcom/facebook/react/flat/FlatUIViewOperationQueue;IFFFFZLcom/facebook/react/bridge/Callback;Lcom/facebook/react/flat/FlatUIViewOperationQueue$1;)V
    .locals 0
    .param p1, "x0"    # Lcom/facebook/react/flat/FlatUIViewOperationQueue;
    .param p2, "x1"    # I
    .param p3, "x2"    # F
    .param p4, "x3"    # F
    .param p5, "x4"    # F
    .param p6, "x5"    # F
    .param p7, "x6"    # Z
    .param p8, "x7"    # Lcom/facebook/react/bridge/Callback;
    .param p9, "x8"    # Lcom/facebook/react/flat/FlatUIViewOperationQueue$1;

    .prologue
    .line 223
    invoke-direct/range {p0 .. p8}, Lcom/facebook/react/flat/FlatUIViewOperationQueue$MeasureVirtualView;-><init>(Lcom/facebook/react/flat/FlatUIViewOperationQueue;IFFFFZLcom/facebook/react/bridge/Callback;)V

    return-void
.end method


# virtual methods
.method public execute()V
    .locals 13

    .prologue
    .line 254
    :try_start_0
    iget-boolean v9, p0, Lcom/facebook/react/flat/FlatUIViewOperationQueue$MeasureVirtualView;->mRelativeToWindow:Z

    if-eqz v9, :cond_0

    .line 256
    iget-object v9, p0, Lcom/facebook/react/flat/FlatUIViewOperationQueue$MeasureVirtualView;->this$0:Lcom/facebook/react/flat/FlatUIViewOperationQueue;

    invoke-static {v9}, Lcom/facebook/react/flat/FlatUIViewOperationQueue;->access$100(Lcom/facebook/react/flat/FlatUIViewOperationQueue;)Lcom/facebook/react/flat/FlatNativeViewHierarchyManager;

    move-result-object v9

    iget v10, p0, Lcom/facebook/react/flat/FlatUIViewOperationQueue$MeasureVirtualView;->mReactTag:I

    invoke-static {}, Lcom/facebook/react/flat/FlatUIViewOperationQueue;->access$200()[I

    move-result-object v11

    invoke-virtual {v9, v10, v11}, Lcom/facebook/react/flat/FlatNativeViewHierarchyManager;->measureInWindow(I[I)V
    :try_end_0
    .catch Lcom/facebook/react/uimanager/NoSuchNativeViewException; {:try_start_0 .. :try_end_0} :catch_0

    .line 268
    :goto_0
    invoke-static {}, Lcom/facebook/react/flat/FlatUIViewOperationQueue;->access$200()[I

    move-result-object v9

    const/4 v10, 0x0

    aget v9, v9, v10

    int-to-float v3, v9

    .line 269
    .local v3, "nativeViewX":F
    invoke-static {}, Lcom/facebook/react/flat/FlatUIViewOperationQueue;->access$200()[I

    move-result-object v9

    const/4 v10, 0x1

    aget v9, v9, v10

    int-to-float v4, v9

    .line 270
    .local v4, "nativeViewY":F
    invoke-static {}, Lcom/facebook/react/flat/FlatUIViewOperationQueue;->access$200()[I

    move-result-object v9

    const/4 v10, 0x2

    aget v9, v9, v10

    int-to-float v2, v9

    .line 271
    .local v2, "nativeViewWidth":F
    invoke-static {}, Lcom/facebook/react/flat/FlatUIViewOperationQueue;->access$200()[I

    move-result-object v9

    const/4 v10, 0x3

    aget v9, v9, v10

    int-to-float v1, v9

    .line 274
    .local v1, "nativeViewHeight":F
    iget v9, p0, Lcom/facebook/react/flat/FlatUIViewOperationQueue$MeasureVirtualView;->mScaledX:F

    mul-float/2addr v9, v2

    add-float/2addr v9, v3

    invoke-static {v9}, Lcom/facebook/react/uimanager/PixelUtil;->toDIPFromPixel(F)F

    move-result v7

    .line 275
    .local v7, "x":F
    iget v9, p0, Lcom/facebook/react/flat/FlatUIViewOperationQueue$MeasureVirtualView;->mScaledY:F

    mul-float/2addr v9, v1

    add-float/2addr v9, v4

    invoke-static {v9}, Lcom/facebook/react/uimanager/PixelUtil;->toDIPFromPixel(F)F

    move-result v8

    .line 276
    .local v8, "y":F
    iget v9, p0, Lcom/facebook/react/flat/FlatUIViewOperationQueue$MeasureVirtualView;->mScaledWidth:F

    mul-float/2addr v9, v2

    invoke-static {v9}, Lcom/facebook/react/uimanager/PixelUtil;->toDIPFromPixel(F)F

    move-result v6

    .line 277
    .local v6, "width":F
    iget v9, p0, Lcom/facebook/react/flat/FlatUIViewOperationQueue$MeasureVirtualView;->mScaledHeight:F

    mul-float/2addr v9, v1

    invoke-static {v9}, Lcom/facebook/react/uimanager/PixelUtil;->toDIPFromPixel(F)F

    move-result v0

    .line 279
    .local v0, "height":F
    iget-boolean v9, p0, Lcom/facebook/react/flat/FlatUIViewOperationQueue$MeasureVirtualView;->mRelativeToWindow:Z

    if-eqz v9, :cond_1

    .line 280
    iget-object v9, p0, Lcom/facebook/react/flat/FlatUIViewOperationQueue$MeasureVirtualView;->mCallback:Lcom/facebook/react/bridge/Callback;

    const/4 v10, 0x4

    new-array v10, v10, [Ljava/lang/Object;

    const/4 v11, 0x0

    invoke-static {v7}, Ljava/lang/Float;->valueOf(F)Ljava/lang/Float;

    move-result-object v12

    aput-object v12, v10, v11

    const/4 v11, 0x1

    invoke-static {v8}, Ljava/lang/Float;->valueOf(F)Ljava/lang/Float;

    move-result-object v12

    aput-object v12, v10, v11

    const/4 v11, 0x2

    invoke-static {v6}, Ljava/lang/Float;->valueOf(F)Ljava/lang/Float;

    move-result-object v12

    aput-object v12, v10, v11

    const/4 v11, 0x3

    invoke-static {v0}, Ljava/lang/Float;->valueOf(F)Ljava/lang/Float;

    move-result-object v12

    aput-object v12, v10, v11

    invoke-interface {v9, v10}, Lcom/facebook/react/bridge/Callback;->invoke([Ljava/lang/Object;)V

    .line 284
    .end local v0    # "height":F
    .end local v1    # "nativeViewHeight":F
    .end local v2    # "nativeViewWidth":F
    .end local v3    # "nativeViewX":F
    .end local v4    # "nativeViewY":F
    .end local v6    # "width":F
    .end local v7    # "x":F
    .end local v8    # "y":F
    :goto_1
    return-void

    .line 259
    :cond_0
    :try_start_1
    iget-object v9, p0, Lcom/facebook/react/flat/FlatUIViewOperationQueue$MeasureVirtualView;->this$0:Lcom/facebook/react/flat/FlatUIViewOperationQueue;

    invoke-static {v9}, Lcom/facebook/react/flat/FlatUIViewOperationQueue;->access$100(Lcom/facebook/react/flat/FlatUIViewOperationQueue;)Lcom/facebook/react/flat/FlatNativeViewHierarchyManager;

    move-result-object v9

    iget v10, p0, Lcom/facebook/react/flat/FlatUIViewOperationQueue$MeasureVirtualView;->mReactTag:I

    invoke-static {}, Lcom/facebook/react/flat/FlatUIViewOperationQueue;->access$200()[I

    move-result-object v11

    invoke-virtual {v9, v10, v11}, Lcom/facebook/react/flat/FlatNativeViewHierarchyManager;->measure(I[I)V
    :try_end_1
    .catch Lcom/facebook/react/uimanager/NoSuchNativeViewException; {:try_start_1 .. :try_end_1} :catch_0

    goto :goto_0

    .line 261
    :catch_0
    move-exception v5

    .line 264
    .local v5, "noSuchNativeViewException":Lcom/facebook/react/uimanager/NoSuchNativeViewException;
    iget-object v9, p0, Lcom/facebook/react/flat/FlatUIViewOperationQueue$MeasureVirtualView;->mCallback:Lcom/facebook/react/bridge/Callback;

    const/4 v10, 0x0

    new-array v10, v10, [Ljava/lang/Object;

    invoke-interface {v9, v10}, Lcom/facebook/react/bridge/Callback;->invoke([Ljava/lang/Object;)V

    goto :goto_1

    .line 282
    .end local v5    # "noSuchNativeViewException":Lcom/facebook/react/uimanager/NoSuchNativeViewException;
    .restart local v0    # "height":F
    .restart local v1    # "nativeViewHeight":F
    .restart local v2    # "nativeViewWidth":F
    .restart local v3    # "nativeViewX":F
    .restart local v4    # "nativeViewY":F
    .restart local v6    # "width":F
    .restart local v7    # "x":F
    .restart local v8    # "y":F
    :cond_1
    iget-object v9, p0, Lcom/facebook/react/flat/FlatUIViewOperationQueue$MeasureVirtualView;->mCallback:Lcom/facebook/react/bridge/Callback;

    const/4 v10, 0x6

    new-array v10, v10, [Ljava/lang/Object;

    const/4 v11, 0x0

    const/4 v12, 0x0

    invoke-static {v12}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v12

    aput-object v12, v10, v11

    const/4 v11, 0x1

    const/4 v12, 0x0

    invoke-static {v12}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v12

    aput-object v12, v10, v11

    const/4 v11, 0x2

    invoke-static {v6}, Ljava/lang/Float;->valueOf(F)Ljava/lang/Float;

    move-result-object v12

    aput-object v12, v10, v11

    const/4 v11, 0x3

    invoke-static {v0}, Ljava/lang/Float;->valueOf(F)Ljava/lang/Float;

    move-result-object v12

    aput-object v12, v10, v11

    const/4 v11, 0x4

    invoke-static {v7}, Ljava/lang/Float;->valueOf(F)Ljava/lang/Float;

    move-result-object v12

    aput-object v12, v10, v11

    const/4 v11, 0x5

    invoke-static {v8}, Ljava/lang/Float;->valueOf(F)Ljava/lang/Float;

    move-result-object v12

    aput-object v12, v10, v11

    invoke-interface {v9, v10}, Lcom/facebook/react/bridge/Callback;->invoke([Ljava/lang/Object;)V

    goto :goto_1
.end method

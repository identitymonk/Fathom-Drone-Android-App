.class final Lcom/facebook/react/flat/FlatViewGroup;
.super Landroid/view/ViewGroup;
.source "FlatViewGroup.java"

# interfaces
.implements Lcom/facebook/react/touch/ReactInterceptingViewGroup;
.implements Lcom/facebook/react/uimanager/ReactClippingViewGroup;
.implements Lcom/facebook/react/uimanager/ReactCompoundViewGroup;
.implements Lcom/facebook/react/touch/ReactHitSlopView;
.implements Lcom/facebook/react/uimanager/ReactPointerEventsView;
.implements Lcom/facebook/react/flat/FlatMeasuredViewGroup;


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lcom/facebook/react/flat/FlatViewGroup$InvalidateCallback;
    }
.end annotation


# static fields
.field private static final DEBUG_DRAW:Z

.field private static final DEBUG_DRAW_TEXT:Z

.field static final DEBUG_HIGHLIGHT_PERFORMANCE_ISSUES:Z

.field private static final EMPTY_DETACHED_VIEWS:Landroid/util/SparseArray;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Landroid/util/SparseArray",
            "<",
            "Landroid/view/View;",
            ">;"
        }
    .end annotation
.end field

.field private static final LAYOUT_REQUESTS:Ljava/util/ArrayList;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/ArrayList",
            "<",
            "Lcom/facebook/react/flat/FlatViewGroup;",
            ">;"
        }
    .end annotation
.end field

.field private static final VIEW_BOUNDS:Landroid/graphics/Rect;

.field private static sDebugCornerPaint:Landroid/graphics/Paint;

.field private static sDebugRect:Landroid/graphics/Rect;

.field private static sDebugRectPaint:Landroid/graphics/Paint;

.field private static sDebugTextBackgroundPaint:Landroid/graphics/Paint;

.field private static sDebugTextPaint:Landroid/graphics/Paint;


# instance fields
.field private mAndroidDebugDraw:Z

.field private mAttachDetachListeners:[Lcom/facebook/react/flat/AttachDetachListener;

.field private mDrawChildIndex:I

.field private mDrawCommandManager:Lcom/facebook/react/flat/DrawCommandManager;
    .annotation runtime Ljavax/annotation/Nullable;
    .end annotation
.end field

.field private mDrawCommands:[Lcom/facebook/react/flat/DrawCommand;

.field private mHitSlopRect:Landroid/graphics/Rect;
    .annotation runtime Ljavax/annotation/Nullable;
    .end annotation
.end field

.field private mHotspot:Landroid/graphics/drawable/Drawable;

.field private mInvalidateCallback:Lcom/facebook/react/flat/FlatViewGroup$InvalidateCallback;
    .annotation runtime Ljavax/annotation/Nullable;
    .end annotation
.end field

.field private mIsAttached:Z

.field private mIsLayoutRequested:Z

.field private mLastTouchDownTime:J

.field private mNeedsOffscreenAlphaCompositing:Z

.field private mNodeRegions:[Lcom/facebook/react/flat/NodeRegion;

.field private mOnInterceptTouchEventListener:Lcom/facebook/react/touch/OnInterceptTouchEventListener;
    .annotation runtime Ljavax/annotation/Nullable;
    .end annotation
.end field

.field private mPointerEvents:Lcom/facebook/react/uimanager/PointerEvents;


# direct methods
.method static constructor <clinit>()V
    .locals 2

    .prologue
    .line 154
    new-instance v0, Ljava/util/ArrayList;

    invoke-direct {v0}, Ljava/util/ArrayList;-><init>()V

    sput-object v0, Lcom/facebook/react/flat/FlatViewGroup;->LAYOUT_REQUESTS:Ljava/util/ArrayList;

    .line 155
    new-instance v0, Landroid/graphics/Rect;

    invoke-direct {v0}, Landroid/graphics/Rect;-><init>()V

    sput-object v0, Lcom/facebook/react/flat/FlatViewGroup;->VIEW_BOUNDS:Landroid/graphics/Rect;

    .line 174
    new-instance v0, Landroid/util/SparseArray;

    const/4 v1, 0x0

    invoke-direct {v0, v1}, Landroid/util/SparseArray;-><init>(I)V

    sput-object v0, Lcom/facebook/react/flat/FlatViewGroup;->EMPTY_DETACHED_VIEWS:Landroid/util/SparseArray;

    return-void
.end method

.method constructor <init>(Landroid/content/Context;)V
    .locals 2
    .param p1, "context"    # Landroid/content/Context;

    .prologue
    const/4 v1, 0x0

    .line 181
    invoke-direct {p0, p1}, Landroid/view/ViewGroup;-><init>(Landroid/content/Context;)V

    .line 159
    sget-object v0, Lcom/facebook/react/flat/DrawCommand;->EMPTY_ARRAY:[Lcom/facebook/react/flat/DrawCommand;

    iput-object v0, p0, Lcom/facebook/react/flat/FlatViewGroup;->mDrawCommands:[Lcom/facebook/react/flat/DrawCommand;

    .line 160
    sget-object v0, Lcom/facebook/react/flat/AttachDetachListener;->EMPTY_ARRAY:[Lcom/facebook/react/flat/AttachDetachListener;

    iput-object v0, p0, Lcom/facebook/react/flat/FlatViewGroup;->mAttachDetachListeners:[Lcom/facebook/react/flat/AttachDetachListener;

    .line 161
    sget-object v0, Lcom/facebook/react/flat/NodeRegion;->EMPTY_ARRAY:[Lcom/facebook/react/flat/NodeRegion;

    iput-object v0, p0, Lcom/facebook/react/flat/FlatViewGroup;->mNodeRegions:[Lcom/facebook/react/flat/NodeRegion;

    .line 165
    iput v1, p0, Lcom/facebook/react/flat/FlatViewGroup;->mDrawChildIndex:I

    .line 166
    iput-boolean v1, p0, Lcom/facebook/react/flat/FlatViewGroup;->mIsAttached:Z

    .line 167
    iput-boolean v1, p0, Lcom/facebook/react/flat/FlatViewGroup;->mIsLayoutRequested:Z

    .line 168
    iput-boolean v1, p0, Lcom/facebook/react/flat/FlatViewGroup;->mNeedsOffscreenAlphaCompositing:Z

    .line 170
    sget-object v0, Lcom/facebook/react/uimanager/PointerEvents;->AUTO:Lcom/facebook/react/uimanager/PointerEvents;

    iput-object v0, p0, Lcom/facebook/react/flat/FlatViewGroup;->mPointerEvents:Lcom/facebook/react/uimanager/PointerEvents;

    .line 182
    invoke-virtual {p0, v1}, Lcom/facebook/react/flat/FlatViewGroup;->setClipChildren(Z)V

    .line 183
    return-void
.end method

.method private anyNodeRegionWithinBounds(FF)Lcom/facebook/react/flat/NodeRegion;
    .locals 3
    .param p1, "touchX"    # F
    .param p2, "touchY"    # F
    .annotation runtime Ljavax/annotation/Nullable;
    .end annotation

    .prologue
    .line 1078
    iget-object v2, p0, Lcom/facebook/react/flat/FlatViewGroup;->mDrawCommandManager:Lcom/facebook/react/flat/DrawCommandManager;

    if-eqz v2, :cond_1

    .line 1079
    iget-object v2, p0, Lcom/facebook/react/flat/FlatViewGroup;->mDrawCommandManager:Lcom/facebook/react/flat/DrawCommandManager;

    invoke-virtual {v2, p1, p2}, Lcom/facebook/react/flat/DrawCommandManager;->anyNodeRegionWithinBounds(FF)Lcom/facebook/react/flat/NodeRegion;

    move-result-object v1

    .line 1088
    :cond_0
    :goto_0
    return-object v1

    .line 1081
    :cond_1
    iget-object v2, p0, Lcom/facebook/react/flat/FlatViewGroup;->mNodeRegions:[Lcom/facebook/react/flat/NodeRegion;

    array-length v2, v2

    add-int/lit8 v0, v2, -0x1

    .local v0, "i":I
    :goto_1
    if-ltz v0, :cond_2

    .line 1082
    iget-object v2, p0, Lcom/facebook/react/flat/FlatViewGroup;->mNodeRegions:[Lcom/facebook/react/flat/NodeRegion;

    aget-object v1, v2, v0

    .line 1083
    .local v1, "nodeRegion":Lcom/facebook/react/flat/NodeRegion;
    invoke-virtual {v1, p1, p2}, Lcom/facebook/react/flat/NodeRegion;->withinBounds(FF)Z

    move-result v2

    if-nez v2, :cond_0

    .line 1081
    add-int/lit8 v0, v0, -0x1

    goto :goto_1

    .line 1088
    .end local v1    # "nodeRegion":Lcom/facebook/react/flat/NodeRegion;
    :cond_2
    const/4 v1, 0x0

    goto :goto_0
.end method

.method private debugDraw(Landroid/graphics/Canvas;)V
    .locals 5
    .param p1, "canvas"    # Landroid/graphics/Canvas;

    .prologue
    const/4 v2, 0x0

    .line 285
    iget-object v1, p0, Lcom/facebook/react/flat/FlatViewGroup;->mDrawCommandManager:Lcom/facebook/react/flat/DrawCommandManager;

    if-eqz v1, :cond_1

    .line 286
    iget-object v1, p0, Lcom/facebook/react/flat/FlatViewGroup;->mDrawCommandManager:Lcom/facebook/react/flat/DrawCommandManager;

    invoke-virtual {v1, p1}, Lcom/facebook/react/flat/DrawCommandManager;->debugDraw(Landroid/graphics/Canvas;)V

    .line 292
    :cond_0
    iput v2, p0, Lcom/facebook/react/flat/FlatViewGroup;->mDrawChildIndex:I

    .line 293
    return-void

    .line 288
    :cond_1
    iget-object v3, p0, Lcom/facebook/react/flat/FlatViewGroup;->mDrawCommands:[Lcom/facebook/react/flat/DrawCommand;

    array-length v4, v3

    move v1, v2

    :goto_0
    if-ge v1, v4, :cond_0

    aget-object v0, v3, v1

    .line 289
    .local v0, "drawCommand":Lcom/facebook/react/flat/DrawCommand;
    invoke-virtual {v0, p0, p1}, Lcom/facebook/react/flat/DrawCommand;->debugDraw(Lcom/facebook/react/flat/FlatViewGroup;Landroid/graphics/Canvas;)V

    .line 288
    add-int/lit8 v1, v1, 0x1

    goto :goto_0
.end method

.method private debugDrawRect(Landroid/graphics/Canvas;IFFFF)V
    .locals 8
    .param p1, "canvas"    # Landroid/graphics/Canvas;
    .param p2, "color"    # I
    .param p3, "left"    # F
    .param p4, "top"    # F
    .param p5, "right"    # F
    .param p6, "bottom"    # F

    .prologue
    .line 459
    const-string v3, ""

    move-object v0, p0

    move-object v1, p1

    move v2, p2

    move v4, p3

    move v5, p4

    move v6, p5

    move v7, p6

    invoke-virtual/range {v0 .. v7}, Lcom/facebook/react/flat/FlatViewGroup;->debugDrawNamedRect(Landroid/graphics/Canvas;ILjava/lang/String;FFFF)V

    .line 460
    return-void
.end method

.method private dispatchOnAttached([Lcom/facebook/react/flat/AttachDetachListener;)V
    .locals 5
    .param p1, "listeners"    # [Lcom/facebook/react/flat/AttachDetachListener;

    .prologue
    .line 1105
    array-length v2, p1

    .line 1106
    .local v2, "numListeners":I
    if-nez v2, :cond_1

    .line 1114
    :cond_0
    return-void

    .line 1110
    :cond_1
    invoke-direct {p0}, Lcom/facebook/react/flat/FlatViewGroup;->getInvalidateCallback()Lcom/facebook/react/flat/FlatViewGroup$InvalidateCallback;

    move-result-object v0

    .line 1111
    .local v0, "callback":Lcom/facebook/react/flat/FlatViewGroup$InvalidateCallback;
    array-length v4, p1

    const/4 v3, 0x0

    :goto_0
    if-ge v3, v4, :cond_0

    aget-object v1, p1, v3

    .line 1112
    .local v1, "listener":Lcom/facebook/react/flat/AttachDetachListener;
    invoke-interface {v1, v0}, Lcom/facebook/react/flat/AttachDetachListener;->onAttached(Lcom/facebook/react/flat/FlatViewGroup$InvalidateCallback;)V

    .line 1111
    add-int/lit8 v3, v3, 0x1

    goto :goto_0
.end method

.method private static dispatchOnDetached([Lcom/facebook/react/flat/AttachDetachListener;)V
    .locals 3
    .param p0, "listeners"    # [Lcom/facebook/react/flat/AttachDetachListener;

    .prologue
    .line 1134
    array-length v2, p0

    const/4 v1, 0x0

    :goto_0
    if-ge v1, v2, :cond_0

    aget-object v0, p0, v1

    .line 1135
    .local v0, "listener":Lcom/facebook/react/flat/AttachDetachListener;
    invoke-interface {v0}, Lcom/facebook/react/flat/AttachDetachListener;->onDetached()V

    .line 1134
    add-int/lit8 v1, v1, 0x1

    goto :goto_0

    .line 1137
    .end local v0    # "listener":Lcom/facebook/react/flat/AttachDetachListener;
    :cond_0
    return-void
.end method

.method private static drawCorner(Landroid/graphics/Canvas;Landroid/graphics/Paint;FFFFF)V
    .locals 6
    .param p0, "c"    # Landroid/graphics/Canvas;
    .param p1, "paint"    # Landroid/graphics/Paint;
    .param p2, "x1"    # F
    .param p3, "y1"    # F
    .param p4, "dx"    # F
    .param p5, "dy"    # F
    .param p6, "lw"    # F

    .prologue
    .line 386
    add-float v4, p2, p4

    invoke-static {p5}, Lcom/facebook/react/flat/FlatViewGroup;->sign(F)I

    move-result v0

    int-to-float v0, v0

    mul-float/2addr v0, p6

    add-float v5, p3, v0

    move-object v0, p0

    move-object v1, p1

    move v2, p2

    move v3, p3

    invoke-static/range {v0 .. v5}, Lcom/facebook/react/flat/FlatViewGroup;->fillRect(Landroid/graphics/Canvas;Landroid/graphics/Paint;FFFF)V

    .line 387
    invoke-static {p4}, Lcom/facebook/react/flat/FlatViewGroup;->sign(F)I

    move-result v0

    int-to-float v0, v0

    mul-float/2addr v0, p6

    add-float v4, p2, v0

    add-float v5, p3, p5

    move-object v0, p0

    move-object v1, p1

    move v2, p2

    move v3, p3

    invoke-static/range {v0 .. v5}, Lcom/facebook/react/flat/FlatViewGroup;->fillRect(Landroid/graphics/Canvas;Landroid/graphics/Paint;FFFF)V

    .line 388
    return-void
.end method

.method private static drawRectCorners(Landroid/graphics/Canvas;FFFFLandroid/graphics/Paint;II)V
    .locals 7
    .param p0, "canvas"    # Landroid/graphics/Canvas;
    .param p1, "x1"    # F
    .param p2, "y1"    # F
    .param p3, "x2"    # F
    .param p4, "y2"    # F
    .param p5, "paint"    # Landroid/graphics/Paint;
    .param p6, "lineLength"    # I
    .param p7, "lineWidth"    # I

    .prologue
    .line 400
    int-to-float v4, p6

    int-to-float v5, p6

    int-to-float v6, p7

    move-object v0, p0

    move-object v1, p5

    move v2, p1

    move v3, p2

    invoke-static/range {v0 .. v6}, Lcom/facebook/react/flat/FlatViewGroup;->drawCorner(Landroid/graphics/Canvas;Landroid/graphics/Paint;FFFFF)V

    .line 401
    int-to-float v4, p6

    neg-int v0, p6

    int-to-float v5, v0

    int-to-float v6, p7

    move-object v0, p0

    move-object v1, p5

    move v2, p1

    move v3, p4

    invoke-static/range {v0 .. v6}, Lcom/facebook/react/flat/FlatViewGroup;->drawCorner(Landroid/graphics/Canvas;Landroid/graphics/Paint;FFFFF)V

    .line 402
    neg-int v0, p6

    int-to-float v4, v0

    int-to-float v5, p6

    int-to-float v6, p7

    move-object v0, p0

    move-object v1, p5

    move v2, p3

    move v3, p2

    invoke-static/range {v0 .. v6}, Lcom/facebook/react/flat/FlatViewGroup;->drawCorner(Landroid/graphics/Canvas;Landroid/graphics/Paint;FFFFF)V

    .line 403
    neg-int v0, p6

    int-to-float v4, v0

    neg-int v0, p6

    int-to-float v5, v0

    int-to-float v6, p7

    move-object v0, p0

    move-object v1, p5

    move v2, p3

    move v3, p4

    invoke-static/range {v0 .. v6}, Lcom/facebook/react/flat/FlatViewGroup;->drawCorner(Landroid/graphics/Canvas;Landroid/graphics/Paint;FFFFF)V

    .line 404
    return-void
.end method

.method private ensureLayoutParams(Landroid/view/ViewGroup$LayoutParams;)Landroid/view/ViewGroup$LayoutParams;
    .locals 1
    .param p1, "lp"    # Landroid/view/ViewGroup$LayoutParams;

    .prologue
    .line 1140
    invoke-virtual {p0, p1}, Lcom/facebook/react/flat/FlatViewGroup;->checkLayoutParams(Landroid/view/ViewGroup$LayoutParams;)Z

    move-result v0

    if-eqz v0, :cond_0

    .line 1143
    .end local p1    # "lp":Landroid/view/ViewGroup$LayoutParams;
    :goto_0
    return-object p1

    .restart local p1    # "lp":Landroid/view/ViewGroup$LayoutParams;
    :cond_0
    invoke-virtual {p0}, Lcom/facebook/react/flat/FlatViewGroup;->generateDefaultLayoutParams()Landroid/view/ViewGroup$LayoutParams;

    move-result-object p1

    goto :goto_0
.end method

.method private static ensureViewHasNoParent(Landroid/view/View;)V
    .locals 4
    .param p0, "view"    # Landroid/view/View;

    .prologue
    .line 1092
    invoke-virtual {p0}, Landroid/view/View;->getParent()Landroid/view/ViewParent;

    move-result-object v0

    .line 1093
    .local v0, "oldParent":Landroid/view/ViewParent;
    if-eqz v0, :cond_0

    .line 1094
    new-instance v1, Ljava/lang/RuntimeException;

    new-instance v2, Ljava/lang/StringBuilder;

    invoke-direct {v2}, Ljava/lang/StringBuilder;-><init>()V

    const-string v3, "Cannot add view "

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2, p0}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    move-result-object v2

    const-string v3, " to FlatViewGroup while it has a parent "

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2, v0}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v2

    invoke-direct {v1, v2}, Ljava/lang/RuntimeException;-><init>(Ljava/lang/String;)V

    throw v1

    .line 1097
    :cond_0
    return-void
.end method

.method private static fillRect(Landroid/graphics/Canvas;Landroid/graphics/Paint;FFFF)V
    .locals 7
    .param p0, "canvas"    # Landroid/graphics/Canvas;
    .param p1, "paint"    # Landroid/graphics/Paint;
    .param p2, "x1"    # F
    .param p3, "y1"    # F
    .param p4, "x2"    # F
    .param p5, "y2"    # F

    .prologue
    .line 361
    cmpl-float v0, p2, p4

    if-eqz v0, :cond_2

    cmpl-float v0, p3, p5

    if-eqz v0, :cond_2

    .line 362
    cmpl-float v0, p2, p4

    if-lez v0, :cond_0

    .line 363
    move v6, p2

    .local v6, "tmp":F
    move p2, p4

    move p4, v6

    .line 365
    .end local v6    # "tmp":F
    :cond_0
    cmpl-float v0, p3, p5

    if-lez v0, :cond_1

    .line 366
    move v6, p3

    .restart local v6    # "tmp":F
    move p3, p5

    move p5, v6

    .end local v6    # "tmp":F
    :cond_1
    move-object v0, p0

    move v1, p2

    move v2, p3

    move v3, p4

    move v4, p5

    move-object v5, p1

    .line 368
    invoke-virtual/range {v0 .. v5}, Landroid/graphics/Canvas;->drawRect(FFFFLandroid/graphics/Paint;)V

    .line 370
    :cond_2
    return-void
.end method

.method private getInvalidateCallback()Lcom/facebook/react/flat/FlatViewGroup$InvalidateCallback;
    .locals 2

    .prologue
    .line 1122
    iget-object v0, p0, Lcom/facebook/react/flat/FlatViewGroup;->mInvalidateCallback:Lcom/facebook/react/flat/FlatViewGroup$InvalidateCallback;

    if-nez v0, :cond_0

    .line 1123
    new-instance v0, Lcom/facebook/react/flat/FlatViewGroup$InvalidateCallback;

    const/4 v1, 0x0

    invoke-direct {v0, p0, v1}, Lcom/facebook/react/flat/FlatViewGroup$InvalidateCallback;-><init>(Lcom/facebook/react/flat/FlatViewGroup;Lcom/facebook/react/flat/FlatViewGroup$1;)V

    iput-object v0, p0, Lcom/facebook/react/flat/FlatViewGroup;->mInvalidateCallback:Lcom/facebook/react/flat/FlatViewGroup$InvalidateCallback;

    .line 1125
    :cond_0
    iget-object v0, p0, Lcom/facebook/react/flat/FlatViewGroup;->mInvalidateCallback:Lcom/facebook/react/flat/FlatViewGroup$InvalidateCallback;

    return-object v0
.end method

.method private initDebugDrawResources()V
    .locals 4

    .prologue
    const/16 v2, 0xc8

    .line 411
    sget-object v0, Lcom/facebook/react/flat/FlatViewGroup;->sDebugTextPaint:Landroid/graphics/Paint;

    if-nez v0, :cond_0

    .line 412
    new-instance v0, Landroid/graphics/Paint;

    invoke-direct {v0}, Landroid/graphics/Paint;-><init>()V

    sput-object v0, Lcom/facebook/react/flat/FlatViewGroup;->sDebugTextPaint:Landroid/graphics/Paint;

    .line 413
    sget-object v0, Lcom/facebook/react/flat/FlatViewGroup;->sDebugTextPaint:Landroid/graphics/Paint;

    sget-object v1, Landroid/graphics/Paint$Align;->RIGHT:Landroid/graphics/Paint$Align;

    invoke-virtual {v0, v1}, Landroid/graphics/Paint;->setTextAlign(Landroid/graphics/Paint$Align;)V

    .line 414
    sget-object v0, Lcom/facebook/react/flat/FlatViewGroup;->sDebugTextPaint:Landroid/graphics/Paint;

    const/16 v1, 0x9

    invoke-virtual {p0, v1}, Lcom/facebook/react/flat/FlatViewGroup;->dipsToPixels(I)I

    move-result v1

    int-to-float v1, v1

    invoke-virtual {v0, v1}, Landroid/graphics/Paint;->setTextSize(F)V

    .line 415
    sget-object v0, Lcom/facebook/react/flat/FlatViewGroup;->sDebugTextPaint:Landroid/graphics/Paint;

    sget-object v1, Landroid/graphics/Typeface;->MONOSPACE:Landroid/graphics/Typeface;

    invoke-virtual {v0, v1}, Landroid/graphics/Paint;->setTypeface(Landroid/graphics/Typeface;)Landroid/graphics/Typeface;

    .line 416
    sget-object v0, Lcom/facebook/react/flat/FlatViewGroup;->sDebugTextPaint:Landroid/graphics/Paint;

    const/4 v1, 0x1

    invoke-virtual {v0, v1}, Landroid/graphics/Paint;->setAntiAlias(Z)V

    .line 417
    sget-object v0, Lcom/facebook/react/flat/FlatViewGroup;->sDebugTextPaint:Landroid/graphics/Paint;

    const/high16 v1, -0x10000

    invoke-virtual {v0, v1}, Landroid/graphics/Paint;->setColor(I)V

    .line 419
    :cond_0
    sget-object v0, Lcom/facebook/react/flat/FlatViewGroup;->sDebugTextBackgroundPaint:Landroid/graphics/Paint;

    if-nez v0, :cond_1

    .line 420
    new-instance v0, Landroid/graphics/Paint;

    invoke-direct {v0}, Landroid/graphics/Paint;-><init>()V

    sput-object v0, Lcom/facebook/react/flat/FlatViewGroup;->sDebugTextBackgroundPaint:Landroid/graphics/Paint;

    .line 421
    sget-object v0, Lcom/facebook/react/flat/FlatViewGroup;->sDebugTextBackgroundPaint:Landroid/graphics/Paint;

    const/4 v1, -0x1

    invoke-virtual {v0, v1}, Landroid/graphics/Paint;->setColor(I)V

    .line 422
    sget-object v0, Lcom/facebook/react/flat/FlatViewGroup;->sDebugTextBackgroundPaint:Landroid/graphics/Paint;

    invoke-virtual {v0, v2}, Landroid/graphics/Paint;->setAlpha(I)V

    .line 423
    sget-object v0, Lcom/facebook/react/flat/FlatViewGroup;->sDebugTextBackgroundPaint:Landroid/graphics/Paint;

    sget-object v1, Landroid/graphics/Paint$Style;->FILL:Landroid/graphics/Paint$Style;

    invoke-virtual {v0, v1}, Landroid/graphics/Paint;->setStyle(Landroid/graphics/Paint$Style;)V

    .line 425
    :cond_1
    sget-object v0, Lcom/facebook/react/flat/FlatViewGroup;->sDebugRectPaint:Landroid/graphics/Paint;

    if-nez v0, :cond_2

    .line 426
    new-instance v0, Landroid/graphics/Paint;

    invoke-direct {v0}, Landroid/graphics/Paint;-><init>()V

    sput-object v0, Lcom/facebook/react/flat/FlatViewGroup;->sDebugRectPaint:Landroid/graphics/Paint;

    .line 427
    sget-object v0, Lcom/facebook/react/flat/FlatViewGroup;->sDebugRectPaint:Landroid/graphics/Paint;

    const/16 v1, 0x64

    invoke-virtual {v0, v1}, Landroid/graphics/Paint;->setAlpha(I)V

    .line 428
    sget-object v0, Lcom/facebook/react/flat/FlatViewGroup;->sDebugRectPaint:Landroid/graphics/Paint;

    sget-object v1, Landroid/graphics/Paint$Style;->STROKE:Landroid/graphics/Paint$Style;

    invoke-virtual {v0, v1}, Landroid/graphics/Paint;->setStyle(Landroid/graphics/Paint$Style;)V

    .line 430
    :cond_2
    sget-object v0, Lcom/facebook/react/flat/FlatViewGroup;->sDebugCornerPaint:Landroid/graphics/Paint;

    if-nez v0, :cond_3

    .line 431
    new-instance v0, Landroid/graphics/Paint;

    invoke-direct {v0}, Landroid/graphics/Paint;-><init>()V

    sput-object v0, Lcom/facebook/react/flat/FlatViewGroup;->sDebugCornerPaint:Landroid/graphics/Paint;

    .line 432
    sget-object v0, Lcom/facebook/react/flat/FlatViewGroup;->sDebugCornerPaint:Landroid/graphics/Paint;

    invoke-virtual {v0, v2}, Landroid/graphics/Paint;->setAlpha(I)V

    .line 433
    sget-object v0, Lcom/facebook/react/flat/FlatViewGroup;->sDebugCornerPaint:Landroid/graphics/Paint;

    const/16 v1, 0x3f

    const/16 v2, 0x7f

    const/16 v3, 0xff

    invoke-static {v1, v2, v3}, Landroid/graphics/Color;->rgb(III)I

    move-result v1

    invoke-virtual {v0, v1}, Landroid/graphics/Paint;->setColor(I)V

    .line 434
    sget-object v0, Lcom/facebook/react/flat/FlatViewGroup;->sDebugCornerPaint:Landroid/graphics/Paint;

    sget-object v1, Landroid/graphics/Paint$Style;->FILL:Landroid/graphics/Paint$Style;

    invoke-virtual {v0, v1}, Landroid/graphics/Paint;->setStyle(Landroid/graphics/Paint$Style;)V

    .line 436
    :cond_3
    sget-object v0, Lcom/facebook/react/flat/FlatViewGroup;->sDebugRect:Landroid/graphics/Rect;

    if-nez v0, :cond_4

    .line 437
    new-instance v0, Landroid/graphics/Rect;

    invoke-direct {v0}, Landroid/graphics/Rect;-><init>()V

    sput-object v0, Lcom/facebook/react/flat/FlatViewGroup;->sDebugRect:Landroid/graphics/Rect;

    .line 439
    :cond_4
    return-void
.end method

.method private processLayoutRequest()V
    .locals 8

    .prologue
    const/high16 v7, 0x40000000    # 2.0f

    .line 983
    const/4 v3, 0x0

    iput-boolean v3, p0, Lcom/facebook/react/flat/FlatViewGroup;->mIsLayoutRequested:Z

    .line 984
    const/4 v2, 0x0

    .local v2, "i":I
    invoke-virtual {p0}, Lcom/facebook/react/flat/FlatViewGroup;->getChildCount()I

    move-result v1

    .local v1, "childCount":I
    :goto_0
    if-eq v2, v1, :cond_1

    .line 985
    invoke-virtual {p0, v2}, Lcom/facebook/react/flat/FlatViewGroup;->getChildAt(I)Landroid/view/View;

    move-result-object v0

    .line 986
    .local v0, "child":Landroid/view/View;
    invoke-virtual {v0}, Landroid/view/View;->isLayoutRequested()Z

    move-result v3

    if-nez v3, :cond_0

    .line 984
    :goto_1
    add-int/lit8 v2, v2, 0x1

    goto :goto_0

    .line 991
    :cond_0
    invoke-virtual {v0}, Landroid/view/View;->getWidth()I

    move-result v3

    invoke-static {v3, v7}, Landroid/view/View$MeasureSpec;->makeMeasureSpec(II)I

    move-result v3

    .line 992
    invoke-virtual {v0}, Landroid/view/View;->getHeight()I

    move-result v4

    invoke-static {v4, v7}, Landroid/view/View$MeasureSpec;->makeMeasureSpec(II)I

    move-result v4

    .line 990
    invoke-virtual {v0, v3, v4}, Landroid/view/View;->measure(II)V

    .line 993
    invoke-virtual {v0}, Landroid/view/View;->getLeft()I

    move-result v3

    invoke-virtual {v0}, Landroid/view/View;->getTop()I

    move-result v4

    invoke-virtual {v0}, Landroid/view/View;->getRight()I

    move-result v5

    invoke-virtual {v0}, Landroid/view/View;->getBottom()I

    move-result v6

    invoke-virtual {v0, v3, v4, v5, v6}, Landroid/view/View;->layout(IIII)V

    goto :goto_1

    .line 995
    .end local v0    # "child":Landroid/view/View;
    :cond_1
    return-void
.end method

.method static processLayoutRequests()V
    .locals 4

    .prologue
    .line 1002
    const/4 v1, 0x0

    .local v1, "i":I
    sget-object v3, Lcom/facebook/react/flat/FlatViewGroup;->LAYOUT_REQUESTS:Ljava/util/ArrayList;

    invoke-virtual {v3}, Ljava/util/ArrayList;->size()I

    move-result v2

    .local v2, "numLayoutRequests":I
    :goto_0
    if-eq v1, v2, :cond_0

    .line 1003
    sget-object v3, Lcom/facebook/react/flat/FlatViewGroup;->LAYOUT_REQUESTS:Ljava/util/ArrayList;

    invoke-virtual {v3, v1}, Ljava/util/ArrayList;->get(I)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/facebook/react/flat/FlatViewGroup;

    .line 1004
    .local v0, "flatViewGroup":Lcom/facebook/react/flat/FlatViewGroup;
    invoke-direct {v0}, Lcom/facebook/react/flat/FlatViewGroup;->processLayoutRequest()V

    .line 1002
    add-int/lit8 v1, v1, 0x1

    goto :goto_0

    .line 1006
    .end local v0    # "flatViewGroup":Lcom/facebook/react/flat/FlatViewGroup;
    :cond_0
    sget-object v3, Lcom/facebook/react/flat/FlatViewGroup;->LAYOUT_REQUESTS:Ljava/util/ArrayList;

    invoke-virtual {v3}, Ljava/util/ArrayList;->clear()V

    .line 1007
    return-void
.end method

.method private static sign(F)I
    .locals 1
    .param p0, "x"    # F

    .prologue
    .line 374
    const/4 v0, 0x0

    cmpl-float v0, p0, v0

    if-ltz v0, :cond_0

    const/4 v0, 0x1

    :goto_0
    return v0

    :cond_0
    const/4 v0, -0x1

    goto :goto_0
.end method

.method private virtualNodeRegionWithinBounds(FF)Lcom/facebook/react/flat/NodeRegion;
    .locals 3
    .param p1, "touchX"    # F
    .param p2, "touchY"    # F
    .annotation runtime Ljavax/annotation/Nullable;
    .end annotation

    .prologue
    .line 1052
    iget-object v2, p0, Lcom/facebook/react/flat/FlatViewGroup;->mDrawCommandManager:Lcom/facebook/react/flat/DrawCommandManager;

    if-eqz v2, :cond_0

    .line 1053
    iget-object v2, p0, Lcom/facebook/react/flat/FlatViewGroup;->mDrawCommandManager:Lcom/facebook/react/flat/DrawCommandManager;

    invoke-virtual {v2, p1, p2}, Lcom/facebook/react/flat/DrawCommandManager;->virtualNodeRegionWithinBounds(FF)Lcom/facebook/react/flat/NodeRegion;

    move-result-object v1

    .line 1066
    :goto_0
    return-object v1

    .line 1055
    :cond_0
    iget-object v2, p0, Lcom/facebook/react/flat/FlatViewGroup;->mNodeRegions:[Lcom/facebook/react/flat/NodeRegion;

    array-length v2, v2

    add-int/lit8 v0, v2, -0x1

    .local v0, "i":I
    :goto_1
    if-ltz v0, :cond_3

    .line 1056
    iget-object v2, p0, Lcom/facebook/react/flat/FlatViewGroup;->mNodeRegions:[Lcom/facebook/react/flat/NodeRegion;

    aget-object v1, v2, v0

    .line 1057
    .local v1, "nodeRegion":Lcom/facebook/react/flat/NodeRegion;
    iget-boolean v2, v1, Lcom/facebook/react/flat/NodeRegion;->mIsVirtual:Z

    if-nez v2, :cond_2

    .line 1055
    :cond_1
    add-int/lit8 v0, v0, -0x1

    goto :goto_1

    .line 1061
    :cond_2
    invoke-virtual {v1, p1, p2}, Lcom/facebook/react/flat/NodeRegion;->withinBounds(FF)Z

    move-result v2

    if-eqz v2, :cond_1

    goto :goto_0

    .line 1066
    .end local v1    # "nodeRegion":Lcom/facebook/react/flat/NodeRegion;
    :cond_3
    const/4 v1, 0x0

    goto :goto_0
.end method


# virtual methods
.method addViewInLayout(Landroid/view/View;)V
    .locals 3
    .param p1, "view"    # Landroid/view/View;

    .prologue
    .line 950
    const/4 v0, -0x1

    invoke-virtual {p1}, Landroid/view/View;->getLayoutParams()Landroid/view/ViewGroup$LayoutParams;

    move-result-object v1

    invoke-direct {p0, v1}, Lcom/facebook/react/flat/FlatViewGroup;->ensureLayoutParams(Landroid/view/ViewGroup$LayoutParams;)Landroid/view/ViewGroup$LayoutParams;

    move-result-object v1

    const/4 v2, 0x1

    invoke-virtual {p0, p1, v0, v1, v2}, Lcom/facebook/react/flat/FlatViewGroup;->addViewInLayout(Landroid/view/View;ILandroid/view/ViewGroup$LayoutParams;Z)Z

    .line 951
    return-void
.end method

.method addViewInLayout(Landroid/view/View;I)V
    .locals 2
    .param p1, "view"    # Landroid/view/View;
    .param p2, "index"    # I

    .prologue
    .line 960
    invoke-virtual {p1}, Landroid/view/View;->getLayoutParams()Landroid/view/ViewGroup$LayoutParams;

    move-result-object v0

    invoke-direct {p0, v0}, Lcom/facebook/react/flat/FlatViewGroup;->ensureLayoutParams(Landroid/view/ViewGroup$LayoutParams;)Landroid/view/ViewGroup$LayoutParams;

    move-result-object v0

    const/4 v1, 0x1

    invoke-virtual {p0, p1, p2, v0, v1}, Lcom/facebook/react/flat/FlatViewGroup;->addViewInLayout(Landroid/view/View;ILandroid/view/ViewGroup$LayoutParams;Z)Z

    .line 961
    return-void
.end method

.method attachViewToParent(Landroid/view/View;)V
    .locals 2
    .param p1, "view"    # Landroid/view/View;

    .prologue
    .line 969
    const/4 v0, -0x1

    invoke-virtual {p1}, Landroid/view/View;->getLayoutParams()Landroid/view/ViewGroup$LayoutParams;

    move-result-object v1

    invoke-direct {p0, v1}, Lcom/facebook/react/flat/FlatViewGroup;->ensureLayoutParams(Landroid/view/ViewGroup$LayoutParams;)Landroid/view/ViewGroup$LayoutParams;

    move-result-object v1

    invoke-virtual {p0, p1, v0, v1}, Lcom/facebook/react/flat/FlatViewGroup;->attachViewToParent(Landroid/view/View;ILandroid/view/ViewGroup$LayoutParams;)V

    .line 970
    return-void
.end method

.method attachViewToParent(Landroid/view/View;I)V
    .locals 1
    .param p1, "view"    # Landroid/view/View;
    .param p2, "index"    # I

    .prologue
    .line 979
    invoke-virtual {p1}, Landroid/view/View;->getLayoutParams()Landroid/view/ViewGroup$LayoutParams;

    move-result-object v0

    invoke-direct {p0, v0}, Lcom/facebook/react/flat/FlatViewGroup;->ensureLayoutParams(Landroid/view/ViewGroup$LayoutParams;)Landroid/view/ViewGroup$LayoutParams;

    move-result-object v0

    invoke-virtual {p0, p1, p2, v0}, Lcom/facebook/react/flat/FlatViewGroup;->attachViewToParent(Landroid/view/View;ILandroid/view/ViewGroup$LayoutParams;)V

    .line 980
    return-void
.end method

.method debugDrawNamedRect(Landroid/graphics/Canvas;ILjava/lang/String;FFFF)V
    .locals 8
    .param p1, "canvas"    # Landroid/graphics/Canvas;
    .param p2, "color"    # I
    .param p3, "name"    # Ljava/lang/String;
    .param p4, "left"    # F
    .param p5, "top"    # F
    .param p6, "right"    # F
    .param p7, "bottom"    # F

    .prologue
    const/high16 v4, 0x3f800000    # 1.0f

    .line 497
    sget-object v0, Lcom/facebook/react/flat/FlatViewGroup;->sDebugRectPaint:Landroid/graphics/Paint;

    sget-object v1, Lcom/facebook/react/flat/FlatViewGroup;->sDebugRectPaint:Landroid/graphics/Paint;

    invoke-virtual {v1}, Landroid/graphics/Paint;->getColor()I

    move-result v1

    const/high16 v2, -0x1000000

    and-int/2addr v1, v2

    const v2, 0xffffff

    and-int/2addr v2, p2

    or-int/2addr v1, v2

    invoke-virtual {v0, v1}, Landroid/graphics/Paint;->setColor(I)V

    .line 498
    sget-object v0, Lcom/facebook/react/flat/FlatViewGroup;->sDebugRectPaint:Landroid/graphics/Paint;

    const/16 v1, 0x64

    invoke-virtual {v0, v1}, Landroid/graphics/Paint;->setAlpha(I)V

    .line 499
    sub-float v3, p6, v4

    sub-float v4, p7, v4

    sget-object v5, Lcom/facebook/react/flat/FlatViewGroup;->sDebugRectPaint:Landroid/graphics/Paint;

    move-object v0, p1

    move v1, p4

    move v2, p5

    invoke-virtual/range {v0 .. v5}, Landroid/graphics/Canvas;->drawRect(FFFFLandroid/graphics/Paint;)V

    .line 505
    sget-object v5, Lcom/facebook/react/flat/FlatViewGroup;->sDebugCornerPaint:Landroid/graphics/Paint;

    const/16 v0, 0x8

    .line 512
    invoke-virtual {p0, v0}, Lcom/facebook/react/flat/FlatViewGroup;->dipsToPixels(I)I

    move-result v6

    const/4 v0, 0x1

    .line 513
    invoke-virtual {p0, v0}, Lcom/facebook/react/flat/FlatViewGroup;->dipsToPixels(I)I

    move-result v7

    move-object v0, p1

    move v1, p4

    move v2, p5

    move v3, p6

    move v4, p7

    .line 505
    invoke-static/range {v0 .. v7}, Lcom/facebook/react/flat/FlatViewGroup;->drawRectCorners(Landroid/graphics/Canvas;FFFFLandroid/graphics/Paint;II)V

    .line 514
    return-void
.end method

.method debugDrawNextChild(Landroid/graphics/Canvas;)V
    .locals 8
    .param p1, "canvas"    # Landroid/graphics/Canvas;

    .prologue
    .line 340
    iget v0, p0, Lcom/facebook/react/flat/FlatViewGroup;->mDrawChildIndex:I

    invoke-virtual {p0, v0}, Lcom/facebook/react/flat/FlatViewGroup;->getChildAt(I)Landroid/view/View;

    move-result-object v7

    .line 342
    .local v7, "child":Landroid/view/View;
    instance-of v0, v7, Lcom/facebook/react/flat/FlatViewGroup;

    if-eqz v0, :cond_0

    const v2, -0xbbbbbc

    .line 346
    .local v2, "color":I
    :goto_0
    invoke-virtual {v7}, Landroid/view/View;->getLeft()I

    move-result v0

    int-to-float v3, v0

    .line 347
    invoke-virtual {v7}, Landroid/view/View;->getTop()I

    move-result v0

    int-to-float v4, v0

    .line 348
    invoke-virtual {v7}, Landroid/view/View;->getRight()I

    move-result v0

    int-to-float v5, v0

    .line 349
    invoke-virtual {v7}, Landroid/view/View;->getBottom()I

    move-result v0

    int-to-float v6, v0

    move-object v0, p0

    move-object v1, p1

    .line 343
    invoke-direct/range {v0 .. v6}, Lcom/facebook/react/flat/FlatViewGroup;->debugDrawRect(Landroid/graphics/Canvas;IFFFF)V

    .line 350
    iget v0, p0, Lcom/facebook/react/flat/FlatViewGroup;->mDrawChildIndex:I

    add-int/lit8 v0, v0, 0x1

    iput v0, p0, Lcom/facebook/react/flat/FlatViewGroup;->mDrawChildIndex:I

    .line 351
    return-void

    .line 342
    .end local v2    # "color":I
    :cond_0
    const/high16 v2, -0x10000

    goto :goto_0
.end method

.method protected detachAllViewsFromParent()V
    .locals 0

    .prologue
    .line 187
    invoke-super {p0}, Landroid/view/ViewGroup;->detachAllViewsFromParent()V

    .line 188
    return-void
.end method

.method dipsToPixels(I)I
    .locals 3
    .param p1, "dips"    # I

    .prologue
    .line 355
    invoke-virtual {p0}, Lcom/facebook/react/flat/FlatViewGroup;->getResources()Landroid/content/res/Resources;

    move-result-object v1

    invoke-virtual {v1}, Landroid/content/res/Resources;->getDisplayMetrics()Landroid/util/DisplayMetrics;

    move-result-object v1

    iget v0, v1, Landroid/util/DisplayMetrics;->density:F

    .line 356
    .local v0, "scale":F
    int-to-float v1, p1

    mul-float/2addr v1, v0

    const/high16 v2, 0x3f000000    # 0.5f

    add-float/2addr v1, v2

    float-to-int v1, v1

    return v1
.end method

.method public dispatchDraw(Landroid/graphics/Canvas;)V
    .locals 5
    .param p1, "canvas"    # Landroid/graphics/Canvas;

    .prologue
    const/4 v2, 0x0

    .line 251
    iput-boolean v2, p0, Lcom/facebook/react/flat/FlatViewGroup;->mAndroidDebugDraw:Z

    .line 252
    invoke-super {p0, p1}, Landroid/view/ViewGroup;->dispatchDraw(Landroid/graphics/Canvas;)V

    .line 254
    iget-object v1, p0, Lcom/facebook/react/flat/FlatViewGroup;->mDrawCommandManager:Lcom/facebook/react/flat/DrawCommandManager;

    if-eqz v1, :cond_1

    .line 255
    iget-object v1, p0, Lcom/facebook/react/flat/FlatViewGroup;->mDrawCommandManager:Lcom/facebook/react/flat/DrawCommandManager;

    invoke-virtual {v1, p1}, Lcom/facebook/react/flat/DrawCommandManager;->draw(Landroid/graphics/Canvas;)V

    .line 262
    :cond_0
    iget v1, p0, Lcom/facebook/react/flat/FlatViewGroup;->mDrawChildIndex:I

    invoke-virtual {p0}, Lcom/facebook/react/flat/FlatViewGroup;->getChildCount()I

    move-result v3

    if-eq v1, v3, :cond_2

    .line 263
    new-instance v1, Ljava/lang/RuntimeException;

    new-instance v2, Ljava/lang/StringBuilder;

    invoke-direct {v2}, Ljava/lang/StringBuilder;-><init>()V

    const-string v3, "Did not draw all children: "

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    iget v3, p0, Lcom/facebook/react/flat/FlatViewGroup;->mDrawChildIndex:I

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v2

    const-string v3, " / "

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    .line 264
    invoke-virtual {p0}, Lcom/facebook/react/flat/FlatViewGroup;->getChildCount()I

    move-result v3

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v2

    invoke-direct {v1, v2}, Ljava/lang/RuntimeException;-><init>(Ljava/lang/String;)V

    throw v1

    .line 257
    :cond_1
    iget-object v3, p0, Lcom/facebook/react/flat/FlatViewGroup;->mDrawCommands:[Lcom/facebook/react/flat/DrawCommand;

    array-length v4, v3

    move v1, v2

    :goto_0
    if-ge v1, v4, :cond_0

    aget-object v0, v3, v1

    .line 258
    .local v0, "drawCommand":Lcom/facebook/react/flat/DrawCommand;
    invoke-virtual {v0, p0, p1}, Lcom/facebook/react/flat/DrawCommand;->draw(Lcom/facebook/react/flat/FlatViewGroup;Landroid/graphics/Canvas;)V

    .line 257
    add-int/lit8 v1, v1, 0x1

    goto :goto_0

    .line 266
    .end local v0    # "drawCommand":Lcom/facebook/react/flat/DrawCommand;
    :cond_2
    iput v2, p0, Lcom/facebook/react/flat/FlatViewGroup;->mDrawChildIndex:I

    .line 268
    iget-boolean v1, p0, Lcom/facebook/react/flat/FlatViewGroup;->mAndroidDebugDraw:Z

    if-eqz v1, :cond_3

    .line 269
    invoke-direct {p0}, Lcom/facebook/react/flat/FlatViewGroup;->initDebugDrawResources()V

    .line 270
    invoke-direct {p0, p1}, Lcom/facebook/react/flat/FlatViewGroup;->debugDraw(Landroid/graphics/Canvas;)V

    .line 273
    :cond_3
    iget-object v1, p0, Lcom/facebook/react/flat/FlatViewGroup;->mHotspot:Landroid/graphics/drawable/Drawable;

    if-eqz v1, :cond_4

    .line 274
    iget-object v1, p0, Lcom/facebook/react/flat/FlatViewGroup;->mHotspot:Landroid/graphics/drawable/Drawable;

    invoke-virtual {v1, p1}, Landroid/graphics/drawable/Drawable;->draw(Landroid/graphics/Canvas;)V

    .line 276
    :cond_4
    return-void
.end method

.method public dispatchDrawableHotspotChanged(FF)V
    .locals 1
    .param p1, "x"    # F
    .param p2, "y"    # F

    .prologue
    .line 568
    iget-object v0, p0, Lcom/facebook/react/flat/FlatViewGroup;->mHotspot:Landroid/graphics/drawable/Drawable;

    if-eqz v0, :cond_0

    .line 569
    iget-object v0, p0, Lcom/facebook/react/flat/FlatViewGroup;->mHotspot:Landroid/graphics/drawable/Drawable;

    invoke-virtual {v0, p1, p2}, Landroid/graphics/drawable/Drawable;->setHotspot(FF)V

    .line 570
    invoke-virtual {p0}, Lcom/facebook/react/flat/FlatViewGroup;->invalidate()V

    .line 572
    :cond_0
    return-void
.end method

.method protected drawChild(Landroid/graphics/Canvas;Landroid/view/View;J)Z
    .locals 1
    .param p1, "canvas"    # Landroid/graphics/Canvas;
    .param p2, "child"    # Landroid/view/View;
    .param p3, "drawingTime"    # J

    .prologue
    .line 331
    const/4 v0, 0x0

    return v0
.end method

.method drawNextChild(Landroid/graphics/Canvas;)V
    .locals 4
    .param p1, "canvas"    # Landroid/graphics/Canvas;

    .prologue
    .line 704
    iget v1, p0, Lcom/facebook/react/flat/FlatViewGroup;->mDrawChildIndex:I

    invoke-virtual {p0, v1}, Lcom/facebook/react/flat/FlatViewGroup;->getChildAt(I)Landroid/view/View;

    move-result-object v0

    .line 705
    .local v0, "child":Landroid/view/View;
    instance-of v1, v0, Lcom/facebook/react/flat/FlatViewGroup;

    if-eqz v1, :cond_0

    .line 706
    invoke-virtual {p0}, Lcom/facebook/react/flat/FlatViewGroup;->getDrawingTime()J

    move-result-wide v2

    invoke-super {p0, p1, v0, v2, v3}, Landroid/view/ViewGroup;->drawChild(Landroid/graphics/Canvas;Landroid/view/View;J)Z

    .line 716
    :goto_0
    iget v1, p0, Lcom/facebook/react/flat/FlatViewGroup;->mDrawChildIndex:I

    add-int/lit8 v1, v1, 0x1

    iput v1, p0, Lcom/facebook/react/flat/FlatViewGroup;->mDrawChildIndex:I

    .line 717
    return-void

    .line 709
    :cond_0
    const/4 v1, 0x2

    invoke-virtual {p1, v1}, Landroid/graphics/Canvas;->save(I)I

    .line 710
    sget-object v1, Lcom/facebook/react/flat/FlatViewGroup;->VIEW_BOUNDS:Landroid/graphics/Rect;

    invoke-virtual {v0, v1}, Landroid/view/View;->getHitRect(Landroid/graphics/Rect;)V

    .line 711
    sget-object v1, Lcom/facebook/react/flat/FlatViewGroup;->VIEW_BOUNDS:Landroid/graphics/Rect;

    invoke-virtual {p1, v1}, Landroid/graphics/Canvas;->clipRect(Landroid/graphics/Rect;)Z

    .line 712
    invoke-virtual {p0}, Lcom/facebook/react/flat/FlatViewGroup;->getDrawingTime()J

    move-result-wide v2

    invoke-super {p0, p1, v0, v2, v3}, Landroid/view/ViewGroup;->drawChild(Landroid/graphics/Canvas;Landroid/view/View;J)Z

    .line 713
    invoke-virtual {p1}, Landroid/graphics/Canvas;->restore()V

    goto :goto_0
.end method

.method protected drawableStateChanged()V
    .locals 2

    .prologue
    .line 576
    invoke-super {p0}, Landroid/view/ViewGroup;->drawableStateChanged()V

    .line 578
    iget-object v0, p0, Lcom/facebook/react/flat/FlatViewGroup;->mHotspot:Landroid/graphics/drawable/Drawable;

    if-eqz v0, :cond_0

    iget-object v0, p0, Lcom/facebook/react/flat/FlatViewGroup;->mHotspot:Landroid/graphics/drawable/Drawable;

    invoke-virtual {v0}, Landroid/graphics/drawable/Drawable;->isStateful()Z

    move-result v0

    if-eqz v0, :cond_0

    .line 579
    iget-object v0, p0, Lcom/facebook/react/flat/FlatViewGroup;->mHotspot:Landroid/graphics/drawable/Drawable;

    invoke-virtual {p0}, Lcom/facebook/react/flat/FlatViewGroup;->getDrawableState()[I

    move-result-object v1

    invoke-virtual {v0, v1}, Landroid/graphics/drawable/Drawable;->setState([I)Z

    .line 581
    :cond_0
    return-void
.end method

.method public getClippingRect(Landroid/graphics/Rect;)V
    .locals 2
    .param p1, "outClippingRect"    # Landroid/graphics/Rect;

    .prologue
    .line 1160
    iget-object v0, p0, Lcom/facebook/react/flat/FlatViewGroup;->mDrawCommandManager:Lcom/facebook/react/flat/DrawCommandManager;

    if-nez v0, :cond_0

    .line 1163
    new-instance v0, Ljava/lang/RuntimeException;

    const-string v1, "Trying to get the clipping rect for a non-clipping FlatViewGroup"

    invoke-direct {v0, v1}, Ljava/lang/RuntimeException;-><init>(Ljava/lang/String;)V

    throw v0

    .line 1166
    :cond_0
    iget-object v0, p0, Lcom/facebook/react/flat/FlatViewGroup;->mDrawCommandManager:Lcom/facebook/react/flat/DrawCommandManager;

    invoke-virtual {v0, p1}, Lcom/facebook/react/flat/DrawCommandManager;->getClippingRect(Landroid/graphics/Rect;)V

    .line 1167
    return-void
.end method

.method getDetachedViews()Landroid/util/SparseArray;
    .locals 1
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()",
            "Landroid/util/SparseArray",
            "<",
            "Landroid/view/View;",
            ">;"
        }
    .end annotation

    .prologue
    .line 805
    iget-object v0, p0, Lcom/facebook/react/flat/FlatViewGroup;->mDrawCommandManager:Lcom/facebook/react/flat/DrawCommandManager;

    if-nez v0, :cond_0

    .line 806
    sget-object v0, Lcom/facebook/react/flat/FlatViewGroup;->EMPTY_DETACHED_VIEWS:Landroid/util/SparseArray;

    .line 808
    :goto_0
    return-object v0

    :cond_0
    iget-object v0, p0, Lcom/facebook/react/flat/FlatViewGroup;->mDrawCommandManager:Lcom/facebook/react/flat/DrawCommandManager;

    invoke-virtual {v0}, Lcom/facebook/react/flat/DrawCommandManager;->getDetachedViews()Landroid/util/SparseArray;

    move-result-object v0

    goto :goto_0
.end method

.method public getHitSlopRect()Landroid/graphics/Rect;
    .locals 1
    .annotation runtime Ljavax/annotation/Nullable;
    .end annotation

    .prologue
    .line 1196
    iget-object v0, p0, Lcom/facebook/react/flat/FlatViewGroup;->mHitSlopRect:Landroid/graphics/Rect;

    return-object v0
.end method

.method getNodeRegionForTag(I)Lcom/facebook/react/flat/NodeRegion;
    .locals 5
    .param p1, "reactTag"    # I

    .prologue
    .line 789
    iget-object v2, p0, Lcom/facebook/react/flat/FlatViewGroup;->mNodeRegions:[Lcom/facebook/react/flat/NodeRegion;

    array-length v3, v2

    const/4 v1, 0x0

    :goto_0
    if-ge v1, v3, :cond_1

    aget-object v0, v2, v1

    .line 790
    .local v0, "region":Lcom/facebook/react/flat/NodeRegion;
    invoke-virtual {v0, p1}, Lcom/facebook/react/flat/NodeRegion;->matchesTag(I)Z

    move-result v4

    if-eqz v4, :cond_0

    .line 794
    .end local v0    # "region":Lcom/facebook/react/flat/NodeRegion;
    :goto_1
    return-object v0

    .line 789
    .restart local v0    # "region":Lcom/facebook/react/flat/NodeRegion;
    :cond_0
    add-int/lit8 v1, v1, 0x1

    goto :goto_0

    .line 794
    .end local v0    # "region":Lcom/facebook/react/flat/NodeRegion;
    :cond_1
    sget-object v0, Lcom/facebook/react/flat/NodeRegion;->EMPTY:Lcom/facebook/react/flat/NodeRegion;

    goto :goto_1
.end method

.method public getPointerEvents()Lcom/facebook/react/uimanager/PointerEvents;
    .locals 1

    .prologue
    .line 666
    iget-object v0, p0, Lcom/facebook/react/flat/FlatViewGroup;->mPointerEvents:Lcom/facebook/react/uimanager/PointerEvents;

    return-object v0
.end method

.method public getRemoveClippedSubviews()Z
    .locals 1

    .prologue
    .line 1191
    iget-object v0, p0, Lcom/facebook/react/flat/FlatViewGroup;->mDrawCommandManager:Lcom/facebook/react/flat/DrawCommandManager;

    if-eqz v0, :cond_0

    const/4 v0, 0x1

    :goto_0
    return v0

    :cond_0
    const/4 v0, 0x0

    goto :goto_0
.end method

.method public hasOverlappingRendering()Z
    .locals 1

    .prologue
    .line 611
    iget-boolean v0, p0, Lcom/facebook/react/flat/FlatViewGroup;->mNeedsOffscreenAlphaCompositing:Z

    return v0
.end method

.method public interceptsTouchEvent(FF)Z
    .locals 2
    .param p1, "touchX"    # F
    .param p2, "touchY"    # F

    .prologue
    .line 229
    invoke-direct {p0, p1, p2}, Lcom/facebook/react/flat/FlatViewGroup;->anyNodeRegionWithinBounds(FF)Lcom/facebook/react/flat/NodeRegion;

    move-result-object v0

    .line 230
    .local v0, "nodeRegion":Lcom/facebook/react/flat/NodeRegion;
    if-eqz v0, :cond_0

    iget-boolean v1, v0, Lcom/facebook/react/flat/NodeRegion;->mIsVirtual:Z

    if-eqz v1, :cond_0

    const/4 v1, 0x1

    :goto_0
    return v1

    :cond_0
    const/4 v1, 0x0

    goto :goto_0
.end method

.method public invalidate()V
    .locals 3

    .prologue
    const/4 v2, 0x0

    .line 602
    invoke-virtual {p0}, Lcom/facebook/react/flat/FlatViewGroup;->getWidth()I

    move-result v0

    add-int/lit8 v0, v0, 0x1

    invoke-virtual {p0}, Lcom/facebook/react/flat/FlatViewGroup;->getHeight()I

    move-result v1

    add-int/lit8 v1, v1, 0x1

    invoke-virtual {p0, v2, v2, v0, v1}, Lcom/facebook/react/flat/FlatViewGroup;->invalidate(IIII)V

    .line 603
    return-void
.end method

.method public jumpDrawablesToCurrentState()V
    .locals 1

    .prologue
    .line 585
    invoke-super {p0}, Landroid/view/ViewGroup;->jumpDrawablesToCurrentState()V

    .line 586
    iget-object v0, p0, Lcom/facebook/react/flat/FlatViewGroup;->mHotspot:Landroid/graphics/drawable/Drawable;

    if-eqz v0, :cond_0

    .line 587
    iget-object v0, p0, Lcom/facebook/react/flat/FlatViewGroup;->mHotspot:Landroid/graphics/drawable/Drawable;

    invoke-virtual {v0}, Landroid/graphics/drawable/Drawable;->jumpToCurrentState()V

    .line 589
    :cond_0
    return-void
.end method

.method public measureWithCommands()Landroid/graphics/Rect;
    .locals 13

    .prologue
    const/4 v10, 0x0

    .line 1012
    invoke-virtual {p0}, Lcom/facebook/react/flat/FlatViewGroup;->getChildCount()I

    move-result v2

    .line 1013
    .local v2, "childCount":I
    if-nez v2, :cond_0

    iget-object v9, p0, Lcom/facebook/react/flat/FlatViewGroup;->mDrawCommands:[Lcom/facebook/react/flat/DrawCommand;

    array-length v9, v9

    if-nez v9, :cond_0

    .line 1014
    new-instance v9, Landroid/graphics/Rect;

    invoke-direct {v9, v10, v10, v10, v10}, Landroid/graphics/Rect;-><init>(IIII)V

    .line 1040
    :goto_0
    return-object v9

    .line 1016
    :cond_0
    const v5, 0x7fffffff

    .line 1017
    .local v5, "left":I
    const v8, 0x7fffffff

    .line 1018
    .local v8, "top":I
    const/high16 v7, -0x80000000

    .line 1019
    .local v7, "right":I
    const/high16 v0, -0x80000000

    .line 1020
    .local v0, "bottom":I
    const/4 v4, 0x0

    .local v4, "i":I
    :goto_1
    if-ge v4, v2, :cond_1

    .line 1023
    invoke-virtual {p0, v4}, Lcom/facebook/react/flat/FlatViewGroup;->getChildAt(I)Landroid/view/View;

    move-result-object v1

    .line 1024
    .local v1, "child":Landroid/view/View;
    invoke-virtual {v1}, Landroid/view/View;->getLeft()I

    move-result v9

    invoke-static {v5, v9}, Ljava/lang/Math;->min(II)I

    move-result v5

    .line 1025
    invoke-virtual {v1}, Landroid/view/View;->getTop()I

    move-result v9

    invoke-static {v8, v9}, Ljava/lang/Math;->min(II)I

    move-result v8

    .line 1026
    invoke-virtual {v1}, Landroid/view/View;->getRight()I

    move-result v9

    invoke-static {v7, v9}, Ljava/lang/Math;->max(II)I

    move-result v7

    .line 1027
    invoke-virtual {v1}, Landroid/view/View;->getBottom()I

    move-result v9

    invoke-static {v0, v9}, Ljava/lang/Math;->max(II)I

    move-result v0

    .line 1020
    add-int/lit8 v4, v4, 0x1

    goto :goto_1

    .line 1030
    .end local v1    # "child":Landroid/view/View;
    :cond_1
    iget-object v11, p0, Lcom/facebook/react/flat/FlatViewGroup;->mDrawCommands:[Lcom/facebook/react/flat/DrawCommand;

    array-length v12, v11

    move v9, v10

    :goto_2
    if-ge v9, v12, :cond_3

    aget-object v6, v11, v9

    .line 1031
    .local v6, "mDrawCommand":Lcom/facebook/react/flat/DrawCommand;
    instance-of v10, v6, Lcom/facebook/react/flat/AbstractDrawCommand;

    if-nez v10, :cond_2

    .line 1030
    :goto_3
    add-int/lit8 v9, v9, 0x1

    goto :goto_2

    :cond_2
    move-object v3, v6

    .line 1034
    check-cast v3, Lcom/facebook/react/flat/AbstractDrawCommand;

    .line 1035
    .local v3, "drawCommand":Lcom/facebook/react/flat/AbstractDrawCommand;
    invoke-virtual {v3}, Lcom/facebook/react/flat/AbstractDrawCommand;->getLeft()F

    move-result v10

    invoke-static {v10}, Ljava/lang/Math;->round(F)I

    move-result v10

    invoke-static {v5, v10}, Ljava/lang/Math;->min(II)I

    move-result v5

    .line 1036
    invoke-virtual {v3}, Lcom/facebook/react/flat/AbstractDrawCommand;->getTop()F

    move-result v10

    invoke-static {v10}, Ljava/lang/Math;->round(F)I

    move-result v10

    invoke-static {v8, v10}, Ljava/lang/Math;->min(II)I

    move-result v8

    .line 1037
    invoke-virtual {v3}, Lcom/facebook/react/flat/AbstractDrawCommand;->getRight()F

    move-result v10

    invoke-static {v10}, Ljava/lang/Math;->round(F)I

    move-result v10

    invoke-static {v7, v10}, Ljava/lang/Math;->max(II)I

    move-result v7

    .line 1038
    invoke-virtual {v3}, Lcom/facebook/react/flat/AbstractDrawCommand;->getBottom()F

    move-result v10

    invoke-static {v10}, Ljava/lang/Math;->round(F)I

    move-result v10

    invoke-static {v0, v10}, Ljava/lang/Math;->max(II)I

    move-result v0

    goto :goto_3

    .line 1040
    .end local v3    # "drawCommand":Lcom/facebook/react/flat/AbstractDrawCommand;
    .end local v6    # "mDrawCommand":Lcom/facebook/react/flat/DrawCommand;
    :cond_3
    new-instance v9, Landroid/graphics/Rect;

    invoke-direct {v9, v5, v8, v7, v0}, Landroid/graphics/Rect;-><init>(IIII)V

    goto :goto_0
.end method

.method mountAttachDetachListeners([Lcom/facebook/react/flat/AttachDetachListener;)V
    .locals 1
    .param p1, "listeners"    # [Lcom/facebook/react/flat/AttachDetachListener;

    .prologue
    .line 844
    iget-boolean v0, p0, Lcom/facebook/react/flat/FlatViewGroup;->mIsAttached:Z

    if-eqz v0, :cond_0

    .line 857
    invoke-direct {p0, p1}, Lcom/facebook/react/flat/FlatViewGroup;->dispatchOnAttached([Lcom/facebook/react/flat/AttachDetachListener;)V

    .line 858
    iget-object v0, p0, Lcom/facebook/react/flat/FlatViewGroup;->mAttachDetachListeners:[Lcom/facebook/react/flat/AttachDetachListener;

    invoke-static {v0}, Lcom/facebook/react/flat/FlatViewGroup;->dispatchOnDetached([Lcom/facebook/react/flat/AttachDetachListener;)V

    .line 860
    :cond_0
    iput-object p1, p0, Lcom/facebook/react/flat/FlatViewGroup;->mAttachDetachListeners:[Lcom/facebook/react/flat/AttachDetachListener;

    .line 861
    return-void
.end method

.method mountClippingDrawCommands([Lcom/facebook/react/flat/DrawCommand;Landroid/util/SparseIntArray;[F[FZ)V
    .locals 6
    .param p1, "drawCommands"    # [Lcom/facebook/react/flat/DrawCommand;
    .param p2, "drawViewIndexMap"    # Landroid/util/SparseIntArray;
    .param p3, "maxBottom"    # [F
    .param p4, "minTop"    # [F
    .param p5, "willMountViews"    # Z

    .prologue
    .line 757
    iget-object v0, p0, Lcom/facebook/react/flat/FlatViewGroup;->mDrawCommandManager:Lcom/facebook/react/flat/DrawCommandManager;

    invoke-static {v0}, Lcom/facebook/infer/annotation/Assertions;->assertNotNull(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/facebook/react/flat/DrawCommandManager;

    move-object v1, p1

    move-object v2, p2

    move-object v3, p3

    move-object v4, p4

    move v5, p5

    invoke-virtual/range {v0 .. v5}, Lcom/facebook/react/flat/DrawCommandManager;->mountDrawCommands([Lcom/facebook/react/flat/DrawCommand;Landroid/util/SparseIntArray;[F[FZ)V

    .line 763
    invoke-virtual {p0}, Lcom/facebook/react/flat/FlatViewGroup;->invalidate()V

    .line 764
    return-void
.end method

.method mountClippingNodeRegions([Lcom/facebook/react/flat/NodeRegion;[F[F)V
    .locals 1
    .param p1, "nodeRegions"    # [Lcom/facebook/react/flat/NodeRegion;
    .param p2, "maxBottom"    # [F
    .param p3, "minTop"    # [F

    .prologue
    .line 886
    iput-object p1, p0, Lcom/facebook/react/flat/FlatViewGroup;->mNodeRegions:[Lcom/facebook/react/flat/NodeRegion;

    .line 887
    iget-object v0, p0, Lcom/facebook/react/flat/FlatViewGroup;->mDrawCommandManager:Lcom/facebook/react/flat/DrawCommandManager;

    invoke-static {v0}, Lcom/facebook/infer/annotation/Assertions;->assertNotNull(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/facebook/react/flat/DrawCommandManager;

    invoke-virtual {v0, p1, p2, p3}, Lcom/facebook/react/flat/DrawCommandManager;->mountNodeRegions([Lcom/facebook/react/flat/NodeRegion;[F[F)V

    .line 888
    return-void
.end method

.method mountDrawCommands([Lcom/facebook/react/flat/DrawCommand;)V
    .locals 0
    .param p1, "drawCommands"    # [Lcom/facebook/react/flat/DrawCommand;

    .prologue
    .line 730
    iput-object p1, p0, Lcom/facebook/react/flat/FlatViewGroup;->mDrawCommands:[Lcom/facebook/react/flat/DrawCommand;

    .line 731
    invoke-virtual {p0}, Lcom/facebook/react/flat/FlatViewGroup;->invalidate()V

    .line 732
    return-void
.end method

.method mountNodeRegions([Lcom/facebook/react/flat/NodeRegion;)V
    .locals 0
    .param p1, "nodeRegions"    # [Lcom/facebook/react/flat/NodeRegion;

    .prologue
    .line 871
    iput-object p1, p0, Lcom/facebook/react/flat/FlatViewGroup;->mNodeRegions:[Lcom/facebook/react/flat/NodeRegion;

    .line 872
    return-void
.end method

.method mountViews(Lcom/facebook/react/flat/ViewResolver;[I[I)V
    .locals 7
    .param p1, "viewResolver"    # Lcom/facebook/react/flat/ViewResolver;
    .param p2, "viewsToAdd"    # [I
    .param p3, "viewsToDetach"    # [I

    .prologue
    const/4 v4, 0x0

    .line 914
    iget-object v3, p0, Lcom/facebook/react/flat/FlatViewGroup;->mDrawCommandManager:Lcom/facebook/react/flat/DrawCommandManager;

    if-eqz v3, :cond_1

    .line 915
    iget-object v3, p0, Lcom/facebook/react/flat/FlatViewGroup;->mDrawCommandManager:Lcom/facebook/react/flat/DrawCommandManager;

    invoke-virtual {v3, p1, p2, p3}, Lcom/facebook/react/flat/DrawCommandManager;->mountViews(Lcom/facebook/react/flat/ViewResolver;[I[I)V

    .line 941
    :cond_0
    invoke-virtual {p0}, Lcom/facebook/react/flat/FlatViewGroup;->invalidate()V

    .line 942
    return-void

    .line 917
    :cond_1
    array-length v5, p2

    move v3, v4

    :goto_0
    if-ge v3, v5, :cond_3

    aget v1, p2, v3

    .line 918
    .local v1, "viewToAdd":I
    if-lez v1, :cond_2

    .line 919
    invoke-interface {p1, v1}, Lcom/facebook/react/flat/ViewResolver;->getView(I)Landroid/view/View;

    move-result-object v0

    .line 920
    .local v0, "view":Landroid/view/View;
    invoke-static {v0}, Lcom/facebook/react/flat/FlatViewGroup;->ensureViewHasNoParent(Landroid/view/View;)V

    .line 921
    invoke-virtual {p0, v0}, Lcom/facebook/react/flat/FlatViewGroup;->addViewInLayout(Landroid/view/View;)V

    .line 917
    :goto_1
    add-int/lit8 v3, v3, 0x1

    goto :goto_0

    .line 923
    .end local v0    # "view":Landroid/view/View;
    :cond_2
    neg-int v6, v1

    invoke-interface {p1, v6}, Lcom/facebook/react/flat/ViewResolver;->getView(I)Landroid/view/View;

    move-result-object v0

    .line 924
    .restart local v0    # "view":Landroid/view/View;
    invoke-static {v0}, Lcom/facebook/react/flat/FlatViewGroup;->ensureViewHasNoParent(Landroid/view/View;)V

    .line 927
    invoke-virtual {p0, v0}, Lcom/facebook/react/flat/FlatViewGroup;->attachViewToParent(Landroid/view/View;)V

    goto :goto_1

    .line 931
    .end local v0    # "view":Landroid/view/View;
    .end local v1    # "viewToAdd":I
    :cond_3
    array-length v5, p3

    move v3, v4

    :goto_2
    if-ge v3, v5, :cond_0

    aget v2, p3, v3

    .line 932
    .local v2, "viewToDetach":I
    invoke-interface {p1, v2}, Lcom/facebook/react/flat/ViewResolver;->getView(I)Landroid/view/View;

    move-result-object v0

    .line 933
    .restart local v0    # "view":Landroid/view/View;
    invoke-virtual {v0}, Landroid/view/View;->getParent()Landroid/view/ViewParent;

    move-result-object v6

    if-eqz v6, :cond_4

    .line 934
    new-instance v3, Ljava/lang/RuntimeException;

    const-string v4, "Trying to remove view not owned by FlatViewGroup"

    invoke-direct {v3, v4}, Ljava/lang/RuntimeException;-><init>(Ljava/lang/String;)V

    throw v3

    .line 936
    :cond_4
    invoke-virtual {p0, v0, v4}, Lcom/facebook/react/flat/FlatViewGroup;->removeDetachedView(Landroid/view/View;Z)V

    .line 931
    add-int/lit8 v3, v3, 0x1

    goto :goto_2
.end method

.method protected onAttachedToWindow()V
    .locals 1

    .prologue
    .line 529
    iget-boolean v0, p0, Lcom/facebook/react/flat/FlatViewGroup;->mIsAttached:Z

    if-eqz v0, :cond_0

    .line 541
    :goto_0
    return-void

    .line 534
    :cond_0
    const/4 v0, 0x1

    iput-boolean v0, p0, Lcom/facebook/react/flat/FlatViewGroup;->mIsAttached:Z

    .line 536
    invoke-super {p0}, Landroid/view/ViewGroup;->onAttachedToWindow()V

    .line 537
    iget-object v0, p0, Lcom/facebook/react/flat/FlatViewGroup;->mAttachDetachListeners:[Lcom/facebook/react/flat/AttachDetachListener;

    invoke-direct {p0, v0}, Lcom/facebook/react/flat/FlatViewGroup;->dispatchOnAttached([Lcom/facebook/react/flat/AttachDetachListener;)V

    .line 540
    invoke-virtual {p0}, Lcom/facebook/react/flat/FlatViewGroup;->updateClippingRect()V

    goto :goto_0
.end method

.method protected onDebugDraw(Landroid/graphics/Canvas;)V
    .locals 1
    .param p1, "canvas"    # Landroid/graphics/Canvas;

    .prologue
    .line 240
    const/4 v0, 0x1

    iput-boolean v0, p0, Lcom/facebook/react/flat/FlatViewGroup;->mAndroidDebugDraw:Z

    .line 241
    return-void
.end method

.method protected onDetachedFromWindow()V
    .locals 2

    .prologue
    .line 545
    iget-boolean v0, p0, Lcom/facebook/react/flat/FlatViewGroup;->mIsAttached:Z

    if-nez v0, :cond_0

    .line 546
    new-instance v0, Ljava/lang/RuntimeException;

    const-string v1, "Double detach"

    invoke-direct {v0, v1}, Ljava/lang/RuntimeException;-><init>(Ljava/lang/String;)V

    throw v0

    .line 549
    :cond_0
    const/4 v0, 0x0

    iput-boolean v0, p0, Lcom/facebook/react/flat/FlatViewGroup;->mIsAttached:Z

    .line 551
    invoke-super {p0}, Landroid/view/ViewGroup;->onDetachedFromWindow()V

    .line 552
    iget-object v0, p0, Lcom/facebook/react/flat/FlatViewGroup;->mAttachDetachListeners:[Lcom/facebook/react/flat/AttachDetachListener;

    invoke-static {v0}, Lcom/facebook/react/flat/FlatViewGroup;->dispatchOnDetached([Lcom/facebook/react/flat/AttachDetachListener;)V

    .line 553
    return-void
.end method

.method public onInterceptTouchEvent(Landroid/view/MotionEvent;)Z
    .locals 6
    .param p1, "ev"    # Landroid/view/MotionEvent;

    .prologue
    const/4 v2, 0x1

    .line 621
    invoke-virtual {p1}, Landroid/view/MotionEvent;->getDownTime()J

    move-result-wide v0

    .line 622
    .local v0, "downTime":J
    iget-wide v4, p0, Lcom/facebook/react/flat/FlatViewGroup;->mLastTouchDownTime:J

    cmp-long v3, v0, v4

    if-eqz v3, :cond_1

    .line 623
    iput-wide v0, p0, Lcom/facebook/react/flat/FlatViewGroup;->mLastTouchDownTime:J

    .line 624
    invoke-virtual {p1}, Landroid/view/MotionEvent;->getX()F

    move-result v3

    invoke-virtual {p1}, Landroid/view/MotionEvent;->getY()F

    move-result v4

    invoke-virtual {p0, v3, v4}, Lcom/facebook/react/flat/FlatViewGroup;->interceptsTouchEvent(FF)Z

    move-result v3

    if-eqz v3, :cond_1

    .line 637
    :cond_0
    :goto_0
    return v2

    .line 629
    :cond_1
    iget-object v3, p0, Lcom/facebook/react/flat/FlatViewGroup;->mOnInterceptTouchEventListener:Lcom/facebook/react/touch/OnInterceptTouchEventListener;

    if-eqz v3, :cond_2

    iget-object v3, p0, Lcom/facebook/react/flat/FlatViewGroup;->mOnInterceptTouchEventListener:Lcom/facebook/react/touch/OnInterceptTouchEventListener;

    .line 630
    invoke-interface {v3, p0, p1}, Lcom/facebook/react/touch/OnInterceptTouchEventListener;->onInterceptTouchEvent(Landroid/view/ViewGroup;Landroid/view/MotionEvent;)Z

    move-result v3

    if-nez v3, :cond_0

    .line 634
    :cond_2
    iget-object v3, p0, Lcom/facebook/react/flat/FlatViewGroup;->mPointerEvents:Lcom/facebook/react/uimanager/PointerEvents;

    sget-object v4, Lcom/facebook/react/uimanager/PointerEvents;->NONE:Lcom/facebook/react/uimanager/PointerEvents;

    if-eq v3, v4, :cond_0

    iget-object v3, p0, Lcom/facebook/react/flat/FlatViewGroup;->mPointerEvents:Lcom/facebook/react/uimanager/PointerEvents;

    sget-object v4, Lcom/facebook/react/uimanager/PointerEvents;->BOX_ONLY:Lcom/facebook/react/uimanager/PointerEvents;

    if-eq v3, v4, :cond_0

    .line 637
    invoke-super {p0, p1}, Landroid/view/ViewGroup;->onInterceptTouchEvent(Landroid/view/MotionEvent;)Z

    move-result v2

    goto :goto_0
.end method

.method protected onLayout(ZIIII)V
    .locals 0
    .param p1, "changed"    # Z
    .param p2, "l"    # I
    .param p3, "t"    # I
    .param p4, "r"    # I
    .param p5, "b"    # I

    .prologue
    .line 519
    return-void
.end method

.method protected onSizeChanged(IIII)V
    .locals 2
    .param p1, "w"    # I
    .param p2, "h"    # I
    .param p3, "oldw"    # I
    .param p4, "oldh"    # I

    .prologue
    const/4 v1, 0x0

    .line 557
    iget-object v0, p0, Lcom/facebook/react/flat/FlatViewGroup;->mHotspot:Landroid/graphics/drawable/Drawable;

    if-eqz v0, :cond_0

    .line 558
    iget-object v0, p0, Lcom/facebook/react/flat/FlatViewGroup;->mHotspot:Landroid/graphics/drawable/Drawable;

    invoke-virtual {v0, v1, v1, p1, p2}, Landroid/graphics/drawable/Drawable;->setBounds(IIII)V

    .line 559
    invoke-virtual {p0}, Lcom/facebook/react/flat/FlatViewGroup;->invalidate()V

    .line 563
    :cond_0
    invoke-virtual {p0}, Lcom/facebook/react/flat/FlatViewGroup;->updateClippingRect()V

    .line 564
    return-void
.end method

.method public onTouchEvent(Landroid/view/MotionEvent;)Z
    .locals 4
    .param p1, "ev"    # Landroid/view/MotionEvent;

    .prologue
    const/4 v1, 0x0

    .line 643
    iget-object v2, p0, Lcom/facebook/react/flat/FlatViewGroup;->mPointerEvents:Lcom/facebook/react/uimanager/PointerEvents;

    sget-object v3, Lcom/facebook/react/uimanager/PointerEvents;->NONE:Lcom/facebook/react/uimanager/PointerEvents;

    if-ne v2, v3, :cond_1

    .line 661
    :cond_0
    :goto_0
    return v1

    .line 647
    :cond_1
    iget-object v2, p0, Lcom/facebook/react/flat/FlatViewGroup;->mPointerEvents:Lcom/facebook/react/uimanager/PointerEvents;

    sget-object v3, Lcom/facebook/react/uimanager/PointerEvents;->BOX_NONE:Lcom/facebook/react/uimanager/PointerEvents;

    if-ne v2, v3, :cond_2

    .line 649
    invoke-virtual {p1}, Landroid/view/MotionEvent;->getX()F

    move-result v2

    invoke-virtual {p1}, Landroid/view/MotionEvent;->getY()F

    move-result v3

    invoke-direct {p0, v2, v3}, Lcom/facebook/react/flat/FlatViewGroup;->virtualNodeRegionWithinBounds(FF)Lcom/facebook/react/flat/NodeRegion;

    move-result-object v0

    .line 650
    .local v0, "nodeRegion":Lcom/facebook/react/flat/NodeRegion;
    if-eqz v0, :cond_0

    .line 661
    .end local v0    # "nodeRegion":Lcom/facebook/react/flat/NodeRegion;
    :cond_2
    const/4 v1, 0x1

    goto :goto_0
.end method

.method onViewDropped(Landroid/view/View;)V
    .locals 1
    .param p1, "view"    # Landroid/view/View;

    .prologue
    .line 776
    iget-object v0, p0, Lcom/facebook/react/flat/FlatViewGroup;->mDrawCommandManager:Lcom/facebook/react/flat/DrawCommandManager;

    if-eqz v0, :cond_0

    .line 778
    iget-object v0, p0, Lcom/facebook/react/flat/FlatViewGroup;->mDrawCommandManager:Lcom/facebook/react/flat/DrawCommandManager;

    invoke-virtual {v0, p1}, Lcom/facebook/react/flat/DrawCommandManager;->onClippedViewDropped(Landroid/view/View;)V

    .line 780
    :cond_0
    return-void
.end method

.method public reactTagForTouch(FF)I
    .locals 3
    .param p1, "touchX"    # F
    .param p2, "touchY"    # F

    .prologue
    .line 212
    iget-object v1, p0, Lcom/facebook/react/flat/FlatViewGroup;->mPointerEvents:Lcom/facebook/react/uimanager/PointerEvents;

    sget-object v2, Lcom/facebook/react/uimanager/PointerEvents;->NONE:Lcom/facebook/react/uimanager/PointerEvents;

    if-eq v1, v2, :cond_0

    const/4 v1, 0x1

    :goto_0
    const-string v2, "TouchTargetHelper should not allow calling this method when pointer events are NONE"

    invoke-static {v1, v2}, Lcom/facebook/react/bridge/SoftAssertions;->assertCondition(ZLjava/lang/String;)V

    .line 216
    iget-object v1, p0, Lcom/facebook/react/flat/FlatViewGroup;->mPointerEvents:Lcom/facebook/react/uimanager/PointerEvents;

    sget-object v2, Lcom/facebook/react/uimanager/PointerEvents;->BOX_ONLY:Lcom/facebook/react/uimanager/PointerEvents;

    if-eq v1, v2, :cond_1

    .line 217
    invoke-direct {p0, p1, p2}, Lcom/facebook/react/flat/FlatViewGroup;->virtualNodeRegionWithinBounds(FF)Lcom/facebook/react/flat/NodeRegion;

    move-result-object v0

    .line 218
    .local v0, "nodeRegion":Lcom/facebook/react/flat/NodeRegion;
    if-eqz v0, :cond_1

    .line 219
    invoke-virtual {v0, p1, p2}, Lcom/facebook/react/flat/NodeRegion;->getReactTag(FF)I

    move-result v1

    .line 224
    .end local v0    # "nodeRegion":Lcom/facebook/react/flat/NodeRegion;
    :goto_1
    return v1

    .line 212
    :cond_0
    const/4 v1, 0x0

    goto :goto_0

    .line 224
    :cond_1
    invoke-virtual {p0}, Lcom/facebook/react/flat/FlatViewGroup;->getId()I

    move-result v1

    goto :goto_1
.end method

.method public removeAllViewsInLayout()V
    .locals 1

    .prologue
    .line 829
    sget-object v0, Lcom/facebook/react/flat/DrawCommand;->EMPTY_ARRAY:[Lcom/facebook/react/flat/DrawCommand;

    iput-object v0, p0, Lcom/facebook/react/flat/FlatViewGroup;->mDrawCommands:[Lcom/facebook/react/flat/DrawCommand;

    .line 830
    invoke-super {p0}, Landroid/view/ViewGroup;->removeAllViewsInLayout()V

    .line 831
    return-void
.end method

.method removeDetachedView(Landroid/view/View;)V
    .locals 1
    .param p1, "view"    # Landroid/view/View;

    .prologue
    .line 820
    const/4 v0, 0x0

    invoke-virtual {p0, p1, v0}, Lcom/facebook/react/flat/FlatViewGroup;->removeDetachedView(Landroid/view/View;Z)V

    .line 821
    return-void
.end method

.method public requestLayout()V
    .locals 1
    .annotation build Landroid/annotation/SuppressLint;
        value = {
            "MissingSuperCall"
        }
    .end annotation

    .prologue
    .line 193
    iget-boolean v0, p0, Lcom/facebook/react/flat/FlatViewGroup;->mIsLayoutRequested:Z

    if-eqz v0, :cond_0

    .line 199
    :goto_0
    return-void

    .line 197
    :cond_0
    const/4 v0, 0x1

    iput-boolean v0, p0, Lcom/facebook/react/flat/FlatViewGroup;->mIsLayoutRequested:Z

    .line 198
    sget-object v0, Lcom/facebook/react/flat/FlatViewGroup;->LAYOUT_REQUESTS:Ljava/util/ArrayList;

    invoke-virtual {v0, p0}, Ljava/util/ArrayList;->add(Ljava/lang/Object;)Z

    goto :goto_0
.end method

.method setHitSlopRect(Landroid/graphics/Rect;)V
    .locals 0
    .param p1, "rect"    # Landroid/graphics/Rect;
        .annotation runtime Ljavax/annotation/Nullable;
        .end annotation
    .end param

    .prologue
    .line 1200
    iput-object p1, p0, Lcom/facebook/react/flat/FlatViewGroup;->mHitSlopRect:Landroid/graphics/Rect;

    .line 1201
    return-void
.end method

.method setHotspot(Landroid/graphics/drawable/Drawable;)V
    .locals 2
    .param p1, "hotspot"    # Landroid/graphics/drawable/Drawable;

    .prologue
    .line 681
    iget-object v0, p0, Lcom/facebook/react/flat/FlatViewGroup;->mHotspot:Landroid/graphics/drawable/Drawable;

    if-eqz v0, :cond_0

    .line 682
    iget-object v0, p0, Lcom/facebook/react/flat/FlatViewGroup;->mHotspot:Landroid/graphics/drawable/Drawable;

    const/4 v1, 0x0

    invoke-virtual {v0, v1}, Landroid/graphics/drawable/Drawable;->setCallback(Landroid/graphics/drawable/Drawable$Callback;)V

    .line 683
    iget-object v0, p0, Lcom/facebook/react/flat/FlatViewGroup;->mHotspot:Landroid/graphics/drawable/Drawable;

    invoke-virtual {p0, v0}, Lcom/facebook/react/flat/FlatViewGroup;->unscheduleDrawable(Landroid/graphics/drawable/Drawable;)V

    .line 686
    :cond_0
    if-eqz p1, :cond_1

    .line 687
    invoke-virtual {p1, p0}, Landroid/graphics/drawable/Drawable;->setCallback(Landroid/graphics/drawable/Drawable$Callback;)V

    .line 688
    invoke-virtual {p1}, Landroid/graphics/drawable/Drawable;->isStateful()Z

    move-result v0

    if-eqz v0, :cond_1

    .line 689
    invoke-virtual {p0}, Lcom/facebook/react/flat/FlatViewGroup;->getDrawableState()[I

    move-result-object v0

    invoke-virtual {p1, v0}, Landroid/graphics/drawable/Drawable;->setState([I)Z

    .line 693
    :cond_1
    iput-object p1, p0, Lcom/facebook/react/flat/FlatViewGroup;->mHotspot:Landroid/graphics/drawable/Drawable;

    .line 694
    invoke-virtual {p0}, Lcom/facebook/react/flat/FlatViewGroup;->invalidate()V

    .line 695
    return-void
.end method

.method setNeedsOffscreenAlphaCompositing(Z)V
    .locals 0
    .param p1, "needsOffscreenAlphaCompositing"    # Z

    .prologue
    .line 677
    iput-boolean p1, p0, Lcom/facebook/react/flat/FlatViewGroup;->mNeedsOffscreenAlphaCompositing:Z

    .line 678
    return-void
.end method

.method public setOnInterceptTouchEventListener(Lcom/facebook/react/touch/OnInterceptTouchEventListener;)V
    .locals 0
    .param p1, "listener"    # Lcom/facebook/react/touch/OnInterceptTouchEventListener;

    .prologue
    .line 616
    iput-object p1, p0, Lcom/facebook/react/flat/FlatViewGroup;->mOnInterceptTouchEventListener:Lcom/facebook/react/touch/OnInterceptTouchEventListener;

    .line 617
    return-void
.end method

.method setPointerEvents(Lcom/facebook/react/uimanager/PointerEvents;)V
    .locals 0
    .param p1, "pointerEvents"    # Lcom/facebook/react/uimanager/PointerEvents;

    .prologue
    .line 670
    iput-object p1, p0, Lcom/facebook/react/flat/FlatViewGroup;->mPointerEvents:Lcom/facebook/react/uimanager/PointerEvents;

    .line 671
    return-void
.end method

.method public setRemoveClippedSubviews(Z)V
    .locals 3
    .param p1, "removeClippedSubviews"    # Z

    .prologue
    .line 1171
    invoke-virtual {p0}, Lcom/facebook/react/flat/FlatViewGroup;->getRemoveClippedSubviews()Z

    move-result v0

    .line 1172
    .local v0, "currentlyClipping":Z
    if-ne p1, v0, :cond_0

    .line 1187
    :goto_0
    return-void

    .line 1176
    :cond_0
    if-eqz v0, :cond_1

    .line 1180
    new-instance v1, Ljava/lang/RuntimeException;

    const-string v2, "Trying to transition FlatViewGroup from clipping to non-clipping state"

    invoke-direct {v1, v2}, Ljava/lang/RuntimeException;-><init>(Ljava/lang/String;)V

    throw v1

    .line 1183
    :cond_1
    iget-object v1, p0, Lcom/facebook/react/flat/FlatViewGroup;->mDrawCommands:[Lcom/facebook/react/flat/DrawCommand;

    invoke-static {p0, v1}, Lcom/facebook/react/flat/DrawCommandManager;->getVerticalClippingInstance(Lcom/facebook/react/flat/FlatViewGroup;[Lcom/facebook/react/flat/DrawCommand;)Lcom/facebook/react/flat/DrawCommandManager;

    move-result-object v1

    iput-object v1, p0, Lcom/facebook/react/flat/FlatViewGroup;->mDrawCommandManager:Lcom/facebook/react/flat/DrawCommandManager;

    .line 1184
    sget-object v1, Lcom/facebook/react/flat/DrawCommand;->EMPTY_ARRAY:[Lcom/facebook/react/flat/DrawCommand;

    iput-object v1, p0, Lcom/facebook/react/flat/FlatViewGroup;->mDrawCommands:[Lcom/facebook/react/flat/DrawCommand;

    goto :goto_0
.end method

.method public updateClippingRect()V
    .locals 1

    .prologue
    .line 1148
    iget-object v0, p0, Lcom/facebook/react/flat/FlatViewGroup;->mDrawCommandManager:Lcom/facebook/react/flat/DrawCommandManager;

    if-nez v0, :cond_1

    .line 1156
    :cond_0
    :goto_0
    return-void

    .line 1152
    :cond_1
    iget-object v0, p0, Lcom/facebook/react/flat/FlatViewGroup;->mDrawCommandManager:Lcom/facebook/react/flat/DrawCommandManager;

    invoke-virtual {v0}, Lcom/facebook/react/flat/DrawCommandManager;->updateClippingRect()Z

    move-result v0

    if-eqz v0, :cond_0

    .line 1154
    invoke-virtual {p0}, Lcom/facebook/react/flat/FlatViewGroup;->invalidate()V

    goto :goto_0
.end method

.method protected verifyDrawable(Landroid/graphics/drawable/Drawable;)Z
    .locals 1
    .param p1, "who"    # Landroid/graphics/drawable/Drawable;
    .annotation build Landroid/annotation/SuppressLint;
        value = {
            "MissingSuperCall"
        }
    .end annotation

    .prologue
    .line 524
    const/4 v0, 0x1

    return v0
.end method

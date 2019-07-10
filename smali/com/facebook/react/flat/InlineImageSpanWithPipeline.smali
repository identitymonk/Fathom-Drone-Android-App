.class final Lcom/facebook/react/flat/InlineImageSpanWithPipeline;
.super Landroid/text/style/ReplacementSpan;
.source "InlineImageSpanWithPipeline.java"

# interfaces
.implements Lcom/facebook/react/flat/AttachDetachListener;
.implements Lcom/facebook/react/flat/BitmapUpdateListener;


# static fields
.field private static final TMP_RECT:Landroid/graphics/RectF;


# instance fields
.field private mCallback:Lcom/facebook/react/flat/FlatViewGroup$InvalidateCallback;
    .annotation runtime Ljavax/annotation/Nullable;
    .end annotation
.end field

.field private mFrozen:Z

.field private mHeight:F

.field private mRequestHelper:Lcom/facebook/react/flat/PipelineRequestHelper;
    .annotation runtime Ljavax/annotation/Nullable;
    .end annotation
.end field

.field private mWidth:F


# direct methods
.method static constructor <clinit>()V
    .locals 1

    .prologue
    .line 26
    new-instance v0, Landroid/graphics/RectF;

    invoke-direct {v0}, Landroid/graphics/RectF;-><init>()V

    sput-object v0, Lcom/facebook/react/flat/InlineImageSpanWithPipeline;->TMP_RECT:Landroid/graphics/RectF;

    return-void
.end method

.method constructor <init>()V
    .locals 2

    .prologue
    const/high16 v1, 0x7fc00000    # Float.NaN

    .line 35
    const/4 v0, 0x0

    invoke-direct {p0, v0, v1, v1}, Lcom/facebook/react/flat/InlineImageSpanWithPipeline;-><init>(Lcom/facebook/react/flat/PipelineRequestHelper;FF)V

    .line 36
    return-void
.end method

.method private constructor <init>(Lcom/facebook/react/flat/PipelineRequestHelper;FF)V
    .locals 0
    .param p1, "requestHelper"    # Lcom/facebook/react/flat/PipelineRequestHelper;
        .annotation runtime Ljavax/annotation/Nullable;
        .end annotation
    .end param
    .param p2, "width"    # F
    .param p3, "height"    # F

    .prologue
    .line 41
    invoke-direct {p0}, Landroid/text/style/ReplacementSpan;-><init>()V

    .line 42
    iput-object p1, p0, Lcom/facebook/react/flat/InlineImageSpanWithPipeline;->mRequestHelper:Lcom/facebook/react/flat/PipelineRequestHelper;

    .line 43
    iput p2, p0, Lcom/facebook/react/flat/InlineImageSpanWithPipeline;->mWidth:F

    .line 44
    iput p3, p0, Lcom/facebook/react/flat/InlineImageSpanWithPipeline;->mHeight:F

    .line 45
    return-void
.end method


# virtual methods
.method public draw(Landroid/graphics/Canvas;Ljava/lang/CharSequence;IIFIIILandroid/graphics/Paint;)V
    .locals 5
    .param p1, "canvas"    # Landroid/graphics/Canvas;
    .param p2, "text"    # Ljava/lang/CharSequence;
    .param p3, "start"    # I
    .param p4, "end"    # I
    .param p5, "x"    # F
    .param p6, "top"    # I
    .param p7, "y"    # I
    .param p8, "bottom"    # I
    .param p9, "paint"    # Landroid/graphics/Paint;

    .prologue
    .line 152
    iget-object v2, p0, Lcom/facebook/react/flat/InlineImageSpanWithPipeline;->mRequestHelper:Lcom/facebook/react/flat/PipelineRequestHelper;

    if-nez v2, :cond_1

    .line 165
    :cond_0
    :goto_0
    return-void

    .line 156
    :cond_1
    iget-object v2, p0, Lcom/facebook/react/flat/InlineImageSpanWithPipeline;->mRequestHelper:Lcom/facebook/react/flat/PipelineRequestHelper;

    invoke-virtual {v2}, Lcom/facebook/react/flat/PipelineRequestHelper;->getBitmap()Landroid/graphics/Bitmap;

    move-result-object v0

    .line 157
    .local v0, "bitmap":Landroid/graphics/Bitmap;
    if-eqz v0, :cond_0

    .line 161
    int-to-float v2, p8

    invoke-virtual {p9}, Landroid/graphics/Paint;->getFontMetricsInt()Landroid/graphics/Paint$FontMetricsInt;

    move-result-object v3

    iget v3, v3, Landroid/graphics/Paint$FontMetricsInt;->descent:I

    int-to-float v3, v3

    sub-float v1, v2, v3

    .line 162
    .local v1, "bottomFloat":F
    sget-object v2, Lcom/facebook/react/flat/InlineImageSpanWithPipeline;->TMP_RECT:Landroid/graphics/RectF;

    iget v3, p0, Lcom/facebook/react/flat/InlineImageSpanWithPipeline;->mHeight:F

    sub-float v3, v1, v3

    iget v4, p0, Lcom/facebook/react/flat/InlineImageSpanWithPipeline;->mWidth:F

    add-float/2addr v4, p5

    invoke-virtual {v2, p5, v3, v4, v1}, Landroid/graphics/RectF;->set(FFFF)V

    .line 164
    const/4 v2, 0x0

    sget-object v3, Lcom/facebook/react/flat/InlineImageSpanWithPipeline;->TMP_RECT:Landroid/graphics/RectF;

    invoke-virtual {p1, v0, v2, v3, p9}, Landroid/graphics/Canvas;->drawBitmap(Landroid/graphics/Bitmap;Landroid/graphics/Rect;Landroid/graphics/RectF;Landroid/graphics/Paint;)V

    goto :goto_0
.end method

.method freeze()V
    .locals 1

    .prologue
    .line 83
    const/4 v0, 0x1

    iput-boolean v0, p0, Lcom/facebook/react/flat/InlineImageSpanWithPipeline;->mFrozen:Z

    .line 84
    return-void
.end method

.method getHeight()F
    .locals 1

    .prologue
    .line 75
    iget v0, p0, Lcom/facebook/react/flat/InlineImageSpanWithPipeline;->mHeight:F

    return v0
.end method

.method public getSize(Landroid/graphics/Paint;Ljava/lang/CharSequence;IILandroid/graphics/Paint$FontMetricsInt;)I
    .locals 2
    .param p1, "paint"    # Landroid/graphics/Paint;
    .param p2, "text"    # Ljava/lang/CharSequence;
    .param p3, "start"    # I
    .param p4, "end"    # I
    .param p5, "fm"    # Landroid/graphics/Paint$FontMetricsInt;

    .prologue
    const/4 v1, 0x0

    .line 130
    if-eqz p5, :cond_0

    .line 131
    iget v0, p0, Lcom/facebook/react/flat/InlineImageSpanWithPipeline;->mHeight:F

    invoke-static {v0}, Ljava/lang/Math;->round(F)I

    move-result v0

    neg-int v0, v0

    iput v0, p5, Landroid/graphics/Paint$FontMetricsInt;->ascent:I

    .line 132
    iput v1, p5, Landroid/graphics/Paint$FontMetricsInt;->descent:I

    .line 134
    iget v0, p5, Landroid/graphics/Paint$FontMetricsInt;->ascent:I

    iput v0, p5, Landroid/graphics/Paint$FontMetricsInt;->top:I

    .line 135
    iput v1, p5, Landroid/graphics/Paint$FontMetricsInt;->bottom:I

    .line 138
    :cond_0
    iget v0, p0, Lcom/facebook/react/flat/InlineImageSpanWithPipeline;->mWidth:F

    invoke-static {v0}, Ljava/lang/Math;->round(F)I

    move-result v0

    return v0
.end method

.method getWidth()F
    .locals 1

    .prologue
    .line 67
    iget v0, p0, Lcom/facebook/react/flat/InlineImageSpanWithPipeline;->mWidth:F

    return v0
.end method

.method hasImageRequest()Z
    .locals 1

    .prologue
    .line 52
    iget-object v0, p0, Lcom/facebook/react/flat/InlineImageSpanWithPipeline;->mRequestHelper:Lcom/facebook/react/flat/PipelineRequestHelper;

    if-eqz v0, :cond_0

    const/4 v0, 0x1

    :goto_0
    return v0

    :cond_0
    const/4 v0, 0x0

    goto :goto_0
.end method

.method isFrozen()Z
    .locals 1

    .prologue
    .line 87
    iget-boolean v0, p0, Lcom/facebook/react/flat/InlineImageSpanWithPipeline;->mFrozen:Z

    return v0
.end method

.method mutableCopy()Lcom/facebook/react/flat/InlineImageSpanWithPipeline;
    .locals 4

    .prologue
    .line 48
    new-instance v0, Lcom/facebook/react/flat/InlineImageSpanWithPipeline;

    iget-object v1, p0, Lcom/facebook/react/flat/InlineImageSpanWithPipeline;->mRequestHelper:Lcom/facebook/react/flat/PipelineRequestHelper;

    iget v2, p0, Lcom/facebook/react/flat/InlineImageSpanWithPipeline;->mWidth:F

    iget v3, p0, Lcom/facebook/react/flat/InlineImageSpanWithPipeline;->mHeight:F

    invoke-direct {v0, v1, v2, v3}, Lcom/facebook/react/flat/InlineImageSpanWithPipeline;-><init>(Lcom/facebook/react/flat/PipelineRequestHelper;FF)V

    return-object v0
.end method

.method public onAttached(Lcom/facebook/react/flat/FlatViewGroup$InvalidateCallback;)V
    .locals 1
    .param p1, "callback"    # Lcom/facebook/react/flat/FlatViewGroup$InvalidateCallback;

    .prologue
    .line 109
    iput-object p1, p0, Lcom/facebook/react/flat/InlineImageSpanWithPipeline;->mCallback:Lcom/facebook/react/flat/FlatViewGroup$InvalidateCallback;

    .line 111
    iget-object v0, p0, Lcom/facebook/react/flat/InlineImageSpanWithPipeline;->mRequestHelper:Lcom/facebook/react/flat/PipelineRequestHelper;

    if-eqz v0, :cond_0

    .line 112
    iget-object v0, p0, Lcom/facebook/react/flat/InlineImageSpanWithPipeline;->mRequestHelper:Lcom/facebook/react/flat/PipelineRequestHelper;

    invoke-virtual {v0, p0}, Lcom/facebook/react/flat/PipelineRequestHelper;->attach(Lcom/facebook/react/flat/BitmapUpdateListener;)V

    .line 114
    :cond_0
    return-void
.end method

.method public onBitmapReady(Landroid/graphics/Bitmap;)V
    .locals 1
    .param p1, "bitmap"    # Landroid/graphics/Bitmap;

    .prologue
    .line 99
    iget-object v0, p0, Lcom/facebook/react/flat/InlineImageSpanWithPipeline;->mCallback:Lcom/facebook/react/flat/FlatViewGroup$InvalidateCallback;

    invoke-static {v0}, Lcom/facebook/infer/annotation/Assertions;->assumeNotNull(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/facebook/react/flat/FlatViewGroup$InvalidateCallback;

    invoke-virtual {v0}, Lcom/facebook/react/flat/FlatViewGroup$InvalidateCallback;->invalidate()V

    .line 100
    return-void
.end method

.method public onDetached()V
    .locals 1

    .prologue
    .line 118
    iget-object v0, p0, Lcom/facebook/react/flat/InlineImageSpanWithPipeline;->mRequestHelper:Lcom/facebook/react/flat/PipelineRequestHelper;

    if-eqz v0, :cond_0

    .line 119
    iget-object v0, p0, Lcom/facebook/react/flat/InlineImageSpanWithPipeline;->mRequestHelper:Lcom/facebook/react/flat/PipelineRequestHelper;

    invoke-virtual {v0}, Lcom/facebook/react/flat/PipelineRequestHelper;->detach()V

    .line 121
    iget-object v0, p0, Lcom/facebook/react/flat/InlineImageSpanWithPipeline;->mRequestHelper:Lcom/facebook/react/flat/PipelineRequestHelper;

    invoke-virtual {v0}, Lcom/facebook/react/flat/PipelineRequestHelper;->isDetached()Z

    move-result v0

    if-eqz v0, :cond_0

    .line 123
    const/4 v0, 0x0

    iput-object v0, p0, Lcom/facebook/react/flat/InlineImageSpanWithPipeline;->mCallback:Lcom/facebook/react/flat/FlatViewGroup$InvalidateCallback;

    .line 126
    :cond_0
    return-void
.end method

.method public onImageLoadEvent(I)V
    .locals 0
    .param p1, "imageLoadEvent"    # I

    .prologue
    .line 105
    return-void
.end method

.method public onSecondaryAttach(Landroid/graphics/Bitmap;)V
    .locals 1
    .param p1, "bitmap"    # Landroid/graphics/Bitmap;

    .prologue
    .line 93
    iget-object v0, p0, Lcom/facebook/react/flat/InlineImageSpanWithPipeline;->mCallback:Lcom/facebook/react/flat/FlatViewGroup$InvalidateCallback;

    invoke-static {v0}, Lcom/facebook/infer/annotation/Assertions;->assumeNotNull(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/facebook/react/flat/FlatViewGroup$InvalidateCallback;

    invoke-virtual {v0}, Lcom/facebook/react/flat/FlatViewGroup$InvalidateCallback;->invalidate()V

    .line 94
    return-void
.end method

.method setHeight(F)V
    .locals 0
    .param p1, "height"    # F

    .prologue
    .line 79
    iput p1, p0, Lcom/facebook/react/flat/InlineImageSpanWithPipeline;->mHeight:F

    .line 80
    return-void
.end method

.method setImageRequest(Lcom/facebook/imagepipeline/request/ImageRequest;)V
    .locals 1
    .param p1, "imageRequest"    # Lcom/facebook/imagepipeline/request/ImageRequest;
        .annotation runtime Ljavax/annotation/Nullable;
        .end annotation
    .end param

    .prologue
    .line 59
    if-nez p1, :cond_0

    .line 60
    const/4 v0, 0x0

    iput-object v0, p0, Lcom/facebook/react/flat/InlineImageSpanWithPipeline;->mRequestHelper:Lcom/facebook/react/flat/PipelineRequestHelper;

    .line 64
    :goto_0
    return-void

    .line 62
    :cond_0
    new-instance v0, Lcom/facebook/react/flat/PipelineRequestHelper;

    invoke-direct {v0, p1}, Lcom/facebook/react/flat/PipelineRequestHelper;-><init>(Lcom/facebook/imagepipeline/request/ImageRequest;)V

    iput-object v0, p0, Lcom/facebook/react/flat/InlineImageSpanWithPipeline;->mRequestHelper:Lcom/facebook/react/flat/PipelineRequestHelper;

    goto :goto_0
.end method

.method setWidth(F)V
    .locals 0
    .param p1, "width"    # F

    .prologue
    .line 71
    iput p1, p0, Lcom/facebook/react/flat/InlineImageSpanWithPipeline;->mWidth:F

    .line 72
    return-void
.end method

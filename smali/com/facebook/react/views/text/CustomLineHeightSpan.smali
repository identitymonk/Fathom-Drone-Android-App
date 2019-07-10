.class public Lcom/facebook/react/views/text/CustomLineHeightSpan;
.super Ljava/lang/Object;
.source "CustomLineHeightSpan.java"

# interfaces
.implements Landroid/text/style/LineHeightSpan;


# instance fields
.field private final mHeight:I


# direct methods
.method constructor <init>(F)V
    .locals 2
    .param p1, "height"    # F

    .prologue
    .line 15
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 16
    float-to-double v0, p1

    invoke-static {v0, v1}, Ljava/lang/Math;->ceil(D)D

    move-result-wide v0

    double-to-int v0, v0

    iput v0, p0, Lcom/facebook/react/views/text/CustomLineHeightSpan;->mHeight:I

    .line 17
    return-void
.end method


# virtual methods
.method public chooseHeight(Ljava/lang/CharSequence;IIIILandroid/graphics/Paint$FontMetricsInt;)V
    .locals 4
    .param p1, "text"    # Ljava/lang/CharSequence;
    .param p2, "start"    # I
    .param p3, "end"    # I
    .param p4, "spanstartv"    # I
    .param p5, "v"    # I
    .param p6, "fm"    # Landroid/graphics/Paint$FontMetricsInt;

    .prologue
    .line 32
    iget v1, p6, Landroid/graphics/Paint$FontMetricsInt;->ascent:I

    neg-int v1, v1

    iget v2, p0, Lcom/facebook/react/views/text/CustomLineHeightSpan;->mHeight:I

    if-le v1, v2, :cond_0

    .line 34
    iget v1, p0, Lcom/facebook/react/views/text/CustomLineHeightSpan;->mHeight:I

    neg-int v1, v1

    iput v1, p6, Landroid/graphics/Paint$FontMetricsInt;->ascent:I

    iput v1, p6, Landroid/graphics/Paint$FontMetricsInt;->top:I

    .line 35
    const/4 v1, 0x0

    iput v1, p6, Landroid/graphics/Paint$FontMetricsInt;->descent:I

    iput v1, p6, Landroid/graphics/Paint$FontMetricsInt;->bottom:I

    .line 53
    :goto_0
    return-void

    .line 36
    :cond_0
    iget v1, p6, Landroid/graphics/Paint$FontMetricsInt;->ascent:I

    neg-int v1, v1

    iget v2, p6, Landroid/graphics/Paint$FontMetricsInt;->descent:I

    add-int/2addr v1, v2

    iget v2, p0, Lcom/facebook/react/views/text/CustomLineHeightSpan;->mHeight:I

    if-le v1, v2, :cond_1

    .line 38
    iget v1, p6, Landroid/graphics/Paint$FontMetricsInt;->ascent:I

    iput v1, p6, Landroid/graphics/Paint$FontMetricsInt;->top:I

    .line 39
    iget v1, p0, Lcom/facebook/react/views/text/CustomLineHeightSpan;->mHeight:I

    iget v2, p6, Landroid/graphics/Paint$FontMetricsInt;->ascent:I

    add-int/2addr v1, v2

    iput v1, p6, Landroid/graphics/Paint$FontMetricsInt;->descent:I

    iput v1, p6, Landroid/graphics/Paint$FontMetricsInt;->bottom:I

    goto :goto_0

    .line 40
    :cond_1
    iget v1, p6, Landroid/graphics/Paint$FontMetricsInt;->ascent:I

    neg-int v1, v1

    iget v2, p6, Landroid/graphics/Paint$FontMetricsInt;->bottom:I

    add-int/2addr v1, v2

    iget v2, p0, Lcom/facebook/react/views/text/CustomLineHeightSpan;->mHeight:I

    if-le v1, v2, :cond_2

    .line 42
    iget v1, p6, Landroid/graphics/Paint$FontMetricsInt;->ascent:I

    iput v1, p6, Landroid/graphics/Paint$FontMetricsInt;->top:I

    .line 43
    iget v1, p6, Landroid/graphics/Paint$FontMetricsInt;->ascent:I

    iget v2, p0, Lcom/facebook/react/views/text/CustomLineHeightSpan;->mHeight:I

    add-int/2addr v1, v2

    iput v1, p6, Landroid/graphics/Paint$FontMetricsInt;->bottom:I

    goto :goto_0

    .line 44
    :cond_2
    iget v1, p6, Landroid/graphics/Paint$FontMetricsInt;->top:I

    neg-int v1, v1

    iget v2, p6, Landroid/graphics/Paint$FontMetricsInt;->bottom:I

    add-int/2addr v1, v2

    iget v2, p0, Lcom/facebook/react/views/text/CustomLineHeightSpan;->mHeight:I

    if-le v1, v2, :cond_3

    .line 46
    iget v1, p6, Landroid/graphics/Paint$FontMetricsInt;->bottom:I

    iget v2, p0, Lcom/facebook/react/views/text/CustomLineHeightSpan;->mHeight:I

    sub-int/2addr v1, v2

    iput v1, p6, Landroid/graphics/Paint$FontMetricsInt;->top:I

    goto :goto_0

    .line 49
    :cond_3
    iget v1, p0, Lcom/facebook/react/views/text/CustomLineHeightSpan;->mHeight:I

    iget v2, p6, Landroid/graphics/Paint$FontMetricsInt;->top:I

    neg-int v2, v2

    iget v3, p6, Landroid/graphics/Paint$FontMetricsInt;->bottom:I

    add-int/2addr v2, v3

    sub-int v0, v1, v2

    .line 50
    .local v0, "additional":I
    iget v1, p6, Landroid/graphics/Paint$FontMetricsInt;->top:I

    sub-int/2addr v1, v0

    iput v1, p6, Landroid/graphics/Paint$FontMetricsInt;->top:I

    .line 51
    iget v1, p6, Landroid/graphics/Paint$FontMetricsInt;->ascent:I

    sub-int/2addr v1, v0

    iput v1, p6, Landroid/graphics/Paint$FontMetricsInt;->ascent:I

    goto :goto_0
.end method

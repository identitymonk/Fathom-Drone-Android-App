.class Lcom/facebook/react/views/image/ReactImageView$RoundedCornerPostprocessor;
.super Lcom/facebook/imagepipeline/request/BasePostprocessor;
.source "ReactImageView.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/facebook/react/views/image/ReactImageView;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x2
    name = "RoundedCornerPostprocessor"
.end annotation


# instance fields
.field final synthetic this$0:Lcom/facebook/react/views/image/ReactImageView;


# direct methods
.method private constructor <init>(Lcom/facebook/react/views/image/ReactImageView;)V
    .locals 0

    .prologue
    .line 89
    iput-object p1, p0, Lcom/facebook/react/views/image/ReactImageView$RoundedCornerPostprocessor;->this$0:Lcom/facebook/react/views/image/ReactImageView;

    invoke-direct {p0}, Lcom/facebook/imagepipeline/request/BasePostprocessor;-><init>()V

    return-void
.end method

.method synthetic constructor <init>(Lcom/facebook/react/views/image/ReactImageView;Lcom/facebook/react/views/image/ReactImageView$1;)V
    .locals 0
    .param p1, "x0"    # Lcom/facebook/react/views/image/ReactImageView;
    .param p2, "x1"    # Lcom/facebook/react/views/image/ReactImageView$1;

    .prologue
    .line 89
    invoke-direct {p0, p1}, Lcom/facebook/react/views/image/ReactImageView$RoundedCornerPostprocessor;-><init>(Lcom/facebook/react/views/image/ReactImageView;)V

    return-void
.end method


# virtual methods
.method getRadii(Landroid/graphics/Bitmap;[F[F)V
    .locals 11
    .param p1, "source"    # Landroid/graphics/Bitmap;
    .param p2, "computedCornerRadii"    # [F
    .param p3, "mappedRadii"    # [F

    .prologue
    const/4 v10, 0x3

    const/4 v9, 0x1

    const/4 v5, 0x0

    const/4 v8, 0x2

    const/4 v7, 0x0

    .line 92
    iget-object v0, p0, Lcom/facebook/react/views/image/ReactImageView$RoundedCornerPostprocessor;->this$0:Lcom/facebook/react/views/image/ReactImageView;

    invoke-static {v0}, Lcom/facebook/react/views/image/ReactImageView;->access$100(Lcom/facebook/react/views/image/ReactImageView;)Lcom/facebook/drawee/drawable/ScalingUtils$ScaleType;

    move-result-object v0

    .line 93
    invoke-static {}, Lcom/facebook/react/views/image/ReactImageView;->access$000()Landroid/graphics/Matrix;

    move-result-object v1

    new-instance v2, Landroid/graphics/Rect;

    .line 94
    invoke-virtual {p1}, Landroid/graphics/Bitmap;->getWidth()I

    move-result v3

    invoke-virtual {p1}, Landroid/graphics/Bitmap;->getHeight()I

    move-result v4

    invoke-direct {v2, v7, v7, v3, v4}, Landroid/graphics/Rect;-><init>(IIII)V

    .line 95
    invoke-virtual {p1}, Landroid/graphics/Bitmap;->getWidth()I

    move-result v3

    .line 96
    invoke-virtual {p1}, Landroid/graphics/Bitmap;->getHeight()I

    move-result v4

    move v6, v5

    .line 92
    invoke-interface/range {v0 .. v6}, Lcom/facebook/drawee/drawable/ScalingUtils$ScaleType;->getTransform(Landroid/graphics/Matrix;Landroid/graphics/Rect;IIFF)Landroid/graphics/Matrix;

    .line 99
    invoke-static {}, Lcom/facebook/react/views/image/ReactImageView;->access$000()Landroid/graphics/Matrix;

    move-result-object v0

    invoke-static {}, Lcom/facebook/react/views/image/ReactImageView;->access$200()Landroid/graphics/Matrix;

    move-result-object v1

    invoke-virtual {v0, v1}, Landroid/graphics/Matrix;->invert(Landroid/graphics/Matrix;)Z

    .line 101
    invoke-static {}, Lcom/facebook/react/views/image/ReactImageView;->access$200()Landroid/graphics/Matrix;

    move-result-object v0

    aget v1, p2, v7

    invoke-virtual {v0, v1}, Landroid/graphics/Matrix;->mapRadius(F)F

    move-result v0

    aput v0, p3, v7

    .line 102
    aget v0, p3, v7

    aput v0, p3, v9

    .line 104
    invoke-static {}, Lcom/facebook/react/views/image/ReactImageView;->access$200()Landroid/graphics/Matrix;

    move-result-object v0

    aget v1, p2, v9

    invoke-virtual {v0, v1}, Landroid/graphics/Matrix;->mapRadius(F)F

    move-result v0

    aput v0, p3, v8

    .line 105
    aget v0, p3, v8

    aput v0, p3, v10

    .line 107
    const/4 v0, 0x4

    invoke-static {}, Lcom/facebook/react/views/image/ReactImageView;->access$200()Landroid/graphics/Matrix;

    move-result-object v1

    aget v2, p2, v8

    invoke-virtual {v1, v2}, Landroid/graphics/Matrix;->mapRadius(F)F

    move-result v1

    aput v1, p3, v0

    .line 108
    const/4 v0, 0x5

    const/4 v1, 0x4

    aget v1, p3, v1

    aput v1, p3, v0

    .line 110
    const/4 v0, 0x6

    invoke-static {}, Lcom/facebook/react/views/image/ReactImageView;->access$200()Landroid/graphics/Matrix;

    move-result-object v1

    aget v2, p2, v10

    invoke-virtual {v1, v2}, Landroid/graphics/Matrix;->mapRadius(F)F

    move-result v1

    aput v1, p3, v0

    .line 111
    const/4 v0, 0x7

    const/4 v1, 0x6

    aget v1, p3, v1

    aput v1, p3, v0

    .line 112
    return-void
.end method

.method public process(Landroid/graphics/Bitmap;Landroid/graphics/Bitmap;)V
    .locals 8
    .param p1, "output"    # Landroid/graphics/Bitmap;
    .param p2, "source"    # Landroid/graphics/Bitmap;

    .prologue
    const/4 v6, 0x1

    const/4 v7, 0x0

    .line 116
    iget-object v4, p0, Lcom/facebook/react/views/image/ReactImageView$RoundedCornerPostprocessor;->this$0:Lcom/facebook/react/views/image/ReactImageView;

    invoke-static {}, Lcom/facebook/react/views/image/ReactImageView;->access$300()[F

    move-result-object v5

    invoke-static {v4, v5}, Lcom/facebook/react/views/image/ReactImageView;->access$400(Lcom/facebook/react/views/image/ReactImageView;[F)V

    .line 118
    invoke-virtual {p1, v6}, Landroid/graphics/Bitmap;->setHasAlpha(Z)V

    .line 119
    invoke-static {}, Lcom/facebook/react/views/image/ReactImageView;->access$300()[F

    move-result-object v4

    const/4 v5, 0x0

    aget v4, v4, v5

    invoke-static {v4, v7}, Lcom/facebook/react/uimanager/FloatUtil;->floatsEqual(FF)Z

    move-result v4

    if-eqz v4, :cond_0

    .line 120
    invoke-static {}, Lcom/facebook/react/views/image/ReactImageView;->access$300()[F

    move-result-object v4

    aget v4, v4, v6

    invoke-static {v4, v7}, Lcom/facebook/react/uimanager/FloatUtil;->floatsEqual(FF)Z

    move-result v4

    if-eqz v4, :cond_0

    .line 121
    invoke-static {}, Lcom/facebook/react/views/image/ReactImageView;->access$300()[F

    move-result-object v4

    const/4 v5, 0x2

    aget v4, v4, v5

    invoke-static {v4, v7}, Lcom/facebook/react/uimanager/FloatUtil;->floatsEqual(FF)Z

    move-result v4

    if-eqz v4, :cond_0

    .line 122
    invoke-static {}, Lcom/facebook/react/views/image/ReactImageView;->access$300()[F

    move-result-object v4

    const/4 v5, 0x3

    aget v4, v4, v5

    invoke-static {v4, v7}, Lcom/facebook/react/uimanager/FloatUtil;->floatsEqual(FF)Z

    move-result v4

    if-eqz v4, :cond_0

    .line 123
    invoke-super {p0, p1, p2}, Lcom/facebook/imagepipeline/request/BasePostprocessor;->process(Landroid/graphics/Bitmap;Landroid/graphics/Bitmap;)V

    .line 143
    :goto_0
    return-void

    .line 126
    :cond_0
    new-instance v1, Landroid/graphics/Paint;

    invoke-direct {v1}, Landroid/graphics/Paint;-><init>()V

    .line 127
    .local v1, "paint":Landroid/graphics/Paint;
    invoke-virtual {v1, v6}, Landroid/graphics/Paint;->setAntiAlias(Z)V

    .line 128
    new-instance v4, Landroid/graphics/BitmapShader;

    sget-object v5, Landroid/graphics/Shader$TileMode;->CLAMP:Landroid/graphics/Shader$TileMode;

    sget-object v6, Landroid/graphics/Shader$TileMode;->CLAMP:Landroid/graphics/Shader$TileMode;

    invoke-direct {v4, p2, v5, v6}, Landroid/graphics/BitmapShader;-><init>(Landroid/graphics/Bitmap;Landroid/graphics/Shader$TileMode;Landroid/graphics/Shader$TileMode;)V

    invoke-virtual {v1, v4}, Landroid/graphics/Paint;->setShader(Landroid/graphics/Shader;)Landroid/graphics/Shader;

    .line 129
    new-instance v0, Landroid/graphics/Canvas;

    invoke-direct {v0, p1}, Landroid/graphics/Canvas;-><init>(Landroid/graphics/Bitmap;)V

    .line 131
    .local v0, "canvas":Landroid/graphics/Canvas;
    const/16 v4, 0x8

    new-array v3, v4, [F

    .line 133
    .local v3, "radii":[F
    invoke-static {}, Lcom/facebook/react/views/image/ReactImageView;->access$300()[F

    move-result-object v4

    invoke-virtual {p0, p2, v4, v3}, Lcom/facebook/react/views/image/ReactImageView$RoundedCornerPostprocessor;->getRadii(Landroid/graphics/Bitmap;[F[F)V

    .line 135
    new-instance v2, Landroid/graphics/Path;

    invoke-direct {v2}, Landroid/graphics/Path;-><init>()V

    .line 137
    .local v2, "pathForBorderRadius":Landroid/graphics/Path;
    new-instance v4, Landroid/graphics/RectF;

    .line 138
    invoke-virtual {p2}, Landroid/graphics/Bitmap;->getWidth()I

    move-result v5

    int-to-float v5, v5

    invoke-virtual {p2}, Landroid/graphics/Bitmap;->getHeight()I

    move-result v6

    int-to-float v6, v6

    invoke-direct {v4, v7, v7, v5, v6}, Landroid/graphics/RectF;-><init>(FFFF)V

    sget-object v5, Landroid/graphics/Path$Direction;->CW:Landroid/graphics/Path$Direction;

    .line 137
    invoke-virtual {v2, v4, v3, v5}, Landroid/graphics/Path;->addRoundRect(Landroid/graphics/RectF;[FLandroid/graphics/Path$Direction;)V

    .line 142
    invoke-virtual {v0, v2, v1}, Landroid/graphics/Canvas;->drawPath(Landroid/graphics/Path;Landroid/graphics/Paint;)V

    goto :goto_0
.end method

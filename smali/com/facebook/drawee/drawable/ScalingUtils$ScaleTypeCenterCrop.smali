.class Lcom/facebook/drawee/drawable/ScalingUtils$ScaleTypeCenterCrop;
.super Lcom/facebook/drawee/drawable/ScalingUtils$AbstractScaleType;
.source "ScalingUtils.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/facebook/drawee/drawable/ScalingUtils;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0xa
    name = "ScaleTypeCenterCrop"
.end annotation


# static fields
.field public static final INSTANCE:Lcom/facebook/drawee/drawable/ScalingUtils$ScaleType;


# direct methods
.method static constructor <clinit>()V
    .locals 1

    .prologue
    .line 324
    new-instance v0, Lcom/facebook/drawee/drawable/ScalingUtils$ScaleTypeCenterCrop;

    invoke-direct {v0}, Lcom/facebook/drawee/drawable/ScalingUtils$ScaleTypeCenterCrop;-><init>()V

    sput-object v0, Lcom/facebook/drawee/drawable/ScalingUtils$ScaleTypeCenterCrop;->INSTANCE:Lcom/facebook/drawee/drawable/ScalingUtils$ScaleType;

    return-void
.end method

.method private constructor <init>()V
    .locals 0

    .prologue
    .line 322
    invoke-direct {p0}, Lcom/facebook/drawee/drawable/ScalingUtils$AbstractScaleType;-><init>()V

    return-void
.end method


# virtual methods
.method public getTransformImpl(Landroid/graphics/Matrix;Landroid/graphics/Rect;IIFFFF)V
    .locals 7
    .param p1, "outTransform"    # Landroid/graphics/Matrix;
    .param p2, "parentRect"    # Landroid/graphics/Rect;
    .param p3, "childWidth"    # I
    .param p4, "childHeight"    # I
    .param p5, "focusX"    # F
    .param p6, "focusY"    # F
    .param p7, "scaleX"    # F
    .param p8, "scaleY"    # F

    .prologue
    const/high16 v6, 0x3f000000    # 0.5f

    .line 337
    cmpl-float v3, p8, p7

    if-lez v3, :cond_0

    .line 338
    move v2, p8

    .line 339
    .local v2, "scale":F
    iget v3, p2, Landroid/graphics/Rect;->left:I

    int-to-float v3, v3

    invoke-virtual {p2}, Landroid/graphics/Rect;->width()I

    move-result v4

    int-to-float v4, v4

    int-to-float v5, p3

    mul-float/2addr v5, v2

    sub-float/2addr v4, v5

    mul-float/2addr v4, v6

    add-float v0, v3, v4

    .line 340
    .local v0, "dx":F
    iget v3, p2, Landroid/graphics/Rect;->top:I

    int-to-float v1, v3

    .line 346
    .local v1, "dy":F
    :goto_0
    invoke-virtual {p1, v2, v2}, Landroid/graphics/Matrix;->setScale(FF)V

    .line 347
    add-float v3, v0, v6

    float-to-int v3, v3

    int-to-float v3, v3

    add-float v4, v1, v6

    float-to-int v4, v4

    int-to-float v4, v4

    invoke-virtual {p1, v3, v4}, Landroid/graphics/Matrix;->postTranslate(FF)Z

    .line 348
    return-void

    .line 342
    .end local v0    # "dx":F
    .end local v1    # "dy":F
    .end local v2    # "scale":F
    :cond_0
    move v2, p7

    .line 343
    .restart local v2    # "scale":F
    iget v3, p2, Landroid/graphics/Rect;->left:I

    int-to-float v0, v3

    .line 344
    .restart local v0    # "dx":F
    iget v3, p2, Landroid/graphics/Rect;->top:I

    int-to-float v3, v3

    invoke-virtual {p2}, Landroid/graphics/Rect;->height()I

    move-result v4

    int-to-float v4, v4

    int-to-float v5, p4

    mul-float/2addr v5, v2

    sub-float/2addr v4, v5

    mul-float/2addr v4, v6

    add-float v1, v3, v4

    .restart local v1    # "dy":F
    goto :goto_0
.end method

.method public toString()Ljava/lang/String;
    .locals 1

    .prologue
    .line 352
    const-string v0, "center_crop"

    return-object v0
.end method

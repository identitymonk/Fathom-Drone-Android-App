.class Lcom/facebook/drawee/drawable/ScalingUtils$ScaleTypeFitEnd;
.super Lcom/facebook/drawee/drawable/ScalingUtils$AbstractScaleType;
.source "ScalingUtils.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/facebook/drawee/drawable/ScalingUtils;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0xa
    name = "ScaleTypeFitEnd"
.end annotation


# static fields
.field public static final INSTANCE:Lcom/facebook/drawee/drawable/ScalingUtils$ScaleType;


# direct methods
.method static constructor <clinit>()V
    .locals 1

    .prologue
    .line 245
    new-instance v0, Lcom/facebook/drawee/drawable/ScalingUtils$ScaleTypeFitEnd;

    invoke-direct {v0}, Lcom/facebook/drawee/drawable/ScalingUtils$ScaleTypeFitEnd;-><init>()V

    sput-object v0, Lcom/facebook/drawee/drawable/ScalingUtils$ScaleTypeFitEnd;->INSTANCE:Lcom/facebook/drawee/drawable/ScalingUtils$ScaleType;

    return-void
.end method

.method private constructor <init>()V
    .locals 0

    .prologue
    .line 243
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

    .line 257
    invoke-static {p7, p8}, Ljava/lang/Math;->min(FF)F

    move-result v2

    .line 258
    .local v2, "scale":F
    iget v3, p2, Landroid/graphics/Rect;->left:I

    int-to-float v3, v3

    invoke-virtual {p2}, Landroid/graphics/Rect;->width()I

    move-result v4

    int-to-float v4, v4

    int-to-float v5, p3

    mul-float/2addr v5, v2

    sub-float/2addr v4, v5

    add-float v0, v3, v4

    .line 259
    .local v0, "dx":F
    iget v3, p2, Landroid/graphics/Rect;->top:I

    int-to-float v3, v3

    invoke-virtual {p2}, Landroid/graphics/Rect;->height()I

    move-result v4

    int-to-float v4, v4

    int-to-float v5, p4

    mul-float/2addr v5, v2

    sub-float/2addr v4, v5

    add-float v1, v3, v4

    .line 260
    .local v1, "dy":F
    invoke-virtual {p1, v2, v2}, Landroid/graphics/Matrix;->setScale(FF)V

    .line 261
    add-float v3, v0, v6

    float-to-int v3, v3

    int-to-float v3, v3

    add-float v4, v1, v6

    float-to-int v4, v4

    int-to-float v4, v4

    invoke-virtual {p1, v3, v4}, Landroid/graphics/Matrix;->postTranslate(FF)Z

    .line 262
    return-void
.end method

.method public toString()Ljava/lang/String;
    .locals 1

    .prologue
    .line 266
    const-string v0, "fit_end"

    return-object v0
.end method

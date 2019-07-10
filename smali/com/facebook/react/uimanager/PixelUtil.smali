.class public Lcom/facebook/react/uimanager/PixelUtil;
.super Ljava/lang/Object;
.source "PixelUtil.java"


# direct methods
.method public constructor <init>()V
    .locals 0

    .prologue
    .line 17
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method

.method public static toDIPFromPixel(F)F
    .locals 1
    .param p0, "value"    # F

    .prologue
    .line 57
    invoke-static {}, Lcom/facebook/react/uimanager/DisplayMetricsHolder;->getWindowDisplayMetrics()Landroid/util/DisplayMetrics;

    move-result-object v0

    iget v0, v0, Landroid/util/DisplayMetrics;->density:F

    div-float v0, p0, v0

    return v0
.end method

.method public static toPixelFromDIP(D)F
    .locals 2
    .param p0, "value"    # D

    .prologue
    .line 33
    double-to-float v0, p0

    invoke-static {v0}, Lcom/facebook/react/uimanager/PixelUtil;->toPixelFromDIP(F)F

    move-result v0

    return v0
.end method

.method public static toPixelFromDIP(F)F
    .locals 2
    .param p0, "value"    # F

    .prologue
    .line 23
    const/4 v0, 0x1

    .line 26
    invoke-static {}, Lcom/facebook/react/uimanager/DisplayMetricsHolder;->getWindowDisplayMetrics()Landroid/util/DisplayMetrics;

    move-result-object v1

    .line 23
    invoke-static {v0, p0, v1}, Landroid/util/TypedValue;->applyDimension(IFLandroid/util/DisplayMetrics;)F

    move-result v0

    return v0
.end method

.method public static toPixelFromSP(D)F
    .locals 2
    .param p0, "value"    # D

    .prologue
    .line 50
    double-to-float v0, p0

    invoke-static {v0}, Lcom/facebook/react/uimanager/PixelUtil;->toPixelFromSP(F)F

    move-result v0

    return v0
.end method

.method public static toPixelFromSP(F)F
    .locals 2
    .param p0, "value"    # F

    .prologue
    .line 40
    const/4 v0, 0x2

    .line 43
    invoke-static {}, Lcom/facebook/react/uimanager/DisplayMetricsHolder;->getWindowDisplayMetrics()Landroid/util/DisplayMetrics;

    move-result-object v1

    .line 40
    invoke-static {v0, p0, v1}, Landroid/util/TypedValue;->applyDimension(IFLandroid/util/DisplayMetrics;)F

    move-result v0

    return v0
.end method

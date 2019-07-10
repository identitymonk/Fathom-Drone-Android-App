.class public Lcom/facebook/drawee/drawable/ScalingUtils;
.super Ljava/lang/Object;
.source "ScalingUtils.java"


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lcom/facebook/drawee/drawable/ScalingUtils$InterpolatingScaleType;,
        Lcom/facebook/drawee/drawable/ScalingUtils$StatefulScaleType;,
        Lcom/facebook/drawee/drawable/ScalingUtils$ScaleTypeFocusCrop;,
        Lcom/facebook/drawee/drawable/ScalingUtils$ScaleTypeCenterCrop;,
        Lcom/facebook/drawee/drawable/ScalingUtils$ScaleTypeCenterInside;,
        Lcom/facebook/drawee/drawable/ScalingUtils$ScaleTypeCenter;,
        Lcom/facebook/drawee/drawable/ScalingUtils$ScaleTypeFitEnd;,
        Lcom/facebook/drawee/drawable/ScalingUtils$ScaleTypeFitCenter;,
        Lcom/facebook/drawee/drawable/ScalingUtils$ScaleTypeFitStart;,
        Lcom/facebook/drawee/drawable/ScalingUtils$ScaleTypeFitXY;,
        Lcom/facebook/drawee/drawable/ScalingUtils$AbstractScaleType;,
        Lcom/facebook/drawee/drawable/ScalingUtils$ScaleType;
    }
.end annotation


# direct methods
.method public constructor <init>()V
    .locals 0

    .prologue
    .line 21
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method

.method public static getActiveScaleTypeDrawable(Landroid/graphics/drawable/Drawable;)Lcom/facebook/drawee/drawable/ScaleTypeDrawable;
    .locals 7
    .param p0, "drawable"    # Landroid/graphics/drawable/Drawable;
    .annotation runtime Ljavax/annotation/Nullable;
    .end annotation

    .prologue
    const/4 v5, 0x0

    .line 111
    if-nez p0, :cond_0

    move-object p0, v5

    .line 130
    .end local p0    # "drawable":Landroid/graphics/drawable/Drawable;
    .local v0, "childDrawable":Landroid/graphics/drawable/Drawable;
    .local v1, "fadeDrawable":Lcom/facebook/drawee/drawable/ArrayDrawable;
    .local v2, "i":I
    .local v3, "numLayers":I
    .local v4, "result":Lcom/facebook/drawee/drawable/ScaleTypeDrawable;
    :goto_0
    return-object p0

    .line 113
    .end local v0    # "childDrawable":Landroid/graphics/drawable/Drawable;
    .end local v1    # "fadeDrawable":Lcom/facebook/drawee/drawable/ArrayDrawable;
    .end local v2    # "i":I
    .end local v3    # "numLayers":I
    .end local v4    # "result":Lcom/facebook/drawee/drawable/ScaleTypeDrawable;
    .restart local p0    # "drawable":Landroid/graphics/drawable/Drawable;
    :cond_0
    instance-of v6, p0, Lcom/facebook/drawee/drawable/ScaleTypeDrawable;

    if-eqz v6, :cond_1

    .line 114
    check-cast p0, Lcom/facebook/drawee/drawable/ScaleTypeDrawable;

    goto :goto_0

    .line 115
    :cond_1
    instance-of v6, p0, Lcom/facebook/drawee/drawable/DrawableParent;

    if-eqz v6, :cond_2

    .line 116
    check-cast p0, Lcom/facebook/drawee/drawable/DrawableParent;

    .end local p0    # "drawable":Landroid/graphics/drawable/Drawable;
    invoke-interface {p0}, Lcom/facebook/drawee/drawable/DrawableParent;->getDrawable()Landroid/graphics/drawable/Drawable;

    move-result-object v0

    .line 117
    .restart local v0    # "childDrawable":Landroid/graphics/drawable/Drawable;
    invoke-static {v0}, Lcom/facebook/drawee/drawable/ScalingUtils;->getActiveScaleTypeDrawable(Landroid/graphics/drawable/Drawable;)Lcom/facebook/drawee/drawable/ScaleTypeDrawable;

    move-result-object p0

    goto :goto_0

    .line 118
    .end local v0    # "childDrawable":Landroid/graphics/drawable/Drawable;
    .restart local p0    # "drawable":Landroid/graphics/drawable/Drawable;
    :cond_2
    instance-of v6, p0, Lcom/facebook/drawee/drawable/ArrayDrawable;

    if-eqz v6, :cond_4

    move-object v1, p0

    .line 119
    check-cast v1, Lcom/facebook/drawee/drawable/ArrayDrawable;

    .line 120
    .restart local v1    # "fadeDrawable":Lcom/facebook/drawee/drawable/ArrayDrawable;
    invoke-virtual {v1}, Lcom/facebook/drawee/drawable/ArrayDrawable;->getNumberOfLayers()I

    move-result v3

    .line 122
    .restart local v3    # "numLayers":I
    const/4 v2, 0x0

    .restart local v2    # "i":I
    :goto_1
    if-ge v2, v3, :cond_4

    .line 123
    invoke-virtual {v1, v2}, Lcom/facebook/drawee/drawable/ArrayDrawable;->getDrawable(I)Landroid/graphics/drawable/Drawable;

    move-result-object v0

    .line 124
    .restart local v0    # "childDrawable":Landroid/graphics/drawable/Drawable;
    invoke-static {v0}, Lcom/facebook/drawee/drawable/ScalingUtils;->getActiveScaleTypeDrawable(Landroid/graphics/drawable/Drawable;)Lcom/facebook/drawee/drawable/ScaleTypeDrawable;

    move-result-object v4

    .line 125
    .restart local v4    # "result":Lcom/facebook/drawee/drawable/ScaleTypeDrawable;
    if-eqz v4, :cond_3

    move-object p0, v4

    .line 126
    goto :goto_0

    .line 122
    :cond_3
    add-int/lit8 v2, v2, 0x1

    goto :goto_1

    .end local v0    # "childDrawable":Landroid/graphics/drawable/Drawable;
    .end local v1    # "fadeDrawable":Lcom/facebook/drawee/drawable/ArrayDrawable;
    .end local v2    # "i":I
    .end local v3    # "numLayers":I
    .end local v4    # "result":Lcom/facebook/drawee/drawable/ScaleTypeDrawable;
    :cond_4
    move-object p0, v5

    .line 130
    goto :goto_0
.end method

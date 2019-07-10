.class Lcom/facebook/fbui/textlayoutbuilder/TextLayoutBuilder$ComparableTextPaint;
.super Landroid/text/TextPaint;
.source "TextLayoutBuilder.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/facebook/fbui/textlayoutbuilder/TextLayoutBuilder;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0xa
    name = "ComparableTextPaint"
.end annotation


# instance fields
.field private mShadowColor:I

.field private mShadowDx:F

.field private mShadowDy:F

.field private mShadowRadius:F


# direct methods
.method public constructor <init>()V
    .locals 0

    .prologue
    .line 763
    invoke-direct {p0}, Landroid/text/TextPaint;-><init>()V

    .line 764
    return-void
.end method

.method public constructor <init>(I)V
    .locals 0
    .param p1, "flags"    # I

    .prologue
    .line 767
    invoke-direct {p0, p1}, Landroid/text/TextPaint;-><init>(I)V

    .line 768
    return-void
.end method

.method public constructor <init>(Landroid/graphics/Paint;)V
    .locals 0
    .param p1, "p"    # Landroid/graphics/Paint;

    .prologue
    .line 771
    invoke-direct {p0, p1}, Landroid/text/TextPaint;-><init>(Landroid/graphics/Paint;)V

    .line 772
    return-void
.end method


# virtual methods
.method public hashCode()I
    .locals 5

    .prologue
    .line 786
    invoke-virtual {p0}, Lcom/facebook/fbui/textlayoutbuilder/TextLayoutBuilder$ComparableTextPaint;->getTypeface()Landroid/graphics/Typeface;

    move-result-object v2

    .line 788
    .local v2, "tf":Landroid/graphics/Typeface;
    const/4 v0, 0x1

    .line 789
    .local v0, "hashCode":I
    invoke-virtual {p0}, Lcom/facebook/fbui/textlayoutbuilder/TextLayoutBuilder$ComparableTextPaint;->getColor()I

    move-result v3

    add-int/lit8 v0, v3, 0x1f

    .line 790
    mul-int/lit8 v3, v0, 0x1f

    invoke-virtual {p0}, Lcom/facebook/fbui/textlayoutbuilder/TextLayoutBuilder$ComparableTextPaint;->getTextSize()F

    move-result v4

    invoke-static {v4}, Ljava/lang/Float;->floatToIntBits(F)I

    move-result v4

    add-int v0, v3, v4

    .line 791
    mul-int/lit8 v4, v0, 0x1f

    if-eqz v2, :cond_1

    invoke-virtual {v2}, Landroid/graphics/Typeface;->hashCode()I

    move-result v3

    :goto_0
    add-int v0, v4, v3

    .line 792
    mul-int/lit8 v3, v0, 0x1f

    iget v4, p0, Lcom/facebook/fbui/textlayoutbuilder/TextLayoutBuilder$ComparableTextPaint;->mShadowDx:F

    invoke-static {v4}, Ljava/lang/Float;->floatToIntBits(F)I

    move-result v4

    add-int v0, v3, v4

    .line 793
    mul-int/lit8 v3, v0, 0x1f

    iget v4, p0, Lcom/facebook/fbui/textlayoutbuilder/TextLayoutBuilder$ComparableTextPaint;->mShadowDy:F

    invoke-static {v4}, Ljava/lang/Float;->floatToIntBits(F)I

    move-result v4

    add-int v0, v3, v4

    .line 794
    mul-int/lit8 v3, v0, 0x1f

    iget v4, p0, Lcom/facebook/fbui/textlayoutbuilder/TextLayoutBuilder$ComparableTextPaint;->mShadowRadius:F

    invoke-static {v4}, Ljava/lang/Float;->floatToIntBits(F)I

    move-result v4

    add-int v0, v3, v4

    .line 795
    mul-int/lit8 v3, v0, 0x1f

    iget v4, p0, Lcom/facebook/fbui/textlayoutbuilder/TextLayoutBuilder$ComparableTextPaint;->mShadowColor:I

    add-int v0, v3, v4

    .line 796
    mul-int/lit8 v3, v0, 0x1f

    iget v4, p0, Lcom/facebook/fbui/textlayoutbuilder/TextLayoutBuilder$ComparableTextPaint;->linkColor:I

    add-int v0, v3, v4

    .line 799
    iget-object v3, p0, Lcom/facebook/fbui/textlayoutbuilder/TextLayoutBuilder$ComparableTextPaint;->drawableState:[I

    if-nez v3, :cond_2

    .line 800
    mul-int/lit8 v3, v0, 0x1f

    add-int/lit8 v0, v3, 0x0

    .line 807
    :cond_0
    return v0

    .line 791
    :cond_1
    const/4 v3, 0x0

    goto :goto_0

    .line 802
    :cond_2
    const/4 v1, 0x0

    .local v1, "i":I
    :goto_1
    iget-object v3, p0, Lcom/facebook/fbui/textlayoutbuilder/TextLayoutBuilder$ComparableTextPaint;->drawableState:[I

    array-length v3, v3

    if-ge v1, v3, :cond_0

    .line 803
    mul-int/lit8 v3, v0, 0x1f

    iget-object v4, p0, Lcom/facebook/fbui/textlayoutbuilder/TextLayoutBuilder$ComparableTextPaint;->drawableState:[I

    aget v4, v4, v1

    add-int v0, v3, v4

    .line 802
    add-int/lit8 v1, v1, 0x1

    goto :goto_1
.end method

.method public setShadowLayer(FFFI)V
    .locals 0
    .param p1, "radius"    # F
    .param p2, "dx"    # F
    .param p3, "dy"    # F
    .param p4, "color"    # I

    .prologue
    .line 776
    iput p1, p0, Lcom/facebook/fbui/textlayoutbuilder/TextLayoutBuilder$ComparableTextPaint;->mShadowRadius:F

    .line 777
    iput p2, p0, Lcom/facebook/fbui/textlayoutbuilder/TextLayoutBuilder$ComparableTextPaint;->mShadowDx:F

    .line 778
    iput p3, p0, Lcom/facebook/fbui/textlayoutbuilder/TextLayoutBuilder$ComparableTextPaint;->mShadowDy:F

    .line 779
    iput p4, p0, Lcom/facebook/fbui/textlayoutbuilder/TextLayoutBuilder$ComparableTextPaint;->mShadowColor:I

    .line 781
    invoke-super {p0, p1, p2, p3, p4}, Landroid/text/TextPaint;->setShadowLayer(FFFI)V

    .line 782
    return-void
.end method

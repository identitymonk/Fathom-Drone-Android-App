.class final Lcom/facebook/react/flat/FontStylingSpan;
.super Landroid/text/style/MetricAffectingSpan;
.source "FontStylingSpan.java"


# static fields
.field static final INSTANCE:Lcom/facebook/react/flat/FontStylingSpan;


# instance fields
.field private mBackgroundColor:I

.field private mFontFamily:Ljava/lang/String;
    .annotation runtime Ljavax/annotation/Nullable;
    .end annotation
.end field

.field private mFontSize:I

.field private mFontStyle:I

.field private mFontWeight:I

.field private mFrozen:Z

.field private mHasStrikeThrough:Z

.field private mHasUnderline:Z

.field private mTextColor:D


# direct methods
.method static constructor <clinit>()V
    .locals 12

    .prologue
    const/4 v4, 0x0

    const/4 v5, -0x1

    .line 21
    new-instance v1, Lcom/facebook/react/flat/FontStylingSpan;

    const-wide/high16 v2, -0x3e90000000000000L    # -1.6777216E7

    const/4 v10, 0x0

    const/4 v11, 0x1

    move v6, v5

    move v7, v5

    move v8, v4

    move v9, v4

    invoke-direct/range {v1 .. v11}, Lcom/facebook/react/flat/FontStylingSpan;-><init>(DIIIIZZLjava/lang/String;Z)V

    sput-object v1, Lcom/facebook/react/flat/FontStylingSpan;->INSTANCE:Lcom/facebook/react/flat/FontStylingSpan;

    return-void
.end method

.method constructor <init>()V
    .locals 0

    .prologue
    .line 47
    invoke-direct {p0}, Landroid/text/style/MetricAffectingSpan;-><init>()V

    .line 48
    return-void
.end method

.method private constructor <init>(DIIIIZZLjava/lang/String;Z)V
    .locals 1
    .param p1, "textColor"    # D
    .param p3, "backgroundColor"    # I
    .param p4, "fontSize"    # I
    .param p5, "fontStyle"    # I
    .param p6, "fontWeight"    # I
    .param p7, "hasUnderline"    # Z
    .param p8, "hasStrikeThrough"    # Z
    .param p9, "fontFamily"    # Ljava/lang/String;
        .annotation runtime Ljavax/annotation/Nullable;
        .end annotation
    .end param
    .param p10, "frozen"    # Z

    .prologue
    .line 59
    invoke-direct {p0}, Landroid/text/style/MetricAffectingSpan;-><init>()V

    .line 60
    iput-wide p1, p0, Lcom/facebook/react/flat/FontStylingSpan;->mTextColor:D

    .line 61
    iput p3, p0, Lcom/facebook/react/flat/FontStylingSpan;->mBackgroundColor:I

    .line 62
    iput p4, p0, Lcom/facebook/react/flat/FontStylingSpan;->mFontSize:I

    .line 63
    iput p5, p0, Lcom/facebook/react/flat/FontStylingSpan;->mFontStyle:I

    .line 64
    iput p6, p0, Lcom/facebook/react/flat/FontStylingSpan;->mFontWeight:I

    .line 65
    iput-boolean p7, p0, Lcom/facebook/react/flat/FontStylingSpan;->mHasUnderline:Z

    .line 66
    iput-boolean p8, p0, Lcom/facebook/react/flat/FontStylingSpan;->mHasStrikeThrough:Z

    .line 67
    iput-object p9, p0, Lcom/facebook/react/flat/FontStylingSpan;->mFontFamily:Ljava/lang/String;

    .line 68
    iput-boolean p10, p0, Lcom/facebook/react/flat/FontStylingSpan;->mFrozen:Z

    .line 69
    return-void
.end method

.method private getNewStyle(I)I
    .locals 4
    .param p1, "oldStyle"    # I

    .prologue
    const/4 v3, -0x1

    .line 178
    move v0, p1

    .line 179
    .local v0, "newStyle":I
    iget v1, p0, Lcom/facebook/react/flat/FontStylingSpan;->mFontStyle:I

    if-eq v1, v3, :cond_0

    .line 180
    and-int/lit8 v1, v0, -0x3

    iget v2, p0, Lcom/facebook/react/flat/FontStylingSpan;->mFontStyle:I

    or-int v0, v1, v2

    .line 183
    :cond_0
    iget v1, p0, Lcom/facebook/react/flat/FontStylingSpan;->mFontWeight:I

    if-eq v1, v3, :cond_1

    .line 184
    and-int/lit8 v1, v0, -0x2

    iget v2, p0, Lcom/facebook/react/flat/FontStylingSpan;->mFontWeight:I

    or-int v0, v1, v2

    .line 187
    :cond_1
    return v0
.end method

.method private updateTypeface(Landroid/text/TextPaint;)V
    .locals 4
    .param p1, "ds"    # Landroid/text/TextPaint;

    .prologue
    .line 191
    invoke-virtual {p1}, Landroid/text/TextPaint;->getTypeface()Landroid/graphics/Typeface;

    move-result-object v2

    .line 193
    .local v2, "typeface":Landroid/graphics/Typeface;
    if-nez v2, :cond_0

    const/4 v1, 0x0

    .line 194
    .local v1, "oldStyle":I
    :goto_0
    invoke-direct {p0, v1}, Lcom/facebook/react/flat/FontStylingSpan;->getNewStyle(I)I

    move-result v0

    .line 196
    .local v0, "newStyle":I
    if-ne v1, v0, :cond_1

    iget-object v3, p0, Lcom/facebook/react/flat/FontStylingSpan;->mFontFamily:Ljava/lang/String;

    if-nez v3, :cond_1

    .line 208
    :goto_1
    return-void

    .line 193
    .end local v0    # "newStyle":I
    .end local v1    # "oldStyle":I
    :cond_0
    invoke-virtual {v2}, Landroid/graphics/Typeface;->getStyle()I

    move-result v1

    goto :goto_0

    .line 201
    .restart local v0    # "newStyle":I
    .restart local v1    # "oldStyle":I
    :cond_1
    iget-object v3, p0, Lcom/facebook/react/flat/FontStylingSpan;->mFontFamily:Ljava/lang/String;

    if-eqz v3, :cond_2

    .line 202
    iget-object v3, p0, Lcom/facebook/react/flat/FontStylingSpan;->mFontFamily:Ljava/lang/String;

    invoke-static {v3, v0}, Lcom/facebook/react/flat/TypefaceCache;->getTypeface(Ljava/lang/String;I)Landroid/graphics/Typeface;

    move-result-object v2

    .line 207
    :goto_2
    invoke-virtual {p1, v2}, Landroid/text/TextPaint;->setTypeface(Landroid/graphics/Typeface;)Landroid/graphics/Typeface;

    goto :goto_1

    .line 204
    :cond_2
    invoke-static {v2, v0}, Lcom/facebook/react/flat/TypefaceCache;->getTypeface(Landroid/graphics/Typeface;I)Landroid/graphics/Typeface;

    move-result-object v2

    goto :goto_2
.end method


# virtual methods
.method freeze()V
    .locals 1

    .prologue
    .line 89
    const/4 v0, 0x1

    iput-boolean v0, p0, Lcom/facebook/react/flat/FontStylingSpan;->mFrozen:Z

    .line 90
    return-void
.end method

.method getBackgroundColor()I
    .locals 1

    .prologue
    .line 101
    iget v0, p0, Lcom/facebook/react/flat/FontStylingSpan;->mBackgroundColor:I

    return v0
.end method

.method getFontFamily()Ljava/lang/String;
    .locals 1
    .annotation runtime Ljavax/annotation/Nullable;
    .end annotation

    .prologue
    .line 133
    iget-object v0, p0, Lcom/facebook/react/flat/FontStylingSpan;->mFontFamily:Ljava/lang/String;

    return-object v0
.end method

.method getFontSize()I
    .locals 1

    .prologue
    .line 109
    iget v0, p0, Lcom/facebook/react/flat/FontStylingSpan;->mFontSize:I

    return v0
.end method

.method getFontStyle()I
    .locals 1

    .prologue
    .line 117
    iget v0, p0, Lcom/facebook/react/flat/FontStylingSpan;->mFontStyle:I

    return v0
.end method

.method getFontWeight()I
    .locals 1

    .prologue
    .line 125
    iget v0, p0, Lcom/facebook/react/flat/FontStylingSpan;->mFontWeight:I

    return v0
.end method

.method getTextColor()D
    .locals 2

    .prologue
    .line 93
    iget-wide v0, p0, Lcom/facebook/react/flat/FontStylingSpan;->mTextColor:D

    return-wide v0
.end method

.method hasStrikeThrough()Z
    .locals 1

    .prologue
    .line 149
    iget-boolean v0, p0, Lcom/facebook/react/flat/FontStylingSpan;->mHasStrikeThrough:Z

    return v0
.end method

.method hasUnderline()Z
    .locals 1

    .prologue
    .line 141
    iget-boolean v0, p0, Lcom/facebook/react/flat/FontStylingSpan;->mHasUnderline:Z

    return v0
.end method

.method isFrozen()Z
    .locals 1

    .prologue
    .line 85
    iget-boolean v0, p0, Lcom/facebook/react/flat/FontStylingSpan;->mFrozen:Z

    return v0
.end method

.method mutableCopy()Lcom/facebook/react/flat/FontStylingSpan;
    .locals 12

    .prologue
    .line 72
    new-instance v1, Lcom/facebook/react/flat/FontStylingSpan;

    iget-wide v2, p0, Lcom/facebook/react/flat/FontStylingSpan;->mTextColor:D

    iget v4, p0, Lcom/facebook/react/flat/FontStylingSpan;->mBackgroundColor:I

    iget v5, p0, Lcom/facebook/react/flat/FontStylingSpan;->mFontSize:I

    iget v6, p0, Lcom/facebook/react/flat/FontStylingSpan;->mFontStyle:I

    iget v7, p0, Lcom/facebook/react/flat/FontStylingSpan;->mFontWeight:I

    iget-boolean v8, p0, Lcom/facebook/react/flat/FontStylingSpan;->mHasUnderline:Z

    iget-boolean v9, p0, Lcom/facebook/react/flat/FontStylingSpan;->mHasStrikeThrough:Z

    iget-object v10, p0, Lcom/facebook/react/flat/FontStylingSpan;->mFontFamily:Ljava/lang/String;

    const/4 v11, 0x0

    invoke-direct/range {v1 .. v11}, Lcom/facebook/react/flat/FontStylingSpan;-><init>(DIIIIZZLjava/lang/String;Z)V

    return-object v1
.end method

.method setBackgroundColor(I)V
    .locals 0
    .param p1, "backgroundColor"    # I

    .prologue
    .line 105
    iput p1, p0, Lcom/facebook/react/flat/FontStylingSpan;->mBackgroundColor:I

    .line 106
    return-void
.end method

.method setFontFamily(Ljava/lang/String;)V
    .locals 0
    .param p1, "fontFamily"    # Ljava/lang/String;
        .annotation runtime Ljavax/annotation/Nullable;
        .end annotation
    .end param

    .prologue
    .line 137
    iput-object p1, p0, Lcom/facebook/react/flat/FontStylingSpan;->mFontFamily:Ljava/lang/String;

    .line 138
    return-void
.end method

.method setFontSize(I)V
    .locals 0
    .param p1, "fontSize"    # I

    .prologue
    .line 113
    iput p1, p0, Lcom/facebook/react/flat/FontStylingSpan;->mFontSize:I

    .line 114
    return-void
.end method

.method setFontStyle(I)V
    .locals 0
    .param p1, "fontStyle"    # I

    .prologue
    .line 121
    iput p1, p0, Lcom/facebook/react/flat/FontStylingSpan;->mFontStyle:I

    .line 122
    return-void
.end method

.method setFontWeight(I)V
    .locals 0
    .param p1, "fontWeight"    # I

    .prologue
    .line 129
    iput p1, p0, Lcom/facebook/react/flat/FontStylingSpan;->mFontWeight:I

    .line 130
    return-void
.end method

.method setHasStrikeThrough(Z)V
    .locals 0
    .param p1, "hasStrikeThrough"    # Z

    .prologue
    .line 153
    iput-boolean p1, p0, Lcom/facebook/react/flat/FontStylingSpan;->mHasStrikeThrough:Z

    .line 154
    return-void
.end method

.method setHasUnderline(Z)V
    .locals 0
    .param p1, "hasUnderline"    # Z

    .prologue
    .line 145
    iput-boolean p1, p0, Lcom/facebook/react/flat/FontStylingSpan;->mHasUnderline:Z

    .line 146
    return-void
.end method

.method setTextColor(D)V
    .locals 1
    .param p1, "textColor"    # D

    .prologue
    .line 97
    iput-wide p1, p0, Lcom/facebook/react/flat/FontStylingSpan;->mTextColor:D

    .line 98
    return-void
.end method

.method public updateDrawState(Landroid/text/TextPaint;)V
    .locals 2
    .param p1, "ds"    # Landroid/text/TextPaint;

    .prologue
    .line 158
    iget-wide v0, p0, Lcom/facebook/react/flat/FontStylingSpan;->mTextColor:D

    invoke-static {v0, v1}, Ljava/lang/Double;->isNaN(D)Z

    move-result v0

    if-nez v0, :cond_0

    .line 159
    iget-wide v0, p0, Lcom/facebook/react/flat/FontStylingSpan;->mTextColor:D

    double-to-int v0, v0

    invoke-virtual {p1, v0}, Landroid/text/TextPaint;->setColor(I)V

    .line 162
    :cond_0
    iget v0, p0, Lcom/facebook/react/flat/FontStylingSpan;->mBackgroundColor:I

    iput v0, p1, Landroid/text/TextPaint;->bgColor:I

    .line 163
    iget-boolean v0, p0, Lcom/facebook/react/flat/FontStylingSpan;->mHasUnderline:Z

    invoke-virtual {p1, v0}, Landroid/text/TextPaint;->setUnderlineText(Z)V

    .line 164
    iget-boolean v0, p0, Lcom/facebook/react/flat/FontStylingSpan;->mHasStrikeThrough:Z

    invoke-virtual {p1, v0}, Landroid/text/TextPaint;->setStrikeThruText(Z)V

    .line 165
    invoke-virtual {p0, p1}, Lcom/facebook/react/flat/FontStylingSpan;->updateMeasureState(Landroid/text/TextPaint;)V

    .line 166
    return-void
.end method

.method public updateMeasureState(Landroid/text/TextPaint;)V
    .locals 2
    .param p1, "ds"    # Landroid/text/TextPaint;

    .prologue
    .line 170
    iget v0, p0, Lcom/facebook/react/flat/FontStylingSpan;->mFontSize:I

    const/4 v1, -0x1

    if-eq v0, v1, :cond_0

    .line 171
    iget v0, p0, Lcom/facebook/react/flat/FontStylingSpan;->mFontSize:I

    int-to-float v0, v0

    invoke-virtual {p1, v0}, Landroid/text/TextPaint;->setTextSize(F)V

    .line 174
    :cond_0
    invoke-direct {p0, p1}, Lcom/facebook/react/flat/FontStylingSpan;->updateTypeface(Landroid/text/TextPaint;)V

    .line 175
    return-void
.end method

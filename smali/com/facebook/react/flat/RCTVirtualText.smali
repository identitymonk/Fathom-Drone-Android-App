.class Lcom/facebook/react/flat/RCTVirtualText;
.super Lcom/facebook/react/flat/FlatTextShadowNode;
.source "RCTVirtualText.java"


# static fields
.field private static final BOLD:Ljava/lang/String; = "bold"

.field private static final DEFAULT_TEXT_SHADOW_COLOR:I = 0x55000000

.field private static final ITALIC:Ljava/lang/String; = "italic"

.field private static final NORMAL:Ljava/lang/String; = "normal"

.field private static final PROP_SHADOW_COLOR:Ljava/lang/String; = "textShadowColor"

.field private static final PROP_SHADOW_OFFSET:Ljava/lang/String; = "textShadowOffset"

.field private static final PROP_SHADOW_RADIUS:Ljava/lang/String; = "textShadowRadius"


# instance fields
.field private mFontStylingSpan:Lcom/facebook/react/flat/FontStylingSpan;

.field private mShadowStyleSpan:Lcom/facebook/react/flat/ShadowStyleSpan;


# direct methods
.method constructor <init>()V
    .locals 1

    .prologue
    .line 26
    invoke-direct {p0}, Lcom/facebook/react/flat/FlatTextShadowNode;-><init>()V

    .line 37
    sget-object v0, Lcom/facebook/react/flat/FontStylingSpan;->INSTANCE:Lcom/facebook/react/flat/FontStylingSpan;

    iput-object v0, p0, Lcom/facebook/react/flat/RCTVirtualText;->mFontStylingSpan:Lcom/facebook/react/flat/FontStylingSpan;

    .line 38
    sget-object v0, Lcom/facebook/react/flat/ShadowStyleSpan;->INSTANCE:Lcom/facebook/react/flat/ShadowStyleSpan;

    iput-object v0, p0, Lcom/facebook/react/flat/RCTVirtualText;->mShadowStyleSpan:Lcom/facebook/react/flat/ShadowStyleSpan;

    return-void
.end method

.method static fontSizeFromSp(F)I
    .locals 2
    .param p0, "sp"    # F

    .prologue
    .line 271
    invoke-static {p0}, Lcom/facebook/react/uimanager/PixelUtil;->toPixelFromSP(F)F

    move-result v0

    float-to-double v0, v0

    invoke-static {v0, v1}, Ljava/lang/Math;->ceil(D)D

    move-result-wide v0

    double-to-int v0, v0

    return v0
.end method

.method private final getShadowSpan()Lcom/facebook/react/flat/ShadowStyleSpan;
    .locals 1

    .prologue
    .line 293
    iget-object v0, p0, Lcom/facebook/react/flat/RCTVirtualText;->mShadowStyleSpan:Lcom/facebook/react/flat/ShadowStyleSpan;

    invoke-virtual {v0}, Lcom/facebook/react/flat/ShadowStyleSpan;->isFrozen()Z

    move-result v0

    if-eqz v0, :cond_0

    .line 294
    iget-object v0, p0, Lcom/facebook/react/flat/RCTVirtualText;->mShadowStyleSpan:Lcom/facebook/react/flat/ShadowStyleSpan;

    invoke-virtual {v0}, Lcom/facebook/react/flat/ShadowStyleSpan;->mutableCopy()Lcom/facebook/react/flat/ShadowStyleSpan;

    move-result-object v0

    iput-object v0, p0, Lcom/facebook/react/flat/RCTVirtualText;->mShadowStyleSpan:Lcom/facebook/react/flat/ShadowStyleSpan;

    .line 296
    :cond_0
    iget-object v0, p0, Lcom/facebook/react/flat/RCTVirtualText;->mShadowStyleSpan:Lcom/facebook/react/flat/ShadowStyleSpan;

    return-object v0
.end method

.method private static parseNumericFontWeight(Ljava/lang/String;)I
    .locals 3
    .param p0, "fontWeightString"    # Ljava/lang/String;

    .prologue
    const/4 v2, 0x0

    .line 305
    invoke-virtual {p0}, Ljava/lang/String;->length()I

    move-result v0

    const/4 v1, 0x3

    if-ne v0, v1, :cond_0

    const-string v0, "00"

    invoke-virtual {p0, v0}, Ljava/lang/String;->endsWith(Ljava/lang/String;)Z

    move-result v0

    if-eqz v0, :cond_0

    .line 306
    invoke-virtual {p0, v2}, Ljava/lang/String;->charAt(I)C

    move-result v0

    const/16 v1, 0x39

    if-gt v0, v1, :cond_0

    invoke-virtual {p0, v2}, Ljava/lang/String;->charAt(I)C

    move-result v0

    const/16 v1, 0x31

    if-lt v0, v1, :cond_0

    .line 307
    invoke-virtual {p0, v2}, Ljava/lang/String;->charAt(I)C

    move-result v0

    add-int/lit8 v0, v0, -0x30

    mul-int/lit8 v0, v0, 0x64

    :goto_0
    return v0

    :cond_0
    const/4 v0, -0x1

    goto :goto_0
.end method


# virtual methods
.method public bridge synthetic addChildAt(Lcom/facebook/react/uimanager/ReactShadowNode;I)V
    .locals 0

    .prologue
    .line 26
    check-cast p1, Lcom/facebook/react/uimanager/ReactShadowNodeImpl;

    invoke-virtual {p0, p1, p2}, Lcom/facebook/react/flat/RCTVirtualText;->addChildAt(Lcom/facebook/react/uimanager/ReactShadowNodeImpl;I)V

    return-void
.end method

.method public addChildAt(Lcom/facebook/react/uimanager/ReactShadowNodeImpl;I)V
    .locals 1
    .param p1, "child"    # Lcom/facebook/react/uimanager/ReactShadowNodeImpl;
    .param p2, "i"    # I

    .prologue
    .line 42
    invoke-super {p0, p1, p2}, Lcom/facebook/react/flat/FlatTextShadowNode;->addChildAt(Lcom/facebook/react/uimanager/ReactShadowNodeImpl;I)V

    .line 43
    const/4 v0, 0x1

    invoke-virtual {p0, v0}, Lcom/facebook/react/flat/RCTVirtualText;->notifyChanged(Z)V

    .line 44
    return-void
.end method

.method protected getDefaultFontSize()I
    .locals 1

    .prologue
    .line 267
    const/4 v0, -0x1

    return v0
.end method

.method protected final getFontSize()I
    .locals 1

    .prologue
    .line 256
    iget-object v0, p0, Lcom/facebook/react/flat/RCTVirtualText;->mFontStylingSpan:Lcom/facebook/react/flat/FontStylingSpan;

    invoke-virtual {v0}, Lcom/facebook/react/flat/FontStylingSpan;->getFontSize()I

    move-result v0

    return v0
.end method

.method protected final getFontStyle()I
    .locals 2

    .prologue
    .line 262
    iget-object v1, p0, Lcom/facebook/react/flat/RCTVirtualText;->mFontStylingSpan:Lcom/facebook/react/flat/FontStylingSpan;

    invoke-virtual {v1}, Lcom/facebook/react/flat/FontStylingSpan;->getFontStyle()I

    move-result v0

    .line 263
    .local v0, "style":I
    if-ltz v0, :cond_0

    .end local v0    # "style":I
    :goto_0
    return v0

    .restart local v0    # "style":I
    :cond_0
    const/4 v0, 0x0

    goto :goto_0
.end method

.method protected final getSpan()Lcom/facebook/react/flat/FontStylingSpan;
    .locals 1

    .prologue
    .line 275
    iget-object v0, p0, Lcom/facebook/react/flat/RCTVirtualText;->mFontStylingSpan:Lcom/facebook/react/flat/FontStylingSpan;

    invoke-virtual {v0}, Lcom/facebook/react/flat/FontStylingSpan;->isFrozen()Z

    move-result v0

    if-eqz v0, :cond_0

    .line 276
    iget-object v0, p0, Lcom/facebook/react/flat/RCTVirtualText;->mFontStylingSpan:Lcom/facebook/react/flat/FontStylingSpan;

    invoke-virtual {v0}, Lcom/facebook/react/flat/FontStylingSpan;->mutableCopy()Lcom/facebook/react/flat/FontStylingSpan;

    move-result-object v0

    iput-object v0, p0, Lcom/facebook/react/flat/RCTVirtualText;->mFontStylingSpan:Lcom/facebook/react/flat/FontStylingSpan;

    .line 278
    :cond_0
    iget-object v0, p0, Lcom/facebook/react/flat/RCTVirtualText;->mFontStylingSpan:Lcom/facebook/react/flat/FontStylingSpan;

    return-object v0
.end method

.method final getText()Landroid/text/SpannableStringBuilder;
    .locals 2

    .prologue
    .line 286
    new-instance v0, Landroid/text/SpannableStringBuilder;

    invoke-direct {v0}, Landroid/text/SpannableStringBuilder;-><init>()V

    .line 287
    .local v0, "sb":Landroid/text/SpannableStringBuilder;
    invoke-virtual {p0, v0}, Lcom/facebook/react/flat/RCTVirtualText;->collectText(Landroid/text/SpannableStringBuilder;)V

    .line 288
    invoke-virtual {p0}, Lcom/facebook/react/flat/RCTVirtualText;->isEditable()Z

    move-result v1

    invoke-virtual {p0, v0, v1}, Lcom/facebook/react/flat/RCTVirtualText;->applySpans(Landroid/text/SpannableStringBuilder;Z)V

    .line 289
    return-object v0
.end method

.method protected performApplySpans(Landroid/text/SpannableStringBuilder;IIZ)V
    .locals 6
    .param p1, "builder"    # Landroid/text/SpannableStringBuilder;
    .param p2, "begin"    # I
    .param p3, "end"    # I
    .param p4, "isEditable"    # Z

    .prologue
    .line 56
    iget-object v4, p0, Lcom/facebook/react/flat/RCTVirtualText;->mFontStylingSpan:Lcom/facebook/react/flat/FontStylingSpan;

    invoke-virtual {v4}, Lcom/facebook/react/flat/FontStylingSpan;->freeze()V

    .line 61
    if-eqz p4, :cond_1

    .line 62
    const/16 v2, 0x21

    .line 69
    .local v2, "flag":I
    :goto_0
    iget-object v4, p0, Lcom/facebook/react/flat/RCTVirtualText;->mFontStylingSpan:Lcom/facebook/react/flat/FontStylingSpan;

    invoke-virtual {p1, v4, p2, p3, v2}, Landroid/text/SpannableStringBuilder;->setSpan(Ljava/lang/Object;III)V

    .line 75
    iget-object v4, p0, Lcom/facebook/react/flat/RCTVirtualText;->mShadowStyleSpan:Lcom/facebook/react/flat/ShadowStyleSpan;

    invoke-virtual {v4}, Lcom/facebook/react/flat/ShadowStyleSpan;->getColor()I

    move-result v4

    if-eqz v4, :cond_0

    iget-object v4, p0, Lcom/facebook/react/flat/RCTVirtualText;->mShadowStyleSpan:Lcom/facebook/react/flat/ShadowStyleSpan;

    invoke-virtual {v4}, Lcom/facebook/react/flat/ShadowStyleSpan;->getRadius()F

    move-result v4

    const/4 v5, 0x0

    cmpl-float v4, v4, v5

    if-eqz v4, :cond_0

    .line 76
    iget-object v4, p0, Lcom/facebook/react/flat/RCTVirtualText;->mShadowStyleSpan:Lcom/facebook/react/flat/ShadowStyleSpan;

    invoke-virtual {v4}, Lcom/facebook/react/flat/ShadowStyleSpan;->freeze()V

    .line 78
    iget-object v4, p0, Lcom/facebook/react/flat/RCTVirtualText;->mShadowStyleSpan:Lcom/facebook/react/flat/ShadowStyleSpan;

    invoke-virtual {p1, v4, p2, p3, v2}, Landroid/text/SpannableStringBuilder;->setSpan(Ljava/lang/Object;III)V

    .line 85
    :cond_0
    const/4 v3, 0x0

    .local v3, "i":I
    invoke-virtual {p0}, Lcom/facebook/react/flat/RCTVirtualText;->getChildCount()I

    move-result v1

    .local v1, "childCount":I
    :goto_1
    if-ge v3, v1, :cond_3

    .line 86
    invoke-virtual {p0, v3}, Lcom/facebook/react/flat/RCTVirtualText;->getChildAt(I)Lcom/facebook/react/uimanager/ReactShadowNodeImpl;

    move-result-object v0

    check-cast v0, Lcom/facebook/react/flat/FlatTextShadowNode;

    .line 87
    .local v0, "child":Lcom/facebook/react/flat/FlatTextShadowNode;
    invoke-virtual {v0, p1, p4}, Lcom/facebook/react/flat/FlatTextShadowNode;->applySpans(Landroid/text/SpannableStringBuilder;Z)V

    .line 85
    add-int/lit8 v3, v3, 0x1

    goto :goto_1

    .line 64
    .end local v0    # "child":Lcom/facebook/react/flat/FlatTextShadowNode;
    .end local v1    # "childCount":I
    .end local v2    # "flag":I
    .end local v3    # "i":I
    :cond_1
    if-nez p2, :cond_2

    const/16 v2, 0x12

    .restart local v2    # "flag":I
    :goto_2
    goto :goto_0

    .end local v2    # "flag":I
    :cond_2
    const/16 v2, 0x22

    goto :goto_2

    .line 89
    .restart local v1    # "childCount":I
    .restart local v2    # "flag":I
    .restart local v3    # "i":I
    :cond_3
    return-void
.end method

.method protected performCollectAttachDetachListeners(Lcom/facebook/react/flat/StateBuilder;)V
    .locals 3
    .param p1, "stateBuilder"    # Lcom/facebook/react/flat/StateBuilder;

    .prologue
    .line 93
    const/4 v2, 0x0

    .local v2, "i":I
    invoke-virtual {p0}, Lcom/facebook/react/flat/RCTVirtualText;->getChildCount()I

    move-result v1

    .local v1, "childCount":I
    :goto_0
    if-ge v2, v1, :cond_0

    .line 94
    invoke-virtual {p0, v2}, Lcom/facebook/react/flat/RCTVirtualText;->getChildAt(I)Lcom/facebook/react/uimanager/ReactShadowNodeImpl;

    move-result-object v0

    check-cast v0, Lcom/facebook/react/flat/FlatTextShadowNode;

    .line 95
    .local v0, "child":Lcom/facebook/react/flat/FlatTextShadowNode;
    invoke-virtual {v0, p1}, Lcom/facebook/react/flat/FlatTextShadowNode;->performCollectAttachDetachListeners(Lcom/facebook/react/flat/StateBuilder;)V

    .line 93
    add-int/lit8 v2, v2, 0x1

    goto :goto_0

    .line 97
    .end local v0    # "child":Lcom/facebook/react/flat/FlatTextShadowNode;
    :cond_0
    return-void
.end method

.method protected performCollectText(Landroid/text/SpannableStringBuilder;)V
    .locals 3
    .param p1, "builder"    # Landroid/text/SpannableStringBuilder;

    .prologue
    .line 48
    const/4 v2, 0x0

    .local v2, "i":I
    invoke-virtual {p0}, Lcom/facebook/react/flat/RCTVirtualText;->getChildCount()I

    move-result v1

    .local v1, "childCount":I
    :goto_0
    if-ge v2, v1, :cond_0

    .line 49
    invoke-virtual {p0, v2}, Lcom/facebook/react/flat/RCTVirtualText;->getChildAt(I)Lcom/facebook/react/uimanager/ReactShadowNodeImpl;

    move-result-object v0

    check-cast v0, Lcom/facebook/react/flat/FlatTextShadowNode;

    .line 50
    .local v0, "child":Lcom/facebook/react/flat/FlatTextShadowNode;
    invoke-virtual {v0, p1}, Lcom/facebook/react/flat/FlatTextShadowNode;->collectText(Landroid/text/SpannableStringBuilder;)V

    .line 48
    add-int/lit8 v2, v2, 0x1

    goto :goto_0

    .line 52
    .end local v0    # "child":Lcom/facebook/react/flat/FlatTextShadowNode;
    :cond_0
    return-void
.end method

.method public setBackgroundColor(I)V
    .locals 1
    .param p1, "backgroundColor"    # I

    .prologue
    .line 124
    invoke-virtual {p0}, Lcom/facebook/react/flat/RCTVirtualText;->isVirtual()Z

    move-result v0

    if-eqz v0, :cond_1

    .line 127
    iget-object v0, p0, Lcom/facebook/react/flat/RCTVirtualText;->mFontStylingSpan:Lcom/facebook/react/flat/FontStylingSpan;

    invoke-virtual {v0}, Lcom/facebook/react/flat/FontStylingSpan;->getBackgroundColor()I

    move-result v0

    if-eq v0, p1, :cond_0

    .line 128
    invoke-virtual {p0}, Lcom/facebook/react/flat/RCTVirtualText;->getSpan()Lcom/facebook/react/flat/FontStylingSpan;

    move-result-object v0

    invoke-virtual {v0, p1}, Lcom/facebook/react/flat/FontStylingSpan;->setBackgroundColor(I)V

    .line 129
    const/4 v0, 0x0

    invoke-virtual {p0, v0}, Lcom/facebook/react/flat/RCTVirtualText;->notifyChanged(Z)V

    .line 140
    :cond_0
    :goto_0
    return-void

    .line 138
    :cond_1
    invoke-super {p0, p1}, Lcom/facebook/react/flat/FlatTextShadowNode;->setBackgroundColor(I)V

    goto :goto_0
.end method

.method public setColor(D)V
    .locals 3
    .param p1, "textColor"    # D
    .annotation runtime Lcom/facebook/react/uimanager/annotations/ReactProp;
        defaultDouble = NaN
        name = "color"
    .end annotation

    .prologue
    .line 116
    iget-object v0, p0, Lcom/facebook/react/flat/RCTVirtualText;->mFontStylingSpan:Lcom/facebook/react/flat/FontStylingSpan;

    invoke-virtual {v0}, Lcom/facebook/react/flat/FontStylingSpan;->getTextColor()D

    move-result-wide v0

    cmpl-double v0, v0, p1

    if-eqz v0, :cond_0

    .line 117
    invoke-virtual {p0}, Lcom/facebook/react/flat/RCTVirtualText;->getSpan()Lcom/facebook/react/flat/FontStylingSpan;

    move-result-object v0

    invoke-virtual {v0, p1, p2}, Lcom/facebook/react/flat/FontStylingSpan;->setTextColor(D)V

    .line 118
    const/4 v0, 0x0

    invoke-virtual {p0, v0}, Lcom/facebook/react/flat/RCTVirtualText;->notifyChanged(Z)V

    .line 120
    :cond_0
    return-void
.end method

.method public setFontFamily(Ljava/lang/String;)V
    .locals 1
    .param p1, "fontFamily"    # Ljava/lang/String;
        .annotation runtime Ljavax/annotation/Nullable;
        .end annotation
    .end param
    .annotation runtime Lcom/facebook/react/uimanager/annotations/ReactProp;
        name = "fontFamily"
    .end annotation

    .prologue
    .line 144
    iget-object v0, p0, Lcom/facebook/react/flat/RCTVirtualText;->mFontStylingSpan:Lcom/facebook/react/flat/FontStylingSpan;

    invoke-virtual {v0}, Lcom/facebook/react/flat/FontStylingSpan;->getFontFamily()Ljava/lang/String;

    move-result-object v0

    invoke-static {v0, p1}, Landroid/text/TextUtils;->equals(Ljava/lang/CharSequence;Ljava/lang/CharSequence;)Z

    move-result v0

    if-nez v0, :cond_0

    .line 145
    invoke-virtual {p0}, Lcom/facebook/react/flat/RCTVirtualText;->getSpan()Lcom/facebook/react/flat/FontStylingSpan;

    move-result-object v0

    invoke-virtual {v0, p1}, Lcom/facebook/react/flat/FontStylingSpan;->setFontFamily(Ljava/lang/String;)V

    .line 146
    const/4 v0, 0x1

    invoke-virtual {p0, v0}, Lcom/facebook/react/flat/RCTVirtualText;->notifyChanged(Z)V

    .line 148
    :cond_0
    return-void
.end method

.method public setFontSize(F)V
    .locals 2
    .param p1, "fontSizeSp"    # F
    .annotation runtime Lcom/facebook/react/uimanager/annotations/ReactProp;
        defaultFloat = NaNf
        name = "fontSize"
    .end annotation

    .prologue
    .line 102
    invoke-static {p1}, Ljava/lang/Float;->isNaN(F)Z

    move-result v1

    if-eqz v1, :cond_1

    .line 103
    invoke-virtual {p0}, Lcom/facebook/react/flat/RCTVirtualText;->getDefaultFontSize()I

    move-result v0

    .line 108
    .local v0, "fontSize":I
    :goto_0
    iget-object v1, p0, Lcom/facebook/react/flat/RCTVirtualText;->mFontStylingSpan:Lcom/facebook/react/flat/FontStylingSpan;

    invoke-virtual {v1}, Lcom/facebook/react/flat/FontStylingSpan;->getFontSize()I

    move-result v1

    if-eq v1, v0, :cond_0

    .line 109
    invoke-virtual {p0}, Lcom/facebook/react/flat/RCTVirtualText;->getSpan()Lcom/facebook/react/flat/FontStylingSpan;

    move-result-object v1

    invoke-virtual {v1, v0}, Lcom/facebook/react/flat/FontStylingSpan;->setFontSize(I)V

    .line 110
    const/4 v1, 0x1

    invoke-virtual {p0, v1}, Lcom/facebook/react/flat/RCTVirtualText;->notifyChanged(Z)V

    .line 112
    :cond_0
    return-void

    .line 105
    .end local v0    # "fontSize":I
    :cond_1
    invoke-static {p1}, Lcom/facebook/react/flat/RCTVirtualText;->fontSizeFromSp(F)I

    move-result v0

    .restart local v0    # "fontSize":I
    goto :goto_0
.end method

.method public setFontStyle(Ljava/lang/String;)V
    .locals 4
    .param p1, "fontStyleString"    # Ljava/lang/String;
        .annotation runtime Ljavax/annotation/Nullable;
        .end annotation
    .end param
    .annotation runtime Lcom/facebook/react/uimanager/annotations/ReactProp;
        name = "fontStyle"
    .end annotation

    .prologue
    .line 199
    if-nez p1, :cond_1

    .line 200
    const/4 v0, -0x1

    .line 209
    .local v0, "fontStyle":I
    :goto_0
    iget-object v1, p0, Lcom/facebook/react/flat/RCTVirtualText;->mFontStylingSpan:Lcom/facebook/react/flat/FontStylingSpan;

    invoke-virtual {v1}, Lcom/facebook/react/flat/FontStylingSpan;->getFontStyle()I

    move-result v1

    if-eq v1, v0, :cond_0

    .line 210
    invoke-virtual {p0}, Lcom/facebook/react/flat/RCTVirtualText;->getSpan()Lcom/facebook/react/flat/FontStylingSpan;

    move-result-object v1

    invoke-virtual {v1, v0}, Lcom/facebook/react/flat/FontStylingSpan;->setFontStyle(I)V

    .line 211
    const/4 v1, 0x1

    invoke-virtual {p0, v1}, Lcom/facebook/react/flat/RCTVirtualText;->notifyChanged(Z)V

    .line 213
    :cond_0
    return-void

    .line 201
    .end local v0    # "fontStyle":I
    :cond_1
    const-string v1, "italic"

    invoke-virtual {v1, p1}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v1

    if-eqz v1, :cond_2

    .line 202
    const/4 v0, 0x2

    .restart local v0    # "fontStyle":I
    goto :goto_0

    .line 203
    .end local v0    # "fontStyle":I
    :cond_2
    const-string v1, "normal"

    invoke-virtual {v1, p1}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v1

    if-eqz v1, :cond_3

    .line 204
    const/4 v0, 0x0

    .restart local v0    # "fontStyle":I
    goto :goto_0

    .line 206
    .end local v0    # "fontStyle":I
    :cond_3
    new-instance v1, Ljava/lang/RuntimeException;

    new-instance v2, Ljava/lang/StringBuilder;

    invoke-direct {v2}, Ljava/lang/StringBuilder;-><init>()V

    const-string v3, "invalid font style "

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2, p1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v2

    invoke-direct {v1, v2}, Ljava/lang/RuntimeException;-><init>(Ljava/lang/String;)V

    throw v1
.end method

.method public setFontWeight(Ljava/lang/String;)V
    .locals 5
    .param p1, "fontWeightString"    # Ljava/lang/String;
        .annotation runtime Ljavax/annotation/Nullable;
        .end annotation
    .end param
    .annotation runtime Lcom/facebook/react/uimanager/annotations/ReactProp;
        name = "fontWeight"
    .end annotation

    .prologue
    const/4 v2, 0x1

    .line 153
    if-nez p1, :cond_1

    .line 154
    const/4 v0, -0x1

    .line 167
    .local v0, "fontWeight":I
    :goto_0
    iget-object v3, p0, Lcom/facebook/react/flat/RCTVirtualText;->mFontStylingSpan:Lcom/facebook/react/flat/FontStylingSpan;

    invoke-virtual {v3}, Lcom/facebook/react/flat/FontStylingSpan;->getFontWeight()I

    move-result v3

    if-eq v3, v0, :cond_0

    .line 168
    invoke-virtual {p0}, Lcom/facebook/react/flat/RCTVirtualText;->getSpan()Lcom/facebook/react/flat/FontStylingSpan;

    move-result-object v3

    invoke-virtual {v3, v0}, Lcom/facebook/react/flat/FontStylingSpan;->setFontWeight(I)V

    .line 169
    invoke-virtual {p0, v2}, Lcom/facebook/react/flat/RCTVirtualText;->notifyChanged(Z)V

    .line 171
    :cond_0
    return-void

    .line 155
    .end local v0    # "fontWeight":I
    :cond_1
    const-string v3, "bold"

    invoke-virtual {v3, p1}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v3

    if-eqz v3, :cond_2

    .line 156
    const/4 v0, 0x1

    .restart local v0    # "fontWeight":I
    goto :goto_0

    .line 157
    .end local v0    # "fontWeight":I
    :cond_2
    const-string v3, "normal"

    invoke-virtual {v3, p1}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v3

    if-eqz v3, :cond_3

    .line 158
    const/4 v0, 0x0

    .restart local v0    # "fontWeight":I
    goto :goto_0

    .line 160
    .end local v0    # "fontWeight":I
    :cond_3
    invoke-static {p1}, Lcom/facebook/react/flat/RCTVirtualText;->parseNumericFontWeight(Ljava/lang/String;)I

    move-result v1

    .line 161
    .local v1, "fontWeightNumeric":I
    const/4 v3, -0x1

    if-ne v1, v3, :cond_4

    .line 162
    new-instance v2, Ljava/lang/RuntimeException;

    new-instance v3, Ljava/lang/StringBuilder;

    invoke-direct {v3}, Ljava/lang/StringBuilder;-><init>()V

    const-string v4, "invalid font weight "

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    invoke-virtual {v3, p1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    invoke-virtual {v3}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v3

    invoke-direct {v2, v3}, Ljava/lang/RuntimeException;-><init>(Ljava/lang/String;)V

    throw v2

    .line 164
    :cond_4
    const/16 v3, 0x1f4

    if-lt v1, v3, :cond_5

    move v0, v2

    .restart local v0    # "fontWeight":I
    :goto_1
    goto :goto_0

    .end local v0    # "fontWeight":I
    :cond_5
    const/4 v0, 0x0

    goto :goto_1
.end method

.method public setTextDecorationLine(Ljava/lang/String;)V
    .locals 8
    .param p1, "textDecorationLineString"    # Ljava/lang/String;
        .annotation runtime Ljavax/annotation/Nullable;
        .end annotation
    .end param
    .annotation runtime Lcom/facebook/react/uimanager/annotations/ReactProp;
        name = "textDecorationLine"
    .end annotation

    .prologue
    .line 175
    const/4 v1, 0x0

    .line 176
    .local v1, "isUnderlineTextDecorationSet":Z
    const/4 v0, 0x0

    .line 177
    .local v0, "isLineThroughTextDecorationSet":Z
    if-eqz p1, :cond_2

    .line 178
    const-string v4, " "

    invoke-virtual {p1, v4}, Ljava/lang/String;->split(Ljava/lang/String;)[Ljava/lang/String;

    move-result-object v5

    array-length v6, v5

    const/4 v4, 0x0

    :goto_0
    if-ge v4, v6, :cond_2

    aget-object v3, v5, v4

    .line 179
    .local v3, "textDecorationLineSubString":Ljava/lang/String;
    const-string v7, "underline"

    invoke-virtual {v7, v3}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v7

    if-eqz v7, :cond_1

    .line 180
    const/4 v1, 0x1

    .line 178
    :cond_0
    :goto_1
    add-int/lit8 v4, v4, 0x1

    goto :goto_0

    .line 181
    :cond_1
    const-string v7, "line-through"

    invoke-virtual {v7, v3}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v7

    if-eqz v7, :cond_0

    .line 182
    const/4 v0, 0x1

    goto :goto_1

    .line 187
    .end local v3    # "textDecorationLineSubString":Ljava/lang/String;
    :cond_2
    iget-object v4, p0, Lcom/facebook/react/flat/RCTVirtualText;->mFontStylingSpan:Lcom/facebook/react/flat/FontStylingSpan;

    invoke-virtual {v4}, Lcom/facebook/react/flat/FontStylingSpan;->hasUnderline()Z

    move-result v4

    if-ne v1, v4, :cond_3

    iget-object v4, p0, Lcom/facebook/react/flat/RCTVirtualText;->mFontStylingSpan:Lcom/facebook/react/flat/FontStylingSpan;

    .line 188
    invoke-virtual {v4}, Lcom/facebook/react/flat/FontStylingSpan;->hasStrikeThrough()Z

    move-result v4

    if-eq v0, v4, :cond_4

    .line 189
    :cond_3
    invoke-virtual {p0}, Lcom/facebook/react/flat/RCTVirtualText;->getSpan()Lcom/facebook/react/flat/FontStylingSpan;

    move-result-object v2

    .line 190
    .local v2, "span":Lcom/facebook/react/flat/FontStylingSpan;
    invoke-virtual {v2, v1}, Lcom/facebook/react/flat/FontStylingSpan;->setHasUnderline(Z)V

    .line 191
    invoke-virtual {v2, v0}, Lcom/facebook/react/flat/FontStylingSpan;->setHasStrikeThrough(Z)V

    .line 192
    const/4 v4, 0x1

    invoke-virtual {p0, v4}, Lcom/facebook/react/flat/RCTVirtualText;->notifyChanged(Z)V

    .line 194
    .end local v2    # "span":Lcom/facebook/react/flat/FontStylingSpan;
    :cond_4
    return-void
.end method

.method public setTextShadowColor(I)V
    .locals 1
    .param p1, "textShadowColor"    # I
    .annotation runtime Lcom/facebook/react/uimanager/annotations/ReactProp;
        customType = "Color"
        defaultInt = 0x55000000
        name = "textShadowColor"
    .end annotation

    .prologue
    .line 245
    iget-object v0, p0, Lcom/facebook/react/flat/RCTVirtualText;->mShadowStyleSpan:Lcom/facebook/react/flat/ShadowStyleSpan;

    invoke-virtual {v0}, Lcom/facebook/react/flat/ShadowStyleSpan;->getColor()I

    move-result v0

    if-eq v0, p1, :cond_0

    .line 246
    invoke-direct {p0}, Lcom/facebook/react/flat/RCTVirtualText;->getShadowSpan()Lcom/facebook/react/flat/ShadowStyleSpan;

    move-result-object v0

    invoke-virtual {v0, p1}, Lcom/facebook/react/flat/ShadowStyleSpan;->setColor(I)V

    .line 247
    const/4 v0, 0x0

    invoke-virtual {p0, v0}, Lcom/facebook/react/flat/RCTVirtualText;->notifyChanged(Z)V

    .line 249
    :cond_0
    return-void
.end method

.method public setTextShadowOffset(Lcom/facebook/react/bridge/ReadableMap;)V
    .locals 4
    .param p1, "offsetMap"    # Lcom/facebook/react/bridge/ReadableMap;
        .annotation runtime Ljavax/annotation/Nullable;
        .end annotation
    .end param
    .annotation runtime Lcom/facebook/react/uimanager/annotations/ReactProp;
        name = "textShadowOffset"
    .end annotation

    .prologue
    .line 217
    const/4 v0, 0x0

    .line 218
    .local v0, "dx":F
    const/4 v1, 0x0

    .line 219
    .local v1, "dy":F
    if-eqz p1, :cond_1

    .line 220
    const-string v2, "width"

    invoke-interface {p1, v2}, Lcom/facebook/react/bridge/ReadableMap;->hasKey(Ljava/lang/String;)Z

    move-result v2

    if-eqz v2, :cond_0

    .line 221
    const-string v2, "width"

    invoke-interface {p1, v2}, Lcom/facebook/react/bridge/ReadableMap;->getDouble(Ljava/lang/String;)D

    move-result-wide v2

    invoke-static {v2, v3}, Lcom/facebook/react/uimanager/PixelUtil;->toPixelFromDIP(D)F

    move-result v0

    .line 223
    :cond_0
    const-string v2, "height"

    invoke-interface {p1, v2}, Lcom/facebook/react/bridge/ReadableMap;->hasKey(Ljava/lang/String;)Z

    move-result v2

    if-eqz v2, :cond_1

    .line 224
    const-string v2, "height"

    invoke-interface {p1, v2}, Lcom/facebook/react/bridge/ReadableMap;->getDouble(Ljava/lang/String;)D

    move-result-wide v2

    invoke-static {v2, v3}, Lcom/facebook/react/uimanager/PixelUtil;->toPixelFromDIP(D)F

    move-result v1

    .line 228
    :cond_1
    iget-object v2, p0, Lcom/facebook/react/flat/RCTVirtualText;->mShadowStyleSpan:Lcom/facebook/react/flat/ShadowStyleSpan;

    invoke-virtual {v2, v0, v1}, Lcom/facebook/react/flat/ShadowStyleSpan;->offsetMatches(FF)Z

    move-result v2

    if-nez v2, :cond_2

    .line 229
    invoke-direct {p0}, Lcom/facebook/react/flat/RCTVirtualText;->getShadowSpan()Lcom/facebook/react/flat/ShadowStyleSpan;

    move-result-object v2

    invoke-virtual {v2, v0, v1}, Lcom/facebook/react/flat/ShadowStyleSpan;->setOffset(FF)V

    .line 230
    const/4 v2, 0x0

    invoke-virtual {p0, v2}, Lcom/facebook/react/flat/RCTVirtualText;->notifyChanged(Z)V

    .line 232
    :cond_2
    return-void
.end method

.method public setTextShadowRadius(F)V
    .locals 1
    .param p1, "textShadowRadius"    # F
    .annotation runtime Lcom/facebook/react/uimanager/annotations/ReactProp;
        name = "textShadowRadius"
    .end annotation

    .prologue
    .line 236
    invoke-static {p1}, Lcom/facebook/react/uimanager/PixelUtil;->toPixelFromDIP(F)F

    move-result p1

    .line 237
    iget-object v0, p0, Lcom/facebook/react/flat/RCTVirtualText;->mShadowStyleSpan:Lcom/facebook/react/flat/ShadowStyleSpan;

    invoke-virtual {v0}, Lcom/facebook/react/flat/ShadowStyleSpan;->getRadius()F

    move-result v0

    cmpl-float v0, v0, p1

    if-eqz v0, :cond_0

    .line 238
    invoke-direct {p0}, Lcom/facebook/react/flat/RCTVirtualText;->getShadowSpan()Lcom/facebook/react/flat/ShadowStyleSpan;

    move-result-object v0

    invoke-virtual {v0, p1}, Lcom/facebook/react/flat/ShadowStyleSpan;->setRadius(F)V

    .line 239
    const/4 v0, 0x0

    invoke-virtual {p0, v0}, Lcom/facebook/react/flat/RCTVirtualText;->notifyChanged(Z)V

    .line 241
    :cond_0
    return-void
.end method

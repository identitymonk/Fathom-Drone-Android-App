.class public Lcom/facebook/react/views/text/CustomStyleSpan;
.super Landroid/text/style/MetricAffectingSpan;
.source "CustomStyleSpan.java"


# instance fields
.field private final mAssetManager:Landroid/content/res/AssetManager;

.field private final mFontFamily:Ljava/lang/String;
    .annotation runtime Ljavax/annotation/Nullable;
    .end annotation
.end field

.field private final mStyle:I

.field private final mWeight:I


# direct methods
.method public constructor <init>(IILjava/lang/String;Landroid/content/res/AssetManager;)V
    .locals 0
    .param p1, "fontStyle"    # I
    .param p2, "fontWeight"    # I
    .param p3, "fontFamily"    # Ljava/lang/String;
        .annotation runtime Ljavax/annotation/Nullable;
        .end annotation
    .end param
    .param p4, "assetManager"    # Landroid/content/res/AssetManager;

    .prologue
    .line 44
    invoke-direct {p0}, Landroid/text/style/MetricAffectingSpan;-><init>()V

    .line 45
    iput p1, p0, Lcom/facebook/react/views/text/CustomStyleSpan;->mStyle:I

    .line 46
    iput p2, p0, Lcom/facebook/react/views/text/CustomStyleSpan;->mWeight:I

    .line 47
    iput-object p3, p0, Lcom/facebook/react/views/text/CustomStyleSpan;->mFontFamily:Ljava/lang/String;

    .line 48
    iput-object p4, p0, Lcom/facebook/react/views/text/CustomStyleSpan;->mAssetManager:Landroid/content/res/AssetManager;

    .line 49
    return-void
.end method

.method private static apply(Landroid/graphics/Paint;IILjava/lang/String;Landroid/content/res/AssetManager;)V
    .locals 5
    .param p0, "paint"    # Landroid/graphics/Paint;
    .param p1, "style"    # I
    .param p2, "weight"    # I
    .param p3, "family"    # Ljava/lang/String;
        .annotation runtime Ljavax/annotation/Nullable;
        .end annotation
    .end param
    .param p4, "assetManager"    # Landroid/content/res/AssetManager;

    .prologue
    const/4 v4, -0x1

    .line 89
    invoke-virtual {p0}, Landroid/graphics/Paint;->getTypeface()Landroid/graphics/Typeface;

    move-result-object v1

    .line 90
    .local v1, "typeface":Landroid/graphics/Typeface;
    if-nez v1, :cond_5

    .line 91
    const/4 v0, 0x0

    .line 96
    .local v0, "oldStyle":I
    :goto_0
    const/4 v2, 0x0

    .line 97
    .local v2, "want":I
    const/4 v3, 0x1

    if-eq p2, v3, :cond_0

    and-int/lit8 v3, v0, 0x1

    if-eqz v3, :cond_1

    if-ne p2, v4, :cond_1

    .line 99
    :cond_0
    or-int/lit8 v2, v2, 0x1

    .line 102
    :cond_1
    const/4 v3, 0x2

    if-eq p1, v3, :cond_2

    and-int/lit8 v3, v0, 0x2

    if-eqz v3, :cond_3

    if-ne p1, v4, :cond_3

    .line 104
    :cond_2
    or-int/lit8 v2, v2, 0x2

    .line 107
    :cond_3
    if-eqz p3, :cond_6

    .line 108
    invoke-static {}, Lcom/facebook/react/views/text/ReactFontManager;->getInstance()Lcom/facebook/react/views/text/ReactFontManager;

    move-result-object v3

    invoke-virtual {v3, p3, v2, p4}, Lcom/facebook/react/views/text/ReactFontManager;->getTypeface(Ljava/lang/String;ILandroid/content/res/AssetManager;)Landroid/graphics/Typeface;

    move-result-object v1

    .line 114
    :cond_4
    :goto_1
    if-eqz v1, :cond_7

    .line 115
    invoke-virtual {p0, v1}, Landroid/graphics/Paint;->setTypeface(Landroid/graphics/Typeface;)Landroid/graphics/Typeface;

    .line 119
    :goto_2
    return-void

    .line 93
    .end local v0    # "oldStyle":I
    .end local v2    # "want":I
    :cond_5
    invoke-virtual {v1}, Landroid/graphics/Typeface;->getStyle()I

    move-result v0

    .restart local v0    # "oldStyle":I
    goto :goto_0

    .line 109
    .restart local v2    # "want":I
    :cond_6
    if-eqz v1, :cond_4

    .line 111
    invoke-static {v1, v2}, Landroid/graphics/Typeface;->create(Landroid/graphics/Typeface;I)Landroid/graphics/Typeface;

    move-result-object v1

    goto :goto_1

    .line 117
    :cond_7
    invoke-static {v2}, Landroid/graphics/Typeface;->defaultFromStyle(I)Landroid/graphics/Typeface;

    move-result-object v3

    invoke-virtual {p0, v3}, Landroid/graphics/Paint;->setTypeface(Landroid/graphics/Typeface;)Landroid/graphics/Typeface;

    goto :goto_2
.end method


# virtual methods
.method public getFontFamily()Ljava/lang/String;
    .locals 1
    .annotation runtime Ljavax/annotation/Nullable;
    .end annotation

    .prologue
    .line 79
    iget-object v0, p0, Lcom/facebook/react/views/text/CustomStyleSpan;->mFontFamily:Ljava/lang/String;

    return-object v0
.end method

.method public getStyle()I
    .locals 2

    .prologue
    .line 65
    iget v0, p0, Lcom/facebook/react/views/text/CustomStyleSpan;->mStyle:I

    const/4 v1, -0x1

    if-ne v0, v1, :cond_0

    const/4 v0, 0x0

    :goto_0
    return v0

    :cond_0
    iget v0, p0, Lcom/facebook/react/views/text/CustomStyleSpan;->mStyle:I

    goto :goto_0
.end method

.method public getWeight()I
    .locals 2

    .prologue
    .line 72
    iget v0, p0, Lcom/facebook/react/views/text/CustomStyleSpan;->mWeight:I

    const/4 v1, -0x1

    if-ne v0, v1, :cond_0

    const/4 v0, 0x0

    :goto_0
    return v0

    :cond_0
    iget v0, p0, Lcom/facebook/react/views/text/CustomStyleSpan;->mWeight:I

    goto :goto_0
.end method

.method public updateDrawState(Landroid/text/TextPaint;)V
    .locals 4
    .param p1, "ds"    # Landroid/text/TextPaint;

    .prologue
    .line 53
    iget v0, p0, Lcom/facebook/react/views/text/CustomStyleSpan;->mStyle:I

    iget v1, p0, Lcom/facebook/react/views/text/CustomStyleSpan;->mWeight:I

    iget-object v2, p0, Lcom/facebook/react/views/text/CustomStyleSpan;->mFontFamily:Ljava/lang/String;

    iget-object v3, p0, Lcom/facebook/react/views/text/CustomStyleSpan;->mAssetManager:Landroid/content/res/AssetManager;

    invoke-static {p1, v0, v1, v2, v3}, Lcom/facebook/react/views/text/CustomStyleSpan;->apply(Landroid/graphics/Paint;IILjava/lang/String;Landroid/content/res/AssetManager;)V

    .line 54
    return-void
.end method

.method public updateMeasureState(Landroid/text/TextPaint;)V
    .locals 4
    .param p1, "paint"    # Landroid/text/TextPaint;

    .prologue
    .line 58
    iget v0, p0, Lcom/facebook/react/views/text/CustomStyleSpan;->mStyle:I

    iget v1, p0, Lcom/facebook/react/views/text/CustomStyleSpan;->mWeight:I

    iget-object v2, p0, Lcom/facebook/react/views/text/CustomStyleSpan;->mFontFamily:Ljava/lang/String;

    iget-object v3, p0, Lcom/facebook/react/views/text/CustomStyleSpan;->mAssetManager:Landroid/content/res/AssetManager;

    invoke-static {p1, v0, v1, v2, v3}, Lcom/facebook/react/views/text/CustomStyleSpan;->apply(Landroid/graphics/Paint;IILjava/lang/String;Landroid/content/res/AssetManager;)V

    .line 59
    return-void
.end method

.class public Lcom/facebook/react/views/text/ReactTextView;
.super Landroid/widget/TextView;
.source "ReactTextView.java"

# interfaces
.implements Lcom/facebook/react/uimanager/ReactCompoundView;


# static fields
.field private static final EMPTY_LAYOUT_PARAMS:Landroid/view/ViewGroup$LayoutParams;


# instance fields
.field private mContainsImages:Z

.field private mDefaultGravityHorizontal:I

.field private mDefaultGravityVertical:I

.field private mEllipsizeLocation:Landroid/text/TextUtils$TruncateAt;

.field private mLineHeight:F

.field private mNumberOfLines:I

.field private mReactBackgroundManager:Lcom/facebook/react/views/view/ReactViewBackgroundManager;

.field private mTextAlign:I

.field private mTextIsSelectable:Z


# direct methods
.method static constructor <clinit>()V
    .locals 2

    .prologue
    const/4 v1, 0x0

    .line 28
    new-instance v0, Landroid/view/ViewGroup$LayoutParams;

    invoke-direct {v0, v1, v1}, Landroid/view/ViewGroup$LayoutParams;-><init>(II)V

    sput-object v0, Lcom/facebook/react/views/text/ReactTextView;->EMPTY_LAYOUT_PARAMS:Landroid/view/ViewGroup$LayoutParams;

    return-void
.end method

.method public constructor <init>(Landroid/content/Context;)V
    .locals 2
    .param p1, "context"    # Landroid/content/Context;

    .prologue
    .line 43
    invoke-direct {p0, p1}, Landroid/widget/TextView;-><init>(Landroid/content/Context;)V

    .line 35
    const/high16 v0, 0x7fc00000    # Float.NaN

    iput v0, p0, Lcom/facebook/react/views/text/ReactTextView;->mLineHeight:F

    .line 36
    const/4 v0, 0x0

    iput v0, p0, Lcom/facebook/react/views/text/ReactTextView;->mTextAlign:I

    .line 37
    const v0, 0x7fffffff

    iput v0, p0, Lcom/facebook/react/views/text/ReactTextView;->mNumberOfLines:I

    .line 38
    sget-object v0, Landroid/text/TextUtils$TruncateAt;->END:Landroid/text/TextUtils$TruncateAt;

    iput-object v0, p0, Lcom/facebook/react/views/text/ReactTextView;->mEllipsizeLocation:Landroid/text/TextUtils$TruncateAt;

    .line 44
    new-instance v0, Lcom/facebook/react/views/view/ReactViewBackgroundManager;

    invoke-direct {v0, p0}, Lcom/facebook/react/views/view/ReactViewBackgroundManager;-><init>(Landroid/view/View;)V

    iput-object v0, p0, Lcom/facebook/react/views/text/ReactTextView;->mReactBackgroundManager:Lcom/facebook/react/views/view/ReactViewBackgroundManager;

    .line 46
    invoke-virtual {p0}, Lcom/facebook/react/views/text/ReactTextView;->getGravity()I

    move-result v0

    const v1, 0x800007

    and-int/2addr v0, v1

    iput v0, p0, Lcom/facebook/react/views/text/ReactTextView;->mDefaultGravityHorizontal:I

    .line 47
    invoke-virtual {p0}, Lcom/facebook/react/views/text/ReactTextView;->getGravity()I

    move-result v0

    and-int/lit8 v0, v0, 0x70

    iput v0, p0, Lcom/facebook/react/views/text/ReactTextView;->mDefaultGravityVertical:I

    .line 48
    return-void
.end method


# virtual methods
.method public invalidateDrawable(Landroid/graphics/drawable/Drawable;)V
    .locals 6
    .param p1, "drawable"    # Landroid/graphics/drawable/Drawable;

    .prologue
    const/4 v3, 0x0

    .line 144
    iget-boolean v4, p0, Lcom/facebook/react/views/text/ReactTextView;->mContainsImages:Z

    if-eqz v4, :cond_1

    invoke-virtual {p0}, Lcom/facebook/react/views/text/ReactTextView;->getText()Ljava/lang/CharSequence;

    move-result-object v4

    instance-of v4, v4, Landroid/text/Spanned;

    if-eqz v4, :cond_1

    .line 145
    invoke-virtual {p0}, Lcom/facebook/react/views/text/ReactTextView;->getText()Ljava/lang/CharSequence;

    move-result-object v2

    check-cast v2, Landroid/text/Spanned;

    .line 146
    .local v2, "text":Landroid/text/Spanned;
    invoke-interface {v2}, Landroid/text/Spanned;->length()I

    move-result v4

    const-class v5, Lcom/facebook/react/views/text/TextInlineImageSpan;

    invoke-interface {v2, v3, v4, v5}, Landroid/text/Spanned;->getSpans(IILjava/lang/Class;)[Ljava/lang/Object;

    move-result-object v1

    check-cast v1, [Lcom/facebook/react/views/text/TextInlineImageSpan;

    .line 147
    .local v1, "spans":[Lcom/facebook/react/views/text/TextInlineImageSpan;
    array-length v4, v1

    :goto_0
    if-ge v3, v4, :cond_1

    aget-object v0, v1, v3

    .line 148
    .local v0, "span":Lcom/facebook/react/views/text/TextInlineImageSpan;
    invoke-virtual {v0}, Lcom/facebook/react/views/text/TextInlineImageSpan;->getDrawable()Landroid/graphics/drawable/Drawable;

    move-result-object v5

    if-ne v5, p1, :cond_0

    .line 149
    invoke-virtual {p0}, Lcom/facebook/react/views/text/ReactTextView;->invalidate()V

    .line 147
    :cond_0
    add-int/lit8 v3, v3, 0x1

    goto :goto_0

    .line 153
    .end local v0    # "span":Lcom/facebook/react/views/text/TextInlineImageSpan;
    .end local v1    # "spans":[Lcom/facebook/react/views/text/TextInlineImageSpan;
    .end local v2    # "text":Landroid/text/Spanned;
    :cond_1
    invoke-super {p0, p1}, Landroid/widget/TextView;->invalidateDrawable(Landroid/graphics/drawable/Drawable;)V

    .line 154
    return-void
.end method

.method public onAttachedToWindow()V
    .locals 6

    .prologue
    const/4 v3, 0x0

    .line 182
    invoke-super {p0}, Landroid/widget/TextView;->onAttachedToWindow()V

    .line 183
    iget-boolean v4, p0, Lcom/facebook/react/views/text/ReactTextView;->mContainsImages:Z

    if-eqz v4, :cond_0

    invoke-virtual {p0}, Lcom/facebook/react/views/text/ReactTextView;->getText()Ljava/lang/CharSequence;

    move-result-object v4

    instance-of v4, v4, Landroid/text/Spanned;

    if-eqz v4, :cond_0

    .line 184
    invoke-virtual {p0}, Lcom/facebook/react/views/text/ReactTextView;->getText()Ljava/lang/CharSequence;

    move-result-object v2

    check-cast v2, Landroid/text/Spanned;

    .line 185
    .local v2, "text":Landroid/text/Spanned;
    invoke-interface {v2}, Landroid/text/Spanned;->length()I

    move-result v4

    const-class v5, Lcom/facebook/react/views/text/TextInlineImageSpan;

    invoke-interface {v2, v3, v4, v5}, Landroid/text/Spanned;->getSpans(IILjava/lang/Class;)[Ljava/lang/Object;

    move-result-object v1

    check-cast v1, [Lcom/facebook/react/views/text/TextInlineImageSpan;

    .line 186
    .local v1, "spans":[Lcom/facebook/react/views/text/TextInlineImageSpan;
    array-length v4, v1

    :goto_0
    if-ge v3, v4, :cond_0

    aget-object v0, v1, v3

    .line 187
    .local v0, "span":Lcom/facebook/react/views/text/TextInlineImageSpan;
    invoke-virtual {v0}, Lcom/facebook/react/views/text/TextInlineImageSpan;->onAttachedToWindow()V

    .line 186
    add-int/lit8 v3, v3, 0x1

    goto :goto_0

    .line 190
    .end local v0    # "span":Lcom/facebook/react/views/text/TextInlineImageSpan;
    .end local v1    # "spans":[Lcom/facebook/react/views/text/TextInlineImageSpan;
    .end local v2    # "text":Landroid/text/Spanned;
    :cond_0
    return-void
.end method

.method public onDetachedFromWindow()V
    .locals 6

    .prologue
    const/4 v3, 0x0

    .line 158
    invoke-super {p0}, Landroid/widget/TextView;->onDetachedFromWindow()V

    .line 159
    iget-boolean v4, p0, Lcom/facebook/react/views/text/ReactTextView;->mContainsImages:Z

    if-eqz v4, :cond_0

    invoke-virtual {p0}, Lcom/facebook/react/views/text/ReactTextView;->getText()Ljava/lang/CharSequence;

    move-result-object v4

    instance-of v4, v4, Landroid/text/Spanned;

    if-eqz v4, :cond_0

    .line 160
    invoke-virtual {p0}, Lcom/facebook/react/views/text/ReactTextView;->getText()Ljava/lang/CharSequence;

    move-result-object v2

    check-cast v2, Landroid/text/Spanned;

    .line 161
    .local v2, "text":Landroid/text/Spanned;
    invoke-interface {v2}, Landroid/text/Spanned;->length()I

    move-result v4

    const-class v5, Lcom/facebook/react/views/text/TextInlineImageSpan;

    invoke-interface {v2, v3, v4, v5}, Landroid/text/Spanned;->getSpans(IILjava/lang/Class;)[Ljava/lang/Object;

    move-result-object v1

    check-cast v1, [Lcom/facebook/react/views/text/TextInlineImageSpan;

    .line 162
    .local v1, "spans":[Lcom/facebook/react/views/text/TextInlineImageSpan;
    array-length v4, v1

    :goto_0
    if-ge v3, v4, :cond_0

    aget-object v0, v1, v3

    .line 163
    .local v0, "span":Lcom/facebook/react/views/text/TextInlineImageSpan;
    invoke-virtual {v0}, Lcom/facebook/react/views/text/TextInlineImageSpan;->onDetachedFromWindow()V

    .line 162
    add-int/lit8 v3, v3, 0x1

    goto :goto_0

    .line 166
    .end local v0    # "span":Lcom/facebook/react/views/text/TextInlineImageSpan;
    .end local v1    # "spans":[Lcom/facebook/react/views/text/TextInlineImageSpan;
    .end local v2    # "text":Landroid/text/Spanned;
    :cond_0
    return-void
.end method

.method public onFinishTemporaryDetach()V
    .locals 6

    .prologue
    const/4 v3, 0x0

    .line 194
    invoke-super {p0}, Landroid/widget/TextView;->onFinishTemporaryDetach()V

    .line 195
    iget-boolean v4, p0, Lcom/facebook/react/views/text/ReactTextView;->mContainsImages:Z

    if-eqz v4, :cond_0

    invoke-virtual {p0}, Lcom/facebook/react/views/text/ReactTextView;->getText()Ljava/lang/CharSequence;

    move-result-object v4

    instance-of v4, v4, Landroid/text/Spanned;

    if-eqz v4, :cond_0

    .line 196
    invoke-virtual {p0}, Lcom/facebook/react/views/text/ReactTextView;->getText()Ljava/lang/CharSequence;

    move-result-object v2

    check-cast v2, Landroid/text/Spanned;

    .line 197
    .local v2, "text":Landroid/text/Spanned;
    invoke-interface {v2}, Landroid/text/Spanned;->length()I

    move-result v4

    const-class v5, Lcom/facebook/react/views/text/TextInlineImageSpan;

    invoke-interface {v2, v3, v4, v5}, Landroid/text/Spanned;->getSpans(IILjava/lang/Class;)[Ljava/lang/Object;

    move-result-object v1

    check-cast v1, [Lcom/facebook/react/views/text/TextInlineImageSpan;

    .line 198
    .local v1, "spans":[Lcom/facebook/react/views/text/TextInlineImageSpan;
    array-length v4, v1

    :goto_0
    if-ge v3, v4, :cond_0

    aget-object v0, v1, v3

    .line 199
    .local v0, "span":Lcom/facebook/react/views/text/TextInlineImageSpan;
    invoke-virtual {v0}, Lcom/facebook/react/views/text/TextInlineImageSpan;->onFinishTemporaryDetach()V

    .line 198
    add-int/lit8 v3, v3, 0x1

    goto :goto_0

    .line 202
    .end local v0    # "span":Lcom/facebook/react/views/text/TextInlineImageSpan;
    .end local v1    # "spans":[Lcom/facebook/react/views/text/TextInlineImageSpan;
    .end local v2    # "text":Landroid/text/Spanned;
    :cond_0
    return-void
.end method

.method public onStartTemporaryDetach()V
    .locals 6

    .prologue
    const/4 v3, 0x0

    .line 170
    invoke-super {p0}, Landroid/widget/TextView;->onStartTemporaryDetach()V

    .line 171
    iget-boolean v4, p0, Lcom/facebook/react/views/text/ReactTextView;->mContainsImages:Z

    if-eqz v4, :cond_0

    invoke-virtual {p0}, Lcom/facebook/react/views/text/ReactTextView;->getText()Ljava/lang/CharSequence;

    move-result-object v4

    instance-of v4, v4, Landroid/text/Spanned;

    if-eqz v4, :cond_0

    .line 172
    invoke-virtual {p0}, Lcom/facebook/react/views/text/ReactTextView;->getText()Ljava/lang/CharSequence;

    move-result-object v2

    check-cast v2, Landroid/text/Spanned;

    .line 173
    .local v2, "text":Landroid/text/Spanned;
    invoke-interface {v2}, Landroid/text/Spanned;->length()I

    move-result v4

    const-class v5, Lcom/facebook/react/views/text/TextInlineImageSpan;

    invoke-interface {v2, v3, v4, v5}, Landroid/text/Spanned;->getSpans(IILjava/lang/Class;)[Ljava/lang/Object;

    move-result-object v1

    check-cast v1, [Lcom/facebook/react/views/text/TextInlineImageSpan;

    .line 174
    .local v1, "spans":[Lcom/facebook/react/views/text/TextInlineImageSpan;
    array-length v4, v1

    :goto_0
    if-ge v3, v4, :cond_0

    aget-object v0, v1, v3

    .line 175
    .local v0, "span":Lcom/facebook/react/views/text/TextInlineImageSpan;
    invoke-virtual {v0}, Lcom/facebook/react/views/text/TextInlineImageSpan;->onStartTemporaryDetach()V

    .line 174
    add-int/lit8 v3, v3, 0x1

    goto :goto_0

    .line 178
    .end local v0    # "span":Lcom/facebook/react/views/text/TextInlineImageSpan;
    .end local v1    # "spans":[Lcom/facebook/react/views/text/TextInlineImageSpan;
    .end local v2    # "text":Landroid/text/Spanned;
    :cond_0
    return-void
.end method

.method public reactTagForTouch(FF)I
    .locals 17
    .param p1, "touchX"    # F
    .param p2, "touchY"    # F

    .prologue
    .line 79
    invoke-virtual/range {p0 .. p0}, Lcom/facebook/react/views/text/ReactTextView;->getText()Ljava/lang/CharSequence;

    move-result-object v13

    check-cast v13, Landroid/text/Spanned;

    .line 80
    .local v13, "text":Landroid/text/Spanned;
    invoke-virtual/range {p0 .. p0}, Lcom/facebook/react/views/text/ReactTextView;->getId()I

    move-result v10

    .line 82
    .local v10, "target":I
    move/from16 v0, p1

    float-to-int v14, v0

    .line 83
    .local v14, "x":I
    move/from16 v0, p2

    float-to-int v15, v0

    .line 85
    .local v15, "y":I
    invoke-virtual/range {p0 .. p0}, Lcom/facebook/react/views/text/ReactTextView;->getLayout()Landroid/text/Layout;

    move-result-object v3

    .line 86
    .local v3, "layout":Landroid/text/Layout;
    if-nez v3, :cond_0

    move v11, v10

    .line 119
    .end local v10    # "target":I
    .local v11, "target":I
    :goto_0
    return v11

    .line 91
    .end local v11    # "target":I
    .restart local v10    # "target":I
    :cond_0
    invoke-virtual {v3, v15}, Landroid/text/Layout;->getLineForVertical(I)I

    move-result v4

    .line 93
    .local v4, "line":I
    invoke-virtual {v3, v4}, Landroid/text/Layout;->getLineLeft(I)F

    move-result v16

    move/from16 v0, v16

    float-to-int v6, v0

    .line 94
    .local v6, "lineStartX":I
    invoke-virtual {v3, v4}, Landroid/text/Layout;->getLineRight(I)F

    move-result v16

    move/from16 v0, v16

    float-to-int v5, v0

    .line 97
    .local v5, "lineEndX":I
    if-lt v14, v6, :cond_2

    if-gt v14, v5, :cond_2

    .line 98
    int-to-float v0, v14

    move/from16 v16, v0

    move/from16 v0, v16

    invoke-virtual {v3, v4, v0}, Landroid/text/Layout;->getOffsetForHorizontal(IF)I

    move-result v2

    .line 104
    .local v2, "index":I
    const-class v16, Lcom/facebook/react/views/text/ReactTagSpan;

    move-object/from16 v0, v16

    invoke-interface {v13, v2, v2, v0}, Landroid/text/Spanned;->getSpans(IILjava/lang/Class;)[Ljava/lang/Object;

    move-result-object v9

    check-cast v9, [Lcom/facebook/react/views/text/ReactTagSpan;

    .line 106
    .local v9, "spans":[Lcom/facebook/react/views/text/ReactTagSpan;
    if-eqz v9, :cond_2

    .line 107
    invoke-interface {v13}, Landroid/text/Spanned;->length()I

    move-result v12

    .line 108
    .local v12, "targetSpanTextLength":I
    const/4 v1, 0x0

    .local v1, "i":I
    :goto_1
    array-length v0, v9

    move/from16 v16, v0

    move/from16 v0, v16

    if-ge v1, v0, :cond_2

    .line 109
    aget-object v16, v9, v1

    move-object/from16 v0, v16

    invoke-interface {v13, v0}, Landroid/text/Spanned;->getSpanStart(Ljava/lang/Object;)I

    move-result v8

    .line 110
    .local v8, "spanStart":I
    aget-object v16, v9, v1

    move-object/from16 v0, v16

    invoke-interface {v13, v0}, Landroid/text/Spanned;->getSpanEnd(Ljava/lang/Object;)I

    move-result v7

    .line 111
    .local v7, "spanEnd":I
    if-le v7, v2, :cond_1

    sub-int v16, v7, v8

    move/from16 v0, v16

    if-gt v0, v12, :cond_1

    .line 112
    aget-object v16, v9, v1

    invoke-virtual/range {v16 .. v16}, Lcom/facebook/react/views/text/ReactTagSpan;->getReactTag()I

    move-result v10

    .line 113
    sub-int v12, v7, v8

    .line 108
    :cond_1
    add-int/lit8 v1, v1, 0x1

    goto :goto_1

    .end local v1    # "i":I
    .end local v2    # "index":I
    .end local v7    # "spanEnd":I
    .end local v8    # "spanStart":I
    .end local v9    # "spans":[Lcom/facebook/react/views/text/ReactTagSpan;
    .end local v12    # "targetSpanTextLength":I
    :cond_2
    move v11, v10

    .line 119
    .end local v10    # "target":I
    .restart local v11    # "target":I
    goto :goto_0
.end method

.method public setBackgroundColor(I)V
    .locals 1
    .param p1, "color"    # I

    .prologue
    .line 237
    iget-object v0, p0, Lcom/facebook/react/views/text/ReactTextView;->mReactBackgroundManager:Lcom/facebook/react/views/view/ReactViewBackgroundManager;

    invoke-virtual {v0, p1}, Lcom/facebook/react/views/view/ReactViewBackgroundManager;->setBackgroundColor(I)V

    .line 238
    return-void
.end method

.method public setBorderColor(IFF)V
    .locals 1
    .param p1, "position"    # I
    .param p2, "color"    # F
    .param p3, "alpha"    # F

    .prologue
    .line 245
    iget-object v0, p0, Lcom/facebook/react/views/text/ReactTextView;->mReactBackgroundManager:Lcom/facebook/react/views/view/ReactViewBackgroundManager;

    invoke-virtual {v0, p1, p2, p3}, Lcom/facebook/react/views/view/ReactViewBackgroundManager;->setBorderColor(IFF)V

    .line 246
    return-void
.end method

.method public setBorderRadius(F)V
    .locals 1
    .param p1, "borderRadius"    # F

    .prologue
    .line 249
    iget-object v0, p0, Lcom/facebook/react/views/text/ReactTextView;->mReactBackgroundManager:Lcom/facebook/react/views/view/ReactViewBackgroundManager;

    invoke-virtual {v0, p1}, Lcom/facebook/react/views/view/ReactViewBackgroundManager;->setBorderRadius(F)V

    .line 250
    return-void
.end method

.method public setBorderRadius(FI)V
    .locals 1
    .param p1, "borderRadius"    # F
    .param p2, "position"    # I

    .prologue
    .line 253
    iget-object v0, p0, Lcom/facebook/react/views/text/ReactTextView;->mReactBackgroundManager:Lcom/facebook/react/views/view/ReactViewBackgroundManager;

    invoke-virtual {v0, p1, p2}, Lcom/facebook/react/views/view/ReactViewBackgroundManager;->setBorderRadius(FI)V

    .line 254
    return-void
.end method

.method public setBorderStyle(Ljava/lang/String;)V
    .locals 1
    .param p1, "style"    # Ljava/lang/String;
        .annotation runtime Ljavax/annotation/Nullable;
        .end annotation
    .end param

    .prologue
    .line 257
    iget-object v0, p0, Lcom/facebook/react/views/text/ReactTextView;->mReactBackgroundManager:Lcom/facebook/react/views/view/ReactViewBackgroundManager;

    invoke-virtual {v0, p1}, Lcom/facebook/react/views/view/ReactViewBackgroundManager;->setBorderStyle(Ljava/lang/String;)V

    .line 258
    return-void
.end method

.method public setBorderWidth(IF)V
    .locals 1
    .param p1, "position"    # I
    .param p2, "width"    # F

    .prologue
    .line 241
    iget-object v0, p0, Lcom/facebook/react/views/text/ReactTextView;->mReactBackgroundManager:Lcom/facebook/react/views/view/ReactViewBackgroundManager;

    invoke-virtual {v0, p1, p2}, Lcom/facebook/react/views/view/ReactViewBackgroundManager;->setBorderWidth(IF)V

    .line 242
    return-void
.end method

.method public setEllipsizeLocation(Landroid/text/TextUtils$TruncateAt;)V
    .locals 0
    .param p1, "ellipsizeLocation"    # Landroid/text/TextUtils$TruncateAt;

    .prologue
    .line 227
    iput-object p1, p0, Lcom/facebook/react/views/text/ReactTextView;->mEllipsizeLocation:Landroid/text/TextUtils$TruncateAt;

    .line 228
    return-void
.end method

.method setGravityHorizontal(I)V
    .locals 2
    .param p1, "gravityHorizontal"    # I

    .prologue
    .line 205
    if-nez p1, :cond_0

    .line 206
    iget p1, p0, Lcom/facebook/react/views/text/ReactTextView;->mDefaultGravityHorizontal:I

    .line 209
    :cond_0
    invoke-virtual {p0}, Lcom/facebook/react/views/text/ReactTextView;->getGravity()I

    move-result v0

    and-int/lit8 v0, v0, -0x8

    const v1, -0x800008

    and-int/2addr v0, v1

    or-int/2addr v0, p1

    .line 208
    invoke-virtual {p0, v0}, Lcom/facebook/react/views/text/ReactTextView;->setGravity(I)V

    .line 211
    return-void
.end method

.method setGravityVertical(I)V
    .locals 1
    .param p1, "gravityVertical"    # I

    .prologue
    .line 214
    if-nez p1, :cond_0

    .line 215
    iget p1, p0, Lcom/facebook/react/views/text/ReactTextView;->mDefaultGravityVertical:I

    .line 217
    :cond_0
    invoke-virtual {p0}, Lcom/facebook/react/views/text/ReactTextView;->getGravity()I

    move-result v0

    and-int/lit8 v0, v0, -0x71

    or-int/2addr v0, p1

    invoke-virtual {p0, v0}, Lcom/facebook/react/views/text/ReactTextView;->setGravity(I)V

    .line 218
    return-void
.end method

.method public setNumberOfLines(I)V
    .locals 2
    .param p1, "numberOfLines"    # I

    .prologue
    const/4 v0, 0x1

    .line 221
    if-nez p1, :cond_0

    const p1, 0x7fffffff

    .end local p1    # "numberOfLines":I
    :cond_0
    iput p1, p0, Lcom/facebook/react/views/text/ReactTextView;->mNumberOfLines:I

    .line 222
    iget v1, p0, Lcom/facebook/react/views/text/ReactTextView;->mNumberOfLines:I

    if-ne v1, v0, :cond_1

    :goto_0
    invoke-virtual {p0, v0}, Lcom/facebook/react/views/text/ReactTextView;->setSingleLine(Z)V

    .line 223
    iget v0, p0, Lcom/facebook/react/views/text/ReactTextView;->mNumberOfLines:I

    invoke-virtual {p0, v0}, Lcom/facebook/react/views/text/ReactTextView;->setMaxLines(I)V

    .line 224
    return-void

    .line 222
    :cond_1
    const/4 v0, 0x0

    goto :goto_0
.end method

.method public setText(Lcom/facebook/react/views/text/ReactTextUpdate;)V
    .locals 6
    .param p1, "update"    # Lcom/facebook/react/views/text/ReactTextUpdate;

    .prologue
    .line 51
    invoke-virtual {p1}, Lcom/facebook/react/views/text/ReactTextUpdate;->containsImages()Z

    move-result v1

    iput-boolean v1, p0, Lcom/facebook/react/views/text/ReactTextView;->mContainsImages:Z

    .line 55
    invoke-virtual {p0}, Lcom/facebook/react/views/text/ReactTextView;->getLayoutParams()Landroid/view/ViewGroup$LayoutParams;

    move-result-object v1

    if-nez v1, :cond_0

    .line 56
    sget-object v1, Lcom/facebook/react/views/text/ReactTextView;->EMPTY_LAYOUT_PARAMS:Landroid/view/ViewGroup$LayoutParams;

    invoke-virtual {p0, v1}, Lcom/facebook/react/views/text/ReactTextView;->setLayoutParams(Landroid/view/ViewGroup$LayoutParams;)V

    .line 58
    :cond_0
    invoke-virtual {p1}, Lcom/facebook/react/views/text/ReactTextUpdate;->getText()Landroid/text/Spannable;

    move-result-object v1

    invoke-virtual {p0, v1}, Lcom/facebook/react/views/text/ReactTextView;->setText(Ljava/lang/CharSequence;)V

    .line 60
    invoke-virtual {p1}, Lcom/facebook/react/views/text/ReactTextUpdate;->getPaddingLeft()F

    move-result v1

    float-to-double v2, v1

    invoke-static {v2, v3}, Ljava/lang/Math;->floor(D)D

    move-result-wide v2

    double-to-int v1, v2

    .line 61
    invoke-virtual {p1}, Lcom/facebook/react/views/text/ReactTextUpdate;->getPaddingTop()F

    move-result v2

    float-to-double v2, v2

    invoke-static {v2, v3}, Ljava/lang/Math;->floor(D)D

    move-result-wide v2

    double-to-int v2, v2

    .line 62
    invoke-virtual {p1}, Lcom/facebook/react/views/text/ReactTextUpdate;->getPaddingRight()F

    move-result v3

    float-to-double v4, v3

    invoke-static {v4, v5}, Ljava/lang/Math;->floor(D)D

    move-result-wide v4

    double-to-int v3, v4

    .line 63
    invoke-virtual {p1}, Lcom/facebook/react/views/text/ReactTextUpdate;->getPaddingBottom()F

    move-result v4

    float-to-double v4, v4

    invoke-static {v4, v5}, Ljava/lang/Math;->floor(D)D

    move-result-wide v4

    double-to-int v4, v4

    .line 59
    invoke-virtual {p0, v1, v2, v3, v4}, Lcom/facebook/react/views/text/ReactTextView;->setPadding(IIII)V

    .line 65
    invoke-virtual {p1}, Lcom/facebook/react/views/text/ReactTextUpdate;->getTextAlign()I

    move-result v0

    .line 66
    .local v0, "nextTextAlign":I
    iget v1, p0, Lcom/facebook/react/views/text/ReactTextView;->mTextAlign:I

    if-eq v1, v0, :cond_1

    .line 67
    iput v0, p0, Lcom/facebook/react/views/text/ReactTextView;->mTextAlign:I

    .line 69
    :cond_1
    iget v1, p0, Lcom/facebook/react/views/text/ReactTextView;->mTextAlign:I

    invoke-virtual {p0, v1}, Lcom/facebook/react/views/text/ReactTextView;->setGravityHorizontal(I)V

    .line 70
    sget v1, Landroid/os/Build$VERSION;->SDK_INT:I

    const/16 v2, 0x17

    if-lt v1, v2, :cond_2

    .line 71
    invoke-virtual {p0}, Lcom/facebook/react/views/text/ReactTextView;->getBreakStrategy()I

    move-result v1

    invoke-virtual {p1}, Lcom/facebook/react/views/text/ReactTextUpdate;->getTextBreakStrategy()I

    move-result v2

    if-eq v1, v2, :cond_2

    .line 72
    invoke-virtual {p1}, Lcom/facebook/react/views/text/ReactTextUpdate;->getTextBreakStrategy()I

    move-result v1

    invoke-virtual {p0, v1}, Lcom/facebook/react/views/text/ReactTextView;->setBreakStrategy(I)V

    .line 75
    :cond_2
    return-void
.end method

.method public setTextIsSelectable(Z)V
    .locals 0
    .param p1, "selectable"    # Z

    .prologue
    .line 124
    iput-boolean p1, p0, Lcom/facebook/react/views/text/ReactTextView;->mTextIsSelectable:Z

    .line 125
    invoke-super {p0, p1}, Landroid/widget/TextView;->setTextIsSelectable(Z)V

    .line 126
    return-void
.end method

.method public updateView()V
    .locals 3

    .prologue
    .line 231
    iget v1, p0, Lcom/facebook/react/views/text/ReactTextView;->mNumberOfLines:I

    const v2, 0x7fffffff

    if-ne v1, v2, :cond_0

    const/4 v0, 0x0

    .line 232
    .local v0, "ellipsizeLocation":Landroid/text/TextUtils$TruncateAt;
    :goto_0
    invoke-virtual {p0, v0}, Lcom/facebook/react/views/text/ReactTextView;->setEllipsize(Landroid/text/TextUtils$TruncateAt;)V

    .line 233
    return-void

    .line 231
    .end local v0    # "ellipsizeLocation":Landroid/text/TextUtils$TruncateAt;
    :cond_0
    iget-object v0, p0, Lcom/facebook/react/views/text/ReactTextView;->mEllipsizeLocation:Landroid/text/TextUtils$TruncateAt;

    goto :goto_0
.end method

.method protected verifyDrawable(Landroid/graphics/drawable/Drawable;)Z
    .locals 6
    .param p1, "drawable"    # Landroid/graphics/drawable/Drawable;

    .prologue
    const/4 v3, 0x0

    .line 130
    iget-boolean v4, p0, Lcom/facebook/react/views/text/ReactTextView;->mContainsImages:Z

    if-eqz v4, :cond_1

    invoke-virtual {p0}, Lcom/facebook/react/views/text/ReactTextView;->getText()Ljava/lang/CharSequence;

    move-result-object v4

    instance-of v4, v4, Landroid/text/Spanned;

    if-eqz v4, :cond_1

    .line 131
    invoke-virtual {p0}, Lcom/facebook/react/views/text/ReactTextView;->getText()Ljava/lang/CharSequence;

    move-result-object v2

    check-cast v2, Landroid/text/Spanned;

    .line 132
    .local v2, "text":Landroid/text/Spanned;
    invoke-interface {v2}, Landroid/text/Spanned;->length()I

    move-result v4

    const-class v5, Lcom/facebook/react/views/text/TextInlineImageSpan;

    invoke-interface {v2, v3, v4, v5}, Landroid/text/Spanned;->getSpans(IILjava/lang/Class;)[Ljava/lang/Object;

    move-result-object v1

    check-cast v1, [Lcom/facebook/react/views/text/TextInlineImageSpan;

    .line 133
    .local v1, "spans":[Lcom/facebook/react/views/text/TextInlineImageSpan;
    array-length v4, v1

    :goto_0
    if-ge v3, v4, :cond_1

    aget-object v0, v1, v3

    .line 134
    .local v0, "span":Lcom/facebook/react/views/text/TextInlineImageSpan;
    invoke-virtual {v0}, Lcom/facebook/react/views/text/TextInlineImageSpan;->getDrawable()Landroid/graphics/drawable/Drawable;

    move-result-object v5

    if-ne v5, p1, :cond_0

    .line 135
    const/4 v3, 0x1

    .line 139
    .end local v0    # "span":Lcom/facebook/react/views/text/TextInlineImageSpan;
    .end local v1    # "spans":[Lcom/facebook/react/views/text/TextInlineImageSpan;
    .end local v2    # "text":Landroid/text/Spanned;
    :goto_1
    return v3

    .line 133
    .restart local v0    # "span":Lcom/facebook/react/views/text/TextInlineImageSpan;
    .restart local v1    # "spans":[Lcom/facebook/react/views/text/TextInlineImageSpan;
    .restart local v2    # "text":Landroid/text/Spanned;
    :cond_0
    add-int/lit8 v3, v3, 0x1

    goto :goto_0

    .line 139
    .end local v0    # "span":Lcom/facebook/react/views/text/TextInlineImageSpan;
    .end local v1    # "spans":[Lcom/facebook/react/views/text/TextInlineImageSpan;
    .end local v2    # "text":Landroid/text/Spanned;
    :cond_1
    invoke-super {p0, p1}, Landroid/widget/TextView;->verifyDrawable(Landroid/graphics/drawable/Drawable;)Z

    move-result v3

    goto :goto_1
.end method

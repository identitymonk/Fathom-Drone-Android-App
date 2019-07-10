.class public Lcom/facebook/react/flat/RCTTextInput;
.super Lcom/facebook/react/flat/RCTVirtualText;
.source "RCTTextInput.java"

# interfaces
.implements Lcom/facebook/react/flat/AndroidView;
.implements Lcom/facebook/yoga/YogaMeasureFunction;


# instance fields
.field private mEditText:Landroid/widget/EditText;
    .annotation runtime Ljavax/annotation/Nullable;
    .end annotation
.end field

.field private mJsEventCount:I

.field private mNumberOfLines:I

.field private mPaddingChanged:Z

.field private mText:Ljava/lang/String;
    .annotation runtime Ljavax/annotation/Nullable;
    .end annotation
.end field


# direct methods
.method public constructor <init>()V
    .locals 2

    .prologue
    const/4 v1, -0x1

    .line 45
    invoke-direct {p0}, Lcom/facebook/react/flat/RCTVirtualText;-><init>()V

    .line 40
    iput v1, p0, Lcom/facebook/react/flat/RCTTextInput;->mJsEventCount:I

    .line 41
    const/4 v0, 0x0

    iput-boolean v0, p0, Lcom/facebook/react/flat/RCTTextInput;->mPaddingChanged:Z

    .line 42
    iput v1, p0, Lcom/facebook/react/flat/RCTTextInput;->mNumberOfLines:I

    .line 46
    invoke-virtual {p0}, Lcom/facebook/react/flat/RCTTextInput;->forceMountToView()V

    .line 47
    invoke-virtual {p0, p0}, Lcom/facebook/react/flat/RCTTextInput;->setMeasureFunction(Lcom/facebook/yoga/YogaMeasureFunction;)V

    .line 48
    return-void
.end method


# virtual methods
.method public bridge synthetic addChildAt(Lcom/facebook/react/uimanager/ReactShadowNodeImpl;I)V
    .locals 0

    .prologue
    .line 37
    invoke-super {p0, p1, p2}, Lcom/facebook/react/flat/RCTVirtualText;->addChildAt(Lcom/facebook/react/uimanager/ReactShadowNodeImpl;I)V

    return-void
.end method

.method public bridge synthetic clipsSubviews()Z
    .locals 1

    .prologue
    .line 37
    invoke-super {p0}, Lcom/facebook/react/flat/RCTVirtualText;->clipsSubviews()Z

    move-result v0

    return v0
.end method

.method isEditable()Z
    .locals 1

    .prologue
    .line 178
    const/4 v0, 0x1

    return v0
.end method

.method public bridge synthetic isHorizontal()Z
    .locals 1

    .prologue
    .line 37
    invoke-super {p0}, Lcom/facebook/react/flat/RCTVirtualText;->isHorizontal()Z

    move-result v0

    return v0
.end method

.method public isPaddingChanged()Z
    .locals 1

    .prologue
    .line 163
    iget-boolean v0, p0, Lcom/facebook/react/flat/RCTTextInput;->mPaddingChanged:Z

    return v0
.end method

.method public isVirtual()Z
    .locals 1

    .prologue
    .line 105
    const/4 v0, 0x0

    return v0
.end method

.method public isVirtualAnchor()Z
    .locals 1

    .prologue
    .line 110
    const/4 v0, 0x1

    return v0
.end method

.method public bridge synthetic markUpdated()V
    .locals 0

    .prologue
    .line 37
    invoke-super {p0}, Lcom/facebook/react/flat/RCTVirtualText;->markUpdated()V

    return-void
.end method

.method public measure(Lcom/facebook/yoga/YogaNode;FLcom/facebook/yoga/YogaMeasureMode;FLcom/facebook/yoga/YogaMeasureMode;)J
    .locals 7
    .param p1, "node"    # Lcom/facebook/yoga/YogaNode;
    .param p2, "width"    # F
    .param p3, "widthMode"    # Lcom/facebook/yoga/YogaMeasureMode;
    .param p4, "height"    # F
    .param p5, "heightMode"    # Lcom/facebook/yoga/YogaMeasureMode;

    .prologue
    const/4 v6, -0x1

    .line 85
    iget-object v2, p0, Lcom/facebook/react/flat/RCTTextInput;->mEditText:Landroid/widget/EditText;

    invoke-static {v2}, Lcom/facebook/infer/annotation/Assertions;->assertNotNull(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Landroid/widget/EditText;

    .line 87
    .local v0, "editText":Landroid/widget/EditText;
    invoke-virtual {p0}, Lcom/facebook/react/flat/RCTTextInput;->getFontSize()I

    move-result v1

    .line 88
    .local v1, "fontSize":I
    const/4 v3, 0x0

    if-ne v1, v6, :cond_1

    const/high16 v2, 0x41600000    # 14.0f

    .line 91
    invoke-static {v2}, Lcom/facebook/react/uimanager/PixelUtil;->toPixelFromSP(F)F

    move-result v2

    float-to-double v4, v2

    invoke-static {v4, v5}, Ljava/lang/Math;->ceil(D)D

    move-result-wide v4

    double-to-int v2, v4

    int-to-float v2, v2

    .line 88
    :goto_0
    invoke-virtual {v0, v3, v2}, Landroid/widget/EditText;->setTextSize(IF)V

    .line 93
    iget v2, p0, Lcom/facebook/react/flat/RCTTextInput;->mNumberOfLines:I

    if-eq v2, v6, :cond_0

    .line 94
    iget v2, p0, Lcom/facebook/react/flat/RCTTextInput;->mNumberOfLines:I

    invoke-virtual {v0, v2}, Landroid/widget/EditText;->setLines(I)V

    .line 98
    :cond_0
    invoke-static {p2, p3}, Lcom/facebook/react/views/view/MeasureUtil;->getMeasureSpec(FLcom/facebook/yoga/YogaMeasureMode;)I

    move-result v2

    .line 99
    invoke-static {p4, p5}, Lcom/facebook/react/views/view/MeasureUtil;->getMeasureSpec(FLcom/facebook/yoga/YogaMeasureMode;)I

    move-result v3

    .line 97
    invoke-virtual {v0, v2, v3}, Landroid/widget/EditText;->measure(II)V

    .line 100
    invoke-virtual {v0}, Landroid/widget/EditText;->getMeasuredWidth()I

    move-result v2

    invoke-virtual {v0}, Landroid/widget/EditText;->getMeasuredHeight()I

    move-result v3

    invoke-static {v2, v3}, Lcom/facebook/yoga/YogaMeasureOutput;->make(II)J

    move-result-wide v2

    return-wide v2

    .line 91
    :cond_1
    int-to-float v2, v1

    goto :goto_0
.end method

.method public needsCustomLayoutForChildren()Z
    .locals 1

    .prologue
    .line 191
    const/4 v0, 0x0

    return v0
.end method

.method protected notifyChanged(Z)V
    .locals 0
    .param p1, "shouldRemeasure"    # Z

    .prologue
    .line 52
    invoke-super {p0, p1}, Lcom/facebook/react/flat/RCTVirtualText;->notifyChanged(Z)V

    .line 54
    invoke-virtual {p0}, Lcom/facebook/react/flat/RCTTextInput;->markUpdated()V

    .line 55
    return-void
.end method

.method public onCollectExtraUpdates(Lcom/facebook/react/uimanager/UIViewOperationQueue;)V
    .locals 9
    .param p1, "uiViewOperationQueue"    # Lcom/facebook/react/uimanager/UIViewOperationQueue;

    .prologue
    const/4 v8, -0x1

    .line 120
    invoke-super {p0, p1}, Lcom/facebook/react/flat/RCTVirtualText;->onCollectExtraUpdates(Lcom/facebook/react/uimanager/UIViewOperationQueue;)V

    .line 121
    iget v1, p0, Lcom/facebook/react/flat/RCTTextInput;->mJsEventCount:I

    if-eq v1, v8, :cond_0

    .line 122
    new-instance v0, Lcom/facebook/react/views/text/ReactTextUpdate;

    .line 124
    invoke-virtual {p0}, Lcom/facebook/react/flat/RCTTextInput;->getText()Landroid/text/SpannableStringBuilder;

    move-result-object v1

    iget v2, p0, Lcom/facebook/react/flat/RCTTextInput;->mJsEventCount:I

    const/4 v3, 0x0

    const/4 v4, 0x4

    .line 127
    invoke-virtual {p0, v4}, Lcom/facebook/react/flat/RCTTextInput;->getPadding(I)F

    move-result v4

    const/4 v5, 0x1

    .line 128
    invoke-virtual {p0, v5}, Lcom/facebook/react/flat/RCTTextInput;->getPadding(I)F

    move-result v5

    const/4 v6, 0x5

    .line 129
    invoke-virtual {p0, v6}, Lcom/facebook/react/flat/RCTTextInput;->getPadding(I)F

    move-result v6

    const/4 v7, 0x3

    .line 130
    invoke-virtual {p0, v7}, Lcom/facebook/react/flat/RCTTextInput;->getPadding(I)F

    move-result v7

    invoke-direct/range {v0 .. v8}, Lcom/facebook/react/views/text/ReactTextUpdate;-><init>(Landroid/text/Spannable;IZFFFFI)V

    .line 133
    .local v0, "reactTextUpdate":Lcom/facebook/react/views/text/ReactTextUpdate;
    invoke-virtual {p0}, Lcom/facebook/react/flat/RCTTextInput;->getReactTag()I

    move-result v1

    invoke-virtual {p1, v1, v0}, Lcom/facebook/react/uimanager/UIViewOperationQueue;->enqueueUpdateExtraData(ILjava/lang/Object;)V

    .line 135
    .end local v0    # "reactTextUpdate":Lcom/facebook/react/views/text/ReactTextUpdate;
    :cond_0
    return-void
.end method

.method protected performCollectText(Landroid/text/SpannableStringBuilder;)V
    .locals 1
    .param p1, "builder"    # Landroid/text/SpannableStringBuilder;

    .prologue
    .line 183
    iget-object v0, p0, Lcom/facebook/react/flat/RCTTextInput;->mText:Ljava/lang/String;

    if-eqz v0, :cond_0

    .line 184
    iget-object v0, p0, Lcom/facebook/react/flat/RCTTextInput;->mText:Ljava/lang/String;

    invoke-virtual {p1, v0}, Landroid/text/SpannableStringBuilder;->append(Ljava/lang/CharSequence;)Landroid/text/SpannableStringBuilder;

    .line 186
    :cond_0
    invoke-super {p0, p1}, Lcom/facebook/react/flat/RCTVirtualText;->performCollectText(Landroid/text/SpannableStringBuilder;)V

    .line 187
    return-void
.end method

.method public resetPaddingChanged()V
    .locals 1

    .prologue
    .line 168
    const/4 v0, 0x0

    iput-boolean v0, p0, Lcom/facebook/react/flat/RCTTextInput;->mPaddingChanged:Z

    .line 169
    return-void
.end method

.method public setBackgroundColor(I)V
    .locals 0
    .param p1, "backgroundColor"    # I

    .prologue
    .line 116
    return-void
.end method

.method public bridge synthetic setColor(D)V
    .locals 1
    .annotation runtime Lcom/facebook/react/uimanager/annotations/ReactProp;
        defaultDouble = NaN
        name = "color"
    .end annotation

    .prologue
    .line 37
    invoke-super {p0, p1, p2}, Lcom/facebook/react/flat/RCTVirtualText;->setColor(D)V

    return-void
.end method

.method public bridge synthetic setFontFamily(Ljava/lang/String;)V
    .locals 0
    .param p1    # Ljava/lang/String;
        .annotation runtime Ljavax/annotation/Nullable;
        .end annotation
    .end param
    .annotation runtime Lcom/facebook/react/uimanager/annotations/ReactProp;
        name = "fontFamily"
    .end annotation

    .prologue
    .line 37
    invoke-super {p0, p1}, Lcom/facebook/react/flat/RCTVirtualText;->setFontFamily(Ljava/lang/String;)V

    return-void
.end method

.method public bridge synthetic setFontSize(F)V
    .locals 0
    .annotation runtime Lcom/facebook/react/uimanager/annotations/ReactProp;
        defaultFloat = NaNf
        name = "fontSize"
    .end annotation

    .prologue
    .line 37
    invoke-super {p0, p1}, Lcom/facebook/react/flat/RCTVirtualText;->setFontSize(F)V

    return-void
.end method

.method public bridge synthetic setFontStyle(Ljava/lang/String;)V
    .locals 0
    .param p1    # Ljava/lang/String;
        .annotation runtime Ljavax/annotation/Nullable;
        .end annotation
    .end param
    .annotation runtime Lcom/facebook/react/uimanager/annotations/ReactProp;
        name = "fontStyle"
    .end annotation

    .prologue
    .line 37
    invoke-super {p0, p1}, Lcom/facebook/react/flat/RCTVirtualText;->setFontStyle(Ljava/lang/String;)V

    return-void
.end method

.method public bridge synthetic setFontWeight(Ljava/lang/String;)V
    .locals 0
    .param p1    # Ljava/lang/String;
        .annotation runtime Ljavax/annotation/Nullable;
        .end annotation
    .end param
    .annotation runtime Lcom/facebook/react/uimanager/annotations/ReactProp;
        name = "fontWeight"
    .end annotation

    .prologue
    .line 37
    invoke-super {p0, p1}, Lcom/facebook/react/flat/RCTVirtualText;->setFontWeight(Ljava/lang/String;)V

    return-void
.end method

.method public setMostRecentEventCount(I)V
    .locals 0
    .param p1, "mostRecentEventCount"    # I
    .annotation runtime Lcom/facebook/react/uimanager/annotations/ReactProp;
        name = "mostRecentEventCount"
    .end annotation

    .prologue
    .line 139
    iput p1, p0, Lcom/facebook/react/flat/RCTTextInput;->mJsEventCount:I

    .line 140
    return-void
.end method

.method public setNumberOfLines(I)V
    .locals 1
    .param p1, "numberOfLines"    # I
    .annotation runtime Lcom/facebook/react/uimanager/annotations/ReactProp;
        defaultInt = 0x7fffffff
        name = "numberOfLines"
    .end annotation

    .prologue
    .line 144
    iput p1, p0, Lcom/facebook/react/flat/RCTTextInput;->mNumberOfLines:I

    .line 145
    const/4 v0, 0x1

    invoke-virtual {p0, v0}, Lcom/facebook/react/flat/RCTTextInput;->notifyChanged(Z)V

    .line 146
    return-void
.end method

.method public bridge synthetic setOverflow(Ljava/lang/String;)V
    .locals 0

    .prologue
    .line 37
    invoke-super {p0, p1}, Lcom/facebook/react/flat/RCTVirtualText;->setOverflow(Ljava/lang/String;)V

    return-void
.end method

.method public setPadding(IF)V
    .locals 1
    .param p1, "spacingType"    # I
    .param p2, "padding"    # F

    .prologue
    .line 156
    invoke-super {p0, p1, p2}, Lcom/facebook/react/flat/RCTVirtualText;->setPadding(IF)V

    .line 157
    const/4 v0, 0x1

    iput-boolean v0, p0, Lcom/facebook/react/flat/RCTTextInput;->mPaddingChanged:Z

    .line 158
    invoke-virtual {p0}, Lcom/facebook/react/flat/RCTTextInput;->dirty()V

    .line 159
    return-void
.end method

.method public setText(Ljava/lang/String;)V
    .locals 1
    .param p1, "text"    # Ljava/lang/String;
        .annotation runtime Ljavax/annotation/Nullable;
        .end annotation
    .end param
    .annotation runtime Lcom/facebook/react/uimanager/annotations/ReactProp;
        name = "text"
    .end annotation

    .prologue
    .line 150
    iput-object p1, p0, Lcom/facebook/react/flat/RCTTextInput;->mText:Ljava/lang/String;

    .line 151
    const/4 v0, 0x1

    invoke-virtual {p0, v0}, Lcom/facebook/react/flat/RCTTextInput;->notifyChanged(Z)V

    .line 152
    return-void
.end method

.method public bridge synthetic setTextDecorationLine(Ljava/lang/String;)V
    .locals 0
    .param p1    # Ljava/lang/String;
        .annotation runtime Ljavax/annotation/Nullable;
        .end annotation
    .end param
    .annotation runtime Lcom/facebook/react/uimanager/annotations/ReactProp;
        name = "textDecorationLine"
    .end annotation

    .prologue
    .line 37
    invoke-super {p0, p1}, Lcom/facebook/react/flat/RCTVirtualText;->setTextDecorationLine(Ljava/lang/String;)V

    return-void
.end method

.method public bridge synthetic setTextShadowColor(I)V
    .locals 0
    .annotation runtime Lcom/facebook/react/uimanager/annotations/ReactProp;
        customType = "Color"
        defaultInt = 0x55000000
        name = "textShadowColor"
    .end annotation

    .prologue
    .line 37
    invoke-super {p0, p1}, Lcom/facebook/react/flat/RCTVirtualText;->setTextShadowColor(I)V

    return-void
.end method

.method public bridge synthetic setTextShadowOffset(Lcom/facebook/react/bridge/ReadableMap;)V
    .locals 0
    .param p1    # Lcom/facebook/react/bridge/ReadableMap;
        .annotation runtime Ljavax/annotation/Nullable;
        .end annotation
    .end param
    .annotation runtime Lcom/facebook/react/uimanager/annotations/ReactProp;
        name = "textShadowOffset"
    .end annotation

    .prologue
    .line 37
    invoke-super {p0, p1}, Lcom/facebook/react/flat/RCTVirtualText;->setTextShadowOffset(Lcom/facebook/react/bridge/ReadableMap;)V

    return-void
.end method

.method public bridge synthetic setTextShadowRadius(F)V
    .locals 0
    .annotation runtime Lcom/facebook/react/uimanager/annotations/ReactProp;
        name = "textShadowRadius"
    .end annotation

    .prologue
    .line 37
    invoke-super {p0, p1}, Lcom/facebook/react/flat/RCTVirtualText;->setTextShadowRadius(F)V

    return-void
.end method

.method public setThemedContext(Lcom/facebook/react/uimanager/ThemedReactContext;)V
    .locals 4
    .param p1, "themedContext"    # Lcom/facebook/react/uimanager/ThemedReactContext;
    .annotation build Landroid/annotation/TargetApi;
        value = 0x11
    .end annotation

    .prologue
    const/4 v3, -0x2

    const/4 v2, 0x0

    .line 60
    invoke-super {p0, p1}, Lcom/facebook/react/flat/RCTVirtualText;->setThemedContext(Lcom/facebook/react/uimanager/ThemedReactContext;)V

    .line 62
    new-instance v0, Landroid/widget/EditText;

    invoke-direct {v0, p1}, Landroid/widget/EditText;-><init>(Landroid/content/Context;)V

    iput-object v0, p0, Lcom/facebook/react/flat/RCTTextInput;->mEditText:Landroid/widget/EditText;

    .line 65
    iget-object v0, p0, Lcom/facebook/react/flat/RCTTextInput;->mEditText:Landroid/widget/EditText;

    new-instance v1, Landroid/view/ViewGroup$LayoutParams;

    invoke-direct {v1, v3, v3}, Landroid/view/ViewGroup$LayoutParams;-><init>(II)V

    invoke-virtual {v0, v1}, Landroid/widget/EditText;->setLayoutParams(Landroid/view/ViewGroup$LayoutParams;)V

    .line 70
    const/4 v0, 0x4

    iget-object v1, p0, Lcom/facebook/react/flat/RCTTextInput;->mEditText:Landroid/widget/EditText;

    invoke-virtual {v1}, Landroid/widget/EditText;->getPaddingStart()I

    move-result v1

    int-to-float v1, v1

    invoke-virtual {p0, v0, v1}, Lcom/facebook/react/flat/RCTTextInput;->setDefaultPadding(IF)V

    .line 71
    const/4 v0, 0x1

    iget-object v1, p0, Lcom/facebook/react/flat/RCTTextInput;->mEditText:Landroid/widget/EditText;

    invoke-virtual {v1}, Landroid/widget/EditText;->getPaddingTop()I

    move-result v1

    int-to-float v1, v1

    invoke-virtual {p0, v0, v1}, Lcom/facebook/react/flat/RCTTextInput;->setDefaultPadding(IF)V

    .line 72
    const/4 v0, 0x5

    iget-object v1, p0, Lcom/facebook/react/flat/RCTTextInput;->mEditText:Landroid/widget/EditText;

    invoke-virtual {v1}, Landroid/widget/EditText;->getPaddingEnd()I

    move-result v1

    int-to-float v1, v1

    invoke-virtual {p0, v0, v1}, Lcom/facebook/react/flat/RCTTextInput;->setDefaultPadding(IF)V

    .line 73
    const/4 v0, 0x3

    iget-object v1, p0, Lcom/facebook/react/flat/RCTTextInput;->mEditText:Landroid/widget/EditText;

    invoke-virtual {v1}, Landroid/widget/EditText;->getPaddingBottom()I

    move-result v1

    int-to-float v1, v1

    invoke-virtual {p0, v0, v1}, Lcom/facebook/react/flat/RCTTextInput;->setDefaultPadding(IF)V

    .line 74
    iget-object v0, p0, Lcom/facebook/react/flat/RCTTextInput;->mEditText:Landroid/widget/EditText;

    invoke-virtual {v0, v2, v2, v2, v2}, Landroid/widget/EditText;->setPadding(IIII)V

    .line 75
    return-void
.end method

.method shouldAllowEmptySpans()Z
    .locals 1

    .prologue
    .line 173
    const/4 v0, 0x1

    return v0
.end method

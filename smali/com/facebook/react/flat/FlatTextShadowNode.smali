.class abstract Lcom/facebook/react/flat/FlatTextShadowNode;
.super Lcom/facebook/react/flat/FlatShadowNode;
.source "FlatTextShadowNode.java"


# instance fields
.field private mTextBegin:I

.field private mTextEnd:I


# direct methods
.method constructor <init>()V
    .locals 0

    .prologue
    .line 19
    invoke-direct {p0}, Lcom/facebook/react/flat/FlatShadowNode;-><init>()V

    return-void
.end method


# virtual methods
.method final applySpans(Landroid/text/SpannableStringBuilder;Z)V
    .locals 2
    .param p1, "builder"    # Landroid/text/SpannableStringBuilder;
    .param p2, "isEditable"    # Z

    .prologue
    .line 71
    iget v0, p0, Lcom/facebook/react/flat/FlatTextShadowNode;->mTextBegin:I

    iget v1, p0, Lcom/facebook/react/flat/FlatTextShadowNode;->mTextEnd:I

    if-ne v0, v1, :cond_0

    invoke-virtual {p0}, Lcom/facebook/react/flat/FlatTextShadowNode;->shouldAllowEmptySpans()Z

    move-result v0

    if-eqz v0, :cond_1

    .line 72
    :cond_0
    iget v0, p0, Lcom/facebook/react/flat/FlatTextShadowNode;->mTextBegin:I

    iget v1, p0, Lcom/facebook/react/flat/FlatTextShadowNode;->mTextEnd:I

    invoke-virtual {p0, p1, v0, v1, p2}, Lcom/facebook/react/flat/FlatTextShadowNode;->performApplySpans(Landroid/text/SpannableStringBuilder;IIZ)V

    .line 74
    :cond_1
    return-void
.end method

.method final collectText(Landroid/text/SpannableStringBuilder;)V
    .locals 1
    .param p1, "builder"    # Landroid/text/SpannableStringBuilder;

    .prologue
    .line 45
    invoke-virtual {p1}, Landroid/text/SpannableStringBuilder;->length()I

    move-result v0

    iput v0, p0, Lcom/facebook/react/flat/FlatTextShadowNode;->mTextBegin:I

    .line 46
    invoke-virtual {p0, p1}, Lcom/facebook/react/flat/FlatTextShadowNode;->performCollectText(Landroid/text/SpannableStringBuilder;)V

    .line 47
    invoke-virtual {p1}, Landroid/text/SpannableStringBuilder;->length()I

    move-result v0

    iput v0, p0, Lcom/facebook/react/flat/FlatTextShadowNode;->mTextEnd:I

    .line 48
    return-void
.end method

.method isEditable()Z
    .locals 1

    .prologue
    .line 63
    const/4 v0, 0x0

    return v0
.end method

.method public isVirtual()Z
    .locals 1

    .prologue
    .line 37
    const/4 v0, 0x1

    return v0
.end method

.method protected notifyChanged(Z)V
    .locals 2
    .param p1, "shouldRemeasure"    # Z

    .prologue
    .line 29
    invoke-virtual {p0}, Lcom/facebook/react/flat/FlatTextShadowNode;->getParent()Lcom/facebook/react/uimanager/ReactShadowNodeImpl;

    move-result-object v0

    .line 30
    .local v0, "parent":Lcom/facebook/react/uimanager/ReactShadowNode;
    instance-of v1, v0, Lcom/facebook/react/flat/FlatTextShadowNode;

    if-eqz v1, :cond_0

    .line 31
    check-cast v0, Lcom/facebook/react/flat/FlatTextShadowNode;

    .end local v0    # "parent":Lcom/facebook/react/uimanager/ReactShadowNode;
    invoke-virtual {v0, p1}, Lcom/facebook/react/flat/FlatTextShadowNode;->notifyChanged(Z)V

    .line 33
    :cond_0
    return-void
.end method

.method protected abstract performApplySpans(Landroid/text/SpannableStringBuilder;IIZ)V
.end method

.method protected abstract performCollectAttachDetachListeners(Lcom/facebook/react/flat/StateBuilder;)V
.end method

.method protected abstract performCollectText(Landroid/text/SpannableStringBuilder;)V
.end method

.method shouldAllowEmptySpans()Z
    .locals 1

    .prologue
    .line 59
    const/4 v0, 0x0

    return v0
.end method

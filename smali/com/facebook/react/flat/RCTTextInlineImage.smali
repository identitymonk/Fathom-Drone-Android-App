.class Lcom/facebook/react/flat/RCTTextInlineImage;
.super Lcom/facebook/react/flat/FlatTextShadowNode;
.source "RCTTextInlineImage.java"


# instance fields
.field private mInlineImageSpan:Lcom/facebook/react/flat/InlineImageSpanWithPipeline;


# direct methods
.method constructor <init>()V
    .locals 1

    .prologue
    .line 25
    invoke-direct {p0}, Lcom/facebook/react/flat/FlatTextShadowNode;-><init>()V

    .line 27
    new-instance v0, Lcom/facebook/react/flat/InlineImageSpanWithPipeline;

    invoke-direct {v0}, Lcom/facebook/react/flat/InlineImageSpanWithPipeline;-><init>()V

    iput-object v0, p0, Lcom/facebook/react/flat/RCTTextInlineImage;->mInlineImageSpan:Lcom/facebook/react/flat/InlineImageSpanWithPipeline;

    return-void
.end method

.method private getMutableSpan()Lcom/facebook/react/flat/InlineImageSpanWithPipeline;
    .locals 1

    .prologue
    .line 85
    iget-object v0, p0, Lcom/facebook/react/flat/RCTTextInlineImage;->mInlineImageSpan:Lcom/facebook/react/flat/InlineImageSpanWithPipeline;

    invoke-virtual {v0}, Lcom/facebook/react/flat/InlineImageSpanWithPipeline;->isFrozen()Z

    move-result v0

    if-eqz v0, :cond_0

    .line 86
    iget-object v0, p0, Lcom/facebook/react/flat/RCTTextInlineImage;->mInlineImageSpan:Lcom/facebook/react/flat/InlineImageSpanWithPipeline;

    invoke-virtual {v0}, Lcom/facebook/react/flat/InlineImageSpanWithPipeline;->mutableCopy()Lcom/facebook/react/flat/InlineImageSpanWithPipeline;

    move-result-object v0

    iput-object v0, p0, Lcom/facebook/react/flat/RCTTextInlineImage;->mInlineImageSpan:Lcom/facebook/react/flat/InlineImageSpanWithPipeline;

    .line 88
    :cond_0
    iget-object v0, p0, Lcom/facebook/react/flat/RCTTextInlineImage;->mInlineImageSpan:Lcom/facebook/react/flat/InlineImageSpanWithPipeline;

    return-object v0
.end method


# virtual methods
.method protected performApplySpans(Landroid/text/SpannableStringBuilder;IIZ)V
    .locals 2
    .param p1, "builder"    # Landroid/text/SpannableStringBuilder;
    .param p2, "begin"    # I
    .param p3, "end"    # I
    .param p4, "isEditable"    # Z

    .prologue
    .line 60
    iget-object v0, p0, Lcom/facebook/react/flat/RCTTextInlineImage;->mInlineImageSpan:Lcom/facebook/react/flat/InlineImageSpanWithPipeline;

    invoke-virtual {v0}, Lcom/facebook/react/flat/InlineImageSpanWithPipeline;->freeze()V

    .line 61
    iget-object v0, p0, Lcom/facebook/react/flat/RCTTextInlineImage;->mInlineImageSpan:Lcom/facebook/react/flat/InlineImageSpanWithPipeline;

    const/16 v1, 0x11

    invoke-virtual {p1, v0, p2, p3, v1}, Landroid/text/SpannableStringBuilder;->setSpan(Ljava/lang/Object;III)V

    .line 66
    return-void
.end method

.method protected performCollectAttachDetachListeners(Lcom/facebook/react/flat/StateBuilder;)V
    .locals 1
    .param p1, "stateBuilder"    # Lcom/facebook/react/flat/StateBuilder;

    .prologue
    .line 71
    iget-object v0, p0, Lcom/facebook/react/flat/RCTTextInlineImage;->mInlineImageSpan:Lcom/facebook/react/flat/InlineImageSpanWithPipeline;

    invoke-virtual {p1, v0}, Lcom/facebook/react/flat/StateBuilder;->addAttachDetachListener(Lcom/facebook/react/flat/AttachDetachListener;)V

    .line 72
    return-void
.end method

.method protected performCollectText(Landroid/text/SpannableStringBuilder;)V
    .locals 1
    .param p1, "builder"    # Landroid/text/SpannableStringBuilder;

    .prologue
    .line 51
    const-string v0, "I"

    invoke-virtual {p1, v0}, Landroid/text/SpannableStringBuilder;->append(Ljava/lang/CharSequence;)Landroid/text/SpannableStringBuilder;

    .line 52
    return-void
.end method

.method public setSource(Lcom/facebook/react/bridge/ReadableArray;)V
    .locals 5
    .param p1, "sources"    # Lcom/facebook/react/bridge/ReadableArray;
        .annotation runtime Ljavax/annotation/Nullable;
        .end annotation
    .end param
    .annotation runtime Lcom/facebook/react/uimanager/annotations/ReactProp;
        name = "src"
    .end annotation

    .prologue
    const/4 v2, 0x0

    .line 76
    if-eqz p1, :cond_0

    .line 77
    invoke-interface {p1}, Lcom/facebook/react/bridge/ReadableArray;->size()I

    move-result v3

    if-nez v3, :cond_1

    :cond_0
    move-object v1, v2

    .line 78
    .local v1, "source":Ljava/lang/String;
    :goto_0
    if-nez v1, :cond_2

    move-object v0, v2

    .line 80
    .local v0, "imageSource":Lcom/facebook/react/views/imagehelper/ImageSource;
    :goto_1
    invoke-direct {p0}, Lcom/facebook/react/flat/RCTTextInlineImage;->getMutableSpan()Lcom/facebook/react/flat/InlineImageSpanWithPipeline;

    move-result-object v3

    if-nez v0, :cond_3

    :goto_2
    invoke-virtual {v3, v2}, Lcom/facebook/react/flat/InlineImageSpanWithPipeline;->setImageRequest(Lcom/facebook/imagepipeline/request/ImageRequest;)V

    .line 82
    return-void

    .line 77
    .end local v0    # "imageSource":Lcom/facebook/react/views/imagehelper/ImageSource;
    .end local v1    # "source":Ljava/lang/String;
    :cond_1
    const/4 v3, 0x0

    invoke-interface {p1, v3}, Lcom/facebook/react/bridge/ReadableArray;->getMap(I)Lcom/facebook/react/bridge/ReadableMap;

    move-result-object v3

    const-string v4, "uri"

    invoke-interface {v3, v4}, Lcom/facebook/react/bridge/ReadableMap;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v1

    goto :goto_0

    .line 78
    .restart local v1    # "source":Ljava/lang/String;
    :cond_2
    new-instance v0, Lcom/facebook/react/views/imagehelper/ImageSource;

    .line 79
    invoke-virtual {p0}, Lcom/facebook/react/flat/RCTTextInlineImage;->getThemedContext()Lcom/facebook/react/uimanager/ThemedReactContext;

    move-result-object v3

    invoke-direct {v0, v3, v1}, Lcom/facebook/react/views/imagehelper/ImageSource;-><init>(Landroid/content/Context;Ljava/lang/String;)V

    goto :goto_1

    .line 81
    .restart local v0    # "imageSource":Lcom/facebook/react/views/imagehelper/ImageSource;
    :cond_3
    invoke-virtual {v0}, Lcom/facebook/react/views/imagehelper/ImageSource;->getUri()Landroid/net/Uri;

    move-result-object v2

    invoke-static {v2}, Lcom/facebook/imagepipeline/request/ImageRequestBuilder;->newBuilderWithSource(Landroid/net/Uri;)Lcom/facebook/imagepipeline/request/ImageRequestBuilder;

    move-result-object v2

    invoke-virtual {v2}, Lcom/facebook/imagepipeline/request/ImageRequestBuilder;->build()Lcom/facebook/imagepipeline/request/ImageRequest;

    move-result-object v2

    goto :goto_2
.end method

.method public setStyleHeight(F)V
    .locals 1
    .param p1, "height"    # F

    .prologue
    .line 41
    invoke-super {p0, p1}, Lcom/facebook/react/flat/FlatTextShadowNode;->setStyleHeight(F)V

    .line 43
    iget-object v0, p0, Lcom/facebook/react/flat/RCTTextInlineImage;->mInlineImageSpan:Lcom/facebook/react/flat/InlineImageSpanWithPipeline;

    invoke-virtual {v0}, Lcom/facebook/react/flat/InlineImageSpanWithPipeline;->getHeight()F

    move-result v0

    cmpl-float v0, v0, p1

    if-eqz v0, :cond_0

    .line 44
    invoke-direct {p0}, Lcom/facebook/react/flat/RCTTextInlineImage;->getMutableSpan()Lcom/facebook/react/flat/InlineImageSpanWithPipeline;

    move-result-object v0

    invoke-virtual {v0, p1}, Lcom/facebook/react/flat/InlineImageSpanWithPipeline;->setHeight(F)V

    .line 45
    const/4 v0, 0x1

    invoke-virtual {p0, v0}, Lcom/facebook/react/flat/RCTTextInlineImage;->notifyChanged(Z)V

    .line 47
    :cond_0
    return-void
.end method

.method public setStyleWidth(F)V
    .locals 1
    .param p1, "width"    # F

    .prologue
    .line 31
    invoke-super {p0, p1}, Lcom/facebook/react/flat/FlatTextShadowNode;->setStyleWidth(F)V

    .line 33
    iget-object v0, p0, Lcom/facebook/react/flat/RCTTextInlineImage;->mInlineImageSpan:Lcom/facebook/react/flat/InlineImageSpanWithPipeline;

    invoke-virtual {v0}, Lcom/facebook/react/flat/InlineImageSpanWithPipeline;->getWidth()F

    move-result v0

    cmpl-float v0, v0, p1

    if-eqz v0, :cond_0

    .line 34
    invoke-direct {p0}, Lcom/facebook/react/flat/RCTTextInlineImage;->getMutableSpan()Lcom/facebook/react/flat/InlineImageSpanWithPipeline;

    move-result-object v0

    invoke-virtual {v0, p1}, Lcom/facebook/react/flat/InlineImageSpanWithPipeline;->setWidth(F)V

    .line 35
    const/4 v0, 0x1

    invoke-virtual {p0, v0}, Lcom/facebook/react/flat/RCTTextInlineImage;->notifyChanged(Z)V

    .line 37
    :cond_0
    return-void
.end method

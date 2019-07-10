.class public abstract Lcom/facebook/react/views/text/TextInlineImageSpan;
.super Landroid/text/style/ReplacementSpan;
.source "TextInlineImageSpan.java"


# direct methods
.method public constructor <init>()V
    .locals 0

    .prologue
    .line 23
    invoke-direct {p0}, Landroid/text/style/ReplacementSpan;-><init>()V

    return-void
.end method

.method public static possiblyUpdateInlineImageSpans(Landroid/text/Spannable;Landroid/widget/TextView;)V
    .locals 5
    .param p0, "spannable"    # Landroid/text/Spannable;
    .param p1, "view"    # Landroid/widget/TextView;

    .prologue
    const/4 v2, 0x0

    .line 33
    .line 34
    invoke-interface {p0}, Landroid/text/Spannable;->length()I

    move-result v3

    const-class v4, Lcom/facebook/react/views/text/TextInlineImageSpan;

    invoke-interface {p0, v2, v3, v4}, Landroid/text/Spannable;->getSpans(IILjava/lang/Class;)[Ljava/lang/Object;

    move-result-object v1

    check-cast v1, [Lcom/facebook/react/views/text/TextInlineImageSpan;

    .line 35
    .local v1, "spans":[Lcom/facebook/react/views/text/TextInlineImageSpan;
    array-length v3, v1

    :goto_0
    if-ge v2, v3, :cond_0

    aget-object v0, v1, v2

    .line 36
    .local v0, "span":Lcom/facebook/react/views/text/TextInlineImageSpan;
    invoke-virtual {v0}, Lcom/facebook/react/views/text/TextInlineImageSpan;->onAttachedToWindow()V

    .line 37
    invoke-virtual {v0, p1}, Lcom/facebook/react/views/text/TextInlineImageSpan;->setTextView(Landroid/widget/TextView;)V

    .line 35
    add-int/lit8 v2, v2, 0x1

    goto :goto_0

    .line 39
    .end local v0    # "span":Lcom/facebook/react/views/text/TextInlineImageSpan;
    :cond_0
    return-void
.end method


# virtual methods
.method public abstract getDrawable()Landroid/graphics/drawable/Drawable;
    .annotation runtime Ljavax/annotation/Nullable;
    .end annotation
.end method

.method public abstract getHeight()I
.end method

.method public abstract getWidth()I
.end method

.method public abstract onAttachedToWindow()V
.end method

.method public abstract onDetachedFromWindow()V
.end method

.method public abstract onFinishTemporaryDetach()V
.end method

.method public abstract onStartTemporaryDetach()V
.end method

.method public abstract setTextView(Landroid/widget/TextView;)V
.end method

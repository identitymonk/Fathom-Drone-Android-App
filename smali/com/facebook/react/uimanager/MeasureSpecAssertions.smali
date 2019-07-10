.class public Lcom/facebook/react/uimanager/MeasureSpecAssertions;
.super Ljava/lang/Object;
.source "MeasureSpecAssertions.java"


# direct methods
.method public constructor <init>()V
    .locals 0

    .prologue
    .line 17
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method

.method public static final assertExplicitMeasureSpec(II)V
    .locals 4
    .param p0, "widthMeasureSpec"    # I
    .param p1, "heightMeasureSpec"    # I

    .prologue
    .line 20
    invoke-static {p0}, Landroid/view/View$MeasureSpec;->getMode(I)I

    move-result v1

    .line 21
    .local v1, "widthMode":I
    invoke-static {p1}, Landroid/view/View$MeasureSpec;->getMode(I)I

    move-result v0

    .line 23
    .local v0, "heightMode":I
    if-eqz v1, :cond_0

    if-nez v0, :cond_1

    .line 24
    :cond_0
    new-instance v2, Ljava/lang/IllegalStateException;

    const-string v3, "A catalyst view must have an explicit width and height given to it. This should normally happen as part of the standard catalyst UI framework."

    invoke-direct {v2, v3}, Ljava/lang/IllegalStateException;-><init>(Ljava/lang/String;)V

    throw v2

    .line 28
    :cond_1
    return-void
.end method

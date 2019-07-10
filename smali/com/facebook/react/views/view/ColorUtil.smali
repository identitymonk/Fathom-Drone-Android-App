.class public Lcom/facebook/react/views/view/ColorUtil;
.super Ljava/lang/Object;
.source "ColorUtil.java"


# direct methods
.method public constructor <init>()V
    .locals 0

    .prologue
    .line 20
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method

.method public static getOpacityFromColor(I)I
    .locals 2
    .param p0, "color"    # I

    .prologue
    .line 46
    ushr-int/lit8 v0, p0, 0x18

    .line 47
    .local v0, "colorAlpha":I
    const/16 v1, 0xff

    if-ne v0, v1, :cond_0

    .line 48
    const/4 v1, -0x1

    .line 52
    :goto_0
    return v1

    .line 49
    :cond_0
    if-nez v0, :cond_1

    .line 50
    const/4 v1, -0x2

    goto :goto_0

    .line 52
    :cond_1
    const/4 v1, -0x3

    goto :goto_0
.end method

.method public static multiplyColorAlpha(II)I
    .locals 4
    .param p0, "color"    # I
    .param p1, "alpha"    # I

    .prologue
    const v3, 0xffffff

    .line 29
    const/16 v2, 0xff

    if-ne p1, v2, :cond_0

    .line 38
    .end local p0    # "color":I
    :goto_0
    return p0

    .line 32
    .restart local p0    # "color":I
    :cond_0
    if-nez p1, :cond_1

    .line 33
    and-int/2addr p0, v3

    goto :goto_0

    .line 35
    :cond_1
    shr-int/lit8 v2, p1, 0x7

    add-int/2addr p1, v2

    .line 36
    ushr-int/lit8 v0, p0, 0x18

    .line 37
    .local v0, "colorAlpha":I
    mul-int v2, v0, p1

    shr-int/lit8 v1, v2, 0x8

    .line 38
    .local v1, "multipliedAlpha":I
    shl-int/lit8 v2, v1, 0x18

    and-int/2addr v3, p0

    or-int p0, v2, v3

    goto :goto_0
.end method

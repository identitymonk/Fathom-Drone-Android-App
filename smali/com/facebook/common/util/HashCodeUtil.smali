.class public Lcom/facebook/common/util/HashCodeUtil;
.super Ljava/lang/Object;
.source "HashCodeUtil.java"


# static fields
.field private static final X:I = 0x1f


# direct methods
.method public constructor <init>()V
    .locals 0

    .prologue
    .line 19
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method

.method public static hashCode(I)I
    .locals 1
    .param p0, "i1"    # I

    .prologue
    .line 99
    add-int/lit8 v0, p0, 0x1f

    .line 100
    .local v0, "acc":I
    return v0
.end method

.method public static hashCode(II)I
    .locals 2
    .param p0, "i1"    # I
    .param p1, "i2"    # I

    .prologue
    .line 106
    add-int/lit8 v0, p0, 0x1f

    .line 107
    .local v0, "acc":I
    mul-int/lit8 v1, v0, 0x1f

    add-int v0, v1, p1

    .line 108
    return v0
.end method

.method public static hashCode(III)I
    .locals 2
    .param p0, "i1"    # I
    .param p1, "i2"    # I
    .param p2, "i3"    # I

    .prologue
    .line 115
    add-int/lit8 v0, p0, 0x1f

    .line 116
    .local v0, "acc":I
    mul-int/lit8 v1, v0, 0x1f

    add-int v0, v1, p1

    .line 117
    mul-int/lit8 v1, v0, 0x1f

    add-int v0, v1, p2

    .line 118
    return v0
.end method

.method public static hashCode(IIII)I
    .locals 2
    .param p0, "i1"    # I
    .param p1, "i2"    # I
    .param p2, "i3"    # I
    .param p3, "i4"    # I

    .prologue
    .line 126
    add-int/lit8 v0, p0, 0x1f

    .line 127
    .local v0, "acc":I
    mul-int/lit8 v1, v0, 0x1f

    add-int v0, v1, p1

    .line 128
    mul-int/lit8 v1, v0, 0x1f

    add-int v0, v1, p2

    .line 129
    mul-int/lit8 v1, v0, 0x1f

    add-int v0, v1, p3

    .line 130
    return v0
.end method

.method public static hashCode(IIIII)I
    .locals 2
    .param p0, "i1"    # I
    .param p1, "i2"    # I
    .param p2, "i3"    # I
    .param p3, "i4"    # I
    .param p4, "i5"    # I

    .prologue
    .line 139
    add-int/lit8 v0, p0, 0x1f

    .line 140
    .local v0, "acc":I
    mul-int/lit8 v1, v0, 0x1f

    add-int v0, v1, p1

    .line 141
    mul-int/lit8 v1, v0, 0x1f

    add-int v0, v1, p2

    .line 142
    mul-int/lit8 v1, v0, 0x1f

    add-int v0, v1, p3

    .line 143
    mul-int/lit8 v1, v0, 0x1f

    add-int v0, v1, p4

    .line 144
    return v0
.end method

.method public static hashCode(IIIIII)I
    .locals 2
    .param p0, "i1"    # I
    .param p1, "i2"    # I
    .param p2, "i3"    # I
    .param p3, "i4"    # I
    .param p4, "i5"    # I
    .param p5, "i6"    # I

    .prologue
    .line 154
    add-int/lit8 v0, p0, 0x1f

    .line 155
    .local v0, "acc":I
    mul-int/lit8 v1, v0, 0x1f

    add-int v0, v1, p1

    .line 156
    mul-int/lit8 v1, v0, 0x1f

    add-int v0, v1, p2

    .line 157
    mul-int/lit8 v1, v0, 0x1f

    add-int v0, v1, p3

    .line 158
    mul-int/lit8 v1, v0, 0x1f

    add-int v0, v1, p4

    .line 159
    mul-int/lit8 v1, v0, 0x1f

    add-int v0, v1, p5

    .line 160
    return v0
.end method

.method public static hashCode(Ljava/lang/Object;)I
    .locals 1
    .param p0, "o1"    # Ljava/lang/Object;
        .annotation runtime Ljavax/annotation/Nullable;
        .end annotation
    .end param

    .prologue
    .line 33
    if-nez p0, :cond_0

    const/4 v0, 0x0

    :goto_0
    invoke-static {v0}, Lcom/facebook/common/util/HashCodeUtil;->hashCode(I)I

    move-result v0

    return v0

    .line 34
    :cond_0
    invoke-virtual {p0}, Ljava/lang/Object;->hashCode()I

    move-result v0

    goto :goto_0
.end method

.method public static hashCode(Ljava/lang/Object;Ljava/lang/Object;)I
    .locals 2
    .param p0, "o1"    # Ljava/lang/Object;
        .annotation runtime Ljavax/annotation/Nullable;
        .end annotation
    .end param
    .param p1, "o2"    # Ljava/lang/Object;
        .annotation runtime Ljavax/annotation/Nullable;
        .end annotation
    .end param

    .prologue
    const/4 v0, 0x0

    .line 40
    if-nez p0, :cond_0

    move v1, v0

    .line 41
    :goto_0
    if-nez p1, :cond_1

    .line 40
    :goto_1
    invoke-static {v1, v0}, Lcom/facebook/common/util/HashCodeUtil;->hashCode(II)I

    move-result v0

    return v0

    .line 41
    :cond_0
    invoke-virtual {p0}, Ljava/lang/Object;->hashCode()I

    move-result v1

    goto :goto_0

    .line 42
    :cond_1
    invoke-virtual {p1}, Ljava/lang/Object;->hashCode()I

    move-result v0

    goto :goto_1
.end method

.method public static hashCode(Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;)I
    .locals 3
    .param p0, "o1"    # Ljava/lang/Object;
        .annotation runtime Ljavax/annotation/Nullable;
        .end annotation
    .end param
    .param p1, "o2"    # Ljava/lang/Object;
        .annotation runtime Ljavax/annotation/Nullable;
        .end annotation
    .end param
    .param p2, "o3"    # Ljava/lang/Object;
        .annotation runtime Ljavax/annotation/Nullable;
        .end annotation
    .end param

    .prologue
    const/4 v0, 0x0

    .line 49
    if-nez p0, :cond_0

    move v2, v0

    .line 50
    :goto_0
    if-nez p1, :cond_1

    move v1, v0

    .line 51
    :goto_1
    if-nez p2, :cond_2

    .line 49
    :goto_2
    invoke-static {v2, v1, v0}, Lcom/facebook/common/util/HashCodeUtil;->hashCode(III)I

    move-result v0

    return v0

    .line 50
    :cond_0
    invoke-virtual {p0}, Ljava/lang/Object;->hashCode()I

    move-result v1

    move v2, v1

    goto :goto_0

    .line 51
    :cond_1
    invoke-virtual {p1}, Ljava/lang/Object;->hashCode()I

    move-result v1

    goto :goto_1

    .line 52
    :cond_2
    invoke-virtual {p2}, Ljava/lang/Object;->hashCode()I

    move-result v0

    goto :goto_2
.end method

.method public static hashCode(Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;)I
    .locals 4
    .param p0, "o1"    # Ljava/lang/Object;
        .annotation runtime Ljavax/annotation/Nullable;
        .end annotation
    .end param
    .param p1, "o2"    # Ljava/lang/Object;
        .annotation runtime Ljavax/annotation/Nullable;
        .end annotation
    .end param
    .param p2, "o3"    # Ljava/lang/Object;
        .annotation runtime Ljavax/annotation/Nullable;
        .end annotation
    .end param
    .param p3, "o4"    # Ljava/lang/Object;
        .annotation runtime Ljavax/annotation/Nullable;
        .end annotation
    .end param

    .prologue
    const/4 v0, 0x0

    .line 60
    if-nez p0, :cond_0

    move v3, v0

    .line 61
    :goto_0
    if-nez p1, :cond_1

    move v2, v0

    .line 62
    :goto_1
    if-nez p2, :cond_2

    move v1, v0

    .line 63
    :goto_2
    if-nez p3, :cond_3

    .line 60
    :goto_3
    invoke-static {v3, v2, v1, v0}, Lcom/facebook/common/util/HashCodeUtil;->hashCode(IIII)I

    move-result v0

    return v0

    .line 61
    :cond_0
    invoke-virtual {p0}, Ljava/lang/Object;->hashCode()I

    move-result v1

    move v3, v1

    goto :goto_0

    .line 62
    :cond_1
    invoke-virtual {p1}, Ljava/lang/Object;->hashCode()I

    move-result v1

    move v2, v1

    goto :goto_1

    .line 63
    :cond_2
    invoke-virtual {p2}, Ljava/lang/Object;->hashCode()I

    move-result v1

    goto :goto_2

    .line 64
    :cond_3
    invoke-virtual {p3}, Ljava/lang/Object;->hashCode()I

    move-result v0

    goto :goto_3
.end method

.method public static hashCode(Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;)I
    .locals 5
    .param p0, "o1"    # Ljava/lang/Object;
        .annotation runtime Ljavax/annotation/Nullable;
        .end annotation
    .end param
    .param p1, "o2"    # Ljava/lang/Object;
        .annotation runtime Ljavax/annotation/Nullable;
        .end annotation
    .end param
    .param p2, "o3"    # Ljava/lang/Object;
        .annotation runtime Ljavax/annotation/Nullable;
        .end annotation
    .end param
    .param p3, "o4"    # Ljava/lang/Object;
        .annotation runtime Ljavax/annotation/Nullable;
        .end annotation
    .end param
    .param p4, "o5"    # Ljava/lang/Object;
        .annotation runtime Ljavax/annotation/Nullable;
        .end annotation
    .end param

    .prologue
    const/4 v0, 0x0

    .line 73
    if-nez p0, :cond_0

    move v4, v0

    .line 74
    :goto_0
    if-nez p1, :cond_1

    move v3, v0

    .line 75
    :goto_1
    if-nez p2, :cond_2

    move v2, v0

    .line 76
    :goto_2
    if-nez p3, :cond_3

    move v1, v0

    .line 77
    :goto_3
    if-nez p4, :cond_4

    .line 73
    :goto_4
    invoke-static {v4, v3, v2, v1, v0}, Lcom/facebook/common/util/HashCodeUtil;->hashCode(IIIII)I

    move-result v0

    return v0

    .line 74
    :cond_0
    invoke-virtual {p0}, Ljava/lang/Object;->hashCode()I

    move-result v1

    move v4, v1

    goto :goto_0

    .line 75
    :cond_1
    invoke-virtual {p1}, Ljava/lang/Object;->hashCode()I

    move-result v1

    move v3, v1

    goto :goto_1

    .line 76
    :cond_2
    invoke-virtual {p2}, Ljava/lang/Object;->hashCode()I

    move-result v1

    move v2, v1

    goto :goto_2

    .line 77
    :cond_3
    invoke-virtual {p3}, Ljava/lang/Object;->hashCode()I

    move-result v1

    goto :goto_3

    .line 78
    :cond_4
    invoke-virtual {p4}, Ljava/lang/Object;->hashCode()I

    move-result v0

    goto :goto_4
.end method

.method public static hashCode(Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;)I
    .locals 6
    .param p0, "o1"    # Ljava/lang/Object;
        .annotation runtime Ljavax/annotation/Nullable;
        .end annotation
    .end param
    .param p1, "o2"    # Ljava/lang/Object;
        .annotation runtime Ljavax/annotation/Nullable;
        .end annotation
    .end param
    .param p2, "o3"    # Ljava/lang/Object;
        .annotation runtime Ljavax/annotation/Nullable;
        .end annotation
    .end param
    .param p3, "o4"    # Ljava/lang/Object;
        .annotation runtime Ljavax/annotation/Nullable;
        .end annotation
    .end param
    .param p4, "o5"    # Ljava/lang/Object;
        .annotation runtime Ljavax/annotation/Nullable;
        .end annotation
    .end param
    .param p5, "o6"    # Ljava/lang/Object;
        .annotation runtime Ljavax/annotation/Nullable;
        .end annotation
    .end param

    .prologue
    const/4 v5, 0x0

    .line 88
    if-nez p0, :cond_0

    move v0, v5

    .line 89
    :goto_0
    if-nez p1, :cond_1

    move v1, v5

    .line 90
    :goto_1
    if-nez p2, :cond_2

    move v2, v5

    .line 91
    :goto_2
    if-nez p3, :cond_3

    move v3, v5

    .line 92
    :goto_3
    if-nez p4, :cond_4

    move v4, v5

    .line 93
    :goto_4
    if-nez p5, :cond_5

    .line 88
    :goto_5
    invoke-static/range {v0 .. v5}, Lcom/facebook/common/util/HashCodeUtil;->hashCode(IIIIII)I

    move-result v0

    return v0

    .line 89
    :cond_0
    invoke-virtual {p0}, Ljava/lang/Object;->hashCode()I

    move-result v0

    goto :goto_0

    .line 90
    :cond_1
    invoke-virtual {p1}, Ljava/lang/Object;->hashCode()I

    move-result v1

    goto :goto_1

    .line 91
    :cond_2
    invoke-virtual {p2}, Ljava/lang/Object;->hashCode()I

    move-result v2

    goto :goto_2

    .line 92
    :cond_3
    invoke-virtual {p3}, Ljava/lang/Object;->hashCode()I

    move-result v3

    goto :goto_3

    .line 93
    :cond_4
    invoke-virtual {p4}, Ljava/lang/Object;->hashCode()I

    move-result v4

    goto :goto_4

    .line 94
    :cond_5
    invoke-virtual {p5}, Ljava/lang/Object;->hashCode()I

    move-result v5

    goto :goto_5
.end method

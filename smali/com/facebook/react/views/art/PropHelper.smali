.class Lcom/facebook/react/views/art/PropHelper;
.super Ljava/lang/Object;
.source "PropHelper.java"


# direct methods
.method constructor <init>()V
    .locals 0

    .prologue
    .line 20
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method

.method static toFloatArray(Lcom/facebook/react/bridge/ReadableArray;[F)I
    .locals 4
    .param p0, "value"    # Lcom/facebook/react/bridge/ReadableArray;
    .param p1, "into"    # [F

    .prologue
    .line 48
    invoke-interface {p0}, Lcom/facebook/react/bridge/ReadableArray;->size()I

    move-result v2

    array-length v3, p1

    if-le v2, v3, :cond_0

    array-length v1, p1

    .line 49
    .local v1, "length":I
    :goto_0
    const/4 v0, 0x0

    .local v0, "i":I
    :goto_1
    if-ge v0, v1, :cond_1

    .line 50
    invoke-interface {p0, v0}, Lcom/facebook/react/bridge/ReadableArray;->getDouble(I)D

    move-result-wide v2

    double-to-float v2, v2

    aput v2, p1, v0

    .line 49
    add-int/lit8 v0, v0, 0x1

    goto :goto_1

    .line 48
    .end local v0    # "i":I
    .end local v1    # "length":I
    :cond_0
    invoke-interface {p0}, Lcom/facebook/react/bridge/ReadableArray;->size()I

    move-result v1

    goto :goto_0

    .line 52
    .restart local v0    # "i":I
    .restart local v1    # "length":I
    :cond_1
    invoke-interface {p0}, Lcom/facebook/react/bridge/ReadableArray;->size()I

    move-result v2

    return v2
.end method

.method static toFloatArray(Lcom/facebook/react/bridge/ReadableArray;)[F
    .locals 2
    .param p0, "value"    # Lcom/facebook/react/bridge/ReadableArray;
        .annotation runtime Ljavax/annotation/Nullable;
        .end annotation
    .end param
    .annotation runtime Ljavax/annotation/Nullable;
    .end annotation

    .prologue
    .line 29
    if-eqz p0, :cond_0

    .line 30
    invoke-interface {p0}, Lcom/facebook/react/bridge/ReadableArray;->size()I

    move-result v1

    new-array v0, v1, [F

    .line 31
    .local v0, "result":[F
    invoke-static {p0, v0}, Lcom/facebook/react/views/art/PropHelper;->toFloatArray(Lcom/facebook/react/bridge/ReadableArray;[F)I

    .line 34
    .end local v0    # "result":[F
    :goto_0
    return-object v0

    :cond_0
    const/4 v0, 0x0

    goto :goto_0
.end method

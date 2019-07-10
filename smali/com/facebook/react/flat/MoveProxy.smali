.class final Lcom/facebook/react/flat/MoveProxy;
.super Ljava/lang/Object;
.source "MoveProxy.java"


# instance fields
.field private mChildren:[Lcom/facebook/react/uimanager/ReactShadowNode;

.field private mMapping:[I

.field private mMoveTo:Lcom/facebook/react/bridge/ReadableArray;
    .annotation runtime Ljavax/annotation/Nullable;
    .end annotation
.end field

.field private mSize:I


# direct methods
.method constructor <init>()V
    .locals 1

    .prologue
    .line 21
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 25
    const/16 v0, 0x8

    new-array v0, v0, [I

    iput-object v0, p0, Lcom/facebook/react/flat/MoveProxy;->mMapping:[I

    .line 26
    const/4 v0, 0x4

    new-array v0, v0, [Lcom/facebook/react/uimanager/ReactShadowNodeImpl;

    iput-object v0, p0, Lcom/facebook/react/flat/MoveProxy;->mChildren:[Lcom/facebook/react/uimanager/ReactShadowNode;

    return-void
.end method

.method private static k(I)I
    .locals 1
    .param p0, "i"    # I

    .prologue
    .line 131
    mul-int/lit8 v0, p0, 0x2

    return v0
.end method

.method private moveFromToIndex(I)I
    .locals 2
    .param p1, "index"    # I

    .prologue
    .line 147
    iget-object v0, p0, Lcom/facebook/react/flat/MoveProxy;->mMapping:[I

    invoke-static {p1}, Lcom/facebook/react/flat/MoveProxy;->k(I)I

    move-result v1

    aget v0, v0, v1

    return v0
.end method

.method private moveFromToValue(I)I
    .locals 2
    .param p1, "index"    # I

    .prologue
    .line 151
    iget-object v0, p0, Lcom/facebook/react/flat/MoveProxy;->mMapping:[I

    invoke-static {p1}, Lcom/facebook/react/flat/MoveProxy;->v(I)I

    move-result v1

    aget v0, v0, v1

    return v0
.end method

.method private static moveToToIndex(I)I
    .locals 0
    .param p0, "index"    # I

    .prologue
    .line 155
    return p0
.end method

.method private moveToToValue(I)I
    .locals 1
    .param p1, "index"    # I

    .prologue
    .line 159
    iget-object v0, p0, Lcom/facebook/react/flat/MoveProxy;->mMoveTo:Lcom/facebook/react/bridge/ReadableArray;

    invoke-static {v0}, Lcom/facebook/infer/annotation/Assertions;->assumeNotNull(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/facebook/react/bridge/ReadableArray;

    invoke-interface {v0, p1}, Lcom/facebook/react/bridge/ReadableArray;->getInt(I)I

    move-result v0

    return v0
.end method

.method private setKeyValue(III)V
    .locals 2
    .param p1, "index"    # I
    .param p2, "key"    # I
    .param p3, "value"    # I

    .prologue
    .line 142
    iget-object v0, p0, Lcom/facebook/react/flat/MoveProxy;->mMapping:[I

    invoke-static {p1}, Lcom/facebook/react/flat/MoveProxy;->k(I)I

    move-result v1

    aput p2, v0, v1

    .line 143
    iget-object v0, p0, Lcom/facebook/react/flat/MoveProxy;->mMapping:[I

    invoke-static {p1}, Lcom/facebook/react/flat/MoveProxy;->v(I)I

    move-result v1

    aput p3, v0, v1

    .line 144
    return-void
.end method

.method private setSize(I)V
    .locals 3
    .param p1, "newSize"    # I

    .prologue
    .line 164
    move v0, p1

    .local v0, "i":I
    :goto_0
    iget v1, p0, Lcom/facebook/react/flat/MoveProxy;->mSize:I

    if-ge v0, v1, :cond_0

    .line 165
    iget-object v1, p0, Lcom/facebook/react/flat/MoveProxy;->mChildren:[Lcom/facebook/react/uimanager/ReactShadowNode;

    const/4 v2, 0x0

    aput-object v2, v1, v0

    .line 164
    add-int/lit8 v0, v0, 0x1

    goto :goto_0

    .line 168
    :cond_0
    iput p1, p0, Lcom/facebook/react/flat/MoveProxy;->mSize:I

    .line 169
    return-void
.end method

.method private static v(I)I
    .locals 1
    .param p0, "i"    # I

    .prologue
    .line 138
    mul-int/lit8 v0, p0, 0x2

    add-int/lit8 v0, v0, 0x1

    return v0
.end method


# virtual methods
.method public getChildMoveTo(I)Lcom/facebook/react/uimanager/ReactShadowNode;
    .locals 2
    .param p1, "moveToIndex"    # I

    .prologue
    .line 46
    iget-object v0, p0, Lcom/facebook/react/flat/MoveProxy;->mChildren:[Lcom/facebook/react/uimanager/ReactShadowNode;

    invoke-static {p1}, Lcom/facebook/react/flat/MoveProxy;->moveToToIndex(I)I

    move-result v1

    aget-object v0, v0, v1

    return-object v0
.end method

.method public getMoveFrom(I)I
    .locals 1
    .param p1, "moveFromIndex"    # I

    .prologue
    .line 53
    invoke-direct {p0, p1}, Lcom/facebook/react/flat/MoveProxy;->moveFromToValue(I)I

    move-result v0

    return v0
.end method

.method public getMoveTo(I)I
    .locals 1
    .param p1, "moveToIndex"    # I

    .prologue
    .line 60
    invoke-direct {p0, p1}, Lcom/facebook/react/flat/MoveProxy;->moveToToValue(I)I

    move-result v0

    return v0
.end method

.method public setChildMoveFrom(ILcom/facebook/react/uimanager/ReactShadowNode;)V
    .locals 2
    .param p1, "moveFromIndex"    # I
    .param p2, "node"    # Lcom/facebook/react/uimanager/ReactShadowNode;

    .prologue
    .line 39
    iget-object v0, p0, Lcom/facebook/react/flat/MoveProxy;->mChildren:[Lcom/facebook/react/uimanager/ReactShadowNode;

    invoke-direct {p0, p1}, Lcom/facebook/react/flat/MoveProxy;->moveFromToIndex(I)I

    move-result v1

    aput-object p2, v0, v1

    .line 40
    return-void
.end method

.method public setup(Lcom/facebook/react/bridge/ReadableArray;Lcom/facebook/react/bridge/ReadableArray;)V
    .locals 8
    .param p1, "moveFrom"    # Lcom/facebook/react/bridge/ReadableArray;
    .param p2, "moveTo"    # Lcom/facebook/react/bridge/ReadableArray;

    .prologue
    const/4 v6, 0x0

    .line 67
    iput-object p2, p0, Lcom/facebook/react/flat/MoveProxy;->mMoveTo:Lcom/facebook/react/bridge/ReadableArray;

    .line 69
    if-nez p1, :cond_1

    .line 70
    invoke-direct {p0, v6}, Lcom/facebook/react/flat/MoveProxy;->setSize(I)V

    .line 125
    :cond_0
    return-void

    .line 74
    :cond_1
    invoke-interface {p1}, Lcom/facebook/react/bridge/ReadableArray;->size()I

    move-result v4

    .line 75
    .local v4, "size":I
    add-int v3, v4, v4

    .line 76
    .local v3, "requiredSpace":I
    iget-object v5, p0, Lcom/facebook/react/flat/MoveProxy;->mMapping:[I

    array-length v5, v5

    if-ge v5, v3, :cond_2

    .line 77
    new-array v5, v3, [I

    iput-object v5, p0, Lcom/facebook/react/flat/MoveProxy;->mMapping:[I

    .line 78
    new-array v5, v4, [Lcom/facebook/react/flat/FlatShadowNode;

    iput-object v5, p0, Lcom/facebook/react/flat/MoveProxy;->mChildren:[Lcom/facebook/react/uimanager/ReactShadowNode;

    .line 81
    :cond_2
    invoke-direct {p0, v4}, Lcom/facebook/react/flat/MoveProxy;->setSize(I)V

    .line 102
    invoke-interface {p1, v6}, Lcom/facebook/react/bridge/ReadableArray;->getInt(I)I

    move-result v5

    invoke-direct {p0, v6, v6, v5}, Lcom/facebook/react/flat/MoveProxy;->setKeyValue(III)V

    .line 106
    const/4 v1, 0x1

    .local v1, "i":I
    :goto_0
    if-ge v1, v4, :cond_0

    .line 108
    invoke-interface {p1, v1}, Lcom/facebook/react/bridge/ReadableArray;->getInt(I)I

    move-result v0

    .line 114
    .local v0, "current":I
    add-int/lit8 v2, v1, -0x1

    .local v2, "j":I
    :goto_1
    if-ltz v2, :cond_3

    .line 115
    invoke-direct {p0, v2}, Lcom/facebook/react/flat/MoveProxy;->moveFromToValue(I)I

    move-result v5

    if-ge v5, v0, :cond_4

    .line 123
    :cond_3
    add-int/lit8 v5, v2, 0x1

    invoke-direct {p0, v5, v1, v0}, Lcom/facebook/react/flat/MoveProxy;->setKeyValue(III)V

    .line 106
    add-int/lit8 v1, v1, 0x1

    goto :goto_0

    .line 120
    :cond_4
    add-int/lit8 v5, v2, 0x1

    invoke-direct {p0, v2}, Lcom/facebook/react/flat/MoveProxy;->moveFromToIndex(I)I

    move-result v6

    invoke-direct {p0, v2}, Lcom/facebook/react/flat/MoveProxy;->moveFromToValue(I)I

    move-result v7

    invoke-direct {p0, v5, v6, v7}, Lcom/facebook/react/flat/MoveProxy;->setKeyValue(III)V

    .line 114
    add-int/lit8 v2, v2, -0x1

    goto :goto_1
.end method

.method public size()I
    .locals 1

    .prologue
    .line 32
    iget v0, p0, Lcom/facebook/react/flat/MoveProxy;->mSize:I

    return v0
.end method

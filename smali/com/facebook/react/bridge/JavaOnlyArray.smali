.class public Lcom/facebook/react/bridge/JavaOnlyArray;
.super Ljava/lang/Object;
.source "JavaOnlyArray.java"

# interfaces
.implements Lcom/facebook/react/bridge/ReadableArray;
.implements Lcom/facebook/react/bridge/WritableArray;


# instance fields
.field private final mBackingList:Ljava/util/List;


# direct methods
.method public constructor <init>()V
    .locals 1

    .prologue
    .line 47
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 48
    new-instance v0, Ljava/util/ArrayList;

    invoke-direct {v0}, Ljava/util/ArrayList;-><init>()V

    iput-object v0, p0, Lcom/facebook/react/bridge/JavaOnlyArray;->mBackingList:Ljava/util/List;

    .line 49
    return-void
.end method

.method private constructor <init>(Ljava/util/List;)V
    .locals 1
    .param p1, "list"    # Ljava/util/List;

    .prologue
    .line 43
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 44
    new-instance v0, Ljava/util/ArrayList;

    invoke-direct {v0, p1}, Ljava/util/ArrayList;-><init>(Ljava/util/Collection;)V

    iput-object v0, p0, Lcom/facebook/react/bridge/JavaOnlyArray;->mBackingList:Ljava/util/List;

    .line 45
    return-void
.end method

.method private varargs constructor <init>([Ljava/lang/Object;)V
    .locals 1
    .param p1, "values"    # [Ljava/lang/Object;

    .prologue
    .line 39
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 40
    invoke-static {p1}, Ljava/util/Arrays;->asList([Ljava/lang/Object;)Ljava/util/List;

    move-result-object v0

    iput-object v0, p0, Lcom/facebook/react/bridge/JavaOnlyArray;->mBackingList:Ljava/util/List;

    .line 41
    return-void
.end method

.method public static from(Ljava/util/List;)Lcom/facebook/react/bridge/JavaOnlyArray;
    .locals 1
    .param p0, "list"    # Ljava/util/List;

    .prologue
    .line 32
    new-instance v0, Lcom/facebook/react/bridge/JavaOnlyArray;

    invoke-direct {v0, p0}, Lcom/facebook/react/bridge/JavaOnlyArray;-><init>(Ljava/util/List;)V

    return-object v0
.end method

.method public static varargs of([Ljava/lang/Object;)Lcom/facebook/react/bridge/JavaOnlyArray;
    .locals 1
    .param p0, "values"    # [Ljava/lang/Object;

    .prologue
    .line 36
    new-instance v0, Lcom/facebook/react/bridge/JavaOnlyArray;

    invoke-direct {v0, p0}, Lcom/facebook/react/bridge/JavaOnlyArray;-><init>([Ljava/lang/Object;)V

    return-object v0
.end method


# virtual methods
.method public equals(Ljava/lang/Object;)Z
    .locals 5
    .param p1, "o"    # Ljava/lang/Object;

    .prologue
    const/4 v1, 0x1

    const/4 v2, 0x0

    .line 165
    if-ne p0, p1, :cond_1

    .line 173
    :cond_0
    :goto_0
    return v1

    .line 166
    :cond_1
    if-eqz p1, :cond_2

    invoke-virtual {p0}, Ljava/lang/Object;->getClass()Ljava/lang/Class;

    move-result-object v3

    invoke-virtual {p1}, Ljava/lang/Object;->getClass()Ljava/lang/Class;

    move-result-object v4

    if-eq v3, v4, :cond_3

    :cond_2
    move v1, v2

    goto :goto_0

    :cond_3
    move-object v0, p1

    .line 168
    check-cast v0, Lcom/facebook/react/bridge/JavaOnlyArray;

    .line 170
    .local v0, "that":Lcom/facebook/react/bridge/JavaOnlyArray;
    iget-object v3, p0, Lcom/facebook/react/bridge/JavaOnlyArray;->mBackingList:Ljava/util/List;

    if-eqz v3, :cond_4

    iget-object v3, p0, Lcom/facebook/react/bridge/JavaOnlyArray;->mBackingList:Ljava/util/List;

    iget-object v4, v0, Lcom/facebook/react/bridge/JavaOnlyArray;->mBackingList:Ljava/util/List;

    invoke-interface {v3, v4}, Ljava/util/List;->equals(Ljava/lang/Object;)Z

    move-result v3

    if-nez v3, :cond_0

    :goto_1
    move v1, v2

    .line 171
    goto :goto_0

    .line 170
    :cond_4
    iget-object v3, v0, Lcom/facebook/react/bridge/JavaOnlyArray;->mBackingList:Ljava/util/List;

    if-eqz v3, :cond_0

    goto :goto_1
.end method

.method public getArray(I)Lcom/facebook/react/bridge/JavaOnlyArray;
    .locals 1
    .param p1, "index"    # I

    .prologue
    .line 78
    iget-object v0, p0, Lcom/facebook/react/bridge/JavaOnlyArray;->mBackingList:Ljava/util/List;

    invoke-interface {v0, p1}, Ljava/util/List;->get(I)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/facebook/react/bridge/JavaOnlyArray;

    return-object v0
.end method

.method public bridge synthetic getArray(I)Lcom/facebook/react/bridge/ReadableArray;
    .locals 1

    .prologue
    .line 27
    invoke-virtual {p0, p1}, Lcom/facebook/react/bridge/JavaOnlyArray;->getArray(I)Lcom/facebook/react/bridge/JavaOnlyArray;

    move-result-object v0

    return-object v0
.end method

.method public getBoolean(I)Z
    .locals 1
    .param p1, "index"    # I

    .prologue
    .line 83
    iget-object v0, p0, Lcom/facebook/react/bridge/JavaOnlyArray;->mBackingList:Ljava/util/List;

    invoke-interface {v0, p1}, Ljava/util/List;->get(I)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Ljava/lang/Boolean;

    invoke-virtual {v0}, Ljava/lang/Boolean;->booleanValue()Z

    move-result v0

    return v0
.end method

.method public getDouble(I)D
    .locals 2
    .param p1, "index"    # I

    .prologue
    .line 63
    iget-object v0, p0, Lcom/facebook/react/bridge/JavaOnlyArray;->mBackingList:Ljava/util/List;

    invoke-interface {v0, p1}, Ljava/util/List;->get(I)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Ljava/lang/Double;

    invoke-virtual {v0}, Ljava/lang/Double;->doubleValue()D

    move-result-wide v0

    return-wide v0
.end method

.method public getDynamic(I)Lcom/facebook/react/bridge/Dynamic;
    .locals 1
    .param p1, "index"    # I

    .prologue
    .line 93
    invoke-static {p0, p1}, Lcom/facebook/react/bridge/DynamicFromArray;->create(Lcom/facebook/react/bridge/ReadableArray;I)Lcom/facebook/react/bridge/DynamicFromArray;

    move-result-object v0

    return-object v0
.end method

.method public getInt(I)I
    .locals 1
    .param p1, "index"    # I

    .prologue
    .line 68
    iget-object v0, p0, Lcom/facebook/react/bridge/JavaOnlyArray;->mBackingList:Ljava/util/List;

    invoke-interface {v0, p1}, Ljava/util/List;->get(I)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Ljava/lang/Integer;

    invoke-virtual {v0}, Ljava/lang/Integer;->intValue()I

    move-result v0

    return v0
.end method

.method public getMap(I)Lcom/facebook/react/bridge/JavaOnlyMap;
    .locals 1
    .param p1, "index"    # I

    .prologue
    .line 88
    iget-object v0, p0, Lcom/facebook/react/bridge/JavaOnlyArray;->mBackingList:Ljava/util/List;

    invoke-interface {v0, p1}, Ljava/util/List;->get(I)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/facebook/react/bridge/JavaOnlyMap;

    return-object v0
.end method

.method public bridge synthetic getMap(I)Lcom/facebook/react/bridge/ReadableMap;
    .locals 1

    .prologue
    .line 27
    invoke-virtual {p0, p1}, Lcom/facebook/react/bridge/JavaOnlyArray;->getMap(I)Lcom/facebook/react/bridge/JavaOnlyMap;

    move-result-object v0

    return-object v0
.end method

.method public getString(I)Ljava/lang/String;
    .locals 1
    .param p1, "index"    # I

    .prologue
    .line 73
    iget-object v0, p0, Lcom/facebook/react/bridge/JavaOnlyArray;->mBackingList:Ljava/util/List;

    invoke-interface {v0, p1}, Ljava/util/List;->get(I)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Ljava/lang/String;

    return-object v0
.end method

.method public getType(I)Lcom/facebook/react/bridge/ReadableType;
    .locals 2
    .param p1, "index"    # I

    .prologue
    .line 98
    iget-object v1, p0, Lcom/facebook/react/bridge/JavaOnlyArray;->mBackingList:Ljava/util/List;

    invoke-interface {v1, p1}, Ljava/util/List;->get(I)Ljava/lang/Object;

    move-result-object v0

    .line 100
    .local v0, "object":Ljava/lang/Object;
    if-nez v0, :cond_0

    .line 101
    sget-object v1, Lcom/facebook/react/bridge/ReadableType;->Null:Lcom/facebook/react/bridge/ReadableType;

    .line 115
    :goto_0
    return-object v1

    .line 102
    :cond_0
    instance-of v1, v0, Ljava/lang/Boolean;

    if-eqz v1, :cond_1

    .line 103
    sget-object v1, Lcom/facebook/react/bridge/ReadableType;->Boolean:Lcom/facebook/react/bridge/ReadableType;

    goto :goto_0

    .line 104
    :cond_1
    instance-of v1, v0, Ljava/lang/Double;

    if-nez v1, :cond_2

    instance-of v1, v0, Ljava/lang/Float;

    if-nez v1, :cond_2

    instance-of v1, v0, Ljava/lang/Integer;

    if-eqz v1, :cond_3

    .line 107
    :cond_2
    sget-object v1, Lcom/facebook/react/bridge/ReadableType;->Number:Lcom/facebook/react/bridge/ReadableType;

    goto :goto_0

    .line 108
    :cond_3
    instance-of v1, v0, Ljava/lang/String;

    if-eqz v1, :cond_4

    .line 109
    sget-object v1, Lcom/facebook/react/bridge/ReadableType;->String:Lcom/facebook/react/bridge/ReadableType;

    goto :goto_0

    .line 110
    :cond_4
    instance-of v1, v0, Lcom/facebook/react/bridge/ReadableArray;

    if-eqz v1, :cond_5

    .line 111
    sget-object v1, Lcom/facebook/react/bridge/ReadableType;->Array:Lcom/facebook/react/bridge/ReadableType;

    goto :goto_0

    .line 112
    :cond_5
    instance-of v1, v0, Lcom/facebook/react/bridge/ReadableMap;

    if-eqz v1, :cond_6

    .line 113
    sget-object v1, Lcom/facebook/react/bridge/ReadableType;->Map:Lcom/facebook/react/bridge/ReadableType;

    goto :goto_0

    .line 115
    :cond_6
    const/4 v1, 0x0

    goto :goto_0
.end method

.method public hashCode()I
    .locals 1

    .prologue
    .line 178
    iget-object v0, p0, Lcom/facebook/react/bridge/JavaOnlyArray;->mBackingList:Ljava/util/List;

    if-eqz v0, :cond_0

    iget-object v0, p0, Lcom/facebook/react/bridge/JavaOnlyArray;->mBackingList:Ljava/util/List;

    invoke-interface {v0}, Ljava/util/List;->hashCode()I

    move-result v0

    :goto_0
    return v0

    :cond_0
    const/4 v0, 0x0

    goto :goto_0
.end method

.method public isNull(I)Z
    .locals 1
    .param p1, "index"    # I

    .prologue
    .line 58
    iget-object v0, p0, Lcom/facebook/react/bridge/JavaOnlyArray;->mBackingList:Ljava/util/List;

    invoke-interface {v0, p1}, Ljava/util/List;->get(I)Ljava/lang/Object;

    move-result-object v0

    if-nez v0, :cond_0

    const/4 v0, 0x1

    :goto_0
    return v0

    :cond_0
    const/4 v0, 0x0

    goto :goto_0
.end method

.method public pushArray(Lcom/facebook/react/bridge/WritableArray;)V
    .locals 1
    .param p1, "array"    # Lcom/facebook/react/bridge/WritableArray;

    .prologue
    .line 140
    iget-object v0, p0, Lcom/facebook/react/bridge/JavaOnlyArray;->mBackingList:Ljava/util/List;

    invoke-interface {v0, p1}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    .line 141
    return-void
.end method

.method public pushBoolean(Z)V
    .locals 2
    .param p1, "value"    # Z

    .prologue
    .line 120
    iget-object v0, p0, Lcom/facebook/react/bridge/JavaOnlyArray;->mBackingList:Ljava/util/List;

    invoke-static {p1}, Ljava/lang/Boolean;->valueOf(Z)Ljava/lang/Boolean;

    move-result-object v1

    invoke-interface {v0, v1}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    .line 121
    return-void
.end method

.method public pushDouble(D)V
    .locals 3
    .param p1, "value"    # D

    .prologue
    .line 125
    iget-object v0, p0, Lcom/facebook/react/bridge/JavaOnlyArray;->mBackingList:Ljava/util/List;

    invoke-static {p1, p2}, Ljava/lang/Double;->valueOf(D)Ljava/lang/Double;

    move-result-object v1

    invoke-interface {v0, v1}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    .line 126
    return-void
.end method

.method public pushInt(I)V
    .locals 2
    .param p1, "value"    # I

    .prologue
    .line 130
    iget-object v0, p0, Lcom/facebook/react/bridge/JavaOnlyArray;->mBackingList:Ljava/util/List;

    invoke-static {p1}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v1

    invoke-interface {v0, v1}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    .line 131
    return-void
.end method

.method public pushMap(Lcom/facebook/react/bridge/WritableMap;)V
    .locals 1
    .param p1, "map"    # Lcom/facebook/react/bridge/WritableMap;

    .prologue
    .line 145
    iget-object v0, p0, Lcom/facebook/react/bridge/JavaOnlyArray;->mBackingList:Ljava/util/List;

    invoke-interface {v0, p1}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    .line 146
    return-void
.end method

.method public pushNull()V
    .locals 2

    .prologue
    .line 150
    iget-object v0, p0, Lcom/facebook/react/bridge/JavaOnlyArray;->mBackingList:Ljava/util/List;

    const/4 v1, 0x0

    invoke-interface {v0, v1}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    .line 151
    return-void
.end method

.method public pushString(Ljava/lang/String;)V
    .locals 1
    .param p1, "value"    # Ljava/lang/String;

    .prologue
    .line 135
    iget-object v0, p0, Lcom/facebook/react/bridge/JavaOnlyArray;->mBackingList:Ljava/util/List;

    invoke-interface {v0, p1}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    .line 136
    return-void
.end method

.method public size()I
    .locals 1

    .prologue
    .line 53
    iget-object v0, p0, Lcom/facebook/react/bridge/JavaOnlyArray;->mBackingList:Ljava/util/List;

    invoke-interface {v0}, Ljava/util/List;->size()I

    move-result v0

    return v0
.end method

.method public toArrayList()Ljava/util/ArrayList;
    .locals 2
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()",
            "Ljava/util/ArrayList",
            "<",
            "Ljava/lang/Object;",
            ">;"
        }
    .end annotation

    .prologue
    .line 155
    new-instance v0, Ljava/util/ArrayList;

    iget-object v1, p0, Lcom/facebook/react/bridge/JavaOnlyArray;->mBackingList:Ljava/util/List;

    invoke-direct {v0, v1}, Ljava/util/ArrayList;-><init>(Ljava/util/Collection;)V

    return-object v0
.end method

.method public toString()Ljava/lang/String;
    .locals 1

    .prologue
    .line 160
    iget-object v0, p0, Lcom/facebook/react/bridge/JavaOnlyArray;->mBackingList:Ljava/util/List;

    invoke-virtual {v0}, Ljava/lang/Object;->toString()Ljava/lang/String;

    move-result-object v0

    return-object v0
.end method

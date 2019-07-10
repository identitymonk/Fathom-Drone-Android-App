.class final Lcom/facebook/react/flat/ElementsList;
.super Ljava/lang/Object;
.source "ElementsList.java"


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lcom/facebook/react/flat/ElementsList$Scope;
    }
.end annotation

.annotation system Ldalvik/annotation/Signature;
    value = {
        "<E:",
        "Ljava/lang/Object;",
        ">",
        "Ljava/lang/Object;"
    }
.end annotation


# instance fields
.field private mCurrentScope:Lcom/facebook/react/flat/ElementsList$Scope;

.field private final mElements:Ljava/util/ArrayDeque;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/ArrayDeque",
            "<TE;>;"
        }
    .end annotation
.end field

.field private final mEmptyArray:[Ljava/lang/Object;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "[TE;"
        }
    .end annotation
.end field

.field private mScopeIndex:I

.field private final mScopesStack:Ljava/util/ArrayList;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/ArrayList",
            "<",
            "Lcom/facebook/react/flat/ElementsList$Scope;",
            ">;"
        }
    .end annotation
.end field


# direct methods
.method public constructor <init>([Ljava/lang/Object;)V
    .locals 2
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "([TE;)V"
        }
    .end annotation

    .prologue
    .line 83
    .local p0, "this":Lcom/facebook/react/flat/ElementsList;, "Lcom/facebook/react/flat/ElementsList<TE;>;"
    .local p1, "emptyArray":[Ljava/lang/Object;, "[TE;"
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 74
    new-instance v0, Ljava/util/ArrayList;

    invoke-direct {v0}, Ljava/util/ArrayList;-><init>()V

    iput-object v0, p0, Lcom/facebook/react/flat/ElementsList;->mScopesStack:Ljava/util/ArrayList;

    .line 78
    new-instance v0, Ljava/util/ArrayDeque;

    invoke-direct {v0}, Ljava/util/ArrayDeque;-><init>()V

    iput-object v0, p0, Lcom/facebook/react/flat/ElementsList;->mElements:Ljava/util/ArrayDeque;

    .line 80
    const/4 v0, 0x0

    iput-object v0, p0, Lcom/facebook/react/flat/ElementsList;->mCurrentScope:Lcom/facebook/react/flat/ElementsList$Scope;

    .line 81
    const/4 v0, 0x0

    iput v0, p0, Lcom/facebook/react/flat/ElementsList;->mScopeIndex:I

    .line 84
    iput-object p1, p0, Lcom/facebook/react/flat/ElementsList;->mEmptyArray:[Ljava/lang/Object;

    .line 85
    iget-object v0, p0, Lcom/facebook/react/flat/ElementsList;->mScopesStack:Ljava/util/ArrayList;

    iget-object v1, p0, Lcom/facebook/react/flat/ElementsList;->mCurrentScope:Lcom/facebook/react/flat/ElementsList$Scope;

    invoke-virtual {v0, v1}, Ljava/util/ArrayList;->add(Ljava/lang/Object;)Z

    .line 86
    return-void
.end method

.method private extractElements(I)[Ljava/lang/Object;
    .locals 3
    .param p1, "size"    # I
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(I)[TE;"
        }
    .end annotation

    .prologue
    .line 157
    .local p0, "this":Lcom/facebook/react/flat/ElementsList;, "Lcom/facebook/react/flat/ElementsList<TE;>;"
    if-nez p1, :cond_1

    .line 159
    iget-object v0, p0, Lcom/facebook/react/flat/ElementsList;->mEmptyArray:[Ljava/lang/Object;

    .line 167
    :cond_0
    return-object v0

    .line 162
    :cond_1
    iget-object v2, p0, Lcom/facebook/react/flat/ElementsList;->mEmptyArray:[Ljava/lang/Object;

    invoke-virtual {v2}, Ljava/lang/Object;->getClass()Ljava/lang/Class;

    move-result-object v2

    invoke-virtual {v2}, Ljava/lang/Class;->getComponentType()Ljava/lang/Class;

    move-result-object v2

    invoke-static {v2, p1}, Ljava/lang/reflect/Array;->newInstance(Ljava/lang/Class;I)Ljava/lang/Object;

    move-result-object v2

    check-cast v2, [Ljava/lang/Object;

    move-object v0, v2

    check-cast v0, [Ljava/lang/Object;

    .line 163
    .local v0, "elements":[Ljava/lang/Object;, "[TE;"
    add-int/lit8 v1, p1, -0x1

    .local v1, "i":I
    :goto_0
    if-ltz v1, :cond_0

    .line 164
    iget-object v2, p0, Lcom/facebook/react/flat/ElementsList;->mElements:Ljava/util/ArrayDeque;

    invoke-virtual {v2}, Ljava/util/ArrayDeque;->pollLast()Ljava/lang/Object;

    move-result-object v2

    aput-object v2, v0, v1

    .line 163
    add-int/lit8 v1, v1, -0x1

    goto :goto_0
.end method

.method private getCurrentScope()Lcom/facebook/react/flat/ElementsList$Scope;
    .locals 1

    .prologue
    .line 198
    .local p0, "this":Lcom/facebook/react/flat/ElementsList;, "Lcom/facebook/react/flat/ElementsList<TE;>;"
    iget-object v0, p0, Lcom/facebook/react/flat/ElementsList;->mCurrentScope:Lcom/facebook/react/flat/ElementsList$Scope;

    return-object v0
.end method

.method private popScope()V
    .locals 2

    .prologue
    .line 190
    .local p0, "this":Lcom/facebook/react/flat/ElementsList;, "Lcom/facebook/react/flat/ElementsList<TE;>;"
    iget v0, p0, Lcom/facebook/react/flat/ElementsList;->mScopeIndex:I

    add-int/lit8 v0, v0, -0x1

    iput v0, p0, Lcom/facebook/react/flat/ElementsList;->mScopeIndex:I

    .line 191
    iget-object v0, p0, Lcom/facebook/react/flat/ElementsList;->mScopesStack:Ljava/util/ArrayList;

    iget v1, p0, Lcom/facebook/react/flat/ElementsList;->mScopeIndex:I

    invoke-virtual {v0, v1}, Ljava/util/ArrayList;->get(I)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/facebook/react/flat/ElementsList$Scope;

    iput-object v0, p0, Lcom/facebook/react/flat/ElementsList;->mCurrentScope:Lcom/facebook/react/flat/ElementsList$Scope;

    .line 192
    return-void
.end method

.method private pushScope()V
    .locals 2

    .prologue
    .line 174
    .local p0, "this":Lcom/facebook/react/flat/ElementsList;, "Lcom/facebook/react/flat/ElementsList<TE;>;"
    iget v0, p0, Lcom/facebook/react/flat/ElementsList;->mScopeIndex:I

    add-int/lit8 v0, v0, 0x1

    iput v0, p0, Lcom/facebook/react/flat/ElementsList;->mScopeIndex:I

    .line 175
    iget v0, p0, Lcom/facebook/react/flat/ElementsList;->mScopeIndex:I

    iget-object v1, p0, Lcom/facebook/react/flat/ElementsList;->mScopesStack:Ljava/util/ArrayList;

    invoke-virtual {v1}, Ljava/util/ArrayList;->size()I

    move-result v1

    if-ne v0, v1, :cond_0

    .line 177
    new-instance v0, Lcom/facebook/react/flat/ElementsList$Scope;

    const/4 v1, 0x0

    invoke-direct {v0, v1}, Lcom/facebook/react/flat/ElementsList$Scope;-><init>(Lcom/facebook/react/flat/ElementsList$1;)V

    iput-object v0, p0, Lcom/facebook/react/flat/ElementsList;->mCurrentScope:Lcom/facebook/react/flat/ElementsList$Scope;

    .line 178
    iget-object v0, p0, Lcom/facebook/react/flat/ElementsList;->mScopesStack:Ljava/util/ArrayList;

    iget-object v1, p0, Lcom/facebook/react/flat/ElementsList;->mCurrentScope:Lcom/facebook/react/flat/ElementsList$Scope;

    invoke-virtual {v0, v1}, Ljava/util/ArrayList;->add(Ljava/lang/Object;)Z

    .line 183
    :goto_0
    return-void

    .line 181
    :cond_0
    iget-object v0, p0, Lcom/facebook/react/flat/ElementsList;->mScopesStack:Ljava/util/ArrayList;

    iget v1, p0, Lcom/facebook/react/flat/ElementsList;->mScopeIndex:I

    invoke-virtual {v0, v1}, Ljava/util/ArrayList;->get(I)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/facebook/react/flat/ElementsList$Scope;

    iput-object v0, p0, Lcom/facebook/react/flat/ElementsList;->mCurrentScope:Lcom/facebook/react/flat/ElementsList$Scope;

    goto :goto_0
.end method


# virtual methods
.method public add(Ljava/lang/Object;)V
    .locals 3
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(TE;)V"
        }
    .end annotation

    .prologue
    .line 130
    .local p0, "this":Lcom/facebook/react/flat/ElementsList;, "Lcom/facebook/react/flat/ElementsList<TE;>;"
    .local p1, "element":Ljava/lang/Object;, "TE;"
    invoke-direct {p0}, Lcom/facebook/react/flat/ElementsList;->getCurrentScope()Lcom/facebook/react/flat/ElementsList$Scope;

    move-result-object v0

    .line 132
    .local v0, "scope":Lcom/facebook/react/flat/ElementsList$Scope;
    iget v1, v0, Lcom/facebook/react/flat/ElementsList$Scope;->index:I

    iget-object v2, v0, Lcom/facebook/react/flat/ElementsList$Scope;->elements:[Ljava/lang/Object;

    array-length v2, v2

    if-ge v1, v2, :cond_0

    iget-object v1, v0, Lcom/facebook/react/flat/ElementsList$Scope;->elements:[Ljava/lang/Object;

    iget v2, v0, Lcom/facebook/react/flat/ElementsList$Scope;->index:I

    aget-object v1, v1, v2

    if-ne v1, p1, :cond_0

    .line 134
    iget v1, v0, Lcom/facebook/react/flat/ElementsList$Scope;->index:I

    add-int/lit8 v1, v1, 0x1

    iput v1, v0, Lcom/facebook/react/flat/ElementsList$Scope;->index:I

    .line 139
    :goto_0
    iget-object v1, p0, Lcom/facebook/react/flat/ElementsList;->mElements:Ljava/util/ArrayDeque;

    invoke-virtual {v1, p1}, Ljava/util/ArrayDeque;->add(Ljava/lang/Object;)Z

    .line 140
    return-void

    .line 136
    :cond_0
    const v1, 0x7fffffff

    iput v1, v0, Lcom/facebook/react/flat/ElementsList$Scope;->index:I

    goto :goto_0
.end method

.method public clear()V
    .locals 2

    .prologue
    .line 146
    .local p0, "this":Lcom/facebook/react/flat/ElementsList;, "Lcom/facebook/react/flat/ElementsList<TE;>;"
    invoke-direct {p0}, Lcom/facebook/react/flat/ElementsList;->getCurrentScope()Lcom/facebook/react/flat/ElementsList$Scope;

    move-result-object v0

    if-eqz v0, :cond_0

    .line 147
    new-instance v0, Ljava/lang/RuntimeException;

    const-string v1, "Must call finish() for every start() call being made."

    invoke-direct {v0, v1}, Ljava/lang/RuntimeException;-><init>(Ljava/lang/String;)V

    throw v0

    .line 149
    :cond_0
    iget-object v0, p0, Lcom/facebook/react/flat/ElementsList;->mElements:Ljava/util/ArrayDeque;

    invoke-virtual {v0}, Ljava/util/ArrayDeque;->clear()V

    .line 150
    return-void
.end method

.method public finish()[Ljava/lang/Object;
    .locals 6
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()[TE;"
        }
    .end annotation

    .prologue
    .line 105
    .local p0, "this":Lcom/facebook/react/flat/ElementsList;, "Lcom/facebook/react/flat/ElementsList<TE;>;"
    invoke-direct {p0}, Lcom/facebook/react/flat/ElementsList;->getCurrentScope()Lcom/facebook/react/flat/ElementsList$Scope;

    move-result-object v2

    .line 106
    .local v2, "scope":Lcom/facebook/react/flat/ElementsList$Scope;
    invoke-direct {p0}, Lcom/facebook/react/flat/ElementsList;->popScope()V

    .line 108
    const/4 v1, 0x0

    .line 109
    .local v1, "result":[Ljava/lang/Object;, "[TE;"
    iget-object v4, p0, Lcom/facebook/react/flat/ElementsList;->mElements:Ljava/util/ArrayDeque;

    invoke-virtual {v4}, Ljava/util/ArrayDeque;->size()I

    move-result v4

    iget v5, v2, Lcom/facebook/react/flat/ElementsList$Scope;->size:I

    sub-int v3, v4, v5

    .line 110
    .local v3, "size":I
    iget v4, v2, Lcom/facebook/react/flat/ElementsList$Scope;->index:I

    iget-object v5, v2, Lcom/facebook/react/flat/ElementsList$Scope;->elements:[Ljava/lang/Object;

    array-length v5, v5

    if-eq v4, v5, :cond_1

    .line 111
    invoke-direct {p0, v3}, Lcom/facebook/react/flat/ElementsList;->extractElements(I)[Ljava/lang/Object;

    move-result-object v1

    .line 120
    :cond_0
    const/4 v4, 0x0

    iput-object v4, v2, Lcom/facebook/react/flat/ElementsList$Scope;->elements:[Ljava/lang/Object;

    .line 122
    return-object v1

    .line 114
    :cond_1
    const/4 v0, 0x0

    .local v0, "i":I
    :goto_0
    if-ge v0, v3, :cond_0

    .line 115
    iget-object v4, p0, Lcom/facebook/react/flat/ElementsList;->mElements:Ljava/util/ArrayDeque;

    invoke-virtual {v4}, Ljava/util/ArrayDeque;->pollLast()Ljava/lang/Object;

    .line 114
    add-int/lit8 v0, v0, 0x1

    goto :goto_0
.end method

.method public start([Ljava/lang/Object;)V
    .locals 2
    .param p1, "elements"    # [Ljava/lang/Object;

    .prologue
    .line 92
    .local p0, "this":Lcom/facebook/react/flat/ElementsList;, "Lcom/facebook/react/flat/ElementsList<TE;>;"
    invoke-direct {p0}, Lcom/facebook/react/flat/ElementsList;->pushScope()V

    .line 94
    invoke-direct {p0}, Lcom/facebook/react/flat/ElementsList;->getCurrentScope()Lcom/facebook/react/flat/ElementsList$Scope;

    move-result-object v0

    .line 95
    .local v0, "scope":Lcom/facebook/react/flat/ElementsList$Scope;
    iput-object p1, v0, Lcom/facebook/react/flat/ElementsList$Scope;->elements:[Ljava/lang/Object;

    .line 96
    const/4 v1, 0x0

    iput v1, v0, Lcom/facebook/react/flat/ElementsList$Scope;->index:I

    .line 97
    iget-object v1, p0, Lcom/facebook/react/flat/ElementsList;->mElements:Ljava/util/ArrayDeque;

    invoke-virtual {v1}, Ljava/util/ArrayDeque;->size()I

    move-result v1

    iput v1, v0, Lcom/facebook/react/flat/ElementsList$Scope;->size:I

    .line 98
    return-void
.end method

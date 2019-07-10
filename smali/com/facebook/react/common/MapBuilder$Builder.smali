.class public final Lcom/facebook/react/common/MapBuilder$Builder;
.super Ljava/lang/Object;
.source "MapBuilder.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/facebook/react/common/MapBuilder;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x19
    name = "Builder"
.end annotation

.annotation system Ldalvik/annotation/Signature;
    value = {
        "<K:",
        "Ljava/lang/Object;",
        "V:",
        "Ljava/lang/Object;",
        ">",
        "Ljava/lang/Object;"
    }
.end annotation


# instance fields
.field private mMap:Ljava/util/Map;

.field private mUnderConstruction:Z


# direct methods
.method private constructor <init>()V
    .locals 1

    .prologue
    .line 132
    .local p0, "this":Lcom/facebook/react/common/MapBuilder$Builder;, "Lcom/facebook/react/common/MapBuilder$Builder<TK;TV;>;"
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 133
    invoke-static {}, Lcom/facebook/react/common/MapBuilder;->newHashMap()Ljava/util/HashMap;

    move-result-object v0

    iput-object v0, p0, Lcom/facebook/react/common/MapBuilder$Builder;->mMap:Ljava/util/Map;

    .line 134
    const/4 v0, 0x1

    iput-boolean v0, p0, Lcom/facebook/react/common/MapBuilder$Builder;->mUnderConstruction:Z

    .line 135
    return-void
.end method

.method synthetic constructor <init>(Lcom/facebook/react/common/MapBuilder$1;)V
    .locals 0
    .param p1, "x0"    # Lcom/facebook/react/common/MapBuilder$1;

    .prologue
    .line 127
    .local p0, "this":Lcom/facebook/react/common/MapBuilder$Builder;, "Lcom/facebook/react/common/MapBuilder$Builder<TK;TV;>;"
    invoke-direct {p0}, Lcom/facebook/react/common/MapBuilder$Builder;-><init>()V

    return-void
.end method


# virtual methods
.method public build()Ljava/util/Map;
    .locals 2
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()",
            "Ljava/util/Map",
            "<TK;TV;>;"
        }
    .end annotation

    .prologue
    .line 146
    .local p0, "this":Lcom/facebook/react/common/MapBuilder$Builder;, "Lcom/facebook/react/common/MapBuilder$Builder<TK;TV;>;"
    iget-boolean v0, p0, Lcom/facebook/react/common/MapBuilder$Builder;->mUnderConstruction:Z

    if-nez v0, :cond_0

    .line 147
    new-instance v0, Ljava/lang/IllegalStateException;

    const-string v1, "Underlying map has already been built"

    invoke-direct {v0, v1}, Ljava/lang/IllegalStateException;-><init>(Ljava/lang/String;)V

    throw v0

    .line 149
    :cond_0
    const/4 v0, 0x0

    iput-boolean v0, p0, Lcom/facebook/react/common/MapBuilder$Builder;->mUnderConstruction:Z

    .line 150
    iget-object v0, p0, Lcom/facebook/react/common/MapBuilder$Builder;->mMap:Ljava/util/Map;

    return-object v0
.end method

.method public put(Ljava/lang/Object;Ljava/lang/Object;)Lcom/facebook/react/common/MapBuilder$Builder;
    .locals 2
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(TK;TV;)",
            "Lcom/facebook/react/common/MapBuilder$Builder",
            "<TK;TV;>;"
        }
    .end annotation

    .prologue
    .line 138
    .local p0, "this":Lcom/facebook/react/common/MapBuilder$Builder;, "Lcom/facebook/react/common/MapBuilder$Builder<TK;TV;>;"
    .local p1, "k":Ljava/lang/Object;, "TK;"
    .local p2, "v":Ljava/lang/Object;, "TV;"
    iget-boolean v0, p0, Lcom/facebook/react/common/MapBuilder$Builder;->mUnderConstruction:Z

    if-nez v0, :cond_0

    .line 139
    new-instance v0, Ljava/lang/IllegalStateException;

    const-string v1, "Underlying map has already been built"

    invoke-direct {v0, v1}, Ljava/lang/IllegalStateException;-><init>(Ljava/lang/String;)V

    throw v0

    .line 141
    :cond_0
    iget-object v0, p0, Lcom/facebook/react/common/MapBuilder$Builder;->mMap:Ljava/util/Map;

    invoke-interface {v0, p1, p2}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 142
    return-object p0
.end method

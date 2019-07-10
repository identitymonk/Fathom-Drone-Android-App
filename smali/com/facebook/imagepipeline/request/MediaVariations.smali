.class public Lcom/facebook/imagepipeline/request/MediaVariations;
.super Ljava/lang/Object;
.source "MediaVariations.java"


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lcom/facebook/imagepipeline/request/MediaVariations$Builder;,
        Lcom/facebook/imagepipeline/request/MediaVariations$Variant;,
        Lcom/facebook/imagepipeline/request/MediaVariations$Source;
    }
.end annotation

.annotation build Ljavax/annotation/concurrent/Immutable;
.end annotation


# static fields
.field public static final SOURCE_ID_EXTRACTOR:Ljava/lang/String; = "id_extractor"

.field public static final SOURCE_IMAGE_REQUEST:Ljava/lang/String; = "request"

.field public static final SOURCE_INDEX_DB:Ljava/lang/String; = "index_db"


# instance fields
.field private final mForceRequestForSpecifiedUri:Z

.field private final mMediaId:Ljava/lang/String;

.field private final mSource:Ljava/lang/String;

.field private final mVariants:Ljava/util/List;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/List",
            "<",
            "Lcom/facebook/imagepipeline/request/MediaVariations$Variant;",
            ">;"
        }
    .end annotation

    .annotation runtime Ljavax/annotation/Nullable;
    .end annotation
.end field


# direct methods
.method private constructor <init>(Lcom/facebook/imagepipeline/request/MediaVariations$Builder;)V
    .locals 1
    .param p1, "builder"    # Lcom/facebook/imagepipeline/request/MediaVariations$Builder;

    .prologue
    .line 68
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 69
    invoke-static {p1}, Lcom/facebook/imagepipeline/request/MediaVariations$Builder;->access$000(Lcom/facebook/imagepipeline/request/MediaVariations$Builder;)Ljava/lang/String;

    move-result-object v0

    iput-object v0, p0, Lcom/facebook/imagepipeline/request/MediaVariations;->mMediaId:Ljava/lang/String;

    .line 70
    invoke-static {p1}, Lcom/facebook/imagepipeline/request/MediaVariations$Builder;->access$100(Lcom/facebook/imagepipeline/request/MediaVariations$Builder;)Ljava/util/List;

    move-result-object v0

    iput-object v0, p0, Lcom/facebook/imagepipeline/request/MediaVariations;->mVariants:Ljava/util/List;

    .line 71
    invoke-static {p1}, Lcom/facebook/imagepipeline/request/MediaVariations$Builder;->access$200(Lcom/facebook/imagepipeline/request/MediaVariations$Builder;)Z

    move-result v0

    iput-boolean v0, p0, Lcom/facebook/imagepipeline/request/MediaVariations;->mForceRequestForSpecifiedUri:Z

    .line 72
    invoke-static {p1}, Lcom/facebook/imagepipeline/request/MediaVariations$Builder;->access$300(Lcom/facebook/imagepipeline/request/MediaVariations$Builder;)Ljava/lang/String;

    move-result-object v0

    iput-object v0, p0, Lcom/facebook/imagepipeline/request/MediaVariations;->mSource:Ljava/lang/String;

    .line 73
    return-void
.end method

.method synthetic constructor <init>(Lcom/facebook/imagepipeline/request/MediaVariations$Builder;Lcom/facebook/imagepipeline/request/MediaVariations$1;)V
    .locals 0
    .param p1, "x0"    # Lcom/facebook/imagepipeline/request/MediaVariations$Builder;
    .param p2, "x1"    # Lcom/facebook/imagepipeline/request/MediaVariations$1;

    .prologue
    .line 44
    invoke-direct {p0, p1}, Lcom/facebook/imagepipeline/request/MediaVariations;-><init>(Lcom/facebook/imagepipeline/request/MediaVariations$Builder;)V

    return-void
.end method

.method public static forMediaId(Ljava/lang/String;)Lcom/facebook/imagepipeline/request/MediaVariations;
    .locals 1
    .param p0, "mediaId"    # Ljava/lang/String;
        .annotation runtime Ljavax/annotation/Nullable;
        .end annotation
    .end param
    .annotation runtime Ljavax/annotation/Nullable;
    .end annotation

    .prologue
    .line 244
    if-eqz p0, :cond_0

    invoke-virtual {p0}, Ljava/lang/String;->isEmpty()Z

    move-result v0

    if-eqz v0, :cond_1

    .line 245
    :cond_0
    const/4 v0, 0x0

    .line 247
    :goto_0
    return-object v0

    :cond_1
    invoke-static {p0}, Lcom/facebook/imagepipeline/request/MediaVariations;->newBuilderForMediaId(Ljava/lang/String;)Lcom/facebook/imagepipeline/request/MediaVariations$Builder;

    move-result-object v0

    invoke-virtual {v0}, Lcom/facebook/imagepipeline/request/MediaVariations$Builder;->build()Lcom/facebook/imagepipeline/request/MediaVariations;

    move-result-object v0

    goto :goto_0
.end method

.method public static newBuilderForMediaId(Ljava/lang/String;)Lcom/facebook/imagepipeline/request/MediaVariations$Builder;
    .locals 2
    .param p0, "mediaId"    # Ljava/lang/String;

    .prologue
    .line 259
    new-instance v0, Lcom/facebook/imagepipeline/request/MediaVariations$Builder;

    const/4 v1, 0x0

    invoke-direct {v0, p0, v1}, Lcom/facebook/imagepipeline/request/MediaVariations$Builder;-><init>(Ljava/lang/String;Lcom/facebook/imagepipeline/request/MediaVariations$1;)V

    return-object v0
.end method


# virtual methods
.method public equals(Ljava/lang/Object;)Z
    .locals 4
    .param p1, "o"    # Ljava/lang/Object;

    .prologue
    const/4 v1, 0x0

    .line 148
    instance-of v2, p1, Lcom/facebook/imagepipeline/request/MediaVariations;

    if-nez v2, :cond_1

    .line 154
    :cond_0
    :goto_0
    return v1

    :cond_1
    move-object v0, p1

    .line 151
    check-cast v0, Lcom/facebook/imagepipeline/request/MediaVariations;

    .line 152
    .local v0, "otherVariations":Lcom/facebook/imagepipeline/request/MediaVariations;
    iget-object v2, p0, Lcom/facebook/imagepipeline/request/MediaVariations;->mMediaId:Ljava/lang/String;

    iget-object v3, v0, Lcom/facebook/imagepipeline/request/MediaVariations;->mMediaId:Ljava/lang/String;

    invoke-static {v2, v3}, Lcom/facebook/common/internal/Objects;->equal(Ljava/lang/Object;Ljava/lang/Object;)Z

    move-result v2

    if-eqz v2, :cond_0

    iget-boolean v2, p0, Lcom/facebook/imagepipeline/request/MediaVariations;->mForceRequestForSpecifiedUri:Z

    iget-boolean v3, v0, Lcom/facebook/imagepipeline/request/MediaVariations;->mForceRequestForSpecifiedUri:Z

    if-ne v2, v3, :cond_0

    iget-object v2, p0, Lcom/facebook/imagepipeline/request/MediaVariations;->mVariants:Ljava/util/List;

    iget-object v3, v0, Lcom/facebook/imagepipeline/request/MediaVariations;->mVariants:Ljava/util/List;

    .line 154
    invoke-static {v2, v3}, Lcom/facebook/common/internal/Objects;->equal(Ljava/lang/Object;Ljava/lang/Object;)Z

    move-result v2

    if-eqz v2, :cond_0

    const/4 v1, 0x1

    goto :goto_0
.end method

.method public getMediaId()Ljava/lang/String;
    .locals 1

    .prologue
    .line 81
    iget-object v0, p0, Lcom/facebook/imagepipeline/request/MediaVariations;->mMediaId:Ljava/lang/String;

    return-object v0
.end method

.method public getSortedVariants(Ljava/util/Comparator;)Ljava/util/List;
    .locals 4
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/util/Comparator",
            "<",
            "Lcom/facebook/imagepipeline/request/MediaVariations$Variant;",
            ">;)",
            "Ljava/util/List",
            "<",
            "Lcom/facebook/imagepipeline/request/MediaVariations$Variant;",
            ">;"
        }
    .end annotation

    .prologue
    .line 112
    .local p1, "comparator":Ljava/util/Comparator;, "Ljava/util/Comparator<Lcom/facebook/imagepipeline/request/MediaVariations$Variant;>;"
    invoke-virtual {p0}, Lcom/facebook/imagepipeline/request/MediaVariations;->getVariantsCount()I

    move-result v2

    .line 113
    .local v2, "variantsCount":I
    if-nez v2, :cond_0

    .line 114
    invoke-static {}, Ljava/util/Collections;->emptyList()Ljava/util/List;

    move-result-object v1

    .line 124
    :goto_0
    return-object v1

    .line 117
    :cond_0
    new-instance v1, Ljava/util/ArrayList;

    invoke-direct {v1, v2}, Ljava/util/ArrayList;-><init>(I)V

    .line 118
    .local v1, "variants":Ljava/util/List;, "Ljava/util/List<Lcom/facebook/imagepipeline/request/MediaVariations$Variant;>;"
    const/4 v0, 0x0

    .local v0, "i":I
    :goto_1
    if-ge v0, v2, :cond_1

    .line 119
    iget-object v3, p0, Lcom/facebook/imagepipeline/request/MediaVariations;->mVariants:Ljava/util/List;

    invoke-interface {v3, v0}, Ljava/util/List;->get(I)Ljava/lang/Object;

    move-result-object v3

    invoke-interface {v1, v3}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    .line 118
    add-int/lit8 v0, v0, 0x1

    goto :goto_1

    .line 122
    :cond_1
    invoke-static {v1, p1}, Ljava/util/Collections;->sort(Ljava/util/List;Ljava/util/Comparator;)V

    goto :goto_0
.end method

.method public getSource()Ljava/lang/String;
    .locals 1

    .prologue
    .line 143
    iget-object v0, p0, Lcom/facebook/imagepipeline/request/MediaVariations;->mSource:Ljava/lang/String;

    return-object v0
.end method

.method public getVariant(I)Lcom/facebook/imagepipeline/request/MediaVariations$Variant;
    .locals 1
    .param p1, "index"    # I

    .prologue
    .line 105
    iget-object v0, p0, Lcom/facebook/imagepipeline/request/MediaVariations;->mVariants:Ljava/util/List;

    invoke-interface {v0, p1}, Ljava/util/List;->get(I)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/facebook/imagepipeline/request/MediaVariations$Variant;

    return-object v0
.end method

.method public getVariantsCount()I
    .locals 1

    .prologue
    .line 92
    iget-object v0, p0, Lcom/facebook/imagepipeline/request/MediaVariations;->mVariants:Ljava/util/List;

    if-nez v0, :cond_0

    const/4 v0, 0x0

    :goto_0
    return v0

    :cond_0
    iget-object v0, p0, Lcom/facebook/imagepipeline/request/MediaVariations;->mVariants:Ljava/util/List;

    invoke-interface {v0}, Ljava/util/List;->size()I

    move-result v0

    goto :goto_0
.end method

.method public hashCode()I
    .locals 3

    .prologue
    .line 159
    const/4 v0, 0x4

    new-array v0, v0, [Ljava/lang/Object;

    const/4 v1, 0x0

    iget-object v2, p0, Lcom/facebook/imagepipeline/request/MediaVariations;->mMediaId:Ljava/lang/String;

    aput-object v2, v0, v1

    const/4 v1, 0x1

    iget-boolean v2, p0, Lcom/facebook/imagepipeline/request/MediaVariations;->mForceRequestForSpecifiedUri:Z

    invoke-static {v2}, Ljava/lang/Boolean;->valueOf(Z)Ljava/lang/Boolean;

    move-result-object v2

    aput-object v2, v0, v1

    const/4 v1, 0x2

    iget-object v2, p0, Lcom/facebook/imagepipeline/request/MediaVariations;->mVariants:Ljava/util/List;

    aput-object v2, v0, v1

    const/4 v1, 0x3

    iget-object v2, p0, Lcom/facebook/imagepipeline/request/MediaVariations;->mSource:Ljava/lang/String;

    aput-object v2, v0, v1

    invoke-static {v0}, Lcom/facebook/common/internal/Objects;->hashCode([Ljava/lang/Object;)I

    move-result v0

    return v0
.end method

.method public shouldForceRequestForSpecifiedUri()Z
    .locals 1

    .prologue
    .line 134
    iget-boolean v0, p0, Lcom/facebook/imagepipeline/request/MediaVariations;->mForceRequestForSpecifiedUri:Z

    return v0
.end method

.method public toString()Ljava/lang/String;
    .locals 5

    .prologue
    .line 164
    const/4 v0, 0x0

    check-cast v0, Ljava/util/Locale;

    const-string v1, "%s-%b-%s-%s"

    const/4 v2, 0x4

    new-array v2, v2, [Ljava/lang/Object;

    const/4 v3, 0x0

    iget-object v4, p0, Lcom/facebook/imagepipeline/request/MediaVariations;->mMediaId:Ljava/lang/String;

    aput-object v4, v2, v3

    const/4 v3, 0x1

    iget-boolean v4, p0, Lcom/facebook/imagepipeline/request/MediaVariations;->mForceRequestForSpecifiedUri:Z

    .line 168
    invoke-static {v4}, Ljava/lang/Boolean;->valueOf(Z)Ljava/lang/Boolean;

    move-result-object v4

    aput-object v4, v2, v3

    const/4 v3, 0x2

    iget-object v4, p0, Lcom/facebook/imagepipeline/request/MediaVariations;->mVariants:Ljava/util/List;

    aput-object v4, v2, v3

    const/4 v3, 0x3

    iget-object v4, p0, Lcom/facebook/imagepipeline/request/MediaVariations;->mSource:Ljava/lang/String;

    aput-object v4, v2, v3

    .line 164
    invoke-static {v0, v1, v2}, Ljava/lang/String;->format(Ljava/util/Locale;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v0

    return-object v0
.end method

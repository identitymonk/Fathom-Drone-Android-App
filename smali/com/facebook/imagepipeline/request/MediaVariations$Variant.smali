.class public final Lcom/facebook/imagepipeline/request/MediaVariations$Variant;
.super Ljava/lang/Object;
.source "MediaVariations.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/facebook/imagepipeline/request/MediaVariations;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x19
    name = "Variant"
.end annotation


# instance fields
.field private final mCacheChoice:Lcom/facebook/imagepipeline/request/ImageRequest$CacheChoice;
    .annotation runtime Ljavax/annotation/Nullable;
    .end annotation
.end field

.field private final mHeight:I

.field private final mUri:Landroid/net/Uri;

.field private final mWidth:I


# direct methods
.method public constructor <init>(Landroid/net/Uri;II)V
    .locals 1
    .param p1, "uri"    # Landroid/net/Uri;
    .param p2, "width"    # I
    .param p3, "height"    # I

    .prologue
    .line 181
    const/4 v0, 0x0

    invoke-direct {p0, p1, p2, p3, v0}, Lcom/facebook/imagepipeline/request/MediaVariations$Variant;-><init>(Landroid/net/Uri;IILcom/facebook/imagepipeline/request/ImageRequest$CacheChoice;)V

    .line 182
    return-void
.end method

.method public constructor <init>(Landroid/net/Uri;IILcom/facebook/imagepipeline/request/ImageRequest$CacheChoice;)V
    .locals 0
    .param p1, "uri"    # Landroid/net/Uri;
    .param p2, "width"    # I
    .param p3, "height"    # I
    .param p4, "cacheChoice"    # Lcom/facebook/imagepipeline/request/ImageRequest$CacheChoice;
        .annotation runtime Ljavax/annotation/Nullable;
        .end annotation
    .end param

    .prologue
    .line 184
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 185
    iput-object p1, p0, Lcom/facebook/imagepipeline/request/MediaVariations$Variant;->mUri:Landroid/net/Uri;

    .line 186
    iput p2, p0, Lcom/facebook/imagepipeline/request/MediaVariations$Variant;->mWidth:I

    .line 187
    iput p3, p0, Lcom/facebook/imagepipeline/request/MediaVariations$Variant;->mHeight:I

    .line 188
    iput-object p4, p0, Lcom/facebook/imagepipeline/request/MediaVariations$Variant;->mCacheChoice:Lcom/facebook/imagepipeline/request/ImageRequest$CacheChoice;

    .line 189
    return-void
.end method


# virtual methods
.method public equals(Ljava/lang/Object;)Z
    .locals 4
    .param p1, "o"    # Ljava/lang/Object;

    .prologue
    const/4 v1, 0x0

    .line 210
    instance-of v2, p1, Lcom/facebook/imagepipeline/request/MediaVariations$Variant;

    if-nez v2, :cond_1

    .line 214
    :cond_0
    :goto_0
    return v1

    :cond_1
    move-object v0, p1

    .line 213
    check-cast v0, Lcom/facebook/imagepipeline/request/MediaVariations$Variant;

    .line 214
    .local v0, "otherVariant":Lcom/facebook/imagepipeline/request/MediaVariations$Variant;
    iget-object v2, p0, Lcom/facebook/imagepipeline/request/MediaVariations$Variant;->mUri:Landroid/net/Uri;

    iget-object v3, v0, Lcom/facebook/imagepipeline/request/MediaVariations$Variant;->mUri:Landroid/net/Uri;

    invoke-static {v2, v3}, Lcom/facebook/common/internal/Objects;->equal(Ljava/lang/Object;Ljava/lang/Object;)Z

    move-result v2

    if-eqz v2, :cond_0

    iget v2, p0, Lcom/facebook/imagepipeline/request/MediaVariations$Variant;->mWidth:I

    iget v3, v0, Lcom/facebook/imagepipeline/request/MediaVariations$Variant;->mWidth:I

    if-ne v2, v3, :cond_0

    iget v2, p0, Lcom/facebook/imagepipeline/request/MediaVariations$Variant;->mHeight:I

    iget v3, v0, Lcom/facebook/imagepipeline/request/MediaVariations$Variant;->mHeight:I

    if-ne v2, v3, :cond_0

    iget-object v2, p0, Lcom/facebook/imagepipeline/request/MediaVariations$Variant;->mCacheChoice:Lcom/facebook/imagepipeline/request/ImageRequest$CacheChoice;

    iget-object v3, v0, Lcom/facebook/imagepipeline/request/MediaVariations$Variant;->mCacheChoice:Lcom/facebook/imagepipeline/request/ImageRequest$CacheChoice;

    if-ne v2, v3, :cond_0

    const/4 v1, 0x1

    goto :goto_0
.end method

.method public getCacheChoice()Lcom/facebook/imagepipeline/request/ImageRequest$CacheChoice;
    .locals 1
    .annotation runtime Ljavax/annotation/Nullable;
    .end annotation

    .prologue
    .line 205
    iget-object v0, p0, Lcom/facebook/imagepipeline/request/MediaVariations$Variant;->mCacheChoice:Lcom/facebook/imagepipeline/request/ImageRequest$CacheChoice;

    return-object v0
.end method

.method public getHeight()I
    .locals 1

    .prologue
    .line 200
    iget v0, p0, Lcom/facebook/imagepipeline/request/MediaVariations$Variant;->mHeight:I

    return v0
.end method

.method public getUri()Landroid/net/Uri;
    .locals 1

    .prologue
    .line 192
    iget-object v0, p0, Lcom/facebook/imagepipeline/request/MediaVariations$Variant;->mUri:Landroid/net/Uri;

    return-object v0
.end method

.method public getWidth()I
    .locals 1

    .prologue
    .line 196
    iget v0, p0, Lcom/facebook/imagepipeline/request/MediaVariations$Variant;->mWidth:I

    return v0
.end method

.method public hashCode()I
    .locals 3

    .prologue
    .line 222
    iget-object v1, p0, Lcom/facebook/imagepipeline/request/MediaVariations$Variant;->mUri:Landroid/net/Uri;

    invoke-virtual {v1}, Landroid/net/Uri;->hashCode()I

    move-result v0

    .line 223
    .local v0, "hashCode":I
    mul-int/lit8 v1, v0, 0x1f

    iget v2, p0, Lcom/facebook/imagepipeline/request/MediaVariations$Variant;->mWidth:I

    add-int v0, v1, v2

    .line 224
    mul-int/lit8 v1, v0, 0x1f

    iget v2, p0, Lcom/facebook/imagepipeline/request/MediaVariations$Variant;->mHeight:I

    add-int v0, v1, v2

    .line 225
    return v0
.end method

.method public toString()Ljava/lang/String;
    .locals 5

    .prologue
    .line 230
    const/4 v0, 0x0

    check-cast v0, Ljava/util/Locale;

    const-string v1, "%dx%d %s %s"

    const/4 v2, 0x4

    new-array v2, v2, [Ljava/lang/Object;

    const/4 v3, 0x0

    iget v4, p0, Lcom/facebook/imagepipeline/request/MediaVariations$Variant;->mWidth:I

    invoke-static {v4}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v4

    aput-object v4, v2, v3

    const/4 v3, 0x1

    iget v4, p0, Lcom/facebook/imagepipeline/request/MediaVariations$Variant;->mHeight:I

    invoke-static {v4}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v4

    aput-object v4, v2, v3

    const/4 v3, 0x2

    iget-object v4, p0, Lcom/facebook/imagepipeline/request/MediaVariations$Variant;->mUri:Landroid/net/Uri;

    aput-object v4, v2, v3

    const/4 v3, 0x3

    iget-object v4, p0, Lcom/facebook/imagepipeline/request/MediaVariations$Variant;->mCacheChoice:Lcom/facebook/imagepipeline/request/ImageRequest$CacheChoice;

    aput-object v4, v2, v3

    invoke-static {v0, v1, v2}, Ljava/lang/String;->format(Ljava/util/Locale;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v0

    return-object v0
.end method

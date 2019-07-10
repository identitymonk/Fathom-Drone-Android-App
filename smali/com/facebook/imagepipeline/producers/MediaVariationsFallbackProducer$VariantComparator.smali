.class Lcom/facebook/imagepipeline/producers/MediaVariationsFallbackProducer$VariantComparator;
.super Ljava/lang/Object;
.source "MediaVariationsFallbackProducer.java"

# interfaces
.implements Ljava/util/Comparator;


# annotations
.annotation build Lcom/facebook/common/internal/VisibleForTesting;
.end annotation

.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/facebook/imagepipeline/producers/MediaVariationsFallbackProducer;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x8
    name = "VariantComparator"
.end annotation

.annotation system Ldalvik/annotation/Signature;
    value = {
        "Ljava/lang/Object;",
        "Ljava/util/Comparator",
        "<",
        "Lcom/facebook/imagepipeline/request/MediaVariations$Variant;",
        ">;"
    }
.end annotation


# instance fields
.field private final mResizeOptions:Lcom/facebook/imagepipeline/common/ResizeOptions;


# direct methods
.method constructor <init>(Lcom/facebook/imagepipeline/common/ResizeOptions;)V
    .locals 0
    .param p1, "resizeOptions"    # Lcom/facebook/imagepipeline/common/ResizeOptions;

    .prologue
    .line 442
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 443
    iput-object p1, p0, Lcom/facebook/imagepipeline/producers/MediaVariationsFallbackProducer$VariantComparator;->mResizeOptions:Lcom/facebook/imagepipeline/common/ResizeOptions;

    .line 444
    return-void
.end method


# virtual methods
.method public compare(Lcom/facebook/imagepipeline/request/MediaVariations$Variant;Lcom/facebook/imagepipeline/request/MediaVariations$Variant;)I
    .locals 4
    .param p1, "o1"    # Lcom/facebook/imagepipeline/request/MediaVariations$Variant;
    .param p2, "o2"    # Lcom/facebook/imagepipeline/request/MediaVariations$Variant;

    .prologue
    .line 448
    iget-object v2, p0, Lcom/facebook/imagepipeline/producers/MediaVariationsFallbackProducer$VariantComparator;->mResizeOptions:Lcom/facebook/imagepipeline/common/ResizeOptions;

    invoke-static {p1, v2}, Lcom/facebook/imagepipeline/producers/MediaVariationsFallbackProducer;->access$300(Lcom/facebook/imagepipeline/request/MediaVariations$Variant;Lcom/facebook/imagepipeline/common/ResizeOptions;)Z

    move-result v0

    .line 449
    .local v0, "o1BigEnough":Z
    iget-object v2, p0, Lcom/facebook/imagepipeline/producers/MediaVariationsFallbackProducer$VariantComparator;->mResizeOptions:Lcom/facebook/imagepipeline/common/ResizeOptions;

    invoke-static {p2, v2}, Lcom/facebook/imagepipeline/producers/MediaVariationsFallbackProducer;->access$300(Lcom/facebook/imagepipeline/request/MediaVariations$Variant;Lcom/facebook/imagepipeline/common/ResizeOptions;)Z

    move-result v1

    .line 451
    .local v1, "o2BigEnough":Z
    if-eqz v0, :cond_0

    if-eqz v1, :cond_0

    .line 453
    invoke-virtual {p1}, Lcom/facebook/imagepipeline/request/MediaVariations$Variant;->getWidth()I

    move-result v2

    invoke-virtual {p2}, Lcom/facebook/imagepipeline/request/MediaVariations$Variant;->getWidth()I

    move-result v3

    sub-int/2addr v2, v3

    .line 460
    :goto_0
    return v2

    .line 454
    :cond_0
    if-eqz v0, :cond_1

    .line 455
    const/4 v2, -0x1

    goto :goto_0

    .line 456
    :cond_1
    if-eqz v1, :cond_2

    .line 457
    const/4 v2, 0x1

    goto :goto_0

    .line 460
    :cond_2
    invoke-virtual {p2}, Lcom/facebook/imagepipeline/request/MediaVariations$Variant;->getWidth()I

    move-result v2

    invoke-virtual {p1}, Lcom/facebook/imagepipeline/request/MediaVariations$Variant;->getWidth()I

    move-result v3

    sub-int/2addr v2, v3

    goto :goto_0
.end method

.method public bridge synthetic compare(Ljava/lang/Object;Ljava/lang/Object;)I
    .locals 1

    .prologue
    .line 437
    check-cast p1, Lcom/facebook/imagepipeline/request/MediaVariations$Variant;

    check-cast p2, Lcom/facebook/imagepipeline/request/MediaVariations$Variant;

    invoke-virtual {p0, p1, p2}, Lcom/facebook/imagepipeline/producers/MediaVariationsFallbackProducer$VariantComparator;->compare(Lcom/facebook/imagepipeline/request/MediaVariations$Variant;Lcom/facebook/imagepipeline/request/MediaVariations$Variant;)I

    move-result v0

    return v0
.end method

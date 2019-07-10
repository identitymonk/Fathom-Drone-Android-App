.class public Lcom/facebook/react/modules/fresco/ReactNetworkImageRequest;
.super Lcom/facebook/imagepipeline/request/ImageRequest;
.source "ReactNetworkImageRequest.java"


# instance fields
.field private final mHeaders:Lcom/facebook/react/bridge/ReadableMap;


# direct methods
.method protected constructor <init>(Lcom/facebook/imagepipeline/request/ImageRequestBuilder;Lcom/facebook/react/bridge/ReadableMap;)V
    .locals 0
    .param p1, "builder"    # Lcom/facebook/imagepipeline/request/ImageRequestBuilder;
    .param p2, "headers"    # Lcom/facebook/react/bridge/ReadableMap;

    .prologue
    .line 28
    invoke-direct {p0, p1}, Lcom/facebook/imagepipeline/request/ImageRequest;-><init>(Lcom/facebook/imagepipeline/request/ImageRequestBuilder;)V

    .line 29
    iput-object p2, p0, Lcom/facebook/react/modules/fresco/ReactNetworkImageRequest;->mHeaders:Lcom/facebook/react/bridge/ReadableMap;

    .line 30
    return-void
.end method

.method public static fromBuilderWithHeaders(Lcom/facebook/imagepipeline/request/ImageRequestBuilder;Lcom/facebook/react/bridge/ReadableMap;)Lcom/facebook/react/modules/fresco/ReactNetworkImageRequest;
    .locals 1
    .param p0, "builder"    # Lcom/facebook/imagepipeline/request/ImageRequestBuilder;
    .param p1, "headers"    # Lcom/facebook/react/bridge/ReadableMap;

    .prologue
    .line 24
    new-instance v0, Lcom/facebook/react/modules/fresco/ReactNetworkImageRequest;

    invoke-direct {v0, p0, p1}, Lcom/facebook/react/modules/fresco/ReactNetworkImageRequest;-><init>(Lcom/facebook/imagepipeline/request/ImageRequestBuilder;Lcom/facebook/react/bridge/ReadableMap;)V

    return-object v0
.end method


# virtual methods
.method public getHeaders()Lcom/facebook/react/bridge/ReadableMap;
    .locals 1

    .prologue
    .line 33
    iget-object v0, p0, Lcom/facebook/react/modules/fresco/ReactNetworkImageRequest;->mHeaders:Lcom/facebook/react/bridge/ReadableMap;

    return-object v0
.end method

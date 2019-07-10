.class public Lcom/facebook/react/shell/MainPackageConfig;
.super Ljava/lang/Object;
.source "MainPackageConfig.java"


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lcom/facebook/react/shell/MainPackageConfig$Builder;
    }
.end annotation


# instance fields
.field private mFrescoConfig:Lcom/facebook/imagepipeline/core/ImagePipelineConfig;


# direct methods
.method private constructor <init>(Lcom/facebook/react/shell/MainPackageConfig$Builder;)V
    .locals 1
    .param p1, "builder"    # Lcom/facebook/react/shell/MainPackageConfig$Builder;

    .prologue
    .line 21
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 22
    invoke-static {p1}, Lcom/facebook/react/shell/MainPackageConfig$Builder;->access$000(Lcom/facebook/react/shell/MainPackageConfig$Builder;)Lcom/facebook/imagepipeline/core/ImagePipelineConfig;

    move-result-object v0

    iput-object v0, p0, Lcom/facebook/react/shell/MainPackageConfig;->mFrescoConfig:Lcom/facebook/imagepipeline/core/ImagePipelineConfig;

    .line 23
    return-void
.end method

.method synthetic constructor <init>(Lcom/facebook/react/shell/MainPackageConfig$Builder;Lcom/facebook/react/shell/MainPackageConfig$1;)V
    .locals 0
    .param p1, "x0"    # Lcom/facebook/react/shell/MainPackageConfig$Builder;
    .param p2, "x1"    # Lcom/facebook/react/shell/MainPackageConfig$1;

    .prologue
    .line 17
    invoke-direct {p0, p1}, Lcom/facebook/react/shell/MainPackageConfig;-><init>(Lcom/facebook/react/shell/MainPackageConfig$Builder;)V

    return-void
.end method


# virtual methods
.method public getFrescoConfig()Lcom/facebook/imagepipeline/core/ImagePipelineConfig;
    .locals 1

    .prologue
    .line 26
    iget-object v0, p0, Lcom/facebook/react/shell/MainPackageConfig;->mFrescoConfig:Lcom/facebook/imagepipeline/core/ImagePipelineConfig;

    return-object v0
.end method

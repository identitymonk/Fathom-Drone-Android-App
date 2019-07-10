.class Lcom/facebook/react/views/toolbar/ReactToolbar$IconImageInfo;
.super Ljava/lang/Object;
.source "ReactToolbar.java"

# interfaces
.implements Lcom/facebook/imagepipeline/image/ImageInfo;


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/facebook/react/views/toolbar/ReactToolbar;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0xa
    name = "IconImageInfo"
.end annotation


# instance fields
.field private mHeight:I

.field private mWidth:I


# direct methods
.method public constructor <init>(II)V
    .locals 0
    .param p1, "width"    # I
    .param p2, "height"    # I

    .prologue
    .line 114
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 115
    iput p1, p0, Lcom/facebook/react/views/toolbar/ReactToolbar$IconImageInfo;->mWidth:I

    .line 116
    iput p2, p0, Lcom/facebook/react/views/toolbar/ReactToolbar$IconImageInfo;->mHeight:I

    .line 117
    return-void
.end method


# virtual methods
.method public getHeight()I
    .locals 1

    .prologue
    .line 126
    iget v0, p0, Lcom/facebook/react/views/toolbar/ReactToolbar$IconImageInfo;->mHeight:I

    return v0
.end method

.method public getQualityInfo()Lcom/facebook/imagepipeline/image/QualityInfo;
    .locals 1

    .prologue
    .line 131
    const/4 v0, 0x0

    return-object v0
.end method

.method public getWidth()I
    .locals 1

    .prologue
    .line 121
    iget v0, p0, Lcom/facebook/react/views/toolbar/ReactToolbar$IconImageInfo;->mWidth:I

    return v0
.end method

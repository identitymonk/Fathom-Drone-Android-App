.class public Lcom/facebook/imagepipeline/bitmaps/SimpleBitmapReleaser;
.super Ljava/lang/Object;
.source "SimpleBitmapReleaser.java"

# interfaces
.implements Lcom/facebook/common/references/ResourceReleaser;


# annotations
.annotation system Ldalvik/annotation/Signature;
    value = {
        "Ljava/lang/Object;",
        "Lcom/facebook/common/references/ResourceReleaser",
        "<",
        "Landroid/graphics/Bitmap;",
        ">;"
    }
.end annotation


# static fields
.field private static sInstance:Lcom/facebook/imagepipeline/bitmaps/SimpleBitmapReleaser;


# direct methods
.method private constructor <init>()V
    .locals 0

    .prologue
    .line 30
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method

.method public static getInstance()Lcom/facebook/imagepipeline/bitmaps/SimpleBitmapReleaser;
    .locals 1

    .prologue
    .line 24
    sget-object v0, Lcom/facebook/imagepipeline/bitmaps/SimpleBitmapReleaser;->sInstance:Lcom/facebook/imagepipeline/bitmaps/SimpleBitmapReleaser;

    if-nez v0, :cond_0

    .line 25
    new-instance v0, Lcom/facebook/imagepipeline/bitmaps/SimpleBitmapReleaser;

    invoke-direct {v0}, Lcom/facebook/imagepipeline/bitmaps/SimpleBitmapReleaser;-><init>()V

    sput-object v0, Lcom/facebook/imagepipeline/bitmaps/SimpleBitmapReleaser;->sInstance:Lcom/facebook/imagepipeline/bitmaps/SimpleBitmapReleaser;

    .line 27
    :cond_0
    sget-object v0, Lcom/facebook/imagepipeline/bitmaps/SimpleBitmapReleaser;->sInstance:Lcom/facebook/imagepipeline/bitmaps/SimpleBitmapReleaser;

    return-object v0
.end method


# virtual methods
.method public release(Landroid/graphics/Bitmap;)V
    .locals 0
    .param p1, "value"    # Landroid/graphics/Bitmap;

    .prologue
    .line 34
    invoke-virtual {p1}, Landroid/graphics/Bitmap;->recycle()V

    .line 35
    return-void
.end method

.method public bridge synthetic release(Ljava/lang/Object;)V
    .locals 0

    .prologue
    .line 19
    check-cast p1, Landroid/graphics/Bitmap;

    invoke-virtual {p0, p1}, Lcom/facebook/imagepipeline/bitmaps/SimpleBitmapReleaser;->release(Landroid/graphics/Bitmap;)V

    return-void
.end method

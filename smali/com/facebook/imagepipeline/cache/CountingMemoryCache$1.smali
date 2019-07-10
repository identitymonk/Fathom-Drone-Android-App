.class Lcom/facebook/imagepipeline/cache/CountingMemoryCache$1;
.super Ljava/lang/Object;
.source "CountingMemoryCache.java"

# interfaces
.implements Lcom/facebook/imagepipeline/bitmaps/PlatformBitmapFactory$BitmapCreationObserver;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/facebook/imagepipeline/cache/CountingMemoryCache;-><init>(Lcom/facebook/imagepipeline/cache/ValueDescriptor;Lcom/facebook/imagepipeline/cache/CountingMemoryCache$CacheTrimStrategy;Lcom/facebook/common/internal/Supplier;Lcom/facebook/imagepipeline/bitmaps/PlatformBitmapFactory;Z)V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$0:Lcom/facebook/imagepipeline/cache/CountingMemoryCache;


# direct methods
.method constructor <init>(Lcom/facebook/imagepipeline/cache/CountingMemoryCache;)V
    .locals 0
    .param p1, "this$0"    # Lcom/facebook/imagepipeline/cache/CountingMemoryCache;

    .prologue
    .line 148
    .local p0, "this":Lcom/facebook/imagepipeline/cache/CountingMemoryCache$1;, "Lcom/facebook/imagepipeline/cache/CountingMemoryCache$1;"
    iput-object p1, p0, Lcom/facebook/imagepipeline/cache/CountingMemoryCache$1;->this$0:Lcom/facebook/imagepipeline/cache/CountingMemoryCache;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public onBitmapCreated(Landroid/graphics/Bitmap;Ljava/lang/Object;)V
    .locals 1
    .param p1, "bitmap"    # Landroid/graphics/Bitmap;
    .param p2, "callerContext"    # Ljava/lang/Object;

    .prologue
    .line 153
    .local p0, "this":Lcom/facebook/imagepipeline/cache/CountingMemoryCache$1;, "Lcom/facebook/imagepipeline/cache/CountingMemoryCache$1;"
    iget-object v0, p0, Lcom/facebook/imagepipeline/cache/CountingMemoryCache$1;->this$0:Lcom/facebook/imagepipeline/cache/CountingMemoryCache;

    iget-object v0, v0, Lcom/facebook/imagepipeline/cache/CountingMemoryCache;->mOtherEntries:Ljava/util/Map;

    invoke-interface {v0, p1, p2}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 154
    return-void
.end method

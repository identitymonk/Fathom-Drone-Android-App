.class Lcom/facebook/imagepipeline/cache/CountingMemoryCache$2;
.super Ljava/lang/Object;
.source "CountingMemoryCache.java"

# interfaces
.implements Lcom/facebook/imagepipeline/cache/ValueDescriptor;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/facebook/imagepipeline/cache/CountingMemoryCache;->wrapValueDescriptor(Lcom/facebook/imagepipeline/cache/ValueDescriptor;)Lcom/facebook/imagepipeline/cache/ValueDescriptor;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation

.annotation system Ldalvik/annotation/Signature;
    value = {
        "Ljava/lang/Object;",
        "Lcom/facebook/imagepipeline/cache/ValueDescriptor",
        "<",
        "Lcom/facebook/imagepipeline/cache/CountingMemoryCache$Entry",
        "<TK;TV;>;>;"
    }
.end annotation


# instance fields
.field final synthetic this$0:Lcom/facebook/imagepipeline/cache/CountingMemoryCache;

.field final synthetic val$evictableValueDescriptor:Lcom/facebook/imagepipeline/cache/ValueDescriptor;


# direct methods
.method constructor <init>(Lcom/facebook/imagepipeline/cache/CountingMemoryCache;Lcom/facebook/imagepipeline/cache/ValueDescriptor;)V
    .locals 0
    .param p1, "this$0"    # Lcom/facebook/imagepipeline/cache/CountingMemoryCache;

    .prologue
    .line 161
    .local p0, "this":Lcom/facebook/imagepipeline/cache/CountingMemoryCache$2;, "Lcom/facebook/imagepipeline/cache/CountingMemoryCache$2;"
    iput-object p1, p0, Lcom/facebook/imagepipeline/cache/CountingMemoryCache$2;->this$0:Lcom/facebook/imagepipeline/cache/CountingMemoryCache;

    iput-object p2, p0, Lcom/facebook/imagepipeline/cache/CountingMemoryCache$2;->val$evictableValueDescriptor:Lcom/facebook/imagepipeline/cache/ValueDescriptor;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public getSizeInBytes(Lcom/facebook/imagepipeline/cache/CountingMemoryCache$Entry;)I
    .locals 2
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Lcom/facebook/imagepipeline/cache/CountingMemoryCache$Entry",
            "<TK;TV;>;)I"
        }
    .end annotation

    .prologue
    .line 164
    .local p0, "this":Lcom/facebook/imagepipeline/cache/CountingMemoryCache$2;, "Lcom/facebook/imagepipeline/cache/CountingMemoryCache$2;"
    .local p1, "entry":Lcom/facebook/imagepipeline/cache/CountingMemoryCache$Entry;, "Lcom/facebook/imagepipeline/cache/CountingMemoryCache$Entry<TK;TV;>;"
    iget-object v0, p0, Lcom/facebook/imagepipeline/cache/CountingMemoryCache$2;->val$evictableValueDescriptor:Lcom/facebook/imagepipeline/cache/ValueDescriptor;

    iget-object v1, p1, Lcom/facebook/imagepipeline/cache/CountingMemoryCache$Entry;->valueRef:Lcom/facebook/common/references/CloseableReference;

    invoke-virtual {v1}, Lcom/facebook/common/references/CloseableReference;->get()Ljava/lang/Object;

    move-result-object v1

    invoke-interface {v0, v1}, Lcom/facebook/imagepipeline/cache/ValueDescriptor;->getSizeInBytes(Ljava/lang/Object;)I

    move-result v0

    return v0
.end method

.method public bridge synthetic getSizeInBytes(Ljava/lang/Object;)I
    .locals 1

    .prologue
    .line 161
    .local p0, "this":Lcom/facebook/imagepipeline/cache/CountingMemoryCache$2;, "Lcom/facebook/imagepipeline/cache/CountingMemoryCache$2;"
    check-cast p1, Lcom/facebook/imagepipeline/cache/CountingMemoryCache$Entry;

    invoke-virtual {p0, p1}, Lcom/facebook/imagepipeline/cache/CountingMemoryCache$2;->getSizeInBytes(Lcom/facebook/imagepipeline/cache/CountingMemoryCache$Entry;)I

    move-result v0

    return v0
.end method

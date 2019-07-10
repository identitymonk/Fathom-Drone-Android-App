.class final Lcom/facebook/common/references/CloseableReference$CloseableReferenceWithoutFinalizer$1;
.super Ljava/lang/Object;
.source "CloseableReference.java"

# interfaces
.implements Ljava/lang/Runnable;


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/facebook/common/references/CloseableReference$CloseableReferenceWithoutFinalizer;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x8
    name = null
.end annotation


# direct methods
.method constructor <init>()V
    .locals 0

    .prologue
    .line 303
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public run()V
    .locals 2

    .prologue
    .line 309
    :goto_0
    :try_start_0
    invoke-static {}, Lcom/facebook/common/references/CloseableReference$CloseableReferenceWithoutFinalizer;->access$400()Ljava/lang/ref/ReferenceQueue;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/ref/ReferenceQueue;->remove()Ljava/lang/ref/Reference;

    move-result-object v0

    check-cast v0, Lcom/facebook/common/references/CloseableReference$CloseableReferenceWithoutFinalizer$Destructor;

    .line 310
    .local v0, "ref":Lcom/facebook/common/references/CloseableReference$CloseableReferenceWithoutFinalizer$Destructor;
    const/4 v1, 0x0

    invoke-virtual {v0, v1}, Lcom/facebook/common/references/CloseableReference$CloseableReferenceWithoutFinalizer$Destructor;->destroy(Z)V
    :try_end_0
    .catch Ljava/lang/InterruptedException; {:try_start_0 .. :try_end_0} :catch_0

    goto :goto_0

    .line 311
    .end local v0    # "ref":Lcom/facebook/common/references/CloseableReference$CloseableReferenceWithoutFinalizer$Destructor;
    :catch_0
    move-exception v1

    goto :goto_0
.end method

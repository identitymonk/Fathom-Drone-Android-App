.class Lcom/facebook/drawee/components/DeferredReleaser$1;
.super Ljava/lang/Object;
.source "DeferredReleaser.java"

# interfaces
.implements Ljava/lang/Runnable;


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/facebook/drawee/components/DeferredReleaser;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$0:Lcom/facebook/drawee/components/DeferredReleaser;


# direct methods
.method constructor <init>(Lcom/facebook/drawee/components/DeferredReleaser;)V
    .locals 0
    .param p1, "this$0"    # Lcom/facebook/drawee/components/DeferredReleaser;

    .prologue
    .line 62
    iput-object p1, p0, Lcom/facebook/drawee/components/DeferredReleaser$1;->this$0:Lcom/facebook/drawee/components/DeferredReleaser;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public run()V
    .locals 3

    .prologue
    .line 65
    invoke-static {}, Lcom/facebook/drawee/components/DeferredReleaser;->access$000()V

    .line 66
    iget-object v1, p0, Lcom/facebook/drawee/components/DeferredReleaser$1;->this$0:Lcom/facebook/drawee/components/DeferredReleaser;

    invoke-static {v1}, Lcom/facebook/drawee/components/DeferredReleaser;->access$100(Lcom/facebook/drawee/components/DeferredReleaser;)Ljava/util/Set;

    move-result-object v1

    invoke-interface {v1}, Ljava/util/Set;->iterator()Ljava/util/Iterator;

    move-result-object v1

    :goto_0
    invoke-interface {v1}, Ljava/util/Iterator;->hasNext()Z

    move-result v2

    if-eqz v2, :cond_0

    invoke-interface {v1}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/facebook/drawee/components/DeferredReleaser$Releasable;

    .line 67
    .local v0, "releasable":Lcom/facebook/drawee/components/DeferredReleaser$Releasable;
    invoke-interface {v0}, Lcom/facebook/drawee/components/DeferredReleaser$Releasable;->release()V

    goto :goto_0

    .line 69
    .end local v0    # "releasable":Lcom/facebook/drawee/components/DeferredReleaser$Releasable;
    :cond_0
    iget-object v1, p0, Lcom/facebook/drawee/components/DeferredReleaser$1;->this$0:Lcom/facebook/drawee/components/DeferredReleaser;

    invoke-static {v1}, Lcom/facebook/drawee/components/DeferredReleaser;->access$100(Lcom/facebook/drawee/components/DeferredReleaser;)Ljava/util/Set;

    move-result-object v1

    invoke-interface {v1}, Ljava/util/Set;->clear()V

    .line 70
    return-void
.end method

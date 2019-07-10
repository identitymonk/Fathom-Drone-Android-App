.class Lcom/facebook/react/views/scroll/ReactScrollView$1;
.super Ljava/lang/Object;
.source "ReactScrollView.java"

# interfaces
.implements Ljava/lang/Runnable;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/facebook/react/views/scroll/ReactScrollView;->fling(I)V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$0:Lcom/facebook/react/views/scroll/ReactScrollView;


# direct methods
.method constructor <init>(Lcom/facebook/react/views/scroll/ReactScrollView;)V
    .locals 0
    .param p1, "this$0"    # Lcom/facebook/react/views/scroll/ReactScrollView;

    .prologue
    .line 283
    iput-object p1, p0, Lcom/facebook/react/views/scroll/ReactScrollView$1;->this$0:Lcom/facebook/react/views/scroll/ReactScrollView;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public run()V
    .locals 4

    .prologue
    .line 286
    iget-object v0, p0, Lcom/facebook/react/views/scroll/ReactScrollView$1;->this$0:Lcom/facebook/react/views/scroll/ReactScrollView;

    invoke-static {v0}, Lcom/facebook/react/views/scroll/ReactScrollView;->access$000(Lcom/facebook/react/views/scroll/ReactScrollView;)Z

    move-result v0

    if-eqz v0, :cond_0

    .line 287
    iget-object v0, p0, Lcom/facebook/react/views/scroll/ReactScrollView$1;->this$0:Lcom/facebook/react/views/scroll/ReactScrollView;

    const/4 v1, 0x0

    invoke-static {v0, v1}, Lcom/facebook/react/views/scroll/ReactScrollView;->access$102(Lcom/facebook/react/views/scroll/ReactScrollView;Z)Z

    .line 288
    iget-object v0, p0, Lcom/facebook/react/views/scroll/ReactScrollView$1;->this$0:Lcom/facebook/react/views/scroll/ReactScrollView;

    invoke-static {v0}, Lcom/facebook/react/views/scroll/ReactScrollView;->access$200(Lcom/facebook/react/views/scroll/ReactScrollView;)V

    .line 289
    iget-object v0, p0, Lcom/facebook/react/views/scroll/ReactScrollView$1;->this$0:Lcom/facebook/react/views/scroll/ReactScrollView;

    invoke-static {v0}, Lcom/facebook/react/views/scroll/ReactScrollViewHelper;->emitScrollMomentumEndEvent(Landroid/view/ViewGroup;)V

    .line 294
    :goto_0
    return-void

    .line 291
    :cond_0
    iget-object v0, p0, Lcom/facebook/react/views/scroll/ReactScrollView$1;->this$0:Lcom/facebook/react/views/scroll/ReactScrollView;

    const/4 v1, 0x1

    invoke-static {v0, v1}, Lcom/facebook/react/views/scroll/ReactScrollView;->access$002(Lcom/facebook/react/views/scroll/ReactScrollView;Z)Z

    .line 292
    iget-object v0, p0, Lcom/facebook/react/views/scroll/ReactScrollView$1;->this$0:Lcom/facebook/react/views/scroll/ReactScrollView;

    const-wide/16 v2, 0x14

    invoke-virtual {v0, p0, v2, v3}, Lcom/facebook/react/views/scroll/ReactScrollView;->postOnAnimationDelayed(Ljava/lang/Runnable;J)V

    goto :goto_0
.end method

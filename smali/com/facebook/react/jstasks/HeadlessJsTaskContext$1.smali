.class Lcom/facebook/react/jstasks/HeadlessJsTaskContext$1;
.super Ljava/lang/Object;
.source "HeadlessJsTaskContext.java"

# interfaces
.implements Ljava/lang/Runnable;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/facebook/react/jstasks/HeadlessJsTaskContext;->finishTask(I)V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$0:Lcom/facebook/react/jstasks/HeadlessJsTaskContext;

.field final synthetic val$taskId:I


# direct methods
.method constructor <init>(Lcom/facebook/react/jstasks/HeadlessJsTaskContext;I)V
    .locals 0
    .param p1, "this$0"    # Lcom/facebook/react/jstasks/HeadlessJsTaskContext;

    .prologue
    .line 123
    iput-object p1, p0, Lcom/facebook/react/jstasks/HeadlessJsTaskContext$1;->this$0:Lcom/facebook/react/jstasks/HeadlessJsTaskContext;

    iput p2, p0, Lcom/facebook/react/jstasks/HeadlessJsTaskContext$1;->val$taskId:I

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public run()V
    .locals 3

    .prologue
    .line 126
    iget-object v1, p0, Lcom/facebook/react/jstasks/HeadlessJsTaskContext$1;->this$0:Lcom/facebook/react/jstasks/HeadlessJsTaskContext;

    invoke-static {v1}, Lcom/facebook/react/jstasks/HeadlessJsTaskContext;->access$000(Lcom/facebook/react/jstasks/HeadlessJsTaskContext;)Ljava/util/Set;

    move-result-object v1

    invoke-interface {v1}, Ljava/util/Set;->iterator()Ljava/util/Iterator;

    move-result-object v1

    :goto_0
    invoke-interface {v1}, Ljava/util/Iterator;->hasNext()Z

    move-result v2

    if-eqz v2, :cond_0

    invoke-interface {v1}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/facebook/react/jstasks/HeadlessJsTaskEventListener;

    .line 127
    .local v0, "listener":Lcom/facebook/react/jstasks/HeadlessJsTaskEventListener;
    iget v2, p0, Lcom/facebook/react/jstasks/HeadlessJsTaskContext$1;->val$taskId:I

    invoke-interface {v0, v2}, Lcom/facebook/react/jstasks/HeadlessJsTaskEventListener;->onHeadlessJsTaskFinish(I)V

    goto :goto_0

    .line 129
    .end local v0    # "listener":Lcom/facebook/react/jstasks/HeadlessJsTaskEventListener;
    :cond_0
    return-void
.end method

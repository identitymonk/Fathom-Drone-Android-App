.class Lcom/facebook/react/HeadlessJsTaskService$2;
.super Ljava/lang/Object;
.source "HeadlessJsTaskService.java"

# interfaces
.implements Ljava/lang/Runnable;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/facebook/react/HeadlessJsTaskService;->invokeStartTask(Lcom/facebook/react/bridge/ReactContext;Lcom/facebook/react/jstasks/HeadlessJsTaskConfig;)V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$0:Lcom/facebook/react/HeadlessJsTaskService;

.field final synthetic val$headlessJsTaskContext:Lcom/facebook/react/jstasks/HeadlessJsTaskContext;

.field final synthetic val$taskConfig:Lcom/facebook/react/jstasks/HeadlessJsTaskConfig;


# direct methods
.method constructor <init>(Lcom/facebook/react/HeadlessJsTaskService;Lcom/facebook/react/jstasks/HeadlessJsTaskContext;Lcom/facebook/react/jstasks/HeadlessJsTaskConfig;)V
    .locals 0
    .param p1, "this$0"    # Lcom/facebook/react/HeadlessJsTaskService;

    .prologue
    .line 124
    iput-object p1, p0, Lcom/facebook/react/HeadlessJsTaskService$2;->this$0:Lcom/facebook/react/HeadlessJsTaskService;

    iput-object p2, p0, Lcom/facebook/react/HeadlessJsTaskService$2;->val$headlessJsTaskContext:Lcom/facebook/react/jstasks/HeadlessJsTaskContext;

    iput-object p3, p0, Lcom/facebook/react/HeadlessJsTaskService$2;->val$taskConfig:Lcom/facebook/react/jstasks/HeadlessJsTaskConfig;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public run()V
    .locals 3

    .prologue
    .line 127
    iget-object v1, p0, Lcom/facebook/react/HeadlessJsTaskService$2;->val$headlessJsTaskContext:Lcom/facebook/react/jstasks/HeadlessJsTaskContext;

    iget-object v2, p0, Lcom/facebook/react/HeadlessJsTaskService$2;->val$taskConfig:Lcom/facebook/react/jstasks/HeadlessJsTaskConfig;

    invoke-virtual {v1, v2}, Lcom/facebook/react/jstasks/HeadlessJsTaskContext;->startTask(Lcom/facebook/react/jstasks/HeadlessJsTaskConfig;)I

    move-result v0

    .line 128
    .local v0, "taskId":I
    iget-object v1, p0, Lcom/facebook/react/HeadlessJsTaskService$2;->this$0:Lcom/facebook/react/HeadlessJsTaskService;

    invoke-static {v1}, Lcom/facebook/react/HeadlessJsTaskService;->access$100(Lcom/facebook/react/HeadlessJsTaskService;)Ljava/util/Set;

    move-result-object v1

    invoke-static {v0}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v2

    invoke-interface {v1, v2}, Ljava/util/Set;->add(Ljava/lang/Object;)Z

    .line 129
    return-void
.end method

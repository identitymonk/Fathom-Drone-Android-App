.class Lcom/facebook/datasource/AbstractDataSource$1;
.super Ljava/lang/Object;
.source "AbstractDataSource.java"

# interfaces
.implements Ljava/lang/Runnable;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/facebook/datasource/AbstractDataSource;->notifyDataSubscriber(Lcom/facebook/datasource/DataSubscriber;Ljava/util/concurrent/Executor;ZZ)V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$0:Lcom/facebook/datasource/AbstractDataSource;

.field final synthetic val$dataSubscriber:Lcom/facebook/datasource/DataSubscriber;

.field final synthetic val$isCancellation:Z

.field final synthetic val$isFailure:Z


# direct methods
.method constructor <init>(Lcom/facebook/datasource/AbstractDataSource;ZLcom/facebook/datasource/DataSubscriber;Z)V
    .locals 0
    .param p1, "this$0"    # Lcom/facebook/datasource/AbstractDataSource;

    .prologue
    .line 173
    .local p0, "this":Lcom/facebook/datasource/AbstractDataSource$1;, "Lcom/facebook/datasource/AbstractDataSource$1;"
    iput-object p1, p0, Lcom/facebook/datasource/AbstractDataSource$1;->this$0:Lcom/facebook/datasource/AbstractDataSource;

    iput-boolean p2, p0, Lcom/facebook/datasource/AbstractDataSource$1;->val$isFailure:Z

    iput-object p3, p0, Lcom/facebook/datasource/AbstractDataSource$1;->val$dataSubscriber:Lcom/facebook/datasource/DataSubscriber;

    iput-boolean p4, p0, Lcom/facebook/datasource/AbstractDataSource$1;->val$isCancellation:Z

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public run()V
    .locals 2

    .prologue
    .line 176
    .local p0, "this":Lcom/facebook/datasource/AbstractDataSource$1;, "Lcom/facebook/datasource/AbstractDataSource$1;"
    iget-boolean v0, p0, Lcom/facebook/datasource/AbstractDataSource$1;->val$isFailure:Z

    if-eqz v0, :cond_0

    .line 177
    iget-object v0, p0, Lcom/facebook/datasource/AbstractDataSource$1;->val$dataSubscriber:Lcom/facebook/datasource/DataSubscriber;

    iget-object v1, p0, Lcom/facebook/datasource/AbstractDataSource$1;->this$0:Lcom/facebook/datasource/AbstractDataSource;

    invoke-interface {v0, v1}, Lcom/facebook/datasource/DataSubscriber;->onFailure(Lcom/facebook/datasource/DataSource;)V

    .line 183
    :goto_0
    return-void

    .line 178
    :cond_0
    iget-boolean v0, p0, Lcom/facebook/datasource/AbstractDataSource$1;->val$isCancellation:Z

    if-eqz v0, :cond_1

    .line 179
    iget-object v0, p0, Lcom/facebook/datasource/AbstractDataSource$1;->val$dataSubscriber:Lcom/facebook/datasource/DataSubscriber;

    iget-object v1, p0, Lcom/facebook/datasource/AbstractDataSource$1;->this$0:Lcom/facebook/datasource/AbstractDataSource;

    invoke-interface {v0, v1}, Lcom/facebook/datasource/DataSubscriber;->onCancellation(Lcom/facebook/datasource/DataSource;)V

    goto :goto_0

    .line 181
    :cond_1
    iget-object v0, p0, Lcom/facebook/datasource/AbstractDataSource$1;->val$dataSubscriber:Lcom/facebook/datasource/DataSubscriber;

    iget-object v1, p0, Lcom/facebook/datasource/AbstractDataSource$1;->this$0:Lcom/facebook/datasource/AbstractDataSource;

    invoke-interface {v0, v1}, Lcom/facebook/datasource/DataSubscriber;->onNewResult(Lcom/facebook/datasource/DataSource;)V

    goto :goto_0
.end method

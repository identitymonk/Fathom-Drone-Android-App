.class Lcom/facebook/react/devsupport/RedBoxDialog$2;
.super Ljava/lang/Object;
.source "RedBoxDialog.java"

# interfaces
.implements Landroid/view/View$OnClickListener;


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/facebook/react/devsupport/RedBoxDialog;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$0:Lcom/facebook/react/devsupport/RedBoxDialog;


# direct methods
.method constructor <init>(Lcom/facebook/react/devsupport/RedBoxDialog;)V
    .locals 0
    .param p1, "this$0"    # Lcom/facebook/react/devsupport/RedBoxDialog;

    .prologue
    .line 84
    iput-object p1, p0, Lcom/facebook/react/devsupport/RedBoxDialog$2;->this$0:Lcom/facebook/react/devsupport/RedBoxDialog;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public onClick(Landroid/view/View;)V
    .locals 6
    .param p1, "view"    # Landroid/view/View;

    .prologue
    const/4 v5, 0x0

    .line 87
    iget-object v3, p0, Lcom/facebook/react/devsupport/RedBoxDialog$2;->this$0:Lcom/facebook/react/devsupport/RedBoxDialog;

    invoke-static {v3}, Lcom/facebook/react/devsupport/RedBoxDialog;->access$400(Lcom/facebook/react/devsupport/RedBoxDialog;)Lcom/facebook/react/devsupport/RedBoxHandler;

    move-result-object v3

    if-eqz v3, :cond_0

    iget-object v3, p0, Lcom/facebook/react/devsupport/RedBoxDialog$2;->this$0:Lcom/facebook/react/devsupport/RedBoxDialog;

    invoke-static {v3}, Lcom/facebook/react/devsupport/RedBoxDialog;->access$400(Lcom/facebook/react/devsupport/RedBoxDialog;)Lcom/facebook/react/devsupport/RedBoxHandler;

    move-result-object v3

    invoke-interface {v3}, Lcom/facebook/react/devsupport/RedBoxHandler;->isReportEnabled()Z

    move-result v3

    if-eqz v3, :cond_0

    iget-object v3, p0, Lcom/facebook/react/devsupport/RedBoxDialog$2;->this$0:Lcom/facebook/react/devsupport/RedBoxDialog;

    invoke-static {v3}, Lcom/facebook/react/devsupport/RedBoxDialog;->access$000(Lcom/facebook/react/devsupport/RedBoxDialog;)Z

    move-result v3

    if-eqz v3, :cond_1

    .line 106
    :cond_0
    :goto_0
    return-void

    .line 90
    :cond_1
    iget-object v3, p0, Lcom/facebook/react/devsupport/RedBoxDialog$2;->this$0:Lcom/facebook/react/devsupport/RedBoxDialog;

    const/4 v4, 0x1

    invoke-static {v3, v4}, Lcom/facebook/react/devsupport/RedBoxDialog;->access$002(Lcom/facebook/react/devsupport/RedBoxDialog;Z)Z

    .line 91
    iget-object v3, p0, Lcom/facebook/react/devsupport/RedBoxDialog$2;->this$0:Lcom/facebook/react/devsupport/RedBoxDialog;

    invoke-static {v3}, Lcom/facebook/react/devsupport/RedBoxDialog;->access$300(Lcom/facebook/react/devsupport/RedBoxDialog;)Landroid/widget/TextView;

    move-result-object v3

    invoke-static {v3}, Lcom/facebook/infer/annotation/Assertions;->assertNotNull(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v3

    check-cast v3, Landroid/widget/TextView;

    const-string v4, "Reporting..."

    invoke-virtual {v3, v4}, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V

    .line 92
    iget-object v3, p0, Lcom/facebook/react/devsupport/RedBoxDialog$2;->this$0:Lcom/facebook/react/devsupport/RedBoxDialog;

    invoke-static {v3}, Lcom/facebook/react/devsupport/RedBoxDialog;->access$300(Lcom/facebook/react/devsupport/RedBoxDialog;)Landroid/widget/TextView;

    move-result-object v3

    invoke-static {v3}, Lcom/facebook/infer/annotation/Assertions;->assertNotNull(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v3

    check-cast v3, Landroid/widget/TextView;

    invoke-virtual {v3, v5}, Landroid/widget/TextView;->setVisibility(I)V

    .line 93
    iget-object v3, p0, Lcom/facebook/react/devsupport/RedBoxDialog$2;->this$0:Lcom/facebook/react/devsupport/RedBoxDialog;

    invoke-static {v3}, Lcom/facebook/react/devsupport/RedBoxDialog;->access$200(Lcom/facebook/react/devsupport/RedBoxDialog;)Landroid/widget/ProgressBar;

    move-result-object v3

    invoke-static {v3}, Lcom/facebook/infer/annotation/Assertions;->assertNotNull(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v3

    check-cast v3, Landroid/widget/ProgressBar;

    invoke-virtual {v3, v5}, Landroid/widget/ProgressBar;->setVisibility(I)V

    .line 94
    iget-object v3, p0, Lcom/facebook/react/devsupport/RedBoxDialog$2;->this$0:Lcom/facebook/react/devsupport/RedBoxDialog;

    invoke-static {v3}, Lcom/facebook/react/devsupport/RedBoxDialog;->access$500(Lcom/facebook/react/devsupport/RedBoxDialog;)Landroid/view/View;

    move-result-object v3

    invoke-static {v3}, Lcom/facebook/infer/annotation/Assertions;->assertNotNull(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v3

    check-cast v3, Landroid/view/View;

    invoke-virtual {v3, v5}, Landroid/view/View;->setVisibility(I)V

    .line 95
    iget-object v3, p0, Lcom/facebook/react/devsupport/RedBoxDialog$2;->this$0:Lcom/facebook/react/devsupport/RedBoxDialog;

    invoke-static {v3}, Lcom/facebook/react/devsupport/RedBoxDialog;->access$100(Lcom/facebook/react/devsupport/RedBoxDialog;)Landroid/widget/Button;

    move-result-object v3

    invoke-static {v3}, Lcom/facebook/infer/annotation/Assertions;->assertNotNull(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v3

    check-cast v3, Landroid/widget/Button;

    invoke-virtual {v3, v5}, Landroid/widget/Button;->setEnabled(Z)V

    .line 97
    iget-object v3, p0, Lcom/facebook/react/devsupport/RedBoxDialog$2;->this$0:Lcom/facebook/react/devsupport/RedBoxDialog;

    invoke-static {v3}, Lcom/facebook/react/devsupport/RedBoxDialog;->access$600(Lcom/facebook/react/devsupport/RedBoxDialog;)Lcom/facebook/react/devsupport/interfaces/DevSupportManager;

    move-result-object v3

    invoke-interface {v3}, Lcom/facebook/react/devsupport/interfaces/DevSupportManager;->getLastErrorTitle()Ljava/lang/String;

    move-result-object v3

    invoke-static {v3}, Lcom/facebook/infer/annotation/Assertions;->assertNotNull(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v2

    check-cast v2, Ljava/lang/String;

    .line 98
    .local v2, "title":Ljava/lang/String;
    iget-object v3, p0, Lcom/facebook/react/devsupport/RedBoxDialog$2;->this$0:Lcom/facebook/react/devsupport/RedBoxDialog;

    invoke-static {v3}, Lcom/facebook/react/devsupport/RedBoxDialog;->access$600(Lcom/facebook/react/devsupport/RedBoxDialog;)Lcom/facebook/react/devsupport/interfaces/DevSupportManager;

    move-result-object v3

    invoke-interface {v3}, Lcom/facebook/react/devsupport/interfaces/DevSupportManager;->getLastErrorStack()[Lcom/facebook/react/devsupport/interfaces/StackFrame;

    move-result-object v3

    invoke-static {v3}, Lcom/facebook/infer/annotation/Assertions;->assertNotNull(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v1

    check-cast v1, [Lcom/facebook/react/devsupport/interfaces/StackFrame;

    .line 99
    .local v1, "stack":[Lcom/facebook/react/devsupport/interfaces/StackFrame;
    iget-object v3, p0, Lcom/facebook/react/devsupport/RedBoxDialog$2;->this$0:Lcom/facebook/react/devsupport/RedBoxDialog;

    invoke-static {v3}, Lcom/facebook/react/devsupport/RedBoxDialog;->access$600(Lcom/facebook/react/devsupport/RedBoxDialog;)Lcom/facebook/react/devsupport/interfaces/DevSupportManager;

    move-result-object v3

    invoke-interface {v3}, Lcom/facebook/react/devsupport/interfaces/DevSupportManager;->getSourceUrl()Ljava/lang/String;

    move-result-object v0

    .line 101
    .local v0, "sourceUrl":Ljava/lang/String;
    iget-object v3, p0, Lcom/facebook/react/devsupport/RedBoxDialog$2;->this$0:Lcom/facebook/react/devsupport/RedBoxDialog;

    invoke-static {v3}, Lcom/facebook/react/devsupport/RedBoxDialog;->access$400(Lcom/facebook/react/devsupport/RedBoxDialog;)Lcom/facebook/react/devsupport/RedBoxHandler;

    move-result-object v4

    iget-object v3, p0, Lcom/facebook/react/devsupport/RedBoxDialog$2;->this$0:Lcom/facebook/react/devsupport/RedBoxDialog;

    .line 105
    invoke-static {v3}, Lcom/facebook/react/devsupport/RedBoxDialog;->access$700(Lcom/facebook/react/devsupport/RedBoxDialog;)Lcom/facebook/react/devsupport/RedBoxHandler$ReportCompletedListener;

    move-result-object v3

    invoke-static {v3}, Lcom/facebook/infer/annotation/Assertions;->assertNotNull(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v3

    check-cast v3, Lcom/facebook/react/devsupport/RedBoxHandler$ReportCompletedListener;

    .line 101
    invoke-interface {v4, v2, v1, v0, v3}, Lcom/facebook/react/devsupport/RedBoxHandler;->reportRedbox(Ljava/lang/String;[Lcom/facebook/react/devsupport/interfaces/StackFrame;Ljava/lang/String;Lcom/facebook/react/devsupport/RedBoxHandler$ReportCompletedListener;)V

    goto/16 :goto_0
.end method

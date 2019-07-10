.class Lcom/facebook/react/devsupport/DevLoadingViewController$1;
.super Ljava/lang/Object;
.source "DevLoadingViewController.java"

# interfaces
.implements Ljava/lang/Runnable;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/facebook/react/devsupport/DevLoadingViewController;->showMessage(Ljava/lang/String;II)V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$0:Lcom/facebook/react/devsupport/DevLoadingViewController;

.field final synthetic val$backgroundColor:I

.field final synthetic val$color:I

.field final synthetic val$message:Ljava/lang/String;


# direct methods
.method constructor <init>(Lcom/facebook/react/devsupport/DevLoadingViewController;ILjava/lang/String;I)V
    .locals 0
    .param p1, "this$0"    # Lcom/facebook/react/devsupport/DevLoadingViewController;

    .prologue
    .line 64
    iput-object p1, p0, Lcom/facebook/react/devsupport/DevLoadingViewController$1;->this$0:Lcom/facebook/react/devsupport/DevLoadingViewController;

    iput p2, p0, Lcom/facebook/react/devsupport/DevLoadingViewController$1;->val$backgroundColor:I

    iput-object p3, p0, Lcom/facebook/react/devsupport/DevLoadingViewController$1;->val$message:Ljava/lang/String;

    iput p4, p0, Lcom/facebook/react/devsupport/DevLoadingViewController$1;->val$color:I

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public run()V
    .locals 2

    .prologue
    .line 67
    iget-object v0, p0, Lcom/facebook/react/devsupport/DevLoadingViewController$1;->this$0:Lcom/facebook/react/devsupport/DevLoadingViewController;

    invoke-static {v0}, Lcom/facebook/react/devsupport/DevLoadingViewController;->access$000(Lcom/facebook/react/devsupport/DevLoadingViewController;)Landroid/widget/TextView;

    move-result-object v0

    iget v1, p0, Lcom/facebook/react/devsupport/DevLoadingViewController$1;->val$backgroundColor:I

    invoke-virtual {v0, v1}, Landroid/widget/TextView;->setBackgroundColor(I)V

    .line 68
    iget-object v0, p0, Lcom/facebook/react/devsupport/DevLoadingViewController$1;->this$0:Lcom/facebook/react/devsupport/DevLoadingViewController;

    invoke-static {v0}, Lcom/facebook/react/devsupport/DevLoadingViewController;->access$000(Lcom/facebook/react/devsupport/DevLoadingViewController;)Landroid/widget/TextView;

    move-result-object v0

    iget-object v1, p0, Lcom/facebook/react/devsupport/DevLoadingViewController$1;->val$message:Ljava/lang/String;

    invoke-virtual {v0, v1}, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V

    .line 69
    iget-object v0, p0, Lcom/facebook/react/devsupport/DevLoadingViewController$1;->this$0:Lcom/facebook/react/devsupport/DevLoadingViewController;

    invoke-static {v0}, Lcom/facebook/react/devsupport/DevLoadingViewController;->access$000(Lcom/facebook/react/devsupport/DevLoadingViewController;)Landroid/widget/TextView;

    move-result-object v0

    iget v1, p0, Lcom/facebook/react/devsupport/DevLoadingViewController$1;->val$color:I

    invoke-virtual {v0, v1}, Landroid/widget/TextView;->setTextColor(I)V

    .line 71
    iget-object v0, p0, Lcom/facebook/react/devsupport/DevLoadingViewController$1;->this$0:Lcom/facebook/react/devsupport/DevLoadingViewController;

    const/4 v1, 0x1

    invoke-static {v0, v1}, Lcom/facebook/react/devsupport/DevLoadingViewController;->access$100(Lcom/facebook/react/devsupport/DevLoadingViewController;Z)V

    .line 72
    return-void
.end method

.class Lcom/facebook/react/modules/toast/ToastModule$2;
.super Ljava/lang/Object;
.source "ToastModule.java"

# interfaces
.implements Ljava/lang/Runnable;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/facebook/react/modules/toast/ToastModule;->showWithGravity(Ljava/lang/String;II)V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$0:Lcom/facebook/react/modules/toast/ToastModule;

.field final synthetic val$duration:I

.field final synthetic val$gravity:I

.field final synthetic val$message:Ljava/lang/String;


# direct methods
.method constructor <init>(Lcom/facebook/react/modules/toast/ToastModule;Ljava/lang/String;II)V
    .locals 0
    .param p1, "this$0"    # Lcom/facebook/react/modules/toast/ToastModule;

    .prologue
    .line 68
    iput-object p1, p0, Lcom/facebook/react/modules/toast/ToastModule$2;->this$0:Lcom/facebook/react/modules/toast/ToastModule;

    iput-object p2, p0, Lcom/facebook/react/modules/toast/ToastModule$2;->val$message:Ljava/lang/String;

    iput p3, p0, Lcom/facebook/react/modules/toast/ToastModule$2;->val$duration:I

    iput p4, p0, Lcom/facebook/react/modules/toast/ToastModule$2;->val$gravity:I

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public run()V
    .locals 5

    .prologue
    const/4 v4, 0x0

    .line 71
    iget-object v1, p0, Lcom/facebook/react/modules/toast/ToastModule$2;->this$0:Lcom/facebook/react/modules/toast/ToastModule;

    invoke-static {v1}, Lcom/facebook/react/modules/toast/ToastModule;->access$100(Lcom/facebook/react/modules/toast/ToastModule;)Lcom/facebook/react/bridge/ReactApplicationContext;

    move-result-object v1

    iget-object v2, p0, Lcom/facebook/react/modules/toast/ToastModule$2;->val$message:Ljava/lang/String;

    iget v3, p0, Lcom/facebook/react/modules/toast/ToastModule$2;->val$duration:I

    invoke-static {v1, v2, v3}, Landroid/widget/Toast;->makeText(Landroid/content/Context;Ljava/lang/CharSequence;I)Landroid/widget/Toast;

    move-result-object v0

    .line 72
    .local v0, "toast":Landroid/widget/Toast;
    iget v1, p0, Lcom/facebook/react/modules/toast/ToastModule$2;->val$gravity:I

    invoke-virtual {v0, v1, v4, v4}, Landroid/widget/Toast;->setGravity(III)V

    .line 73
    invoke-virtual {v0}, Landroid/widget/Toast;->show()V

    .line 74
    return-void
.end method

.class Lcom/brynk/fathom/controllers/ReactActivity$DebugExampleTwoFragment$20;
.super Ljava/lang/Object;
.source "ReactActivity.java"

# interfaces
.implements Ljava/lang/Runnable;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/brynk/fathom/controllers/ReactActivity$DebugExampleTwoFragment;->setupTelemtry()V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$0:Lcom/brynk/fathom/controllers/ReactActivity$DebugExampleTwoFragment;

.field final synthetic val$rootView:Landroid/view/View;


# direct methods
.method constructor <init>(Lcom/brynk/fathom/controllers/ReactActivity$DebugExampleTwoFragment;Landroid/view/View;)V
    .locals 0
    .param p1, "this$0"    # Lcom/brynk/fathom/controllers/ReactActivity$DebugExampleTwoFragment;

    .prologue
    .line 774
    iput-object p1, p0, Lcom/brynk/fathom/controllers/ReactActivity$DebugExampleTwoFragment$20;->this$0:Lcom/brynk/fathom/controllers/ReactActivity$DebugExampleTwoFragment;

    iput-object p2, p0, Lcom/brynk/fathom/controllers/ReactActivity$DebugExampleTwoFragment$20;->val$rootView:Landroid/view/View;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public run()V
    .locals 4

    .prologue
    .line 777
    new-instance v0, Lcom/brynk/fathom/api/TemperatureTask;

    iget-object v1, p0, Lcom/brynk/fathom/controllers/ReactActivity$DebugExampleTwoFragment$20;->val$rootView:Landroid/view/View;

    invoke-virtual {v1}, Landroid/view/View;->getContext()Landroid/content/Context;

    move-result-object v1

    iget-object v2, p0, Lcom/brynk/fathom/controllers/ReactActivity$DebugExampleTwoFragment$20;->val$rootView:Landroid/view/View;

    iget-object v3, p0, Lcom/brynk/fathom/controllers/ReactActivity$DebugExampleTwoFragment$20;->this$0:Lcom/brynk/fathom/controllers/ReactActivity$DebugExampleTwoFragment;

    invoke-static {v3}, Lcom/brynk/fathom/controllers/ReactActivity$DebugExampleTwoFragment;->access$1100(Lcom/brynk/fathom/controllers/ReactActivity$DebugExampleTwoFragment;)Ljava/lang/String;

    move-result-object v3

    invoke-direct {v0, v1, v2, v3}, Lcom/brynk/fathom/api/TemperatureTask;-><init>(Landroid/content/Context;Landroid/view/View;Ljava/lang/String;)V

    const/4 v1, 0x1

    new-array v1, v1, [Ljava/lang/String;

    const/4 v2, 0x0

    const-string v3, ""

    aput-object v3, v1, v2

    invoke-virtual {v0, v1}, Lcom/brynk/fathom/api/TemperatureTask;->execute([Ljava/lang/Object;)Landroid/os/AsyncTask;

    .line 778
    return-void
.end method

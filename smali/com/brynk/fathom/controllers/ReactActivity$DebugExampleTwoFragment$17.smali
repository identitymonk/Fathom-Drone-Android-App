.class Lcom/brynk/fathom/controllers/ReactActivity$DebugExampleTwoFragment$17;
.super Ljava/lang/Object;
.source "ReactActivity.java"

# interfaces
.implements Landroid/view/View$OnClickListener;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/brynk/fathom/controllers/ReactActivity$DebugExampleTwoFragment;->onCreateView(Landroid/view/LayoutInflater;Landroid/view/ViewGroup;Landroid/os/Bundle;)Landroid/view/View;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$0:Lcom/brynk/fathom/controllers/ReactActivity$DebugExampleTwoFragment;


# direct methods
.method constructor <init>(Lcom/brynk/fathom/controllers/ReactActivity$DebugExampleTwoFragment;)V
    .locals 0
    .param p1, "this$0"    # Lcom/brynk/fathom/controllers/ReactActivity$DebugExampleTwoFragment;

    .prologue
    .line 480
    iput-object p1, p0, Lcom/brynk/fathom/controllers/ReactActivity$DebugExampleTwoFragment$17;->this$0:Lcom/brynk/fathom/controllers/ReactActivity$DebugExampleTwoFragment;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public onClick(Landroid/view/View;)V
    .locals 3
    .param p1, "view"    # Landroid/view/View;

    .prologue
    .line 483
    iget-object v1, p0, Lcom/brynk/fathom/controllers/ReactActivity$DebugExampleTwoFragment$17;->this$0:Lcom/brynk/fathom/controllers/ReactActivity$DebugExampleTwoFragment;

    invoke-virtual {v1}, Lcom/brynk/fathom/controllers/ReactActivity$DebugExampleTwoFragment;->getView()Landroid/view/View;

    move-result-object v1

    const v2, 0x7f0f00c7

    invoke-virtual {v1, v2}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/RelativeLayout;

    .line 484
    .local v0, "rl":Landroid/widget/RelativeLayout;
    const/4 v1, 0x4

    invoke-virtual {v0, v1}, Landroid/widget/RelativeLayout;->setVisibility(I)V

    .line 485
    return-void
.end method

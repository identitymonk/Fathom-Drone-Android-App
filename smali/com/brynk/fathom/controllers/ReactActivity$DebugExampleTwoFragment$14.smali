.class Lcom/brynk/fathom/controllers/ReactActivity$DebugExampleTwoFragment$14;
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
    .line 456
    iput-object p1, p0, Lcom/brynk/fathom/controllers/ReactActivity$DebugExampleTwoFragment$14;->this$0:Lcom/brynk/fathom/controllers/ReactActivity$DebugExampleTwoFragment;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public onClick(Landroid/view/View;)V
    .locals 2
    .param p1, "view"    # Landroid/view/View;

    .prologue
    .line 459
    iget-object v0, p0, Lcom/brynk/fathom/controllers/ReactActivity$DebugExampleTwoFragment$14;->this$0:Lcom/brynk/fathom/controllers/ReactActivity$DebugExampleTwoFragment;

    iget-object v1, p0, Lcom/brynk/fathom/controllers/ReactActivity$DebugExampleTwoFragment$14;->this$0:Lcom/brynk/fathom/controllers/ReactActivity$DebugExampleTwoFragment;

    invoke-virtual {v1}, Lcom/brynk/fathom/controllers/ReactActivity$DebugExampleTwoFragment;->getView()Landroid/view/View;

    move-result-object v1

    invoke-virtual {v0, v1}, Lcom/brynk/fathom/controllers/ReactActivity$DebugExampleTwoFragment;->toggleLights(Landroid/view/View;)V

    .line 460
    return-void
.end method

.class Lcom/brynk/fathom/controllers/ReactActivity$DebugExampleTwoFragment$1;
.super Ljava/lang/Object;
.source "ReactActivity.java"

# interfaces
.implements Landroid/view/View$OnGenericMotionListener;


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
    .line 312
    iput-object p1, p0, Lcom/brynk/fathom/controllers/ReactActivity$DebugExampleTwoFragment$1;->this$0:Lcom/brynk/fathom/controllers/ReactActivity$DebugExampleTwoFragment;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public onGenericMotion(Landroid/view/View;Landroid/view/MotionEvent;)Z
    .locals 3
    .param p1, "v"    # Landroid/view/View;
    .param p2, "event"    # Landroid/view/MotionEvent;

    .prologue
    const v2, 0x1000010

    .line 320
    invoke-virtual {p2}, Landroid/view/MotionEvent;->getAction()I

    move-result v0

    const/16 v1, 0x13

    if-ne v0, v1, :cond_0

    .line 321
    const-string v0, "FATHOM1"

    const-string v1, "UPPER"

    invoke-static {v0, v1}, Landroid/util/Log;->d(Ljava/lang/String;Ljava/lang/String;)I

    .line 323
    :cond_0
    invoke-virtual {p2}, Landroid/view/MotionEvent;->getSource()I

    move-result v0

    and-int/2addr v0, v2

    if-ne v0, v2, :cond_1

    .line 325
    invoke-virtual {p2}, Landroid/view/MotionEvent;->getAction()I

    move-result v0

    const/4 v1, 0x2

    if-ne v0, v1, :cond_1

    .line 327
    iget-object v0, p0, Lcom/brynk/fathom/controllers/ReactActivity$DebugExampleTwoFragment$1;->this$0:Lcom/brynk/fathom/controllers/ReactActivity$DebugExampleTwoFragment;

    invoke-static {v0}, Lcom/brynk/fathom/controllers/ReactActivity$DebugExampleTwoFragment;->access$000(Lcom/brynk/fathom/controllers/ReactActivity$DebugExampleTwoFragment;)Lcom/brynk/fathom/helpers/ExternalDevice;

    move-result-object v0

    iget-object v1, p0, Lcom/brynk/fathom/controllers/ReactActivity$DebugExampleTwoFragment$1;->this$0:Lcom/brynk/fathom/controllers/ReactActivity$DebugExampleTwoFragment;

    iget-object v1, v1, Lcom/brynk/fathom/controllers/ReactActivity$DebugExampleTwoFragment;->thruster_socket:Ljava/net/DatagramSocket;

    invoke-virtual {v0, p2, v1}, Lcom/brynk/fathom/helpers/ExternalDevice;->processHistoricalEvents(Landroid/view/MotionEvent;Ljava/net/DatagramSocket;)V

    .line 328
    iget-object v0, p0, Lcom/brynk/fathom/controllers/ReactActivity$DebugExampleTwoFragment$1;->this$0:Lcom/brynk/fathom/controllers/ReactActivity$DebugExampleTwoFragment;

    invoke-static {v0}, Lcom/brynk/fathom/controllers/ReactActivity$DebugExampleTwoFragment;->access$000(Lcom/brynk/fathom/controllers/ReactActivity$DebugExampleTwoFragment;)Lcom/brynk/fathom/helpers/ExternalDevice;

    move-result-object v0

    iget-object v1, p0, Lcom/brynk/fathom/controllers/ReactActivity$DebugExampleTwoFragment$1;->this$0:Lcom/brynk/fathom/controllers/ReactActivity$DebugExampleTwoFragment;

    iget-object v1, v1, Lcom/brynk/fathom/controllers/ReactActivity$DebugExampleTwoFragment;->thruster_socket:Ljava/net/DatagramSocket;

    invoke-virtual {v0, p2, v1}, Lcom/brynk/fathom/helpers/ExternalDevice;->processCurrentEvent(Landroid/view/MotionEvent;Ljava/net/DatagramSocket;)V

    .line 330
    const/4 v0, 0x1

    .line 332
    :goto_0
    return v0

    :cond_1
    const/4 v0, 0x0

    goto :goto_0
.end method

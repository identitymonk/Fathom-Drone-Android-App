.class Lcom/brynk/fathom/controllers/ReactActivity$DebugExampleTwoFragment$2;
.super Ljava/lang/Object;
.source "ReactActivity.java"

# interfaces
.implements Landroid/view/View$OnTouchListener;


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
    .line 336
    iput-object p1, p0, Lcom/brynk/fathom/controllers/ReactActivity$DebugExampleTwoFragment$2;->this$0:Lcom/brynk/fathom/controllers/ReactActivity$DebugExampleTwoFragment;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public onTouch(Landroid/view/View;Landroid/view/MotionEvent;)Z
    .locals 6
    .param p1, "v"    # Landroid/view/View;
    .param p2, "event"    # Landroid/view/MotionEvent;

    .prologue
    const/4 v5, 0x1

    .line 339
    invoke-static {p2}, Landroid/support/v4/view/MotionEventCompat;->getActionMasked(Landroid/view/MotionEvent;)I

    move-result v0

    .line 340
    .local v0, "action":I
    const v3, 0x7f0f00a9

    invoke-virtual {p1, v3}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v2

    check-cast v2, Landroid/widget/TextView;

    .line 341
    .local v2, "pilotView":Landroid/widget/TextView;
    iget-object v3, p0, Lcom/brynk/fathom/controllers/ReactActivity$DebugExampleTwoFragment$2;->this$0:Lcom/brynk/fathom/controllers/ReactActivity$DebugExampleTwoFragment;

    invoke-static {v3}, Lcom/brynk/fathom/controllers/ReactActivity$DebugExampleTwoFragment;->access$100(Lcom/brynk/fathom/controllers/ReactActivity$DebugExampleTwoFragment;)Lcom/brynk/fathom/helpers/CoordinateHelper;

    move-result-object v3

    invoke-virtual {v3, p2, v2}, Lcom/brynk/fathom/helpers/CoordinateHelper;->boundCoordInTextView(Landroid/view/MotionEvent;Landroid/widget/TextView;)Ljava/util/ArrayList;

    move-result-object v1

    .line 343
    .local v1, "boundedCoords":Ljava/util/ArrayList;
    packed-switch v0, :pswitch_data_0

    .line 361
    :goto_0
    return v5

    .line 346
    :pswitch_0
    iget-object v3, p0, Lcom/brynk/fathom/controllers/ReactActivity$DebugExampleTwoFragment$2;->this$0:Lcom/brynk/fathom/controllers/ReactActivity$DebugExampleTwoFragment;

    invoke-static {v5}, Ljava/lang/Boolean;->valueOf(Z)Ljava/lang/Boolean;

    move-result-object v4

    invoke-static {v3, v4}, Lcom/brynk/fathom/controllers/ReactActivity$DebugExampleTwoFragment;->access$202(Lcom/brynk/fathom/controllers/ReactActivity$DebugExampleTwoFragment;Ljava/lang/Boolean;)Ljava/lang/Boolean;

    .line 347
    iget-object v3, p0, Lcom/brynk/fathom/controllers/ReactActivity$DebugExampleTwoFragment$2;->this$0:Lcom/brynk/fathom/controllers/ReactActivity$DebugExampleTwoFragment;

    invoke-static {v3, v1}, Lcom/brynk/fathom/controllers/ReactActivity$DebugExampleTwoFragment;->access$300(Lcom/brynk/fathom/controllers/ReactActivity$DebugExampleTwoFragment;Ljava/util/ArrayList;)V

    .line 348
    iget-object v3, p0, Lcom/brynk/fathom/controllers/ReactActivity$DebugExampleTwoFragment$2;->this$0:Lcom/brynk/fathom/controllers/ReactActivity$DebugExampleTwoFragment;

    invoke-virtual {v3, p1}, Lcom/brynk/fathom/controllers/ReactActivity$DebugExampleTwoFragment;->resetVerticalMovement(Landroid/view/View;)V

    goto :goto_0

    .line 351
    :pswitch_1
    iget-object v3, p0, Lcom/brynk/fathom/controllers/ReactActivity$DebugExampleTwoFragment$2;->this$0:Lcom/brynk/fathom/controllers/ReactActivity$DebugExampleTwoFragment;

    const/4 v4, 0x0

    invoke-static {v4}, Ljava/lang/Boolean;->valueOf(Z)Ljava/lang/Boolean;

    move-result-object v4

    invoke-static {v3, v4}, Lcom/brynk/fathom/controllers/ReactActivity$DebugExampleTwoFragment;->access$202(Lcom/brynk/fathom/controllers/ReactActivity$DebugExampleTwoFragment;Ljava/lang/Boolean;)Ljava/lang/Boolean;

    .line 352
    iget-object v3, p0, Lcom/brynk/fathom/controllers/ReactActivity$DebugExampleTwoFragment$2;->this$0:Lcom/brynk/fathom/controllers/ReactActivity$DebugExampleTwoFragment;

    invoke-static {v3}, Lcom/brynk/fathom/controllers/ReactActivity$DebugExampleTwoFragment;->access$400(Lcom/brynk/fathom/controllers/ReactActivity$DebugExampleTwoFragment;)V

    goto :goto_0

    .line 355
    :pswitch_2
    iget-object v3, p0, Lcom/brynk/fathom/controllers/ReactActivity$DebugExampleTwoFragment$2;->this$0:Lcom/brynk/fathom/controllers/ReactActivity$DebugExampleTwoFragment;

    invoke-static {v5}, Ljava/lang/Boolean;->valueOf(Z)Ljava/lang/Boolean;

    move-result-object v4

    invoke-static {v3, v4}, Lcom/brynk/fathom/controllers/ReactActivity$DebugExampleTwoFragment;->access$202(Lcom/brynk/fathom/controllers/ReactActivity$DebugExampleTwoFragment;Ljava/lang/Boolean;)Ljava/lang/Boolean;

    .line 356
    iget-object v3, p0, Lcom/brynk/fathom/controllers/ReactActivity$DebugExampleTwoFragment$2;->this$0:Lcom/brynk/fathom/controllers/ReactActivity$DebugExampleTwoFragment;

    invoke-static {v3, v1, p2}, Lcom/brynk/fathom/controllers/ReactActivity$DebugExampleTwoFragment;->access$500(Lcom/brynk/fathom/controllers/ReactActivity$DebugExampleTwoFragment;Ljava/util/ArrayList;Landroid/view/MotionEvent;)V

    goto :goto_0

    .line 343
    nop

    :pswitch_data_0
    .packed-switch 0x0
        :pswitch_0
        :pswitch_1
        :pswitch_2
    .end packed-switch
.end method

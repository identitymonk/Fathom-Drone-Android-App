.class Lcom/brynk/fathom/controllers/MainActivity$4;
.super Ljava/lang/Object;
.source "MainActivity.java"

# interfaces
.implements Landroid/view/View$OnTouchListener;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/brynk/fathom/controllers/MainActivity;->onCreate(Landroid/os/Bundle;)V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$0:Lcom/brynk/fathom/controllers/MainActivity;


# direct methods
.method constructor <init>(Lcom/brynk/fathom/controllers/MainActivity;)V
    .locals 0
    .param p1, "this$0"    # Lcom/brynk/fathom/controllers/MainActivity;

    .prologue
    .line 235
    iput-object p1, p0, Lcom/brynk/fathom/controllers/MainActivity$4;->this$0:Lcom/brynk/fathom/controllers/MainActivity;

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

    .line 238
    invoke-static {p2}, Landroid/support/v4/view/MotionEventCompat;->getActionMasked(Landroid/view/MotionEvent;)I

    move-result v0

    .line 239
    .local v0, "action":I
    iget-object v3, p0, Lcom/brynk/fathom/controllers/MainActivity$4;->this$0:Lcom/brynk/fathom/controllers/MainActivity;

    const v4, 0x7f0f00aa

    invoke-virtual {v3, v4}, Lcom/brynk/fathom/controllers/MainActivity;->findViewById(I)Landroid/view/View;

    move-result-object v2

    check-cast v2, Landroid/widget/TextView;

    .line 240
    .local v2, "pilotView":Landroid/widget/TextView;
    iget-object v3, p0, Lcom/brynk/fathom/controllers/MainActivity$4;->this$0:Lcom/brynk/fathom/controllers/MainActivity;

    invoke-static {v3}, Lcom/brynk/fathom/controllers/MainActivity;->access$100(Lcom/brynk/fathom/controllers/MainActivity;)Lcom/brynk/fathom/helpers/CoordinateHelper;

    move-result-object v3

    invoke-virtual {v3, p2, v2}, Lcom/brynk/fathom/helpers/CoordinateHelper;->boundCoordInTextView(Landroid/view/MotionEvent;Landroid/widget/TextView;)Ljava/util/ArrayList;

    move-result-object v1

    .line 242
    .local v1, "boundedCoords":Ljava/util/ArrayList;
    packed-switch v0, :pswitch_data_0

    .line 255
    :goto_0
    return v5

    .line 245
    :pswitch_0
    iget-object v3, p0, Lcom/brynk/fathom/controllers/MainActivity$4;->this$0:Lcom/brynk/fathom/controllers/MainActivity;

    invoke-static {v3, v1}, Lcom/brynk/fathom/controllers/MainActivity;->access$500(Lcom/brynk/fathom/controllers/MainActivity;Ljava/util/ArrayList;)V

    goto :goto_0

    .line 248
    :pswitch_1
    iget-object v3, p0, Lcom/brynk/fathom/controllers/MainActivity$4;->this$0:Lcom/brynk/fathom/controllers/MainActivity;

    invoke-static {v3}, Lcom/brynk/fathom/controllers/MainActivity;->access$600(Lcom/brynk/fathom/controllers/MainActivity;)V

    goto :goto_0

    .line 252
    :pswitch_2
    iget-object v3, p0, Lcom/brynk/fathom/controllers/MainActivity$4;->this$0:Lcom/brynk/fathom/controllers/MainActivity;

    invoke-static {v3, v1, p2}, Lcom/brynk/fathom/controllers/MainActivity;->access$700(Lcom/brynk/fathom/controllers/MainActivity;Ljava/util/ArrayList;Landroid/view/MotionEvent;)V

    goto :goto_0

    .line 242
    :pswitch_data_0
    .packed-switch 0x0
        :pswitch_0
        :pswitch_1
        :pswitch_2
    .end packed-switch
.end method

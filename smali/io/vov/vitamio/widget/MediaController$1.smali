.class Lio/vov/vitamio/widget/MediaController$1;
.super Landroid/os/Handler;
.source "MediaController.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lio/vov/vitamio/widget/MediaController;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$0:Lio/vov/vitamio/widget/MediaController;


# direct methods
.method constructor <init>(Lio/vov/vitamio/widget/MediaController;)V
    .locals 0
    .param p1, "this$0"    # Lio/vov/vitamio/widget/MediaController;

    .prologue
    .line 101
    iput-object p1, p0, Lio/vov/vitamio/widget/MediaController$1;->this$0:Lio/vov/vitamio/widget/MediaController;

    invoke-direct {p0}, Landroid/os/Handler;-><init>()V

    return-void
.end method


# virtual methods
.method public handleMessage(Landroid/os/Message;)V
    .locals 6
    .param p1, "msg"    # Landroid/os/Message;

    .prologue
    const-wide/16 v4, 0x3e8

    .line 105
    iget v2, p1, Landroid/os/Message;->what:I

    packed-switch v2, :pswitch_data_0

    .line 118
    :cond_0
    :goto_0
    return-void

    .line 107
    :pswitch_0
    iget-object v2, p0, Lio/vov/vitamio/widget/MediaController$1;->this$0:Lio/vov/vitamio/widget/MediaController;

    invoke-virtual {v2}, Lio/vov/vitamio/widget/MediaController;->hide()V

    goto :goto_0

    .line 110
    :pswitch_1
    iget-object v2, p0, Lio/vov/vitamio/widget/MediaController$1;->this$0:Lio/vov/vitamio/widget/MediaController;

    invoke-static {v2}, Lio/vov/vitamio/widget/MediaController;->access$000(Lio/vov/vitamio/widget/MediaController;)J

    move-result-wide v0

    .line 111
    .local v0, "pos":J
    iget-object v2, p0, Lio/vov/vitamio/widget/MediaController$1;->this$0:Lio/vov/vitamio/widget/MediaController;

    invoke-static {v2}, Lio/vov/vitamio/widget/MediaController;->access$100(Lio/vov/vitamio/widget/MediaController;)Z

    move-result v2

    if-nez v2, :cond_0

    iget-object v2, p0, Lio/vov/vitamio/widget/MediaController$1;->this$0:Lio/vov/vitamio/widget/MediaController;

    invoke-static {v2}, Lio/vov/vitamio/widget/MediaController;->access$200(Lio/vov/vitamio/widget/MediaController;)Z

    move-result v2

    if-eqz v2, :cond_0

    .line 112
    const/4 v2, 0x2

    invoke-virtual {p0, v2}, Lio/vov/vitamio/widget/MediaController$1;->obtainMessage(I)Landroid/os/Message;

    move-result-object p1

    .line 113
    rem-long v2, v0, v4

    sub-long v2, v4, v2

    invoke-virtual {p0, p1, v2, v3}, Lio/vov/vitamio/widget/MediaController$1;->sendMessageDelayed(Landroid/os/Message;J)Z

    .line 114
    iget-object v2, p0, Lio/vov/vitamio/widget/MediaController$1;->this$0:Lio/vov/vitamio/widget/MediaController;

    invoke-static {v2}, Lio/vov/vitamio/widget/MediaController;->access$300(Lio/vov/vitamio/widget/MediaController;)V

    goto :goto_0

    .line 105
    :pswitch_data_0
    .packed-switch 0x1
        :pswitch_0
        :pswitch_1
    .end packed-switch
.end method

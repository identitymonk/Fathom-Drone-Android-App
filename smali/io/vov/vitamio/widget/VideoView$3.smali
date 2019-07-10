.class Lio/vov/vitamio/widget/VideoView$3;
.super Ljava/lang/Object;
.source "VideoView.java"

# interfaces
.implements Landroid/view/SurfaceHolder$Callback;


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lio/vov/vitamio/widget/VideoView;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$0:Lio/vov/vitamio/widget/VideoView;


# direct methods
.method constructor <init>(Lio/vov/vitamio/widget/VideoView;)V
    .locals 0
    .param p1, "this$0"    # Lio/vov/vitamio/widget/VideoView;

    .prologue
    .line 134
    iput-object p1, p0, Lio/vov/vitamio/widget/VideoView$3;->this$0:Lio/vov/vitamio/widget/VideoView;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public surfaceChanged(Landroid/view/SurfaceHolder;III)V
    .locals 6
    .param p1, "holder"    # Landroid/view/SurfaceHolder;
    .param p2, "format"    # I
    .param p3, "w"    # I
    .param p4, "h"    # I

    .prologue
    const/4 v2, 0x1

    const/4 v3, 0x0

    .line 136
    iget-object v4, p0, Lio/vov/vitamio/widget/VideoView$3;->this$0:Lio/vov/vitamio/widget/VideoView;

    invoke-static {v4, p3}, Lio/vov/vitamio/widget/VideoView;->access$1002(Lio/vov/vitamio/widget/VideoView;I)I

    .line 137
    iget-object v4, p0, Lio/vov/vitamio/widget/VideoView$3;->this$0:Lio/vov/vitamio/widget/VideoView;

    invoke-static {v4, p4}, Lio/vov/vitamio/widget/VideoView;->access$1102(Lio/vov/vitamio/widget/VideoView;I)I

    .line 138
    iget-object v4, p0, Lio/vov/vitamio/widget/VideoView$3;->this$0:Lio/vov/vitamio/widget/VideoView;

    invoke-static {v4}, Lio/vov/vitamio/widget/VideoView;->access$1200(Lio/vov/vitamio/widget/VideoView;)I

    move-result v4

    const/4 v5, 0x3

    if-ne v4, v5, :cond_3

    move v1, v2

    .line 139
    .local v1, "isValidState":Z
    :goto_0
    iget-object v4, p0, Lio/vov/vitamio/widget/VideoView$3;->this$0:Lio/vov/vitamio/widget/VideoView;

    invoke-static {v4}, Lio/vov/vitamio/widget/VideoView;->access$000(Lio/vov/vitamio/widget/VideoView;)I

    move-result v4

    if-ne v4, p3, :cond_4

    iget-object v4, p0, Lio/vov/vitamio/widget/VideoView$3;->this$0:Lio/vov/vitamio/widget/VideoView;

    invoke-static {v4}, Lio/vov/vitamio/widget/VideoView;->access$100(Lio/vov/vitamio/widget/VideoView;)I

    move-result v4

    if-ne v4, p4, :cond_4

    move v0, v2

    .line 140
    .local v0, "hasValidSize":Z
    :goto_1
    iget-object v2, p0, Lio/vov/vitamio/widget/VideoView$3;->this$0:Lio/vov/vitamio/widget/VideoView;

    invoke-static {v2}, Lio/vov/vitamio/widget/VideoView;->access$700(Lio/vov/vitamio/widget/VideoView;)Lio/vov/vitamio/MediaPlayer;

    move-result-object v2

    if-eqz v2, :cond_2

    if-eqz v1, :cond_2

    if-eqz v0, :cond_2

    .line 141
    iget-object v2, p0, Lio/vov/vitamio/widget/VideoView$3;->this$0:Lio/vov/vitamio/widget/VideoView;

    invoke-static {v2}, Lio/vov/vitamio/widget/VideoView;->access$900(Lio/vov/vitamio/widget/VideoView;)J

    move-result-wide v2

    const-wide/16 v4, 0x0

    cmp-long v2, v2, v4

    if-eqz v2, :cond_0

    .line 142
    iget-object v2, p0, Lio/vov/vitamio/widget/VideoView$3;->this$0:Lio/vov/vitamio/widget/VideoView;

    iget-object v3, p0, Lio/vov/vitamio/widget/VideoView$3;->this$0:Lio/vov/vitamio/widget/VideoView;

    invoke-static {v3}, Lio/vov/vitamio/widget/VideoView;->access$900(Lio/vov/vitamio/widget/VideoView;)J

    move-result-wide v4

    invoke-virtual {v2, v4, v5}, Lio/vov/vitamio/widget/VideoView;->seekTo(J)V

    .line 143
    :cond_0
    iget-object v2, p0, Lio/vov/vitamio/widget/VideoView$3;->this$0:Lio/vov/vitamio/widget/VideoView;

    invoke-virtual {v2}, Lio/vov/vitamio/widget/VideoView;->start()V

    .line 144
    iget-object v2, p0, Lio/vov/vitamio/widget/VideoView$3;->this$0:Lio/vov/vitamio/widget/VideoView;

    invoke-static {v2}, Lio/vov/vitamio/widget/VideoView;->access$800(Lio/vov/vitamio/widget/VideoView;)Lio/vov/vitamio/widget/MediaController;

    move-result-object v2

    if-eqz v2, :cond_2

    .line 145
    iget-object v2, p0, Lio/vov/vitamio/widget/VideoView$3;->this$0:Lio/vov/vitamio/widget/VideoView;

    invoke-static {v2}, Lio/vov/vitamio/widget/VideoView;->access$800(Lio/vov/vitamio/widget/VideoView;)Lio/vov/vitamio/widget/MediaController;

    move-result-object v2

    invoke-virtual {v2}, Lio/vov/vitamio/widget/MediaController;->isShowing()Z

    move-result v2

    if-eqz v2, :cond_1

    .line 146
    iget-object v2, p0, Lio/vov/vitamio/widget/VideoView$3;->this$0:Lio/vov/vitamio/widget/VideoView;

    invoke-static {v2}, Lio/vov/vitamio/widget/VideoView;->access$800(Lio/vov/vitamio/widget/VideoView;)Lio/vov/vitamio/widget/MediaController;

    move-result-object v2

    invoke-virtual {v2}, Lio/vov/vitamio/widget/MediaController;->hide()V

    .line 147
    :cond_1
    iget-object v2, p0, Lio/vov/vitamio/widget/VideoView$3;->this$0:Lio/vov/vitamio/widget/VideoView;

    invoke-static {v2}, Lio/vov/vitamio/widget/VideoView;->access$800(Lio/vov/vitamio/widget/VideoView;)Lio/vov/vitamio/widget/MediaController;

    move-result-object v2

    invoke-virtual {v2}, Lio/vov/vitamio/widget/MediaController;->show()V

    .line 150
    :cond_2
    return-void

    .end local v0    # "hasValidSize":Z
    .end local v1    # "isValidState":Z
    :cond_3
    move v1, v3

    .line 138
    goto :goto_0

    .restart local v1    # "isValidState":Z
    :cond_4
    move v0, v3

    .line 139
    goto :goto_1
.end method

.method public surfaceCreated(Landroid/view/SurfaceHolder;)V
    .locals 2
    .param p1, "holder"    # Landroid/view/SurfaceHolder;

    .prologue
    .line 153
    iget-object v0, p0, Lio/vov/vitamio/widget/VideoView$3;->this$0:Lio/vov/vitamio/widget/VideoView;

    invoke-static {v0, p1}, Lio/vov/vitamio/widget/VideoView;->access$1302(Lio/vov/vitamio/widget/VideoView;Landroid/view/SurfaceHolder;)Landroid/view/SurfaceHolder;

    .line 154
    iget-object v0, p0, Lio/vov/vitamio/widget/VideoView$3;->this$0:Lio/vov/vitamio/widget/VideoView;

    invoke-static {v0}, Lio/vov/vitamio/widget/VideoView;->access$700(Lio/vov/vitamio/widget/VideoView;)Lio/vov/vitamio/MediaPlayer;

    move-result-object v0

    if-eqz v0, :cond_0

    iget-object v0, p0, Lio/vov/vitamio/widget/VideoView$3;->this$0:Lio/vov/vitamio/widget/VideoView;

    invoke-static {v0}, Lio/vov/vitamio/widget/VideoView;->access$500(Lio/vov/vitamio/widget/VideoView;)I

    move-result v0

    const/4 v1, 0x6

    if-ne v0, v1, :cond_0

    iget-object v0, p0, Lio/vov/vitamio/widget/VideoView$3;->this$0:Lio/vov/vitamio/widget/VideoView;

    invoke-static {v0}, Lio/vov/vitamio/widget/VideoView;->access$1200(Lio/vov/vitamio/widget/VideoView;)I

    move-result v0

    const/4 v1, 0x7

    if-ne v0, v1, :cond_0

    .line 155
    iget-object v0, p0, Lio/vov/vitamio/widget/VideoView$3;->this$0:Lio/vov/vitamio/widget/VideoView;

    invoke-static {v0}, Lio/vov/vitamio/widget/VideoView;->access$700(Lio/vov/vitamio/widget/VideoView;)Lio/vov/vitamio/MediaPlayer;

    move-result-object v0

    iget-object v1, p0, Lio/vov/vitamio/widget/VideoView$3;->this$0:Lio/vov/vitamio/widget/VideoView;

    invoke-static {v1}, Lio/vov/vitamio/widget/VideoView;->access$1300(Lio/vov/vitamio/widget/VideoView;)Landroid/view/SurfaceHolder;

    move-result-object v1

    invoke-virtual {v0, v1}, Lio/vov/vitamio/MediaPlayer;->setDisplay(Landroid/view/SurfaceHolder;)V

    .line 156
    iget-object v0, p0, Lio/vov/vitamio/widget/VideoView$3;->this$0:Lio/vov/vitamio/widget/VideoView;

    invoke-virtual {v0}, Lio/vov/vitamio/widget/VideoView;->resume()V

    .line 160
    :goto_0
    return-void

    .line 158
    :cond_0
    iget-object v0, p0, Lio/vov/vitamio/widget/VideoView$3;->this$0:Lio/vov/vitamio/widget/VideoView;

    invoke-static {v0}, Lio/vov/vitamio/widget/VideoView;->access$1400(Lio/vov/vitamio/widget/VideoView;)V

    goto :goto_0
.end method

.method public surfaceDestroyed(Landroid/view/SurfaceHolder;)V
    .locals 2
    .param p1, "holder"    # Landroid/view/SurfaceHolder;

    .prologue
    .line 163
    iget-object v0, p0, Lio/vov/vitamio/widget/VideoView$3;->this$0:Lio/vov/vitamio/widget/VideoView;

    const/4 v1, 0x0

    invoke-static {v0, v1}, Lio/vov/vitamio/widget/VideoView;->access$1302(Lio/vov/vitamio/widget/VideoView;Landroid/view/SurfaceHolder;)Landroid/view/SurfaceHolder;

    .line 164
    iget-object v0, p0, Lio/vov/vitamio/widget/VideoView$3;->this$0:Lio/vov/vitamio/widget/VideoView;

    invoke-static {v0}, Lio/vov/vitamio/widget/VideoView;->access$800(Lio/vov/vitamio/widget/VideoView;)Lio/vov/vitamio/widget/MediaController;

    move-result-object v0

    if-eqz v0, :cond_0

    .line 165
    iget-object v0, p0, Lio/vov/vitamio/widget/VideoView$3;->this$0:Lio/vov/vitamio/widget/VideoView;

    invoke-static {v0}, Lio/vov/vitamio/widget/VideoView;->access$800(Lio/vov/vitamio/widget/VideoView;)Lio/vov/vitamio/widget/MediaController;

    move-result-object v0

    invoke-virtual {v0}, Lio/vov/vitamio/widget/MediaController;->hide()V

    .line 166
    :cond_0
    iget-object v0, p0, Lio/vov/vitamio/widget/VideoView$3;->this$0:Lio/vov/vitamio/widget/VideoView;

    const/4 v1, 0x1

    invoke-static {v0, v1}, Lio/vov/vitamio/widget/VideoView;->access$1500(Lio/vov/vitamio/widget/VideoView;Z)V

    .line 167
    return-void
.end method

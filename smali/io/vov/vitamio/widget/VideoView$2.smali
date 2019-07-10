.class Lio/vov/vitamio/widget/VideoView$2;
.super Ljava/lang/Object;
.source "VideoView.java"

# interfaces
.implements Lio/vov/vitamio/MediaPlayer$OnPreparedListener;


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
    .line 96
    iput-object p1, p0, Lio/vov/vitamio/widget/VideoView$2;->this$0:Lio/vov/vitamio/widget/VideoView;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public onPrepared(Lio/vov/vitamio/MediaPlayer;)V
    .locals 9
    .param p1, "mp"    # Lio/vov/vitamio/MediaPlayer;

    .prologue
    const/4 v8, 0x3

    const/4 v5, 0x0

    const-wide/16 v6, 0x0

    .line 98
    const-string v2, "onPrepared"

    new-array v3, v5, [Ljava/lang/Object;

    invoke-static {v2, v3}, Lio/vov/vitamio/utils/Log;->d(Ljava/lang/String;[Ljava/lang/Object;)V

    .line 99
    iget-object v2, p0, Lio/vov/vitamio/widget/VideoView$2;->this$0:Lio/vov/vitamio/widget/VideoView;

    const/4 v3, 0x2

    invoke-static {v2, v3}, Lio/vov/vitamio/widget/VideoView;->access$502(Lio/vov/vitamio/widget/VideoView;I)I

    .line 105
    iget-object v2, p0, Lio/vov/vitamio/widget/VideoView$2;->this$0:Lio/vov/vitamio/widget/VideoView;

    invoke-static {v2}, Lio/vov/vitamio/widget/VideoView;->access$600(Lio/vov/vitamio/widget/VideoView;)Lio/vov/vitamio/MediaPlayer$OnPreparedListener;

    move-result-object v2

    if-eqz v2, :cond_0

    .line 106
    iget-object v2, p0, Lio/vov/vitamio/widget/VideoView$2;->this$0:Lio/vov/vitamio/widget/VideoView;

    invoke-static {v2}, Lio/vov/vitamio/widget/VideoView;->access$600(Lio/vov/vitamio/widget/VideoView;)Lio/vov/vitamio/MediaPlayer$OnPreparedListener;

    move-result-object v2

    iget-object v3, p0, Lio/vov/vitamio/widget/VideoView$2;->this$0:Lio/vov/vitamio/widget/VideoView;

    invoke-static {v3}, Lio/vov/vitamio/widget/VideoView;->access$700(Lio/vov/vitamio/widget/VideoView;)Lio/vov/vitamio/MediaPlayer;

    move-result-object v3

    invoke-interface {v2, v3}, Lio/vov/vitamio/MediaPlayer$OnPreparedListener;->onPrepared(Lio/vov/vitamio/MediaPlayer;)V

    .line 107
    :cond_0
    iget-object v2, p0, Lio/vov/vitamio/widget/VideoView$2;->this$0:Lio/vov/vitamio/widget/VideoView;

    invoke-static {v2}, Lio/vov/vitamio/widget/VideoView;->access$800(Lio/vov/vitamio/widget/VideoView;)Lio/vov/vitamio/widget/MediaController;

    move-result-object v2

    if-eqz v2, :cond_1

    .line 108
    iget-object v2, p0, Lio/vov/vitamio/widget/VideoView$2;->this$0:Lio/vov/vitamio/widget/VideoView;

    invoke-static {v2}, Lio/vov/vitamio/widget/VideoView;->access$800(Lio/vov/vitamio/widget/VideoView;)Lio/vov/vitamio/widget/MediaController;

    move-result-object v2

    const/4 v3, 0x1

    invoke-virtual {v2, v3}, Lio/vov/vitamio/widget/MediaController;->setEnabled(Z)V

    .line 109
    :cond_1
    iget-object v2, p0, Lio/vov/vitamio/widget/VideoView$2;->this$0:Lio/vov/vitamio/widget/VideoView;

    invoke-virtual {p1}, Lio/vov/vitamio/MediaPlayer;->getVideoWidth()I

    move-result v3

    invoke-static {v2, v3}, Lio/vov/vitamio/widget/VideoView;->access$002(Lio/vov/vitamio/widget/VideoView;I)I

    .line 110
    iget-object v2, p0, Lio/vov/vitamio/widget/VideoView$2;->this$0:Lio/vov/vitamio/widget/VideoView;

    invoke-virtual {p1}, Lio/vov/vitamio/MediaPlayer;->getVideoHeight()I

    move-result v3

    invoke-static {v2, v3}, Lio/vov/vitamio/widget/VideoView;->access$102(Lio/vov/vitamio/widget/VideoView;I)I

    .line 111
    iget-object v2, p0, Lio/vov/vitamio/widget/VideoView$2;->this$0:Lio/vov/vitamio/widget/VideoView;

    invoke-virtual {p1}, Lio/vov/vitamio/MediaPlayer;->getVideoAspectRatio()F

    move-result v3

    invoke-static {v2, v3}, Lio/vov/vitamio/widget/VideoView;->access$202(Lio/vov/vitamio/widget/VideoView;F)F

    .line 113
    iget-object v2, p0, Lio/vov/vitamio/widget/VideoView$2;->this$0:Lio/vov/vitamio/widget/VideoView;

    invoke-static {v2}, Lio/vov/vitamio/widget/VideoView;->access$900(Lio/vov/vitamio/widget/VideoView;)J

    move-result-wide v0

    .line 114
    .local v0, "seekToPosition":J
    cmp-long v2, v0, v6

    if-eqz v2, :cond_2

    .line 115
    iget-object v2, p0, Lio/vov/vitamio/widget/VideoView$2;->this$0:Lio/vov/vitamio/widget/VideoView;

    invoke-virtual {v2, v0, v1}, Lio/vov/vitamio/widget/VideoView;->seekTo(J)V

    .line 117
    :cond_2
    iget-object v2, p0, Lio/vov/vitamio/widget/VideoView$2;->this$0:Lio/vov/vitamio/widget/VideoView;

    invoke-static {v2}, Lio/vov/vitamio/widget/VideoView;->access$000(Lio/vov/vitamio/widget/VideoView;)I

    move-result v2

    if-eqz v2, :cond_6

    iget-object v2, p0, Lio/vov/vitamio/widget/VideoView$2;->this$0:Lio/vov/vitamio/widget/VideoView;

    invoke-static {v2}, Lio/vov/vitamio/widget/VideoView;->access$100(Lio/vov/vitamio/widget/VideoView;)I

    move-result v2

    if-eqz v2, :cond_6

    .line 118
    iget-object v2, p0, Lio/vov/vitamio/widget/VideoView$2;->this$0:Lio/vov/vitamio/widget/VideoView;

    iget-object v3, p0, Lio/vov/vitamio/widget/VideoView$2;->this$0:Lio/vov/vitamio/widget/VideoView;

    invoke-static {v3}, Lio/vov/vitamio/widget/VideoView;->access$300(Lio/vov/vitamio/widget/VideoView;)I

    move-result v3

    iget-object v4, p0, Lio/vov/vitamio/widget/VideoView$2;->this$0:Lio/vov/vitamio/widget/VideoView;

    invoke-static {v4}, Lio/vov/vitamio/widget/VideoView;->access$400(Lio/vov/vitamio/widget/VideoView;)F

    move-result v4

    invoke-virtual {v2, v3, v4}, Lio/vov/vitamio/widget/VideoView;->setVideoLayout(IF)V

    .line 119
    iget-object v2, p0, Lio/vov/vitamio/widget/VideoView$2;->this$0:Lio/vov/vitamio/widget/VideoView;

    invoke-static {v2}, Lio/vov/vitamio/widget/VideoView;->access$1000(Lio/vov/vitamio/widget/VideoView;)I

    move-result v2

    iget-object v3, p0, Lio/vov/vitamio/widget/VideoView$2;->this$0:Lio/vov/vitamio/widget/VideoView;

    invoke-static {v3}, Lio/vov/vitamio/widget/VideoView;->access$000(Lio/vov/vitamio/widget/VideoView;)I

    move-result v3

    if-ne v2, v3, :cond_3

    iget-object v2, p0, Lio/vov/vitamio/widget/VideoView$2;->this$0:Lio/vov/vitamio/widget/VideoView;

    invoke-static {v2}, Lio/vov/vitamio/widget/VideoView;->access$1100(Lio/vov/vitamio/widget/VideoView;)I

    move-result v2

    iget-object v3, p0, Lio/vov/vitamio/widget/VideoView$2;->this$0:Lio/vov/vitamio/widget/VideoView;

    invoke-static {v3}, Lio/vov/vitamio/widget/VideoView;->access$100(Lio/vov/vitamio/widget/VideoView;)I

    move-result v3

    if-ne v2, v3, :cond_3

    .line 120
    iget-object v2, p0, Lio/vov/vitamio/widget/VideoView$2;->this$0:Lio/vov/vitamio/widget/VideoView;

    invoke-static {v2}, Lio/vov/vitamio/widget/VideoView;->access$1200(Lio/vov/vitamio/widget/VideoView;)I

    move-result v2

    if-ne v2, v8, :cond_4

    .line 121
    iget-object v2, p0, Lio/vov/vitamio/widget/VideoView$2;->this$0:Lio/vov/vitamio/widget/VideoView;

    invoke-virtual {v2}, Lio/vov/vitamio/widget/VideoView;->start()V

    .line 122
    iget-object v2, p0, Lio/vov/vitamio/widget/VideoView$2;->this$0:Lio/vov/vitamio/widget/VideoView;

    invoke-static {v2}, Lio/vov/vitamio/widget/VideoView;->access$800(Lio/vov/vitamio/widget/VideoView;)Lio/vov/vitamio/widget/MediaController;

    move-result-object v2

    if-eqz v2, :cond_3

    .line 123
    iget-object v2, p0, Lio/vov/vitamio/widget/VideoView$2;->this$0:Lio/vov/vitamio/widget/VideoView;

    invoke-static {v2}, Lio/vov/vitamio/widget/VideoView;->access$800(Lio/vov/vitamio/widget/VideoView;)Lio/vov/vitamio/widget/MediaController;

    move-result-object v2

    invoke-virtual {v2}, Lio/vov/vitamio/widget/MediaController;->show()V

    .line 132
    :cond_3
    :goto_0
    return-void

    .line 124
    :cond_4
    iget-object v2, p0, Lio/vov/vitamio/widget/VideoView$2;->this$0:Lio/vov/vitamio/widget/VideoView;

    invoke-virtual {v2}, Lio/vov/vitamio/widget/VideoView;->isPlaying()Z

    move-result v2

    if-nez v2, :cond_3

    cmp-long v2, v0, v6

    if-nez v2, :cond_5

    iget-object v2, p0, Lio/vov/vitamio/widget/VideoView$2;->this$0:Lio/vov/vitamio/widget/VideoView;

    invoke-virtual {v2}, Lio/vov/vitamio/widget/VideoView;->getCurrentPosition()J

    move-result-wide v2

    cmp-long v2, v2, v6

    if-lez v2, :cond_3

    .line 125
    :cond_5
    iget-object v2, p0, Lio/vov/vitamio/widget/VideoView$2;->this$0:Lio/vov/vitamio/widget/VideoView;

    invoke-static {v2}, Lio/vov/vitamio/widget/VideoView;->access$800(Lio/vov/vitamio/widget/VideoView;)Lio/vov/vitamio/widget/MediaController;

    move-result-object v2

    if-eqz v2, :cond_3

    .line 126
    iget-object v2, p0, Lio/vov/vitamio/widget/VideoView$2;->this$0:Lio/vov/vitamio/widget/VideoView;

    invoke-static {v2}, Lio/vov/vitamio/widget/VideoView;->access$800(Lio/vov/vitamio/widget/VideoView;)Lio/vov/vitamio/widget/MediaController;

    move-result-object v2

    invoke-virtual {v2, v5}, Lio/vov/vitamio/widget/MediaController;->show(I)V

    goto :goto_0

    .line 129
    :cond_6
    iget-object v2, p0, Lio/vov/vitamio/widget/VideoView$2;->this$0:Lio/vov/vitamio/widget/VideoView;

    invoke-static {v2}, Lio/vov/vitamio/widget/VideoView;->access$1200(Lio/vov/vitamio/widget/VideoView;)I

    move-result v2

    if-ne v2, v8, :cond_3

    .line 130
    iget-object v2, p0, Lio/vov/vitamio/widget/VideoView$2;->this$0:Lio/vov/vitamio/widget/VideoView;

    invoke-virtual {v2}, Lio/vov/vitamio/widget/VideoView;->start()V

    goto :goto_0
.end method

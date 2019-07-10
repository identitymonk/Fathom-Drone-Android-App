.class Lio/vov/vitamio/widget/MediaController$3;
.super Ljava/lang/Object;
.source "MediaController.java"

# interfaces
.implements Landroid/widget/SeekBar$OnSeekBarChangeListener;


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
    .line 126
    iput-object p1, p0, Lio/vov/vitamio/widget/MediaController$3;->this$0:Lio/vov/vitamio/widget/MediaController;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public onProgressChanged(Landroid/widget/SeekBar;IZ)V
    .locals 8
    .param p1, "bar"    # Landroid/widget/SeekBar;
    .param p2, "progress"    # I
    .param p3, "fromuser"    # Z

    .prologue
    .line 140
    if-nez p3, :cond_1

    .line 151
    :cond_0
    :goto_0
    return-void

    .line 143
    :cond_1
    iget-object v3, p0, Lio/vov/vitamio/widget/MediaController$3;->this$0:Lio/vov/vitamio/widget/MediaController;

    invoke-static {v3}, Lio/vov/vitamio/widget/MediaController;->access$900(Lio/vov/vitamio/widget/MediaController;)J

    move-result-wide v4

    int-to-long v6, p2

    mul-long/2addr v4, v6

    const-wide/16 v6, 0x3e8

    div-long v0, v4, v6

    .line 144
    .local v0, "newposition":J
    invoke-static {v0, v1}, Lio/vov/vitamio/utils/StringUtils;->generateTime(J)Ljava/lang/String;

    move-result-object v2

    .line 145
    .local v2, "time":Ljava/lang/String;
    iget-object v3, p0, Lio/vov/vitamio/widget/MediaController$3;->this$0:Lio/vov/vitamio/widget/MediaController;

    invoke-static {v3}, Lio/vov/vitamio/widget/MediaController;->access$600(Lio/vov/vitamio/widget/MediaController;)Z

    move-result v3

    if-eqz v3, :cond_2

    .line 146
    iget-object v3, p0, Lio/vov/vitamio/widget/MediaController$3;->this$0:Lio/vov/vitamio/widget/MediaController;

    invoke-static {v3}, Lio/vov/vitamio/widget/MediaController;->access$1000(Lio/vov/vitamio/widget/MediaController;)Lio/vov/vitamio/widget/MediaController$MediaPlayerControl;

    move-result-object v3

    invoke-interface {v3, v0, v1}, Lio/vov/vitamio/widget/MediaController$MediaPlayerControl;->seekTo(J)V

    .line 147
    :cond_2
    iget-object v3, p0, Lio/vov/vitamio/widget/MediaController$3;->this$0:Lio/vov/vitamio/widget/MediaController;

    invoke-static {v3}, Lio/vov/vitamio/widget/MediaController;->access$800(Lio/vov/vitamio/widget/MediaController;)Lio/vov/vitamio/widget/OutlineTextView;

    move-result-object v3

    if-eqz v3, :cond_3

    .line 148
    iget-object v3, p0, Lio/vov/vitamio/widget/MediaController$3;->this$0:Lio/vov/vitamio/widget/MediaController;

    invoke-static {v3}, Lio/vov/vitamio/widget/MediaController;->access$800(Lio/vov/vitamio/widget/MediaController;)Lio/vov/vitamio/widget/OutlineTextView;

    move-result-object v3

    invoke-virtual {v3, v2}, Lio/vov/vitamio/widget/OutlineTextView;->setText(Ljava/lang/String;)V

    .line 149
    :cond_3
    iget-object v3, p0, Lio/vov/vitamio/widget/MediaController$3;->this$0:Lio/vov/vitamio/widget/MediaController;

    invoke-static {v3}, Lio/vov/vitamio/widget/MediaController;->access$1100(Lio/vov/vitamio/widget/MediaController;)Landroid/widget/TextView;

    move-result-object v3

    if-eqz v3, :cond_0

    .line 150
    iget-object v3, p0, Lio/vov/vitamio/widget/MediaController$3;->this$0:Lio/vov/vitamio/widget/MediaController;

    invoke-static {v3}, Lio/vov/vitamio/widget/MediaController;->access$1100(Lio/vov/vitamio/widget/MediaController;)Landroid/widget/TextView;

    move-result-object v3

    invoke-virtual {v3, v2}, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V

    goto :goto_0
.end method

.method public onStartTrackingTouch(Landroid/widget/SeekBar;)V
    .locals 3
    .param p1, "bar"    # Landroid/widget/SeekBar;

    .prologue
    const/4 v2, 0x1

    .line 128
    iget-object v0, p0, Lio/vov/vitamio/widget/MediaController$3;->this$0:Lio/vov/vitamio/widget/MediaController;

    invoke-static {v0, v2}, Lio/vov/vitamio/widget/MediaController;->access$102(Lio/vov/vitamio/widget/MediaController;Z)Z

    .line 129
    iget-object v0, p0, Lio/vov/vitamio/widget/MediaController$3;->this$0:Lio/vov/vitamio/widget/MediaController;

    const v1, 0x36ee80

    invoke-virtual {v0, v1}, Lio/vov/vitamio/widget/MediaController;->show(I)V

    .line 130
    iget-object v0, p0, Lio/vov/vitamio/widget/MediaController$3;->this$0:Lio/vov/vitamio/widget/MediaController;

    invoke-static {v0}, Lio/vov/vitamio/widget/MediaController;->access$500(Lio/vov/vitamio/widget/MediaController;)Landroid/os/Handler;

    move-result-object v0

    const/4 v1, 0x2

    invoke-virtual {v0, v1}, Landroid/os/Handler;->removeMessages(I)V

    .line 131
    iget-object v0, p0, Lio/vov/vitamio/widget/MediaController$3;->this$0:Lio/vov/vitamio/widget/MediaController;

    invoke-static {v0}, Lio/vov/vitamio/widget/MediaController;->access$600(Lio/vov/vitamio/widget/MediaController;)Z

    move-result v0

    if-eqz v0, :cond_0

    .line 132
    iget-object v0, p0, Lio/vov/vitamio/widget/MediaController$3;->this$0:Lio/vov/vitamio/widget/MediaController;

    invoke-static {v0}, Lio/vov/vitamio/widget/MediaController;->access$700(Lio/vov/vitamio/widget/MediaController;)Landroid/media/AudioManager;

    move-result-object v0

    const/4 v1, 0x3

    invoke-virtual {v0, v1, v2}, Landroid/media/AudioManager;->setStreamMute(IZ)V

    .line 133
    :cond_0
    iget-object v0, p0, Lio/vov/vitamio/widget/MediaController$3;->this$0:Lio/vov/vitamio/widget/MediaController;

    invoke-static {v0}, Lio/vov/vitamio/widget/MediaController;->access$800(Lio/vov/vitamio/widget/MediaController;)Lio/vov/vitamio/widget/OutlineTextView;

    move-result-object v0

    if-eqz v0, :cond_1

    .line 134
    iget-object v0, p0, Lio/vov/vitamio/widget/MediaController$3;->this$0:Lio/vov/vitamio/widget/MediaController;

    invoke-static {v0}, Lio/vov/vitamio/widget/MediaController;->access$800(Lio/vov/vitamio/widget/MediaController;)Lio/vov/vitamio/widget/OutlineTextView;

    move-result-object v0

    const-string v1, ""

    invoke-virtual {v0, v1}, Lio/vov/vitamio/widget/OutlineTextView;->setText(Ljava/lang/String;)V

    .line 135
    iget-object v0, p0, Lio/vov/vitamio/widget/MediaController$3;->this$0:Lio/vov/vitamio/widget/MediaController;

    invoke-static {v0}, Lio/vov/vitamio/widget/MediaController;->access$800(Lio/vov/vitamio/widget/MediaController;)Lio/vov/vitamio/widget/OutlineTextView;

    move-result-object v0

    const/4 v1, 0x0

    invoke-virtual {v0, v1}, Lio/vov/vitamio/widget/OutlineTextView;->setVisibility(I)V

    .line 137
    :cond_1
    return-void
.end method

.method public onStopTrackingTouch(Landroid/widget/SeekBar;)V
    .locals 10
    .param p1, "bar"    # Landroid/widget/SeekBar;

    .prologue
    const-wide/16 v8, 0x3e8

    const/4 v7, 0x2

    const/4 v6, 0x0

    .line 154
    iget-object v0, p0, Lio/vov/vitamio/widget/MediaController$3;->this$0:Lio/vov/vitamio/widget/MediaController;

    invoke-static {v0}, Lio/vov/vitamio/widget/MediaController;->access$600(Lio/vov/vitamio/widget/MediaController;)Z

    move-result v0

    if-nez v0, :cond_0

    .line 155
    iget-object v0, p0, Lio/vov/vitamio/widget/MediaController$3;->this$0:Lio/vov/vitamio/widget/MediaController;

    invoke-static {v0}, Lio/vov/vitamio/widget/MediaController;->access$1000(Lio/vov/vitamio/widget/MediaController;)Lio/vov/vitamio/widget/MediaController$MediaPlayerControl;

    move-result-object v0

    iget-object v1, p0, Lio/vov/vitamio/widget/MediaController$3;->this$0:Lio/vov/vitamio/widget/MediaController;

    invoke-static {v1}, Lio/vov/vitamio/widget/MediaController;->access$900(Lio/vov/vitamio/widget/MediaController;)J

    move-result-wide v2

    invoke-virtual {p1}, Landroid/widget/SeekBar;->getProgress()I

    move-result v1

    int-to-long v4, v1

    mul-long/2addr v2, v4

    div-long/2addr v2, v8

    invoke-interface {v0, v2, v3}, Lio/vov/vitamio/widget/MediaController$MediaPlayerControl;->seekTo(J)V

    .line 156
    :cond_0
    iget-object v0, p0, Lio/vov/vitamio/widget/MediaController$3;->this$0:Lio/vov/vitamio/widget/MediaController;

    invoke-static {v0}, Lio/vov/vitamio/widget/MediaController;->access$800(Lio/vov/vitamio/widget/MediaController;)Lio/vov/vitamio/widget/OutlineTextView;

    move-result-object v0

    if-eqz v0, :cond_1

    .line 157
    iget-object v0, p0, Lio/vov/vitamio/widget/MediaController$3;->this$0:Lio/vov/vitamio/widget/MediaController;

    invoke-static {v0}, Lio/vov/vitamio/widget/MediaController;->access$800(Lio/vov/vitamio/widget/MediaController;)Lio/vov/vitamio/widget/OutlineTextView;

    move-result-object v0

    const-string v1, ""

    invoke-virtual {v0, v1}, Lio/vov/vitamio/widget/OutlineTextView;->setText(Ljava/lang/String;)V

    .line 158
    iget-object v0, p0, Lio/vov/vitamio/widget/MediaController$3;->this$0:Lio/vov/vitamio/widget/MediaController;

    invoke-static {v0}, Lio/vov/vitamio/widget/MediaController;->access$800(Lio/vov/vitamio/widget/MediaController;)Lio/vov/vitamio/widget/OutlineTextView;

    move-result-object v0

    const/16 v1, 0x8

    invoke-virtual {v0, v1}, Lio/vov/vitamio/widget/OutlineTextView;->setVisibility(I)V

    .line 160
    :cond_1
    iget-object v0, p0, Lio/vov/vitamio/widget/MediaController$3;->this$0:Lio/vov/vitamio/widget/MediaController;

    const/16 v1, 0xbb8

    invoke-virtual {v0, v1}, Lio/vov/vitamio/widget/MediaController;->show(I)V

    .line 161
    iget-object v0, p0, Lio/vov/vitamio/widget/MediaController$3;->this$0:Lio/vov/vitamio/widget/MediaController;

    invoke-static {v0}, Lio/vov/vitamio/widget/MediaController;->access$500(Lio/vov/vitamio/widget/MediaController;)Landroid/os/Handler;

    move-result-object v0

    invoke-virtual {v0, v7}, Landroid/os/Handler;->removeMessages(I)V

    .line 162
    iget-object v0, p0, Lio/vov/vitamio/widget/MediaController$3;->this$0:Lio/vov/vitamio/widget/MediaController;

    invoke-static {v0}, Lio/vov/vitamio/widget/MediaController;->access$700(Lio/vov/vitamio/widget/MediaController;)Landroid/media/AudioManager;

    move-result-object v0

    const/4 v1, 0x3

    invoke-virtual {v0, v1, v6}, Landroid/media/AudioManager;->setStreamMute(IZ)V

    .line 163
    iget-object v0, p0, Lio/vov/vitamio/widget/MediaController$3;->this$0:Lio/vov/vitamio/widget/MediaController;

    invoke-static {v0, v6}, Lio/vov/vitamio/widget/MediaController;->access$102(Lio/vov/vitamio/widget/MediaController;Z)Z

    .line 164
    iget-object v0, p0, Lio/vov/vitamio/widget/MediaController$3;->this$0:Lio/vov/vitamio/widget/MediaController;

    invoke-static {v0}, Lio/vov/vitamio/widget/MediaController;->access$500(Lio/vov/vitamio/widget/MediaController;)Landroid/os/Handler;

    move-result-object v0

    invoke-virtual {v0, v7, v8, v9}, Landroid/os/Handler;->sendEmptyMessageDelayed(IJ)Z

    .line 165
    return-void
.end method

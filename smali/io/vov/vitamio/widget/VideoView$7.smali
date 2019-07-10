.class Lio/vov/vitamio/widget/VideoView$7;
.super Ljava/lang/Object;
.source "VideoView.java"

# interfaces
.implements Lio/vov/vitamio/MediaPlayer$OnInfoListener;


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
    .line 242
    iput-object p1, p0, Lio/vov/vitamio/widget/VideoView$7;->this$0:Lio/vov/vitamio/widget/VideoView;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public onInfo(Lio/vov/vitamio/MediaPlayer;II)Z
    .locals 8
    .param p1, "mp"    # Lio/vov/vitamio/MediaPlayer;
    .param p2, "what"    # I
    .param p3, "extra"    # I

    .prologue
    const/4 v7, 0x2

    const/4 v6, 0x1

    const/4 v5, 0x0

    .line 245
    const-string v2, "onInfo: (%d, %d)"

    new-array v3, v7, [Ljava/lang/Object;

    invoke-static {p2}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v4

    aput-object v4, v3, v5

    invoke-static {p3}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v4

    aput-object v4, v3, v6

    invoke-static {v2, v3}, Lio/vov/vitamio/utils/Log;->d(Ljava/lang/String;[Ljava/lang/Object;)V

    .line 247
    const/16 v2, 0x3e9

    if-ne v2, p2, :cond_0

    .line 248
    const-string v2, " VITAMIO--TYPE_CHECK  stype  not include  onInfo mediaplayer unknow type "

    new-array v3, v5, [Ljava/lang/Object;

    invoke-static {v2, v3}, Lio/vov/vitamio/utils/Log;->e(Ljava/lang/String;[Ljava/lang/Object;)V

    .line 251
    :cond_0
    const/16 v2, 0x2c0

    if-ne v2, p2, :cond_1

    .line 252
    iget-object v2, p0, Lio/vov/vitamio/widget/VideoView$7;->this$0:Lio/vov/vitamio/widget/VideoView;

    invoke-static {v2}, Lio/vov/vitamio/widget/VideoView;->access$700(Lio/vov/vitamio/widget/VideoView;)Lio/vov/vitamio/MediaPlayer;

    move-result-object v2

    invoke-virtual {v2}, Lio/vov/vitamio/MediaPlayer;->audioTrackInit()I

    move-result v2

    int-to-long v0, v2

    .line 253
    .local v0, "buffersize":J
    iget-object v2, p0, Lio/vov/vitamio/widget/VideoView$7;->this$0:Lio/vov/vitamio/widget/VideoView;

    invoke-static {v2}, Lio/vov/vitamio/widget/VideoView;->access$700(Lio/vov/vitamio/widget/VideoView;)Lio/vov/vitamio/MediaPlayer;

    move-result-object v2

    invoke-virtual {v2, v0, v1}, Lio/vov/vitamio/MediaPlayer;->audioInitedOk(J)V

    .line 256
    .end local v0    # "buffersize":J
    :cond_1
    const-string v2, "onInfo: (%d, %d)"

    new-array v3, v7, [Ljava/lang/Object;

    invoke-static {p2}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v4

    aput-object v4, v3, v5

    invoke-static {p3}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v4

    aput-object v4, v3, v6

    invoke-static {v2, v3}, Lio/vov/vitamio/utils/Log;->d(Ljava/lang/String;[Ljava/lang/Object;)V

    .line 258
    iget-object v2, p0, Lio/vov/vitamio/widget/VideoView$7;->this$0:Lio/vov/vitamio/widget/VideoView;

    invoke-static {v2}, Lio/vov/vitamio/widget/VideoView;->access$2100(Lio/vov/vitamio/widget/VideoView;)Lio/vov/vitamio/MediaPlayer$OnInfoListener;

    move-result-object v2

    if-eqz v2, :cond_3

    .line 259
    iget-object v2, p0, Lio/vov/vitamio/widget/VideoView$7;->this$0:Lio/vov/vitamio/widget/VideoView;

    invoke-static {v2}, Lio/vov/vitamio/widget/VideoView;->access$2100(Lio/vov/vitamio/widget/VideoView;)Lio/vov/vitamio/MediaPlayer$OnInfoListener;

    move-result-object v2

    invoke-interface {v2, p1, p2, p3}, Lio/vov/vitamio/MediaPlayer$OnInfoListener;->onInfo(Lio/vov/vitamio/MediaPlayer;II)Z

    .line 271
    :cond_2
    :goto_0
    return v6

    .line 260
    :cond_3
    iget-object v2, p0, Lio/vov/vitamio/widget/VideoView$7;->this$0:Lio/vov/vitamio/widget/VideoView;

    invoke-static {v2}, Lio/vov/vitamio/widget/VideoView;->access$700(Lio/vov/vitamio/widget/VideoView;)Lio/vov/vitamio/MediaPlayer;

    move-result-object v2

    if-eqz v2, :cond_2

    .line 261
    const/16 v2, 0x2bd

    if-ne p2, v2, :cond_4

    .line 262
    iget-object v2, p0, Lio/vov/vitamio/widget/VideoView$7;->this$0:Lio/vov/vitamio/widget/VideoView;

    invoke-static {v2}, Lio/vov/vitamio/widget/VideoView;->access$700(Lio/vov/vitamio/widget/VideoView;)Lio/vov/vitamio/MediaPlayer;

    move-result-object v2

    invoke-virtual {v2}, Lio/vov/vitamio/MediaPlayer;->pause()V

    .line 263
    iget-object v2, p0, Lio/vov/vitamio/widget/VideoView$7;->this$0:Lio/vov/vitamio/widget/VideoView;

    invoke-static {v2}, Lio/vov/vitamio/widget/VideoView;->access$2200(Lio/vov/vitamio/widget/VideoView;)Landroid/view/View;

    move-result-object v2

    if-eqz v2, :cond_2

    .line 264
    iget-object v2, p0, Lio/vov/vitamio/widget/VideoView$7;->this$0:Lio/vov/vitamio/widget/VideoView;

    invoke-static {v2}, Lio/vov/vitamio/widget/VideoView;->access$2200(Lio/vov/vitamio/widget/VideoView;)Landroid/view/View;

    move-result-object v2

    invoke-virtual {v2, v5}, Landroid/view/View;->setVisibility(I)V

    goto :goto_0

    .line 265
    :cond_4
    const/16 v2, 0x2be

    if-ne p2, v2, :cond_2

    .line 266
    iget-object v2, p0, Lio/vov/vitamio/widget/VideoView$7;->this$0:Lio/vov/vitamio/widget/VideoView;

    invoke-static {v2}, Lio/vov/vitamio/widget/VideoView;->access$700(Lio/vov/vitamio/widget/VideoView;)Lio/vov/vitamio/MediaPlayer;

    move-result-object v2

    invoke-virtual {v2}, Lio/vov/vitamio/MediaPlayer;->start()V

    .line 267
    iget-object v2, p0, Lio/vov/vitamio/widget/VideoView$7;->this$0:Lio/vov/vitamio/widget/VideoView;

    invoke-static {v2}, Lio/vov/vitamio/widget/VideoView;->access$2200(Lio/vov/vitamio/widget/VideoView;)Landroid/view/View;

    move-result-object v2

    if-eqz v2, :cond_2

    .line 268
    iget-object v2, p0, Lio/vov/vitamio/widget/VideoView$7;->this$0:Lio/vov/vitamio/widget/VideoView;

    invoke-static {v2}, Lio/vov/vitamio/widget/VideoView;->access$2200(Lio/vov/vitamio/widget/VideoView;)Landroid/view/View;

    move-result-object v2

    const/16 v3, 0x8

    invoke-virtual {v2, v3}, Landroid/view/View;->setVisibility(I)V

    goto :goto_0
.end method

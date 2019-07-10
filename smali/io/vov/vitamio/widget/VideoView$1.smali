.class Lio/vov/vitamio/widget/VideoView$1;
.super Ljava/lang/Object;
.source "VideoView.java"

# interfaces
.implements Lio/vov/vitamio/MediaPlayer$OnVideoSizeChangedListener;


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
    .line 86
    iput-object p1, p0, Lio/vov/vitamio/widget/VideoView$1;->this$0:Lio/vov/vitamio/widget/VideoView;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public onVideoSizeChanged(Lio/vov/vitamio/MediaPlayer;II)V
    .locals 4
    .param p1, "mp"    # Lio/vov/vitamio/MediaPlayer;
    .param p2, "width"    # I
    .param p3, "height"    # I

    .prologue
    .line 88
    const-string v0, "onVideoSizeChanged: (%dx%d)"

    const/4 v1, 0x2

    new-array v1, v1, [Ljava/lang/Object;

    const/4 v2, 0x0

    invoke-static {p2}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v3

    aput-object v3, v1, v2

    const/4 v2, 0x1

    invoke-static {p3}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v3

    aput-object v3, v1, v2

    invoke-static {v0, v1}, Lio/vov/vitamio/utils/Log;->d(Ljava/lang/String;[Ljava/lang/Object;)V

    .line 89
    iget-object v0, p0, Lio/vov/vitamio/widget/VideoView$1;->this$0:Lio/vov/vitamio/widget/VideoView;

    invoke-virtual {p1}, Lio/vov/vitamio/MediaPlayer;->getVideoWidth()I

    move-result v1

    invoke-static {v0, v1}, Lio/vov/vitamio/widget/VideoView;->access$002(Lio/vov/vitamio/widget/VideoView;I)I

    .line 90
    iget-object v0, p0, Lio/vov/vitamio/widget/VideoView$1;->this$0:Lio/vov/vitamio/widget/VideoView;

    invoke-virtual {p1}, Lio/vov/vitamio/MediaPlayer;->getVideoHeight()I

    move-result v1

    invoke-static {v0, v1}, Lio/vov/vitamio/widget/VideoView;->access$102(Lio/vov/vitamio/widget/VideoView;I)I

    .line 91
    iget-object v0, p0, Lio/vov/vitamio/widget/VideoView$1;->this$0:Lio/vov/vitamio/widget/VideoView;

    invoke-virtual {p1}, Lio/vov/vitamio/MediaPlayer;->getVideoAspectRatio()F

    move-result v1

    invoke-static {v0, v1}, Lio/vov/vitamio/widget/VideoView;->access$202(Lio/vov/vitamio/widget/VideoView;F)F

    .line 92
    iget-object v0, p0, Lio/vov/vitamio/widget/VideoView$1;->this$0:Lio/vov/vitamio/widget/VideoView;

    invoke-static {v0}, Lio/vov/vitamio/widget/VideoView;->access$000(Lio/vov/vitamio/widget/VideoView;)I

    move-result v0

    if-eqz v0, :cond_0

    iget-object v0, p0, Lio/vov/vitamio/widget/VideoView$1;->this$0:Lio/vov/vitamio/widget/VideoView;

    invoke-static {v0}, Lio/vov/vitamio/widget/VideoView;->access$100(Lio/vov/vitamio/widget/VideoView;)I

    move-result v0

    if-eqz v0, :cond_0

    .line 93
    iget-object v0, p0, Lio/vov/vitamio/widget/VideoView$1;->this$0:Lio/vov/vitamio/widget/VideoView;

    iget-object v1, p0, Lio/vov/vitamio/widget/VideoView$1;->this$0:Lio/vov/vitamio/widget/VideoView;

    invoke-static {v1}, Lio/vov/vitamio/widget/VideoView;->access$300(Lio/vov/vitamio/widget/VideoView;)I

    move-result v1

    iget-object v2, p0, Lio/vov/vitamio/widget/VideoView$1;->this$0:Lio/vov/vitamio/widget/VideoView;

    invoke-static {v2}, Lio/vov/vitamio/widget/VideoView;->access$400(Lio/vov/vitamio/widget/VideoView;)F

    move-result v2

    invoke-virtual {v0, v1, v2}, Lio/vov/vitamio/widget/VideoView;->setVideoLayout(IF)V

    .line 94
    :cond_0
    return-void
.end method

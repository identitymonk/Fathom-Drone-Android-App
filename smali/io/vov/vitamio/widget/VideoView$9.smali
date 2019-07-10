.class Lio/vov/vitamio/widget/VideoView$9;
.super Ljava/lang/Object;
.source "VideoView.java"

# interfaces
.implements Lio/vov/vitamio/MediaPlayer$OnTimedTextListener;


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
    .line 282
    iput-object p1, p0, Lio/vov/vitamio/widget/VideoView$9;->this$0:Lio/vov/vitamio/widget/VideoView;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public onTimedText(Ljava/lang/String;)V
    .locals 3
    .param p1, "text"    # Ljava/lang/String;

    .prologue
    .line 292
    const-string v0, "onSubtitleUpdate: %s"

    const/4 v1, 0x1

    new-array v1, v1, [Ljava/lang/Object;

    const/4 v2, 0x0

    aput-object p1, v1, v2

    invoke-static {v0, v1}, Lio/vov/vitamio/utils/Log;->i(Ljava/lang/String;[Ljava/lang/Object;)V

    .line 293
    iget-object v0, p0, Lio/vov/vitamio/widget/VideoView$9;->this$0:Lio/vov/vitamio/widget/VideoView;

    invoke-static {v0}, Lio/vov/vitamio/widget/VideoView;->access$2400(Lio/vov/vitamio/widget/VideoView;)Lio/vov/vitamio/MediaPlayer$OnTimedTextListener;

    move-result-object v0

    if-eqz v0, :cond_0

    .line 294
    iget-object v0, p0, Lio/vov/vitamio/widget/VideoView$9;->this$0:Lio/vov/vitamio/widget/VideoView;

    invoke-static {v0}, Lio/vov/vitamio/widget/VideoView;->access$2400(Lio/vov/vitamio/widget/VideoView;)Lio/vov/vitamio/MediaPlayer$OnTimedTextListener;

    move-result-object v0

    invoke-interface {v0, p1}, Lio/vov/vitamio/MediaPlayer$OnTimedTextListener;->onTimedText(Ljava/lang/String;)V

    .line 295
    :cond_0
    return-void
.end method

.method public onTimedTextUpdate([BII)V
    .locals 4
    .param p1, "pixels"    # [B
    .param p2, "width"    # I
    .param p3, "height"    # I

    .prologue
    .line 285
    const-string v0, "onSubtitleUpdate: bitmap subtitle, %dx%d"

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

    invoke-static {v0, v1}, Lio/vov/vitamio/utils/Log;->i(Ljava/lang/String;[Ljava/lang/Object;)V

    .line 286
    iget-object v0, p0, Lio/vov/vitamio/widget/VideoView$9;->this$0:Lio/vov/vitamio/widget/VideoView;

    invoke-static {v0}, Lio/vov/vitamio/widget/VideoView;->access$2400(Lio/vov/vitamio/widget/VideoView;)Lio/vov/vitamio/MediaPlayer$OnTimedTextListener;

    move-result-object v0

    if-eqz v0, :cond_0

    .line 287
    iget-object v0, p0, Lio/vov/vitamio/widget/VideoView$9;->this$0:Lio/vov/vitamio/widget/VideoView;

    invoke-static {v0}, Lio/vov/vitamio/widget/VideoView;->access$2400(Lio/vov/vitamio/widget/VideoView;)Lio/vov/vitamio/MediaPlayer$OnTimedTextListener;

    move-result-object v0

    invoke-interface {v0, p1, p2, p3}, Lio/vov/vitamio/MediaPlayer$OnTimedTextListener;->onTimedTextUpdate([BII)V

    .line 288
    :cond_0
    return-void
.end method

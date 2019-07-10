.class Lio/vov/vitamio/widget/VideoView$6;
.super Ljava/lang/Object;
.source "VideoView.java"

# interfaces
.implements Lio/vov/vitamio/MediaPlayer$OnBufferingUpdateListener;


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
    .line 235
    iput-object p1, p0, Lio/vov/vitamio/widget/VideoView$6;->this$0:Lio/vov/vitamio/widget/VideoView;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public onBufferingUpdate(Lio/vov/vitamio/MediaPlayer;I)V
    .locals 1
    .param p1, "mp"    # Lio/vov/vitamio/MediaPlayer;
    .param p2, "percent"    # I

    .prologue
    .line 237
    iget-object v0, p0, Lio/vov/vitamio/widget/VideoView$6;->this$0:Lio/vov/vitamio/widget/VideoView;

    invoke-static {v0, p2}, Lio/vov/vitamio/widget/VideoView;->access$1902(Lio/vov/vitamio/widget/VideoView;I)I

    .line 238
    iget-object v0, p0, Lio/vov/vitamio/widget/VideoView$6;->this$0:Lio/vov/vitamio/widget/VideoView;

    invoke-static {v0}, Lio/vov/vitamio/widget/VideoView;->access$2000(Lio/vov/vitamio/widget/VideoView;)Lio/vov/vitamio/MediaPlayer$OnBufferingUpdateListener;

    move-result-object v0

    if-eqz v0, :cond_0

    .line 239
    iget-object v0, p0, Lio/vov/vitamio/widget/VideoView$6;->this$0:Lio/vov/vitamio/widget/VideoView;

    invoke-static {v0}, Lio/vov/vitamio/widget/VideoView;->access$2000(Lio/vov/vitamio/widget/VideoView;)Lio/vov/vitamio/MediaPlayer$OnBufferingUpdateListener;

    move-result-object v0

    invoke-interface {v0, p1, p2}, Lio/vov/vitamio/MediaPlayer$OnBufferingUpdateListener;->onBufferingUpdate(Lio/vov/vitamio/MediaPlayer;I)V

    .line 240
    :cond_0
    return-void
.end method

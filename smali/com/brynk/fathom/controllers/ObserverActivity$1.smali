.class Lcom/brynk/fathom/controllers/ObserverActivity$1;
.super Ljava/lang/Object;
.source "ObserverActivity.java"

# interfaces
.implements Lio/vov/vitamio/MediaPlayer$OnPreparedListener;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/brynk/fathom/controllers/ObserverActivity;->onCreate(Landroid/os/Bundle;)V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$0:Lcom/brynk/fathom/controllers/ObserverActivity;


# direct methods
.method constructor <init>(Lcom/brynk/fathom/controllers/ObserverActivity;)V
    .locals 0
    .param p1, "this$0"    # Lcom/brynk/fathom/controllers/ObserverActivity;

    .prologue
    .line 44
    iput-object p1, p0, Lcom/brynk/fathom/controllers/ObserverActivity$1;->this$0:Lcom/brynk/fathom/controllers/ObserverActivity;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public onPrepared(Lio/vov/vitamio/MediaPlayer;)V
    .locals 4
    .param p1, "mp"    # Lio/vov/vitamio/MediaPlayer;

    .prologue
    .line 47
    const/high16 v0, 0x3f800000    # 1.0f

    invoke-virtual {p1, v0}, Lio/vov/vitamio/MediaPlayer;->setPlaybackSpeed(F)V

    .line 48
    iget-object v0, p0, Lcom/brynk/fathom/controllers/ObserverActivity$1;->this$0:Lcom/brynk/fathom/controllers/ObserverActivity;

    invoke-static {v0}, Lcom/brynk/fathom/controllers/ObserverActivity;->access$000(Lcom/brynk/fathom/controllers/ObserverActivity;)Lio/vov/vitamio/widget/VideoView;

    move-result-object v0

    iget-object v1, p0, Lcom/brynk/fathom/controllers/ObserverActivity$1;->this$0:Lcom/brynk/fathom/controllers/ObserverActivity;

    invoke-static {v1}, Lcom/brynk/fathom/controllers/ObserverActivity;->access$000(Lcom/brynk/fathom/controllers/ObserverActivity;)Lio/vov/vitamio/widget/VideoView;

    move-result-object v1

    invoke-virtual {v1}, Lio/vov/vitamio/widget/VideoView;->getDuration()J

    move-result-wide v2

    invoke-virtual {v0, v2, v3}, Lio/vov/vitamio/widget/VideoView;->seekTo(J)V

    .line 49
    iget-object v0, p0, Lcom/brynk/fathom/controllers/ObserverActivity$1;->this$0:Lcom/brynk/fathom/controllers/ObserverActivity;

    invoke-static {v0}, Lcom/brynk/fathom/controllers/ObserverActivity;->access$000(Lcom/brynk/fathom/controllers/ObserverActivity;)Lio/vov/vitamio/widget/VideoView;

    move-result-object v0

    invoke-virtual {v0}, Lio/vov/vitamio/widget/VideoView;->start()V

    .line 50
    return-void
.end method

.class Lcom/brynk/fathom/controllers/MainActivity$2;
.super Ljava/lang/Object;
.source "MainActivity.java"

# interfaces
.implements Lio/vov/vitamio/MediaPlayer$OnPreparedListener;


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
    .line 176
    iput-object p1, p0, Lcom/brynk/fathom/controllers/MainActivity$2;->this$0:Lcom/brynk/fathom/controllers/MainActivity;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public onPrepared(Lio/vov/vitamio/MediaPlayer;)V
    .locals 8
    .param p1, "mp"    # Lio/vov/vitamio/MediaPlayer;

    .prologue
    .line 179
    const/high16 v5, 0x3f800000    # 1.0f

    invoke-virtual {p1, v5}, Lio/vov/vitamio/MediaPlayer;->setPlaybackSpeed(F)V

    .line 180
    const-wide/16 v6, 0x3e8

    invoke-virtual {p1, v6, v7}, Lio/vov/vitamio/MediaPlayer;->setBufferSize(J)V

    .line 181
    iget-object v5, p0, Lcom/brynk/fathom/controllers/MainActivity$2;->this$0:Lcom/brynk/fathom/controllers/MainActivity;

    invoke-static {v5}, Lcom/brynk/fathom/controllers/MainActivity;->access$000(Lcom/brynk/fathom/controllers/MainActivity;)Lio/vov/vitamio/widget/VideoView;

    move-result-object v5

    const/16 v6, 0x3e8

    invoke-virtual {v5, v6}, Lio/vov/vitamio/widget/VideoView;->setBufferSize(I)V

    .line 182
    invoke-virtual {p1}, Lio/vov/vitamio/MediaPlayer;->start()V

    .line 183
    iget-object v5, p0, Lcom/brynk/fathom/controllers/MainActivity$2;->this$0:Lcom/brynk/fathom/controllers/MainActivity;

    invoke-static {v5}, Lcom/brynk/fathom/controllers/MainActivity;->access$000(Lcom/brynk/fathom/controllers/MainActivity;)Lio/vov/vitamio/widget/VideoView;

    move-result-object v5

    invoke-virtual {v5}, Lio/vov/vitamio/widget/VideoView;->start()V

    .line 185
    iget-object v5, p0, Lcom/brynk/fathom/controllers/MainActivity$2;->this$0:Lcom/brynk/fathom/controllers/MainActivity;

    const v6, 0x7f0f00c1

    invoke-virtual {v5, v6}, Lcom/brynk/fathom/controllers/MainActivity;->findViewById(I)Landroid/view/View;

    move-result-object v3

    check-cast v3, Landroid/widget/RelativeLayout;

    .line 186
    .local v3, "rl_pilotLoader":Landroid/widget/RelativeLayout;
    iget-object v5, p0, Lcom/brynk/fathom/controllers/MainActivity$2;->this$0:Lcom/brynk/fathom/controllers/MainActivity;

    const v6, 0x7f0f00c2

    invoke-virtual {v5, v6}, Lcom/brynk/fathom/controllers/MainActivity;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/VideoView;

    .line 187
    .local v0, "loadingVideo":Landroid/widget/VideoView;
    iget-object v5, p0, Lcom/brynk/fathom/controllers/MainActivity$2;->this$0:Lcom/brynk/fathom/controllers/MainActivity;

    const v6, 0x7f0f00a4

    invoke-virtual {v5, v6}, Lcom/brynk/fathom/controllers/MainActivity;->findViewById(I)Landroid/view/View;

    move-result-object v4

    check-cast v4, Landroid/widget/RelativeLayout;

    .line 191
    .local v4, "rl_pilotViewWrapper":Landroid/widget/RelativeLayout;
    new-instance v1, Landroid/os/Handler;

    invoke-direct {v1}, Landroid/os/Handler;-><init>()V

    .line 192
    .local v1, "mHandler":Landroid/os/Handler;
    new-instance v2, Lcom/brynk/fathom/controllers/MainActivity$2$1;

    invoke-direct {v2, p0, v3, v0, v4}, Lcom/brynk/fathom/controllers/MainActivity$2$1;-><init>(Lcom/brynk/fathom/controllers/MainActivity$2;Landroid/widget/RelativeLayout;Landroid/widget/VideoView;Landroid/widget/RelativeLayout;)V

    .line 206
    .local v2, "mRunnable":Ljava/lang/Runnable;
    const-wide/16 v6, 0x1770

    invoke-virtual {v1, v2, v6, v7}, Landroid/os/Handler;->postDelayed(Ljava/lang/Runnable;J)Z

    .line 208
    return-void
.end method

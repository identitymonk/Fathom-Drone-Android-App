.class public Lcom/brynk/fathom/controllers/ObserverActivity;
.super Landroid/support/v7/app/AppCompatActivity;
.source "ObserverActivity.java"


# instance fields
.field private mediaController:Lio/vov/vitamio/widget/MediaController;

.field private path:Ljava/lang/String;

.field private videoView:Lio/vov/vitamio/widget/VideoView;


# direct methods
.method public constructor <init>()V
    .locals 1

    .prologue
    .line 18
    invoke-direct {p0}, Landroid/support/v7/app/AppCompatActivity;-><init>()V

    .line 22
    const-string v0, "udp://@:8010"

    iput-object v0, p0, Lcom/brynk/fathom/controllers/ObserverActivity;->path:Ljava/lang/String;

    return-void
.end method

.method static synthetic access$000(Lcom/brynk/fathom/controllers/ObserverActivity;)Lio/vov/vitamio/widget/VideoView;
    .locals 1
    .param p0, "x0"    # Lcom/brynk/fathom/controllers/ObserverActivity;

    .prologue
    .line 18
    iget-object v0, p0, Lcom/brynk/fathom/controllers/ObserverActivity;->videoView:Lio/vov/vitamio/widget/VideoView;

    return-object v0
.end method

.method private init()V
    .locals 1

    .prologue
    .line 62
    const v0, 0x7f0f00c3

    invoke-virtual {p0, v0}, Lcom/brynk/fathom/controllers/ObserverActivity;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Lio/vov/vitamio/widget/VideoView;

    iput-object v0, p0, Lcom/brynk/fathom/controllers/ObserverActivity;->videoView:Lio/vov/vitamio/widget/VideoView;

    .line 63
    new-instance v0, Lio/vov/vitamio/widget/MediaController;

    invoke-direct {v0, p0}, Lio/vov/vitamio/widget/MediaController;-><init>(Landroid/content/Context;)V

    iput-object v0, p0, Lcom/brynk/fathom/controllers/ObserverActivity;->mediaController:Lio/vov/vitamio/widget/MediaController;

    .line 64
    return-void
.end method


# virtual methods
.method protected onCreate(Landroid/os/Bundle;)V
    .locals 2
    .param p1, "savedInstanceState"    # Landroid/os/Bundle;

    .prologue
    const/16 v1, 0x400

    .line 27
    invoke-super {p0, p1}, Landroid/support/v7/app/AppCompatActivity;->onCreate(Landroid/os/Bundle;)V

    .line 29
    const v0, 0x7f04001f

    invoke-virtual {p0, v0}, Lcom/brynk/fathom/controllers/ObserverActivity;->setContentView(I)V

    .line 31
    invoke-virtual {p0}, Lcom/brynk/fathom/controllers/ObserverActivity;->getWindow()Landroid/view/Window;

    move-result-object v0

    invoke-virtual {v0, v1, v1}, Landroid/view/Window;->setFlags(II)V

    .line 34
    invoke-direct {p0}, Lcom/brynk/fathom/controllers/ObserverActivity;->init()V

    .line 35
    iget-object v0, p0, Lcom/brynk/fathom/controllers/ObserverActivity;->videoView:Lio/vov/vitamio/widget/VideoView;

    iget-object v1, p0, Lcom/brynk/fathom/controllers/ObserverActivity;->mediaController:Lio/vov/vitamio/widget/MediaController;

    invoke-virtual {v0, v1}, Lio/vov/vitamio/widget/VideoView;->setMediaController(Lio/vov/vitamio/widget/MediaController;)V

    .line 39
    iget-object v0, p0, Lcom/brynk/fathom/controllers/ObserverActivity;->videoView:Lio/vov/vitamio/widget/VideoView;

    iget-object v1, p0, Lcom/brynk/fathom/controllers/ObserverActivity;->path:Ljava/lang/String;

    invoke-static {v1}, Landroid/net/Uri;->parse(Ljava/lang/String;)Landroid/net/Uri;

    move-result-object v1

    invoke-virtual {v0, v1}, Lio/vov/vitamio/widget/VideoView;->setVideoURI(Landroid/net/Uri;)V

    .line 44
    iget-object v0, p0, Lcom/brynk/fathom/controllers/ObserverActivity;->videoView:Lio/vov/vitamio/widget/VideoView;

    new-instance v1, Lcom/brynk/fathom/controllers/ObserverActivity$1;

    invoke-direct {v1, p0}, Lcom/brynk/fathom/controllers/ObserverActivity$1;-><init>(Lcom/brynk/fathom/controllers/ObserverActivity;)V

    invoke-virtual {v0, v1}, Lio/vov/vitamio/widget/VideoView;->setOnPreparedListener(Lio/vov/vitamio/MediaPlayer$OnPreparedListener;)V

    .line 53
    return-void
.end method

.method protected onPostCreate(Landroid/os/Bundle;)V
    .locals 0
    .param p1, "savedInstanceState"    # Landroid/os/Bundle;

    .prologue
    .line 57
    invoke-super {p0, p1}, Landroid/support/v7/app/AppCompatActivity;->onPostCreate(Landroid/os/Bundle;)V

    .line 60
    return-void
.end method

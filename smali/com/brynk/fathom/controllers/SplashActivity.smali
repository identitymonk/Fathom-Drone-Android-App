.class public Lcom/brynk/fathom/controllers/SplashActivity;
.super Landroid/support/v7/app/AppCompatActivity;
.source "SplashActivity.java"


# static fields
.field private static final UI_ANIMATION_DELAY:I


# instance fields
.field private final SPLASH_DISPLAY_LENGTH:I

.field private mContentView:Landroid/view/View;

.field private final mHideHandler:Landroid/os/Handler;

.field private final mHidePart2Runnable:Ljava/lang/Runnable;


# direct methods
.method public constructor <init>()V
    .locals 1

    .prologue
    .line 18
    invoke-direct {p0}, Landroid/support/v7/app/AppCompatActivity;-><init>()V

    .line 20
    const/16 v0, 0xbb8

    iput v0, p0, Lcom/brynk/fathom/controllers/SplashActivity;->SPLASH_DISPLAY_LENGTH:I

    .line 28
    new-instance v0, Landroid/os/Handler;

    invoke-direct {v0}, Landroid/os/Handler;-><init>()V

    iput-object v0, p0, Lcom/brynk/fathom/controllers/SplashActivity;->mHideHandler:Landroid/os/Handler;

    .line 30
    new-instance v0, Lcom/brynk/fathom/controllers/SplashActivity$1;

    invoke-direct {v0, p0}, Lcom/brynk/fathom/controllers/SplashActivity$1;-><init>(Lcom/brynk/fathom/controllers/SplashActivity;)V

    iput-object v0, p0, Lcom/brynk/fathom/controllers/SplashActivity;->mHidePart2Runnable:Ljava/lang/Runnable;

    return-void
.end method

.method static synthetic access$000(Lcom/brynk/fathom/controllers/SplashActivity;)Landroid/view/View;
    .locals 1
    .param p0, "x0"    # Lcom/brynk/fathom/controllers/SplashActivity;

    .prologue
    .line 18
    iget-object v0, p0, Lcom/brynk/fathom/controllers/SplashActivity;->mContentView:Landroid/view/View;

    return-object v0
.end method

.method static synthetic access$100(Lcom/brynk/fathom/controllers/SplashActivity;)V
    .locals 0
    .param p0, "x0"    # Lcom/brynk/fathom/controllers/SplashActivity;

    .prologue
    .line 18
    invoke-direct {p0}, Lcom/brynk/fathom/controllers/SplashActivity;->checkWifiAndGo()V

    return-void
.end method

.method private checkWifiAndGo()V
    .locals 2

    .prologue
    .line 96
    new-instance v0, Landroid/content/Intent;

    const-class v1, Lcom/brynk/fathom/controllers/LobbyActivity;

    invoke-direct {v0, p0, v1}, Landroid/content/Intent;-><init>(Landroid/content/Context;Ljava/lang/Class;)V

    invoke-virtual {p0, v0}, Lcom/brynk/fathom/controllers/SplashActivity;->startActivity(Landroid/content/Intent;)V

    .line 98
    return-void
.end method

.method private hide()V
    .locals 6

    .prologue
    .line 102
    invoke-virtual {p0}, Lcom/brynk/fathom/controllers/SplashActivity;->getSupportActionBar()Landroid/support/v7/app/ActionBar;

    move-result-object v0

    .line 103
    .local v0, "actionBar":Landroid/support/v7/app/ActionBar;
    if-eqz v0, :cond_0

    .line 104
    invoke-virtual {v0}, Landroid/support/v7/app/ActionBar;->hide()V

    .line 106
    :cond_0
    iget-object v1, p0, Lcom/brynk/fathom/controllers/SplashActivity;->mHideHandler:Landroid/os/Handler;

    iget-object v2, p0, Lcom/brynk/fathom/controllers/SplashActivity;->mHidePart2Runnable:Ljava/lang/Runnable;

    const-wide/16 v4, 0x0

    invoke-virtual {v1, v2, v4, v5}, Landroid/os/Handler;->postDelayed(Ljava/lang/Runnable;J)Z

    .line 107
    return-void
.end method


# virtual methods
.method protected onCreate(Landroid/os/Bundle;)V
    .locals 6
    .param p1, "savedInstanceState"    # Landroid/os/Bundle;

    .prologue
    .line 52
    invoke-super {p0, p1}, Landroid/support/v7/app/AppCompatActivity;->onCreate(Landroid/os/Bundle;)V

    .line 53
    invoke-direct {p0}, Lcom/brynk/fathom/controllers/SplashActivity;->hide()V

    .line 55
    const v1, 0x7f040022

    invoke-virtual {p0, v1}, Lcom/brynk/fathom/controllers/SplashActivity;->setContentView(I)V

    .line 56
    const v1, 0x7f0f00cb

    invoke-virtual {p0, v1}, Lcom/brynk/fathom/controllers/SplashActivity;->findViewById(I)Landroid/view/View;

    move-result-object v1

    iput-object v1, p0, Lcom/brynk/fathom/controllers/SplashActivity;->mContentView:Landroid/view/View;

    .line 58
    const v1, 0x7f0f00cc

    invoke-virtual {p0, v1}, Lcom/brynk/fathom/controllers/SplashActivity;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/VideoView;

    .line 59
    .local v0, "splashvideo":Landroid/widget/VideoView;
    new-instance v1, Ljava/lang/StringBuilder;

    invoke-direct {v1}, Ljava/lang/StringBuilder;-><init>()V

    const-string v2, "android.resource://"

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {p0}, Lcom/brynk/fathom/controllers/SplashActivity;->getPackageName()Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    const-string v2, "/"

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    const v2, 0x7f070002

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Landroid/widget/VideoView;->setVideoPath(Ljava/lang/String;)V

    .line 60
    invoke-virtual {v0}, Landroid/widget/VideoView;->start()V

    .line 69
    new-instance v1, Landroid/os/Handler;

    invoke-direct {v1}, Landroid/os/Handler;-><init>()V

    new-instance v2, Lcom/brynk/fathom/controllers/SplashActivity$2;

    invoke-direct {v2, p0}, Lcom/brynk/fathom/controllers/SplashActivity$2;-><init>(Lcom/brynk/fathom/controllers/SplashActivity;)V

    const-wide/16 v4, 0xbb8

    invoke-virtual {v1, v2, v4, v5}, Landroid/os/Handler;->postDelayed(Ljava/lang/Runnable;J)Z

    .line 82
    return-void
.end method

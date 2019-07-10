.class public Lcom/brynk/fathom/controllers/WiFiSetupActivity;
.super Landroid/support/v7/app/AppCompatActivity;
.source "WiFiSetupActivity.java"


# instance fields
.field private connectedToFathomNetwork:Ljava/lang/Boolean;


# direct methods
.method public constructor <init>()V
    .locals 1

    .prologue
    .line 44
    invoke-direct {p0}, Landroid/support/v7/app/AppCompatActivity;-><init>()V

    .line 45
    const/4 v0, 0x0

    invoke-static {v0}, Ljava/lang/Boolean;->valueOf(Z)Ljava/lang/Boolean;

    move-result-object v0

    iput-object v0, p0, Lcom/brynk/fathom/controllers/WiFiSetupActivity;->connectedToFathomNetwork:Ljava/lang/Boolean;

    return-void
.end method

.method static synthetic access$000(Lcom/brynk/fathom/controllers/WiFiSetupActivity;)V
    .locals 0
    .param p0, "x0"    # Lcom/brynk/fathom/controllers/WiFiSetupActivity;

    .prologue
    .line 44
    invoke-direct {p0}, Lcom/brynk/fathom/controllers/WiFiSetupActivity;->checkWifiStatus()V

    return-void
.end method

.method private checkWifiStatus()V
    .locals 7

    .prologue
    const v6, 0x7f0f00d0

    const/4 v5, 0x0

    .line 70
    new-instance v3, Lcom/brynk/fathom/helpers/WiFiHelper;

    invoke-direct {v3}, Lcom/brynk/fathom/helpers/WiFiHelper;-><init>()V

    invoke-virtual {p0}, Lcom/brynk/fathom/controllers/WiFiSetupActivity;->getApplicationContext()Landroid/content/Context;

    move-result-object v4

    invoke-virtual {v3, v4}, Lcom/brynk/fathom/helpers/WiFiHelper;->isConnectedToFathomNetwork(Landroid/content/Context;)Z

    move-result v3

    if-eqz v3, :cond_0

    .line 71
    const/4 v3, 0x1

    invoke-static {v3}, Ljava/lang/Boolean;->valueOf(Z)Ljava/lang/Boolean;

    move-result-object v3

    iput-object v3, p0, Lcom/brynk/fathom/controllers/WiFiSetupActivity;->connectedToFathomNetwork:Ljava/lang/Boolean;

    .line 73
    const v3, 0x7f0f009c

    invoke-virtual {p0, v3}, Lcom/brynk/fathom/controllers/WiFiSetupActivity;->findViewById(I)Landroid/view/View;

    move-result-object v1

    check-cast v1, Landroid/widget/ProgressBar;

    .line 74
    .local v1, "progressBar":Landroid/widget/ProgressBar;
    const/4 v3, 0x4

    invoke-virtual {v1, v3}, Landroid/widget/ProgressBar;->setVisibility(I)V

    .line 77
    const v3, 0x7f0f00cf

    invoke-virtual {p0, v3}, Lcom/brynk/fathom/controllers/WiFiSetupActivity;->findViewById(I)Landroid/view/View;

    move-result-object v2

    check-cast v2, Landroid/widget/TextView;

    .line 78
    .local v2, "tvConnected":Landroid/widget/TextView;
    invoke-virtual {v2, v5}, Landroid/widget/TextView;->setVisibility(I)V

    .line 81
    invoke-virtual {p0, v6}, Lcom/brynk/fathom/controllers/WiFiSetupActivity;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/Button;

    .line 82
    .local v0, "btnNext":Landroid/widget/Button;
    invoke-virtual {v0, v5}, Landroid/widget/Button;->setVisibility(I)V

    .line 88
    .end local v0    # "btnNext":Landroid/widget/Button;
    .end local v1    # "progressBar":Landroid/widget/ProgressBar;
    .end local v2    # "tvConnected":Landroid/widget/TextView;
    :cond_0
    invoke-virtual {p0, v6}, Lcom/brynk/fathom/controllers/WiFiSetupActivity;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/Button;

    .line 90
    .restart local v0    # "btnNext":Landroid/widget/Button;
    return-void
.end method


# virtual methods
.method public goToNextStep(Landroid/view/View;)V
    .locals 2
    .param p1, "v"    # Landroid/view/View;

    .prologue
    .line 98
    new-instance v0, Landroid/content/Intent;

    const-class v1, Lcom/brynk/fathom/controllers/WifiSetupStep2Activity;

    invoke-direct {v0, p0, v1}, Landroid/content/Intent;-><init>(Landroid/content/Context;Ljava/lang/Class;)V

    invoke-virtual {p0, v0}, Lcom/brynk/fathom/controllers/WiFiSetupActivity;->startActivity(Landroid/content/Intent;)V

    .line 100
    return-void
.end method

.method protected onCreate(Landroid/os/Bundle;)V
    .locals 6
    .param p1, "savedInstanceState"    # Landroid/os/Bundle;

    .prologue
    .line 49
    invoke-super {p0, p1}, Landroid/support/v7/app/AppCompatActivity;->onCreate(Landroid/os/Bundle;)V

    .line 50
    const v3, 0x7f040023

    invoke-virtual {p0, v3}, Lcom/brynk/fathom/controllers/WiFiSetupActivity;->setContentView(I)V

    .line 52
    invoke-static {}, Ljava/util/concurrent/Executors;->newSingleThreadScheduledExecutor()Ljava/util/concurrent/ScheduledExecutorService;

    move-result-object v0

    .line 53
    .local v0, "exec":Ljava/util/concurrent/ScheduledExecutorService;
    invoke-virtual {p0}, Lcom/brynk/fathom/controllers/WiFiSetupActivity;->getWindow()Landroid/view/Window;

    move-result-object v3

    invoke-virtual {v3}, Landroid/view/Window;->getDecorView()Landroid/view/View;

    move-result-object v3

    invoke-virtual {v3}, Landroid/view/View;->getRootView()Landroid/view/View;

    move-result-object v2

    .line 55
    .local v2, "rootView":Landroid/view/View;
    new-instance v1, Landroid/os/Handler;

    invoke-direct {v1}, Landroid/os/Handler;-><init>()V

    .line 56
    .local v1, "handler":Landroid/os/Handler;
    new-instance v3, Lcom/brynk/fathom/controllers/WiFiSetupActivity$1;

    invoke-direct {v3, p0}, Lcom/brynk/fathom/controllers/WiFiSetupActivity$1;-><init>(Lcom/brynk/fathom/controllers/WiFiSetupActivity;)V

    const-wide/16 v4, 0x3e8

    invoke-virtual {v1, v3, v4, v5}, Landroid/os/Handler;->postDelayed(Ljava/lang/Runnable;J)Z

    .line 67
    return-void
.end method

.method public onPause()V
    .locals 1

    .prologue
    const/4 v0, 0x0

    .line 93
    invoke-super {p0}, Landroid/support/v7/app/AppCompatActivity;->onPause()V

    .line 94
    invoke-virtual {p0, v0, v0}, Lcom/brynk/fathom/controllers/WiFiSetupActivity;->overridePendingTransition(II)V

    .line 95
    return-void
.end method

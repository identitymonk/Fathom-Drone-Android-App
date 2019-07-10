.class public Lcom/brynk/fathom/controllers/WifiSetupStep2Activity;
.super Landroid/support/v7/app/AppCompatActivity;
.source "WifiSetupStep2Activity.java"


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lcom/brynk/fathom/controllers/WifiSetupStep2Activity$ConnectionStatusTask;
    }
.end annotation


# instance fields
.field private DRONE_IP:Ljava/lang/String;

.field private connectedToFathomNetwork:Ljava/lang/Boolean;

.field private isConnected:Ljava/lang/Boolean;


# direct methods
.method public constructor <init>()V
    .locals 1

    .prologue
    .line 39
    invoke-direct {p0}, Landroid/support/v7/app/AppCompatActivity;-><init>()V

    .line 41
    const/4 v0, 0x0

    invoke-static {v0}, Ljava/lang/Boolean;->valueOf(Z)Ljava/lang/Boolean;

    move-result-object v0

    iput-object v0, p0, Lcom/brynk/fathom/controllers/WifiSetupStep2Activity;->connectedToFathomNetwork:Ljava/lang/Boolean;

    .line 97
    return-void
.end method

.method static synthetic access$000(Lcom/brynk/fathom/controllers/WifiSetupStep2Activity;)V
    .locals 0
    .param p0, "x0"    # Lcom/brynk/fathom/controllers/WifiSetupStep2Activity;

    .prologue
    .line 39
    invoke-direct {p0}, Lcom/brynk/fathom/controllers/WifiSetupStep2Activity;->checkWifiStatus()V

    return-void
.end method

.method static synthetic access$100(Lcom/brynk/fathom/controllers/WifiSetupStep2Activity;)Ljava/lang/Boolean;
    .locals 1
    .param p0, "x0"    # Lcom/brynk/fathom/controllers/WifiSetupStep2Activity;

    .prologue
    .line 39
    iget-object v0, p0, Lcom/brynk/fathom/controllers/WifiSetupStep2Activity;->connectedToFathomNetwork:Ljava/lang/Boolean;

    return-object v0
.end method

.method static synthetic access$200(Lcom/brynk/fathom/controllers/WifiSetupStep2Activity;)Ljava/lang/Boolean;
    .locals 1
    .param p0, "x0"    # Lcom/brynk/fathom/controllers/WifiSetupStep2Activity;

    .prologue
    .line 39
    iget-object v0, p0, Lcom/brynk/fathom/controllers/WifiSetupStep2Activity;->isConnected:Ljava/lang/Boolean;

    return-object v0
.end method

.method static synthetic access$202(Lcom/brynk/fathom/controllers/WifiSetupStep2Activity;Ljava/lang/Boolean;)Ljava/lang/Boolean;
    .locals 0
    .param p0, "x0"    # Lcom/brynk/fathom/controllers/WifiSetupStep2Activity;
    .param p1, "x1"    # Ljava/lang/Boolean;

    .prologue
    .line 39
    iput-object p1, p0, Lcom/brynk/fathom/controllers/WifiSetupStep2Activity;->isConnected:Ljava/lang/Boolean;

    return-object p1
.end method

.method private checkWifiStatus()V
    .locals 2

    .prologue
    .line 91
    new-instance v0, Lcom/brynk/fathom/helpers/WiFiHelper;

    invoke-direct {v0}, Lcom/brynk/fathom/helpers/WiFiHelper;-><init>()V

    invoke-virtual {p0}, Lcom/brynk/fathom/controllers/WifiSetupStep2Activity;->getApplicationContext()Landroid/content/Context;

    move-result-object v1

    invoke-virtual {v0, v1}, Lcom/brynk/fathom/helpers/WiFiHelper;->isConnectedToFathomNetwork(Landroid/content/Context;)Z

    move-result v0

    if-eqz v0, :cond_0

    .line 92
    const/4 v0, 0x1

    invoke-static {v0}, Ljava/lang/Boolean;->valueOf(Z)Ljava/lang/Boolean;

    move-result-object v0

    iput-object v0, p0, Lcom/brynk/fathom/controllers/WifiSetupStep2Activity;->connectedToFathomNetwork:Ljava/lang/Boolean;

    .line 95
    :cond_0
    return-void
.end method


# virtual methods
.method public goToNextStep(Landroid/view/View;)V
    .locals 2
    .param p1, "v"    # Landroid/view/View;

    .prologue
    .line 85
    new-instance v0, Landroid/content/Intent;

    const-class v1, Lcom/brynk/fathom/controllers/WifiSetupStep3Activity;

    invoke-direct {v0, p0, v1}, Landroid/content/Intent;-><init>(Landroid/content/Context;Ljava/lang/Class;)V

    invoke-virtual {p0, v0}, Lcom/brynk/fathom/controllers/WifiSetupStep2Activity;->startActivity(Landroid/content/Intent;)V

    .line 87
    return-void
.end method

.method protected onCreate(Landroid/os/Bundle;)V
    .locals 6
    .param p1, "savedInstanceState"    # Landroid/os/Bundle;

    .prologue
    .line 46
    invoke-super {p0, p1}, Landroid/support/v7/app/AppCompatActivity;->onCreate(Landroid/os/Bundle;)V

    .line 47
    const v3, 0x7f040025

    invoke-virtual {p0, v3}, Lcom/brynk/fathom/controllers/WifiSetupStep2Activity;->setContentView(I)V

    .line 48
    new-instance v3, Lcom/brynk/fathom/helpers/Constants;

    invoke-direct {v3}, Lcom/brynk/fathom/helpers/Constants;-><init>()V

    invoke-virtual {p0}, Lcom/brynk/fathom/controllers/WifiSetupStep2Activity;->getApplicationContext()Landroid/content/Context;

    move-result-object v4

    invoke-virtual {v3, v4}, Lcom/brynk/fathom/helpers/Constants;->getDroneIp(Landroid/content/Context;)Ljava/lang/String;

    move-result-object v3

    iput-object v3, p0, Lcom/brynk/fathom/controllers/WifiSetupStep2Activity;->DRONE_IP:Ljava/lang/String;

    .line 50
    invoke-static {}, Ljava/util/concurrent/Executors;->newSingleThreadScheduledExecutor()Ljava/util/concurrent/ScheduledExecutorService;

    move-result-object v0

    .line 51
    .local v0, "exec":Ljava/util/concurrent/ScheduledExecutorService;
    invoke-virtual {p0}, Lcom/brynk/fathom/controllers/WifiSetupStep2Activity;->getWindow()Landroid/view/Window;

    move-result-object v3

    invoke-virtual {v3}, Landroid/view/Window;->getDecorView()Landroid/view/View;

    move-result-object v3

    invoke-virtual {v3}, Landroid/view/View;->getRootView()Landroid/view/View;

    move-result-object v2

    .line 54
    .local v2, "rootView":Landroid/view/View;
    new-instance v1, Landroid/os/Handler;

    invoke-direct {v1}, Landroid/os/Handler;-><init>()V

    .line 55
    .local v1, "handler":Landroid/os/Handler;
    new-instance v3, Lcom/brynk/fathom/controllers/WifiSetupStep2Activity$1;

    invoke-direct {v3, p0}, Lcom/brynk/fathom/controllers/WifiSetupStep2Activity$1;-><init>(Lcom/brynk/fathom/controllers/WifiSetupStep2Activity;)V

    const-wide/16 v4, 0x3e8

    invoke-virtual {v1, v3, v4, v5}, Landroid/os/Handler;->postDelayed(Ljava/lang/Runnable;J)Z

    .line 81
    return-void
.end method

.class public Lcom/brynk/fathom/controllers/WifiSetupStep3Activity;
.super Landroid/support/v7/app/AppCompatActivity;
.source "WifiSetupStep3Activity.java"


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lcom/brynk/fathom/controllers/WifiSetupStep3Activity$NetworkConnectedTask;,
        Lcom/brynk/fathom/controllers/WifiSetupStep3Activity$NetworkConnectTask;,
        Lcom/brynk/fathom/controllers/WifiSetupStep3Activity$NetworkTask;
    }
.end annotation


# instance fields
.field private DRONE_IP:Ljava/lang/String;

.field private result_from_api:Ljava/lang/String;

.field private selected_network:Ljava/lang/String;

.field private selected_network_password:Ljava/lang/String;


# direct methods
.method public constructor <init>()V
    .locals 1

    .prologue
    .line 34
    invoke-direct {p0}, Landroid/support/v7/app/AppCompatActivity;-><init>()V

    .line 37
    const-string v0, ""

    iput-object v0, p0, Lcom/brynk/fathom/controllers/WifiSetupStep3Activity;->selected_network:Ljava/lang/String;

    .line 38
    const-string v0, ""

    iput-object v0, p0, Lcom/brynk/fathom/controllers/WifiSetupStep3Activity;->selected_network_password:Ljava/lang/String;

    .line 253
    return-void
.end method

.method static synthetic access$200(Lcom/brynk/fathom/controllers/WifiSetupStep3Activity;)Ljava/lang/String;
    .locals 1
    .param p0, "x0"    # Lcom/brynk/fathom/controllers/WifiSetupStep3Activity;

    .prologue
    .line 34
    iget-object v0, p0, Lcom/brynk/fathom/controllers/WifiSetupStep3Activity;->DRONE_IP:Ljava/lang/String;

    return-object v0
.end method

.method static synthetic access$300(Lcom/brynk/fathom/controllers/WifiSetupStep3Activity;)Ljava/lang/String;
    .locals 1
    .param p0, "x0"    # Lcom/brynk/fathom/controllers/WifiSetupStep3Activity;

    .prologue
    .line 34
    iget-object v0, p0, Lcom/brynk/fathom/controllers/WifiSetupStep3Activity;->result_from_api:Ljava/lang/String;

    return-object v0
.end method

.method static synthetic access$302(Lcom/brynk/fathom/controllers/WifiSetupStep3Activity;Ljava/lang/String;)Ljava/lang/String;
    .locals 0
    .param p0, "x0"    # Lcom/brynk/fathom/controllers/WifiSetupStep3Activity;
    .param p1, "x1"    # Ljava/lang/String;

    .prologue
    .line 34
    iput-object p1, p0, Lcom/brynk/fathom/controllers/WifiSetupStep3Activity;->result_from_api:Ljava/lang/String;

    return-object p1
.end method

.method static synthetic access$400(Lcom/brynk/fathom/controllers/WifiSetupStep3Activity;)Ljava/lang/String;
    .locals 1
    .param p0, "x0"    # Lcom/brynk/fathom/controllers/WifiSetupStep3Activity;

    .prologue
    .line 34
    iget-object v0, p0, Lcom/brynk/fathom/controllers/WifiSetupStep3Activity;->selected_network:Ljava/lang/String;

    return-object v0
.end method

.method static synthetic access$402(Lcom/brynk/fathom/controllers/WifiSetupStep3Activity;Ljava/lang/String;)Ljava/lang/String;
    .locals 0
    .param p0, "x0"    # Lcom/brynk/fathom/controllers/WifiSetupStep3Activity;
    .param p1, "x1"    # Ljava/lang/String;

    .prologue
    .line 34
    iput-object p1, p0, Lcom/brynk/fathom/controllers/WifiSetupStep3Activity;->selected_network:Ljava/lang/String;

    return-object p1
.end method

.method static synthetic access$500(Lcom/brynk/fathom/controllers/WifiSetupStep3Activity;)Ljava/lang/String;
    .locals 1
    .param p0, "x0"    # Lcom/brynk/fathom/controllers/WifiSetupStep3Activity;

    .prologue
    .line 34
    iget-object v0, p0, Lcom/brynk/fathom/controllers/WifiSetupStep3Activity;->selected_network_password:Ljava/lang/String;

    return-object v0
.end method


# virtual methods
.method public connectToWifi(Landroid/view/View;)V
    .locals 5
    .param p1, "v"    # Landroid/view/View;

    .prologue
    .line 53
    const v2, 0x7f0f00d8

    invoke-virtual {p0, v2}, Lcom/brynk/fathom/controllers/WifiSetupStep3Activity;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/EditText;

    .line 54
    .local v0, "etWifiPassword":Landroid/widget/EditText;
    invoke-virtual {v0}, Landroid/widget/EditText;->getText()Landroid/text/Editable;

    move-result-object v2

    invoke-virtual {v2}, Ljava/lang/Object;->toString()Ljava/lang/String;

    move-result-object v2

    iput-object v2, p0, Lcom/brynk/fathom/controllers/WifiSetupStep3Activity;->selected_network_password:Ljava/lang/String;

    .line 56
    const-string v2, "FATHOM1"

    const-string v3, "Adding network..."

    invoke-static {v2, v3}, Landroid/util/Log;->d(Ljava/lang/String;Ljava/lang/String;)I

    .line 57
    new-instance v1, Lcom/brynk/fathom/controllers/WifiSetupStep3Activity$NetworkConnectTask;

    const/4 v2, 0x0

    invoke-direct {v1, p0, v2}, Lcom/brynk/fathom/controllers/WifiSetupStep3Activity$NetworkConnectTask;-><init>(Lcom/brynk/fathom/controllers/WifiSetupStep3Activity;Lcom/brynk/fathom/controllers/WifiSetupStep3Activity$1;)V

    .line 58
    .local v1, "networkConnectTask":Lcom/brynk/fathom/controllers/WifiSetupStep3Activity$NetworkConnectTask;
    const/4 v2, 0x1

    new-array v2, v2, [Ljava/lang/String;

    const/4 v3, 0x0

    const-string v4, ""

    aput-object v4, v2, v3

    invoke-virtual {v1, v2}, Lcom/brynk/fathom/controllers/WifiSetupStep3Activity$NetworkConnectTask;->execute([Ljava/lang/Object;)Landroid/os/AsyncTask;

    .line 60
    return-void
.end method

.method public goToFirmwareScreen(Landroid/view/View;)V
    .locals 2
    .param p1, "v"    # Landroid/view/View;

    .prologue
    .line 63
    new-instance v0, Landroid/content/Intent;

    const-class v1, Lcom/brynk/fathom/controllers/FirmwareActivity;

    invoke-direct {v0, p0, v1}, Landroid/content/Intent;-><init>(Landroid/content/Context;Ljava/lang/Class;)V

    invoke-virtual {p0, v0}, Lcom/brynk/fathom/controllers/WifiSetupStep3Activity;->startActivity(Landroid/content/Intent;)V

    .line 65
    return-void
.end method

.method protected onCreate(Landroid/os/Bundle;)V
    .locals 2
    .param p1, "savedInstanceState"    # Landroid/os/Bundle;

    .prologue
    .line 42
    invoke-super {p0, p1}, Landroid/support/v7/app/AppCompatActivity;->onCreate(Landroid/os/Bundle;)V

    .line 43
    const v0, 0x7f040026

    invoke-virtual {p0, v0}, Lcom/brynk/fathom/controllers/WifiSetupStep3Activity;->setContentView(I)V

    .line 44
    new-instance v0, Lcom/brynk/fathom/helpers/Constants;

    invoke-direct {v0}, Lcom/brynk/fathom/helpers/Constants;-><init>()V

    invoke-virtual {p0}, Lcom/brynk/fathom/controllers/WifiSetupStep3Activity;->getApplicationContext()Landroid/content/Context;

    move-result-object v1

    invoke-virtual {v0, v1}, Lcom/brynk/fathom/helpers/Constants;->getDroneIp(Landroid/content/Context;)Ljava/lang/String;

    move-result-object v0

    iput-object v0, p0, Lcom/brynk/fathom/controllers/WifiSetupStep3Activity;->DRONE_IP:Ljava/lang/String;

    .line 49
    return-void
.end method

.method public turnOnWifi(Landroid/view/View;)V
    .locals 5
    .param p1, "v"    # Landroid/view/View;

    .prologue
    const/4 v4, 0x1

    .line 69
    invoke-virtual {p0}, Lcom/brynk/fathom/controllers/WifiSetupStep3Activity;->getApplicationContext()Landroid/content/Context;

    move-result-object v2

    const-string v3, "Turning on WiFi"

    invoke-static {v2, v3, v4}, Landroid/widget/Toast;->makeText(Landroid/content/Context;Ljava/lang/CharSequence;I)Landroid/widget/Toast;

    move-result-object v1

    .line 70
    .local v1, "toast":Landroid/widget/Toast;
    invoke-virtual {v1}, Landroid/widget/Toast;->show()V

    .line 71
    new-instance v0, Lcom/brynk/fathom/controllers/WifiSetupStep3Activity$NetworkTask;

    const/4 v2, 0x0

    invoke-direct {v0, p0, v2}, Lcom/brynk/fathom/controllers/WifiSetupStep3Activity$NetworkTask;-><init>(Lcom/brynk/fathom/controllers/WifiSetupStep3Activity;Lcom/brynk/fathom/controllers/WifiSetupStep3Activity$1;)V

    .line 72
    .local v0, "networkTask":Lcom/brynk/fathom/controllers/WifiSetupStep3Activity$NetworkTask;
    new-array v2, v4, [Ljava/lang/String;

    const/4 v3, 0x0

    const-string v4, ""

    aput-object v4, v2, v3

    invoke-virtual {v0, v2}, Lcom/brynk/fathom/controllers/WifiSetupStep3Activity$NetworkTask;->execute([Ljava/lang/Object;)Landroid/os/AsyncTask;

    .line 74
    return-void
.end method

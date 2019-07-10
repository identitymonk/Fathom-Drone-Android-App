.class public Lcom/brynk/fathom/controllers/WifiActivity;
.super Landroid/support/v7/app/AppCompatActivity;
.source "WifiActivity.java"


# direct methods
.method public constructor <init>()V
    .locals 0

    .prologue
    .line 15
    invoke-direct {p0}, Landroid/support/v7/app/AppCompatActivity;-><init>()V

    return-void
.end method


# virtual methods
.method public goToMainScreen(Landroid/view/View;)V
    .locals 2
    .param p1, "v"    # Landroid/view/View;

    .prologue
    .line 40
    new-instance v0, Landroid/content/Intent;

    const-class v1, Lcom/brynk/fathom/controllers/LobbyActivity;

    invoke-direct {v0, p0, v1}, Landroid/content/Intent;-><init>(Landroid/content/Context;Ljava/lang/Class;)V

    invoke-virtual {p0, v0}, Lcom/brynk/fathom/controllers/WifiActivity;->startActivity(Landroid/content/Intent;)V

    .line 42
    return-void
.end method

.method public goToWifiScreen(Landroid/view/View;)V
    .locals 2
    .param p1, "v"    # Landroid/view/View;

    .prologue
    .line 44
    new-instance v0, Landroid/content/Intent;

    const-string v1, "android.settings.WIFI_SETTINGS"

    invoke-direct {v0, v1}, Landroid/content/Intent;-><init>(Ljava/lang/String;)V

    invoke-virtual {p0, v0}, Lcom/brynk/fathom/controllers/WifiActivity;->startActivity(Landroid/content/Intent;)V

    .line 45
    return-void
.end method

.method protected onCreate(Landroid/os/Bundle;)V
    .locals 4
    .param p1, "savedInstanceState"    # Landroid/os/Bundle;

    .prologue
    .line 19
    invoke-super {p0, p1}, Landroid/support/v7/app/AppCompatActivity;->onCreate(Landroid/os/Bundle;)V

    .line 20
    const v2, 0x7f040024

    invoke-virtual {p0, v2}, Lcom/brynk/fathom/controllers/WifiActivity;->setContentView(I)V

    .line 21
    const v2, 0x7f0f00d1

    invoke-virtual {p0, v2}, Lcom/brynk/fathom/controllers/WifiActivity;->findViewById(I)Landroid/view/View;

    move-result-object v1

    check-cast v1, Landroid/support/v7/widget/Toolbar;

    .line 22
    .local v1, "toolbar":Landroid/support/v7/widget/Toolbar;
    invoke-virtual {p0, v1}, Lcom/brynk/fathom/controllers/WifiActivity;->setSupportActionBar(Landroid/support/v7/widget/Toolbar;)V

    .line 24
    const v2, 0x7f0f00a3

    invoke-virtual {p0, v2}, Lcom/brynk/fathom/controllers/WifiActivity;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/support/design/widget/FloatingActionButton;

    .line 25
    .local v0, "fab":Landroid/support/design/widget/FloatingActionButton;
    new-instance v2, Lcom/brynk/fathom/controllers/WifiActivity$1;

    invoke-direct {v2, p0}, Lcom/brynk/fathom/controllers/WifiActivity$1;-><init>(Lcom/brynk/fathom/controllers/WifiActivity;)V

    invoke-virtual {v0, v2}, Landroid/support/design/widget/FloatingActionButton;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    .line 34
    new-instance v2, Lcom/brynk/fathom/helpers/WiFiHelper;

    invoke-direct {v2}, Lcom/brynk/fathom/helpers/WiFiHelper;-><init>()V

    invoke-virtual {p0}, Lcom/brynk/fathom/controllers/WifiActivity;->getApplicationContext()Landroid/content/Context;

    move-result-object v3

    invoke-virtual {v2, v3}, Lcom/brynk/fathom/helpers/WiFiHelper;->isConnectedToFathomNetwork(Landroid/content/Context;)Z

    move-result v2

    if-eqz v2, :cond_0

    .line 36
    new-instance v2, Landroid/content/Intent;

    const-class v3, Lcom/brynk/fathom/controllers/LobbyActivity;

    invoke-direct {v2, p0, v3}, Landroid/content/Intent;-><init>(Landroid/content/Context;Ljava/lang/Class;)V

    invoke-virtual {p0, v2}, Lcom/brynk/fathom/controllers/WifiActivity;->startActivity(Landroid/content/Intent;)V

    .line 38
    :cond_0
    return-void
.end method

.class public Lcom/brynk/fathom/controllers/LobbyActivity;
.super Landroid/support/v7/app/AppCompatActivity;
.source "LobbyActivity.java"


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lcom/brynk/fathom/controllers/LobbyActivity$ObserverTask;,
        Lcom/brynk/fathom/controllers/LobbyActivity$CameraTask;,
        Lcom/brynk/fathom/controllers/LobbyActivity$LatLongTask;,
        Lcom/brynk/fathom/controllers/LobbyActivity$ConnectionStatusTask;
    }
.end annotation


# static fields
.field private static final PERMISSION_REQUEST_COARSE_LOCATION:I = 0x1


# instance fields
.field private DRONE_IP:Ljava/lang/String;

.field private connectedToFathomNetwork:Ljava/lang/Boolean;

.field private exec:Ljava/util/concurrent/ScheduledExecutorService;

.field private isConnected:Ljava/lang/Boolean;

.field private phone_latitude:D

.field private phone_longitude:D


# direct methods
.method public constructor <init>()V
    .locals 3

    .prologue
    const/4 v2, 0x0

    const-wide/high16 v0, -0x4010000000000000L    # -1.0

    .line 44
    invoke-direct {p0}, Landroid/support/v7/app/AppCompatActivity;-><init>()V

    .line 46
    iput-wide v0, p0, Lcom/brynk/fathom/controllers/LobbyActivity;->phone_latitude:D

    .line 47
    iput-wide v0, p0, Lcom/brynk/fathom/controllers/LobbyActivity;->phone_longitude:D

    .line 49
    invoke-static {v2}, Ljava/lang/Boolean;->valueOf(Z)Ljava/lang/Boolean;

    move-result-object v0

    iput-object v0, p0, Lcom/brynk/fathom/controllers/LobbyActivity;->connectedToFathomNetwork:Ljava/lang/Boolean;

    .line 50
    invoke-static {v2}, Ljava/lang/Boolean;->valueOf(Z)Ljava/lang/Boolean;

    move-result-object v0

    iput-object v0, p0, Lcom/brynk/fathom/controllers/LobbyActivity;->isConnected:Ljava/lang/Boolean;

    .line 51
    const/4 v0, 0x0

    iput-object v0, p0, Lcom/brynk/fathom/controllers/LobbyActivity;->exec:Ljava/util/concurrent/ScheduledExecutorService;

    .line 540
    return-void
.end method

.method static synthetic access$000(Lcom/brynk/fathom/controllers/LobbyActivity;)Ljava/lang/String;
    .locals 1
    .param p0, "x0"    # Lcom/brynk/fathom/controllers/LobbyActivity;

    .prologue
    .line 44
    iget-object v0, p0, Lcom/brynk/fathom/controllers/LobbyActivity;->DRONE_IP:Ljava/lang/String;

    return-object v0
.end method

.method static synthetic access$100(Lcom/brynk/fathom/controllers/LobbyActivity;)V
    .locals 0
    .param p0, "x0"    # Lcom/brynk/fathom/controllers/LobbyActivity;

    .prologue
    .line 44
    invoke-direct {p0}, Lcom/brynk/fathom/controllers/LobbyActivity;->checkWifiStatus()V

    return-void
.end method

.method static synthetic access$200(Lcom/brynk/fathom/controllers/LobbyActivity;)Ljava/lang/Boolean;
    .locals 1
    .param p0, "x0"    # Lcom/brynk/fathom/controllers/LobbyActivity;

    .prologue
    .line 44
    iget-object v0, p0, Lcom/brynk/fathom/controllers/LobbyActivity;->connectedToFathomNetwork:Ljava/lang/Boolean;

    return-object v0
.end method

.method static synthetic access$300(Lcom/brynk/fathom/controllers/LobbyActivity;)Ljava/lang/Boolean;
    .locals 1
    .param p0, "x0"    # Lcom/brynk/fathom/controllers/LobbyActivity;

    .prologue
    .line 44
    iget-object v0, p0, Lcom/brynk/fathom/controllers/LobbyActivity;->isConnected:Ljava/lang/Boolean;

    return-object v0
.end method

.method static synthetic access$302(Lcom/brynk/fathom/controllers/LobbyActivity;Ljava/lang/Boolean;)Ljava/lang/Boolean;
    .locals 0
    .param p0, "x0"    # Lcom/brynk/fathom/controllers/LobbyActivity;
    .param p1, "x1"    # Ljava/lang/Boolean;

    .prologue
    .line 44
    iput-object p1, p0, Lcom/brynk/fathom/controllers/LobbyActivity;->isConnected:Ljava/lang/Boolean;

    return-object p1
.end method

.method private checkWifiStatus()V
    .locals 2

    .prologue
    .line 228
    new-instance v0, Lcom/brynk/fathom/helpers/WiFiHelper;

    invoke-direct {v0}, Lcom/brynk/fathom/helpers/WiFiHelper;-><init>()V

    invoke-virtual {p0}, Lcom/brynk/fathom/controllers/LobbyActivity;->getApplicationContext()Landroid/content/Context;

    move-result-object v1

    invoke-virtual {v0, v1}, Lcom/brynk/fathom/helpers/WiFiHelper;->isConnectedToFathomNetwork(Landroid/content/Context;)Z

    move-result v0

    if-eqz v0, :cond_0

    .line 229
    const/4 v0, 0x1

    invoke-static {v0}, Ljava/lang/Boolean;->valueOf(Z)Ljava/lang/Boolean;

    move-result-object v0

    iput-object v0, p0, Lcom/brynk/fathom/controllers/LobbyActivity;->connectedToFathomNetwork:Ljava/lang/Boolean;

    .line 232
    :cond_0
    return-void
.end method

.method private setLocation(Landroid/location/Location;)V
    .locals 2
    .param p1, "location"    # Landroid/location/Location;

    .prologue
    const-wide/high16 v0, -0x4010000000000000L    # -1.0

    .line 641
    if-eqz p1, :cond_0

    .line 642
    invoke-virtual {p1}, Landroid/location/Location;->getLongitude()D

    move-result-wide v0

    iput-wide v0, p0, Lcom/brynk/fathom/controllers/LobbyActivity;->phone_longitude:D

    .line 643
    invoke-virtual {p1}, Landroid/location/Location;->getLatitude()D

    move-result-wide v0

    iput-wide v0, p0, Lcom/brynk/fathom/controllers/LobbyActivity;->phone_latitude:D

    .line 649
    :goto_0
    return-void

    .line 645
    :cond_0
    iput-wide v0, p0, Lcom/brynk/fathom/controllers/LobbyActivity;->phone_longitude:D

    .line 646
    iput-wide v0, p0, Lcom/brynk/fathom/controllers/LobbyActivity;->phone_latitude:D

    goto :goto_0
.end method


# virtual methods
.method public goToCalibrateScreen(Landroid/view/View;)V
    .locals 2
    .param p1, "v"    # Landroid/view/View;

    .prologue
    .line 222
    new-instance v0, Landroid/content/Intent;

    const-class v1, Lcom/brynk/fathom/controllers/SettingsActivity;

    invoke-direct {v0, p0, v1}, Landroid/content/Intent;-><init>(Landroid/content/Context;Ljava/lang/Class;)V

    invoke-virtual {p0, v0}, Lcom/brynk/fathom/controllers/LobbyActivity;->startActivity(Landroid/content/Intent;)V

    .line 224
    return-void
.end method

.method public goToFlightRecordScreen(Landroid/view/View;)V
    .locals 2
    .param p1, "v"    # Landroid/view/View;

    .prologue
    .line 217
    new-instance v0, Landroid/content/Intent;

    const-class v1, Lcom/brynk/fathom/controllers/DivelogActivity;

    invoke-direct {v0, p0, v1}, Landroid/content/Intent;-><init>(Landroid/content/Context;Ljava/lang/Class;)V

    invoke-virtual {p0, v0}, Lcom/brynk/fathom/controllers/LobbyActivity;->startActivity(Landroid/content/Intent;)V

    .line 218
    return-void
.end method

.method public goToObserverScreen(Landroid/view/View;)V
    .locals 5
    .param p1, "v"    # Landroid/view/View;

    .prologue
    .line 195
    iget-object v2, p0, Lcom/brynk/fathom/controllers/LobbyActivity;->isConnected:Ljava/lang/Boolean;

    invoke-virtual {v2}, Ljava/lang/Boolean;->booleanValue()Z

    move-result v2

    if-nez v2, :cond_0

    .line 196
    invoke-virtual {p0}, Lcom/brynk/fathom/controllers/LobbyActivity;->getApplicationContext()Landroid/content/Context;

    move-result-object v2

    const-string v3, "Fathom One is offline."

    const/4 v4, 0x1

    invoke-static {v2, v3, v4}, Landroid/widget/Toast;->makeText(Landroid/content/Context;Ljava/lang/CharSequence;I)Landroid/widget/Toast;

    move-result-object v1

    .line 197
    .local v1, "toast":Landroid/widget/Toast;
    invoke-virtual {v1}, Landroid/widget/Toast;->show()V

    .line 214
    .end local v1    # "toast":Landroid/widget/Toast;
    :goto_0
    return-void

    .line 210
    :cond_0
    new-instance v0, Landroid/content/Intent;

    const-class v2, Lcom/brynk/fathom/controllers/ReactObserverActivity;

    invoke-direct {v0, p0, v2}, Landroid/content/Intent;-><init>(Landroid/content/Context;Ljava/lang/Class;)V

    .line 212
    .local v0, "i":Landroid/content/Intent;
    invoke-virtual {p0, v0}, Lcom/brynk/fathom/controllers/LobbyActivity;->startActivity(Landroid/content/Intent;)V

    goto :goto_0
.end method

.method public goToPilotScreen(Landroid/view/View;)V
    .locals 8
    .param p1, "v"    # Landroid/view/View;

    .prologue
    .line 171
    iget-object v3, p0, Lcom/brynk/fathom/controllers/LobbyActivity;->isConnected:Ljava/lang/Boolean;

    invoke-virtual {v3}, Ljava/lang/Boolean;->booleanValue()Z

    move-result v3

    if-nez v3, :cond_0

    .line 172
    invoke-virtual {p0}, Lcom/brynk/fathom/controllers/LobbyActivity;->getApplicationContext()Landroid/content/Context;

    move-result-object v3

    const-string v4, "Fathom One is offline."

    const/4 v5, 0x1

    invoke-static {v3, v4, v5}, Landroid/widget/Toast;->makeText(Landroid/content/Context;Ljava/lang/CharSequence;I)Landroid/widget/Toast;

    move-result-object v2

    .line 173
    .local v2, "toast":Landroid/widget/Toast;
    invoke-virtual {v2}, Landroid/widget/Toast;->show()V

    .line 179
    .end local v2    # "toast":Landroid/widget/Toast;
    :cond_0
    new-instance v0, Lcom/brynk/fathom/controllers/LobbyActivity$LatLongTask;

    iget-object v3, p0, Lcom/brynk/fathom/controllers/LobbyActivity;->DRONE_IP:Ljava/lang/String;

    invoke-virtual {p0}, Lcom/brynk/fathom/controllers/LobbyActivity;->getApplicationContext()Landroid/content/Context;

    move-result-object v4

    invoke-direct {v0, p0, v3, v4}, Lcom/brynk/fathom/controllers/LobbyActivity$LatLongTask;-><init>(Lcom/brynk/fathom/controllers/LobbyActivity;Ljava/lang/String;Landroid/content/Context;)V

    .line 180
    .local v0, "ct":Lcom/brynk/fathom/controllers/LobbyActivity$LatLongTask;
    iget-wide v4, p0, Lcom/brynk/fathom/controllers/LobbyActivity;->phone_longitude:D

    invoke-virtual {v0, v4, v5}, Lcom/brynk/fathom/controllers/LobbyActivity$LatLongTask;->setPhone_longitude(D)V

    .line 181
    iget-wide v4, p0, Lcom/brynk/fathom/controllers/LobbyActivity;->phone_latitude:D

    invoke-virtual {v0, v4, v5}, Lcom/brynk/fathom/controllers/LobbyActivity$LatLongTask;->setPhone_latitude(D)V

    .line 182
    const/4 v3, 0x0

    new-array v3, v3, [Ljava/lang/String;

    invoke-virtual {v0, v3}, Lcom/brynk/fathom/controllers/LobbyActivity$LatLongTask;->execute([Ljava/lang/Object;)Landroid/os/AsyncTask;

    .line 183
    new-instance v1, Landroid/content/Intent;

    const-class v3, Lcom/brynk/fathom/controllers/ReactActivity;

    invoke-direct {v1, p0, v3}, Landroid/content/Intent;-><init>(Landroid/content/Context;Ljava/lang/Class;)V

    .line 184
    .local v1, "i":Landroid/content/Intent;
    const-string v3, "PHONE_LATITUDE"

    new-instance v4, Ljava/lang/StringBuilder;

    invoke-direct {v4}, Ljava/lang/StringBuilder;-><init>()V

    const-string v5, ""

    invoke-virtual {v4, v5}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v4

    iget-wide v6, p0, Lcom/brynk/fathom/controllers/LobbyActivity;->phone_latitude:D

    invoke-virtual {v4, v6, v7}, Ljava/lang/StringBuilder;->append(D)Ljava/lang/StringBuilder;

    move-result-object v4

    invoke-virtual {v4}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v4

    invoke-virtual {v1, v3, v4}, Landroid/content/Intent;->putExtra(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;

    .line 185
    const-string v3, "PHONE_LONGITUDE"

    new-instance v4, Ljava/lang/StringBuilder;

    invoke-direct {v4}, Ljava/lang/StringBuilder;-><init>()V

    const-string v5, ""

    invoke-virtual {v4, v5}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v4

    iget-wide v6, p0, Lcom/brynk/fathom/controllers/LobbyActivity;->phone_longitude:D

    invoke-virtual {v4, v6, v7}, Ljava/lang/StringBuilder;->append(D)Ljava/lang/StringBuilder;

    move-result-object v4

    invoke-virtual {v4}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v4

    invoke-virtual {v1, v3, v4}, Landroid/content/Intent;->putExtra(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;

    .line 187
    invoke-virtual {p0, v1}, Lcom/brynk/fathom/controllers/LobbyActivity;->startActivity(Landroid/content/Intent;)V

    .line 190
    return-void
.end method

.method protected onCreate(Landroid/os/Bundle;)V
    .locals 9
    .param p1, "savedInstanceState"    # Landroid/os/Bundle;

    .prologue
    const/4 v8, 0x1

    .line 55
    invoke-super {p0, p1}, Landroid/support/v7/app/AppCompatActivity;->onCreate(Landroid/os/Bundle;)V

    .line 56
    const v5, 0x7f04001d

    invoke-virtual {p0, v5}, Lcom/brynk/fathom/controllers/LobbyActivity;->setContentView(I)V

    .line 58
    const v5, 0x7f0f00d1

    invoke-virtual {p0, v5}, Lcom/brynk/fathom/controllers/LobbyActivity;->findViewById(I)Landroid/view/View;

    move-result-object v4

    check-cast v4, Landroid/support/v7/widget/Toolbar;

    .line 59
    .local v4, "toolbar":Landroid/support/v7/widget/Toolbar;
    invoke-virtual {p0, v4}, Lcom/brynk/fathom/controllers/LobbyActivity;->setSupportActionBar(Landroid/support/v7/widget/Toolbar;)V

    .line 61
    new-instance v5, Lcom/brynk/fathom/helpers/Constants;

    invoke-direct {v5}, Lcom/brynk/fathom/helpers/Constants;-><init>()V

    invoke-virtual {p0}, Lcom/brynk/fathom/controllers/LobbyActivity;->getApplicationContext()Landroid/content/Context;

    move-result-object v6

    invoke-virtual {v5, v6}, Lcom/brynk/fathom/helpers/Constants;->getDroneIp(Landroid/content/Context;)Ljava/lang/String;

    move-result-object v5

    iput-object v5, p0, Lcom/brynk/fathom/controllers/LobbyActivity;->DRONE_IP:Ljava/lang/String;

    .line 63
    new-instance v5, Lcom/brynk/fathom/helpers/Constants;

    invoke-direct {v5}, Lcom/brynk/fathom/helpers/Constants;-><init>()V

    invoke-virtual {p0}, Lcom/brynk/fathom/controllers/LobbyActivity;->getApplicationContext()Landroid/content/Context;

    move-result-object v6

    invoke-virtual {v5, v6}, Lcom/brynk/fathom/helpers/Constants;->getMockDroneIp(Landroid/content/Context;)Ljava/lang/String;

    move-result-object v0

    .line 68
    .local v0, "MOCK_DRONE_IP":Ljava/lang/String;
    const-string v5, "FATHOM1"

    iget-object v6, p0, Lcom/brynk/fathom/controllers/LobbyActivity;->DRONE_IP:Ljava/lang/String;

    invoke-static {v5, v6}, Landroid/util/Log;->v(Ljava/lang/String;Ljava/lang/String;)I

    .line 70
    const v5, 0x7f0f00a3

    invoke-virtual {p0, v5}, Lcom/brynk/fathom/controllers/LobbyActivity;->findViewById(I)Landroid/view/View;

    move-result-object v1

    check-cast v1, Landroid/support/design/widget/FloatingActionButton;

    .line 71
    .local v1, "fab":Landroid/support/design/widget/FloatingActionButton;
    new-instance v5, Lcom/brynk/fathom/controllers/LobbyActivity$1;

    invoke-direct {v5, p0}, Lcom/brynk/fathom/controllers/LobbyActivity$1;-><init>(Lcom/brynk/fathom/controllers/LobbyActivity;)V

    invoke-virtual {v1, v5}, Landroid/support/design/widget/FloatingActionButton;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    .line 80
    sget v5, Landroid/os/Build$VERSION;->SDK_INT:I

    const/16 v6, 0x17

    if-lt v5, v6, :cond_1

    .line 81
    const-string v5, "android.permission.ACCESS_COARSE_LOCATION"

    invoke-virtual {p0, v5}, Lcom/brynk/fathom/controllers/LobbyActivity;->checkSelfPermission(Ljava/lang/String;)I

    move-result v5

    if-eqz v5, :cond_0

    .line 89
    new-array v5, v8, [Ljava/lang/String;

    const/4 v6, 0x0

    const-string v7, "android.permission.ACCESS_COARSE_LOCATION"

    aput-object v7, v5, v6

    invoke-static {p0, v5, v8}, Landroid/support/v4/app/ActivityCompat;->requestPermissions(Landroid/app/Activity;[Ljava/lang/String;I)V

    .line 117
    :goto_0
    return-void

    .line 98
    :cond_0
    invoke-virtual {p0}, Lcom/brynk/fathom/controllers/LobbyActivity;->getApplicationContext()Landroid/content/Context;

    const-string v5, "location"

    invoke-virtual {p0, v5}, Lcom/brynk/fathom/controllers/LobbyActivity;->getSystemService(Ljava/lang/String;)Ljava/lang/Object;

    move-result-object v2

    check-cast v2, Landroid/location/LocationManager;

    .line 99
    .local v2, "lm":Landroid/location/LocationManager;
    const-string v5, "gps"

    invoke-virtual {v2, v5}, Landroid/location/LocationManager;->getLastKnownLocation(Ljava/lang/String;)Landroid/location/Location;

    move-result-object v3

    .line 100
    .local v3, "location":Landroid/location/Location;
    invoke-direct {p0, v3}, Lcom/brynk/fathom/controllers/LobbyActivity;->setLocation(Landroid/location/Location;)V

    goto :goto_0

    .line 107
    .end local v2    # "lm":Landroid/location/LocationManager;
    .end local v3    # "location":Landroid/location/Location;
    :cond_1
    invoke-virtual {p0}, Lcom/brynk/fathom/controllers/LobbyActivity;->getApplicationContext()Landroid/content/Context;

    const-string v5, "location"

    invoke-virtual {p0, v5}, Lcom/brynk/fathom/controllers/LobbyActivity;->getSystemService(Ljava/lang/String;)Ljava/lang/Object;

    move-result-object v2

    check-cast v2, Landroid/location/LocationManager;

    .line 108
    .restart local v2    # "lm":Landroid/location/LocationManager;
    const-string v5, "gps"

    invoke-virtual {v2, v5}, Landroid/location/LocationManager;->getLastKnownLocation(Ljava/lang/String;)Landroid/location/Location;

    move-result-object v3

    .line 109
    .restart local v3    # "location":Landroid/location/Location;
    invoke-direct {p0, v3}, Lcom/brynk/fathom/controllers/LobbyActivity;->setLocation(Landroid/location/Location;)V

    goto :goto_0
.end method

.method public onPause()V
    .locals 1

    .prologue
    .line 135
    invoke-super {p0}, Landroid/support/v7/app/AppCompatActivity;->onPause()V

    .line 136
    iget-object v0, p0, Lcom/brynk/fathom/controllers/LobbyActivity;->exec:Ljava/util/concurrent/ScheduledExecutorService;

    invoke-interface {v0}, Ljava/util/concurrent/ScheduledExecutorService;->shutdownNow()Ljava/util/List;

    .line 138
    return-void
.end method

.method public onRequestPermissionsResult(I[Ljava/lang/String;[I)V
    .locals 5
    .param p1, "requestCode"    # I
    .param p2, "permissions"    # [Ljava/lang/String;
    .param p3, "grantResults"    # [I

    .prologue
    .line 141
    packed-switch p1, :pswitch_data_0

    .line 166
    :goto_0
    return-void

    .line 143
    :pswitch_0
    const/4 v3, 0x0

    aget v3, p3, v3

    if-nez v3, :cond_0

    const-string v3, "android.permission.ACCESS_COARSE_LOCATION"

    invoke-static {p0, v3}, Landroid/support/v4/app/ActivityCompat;->checkSelfPermission(Landroid/content/Context;Ljava/lang/String;)I

    move-result v3

    if-eqz v3, :cond_0

    .line 144
    const-string v3, "FATHOM1"

    const-string v4, "coarse location permission granted"

    invoke-static {v3, v4}, Landroid/util/Log;->d(Ljava/lang/String;Ljava/lang/String;)I

    .line 146
    invoke-virtual {p0}, Lcom/brynk/fathom/controllers/LobbyActivity;->getApplicationContext()Landroid/content/Context;

    const-string v3, "location"

    invoke-virtual {p0, v3}, Lcom/brynk/fathom/controllers/LobbyActivity;->getSystemService(Ljava/lang/String;)Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Landroid/location/LocationManager;

    .line 147
    .local v1, "lm":Landroid/location/LocationManager;
    const-string v3, "gps"

    invoke-virtual {v1, v3}, Landroid/location/LocationManager;->getLastKnownLocation(Ljava/lang/String;)Landroid/location/Location;

    move-result-object v2

    .line 148
    .local v2, "location":Landroid/location/Location;
    invoke-direct {p0, v2}, Lcom/brynk/fathom/controllers/LobbyActivity;->setLocation(Landroid/location/Location;)V

    goto :goto_0

    .line 150
    .end local v1    # "lm":Landroid/location/LocationManager;
    .end local v2    # "location":Landroid/location/Location;
    :cond_0
    new-instance v0, Landroid/app/AlertDialog$Builder;

    invoke-direct {v0, p0}, Landroid/app/AlertDialog$Builder;-><init>(Landroid/content/Context;)V

    .line 151
    .local v0, "builder":Landroid/app/AlertDialog$Builder;
    const-string v3, "Functionality limited"

    invoke-virtual {v0, v3}, Landroid/app/AlertDialog$Builder;->setTitle(Ljava/lang/CharSequence;)Landroid/app/AlertDialog$Builder;

    .line 152
    const-string v3, "Since location access has not been granted, this app will not be able to discover beacons when in the background."

    invoke-virtual {v0, v3}, Landroid/app/AlertDialog$Builder;->setMessage(Ljava/lang/CharSequence;)Landroid/app/AlertDialog$Builder;

    .line 153
    const v3, 0x104000a

    const/4 v4, 0x0

    invoke-virtual {v0, v3, v4}, Landroid/app/AlertDialog$Builder;->setPositiveButton(ILandroid/content/DialogInterface$OnClickListener;)Landroid/app/AlertDialog$Builder;

    .line 154
    new-instance v3, Lcom/brynk/fathom/controllers/LobbyActivity$3;

    invoke-direct {v3, p0}, Lcom/brynk/fathom/controllers/LobbyActivity$3;-><init>(Lcom/brynk/fathom/controllers/LobbyActivity;)V

    invoke-virtual {v0, v3}, Landroid/app/AlertDialog$Builder;->setOnDismissListener(Landroid/content/DialogInterface$OnDismissListener;)Landroid/app/AlertDialog$Builder;

    .line 161
    invoke-virtual {v0}, Landroid/app/AlertDialog$Builder;->show()Landroid/app/AlertDialog;

    goto :goto_0

    .line 141
    nop

    :pswitch_data_0
    .packed-switch 0x1
        :pswitch_0
    .end packed-switch
.end method

.method public onStart()V
    .locals 8

    .prologue
    .line 121
    invoke-super {p0}, Landroid/support/v7/app/AppCompatActivity;->onStart()V

    .line 122
    invoke-static {}, Ljava/util/concurrent/Executors;->newSingleThreadScheduledExecutor()Ljava/util/concurrent/ScheduledExecutorService;

    move-result-object v0

    iput-object v0, p0, Lcom/brynk/fathom/controllers/LobbyActivity;->exec:Ljava/util/concurrent/ScheduledExecutorService;

    .line 123
    invoke-virtual {p0}, Lcom/brynk/fathom/controllers/LobbyActivity;->getWindow()Landroid/view/Window;

    move-result-object v0

    invoke-virtual {v0}, Landroid/view/Window;->getDecorView()Landroid/view/View;

    move-result-object v0

    invoke-virtual {v0}, Landroid/view/View;->getRootView()Landroid/view/View;

    move-result-object v7

    .line 125
    .local v7, "rootView":Landroid/view/View;
    iget-object v0, p0, Lcom/brynk/fathom/controllers/LobbyActivity;->exec:Ljava/util/concurrent/ScheduledExecutorService;

    new-instance v1, Lcom/brynk/fathom/controllers/LobbyActivity$2;

    invoke-direct {v1, p0}, Lcom/brynk/fathom/controllers/LobbyActivity$2;-><init>(Lcom/brynk/fathom/controllers/LobbyActivity;)V

    const-wide/16 v2, 0x0

    const-wide/16 v4, 0x3

    sget-object v6, Ljava/util/concurrent/TimeUnit;->SECONDS:Ljava/util/concurrent/TimeUnit;

    invoke-interface/range {v0 .. v6}, Ljava/util/concurrent/ScheduledExecutorService;->scheduleAtFixedRate(Ljava/lang/Runnable;JJLjava/util/concurrent/TimeUnit;)Ljava/util/concurrent/ScheduledFuture;

    .line 132
    return-void
.end method

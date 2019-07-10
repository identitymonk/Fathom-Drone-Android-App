.class public Lcom/brynk/fathom/helpers/WiFiHelper;
.super Ljava/lang/Object;
.source "WiFiHelper.java"


# instance fields
.field private NETWORK_NAME:Ljava/lang/String;

.field private TEST_NETWORK_NAME:Ljava/lang/String;

.field private TEST_NETWORK_NAME_TWO:Ljava/lang/String;


# direct methods
.method public constructor <init>()V
    .locals 1

    .prologue
    .line 17
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 19
    const-string v0, "Fathom"

    iput-object v0, p0, Lcom/brynk/fathom/helpers/WiFiHelper;->NETWORK_NAME:Ljava/lang/String;

    .line 20
    const-string v0, "ALFA"

    iput-object v0, p0, Lcom/brynk/fathom/helpers/WiFiHelper;->TEST_NETWORK_NAME:Ljava/lang/String;

    .line 21
    const-string v0, "GR Makers"

    iput-object v0, p0, Lcom/brynk/fathom/helpers/WiFiHelper;->TEST_NETWORK_NAME_TWO:Ljava/lang/String;

    return-void
.end method


# virtual methods
.method public calculateSignalStrength(Landroid/content/Context;)I
    .locals 5
    .param p1, "context"    # Landroid/content/Context;

    .prologue
    .line 80
    const-string v4, "wifi"

    invoke-virtual {p1, v4}, Landroid/content/Context;->getSystemService(Ljava/lang/String;)Ljava/lang/Object;

    move-result-object v3

    check-cast v3, Landroid/net/wifi/WifiManager;

    .line 81
    .local v3, "wifiManager":Landroid/net/wifi/WifiManager;
    const/16 v1, 0x64

    .line 82
    .local v1, "numberOfLevels":I
    invoke-virtual {v3}, Landroid/net/wifi/WifiManager;->getConnectionInfo()Landroid/net/wifi/WifiInfo;

    move-result-object v2

    .line 83
    .local v2, "wifiInfo":Landroid/net/wifi/WifiInfo;
    invoke-virtual {v2}, Landroid/net/wifi/WifiInfo;->getRssi()I

    move-result v4

    invoke-static {v4, v1}, Landroid/net/wifi/WifiManager;->calculateSignalLevel(II)I

    move-result v0

    .line 84
    .local v0, "level":I
    return v0
.end method

.method public getIPAddress(Landroid/content/Context;)Ljava/lang/String;
    .locals 3
    .param p1, "context"    # Landroid/content/Context;

    .prologue
    .line 75
    const-string v2, "wifi"

    invoke-virtual {p1, v2}, Landroid/content/Context;->getSystemService(Ljava/lang/String;)Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Landroid/net/wifi/WifiManager;

    .line 76
    .local v1, "wm":Landroid/net/wifi/WifiManager;
    invoke-virtual {v1}, Landroid/net/wifi/WifiManager;->getConnectionInfo()Landroid/net/wifi/WifiInfo;

    move-result-object v2

    invoke-virtual {v2}, Landroid/net/wifi/WifiInfo;->getIpAddress()I

    move-result v2

    invoke-static {v2}, Landroid/text/format/Formatter;->formatIpAddress(I)Ljava/lang/String;

    move-result-object v0

    .line 77
    .local v0, "ip":Ljava/lang/String;
    return-object v0
.end method

.method public getWifiName(Landroid/content/Context;)Ljava/lang/String;
    .locals 7
    .param p1, "context"    # Landroid/content/Context;

    .prologue
    .line 24
    const/4 v3, 0x0

    .line 25
    .local v3, "ssid":Ljava/lang/String;
    const-string v5, "connectivity"

    invoke-virtual {p1, v5}, Landroid/content/Context;->getSystemService(Ljava/lang/String;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Landroid/net/ConnectivityManager;

    .line 26
    .local v0, "connManager":Landroid/net/ConnectivityManager;
    const/4 v5, 0x1

    invoke-virtual {v0, v5}, Landroid/net/ConnectivityManager;->getNetworkInfo(I)Landroid/net/NetworkInfo;

    move-result-object v2

    .line 27
    .local v2, "networkInfo":Landroid/net/NetworkInfo;
    invoke-virtual {v2}, Landroid/net/NetworkInfo;->isConnected()Z

    move-result v5

    if-eqz v5, :cond_0

    .line 28
    const-string v5, "wifi"

    invoke-virtual {p1, v5}, Landroid/content/Context;->getSystemService(Ljava/lang/String;)Ljava/lang/Object;

    move-result-object v4

    check-cast v4, Landroid/net/wifi/WifiManager;

    .line 29
    .local v4, "wifiManager":Landroid/net/wifi/WifiManager;
    invoke-virtual {v4}, Landroid/net/wifi/WifiManager;->getConnectionInfo()Landroid/net/wifi/WifiInfo;

    move-result-object v1

    .line 30
    .local v1, "connectionInfo":Landroid/net/wifi/WifiInfo;
    if-eqz v1, :cond_0

    invoke-virtual {v1}, Landroid/net/wifi/WifiInfo;->getSSID()Ljava/lang/String;

    move-result-object v5

    const-string v6, ""

    invoke-virtual {v5, v6}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v5

    if-nez v5, :cond_0

    .line 32
    invoke-virtual {v1}, Landroid/net/wifi/WifiInfo;->getSSID()Ljava/lang/String;

    move-result-object v3

    .line 61
    .end local v1    # "connectionInfo":Landroid/net/wifi/WifiInfo;
    .end local v4    # "wifiManager":Landroid/net/wifi/WifiManager;
    :cond_0
    return-object v3
.end method

.method public isConnectedToFathomNetwork(Landroid/content/Context;)Z
    .locals 3
    .param p1, "context"    # Landroid/content/Context;

    .prologue
    const/4 v1, 0x0

    .line 65
    invoke-virtual {p0, p1}, Lcom/brynk/fathom/helpers/WiFiHelper;->getWifiName(Landroid/content/Context;)Ljava/lang/String;

    move-result-object v0

    .line 66
    .local v0, "networkName":Ljava/lang/String;
    if-nez v0, :cond_1

    .line 71
    :cond_0
    :goto_0
    return v1

    :cond_1
    iget-object v2, p0, Lcom/brynk/fathom/helpers/WiFiHelper;->NETWORK_NAME:Ljava/lang/String;

    invoke-virtual {v0, v2}, Ljava/lang/String;->contains(Ljava/lang/CharSequence;)Z

    move-result v2

    if-nez v2, :cond_2

    iget-object v2, p0, Lcom/brynk/fathom/helpers/WiFiHelper;->TEST_NETWORK_NAME:Ljava/lang/String;

    invoke-virtual {v0, v2}, Ljava/lang/String;->contains(Ljava/lang/CharSequence;)Z

    move-result v2

    if-nez v2, :cond_2

    iget-object v2, p0, Lcom/brynk/fathom/helpers/WiFiHelper;->TEST_NETWORK_NAME_TWO:Ljava/lang/String;

    invoke-virtual {v0, v2}, Ljava/lang/String;->contains(Ljava/lang/CharSequence;)Z

    move-result v2

    if-nez v2, :cond_2

    const-string v2, "ATT7DJQpi2"

    invoke-virtual {v0, v2}, Ljava/lang/String;->contains(Ljava/lang/CharSequence;)Z

    move-result v2

    if-eqz v2, :cond_0

    :cond_2
    const/4 v1, 0x1

    goto :goto_0
.end method

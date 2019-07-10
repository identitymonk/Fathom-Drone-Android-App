.class public Lcom/facebook/react/modules/netinfo/NetInfoModule;
.super Lcom/facebook/react/bridge/ReactContextBaseJavaModule;
.source "NetInfoModule.java"

# interfaces
.implements Lcom/facebook/react/bridge/LifecycleEventListener;


# annotations
.annotation runtime Lcom/facebook/react/module/annotations/ReactModule;
    name = "NetInfo"
.end annotation

.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lcom/facebook/react/modules/netinfo/NetInfoModule$ConnectivityBroadcastReceiver;
    }
.end annotation


# static fields
.field private static final CONNECTION_TYPE_BLUETOOTH:Ljava/lang/String; = "bluetooth"

.field private static final CONNECTION_TYPE_CELLULAR:Ljava/lang/String; = "cellular"

.field private static final CONNECTION_TYPE_ETHERNET:Ljava/lang/String; = "ethernet"

.field private static final CONNECTION_TYPE_NONE:Ljava/lang/String; = "none"

.field private static final CONNECTION_TYPE_NONE_DEPRECATED:Ljava/lang/String; = "NONE"

.field private static final CONNECTION_TYPE_UNKNOWN:Ljava/lang/String; = "unknown"

.field private static final CONNECTION_TYPE_UNKNOWN_DEPRECATED:Ljava/lang/String; = "UNKNOWN"

.field private static final CONNECTION_TYPE_WIFI:Ljava/lang/String; = "wifi"

.field private static final CONNECTION_TYPE_WIMAX:Ljava/lang/String; = "wimax"

.field private static final EFFECTIVE_CONNECTION_TYPE_2G:Ljava/lang/String; = "2g"

.field private static final EFFECTIVE_CONNECTION_TYPE_3G:Ljava/lang/String; = "3g"

.field private static final EFFECTIVE_CONNECTION_TYPE_4G:Ljava/lang/String; = "4g"

.field private static final EFFECTIVE_CONNECTION_TYPE_UNKNOWN:Ljava/lang/String; = "unknown"

.field private static final ERROR_MISSING_PERMISSION:Ljava/lang/String; = "E_MISSING_PERMISSION"

.field private static final MISSING_PERMISSION_MESSAGE:Ljava/lang/String; = "To use NetInfo on Android, add the following to your AndroidManifest.xml:\n<uses-permission android:name=\"android.permission.ACCESS_NETWORK_STATE\" />"


# instance fields
.field private mConnectionType:Ljava/lang/String;

.field private final mConnectivityBroadcastReceiver:Lcom/facebook/react/modules/netinfo/NetInfoModule$ConnectivityBroadcastReceiver;

.field private mConnectivityDeprecated:Ljava/lang/String;

.field private final mConnectivityManager:Landroid/net/ConnectivityManager;

.field private mEffectiveConnectionType:Ljava/lang/String;

.field private mNoNetworkPermission:Z


# direct methods
.method public constructor <init>(Lcom/facebook/react/bridge/ReactApplicationContext;)V
    .locals 2
    .param p1, "reactContext"    # Lcom/facebook/react/bridge/ReactApplicationContext;

    .prologue
    .line 74
    invoke-direct {p0, p1}, Lcom/facebook/react/bridge/ReactContextBaseJavaModule;-><init>(Lcom/facebook/react/bridge/ReactApplicationContext;)V

    .line 67
    const/4 v0, 0x0

    iput-boolean v0, p0, Lcom/facebook/react/modules/netinfo/NetInfoModule;->mNoNetworkPermission:Z

    .line 69
    const-string v0, "UNKNOWN"

    iput-object v0, p0, Lcom/facebook/react/modules/netinfo/NetInfoModule;->mConnectivityDeprecated:Ljava/lang/String;

    .line 70
    const-string v0, "unknown"

    iput-object v0, p0, Lcom/facebook/react/modules/netinfo/NetInfoModule;->mConnectionType:Ljava/lang/String;

    .line 71
    const-string v0, "unknown"

    iput-object v0, p0, Lcom/facebook/react/modules/netinfo/NetInfoModule;->mEffectiveConnectionType:Ljava/lang/String;

    .line 75
    const-string v0, "connectivity"

    .line 76
    invoke-virtual {p1, v0}, Lcom/facebook/react/bridge/ReactApplicationContext;->getSystemService(Ljava/lang/String;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Landroid/net/ConnectivityManager;

    iput-object v0, p0, Lcom/facebook/react/modules/netinfo/NetInfoModule;->mConnectivityManager:Landroid/net/ConnectivityManager;

    .line 77
    new-instance v0, Lcom/facebook/react/modules/netinfo/NetInfoModule$ConnectivityBroadcastReceiver;

    const/4 v1, 0x0

    invoke-direct {v0, p0, v1}, Lcom/facebook/react/modules/netinfo/NetInfoModule$ConnectivityBroadcastReceiver;-><init>(Lcom/facebook/react/modules/netinfo/NetInfoModule;Lcom/facebook/react/modules/netinfo/NetInfoModule$1;)V

    iput-object v0, p0, Lcom/facebook/react/modules/netinfo/NetInfoModule;->mConnectivityBroadcastReceiver:Lcom/facebook/react/modules/netinfo/NetInfoModule$ConnectivityBroadcastReceiver;

    .line 78
    return-void
.end method

.method static synthetic access$100(Lcom/facebook/react/modules/netinfo/NetInfoModule;)V
    .locals 0
    .param p0, "x0"    # Lcom/facebook/react/modules/netinfo/NetInfoModule;

    .prologue
    .line 36
    invoke-direct {p0}, Lcom/facebook/react/modules/netinfo/NetInfoModule;->updateAndSendConnectionType()V

    return-void
.end method

.method private createConnectivityEventMap()Lcom/facebook/react/bridge/WritableMap;
    .locals 3

    .prologue
    .line 235
    new-instance v0, Lcom/facebook/react/bridge/WritableNativeMap;

    invoke-direct {v0}, Lcom/facebook/react/bridge/WritableNativeMap;-><init>()V

    .line 236
    .local v0, "event":Lcom/facebook/react/bridge/WritableMap;
    const-string v1, "network_info"

    iget-object v2, p0, Lcom/facebook/react/modules/netinfo/NetInfoModule;->mConnectivityDeprecated:Ljava/lang/String;

    invoke-interface {v0, v1, v2}, Lcom/facebook/react/bridge/WritableMap;->putString(Ljava/lang/String;Ljava/lang/String;)V

    .line 237
    const-string v1, "connectionType"

    iget-object v2, p0, Lcom/facebook/react/modules/netinfo/NetInfoModule;->mConnectionType:Ljava/lang/String;

    invoke-interface {v0, v1, v2}, Lcom/facebook/react/bridge/WritableMap;->putString(Ljava/lang/String;Ljava/lang/String;)V

    .line 238
    const-string v1, "effectiveConnectionType"

    iget-object v2, p0, Lcom/facebook/react/modules/netinfo/NetInfoModule;->mEffectiveConnectionType:Ljava/lang/String;

    invoke-interface {v0, v1, v2}, Lcom/facebook/react/bridge/WritableMap;->putString(Ljava/lang/String;Ljava/lang/String;)V

    .line 239
    return-object v0
.end method

.method private getCurrentConnectionType()Ljava/lang/String;
    .locals 3

    .prologue
    .line 189
    :try_start_0
    iget-object v2, p0, Lcom/facebook/react/modules/netinfo/NetInfoModule;->mConnectivityManager:Landroid/net/ConnectivityManager;

    invoke-virtual {v2}, Landroid/net/ConnectivityManager;->getActiveNetworkInfo()Landroid/net/NetworkInfo;

    move-result-object v1

    .line 190
    .local v1, "networkInfo":Landroid/net/NetworkInfo;
    if-eqz v1, :cond_0

    invoke-virtual {v1}, Landroid/net/NetworkInfo;->isConnected()Z

    move-result v2

    if-nez v2, :cond_1

    .line 191
    :cond_0
    const-string v2, "NONE"

    .line 199
    .end local v1    # "networkInfo":Landroid/net/NetworkInfo;
    :goto_0
    return-object v2

    .line 192
    .restart local v1    # "networkInfo":Landroid/net/NetworkInfo;
    :cond_1
    invoke-virtual {v1}, Landroid/net/NetworkInfo;->getType()I

    move-result v2

    invoke-static {v2}, Landroid/net/ConnectivityManager;->isNetworkTypeValid(I)Z

    move-result v2

    if-eqz v2, :cond_2

    .line 193
    invoke-virtual {v1}, Landroid/net/NetworkInfo;->getTypeName()Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v2}, Ljava/lang/String;->toUpperCase()Ljava/lang/String;

    move-result-object v2

    goto :goto_0

    .line 195
    :cond_2
    const-string v2, "UNKNOWN"
    :try_end_0
    .catch Ljava/lang/SecurityException; {:try_start_0 .. :try_end_0} :catch_0

    goto :goto_0

    .line 197
    .end local v1    # "networkInfo":Landroid/net/NetworkInfo;
    :catch_0
    move-exception v0

    .line 198
    .local v0, "e":Ljava/lang/SecurityException;
    const/4 v2, 0x1

    iput-boolean v2, p0, Lcom/facebook/react/modules/netinfo/NetInfoModule;->mNoNetworkPermission:Z

    .line 199
    const-string v2, "UNKNOWN"

    goto :goto_0
.end method

.method private getEffectiveConnectionType(Landroid/net/NetworkInfo;)Ljava/lang/String;
    .locals 1
    .param p1, "networkInfo"    # Landroid/net/NetworkInfo;

    .prologue
    .line 204
    invoke-virtual {p1}, Landroid/net/NetworkInfo;->getSubtype()I

    move-result v0

    packed-switch v0, :pswitch_data_0

    .line 225
    const-string v0, "unknown"

    :goto_0
    return-object v0

    .line 210
    :pswitch_0
    const-string v0, "2g"

    goto :goto_0

    .line 219
    :pswitch_1
    const-string v0, "3g"

    goto :goto_0

    .line 222
    :pswitch_2
    const-string v0, "4g"

    goto :goto_0

    .line 204
    nop

    :pswitch_data_0
    .packed-switch 0x1
        :pswitch_0
        :pswitch_0
        :pswitch_1
        :pswitch_0
        :pswitch_1
        :pswitch_1
        :pswitch_0
        :pswitch_1
        :pswitch_1
        :pswitch_1
        :pswitch_0
        :pswitch_1
        :pswitch_2
        :pswitch_1
        :pswitch_2
    .end packed-switch
.end method

.method private registerReceiver()V
    .locals 3

    .prologue
    .line 123
    new-instance v0, Landroid/content/IntentFilter;

    invoke-direct {v0}, Landroid/content/IntentFilter;-><init>()V

    .line 124
    .local v0, "filter":Landroid/content/IntentFilter;
    const-string v1, "android.net.conn.CONNECTIVITY_CHANGE"

    invoke-virtual {v0, v1}, Landroid/content/IntentFilter;->addAction(Ljava/lang/String;)V

    .line 125
    invoke-virtual {p0}, Lcom/facebook/react/modules/netinfo/NetInfoModule;->getReactApplicationContext()Lcom/facebook/react/bridge/ReactApplicationContext;

    move-result-object v1

    iget-object v2, p0, Lcom/facebook/react/modules/netinfo/NetInfoModule;->mConnectivityBroadcastReceiver:Lcom/facebook/react/modules/netinfo/NetInfoModule$ConnectivityBroadcastReceiver;

    invoke-virtual {v1, v2, v0}, Lcom/facebook/react/bridge/ReactApplicationContext;->registerReceiver(Landroid/content/BroadcastReceiver;Landroid/content/IntentFilter;)Landroid/content/Intent;

    .line 126
    iget-object v1, p0, Lcom/facebook/react/modules/netinfo/NetInfoModule;->mConnectivityBroadcastReceiver:Lcom/facebook/react/modules/netinfo/NetInfoModule$ConnectivityBroadcastReceiver;

    const/4 v2, 0x1

    invoke-virtual {v1, v2}, Lcom/facebook/react/modules/netinfo/NetInfoModule$ConnectivityBroadcastReceiver;->setRegistered(Z)V

    .line 127
    return-void
.end method

.method private sendConnectivityChangedEvent()V
    .locals 3

    .prologue
    .line 230
    invoke-virtual {p0}, Lcom/facebook/react/modules/netinfo/NetInfoModule;->getReactApplicationContext()Lcom/facebook/react/bridge/ReactApplicationContext;

    move-result-object v0

    const-class v1, Lcom/facebook/react/modules/core/DeviceEventManagerModule$RCTDeviceEventEmitter;

    invoke-virtual {v0, v1}, Lcom/facebook/react/bridge/ReactApplicationContext;->getJSModule(Ljava/lang/Class;)Lcom/facebook/react/bridge/JavaScriptModule;

    move-result-object v0

    check-cast v0, Lcom/facebook/react/modules/core/DeviceEventManagerModule$RCTDeviceEventEmitter;

    const-string v1, "networkStatusDidChange"

    .line 231
    invoke-direct {p0}, Lcom/facebook/react/modules/netinfo/NetInfoModule;->createConnectivityEventMap()Lcom/facebook/react/bridge/WritableMap;

    move-result-object v2

    invoke-interface {v0, v1, v2}, Lcom/facebook/react/modules/core/DeviceEventManagerModule$RCTDeviceEventEmitter;->emit(Ljava/lang/String;Ljava/lang/Object;)V

    .line 232
    return-void
.end method

.method private unregisterReceiver()V
    .locals 2

    .prologue
    .line 130
    iget-object v0, p0, Lcom/facebook/react/modules/netinfo/NetInfoModule;->mConnectivityBroadcastReceiver:Lcom/facebook/react/modules/netinfo/NetInfoModule$ConnectivityBroadcastReceiver;

    invoke-virtual {v0}, Lcom/facebook/react/modules/netinfo/NetInfoModule$ConnectivityBroadcastReceiver;->isRegistered()Z

    move-result v0

    if-eqz v0, :cond_0

    .line 131
    invoke-virtual {p0}, Lcom/facebook/react/modules/netinfo/NetInfoModule;->getReactApplicationContext()Lcom/facebook/react/bridge/ReactApplicationContext;

    move-result-object v0

    iget-object v1, p0, Lcom/facebook/react/modules/netinfo/NetInfoModule;->mConnectivityBroadcastReceiver:Lcom/facebook/react/modules/netinfo/NetInfoModule$ConnectivityBroadcastReceiver;

    invoke-virtual {v0, v1}, Lcom/facebook/react/bridge/ReactApplicationContext;->unregisterReceiver(Landroid/content/BroadcastReceiver;)V

    .line 132
    iget-object v0, p0, Lcom/facebook/react/modules/netinfo/NetInfoModule;->mConnectivityBroadcastReceiver:Lcom/facebook/react/modules/netinfo/NetInfoModule$ConnectivityBroadcastReceiver;

    const/4 v1, 0x0

    invoke-virtual {v0, v1}, Lcom/facebook/react/modules/netinfo/NetInfoModule$ConnectivityBroadcastReceiver;->setRegistered(Z)V

    .line 134
    :cond_0
    return-void
.end method

.method private updateAndSendConnectionType()V
    .locals 7

    .prologue
    .line 137
    const-string v0, "unknown"

    .line 138
    .local v0, "connectionType":Ljava/lang/String;
    const-string v3, "unknown"

    .line 141
    .local v3, "effectiveConnectionType":Ljava/lang/String;
    :try_start_0
    iget-object v6, p0, Lcom/facebook/react/modules/netinfo/NetInfoModule;->mConnectivityManager:Landroid/net/ConnectivityManager;

    invoke-virtual {v6}, Landroid/net/ConnectivityManager;->getActiveNetworkInfo()Landroid/net/NetworkInfo;

    move-result-object v4

    .line 142
    .local v4, "networkInfo":Landroid/net/NetworkInfo;
    if-eqz v4, :cond_0

    invoke-virtual {v4}, Landroid/net/NetworkInfo;->isConnected()Z

    move-result v6

    if-nez v6, :cond_3

    .line 143
    :cond_0
    const-string v0, "none"
    :try_end_0
    .catch Ljava/lang/SecurityException; {:try_start_0 .. :try_end_0} :catch_0

    .line 174
    .end local v4    # "networkInfo":Landroid/net/NetworkInfo;
    :goto_0
    invoke-direct {p0}, Lcom/facebook/react/modules/netinfo/NetInfoModule;->getCurrentConnectionType()Ljava/lang/String;

    move-result-object v1

    .line 177
    .local v1, "currentConnectivity":Ljava/lang/String;
    iget-object v6, p0, Lcom/facebook/react/modules/netinfo/NetInfoModule;->mConnectionType:Ljava/lang/String;

    invoke-virtual {v0, v6}, Ljava/lang/String;->equalsIgnoreCase(Ljava/lang/String;)Z

    move-result v6

    if-eqz v6, :cond_1

    iget-object v6, p0, Lcom/facebook/react/modules/netinfo/NetInfoModule;->mEffectiveConnectionType:Ljava/lang/String;

    .line 178
    invoke-virtual {v3, v6}, Ljava/lang/String;->equalsIgnoreCase(Ljava/lang/String;)Z

    move-result v6

    if-eqz v6, :cond_1

    iget-object v6, p0, Lcom/facebook/react/modules/netinfo/NetInfoModule;->mConnectivityDeprecated:Ljava/lang/String;

    .line 179
    invoke-virtual {v1, v6}, Ljava/lang/String;->equalsIgnoreCase(Ljava/lang/String;)Z

    move-result v6

    if-nez v6, :cond_2

    .line 180
    :cond_1
    iput-object v0, p0, Lcom/facebook/react/modules/netinfo/NetInfoModule;->mConnectionType:Ljava/lang/String;

    .line 181
    iput-object v3, p0, Lcom/facebook/react/modules/netinfo/NetInfoModule;->mEffectiveConnectionType:Ljava/lang/String;

    .line 182
    iput-object v1, p0, Lcom/facebook/react/modules/netinfo/NetInfoModule;->mConnectivityDeprecated:Ljava/lang/String;

    .line 183
    invoke-direct {p0}, Lcom/facebook/react/modules/netinfo/NetInfoModule;->sendConnectivityChangedEvent()V

    .line 185
    :cond_2
    return-void

    .line 145
    .end local v1    # "currentConnectivity":Ljava/lang/String;
    .restart local v4    # "networkInfo":Landroid/net/NetworkInfo;
    :cond_3
    :try_start_1
    invoke-virtual {v4}, Landroid/net/NetworkInfo;->getType()I

    move-result v5

    .line 146
    .local v5, "networkType":I
    packed-switch v5, :pswitch_data_0

    .line 165
    :pswitch_0
    const-string v0, "unknown"

    goto :goto_0

    .line 148
    :pswitch_1
    const-string v0, "bluetooth"

    .line 149
    goto :goto_0

    .line 151
    :pswitch_2
    const-string v0, "ethernet"

    .line 152
    goto :goto_0

    .line 155
    :pswitch_3
    const-string v0, "cellular"

    .line 156
    invoke-direct {p0, v4}, Lcom/facebook/react/modules/netinfo/NetInfoModule;->getEffectiveConnectionType(Landroid/net/NetworkInfo;)Ljava/lang/String;

    move-result-object v3

    .line 157
    goto :goto_0

    .line 159
    :pswitch_4
    const-string v0, "wifi"

    .line 160
    goto :goto_0

    .line 162
    :pswitch_5
    const-string v0, "wimax"
    :try_end_1
    .catch Ljava/lang/SecurityException; {:try_start_1 .. :try_end_1} :catch_0

    .line 163
    goto :goto_0

    .line 169
    .end local v4    # "networkInfo":Landroid/net/NetworkInfo;
    .end local v5    # "networkType":I
    :catch_0
    move-exception v2

    .line 170
    .local v2, "e":Ljava/lang/SecurityException;
    const/4 v6, 0x1

    iput-boolean v6, p0, Lcom/facebook/react/modules/netinfo/NetInfoModule;->mNoNetworkPermission:Z

    .line 171
    const-string v0, "unknown"

    goto :goto_0

    .line 146
    :pswitch_data_0
    .packed-switch 0x0
        :pswitch_3
        :pswitch_4
        :pswitch_0
        :pswitch_0
        :pswitch_3
        :pswitch_0
        :pswitch_5
        :pswitch_1
        :pswitch_0
        :pswitch_2
    .end packed-switch
.end method


# virtual methods
.method public getCurrentConnectivity(Lcom/facebook/react/bridge/Promise;)V
    .locals 3
    .param p1, "promise"    # Lcom/facebook/react/bridge/Promise;
    .annotation runtime Lcom/facebook/react/bridge/ReactMethod;
    .end annotation

    .prologue
    .line 106
    iget-boolean v0, p0, Lcom/facebook/react/modules/netinfo/NetInfoModule;->mNoNetworkPermission:Z

    if-eqz v0, :cond_0

    .line 107
    const-string v0, "E_MISSING_PERMISSION"

    const-string v1, "To use NetInfo on Android, add the following to your AndroidManifest.xml:\n<uses-permission android:name=\"android.permission.ACCESS_NETWORK_STATE\" />"

    const/4 v2, 0x0

    invoke-interface {p1, v0, v1, v2}, Lcom/facebook/react/bridge/Promise;->reject(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V

    .line 111
    :goto_0
    return-void

    .line 110
    :cond_0
    invoke-direct {p0}, Lcom/facebook/react/modules/netinfo/NetInfoModule;->createConnectivityEventMap()Lcom/facebook/react/bridge/WritableMap;

    move-result-object v0

    invoke-interface {p1, v0}, Lcom/facebook/react/bridge/Promise;->resolve(Ljava/lang/Object;)V

    goto :goto_0
.end method

.method public getName()Ljava/lang/String;
    .locals 1

    .prologue
    .line 101
    const-string v0, "NetInfo"

    return-object v0
.end method

.method public initialize()V
    .locals 1

    .prologue
    .line 96
    invoke-virtual {p0}, Lcom/facebook/react/modules/netinfo/NetInfoModule;->getReactApplicationContext()Lcom/facebook/react/bridge/ReactApplicationContext;

    move-result-object v0

    invoke-virtual {v0, p0}, Lcom/facebook/react/bridge/ReactApplicationContext;->addLifecycleEventListener(Lcom/facebook/react/bridge/LifecycleEventListener;)V

    .line 97
    return-void
.end method

.method public isConnectionMetered(Lcom/facebook/react/bridge/Promise;)V
    .locals 3
    .param p1, "promise"    # Lcom/facebook/react/bridge/Promise;
    .annotation runtime Lcom/facebook/react/bridge/ReactMethod;
    .end annotation

    .prologue
    .line 115
    iget-boolean v0, p0, Lcom/facebook/react/modules/netinfo/NetInfoModule;->mNoNetworkPermission:Z

    if-eqz v0, :cond_0

    .line 116
    const-string v0, "E_MISSING_PERMISSION"

    const-string v1, "To use NetInfo on Android, add the following to your AndroidManifest.xml:\n<uses-permission android:name=\"android.permission.ACCESS_NETWORK_STATE\" />"

    const/4 v2, 0x0

    invoke-interface {p1, v0, v1, v2}, Lcom/facebook/react/bridge/Promise;->reject(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V

    .line 120
    :goto_0
    return-void

    .line 119
    :cond_0
    iget-object v0, p0, Lcom/facebook/react/modules/netinfo/NetInfoModule;->mConnectivityManager:Landroid/net/ConnectivityManager;

    invoke-static {v0}, Landroid/support/v4/net/ConnectivityManagerCompat;->isActiveNetworkMetered(Landroid/net/ConnectivityManager;)Z

    move-result v0

    invoke-static {v0}, Ljava/lang/Boolean;->valueOf(Z)Ljava/lang/Boolean;

    move-result-object v0

    invoke-interface {p1, v0}, Lcom/facebook/react/bridge/Promise;->resolve(Ljava/lang/Object;)V

    goto :goto_0
.end method

.method public onHostDestroy()V
    .locals 0

    .prologue
    .line 92
    return-void
.end method

.method public onHostPause()V
    .locals 0

    .prologue
    .line 87
    invoke-direct {p0}, Lcom/facebook/react/modules/netinfo/NetInfoModule;->unregisterReceiver()V

    .line 88
    return-void
.end method

.method public onHostResume()V
    .locals 0

    .prologue
    .line 82
    invoke-direct {p0}, Lcom/facebook/react/modules/netinfo/NetInfoModule;->registerReceiver()V

    .line 83
    return-void
.end method

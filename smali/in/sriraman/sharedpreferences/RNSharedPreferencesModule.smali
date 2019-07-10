.class public Lin/sriraman/sharedpreferences/RNSharedPreferencesModule;
.super Lcom/facebook/react/bridge/ReactContextBaseJavaModule;
.source "RNSharedPreferencesModule.java"


# instance fields
.field final BT_ACTION_REQUEST_ENABLE:I

.field private bt_adapter:Landroid/bluetooth/BluetoothAdapter;

.field private bt_device_list:Ljava/util/ArrayList;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/ArrayList",
            "<",
            "Landroid/bluetooth/BluetoothDevice;",
            ">;"
        }
    .end annotation
.end field

.field private bt_info_receiver:Landroid/content/BroadcastReceiver;

.field private bt_list_view:Landroid/widget/ListView;

.field private bt_scanning:Z

.field private is_watch:Z


# direct methods
.method public constructor <init>(Lcom/facebook/react/bridge/ReactApplicationContext;)V
    .locals 3
    .param p1, "reactContext"    # Lcom/facebook/react/bridge/ReactApplicationContext;

    .prologue
    const/4 v2, 0x0

    const/4 v1, 0x0

    .line 75
    invoke-direct {p0, p1}, Lcom/facebook/react/bridge/ReactContextBaseJavaModule;-><init>(Lcom/facebook/react/bridge/ReactApplicationContext;)V

    .line 53
    const/4 v0, 0x1

    iput v0, p0, Lin/sriraman/sharedpreferences/RNSharedPreferencesModule;->BT_ACTION_REQUEST_ENABLE:I

    .line 55
    iput-object v1, p0, Lin/sriraman/sharedpreferences/RNSharedPreferencesModule;->bt_adapter:Landroid/bluetooth/BluetoothAdapter;

    .line 57
    iput-object v1, p0, Lin/sriraman/sharedpreferences/RNSharedPreferencesModule;->bt_device_list:Ljava/util/ArrayList;

    .line 58
    iput-boolean v2, p0, Lin/sriraman/sharedpreferences/RNSharedPreferencesModule;->bt_scanning:Z

    .line 59
    iput-boolean v2, p0, Lin/sriraman/sharedpreferences/RNSharedPreferencesModule;->is_watch:Z

    .line 61
    iput-object v1, p0, Lin/sriraman/sharedpreferences/RNSharedPreferencesModule;->bt_info_receiver:Landroid/content/BroadcastReceiver;

    .line 76
    return-void
.end method


# virtual methods
.method public clear()V
    .locals 1
    .annotation runtime Lcom/facebook/react/bridge/ReactMethod;
    .end annotation

    .prologue
    .line 161
    invoke-virtual {p0}, Lin/sriraman/sharedpreferences/RNSharedPreferencesModule;->getReactApplicationContext()Lcom/facebook/react/bridge/ReactApplicationContext;

    move-result-object v0

    invoke-static {v0}, Lin/sriraman/sharedpreferences/SharedHandler;->init(Landroid/content/Context;)V

    .line 162
    invoke-static {}, Lin/sriraman/sharedpreferences/SharedDataProvider;->clear()V

    .line 163
    return-void
.end method

.method public getAll(Lcom/facebook/react/bridge/Callback;)V
    .locals 7
    .param p1, "successCallback"    # Lcom/facebook/react/bridge/Callback;
    .annotation runtime Lcom/facebook/react/bridge/ReactMethod;
    .end annotation

    .prologue
    const/4 v6, 0x1

    const/4 v5, 0x0

    .line 122
    invoke-virtual {p0}, Lin/sriraman/sharedpreferences/RNSharedPreferencesModule;->getReactApplicationContext()Lcom/facebook/react/bridge/ReactApplicationContext;

    move-result-object v4

    invoke-static {v4}, Lin/sriraman/sharedpreferences/SharedHandler;->init(Landroid/content/Context;)V

    .line 123
    invoke-static {}, Lin/sriraman/sharedpreferences/SharedDataProvider;->getAllSharedValues()[[Ljava/lang/String;

    move-result-object v3

    .line 124
    .local v3, "values":[[Ljava/lang/String;
    new-instance v1, Lcom/facebook/react/bridge/WritableNativeArray;

    invoke-direct {v1}, Lcom/facebook/react/bridge/WritableNativeArray;-><init>()V

    .line 125
    .local v1, "data":Lcom/facebook/react/bridge/WritableNativeArray;
    const/4 v2, 0x0

    .local v2, "i":I
    :goto_0
    array-length v4, v3

    if-ge v2, v4, :cond_0

    .line 126
    new-instance v0, Lcom/facebook/react/bridge/WritableNativeArray;

    invoke-direct {v0}, Lcom/facebook/react/bridge/WritableNativeArray;-><init>()V

    .line 127
    .local v0, "arr":Lcom/facebook/react/bridge/WritableArray;
    aget-object v4, v3, v2

    aget-object v4, v4, v5

    invoke-interface {v0, v4}, Lcom/facebook/react/bridge/WritableArray;->pushString(Ljava/lang/String;)V

    .line 128
    aget-object v4, v3, v2

    aget-object v4, v4, v6

    invoke-interface {v0, v4}, Lcom/facebook/react/bridge/WritableArray;->pushString(Ljava/lang/String;)V

    .line 129
    invoke-virtual {v1, v0}, Lcom/facebook/react/bridge/WritableNativeArray;->pushArray(Lcom/facebook/react/bridge/WritableArray;)V

    .line 125
    add-int/lit8 v2, v2, 0x1

    goto :goto_0

    .line 131
    .end local v0    # "arr":Lcom/facebook/react/bridge/WritableArray;
    :cond_0
    new-array v4, v6, [Ljava/lang/Object;

    aput-object v1, v4, v5

    invoke-interface {p1, v4}, Lcom/facebook/react/bridge/Callback;->invoke([Ljava/lang/Object;)V

    .line 132
    return-void
.end method

.method public getAllKeys(Lcom/facebook/react/bridge/Callback;)V
    .locals 5
    .param p1, "successCallback"    # Lcom/facebook/react/bridge/Callback;
    .annotation runtime Lcom/facebook/react/bridge/ReactMethod;
    .end annotation

    .prologue
    .line 148
    invoke-virtual {p0}, Lin/sriraman/sharedpreferences/RNSharedPreferencesModule;->getReactApplicationContext()Lcom/facebook/react/bridge/ReactApplicationContext;

    move-result-object v3

    invoke-static {v3}, Lin/sriraman/sharedpreferences/SharedHandler;->init(Landroid/content/Context;)V

    .line 149
    invoke-static {}, Lin/sriraman/sharedpreferences/SharedDataProvider;->getAllKeys()[Ljava/lang/String;

    move-result-object v2

    .line 150
    .local v2, "keys":[Ljava/lang/String;
    new-instance v0, Lcom/facebook/react/bridge/WritableNativeArray;

    invoke-direct {v0}, Lcom/facebook/react/bridge/WritableNativeArray;-><init>()V

    .line 151
    .local v0, "data":Lcom/facebook/react/bridge/WritableNativeArray;
    const/4 v1, 0x0

    .local v1, "i":I
    :goto_0
    array-length v3, v2

    if-ge v1, v3, :cond_0

    .line 152
    aget-object v3, v2, v1

    invoke-virtual {v0, v3}, Lcom/facebook/react/bridge/WritableNativeArray;->pushString(Ljava/lang/String;)V

    .line 151
    add-int/lit8 v1, v1, 0x1

    goto :goto_0

    .line 154
    :cond_0
    const/4 v3, 0x1

    new-array v3, v3, [Ljava/lang/Object;

    const/4 v4, 0x0

    aput-object v0, v3, v4

    invoke-interface {p1, v3}, Lcom/facebook/react/bridge/Callback;->invoke([Ljava/lang/Object;)V

    .line 155
    return-void
.end method

.method public getItem(Ljava/lang/String;Lcom/facebook/react/bridge/Callback;)V
    .locals 3
    .param p1, "key"    # Ljava/lang/String;
    .param p2, "successCallback"    # Lcom/facebook/react/bridge/Callback;
    .annotation runtime Lcom/facebook/react/bridge/ReactMethod;
    .end annotation

    .prologue
    .line 95
    invoke-virtual {p0}, Lin/sriraman/sharedpreferences/RNSharedPreferencesModule;->getReactApplicationContext()Lcom/facebook/react/bridge/ReactApplicationContext;

    move-result-object v1

    invoke-static {v1}, Lin/sriraman/sharedpreferences/SharedHandler;->init(Landroid/content/Context;)V

    .line 96
    invoke-static {p1}, Lin/sriraman/sharedpreferences/SharedDataProvider;->getSharedValue(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    .line 97
    .local v0, "value":Ljava/lang/String;
    const/4 v1, 0x1

    new-array v1, v1, [Ljava/lang/Object;

    const/4 v2, 0x0

    aput-object v0, v1, v2

    invoke-interface {p2, v1}, Lcom/facebook/react/bridge/Callback;->invoke([Ljava/lang/Object;)V

    .line 99
    return-void
.end method

.method public getItems(Lcom/facebook/react/bridge/ReadableArray;Lcom/facebook/react/bridge/Callback;)V
    .locals 6
    .param p1, "keys"    # Lcom/facebook/react/bridge/ReadableArray;
    .param p2, "successCallback"    # Lcom/facebook/react/bridge/Callback;
    .annotation runtime Lcom/facebook/react/bridge/ReactMethod;
    .end annotation

    .prologue
    const/4 v5, 0x1

    .line 107
    invoke-virtual {p0}, Lin/sriraman/sharedpreferences/RNSharedPreferencesModule;->getReactApplicationContext()Lcom/facebook/react/bridge/ReactApplicationContext;

    move-result-object v4

    invoke-static {v4}, Lin/sriraman/sharedpreferences/SharedHandler;->init(Landroid/content/Context;)V

    .line 108
    invoke-interface {p1}, Lcom/facebook/react/bridge/ReadableArray;->size()I

    move-result v4

    new-array v2, v4, [Ljava/lang/String;

    .line 109
    .local v2, "keysArray":[Ljava/lang/String;
    const/4 v1, 0x0

    .local v1, "i":I
    :goto_0
    invoke-interface {p1}, Lcom/facebook/react/bridge/ReadableArray;->size()I

    move-result v4

    if-ge v1, v4, :cond_0

    .line 110
    invoke-interface {p1, v1}, Lcom/facebook/react/bridge/ReadableArray;->getString(I)Ljava/lang/String;

    move-result-object v4

    aput-object v4, v2, v1

    .line 109
    add-int/lit8 v1, v1, 0x1

    goto :goto_0

    .line 112
    :cond_0
    invoke-static {v2}, Lin/sriraman/sharedpreferences/SharedDataProvider;->getMultiSharedValues([Ljava/lang/String;)[[Ljava/lang/String;

    move-result-object v3

    .line 113
    .local v3, "values":[[Ljava/lang/String;
    new-instance v0, Lcom/facebook/react/bridge/WritableNativeArray;

    invoke-direct {v0}, Lcom/facebook/react/bridge/WritableNativeArray;-><init>()V

    .line 114
    .local v0, "data":Lcom/facebook/react/bridge/WritableNativeArray;
    const/4 v1, 0x0

    :goto_1
    invoke-interface {p1}, Lcom/facebook/react/bridge/ReadableArray;->size()I

    move-result v4

    if-ge v1, v4, :cond_1

    .line 115
    aget-object v4, v3, v1

    aget-object v4, v4, v5

    invoke-virtual {v0, v4}, Lcom/facebook/react/bridge/WritableNativeArray;->pushString(Ljava/lang/String;)V

    .line 114
    add-int/lit8 v1, v1, 0x1

    goto :goto_1

    .line 117
    :cond_1
    new-array v4, v5, [Ljava/lang/Object;

    const/4 v5, 0x0

    aput-object v0, v4, v5

    invoke-interface {p2, v4}, Lcom/facebook/react/bridge/Callback;->invoke([Ljava/lang/Object;)V

    .line 118
    return-void
.end method

.method public getName()Ljava/lang/String;
    .locals 1

    .prologue
    .line 80
    const-string v0, "SharedPreferences"

    return-object v0
.end method

.method public onCreate(Landroid/os/Bundle;)V
    .locals 0
    .param p1, "savedInstanceState"    # Landroid/os/Bundle;

    .prologue
    .line 69
    return-void
.end method

.method public removeItem(Ljava/lang/String;)V
    .locals 1
    .param p1, "key"    # Ljava/lang/String;
    .annotation runtime Lcom/facebook/react/bridge/ReactMethod;
    .end annotation

    .prologue
    .line 168
    invoke-virtual {p0}, Lin/sriraman/sharedpreferences/RNSharedPreferencesModule;->getReactApplicationContext()Lcom/facebook/react/bridge/ReactApplicationContext;

    move-result-object v0

    invoke-static {v0}, Lin/sriraman/sharedpreferences/SharedHandler;->init(Landroid/content/Context;)V

    .line 169
    invoke-static {p1}, Lin/sriraman/sharedpreferences/SharedDataProvider;->deleteSharedValue(Ljava/lang/String;)V

    .line 170
    return-void
.end method

.method public setItem(Ljava/lang/String;Ljava/lang/String;)V
    .locals 1
    .param p1, "key"    # Ljava/lang/String;
    .param p2, "value"    # Ljava/lang/String;
    .annotation runtime Lcom/facebook/react/bridge/ReactMethod;
    .end annotation

    .prologue
    .line 87
    invoke-virtual {p0}, Lin/sriraman/sharedpreferences/RNSharedPreferencesModule;->getReactApplicationContext()Lcom/facebook/react/bridge/ReactApplicationContext;

    move-result-object v0

    invoke-static {v0}, Lin/sriraman/sharedpreferences/SharedHandler;->init(Landroid/content/Context;)V

    .line 88
    invoke-static {p1, p2}, Lin/sriraman/sharedpreferences/SharedDataProvider;->putSharedValue(Ljava/lang/String;Ljava/lang/String;)V

    .line 90
    return-void
.end method

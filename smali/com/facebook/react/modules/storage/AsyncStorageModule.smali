.class public final Lcom/facebook/react/modules/storage/AsyncStorageModule;
.super Lcom/facebook/react/bridge/ReactContextBaseJavaModule;
.source "AsyncStorageModule.java"

# interfaces
.implements Lcom/facebook/react/modules/common/ModuleDataCleaner$Cleanable;


# annotations
.annotation runtime Lcom/facebook/react/module/annotations/ReactModule;
    name = "AsyncSQLiteDBStorage"
.end annotation


# static fields
.field private static final MAX_SQL_KEYS:I = 0x3e7

.field protected static final NAME:Ljava/lang/String; = "AsyncSQLiteDBStorage"


# instance fields
.field private mReactDatabaseSupplier:Lcom/facebook/react/modules/storage/ReactDatabaseSupplier;

.field private mShuttingDown:Z


# direct methods
.method public constructor <init>(Lcom/facebook/react/bridge/ReactApplicationContext;)V
    .locals 1
    .param p1, "reactContext"    # Lcom/facebook/react/bridge/ReactApplicationContext;

    .prologue
    .line 49
    invoke-direct {p0, p1}, Lcom/facebook/react/bridge/ReactContextBaseJavaModule;-><init>(Lcom/facebook/react/bridge/ReactApplicationContext;)V

    .line 46
    const/4 v0, 0x0

    iput-boolean v0, p0, Lcom/facebook/react/modules/storage/AsyncStorageModule;->mShuttingDown:Z

    .line 50
    invoke-static {p1}, Lcom/facebook/react/modules/storage/ReactDatabaseSupplier;->getInstance(Landroid/content/Context;)Lcom/facebook/react/modules/storage/ReactDatabaseSupplier;

    move-result-object v0

    iput-object v0, p0, Lcom/facebook/react/modules/storage/AsyncStorageModule;->mReactDatabaseSupplier:Lcom/facebook/react/modules/storage/ReactDatabaseSupplier;

    .line 51
    return-void
.end method

.method static synthetic access$000(Lcom/facebook/react/modules/storage/AsyncStorageModule;)Z
    .locals 1
    .param p0, "x0"    # Lcom/facebook/react/modules/storage/AsyncStorageModule;

    .prologue
    .line 36
    invoke-direct {p0}, Lcom/facebook/react/modules/storage/AsyncStorageModule;->ensureDatabase()Z

    move-result v0

    return v0
.end method

.method static synthetic access$100(Lcom/facebook/react/modules/storage/AsyncStorageModule;)Lcom/facebook/react/modules/storage/ReactDatabaseSupplier;
    .locals 1
    .param p0, "x0"    # Lcom/facebook/react/modules/storage/AsyncStorageModule;

    .prologue
    .line 36
    iget-object v0, p0, Lcom/facebook/react/modules/storage/AsyncStorageModule;->mReactDatabaseSupplier:Lcom/facebook/react/modules/storage/ReactDatabaseSupplier;

    return-object v0
.end method

.method private ensureDatabase()Z
    .locals 1

    .prologue
    .line 391
    iget-boolean v0, p0, Lcom/facebook/react/modules/storage/AsyncStorageModule;->mShuttingDown:Z

    if-nez v0, :cond_0

    iget-object v0, p0, Lcom/facebook/react/modules/storage/AsyncStorageModule;->mReactDatabaseSupplier:Lcom/facebook/react/modules/storage/ReactDatabaseSupplier;

    invoke-virtual {v0}, Lcom/facebook/react/modules/storage/ReactDatabaseSupplier;->ensureDatabase()Z

    move-result v0

    if-eqz v0, :cond_0

    const/4 v0, 0x1

    :goto_0
    return v0

    :cond_0
    const/4 v0, 0x0

    goto :goto_0
.end method


# virtual methods
.method public clear(Lcom/facebook/react/bridge/Callback;)V
    .locals 2
    .param p1, "callback"    # Lcom/facebook/react/bridge/Callback;
    .annotation runtime Lcom/facebook/react/bridge/ReactMethod;
    .end annotation

    .prologue
    .line 335
    new-instance v0, Lcom/facebook/react/modules/storage/AsyncStorageModule$5;

    invoke-virtual {p0}, Lcom/facebook/react/modules/storage/AsyncStorageModule;->getReactApplicationContext()Lcom/facebook/react/bridge/ReactApplicationContext;

    move-result-object v1

    invoke-direct {v0, p0, v1, p1}, Lcom/facebook/react/modules/storage/AsyncStorageModule$5;-><init>(Lcom/facebook/react/modules/storage/AsyncStorageModule;Lcom/facebook/react/bridge/ReactContext;Lcom/facebook/react/bridge/Callback;)V

    const/4 v1, 0x0

    new-array v1, v1, [Ljava/lang/Void;

    .line 350
    invoke-virtual {v0, v1}, Lcom/facebook/react/modules/storage/AsyncStorageModule$5;->execute([Ljava/lang/Object;)Landroid/os/AsyncTask;

    .line 351
    return-void
.end method

.method public clearSensitiveData()V
    .locals 1

    .prologue
    .line 74
    iget-object v0, p0, Lcom/facebook/react/modules/storage/AsyncStorageModule;->mReactDatabaseSupplier:Lcom/facebook/react/modules/storage/ReactDatabaseSupplier;

    invoke-virtual {v0}, Lcom/facebook/react/modules/storage/ReactDatabaseSupplier;->clearAndCloseDatabase()V

    .line 75
    return-void
.end method

.method public getAllKeys(Lcom/facebook/react/bridge/Callback;)V
    .locals 2
    .param p1, "callback"    # Lcom/facebook/react/bridge/Callback;
    .annotation runtime Lcom/facebook/react/bridge/ReactMethod;
    .end annotation

    .prologue
    .line 358
    new-instance v0, Lcom/facebook/react/modules/storage/AsyncStorageModule$6;

    invoke-virtual {p0}, Lcom/facebook/react/modules/storage/AsyncStorageModule;->getReactApplicationContext()Lcom/facebook/react/bridge/ReactApplicationContext;

    move-result-object v1

    invoke-direct {v0, p0, v1, p1}, Lcom/facebook/react/modules/storage/AsyncStorageModule$6;-><init>(Lcom/facebook/react/modules/storage/AsyncStorageModule;Lcom/facebook/react/bridge/ReactContext;Lcom/facebook/react/bridge/Callback;)V

    const/4 v1, 0x0

    new-array v1, v1, [Ljava/lang/Void;

    .line 384
    invoke-virtual {v0, v1}, Lcom/facebook/react/modules/storage/AsyncStorageModule$6;->execute([Ljava/lang/Object;)Landroid/os/AsyncTask;

    .line 385
    return-void
.end method

.method public getName()Ljava/lang/String;
    .locals 1

    .prologue
    .line 55
    const-string v0, "AsyncSQLiteDBStorage"

    return-object v0
.end method

.method public initialize()V
    .locals 1

    .prologue
    .line 60
    invoke-super {p0}, Lcom/facebook/react/bridge/ReactContextBaseJavaModule;->initialize()V

    .line 61
    const/4 v0, 0x0

    iput-boolean v0, p0, Lcom/facebook/react/modules/storage/AsyncStorageModule;->mShuttingDown:Z

    .line 62
    return-void
.end method

.method public multiGet(Lcom/facebook/react/bridge/ReadableArray;Lcom/facebook/react/bridge/Callback;)V
    .locals 4
    .param p1, "keys"    # Lcom/facebook/react/bridge/ReadableArray;
    .param p2, "callback"    # Lcom/facebook/react/bridge/Callback;
    .annotation runtime Lcom/facebook/react/bridge/ReactMethod;
    .end annotation

    .prologue
    const/4 v3, 0x0

    const/4 v2, 0x0

    .line 83
    if-nez p1, :cond_0

    .line 84
    const/4 v0, 0x2

    new-array v0, v0, [Ljava/lang/Object;

    invoke-static {v3}, Lcom/facebook/react/modules/storage/AsyncStorageErrorUtil;->getInvalidKeyError(Ljava/lang/String;)Lcom/facebook/react/bridge/WritableMap;

    move-result-object v1

    aput-object v1, v0, v2

    const/4 v1, 0x1

    aput-object v3, v0, v1

    invoke-interface {p2, v0}, Lcom/facebook/react/bridge/Callback;->invoke([Ljava/lang/Object;)V

    .line 147
    :goto_0
    return-void

    .line 88
    :cond_0
    new-instance v0, Lcom/facebook/react/modules/storage/AsyncStorageModule$1;

    invoke-virtual {p0}, Lcom/facebook/react/modules/storage/AsyncStorageModule;->getReactApplicationContext()Lcom/facebook/react/bridge/ReactApplicationContext;

    move-result-object v1

    invoke-direct {v0, p0, v1, p2, p1}, Lcom/facebook/react/modules/storage/AsyncStorageModule$1;-><init>(Lcom/facebook/react/modules/storage/AsyncStorageModule;Lcom/facebook/react/bridge/ReactContext;Lcom/facebook/react/bridge/Callback;Lcom/facebook/react/bridge/ReadableArray;)V

    new-array v1, v2, [Ljava/lang/Void;

    .line 146
    invoke-virtual {v0, v1}, Lcom/facebook/react/modules/storage/AsyncStorageModule$1;->execute([Ljava/lang/Object;)Landroid/os/AsyncTask;

    goto :goto_0
.end method

.method public multiMerge(Lcom/facebook/react/bridge/ReadableArray;Lcom/facebook/react/bridge/Callback;)V
    .locals 2
    .param p1, "keyValueArray"    # Lcom/facebook/react/bridge/ReadableArray;
    .param p2, "callback"    # Lcom/facebook/react/bridge/Callback;
    .annotation runtime Lcom/facebook/react/bridge/ReactMethod;
    .end annotation

    .prologue
    .line 273
    new-instance v0, Lcom/facebook/react/modules/storage/AsyncStorageModule$4;

    invoke-virtual {p0}, Lcom/facebook/react/modules/storage/AsyncStorageModule;->getReactApplicationContext()Lcom/facebook/react/bridge/ReactApplicationContext;

    move-result-object v1

    invoke-direct {v0, p0, v1, p2, p1}, Lcom/facebook/react/modules/storage/AsyncStorageModule$4;-><init>(Lcom/facebook/react/modules/storage/AsyncStorageModule;Lcom/facebook/react/bridge/ReactContext;Lcom/facebook/react/bridge/Callback;Lcom/facebook/react/bridge/ReadableArray;)V

    const/4 v1, 0x0

    new-array v1, v1, [Ljava/lang/Void;

    .line 327
    invoke-virtual {v0, v1}, Lcom/facebook/react/modules/storage/AsyncStorageModule$4;->execute([Ljava/lang/Object;)Landroid/os/AsyncTask;

    .line 328
    return-void
.end method

.method public multiRemove(Lcom/facebook/react/bridge/ReadableArray;Lcom/facebook/react/bridge/Callback;)V
    .locals 3
    .param p1, "keys"    # Lcom/facebook/react/bridge/ReadableArray;
    .param p2, "callback"    # Lcom/facebook/react/bridge/Callback;
    .annotation runtime Lcom/facebook/react/bridge/ReactMethod;
    .end annotation

    .prologue
    const/4 v2, 0x0

    .line 221
    invoke-interface {p1}, Lcom/facebook/react/bridge/ReadableArray;->size()I

    move-result v0

    if-nez v0, :cond_0

    .line 222
    const/4 v0, 0x1

    new-array v0, v0, [Ljava/lang/Object;

    const/4 v1, 0x0

    invoke-static {v1}, Lcom/facebook/react/modules/storage/AsyncStorageErrorUtil;->getInvalidKeyError(Ljava/lang/String;)Lcom/facebook/react/bridge/WritableMap;

    move-result-object v1

    aput-object v1, v0, v2

    invoke-interface {p2, v0}, Lcom/facebook/react/bridge/Callback;->invoke([Ljava/lang/Object;)V

    .line 265
    :goto_0
    return-void

    .line 226
    :cond_0
    new-instance v0, Lcom/facebook/react/modules/storage/AsyncStorageModule$3;

    invoke-virtual {p0}, Lcom/facebook/react/modules/storage/AsyncStorageModule;->getReactApplicationContext()Lcom/facebook/react/bridge/ReactApplicationContext;

    move-result-object v1

    invoke-direct {v0, p0, v1, p2, p1}, Lcom/facebook/react/modules/storage/AsyncStorageModule$3;-><init>(Lcom/facebook/react/modules/storage/AsyncStorageModule;Lcom/facebook/react/bridge/ReactContext;Lcom/facebook/react/bridge/Callback;Lcom/facebook/react/bridge/ReadableArray;)V

    new-array v1, v2, [Ljava/lang/Void;

    .line 264
    invoke-virtual {v0, v1}, Lcom/facebook/react/modules/storage/AsyncStorageModule$3;->execute([Ljava/lang/Object;)Landroid/os/AsyncTask;

    goto :goto_0
.end method

.method public multiSet(Lcom/facebook/react/bridge/ReadableArray;Lcom/facebook/react/bridge/Callback;)V
    .locals 3
    .param p1, "keyValueArray"    # Lcom/facebook/react/bridge/ReadableArray;
    .param p2, "callback"    # Lcom/facebook/react/bridge/Callback;
    .annotation runtime Lcom/facebook/react/bridge/ReactMethod;
    .end annotation

    .prologue
    const/4 v2, 0x0

    .line 156
    invoke-interface {p1}, Lcom/facebook/react/bridge/ReadableArray;->size()I

    move-result v0

    if-nez v0, :cond_0

    .line 157
    const/4 v0, 0x1

    new-array v0, v0, [Ljava/lang/Object;

    const/4 v1, 0x0

    invoke-static {v1}, Lcom/facebook/react/modules/storage/AsyncStorageErrorUtil;->getInvalidKeyError(Ljava/lang/String;)Lcom/facebook/react/bridge/WritableMap;

    move-result-object v1

    aput-object v1, v0, v2

    invoke-interface {p2, v0}, Lcom/facebook/react/bridge/Callback;->invoke([Ljava/lang/Object;)V

    .line 214
    :goto_0
    return-void

    .line 161
    :cond_0
    new-instance v0, Lcom/facebook/react/modules/storage/AsyncStorageModule$2;

    invoke-virtual {p0}, Lcom/facebook/react/modules/storage/AsyncStorageModule;->getReactApplicationContext()Lcom/facebook/react/bridge/ReactApplicationContext;

    move-result-object v1

    invoke-direct {v0, p0, v1, p2, p1}, Lcom/facebook/react/modules/storage/AsyncStorageModule$2;-><init>(Lcom/facebook/react/modules/storage/AsyncStorageModule;Lcom/facebook/react/bridge/ReactContext;Lcom/facebook/react/bridge/Callback;Lcom/facebook/react/bridge/ReadableArray;)V

    new-array v1, v2, [Ljava/lang/Void;

    .line 213
    invoke-virtual {v0, v1}, Lcom/facebook/react/modules/storage/AsyncStorageModule$2;->execute([Ljava/lang/Object;)Landroid/os/AsyncTask;

    goto :goto_0
.end method

.method public onCatalystInstanceDestroy()V
    .locals 1

    .prologue
    .line 66
    const/4 v0, 0x1

    iput-boolean v0, p0, Lcom/facebook/react/modules/storage/AsyncStorageModule;->mShuttingDown:Z

    .line 67
    return-void
.end method

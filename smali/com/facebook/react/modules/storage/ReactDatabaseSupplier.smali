.class public Lcom/facebook/react/modules/storage/ReactDatabaseSupplier;
.super Landroid/database/sqlite/SQLiteOpenHelper;
.source "ReactDatabaseSupplier.java"


# static fields
.field public static final DATABASE_NAME:Ljava/lang/String; = "RKStorage"

.field private static final DATABASE_VERSION:I = 0x1

.field static final KEY_COLUMN:Ljava/lang/String; = "key"

.field private static final SLEEP_TIME_MS:I = 0x1e

.field static final TABLE_CATALYST:Ljava/lang/String; = "catalystLocalStorage"

.field static final VALUE_COLUMN:Ljava/lang/String; = "value"

.field static final VERSION_TABLE_CREATE:Ljava/lang/String; = "CREATE TABLE catalystLocalStorage (key TEXT PRIMARY KEY, value TEXT NOT NULL)"

.field private static sReactDatabaseSupplierInstance:Lcom/facebook/react/modules/storage/ReactDatabaseSupplier;
    .annotation runtime Ljavax/annotation/Nullable;
    .end annotation
.end field


# instance fields
.field private mContext:Landroid/content/Context;

.field private mDb:Landroid/database/sqlite/SQLiteDatabase;
    .annotation runtime Ljavax/annotation/Nullable;
    .end annotation
.end field

.field private mMaximumDatabaseSize:J


# direct methods
.method private constructor <init>(Landroid/content/Context;)V
    .locals 3
    .param p1, "context"    # Landroid/content/Context;

    .prologue
    .line 51
    const-string v0, "RKStorage"

    const/4 v1, 0x0

    const/4 v2, 0x1

    invoke-direct {p0, p1, v0, v1, v2}, Landroid/database/sqlite/SQLiteOpenHelper;-><init>(Landroid/content/Context;Ljava/lang/String;Landroid/database/sqlite/SQLiteDatabase$CursorFactory;I)V

    .line 48
    const-wide/32 v0, 0x600000

    iput-wide v0, p0, Lcom/facebook/react/modules/storage/ReactDatabaseSupplier;->mMaximumDatabaseSize:J

    .line 52
    iput-object p1, p0, Lcom/facebook/react/modules/storage/ReactDatabaseSupplier;->mContext:Landroid/content/Context;

    .line 53
    return-void
.end method

.method private declared-synchronized closeDatabase()V
    .locals 1

    .prologue
    .line 157
    monitor-enter p0

    :try_start_0
    iget-object v0, p0, Lcom/facebook/react/modules/storage/ReactDatabaseSupplier;->mDb:Landroid/database/sqlite/SQLiteDatabase;

    if-eqz v0, :cond_0

    iget-object v0, p0, Lcom/facebook/react/modules/storage/ReactDatabaseSupplier;->mDb:Landroid/database/sqlite/SQLiteDatabase;

    invoke-virtual {v0}, Landroid/database/sqlite/SQLiteDatabase;->isOpen()Z

    move-result v0

    if-eqz v0, :cond_0

    .line 158
    iget-object v0, p0, Lcom/facebook/react/modules/storage/ReactDatabaseSupplier;->mDb:Landroid/database/sqlite/SQLiteDatabase;

    invoke-virtual {v0}, Landroid/database/sqlite/SQLiteDatabase;->close()V

    .line 159
    const/4 v0, 0x0

    iput-object v0, p0, Lcom/facebook/react/modules/storage/ReactDatabaseSupplier;->mDb:Landroid/database/sqlite/SQLiteDatabase;
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    .line 161
    :cond_0
    monitor-exit p0

    return-void

    .line 157
    :catchall_0
    move-exception v0

    monitor-exit p0

    throw v0
.end method

.method private declared-synchronized deleteDatabase()Z
    .locals 2

    .prologue
    .line 152
    monitor-enter p0

    :try_start_0
    invoke-direct {p0}, Lcom/facebook/react/modules/storage/ReactDatabaseSupplier;->closeDatabase()V

    .line 153
    iget-object v0, p0, Lcom/facebook/react/modules/storage/ReactDatabaseSupplier;->mContext:Landroid/content/Context;

    const-string v1, "RKStorage"

    invoke-virtual {v0, v1}, Landroid/content/Context;->deleteDatabase(Ljava/lang/String;)Z
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    move-result v0

    monitor-exit p0

    return v0

    .line 152
    :catchall_0
    move-exception v0

    monitor-exit p0

    throw v0
.end method

.method public static deleteInstance()V
    .locals 1

    .prologue
    .line 165
    const/4 v0, 0x0

    sput-object v0, Lcom/facebook/react/modules/storage/ReactDatabaseSupplier;->sReactDatabaseSupplierInstance:Lcom/facebook/react/modules/storage/ReactDatabaseSupplier;

    .line 166
    return-void
.end method

.method public static getInstance(Landroid/content/Context;)Lcom/facebook/react/modules/storage/ReactDatabaseSupplier;
    .locals 2
    .param p0, "context"    # Landroid/content/Context;

    .prologue
    .line 56
    sget-object v0, Lcom/facebook/react/modules/storage/ReactDatabaseSupplier;->sReactDatabaseSupplierInstance:Lcom/facebook/react/modules/storage/ReactDatabaseSupplier;

    if-nez v0, :cond_0

    .line 57
    new-instance v0, Lcom/facebook/react/modules/storage/ReactDatabaseSupplier;

    invoke-virtual {p0}, Landroid/content/Context;->getApplicationContext()Landroid/content/Context;

    move-result-object v1

    invoke-direct {v0, v1}, Lcom/facebook/react/modules/storage/ReactDatabaseSupplier;-><init>(Landroid/content/Context;)V

    sput-object v0, Lcom/facebook/react/modules/storage/ReactDatabaseSupplier;->sReactDatabaseSupplierInstance:Lcom/facebook/react/modules/storage/ReactDatabaseSupplier;

    .line 59
    :cond_0
    sget-object v0, Lcom/facebook/react/modules/storage/ReactDatabaseSupplier;->sReactDatabaseSupplierInstance:Lcom/facebook/react/modules/storage/ReactDatabaseSupplier;

    return-object v0
.end method


# virtual methods
.method declared-synchronized clear()V
    .locals 4

    .prologue
    .line 137
    monitor-enter p0

    :try_start_0
    invoke-virtual {p0}, Lcom/facebook/react/modules/storage/ReactDatabaseSupplier;->get()Landroid/database/sqlite/SQLiteDatabase;

    move-result-object v0

    const-string v1, "catalystLocalStorage"

    const/4 v2, 0x0

    const/4 v3, 0x0

    invoke-virtual {v0, v1, v2, v3}, Landroid/database/sqlite/SQLiteDatabase;->delete(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;)I
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    .line 138
    monitor-exit p0

    return-void

    .line 137
    :catchall_0
    move-exception v0

    monitor-exit p0

    throw v0
.end method

.method public declared-synchronized clearAndCloseDatabase()V
    .locals 3
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/lang/RuntimeException;
        }
    .end annotation

    .prologue
    .line 122
    monitor-enter p0

    :try_start_0
    invoke-virtual {p0}, Lcom/facebook/react/modules/storage/ReactDatabaseSupplier;->clear()V

    .line 123
    invoke-direct {p0}, Lcom/facebook/react/modules/storage/ReactDatabaseSupplier;->closeDatabase()V

    .line 124
    const-string v1, "ReactNative"

    const-string v2, "Cleaned RKStorage"

    invoke-static {v1, v2}, Lcom/facebook/common/logging/FLog;->d(Ljava/lang/String;Ljava/lang/String;)V
    :try_end_0
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    .line 134
    :goto_0
    monitor-exit p0

    return-void

    .line 125
    :catch_0
    move-exception v0

    .line 127
    .local v0, "e":Ljava/lang/Exception;
    :try_start_1
    invoke-direct {p0}, Lcom/facebook/react/modules/storage/ReactDatabaseSupplier;->deleteDatabase()Z

    move-result v1

    if-eqz v1, :cond_0

    .line 128
    const-string v1, "ReactNative"

    const-string v2, "Deleted Local Database RKStorage"

    invoke-static {v1, v2}, Lcom/facebook/common/logging/FLog;->d(Ljava/lang/String;Ljava/lang/String;)V
    :try_end_1
    .catchall {:try_start_1 .. :try_end_1} :catchall_0

    goto :goto_0

    .line 122
    .end local v0    # "e":Ljava/lang/Exception;
    :catchall_0
    move-exception v1

    monitor-exit p0

    throw v1

    .line 132
    .restart local v0    # "e":Ljava/lang/Exception;
    :cond_0
    :try_start_2
    new-instance v1, Ljava/lang/RuntimeException;

    const-string v2, "Clearing and deleting database RKStorage failed"

    invoke-direct {v1, v2}, Ljava/lang/RuntimeException;-><init>(Ljava/lang/String;)V

    throw v1
    :try_end_2
    .catchall {:try_start_2 .. :try_end_2} :catchall_0
.end method

.method declared-synchronized ensureDatabase()Z
    .locals 9

    .prologue
    const/4 v8, 0x1

    .line 79
    monitor-enter p0

    :try_start_0
    iget-object v4, p0, Lcom/facebook/react/modules/storage/ReactDatabaseSupplier;->mDb:Landroid/database/sqlite/SQLiteDatabase;

    if-eqz v4, :cond_0

    iget-object v4, p0, Lcom/facebook/react/modules/storage/ReactDatabaseSupplier;->mDb:Landroid/database/sqlite/SQLiteDatabase;

    invoke-virtual {v4}, Landroid/database/sqlite/SQLiteDatabase;->isOpen()Z
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    move-result v4

    if-eqz v4, :cond_0

    .line 109
    :goto_0
    monitor-exit p0

    return v8

    .line 84
    :cond_0
    const/4 v2, 0x0

    .line 85
    .local v2, "lastSQLiteException":Landroid/database/sqlite/SQLiteException;
    const/4 v3, 0x0

    .local v3, "tries":I
    :goto_1
    const/4 v4, 0x2

    if-ge v3, v4, :cond_2

    .line 87
    if-lez v3, :cond_1

    .line 88
    :try_start_1
    invoke-direct {p0}, Lcom/facebook/react/modules/storage/ReactDatabaseSupplier;->deleteDatabase()Z

    .line 90
    :cond_1
    invoke-virtual {p0}, Lcom/facebook/react/modules/storage/ReactDatabaseSupplier;->getWritableDatabase()Landroid/database/sqlite/SQLiteDatabase;

    move-result-object v4

    iput-object v4, p0, Lcom/facebook/react/modules/storage/ReactDatabaseSupplier;->mDb:Landroid/database/sqlite/SQLiteDatabase;
    :try_end_1
    .catch Landroid/database/sqlite/SQLiteException; {:try_start_1 .. :try_end_1} :catch_0
    .catchall {:try_start_1 .. :try_end_1} :catchall_0

    .line 102
    :cond_2
    :try_start_2
    iget-object v4, p0, Lcom/facebook/react/modules/storage/ReactDatabaseSupplier;->mDb:Landroid/database/sqlite/SQLiteDatabase;

    if-nez v4, :cond_3

    .line 103
    throw v2
    :try_end_2
    .catchall {:try_start_2 .. :try_end_2} :catchall_0

    .line 79
    .end local v2    # "lastSQLiteException":Landroid/database/sqlite/SQLiteException;
    .end local v3    # "tries":I
    :catchall_0
    move-exception v4

    monitor-exit p0

    throw v4

    .line 92
    .restart local v2    # "lastSQLiteException":Landroid/database/sqlite/SQLiteException;
    .restart local v3    # "tries":I
    :catch_0
    move-exception v0

    .line 93
    .local v0, "e":Landroid/database/sqlite/SQLiteException;
    move-object v2, v0

    .line 97
    const-wide/16 v4, 0x1e

    :try_start_3
    invoke-static {v4, v5}, Ljava/lang/Thread;->sleep(J)V
    :try_end_3
    .catch Ljava/lang/InterruptedException; {:try_start_3 .. :try_end_3} :catch_1
    .catchall {:try_start_3 .. :try_end_3} :catchall_0

    .line 85
    :goto_2
    add-int/lit8 v3, v3, 0x1

    goto :goto_1

    .line 98
    :catch_1
    move-exception v1

    .line 99
    .local v1, "ie":Ljava/lang/InterruptedException;
    :try_start_4
    invoke-static {}, Ljava/lang/Thread;->currentThread()Ljava/lang/Thread;

    move-result-object v4

    invoke-virtual {v4}, Ljava/lang/Thread;->interrupt()V

    goto :goto_2

    .line 108
    .end local v0    # "e":Landroid/database/sqlite/SQLiteException;
    .end local v1    # "ie":Ljava/lang/InterruptedException;
    :cond_3
    iget-object v4, p0, Lcom/facebook/react/modules/storage/ReactDatabaseSupplier;->mDb:Landroid/database/sqlite/SQLiteDatabase;

    iget-wide v6, p0, Lcom/facebook/react/modules/storage/ReactDatabaseSupplier;->mMaximumDatabaseSize:J

    invoke-virtual {v4, v6, v7}, Landroid/database/sqlite/SQLiteDatabase;->setMaximumSize(J)J
    :try_end_4
    .catchall {:try_start_4 .. :try_end_4} :catchall_0

    goto :goto_0
.end method

.method public declared-synchronized get()Landroid/database/sqlite/SQLiteDatabase;
    .locals 1

    .prologue
    .line 116
    monitor-enter p0

    :try_start_0
    invoke-virtual {p0}, Lcom/facebook/react/modules/storage/ReactDatabaseSupplier;->ensureDatabase()Z

    .line 117
    iget-object v0, p0, Lcom/facebook/react/modules/storage/ReactDatabaseSupplier;->mDb:Landroid/database/sqlite/SQLiteDatabase;
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    monitor-exit p0

    return-object v0

    .line 116
    :catchall_0
    move-exception v0

    monitor-exit p0

    throw v0
.end method

.method public onCreate(Landroid/database/sqlite/SQLiteDatabase;)V
    .locals 1
    .param p1, "db"    # Landroid/database/sqlite/SQLiteDatabase;

    .prologue
    .line 64
    const-string v0, "CREATE TABLE catalystLocalStorage (key TEXT PRIMARY KEY, value TEXT NOT NULL)"

    invoke-virtual {p1, v0}, Landroid/database/sqlite/SQLiteDatabase;->execSQL(Ljava/lang/String;)V

    .line 65
    return-void
.end method

.method public onUpgrade(Landroid/database/sqlite/SQLiteDatabase;II)V
    .locals 0
    .param p1, "db"    # Landroid/database/sqlite/SQLiteDatabase;
    .param p2, "oldVersion"    # I
    .param p3, "newVersion"    # I

    .prologue
    .line 69
    if-eq p2, p3, :cond_0

    .line 70
    invoke-direct {p0}, Lcom/facebook/react/modules/storage/ReactDatabaseSupplier;->deleteDatabase()Z

    .line 71
    invoke-virtual {p0, p1}, Lcom/facebook/react/modules/storage/ReactDatabaseSupplier;->onCreate(Landroid/database/sqlite/SQLiteDatabase;)V

    .line 73
    :cond_0
    return-void
.end method

.method public declared-synchronized setMaximumSize(J)V
    .locals 5
    .param p1, "size"    # J

    .prologue
    .line 145
    monitor-enter p0

    :try_start_0
    iput-wide p1, p0, Lcom/facebook/react/modules/storage/ReactDatabaseSupplier;->mMaximumDatabaseSize:J

    .line 146
    iget-object v0, p0, Lcom/facebook/react/modules/storage/ReactDatabaseSupplier;->mDb:Landroid/database/sqlite/SQLiteDatabase;

    if-eqz v0, :cond_0

    .line 147
    iget-object v0, p0, Lcom/facebook/react/modules/storage/ReactDatabaseSupplier;->mDb:Landroid/database/sqlite/SQLiteDatabase;

    iget-wide v2, p0, Lcom/facebook/react/modules/storage/ReactDatabaseSupplier;->mMaximumDatabaseSize:J

    invoke-virtual {v0, v2, v3}, Landroid/database/sqlite/SQLiteDatabase;->setMaximumSize(J)J
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    .line 149
    :cond_0
    monitor-exit p0

    return-void

    .line 145
    :catchall_0
    move-exception v0

    monitor-exit p0

    throw v0
.end method

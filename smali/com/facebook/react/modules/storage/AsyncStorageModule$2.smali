.class Lcom/facebook/react/modules/storage/AsyncStorageModule$2;
.super Lcom/facebook/react/bridge/GuardedAsyncTask;
.source "AsyncStorageModule.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/facebook/react/modules/storage/AsyncStorageModule;->multiSet(Lcom/facebook/react/bridge/ReadableArray;Lcom/facebook/react/bridge/Callback;)V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation

.annotation system Ldalvik/annotation/Signature;
    value = {
        "Lcom/facebook/react/bridge/GuardedAsyncTask",
        "<",
        "Ljava/lang/Void;",
        "Ljava/lang/Void;",
        ">;"
    }
.end annotation


# instance fields
.field final synthetic this$0:Lcom/facebook/react/modules/storage/AsyncStorageModule;

.field final synthetic val$callback:Lcom/facebook/react/bridge/Callback;

.field final synthetic val$keyValueArray:Lcom/facebook/react/bridge/ReadableArray;


# direct methods
.method constructor <init>(Lcom/facebook/react/modules/storage/AsyncStorageModule;Lcom/facebook/react/bridge/ReactContext;Lcom/facebook/react/bridge/Callback;Lcom/facebook/react/bridge/ReadableArray;)V
    .locals 0
    .param p1, "this$0"    # Lcom/facebook/react/modules/storage/AsyncStorageModule;
    .param p2, "reactContext"    # Lcom/facebook/react/bridge/ReactContext;

    .prologue
    .line 161
    iput-object p1, p0, Lcom/facebook/react/modules/storage/AsyncStorageModule$2;->this$0:Lcom/facebook/react/modules/storage/AsyncStorageModule;

    iput-object p3, p0, Lcom/facebook/react/modules/storage/AsyncStorageModule$2;->val$callback:Lcom/facebook/react/bridge/Callback;

    iput-object p4, p0, Lcom/facebook/react/modules/storage/AsyncStorageModule$2;->val$keyValueArray:Lcom/facebook/react/bridge/ReadableArray;

    invoke-direct {p0, p2}, Lcom/facebook/react/bridge/GuardedAsyncTask;-><init>(Lcom/facebook/react/bridge/ReactContext;)V

    return-void
.end method


# virtual methods
.method protected bridge synthetic doInBackgroundGuarded([Ljava/lang/Object;)V
    .locals 0

    .prologue
    .line 161
    check-cast p1, [Ljava/lang/Void;

    invoke-virtual {p0, p1}, Lcom/facebook/react/modules/storage/AsyncStorageModule$2;->doInBackgroundGuarded([Ljava/lang/Void;)V

    return-void
.end method

.method protected varargs doInBackgroundGuarded([Ljava/lang/Void;)V
    .locals 12
    .param p1, "params"    # [Ljava/lang/Void;

    .prologue
    const/4 v11, 0x2

    const/4 v10, 0x1

    const/4 v9, 0x0

    const/4 v8, 0x0

    .line 164
    iget-object v5, p0, Lcom/facebook/react/modules/storage/AsyncStorageModule$2;->this$0:Lcom/facebook/react/modules/storage/AsyncStorageModule;

    invoke-static {v5}, Lcom/facebook/react/modules/storage/AsyncStorageModule;->access$000(Lcom/facebook/react/modules/storage/AsyncStorageModule;)Z

    move-result v5

    if-nez v5, :cond_1

    .line 165
    iget-object v5, p0, Lcom/facebook/react/modules/storage/AsyncStorageModule$2;->val$callback:Lcom/facebook/react/bridge/Callback;

    new-array v6, v10, [Ljava/lang/Object;

    invoke-static {v8}, Lcom/facebook/react/modules/storage/AsyncStorageErrorUtil;->getDBError(Ljava/lang/String;)Lcom/facebook/react/bridge/WritableMap;

    move-result-object v7

    aput-object v7, v6, v9

    invoke-interface {v5, v6}, Lcom/facebook/react/bridge/Callback;->invoke([Ljava/lang/Object;)V

    .line 212
    :cond_0
    :goto_0
    return-void

    .line 169
    :cond_1
    const-string v3, "INSERT OR REPLACE INTO catalystLocalStorage VALUES (?, ?);"

    .line 170
    .local v3, "sql":Ljava/lang/String;
    iget-object v5, p0, Lcom/facebook/react/modules/storage/AsyncStorageModule$2;->this$0:Lcom/facebook/react/modules/storage/AsyncStorageModule;

    invoke-static {v5}, Lcom/facebook/react/modules/storage/AsyncStorageModule;->access$100(Lcom/facebook/react/modules/storage/AsyncStorageModule;)Lcom/facebook/react/modules/storage/ReactDatabaseSupplier;

    move-result-object v5

    invoke-virtual {v5}, Lcom/facebook/react/modules/storage/ReactDatabaseSupplier;->get()Landroid/database/sqlite/SQLiteDatabase;

    move-result-object v5

    invoke-virtual {v5, v3}, Landroid/database/sqlite/SQLiteDatabase;->compileStatement(Ljava/lang/String;)Landroid/database/sqlite/SQLiteStatement;

    move-result-object v4

    .line 171
    .local v4, "statement":Landroid/database/sqlite/SQLiteStatement;
    const/4 v1, 0x0

    .line 173
    .local v1, "error":Lcom/facebook/react/bridge/WritableMap;
    :try_start_0
    iget-object v5, p0, Lcom/facebook/react/modules/storage/AsyncStorageModule$2;->this$0:Lcom/facebook/react/modules/storage/AsyncStorageModule;

    invoke-static {v5}, Lcom/facebook/react/modules/storage/AsyncStorageModule;->access$100(Lcom/facebook/react/modules/storage/AsyncStorageModule;)Lcom/facebook/react/modules/storage/ReactDatabaseSupplier;

    move-result-object v5

    invoke-virtual {v5}, Lcom/facebook/react/modules/storage/ReactDatabaseSupplier;->get()Landroid/database/sqlite/SQLiteDatabase;

    move-result-object v5

    invoke-virtual {v5}, Landroid/database/sqlite/SQLiteDatabase;->beginTransaction()V

    .line 174
    const/4 v2, 0x0

    .local v2, "idx":I
    :goto_1
    iget-object v5, p0, Lcom/facebook/react/modules/storage/AsyncStorageModule$2;->val$keyValueArray:Lcom/facebook/react/bridge/ReadableArray;

    invoke-interface {v5}, Lcom/facebook/react/bridge/ReadableArray;->size()I

    move-result v5

    if-ge v2, v5, :cond_5

    .line 175
    iget-object v5, p0, Lcom/facebook/react/modules/storage/AsyncStorageModule$2;->val$keyValueArray:Lcom/facebook/react/bridge/ReadableArray;

    invoke-interface {v5, v2}, Lcom/facebook/react/bridge/ReadableArray;->getArray(I)Lcom/facebook/react/bridge/ReadableArray;

    move-result-object v5

    invoke-interface {v5}, Lcom/facebook/react/bridge/ReadableArray;->size()I

    move-result v5

    if-eq v5, v11, :cond_2

    .line 176
    const/4 v5, 0x0

    invoke-static {v5}, Lcom/facebook/react/modules/storage/AsyncStorageErrorUtil;->getInvalidValueError(Ljava/lang/String;)Lcom/facebook/react/bridge/WritableMap;
    :try_end_0
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_4
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    move-result-object v1

    .line 199
    :try_start_1
    iget-object v5, p0, Lcom/facebook/react/modules/storage/AsyncStorageModule$2;->this$0:Lcom/facebook/react/modules/storage/AsyncStorageModule;

    invoke-static {v5}, Lcom/facebook/react/modules/storage/AsyncStorageModule;->access$100(Lcom/facebook/react/modules/storage/AsyncStorageModule;)Lcom/facebook/react/modules/storage/ReactDatabaseSupplier;

    move-result-object v5

    invoke-virtual {v5}, Lcom/facebook/react/modules/storage/ReactDatabaseSupplier;->get()Landroid/database/sqlite/SQLiteDatabase;

    move-result-object v5

    invoke-virtual {v5}, Landroid/database/sqlite/SQLiteDatabase;->endTransaction()V
    :try_end_1
    .catch Ljava/lang/Exception; {:try_start_1 .. :try_end_1} :catch_0

    goto :goto_0

    .line 200
    :catch_0
    move-exception v0

    .line 201
    .local v0, "e":Ljava/lang/Exception;
    const-string v5, "ReactNative"

    invoke-virtual {v0}, Ljava/lang/Exception;->getMessage()Ljava/lang/String;

    move-result-object v6

    invoke-static {v5, v6, v0}, Lcom/facebook/common/logging/FLog;->w(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V

    .line 202
    if-nez v1, :cond_0

    .line 203
    invoke-virtual {v0}, Ljava/lang/Exception;->getMessage()Ljava/lang/String;

    move-result-object v5

    invoke-static {v8, v5}, Lcom/facebook/react/modules/storage/AsyncStorageErrorUtil;->getError(Ljava/lang/String;Ljava/lang/String;)Lcom/facebook/react/bridge/WritableMap;

    move-result-object v1

    goto :goto_0

    .line 179
    .end local v0    # "e":Ljava/lang/Exception;
    :cond_2
    :try_start_2
    iget-object v5, p0, Lcom/facebook/react/modules/storage/AsyncStorageModule$2;->val$keyValueArray:Lcom/facebook/react/bridge/ReadableArray;

    invoke-interface {v5, v2}, Lcom/facebook/react/bridge/ReadableArray;->getArray(I)Lcom/facebook/react/bridge/ReadableArray;

    move-result-object v5

    const/4 v6, 0x0

    invoke-interface {v5, v6}, Lcom/facebook/react/bridge/ReadableArray;->getString(I)Ljava/lang/String;

    move-result-object v5

    if-nez v5, :cond_3

    .line 180
    const/4 v5, 0x0

    invoke-static {v5}, Lcom/facebook/react/modules/storage/AsyncStorageErrorUtil;->getInvalidKeyError(Ljava/lang/String;)Lcom/facebook/react/bridge/WritableMap;
    :try_end_2
    .catch Ljava/lang/Exception; {:try_start_2 .. :try_end_2} :catch_4
    .catchall {:try_start_2 .. :try_end_2} :catchall_0

    move-result-object v1

    .line 199
    :try_start_3
    iget-object v5, p0, Lcom/facebook/react/modules/storage/AsyncStorageModule$2;->this$0:Lcom/facebook/react/modules/storage/AsyncStorageModule;

    invoke-static {v5}, Lcom/facebook/react/modules/storage/AsyncStorageModule;->access$100(Lcom/facebook/react/modules/storage/AsyncStorageModule;)Lcom/facebook/react/modules/storage/ReactDatabaseSupplier;

    move-result-object v5

    invoke-virtual {v5}, Lcom/facebook/react/modules/storage/ReactDatabaseSupplier;->get()Landroid/database/sqlite/SQLiteDatabase;

    move-result-object v5

    invoke-virtual {v5}, Landroid/database/sqlite/SQLiteDatabase;->endTransaction()V
    :try_end_3
    .catch Ljava/lang/Exception; {:try_start_3 .. :try_end_3} :catch_1

    goto :goto_0

    .line 200
    :catch_1
    move-exception v0

    .line 201
    .restart local v0    # "e":Ljava/lang/Exception;
    const-string v5, "ReactNative"

    invoke-virtual {v0}, Ljava/lang/Exception;->getMessage()Ljava/lang/String;

    move-result-object v6

    invoke-static {v5, v6, v0}, Lcom/facebook/common/logging/FLog;->w(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V

    .line 202
    if-nez v1, :cond_0

    .line 203
    invoke-virtual {v0}, Ljava/lang/Exception;->getMessage()Ljava/lang/String;

    move-result-object v5

    invoke-static {v8, v5}, Lcom/facebook/react/modules/storage/AsyncStorageErrorUtil;->getError(Ljava/lang/String;Ljava/lang/String;)Lcom/facebook/react/bridge/WritableMap;

    move-result-object v1

    goto/16 :goto_0

    .line 183
    .end local v0    # "e":Ljava/lang/Exception;
    :cond_3
    :try_start_4
    iget-object v5, p0, Lcom/facebook/react/modules/storage/AsyncStorageModule$2;->val$keyValueArray:Lcom/facebook/react/bridge/ReadableArray;

    invoke-interface {v5, v2}, Lcom/facebook/react/bridge/ReadableArray;->getArray(I)Lcom/facebook/react/bridge/ReadableArray;

    move-result-object v5

    const/4 v6, 0x1

    invoke-interface {v5, v6}, Lcom/facebook/react/bridge/ReadableArray;->getString(I)Ljava/lang/String;

    move-result-object v5

    if-nez v5, :cond_4

    .line 184
    const/4 v5, 0x0

    invoke-static {v5}, Lcom/facebook/react/modules/storage/AsyncStorageErrorUtil;->getInvalidValueError(Ljava/lang/String;)Lcom/facebook/react/bridge/WritableMap;
    :try_end_4
    .catch Ljava/lang/Exception; {:try_start_4 .. :try_end_4} :catch_4
    .catchall {:try_start_4 .. :try_end_4} :catchall_0

    move-result-object v1

    .line 199
    :try_start_5
    iget-object v5, p0, Lcom/facebook/react/modules/storage/AsyncStorageModule$2;->this$0:Lcom/facebook/react/modules/storage/AsyncStorageModule;

    invoke-static {v5}, Lcom/facebook/react/modules/storage/AsyncStorageModule;->access$100(Lcom/facebook/react/modules/storage/AsyncStorageModule;)Lcom/facebook/react/modules/storage/ReactDatabaseSupplier;

    move-result-object v5

    invoke-virtual {v5}, Lcom/facebook/react/modules/storage/ReactDatabaseSupplier;->get()Landroid/database/sqlite/SQLiteDatabase;

    move-result-object v5

    invoke-virtual {v5}, Landroid/database/sqlite/SQLiteDatabase;->endTransaction()V
    :try_end_5
    .catch Ljava/lang/Exception; {:try_start_5 .. :try_end_5} :catch_2

    goto/16 :goto_0

    .line 200
    :catch_2
    move-exception v0

    .line 201
    .restart local v0    # "e":Ljava/lang/Exception;
    const-string v5, "ReactNative"

    invoke-virtual {v0}, Ljava/lang/Exception;->getMessage()Ljava/lang/String;

    move-result-object v6

    invoke-static {v5, v6, v0}, Lcom/facebook/common/logging/FLog;->w(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V

    .line 202
    if-nez v1, :cond_0

    .line 203
    invoke-virtual {v0}, Ljava/lang/Exception;->getMessage()Ljava/lang/String;

    move-result-object v5

    invoke-static {v8, v5}, Lcom/facebook/react/modules/storage/AsyncStorageErrorUtil;->getError(Ljava/lang/String;Ljava/lang/String;)Lcom/facebook/react/bridge/WritableMap;

    move-result-object v1

    goto/16 :goto_0

    .line 188
    .end local v0    # "e":Ljava/lang/Exception;
    :cond_4
    :try_start_6
    invoke-virtual {v4}, Landroid/database/sqlite/SQLiteStatement;->clearBindings()V

    .line 189
    const/4 v5, 0x1

    iget-object v6, p0, Lcom/facebook/react/modules/storage/AsyncStorageModule$2;->val$keyValueArray:Lcom/facebook/react/bridge/ReadableArray;

    invoke-interface {v6, v2}, Lcom/facebook/react/bridge/ReadableArray;->getArray(I)Lcom/facebook/react/bridge/ReadableArray;

    move-result-object v6

    const/4 v7, 0x0

    invoke-interface {v6, v7}, Lcom/facebook/react/bridge/ReadableArray;->getString(I)Ljava/lang/String;

    move-result-object v6

    invoke-virtual {v4, v5, v6}, Landroid/database/sqlite/SQLiteStatement;->bindString(ILjava/lang/String;)V

    .line 190
    const/4 v5, 0x2

    iget-object v6, p0, Lcom/facebook/react/modules/storage/AsyncStorageModule$2;->val$keyValueArray:Lcom/facebook/react/bridge/ReadableArray;

    invoke-interface {v6, v2}, Lcom/facebook/react/bridge/ReadableArray;->getArray(I)Lcom/facebook/react/bridge/ReadableArray;

    move-result-object v6

    const/4 v7, 0x1

    invoke-interface {v6, v7}, Lcom/facebook/react/bridge/ReadableArray;->getString(I)Ljava/lang/String;

    move-result-object v6

    invoke-virtual {v4, v5, v6}, Landroid/database/sqlite/SQLiteStatement;->bindString(ILjava/lang/String;)V

    .line 191
    invoke-virtual {v4}, Landroid/database/sqlite/SQLiteStatement;->execute()V

    .line 174
    add-int/lit8 v2, v2, 0x1

    goto/16 :goto_1

    .line 193
    :cond_5
    iget-object v5, p0, Lcom/facebook/react/modules/storage/AsyncStorageModule$2;->this$0:Lcom/facebook/react/modules/storage/AsyncStorageModule;

    invoke-static {v5}, Lcom/facebook/react/modules/storage/AsyncStorageModule;->access$100(Lcom/facebook/react/modules/storage/AsyncStorageModule;)Lcom/facebook/react/modules/storage/ReactDatabaseSupplier;

    move-result-object v5

    invoke-virtual {v5}, Lcom/facebook/react/modules/storage/ReactDatabaseSupplier;->get()Landroid/database/sqlite/SQLiteDatabase;

    move-result-object v5

    invoke-virtual {v5}, Landroid/database/sqlite/SQLiteDatabase;->setTransactionSuccessful()V
    :try_end_6
    .catch Ljava/lang/Exception; {:try_start_6 .. :try_end_6} :catch_4
    .catchall {:try_start_6 .. :try_end_6} :catchall_0

    .line 199
    :try_start_7
    iget-object v5, p0, Lcom/facebook/react/modules/storage/AsyncStorageModule$2;->this$0:Lcom/facebook/react/modules/storage/AsyncStorageModule;

    invoke-static {v5}, Lcom/facebook/react/modules/storage/AsyncStorageModule;->access$100(Lcom/facebook/react/modules/storage/AsyncStorageModule;)Lcom/facebook/react/modules/storage/ReactDatabaseSupplier;

    move-result-object v5

    invoke-virtual {v5}, Lcom/facebook/react/modules/storage/ReactDatabaseSupplier;->get()Landroid/database/sqlite/SQLiteDatabase;

    move-result-object v5

    invoke-virtual {v5}, Landroid/database/sqlite/SQLiteDatabase;->endTransaction()V
    :try_end_7
    .catch Ljava/lang/Exception; {:try_start_7 .. :try_end_7} :catch_3

    .line 207
    .end local v2    # "idx":I
    :cond_6
    :goto_2
    if-eqz v1, :cond_8

    .line 208
    iget-object v5, p0, Lcom/facebook/react/modules/storage/AsyncStorageModule$2;->val$callback:Lcom/facebook/react/bridge/Callback;

    new-array v6, v10, [Ljava/lang/Object;

    aput-object v1, v6, v9

    invoke-interface {v5, v6}, Lcom/facebook/react/bridge/Callback;->invoke([Ljava/lang/Object;)V

    goto/16 :goto_0

    .line 200
    .restart local v2    # "idx":I
    :catch_3
    move-exception v0

    .line 201
    .restart local v0    # "e":Ljava/lang/Exception;
    const-string v5, "ReactNative"

    invoke-virtual {v0}, Ljava/lang/Exception;->getMessage()Ljava/lang/String;

    move-result-object v6

    invoke-static {v5, v6, v0}, Lcom/facebook/common/logging/FLog;->w(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V

    .line 202
    if-nez v1, :cond_6

    .line 203
    invoke-virtual {v0}, Ljava/lang/Exception;->getMessage()Ljava/lang/String;

    move-result-object v5

    invoke-static {v8, v5}, Lcom/facebook/react/modules/storage/AsyncStorageErrorUtil;->getError(Ljava/lang/String;Ljava/lang/String;)Lcom/facebook/react/bridge/WritableMap;

    move-result-object v1

    goto :goto_2

    .line 194
    .end local v0    # "e":Ljava/lang/Exception;
    .end local v2    # "idx":I
    :catch_4
    move-exception v0

    .line 195
    .restart local v0    # "e":Ljava/lang/Exception;
    :try_start_8
    const-string v5, "ReactNative"

    invoke-virtual {v0}, Ljava/lang/Exception;->getMessage()Ljava/lang/String;

    move-result-object v6

    invoke-static {v5, v6, v0}, Lcom/facebook/common/logging/FLog;->w(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V

    .line 196
    const/4 v5, 0x0

    invoke-virtual {v0}, Ljava/lang/Exception;->getMessage()Ljava/lang/String;

    move-result-object v6

    invoke-static {v5, v6}, Lcom/facebook/react/modules/storage/AsyncStorageErrorUtil;->getError(Ljava/lang/String;Ljava/lang/String;)Lcom/facebook/react/bridge/WritableMap;
    :try_end_8
    .catchall {:try_start_8 .. :try_end_8} :catchall_0

    move-result-object v1

    .line 199
    :try_start_9
    iget-object v5, p0, Lcom/facebook/react/modules/storage/AsyncStorageModule$2;->this$0:Lcom/facebook/react/modules/storage/AsyncStorageModule;

    invoke-static {v5}, Lcom/facebook/react/modules/storage/AsyncStorageModule;->access$100(Lcom/facebook/react/modules/storage/AsyncStorageModule;)Lcom/facebook/react/modules/storage/ReactDatabaseSupplier;

    move-result-object v5

    invoke-virtual {v5}, Lcom/facebook/react/modules/storage/ReactDatabaseSupplier;->get()Landroid/database/sqlite/SQLiteDatabase;

    move-result-object v5

    invoke-virtual {v5}, Landroid/database/sqlite/SQLiteDatabase;->endTransaction()V
    :try_end_9
    .catch Ljava/lang/Exception; {:try_start_9 .. :try_end_9} :catch_5

    goto :goto_2

    .line 200
    :catch_5
    move-exception v0

    .line 201
    const-string v5, "ReactNative"

    invoke-virtual {v0}, Ljava/lang/Exception;->getMessage()Ljava/lang/String;

    move-result-object v6

    invoke-static {v5, v6, v0}, Lcom/facebook/common/logging/FLog;->w(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V

    .line 202
    if-nez v1, :cond_6

    .line 203
    invoke-virtual {v0}, Ljava/lang/Exception;->getMessage()Ljava/lang/String;

    move-result-object v5

    invoke-static {v8, v5}, Lcom/facebook/react/modules/storage/AsyncStorageErrorUtil;->getError(Ljava/lang/String;Ljava/lang/String;)Lcom/facebook/react/bridge/WritableMap;

    move-result-object v1

    goto :goto_2

    .line 198
    .end local v0    # "e":Ljava/lang/Exception;
    :catchall_0
    move-exception v5

    .line 199
    :try_start_a
    iget-object v6, p0, Lcom/facebook/react/modules/storage/AsyncStorageModule$2;->this$0:Lcom/facebook/react/modules/storage/AsyncStorageModule;

    invoke-static {v6}, Lcom/facebook/react/modules/storage/AsyncStorageModule;->access$100(Lcom/facebook/react/modules/storage/AsyncStorageModule;)Lcom/facebook/react/modules/storage/ReactDatabaseSupplier;

    move-result-object v6

    invoke-virtual {v6}, Lcom/facebook/react/modules/storage/ReactDatabaseSupplier;->get()Landroid/database/sqlite/SQLiteDatabase;

    move-result-object v6

    invoke-virtual {v6}, Landroid/database/sqlite/SQLiteDatabase;->endTransaction()V
    :try_end_a
    .catch Ljava/lang/Exception; {:try_start_a .. :try_end_a} :catch_6

    .line 205
    :cond_7
    :goto_3
    throw v5

    .line 200
    :catch_6
    move-exception v0

    .line 201
    .restart local v0    # "e":Ljava/lang/Exception;
    const-string v6, "ReactNative"

    invoke-virtual {v0}, Ljava/lang/Exception;->getMessage()Ljava/lang/String;

    move-result-object v7

    invoke-static {v6, v7, v0}, Lcom/facebook/common/logging/FLog;->w(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V

    .line 202
    if-nez v1, :cond_7

    .line 203
    invoke-virtual {v0}, Ljava/lang/Exception;->getMessage()Ljava/lang/String;

    move-result-object v6

    invoke-static {v8, v6}, Lcom/facebook/react/modules/storage/AsyncStorageErrorUtil;->getError(Ljava/lang/String;Ljava/lang/String;)Lcom/facebook/react/bridge/WritableMap;

    move-result-object v1

    goto :goto_3

    .line 210
    .end local v0    # "e":Ljava/lang/Exception;
    :cond_8
    iget-object v5, p0, Lcom/facebook/react/modules/storage/AsyncStorageModule$2;->val$callback:Lcom/facebook/react/bridge/Callback;

    new-array v6, v9, [Ljava/lang/Object;

    invoke-interface {v5, v6}, Lcom/facebook/react/bridge/Callback;->invoke([Ljava/lang/Object;)V

    goto/16 :goto_0
.end method

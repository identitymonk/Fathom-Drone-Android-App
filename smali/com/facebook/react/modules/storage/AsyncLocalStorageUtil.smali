.class public Lcom/facebook/react/modules/storage/AsyncLocalStorageUtil;
.super Ljava/lang/Object;
.source "AsyncLocalStorageUtil.java"


# direct methods
.method public constructor <init>()V
    .locals 0

    .prologue
    .line 34
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method

.method static buildKeySelection(I)Ljava/lang/String;
    .locals 3
    .param p0, "selectionCount"    # I

    .prologue
    .line 42
    new-array v0, p0, [Ljava/lang/String;

    .line 43
    .local v0, "list":[Ljava/lang/String;
    const-string v1, "?"

    invoke-static {v0, v1}, Ljava/util/Arrays;->fill([Ljava/lang/Object;Ljava/lang/Object;)V

    .line 44
    new-instance v1, Ljava/lang/StringBuilder;

    invoke-direct {v1}, Ljava/lang/StringBuilder;-><init>()V

    const-string v2, "key IN ("

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    const-string v2, ", "

    invoke-static {v2, v0}, Landroid/text/TextUtils;->join(Ljava/lang/CharSequence;[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    const-string v2, ")"

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    return-object v1
.end method

.method static buildKeySelectionArgs(Lcom/facebook/react/bridge/ReadableArray;II)[Ljava/lang/String;
    .locals 3
    .param p0, "keys"    # Lcom/facebook/react/bridge/ReadableArray;
    .param p1, "start"    # I
    .param p2, "count"    # I

    .prologue
    .line 53
    new-array v1, p2, [Ljava/lang/String;

    .line 54
    .local v1, "selectionArgs":[Ljava/lang/String;
    const/4 v0, 0x0

    .local v0, "keyIndex":I
    :goto_0
    if-ge v0, p2, :cond_0

    .line 55
    add-int v2, p1, v0

    invoke-interface {p0, v2}, Lcom/facebook/react/bridge/ReadableArray;->getString(I)Ljava/lang/String;

    move-result-object v2

    aput-object v2, v1, v0

    .line 54
    add-int/lit8 v0, v0, 0x1

    goto :goto_0

    .line 57
    :cond_0
    return-object v1
.end method

.method private static deepMergeInto(Lorg/json/JSONObject;Lorg/json/JSONObject;)V
    .locals 5
    .param p0, "oldJSON"    # Lorg/json/JSONObject;
    .param p1, "newJSON"    # Lorg/json/JSONObject;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Lorg/json/JSONException;
        }
    .end annotation

    .prologue
    .line 133
    invoke-virtual {p1}, Lorg/json/JSONObject;->keys()Ljava/util/Iterator;

    move-result-object v1

    .line 134
    .local v1, "keys":Ljava/util/Iterator;, "Ljava/util/Iterator<*>;"
    :goto_0
    invoke-interface {v1}, Ljava/util/Iterator;->hasNext()Z

    move-result v4

    if-eqz v4, :cond_1

    .line 135
    invoke-interface {v1}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Ljava/lang/String;

    .line 137
    .local v0, "key":Ljava/lang/String;
    invoke-virtual {p1, v0}, Lorg/json/JSONObject;->optJSONObject(Ljava/lang/String;)Lorg/json/JSONObject;

    move-result-object v2

    .line 138
    .local v2, "newJSONObject":Lorg/json/JSONObject;
    invoke-virtual {p0, v0}, Lorg/json/JSONObject;->optJSONObject(Ljava/lang/String;)Lorg/json/JSONObject;

    move-result-object v3

    .line 139
    .local v3, "oldJSONObject":Lorg/json/JSONObject;
    if-eqz v2, :cond_0

    if-eqz v3, :cond_0

    .line 140
    invoke-static {v3, v2}, Lcom/facebook/react/modules/storage/AsyncLocalStorageUtil;->deepMergeInto(Lorg/json/JSONObject;Lorg/json/JSONObject;)V

    .line 141
    invoke-virtual {p0, v0, v3}, Lorg/json/JSONObject;->put(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;

    goto :goto_0

    .line 143
    :cond_0
    invoke-virtual {p1, v0}, Lorg/json/JSONObject;->get(Ljava/lang/String;)Ljava/lang/Object;

    move-result-object v4

    invoke-virtual {p0, v0, v4}, Lorg/json/JSONObject;->put(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;

    goto :goto_0

    .line 146
    .end local v0    # "key":Ljava/lang/String;
    .end local v2    # "newJSONObject":Lorg/json/JSONObject;
    .end local v3    # "oldJSONObject":Lorg/json/JSONObject;
    :cond_1
    return-void
.end method

.method public static getItemImpl(Landroid/database/sqlite/SQLiteDatabase;Ljava/lang/String;)Ljava/lang/String;
    .locals 9
    .param p0, "db"    # Landroid/database/sqlite/SQLiteDatabase;
    .param p1, "key"    # Ljava/lang/String;
    .annotation runtime Ljavax/annotation/Nullable;
    .end annotation

    .prologue
    const/4 v3, 0x1

    const/4 v1, 0x0

    const/4 v5, 0x0

    .line 64
    new-array v2, v3, [Ljava/lang/String;

    const-string v0, "value"

    aput-object v0, v2, v1

    .line 65
    .local v2, "columns":[Ljava/lang/String;
    new-array v4, v3, [Ljava/lang/String;

    aput-object p1, v4, v1

    .line 67
    .local v4, "selectionArgs":[Ljava/lang/String;
    const-string v1, "catalystLocalStorage"

    const-string v3, "key=?"

    move-object v0, p0

    move-object v6, v5

    move-object v7, v5

    invoke-virtual/range {v0 .. v7}, Landroid/database/sqlite/SQLiteDatabase;->query(Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;

    move-result-object v8

    .line 77
    .local v8, "cursor":Landroid/database/Cursor;
    :try_start_0
    invoke-interface {v8}, Landroid/database/Cursor;->moveToFirst()Z
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    move-result v0

    if-nez v0, :cond_0

    .line 83
    invoke-interface {v8}, Landroid/database/Cursor;->close()V

    :goto_0
    return-object v5

    .line 80
    :cond_0
    const/4 v0, 0x0

    :try_start_1
    invoke-interface {v8, v0}, Landroid/database/Cursor;->getString(I)Ljava/lang/String;
    :try_end_1
    .catchall {:try_start_1 .. :try_end_1} :catchall_0

    move-result-object v5

    .line 83
    invoke-interface {v8}, Landroid/database/Cursor;->close()V

    goto :goto_0

    :catchall_0
    move-exception v0

    invoke-interface {v8}, Landroid/database/Cursor;->close()V

    throw v0
.end method

.method static mergeImpl(Landroid/database/sqlite/SQLiteDatabase;Ljava/lang/String;Ljava/lang/String;)Z
    .locals 5
    .param p0, "db"    # Landroid/database/sqlite/SQLiteDatabase;
    .param p1, "key"    # Ljava/lang/String;
    .param p2, "value"    # Ljava/lang/String;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Lorg/json/JSONException;
        }
    .end annotation

    .prologue
    .line 111
    invoke-static {p0, p1}, Lcom/facebook/react/modules/storage/AsyncLocalStorageUtil;->getItemImpl(Landroid/database/sqlite/SQLiteDatabase;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v3

    .line 114
    .local v3, "oldValue":Ljava/lang/String;
    if-nez v3, :cond_0

    .line 115
    move-object v1, p2

    .line 123
    .local v1, "newValue":Ljava/lang/String;
    :goto_0
    invoke-static {p0, p1, v1}, Lcom/facebook/react/modules/storage/AsyncLocalStorageUtil;->setItemImpl(Landroid/database/sqlite/SQLiteDatabase;Ljava/lang/String;Ljava/lang/String;)Z

    move-result v4

    return v4

    .line 117
    .end local v1    # "newValue":Ljava/lang/String;
    :cond_0
    new-instance v2, Lorg/json/JSONObject;

    invoke-direct {v2, v3}, Lorg/json/JSONObject;-><init>(Ljava/lang/String;)V

    .line 118
    .local v2, "oldJSON":Lorg/json/JSONObject;
    new-instance v0, Lorg/json/JSONObject;

    invoke-direct {v0, p2}, Lorg/json/JSONObject;-><init>(Ljava/lang/String;)V

    .line 119
    .local v0, "newJSON":Lorg/json/JSONObject;
    invoke-static {v2, v0}, Lcom/facebook/react/modules/storage/AsyncLocalStorageUtil;->deepMergeInto(Lorg/json/JSONObject;Lorg/json/JSONObject;)V

    .line 120
    invoke-virtual {v2}, Lorg/json/JSONObject;->toString()Ljava/lang/String;

    move-result-object v1

    .restart local v1    # "newValue":Ljava/lang/String;
    goto :goto_0
.end method

.method static setItemImpl(Landroid/database/sqlite/SQLiteDatabase;Ljava/lang/String;Ljava/lang/String;)Z
    .locals 6
    .param p0, "db"    # Landroid/database/sqlite/SQLiteDatabase;
    .param p1, "key"    # Ljava/lang/String;
    .param p2, "value"    # Ljava/lang/String;

    .prologue
    .line 91
    new-instance v0, Landroid/content/ContentValues;

    invoke-direct {v0}, Landroid/content/ContentValues;-><init>()V

    .line 92
    .local v0, "contentValues":Landroid/content/ContentValues;
    const-string v1, "key"

    invoke-virtual {v0, v1, p1}, Landroid/content/ContentValues;->put(Ljava/lang/String;Ljava/lang/String;)V

    .line 93
    const-string v1, "value"

    invoke-virtual {v0, v1, p2}, Landroid/content/ContentValues;->put(Ljava/lang/String;Ljava/lang/String;)V

    .line 95
    const-string v1, "catalystLocalStorage"

    const/4 v4, 0x0

    const/4 v5, 0x5

    invoke-virtual {p0, v1, v4, v0, v5}, Landroid/database/sqlite/SQLiteDatabase;->insertWithOnConflict(Ljava/lang/String;Ljava/lang/String;Landroid/content/ContentValues;I)J

    move-result-wide v2

    .line 101
    .local v2, "inserted":J
    const-wide/16 v4, -0x1

    cmp-long v1, v4, v2

    if-eqz v1, :cond_0

    const/4 v1, 0x1

    :goto_0
    return v1

    :cond_0
    const/4 v1, 0x0

    goto :goto_0
.end method

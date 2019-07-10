.class public Lcom/facebook/imagepipeline/cache/MediaVariationsIndexDatabase;
.super Ljava/lang/Object;
.source "MediaVariationsIndexDatabase.java"

# interfaces
.implements Lcom/facebook/imagepipeline/cache/MediaVariationsIndex;


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lcom/facebook/imagepipeline/cache/MediaVariationsIndexDatabase$IndexDbOpenHelper;,
        Lcom/facebook/imagepipeline/cache/MediaVariationsIndexDatabase$LazyIndexDbOpenHelper;,
        Lcom/facebook/imagepipeline/cache/MediaVariationsIndexDatabase$IndexEntry;
    }
.end annotation


# static fields
.field private static final PROJECTION:[Ljava/lang/String;

.field private static final SQL_DELETE_ENTRIES:Ljava/lang/String; = "DROP TABLE IF EXISTS media_variations_index"

.field private static final TAG:Ljava/lang/String;


# instance fields
.field private final mDbHelper:Lcom/facebook/imagepipeline/cache/MediaVariationsIndexDatabase$LazyIndexDbOpenHelper;
    .annotation build Ljavax/annotation/concurrent/GuardedBy;
        value = "MediaVariationsIndexDatabase.class"
    .end annotation
.end field

.field private final mReadExecutor:Ljava/util/concurrent/Executor;

.field private final mWriteExecutor:Ljava/util/concurrent/Executor;


# direct methods
.method static constructor <clinit>()V
    .locals 3

    .prologue
    .line 40
    const-class v0, Lcom/facebook/imagepipeline/cache/MediaVariationsIndexDatabase;

    invoke-virtual {v0}, Ljava/lang/Class;->getSimpleName()Ljava/lang/String;

    move-result-object v0

    sput-object v0, Lcom/facebook/imagepipeline/cache/MediaVariationsIndexDatabase;->TAG:Ljava/lang/String;

    .line 42
    const/4 v0, 0x4

    new-array v0, v0, [Ljava/lang/String;

    const/4 v1, 0x0

    const-string v2, "cache_choice"

    aput-object v2, v0, v1

    const/4 v1, 0x1

    const-string v2, "cache_key"

    aput-object v2, v0, v1

    const/4 v1, 0x2

    const-string v2, "width"

    aput-object v2, v0, v1

    const/4 v1, 0x3

    const-string v2, "height"

    aput-object v2, v0, v1

    sput-object v0, Lcom/facebook/imagepipeline/cache/MediaVariationsIndexDatabase;->PROJECTION:[Ljava/lang/String;

    return-void
.end method

.method public constructor <init>(Landroid/content/Context;Ljava/util/concurrent/Executor;Ljava/util/concurrent/Executor;)V
    .locals 2
    .param p1, "context"    # Landroid/content/Context;
    .param p2, "readExecutor"    # Ljava/util/concurrent/Executor;
    .param p3, "writeExecutor"    # Ljava/util/concurrent/Executor;

    .prologue
    .line 59
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 60
    new-instance v0, Lcom/facebook/imagepipeline/cache/MediaVariationsIndexDatabase$LazyIndexDbOpenHelper;

    const/4 v1, 0x0

    invoke-direct {v0, p1, v1}, Lcom/facebook/imagepipeline/cache/MediaVariationsIndexDatabase$LazyIndexDbOpenHelper;-><init>(Landroid/content/Context;Lcom/facebook/imagepipeline/cache/MediaVariationsIndexDatabase$1;)V

    iput-object v0, p0, Lcom/facebook/imagepipeline/cache/MediaVariationsIndexDatabase;->mDbHelper:Lcom/facebook/imagepipeline/cache/MediaVariationsIndexDatabase$LazyIndexDbOpenHelper;

    .line 61
    iput-object p2, p0, Lcom/facebook/imagepipeline/cache/MediaVariationsIndexDatabase;->mReadExecutor:Ljava/util/concurrent/Executor;

    .line 62
    iput-object p3, p0, Lcom/facebook/imagepipeline/cache/MediaVariationsIndexDatabase;->mWriteExecutor:Ljava/util/concurrent/Executor;

    .line 63
    return-void
.end method


# virtual methods
.method public getCachedVariants(Ljava/lang/String;Lcom/facebook/imagepipeline/request/MediaVariations$Builder;)Lbolts/Task;
    .locals 5
    .param p1, "mediaId"    # Ljava/lang/String;
    .param p2, "mediaVariationsBuilder"    # Lcom/facebook/imagepipeline/request/MediaVariations$Builder;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/lang/String;",
            "Lcom/facebook/imagepipeline/request/MediaVariations$Builder;",
            ")",
            "Lbolts/Task",
            "<",
            "Lcom/facebook/imagepipeline/request/MediaVariations;",
            ">;"
        }
    .end annotation

    .prologue
    .line 70
    :try_start_0
    new-instance v1, Lcom/facebook/imagepipeline/cache/MediaVariationsIndexDatabase$1;

    invoke-direct {v1, p0, p1, p2}, Lcom/facebook/imagepipeline/cache/MediaVariationsIndexDatabase$1;-><init>(Lcom/facebook/imagepipeline/cache/MediaVariationsIndexDatabase;Ljava/lang/String;Lcom/facebook/imagepipeline/request/MediaVariations$Builder;)V

    iget-object v2, p0, Lcom/facebook/imagepipeline/cache/MediaVariationsIndexDatabase;->mReadExecutor:Ljava/util/concurrent/Executor;

    invoke-static {v1, v2}, Lbolts/Task;->call(Ljava/util/concurrent/Callable;Ljava/util/concurrent/Executor;)Lbolts/Task;
    :try_end_0
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_0

    move-result-object v1

    .line 80
    :goto_0
    return-object v1

    .line 78
    :catch_0
    move-exception v0

    .line 79
    .local v0, "exception":Ljava/lang/Exception;
    sget-object v1, Lcom/facebook/imagepipeline/cache/MediaVariationsIndexDatabase;->TAG:Ljava/lang/String;

    const-string v2, "Failed to schedule query task for %s"

    const/4 v3, 0x1

    new-array v3, v3, [Ljava/lang/Object;

    const/4 v4, 0x0

    aput-object p1, v3, v4

    invoke-static {v1, v0, v2, v3}, Lcom/facebook/common/logging/FLog;->w(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V

    .line 80
    invoke-static {v0}, Lbolts/Task;->forError(Ljava/lang/Exception;)Lbolts/Task;

    move-result-object v1

    goto :goto_0
.end method

.method protected getCachedVariantsSync(Ljava/lang/String;Lcom/facebook/imagepipeline/request/MediaVariations$Builder;)Lcom/facebook/imagepipeline/request/MediaVariations;
    .locals 17
    .param p1, "mediaId"    # Ljava/lang/String;
    .param p2, "mediaVariationsBuilder"    # Lcom/facebook/imagepipeline/request/MediaVariations$Builder;
    .annotation build Lcom/facebook/common/internal/VisibleForTesting;
    .end annotation

    .prologue
    .line 88
    const-class v16, Lcom/facebook/imagepipeline/cache/MediaVariationsIndexDatabase;

    monitor-enter v16

    .line 89
    :try_start_0
    move-object/from16 v0, p0

    iget-object v2, v0, Lcom/facebook/imagepipeline/cache/MediaVariationsIndexDatabase;->mDbHelper:Lcom/facebook/imagepipeline/cache/MediaVariationsIndexDatabase$LazyIndexDbOpenHelper;

    invoke-virtual {v2}, Lcom/facebook/imagepipeline/cache/MediaVariationsIndexDatabase$LazyIndexDbOpenHelper;->getWritableDatabase()Landroid/database/sqlite/SQLiteDatabase;
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_1

    move-result-object v1

    .line 90
    .local v1, "db":Landroid/database/sqlite/SQLiteDatabase;
    const/4 v9, 0x0

    .line 92
    .local v9, "c":Landroid/database/Cursor;
    :try_start_1
    const-string v4, "media_id = ?"

    .line 93
    .local v4, "selection":Ljava/lang/String;
    const/4 v2, 0x1

    new-array v5, v2, [Ljava/lang/String;

    const/4 v2, 0x0

    aput-object p1, v5, v2

    .line 95
    .local v5, "selectionArgs":[Ljava/lang/String;
    const-string v2, "media_variations_index"

    sget-object v3, Lcom/facebook/imagepipeline/cache/MediaVariationsIndexDatabase;->PROJECTION:[Ljava/lang/String;

    const/4 v6, 0x0

    const/4 v7, 0x0

    const/4 v8, 0x0

    invoke-virtual/range {v1 .. v8}, Landroid/database/sqlite/SQLiteDatabase;->query(Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;

    move-result-object v9

    .line 104
    invoke-interface {v9}, Landroid/database/Cursor;->getCount()I

    move-result v2

    if-nez v2, :cond_1

    .line 105
    invoke-virtual/range {p2 .. p2}, Lcom/facebook/imagepipeline/request/MediaVariations$Builder;->build()Lcom/facebook/imagepipeline/request/MediaVariations;
    :try_end_1
    .catch Landroid/database/SQLException; {:try_start_1 .. :try_end_1} :catch_0
    .catchall {:try_start_1 .. :try_end_1} :catchall_0

    move-result-object v2

    .line 130
    if-eqz v9, :cond_0

    .line 131
    :try_start_2
    invoke-interface {v9}, Landroid/database/Cursor;->close()V

    :cond_0
    monitor-exit v16
    :try_end_2
    .catchall {:try_start_2 .. :try_end_2} :catchall_1

    :goto_0
    return-object v2

    .line 108
    :cond_1
    :try_start_3
    const-string v2, "cache_key"

    invoke-interface {v9, v2}, Landroid/database/Cursor;->getColumnIndexOrThrow(Ljava/lang/String;)I

    move-result v12

    .line 109
    .local v12, "columnIndexCacheKey":I
    const-string v2, "width"

    invoke-interface {v9, v2}, Landroid/database/Cursor;->getColumnIndexOrThrow(Ljava/lang/String;)I

    move-result v14

    .line 110
    .local v14, "columnIndexWidth":I
    const-string v2, "height"

    invoke-interface {v9, v2}, Landroid/database/Cursor;->getColumnIndexOrThrow(Ljava/lang/String;)I

    move-result v13

    .line 111
    .local v13, "columnIndexHeight":I
    const-string v2, "cache_choice"

    .line 112
    invoke-interface {v9, v2}, Landroid/database/Cursor;->getColumnIndexOrThrow(Ljava/lang/String;)I

    move-result v11

    .line 114
    .local v11, "columnIndexCacheChoice":I
    :goto_1
    invoke-interface {v9}, Landroid/database/Cursor;->moveToNext()Z

    move-result v2

    if-eqz v2, :cond_4

    .line 115
    invoke-interface {v9, v11}, Landroid/database/Cursor;->getString(I)Ljava/lang/String;

    move-result-object v10

    .line 118
    .local v10, "cacheChoiceStr":Ljava/lang/String;
    invoke-interface {v9, v12}, Landroid/database/Cursor;->getString(I)Ljava/lang/String;

    move-result-object v2

    invoke-static {v2}, Landroid/net/Uri;->parse(Ljava/lang/String;)Landroid/net/Uri;

    move-result-object v3

    .line 119
    invoke-interface {v9, v14}, Landroid/database/Cursor;->getInt(I)I

    move-result v6

    .line 120
    invoke-interface {v9, v13}, Landroid/database/Cursor;->getInt(I)I

    move-result v7

    .line 121
    invoke-static {v10}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result v2

    if-eqz v2, :cond_3

    const/4 v2, 0x0

    .line 117
    :goto_2
    move-object/from16 v0, p2

    invoke-virtual {v0, v3, v6, v7, v2}, Lcom/facebook/imagepipeline/request/MediaVariations$Builder;->addVariant(Landroid/net/Uri;IILcom/facebook/imagepipeline/request/ImageRequest$CacheChoice;)Lcom/facebook/imagepipeline/request/MediaVariations$Builder;
    :try_end_3
    .catch Landroid/database/SQLException; {:try_start_3 .. :try_end_3} :catch_0
    .catchall {:try_start_3 .. :try_end_3} :catchall_0

    goto :goto_1

    .line 126
    .end local v4    # "selection":Ljava/lang/String;
    .end local v5    # "selectionArgs":[Ljava/lang/String;
    .end local v10    # "cacheChoiceStr":Ljava/lang/String;
    .end local v11    # "columnIndexCacheChoice":I
    .end local v12    # "columnIndexCacheKey":I
    .end local v13    # "columnIndexHeight":I
    .end local v14    # "columnIndexWidth":I
    :catch_0
    move-exception v15

    .line 127
    .local v15, "x":Landroid/database/SQLException;
    :try_start_4
    sget-object v2, Lcom/facebook/imagepipeline/cache/MediaVariationsIndexDatabase;->TAG:Ljava/lang/String;

    const-string v3, "Error reading for %s"

    const/4 v6, 0x1

    new-array v6, v6, [Ljava/lang/Object;

    const/4 v7, 0x0

    aput-object p1, v6, v7

    invoke-static {v2, v15, v3, v6}, Lcom/facebook/common/logging/FLog;->e(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V

    .line 128
    throw v15
    :try_end_4
    .catchall {:try_start_4 .. :try_end_4} :catchall_0

    .line 130
    .end local v15    # "x":Landroid/database/SQLException;
    :catchall_0
    move-exception v2

    if-eqz v9, :cond_2

    .line 131
    :try_start_5
    invoke-interface {v9}, Landroid/database/Cursor;->close()V

    :cond_2
    throw v2

    .line 134
    .end local v1    # "db":Landroid/database/sqlite/SQLiteDatabase;
    .end local v9    # "c":Landroid/database/Cursor;
    :catchall_1
    move-exception v2

    monitor-exit v16
    :try_end_5
    .catchall {:try_start_5 .. :try_end_5} :catchall_1

    throw v2

    .line 122
    .restart local v1    # "db":Landroid/database/sqlite/SQLiteDatabase;
    .restart local v4    # "selection":Ljava/lang/String;
    .restart local v5    # "selectionArgs":[Ljava/lang/String;
    .restart local v9    # "c":Landroid/database/Cursor;
    .restart local v10    # "cacheChoiceStr":Ljava/lang/String;
    .restart local v11    # "columnIndexCacheChoice":I
    .restart local v12    # "columnIndexCacheKey":I
    .restart local v13    # "columnIndexHeight":I
    .restart local v14    # "columnIndexWidth":I
    :cond_3
    :try_start_6
    invoke-static {v10}, Lcom/facebook/imagepipeline/request/ImageRequest$CacheChoice;->valueOf(Ljava/lang/String;)Lcom/facebook/imagepipeline/request/ImageRequest$CacheChoice;

    move-result-object v2

    goto :goto_2

    .line 125
    .end local v10    # "cacheChoiceStr":Ljava/lang/String;
    :cond_4
    invoke-virtual/range {p2 .. p2}, Lcom/facebook/imagepipeline/request/MediaVariations$Builder;->build()Lcom/facebook/imagepipeline/request/MediaVariations;
    :try_end_6
    .catch Landroid/database/SQLException; {:try_start_6 .. :try_end_6} :catch_0
    .catchall {:try_start_6 .. :try_end_6} :catchall_0

    move-result-object v2

    .line 130
    if-eqz v9, :cond_5

    .line 131
    :try_start_7
    invoke-interface {v9}, Landroid/database/Cursor;->close()V

    :cond_5
    monitor-exit v16
    :try_end_7
    .catchall {:try_start_7 .. :try_end_7} :catchall_1

    goto :goto_0
.end method

.method public saveCachedVariant(Ljava/lang/String;Lcom/facebook/imagepipeline/request/ImageRequest$CacheChoice;Lcom/facebook/cache/common/CacheKey;Lcom/facebook/imagepipeline/image/EncodedImage;)V
    .locals 7
    .param p1, "mediaId"    # Ljava/lang/String;
    .param p2, "cacheChoice"    # Lcom/facebook/imagepipeline/request/ImageRequest$CacheChoice;
    .param p3, "cacheKey"    # Lcom/facebook/cache/common/CacheKey;
    .param p4, "encodedImage"    # Lcom/facebook/imagepipeline/image/EncodedImage;

    .prologue
    .line 143
    iget-object v6, p0, Lcom/facebook/imagepipeline/cache/MediaVariationsIndexDatabase;->mWriteExecutor:Ljava/util/concurrent/Executor;

    new-instance v0, Lcom/facebook/imagepipeline/cache/MediaVariationsIndexDatabase$2;

    move-object v1, p0

    move-object v2, p1

    move-object v3, p2

    move-object v4, p3

    move-object v5, p4

    invoke-direct/range {v0 .. v5}, Lcom/facebook/imagepipeline/cache/MediaVariationsIndexDatabase$2;-><init>(Lcom/facebook/imagepipeline/cache/MediaVariationsIndexDatabase;Ljava/lang/String;Lcom/facebook/imagepipeline/request/ImageRequest$CacheChoice;Lcom/facebook/cache/common/CacheKey;Lcom/facebook/imagepipeline/image/EncodedImage;)V

    invoke-interface {v6, v0}, Ljava/util/concurrent/Executor;->execute(Ljava/lang/Runnable;)V

    .line 149
    return-void
.end method

.method protected saveCachedVariantSync(Ljava/lang/String;Lcom/facebook/imagepipeline/request/ImageRequest$CacheChoice;Lcom/facebook/cache/common/CacheKey;Lcom/facebook/imagepipeline/image/EncodedImage;)V
    .locals 8
    .param p1, "mediaId"    # Ljava/lang/String;
    .param p2, "cacheChoice"    # Lcom/facebook/imagepipeline/request/ImageRequest$CacheChoice;
    .param p3, "cacheKey"    # Lcom/facebook/cache/common/CacheKey;
    .param p4, "encodedImage"    # Lcom/facebook/imagepipeline/image/EncodedImage;

    .prologue
    .line 156
    const-class v4, Lcom/facebook/imagepipeline/cache/MediaVariationsIndexDatabase;

    monitor-enter v4

    .line 157
    :try_start_0
    iget-object v3, p0, Lcom/facebook/imagepipeline/cache/MediaVariationsIndexDatabase;->mDbHelper:Lcom/facebook/imagepipeline/cache/MediaVariationsIndexDatabase$LazyIndexDbOpenHelper;

    invoke-virtual {v3}, Lcom/facebook/imagepipeline/cache/MediaVariationsIndexDatabase$LazyIndexDbOpenHelper;->getWritableDatabase()Landroid/database/sqlite/SQLiteDatabase;
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    move-result-object v1

    .line 159
    .local v1, "db":Landroid/database/sqlite/SQLiteDatabase;
    :try_start_1
    invoke-virtual {v1}, Landroid/database/sqlite/SQLiteDatabase;->beginTransaction()V

    .line 161
    new-instance v0, Landroid/content/ContentValues;

    invoke-direct {v0}, Landroid/content/ContentValues;-><init>()V

    .line 162
    .local v0, "contentValues":Landroid/content/ContentValues;
    const-string v3, "media_id"

    invoke-virtual {v0, v3, p1}, Landroid/content/ContentValues;->put(Ljava/lang/String;Ljava/lang/String;)V

    .line 163
    const-string v3, "width"

    invoke-virtual {p4}, Lcom/facebook/imagepipeline/image/EncodedImage;->getWidth()I

    move-result v5

    invoke-static {v5}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v5

    invoke-virtual {v0, v3, v5}, Landroid/content/ContentValues;->put(Ljava/lang/String;Ljava/lang/Integer;)V

    .line 164
    const-string v3, "height"

    invoke-virtual {p4}, Lcom/facebook/imagepipeline/image/EncodedImage;->getHeight()I

    move-result v5

    invoke-static {v5}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v5

    invoke-virtual {v0, v3, v5}, Landroid/content/ContentValues;->put(Ljava/lang/String;Ljava/lang/Integer;)V

    .line 165
    const-string v3, "cache_choice"

    invoke-virtual {p2}, Lcom/facebook/imagepipeline/request/ImageRequest$CacheChoice;->name()Ljava/lang/String;

    move-result-object v5

    invoke-virtual {v0, v3, v5}, Landroid/content/ContentValues;->put(Ljava/lang/String;Ljava/lang/String;)V

    .line 166
    const-string v3, "cache_key"

    invoke-interface {p3}, Lcom/facebook/cache/common/CacheKey;->getUriString()Ljava/lang/String;

    move-result-object v5

    invoke-virtual {v0, v3, v5}, Landroid/content/ContentValues;->put(Ljava/lang/String;Ljava/lang/String;)V

    .line 167
    const-string v3, "resource_id"

    .line 168
    invoke-static {p3}, Lcom/facebook/cache/common/CacheKeyUtil;->getFirstResourceId(Lcom/facebook/cache/common/CacheKey;)Ljava/lang/String;

    move-result-object v5

    invoke-virtual {v0, v3, v5}, Landroid/content/ContentValues;->put(Ljava/lang/String;Ljava/lang/String;)V

    .line 170
    const-string v3, "media_variations_index"

    const/4 v5, 0x0

    invoke-virtual {v1, v3, v5, v0}, Landroid/database/sqlite/SQLiteDatabase;->replaceOrThrow(Ljava/lang/String;Ljava/lang/String;Landroid/content/ContentValues;)J

    .line 172
    invoke-virtual {v1}, Landroid/database/sqlite/SQLiteDatabase;->setTransactionSuccessful()V
    :try_end_1
    .catch Ljava/lang/Exception; {:try_start_1 .. :try_end_1} :catch_0
    .catchall {:try_start_1 .. :try_end_1} :catchall_1

    .line 176
    :try_start_2
    invoke-virtual {v1}, Landroid/database/sqlite/SQLiteDatabase;->endTransaction()V

    .line 178
    .end local v0    # "contentValues":Landroid/content/ContentValues;
    :goto_0
    monitor-exit v4
    :try_end_2
    .catchall {:try_start_2 .. :try_end_2} :catchall_0

    .line 179
    return-void

    .line 173
    :catch_0
    move-exception v2

    .line 174
    .local v2, "x":Ljava/lang/Exception;
    :try_start_3
    sget-object v3, Lcom/facebook/imagepipeline/cache/MediaVariationsIndexDatabase;->TAG:Ljava/lang/String;

    const-string v5, "Error writing for %s"

    const/4 v6, 0x1

    new-array v6, v6, [Ljava/lang/Object;

    const/4 v7, 0x0

    aput-object p1, v6, v7

    invoke-static {v3, v2, v5, v6}, Lcom/facebook/common/logging/FLog;->e(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    :try_end_3
    .catchall {:try_start_3 .. :try_end_3} :catchall_1

    .line 176
    :try_start_4
    invoke-virtual {v1}, Landroid/database/sqlite/SQLiteDatabase;->endTransaction()V

    goto :goto_0

    .line 178
    .end local v1    # "db":Landroid/database/sqlite/SQLiteDatabase;
    .end local v2    # "x":Ljava/lang/Exception;
    :catchall_0
    move-exception v3

    monitor-exit v4
    :try_end_4
    .catchall {:try_start_4 .. :try_end_4} :catchall_0

    throw v3

    .line 176
    .restart local v1    # "db":Landroid/database/sqlite/SQLiteDatabase;
    :catchall_1
    move-exception v3

    :try_start_5
    invoke-virtual {v1}, Landroid/database/sqlite/SQLiteDatabase;->endTransaction()V

    throw v3
    :try_end_5
    .catchall {:try_start_5 .. :try_end_5} :catchall_0
.end method

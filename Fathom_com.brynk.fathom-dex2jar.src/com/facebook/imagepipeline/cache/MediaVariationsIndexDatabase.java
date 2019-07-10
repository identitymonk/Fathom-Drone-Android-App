package com.facebook.imagepipeline.cache;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.net.Uri;
import android.provider.BaseColumns;
import android.text.TextUtils;
import bolts.Task;
import com.facebook.cache.common.CacheKey;
import com.facebook.common.internal.VisibleForTesting;
import com.facebook.common.logging.FLog;
import com.facebook.imagepipeline.image.EncodedImage;
import com.facebook.imagepipeline.request.ImageRequest.CacheChoice;
import com.facebook.imagepipeline.request.MediaVariations;
import com.facebook.imagepipeline.request.MediaVariations.Builder;
import java.util.concurrent.Callable;
import java.util.concurrent.Executor;
import javax.annotation.Nullable;
import javax.annotation.concurrent.GuardedBy;

public class MediaVariationsIndexDatabase
  implements MediaVariationsIndex
{
  private static final String[] PROJECTION;
  private static final String SQL_DELETE_ENTRIES = "DROP TABLE IF EXISTS media_variations_index";
  private static final String TAG = MediaVariationsIndexDatabase.class.getSimpleName();

  @GuardedBy("MediaVariationsIndexDatabase.class")
  private final LazyIndexDbOpenHelper mDbHelper;
  private final Executor mReadExecutor;
  private final Executor mWriteExecutor;

  static
  {
    PROJECTION = new String[] { "cache_choice", "cache_key", "width", "height" };
  }

  public MediaVariationsIndexDatabase(Context paramContext, Executor paramExecutor1, Executor paramExecutor2)
  {
    this.mDbHelper = new LazyIndexDbOpenHelper(paramContext, null);
    this.mReadExecutor = paramExecutor1;
    this.mWriteExecutor = paramExecutor2;
  }

  public Task<MediaVariations> getCachedVariants(String paramString, MediaVariations.Builder paramBuilder)
  {
    try
    {
      paramBuilder = Task.call(new Callable(paramString, paramBuilder)
      {
        public MediaVariations call()
          throws Exception
        {
          return MediaVariationsIndexDatabase.this.getCachedVariantsSync(this.val$mediaId, this.val$mediaVariationsBuilder);
        }
      }
      , this.mReadExecutor);
      return paramBuilder;
    }
    catch (Exception paramBuilder)
    {
      FLog.w(TAG, paramBuilder, "Failed to schedule query task for %s", new Object[] { paramString });
    }
    return Task.forError(paramBuilder);
  }

  @VisibleForTesting
  protected MediaVariations getCachedVariantsSync(String paramString, MediaVariations.Builder paramBuilder)
  {
    monitorenter;
    Object localObject3;
    while (true)
    {
      try
      {
        localObject3 = this.mDbHelper.getWritableDatabase();
        localObject2 = null;
        localObject1 = null;
        try
        {
          localObject3 = ((SQLiteDatabase)localObject3).query("media_variations_index", PROJECTION, "media_id = ?", new String[] { paramString }, null, null, null);
          localObject1 = localObject3;
          localObject2 = localObject3;
          if (((Cursor)localObject3).getCount() != 0)
            continue;
          localObject1 = localObject3;
          localObject2 = localObject3;
          paramBuilder = paramBuilder.build();
          if (localObject3 == null)
            continue;
          ((Cursor)localObject3).close();
          monitorexit;
          return paramBuilder;
          localObject1 = localObject3;
          localObject2 = localObject3;
          int i = ((Cursor)localObject3).getColumnIndexOrThrow("cache_key");
          localObject1 = localObject3;
          localObject2 = localObject3;
          int j = ((Cursor)localObject3).getColumnIndexOrThrow("width");
          localObject1 = localObject3;
          localObject2 = localObject3;
          int k = ((Cursor)localObject3).getColumnIndexOrThrow("height");
          localObject1 = localObject3;
          localObject2 = localObject3;
          int m = ((Cursor)localObject3).getColumnIndexOrThrow("cache_choice");
          localObject1 = localObject3;
          localObject2 = localObject3;
          if (!((Cursor)localObject3).moveToNext())
            break;
          localObject1 = localObject3;
          localObject2 = localObject3;
          localObject4 = ((Cursor)localObject3).getString(m);
          localObject1 = localObject3;
          localObject2 = localObject3;
          Uri localUri = Uri.parse(((Cursor)localObject3).getString(i));
          localObject1 = localObject3;
          localObject2 = localObject3;
          int n = ((Cursor)localObject3).getInt(j);
          localObject1 = localObject3;
          localObject2 = localObject3;
          int i1 = ((Cursor)localObject3).getInt(k);
          localObject1 = localObject3;
          localObject2 = localObject3;
          if (TextUtils.isEmpty((CharSequence)localObject4))
          {
            localObject4 = null;
            localObject1 = localObject3;
            localObject2 = localObject3;
            paramBuilder.addVariant(localUri, n, i1, (ImageRequest.CacheChoice)localObject4);
            continue;
          }
        }
        catch (android.database.SQLException paramBuilder)
        {
          localObject2 = localObject1;
          FLog.e(TAG, paramBuilder, "Error reading for %s", new Object[] { paramString });
          localObject2 = localObject1;
          throw paramBuilder;
        }
        finally
        {
          if (localObject2 == null)
            continue;
          localObject2.close();
        }
      }
      finally
      {
        monitorexit;
      }
      localObject1 = localObject3;
      localObject2 = localObject3;
      Object localObject4 = ImageRequest.CacheChoice.valueOf((String)localObject4);
    }
    Object localObject1 = localObject3;
    Object localObject2 = localObject3;
    paramBuilder = paramBuilder.build();
    if (localObject3 != null)
      ((Cursor)localObject3).close();
    monitorexit;
    return (MediaVariations)(MediaVariations)paramBuilder;
  }

  public void saveCachedVariant(String paramString, ImageRequest.CacheChoice paramCacheChoice, CacheKey paramCacheKey, EncodedImage paramEncodedImage)
  {
    this.mWriteExecutor.execute(new Runnable(paramString, paramCacheChoice, paramCacheKey, paramEncodedImage)
    {
      public void run()
      {
        MediaVariationsIndexDatabase.this.saveCachedVariantSync(this.val$mediaId, this.val$cacheChoice, this.val$cacheKey, this.val$encodedImage);
      }
    });
  }

  // ERROR //
  protected void saveCachedVariantSync(String paramString, ImageRequest.CacheChoice paramCacheChoice, CacheKey paramCacheKey, EncodedImage paramEncodedImage)
  {
    // Byte code:
    //   0: ldc 2
    //   2: monitorenter
    //   3: aload_0
    //   4: getfield 66	com/facebook/imagepipeline/cache/MediaVariationsIndexDatabase:mDbHelper	Lcom/facebook/imagepipeline/cache/MediaVariationsIndexDatabase$LazyIndexDbOpenHelper;
    //   7: invokevirtual 106	com/facebook/imagepipeline/cache/MediaVariationsIndexDatabase$LazyIndexDbOpenHelper:getWritableDatabase	()Landroid/database/sqlite/SQLiteDatabase;
    //   10: astore 5
    //   12: aload 5
    //   14: invokevirtual 190	android/database/sqlite/SQLiteDatabase:beginTransaction	()V
    //   17: new 192	android/content/ContentValues
    //   20: dup
    //   21: invokespecial 193	android/content/ContentValues:<init>	()V
    //   24: astore 6
    //   26: aload 6
    //   28: ldc 195
    //   30: aload_1
    //   31: invokevirtual 199	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/String;)V
    //   34: aload 6
    //   36: ldc 52
    //   38: aload 4
    //   40: invokevirtual 204	com/facebook/imagepipeline/image/EncodedImage:getWidth	()I
    //   43: invokestatic 209	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   46: invokevirtual 212	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/Integer;)V
    //   49: aload 6
    //   51: ldc 54
    //   53: aload 4
    //   55: invokevirtual 215	com/facebook/imagepipeline/image/EncodedImage:getHeight	()I
    //   58: invokestatic 209	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   61: invokevirtual 212	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/Integer;)V
    //   64: aload 6
    //   66: ldc 48
    //   68: aload_2
    //   69: invokevirtual 218	com/facebook/imagepipeline/request/ImageRequest$CacheChoice:name	()Ljava/lang/String;
    //   72: invokevirtual 199	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/String;)V
    //   75: aload 6
    //   77: ldc 50
    //   79: aload_3
    //   80: invokeinterface 223 1 0
    //   85: invokevirtual 199	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/String;)V
    //   88: aload 6
    //   90: ldc 225
    //   92: aload_3
    //   93: invokestatic 231	com/facebook/cache/common/CacheKeyUtil:getFirstResourceId	(Lcom/facebook/cache/common/CacheKey;)Ljava/lang/String;
    //   96: invokevirtual 199	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/String;)V
    //   99: aload 5
    //   101: ldc 108
    //   103: aconst_null
    //   104: aload 6
    //   106: invokevirtual 235	android/database/sqlite/SQLiteDatabase:replaceOrThrow	(Ljava/lang/String;Ljava/lang/String;Landroid/content/ContentValues;)J
    //   109: pop2
    //   110: aload 5
    //   112: invokevirtual 238	android/database/sqlite/SQLiteDatabase:setTransactionSuccessful	()V
    //   115: aload 5
    //   117: invokevirtual 241	android/database/sqlite/SQLiteDatabase:endTransaction	()V
    //   120: ldc 2
    //   122: monitorexit
    //   123: return
    //   124: astore_2
    //   125: getstatic 44	com/facebook/imagepipeline/cache/MediaVariationsIndexDatabase:TAG	Ljava/lang/String;
    //   128: aload_2
    //   129: ldc 243
    //   131: iconst_1
    //   132: anewarray 4	java/lang/Object
    //   135: dup
    //   136: iconst_0
    //   137: aload_1
    //   138: aastore
    //   139: invokestatic 168	com/facebook/common/logging/FLog:e	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   142: aload 5
    //   144: invokevirtual 241	android/database/sqlite/SQLiteDatabase:endTransaction	()V
    //   147: goto -27 -> 120
    //   150: astore_1
    //   151: ldc 2
    //   153: monitorexit
    //   154: aload_1
    //   155: athrow
    //   156: astore_1
    //   157: aload 5
    //   159: invokevirtual 241	android/database/sqlite/SQLiteDatabase:endTransaction	()V
    //   162: aload_1
    //   163: athrow
    //
    // Exception table:
    //   from	to	target	type
    //   12	115	124	java/lang/Exception
    //   3	12	150	finally
    //   115	120	150	finally
    //   120	123	150	finally
    //   142	147	150	finally
    //   151	154	150	finally
    //   157	164	150	finally
    //   12	115	156	finally
    //   125	142	156	finally
  }

  private static class IndexDbOpenHelper extends SQLiteOpenHelper
  {
    public static final String DATABASE_NAME = "FrescoMediaVariationsIndex.db";
    public static final int DATABASE_VERSION = 2;
    private static final String INTEGER_TYPE = " INTEGER";
    private static final String SQL_CREATE_ENTRIES = "CREATE TABLE media_variations_index (_id INTEGER PRIMARY KEY,media_id TEXT,width INTEGER,height INTEGER,cache_choice TEXT,cache_key TEXT,resource_id TEXT UNIQUE )";
    private static final String SQL_CREATE_INDEX = "CREATE INDEX index_media_id ON media_variations_index (media_id)";
    private static final String TEXT_TYPE = " TEXT";

    public IndexDbOpenHelper(Context paramContext)
    {
      super("FrescoMediaVariationsIndex.db", null, 2);
    }

    public void onCreate(SQLiteDatabase paramSQLiteDatabase)
    {
      paramSQLiteDatabase.beginTransaction();
      try
      {
        paramSQLiteDatabase.execSQL("CREATE TABLE media_variations_index (_id INTEGER PRIMARY KEY,media_id TEXT,width INTEGER,height INTEGER,cache_choice TEXT,cache_key TEXT,resource_id TEXT UNIQUE )");
        paramSQLiteDatabase.execSQL("CREATE INDEX index_media_id ON media_variations_index (media_id)");
        paramSQLiteDatabase.setTransactionSuccessful();
        return;
      }
      finally
      {
        paramSQLiteDatabase.endTransaction();
      }
      throw localObject;
    }

    public void onDowngrade(SQLiteDatabase paramSQLiteDatabase, int paramInt1, int paramInt2)
    {
      onUpgrade(paramSQLiteDatabase, paramInt1, paramInt2);
    }

    public void onUpgrade(SQLiteDatabase paramSQLiteDatabase, int paramInt1, int paramInt2)
    {
      paramSQLiteDatabase.beginTransaction();
      try
      {
        paramSQLiteDatabase.execSQL("DROP TABLE IF EXISTS media_variations_index");
        paramSQLiteDatabase.setTransactionSuccessful();
        paramSQLiteDatabase.endTransaction();
        onCreate(paramSQLiteDatabase);
        return;
      }
      finally
      {
        paramSQLiteDatabase.endTransaction();
      }
      throw localObject;
    }
  }

  private static final class IndexEntry
    implements BaseColumns
  {
    public static final String COLUMN_NAME_CACHE_CHOICE = "cache_choice";
    public static final String COLUMN_NAME_CACHE_KEY = "cache_key";
    public static final String COLUMN_NAME_HEIGHT = "height";
    public static final String COLUMN_NAME_MEDIA_ID = "media_id";
    public static final String COLUMN_NAME_RESOURCE_ID = "resource_id";
    public static final String COLUMN_NAME_WIDTH = "width";
    public static final String TABLE_NAME = "media_variations_index";
  }

  private static class LazyIndexDbOpenHelper
  {
    private final Context mContext;

    @Nullable
    private MediaVariationsIndexDatabase.IndexDbOpenHelper mIndexDbOpenHelper;

    private LazyIndexDbOpenHelper(Context paramContext)
    {
      this.mContext = paramContext;
    }

    public SQLiteDatabase getWritableDatabase()
    {
      monitorenter;
      try
      {
        if (this.mIndexDbOpenHelper == null)
          this.mIndexDbOpenHelper = new MediaVariationsIndexDatabase.IndexDbOpenHelper(this.mContext);
        SQLiteDatabase localSQLiteDatabase = this.mIndexDbOpenHelper.getWritableDatabase();
        return localSQLiteDatabase;
      }
      finally
      {
        monitorexit;
      }
      throw localObject;
    }
  }
}

/* Location:           C:\Users\c_jealom1\Documents\Scripts\Android\Fathom_com.brynk.fathom\Fathom_com.brynk.fathom-dex2jar.jar
 * Qualified Name:     com.facebook.imagepipeline.cache.MediaVariationsIndexDatabase
 * JD-Core Version:    0.6.0
 */
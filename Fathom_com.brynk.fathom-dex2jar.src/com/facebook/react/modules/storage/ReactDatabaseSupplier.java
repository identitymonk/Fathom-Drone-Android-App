package com.facebook.react.modules.storage;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import com.facebook.common.logging.FLog;
import javax.annotation.Nullable;

public class ReactDatabaseSupplier extends SQLiteOpenHelper
{
  public static final String DATABASE_NAME = "RKStorage";
  private static final int DATABASE_VERSION = 1;
  static final String KEY_COLUMN = "key";
  private static final int SLEEP_TIME_MS = 30;
  static final String TABLE_CATALYST = "catalystLocalStorage";
  static final String VALUE_COLUMN = "value";
  static final String VERSION_TABLE_CREATE = "CREATE TABLE catalystLocalStorage (key TEXT PRIMARY KEY, value TEXT NOT NULL)";

  @Nullable
  private static ReactDatabaseSupplier sReactDatabaseSupplierInstance;
  private Context mContext;

  @Nullable
  private SQLiteDatabase mDb;
  private long mMaximumDatabaseSize = 6291456L;

  private ReactDatabaseSupplier(Context paramContext)
  {
    super(paramContext, "RKStorage", null, 1);
    this.mContext = paramContext;
  }

  private void closeDatabase()
  {
    monitorenter;
    try
    {
      if ((this.mDb != null) && (this.mDb.isOpen()))
      {
        this.mDb.close();
        this.mDb = null;
      }
      monitorexit;
      return;
    }
    finally
    {
      localObject = finally;
      monitorexit;
    }
    throw localObject;
  }

  private boolean deleteDatabase()
  {
    monitorenter;
    try
    {
      closeDatabase();
      boolean bool = this.mContext.deleteDatabase("RKStorage");
      monitorexit;
      return bool;
    }
    finally
    {
      localObject = finally;
      monitorexit;
    }
    throw localObject;
  }

  public static void deleteInstance()
  {
    sReactDatabaseSupplierInstance = null;
  }

  public static ReactDatabaseSupplier getInstance(Context paramContext)
  {
    if (sReactDatabaseSupplierInstance == null)
      sReactDatabaseSupplierInstance = new ReactDatabaseSupplier(paramContext.getApplicationContext());
    return sReactDatabaseSupplierInstance;
  }

  void clear()
  {
    monitorenter;
    try
    {
      get().delete("catalystLocalStorage", null, null);
      monitorexit;
      return;
    }
    finally
    {
      localObject = finally;
      monitorexit;
    }
    throw localObject;
  }

  public void clearAndCloseDatabase()
    throws RuntimeException
  {
    monitorenter;
    try
    {
      clear();
      closeDatabase();
      FLog.d("ReactNative", "Cleaned RKStorage");
      return;
    }
    catch (Exception localException)
    {
      while (deleteDatabase())
        FLog.d("ReactNative", "Deleted Local Database RKStorage");
    }
    finally
    {
      monitorexit;
    }
    throw new RuntimeException("Clearing and deleting database RKStorage failed");
  }

  // ERROR //
  boolean ensureDatabase()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 50	com/facebook/react/modules/storage/ReactDatabaseSupplier:mDb	Landroid/database/sqlite/SQLiteDatabase;
    //   6: ifnull +19 -> 25
    //   9: aload_0
    //   10: getfield 50	com/facebook/react/modules/storage/ReactDatabaseSupplier:mDb	Landroid/database/sqlite/SQLiteDatabase;
    //   13: invokevirtual 56	android/database/sqlite/SQLiteDatabase:isOpen	()Z
    //   16: istore_2
    //   17: iload_2
    //   18: ifeq +7 -> 25
    //   21: aload_0
    //   22: monitorexit
    //   23: iconst_1
    //   24: ireturn
    //   25: aconst_null
    //   26: astore_3
    //   27: iconst_0
    //   28: istore_1
    //   29: iload_1
    //   30: iconst_2
    //   31: if_icmpge +20 -> 51
    //   34: iload_1
    //   35: ifle +8 -> 43
    //   38: aload_0
    //   39: invokespecial 106	com/facebook/react/modules/storage/ReactDatabaseSupplier:deleteDatabase	()Z
    //   42: pop
    //   43: aload_0
    //   44: aload_0
    //   45: invokevirtual 122	com/facebook/react/modules/storage/ReactDatabaseSupplier:getWritableDatabase	()Landroid/database/sqlite/SQLiteDatabase;
    //   48: putfield 50	com/facebook/react/modules/storage/ReactDatabaseSupplier:mDb	Landroid/database/sqlite/SQLiteDatabase;
    //   51: aload_0
    //   52: getfield 50	com/facebook/react/modules/storage/ReactDatabaseSupplier:mDb	Landroid/database/sqlite/SQLiteDatabase;
    //   55: ifnonnull +35 -> 90
    //   58: aload_3
    //   59: athrow
    //   60: astore_3
    //   61: aload_0
    //   62: monitorexit
    //   63: aload_3
    //   64: athrow
    //   65: astore_3
    //   66: ldc2_w 123
    //   69: invokestatic 130	java/lang/Thread:sleep	(J)V
    //   72: iload_1
    //   73: iconst_1
    //   74: iadd
    //   75: istore_1
    //   76: goto -47 -> 29
    //   79: astore 4
    //   81: invokestatic 134	java/lang/Thread:currentThread	()Ljava/lang/Thread;
    //   84: invokevirtual 137	java/lang/Thread:interrupt	()V
    //   87: goto -15 -> 72
    //   90: aload_0
    //   91: getfield 50	com/facebook/react/modules/storage/ReactDatabaseSupplier:mDb	Landroid/database/sqlite/SQLiteDatabase;
    //   94: aload_0
    //   95: getfield 43	com/facebook/react/modules/storage/ReactDatabaseSupplier:mMaximumDatabaseSize	J
    //   98: invokevirtual 141	android/database/sqlite/SQLiteDatabase:setMaximumSize	(J)J
    //   101: pop2
    //   102: goto -81 -> 21
    //
    // Exception table:
    //   from	to	target	type
    //   2	17	60	finally
    //   38	43	60	finally
    //   43	51	60	finally
    //   51	60	60	finally
    //   66	72	60	finally
    //   81	87	60	finally
    //   90	102	60	finally
    //   38	43	65	android/database/sqlite/SQLiteException
    //   43	51	65	android/database/sqlite/SQLiteException
    //   66	72	79	java/lang/InterruptedException
  }

  public SQLiteDatabase get()
  {
    monitorenter;
    try
    {
      ensureDatabase();
      SQLiteDatabase localSQLiteDatabase = this.mDb;
      monitorexit;
      return localSQLiteDatabase;
    }
    finally
    {
      localObject = finally;
      monitorexit;
    }
    throw localObject;
  }

  public void onCreate(SQLiteDatabase paramSQLiteDatabase)
  {
    paramSQLiteDatabase.execSQL("CREATE TABLE catalystLocalStorage (key TEXT PRIMARY KEY, value TEXT NOT NULL)");
  }

  public void onUpgrade(SQLiteDatabase paramSQLiteDatabase, int paramInt1, int paramInt2)
  {
    if (paramInt1 != paramInt2)
    {
      deleteDatabase();
      onCreate(paramSQLiteDatabase);
    }
  }

  public void setMaximumSize(long paramLong)
  {
    monitorenter;
    try
    {
      this.mMaximumDatabaseSize = paramLong;
      if (this.mDb != null)
        this.mDb.setMaximumSize(this.mMaximumDatabaseSize);
      monitorexit;
      return;
    }
    finally
    {
      localObject = finally;
      monitorexit;
    }
    throw localObject;
  }
}

/* Location:           C:\Users\c_jealom1\Documents\Scripts\Android\Fathom_com.brynk.fathom\Fathom_com.brynk.fathom-dex2jar.jar
 * Qualified Name:     com.facebook.react.modules.storage.ReactDatabaseSupplier
 * JD-Core Version:    0.6.0
 */
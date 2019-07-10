package com.facebook.react.modules.storage;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteStatement;
import com.facebook.common.logging.FLog;
import com.facebook.react.bridge.Arguments;
import com.facebook.react.bridge.Callback;
import com.facebook.react.bridge.GuardedAsyncTask;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.facebook.react.bridge.ReactMethod;
import com.facebook.react.bridge.ReadableArray;
import com.facebook.react.bridge.WritableArray;
import com.facebook.react.bridge.WritableMap;
import com.facebook.react.module.annotations.ReactModule;
import com.facebook.react.modules.common.ModuleDataCleaner.Cleanable;
import java.util.HashSet;
import java.util.Iterator;

@ReactModule(name="AsyncSQLiteDBStorage")
public final class AsyncStorageModule extends ReactContextBaseJavaModule
  implements ModuleDataCleaner.Cleanable
{
  private static final int MAX_SQL_KEYS = 999;
  protected static final String NAME = "AsyncSQLiteDBStorage";
  private ReactDatabaseSupplier mReactDatabaseSupplier;
  private boolean mShuttingDown = false;

  public AsyncStorageModule(ReactApplicationContext paramReactApplicationContext)
  {
    super(paramReactApplicationContext);
    this.mReactDatabaseSupplier = ReactDatabaseSupplier.getInstance(paramReactApplicationContext);
  }

  private boolean ensureDatabase()
  {
    return (!this.mShuttingDown) && (this.mReactDatabaseSupplier.ensureDatabase());
  }

  @ReactMethod
  public void clear(Callback paramCallback)
  {
    new GuardedAsyncTask(getReactApplicationContext(), paramCallback)
    {
      protected void doInBackgroundGuarded(Void[] paramArrayOfVoid)
      {
        if (!AsyncStorageModule.this.mReactDatabaseSupplier.ensureDatabase())
        {
          this.val$callback.invoke(new Object[] { AsyncStorageErrorUtil.getDBError(null) });
          return;
        }
        try
        {
          AsyncStorageModule.this.mReactDatabaseSupplier.clear();
          this.val$callback.invoke(new Object[0]);
          return;
        }
        catch (Exception paramArrayOfVoid)
        {
          FLog.w("ReactNative", paramArrayOfVoid.getMessage(), paramArrayOfVoid);
          this.val$callback.invoke(new Object[] { AsyncStorageErrorUtil.getError(null, paramArrayOfVoid.getMessage()) });
        }
      }
    }
    .execute(new Void[0]);
  }

  public void clearSensitiveData()
  {
    this.mReactDatabaseSupplier.clearAndCloseDatabase();
  }

  @ReactMethod
  public void getAllKeys(Callback paramCallback)
  {
    new GuardedAsyncTask(getReactApplicationContext(), paramCallback)
    {
      protected void doInBackgroundGuarded(Void[] paramArrayOfVoid)
      {
        if (!AsyncStorageModule.this.ensureDatabase())
        {
          this.val$callback.invoke(new Object[] { AsyncStorageErrorUtil.getDBError(null), null });
          return;
        }
        WritableArray localWritableArray = Arguments.createArray();
        paramArrayOfVoid = AsyncStorageModule.this.mReactDatabaseSupplier.get().query("catalystLocalStorage", new String[] { "key" }, null, null, null, null, null);
        try
        {
          if (paramArrayOfVoid.moveToFirst())
          {
            boolean bool;
            do
            {
              localWritableArray.pushString(paramArrayOfVoid.getString(0));
              bool = paramArrayOfVoid.moveToNext();
            }
            while (bool);
          }
          paramArrayOfVoid.close();
          this.val$callback.invoke(new Object[] { null, localWritableArray });
          return;
        }
        catch (Exception localException)
        {
          FLog.w("ReactNative", localException.getMessage(), localException);
          this.val$callback.invoke(new Object[] { AsyncStorageErrorUtil.getError(null, localException.getMessage()), null });
          return;
        }
        finally
        {
          paramArrayOfVoid.close();
        }
        throw localObject;
      }
    }
    .execute(new Void[0]);
  }

  public String getName()
  {
    return "AsyncSQLiteDBStorage";
  }

  public void initialize()
  {
    super.initialize();
    this.mShuttingDown = false;
  }

  @ReactMethod
  public void multiGet(ReadableArray paramReadableArray, Callback paramCallback)
  {
    if (paramReadableArray == null)
    {
      paramCallback.invoke(new Object[] { AsyncStorageErrorUtil.getInvalidKeyError(null), null });
      return;
    }
    new GuardedAsyncTask(getReactApplicationContext(), paramCallback, paramReadableArray)
    {
      protected void doInBackgroundGuarded(Void[] paramArrayOfVoid)
      {
        if (!AsyncStorageModule.this.ensureDatabase())
        {
          this.val$callback.invoke(new Object[] { AsyncStorageErrorUtil.getDBError(null), null });
          return;
        }
        paramArrayOfVoid = new HashSet();
        WritableArray localWritableArray = Arguments.createArray();
        int i = 0;
        while (i < this.val$keys.size())
        {
          int k = Math.min(this.val$keys.size() - i, 999);
          Object localObject1 = AsyncStorageModule.this.mReactDatabaseSupplier.get();
          Object localObject2 = AsyncLocalStorageUtil.buildKeySelection(k);
          Object localObject3 = AsyncLocalStorageUtil.buildKeySelectionArgs(this.val$keys, i, k);
          localObject1 = ((SQLiteDatabase)localObject1).query("catalystLocalStorage", new String[] { "key", "value" }, (String)localObject2, localObject3, null, null, null);
          paramArrayOfVoid.clear();
          try
          {
            if (((Cursor)localObject1).getCount() != this.val$keys.size())
            {
              int j = i;
              while (j < i + k)
              {
                paramArrayOfVoid.add(this.val$keys.getString(j));
                j += 1;
              }
            }
            if (((Cursor)localObject1).moveToFirst())
            {
              boolean bool;
              do
              {
                localObject2 = Arguments.createArray();
                ((WritableArray)localObject2).pushString(((Cursor)localObject1).getString(0));
                ((WritableArray)localObject2).pushString(((Cursor)localObject1).getString(1));
                localWritableArray.pushArray((WritableArray)localObject2);
                paramArrayOfVoid.remove(((Cursor)localObject1).getString(0));
                bool = ((Cursor)localObject1).moveToNext();
              }
              while (bool);
            }
            ((Cursor)localObject1).close();
            localObject1 = paramArrayOfVoid.iterator();
            while (((Iterator)localObject1).hasNext())
            {
              localObject2 = (String)((Iterator)localObject1).next();
              localObject3 = Arguments.createArray();
              ((WritableArray)localObject3).pushString((String)localObject2);
              ((WritableArray)localObject3).pushNull();
              localWritableArray.pushArray((WritableArray)localObject3);
            }
          }
          catch (Exception paramArrayOfVoid)
          {
            FLog.w("ReactNative", paramArrayOfVoid.getMessage(), paramArrayOfVoid);
            this.val$callback.invoke(new Object[] { AsyncStorageErrorUtil.getError(null, paramArrayOfVoid.getMessage()), null });
            return;
          }
          finally
          {
            ((Cursor)localObject1).close();
          }
          paramArrayOfVoid.clear();
          i += 999;
        }
        this.val$callback.invoke(new Object[] { null, localWritableArray });
      }
    }
    .execute(new Void[0]);
  }

  @ReactMethod
  public void multiMerge(ReadableArray paramReadableArray, Callback paramCallback)
  {
    new GuardedAsyncTask(getReactApplicationContext(), paramCallback, paramReadableArray)
    {
      protected void doInBackgroundGuarded(Void[] paramArrayOfVoid)
      {
        if (!AsyncStorageModule.this.ensureDatabase())
          this.val$callback.invoke(new Object[] { AsyncStorageErrorUtil.getDBError(null) });
        while (true)
        {
          return;
          paramArrayOfVoid = null;
          try
          {
            AsyncStorageModule.this.mReactDatabaseSupplier.get().beginTransaction();
            int i = 0;
            while (true)
            {
              if (i >= this.val$keyValueArray.size())
                break label349;
              if (this.val$keyValueArray.getArray(i).size() != 2)
              {
                paramArrayOfVoid = AsyncStorageErrorUtil.getInvalidValueError(null);
                try
                {
                  AsyncStorageModule.this.mReactDatabaseSupplier.get().endTransaction();
                  return;
                }
                catch (Exception localException1)
                {
                  FLog.w("ReactNative", localException1.getMessage(), localException1);
                }
                if (paramArrayOfVoid != null)
                  break;
                AsyncStorageErrorUtil.getError(null, localException1.getMessage());
                return;
              }
              if (this.val$keyValueArray.getArray(i).getString(0) == null)
              {
                paramArrayOfVoid = AsyncStorageErrorUtil.getInvalidKeyError(null);
                try
                {
                  AsyncStorageModule.this.mReactDatabaseSupplier.get().endTransaction();
                  return;
                }
                catch (Exception localException2)
                {
                  FLog.w("ReactNative", localException2.getMessage(), localException2);
                }
                if (paramArrayOfVoid != null)
                  break;
                AsyncStorageErrorUtil.getError(null, localException2.getMessage());
                return;
              }
              if (this.val$keyValueArray.getArray(i).getString(1) == null)
              {
                paramArrayOfVoid = AsyncStorageErrorUtil.getInvalidValueError(null);
                try
                {
                  AsyncStorageModule.this.mReactDatabaseSupplier.get().endTransaction();
                  return;
                }
                catch (Exception localException3)
                {
                  FLog.w("ReactNative", localException3.getMessage(), localException3);
                }
                if (paramArrayOfVoid != null)
                  break;
                AsyncStorageErrorUtil.getError(null, localException3.getMessage());
                return;
              }
              if (!AsyncLocalStorageUtil.mergeImpl(AsyncStorageModule.this.mReactDatabaseSupplier.get(), this.val$keyValueArray.getArray(i).getString(0), this.val$keyValueArray.getArray(i).getString(1)))
              {
                paramArrayOfVoid = AsyncStorageErrorUtil.getDBError(null);
                try
                {
                  AsyncStorageModule.this.mReactDatabaseSupplier.get().endTransaction();
                  return;
                }
                catch (Exception localException4)
                {
                  FLog.w("ReactNative", localException4.getMessage(), localException4);
                }
                if (paramArrayOfVoid != null)
                  break;
                AsyncStorageErrorUtil.getError(null, localException4.getMessage());
                return;
              }
              i += 1;
            }
            label349: AsyncStorageModule.this.mReactDatabaseSupplier.get().setTransactionSuccessful();
            try
            {
              AsyncStorageModule.this.mReactDatabaseSupplier.get().endTransaction();
              if (paramArrayOfVoid != null)
              {
                this.val$callback.invoke(new Object[] { paramArrayOfVoid });
                return;
              }
            }
            catch (Exception localException5)
            {
              while (true)
              {
                FLog.w("ReactNative", localException5.getMessage(), localException5);
                if (0 != 0)
                  continue;
                paramArrayOfVoid = AsyncStorageErrorUtil.getError(null, localException5.getMessage());
              }
            }
          }
          catch (Exception paramArrayOfVoid)
          {
            while (true)
            {
              FLog.w("ReactNative", paramArrayOfVoid.getMessage(), paramArrayOfVoid);
              WritableMap localWritableMap = AsyncStorageErrorUtil.getError(null, paramArrayOfVoid.getMessage());
              try
              {
                AsyncStorageModule.this.mReactDatabaseSupplier.get().endTransaction();
                paramArrayOfVoid = localWritableMap;
              }
              catch (Exception localException7)
              {
                FLog.w("ReactNative", localException7.getMessage(), localException7);
                paramArrayOfVoid = localWritableMap;
              }
              if (localWritableMap != null)
                continue;
              paramArrayOfVoid = AsyncStorageErrorUtil.getError(null, localException7.getMessage());
            }
          }
          finally
          {
            try
            {
              AsyncStorageModule.this.mReactDatabaseSupplier.get().endTransaction();
              throw paramArrayOfVoid;
            }
            catch (Exception localException6)
            {
              while (true)
              {
                FLog.w("ReactNative", localException6.getMessage(), localException6);
                if (0 != 0)
                  continue;
                AsyncStorageErrorUtil.getError(null, localException6.getMessage());
              }
            }
            this.val$callback.invoke(new Object[0]);
          }
        }
      }
    }
    .execute(new Void[0]);
  }

  @ReactMethod
  public void multiRemove(ReadableArray paramReadableArray, Callback paramCallback)
  {
    if (paramReadableArray.size() == 0)
    {
      paramCallback.invoke(new Object[] { AsyncStorageErrorUtil.getInvalidKeyError(null) });
      return;
    }
    new GuardedAsyncTask(getReactApplicationContext(), paramCallback, paramReadableArray)
    {
      protected void doInBackgroundGuarded(Void[] paramArrayOfVoid)
      {
        if (!AsyncStorageModule.this.ensureDatabase())
        {
          this.val$callback.invoke(new Object[] { AsyncStorageErrorUtil.getDBError(null) });
          return;
        }
        paramArrayOfVoid = null;
        try
        {
          AsyncStorageModule.this.mReactDatabaseSupplier.get().beginTransaction();
          int i = 0;
          while (i < this.val$keys.size())
          {
            int j = Math.min(this.val$keys.size() - i, 999);
            AsyncStorageModule.this.mReactDatabaseSupplier.get().delete("catalystLocalStorage", AsyncLocalStorageUtil.buildKeySelection(j), AsyncLocalStorageUtil.buildKeySelectionArgs(this.val$keys, i, j));
            i += 999;
          }
          AsyncStorageModule.this.mReactDatabaseSupplier.get().setTransactionSuccessful();
          try
          {
            AsyncStorageModule.this.mReactDatabaseSupplier.get().endTransaction();
            if (paramArrayOfVoid != null)
            {
              this.val$callback.invoke(new Object[] { paramArrayOfVoid });
              return;
            }
          }
          catch (Exception localException1)
          {
            while (true)
            {
              FLog.w("ReactNative", localException1.getMessage(), localException1);
              if (0 != 0)
                continue;
              paramArrayOfVoid = AsyncStorageErrorUtil.getError(null, localException1.getMessage());
            }
          }
        }
        catch (Exception paramArrayOfVoid)
        {
          while (true)
          {
            FLog.w("ReactNative", paramArrayOfVoid.getMessage(), paramArrayOfVoid);
            WritableMap localWritableMap = AsyncStorageErrorUtil.getError(null, paramArrayOfVoid.getMessage());
            try
            {
              AsyncStorageModule.this.mReactDatabaseSupplier.get().endTransaction();
              paramArrayOfVoid = localWritableMap;
            }
            catch (Exception localException3)
            {
              FLog.w("ReactNative", localException3.getMessage(), localException3);
              paramArrayOfVoid = localWritableMap;
            }
            if (localWritableMap != null)
              continue;
            paramArrayOfVoid = AsyncStorageErrorUtil.getError(null, localException3.getMessage());
          }
        }
        finally
        {
          try
          {
            AsyncStorageModule.this.mReactDatabaseSupplier.get().endTransaction();
            throw paramArrayOfVoid;
          }
          catch (Exception localException2)
          {
            while (true)
            {
              FLog.w("ReactNative", localException2.getMessage(), localException2);
              if (0 != 0)
                continue;
              AsyncStorageErrorUtil.getError(null, localException2.getMessage());
            }
          }
          this.val$callback.invoke(new Object[0]);
        }
      }
    }
    .execute(new Void[0]);
  }

  @ReactMethod
  public void multiSet(ReadableArray paramReadableArray, Callback paramCallback)
  {
    if (paramReadableArray.size() == 0)
    {
      paramCallback.invoke(new Object[] { AsyncStorageErrorUtil.getInvalidKeyError(null) });
      return;
    }
    new GuardedAsyncTask(getReactApplicationContext(), paramCallback, paramReadableArray)
    {
      protected void doInBackgroundGuarded(Void[] paramArrayOfVoid)
      {
        if (!AsyncStorageModule.this.ensureDatabase())
          this.val$callback.invoke(new Object[] { AsyncStorageErrorUtil.getDBError(null) });
        while (true)
        {
          return;
          SQLiteStatement localSQLiteStatement = AsyncStorageModule.this.mReactDatabaseSupplier.get().compileStatement("INSERT OR REPLACE INTO catalystLocalStorage VALUES (?, ?);");
          paramArrayOfVoid = null;
          try
          {
            AsyncStorageModule.this.mReactDatabaseSupplier.get().beginTransaction();
            int i = 0;
            while (true)
            {
              if (i >= this.val$keyValueArray.size())
                break label323;
              if (this.val$keyValueArray.getArray(i).size() != 2)
              {
                paramArrayOfVoid = AsyncStorageErrorUtil.getInvalidValueError(null);
                try
                {
                  AsyncStorageModule.this.mReactDatabaseSupplier.get().endTransaction();
                  return;
                }
                catch (Exception localException1)
                {
                  FLog.w("ReactNative", localException1.getMessage(), localException1);
                }
                if (paramArrayOfVoid != null)
                  break;
                AsyncStorageErrorUtil.getError(null, localException1.getMessage());
                return;
              }
              if (this.val$keyValueArray.getArray(i).getString(0) == null)
              {
                paramArrayOfVoid = AsyncStorageErrorUtil.getInvalidKeyError(null);
                try
                {
                  AsyncStorageModule.this.mReactDatabaseSupplier.get().endTransaction();
                  return;
                }
                catch (Exception localException2)
                {
                  FLog.w("ReactNative", localException2.getMessage(), localException2);
                }
                if (paramArrayOfVoid != null)
                  break;
                AsyncStorageErrorUtil.getError(null, localException2.getMessage());
                return;
              }
              if (this.val$keyValueArray.getArray(i).getString(1) == null)
              {
                paramArrayOfVoid = AsyncStorageErrorUtil.getInvalidValueError(null);
                try
                {
                  AsyncStorageModule.this.mReactDatabaseSupplier.get().endTransaction();
                  return;
                }
                catch (Exception localException3)
                {
                  FLog.w("ReactNative", localException3.getMessage(), localException3);
                }
                if (paramArrayOfVoid != null)
                  break;
                AsyncStorageErrorUtil.getError(null, localException3.getMessage());
                return;
              }
              localException3.clearBindings();
              localException3.bindString(1, this.val$keyValueArray.getArray(i).getString(0));
              localException3.bindString(2, this.val$keyValueArray.getArray(i).getString(1));
              localException3.execute();
              i += 1;
            }
            label323: AsyncStorageModule.this.mReactDatabaseSupplier.get().setTransactionSuccessful();
            try
            {
              AsyncStorageModule.this.mReactDatabaseSupplier.get().endTransaction();
              if (paramArrayOfVoid != null)
              {
                this.val$callback.invoke(new Object[] { paramArrayOfVoid });
                return;
              }
            }
            catch (Exception localException4)
            {
              while (true)
              {
                FLog.w("ReactNative", localException4.getMessage(), localException4);
                if (0 != 0)
                  continue;
                paramArrayOfVoid = AsyncStorageErrorUtil.getError(null, localException4.getMessage());
              }
            }
          }
          catch (Exception paramArrayOfVoid)
          {
            while (true)
            {
              FLog.w("ReactNative", paramArrayOfVoid.getMessage(), paramArrayOfVoid);
              WritableMap localWritableMap = AsyncStorageErrorUtil.getError(null, paramArrayOfVoid.getMessage());
              try
              {
                AsyncStorageModule.this.mReactDatabaseSupplier.get().endTransaction();
                paramArrayOfVoid = localWritableMap;
              }
              catch (Exception localException6)
              {
                FLog.w("ReactNative", localException6.getMessage(), localException6);
                paramArrayOfVoid = localWritableMap;
              }
              if (localWritableMap != null)
                continue;
              paramArrayOfVoid = AsyncStorageErrorUtil.getError(null, localException6.getMessage());
            }
          }
          finally
          {
            try
            {
              AsyncStorageModule.this.mReactDatabaseSupplier.get().endTransaction();
              throw paramArrayOfVoid;
            }
            catch (Exception localException5)
            {
              while (true)
              {
                FLog.w("ReactNative", localException5.getMessage(), localException5);
                if (0 != 0)
                  continue;
                AsyncStorageErrorUtil.getError(null, localException5.getMessage());
              }
            }
            this.val$callback.invoke(new Object[0]);
          }
        }
      }
    }
    .execute(new Void[0]);
  }

  public void onCatalystInstanceDestroy()
  {
    this.mShuttingDown = true;
  }
}

/* Location:           C:\Users\c_jealom1\Documents\Scripts\Android\Fathom_com.brynk.fathom\Fathom_com.brynk.fathom-dex2jar.jar
 * Qualified Name:     com.facebook.react.modules.storage.AsyncStorageModule
 * JD-Core Version:    0.6.0
 */
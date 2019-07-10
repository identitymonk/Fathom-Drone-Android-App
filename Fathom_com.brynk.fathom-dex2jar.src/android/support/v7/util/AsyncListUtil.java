package android.support.v7.util;

import android.support.annotation.UiThread;
import android.support.annotation.WorkerThread;
import android.util.Log;
import android.util.SparseBooleanArray;
import android.util.SparseIntArray;

public class AsyncListUtil<T>
{
  private static final boolean DEBUG = false;
  private static final String TAG = "AsyncListUtil";
  private boolean mAllowScrollHints;
  private final ThreadUtil.BackgroundCallback<T> mBackgroundCallback = new ThreadUtil.BackgroundCallback()
  {
    private int mFirstRequiredTileStart;
    private int mGeneration;
    private int mItemCount;
    private int mLastRequiredTileStart;
    final SparseBooleanArray mLoadedTiles = new SparseBooleanArray();
    private TileList.Tile<T> mRecycledRoot;

    private TileList.Tile<T> acquireTile()
    {
      if (this.mRecycledRoot != null)
      {
        TileList.Tile localTile = this.mRecycledRoot;
        this.mRecycledRoot = this.mRecycledRoot.mNext;
        return localTile;
      }
      return new TileList.Tile(AsyncListUtil.this.mTClass, AsyncListUtil.this.mTileSize);
    }

    private void addTile(TileList.Tile<T> paramTile)
    {
      this.mLoadedTiles.put(paramTile.mStartPosition, true);
      AsyncListUtil.this.mMainThreadProxy.addTile(this.mGeneration, paramTile);
    }

    private void flushTileCache(int paramInt)
    {
      int i = AsyncListUtil.this.mDataCallback.getMaxCachedTiles();
      while (this.mLoadedTiles.size() >= i)
      {
        int j = this.mLoadedTiles.keyAt(0);
        int k = this.mLoadedTiles.keyAt(this.mLoadedTiles.size() - 1);
        int m = this.mFirstRequiredTileStart - j;
        int n = k - this.mLastRequiredTileStart;
        if ((m > 0) && ((m >= n) || (paramInt == 2)))
        {
          removeTile(j);
          continue;
        }
        if ((n <= 0) || ((m >= n) && (paramInt != 1)))
          break;
        removeTile(k);
      }
    }

    private int getTileStart(int paramInt)
    {
      return paramInt - paramInt % AsyncListUtil.this.mTileSize;
    }

    private boolean isTileLoaded(int paramInt)
    {
      return this.mLoadedTiles.get(paramInt);
    }

    private void log(String paramString, Object[] paramArrayOfObject)
    {
      Log.d("AsyncListUtil", "[BKGR] " + String.format(paramString, paramArrayOfObject));
    }

    private void removeTile(int paramInt)
    {
      this.mLoadedTiles.delete(paramInt);
      AsyncListUtil.this.mMainThreadProxy.removeTile(this.mGeneration, paramInt);
    }

    private void requestTiles(int paramInt1, int paramInt2, int paramInt3, boolean paramBoolean)
    {
      int i = paramInt1;
      if (i <= paramInt2)
      {
        if (paramBoolean);
        for (int j = paramInt2 + paramInt1 - i; ; j = i)
        {
          AsyncListUtil.this.mBackgroundProxy.loadTile(j, paramInt3);
          i += AsyncListUtil.this.mTileSize;
          break;
        }
      }
    }

    public void loadTile(int paramInt1, int paramInt2)
    {
      if (isTileLoaded(paramInt1))
        return;
      TileList.Tile localTile = acquireTile();
      localTile.mStartPosition = paramInt1;
      localTile.mItemCount = Math.min(AsyncListUtil.this.mTileSize, this.mItemCount - localTile.mStartPosition);
      AsyncListUtil.this.mDataCallback.fillData(localTile.mItems, localTile.mStartPosition, localTile.mItemCount);
      flushTileCache(paramInt2);
      addTile(localTile);
    }

    public void recycleTile(TileList.Tile<T> paramTile)
    {
      AsyncListUtil.this.mDataCallback.recycleData(paramTile.mItems, paramTile.mItemCount);
      paramTile.mNext = this.mRecycledRoot;
      this.mRecycledRoot = paramTile;
    }

    public void refresh(int paramInt)
    {
      this.mGeneration = paramInt;
      this.mLoadedTiles.clear();
      this.mItemCount = AsyncListUtil.this.mDataCallback.refreshData();
      AsyncListUtil.this.mMainThreadProxy.updateItemCount(this.mGeneration, this.mItemCount);
    }

    public void updateRange(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5)
    {
      if (paramInt1 > paramInt2)
        return;
      paramInt1 = getTileStart(paramInt1);
      paramInt2 = getTileStart(paramInt2);
      this.mFirstRequiredTileStart = getTileStart(paramInt3);
      this.mLastRequiredTileStart = getTileStart(paramInt4);
      if (paramInt5 == 1)
      {
        requestTiles(this.mFirstRequiredTileStart, paramInt2, paramInt5, true);
        requestTiles(AsyncListUtil.this.mTileSize + paramInt2, this.mLastRequiredTileStart, paramInt5, false);
        return;
      }
      requestTiles(paramInt1, this.mLastRequiredTileStart, paramInt5, false);
      requestTiles(this.mFirstRequiredTileStart, paramInt1 - AsyncListUtil.this.mTileSize, paramInt5, true);
    }
  };
  final ThreadUtil.BackgroundCallback<T> mBackgroundProxy;
  final DataCallback<T> mDataCallback;
  int mDisplayedGeneration = 0;
  private int mItemCount = 0;
  private final ThreadUtil.MainThreadCallback<T> mMainThreadCallback = new ThreadUtil.MainThreadCallback()
  {
    private boolean isRequestedGeneration(int paramInt)
    {
      return paramInt == AsyncListUtil.this.mRequestedGeneration;
    }

    private void recycleAllTiles()
    {
      int i = 0;
      while (i < AsyncListUtil.this.mTileList.size())
      {
        AsyncListUtil.this.mBackgroundProxy.recycleTile(AsyncListUtil.this.mTileList.getAtIndex(i));
        i += 1;
      }
      AsyncListUtil.this.mTileList.clear();
    }

    public void addTile(int paramInt, TileList.Tile<T> paramTile)
    {
      if (!isRequestedGeneration(paramInt))
        AsyncListUtil.this.mBackgroundProxy.recycleTile(paramTile);
      while (true)
      {
        return;
        TileList.Tile localTile = AsyncListUtil.this.mTileList.addOrReplace(paramTile);
        if (localTile != null)
        {
          Log.e("AsyncListUtil", "duplicate tile @" + localTile.mStartPosition);
          AsyncListUtil.this.mBackgroundProxy.recycleTile(localTile);
        }
        int i = paramTile.mStartPosition;
        int j = paramTile.mItemCount;
        paramInt = 0;
        while (paramInt < AsyncListUtil.this.mMissingPositions.size())
        {
          int k = AsyncListUtil.this.mMissingPositions.keyAt(paramInt);
          if ((paramTile.mStartPosition <= k) && (k < i + j))
          {
            AsyncListUtil.this.mMissingPositions.removeAt(paramInt);
            AsyncListUtil.this.mViewCallback.onItemLoaded(k);
            continue;
          }
          paramInt += 1;
        }
      }
    }

    public void removeTile(int paramInt1, int paramInt2)
    {
      if (!isRequestedGeneration(paramInt1))
        return;
      TileList.Tile localTile = AsyncListUtil.this.mTileList.removeAtPos(paramInt2);
      if (localTile == null)
      {
        Log.e("AsyncListUtil", "tile not found @" + paramInt2);
        return;
      }
      AsyncListUtil.this.mBackgroundProxy.recycleTile(localTile);
    }

    public void updateItemCount(int paramInt1, int paramInt2)
    {
      if (!isRequestedGeneration(paramInt1))
        return;
      AsyncListUtil.access$002(AsyncListUtil.this, paramInt2);
      AsyncListUtil.this.mViewCallback.onDataRefresh();
      AsyncListUtil.this.mDisplayedGeneration = AsyncListUtil.this.mRequestedGeneration;
      recycleAllTiles();
      AsyncListUtil.access$102(AsyncListUtil.this, false);
      AsyncListUtil.this.updateRange();
    }
  };
  final ThreadUtil.MainThreadCallback<T> mMainThreadProxy;
  private final SparseIntArray mMissingPositions = new SparseIntArray();
  final int[] mPrevRange = new int[2];
  int mRequestedGeneration = this.mDisplayedGeneration;
  private int mScrollHint = 0;
  final Class<T> mTClass;
  final TileList<T> mTileList;
  final int mTileSize;
  final int[] mTmpRange = new int[2];
  final int[] mTmpRangeExtended = new int[2];
  final ViewCallback mViewCallback;

  public AsyncListUtil(Class<T> paramClass, int paramInt, DataCallback<T> paramDataCallback, ViewCallback paramViewCallback)
  {
    this.mTClass = paramClass;
    this.mTileSize = paramInt;
    this.mDataCallback = paramDataCallback;
    this.mViewCallback = paramViewCallback;
    this.mTileList = new TileList(this.mTileSize);
    paramClass = new MessageThreadUtil();
    this.mMainThreadProxy = paramClass.getMainThreadProxy(this.mMainThreadCallback);
    this.mBackgroundProxy = paramClass.getBackgroundProxy(this.mBackgroundCallback);
    refresh();
  }

  private boolean isRefreshPending()
  {
    return this.mRequestedGeneration != this.mDisplayedGeneration;
  }

  private void log(String paramString, Object[] paramArrayOfObject)
  {
    Log.d("AsyncListUtil", "[MAIN] " + String.format(paramString, paramArrayOfObject));
  }

  private void updateRange()
  {
    this.mViewCallback.getItemRangeInto(this.mTmpRange);
    if ((this.mTmpRange[0] > this.mTmpRange[1]) || (this.mTmpRange[0] < 0));
    do
      return;
    while (this.mTmpRange[1] >= this.mItemCount);
    if (!this.mAllowScrollHints)
      this.mScrollHint = 0;
    while (true)
    {
      this.mPrevRange[0] = this.mTmpRange[0];
      this.mPrevRange[1] = this.mTmpRange[1];
      this.mViewCallback.extendRangeInto(this.mTmpRange, this.mTmpRangeExtended, this.mScrollHint);
      this.mTmpRangeExtended[0] = Math.min(this.mTmpRange[0], Math.max(this.mTmpRangeExtended[0], 0));
      this.mTmpRangeExtended[1] = Math.max(this.mTmpRange[1], Math.min(this.mTmpRangeExtended[1], this.mItemCount - 1));
      this.mBackgroundProxy.updateRange(this.mTmpRange[0], this.mTmpRange[1], this.mTmpRangeExtended[0], this.mTmpRangeExtended[1], this.mScrollHint);
      return;
      if ((this.mTmpRange[0] > this.mPrevRange[1]) || (this.mPrevRange[0] > this.mTmpRange[1]))
      {
        this.mScrollHint = 0;
        continue;
      }
      if (this.mTmpRange[0] < this.mPrevRange[0])
      {
        this.mScrollHint = 1;
        continue;
      }
      if (this.mTmpRange[0] <= this.mPrevRange[0])
        continue;
      this.mScrollHint = 2;
    }
  }

  public T getItem(int paramInt)
  {
    if ((paramInt < 0) || (paramInt >= this.mItemCount))
      throw new IndexOutOfBoundsException(paramInt + " is not within 0 and " + this.mItemCount);
    Object localObject = this.mTileList.getItemAt(paramInt);
    if ((localObject == null) && (!isRefreshPending()))
      this.mMissingPositions.put(paramInt, 0);
    return localObject;
  }

  public int getItemCount()
  {
    return this.mItemCount;
  }

  public void onRangeChanged()
  {
    if (isRefreshPending())
      return;
    updateRange();
    this.mAllowScrollHints = true;
  }

  public void refresh()
  {
    this.mMissingPositions.clear();
    ThreadUtil.BackgroundCallback localBackgroundCallback = this.mBackgroundProxy;
    int i = this.mRequestedGeneration + 1;
    this.mRequestedGeneration = i;
    localBackgroundCallback.refresh(i);
  }

  public static abstract class DataCallback<T>
  {
    @WorkerThread
    public abstract void fillData(T[] paramArrayOfT, int paramInt1, int paramInt2);

    @WorkerThread
    public int getMaxCachedTiles()
    {
      return 10;
    }

    @WorkerThread
    public void recycleData(T[] paramArrayOfT, int paramInt)
    {
    }

    @WorkerThread
    public abstract int refreshData();
  }

  public static abstract class ViewCallback
  {
    public static final int HINT_SCROLL_ASC = 2;
    public static final int HINT_SCROLL_DESC = 1;
    public static final int HINT_SCROLL_NONE = 0;

    @UiThread
    public void extendRangeInto(int[] paramArrayOfInt1, int[] paramArrayOfInt2, int paramInt)
    {
      int i = paramArrayOfInt1[1] - paramArrayOfInt1[0] + 1;
      int j = i / 2;
      int m = paramArrayOfInt1[0];
      int k;
      if (paramInt == 1)
      {
        k = i;
        paramArrayOfInt2[0] = (m - k);
        k = paramArrayOfInt1[1];
        if (paramInt != 2)
          break label65;
      }
      while (true)
      {
        paramArrayOfInt2[1] = (k + i);
        return;
        k = j;
        break;
        label65: i = j;
      }
    }

    @UiThread
    public abstract void getItemRangeInto(int[] paramArrayOfInt);

    @UiThread
    public abstract void onDataRefresh();

    @UiThread
    public abstract void onItemLoaded(int paramInt);
  }
}

/* Location:           C:\Users\c_jealom1\Documents\Scripts\Android\Fathom_com.brynk.fathom\Fathom_com.brynk.fathom-dex2jar.jar
 * Qualified Name:     android.support.v7.util.AsyncListUtil
 * JD-Core Version:    0.6.0
 */
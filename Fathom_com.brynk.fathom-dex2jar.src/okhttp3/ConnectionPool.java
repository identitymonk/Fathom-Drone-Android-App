package okhttp3;

import java.lang.ref.Reference;
import java.net.Socket;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.Executor;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import okhttp3.internal.Util;
import okhttp3.internal.connection.RealConnection;
import okhttp3.internal.connection.RouteDatabase;
import okhttp3.internal.connection.StreamAllocation;
import okhttp3.internal.connection.StreamAllocation.StreamAllocationReference;
import okhttp3.internal.platform.Platform;

public final class ConnectionPool
{
  private static final Executor executor;
  private final Runnable cleanupRunnable = new Runnable()
  {
    public void run()
    {
      long l1;
      do
      {
        l1 = ConnectionPool.this.cleanup(System.nanoTime());
        if (l1 == -1L)
          return;
      }
      while (l1 <= 0L);
      long l2 = l1 / 1000000L;
      try
      {
        label57: synchronized (ConnectionPool.this)
        {
          ConnectionPool.this.wait(l2, (int)(l1 - l2 * 1000000L));
        }
      }
      catch (InterruptedException localInterruptedException)
      {
        break label57;
      }
    }
  };
  boolean cleanupRunning;
  private final Deque<RealConnection> connections = new ArrayDeque();
  private final long keepAliveDurationNs;
  private final int maxIdleConnections;
  final RouteDatabase routeDatabase = new RouteDatabase();

  static
  {
    if (!ConnectionPool.class.desiredAssertionStatus());
    for (boolean bool = true; ; bool = false)
    {
      $assertionsDisabled = bool;
      executor = new ThreadPoolExecutor(0, 2147483647, 60L, TimeUnit.SECONDS, new SynchronousQueue(), Util.threadFactory("OkHttp ConnectionPool", true));
      return;
    }
  }

  public ConnectionPool()
  {
    this(5, 5L, TimeUnit.MINUTES);
  }

  public ConnectionPool(int paramInt, long paramLong, TimeUnit paramTimeUnit)
  {
    this.maxIdleConnections = paramInt;
    this.keepAliveDurationNs = paramTimeUnit.toNanos(paramLong);
    if (paramLong <= 0L)
      throw new IllegalArgumentException("keepAliveDuration <= 0: " + paramLong);
  }

  private int pruneAndGetAllocationCount(RealConnection paramRealConnection, long paramLong)
  {
    List localList = paramRealConnection.allocations;
    int i = 0;
    while (i < localList.size())
    {
      Object localObject = (Reference)localList.get(i);
      if (((Reference)localObject).get() != null)
      {
        i += 1;
        continue;
      }
      localObject = (StreamAllocation.StreamAllocationReference)localObject;
      String str = "A connection to " + paramRealConnection.route().address().url() + " was leaked. Did you forget to close a response body?";
      Platform.get().logCloseableLeak(str, ((StreamAllocation.StreamAllocationReference)localObject).callStackTrace);
      localList.remove(i);
      paramRealConnection.noNewStreams = true;
      if (!localList.isEmpty())
        continue;
      paramRealConnection.idleAtNanos = (paramLong - this.keepAliveDurationNs);
      return 0;
    }
    return localList.size();
  }

  long cleanup(long paramLong)
  {
    int j = 0;
    int i = 0;
    Object localObject1 = null;
    long l1 = -9223372036854775808L;
    monitorenter;
    try
    {
      Iterator localIterator = this.connections.iterator();
      while (localIterator.hasNext())
      {
        RealConnection localRealConnection = (RealConnection)localIterator.next();
        if (pruneAndGetAllocationCount(localRealConnection, paramLong) > 0)
        {
          j += 1;
          continue;
        }
        int k = i + 1;
        long l2 = paramLong - localRealConnection.idleAtNanos;
        i = k;
        if (l2 <= l1)
          continue;
        l1 = l2;
        localObject1 = localRealConnection;
        i = k;
      }
      if ((l1 >= this.keepAliveDurationNs) || (i > this.maxIdleConnections))
      {
        this.connections.remove(localObject1);
        monitorexit;
        Util.closeQuietly(localObject1.socket());
        return 0L;
      }
      if (i > 0)
      {
        paramLong = this.keepAliveDurationNs;
        return paramLong - l1;
      }
    }
    finally
    {
      monitorexit;
    }
    if (j > 0)
    {
      paramLong = this.keepAliveDurationNs;
      monitorexit;
      return paramLong;
    }
    this.cleanupRunning = false;
    monitorexit;
    return -1L;
  }

  boolean connectionBecameIdle(RealConnection paramRealConnection)
  {
    assert (Thread.holdsLock(this));
    if ((paramRealConnection.noNewStreams) || (this.maxIdleConnections == 0))
    {
      this.connections.remove(paramRealConnection);
      return true;
    }
    notifyAll();
    return false;
  }

  public int connectionCount()
  {
    monitorenter;
    try
    {
      int i = this.connections.size();
      monitorexit;
      return i;
    }
    finally
    {
      localObject = finally;
      monitorexit;
    }
    throw localObject;
  }

  Socket deduplicate(Address paramAddress, StreamAllocation paramStreamAllocation)
  {
    assert (Thread.holdsLock(this));
    Iterator localIterator = this.connections.iterator();
    while (localIterator.hasNext())
    {
      RealConnection localRealConnection = (RealConnection)localIterator.next();
      if ((localRealConnection.isEligible(paramAddress)) && (localRealConnection.isMultiplexed()) && (localRealConnection != paramStreamAllocation.connection()))
        return paramStreamAllocation.releaseAndAcquire(localRealConnection);
    }
    return null;
  }

  public void evictAll()
  {
    ArrayList localArrayList = new ArrayList();
    monitorenter;
    try
    {
      Iterator localIterator2 = this.connections.iterator();
      while (localIterator2.hasNext())
      {
        RealConnection localRealConnection = (RealConnection)localIterator2.next();
        if (!localRealConnection.allocations.isEmpty())
          continue;
        localRealConnection.noNewStreams = true;
        localArrayList.add(localRealConnection);
        localIterator2.remove();
      }
    }
    finally
    {
      monitorexit;
    }
    monitorexit;
    Iterator localIterator1 = localObject.iterator();
    while (localIterator1.hasNext())
      Util.closeQuietly(((RealConnection)localIterator1.next()).socket());
  }

  RealConnection get(Address paramAddress, StreamAllocation paramStreamAllocation)
  {
    assert (Thread.holdsLock(this));
    Iterator localIterator = this.connections.iterator();
    while (localIterator.hasNext())
    {
      RealConnection localRealConnection = (RealConnection)localIterator.next();
      if (!localRealConnection.isEligible(paramAddress))
        continue;
      paramStreamAllocation.acquire(localRealConnection);
      return localRealConnection;
    }
    return null;
  }

  public int idleConnectionCount()
  {
    monitorenter;
    int i = 0;
    try
    {
      Iterator localIterator = this.connections.iterator();
      while (localIterator.hasNext())
      {
        boolean bool = ((RealConnection)localIterator.next()).allocations.isEmpty();
        if (!bool)
          continue;
        i += 1;
      }
      return i;
    }
    finally
    {
      monitorexit;
    }
    throw localObject;
  }

  void put(RealConnection paramRealConnection)
  {
    assert (Thread.holdsLock(this));
    if (!this.cleanupRunning)
    {
      this.cleanupRunning = true;
      executor.execute(this.cleanupRunnable);
    }
    this.connections.add(paramRealConnection);
  }
}

/* Location:           C:\Users\c_jealom1\Documents\Scripts\Android\Fathom_com.brynk.fathom\Fathom_com.brynk.fathom-dex2jar.jar
 * Qualified Name:     okhttp3.ConnectionPool
 * JD-Core Version:    0.6.0
 */
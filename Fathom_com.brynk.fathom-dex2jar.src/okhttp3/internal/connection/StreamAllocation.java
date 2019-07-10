package okhttp3.internal.connection;

import java.io.IOException;
import java.lang.ref.Reference;
import java.lang.ref.WeakReference;
import java.net.Socket;
import java.util.List;
import okhttp3.Address;
import okhttp3.ConnectionPool;
import okhttp3.OkHttpClient;
import okhttp3.Route;
import okhttp3.internal.Internal;
import okhttp3.internal.Util;
import okhttp3.internal.http.HttpCodec;
import okhttp3.internal.http2.ConnectionShutdownException;
import okhttp3.internal.http2.ErrorCode;
import okhttp3.internal.http2.StreamResetException;

public final class StreamAllocation
{
  public final Address address;
  private final Object callStackTrace;
  private boolean canceled;
  private HttpCodec codec;
  private RealConnection connection;
  private final ConnectionPool connectionPool;
  private int refusedStreamCount;
  private boolean released;
  private Route route;
  private final RouteSelector routeSelector;

  static
  {
    if (!StreamAllocation.class.desiredAssertionStatus());
    for (boolean bool = true; ; bool = false)
    {
      $assertionsDisabled = bool;
      return;
    }
  }

  public StreamAllocation(ConnectionPool paramConnectionPool, Address paramAddress, Object paramObject)
  {
    this.connectionPool = paramConnectionPool;
    this.address = paramAddress;
    this.routeSelector = new RouteSelector(paramAddress, routeDatabase());
    this.callStackTrace = paramObject;
  }

  private Socket deallocate(boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3)
  {
    assert (Thread.holdsLock(this.connectionPool));
    if (paramBoolean3)
      this.codec = null;
    if (paramBoolean2)
      this.released = true;
    Object localObject3 = null;
    Object localObject2 = null;
    Object localObject1 = localObject3;
    if (this.connection != null)
    {
      if (paramBoolean1)
        this.connection.noNewStreams = true;
      localObject1 = localObject3;
      if (this.codec == null)
        if (!this.released)
        {
          localObject1 = localObject3;
          if (!this.connection.noNewStreams);
        }
        else
        {
          release(this.connection);
          localObject1 = localObject2;
          if (this.connection.allocations.isEmpty())
          {
            this.connection.idleAtNanos = System.nanoTime();
            localObject1 = localObject2;
            if (Internal.instance.connectionBecameIdle(this.connectionPool, this.connection))
              localObject1 = this.connection.socket();
          }
          this.connection = null;
        }
    }
    return (Socket)localObject1;
  }

  private RealConnection findConnection(int paramInt1, int paramInt2, int paramInt3, boolean paramBoolean)
    throws IOException
  {
    synchronized (this.connectionPool)
    {
      if (this.released)
        throw new IllegalStateException("released");
    }
    if (this.codec != null)
      throw new IllegalStateException("codec != null");
    if (this.canceled)
      throw new IOException("Canceled");
    ??? = this.connection;
    if ((??? != null) && (!((RealConnection)???).noNewStreams))
    {
      monitorexit;
      return ???;
    }
    Internal.instance.get(this.connectionPool, this.address, this);
    if (this.connection != null)
    {
      ??? = this.connection;
      monitorexit;
      return ???;
    }
    ??? = this.route;
    monitorexit;
    ??? = ???;
    if (??? == null)
      ??? = this.routeSelector.next();
    RealConnection localRealConnection;
    synchronized (this.connectionPool)
    {
      this.route = ((Route)???);
      this.refusedStreamCount = 0;
      localRealConnection = new RealConnection(this.connectionPool, (Route)???);
      acquire(localRealConnection);
      if (this.canceled)
        throw new IOException("Canceled");
    }
    monitorexit;
    localRealConnection.connect(paramInt1, paramInt2, paramInt3, paramBoolean);
    routeDatabase().connected(localRealConnection.route());
    ??? = null;
    synchronized (this.connectionPool)
    {
      Internal.instance.put(this.connectionPool, localRealConnection);
      Object localObject3 = localRealConnection;
      if (localRealConnection.isMultiplexed())
      {
        ??? = Internal.instance.deduplicate(this.connectionPool, this.address, this);
        localObject3 = this.connection;
      }
      Util.closeQuietly((Socket)???);
      return localObject3;
    }
  }

  private RealConnection findHealthyConnection(int paramInt1, int paramInt2, int paramInt3, boolean paramBoolean1, boolean paramBoolean2)
    throws IOException
  {
    while (true)
    {
      RealConnection localRealConnection = findConnection(paramInt1, paramInt2, paramInt3, paramBoolean1);
      synchronized (this.connectionPool)
      {
        if (localRealConnection.successCount == 0)
          return localRealConnection;
        if (localRealConnection.isHealthy(paramBoolean2))
          break;
        noNewStreams();
      }
    }
    return localObject;
  }

  private void release(RealConnection paramRealConnection)
  {
    int i = 0;
    int j = paramRealConnection.allocations.size();
    while (i < j)
    {
      if (((Reference)paramRealConnection.allocations.get(i)).get() == this)
      {
        paramRealConnection.allocations.remove(i);
        return;
      }
      i += 1;
    }
    throw new IllegalStateException();
  }

  private RouteDatabase routeDatabase()
  {
    return Internal.instance.routeDatabase(this.connectionPool);
  }

  public void acquire(RealConnection paramRealConnection)
  {
    assert (Thread.holdsLock(this.connectionPool));
    if (this.connection != null)
      throw new IllegalStateException();
    this.connection = paramRealConnection;
    paramRealConnection.allocations.add(new StreamAllocationReference(this, this.callStackTrace));
  }

  public void cancel()
  {
    RealConnection localRealConnection;
    do
      synchronized (this.connectionPool)
      {
        this.canceled = true;
        HttpCodec localHttpCodec = this.codec;
        localRealConnection = this.connection;
        if (localHttpCodec == null)
          continue;
        localHttpCodec.cancel();
        return;
      }
    while (localRealConnection == null);
    localRealConnection.cancel();
  }

  public HttpCodec codec()
  {
    synchronized (this.connectionPool)
    {
      HttpCodec localHttpCodec = this.codec;
      return localHttpCodec;
    }
  }

  public RealConnection connection()
  {
    monitorenter;
    try
    {
      RealConnection localRealConnection = this.connection;
      monitorexit;
      return localRealConnection;
    }
    finally
    {
      localObject = finally;
      monitorexit;
    }
    throw localObject;
  }

  public boolean hasMoreRoutes()
  {
    return (this.route != null) || (this.routeSelector.hasNext());
  }

  public HttpCodec newStream(OkHttpClient arg1, boolean paramBoolean)
  {
    int i = ???.connectTimeoutMillis();
    int j = ???.readTimeoutMillis();
    int k = ???.writeTimeoutMillis();
    boolean bool = ???.retryOnConnectionFailure();
    try
    {
      HttpCodec localHttpCodec = findHealthyConnection(i, j, k, bool, paramBoolean).newCodec(???, this);
      synchronized (this.connectionPool)
      {
        this.codec = localHttpCodec;
        return localHttpCodec;
      }
    }
    catch (IOException )
    {
    }
    throw new RouteException(???);
  }

  public void noNewStreams()
  {
    synchronized (this.connectionPool)
    {
      Socket localSocket = deallocate(true, false, false);
      Util.closeQuietly(localSocket);
      return;
    }
  }

  public void release()
  {
    synchronized (this.connectionPool)
    {
      Socket localSocket = deallocate(false, true, false);
      Util.closeQuietly(localSocket);
      return;
    }
  }

  public Socket releaseAndAcquire(RealConnection paramRealConnection)
  {
    assert (Thread.holdsLock(this.connectionPool));
    if ((this.codec != null) || (this.connection.allocations.size() != 1))
      throw new IllegalStateException();
    Reference localReference = (Reference)this.connection.allocations.get(0);
    Socket localSocket = deallocate(true, false, false);
    this.connection = paramRealConnection;
    paramRealConnection.allocations.add(localReference);
    return localSocket;
  }

  public void streamFailed(IOException paramIOException)
  {
    boolean bool2 = false;
    synchronized (this.connectionPool)
    {
      if ((paramIOException instanceof StreamResetException))
      {
        paramIOException = (StreamResetException)paramIOException;
        if (paramIOException.errorCode == ErrorCode.REFUSED_STREAM)
          this.refusedStreamCount += 1;
        if (paramIOException.errorCode == ErrorCode.REFUSED_STREAM)
        {
          bool1 = bool2;
          if (this.refusedStreamCount <= 1);
        }
        else
        {
          bool1 = true;
          this.route = null;
        }
      }
      do
      {
        do
        {
          do
          {
            paramIOException = deallocate(bool1, false, true);
            Util.closeQuietly(paramIOException);
            return;
            bool1 = bool2;
          }
          while (this.connection == null);
          if (!this.connection.isMultiplexed())
            break;
          bool1 = bool2;
        }
        while (!(paramIOException instanceof ConnectionShutdownException));
        bool2 = true;
        bool1 = bool2;
      }
      while (this.connection.successCount != 0);
      if ((this.route != null) && (paramIOException != null))
        this.routeSelector.connectFailed(this.route, paramIOException);
      this.route = null;
      boolean bool1 = bool2;
    }
  }

  // ERROR //
  public void streamFinished(boolean paramBoolean, HttpCodec paramHttpCodec)
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 44	okhttp3/internal/connection/StreamAllocation:connectionPool	Lokhttp3/ConnectionPool;
    //   4: astore_3
    //   5: aload_3
    //   6: monitorenter
    //   7: aload_2
    //   8: ifnull +11 -> 19
    //   11: aload_2
    //   12: aload_0
    //   13: getfield 72	okhttp3/internal/connection/StreamAllocation:codec	Lokhttp3/internal/http/HttpCodec;
    //   16: if_acmpeq +49 -> 65
    //   19: new 124	java/lang/IllegalStateException
    //   22: dup
    //   23: new 286	java/lang/StringBuilder
    //   26: dup
    //   27: invokespecial 287	java/lang/StringBuilder:<init>	()V
    //   30: ldc_w 289
    //   33: invokevirtual 293	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   36: aload_0
    //   37: getfield 72	okhttp3/internal/connection/StreamAllocation:codec	Lokhttp3/internal/http/HttpCodec;
    //   40: invokevirtual 296	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   43: ldc_w 298
    //   46: invokevirtual 293	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   49: aload_2
    //   50: invokevirtual 296	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   53: invokevirtual 302	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   56: invokespecial 128	java/lang/IllegalStateException:<init>	(Ljava/lang/String;)V
    //   59: athrow
    //   60: astore_2
    //   61: aload_3
    //   62: monitorexit
    //   63: aload_2
    //   64: athrow
    //   65: iload_1
    //   66: ifne +18 -> 84
    //   69: aload_0
    //   70: getfield 76	okhttp3/internal/connection/StreamAllocation:connection	Lokhttp3/internal/connection/RealConnection;
    //   73: astore_2
    //   74: aload_2
    //   75: aload_2
    //   76: getfield 190	okhttp3/internal/connection/RealConnection:successCount	I
    //   79: iconst_1
    //   80: iadd
    //   81: putfield 190	okhttp3/internal/connection/RealConnection:successCount	I
    //   84: aload_0
    //   85: iload_1
    //   86: iconst_0
    //   87: iconst_1
    //   88: invokespecial 262	okhttp3/internal/connection/StreamAllocation:deallocate	(ZZZ)Ljava/net/Socket;
    //   91: astore_2
    //   92: aload_3
    //   93: monitorexit
    //   94: aload_2
    //   95: invokestatic 182	okhttp3/internal/Util:closeQuietly	(Ljava/net/Socket;)V
    //   98: return
    //
    // Exception table:
    //   from	to	target	type
    //   11	19	60	finally
    //   19	60	60	finally
    //   61	63	60	finally
    //   69	84	60	finally
    //   84	94	60	finally
  }

  public String toString()
  {
    RealConnection localRealConnection = connection();
    if (localRealConnection != null)
      return localRealConnection.toString();
    return this.address.toString();
  }

  public static final class StreamAllocationReference extends WeakReference<StreamAllocation>
  {
    public final Object callStackTrace;

    StreamAllocationReference(StreamAllocation paramStreamAllocation, Object paramObject)
    {
      super();
      this.callStackTrace = paramObject;
    }
  }
}

/* Location:           C:\Users\c_jealom1\Documents\Scripts\Android\Fathom_com.brynk.fathom\Fathom_com.brynk.fathom-dex2jar.jar
 * Qualified Name:     okhttp3.internal.connection.StreamAllocation
 * JD-Core Version:    0.6.0
 */
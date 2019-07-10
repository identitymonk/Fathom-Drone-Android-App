package okhttp3;

import java.io.Closeable;
import java.io.File;
import java.io.Flushable;
import java.io.IOException;
import java.security.cert.Certificate;
import java.security.cert.CertificateEncodingException;
import java.security.cert.CertificateException;
import java.security.cert.CertificateFactory;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;
import okhttp3.internal.Util;
import okhttp3.internal.cache.CacheRequest;
import okhttp3.internal.cache.CacheStrategy;
import okhttp3.internal.cache.DiskLruCache;
import okhttp3.internal.cache.DiskLruCache.Editor;
import okhttp3.internal.cache.DiskLruCache.Snapshot;
import okhttp3.internal.cache.InternalCache;
import okhttp3.internal.http.HttpHeaders;
import okhttp3.internal.http.HttpMethod;
import okhttp3.internal.http.StatusLine;
import okhttp3.internal.io.FileSystem;
import okhttp3.internal.platform.Platform;
import okio.Buffer;
import okio.BufferedSink;
import okio.BufferedSource;
import okio.ByteString;
import okio.ForwardingSink;
import okio.ForwardingSource;
import okio.Okio;
import okio.Sink;
import okio.Source;

public final class Cache
  implements Closeable, Flushable
{
  private static final int ENTRY_BODY = 1;
  private static final int ENTRY_COUNT = 2;
  private static final int ENTRY_METADATA = 0;
  private static final int VERSION = 201105;
  final DiskLruCache cache;
  private int hitCount;
  final InternalCache internalCache = new InternalCache()
  {
    public Response get(Request paramRequest)
      throws IOException
    {
      return Cache.this.get(paramRequest);
    }

    public CacheRequest put(Response paramResponse)
      throws IOException
    {
      return Cache.this.put(paramResponse);
    }

    public void remove(Request paramRequest)
      throws IOException
    {
      Cache.this.remove(paramRequest);
    }

    public void trackConditionalCacheHit()
    {
      Cache.this.trackConditionalCacheHit();
    }

    public void trackResponse(CacheStrategy paramCacheStrategy)
    {
      Cache.this.trackResponse(paramCacheStrategy);
    }

    public void update(Response paramResponse1, Response paramResponse2)
    {
      Cache.this.update(paramResponse1, paramResponse2);
    }
  };
  private int networkCount;
  private int requestCount;
  int writeAbortCount;
  int writeSuccessCount;

  public Cache(File paramFile, long paramLong)
  {
    this(paramFile, paramLong, FileSystem.SYSTEM);
  }

  Cache(File paramFile, long paramLong, FileSystem paramFileSystem)
  {
    this.cache = DiskLruCache.create(paramFileSystem, paramFile, 201105, 2, paramLong);
  }

  private void abortQuietly(DiskLruCache.Editor paramEditor)
  {
    if (paramEditor != null);
    try
    {
      paramEditor.abort();
      return;
    }
    catch (IOException paramEditor)
    {
    }
  }

  public static String key(HttpUrl paramHttpUrl)
  {
    return ByteString.encodeUtf8(paramHttpUrl.toString()).md5().hex();
  }

  static int readInt(BufferedSource paramBufferedSource)
    throws IOException
  {
    long l;
    try
    {
      l = paramBufferedSource.readDecimalLong();
      paramBufferedSource = paramBufferedSource.readUtf8LineStrict();
      if ((l < 0L) || (l > 2147483647L) || (!paramBufferedSource.isEmpty()))
        throw new IOException("expected an int but was \"" + l + paramBufferedSource + "\"");
    }
    catch (NumberFormatException paramBufferedSource)
    {
      throw new IOException(paramBufferedSource.getMessage());
    }
    return (int)l;
  }

  public void close()
    throws IOException
  {
    this.cache.close();
  }

  public void delete()
    throws IOException
  {
    this.cache.delete();
  }

  public File directory()
  {
    return this.cache.getDirectory();
  }

  public void evictAll()
    throws IOException
  {
    this.cache.evictAll();
  }

  public void flush()
    throws IOException
  {
    this.cache.flush();
  }

  Response get(Request paramRequest)
  {
    Object localObject = key(paramRequest.url());
    while (true)
    {
      try
      {
        localObject = this.cache.get((String)localObject);
        if (localObject == null)
        {
          localObject = null;
          return localObject;
        }
      }
      catch (IOException paramRequest)
      {
        return null;
      }
      try
      {
        Entry localEntry = new Entry(((DiskLruCache.Snapshot)localObject).getSource(0));
        Response localResponse = localEntry.response((DiskLruCache.Snapshot)localObject);
        localObject = localResponse;
        if (localEntry.matches(paramRequest, localResponse))
          continue;
        Util.closeQuietly(localResponse.body());
        return null;
      }
      catch (IOException paramRequest)
      {
        Util.closeQuietly((Flushable)localObject);
      }
    }
    return (Response)null;
  }

  public int hitCount()
  {
    monitorenter;
    try
    {
      int i = this.hitCount;
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

  public void initialize()
    throws IOException
  {
    this.cache.initialize();
  }

  public boolean isClosed()
  {
    return this.cache.isClosed();
  }

  public long maxSize()
  {
    return this.cache.getMaxSize();
  }

  public int networkCount()
  {
    monitorenter;
    try
    {
      int i = this.networkCount;
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

  CacheRequest put(Response paramResponse)
  {
    Object localObject = paramResponse.request().method();
    if (HttpMethod.invalidatesCache(paramResponse.request().method()));
    try
    {
      remove(paramResponse.request());
      while (true)
      {
        return null;
        if ((!((String)localObject).equals("GET")) || (HttpHeaders.hasVaryAll(paramResponse)))
          continue;
        Entry localEntry = new Entry(paramResponse);
        localObject = null;
        try
        {
          paramResponse = this.cache.edit(key(paramResponse.request().url()));
          if (paramResponse == null)
            continue;
          localObject = paramResponse;
          localEntry.writeTo(paramResponse);
          localObject = paramResponse;
          paramResponse = new CacheRequestImpl(paramResponse);
          return paramResponse;
        }
        catch (IOException paramResponse)
        {
          abortQuietly((DiskLruCache.Editor)localObject);
          return null;
        }
      }
    }
    catch (IOException paramResponse)
    {
    }
    return (CacheRequest)null;
  }

  void remove(Request paramRequest)
    throws IOException
  {
    this.cache.remove(key(paramRequest.url()));
  }

  public int requestCount()
  {
    monitorenter;
    try
    {
      int i = this.requestCount;
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

  public long size()
    throws IOException
  {
    return this.cache.size();
  }

  void trackConditionalCacheHit()
  {
    monitorenter;
    try
    {
      this.hitCount += 1;
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

  void trackResponse(CacheStrategy paramCacheStrategy)
  {
    monitorenter;
    try
    {
      this.requestCount += 1;
      if (paramCacheStrategy.networkRequest != null)
        this.networkCount += 1;
      while (true)
      {
        return;
        if (paramCacheStrategy.cacheResponse == null)
          continue;
        this.hitCount += 1;
      }
    }
    finally
    {
      monitorexit;
    }
    throw paramCacheStrategy;
  }

  void update(Response paramResponse1, Response paramResponse2)
  {
    Entry localEntry = new Entry(paramResponse2);
    paramResponse2 = ((CacheResponseBody)paramResponse1.body()).snapshot;
    paramResponse1 = null;
    try
    {
      paramResponse2 = paramResponse2.edit();
      if (paramResponse2 != null)
      {
        paramResponse1 = paramResponse2;
        localEntry.writeTo(paramResponse2);
        paramResponse1 = paramResponse2;
        paramResponse2.commit();
      }
      return;
    }
    catch (IOException paramResponse2)
    {
      abortQuietly(paramResponse1);
    }
  }

  public Iterator<String> urls()
    throws IOException
  {
    return new Iterator()
    {
      boolean canRemove;
      final Iterator<DiskLruCache.Snapshot> delegate = Cache.this.cache.snapshots();
      String nextUrl;

      // ERROR //
      public boolean hasNext()
      {
        // Byte code:
        //   0: aload_0
        //   1: getfield 47	okhttp3/Cache$2:nextUrl	Ljava/lang/String;
        //   4: ifnull +5 -> 9
        //   7: iconst_1
        //   8: ireturn
        //   9: aload_0
        //   10: iconst_0
        //   11: putfield 49	okhttp3/Cache$2:canRemove	Z
        //   14: aload_0
        //   15: getfield 41	okhttp3/Cache$2:delegate	Ljava/util/Iterator;
        //   18: invokeinterface 51 1 0
        //   23: ifeq +54 -> 77
        //   26: aload_0
        //   27: getfield 41	okhttp3/Cache$2:delegate	Ljava/util/Iterator;
        //   30: invokeinterface 55 1 0
        //   35: checkcast 57	okhttp3/internal/cache/DiskLruCache$Snapshot
        //   38: astore_1
        //   39: aload_0
        //   40: aload_1
        //   41: iconst_0
        //   42: invokevirtual 61	okhttp3/internal/cache/DiskLruCache$Snapshot:getSource	(I)Lokio/Source;
        //   45: invokestatic 67	okio/Okio:buffer	(Lokio/Source;)Lokio/BufferedSource;
        //   48: invokeinterface 73 1 0
        //   53: putfield 47	okhttp3/Cache$2:nextUrl	Ljava/lang/String;
        //   56: aload_1
        //   57: invokevirtual 76	okhttp3/internal/cache/DiskLruCache$Snapshot:close	()V
        //   60: iconst_1
        //   61: ireturn
        //   62: astore_2
        //   63: aload_1
        //   64: invokevirtual 76	okhttp3/internal/cache/DiskLruCache$Snapshot:close	()V
        //   67: goto -53 -> 14
        //   70: astore_2
        //   71: aload_1
        //   72: invokevirtual 76	okhttp3/internal/cache/DiskLruCache$Snapshot:close	()V
        //   75: aload_2
        //   76: athrow
        //   77: iconst_0
        //   78: ireturn
        //
        // Exception table:
        //   from	to	target	type
        //   39	56	62	java/io/IOException
        //   39	56	70	finally
      }

      public String next()
      {
        if (!hasNext())
          throw new NoSuchElementException();
        String str = this.nextUrl;
        this.nextUrl = null;
        this.canRemove = true;
        return str;
      }

      public void remove()
      {
        if (!this.canRemove)
          throw new IllegalStateException("remove() before next()");
        this.delegate.remove();
      }
    };
  }

  public int writeAbortCount()
  {
    monitorenter;
    try
    {
      int i = this.writeAbortCount;
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

  public int writeSuccessCount()
  {
    monitorenter;
    try
    {
      int i = this.writeSuccessCount;
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

  private final class CacheRequestImpl
    implements CacheRequest
  {
    private Sink body;
    private Sink cacheOut;
    boolean done;
    private final DiskLruCache.Editor editor;

    public CacheRequestImpl(DiskLruCache.Editor arg2)
    {
      DiskLruCache.Editor localEditor;
      this.editor = localEditor;
      this.cacheOut = localEditor.newSink(1);
      this.body = new ForwardingSink(this.cacheOut, Cache.this, localEditor)
      {
        public void close()
          throws IOException
        {
          synchronized (Cache.this)
          {
            if (Cache.CacheRequestImpl.this.done)
              return;
            Cache.CacheRequestImpl.this.done = true;
            Cache localCache2 = Cache.this;
            localCache2.writeSuccessCount += 1;
            super.close();
            this.val$editor.commit();
            return;
          }
        }
      };
    }

    public void abort()
    {
      synchronized (Cache.this)
      {
        if (this.done)
          return;
        this.done = true;
        Cache localCache2 = Cache.this;
        localCache2.writeAbortCount += 1;
        Util.closeQuietly(this.cacheOut);
        try
        {
          this.editor.abort();
          return;
        }
        catch (IOException localIOException)
        {
          return;
        }
      }
    }

    public Sink body()
    {
      return this.body;
    }
  }

  private static class CacheResponseBody extends ResponseBody
  {
    private final BufferedSource bodySource;
    private final String contentLength;
    private final String contentType;
    final DiskLruCache.Snapshot snapshot;

    public CacheResponseBody(DiskLruCache.Snapshot paramSnapshot, String paramString1, String paramString2)
    {
      this.snapshot = paramSnapshot;
      this.contentType = paramString1;
      this.contentLength = paramString2;
      this.bodySource = Okio.buffer(new ForwardingSource(paramSnapshot.getSource(1), paramSnapshot)
      {
        public void close()
          throws IOException
        {
          this.val$snapshot.close();
          super.close();
        }
      });
    }

    public long contentLength()
    {
      long l = -1L;
      try
      {
        if (this.contentLength != null)
          l = Long.parseLong(this.contentLength);
        return l;
      }
      catch (NumberFormatException localNumberFormatException)
      {
      }
      return -1L;
    }

    public MediaType contentType()
    {
      if (this.contentType != null)
        return MediaType.parse(this.contentType);
      return null;
    }

    public BufferedSource source()
    {
      return this.bodySource;
    }
  }

  private static final class Entry
  {
    private static final String RECEIVED_MILLIS;
    private static final String SENT_MILLIS = Platform.get().getPrefix() + "-Sent-Millis";
    private final int code;
    private final Handshake handshake;
    private final String message;
    private final Protocol protocol;
    private final long receivedResponseMillis;
    private final String requestMethod;
    private final Headers responseHeaders;
    private final long sentRequestMillis;
    private final String url;
    private final Headers varyHeaders;

    static
    {
      RECEIVED_MILLIS = Platform.get().getPrefix() + "-Received-Millis";
    }

    public Entry(Response paramResponse)
    {
      this.url = paramResponse.request().url().toString();
      this.varyHeaders = HttpHeaders.varyHeaders(paramResponse);
      this.requestMethod = paramResponse.request().method();
      this.protocol = paramResponse.protocol();
      this.code = paramResponse.code();
      this.message = paramResponse.message();
      this.responseHeaders = paramResponse.headers();
      this.handshake = paramResponse.handshake();
      this.sentRequestMillis = paramResponse.sentRequestAtMillis();
      this.receivedResponseMillis = paramResponse.receivedResponseAtMillis();
    }

    public Entry(Source paramSource)
      throws IOException
    {
      while (true)
      {
        try
        {
          BufferedSource localBufferedSource1 = Okio.buffer(paramSource);
          this.url = localBufferedSource1.readUtf8LineStrict();
          this.requestMethod = localBufferedSource1.readUtf8LineStrict();
          localObject1 = new Headers.Builder();
          int j = Cache.readInt(localBufferedSource1);
          int i = 0;
          if (i >= j)
            continue;
          ((Headers.Builder)localObject1).addLenient(localBufferedSource1.readUtf8LineStrict());
          i += 1;
          continue;
          this.varyHeaders = ((Headers.Builder)localObject1).build();
          localObject1 = StatusLine.parse(localBufferedSource1.readUtf8LineStrict());
          this.protocol = ((StatusLine)localObject1).protocol;
          this.code = ((StatusLine)localObject1).code;
          this.message = ((StatusLine)localObject1).message;
          localObject1 = new Headers.Builder();
          j = Cache.readInt(localBufferedSource1);
          i = 0;
          if (i >= j)
            continue;
          ((Headers.Builder)localObject1).addLenient(localBufferedSource1.readUtf8LineStrict());
          i += 1;
          continue;
          localObject2 = ((Headers.Builder)localObject1).get(SENT_MILLIS);
          localObject3 = ((Headers.Builder)localObject1).get(RECEIVED_MILLIS);
          ((Headers.Builder)localObject1).removeAll(SENT_MILLIS);
          ((Headers.Builder)localObject1).removeAll(RECEIVED_MILLIS);
          if (localObject2 != null)
          {
            l = Long.parseLong((String)localObject2);
            this.sentRequestMillis = l;
            if (localObject3 == null)
              break label321;
            l = Long.parseLong((String)localObject3);
            this.receivedResponseMillis = l;
            this.responseHeaders = ((Headers.Builder)localObject1).build();
            if (!isHttps())
              break label405;
            localObject1 = localBufferedSource1.readUtf8LineStrict();
            if (((String)localObject1).length() <= 0)
              break;
            throw new IOException("expected \"\" but was \"" + (String)localObject1 + "\"");
          }
        }
        finally
        {
          paramSource.close();
        }
        long l = 0L;
        continue;
        label321: l = 0L;
      }
      Object localObject1 = CipherSuite.forJavaName(localBufferedSource2.readUtf8LineStrict());
      Object localObject2 = readCertificateList(localBufferedSource2);
      Object localObject3 = readCertificateList(localBufferedSource2);
      TlsVersion localTlsVersion;
      if (!localBufferedSource2.exhausted())
        localTlsVersion = TlsVersion.forJavaName(localBufferedSource2.readUtf8LineStrict());
      label405: for (this.handshake = Handshake.get(localTlsVersion, (CipherSuite)localObject1, (List)localObject2, (List)localObject3); ; this.handshake = null)
      {
        paramSource.close();
        return;
        localTlsVersion = null;
        break;
      }
    }

    private boolean isHttps()
    {
      return this.url.startsWith("https://");
    }

    private List<Certificate> readCertificateList(BufferedSource paramBufferedSource)
      throws IOException
    {
      int j = Cache.readInt(paramBufferedSource);
      Object localObject;
      if (j == -1)
        localObject = Collections.emptyList();
      while (true)
      {
        return localObject;
        try
        {
          CertificateFactory localCertificateFactory = CertificateFactory.getInstance("X.509");
          ArrayList localArrayList = new ArrayList(j);
          int i = 0;
          while (true)
          {
            localObject = localArrayList;
            if (i >= j)
              break;
            localObject = paramBufferedSource.readUtf8LineStrict();
            Buffer localBuffer = new Buffer();
            localBuffer.write(ByteString.decodeBase64((String)localObject));
            localArrayList.add(localCertificateFactory.generateCertificate(localBuffer.inputStream()));
            i += 1;
          }
        }
        catch (CertificateException paramBufferedSource)
        {
        }
      }
      throw new IOException(paramBufferedSource.getMessage());
    }

    private void writeCertList(BufferedSink paramBufferedSink, List<Certificate> paramList)
      throws IOException
    {
      try
      {
        paramBufferedSink.writeDecimalLong(paramList.size()).writeByte(10);
        int i = 0;
        int j = paramList.size();
        while (i < j)
        {
          paramBufferedSink.writeUtf8(ByteString.of(((Certificate)paramList.get(i)).getEncoded()).base64()).writeByte(10);
          i += 1;
        }
      }
      catch (CertificateEncodingException paramBufferedSink)
      {
        throw new IOException(paramBufferedSink.getMessage());
      }
    }

    public boolean matches(Request paramRequest, Response paramResponse)
    {
      return (this.url.equals(paramRequest.url().toString())) && (this.requestMethod.equals(paramRequest.method())) && (HttpHeaders.varyMatches(paramResponse, this.varyHeaders, paramRequest));
    }

    public Response response(DiskLruCache.Snapshot paramSnapshot)
    {
      String str1 = this.responseHeaders.get("Content-Type");
      String str2 = this.responseHeaders.get("Content-Length");
      Request localRequest = new Request.Builder().url(this.url).method(this.requestMethod, null).headers(this.varyHeaders).build();
      return new Response.Builder().request(localRequest).protocol(this.protocol).code(this.code).message(this.message).headers(this.responseHeaders).body(new Cache.CacheResponseBody(paramSnapshot, str1, str2)).handshake(this.handshake).sentRequestAtMillis(this.sentRequestMillis).receivedResponseAtMillis(this.receivedResponseMillis).build();
    }

    public void writeTo(DiskLruCache.Editor paramEditor)
      throws IOException
    {
      paramEditor = Okio.buffer(paramEditor.newSink(0));
      paramEditor.writeUtf8(this.url).writeByte(10);
      paramEditor.writeUtf8(this.requestMethod).writeByte(10);
      paramEditor.writeDecimalLong(this.varyHeaders.size()).writeByte(10);
      int i = 0;
      int j = this.varyHeaders.size();
      while (i < j)
      {
        paramEditor.writeUtf8(this.varyHeaders.name(i)).writeUtf8(": ").writeUtf8(this.varyHeaders.value(i)).writeByte(10);
        i += 1;
      }
      paramEditor.writeUtf8(new StatusLine(this.protocol, this.code, this.message).toString()).writeByte(10);
      paramEditor.writeDecimalLong(this.responseHeaders.size() + 2).writeByte(10);
      i = 0;
      j = this.responseHeaders.size();
      while (i < j)
      {
        paramEditor.writeUtf8(this.responseHeaders.name(i)).writeUtf8(": ").writeUtf8(this.responseHeaders.value(i)).writeByte(10);
        i += 1;
      }
      paramEditor.writeUtf8(SENT_MILLIS).writeUtf8(": ").writeDecimalLong(this.sentRequestMillis).writeByte(10);
      paramEditor.writeUtf8(RECEIVED_MILLIS).writeUtf8(": ").writeDecimalLong(this.receivedResponseMillis).writeByte(10);
      if (isHttps())
      {
        paramEditor.writeByte(10);
        paramEditor.writeUtf8(this.handshake.cipherSuite().javaName()).writeByte(10);
        writeCertList(paramEditor, this.handshake.peerCertificates());
        writeCertList(paramEditor, this.handshake.localCertificates());
        if (this.handshake.tlsVersion() != null)
          paramEditor.writeUtf8(this.handshake.tlsVersion().javaName()).writeByte(10);
      }
      paramEditor.close();
    }
  }
}

/* Location:           C:\Users\c_jealom1\Documents\Scripts\Android\Fathom_com.brynk.fathom\Fathom_com.brynk.fathom-dex2jar.jar
 * Qualified Name:     okhttp3.Cache
 * JD-Core Version:    0.6.0
 */
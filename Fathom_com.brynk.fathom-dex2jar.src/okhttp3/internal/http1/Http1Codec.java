package okhttp3.internal.http1;

import java.io.EOFException;
import java.io.IOException;
import java.net.ProtocolException;
import java.net.Proxy;
import java.util.concurrent.TimeUnit;
import okhttp3.Headers;
import okhttp3.Headers.Builder;
import okhttp3.HttpUrl;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.Response.Builder;
import okhttp3.ResponseBody;
import okhttp3.Route;
import okhttp3.internal.Internal;
import okhttp3.internal.Util;
import okhttp3.internal.connection.RealConnection;
import okhttp3.internal.connection.StreamAllocation;
import okhttp3.internal.http.HttpCodec;
import okhttp3.internal.http.HttpHeaders;
import okhttp3.internal.http.RealResponseBody;
import okhttp3.internal.http.RequestLine;
import okhttp3.internal.http.StatusLine;
import okio.Buffer;
import okio.BufferedSink;
import okio.BufferedSource;
import okio.ForwardingTimeout;
import okio.Okio;
import okio.Sink;
import okio.Source;
import okio.Timeout;

public final class Http1Codec
  implements HttpCodec
{
  private static final int STATE_CLOSED = 6;
  private static final int STATE_IDLE = 0;
  private static final int STATE_OPEN_REQUEST_BODY = 1;
  private static final int STATE_OPEN_RESPONSE_BODY = 4;
  private static final int STATE_READING_RESPONSE_BODY = 5;
  private static final int STATE_READ_RESPONSE_HEADERS = 3;
  private static final int STATE_WRITING_REQUEST_BODY = 2;
  final OkHttpClient client;
  final BufferedSink sink;
  final BufferedSource source;
  int state = 0;
  final StreamAllocation streamAllocation;

  public Http1Codec(OkHttpClient paramOkHttpClient, StreamAllocation paramStreamAllocation, BufferedSource paramBufferedSource, BufferedSink paramBufferedSink)
  {
    this.client = paramOkHttpClient;
    this.streamAllocation = paramStreamAllocation;
    this.source = paramBufferedSource;
    this.sink = paramBufferedSink;
  }

  private Source getTransferStream(Response paramResponse)
    throws IOException
  {
    if (!HttpHeaders.hasBody(paramResponse))
      return newFixedLengthSource(0L);
    if ("chunked".equalsIgnoreCase(paramResponse.header("Transfer-Encoding")))
      return newChunkedSource(paramResponse.request().url());
    long l = HttpHeaders.contentLength(paramResponse);
    if (l != -1L)
      return newFixedLengthSource(l);
    return newUnknownLengthSource();
  }

  public void cancel()
  {
    RealConnection localRealConnection = this.streamAllocation.connection();
    if (localRealConnection != null)
      localRealConnection.cancel();
  }

  public Sink createRequestBody(Request paramRequest, long paramLong)
  {
    if ("chunked".equalsIgnoreCase(paramRequest.header("Transfer-Encoding")))
      return newChunkedSink();
    if (paramLong != -1L)
      return newFixedLengthSink(paramLong);
    throw new IllegalStateException("Cannot stream a request body without chunked encoding or a known content length!");
  }

  void detachTimeout(ForwardingTimeout paramForwardingTimeout)
  {
    Timeout localTimeout = paramForwardingTimeout.delegate();
    paramForwardingTimeout.setDelegate(Timeout.NONE);
    localTimeout.clearDeadline();
    localTimeout.clearTimeout();
  }

  public void finishRequest()
    throws IOException
  {
    this.sink.flush();
  }

  public void flushRequest()
    throws IOException
  {
    this.sink.flush();
  }

  public boolean isClosed()
  {
    return this.state == 6;
  }

  public Sink newChunkedSink()
  {
    if (this.state != 1)
      throw new IllegalStateException("state: " + this.state);
    this.state = 2;
    return new ChunkedSink();
  }

  public Source newChunkedSource(HttpUrl paramHttpUrl)
    throws IOException
  {
    if (this.state != 4)
      throw new IllegalStateException("state: " + this.state);
    this.state = 5;
    return new ChunkedSource(paramHttpUrl);
  }

  public Sink newFixedLengthSink(long paramLong)
  {
    if (this.state != 1)
      throw new IllegalStateException("state: " + this.state);
    this.state = 2;
    return new FixedLengthSink(paramLong);
  }

  public Source newFixedLengthSource(long paramLong)
    throws IOException
  {
    if (this.state != 4)
      throw new IllegalStateException("state: " + this.state);
    this.state = 5;
    return new FixedLengthSource(paramLong);
  }

  public Source newUnknownLengthSource()
    throws IOException
  {
    if (this.state != 4)
      throw new IllegalStateException("state: " + this.state);
    if (this.streamAllocation == null)
      throw new IllegalStateException("streamAllocation == null");
    this.state = 5;
    this.streamAllocation.noNewStreams();
    return new UnknownLengthSource();
  }

  public ResponseBody openResponseBody(Response paramResponse)
    throws IOException
  {
    Source localSource = getTransferStream(paramResponse);
    return new RealResponseBody(paramResponse.headers(), Okio.buffer(localSource));
  }

  public Headers readHeaders()
    throws IOException
  {
    Headers.Builder localBuilder = new Headers.Builder();
    while (true)
    {
      String str = this.source.readUtf8LineStrict();
      if (str.length() == 0)
        break;
      Internal.instance.addLenient(localBuilder, str);
    }
    return localBuilder.build();
  }

  public Response.Builder readResponseHeaders(boolean paramBoolean)
    throws IOException
  {
    if ((this.state != 1) && (this.state != 3))
      throw new IllegalStateException("state: " + this.state);
    Object localObject;
    try
    {
      StatusLine localStatusLine = StatusLine.parse(this.source.readUtf8LineStrict());
      localObject = new Response.Builder().protocol(localStatusLine.protocol).code(localStatusLine.code).message(localStatusLine.message).headers(readHeaders());
      if ((paramBoolean) && (localStatusLine.code == 100))
        return null;
      this.state = 4;
      return localObject;
    }
    catch (EOFException localEOFException)
    {
      localObject = new IOException("unexpected end of stream on " + this.streamAllocation);
      ((IOException)localObject).initCause(localEOFException);
    }
    throw ((Throwable)localObject);
  }

  public void writeRequest(Headers paramHeaders, String paramString)
    throws IOException
  {
    if (this.state != 0)
      throw new IllegalStateException("state: " + this.state);
    this.sink.writeUtf8(paramString).writeUtf8("\r\n");
    int i = 0;
    int j = paramHeaders.size();
    while (i < j)
    {
      this.sink.writeUtf8(paramHeaders.name(i)).writeUtf8(": ").writeUtf8(paramHeaders.value(i)).writeUtf8("\r\n");
      i += 1;
    }
    this.sink.writeUtf8("\r\n");
    this.state = 1;
  }

  public void writeRequestHeaders(Request paramRequest)
    throws IOException
  {
    String str = RequestLine.get(paramRequest, this.streamAllocation.connection().route().proxy().type());
    writeRequest(paramRequest.headers(), str);
  }

  private abstract class AbstractSource
    implements Source
  {
    protected boolean closed;
    protected final ForwardingTimeout timeout = new ForwardingTimeout(Http1Codec.this.source.timeout());

    private AbstractSource()
    {
    }

    protected final void endOfInput(boolean paramBoolean)
      throws IOException
    {
      if (Http1Codec.this.state == 6);
      do
      {
        return;
        if (Http1Codec.this.state != 5)
          throw new IllegalStateException("state: " + Http1Codec.this.state);
        Http1Codec.this.detachTimeout(this.timeout);
        Http1Codec.this.state = 6;
      }
      while (Http1Codec.this.streamAllocation == null);
      StreamAllocation localStreamAllocation = Http1Codec.this.streamAllocation;
      if (!paramBoolean);
      for (paramBoolean = true; ; paramBoolean = false)
      {
        localStreamAllocation.streamFinished(paramBoolean, Http1Codec.this);
        return;
      }
    }

    public Timeout timeout()
    {
      return this.timeout;
    }
  }

  private final class ChunkedSink
    implements Sink
  {
    private boolean closed;
    private final ForwardingTimeout timeout = new ForwardingTimeout(Http1Codec.this.sink.timeout());

    ChunkedSink()
    {
    }

    public void close()
      throws IOException
    {
      monitorenter;
      try
      {
        boolean bool = this.closed;
        if (bool);
        while (true)
        {
          return;
          this.closed = true;
          Http1Codec.this.sink.writeUtf8("0\r\n\r\n");
          Http1Codec.this.detachTimeout(this.timeout);
          Http1Codec.this.state = 3;
        }
      }
      finally
      {
        monitorexit;
      }
      throw localObject;
    }

    public void flush()
      throws IOException
    {
      monitorenter;
      try
      {
        boolean bool = this.closed;
        if (bool);
        while (true)
        {
          return;
          Http1Codec.this.sink.flush();
        }
      }
      finally
      {
        monitorexit;
      }
      throw localObject;
    }

    public Timeout timeout()
    {
      return this.timeout;
    }

    public void write(Buffer paramBuffer, long paramLong)
      throws IOException
    {
      if (this.closed)
        throw new IllegalStateException("closed");
      if (paramLong == 0L)
        return;
      Http1Codec.this.sink.writeHexadecimalUnsignedLong(paramLong);
      Http1Codec.this.sink.writeUtf8("\r\n");
      Http1Codec.this.sink.write(paramBuffer, paramLong);
      Http1Codec.this.sink.writeUtf8("\r\n");
    }
  }

  private class ChunkedSource extends Http1Codec.AbstractSource
  {
    private static final long NO_CHUNK_YET = -1L;
    private long bytesRemainingInChunk = -1L;
    private boolean hasMoreChunks = true;
    private final HttpUrl url;

    ChunkedSource(HttpUrl arg2)
    {
      super(null);
      Object localObject;
      this.url = localObject;
    }

    private void readChunkSize()
      throws IOException
    {
      if (this.bytesRemainingInChunk != -1L)
        Http1Codec.this.source.readUtf8LineStrict();
      try
      {
        this.bytesRemainingInChunk = Http1Codec.this.source.readHexadecimalUnsignedLong();
        String str = Http1Codec.this.source.readUtf8LineStrict().trim();
        if ((this.bytesRemainingInChunk < 0L) || ((!str.isEmpty()) && (!str.startsWith(";"))))
          throw new ProtocolException("expected chunk size and optional extensions but was \"" + this.bytesRemainingInChunk + str + "\"");
      }
      catch (NumberFormatException localNumberFormatException)
      {
        throw new ProtocolException(localNumberFormatException.getMessage());
      }
      if (this.bytesRemainingInChunk == 0L)
      {
        this.hasMoreChunks = false;
        HttpHeaders.receiveHeaders(Http1Codec.this.client.cookieJar(), this.url, Http1Codec.this.readHeaders());
        endOfInput(true);
      }
    }

    public void close()
      throws IOException
    {
      if (this.closed)
        return;
      if ((this.hasMoreChunks) && (!Util.discard(this, 100, TimeUnit.MILLISECONDS)))
        endOfInput(false);
      this.closed = true;
    }

    public long read(Buffer paramBuffer, long paramLong)
      throws IOException
    {
      if (paramLong < 0L)
        throw new IllegalArgumentException("byteCount < 0: " + paramLong);
      if (this.closed)
        throw new IllegalStateException("closed");
      if (!this.hasMoreChunks)
        return -1L;
      if ((this.bytesRemainingInChunk == 0L) || (this.bytesRemainingInChunk == -1L))
      {
        readChunkSize();
        if (!this.hasMoreChunks)
          return -1L;
      }
      paramLong = Http1Codec.this.source.read(paramBuffer, Math.min(paramLong, this.bytesRemainingInChunk));
      if (paramLong == -1L)
      {
        endOfInput(false);
        throw new ProtocolException("unexpected end of stream");
      }
      this.bytesRemainingInChunk -= paramLong;
      return paramLong;
    }
  }

  private final class FixedLengthSink
    implements Sink
  {
    private long bytesRemaining;
    private boolean closed;
    private final ForwardingTimeout timeout = new ForwardingTimeout(Http1Codec.this.sink.timeout());

    FixedLengthSink(long arg2)
    {
      Object localObject;
      this.bytesRemaining = localObject;
    }

    public void close()
      throws IOException
    {
      if (this.closed)
        return;
      this.closed = true;
      if (this.bytesRemaining > 0L)
        throw new ProtocolException("unexpected end of stream");
      Http1Codec.this.detachTimeout(this.timeout);
      Http1Codec.this.state = 3;
    }

    public void flush()
      throws IOException
    {
      if (this.closed)
        return;
      Http1Codec.this.sink.flush();
    }

    public Timeout timeout()
    {
      return this.timeout;
    }

    public void write(Buffer paramBuffer, long paramLong)
      throws IOException
    {
      if (this.closed)
        throw new IllegalStateException("closed");
      Util.checkOffsetAndCount(paramBuffer.size(), 0L, paramLong);
      if (paramLong > this.bytesRemaining)
        throw new ProtocolException("expected " + this.bytesRemaining + " bytes but received " + paramLong);
      Http1Codec.this.sink.write(paramBuffer, paramLong);
      this.bytesRemaining -= paramLong;
    }
  }

  private class FixedLengthSource extends Http1Codec.AbstractSource
  {
    private long bytesRemaining;

    public FixedLengthSource(long arg2)
      throws IOException
    {
      super(null);
      Object localObject;
      this.bytesRemaining = localObject;
      if (this.bytesRemaining == 0L)
        endOfInput(true);
    }

    public void close()
      throws IOException
    {
      if (this.closed)
        return;
      if ((this.bytesRemaining != 0L) && (!Util.discard(this, 100, TimeUnit.MILLISECONDS)))
        endOfInput(false);
      this.closed = true;
    }

    public long read(Buffer paramBuffer, long paramLong)
      throws IOException
    {
      if (paramLong < 0L)
        throw new IllegalArgumentException("byteCount < 0: " + paramLong);
      if (this.closed)
        throw new IllegalStateException("closed");
      if (this.bytesRemaining == 0L)
        paramLong = -1L;
      long l;
      do
      {
        return paramLong;
        l = Http1Codec.this.source.read(paramBuffer, Math.min(this.bytesRemaining, paramLong));
        if (l == -1L)
        {
          endOfInput(false);
          throw new ProtocolException("unexpected end of stream");
        }
        this.bytesRemaining -= l;
        paramLong = l;
      }
      while (this.bytesRemaining != 0L);
      endOfInput(true);
      return l;
    }
  }

  private class UnknownLengthSource extends Http1Codec.AbstractSource
  {
    private boolean inputExhausted;

    UnknownLengthSource()
    {
      super(null);
    }

    public void close()
      throws IOException
    {
      if (this.closed)
        return;
      if (!this.inputExhausted)
        endOfInput(false);
      this.closed = true;
    }

    public long read(Buffer paramBuffer, long paramLong)
      throws IOException
    {
      if (paramLong < 0L)
        throw new IllegalArgumentException("byteCount < 0: " + paramLong);
      if (this.closed)
        throw new IllegalStateException("closed");
      if (this.inputExhausted)
        paramLong = -1L;
      long l;
      do
      {
        return paramLong;
        l = Http1Codec.this.source.read(paramBuffer, paramLong);
        paramLong = l;
      }
      while (l != -1L);
      this.inputExhausted = true;
      endOfInput(true);
      return -1L;
    }
  }
}

/* Location:           C:\Users\c_jealom1\Documents\Scripts\Android\Fathom_com.brynk.fathom\Fathom_com.brynk.fathom-dex2jar.jar
 * Qualified Name:     okhttp3.internal.http1.Http1Codec
 * JD-Core Version:    0.6.0
 */
package okhttp3.internal.http2;

import java.io.IOException;
import java.net.ProtocolException;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.concurrent.TimeUnit;
import okhttp3.Headers;
import okhttp3.Headers.Builder;
import okhttp3.HttpUrl;
import okhttp3.OkHttpClient;
import okhttp3.Protocol;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.Response.Builder;
import okhttp3.ResponseBody;
import okhttp3.internal.Internal;
import okhttp3.internal.Util;
import okhttp3.internal.connection.StreamAllocation;
import okhttp3.internal.http.HttpCodec;
import okhttp3.internal.http.RealResponseBody;
import okhttp3.internal.http.RequestLine;
import okhttp3.internal.http.StatusLine;
import okio.ByteString;
import okio.ForwardingSource;
import okio.Okio;
import okio.Sink;
import okio.Source;
import okio.Timeout;

public final class Http2Codec
  implements HttpCodec
{
  private static final ByteString CONNECTION = ByteString.encodeUtf8("connection");
  private static final ByteString ENCODING;
  private static final ByteString HOST = ByteString.encodeUtf8("host");
  private static final List<ByteString> HTTP_2_SKIPPED_REQUEST_HEADERS;
  private static final List<ByteString> HTTP_2_SKIPPED_RESPONSE_HEADERS;
  private static final ByteString KEEP_ALIVE = ByteString.encodeUtf8("keep-alive");
  private static final ByteString PROXY_CONNECTION = ByteString.encodeUtf8("proxy-connection");
  private static final ByteString TE;
  private static final ByteString TRANSFER_ENCODING = ByteString.encodeUtf8("transfer-encoding");
  private static final ByteString UPGRADE;
  private final OkHttpClient client;
  private final Http2Connection connection;
  private Http2Stream stream;
  final StreamAllocation streamAllocation;

  static
  {
    TE = ByteString.encodeUtf8("te");
    ENCODING = ByteString.encodeUtf8("encoding");
    UPGRADE = ByteString.encodeUtf8("upgrade");
    HTTP_2_SKIPPED_REQUEST_HEADERS = Util.immutableList(new ByteString[] { CONNECTION, HOST, KEEP_ALIVE, PROXY_CONNECTION, TE, TRANSFER_ENCODING, ENCODING, UPGRADE, Header.TARGET_METHOD, Header.TARGET_PATH, Header.TARGET_SCHEME, Header.TARGET_AUTHORITY });
    HTTP_2_SKIPPED_RESPONSE_HEADERS = Util.immutableList(new ByteString[] { CONNECTION, HOST, KEEP_ALIVE, PROXY_CONNECTION, TE, TRANSFER_ENCODING, ENCODING, UPGRADE });
  }

  public Http2Codec(OkHttpClient paramOkHttpClient, StreamAllocation paramStreamAllocation, Http2Connection paramHttp2Connection)
  {
    this.client = paramOkHttpClient;
    this.streamAllocation = paramStreamAllocation;
    this.connection = paramHttp2Connection;
  }

  public static List<Header> http2HeadersList(Request paramRequest)
  {
    Headers localHeaders = paramRequest.headers();
    ArrayList localArrayList = new ArrayList(localHeaders.size() + 4);
    localArrayList.add(new Header(Header.TARGET_METHOD, paramRequest.method()));
    localArrayList.add(new Header(Header.TARGET_PATH, RequestLine.requestPath(paramRequest.url())));
    String str = paramRequest.header("Host");
    if (str != null)
      localArrayList.add(new Header(Header.TARGET_AUTHORITY, str));
    localArrayList.add(new Header(Header.TARGET_SCHEME, paramRequest.url().scheme()));
    int i = 0;
    int j = localHeaders.size();
    while (i < j)
    {
      paramRequest = ByteString.encodeUtf8(localHeaders.name(i).toLowerCase(Locale.US));
      if (!HTTP_2_SKIPPED_REQUEST_HEADERS.contains(paramRequest))
        localArrayList.add(new Header(paramRequest, localHeaders.value(i)));
      i += 1;
    }
    return localArrayList;
  }

  public static Response.Builder readHttp2HeadersList(List<Header> paramList)
    throws IOException
  {
    Object localObject3 = null;
    Object localObject2 = new Headers.Builder();
    int i = 0;
    int j = paramList.size();
    if (i < j)
    {
      Object localObject1 = (Header)paramList.get(i);
      Object localObject4;
      if (localObject1 == null)
      {
        localObject4 = localObject2;
        localObject1 = localObject3;
        if (localObject3 != null)
        {
          localObject4 = localObject2;
          localObject1 = localObject3;
          if (localObject3.code == 100)
          {
            localObject1 = null;
            localObject4 = new Headers.Builder();
          }
        }
      }
      while (true)
      {
        i += 1;
        localObject2 = localObject4;
        localObject3 = localObject1;
        break;
        ByteString localByteString = ((Header)localObject1).name;
        String str = ((Header)localObject1).value.utf8();
        if (localByteString.equals(Header.RESPONSE_STATUS))
        {
          localObject1 = StatusLine.parse("HTTP/1.1 " + str);
          localObject4 = localObject2;
          continue;
        }
        localObject4 = localObject2;
        localObject1 = localObject3;
        if (HTTP_2_SKIPPED_RESPONSE_HEADERS.contains(localByteString))
          continue;
        Internal.instance.addLenient((Headers.Builder)localObject2, localByteString.utf8(), str);
        localObject4 = localObject2;
        localObject1 = localObject3;
      }
    }
    if (localObject3 == null)
      throw new ProtocolException("Expected ':status' header not present");
    return (Response.Builder)(Response.Builder)(Response.Builder)new Response.Builder().protocol(Protocol.HTTP_2).code(localObject3.code).message(localObject3.message).headers(((Headers.Builder)localObject2).build());
  }

  public void cancel()
  {
    if (this.stream != null)
      this.stream.closeLater(ErrorCode.CANCEL);
  }

  public Sink createRequestBody(Request paramRequest, long paramLong)
  {
    return this.stream.getSink();
  }

  public void finishRequest()
    throws IOException
  {
    this.stream.getSink().close();
  }

  public void flushRequest()
    throws IOException
  {
    this.connection.flush();
  }

  public ResponseBody openResponseBody(Response paramResponse)
    throws IOException
  {
    StreamFinishingSource localStreamFinishingSource = new StreamFinishingSource(this.stream.getSource());
    return new RealResponseBody(paramResponse.headers(), Okio.buffer(localStreamFinishingSource));
  }

  public Response.Builder readResponseHeaders(boolean paramBoolean)
    throws IOException
  {
    Response.Builder localBuilder2 = readHttp2HeadersList(this.stream.takeResponseHeaders());
    Response.Builder localBuilder1 = localBuilder2;
    if (paramBoolean)
    {
      localBuilder1 = localBuilder2;
      if (Internal.instance.code(localBuilder2) == 100)
        localBuilder1 = null;
    }
    return localBuilder1;
  }

  public void writeRequestHeaders(Request paramRequest)
    throws IOException
  {
    if (this.stream != null)
      return;
    if (paramRequest.body() != null);
    for (boolean bool = true; ; bool = false)
    {
      paramRequest = http2HeadersList(paramRequest);
      this.stream = this.connection.newStream(paramRequest, bool);
      this.stream.readTimeout().timeout(this.client.readTimeoutMillis(), TimeUnit.MILLISECONDS);
      this.stream.writeTimeout().timeout(this.client.writeTimeoutMillis(), TimeUnit.MILLISECONDS);
      return;
    }
  }

  class StreamFinishingSource extends ForwardingSource
  {
    public StreamFinishingSource(Source arg2)
    {
      super();
    }

    public void close()
      throws IOException
    {
      Http2Codec.this.streamAllocation.streamFinished(false, Http2Codec.this);
      super.close();
    }
  }
}

/* Location:           C:\Users\c_jealom1\Documents\Scripts\Android\Fathom_com.brynk.fathom\Fathom_com.brynk.fathom-dex2jar.jar
 * Qualified Name:     okhttp3.internal.http2.Http2Codec
 * JD-Core Version:    0.6.0
 */
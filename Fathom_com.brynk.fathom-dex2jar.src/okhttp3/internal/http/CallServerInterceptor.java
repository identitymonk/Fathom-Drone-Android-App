package okhttp3.internal.http;

import java.io.IOException;
import java.net.ProtocolException;
import okhttp3.Interceptor;
import okhttp3.Interceptor.Chain;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;
import okhttp3.Response.Builder;
import okhttp3.ResponseBody;
import okhttp3.internal.Util;
import okhttp3.internal.connection.RealConnection;
import okhttp3.internal.connection.StreamAllocation;
import okio.BufferedSink;
import okio.Okio;

public final class CallServerInterceptor
  implements Interceptor
{
  private final boolean forWebSocket;

  public CallServerInterceptor(boolean paramBoolean)
  {
    this.forWebSocket = paramBoolean;
  }

  public Response intercept(Interceptor.Chain paramChain)
    throws IOException
  {
    HttpCodec localHttpCodec = ((RealInterceptorChain)paramChain).httpStream();
    StreamAllocation localStreamAllocation = ((RealInterceptorChain)paramChain).streamAllocation();
    Request localRequest = paramChain.request();
    long l = System.currentTimeMillis();
    localHttpCodec.writeRequestHeaders(localRequest);
    Object localObject2 = null;
    Object localObject1 = null;
    paramChain = localObject2;
    if (HttpMethod.permitsRequestBody(localRequest.method()))
    {
      paramChain = localObject2;
      if (localRequest.body() != null)
      {
        if ("100-continue".equalsIgnoreCase(localRequest.header("Expect")))
        {
          localHttpCodec.flushRequest();
          localObject1 = localHttpCodec.readResponseHeaders(true);
        }
        paramChain = (Interceptor.Chain)localObject1;
        if (localObject1 == null)
        {
          paramChain = Okio.buffer(localHttpCodec.createRequestBody(localRequest, localRequest.body().contentLength()));
          localRequest.body().writeTo(paramChain);
          paramChain.close();
          paramChain = (Interceptor.Chain)localObject1;
        }
      }
    }
    localHttpCodec.finishRequest();
    localObject1 = paramChain;
    if (paramChain == null)
      localObject1 = localHttpCodec.readResponseHeaders(false);
    paramChain = ((Response.Builder)localObject1).request(localRequest).handshake(localStreamAllocation.connection().handshake()).sentRequestAtMillis(l).receivedResponseAtMillis(System.currentTimeMillis()).build();
    int i = paramChain.code();
    if ((this.forWebSocket) && (i == 101));
    for (paramChain = paramChain.newBuilder().body(Util.EMPTY_RESPONSE).build(); ; paramChain = paramChain.newBuilder().body(localHttpCodec.openResponseBody(paramChain)).build())
    {
      if (("close".equalsIgnoreCase(paramChain.request().header("Connection"))) || ("close".equalsIgnoreCase(paramChain.header("Connection"))))
        localStreamAllocation.noNewStreams();
      if (((i != 204) && (i != 205)) || (paramChain.body().contentLength() <= 0L))
        break;
      throw new ProtocolException("HTTP " + i + " had non-zero Content-Length: " + paramChain.body().contentLength());
    }
    return (Response)paramChain;
  }
}

/* Location:           C:\Users\c_jealom1\Documents\Scripts\Android\Fathom_com.brynk.fathom\Fathom_com.brynk.fathom-dex2jar.jar
 * Qualified Name:     okhttp3.internal.http.CallServerInterceptor
 * JD-Core Version:    0.6.0
 */
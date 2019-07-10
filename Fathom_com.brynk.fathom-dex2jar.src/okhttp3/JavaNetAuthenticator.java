package okhttp3;

import java.io.IOException;
import java.net.Authenticator.RequestorType;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.PasswordAuthentication;
import java.net.Proxy;
import java.net.Proxy.Type;
import java.util.List;

public final class JavaNetAuthenticator
  implements Authenticator
{
  private InetAddress getConnectToInetAddress(Proxy paramProxy, HttpUrl paramHttpUrl)
    throws IOException
  {
    if ((paramProxy != null) && (paramProxy.type() != Proxy.Type.DIRECT))
      return ((InetSocketAddress)paramProxy.address()).getAddress();
    return InetAddress.getByName(paramHttpUrl.host());
  }

  public Request authenticate(Route paramRoute, Response paramResponse)
    throws IOException
  {
    List localList = paramResponse.challenges();
    Object localObject = paramResponse.request();
    HttpUrl localHttpUrl = ((Request)localObject).url();
    int i;
    if (paramResponse.code() == 407)
      i = 1;
    while (true)
    {
      paramResponse = paramRoute.proxy();
      int j = 0;
      int k = localList.size();
      while (true)
      {
        if (j >= k)
          break label248;
        paramRoute = (Challenge)localList.get(j);
        if (!"Basic".equalsIgnoreCase(paramRoute.scheme()))
        {
          j += 1;
          continue;
          i = 0;
          break;
        }
      }
      if (i != 0)
      {
        InetSocketAddress localInetSocketAddress = (InetSocketAddress)paramResponse.address();
        paramRoute = java.net.Authenticator.requestPasswordAuthentication(localInetSocketAddress.getHostName(), getConnectToInetAddress(paramResponse, localHttpUrl), localInetSocketAddress.getPort(), localHttpUrl.scheme(), paramRoute.realm(), paramRoute.scheme(), localHttpUrl.url(), Authenticator.RequestorType.PROXY);
        label149: if (paramRoute == null)
          break label240;
        paramResponse = Credentials.basic(paramRoute.getUserName(), new String(paramRoute.getPassword()));
        localObject = ((Request)localObject).newBuilder();
        if (i == 0)
          break label242;
      }
      label240: label242: for (paramRoute = "Proxy-Authorization"; ; paramRoute = "Authorization")
      {
        return ((Request.Builder)localObject).header(paramRoute, paramResponse).build();
        paramRoute = java.net.Authenticator.requestPasswordAuthentication(localHttpUrl.host(), getConnectToInetAddress(paramResponse, localHttpUrl), localHttpUrl.port(), localHttpUrl.scheme(), paramRoute.realm(), paramRoute.scheme(), localHttpUrl.url(), Authenticator.RequestorType.SERVER);
        break label149;
        break;
      }
    }
    label248: return (Request)null;
  }
}

/* Location:           C:\Users\c_jealom1\Documents\Scripts\Android\Fathom_com.brynk.fathom\Fathom_com.brynk.fathom-dex2jar.jar
 * Qualified Name:     okhttp3.JavaNetAuthenticator
 * JD-Core Version:    0.6.0
 */
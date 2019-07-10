package okhttp3;

import java.net.InetSocketAddress;
import java.net.Proxy;
import java.net.Proxy.Type;

public final class Route
{
  final Address address;
  final InetSocketAddress inetSocketAddress;
  final Proxy proxy;

  public Route(Address paramAddress, Proxy paramProxy, InetSocketAddress paramInetSocketAddress)
  {
    if (paramAddress == null)
      throw new NullPointerException("address == null");
    if (paramProxy == null)
      throw new NullPointerException("proxy == null");
    if (paramInetSocketAddress == null)
      throw new NullPointerException("inetSocketAddress == null");
    this.address = paramAddress;
    this.proxy = paramProxy;
    this.inetSocketAddress = paramInetSocketAddress;
  }

  public Address address()
  {
    return this.address;
  }

  public boolean equals(Object paramObject)
  {
    int j = 0;
    int i = j;
    if ((paramObject instanceof Route))
    {
      paramObject = (Route)paramObject;
      i = j;
      if (this.address.equals(paramObject.address))
      {
        i = j;
        if (this.proxy.equals(paramObject.proxy))
        {
          i = j;
          if (this.inetSocketAddress.equals(paramObject.inetSocketAddress))
            i = 1;
        }
      }
    }
    return i;
  }

  public int hashCode()
  {
    return ((this.address.hashCode() + 527) * 31 + this.proxy.hashCode()) * 31 + this.inetSocketAddress.hashCode();
  }

  public Proxy proxy()
  {
    return this.proxy;
  }

  public boolean requiresTunnel()
  {
    return (this.address.sslSocketFactory != null) && (this.proxy.type() == Proxy.Type.HTTP);
  }

  public InetSocketAddress socketAddress()
  {
    return this.inetSocketAddress;
  }

  public String toString()
  {
    return "Route{" + this.inetSocketAddress + "}";
  }
}

/* Location:           C:\Users\c_jealom1\Documents\Scripts\Android\Fathom_com.brynk.fathom\Fathom_com.brynk.fathom-dex2jar.jar
 * Qualified Name:     okhttp3.Route
 * JD-Core Version:    0.6.0
 */
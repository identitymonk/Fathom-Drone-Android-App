package okhttp3.internal.platform;

import java.lang.reflect.Method;
import java.util.List;
import javax.net.ssl.SSLParameters;
import javax.net.ssl.SSLSocket;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.X509TrustManager;
import okhttp3.Protocol;

final class Jdk9Platform extends Platform
{
  final Method getProtocolMethod;
  final Method setProtocolMethod;

  public Jdk9Platform(Method paramMethod1, Method paramMethod2)
  {
    this.setProtocolMethod = paramMethod1;
    this.getProtocolMethod = paramMethod2;
  }

  public static Jdk9Platform buildIfSupported()
  {
    try
    {
      Jdk9Platform localJdk9Platform = new Jdk9Platform(SSLParameters.class.getMethod("setApplicationProtocols", new Class[] { [Ljava.lang.String.class }), SSLSocket.class.getMethod("getApplicationProtocol", new Class[0]));
      return localJdk9Platform;
    }
    catch (NoSuchMethodException localNoSuchMethodException)
    {
    }
    return null;
  }

  public void configureTlsExtensions(SSLSocket paramSSLSocket, String paramString, List<Protocol> paramList)
  {
    try
    {
      paramString = paramSSLSocket.getSSLParameters();
      paramList = alpnProtocolNames(paramList);
      this.setProtocolMethod.invoke(paramString, new Object[] { paramList.toArray(new String[paramList.size()]) });
      paramSSLSocket.setSSLParameters(paramString);
      return;
    }
    catch (java.lang.IllegalAccessException paramSSLSocket)
    {
      throw new AssertionError();
    }
    catch (java.lang.reflect.InvocationTargetException paramSSLSocket)
    {
      label48: break label48;
    }
  }

  public String getSelectedProtocol(SSLSocket paramSSLSocket)
  {
    try
    {
      paramSSLSocket = (String)this.getProtocolMethod.invoke(paramSSLSocket, new Object[0]);
      if (paramSSLSocket != null)
      {
        boolean bool = paramSSLSocket.equals("");
        if (!bool);
      }
      else
      {
        paramSSLSocket = null;
      }
      return paramSSLSocket;
    }
    catch (java.lang.IllegalAccessException paramSSLSocket)
    {
      throw new AssertionError();
    }
    catch (java.lang.reflect.InvocationTargetException paramSSLSocket)
    {
      label36: break label36;
    }
  }

  public X509TrustManager trustManager(SSLSocketFactory paramSSLSocketFactory)
  {
    throw new UnsupportedOperationException("clientBuilder.sslSocketFactory(SSLSocketFactory) not supported on JDK 9+");
  }
}

/* Location:           C:\Users\c_jealom1\Documents\Scripts\Android\Fathom_com.brynk.fathom\Fathom_com.brynk.fathom-dex2jar.jar
 * Qualified Name:     okhttp3.internal.platform.Jdk9Platform
 * JD-Core Version:    0.6.0
 */
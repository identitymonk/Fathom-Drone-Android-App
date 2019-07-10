package com.facebook.react.modules.network;

import java.io.IOException;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;
import java.security.KeyManagementException;
import java.security.NoSuchAlgorithmException;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSocket;
import javax.net.ssl.SSLSocketFactory;

public class TLSSocketFactory extends SSLSocketFactory
{
  private SSLSocketFactory delegate;

  public TLSSocketFactory()
    throws KeyManagementException, NoSuchAlgorithmException
  {
    SSLContext localSSLContext = SSLContext.getInstance("TLS");
    localSSLContext.init(null, null, null);
    this.delegate = localSSLContext.getSocketFactory();
  }

  private Socket enableTLSOnSocket(Socket paramSocket)
  {
    if ((paramSocket != null) && ((paramSocket instanceof SSLSocket)))
      ((SSLSocket)paramSocket).setEnabledProtocols(new String[] { "TLSv1", "TLSv1.1", "TLSv1.2" });
    return paramSocket;
  }

  public Socket createSocket(String paramString, int paramInt)
    throws IOException, UnknownHostException
  {
    return enableTLSOnSocket(this.delegate.createSocket(paramString, paramInt));
  }

  public Socket createSocket(String paramString, int paramInt1, InetAddress paramInetAddress, int paramInt2)
    throws IOException, UnknownHostException
  {
    return enableTLSOnSocket(this.delegate.createSocket(paramString, paramInt1, paramInetAddress, paramInt2));
  }

  public Socket createSocket(InetAddress paramInetAddress, int paramInt)
    throws IOException
  {
    return enableTLSOnSocket(this.delegate.createSocket(paramInetAddress, paramInt));
  }

  public Socket createSocket(InetAddress paramInetAddress1, int paramInt1, InetAddress paramInetAddress2, int paramInt2)
    throws IOException
  {
    return enableTLSOnSocket(this.delegate.createSocket(paramInetAddress1, paramInt1, paramInetAddress2, paramInt2));
  }

  public Socket createSocket(Socket paramSocket, String paramString, int paramInt, boolean paramBoolean)
    throws IOException
  {
    return enableTLSOnSocket(this.delegate.createSocket(paramSocket, paramString, paramInt, paramBoolean));
  }

  public String[] getDefaultCipherSuites()
  {
    return this.delegate.getDefaultCipherSuites();
  }

  public String[] getSupportedCipherSuites()
  {
    return this.delegate.getSupportedCipherSuites();
  }
}

/* Location:           C:\Users\c_jealom1\Documents\Scripts\Android\Fathom_com.brynk.fathom\Fathom_com.brynk.fathom-dex2jar.jar
 * Qualified Name:     com.facebook.react.modules.network.TLSSocketFactory
 * JD-Core Version:    0.6.0
 */
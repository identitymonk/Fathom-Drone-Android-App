package okhttp3.internal.platform;

import android.util.Log;
import java.io.IOException;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.security.cert.Certificate;
import java.security.cert.X509Certificate;
import java.util.List;
import javax.net.ssl.SSLPeerUnverifiedException;
import javax.net.ssl.SSLSocket;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.X509TrustManager;
import okhttp3.Protocol;
import okhttp3.internal.Util;
import okhttp3.internal.tls.CertificateChainCleaner;

class AndroidPlatform extends Platform
{
  private static final int MAX_LOG_LENGTH = 4000;
  private final CloseGuard closeGuard = CloseGuard.get();
  private final OptionalMethod<Socket> getAlpnSelectedProtocol;
  private final OptionalMethod<Socket> setAlpnProtocols;
  private final OptionalMethod<Socket> setHostname;
  private final OptionalMethod<Socket> setUseSessionTickets;
  private final Class<?> sslParametersClass;

  public AndroidPlatform(Class<?> paramClass, OptionalMethod<Socket> paramOptionalMethod1, OptionalMethod<Socket> paramOptionalMethod2, OptionalMethod<Socket> paramOptionalMethod3, OptionalMethod<Socket> paramOptionalMethod4)
  {
    this.sslParametersClass = paramClass;
    this.setUseSessionTickets = paramOptionalMethod1;
    this.setHostname = paramOptionalMethod2;
    this.getAlpnSelectedProtocol = paramOptionalMethod3;
    this.setAlpnProtocols = paramOptionalMethod4;
  }

  // ERROR //
  public static Platform buildIfSupported()
  {
    // Byte code:
    //   0: ldc 54
    //   2: invokestatic 60	java/lang/Class:forName	(Ljava/lang/String;)Ljava/lang/Class;
    //   5: astore_1
    //   6: new 62	okhttp3/internal/platform/OptionalMethod
    //   9: dup
    //   10: aconst_null
    //   11: ldc 63
    //   13: iconst_1
    //   14: anewarray 56	java/lang/Class
    //   17: dup
    //   18: iconst_0
    //   19: getstatic 68	java/lang/Boolean:TYPE	Ljava/lang/Class;
    //   22: aastore
    //   23: invokespecial 71	okhttp3/internal/platform/OptionalMethod:<init>	(Ljava/lang/Class;Ljava/lang/String;[Ljava/lang/Class;)V
    //   26: astore 4
    //   28: new 62	okhttp3/internal/platform/OptionalMethod
    //   31: dup
    //   32: aconst_null
    //   33: ldc 72
    //   35: iconst_1
    //   36: anewarray 56	java/lang/Class
    //   39: dup
    //   40: iconst_0
    //   41: ldc 74
    //   43: aastore
    //   44: invokespecial 71	okhttp3/internal/platform/OptionalMethod:<init>	(Ljava/lang/Class;Ljava/lang/String;[Ljava/lang/Class;)V
    //   47: astore 5
    //   49: aconst_null
    //   50: astore_3
    //   51: aconst_null
    //   52: astore_2
    //   53: ldc 76
    //   55: invokestatic 60	java/lang/Class:forName	(Ljava/lang/String;)Ljava/lang/Class;
    //   58: pop
    //   59: new 62	okhttp3/internal/platform/OptionalMethod
    //   62: dup
    //   63: ldc 78
    //   65: ldc 79
    //   67: iconst_0
    //   68: anewarray 56	java/lang/Class
    //   71: invokespecial 71	okhttp3/internal/platform/OptionalMethod:<init>	(Ljava/lang/Class;Ljava/lang/String;[Ljava/lang/Class;)V
    //   74: astore_0
    //   75: new 62	okhttp3/internal/platform/OptionalMethod
    //   78: dup
    //   79: aconst_null
    //   80: ldc 80
    //   82: iconst_1
    //   83: anewarray 56	java/lang/Class
    //   86: dup
    //   87: iconst_0
    //   88: ldc 78
    //   90: aastore
    //   91: invokespecial 71	okhttp3/internal/platform/OptionalMethod:<init>	(Ljava/lang/Class;Ljava/lang/String;[Ljava/lang/Class;)V
    //   94: astore_3
    //   95: aload_3
    //   96: astore_2
    //   97: new 2	okhttp3/internal/platform/AndroidPlatform
    //   100: dup
    //   101: aload_1
    //   102: aload 4
    //   104: aload 5
    //   106: aload_0
    //   107: aload_2
    //   108: invokespecial 82	okhttp3/internal/platform/AndroidPlatform:<init>	(Ljava/lang/Class;Lokhttp3/internal/platform/OptionalMethod;Lokhttp3/internal/platform/OptionalMethod;Lokhttp3/internal/platform/OptionalMethod;Lokhttp3/internal/platform/OptionalMethod;)V
    //   111: areturn
    //   112: astore_0
    //   113: ldc 84
    //   115: invokestatic 60	java/lang/Class:forName	(Ljava/lang/String;)Ljava/lang/Class;
    //   118: astore_1
    //   119: goto -113 -> 6
    //   122: astore_0
    //   123: aconst_null
    //   124: areturn
    //   125: astore_0
    //   126: aload_3
    //   127: astore_0
    //   128: goto -31 -> 97
    //   131: astore_3
    //   132: goto -35 -> 97
    //
    // Exception table:
    //   from	to	target	type
    //   0	6	112	java/lang/ClassNotFoundException
    //   6	49	122	java/lang/ClassNotFoundException
    //   97	112	122	java/lang/ClassNotFoundException
    //   113	119	122	java/lang/ClassNotFoundException
    //   53	75	125	java/lang/ClassNotFoundException
    //   75	95	131	java/lang/ClassNotFoundException
  }

  public CertificateChainCleaner buildCertificateChainCleaner(X509TrustManager paramX509TrustManager)
  {
    try
    {
      Object localObject = Class.forName("android.net.http.X509TrustManagerExtensions");
      localObject = new AndroidCertificateChainCleaner(((Class)localObject).getConstructor(new Class[] { X509TrustManager.class }).newInstance(new Object[] { paramX509TrustManager }), ((Class)localObject).getMethod("checkServerTrusted", new Class[] { [Ljava.security.cert.X509Certificate.class, String.class, String.class }));
      return localObject;
    }
    catch (Exception localException)
    {
    }
    return (CertificateChainCleaner)super.buildCertificateChainCleaner(paramX509TrustManager);
  }

  public void configureTlsExtensions(SSLSocket paramSSLSocket, String paramString, List<Protocol> paramList)
  {
    if (paramString != null)
    {
      this.setUseSessionTickets.invokeOptionalWithoutCheckedException(paramSSLSocket, new Object[] { Boolean.valueOf(true) });
      this.setHostname.invokeOptionalWithoutCheckedException(paramSSLSocket, new Object[] { paramString });
    }
    if ((this.setAlpnProtocols != null) && (this.setAlpnProtocols.isSupported(paramSSLSocket)))
    {
      paramString = concatLengthPrefixed(paramList);
      this.setAlpnProtocols.invokeWithoutCheckedException(paramSSLSocket, new Object[] { paramString });
    }
  }

  public void connectSocket(Socket paramSocket, InetSocketAddress paramInetSocketAddress, int paramInt)
    throws IOException
  {
    try
    {
      paramSocket.connect(paramInetSocketAddress, paramInt);
      return;
    }
    catch (AssertionError paramSocket)
    {
      if (Util.isAndroidGetsocknameError(paramSocket))
        throw new IOException(paramSocket);
      throw paramSocket;
    }
    catch (java.lang.SecurityException paramSocket)
    {
      paramInetSocketAddress = new IOException("Exception in connect");
      paramInetSocketAddress.initCause(paramSocket);
    }
    throw paramInetSocketAddress;
  }

  public String getSelectedProtocol(SSLSocket paramSSLSocket)
  {
    if (this.getAlpnSelectedProtocol == null);
    do
      return null;
    while (!this.getAlpnSelectedProtocol.isSupported(paramSSLSocket));
    paramSSLSocket = (byte[])(byte[])this.getAlpnSelectedProtocol.invokeWithoutCheckedException(paramSSLSocket, new Object[0]);
    if (paramSSLSocket != null);
    for (paramSSLSocket = new String(paramSSLSocket, Util.UTF_8); ; paramSSLSocket = null)
      return paramSSLSocket;
  }

  public Object getStackTraceForCloseable(String paramString)
  {
    return this.closeGuard.createAndOpen(paramString);
  }

  public boolean isCleartextTrafficPermitted(String paramString)
  {
    try
    {
      Class localClass = Class.forName("android.security.NetworkSecurityPolicy");
      Object localObject = localClass.getMethod("getInstance", new Class[0]).invoke(null, new Object[0]);
      boolean bool = ((Boolean)localClass.getMethod("isCleartextTrafficPermitted", new Class[] { String.class }).invoke(localObject, new Object[] { paramString })).booleanValue();
      return bool;
    }
    catch (ClassNotFoundException localClassNotFoundException)
    {
      return super.isCleartextTrafficPermitted(paramString);
    }
    catch (java.lang.IllegalAccessException paramString)
    {
      throw new AssertionError();
    }
    catch (java.lang.IllegalArgumentException paramString)
    {
      break label71;
    }
    catch (InvocationTargetException paramString)
    {
      break label71;
    }
    catch (NoSuchMethodException localNoSuchMethodException)
    {
      label64: label71: break label64;
    }
  }

  public void log(int paramInt, String paramString, Throwable paramThrowable)
  {
    int i = 5;
    String str;
    int m;
    label52: int j;
    if (paramInt == 5)
    {
      str = paramString;
      if (paramThrowable != null)
        str = paramString + '\n' + Log.getStackTraceString(paramThrowable);
      paramInt = 0;
      m = str.length();
      if (paramInt >= m)
        return;
      j = str.indexOf('\n', paramInt);
      if (j == -1)
        break label126;
    }
    while (true)
    {
      int k = Math.min(j, paramInt + 4000);
      Log.println(i, "OkHttp", str.substring(paramInt, k));
      paramInt = k;
      if (k < j)
        continue;
      paramInt = k + 1;
      break label52;
      i = 3;
      break;
      label126: j = m;
    }
  }

  public void logCloseableLeak(String paramString, Object paramObject)
  {
    if (!this.closeGuard.warnIfOpen(paramObject))
      log(5, paramString, null);
  }

  public X509TrustManager trustManager(SSLSocketFactory paramSSLSocketFactory)
  {
    Object localObject2 = readFieldOrNull(paramSSLSocketFactory, this.sslParametersClass, "sslParameters");
    Object localObject1 = localObject2;
    if (localObject2 == null);
    try
    {
      localObject1 = readFieldOrNull(paramSSLSocketFactory, Class.forName("com.google.android.gms.org.conscrypt.SSLParametersImpl", false, paramSSLSocketFactory.getClass().getClassLoader()), "sslParameters");
      paramSSLSocketFactory = (X509TrustManager)readFieldOrNull(localObject1, X509TrustManager.class, "x509TrustManager");
      if (paramSSLSocketFactory != null)
        return paramSSLSocketFactory;
    }
    catch (ClassNotFoundException localClassNotFoundException)
    {
      return super.trustManager(paramSSLSocketFactory);
    }
    return (X509TrustManager)readFieldOrNull(localClassNotFoundException, X509TrustManager.class, "trustManager");
  }

  static final class AndroidCertificateChainCleaner extends CertificateChainCleaner
  {
    private final Method checkServerTrusted;
    private final Object x509TrustManagerExtensions;

    AndroidCertificateChainCleaner(Object paramObject, Method paramMethod)
    {
      this.x509TrustManagerExtensions = paramObject;
      this.checkServerTrusted = paramMethod;
    }

    public List<Certificate> clean(List<Certificate> paramList, String paramString)
      throws SSLPeerUnverifiedException
    {
      try
      {
        paramList = (X509Certificate[])paramList.toArray(new X509Certificate[paramList.size()]);
        paramList = (List)this.checkServerTrusted.invoke(this.x509TrustManagerExtensions, new Object[] { paramList, "RSA", paramString });
        return paramList;
      }
      catch (InvocationTargetException paramList)
      {
        paramString = new SSLPeerUnverifiedException(paramList.getMessage());
        paramString.initCause(paramList);
        throw paramString;
      }
      catch (java.lang.IllegalAccessException paramList)
      {
      }
      throw new AssertionError(paramList);
    }

    public boolean equals(Object paramObject)
    {
      return paramObject instanceof AndroidCertificateChainCleaner;
    }

    public int hashCode()
    {
      return 0;
    }
  }

  static final class CloseGuard
  {
    private final Method getMethod;
    private final Method openMethod;
    private final Method warnIfOpenMethod;

    CloseGuard(Method paramMethod1, Method paramMethod2, Method paramMethod3)
    {
      this.getMethod = paramMethod1;
      this.openMethod = paramMethod2;
      this.warnIfOpenMethod = paramMethod3;
    }

    static CloseGuard get()
    {
      try
      {
        localObject2 = Class.forName("dalvik.system.CloseGuard");
        Method localMethod1 = ((Class)localObject2).getMethod("get", new Class[0]);
        localMethod2 = ((Class)localObject2).getMethod("open", new Class[] { String.class });
        localObject2 = ((Class)localObject2).getMethod("warnIfOpen", new Class[0]);
        return new CloseGuard(localMethod1, localMethod2, (Method)localObject2);
      }
      catch (Exception localObject1)
      {
        while (true)
        {
          Object localObject1 = null;
          Method localMethod2 = null;
          Object localObject2 = null;
        }
      }
    }

    Object createAndOpen(String paramString)
    {
      if (this.getMethod != null)
        try
        {
          Object localObject = this.getMethod.invoke(null, new Object[0]);
          this.openMethod.invoke(localObject, new Object[] { paramString });
          return localObject;
        }
        catch (Exception paramString)
        {
        }
      return null;
    }

    boolean warnIfOpen(Object paramObject)
    {
      int i = 0;
      if (paramObject != null);
      try
      {
        this.warnIfOpenMethod.invoke(paramObject, new Object[0]);
        i = 1;
        return i;
      }
      catch (Exception paramObject)
      {
      }
      return false;
    }
  }
}

/* Location:           C:\Users\c_jealom1\Documents\Scripts\Android\Fathom_com.brynk.fathom\Fathom_com.brynk.fathom-dex2jar.jar
 * Qualified Name:     okhttp3.internal.platform.AndroidPlatform
 * JD-Core Version:    0.6.0
 */
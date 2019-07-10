package okhttp3;

public enum TlsVersion
{
  final String javaName;

  static
  {
    TLS_1_2 = new TlsVersion("TLS_1_2", 1, "TLSv1.2");
    TLS_1_1 = new TlsVersion("TLS_1_1", 2, "TLSv1.1");
    TLS_1_0 = new TlsVersion("TLS_1_0", 3, "TLSv1");
    SSL_3_0 = new TlsVersion("SSL_3_0", 4, "SSLv3");
    $VALUES = new TlsVersion[] { TLS_1_3, TLS_1_2, TLS_1_1, TLS_1_0, SSL_3_0 };
  }

  private TlsVersion(String paramString)
  {
    this.javaName = paramString;
  }

  public static TlsVersion forJavaName(String paramString)
  {
    int i = -1;
    switch (paramString.hashCode())
    {
    default:
    case -503070501:
    case -503070502:
    case -503070503:
    case 79923350:
    case 79201641:
    }
    while (true)
      switch (i)
      {
      default:
        throw new IllegalArgumentException("Unexpected TLS version: " + paramString);
        if (!paramString.equals("TLSv1.3"))
          continue;
        i = 0;
        continue;
        if (!paramString.equals("TLSv1.2"))
          continue;
        i = 1;
        continue;
        if (!paramString.equals("TLSv1.1"))
          continue;
        i = 2;
        continue;
        if (!paramString.equals("TLSv1"))
          continue;
        i = 3;
        continue;
        if (!paramString.equals("SSLv3"))
          continue;
        i = 4;
      case 0:
      case 1:
      case 2:
      case 3:
      case 4:
      }
    return TLS_1_3;
    return TLS_1_2;
    return TLS_1_1;
    return TLS_1_0;
    return SSL_3_0;
  }

  public String javaName()
  {
    return this.javaName;
  }
}

/* Location:           C:\Users\c_jealom1\Documents\Scripts\Android\Fathom_com.brynk.fathom\Fathom_com.brynk.fathom-dex2jar.jar
 * Qualified Name:     okhttp3.TlsVersion
 * JD-Core Version:    0.6.0
 */
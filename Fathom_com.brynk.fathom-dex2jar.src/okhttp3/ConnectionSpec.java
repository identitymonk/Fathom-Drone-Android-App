package okhttp3;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import javax.net.ssl.SSLSocket;
import okhttp3.internal.Util;

public final class ConnectionSpec
{
  private static final CipherSuite[] APPROVED_CIPHER_SUITES = { CipherSuite.TLS_ECDHE_ECDSA_WITH_AES_128_GCM_SHA256, CipherSuite.TLS_ECDHE_RSA_WITH_AES_128_GCM_SHA256, CipherSuite.TLS_ECDHE_ECDSA_WITH_AES_256_GCM_SHA384, CipherSuite.TLS_ECDHE_RSA_WITH_AES_256_GCM_SHA384, CipherSuite.TLS_ECDHE_ECDSA_WITH_CHACHA20_POLY1305_SHA256, CipherSuite.TLS_ECDHE_RSA_WITH_CHACHA20_POLY1305_SHA256, CipherSuite.TLS_ECDHE_ECDSA_WITH_AES_128_CBC_SHA, CipherSuite.TLS_ECDHE_RSA_WITH_AES_128_CBC_SHA, CipherSuite.TLS_ECDHE_ECDSA_WITH_AES_256_CBC_SHA, CipherSuite.TLS_ECDHE_RSA_WITH_AES_256_CBC_SHA, CipherSuite.TLS_RSA_WITH_AES_128_GCM_SHA256, CipherSuite.TLS_RSA_WITH_AES_256_GCM_SHA384, CipherSuite.TLS_RSA_WITH_AES_128_CBC_SHA, CipherSuite.TLS_RSA_WITH_AES_256_CBC_SHA, CipherSuite.TLS_RSA_WITH_3DES_EDE_CBC_SHA };
  public static final ConnectionSpec CLEARTEXT;
  public static final ConnectionSpec COMPATIBLE_TLS;
  public static final ConnectionSpec MODERN_TLS = new Builder(true).cipherSuites(APPROVED_CIPHER_SUITES).tlsVersions(new TlsVersion[] { TlsVersion.TLS_1_3, TlsVersion.TLS_1_2, TlsVersion.TLS_1_1, TlsVersion.TLS_1_0 }).supportsTlsExtensions(true).build();
  final String[] cipherSuites;
  final boolean supportsTlsExtensions;
  final boolean tls;
  final String[] tlsVersions;

  static
  {
    COMPATIBLE_TLS = new Builder(MODERN_TLS).tlsVersions(new TlsVersion[] { TlsVersion.TLS_1_0 }).supportsTlsExtensions(true).build();
    CLEARTEXT = new Builder(false).build();
  }

  ConnectionSpec(Builder paramBuilder)
  {
    this.tls = paramBuilder.tls;
    this.cipherSuites = paramBuilder.cipherSuites;
    this.tlsVersions = paramBuilder.tlsVersions;
    this.supportsTlsExtensions = paramBuilder.supportsTlsExtensions;
  }

  private static boolean nonEmptyIntersection(String[] paramArrayOfString1, String[] paramArrayOfString2)
  {
    if ((paramArrayOfString1 == null) || (paramArrayOfString2 == null) || (paramArrayOfString1.length == 0) || (paramArrayOfString2.length == 0));
    while (true)
    {
      return false;
      int j = paramArrayOfString1.length;
      int i = 0;
      while (i < j)
      {
        if (Util.indexOf(paramArrayOfString2, paramArrayOfString1[i]) != -1)
          return true;
        i += 1;
      }
    }
  }

  private ConnectionSpec supportedSpec(SSLSocket paramSSLSocket, boolean paramBoolean)
  {
    String[] arrayOfString1;
    if (this.cipherSuites != null)
    {
      arrayOfString1 = (String[])Util.intersect(String.class, this.cipherSuites, paramSSLSocket.getEnabledCipherSuites());
      if (this.tlsVersions == null)
        break label110;
    }
    label110: for (String[] arrayOfString2 = (String[])Util.intersect(String.class, this.tlsVersions, paramSSLSocket.getEnabledProtocols()); ; arrayOfString2 = paramSSLSocket.getEnabledProtocols())
    {
      String[] arrayOfString3 = arrayOfString1;
      if (paramBoolean)
      {
        arrayOfString3 = arrayOfString1;
        if (Util.indexOf(paramSSLSocket.getSupportedCipherSuites(), "TLS_FALLBACK_SCSV") != -1)
          arrayOfString3 = Util.concat(arrayOfString1, "TLS_FALLBACK_SCSV");
      }
      return new Builder(this).cipherSuites(arrayOfString3).tlsVersions(arrayOfString2).build();
      arrayOfString1 = paramSSLSocket.getEnabledCipherSuites();
      break;
    }
  }

  void apply(SSLSocket paramSSLSocket, boolean paramBoolean)
  {
    ConnectionSpec localConnectionSpec = supportedSpec(paramSSLSocket, paramBoolean);
    if (localConnectionSpec.tlsVersions != null)
      paramSSLSocket.setEnabledProtocols(localConnectionSpec.tlsVersions);
    if (localConnectionSpec.cipherSuites != null)
      paramSSLSocket.setEnabledCipherSuites(localConnectionSpec.cipherSuites);
  }

  public List<CipherSuite> cipherSuites()
  {
    if (this.cipherSuites == null)
      return null;
    ArrayList localArrayList = new ArrayList(this.cipherSuites.length);
    String[] arrayOfString = this.cipherSuites;
    int j = arrayOfString.length;
    int i = 0;
    while (i < j)
    {
      localArrayList.add(CipherSuite.forJavaName(arrayOfString[i]));
      i += 1;
    }
    return Collections.unmodifiableList(localArrayList);
  }

  public boolean equals(Object paramObject)
  {
    if (!(paramObject instanceof ConnectionSpec));
    do
    {
      return false;
      if (paramObject == this)
        return true;
      paramObject = (ConnectionSpec)paramObject;
    }
    while ((this.tls != paramObject.tls) || ((this.tls) && ((!Arrays.equals(this.cipherSuites, paramObject.cipherSuites)) || (!Arrays.equals(this.tlsVersions, paramObject.tlsVersions)) || (this.supportsTlsExtensions != paramObject.supportsTlsExtensions))));
    return true;
  }

  public int hashCode()
  {
    int i = 17;
    int j;
    int k;
    if (this.tls)
    {
      j = Arrays.hashCode(this.cipherSuites);
      k = Arrays.hashCode(this.tlsVersions);
      if (!this.supportsTlsExtensions)
        break label53;
    }
    label53: for (i = 0; ; i = 1)
    {
      i = ((j + 527) * 31 + k) * 31 + i;
      return i;
    }
  }

  public boolean isCompatible(SSLSocket paramSSLSocket)
  {
    if (!this.tls);
    do
      return false;
    while (((this.tlsVersions != null) && (!nonEmptyIntersection(this.tlsVersions, paramSSLSocket.getEnabledProtocols()))) || ((this.cipherSuites != null) && (!nonEmptyIntersection(this.cipherSuites, paramSSLSocket.getEnabledCipherSuites()))));
    return true;
  }

  public boolean isTls()
  {
    return this.tls;
  }

  public boolean supportsTlsExtensions()
  {
    return this.supportsTlsExtensions;
  }

  public List<TlsVersion> tlsVersions()
  {
    if (this.tlsVersions == null)
      return null;
    ArrayList localArrayList = new ArrayList(this.tlsVersions.length);
    String[] arrayOfString = this.tlsVersions;
    int j = arrayOfString.length;
    int i = 0;
    while (i < j)
    {
      localArrayList.add(TlsVersion.forJavaName(arrayOfString[i]));
      i += 1;
    }
    return Collections.unmodifiableList(localArrayList);
  }

  public String toString()
  {
    if (!this.tls)
      return "ConnectionSpec()";
    String str1;
    if (this.cipherSuites != null)
    {
      str1 = cipherSuites().toString();
      if (this.tlsVersions == null)
        break label92;
    }
    label92: for (String str2 = tlsVersions().toString(); ; str2 = "[all enabled]")
    {
      return "ConnectionSpec(cipherSuites=" + str1 + ", tlsVersions=" + str2 + ", supportsTlsExtensions=" + this.supportsTlsExtensions + ")";
      str1 = "[all enabled]";
      break;
    }
  }

  public static final class Builder
  {
    String[] cipherSuites;
    boolean supportsTlsExtensions;
    boolean tls;
    String[] tlsVersions;

    public Builder(ConnectionSpec paramConnectionSpec)
    {
      this.tls = paramConnectionSpec.tls;
      this.cipherSuites = paramConnectionSpec.cipherSuites;
      this.tlsVersions = paramConnectionSpec.tlsVersions;
      this.supportsTlsExtensions = paramConnectionSpec.supportsTlsExtensions;
    }

    Builder(boolean paramBoolean)
    {
      this.tls = paramBoolean;
    }

    public Builder allEnabledCipherSuites()
    {
      if (!this.tls)
        throw new IllegalStateException("no cipher suites for cleartext connections");
      this.cipherSuites = null;
      return this;
    }

    public Builder allEnabledTlsVersions()
    {
      if (!this.tls)
        throw new IllegalStateException("no TLS versions for cleartext connections");
      this.tlsVersions = null;
      return this;
    }

    public ConnectionSpec build()
    {
      return new ConnectionSpec(this);
    }

    public Builder cipherSuites(String[] paramArrayOfString)
    {
      if (!this.tls)
        throw new IllegalStateException("no cipher suites for cleartext connections");
      if (paramArrayOfString.length == 0)
        throw new IllegalArgumentException("At least one cipher suite is required");
      this.cipherSuites = ((String[])paramArrayOfString.clone());
      return this;
    }

    public Builder cipherSuites(CipherSuite[] paramArrayOfCipherSuite)
    {
      if (!this.tls)
        throw new IllegalStateException("no cipher suites for cleartext connections");
      String[] arrayOfString = new String[paramArrayOfCipherSuite.length];
      int i = 0;
      while (i < paramArrayOfCipherSuite.length)
      {
        arrayOfString[i] = paramArrayOfCipherSuite[i].javaName;
        i += 1;
      }
      return cipherSuites(arrayOfString);
    }

    public Builder supportsTlsExtensions(boolean paramBoolean)
    {
      if (!this.tls)
        throw new IllegalStateException("no TLS extensions for cleartext connections");
      this.supportsTlsExtensions = paramBoolean;
      return this;
    }

    public Builder tlsVersions(String[] paramArrayOfString)
    {
      if (!this.tls)
        throw new IllegalStateException("no TLS versions for cleartext connections");
      if (paramArrayOfString.length == 0)
        throw new IllegalArgumentException("At least one TLS version is required");
      this.tlsVersions = ((String[])paramArrayOfString.clone());
      return this;
    }

    public Builder tlsVersions(TlsVersion[] paramArrayOfTlsVersion)
    {
      if (!this.tls)
        throw new IllegalStateException("no TLS versions for cleartext connections");
      String[] arrayOfString = new String[paramArrayOfTlsVersion.length];
      int i = 0;
      while (i < paramArrayOfTlsVersion.length)
      {
        arrayOfString[i] = paramArrayOfTlsVersion[i].javaName;
        i += 1;
      }
      return tlsVersions(arrayOfString);
    }
  }
}

/* Location:           C:\Users\c_jealom1\Documents\Scripts\Android\Fathom_com.brynk.fathom\Fathom_com.brynk.fathom-dex2jar.jar
 * Qualified Name:     okhttp3.ConnectionSpec
 * JD-Core Version:    0.6.0
 */
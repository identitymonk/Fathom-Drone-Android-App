package okhttp3.internal.tls;

import java.lang.reflect.Method;
import java.security.PublicKey;
import java.security.cert.TrustAnchor;
import java.security.cert.X509Certificate;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;
import javax.net.ssl.X509TrustManager;
import javax.security.auth.x500.X500Principal;

public abstract class TrustRootIndex
{
  public static TrustRootIndex get(X509TrustManager paramX509TrustManager)
  {
    try
    {
      Object localObject = paramX509TrustManager.getClass().getDeclaredMethod("findTrustAnchorByIssuerAndSignature", new Class[] { X509Certificate.class });
      ((Method)localObject).setAccessible(true);
      localObject = new AndroidTrustRootIndex(paramX509TrustManager, (Method)localObject);
      return localObject;
    }
    catch (NoSuchMethodException localNoSuchMethodException)
    {
    }
    return (TrustRootIndex)get(paramX509TrustManager.getAcceptedIssuers());
  }

  public static TrustRootIndex get(X509Certificate[] paramArrayOfX509Certificate)
  {
    return new BasicTrustRootIndex(paramArrayOfX509Certificate);
  }

  public abstract X509Certificate findByIssuerAndSignature(X509Certificate paramX509Certificate);

  static final class AndroidTrustRootIndex extends TrustRootIndex
  {
    private final Method findByIssuerAndSignatureMethod;
    private final X509TrustManager trustManager;

    AndroidTrustRootIndex(X509TrustManager paramX509TrustManager, Method paramMethod)
    {
      this.findByIssuerAndSignatureMethod = paramMethod;
      this.trustManager = paramX509TrustManager;
    }

    public boolean equals(Object paramObject)
    {
      if (paramObject == this);
      do
      {
        return true;
        if (!(paramObject instanceof AndroidTrustRootIndex))
          return false;
        paramObject = (AndroidTrustRootIndex)paramObject;
      }
      while ((this.trustManager.equals(paramObject.trustManager)) && (this.findByIssuerAndSignatureMethod.equals(paramObject.findByIssuerAndSignatureMethod)));
      return false;
    }

    public X509Certificate findByIssuerAndSignature(X509Certificate paramX509Certificate)
    {
      Object localObject = null;
      try
      {
        TrustAnchor localTrustAnchor = (TrustAnchor)this.findByIssuerAndSignatureMethod.invoke(this.trustManager, new Object[] { paramX509Certificate });
        paramX509Certificate = localObject;
        if (localTrustAnchor != null)
          paramX509Certificate = localTrustAnchor.getTrustedCert();
        return paramX509Certificate;
      }
      catch (java.lang.IllegalAccessException paramX509Certificate)
      {
        throw new AssertionError();
      }
      catch (java.lang.reflect.InvocationTargetException paramX509Certificate)
      {
      }
      return null;
    }

    public int hashCode()
    {
      return this.trustManager.hashCode() + this.findByIssuerAndSignatureMethod.hashCode() * 31;
    }
  }

  static final class BasicTrustRootIndex extends TrustRootIndex
  {
    private final Map<X500Principal, Set<X509Certificate>> subjectToCaCerts = new LinkedHashMap();

    public BasicTrustRootIndex(X509Certificate[] paramArrayOfX509Certificate)
    {
      int j = paramArrayOfX509Certificate.length;
      int i = 0;
      while (i < j)
      {
        X509Certificate localX509Certificate = paramArrayOfX509Certificate[i];
        X500Principal localX500Principal = localX509Certificate.getSubjectX500Principal();
        Set localSet = (Set)this.subjectToCaCerts.get(localX500Principal);
        Object localObject = localSet;
        if (localSet == null)
        {
          localObject = new LinkedHashSet(1);
          this.subjectToCaCerts.put(localX500Principal, localObject);
        }
        ((Set)localObject).add(localX509Certificate);
        i += 1;
      }
    }

    public boolean equals(Object paramObject)
    {
      if (paramObject == this);
      do
        return true;
      while (((paramObject instanceof BasicTrustRootIndex)) && (((BasicTrustRootIndex)paramObject).subjectToCaCerts.equals(this.subjectToCaCerts)));
      return false;
    }

    public X509Certificate findByIssuerAndSignature(X509Certificate paramX509Certificate)
    {
      Object localObject = paramX509Certificate.getIssuerX500Principal();
      localObject = (Set)this.subjectToCaCerts.get(localObject);
      if (localObject == null)
        return null;
      localObject = ((Set)localObject).iterator();
      while (((Iterator)localObject).hasNext())
      {
        X509Certificate localX509Certificate = (X509Certificate)((Iterator)localObject).next();
        PublicKey localPublicKey = localX509Certificate.getPublicKey();
        try
        {
          paramX509Certificate.verify(localPublicKey);
          return localX509Certificate;
        }
        catch (Exception localException)
        {
        }
      }
      return (X509Certificate)null;
    }

    public int hashCode()
    {
      return this.subjectToCaCerts.hashCode();
    }
  }
}

/* Location:           C:\Users\c_jealom1\Documents\Scripts\Android\Fathom_com.brynk.fathom\Fathom_com.brynk.fathom-dex2jar.jar
 * Qualified Name:     okhttp3.internal.tls.TrustRootIndex
 * JD-Core Version:    0.6.0
 */
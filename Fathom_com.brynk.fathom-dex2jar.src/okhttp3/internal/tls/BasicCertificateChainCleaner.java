package okhttp3.internal.tls;

import java.security.Principal;
import java.security.cert.Certificate;
import java.security.cert.X509Certificate;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.Iterator;
import java.util.List;
import javax.net.ssl.SSLPeerUnverifiedException;

public final class BasicCertificateChainCleaner extends CertificateChainCleaner
{
  private static final int MAX_SIGNERS = 9;
  private final TrustRootIndex trustRootIndex;

  public BasicCertificateChainCleaner(TrustRootIndex paramTrustRootIndex)
  {
    this.trustRootIndex = paramTrustRootIndex;
  }

  private boolean verifySignature(X509Certificate paramX509Certificate1, X509Certificate paramX509Certificate2)
  {
    if (!paramX509Certificate1.getIssuerDN().equals(paramX509Certificate2.getSubjectDN()))
      return false;
    try
    {
      paramX509Certificate1.verify(paramX509Certificate2.getPublicKey());
      return true;
    }
    catch (java.security.GeneralSecurityException paramX509Certificate1)
    {
    }
    return false;
  }

  public List<Certificate> clean(List<Certificate> paramList, String paramString)
    throws SSLPeerUnverifiedException
  {
    paramList = new ArrayDeque(paramList);
    paramString = new ArrayList();
    paramString.add(paramList.removeFirst());
    int j = 0;
    int i = 0;
    if (i < 9)
    {
      X509Certificate localX509Certificate1 = (X509Certificate)paramString.get(paramString.size() - 1);
      Object localObject = this.trustRootIndex.findByIssuerAndSignature(localX509Certificate1);
      if (localObject != null)
      {
        if ((paramString.size() > 1) || (!localX509Certificate1.equals(localObject)))
          paramString.add(localObject);
        if (!verifySignature((X509Certificate)localObject, (X509Certificate)localObject));
      }
      do
      {
        return paramString;
        j = 1;
        while (true)
        {
          i += 1;
          break;
          localObject = paramList.iterator();
          X509Certificate localX509Certificate2;
          do
          {
            if (!((Iterator)localObject).hasNext())
              break;
            localX509Certificate2 = (X509Certificate)((Iterator)localObject).next();
          }
          while (!verifySignature(localX509Certificate1, localX509Certificate2));
          ((Iterator)localObject).remove();
          paramString.add(localX509Certificate2);
        }
      }
      while (j != 0);
      throw new SSLPeerUnverifiedException("Failed to find a trusted cert that signed " + localX509Certificate1);
    }
    throw new SSLPeerUnverifiedException("Certificate chain too long: " + paramString);
  }

  public boolean equals(Object paramObject)
  {
    if (paramObject == this);
    do
      return true;
    while (((paramObject instanceof BasicCertificateChainCleaner)) && (((BasicCertificateChainCleaner)paramObject).trustRootIndex.equals(this.trustRootIndex)));
    return false;
  }

  public int hashCode()
  {
    return this.trustRootIndex.hashCode();
  }
}

/* Location:           C:\Users\c_jealom1\Documents\Scripts\Android\Fathom_com.brynk.fathom\Fathom_com.brynk.fathom-dex2jar.jar
 * Qualified Name:     okhttp3.internal.tls.BasicCertificateChainCleaner
 * JD-Core Version:    0.6.0
 */
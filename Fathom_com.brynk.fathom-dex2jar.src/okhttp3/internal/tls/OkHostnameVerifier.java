package okhttp3.internal.tls;

import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLSession;
import okhttp3.internal.Util;

public final class OkHostnameVerifier
  implements HostnameVerifier
{
  private static final int ALT_DNS_NAME = 2;
  private static final int ALT_IPA_NAME = 7;
  public static final OkHostnameVerifier INSTANCE = new OkHostnameVerifier();

  public static List<String> allSubjectAltNames(X509Certificate paramX509Certificate)
  {
    List localList = getSubjectAltNames(paramX509Certificate, 7);
    paramX509Certificate = getSubjectAltNames(paramX509Certificate, 2);
    ArrayList localArrayList = new ArrayList(localList.size() + paramX509Certificate.size());
    localArrayList.addAll(localList);
    localArrayList.addAll(paramX509Certificate);
    return localArrayList;
  }

  private static List<String> getSubjectAltNames(X509Certificate paramX509Certificate, int paramInt)
  {
    ArrayList localArrayList = new ArrayList();
    try
    {
      paramX509Certificate = paramX509Certificate.getSubjectAlternativeNames();
      if (paramX509Certificate == null)
        return Collections.emptyList();
      Iterator localIterator = paramX509Certificate.iterator();
      while (true)
      {
        paramX509Certificate = localArrayList;
        if (!localIterator.hasNext())
          break;
        paramX509Certificate = (List)localIterator.next();
        if ((paramX509Certificate == null) || (paramX509Certificate.size() < 2))
          continue;
        Integer localInteger = (Integer)paramX509Certificate.get(0);
        if ((localInteger == null) || (localInteger.intValue() != paramInt))
          continue;
        paramX509Certificate = (String)paramX509Certificate.get(1);
        if (paramX509Certificate == null)
          continue;
        localArrayList.add(paramX509Certificate);
      }
    }
    catch (java.security.cert.CertificateParsingException paramX509Certificate)
    {
      paramX509Certificate = Collections.emptyList();
    }
    return paramX509Certificate;
  }

  private boolean verifyHostname(String paramString1, String paramString2)
  {
    if ((paramString1 == null) || (paramString1.length() == 0) || (paramString1.startsWith(".")) || (paramString1.endsWith("..")));
    String str;
    int i;
    do
    {
      do
      {
        do
        {
          do
            return false;
          while ((paramString2 == null) || (paramString2.length() == 0) || (paramString2.startsWith(".")) || (paramString2.endsWith("..")));
          str = paramString1;
          if (!paramString1.endsWith("."))
            str = paramString1 + '.';
          paramString1 = paramString2;
          if (!paramString2.endsWith("."))
            paramString1 = paramString2 + '.';
          paramString1 = paramString1.toLowerCase(Locale.US);
          if (!paramString1.contains("*"))
            return str.equals(paramString1);
        }
        while ((!paramString1.startsWith("*.")) || (paramString1.indexOf('*', 1) != -1) || (str.length() < paramString1.length()) || ("*.".equals(paramString1)));
        paramString1 = paramString1.substring(1);
      }
      while (!str.endsWith(paramString1));
      i = str.length() - paramString1.length();
    }
    while ((i > 0) && (str.lastIndexOf('.', i - 1) != -1));
    return true;
  }

  private boolean verifyHostname(String paramString, X509Certificate paramX509Certificate)
  {
    paramString = paramString.toLowerCase(Locale.US);
    int j = 0;
    List localList = getSubjectAltNames(paramX509Certificate, 2);
    int i = 0;
    int k = localList.size();
    while (i < k)
    {
      j = 1;
      if (verifyHostname(paramString, (String)localList.get(i)))
        return true;
      i += 1;
    }
    if (j == 0)
    {
      paramX509Certificate = new DistinguishedNameParser(paramX509Certificate.getSubjectX500Principal()).findMostSpecific("cn");
      if (paramX509Certificate != null)
        return verifyHostname(paramString, paramX509Certificate);
    }
    return false;
  }

  private boolean verifyIpAddress(String paramString, X509Certificate paramX509Certificate)
  {
    paramX509Certificate = getSubjectAltNames(paramX509Certificate, 7);
    int i = 0;
    int j = paramX509Certificate.size();
    while (i < j)
    {
      if (paramString.equalsIgnoreCase((String)paramX509Certificate.get(i)))
        return true;
      i += 1;
    }
    return false;
  }

  public boolean verify(String paramString, X509Certificate paramX509Certificate)
  {
    if (Util.verifyAsIpAddress(paramString))
      return verifyIpAddress(paramString, paramX509Certificate);
    return verifyHostname(paramString, paramX509Certificate);
  }

  public boolean verify(String paramString, SSLSession paramSSLSession)
  {
    try
    {
      boolean bool = verify(paramString, (X509Certificate)paramSSLSession.getPeerCertificates()[0]);
      return bool;
    }
    catch (javax.net.ssl.SSLException paramString)
    {
    }
    return false;
  }
}

/* Location:           C:\Users\c_jealom1\Documents\Scripts\Android\Fathom_com.brynk.fathom\Fathom_com.brynk.fathom-dex2jar.jar
 * Qualified Name:     okhttp3.internal.tls.OkHostnameVerifier
 * JD-Core Version:    0.6.0
 */
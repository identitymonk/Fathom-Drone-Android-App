package okhttp3;

import java.io.IOException;
import java.net.CookieHandler;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.List<Lokhttp3.Cookie;>;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import okhttp3.internal.Util;
import okhttp3.internal.platform.Platform;

public final class JavaNetCookieJar
  implements CookieJar
{
  private final CookieHandler cookieHandler;

  public JavaNetCookieJar(CookieHandler paramCookieHandler)
  {
    this.cookieHandler = paramCookieHandler;
  }

  private List<Cookie> decodeHeaderAsJavaNetCookies(HttpUrl paramHttpUrl, String paramString)
  {
    ArrayList localArrayList = new ArrayList();
    int i = 0;
    int j = paramString.length();
    while (i < j)
    {
      int k = Util.delimiterOffset(paramString, i, j, ";,");
      int m = Util.delimiterOffset(paramString, i, k, '=');
      String str3 = Util.trimSubstring(paramString, i, m);
      if (str3.startsWith("$"))
      {
        i = k + 1;
        continue;
      }
      if (m < k);
      for (String str1 = Util.trimSubstring(paramString, m + 1, k); ; str1 = "")
      {
        String str2 = str1;
        if (str1.startsWith("\""))
        {
          str2 = str1;
          if (str1.endsWith("\""))
            str2 = str1.substring(1, str1.length() - 1);
        }
        localArrayList.add(new Cookie.Builder().name(str3).value(str2).domain(paramHttpUrl.host()).build());
        break;
      }
    }
    return localArrayList;
  }

  public List<Cookie> loadForRequest(HttpUrl paramHttpUrl)
  {
    Object localObject1 = Collections.emptyMap();
    try
    {
      Object localObject2 = this.cookieHandler.get(paramHttpUrl.uri(), (Map)localObject1);
      localObject1 = null;
      Iterator localIterator = ((Map)localObject2).entrySet().iterator();
      while (localIterator.hasNext())
      {
        localObject2 = (Map.Entry)localIterator.next();
        Object localObject3 = (String)((Map.Entry)localObject2).getKey();
        if (((!"Cookie".equalsIgnoreCase((String)localObject3)) && (!"Cookie2".equalsIgnoreCase((String)localObject3))) || (((List)((Map.Entry)localObject2).getValue()).isEmpty()))
          continue;
        localObject3 = ((List)((Map.Entry)localObject2).getValue()).iterator();
        for (localObject2 = localObject1; ; localObject2 = localObject1)
        {
          localObject1 = localObject2;
          if (!((Iterator)localObject3).hasNext())
            break;
          String str = (String)((Iterator)localObject3).next();
          localObject1 = localObject2;
          if (localObject2 == null)
            localObject1 = new ArrayList();
          ((List)localObject1).addAll(decodeHeaderAsJavaNetCookies(paramHttpUrl, str));
        }
      }
    }
    catch (IOException localIOException)
    {
      Platform.get().log(5, "Loading cookies failed for " + paramHttpUrl.resolve("/..."), localIOException);
      return Collections.emptyList();
    }
    if (localIOException != null)
      return Collections.unmodifiableList(localIOException);
    return (List<Cookie>)(List<Cookie>)(List<Cookie>)Collections.emptyList();
  }

  public void saveFromResponse(HttpUrl paramHttpUrl, List<Cookie> paramList)
  {
    if (this.cookieHandler != null)
    {
      ArrayList localArrayList = new ArrayList();
      paramList = paramList.iterator();
      while (paramList.hasNext())
        localArrayList.add(((Cookie)paramList.next()).toString(true));
      paramList = Collections.singletonMap("Set-Cookie", localArrayList);
    }
    try
    {
      this.cookieHandler.put(paramHttpUrl.uri(), paramList);
      return;
    }
    catch (IOException paramList)
    {
      Platform.get().log(5, "Saving cookies failed for " + paramHttpUrl.resolve("/..."), paramList);
    }
  }
}

/* Location:           C:\Users\c_jealom1\Documents\Scripts\Android\Fathom_com.brynk.fathom\Fathom_com.brynk.fathom-dex2jar.jar
 * Qualified Name:     okhttp3.JavaNetCookieJar
 * JD-Core Version:    0.6.0
 */
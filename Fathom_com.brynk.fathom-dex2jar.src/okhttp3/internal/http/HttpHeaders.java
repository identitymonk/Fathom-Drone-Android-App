package okhttp3.internal.http;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.Set<Ljava.lang.String;>;
import java.util.TreeSet;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import okhttp3.Challenge;
import okhttp3.Cookie;
import okhttp3.CookieJar;
import okhttp3.Headers;
import okhttp3.Headers.Builder;
import okhttp3.HttpUrl;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.internal.Util;

public final class HttpHeaders
{
  private static final Pattern PARAMETER = Pattern.compile(" +([^ \"=]*)=(:?\"([^\"]*)\"|([^ \"=]*)) *(:?,|$)");
  private static final String QUOTED_STRING = "\"([^\"]*)\"";
  private static final String TOKEN = "([^ \"=]*)";

  public static long contentLength(Headers paramHeaders)
  {
    return stringToLong(paramHeaders.get("Content-Length"));
  }

  public static long contentLength(Response paramResponse)
  {
    return contentLength(paramResponse.headers());
  }

  public static boolean hasBody(Response paramResponse)
  {
    if (paramResponse.request().method().equals("HEAD"));
    do
    {
      return false;
      int i = paramResponse.code();
      if (((i < 100) || (i >= 200)) && (i != 204) && (i != 304))
        return true;
    }
    while ((contentLength(paramResponse) == -1L) && (!"chunked".equalsIgnoreCase(paramResponse.header("Transfer-Encoding"))));
    return true;
  }

  public static boolean hasVaryAll(Headers paramHeaders)
  {
    return varyFields(paramHeaders).contains("*");
  }

  public static boolean hasVaryAll(Response paramResponse)
  {
    return hasVaryAll(paramResponse.headers());
  }

  public static List<Challenge> parseChallenges(Headers paramHeaders, String paramString)
  {
    ArrayList localArrayList = new ArrayList();
    paramHeaders = paramHeaders.values(paramString).iterator();
    label139: 
    while (paramHeaders.hasNext())
    {
      paramString = (String)paramHeaders.next();
      int j = paramString.indexOf(' ');
      if (j == -1)
        continue;
      Matcher localMatcher = PARAMETER.matcher(paramString);
      for (int i = j; ; i = localMatcher.end())
      {
        if (!localMatcher.find(i))
          break label139;
        if (!paramString.regionMatches(true, localMatcher.start(1), "realm", 0, 5))
          continue;
        String str1 = paramString.substring(0, j);
        String str2 = localMatcher.group(3);
        if (str2 == null)
          continue;
        localArrayList.add(new Challenge(str1, str2));
        break;
      }
    }
    return localArrayList;
  }

  public static int parseSeconds(String paramString, int paramInt)
  {
    try
    {
      long l = Long.parseLong(paramString);
      if (l > 2147483647L)
        return 2147483647;
      if (l < 0L)
        return 0;
      return (int)l;
    }
    catch (java.lang.NumberFormatException paramString)
    {
    }
    return paramInt;
  }

  public static void receiveHeaders(CookieJar paramCookieJar, HttpUrl paramHttpUrl, Headers paramHeaders)
  {
    if (paramCookieJar == CookieJar.NO_COOKIES);
    do
    {
      return;
      paramHeaders = Cookie.parseAll(paramHttpUrl, paramHeaders);
    }
    while (paramHeaders.isEmpty());
    paramCookieJar.saveFromResponse(paramHttpUrl, paramHeaders);
  }

  public static int skipUntil(String paramString1, int paramInt, String paramString2)
  {
    while (true)
    {
      if ((paramInt >= paramString1.length()) || (paramString2.indexOf(paramString1.charAt(paramInt)) != -1))
        return paramInt;
      paramInt += 1;
    }
  }

  public static int skipWhitespace(String paramString, int paramInt)
  {
    while (true)
    {
      if (paramInt < paramString.length())
      {
        int i = paramString.charAt(paramInt);
        if ((i == 32) || (i == 9));
      }
      else
      {
        return paramInt;
      }
      paramInt += 1;
    }
  }

  private static long stringToLong(String paramString)
  {
    if (paramString == null)
      return -1L;
    try
    {
      long l = Long.parseLong(paramString);
      return l;
    }
    catch (java.lang.NumberFormatException paramString)
    {
    }
    return -1L;
  }

  public static Set<String> varyFields(Headers paramHeaders)
  {
    Object localObject2 = Collections.emptySet();
    int i = 0;
    int k = paramHeaders.size();
    while (i < k)
    {
      if (!"Vary".equalsIgnoreCase(paramHeaders.name(i)))
      {
        i += 1;
        continue;
      }
      Object localObject3 = paramHeaders.value(i);
      Object localObject1 = localObject2;
      if (((Set)localObject2).isEmpty())
        localObject1 = new TreeSet(String.CASE_INSENSITIVE_ORDER);
      localObject3 = ((String)localObject3).split(",");
      int m = localObject3.length;
      int j = 0;
      while (true)
      {
        localObject2 = localObject1;
        if (j >= m)
          break;
        ((Set)localObject1).add(localObject3[j].trim());
        j += 1;
      }
    }
    return (Set<String>)(Set<String>)(Set<String>)localObject2;
  }

  private static Set<String> varyFields(Response paramResponse)
  {
    return varyFields(paramResponse.headers());
  }

  public static Headers varyHeaders(Headers paramHeaders1, Headers paramHeaders2)
  {
    paramHeaders2 = varyFields(paramHeaders2);
    if (paramHeaders2.isEmpty())
      return new Headers.Builder().build();
    Headers.Builder localBuilder = new Headers.Builder();
    int i = 0;
    int j = paramHeaders1.size();
    while (i < j)
    {
      String str = paramHeaders1.name(i);
      if (paramHeaders2.contains(str))
        localBuilder.add(str, paramHeaders1.value(i));
      i += 1;
    }
    return localBuilder.build();
  }

  public static Headers varyHeaders(Response paramResponse)
  {
    return varyHeaders(paramResponse.networkResponse().request().headers(), paramResponse.headers());
  }

  public static boolean varyMatches(Response paramResponse, Headers paramHeaders, Request paramRequest)
  {
    paramResponse = varyFields(paramResponse).iterator();
    while (paramResponse.hasNext())
    {
      String str = (String)paramResponse.next();
      if (!Util.equal(paramHeaders.values(str), paramRequest.headers(str)))
        return false;
    }
    return true;
  }
}

/* Location:           C:\Users\c_jealom1\Documents\Scripts\Android\Fathom_com.brynk.fathom\Fathom_com.brynk.fathom-dex2jar.jar
 * Qualified Name:     okhttp3.internal.http.HttpHeaders
 * JD-Core Version:    0.6.0
 */
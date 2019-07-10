package okhttp3.internal;

import java.io.Closeable;
import java.io.IOException;
import java.lang.reflect.Array;
import java.net.IDN;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Locale;
import java.util.TimeZone;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.TimeUnit;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import okhttp3.HttpUrl;
import okhttp3.RequestBody;
import okhttp3.ResponseBody;
import okio.Buffer;
import okio.BufferedSource;
import okio.ByteString;
import okio.Source;
import okio.Timeout;

public final class Util
{
  public static final byte[] EMPTY_BYTE_ARRAY = new byte[0];
  public static final RequestBody EMPTY_REQUEST;
  public static final ResponseBody EMPTY_RESPONSE;
  public static final String[] EMPTY_STRING_ARRAY = new String[0];
  public static final TimeZone UTC;
  private static final Charset UTF_16_BE;
  private static final ByteString UTF_16_BE_BOM;
  private static final Charset UTF_16_LE;
  private static final ByteString UTF_16_LE_BOM;
  private static final Charset UTF_32_BE;
  private static final ByteString UTF_32_BE_BOM;
  private static final Charset UTF_32_LE;
  private static final ByteString UTF_32_LE_BOM;
  public static final Charset UTF_8;
  private static final ByteString UTF_8_BOM;
  private static final Pattern VERIFY_AS_IP_ADDRESS;

  static
  {
    EMPTY_RESPONSE = ResponseBody.create(null, EMPTY_BYTE_ARRAY);
    EMPTY_REQUEST = RequestBody.create(null, EMPTY_BYTE_ARRAY);
    UTF_8_BOM = ByteString.decodeHex("efbbbf");
    UTF_16_BE_BOM = ByteString.decodeHex("feff");
    UTF_16_LE_BOM = ByteString.decodeHex("fffe");
    UTF_32_BE_BOM = ByteString.decodeHex("0000ffff");
    UTF_32_LE_BOM = ByteString.decodeHex("ffff0000");
    UTF_8 = Charset.forName("UTF-8");
    UTF_16_BE = Charset.forName("UTF-16BE");
    UTF_16_LE = Charset.forName("UTF-16LE");
    UTF_32_BE = Charset.forName("UTF-32BE");
    UTF_32_LE = Charset.forName("UTF-32LE");
    UTC = TimeZone.getTimeZone("GMT");
    VERIFY_AS_IP_ADDRESS = Pattern.compile("([0-9a-fA-F]*:[0-9a-fA-F:.]*)|([\\d.]+)");
  }

  public static Charset bomAwareCharset(BufferedSource paramBufferedSource, Charset paramCharset)
    throws IOException
  {
    if (paramBufferedSource.rangeEquals(0L, UTF_8_BOM))
    {
      paramBufferedSource.skip(UTF_8_BOM.size());
      paramCharset = UTF_8;
    }
    do
    {
      return paramCharset;
      if (paramBufferedSource.rangeEquals(0L, UTF_16_BE_BOM))
      {
        paramBufferedSource.skip(UTF_16_BE_BOM.size());
        return UTF_16_BE;
      }
      if (paramBufferedSource.rangeEquals(0L, UTF_16_LE_BOM))
      {
        paramBufferedSource.skip(UTF_16_LE_BOM.size());
        return UTF_16_LE;
      }
      if (!paramBufferedSource.rangeEquals(0L, UTF_32_BE_BOM))
        continue;
      paramBufferedSource.skip(UTF_32_BE_BOM.size());
      return UTF_32_BE;
    }
    while (!paramBufferedSource.rangeEquals(0L, UTF_32_LE_BOM));
    paramBufferedSource.skip(UTF_32_LE_BOM.size());
    return UTF_32_LE;
  }

  public static void checkOffsetAndCount(long paramLong1, long paramLong2, long paramLong3)
  {
    if (((paramLong2 | paramLong3) < 0L) || (paramLong2 > paramLong1) || (paramLong1 - paramLong2 < paramLong3))
      throw new ArrayIndexOutOfBoundsException();
  }

  public static void closeQuietly(Closeable paramCloseable)
  {
    if (paramCloseable != null);
    try
    {
      paramCloseable.close();
      return;
    }
    catch (java.lang.RuntimeException paramCloseable)
    {
      throw paramCloseable;
    }
    catch (java.lang.Exception paramCloseable)
    {
    }
  }

  public static void closeQuietly(ServerSocket paramServerSocket)
  {
    if (paramServerSocket != null);
    try
    {
      paramServerSocket.close();
      return;
    }
    catch (java.lang.RuntimeException paramServerSocket)
    {
      throw paramServerSocket;
    }
    catch (java.lang.Exception paramServerSocket)
    {
    }
  }

  public static void closeQuietly(Socket paramSocket)
  {
    if (paramSocket != null);
    try
    {
      paramSocket.close();
      return;
    }
    catch (AssertionError paramSocket)
    {
      while (isAndroidGetsocknameError(paramSocket));
      throw paramSocket;
    }
    catch (java.lang.RuntimeException paramSocket)
    {
      throw paramSocket;
    }
    catch (java.lang.Exception paramSocket)
    {
    }
  }

  public static String[] concat(String[] paramArrayOfString, String paramString)
  {
    String[] arrayOfString = new String[paramArrayOfString.length + 1];
    System.arraycopy(paramArrayOfString, 0, arrayOfString, 0, paramArrayOfString.length);
    arrayOfString[(arrayOfString.length - 1)] = paramString;
    return arrayOfString;
  }

  private static boolean containsInvalidHostnameAsciiCodes(String paramString)
  {
    int i = 0;
    while (i < paramString.length())
    {
      int j = paramString.charAt(i);
      if ((j <= 31) || (j >= 127));
      do
        return true;
      while (" #%/:?@[\\]".indexOf(j) != -1);
      i += 1;
    }
    return false;
  }

  public static int delimiterOffset(String paramString, int paramInt1, int paramInt2, char paramChar)
  {
    while (paramInt1 < paramInt2)
    {
      if (paramString.charAt(paramInt1) == paramChar)
        return paramInt1;
      paramInt1 += 1;
    }
    return paramInt2;
  }

  public static int delimiterOffset(String paramString1, int paramInt1, int paramInt2, String paramString2)
  {
    while (paramInt1 < paramInt2)
    {
      if (paramString2.indexOf(paramString1.charAt(paramInt1)) != -1)
        return paramInt1;
      paramInt1 += 1;
    }
    return paramInt2;
  }

  public static boolean discard(Source paramSource, int paramInt, TimeUnit paramTimeUnit)
  {
    try
    {
      boolean bool = skipAll(paramSource, paramInt, paramTimeUnit);
      return bool;
    }
    catch (IOException paramSource)
    {
    }
    return false;
  }

  public static String domainToAscii(String paramString)
  {
    try
    {
      paramString = IDN.toASCII(paramString).toLowerCase(Locale.US);
      if (paramString.isEmpty())
        return null;
      boolean bool = containsInvalidHostnameAsciiCodes(paramString);
      if (bool)
        return null;
    }
    catch (java.lang.IllegalArgumentException paramString)
    {
      paramString = null;
    }
    return paramString;
  }

  public static boolean equal(Object paramObject1, Object paramObject2)
  {
    return (paramObject1 == paramObject2) || ((paramObject1 != null) && (paramObject1.equals(paramObject2)));
  }

  public static String format(String paramString, Object[] paramArrayOfObject)
  {
    return String.format(Locale.US, paramString, paramArrayOfObject);
  }

  public static String hostHeader(HttpUrl paramHttpUrl, boolean paramBoolean)
  {
    if (paramHttpUrl.host().contains(":"));
    for (String str1 = "[" + paramHttpUrl.host() + "]"; ; str1 = paramHttpUrl.host())
    {
      String str2;
      if (!paramBoolean)
      {
        str2 = str1;
        if (paramHttpUrl.port() == HttpUrl.defaultPort(paramHttpUrl.scheme()));
      }
      else
      {
        str2 = str1 + ":" + paramHttpUrl.port();
      }
      return str2;
    }
  }

  public static <T> List<T> immutableList(List<T> paramList)
  {
    return Collections.unmodifiableList(new ArrayList(paramList));
  }

  public static <T> List<T> immutableList(T[] paramArrayOfT)
  {
    return Collections.unmodifiableList(Arrays.asList((Object[])paramArrayOfT.clone()));
  }

  public static <T> int indexOf(T[] paramArrayOfT, T paramT)
  {
    int i = 0;
    int j = paramArrayOfT.length;
    while (i < j)
    {
      if (equal(paramArrayOfT[i], paramT))
        return i;
      i += 1;
    }
    return -1;
  }

  public static int indexOfControlOrNonAscii(String paramString)
  {
    int i = 0;
    int j = paramString.length();
    while (i < j)
    {
      int k = paramString.charAt(i);
      if ((k <= 31) || (k >= 127))
        return i;
      i += 1;
    }
    return -1;
  }

  private static <T> List<T> intersect(T[] paramArrayOfT1, T[] paramArrayOfT2)
  {
    ArrayList localArrayList = new ArrayList();
    int k = paramArrayOfT1.length;
    int i = 0;
    if (i < k)
    {
      T ? = paramArrayOfT1[i];
      int m = paramArrayOfT2.length;
      int j = 0;
      while (true)
      {
        if (j < m)
        {
          T ? = paramArrayOfT2[j];
          if (?.equals(?))
            localArrayList.add(?);
        }
        else
        {
          i += 1;
          break;
        }
        j += 1;
      }
    }
    return localArrayList;
  }

  public static <T> T[] intersect(Class<T> paramClass, T[] paramArrayOfT1, T[] paramArrayOfT2)
  {
    paramArrayOfT1 = intersect(paramArrayOfT1, paramArrayOfT2);
    return paramArrayOfT1.toArray((Object[])(Object[])Array.newInstance(paramClass, paramArrayOfT1.size()));
  }

  public static boolean isAndroidGetsocknameError(AssertionError paramAssertionError)
  {
    return (paramAssertionError.getCause() != null) && (paramAssertionError.getMessage() != null) && (paramAssertionError.getMessage().contains("getsockname failed"));
  }

  public static boolean skipAll(Source paramSource, int paramInt, TimeUnit paramTimeUnit)
    throws IOException
  {
    long l2 = System.nanoTime();
    long l1;
    if (paramSource.timeout().hasDeadline())
      l1 = paramSource.timeout().deadlineNanoTime() - l2;
    while (true)
    {
      paramSource.timeout().deadlineNanoTime(Math.min(l1, paramTimeUnit.toNanos(paramInt)) + l2);
      try
      {
        paramTimeUnit = new Buffer();
        while (paramSource.read(paramTimeUnit, 8192L) != -1L)
          paramTimeUnit.clear();
      }
      catch (java.io.InterruptedIOException paramTimeUnit)
      {
        if (l1 == 9223372036854775807L)
          paramSource.timeout().clearDeadline();
        while (true)
        {
          return false;
          l1 = 9223372036854775807L;
          break;
          if (l1 == 9223372036854775807L)
            paramSource.timeout().clearDeadline();
          while (true)
          {
            return true;
            paramSource.timeout().deadlineNanoTime(l2 + l1);
          }
          paramSource.timeout().deadlineNanoTime(l2 + l1);
        }
      }
      finally
      {
        if (l1 != 9223372036854775807L)
          break label188;
      }
    }
    paramSource.timeout().clearDeadline();
    while (true)
    {
      throw paramTimeUnit;
      label188: paramSource.timeout().deadlineNanoTime(l2 + l1);
    }
  }

  public static int skipLeadingAsciiWhitespace(String paramString, int paramInt1, int paramInt2)
  {
    while (paramInt1 < paramInt2)
    {
      switch (paramString.charAt(paramInt1))
      {
      default:
        return paramInt1;
      case '\t':
      case '\n':
      case '\f':
      case '\r':
      case ' ':
      }
      paramInt1 += 1;
    }
    return paramInt2;
  }

  public static int skipTrailingAsciiWhitespace(String paramString, int paramInt1, int paramInt2)
  {
    paramInt2 -= 1;
    while (true)
    {
      int i = paramInt1;
      if (paramInt2 >= paramInt1);
      switch (paramString.charAt(paramInt2))
      {
      default:
        i = paramInt2 + 1;
        return i;
      case '\t':
      case '\n':
      case '\f':
      case '\r':
      case ' ':
      }
      paramInt2 -= 1;
    }
  }

  public static ThreadFactory threadFactory(String paramString, boolean paramBoolean)
  {
    return new ThreadFactory(paramString, paramBoolean)
    {
      public Thread newThread(Runnable paramRunnable)
      {
        paramRunnable = new Thread(paramRunnable, this.val$name);
        paramRunnable.setDaemon(this.val$daemon);
        return paramRunnable;
      }
    };
  }

  public static String toHumanReadableAscii(String paramString)
  {
    int i = 0;
    int m = paramString.length();
    Object localObject;
    while (true)
    {
      localObject = paramString;
      if (i >= m)
        break;
      int j = paramString.codePointAt(i);
      if ((j > 31) && (j < 127))
      {
        i += Character.charCount(j);
        continue;
      }
      localObject = new Buffer();
      ((Buffer)localObject).writeUtf8(paramString, 0, i);
      if (i < m)
      {
        int k = paramString.codePointAt(i);
        if ((k > 31) && (k < 127));
        for (j = k; ; j = 63)
        {
          ((Buffer)localObject).writeUtf8CodePoint(j);
          i += Character.charCount(k);
          break;
        }
      }
      localObject = ((Buffer)localObject).readUtf8();
    }
    return (String)localObject;
  }

  public static String trimSubstring(String paramString, int paramInt1, int paramInt2)
  {
    paramInt1 = skipLeadingAsciiWhitespace(paramString, paramInt1, paramInt2);
    return paramString.substring(paramInt1, skipTrailingAsciiWhitespace(paramString, paramInt1, paramInt2));
  }

  public static boolean verifyAsIpAddress(String paramString)
  {
    return VERIFY_AS_IP_ADDRESS.matcher(paramString).matches();
  }
}

/* Location:           C:\Users\c_jealom1\Documents\Scripts\Android\Fathom_com.brynk.fathom\Fathom_com.brynk.fathom-dex2jar.jar
 * Qualified Name:     okhttp3.internal.Util
 * JD-Core Version:    0.6.0
 */
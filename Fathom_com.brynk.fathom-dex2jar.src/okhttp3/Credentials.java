package okhttp3;

import java.nio.charset.Charset;
import okio.ByteString;

public final class Credentials
{
  public static String basic(String paramString1, String paramString2)
  {
    return basic(paramString1, paramString2, Charset.forName("ISO-8859-1"));
  }

  public static String basic(String paramString1, String paramString2, Charset paramCharset)
  {
    paramString1 = ByteString.of((paramString1 + ":" + paramString2).getBytes(paramCharset)).base64();
    return "Basic " + paramString1;
  }
}

/* Location:           C:\Users\c_jealom1\Documents\Scripts\Android\Fathom_com.brynk.fathom\Fathom_com.brynk.fathom-dex2jar.jar
 * Qualified Name:     okhttp3.Credentials
 * JD-Core Version:    0.6.0
 */
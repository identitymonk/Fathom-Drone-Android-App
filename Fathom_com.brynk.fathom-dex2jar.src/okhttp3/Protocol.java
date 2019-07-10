package okhttp3;

import java.io.IOException;

public enum Protocol
{
  private final String protocol;

  static
  {
    HTTP_2 = new Protocol("HTTP_2", 3, "h2");
    $VALUES = new Protocol[] { HTTP_1_0, HTTP_1_1, SPDY_3, HTTP_2 };
  }

  private Protocol(String paramString)
  {
    this.protocol = paramString;
  }

  public static Protocol get(String paramString)
    throws IOException
  {
    if (paramString.equals(HTTP_1_0.protocol))
      return HTTP_1_0;
    if (paramString.equals(HTTP_1_1.protocol))
      return HTTP_1_1;
    if (paramString.equals(HTTP_2.protocol))
      return HTTP_2;
    if (paramString.equals(SPDY_3.protocol))
      return SPDY_3;
    throw new IOException("Unexpected protocol: " + paramString);
  }

  public String toString()
  {
    return this.protocol;
  }
}

/* Location:           C:\Users\c_jealom1\Documents\Scripts\Android\Fathom_com.brynk.fathom\Fathom_com.brynk.fathom-dex2jar.jar
 * Qualified Name:     okhttp3.Protocol
 * JD-Core Version:    0.6.0
 */
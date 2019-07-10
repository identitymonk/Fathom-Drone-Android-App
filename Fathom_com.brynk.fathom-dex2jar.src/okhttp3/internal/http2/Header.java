package okhttp3.internal.http2;

import okhttp3.internal.Util;
import okio.ByteString;

public final class Header
{
  public static final ByteString PSEUDO_PREFIX = ByteString.encodeUtf8(":");
  public static final ByteString RESPONSE_STATUS = ByteString.encodeUtf8(":status");
  public static final ByteString TARGET_AUTHORITY;
  public static final ByteString TARGET_METHOD = ByteString.encodeUtf8(":method");
  public static final ByteString TARGET_PATH = ByteString.encodeUtf8(":path");
  public static final ByteString TARGET_SCHEME = ByteString.encodeUtf8(":scheme");
  final int hpackSize;
  public final ByteString name;
  public final ByteString value;

  static
  {
    TARGET_AUTHORITY = ByteString.encodeUtf8(":authority");
  }

  public Header(String paramString1, String paramString2)
  {
    this(ByteString.encodeUtf8(paramString1), ByteString.encodeUtf8(paramString2));
  }

  public Header(ByteString paramByteString, String paramString)
  {
    this(paramByteString, ByteString.encodeUtf8(paramString));
  }

  public Header(ByteString paramByteString1, ByteString paramByteString2)
  {
    this.name = paramByteString1;
    this.value = paramByteString2;
    this.hpackSize = (paramByteString1.size() + 32 + paramByteString2.size());
  }

  public boolean equals(Object paramObject)
  {
    int j = 0;
    int i = j;
    if ((paramObject instanceof Header))
    {
      paramObject = (Header)paramObject;
      i = j;
      if (this.name.equals(paramObject.name))
      {
        i = j;
        if (this.value.equals(paramObject.value))
          i = 1;
      }
    }
    return i;
  }

  public int hashCode()
  {
    return (this.name.hashCode() + 527) * 31 + this.value.hashCode();
  }

  public String toString()
  {
    return Util.format("%s: %s", new Object[] { this.name.utf8(), this.value.utf8() });
  }
}

/* Location:           C:\Users\c_jealom1\Documents\Scripts\Android\Fathom_com.brynk.fathom\Fathom_com.brynk.fathom-dex2jar.jar
 * Qualified Name:     okhttp3.internal.http2.Header
 * JD-Core Version:    0.6.0
 */
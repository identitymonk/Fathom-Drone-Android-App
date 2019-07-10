package okhttp3.internal.http2;

import java.io.IOException;
import okhttp3.internal.Util;
import okio.ByteString;

public final class Http2
{
  static final String[] BINARY;
  static final ByteString CONNECTION_PREFACE = ByteString.encodeUtf8("PRI * HTTP/2.0\r\n\r\nSM\r\n\r\n");
  static final String[] FLAGS;
  static final byte FLAG_ACK = 1;
  static final byte FLAG_COMPRESSED = 32;
  static final byte FLAG_END_HEADERS = 4;
  static final byte FLAG_END_PUSH_PROMISE = 4;
  static final byte FLAG_END_STREAM = 1;
  static final byte FLAG_NONE = 0;
  static final byte FLAG_PADDED = 8;
  static final byte FLAG_PRIORITY = 32;
  private static final String[] FRAME_NAMES = { "DATA", "HEADERS", "PRIORITY", "RST_STREAM", "SETTINGS", "PUSH_PROMISE", "PING", "GOAWAY", "WINDOW_UPDATE", "CONTINUATION" };
  static final int INITIAL_MAX_FRAME_SIZE = 16384;
  static final byte TYPE_CONTINUATION = 9;
  static final byte TYPE_DATA = 0;
  static final byte TYPE_GOAWAY = 7;
  static final byte TYPE_HEADERS = 1;
  static final byte TYPE_PING = 6;
  static final byte TYPE_PRIORITY = 2;
  static final byte TYPE_PUSH_PROMISE = 5;
  static final byte TYPE_RST_STREAM = 3;
  static final byte TYPE_SETTINGS = 4;
  static final byte TYPE_WINDOW_UPDATE = 8;

  static
  {
    FLAGS = new String[64];
    BINARY = new String[256];
    int i = 0;
    while (i < BINARY.length)
    {
      BINARY[i] = Util.format("%8s", new Object[] { Integer.toBinaryString(i) }).replace(' ', '0');
      i += 1;
    }
    FLAGS[0] = "";
    FLAGS[1] = "END_STREAM";
    int[] arrayOfInt1 = new int[1];
    arrayOfInt1[0] = 1;
    FLAGS[8] = "PADDED";
    int j = arrayOfInt1.length;
    i = 0;
    while (i < j)
    {
      k = arrayOfInt1[i];
      FLAGS[(k | 0x8)] = (FLAGS[k] + "|PADDED");
      i += 1;
    }
    FLAGS[4] = "END_HEADERS";
    FLAGS[32] = "PRIORITY";
    FLAGS[36] = "END_HEADERS|PRIORITY";
    int[] arrayOfInt2 = new int[3];
    int[] tmp248_246 = arrayOfInt2;
    tmp248_246[0] = 4;
    int[] tmp252_248 = tmp248_246;
    tmp252_248[1] = 32;
    int[] tmp257_252 = tmp252_248;
    tmp257_252[2] = 36;
    tmp257_252;
    int k = arrayOfInt2.length;
    i = 0;
    while (i < k)
    {
      int m = arrayOfInt2[i];
      int n = arrayOfInt1.length;
      j = 0;
      while (j < n)
      {
        int i1 = arrayOfInt1[j];
        FLAGS[(i1 | m)] = (FLAGS[i1] + '|' + FLAGS[m]);
        FLAGS[(i1 | m | 0x8)] = (FLAGS[i1] + '|' + FLAGS[m] + "|PADDED");
        j += 1;
      }
      i += 1;
    }
    i = 0;
    while (i < FLAGS.length)
    {
      if (FLAGS[i] == null)
        FLAGS[i] = BINARY[i];
      i += 1;
    }
  }

  static String formatFlags(byte paramByte1, byte paramByte2)
  {
    if (paramByte2 == 0)
      return "";
    switch (paramByte1)
    {
    case 5:
    default:
      if (paramByte2 >= FLAGS.length)
        break;
    case 4:
    case 6:
    case 2:
    case 3:
    case 7:
    case 8:
    }
    for (String str = FLAGS[paramByte2]; (paramByte1 == 5) && ((paramByte2 & 0x4) != 0); str = BINARY[paramByte2])
    {
      return str.replace("HEADERS", "PUSH_PROMISE");
      if (paramByte2 == 1)
        return "ACK";
      return BINARY[paramByte2];
      return BINARY[paramByte2];
    }
    if ((paramByte1 == 0) && ((paramByte2 & 0x20) != 0))
      return str.replace("PRIORITY", "COMPRESSED");
    return str;
  }

  static String frameLog(boolean paramBoolean, int paramInt1, int paramInt2, byte paramByte1, byte paramByte2)
  {
    String str1;
    String str3;
    if (paramByte1 < FRAME_NAMES.length)
    {
      str1 = FRAME_NAMES[paramByte1];
      str3 = formatFlags(paramByte1, paramByte2);
      if (!paramBoolean)
        break label91;
    }
    label91: for (String str2 = "<<"; ; str2 = ">>")
    {
      return Util.format("%s 0x%08x %5d %-13s %s", new Object[] { str2, Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), str1, str3 });
      str1 = Util.format("0x%02x", new Object[] { Byte.valueOf(paramByte1) });
      break;
    }
  }

  static IllegalArgumentException illegalArgument(String paramString, Object[] paramArrayOfObject)
  {
    throw new IllegalArgumentException(Util.format(paramString, paramArrayOfObject));
  }

  static IOException ioException(String paramString, Object[] paramArrayOfObject)
    throws IOException
  {
    throw new IOException(Util.format(paramString, paramArrayOfObject));
  }
}

/* Location:           C:\Users\c_jealom1\Documents\Scripts\Android\Fathom_com.brynk.fathom\Fathom_com.brynk.fathom-dex2jar.jar
 * Qualified Name:     okhttp3.internal.http2.Http2
 * JD-Core Version:    0.6.0
 */
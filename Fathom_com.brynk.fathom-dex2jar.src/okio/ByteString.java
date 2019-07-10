package okio;

import B;
import java.io.EOFException;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.io.Serializable;
import java.lang.reflect.Field;
import java.nio.ByteBuffer;
import java.nio.charset.Charset;
import java.security.MessageDigest;
import java.util.Arrays;
import javax.annotation.Nullable;
import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;

public class ByteString
  implements Serializable, Comparable<ByteString>
{
  public static final ByteString EMPTY;
  static final char[] HEX_DIGITS = { 48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 97, 98, 99, 100, 101, 102 };
  private static final long serialVersionUID = 1L;
  final byte[] data;
  transient int hashCode;
  transient String utf8;

  static
  {
    EMPTY = of(new byte[0]);
  }

  ByteString(byte[] paramArrayOfByte)
  {
    this.data = paramArrayOfByte;
  }

  static int codePointIndexToCharIndex(String paramString, int paramInt)
  {
    int i = 0;
    int j = 0;
    int k = paramString.length();
    while (i < k)
    {
      if (j == paramInt)
        return i;
      int m = paramString.codePointAt(i);
      if (((Character.isISOControl(m)) && (m != 10) && (m != 13)) || (m == 65533))
        return -1;
      j += 1;
      i += Character.charCount(m);
    }
    return paramString.length();
  }

  @Nullable
  public static ByteString decodeBase64(String paramString)
  {
    if (paramString == null)
      throw new IllegalArgumentException("base64 == null");
    paramString = Base64.decode(paramString);
    if (paramString != null)
      return new ByteString(paramString);
    return null;
  }

  public static ByteString decodeHex(String paramString)
  {
    if (paramString == null)
      throw new IllegalArgumentException("hex == null");
    if (paramString.length() % 2 != 0)
      throw new IllegalArgumentException("Unexpected hex string: " + paramString);
    byte[] arrayOfByte = new byte[paramString.length() / 2];
    int i = 0;
    while (i < arrayOfByte.length)
    {
      arrayOfByte[i] = (byte)((decodeHexDigit(paramString.charAt(i * 2)) << 4) + decodeHexDigit(paramString.charAt(i * 2 + 1)));
      i += 1;
    }
    return of(arrayOfByte);
  }

  private static int decodeHexDigit(char paramChar)
  {
    if ((paramChar >= '0') && (paramChar <= '9'))
      return paramChar - '0';
    if ((paramChar >= 'a') && (paramChar <= 'f'))
      return paramChar - 'a' + 10;
    if ((paramChar >= 'A') && (paramChar <= 'F'))
      return paramChar - 'A' + 10;
    throw new IllegalArgumentException("Unexpected hex digit: " + paramChar);
  }

  private ByteString digest(String paramString)
  {
    try
    {
      paramString = of(MessageDigest.getInstance(paramString).digest(this.data));
      return paramString;
    }
    catch (java.security.NoSuchAlgorithmException paramString)
    {
    }
    throw new AssertionError(paramString);
  }

  public static ByteString encodeString(String paramString, Charset paramCharset)
  {
    if (paramString == null)
      throw new IllegalArgumentException("s == null");
    if (paramCharset == null)
      throw new IllegalArgumentException("charset == null");
    return new ByteString(paramString.getBytes(paramCharset));
  }

  public static ByteString encodeUtf8(String paramString)
  {
    if (paramString == null)
      throw new IllegalArgumentException("s == null");
    ByteString localByteString = new ByteString(paramString.getBytes(Util.UTF_8));
    localByteString.utf8 = paramString;
    return localByteString;
  }

  private ByteString hmac(String paramString, ByteString paramByteString)
  {
    try
    {
      Mac localMac = Mac.getInstance(paramString);
      localMac.init(new SecretKeySpec(paramByteString.toByteArray(), paramString));
      paramString = of(localMac.doFinal(this.data));
      return paramString;
    }
    catch (java.security.NoSuchAlgorithmException paramString)
    {
      throw new AssertionError(paramString);
    }
    catch (java.security.InvalidKeyException paramString)
    {
    }
    throw new IllegalArgumentException(paramString);
  }

  public static ByteString of(ByteBuffer paramByteBuffer)
  {
    if (paramByteBuffer == null)
      throw new IllegalArgumentException("data == null");
    byte[] arrayOfByte = new byte[paramByteBuffer.remaining()];
    paramByteBuffer.get(arrayOfByte);
    return new ByteString(arrayOfByte);
  }

  public static ByteString of(byte[] paramArrayOfByte)
  {
    if (paramArrayOfByte == null)
      throw new IllegalArgumentException("data == null");
    return new ByteString((byte[])paramArrayOfByte.clone());
  }

  public static ByteString of(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    if (paramArrayOfByte == null)
      throw new IllegalArgumentException("data == null");
    Util.checkOffsetAndCount(paramArrayOfByte.length, paramInt1, paramInt2);
    byte[] arrayOfByte = new byte[paramInt2];
    System.arraycopy(paramArrayOfByte, paramInt1, arrayOfByte, 0, paramInt2);
    return new ByteString(arrayOfByte);
  }

  public static ByteString read(InputStream paramInputStream, int paramInt)
    throws IOException
  {
    if (paramInputStream == null)
      throw new IllegalArgumentException("in == null");
    if (paramInt < 0)
      throw new IllegalArgumentException("byteCount < 0: " + paramInt);
    byte[] arrayOfByte = new byte[paramInt];
    int i = 0;
    while (i < paramInt)
    {
      int j = paramInputStream.read(arrayOfByte, i, paramInt - i);
      if (j == -1)
        throw new EOFException();
      i += j;
    }
    return new ByteString(arrayOfByte);
  }

  private void readObject(ObjectInputStream paramObjectInputStream)
    throws IOException
  {
    paramObjectInputStream = read(paramObjectInputStream, paramObjectInputStream.readInt());
    try
    {
      Field localField = ByteString.class.getDeclaredField("data");
      localField.setAccessible(true);
      localField.set(this, paramObjectInputStream.data);
      return;
    }
    catch (java.lang.NoSuchFieldException paramObjectInputStream)
    {
      throw new AssertionError();
    }
    catch (java.lang.IllegalAccessException paramObjectInputStream)
    {
    }
    throw new AssertionError();
  }

  private void writeObject(ObjectOutputStream paramObjectOutputStream)
    throws IOException
  {
    paramObjectOutputStream.writeInt(this.data.length);
    paramObjectOutputStream.write(this.data);
  }

  public ByteBuffer asByteBuffer()
  {
    return ByteBuffer.wrap(this.data).asReadOnlyBuffer();
  }

  public String base64()
  {
    return Base64.encode(this.data);
  }

  public String base64Url()
  {
    return Base64.encodeUrl(this.data);
  }

  public int compareTo(ByteString paramByteString)
  {
    int j = size();
    int k = paramByteString.size();
    int i = 0;
    int m = Math.min(j, k);
    while (true)
      if (i < m)
      {
        int n = getByte(i) & 0xFF;
        int i1 = paramByteString.getByte(i) & 0xFF;
        if (n == i1)
        {
          i += 1;
          continue;
        }
        if (n >= i1)
          break;
      }
    do
    {
      return -1;
      return 1;
      if (j == k)
        return 0;
    }
    while (j < k);
    return 1;
  }

  public final boolean endsWith(ByteString paramByteString)
  {
    return rangeEquals(size() - paramByteString.size(), paramByteString, 0, paramByteString.size());
  }

  public final boolean endsWith(byte[] paramArrayOfByte)
  {
    return rangeEquals(size() - paramArrayOfByte.length, paramArrayOfByte, 0, paramArrayOfByte.length);
  }

  public boolean equals(Object paramObject)
  {
    if (paramObject == this)
      return true;
    if (((paramObject instanceof ByteString)) && (((ByteString)paramObject).size() == this.data.length) && (((ByteString)paramObject).rangeEquals(0, this.data, 0, this.data.length)));
    for (int i = 1; ; i = 0)
      return i;
  }

  public byte getByte(int paramInt)
  {
    return this.data[paramInt];
  }

  public int hashCode()
  {
    int i = this.hashCode;
    if (i != 0)
      return i;
    i = Arrays.hashCode(this.data);
    this.hashCode = i;
    return i;
  }

  public String hex()
  {
    char[] arrayOfChar = new char[this.data.length * 2];
    byte[] arrayOfByte = this.data;
    int k = arrayOfByte.length;
    int i = 0;
    int j = 0;
    while (i < k)
    {
      int m = arrayOfByte[i];
      int n = j + 1;
      arrayOfChar[j] = HEX_DIGITS[(m >> 4 & 0xF)];
      j = n + 1;
      arrayOfChar[n] = HEX_DIGITS[(m & 0xF)];
      i += 1;
    }
    return new String(arrayOfChar);
  }

  public ByteString hmacSha1(ByteString paramByteString)
  {
    return hmac("HmacSHA1", paramByteString);
  }

  public ByteString hmacSha256(ByteString paramByteString)
  {
    return hmac("HmacSHA256", paramByteString);
  }

  public ByteString hmacSha512(ByteString paramByteString)
  {
    return hmac("HmacSHA512", paramByteString);
  }

  public final int indexOf(ByteString paramByteString)
  {
    return indexOf(paramByteString.internalArray(), 0);
  }

  public final int indexOf(ByteString paramByteString, int paramInt)
  {
    return indexOf(paramByteString.internalArray(), paramInt);
  }

  public final int indexOf(byte[] paramArrayOfByte)
  {
    return indexOf(paramArrayOfByte, 0);
  }

  public int indexOf(byte[] paramArrayOfByte, int paramInt)
  {
    paramInt = Math.max(paramInt, 0);
    int i = this.data.length;
    int j = paramArrayOfByte.length;
    while (paramInt <= i - j)
    {
      if (Util.arrayRangeEquals(this.data, paramInt, paramArrayOfByte, 0, paramArrayOfByte.length))
        return paramInt;
      paramInt += 1;
    }
    return -1;
  }

  byte[] internalArray()
  {
    return this.data;
  }

  public final int lastIndexOf(ByteString paramByteString)
  {
    return lastIndexOf(paramByteString.internalArray(), size());
  }

  public final int lastIndexOf(ByteString paramByteString, int paramInt)
  {
    return lastIndexOf(paramByteString.internalArray(), paramInt);
  }

  public final int lastIndexOf(byte[] paramArrayOfByte)
  {
    return lastIndexOf(paramArrayOfByte, size());
  }

  public int lastIndexOf(byte[] paramArrayOfByte, int paramInt)
  {
    paramInt = Math.min(paramInt, this.data.length - paramArrayOfByte.length);
    while (paramInt >= 0)
    {
      if (Util.arrayRangeEquals(this.data, paramInt, paramArrayOfByte, 0, paramArrayOfByte.length))
        return paramInt;
      paramInt -= 1;
    }
    return -1;
  }

  public ByteString md5()
  {
    return digest("MD5");
  }

  public boolean rangeEquals(int paramInt1, ByteString paramByteString, int paramInt2, int paramInt3)
  {
    return paramByteString.rangeEquals(paramInt2, this.data, paramInt1, paramInt3);
  }

  public boolean rangeEquals(int paramInt1, byte[] paramArrayOfByte, int paramInt2, int paramInt3)
  {
    return (paramInt1 >= 0) && (paramInt1 <= this.data.length - paramInt3) && (paramInt2 >= 0) && (paramInt2 <= paramArrayOfByte.length - paramInt3) && (Util.arrayRangeEquals(this.data, paramInt1, paramArrayOfByte, paramInt2, paramInt3));
  }

  public ByteString sha1()
  {
    return digest("SHA-1");
  }

  public ByteString sha256()
  {
    return digest("SHA-256");
  }

  public ByteString sha512()
  {
    return digest("SHA-512");
  }

  public int size()
  {
    return this.data.length;
  }

  public final boolean startsWith(ByteString paramByteString)
  {
    return rangeEquals(0, paramByteString, 0, paramByteString.size());
  }

  public final boolean startsWith(byte[] paramArrayOfByte)
  {
    return rangeEquals(0, paramArrayOfByte, 0, paramArrayOfByte.length);
  }

  public String string(Charset paramCharset)
  {
    if (paramCharset == null)
      throw new IllegalArgumentException("charset == null");
    return new String(this.data, paramCharset);
  }

  public ByteString substring(int paramInt)
  {
    return substring(paramInt, this.data.length);
  }

  public ByteString substring(int paramInt1, int paramInt2)
  {
    if (paramInt1 < 0)
      throw new IllegalArgumentException("beginIndex < 0");
    if (paramInt2 > this.data.length)
      throw new IllegalArgumentException("endIndex > length(" + this.data.length + ")");
    int i = paramInt2 - paramInt1;
    if (i < 0)
      throw new IllegalArgumentException("endIndex < beginIndex");
    if ((paramInt1 == 0) && (paramInt2 == this.data.length))
      return this;
    byte[] arrayOfByte = new byte[i];
    System.arraycopy(this.data, paramInt1, arrayOfByte, 0, i);
    return new ByteString(arrayOfByte);
  }

  public ByteString toAsciiLowercase()
  {
    int i = 0;
    Object localObject;
    while (true)
    {
      localObject = this;
      if (i >= this.data.length)
        break;
      int j = this.data[i];
      if ((j < 65) || (j > 90))
      {
        i += 1;
        continue;
      }
      localObject = (byte[])this.data.clone();
      localObject[i] = (byte)(j + 32);
      i += 1;
      if (i < localObject.length)
      {
        j = localObject[i];
        if ((j < 65) || (j > 90));
        while (true)
        {
          i += 1;
          break;
          localObject[i] = (byte)(j + 32);
        }
      }
      localObject = new ByteString(localObject);
    }
    return (ByteString)localObject;
  }

  public ByteString toAsciiUppercase()
  {
    int i = 0;
    Object localObject;
    while (true)
    {
      localObject = this;
      if (i >= this.data.length)
        break;
      int j = this.data[i];
      if ((j < 97) || (j > 122))
      {
        i += 1;
        continue;
      }
      localObject = (byte[])this.data.clone();
      localObject[i] = (byte)(j - 32);
      i += 1;
      if (i < localObject.length)
      {
        j = localObject[i];
        if ((j < 97) || (j > 122));
        while (true)
        {
          i += 1;
          break;
          localObject[i] = (byte)(j - 32);
        }
      }
      localObject = new ByteString(localObject);
    }
    return (ByteString)localObject;
  }

  public byte[] toByteArray()
  {
    return (byte[])this.data.clone();
  }

  public String toString()
  {
    if (this.data.length == 0)
      return "[size=0]";
    String str1 = utf8();
    int i = codePointIndexToCharIndex(str1, 64);
    if (i == -1)
    {
      if (this.data.length <= 64)
        return "[hex=" + hex() + "]";
      return "[size=" + this.data.length + " hex=" + substring(0, 64).hex() + "…]";
    }
    String str2 = str1.substring(0, i).replace("\\", "\\\\").replace("\n", "\\n").replace("\r", "\\r");
    if (i < str1.length())
      return "[size=" + this.data.length + " text=" + str2 + "…]";
    return "[text=" + str2 + "]";
  }

  public String utf8()
  {
    String str = this.utf8;
    if (str != null)
      return str;
    str = new String(this.data, Util.UTF_8);
    this.utf8 = str;
    return str;
  }

  public void write(OutputStream paramOutputStream)
    throws IOException
  {
    if (paramOutputStream == null)
      throw new IllegalArgumentException("out == null");
    paramOutputStream.write(this.data);
  }

  void write(Buffer paramBuffer)
  {
    paramBuffer.write(this.data, 0, this.data.length);
  }
}

/* Location:           C:\Users\c_jealom1\Documents\Scripts\Android\Fathom_com.brynk.fathom\Fathom_com.brynk.fathom-dex2jar.jar
 * Qualified Name:     okio.ByteString
 * JD-Core Version:    0.6.0
 */
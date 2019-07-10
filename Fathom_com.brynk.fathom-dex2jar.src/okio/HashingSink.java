package okio;

import java.io.IOException;
import java.security.MessageDigest;
import javax.annotation.Nullable;
import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;

public final class HashingSink extends ForwardingSink
{

  @Nullable
  private final Mac mac;

  @Nullable
  private final MessageDigest messageDigest;

  private HashingSink(Sink paramSink, String paramString)
  {
    super(paramSink);
    try
    {
      this.messageDigest = MessageDigest.getInstance(paramString);
      this.mac = null;
      return;
    }
    catch (java.security.NoSuchAlgorithmException paramSink)
    {
    }
    throw new AssertionError();
  }

  private HashingSink(Sink paramSink, ByteString paramByteString, String paramString)
  {
    super(paramSink);
    try
    {
      this.mac = Mac.getInstance(paramString);
      this.mac.init(new SecretKeySpec(paramByteString.toByteArray(), paramString));
      this.messageDigest = null;
      return;
    }
    catch (java.security.NoSuchAlgorithmException paramSink)
    {
      throw new AssertionError();
    }
    catch (java.security.InvalidKeyException paramSink)
    {
    }
    throw new IllegalArgumentException(paramSink);
  }

  public static HashingSink hmacSha1(Sink paramSink, ByteString paramByteString)
  {
    return new HashingSink(paramSink, paramByteString, "HmacSHA1");
  }

  public static HashingSink hmacSha256(Sink paramSink, ByteString paramByteString)
  {
    return new HashingSink(paramSink, paramByteString, "HmacSHA256");
  }

  public static HashingSink hmacSha512(Sink paramSink, ByteString paramByteString)
  {
    return new HashingSink(paramSink, paramByteString, "HmacSHA512");
  }

  public static HashingSink md5(Sink paramSink)
  {
    return new HashingSink(paramSink, "MD5");
  }

  public static HashingSink sha1(Sink paramSink)
  {
    return new HashingSink(paramSink, "SHA-1");
  }

  public static HashingSink sha256(Sink paramSink)
  {
    return new HashingSink(paramSink, "SHA-256");
  }

  public static HashingSink sha512(Sink paramSink)
  {
    return new HashingSink(paramSink, "SHA-512");
  }

  public ByteString hash()
  {
    if (this.messageDigest != null);
    for (byte[] arrayOfByte = this.messageDigest.digest(); ; arrayOfByte = this.mac.doFinal())
      return ByteString.of(arrayOfByte);
  }

  public void write(Buffer paramBuffer, long paramLong)
    throws IOException
  {
    Util.checkOffsetAndCount(paramBuffer.size, 0L, paramLong);
    long l = 0L;
    Segment localSegment = paramBuffer.head;
    if (l < paramLong)
    {
      int i = (int)Math.min(paramLong - l, localSegment.limit - localSegment.pos);
      if (this.messageDigest != null)
        this.messageDigest.update(localSegment.data, localSegment.pos, i);
      while (true)
      {
        l += i;
        localSegment = localSegment.next;
        break;
        this.mac.update(localSegment.data, localSegment.pos, i);
      }
    }
    super.write(paramBuffer, paramLong);
  }
}

/* Location:           C:\Users\c_jealom1\Documents\Scripts\Android\Fathom_com.brynk.fathom\Fathom_com.brynk.fathom-dex2jar.jar
 * Qualified Name:     okio.HashingSink
 * JD-Core Version:    0.6.0
 */
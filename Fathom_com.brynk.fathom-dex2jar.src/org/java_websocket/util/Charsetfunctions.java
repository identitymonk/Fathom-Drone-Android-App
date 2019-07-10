package org.java_websocket.util;

import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.charset.Charset;
import java.nio.charset.CharsetDecoder;
import java.nio.charset.CodingErrorAction;
import org.java_websocket.exceptions.InvalidDataException;

public class Charsetfunctions
{
  public static CodingErrorAction codingErrorAction = CodingErrorAction.REPORT;

  public static byte[] asciiBytes(String paramString)
  {
    try
    {
      paramString = paramString.getBytes("ASCII");
      return paramString;
    }
    catch (java.io.UnsupportedEncodingException paramString)
    {
    }
    throw new RuntimeException(paramString);
  }

  public static void main(String[] paramArrayOfString)
    throws InvalidDataException
  {
    stringUtf8(utf8Bytes(""));
    stringAscii(asciiBytes(""));
  }

  public static String stringAscii(byte[] paramArrayOfByte)
  {
    return stringAscii(paramArrayOfByte, 0, paramArrayOfByte.length);
  }

  public static String stringAscii(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    try
    {
      paramArrayOfByte = new String(paramArrayOfByte, paramInt1, paramInt2, "ASCII");
      return paramArrayOfByte;
    }
    catch (java.io.UnsupportedEncodingException paramArrayOfByte)
    {
    }
    throw new RuntimeException(paramArrayOfByte);
  }

  public static String stringUtf8(ByteBuffer paramByteBuffer)
    throws InvalidDataException
  {
    Object localObject = Charset.forName("UTF8").newDecoder();
    ((CharsetDecoder)localObject).onMalformedInput(codingErrorAction);
    ((CharsetDecoder)localObject).onUnmappableCharacter(codingErrorAction);
    try
    {
      paramByteBuffer.mark();
      localObject = ((CharsetDecoder)localObject).decode(paramByteBuffer).toString();
      paramByteBuffer.reset();
      return localObject;
    }
    catch (java.nio.charset.CharacterCodingException paramByteBuffer)
    {
    }
    throw new InvalidDataException(1007, paramByteBuffer);
  }

  public static String stringUtf8(byte[] paramArrayOfByte)
    throws InvalidDataException
  {
    return stringUtf8(ByteBuffer.wrap(paramArrayOfByte));
  }

  public static byte[] utf8Bytes(String paramString)
  {
    try
    {
      paramString = paramString.getBytes("UTF8");
      return paramString;
    }
    catch (java.io.UnsupportedEncodingException paramString)
    {
    }
    throw new RuntimeException(paramString);
  }
}

/* Location:           C:\Users\c_jealom1\Documents\Scripts\Android\Fathom_com.brynk.fathom\Fathom_com.brynk.fathom-dex2jar.jar
 * Qualified Name:     org.java_websocket.util.Charsetfunctions
 * JD-Core Version:    0.6.0
 */
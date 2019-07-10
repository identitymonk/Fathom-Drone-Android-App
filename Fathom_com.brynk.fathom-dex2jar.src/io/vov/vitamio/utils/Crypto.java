package io.vov.vitamio.utils;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.PublicKey;
import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

public class Crypto
{
  private Cipher ecipher;

  public Crypto(String paramString)
  {
    try
    {
      setupCrypto(new SecretKeySpec(generateKey(paramString), "AES"));
      return;
    }
    catch (Exception paramString)
    {
      Log.e("Crypto", paramString);
    }
  }

  private static byte[] generateKey(String paramString)
  {
    try
    {
      paramString = paramString.getBytes("UTF-8");
      paramString = MessageDigest.getInstance("SHA256").digest(paramString);
      return paramString;
    }
    catch (Exception paramString)
    {
      Log.e("generateKey", paramString);
    }
    return null;
  }

  public static String md5(String paramString)
  {
    Object localObject;
    try
    {
      localObject = MessageDigest.getInstance("MD5");
      ((MessageDigest)localObject).update(paramString.getBytes());
      for (paramString = new BigInteger(1, ((MessageDigest)localObject).digest()).toString(16); ; paramString = "0" + paramString)
      {
        localObject = paramString;
        if (paramString.length() >= 32)
          break;
      }
    }
    catch (Exception paramString)
    {
      localObject = "";
    }
    return (String)localObject;
  }

  private PublicKey readKeyFromStream(InputStream paramInputStream)
    throws IOException
  {
    paramInputStream = new ObjectInputStream(new BufferedInputStream(paramInputStream));
    try
    {
      PublicKey localPublicKey = (PublicKey)paramInputStream.readObject();
      return localPublicKey;
    }
    catch (Exception localException)
    {
      Log.e("readKeyFromStream", localException);
      return null;
    }
    finally
    {
      paramInputStream.close();
    }
    throw localObject;
  }

  private void setupCrypto(SecretKey paramSecretKey)
  {
    IvParameterSpec localIvParameterSpec = new IvParameterSpec(new byte[] { 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15 });
    try
    {
      this.ecipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
      this.ecipher.init(1, paramSecretKey, localIvParameterSpec);
      return;
    }
    catch (Exception paramSecretKey)
    {
      this.ecipher = null;
      Log.e("setupCrypto", paramSecretKey);
    }
  }

  public String encrypt(String paramString)
  {
    if (this.ecipher == null)
      return "";
    try
    {
      paramString = Base64.encodeToString(this.ecipher.doFinal(paramString.getBytes("UTF-8")), 2);
      return paramString;
    }
    catch (Exception paramString)
    {
      Log.e("encryp", paramString);
    }
    return "";
  }

  public String rsaEncrypt(InputStream paramInputStream, String paramString)
  {
    try
    {
      paramInputStream = rsaEncrypt(paramInputStream, paramString.getBytes("UTF-8"));
      return paramInputStream;
    }
    catch (java.io.UnsupportedEncodingException paramInputStream)
    {
    }
    return "";
  }

  public String rsaEncrypt(InputStream paramInputStream, byte[] paramArrayOfByte)
  {
    try
    {
      paramInputStream = readKeyFromStream(paramInputStream);
      Cipher localCipher = Cipher.getInstance("RSA/ECB/NoPadding");
      localCipher.init(1, paramInputStream);
      paramInputStream = Base64.encodeToString(localCipher.doFinal(paramArrayOfByte), 2);
      return paramInputStream;
    }
    catch (Exception paramInputStream)
    {
      Log.e("rsaEncrypt", paramInputStream);
    }
    return "";
  }
}

/* Location:           C:\Users\c_jealom1\Documents\Scripts\Android\Fathom_com.brynk.fathom\Fathom_com.brynk.fathom-dex2jar.jar
 * Qualified Name:     io.vov.vitamio.utils.Crypto
 * JD-Core Version:    0.6.0
 */
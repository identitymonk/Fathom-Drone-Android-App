package com.google.android.gms.common.util;

import android.os.ParcelFileDescriptor;
import java.io.ByteArrayOutputStream;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public final class zzo
{
  public static long zza(InputStream paramInputStream, OutputStream paramOutputStream)
    throws IOException
  {
    return zza(paramInputStream, paramOutputStream, false);
  }

  public static long zza(InputStream paramInputStream, OutputStream paramOutputStream, boolean paramBoolean)
    throws IOException
  {
    return zza(paramInputStream, paramOutputStream, paramBoolean, 1024);
  }

  public static long zza(InputStream paramInputStream, OutputStream paramOutputStream, boolean paramBoolean, int paramInt)
    throws IOException
  {
    byte[] arrayOfByte = new byte[paramInt];
    long l = 0L;
    try
    {
      while (true)
      {
        int i = paramInputStream.read(arrayOfByte, 0, paramInt);
        if (i == -1)
          break;
        l += i;
        paramOutputStream.write(arrayOfByte, 0, i);
      }
    }
    finally
    {
      if (paramBoolean)
      {
        zzb(paramInputStream);
        zzb(paramOutputStream);
      }
    }
    if (paramBoolean)
    {
      zzb(paramInputStream);
      zzb(paramOutputStream);
    }
    return l;
  }

  public static void zza(ParcelFileDescriptor paramParcelFileDescriptor)
  {
    if (paramParcelFileDescriptor != null);
    try
    {
      paramParcelFileDescriptor.close();
      return;
    }
    catch (IOException paramParcelFileDescriptor)
    {
    }
  }

  public static byte[] zza(InputStream paramInputStream, boolean paramBoolean)
    throws IOException
  {
    ByteArrayOutputStream localByteArrayOutputStream = new ByteArrayOutputStream();
    zza(paramInputStream, localByteArrayOutputStream, paramBoolean);
    return localByteArrayOutputStream.toByteArray();
  }

  public static void zzb(Closeable paramCloseable)
  {
    if (paramCloseable != null);
    try
    {
      paramCloseable.close();
      return;
    }
    catch (IOException paramCloseable)
    {
    }
  }

  public static byte[] zzk(InputStream paramInputStream)
    throws IOException
  {
    return zza(paramInputStream, true);
  }
}

/* Location:           C:\Users\c_jealom1\Documents\Scripts\Android\Fathom_com.brynk.fathom\Fathom_com.brynk.fathom-dex2jar.jar
 * Qualified Name:     com.google.android.gms.common.util.zzo
 * JD-Core Version:    0.6.0
 */
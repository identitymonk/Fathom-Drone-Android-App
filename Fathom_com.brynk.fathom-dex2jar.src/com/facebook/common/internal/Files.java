package com.facebook.common.internal;

import java.io.IOException;
import java.io.InputStream;

public class Files
{
  static byte[] readFile(InputStream paramInputStream, long paramLong)
    throws IOException
  {
    if (paramLong > 2147483647L)
      throw new OutOfMemoryError("file is too large to fit in a byte array: " + paramLong + " bytes");
    if (paramLong == 0L)
      return ByteStreams.toByteArray(paramInputStream);
    return ByteStreams.toByteArray(paramInputStream, (int)paramLong);
  }

  // ERROR //
  public static byte[] toByteArray(java.io.File paramFile)
    throws IOException
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore_2
    //   2: new 51	java/io/FileInputStream
    //   5: dup
    //   6: aload_0
    //   7: invokespecial 54	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   10: astore_0
    //   11: aload_0
    //   12: aload_0
    //   13: invokevirtual 58	java/io/FileInputStream:getChannel	()Ljava/nio/channels/FileChannel;
    //   16: invokevirtual 64	java/nio/channels/FileChannel:size	()J
    //   19: invokestatic 66	com/facebook/common/internal/Files:readFile	(Ljava/io/InputStream;J)[B
    //   22: astore_1
    //   23: aload_0
    //   24: ifnull +7 -> 31
    //   27: aload_0
    //   28: invokevirtual 69	java/io/FileInputStream:close	()V
    //   31: aload_1
    //   32: areturn
    //   33: astore_1
    //   34: aload_2
    //   35: astore_0
    //   36: aload_0
    //   37: ifnull +7 -> 44
    //   40: aload_0
    //   41: invokevirtual 69	java/io/FileInputStream:close	()V
    //   44: aload_1
    //   45: athrow
    //   46: astore_1
    //   47: goto -11 -> 36
    //
    // Exception table:
    //   from	to	target	type
    //   2	11	33	finally
    //   11	23	46	finally
  }
}

/* Location:           C:\Users\c_jealom1\Documents\Scripts\Android\Fathom_com.brynk.fathom\Fathom_com.brynk.fathom-dex2jar.jar
 * Qualified Name:     com.facebook.common.internal.Files
 * JD-Core Version:    0.6.0
 */
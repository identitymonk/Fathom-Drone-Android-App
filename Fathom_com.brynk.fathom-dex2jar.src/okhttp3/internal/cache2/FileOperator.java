package okhttp3.internal.cache2;

import java.io.EOFException;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import okio.Buffer;

final class FileOperator
{
  private static final int BUFFER_SIZE = 8192;
  private final byte[] byteArray = new byte[8192];
  private final ByteBuffer byteBuffer = ByteBuffer.wrap(this.byteArray);
  private final FileChannel fileChannel;

  public FileOperator(FileChannel paramFileChannel)
  {
    this.fileChannel = paramFileChannel;
  }

  public void read(long paramLong1, Buffer paramBuffer, long paramLong2)
    throws IOException
  {
    long l = paramLong1;
    paramLong1 = paramLong2;
    if (paramLong2 < 0L)
      throw new IndexOutOfBoundsException();
    try
    {
      while (true)
      {
        int i = this.byteBuffer.position();
        paramBuffer.write(this.byteArray, 0, i);
        l += i;
        paramLong1 -= i;
        this.byteBuffer.clear();
        if (paramLong1 <= 0L)
          break;
        this.byteBuffer.limit((int)Math.min(8192L, paramLong1));
        if (this.fileChannel.read(this.byteBuffer, l) != -1)
          continue;
        throw new EOFException();
      }
    }
    finally
    {
      this.byteBuffer.clear();
    }
  }

  public void write(long paramLong1, Buffer paramBuffer, long paramLong2)
    throws IOException
  {
    long l;
    if (paramLong2 >= 0L)
    {
      l = paramLong2;
      if (paramLong2 <= paramBuffer.size());
    }
    else
    {
      throw new IndexOutOfBoundsException();
    }
    while (l > 0L)
      try
      {
        int i = (int)Math.min(8192L, l);
        paramBuffer.read(this.byteArray, 0, i);
        this.byteBuffer.limit(i);
        paramLong2 = paramLong1;
        boolean bool;
        do
        {
          paramLong1 = paramLong2 + this.fileChannel.write(this.byteBuffer, paramLong2);
          bool = this.byteBuffer.hasRemaining();
          paramLong2 = paramLong1;
        }
        while (bool);
        l -= i;
        this.byteBuffer.clear();
        continue;
      }
      finally
      {
        this.byteBuffer.clear();
      }
  }
}

/* Location:           C:\Users\c_jealom1\Documents\Scripts\Android\Fathom_com.brynk.fathom\Fathom_com.brynk.fathom-dex2jar.jar
 * Qualified Name:     okhttp3.internal.cache2.FileOperator
 * JD-Core Version:    0.6.0
 */
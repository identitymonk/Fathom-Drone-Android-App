package okio;

import java.io.IOException;
import java.util.zip.CRC32;
import java.util.zip.Deflater;

public final class GzipSink
  implements Sink
{
  private boolean closed;
  private final CRC32 crc = new CRC32();
  private final Deflater deflater;
  private final DeflaterSink deflaterSink;
  private final BufferedSink sink;

  public GzipSink(Sink paramSink)
  {
    if (paramSink == null)
      throw new IllegalArgumentException("sink == null");
    this.deflater = new Deflater(-1, true);
    this.sink = Okio.buffer(paramSink);
    this.deflaterSink = new DeflaterSink(this.sink, this.deflater);
    writeHeader();
  }

  private void updateCrc(Buffer paramBuffer, long paramLong)
  {
    for (paramBuffer = paramBuffer.head; paramLong > 0L; paramBuffer = paramBuffer.next)
    {
      int i = (int)Math.min(paramLong, paramBuffer.limit - paramBuffer.pos);
      this.crc.update(paramBuffer.data, paramBuffer.pos, i);
      paramLong -= i;
    }
  }

  private void writeFooter()
    throws IOException
  {
    this.sink.writeIntLe((int)this.crc.getValue());
    this.sink.writeIntLe((int)this.deflater.getBytesRead());
  }

  private void writeHeader()
  {
    Buffer localBuffer = this.sink.buffer();
    localBuffer.writeShort(8075);
    localBuffer.writeByte(8);
    localBuffer.writeByte(0);
    localBuffer.writeInt(0);
    localBuffer.writeByte(0);
    localBuffer.writeByte(0);
  }

  public void close()
    throws IOException
  {
    if (this.closed);
    while (true)
    {
      return;
      Object localObject2 = null;
      try
      {
        this.deflaterSink.finishDeflate();
        writeFooter();
      }
      catch (Throwable localThrowable3)
      {
        try
        {
          this.deflater.end();
          localObject1 = localObject2;
        }
        catch (Throwable localThrowable3)
        {
          try
          {
            while (true)
            {
              this.sink.close();
              localObject2 = localObject1;
              this.closed = true;
              if (localObject2 == null)
                break;
              Util.sneakyRethrow(localObject2);
              return;
              localThrowable1 = localThrowable1;
              continue;
              localThrowable2 = localThrowable2;
              localObject1 = localThrowable1;
              if (localThrowable1 != null)
                continue;
              localObject1 = localThrowable2;
            }
          }
          catch (Throwable localThrowable3)
          {
            while (true)
            {
              Object localObject1;
              Object localObject3 = localObject1;
              if (localObject1 != null)
                continue;
              localObject3 = localThrowable3;
            }
          }
        }
      }
    }
  }

  public Deflater deflater()
  {
    return this.deflater;
  }

  public void flush()
    throws IOException
  {
    this.deflaterSink.flush();
  }

  public Timeout timeout()
  {
    return this.sink.timeout();
  }

  public void write(Buffer paramBuffer, long paramLong)
    throws IOException
  {
    if (paramLong < 0L)
      throw new IllegalArgumentException("byteCount < 0: " + paramLong);
    if (paramLong == 0L)
      return;
    updateCrc(paramBuffer, paramLong);
    this.deflaterSink.write(paramBuffer, paramLong);
  }
}

/* Location:           C:\Users\c_jealom1\Documents\Scripts\Android\Fathom_com.brynk.fathom\Fathom_com.brynk.fathom-dex2jar.jar
 * Qualified Name:     okio.GzipSink
 * JD-Core Version:    0.6.0
 */
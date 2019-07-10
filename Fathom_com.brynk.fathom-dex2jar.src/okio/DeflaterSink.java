package okio;

import java.io.IOException;
import java.util.zip.Deflater;
import org.codehaus.mojo.animal_sniffer.IgnoreJRERequirement;

public final class DeflaterSink
  implements Sink
{
  private boolean closed;
  private final Deflater deflater;
  private final BufferedSink sink;

  DeflaterSink(BufferedSink paramBufferedSink, Deflater paramDeflater)
  {
    if (paramBufferedSink == null)
      throw new IllegalArgumentException("source == null");
    if (paramDeflater == null)
      throw new IllegalArgumentException("inflater == null");
    this.sink = paramBufferedSink;
    this.deflater = paramDeflater;
  }

  public DeflaterSink(Sink paramSink, Deflater paramDeflater)
  {
    this(Okio.buffer(paramSink), paramDeflater);
  }

  @IgnoreJRERequirement
  private void deflate(boolean paramBoolean)
    throws IOException
  {
    Buffer localBuffer = this.sink.buffer();
    Segment localSegment;
    label119: 
    do
    {
      localSegment = localBuffer.writableSegment(1);
      if (paramBoolean);
      for (int i = this.deflater.deflate(localSegment.data, localSegment.limit, 8192 - localSegment.limit, 2); ; i = this.deflater.deflate(localSegment.data, localSegment.limit, 8192 - localSegment.limit))
      {
        if (i <= 0)
          break label119;
        localSegment.limit += i;
        localBuffer.size += i;
        this.sink.emitCompleteSegments();
        break;
      }
    }
    while (!this.deflater.needsInput());
    if (localSegment.pos == localSegment.limit)
    {
      localBuffer.head = localSegment.pop();
      SegmentPool.recycle(localSegment);
    }
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
        finishDeflate();
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

  void finishDeflate()
    throws IOException
  {
    this.deflater.finish();
    deflate(false);
  }

  public void flush()
    throws IOException
  {
    deflate(true);
    this.sink.flush();
  }

  public Timeout timeout()
  {
    return this.sink.timeout();
  }

  public String toString()
  {
    return "DeflaterSink(" + this.sink + ")";
  }

  public void write(Buffer paramBuffer, long paramLong)
    throws IOException
  {
    Util.checkOffsetAndCount(paramBuffer.size, 0L, paramLong);
    while (paramLong > 0L)
    {
      Segment localSegment = paramBuffer.head;
      int i = (int)Math.min(paramLong, localSegment.limit - localSegment.pos);
      this.deflater.setInput(localSegment.data, localSegment.pos, i);
      deflate(false);
      paramBuffer.size -= i;
      localSegment.pos += i;
      if (localSegment.pos == localSegment.limit)
      {
        paramBuffer.head = localSegment.pop();
        SegmentPool.recycle(localSegment);
      }
      paramLong -= i;
    }
  }
}

/* Location:           C:\Users\c_jealom1\Documents\Scripts\Android\Fathom_com.brynk.fathom\Fathom_com.brynk.fathom-dex2jar.jar
 * Qualified Name:     okio.DeflaterSink
 * JD-Core Version:    0.6.0
 */
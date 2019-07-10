package okhttp3.internal.ws;

import java.io.IOException;
import java.util.Random;
import okio.Buffer;
import okio.BufferedSink;
import okio.ByteString;
import okio.Sink;
import okio.Timeout;

final class WebSocketWriter
{
  boolean activeWriter;
  final Buffer buffer = new Buffer();
  final FrameSink frameSink = new FrameSink();
  final boolean isClient;
  final byte[] maskBuffer;
  final byte[] maskKey;
  final Random random;
  final BufferedSink sink;
  boolean writerClosed;

  static
  {
    if (!WebSocketWriter.class.desiredAssertionStatus());
    for (boolean bool = true; ; bool = false)
    {
      $assertionsDisabled = bool;
      return;
    }
  }

  WebSocketWriter(boolean paramBoolean, BufferedSink paramBufferedSink, Random paramRandom)
  {
    if (paramBufferedSink == null)
      throw new NullPointerException("sink == null");
    if (paramRandom == null)
      throw new NullPointerException("random == null");
    this.isClient = paramBoolean;
    this.sink = paramBufferedSink;
    this.random = paramRandom;
    if (paramBoolean);
    for (paramBufferedSink = new byte[4]; ; paramBufferedSink = null)
    {
      this.maskKey = paramBufferedSink;
      paramBufferedSink = localObject;
      if (paramBoolean)
        paramBufferedSink = new byte[8192];
      this.maskBuffer = paramBufferedSink;
      return;
    }
  }

  private void writeControlFrameSynchronized(int paramInt, ByteString paramByteString)
    throws IOException
  {
    assert (Thread.holdsLock(this));
    if (this.writerClosed)
      throw new IOException("closed");
    int i = paramByteString.size();
    if (i > 125L)
      throw new IllegalArgumentException("Payload size must be less than or equal to 125");
    this.sink.writeByte(paramInt | 0x80);
    if (this.isClient)
    {
      this.sink.writeByte(i | 0x80);
      this.random.nextBytes(this.maskKey);
      this.sink.write(this.maskKey);
      paramByteString = paramByteString.toByteArray();
      WebSocketProtocol.toggleMask(paramByteString, paramByteString.length, this.maskKey, 0L);
      this.sink.write(paramByteString);
    }
    while (true)
    {
      this.sink.flush();
      return;
      this.sink.writeByte(i);
      this.sink.write(paramByteString);
    }
  }

  Sink newMessageSink(int paramInt, long paramLong)
  {
    if (this.activeWriter)
      throw new IllegalStateException("Another message writer is active. Did you call close()?");
    this.activeWriter = true;
    this.frameSink.formatOpcode = paramInt;
    this.frameSink.contentLength = paramLong;
    this.frameSink.isFirstFrame = true;
    this.frameSink.closed = false;
    return this.frameSink;
  }

  // ERROR //
  void writeClose(int paramInt, ByteString paramByteString)
    throws IOException
  {
    // Byte code:
    //   0: getstatic 158	okio/ByteString:EMPTY	Lokio/ByteString;
    //   3: astore_3
    //   4: iload_1
    //   5: ifne +7 -> 12
    //   8: aload_2
    //   9: ifnull +40 -> 49
    //   12: iload_1
    //   13: ifeq +7 -> 20
    //   16: iload_1
    //   17: invokestatic 162	okhttp3/internal/ws/WebSocketProtocol:validateCloseCode	(I)V
    //   20: new 40	okio/Buffer
    //   23: dup
    //   24: invokespecial 41	okio/Buffer:<init>	()V
    //   27: astore_3
    //   28: aload_3
    //   29: iload_1
    //   30: invokevirtual 166	okio/Buffer:writeShort	(I)Lokio/Buffer;
    //   33: pop
    //   34: aload_2
    //   35: ifnull +9 -> 44
    //   38: aload_3
    //   39: aload_2
    //   40: invokevirtual 169	okio/Buffer:write	(Lokio/ByteString;)Lokio/Buffer;
    //   43: pop
    //   44: aload_3
    //   45: invokevirtual 173	okio/Buffer:readByteString	()Lokio/ByteString;
    //   48: astore_3
    //   49: aload_0
    //   50: monitorenter
    //   51: aload_0
    //   52: bipush 8
    //   54: aload_3
    //   55: invokespecial 175	okhttp3/internal/ws/WebSocketWriter:writeControlFrameSynchronized	(ILokio/ByteString;)V
    //   58: aload_0
    //   59: iconst_1
    //   60: putfield 82	okhttp3/internal/ws/WebSocketWriter:writerClosed	Z
    //   63: aload_0
    //   64: monitorexit
    //   65: return
    //   66: astore_2
    //   67: aload_0
    //   68: iconst_1
    //   69: putfield 82	okhttp3/internal/ws/WebSocketWriter:writerClosed	Z
    //   72: aload_2
    //   73: athrow
    //   74: astore_2
    //   75: aload_0
    //   76: monitorexit
    //   77: aload_2
    //   78: athrow
    //
    // Exception table:
    //   from	to	target	type
    //   51	58	66	finally
    //   58	65	74	finally
    //   67	74	74	finally
    //   75	77	74	finally
  }

  void writeMessageFrameSynchronized(int paramInt, long paramLong, boolean paramBoolean1, boolean paramBoolean2)
    throws IOException
  {
    assert (Thread.holdsLock(this));
    if (this.writerClosed)
      throw new IOException("closed");
    label111: long l;
    if (paramBoolean1)
    {
      int i = paramInt;
      if (paramBoolean2)
        i = paramInt | 0x80;
      this.sink.writeByte(i);
      paramInt = 0;
      if (this.isClient)
        paramInt = 0x0 | 0x80;
      if (paramLong > 125L)
        break label197;
      i = (int)paramLong;
      this.sink.writeByte(paramInt | i);
      if (!this.isClient)
        break label303;
      this.random.nextBytes(this.maskKey);
      this.sink.write(this.maskKey);
      l = 0L;
    }
    while (true)
    {
      if (l >= paramLong)
        break label317;
      paramInt = (int)Math.min(paramLong, this.maskBuffer.length);
      paramInt = this.buffer.read(this.maskBuffer, 0, paramInt);
      if (paramInt == -1)
      {
        throw new AssertionError();
        paramInt = 0;
        break;
        label197: if (paramLong <= 65535L)
        {
          this.sink.writeByte(paramInt | 0x7E);
          this.sink.writeShort((int)paramLong);
          break label111;
        }
        this.sink.writeByte(paramInt | 0x7F);
        this.sink.writeLong(paramLong);
        break label111;
      }
      WebSocketProtocol.toggleMask(this.maskBuffer, paramInt, this.maskKey, l);
      this.sink.write(this.maskBuffer, 0, paramInt);
      l += paramInt;
    }
    label303: this.sink.write(this.buffer, paramLong);
    label317: this.sink.emit();
  }

  void writePing(ByteString paramByteString)
    throws IOException
  {
    monitorenter;
    try
    {
      writeControlFrameSynchronized(9, paramByteString);
      return;
    }
    finally
    {
      monitorexit;
    }
    throw paramByteString;
  }

  void writePong(ByteString paramByteString)
    throws IOException
  {
    monitorenter;
    try
    {
      writeControlFrameSynchronized(10, paramByteString);
      return;
    }
    finally
    {
      monitorexit;
    }
    throw paramByteString;
  }

  final class FrameSink
    implements Sink
  {
    boolean closed;
    long contentLength;
    int formatOpcode;
    boolean isFirstFrame;

    FrameSink()
    {
    }

    public void close()
      throws IOException
    {
      if (this.closed)
        throw new IOException("closed");
      synchronized (WebSocketWriter.this)
      {
        WebSocketWriter.this.writeMessageFrameSynchronized(this.formatOpcode, WebSocketWriter.this.buffer.size(), this.isFirstFrame, true);
        this.closed = true;
        WebSocketWriter.this.activeWriter = false;
        return;
      }
    }

    public void flush()
      throws IOException
    {
      if (this.closed)
        throw new IOException("closed");
      synchronized (WebSocketWriter.this)
      {
        WebSocketWriter.this.writeMessageFrameSynchronized(this.formatOpcode, WebSocketWriter.this.buffer.size(), this.isFirstFrame, false);
        this.isFirstFrame = false;
        return;
      }
    }

    public Timeout timeout()
    {
      return WebSocketWriter.this.sink.timeout();
    }

    public void write(Buffer arg1, long paramLong)
      throws IOException
    {
      if (this.closed)
        throw new IOException("closed");
      WebSocketWriter.this.buffer.write(???, paramLong);
      int i;
      if ((this.isFirstFrame) && (this.contentLength != -1L) && (WebSocketWriter.this.buffer.size() > this.contentLength - 8192L))
        i = 1;
      while (true)
      {
        paramLong = WebSocketWriter.this.buffer.completeSegmentByteCount();
        if ((paramLong > 0L) && (i == 0));
        synchronized (WebSocketWriter.this)
        {
          WebSocketWriter.this.writeMessageFrameSynchronized(this.formatOpcode, paramLong, this.isFirstFrame, false);
          this.isFirstFrame = false;
          return;
          i = 0;
        }
      }
    }
  }
}

/* Location:           C:\Users\c_jealom1\Documents\Scripts\Android\Fathom_com.brynk.fathom\Fathom_com.brynk.fathom-dex2jar.jar
 * Qualified Name:     okhttp3.internal.ws.WebSocketWriter
 * JD-Core Version:    0.6.0
 */
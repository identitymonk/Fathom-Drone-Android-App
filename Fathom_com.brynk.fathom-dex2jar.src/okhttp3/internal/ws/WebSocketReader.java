package okhttp3.internal.ws;

import java.io.EOFException;
import java.io.IOException;
import java.net.ProtocolException;
import java.util.concurrent.TimeUnit;
import okio.Buffer;
import okio.BufferedSource;
import okio.ByteString;
import okio.Timeout;

final class WebSocketReader
{
  boolean closed;
  long frameBytesRead;
  final FrameCallback frameCallback;
  long frameLength;
  final boolean isClient;
  boolean isControlFrame;
  boolean isFinalFrame;
  boolean isMasked;
  final byte[] maskBuffer = new byte[8192];
  final byte[] maskKey = new byte[4];
  int opcode;
  final BufferedSource source;

  WebSocketReader(boolean paramBoolean, BufferedSource paramBufferedSource, FrameCallback paramFrameCallback)
  {
    if (paramBufferedSource == null)
      throw new NullPointerException("source == null");
    if (paramFrameCallback == null)
      throw new NullPointerException("frameCallback == null");
    this.isClient = paramBoolean;
    this.source = paramBufferedSource;
    this.frameCallback = paramFrameCallback;
  }

  private void readControlFrame()
    throws IOException
  {
    Object localObject = new Buffer();
    if (this.frameBytesRead < this.frameLength)
    {
      if (!this.isClient)
        break label145;
      this.source.readFully((Buffer)localObject, this.frameLength);
    }
    switch (this.opcode)
    {
    default:
      throw new ProtocolException("Unknown control opcode: " + Integer.toHexString(this.opcode));
      do
      {
        int i;
        WebSocketProtocol.toggleMask(this.maskBuffer, i, this.maskKey, this.frameBytesRead);
        ((Buffer)localObject).write(this.maskBuffer, 0, i);
        this.frameBytesRead += i;
        if (this.frameBytesRead >= this.frameLength)
          break;
        j = (int)Math.min(this.frameLength - this.frameBytesRead, this.maskBuffer.length);
        j = this.source.read(this.maskBuffer, 0, j);
      }
      while (j != -1);
      throw new EOFException();
    case 9:
      this.frameCallback.onReadPing(((Buffer)localObject).readByteString());
      return;
    case 10:
      label145: this.frameCallback.onReadPong(((Buffer)localObject).readByteString());
      return;
    case 8:
    }
    int j = 1005;
    String str = "";
    long l = ((Buffer)localObject).size();
    if (l == 1L)
      throw new ProtocolException("Malformed close payload length of 1.");
    if (l != 0L)
    {
      j = ((Buffer)localObject).readShort();
      str = ((Buffer)localObject).readUtf8();
      localObject = WebSocketProtocol.closeCodeExceptionMessage(j);
      if (localObject != null)
        throw new ProtocolException((String)localObject);
    }
    this.frameCallback.onReadClose(j, str);
    this.closed = true;
  }

  private void readHeader()
    throws IOException
  {
    boolean bool2 = true;
    if (this.closed)
      throw new IOException("closed");
    long l = this.source.timeout().timeoutNanos();
    this.source.timeout().clearTimeout();
    boolean bool1;
    while (true)
    {
      try
      {
        i = this.source.readByte();
        k = i & 0xFF;
        this.source.timeout().timeout(l, TimeUnit.NANOSECONDS);
        this.opcode = (k & 0xF);
        if ((k & 0x80) != 0)
        {
          bool1 = true;
          this.isFinalFrame = bool1;
          if ((k & 0x8) == 0)
            break label175;
          bool1 = true;
          this.isControlFrame = bool1;
          if ((!this.isControlFrame) || (this.isFinalFrame))
            break;
          throw new ProtocolException("Control frames must be final.");
        }
      }
      finally
      {
        this.source.timeout().timeout(l, TimeUnit.NANOSECONDS);
      }
      bool1 = false;
      continue;
      label175: bool1 = false;
    }
    int j;
    if ((k & 0x40) != 0)
    {
      i = 1;
      if ((k & 0x20) == 0)
        break label235;
      j = 1;
      label199: if ((k & 0x10) == 0)
        break label240;
    }
    label235: label240: for (int k = 1; ; k = 0)
    {
      if ((i == 0) && (j == 0) && (k == 0))
        break label245;
      throw new ProtocolException("Reserved flags are unsupported.");
      i = 0;
      break;
      j = 0;
      break label199;
    }
    label245: int i = this.source.readByte() & 0xFF;
    if ((i & 0x80) != 0)
    {
      bool1 = bool2;
      this.isMasked = bool1;
      if (this.isMasked != this.isClient)
        break label322;
      if (!this.isClient)
        break label315;
    }
    label315: for (String str = "Server-sent frames must not be masked."; ; str = "Client-sent frames must be masked.")
    {
      throw new ProtocolException(str);
      bool1 = false;
      break;
    }
    label322: this.frameLength = (i & 0x7F);
    if (this.frameLength == 126L)
      this.frameLength = (this.source.readShort() & 0xFFFF);
    while (true)
    {
      this.frameBytesRead = 0L;
      if ((!this.isControlFrame) || (this.frameLength <= 125L))
        break;
      throw new ProtocolException("Control frame must be less than 125B.");
      if (this.frameLength != 127L)
        continue;
      this.frameLength = this.source.readLong();
      if (this.frameLength >= 0L)
        continue;
      throw new ProtocolException("Frame length 0x" + Long.toHexString(this.frameLength) + " > 0x7FFFFFFFFFFFFFFF");
    }
    if (this.isMasked)
      this.source.readFully(this.maskKey);
  }

  private void readMessage(Buffer paramBuffer)
    throws IOException
  {
    if (this.closed)
      throw new IOException("closed");
    if (this.frameBytesRead == this.frameLength)
    {
      if (this.isFinalFrame);
      do
      {
        return;
        readUntilNonControlFrame();
        if (this.opcode == 0)
          continue;
        throw new ProtocolException("Expected continuation opcode. Got: " + Integer.toHexString(this.opcode));
      }
      while ((this.isFinalFrame) && (this.frameLength == 0L));
    }
    long l1 = this.frameLength - this.frameBytesRead;
    if (this.isMasked)
    {
      l1 = Math.min(l1, this.maskBuffer.length);
      l1 = this.source.read(this.maskBuffer, 0, (int)l1);
      if (l1 == -1L)
        throw new EOFException();
      WebSocketProtocol.toggleMask(this.maskBuffer, l1, this.maskKey, this.frameBytesRead);
      paramBuffer.write(this.maskBuffer, 0, (int)l1);
    }
    long l2;
    do
    {
      this.frameBytesRead += l1;
      break;
      l2 = this.source.read(paramBuffer, l1);
      l1 = l2;
    }
    while (l2 != -1L);
    throw new EOFException();
  }

  private void readMessageFrame()
    throws IOException
  {
    int i = this.opcode;
    if ((i != 1) && (i != 2))
      throw new ProtocolException("Unknown opcode: " + Integer.toHexString(i));
    Buffer localBuffer = new Buffer();
    readMessage(localBuffer);
    if (i == 1)
    {
      this.frameCallback.onReadMessage(localBuffer.readUtf8());
      return;
    }
    this.frameCallback.onReadMessage(localBuffer.readByteString());
  }

  void processNextFrame()
    throws IOException
  {
    readHeader();
    if (this.isControlFrame)
    {
      readControlFrame();
      return;
    }
    readMessageFrame();
  }

  void readUntilNonControlFrame()
    throws IOException
  {
    while (true)
    {
      if (!this.closed)
      {
        readHeader();
        if (this.isControlFrame);
      }
      else
      {
        return;
      }
      readControlFrame();
    }
  }

  public static abstract interface FrameCallback
  {
    public abstract void onReadClose(int paramInt, String paramString);

    public abstract void onReadMessage(String paramString)
      throws IOException;

    public abstract void onReadMessage(ByteString paramByteString)
      throws IOException;

    public abstract void onReadPing(ByteString paramByteString);

    public abstract void onReadPong(ByteString paramByteString);
  }
}

/* Location:           C:\Users\c_jealom1\Documents\Scripts\Android\Fathom_com.brynk.fathom\Fathom_com.brynk.fathom-dex2jar.jar
 * Qualified Name:     okhttp3.internal.ws.WebSocketReader
 * JD-Core Version:    0.6.0
 */
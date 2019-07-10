package org.java_websocket;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.ByteChannel;
import java.nio.channels.SocketChannel;
import javax.net.ssl.SSLException;

public class AbstractWrappedByteChannel
  implements WrappedByteChannel
{
  private final ByteChannel channel;

  public AbstractWrappedByteChannel(ByteChannel paramByteChannel)
  {
    this.channel = paramByteChannel;
  }

  public AbstractWrappedByteChannel(WrappedByteChannel paramWrappedByteChannel)
  {
    this.channel = paramWrappedByteChannel;
  }

  public void close()
    throws IOException
  {
    this.channel.close();
  }

  public boolean isBlocking()
  {
    if ((this.channel instanceof SocketChannel))
      return ((SocketChannel)this.channel).isBlocking();
    if ((this.channel instanceof WrappedByteChannel))
      return ((WrappedByteChannel)this.channel).isBlocking();
    return false;
  }

  public boolean isNeedRead()
  {
    if ((this.channel instanceof WrappedByteChannel))
      return ((WrappedByteChannel)this.channel).isNeedRead();
    return false;
  }

  public boolean isNeedWrite()
  {
    if ((this.channel instanceof WrappedByteChannel))
      return ((WrappedByteChannel)this.channel).isNeedWrite();
    return false;
  }

  public boolean isOpen()
  {
    return this.channel.isOpen();
  }

  public int read(ByteBuffer paramByteBuffer)
    throws IOException
  {
    return this.channel.read(paramByteBuffer);
  }

  public int readMore(ByteBuffer paramByteBuffer)
    throws SSLException
  {
    if ((this.channel instanceof WrappedByteChannel))
      return ((WrappedByteChannel)this.channel).readMore(paramByteBuffer);
    return 0;
  }

  public int write(ByteBuffer paramByteBuffer)
    throws IOException
  {
    return this.channel.write(paramByteBuffer);
  }

  public void writeMore()
    throws IOException
  {
    if ((this.channel instanceof WrappedByteChannel))
      ((WrappedByteChannel)this.channel).writeMore();
  }
}

/* Location:           C:\Users\c_jealom1\Documents\Scripts\Android\Fathom_com.brynk.fathom\Fathom_com.brynk.fathom-dex2jar.jar
 * Qualified Name:     org.java_websocket.AbstractWrappedByteChannel
 * JD-Core Version:    0.6.0
 */
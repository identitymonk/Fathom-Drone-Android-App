package org.java_websocket;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.ByteChannel;
import java.nio.channels.spi.AbstractSelectableChannel;
import java.util.concurrent.BlockingQueue;

public class SocketChannelIOHelper
{
  static
  {
    if (!SocketChannelIOHelper.class.desiredAssertionStatus());
    for (boolean bool = true; ; bool = false)
    {
      $assertionsDisabled = bool;
      return;
    }
  }

  public static boolean batch(WebSocketImpl paramWebSocketImpl, ByteChannel paramByteChannel)
    throws IOException
  {
    ByteBuffer localByteBuffer = (ByteBuffer)paramWebSocketImpl.outQueue.peek();
    WrappedByteChannel localWrappedByteChannel = null;
    Object localObject = localByteBuffer;
    if (localByteBuffer == null)
    {
      localObject = localWrappedByteChannel;
      if ((paramByteChannel instanceof WrappedByteChannel))
      {
        localWrappedByteChannel = (WrappedByteChannel)paramByteChannel;
        localObject = localWrappedByteChannel;
        if (localWrappedByteChannel.isNeedWrite())
        {
          localWrappedByteChannel.writeMore();
          localObject = localWrappedByteChannel;
        }
      }
    }
    while (true)
    {
      if ((paramWebSocketImpl.outQueue.isEmpty()) && (paramWebSocketImpl.isFlushAndClose()))
        monitorenter;
      try
      {
        paramWebSocketImpl.closeConnection();
        monitorexit;
        if ((localObject != null) && (((WrappedByteChannel)paramByteChannel).isNeedWrite()))
          break;
        return true;
        do
        {
          paramByteChannel.write((ByteBuffer)localObject);
          if (((ByteBuffer)localObject).remaining() > 0)
            return false;
          paramWebSocketImpl.outQueue.poll();
          localByteBuffer = (ByteBuffer)paramWebSocketImpl.outQueue.peek();
          localObject = localByteBuffer;
        }
        while (localByteBuffer != null);
        localObject = localWrappedByteChannel;
        continue;
      }
      finally
      {
        monitorexit;
      }
    }
    return false;
  }

  public static boolean read(ByteBuffer paramByteBuffer, WebSocketImpl paramWebSocketImpl, ByteChannel paramByteChannel)
    throws IOException
  {
    paramByteBuffer.clear();
    int i = paramByteChannel.read(paramByteBuffer);
    paramByteBuffer.flip();
    if (i == -1)
      paramWebSocketImpl.eot();
    do
      return false;
    while (i == 0);
    return true;
  }

  public static boolean readMore(ByteBuffer paramByteBuffer, WebSocketImpl paramWebSocketImpl, WrappedByteChannel paramWrappedByteChannel)
    throws IOException
  {
    paramByteBuffer.clear();
    int i = paramWrappedByteChannel.readMore(paramByteBuffer);
    paramByteBuffer.flip();
    if (i == -1)
    {
      paramWebSocketImpl.eot();
      return false;
    }
    return paramWrappedByteChannel.isNeedRead();
  }

  public static void writeBlocking(WebSocketImpl paramWebSocketImpl, ByteChannel paramByteChannel)
    throws InterruptedException, IOException
  {
    if (($assertionsDisabled) || (paramByteChannel instanceof AbstractSelectableChannel != true) || (((AbstractSelectableChannel)paramByteChannel).isBlocking()))
    {
      if ((!$assertionsDisabled) && (paramByteChannel instanceof WrappedByteChannel == true) && (!((WrappedByteChannel)paramByteChannel).isBlocking()))
        break label89;
      paramWebSocketImpl = (ByteBuffer)paramWebSocketImpl.outQueue.take();
    }
    while (paramWebSocketImpl.hasRemaining())
    {
      paramByteChannel.write(paramWebSocketImpl);
      continue;
      throw new AssertionError();
      label89: throw new AssertionError();
    }
  }
}

/* Location:           C:\Users\c_jealom1\Documents\Scripts\Android\Fathom_com.brynk.fathom\Fathom_com.brynk.fathom-dex2jar.jar
 * Qualified Name:     org.java_websocket.SocketChannelIOHelper
 * JD-Core Version:    0.6.0
 */
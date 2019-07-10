package org.java_websocket.client;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.ByteChannel;
import org.java_websocket.AbstractWrappedByteChannel;

public abstract class AbstractClientProxyChannel extends AbstractWrappedByteChannel
{
  protected final ByteBuffer proxyHandshake;

  public AbstractClientProxyChannel(ByteChannel paramByteChannel)
  {
    super(paramByteChannel);
    try
    {
      this.proxyHandshake = ByteBuffer.wrap(buildHandShake().getBytes("ASCII"));
      return;
    }
    catch (java.io.UnsupportedEncodingException paramByteChannel)
    {
    }
    throw new RuntimeException(paramByteChannel);
  }

  public abstract String buildHandShake();

  public int write(ByteBuffer paramByteBuffer)
    throws IOException
  {
    if (!this.proxyHandshake.hasRemaining())
      return super.write(paramByteBuffer);
    return super.write(this.proxyHandshake);
  }
}

/* Location:           C:\Users\c_jealom1\Documents\Scripts\Android\Fathom_com.brynk.fathom\Fathom_com.brynk.fathom-dex2jar.jar
 * Qualified Name:     org.java_websocket.client.AbstractClientProxyChannel
 * JD-Core Version:    0.6.0
 */
package org.java_websocket;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.ByteChannel;
import javax.net.ssl.SSLException;

public abstract interface WrappedByteChannel extends ByteChannel
{
  public abstract boolean isBlocking();

  public abstract boolean isNeedRead();

  public abstract boolean isNeedWrite();

  public abstract int readMore(ByteBuffer paramByteBuffer)
    throws SSLException;

  public abstract void writeMore()
    throws IOException;
}

/* Location:           C:\Users\c_jealom1\Documents\Scripts\Android\Fathom_com.brynk.fathom\Fathom_com.brynk.fathom-dex2jar.jar
 * Qualified Name:     org.java_websocket.WrappedByteChannel
 * JD-Core Version:    0.6.0
 */
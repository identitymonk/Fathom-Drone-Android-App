package org.java_websocket;

import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.NotYetConnectedException;
import org.java_websocket.drafts.Draft;
import org.java_websocket.framing.Framedata;

public abstract interface WebSocket
{
  public static final int DEFAULT_PORT = 80;
  public static final int DEFAULT_WSS_PORT = 443;

  public abstract void close();

  public abstract void close(int paramInt);

  public abstract void close(int paramInt, String paramString);

  public abstract void closeConnection(int paramInt, String paramString);

  public abstract Draft getDraft();

  public abstract InetSocketAddress getLocalSocketAddress();

  public abstract READYSTATE getReadyState();

  public abstract InetSocketAddress getRemoteSocketAddress();

  public abstract boolean hasBufferedData();

  public abstract boolean isClosed();

  public abstract boolean isClosing();

  public abstract boolean isConnecting();

  public abstract boolean isFlushAndClose();

  public abstract boolean isOpen();

  public abstract void send(String paramString)
    throws NotYetConnectedException;

  public abstract void send(ByteBuffer paramByteBuffer)
    throws IllegalArgumentException, NotYetConnectedException;

  public abstract void send(byte[] paramArrayOfByte)
    throws IllegalArgumentException, NotYetConnectedException;

  public abstract void sendFrame(Framedata paramFramedata);

  public static enum READYSTATE
  {
    static
    {
      CONNECTING = new READYSTATE("CONNECTING", 1);
      OPEN = new READYSTATE("OPEN", 2);
      CLOSING = new READYSTATE("CLOSING", 3);
      CLOSED = new READYSTATE("CLOSED", 4);
      $VALUES = new READYSTATE[] { NOT_YET_CONNECTED, CONNECTING, OPEN, CLOSING, CLOSED };
    }
  }

  public static enum Role
  {
    static
    {
      $VALUES = new Role[] { CLIENT, SERVER };
    }
  }
}

/* Location:           C:\Users\c_jealom1\Documents\Scripts\Android\Fathom_com.brynk.fathom\Fathom_com.brynk.fathom-dex2jar.jar
 * Qualified Name:     org.java_websocket.WebSocket
 * JD-Core Version:    0.6.0
 */
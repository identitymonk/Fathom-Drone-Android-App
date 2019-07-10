package org.java_websocket.framing;

import java.nio.ByteBuffer;
import org.java_websocket.exceptions.InvalidFrameException;

public abstract interface Framedata
{
  public abstract void append(Framedata paramFramedata)
    throws InvalidFrameException;

  public abstract Opcode getOpcode();

  public abstract ByteBuffer getPayloadData();

  public abstract boolean getTransfereMasked();

  public abstract boolean isFin();

  public static enum Opcode
  {
    static
    {
      BINARY = new Opcode("BINARY", 2);
      PING = new Opcode("PING", 3);
      PONG = new Opcode("PONG", 4);
      CLOSING = new Opcode("CLOSING", 5);
      $VALUES = new Opcode[] { CONTINUOUS, TEXT, BINARY, PING, PONG, CLOSING };
    }
  }
}

/* Location:           C:\Users\c_jealom1\Documents\Scripts\Android\Fathom_com.brynk.fathom\Fathom_com.brynk.fathom-dex2jar.jar
 * Qualified Name:     org.java_websocket.framing.Framedata
 * JD-Core Version:    0.6.0
 */
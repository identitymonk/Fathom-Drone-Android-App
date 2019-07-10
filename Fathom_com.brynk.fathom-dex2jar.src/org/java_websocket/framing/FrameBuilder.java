package org.java_websocket.framing;

import java.nio.ByteBuffer;
import org.java_websocket.exceptions.InvalidDataException;

public abstract interface FrameBuilder extends Framedata
{
  public abstract void setFin(boolean paramBoolean);

  public abstract void setOptcode(Framedata.Opcode paramOpcode);

  public abstract void setPayload(ByteBuffer paramByteBuffer)
    throws InvalidDataException;

  public abstract void setTransferemasked(boolean paramBoolean);
}

/* Location:           C:\Users\c_jealom1\Documents\Scripts\Android\Fathom_com.brynk.fathom\Fathom_com.brynk.fathom-dex2jar.jar
 * Qualified Name:     org.java_websocket.framing.FrameBuilder
 * JD-Core Version:    0.6.0
 */
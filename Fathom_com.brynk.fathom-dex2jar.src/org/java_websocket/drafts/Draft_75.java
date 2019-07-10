package org.java_websocket.drafts;

import java.nio.ByteBuffer;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;
import org.java_websocket.exceptions.InvalidDataException;
import org.java_websocket.exceptions.InvalidHandshakeException;
import org.java_websocket.exceptions.NotSendableException;
import org.java_websocket.framing.FrameBuilder;
import org.java_websocket.framing.Framedata;
import org.java_websocket.framing.Framedata.Opcode;
import org.java_websocket.framing.FramedataImpl1;
import org.java_websocket.handshake.ClientHandshake;
import org.java_websocket.handshake.ClientHandshakeBuilder;
import org.java_websocket.handshake.HandshakeBuilder;
import org.java_websocket.handshake.ServerHandshake;
import org.java_websocket.handshake.ServerHandshakeBuilder;
import org.java_websocket.util.Charsetfunctions;

public class Draft_75 extends Draft
{
  public static final byte CR = 13;
  public static final byte END_OF_FRAME = -1;
  public static final byte LF = 10;
  public static final byte START_OF_FRAME = 0;
  protected ByteBuffer currentFrame;
  private boolean inframe = false;
  protected boolean readingState = false;
  protected List<Framedata> readyframes = new LinkedList();
  private final Random reuseableRandom = new Random();

  public Draft.HandshakeState acceptHandshakeAsClient(ClientHandshake paramClientHandshake, ServerHandshake paramServerHandshake)
  {
    if ((paramClientHandshake.getFieldValue("WebSocket-Origin").equals(paramServerHandshake.getFieldValue("Origin"))) && (basicAccept(paramServerHandshake)))
      return Draft.HandshakeState.MATCHED;
    return Draft.HandshakeState.NOT_MATCHED;
  }

  public Draft.HandshakeState acceptHandshakeAsServer(ClientHandshake paramClientHandshake)
  {
    if ((paramClientHandshake.hasFieldValue("Origin")) && (basicAccept(paramClientHandshake)))
      return Draft.HandshakeState.MATCHED;
    return Draft.HandshakeState.NOT_MATCHED;
  }

  public Draft copyInstance()
  {
    return new Draft_75();
  }

  public ByteBuffer createBinaryFrame(Framedata paramFramedata)
  {
    if (paramFramedata.getOpcode() != Framedata.Opcode.TEXT)
      throw new RuntimeException("only text frames supported");
    paramFramedata = paramFramedata.getPayloadData();
    ByteBuffer localByteBuffer = ByteBuffer.allocate(paramFramedata.remaining() + 2);
    localByteBuffer.put(0);
    paramFramedata.mark();
    localByteBuffer.put(paramFramedata);
    paramFramedata.reset();
    localByteBuffer.put(-1);
    localByteBuffer.flip();
    return localByteBuffer;
  }

  public ByteBuffer createBuffer()
  {
    return ByteBuffer.allocate(INITIAL_FAMESIZE);
  }

  public List<Framedata> createFrames(String paramString, boolean paramBoolean)
  {
    FramedataImpl1 localFramedataImpl1 = new FramedataImpl1();
    try
    {
      localFramedataImpl1.setPayload(ByteBuffer.wrap(Charsetfunctions.utf8Bytes(paramString)));
      localFramedataImpl1.setFin(true);
      localFramedataImpl1.setOptcode(Framedata.Opcode.TEXT);
      localFramedataImpl1.setTransferemasked(paramBoolean);
      return Collections.singletonList(localFramedataImpl1);
    }
    catch (InvalidDataException paramString)
    {
    }
    throw new NotSendableException(paramString);
  }

  public List<Framedata> createFrames(ByteBuffer paramByteBuffer, boolean paramBoolean)
  {
    throw new RuntimeException("not yet implemented");
  }

  public Draft.CloseHandshakeType getCloseHandshakeType()
  {
    return Draft.CloseHandshakeType.NONE;
  }

  public ByteBuffer increaseBuffer(ByteBuffer paramByteBuffer)
  {
    paramByteBuffer.flip();
    ByteBuffer localByteBuffer = ByteBuffer.allocate(paramByteBuffer.capacity() * 2);
    localByteBuffer.put(paramByteBuffer);
    return localByteBuffer;
  }

  public ClientHandshakeBuilder postProcessHandshakeRequestAsClient(ClientHandshakeBuilder paramClientHandshakeBuilder)
    throws InvalidHandshakeException
  {
    paramClientHandshakeBuilder.put("Upgrade", "WebSocket");
    paramClientHandshakeBuilder.put("Connection", "Upgrade");
    if (!paramClientHandshakeBuilder.hasFieldValue("Origin"))
      paramClientHandshakeBuilder.put("Origin", "random" + this.reuseableRandom.nextInt());
    return paramClientHandshakeBuilder;
  }

  public HandshakeBuilder postProcessHandshakeResponseAsServer(ClientHandshake paramClientHandshake, ServerHandshakeBuilder paramServerHandshakeBuilder)
    throws InvalidHandshakeException
  {
    paramServerHandshakeBuilder.setHttpStatusMessage("Web Socket Protocol Handshake");
    paramServerHandshakeBuilder.put("Upgrade", "WebSocket");
    paramServerHandshakeBuilder.put("Connection", paramClientHandshake.getFieldValue("Connection"));
    paramServerHandshakeBuilder.put("WebSocket-Origin", paramClientHandshake.getFieldValue("Origin"));
    paramServerHandshakeBuilder.put("WebSocket-Location", "ws://" + paramClientHandshake.getFieldValue("Host") + paramClientHandshake.getResourceDescriptor());
    return paramServerHandshakeBuilder;
  }

  public void reset()
  {
    this.readingState = false;
    this.currentFrame = null;
  }

  public List<Framedata> translateFrame(ByteBuffer paramByteBuffer)
    throws InvalidDataException
  {
    paramByteBuffer = translateRegularFrame(paramByteBuffer);
    if (paramByteBuffer == null)
      throw new InvalidDataException(1002);
    return paramByteBuffer;
  }

  protected List<Framedata> translateRegularFrame(ByteBuffer paramByteBuffer)
    throws InvalidDataException
  {
    Object localObject;
    while (paramByteBuffer.hasRemaining())
    {
      byte b = paramByteBuffer.get();
      if (b == 0)
      {
        if (this.readingState)
          return null;
        this.readingState = true;
        continue;
      }
      if (b == -1)
      {
        if (!this.readingState)
          return null;
        FramedataImpl1 localFramedataImpl1;
        if (this.currentFrame != null)
        {
          this.currentFrame.flip();
          localFramedataImpl1 = new FramedataImpl1();
          localFramedataImpl1.setPayload(this.currentFrame);
          localFramedataImpl1.setFin(true);
          if (!this.inframe)
            break label138;
        }
        label138: for (localObject = Framedata.Opcode.CONTINUOUS; ; localObject = Framedata.Opcode.TEXT)
        {
          localFramedataImpl1.setOptcode((Framedata.Opcode)localObject);
          this.readyframes.add(localFramedataImpl1);
          this.currentFrame = null;
          paramByteBuffer.mark();
          this.readingState = false;
          this.inframe = false;
          break;
        }
      }
      if (this.readingState)
      {
        if (this.currentFrame == null)
          this.currentFrame = createBuffer();
        while (true)
        {
          this.currentFrame.put(b);
          break;
          if (this.currentFrame.hasRemaining())
            continue;
          this.currentFrame = increaseBuffer(this.currentFrame);
        }
      }
      return null;
    }
    if (this.readingState)
    {
      localObject = new FramedataImpl1();
      this.currentFrame.flip();
      ((FramedataImpl1)localObject).setPayload(this.currentFrame);
      ((FramedataImpl1)localObject).setFin(false);
      if (!this.inframe)
        break label297;
    }
    label297: for (paramByteBuffer = Framedata.Opcode.CONTINUOUS; ; paramByteBuffer = Framedata.Opcode.TEXT)
    {
      ((FramedataImpl1)localObject).setOptcode(paramByteBuffer);
      this.inframe = true;
      this.readyframes.add(localObject);
      paramByteBuffer = this.readyframes;
      this.readyframes = new LinkedList();
      this.currentFrame = null;
      return paramByteBuffer;
    }
  }
}

/* Location:           C:\Users\c_jealom1\Documents\Scripts\Android\Fathom_com.brynk.fathom\Fathom_com.brynk.fathom-dex2jar.jar
 * Qualified Name:     org.java_websocket.drafts.Draft_75
 * JD-Core Version:    0.6.0
 */
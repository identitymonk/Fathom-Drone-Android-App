package org.java_websocket.drafts;

import java.math.BigInteger;
import java.nio.ByteBuffer;
import java.security.MessageDigest;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.List<Lorg.java_websocket.framing.Framedata;>;
import java.util.Random;
import org.java_websocket.WebSocket.Role;
import org.java_websocket.exceptions.InvalidDataException;
import org.java_websocket.exceptions.InvalidFrameException;
import org.java_websocket.exceptions.InvalidHandshakeException;
import org.java_websocket.exceptions.LimitExedeedException;
import org.java_websocket.exceptions.NotSendableException;
import org.java_websocket.framing.CloseFrameBuilder;
import org.java_websocket.framing.FrameBuilder;
import org.java_websocket.framing.Framedata;
import org.java_websocket.framing.Framedata.Opcode;
import org.java_websocket.framing.FramedataImpl1;
import org.java_websocket.handshake.ClientHandshake;
import org.java_websocket.handshake.ClientHandshakeBuilder;
import org.java_websocket.handshake.HandshakeBuilder;
import org.java_websocket.handshake.Handshakedata;
import org.java_websocket.handshake.ServerHandshake;
import org.java_websocket.handshake.ServerHandshakeBuilder;
import org.java_websocket.util.Base64;
import org.java_websocket.util.Charsetfunctions;

public class Draft_10 extends Draft
{
  private Framedata fragmentedframe = null;
  private ByteBuffer incompleteframe;
  private final Random reuseableRandom = new Random();

  static
  {
    if (!Draft_10.class.desiredAssertionStatus());
    for (boolean bool = true; ; bool = false)
    {
      $assertionsDisabled = bool;
      return;
    }
  }

  private byte fromOpcode(Framedata.Opcode paramOpcode)
  {
    if (paramOpcode == Framedata.Opcode.CONTINUOUS)
      return 0;
    if (paramOpcode == Framedata.Opcode.TEXT)
      return 1;
    if (paramOpcode == Framedata.Opcode.BINARY)
      return 2;
    if (paramOpcode == Framedata.Opcode.CLOSING)
      return 8;
    if (paramOpcode == Framedata.Opcode.PING)
      return 9;
    if (paramOpcode == Framedata.Opcode.PONG)
      return 10;
    throw new RuntimeException("Don't know how to handle " + paramOpcode.toString());
  }

  private String generateFinalKey(String paramString)
  {
    paramString = paramString.trim();
    paramString = paramString + "258EAFA5-E914-47DA-95CA-C5AB0DC85B11";
    try
    {
      MessageDigest localMessageDigest = MessageDigest.getInstance("SHA1");
      return Base64.encodeBytes(localMessageDigest.digest(paramString.getBytes()));
    }
    catch (java.security.NoSuchAlgorithmException paramString)
    {
    }
    throw new RuntimeException(paramString);
  }

  public static int readVersion(Handshakedata paramHandshakedata)
  {
    int i = -1;
    paramHandshakedata = paramHandshakedata.getFieldValue("Sec-WebSocket-Version");
    if (paramHandshakedata.length() > 0);
    try
    {
      i = new Integer(paramHandshakedata.trim()).intValue();
      return i;
    }
    catch (java.lang.NumberFormatException paramHandshakedata)
    {
    }
    return -1;
  }

  private byte[] toByteArray(long paramLong, int paramInt)
  {
    byte[] arrayOfByte = new byte[paramInt];
    int i = 0;
    while (i < paramInt)
    {
      arrayOfByte[i] = (byte)(int)(paramLong >>> paramInt * 8 - 8 - i * 8);
      i += 1;
    }
    return arrayOfByte;
  }

  private Framedata.Opcode toOpcode(byte paramByte)
    throws InvalidFrameException
  {
    switch (paramByte)
    {
    case 3:
    case 4:
    case 5:
    case 6:
    case 7:
    default:
      throw new InvalidFrameException("unknow optcode " + (short)paramByte);
    case 0:
      return Framedata.Opcode.CONTINUOUS;
    case 1:
      return Framedata.Opcode.TEXT;
    case 2:
      return Framedata.Opcode.BINARY;
    case 8:
      return Framedata.Opcode.CLOSING;
    case 9:
      return Framedata.Opcode.PING;
    case 10:
    }
    return Framedata.Opcode.PONG;
  }

  public Draft.HandshakeState acceptHandshakeAsClient(ClientHandshake paramClientHandshake, ServerHandshake paramServerHandshake)
    throws InvalidHandshakeException
  {
    if ((!paramClientHandshake.hasFieldValue("Sec-WebSocket-Key")) || (!paramServerHandshake.hasFieldValue("Sec-WebSocket-Accept")))
      return Draft.HandshakeState.NOT_MATCHED;
    paramServerHandshake = paramServerHandshake.getFieldValue("Sec-WebSocket-Accept");
    if (generateFinalKey(paramClientHandshake.getFieldValue("Sec-WebSocket-Key")).equals(paramServerHandshake))
      return Draft.HandshakeState.MATCHED;
    return Draft.HandshakeState.NOT_MATCHED;
  }

  public Draft.HandshakeState acceptHandshakeAsServer(ClientHandshake paramClientHandshake)
    throws InvalidHandshakeException
  {
    int i = readVersion(paramClientHandshake);
    if ((i == 7) || (i == 8))
    {
      if (basicAccept(paramClientHandshake))
        return Draft.HandshakeState.MATCHED;
      return Draft.HandshakeState.NOT_MATCHED;
    }
    return Draft.HandshakeState.NOT_MATCHED;
  }

  public Draft copyInstance()
  {
    return new Draft_10();
  }

  public ByteBuffer createBinaryFrame(Framedata paramFramedata)
  {
    ByteBuffer localByteBuffer1 = paramFramedata.getPayloadData();
    int j;
    int i;
    label32: label42: int m;
    label49: ByteBuffer localByteBuffer2;
    if (this.role == WebSocket.Role.CLIENT)
    {
      j = 1;
      if (localByteBuffer1.remaining() > 125)
        break label142;
      i = 1;
      if (i <= 1)
        break label163;
      k = i + 1;
      if (j == 0)
        break label169;
      m = 4;
      localByteBuffer2 = ByteBuffer.allocate(m + (k + 1) + localByteBuffer1.remaining());
      m = fromOpcode(paramFramedata.getOpcode());
      if (!paramFramedata.isFin())
        break label175;
    }
    label142: label163: label169: label175: for (int k = -128; ; k = 0)
    {
      localByteBuffer2.put((byte)((byte)k | m));
      paramFramedata = toByteArray(localByteBuffer1.remaining(), i);
      if (($assertionsDisabled) || (paramFramedata.length == i))
        break label181;
      throw new AssertionError();
      j = 0;
      break;
      if (localByteBuffer1.remaining() <= 65535)
      {
        i = 2;
        break label32;
      }
      i = 8;
      break label32;
      k = i;
      break label42;
      m = 0;
      break label49;
    }
    label181: if (i == 1)
    {
      k = paramFramedata[0];
      if (j != 0);
      for (i = -128; ; i = 0)
      {
        localByteBuffer2.put((byte)(i | k));
        if (j == 0)
          break;
        paramFramedata = ByteBuffer.allocate(4);
        paramFramedata.putInt(this.reuseableRandom.nextInt());
        localByteBuffer2.put(paramFramedata.array());
        i = 0;
        while (i < localByteBuffer1.limit())
        {
          localByteBuffer2.put((byte)(localByteBuffer1.get() ^ paramFramedata.get(i % 4)));
          i += 1;
        }
      }
    }
    if (i == 2)
    {
      if (j != 0);
      for (i = -128; ; i = 0)
      {
        localByteBuffer2.put((byte)(i | 0x7E));
        localByteBuffer2.put(paramFramedata);
        break;
      }
    }
    if (i == 8)
    {
      if (j != 0);
      for (i = -128; ; i = 0)
      {
        localByteBuffer2.put((byte)(i | 0x7F));
        localByteBuffer2.put(paramFramedata);
        break;
      }
    }
    throw new RuntimeException("Size representation not supported/specified");
    localByteBuffer2.put(localByteBuffer1);
    assert (localByteBuffer2.remaining() == 0) : localByteBuffer2.remaining();
    localByteBuffer2.flip();
    return localByteBuffer2;
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
    FramedataImpl1 localFramedataImpl1 = new FramedataImpl1();
    try
    {
      localFramedataImpl1.setPayload(paramByteBuffer);
      localFramedataImpl1.setFin(true);
      localFramedataImpl1.setOptcode(Framedata.Opcode.BINARY);
      localFramedataImpl1.setTransferemasked(paramBoolean);
      return Collections.singletonList(localFramedataImpl1);
    }
    catch (InvalidDataException paramByteBuffer)
    {
    }
    throw new NotSendableException(paramByteBuffer);
  }

  public Draft.CloseHandshakeType getCloseHandshakeType()
  {
    return Draft.CloseHandshakeType.TWOWAY;
  }

  public ClientHandshakeBuilder postProcessHandshakeRequestAsClient(ClientHandshakeBuilder paramClientHandshakeBuilder)
  {
    paramClientHandshakeBuilder.put("Upgrade", "websocket");
    paramClientHandshakeBuilder.put("Connection", "Upgrade");
    paramClientHandshakeBuilder.put("Sec-WebSocket-Version", "8");
    byte[] arrayOfByte = new byte[16];
    this.reuseableRandom.nextBytes(arrayOfByte);
    paramClientHandshakeBuilder.put("Sec-WebSocket-Key", Base64.encodeBytes(arrayOfByte));
    return paramClientHandshakeBuilder;
  }

  public HandshakeBuilder postProcessHandshakeResponseAsServer(ClientHandshake paramClientHandshake, ServerHandshakeBuilder paramServerHandshakeBuilder)
    throws InvalidHandshakeException
  {
    paramServerHandshakeBuilder.put("Upgrade", "websocket");
    paramServerHandshakeBuilder.put("Connection", paramClientHandshake.getFieldValue("Connection"));
    paramServerHandshakeBuilder.setHttpStatusMessage("Switching Protocols");
    paramClientHandshake = paramClientHandshake.getFieldValue("Sec-WebSocket-Key");
    if (paramClientHandshake == null)
      throw new InvalidHandshakeException("missing Sec-WebSocket-Key");
    paramServerHandshakeBuilder.put("Sec-WebSocket-Accept", generateFinalKey(paramClientHandshake));
    return paramServerHandshakeBuilder;
  }

  public void reset()
  {
    this.incompleteframe = null;
  }

  public List<Framedata> translateFrame(ByteBuffer paramByteBuffer)
    throws LimitExedeedException, InvalidDataException
  {
    LinkedList localLinkedList2 = new LinkedList();
    if (this.incompleteframe != null);
    Object localObject;
    try
    {
      paramByteBuffer.mark();
      int i = paramByteBuffer.remaining();
      int j = this.incompleteframe.remaining();
      if (j > i)
      {
        this.incompleteframe.put(paramByteBuffer.array(), paramByteBuffer.position(), i);
        paramByteBuffer.position(paramByteBuffer.position() + i);
        return Collections.emptyList();
      }
      this.incompleteframe.put(paramByteBuffer.array(), paramByteBuffer.position(), j);
      paramByteBuffer.position(paramByteBuffer.position() + j);
      localLinkedList2.add(translateSingleFrame((ByteBuffer)this.incompleteframe.duplicate().position(0)));
      this.incompleteframe = null;
      while (true)
      {
        LinkedList localLinkedList1 = localLinkedList2;
        if (paramByteBuffer.hasRemaining())
        {
          paramByteBuffer.mark();
          try
          {
            localLinkedList2.add(translateSingleFrame(paramByteBuffer));
          }
          catch (IncompleteException localIncompleteException1)
          {
            paramByteBuffer.reset();
            this.incompleteframe = ByteBuffer.allocate(checkAlloc(localIncompleteException1.getPreferedSize()));
            this.incompleteframe.put(paramByteBuffer);
            return localLinkedList2;
          }
        }
      }
    }
    catch (IncompleteException localObject)
    {
      this.incompleteframe.limit();
      localObject = ByteBuffer.allocate(checkAlloc(localIncompleteException2.getPreferedSize()));
      assert (((ByteBuffer)localObject).limit() > this.incompleteframe.limit());
      this.incompleteframe.rewind();
      ((ByteBuffer)localObject).put(this.incompleteframe);
      this.incompleteframe = ((ByteBuffer)localObject);
      localObject = translateFrame(paramByteBuffer);
    }
    return (List<Framedata>)localObject;
  }

  public Framedata translateSingleFrame(ByteBuffer paramByteBuffer)
    throws Draft_10.IncompleteException, InvalidDataException
  {
    int n = paramByteBuffer.remaining();
    int j = 2;
    if (n < 2)
      throw new IncompleteException(2);
    int m = paramByteBuffer.get();
    if (m >> 8 != 0);
    for (boolean bool = true; ; bool = false)
    {
      i = (byte)((m & 0x7F) >> 4);
      if (i == 0)
        break;
      throw new InvalidFrameException("bad rsv " + i);
    }
    int i = paramByteBuffer.get();
    if ((i & 0xFFFFFF80) != 0);
    Framedata.Opcode localOpcode;
    for (int k = 1; ; k = 0)
    {
      i = (byte)(i & 0x7F);
      localOpcode = toOpcode((byte)(m & 0xF));
      if ((bool) || ((localOpcode != Framedata.Opcode.PING) && (localOpcode != Framedata.Opcode.PONG) && (localOpcode != Framedata.Opcode.CLOSING)))
        break;
      throw new InvalidFrameException("control frames may no be fragmented");
    }
    if ((i >= 0) && (i <= 125))
      if (k == 0)
        break label397;
    label397: for (m = 4; ; m = 0)
    {
      j = j + m + i;
      if (n >= j)
        break label403;
      throw new IncompleteException(j);
      if ((localOpcode == Framedata.Opcode.PING) || (localOpcode == Framedata.Opcode.PONG) || (localOpcode == Framedata.Opcode.CLOSING))
        throw new InvalidFrameException("more than 125 octets");
      if (i == 126)
      {
        j = 2 + 2;
        if (n < j)
          throw new IncompleteException(j);
        localObject = new byte[3];
        localObject[1] = paramByteBuffer.get();
        localObject[2] = paramByteBuffer.get();
        i = new BigInteger(localObject).intValue();
        break;
      }
      j = 2 + 8;
      if (n < j)
        throw new IncompleteException(j);
      localObject = new byte[8];
      i = 0;
      while (i < 8)
      {
        localObject[i] = paramByteBuffer.get();
        i += 1;
      }
      long l = new BigInteger(localObject).longValue();
      if (l > 2147483647L)
        throw new LimitExedeedException("Payloadsize is to big...");
      i = (int)l;
      break;
    }
    label403: Object localObject = ByteBuffer.allocate(checkAlloc(i));
    if (k != 0)
    {
      byte[] arrayOfByte = new byte[4];
      paramByteBuffer.get(arrayOfByte);
      j = 0;
      while (j < i)
      {
        ((ByteBuffer)localObject).put((byte)(paramByteBuffer.get() ^ arrayOfByte[(j % 4)]));
        j += 1;
      }
    }
    ((ByteBuffer)localObject).put(paramByteBuffer.array(), paramByteBuffer.position(), ((ByteBuffer)localObject).limit());
    paramByteBuffer.position(paramByteBuffer.position() + ((ByteBuffer)localObject).limit());
    if (localOpcode == Framedata.Opcode.CLOSING)
      paramByteBuffer = new CloseFrameBuilder();
    while (true)
    {
      ((ByteBuffer)localObject).flip();
      paramByteBuffer.setPayload((ByteBuffer)localObject);
      return paramByteBuffer;
      paramByteBuffer = new FramedataImpl1();
      paramByteBuffer.setFin(bool);
      paramByteBuffer.setOptcode(localOpcode);
    }
  }

  private class IncompleteException extends Throwable
  {
    private static final long serialVersionUID = 7330519489840500997L;
    private int preferedsize;

    public IncompleteException(int arg2)
    {
      int i;
      this.preferedsize = i;
    }

    public int getPreferedSize()
    {
      return this.preferedsize;
    }
  }
}

/* Location:           C:\Users\c_jealom1\Documents\Scripts\Android\Fathom_com.brynk.fathom\Fathom_com.brynk.fathom-dex2jar.jar
 * Qualified Name:     org.java_websocket.drafts.Draft_10
 * JD-Core Version:    0.6.0
 */
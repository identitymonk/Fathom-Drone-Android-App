package org.java_websocket.drafts;

import java.nio.ByteBuffer;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import org.java_websocket.WebSocket.Role;
import org.java_websocket.exceptions.IncompleteHandshakeException;
import org.java_websocket.exceptions.InvalidDataException;
import org.java_websocket.exceptions.InvalidHandshakeException;
import org.java_websocket.exceptions.LimitExedeedException;
import org.java_websocket.framing.Framedata;
import org.java_websocket.handshake.ClientHandshake;
import org.java_websocket.handshake.ClientHandshakeBuilder;
import org.java_websocket.handshake.HandshakeBuilder;
import org.java_websocket.handshake.HandshakeImpl1Client;
import org.java_websocket.handshake.HandshakeImpl1Server;
import org.java_websocket.handshake.Handshakedata;
import org.java_websocket.handshake.ServerHandshake;
import org.java_websocket.handshake.ServerHandshakeBuilder;
import org.java_websocket.util.Charsetfunctions;

public abstract class Draft
{
  public static final byte[] FLASH_POLICY_REQUEST;
  public static int INITIAL_FAMESIZE;
  public static int MAX_FAME_SIZE = 1000;
  protected WebSocket.Role role = null;

  static
  {
    INITIAL_FAMESIZE = 64;
    FLASH_POLICY_REQUEST = Charsetfunctions.utf8Bytes("");
  }

  public static ByteBuffer readLine(ByteBuffer paramByteBuffer)
  {
    ByteBuffer localByteBuffer = ByteBuffer.allocate(paramByteBuffer.remaining());
    int i = 48;
    while (true)
    {
      int j = i;
      if (!paramByteBuffer.hasRemaining())
        break;
      byte b = paramByteBuffer.get();
      localByteBuffer.put(b);
      i = b;
      if (j != 13)
        continue;
      i = b;
      if (b != 10)
        continue;
      localByteBuffer.limit(localByteBuffer.position() - 2);
      localByteBuffer.position(0);
      return localByteBuffer;
    }
    paramByteBuffer.position(paramByteBuffer.position() - localByteBuffer.position());
    return null;
  }

  public static String readStringLine(ByteBuffer paramByteBuffer)
  {
    paramByteBuffer = readLine(paramByteBuffer);
    if (paramByteBuffer == null)
      return null;
    return Charsetfunctions.stringAscii(paramByteBuffer.array(), 0, paramByteBuffer.limit());
  }

  public static HandshakeBuilder translateHandshakeHttp(ByteBuffer paramByteBuffer, WebSocket.Role paramRole)
    throws InvalidHandshakeException, IncompleteHandshakeException
  {
    Object localObject = readStringLine(paramByteBuffer);
    if (localObject == null)
      throw new IncompleteHandshakeException(paramByteBuffer.capacity() + 128);
    localObject = ((String)localObject).split(" ", 3);
    if (localObject.length != 3)
      throw new InvalidHandshakeException();
    if (paramRole == WebSocket.Role.CLIENT)
    {
      paramRole = new HandshakeImpl1Server();
      ServerHandshakeBuilder localServerHandshakeBuilder = (ServerHandshakeBuilder)paramRole;
      localServerHandshakeBuilder.setHttpStatus(Short.parseShort(localObject[1]));
      localServerHandshakeBuilder.setHttpStatusMessage(localObject[2]);
    }
    for (localObject = readStringLine(paramByteBuffer); ; localObject = readStringLine(paramByteBuffer))
    {
      if ((localObject == null) || (((String)localObject).length() <= 0))
        break label175;
      localObject = ((String)localObject).split(":", 2);
      if (localObject.length != 2)
      {
        throw new InvalidHandshakeException("not an http header");
        paramRole = new HandshakeImpl1Client();
        paramRole.setResourceDescriptor(localObject[1]);
        break;
      }
      paramRole.put(localObject[0], localObject[1].replaceFirst("^ +", ""));
    }
    label175: if (localObject == null)
      throw new IncompleteHandshakeException();
    return (HandshakeBuilder)paramRole;
  }

  public abstract HandshakeState acceptHandshakeAsClient(ClientHandshake paramClientHandshake, ServerHandshake paramServerHandshake)
    throws InvalidHandshakeException;

  public abstract HandshakeState acceptHandshakeAsServer(ClientHandshake paramClientHandshake)
    throws InvalidHandshakeException;

  protected boolean basicAccept(Handshakedata paramHandshakedata)
  {
    return (paramHandshakedata.getFieldValue("Upgrade").equalsIgnoreCase("websocket")) && (paramHandshakedata.getFieldValue("Connection").toLowerCase(Locale.ENGLISH).contains("upgrade"));
  }

  public int checkAlloc(int paramInt)
    throws LimitExedeedException, InvalidDataException
  {
    if (paramInt < 0)
      throw new InvalidDataException(1002, "Negative count");
    return paramInt;
  }

  public abstract Draft copyInstance();

  public abstract ByteBuffer createBinaryFrame(Framedata paramFramedata);

  public abstract List<Framedata> createFrames(String paramString, boolean paramBoolean);

  public abstract List<Framedata> createFrames(ByteBuffer paramByteBuffer, boolean paramBoolean);

  public List<ByteBuffer> createHandshake(Handshakedata paramHandshakedata, WebSocket.Role paramRole)
  {
    return createHandshake(paramHandshakedata, paramRole, true);
  }

  public List<ByteBuffer> createHandshake(Handshakedata paramHandshakedata, WebSocket.Role paramRole, boolean paramBoolean)
  {
    paramRole = new StringBuilder(100);
    if ((paramHandshakedata instanceof ClientHandshake))
    {
      paramRole.append("GET ");
      paramRole.append(((ClientHandshake)paramHandshakedata).getResourceDescriptor());
      paramRole.append(" HTTP/1.1");
    }
    Object localObject;
    while (true)
    {
      paramRole.append("\r\n");
      localObject = paramHandshakedata.iterateHttpFields();
      while (true)
        if (((Iterator)localObject).hasNext())
        {
          String str1 = (String)((Iterator)localObject).next();
          String str2 = paramHandshakedata.getFieldValue(str1);
          paramRole.append(str1);
          paramRole.append(": ");
          paramRole.append(str2);
          paramRole.append("\r\n");
          continue;
          if ((paramHandshakedata instanceof ServerHandshake))
          {
            paramRole.append("HTTP/1.1 101 " + ((ServerHandshake)paramHandshakedata).getHttpStatusMessage());
            break;
          }
          throw new RuntimeException("unknow role");
        }
    }
    paramRole.append("\r\n");
    paramRole = Charsetfunctions.asciiBytes(paramRole.toString());
    if (paramBoolean)
    {
      paramHandshakedata = paramHandshakedata.getContent();
      if (paramHandshakedata != null)
        break label256;
    }
    label256: for (int i = 0; ; i = paramHandshakedata.length)
    {
      localObject = ByteBuffer.allocate(i + paramRole.length);
      ((ByteBuffer)localObject).put(paramRole);
      if (paramHandshakedata != null)
        ((ByteBuffer)localObject).put(paramHandshakedata);
      ((ByteBuffer)localObject).flip();
      return Collections.singletonList(localObject);
      paramHandshakedata = null;
      break;
    }
  }

  public abstract CloseHandshakeType getCloseHandshakeType();

  public abstract ClientHandshakeBuilder postProcessHandshakeRequestAsClient(ClientHandshakeBuilder paramClientHandshakeBuilder)
    throws InvalidHandshakeException;

  public abstract HandshakeBuilder postProcessHandshakeResponseAsServer(ClientHandshake paramClientHandshake, ServerHandshakeBuilder paramServerHandshakeBuilder)
    throws InvalidHandshakeException;

  public abstract void reset();

  public void setParseMode(WebSocket.Role paramRole)
  {
    this.role = paramRole;
  }

  public abstract List<Framedata> translateFrame(ByteBuffer paramByteBuffer)
    throws InvalidDataException;

  public Handshakedata translateHandshake(ByteBuffer paramByteBuffer)
    throws InvalidHandshakeException
  {
    return translateHandshakeHttp(paramByteBuffer, this.role);
  }

  public static enum CloseHandshakeType
  {
    static
    {
      $VALUES = new CloseHandshakeType[] { NONE, ONEWAY, TWOWAY };
    }
  }

  public static enum HandshakeState
  {
    static
    {
      $VALUES = new HandshakeState[] { MATCHED, NOT_MATCHED };
    }
  }
}

/* Location:           C:\Users\c_jealom1\Documents\Scripts\Android\Fathom_com.brynk.fathom\Fathom_com.brynk.fathom-dex2jar.jar
 * Qualified Name:     org.java_websocket.drafts.Draft
 * JD-Core Version:    0.6.0
 */
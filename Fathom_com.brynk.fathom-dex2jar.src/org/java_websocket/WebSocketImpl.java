package org.java_websocket;

import java.io.PrintStream;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.nio.ByteBuffer;
import java.nio.channels.ByteChannel;
import java.nio.channels.SelectionKey;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import org.java_websocket.drafts.Draft;
import org.java_websocket.drafts.Draft.CloseHandshakeType;
import org.java_websocket.drafts.Draft.HandshakeState;
import org.java_websocket.drafts.Draft_10;
import org.java_websocket.drafts.Draft_17;
import org.java_websocket.drafts.Draft_75;
import org.java_websocket.drafts.Draft_76;
import org.java_websocket.exceptions.IncompleteHandshakeException;
import org.java_websocket.exceptions.InvalidDataException;
import org.java_websocket.exceptions.InvalidHandshakeException;
import org.java_websocket.exceptions.WebsocketNotConnectedException;
import org.java_websocket.framing.CloseFrame;
import org.java_websocket.framing.CloseFrameBuilder;
import org.java_websocket.framing.Framedata;
import org.java_websocket.framing.Framedata.Opcode;
import org.java_websocket.handshake.ClientHandshake;
import org.java_websocket.handshake.ClientHandshakeBuilder;
import org.java_websocket.handshake.Handshakedata;
import org.java_websocket.server.WebSocketServer.WebSocketWorker;
import org.java_websocket.util.Charsetfunctions;

public class WebSocketImpl
  implements WebSocket
{
  public static boolean DEBUG;
  public static int RCVBUF;
  public static final List<Draft> defaultdraftlist;
  public ByteChannel channel;
  private Integer closecode = null;
  private Boolean closedremotely = null;
  private String closemessage = null;
  private Framedata.Opcode current_continuous_frame_opcode = null;
  private Draft draft = null;
  private volatile boolean flushandclosestate = false;
  private ClientHandshake handshakerequest = null;
  public final BlockingQueue<ByteBuffer> inQueue;
  public SelectionKey key;
  private List<Draft> knownDrafts;
  public final BlockingQueue<ByteBuffer> outQueue;
  private WebSocket.READYSTATE readystate = WebSocket.READYSTATE.NOT_YET_CONNECTED;
  private WebSocket.Role role;
  private ByteBuffer tmpHandshakeBytes;
  public volatile WebSocketServer.WebSocketWorker workerThread;
  private final WebSocketListener wsl;

  static
  {
    if (!WebSocketImpl.class.desiredAssertionStatus());
    for (boolean bool = true; ; bool = false)
    {
      $assertionsDisabled = bool;
      RCVBUF = 16384;
      DEBUG = false;
      defaultdraftlist = new ArrayList(4);
      defaultdraftlist.add(new Draft_17());
      defaultdraftlist.add(new Draft_10());
      defaultdraftlist.add(new Draft_76());
      defaultdraftlist.add(new Draft_75());
      return;
    }
  }

  public WebSocketImpl(WebSocketListener paramWebSocketListener, List<Draft> paramList)
  {
    this(paramWebSocketListener, (Draft)null);
    this.role = WebSocket.Role.SERVER;
    if ((paramList == null) || (paramList.isEmpty()))
    {
      this.knownDrafts = defaultdraftlist;
      return;
    }
    this.knownDrafts = paramList;
  }

  @Deprecated
  public WebSocketImpl(WebSocketListener paramWebSocketListener, List<Draft> paramList, Socket paramSocket)
  {
    this(paramWebSocketListener, paramList);
  }

  public WebSocketImpl(WebSocketListener paramWebSocketListener, Draft paramDraft)
  {
    if ((paramWebSocketListener == null) || ((paramDraft == null) && (this.role == WebSocket.Role.SERVER)))
      throw new IllegalArgumentException("parameters must not be null");
    this.outQueue = new LinkedBlockingQueue();
    this.inQueue = new LinkedBlockingQueue();
    this.wsl = paramWebSocketListener;
    this.role = WebSocket.Role.CLIENT;
    if (paramDraft != null)
      this.draft = paramDraft.copyInstance();
  }

  @Deprecated
  public WebSocketImpl(WebSocketListener paramWebSocketListener, Draft paramDraft, Socket paramSocket)
  {
    this(paramWebSocketListener, paramDraft);
  }

  private void close(int paramInt, String paramString, boolean paramBoolean)
  {
    if ((this.readystate != WebSocket.READYSTATE.CLOSING) && (this.readystate != WebSocket.READYSTATE.CLOSED))
    {
      if (this.readystate != WebSocket.READYSTATE.OPEN)
        break label190;
      if (paramInt == 1006)
      {
        assert (!paramBoolean);
        this.readystate = WebSocket.READYSTATE.CLOSING;
        flushAndClose(paramInt, paramString, false);
      }
    }
    else
    {
      return;
    }
    if ((this.draft.getCloseHandshakeType() == Draft.CloseHandshakeType.NONE) || (!paramBoolean));
    while (true)
    {
      try
      {
        this.wsl.onWebsocketCloseInitiated(this, paramInt, paramString);
        sendFrame(new CloseFrameBuilder(paramInt, paramString));
        flushAndClose(paramInt, paramString, paramBoolean);
        if (paramInt != 1002)
          continue;
        flushAndClose(paramInt, paramString, paramBoolean);
        this.readystate = WebSocket.READYSTATE.CLOSING;
        this.tmpHandshakeBytes = null;
        return;
      }
      catch (RuntimeException localRuntimeException)
      {
        this.wsl.onWebsocketError(this, localRuntimeException);
        continue;
      }
      catch (InvalidDataException localInvalidDataException)
      {
        this.wsl.onWebsocketError(this, localInvalidDataException);
        flushAndClose(1006, "generated frame is invalid", false);
        continue;
      }
      label190: if (paramInt == -3)
      {
        assert (paramBoolean);
        flushAndClose(-3, paramString, true);
        continue;
      }
      flushAndClose(-1, paramString, false);
    }
  }

  private void decodeFrames(ByteBuffer paramByteBuffer)
  {
    if (this.flushandclosestate)
      return;
    while (true)
    {
      Framedata localFramedata;
      boolean bool;
      int i;
      try
      {
        Iterator localIterator = this.draft.translateFrame(paramByteBuffer).iterator();
        if (!localIterator.hasNext())
          break;
        localFramedata = (Framedata)localIterator.next();
        if (!DEBUG)
          continue;
        System.out.println("matched frame: " + localFramedata);
        if (this.flushandclosestate)
          break;
        paramByteBuffer = localFramedata.getOpcode();
        bool = localFramedata.isFin();
        if (paramByteBuffer != Framedata.Opcode.CLOSING)
          break label214;
        i = 1005;
        paramByteBuffer = "";
        if (!(localFramedata instanceof CloseFrame))
          continue;
        paramByteBuffer = (CloseFrame)localFramedata;
        i = paramByteBuffer.getCloseCode();
        paramByteBuffer = paramByteBuffer.getMessage();
        if (this.readystate == WebSocket.READYSTATE.CLOSING)
        {
          closeConnection(i, paramByteBuffer, true);
          continue;
        }
      }
      catch (InvalidDataException paramByteBuffer)
      {
        this.wsl.onWebsocketError(this, paramByteBuffer);
        close(paramByteBuffer);
        return;
      }
      if (this.draft.getCloseHandshakeType() == Draft.CloseHandshakeType.TWOWAY)
      {
        close(i, paramByteBuffer, true);
        continue;
      }
      flushAndClose(i, paramByteBuffer, false);
      continue;
      label214: if (paramByteBuffer == Framedata.Opcode.PING)
      {
        this.wsl.onWebsocketPing(this, localFramedata);
        continue;
      }
      if (paramByteBuffer == Framedata.Opcode.PONG)
      {
        this.wsl.onWebsocketPong(this, localFramedata);
        continue;
      }
      if ((!bool) || (paramByteBuffer == Framedata.Opcode.CONTINUOUS))
      {
        if (paramByteBuffer != Framedata.Opcode.CONTINUOUS)
        {
          if (this.current_continuous_frame_opcode != null)
            throw new InvalidDataException(1002, "Previous continuous frame sequence not completed.");
          this.current_continuous_frame_opcode = paramByteBuffer;
        }
        label365: 
        do
          while (true)
          {
            try
            {
              this.wsl.onWebsocketMessageFragment(this, localFramedata);
            }
            catch (RuntimeException paramByteBuffer)
            {
              this.wsl.onWebsocketError(this, paramByteBuffer);
            }
            break;
            if (!bool)
              break label365;
            if (this.current_continuous_frame_opcode == null)
              throw new InvalidDataException(1002, "Continuous frame sequence was not started.");
            this.current_continuous_frame_opcode = null;
          }
        while (this.current_continuous_frame_opcode != null);
        throw new InvalidDataException(1002, "Continuous frame sequence was not started.");
      }
      if (this.current_continuous_frame_opcode != null)
        throw new InvalidDataException(1002, "Continuous frame sequence not completed.");
      Framedata.Opcode localOpcode = Framedata.Opcode.TEXT;
      if (paramByteBuffer == localOpcode)
      {
        try
        {
          this.wsl.onWebsocketMessage(this, Charsetfunctions.stringUtf8(localFramedata.getPayloadData()));
        }
        catch (RuntimeException paramByteBuffer)
        {
          this.wsl.onWebsocketError(this, paramByteBuffer);
        }
        continue;
      }
      localOpcode = Framedata.Opcode.BINARY;
      if (paramByteBuffer != localOpcode)
        break label502;
      try
      {
        this.wsl.onWebsocketMessage(this, localFramedata.getPayloadData());
      }
      catch (RuntimeException paramByteBuffer)
      {
        this.wsl.onWebsocketError(this, paramByteBuffer);
      }
    }
    label502: throw new InvalidDataException(1002, "non control or continious frame expected");
  }

  // ERROR //
  private boolean decodeHandshake(ByteBuffer paramByteBuffer)
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 208	org/java_websocket/WebSocketImpl:tmpHandshakeBytes	Ljava/nio/ByteBuffer;
    //   4: ifnonnull +62 -> 66
    //   7: aload_1
    //   8: astore 4
    //   10: aload 4
    //   12: invokevirtual 358	java/nio/ByteBuffer:mark	()Ljava/nio/Buffer;
    //   15: pop
    //   16: aload_0
    //   17: getfield 126	org/java_websocket/WebSocketImpl:draft	Lorg/java_websocket/drafts/Draft;
    //   20: ifnonnull +127 -> 147
    //   23: aload_0
    //   24: aload 4
    //   26: invokespecial 362	org/java_websocket/WebSocketImpl:isFlashEdgeCase	(Ljava/nio/ByteBuffer;)Lorg/java_websocket/drafts/Draft$HandshakeState;
    //   29: getstatic 368	org/java_websocket/drafts/Draft$HandshakeState:MATCHED	Lorg/java_websocket/drafts/Draft$HandshakeState;
    //   32: if_acmpne +115 -> 147
    //   35: aload_0
    //   36: aload_0
    //   37: getfield 152	org/java_websocket/WebSocketImpl:wsl	Lorg/java_websocket/WebSocketListener;
    //   40: aload_0
    //   41: invokeinterface 372 2 0
    //   46: invokestatic 376	org/java_websocket/util/Charsetfunctions:utf8Bytes	(Ljava/lang/String;)[B
    //   49: invokestatic 380	java/nio/ByteBuffer:wrap	([B)Ljava/nio/ByteBuffer;
    //   52: invokespecial 383	org/java_websocket/WebSocketImpl:write	(Ljava/nio/ByteBuffer;)V
    //   55: aload_0
    //   56: bipush 253
    //   58: ldc_w 275
    //   61: invokevirtual 385	org/java_websocket/WebSocketImpl:close	(ILjava/lang/String;)V
    //   64: iconst_0
    //   65: ireturn
    //   66: aload_0
    //   67: getfield 208	org/java_websocket/WebSocketImpl:tmpHandshakeBytes	Ljava/nio/ByteBuffer;
    //   70: invokevirtual 388	java/nio/ByteBuffer:remaining	()I
    //   73: aload_1
    //   74: invokevirtual 388	java/nio/ByteBuffer:remaining	()I
    //   77: if_icmpge +44 -> 121
    //   80: aload_0
    //   81: getfield 208	org/java_websocket/WebSocketImpl:tmpHandshakeBytes	Ljava/nio/ByteBuffer;
    //   84: invokevirtual 391	java/nio/ByteBuffer:capacity	()I
    //   87: aload_1
    //   88: invokevirtual 388	java/nio/ByteBuffer:remaining	()I
    //   91: iadd
    //   92: invokestatic 395	java/nio/ByteBuffer:allocate	(I)Ljava/nio/ByteBuffer;
    //   95: astore 4
    //   97: aload_0
    //   98: getfield 208	org/java_websocket/WebSocketImpl:tmpHandshakeBytes	Ljava/nio/ByteBuffer;
    //   101: invokevirtual 398	java/nio/ByteBuffer:flip	()Ljava/nio/Buffer;
    //   104: pop
    //   105: aload 4
    //   107: aload_0
    //   108: getfield 208	org/java_websocket/WebSocketImpl:tmpHandshakeBytes	Ljava/nio/ByteBuffer;
    //   111: invokevirtual 402	java/nio/ByteBuffer:put	(Ljava/nio/ByteBuffer;)Ljava/nio/ByteBuffer;
    //   114: pop
    //   115: aload_0
    //   116: aload 4
    //   118: putfield 208	org/java_websocket/WebSocketImpl:tmpHandshakeBytes	Ljava/nio/ByteBuffer;
    //   121: aload_0
    //   122: getfield 208	org/java_websocket/WebSocketImpl:tmpHandshakeBytes	Ljava/nio/ByteBuffer;
    //   125: aload_1
    //   126: invokevirtual 402	java/nio/ByteBuffer:put	(Ljava/nio/ByteBuffer;)Ljava/nio/ByteBuffer;
    //   129: pop
    //   130: aload_0
    //   131: getfield 208	org/java_websocket/WebSocketImpl:tmpHandshakeBytes	Ljava/nio/ByteBuffer;
    //   134: invokevirtual 398	java/nio/ByteBuffer:flip	()Ljava/nio/Buffer;
    //   137: pop
    //   138: aload_0
    //   139: getfield 208	org/java_websocket/WebSocketImpl:tmpHandshakeBytes	Ljava/nio/ByteBuffer;
    //   142: astore 4
    //   144: goto -134 -> 10
    //   147: aload_0
    //   148: getfield 101	org/java_websocket/WebSocketImpl:role	Lorg/java_websocket/WebSocket$Role;
    //   151: getstatic 99	org/java_websocket/WebSocket$Role:SERVER	Lorg/java_websocket/WebSocket$Role;
    //   154: if_acmpne +311 -> 465
    //   157: aload_0
    //   158: getfield 126	org/java_websocket/WebSocketImpl:draft	Lorg/java_websocket/drafts/Draft;
    //   161: ifnonnull +230 -> 391
    //   164: aload_0
    //   165: getfield 106	org/java_websocket/WebSocketImpl:knownDrafts	Ljava/util/List;
    //   168: invokeinterface 224 1 0
    //   173: astore 5
    //   175: aload 5
    //   177: invokeinterface 229 1 0
    //   182: ifeq +189 -> 371
    //   185: aload 5
    //   187: invokeinterface 233 1 0
    //   192: checkcast 91	org/java_websocket/drafts/Draft
    //   195: invokevirtual 159	org/java_websocket/drafts/Draft:copyInstance	()Lorg/java_websocket/drafts/Draft;
    //   198: astore 6
    //   200: aload 6
    //   202: aload_0
    //   203: getfield 101	org/java_websocket/WebSocketImpl:role	Lorg/java_websocket/WebSocket$Role;
    //   206: invokevirtual 406	org/java_websocket/drafts/Draft:setParseMode	(Lorg/java_websocket/WebSocket$Role;)V
    //   209: aload 4
    //   211: invokevirtual 409	java/nio/ByteBuffer:reset	()Ljava/nio/Buffer;
    //   214: pop
    //   215: aload 6
    //   217: aload 4
    //   219: invokevirtual 413	org/java_websocket/drafts/Draft:translateHandshake	(Ljava/nio/ByteBuffer;)Lorg/java_websocket/handshake/Handshakedata;
    //   222: astore 7
    //   224: aload 7
    //   226: instanceof 415
    //   229: ifne +16 -> 245
    //   232: aload_0
    //   233: sipush 1002
    //   236: ldc_w 417
    //   239: iconst_0
    //   240: invokevirtual 181	org/java_websocket/WebSocketImpl:flushAndClose	(ILjava/lang/String;Z)V
    //   243: iconst_0
    //   244: ireturn
    //   245: aload 7
    //   247: checkcast 415	org/java_websocket/handshake/ClientHandshake
    //   250: astore 7
    //   252: aload 6
    //   254: aload 7
    //   256: invokevirtual 421	org/java_websocket/drafts/Draft:acceptHandshakeAsServer	(Lorg/java_websocket/handshake/ClientHandshake;)Lorg/java_websocket/drafts/Draft$HandshakeState;
    //   259: astore 8
    //   261: getstatic 368	org/java_websocket/drafts/Draft$HandshakeState:MATCHED	Lorg/java_websocket/drafts/Draft$HandshakeState;
    //   264: astore 9
    //   266: aload 8
    //   268: aload 9
    //   270: if_acmpne -95 -> 175
    //   273: aload_0
    //   274: getfield 152	org/java_websocket/WebSocketImpl:wsl	Lorg/java_websocket/WebSocketListener;
    //   277: aload_0
    //   278: aload 6
    //   280: aload 7
    //   282: invokeinterface 425 4 0
    //   287: astore 8
    //   289: aload_0
    //   290: aload 6
    //   292: aload 6
    //   294: aload 7
    //   296: aload 8
    //   298: invokevirtual 429	org/java_websocket/drafts/Draft:postProcessHandshakeResponseAsServer	(Lorg/java_websocket/handshake/ClientHandshake;Lorg/java_websocket/handshake/ServerHandshakeBuilder;)Lorg/java_websocket/handshake/HandshakeBuilder;
    //   301: aload_0
    //   302: getfield 101	org/java_websocket/WebSocketImpl:role	Lorg/java_websocket/WebSocket$Role;
    //   305: invokevirtual 433	org/java_websocket/drafts/Draft:createHandshake	(Lorg/java_websocket/handshake/Handshakedata;Lorg/java_websocket/WebSocket$Role;)Ljava/util/List;
    //   308: invokespecial 436	org/java_websocket/WebSocketImpl:write	(Ljava/util/List;)V
    //   311: aload_0
    //   312: aload 6
    //   314: putfield 126	org/java_websocket/WebSocketImpl:draft	Lorg/java_websocket/drafts/Draft;
    //   317: aload_0
    //   318: aload 7
    //   320: invokespecial 440	org/java_websocket/WebSocketImpl:open	(Lorg/java_websocket/handshake/Handshakedata;)V
    //   323: iconst_1
    //   324: ireturn
    //   325: astore 6
    //   327: aload_0
    //   328: aload 6
    //   330: invokevirtual 441	org/java_websocket/exceptions/InvalidDataException:getCloseCode	()I
    //   333: aload 6
    //   335: invokevirtual 442	org/java_websocket/exceptions/InvalidDataException:getMessage	()Ljava/lang/String;
    //   338: iconst_0
    //   339: invokevirtual 181	org/java_websocket/WebSocketImpl:flushAndClose	(ILjava/lang/String;Z)V
    //   342: iconst_0
    //   343: ireturn
    //   344: astore 6
    //   346: aload_0
    //   347: getfield 152	org/java_websocket/WebSocketImpl:wsl	Lorg/java_websocket/WebSocketListener;
    //   350: aload_0
    //   351: aload 6
    //   353: invokeinterface 212 3 0
    //   358: aload_0
    //   359: iconst_m1
    //   360: aload 6
    //   362: invokevirtual 443	java/lang/RuntimeException:getMessage	()Ljava/lang/String;
    //   365: iconst_0
    //   366: invokevirtual 181	org/java_websocket/WebSocketImpl:flushAndClose	(ILjava/lang/String;Z)V
    //   369: iconst_0
    //   370: ireturn
    //   371: aload_0
    //   372: getfield 126	org/java_websocket/WebSocketImpl:draft	Lorg/java_websocket/drafts/Draft;
    //   375: ifnonnull +419 -> 794
    //   378: aload_0
    //   379: sipush 1002
    //   382: ldc_w 445
    //   385: invokevirtual 385	org/java_websocket/WebSocketImpl:close	(ILjava/lang/String;)V
    //   388: goto +406 -> 794
    //   391: aload_0
    //   392: getfield 126	org/java_websocket/WebSocketImpl:draft	Lorg/java_websocket/drafts/Draft;
    //   395: aload 4
    //   397: invokevirtual 413	org/java_websocket/drafts/Draft:translateHandshake	(Ljava/nio/ByteBuffer;)Lorg/java_websocket/handshake/Handshakedata;
    //   400: astore 5
    //   402: aload 5
    //   404: instanceof 415
    //   407: ifne +16 -> 423
    //   410: aload_0
    //   411: sipush 1002
    //   414: ldc_w 417
    //   417: iconst_0
    //   418: invokevirtual 181	org/java_websocket/WebSocketImpl:flushAndClose	(ILjava/lang/String;Z)V
    //   421: iconst_0
    //   422: ireturn
    //   423: aload 5
    //   425: checkcast 415	org/java_websocket/handshake/ClientHandshake
    //   428: astore 5
    //   430: aload_0
    //   431: getfield 126	org/java_websocket/WebSocketImpl:draft	Lorg/java_websocket/drafts/Draft;
    //   434: aload 5
    //   436: invokevirtual 421	org/java_websocket/drafts/Draft:acceptHandshakeAsServer	(Lorg/java_websocket/handshake/ClientHandshake;)Lorg/java_websocket/drafts/Draft$HandshakeState;
    //   439: getstatic 368	org/java_websocket/drafts/Draft$HandshakeState:MATCHED	Lorg/java_websocket/drafts/Draft$HandshakeState;
    //   442: if_acmpne +11 -> 453
    //   445: aload_0
    //   446: aload 5
    //   448: invokespecial 440	org/java_websocket/WebSocketImpl:open	(Lorg/java_websocket/handshake/Handshakedata;)V
    //   451: iconst_1
    //   452: ireturn
    //   453: aload_0
    //   454: sipush 1002
    //   457: ldc_w 447
    //   460: invokevirtual 385	org/java_websocket/WebSocketImpl:close	(ILjava/lang/String;)V
    //   463: iconst_0
    //   464: ireturn
    //   465: aload_0
    //   466: getfield 101	org/java_websocket/WebSocketImpl:role	Lorg/java_websocket/WebSocket$Role;
    //   469: getstatic 155	org/java_websocket/WebSocket$Role:CLIENT	Lorg/java_websocket/WebSocket$Role;
    //   472: if_acmpne +186 -> 658
    //   475: aload_0
    //   476: getfield 126	org/java_websocket/WebSocketImpl:draft	Lorg/java_websocket/drafts/Draft;
    //   479: aload_0
    //   480: getfield 101	org/java_websocket/WebSocketImpl:role	Lorg/java_websocket/WebSocket$Role;
    //   483: invokevirtual 406	org/java_websocket/drafts/Draft:setParseMode	(Lorg/java_websocket/WebSocket$Role;)V
    //   486: aload_0
    //   487: getfield 126	org/java_websocket/WebSocketImpl:draft	Lorg/java_websocket/drafts/Draft;
    //   490: aload 4
    //   492: invokevirtual 413	org/java_websocket/drafts/Draft:translateHandshake	(Ljava/nio/ByteBuffer;)Lorg/java_websocket/handshake/Handshakedata;
    //   495: astore 5
    //   497: aload 5
    //   499: instanceof 449
    //   502: ifne +16 -> 518
    //   505: aload_0
    //   506: sipush 1002
    //   509: ldc_w 451
    //   512: iconst_0
    //   513: invokevirtual 181	org/java_websocket/WebSocketImpl:flushAndClose	(ILjava/lang/String;Z)V
    //   516: iconst_0
    //   517: ireturn
    //   518: aload 5
    //   520: checkcast 449	org/java_websocket/handshake/ServerHandshake
    //   523: astore 5
    //   525: aload_0
    //   526: getfield 126	org/java_websocket/WebSocketImpl:draft	Lorg/java_websocket/drafts/Draft;
    //   529: aload_0
    //   530: getfield 130	org/java_websocket/WebSocketImpl:handshakerequest	Lorg/java_websocket/handshake/ClientHandshake;
    //   533: aload 5
    //   535: invokevirtual 455	org/java_websocket/drafts/Draft:acceptHandshakeAsClient	(Lorg/java_websocket/handshake/ClientHandshake;Lorg/java_websocket/handshake/ServerHandshake;)Lorg/java_websocket/drafts/Draft$HandshakeState;
    //   538: astore 6
    //   540: getstatic 368	org/java_websocket/drafts/Draft$HandshakeState:MATCHED	Lorg/java_websocket/drafts/Draft$HandshakeState;
    //   543: astore 7
    //   545: aload 6
    //   547: aload 7
    //   549: if_acmpne +73 -> 622
    //   552: aload_0
    //   553: getfield 152	org/java_websocket/WebSocketImpl:wsl	Lorg/java_websocket/WebSocketListener;
    //   556: aload_0
    //   557: aload_0
    //   558: getfield 130	org/java_websocket/WebSocketImpl:handshakerequest	Lorg/java_websocket/handshake/ClientHandshake;
    //   561: aload 5
    //   563: invokeinterface 459 4 0
    //   568: aload_0
    //   569: aload 5
    //   571: invokespecial 440	org/java_websocket/WebSocketImpl:open	(Lorg/java_websocket/handshake/Handshakedata;)V
    //   574: iconst_1
    //   575: ireturn
    //   576: astore 5
    //   578: aload_0
    //   579: aload 5
    //   581: invokevirtual 441	org/java_websocket/exceptions/InvalidDataException:getCloseCode	()I
    //   584: aload 5
    //   586: invokevirtual 442	org/java_websocket/exceptions/InvalidDataException:getMessage	()Ljava/lang/String;
    //   589: iconst_0
    //   590: invokevirtual 181	org/java_websocket/WebSocketImpl:flushAndClose	(ILjava/lang/String;Z)V
    //   593: iconst_0
    //   594: ireturn
    //   595: astore 5
    //   597: aload_0
    //   598: getfield 152	org/java_websocket/WebSocketImpl:wsl	Lorg/java_websocket/WebSocketListener;
    //   601: aload_0
    //   602: aload 5
    //   604: invokeinterface 212 3 0
    //   609: aload_0
    //   610: iconst_m1
    //   611: aload 5
    //   613: invokevirtual 443	java/lang/RuntimeException:getMessage	()Ljava/lang/String;
    //   616: iconst_0
    //   617: invokevirtual 181	org/java_websocket/WebSocketImpl:flushAndClose	(ILjava/lang/String;Z)V
    //   620: iconst_0
    //   621: ireturn
    //   622: aload_0
    //   623: sipush 1002
    //   626: new 243	java/lang/StringBuilder
    //   629: dup
    //   630: invokespecial 244	java/lang/StringBuilder:<init>	()V
    //   633: ldc_w 461
    //   636: invokevirtual 250	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   639: aload_0
    //   640: getfield 126	org/java_websocket/WebSocketImpl:draft	Lorg/java_websocket/drafts/Draft;
    //   643: invokevirtual 253	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   646: ldc_w 463
    //   649: invokevirtual 250	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   652: invokevirtual 257	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   655: invokevirtual 385	org/java_websocket/WebSocketImpl:close	(ILjava/lang/String;)V
    //   658: iconst_0
    //   659: ireturn
    //   660: astore 5
    //   662: aload_0
    //   663: aload 5
    //   665: invokevirtual 290	org/java_websocket/WebSocketImpl:close	(Lorg/java_websocket/exceptions/InvalidDataException;)V
    //   668: goto -10 -> 658
    //   671: astore 5
    //   673: aload_0
    //   674: getfield 208	org/java_websocket/WebSocketImpl:tmpHandshakeBytes	Ljava/nio/ByteBuffer;
    //   677: ifnonnull +79 -> 756
    //   680: aload 4
    //   682: invokevirtual 409	java/nio/ByteBuffer:reset	()Ljava/nio/Buffer;
    //   685: pop
    //   686: aload 5
    //   688: invokevirtual 466	org/java_websocket/exceptions/IncompleteHandshakeException:getPreferedSize	()I
    //   691: istore_3
    //   692: iload_3
    //   693: ifne +32 -> 725
    //   696: aload 4
    //   698: invokevirtual 391	java/nio/ByteBuffer:capacity	()I
    //   701: bipush 16
    //   703: iadd
    //   704: istore_2
    //   705: aload_0
    //   706: iload_2
    //   707: invokestatic 395	java/nio/ByteBuffer:allocate	(I)Ljava/nio/ByteBuffer;
    //   710: putfield 208	org/java_websocket/WebSocketImpl:tmpHandshakeBytes	Ljava/nio/ByteBuffer;
    //   713: aload_0
    //   714: getfield 208	org/java_websocket/WebSocketImpl:tmpHandshakeBytes	Ljava/nio/ByteBuffer;
    //   717: aload_1
    //   718: invokevirtual 402	java/nio/ByteBuffer:put	(Ljava/nio/ByteBuffer;)Ljava/nio/ByteBuffer;
    //   721: pop
    //   722: goto -64 -> 658
    //   725: iload_3
    //   726: istore_2
    //   727: getstatic 56	org/java_websocket/WebSocketImpl:$assertionsDisabled	Z
    //   730: ifne -25 -> 705
    //   733: iload_3
    //   734: istore_2
    //   735: aload 5
    //   737: invokevirtual 466	org/java_websocket/exceptions/IncompleteHandshakeException:getPreferedSize	()I
    //   740: aload 4
    //   742: invokevirtual 388	java/nio/ByteBuffer:remaining	()I
    //   745: if_icmpge -40 -> 705
    //   748: new 177	java/lang/AssertionError
    //   751: dup
    //   752: invokespecial 178	java/lang/AssertionError:<init>	()V
    //   755: athrow
    //   756: aload_0
    //   757: getfield 208	org/java_websocket/WebSocketImpl:tmpHandshakeBytes	Ljava/nio/ByteBuffer;
    //   760: aload_0
    //   761: getfield 208	org/java_websocket/WebSocketImpl:tmpHandshakeBytes	Ljava/nio/ByteBuffer;
    //   764: invokevirtual 469	java/nio/ByteBuffer:limit	()I
    //   767: invokevirtual 473	java/nio/ByteBuffer:position	(I)Ljava/nio/Buffer;
    //   770: pop
    //   771: aload_0
    //   772: getfield 208	org/java_websocket/WebSocketImpl:tmpHandshakeBytes	Ljava/nio/ByteBuffer;
    //   775: aload_0
    //   776: getfield 208	org/java_websocket/WebSocketImpl:tmpHandshakeBytes	Ljava/nio/ByteBuffer;
    //   779: invokevirtual 391	java/nio/ByteBuffer:capacity	()I
    //   782: invokevirtual 475	java/nio/ByteBuffer:limit	(I)Ljava/nio/Buffer;
    //   785: pop
    //   786: goto -128 -> 658
    //   789: astore 6
    //   791: goto -616 -> 175
    //   794: iconst_0
    //   795: ireturn
    //
    // Exception table:
    //   from	to	target	type
    //   273	289	325	org/java_websocket/exceptions/InvalidDataException
    //   273	289	344	java/lang/RuntimeException
    //   552	568	576	org/java_websocket/exceptions/InvalidDataException
    //   552	568	595	java/lang/RuntimeException
    //   147	175	660	org/java_websocket/exceptions/InvalidHandshakeException
    //   175	200	660	org/java_websocket/exceptions/InvalidHandshakeException
    //   371	388	660	org/java_websocket/exceptions/InvalidHandshakeException
    //   391	421	660	org/java_websocket/exceptions/InvalidHandshakeException
    //   423	451	660	org/java_websocket/exceptions/InvalidHandshakeException
    //   453	463	660	org/java_websocket/exceptions/InvalidHandshakeException
    //   465	516	660	org/java_websocket/exceptions/InvalidHandshakeException
    //   518	545	660	org/java_websocket/exceptions/InvalidHandshakeException
    //   552	568	660	org/java_websocket/exceptions/InvalidHandshakeException
    //   568	574	660	org/java_websocket/exceptions/InvalidHandshakeException
    //   578	593	660	org/java_websocket/exceptions/InvalidHandshakeException
    //   597	620	660	org/java_websocket/exceptions/InvalidHandshakeException
    //   622	658	660	org/java_websocket/exceptions/InvalidHandshakeException
    //   16	64	671	org/java_websocket/exceptions/IncompleteHandshakeException
    //   147	175	671	org/java_websocket/exceptions/IncompleteHandshakeException
    //   175	200	671	org/java_websocket/exceptions/IncompleteHandshakeException
    //   200	243	671	org/java_websocket/exceptions/IncompleteHandshakeException
    //   245	266	671	org/java_websocket/exceptions/IncompleteHandshakeException
    //   273	289	671	org/java_websocket/exceptions/IncompleteHandshakeException
    //   289	323	671	org/java_websocket/exceptions/IncompleteHandshakeException
    //   327	342	671	org/java_websocket/exceptions/IncompleteHandshakeException
    //   346	369	671	org/java_websocket/exceptions/IncompleteHandshakeException
    //   371	388	671	org/java_websocket/exceptions/IncompleteHandshakeException
    //   391	421	671	org/java_websocket/exceptions/IncompleteHandshakeException
    //   423	451	671	org/java_websocket/exceptions/IncompleteHandshakeException
    //   453	463	671	org/java_websocket/exceptions/IncompleteHandshakeException
    //   465	516	671	org/java_websocket/exceptions/IncompleteHandshakeException
    //   518	545	671	org/java_websocket/exceptions/IncompleteHandshakeException
    //   552	568	671	org/java_websocket/exceptions/IncompleteHandshakeException
    //   568	574	671	org/java_websocket/exceptions/IncompleteHandshakeException
    //   578	593	671	org/java_websocket/exceptions/IncompleteHandshakeException
    //   597	620	671	org/java_websocket/exceptions/IncompleteHandshakeException
    //   622	658	671	org/java_websocket/exceptions/IncompleteHandshakeException
    //   662	668	671	org/java_websocket/exceptions/IncompleteHandshakeException
    //   200	243	789	org/java_websocket/exceptions/InvalidHandshakeException
    //   245	266	789	org/java_websocket/exceptions/InvalidHandshakeException
    //   273	289	789	org/java_websocket/exceptions/InvalidHandshakeException
    //   289	323	789	org/java_websocket/exceptions/InvalidHandshakeException
    //   327	342	789	org/java_websocket/exceptions/InvalidHandshakeException
    //   346	369	789	org/java_websocket/exceptions/InvalidHandshakeException
  }

  private Draft.HandshakeState isFlashEdgeCase(ByteBuffer paramByteBuffer)
    throws IncompleteHandshakeException
  {
    paramByteBuffer.mark();
    if (paramByteBuffer.limit() > Draft.FLASH_POLICY_REQUEST.length)
      return Draft.HandshakeState.NOT_MATCHED;
    if (paramByteBuffer.limit() < Draft.FLASH_POLICY_REQUEST.length)
      throw new IncompleteHandshakeException(Draft.FLASH_POLICY_REQUEST.length);
    int i = 0;
    while (paramByteBuffer.hasRemaining())
    {
      if (Draft.FLASH_POLICY_REQUEST[i] != paramByteBuffer.get())
      {
        paramByteBuffer.reset();
        return Draft.HandshakeState.NOT_MATCHED;
      }
      i += 1;
    }
    return Draft.HandshakeState.MATCHED;
  }

  private void open(Handshakedata paramHandshakedata)
  {
    if (DEBUG)
      System.out.println("open using draft: " + this.draft.getClass().getSimpleName());
    this.readystate = WebSocket.READYSTATE.OPEN;
    try
    {
      this.wsl.onWebsocketOpen(this, paramHandshakedata);
      return;
    }
    catch (RuntimeException paramHandshakedata)
    {
      this.wsl.onWebsocketError(this, paramHandshakedata);
    }
  }

  private void send(Collection<Framedata> paramCollection)
  {
    if (!isOpen())
      throw new WebsocketNotConnectedException();
    paramCollection = paramCollection.iterator();
    while (paramCollection.hasNext())
      sendFrame((Framedata)paramCollection.next());
  }

  private void write(ByteBuffer paramByteBuffer)
  {
    PrintStream localPrintStream;
    StringBuilder localStringBuilder;
    if (DEBUG)
    {
      localPrintStream = System.out;
      localStringBuilder = new StringBuilder().append("write(").append(paramByteBuffer.remaining()).append("): {");
      if (paramByteBuffer.remaining() <= 1000)
        break label93;
    }
    label93: for (String str = "too big to display"; ; str = new String(paramByteBuffer.array()))
    {
      localPrintStream.println(str + "}");
      this.outQueue.add(paramByteBuffer);
      this.wsl.onWriteDemand(this);
      return;
    }
  }

  private void write(List<ByteBuffer> paramList)
  {
    paramList = paramList.iterator();
    while (paramList.hasNext())
      write((ByteBuffer)paramList.next());
  }

  public void close()
  {
    close(1000);
  }

  public void close(int paramInt)
  {
    close(paramInt, "", false);
  }

  public void close(int paramInt, String paramString)
  {
    close(paramInt, paramString, false);
  }

  public void close(InvalidDataException paramInvalidDataException)
  {
    close(paramInvalidDataException.getCloseCode(), paramInvalidDataException.getMessage(), false);
  }

  public void closeConnection()
  {
    if (this.closedremotely == null)
      throw new IllegalStateException("this method must be used in conjuction with flushAndClose");
    closeConnection(this.closecode.intValue(), this.closemessage, this.closedremotely.booleanValue());
  }

  public void closeConnection(int paramInt, String paramString)
  {
    closeConnection(paramInt, paramString, false);
  }

  // ERROR //
  protected void closeConnection(int paramInt, String paramString, boolean paramBoolean)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 124	org/java_websocket/WebSocketImpl:readystate	Lorg/java_websocket/WebSocket$READYSTATE;
    //   6: astore 4
    //   8: getstatic 172	org/java_websocket/WebSocket$READYSTATE:CLOSED	Lorg/java_websocket/WebSocket$READYSTATE;
    //   11: astore 5
    //   13: aload 4
    //   15: aload 5
    //   17: if_acmpne +6 -> 23
    //   20: aload_0
    //   21: monitorexit
    //   22: return
    //   23: aload_0
    //   24: getfield 565	org/java_websocket/WebSocketImpl:key	Ljava/nio/channels/SelectionKey;
    //   27: ifnull +10 -> 37
    //   30: aload_0
    //   31: getfield 565	org/java_websocket/WebSocketImpl:key	Ljava/nio/channels/SelectionKey;
    //   34: invokevirtual 570	java/nio/channels/SelectionKey:cancel	()V
    //   37: aload_0
    //   38: getfield 572	org/java_websocket/WebSocketImpl:channel	Ljava/nio/channels/ByteChannel;
    //   41: astore 4
    //   43: aload 4
    //   45: ifnull +12 -> 57
    //   48: aload_0
    //   49: getfield 572	org/java_websocket/WebSocketImpl:channel	Ljava/nio/channels/ByteChannel;
    //   52: invokeinterface 576 1 0
    //   57: aload_0
    //   58: getfield 152	org/java_websocket/WebSocketImpl:wsl	Lorg/java_websocket/WebSocketListener;
    //   61: aload_0
    //   62: iload_1
    //   63: aload_2
    //   64: iload_3
    //   65: invokeinterface 580 5 0
    //   70: aload_0
    //   71: getfield 126	org/java_websocket/WebSocketImpl:draft	Lorg/java_websocket/drafts/Draft;
    //   74: ifnull +10 -> 84
    //   77: aload_0
    //   78: getfield 126	org/java_websocket/WebSocketImpl:draft	Lorg/java_websocket/drafts/Draft;
    //   81: invokevirtual 582	org/java_websocket/drafts/Draft:reset	()V
    //   84: aload_0
    //   85: aconst_null
    //   86: putfield 130	org/java_websocket/WebSocketImpl:handshakerequest	Lorg/java_websocket/handshake/ClientHandshake;
    //   89: aload_0
    //   90: getstatic 172	org/java_websocket/WebSocket$READYSTATE:CLOSED	Lorg/java_websocket/WebSocket$READYSTATE;
    //   93: putfield 124	org/java_websocket/WebSocketImpl:readystate	Lorg/java_websocket/WebSocket$READYSTATE;
    //   96: aload_0
    //   97: getfield 148	org/java_websocket/WebSocketImpl:outQueue	Ljava/util/concurrent/BlockingQueue;
    //   100: invokeinterface 585 1 0
    //   105: goto -85 -> 20
    //   108: astore_2
    //   109: aload_0
    //   110: monitorexit
    //   111: aload_2
    //   112: athrow
    //   113: astore 4
    //   115: aload_0
    //   116: getfield 152	org/java_websocket/WebSocketImpl:wsl	Lorg/java_websocket/WebSocketListener;
    //   119: aload_0
    //   120: aload 4
    //   122: invokeinterface 212 3 0
    //   127: goto -70 -> 57
    //   130: astore_2
    //   131: aload_0
    //   132: getfield 152	org/java_websocket/WebSocketImpl:wsl	Lorg/java_websocket/WebSocketListener;
    //   135: aload_0
    //   136: aload_2
    //   137: invokeinterface 212 3 0
    //   142: goto -72 -> 70
    //
    // Exception table:
    //   from	to	target	type
    //   2	13	108	finally
    //   23	37	108	finally
    //   37	43	108	finally
    //   48	57	108	finally
    //   57	70	108	finally
    //   70	84	108	finally
    //   84	105	108	finally
    //   115	127	108	finally
    //   131	142	108	finally
    //   48	57	113	java/io/IOException
    //   57	70	130	java/lang/RuntimeException
  }

  protected void closeConnection(int paramInt, boolean paramBoolean)
  {
    closeConnection(paramInt, "", paramBoolean);
  }

  public void decode(ByteBuffer paramByteBuffer)
  {
    if ((!paramByteBuffer.hasRemaining()) || (this.flushandclosestate));
    label159: label173: 
    while (true)
    {
      return;
      String str;
      if (DEBUG)
      {
        PrintStream localPrintStream = System.out;
        StringBuilder localStringBuilder = new StringBuilder().append("process(").append(paramByteBuffer.remaining()).append("): {");
        if (paramByteBuffer.remaining() > 1000)
        {
          str = "too big to display";
          localPrintStream.println(str + "}");
        }
      }
      else
      {
        if (this.readystate != WebSocket.READYSTATE.OPEN)
          break label159;
        decodeFrames(paramByteBuffer);
      }
      while (true)
      {
        if (($assertionsDisabled) || (isClosing()) || (isFlushAndClose()) || (!paramByteBuffer.hasRemaining()))
          break label173;
        throw new AssertionError();
        str = new String(paramByteBuffer.array(), paramByteBuffer.position(), paramByteBuffer.remaining());
        break;
        if (!decodeHandshake(paramByteBuffer))
          continue;
        decodeFrames(paramByteBuffer);
      }
    }
  }

  public void eot()
  {
    if (getReadyState() == WebSocket.READYSTATE.NOT_YET_CONNECTED)
    {
      closeConnection(-1, true);
      return;
    }
    if (this.flushandclosestate)
    {
      closeConnection(this.closecode.intValue(), this.closemessage, this.closedremotely.booleanValue());
      return;
    }
    if (this.draft.getCloseHandshakeType() == Draft.CloseHandshakeType.NONE)
    {
      closeConnection(1000, true);
      return;
    }
    if (this.draft.getCloseHandshakeType() == Draft.CloseHandshakeType.ONEWAY)
    {
      if (this.role == WebSocket.Role.SERVER)
      {
        closeConnection(1006, true);
        return;
      }
      closeConnection(1000, true);
      return;
    }
    closeConnection(1006, true);
  }

  // ERROR //
  protected void flushAndClose(int paramInt, String paramString, boolean paramBoolean)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 117	org/java_websocket/WebSocketImpl:flushandclosestate	Z
    //   6: istore 4
    //   8: iload 4
    //   10: ifeq +6 -> 16
    //   13: aload_0
    //   14: monitorexit
    //   15: return
    //   16: aload_0
    //   17: iload_1
    //   18: invokestatic 618	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   21: putfield 134	org/java_websocket/WebSocketImpl:closecode	Ljava/lang/Integer;
    //   24: aload_0
    //   25: aload_2
    //   26: putfield 132	org/java_websocket/WebSocketImpl:closemessage	Ljava/lang/String;
    //   29: aload_0
    //   30: iload_3
    //   31: invokestatic 621	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   34: putfield 136	org/java_websocket/WebSocketImpl:closedremotely	Ljava/lang/Boolean;
    //   37: aload_0
    //   38: iconst_1
    //   39: putfield 117	org/java_websocket/WebSocketImpl:flushandclosestate	Z
    //   42: aload_0
    //   43: getfield 152	org/java_websocket/WebSocketImpl:wsl	Lorg/java_websocket/WebSocketListener;
    //   46: aload_0
    //   47: invokeinterface 534 2 0
    //   52: aload_0
    //   53: getfield 152	org/java_websocket/WebSocketImpl:wsl	Lorg/java_websocket/WebSocketListener;
    //   56: aload_0
    //   57: iload_1
    //   58: aload_2
    //   59: iload_3
    //   60: invokeinterface 624 5 0
    //   65: aload_0
    //   66: getfield 126	org/java_websocket/WebSocketImpl:draft	Lorg/java_websocket/drafts/Draft;
    //   69: ifnull +10 -> 79
    //   72: aload_0
    //   73: getfield 126	org/java_websocket/WebSocketImpl:draft	Lorg/java_websocket/drafts/Draft;
    //   76: invokevirtual 582	org/java_websocket/drafts/Draft:reset	()V
    //   79: aload_0
    //   80: aconst_null
    //   81: putfield 130	org/java_websocket/WebSocketImpl:handshakerequest	Lorg/java_websocket/handshake/ClientHandshake;
    //   84: goto -71 -> 13
    //   87: astore_2
    //   88: aload_0
    //   89: monitorexit
    //   90: aload_2
    //   91: athrow
    //   92: astore_2
    //   93: aload_0
    //   94: getfield 152	org/java_websocket/WebSocketImpl:wsl	Lorg/java_websocket/WebSocketListener;
    //   97: aload_0
    //   98: aload_2
    //   99: invokeinterface 212 3 0
    //   104: goto -39 -> 65
    //
    // Exception table:
    //   from	to	target	type
    //   2	8	87	finally
    //   16	52	87	finally
    //   52	65	87	finally
    //   65	79	87	finally
    //   79	84	87	finally
    //   93	104	87	finally
    //   52	65	92	java/lang/RuntimeException
  }

  public Draft getDraft()
  {
    return this.draft;
  }

  public InetSocketAddress getLocalSocketAddress()
  {
    return this.wsl.getLocalSocketAddress(this);
  }

  public WebSocket.READYSTATE getReadyState()
  {
    return this.readystate;
  }

  public InetSocketAddress getRemoteSocketAddress()
  {
    return this.wsl.getRemoteSocketAddress(this);
  }

  public boolean hasBufferedData()
  {
    return !this.outQueue.isEmpty();
  }

  public int hashCode()
  {
    return super.hashCode();
  }

  public boolean isClosed()
  {
    return this.readystate == WebSocket.READYSTATE.CLOSED;
  }

  public boolean isClosing()
  {
    return this.readystate == WebSocket.READYSTATE.CLOSING;
  }

  public boolean isConnecting()
  {
    if (($assertionsDisabled) || (!this.flushandclosestate) || (this.readystate == WebSocket.READYSTATE.CONNECTING))
    {
      if (this.readystate == WebSocket.READYSTATE.CONNECTING)
        return true;
    }
    else
      throw new AssertionError();
    return false;
  }

  public boolean isFlushAndClose()
  {
    return this.flushandclosestate;
  }

  public boolean isOpen()
  {
    if (($assertionsDisabled) || (this.readystate != WebSocket.READYSTATE.OPEN) || (!this.flushandclosestate))
    {
      if (this.readystate == WebSocket.READYSTATE.OPEN)
        return true;
    }
    else
      throw new AssertionError();
    return false;
  }

  public void send(String paramString)
    throws WebsocketNotConnectedException
  {
    if (paramString == null)
      throw new IllegalArgumentException("Cannot send 'null' data to a WebSocketImpl.");
    Draft localDraft = this.draft;
    if (this.role == WebSocket.Role.CLIENT);
    for (boolean bool = true; ; bool = false)
    {
      send(localDraft.createFrames(paramString, bool));
      return;
    }
  }

  public void send(ByteBuffer paramByteBuffer)
    throws IllegalArgumentException, WebsocketNotConnectedException
  {
    if (paramByteBuffer == null)
      throw new IllegalArgumentException("Cannot send 'null' data to a WebSocketImpl.");
    Draft localDraft = this.draft;
    if (this.role == WebSocket.Role.CLIENT);
    for (boolean bool = true; ; bool = false)
    {
      send(localDraft.createFrames(paramByteBuffer, bool));
      return;
    }
  }

  public void send(byte[] paramArrayOfByte)
    throws IllegalArgumentException, WebsocketNotConnectedException
  {
    send(ByteBuffer.wrap(paramArrayOfByte));
  }

  public void sendFrame(Framedata paramFramedata)
  {
    if (DEBUG)
      System.out.println("send frame: " + paramFramedata);
    write(this.draft.createBinaryFrame(paramFramedata));
  }

  public void startHandshake(ClientHandshakeBuilder paramClientHandshakeBuilder)
    throws InvalidHandshakeException
  {
    assert (this.readystate != WebSocket.READYSTATE.CONNECTING) : "shall only be called once";
    this.handshakerequest = this.draft.postProcessHandshakeRequestAsClient(paramClientHandshakeBuilder);
    try
    {
      this.wsl.onWebsocketHandshakeSentAsClient(this, this.handshakerequest);
      write(this.draft.createHandshake(this.handshakerequest, this.role));
      return;
    }
    catch (InvalidDataException paramClientHandshakeBuilder)
    {
      throw new InvalidHandshakeException("Handshake data rejected by client.");
    }
    catch (RuntimeException paramClientHandshakeBuilder)
    {
      this.wsl.onWebsocketError(this, paramClientHandshakeBuilder);
    }
    throw new InvalidHandshakeException("rejected because of" + paramClientHandshakeBuilder);
  }

  public String toString()
  {
    return super.toString();
  }
}

/* Location:           C:\Users\c_jealom1\Documents\Scripts\Android\Fathom_com.brynk.fathom\Fathom_com.brynk.fathom-dex2jar.jar
 * Qualified Name:     org.java_websocket.WebSocketImpl
 * JD-Core Version:    0.6.0
 */
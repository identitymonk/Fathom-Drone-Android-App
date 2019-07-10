package org.java_websocket.handshake;

public class HandshakeImpl1Server extends HandshakedataImpl1
  implements ServerHandshakeBuilder
{
  private short httpstatus;
  private String httpstatusmessage;

  public short getHttpStatus()
  {
    return this.httpstatus;
  }

  public String getHttpStatusMessage()
  {
    return this.httpstatusmessage;
  }

  public void setHttpStatus(short paramShort)
  {
    this.httpstatus = paramShort;
  }

  public void setHttpStatusMessage(String paramString)
  {
    this.httpstatusmessage = paramString;
  }
}

/* Location:           C:\Users\c_jealom1\Documents\Scripts\Android\Fathom_com.brynk.fathom\Fathom_com.brynk.fathom-dex2jar.jar
 * Qualified Name:     org.java_websocket.handshake.HandshakeImpl1Server
 * JD-Core Version:    0.6.0
 */
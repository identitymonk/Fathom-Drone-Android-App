package org.java_websocket.handshake;

public abstract interface ServerHandshake extends Handshakedata
{
  public abstract short getHttpStatus();

  public abstract String getHttpStatusMessage();
}

/* Location:           C:\Users\c_jealom1\Documents\Scripts\Android\Fathom_com.brynk.fathom\Fathom_com.brynk.fathom-dex2jar.jar
 * Qualified Name:     org.java_websocket.handshake.ServerHandshake
 * JD-Core Version:    0.6.0
 */
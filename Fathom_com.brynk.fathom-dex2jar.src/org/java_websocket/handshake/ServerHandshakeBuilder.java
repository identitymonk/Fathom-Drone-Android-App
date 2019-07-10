package org.java_websocket.handshake;

public abstract interface ServerHandshakeBuilder extends HandshakeBuilder, ServerHandshake
{
  public abstract void setHttpStatus(short paramShort);

  public abstract void setHttpStatusMessage(String paramString);
}

/* Location:           C:\Users\c_jealom1\Documents\Scripts\Android\Fathom_com.brynk.fathom\Fathom_com.brynk.fathom-dex2jar.jar
 * Qualified Name:     org.java_websocket.handshake.ServerHandshakeBuilder
 * JD-Core Version:    0.6.0
 */
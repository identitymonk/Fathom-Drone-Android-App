package org.java_websocket.handshake;

import java.util.Iterator;

public abstract interface Handshakedata
{
  public abstract byte[] getContent();

  public abstract String getFieldValue(String paramString);

  public abstract boolean hasFieldValue(String paramString);

  public abstract Iterator<String> iterateHttpFields();
}

/* Location:           C:\Users\c_jealom1\Documents\Scripts\Android\Fathom_com.brynk.fathom\Fathom_com.brynk.fathom-dex2jar.jar
 * Qualified Name:     org.java_websocket.handshake.Handshakedata
 * JD-Core Version:    0.6.0
 */
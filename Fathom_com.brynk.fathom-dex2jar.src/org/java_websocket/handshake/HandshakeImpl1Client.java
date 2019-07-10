package org.java_websocket.handshake;

public class HandshakeImpl1Client extends HandshakedataImpl1
  implements ClientHandshakeBuilder
{
  private String resourcedescriptor;

  public String getResourceDescriptor()
  {
    return this.resourcedescriptor;
  }

  public void setResourceDescriptor(String paramString)
    throws IllegalArgumentException
  {
    this.resourcedescriptor = paramString;
  }
}

/* Location:           C:\Users\c_jealom1\Documents\Scripts\Android\Fathom_com.brynk.fathom\Fathom_com.brynk.fathom-dex2jar.jar
 * Qualified Name:     org.java_websocket.handshake.HandshakeImpl1Client
 * JD-Core Version:    0.6.0
 */
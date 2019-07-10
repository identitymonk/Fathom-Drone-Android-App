package org.java_websocket.exceptions;

public class IncompleteHandshakeException extends RuntimeException
{
  private static final long serialVersionUID = 7906596804233893092L;
  private int newsize;

  public IncompleteHandshakeException()
  {
    this.newsize = 0;
  }

  public IncompleteHandshakeException(int paramInt)
  {
    this.newsize = paramInt;
  }

  public int getPreferedSize()
  {
    return this.newsize;
  }
}

/* Location:           C:\Users\c_jealom1\Documents\Scripts\Android\Fathom_com.brynk.fathom\Fathom_com.brynk.fathom-dex2jar.jar
 * Qualified Name:     org.java_websocket.exceptions.IncompleteHandshakeException
 * JD-Core Version:    0.6.0
 */
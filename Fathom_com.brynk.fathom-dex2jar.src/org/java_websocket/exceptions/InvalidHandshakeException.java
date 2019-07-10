package org.java_websocket.exceptions;

public class InvalidHandshakeException extends InvalidDataException
{
  private static final long serialVersionUID = -1426533877490484964L;

  public InvalidHandshakeException()
  {
    super(1002);
  }

  public InvalidHandshakeException(String paramString)
  {
    super(1002, paramString);
  }

  public InvalidHandshakeException(String paramString, Throwable paramThrowable)
  {
    super(1002, paramString, paramThrowable);
  }

  public InvalidHandshakeException(Throwable paramThrowable)
  {
    super(1002, paramThrowable);
  }
}

/* Location:           C:\Users\c_jealom1\Documents\Scripts\Android\Fathom_com.brynk.fathom\Fathom_com.brynk.fathom-dex2jar.jar
 * Qualified Name:     org.java_websocket.exceptions.InvalidHandshakeException
 * JD-Core Version:    0.6.0
 */
package org.java_websocket.exceptions;

public class InvalidFrameException extends InvalidDataException
{
  private static final long serialVersionUID = -9016496369828887591L;

  public InvalidFrameException()
  {
    super(1002);
  }

  public InvalidFrameException(String paramString)
  {
    super(1002, paramString);
  }

  public InvalidFrameException(String paramString, Throwable paramThrowable)
  {
    super(1002, paramString, paramThrowable);
  }

  public InvalidFrameException(Throwable paramThrowable)
  {
    super(1002, paramThrowable);
  }
}

/* Location:           C:\Users\c_jealom1\Documents\Scripts\Android\Fathom_com.brynk.fathom\Fathom_com.brynk.fathom-dex2jar.jar
 * Qualified Name:     org.java_websocket.exceptions.InvalidFrameException
 * JD-Core Version:    0.6.0
 */
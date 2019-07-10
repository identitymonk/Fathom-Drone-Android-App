package org.java_websocket.exceptions;

public class LimitExedeedException extends InvalidDataException
{
  private static final long serialVersionUID = 6908339749836826785L;

  public LimitExedeedException()
  {
    super(1009);
  }

  public LimitExedeedException(String paramString)
  {
    super(1009, paramString);
  }
}

/* Location:           C:\Users\c_jealom1\Documents\Scripts\Android\Fathom_com.brynk.fathom\Fathom_com.brynk.fathom-dex2jar.jar
 * Qualified Name:     org.java_websocket.exceptions.LimitExedeedException
 * JD-Core Version:    0.6.0
 */
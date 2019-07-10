package okhttp3.internal.http2;

import java.io.IOException;

public final class StreamResetException extends IOException
{
  public final ErrorCode errorCode;

  public StreamResetException(ErrorCode paramErrorCode)
  {
    super("stream was reset: " + paramErrorCode);
    this.errorCode = paramErrorCode;
  }
}

/* Location:           C:\Users\c_jealom1\Documents\Scripts\Android\Fathom_com.brynk.fathom\Fathom_com.brynk.fathom-dex2jar.jar
 * Qualified Name:     okhttp3.internal.http2.StreamResetException
 * JD-Core Version:    0.6.0
 */
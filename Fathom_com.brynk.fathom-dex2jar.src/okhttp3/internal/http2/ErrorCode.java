package okhttp3.internal.http2;

public enum ErrorCode
{
  public final int httpCode;

  static
  {
    INTERNAL_ERROR = new ErrorCode("INTERNAL_ERROR", 2, 2);
    FLOW_CONTROL_ERROR = new ErrorCode("FLOW_CONTROL_ERROR", 3, 3);
    REFUSED_STREAM = new ErrorCode("REFUSED_STREAM", 4, 7);
    CANCEL = new ErrorCode("CANCEL", 5, 8);
    $VALUES = new ErrorCode[] { NO_ERROR, PROTOCOL_ERROR, INTERNAL_ERROR, FLOW_CONTROL_ERROR, REFUSED_STREAM, CANCEL };
  }

  private ErrorCode(int paramInt)
  {
    this.httpCode = paramInt;
  }

  public static ErrorCode fromHttp2(int paramInt)
  {
    ErrorCode[] arrayOfErrorCode = values();
    int j = arrayOfErrorCode.length;
    int i = 0;
    while (i < j)
    {
      ErrorCode localErrorCode = arrayOfErrorCode[i];
      if (localErrorCode.httpCode == paramInt)
        return localErrorCode;
      i += 1;
    }
    return null;
  }
}

/* Location:           C:\Users\c_jealom1\Documents\Scripts\Android\Fathom_com.brynk.fathom\Fathom_com.brynk.fathom-dex2jar.jar
 * Qualified Name:     okhttp3.internal.http2.ErrorCode
 * JD-Core Version:    0.6.0
 */
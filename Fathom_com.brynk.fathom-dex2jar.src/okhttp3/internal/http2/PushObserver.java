package okhttp3.internal.http2;

import java.io.IOException;
import java.util.List;
import okio.BufferedSource;

public abstract interface PushObserver
{
  public static final PushObserver CANCEL = new PushObserver()
  {
    public boolean onData(int paramInt1, BufferedSource paramBufferedSource, int paramInt2, boolean paramBoolean)
      throws IOException
    {
      paramBufferedSource.skip(paramInt2);
      return true;
    }

    public boolean onHeaders(int paramInt, List<Header> paramList, boolean paramBoolean)
    {
      return true;
    }

    public boolean onRequest(int paramInt, List<Header> paramList)
    {
      return true;
    }

    public void onReset(int paramInt, ErrorCode paramErrorCode)
    {
    }
  };

  public abstract boolean onData(int paramInt1, BufferedSource paramBufferedSource, int paramInt2, boolean paramBoolean)
    throws IOException;

  public abstract boolean onHeaders(int paramInt, List<Header> paramList, boolean paramBoolean);

  public abstract boolean onRequest(int paramInt, List<Header> paramList);

  public abstract void onReset(int paramInt, ErrorCode paramErrorCode);
}

/* Location:           C:\Users\c_jealom1\Documents\Scripts\Android\Fathom_com.brynk.fathom\Fathom_com.brynk.fathom-dex2jar.jar
 * Qualified Name:     okhttp3.internal.http2.PushObserver
 * JD-Core Version:    0.6.0
 */
package okhttp3.internal.cache;

import java.io.IOException;
import okio.Buffer;
import okio.ForwardingSink;
import okio.Sink;

class FaultHidingSink extends ForwardingSink
{
  private boolean hasErrors;

  public FaultHidingSink(Sink paramSink)
  {
    super(paramSink);
  }

  public void close()
    throws IOException
  {
    if (this.hasErrors)
      return;
    try
    {
      super.close();
      return;
    }
    catch (IOException localIOException)
    {
      this.hasErrors = true;
      onException(localIOException);
    }
  }

  public void flush()
    throws IOException
  {
    if (this.hasErrors)
      return;
    try
    {
      super.flush();
      return;
    }
    catch (IOException localIOException)
    {
      this.hasErrors = true;
      onException(localIOException);
    }
  }

  protected void onException(IOException paramIOException)
  {
  }

  public void write(Buffer paramBuffer, long paramLong)
    throws IOException
  {
    if (this.hasErrors)
    {
      paramBuffer.skip(paramLong);
      return;
    }
    try
    {
      super.write(paramBuffer, paramLong);
      return;
    }
    catch (IOException paramBuffer)
    {
      this.hasErrors = true;
      onException(paramBuffer);
    }
  }
}

/* Location:           C:\Users\c_jealom1\Documents\Scripts\Android\Fathom_com.brynk.fathom\Fathom_com.brynk.fathom-dex2jar.jar
 * Qualified Name:     okhttp3.internal.cache.FaultHidingSink
 * JD-Core Version:    0.6.0
 */
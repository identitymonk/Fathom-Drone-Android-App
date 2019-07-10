package okhttp3;

import java.io.IOException;

public abstract interface Call extends Cloneable
{
  public abstract void cancel();

  public abstract Call clone();

  public abstract void enqueue(Callback paramCallback);

  public abstract Response execute()
    throws IOException;

  public abstract boolean isCanceled();

  public abstract boolean isExecuted();

  public abstract Request request();

  public static abstract interface Factory
  {
    public abstract Call newCall(Request paramRequest);
  }
}

/* Location:           C:\Users\c_jealom1\Documents\Scripts\Android\Fathom_com.brynk.fathom\Fathom_com.brynk.fathom-dex2jar.jar
 * Qualified Name:     okhttp3.Call
 * JD-Core Version:    0.6.0
 */
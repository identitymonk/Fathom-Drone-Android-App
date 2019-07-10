package okhttp3;

import java.io.IOException;

public abstract interface Interceptor
{
  public abstract Response intercept(Chain paramChain)
    throws IOException;

  public static abstract interface Chain
  {
    public abstract Connection connection();

    public abstract Response proceed(Request paramRequest)
      throws IOException;

    public abstract Request request();
  }
}

/* Location:           C:\Users\c_jealom1\Documents\Scripts\Android\Fathom_com.brynk.fathom\Fathom_com.brynk.fathom-dex2jar.jar
 * Qualified Name:     okhttp3.Interceptor
 * JD-Core Version:    0.6.0
 */
package okhttp3;

import java.net.Socket;

public abstract interface Connection
{
  public abstract Handshake handshake();

  public abstract Protocol protocol();

  public abstract Route route();

  public abstract Socket socket();
}

/* Location:           C:\Users\c_jealom1\Documents\Scripts\Android\Fathom_com.brynk.fathom\Fathom_com.brynk.fathom-dex2jar.jar
 * Qualified Name:     okhttp3.Connection
 * JD-Core Version:    0.6.0
 */
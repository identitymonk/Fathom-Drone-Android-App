package okhttp3;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.Arrays;
import java.util.List;

public abstract interface Dns
{
  public static final Dns SYSTEM = new Dns()
  {
    public List<InetAddress> lookup(String paramString)
      throws UnknownHostException
    {
      if (paramString == null)
        throw new UnknownHostException("hostname == null");
      return Arrays.asList(InetAddress.getAllByName(paramString));
    }
  };

  public abstract List<InetAddress> lookup(String paramString)
    throws UnknownHostException;
}

/* Location:           C:\Users\c_jealom1\Documents\Scripts\Android\Fathom_com.brynk.fathom\Fathom_com.brynk.fathom-dex2jar.jar
 * Qualified Name:     okhttp3.Dns
 * JD-Core Version:    0.6.0
 */
package okhttp3.internal;

import java.io.IOException;
import java.net.URL;

public abstract interface URLFilter
{
  public abstract void checkURLPermitted(URL paramURL)
    throws IOException;
}

/* Location:           C:\Users\c_jealom1\Documents\Scripts\Android\Fathom_com.brynk.fathom\Fathom_com.brynk.fathom-dex2jar.jar
 * Qualified Name:     okhttp3.internal.URLFilter
 * JD-Core Version:    0.6.0
 */
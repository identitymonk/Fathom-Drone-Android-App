package okhttp3;

import java.util.Collections;
import java.util.List;

public abstract interface CookieJar
{
  public static final CookieJar NO_COOKIES = new CookieJar()
  {
    public List<Cookie> loadForRequest(HttpUrl paramHttpUrl)
    {
      return Collections.emptyList();
    }

    public void saveFromResponse(HttpUrl paramHttpUrl, List<Cookie> paramList)
    {
    }
  };

  public abstract List<Cookie> loadForRequest(HttpUrl paramHttpUrl);

  public abstract void saveFromResponse(HttpUrl paramHttpUrl, List<Cookie> paramList);
}

/* Location:           C:\Users\c_jealom1\Documents\Scripts\Android\Fathom_com.brynk.fathom\Fathom_com.brynk.fathom-dex2jar.jar
 * Qualified Name:     okhttp3.CookieJar
 * JD-Core Version:    0.6.0
 */
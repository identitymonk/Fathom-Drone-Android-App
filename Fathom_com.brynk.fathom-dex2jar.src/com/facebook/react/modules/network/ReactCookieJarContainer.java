package com.facebook.react.modules.network;

import java.util.Collections;
import java.util.List;
import javax.annotation.Nullable;
import okhttp3.Cookie;
import okhttp3.CookieJar;
import okhttp3.HttpUrl;

public class ReactCookieJarContainer
  implements CookieJarContainer
{

  @Nullable
  private CookieJar cookieJar = null;

  public List<Cookie> loadForRequest(HttpUrl paramHttpUrl)
  {
    if (this.cookieJar != null)
      return this.cookieJar.loadForRequest(paramHttpUrl);
    return Collections.emptyList();
  }

  public void removeCookieJar()
  {
    this.cookieJar = null;
  }

  public void saveFromResponse(HttpUrl paramHttpUrl, List<Cookie> paramList)
  {
    if (this.cookieJar != null)
      this.cookieJar.saveFromResponse(paramHttpUrl, paramList);
  }

  public void setCookieJar(CookieJar paramCookieJar)
  {
    this.cookieJar = paramCookieJar;
  }
}

/* Location:           C:\Users\c_jealom1\Documents\Scripts\Android\Fathom_com.brynk.fathom\Fathom_com.brynk.fathom-dex2jar.jar
 * Qualified Name:     com.facebook.react.modules.network.ReactCookieJarContainer
 * JD-Core Version:    0.6.0
 */
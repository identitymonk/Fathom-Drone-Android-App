package com.facebook.react.modules.network;

import android.annotation.TargetApi;
import android.content.Context;
import android.os.Build.VERSION;
import android.os.Handler;
import android.os.Handler.Callback;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import android.webkit.CookieManager;
import android.webkit.CookieSyncManager;
import android.webkit.ValueCallback;
import com.facebook.react.bridge.Callback;
import com.facebook.react.bridge.GuardedAsyncTask;
import com.facebook.react.bridge.GuardedResultAsyncTask;
import com.facebook.react.bridge.ReactContext;
import java.io.IOException;
import java.net.CookieHandler;
import java.net.URI;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import javax.annotation.Nullable;

public class ForwardingCookieHandler extends CookieHandler
{
  private static final String COOKIE_HEADER = "Cookie";
  private static final boolean USES_LEGACY_STORE;
  private static final String VERSION_ONE_HEADER = "Set-cookie2";
  private static final String VERSION_ZERO_HEADER = "Set-cookie";
  private final ReactContext mContext;

  @Nullable
  private CookieManager mCookieManager;
  private final CookieSaver mCookieSaver;

  static
  {
    if (Build.VERSION.SDK_INT < 21);
    for (boolean bool = true; ; bool = false)
    {
      USES_LEGACY_STORE = bool;
      return;
    }
  }

  public ForwardingCookieHandler(ReactContext paramReactContext)
  {
    this.mContext = paramReactContext;
    this.mCookieSaver = new CookieSaver();
  }

  @TargetApi(21)
  private void addCookieAsync(String paramString1, String paramString2)
  {
    getCookieManager().setCookie(paramString1, paramString2, null);
  }

  private void addCookies(String paramString, List<String> paramList)
  {
    if (USES_LEGACY_STORE)
    {
      runInBackground(new Runnable(paramList, paramString)
      {
        public void run()
        {
          Iterator localIterator = this.val$cookies.iterator();
          while (localIterator.hasNext())
          {
            String str = (String)localIterator.next();
            ForwardingCookieHandler.this.getCookieManager().setCookie(this.val$url, str);
          }
          ForwardingCookieHandler.this.mCookieSaver.onCookiesModified();
        }
      });
      return;
    }
    paramList = paramList.iterator();
    while (paramList.hasNext())
      addCookieAsync(paramString, (String)paramList.next());
    this.mCookieSaver.onCookiesModified();
  }

  private void clearCookiesAsync(Callback paramCallback)
  {
    getCookieManager().removeAllCookies(new ValueCallback(paramCallback)
    {
      public void onReceiveValue(Boolean paramBoolean)
      {
        ForwardingCookieHandler.this.mCookieSaver.onCookiesModified();
        this.val$callback.invoke(new Object[] { paramBoolean });
      }
    });
  }

  private CookieManager getCookieManager()
  {
    if (this.mCookieManager == null)
    {
      possiblyWorkaroundSyncManager(this.mContext);
      this.mCookieManager = CookieManager.getInstance();
      if (USES_LEGACY_STORE)
        this.mCookieManager.removeExpiredCookie();
    }
    return this.mCookieManager;
  }

  private static boolean isCookieHeader(String paramString)
  {
    return (paramString.equalsIgnoreCase("Set-cookie")) || (paramString.equalsIgnoreCase("Set-cookie2"));
  }

  private static void possiblyWorkaroundSyncManager(Context paramContext)
  {
    if (USES_LEGACY_STORE)
      CookieSyncManager.createInstance(paramContext).sync();
  }

  private void runInBackground(Runnable paramRunnable)
  {
    new GuardedAsyncTask(this.mContext, paramRunnable)
    {
      protected void doInBackgroundGuarded(Void[] paramArrayOfVoid)
      {
        this.val$runnable.run();
      }
    }
    .execute(new Void[0]);
  }

  public void clearCookies(Callback paramCallback)
  {
    if (USES_LEGACY_STORE)
    {
      new GuardedResultAsyncTask(this.mContext, paramCallback)
      {
        protected Boolean doInBackgroundGuarded()
        {
          ForwardingCookieHandler.this.getCookieManager().removeAllCookie();
          ForwardingCookieHandler.this.mCookieSaver.onCookiesModified();
          return Boolean.valueOf(true);
        }

        protected void onPostExecuteGuarded(Boolean paramBoolean)
        {
          this.val$callback.invoke(new Object[] { paramBoolean });
        }
      }
      .execute(new Void[0]);
      return;
    }
    clearCookiesAsync(paramCallback);
  }

  public void destroy()
  {
    if (USES_LEGACY_STORE)
    {
      getCookieManager().removeExpiredCookie();
      this.mCookieSaver.persistCookies();
    }
  }

  public Map<String, List<String>> get(URI paramURI, Map<String, List<String>> paramMap)
    throws IOException
  {
    paramURI = getCookieManager().getCookie(paramURI.toString());
    if (TextUtils.isEmpty(paramURI))
      return Collections.emptyMap();
    return Collections.singletonMap("Cookie", Collections.singletonList(paramURI));
  }

  public void put(URI paramURI, Map<String, List<String>> paramMap)
    throws IOException
  {
    paramURI = paramURI.toString();
    paramMap = paramMap.entrySet().iterator();
    while (paramMap.hasNext())
    {
      Map.Entry localEntry = (Map.Entry)paramMap.next();
      String str = (String)localEntry.getKey();
      if ((str == null) || (!isCookieHeader(str)))
        continue;
      addCookies(paramURI, (List)localEntry.getValue());
    }
  }

  private class CookieSaver
  {
    private static final int MSG_PERSIST_COOKIES = 1;
    private static final int TIMEOUT = 30000;
    private final Handler mHandler = new Handler(Looper.getMainLooper(), new Handler.Callback(ForwardingCookieHandler.this)
    {
      public boolean handleMessage(Message paramMessage)
      {
        if (paramMessage.what == 1)
        {
          ForwardingCookieHandler.CookieSaver.this.persistCookies();
          return true;
        }
        return false;
      }
    });

    public CookieSaver()
    {
    }

    @TargetApi(21)
    private void flush()
    {
      ForwardingCookieHandler.this.getCookieManager().flush();
    }

    public void onCookiesModified()
    {
      if (ForwardingCookieHandler.USES_LEGACY_STORE)
        this.mHandler.sendEmptyMessageDelayed(1, 30000L);
    }

    public void persistCookies()
    {
      this.mHandler.removeMessages(1);
      ForwardingCookieHandler.this.runInBackground(new Runnable()
      {
        public void run()
        {
          if (ForwardingCookieHandler.USES_LEGACY_STORE)
          {
            CookieSyncManager.getInstance().sync();
            return;
          }
          ForwardingCookieHandler.CookieSaver.this.flush();
        }
      });
    }
  }
}

/* Location:           C:\Users\c_jealom1\Documents\Scripts\Android\Fathom_com.brynk.fathom\Fathom_com.brynk.fathom-dex2jar.jar
 * Qualified Name:     com.facebook.react.modules.network.ForwardingCookieHandler
 * JD-Core Version:    0.6.0
 */
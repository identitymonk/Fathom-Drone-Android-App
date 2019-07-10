package com.facebook.react.views.webview;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Picture;
import android.net.Uri;
import android.os.Build.VERSION;
import android.text.TextUtils;
import android.view.ViewGroup.LayoutParams;
import android.webkit.ConsoleMessage;
import android.webkit.CookieManager;
import android.webkit.GeolocationPermissions.Callback;
import android.webkit.JavascriptInterface;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebView.PictureListener;
import android.webkit.WebViewClient;
import com.facebook.common.logging.FLog;
import com.facebook.react.bridge.Arguments;
import com.facebook.react.bridge.LifecycleEventListener;
import com.facebook.react.bridge.ReactContext;
import com.facebook.react.bridge.ReadableArray;
import com.facebook.react.bridge.ReadableMap;
import com.facebook.react.bridge.ReadableMapKeySetIterator;
import com.facebook.react.bridge.WritableMap;
import com.facebook.react.common.MapBuilder;
import com.facebook.react.module.annotations.ReactModule;
import com.facebook.react.uimanager.SimpleViewManager;
import com.facebook.react.uimanager.ThemedReactContext;
import com.facebook.react.uimanager.UIManagerModule;
import com.facebook.react.uimanager.annotations.ReactProp;
import com.facebook.react.uimanager.events.ContentSizeChangeEvent;
import com.facebook.react.uimanager.events.Event;
import com.facebook.react.uimanager.events.EventDispatcher;
import com.facebook.react.views.webview.events.TopLoadingErrorEvent;
import com.facebook.react.views.webview.events.TopLoadingFinishEvent;
import com.facebook.react.views.webview.events.TopLoadingStartEvent;
import com.facebook.react.views.webview.events.TopMessageEvent;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Locale;
import java.util.Map;
import javax.annotation.Nullable;
import org.json.JSONObject;

@ReactModule(name="RCTWebView")
public class ReactWebViewManager extends SimpleViewManager<WebView>
{
  protected static final String BLANK_URL = "about:blank";
  protected static final String BRIDGE_NAME = "__REACT_WEB_VIEW_BRIDGE";
  public static final int COMMAND_GO_BACK = 1;
  public static final int COMMAND_GO_FORWARD = 2;
  public static final int COMMAND_INJECT_JAVASCRIPT = 6;
  public static final int COMMAND_POST_MESSAGE = 5;
  public static final int COMMAND_RELOAD = 3;
  public static final int COMMAND_STOP_LOADING = 4;
  protected static final String HTML_ENCODING = "UTF-8";
  protected static final String HTML_MIME_TYPE = "text/html";
  protected static final String HTTP_METHOD_POST = "POST";
  protected static final String REACT_CLASS = "RCTWebView";

  @Nullable
  protected WebView.PictureListener mPictureListener;
  protected WebViewConfig mWebViewConfig;

  public ReactWebViewManager()
  {
    this.mWebViewConfig = new WebViewConfig()
    {
      public void configWebView(WebView paramWebView)
      {
      }
    };
  }

  public ReactWebViewManager(WebViewConfig paramWebViewConfig)
  {
    this.mWebViewConfig = paramWebViewConfig;
  }

  protected static void dispatchEvent(WebView paramWebView, Event paramEvent)
  {
    ((UIManagerModule)((ReactContext)paramWebView.getContext()).getNativeModule(UIManagerModule.class)).getEventDispatcher().dispatchEvent(paramEvent);
  }

  protected void addEventEmitters(ThemedReactContext paramThemedReactContext, WebView paramWebView)
  {
    paramWebView.setWebViewClient(new ReactWebViewClient());
  }

  protected ReactWebView createReactWebViewInstance(ThemedReactContext paramThemedReactContext)
  {
    return new ReactWebView(paramThemedReactContext);
  }

  protected WebView createViewInstance(ThemedReactContext paramThemedReactContext)
  {
    ReactWebView localReactWebView = createReactWebViewInstance(paramThemedReactContext);
    localReactWebView.setWebChromeClient(new WebChromeClient()
    {
      public boolean onConsoleMessage(ConsoleMessage paramConsoleMessage)
      {
        return true;
      }

      public void onGeolocationPermissionsShowPrompt(String paramString, GeolocationPermissions.Callback paramCallback)
      {
        paramCallback.invoke(paramString, true, false);
      }
    });
    paramThemedReactContext.addLifecycleEventListener(localReactWebView);
    this.mWebViewConfig.configWebView(localReactWebView);
    localReactWebView.getSettings().setBuiltInZoomControls(true);
    localReactWebView.getSettings().setDisplayZoomControls(false);
    localReactWebView.getSettings().setDomStorageEnabled(true);
    localReactWebView.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
    return localReactWebView;
  }

  @Nullable
  public Map<String, Integer> getCommandsMap()
  {
    return MapBuilder.of("goBack", Integer.valueOf(1), "goForward", Integer.valueOf(2), "reload", Integer.valueOf(3), "stopLoading", Integer.valueOf(4), "postMessage", Integer.valueOf(5), "injectJavaScript", Integer.valueOf(6));
  }

  public String getName()
  {
    return "RCTWebView";
  }

  protected WebView.PictureListener getPictureListener()
  {
    if (this.mPictureListener == null)
      this.mPictureListener = new WebView.PictureListener()
      {
        public void onNewPicture(WebView paramWebView, Picture paramPicture)
        {
          ReactWebViewManager.dispatchEvent(paramWebView, new ContentSizeChangeEvent(paramWebView.getId(), paramWebView.getWidth(), paramWebView.getContentHeight()));
        }
      };
    return this.mPictureListener;
  }

  public void onDropViewInstance(WebView paramWebView)
  {
    super.onDropViewInstance(paramWebView);
    ((ThemedReactContext)paramWebView.getContext()).removeLifecycleEventListener((ReactWebView)paramWebView);
    ((ReactWebView)paramWebView).cleanupCallbacksAndDestroy();
  }

  public void receiveCommand(WebView paramWebView, int paramInt, @Nullable ReadableArray paramReadableArray)
  {
    switch (paramInt)
    {
    default:
      return;
    case 1:
      paramWebView.goBack();
      return;
    case 2:
      paramWebView.goForward();
      return;
    case 3:
      paramWebView.reload();
      return;
    case 4:
      paramWebView.stopLoading();
      return;
    case 5:
      try
      {
        JSONObject localJSONObject = new JSONObject();
        localJSONObject.put("data", paramReadableArray.getString(0));
        paramWebView.loadUrl("javascript:(function () {var event;var data = " + localJSONObject.toString() + ";" + "try {" + "event = new MessageEvent('message', data);" + "} catch (e) {" + "event = document.createEvent('MessageEvent');" + "event.initMessageEvent('message', true, true, data.data, data.origin, data.lastEventId, data.source);" + "}" + "document.dispatchEvent(event);" + "})();");
        return;
      }
      catch (org.json.JSONException paramWebView)
      {
        throw new RuntimeException(paramWebView);
      }
    case 6:
    }
    paramWebView.loadUrl("javascript:" + paramReadableArray.getString(0));
  }

  @ReactProp(name="allowUniversalAccessFromFileURLs")
  public void setAllowUniversalAccessFromFileURLs(WebView paramWebView, boolean paramBoolean)
  {
    paramWebView.getSettings().setAllowUniversalAccessFromFileURLs(paramBoolean);
  }

  @ReactProp(name="domStorageEnabled")
  public void setDomStorageEnabled(WebView paramWebView, boolean paramBoolean)
  {
    paramWebView.getSettings().setDomStorageEnabled(paramBoolean);
  }

  @ReactProp(name="injectedJavaScript")
  public void setInjectedJavaScript(WebView paramWebView, @Nullable String paramString)
  {
    ((ReactWebView)paramWebView).setInjectedJavaScript(paramString);
  }

  @ReactProp(name="javaScriptEnabled")
  public void setJavaScriptEnabled(WebView paramWebView, boolean paramBoolean)
  {
    paramWebView.getSettings().setJavaScriptEnabled(paramBoolean);
  }

  @ReactProp(name="mediaPlaybackRequiresUserAction")
  public void setMediaPlaybackRequiresUserAction(WebView paramWebView, boolean paramBoolean)
  {
    paramWebView.getSettings().setMediaPlaybackRequiresUserGesture(paramBoolean);
  }

  @ReactProp(name="messagingEnabled")
  public void setMessagingEnabled(WebView paramWebView, boolean paramBoolean)
  {
    ((ReactWebView)paramWebView).setMessagingEnabled(paramBoolean);
  }

  @ReactProp(name="mixedContentMode")
  public void setMixedContentMode(WebView paramWebView, @Nullable String paramString)
  {
    if (Build.VERSION.SDK_INT >= 21)
    {
      if ((paramString != null) && (!"never".equals(paramString)))
        break label31;
      paramWebView.getSettings().setMixedContentMode(1);
    }
    label31: 
    do
    {
      return;
      if (!"always".equals(paramString))
        continue;
      paramWebView.getSettings().setMixedContentMode(0);
      return;
    }
    while (!"compatibility".equals(paramString));
    paramWebView.getSettings().setMixedContentMode(2);
  }

  @ReactProp(name="onContentSizeChange")
  public void setOnContentSizeChange(WebView paramWebView, boolean paramBoolean)
  {
    if (paramBoolean)
    {
      paramWebView.setPictureListener(getPictureListener());
      return;
    }
    paramWebView.setPictureListener(null);
  }

  @ReactProp(name="saveFormDataDisabled")
  public void setSaveFormDataDisabled(WebView paramWebView, boolean paramBoolean)
  {
    paramWebView = paramWebView.getSettings();
    if (!paramBoolean);
    for (paramBoolean = true; ; paramBoolean = false)
    {
      paramWebView.setSaveFormData(paramBoolean);
      return;
    }
  }

  @ReactProp(name="scalesPageToFit")
  public void setScalesPageToFit(WebView paramWebView, boolean paramBoolean)
  {
    paramWebView = paramWebView.getSettings();
    if (!paramBoolean);
    for (paramBoolean = true; ; paramBoolean = false)
    {
      paramWebView.setUseWideViewPort(paramBoolean);
      return;
    }
  }

  @ReactProp(name="source")
  public void setSource(WebView paramWebView, @Nullable ReadableMap paramReadableMap)
  {
    if (paramReadableMap != null)
    {
      Object localObject1;
      if (paramReadableMap.hasKey("html"))
      {
        localObject1 = paramReadableMap.getString("html");
        if (paramReadableMap.hasKey("baseUrl"))
          paramWebView.loadDataWithBaseURL(paramReadableMap.getString("baseUrl"), (String)localObject1, "text/html", "UTF-8", null);
      }
      while (true)
      {
        return;
        paramWebView.loadData((String)localObject1, "text/html", "UTF-8");
        return;
        if (!paramReadableMap.hasKey("uri"))
          break;
        String str1 = paramReadableMap.getString("uri");
        localObject1 = paramWebView.getUrl();
        if ((localObject1 != null) && (((String)localObject1).equals(str1)))
          continue;
        if ((paramReadableMap.hasKey("method")) && (paramReadableMap.getString("method").equals("POST")))
        {
          localObject1 = null;
          if (paramReadableMap.hasKey("body"))
            paramReadableMap = paramReadableMap.getString("body");
          try
          {
            localObject1 = paramReadableMap.getBytes("UTF-8");
            paramReadableMap = (ReadableMap)localObject1;
            if (localObject1 == null)
              paramReadableMap = new byte[0];
            paramWebView.postUrl(str1, paramReadableMap);
            return;
          }
          catch (UnsupportedEncodingException localObject2)
          {
            while (true)
              localObject2 = paramReadableMap.getBytes();
          }
        }
        Object localObject2 = new HashMap();
        if (paramReadableMap.hasKey("headers"))
        {
          paramReadableMap = paramReadableMap.getMap("headers");
          ReadableMapKeySetIterator localReadableMapKeySetIterator = paramReadableMap.keySetIterator();
          while (localReadableMapKeySetIterator.hasNextKey())
          {
            String str2 = localReadableMapKeySetIterator.nextKey();
            if ("user-agent".equals(str2.toLowerCase(Locale.ENGLISH)))
            {
              if (paramWebView.getSettings() == null)
                continue;
              paramWebView.getSettings().setUserAgentString(paramReadableMap.getString(str2));
              continue;
            }
            ((HashMap)localObject2).put(str2, paramReadableMap.getString(str2));
          }
        }
        paramWebView.loadUrl(str1, (Map)localObject2);
        return;
      }
    }
    paramWebView.loadUrl("about:blank");
  }

  @ReactProp(name="thirdPartyCookiesEnabled")
  public void setThirdPartyCookiesEnabled(WebView paramWebView, boolean paramBoolean)
  {
    if (Build.VERSION.SDK_INT >= 21)
      CookieManager.getInstance().setAcceptThirdPartyCookies(paramWebView, paramBoolean);
  }

  @ReactProp(name="urlPrefixesForDefaultIntent")
  public void setUrlPrefixesForDefaultIntent(WebView paramWebView, @Nullable ReadableArray paramReadableArray)
  {
    paramWebView = ((ReactWebView)paramWebView).getReactWebViewClient();
    if ((paramWebView != null) && (paramReadableArray != null))
      paramWebView.setUrlPrefixesForDefaultIntent(paramReadableArray);
  }

  @ReactProp(name="userAgent")
  public void setUserAgent(WebView paramWebView, @Nullable String paramString)
  {
    if (paramString != null)
      paramWebView.getSettings().setUserAgentString(paramString);
  }

  protected static class ReactWebView extends WebView
    implements LifecycleEventListener
  {

    @Nullable
    protected String injectedJS;

    @Nullable
    protected ReactWebViewManager.ReactWebViewClient mReactWebViewClient;
    protected boolean messagingEnabled = false;

    public ReactWebView(ThemedReactContext paramThemedReactContext)
    {
      super();
    }

    public void callInjectedJavaScript()
    {
      if ((getSettings().getJavaScriptEnabled()) && (this.injectedJS != null) && (!TextUtils.isEmpty(this.injectedJS)))
        loadUrl("javascript:(function() {\n" + this.injectedJS + ";\n})();");
    }

    protected void cleanupCallbacksAndDestroy()
    {
      setWebViewClient(null);
      destroy();
    }

    protected ReactWebViewBridge createReactWebViewBridge(ReactWebView paramReactWebView)
    {
      return new ReactWebViewBridge(paramReactWebView);
    }

    @Nullable
    public ReactWebViewManager.ReactWebViewClient getReactWebViewClient()
    {
      return this.mReactWebViewClient;
    }

    public void linkBridge()
    {
      if (this.messagingEnabled)
        loadUrl("javascript:(window.originalPostMessage = window.postMessage,window.postMessage = function(data) {__REACT_WEB_VIEW_BRIDGE.postMessage(String(data));})");
    }

    public void onHostDestroy()
    {
      cleanupCallbacksAndDestroy();
    }

    public void onHostPause()
    {
    }

    public void onHostResume()
    {
    }

    public void onMessage(String paramString)
    {
      ReactWebViewManager.dispatchEvent(this, new TopMessageEvent(getId(), paramString));
    }

    public void setInjectedJavaScript(@Nullable String paramString)
    {
      this.injectedJS = paramString;
    }

    public void setMessagingEnabled(boolean paramBoolean)
    {
      if (this.messagingEnabled == paramBoolean)
        return;
      this.messagingEnabled = paramBoolean;
      if (paramBoolean)
      {
        addJavascriptInterface(createReactWebViewBridge(this), "__REACT_WEB_VIEW_BRIDGE");
        linkBridge();
        return;
      }
      removeJavascriptInterface("__REACT_WEB_VIEW_BRIDGE");
    }

    public void setWebViewClient(WebViewClient paramWebViewClient)
    {
      super.setWebViewClient(paramWebViewClient);
      this.mReactWebViewClient = ((ReactWebViewManager.ReactWebViewClient)paramWebViewClient);
    }

    protected class ReactWebViewBridge
    {
      ReactWebViewManager.ReactWebView mContext;

      ReactWebViewBridge(ReactWebViewManager.ReactWebView arg2)
      {
        Object localObject;
        this.mContext = localObject;
      }

      @JavascriptInterface
      public void postMessage(String paramString)
      {
        this.mContext.onMessage(paramString);
      }
    }
  }

  protected static class ReactWebViewClient extends WebViewClient
  {
    protected boolean mLastLoadFailed = false;

    @Nullable
    protected ReadableArray mUrlPrefixesForDefaultIntent;

    protected WritableMap createWebViewEvent(WebView paramWebView, String paramString)
    {
      WritableMap localWritableMap = Arguments.createMap();
      localWritableMap.putDouble("target", paramWebView.getId());
      localWritableMap.putString("url", paramString);
      if ((!this.mLastLoadFailed) && (paramWebView.getProgress() != 100));
      for (boolean bool = true; ; bool = false)
      {
        localWritableMap.putBoolean("loading", bool);
        localWritableMap.putString("title", paramWebView.getTitle());
        localWritableMap.putBoolean("canGoBack", paramWebView.canGoBack());
        localWritableMap.putBoolean("canGoForward", paramWebView.canGoForward());
        return localWritableMap;
      }
    }

    protected void emitFinishEvent(WebView paramWebView, String paramString)
    {
      ReactWebViewManager.dispatchEvent(paramWebView, new TopLoadingFinishEvent(paramWebView.getId(), createWebViewEvent(paramWebView, paramString)));
    }

    public void onPageFinished(WebView paramWebView, String paramString)
    {
      super.onPageFinished(paramWebView, paramString);
      if (!this.mLastLoadFailed)
      {
        ReactWebViewManager.ReactWebView localReactWebView = (ReactWebViewManager.ReactWebView)paramWebView;
        localReactWebView.callInjectedJavaScript();
        localReactWebView.linkBridge();
        emitFinishEvent(paramWebView, paramString);
      }
    }

    public void onPageStarted(WebView paramWebView, String paramString, Bitmap paramBitmap)
    {
      super.onPageStarted(paramWebView, paramString, paramBitmap);
      this.mLastLoadFailed = false;
      ReactWebViewManager.dispatchEvent(paramWebView, new TopLoadingStartEvent(paramWebView.getId(), createWebViewEvent(paramWebView, paramString)));
    }

    public void onReceivedError(WebView paramWebView, int paramInt, String paramString1, String paramString2)
    {
      super.onReceivedError(paramWebView, paramInt, paramString1, paramString2);
      this.mLastLoadFailed = true;
      emitFinishEvent(paramWebView, paramString2);
      paramString2 = createWebViewEvent(paramWebView, paramString2);
      paramString2.putDouble("code", paramInt);
      paramString2.putString("description", paramString1);
      ReactWebViewManager.dispatchEvent(paramWebView, new TopLoadingErrorEvent(paramWebView.getId(), paramString2));
    }

    public void setUrlPrefixesForDefaultIntent(ReadableArray paramReadableArray)
    {
      this.mUrlPrefixesForDefaultIntent = paramReadableArray;
    }

    public boolean shouldOverrideUrlLoading(WebView paramWebView, String paramString)
    {
      int j = 0;
      int i = j;
      Object localObject;
      if (this.mUrlPrefixesForDefaultIntent != null)
      {
        i = j;
        if (this.mUrlPrefixesForDefaultIntent.size() > 0)
        {
          localObject = this.mUrlPrefixesForDefaultIntent.toArrayList().iterator();
          while (true)
          {
            i = j;
            if (!((Iterator)localObject).hasNext())
              break;
            if (!paramString.startsWith((String)((Iterator)localObject).next()))
              continue;
            i = 1;
          }
        }
      }
      if ((i == 0) && ((paramString.startsWith("http://")) || (paramString.startsWith("https://")) || (paramString.startsWith("file://")) || (paramString.equals("about:blank"))))
        return false;
      try
      {
        localObject = new Intent("android.intent.action.VIEW", Uri.parse(paramString));
        ((Intent)localObject).setFlags(268435456);
        paramWebView.getContext().startActivity((Intent)localObject);
        return true;
      }
      catch (android.content.ActivityNotFoundException paramWebView)
      {
        while (true)
          FLog.w("ReactNative", "activity not found to handle uri scheme for: " + paramString, paramWebView);
      }
    }
  }
}

/* Location:           C:\Users\c_jealom1\Documents\Scripts\Android\Fathom_com.brynk.fathom\Fathom_com.brynk.fathom-dex2jar.jar
 * Qualified Name:     com.facebook.react.views.webview.ReactWebViewManager
 * JD-Core Version:    0.6.0
 */
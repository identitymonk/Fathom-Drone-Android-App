package com.facebook.react.bridge;

import android.content.Context;
import com.facebook.react.common.DebugServerException;

public abstract class JSBundleLoader
{
  public static JSBundleLoader createAssetLoader(Context paramContext, String paramString, boolean paramBoolean)
  {
    return new JSBundleLoader(paramContext, paramString, paramBoolean)
    {
      public String loadScript(CatalystInstanceImpl paramCatalystInstanceImpl)
      {
        paramCatalystInstanceImpl.loadScriptFromAssets(this.val$context.getAssets(), this.val$assetUrl, this.val$loadSynchronously);
        return this.val$assetUrl;
      }
    };
  }

  public static JSBundleLoader createCachedBundleFromNetworkLoader(String paramString1, String paramString2)
  {
    return new JSBundleLoader(paramString2, paramString1)
    {
      public String loadScript(CatalystInstanceImpl paramCatalystInstanceImpl)
      {
        try
        {
          paramCatalystInstanceImpl.loadScriptFromFile(this.val$cachedFileLocation, this.val$sourceURL, false);
          paramCatalystInstanceImpl = this.val$sourceURL;
          return paramCatalystInstanceImpl;
        }
        catch (Exception paramCatalystInstanceImpl)
        {
        }
        throw DebugServerException.makeGeneric(paramCatalystInstanceImpl.getMessage(), paramCatalystInstanceImpl);
      }
    };
  }

  public static JSBundleLoader createFileLoader(String paramString)
  {
    return createFileLoader(paramString, paramString, false);
  }

  public static JSBundleLoader createFileLoader(String paramString1, String paramString2, boolean paramBoolean)
  {
    return new JSBundleLoader(paramString1, paramString2, paramBoolean)
    {
      public String loadScript(CatalystInstanceImpl paramCatalystInstanceImpl)
      {
        paramCatalystInstanceImpl.loadScriptFromFile(this.val$fileName, this.val$assetUrl, this.val$loadSynchronously);
        return this.val$fileName;
      }
    };
  }

  public static JSBundleLoader createRemoteDebuggerBundleLoader(String paramString1, String paramString2)
  {
    return new JSBundleLoader(paramString2, paramString1)
    {
      public String loadScript(CatalystInstanceImpl paramCatalystInstanceImpl)
      {
        paramCatalystInstanceImpl.setSourceURLs(this.val$realSourceURL, this.val$proxySourceURL);
        return this.val$realSourceURL;
      }
    };
  }

  public abstract String loadScript(CatalystInstanceImpl paramCatalystInstanceImpl);
}

/* Location:           C:\Users\c_jealom1\Documents\Scripts\Android\Fathom_com.brynk.fathom\Fathom_com.brynk.fathom-dex2jar.jar
 * Qualified Name:     com.facebook.react.bridge.JSBundleLoader
 * JD-Core Version:    0.6.0
 */
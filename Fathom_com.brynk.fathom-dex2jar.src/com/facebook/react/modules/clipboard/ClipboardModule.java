package com.facebook.react.modules.clipboard;

import android.annotation.SuppressLint;
import android.content.ClipData;
import android.content.ClipData.Item;
import android.content.ClipboardManager;
import android.content.Context;
import android.os.Build.VERSION;
import com.facebook.react.bridge.ContextBaseJavaModule;
import com.facebook.react.bridge.Promise;
import com.facebook.react.bridge.ReactMethod;
import com.facebook.react.module.annotations.ReactModule;

@ReactModule(name="Clipboard")
public class ClipboardModule extends ContextBaseJavaModule
{
  public ClipboardModule(Context paramContext)
  {
    super(paramContext);
  }

  private ClipboardManager getClipboardService()
  {
    Context localContext = getContext();
    getContext();
    return (ClipboardManager)localContext.getSystemService("clipboard");
  }

  public String getName()
  {
    return "Clipboard";
  }

  @ReactMethod
  public void getString(Promise paramPromise)
  {
    try
    {
      Object localObject = getClipboardService();
      ClipData localClipData = ((ClipboardManager)localObject).getPrimaryClip();
      if (localClipData == null)
      {
        paramPromise.resolve("");
        return;
      }
      if (localClipData.getItemCount() >= 1)
      {
        localObject = ((ClipboardManager)localObject).getPrimaryClip().getItemAt(0);
        paramPromise.resolve("" + ((ClipData.Item)localObject).getText());
        return;
      }
    }
    catch (Exception localException)
    {
      paramPromise.reject(localException);
      return;
    }
    paramPromise.resolve("");
  }

  @ReactMethod
  @SuppressLint({"DeprecatedMethod"})
  public void setString(String paramString)
  {
    if (Build.VERSION.SDK_INT >= 11)
    {
      paramString = ClipData.newPlainText(null, paramString);
      getClipboardService().setPrimaryClip(paramString);
      return;
    }
    getClipboardService().setText(paramString);
  }
}

/* Location:           C:\Users\c_jealom1\Documents\Scripts\Android\Fathom_com.brynk.fathom\Fathom_com.brynk.fathom-dex2jar.jar
 * Qualified Name:     com.facebook.react.modules.clipboard.ClipboardModule
 * JD-Core Version:    0.6.0
 */
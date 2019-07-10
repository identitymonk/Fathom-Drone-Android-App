package com.facebook.react.devsupport.interfaces;

import javax.annotation.Nullable;

public abstract interface DevBundleDownloadListener
{
  public abstract void onFailure(Exception paramException);

  public abstract void onProgress(@Nullable String paramString, @Nullable Integer paramInteger1, @Nullable Integer paramInteger2);

  public abstract void onSuccess();
}

/* Location:           C:\Users\c_jealom1\Documents\Scripts\Android\Fathom_com.brynk.fathom\Fathom_com.brynk.fathom-dex2jar.jar
 * Qualified Name:     com.facebook.react.devsupport.interfaces.DevBundleDownloadListener
 * JD-Core Version:    0.6.0
 */
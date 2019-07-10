package com.facebook.react.devsupport;

import android.content.Context;
import com.facebook.react.devsupport.interfaces.DevBundleDownloadListener;
import com.facebook.react.devsupport.interfaces.DevSupportManager;
import java.lang.reflect.Constructor;
import javax.annotation.Nullable;

public class DevSupportManagerFactory
{
  private static final String DEVSUPPORT_IMPL_CLASS = "DevSupportManagerImpl";
  private static final String DEVSUPPORT_IMPL_PACKAGE = "com.facebook.react.devsupport";

  public static DevSupportManager create(Context paramContext, ReactInstanceDevCommandsHandler paramReactInstanceDevCommandsHandler, @Nullable String paramString, boolean paramBoolean, int paramInt)
  {
    return create(paramContext, paramReactInstanceDevCommandsHandler, paramString, paramBoolean, null, null, paramInt);
  }

  public static DevSupportManager create(Context paramContext, ReactInstanceDevCommandsHandler paramReactInstanceDevCommandsHandler, @Nullable String paramString, boolean paramBoolean, @Nullable RedBoxHandler paramRedBoxHandler, @Nullable DevBundleDownloadListener paramDevBundleDownloadListener, int paramInt)
  {
    if (!paramBoolean)
      return new DisabledDevSupportManager();
    try
    {
      paramContext = (DevSupportManager)Class.forName("com.facebook.react.devsupport" + "." + "DevSupportManagerImpl").getConstructor(new Class[] { Context.class, ReactInstanceDevCommandsHandler.class, String.class, Boolean.TYPE, RedBoxHandler.class, DevBundleDownloadListener.class, Integer.TYPE }).newInstance(new Object[] { paramContext, paramReactInstanceDevCommandsHandler, paramString, Boolean.valueOf(true), paramRedBoxHandler, paramDevBundleDownloadListener, Integer.valueOf(paramInt) });
      return paramContext;
    }
    catch (java.lang.Exception paramContext)
    {
    }
    throw new RuntimeException("Requested enabled DevSupportManager, but DevSupportManagerImpl class was not found or could not be created", paramContext);
  }
}

/* Location:           C:\Users\c_jealom1\Documents\Scripts\Android\Fathom_com.brynk.fathom\Fathom_com.brynk.fathom-dex2jar.jar
 * Qualified Name:     com.facebook.react.devsupport.DevSupportManagerFactory
 * JD-Core Version:    0.6.0
 */
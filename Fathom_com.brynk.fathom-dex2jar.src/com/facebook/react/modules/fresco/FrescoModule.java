package com.facebook.react.modules.fresco;

import android.support.annotation.Nullable;
import com.facebook.common.logging.FLog;
import com.facebook.common.soloader.SoLoaderShim;
import com.facebook.common.soloader.SoLoaderShim.Handler;
import com.facebook.drawee.backends.pipeline.Fresco;
import com.facebook.imagepipeline.backends.okhttp3.OkHttpImagePipelineConfigFactory;
import com.facebook.imagepipeline.core.ImagePipeline;
import com.facebook.imagepipeline.core.ImagePipelineConfig;
import com.facebook.imagepipeline.core.ImagePipelineConfig.Builder;
import com.facebook.react.bridge.LifecycleEventListener;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.facebook.react.module.annotations.ReactModule;
import com.facebook.react.modules.common.ModuleDataCleaner.Cleanable;
import com.facebook.react.modules.network.CookieJarContainer;
import com.facebook.react.modules.network.ForwardingCookieHandler;
import com.facebook.react.modules.network.OkHttpClientProvider;
import com.facebook.soloader.SoLoader;
import java.util.HashSet;
import okhttp3.JavaNetCookieJar;
import okhttp3.OkHttpClient;

@ReactModule(name="FrescoModule")
public class FrescoModule extends ReactContextBaseJavaModule
  implements ModuleDataCleaner.Cleanable, LifecycleEventListener
{
  private static boolean sHasBeenInitialized = false;
  private final boolean mClearOnDestroy;

  @Nullable
  private ImagePipelineConfig mConfig;

  public FrescoModule(ReactApplicationContext paramReactApplicationContext)
  {
    this(paramReactApplicationContext, true, null);
  }

  public FrescoModule(ReactApplicationContext paramReactApplicationContext, boolean paramBoolean)
  {
    this(paramReactApplicationContext, paramBoolean, null);
  }

  public FrescoModule(ReactApplicationContext paramReactApplicationContext, boolean paramBoolean, @Nullable ImagePipelineConfig paramImagePipelineConfig)
  {
    super(paramReactApplicationContext);
    this.mClearOnDestroy = paramBoolean;
    this.mConfig = paramImagePipelineConfig;
  }

  private static ImagePipelineConfig getDefaultConfig(ReactContext paramReactContext)
  {
    return getDefaultConfigBuilder(paramReactContext).build();
  }

  public static ImagePipelineConfig.Builder getDefaultConfigBuilder(ReactContext paramReactContext)
  {
    HashSet localHashSet = new HashSet();
    localHashSet.add(new SystraceRequestListener());
    OkHttpClient localOkHttpClient = OkHttpClientProvider.createClient();
    ((CookieJarContainer)localOkHttpClient.cookieJar()).setCookieJar(new JavaNetCookieJar(new ForwardingCookieHandler(paramReactContext)));
    return OkHttpImagePipelineConfigFactory.newBuilder(paramReactContext.getApplicationContext(), localOkHttpClient).setNetworkFetcher(new ReactOkHttpNetworkFetcher(localOkHttpClient)).setDownsampleEnabled(false).setRequestListeners(localHashSet);
  }

  public static boolean hasBeenInitialized()
  {
    return sHasBeenInitialized;
  }

  public void clearSensitiveData()
  {
    Fresco.getImagePipeline().clearCaches();
  }

  public String getName()
  {
    return "FrescoModule";
  }

  public void initialize()
  {
    super.initialize();
    getReactApplicationContext().addLifecycleEventListener(this);
    if (!hasBeenInitialized())
    {
      SoLoaderShim.setHandler(new FrescoHandler(null));
      if (this.mConfig == null)
        this.mConfig = getDefaultConfig(getReactApplicationContext());
      Fresco.initialize(getReactApplicationContext().getApplicationContext(), this.mConfig);
      sHasBeenInitialized = true;
    }
    while (true)
    {
      this.mConfig = null;
      return;
      if (this.mConfig == null)
        continue;
      FLog.w("ReactNative", "Fresco has already been initialized with a different config. The new Fresco configuration will be ignored!");
    }
  }

  public void onHostDestroy()
  {
    if ((hasBeenInitialized()) && (this.mClearOnDestroy))
      Fresco.getImagePipeline().clearMemoryCaches();
  }

  public void onHostPause()
  {
  }

  public void onHostResume()
  {
  }

  private static class FrescoHandler
    implements SoLoaderShim.Handler
  {
    public void loadLibrary(String paramString)
    {
      SoLoader.loadLibrary(paramString);
    }
  }
}

/* Location:           C:\Users\c_jealom1\Documents\Scripts\Android\Fathom_com.brynk.fathom\Fathom_com.brynk.fathom-dex2jar.jar
 * Qualified Name:     com.facebook.react.modules.fresco.FrescoModule
 * JD-Core Version:    0.6.0
 */